package com.android.server.inputmethod;

import android.content.pm.PackageManagerInternal;
import android.os.LocaleList;
import android.text.TextUtils;
import android.util.IntArray;
import android.util.Pair;
import android.util.Printer;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodSubtype;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes2.dex */
final class InputMethodSettings {
    public static final boolean DEBUG = false;
    private static final char INPUT_METHOD_SEPARATOR = ':';
    private static final char INPUT_METHOD_SUBTYPE_SEPARATOR = ';';
    static final int INVALID_SUBTYPE_HASHCODE = -1;
    private static final String INVALID_SUBTYPE_HASHCODE_STR = null;
    private static final String TAG = "InputMethodSettings";
    private final List<InputMethodInfo> mMethodList;
    private final InputMethodMap mMethodMap;
    private final int mUserId;

    static {
        INVALID_SUBTYPE_HASHCODE_STR = String.valueOf(-1);
    }

    private static void buildEnabledInputMethodsSettingString(StringBuilder builder, Pair<String, ArrayList<String>> ime) {
        builder.append((String) ime.first);
        int i = 0;
    L4:
        if (i >= ((ArrayList) ime.second).size()) goto L7;
        String subtypeHashCode = (String) ((ArrayList) ime.second).get(i);
        builder.append(INPUT_METHOD_SUBTYPE_SEPARATOR);
        builder.append(subtypeHashCode);
        i = i + 1;
        goto L4
    }

    static InputMethodSettings createEmptyMap(int userId) {
        return new InputMethodSettings(InputMethodMap.emptyMap(), userId);
    }

    static InputMethodSettings create(InputMethodMap methodMap, int userId) {
        return new InputMethodSettings(methodMap, userId);
    }

    private InputMethodSettings(InputMethodMap methodMap, int userId) {
        this.mMethodMap = methodMap;
        this.mMethodList = methodMap.values();
        this.mUserId = userId;
    }

    InputMethodMap getMethodMap() {
        return this.mMethodMap;
    }

    List<InputMethodInfo> getMethodList() {
        return this.mMethodList;
    }

    private void putString(String key, String str) {
        SecureSettingsWrapper.putString(key, str, this.mUserId);
    }

    private String getString(String key, String defaultValue) {
        return SecureSettingsWrapper.getString(key, defaultValue, this.mUserId);
    }

    private void putInt(String key, int value) {
        SecureSettingsWrapper.putInt(key, value, this.mUserId);
    }

    private int getInt(String key, int defaultValue) {
        return SecureSettingsWrapper.getInt(key, defaultValue, this.mUserId);
    }

    ArrayList<InputMethodInfo> getEnabledInputMethodList() {
        return getEnabledInputMethodListWithFilter(null);
    }

    ArrayList<InputMethodInfo> getEnabledInputMethodListWithFilter(Predicate<InputMethodInfo> matchingCondition) {
        return createEnabledInputMethodList(getEnabledInputMethodsAndSubtypeList(), matchingCondition);
    }

    List<InputMethodSubtype> getEnabledInputMethodSubtypeList(InputMethodInfo imi, boolean allowsImplicitlyEnabledSubtypes) {
        List<InputMethodSubtype> enabledSubtypes = getEnabledInputMethodSubtypeList(imi);
        if (allowsImplicitlyEnabledSubtypes == false) goto L8;
        if (enabledSubtypes.isEmpty() == false) goto L8;
        enabledSubtypes = SubtypeUtils.getImplicitlyApplicableSubtypes(SystemLocaleWrapper.get(this.mUserId), imi);
    L8:
        return InputMethodSubtype.sort(imi, enabledSubtypes);
    }

    List<InputMethodSubtype> getEnabledInputMethodSubtypeList(InputMethodInfo imi) {
        List<Pair<String, ArrayList<String>>> imsList = getEnabledInputMethodsAndSubtypeList();
        ArrayList<InputMethodSubtype> enabledSubtypes = new ArrayList();
        if (imi == null) goto L23;
        int i = 0;
    L6:
        if (i >= imsList.size()) goto L23;
        Pair<String, ArrayList<String>> imsPair = imsList.get(i);
        InputMethodInfo info = this.mMethodMap.get((String) imsPair.first);
        if (info == null) goto L22;
        if (info.getId().equals(imi.getId()) == false) goto L22;
        int subtypeCount = info.getSubtypeCount();
        int j = 0;
    L12:
        if (j >= subtypeCount) goto L23;
        InputMethodSubtype ims = info.getSubtypeAt(j);
        int k = 0;
    L15:
        if (k >= ((ArrayList) imsPair.second).size()) goto L20;
        String s = (String) ((ArrayList) imsPair.second).get(k);
        if (String.valueOf(ims.hashCode()).equals(s) == false) goto L19;
        enabledSubtypes.add(ims);
    L19:
        k = k + 1;
        goto L15
    L20:
        j = j + 1;
    L22:
        i = i + 1;
    L23:
        return enabledSubtypes;
    }

    List<Pair<String, ArrayList<String>>> getEnabledInputMethodsAndSubtypeList() {
        String enabledInputMethodsStr = getEnabledInputMethodsStr();
        TextUtils.SimpleStringSplitter inputMethodSplitter = new TextUtils.SimpleStringSplitter(INPUT_METHOD_SEPARATOR);
        TextUtils.SimpleStringSplitter subtypeSplitter = new TextUtils.SimpleStringSplitter(INPUT_METHOD_SUBTYPE_SEPARATOR);
        ArrayList<Pair<String, ArrayList<String>>> imsList = new ArrayList();
        if (TextUtils.isEmpty(enabledInputMethodsStr) == false) goto L5;
        return imsList;
    L5:
        inputMethodSplitter.setString(enabledInputMethodsStr);
    L7:
        if (inputMethodSplitter.hasNext() == false) goto L16;
        String nextImsStr = inputMethodSplitter.next();
        subtypeSplitter.setString(nextImsStr);
        if (subtypeSplitter.hasNext() == false) goto L7;
        ArrayList<String> subtypeHashes = new ArrayList();
        String imeId = subtypeSplitter.next();
    L12:
        if (subtypeSplitter.hasNext() == false) goto L14;
        subtypeHashes.add(subtypeSplitter.next());
        goto L12
    L14:
        imsList.add(new Pair(imeId, subtypeHashes));
        goto L7
    L16:
        return imsList;
    }

    boolean buildAndPutEnabledInputMethodsStrRemovingId(StringBuilder builder, List<Pair<String, ArrayList<String>>> imsList, String id) {
        boolean isRemoved = false;
        boolean needsAppendSeparator = false;
        int i = 0;
    L4:
        if (i >= imsList.size()) goto L14;
        Pair<String, ArrayList<String>> ims = imsList.get(i);
        String curId = (String) ims.first;
        if (curId.equals(id) == false) goto L8;
        isRemoved = true;
    L12:
        i = i + 1;
        goto L4
    L8:
        if (needsAppendSeparator == false) goto L10;
        builder.append(INPUT_METHOD_SEPARATOR);
    L11:
        buildEnabledInputMethodsSettingString(builder, ims);
        goto L12
    L10:
        needsAppendSeparator = true;
        goto L11
    L14:
        if (isRemoved == false) goto L16;
        putEnabledInputMethodsStr(builder.toString());
    L16:
        return isRemoved;
    }

    private ArrayList<InputMethodInfo> createEnabledInputMethodList(List<Pair<String, ArrayList<String>>> imsList, Predicate<InputMethodInfo> matchingCondition) {
        ArrayList<InputMethodInfo> res = new ArrayList();
        int i = 0;
    L4:
        if (i >= imsList.size()) goto L15;
        Pair<String, ArrayList<String>> ims = imsList.get(i);
        InputMethodInfo info = this.mMethodMap.get((String) ims.first);
        if (info == null) goto L13;
        if (info.isVrOnly() == true) goto L13;
        if (matchingCondition != null) goto L11;
    L12:
        res.add(info);
        goto L13
    L11:
        if (matchingCondition.test(info) == true) goto L12;
    L13:
        i = i + 1;
        goto L4
    L15:
        return res;
    }

    void putEnabledInputMethodsStr(String str) {
        if (TextUtils.isEmpty(str) == false) goto L5;
        putString("enabled_input_methods", null);
        return;
    L5:
        putString("enabled_input_methods", str);
    }

    String getEnabledInputMethodsStr() {
        return getString("enabled_input_methods", "");
    }

    private void saveSubtypeHistory(List<Pair<String, String>> savedImes, String newImeId, String newSubtypeHashCodeStr) {
        StringBuilder builder = new StringBuilder();
        boolean isImeAdded = false;
        if (TextUtils.isEmpty(newImeId) == false) goto L5;
    L7:
        int i = 0;
    L9:
        if (i >= savedImes.size()) goto L17;
        Pair<String, String> ime = savedImes.get(i);
        String imeId = (String) ime.first;
        String subtypeHashCodeStr = (String) ime.second;
        if (TextUtils.isEmpty(subtypeHashCodeStr) == false) goto L13;
        subtypeHashCodeStr = INVALID_SUBTYPE_HASHCODE_STR;
    L13:
        if (isImeAdded == false) goto L15;
        builder.append(INPUT_METHOD_SEPARATOR);
    L16:
        builder.append(imeId);
        builder.append(INPUT_METHOD_SUBTYPE_SEPARATOR);
        builder.append(subtypeHashCodeStr);
        i = i + 1;
        goto L9
    L15:
        isImeAdded = true;
        goto L16
    L17:
        putSubtypeHistoryStr(builder.toString());
        return;
    L5:
        if (TextUtils.isEmpty(newSubtypeHashCodeStr) == true) goto L7;
        builder.append(newImeId);
        builder.append(INPUT_METHOD_SUBTYPE_SEPARATOR);
        builder.append(newSubtypeHashCodeStr);
        isImeAdded = true;
        goto L7
    }

    private void addSubtypeToHistory(String imeId, String subtypeHashCodeStr) {
        List<Pair<String, String>> subtypeHistory = loadInputMethodAndSubtypeHistory();
        int i = 0;
    L4:
        if (i >= subtypeHistory.size()) goto L9;
        Pair<String, String> ime = subtypeHistory.get(i);
        if (((String) ime.first).equals(imeId) == true) goto L7;
        i = i + 1;
        goto L4
    L7:
        subtypeHistory.remove(ime);
    L9:
        saveSubtypeHistory(subtypeHistory, imeId, subtypeHashCodeStr);
    }

    private void putSubtypeHistoryStr(String str) {
        if (TextUtils.isEmpty(str) == false) goto L5;
        putString("input_methods_subtype_history", null);
        return;
    L5:
        putString("input_methods_subtype_history", str);
    }

    Pair<String, String> getLastInputMethodAndSubtype() {
        return getLastSubtypeForInputMethodInternal(null);
    }

    InputMethodSubtype getLastInputMethodSubtype() {
        Pair<String, String> lastIme = getLastInputMethodAndSubtype();
        if (lastIme != null) goto L5;
    L24:
        return null;
    L5:
        if (TextUtils.isEmpty((CharSequence) lastIme.first) == true) goto L24;
        if (TextUtils.isEmpty((CharSequence) lastIme.second) == true) goto L24;
        InputMethodInfo lastImi = this.mMethodMap.get((String) lastIme.first);
        if (lastImi != null) goto L25;
        return null;
    L25:
        int lastSubtypeHash = Integer.parseInt((String) lastIme.second);     // Catch: NumberFormatException -> L19
        int lastSubtypeIndex = SubtypeUtils.getSubtypeIndexFromHashCode(lastImi, lastSubtypeHash);     // Catch: NumberFormatException -> L19
        if (lastSubtypeIndex < 0) goto L21;
        if (lastSubtypeIndex >= lastImi.getSubtypeCount()) goto L21;
        return lastImi.getSubtypeAt(lastSubtypeIndex);
    L21:
        return null;
    L23:
        return null;
    }

    String getLastSubtypeForInputMethod(String imeId) {
        Pair<String, String> ime = getLastSubtypeForInputMethodInternal(imeId);
        if (ime != null) goto L5;
        return null;
    L5:
        return (String) ime.second;
    }

    private Pair<String, String> getLastSubtypeForInputMethodInternal(String imeId) {
        List<Pair<String, ArrayList<String>>> enabledImes = getEnabledInputMethodsAndSubtypeList();
        List<Pair<String, String>> subtypeHistory = loadInputMethodAndSubtypeHistory();
        int i = 0;
    L4:
        if (i >= subtypeHistory.size()) goto L14;
        Pair<String, String> imeAndSubtype = subtypeHistory.get(i);
        String imeInTheHistory = (String) imeAndSubtype.first;
        if (TextUtils.isEmpty(imeId) == false) goto L8;
    L9:
        String subtypeInTheHistory = (String) imeAndSubtype.second;
        String subtypeHashCode = getEnabledSubtypeHashCodeForInputMethodAndSubtype(enabledImes, imeInTheHistory, subtypeInTheHistory);
        if (TextUtils.isEmpty(subtypeHashCode) == true) goto L13;
        return new Pair(imeInTheHistory, subtypeHashCode);
    L13:
        i = i + 1;
        goto L4
    L8:
        if (imeInTheHistory.equals(imeId) == false) goto L13;
    L14:
        return null;
    }

    private String getEnabledSubtypeHashCodeForInputMethodAndSubtype(List<Pair<String, ArrayList<String>>> enabledImes, String imeId, String subtypeHashCode) {
        LocaleList localeList = SystemLocaleWrapper.get(this.mUserId);
        int i = 0;
    L4:
        if (i >= enabledImes.size()) goto L36;
        Pair<String, ArrayList<String>> enabledIme = enabledImes.get(i);
        if (((String) enabledIme.first).equals(imeId) == true) goto L7;
        i = i + 1;
        goto L4
    L7:
        ArrayList<String> explicitlyEnabledSubtypes = (ArrayList) enabledIme.second;
        InputMethodInfo imi = this.mMethodMap.get(imeId);
        if (explicitlyEnabledSubtypes.isEmpty() == false) goto L19;
        if (imi == null) goto L34;
        if (imi.getSubtypeCount() <= 0) goto L34;
        List<InputMethodSubtype> implicitlyEnabledSubtypes = SubtypeUtils.getImplicitlyApplicableSubtypes(localeList, imi);
        int numSubtypes = implicitlyEnabledSubtypes.size();
        int j = 0;
    L13:
        if (j >= numSubtypes) goto L34;
        InputMethodSubtype st = implicitlyEnabledSubtypes.get(j);
        if (String.valueOf(st.hashCode()).equals(subtypeHashCode) == true) goto L16;
        j = j + 1;
        goto L13
    L16:
        return subtypeHashCode;
    L34:
        return INVALID_SUBTYPE_HASHCODE_STR;
    L19:
        int j2 = 0;
    L21:
        if (j2 >= explicitlyEnabledSubtypes.size()) goto L34;
        String s = explicitlyEnabledSubtypes.get(j2);
        if (s.equals(subtypeHashCode) == true) goto L38;
        j2 = j2 + 1;
        goto L21
    L38:
        int hashCode = Integer.parseInt(subtypeHashCode);     // Catch: NumberFormatException -> L29
        if (SubtypeUtils.isValidSubtypeHashCode(imi, hashCode) == false) goto L27;
        return s;
    L27:
        return INVALID_SUBTYPE_HASHCODE_STR;
    L31:
        return INVALID_SUBTYPE_HASHCODE_STR;
    L36:
        return null;
    }

    private List<Pair<String, String>> loadInputMethodAndSubtypeHistory() {
        ArrayList<Pair<String, String>> imsList = new ArrayList();
        String subtypeHistoryStr = getSubtypeHistoryStr();
        if (TextUtils.isEmpty(subtypeHistoryStr) == false) goto L5;
        return imsList;
    L5:
        TextUtils.SimpleStringSplitter inputMethodSplitter = new TextUtils.SimpleStringSplitter(INPUT_METHOD_SEPARATOR);
        TextUtils.SimpleStringSplitter subtypeSplitter = new TextUtils.SimpleStringSplitter(INPUT_METHOD_SUBTYPE_SEPARATOR);
        inputMethodSplitter.setString(subtypeHistoryStr);
    L7:
        if (inputMethodSplitter.hasNext() == false) goto L15;
        String nextImsStr = inputMethodSplitter.next();
        subtypeSplitter.setString(nextImsStr);
        if (subtypeSplitter.hasNext() == false) goto L7;
        String subtypeHashCodeStr = INVALID_SUBTYPE_HASHCODE_STR;
        String imeId = subtypeSplitter.next();
        if (subtypeSplitter.hasNext() == false) goto L13;
        subtypeHashCodeStr = subtypeSplitter.next();
    L13:
        imsList.add(new Pair(imeId, subtypeHashCodeStr));
        goto L7
    L15:
        return imsList;
    }

    private String getSubtypeHistoryStr() {
        String history = getString("input_methods_subtype_history", "");
        return history;
    }

    void putSelectedInputMethod(String imeId) {
        putString("default_input_method", imeId);
    }

    void putSelectedSubtype(int subtypeHashCode) {
        putInt("selected_input_method_subtype", subtypeHashCode);
    }

    String getSelectedInputMethod() {
        String imi = getString("default_input_method", null);
        return imi;
    }

    String getSelectedDefaultDeviceInputMethod() {
        String imi = getString("default_device_input_method", null);
        return imi;
    }

    void putSelectedDefaultDeviceInputMethod(String imeId) {
        putString("default_device_input_method", imeId);
    }

    void putDefaultVoiceInputMethod(String imeId) {
        putString("default_voice_input_method", imeId);
    }

    String getDefaultVoiceInputMethod() {
        String imi = getString("default_voice_input_method", null);
        return imi;
    }

    private int getSelectedInputMethodSubtypeHashCode() {
        return getInt("selected_input_method_subtype", -1);
    }

    public int getUserId() {
        return this.mUserId;
    }

    int getSelectedInputMethodSubtypeIndex(String selectedImiId) {
        InputMethodInfo imi = this.mMethodMap.get(selectedImiId);
        if (imi != null) goto L6;
        return -1;
    L6:
        int subtypeHashCode = getSelectedInputMethodSubtypeHashCode();
        return SubtypeUtils.getSubtypeIndexFromHashCode(imi, subtypeHashCode);
    }

    void saveCurrentInputMethodAndSubtypeToHistory(String curMethodId, InputMethodSubtype currentSubtype) {
        String subtypeHashCodeStr = INVALID_SUBTYPE_HASHCODE_STR;
        if (currentSubtype == null) goto L6;
        subtypeHashCodeStr = String.valueOf(currentSubtype.hashCode());
    L6:
        if (InputMethodUtils.canAddToLastInputMethod(currentSubtype) == false) goto L9;
        addSubtypeToHistory(curMethodId, subtypeHashCodeStr);
        return;
    }

    AdditionalSubtypeMap getNewAdditionalSubtypeMap(String imeId, ArrayList<InputMethodSubtype> subtypes, AdditionalSubtypeMap additionalSubtypeMap, PackageManagerInternal packageManagerInternal, int callingUid) {
        InputMethodInfo imi = this.mMethodMap.get(imeId);
        if (imi != null) goto L6;
        return additionalSubtypeMap;
    L6:
        if (InputMethodUtils.checkIfPackageBelongsToUid(packageManagerInternal, callingUid, imi.getPackageName()) == true) goto L9;
        return additionalSubtypeMap;
    L9:
        if (subtypes.isEmpty() == false) goto L11;
        AdditionalSubtypeMap newMap = additionalSubtypeMap.cloneWithRemoveOrSelf(imi.getId());
        return newMap;
    L11:
        AdditionalSubtypeMap newMap2 = additionalSubtypeMap.cloneWithPut(imi.getId(), subtypes);
        return newMap2;
    }

    boolean setEnabledInputMethodSubtypes(String imeId, int[] subtypeHashCodes) {
        InputMethodInfo imi = this.mMethodMap.get(imeId);
        if (imi != null) goto L5;
        return false;
    L5:
        IntArray validSubtypeHashCodes = new IntArray(subtypeHashCodes.length);
        int r3 = subtypeHashCodes.length;
        int r4 = 0;
    L6:
        if (r4 >= r3) goto L18;
        int subtypeHashCode = subtypeHashCodes[r4];
        if (subtypeHashCode == (-1)) goto L17;
        if (SubtypeUtils.isValidSubtypeHashCode(imi, subtypeHashCode) == false) goto L17;
        if (validSubtypeHashCodes.indexOf(subtypeHashCode) >= 0) goto L17;
        validSubtypeHashCodes.add(subtypeHashCode);
    L17:
        r4 = r4 + 1;
        goto L6
    L18:
        String originalEnabledImesString = getEnabledInputMethodsStr();
        String updatedEnabledImesString = updateEnabledImeString(originalEnabledImesString, imi.getId(), validSubtypeHashCodes);
        if (TextUtils.equals(originalEnabledImesString, updatedEnabledImesString) == false) goto L21;
        return false;
    L21:
        putEnabledInputMethodsStr(updatedEnabledImesString);
        return true;
    }

    static String updateEnabledImeString(String enabledImesString, String imeId, IntArray enabledSubtypeHashCodes) {
        TextUtils.SimpleStringSplitter imeSplitter = new TextUtils.SimpleStringSplitter(INPUT_METHOD_SEPARATOR);
        TextUtils.SimpleStringSplitter imeSubtypeSplitter = new TextUtils.SimpleStringSplitter(INPUT_METHOD_SUBTYPE_SEPARATOR);
        StringBuilder sb = new StringBuilder();
        imeSplitter.setString(enabledImesString);
        boolean needsImeSeparator = false;
    L4:
        if (imeSplitter.hasNext() == false) goto L20;
        String nextImsStr = imeSplitter.next();
        imeSubtypeSplitter.setString(nextImsStr);
        if (imeSubtypeSplitter.hasNext() == false) goto L4;
        if (needsImeSeparator == false) goto L10;
        sb.append(INPUT_METHOD_SEPARATOR);
    L10:
        if (TextUtils.equals(imeId, imeSubtypeSplitter.next()) == false) goto L16;
        sb.append(imeId);
        int i = 0;
    L13:
        if (i >= enabledSubtypeHashCodes.size()) goto L17;
        sb.append(INPUT_METHOD_SUBTYPE_SEPARATOR);
        sb.append(enabledSubtypeHashCodes.get(i));
        i = i + 1;
    L17:
        needsImeSeparator = true;
        goto L4
    L16:
        sb.append(nextImsStr);
        goto L17
    L20:
        return sb.toString();
    }

    void dump(Printer pw, String prefix) {
        pw.println(prefix + "mUserId=" + this.mUserId);
    }
}

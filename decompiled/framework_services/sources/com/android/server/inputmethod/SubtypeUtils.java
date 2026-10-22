package com.android.server.inputmethod;

import android.os.LocaleList;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodSubtype;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
final class SubtypeUtils {
    public static final boolean DEBUG = false;
    static final String SUBTYPE_MODE_ANY = null;
    static final String SUBTYPE_MODE_KEYBOARD = "keyboard";
    private static final String TAG = "SubtypeUtils";
    private static final String TAG_ENABLED_WHEN_DEFAULT_IS_NOT_ASCII_CAPABLE = "EnabledWhenDefaultIsNotAsciiCapable";
    private static final Object sCacheLock = null;
    private static InputMethodInfo sCachedInputMethodInfo;
    private static ArrayList<InputMethodSubtype> sCachedResult;
    private static LocaleList sCachedSystemLocales;
    private static final LocaleUtils.LocaleExtractor<InputMethodSubtype> sSubtypeToLocale = null;

    public static /* synthetic */ Locale $r8$lambda$N5Ol3_HMUmz80oOVs2S2bVFGXzM(InputMethodSubtype r0) {
        return lambda$static$0(r0);
    }

    SubtypeUtils() {
    }

    static {
        SUBTYPE_MODE_ANY = null;
        sCacheLock = new Object();
        sSubtypeToLocale = new SubtypeUtils$$ExternalSyntheticLambda0();
    }

    static boolean containsSubtypeOf(InputMethodInfo imi, Locale locale, boolean checkCountry, String mode) {
        if (locale != null) goto L5;
        return false;
    L5:
        int numSubtypes = imi.getSubtypeCount();
        int i = 0;
    L6:
        if (i >= numSubtypes) goto L29;
        InputMethodSubtype subtype = imi.getSubtypeAt(i);
        if (checkCountry == false) goto L18;
        Locale subtypeLocale = subtype.getLocaleObject();
        if (subtypeLocale == null) goto L25;
        if (TextUtils.equals(subtypeLocale.getLanguage(), locale.getLanguage()) == false) goto L25;
        if (TextUtils.equals(subtypeLocale.getCountry(), locale.getCountry()) == false) goto L25;
    L21:
        if (TextUtils.isEmpty(mode) == true) goto L26;
        if (mode.equalsIgnoreCase(subtype.getMode()) == false) goto L25;
        return true;
    L26:
        return true;
    L25:
        i = i + 1;
        goto L6
    L18:
        if (TextUtils.equals(new Locale(LocaleUtils.getLanguageFromLocaleString(subtype.getLocale())).getLanguage(), locale.getLanguage()) == true) goto L21;
    L29:
        return false;
    }

    static ArrayList<InputMethodSubtype> getSubtypes(InputMethodInfo imi) {
        ArrayList<InputMethodSubtype> subtypes = new ArrayList();
        int subtypeCount = imi.getSubtypeCount();
        int i = 0;
    L3:
        if (i >= subtypeCount) goto L6;
        subtypes.add(imi.getSubtypeAt(i));
        i = i + 1;
        goto L3
    L6:
        return subtypes;
    }

    static boolean isValidSubtypeHashCode(InputMethodInfo imi, int subtypeHashCode) {
        if (getSubtypeIndexFromHashCode(imi, subtypeHashCode) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    static int getSubtypeIndexFromHashCode(InputMethodInfo imi, int subtypeHashCode) {
        if (imi == null) goto L9;
        int subtypeCount = imi.getSubtypeCount();
        int i = 0;
    L4:
        if (i >= subtypeCount) goto L13;
        InputMethodSubtype ims = imi.getSubtypeAt(i);
        if (subtypeHashCode == ims.hashCode()) goto L7;
        i = i + 1;
        goto L4
    L7:
        return i;
    L13:
        return -1;
    L9:
        return -1;
    }

    private static /* synthetic */ Locale lambda$static$0(InputMethodSubtype source) {
        if (source != null) goto L6;
        return null;
    L6:
        return source.getLocaleObject();
    }

    static ArrayList<InputMethodSubtype> getImplicitlyApplicableSubtypes(LocaleList systemLocales, InputMethodInfo imi) {
        Object r0 = sCacheLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (systemLocales.equals(sCachedSystemLocales) == true) goto L7;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L11
        ArrayList<InputMethodSubtype> result = getImplicitlyApplicableSubtypesImpl(systemLocales, imi);
        Object r2 = sCacheLock;
        monitor-enter(r2);
        sCachedSystemLocales = systemLocales;     // Catch: Throwable -> L19
        sCachedInputMethodInfo = imi;     // Catch: Throwable -> L19
        sCachedResult = new ArrayList(result);     // Catch: Throwable -> L19
        monitor-exit(r2);     // Catch: Throwable -> L19
        return result;
    L19:
        th = move-exception;
        throw th;
    L7:
        if (sCachedInputMethodInfo != imi) goto L13;
        ArrayList<InputMethodSubtype> r1 = new ArrayList(sCachedResult);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r1;
    }

    private static ArrayList<InputMethodSubtype> getImplicitlyApplicableSubtypesImpl(LocaleList systemLocales, InputMethodInfo imi) {
        List<InputMethodSubtype> subtypes = getSubtypes(imi);
        String systemLocale = systemLocales.get(0).toString();
        if (TextUtils.isEmpty(systemLocale) == true) goto L5;
        int numSubtypes = subtypes.size();
        ArrayMap<String, InputMethodSubtype> applicableModeAndSubtypesMap = new ArrayMap();
        int i = 0;
    L7:
        if (i >= numSubtypes) goto L14;
        InputMethodSubtype subtype = subtypes.get(i);
        if (subtype.overridesImplicitlyEnabledSubtype() == false) goto L13;
        String mode = subtype.getMode();
        if (applicableModeAndSubtypesMap.containsKey(mode) == true) goto L13;
        applicableModeAndSubtypesMap.put(mode, subtype);
    L13:
        i = i + 1;
        goto L7
    L14:
        int i2 = applicableModeAndSubtypesMap.size();
        if (i2 > 0) goto L17;
        ArrayMap<String, ArrayList<InputMethodSubtype>> nonKeyboardSubtypesMap = new ArrayMap();
        ArrayList<InputMethodSubtype> keyboardSubtypes = new ArrayList();
        int i3 = 0;
    L20:
        if (i3 >= numSubtypes) goto L29;
        InputMethodSubtype subtype2 = subtypes.get(i3);
        String mode2 = subtype2.getMode();
        if (SUBTYPE_MODE_KEYBOARD.equals(mode2) == false) goto L25;
        keyboardSubtypes.add(subtype2);
    L28:
        i3 = i3 + 1;
        goto L20
    L25:
        if (nonKeyboardSubtypesMap.containsKey(mode2) == true) goto L27;
        nonKeyboardSubtypesMap.put(mode2, new ArrayList());
    L27:
        nonKeyboardSubtypesMap.get(mode2).add(subtype2);
        goto L28
    L29:
        ArrayList<InputMethodSubtype> applicableSubtypes = new ArrayList();
        LocaleUtils.filterByLanguage(keyboardSubtypes, sSubtypeToLocale, systemLocales, applicableSubtypes);
        if (applicableSubtypes.isEmpty() == true) goto L46;
        boolean hasAsciiCapableKeyboard = false;
        int numApplicationSubtypes = applicableSubtypes.size();
        int i4 = 0;
    L32:
        if (i4 >= numApplicationSubtypes) goto L37;
        if (applicableSubtypes.get(i4).isAsciiCapable() == true) goto L35;
        i4 = i4 + 1;
        goto L32
    L35:
        hasAsciiCapableKeyboard = true;
    L37:
        if (hasAsciiCapableKeyboard == true) goto L46;
        int numKeyboardSubtypes = keyboardSubtypes.size();
        int i5 = 0;
    L39:
        if (i5 >= numKeyboardSubtypes) goto L46;
        InputMethodSubtype subtype3 = keyboardSubtypes.get(i5);
        if (SUBTYPE_MODE_KEYBOARD.equals(subtype3.getMode()) == false) goto L45;
        if (subtype3.containsExtraValueKey(TAG_ENABLED_WHEN_DEFAULT_IS_NOT_ASCII_CAPABLE) == false) goto L45;
        applicableSubtypes.add(subtype3);
    L45:
        i5 = i5 + 1;
    L46:
        boolean hasAsciiCapableKeyboard2 = applicableSubtypes.isEmpty();
        if (hasAsciiCapableKeyboard2 == false) goto L51;
        InputMethodSubtype lastResortKeyboardSubtype = findLastResortApplicableSubtype(subtypes, SUBTYPE_MODE_KEYBOARD, systemLocale, true);
        if (lastResortKeyboardSubtype == null) goto L51;
        applicableSubtypes.add(lastResortKeyboardSubtype);
    L51:
        Iterator<ArrayList<InputMethodSubtype>> r8 = nonKeyboardSubtypesMap.values().iterator();
    L53:
        if (r8.hasNext() == false) goto L55;
        ArrayList<InputMethodSubtype> subtypeList = r8.next();
        LocaleUtils.filterByLanguage(subtypeList, sSubtypeToLocale, systemLocales, applicableSubtypes);
        goto L53
    L55:
        return applicableSubtypes;
    L17:
        return new ArrayList(applicableModeAndSubtypesMap.values());
    L5:
        return new ArrayList();
    }

    static InputMethodSubtype findLastResortApplicableSubtype(List<InputMethodSubtype> subtypes, String mode, String locale, boolean canIgnoreLocaleAsLastResort) {
        if (subtypes != null) goto L4;
        return null;
    L4:
        if (subtypes.isEmpty() == true) goto L34;
        String language = LocaleUtils.getLanguageFromLocaleString(locale);
        boolean partialMatchFound = false;
        InputMethodSubtype applicableSubtype = null;
        InputMethodSubtype firstMatchedModeSubtype = null;
        int numSubtypes = subtypes.size();
        int i = 0;
    L7:
        if (i >= numSubtypes) goto L22;
        InputMethodSubtype subtype = subtypes.get(i);
        String subtypeLocale = subtype.getLocale();
        String subtypeLanguage = LocaleUtils.getLanguageFromLocaleString(subtypeLocale);
        if (mode != null) goto L11;
    L12:
        if (firstMatchedModeSubtype != null) goto L15;
        firstMatchedModeSubtype = subtype;
    L15:
        if (locale.equals(subtypeLocale) == true) goto L16;
        if (partialMatchFound == true) goto L21;
        if (language.equals(subtypeLanguage) == false) goto L21;
        applicableSubtype = subtype;
        partialMatchFound = true;
    L21:
        i = i + 1;
        goto L7
    L16:
        applicableSubtype = subtype;
        goto L22
    L11:
        if (subtypes.get(i).getMode().equalsIgnoreCase(mode) == false) goto L21;
    L22:
        if (applicableSubtype != null) goto L25;
        if (canIgnoreLocaleAsLastResort == false) goto L25;
        return firstMatchedModeSubtype;
    L25:
        return applicableSubtype;
    L34:
        return null;
    }

    static InputMethodSubtype getCurrentInputMethodSubtype(InputMethodInfo imi, InputMethodSettings settings, InputMethodSubtype currentSubtype) {
        int userId = settings.getUserId();
        int selectedSubtypeHashCode = SecureSettingsWrapper.getInt("selected_input_method_subtype", -1, userId);
        if (selectedSubtypeHashCode == (-1)) goto L8;
        if (currentSubtype == null) goto L8;
        if (isValidSubtypeHashCode(imi, currentSubtype.hashCode()) == false) goto L8;
        return currentSubtype;
    L8:
        int subtypeIndex = settings.getSelectedInputMethodSubtypeIndex(imi.getId());
        if (subtypeIndex != (-1)) goto L11;
        List<InputMethodSubtype> subtypes = settings.getEnabledInputMethodSubtypeList(imi, true);
        if (subtypes.isEmpty() == false) goto L16;
        return currentSubtype;
    L16:
        if (subtypes.size() == 1) goto L18;
        String locale = SystemLocaleWrapper.get(userId).get(0).toString();
        InputMethodSubtype subtype = findLastResortApplicableSubtype(subtypes, SUBTYPE_MODE_KEYBOARD, locale, true);
        if (subtype == null) goto L23;
        return subtype;
    L23:
        return findLastResortApplicableSubtype(subtypes, null, locale, true);
    L18:
        return subtypes.get(0);
    L11:
        return imi.getSubtypeAt(subtypeIndex);
    }
}

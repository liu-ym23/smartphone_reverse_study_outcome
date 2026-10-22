package com.android.server.inputmethod;

import android.R;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.res.Resources;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.ArraySet;
import android.util.Slog;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodSubtype;
import android.view.textservice.SpellCheckerInfo;
import com.android.server.LocalServices;
import com.android.server.pm.UserManagerInternal;
import com.android.server.textservices.TextServicesManagerInternal;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
final class InputMethodUtils {
    public static final boolean DEBUG = false;
    static final char INPUT_METHOD_SEPARATOR = ':';
    static final char INPUT_METHOD_SUBTYPE_SEPARATOR = ';';
    static final int NOT_A_SUBTYPE_INDEX = -1;
    private static final String TAG = "InputMethodUtils";

    private InputMethodUtils() {
    }

    static boolean canAddToLastInputMethod(InputMethodSubtype subtype) {
        if (subtype != null) goto L6;
        return true;
    L6:
        return true ^ subtype.isAuxiliary();
    }

    static void setNonSelectedSystemImesDisabledUntilUsed(PackageManager packageManagerForUser, List<InputMethodInfo> enabledImis) {
        String[] systemImesDisabledUntilUsed = Resources.getSystem().getStringArray(R.array.config_displayWhiteBalanceHighLightAmbientBrightnesses);
        if (systemImesDisabledUntilUsed != null) goto L5;
        return;
    L5:
        if (systemImesDisabledUntilUsed.length == 0) goto L48;
        SpellCheckerInfo currentSpellChecker = TextServicesManagerInternal.get().getCurrentSpellCheckerForUser(packageManagerForUser.getUserId());
        int r2 = systemImesDisabledUntilUsed.length;
        int r4 = 0;
    L8:
        if (r4 >= r2) goto L35;
        String packageName = systemImesDisabledUntilUsed[r4];
        boolean enabledIme = false;
        int j = 0;
    L11:
        if (j >= enabledImis.size()) goto L16;
        InputMethodInfo imi = enabledImis.get(j);
        if (packageName.equals(imi.getPackageName()) == true) goto L14;
        j = j + 1;
        goto L11
    L14:
        enabledIme = true;
    L16:
        if (enabledIme == true) goto L34;
        if (currentSpellChecker == null) goto L37;
        if (packageName.equals(currentSpellChecker.getPackageName()) == true) goto L34;
    L37:
        ApplicationInfo ai = packageManagerForUser.getApplicationInfo(packageName, PackageManager.ApplicationInfoFlags.of(32768));     // Catch: PackageManager.NameNotFoundException -> L33
        if (ai == null) goto L34;
        boolean isSystemPackage = true;
        if ((ai.flags & 1) != 0) goto L30;
        isSystemPackage = false;
    L30:
        if (isSystemPackage == false) goto L34;
        setDisabledUntilUsed(packageManagerForUser, packageName);
    L34:
        r4 = r4 + 1;
        goto L8
    L35:
        return;
    }

    private static void setDisabledUntilUsed(PackageManager packageManagerForUser, String packageName) {
        int state = packageManagerForUser.getApplicationEnabledSetting(packageName);     // Catch: IllegalArgumentException -> L13
        if (state == 0) goto L16;
        if (state == 1) goto L16;
        return;
    L16:
        packageManagerForUser.setApplicationEnabledSetting(packageName, 4, 0);     // Catch: IllegalArgumentException -> L10
        return;
    L10:
        e = move-exception;
        Slog.w(TAG, "setApplicationEnabledSetting failed. packageName=" + packageName + " userId=" + packageManagerForUser.getUserId(), e);
        return;
    L13:
        e = move-exception;
        Slog.w(TAG, "getApplicationEnabledSetting failed. packageName=" + packageName + " userId=" + packageManagerForUser.getUserId(), e);
    }

    static boolean checkIfPackageBelongsToUid(PackageManagerInternal packageManagerInternal, int uid, String packageName) {
        return packageManagerInternal.isSameApp(packageName, 0, uid, UserHandle.getUserId(uid));
    }

    static boolean isSoftInputModeStateVisibleAllowed(int targetSdkVersion, int startInputFlags) {
        if (targetSdkVersion >= 28) goto L6;
        return true;
    L6:
        if ((startInputFlags & 1) != 0) goto L9;
        return false;
    L9:
        if ((startInputFlags & 2) != 0) goto L11;
        return false;
    L11:
        return true;
    }

    static int[] resolveUserId(int userIdToBeResolved, int currentUserId, PrintWriter warningWriter) {
        UserManagerInternal userManagerInternal = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        if (userIdToBeResolved != (-1)) goto L7;
        return userManagerInternal.getUserIds();
    L7:
        if (userIdToBeResolved != (-2)) goto L10;
        int sourceUserId = currentUserId;
    L19:
        return new int[]{sourceUserId};
    L10:
        if (userIdToBeResolved >= 0) goto L16;
        if (warningWriter == null) goto L14;
        warningWriter.print("Pseudo user ID ");
        warningWriter.print(userIdToBeResolved);
        warningWriter.println(" is not supported.");
    L14:
        return new int[0];
    L16:
        if (userManagerInternal.exists(userIdToBeResolved) == false) goto L20;
        sourceUserId = userIdToBeResolved;
        goto L19
    L20:
        if (warningWriter == null) goto L23;
        warningWriter.print("User #");
        warningWriter.print(userIdToBeResolved);
        warningWriter.println(" does not exit.");
    L23:
        return new int[0];
    }

    static List<String> getEnabledInputMethodIdsForFiltering(Context context, int userId) {
        String enabledInputMethodsStr = TextUtils.nullIfEmpty(SecureSettingsWrapper.getString("enabled_input_methods", null, userId));
        final ArrayList<String> result = new ArrayList();
        splitEnabledImeStr(enabledInputMethodsStr, new InputMethodUtils$$ExternalSyntheticLambda0(result));
        return result;
    }

    static void splitEnabledImeStr(String text, Consumer<String> consumer) {
        if (TextUtils.isEmpty(text) == false) goto L5;
        return;
    L5:
        TextUtils.SimpleStringSplitter inputMethodSplitter = new TextUtils.SimpleStringSplitter(INPUT_METHOD_SEPARATOR);
        TextUtils.SimpleStringSplitter subtypeSplitter = new TextUtils.SimpleStringSplitter(INPUT_METHOD_SUBTYPE_SEPARATOR);
        inputMethodSplitter.setString(text);
    L7:
        if (inputMethodSplitter.hasNext() == false) goto L12;
        String nextImsStr = inputMethodSplitter.next();
        subtypeSplitter.setString(nextImsStr);
        if (subtypeSplitter.hasNext() == false) goto L7;
        consumer.accept(subtypeSplitter.next());
        goto L7
    }

    static String concatEnabledImeIds(String existingEnabledImeId, String... imeIds) {
        final ArraySet<String> alreadyEnabledIds = new ArraySet();
        StringJoiner joiner = new StringJoiner(Character.toString(INPUT_METHOD_SEPARATOR));
        if (TextUtils.isEmpty(existingEnabledImeId) == true) goto L5;
        splitEnabledImeStr(existingEnabledImeId, new InputMethodUtils$$ExternalSyntheticLambda1(alreadyEnabledIds));
        joiner.add(existingEnabledImeId);
    L5:
        int r2 = imeIds.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L12;
        String id = imeIds[r3];
        if (alreadyEnabledIds.contains(id) == true) goto L10;
        joiner.add(id);
        alreadyEnabledIds.add(id);
    L10:
        r3 = r3 + 1;
        goto L6
    L12:
        return joiner.toString();
    }

    public static ComponentName convertIdToComponentName(String id) {
        return ComponentName.unflattenFromString(id);
    }
}

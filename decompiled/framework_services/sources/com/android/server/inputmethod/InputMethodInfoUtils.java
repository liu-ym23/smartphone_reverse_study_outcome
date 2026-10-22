package com.android.server.inputmethod;

import android.content.Context;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.Slog;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodSubtype;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
final class InputMethodInfoUtils {
    private static final Locale ENGLISH_LOCALE = null;
    private static final Locale[] SEARCH_ORDER_OF_FALLBACK_LOCALES = null;
    private static final String TAG = "InputMethodInfoUtils";

    private static final class InputMethodListBuilder {
        private final LinkedHashSet<InputMethodInfo> mInputMethodSet;

        /* JADX INFO: renamed from: -$$Nest$fgetmInputMethodSet, reason: not valid java name */
        static /* bridge */ /* synthetic */ LinkedHashSet m4695$$Nest$fgetmInputMethodSet(InputMethodListBuilder r0) {
            return r0.mInputMethodSet;
        }

        /* synthetic */ InputMethodListBuilder(InputMethodInfoUtilsIA r1) {
            this();
        }

        private InputMethodListBuilder() {
            this.mInputMethodSet = new LinkedHashSet();
        }

        InputMethodListBuilder fillImes(List<InputMethodInfo> imis, Context context, boolean checkDefaultAttribute, Locale locale, boolean checkCountry, String requiredSubtypeMode) {
            int i = 0;
        L4:
            if (i >= imis.size()) goto L10;
            InputMethodInfo imi = imis.get(i);
            Context context2 = context;
            boolean checkDefaultAttribute2 = checkDefaultAttribute;
            Locale locale2 = locale;
            boolean checkCountry2 = checkCountry;
            String requiredSubtypeMode2 = requiredSubtypeMode;
            if (InputMethodInfoUtils.m4694$$Nest$smisSystemImeThatHasSubtypeOf(imi, context2, checkDefaultAttribute2, locale2, checkCountry2, requiredSubtypeMode2) == false) goto L8;
            this.mInputMethodSet.add(imi);
        L8:
            i = i + 1;
            context = context2;
            checkDefaultAttribute = checkDefaultAttribute2;
            locale = locale2;
            checkCountry = checkCountry2;
            requiredSubtypeMode = requiredSubtypeMode2;
            goto L4
        L10:
            return this;
        }

        InputMethodListBuilder fillAuxiliaryImes(List<InputMethodInfo> imis, Context context) {
            Iterator<InputMethodInfo> r0 = this.mInputMethodSet.iterator();
        L4:
            if (r0.hasNext() == false) goto L9;
            if (r0.next().isAuxiliaryIme() == false) goto L4;
            return this;
        L9:
            boolean added = false;
            int i = 0;
        L11:
            if (i >= imis.size()) goto L17;
            InputMethodInfo imi = imis.get(i);
            if (InputMethodInfoUtils.m4693$$Nest$smisSystemAuxilialyImeThatHasAutomaticSubtype(imi, context, true) == false) goto L15;
            this.mInputMethodSet.add(imi);
            added = true;
        L15:
            i = i + 1;
            goto L11
        L17:
            if (added == false) goto L19;
            return this;
        L19:
            int i2 = 0;
        L21:
            if (i2 >= imis.size()) goto L27;
            InputMethodInfo imi2 = imis.get(i2);
            if (InputMethodInfoUtils.m4693$$Nest$smisSystemAuxilialyImeThatHasAutomaticSubtype(imi2, context, false) == false) goto L25;
            this.mInputMethodSet.add(imi2);
        L25:
            i2 = i2 + 1;
            goto L21
        L27:
            return this;
        }

        public boolean isEmpty() {
            return this.mInputMethodSet.isEmpty();
        }

        public ArrayList<InputMethodInfo> build() {
            return new ArrayList(this.mInputMethodSet);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$smisSystemAuxilialyImeThatHasAutomaticSubtype, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4693$$Nest$smisSystemAuxilialyImeThatHasAutomaticSubtype(InputMethodInfo r0, Context r1, boolean r2) {
        return isSystemAuxilialyImeThatHasAutomaticSubtype(r0, r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$smisSystemImeThatHasSubtypeOf, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4694$$Nest$smisSystemImeThatHasSubtypeOf(InputMethodInfo r0, Context r1, boolean r2, Locale r3, boolean r4, String r5) {
        return isSystemImeThatHasSubtypeOf(r0, r1, r2, r3, r4, r5);
    }

    InputMethodInfoUtils() {
    }

    static {
        SEARCH_ORDER_OF_FALLBACK_LOCALES = new Locale[]{Locale.ENGLISH, Locale.US, Locale.UK};
        ENGLISH_LOCALE = new Locale("en");
    }

    private static InputMethodListBuilder getMinimumKeyboardSetWithSystemLocale(List<InputMethodInfo> imis, Context context, Locale systemLocale, Locale fallbackLocale) {
        InputMethodListBuilder builder = new InputMethodListBuilder(null);
        builder.fillImes(imis, context, true, systemLocale, true, "keyboard");
        if (builder.isEmpty() == true) goto L5;
        return builder;
    L5:
        builder.fillImes(imis, context, true, systemLocale, false, "keyboard");
        if (builder.isEmpty() == true) goto L8;
        return builder;
    L8:
        builder.fillImes(imis, context, true, fallbackLocale, true, "keyboard");
        if (builder.isEmpty() == true) goto L11;
        return builder;
    L11:
        builder.fillImes(imis, context, true, fallbackLocale, false, "keyboard");
        if (builder.isEmpty() == true) goto L14;
        return builder;
    L14:
        builder.fillImes(imis, context, false, fallbackLocale, true, "keyboard");
        if (builder.isEmpty() == true) goto L17;
        return builder;
    L17:
        builder.fillImes(imis, context, false, fallbackLocale, false, "keyboard");
        if (builder.isEmpty() == true) goto L20;
        return builder;
    L20:
        InputMethodInfo fallbackIme = getMostApplicableDefaultIME(imis);
        if (fallbackIme == null) goto L24;
        InputMethodListBuilder.m4695$$Nest$fgetmInputMethodSet(builder).add(fallbackIme);
        return builder;
    L24:
        Slog.w(TAG, "No software keyboard is found. imis=" + Arrays.toString(imis.toArray()) + " systemLocale=" + systemLocale + " fallbackLocale=" + fallbackLocale);
        return builder;
    }

    static ArrayList<InputMethodInfo> getDefaultEnabledImes(Context context, List<InputMethodInfo> imis, boolean onlyMinimum) {
        Locale fallbackLocale = getFallbackLocaleForDefaultIme(imis, context);
        Locale systemLocale = LocaleUtils.getSystemLocaleFromContext(context);
        InputMethodListBuilder builder = getMinimumKeyboardSetWithSystemLocale(imis, context, systemLocale, fallbackLocale);
        if (onlyMinimum == true) goto L7;
        builder.fillImes(imis, context, true, systemLocale, true, SubtypeUtils.SUBTYPE_MODE_ANY).fillAuxiliaryImes(imis, context);
    L7:
        return builder.build();
    }

    static ArrayList<InputMethodInfo> getDefaultEnabledImes(Context context, List<InputMethodInfo> imis) {
        return getDefaultEnabledImes(context, imis, false);
    }

    static InputMethodInfo chooseSystemVoiceIme(InputMethodMap methodMap, String systemSpeechRecognizerPackageName, String currentDefaultVoiceImeId) {
        if (TextUtils.isEmpty(systemSpeechRecognizerPackageName) == false) goto L5;
        return null;
    L5:
        InputMethodInfo defaultVoiceIme = methodMap.get(currentDefaultVoiceImeId);
        if (defaultVoiceIme != null) goto L8;
    L12:
        InputMethodInfo firstMatchingIme = null;
        int methodCount = methodMap.size();
        int i = 0;
    L13:
        if (i >= methodCount) goto L26;
        InputMethodInfo imi = methodMap.valueAt(i);
        if (imi.isSystem() == false) goto L24;
        if (TextUtils.equals(imi.getPackageName(), systemSpeechRecognizerPackageName) == false) goto L24;
        if (firstMatchingIme != null) goto L21;
        firstMatchingIme = imi;
        goto L24
    L21:
        Slog.e(TAG, "At most one InputMethodService can be published in systemSpeechRecognizer: " + systemSpeechRecognizerPackageName + ". Ignoring all of them.");
        return null;
    L24:
        i = i + 1;
        goto L13
    L26:
        if (firstMatchingIme == null) goto L28;
        return firstMatchingIme;
    L28:
        return getMostApplicableDefaultIME(methodMap.values());
    L8:
        if (defaultVoiceIme.isSystem() == false) goto L12;
        if (defaultVoiceIme.getPackageName().equals(systemSpeechRecognizerPackageName) == false) goto L12;
        return defaultVoiceIme;
    }

    static InputMethodInfo getMostApplicableDefaultIME(List<InputMethodInfo> enabledImes) {
        if (enabledImes != null) goto L4;
        return null;
    L4:
        if (enabledImes.isEmpty() == true) goto L36;
        int i = enabledImes.size();
        int firstFoundSystemIme = -1;
    L8:
        if (i <= 0) goto L23;
        i = i - 1;
        InputMethodInfo imi = enabledImes.get(i);
        if (imi.isAuxiliaryIme() == true) goto L8;
        if (imi.isSystem() == true) goto L15;
    L17:
        if (firstFoundSystemIme >= 0) goto L8;
        if (imi.isSystem() == false) goto L8;
        firstFoundSystemIme = i;
        goto L8
    L15:
        if (SubtypeUtils.containsSubtypeOf(imi, ENGLISH_LOCALE, false, "keyboard") == false) goto L17;
        return imi;
    L23:
        return enabledImes.get(Math.max(firstFoundSystemIme, 0));
    L36:
        return null;
    }

    private static boolean isSystemAuxilialyImeThatHasAutomaticSubtype(InputMethodInfo imi, Context context, boolean checkDefaultAttribute) {
        if (imi.isSystem() == true) goto L5;
        return false;
    L5:
        if (checkDefaultAttribute == false) goto L10;
        if (imi.isDefault(context) == true) goto L10;
        return false;
    L10:
        if (imi.isAuxiliaryIme() == true) goto L12;
        return false;
    L12:
        int subtypeCount = imi.getSubtypeCount();
        int i = 0;
    L13:
        if (i >= subtypeCount) goto L20;
        InputMethodSubtype s = imi.getSubtypeAt(i);
        if (s.overridesImplicitlyEnabledSubtype() == true) goto L16;
        i = i + 1;
        goto L13
    L16:
        return true;
    L20:
        return false;
    }

    private static Locale getFallbackLocaleForDefaultIme(List<InputMethodInfo> imis, Context context) {
        Locale[] r1 = SEARCH_ORDER_OF_FALLBACK_LOCALES;
        int r2 = r1.length;
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L12;
        Locale fallbackLocale = r1[r4];
        int i = 0;
    L6:
        if (i >= imis.size()) goto L11;
        if (isSystemImeThatHasSubtypeOf(imis.get(i), context, true, fallbackLocale, true, "keyboard") == true) goto L9;
        i = i + 1;
        goto L6
    L9:
        return fallbackLocale;
    L11:
        r4 = r4 + 1;
        goto L3
    L12:
        Locale[] r5 = SEARCH_ORDER_OF_FALLBACK_LOCALES;
        int r6 = r5.length;
    L13:
        if (r3 >= r6) goto L22;
        Locale fallbackLocale2 = r5[r3];
        int i2 = 0;
    L16:
        if (i2 >= imis.size()) goto L21;
        if (isSystemImeThatHasSubtypeOf(imis.get(i2), context, false, fallbackLocale2, true, "keyboard") == true) goto L19;
        i2 = i2 + 1;
        goto L16
    L19:
        return fallbackLocale2;
    L21:
        r3 = r3 + 1;
        goto L13
    L22:
        Slog.w(TAG, "Found no fallback locale. imis=" + Arrays.toString(imis.toArray()));
        return null;
    }

    private static boolean isSystemImeThatHasSubtypeOf(InputMethodInfo imi, Context context, boolean checkDefaultAttribute, Locale requiredLocale, boolean checkCountry, String requiredSubtypeMode) {
        if (imi.isSystem() == true) goto L5;
        return false;
    L5:
        if (checkDefaultAttribute == false) goto L10;
        if (imi.isDefault(context) == true) goto L10;
        return false;
    L10:
        return SubtypeUtils.containsSubtypeOf(imi, requiredLocale, checkCountry, requiredSubtypeMode);
    }

    static byte[] marshal(InputMethodInfo imi) {
        Parcel parcel = null;
        parcel = Parcel.obtain();     // Catch: Throwable -> L6
        parcel.writeTypedObject(imi, 0);     // Catch: Throwable -> L6
        byte[] r1 = parcel.marshall();     // Catch: Throwable -> L6
        parcel.recycle();
        return r1;
    L6:
        th = move-exception;
        if (parcel == null) goto L9;
        parcel.recycle();
    L9:
        throw th;
    }
}

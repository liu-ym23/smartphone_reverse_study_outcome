package androidx.core.os;

import android.os.LocaleList;
import androidx.core.text.ICUCompat;
import com.android.contacts.common.SimContactsConstants;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class LocaleListCompat {
    private static final LocaleListCompat sEmptyLocaleList = null;
    private final LocaleListInterface mImpl;

    static class Api21Impl {
        private static final Locale[] PSEUDO_LOCALE = null;

        private Api21Impl() {
        }

        static boolean matchesLanguageAndScript(Locale r4, Locale r5) {
            if (r4.equals(r5) == false) goto L6;
            return true;
        L6:
            if (r4.getLanguage().equals(r5.getLanguage()) == true) goto L9;
            return false;
        L9:
            if (isPseudoLocale(r4) == false) goto L11;
        L24:
            return false;
        L11:
            if (isPseudoLocale(r5) == true) goto L24;
            String r0 = ICUCompat.maximizeAndGetScript(r4);
            if (r0.isEmpty() == false) goto L23;
            String r6 = r4.getCountry();
            if (r6.isEmpty() == false) goto L18;
            return true;
        L18:
            if (r6.equals(r5.getCountry()) == false) goto L21;
            return true;
        L21:
            return false;
        L23:
            return r0.equals(ICUCompat.maximizeAndGetScript(r5));
        }

        static {
            PSEUDO_LOCALE = new Locale[]{new Locale("en", "XA"), new Locale("ar", "XB")};
        }

        private static boolean isPseudoLocale(Locale r5) {
            Locale[] r0 = PSEUDO_LOCALE;
            int r1 = r0.length;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L9;
            if (r0[r3].equals(r5) == true) goto L6;
            r3 = r3 + 1;
            goto L3
        L6:
            return true;
        L9:
            return false;
        }

        static Locale forLanguageTag(String r0) {
            return Locale.forLanguageTag(r0);
        }
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static LocaleList createLocaleList(Locale... r1) {
            return new LocaleList(r1);
        }

        static LocaleList getAdjustedDefault() {
            return LocaleList.getAdjustedDefault();
        }

        static LocaleList getDefault() {
            return LocaleList.getDefault();
        }
    }

    static {
        sEmptyLocaleList = create(new Locale[0]);
    }

    private LocaleListCompat(LocaleListInterface r1) {
        this.mImpl = r1;
    }

    @Deprecated
    public static LocaleListCompat wrap(Object r0) {
        return wrap((LocaleList) r0);
    }

    public static LocaleListCompat wrap(LocaleList r2) {
        return new LocaleListCompat(new LocaleListPlatformWrapper(r2));
    }

    public Object unwrap() {
        return this.mImpl.getLocaleList();
    }

    public static LocaleListCompat create(Locale... r0) {
        return wrap(Api24Impl.createLocaleList(r0));
    }

    public Locale get(int r1) {
        return this.mImpl.get(r1);
    }

    public boolean isEmpty() {
        return this.mImpl.isEmpty();
    }

    public int size() {
        return this.mImpl.size();
    }

    public int indexOf(Locale r1) {
        return this.mImpl.indexOf(r1);
    }

    public String toLanguageTags() {
        return this.mImpl.toLanguageTags();
    }

    public Locale getFirstMatch(String[] r1) {
        return this.mImpl.getFirstMatch(r1);
    }

    public static LocaleListCompat getEmptyLocaleList() {
        return sEmptyLocaleList;
    }

    public static LocaleListCompat forLanguageTags(String r4) {
        if (r4 == null) goto L12;
        if (r4.isEmpty() == true) goto L12;
        String[] r5 = r4.split(SimContactsConstants.EMAIL_SEP, -1);
        int r0 = r5.length;
        Locale[] r1 = new Locale[r0];
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L10;
        r1[r2] = Api21Impl.forLanguageTag(r5[r2]);
        r2 = r2 + 1;
        goto L7
    L10:
        return create(r1);
    L12:
        return getEmptyLocaleList();
    }

    static Locale forLanguageTagCompat(String r6) {
        if (r6.contains("-") == false) goto L17;
        String[] r0 = r6.split("-", -1);
        if (r0.length <= 2) goto L9;
        return new Locale(r0[0], r0[1], r0[2]);
    L9:
        if (r0.length <= 1) goto L13;
        return new Locale(r0[0], r0[1]);
    L13:
        if (r0.length != 1) goto L31;
        return new Locale(r0[0]);
    L31:
        throw new IllegalArgumentException("Can not parse language tag: [" + r6 + "]");
    L17:
        if (r6.contains("_") == false) goto L33;
        String[] r1 = r6.split("_", -1);
        if (r1.length <= 2) goto L23;
        return new Locale(r1[0], r1[1], r1[2]);
    L23:
        if (r1.length <= 1) goto L27;
        return new Locale(r1[0], r1[1]);
    L27:
        if (r1.length != 1) goto L31;
        return new Locale(r1[0]);
    L33:
        return new Locale(r6);
    }

    public static LocaleListCompat getAdjustedDefault() {
        return wrap(Api24Impl.getAdjustedDefault());
    }

    public static LocaleListCompat getDefault() {
        return wrap(Api24Impl.getDefault());
    }

    public static boolean matchesLanguageAndScript(Locale r1, Locale r2) {
        if (BuildCompat.isAtLeastT() == false) goto L7;
        return LocaleList.matchesLanguageAndScript(r1, r2);
    L7:
        return Api21Impl.matchesLanguageAndScript(r1, r2);
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof LocaleListCompat) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mImpl.equals(((LocaleListCompat) r2).mImpl) == false) goto L7;
        return true;
    }

    public int hashCode() {
        return this.mImpl.hashCode();
    }

    public String toString() {
        return this.mImpl.toString();
    }
}

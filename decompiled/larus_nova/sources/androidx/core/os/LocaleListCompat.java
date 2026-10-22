package androidx.core.os;

import android.os.Build;
import android.os.LocaleList;
import androidx.core.text.ICUCompat;
import com.bytedance.android.live.uikit.util.RTLUtil;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public final class LocaleListCompat {
    private static final LocaleListCompat sEmptyLocaleList = null;
    private final LocaleListInterface mImpl;

    /* JADX INFO: loaded from: classes17.dex */
    public static class Api21Impl {
        private static final Locale[] PSEUDO_LOCALE = null;

        static {
            PSEUDO_LOCALE = new Locale[]{new Locale("en", "XA"), new Locale(RTLUtil.ARABIA_LANG, "XB")};
        }

        private Api21Impl() {
        }

        public static Locale forLanguageTag(String r100) {
            return Locale.forLanguageTag(r100);
        }

        private static boolean isPseudoLocale(Locale r100) {
            Locale[] r101 = PSEUDO_LOCALE;
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L9;
            if (r101[r103].equals(r100) == true) goto L6;
            r103 = r103 + 1;
            goto L3
        L6:
            return true;
        L9:
            return false;
        }

        public static boolean matchesLanguageAndScript(Locale r100, Locale r101) {
            if (r100.equals(r101) == false) goto L6;
            return true;
        L6:
            if (r100.getLanguage().equals(r101.getLanguage()) == true) goto L9;
            return false;
        L9:
            if (isPseudoLocale(r100) == false) goto L11;
        L24:
            return false;
        L11:
            if (isPseudoLocale(r101) == true) goto L24;
            String r102 = ICUCompat.maximizeAndGetScript(r100);
            if (r102.isEmpty() == false) goto L23;
            String r103 = r100.getCountry();
            if (r103.isEmpty() == false) goto L18;
            return true;
        L18:
            if (r103.equals(r101.getCountry()) == true) goto L26;
            return false;
        L26:
            return true;
        L23:
            return r102.equals(ICUCompat.maximizeAndGetScript(r101));
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class Api24Impl {
        public static LocaleList getAdjustedDefault() {
            return LocaleList.getAdjustedDefault();
        }

        public static LocaleList getDefault() {
            return LocaleList.getDefault();
        }

        private Api24Impl() {
        }

        public static LocaleList createLocaleList(Locale... r100) {
            return new LocaleList(r100);
        }
    }

    static {
        sEmptyLocaleList = create(new Locale[0]);
    }

    public static LocaleListCompat getAdjustedDefault() {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return wrap(Api24Impl.getAdjustedDefault());
    L7:
        return create(new Locale[]{Locale.getDefault()});
    }

    public static LocaleListCompat getDefault() {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return wrap(Api24Impl.getDefault());
    L7:
        return create(new Locale[]{Locale.getDefault()});
    }

    public int hashCode() {
        return this.mImpl.hashCode();
    }

    public boolean isEmpty() {
        return this.mImpl.isEmpty();
    }

    public int size() {
        return this.mImpl.size();
    }

    public String toLanguageTags() {
        return this.mImpl.toLanguageTags();
    }

    public String toString() {
        return this.mImpl.toString();
    }

    public Object unwrap() {
        return this.mImpl.getLocaleList();
    }

    public static LocaleListCompat getEmptyLocaleList() {
        return sEmptyLocaleList;
    }

    private LocaleListCompat(LocaleListInterface r100) {
        this.mImpl = r100;
    }

    public static LocaleListCompat create(Locale... r100) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return wrap(Api24Impl.createLocaleList(r100));
    L7:
        return new LocaleListCompat(new LocaleListCompatWrapper(r100));
    }

    public static Locale forLanguageTagCompat(String r100) {
        if (r100.contains("-") == false) goto L17;
        String[] r101 = r100.split("-", -1);
        if (r101.length <= 2) goto L9;
        return new Locale(r101[0], r101[1], r101[2]);
    L9:
        if (r101.length <= 1) goto L13;
        return new Locale(r101[0], r101[1]);
    L13:
        if (r101.length != 1) goto L31;
        return new Locale(r101[0]);
    L31:
        throw new IllegalArgumentException("Can not parse language tag: [" + r100 + "]");
    L17:
        if (r100.contains("_") == false) goto L33;
        String[] r102 = r100.split("_", -1);
        if (r102.length <= 2) goto L23;
        return new Locale(r102[0], r102[1], r102[2]);
    L23:
        if (r102.length <= 1) goto L27;
        return new Locale(r102[0], r102[1]);
    L27:
        if (r102.length != 1) goto L31;
        return new Locale(r102[0]);
    L33:
        return new Locale(r100);
    }

    public static LocaleListCompat forLanguageTags(String r100) {
        if (r100 == null) goto L12;
        if (r100.isEmpty() == true) goto L12;
        String[] r101 = r100.split(",", -1);
        int r102 = r101.length;
        Locale[] r103 = new Locale[r102];
        int r104 = 0;
    L7:
        if (r104 >= r102) goto L10;
        r103[r104] = Api21Impl.forLanguageTag(r101[r104]);
        r104 = r104 + 1;
        goto L7
    L10:
        return create(r103);
    L12:
        return getEmptyLocaleList();
    }

    public static LocaleListCompat wrap(LocaleList r100) {
        return new LocaleListCompat(new LocaleListPlatformWrapper(r100));
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof LocaleListCompat) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mImpl.equals(((LocaleListCompat) r100).mImpl) == false) goto L7;
        return true;
    }

    public Locale get(int r100) {
        return this.mImpl.get(r100);
    }

    public Locale getFirstMatch(String[] r100) {
        return this.mImpl.getFirstMatch(r100);
    }

    public int indexOf(Locale r100) {
        return this.mImpl.indexOf(r100);
    }

    public static LocaleListCompat wrap(Object r100) {
        return wrap((LocaleList) r100);
    }

    public static boolean matchesLanguageAndScript(Locale r100, Locale r101) {
        if (Build.VERSION.SDK_INT < 33) goto L7;
        return LocaleList.matchesLanguageAndScript(r100, r101);
    L7:
        return Api21Impl.matchesLanguageAndScript(r100, r101);
    }
}

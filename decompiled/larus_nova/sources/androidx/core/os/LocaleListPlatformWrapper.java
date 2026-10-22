package androidx.core.os;

import android.os.LocaleList;
import java.util.Locale;

/* JADX INFO: loaded from: classes17.dex */
final class LocaleListPlatformWrapper implements LocaleListInterface {
    private final LocaleList mLocaleList;

    public int hashCode() {
        return this.mLocaleList.hashCode();
    }

    @Override // androidx.core.os.LocaleListInterface
    public boolean isEmpty() {
        return this.mLocaleList.isEmpty();
    }

    @Override // androidx.core.os.LocaleListInterface
    public int size() {
        return this.mLocaleList.size();
    }

    @Override // androidx.core.os.LocaleListInterface
    public String toLanguageTags() {
        return this.mLocaleList.toLanguageTags();
    }

    public String toString() {
        return this.mLocaleList.toString();
    }

    @Override // androidx.core.os.LocaleListInterface
    public Object getLocaleList() {
        return this.mLocaleList;
    }

    public LocaleListPlatformWrapper(Object r100) {
        this.mLocaleList = (LocaleList) r100;
    }

    public boolean equals(Object r100) {
        return this.mLocaleList.equals(((LocaleListInterface) r100).getLocaleList());
    }

    @Override // androidx.core.os.LocaleListInterface
    public Locale get(int r100) {
        return this.mLocaleList.get(r100);
    }

    @Override // androidx.core.os.LocaleListInterface
    public Locale getFirstMatch(String[] r100) {
        return this.mLocaleList.getFirstMatch(r100);
    }

    @Override // androidx.core.os.LocaleListInterface
    public int indexOf(Locale r100) {
        return this.mLocaleList.indexOf(r100);
    }
}

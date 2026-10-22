package androidx.core.os;

import android.os.LocaleList;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class f implements LocaleListInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LocaleList f2577a;

    public f(Object r10) {
        this.f2577a = (LocaleList) r10;
    }

    public boolean equals(Object r10) {
        return this.f2577a.equals(((LocaleListInterface) r10).getLocaleList());
    }

    @Override // androidx.core.os.LocaleListInterface
    public Locale get(int r10) {
        return this.f2577a.get(r10);
    }

    @Override // androidx.core.os.LocaleListInterface
    public Locale getFirstMatch(String[] r10) {
        return this.f2577a.getFirstMatch(r10);
    }

    @Override // androidx.core.os.LocaleListInterface
    public Object getLocaleList() {
        return this.f2577a;
    }

    public int hashCode() {
        return this.f2577a.hashCode();
    }

    @Override // androidx.core.os.LocaleListInterface
    public int indexOf(Locale r10) {
        return this.f2577a.indexOf(r10);
    }

    @Override // androidx.core.os.LocaleListInterface
    public boolean isEmpty() {
        return this.f2577a.isEmpty();
    }

    @Override // androidx.core.os.LocaleListInterface
    public int size() {
        return this.f2577a.size();
    }

    @Override // androidx.core.os.LocaleListInterface
    public String toLanguageTags() {
        return this.f2577a.toLanguageTags();
    }

    public String toString() {
        return this.f2577a.toString();
    }
}

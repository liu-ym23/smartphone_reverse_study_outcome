package androidx.core.os;

import android.os.LocaleList;

/* loaded from: classes.dex */
final class f implements e {

    /* renamed from: a, reason: collision with root package name */
    private final LocaleList f9674a;

    f(Object obj) {
        this.f9674a = (LocaleList) obj;
    }

    @Override // androidx.core.os.e
    public String a() {
        return this.f9674a.toLanguageTags();
    }

    @Override // androidx.core.os.e
    public Object b() {
        return this.f9674a;
    }

    public boolean equals(Object obj) {
        return this.f9674a.equals(((e) obj).b());
    }

    public int hashCode() {
        return this.f9674a.hashCode();
    }

    @Override // androidx.core.os.e
    public boolean isEmpty() {
        return this.f9674a.isEmpty();
    }

    public String toString() {
        return this.f9674a.toString();
    }
}

package o3;

import n3.InterfaceC0781b;

/* loaded from: classes2.dex */
public final class f implements InterfaceC0781b {

    /* renamed from: a, reason: collision with root package name */
    public final String f13809a;

    /* renamed from: b, reason: collision with root package name */
    public volatile InterfaceC0781b f13810b;

    public f(String str) {
        this.f13809a = str;
    }

    @Override // n3.InterfaceC0781b
    public final void debug(String str, Object obj) {
        (this.f13810b != null ? this.f13810b : e.f13808a).debug("Removing {}", obj);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && f.class == obj.getClass() && this.f13809a.equals(((f) obj).f13809a);
    }

    @Override // n3.InterfaceC0781b
    public final void error(String str, Throwable th) {
        (this.f13810b != null ? this.f13810b : e.f13808a).error(str, th);
    }

    public final int hashCode() {
        return this.f13809a.hashCode();
    }

    @Override // n3.InterfaceC0781b
    public final void info(String str) {
        (this.f13810b != null ? this.f13810b : e.f13808a).info(str);
    }

    @Override // n3.InterfaceC0781b
    public final void warn(String str) {
        (this.f13810b != null ? this.f13810b : e.f13808a).warn(str);
    }
}

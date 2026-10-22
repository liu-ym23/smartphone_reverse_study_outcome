package j3;

import android.os.LocaleList;
import java.lang.invoke.VarHandle;
import java.util.Locale;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name */
    public static final c f6549b;

    /* renamed from: a, reason: collision with root package name */
    public d f6550a;

    static {
        LocaleList localeList = new LocaleList(new Locale[0]);
        d dVar = new d();
        dVar.f6551a = localeList;
        VarHandle.storeStoreFence();
        c cVar = new c();
        cVar.f6550a = dVar;
        VarHandle.storeStoreFence();
        f6549b = cVar;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof c) && this.f6550a.equals(((c) obj).f6550a);
    }

    public final int hashCode() {
        return this.f6550a.f6551a.hashCode();
    }

    public final String toString() {
        return this.f6550a.f6551a.toString();
    }
}

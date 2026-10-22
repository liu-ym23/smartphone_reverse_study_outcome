package e8;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public com.fasterxml.jackson.core.util.a f3606a;

    public final a a(w7.a aVar) {
        String str = aVar != null ? aVar.f15287a : "";
        String strSubstring = str.startsWith("classpath:") ? str.substring(10) : str.startsWith("resource:") ? str.substring(9) : null;
        if (strSubstring == null) {
            return null;
        }
        ClassLoader classLoader = (ClassLoader) this.f3606a.get();
        if (strSubstring.startsWith("//")) {
            strSubstring = strSubstring.substring(2);
        }
        a aVar2 = new a();
        aVar2.f3602a = classLoader;
        aVar2.f3603b = strSubstring;
        aVar2.f3604c = str;
        VarHandle.storeStoreFence();
        return aVar2;
    }
}

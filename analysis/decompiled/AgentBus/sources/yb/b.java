package yb;

import nb.f;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final f f11749a = new f(20);

    public static byte[] a(String str) {
        try {
            return f11749a.s(str.length(), str);
        } catch (Exception e10) {
            a aVar = new a("exception decoding Hex string: " + e10.getMessage());
            aVar.f11748f = e10;
            throw aVar;
        }
    }
}

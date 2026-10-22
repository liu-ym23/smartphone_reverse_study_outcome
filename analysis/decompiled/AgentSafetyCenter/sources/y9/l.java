package y9;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public static final f7.f f16062a = new f7.f(5);

    /* renamed from: b, reason: collision with root package name */
    public static final f7.f f16063b;

    /* renamed from: c, reason: collision with root package name */
    public static final f7.f f16064c;

    /* renamed from: d, reason: collision with root package name */
    public static final f7.f f16065d;

    /* renamed from: e, reason: collision with root package name */
    public static final f7.f f16066e;

    static {
        f7.f fVar = new f7.f(9);
        VarHandle.storeStoreFence();
        f16063b = fVar;
        f7.f fVar2 = new f7.f(7);
        VarHandle.storeStoreFence();
        f16064c = fVar2;
        f7.f fVar3 = new f7.f(8);
        VarHandle.storeStoreFence();
        f16065d = fVar3;
        f7.f fVar4 = new f7.f(4);
        VarHandle.storeStoreFence();
        f16066e = fVar4;
    }

    public static final int a(int i, int i3) {
        return (i & 16777215) | ((((p5.f.q(i3, 0, 100) * 255) + 50) / 100) << 24);
    }

    public static final int b(int i, int i3) {
        return (i & 16777215) | ((((p5.f.q(i3, 0, 100) * 255) + 50) / 100) << 24);
    }
}

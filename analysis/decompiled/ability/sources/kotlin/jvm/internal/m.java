package kotlin.jvm.internal;

import b8.r0;

/* loaded from: classes3.dex */
public abstract class m {

    /* renamed from: a, reason: collision with root package name */
    public static final n f4928a;

    static {
        n nVar = null;
        try {
            nVar = (n) r0.class.newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (nVar == null) {
            nVar = new n();
        }
        f4928a = nVar;
    }
}

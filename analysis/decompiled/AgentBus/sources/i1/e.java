package i1;

/* loaded from: classes.dex */
public final class e implements s0.i {

    /* renamed from: a, reason: collision with root package name */
    public static final e f4444a = new e();

    /* renamed from: b, reason: collision with root package name */
    public static Boolean f4445b;

    @Override // s0.i
    public final boolean a() {
        Boolean bool = f4445b;
        if (bool != null) {
            return bool.booleanValue();
        }
        throw m.x.i("canFocus is read before it is written");
    }

    @Override // s0.i
    public final void b(boolean z4) {
        f4445b = Boolean.valueOf(z4);
    }
}

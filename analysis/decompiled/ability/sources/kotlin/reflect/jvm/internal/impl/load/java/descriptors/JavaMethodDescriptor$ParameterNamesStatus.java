package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

/* loaded from: classes4.dex */
enum JavaMethodDescriptor$ParameterNamesStatus {
    NON_STABLE_DECLARED(false, false),
    STABLE_DECLARED(true, false),
    NON_STABLE_SYNTHESIZED(false, true),
    STABLE_SYNTHESIZED(true, true);


    /* renamed from: a, reason: collision with root package name */
    public final boolean f4993a;
    public final boolean b;

    JavaMethodDescriptor$ParameterNamesStatus(boolean z10, boolean z11) {
        this.f4993a = z10;
        this.b = z11;
    }
}

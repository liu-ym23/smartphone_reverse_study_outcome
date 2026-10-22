package io.ktor.utils.io;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class r0 implements a6.f0 {

    /* renamed from: a, reason: collision with root package name */
    public final d0 f3239a;

    /* renamed from: b, reason: collision with root package name */
    public final f5.h f3240b;

    public r0(d0 d0Var, f5.h coroutineContext) {
        kotlin.jvm.internal.p.e(coroutineContext, "coroutineContext");
        this.f3239a = d0Var;
        this.f3240b = coroutineContext;
    }

    @Override // a6.f0
    public final f5.h b() {
        return this.f3240b;
    }
}

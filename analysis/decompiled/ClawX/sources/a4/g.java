package a4;

import a6.f0;
import kotlin.jvm.internal.p;
import z3.y0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class g implements f0 {

    /* renamed from: a, reason: collision with root package name */
    public final y0 f103a;

    /* renamed from: b, reason: collision with root package name */
    public final f5.h f104b;

    public g(y0 httpSendSender, f5.h coroutineContext) {
        p.e(httpSendSender, "httpSendSender");
        p.e(coroutineContext, "coroutineContext");
        this.f103a = httpSendSender;
        this.f104b = coroutineContext;
    }

    @Override // a6.f0
    public final f5.h b() {
        return this.f104b;
    }
}

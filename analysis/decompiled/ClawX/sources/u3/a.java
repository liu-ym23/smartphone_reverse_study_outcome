package u3;

import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a extends IllegalStateException {

    /* renamed from: a, reason: collision with root package name */
    public final String f5626a;

    public a(c call) {
        p.e(call, "call");
        this.f5626a = "Response already received: " + call;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return this.f5626a;
    }
}

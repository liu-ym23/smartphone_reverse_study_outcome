package io.modelcontextprotocol.client.transport;

import reactor.core.Disposable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class c0 implements Disposable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6164c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ qd.e f6165f;

    public /* synthetic */ c0(int i) {
        this.f6164c = i;
    }

    @Override // reactor.core.Disposable
    public final void dispose() {
        int i = this.f6164c;
        qd.e eVar = this.f6165f;
        switch (i) {
            case 0:
                eVar.cancel();
                break;
            case 1:
                eVar.cancel();
                break;
            default:
                eVar.cancel();
                break;
        }
    }
}

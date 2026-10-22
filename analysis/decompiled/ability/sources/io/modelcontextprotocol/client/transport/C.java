package io.modelcontextprotocol.client.transport;

import reactor.core.Disposable;

/* loaded from: classes2.dex */
public final /* synthetic */ class C implements Disposable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4650a;
    public final /* synthetic */ Z9.e b;

    public /* synthetic */ C(Z9.e eVar, int i) {
        this.f4650a = i;
        this.b = eVar;
    }

    @Override // reactor.core.Disposable
    public final void dispose() {
        int i = this.f4650a;
        Z9.e eVar = this.b;
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

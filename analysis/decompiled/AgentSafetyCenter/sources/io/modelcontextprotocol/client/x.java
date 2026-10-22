package io.modelcontextprotocol.client;

import java.util.List;
import java.util.function.Consumer;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class x implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6223c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Consumer f6224f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ List f6225g;

    public /* synthetic */ x(int i) {
        this.f6223c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6223c) {
            case 0:
                this.f6224f.accept(this.f6225g);
                break;
            case 1:
                this.f6224f.accept(this.f6225g);
                break;
            case 2:
                this.f6224f.accept(this.f6225g);
                break;
            default:
                this.f6224f.accept(this.f6225g);
                break;
        }
    }
}

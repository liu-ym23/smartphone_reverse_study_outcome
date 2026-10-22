package io.modelcontextprotocol.client;

import java.util.List;
import java.util.function.Consumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class x implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4684a;
    public final /* synthetic */ Consumer b;
    public final /* synthetic */ List c;

    public /* synthetic */ x(Consumer consumer, List list, int i) {
        this.f4684a = i;
        this.b = consumer;
        this.c = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4684a) {
            case 0:
                this.b.accept(this.c);
                break;
            case 1:
                this.b.accept(this.c);
                break;
            case 2:
                this.b.accept(this.c);
                break;
            default:
                this.b.accept(this.c);
                break;
        }
    }
}

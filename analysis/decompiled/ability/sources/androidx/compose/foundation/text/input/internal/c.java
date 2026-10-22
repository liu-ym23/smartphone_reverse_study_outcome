package androidx.compose.foundation.text.input.internal;

import java.util.function.IntConsumer;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1739a;
    public final /* synthetic */ IntConsumer b;
    public final /* synthetic */ int c;

    public /* synthetic */ c(IntConsumer intConsumer, int i, int i6) {
        this.f1739a = i6;
        this.b = intConsumer;
        this.c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1739a) {
            case 0:
                this.b.accept(this.c);
                break;
            default:
                this.b.accept(this.c);
                break;
        }
    }
}

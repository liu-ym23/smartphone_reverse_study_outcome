package q3;

import com.mdisdk.capability.input.EventCallback;
import com.mdisdk.capability.input.impl.AndroidEventInjector;

/* renamed from: q3.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final /* synthetic */ class RunnableC1799a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5577a = 0;
    public final /* synthetic */ AndroidEventInjector b;
    public final /* synthetic */ long c;
    public final /* synthetic */ float d;
    public final /* synthetic */ float e;
    public final /* synthetic */ int f;
    public final /* synthetic */ EventCallback g;

    public /* synthetic */ RunnableC1799a(AndroidEventInjector androidEventInjector, float f, float f7, int i, EventCallback eventCallback, long j5) {
        this.b = androidEventInjector;
        this.d = f;
        this.e = f7;
        this.f = i;
        this.g = eventCallback;
        this.c = j5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5577a) {
            case 0:
                this.b.lambda$longPress$1(this.d, this.e, this.f, this.g, this.c);
                break;
            default:
                int i = this.f;
                EventCallback eventCallback = this.g;
                this.b.lambda$longPress$0(this.c, this.d, this.e, i, eventCallback);
                break;
        }
    }

    public /* synthetic */ RunnableC1799a(AndroidEventInjector androidEventInjector, long j5, float f, float f7, int i, EventCallback eventCallback) {
        this.b = androidEventInjector;
        this.c = j5;
        this.d = f;
        this.e = f7;
        this.f = i;
        this.g = eventCallback;
    }
}

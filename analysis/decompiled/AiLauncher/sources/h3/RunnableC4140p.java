package h3;

import java.util.Map;
import m3.C4894a;
import m3.InterfaceC4895b;

/* renamed from: h3.p, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class RunnableC4140p implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final Map.Entry f32935a;

    /* renamed from: b, reason: collision with root package name */
    public final C4894a f32936b;

    public RunnableC4140p(Map.Entry entry, C4894a c4894a) {
        this.f32935a = entry;
        this.f32936b = c4894a;
    }

    public static Runnable a(Map.Entry entry, C4894a c4894a) {
        return new RunnableC4140p(entry, c4894a);
    }

    @Override // java.lang.Runnable
    public void run() {
        ((InterfaceC4895b) this.f32935a.getKey()).a(this.f32936b);
    }
}

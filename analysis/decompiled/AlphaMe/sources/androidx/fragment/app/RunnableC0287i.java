package androidx.fragment.app;

import java.util.ArrayList;

/* renamed from: androidx.fragment.app.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0287i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3761a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3762b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3763c;

    public /* synthetic */ RunnableC0287i(int i4, Object obj, Object obj2) {
        this.f3761a = i4;
        this.f3763c = obj;
        this.f3762b = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i4 = this.f3761a;
        Object obj = this.f3762b;
        switch (i4) {
            case 0:
                f0.a((ArrayList) obj, 4);
                break;
            default:
                ((r0) obj).c();
                break;
        }
    }
}

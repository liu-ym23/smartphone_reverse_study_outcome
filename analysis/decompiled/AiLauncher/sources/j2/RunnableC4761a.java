package j2;

import e2.AbstractC3981h;
import e2.m;

/* renamed from: j2.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class RunnableC4761a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final c f34492a;

    /* renamed from: b, reason: collision with root package name */
    public final m f34493b;

    /* renamed from: c, reason: collision with root package name */
    public final b2.g f34494c;

    /* renamed from: d, reason: collision with root package name */
    public final AbstractC3981h f34495d;

    public RunnableC4761a(c cVar, m mVar, b2.g gVar, AbstractC3981h abstractC3981h) {
        this.f34492a = cVar;
        this.f34493b = mVar;
        this.f34494c = gVar;
        this.f34495d = abstractC3981h;
    }

    public static Runnable a(c cVar, m mVar, b2.g gVar, AbstractC3981h abstractC3981h) {
        return new RunnableC4761a(cVar, mVar, gVar, abstractC3981h);
    }

    @Override // java.lang.Runnable
    public void run() {
        c.c(this.f34492a, this.f34493b, this.f34494c, this.f34495d);
    }
}

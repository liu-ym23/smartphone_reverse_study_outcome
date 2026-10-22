package b6;

import a6.m;
import a6.o0;
import android.graphics.Typeface;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f923a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f924b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f925c;

    public /* synthetic */ d(Object obj, int i8, Object obj2) {
        this.f923a = i8;
        this.f924b = obj;
        this.f925c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() throws o0 {
        switch (this.f923a) {
            case 0:
                ((m) this.f924b).C((f) this.f925c);
                break;
            default:
                ((w.b) this.f924b).e((Typeface) this.f925c);
                break;
        }
    }
}

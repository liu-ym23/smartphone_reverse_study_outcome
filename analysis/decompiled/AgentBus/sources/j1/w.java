package j1;

import android.os.SystemClock;
import android.view.MotionEvent;

/* loaded from: classes.dex */
public final class w extends q7.m implements p7.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f5341g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ y f5342h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w(y yVar, int i2) {
        super(0);
        this.f5341g = i2;
        this.f5342h = yVar;
    }

    @Override // p7.a
    public final Object c() {
        int actionMasked;
        switch (this.f5341g) {
            case 0:
                y yVar = this.f5342h;
                MotionEvent motionEvent = yVar.f5385u0;
                if (motionEvent != null && ((actionMasked = motionEvent.getActionMasked()) == 7 || actionMasked == 9)) {
                    yVar.f5387v0 = SystemClock.uptimeMillis();
                    yVar.post(yVar.A0);
                }
                return c7.r.f1986a;
            default:
                return this.f5342h.get_viewTreeOwners();
        }
    }
}

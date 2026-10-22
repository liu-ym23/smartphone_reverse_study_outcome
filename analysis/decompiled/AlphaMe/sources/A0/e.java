package A0;

import androidx.work.impl.foreground.SystemForegroundService;
import com.google.android.gms.common.api.internal.q;
import stepos.support.v7.widget.PopupNestedScrollingLayout;

/* loaded from: classes.dex */
public final class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f42a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f43b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f44c;

    public /* synthetic */ e(int i4, int i5, Object obj) {
        this.f42a = i5;
        this.f44c = obj;
        this.f43b = i4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i4 = this.f42a;
        int i5 = this.f43b;
        Object obj = this.f44c;
        switch (i4) {
            case 0:
                ((SystemForegroundService) obj).f4344e.cancel(i5);
                break;
            case 1:
                ((q) obj).f(i5);
                break;
            default:
                PopupNestedScrollingLayout popupNestedScrollingLayout = (PopupNestedScrollingLayout) obj;
                popupNestedScrollingLayout.h(i5 - popupNestedScrollingLayout.f14885p);
                break;
        }
    }
}

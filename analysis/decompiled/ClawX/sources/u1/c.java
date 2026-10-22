package u1;

import android.view.View;
import com.google.android.material.sidesheet.SideSheetBehavior;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5620a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f5621b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f5622c;

    public /* synthetic */ c(Object obj, int i8, int i9) {
        this.f5620a = i9;
        this.f5622c = obj;
        this.f5621b = i8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5620a) {
            case 0:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f5622c;
                View view = (View) sideSheetBehavior.f1339p.get();
                if (view != null) {
                    sideSheetBehavior.t(view, this.f5621b, false);
                    break;
                }
                break;
            default:
                ((w.b) this.f5622c).d(this.f5621b);
                break;
        }
    }
}

package f;

import android.view.View;
import android.view.ViewTreeObserver;
import g.j1;
import java.util.ArrayList;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2417a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f2418b;

    public /* synthetic */ c(l lVar, int i8) {
        this.f2417a = i8;
        this.f2418b = lVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        switch (this.f2417a) {
            case 0:
                g gVar = (g) this.f2418b;
                ArrayList arrayList = gVar.f2432h;
                if (gVar.k() && arrayList.size() > 0) {
                    int i8 = 0;
                    if (!((f) arrayList.get(0)).f2424a.f2756v) {
                        View view = gVar.f2439p;
                        if (view != null && view.isShown()) {
                            int size = arrayList.size();
                            while (i8 < size) {
                                Object obj = arrayList.get(i8);
                                i8++;
                                ((f) obj).f2424a.a();
                            }
                            break;
                        } else {
                            gVar.dismiss();
                            break;
                        }
                    }
                }
                break;
            default:
                s sVar = (s) this.f2418b;
                j1 j1Var = sVar.f2513h;
                if (sVar.k() && !j1Var.f2756v) {
                    View view2 = sVar.f2518n;
                    if (view2 != null && view2.isShown()) {
                        j1Var.a();
                        break;
                    } else {
                        sVar.dismiss();
                        break;
                    }
                }
                break;
        }
    }
}

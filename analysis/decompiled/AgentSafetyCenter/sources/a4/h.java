package a4;

import java.util.ArrayList;
import java.util.List;
import stepos.support.v7.widget.PopupNestedScrollingLayout;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f170c = 1;

    /* renamed from: f, reason: collision with root package name */
    public int f171f;

    /* renamed from: g, reason: collision with root package name */
    public Object f172g;

    public h(List list, int i, Throwable th) {
        p5.f.k(list, "initCallbacks cannot be null");
        this.f172g = new ArrayList(list);
        this.f171f = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f170c) {
            case 0:
                ArrayList arrayList = (ArrayList) this.f172g;
                int size = arrayList.size();
                int i = 0;
                if (this.f171f == 1) {
                    while (i < size) {
                        ((g) arrayList.get(i)).b();
                        i++;
                    }
                    break;
                } else {
                    while (i < size) {
                        ((g) arrayList.get(i)).a();
                        i++;
                    }
                    break;
                }
            default:
                PopupNestedScrollingLayout popupNestedScrollingLayout = (PopupNestedScrollingLayout) this.f172g;
                popupNestedScrollingLayout.g(this.f171f - popupNestedScrollingLayout.f12627t);
                break;
        }
    }

    public /* synthetic */ h() {
    }
}

package pe;

import android.view.View;
import com.google.android.material.bottomappbar.BottomAppBar$Behavior;
import stepos.support.v7.widget.n;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class a implements View.OnLayoutChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10041a = 0;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f10042b;

    public a(BottomAppBar$Behavior bottomAppBar$Behavior) {
        this.f10042b = bottomAppBar$Behavior;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i3, int i10, int i11, int i12, int i13, int i14, int i15) {
        switch (this.f10041a) {
            case 0:
                c.a((n) this.f10042b);
                return;
            default:
                throw null;
        }
    }

    public /* synthetic */ a() {
    }
}

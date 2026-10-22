package androidx.activity;

import android.view.View;
import com.stepos.agentsafetycenter.R;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i0 extends yb.l implements xb.l {

    /* renamed from: f, reason: collision with root package name */
    public static final i0 f681f;

    /* renamed from: g, reason: collision with root package name */
    public static final i0 f682g;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f683c;

    static {
        int i = 1;
        f681f = new i0(i, 0);
        f682g = new i0(i, 1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i0(int i, int i3) {
        super(i);
        this.f683c = i3;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        switch (this.f683c) {
            case 0:
                View view = (View) obj;
                view.getClass();
                Object parent = view.getParent();
                if (parent instanceof View) {
                    return (View) parent;
                }
                return null;
            default:
                View view2 = (View) obj;
                view2.getClass();
                Object tag = view2.getTag(R.id.view_tree_on_back_pressed_dispatcher_owner);
                if (tag instanceof g0) {
                    return (g0) tag;
                }
                return null;
        }
    }
}

package g7;

import a4.t;
import android.view.View;
import androidx.fragment.app.r;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.sidesheet.SideSheetBehavior;
import java.lang.invoke.VarHandle;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4361a = 1;

    /* renamed from: b, reason: collision with root package name */
    public int f4362b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4363c;

    /* renamed from: d, reason: collision with root package name */
    public final Runnable f4364d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ b3.a f4365e;

    public f(SideSheetBehavior sideSheetBehavior) {
        this.f4365e = sideSheetBehavior;
        t tVar = new t(15);
        tVar.f200f = this;
        VarHandle.storeStoreFence();
        this.f4364d = tVar;
    }

    public final void a(int i) {
        switch (this.f4361a) {
            case 0:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f4365e;
                WeakReference weakReference = sideSheetBehavior.f2457p;
                if (weakReference != null && weakReference.get() != null) {
                    this.f4362b = i;
                    if (!this.f4363c) {
                        ((View) sideSheetBehavior.f2457p.get()).postOnAnimation((t) this.f4364d);
                        this.f4363c = true;
                        break;
                    }
                }
                break;
            default:
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.f4365e;
                WeakReference weakReference2 = bottomSheetBehavior.W;
                if (weakReference2 != null && weakReference2.get() != null) {
                    this.f4362b = i;
                    if (!this.f4363c) {
                        ((View) bottomSheetBehavior.W.get()).postOnAnimation((r) this.f4364d);
                        this.f4363c = true;
                        break;
                    }
                }
                break;
        }
    }

    public f(BottomSheetBehavior bottomSheetBehavior) {
        this.f4365e = bottomSheetBehavior;
        r rVar = new r(14);
        rVar.f1301f = this;
        VarHandle.storeStoreFence();
        this.f4364d = rVar;
    }
}

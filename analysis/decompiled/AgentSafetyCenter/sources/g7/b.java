package g7;

import android.view.View;
import android.view.ViewParent;
import com.google.android.material.sidesheet.SideSheetBehavior;
import java.lang.invoke.VarHandle;
import java.lang.ref.WeakReference;
import o3.o;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements o {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ SideSheetBehavior f4353c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ int f4354f;

    @Override // o3.o
    public final boolean c(View view) {
        SideSheetBehavior sideSheetBehavior = this.f4353c;
        int i = this.f4354f;
        if (i == 1 || i == 2) {
            throw new IllegalArgumentException(androidx.activity.b.n(new StringBuilder("STATE_"), i == 1 ? "DRAGGING" : "SETTLING", " should not be set externally."));
        }
        WeakReference weakReference = sideSheetBehavior.f2457p;
        if (weakReference == null || weakReference.get() == null) {
            sideSheetBehavior.c(i);
            return true;
        }
        View view2 = (View) sideSheetBehavior.f2457p.get();
        c cVar = new c(0);
        cVar.f4357g = sideSheetBehavior;
        cVar.f4356f = i;
        VarHandle.storeStoreFence();
        ViewParent parent = view2.getParent();
        if (parent != null && parent.isLayoutRequested() && view2.isAttachedToWindow()) {
            view2.post(cVar);
            return true;
        }
        cVar.run();
        return true;
    }
}

package stepos.support.v7.widget;

import android.R;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class d1 {

    /* renamed from: a, reason: collision with root package name */
    public View f12741a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f12742b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ StepOSRecyclerView f12743c;

    public final boolean a(int i, int i3, Rect rect, MotionEvent motionEvent) {
        int i10;
        StepOSRecyclerView stepOSRecyclerView = this.f12743c;
        boolean z10 = i >= rect.left && i <= rect.right;
        if (stepOSRecyclerView.f12650j0) {
            int rawY = (int) motionEvent.getRawY();
            int rawX = (int) motionEvent.getRawX();
            View viewJ = stepOSRecyclerView.j(i, i3);
            View viewFindViewById = viewJ == null ? null : viewJ.findViewById(R.id.checkbox);
            if (viewFindViewById != null && (viewFindViewById instanceof Checkable)) {
                int[] iArr = new int[2];
                viewFindViewById.getLocationOnScreen(iArr);
                int i11 = iArr[0];
                return rawX >= i11 && rawX <= viewFindViewById.getWidth() + i11 && rawY >= (i10 = iArr[1]) && rawY <= viewFindViewById.getHeight() + i10;
            }
        }
        return z10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean b(RecyclerView recyclerView, View view, int i, long j10) {
        int i3;
        long j11;
        boolean z10;
        StepOSRecyclerView stepOSRecyclerView = this.f12743c;
        if (stepOSRecyclerView.s(i)) {
            return true;
        }
        boolean z11 = false;
        if (stepOSRecyclerView.f12643f != 0) {
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            boolean zIsSelectable = adapter instanceof m1 ? ((m1) adapter).isSelectable(i) : true;
            int i10 = stepOSRecyclerView.f12643f;
            if ((i10 == 4 || i10 == 5) && stepOSRecyclerView.f12644g != null && zIsSelectable) {
                boolean z12 = stepOSRecyclerView.f12649j.get(i, false);
                boolean z13 = !z12;
                stepOSRecyclerView.f12649j.put(i, z13);
                if (stepOSRecyclerView.f12653l != null && adapter.hasStableIds()) {
                    p.n nVar = stepOSRecyclerView.f12653l;
                    if (z12) {
                        nVar.b(adapter.getItemId(i));
                    } else {
                        nVar.e(Integer.valueOf(i), adapter.getItemId(i));
                    }
                }
                int i11 = stepOSRecyclerView.i;
                if (z12) {
                    stepOSRecyclerView.i = i11 - 1;
                } else {
                    stepOSRecyclerView.i = i11 + 1;
                }
                ActionMode actionMode = stepOSRecyclerView.f12644g;
                if (actionMode != null) {
                    i3 = i;
                    j11 = j10;
                    stepOSRecyclerView.f12646h.onItemCheckedStateChanged(actionMode, i3, j11, z13);
                } else {
                    i3 = i;
                    j11 = j10;
                    z11 = true;
                }
                z10 = z11;
                z11 = true;
            } else {
                i3 = i;
                j11 = j10;
                z10 = true;
            }
            if (z11) {
                stepOSRecyclerView.u();
            }
            z11 = true;
        } else {
            i3 = i;
            j11 = j10;
            z10 = true;
        }
        if (z10 && stepOSRecyclerView.U) {
            if (!stepOSRecyclerView.V) {
                view.setHovered(true);
            }
            y0 y0Var = stepOSRecyclerView.T;
            if (y0Var == null) {
                y0 y0Var2 = new y0();
                y0Var2.f12925a = view;
                y0Var2.f12926b = i3;
                y0Var2.f12927c = j11;
                stepOSRecyclerView.T = y0Var2;
                return z11;
            }
            y0Var.f12925a = view;
            y0Var.f12926b = i3;
            y0Var.f12927c = j11;
        }
        return z11;
    }

    public final void c() {
        StepOSRecyclerView stepOSRecyclerView = this.f12743c;
        stepOSRecyclerView.setPressed(false);
        View view = this.f12741a;
        if (view != null) {
            view.setPressed(false);
        }
        Drawable drawable = stepOSRecyclerView.M;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        stepOSRecyclerView.N.setEmpty();
        stepOSRecyclerView.f12640c = 3;
    }
}

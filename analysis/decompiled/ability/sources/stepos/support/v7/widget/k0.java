package stepos.support.v7.widget;

import android.R;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes4.dex */
public final class k0 {

    /* renamed from: a, reason: collision with root package name */
    public View f6622a;
    public boolean b = false;
    public final /* synthetic */ StepOSRecyclerView c;

    public k0(StepOSRecyclerView stepOSRecyclerView) {
        this.c = stepOSRecyclerView;
    }

    public final boolean a(int i, int i6, Rect rect, MotionEvent motionEvent) {
        int i10;
        boolean z10 = i >= rect.left && i <= rect.right;
        StepOSRecyclerView stepOSRecyclerView = this.c;
        if (stepOSRecyclerView.f6541j0) {
            stepOSRecyclerView.getClass();
        }
        if (stepOSRecyclerView.f6541j0) {
            int rawY = (int) motionEvent.getRawY();
            int rawX = (int) motionEvent.getRawX();
            View viewJ = stepOSRecyclerView.j(i, i6);
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
    public final boolean b(RecyclerView recyclerView, View view, int i, long j5) {
        int i6;
        long j6;
        boolean z10;
        StepOSRecyclerView stepOSRecyclerView = this.c;
        if (stepOSRecyclerView.s(i)) {
            return true;
        }
        boolean z11 = false;
        if (stepOSRecyclerView.b != 0) {
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            boolean zIsSelectable = adapter instanceof t0 ? ((t0) adapter).isSelectable(i) : true;
            int i10 = stepOSRecyclerView.b;
            if ((i10 == 4 || i10 == 5) && stepOSRecyclerView.c != null && zIsSelectable) {
                boolean z12 = stepOSRecyclerView.f.get(i, false);
                boolean z13 = !z12;
                stepOSRecyclerView.f.put(i, z13);
                if (stepOSRecyclerView.h != null && adapter.hasStableIds()) {
                    if (z12) {
                        stepOSRecyclerView.h.delete(adapter.getItemId(i));
                    } else {
                        stepOSRecyclerView.h.put(adapter.getItemId(i), Integer.valueOf(i));
                    }
                }
                if (z12) {
                    stepOSRecyclerView.e--;
                } else {
                    stepOSRecyclerView.e++;
                }
                ActionMode actionMode = stepOSRecyclerView.c;
                if (actionMode != null) {
                    i6 = i;
                    j6 = j5;
                    stepOSRecyclerView.d.onItemCheckedStateChanged(actionMode, i6, j6, z13);
                } else {
                    i6 = i;
                    j6 = j5;
                    z11 = true;
                }
                z10 = z11;
                z11 = true;
            } else {
                i6 = i;
                j6 = j5;
                z10 = true;
            }
            if (z11) {
                stepOSRecyclerView.u();
            }
            z11 = true;
        } else {
            i6 = i;
            j6 = j5;
            z10 = true;
        }
        if (z10 && stepOSRecyclerView.f6528U) {
            if (!stepOSRecyclerView.f6529V) {
                view.setHovered(true);
            }
            C5.d dVar = stepOSRecyclerView.f6527T;
            if (dVar == null) {
                C5.d dVar2 = new C5.d(1);
                dVar2.d = view;
                dVar2.b = i6;
                dVar2.c = j6;
                stepOSRecyclerView.f6527T = dVar2;
                return z11;
            }
            dVar.d = view;
            dVar.b = i6;
            dVar.c = j6;
        }
        return z11;
    }

    public final void c() {
        StepOSRecyclerView stepOSRecyclerView = this.c;
        stepOSRecyclerView.setPressed(false);
        View view = this.f6622a;
        if (view != null) {
            view.setPressed(false);
        }
        Drawable drawable = stepOSRecyclerView.f6520M;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        stepOSRecyclerView.f6521N.setEmpty();
        stepOSRecyclerView.f6531a = 3;
    }
}

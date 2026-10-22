package stepos.support.v7.widget;

import android.R;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import androidx.recyclerview.widget.RecyclerView;
import o2.C0808a;

/* loaded from: classes2.dex */
public final class c0 implements O {

    /* renamed from: a, reason: collision with root package name */
    public View f15074a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f15075b = false;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ StepOSRecyclerView f15076c;

    public c0(StepOSRecyclerView stepOSRecyclerView) {
        this.f15076c = stepOSRecyclerView;
    }

    public final boolean a(int i4, int i5, Rect rect, MotionEvent motionEvent) {
        int i6;
        boolean z4 = false;
        boolean z5 = i4 >= rect.left && i4 <= rect.right;
        StepOSRecyclerView stepOSRecyclerView = this.f15076c;
        if (stepOSRecyclerView.f14959q0) {
            stepOSRecyclerView.getClass();
        }
        if (!stepOSRecyclerView.f14959q0) {
            return z5;
        }
        int rawY = (int) motionEvent.getRawY();
        int rawX = (int) motionEvent.getRawX();
        View viewK = stepOSRecyclerView.k(i4, i5);
        View viewFindViewById = viewK == null ? null : viewK.findViewById(R.id.checkbox);
        if (viewFindViewById == null || !(viewFindViewById instanceof Checkable)) {
            return z5;
        }
        int[] iArr = new int[2];
        viewFindViewById.getLocationOnScreen(iArr);
        int i7 = iArr[0];
        if (rawX >= i7 && rawX <= viewFindViewById.getWidth() + i7 && rawY >= (i6 = iArr[1]) && rawY <= viewFindViewById.getHeight() + i6) {
            z4 = true;
        }
        return z4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean b(StepOSRecyclerView stepOSRecyclerView, View view, int i4, long j4) {
        boolean z4;
        StepOSRecyclerView stepOSRecyclerView2 = this.f15076c;
        if (stepOSRecyclerView2.v(i4)) {
            return true;
        }
        boolean z5 = false;
        if (stepOSRecyclerView2.f14937b != 0) {
            RecyclerView.Adapter adapter = stepOSRecyclerView.getAdapter();
            boolean zIsSelectable = adapter instanceof l0 ? ((l0) adapter).isSelectable(i4) : true;
            int i5 = stepOSRecyclerView2.f14937b;
            if ((i5 == 4 || i5 == 5) && ((stepOSRecyclerView2.f14938c != null || stepOSRecyclerView2.f14949l0) && zIsSelectable)) {
                boolean z6 = !stepOSRecyclerView2.f14941f.get(i4, false);
                stepOSRecyclerView2.f14941f.put(i4, z6);
                if (stepOSRecyclerView2.f14943h != null && adapter.hasStableIds()) {
                    if (z6) {
                        stepOSRecyclerView2.f14943h.f(adapter.getItemId(i4), Integer.valueOf(i4));
                    } else {
                        stepOSRecyclerView2.f14943h.c(adapter.getItemId(i4));
                    }
                }
                if (z6) {
                    stepOSRecyclerView2.f14940e++;
                } else {
                    stepOSRecyclerView2.f14940e--;
                }
                ActionMode actionMode = stepOSRecyclerView2.f14938c;
                if (actionMode != null) {
                    stepOSRecyclerView2.f14939d.a(actionMode, i4, j4, z6);
                } else {
                    z5 = true;
                }
                z4 = z5;
                z5 = true;
            } else {
                z4 = true;
            }
            if (z5) {
                stepOSRecyclerView2.x();
            }
            z5 = true;
        } else {
            z4 = true;
        }
        if (z4 && stepOSRecyclerView2.f14930Q) {
            if (!stepOSRecyclerView2.f14931R) {
                view.setHovered(true);
            }
            C0808a c0808a = stepOSRecyclerView2.f14929P;
            if (c0808a == null) {
                C0808a c0808a2 = new C0808a();
                c0808a2.f13791d = stepOSRecyclerView2;
                c0808a2.f13790c = view;
                c0808a2.f13788a = i4;
                c0808a2.f13789b = j4;
                stepOSRecyclerView2.f14929P = c0808a2;
            } else {
                c0808a.f13790c = view;
                c0808a.f13788a = i4;
                c0808a.f13789b = j4;
            }
        }
        return z5;
    }

    public final void c() {
        StepOSRecyclerView stepOSRecyclerView = this.f15076c;
        stepOSRecyclerView.setPressed(false);
        View view = this.f15074a;
        if (view != null) {
            view.setPressed(false);
        }
        Drawable drawable = stepOSRecyclerView.f14922I;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        stepOSRecyclerView.f14923J.setEmpty();
        stepOSRecyclerView.f14936a = 3;
    }
}

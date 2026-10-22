package com.google.android.material.bottomsheet;

import A6.l;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.sidesheet.SideSheetBehavior;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2348a;
    public int b;
    public boolean c;
    public final Runnable d;
    public final /* synthetic */ CoordinatorLayout.Behavior e;

    public f(SideSheetBehavior sideSheetBehavior) {
        this.f2348a = 1;
        this.e = sideSheetBehavior;
        this.d = new D6.b(this, 17);
    }

    public final void a(int i) {
        switch (this.f2348a) {
            case 0:
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.e;
                WeakReference weakReference = bottomSheetBehavior.f2325W;
                if (weakReference != null && weakReference.get() != null) {
                    this.b = i;
                    if (!this.c) {
                        ((View) bottomSheetBehavior.f2325W.get()).postOnAnimation((l) this.d);
                        this.c = true;
                        break;
                    }
                }
                break;
            default:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.e;
                WeakReference weakReference2 = sideSheetBehavior.p;
                if (weakReference2 != null && weakReference2.get() != null) {
                    this.b = i;
                    if (!this.c) {
                        ((View) sideSheetBehavior.p.get()).postOnAnimation((D6.b) this.d);
                        this.c = true;
                        break;
                    }
                }
                break;
        }
    }

    public f(BottomSheetBehavior bottomSheetBehavior) {
        this.f2348a = 0;
        this.e = bottomSheetBehavior;
        this.d = new l(this, 18);
    }
}

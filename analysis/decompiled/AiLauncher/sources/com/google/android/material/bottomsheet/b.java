package com.google.android.material.bottomsheet;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.app.l;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* loaded from: classes2.dex */
public class b extends l {
    private boolean waitingForDismissAllowingStateLoss;

    /* renamed from: com.google.android.material.bottomsheet.b$b, reason: collision with other inner class name */
    public class C0230b extends BottomSheetBehavior.g {
        public C0230b() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void b(View view, float f10) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void c(View view, int i10) {
            if (i10 == 5) {
                b.this.p();
            }
        }
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC1374l
    public void dismiss() {
        if (r(false)) {
            return;
        }
        super.dismiss();
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC1374l
    public void dismissAllowingStateLoss() {
        if (r(true)) {
            return;
        }
        super.dismissAllowingStateLoss();
    }

    @Override // androidx.appcompat.app.l, androidx.fragment.app.DialogInterfaceOnCancelListenerC1374l
    public Dialog onCreateDialog(Bundle bundle) {
        return new com.google.android.material.bottomsheet.a(getContext(), getTheme());
    }

    public final void p() {
        if (this.waitingForDismissAllowingStateLoss) {
            super.dismissAllowingStateLoss();
        } else {
            super.dismiss();
        }
    }

    public final void q(BottomSheetBehavior<?> bottomSheetBehavior, boolean z10) {
        this.waitingForDismissAllowingStateLoss = z10;
        if (bottomSheetBehavior.S() == 5) {
            p();
            return;
        }
        if (getDialog() instanceof com.google.android.material.bottomsheet.a) {
            ((com.google.android.material.bottomsheet.a) getDialog()).q();
        }
        bottomSheetBehavior.A(new C0230b());
        bottomSheetBehavior.x0(5);
    }

    public final boolean r(boolean z10) {
        Dialog dialog = getDialog();
        if (!(dialog instanceof com.google.android.material.bottomsheet.a)) {
            return false;
        }
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) dialog;
        BottomSheetBehavior<FrameLayout> bottomSheetBehaviorN = aVar.n();
        if (!bottomSheetBehaviorN.Y() || !aVar.o()) {
            return false;
        }
        q(bottomSheetBehaviorN, z10);
        return true;
    }
}

package com.google.android.material.bottomsheet;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialogFragment;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.h.a;
import com.stepos.aiengine.R;
import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class BottomSheetDialogFragment extends AppCompatDialogFragment {
    private boolean waitingForDismissAllowingStateLoss;

    public BottomSheetDialogFragment() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissAfterAnimation() {
        if (this.waitingForDismissAllowingStateLoss) {
            super.dismissAllowingStateLoss();
        } else {
            super.dismiss();
        }
    }

    private void dismissWithAnimation(BottomSheetBehavior<?> bottomSheetBehavior, boolean z) throws Resources.NotFoundException {
        this.waitingForDismissAllowingStateLoss = z;
        if (bottomSheetBehavior.Q == 5) {
            dismissAfterAnimation();
            return;
        }
        if (getDialog() instanceof h) {
            h hVar = (h) getDialog();
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior2 = hVar.h;
            bottomSheetBehavior2.b0.remove(hVar.f4727s);
        }
        a aVar = new a();
        ArrayList<BottomSheetBehavior.d> arrayList = bottomSheetBehavior.b0;
        if (!arrayList.contains(aVar)) {
            arrayList.add(aVar);
        }
        bottomSheetBehavior.s(5);
    }

    private boolean tryDismissWithAnimation(boolean z) throws Resources.NotFoundException {
        Dialog dialog = getDialog();
        if (!(dialog instanceof h)) {
            return false;
        }
        h hVar = (h) dialog;
        if (hVar.h == null) {
            hVar.e();
        }
        boolean z3 = hVar.h.L;
        return false;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        if (tryDismissWithAnimation(false)) {
            return;
        }
        super.dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismissAllowingStateLoss() {
        if (tryDismissWithAnimation(true)) {
            return;
        }
        super.dismissAllowingStateLoss();
    }

    @Override // androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Context context = getContext();
        int theme = getTheme();
        if (theme == 0) {
            TypedValue typedValue = new TypedValue();
            theme = context.getTheme().resolveAttribute(R.attr.bottomSheetDialogTheme, typedValue, true) ? typedValue.resourceId : R.style.Theme_Design_Light_BottomSheetDialog;
        }
        h hVar = new h(context, theme);
        hVar.f4722m = true;
        hVar.f4723n = true;
        hVar.f4727s = hVar.new a();
        hVar.c().n(1);
        TypedArray typedArrayObtainStyledAttributes = hVar.getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.enableEdgeToEdge});
        hVar.f4726q = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        return hVar;
    }

    @SuppressLint({"ValidFragment"})
    public BottomSheetDialogFragment(int i10) {
        super(i10);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends BottomSheetBehavior.d {
        public a() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.d
        public final void c(int i10, View view) {
            if (i10 == 5) {
                BottomSheetDialogFragment.this.dismissAfterAnimation();
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.d
        public final void b(View view) {
        }
    }
}

package com.bytedance.android.ec.hybrid.ui;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.DialogFragment;
import com.bytedance.common.utility.UIUtils;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/ec/hybrid/ui/ECMallHoleOverMaskLayer;", "Landroidx/fragment/app/DialogFragment;", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECMallHoleOverMaskLayer extends DialogFragment {
    public ECMallHoleOverMaskLayer() {
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        throw null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r100 = getDialog();
        if (r100 == null) goto L8;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L8;
        r101.setDimAmount(0.0f);
        r101.setBackgroundDrawable(new ColorDrawable(0));
        r101.setGravity(17);
        WindowManager.LayoutParams r102 = r101.getAttributes();
        r102.width = UIUtils.getScreenWidth(r101.getContext());
        int r103 = UIUtils.getScreenHeight(r101.getContext());
        r102.height = r103;
        r101.setLayout(r102.width, r103);
    L8:
        throw null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Dialog r101 = getDialog();
        if (r101 == null) goto L8;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L9;
        r102.setBackgroundDrawable(new ColorDrawable(0));
        return;
    L9:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Dialog r103 = getDialog();
        if (r103 == null) goto L8;
        Window r104 = r103.getWindow();
        if (r104 == null) goto L8;
        r104.setBackgroundDrawable(new ColorDrawable(0));
    L8:
        throw null;
    }
}

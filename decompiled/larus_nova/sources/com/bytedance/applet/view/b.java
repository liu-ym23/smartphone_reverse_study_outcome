package com.bytedance.applet.view;

import android.app.Dialog;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes14.dex */
public final /* synthetic */ class b implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AppletFragment f192369a;

    public /* synthetic */ b(AppletFragment r100) {
        this.f192369a = r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        AppletFragment r100 = this.f192369a;
        int r101 = AppletFragment.f192328J;
        Fragment r102 = r100.getParentFragment();
        if ((r102 instanceof DialogFragment) == false) goto L5;
        DialogFragment r103 = (DialogFragment) r102;
    L6:
        if (r103 == null) goto L13;
        Dialog r104 = r103.getDialog();
        if (r104 == null) goto L13;
        Window r105 = r104.getWindow();
        if (r105 == null) goto L13;
        return r105;
    L13:
        FragmentActivity r106 = r100.getActivity();
        if (r106 != null) goto L16;
        return null;
    L16:
        return r106.getWindow();
    L5:
        r103 = null;
        goto L6
    }
}

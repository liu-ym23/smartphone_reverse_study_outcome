package com.bytedance.android.live.revlink.impl.pk.dialog;

import android.view.View;
import androidx.appcompat.widget.AppCompatRadioButton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class h implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PkMuteCheckDialogFragment f95976a;

    public h(PkMuteCheckDialogFragment r100) {
        this.f95976a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        AppCompatRadioButton r101 = this.f95976a.f95440h;
        boolean r102 = false;
        if (r101 == null) goto L12;
        if (r101 != null) goto L6;
    L9:
        boolean r103 = true;
    L10:
        r101.setChecked(r103);
        goto L12
    L6:
        if (r101.isChecked() != true) goto L9;
        r103 = false;
    L12:
        if (Intrinsics.areEqual(this.f95976a.f95443k, Boolean.TRUE) == false) goto L19;
        AppCompatRadioButton r104 = this.f95976a.f95440h;
        if (r104 != null) goto L16;
    L17:
        r102 = true;
    L18:
        l51.a.T.setValue(null, l51.a.f507436a[48], Boolean.valueOf(r102));
        return;
    L16:
        if (r104.isChecked() == true) goto L18;
    L19:
        AppCompatRadioButton r105 = this.f95976a.f95440h;
        if (r105 != null) goto L22;
    L23:
        r102 = true;
    L24:
        l51.a.S.setValue(null, l51.a.f507436a[47], Boolean.valueOf(r102));
        return;
    L22:
        if (r105.isChecked() == true) goto L24;
        goto L23
    }
}

package com.bytedance.android.livesdk.interactivity.comment.input;

import android.view.View;
import android.widget.CheckBox;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class h implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f135168a;

    public h(i r100) {
        this.f135168a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        CheckBox r101 = this.f135168a.f135171c;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("checkBox");
    L5:
        CheckBox r102 = this.f135168a.f135171c;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("checkBox");
    L8:
        r101.setChecked(!r102.isChecked());
    }
}

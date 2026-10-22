package com.bytedance.android.livesdk.dislike;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.larus.nova.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class f extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f122111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f122112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f122113c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Unit> f122114d;

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setContentView(R.layout.ttlive_dialog_bottom_dislke);
        Window r101 = getWindow();
        if (r101 == null) goto L5;
        r101.setLayout(-1, -2);
    L5:
        Window r102 = getWindow();
        if (r102 == null) goto L8;
        r102.setGravity(80);
    L8:
        this.f122111a = findViewById(R.id.root);
        this.f122112b = findViewById(R.id.ll_dislike);
        this.f122113c = findViewById(R.id.btn_cancel);
        View r103 = this.f122111a;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L11:
        r103.setOnClickListener(new c(this));
        View r104 = this.f122113c;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mCancelView");
    L14:
        r104.setOnClickListener(new d(this));
        View r105 = this.f122112b;
        if (r105 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mDislikeView");
    L17:
        r105.setOnClickListener(new e(this));
    }

    public f(Activity r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        super(r100, R.style.ttlive_dislike_bottom_dialog);
        this.f122114d = r101;
    }
}

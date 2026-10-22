package com.bytedance.android.livesdk.interactivity.roomintro.v2.adapter;

import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.x0;
import com.bytedance.android.livesdk.widget.TextCorrectionEditText;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes9.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f140614a;

    public g(a r100) {
        this.f140614a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        UtilityKotlinExtentionsKt.t(this.f140614a.f140607d);
        TextCorrectionEditText r101 = this.f140614a.f140606c;
        if (r101 == null) goto L5;
        UtilityKotlinExtentionsKt.w(r101);
    L5:
        String r102 = this.f140614a.f140604a;
        if (r102 != null) goto L8;
    L11:
        boolean r103 = true;
    L12:
        if (r103 == true) goto L21;
        a r104 = this.f140614a;
        TextCorrectionEditText r105 = r104.f140606c;
        if (r105 == null) goto L16;
        r105.setText(r104.f140604a);
    L16:
        int r106 = this.f140614a.b();
        String r107 = this.f140614a.f140604a;
        if (r107 == null) goto L21;
        int r108 = r107.length();
        TextCorrectionEditText r109 = this.f140614a.f140606c;
        if (r109 == null) goto L21;
        r109.setSelection(RangesKt.coerceAtMost(r108, r106));
    L21:
        x0.b(this.f140614a.f140606c);
        return;
    L8:
        if (r102.length() == 0) goto L11;
        r103 = false;
        goto L12
    }
}

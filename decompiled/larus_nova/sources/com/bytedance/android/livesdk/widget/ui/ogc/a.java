package com.bytedance.android.livesdk.widget.ui.ogc;

import android.view.View;
import com.bytedance.android.livesdk.interactivity.api.expression.j;
import com.bytedance.android.livesdk.widget.board.ExpressionContext;
import com.bytedance.android.livesdk.widget.board.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f162188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f162189b;

    @Override // com.bytedance.android.livesdk.widget.board.k
    public final void a() {
    }

    @Override // com.bytedance.android.livesdk.widget.board.k
    public final void unbind() {
        View r100 = this.f162188a;
        if (r100 == null) goto L7;
        OGCFixedSelectPanel r101 = (OGCFixedSelectPanel) r100;
        r101.f162184e.dispose();
        r101.f162183d = null;
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.widget.ui.ogc.OGCFixedSelectPanel");
    }

    @Override // com.bytedance.android.livesdk.widget.board.k
    public final View getRootView() {
        return this.f162188a;
    }

    @Override // com.bytedance.android.livesdk.widget.board.k
    public final void b(ExpressionContext r100) {
        Intrinsics.checkNotNullParameter(r100, "expressionContext");
        View r101 = this.f162188a;
        if (r101 == null) goto L10;
        OGCFixedSelectPanel r102 = (OGCFixedSelectPanel) r101;
        j r103 = r100.getOnCommentSendDelegate().getValue();
        if (r103 == null) goto L7;
        r102.setOnSubscribeEmojiSendListener(r103);
    L7:
        r102.b(this.f162189b);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.widget.ui.ogc.OGCFixedSelectPanel");
    }

    public a(View r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        this.f162188a = r100;
        this.f162189b = r101;
    }
}

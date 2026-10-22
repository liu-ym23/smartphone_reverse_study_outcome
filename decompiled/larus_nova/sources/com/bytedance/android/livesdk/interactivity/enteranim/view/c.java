package com.bytedance.android.livesdk.interactivity.enteranim.view;

import android.graphics.drawable.NinePatchDrawable;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.utils.a3;
import com.bytedance.android.livesdk.interactivity.api.base.utils.InteractivityOpt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements a3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseEnterView f136874a;

    @Override // com.bytedance.android.livesdk.chatroom.utils.a3.b
    public final void onFail() {
        ALogger.d("BaseEnterView", "error load nine patch");
    }

    public c(BaseEnterView r100) {
        this.f136874a = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.utils.a3.b
    public final void a(NinePatchDrawable r100) {
        Intrinsics.checkNotNullParameter(r100, "ninePatchDrawable");
        View r101 = this.f136874a.f136810f;
        if (r101 == null) goto L5;
        int r102 = r101.getPaddingLeft();
    L7:
        if (r102 <= InteractivityOpt.a(6.0f)) goto L19;
        HSImageView r103 = this.f136874a.f136805a;
        if (r103 == null) goto L19;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        if ((r104 instanceof ViewGroup.MarginLayoutParams) == true) goto L13;
        r104 = null;
    L13:
        ViewGroup.MarginLayoutParams r105 = (ViewGroup.MarginLayoutParams) r104;
        if (r105 == null) goto L16;
        r105.leftMargin = 0;
    L16:
        HSImageView r106 = this.f136874a.f136805a;
        if (r106 == null) goto L30;
        r106.setLayoutParams(r105);
    L30:
        BaseEnterView r107 = this.f136874a;
        e r108 = r107.f136811g;
        if (r108 == null) goto L34;
        ((UserEnterLevelView) r108).e(r107);
        return;
    L34:
        return;
    L19:
        View r109 = this.f136874a.f136810f;
        if (r109 == null) goto L30;
        int r110 = r109.getPaddingTop();
        View r111 = this.f136874a.f136810f;
        if (r111 == null) goto L24;
        int r112 = r111.getPaddingRight();
    L25:
        View r113 = this.f136874a.f136810f;
        if (r113 == null) goto L28;
        int r114 = r113.getPaddingBottom();
    L29:
        r109.setPadding(0, r110, r112, r114);
        goto L30
    L28:
        r114 = 0;
        goto L29
    L24:
        r112 = 0;
        goto L25
    L5:
        r102 = 0;
        goto L7
    }
}

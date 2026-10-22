package com.bytedance.android.livesdk.chatroom.ui.setting;

import android.view.View;
import com.bytedance.android.live.broadcast.api.model.IMiddlewareAnchorVideoResolutionManager;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.h2;
import com.bytedance.android.livesdkapi.interfaces.ListDialogAbility;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class y extends mx.j {

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DataCenter f114170a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ListDialogAbility f114171b;

        public a(DataCenter r100, ListDialogAbility r101) {
            this.f114170a = r100;
            this.f114171b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            h2 r101 = new h2();
            r101.p4(r100, this.f114170a);
            r101.onClick(r100);
            this.f114171b.dismissDialog();
            r101.R9(r100, this.f114170a);
        }
    }

    public y(DataCenter r100, ListDialogAbility r101) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        Intrinsics.checkNotNullParameter(r101, "ability");
        String r102 = ((IMiddlewareAnchorVideoResolutionManager) va1.b.a.f553922a.a(IMiddlewareAnchorVideoResolutionManager.class)).getCurrResolutionTxt().getValue();
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        super("选择清晰度", r102, false, 12);
        this.f516144l = new a(r100, r101);
    }
}

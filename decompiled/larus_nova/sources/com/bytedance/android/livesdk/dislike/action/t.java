package com.bytedance.android.livesdk.dislike.action;

import android.view.View;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.dislike.ActionsManager;
import com.bytedance.android.livesdk.dislike.NotificationSettingBottomDialog;
import com.bytedance.android.livesdk.notification.notificationsetting.api.NotificationSettingStatusApi;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class t extends OptionAction {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ActionsManager f122095e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f122096f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final NotificationSettingBottomDialog.b f122097g;

    @Override // com.bytedance.android.livesdk.dislike.action.OptionAction
    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        String r101 = this.f122096f;
        if (r101 == null) goto L6;
        ((NotificationSettingStatusApi) com.bytedance.android.live.network.c.b().e(NotificationSettingStatusApi.class)).updateFollowPushStatus(r101, r101, (int) 2).compose(RxUtil.rxSchedulerHelper()).subscribe(new r(this, r101), new s(this));
        return;
    }

    public t(ActionsManager r100, String r101, NotificationSettingBottomDialog.b r102) {
        Intrinsics.checkNotNullParameter(r100, "actionsManager");
        super(r100);
        this.f122095e = r100;
        this.f122096f = r101;
        this.f122097g = r102;
    }
}

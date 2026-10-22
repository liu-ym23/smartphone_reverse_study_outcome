package com.bytedance.android.live.revlink.impl.multianchor.ui;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdk.widget.z0;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public x0 f94814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f94815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f94816c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f94817d;

    public p(Context r100) {
        this.f94817d = r100;
        this.f94815b = new CompositeDisposable();
    }

    public static final void a(p r100, Throwable r101) {
        r100.getClass();
        if ((r101 instanceof ApiServerException) == false) goto L5;
        IESUIUtils.displayToast(r100.f94817d, ((ApiServerException) r101).getPrompt());
        return;
    L5:
        ToastUtil.a(R.string.ttlive_live_profile_action_error, 0);
    }

    public final void b(final String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(UserProfileEvent.POSITION_LINKED_ANCHOR_MANAGE_SETTING, "source");
        if (r101 == true) goto L32;
        x0 r102 = this.f94814a;
        if (r102 == null) goto L28;
        if (r102.isShowing() != true) goto L28;
        x0 r103 = this.f94814a;
        if (r103 == null) goto L28;
        Handler r104 = DialogLancet.resolveDialogHandler(r103);
        if (r104 != null) goto L13;
    L15:
        DialogLancet.beforeDialogDismiss(r103);
        r103.dismiss();     // Catch: Throwable -> L18 Exception -> L20
    L24:
        DialogLancet.afterDialogDismiss(r103);
        goto L28
    L20:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L18
        Throwable r105 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L18
        if (r105 == null) goto L24;
        com.bytedance.crash.d.d(r105, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r103);
        throw th;
    L13:
        if (Looper.myLooper() == r104.getLooper()) goto L15;
        r104.post(DialogLancet.createDismissRunnable(r103));
    L28:
        if (this.f94817d != null) goto L30;
        return;
    L30:
        z0 r106 = z0.a();
        Context r107 = this.f94817d;
        r106.getClass();
        x0.b r108 = z0.b(r107);
        r108.l(R.string.ttlive_rev_talk_room_interact_panel_un_follow_title);
        r108.i(0, R.string.ttlive_ok, new l(this, r100));
        r108.i(1, R.string.ttlive_cancel, m.f94809a);
        this.f94814a = r108.n();
        return;
    L32:
        if (this.f94816c == true) goto L40;
        this.f94816c = true;
        RxUtilKt.c(((com.bytedance.android.livesdk.revenue.service.user.a) vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class)).om(null, null, new ds2.c(new MultiFollowHelper$follow$1(r100))).subscribe(new j(this, r100), new k(this)), this.f94815b);
        return;
    }
}

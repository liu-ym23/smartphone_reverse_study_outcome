package com.bytedance.android.livesdk.chatroom.replay.session.video.task;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.livesdk.chatroom.vs_base.session.video.h;
import com.bytedance.android.livesdk.room.data.EndReason;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes7.dex */
public final class e extends com.bytedance.android.livesdk.chatroom.vs_base.base.api.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f109950b;

    public e(h r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        this.f109950b = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.base.api.a
    public final void b(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "extra");
        Object r101 = r100.get("key_error");
        pq1.a r102 = null;
        String r103 = null;
        if ((r101 instanceof ls2.e) == true) goto L5;
        r101 = null;
    L5:
        ls2.e r104 = (ls2.e) r101;
        if (r104 != null) goto L8;
        return;
    L8:
        pq1.a r105 = this.f109950b.f118147u;
        if (r105 == null) goto L33;
        if (r105.isShowing() == true) goto L14;
        r105 = null;
    L14:
        if (r105 == null) goto L33;
        Handler r106 = DialogLancet.resolveDialogHandler(r105);
        if (r106 != null) goto L18;
    L20:
        DialogLancet.beforeDialogDismiss(r105);
        r105.dismiss();     // Catch: Throwable -> L23 Exception -> L25
    L29:
        DialogLancet.afterDialogDismiss(r105);
        goto L33
    L23:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r105);
        throw th;
    L25:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L23
        Throwable r107 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L23
        if (r107 == null) goto L29;
        com.bytedance.crash.d.d(r107, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L23
        goto L29
    L18:
        if (Looper.myLooper() == r106.getLooper()) goto L20;
        r106.post(DialogLancet.createDismissRunnable(r105));
    L33:
        if (r104.getErrorCode() != 30006) goto L36;
        com.bytedance.android.livesdk.chatroom.vs_base.log.d.a(this.f109950b.f118151y).d("blacklist_request_enter", null, new Object[0]);
    L36:
        if (StringsKt.contains$default(r104.getErrMsgV2(), String.valueOf(30005), false, 2, null) == false) goto L38;
    L47:
        pq1.a r108 = this.f109950b.f118147u;
        if (r108 != null) goto L50;
    L52:
        this.f109950b.f118130d.f118069w.setValue("show");
        h r109 = this.f109950b;
        pq1.a.C7226a r110 = new pq1.a.C7226a(r109.getContext(), 0);
        r110.f530265a.f530273f = false;
        r110.b(R.string.ttlive_replay_play_tip);
        r110.a(0, R.string.ttlive_replay_play_finish, new c(this));
        r110.a(1, R.string.ttlive_text_cancel, new d(this));
        Context r111 = r110.f530265a.f530269b;
        if (r111 == null) goto L55;
        new pq1.a(r111, r110.f530265a);
    L55:
        Context r112 = r110.f530265a.f530269b;
        if (r112 == null) goto L58;
        r102 = new pq1.a(r112, r110.f530265a);
    L58:
        if (r102 != null) goto L60;
    L64:
        r109.f118147u = r102;
        return;
    L60:
        if (DialogLancet.shouldBlockDialogShow(r102) == false) goto L67;
        DialogLancet.handleBlockedDialogShow(r102);
        goto L64
    L67:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L66
    L63:
        DialogLancet.beforeDialogShow(r102);
        r102.show();
        DialogLancet.afterDialogShow(r102);
        goto L64
    L50:
        if (r108.isShowing() != true) goto L52;
        return;
    L38:
        if (r104.getErrorCode() == 30005) goto L47;
        h r113 = this.f109950b;
        long r114 = r113.f118149w;
        String r115 = r113.getContext().getString(R.string.ttlive_replay_live_enter_failed);
        String r116 = r104.getErrPromptV2();
        if ((!StringsKt.isBlank(r116)) == false) goto L43;
        r103 = r116;
    L43:
        if (r103 == null) goto L46;
        r115 = r103;
    L46:
        com.bytedance.android.livesdk.chatroom.vs_base.base.api.b r117 = a();
        r104.setErrPromptV2(r115);
        r104.setReasonV2(EndReason.ENTER_FAILED.INSTANCE);
        Unit r118 = Unit.INSTANCE;
        r117.start(b.class, MapsKt.mapOf(TuplesKt.to("key_error", r104)));
    }
}

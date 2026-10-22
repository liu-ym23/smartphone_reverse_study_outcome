package com.bytedance.android.live.liveinteract.chatroom.chatroom.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog.LinkCommonBottomDialog;
import com.bytedance.android.live.liveinteract.plantform.api.LinkAudienceApi;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rj0.l;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/ui/VideoTalkRoomApplyCancelDialog;", "Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/dialog/LinkCommonBottomDialog;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class VideoTalkRoomApplyCancelDialog extends LinkCommonBottomDialog {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f72433e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f72434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DataCenter f72435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f72436c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f72437d;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoTalkRoomApplyCancelDialog f72438a;

        public b(VideoTalkRoomApplyCancelDialog r100) {
            this.f72438a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (this.f72438a.f72436c <= 0) goto L5;
            int r101 = bh0.a.f18994a;
            int r102 = 101;
        L6:
            l.f537955n2.getClass();
            l r103 = l.a.a();
            if (r103 == null) goto L9;
            l.b.a(r103, this.f72438a.f72436c, r102, "video_talk_apply_click");
        L9:
            VideoTalkRoomApplyCancelDialog r104 = this.f72438a;
            Handler r105 = DialogLancet.resolveDialogHandler(r104);
            if (r105 != null) goto L12;
        L14:
            DialogLancet.beforeDialogDismiss(r104);
            r104.dismiss();     // Catch: Throwable -> L17 Exception -> L19
        L23:
            DialogLancet.afterDialogDismiss(r104);
            return;
        L17:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r104);
            throw th;
        L19:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
            Throwable r106 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
            if (r106 == null) goto L23;
            com.bytedance.crash.d.d(r106, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
            goto L23
        L12:
            if (Looper.myLooper() == r105.getLooper()) goto L14;
            r105.post(DialogLancet.createDismissRunnable(r104));
            return;
        L5:
            int r107 = bh0.a.f18994a;
            r102 = 102;
            goto L6
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoTalkRoomApplyCancelDialog f72439a;

        public c(VideoTalkRoomApplyCancelDialog r100) {
            this.f72439a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (com.bytedance.android.live.liveinteract.videotalk.a.f79039a == true) goto L24;
            l.f537955n2.getClass();
            l r101 = l.a.a();
            if (r101 == null) goto L7;
            l.b.c(r101, null, 7);
        L7:
            VideoTalkRoomApplyCancelDialog r102 = this.f72439a;
            Handler r103 = DialogLancet.resolveDialogHandler(r102);
            if (r103 != null) goto L10;
        L12:
            DialogLancet.beforeDialogDismiss(r102);
            r102.dismiss();     // Catch: Throwable -> L15 Exception -> L17
        L21:
            DialogLancet.afterDialogDismiss(r102);
            return;
        L15:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r102);
            throw th;
        L17:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L15
            Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L15
            if (r104 == null) goto L21;
            com.bytedance.crash.d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L15
            goto L21
        L10:
            if (Looper.myLooper() == r103.getLooper()) goto L12;
            r103.post(DialogLancet.createDismissRunnable(r102));
            return;
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoTalkRoomApplyCancelDialog f72440a;

        public d(VideoTalkRoomApplyCancelDialog r100) {
            this.f72440a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            VideoTalkRoomApplyCancelDialog r101 = this.f72440a;
            Handler r102 = DialogLancet.resolveDialogHandler(r101);
            if (r102 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r101);
            r101.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r101);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r101);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r103 == null) goto L16;
            com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r102.getLooper()) goto L7;
            r102.post(DialogLancet.createDismissRunnable(r101));
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog
    public final int getLayoutId() {
        return R.layout.ttlive_dialog_video_talkroom_apply_cancel;
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f72434a.dispose();
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r110) {
        super.onCreate(r110);
        if (this.f72437d == false) goto L5;
        ((TextView) findViewById(R.id.video_talk_room_apply)).setVisibility(0);
        ((TextView) findViewById(R.id.cancel_apply)).setVisibility(8);
        ((FrameLayout) findViewById(R.id.layout_apply_waiting_rank_tips)).setVisibility(8);
    L10:
        ((TextView) findViewById(R.id.video_talk_room_apply)).setOnClickListener(new b(this));
        ((TextView) findViewById(R.id.cancel_apply)).setOnClickListener(new c(this));
        ((TextView) findViewById(R.id.cancel)).setOnClickListener(new d(this));
        return;
    L5:
        ((TextView) findViewById(R.id.video_talk_room_apply)).setVisibility(8);
        ((TextView) findViewById(R.id.cancel_apply)).setVisibility(0);
        DataCenter r111 = this.f72435b;
        if (r111 == null) goto L10;
        IRoom r112 = a0.m(r111).f66427a;
        if (r112 == null) goto L10;
        long r100 = r112.getId();
        Disposable r113 = ((LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class)).getUserWaitingRankPosition(r100, r100, 8, 0).compose(RxUtil.rxSchedulerHelper()).subscribe(new j(this), k.f72469a);
        this.f72434a.add(r113);
        goto L10
    }

    public VideoTalkRoomApplyCancelDialog(Context r100, DataCenter r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f72435b = r101;
        this.f72436c = r102;
        this.f72437d = false;
        this.f72434a = new CompositeDisposable();
    }
}

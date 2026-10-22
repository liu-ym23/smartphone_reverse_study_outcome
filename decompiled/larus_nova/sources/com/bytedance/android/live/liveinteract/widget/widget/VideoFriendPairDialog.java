package com.bytedance.android.live.liveinteract.widget.widget;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.liveinteract.plantform.model.h0;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/widget/widget/VideoFriendPairDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "Lcom/bytedance/android/live/liveinteract/widget/widget/PairUserAdapter$PairUserViewHolder$a;", "Lcom/bytedance/android/live/liveinteract/widget/widget/VideoFriendSelectPairDialog$a;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class VideoFriendPairDialog extends CommonBottomDialog implements PairUserAdapter.PairUserViewHolder.a, VideoFriendSelectPairDialog.a {

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoFriendPairDialog f81024a;

        public a(VideoFriendPairDialog r100) {
            this.f81024a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            VideoFriendPairDialog r101 = this.f81024a;
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

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog
    public final int getLayoutId() {
        return R.layout.ttlive_dialog_video_friend_pair;
    }

    public final void M0() {
        com.bytedance.android.livesdk.sharedpref.e<Long> r100 = b6.f65223a0;
        Long r101 = r100.getValue();
        if (r101 == null) goto L8;
        if (r101.longValue() != 0) goto L8;
    L11:
        ((TextView) findViewById(R.id.tv_cooling_countdown)).setVisibility(8);
        com.bytedance.android.livesdk.sharedpref.f.d(r100, 0L);
        throw null;
    L8:
        if ((SystemClock.elapsedRealtime() - r100.getValue().longValue()) >= ((Number) vm2.d.f555952r5.getValue(null, vm2.d.f555776a[327(0x147, float:4.58E-43)])).longValue()) goto L11;
        ((TextView) findViewById(R.id.tv_cooling_countdown)).setVisibility(0);
        throw null;
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        throw null;
    }

    @Override // com.bytedance.android.live.liveinteract.widget.widget.VideoFriendSelectPairDialog.a
    public final void A0(List<? extends h0> r100) {
        Intrinsics.checkNotNullParameter(r100, "users");
        if (r100.size() > 0) goto L5;
        return;
    L5:
        ((RecyclerView) findViewById(R.id.rv_pair_user_list)).setVisibility(0);
        ((LinearLayout) findViewById(R.id.empty)).setVisibility(8);
        throw null;
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setCanceledOnTouchOutside(true);
        ((FrameLayout) findViewById(R.id.iv_back)).setOnClickListener(new a(this));
        M0();
        throw null;
    }
}

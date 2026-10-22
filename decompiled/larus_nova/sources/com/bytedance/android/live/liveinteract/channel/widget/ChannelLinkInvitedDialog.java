package com.bytedance.android.live.liveinteract.channel.widget;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdk.widget.CommonStandardBottomDialog;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/channel/widget/ChannelLinkInvitedDialog;", "Lcom/bytedance/android/livesdk/widget/CommonStandardBottomDialog;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ChannelLinkInvitedDialog extends CommonStandardBottomDialog {
    public static final /* synthetic */ int D = 0;
    public Animation B;
    public Animation C;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.widget.CommonStandardBottomDialog
    public final boolean V0() {
        return true;
    }

    @Override // com.bytedance.android.livesdk.widget.CommonStandardBottomDialog
    public final int getLayoutId() {
        return R.layout.ttlive_room_channel_link_invited_dialog;
    }

    @Override // com.bytedance.android.livesdk.widget.LiveStandardSheetDialog, com.bytedance.android.livesdk.pannel.SheetBaseDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Intrinsics.throwUninitializedPropertyAccessException("callback");
        Intrinsics.throwUninitializedPropertyAccessException("inviterUser");
        throw null;
    }

    @Override // com.bytedance.android.livesdk.widget.CommonStandardBottomDialog, com.bytedance.android.livesdk.pannel.SheetBaseDialog, android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        throw null;
    }

    @Override // com.bytedance.android.livesdk.widget.CommonStandardBottomDialog, com.bytedance.android.livesdk.pannel.SheetBaseDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.B = AnimationUtils.loadAnimation(getContext(), R.anim.ttlive_video_talk_beinvited);
        this.C = AnimationUtils.loadAnimation(getContext(), R.anim.ttlive_video_talk_beinvited_user);
        AnimationUtils.loadAnimation(getContext(), R.anim.ttlive_video_talk_beinvited_user_out);
        Animation r101 = this.C;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mUserAnimation");
    L5:
        r101.setRepeatCount(-1);
        Animation r102 = this.B;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException(GXTemplateKey.GAIAX_ANIMATION);
    L8:
        r102.setInterpolator(new LinearInterpolator());
        Animation r103 = this.C;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mUserAnimation");
    L11:
        r103.setInterpolator(new LinearInterpolator());
        ImageView r104 = (ImageView) findViewById(R.id.inviter_user_avatar_iv);
        Intrinsics.throwUninitializedPropertyAccessException("inviterUser");
        throw null;
    }
}

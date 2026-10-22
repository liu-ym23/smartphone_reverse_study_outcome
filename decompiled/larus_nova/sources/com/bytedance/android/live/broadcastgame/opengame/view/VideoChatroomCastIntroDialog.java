package com.bytedance.android.live.broadcastgame.opengame.view;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/view/VideoChatroomCastIntroDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoChatroomCastIntroDialog extends CommonBottomDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f61279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f61280b;

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog
    public final int getLayoutId() {
        return R.layout.ttlive_dialog_open_game_video_chatroom_cast_intro;
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        int r100 = com.bytedance.android.live.broadcastgame.api.interactgame.n.f59316a;
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_game_screen_share_intro_show", null, new Object[]{Room.class});
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    public VideoChatroomCastIntroDialog(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        StringBuilder r101 = new StringBuilder("https://");
        LiveCommonConstants r102 = LiveCommonConstants.INSTANCE;
        r101.append(r102.getObjectTosPath());
        r101.append("/obj/live-android/ttlive_bg_video_chatroom_game_cast_intro.png");
        this.f61279a = r101.toString();
        this.f61280b = "https://" + r102.getObjectTosPath() + "/obj/live-android/ttlive_bg_equal_chatroom_game_cast_intro.png";
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        ((TextView) findViewById(R.id.user_understand)).setOnClickListener(new e0(this));
        int r101 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
        if (r101 != 12) goto L6;
        M0((HSImageView) findViewById(R.id.cast_image_desc), this.f61280b);
        return;
    L6:
        if (r101 != 8) goto L10;
        M0((HSImageView) findViewById(R.id.cast_image_desc), this.f61279a);
        return;
    }

    public final void M0(HSImageView r100, String r101) {
        if (r100 == null) goto L4;
        r100.setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true).setUri(UriProtector.parse(r101)).build());
    L4:
        if (r100 == null) goto L9;
        GenericDraweeHierarchy r102 = r100.getHierarchy();
        if (r102 == null) goto L10;
        r102.setFailureImage(R.drawable.ttlive_open_game_dialog_img_loading_error);
        return;
    L10:
        return;
    }
}

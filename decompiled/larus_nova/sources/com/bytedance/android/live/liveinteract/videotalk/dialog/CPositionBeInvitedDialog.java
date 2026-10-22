package com.bytedance.android.live.liveinteract.videotalk.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.model.interact.EnlargeGuestInfo;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.network.http.ServiceType;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/dialog/CPositionBeInvitedDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "RoomType", "ShowType", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CPositionBeInvitedDialog extends LiveDialogFragment {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f79115o = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<Integer, View> f79116d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CompositeDisposable f79117e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f79118f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f79119g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f79120h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public h1 f79121i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f79122j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ShowType f79123k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f79124l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public RoomType f79125m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public DataCenter f79126n;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/dialog/CPositionBeInvitedDialog$RoomType;", "", "Video", ServiceType.AUDIO, "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum RoomType extends Enum<RoomType> {
        public static final RoomType Audio = null;
        public static final RoomType Video = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RoomType[] f79127a = null;

        static {
            RoomType r100 = new RoomType("Video", 0);
            Video = r100;
            RoomType r101 = new RoomType(ServiceType.AUDIO, 1);
            Audio = r101;
            f79127a = new RoomType[]{r100, r101};
        }

        public static RoomType valueOf(String r100) {
            return (RoomType) r27.a.a(RoomType.class, r100);
        }

        public static RoomType[] values() {
            return (RoomType[]) f79127a.clone();
        }

        public RoomType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/dialog/CPositionBeInvitedDialog$ShowType;", "", "Invite", "Apply", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum ShowType extends Enum<ShowType> {
        public static final ShowType Apply = null;
        public static final ShowType Invite = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ShowType[] f79128a = null;

        static {
            ShowType r100 = new ShowType("Invite", 0);
            Invite = r100;
            ShowType r101 = new ShowType("Apply", 1);
            Apply = r101;
            f79128a = new ShowType[]{r100, r101};
        }

        public static ShowType valueOf(String r100) {
            return (ShowType) r27.a.a(ShowType.class, r100);
        }

        public static ShowType[] values() {
            return (ShowType[]) f79128a.clone();
        }

        public ShowType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
        public static CPositionBeInvitedDialog a(ShowType r100, long r101, RoomType r102, boolean r103, String r104, h1 r105, DataCenter r106) {
            Intrinsics.checkNotNullParameter(r100, "showType");
            Intrinsics.checkNotNullParameter(r102, "roomType");
            Intrinsics.checkNotNullParameter(r104, "replyToUid");
            Intrinsics.checkNotNullParameter(r105, "msg");
            CPositionBeInvitedDialog r107 = new CPositionBeInvitedDialog();
            r107.f79123k = r100;
            r107.f79118f = r101;
            r107.f79125m = r102;
            r107.f79119g = r103;
            r107.f79120h = r104;
            r107.f79121i = r105;
            r107.f79126n = r106;
            return r107;
        }
    }

    public static final class b implements DialogInterface.OnCancelListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CPositionBeInvitedDialog f79129a;

        public b(CPositionBeInvitedDialog r100) {
            this.f79129a = r100;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r100) {
            CPositionBeInvitedDialog r101 = this.f79129a;
            int r102 = CPositionBeInvitedDialog.f79115o;
            Dialog r103 = r101.getDialog();
            Context r104 = r101.getContext();
            if (r103 == null) goto L17;
            if (r104 == null) goto L21;
            Dialog r105 = r101.getDialog();
            if (r105 == null) goto L18;
            View r106 = r105.getCurrentFocus();
            if (r106 == null) goto L22;
            InputMethodManager r107 = (InputMethodManager) r104.getSystemService("input_method");
            if (r107 != null) goto L14;
            return;
        L14:
            if (r107.isActive() == false) goto L20;
            r107.hideSoftInputFromWindow(r106.getWindowToken(), 0);
            return;
        L20:
            return;
        L22:
            return;
        L18:
            return;
        L21:
            return;
        }
    }

    public static final class c<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CPositionBeInvitedDialog f79130a;

        public c(CPositionBeInvitedDialog r100) {
            this.f79130a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Long r101 = (Long) r100;
            Intrinsics.checkNotNullParameter(r101, "sec");
            return Long.valueOf(((long) this.f79130a.f79122j) - r101.longValue());
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CPositionBeInvitedDialog f79131a;

        public d(CPositionBeInvitedDialog r100) {
            this.f79131a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            ((TextView) this.f79131a.S90(R.id.refuse)).setText(s1.C(R.string.ttlive_interact_refuse_time, new Object[]{Integer.valueOf((int) r101.longValue())}));
            if (r101.longValue() != 0) goto L14;
            this.f79131a.U90(false, true);
            this.f79131a.dismiss();     // Catch: Exception -> L7
            return;
        L7:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r102 = DialogFragmentLancet.sLastShowStack;
            if (r102 == null) goto L15;
            com.bytedance.crash.d.d(r102, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L15:
            return;
        }
    }

    static {
    }

    public CPositionBeInvitedDialog() {
        this.f79116d = new LinkedHashMap();
        this.f79117e = new CompositeDisposable();
        this.f79120h = "";
        this.f79122j = 9;
        this.f79123k = ShowType.Invite;
        this.f79125m = RoomType.Video;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f79117e.dispose();
        if (this.f79124l == true) goto L5;
        U90(false, false);
    L5:
        ((LinkedHashMap) this.f79116d).clear();
    }

    public final View S90(int r100) {
        if (this.f79116d != null) goto L5;
        this.f79116d = new LinkedHashMap();
    L5:
        View r101 = this.f79116d.get(Integer.valueOf(r100));
        if (r101 != null) goto L14;
        View r102 = getView();
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(r100);
        if (r103 == null) goto L12;
        this.f79116d.put(Integer.valueOf(r100), r103);
        return r103;
    L12:
        return null;
    L14:
        return r101;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        Dialog r101 = getDialog();
        if (r101 == null) goto L8;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L9;
        WindowManager.LayoutParams r103 = r102.getAttributes();
        r103.width = -1;
        r103.height = -1;
        r102.setAttributes(r103);
        r102.setBackgroundDrawable(new ColorDrawable(0));
        r102.setGravity(80);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setStyle(1, R.style.ttlive_live_interact_dialog);
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        Dialog r101 = super.onCreateDialog(r100);
        r101.setOnCancelListener(new b(this));
        r101.setCanceledOnTouchOutside(false);
        return r101;
    }

    public final void U90(boolean r100, boolean r110) {
        this.f79124l = true;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r101 = null;
        if (this.f79119g == false) goto L15;
        rj0.k.f537953m2.getClass();
        rj0.k r102 = rj0.k.a.a();
        if (r102 == null) goto L7;
        r101 = r102.getLinkUserInfoCenter();
    L7:
        T90(r100, r110, r101, this.f79120h, this.f79123k);
        if (this.f79125m != RoomType.Video) goto L12;
        rj0.k r111 = rj0.k.a.a();
        if (r111 == null) goto L27;
        r111.replyCPosition(this.f79118f, this.f79120h, r100);
        return;
    L27:
        return;
    L12:
        com.bytedance.android.live.liveinteract.voicechat.d.f80030s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r112 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r112 == null) goto L29;
        r112.replyCPosition(this.f79118f, this.f79120h, r100);
        return;
    L29:
        return;
    L15:
        rj0.l.f537955n2.getClass();
        rj0.l r103 = rj0.l.a.a();
        if (r103 == null) goto L18;
        r101 = r103.getLinkUserInfoCenter();
    L18:
        T90(r100, r110, r101, this.f79120h, this.f79123k);
        if (this.f79125m != RoomType.Video) goto L23;
        rj0.l r113 = rj0.l.a.a();
        if (r113 == null) goto L31;
        r113.replyCPosition(this.f79118f, this.f79120h, r100);
        return;
    L31:
        return;
    L23:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r114 = IVoiceChatGuestService.a.a();
        if (r114 == null) goto L33;
        r114.replyCPosition(this.f79118f, this.f79120h, r100);
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        h1 r112 = this.f79121i;
        py.k r100 = null;
        if (r112 == null) goto L73;
        if (this.f79123k != ShowType.Invite) goto L20;
        com.bytedance.live.datacontext.m<IRoom> r101 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r101 == null) goto L11;
        IRoom r102 = r101.getValue();
        if (r102 == null) goto L11;
        String r103 = r102.getOwnerUserIdString();
    L12:
        com.bytedance.android.livesdk.message.linker.k r113 = r112.getLinkerEnlargeGuestInviteContent();
        if (r113 == null) goto L15;
        String r114 = com.bytedance.android.livesdk.message.linker.l.a(r113);
    L17:
        if ((!Intrinsics.areEqual(r103, r114)) == false) goto L19;
        ((TextView) S90(R.id.invite_description_tv)).setText(R.string.ttlive_talk_room_c_position_admin_invite_title);
        goto L73
    L19:
        ((TextView) S90(R.id.invite_description_tv)).setText(R.string.ttlive_talk_room_c_position_anchor_invite_title);
        goto L73
    L15:
        r114 = null;
    L11:
        r103 = null;
        goto L12
    L20:
        com.bytedance.android.livesdk.message.linker.f r104 = r112.getLinkerEnlargeGuestApplyContent();
        if (r104 == null) goto L23;
        String r105 = r104.getApplyPrompts();
    L24:
        if (r105 != null) goto L26;
    L29:
        boolean r106 = true;
    L30:
        if (r106 == true) goto L32;
        ((TextView) S90(R.id.invite_description_tv)).setText(r105);
        goto L73
    L32:
        com.bytedance.android.livesdk.message.linker.f r115 = r112.getLinkerEnlargeGuestApplyContent();
        if (r115 == null) goto L36;
        String r116 = r115.getFromUidStr();
        if (r116 == null) goto L36;
    L38:
        if (r116.length() != 0) goto L40;
        boolean r107 = true;
    L41:
        if (r107 == false) goto L44;
    L68:
        String r117 = null;
    L69:
        if (r117 != null) goto L71;
        r117 = "用户";
    L71:
        ((TextView) S90(R.id.invite_description_tv)).setText(s1.C(R.string.ttlive_talk_room_c_position_receive_apply_title, new Object[]{r117}));
        goto L73
    L44:
        if (this.f79119g == false) goto L54;
        if (this.f79125m != RoomType.Video) goto L50;
        rj0.k.f537953m2.getClass();
        rj0.k r108 = rj0.k.a.a();
        if (r108 == null) goto L61;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r109 = r108.getLinkUserInfoCenter();
    L62:
        if (r109 == null) goto L68;
        ILinkPlayerInfoBridge r118 = (ILinkPlayerInfoBridge) r109.a5(r116, null);
        if (r118 == null) goto L68;
        IBaseUser r119 = r118.getUser();
        if (r119 == null) goto L68;
        r117 = r119.getNickName();
    L61:
        r109 = null;
        goto L62
    L50:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r120 = IVoiceChatGuestService.a.a();
        if (r120 == null) goto L61;
        r109 = r120.getLinkUserInfoCenter();
        goto L62
    L54:
        if (this.f79125m != RoomType.Video) goto L58;
        rj0.l.f537955n2.getClass();
        rj0.l r121 = rj0.l.a.a();
        if (r121 == null) goto L61;
        r109 = r121.getLinkUserInfoCenter();
        goto L62
    L58:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r122 = IVoiceChatGuestService.a.a();
        if (r122 == null) goto L61;
        r109 = r122.getLinkUserInfoCenter();
        goto L62
    L40:
        r107 = false;
    L36:
        r116 = "";
        goto L38
    L26:
        if (r105.length() == 0) goto L29;
        r106 = false;
        goto L30
    L23:
        r105 = null;
    L73:
        if (this.f79125m != RoomType.Video) goto L102;
        ((HSImageView) S90(R.id.invite_icon_video_img)).setVisibility(0);
        h1 r123 = this.f79121i;
        if (r123 == null) goto L79;
        com.bytedance.android.livesdk.message.linker.k r124 = r123.getLinkerEnlargeGuestInviteContent();
        if (r124 == null) goto L79;
        py.k r125 = r124.getUiImage();
    L81:
        if (r125 == null) goto L88;
        ViewGroup.LayoutParams r126 = ((HSImageView) S90(R.id.invite_icon_video_img)).getLayoutParams();
        r126.width = -1;
        r126.height = UtilityKotlinExtentionsKt.i(188);
        ImageView r127 = (ImageView) S90(R.id.invite_icon_video_img);
        h1 r128 = this.f79121i;
        if (r128 == null) goto L87;
        com.bytedance.android.livesdk.message.linker.k r129 = r128.getLinkerEnlargeGuestInviteContent();
        if (r129 == null) goto L87;
        r100 = r129.getUiImage();
    L87:
        ImageUtil.loadImage(r127, r100, -1, -1, false, 0, ImageView.ScaleType.FIT_CENTER, null);
    L129:
        ((TextView) S90(R.id.refuse)).setOnClickListener(x0.a(new AnonymousClass5(this)));
        ((TextView) S90(R.id.accept)).setOnClickListener(x0.a(new AnonymousClass6(this)));
        ((TextView) S90(R.id.refuse)).setText(s1.C(R.string.ttlive_interact_refuse_time, new Object[]{Integer.valueOf(this.f79122j)}));
        this.f79117e.add(du2.a.d(1, TimeUnit.SECONDS).take(this.f79122j + 1).map(new c(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this)));
        return;
    L88:
        h1 r130 = this.f79121i;
        if (r130 == null) goto L93;
        com.bytedance.android.livesdk.message.linker.f r131 = r130.getLinkerEnlargeGuestApplyContent();
        if (r131 == null) goto L93;
        py.k r132 = r131.getUiImage();
    L94:
        if (r132 == null) goto L101;
        ViewGroup.LayoutParams r133 = ((HSImageView) S90(R.id.invite_icon_video_img)).getLayoutParams();
        r133.width = -1;
        r133.height = UtilityKotlinExtentionsKt.i(188);
        ImageView r134 = (ImageView) S90(R.id.invite_icon_video_img);
        h1 r135 = this.f79121i;
        if (r135 == null) goto L100;
        com.bytedance.android.livesdk.message.linker.f r136 = r135.getLinkerEnlargeGuestApplyContent();
        if (r136 == null) goto L100;
        r100 = r136.getUiImage();
    L100:
        ImageUtil.loadImage(r134, r100, -1, -1, false, 0, ImageView.ScaleType.FIT_CENTER, null);
        goto L129
    L101:
        ((HSImageView) S90(R.id.invite_icon_video_img)).setImageURI("https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_ic_c_position_be_invite.png");
        ViewGroup.LayoutParams r137 = ((HSImageView) S90(R.id.invite_icon_video_img)).getLayoutParams();
        r137.width = UtilityKotlinExtentionsKt.i(158);
        r137.height = UtilityKotlinExtentionsKt.i(134);
    L93:
        r132 = null;
    L79:
        r125 = null;
        goto L81
    L102:
        ((HSImageView) S90(R.id.invite_icon_audio_img)).setVisibility(0);
        h1 r138 = this.f79121i;
        if (r138 == null) goto L107;
        com.bytedance.android.livesdk.message.linker.k r139 = r138.getLinkerEnlargeGuestInviteContent();
        if (r139 == null) goto L107;
        py.k r140 = r139.getUiImage();
    L108:
        if (r140 == null) goto L115;
        ImageView r141 = (ImageView) S90(R.id.invite_icon_audio_img);
        h1 r142 = this.f79121i;
        if (r142 == null) goto L114;
        com.bytedance.android.livesdk.message.linker.k r143 = r142.getLinkerEnlargeGuestInviteContent();
        if (r143 == null) goto L114;
        r100 = r143.getUiImage();
    L114:
        ImageUtil.loadImage(r141, r100, -1, -1, false, 0, ImageView.ScaleType.FIT_CENTER, null);
        goto L129
    L115:
        h1 r144 = this.f79121i;
        if (r144 == null) goto L120;
        com.bytedance.android.livesdk.message.linker.f r145 = r144.getLinkerEnlargeGuestApplyContent();
        if (r145 == null) goto L120;
        py.k r146 = r145.getUiImage();
    L121:
        if (r146 == null) goto L128;
        ImageView r147 = (ImageView) S90(R.id.invite_icon_audio_img);
        h1 r148 = this.f79121i;
        if (r148 == null) goto L127;
        com.bytedance.android.livesdk.message.linker.f r149 = r148.getLinkerEnlargeGuestApplyContent();
        if (r149 == null) goto L127;
        r100 = r149.getUiImage();
    L127:
        ImageUtil.loadImage(r147, r100, -1, -1, false, 0, ImageView.ScaleType.FIT_CENTER, null);
        goto L129
    L128:
        ((HSImageView) S90(R.id.invite_icon_audio_img)).setImageURI("https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_ic_c_position_audio_be_invite.png");
    L120:
        r146 = null;
    L107:
        r140 = null;
        goto L108
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_dialog_video_talk_c_position_invited, r101);
    }

    public final void T90(boolean r110, boolean r111, com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r112, String r113, ShowType r114) {
        i0 r100 = TalkRoomLogUtils.f77433a;
        TalkRoomLogUtils.E();
        Integer r101 = null;
        if (r112 == null) goto L33;
        Iterable r102 = r112.getOnlineUserList();
        if (r102 == null) goto L33;
        Iterable r103 = r102;
        if ((r103 instanceof Collection) == true) goto L9;
    L11:
        Iterator r104 = r103.iterator();
    L13:
        if (r104.hasNext() == false) goto L33;
        ILinkPlayerInfoBridge r105 = (ILinkPlayerInfoBridge) r104.next();
        if (r105.isEnlarged() == false) goto L31;
        IBaseUser r106 = r105.getUser();
        if (r106 == null) goto L19;
        String r107 = r106.getIdString();
    L20:
        o r108 = com.bytedance.android.live.liveinteract.api.utils.m.n(null, Long.valueOf(this.f79118f), 1);
        if (r108 == null) goto L27;
        com.bytedance.live.datacontext.m<IRoom> r109 = r108.getRoom();
        if (r109 == null) goto L27;
        IRoom r115 = r109.getValue();
        if (r115 == null) goto L27;
        String r116 = r115.getOwnerUserIdString();
    L29:
        if (Intrinsics.areEqual(r107, r116) == false) goto L31;
        boolean r117 = true;
    L32:
        if (r117 == false) goto L13;
    L27:
        r116 = null;
        goto L29
    L19:
        r107 = null;
    L31:
        r117 = false;
        goto L32
    L9:
        if (((Collection) r103).isEmpty() == false) goto L11;
    L33:
        if (r112 == null) goto L36;
        je0.d.j(r112);
    L36:
        if (r114 != ShowType.Invite) goto L42;
        h1 r118 = this.f79121i;
        if (r118 == null) goto L47;
        com.bytedance.android.livesdk.message.linker.k r119 = r118.getLinkerEnlargeGuestInviteContent();
        if (r119 == null) goto L47;
        r101 = Integer.valueOf(r119.getTargetEnlargeGuestType());
    L47:
        if (r101 == null) goto L49;
        int r120 = r101.intValue();
    L51:
        if (r120 != EnlargeGuestInfo.EnlargeGuestType.EnlargeGuestType_Double.ordinal()) goto L53;
        boolean r121 = true;
    L54:
        TalkRoomLogUtils.B.d0(r110, r111, r113, r114, r121, this.f79126n);
        return;
    L53:
        r121 = false;
        goto L54
    L49:
        r120 = EnlargeGuestInfo.EnlargeGuestType.EnlargeGuestType_Unkown.ordinal();
        goto L51
    L42:
        h1 r122 = this.f79121i;
        if (r122 == null) goto L47;
        com.bytedance.android.livesdk.message.linker.f r123 = r122.getLinkerEnlargeGuestApplyContent();
        if (r123 == null) goto L47;
        r101 = Integer.valueOf(r123.getTargetEnlargeGuestType());
        goto L47
    }
}

package com.bytedance.android.live.liveinteract.digitavatar.videoavatar;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.digitavatar.AvatarGender;
import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarContext;
import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarMsgController;
import com.bytedance.android.live.liveinteract.digitavatar.c0;
import com.bytedance.android.live.liveinteract.digitavatar.y;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;
import com.bytedance.live.bizlink.api.platform.status.common.LinkBizApiLocalException;
import com.larus.nova.R;
import io.reactivex.disposables.CompositeDisposable;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f72731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f72732b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public VideoShowMode f72733c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f72734d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.live.liveinteract.digitavatar.h f72735e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f72736f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AvatarGender f72737g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AvatarGender f72738h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f72739i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f72740j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f72741k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public VideoShowMode f72742l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f72743m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final DigitAvatarMsgController f72744n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final com.bytedance.android.live.effect.api.o f72745o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final j1 f72746p;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f72747a;

        public a(o r100) {
            this.f72747a = r100;
        }

        @Override // com.bytedance.android.livesdk.app.dataholder.Observer
        public final void onChanged(Object r100) {
            Integer r101 = (Integer) r100;
            if (r101 != null) goto L6;
        L7:
            this.f72747a.c(VideoShowMode.AUDIO);
        L8:
            o r102 = this.f72747a;
            if (r101 != null) goto L12;
        L14:
            boolean r103 = false;
        L16:
            if (r102.f72743m == r103) goto L26;
            r102.f72743m = r103;
            if (r103 == false) goto L24;
            DigitAvatarContext r104 = DigitAvatarContext.Companion.getContext();
            if (r104 == null) goto L24;
            com.bytedance.live.datacontext.m<Boolean> r105 = r104.getUsedAvatarThisLinkRound();
            if (r105 == null) goto L24;
            r105.setValue(Boolean.FALSE);
        L24:
            r102.e(r102.f72742l, true, null, "online");
            return;
        L26:
            return;
        L12:
            if (r101.intValue() != 2) goto L14;
            r103 = true;
            goto L16
        L6:
            if (r101.intValue() == 2) goto L8;
            goto L7
        }
    }

    public static final class b implements lg6.a<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f72748a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Sticker f72749b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AvatarGender f72750c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ VideoShowMode f72751d;

        @Override // lg6.a
        public final void a(Unit r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.f72748a.f72745o.a("livedigitavatar", this.f72749b, "VideoShowModeProcessor_startAvatarModeInner_onSuccess");
            DigitAvatarContext.a r101 = DigitAvatarContext.Companion;
            DigitAvatarContext r102 = r101.getContext();
            if (r102 == null) goto L30;
            com.bytedance.live.datacontext.m<com.bytedance.android.live.liveinteract.digitavatar.n> r103 = r102.getDigitAvatar();
            if (r103 == null) goto L30;
            com.bytedance.android.live.liveinteract.digitavatar.n r104 = r103.getValue();
            if (r104 == null) goto L30;
            ALogger.i("KtvDigitAvatar", "avatar形象审核情况：audited=" + r104.f72679e + ",auditOk=" + r104.f72677c + ", avatarData=" + r104.f72678d + ' ');
            String r105 = r104.f72678d;
            if (r104.f72677c == false) goto L19;
            if (r105 != null) goto L12;
        L15:
            boolean r106 = true;
        L16:
            if (r106 == true) goto L19;
            ALogger.i("KtvDigitAvatar", "等待avatar演唱道具ready");
            this.f72748a.getClass();
            this.f72748a.f72732b = r105;
            goto L30
        L12:
            if (r105.length() == 0) goto L15;
            r106 = false;
        L19:
            if (r104.f72675a == true) goto L30;
            if (r105 != null) goto L22;
        L25:
            boolean r107 = true;
        L26:
            if (r107 == true) goto L30;
            if (r104.f72679e == true) goto L30;
            f2.b(R.string.ttlive_ktv_avatar_auditing_use_default_tips, 0);
            goto L30
        L22:
            if (r105.length() == 0) goto L25;
            r107 = false;
        L30:
            this.f72748a.f72738h = this.f72750c;
            o.g(true);
            DigitAvatarContext r108 = r101.getContext();
            if (r108 == null) goto L35;
            com.bytedance.live.datacontext.m<Boolean> r109 = r108.getUsedAvatarThisLinkRound();
            if (r109 == null) goto L35;
            r109.setValue(Boolean.TRUE);
        L35:
            this.f72748a.b(this.f72750c);
            this.f72748a.f72740j = System.currentTimeMillis();
            DigitAvatarContext r110 = r101.getContext();
            if (r110 == null) goto L38;
            DigitAvatarContext.setVideoShowMode$default(r110, VideoShowMode.DIGIT_AVATAR, null, 2, null);
        L38:
            DigitAvatarContext r111 = r101.getContext();
            if (r111 == null) goto L44;
            com.bytedance.live.datacontext.k<d> r112 = r111.getSetVideoShowModeResult();
            if (r112 == null) goto L45;
            r112.post(new d(this.f72751d, VideoShowMode.DIGIT_AVATAR, true));
            return;
        L45:
            return;
        }

        @Override // lg6.a
        public final void onFailed(Exception r100) {
            Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
            StringBuilder r101 = new StringBuilder("show mode 切换失败，from=");
            r101.append(this.f72751d);
            r101.append(", to=");
            VideoShowMode r102 = VideoShowMode.DIGIT_AVATAR;
            r101.append(r102);
            ALogger.e("KtvDigitAvatar", r101.toString(), r100);
            int r103 = x.f77572a;
            x.i(r102.name(), r100);
            TalkRoomBusinessFullLinkMonitor r104 = TalkRoomBusinessFullLinkMonitor.f71456a;
            String r105 = r102.name();
            r104.getClass();
            TalkRoomBusinessFullLinkMonitor.n(r105, r100);
            this.f72748a.getClass();
            if ((r100 instanceof LinkBizApiLocalException) == true) goto L5;
        L7:
            DigitAvatarContext.a r106 = DigitAvatarContext.Companion;
            DigitAvatarContext r107 = r106.getContext();
            if (r107 == null) goto L10;
            r107.setIsDigitAvatarLoading(false);
        L10:
            o r108 = this.f72748a;
            r108.f72742l = this.f72751d;
            DigitAvatarContext r109 = r106.getContext();
            if (r109 == null) goto L13;
            DigitAvatarContext.setVideoShowMode$default(r109, this.f72748a.f72733c, null, 2, null);
        L13:
            this.f72748a.f72745o.b("livedigitavatar", "VideoShowModeProcessor_startAvatarModeInner_onError");
            DigitAvatarContext r110 = r106.getContext();
            if (r110 == null) goto L19;
            com.bytedance.live.datacontext.k<d> r111 = r110.getSetVideoShowModeResult();
            if (r111 == null) goto L20;
            r111.post(new d(this.f72751d, r102, false));
            return;
        L20:
            return;
        L19:
            return;
        L5:
            if (((LinkBizApiLocalException) r100).getErrorCode() != (-10)) goto L7;
            f2.b(R.string.ttlive_interact_camera_toofast, 0);
            goto L7
        }

        public b(o r100, Sticker r101, AvatarGender r102, com.bytedance.android.live.liveinteract.digitavatar.videoavatar.b r103, VideoShowMode r104) {
            this.f72748a = r100;
            this.f72749b = r101;
            this.f72750c = r102;
            this.f72751d = r104;
        }
    }

    public static final class c implements lg6.a<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f72752a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ VideoShowMode f72753b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ VideoShowMode f72754c;

        @Override // lg6.a
        public final void a(Unit r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.f72752a.f72745o.b("livedigitavatar", "VideoShowModeProcessor_startUseNonDigitAvatarMode_onSuccess");
            this.f72752a.getClass();
            o.g(false);
            this.f72752a.a();
            DigitAvatarContext.a r101 = DigitAvatarContext.Companion;
            DigitAvatarContext r102 = r101.getContext();
            if (r102 == null) goto L5;
            DigitAvatarContext.setVideoShowMode$default(r102, this.f72753b, null, 2, null);
        L5:
            DigitAvatarContext r103 = r101.getContext();
            if (r103 == null) goto L11;
            com.bytedance.live.datacontext.k<d> r104 = r103.getSetVideoShowModeResult();
            if (r104 == null) goto L12;
            r104.post(new d(this.f72754c, this.f72753b, true));
            return;
        L12:
            return;
        }

        @Override // lg6.a
        public final void onFailed(Exception r100) {
            Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
            ALogger.e("KtvDigitAvatar", "show mode 切换失败，from=" + this.f72754c + ", to=" + this.f72753b, r100);
            int r101 = x.f77572a;
            x.i(this.f72753b.name(), r100);
            TalkRoomBusinessFullLinkMonitor r102 = TalkRoomBusinessFullLinkMonitor.f71456a;
            String r103 = this.f72753b.name();
            r102.getClass();
            TalkRoomBusinessFullLinkMonitor.n(r103, r100);
            this.f72752a.getClass();
            if ((r100 instanceof LinkBizApiLocalException) == true) goto L5;
        L7:
            this.f72752a.f72742l = this.f72754c;
            DigitAvatarContext.a r104 = DigitAvatarContext.Companion;
            DigitAvatarContext r105 = r104.getContext();
            if (r105 == null) goto L10;
            DigitAvatarContext.setVideoShowMode$default(r105, this.f72754c, null, 2, null);
        L10:
            DigitAvatarContext r106 = r104.getContext();
            if (r106 == null) goto L16;
            com.bytedance.live.datacontext.k<d> r107 = r106.getSetVideoShowModeResult();
            if (r107 == null) goto L17;
            r107.post(new d(this.f72754c, this.f72753b, false));
            return;
        L17:
            return;
        L16:
            return;
        L5:
            if (((LinkBizApiLocalException) r100).getErrorCode() != (-10)) goto L7;
            f2.b(R.string.ttlive_interact_camera_toofast, 0);
            goto L7
        }

        public c(o r100, VideoShowMode r101, com.bytedance.android.live.liveinteract.digitavatar.videoavatar.b r102, VideoShowMode r103) {
            this.f72752a = r100;
            this.f72753b = r101;
            this.f72754c = r103;
        }
    }

    public final void a() {
        if (this.f72740j <= 0) goto L6;
        long r100 = System.currentTimeMillis() - this.f72740j;
        int r101 = com.bytedance.android.live.liveinteract.digitavatar.x.f72760a;
        boolean r102 = this.f72741k;
        LinkedHashMap r103 = new LinkedHashMap();
        com.bytedance.android.live.liveinteract.digitavatar.x.c(r103, r102);
        r103.put("duration", String.valueOf(r100));
        j0.l().sendLog("livesdk_anchor_audinece_connection_avatar_model_duration", r103, new Object[]{am2.x.class, IRoom.class});
        this.f72740j = 0;
        return;
    }

    public static void g(boolean r100) {
        DigitAvatarContext r101 = DigitAvatarContext.Companion.getContext();
        if (r101 == null) goto L10;
        com.bytedance.live.datacontext.m<Boolean> r102 = r101.getCurrentUsingDigitAvatarInVideoTalkRoom();
        if (r102 != null) goto L7;
        return;
    L7:
        if (r102.getValue().booleanValue() == r100) goto L12;
        r102.setValue(Boolean.valueOf(r100));
        return;
    L12:
        return;
    }

    public final void b(AvatarGender r100) {
        if (this.f72741k == true) goto L5;
    L8:
        boolean r101 = true;
    L9:
        this.f72734d.getClass();
        this.f72734d.b(r100, r101);
        return;
    L5:
        if (je0.d.f() == 12) goto L8;
        r101 = false;
        goto L9
    }

    public final void c(VideoShowMode r100) {
        this.f72733c = r100;
        DigitAvatarContext r101 = DigitAvatarContext.Companion.getContext();
        if (r101 == null) goto L6;
        r101.setLastVideoShowMode(r100);
        return;
    }

    public final void e(VideoShowMode r100, boolean r101, com.bytedance.android.live.liveinteract.digitavatar.videoavatar.b r110, String r111) {
        if (this.f72743m == true) goto L6;
        g(false);
        return;
    L6:
        ALogger.i("KtvDigitAvatar", "start show mode: " + r100);
        int r102 = n.f72730a[r100.ordinal()];
        if (r102 != 1) goto L9;
        VideoShowMode r103 = this.f72733c;
        DigitAvatarContext r104 = DigitAvatarContext.Companion.getContext();
        if (r104 == null) goto L31;
        com.bytedance.live.datacontext.m<com.bytedance.android.live.liveinteract.digitavatar.n> r105 = r104.getDigitAvatar();
        if (r105 == null) goto L31;
        com.bytedance.android.live.liveinteract.digitavatar.n r106 = r105.getValue();
        if (r106 == null) goto L31;
        AvatarGender r107 = r106.f72676b;
        if (r107 == null) goto L31;
    L32:
        AvatarGender r108 = r107;
        Sticker r109 = (Sticker) ((LinkedHashMap) y.f72761a).get(r108);
        if (r109 == null) goto L35;
        this.f72736f = false;
        d(r108, r109, r103, r101, r110, r111);
        return;
    L35:
        ALogger.w("KtvDigitAvatar", "使用avatar展示模式，but形象道具还未下载好, so等待avatar下载完成");
        f2.b(R.string.ttlive_ktv_avatar_downloading_when_song, 0);
        this.f72736f = true;
        this.f72737g = r108;
        return;
    L31:
        r107 = c0.b();
        goto L32
    L9:
        if (r102 != 2) goto L11;
        f(r100, this.f72733c, r101, r110, r111);
        return;
    L11:
        if (r102 == 3) goto L14;
        return;
    L14:
        if (this.f72741k == true) goto L16;
    L21:
        f(r100, this.f72733c, r101, r110, r111);
        return;
    L16:
        if (aj0.a.d() == true) goto L18;
    L20:
        f2.b(R.string.ttlive_digit_avatar_anchor_no_support_show_mode_audio, 0);
        ALogger.e("KtvDigitAvatar", "anchor no support show mode: " + r100);
        return;
    L18:
        if (aj0.a.b(o3.f().getCurrentRoom()) == false) goto L20;
        goto L20
    }

    public final void f(VideoShowMode r100, VideoShowMode r101, boolean r102, com.bytedance.android.live.liveinteract.digitavatar.videoavatar.b r103, String r104) {
        if (jc0.a.c() == false) goto L6;
        ALogger.i("KtvDigitAvatar", "video chorus can not switch mode");
        return;
    L6:
        cg6.a r105 = (cg6.a) this.f72746p.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r105 == null) goto L16;
        jg6.a r106 = r105.e5();
        if (r106 == null) goto L17;
        lh6.b r107 = r106.a();
        if (r107 == null) goto L18;
        if (r104 != null) goto L14;
        r104 = "startUseNonDigitAvatarMode";
    L14:
        r107.h(r100, r104, r102, new c(this, r100, r103, r101));
        return;
    L18:
        return;
    L17:
        return;
    }

    public o(boolean r100, VideoShowMode r101, boolean r102, DigitAvatarMsgController r103, com.bytedance.android.live.effect.api.o r104, j1 r105) {
        Intrinsics.checkNotNullParameter(r101, "showMode");
        Intrinsics.checkNotNullParameter(r103, "avatarMsgController");
        Intrinsics.checkNotNullParameter(r104, "stickerComposerManager");
        Intrinsics.checkNotNullParameter(r105, "scopeProvider");
        this.f72741k = r100;
        this.f72742l = r101;
        this.f72743m = r102;
        this.f72744n = r103;
        this.f72745o = r104;
        this.f72746p = r105;
        this.f72731a = new CompositeDisposable();
        this.f72733c = this.f72742l;
        this.f72734d = new e(r103, r100, true);
        this.f72735e = new com.bytedance.android.live.liveinteract.digitavatar.h(r103, r100);
        AvatarGender r106 = AvatarGender.Male;
        this.f72737g = r106;
        this.f72738h = r106;
        this.f72739i = new a(this);
    }

    public final void d(AvatarGender r110, Sticker r111, VideoShowMode r112, boolean r113, com.bytedance.android.live.liveinteract.digitavatar.videoavatar.b r114, String r115) {
        ALogger.i("KtvDigitAvatar", "开始使用avatar进行演唱");
        cg6.a r100 = (cg6.a) this.f72746p.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r100 == null) goto L13;
        jg6.a r101 = r100.e5();
        if (r101 == null) goto L14;
        lh6.b r102 = r101.a();
        if (r102 == null) goto L15;
        VideoShowMode r103 = VideoShowMode.DIGIT_AVATAR;
        if (r115 != null) goto L11;
        r115 = "startAvatarModeInner";
    L11:
        r102.h(r103, r115, r113, new b(this, r111, r110, r114, r112));
        return;
    L15:
        return;
    L14:
        return;
    }
}

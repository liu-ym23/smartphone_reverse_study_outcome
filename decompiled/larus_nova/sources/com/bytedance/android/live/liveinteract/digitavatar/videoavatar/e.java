package com.bytedance.android.live.liveinteract.digitavatar.videoavatar;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.digitavatar.AvatarGender;
import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarContext;
import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarMsgController;
import com.bytedance.android.live.liveinteract.digitavatar.c0;
import com.bytedance.android.livesdk.message.model.zf;
import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import com.bytedance.android.livesdkapi.model.VideoDigitAvatarBgConfig;
import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.io.File;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

/* JADX INFO: loaded from: classes46.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DownloadTask f72715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f72716b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f72717c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f72718d;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f72719a;

        public a(e r100) {
            this.f72719a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.android.livesdk.chatroom.viewmodel.j r101 = (com.bytedance.android.livesdk.chatroom.viewmodel.j) r100;
            e r102 = this.f72719a;
            r102.getClass();
            int r103 = je0.d.f();
            if (r102.f72717c == r103) goto L26;
            ALogger.i("KtvDigitAvatar", "video talk scene change: " + r102.f72717c + " -> " + r103);
            r102.f72717c = r103;
            if (r102.f72718d == false) goto L27;
            DigitAvatarContext.a r104 = DigitAvatarContext.Companion;
            DigitAvatarContext r105 = r104.getContext();
            if (r105 == null) goto L9;
            VideoShowMode r106 = r105.getCurrentVideoShowMode();
        L11:
            if (r106 != VideoShowMode.DIGIT_AVATAR) goto L28;
            DigitAvatarContext r107 = r104.getContext();
            if (r107 == null) goto L20;
            com.bytedance.live.datacontext.m<com.bytedance.android.live.liveinteract.digitavatar.n> r108 = r107.getDigitAvatar();
            if (r108 == null) goto L20;
            com.bytedance.android.live.liveinteract.digitavatar.n r109 = r108.getValue();
            if (r109 == null) goto L20;
            AvatarGender r110 = r109.f72676b;
            if (r110 == null) goto L20;
        L22:
            if (r102.f72717c == 8) goto L24;
            r102.b(r110, true);
            return;
        L24:
            r102.b(r110, false);
            return;
        L20:
            r110 = c0.b();
            goto L22
        L28:
            return;
        L9:
            r106 = null;
            goto L11
        L27:
            return;
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f72720a = null;

        static {
            f72720a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    public static final class c {
    }

    static {
    }

    public static String a(String r100) {
        StringBuilder r101 = new StringBuilder();
        String r102 = zf.a(r100.getBytes());     // Catch: Exception -> L5
    L7:
        r101.append(r102);
        r101.append(RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT);
        return r101.toString();
    L5:
        e = move-exception;
        e.printStackTrace();
        r102 = null;
        goto L7
    }

    public final void b(AvatarGender r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "gender");
        ALogger.i("KtvDigitAvatar", "loadBgAndSend： " + r100 + ", useSmallBg=" + r101);
        VideoDigitAvatarBgConfig r102 = (VideoDigitAvatarBgConfig) vm2.d.f555810d3.getValue(null, vm2.d.f555776a[209(0xd1, float:2.93E-43)]);
        if (r101 == false) goto L6;
        String r103 = (String) ListProtector.get(r102.getSmallBgList(), Random.Default.nextInt(r102.getSmallBgList().size()));
    L9:
        String r104 = com.bytedance.android.live.liveinteract.digitavatar.l.f72649a;
        File r105 = s1.getContext().getExternalCacheDir();
        String r106 = com.bytedance.android.live.liveinteract.digitavatar.l.f72651c;
        PolarisFileWrapper r107 = new PolarisFileWrapper(r105, r106);
        if (r107.exists() == true) goto L13;
        r107.mkdirs();
    L13:
        if (new PolarisFileWrapper(r107, a(r103)).exists() == true) goto L23;
        ALogger.i("KtvDigitAvatar", "download image： " + r103);
        String r108 = a(r103);
        DownloadTask r109 = this.f72715a;
        if (r109 == null) goto L18;
        r109.subThreadListener(null);
    L18:
        DownloadTask r110 = Downloader.with(s1.getContext()).url(r103).name(r108);
        PolarisFileWrapper r111 = new PolarisFileWrapper(s1.getContext().getExternalCacheDir(), r106);
        if (r111.exists() == true) goto L21;
        r111.mkdirs();
    L21:
        DownloadTask r112 = r110.savePath(r111.getAbsolutePath()).monitorScene("live_video_talk_room_digit_avatar").subThreadListener(new f(this));
        r112.download();
        Unit r113 = Unit.INSTANCE;
        this.f72715a = r112;
        return;
    L23:
        return;
    L6:
        if (r100 != AvatarGender.Female) goto L8;
        r103 = r102.getFemaleBg();
        goto L9
    L8:
        r103 = r102.getMaleBg();
        goto L9
    }

    public e(DigitAvatarMsgController r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "effectMsgController");
        this.f72718d = r101;
        CompositeDisposable r103 = new CompositeDisposable();
        this.f72716b = r103;
        this.f72717c = je0.d.f();
        if (r102 == false) goto L14;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.viewmodel.e> r104 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r104 == null) goto L15;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r105 = r104.getValue();
        if (r105 == null) goto L16;
        BehaviorSubject r106 = r105.a();
        if (r106 == null) goto L17;
        Disposable r107 = r106.subscribe(new a(this), b.f72720a);
        if (r107 == null) goto L18;
        r103.add(r107);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }
}

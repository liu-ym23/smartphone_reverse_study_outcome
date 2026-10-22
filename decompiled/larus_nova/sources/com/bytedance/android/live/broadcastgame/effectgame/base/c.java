package com.bytedance.android.live.broadcastgame.effectgame.base;

import com.bytedance.android.live.broadcastgame.api.model.r;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.k;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import java.io.File;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f59609a = 0;

    public interface a {
        void a(String r100, Sticker r101);

        void b(String r100, ExceptionResult r101);
    }

    public interface b {
        void onFail(ExceptionResult r100);

        void onSuccess(List<Sticker> r100);
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.effectgame.base.c$c, reason: collision with other inner class name */
    public static final class C0980c implements k.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f59610a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f59611b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Sticker f59612c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ SafeThreadEffectFetchCallBackDelegate f59613d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.live.broadcastgame.effectgame.base.a f59614e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Sticker f59615f;

        @Override // com.bytedance.android.live.effect.api.k.f
        public final void O1(String r100, Sticker r101) {
            StringBuilder r102 = new StringBuilder("[");
            r102.append(this.f59610a);
            r102.append("]download success panel: ");
            r102.append(r100);
            r102.append(" sticker: ");
            if (r101 == null) goto L5;
            String r103 = r101.getName();
        L6:
            r102.append(r103);
            ALogger.i("EffectResourceLoadUtils", r102.toString());
            if (r101 == null) goto L13;
            Sticker r104 = this.f59612c;
            int r105 = c.f59609a;
            Intrinsics.checkNotNullParameter(r101, "sticker");
            List<String> r106 = LiveEffectContext.f66734h;
            r104.setDownloaded(LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).b().r().q(r101));
            SafeThreadEffectFetchCallBackDelegate r107 = this.f59613d;
            if (r107 == null) goto L11;
            r107.a(1, false, this.f59611b, this.f59612c);
        L11:
            c.c(this.f59612c, this.f59613d);
            return;
        L13:
            return;
        L5:
            r103 = null;
            goto L6
        }

        @Override // com.bytedance.android.live.effect.api.k.f
        public final void Z(String r100, Sticker r101) {
            StringBuilder r102 = new StringBuilder("[");
            r102.append(this.f59610a);
            r102.append("]download start sticker: ");
            if (r101 == null) goto L5;
            String r103 = r101.getName();
        L6:
            r102.append(r103);
            ALogger.i("EffectResourceLoadUtils", r102.toString());
            if (this.f59611b != 1) goto L14;
            Sticker r104 = this.f59612c;
            if (r104 == null) goto L15;
            SafeThreadEffectFetchCallBackDelegate r105 = this.f59613d;
            if (r105 == null) goto L16;
            r105.c(1, r104);
            return;
        L16:
            return;
        L15:
            return;
        L14:
            return;
        L5:
            r103 = null;
            goto L6
        }

        @Override // com.bytedance.android.live.effect.api.k.g
        public final void onProgress(int r100, long r101) {
            SafeThreadEffectFetchCallBackDelegate r102 = this.f59613d;
            if (r102 == null) goto L6;
            r102.b(1, r100, r101, this.f59615f);
            return;
        }

        @Override // com.bytedance.android.live.effect.api.k.f
        public final void z0(String r100, Sticker r101, ExceptionResult r102) {
            StringBuilder r103 = new StringBuilder("[");
            r103.append(this.f59610a);
            r103.append("]download fail panel[");
            r103.append(this.f59611b);
            r103.append("]: ");
            r103.append(r100);
            r103.append(" sticker: ");
            if (r101 == null) goto L5;
            String r104 = r101.getName();
        L6:
            r103.append(r104);
            ALogger.e("EffectResourceLoadUtils", r103.toString());
            int r105 = this.f59611b;
            if (r105 < 3) goto L11;
            SafeThreadEffectFetchCallBackDelegate r106 = this.f59613d;
            if (r106 == null) goto L13;
            r106.d(1, this.f59612c, r102);
            return;
        L13:
            return;
        L11:
            int r107 = c.f59609a;
            c.b(this.f59612c, r105 + 1, this.f59614e);
            return;
        L5:
            r104 = null;
            goto L6
        }

        public C0980c(long r100, int r101, Sticker r102, SafeThreadEffectFetchCallBackDelegate r103, com.bytedance.android.live.broadcastgame.effectgame.base.a r104, Sticker r105) {
            this.f59610a = r100;
            this.f59611b = r101;
            this.f59612c = r102;
            this.f59613d = r103;
            this.f59614e = r104;
            this.f59615f = r105;
        }
    }

    public static final class d extends AbsDownloadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.live.broadcastgame.effectgame.base.a f59616a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Sticker f59617b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f59618c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f59619d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f59620e;

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onProgress(DownloadInfo r100) {
            super.onProgress(r100);
            if (r100 == null) goto L8;
            int r101 = (int) ((r100.getCurBytes() / r100.getTotalBytes()) * 100);
            com.bytedance.android.live.broadcastgame.effectgame.base.a r102 = this.f59616a;
            if (r102 == null) goto L9;
            r102.b(2, r101, r100.getTotalBytes(), this.f59617b);
            return;
        L9:
            return;
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onStart(DownloadInfo r100) {
            super.onStart(r100);
            com.bytedance.android.live.broadcastgame.effectgame.base.a r101 = this.f59616a;
            if (r101 == null) goto L6;
            r101.c(2, this.f59617b);
            return;
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onSuccessed(DownloadInfo r100) {
            super.onSuccessed(r100);
            if (r100 == null) goto L15;
            String r101 = r100.getTargetFilePath();
            if (r101 == null) goto L15;
            if (StringsKt.isBlank(r101) == false) goto L9;
            boolean r102 = true;
        L10:
            if (r102 == true) goto L15;
            FileUtils.unZipFolder(r101, this.f59618c + "_zip");     // Catch: Exception -> L13
            new PolarisFileWrapper(r101).delete();     // Catch: Exception -> L13
            new PolarisFileWrapper(this.f59618c + "_zip").renameTo(new PolarisFileWrapper(this.f59618c));     // Catch: Exception -> L13
        L13:
            e = move-exception;
            ALogger.e("EffectResourceLoadUtils unZipFolder", e);
            goto L15
        L9:
            r102 = false;
        L15:
            com.bytedance.android.live.broadcastgame.effectgame.base.a r103 = this.f59616a;
            if (r103 == null) goto L21;
            r103.a(2, false, this.f59619d, this.f59617b);
            return;
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public final void onFailed(DownloadInfo r100, BaseException r101) {
            super.onFailed(r100, r101);
            int r102 = this.f59619d;
            if (r102 < 3) goto L7;
            ExceptionResult r103 = new ExceptionResult(-1, r101);
            com.bytedance.android.live.broadcastgame.effectgame.base.a r104 = this.f59616a;
            if (r104 == null) goto L8;
            r104.d(2, this.f59617b, r103);
        L8:
            if (r100 == null) goto L14;
            String r105 = r100.getTargetFilePath();
            if (r105 == null) goto L14;
            if (StringsKt.isBlank(r105) != true) goto L14;
            new PolarisFileWrapper(r100.getTargetFilePath()).delete();
        L14:
            ALogger.e("EffectResourceLoadUtils", "count: " + this.f59619d + ' ' + r101);
            return;
        L7:
            int r106 = c.f59609a;
            c.e(this.f59617b, this.f59618c, this.f59620e, r102 + 1, this.f59616a);
            goto L8
        }

        public d(com.bytedance.android.live.broadcastgame.effectgame.base.a r100, Sticker r101, String r102, int r103, String r104) {
            this.f59616a = r100;
            this.f59617b = r101;
            this.f59618c = r102;
            this.f59619d = r103;
            this.f59620e = r104;
        }
    }

    static {
    }

    public static String d(String r100) {
        int r101 = StringsKt.lastIndexOf$default(r100, ".", 0, false, 6, null);
        if (r101 == (-1)) goto L10;
        if (r100 == null) goto L9;
        return r100.substring(0, r101);
    L9:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L10:
        return r100;
    }

    public static void a(Sticker r100, r r101) {
        Intrinsics.checkNotNullParameter(r100, "sticker");
        Intrinsics.checkNotNullParameter(r101, "gameExtra");
        Intrinsics.checkNotNullParameter(r100, "sticker");
        List<String> r102 = LiveEffectContext.f66734h;
        r100.setDownloaded(LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).b().r().q(r100));
        Unit r103 = Unit.INSTANCE;
        r101.f59368a = r100;
        Sticker.EffectGameInfo r104 = r100.getGameInfo();
        r104.setGuide_show_count(r101.t());
        r104.setLoadgame_when_guide(r101.v());
        r104.setNeed_beat(r101.y());
        r104.setNeed_bgmusic(r101.z());
        r104.setSupport_mode(r101.J());
        r104.setSupport_effect_mix_stream(r101.I());
        String r105 = r100.getGameInfo().getGuide_url();
        boolean r106 = true;
        if (r105 != null) goto L5;
    L8:
        boolean r107 = true;
    L9:
        if (r107 == true) goto L11;
        r100.getGameInfo().setGuide_res_path(r100.getUnzipPath() + File.separator + d(r100.getGameInfo().getGuide_name()));
    L11:
        List<String> r108 = r101.L();
        if (r108 != null) goto L14;
    L17:
        boolean r109 = true;
    L18:
        if (r109 == true) goto L32;
        String r110 = r101.s();
        if (r110 != null) goto L22;
    L25:
        if (r106 == true) goto L33;
        String r111 = r101.s();
        Intrinsics.checkNotNull(r111);
        r104.setGuide_name(r111);
        List<String> r112 = r101.L();
        if (r112 == null) goto L29;
        String r113 = (String) ListProtector.get(r112, 0);
    L30:
        r104.setGuide_url(Intrinsics.stringPlus(r113, r104.getGuide_name()));
        return;
    L29:
        r113 = null;
        goto L30
    L33:
        return;
    L22:
        if (StringsKt.isBlank(r110) == true) goto L25;
        r106 = false;
        goto L25
    L32:
        return;
    L14:
        if (r108.isEmpty() == true) goto L17;
        r109 = false;
        goto L18
    L5:
        if (StringsKt.isBlank(r105) == true) goto L8;
        r107 = false;
        goto L9
    }

    public static void c(Sticker r100, SafeThreadEffectFetchCallBackDelegate r101) {
        String r102 = r100.getGameInfo().getGuide_url();
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L10:
        if (r103 == true) goto L16;
        String r104 = r100.getGameInfo().getGuide_name();
        String r105 = r100.getUnzipPath() + File.separator + d(r104);
        r100.getGameInfo().setGuide_res_path(r105);
        if (new PolarisFileWrapper(r105).exists() == true) goto L14;
        e(r100, r105, r104, 1, r101);
        return;
    L14:
        if (r101 == null) goto L20;
        r101.a(2, true, 1, r100);
        return;
    L20:
        return;
    L16:
        if (r101 == null) goto L22;
        r101.a(2, true, 1, r100);
        return;
    L22:
        return;
    L5:
        if (StringsKt.isBlank(r102) == true) goto L8;
        r103 = false;
        goto L10
    }

    public static void b(Sticker r110, int r111, com.bytedance.android.live.broadcastgame.effectgame.base.a r112) {
        Intrinsics.checkNotNullParameter(r110, "sticker");
        List<String> r100 = LiveEffectContext.f66734h;
        k r101 = LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).b().r();
        if (r101 != null) goto L5;
        return;
    L5:
        if (r112 == null) goto L7;
        SafeThreadEffectFetchCallBackDelegate r102 = new SafeThreadEffectFetchCallBackDelegate(r112);
    L8:
        SafeThreadEffectFetchCallBackDelegate r103 = r102;
        r110.setDownloaded(r101.q(r110));
        if (r110.isDownloaded() == true) goto L11;
        r101.g("livegame", r110, new C0980c(h.f59626a.incrementAndGet(), r111, r110, r103, r112, r110));
        return;
    L11:
        if (r103 == null) goto L13;
        r103.a(1, true, 1, r110);
    L13:
        c(r110, r103);
        return;
    L7:
        r102 = null;
        goto L8
    }

    public static void e(Sticker r100, String r101, String r110, int r111, com.bytedance.android.live.broadcastgame.effectgame.base.a r112) {
        Downloader.with(s1.getContext()).url(r100.getGameInfo().getGuide_url()).name(r110).savePath(r101 + "_zip").monitorScene("live_revenue_effect_play_resource").subThreadListener(new d(r112, r100, r101, r111, r110)).download();
    }
}

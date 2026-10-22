package com.bytedance.android.shopping.anchorv3.detail.widget.playerblock;

import android.view.ViewGroup;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.ECPDPBaseVideo;
import com.bytedance.android.ec.model.response.u1;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.base.VideoModel;
import com.bytedance.android.shopping.api.video.AVScene;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class PlayAbilityUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z73.a<String, gj.b> f164933a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f164934b = null;

    public PlayAbilityUtil() {
    }

    static {
        f164933a = new z73.a();
        f164934b = LazyKt.lazy(PlayAbilityUtil$expValue$2.INSTANCE);
    }

    public static boolean e() {
        Lazy r100 = f164934b;
        if (((Number) r100.getValue()).intValue() != 1) goto L5;
        return true;
    L5:
        if (((Number) r100.getValue()).intValue() < 4) goto L7;
        return true;
    L7:
        if (com.bytedance.android.shopping.anchorv4.video.p007float.e.a() == true) goto L13;
        return false;
    L13:
        return true;
    }

    public static String c(b r100, PlayAbilityCacheScene r101) {
        if (r101 == null) goto L5;
        String r102 = r101.getScenePrefix();
        if (r102 == null) goto L5;
    L7:
        return r102 + '_' + r100.j();
    L5:
        r102 = "";
        goto L7
    }

    public static boolean f(PlayerViewScene r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, "playerViewScene");
        int r102 = ECSdk.f48106a;
        s83.g r103 = (s83.g) ECSdk.a(s83.g.class);
        if (r103 == null) goto L9;
        s83.f r104 = r103.p();
        if (r104 == null) goto L10;
        r104.i();
        return false;
    L10:
        return false;
    L9:
        return false;
    }

    public static b a(VideoModel r210, fj.f r211, PlayerViewScene r212) {
        Intrinsics.checkNotNullParameter(r210, "bffVideoModel");
        Intrinsics.checkNotNullParameter(r212, "scene");
        String r100 = r210.getMainUrl();
        String r101 = r210.getBackupUrl();
        String r102 = r210.getVid();
        long r103 = com.bytedance.android.shopping.extensions.c.b(Integer.valueOf(r210.getWidth()));
        long r104 = com.bytedance.android.shopping.extensions.c.b(Integer.valueOf(r210.getHeight()));
        long r110 = com.bytedance.android.shopping.extensions.c.b(r210.getDuration());
        Integer r111 = r210.getSourceType();
        long r213 = r210.getInitialStartTimeMs();
        String r214 = r210.getItemId();
        boolean r112 = r210.getAutoPlay();
        boolean r113 = r210.isMute();
        u1 r215 = r210.getExtraInfo();
        String r105 = r210.getPosterUrl();
        if (r105 != null) goto L11;
        ImageModel r106 = r210.getPosterImage();
        if (r106 == null) goto L9;
        ECUrlModel r107 = r106.getRemote();
        if (r107 == null) goto L9;
        r105 = r107.getFirstUrl();
    L9:
        r105 = null;
    L11:
        return new b(new fj.d(r100, r101, r102, r103, r104, r110, r105, r112, r113, false, false, false, r111, false, r213, r214, r215, 11776), r210.getPlayMeta(), r211, r212);
    }

    public static b b(fj.d r100, ECPDPBaseVideo r101, PlayerViewScene r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 8) == 0) goto L9;
        r102 = null;
    L9:
        if (r102 != null) goto L12;
        r102 = PlayerViewScene.SCENE_OTHERS;
    L12:
        return new b(r100, r101, null, r102);
    }

    public static gj.b d(b r100, ViewGroup r101, PlayerViewScene r102, AVScene r103, com.bytedance.android.shopping.api.video.d r104, PlayAbilityCacheScene r105) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, "parentView");
        Intrinsics.checkNotNullParameter(r102, "playerViewScene");
        Intrinsics.checkNotNullParameter(r103, "scene");
        Intrinsics.checkNotNullParameter(r104, "playerOptions");
        h r106 = null;
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.e.a() == false) goto L17;
        z73.a<String, gj.b> r107 = f164933a;
        String r108 = c(r100, r105);
        gj.b r109 = r107.f570646a.get(r108);
        if (r109 != null) goto L7;
    L8:
        f(r102, r100);
        fj.d r110 = r100.f164970b;
        if (r110 == null) goto L11;
        r106 = new h(r101, r110, r103);
    L11:
        if (r106 == null) goto L23;
        String r111 = c(r100, r105);
        if (r111 == null) goto L16;
        r107.f570646a.put(r111, r106);
    L21:
        return r106;
    L16:
        throw new IllegalArgumentException("Cache key cannot be null".toString());
    L23:
        return r109;
    L7:
        if (r105 == PlayAbilityCacheScene.SCENE_MORE_VIDEO) goto L8;
        return r109;
    L17:
        f(r102, r100);
        fj.d r112 = r100.f164970b;
        if (r112 == null) goto L21;
        r106 = new h(r101, r112, r103);
        goto L21
    }
}

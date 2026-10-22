package com.bytedance.android.livesdk.chatroom.replay.player;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.LruCache;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.ReplayABSettingKeys;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.q;
import com.bytedance.android.livesdk.chatroom.vs_base.util.r;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.android.livesdkapi.replay.ReplayPlayerConfiger;
import com.bytedance.android.scope.o;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.videoshop.context.VideoContext;
import com.ss.android.videoshop.mediaview.LayerHostMediaLayout;
import com.ss.android.videoshop.mediaview.TextureVideoView;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.VideoEngineInfos;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.model.VideoRef;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mq1.y;

/* JADX INFO: loaded from: classes7.dex */
public final class k implements nm1.k, y, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Long, tic.a> f109588a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LruCache<Long, Bitmap> f109589b = null;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f109590a;

        public b(long r100) {
            this.f109590a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            k.f109589b.put(Long.valueOf(this.f109590a), (Bitmap) r100);
            ALogger.d("ReplayVideoPrepareService", "background prepared, episodeId " + this.f109590a);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f109591a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ py.k f109592b;

        public c(long r100, py.k r101) {
            this.f109591a = r100;
            this.f109592b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            ALogger.e("ReplayVideoPrepareService", "prepare background error, episode id " + this.f109591a + ", image model " + this.f109592b);
        }
    }

    public static final class d extends nic.l.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bundle f109593a;

        public d(Bundle r100) {
            this.f109593a = r100;
        }

        @Override // nic.l.a, nic.h
        public final void i(oic.f r100, tic.a r101, VideoEngineInfos r102) {
            if (Intrinsics.areEqual(r102.getKey(), VideoEngineInfos.USING_MDL_HIT_CACHE_SIZE) == true) goto L5;
            return;
        L5:
            if (r102.getUsingMDLHitCacheSize() <= 0) goto L9;
            this.f109593a.putBoolean(VSConstants.EXTRA_VS_HIT_CACHE_WHEN_PREPARE, true);
            return;
        }
    }

    public k() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    static {
        f109588a = new LinkedHashMap();
        f109589b = new LruCache(5);
    }

    @Override // nm1.k
    public final boolean c() {
        return ReplayABSettingKeys.LIVE_REPLAY_ENTER_OPTIMIZE.getValue().getEnablePreloadJsb();
    }

    @Override // mq1.y
    public final Bitmap d(Long r100) {
        if (r100 == null) goto L5;
        r100.longValue();
        return f109589b.remove(r100);
    L5:
        return null;
    }

    @Override // nm1.k
    public final void g(Context r100) {
        if (r100 == null) goto L5;
        VideoContext.n0(r100).E0();
        return;
    }

    @Override // nm1.k, mq1.y
    public final void a(py.k r100, long r101) {
        if (ReplayABSettingKeys.LIVE_REPLAY_ENTER_OPTIMIZE.getValue().getEnablePrepareBackground() == false) goto L15;
        LruCache<Long, Bitmap> r102 = f109589b;
        if (r102.get(Long.valueOf(r101)) == null) goto L11;
        Bitmap r103 = r102.get(Long.valueOf(r101));
        if (r103 != null) goto L9;
        return;
    L9:
        if (r103.isRecycled() == true) goto L11;
        return;
    L11:
        if (r100 != null) goto L13;
        return;
    L13:
        a1.k(r100).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(r101), new c(r101, r100));
        return;
    }

    @Override // nm1.k
    public final boolean f(String r110, Context r111, Bundle r112) {
        if (ReplayABSettingKeys.LIVE_REPLAY_ENTER_OPTIMIZE.getValue().getEnablePrepare() == true) goto L6;
        return false;
    L6:
        if (TextUtils.isEmpty(r110) == false) goto L8;
        return false;
    L8:
        if (r112 != null) goto L10;
        return false;
    L10:
        if (r111 != null) goto L13;
        return false;
    L13:
        if (r112.getLong(VSConstants.EXTRA_ITEM_ID, 0) <= 0) goto L16;
        long r100 = r112.getLong(VSConstants.EXTRA_ITEM_ID);
    L22:
        if (r100 > 0) goto L25;
        return false;
    L25:
        if (((LinkedHashMap) f109588a).get(Long.valueOf(r100)) == null) goto L28;
        ALogger.d("ReplayVideoPrepareService", "already prepared by video info string, item id " + r100);
        return true;
    L28:
        int r101 = r.f118208a;
        VideoModel r102 = r.e(r110);
        if (r102 != null) goto L31;
        return false;
    L31:
        ALogger.d("ReplayVideoPrepareService", "before prepare thread = " + ThreadMethodProxy.currentThread().getName() + ", is main thread = " + Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()));
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L34;
        h(r102, r111, r112, r100);
    L35:
        ALogger.d("ReplayVideoPrepareService", "start prepare by video info string, item id " + r100);
        return true;
    L34:
        i0.c().post(new l(this, r102, r111, r112, r100));
        goto L35
    L16:
        if (TextUtils.isEmpty(r112.getString(VSConstants.EXTRA_ITEM_ID, "")) == true) goto L20;
        String r103 = r112.getString(VSConstants.EXTRA_ITEM_ID, "0L");
        if (r103 == null) goto L20;
        r100 = CastLongProtector.parseLong(r103);
    L20:
        r100 = 0;
        goto L22
    }

    public static void h(VideoModel r110, Context r111, Bundle r112, long r210) {
        ALogger.d("ReplayVideoPrepareService", "preparing thread = " + ThreadMethodProxy.currentThread().getName() + ", is main thread = " + Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()));
        VideoContext r100 = VideoContext.n0(r111);
        if (r100 == null) goto L5;
        ReplayPlayerConfiger r101 = new ReplayPlayerConfiger();
        int r102 = r.f118208a;
        r101.targetResolution = r.a(r110);
        Unit r103 = Unit.INSTANCE;
        r100.f455967u.f529432f = r101;
    L5:
        String r104 = "";
        String r105 = r112.getString(VSConstants.EXTRA_VS_VIDEO_ID, "");
        boolean r106 = r112.getBoolean(VSConstants.EXTRA_VS_SHARE_VIEW, false);
        if (r210 <= 0) goto L88;
        Intrinsics.checkNotNullParameter(r110, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        String r107 = r110.getVideoRefStr(2);
        if (r107 != null) goto L10;
    L13:
        boolean r108 = true;
    L14:
        if (r108 == true) goto L17;
        r105 = r107;
    L17:
        if (r105 == null) goto L21;
        mq1.c r109 = q.a();
        if (r109 == null) goto L21;
        Map<String, Pair<String, String>> r113 = r109.getLocalVideoPath(r105);
    L22:
        if (r113 != null) goto L24;
    L27:
        boolean r114 = true;
    L28:
        if (r114 == true) goto L40;
        Set<String> r115 = r113.keySet();
        if (r115 != null) goto L32;
    L35:
        boolean r116 = true;
    L36:
        if (r116 == true) goto L40;
        r104 = (String) CollectionsKt.first(r113.keySet());
        Pair<String, String> r117 = r113.get(r104);
        if (r117 == null) goto L40;
        String r118 = r117.getFirst();
        String r119 = r117.getSecond();
    L41:
        tic.a r120 = new tic.a();
        if (r106 == true) goto L83;
        if (r119 != null) goto L45;
    L48:
        boolean r121 = true;
    L49:
        if (r121 == true) goto L83;
        r120.f546368f = r119;
        if (r118 != null) goto L54;
    L57:
        boolean r122 = true;
    L58:
        if (r122 == true) goto L60;
        r120.f546372j = r118;
    L60:
        ejc.b r123 = r120.f546377o;
        Resolution[] r124 = r110.getSupportResolutions();
        if (r124 == null) goto L70;
        int r125 = r124.length;
        int r126 = 0;
    L63:
        if (r126 >= r125) goto L68;
        Resolution r127 = r124[r126];
        if (Intrinsics.areEqual(r127.toString(VideoRef.TYPE_VIDEO), r104) == true) goto L69;
        r126 = r126 + 1;
    L69:
        if (r127 == null) goto L70;
    L82:
        r123.f472909k = r127;
    L84:
        r120.f546373k = "vs_long_video";
        r120.f546374l = "vs_video_enter";
        r120.f546375m = true;
        r120.f546365c = r.c(sq1.c.a(r210), r112.getLong(VSConstants.EXTRA_VS_START_PLAY_POSITION, -1) * 1000, r112.getLong(VSConstants.EXTRA_VS_START_HIGHLIGHT_POSITION, -1) * 1000, (int) (((long) r110.getVideoRefInt(3)) * 1000)).f118216a;
        ejc.b r128 = r120.f546377o;
        if (r128 == null) goto L87;
        r128.f472900b = false;
    L87:
        f109588a.put(Long.valueOf(r210), r120);
        goto L88
    L68:
        r127 = null;
    L70:
        Resolution[] r129 = r110.getSupportResolutions();
        int r130 = r129.length;
        int r131 = 0;
    L71:
        if (r131 >= r130) goto L81;
        r127 = r129[r131];
        String r132 = r127.toString(VideoRef.TYPE_VIDEO);
        if (r132 != null) goto L75;
    L77:
        boolean r133 = false;
    L78:
        if (r133 == true) goto L82;
        r131 = r131 + 1;
        goto L71
    L75:
        if (StringsKt.contains$default(r132, r104, false, 2, null) != true) goto L77;
        r133 = true;
        goto L78
    L81:
        r127 = null;
        goto L82
    L54:
        if (r118.length() == 0) goto L57;
        r122 = false;
        goto L58
    L45:
        if (r119.length() == 0) goto L48;
        r121 = false;
    L83:
        r120.f546366d = r110;
        goto L84
    L32:
        if (r115.isEmpty() == true) goto L35;
        r116 = false;
    L40:
        r119 = null;
        r118 = null;
        goto L41
    L24:
        if (r113.isEmpty() == true) goto L27;
        r114 = false;
    L21:
        r113 = null;
        goto L22
    L10:
        if (r107.length() == 0) goto L13;
        r108 = false;
    L88:
        VideoContext.n0(r111).f455967u.f529431e = r.d();
        VideoContext.n0(r111).f455967u.f529434h = new d(r112);
        VideoContext.n0(r111).f455967u.f529433g = new sic.a();
        VideoContext r134 = VideoContext.n0(r111);
        tic.a r135 = (tic.a) ((LinkedHashMap) f109588a).get(Long.valueOf(r210));
        boolean r136 = ReplayABSettingKeys.LIVE_REPLAY_PLAYER_USE_SURFACEVIEW.getValue().booleanValue();
        pic.e r137 = r134.f455967u;
        if (r135 != null) goto L91;
        r137.getClass();
        return;
    L91:
        if (((HashMap) r137.f529427a).containsKey(r135) == false) goto L93;
        return;
    L93:
        if (((HashMap) r137.f529428b).containsKey(r135) == true) goto L144;
        Activity r138 = fjc.d.a(r137.f529435i.getContext());
        if (r138 == null) goto L145;
        ViewGroup r139 = (ViewGroup) r138.findViewById(R.id.content);
        if (r139 == null) goto L146;
        VideoContext r140 = r137.f529435i;
        if (r140 == null) goto L109;
        if (r140.q0(r135) == false) goto L109;
        if (r137.f529435i.v0() == true) goto L109;
        return;
    L109:
        if (((LinkedList) r137.f529429c).size() < r137.f529436j) goto L111;
        ajc.b.a("VideoPrepareManager", "prepareQueue over maxsize release first one. prepareQueue.size:" + ((LinkedList) r137.f529429c).size());
        r137.a((tic.a) ((LinkedList) r137.f529429c).peek());
    L111:
        ((LinkedList) r137.f529429c).offer(r135);
        qic.c r141 = r137.f529430d;
        VideoContext r142 = r137.f529435i;
        r141.getClass();
        qic.b r143 = new qic.b(r142);
        ((HashMap) r137.f529427a).put(r135, r143);
        nic.f r144 = r137.f529431e;
        if (r144 == null) goto L114;
        r143.f533240p = r144;
    L114:
        r143.f533230f = null;
        r143.f533237m = r137.f529432f;
        nic.c r145 = r137.f529433g;
        if (r145 == null) goto L117;
        r143.n(r145);
    L117:
        r143.setPlayEntity(r135);
        ejc.b r146 = r135.f546377o;
        if (r146 == null) goto L120;
        r143.f533244t = r146.f472900b;
    L120:
        r143.f533236l = r137.f529434h;
        VideoContext r147 = r137.f529435i;
        if (r147 == null) goto L127;
        LayerHostMediaLayout r148 = r147.f455949c;
        if (r148 == null) goto L127;
        if (r148.a0() == false) goto L127;
        boolean r149 = true;
    L128:
        if (r149 == true) goto L131;
        if (r136 == true) goto L131;
        TextureVideoView r150 = new TextureVideoView(r137.f529435i.getContext());
        r150.setReuseSurfaceTexture(true);
        ((HashMap) r137.f529428b).put(r135, r150);
        r150.setSurfaceTextureListener(new pic.d(r137, r150, r135, r143));
        r139.addView(r150, new ViewGroup.LayoutParams(0, 0));
    L135:
        ajc.b.a("VideoPrepareManager", "prepare vid:" + r135.f546363a + " title:null");
        return;
    L131:
        int r151 = 1;
        if (Build.VERSION.SDK_INT >= 24) goto L134;
        r151 = 2;
    L134:
        r143.f533229e = r151;
        r143.prepare();
    L127:
        r149 = false;
        goto L128
    L146:
        return;
    L145:
        return;
    }
}

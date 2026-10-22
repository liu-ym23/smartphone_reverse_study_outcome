package com.bytedance.android.gamecp.business;

import android.content.Context;
import android.os.Process;
import android.provider.Settings;
import android.view.View;
import android.view.ViewGroup;
import androidx.camera.video.AudioStats;
import com.bytedance.android.gamecp.common.setting.config.g3;
import com.bytedance.android.gamecp.common.track.GamecpTracker;
import com.bytedance.android.gamecp.common.ui.HSImageView;
import com.bytedance.android.gamecp.common.utils.r;
import com.bytedance.android.gamecp.host_api.model.GameImageBundler;
import com.bytedance.android.gamecp.host_api.model.ImageModel;
import com.bytedance.android.livesdkapi.depend.log.LogFilterName;
import com.bytedance.live.datacontext.DataContext;
import com.facebook.imagepipeline.common.Priority;
import com.obric.sva.sdk.data.ISmModel;
import com.ss.android.downloadlib.addownload.DownloadInsideHelper;
import com.ss.android.socialbase.appdownloader.util.MIUIUtils;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;
import wu.c3;
import wu.i2;
import wu.j2;
import wu.q1;

/* JADX INFO: loaded from: classes44.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f56003a = 0;

    public static com.bytedance.android.gamecp.host_api.model.c c() {
        Context r100 = com.bytedance.android.gamecp.host_api.a.b().getHostContext().getAppContext();
        boolean r101 = true;
        boolean r102 = false;
        if (RomUtils.isMiui() == false) goto L8;
        if (MIUIUtils.readPureModeState(r100) == 1) goto L49;
    L48:
        r101 = false;
    L49:
        String r103 = "";
        boolean r104 = r101;
    L51:
        return new com.bytedance.android.gamecp.host_api.model.c(RomUtils.getOs(), r103, r104, r102);
    L8:
        if (RomUtils.isHarmony() == false) goto L48;
        r103 = m0.c();
        if (r100 != null) goto L12;
    L22:
        r104 = false;
    L23:
        if (r100 != null) goto L25;
    L46:
        r101 = false;
    L47:
        r102 = r101;
        goto L51
    L25:
        if (Settings.Secure.getInt(r100.getContentResolver(), "pure_enhanced_mode_state", 1) != 0) goto L27;
        boolean r105 = false;
    L28:
        if (r105 == true) goto L46;
        if (m0.b() == true) goto L32;
    L43:
        boolean r106 = false;
    L44:
        if (r106 == false) goto L46;
    L32:
        if (m0.e(m0.c()) == false) goto L43;
        int r107 = Process.myUid();
        Class r108 = m0.a("com.huawei.android.os.UserHandleEx");     // Catch: Throwable -> L39
        Object r109 = r108.getMethod("getUserId", new Class[]{Integer.TYPE}).invoke(r108, new Object[]{Integer.valueOf(r107)});     // Catch: Throwable -> L39
        if (r109 == null) goto L38;
        int r110 = ((Integer) r109).intValue();     // Catch: Throwable -> L39
    L41:
        if (r110 != 0) goto L43;
        r106 = true;
        goto L44
    L38:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        th.printStackTrace();
        r110 = 1;
        goto L41
    L27:
        r105 = true;
        goto L28
    L12:
        if (m0.e(m0.c()) == true) goto L14;
        int r111 = Settings.Secure.getInt(r100.getContentResolver(), "pure_mode_state", 0);
    L18:
        if (r111 != 0) goto L22;
        if (m0.b() == false) goto L22;
        r104 = true;
        goto L23
    L14:
        if (Settings.Secure.getInt(r100.getContentResolver(), "pure_mode_state", 1) != 0) goto L16;
        r111 = 0;
        goto L18
    L16:
        r111 = 1;
        goto L18
    }

    static {
    }

    public static List b(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        ArrayList r101 = new ArrayList();
        if ((r100 instanceof ViewGroup) == false) goto L7;
        ViewGroup r102 = (ViewGroup) r100;
        int r103 = r102.getChildCount();
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L7;
        View r105 = r102.getChildAt(r104);
        r101.add(r105);
        r101.addAll(b(r105));
        r104 = r104 + 1;
    L7:
        return r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String d(int r100) {
        boolean r101 = false;
        Object r102 = null;
        if (r100 == 0) goto L33;
        if (r100 != 1) goto L6;
        DataContext r103 = com.bytedance.live.datacontext.d.d(GamePromoteTrackViewModel.class);
        if ((r103 instanceof GamePromoteTrackViewModel) == false) goto L26;
        r102 = r103;
    L26:
        GamePromoteTrackViewModel r104 = (GamePromoteTrackViewModel) r102;
        if (r104 == null) goto L53;
        String r105 = r104.isAds();
        if (r105 != null) goto L32;
        return "0";
    L32:
        return r105;
    L53:
        return "0";
    L6:
        if (r100 != 2) goto L54;
        DataContext r106 = com.bytedance.live.datacontext.d.d(GamePromoteTrackViewModel.class);
        if ((r106 instanceof GamePromoteTrackViewModel) == true) goto L11;
        r106 = null;
    L11:
        GamePromoteTrackViewModel r107 = (GamePromoteTrackViewModel) r106;
        if (r107 == null) goto L49;
        String r108 = r107.isAds();
        if (r108 != null) goto L16;
        return "0";
    L16:
        if (r108.length() <= 0) goto L18;
        r101 = true;
    L18:
        if (r101 == false) goto L20;
        r102 = r108;
    L20:
        if (r102 != null) goto L52;
        return "0";
    L52:
        return r102;
    L49:
        return "0";
    L54:
        return "0";
    L33:
        HashMap<String, String> r109 = GamecpTracker.f56755a;
        com.bytedance.android.gamecp.common.track.filter.d r110 = GamecpTracker.h(zu.a.class);
        if ((r110 instanceof com.bytedance.android.gamecp.common.track.filter.b) == false) goto L37;
        r102 = r110;
    L37:
        com.bytedance.android.gamecp.common.track.filter.b r111 = (com.bytedance.android.gamecp.common.track.filter.b) r102;
        if (r111 == null) goto L41;
        String r112 = r111.d();
        if (r112 == null) goto L41;
    L43:
        if (r112.length() != 0) goto L45;
        r101 = true;
    L45:
        if (r101 == false) goto L48;
        return "0";
    L48:
        return r112;
    L41:
        r112 = "0";
        goto L43
    }

    public static String f(int r100) {
        if (r100 != 0) goto L4;
        Map r101 = com.bytedance.android.gamecp.common.track.b.b(LogFilterName.ROOM);
        if (r101 == null) goto L18;
        String r102 = (String) r101.get("request_id");
        if (r102 == null) goto L18;
        return r102;
    L18:
        return "";
    L4:
        if (r100 != 1) goto L18;
        DataContext r103 = com.bytedance.live.datacontext.d.d(GamePromoteTrackViewModel.class);
        if ((r103 instanceof GamePromoteTrackViewModel) == true) goto L9;
        r103 = null;
    L9:
        GamePromoteTrackViewModel r104 = (GamePromoteTrackViewModel) r103;
        if (r104 == null) goto L18;
        String r105 = r104.getRequestId();
        if (r105 == null) goto L18;
        return r105;
    }

    public static String g(Integer r100) {
        if (r100 != null) goto L5;
    L7:
        if (r100 != null) goto L10;
    L12:
        if (r100 != null) goto L15;
    L17:
        if (r100 != null) goto L20;
    L22:
        return "";
    L20:
        if (r100.intValue() != 3) goto L22;
        return "saas";
    L15:
        if (r100.intValue() != 2) goto L17;
        return "official";
    L10:
        if (r100.intValue() != 1) goto L12;
        return "video";
    L5:
        if (r100.intValue() != 0) goto L7;
        return "live";
    }

    public static int h(com.bytedance.android.gamecp.base.core.service.depend.x r100) {
        Intrinsics.checkNotNullParameter(r100, "progressData");
        if (c3.f561291a.getValue().booleanValue() == false) goto L7;
        return r100.f51441e;
    L7:
        return r100.f51437a;
    }

    public static boolean i(Long r100) {
        if (r100 != null) goto L5;
        return true;
    L5:
        if ((r100.longValue() & ((long) 2)) <= 0) goto L7;
        return true;
    L7:
        return false;
    }

    public static void a(HSImageView r100, GameImageBundler r101, fu.g r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "imageBundler");
        if (fu.d.f478832a != true) goto L6;
        fu.d.b(r100, r101, Priority.IMMEDIATE, r102);
        return;
    L6:
        ImageModel r104 = new ImageModel();
        r104.setUrls(CollectionsKt.arrayListOf(new String[]{r103}));
        Unit r105 = Unit.INSTANCE;
        fu.j.b(r100, r104);
    }

    public static com.bytedance.android.gamecp.base.core.service.depend.x e(long r210, long r211, long r212, com.bytedance.android.gamecp.business.download.p r310, JSONObject r311) {
        int r100 = (int) ((r210 * 100.0f) / r212);
        if (r100 <= 100) goto L5;
        int r101 = 100;
    L7:
        if (r101 < 0) goto L11;
        if (50 < r101) goto L11;
        double r110 = ((double) r101) * 1.5d;
    L12:
        int r111 = (int) r110;
        if (r310 == null) goto L17;
        com.bytedance.android.gamecp.business.download.s r112 = r310.G0;
        if (r112 == null) goto L17;
        long r102 = r112.f52919c;
    L18:
        long r103 = System.currentTimeMillis();
        if (r310 == null) goto L23;
        com.bytedance.android.gamecp.business.download.s r113 = r310.G0;
        if (r113 == null) goto L23;
        long r104 = r113.f52920d;
    L24:
        long r105 = r211 - r102;
        long r114 = r103 - r104;
        String r213 = "0Kb/s";
        if (r105 != 0) goto L27;
    L80:
        int r106 = r101;
        String r107 = "0Kb/s";
        String r108 = r107;
        float r109 = 0.0f;
    L82:
        if (r210 != 0) goto L145;
        if (r310 == null) goto L87;
        com.bytedance.android.gamecp.business.download.s r115 = r310.G0;
        if (r115 == null) goto L87;
        long r116 = r115.f52928l;
    L89:
        if (r116 == 0) goto L145;
        if (r310 == null) goto L94;
        com.bytedance.android.gamecp.business.download.s r117 = r310.G0;
        if (r117 == null) goto L94;
        int r118 = r117.f52927k;
    L95:
        if (r118 != 0) goto L145;
        int r119 = yt.f.f569005a;
        if (r310 == null) goto L99;
        double r120 = r310.f52854j0;
    L101:
        if (r.f57271a != null) goto L103;
        r.f57271a = i2.f561326a.getValue();
    L103:
        Boolean r121 = r.f57271a;
        Intrinsics.checkNotNull(r121);
        if (r121.booleanValue() == true) goto L106;
    L128:
        int r122 = 0;
    L129:
        if (r122 != 0) goto L139;
        long r123 = System.currentTimeMillis();
        if (r310 == null) goto L135;
        com.bytedance.android.gamecp.business.download.s r124 = r310.G0;
        if (r124 == null) goto L135;
        long r125 = r124.f52928l;
    L137:
        if ((r123 - r125) < 1000) goto L139;
        int r126 = 1;
    L140:
        if (r310 == null) goto L152;
        com.bytedance.android.gamecp.business.download.s r127 = r310.G0;
        if (r127 == null) goto L152;
        r127.f52927k = r126;
    L152:
        if (com.bytedance.android.gamecp.business.patch.experiment.a.d(r311) == false) goto L158;
        float r128 = r126;
        Float r129 = q1.f561373a.getValue().m();
        if (r129 == null) goto L156;
        float r130 = r129.floatValue();
    L157:
        int r131 = (int) (r128 * r130);
        yr.c.a("AirCompressManager", "原有进度：" + r126 + ", 增量下载进度: " + r131 + ' ');
        int r132 = r131;
    L160:
        if (r109 <= 0) goto L166;
        if (r310 == null) goto L166;
        com.bytedance.android.gamecp.business.download.s r133 = r310.G0;
        if (r133 == null) goto L166;
        r133.f52924h = r109;
    L166:
        if (r310 == null) goto L170;
        com.bytedance.android.gamecp.business.download.s r134 = r310.G0;
        if (r134 == null) goto L170;
        float r135 = r134.f52924h;
    L172:
        return new com.bytedance.android.gamecp.base.core.service.depend.x(r106, r107, r111, r108, r132, r211, r212, r135, null, false, ISmModel.VERSION_0700);
    L170:
        r135 = 0.0f;
        goto L172
    L156:
        r130 = 0.9f;
        goto L157
    L158:
        r132 = r126;
    L135:
        r125 = 0;
    L139:
        r126 = r122;
        goto L140
    L106:
        if (r.f57272b != null) goto L108;
        r.f57272b = j2.f561332a.getValue();
    L108:
        g3 r136 = r.f57272b;
        Intrinsics.checkNotNull(r136);
        if (r120 <= r136.a()) goto L128;
        if (r.f57272b != null) goto L114;
        r.f57272b = j2.f561332a.getValue();
    L114:
        g3 r137 = r.f57272b;
        Intrinsics.checkNotNull(r137);
        int r138 = r137.b();
        if (r138 != 0) goto L117;
    L126:
        int r139 = 0;
    L127:
        yr.c.e("VirtualProgress", "下载起点进度: " + r139);
        r122 = r139;
        goto L129
    L117:
        if (r138 != 1) goto L119;
        r139 = RangesKt.random(new IntRange(1, 3), Random.Default);
        goto L127
    L119:
        if (r138 == 2) goto L123;
        if (r138 != 3) goto L126;
        r139 = RangesKt.random(new IntRange(3, 5), Random.Default);
        goto L127
    L123:
        r139 = RangesKt.random(new IntRange(2, 4), Random.Default);
        goto L127
    L99:
        r120 = AudioStats.AUDIO_AMPLITUDE_NONE;
    L94:
        r118 = 0;
    L87:
        r116 = 0;
    L145:
        if (DownloadInsideHelper.checkProgressOptOpen() == true) goto L147;
        int r140 = yt.f.f569005a;
        r100 = (int) (Math.sqrt(((double) r100) * 1.0d) * ((double) 10));
    L147:
        r126 = 99;
        if (r100 > 99) goto L152;
        r126 = r100;
        goto L152
    L27:
        if (r114 == 0) goto L80;
        if (r104 == 0) goto L80;
        r109 = ((r105 / 1024.0f) * 1000.0f) / r114;
        r106 = r101;
        if (r101 >= 0) goto L35;
    L37:
        double r141 = r109;
        double r142 = 0.5d;
    L38:
        float r143 = (float) (r141 * r142);
        int r144 = Random.Default.nextInt(300) + 400;
        if (r310 == null) goto L43;
        com.bytedance.android.gamecp.business.download.s r145 = r310.G0;
        if (r145 == null) goto L43;
        long r146 = r145.f52925i;
    L45:
        if ((r103 - r146) <= r144) goto L62;
        float r147 = 1024;
        if (r109 <= r147) goto L49;
        float r148 = r109 / r147;
        StringBuilder r149 = new StringBuilder();
        StringCompanionObject r150 = StringCompanionObject.INSTANCE;
        r149.append(String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(r148)}, 1)));
        r149.append("Mb/s");
        String r151 = r149.toString();
    L50:
        if (r310 == null) goto L54;
        com.bytedance.android.gamecp.business.download.s r152 = r310.G0;
        if (r152 == null) goto L54;
        r152.f52925i = r103;
    L54:
        if (r310 == null) goto L58;
        com.bytedance.android.gamecp.business.download.s r153 = r310.G0;
        if (r153 == null) goto L58;
        Intrinsics.checkNotNullParameter(r151, "<set-?>");
        r153.f52923g = r151;
    L58:
        if (r310 == null) goto L75;
        com.bytedance.android.gamecp.business.download.s r154 = r310.G0;
        if (r154 == null) goto L75;
        r154.f52922f = r109;
    L75:
        float r155 = 1024;
        if (r143 <= r155) goto L78;
        float r156 = r143 / r155;
        StringBuilder r157 = new StringBuilder();
        StringCompanionObject r158 = StringCompanionObject.INSTANCE;
        r157.append(String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(r156)}, 1)));
        r157.append("Mb/s");
        String r159 = r157.toString();
    L79:
        r108 = r159;
        r107 = r151;
        goto L82
    L78:
        StringBuilder r160 = new StringBuilder();
        StringCompanionObject r161 = StringCompanionObject.INSTANCE;
        r160.append(String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(r143)}, 1)));
        r160.append("Kb/s");
        r159 = r160.toString();
        goto L79
    L49:
        StringBuilder r162 = new StringBuilder();
        StringCompanionObject r163 = StringCompanionObject.INSTANCE;
        r162.append(String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(r109)}, 1)));
        r162.append("Kb/s");
        r151 = r162.toString();
        goto L50
    L62:
        if (r310 == null) goto L69;
        com.bytedance.android.gamecp.business.download.s r164 = r310.G0;
        if (r164 == null) goto L69;
        String r165 = r164.f52923g;
        if (r165 == null) goto L69;
        r213 = r165;
    L69:
        if (r310 == null) goto L73;
        com.bytedance.android.gamecp.business.download.s r166 = r310.G0;
        if (r166 == null) goto L73;
        r109 = r166.f52922f;
    L74:
        r151 = r213;
    L73:
        r109 = 0.0f;
    L43:
        r146 = 0;
        goto L45
    L35:
        if (50 < r106) goto L37;
        r141 = r109;
        r142 = 1.5d;
    L23:
        r104 = 0;
    L17:
        r102 = 0;
    L11:
        r110 = (((double) r101) * 0.5d) + ((double) 50);
        goto L12
    L5:
        r101 = r100;
        goto L7
    }
}

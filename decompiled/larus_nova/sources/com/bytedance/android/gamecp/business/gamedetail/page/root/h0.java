package com.bytedance.android.gamecp.business.gamedetail.page.root;

import android.os.Bundle;
import androidx.camera.video.AudioStats;
import com.bytedance.android.gamecp.business.micro.MicroGameManager;
import com.bytedance.android.gamecp.common.utils.UtilsKt;
import com.ss.android.downloadlib.constants.EventConstants;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;
import wu.q1;

/* JADX INFO: loaded from: classes44.dex */
public final class h0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f55528e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public dt.b f55529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public o f55530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public o f55531c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f55532d;

    public static final class a {
        public static h0 b(Bundle r100) {
            h0 r101 = new h0();
            int r102 = m.f55555h;
            Intrinsics.checkNotNullParameter("开始并发请求", "message");
            yr.c.e("AudienceGameDetailRequest", "开始并发请求");
            dt.b.f469938w0.getClass();
            dt.b r103 = dt.b.a.a(r100, true);
            r101.f55529a = r103;
            int r104 = q.f55580a;
            n r105 = new n(r103, "1", null, 4);
            Intrinsics.checkNotNullParameter(r105, "request");
            Ref.ObjectRef r106 = new Ref.ObjectRef();
            r106.element = null;
            r101.f55530b = m.a.a(r105, new p(r106, r105, null));
            int r107 = s.f55584a;
            n r108 = new n(r103, "2", null, 4);
            Intrinsics.checkNotNullParameter(r108, "request");
            r101.f55531c = m.a.a(r108, new r(null));
            boolean r109 = GameDetailPreRequestUtil.f55453a;
            k0 r110 = new k0(r101);
            Intrinsics.checkNotNullParameter(r103, "launchParams");
            Intrinsics.checkNotNullParameter(r110, "cb");
            GameDetailPreRequestUtil.f("缓存读取 null, isEnableCache() = false");
            Intrinsics.checkNotNullParameter("switch is close", "msg");
            Intrinsics.checkNotNullParameter("switch is close", "msg");
            LinkedHashMap r111 = new LinkedHashMap();
            r111.put("game_id", r103.F);
            r111.put("scene", String.valueOf(r103.P));
            r111.put("room_id", r103.f469939J);
            r111.put("video_id", r103.R);
            r111.put("fail_reason", "switch is close");
            GameDetailPreRequestUtil.m("dygame_tech_game_detail_use_preload_data_failed", r111);
            return r101;
        }

        public static com.bytedance.android.gamecp.business.gamedetail.base.model.h a(JSONObject r110, n r111) {
            JSONObject r100 = r110.optJSONObject("game_detail_common_params");
            if (r100 == null) goto L5;
            String r101 = r100.toString();
        L6:
            com.bytedance.android.gamecp.business.gamedetail.base.model.h r102 = (com.bytedance.android.gamecp.business.gamedetail.base.model.h) com.bytedance.android.gamecp.common.utils.e0.g(r101, com.bytedance.android.gamecp.business.gamedetail.base.model.h.class);
            int r103 = m0.f55563a;
            if (MicroGameManager.b() == false) goto L147;
            yr.c.a("game-promote", "实验组开始处理微端包大小");
            if (r102 != null) goto L145;
        L18:
            JSONObject r112 = null;
        L19:
            if (r112 == null) goto L21;
            double r113 = r112.optDouble(EventConstants.ExtraJson.PACKAGE_SIZE, AudioStats.AUDIO_AMPLITUDE_NONE);     // Catch: Throwable -> L16
        L22:
            if (r112 == null) goto L24;
            String r104 = r112.optString("pkg_name");     // Catch: Throwable -> L16
        L25:
            if (r112 == null) goto L27;
            String r114 = r112.optString("micro_pkg_download_url");     // Catch: Throwable -> L16
        L28:
            if (r112 == null) goto L30;
            String r115 = r112.optString("micro_pkg_size");     // Catch: Throwable -> L16
        L31:
            com.bytedance.android.gamecp.business.download.p r116 = new com.bytedance.android.gamecp.business.download.p();     // Catch: Throwable -> L16
            r116.f52854j0 = r113;     // Catch: Throwable -> L16
            r116.f52860m0 = r104;     // Catch: Throwable -> L16
            if (r102 == null) goto L36;
            com.bytedance.android.gamecp.business.gamedetail.base.model.c r105 = r102.e();     // Catch: Throwable -> L16
            if (r105 == null) goto L36;
            String r106 = r105.q();     // Catch: Throwable -> L16
        L37:
            r116.f52855k = r106;     // Catch: Throwable -> L16
            if (r111 == null) goto L42;
            dt.b r107 = r111.f55564a;     // Catch: Throwable -> L16
            if (r107 == null) goto L42;
            String r108 = r107.f469952g;     // Catch: Throwable -> L16
        L43:
            r116.F = r108;     // Catch: Throwable -> L16
            if (MicroGameManager.d(r116, r114) == false) goto L147;
            yr.c.a("game-promote", "符合下载微端包条件, 将微端包大小改为 7.0 M");     // Catch: Throwable -> L16
            if (MicroGameManager.b() == false) goto L51;
            if (r102 == null) goto L51;
            com.bytedance.android.gamecp.business.gamedetail.base.model.c r109 = r102.e();     // Catch: Throwable -> L16
            if (r109 == null) goto L51;
            r109.D(r115);     // Catch: Throwable -> L16
        L51:
            r101 = com.bytedance.android.gamecp.common.utils.e0.h(r102);     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            yr.c.b("game-promote", "修改微端包大小失败 : " + th.getMessage());
        L42:
            r108 = null;
        L36:
            r106 = null;
            goto L37
        L30:
            r115 = null;
            goto L31
        L27:
            r114 = null;
            goto L28
        L24:
            r104 = null;
            goto L25
        L21:
            r113 = 0.0d;
            goto L22
        L145:
            com.bytedance.android.gamecp.business.gamedetail.base.model.b r117 = r102.d();     // Catch: Throwable -> L16
            if (r117 == null) goto L18;
            String r118 = r117.a();     // Catch: Throwable -> L16
            if (r118 == null) goto L18;
            r112 = new JSONObject(r118);     // Catch: Throwable -> L16
        L147:
            long r119 = System.currentTimeMillis();     // Catch: Throwable -> L84
            int r120 = com.bytedance.android.gamecp.business.patch.experiment.a.f56229a;     // Catch: Throwable -> L84
            if (q1.f561373a.getValue().g() == true) goto L58;
            yr.c.a("game-promote", "配置不显示增量包大小，显示完整包大小");     // Catch: Throwable -> L84
        L142:
            if (r102 == null) goto L144;
            r102.f53486a = r101;
        L144:
            return r102;
        L58:
            if (r102 == null) goto L64;
            com.bytedance.android.gamecp.business.gamedetail.base.model.b r121 = r102.d();     // Catch: Throwable -> L84
            if (r121 == null) goto L64;
            String r122 = r121.a();     // Catch: Throwable -> L84
            if (r122 == null) goto L64;
            JSONObject r123 = new JSONObject(r122);     // Catch: Throwable -> L84
        L65:
            if (r123 == null) goto L67;
            String r124 = r123.optString("increment_package_info");     // Catch: Throwable -> L84
        L68:
            if (r123 == null) goto L70;
            String r125 = r123.optString("increment_package_info_v2");     // Catch: Throwable -> L84
        L71:
            yr.c.a("game-promote", "实验组处理增量包展示大小 增量信息:" + r124);     // Catch: Throwable -> L84
            com.bytedance.android.gamecp.business.api.response.k r126 = (com.bytedance.android.gamecp.business.api.response.k) com.bytedance.android.gamecp.common.utils.e0.g(r124, com.bytedance.android.gamecp.business.api.response.k.class);     // Catch: Throwable -> L84
            com.bytedance.android.gamecp.business.api.response.k r127 = (com.bytedance.android.gamecp.business.api.response.k) com.bytedance.android.gamecp.common.utils.e0.g(r125, com.bytedance.android.gamecp.business.api.response.k.class);     // Catch: Throwable -> L84
            if (com.bytedance.android.gamecp.business.patch.experiment.a.b() == false) goto L86;
            if (r127 == null) goto L75;
            String r128 = r127.downloadUrl;     // Catch: Throwable -> L84
        L77:
            if (UtilsKt.c(r128) == false) goto L86;
            com.bytedance.android.gamecp.business.patch.experiment.c.f56231a.getClass();     // Catch: Throwable -> L84
            boolean r129 = true;
            if (h06.a.b().c(com.bytedance.android.gamecp.business.patch.experiment.c.class) != 1) goto L81;
            boolean r130 = true;
        L82:
            if (r130 == false) goto L87;
            r126 = r127;
        L87:
            if (r126 != null) goto L89;
            yr.c.a("game-promote", "增量包信息为空");     // Catch: Throwable -> L84
            goto L142
        L89:
            if (r102 == null) goto L93;
            com.bytedance.android.gamecp.business.gamedetail.base.model.c r131 = r102.e();     // Catch: Throwable -> L84
            if (r131 == null) goto L93;
            String r132 = r131.q();     // Catch: Throwable -> L84
        L94:
            if (r123 == null) goto L96;
            String r133 = r123.optString("pkg_name");     // Catch: Throwable -> L84
        L97:
            if (r123 == null) goto L99;
            double r134 = r123.optDouble(EventConstants.ExtraJson.PACKAGE_SIZE, AudioStats.AUDIO_AMPLITUDE_NONE);     // Catch: Throwable -> L84
        L100:
            StringBuilder r135 = new StringBuilder("installedApkMd5: ");     // Catch: Throwable -> L84
            if (r111 == null) goto L105;
            dt.b r136 = r111.f55564a;     // Catch: Throwable -> L84
            if (r136 == null) goto L105;
            String r137 = r136.E;     // Catch: Throwable -> L84
        L106:
            r135.append(r137);     // Catch: Throwable -> L84
            r135.append(' ');     // Catch: Throwable -> L84
            yr.c.a("game-promote", r135.toString());     // Catch: Throwable -> L84
            if (r111 == null) goto L111;
            dt.b r138 = r111.f55564a;     // Catch: Throwable -> L84
            if (r138 == null) goto L111;
            String r139 = r138.E;     // Catch: Throwable -> L84
        L113:
            if (com.bytedance.android.gamecp.business.patch.experiment.a.a(r132, r133, r139) == true) goto L116;
            yr.c.a("game-promote", "增量更新依赖的base apk 不合，不显示增量更新");     // Catch: Throwable -> L84
            goto L142
        L116:
            if (com.bytedance.android.gamecp.business.patch.experiment.a.c(r126, r132, r133, Double.valueOf(r134)) == true) goto L118;
            yr.c.a("game-promote", "不支持增量更新，展示原有包大小");     // Catch: Throwable -> L84
            goto L142
        L118:
            if (r102 == null) goto L122;
            com.bytedance.android.gamecp.business.gamedetail.base.model.c r140 = r102.e();     // Catch: Throwable -> L84
            if (r140 == null) goto L122;
            String r141 = r140.r();     // Catch: Throwable -> L84
        L123:
            if (r141 != null) goto L125;
        L128:
            if (r129 == false) goto L132;
            Double r142 = r126.packageSize;     // Catch: Throwable -> L84
            if (r142 == null) goto L132;
            r141 = (String) Integer.valueOf((int) r142.doubleValue());     // Catch: Throwable -> L84
        L132:
            yr.c.a("game-promote", "增量包大小的展示size为：" + r141 + " coat mills:" + (System.currentTimeMillis() - r119) + ':');     // Catch: Throwable -> L84
            if (r141 == null) goto L142;
            if (r102 == null) goto L139;
            com.bytedance.android.gamecp.business.gamedetail.base.model.c r143 = r102.e();     // Catch: Throwable -> L84
            if (r143 == null) goto L139;
            r143.D(r141);     // Catch: Throwable -> L84
        L139:
            r101 = com.bytedance.android.gamecp.common.utils.e0.h(r102);     // Catch: Throwable -> L84
            goto L142
        L125:
            if (r141.length() == 0) goto L128;
            r129 = false;
        L122:
            r141 = null;
        L111:
            r139 = null;
        L105:
            r137 = null;
            goto L106
        L99:
            r134 = AudioStats.AUDIO_AMPLITUDE_NONE;
            goto L100
        L96:
            r133 = null;
        L93:
            r132 = null;
            goto L94
        L81:
            r130 = false;
            goto L82
        L75:
            r128 = null;
        L86:
            r129 = true;
            goto L87
        L70:
            r125 = null;
            goto L71
        L67:
            r124 = null;
        L64:
            r123 = null;
        L84:
            th = move-exception;
            yr.c.b("game-promote", "修改微端包大小失败 : " + th.getMessage());
            goto L142
        L5:
            r101 = null;
            goto L6
        }
    }

    static {
    }

    public h0() {
    }
}

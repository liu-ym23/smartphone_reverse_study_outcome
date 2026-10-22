package com.bytedance.android.livesdk.player.vr;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.roomplayer.VrBgLogData;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/player/vr/VrBgImageEventController;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/android/livesdkapi/roomplayer/VrBgLogData;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "platform-player-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VrBgImageEventController implements Observer<VrBgLogData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f156248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f156249b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f156250c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<String, String> f156251d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f156252e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f156253f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f156254g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f156255h;

    public static final class a {
    }

    static {
    }

    public VrBgImageEventController() {
        this.f156251d = new HashMap();
        this.f156252e = -1;
        this.f156253f = -1;
        this.f156254g = -1;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r110) {
        VrBgLogData r111 = (VrBgLogData) r110;
        if (r111 == null) goto L103;
        ALogger.d("VrBgImageEventController", "New VrBgLogData received: " + r111 + '.');
        if (r111.getRoomEntered() == false) goto L8;
        this.f156248a = r111.getRoomEntered();
        ALogger.d("VrBgImageEventController", "Room entered.");
    L8:
        if (r111.getFirstFrameRendered() == false) goto L11;
        this.f156249b = r111.getFirstFrameRendered();
        ALogger.d("VrBgImageEventController", "First frame rendered.");
    L11:
        if (r111.getBgRendered() == false) goto L13;
        this.f156250c = r111.getBgRendered();
        ALogger.d("VrBgImageEventController", "Background image rendered.");
    L13:
        HashMap<String, String> r100 = r111.getExtra();
        boolean r101 = r111.getBgRendered();
        if (r111.getFirstFrameRendered() == false) goto L16;
    L19:
        boolean r112 = true;
    L20:
        String r102 = "";
        if (r101 == true) goto L99;
    L38:
        if (r112 == false) goto L78;
        String r113 = r100.get(VrBgLogData.KEY_PREVIEW_RENDER_START_TIME);     // Catch: Exception -> L43
        if (r113 == null) goto L44;
        long r103 = CastLongProtector.parseLong(r113);     // Catch: Exception -> L43
    L45:
        this.f156252e = r103;
        this.f156255h = Intrinsics.areEqual("true", r100.get(VrBgLogData.KEY_ENTER_FROM_PREVIEW));
        HashMap<String, String> r114 = this.f156251d;
        String r104 = r100.get("anchor_id");
        if (r104 != null) goto L48;
        r104 = "";
    L48:
        r114.put("anchor_id", r104);
        HashMap<String, String> r115 = this.f156251d;
        String r105 = r100.get("room_id");
        if (r105 != null) goto L51;
        r105 = "";
    L51:
        r115.put("room_id", r105);
        HashMap<String, String> r116 = this.f156251d;
        String r106 = r100.get("enter_method");
        if (r106 != null) goto L54;
        r106 = "";
    L54:
        r116.put("enter_method", r106);
        HashMap<String, String> r117 = this.f156251d;
        String r107 = r100.get("enter_from_merge");
        if (r107 != null) goto L57;
        r107 = "";
    L57:
        r117.put("enter_from_merge", r107);
        HashMap<String, String> r118 = this.f156251d;
        String r108 = r100.get(VrBgLogData.KEY_VR_TYPE);
        if (r108 != null) goto L60;
        r108 = "";
    L60:
        r118.put(VrBgLogData.KEY_VR_TYPE, r108);
        HashMap<String, String> r119 = this.f156251d;
        String r109 = r100.get(VrBgLogData.KEY_VR_SUB_TYPE);
        if (r109 != null) goto L63;
        r109 = "";
    L63:
        r119.put(VrBgLogData.KEY_VR_SUB_TYPE, r109);
        HashMap<String, String> r120 = this.f156251d;
        String r121 = r100.get("image_type");
        if (r121 != null) goto L66;
        r121 = "";
    L66:
        r120.put("image_type", r121);
        HashMap<String, String> r122 = this.f156251d;
        String r123 = r100.get(VrBgLogData.KEY_IS_PREVIEW);
        if (r123 != null) goto L69;
        r123 = "";
    L69:
        r122.put(VrBgLogData.KEY_IS_PREVIEW, r123);
        HashMap<String, String> r124 = this.f156251d;
        String r125 = r100.get(VrBgLogData.KEY_ENTER_DURATION);
        if (r125 != null) goto L72;
        r125 = "";
    L72:
        r124.put(VrBgLogData.KEY_ENTER_DURATION, r125);
        HashMap<String, String> r126 = this.f156251d;
        String r127 = r100.get(VrBgLogData.KEY_IS_PREVIEW);
        if (r127 == null) goto L76;
        r102 = r127;
    L76:
        r126.put(VrBgLogData.KEY_IS_PREVIEW, r102);
    L44:
        r103 = -1;
    L78:
        if (this.f156248a == true) goto L82;
        if (this.f156249b == true) goto L82;
        return;
    L82:
        if (this.f156250c == true) goto L84;
        return;
    L84:
        if (this.f156255h == false) goto L86;
        ALogger.d("VrBgImageEventController", "Skip upload background duration because entered from preview.");
    L94:
        ALogger.d("VrBgImageEventController", "Ready to upload background image event with content: " + this.f156251d + '.');
        j0.l().sendLog(VrBgLogData.VR_BG_EVENT_NAME, this.f156251d, new Object[0]);
        ALogger.d("VrBgImageEventController", "Background image event has been uploaded, ready to reset data.");
        this.f156248a = false;
        this.f156249b = false;
        this.f156250c = false;
        this.f156252e = -1;
        this.f156253f = -1;
        this.f156254g = -1;
        this.f156255h = false;
        this.f156251d.clear();
        return;
    L86:
        HashMap<String, String> r128 = this.f156251d;
        long r129 = this.f156253f;
        long r130 = this.f156252e;
        String r131 = "0";
        if (r129 <= r130) goto L89;
        String r132 = String.valueOf(r129 - r130);
    L90:
        r128.put("duration", r132);
        HashMap<String, String> r133 = this.f156251d;
        long r134 = this.f156254g;
        long r135 = this.f156252e;
        if (r134 <= r135) goto L93;
        r131 = String.valueOf(r134 - r135);
    L93:
        r133.put(VrBgLogData.KEY_DURATION_1K, r131);
        goto L94
    L89:
        r132 = "0";
        goto L90
    L99:
        String r136 = r100.get(VrBgLogData.KEY_BG_RENDER_END_TIME);     // Catch: Exception -> L96
        if (r136 == null) goto L26;
        long r137 = CastLongProtector.parseLong(r136);     // Catch: Exception -> L96
    L27:
        this.f156253f = r137;
        String r138 = r100.get(VrBgLogData.KEY_1K_BG_RENDER_END_TIME);     // Catch: Exception -> L32
        if (r138 == null) goto L33;
        long r139 = CastLongProtector.parseLong(r138);     // Catch: Exception -> L32
    L34:
        this.f156254g = r139;
        HashMap<String, String> r140 = this.f156251d;
        String r141 = r100.get(VrBgLogData.KEY_VR_VIEW);
        if (r141 != null) goto L37;
        r141 = "";
    L37:
        r140.put(VrBgLogData.KEY_VR_VIEW, r141);
    L33:
        r139 = -1;
    L26:
        r137 = -1;
        goto L27
    L16:
        if (r111.getRoomEntered() == true) goto L19;
        r112 = false;
        goto L20
    }
}

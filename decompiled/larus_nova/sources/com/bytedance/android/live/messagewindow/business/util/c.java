package com.bytedance.android.live.messagewindow.business.util;

import android.text.TextUtils;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Keva f83006a = null;

    static {
        f83006a = Keva.getRepo("common_card_params_record");
    }

    @JvmStatic
    public static final int a(String r110, Integer r210, boolean r211) {
        String r100 = "put";
        int r101 = 0;
        if (r210 != null) goto L5;
        return 0;
    L5:
        String r102 = Intrinsics.stringPlus(r110, r210);
        Keva r103 = f83006a;
        if (r103 == null) goto L8;
        String r104 = r103.getString("card_close_times", "");
    L9:
        mm0.a r105 = (mm0.a) JsonUtil.parse(r104, mm0.a.class);
        if (r105 != null) goto L12;
        r105 = new mm0.a();
    L12:
        long r111 = System.currentTimeMillis();
        long r112 = Math.abs(r111 - Long.valueOf(r105.f514410a).longValue());     // Catch: Exception -> L48
        long r113 = BaseConstants.Time.DAY;
        if (r112 > r113) goto L63;
    L20:
        HashMap<String, Pair<Object, Long>> r114 = r105.f514411b;     // Catch: Exception -> L48
        r105.f514410a = r111;     // Catch: Exception -> L48
        if (r114 == null) goto L26;
        Set<Map.Entry<String, Pair<Object, Long>>> r115 = r114.entrySet();     // Catch: Exception -> L18
        if (r115 == null) goto L26;
        Iterator<Map.Entry<String, Pair<Object, Long>>> r116 = r115.iterator();     // Catch: Exception -> L18
    L27:
        if (r116 == null) goto L39;
        if (r116.hasNext() != true) goto L39;
        Map.Entry<String, Pair<Object, Long>> r106 = r116.next();     // Catch: Exception -> L48
        if (Math.abs(r111 - r106.getValue().getSecond().longValue()) <= r113) goto L34;
        r116.remove();     // Catch: Exception -> L48
        goto L27
    L34:
        if (TextUtils.equals(r102, r106.getKey()) == false) goto L27;
        r101 = CastIntegerProtector.parseInt(String.valueOf(r106.getValue().getFirst()));     // Catch: Exception -> L48
        if (r114 == null) goto L40;
        Pair<Object, Long> r107 = r114.put(r102, new Pair(String.valueOf(r101), Long.valueOf(r111)));     // Catch: Exception -> L18
    L40:
        if (r211 == false) goto L55;
        r101 = r101 + 1;     // Catch: Exception -> L18
        if (r114 == null) goto L44;
        Pair<Object, Long> r108 = r114.put(r102, new Pair(String.valueOf(r101), Long.valueOf(r111)));     // Catch: Exception -> L18
    L44:
        Keva r109 = f83006a;     // Catch: Exception -> L18
        if (r109 == null) goto L55;
        r109.storeString("card_close_times", GsonHelper.get().toJson(r105));     // Catch: Exception -> L18
    L18:
        e = e;
    L50:
        SafetyGuard.a(null, e, null);
        StringBuilder r117 = new StringBuilder("error ");
        if (r211 == false) goto L53;
        String r118 = "put";
    L54:
        r117.append(r118);
        r117.append(" card ");
        r117.append(r210);
        r117.append(" MicRoomCloseTimes in keva");
        ALogger.e("RecordCardParamsHelper", r117.toString());
        goto L55
    L53:
        r118 = MonitorConstants.CONNECT_TYPE_GET;
    L55:
        StringBuilder r119 = new StringBuilder();
        if (r211 == true) goto L59;
        r100 = MonitorConstants.CONNECT_TYPE_GET;
    L59:
        r119.append(r100);
        r119.append(" card ");
        r119.append(r210);
        r119.append(" MicRoomCloseTimes ");
        r119.append(r101);
        r119.append(" in keva");
        ALogger.d("RecordCardParamsHelper", r119.toString());
        return r101;
    L39:
        r101 = 0;
    L26:
        r116 = null;
        goto L27
    L63:
        HashMap<String, Pair<Object, Long>> r120 = new HashMap();     // Catch: Exception -> L18
        Intrinsics.checkNotNullParameter(r120, "<set-?>");     // Catch: Exception -> L18
        r105.f514411b = r120;     // Catch: Exception -> L18
    L48:
        e = e;
        r101 = 0;
        goto L50
    L8:
        r104 = null;
        goto L9
    }

    @JvmStatic
    public static final long b(String r100, Integer r110, boolean r111) {
        long r101 = System.currentTimeMillis();
        String r102 = Intrinsics.stringPlus(r100, r110);
        long r103 = 0;
        if (r110 == null) goto L14;
        r110.intValue();
        Keva r112 = f83006a;
        if (r112 == null) goto L8;
        r103 = r112.getLong(r102, 0);
    L8:
        if ((r101 - r103) <= BaseConstants.Time.DAY) goto L11;
        if (r112 == null) goto L11;
        r112.erase(r102);
    L11:
        if (r111 == false) goto L14;
        if (r112 == null) goto L14;
        r112.storeLong(r102, r101);
    L14:
        StringBuilder r104 = new StringBuilder();
        if (r111 == false) goto L17;
        String r113 = "put";
    L18:
        r104.append(r113);
        r104.append(" CardLastShowTime ");
        r104.append(r103);
        r104.append(" in keva");
        ALogger.d("RecordCardParamsHelper", r104.toString());
        return r103;
    L17:
        r113 = MonitorConstants.CONNECT_TYPE_GET;
        goto L18
    }

    @JvmStatic
    public static final boolean c(String r110, String r111, Integer r112, boolean r113) {
        String r100 = r111 + r112 + r110;
        Keva r101 = f83006a;
        if (r101 == null) goto L5;
        String r102 = r101.getString("is_same_anchor_info", "");
    L6:
        mm0.a r103 = (mm0.a) JsonUtil.parse(r102, mm0.a.class);
        if (r103 != null) goto L9;
        r103 = new mm0.a();
    L9:
        long r104 = System.currentTimeMillis();
        long r105 = Math.abs(r104 - Long.valueOf(r103.f514410a).longValue());     // Catch: Exception -> L35
        long r106 = BaseConstants.Time.DAY;
        if (r105 <= r106) goto L13;
        HashMap<String, Pair<Object, Long>> r107 = new HashMap();     // Catch: Exception -> L35
        Intrinsics.checkNotNullParameter(r107, "<set-?>");     // Catch: Exception -> L35
        r103.f514411b = r107;     // Catch: Exception -> L35
    L13:
        HashMap<String, Pair<Object, Long>> r108 = r103.f514411b;     // Catch: Exception -> L35
        r103.f514410a = r104;     // Catch: Exception -> L35
        if (r108 == null) goto L18;
        Set<Map.Entry<String, Pair<Object, Long>>> r109 = r108.entrySet();     // Catch: Exception -> L35
        if (r109 == null) goto L18;
        Iterator<Map.Entry<String, Pair<Object, Long>>> r114 = r109.iterator();     // Catch: Exception -> L35
    L19:
        if (r114 == null) goto L28;
        if (r114.hasNext() != true) goto L28;
        Map.Entry<String, Pair<Object, Long>> r115 = r114.next();     // Catch: Exception -> L35
        if (Math.abs(r104 - r115.getValue().getSecond().longValue()) > r106) goto L24;
        if (TextUtils.equals(r100, r115.getKey()) == false) goto L19;
        return true;
    L24:
        r114.remove();     // Catch: Exception -> L35
    L28:
        if (r113 == false) goto L54;
        if (r108 == null) goto L31;
        Pair<Object, Long> r116 = r108.put(r100, new Pair(r100, Long.valueOf(r104)));     // Catch: Exception -> L35
    L31:
        Keva r117 = f83006a;     // Catch: Exception -> L35
        if (r117 == null) goto L55;
        r117.storeString("is_same_anchor_info", GsonHelper.get().toJson(r103));     // Catch: Exception -> L35
        return false;
    L55:
        return false;
    L54:
        return false;
    L18:
        r114 = null;
    L35:
        e = move-exception;
        SafetyGuard.a(null, e, null);
        StringBuilder r118 = new StringBuilder("error ");
        if (r113 == false) goto L39;
        String r119 = "put";
    L40:
        r118.append(r119);
        r118.append(" card ");
        r118.append(r112);
        r118.append(" IsSameAnchorInfo in keva");
        ALogger.e("RecordCardParamsHelper", r118.toString());
        return false;
    L39:
        r119 = MonitorConstants.CONNECT_TYPE_GET;
        goto L40
    L5:
        r102 = null;
        goto L6
    }
}

package com.bytedance.android.live.network.impl.interceptor;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.live.core.cache.LruCache;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.network.impl.interceptor.business.MultiLinkCPInterceptor;
import com.bytedance.android.livesdk.config.cp0;
import com.bytedance.android.livesdk.config.hg1;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes46.dex */
public class b implements com.bytedance.android.live.network.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.live.network.impl.interceptor.business.a f83859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String[] f83860b;

    public void b(Map<String, String> r100) {
        throw null;
    }

    public b() {
        com.bytedance.android.live.network.impl.interceptor.business.a r100 = new com.bytedance.android.live.network.impl.interceptor.business.a();
        MultiLinkCPInterceptor r101 = new MultiLinkCPInterceptor();
        Intrinsics.checkNotNullParameter(r101, "businessCPInterceptor");
        r100.f83864a.add(r101);
        this.f83859a = r100;
        this.f83860b = new String[]{"CN", "MR", "SA", "FR", "AE"};
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String a(boolean r110, String r111, String r112, byte[] r113) {
        if (TextUtils.isEmpty(r111) == false) goto L5;
        return r111;
    L5:
        Uri r100 = UriProtector.parse(r111);
        if (r100.isOpaque() == false) goto L8;
    L10:
        String r101 = UriProtector.parse(r111).getPath();
        if (r110 == true) goto L13;
        LruCache r102 = co0.c.f24604a;
        if (r111 == null) goto L92;
        hg1 r103 = cp0.f119970a.getValue();
        if (r103 == null) goto L92;
        if (r103.b(r101) != true) goto L92;
        String r104 = co0.c.b(r111, r101);
        boolean r105 = false;
        if (r104 == null) goto L24;
        int r106 = r104.length();
    L25:
        String r107 = null;
        if (r106 <= r111.length()) goto L31;
        if (r104 == null) goto L31;
        if (StringsKt.contains$default(r104, "r_signature", false, 2, null) != true) goto L31;
        return r104;
    L31:
        if (r113 != null) goto L34;
    L74:
        String r108 = "";
    L76:
        if (r108.length() != 0) goto L78;
        boolean r109 = true;
    L79:
        if (r109 == true) goto L92;
        LruCache r114 = co0.c.f24604a;
        if (r114 == null) goto L84;
        r107 = (String) r114.get(r108);
    L84:
        if (r107 == null) goto L92;
        if (r107.length() <= 0) goto L88;
        r105 = true;
    L88:
        if (r105 != true) goto L92;
        return co0.c.a(r111, r107);
    L78:
        r109 = false;
        goto L79
    L34:
        if (Intrinsics.areEqual(r112, "application/x-www-form-urlencoded; charset=UTF-8") == false) goto L74;
        String r115 = new String(r113, Charsets.UTF_8);     // Catch: Exception -> L37
    L39:
        if (r115 == null) goto L74;
        if (r115.length() <= 0) goto L43;
        boolean r116 = true;
    L44:
        if (r116 != true) goto L74;
        int r117 = StringsKt.indexOf$default(r115, "room_id=", 0, false, 6, null);
        if (r117 < 0) goto L74;
        int r118 = r115.length();
        int r119 = r117 + 8;
        if (r119 < 0) goto L74;
        if (r118 < r119) goto L74;
        r108 = r115.substring(r119);
        if (r108 == null) goto L74;
        if (r108.length() <= 0) goto L57;
        boolean r120 = true;
    L58:
        if (r120 != true) goto L74;
        int r121 = r108.length();
        int r122 = 0;
    L62:
        if (r122 >= r121) goto L67;
        if (Character.isDigit(r108.charAt(r122)) == false) goto L68;
        r122 = r122 + 1;
    L68:
        if (r122 == (-1)) goto L76;
        if (r122 <= 0) goto L74;
        if (r122 > r108.length()) goto L74;
        r108 = r108.substring(0, r122);
        goto L76
    L67:
        r122 = -1;
        goto L68
    L57:
        r120 = false;
        goto L58
    L43:
        r116 = false;
    L37:
        e = move-exception;
        SafetyGuard.a(null, e, "RoomParamHandler bytes to string error");
        ALogger.i("RoomParamHandler", "bytes to string error: " + e.getMessage());
        r115 = null;
        goto L39
    L24:
        r106 = 0;
    L92:
        return r111;
    L13:
        return co0.c.b(r111, r101);
    L8:
        if (UriProtector.getQueryParameter(r100, "r_signature") == null) goto L10;
        return r111;
    }
}

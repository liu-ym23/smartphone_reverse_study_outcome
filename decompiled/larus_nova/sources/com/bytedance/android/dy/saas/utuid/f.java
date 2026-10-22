package com.bytedance.android.dy.saas.utuid;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.android.live.saas.middleware.utuid.UtUidInitTask;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.RandomKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class f implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f42651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f42652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f42653c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f42654d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f42655e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f42656f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static nd.a f42657g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f42658h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final f f42659i = null;

    public f() {
    }

    static {
        f42659i = new f();
    }

    @Override // com.bytedance.android.dy.saas.utuid.d
    public final String b() {
        String r100 = f42652b;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("innerUt");
    L5:
        return r100;
    }

    @Override // com.bytedance.android.dy.saas.utuid.d
    public final String c() {
        String r100 = f42654d;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("innerSecUt");
    L5:
        return r100;
    }

    @Override // com.bytedance.android.dy.saas.utuid.d
    public final String getSalt() {
        String r100 = f42656f;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("innerSalt");
    L5:
        return r100;
    }

    @Override // com.bytedance.android.dy.saas.utuid.d
    public final String getSecUid() {
        String r100 = f42655e;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("innerSecUid");
    L5:
        return r100;
    }

    @Override // com.bytedance.android.dy.saas.utuid.d
    public final String getUid() {
        String r100 = f42653c;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("innerUid");
    L5:
        return r100;
    }

    @Override // com.bytedance.android.dy.saas.utuid.d
    public final boolean a() {
        return f42651a;
    }

    public static final boolean d(Application r210, e r211, String r310) {
        f r100 = f42659i;
        Random r101 = RandomKt.Random(System.currentTimeMillis());
        int r102 = r101.nextInt(1000000, 9999999);
        int r103 = c.f42643a;
        String r104 = c.d(r102 + r211.f42646c);
        if (r104 == null) goto L90;
        String r105 = r104.substring(0, 10);
        if (StringsKt.startsWith$default(r211.f42648e, "enc_", false, 2, null) == false) goto L15;
        String r106 = r211.f42648e;
        if (r106 == null) goto L14;
        String r107 = r106.substring(4);
        String r110 = c.d(r211.f42645b);
        if (r110 == null) goto L12;
        String r108 = c.a(r107, r110.substring(0, 16));
    L17:
        if (StringsKt.startsWith$default(r211.f42647d, "enc_", false, 2, null) == false) goto L27;
        String r109 = r211.f42647d;
        if (r109 == null) goto L26;
        String r111 = r109.substring(4);
        String r112 = c.d(r211.f42645b);
        if (r112 == null) goto L24;
        String r113 = c.a(r111, r112.substring(0, 16));
    L28:
        String r114 = "https://mercury-sdk.snssdk.com/access_token/register/wap/v4/?partner=" + r113;
        Map<String, String> r115 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("Salt", r105), TuplesKt.to("webcast-app-id", r211.f42645b), TuplesKt.to("Content-Type", "application/x-www-form-urlencoded")});
        nd.a r116 = f42657g;
        String r117 = "";
        if (r116 == null) goto L35;
        String r118 = r116.getSdkVersion();
        if (r118 != null) goto L34;
        r118 = "";
    L34:
        String r119 = r115.put("webcast-sdk-version", r118);
    L35:
        String r120 = String.valueOf(System.currentTimeMillis() / ((long) 1000));
        String r121 = String.valueOf(r101.nextInt(100000, 999999));
        Map r122 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(ST.UUID_DEVICE, r310), TuplesKt.to("timestamp", r120), TuplesKt.to("appid", r211.f42646c), TuplesKt.to("nonce", r121), TuplesKt.to("signature", c.d(CollectionsKt.joinToString$default(CollectionsKt.sorted(CollectionsKt.listOf(new String[]{r108, r120, r121, r310})), "", null, null, 0, null, null, 62, null)))});
        nd.a r123 = f42657g;
        if (r123 == null) goto L42;
        String r124 = r123.getSdkVersion();
        if (r124 == null) goto L40;
        r117 = r124;
    L40:
        String r125 = (String) r122.put("sdk_version", r117);
    L42:
        if (r211.f42649f.length() <= 0) goto L44;
        boolean r126 = true;
    L45:
        if (r126 == false) goto L48;
        r122.put("original_partner", r211.f42649f);
    L48:
        if (r211.f42650g.length() <= 0) goto L50;
        boolean r127 = true;
    L51:
        if (r127 == false) goto L53;
        r122.put("original_uuid", r211.f42650g);
    L53:
        ArrayList r128 = new ArrayList(r122.size());
        Iterator r129 = r122.entrySet().iterator();
    L55:
        if (r129.hasNext() == false) goto L57;
        Map.Entry r130 = (Map.Entry) r129.next();
        r128.add(((String) r130.getKey()) + com.alipay.sdk.m.n.a.f25612h + URLEncoder.encode((String) r130.getValue(), XML.CHARSET_UTF8));
        goto L55
    L57:
        String r131 = CollectionsKt.joinToString$default(r128, "&", null, null, 0, null, null, 62, null);
        int r132 = c.f42643a;
        String r133 = c.c("MD5", r108 + r105);
        if (r133 == null) goto L88;
        String r134 = r133.toLowerCase();
        if (r134 == null) goto L86;
        String r135 = r134.substring(0, 16);
        String r136 = c.b(r131, r135);
        Charset r137 = Charsets.UTF_8;
        if (r136 == null) goto L84;
        byte[] r138 = r136.getBytes(r137);
        nd.a r139 = f42657g;
        if (r139 == null) goto L66;
        String r140 = r139.post(r114, r138, r115);
    L67:
        if (r140 != null) goto L69;
    L72:
        if (r140 == null) goto L91;
    L74:
        if (GsonProtectorUtils.parse(new JsonParser(), c.a(r140, r135)).getAsJsonObject().get("ret").getAsInt() != 0) goto L81;
        SharedPreferences r141 = r210.getSharedPreferences("IUtUidStore", 0);
        r141.edit().putString("salt_seed", String.valueOf(r102)).putString("enc_content", r140).commit();
        r100.g(r141, String.valueOf(r102), r211);
        return true;
    L81:
        return false;
    L79:
        e = move-exception;
        e.printStackTrace();
        e.toString();
        goto L81
    L91:
        Intrinsics.throwNpe();     // Catch: IllegalArgumentException -> L79
        goto L74
    L69:
        if (StringsKt.startsWith$default(r140, "{", false, 2, null) != true) goto L72;
    L66:
        r140 = null;
        goto L67
    L84:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L86:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L88:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L50:
        r127 = false;
        goto L51
    L44:
        r126 = false;
        goto L45
    L24:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L26:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L27:
        r113 = r211.f42647d;
        goto L28
    L12:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L14:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L15:
        r108 = r211.f42648e;
        goto L17
    L90:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public static void e(final Application r100, final e r101, final String r110) {
        final a r102 = null;
        ThreadsKt.thread$default(false, false, null, null, 0, new UtUidStoreImpl$asyncFetch$1(r100, r101, r110, r102), 31, null);
    }

    public static void f(Context r100, final e r101, final UtUidInitTask.C99601 r110) {
        final SharedPreferences r102 = r100.getSharedPreferences("IUtUidStore", 0);
        final String r103 = r102.getString("salt_seed", null);
        if (r103 != null) goto L6;
        r110.onSuccess(Boolean.FALSE);
        return;
    L6:
        ThreadsKt.thread$default(false, false, null, null, 0, new UtUidStoreImpl$asyncLoad$1(r102, r103, r101, r110), 31, null);
    }

    public final synchronized void g(SharedPreferences r100, String r101, e r102) {
        monitor-enter(this);
    L73:
        th = move-exception;
        throw th;
    L4:
        if (f42658h == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        f42658h = true;     // Catch: Throwable -> L73
        String r103 = r100.getString("enc_content", null);     // Catch: Throwable -> L70
        if (r103 != null) goto L13;
    L68:
        f42658h = false;     // Catch: Throwable -> L70
    L71:
        monitor-exit(this);
        return;
    L13:
        if (r103.length() <= 0) goto L15;
        boolean r104 = true;
    L16:
        if (r104 != true) goto L68;
        if (StringsKt.startsWith$default(r103, "{", false, 2, null) == false) goto L22;
        f42658h = false;     // Catch: Throwable -> L70
        monitor-exit(this);
        return;
    L22:
        int r105 = c.f42643a;     // Catch: Throwable -> L70
        String r106 = c.d(r101 + r102.f42646c);     // Catch: Throwable -> L70
        if (r106 == null) goto L67;
        f42656f = r106.substring(0, 10);     // Catch: Throwable -> L70
        if (StringsKt.startsWith$default(r102.f42648e, "enc_", false, 2, null) == false) goto L35;
        String r107 = r102.f42648e;     // Catch: Throwable -> L70
        if (r107 == null) goto L34;
        String r108 = r107.substring(4);     // Catch: Throwable -> L70
        String r109 = c.d(r102.f42645b);     // Catch: Throwable -> L70
        if (r109 == null) goto L32;
        String r110 = c.a(r108, r109.substring(0, 16));     // Catch: Throwable -> L70
    L36:
        StringBuilder r111 = new StringBuilder();     // Catch: Throwable -> L70
        r111.append(r110);     // Catch: Throwable -> L70
        String r112 = f42656f;     // Catch: Throwable -> L70
        if (r112 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("innerSalt");     // Catch: Throwable -> L70
    L39:
        r111.append(r112);     // Catch: Throwable -> L70
        String r113 = c.c("MD5", r111.toString());     // Catch: Throwable -> L70
        if (r113 == null) goto L65;
        String r114 = r113.toLowerCase();     // Catch: Throwable -> L70
        if (r114 == null) goto L63;
        JsonObject r115 = new JsonParser().parse(c.a(r103, r114.substring(0, 16))).getAsJsonObject();     // Catch: Throwable -> L70
        if (r115.get("ret").getAsInt() == 0) goto L48;
        f42658h = false;     // Catch: Throwable -> L70
        monitor-exit(this);
        return;
    L48:
        JsonObject r116 = r115.getAsJsonObject("data");     // Catch: Throwable -> L70
        f42653c = r116.get("user_id").getAsString();     // Catch: Throwable -> L70
        f42652b = r116.get("user_type").getAsString();     // Catch: Throwable -> L70
        StringBuilder r117 = new StringBuilder();     // Catch: Throwable -> L70
        r117.append(r102.f42645b);     // Catch: Throwable -> L70
        String r118 = f42656f;     // Catch: Throwable -> L70
        if (r118 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("innerSalt");     // Catch: Throwable -> L70
    L51:
        r117.append(r118);     // Catch: Throwable -> L70
        String r119 = c.d(r117.toString());     // Catch: Throwable -> L70
        if (r119 == null) goto L61;
        String r120 = r119.substring(0, 16);     // Catch: Throwable -> L70
        String r121 = f42653c;     // Catch: Throwable -> L70
        if (r121 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("innerUid");     // Catch: Throwable -> L70
    L56:
        f42655e = c.b(r121, r120);     // Catch: Throwable -> L70
        String r122 = f42652b;     // Catch: Throwable -> L70
        if (r122 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("innerUt");     // Catch: Throwable -> L70
    L59:
        f42654d = c.b(r122, r120);     // Catch: Throwable -> L70
        f42651a = true;     // Catch: Throwable -> L70
        goto L68
    L61:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");     // Catch: Throwable -> L70
    L63:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");     // Catch: Throwable -> L70
    L65:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");     // Catch: Throwable -> L70
    L32:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");     // Catch: Throwable -> L70
    L34:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");     // Catch: Throwable -> L70
    L35:
        r110 = r102.f42648e;     // Catch: Throwable -> L70
        goto L36
    L67:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");     // Catch: Throwable -> L70
    L15:
        r104 = false;
    L70:
        f42658h = false;     // Catch: Throwable -> L73
        goto L71
    }
}

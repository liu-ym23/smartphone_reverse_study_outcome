package com.amap.api.location;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import com.amap.api.col.s.ce;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.loc.c;
import com.loc.j;
import com.loc.u;
import n4a.c4;
import n4a.c5;
import n4a.e5;
import n4a.h4;
import n4a.j4;
import n4a.k1;
import n4a.s4;
import n4a.t4;
import n4a.v3;
import n4a.v4;
import n4a.x1;
import n4a.x4;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class AMapLocationClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Context f26716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    x1 f26717b;

    public AMapLocationClient(Context r100) throws Exception {
        a(r100);
        if (r100 == null) goto L9;
        this.f26716a = r100.getApplicationContext();     // Catch: Throwable -> L6
        this.f26717b = new x1(r100, null, null);     // Catch: Throwable -> L6
        return;
    L9:
        throw new IllegalArgumentException("Context参数不能为null");     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        c4.g(th, "AMClt", "ne1");
    }

    public AMapLocationClient(Context r100, Intent r101) throws Exception {
        a(r100);
        if (r100 == null) goto L9;
        this.f26716a = r100.getApplicationContext();     // Catch: Throwable -> L6
        this.f26717b = new x1(this.f26716a, r101, null);     // Catch: Throwable -> L6
        return;
    L9:
        throw new IllegalArgumentException("Context参数不能为null");     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        c4.g(th, "AMClt", "ne2");
    }

    public AMapLocationClient(Looper r100, Context r101) throws Exception {
        a(r101);
        if (r101 == null) goto L9;
        this.f26716a = r101.getApplicationContext();     // Catch: Throwable -> L6
        this.f26717b = new x1(this.f26716a, null, r100);     // Catch: Throwable -> L6
        return;
    L9:
        throw new IllegalArgumentException("Context参数不能为null");     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        c4.g(th, "AMClt", "ne3");
    }

    public static void setApiKey(String r100) {
        AMapLocationClientOption.f26718a = r100;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        c4.g(th, "AMClt", "sKey");
    }

    public static void setHost(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        c.f379954a = -1;
        r100 = "";
    L5:
        c.f379955b = r100;
        return;
    L7:
        c.f379954a = 1;
        goto L5
    }

    public void enableBackgroundLocation(int r100, Notification r101) {
        x1 r102 = this.f26717b;     // Catch: Throwable -> L6
        if (r102 == null) goto L11;
        r102.b(r100, r101);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        c4.g(th, "AMClt", "eBackL");
    }

    public AMapLocation getLastKnownLocation() {
        x1 r100 = this.f26717b;     // Catch: Throwable -> L26
        if (r100 != null) goto L33;
    L28:
        return null;
    L33:
        t4 r101 = r100.f517902o;     // Catch: Throwable -> L21
        if (r101 == null) goto L25;
        r101.e();     // Catch: Throwable -> L21
        v3 r102 = t4.f517756g;     // Catch: Throwable -> L21
        if (r102 != null) goto L11;
    L9:
        AMapLocation r103 = null;
    L14:
        if (r103 == null) goto L35;
        r103.setTrustedLevel(3);     // Catch: Throwable -> L18
    L18:
        Throwable th10 = th;
    L23:
        c4.g(th10, "ALManager", "getLastKnownLocation");     // Catch: Throwable -> L26
    L35:
        return r103;
    L11:
        if (j4.l(r102.f517830d) == false) goto L9;
        r103 = t4.f517756g.f517830d;     // Catch: Throwable -> L21
        goto L14
    L25:
        return null;
    L21:
        th = move-exception;
        th10 = th;
        r103 = null;
    L26:
        th = move-exception;
        c4.g(th, "AMClt", "gLastL");
        goto L28
    }

    public String getVersion() {
        return "6.4.8";
    }

    public void startAssistantLocation(WebView r100) {
        x1 r101 = this.f26717b;     // Catch: Throwable -> L6
        if (r101 == null) goto L11;
        r101.g(r100);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        c4.g(th, "AMClt", "sttAssL1");
    }

    public boolean isStarted() {
        x1 r100 = this.f26717b;     // Catch: Throwable -> L6
        if (r100 == null) goto L12;
        return r100.f517895h;
    L12:
        return false;
    L6:
        th = move-exception;
        c4.g(th, "AMClt", "isS");
        return false;
    }

    public void onDestroy() {
        x1 r100 = this.f26717b;     // Catch: Throwable -> L13
        if (r100 == null) goto L19;
        r100.getClass();     // Catch: Throwable -> L13
        s4 r101 = r100.A;     // Catch: Throwable -> L10
        if (r101 == null) goto L8;
        r101.b();     // Catch: Throwable -> L10
        r100.A = null;     // Catch: Throwable -> L10
    L8:
        r100.d(1011, null, 0);     // Catch: Throwable -> L10
        r100.f517907t = true;     // Catch: Throwable -> L10
    L20:
        return;
    L10:
        th = move-exception;
        c4.g(th, "ALManager", LiveCommonConstants.REASON_ON_DEDTROY);     // Catch: Throwable -> L13
        return;
    L19:
        return;
    L13:
        th = move-exception;
        c4.g(th, "AMClt", "onDy");
    }

    public void startLocation() {
        x1 r100 = this.f26717b;     // Catch: Throwable -> L16
        if (r100 == null) goto L25;
        r100.getClass();     // Catch: Throwable -> L16
        if (r100.f517913z.getCacheCallBack() == false) goto L21;
        x1.e r101 = r100.f517891d;     // Catch: Throwable -> L19
        if (r101 == null) goto L21;
        r101.sendEmptyMessageDelayed(13, r100.f517913z.getCacheCallBackTime());     // Catch: Throwable -> L19
    L21:
        r100.d(1003, null, 0);     // Catch: Throwable -> L13
    L26:
        return;
    L13:
        th = move-exception;
        c4.g(th, "ALManager", "startLocation");     // Catch: Throwable -> L16
        return;
    L25:
        return;
    L16:
        th = move-exception;
        c4.g(th, "AMClt", "stl");
    }

    public void stopAssistantLocation() {
        x1 r100 = this.f26717b;     // Catch: Throwable -> L12
        if (r100 == null) goto L19;
        r100.getClass();     // Catch: Throwable -> L12
        s4 r101 = r100.A;     // Catch: Throwable -> L9
        if (r101 == null) goto L20;
        r101.b();     // Catch: Throwable -> L9
        r100.A = null;     // Catch: Throwable -> L9
    L21:
        return;
    L20:
        return;
    L9:
        th = move-exception;
        c4.g(th, "ALManager", "stopAssistantLocation");     // Catch: Throwable -> L12
        return;
    L19:
        return;
    L12:
        th = move-exception;
        c4.g(th, "AMClt", "stAssL");
    }

    public void stopLocation() {
        x1 r100 = this.f26717b;     // Catch: Throwable -> L11
        if (r100 == null) goto L18;
        r100.getClass();     // Catch: Throwable -> L11
        r100.d(1004, null, 0);     // Catch: Throwable -> L8
    L19:
        return;
    L8:
        th = move-exception;
        c4.g(th, "ALManager", "stopLocation");     // Catch: Throwable -> L11
        return;
    L18:
        return;
    L11:
        th = move-exception;
        c4.g(th, "AMClt", "stl");
    }

    private static void a(Context r110) throws Exception {
        e5 r100 = c4.k();
        u.b r101 = u.f380160a;
        monitor-enter(u.class);
        if (r110 == null) goto L56;
        if (r100 == null) goto L56;
        if (u.f380171l == true) goto L10;
        u.g(r110);     // Catch: Throwable -> L63
        u.f380171l = true;     // Catch: Throwable -> L63
    L10:
        j r102 = null;
        if (u.f380161b != u.d.f380196c) goto L13;
        boolean r103 = true;
    L20:
        if (r103 == true) goto L22;
    L30:
        if (r103 != true) goto L41;
        if (u.f380165f == u.a.f380175c) goto L41;
        if (u.f380165f != u.a.f380173a) goto L37;
        r102 = new j(u.c.f380188f, r100);     // Catch: Throwable -> L63
    L39:
        r103 = false;
        goto L41
    L37:
        if (u.f380165f != u.a.f380174b) goto L39;
        r102 = new j(u.c.f380189g, r100);     // Catch: Throwable -> L63
    L41:
        if (u.f380170k == u.f380169j) goto L46;
        long r111 = u.f380169j;     // Catch: Throwable -> L63
        u.f380170k = u.f380169j;     // Catch: Throwable -> L63
        JSONObject r112 = new JSONObject();     // Catch: Throwable -> L66
        r112.put("privacyInfo", u.f380160a.a());     // Catch: Throwable -> L66
        r112.put("privacyShow", u.f380161b.a());     // Catch: Throwable -> L66
        r112.put("showTime", u.f380164e);     // Catch: Throwable -> L66
        r112.put("show2SDK", u.f380162c);     // Catch: Throwable -> L66
        r112.put("show2SDKVer", u.f380163d);     // Catch: Throwable -> L66
        r112.put("privacyAgree", u.f380165f.a());     // Catch: Throwable -> L66
        r112.put("agreeTime", u.f380166g);     // Catch: Throwable -> L66
        r112.put("agree2SDK", u.f380167h);     // Catch: Throwable -> L66
        r112.put("agree2SDKVer", u.f380168i);     // Catch: Throwable -> L66
        k1.f517430d.b(new u.e(u.f380172m, r110, r111, r112));     // Catch: Throwable -> L63
    L48:
        u.f380172m = false;     // Catch: Throwable -> L63
        String r113 = v4.g(r110);     // Catch: Throwable -> L63
        if (r113 != null) goto L51;
    L52:
        u.c r114 = u.c.f380190h;     // Catch: Throwable -> L63
        r102 = new j(r114, r100);     // Catch: Throwable -> L63
        r100.a();     // Catch: Throwable -> L63
        String.format("获取apikey失败：\nerrorCode : %d\n原因：%s", new Object[]{Integer.valueOf(r114.a()), r102.f380148b});     // Catch: Throwable -> L63
    L53:
        if (r103 == false) goto L55;
        r102 = new j(u.c.f380183a, r100);     // Catch: Throwable -> L63
    L57:
        monitor-exit(u.class);
        if (r102.f380147a != u.c.f380183a) goto L62;
        return;
    L62:
        throw new Exception(r102.f380148b);
    L55:
        r100.a();     // Catch: Throwable -> L63
        String.format("隐私合规校验失败：\nerrorCode : %d\n原因：%s", new Object[]{Integer.valueOf(r102.f380147a.a()), r102.f380148b});     // Catch: Throwable -> L63
        goto L57
    L51:
        if (r113.length() > 0) goto L53;
    L46:
        if (u.f380172m == false) goto L48;
        k1.f517430d.b(new c5(r110));     // Catch: Throwable -> L63
        goto L48
    L22:
        if (u.f380160a == u.b.f380180c) goto L30;
        if (u.f380160a != u.b.f380178a) goto L27;
        r102 = new j(u.c.f380186d, r100);     // Catch: Throwable -> L63
    L29:
        r103 = false;
        goto L30
    L27:
        if (u.f380160a != u.b.f380179b) goto L29;
        r102 = new j(u.c.f380187e, r100);     // Catch: Throwable -> L63
        goto L29
    L13:
        if (u.f380161b != u.d.f380194a) goto L16;
        r102 = new j(u.c.f380184b, r100);     // Catch: Throwable -> L63
    L18:
        r103 = false;
        goto L20
    L16:
        if (u.f380161b != u.d.f380195b) goto L18;
        r102 = new j(u.c.f380185c, r100);     // Catch: Throwable -> L63
    L56:
        r102 = new j(u.c.f380191i, r100);     // Catch: Throwable -> L63
    L63:
        th = move-exception;
        throw th;
    }

    public static String getDeviceId(Context r100) {
        return "#" + x4.j(r100) + "#" + x4.u(r100);
    }

    public void disableBackgroundLocation(boolean r100) {
        x1 r101 = this.f26717b;     // Catch: Throwable -> L10
        if (r101 == null) goto L16;
        r101.getClass();     // Catch: Throwable -> L10
        Bundle r102 = new Bundle();     // Catch: Throwable -> L7
        r102.putBoolean(ce.f26395j, r100);     // Catch: Throwable -> L7
        r101.d(1024, r102, 0);     // Catch: Throwable -> L7
    L17:
        return;
    L7:
        th = move-exception;
        c4.g(th, "ALManager", "disableBackgroundLocation");     // Catch: Throwable -> L10
        return;
    L16:
        return;
    L10:
        th = move-exception;
        c4.g(th, "AMClt", "dBackL");
    }

    public void setLocationListener(AMapLocationListener r100) {
        if (r100 == null) goto L15;
        x1 r101 = this.f26717b;     // Catch: Throwable -> L12
        if (r101 == null) goto L21;
        r101.getClass();     // Catch: Throwable -> L12
        r101.d(1002, r100, 0);     // Catch: Throwable -> L9
    L22:
        return;
    L9:
        th = move-exception;
        c4.g(th, "ALManager", "setLocationListener");     // Catch: Throwable -> L12
        return;
    L21:
        return;
    L15:
        throw new IllegalArgumentException("listener参数不能为null");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        c4.g(th, "AMClt", "sLocL");
    }

    public void setLocationOption(AMapLocationClientOption r100) {
        if (r100 == null) goto L20;
        x1 r101 = this.f26717b;     // Catch: Throwable -> L17
        if (r101 == null) goto L11;
        r101.getClass();     // Catch: Throwable -> L17
        r101.f517913z = r100.clone();     // Catch: Throwable -> L8
        r101.d(1018, r100.clone(), 0);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        c4.g(th, "ALManager", "setLocationOption");     // Catch: Throwable -> L17
    L11:
        if (r100.f26724b == false) goto L26;
        r100.f26724b = false;     // Catch: Throwable -> L17
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L17
        if (TextUtils.isEmpty(r100.f26725c) == true) goto L15;
        r102.put("amap_loc_scenes_type", r100.f26725c);     // Catch: Throwable -> L17
    L15:
        h4.i(this.f26716a, "O019", r102);     // Catch: Throwable -> L17
        return;
    L26:
        return;
    L20:
        throw new IllegalArgumentException("LocationManagerOption参数不能为null");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        c4.g(th, "AMClt", "sLocnO");
    }

    public void unRegisterLocationListener(AMapLocationListener r100) {
        x1 r101 = this.f26717b;     // Catch: Throwable -> L11
        if (r101 == null) goto L17;
        r101.getClass();     // Catch: Throwable -> L11
        r101.d(1005, r100, 0);     // Catch: Throwable -> L8
    L18:
        return;
    L8:
        th = move-exception;
        c4.g(th, "ALManager", "unRegisterLocationListener");     // Catch: Throwable -> L11
        return;
    L17:
        return;
    L11:
        th = move-exception;
        c4.g(th, "AMClt", "unRL");
    }

    public static void updatePrivacyAgree(Context r100, boolean r101) {
        e5 r102 = c4.k();
        u.b r103 = u.f380160a;
        if (r101 == false) goto L5;
        u.a r104 = u.a.f380175c;
    L7:
        monitor-enter(u.class);
        if (r100 == null) goto L21;
        if (r102 == null) goto L21;
    L18:
        th = move-exception;
        throw th;
    L12:
        if (u.f380171l == true) goto L15;
        u.g(r100);     // Catch: Throwable -> L18
        u.f380171l = true;     // Catch: Throwable -> L18
    L15:
        if (r104 == u.f380165f) goto L21;
        u.f380165f = r104;     // Catch: Throwable -> L18
        u.f380167h = r102.a();     // Catch: Throwable -> L18
        u.f380168i = r102.f517264f;     // Catch: Throwable -> L18
        long r105 = System.currentTimeMillis();     // Catch: Throwable -> L18
        u.f380166g = r105;     // Catch: Throwable -> L18
        u.f380169j = r105;     // Catch: Throwable -> L18
        u.f(r100);     // Catch: Throwable -> L18
    L21:
        monitor-exit(u.class);
        return;
    L5:
        r104 = u.a.f380174b;
        goto L7
    }

    public static void updatePrivacyShow(Context r100, boolean r101, boolean r102) {
        e5 r103 = c4.k();
        u.b r104 = u.f380160a;
        if (r102 == false) goto L5;
        u.d r105 = u.d.f380196c;
    L6:
        if (r101 == false) goto L8;
        u.b r106 = u.b.f380180c;
    L10:
        monitor-enter(u.class);
        if (r100 == null) goto L30;
        if (r103 == null) goto L30;
    L27:
        th = move-exception;
        throw th;
    L15:
        if (u.f380171l == true) goto L17;
        u.g(r100);     // Catch: Throwable -> L27
        u.f380171l = true;     // Catch: Throwable -> L27
    L17:
        Boolean r107 = Boolean.FALSE;     // Catch: Throwable -> L27
        if (r105 == u.f380161b) goto L21;
        r107 = Boolean.TRUE;     // Catch: Throwable -> L27
        u.f380161b = r105;     // Catch: Throwable -> L27
    L21:
        if (r106 == u.f380160a) goto L24;
        r107 = Boolean.TRUE;     // Catch: Throwable -> L27
        u.f380160a = r106;     // Catch: Throwable -> L27
    L24:
        if (r107.booleanValue() == false) goto L30;
        u.f380162c = r103.a();     // Catch: Throwable -> L27
        u.f380163d = r103.f517264f;     // Catch: Throwable -> L27
        long r108 = System.currentTimeMillis();     // Catch: Throwable -> L27
        u.f380164e = r108;     // Catch: Throwable -> L27
        u.f380169j = r108;     // Catch: Throwable -> L27
        u.f(r100);     // Catch: Throwable -> L27
    L30:
        monitor-exit(u.class);
        return;
    L8:
        r106 = u.b.f380179b;
        goto L10
    L5:
        r105 = u.d.f380195b;
        goto L6
    }
}

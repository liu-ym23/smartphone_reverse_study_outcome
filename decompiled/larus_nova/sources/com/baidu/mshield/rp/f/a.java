package com.baidu.mshield.rp.f;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.mshield.b.f.e;
import com.baidu.mshield.utility.b;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f32415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HandlerC0654a f32416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.baidu.mshield.sharedpreferences.a f32417c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Context f32418d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.baidu.mshield.rp.e.a.a f32419e;

    /* JADX INFO: renamed from: com.baidu.mshield.rp.f.a$a, reason: collision with other inner class name */
    public class HandlerC0654a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f32420a;

        @Override // android.os.Handler
        public void handleMessage(Message r100) {
        L37:
            th = move-exception;
            com.baidu.mshield.utility.a.a(th);
            return;
        L4:
            switch(r100.what) {
                case 0: goto L35;
                case 1: goto L34;
                case 2: goto L33;
                case 3: goto L29;
                case 4: goto L25;
                case 5: goto L24;
                case 6: goto L23;
                case 7: goto L22;
                case 8: goto L21;
                case 9: goto L20;
                case 10: goto L9;
                case 11: goto L6;
                default: goto L41;
            };     // Catch: Throwable -> L37
        L6:
            String r101 = String.valueOf(r100.obj);     // Catch: Throwable -> L37
            if (a.e(this.f32420a).a(new JSONArray().put(com.baidu.mshield.utility.a.a(a.d(this.f32420a), new JSONObject(r101))).toString(), a.a(this.f32420a, new JSONObject(r101)), "3") == true) goto L42;
            com.baidu.mshield.utility.a.b(a.d(this.f32420a), r101);     // Catch: Throwable -> L37
            return;
        L42:
            return;
        L9:
            int r102 = com.baidu.mshield.utility.a.d(a.d(this.f32420a));     // Catch: Throwable -> L37
            if (2 != r102) goto L18;
            com.baidu.mshield.b.c.a.b("sj-trigger report wifi ");     // Catch: Throwable -> L37
            if (com.baidu.mshield.rp.c.a.a(a.d(this.f32420a)).b() < com.baidu.mshield.sharedpreferences.a.a(a.d(this.f32420a)).g()) goto L15;
            com.baidu.mshield.b.c.a.b("sj-trigger reportrc condi");     // Catch: Throwable -> L37
            a.a(this.f32420a, 0, r102);     // Catch: Throwable -> L37
            return;
        L15:
            List<com.baidu.mshield.rp.d.a> r103 = com.baidu.mshield.rp.c.a.a(a.d(this.f32420a)).a(true, r102);     // Catch: Throwable -> L37
            com.baidu.mshield.b.c.a.b("sj-trigger report Dela " + r103.size());     // Catch: Throwable -> L37
            if (r103.size() <= 0) goto L44;
            com.baidu.mshield.b.c.a.b("sj-trigger reportde condi");     // Catch: Throwable -> L37
            a.a(this.f32420a, 0, r102);     // Catch: Throwable -> L37
            return;
        L44:
            return;
        L18:
            if (1 != r102) goto L46;
            com.baidu.mshield.b.c.a.b("sj-trigger reportde re");     // Catch: Throwable -> L37
            a.a(this.f32420a, 4, r102);     // Catch: Throwable -> L37
            return;
        L46:
            return;
        L20:
            a.a(this.f32420a, 0, 2);     // Catch: Throwable -> L37
            return;
        L21:
            a r104 = this.f32420a;     // Catch: Throwable -> L37
            a.a(r104, 3, com.baidu.mshield.utility.a.d(a.d(r104)));     // Catch: Throwable -> L37
            return;
        L22:
            a.c(this.f32420a);     // Catch: Throwable -> L37
            a r105 = this.f32420a;     // Catch: Throwable -> L37
            a.a(r105, 1, com.baidu.mshield.utility.a.d(a.d(r105)));     // Catch: Throwable -> L37
            return;
        L23:
            a r106 = this.f32420a;     // Catch: Throwable -> L37
            a.a(r106, 1, com.baidu.mshield.utility.a.d(a.d(r106)));     // Catch: Throwable -> L37
            return;
        L24:
            a.a(this.f32420a);     // Catch: Throwable -> L37
            a.b(this.f32420a);     // Catch: Throwable -> L37
            Message r107 = new Message();     // Catch: Throwable -> L37
            r107.what = 10;     // Catch: Throwable -> L37
            sendMessage(r107);     // Catch: Throwable -> L37
            return;
        L25:
            String r108 = String.valueOf(r100.obj);     // Catch: Throwable -> L37
            if (TextUtils.isEmpty(r108) == false) goto L28;
            return;
        L28:
            com.baidu.mshield.rp.c.a.a(a.d(this.f32420a)).a(e.a(r108));     // Catch: Throwable -> L37
            return;
        L29:
            com.baidu.mshield.rp.b.a r109 = (com.baidu.mshield.rp.b.a) r100.obj;     // Catch: Throwable -> L37
            if (r109 != null) goto L32;
            return;
        L32:
            a.a(this.f32420a, r109);     // Catch: Throwable -> L37
            return;
        L33:
            com.baidu.mshield.b.c.a.b("sj-trigger reportACTION_REPORT_DATA");     // Catch: Throwable -> L37
            a.a(this.f32420a);     // Catch: Throwable -> L37
            a.c(this.f32420a);     // Catch: Throwable -> L37
            a.a(this.f32420a, 0, com.baidu.mshield.utility.a.d(a.d(this.f32420a)));     // Catch: Throwable -> L37
            return;
        L34:
            com.baidu.mshield.rp.c.a.a(a.d(this.f32420a)).a((com.baidu.mshield.rp.d.a) r100.obj);     // Catch: Throwable -> L37
            com.baidu.mshield.b.c.a.b("sj-trigger report f ACTION_REPORT_RECORD");     // Catch: Throwable -> L37
            Message r110 = new Message();     // Catch: Throwable -> L37
            r110.what = 10;     // Catch: Throwable -> L37
            sendMessage(r110);     // Catch: Throwable -> L37
            return;
        L35:
            a.c(this.f32420a);     // Catch: Throwable -> L37
            return;
        }

        public HandlerC0654a(a r100, Looper r101) {
            this.f32420a = r100;
            super(r101);
        }
    }

    public final boolean b() {
        com.baidu.mshield.b.c.a.b("checkReportFail,sFailTime=" + f32415a);
        if (f32415a > 0) goto L5;
    L9:
        com.baidu.mshield.b.c.a.b("checkReportFail:true");
        return true;
    L5:
        if ((System.currentTimeMillis() - f32415a) >= 300000) goto L8;
        com.baidu.mshield.b.c.a.b("checkReportFail:false");
        return false;
    L8:
        f32415a = 0;
        goto L9
    }

    public final void c() {
        this.f32419e.a();
        this.f32417c.a(System.currentTimeMillis());
    }

    public final void d() {
        com.baidu.mshield.sharedpreferences.a r100 = com.baidu.mshield.sharedpreferences.a.a(this.f32418d);     // Catch: Throwable -> L8
        int r101 = r100.J();     // Catch: Throwable -> L8
        com.baidu.mshield.b.c.a.b(" 2" + Integer.toString(r101));     // Catch: Throwable -> L8
        long r102 = System.currentTimeMillis() - r100.G();     // Catch: Throwable -> L8
        long r103 = (long) (r101 * BaseConstants.Time.HOUR);     // Catch: Throwable -> L8
        if (r102 < r103) goto L6;
        b.a(this.f32418d).d();     // Catch: Throwable -> L8
        com.baidu.mshield.utility.a.a(this.f32418d, r103);     // Catch: Throwable -> L8
        r100.b(System.currentTimeMillis());     // Catch: Throwable -> L8
    L11:
        return;
    L6:
        com.baidu.mshield.utility.a.a(this.f32418d, r103 - r102);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
    }

    public void e() {
        Message r100 = new Message();
        r100.what = 7;
        a(r100);
    }

    public final void f() {
        List<com.baidu.mshield.rp.b.a> r100 = this.f32417c.p();     // Catch: Throwable -> L10
        if (r100 != null) goto L5;
        return;
    L5:
        Iterator<com.baidu.mshield.rp.b.a> r101 = r100.iterator();     // Catch: Throwable -> L10
    L7:
        if (r101.hasNext() == false) goto L17;
        a(r101.next());     // Catch: Throwable -> L10
        goto L7
    L17:
        return;
    L10:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
    }

    public final void a() {
        if ((System.currentTimeMillis() - this.f32417c.B()) >= 86400000) goto L5;
        return;
    L5:
        c();
    }

    public a(Context r100) {
        this.f32418d = r100.getApplicationContext();
        this.f32416b = new HandlerC0654a(this, com.baidu.mshield.utility.e.a());
        this.f32417c = com.baidu.mshield.sharedpreferences.a.a(r100);
        this.f32419e = new com.baidu.mshield.rp.e.a.a(this.f32418d);
    }

    public static /* synthetic */ void c(a r100) {
        r100.f();
    }

    public static /* synthetic */ Context d(a r100) {
        return r100.f32418d;
    }

    public static /* synthetic */ com.baidu.mshield.rp.e.a.a e(a r100) {
        return r100.f32419e;
    }

    public final void a(com.baidu.mshield.rp.b.a r100) {
        String r101 = com.baidu.mshield.utility.a.a();     // Catch: Throwable -> L17
        if ("4.2.9".equals(this.f32417c.C()) == false) goto L10;
        com.baidu.mshield.b.c.a.b("same version=4.2.9");     // Catch: Throwable -> L17
        if (this.f32417c.d(r100.f32395d).equals(r101) == false) goto L9;
        com.baidu.mshield.b.c.a.b("same version has reported!");     // Catch: Throwable -> L17
        return;
    L9:
        com.baidu.mshield.b.c.a.b("same version new report");     // Catch: Throwable -> L17
    L11:
        String r102 = this.f32417c.b(r100.f32395d);     // Catch: Throwable -> L17
        com.baidu.mshield.rp.d.a r103 = new com.baidu.mshield.rp.d.a();     // Catch: Throwable -> L17
        r103.f32402b = r100.f32395d;     // Catch: Throwable -> L17
        r103.f32407g = 0;     // Catch: Throwable -> L17
        r103.f32403c = 2;     // Catch: Throwable -> L17
        r103.f32405e = System.currentTimeMillis();     // Catch: Throwable -> L17
        r103.f32406f = 1;     // Catch: Throwable -> L17
        r103.f32409i = 5;     // Catch: Throwable -> L17
        r103.f32404d = com.baidu.mshield.utility.a.a(this.f32418d, r100, r102, true).toString();     // Catch: Throwable -> L17
        com.baidu.mshield.rp.c.a.a(this.f32418d).a(r103);     // Catch: Throwable -> L17
        String r104 = e.a(com.baidu.mshield.utility.a.b(this.f32418d).toString());     // Catch: Throwable -> L17
        if (com.baidu.mshield.rp.c.a.a(this.f32418d).b(r104) == true) goto L14;
    L15:
        this.f32417c.c(r100.f32395d, r101);     // Catch: Throwable -> L17
        return;
    L14:
        r103.f32402b = "1067001";     // Catch: Throwable -> L17
        r103.f32409i = 0;     // Catch: Throwable -> L17
        Context r105 = this.f32418d;     // Catch: Throwable -> L17
        r103.f32404d = com.baidu.mshield.utility.a.a(r105, r100.f32392a, r100.f32394c, "1067001", com.baidu.mshield.utility.a.b(r105).toString()).toString();     // Catch: Throwable -> L17
        com.baidu.mshield.rp.c.a.a(this.f32418d).a(r103);     // Catch: Throwable -> L17
        com.baidu.mshield.rp.c.a.a(this.f32418d).a(r104);     // Catch: Throwable -> L17
        goto L15
    L10:
        com.baidu.mshield.b.c.a.b("new version set=4.2.9");     // Catch: Throwable -> L17
        this.f32417c.n("4.2.9");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
    }

    public final void b(com.baidu.mshield.rp.b.a r100) {
        String r101 = this.f32417c.b(r100.f32396e);     // Catch: Throwable -> L7
        com.baidu.mshield.rp.d.a r102 = new com.baidu.mshield.rp.d.a();     // Catch: Throwable -> L7
        r102.f32402b = r100.f32396e;     // Catch: Throwable -> L7
        r102.f32407g = 0;     // Catch: Throwable -> L7
        r102.f32403c = 1;     // Catch: Throwable -> L7
        r102.f32405e = System.currentTimeMillis();     // Catch: Throwable -> L7
        r102.f32406f = 1;     // Catch: Throwable -> L7
        r102.f32404d = com.baidu.mshield.utility.a.a(this.f32418d, r100, r101, false).toString();     // Catch: Throwable -> L7
        com.baidu.mshield.rp.c.a.a(this.f32418d).a(r102);     // Catch: Throwable -> L7
        this.f32417c.a(r100.f32396e, true);     // Catch: Throwable -> L7
        String r103 = e.a(com.baidu.mshield.utility.a.b(this.f32418d).toString());     // Catch: Throwable -> L7
        if (com.baidu.mshield.rp.c.a.a(this.f32418d).b(r103) == true) goto L5;
        return;
    L5:
        r102.f32402b = "1067001";     // Catch: Throwable -> L7
        Context r104 = this.f32418d;     // Catch: Throwable -> L7
        r102.f32404d = com.baidu.mshield.utility.a.a(r104, r100.f32392a, r100.f32394c, "1067001", com.baidu.mshield.utility.a.b(r104).toString()).toString();     // Catch: Throwable -> L7
        com.baidu.mshield.rp.c.a.a(this.f32418d).a(r102);     // Catch: Throwable -> L7
        com.baidu.mshield.rp.c.a.a(this.f32418d).a(r103);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
    }

    public static /* synthetic */ void b(a r100) {
        r100.d();
    }

    public final String a(JSONObject r100) {
        if (r100 != null) goto L16;
        return null;
    L16:
        JSONObject r101 = r100.getJSONObject("Common_section");     // Catch: Throwable -> L13
        if (r101 != null) goto L8;
    L12:
        return null;
    L8:
        if (r101.has("12") == false) goto L12;
        return r101.optString("12", "");
    L13:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
        return null;
    }

    public void a(boolean r100) {
        Message r101 = new Message();
        r101.what = 5;
        a(r101);
    }

    public void a(Message r100) {
        this.f32416b.sendMessage(r100);
    }

    public static /* synthetic */ void a(a r100) {
        r100.a();
    }

    public final List<com.baidu.mshield.rp.d.a> a(int r100, int r101) {
        if (r100 == 0) goto L6;
        return null;
    L6:
        if (r101 == 2) goto L9;
        return null;
    L9:
        return com.baidu.mshield.rp.c.a.a(this.f32418d).b(r101);
    }

    public final void b(int r110, int r210) {
        if (r210 != 0) goto L7;
        com.baidu.mshield.b.c.a.b("sj-trigger EVENT_NETWORK_NONE ");     // Catch: Throwable -> L50
        return;
    L7:
        if (r110 != 1) goto L11;
        List<com.baidu.mshield.rp.d.a> r100 = com.baidu.mshield.rp.c.a.a(this.f32418d).c();     // Catch: Throwable -> L50
        if (1 != r210) goto L17;
        com.baidu.mshield.b.c.a.b("sj-trigger report 3g " + r100.size());     // Catch: Throwable -> L50
    L17:
        if (r100 != null) goto L19;
        return;
    L19:
        if (r100.size() <= 0) goto L55;
        long r111 = this.f32417c.d();     // Catch: Throwable -> L50
        long r112 = System.currentTimeMillis();     // Catch: Throwable -> L50
        long r113 = this.f32417c.c();     // Catch: Throwable -> L50
        int r101 = this.f32417c.D();     // Catch: Throwable -> L50
        if (r113 != 0) goto L24;
        this.f32417c.c(r112);     // Catch: Throwable -> L50
        r113 = r112;
    L24:
        com.baidu.mshield.b.c.a.b("begintime : " + r112);     // Catch: Throwable -> L50
        com.baidu.mshield.b.c.a.b("last rp len : " + r111);     // Catch: Throwable -> L50
        if ((r112 - r113) < 86400000) goto L27;
        this.f32417c.d(0);     // Catch: Throwable -> L50
        this.f32417c.c(r112);     // Catch: Throwable -> L50
        if (r110 != 3) goto L39;
        this.f32417c.g(0);     // Catch: Throwable -> L50
    L39:
        a(r100, r210, r111);     // Catch: Throwable -> L50
        List<com.baidu.mshield.rp.d.a> r102 = a(r110, r210);     // Catch: Throwable -> L50
    L40:
        if (r102 == null) goto L57;
        if (r102.size() == 0) goto L58;
        a(r102, r210, r111);     // Catch: Throwable -> L50
        if (b() == false) goto L45;
        r102 = a(r110, r210);     // Catch: Throwable -> L50
        goto L40
    L45:
        com.baidu.mshield.b.c.a.b("324 checkReportFail");     // Catch: Throwable -> L50
        return;
    L58:
        return;
    L57:
        return;
    L27:
        if (r110 != 3) goto L33;
        int r103 = this.f32417c.E();     // Catch: Throwable -> L50
        if (r103 < 5) goto L31;
        return;
    L31:
        this.f32417c.g(r103 + 1);     // Catch: Throwable -> L50
    L33:
        if (r111 <= (r101 * 1048576)) goto L39;
        com.baidu.mshield.b.c.a.b("rp over limit : maxday :  : " + r111);     // Catch: Throwable -> L50
        return;
    L55:
        return;
    L11:
        if (r110 != 3) goto L14;
        r100 = com.baidu.mshield.rp.c.a.a(this.f32418d).a(false, r210);     // Catch: Throwable -> L50
        goto L17
    L14:
        if (r110 != 4) goto L16;
        List<com.baidu.mshield.rp.d.a> r104 = com.baidu.mshield.rp.c.a.a(this.f32418d).a(true, r210);     // Catch: Throwable -> L50
        com.baidu.mshield.b.c.a.b("sj-trigger report 3g to report " + r104.size());     // Catch: Throwable -> L50
        r100 = r104;
        goto L17
    L16:
        r100 = com.baidu.mshield.rp.c.a.a(this.f32418d).b(r210);     // Catch: Throwable -> L50
        goto L17
    }

    public static /* synthetic */ String a(a r100, JSONObject r101) {
        return r100.a(r101);
    }

    public static /* synthetic */ void a(a r100, com.baidu.mshield.rp.b.a r101) {
        r100.b(r101);
    }

    public final void a(List<com.baidu.mshield.rp.d.a> r110, int r111, long r112) {
        int r100 = this.f32417c.H();     // Catch: Throwable -> L61
        ArrayList r101 = new ArrayList();     // Catch: Throwable -> L61
        ArrayList r102 = new ArrayList();     // Catch: Throwable -> L61
        Iterator<com.baidu.mshield.rp.d.a> r113 = r110.iterator();     // Catch: Throwable -> L61
        int r103 = 0;
        int r104 = 0;
    L4:
        if (r113.hasNext() == false) goto L17;
        com.baidu.mshield.rp.d.a r105 = r113.next();     // Catch: Throwable -> L61
    L7:
        String r106 = com.baidu.mshield.utility.a.a(this.f32418d, new JSONObject(r105.f32404d)).toString();     // Catch: Throwable -> L61
        JSONObject r107 = new JSONObject(r106);     // Catch: Throwable -> L13
    L9:
        int r108 = r106.length() + r104;     // Catch: Throwable -> L61
        if (r108 >= (1048576 * r100)) goto L11;
        r101.add(Integer.valueOf(r105.f32401a));     // Catch: Throwable -> L61
        r102.add(new com.baidu.mshield.rp.d.b(r107, r105.f32410j, r105.f32401a));     // Catch: Throwable -> L61
        r104 = r108;
        goto L4
    L11:
        com.baidu.mshield.b.c.a.b("rp once over limit : maxOnece : " + r100 + " : " + r108);     // Catch: Throwable -> L61
    L13:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);     // Catch: Throwable -> L61
    L15:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);     // Catch: Throwable -> L61
    L17:
        HashMap r114 = new HashMap();     // Catch: Throwable -> L61
        HashMap r109 = new HashMap();     // Catch: Throwable -> L61
        JSONArray r115 = new JSONArray();     // Catch: Throwable -> L61
        ArrayList r116 = new ArrayList();     // Catch: Throwable -> L61
    L19:
        if (r103 >= r102.size()) goto L39;
        com.baidu.mshield.rp.d.b r117 = (com.baidu.mshield.rp.d.b) r102.get(r103);     // Catch: Throwable -> L61
        if (r117 == null) goto L37;
        String r118 = r117.c();     // Catch: Throwable -> L61
        if (TextUtils.isEmpty(r118) == false) goto L27;
        r115.put(r117.b());     // Catch: Throwable -> L61
        r116.add(Integer.valueOf(r117.a()));     // Catch: Throwable -> L61
        goto L37
    L27:
        if (r114.containsKey(r118) == false) goto L32;
        JSONArray r119 = (JSONArray) r114.get(r118);     // Catch: Throwable -> L61
        if (r119 != null) goto L31;
        r119 = new JSONArray();     // Catch: Throwable -> L61
    L31:
        r119.put(r117.b());     // Catch: Throwable -> L61
        r114.put(r118, r119);     // Catch: Throwable -> L61
    L33:
        ArrayList r120 = (ArrayList) r109.get(r118);     // Catch: Throwable -> L61
        if (r120 != null) goto L36;
        r120 = new ArrayList();     // Catch: Throwable -> L61
    L36:
        r120.add(Integer.valueOf(r117.a()));     // Catch: Throwable -> L61
        r109.put(r118, r120);     // Catch: Throwable -> L61
        goto L37
    L32:
        JSONArray r121 = new JSONArray();     // Catch: Throwable -> L61
        r121.put(r117.b());     // Catch: Throwable -> L61
        r114.put(r118, r121);     // Catch: Throwable -> L61
    L37:
        r103 = r103 + 1;     // Catch: Throwable -> L61
        goto L19
    L39:
        if (r115.length() <= 0) goto L45;
        if (this.f32419e.a(r115.toString(), null, "1") == false) goto L43;
        com.baidu.mshield.rp.c.a.a(this.f32418d).a(r116);     // Catch: Throwable -> L61
        goto L45
    L43:
        f32415a = System.currentTimeMillis();     // Catch: Throwable -> L61
        com.baidu.mshield.b.c.a.b("427 report fail,sFailTime = " + f32415a);     // Catch: Throwable -> L61
    L45:
        if (r114.size() <= 0) goto L57;
        Iterator r122 = r114.keySet().iterator();     // Catch: Throwable -> L61
    L48:
        if (r122.hasNext() == false) goto L57;
        String r123 = (String) r122.next();     // Catch: Throwable -> L61
        JSONArray r124 = (JSONArray) r114.get(r123);     // Catch: Throwable -> L61
        if (r124 == null) goto L48;
        if (r124.length() <= 0) goto L48;
        if (this.f32419e.a(r124.toString(), r123, "2") == true) goto L55;
        f32415a = System.currentTimeMillis();     // Catch: Throwable -> L61
        com.baidu.mshield.b.c.a.b("441 report fail,sFailTime = " + f32415a);     // Catch: Throwable -> L61
        goto L48
    L55:
        com.baidu.mshield.rp.c.a.a(this.f32418d).a((List) r109.get(r123));     // Catch: Throwable -> L61
    L57:
        com.baidu.mshield.rp.c.a.a(this.f32418d).a();     // Catch: Throwable -> L61
        if (2 == r111) goto L92;
        this.f32417c.d(((long) r104) + r112);     // Catch: Throwable -> L61
        return;
    L92:
        return;
    L61:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
    }

    public static /* synthetic */ void a(a r100, int r101, int r102) {
        r100.b(r101, r102);
    }
}

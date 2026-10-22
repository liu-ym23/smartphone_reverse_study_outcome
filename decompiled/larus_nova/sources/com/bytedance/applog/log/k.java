package com.bytedance.applog.log;

import com.baidu.mapapi.http.HttpClient;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.miniapp.alarm.AlarmSessionType;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class k {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f192468i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f192469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f192470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f192471c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f192472d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<String> f192473e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f192474f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f192475g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Throwable f192476h;

    /* JADX INFO: loaded from: classes14.dex */
    public static class a extends ThreadLocal<SimpleDateFormat> {
        @Override // java.lang.ThreadLocal
        public final SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }

        public a() {
        }
    }

    static {
        f192468i = new a();
    }

    public final String a() {
        int r100 = this.f192471c;
        if (r100 != 0) goto L5;
        return "VERBOSE";
    L5:
        if (r100 != 1) goto L7;
        return "DEBUG";
    L7:
        if (r100 != 2) goto L9;
        return "INFO";
    L9:
        if (r100 != 3) goto L11;
        return "WARN";
    L11:
        if (r100 != 4) goto L13;
        return "ERROR";
    L13:
        if (r100 == 5) goto L16;
        return "";
    L16:
        return "ASSERT";
    }

    public final String b() {
        String r100 = this.f192474f;
        if (r100 != null) goto L5;
    L8:
        String r101 = this.f192474f;
        if (r101 != null) goto L13;
        return "";
    L13:
        return r101.toString();
    L5:
        if (r100.isEmpty() == true) goto L8;
        return this.f192474f;
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("[");
        if (this.f192475g <= 0) goto L5;
        String r101 = f192468i.get().format(new Date(this.f192475g));
    L6:
        r100.append(r101);
        r100.append("][");
        r100.append(a());
        r100.append("][");
        String r102 = this.f192469a;
        String r103 = "";
        if (r102 == null) goto L9;
        String r104 = r102.toString();
    L10:
        r100.append(r104);
        r100.append("][");
        String r105 = this.f192470b;
        if (r105 == null) goto L13;
        String r106 = r105.toString();
    L14:
        r100.append(r106);
        r100.append("][");
        switch(this.f192472d) {
            case 1: goto L31;
            case 2: goto L30;
            case 3: goto L29;
            case 4: goto L28;
            case 5: goto L27;
            case 6: goto L26;
            case 7: goto L25;
            case 8: goto L24;
            case 9: goto L23;
            case 10: goto L22;
            case 11: goto L21;
            case 12: goto L20;
            case 13: goto L19;
            case 14: goto L18;
            case 15: goto L17;
            default: goto L16;
        };
    L16:
        String r107 = "DEFAULT";
    L32:
        r100.append(r107);
        r100.append("][");
        List<String> r108 = this.f192473e;
        if (r108 != null) goto L35;
    L44:
        r100.append(r103);
        r100.append("] ");
        r100.append(b());
        String r109 = r100.toString();
        if (this.f192476h == null) goto L59;
        StringBuilder r110 = new StringBuilder();
        r110.append(r109);
        r110.append("\nstacktrace: ");
        Throwable r111 = this.f192476h;
        StringBuilder r112 = new StringBuilder();
    L47:
        if (r111 == null) goto L52;
        r112.append(r111.toString());
        StackTraceElement[] r113 = r111.getStackTrace();
        int r114 = r113.length;
        int r115 = 0;
    L49:
        if (r115 >= r114) goto L51;
        StackTraceElement r116 = r113[r115];
        r112.append("\n\tat ");
        r112.append(r116);
        r115 = r115 + 1;
        goto L49
    L51:
        r111 = r111.getCause();
        goto L47
    L52:
        r110.append(r112.toString());
        return r110.toString();
    L59:
        return r109;
    L35:
        if (r108.size() <= 0) goto L44;
        StringBuilder r117 = new StringBuilder();
        int r118 = 0;
    L38:
        if (r118 >= this.f192473e.size()) goto L43;
        r117.append((String) ListProtector.get(this.f192473e, r118));
        if (r118 >= (this.f192473e.size() - 1)) goto L42;
        r117.append(",");
    L42:
        r118 = r118 + 1;
        goto L38
    L43:
        r103 = r117.toString();
        goto L44
    L17:
        r107 = "ONE_ID";
        goto L32
    L18:
        r107 = "COMPRESS";
        goto L32
    L19:
        r107 = "EVENT_PRIORITY";
        goto L32
    L20:
        r107 = "EVENT_SAMPLING";
        goto L32
    L21:
        r107 = "REQUEST";
        goto L32
    L22:
        r107 = "PICKER";
        goto L32
    L23:
        r107 = "USER_PROFILE";
        goto L32
    L24:
        r107 = "MONITOR";
        goto L32
    L25:
        r107 = "VIEW_EXPOSURE";
        goto L32
    L26:
        r107 = "EVENT_VERIFY";
        goto L32
    L27:
        r107 = "DATABASE";
        goto L32
    L28:
        r107 = AlarmSessionType.EVENT;
        goto L32
    L29:
        r107 = "ALINK";
        goto L32
    L30:
        r107 = "ABTEST";
        goto L32
    L31:
        r107 = "DEVICE_REGISTER";
        goto L32
    L13:
        r106 = "";
        goto L14
    L9:
        r104 = "";
        goto L10
    L5:
        r101 = HttpClient.ENDFLAG;
        goto L6
    }

    public k() {
        this.f192471c = 1;
        this.f192472d = 0;
        this.f192475g = System.currentTimeMillis();
    }
}

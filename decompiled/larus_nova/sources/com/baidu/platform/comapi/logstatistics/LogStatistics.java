package com.baidu.platform.comapi.logstatistics;

import com.baidu.platform.comapi.JNIInitializer;
import com.baidu.platform.comapi.util.JsonBuilder;
import com.baidu.platform.comapi.util.SysOSUtil;
import com.baidu.platform.comjni.base.logstatistics.NALogStatistics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
public class LogStatistics {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NALogStatistics f32912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ArrayList<c> f32913b;

    public static /* synthetic */ class a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final LogStatistics f32914a = null;

        static {
            f32914a = new LogStatistics(null);
        }

        public static /* synthetic */ LogStatistics a() {
            return f32914a;
        }
    }

    private boolean b() {
        if (this.f32912a != null) goto L7;
        this.f32912a = new NALogStatistics();
        return true;
    L7:
        return true;
    }

    public void a() {
        NALogStatistics r100 = this.f32912a;
        if (r100 == null) goto L6;
        r100.dispose();
        this.f32912a = null;
        return;
    }

    private LogStatistics() {
        this.f32912a = null;
        this.f32913b = new ArrayList();
        b();
    }

    public static LogStatistics getInstance() {
        return b.a();
    }

    public /* synthetic */ LogStatistics(a r100) {
        this();
    }

    public boolean a(com.baidu.platform.comapi.logstatistics.b r100) {
        ArrayList<c> r101 = this.f32913b;
        if (r101 != null) goto L5;
        return false;
    L5:
        if (r101.isEmpty() == true) goto L13;
        Iterator<c> r102 = this.f32913b.iterator();
    L8:
        if (r102.hasNext() == false) goto L14;
        r102.next().a(r100);
        goto L8
    L14:
        return false;
    L13:
        return false;
    }

    public static void onAddLog(int r100, int r101, String r102, String r103) {
        getInstance().a(new com.baidu.platform.comapi.logstatistics.b(r100, r101, r102, r103));
    }

    public void a(int r100, int r101, String r102, Map<String, Object> r103) {
        if (r103 != null) goto L4;
    L13:
        String r104 = null;
    L14:
        a(r100, r101, r102, r104);
        return;
    L4:
        if (r103.size() <= 0) goto L13;
        JsonBuilder r105 = new JsonBuilder();
        r105.object();
        Iterator<String> r106 = r103.keySet().iterator();
    L7:
        if (r106.hasNext() == false) goto L12;
        String r107 = r106.next();
        Object r108 = r103.get(r107);
        if (r108 == null) goto L7;
        r105.key(r107).value(r108);
        goto L7
    L12:
        r105.endObject();
        r104 = r105.getJson();
        goto L14
    }

    public boolean a(int r100, int r101, String r110, String r111) {
        if (this.f32912a != null) goto L5;
        return false;
    L5:
        if (JNIInitializer.isDebug() == false) goto L7;
    L8:
        a(new com.baidu.platform.comapi.logstatistics.b(r100, r101, r110, r111));
    L10:
        return this.f32912a.a(r100, r101, SysOSUtil.getInstance().getNetType(), r110, r111);
    L7:
        if (JNIInitializer.isBaseLineRelease() == false) goto L10;
        goto L8
    }
}

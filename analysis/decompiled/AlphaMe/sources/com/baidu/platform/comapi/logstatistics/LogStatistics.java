package com.baidu.platform.comapi.logstatistics;

import com.baidu.platform.comapi.JNIInitializer;
import com.baidu.platform.comapi.util.JsonBuilder;
import com.baidu.platform.comapi.util.SysOSUtil;
import com.baidu.platform.comjni.base.logstatistics.NALogStatistics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class LogStatistics {

    /* renamed from: a, reason: collision with root package name */
    private NALogStatistics f8773a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<c> f8774b;

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final LogStatistics f8775a = new LogStatistics();
    }

    private boolean b() {
        if (this.f8773a != null) {
            return true;
        }
        this.f8773a = new NALogStatistics();
        return true;
    }

    public static LogStatistics getInstance() {
        return b.f8775a;
    }

    public static void onAddLog(int i4, int i5, String str, String str2) {
        getInstance().a(new com.baidu.platform.comapi.logstatistics.b(i4, i5, str, str2));
    }

    public void a() {
        NALogStatistics nALogStatistics = this.f8773a;
        if (nALogStatistics != null) {
            nALogStatistics.dispose();
            this.f8773a = null;
        }
    }

    private LogStatistics() {
        this.f8773a = null;
        this.f8774b = new ArrayList<>();
        b();
    }

    public void a(int i4, int i5, String str, Map<String, Object> map) {
        String json;
        if (map == null || map.size() <= 0) {
            json = null;
        } else {
            JsonBuilder jsonBuilder = new JsonBuilder();
            jsonBuilder.object();
            for (String str2 : map.keySet()) {
                Object obj = map.get(str2);
                if (obj != null) {
                    jsonBuilder.key(str2).value(obj);
                }
            }
            jsonBuilder.endObject();
            json = jsonBuilder.getJson();
        }
        a(i4, i5, str, json);
    }

    public boolean a(int i4, int i5, String str, String str2) {
        if (this.f8773a == null) {
            return false;
        }
        if (JNIInitializer.isDebug() || JNIInitializer.isBaseLineRelease()) {
            a(new com.baidu.platform.comapi.logstatistics.b(i4, i5, str, str2));
        }
        return this.f8773a.a(i4, i5, SysOSUtil.getInstance().getNetType(), str, str2);
    }

    public boolean a(com.baidu.platform.comapi.logstatistics.b bVar) {
        ArrayList<c> arrayList = this.f8774b;
        if (arrayList == null || arrayList.isEmpty()) {
            return false;
        }
        Iterator<c> it = this.f8774b.iterator();
        while (it.hasNext()) {
            it.next().a(bVar);
        }
        return false;
    }
}

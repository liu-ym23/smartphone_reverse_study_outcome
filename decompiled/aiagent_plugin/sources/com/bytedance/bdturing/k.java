package com.bytedance.bdturing;

import com.bytedance.apm.battery.dao.DBHelper;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: UserMotionManager.java */
/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ReentrantLock f6591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static List<JSONObject> f6592b;

    static {
        f6591a = new ReentrantLock();
        f6592b = new LinkedList();
    }

    public static void a(long r2, float r4, float r5, int r6, float r7, float r8) {
        JSONObject r0 = new JSONObject();
        r0.put(DBHelper.COL_TIME, r2);     // Catch: JSONException -> L11
        r0.put(DBDefinition.FORCE, r4);     // Catch: JSONException -> L11
        r0.put("majorRadius", r5);     // Catch: JSONException -> L11
        r0.put("phase", r6);     // Catch: JSONException -> L11
        r0.put("x", r7);     // Catch: JSONException -> L11
        r0.put("y", r8);     // Catch: JSONException -> L11
        f6591a.lockInterruptibly();     // Catch: Throwable -> L6 InterruptedException -> L14
        f6592b.add(r0);     // Catch: Throwable -> L6 InterruptedException -> L14
    L6:
        th = move-exception;
        f6591a.unlock();
        throw th;
    L9:
        f6591a.unlock();
        return;
    L11:
        e = move-exception;
        g.a(e);
    }

    public static void a() {
        f6591a.lockInterruptibly();     // Catch: Throwable -> L4 Exception -> L9
        f6592b.clear();     // Catch: Throwable -> L4 Exception -> L9
    L4:
        th = move-exception;
        f6591a.unlock();
        throw th;
    L7:
        f6591a.unlock();
    }

    public static void a(com.bytedance.bdturing.b.c r4) {
        JSONObject r1 = new JSONObject();
        r1.put("os_name", "android");     // Catch: Throwable -> L5 Exception -> L11
        f6591a.lockInterruptibly();     // Catch: Throwable -> L5 Exception -> L11
        r1.put("touch", new JSONArray(f6592b));     // Catch: Throwable -> L5 Exception -> L11
        g.g("onTouch", "responseGetTouchToJs motion list size " + f6592b.size());     // Catch: Throwable -> L5 Exception -> L11
        f6592b.clear();     // Catch: Throwable -> L5 Exception -> L11
        g.g("onTouch", "responseGetTouchToJs end motion list size " + f6592b.size());     // Catch: Throwable -> L5 Exception -> L11
    L5:
        th = move-exception;
        f6591a.unlock();
        throw th;
    L8:
        f6591a.unlock();
        r4.a(1, r1);     // Catch: Exception -> L12
        return;
    }
}

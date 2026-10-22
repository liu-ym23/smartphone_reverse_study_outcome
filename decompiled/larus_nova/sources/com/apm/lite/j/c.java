package com.apm.lite.j;

import com.apm.lite.CrashType;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ConcurrentLinkedQueue<c> f29952a;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f29953a = null;

        static {
            int[] r100 = new int[CrashType.values().length];
            f29953a = r100;
            r100[CrashType.JAVA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f29953a[CrashType.LAUNCH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f29953a[CrashType.NATIVE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static {
        f29952a = new ConcurrentLinkedQueue();
    }

    public c() {
    }

    public abstract void a();

    public static void b(CrashType r100, JSONObject r101) {
        ConcurrentLinkedQueue<c> r102 = f29952a;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.isEmpty() == false) goto L8;
        return;
    L8:
        if (r100 != CrashType.LAUNCH) goto L10;
        ((JSONArray) r101.opt("data")).optJSONObject(0);
    L10:
        r101.optJSONObject("header");
    L12:
        if (f29952a.isEmpty() == true) goto L16;
        c r103 = f29952a.poll();
        if (r103 == null) goto L12;
        r103.a();
        goto L12
    L16:
        f29952a = null;
    }
}

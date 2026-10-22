package com.bytedance.crash.dumper;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Debug;
import com.bytedance.crash.o.v;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class MemoryInfo {

    static class AppMemoryInfo implements Serializable {
        private static final String FILE_NAME = "app_memory.inf";
        private static final long serialVersionUID = 1;
        private int mLargeMemoryClass;
        private int mMemoryClass;
        private final long mNativeHeapAllocSize;
        private final long mNativeHeapFreeSize;
        private final long mNativeHeapSize;
        private final long mRuntimeFree;
        private final long mRuntimeMax;
        private final long mRuntimeTotal;

        public static void dump(File r2, ActivityManager r3) {
            AppMemoryInfo r0 = new AppMemoryInfo(r3);
            v.a(new File(r2, FILE_NAME), r0);
        }

        public static AppMemoryInfo load(File r2) {
            return (AppMemoryInfo) ZeusTransformUtils.preCheckCast(v.a(new File(r2, FILE_NAME)), AppMemoryInfo.class, "com.obric.aiagent.plugin");
        }

        AppMemoryInfo(ActivityManager r4) {
            this.mNativeHeapSize = Debug.getNativeHeapSize();
            this.mNativeHeapAllocSize = Debug.getNativeHeapAllocatedSize();
            this.mNativeHeapFreeSize = Debug.getNativeHeapFreeSize();
            Runtime r0 = Runtime.getRuntime();
            this.mRuntimeMax = r0.maxMemory();
            this.mRuntimeFree = r0.freeMemory();
            this.mRuntimeTotal = r0.totalMemory();
            if (r4 == null) goto L6;
            this.mMemoryClass = r4.getMemoryClass();
            this.mLargeMemoryClass = r4.getLargeMemoryClass();
            return;
        }

        void pushTo(JSONObject r5) {
            JSONObject r0 = new JSONObject();
            r0.put("native_heap_size", this.mNativeHeapSize);     // Catch: JSONException -> L5
            r0.put("native_heap_alloc_size", this.mNativeHeapAllocSize);     // Catch: JSONException -> L5
            r0.put("native_heap_free_size", this.mNativeHeapFreeSize);     // Catch: JSONException -> L5
            r0.put("max_memory", this.mRuntimeMax);     // Catch: JSONException -> L5
            r0.put("free_memory", this.mRuntimeFree);     // Catch: JSONException -> L5
            r0.put("total_memory", this.mRuntimeTotal);     // Catch: JSONException -> L5
            r0.put("memory_class", this.mMemoryClass);     // Catch: JSONException -> L5
            r0.put("large_memory_class", this.mLargeMemoryClass);     // Catch: JSONException -> L5
            r5.put("app_memory_info", r0);     // Catch: JSONException -> L5
            return;
        }
    }

    static class DevMemoryInfo implements Serializable {
        private static final String FILE_NAME = "dev_memory.inf";
        private static final long KB = 1024;
        private static final long serialVersionUID = 1;
        private final long mDalvikPrivateDirty;
        private final long mDalvikPss;
        private final long mDalvikSharedDirty;
        private final long mNativePrivateDirty;
        private final long mNativePss;
        private final long mNativeSharedDirty;
        private final long mOtherPrivateDirty;
        private final long mOtherPss;
        private final long mOtherSharedDirty;
        private final long mSummaryGraphics;
        private final long mTotalPrivateClean;
        private final long mTotalPrivateDirty;
        private final long mTotalPss;
        private final long mTotalSharedClean;
        private final long mTotalSharedDirty;
        private final long mTotalSwappablePss;

        public static void dump(File r3) {
            DevMemoryInfo r0 = new DevMemoryInfo();
            v.a(new File(r3, FILE_NAME), r0);
        }

        public static DevMemoryInfo load(File r2) {
            return (DevMemoryInfo) ZeusTransformUtils.preCheckCast(v.a(new File(r2, FILE_NAME)), DevMemoryInfo.class, "com.obric.aiagent.plugin");
        }

        DevMemoryInfo() {
            Debug.MemoryInfo r0 = new Debug.MemoryInfo();
            Debug.getMemoryInfo(r0);
            this.mDalvikPss = ((long) r0.dalvikPss) * 1024;
            this.mDalvikSharedDirty = ((long) r0.dalvikSharedDirty) * 1024;
            this.mDalvikPrivateDirty = ((long) r0.dalvikPrivateDirty) * 1024;
            this.mNativePss = ((long) r0.nativePss) * 1024;
            this.mNativeSharedDirty = ((long) r0.nativeSharedDirty) * 1024;
            this.mNativePrivateDirty = ((long) r0.nativePrivateDirty) * 1024;
            this.mOtherPss = ((long) r0.otherPss) * 1024;
            this.mOtherSharedDirty = ((long) r0.otherSharedDirty) * 1024;
            this.mOtherPrivateDirty = ((long) r0.otherPrivateDirty) * 1024;
            this.mTotalPss = ((long) r0.getTotalPss()) * 1024;
            if (Build.VERSION.SDK_INT < 19) goto L5;
            this.mTotalSharedClean = ((long) r0.getTotalSharedClean()) * 1024;
            this.mTotalPrivateClean = ((long) r0.getTotalPrivateClean()) * 1024;
            this.mTotalSwappablePss = ((long) r0.getTotalSwappablePss()) * 1024;
        L6:
            this.mTotalSharedDirty = ((long) r0.getTotalSharedDirty()) * 1024;
            this.mTotalPrivateDirty = ((long) r0.getTotalPrivateDirty()) * 1024;
            this.mSummaryGraphics = getSummaryGraphics(r0);
            return;
        L5:
            this.mTotalSharedClean = 0;
            this.mTotalPrivateClean = 0;
            this.mTotalSwappablePss = 0;
            goto L6
        }

        private static long getSummaryGraphics(Debug.MemoryInfo r4) {
            if (Build.VERSION.SDK_INT >= 23) goto L10;
            return 0;
        L10:
            return ((long) Integer.parseInt(r4.getMemoryStat("summary.graphics"))) * 1024;
        L12:
            return 0;
        }

        public void pushTo(JSONObject r5) {
            JSONObject r0 = new JSONObject();
            r0.put("dalvikPss", this.mDalvikPss);     // Catch: JSONException -> L5
            r0.put("dalvikSharedDirty", this.mDalvikSharedDirty);     // Catch: JSONException -> L5
            r0.put("dalvikPrivateDirty", this.mDalvikPrivateDirty);     // Catch: JSONException -> L5
            r0.put("nativePss", this.mNativePss);     // Catch: JSONException -> L5
            r0.put("nativeSharedDirty", this.mNativeSharedDirty);     // Catch: JSONException -> L5
            r0.put("nativePrivateDirty", this.mNativePrivateDirty);     // Catch: JSONException -> L5
            r0.put("otherPss", this.mOtherPss);     // Catch: JSONException -> L5
            r0.put("otherSharedDirty", this.mOtherSharedDirty);     // Catch: JSONException -> L5
            r0.put("otherPrivateDirty", this.mOtherPrivateDirty);     // Catch: JSONException -> L5
            r0.put("totalPss", this.mTotalPss);     // Catch: JSONException -> L5
            r0.put("totalPrivateClean", this.mTotalPrivateClean);     // Catch: JSONException -> L5
            r0.put("totalSharedClean", this.mTotalSharedClean);     // Catch: JSONException -> L5
            r0.put("totalSwappablePss", this.mTotalSwappablePss);     // Catch: JSONException -> L5
            r0.put("totalSharedDirty", this.mTotalSharedDirty);     // Catch: JSONException -> L5
            r0.put("totalPrivateDirty", this.mTotalPrivateDirty);     // Catch: JSONException -> L5
            r0.put("summary.graphics", this.mSummaryGraphics);     // Catch: JSONException -> L5
            r5.put("memory_info", r0);     // Catch: JSONException -> L5
            return;
        }
    }

    static class SysMemoryInfo implements Serializable {
        private static final String FILE_NAME = "sys_memory.inf";
        private static final long UNIT_SIZE = 536870912;
        private static final long serialVersionUID = 1;
        private final long mAvailMem;
        private final boolean mLowMemory;
        private final long mThreshold;
        private final long mTotalMem;

        static void dump(File r2, ActivityManager r3) {
            if (r3 == null) goto L5;
            SysMemoryInfo r0 = new SysMemoryInfo(r3);
            v.a(new File(r2, FILE_NAME), r0);
            return;
        }

        static SysMemoryInfo load(File r2) {
            return (SysMemoryInfo) ZeusTransformUtils.preCheckCast(v.a(new File(r2, FILE_NAME)), SysMemoryInfo.class, "com.obric.aiagent.plugin");
        }

        SysMemoryInfo(ActivityManager r4) {
            ActivityManager.MemoryInfo r0 = new ActivityManager.MemoryInfo();
            r4.getMemoryInfo(r0);
            this.mLowMemory = r0.lowMemory;
            this.mThreshold = r0.threshold;
            this.mAvailMem = r0.availMem;
            this.mTotalMem = r0.totalMem;
        }

        void pushTo(JSONObject r7) {
            JSONObject r0 = new JSONObject();
            r0.put("lowMemory", this.mLowMemory);     // Catch: JSONException -> L5
            r0.put("threshold", this.mThreshold);     // Catch: JSONException -> L5
            r0.put("availMemUnit", this.mAvailMem / UNIT_SIZE);     // Catch: JSONException -> L5
            r0.put("totalMemUnit", this.mTotalMem / UNIT_SIZE);     // Catch: JSONException -> L5
            r7.put("sys_memory_info", r0);     // Catch: JSONException -> L5
            return;
        }
    }

    public static void a(File r3) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.crash.i.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L6;
        ActivityManager r1 = (ActivityManager) ZeusTransformUtils.preCheckCast(r0.getSystemService("activity"), ActivityManager.class, "com.obric.aiagent.plugin");
        DevMemoryInfo.dump(r3);
        SysMemoryInfo.dump(r3, r1);
        AppMemoryInfo.dump(r3, r1);
        return;
    }

    public static void a(JSONObject r4, File r5) {
        if (r5 == null) goto L5;
        AppMemoryInfo r0 = AppMemoryInfo.load(r5);
        SysMemoryInfo r1 = SysMemoryInfo.load(r5);
        DevMemoryInfo r2 = DevMemoryInfo.load(r5);
        JSONObject r6 = b(r5);
    L12:
        if (r0 == null) goto L14;
        r0.pushTo(r4);
    L14:
        if (r1 == null) goto L16;
        r1.pushTo(r4);
    L16:
        if (r2 == null) goto L18;
        r2.pushTo(r4);
    L18:
        if (r6 == null) goto L21;
        a(r4, r6);
        return;
    L21:
        return;
    L5:
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.crash.i.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L10;
        ActivityManager r8 = (ActivityManager) ZeusTransformUtils.preCheckCast(r7.getSystemService("activity"), ActivityManager.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L10;
        AppMemoryInfo r3 = new AppMemoryInfo(r8);
        SysMemoryInfo r9 = new SysMemoryInfo(r8);
    L11:
        SysMemoryInfo r10 = r9;
        r2 = new DevMemoryInfo();
        r6 = null;
        r0 = r3;
        r1 = r10;
    L10:
        r3 = null;
        r9 = null;
        goto L11
    }

    public static void a(JSONObject r1) {
        a(r1, null);
    }

    private static void a(JSONObject r2, JSONObject r3) {
        JSONObject r1 = r2.optJSONObject("memory_info");
        if (r1 != null) goto L7;
        r2.putOpt("memory_info", r3);     // Catch: JSONException -> L10
        return;
    L15:
        return;
    L7:
        if (r1.has("graphicPss") == true) goto L13;
        com.bytedance.crash.o.l.a(r1, r3);
        return;
    }

    private static JSONObject b(File r9) {
        JSONObject r0 = new JSONObject();
        File r1 = new File(r9, "sys_memtrack.txt");
        if (r1.exists() == false) goto L18;
        BufferedReader r10 = null;
        BufferedReader r2 = new BufferedReader(new FileReader(r1));     // Catch: Throwable -> L19
    L20:
        String r11 = r2.readLine();     // Catch: Throwable -> L16
        if (r11 == null) goto L15;
        if ("".equals(r11) == true) goto L20;
        String[] r12 = r11.split(" ");     // Catch: Throwable -> L16
        if (r12.length != 3) goto L20;
        String r3 = r12[0];     // Catch: Throwable -> L16
        long r5 = Long.parseLong(r12[1]) * 1024;     // Catch: Throwable -> L16
        r0.putOpt(r3.substring(0, r3.length() - 1), Long.valueOf(r5));     // Catch: Throwable -> L16
        goto L20
    L15:
        com.bytedance.crash.o.k.a(r2);
    L16:
        r10 = r2;
    L17:
        com.bytedance.crash.o.k.a(r10);
    L18:
        return r0;
    }

    public static void b(JSONObject r9, File r10) {
        File r1 = new File(r10, "maps_size.txt");
        if (r1.exists() == false) goto L32;
        BufferedReader r11 = new BufferedReader(new FileReader(r1));     // Catch: Throwable -> L23
        String r2 = r11.readLine();     // Catch: Throwable -> L23
        if (r2 != null) goto L7;
        return;
    L7:
        String[] r3 = r2.trim().split(" ");     // Catch: Throwable -> L23
        if (r3.length >= 2) goto L10;
        return;
    L10:
        JSONArray r4 = new JSONArray();     // Catch: Throwable -> L23
    L11:
        String r5 = r11.readLine();     // Catch: Throwable -> L23
        if (r5 == null) goto L20;
        String[] r6 = r5.trim().split(" ");     // Catch: Throwable -> L23
        if (r6.length != r3.length) goto L11;
        JSONObject r7 = new JSONObject();     // Catch: Throwable -> L23
        int r8 = 0;
    L17:
        if (r8 >= r3.length) goto L19;
        r7.put(r3[r8], r6[r8]);     // Catch: Throwable -> L23
        r8 = r8 + 1;     // Catch: Throwable -> L23
        goto L17
    L19:
        r4.put(r7);     // Catch: Throwable -> L23
        goto L11
    L20:
        r11.close();     // Catch: Throwable -> L23
        r9.put("tagged_maps_size", r4);     // Catch: Throwable -> L23
    L21:
        com.bytedance.crash.o.j.a(r1);
        return;
    }
}

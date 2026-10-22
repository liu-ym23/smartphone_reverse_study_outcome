package com.apm.lite.k;

import android.os.Environment;
import android.os.StatFs;
import com.bytedance.crash.dumper.Scraps;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public final class v {
    public static JSONObject a() {
        JSONObject r100 = new JSONObject();
        long r101 = 0;
        long r102 = new StatFs(Environment.getRootDirectory().getPath()).getFreeBytes();     // Catch: Throwable -> L7
    L37:
        r100.put(Scraps.INNER_FREE, r102);     // Catch: Throwable -> L36
        long r103 = new StatFs(Environment.getRootDirectory().getPath()).getTotalBytes();     // Catch: Throwable -> L11
    L12:
        r100.put(Scraps.INNER_TOTAL, r103);     // Catch: Throwable -> L36
        if ("mounted".equals(Environment.getExternalStorageState()) == false) goto L17;
        long r104 = Environment.getExternalStorageDirectory().getFreeSpace();     // Catch: Throwable -> L35
    L18:
        r100.put(Scraps.SDCARD_FREE, r104);     // Catch: Throwable -> L36
        if ("mounted".equals(Environment.getExternalStorageState()) == false) goto L23;
        long r105 = Environment.getExternalStorageDirectory().getTotalSpace();     // Catch: Throwable -> L34
    L24:
        r100.put("sdcard_total", r105);     // Catch: Throwable -> L36
        long r106 = new StatFs(com.apm.lite.e.f29909a.getFilesDir().getPath()).getFreeBytes();     // Catch: Throwable -> L27
    L28:
        r100.put("inner_free_real", r106);     // Catch: Throwable -> L36
        r101 = new StatFs(com.apm.lite.e.f29909a.getFilesDir().getPath()).getTotalBytes();     // Catch: Throwable -> L33
    L31:
        r100.put("inner_total_real", r101);     // Catch: Throwable -> L36
    L27:
        r106 = 0;
    L23:
        r105 = 0;
    L17:
        r104 = 0;
    L11:
        r103 = 0;
    L32:
        return r100;
    L7:
        r102 = 0;
        goto L37
    }
}

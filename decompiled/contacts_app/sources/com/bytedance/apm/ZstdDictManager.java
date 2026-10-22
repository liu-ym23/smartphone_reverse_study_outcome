package com.bytedance.apm;

import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.apm6.util.FileUtils;
import com.bytedance.apm6.util.IOUtils;
import com.bytedance.apm6.util.UrlUtils;
import com.bytedance.apm6.util.constant.ReportConsts;
import com.bytedance.common.utility.date.DateDef;
import com.bytedance.services.apm.api.HttpResponse;
import com.bytedance.services.apm.api.IZstdDict;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ZstdDictManager implements IZstdDict {
    public static final String DICT_INTERVAL = "dict_interval";
    private static final String DICT_VERSION = "dict_version";
    public static final String DICT_VERSION_HEADER_KEY = "slardar-zstd-version";
    private byte[] mDict;
    private String mDictVersion;
    private long mInterval;
    private volatile boolean mIsInit;
    private String url;

    public ZstdDictManager() {
    }

    @Override // com.bytedance.services.apm.api.IZstdDict
    public Pair<byte[], String> getDictAndDictVersion() {
        ensureInit();
        byte[] r0 = this.mDict;
        if (r0 != null) goto L5;
    L6:
        downloadDict();
        r0 = this.mDict;
    L8:
        return new Pair(r0, this.mDictVersion);
    L5:
        if ((System.currentTimeMillis() - this.mInterval) <= DateDef.WEEK) goto L8;
        goto L6
    }

    private void ensureInit() {
        if (this.mIsInit == false) goto L5;
        return;
    L5:
        this.mDict = FileUtils.readFileToByteArray(new File(com.bytedance.apm6.foundation.context.ApmContext.getContext().getFilesDir(), "monitor_dict"));
        SharedPreferences r0 = com.bytedance.apm6.foundation.context.ApmContext.getContext().getSharedPreferences(DICT_INTERVAL, 0);
        this.mInterval = r0.getLong(DICT_INTERVAL, 0);
        this.mDictVersion = r0.getString(DICT_VERSION, null);
        this.mIsInit = true;
    }

    private void downloadDict() {
        HashMap r1 = new HashMap(com.bytedance.apm6.foundation.context.ApmContext.getUrlParams());
        r1.put("slardar_zstd_dict_type", "monitor");
        r1.put("zstd_client_code_version", "dynamic");
        r1.put("Content-Type", "application/json; charset=utf-8");
        byte[] r2 = new JSONObject(r1).toString().getBytes();     // Catch: Exception -> L13
        HttpResponse r3 = com.bytedance.apm6.foundation.context.ApmContext.doPost(UrlUtils.addParamsToURL(this.url, r1), r1, r2);     // Catch: Exception -> L13
        if (r3 != null) goto L6;
        return;
    L6:
        if (r3.getResponseBytes() == null) goto L19;
        JSONObject r4 = new JSONObject(new String(r3.getResponseBytes()));     // Catch: Exception -> L13
        String r5 = r4.getString(DICT_VERSION);     // Catch: Exception -> L13
        String r6 = r4.getString("dict");     // Catch: Exception -> L13
        if (r4.getInt("code") == 200) goto L10;
        return;
    L10:
        byte[] r7 = Base64.decode(r6, 0);     // Catch: Exception -> L13
        writeFile(new File(com.bytedance.apm6.foundation.context.ApmContext.getContext().getFilesDir(), "monitor_dict"), r7);     // Catch: Exception -> L13
        this.mDictVersion = r5;     // Catch: Exception -> L13
        this.mDict = r7;     // Catch: Exception -> L13
        this.mInterval = System.currentTimeMillis();
        com.bytedance.apm6.foundation.context.ApmContext.getContext().getSharedPreferences(DICT_INTERVAL, 0).edit().putLong(DICT_INTERVAL, this.mInterval).putString(DICT_VERSION, r5).commit();
        return;
    L19:
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.bytedance.services.apm.api.IZstdDict
    public void setDomain(String r3) {
        this.url = "https://" + r3 + ReportConsts.ZSTD_DICT_PATH;
    }

    private static void writeFile(File r2, byte[] r3) throws IOException {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r3 != null) goto L6;
        return;
    L6:
        if (r3.length == 0) goto L30;
        r2.getParentFile().mkdirs();
        FileOutputStream r0 = null;
    L18:
        th = th;
    L19:
        IOUtils.safeClose(r0);
        throw th;
    L10:
        if (r2.exists() == false) goto L12;
        r2.delete();     // Catch: Throwable -> L18 Exception -> L23
    L12:
        r2.exists();     // Catch: Throwable -> L18 Exception -> L23
        FileOutputStream r1 = new FileOutputStream(r2);     // Catch: Throwable -> L18 Exception -> L23
        r1.write(r3);     // Catch: Throwable -> L15 Exception -> L17
        r1.flush();     // Catch: Throwable -> L15 Exception -> L17
        IOUtils.safeClose(r1);
        return;
    L17:
        r0 = r1;
    L15:
        th = th;
        r0 = r1;
        goto L19
    L21:
        IOUtils.safeClose(r0);
        return;
    }
}

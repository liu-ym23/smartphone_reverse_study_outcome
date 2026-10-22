package com.autonavi.aps.amapapi.utils;

import S1.a;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.amap.api.col.jmsl.C1568j1;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.security.Encrypt;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ReportRecorder {

    /* renamed from: h, reason: collision with root package name */
    private static ReportRecorder f18453h;

    /* renamed from: i, reason: collision with root package name */
    private static long f18454i;

    /* renamed from: b, reason: collision with root package name */
    private File f18456b;

    /* renamed from: c, reason: collision with root package name */
    private String f18457c;

    /* renamed from: d, reason: collision with root package name */
    private Context f18458d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f18459e;

    /* renamed from: a, reason: collision with root package name */
    private LinkedHashMap<String, Long> f18455a = new LinkedHashMap<>();

    /* renamed from: f, reason: collision with root package name */
    String f18460f = "";

    /* renamed from: g, reason: collision with root package name */
    String f18461g = null;

    private ReportRecorder(Context context) {
        this.f18457c = null;
        Context applicationContext = context.getApplicationContext();
        this.f18458d = applicationContext;
        String path = applicationContext.getFilesDir().getPath();
        if (this.f18457c == null) {
            this.f18457c = Utils.getPackageNameMD5(this.f18458d);
        }
        try {
            this.f18456b = new File(path, "reportRecorder");
        } catch (Throwable th) {
            a.b(th);
        }
        a();
    }

    private synchronized void a() {
        LinkedHashMap<String, Long> linkedHashMap = this.f18455a;
        if (linkedHashMap == null || linkedHashMap.size() <= 0) {
            try {
                this.f18460f = new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
                Iterator<String> it = Utils.readLines(this.f18456b).iterator();
                while (it.hasNext()) {
                    try {
                        try {
                            String[] strArrSplit = new String(Encrypt.aesDecrypt(C1568j1.b(it.next()), this.f18457c), "UTF-8").split(Const.STR_MART_COMMA);
                            if (strArrSplit != null && strArrSplit.length > 1) {
                                this.f18455a.put(strArrSplit[0], Long.valueOf(Long.parseLong(strArrSplit[1])));
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    } catch (UnsupportedEncodingException e10) {
                        e10.printStackTrace();
                    }
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public static synchronized ReportRecorder getInstance(Context context) {
        try {
            if (f18453h == null) {
                f18453h = new ReportRecorder(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f18453h;
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002d A[Catch: all -> 0x0016, TryCatch #1 {all -> 0x0016, blocks: (B:3:0x0001, B:5:0x000b, B:14:0x002d, B:15:0x003c, B:17:0x0042, B:23:0x005f, B:24:0x0063, B:25:0x0067, B:27:0x006d, B:28:0x0079, B:32:0x0081, B:34:0x0088, B:37:0x0090, B:39:0x009c, B:41:0x00c6, B:43:0x00ce, B:45:0x00d5, B:46:0x00d8, B:40:0x00b9, B:10:0x0019, B:12:0x0023, B:18:0x0048), top: B:58:0x0001, inners: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void addRecortNum(com.amap.api.location.AMapLocation r7) {
        /*
            Method dump skipped, instructions count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.utils.ReportRecorder.addRecortNum(com.amap.api.location.AMapLocation):void");
    }

    public synchronized void applyStatistics() {
        Context context;
        try {
            context = this.f18458d;
            if (this.f18461g == null) {
                this.f18461g = SPUtil.getPrefsStr(context, Const.STR_PREF, Const.STR_PREF_KEY_LAST_SAVE, "0");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (this.f18461g.equals(this.f18460f)) {
            return;
        }
        SharedPreferences.Editor editorStartEdit = SPUtil.startEdit(context, Const.STR_PREF);
        SPUtil.setPrefsStr(editorStartEdit, Const.STR_PREF_KEY_LAST_SAVE, this.f18460f);
        SPUtil.endEdit(editorStartEdit);
        this.f18461g = this.f18460f;
        for (Map.Entry<String, Long> entry : this.f18455a.entrySet()) {
            try {
                if (!this.f18460f.equals(entry.getKey())) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("param_long_first", entry.getKey());
                    jSONObject.put("param_long_second", entry.getValue());
                    ReportUtil.applyStatistics(this.f18458d, ReportUtil.STATICS_ID_OFFLINECOUNT, jSONObject);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public synchronized void synToDisk() {
        if (this.f18459e) {
            try {
                StringBuilder sb2 = new StringBuilder();
                for (Map.Entry<String, Long> entry : this.f18455a.entrySet()) {
                    try {
                        sb2.append(C1568j1.g(Encrypt.aesEncrypt((entry.getKey() + Const.STR_MART_COMMA + entry.getValue()).getBytes("UTF-8"), this.f18457c)) + "\n");
                    } catch (UnsupportedEncodingException e10) {
                        e10.printStackTrace();
                    }
                }
                String string = sb2.toString();
                if (!TextUtils.isEmpty(string)) {
                    Utils.writeStringToFile(this.f18456b, string, false);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.f18459e = false;
        }
    }
}

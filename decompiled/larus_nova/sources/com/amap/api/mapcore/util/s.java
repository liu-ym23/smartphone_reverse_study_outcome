package com.amap.api.mapcore.util;

import android.content.Context;
import com.bytedance.ee.plugin.common.ttreader.ITTReaderViewWrapper;
import java.util.Hashtable;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class s extends d5<String, a> {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f27940t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int[] f27941u;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f27942a;

        public a() {
            this.f27942a = false;
        }
    }

    @Override // com.amap.api.mapcore.util.y7
    public boolean isSupportIPV6() {
        return true;
    }

    @Override // com.amap.api.mapcore.util.c3, com.amap.api.mapcore.util.y7
    public Map<String, String> getParams() {
        Hashtable r100 = new Hashtable(16);
        r100.put("key", l5.e(this.f27173q));
        if (this.f27940t == false) goto L5;
        r100.put("pname", "3dmap");
    L5:
        String r101 = n5.a();
        String r102 = n5.a(this.f27173q, r101, x5.a(r100));
        r100.put("ts", r101);
        r100.put("scode", r102);
        return r100;
    }

    @Override // com.amap.api.mapcore.util.y7
    public String getURL() {
        return ("http://" + p5.b(this.f27173q).a(27)) + "/v4" + this.f27174r;
    }

    @Override // com.amap.api.mapcore.util.y7
    public String getIPV6URL() {
        return w3.a(getURL(), this.f27173q);
    }

    @Override // com.amap.api.mapcore.util.d5
    public a b(String r100) throws c5 {
        JSONObject r101 = new JSONObject(r100);     // Catch: Throwable -> L14
        if (r101.has("errcode") == false) goto L6;
        int r102 = r101.optInt("errcode");     // Catch: Throwable -> L14
        r101.optString(ITTReaderViewWrapper.ERROR_MSG_KEY);     // Catch: Throwable -> L14
        r101.optString("errdetail");     // Catch: Throwable -> L14
    L7:
        a r103 = new a();     // Catch: Throwable -> L14
        int r104 = 0;
        r103.f27942a = false;     // Catch: Throwable -> L14
        int[] r105 = this.f27941u;     // Catch: Throwable -> L14
        int r106 = r105.length;     // Catch: Throwable -> L14
    L8:
        if (r104 >= r106) goto L22;
        if (r105[r104] == r102) goto L11;
        r104 = r104 + 1;
        goto L8
    L11:
        r103.f27942a = true;     // Catch: Throwable -> L14
        return r103;
    L22:
        return r103;
    L6:
        r102 = -1;
    L14:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public s(Context r100, String r101) {
        super(r100, r101);
        this.f27941u = new int[]{10000, 0, 10018, 10019, 10020, 10021, 10022, 10023};
        this.f27174r = "/feedback";
        this.isPostFlag = false;
        this.f27940t = true;
    }
}

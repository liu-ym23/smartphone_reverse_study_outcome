package com.bytedance.android.monitorV2.webview;

import android.webkit.WebView;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String[] f163336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String[] f163337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f163338c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f163339d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f163340e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f163341f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f163342g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f163343h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f163344i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public tz2.a f163345j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public JSONObject f163346k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f163347l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f163348m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f163349n;

    public final String toString() {
        return "Config{mWebViewClasses=" + Arrays.toString(this.f163336a) + ", mWebViewObjKeys=" + Arrays.toString(this.f163337b) + ", mIsNeedMonitor='" + this.f163341f + "', mIsNeedInjectBrowser='" + this.f163340e + "', sourceMonitor='" + this.f163338c + "', mBid='" + this.f163342g + "', virtualAid='" + this.f163343h + "'}";
    }

    public c() {
        this.f163339d = "";
        this.f163340e = true;
        this.f163341f = true;
        this.f163342g = "";
        this.f163346k = new JSONObject();
        this.f163347l = "";
        this.f163348m = "";
        this.f163349n = "";
    }

    public final void a(WebView... r100) {
        if (r100.length <= 0) goto L15;
        ArrayList r101 = new ArrayList();
        int r102 = r100.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L10;
        WebView r104 = r100[r103];
        if (r104 == null) goto L9;
        r101.add(r104.hashCode() + "");
    L9:
        r103 = r103 + 1;
        goto L5
    L10:
        this.f163337b = (String[]) r101.toArray(new String[r101.size()]);
        return;
    }
}

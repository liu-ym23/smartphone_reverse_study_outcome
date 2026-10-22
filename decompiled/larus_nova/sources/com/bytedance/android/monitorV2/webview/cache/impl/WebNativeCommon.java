package com.bytedance.android.monitorV2.webview.cache.impl;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.monitorV2.entity.NativeCommon;
import com.bytedance.android.monitorV2.g;
import com.bytedance.android.monitorV2.util.b;
import com.bytedance.android.monitorV2.util.l;
import com.bytedance.android.monitorV2.webview.m;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class WebNativeCommon extends NativeCommon {
    private JSONObject eventObject;
    private JSONObject extraPerformance;
    private long loadUrlTime;
    public String webViewType;

    public WebNativeCommon() {
        this.webViewType = "web";
        this.extraPerformance = new JSONObject();
        this.eventObject = new JSONObject();
    }

    public long getClickStartTime() {
        return this.clickStart;
    }

    public long getLoadUrlTime() {
        return this.loadUrlTime;
    }

    public String getNavigationIdCache() {
        return this.navigationId;
    }

    public String getUrlCache() {
        return this.url;
    }

    public void addDebugContext(JSONObject r100) {
        JSONObject r101 = r100.optJSONObject("debug_context");
        if (r101 != null) goto L5;
        r101 = new JSONObject();
        l.p(r100, "debug_context", r101);
    L5:
        l.q(r101, "is_ttweb_enable", String.valueOf(m.f163358f.D()));
    }

    @Override // com.bytedance.android.monitorV2.entity.NativeCommon, fz2.a
    public void fillInJsonObject(JSONObject r100) {
        super.fillInJsonObject(r100);
        l.q(r100, "js_dependency_version", "2.2.1");
        l.q(r100, "webview_type", this.webViewType);
        l.a(r100, this.extraPerformance);
        l.a(r100, this.eventObject);
        addDebugContext(r100);
    }

    public void initNativePage(Context r100) {
        Activity r101 = b.a(r100);
        if (r101 == null) goto L11;
        g r102 = g.e();
        if (r102.f163042c == false) goto L9;
        g.b r103 = r102.f163043d;
        if (r103 == null) goto L9;
        r103.a(r101);
    L9:
        this.nativePage = r101.getClass().getName();
        return;
    }

    public void saveCommonData(JSONObject r100) {
        Iterator<String> r101 = r100.keys();
    L4:
        if (r101.hasNext() == false) goto L6;
        String r102 = r101.next();
        l.p(this.extraPerformance, r102, l.k(r100, r102));
        goto L4
    }

    public void setClickStartTime(long r100) {
        this.clickStart = r100;
    }

    public void setContainerType(String r100) {
        this.containerType = r100;
    }

    public void setLoadUrlTime(long r100) {
        this.loadUrlTime = r100;
    }

    public void setNavigationIdCache(String r100) {
        this.navigationId = r100;
    }

    public void setUrlCache(String r100) {
        this.url = r100;
    }

    public void setWebViewType(String r100) {
        this.webViewType = r100;
    }

    public void saveExtra(String r100, Object r101) {
        l.p(this.eventObject, r100, r101);
    }
}

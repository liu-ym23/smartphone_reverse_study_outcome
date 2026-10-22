package com.bytedance.ttnet;

import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.retrofit2.SsHttpCall;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class TNCRequestFlagHandler implements SsHttpCall.IRequestFlagHandler {
    private static final String TAG = "TNCRequestFlagHandler";
    private static volatile TNCRequestFlagHandler sInstance;
    private final List<SingleRequestFlagConfig> mRequestFlagConfigs;
    private final AtomicBoolean mRequestFlagCtlEnabled;

    static final class SingleRequestFlagConfig {
        final List<String> mMatchHosts;
        final List<String> mMatchPaths;
        int mTncRequestCronetFlags;
        int mTncRequestTTNetFlags;

        SingleRequestFlagConfig(int r3, int r4, List<String> r5, List<String> r6) {
            ArrayList r0 = new ArrayList();
            this.mMatchHosts = r0;
            ArrayList r1 = new ArrayList();
            this.mMatchPaths = r1;
            this.mTncRequestCronetFlags = r3;
            this.mTncRequestTTNetFlags = r4;
            r0.addAll(r5);
            r1.addAll(r6);
        }
    }

    public TNCRequestFlagHandler() {
        this.mRequestFlagConfigs = new CopyOnWriteArrayList();
        this.mRequestFlagCtlEnabled = new AtomicBoolean(false);
    }

    public static TNCRequestFlagHandler getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(TNCRequestFlagHandler.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new TNCRequestFlagHandler();     // Catch: Throwable -> L11
        SsHttpCall.setRequestFlagHandler(sInstance);     // Catch: Throwable -> L11
    L9:
        monitor-exit(TNCRequestFlagHandler.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    @Override // com.bytedance.retrofit2.SsHttpCall.IRequestFlagHandler
    public Request handleFlag(Request r7) {
        if (r7 != null) goto L4;
        return r7;
    L4:
        if (this.mRequestFlagCtlEnabled.get() == false) goto L80;
        Iterator<SingleRequestFlagConfig> r6 = this.mRequestFlagConfigs.iterator();
    L7:
        boolean r1 = true;
        if (r6.hasNext() == false) goto L39;
        SingleRequestFlagConfig r0 = r6.next();
        Iterator<String> r3 = r0.mMatchHosts.iterator();
    L11:
        if (r3.hasNext() == false) goto L15;
        if (UrlUtils.matchPattern(r7.getHost(), r3.next()) == false) goto L11;
        boolean r4 = true;
    L16:
        if (r4 == false) goto L7;
        List<String> r5 = r0.mMatchPaths;
        if (r5 == null) goto L7;
        Iterator<String> r8 = r5.iterator();
    L23:
        if (r8.hasNext() == false) goto L29;
        String r9 = r8.next();
        if (r7.getPath() == null) goto L23;
        if (r7.getPath().startsWith(r9) == false) goto L23;
    L30:
        if (r1 == false) goto L7;
        if (r7.getExtraInfo() != null) goto L36;
        Request.Builder r10 = r7.newBuilder();
        r10.setExtraInfo(new BaseRequestContext());
        r7 = r10.build();
    L36:
        if ((r7.getExtraInfo() instanceof BaseRequestContext) == false) goto L7;
        BaseRequestContext r2 = (BaseRequestContext) r7.getExtraInfo();
        r2.request_flag |= r0.mTncRequestCronetFlags;
        r2.request_type_flags = r0.mTncRequestTTNetFlags | r2.request_type_flags;
        Request.Builder r11 = r7.newBuilder();
        r11.setExtraInfo(r2);
        r7 = r11.build();
        goto L7
    L29:
        r1 = false;
        goto L30
    L15:
        r4 = false;
        goto L16
    L39:
        if ((r7.getExtraInfo() instanceof BaseRequestContext) == false) goto L78;
        BaseRequestContext r12 = (BaseRequestContext) r7.getExtraInfo();
        if ((r12.request_type_flags & 512) <= 0) goto L43;
        boolean r13 = true;
    L45:
        if ((r12.request_type_flags & 1024) > 0) goto L48;
        r1 = false;
    L48:
        if (r13 == true) goto L50;
        if (r1 == true) goto L50;
        return r7;
    L50:
        Request.Builder r14 = r7.newBuilder();
        ArrayList r15 = new ArrayList();
        r15.addAll(r7.getHeaders());
        if (r13 == false) goto L53;
        r15.add(new Header(Request.KEY_BYPASS_TTNET_FEATURES, "1"));
    L53:
        if (r1 == false) goto L55;
        r15.add(new Header(Request.KEY_BYPASS_DISPATCH, "1"));
    L55:
        r14.headers(r15);
        return r14.build();
    L43:
        r13 = false;
        goto L45
    L78:
        return r7;
    L80:
        return r7;
    }

    @Override // com.bytedance.retrofit2.SsHttpCall.IRequestFlagHandler
    public boolean shouldBypassInterceptor(Request r2) {
        if ((r2.getExtraInfo() instanceof BaseRequestContext) == false) goto L10;
        BaseRequestContext r1 = (BaseRequestContext) r2.getExtraInfo();
        if ((r1.request_type_flags & 256) <= 0) goto L7;
    L8:
        return true;
    L7:
        if ((r1.request_type_flags & 512) > 0) goto L8;
        return false;
    L10:
        return false;
    }

    public void parseJson2Config(JSONObject r14) {
        JSONArray r1 = r14.optJSONArray("request_flag_control");
        if (r1 != null) goto L5;
        return;
    L5:
        this.mRequestFlagCtlEnabled.set(false);
        this.mRequestFlagConfigs.clear();
        ArrayList r2 = new ArrayList();     // Catch: JSONException -> L38
        int r4 = 0;
    L8:
        if (r4 >= r1.length()) goto L33;
        JSONObject r5 = r1.getJSONObject(r4);     // Catch: JSONException -> L38
        int r6 = r5.optInt("cronet_flags");     // Catch: JSONException -> L38
        int r7 = r5.optInt("ttnet_flags");     // Catch: JSONException -> L38
        JSONArray r8 = r5.optJSONArray("prefix_group");     // Catch: JSONException -> L38
        JSONArray r9 = r5.optJSONArray("host_group");     // Catch: JSONException -> L38
        ArrayList r10 = new ArrayList();     // Catch: JSONException -> L38
        if (r8 == null) goto L16;
        int r11 = 0;
    L14:
        if (r11 >= r8.length()) goto L16;
        r10.add(r8.optString(r11, ""));     // Catch: JSONException -> L38
        r11 = r11 + 1;     // Catch: JSONException -> L38
    L16:
        ArrayList r12 = new ArrayList();     // Catch: JSONException -> L38
        if (r9 == null) goto L22;
        int r13 = 0;
    L20:
        if (r13 >= r9.length()) goto L22;
        r12.add(r9.optString(r13, ""));     // Catch: JSONException -> L38
        r13 = r13 + 1;     // Catch: JSONException -> L38
    L22:
        if (r6 > 0) goto L25;
        if (r7 > 0) goto L25;
    L31:
        r4 = r4 + 1;     // Catch: JSONException -> L38
    L25:
        if (r10.isEmpty() == true) goto L31;
        if (r12.isEmpty() == true) goto L31;
        r2.add(new SingleRequestFlagConfig(r6, r7, r12, r10));     // Catch: JSONException -> L38
        if (Logger.debug() == false) goto L31;
        Logger.d(TAG, "paths: " + r10);     // Catch: JSONException -> L38
        Logger.d(TAG, "hosts: " + r12);     // Catch: JSONException -> L38
        Logger.d(TAG, "flag: " + r6);     // Catch: JSONException -> L38
        Logger.d(TAG, "type flag: " + r7);     // Catch: JSONException -> L38
        goto L31
    L33:
        if (r14.optInt("req_flag_ctl_enabled") > 0) goto L35;
        return;
    L35:
        if (r2.size() <= 0) goto L50;
        this.mRequestFlagConfigs.addAll(r2);     // Catch: JSONException -> L38
        this.mRequestFlagCtlEnabled.set(true);     // Catch: JSONException -> L38
        return;
    L50:
        return;
    }
}

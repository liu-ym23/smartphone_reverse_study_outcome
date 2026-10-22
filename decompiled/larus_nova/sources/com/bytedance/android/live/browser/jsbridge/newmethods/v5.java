package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class v5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExecutorService f63689a = null;

    @XBridgeMethod(biz = "webcast", name = "getStorage")
    public static class a extends com.bytedance.ies.web.jsbridge2.g<JSONObject, JSONObject> {
        public a() {
        }

        @Override // com.bytedance.ies.web.jsbridge2.g
        public final JSONObject invoke(JSONObject r100, CallContext r101) throws Exception {
            JSONObject r102 = r100;
            JSONObject r103 = new JSONObject();
            String r104 = r102.optString("fileName", "");
            if (TextUtils.isEmpty(r104) == false) goto L5;
            ExecutorService r105 = v5.f63689a;
            SharedPreferences r106 = r101.getContext().getSharedPreferences("js_kv_methods_20191113", 0);
        L7:
            if (TextUtils.equals(r102.optString("type", ""), "all") == false) goto L20;
            Map<String, ?> r107 = r106.getAll();
            JSONObject r108 = new JSONObject();
            if (r107 != null) goto L11;
        L19:
            r103.put("value", r108);
        L21:
            r103.put("code", 1);
            return r103;
        L11:
            if (r107.isEmpty() == true) goto L19;
            Iterator<String> r109 = r107.keySet().iterator();
        L14:
            if (r109.hasNext() == false) goto L19;
            String r110 = r109.next();
            if (r110 == null) goto L14;
            r108.put(r110.toString(), r106.getString(r110.toString(), ""));
            goto L14
        L20:
            r103.put("value", r106.getString(r102.optString("key"), ""));
            goto L21
        L5:
            ExecutorService r111 = v5.f63689a;
            r106 = r101.getContext().getSharedPreferences(r104, 0);
            goto L7
        }
    }

    @XBridgeMethod(biz = "webcast", name = "removeStorage")
    public static class b extends com.bytedance.ies.web.jsbridge2.g<JSONObject, JSONObject> {
        public b() {
        }

        @Override // com.bytedance.ies.web.jsbridge2.g
        public final JSONObject invoke(JSONObject r100, CallContext r101) throws Exception {
            JSONObject r102 = r100;
            boolean r103 = TextUtils.equals(r102.optString("type", ""), "all");
            JSONObject r104 = new JSONObject();
            if (r103 == false) goto L5;
            v5.a(r101).clear().apply();
        L6:
            r104.put("code", 1);
            return r104;
        L5:
            String r105 = r102.optString("key");
            v5.a(r101).remove(r105).apply();
            goto L6
        }
    }

    @XBridgeMethod(biz = "webcast", name = "setStorage")
    public static class c extends com.bytedance.ies.web.jsbridge2.g<JSONObject, JSONObject> {
        public c() {
        }

        @Override // com.bytedance.ies.web.jsbridge2.g
        public final JSONObject invoke(JSONObject r100, CallContext r101) throws Exception {
            JSONObject r102 = r100;
            String r103 = r102.optString("key");
            String r104 = r102.optString("value");
            v5.a(r101).putString(r103, r104).apply();
            JSONObject r105 = new JSONObject();
            r105.put("code", 1);
            return r105;
        }
    }

    public static class d extends com.bytedance.ies.web.jsbridge2.f<JSONObject, JSONObject> {
        @Override // com.bytedance.ies.web.jsbridge2.f
        public final void onTerminate() {
        }

        public d() {
        }

        @Override // com.bytedance.ies.web.jsbridge2.f
        public final void invoke(JSONObject r100, final CallContext r101) throws Exception {
            JSONObject r102 = r100;
            final String r103 = r102.optString("key");
            final String r104 = r102.optString("value");
            v5.f63689a.submit(new w5(this, r101, r103, r104));
        }
    }

    static {
        f63689a = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("ods/KVMethods"));
    }

    public static SharedPreferences.Editor a(CallContext r100) {
        return r100.getContext().getSharedPreferences("js_kv_methods_20191113", 0).edit();
    }
}

package com.bytedance.reparo;

import android.app.Application;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.reparo.core.m;
import com.bytedance.reparo.model.PatchFetchInfo;
import com.bytedance.reparo.model.Response;
import com.google.gson.Gson;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: RemotePatchFetcher.java */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IReparoConfig f9356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Application f9357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f9358c;

    /* JADX INFO: compiled from: RemotePatchFetcher.java */
    interface a {
        void a(com.bytedance.reparo.core.b.d r1);

        void a(List<PatchFetchInfo> r1);
    }

    /* JADX INFO: compiled from: RemotePatchFetcher.java */
    public class b extends com.bytedance.reparo.core.b.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f9359a;

        public b(f r1, String r2) {
            this.f9359a = r1;
            super(r2, 0);
        }
    }

    public f(Application r3, IReparoConfig r4, String r5) {
        this.f9357b = (Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.aiagent.plugin");
        this.f9356a = r4;
        this.f9358c = r5;
    }

    public void a(a r7) {
        a r8 = (a) ZeusTransformUtils.wrapperContextForParams(r7, a.class, "com.obric.aiagent.plugin");
        int r1 = m.a().b();     // Catch: Throwable -> L13
        if (r1 != (-1)) goto L7;
        r8.a(new com.bytedance.reparo.core.b.d("wrong abi bits", 0));     // Catch: Throwable -> L13
        return;
    L7:
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L13
        r2.put("patch", new JSONArray());     // Catch: Throwable -> L13
        if (com.bytedance.reparo.core.i.f.a(this.f9357b) == false) goto L10;
        int r4 = 1;
    L11:
        r2.put("debug", r4);     // Catch: Throwable -> L13
        Uri.Builder r3 = Uri.parse(g.a().b()).buildUpon();     // Catch: Throwable -> L13
        r3.appendQueryParameter("hotfix_abi", String.valueOf(r1));     // Catch: Throwable -> L13
        r3.appendQueryParameter("sdk_version", com.bytedance.reparo.core.a.b.e.a(this.f9358c));     // Catch: Throwable -> L13
        r3.appendQueryParameter("hotfix_type", "reparo");     // Catch: Throwable -> L13
        r3.appendQueryParameter("channel", this.f9356a.getChannel());     // Catch: Throwable -> L13
        r8.a(a(this.f9356a.executePatchRequest(33554432, r3.toString(), r2.toString().getBytes(), "application/json; charset=utf-8")));     // Catch: Throwable -> L13
        return;
    L10:
        r4 = 0;
    L13:
        th = move-exception;
        r8.a(new com.bytedance.reparo.core.b.d("queryRemotePatchInfo error.", th, 0));
    }

    private List<PatchFetchInfo> a(String r3) {
        if (TextUtils.isEmpty(r3) == true) goto L15;
        Response r2 = (Response) ZeusTransformUtils.preCheckCast(new Gson().fromJson(r3, Response.class), Response.class, "com.obric.aiagent.plugin");
        if (TextUtils.equals("success", r2.message) == false) goto L13;
        Response.PatchResponse r4 = r2.data;
        if (r4.patch != null) goto L11;
        return new ArrayList();
    L11:
        return r4.patch;
    L13:
        throw new IllegalAccessException(String.format("an error occurred on this interface, response is %s", new Object[]{r3}));
    L15:
        throw new b(this, "response is null");
    }
}

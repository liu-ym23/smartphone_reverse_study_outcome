package com.baidu.naviapi.platform;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.lbsapi.auth.LBSAuthManagerListener;
import com.baidu.mshield.x6.EngineImpl;
import com.baidu.naviapi.okhttp.log.BNLogUtil;
import com.baidu.naviapi.open.IAuthResult;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.Hashtable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public final class c implements LBSAuthManagerListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Hashtable<String, String> f32665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IAuthResult f32666b;

    public static /* synthetic */ class a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f32667a = null;

        static {
            f32667a = new c(null);
        }

        public static /* synthetic */ c a() {
            return f32667a;
        }
    }

    public c() {
        this.f32665a = new Hashtable();
    }

    public static c a() {
        return b.a();
    }

    public /* synthetic */ c(a r100) {
        this();
    }

    public final void a(String r100) {
        d.a("token", r100);
    }

    public void a(Context r100, IAuthResult r101) {
        this.f32666b = r101;
        if (r101 != null) goto L6;
        BNLogUtil.logI("lbs-active iAuthResult = null");
        return;
    L6:
        this.f32665a.put(EngineImpl.KEY_CUID, e.b().a());
        LBSAuthManager.getInstance(r100).setKey(r101.getApiKey());
        int r102 = LBSAuthManager.getInstance(r100).authenticate(false, "lbs_androidsdk", this.f32665a, this);
        if (r102 == 0) goto L10;
        BNLogUtil.logI("lbs-active ret " + r102);
        return;
    }

    @Override // com.baidu.lbsapi.auth.LBSAuthManagerListener
    public void onAuthResult(int r100, String r101) {
        BNLogUtil.logI("onAuthResult " + r100 + r101);
        if (TextUtils.isEmpty(r101) == false) goto L20;
        IAuthResult r102 = this.f32666b;
        if (r102 == null) goto L22;
        r102.authenticate(1, "内部错误");
        return;
    L22:
        return;
    L20:
        JSONObject r103 = new JSONObject(r101);     // Catch: Exception -> L15
        int r104 = r103.optInt("status", 1);     // Catch: Exception -> L15
        String r105 = r103.optString("message", "null");     // Catch: Exception -> L15
        if (r104 != 0) goto L11;
        a(JSONObjectProtectorUtils.getString(r103, "token"));     // Catch: Exception -> L15
    L11:
        IAuthResult r106 = this.f32666b;     // Catch: Exception -> L15
        if (r106 == null) goto L23;
        r106.authenticate(r104, r105);     // Catch: Exception -> L15
        return;
    L23:
        return;
    L15:
        e = move-exception;
        BNLogUtil.logE("onAuthResult", e);
        IAuthResult r107 = this.f32666b;
        if (r107 == null) goto L24;
        r107.authenticate(1, "e 内部错误");
        return;
    }
}

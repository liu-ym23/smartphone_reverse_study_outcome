package com.bytedance.android.gamecp.business.download;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y0 f52963a = null;

    public static final class a implements e1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f52964a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ wr.b f52965b;

        @Override // com.bytedance.android.gamecp.business.download.e1
        public final void a(JSONObject r100) {
        }

        @Override // com.bytedance.android.gamecp.business.download.e1
        public final void b(List<p> r100) {
            Intrinsics.checkNotNullParameter(r100, "downloadList");
            Iterator<p> r101 = r100.iterator();
        L4:
            if (r101.hasNext() == false) goto L9;
            p r102 = r101.next();
            LocalTestManager.a(new Class[]{uv.a.class});
            if (Intrinsics.areEqual(r102.f52855k, this.f52964a) == false) goto L4;
            this.f52965b.onResult(r102);
            return;
        L9:
            LocalTestManager.a(new Class[]{uv.a.class});
            this.f52965b.onResult(null);
        }

        public a(String r100, wr.b r101) {
            this.f52964a = r100;
            this.f52965b = r101;
        }
    }

    public y0() {
    }

    static {
        f52963a = new y0();
    }

    public static boolean f(p r100) {
        com.bytedance.android.gamecp.host_api.a.b().getHostDownloadService().F();
        int r101 = com.bytedance.android.gamecp.business.f.f53161a;
        Boolean r102 = Boolean.FALSE;
        Pair r103 = new Pair(r102, r102);
        boolean r104 = ((Boolean) r103.component1()).booleanValue();
        boolean r105 = ((Boolean) r103.component2()).booleanValue();
        if (r104 == false) goto L6;
        if (r105 == false) goto L9;
        com.bytedance.android.gamecp.host_api.a.b().getHostDownloadService().t();
        return false;
    L9:
        return false;
    L6:
        com.bytedance.android.gamecp.host_api.a.b().getHostDownloadService().t();
        return false;
    }

    public static boolean c(Context r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "params");
        int r102 = com.bytedance.android.gamecp.business.f.f53161a;
        Intrinsics.checkNotNullParameter(r101, "params");
        com.bytedance.gamecenter.base.q r103 = com.bytedance.gamecenter.base.q.l();
        Context r104 = com.bytedance.android.gamecp.host_api.a.b().getHostContext().getAppContext();
        if (r103.f245053f != null) goto L5;
        r103.f245053f = new com.bytedance.gamecenter.base.f(r104);
    L5:
        r103.f245053f.f244981a.getClass();
        return com.bytedance.gamecenter.base.g.a.f244983a.f(r101).booleanValue();
    }

    public static JSONArray g(Context r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "params");
        int r102 = com.bytedance.android.gamecp.business.f.f53161a;
        Intrinsics.checkNotNullParameter(r101, "params");
        com.bytedance.gamecenter.base.q r103 = com.bytedance.gamecenter.base.q.l();
        Context r104 = com.bytedance.android.gamecp.host_api.a.b().getHostContext().getAppContext();
        if (r103.f245053f != null) goto L5;
        r103.f245053f = new com.bytedance.gamecenter.base.f(r104);
    L5:
        r103.f245053f.f244981a.getClass();
        return com.bytedance.gamecenter.base.g.a.f244983a.b(r101);
    }

    public final void a(Context r100, p r101) {
        f(r101);
        GamePromoteDownloaderOld.f52422f.a(r100, r101);
    }

    public final void b(Context r100, p r101) {
        f(r101);
        GamePromoteDownloaderOld.f52422f.b(r100, r101);
    }

    public final void i(Context r100, p r101) {
        f(r101);
        GamePromoteDownloaderOld.f52422f.j(r100, r101);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static void d(Context r100, String r101, e1 r102) {
        Intrinsics.checkNotNullParameter(r101, "status");
        if (r100 != null) goto L5;
        return;
    L5:
        JSONObject r103 = new JSONObject();
        r103.put("status", r101);     // Catch: JSONException -> L12
        r103.put("biz_type", BaseConstants.GAME_INFO_LIVE_UNION);     // Catch: JSONException -> L12
        String r104 = wu.o0.f561360a.getValue();     // Catch: JSONException -> L12
        if (TextUtils.isEmpty(r104) == true) goto L9;
        JSONObject r105 = new JSONObject(r104);     // Catch: JSONException -> L12
    L10:
        r105.put("live_download_get_install_status_parse_package_info", wu.j0.f561330a.getValue().booleanValue());     // Catch: JSONException -> L12
        r103.put(AdDownloadModel.JsonKey.DOWNLOAD_SETTINGS, r105);     // Catch: JSONException -> L12
    L14:
        Intrinsics.checkNotNullParameter(r103, "json");
        com.bytedance.android.gamecp.host_api.a.b().getHostDownloadService().E();
        GamePromoteDownloaderOld.f52422f.d(r100, r103, r102);
        return;
    L9:
        r105 = new JSONObject();     // Catch: JSONException -> L12
    L12:
        e = move-exception;
        yr.c.b("", String.valueOf(e.getMessage()));
        goto L14
    }

    public static void e(Context r100, String r101, String r102, wr.b r103) {
        Intrinsics.checkNotNullParameter(r103, "callback");
        if (r100 == null) goto L16;
        if (r101 != null) goto L6;
    L9:
        boolean r104 = true;
    L10:
        if (r104 == true) goto L16;
        if (r102 != null) goto L14;
        r102 = "";
    L14:
        d(r100, r102, new a(r101, r103));
        return;
    L6:
        if (r101.length() == 0) goto L9;
        r104 = false;
    L16:
        r103.onResult(null);
    }

    public final void h(Context r100, p r101, com.bytedance.android.gamecp.base.core.service.depend.n r102, boolean r103) {
        f(r101);
        GamePromoteDownloaderOld.f52422f.h(r100, r101, r102, r103);
    }
}

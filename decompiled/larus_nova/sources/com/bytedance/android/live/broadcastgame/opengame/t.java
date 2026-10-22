package com.bytedance.android.live.broadcastgame.opengame;

import android.net.Uri;
import androidx.collection.LruCache;
import com.bytedance.android.live.broadcastgame.api.model.u;
import com.bytedance.android.live.broadcastgame.api.openplatform.PluginType;
import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformMiniAppDebugger;
import com.bytedance.bdp.live.livecontainer.base.schema.LiveSchemaInfo;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.io.File;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class t {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f61074q = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f61075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f61076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f61077c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f61078d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f61079e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f61080f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f61081g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f61082h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f61083i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f61084j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<String, ? extends Object> f61085k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.bytedance.android.live.broadcastgame.opengame.runtime.g f61086l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public File f61087m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f61088n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final PluginType f61089o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f61090p;

    public static final class a {
        public static int a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "schema");
            PluginType.Companion.getClass();
            boolean r101 = true;
            if (PluginType.a.a(r100) == PluginType.LYNX) goto L5;
        L7:
            Intrinsics.checkNotNullParameter(r100, "$this$isPreviewVersion");
            LruCache<String, LiveSchemaInfo> r102 = LiveSchemaInfo.f201489r;
            LiveSchemaInfo r103 = LiveSchemaInfo.c.a(r100);
            if (r103 == null) goto L10;
            String r104 = (String) r103.f201493d.getValue();
        L12:
            if (Intrinsics.areEqual(r104, "preview") == false) goto L14;
        L36:
            return 2;
        L14:
            if (PluginType.a.a(r100) != PluginType.MINI_APP) goto L35;
            int r105 = OpenPlatformMiniAppDebugger.f59980h;
            if (OpenPlatformMiniAppDebugger.Companion.b(r100) == true) goto L36;
            Intrinsics.checkNotNullParameter(r100, "schema");
            if (r100.length() != 0) goto L20;
            boolean r106 = true;
        L21:
            if (r106 == true) goto L32;
            Uri r107 = UriProtector.parse(r100);
            if (Intrinsics.areEqual(r107.getHost(), AppbrandHostConstants.Micro_Host.HOST_APPBRAND) == false) goto L32;
            if (Intrinsics.areEqual(UriProtector.getQueryParameter(r107, "version_type"), "latest") == false) goto L28;
        L33:
            if (r101 == false) goto L35;
        L28:
            if (Intrinsics.areEqual(UriProtector.getQueryParameter(r107, "version_type"), "audit") == true) goto L33;
            if (Intrinsics.areEqual(UriProtector.getQueryParameter(r107, "version_type"), "preview") == true) goto L33;
        L32:
            r101 = false;
            goto L33
        L20:
            r106 = false;
        L35:
            return 0;
        L10:
            r104 = null;
            goto L12
        L5:
            if (com.bytedance.android.live.broadcastgame.api.openplatform.k.a(r100) == false) goto L7;
            return 1;
        }
    }

    static {
    }

    public final String c() {
        Object r100 = this.f61085k.get("OPEN_APP_NAME");
        if ((r100 instanceof String) == true) goto L6;
        r100 = null;
    L6:
        return (String) r100;
    }

    public final u e() {
        Object r100 = this.f61085k.get("game");
        if ((r100 instanceof u) == true) goto L6;
        r100 = null;
    L6:
        return (u) r100;
    }

    public final String a() {
        u r100 = e();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.name;
    }

    public final String b(boolean r100) {
        if (r100 == false) goto L7;
        String r101 = a();
        if (r101 != null) goto L11;
        return "";
    L11:
        return r101;
    L7:
        r101 = c();
        if (r101 != null) goto L11;
        return "";
    }

    public final int d(boolean r100) {
        Object r101 = null;
        if (r100 == false) goto L13;
        Object r102 = this.f61085k.get("game");
        if ((r102 instanceof u) == false) goto L8;
        r101 = r102;
    L8:
        u r103 = (u) r101;
        if (r103 == null) goto L21;
        com.bytedance.android.live.broadcastgame.api.model.r r104 = r103.c();
        if (r104 != null) goto L23;
        return 0;
    L23:
        return r104.g();
    L21:
        return 0;
    L13:
        Object r105 = this.f61085k.get("business_type");
        if ((r105 instanceof Integer) == false) goto L17;
        r101 = r105;
    L17:
        Integer r106 = (Integer) r101;
        if (r106 != null) goto L20;
        return 0;
    L20:
        return r106.intValue();
    }

    public t(long r100, String r101, String r102, Map r103, String r104, PluginType r105) {
        Intrinsics.checkNotNullParameter(r101, "appId");
        Intrinsics.checkNotNullParameter(r102, "appVersion");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r104, "schemaUrl");
        Intrinsics.checkNotNullParameter(r105, "pluginType");
        this.f61082h = r100;
        this.f61083i = r101;
        this.f61084j = r102;
        this.f61085k = r103;
        this.f61086l = null;
        this.f61087m = null;
        this.f61088n = r104;
        this.f61089o = r105;
        this.f61090p = false;
        this.f61075a = -1;
        this.f61076b = "";
        Object r106 = r103.get("is_support_single_game_cast");
        Boolean r107 = Boolean.TRUE;
        this.f61080f = Intrinsics.areEqual(r106, r107);
        this.f61081g = Intrinsics.areEqual(r103.get("auto_cast_game"), r107);
    }
}

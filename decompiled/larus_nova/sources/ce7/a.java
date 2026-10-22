package ce7;

import android.net.Uri;
import com.bytedance.android.livesdkapi.monitor.ILiveHybridMonitor;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f23465a = 0;

    /* JADX INFO: renamed from: ce7.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0438a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f23466a = null;

        static {
            int[] r100 = new int[PlatformType.values().length];
            r100[PlatformType.LYNX.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[PlatformType.WEB.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[PlatformType.WORKER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f23466a = r100;
        }
    }

    static {
    }

    public static String a(PlatformType r100) {
        int r101 = C0438a.f23466a[r100.ordinal()];
        if (r101 != 1) goto L5;
        return "lynx";
    L5:
        if (r101 != 2) goto L7;
        return "webview";
    L7:
        if (r101 != 3) goto L10;
        return ErrorType.WORKER;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public static String c(String r100) {
        Uri r101 = UriProtector.parse(r100);     // Catch: Exception -> L7
        if (r101.isHierarchical() == true) goto L5;
        return r100;
    L5:
        return r101.buildUpon().clearQuery().build().toString();
    L10:
        return r100;
    }

    public static void b(JSONObject r100, le7.a r101) {
        String r102 = r101.f508962t;
        String r103 = "";
        if (r102 != null) goto L7;
        r102 = r101.d();
        if (r102 != null) goto L7;
        r102 = "";
    L7:
        String r104 = c(r102);
        c(r101.d());
        r100.put("bridge_name", r101.f508943a);
        if (r104 != null) goto L10;
        r104 = "";
    L10:
        r100.put("auth_url", r104);
        r100.put("fe_id", r101.f508959q);
        r100.put("auth_code", r101.f508967y);
        r100.put("method_auth_type", r101.f508968z);
        String r105 = r101.f508946d;
        if (r105 != null) goto L13;
    L15:
        if (r105 != null) goto L17;
        r105 = "unset";
    L17:
        r100.put("namespace", r105);
        r100.put("package_version", r101.f508964v);
        r100.put(ILiveHybridMonitor.BusinessParams.CONTAINER_TYPE, a(r101.c()));
        r100.put("auth_mode", r101.C);
        if ((r101 instanceof com.bytedance.sdk.xbridge.cn.platform.web.b) == false) goto L24;
        com.bytedance.sdk.xbridge.cn.platform.web.b r106 = (com.bytedance.sdk.xbridge.cn.platform.web.b) r101;
        r100.put("token_auth_mode", r106.T);
        if (r106.S.length() != 0) goto L22;
        boolean r107 = true;
    L23:
        r100.put("token_exist", !r107);
        r100.put("auth_url_type", r101.D);
        r100.put("frame_url", r106.P);
        r100.put("protocol_version", r106.R);
        r100.put("fe_auth_source", r101.G);
        goto L24
    L22:
        r107 = false;
    L24:
        JSONObject r108 = r101.E;
        if (r108 != null) goto L27;
        r108 = "";
    L27:
        r100.put("request_trackings", r108);
        String r109 = r101.f508962t;
        if (r109 == null) goto L33;
        String r110 = StringsKt.take(r109, 200);
        if (r110 == null) goto L33;
        r103 = r110;
    L33:
        r100.put("origin_auth_url", r103);
        r100.put("auth_config_source", r101.A);
        r100.put("fe_id_mapper", r101.f508960r);
        return;
    L13:
        if (Intrinsics.areEqual(r105, "") == false) goto L15;
        r105 = "host";
        goto L17
    }
}

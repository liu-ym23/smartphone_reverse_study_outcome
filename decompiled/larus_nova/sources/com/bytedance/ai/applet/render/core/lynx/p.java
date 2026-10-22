package com.bytedance.ai.applet.render.core.lynx;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.network.http.ServiceType;
import com.lynx.tasm.LynxView;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f35155a = 0;

    public static final class a {
        @JvmStatic
        public static void a(LynxView r100, String r101, String r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, "lynxView");
            Intrinsics.checkNotNullParameter(r101, "schema");
            Intrinsics.checkNotNullParameter("1.15.0-rc.7", com.heytap.mcssdk.constant.b.C);
            Uri r104 = UriProtector.parse(r101);     // Catch: Exception -> L31
            if (r102 != null) goto L10;
            r102 = UriProtector.getQueryParameter(r104, "channel");     // Catch: Exception -> L31
            if (r102 != null) goto L10;
            r102 = UriProtector.getQueryParameter(r104, "gecko_channel");     // Catch: Exception -> L31
            if (r102 != null) goto L10;
            r102 = UriProtector.getQueryParameter(r104, "packageName");     // Catch: Exception -> L31
        L10:
            if (r103 != null) goto L16;
            r103 = UriProtector.getQueryParameter(r104, "bundle");     // Catch: Exception -> L31
            if (r103 != null) goto L16;
            r103 = UriProtector.getQueryParameter(r104, "gecko_bundle");     // Catch: Exception -> L31
            if (r103 != null) goto L16;
            r103 = UriProtector.getQueryParameter(r104, "appId");     // Catch: Exception -> L31
        L16:
            if (r102 == null) goto L19;
            if (r103 == null) goto L19;
            String r105 = r102 + '/' + r103;     // Catch: Exception -> L31
        L20:
            Map r106 = MapsKt.mapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PAGE_ID, r105), TuplesKt.to("container_name", ServiceType.FIRST_PART), TuplesKt.to("container_sdk_version", "1.15.0-rc.7"), TuplesKt.to("schema", r101)});     // Catch: Exception -> L31
            LinkedHashMap r107 = new LinkedHashMap();     // Catch: Exception -> L31
            Iterator r108 = r106.entrySet().iterator();     // Catch: Exception -> L31
        L22:
            if (r108.hasNext() == false) goto L29;
            Map.Entry r109 = (Map.Entry) r108.next();     // Catch: Exception -> L31
            if (((String) r109.getValue()) == null) goto L26;
            boolean r110 = true;
        L27:
            if (r110 == false) goto L22;
            r107.put(r109.getKey(), r109.getValue());     // Catch: Exception -> L31
            goto L22
        L26:
            r110 = false;
            goto L27
        L29:
            r100.putParamsForReportingEvents(r107);     // Catch: Exception -> L31
            return;
        L19:
            r105 = r104.buildUpon().clearQuery().build().toString();     // Catch: Exception -> L31
        }
    }

    static {
    }
}

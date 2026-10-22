package com.bytedance.android.shopping.hybrid.bridges;

import android.content.Context;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.shopping.utils.gallery.k;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/hybrid/bridges/ECGalleryMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECGalleryMethod extends ECBaseBridgeMethod {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f176202e;

    public static final class a {
    }

    static {
    }

    public ECGalleryMethod() {
        this.f176202e = "ecGallery";
    }

    @Override // com.bytedance.android.ec.model.hybrid.IECBridgeMethod
    public final String getName() {
        return this.f176202e;
    }

    @Override // com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod
    public final void c(JSONObject r110, ECBaseBridgeMethod.a r111) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "iReturn");
        JSONObject r100 = r110.optJSONObject("data");
        if (r100 == null) goto L6;
        r110 = r100;
    L6:
        boolean r101 = false;
        int r102 = r110.optInt("index", 0);
        ArrayList r103 = new ArrayList();
        JSONArray r104 = r110.optJSONArray("images");     // Catch: JSONException -> L16
        if (r104 == null) goto L18;
        Iterator r105 = ((ArrayList) com.bytedance.android.shopping.hybrid.a.a(r104)).iterator();     // Catch: JSONException -> L16
    L11:
        if (r105.hasNext() == false) goto L18;
        Object r106 = r105.next();     // Catch: JSONException -> L16
        if ((r106 instanceof String) == false) goto L11;
        r103.add(r106);     // Catch: JSONException -> L16
    L18:
        ArrayList r107 = new ArrayList();
        JSONArray r108 = r110.optJSONArray("videos");     // Catch: JSONException -> L31
        if (r108 == null) goto L33;
        Iterator r109 = ((ArrayList) com.bytedance.android.shopping.hybrid.a.a(r108)).iterator();     // Catch: JSONException -> L31
    L23:
        if (r109.hasNext() == false) goto L33;
        Object r112 = r109.next();     // Catch: JSONException -> L31
        fj.d.a r113 = fj.d.f477433s;     // Catch: JSONException -> L31
        if ((r112 instanceof HashMap) == true) goto L27;
        r112 = null;
    L27:
        r113.getClass();     // Catch: JSONException -> L31
        fj.d r114 = fj.d.a.a((HashMap) r112);     // Catch: JSONException -> L31
        if (r114 == null) goto L23;
        r107.add(r114);     // Catch: JSONException -> L31
    L33:
        ArrayList r115 = new ArrayList();
        JSONArray r116 = r110.optJSONArray("titles");
        if (r116 == null) goto L41;
        Iterator r117 = ((ArrayList) com.bytedance.android.shopping.hybrid.a.a(r116)).iterator();
    L37:
        if (r117.hasNext() == false) goto L41;
        Object r118 = r117.next();
        if ((r118 instanceof String) == false) goto L37;
        r115.add(r118);
    L41:
        r110.optBoolean(BitableAnalytic.ProgressInputType.DRAG, true);
        r110.optBoolean("download", false);
        Context r119 = getContext();
        int r120 = -1;
        String r121 = "";
        if (r119 != null) goto L44;
    L54:
        JSONObject r122 = new JSONObject();
        r122.put("code", r120);
        if (r121.length() <= 0) goto L57;
        r101 = true;
    L57:
        if (r101 == false) goto L59;
        r122.put("error_msg", r121);
    L59:
        Unit r123 = Unit.INSTANCE;
        r111.a(r122);
        return;
    L44:
        if ((r107.size() + r103.size()) != 0) goto L47;
        int r124 = -1;
    L51:
        if (r124 >= 0) goto L53;
        r121 = "empty_source";
        goto L54
    L53:
        k.a(r119, r107, r103, r115, r124, false);
        r120 = 1;
        goto L54
    L47:
        if (r107.isEmpty() == false) goto L49;
        int r125 = Math.min(r102, r103.size() - 1);
    L50:
        r124 = r125;
        goto L51
    L49:
        r125 = Math.min(r102 + 1, r103.size());
    L31:
        e = move-exception;
        ECExceptionMonitor.f(e, "ECGalleryMethod video url parse error");
    L16:
        e = move-exception;
        ECExceptionMonitor.f(e, "ECGalleryMethod image url parse error");
        goto L18
    }
}

package c59;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.dynamic.dsl.DslActionType;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes27.dex */
public final class e implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f22507a;

    public e(b r100) {
        this.f22507a = r100;
    }

    @Override // c59.d
    public final boolean a(Context r110, CoroutineScope r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "lifecycleScope");
        int r112 = com.larus.dora.impl.util.h0.f338139a;
        b r113 = this.f22507a;
        if (r113 != null) goto L5;
        g49.d.b("ExternalRoute", "open action failed, action is null");
        return false;
    L5:
        String r100 = r113.e();
        if (r113.getType() != DslActionType.EXTERNAL_JUMP_BY_EXPLICIT_INTENT) goto L66;
        g49.d.d("ExternalRoute", "open by explicit intent, action: " + r113);
        Map<String, Object> r101 = r113.a();     // Catch: Exception -> L63
        String r102 = null;
        if (r101 == null) goto L12;
        Object r103 = r101.get("package_name");     // Catch: Exception -> L63
    L14:
        if ((r103 instanceof String) == false) goto L16;
        String r104 = (String) r103;     // Catch: Exception -> L63
    L17:
        Map<String, Object> r105 = r113.a();     // Catch: Exception -> L63
        if (r105 == null) goto L21;
        Object r106 = r105.get("class_name");     // Catch: Exception -> L63
    L23:
        if ((r106 instanceof String) == false) goto L25;
        r102 = (String) r106;     // Catch: Exception -> L63
    L25:
        g49.d.d("ExternalRoute", "open component, packageName: " + r104 + ", className: " + r102);     // Catch: Exception -> L63
        if (r104 != null) goto L28;
    L31:
        boolean r107 = true;
    L32:
        if (r107 == true) goto L87;
        if (r102 != null) goto L35;
    L38:
        boolean r108 = true;
    L39:
        if (r108 == true) goto L88;
        Intent r109 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);     // Catch: Exception -> L63
        r109.addFlags(335544320);     // Catch: Exception -> L63
        r109.setComponent(new ComponentName(r104, r102));     // Catch: Exception -> L63
        r109.setPackage(r104);     // Catch: Exception -> L63
        Iterator<Map.Entry<String, Object>> r114 = r113.a().entrySet().iterator();     // Catch: Exception -> L63
    L43:
        if (r114.hasNext() == false) goto L61;
        Map.Entry<String, Object> r115 = r114.next();     // Catch: Exception -> L63
        String r116 = r115.getKey();     // Catch: Exception -> L63
        Object r117 = r115.getValue();     // Catch: Exception -> L63
        if (Intrinsics.areEqual(r116, "package_name") == true) goto L43;
        if (Intrinsics.areEqual(r116, "class_name") == true) goto L43;
        g49.d.d("ExternalRoute", "put extra, key: " + r116 + ", value: " + r117);     // Catch: Exception -> L63
        if ((r117 instanceof String) == true) goto L60;
        if ((r117 instanceof Integer) == true) goto L60;
        if ((r117 instanceof Long) == true) goto L60;
        if ((r117 instanceof Boolean) == true) goto L60;
        if ((r117 instanceof Float) == true) goto L60;
        if ((r117 instanceof Double) == false) goto L43;
    L60:
        r109.putExtra(r116, (Serializable) r117);     // Catch: Exception -> L63
        goto L43
    L61:
        AppHost.f326268a.getApplication().startActivity(r109);     // Catch: Exception -> L63
        g49.d.d("ExternalRoute", "open component success, packageName: " + r104 + ", className: " + r102);     // Catch: Exception -> L63
        return true;
    L88:
        return false;
    L35:
        if (r102.length() == 0) goto L38;
        r108 = false;
        goto L39
    L87:
        return false;
    L28:
        if (r104.length() == 0) goto L31;
        r107 = false;
        goto L32
    L21:
        r106 = null;
        goto L23
    L16:
        r104 = null;
        goto L17
    L12:
        r103 = null;
    L63:
        e = move-exception;
        g49.d.b("ExternalRoute", "open component failed, e: " + e.getMessage());
        return false;
    L66:
        if (r113.getType() != DslActionType.EXTERNAL_JUMP) goto L68;
        g49.d.d("ExternalRoute", "open schema, schema: " + r100);
        return com.larus.dora.impl.util.h0.b(r100);
    L68:
        g49.d.b("ExternalRoute", "open action failed, unknown action type, action: " + r113);
        return false;
    }
}

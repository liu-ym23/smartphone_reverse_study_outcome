package bo2;

import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class e implements c {
    public e() {
    }

    @Override // bo2.c
    public final void a(PolarisFileWrapper r100, ff7.e r110) {
        Intrinsics.checkNotNullParameter(r100, "file");
        Intrinsics.checkNotNullParameter(r110, "callback");
        IHostContext r101 = (IHostContext) jc1.k.f(IHostContext.class);
        if (r101 != null) goto L6;
        r100.delete();
        r110.onFail("hostContext is null");
        return;
    L6:
        String r102 = r101.getServerDeviceId();
        if (r102 != null) goto L9;
    L12:
        boolean r103 = true;
    L13:
        if (r103 == false) goto L16;
        r100.delete();
        r110.onFail("did is null");
        return;
    L16:
        int r104 = r101.appId();
        r100.getName();
        JSONObject r105 = new JSONObject();
        Map<String, String> r106 = com.bytedance.apm.d.g();
        if (r106 == null) goto L22;
        Iterator<Map.Entry<String, String>> r107 = r106.entrySet().iterator();
    L20:
        if (r107.hasNext() == false) goto L22;
        Map.Entry<String, String> r108 = r107.next();
        r105.put(r108.getKey(), r108.getValue());
    L22:
        new xs3.a().c(String.valueOf(r104), r102, "live_hprof_dump", CollectionsKt.listOf(r100.getAbsolutePath()), "dump.hprof", r105, r110);
        return;
    L9:
        if (r102.length() == 0) goto L12;
        r103 = false;
        goto L13
    }
}

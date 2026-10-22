package z5;

import com.stepos.agentcache.core.ServiceContract;
import java.util.Map;
import q7.k;

/* loaded from: classes.dex */
public final class f implements e {

    /* renamed from: f, reason: collision with root package name */
    public static final f f11814f = new f();

    @Override // z5.e
    public final void e(String str, String str2, h hVar, String str3, String str4, String str5, int i2) {
        k.e(str, ServiceContract.RequiredKeys.TRACE_ID);
        k.e(str2, ServiceContract.RequiredKeys.NODE_NAME);
        k.e(hVar, "level");
        k.e(str3, "event");
        k.e(str4, "log");
    }

    @Override // z5.e
    public final void h(String str, String str2, Map map, Map map2, String str3, String str4, int i2) {
        k.e(str, ServiceContract.RequiredKeys.TRACE_ID);
        k.e(str2, ServiceContract.RequiredKeys.NODE_NAME);
        k.e(map, "commonFields");
        k.e(map2, "bizData");
        k.e(str3, "inputText");
        k.e(str4, "outputText");
    }
}

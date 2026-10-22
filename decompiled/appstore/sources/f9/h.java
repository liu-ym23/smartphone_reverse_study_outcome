package f9;

import android.content.Context;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.ttnet.TTNetInit;
import com.bytedanceos.common.BaseApplication;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NetworkParams.ApiProcessHook f19546a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final NetworkParams.MonitorProcessHook f19547b = null;

    public class a implements NetworkParams.ApiProcessHook {
        public a() {
        }

        public void a(String r10, Throwable r11, long r12, p6.b r13) {
        }

        @Override // com.bytedance.frameworks.baselib.network.http.NetworkParams.ApiProcessHook
        public String addCommonParams(String r10, boolean r11) {
            return r10;
        }

        @Override // com.bytedance.frameworks.baselib.network.http.NetworkParams.ApiProcessHook
        public String addRequestVertifyParams(String r10, boolean r11, Object... r12) {
            return r10;
        }

        public void b(String r10, long r11, p6.b r12) {
        }

        @Override // com.bytedance.frameworks.baselib.network.http.NetworkParams.ApiProcessHook
        public Map getCommonParamsByLevel(int r10) {
            return new HashMap();
        }

        @Override // com.bytedance.frameworks.baselib.network.http.NetworkParams.ApiProcessHook
        public /* bridge */ /* synthetic */ void handleApiError(String r10, Throwable r11, long r12, BaseHttpRequestInfo r13) {
            a(r10, r11, r12, (p6.b) r13);
        }

        @Override // com.bytedance.frameworks.baselib.network.http.NetworkParams.ApiProcessHook
        public /* bridge */ /* synthetic */ void handleApiOk(String r10, long r11, BaseHttpRequestInfo r12) {
            b(r10, r11, (p6.b) r12);
        }

        @Override // com.bytedance.frameworks.baselib.network.http.NetworkParams.ApiProcessHook
        public void onTryInit() {
        }

        @Override // com.bytedance.frameworks.baselib.network.http.NetworkParams.ApiProcessHook
        public void putCommonParams(Map r10, boolean r11) {
        }
    }

    static {
        f19546a = new a();
        f19547b = new e();
    }

    public static void a(Context r10) {
        TTNetInit.setTTNetDepend(g.a());
        TTNetInit.tryInitTTNet(r10, BaseApplication.c(), f19546a, f19547b, null, true, new boolean[0]);     // Catch: RuntimeException -> L5
        return;
    L5:
        e = move-exception;
        re.a.l("TTNetHelper", e.fillInStackTrace());
    }
}

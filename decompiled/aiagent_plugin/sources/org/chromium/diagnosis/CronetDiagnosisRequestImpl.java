package org.chromium.diagnosis;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.reflect.Reflect;
import com.ttnet.org.chromium.net.ac;
import com.ttnet.org.chromium.net.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import org.chromium.CronetClient;

/* JADX INFO: loaded from: classes5.dex */
public class CronetDiagnosisRequestImpl implements com.bytedance.frameworks.baselib.network.http.cronet.a.a {
    private static final String TAG = "CronetDiagnosisRequestImpl";
    private static final String TTNET_INIT_CLASS = "com.bytedance.ttnet.TTNetInit";
    private static d sCronetEngine;
    private com.bytedance.frameworks.baselib.network.http.cronet.a.a.InterfaceC0185a mCallback;
    private a mCronetCallback;
    private ac mRequest;

    class a implements ac.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CronetDiagnosisRequestImpl f40532a;

        a(CronetDiagnosisRequestImpl r1) {
            this.f40532a = r1;
        }

        @Override // com.ttnet.org.chromium.net.ac.b
        public void a(ac r1, String r2) {
            CronetDiagnosisRequestImpl.access$000(this.f40532a).a(r2);
        }
    }

    static {
    }

    static /* synthetic */ com.bytedance.frameworks.baselib.network.http.cronet.a.a.InterfaceC0185a access$000(CronetDiagnosisRequestImpl r0) {
        return r0.mCallback;
    }

    public CronetDiagnosisRequestImpl(com.bytedance.frameworks.baselib.network.http.cronet.a.a.InterfaceC0185a r3, int r4, List<String> r5, int r6, int r7, int r8) {
        com.bytedance.frameworks.baselib.network.http.cronet.a.a.InterfaceC0185a r9 = (com.bytedance.frameworks.baselib.network.http.cronet.a.a.InterfaceC0185a) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.frameworks.baselib.network.http.cronet.a.a.InterfaceC0185a.class, "com.obric.aiagent.plugin");
        List<String> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        this.mRequest = null;
        this.mCronetCallback = new a(this);
        this.mCallback = r9;
        if (sCronetEngine != null) goto L5;
        sCronetEngine = getCronetEngine();
    L5:
        d r11 = sCronetEngine;
        if (r11 == null) goto L10;
        ac.a r12 = r11.a(this.mCronetCallback, null);
        r12.a(r4).a(r10).b(r6).c(r7).d(r8);
        this.mRequest = r12.a();
        return;
    L10:
        throw new UnsupportedOperationException("Can not get cronet engine.");
    }

    private d getCronetEngine() {
        if (Logger.debug() == false) goto L13;
        Logger.d(TAG, "Init cronet engine");
    L13:
        loadCronetKernel();     // Catch: Throwable -> L7
    L12:
        return CronetClient.getCronetEngine();
    L7:
        th = move-exception;
        th.printStackTrace();
        if (Logger.debug() == false) goto L12;
        Logger.d(TAG, "TTNet init failed, cronet engine is null.");
        goto L12
    }

    private static void loadCronetKernel() {
        Reflect.on(ZeusTransformUtils.forName(TTNET_INIT_CLASS, "com.obric.aiagent.plugin").newInstance()).call("preInitCronetKernel");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.a.a
    public void start() {
        ac r0 = this.mRequest;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.a.a
    public void cancel() {
        ac r0 = this.mRequest;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.a.a
    public void doExtraCommand(String r1, String r2) {
        ac r0 = this.mRequest;
        if (r0 == null) goto L6;
        r0.a(r1, r2);
        return;
    }
}

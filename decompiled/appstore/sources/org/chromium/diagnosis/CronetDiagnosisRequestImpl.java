package org.chromium.diagnosis;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.frameworks.baselib.network.http.cronet.diagnosis.ICronetDiagnosisRequest;
import com.bytedance.ttnet.TTNetInit;
import com.ttnet.org.chromium.net.TTNetDiagnosisRequest;
import com.ttnet.org.chromium.net.c;
import java.util.List;
import org.chromium.CronetClient;

/* JADX INFO: loaded from: classes4.dex */
public class CronetDiagnosisRequestImpl implements ICronetDiagnosisRequest {
    private static final String TAG = "CronetDiagnosisRequestImpl";
    private static final String TTNET_INIT_CLASS = "com.bytedance.ttnet.TTNetInit";
    private static c sCronetEngine;
    private ICronetDiagnosisRequest.Callback mCallback;
    private a mCronetCallback;
    private TTNetDiagnosisRequest mRequest;

    public class a implements TTNetDiagnosisRequest.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CronetDiagnosisRequestImpl f23042a;

        public a(CronetDiagnosisRequestImpl r10) {
            this.f23042a = r10;
        }

        @Override // com.ttnet.org.chromium.net.TTNetDiagnosisRequest.Callback
        public void onNetDiagnosisRequestComplete(TTNetDiagnosisRequest r10, String r11) {
            CronetDiagnosisRequestImpl.access$000(this.f23042a).onNetDiagnosisRequestComplete(r11);
        }
    }

    static {
    }

    public CronetDiagnosisRequestImpl(ICronetDiagnosisRequest.Callback r10, int r11, List<String> r12, int r13, int r14) throws Exception {
        this.mRequest = null;
        this.mCronetCallback = new a(this);
        this.mCallback = r10;
        if (sCronetEngine != null) goto L5;
        sCronetEngine = getCronetEngine();
    L5:
        c r15 = sCronetEngine;
        if (r15 == null) goto L11;
        if (r15 == null) goto L12;
        TTNetDiagnosisRequest.a r16 = r15.b(this.mCronetCallback, null);
        r16.c(r11).d(r12).b(r13).e(r14);
        this.mRequest = r16.a();
        return;
    L12:
        return;
    L11:
        throw new UnsupportedOperationException("Can not get cronet engine.");
    }

    public static /* synthetic */ ICronetDiagnosisRequest.Callback access$000(CronetDiagnosisRequestImpl r10) {
        return r10.mCallback;
    }

    private c getCronetEngine() {
        Logger.d(TAG, "Init cronet engine");
        loadCronetKernel();     // Catch: Throwable -> L5
    L8:
        return CronetClient.getCronetEngine();
    L5:
        th = move-exception;
        th.printStackTrace();
        Logger.d(TAG, "TTNet init failed, cronet engine is null.");
        goto L8
    }

    private static void loadCronetKernel() throws Exception {
        String r10 = TTNetInit.DOMAIN_HTTPDNS_KEY;
        Reflect.on(TTNetInit.class.newInstance()).call("preInitCronetKernel");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.diagnosis.ICronetDiagnosisRequest
    public void cancel() {
        TTNetDiagnosisRequest r10 = this.mRequest;
        if (r10 == null) goto L6;
        r10.a();
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.diagnosis.ICronetDiagnosisRequest
    public void doExtraCommand(String r10, String r11) {
        TTNetDiagnosisRequest r12 = this.mRequest;
        if (r12 == null) goto L6;
        r12.b(r10, r11);
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.diagnosis.ICronetDiagnosisRequest
    public void start() {
        TTNetDiagnosisRequest r10 = this.mRequest;
        if (r10 == null) goto L6;
        r10.c();
        return;
    }
}

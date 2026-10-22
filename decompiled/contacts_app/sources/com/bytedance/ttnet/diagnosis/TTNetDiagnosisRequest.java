package com.bytedance.ttnet.diagnosis;

import com.bytedance.frameworks.baselib.network.http.cronet.diagnosis.ICronetDiagnosisRequest;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class TTNetDiagnosisRequest implements IDiagnosisRequest {
    private static final String CRONET_DIAGNOSIS_REQUEST_IMPL_CLASS = "org.chromium.diagnosis.CronetDiagnosisRequestImpl";
    private static final String TAG = "TTNetDiagnosisRequest";
    private IDiagnosisCallback mCallback;
    private boolean mCanceled;
    private ICronetDiagnosisRequest mCronetDiagnosisRequest;
    private ICronetDiagnosisRequest.Callback mCronetDiagnosisRequestCallback;
    private String mExtraInfo;
    private int mMultiNetAction;
    private int mNetDetectType;
    private int mReqType;
    private boolean mStarted;
    private List<String> mTargets;
    private int mTimeoutMs;

    class CallbackImpl implements ICronetDiagnosisRequest.Callback {
        final /* synthetic */ TTNetDiagnosisRequest this$0;

        CallbackImpl(TTNetDiagnosisRequest r1) {
            this.this$0 = r1;
        }

        @Override // com.bytedance.frameworks.baselib.network.http.cronet.diagnosis.ICronetDiagnosisRequest.Callback
        public void onNetDiagnosisRequestComplete(String r2) {
            if (TTNetDiagnosisRequest.access$000(this.this$0) == null) goto L6;
            TTNetDiagnosisRequest.access$000(this.this$0).onDiagnosisComplete(r2);
            return;
        }
    }

    static {
    }

    static /* synthetic */ IDiagnosisCallback access$000(TTNetDiagnosisRequest r0) {
        return r0.mCallback;
    }

    public TTNetDiagnosisRequest(int r2, List<String> r3, int r4, int r5, int r6) throws Exception {
        this.mCronetDiagnosisRequestCallback = new CallbackImpl(this);
        this.mStarted = false;
        this.mCanceled = false;
        this.mReqType = r2;
        this.mTargets = r3;
        this.mNetDetectType = r4;
        this.mMultiNetAction = r5;
        this.mTimeoutMs = r6;
        tryResolveCronetDiagnosisRequest();
    }

    private void tryResolveCronetDiagnosisRequest() throws Exception {
        if (this.mCronetDiagnosisRequest != null) goto L11;
        Class<?> r0 = checkClass(CRONET_DIAGNOSIS_REQUEST_IMPL_CLASS);
        if (r0 == null) goto L10;
        Object r1 = r0.getDeclaredConstructor(new Class[]{ICronetDiagnosisRequest.Callback.class, Integer.TYPE, List.class, Integer.TYPE, Integer.TYPE, Integer.TYPE}).newInstance(new Object[]{this.mCronetDiagnosisRequestCallback, Integer.valueOf(this.mReqType), this.mTargets, Integer.valueOf(this.mNetDetectType), Integer.valueOf(this.mMultiNetAction), Integer.valueOf(this.mTimeoutMs)});
        if ((r1 instanceof ICronetDiagnosisRequest) == false) goto L12;
        this.mCronetDiagnosisRequest = (ICronetDiagnosisRequest) r1;
        return;
    L12:
        return;
    L10:
        throw new ClassNotFoundException("org.chromium.diagnosis.CronetDiagnosisRequestImpl class not found");
    }

    private Class<?> checkClass(String r1) {
        return Class.forName(r1);
    L4:
        return null;
    }

    @Override // com.bytedance.ttnet.diagnosis.IDiagnosisRequest
    public void start(IDiagnosisCallback r2) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.mStarted == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    L7:
        this.mCallback = r2;     // Catch: Throwable -> L14
        this.mCronetDiagnosisRequest.start();     // Catch: Throwable -> L14
        this.mStarted = true;     // Catch: Throwable -> L14
        String r3 = this.mExtraInfo;     // Catch: Throwable -> L14
        if (r3 != null) goto L10;
    L12:
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    L10:
        if (r3.isEmpty() == true) goto L12;
        doExtraCommand("extra_info", this.mExtraInfo);     // Catch: Throwable -> L14
        goto L12
    }

    @Override // com.bytedance.ttnet.diagnosis.IDiagnosisRequest
    public void cancel() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.mStarted == true) goto L6;
    L11:
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L6:
        if (this.mCanceled == true) goto L11;
        this.mCronetDiagnosisRequest.cancel();     // Catch: Throwable -> L13
        this.mCanceled = true;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
    }

    @Override // com.bytedance.ttnet.diagnosis.IDiagnosisRequest
    public void doExtraCommand(String r2, String r3) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.mStarted == true) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L7:
        this.mCronetDiagnosisRequest.doExtraCommand(r2, r3);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
    }

    @Override // com.bytedance.ttnet.diagnosis.IDiagnosisRequest
    public void setUserExtraInfo(String r2) {
        monitor-enter(this);
        this.mExtraInfo = r2;     // Catch: Throwable -> L6
        doExtraCommand("extra_info", r2);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }
}

package com.bytedance.ttnet.diagnosis;

import com.bytedance.common.utility.Logger;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes.dex */
public class TTGameDiagnosisService {
    private static final String TAG = "TTGameDiagnosisService";
    private static volatile TTGameDiagnosisService sInstance;
    private volatile boolean mIsMonitoring;
    private IDiagnosisRequest mRequest;

    public class a implements IDiagnosisCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TTGameDiagnosisService f8154a;

        public a(TTGameDiagnosisService r10) {
            this.f8154a = r10;
        }

        @Override // com.bytedance.ttnet.diagnosis.IDiagnosisCallback
        public void onDiagnosisComplete(String r10) {
            if (Logger.debug() == false) goto L6;
            Logger.d(TTGameDiagnosisService.access$000(), "onDiagnosisComplete: " + r10);
            return;
        }
    }

    static {
    }

    private TTGameDiagnosisService() {
        this.mRequest = null;
        this.mIsMonitoring = false;
    }

    public static /* synthetic */ String access$000() {
        return TAG;
    }

    public static TTGameDiagnosisService inst() {
        if (sInstance != null) goto L16;
        monitor-enter(TTGameDiagnosisService.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L11;
        sInstance = new TTGameDiagnosisService();     // Catch: Throwable -> L9
    L11:
        monitor-exit(TTGameDiagnosisService.class);     // Catch: Throwable -> L9
    L16:
        return sInstance;
    }

    public void doDiagnosisDuringGaming(String r10) {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsMonitoring == true) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L9:
        this.mRequest.doExtraCommand("diagnosis", r10);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
    }

    public boolean isMonitoring() {
        return this.mIsMonitoring;
    }

    public void monitorBegin(String r10, String r11) throws Exception {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsMonitoring == false) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L9:
        IDiagnosisRequest r12 = TTNetDiagnosisService.createRequest(4, r10, 0, Channel.UNLIMITED);     // Catch: Throwable -> L7
        this.mRequest = r12;     // Catch: Throwable -> L7
        r12.start(new a(this));     // Catch: Throwable -> L7
        this.mRequest.doExtraCommand("extra_info", r11);     // Catch: Throwable -> L7
        this.mIsMonitoring = true;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
    }

    public void monitorEnd() {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsMonitoring == true) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L9:
        this.mRequest.doExtraCommand("finish", "");     // Catch: Throwable -> L7
        this.mIsMonitoring = false;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
    }
}

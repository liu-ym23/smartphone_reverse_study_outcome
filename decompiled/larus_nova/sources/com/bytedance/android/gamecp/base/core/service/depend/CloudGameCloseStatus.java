package com.bytedance.android.gamecp.base.core.service.depend;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/gamecp/base/core/service/depend/CloudGameCloseStatus;", "", "", "status", "I", "getStatus", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "FAIL", "SUCCESS", "TRIAL_TIME_OUT", "USER_STOP", "FORCE_STOP", "FAIL_INIT", "FAIL_EVENT_STOP", "gamecp-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CloudGameCloseStatus extends Enum<CloudGameCloseStatus> {
    public static final a Companion = null;
    public static final CloudGameCloseStatus FAIL = null;
    public static final CloudGameCloseStatus FAIL_EVENT_STOP = null;
    public static final CloudGameCloseStatus FAIL_INIT = null;
    public static final CloudGameCloseStatus FORCE_STOP = null;
    public static final CloudGameCloseStatus SUCCESS = null;
    public static final CloudGameCloseStatus TRIAL_TIME_OUT = null;
    public static final CloudGameCloseStatus USER_STOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CloudGameCloseStatus[] f51401a = null;
    private final int status;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.gamecp.base.core.service.depend.CloudGameCloseStatus$a] */
    static {
        CloudGameCloseStatus r100 = new CloudGameCloseStatus("FAIL", 0, 0);
        FAIL = r100;
        CloudGameCloseStatus r101 = new CloudGameCloseStatus("SUCCESS", 1, 1);
        SUCCESS = r101;
        CloudGameCloseStatus r102 = new CloudGameCloseStatus("TRIAL_TIME_OUT", 2, 2);
        TRIAL_TIME_OUT = r102;
        CloudGameCloseStatus r103 = new CloudGameCloseStatus("USER_STOP", 3, 3);
        USER_STOP = r103;
        CloudGameCloseStatus r104 = new CloudGameCloseStatus("FORCE_STOP", 4, 4);
        FORCE_STOP = r104;
        CloudGameCloseStatus r105 = new CloudGameCloseStatus("FAIL_INIT", 5, 5);
        FAIL_INIT = r105;
        CloudGameCloseStatus r106 = new CloudGameCloseStatus("FAIL_EVENT_STOP", 6, 6);
        FAIL_EVENT_STOP = r106;
        f51401a = new CloudGameCloseStatus[]{r100, r101, r102, r103, r104, r105, r106};
        Companion = new a();
    }

    public static CloudGameCloseStatus valueOf(String r100) {
        return (CloudGameCloseStatus) r27.a.a(CloudGameCloseStatus.class, r100);
    }

    public static CloudGameCloseStatus[] values() {
        return (CloudGameCloseStatus[]) f51401a.clone();
    }

    public final int getStatus() {
        return this.status;
    }

    public CloudGameCloseStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.status = r102;
    }
}

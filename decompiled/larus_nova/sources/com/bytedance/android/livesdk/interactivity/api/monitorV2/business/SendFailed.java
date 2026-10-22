package com.bytedance.android.livesdk.interactivity.api.monitorV2.business;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/monitorV2/business/SendFailed;", "", "", "reason", "Ljava/lang/String;", "getReason", "()Ljava/lang/String;", "NotLogin", "TeenagerProtect", "Overlength", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SendFailed extends Enum<SendFailed> {
    public static final SendFailed NotLogin = null;
    public static final SendFailed Overlength = null;
    public static final SendFailed TeenagerProtect = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SendFailed[] f133354a = null;
    private final String reason;

    static {
        SendFailed r100 = new SendFailed("NotLogin", 0, "not_login");
        NotLogin = r100;
        SendFailed r101 = new SendFailed("TeenagerProtect", 1, "teenager_protect");
        TeenagerProtect = r101;
        SendFailed r102 = new SendFailed("Overlength", 2, "danmaku_overlength");
        Overlength = r102;
        f133354a = new SendFailed[]{r100, r101, r102};
    }

    public static SendFailed valueOf(String r100) {
        return (SendFailed) a.a(SendFailed.class, r100);
    }

    public static SendFailed[] values() {
        return (SendFailed[]) f133354a.clone();
    }

    public final String getReason() {
        return this.reason;
    }

    public SendFailed(String r100, int r101, String r102) {
        super(r100, r101);
        this.reason = r102;
    }
}

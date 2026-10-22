package com.bytedance.android.annie.bridge.method;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/OpenActionStatus;", "", "BEFORE_OPEN", "AFTER_OPEN", "annie_release"}, k = 1, mv = {1, 4, 3})
public final enum OpenActionStatus extends Enum<OpenActionStatus> {
    public static final OpenActionStatus AFTER_OPEN = null;
    public static final OpenActionStatus BEFORE_OPEN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OpenActionStatus[] f38467a = null;

    public static OpenActionStatus valueOf(String r100) {
        return (OpenActionStatus) r27.a.a(OpenActionStatus.class, r100);
    }

    public static OpenActionStatus[] values() {
        return (OpenActionStatus[]) f38467a.clone();
    }

    static {
        OpenActionStatus r100 = new OpenActionStatus("BEFORE_OPEN", 0);
        BEFORE_OPEN = r100;
        OpenActionStatus r101 = new OpenActionStatus("AFTER_OPEN", 1);
        AFTER_OPEN = r101;
        f38467a = new OpenActionStatus[]{r100, r101};
    }

    public OpenActionStatus(String r100, int r101) {
        super(r100, r101);
    }
}

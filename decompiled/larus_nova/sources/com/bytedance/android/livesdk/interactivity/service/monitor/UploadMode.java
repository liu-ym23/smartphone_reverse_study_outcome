package com.bytedance.android.livesdk.interactivity.service.monitor;

import com.bytedance.apm.constant.UploadTypeInf;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/service/monitor/UploadMode;", "", "", "mode", "Ljava/lang/String;", "getMode", "()Ljava/lang/String;", "ROOM_QUIT", "LOOP", "TIMER", "IMMEDIATE", "community-service_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum UploadMode extends Enum<UploadMode> {
    public static final UploadMode IMMEDIATE = null;
    public static final UploadMode LOOP = null;
    public static final UploadMode ROOM_QUIT = null;
    public static final UploadMode TIMER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UploadMode[] f140932a = null;
    private final String mode;

    static {
        UploadMode r100 = new UploadMode("ROOM_QUIT", 0, "quit");
        ROOM_QUIT = r100;
        UploadMode r101 = new UploadMode("LOOP", 1, "loop");
        LOOP = r101;
        UploadMode r102 = new UploadMode("TIMER", 2, UploadTypeInf.TIMER);
        TIMER = r102;
        UploadMode r103 = new UploadMode("IMMEDIATE", 3, "immediate");
        IMMEDIATE = r103;
        f140932a = new UploadMode[]{r100, r101, r102, r103};
    }

    public static UploadMode valueOf(String r100) {
        return (UploadMode) r27.a.a(UploadMode.class, r100);
    }

    public static UploadMode[] values() {
        return (UploadMode[]) f140932a.clone();
    }

    public final String getMode() {
        return this.mode;
    }

    public UploadMode(String r100, int r101, String r102) {
        super(r100, r101);
        this.mode = r102;
    }
}

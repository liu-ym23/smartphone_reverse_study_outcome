package kotlin.reflect.jvm.internal.impl.types.model;

import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class CaptureStatus {

    /* renamed from: a, reason: collision with root package name */
    public static final CaptureStatus f5164a;
    public static final /* synthetic */ CaptureStatus[] b;

    static {
        CaptureStatus captureStatus = new CaptureStatus("FOR_SUBTYPING", 0);
        f5164a = captureStatus;
        CaptureStatus[] captureStatusArr = {captureStatus, new CaptureStatus("FOR_INCORPORATION", 1), new CaptureStatus("FROM_EXPRESSION", 2)};
        b = captureStatusArr;
        a.a(captureStatusArr);
    }

    public static CaptureStatus valueOf(String str) {
        return (CaptureStatus) Enum.valueOf(CaptureStatus.class, str);
    }

    public static CaptureStatus[] values() {
        return (CaptureStatus[]) b.clone();
    }
}

package com.bytedance.android.livesdk.gift.platform.core.utils.recorder;

import com.byted.cast.common.api.IPlayerListener;
import com.byted.cast.sdk.RTCEngine;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/utils/recorder/ErrorNo;", "", "", "errCode", "I", "getErrCode", "()I", "setErrCode", "(I)V", "NORMAL_ERROR", "POLICY_ERROR", "CONSUME_TIMEOUT", "OBJECT_NULL", "NO_CONSUMER", "RESOURCE_ERROR", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ErrorNo extends Enum<ErrorNo> {
    public static final ErrorNo CONSUME_TIMEOUT = null;
    public static final ErrorNo NORMAL_ERROR = null;
    public static final ErrorNo NO_CONSUMER = null;
    public static final ErrorNo OBJECT_NULL = null;
    public static final ErrorNo POLICY_ERROR = null;
    public static final ErrorNo RESOURCE_ERROR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ErrorNo[] f132065a = null;
    private int errCode;

    static {
        ErrorNo r100 = new ErrorNo("NORMAL_ERROR", 0, IPlayerListener.CONFERENCE_PINCODE_CONVERTTODEV_ERROR);
        NORMAL_ERROR = r100;
        ErrorNo r101 = new ErrorNo("POLICY_ERROR", 1, 300002);
        POLICY_ERROR = r101;
        ErrorNo r102 = new ErrorNo("CONSUME_TIMEOUT", 2, 400001);
        CONSUME_TIMEOUT = r102;
        ErrorNo r103 = new ErrorNo("OBJECT_NULL", 3, 400002);
        OBJECT_NULL = r103;
        ErrorNo r104 = new ErrorNo("NO_CONSUMER", 4, RTCEngine.INFO_SET_BITRATE_KPS);
        NO_CONSUMER = r104;
        ErrorNo r105 = new ErrorNo("RESOURCE_ERROR", 5, 400004);
        RESOURCE_ERROR = r105;
        f132065a = new ErrorNo[]{r100, r101, r102, r103, r104, r105};
    }

    public static ErrorNo valueOf(String r100) {
        return (ErrorNo) r27.a.a(ErrorNo.class, r100);
    }

    public static ErrorNo[] values() {
        return (ErrorNo[]) f132065a.clone();
    }

    public final int getErrCode() {
        return this.errCode;
    }

    public final void setErrCode(int r100) {
        this.errCode = r100;
    }

    public ErrorNo(String r100, int r101, int r102) {
        super(r100, r101);
        this.errCode = r102;
    }
}

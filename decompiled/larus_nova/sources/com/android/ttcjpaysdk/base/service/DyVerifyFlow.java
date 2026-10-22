package com.android.ttcjpaysdk.base.service;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/DyVerifyFlow;", "", "value", "", "label", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getLabel", "()Ljava/lang/String;", "getValue", "PASSWORD", "LIVEDETECT", "MSG", "POPUP", "THREEDS", "MSGBLOCK", "MSGUNBLOCK", "BIO", "CERT", "DEFAULTALERT", "TIMEOUTALERT", "VOICE", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum DyVerifyFlow extends Enum<DyVerifyFlow> {
    private static final /* synthetic */ DyVerifyFlow[] $VALUES = null;
    public static final DyVerifyFlow BIO = null;
    public static final DyVerifyFlow CERT = null;
    public static final DyVerifyFlow DEFAULTALERT = null;
    public static final DyVerifyFlow LIVEDETECT = null;
    public static final DyVerifyFlow MSG = null;
    public static final DyVerifyFlow MSGBLOCK = null;
    public static final DyVerifyFlow MSGUNBLOCK = null;
    public static final DyVerifyFlow PASSWORD = null;
    public static final DyVerifyFlow POPUP = null;
    public static final DyVerifyFlow THREEDS = null;
    public static final DyVerifyFlow TIMEOUTALERT = null;
    public static final DyVerifyFlow VOICE = null;
    private final String label;
    private final String value;

    private static final /* synthetic */ DyVerifyFlow[] $values() {
        return new DyVerifyFlow[]{PASSWORD, LIVEDETECT, MSG, POPUP, THREEDS, MSGBLOCK, MSGUNBLOCK, BIO, CERT, DEFAULTALERT, TIMEOUTALERT, VOICE};
    }

    public static DyVerifyFlow valueOf(String r100) {
        return (DyVerifyFlow) a.a(DyVerifyFlow.class, r100);
    }

    public static DyVerifyFlow[] values() {
        return (DyVerifyFlow[]) $VALUES.clone();
    }

    static {
        PASSWORD = new DyVerifyFlow("PASSWORD", 0, "PASSWORD", "密码");
        LIVEDETECT = new DyVerifyFlow("LIVEDETECT", 1, "LIVEDETECT", "人脸");
        MSG = new DyVerifyFlow("MSG", 2, "MSG", "短信");
        POPUP = new DyVerifyFlow("POPUP", 3, "POPUP", "弹窗");
        THREEDS = new DyVerifyFlow("THREEDS", 4, "THREEDS", "3DS");
        MSGBLOCK = new DyVerifyFlow("MSGBLOCK", 5, "MSGBLOCK", "拦截弹窗");
        MSGUNBLOCK = new DyVerifyFlow("MSGUNBLOCK", 6, "MSGUNBLOCK", "解脱弹窗");
        BIO = new DyVerifyFlow("BIO", 7, "BIO", "指纹");
        CERT = new DyVerifyFlow("CERT", 8, "CERT", "数字证书");
        DEFAULTALERT = new DyVerifyFlow("DEFAULTALERT", 9, "DEFAULTALERT", "反诈弹窗");
        TIMEOUTALERT = new DyVerifyFlow("TIMEOUTALERT", 10, "TIMEOUTALERT", "倒计时反诈弹窗");
        VOICE = new DyVerifyFlow("VOICE", 11, "VOICE", "声纹");
        $VALUES = $values();
    }

    public final String getLabel() {
        return this.label;
    }

    public final String getValue() {
        return this.value;
    }

    private DyVerifyFlow(String r100, int r101, String r102, String r103) {
        super(r100, r101);
        this.value = r102;
        this.label = r103;
    }
}

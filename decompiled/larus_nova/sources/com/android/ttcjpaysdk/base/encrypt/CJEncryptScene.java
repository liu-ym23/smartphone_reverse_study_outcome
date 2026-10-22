package com.android.ttcjpaysdk.base.encrypt;

import com.android.ttcjpaysdk.verify.constants.DyVerifyReqConstants;
import com.bytedance.android.service.manager.push.client.intelligence.IClientFeatureService;
import com.bytedance.locallife.cube.PrefetchTiming;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/base/encrypt/CJEncryptScene;", "", "sceneValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getSceneValue", "()Ljava/lang/String;", "TRADE_VERIFY", "RISK_INFO", "PITAYA", "JSB", "OCR", "FKM", "NO_LOGIN", "FINTECH", "UNKNOWN", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum CJEncryptScene extends Enum<CJEncryptScene> {
    private static final /* synthetic */ CJEncryptScene[] $VALUES = null;
    public static final CJEncryptScene FINTECH = null;
    public static final CJEncryptScene FKM = null;
    public static final CJEncryptScene JSB = null;
    public static final CJEncryptScene NO_LOGIN = null;
    public static final CJEncryptScene OCR = null;
    public static final CJEncryptScene PITAYA = null;
    public static final CJEncryptScene RISK_INFO = null;
    public static final CJEncryptScene TRADE_VERIFY = null;
    public static final CJEncryptScene UNKNOWN = null;
    private final String sceneValue;

    private static final /* synthetic */ CJEncryptScene[] $values() {
        return new CJEncryptScene[]{TRADE_VERIFY, RISK_INFO, PITAYA, JSB, OCR, FKM, NO_LOGIN, FINTECH, UNKNOWN};
    }

    public static CJEncryptScene valueOf(String r100) {
        return (CJEncryptScene) a.a(CJEncryptScene.class, r100);
    }

    public static CJEncryptScene[] values() {
        return (CJEncryptScene[]) $VALUES.clone();
    }

    static {
        TRADE_VERIFY = new CJEncryptScene("TRADE_VERIFY", 0, "trade_verify");
        RISK_INFO = new CJEncryptScene("RISK_INFO", 1, DyVerifyReqConstants.Key.RISK_INFO);
        PITAYA = new CJEncryptScene("PITAYA", 2, IClientFeatureService.INVOKE_SCENE_PITAYA);
        JSB = new CJEncryptScene("JSB", 3, PrefetchTiming.JSB);
        OCR = new CJEncryptScene("OCR", 4, "ocr");
        FKM = new CJEncryptScene("FKM", 5, "fkm");
        NO_LOGIN = new CJEncryptScene("NO_LOGIN", 6, "no_login");
        FINTECH = new CJEncryptScene("FINTECH", 7, "fintech");
        UNKNOWN = new CJEncryptScene("UNKNOWN", 8, "unknown");
        $VALUES = $values();
    }

    public final String getSceneValue() {
        return this.sceneValue;
    }

    private CJEncryptScene(String r100, int r101, String r102) {
        super(r100, r101);
        this.sceneValue = r102;
    }
}

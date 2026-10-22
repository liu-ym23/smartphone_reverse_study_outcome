package com.android.ttcjpaysdk.ocr.utils;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/ocr/utils/OCREnumType;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "CARD", "ID_CARD", "ID_CARD_ONLY_UPLOAD", "ID_CARD_FRONT", "ID_CARD_FXJ", "PASSPORT", "HKMPASS", "TAIWANPASS", "HM_RESIDENCE", "TW_RESIDENCE", "FOREIGNER", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum OCREnumType extends Enum<OCREnumType> {
    private static final /* synthetic */ OCREnumType[] $VALUES = null;
    public static final OCREnumType CARD = null;
    public static final OCREnumType FOREIGNER = null;
    public static final OCREnumType HKMPASS = null;
    public static final OCREnumType HM_RESIDENCE = null;
    public static final OCREnumType ID_CARD = null;
    public static final OCREnumType ID_CARD_FRONT = null;
    public static final OCREnumType ID_CARD_FXJ = null;
    public static final OCREnumType ID_CARD_ONLY_UPLOAD = null;
    public static final OCREnumType PASSPORT = null;
    public static final OCREnumType TAIWANPASS = null;
    public static final OCREnumType TW_RESIDENCE = null;
    private final String type;

    private static final /* synthetic */ OCREnumType[] $values() {
        return new OCREnumType[]{CARD, ID_CARD, ID_CARD_ONLY_UPLOAD, ID_CARD_FRONT, ID_CARD_FXJ, PASSPORT, HKMPASS, TAIWANPASS, HM_RESIDENCE, TW_RESIDENCE, FOREIGNER};
    }

    public static OCREnumType valueOf(String r100) {
        return (OCREnumType) a.a(OCREnumType.class, r100);
    }

    public static OCREnumType[] values() {
        return (OCREnumType[]) $VALUES.clone();
    }

    static {
        CARD = new OCREnumType("CARD", 0, BrowserDependency.UrlClickType.CARD);
        ID_CARD = new OCREnumType("ID_CARD", 1, BytedCertConstant.NFC.ID_CARD);
        ID_CARD_ONLY_UPLOAD = new OCREnumType("ID_CARD_ONLY_UPLOAD", 2, "id_card_only_upload");
        ID_CARD_FRONT = new OCREnumType("ID_CARD_FRONT", 3, "id_card_front");
        ID_CARD_FXJ = new OCREnumType("ID_CARD_FXJ", 4, "id_card_fxj");
        PASSPORT = new OCREnumType("PASSPORT", 5, "passport");
        HKMPASS = new OCREnumType("HKMPASS", 6, "hkmpass");
        TAIWANPASS = new OCREnumType("TAIWANPASS", 7, "taiwanpass");
        HM_RESIDENCE = new OCREnumType("HM_RESIDENCE", 8, "hm_residence");
        TW_RESIDENCE = new OCREnumType("TW_RESIDENCE", 9, "tw_residence");
        FOREIGNER = new OCREnumType("FOREIGNER", 10, "foreigner");
        $VALUES = $values();
    }

    public final String getType() {
        return this.type;
    }

    private OCREnumType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}

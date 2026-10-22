package com.android.ttcjpaysdk.ocr.utils;

import com.larus.nova.R;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R)\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007R)\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0007R)\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/ocr/utils/OCRIdCardConfig;", "", "()V", "requestType", "", "", "getRequestType", "()Ljava/util/Map;", "scanImageMap", "Lkotlin/Pair;", "getScanImageMap", "scanSuccessImage", "getScanSuccessImage", "scanTipsResMap", "", "getScanTipsResMap", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OCRIdCardConfig {
    public static final OCRIdCardConfig INSTANCE = null;
    private static final Map<String, String> requestType = null;
    private static final Map<String, Pair<String, String>> scanImageMap = null;
    private static final Map<String, Pair<String, String>> scanSuccessImage = null;
    private static final Map<String, Pair<Integer, Integer>> scanTipsResMap = null;

    private OCRIdCardConfig() {
    }

    static {
        INSTANCE = new OCRIdCardConfig();
        OCREnumType r100 = OCREnumType.ID_CARD;
        OCREnumType r101 = OCREnumType.ID_CARD_ONLY_UPLOAD;
        OCREnumType r102 = OCREnumType.ID_CARD_FXJ;
        OCREnumType r103 = OCREnumType.HKMPASS;
        OCREnumType r104 = OCREnumType.TAIWANPASS;
        OCREnumType r110 = OCREnumType.HM_RESIDENCE;
        OCREnumType r111 = OCREnumType.TW_RESIDENCE;
        OCREnumType r112 = OCREnumType.FOREIGNER;
        requestType = MapsKt.mapOf(new Pair[]{TuplesKt.to(r100.getType(), "ID_CARD"), TuplesKt.to(r101.getType(), "ID_CARD"), TuplesKt.to(OCREnumType.ID_CARD_FRONT.getType(), "ID_CARD"), TuplesKt.to(r102.getType(), "ID_CARD"), TuplesKt.to(r103.getType(), "HKMPASS"), TuplesKt.to(r104.getType(), "TAIWANPASS"), TuplesKt.to(r110.getType(), "HM_RESIDENCE"), TuplesKt.to(r111.getType(), "TW_RESIDENCE"), TuplesKt.to(r112.getType(), "FOREIGNER"), TuplesKt.to(OCREnumType.PASSPORT.getType(), "PASSPORT")});
        String r113 = r100.getType();
        Integer r114 = Integer.valueOf(R.string.cj_pay_ocr_scan_id_card_front);
        Integer r105 = Integer.valueOf(R.string.cj_pay_ocr_scan_id_card_back);
        scanTipsResMap = MapsKt.mapOf(new Pair[]{TuplesKt.to(r113, new Pair(r114, r105)), TuplesKt.to(r101.getType(), new Pair(r114, r105)), TuplesKt.to(r102.getType(), new Pair(r114, r105)), TuplesKt.to(r103.getType(), new Pair(Integer.valueOf(R.string.cj_pay_ocr_scan_hkmpass_front), Integer.valueOf(R.string.cj_pay_ocr_scan_hkmpass_back))), TuplesKt.to(r104.getType(), new Pair(Integer.valueOf(R.string.cj_pay_ocr_scan_taiwanpass_front), Integer.valueOf(R.string.cj_pay_ocr_scan_taiwanpass_back))), TuplesKt.to(r110.getType(), new Pair(Integer.valueOf(R.string.cj_pay_ocr_scan_hm_residence_front), Integer.valueOf(R.string.cj_pay_ocr_scan_hm_residence_back))), TuplesKt.to(r111.getType(), new Pair(Integer.valueOf(R.string.cj_pay_ocr_scan_tw_residence_front), Integer.valueOf(R.string.cj_pay_ocr_scan_tw_residence_back))), TuplesKt.to(r112.getType(), new Pair(Integer.valueOf(R.string.cj_pay_ocr_scan_foreigner_front), Integer.valueOf(R.string.cj_pay_ocr_scan_foreigner_back)))});
        scanSuccessImage = MapsKt.mapOf(new Pair[]{TuplesKt.to(r100.getType(), new Pair("cj_ocr_profile_img.png", "cj_ocr_amb_img.png")), TuplesKt.to(r101.getType(), new Pair("cj_ocr_profile_img.png", "cj_ocr_amb_img.png")), TuplesKt.to(r102.getType(), new Pair("cj_ocr_profile_img.png", "cj_ocr_amb_img.png")), TuplesKt.to(r103.getType(), new Pair("hw_macao_pass_success_front.png", "hw_macao_pass_success_back.png")), TuplesKt.to(r104.getType(), new Pair("tw_pass_success_front.png", "tw_pass_success_back.png")), TuplesKt.to(r110.getType(), new Pair("hk_macao_residence_success_front.png", "hk_macao_residence_success_back.png")), TuplesKt.to(r111.getType(), new Pair("tw_residence_success_front.png", "tw_residence_success_back.png")), TuplesKt.to(r112.getType(), new Pair("foreigner_residence_success_front.png", "foreigner_residence_success_back.png"))});
        scanImageMap = MapsKt.mapOf(new Pair[]{TuplesKt.to(r100.getType(), new Pair("cj_profile_side_blank_image_opt.png", "cj_emblem_side_blank_image_opt.png")), TuplesKt.to(r101.getType(), new Pair("cj_profile_side_blank_image_opt.png", "cj_emblem_side_blank_image_opt.png")), TuplesKt.to(r102.getType(), new Pair("cj_profile_side_blank_image_opt.png", "cj_emblem_side_blank_image_opt.png")), TuplesKt.to(r103.getType(), new Pair("hk_macao_pass_front.png", "hk_macao_pass_back.png")), TuplesKt.to(r104.getType(), new Pair("tw_pass_front.png", "tw_pass_back.png")), TuplesKt.to(r110.getType(), new Pair("hk_macao_residence_front.png", "hk_macao_residence_back.png")), TuplesKt.to(r111.getType(), new Pair("tw_residence_front.png", "tw_residence_back.png")), TuplesKt.to(r112.getType(), new Pair("foreigner_residence_front.png", "foreigner_residence_back.png"))});
    }

    public final Map<String, String> getRequestType() {
        return requestType;
    }

    public final Map<String, Pair<String, String>> getScanImageMap() {
        return scanImageMap;
    }

    public final Map<String, Pair<String, String>> getScanSuccessImage() {
        return scanSuccessImage;
    }

    public final Map<String, Pair<Integer, Integer>> getScanTipsResMap() {
        return scanTipsResMap;
    }
}

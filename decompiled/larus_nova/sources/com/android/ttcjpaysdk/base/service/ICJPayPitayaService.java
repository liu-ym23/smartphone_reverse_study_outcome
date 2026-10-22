package com.android.ttcjpaysdk.base.service;

import android.content.Context;
import android.graphics.Bitmap;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u0000 \u00132\u00020\u0001:\u0005\u0012\u0013\u0014\u0015\u0016J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\tH&J\u001c\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\u001c\u0010\u000f\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&¨\u0006\u0017"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayPitayaService;", "Lcom/android/ttcjpaysdk/base/service/ICJPayService;", "bankcardOCR", "", SimplayerImageStrategy.RESULT_BITMAP, "Landroid/graphics/Bitmap;", "callback", "Lcom/android/ttcjpaysdk/base/service/ICJPayPitayaService$IOCRCallback;", "cardDetect", "Lcom/android/ttcjpaysdk/base/service/ICJPayPitayaService$ICardDetectCallback;", "init", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "setupInfo", "Lorg/json/JSONObject;", "registerApplogRunWithRiskSdkFeature", "aid", "", "CJPayPTYErrorCode", "Companion", "ICardDetectCallback", "IHostSetupCallback", "IOCRCallback", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ICJPayPitayaService extends ICJPayService {
    public static final String AID = "1792";
    public static final String AID_DOUYIN = "1128";
    public static final String AID_DOUYIN_HUOSHAN = "8663";
    public static final String AID_DOUYIN_LITE = "2329";
    public static final Companion Companion = null;

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayPitayaService$CJPayPTYErrorCode;", "", "()V", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CJPayPTYErrorCode {
        public static final Companion Companion = null;
        public static final int OCR_CODE_CARD_RATIO_INVALID = 104;
        public static final int OCR_CODE_FAILED = 101;
        public static final int OCR_CODE_MORE_THAN_ONE_CARD = 103;
        public static final int OCR_CODE_NO_CARD = 102;
        public static final int OCR_CODE_SUCCESS = 100;
        public static final int TASK_RUN_ERROR = 11;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayPitayaService$CJPayPTYErrorCode$Companion;", "", "()V", "OCR_CODE_CARD_RATIO_INVALID", "", "OCR_CODE_FAILED", "OCR_CODE_MORE_THAN_ONE_CARD", "OCR_CODE_NO_CARD", "OCR_CODE_SUCCESS", "TASK_RUN_ERROR", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
        }

        public CJPayPTYErrorCode() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayPitayaService$Companion;", "", "()V", "AID", "", "AID_DOUYIN", "AID_DOUYIN_HUOSHAN", "AID_DOUYIN_LITE", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final String AID = "1792";
        public static final String AID_DOUYIN = "1128";
        public static final String AID_DOUYIN_HUOSHAN = "8663";
        public static final String AID_DOUYIN_LITE = "2329";

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayPitayaService$ICardDetectCallback;", "", "onResult", "", "code", "", "msg", "", SimplayerImageStrategy.RESULT_BITMAP, "Landroid/graphics/Bitmap;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface ICardDetectCallback {
        void onResult(int r100, String r101, Bitmap r102);
    }

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayPitayaService$IHostSetupCallback;", "", "onHostSetup", "", "success", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface IHostSetupCallback {
        void onHostSetup(boolean r100);
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayPitayaService$IOCRCallback;", "", "onResult", "", "code", "", "msg", "", "data", "Lorg/json/JSONObject;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface IOCRCallback {
        void onResult(int r100, String r101, JSONObject r102);
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    void bankcardOCR(Bitmap r100, IOCRCallback r101);

    void cardDetect(Bitmap r100, ICardDetectCallback r101);

    void init(Context r100, JSONObject r101);

    void registerApplogRunWithRiskSdkFeature(Context r100, String r101);
}

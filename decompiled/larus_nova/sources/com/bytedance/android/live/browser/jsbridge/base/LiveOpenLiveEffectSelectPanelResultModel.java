package com.bytedance.android.live.browser.jsbridge.base;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import e7.j0;
import e7.k0;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0002\u0019\fB\u0007¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/LiveOpenLiveEffectSelectPanelResultModel;", "Le7/k0;", "Lcom/bytedance/android/live/browser/jsbridge/base/LiveOpenLiveEffectSelectPanelResultModel$Code;", "code", "Lcom/bytedance/android/live/browser/jsbridge/base/LiveOpenLiveEffectSelectPanelResultModel$Code;", "getCode", "()Lcom/bytedance/android/live/browser/jsbridge/base/LiveOpenLiveEffectSelectPanelResultModel$Code;", "b", "(Lcom/bytedance/android/live/browser/jsbridge/base/LiveOpenLiveEffectSelectPanelResultModel$Code;)V", "Lcom/bytedance/android/live/browser/jsbridge/base/LiveOpenLiveEffectSelectPanelResultModel$a;", "data", "Lcom/bytedance/android/live/browser/jsbridge/base/LiveOpenLiveEffectSelectPanelResultModel$a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/live/browser/jsbridge/base/LiveOpenLiveEffectSelectPanelResultModel$a;", "c", "(Lcom/bytedance/android/live/browser/jsbridge/base/LiveOpenLiveEffectSelectPanelResultModel$a;)V", "", "msg", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "<init>", "()V", "Code", "livehybrid-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveOpenLiveEffectSelectPanelResultModel implements k0 {

    @SerializedName("code")
    private Code code;

    @SerializedName("data")
    private a data;

    @SerializedName("msg")
    private String msg;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/LiveOpenLiveEffectSelectPanelResultModel$Code;", "", "Le7/j0;", "", "getCode", "value", "I", "getValue", "()I", "Success", "Failed", "NO_PERMISSION", "NOT_REGISTER", "livehybrid-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Code extends Enum<Code> implements j0 {
        public static final Code Failed = null;
        public static final Code NOT_REGISTER = null;
        public static final Code NO_PERMISSION = null;
        public static final Code Success = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Code[] f63070a = null;
        private final int value;

        static {
            Code r100 = new Code("Success", 0, 1);
            Success = r100;
            Code r101 = new Code("Failed", 1, 0);
            Failed = r101;
            Code r102 = new Code("NO_PERMISSION", 2, -1);
            NO_PERMISSION = r102;
            Code r103 = new Code("NOT_REGISTER", 3, -2);
            NOT_REGISTER = r103;
            f63070a = new Code[]{r100, r101, r102, r103};
        }

        public static Code valueOf(String r100) {
            return (Code) r27.a.a(Code.class, r100);
        }

        public static Code[] values() {
            return (Code[]) f63070a.clone();
        }

        @Override // e7.j0
        public int getCode() {
            return this.value;
        }

        public final int getValue() {
            return this.value;
        }

        public Code(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0004\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b&\u0010'R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR$\u0010 \u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR$\u0010#\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010\b¨\u0006("}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/LiveOpenLiveEffectSelectPanelResultModel$a;", "", "", "effectID", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "e", "(Ljava/lang/String;)V", "effectName", "b", "h", "effectIconUrl", "getEffectIconUrl", "f", "", "effectEnableCustomizeDuration", "Ljava/lang/Boolean;", "getEffectEnableCustomizeDuration", "()Ljava/lang/Boolean;", "d", "(Ljava/lang/Boolean;)V", "", "effectDefaultDuration", "Ljava/lang/Number;", "getEffectDefaultDuration", "()Ljava/lang/Number;", "c", "(Ljava/lang/Number;)V", "effectMaxDuration", "getEffectMaxDuration", ce.f26391f, "firstLevelEffectCategory", "getFirstLevelEffectCategory", RXScreenCaptureService.KEY_INDEX, "secondLevelEffectCategory", "getSecondLevelEffectCategory", ce.f26395j, "<init>", "()V", "livehybrid-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("effectDefaultDuration")
        private Number effectDefaultDuration;

        @SerializedName("effectEnableCustomizeDuration")
        private Boolean effectEnableCustomizeDuration;

        @SerializedName("effectID")
        private String effectID;

        @SerializedName("effectIconUrl")
        private String effectIconUrl;

        @SerializedName("effectMaxDuration")
        private Number effectMaxDuration;

        @SerializedName("effectName")
        private String effectName;

        @SerializedName("firstLevelEffectCategory")
        private String firstLevelEffectCategory;

        @SerializedName("secondLevelEffectCategory")
        private String secondLevelEffectCategory;

        public a() {
        }

        public final String a() {
            return this.effectID;
        }

        public final String b() {
            return this.effectName;
        }

        public final void c(Number r100) {
            this.effectDefaultDuration = r100;
        }

        public final void d(Boolean r100) {
            this.effectEnableCustomizeDuration = r100;
        }

        public final void e(String r100) {
            this.effectID = r100;
        }

        public final void f(String r100) {
            this.effectIconUrl = r100;
        }

        public final void g(Number r100) {
            this.effectMaxDuration = r100;
        }

        public final void h(String r100) {
            this.effectName = r100;
        }

        public final void i(String r100) {
            this.firstLevelEffectCategory = r100;
        }

        public final void j(String r100) {
            this.secondLevelEffectCategory = r100;
        }
    }

    public LiveOpenLiveEffectSelectPanelResultModel() {
    }

    public final a a() {
        return this.data;
    }

    public final void b(Code r100) {
        this.code = r100;
    }

    public final void c(a r100) {
        this.data = r100;
    }
}

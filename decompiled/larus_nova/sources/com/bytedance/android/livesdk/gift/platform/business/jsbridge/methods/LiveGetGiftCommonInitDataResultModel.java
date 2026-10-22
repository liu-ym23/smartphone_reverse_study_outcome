package com.bytedance.android.livesdk.gift.platform.business.jsbridge.methods;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import e7.j0;
import e7.k0;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0002\u0012\fB\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/jsbridge/methods/LiveGetGiftCommonInitDataResultModel;", "Le7/k0;", "Lcom/bytedance/android/livesdk/gift/platform/business/jsbridge/methods/LiveGetGiftCommonInitDataResultModel$Code;", "code", "Lcom/bytedance/android/livesdk/gift/platform/business/jsbridge/methods/LiveGetGiftCommonInitDataResultModel$Code;", "getCode", "()Lcom/bytedance/android/livesdk/gift/platform/business/jsbridge/methods/LiveGetGiftCommonInitDataResultModel$Code;", "b", "(Lcom/bytedance/android/livesdk/gift/platform/business/jsbridge/methods/LiveGetGiftCommonInitDataResultModel$Code;)V", "Lcom/bytedance/android/livesdk/gift/platform/business/jsbridge/methods/LiveGetGiftCommonInitDataResultModel$a;", "data", "Lcom/bytedance/android/livesdk/gift/platform/business/jsbridge/methods/LiveGetGiftCommonInitDataResultModel$a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/livesdk/gift/platform/business/jsbridge/methods/LiveGetGiftCommonInitDataResultModel$a;", "c", "(Lcom/bytedance/android/livesdk/gift/platform/business/jsbridge/methods/LiveGetGiftCommonInitDataResultModel$a;)V", "<init>", "()V", "Code", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveGetGiftCommonInitDataResultModel implements k0 {

    @SerializedName("code")
    private Code code;

    @SerializedName("data")
    private a data;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/jsbridge/methods/LiveGetGiftCommonInitDataResultModel$Code;", "", "Le7/j0;", "", "getCode", "value", "I", "getValue", "()I", "Success", "Failed", "NO_PERMISSION", "NOT_REGISTER", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Code extends Enum<Code> implements j0 {
        public static final Code Failed = null;
        public static final Code NOT_REGISTER = null;
        public static final Code NO_PERMISSION = null;
        public static final Code Success = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Code[] f129676a = null;
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
            f129676a = new Code[]{r100, r101, r102, r103};
        }

        public static Code valueOf(String r100) {
            return (Code) r27.a.a(Code.class, r100);
        }

        public static Code[] values() {
            return (Code[]) f129676a.clone();
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

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0004\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/jsbridge/methods/LiveGetGiftCommonInitDataResultModel$a;", "", "", "roomScene", "Ljava/lang/Number;", "getRoomScene", "()Ljava/lang/Number;", "b", "(Ljava/lang/Number;)V", "interactiveScene", "getInteractiveScene", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("interactiveScene")
        private Number interactiveScene;

        @SerializedName("roomScene")
        private Number roomScene;

        public a() {
        }

        public final void a(Number r100) {
            this.interactiveScene = r100;
        }

        public final void b(Number r100) {
            this.roomScene = r100;
        }
    }

    public LiveGetGiftCommonInitDataResultModel() {
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

package com.bytedance.android.live.browser.jsbridge.base;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import e7.j0;
import e7.k0;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/LiveGetStickerInfoResultModel;", "Le7/k0;", "Lcom/bytedance/android/live/browser/jsbridge/base/LiveGetStickerInfoResultModel$Code;", "code", "Lcom/bytedance/android/live/browser/jsbridge/base/LiveGetStickerInfoResultModel$Code;", "getCode", "()Lcom/bytedance/android/live/browser/jsbridge/base/LiveGetStickerInfoResultModel$Code;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "(Lcom/bytedance/android/live/browser/jsbridge/base/LiveGetStickerInfoResultModel$Code;)V", "", "is_added", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "b", "(Ljava/lang/Boolean;)V", "<init>", "()V", "Code", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveGetStickerInfoResultModel implements k0 {

    @SerializedName("code")
    private Code code;

    @SerializedName("is_added")
    private Boolean is_added;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/LiveGetStickerInfoResultModel$Code;", "", "Le7/j0;", "", "getCode", "value", "I", "getValue", "()I", "Success", "Failed", "NO_PERMISSION", "NOT_REGISTER", "FetchStickerListFail", "NotFoundSticker", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Code extends Enum<Code> implements j0 {
        public static final Code Failed = null;
        public static final Code FetchStickerListFail = null;
        public static final Code NOT_REGISTER = null;
        public static final Code NO_PERMISSION = null;
        public static final Code NotFoundSticker = null;
        public static final Code Success = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Code[] f63064a = null;
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
            Code r104 = new Code("FetchStickerListFail", 4, -1001);
            FetchStickerListFail = r104;
            Code r105 = new Code("NotFoundSticker", 5, -1002);
            NotFoundSticker = r105;
            f63064a = new Code[]{r100, r101, r102, r103, r104, r105};
        }

        public static Code valueOf(String r100) {
            return (Code) a.a(Code.class, r100);
        }

        public static Code[] values() {
            return (Code[]) f63064a.clone();
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

    public LiveGetStickerInfoResultModel() {
    }

    public final void a(Code r100) {
        this.code = r100;
    }

    public final void b(Boolean r100) {
        this.is_added = r100;
    }
}

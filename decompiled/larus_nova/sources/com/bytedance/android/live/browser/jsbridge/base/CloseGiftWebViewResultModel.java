package com.bytedance.android.live.browser.jsbridge.base;

import com.google.gson.annotations.SerializedName;
import e7.j0;
import e7.k0;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/CloseGiftWebViewResultModel;", "Le7/k0;", "Lcom/bytedance/android/live/browser/jsbridge/base/CloseGiftWebViewResultModel$Code;", "code", "Lcom/bytedance/android/live/browser/jsbridge/base/CloseGiftWebViewResultModel$Code;", "getCode", "()Lcom/bytedance/android/live/browser/jsbridge/base/CloseGiftWebViewResultModel$Code;", "setCode", "(Lcom/bytedance/android/live/browser/jsbridge/base/CloseGiftWebViewResultModel$Code;)V", "<init>", "()V", "Code", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CloseGiftWebViewResultModel implements k0 {

    @SerializedName("code")
    private Code code;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/CloseGiftWebViewResultModel$Code;", "", "Le7/j0;", "", "getCode", "value", "I", "getValue", "()I", "Success", "Failed", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Code extends Enum<Code> implements j0 {
        public static final Code Failed = null;
        public static final Code Success = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Code[] f62978a = null;
        private final int value;

        static {
            Code r100 = new Code("Success", 0, 1);
            Success = r100;
            Code r101 = new Code("Failed", 1, 0);
            Failed = r101;
            f62978a = new Code[]{r100, r101};
        }

        public static Code valueOf(String r100) {
            return (Code) a.a(Code.class, r100);
        }

        public static Code[] values() {
            return (Code[]) f62978a.clone();
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

    public CloseGiftWebViewResultModel() {
    }
}

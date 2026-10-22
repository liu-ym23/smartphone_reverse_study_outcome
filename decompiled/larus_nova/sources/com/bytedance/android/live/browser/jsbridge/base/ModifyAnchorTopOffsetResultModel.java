package com.bytedance.android.live.browser.jsbridge.base;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import e7.j0;
import e7.k0;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001\u0014B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\f\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/ModifyAnchorTopOffsetResultModel;", "Le7/k0;", "Lcom/bytedance/android/live/browser/jsbridge/model/IResultModel;", "Lcom/bytedance/android/live/browser/jsbridge/base/ModifyAnchorTopOffsetResultModel$Code;", "code", "Lcom/bytedance/android/live/browser/jsbridge/base/ModifyAnchorTopOffsetResultModel$Code;", "getCode", "()Lcom/bytedance/android/live/browser/jsbridge/base/ModifyAnchorTopOffsetResultModel$Code;", "setCode", "(Lcom/bytedance/android/live/browser/jsbridge/base/ModifyAnchorTopOffsetResultModel$Code;)V", "Lcom/google/gson/JsonObject;", "Lcom/bytedance/revenue/platform/api/core/JsonObject;", "data", "Lcom/google/gson/JsonObject;", "getData", "()Lcom/google/gson/JsonObject;", "setData", "(Lcom/google/gson/JsonObject;)V", "<init>", "()V", "Code", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ModifyAnchorTopOffsetResultModel implements k0 {

    @SerializedName("code")
    private Code code;

    @SerializedName("data")
    private JsonObject data;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00060\u0002j\u0002`\u0003J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/ModifyAnchorTopOffsetResultModel$Code;", "", "Le7/j0;", "Lcom/bytedance/android/live/browser/jsbridge/model/IResultCode;", "", "getCode", "value", "I", "getValue", "()I", "Success", "Failed", "NO_PERMISSION", "NOT_REGISTER", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum Code extends Enum<Code> implements j0 {
        public static final Code Failed = null;
        public static final Code NOT_REGISTER = null;
        public static final Code NO_PERMISSION = null;
        public static final Code Success = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Code[] f63097a = null;
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
            f63097a = new Code[]{r100, r101, r102, r103};
        }

        public static Code valueOf(String r100) {
            return (Code) a.a(Code.class, r100);
        }

        public static Code[] values() {
            return (Code[]) f63097a.clone();
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

    public ModifyAnchorTopOffsetResultModel() {
    }
}

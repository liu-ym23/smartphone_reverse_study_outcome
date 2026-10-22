package com.bytedance.android.live.browser.jsbridge.base;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import e7.j0;
import e7.k0;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/StartSpeechRecognitionResultModel;", "Le7/k0;", "Lcom/bytedance/android/live/browser/jsbridge/base/StartSpeechRecognitionResultModel$Code;", "code", "Lcom/bytedance/android/live/browser/jsbridge/base/StartSpeechRecognitionResultModel$Code;", "getCode", "()Lcom/bytedance/android/live/browser/jsbridge/base/StartSpeechRecognitionResultModel$Code;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "(Lcom/bytedance/android/live/browser/jsbridge/base/StartSpeechRecognitionResultModel$Code;)V", "", "msg", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "b", "(Ljava/lang/String;)V", "<init>", "()V", "Code", "annie_release"}, k = 1, mv = {1, 4, 3})
public final class StartSpeechRecognitionResultModel implements k0 {

    @SerializedName("code")
    private Code code;

    @SerializedName("msg")
    private String msg;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/StartSpeechRecognitionResultModel$Code;", "", "Le7/j0;", "", "getCode", "value", "I", "getValue", "()I", "Success", "Failed", "UnauthorizedInvocation", "UnregisteredMethod", "UnauthorizedAccess", "InvalidParameter", "NetworkUnreachable", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final enum Code extends Enum<Code> implements j0 {
        public static final Code Failed = null;
        public static final Code InvalidParameter = null;
        public static final Code NetworkUnreachable = null;
        public static final Code Success = null;
        public static final Code UnauthorizedAccess = null;
        public static final Code UnauthorizedInvocation = null;
        public static final Code UnregisteredMethod = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Code[] f63174a = null;
        private final int value;

        public static Code valueOf(String r100) {
            return (Code) a.a(Code.class, r100);
        }

        public static Code[] values() {
            return (Code[]) f63174a.clone();
        }

        static {
            Code r100 = new Code("Success", 0, 1);
            Success = r100;
            Code r101 = new Code("Failed", 1, 0);
            Failed = r101;
            Code r102 = new Code("UnauthorizedInvocation", 2, -1);
            UnauthorizedInvocation = r102;
            Code r103 = new Code("UnregisteredMethod", 3, -2);
            UnregisteredMethod = r103;
            Code r104 = new Code("UnauthorizedAccess", 4, -6);
            UnauthorizedAccess = r104;
            Code r105 = new Code("InvalidParameter", 5, -3);
            InvalidParameter = r105;
            Code r110 = new Code("NetworkUnreachable", 6, -1001);
            NetworkUnreachable = r110;
            f63174a = new Code[]{r100, r101, r102, r103, r104, r105, r110};
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

    public StartSpeechRecognitionResultModel() {
    }

    public final void a(Code r100) {
        this.code = r100;
    }

    public final void b(String r100) {
        this.msg = r100;
    }
}

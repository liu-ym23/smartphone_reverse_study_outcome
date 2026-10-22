package com.bytedance.android.annie.bridge.method.abs;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import e7.j0;
import e7.k0;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0002\u001c\u001dB\u0007¢\u0006\u0004\b\u001a\u0010\u001bR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/abs/LoginResultModel;", "Le7/k0;", "Lcom/bytedance/android/annie/bridge/method/abs/LoginResultModel$Code;", "code", "Lcom/bytedance/android/annie/bridge/method/abs/LoginResultModel$Code;", "getCode", "()Lcom/bytedance/android/annie/bridge/method/abs/LoginResultModel$Code;", "b", "(Lcom/bytedance/android/annie/bridge/method/abs/LoginResultModel$Code;)V", "", "status", "Ljava/lang/String;", "getStatus", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "", "alreadyLoggedIn", "Ljava/lang/Boolean;", "getAlreadyLoggedIn", "()Ljava/lang/Boolean;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "(Ljava/lang/Boolean;)V", "msg", "getMsg", "c", "<init>", "()V", "Code", "Status", "annie_release"}, k = 1, mv = {1, 4, 3})
public final class LoginResultModel implements k0 {

    @SerializedName("alreadyLoggedIn")
    private Boolean alreadyLoggedIn;

    @SerializedName("code")
    private Code code;

    @SerializedName("msg")
    private String msg;

    @SerializedName("status")
    private String status;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/abs/LoginResultModel$Code;", "", "Le7/j0;", "", "getCode", "value", "I", "getValue", "()I", "Success", "Failed", "InvalidParam", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final enum Code extends Enum<Code> implements j0 {
        public static final Code Failed = null;
        public static final Code InvalidParam = null;
        public static final Code Success = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Code[] f38517a = null;
        private final int value;

        public static Code valueOf(String r100) {
            return (Code) a.a(Code.class, r100);
        }

        public static Code[] values() {
            return (Code[]) f38517a.clone();
        }

        static {
            Code r100 = new Code("Success", 0, 1);
            Success = r100;
            Code r101 = new Code("Failed", 1, 0);
            Failed = r101;
            Code r102 = new Code("InvalidParam", 2, -3);
            InvalidParam = r102;
            f38517a = new Code[]{r100, r101, r102};
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

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/abs/LoginResultModel$Status;", "", "", "toString", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "LoggedIn", "Cancelled", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final enum Status extends Enum<Status> {
        public static final Status Cancelled = null;
        public static final a Companion = null;
        public static final Status LoggedIn = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Status[] f38518a = null;

        public static final class a {
            public a() {
            }
        }

        public static Status valueOf(String r100) {
            return (Status) r27.a.a(Status.class, r100);
        }

        public static Status[] values() {
            return (Status[]) f38518a.clone();
        }

        static {
            Status r100 = new Status("LoggedIn", 0);
            LoggedIn = r100;
            Status r101 = new Status("Cancelled", 1);
            Cancelled = r101;
            f38518a = new Status[]{r100, r101};
            Companion = new a();
        }

        @Override // java.lang.Enum
        public String toString() {
            if (this != LoggedIn) goto L6;
            return "loggedIn";
        L6:
            if (this != Cancelled) goto L8;
            return "cancelled";
        L8:
            return "";
        }

        public Status(String r100, int r101) {
            super(r100, r101);
        }
    }

    public LoginResultModel() {
    }

    public final void a(Boolean r100) {
        this.alreadyLoggedIn = r100;
    }

    public final void b(Code r100) {
        this.code = r100;
    }

    public final void c(String r100) {
        this.msg = r100;
    }

    public final void d(String r100) {
        this.status = r100;
    }
}

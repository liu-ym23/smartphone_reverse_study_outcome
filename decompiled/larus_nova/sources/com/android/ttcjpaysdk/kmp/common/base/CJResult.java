package com.android.ttcjpaysdk.kmp.common.base;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0007\u0018\u0000 \u0015*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0015B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00028\u0000¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\t\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/base/CJResult;", ExifInterface.GPS_DIRECTION_TRUE, "", "code", "", "msg", "", "bizCode", "bizMsg", "data", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "getCode", "()I", "getMsg", "()Ljava/lang/String;", "getBizCode", "getBizMsg", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "Companion", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CJResult<T> {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private final String bizCode;
    private final String bizMsg;
    private final int code;
    private final T data;
    private final String msg;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0001\u0010\u00062\u0006\u0010\u0007\u001a\u0002H\u0006¢\u0006\u0002\u0010\bJ/\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0001\u0010\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u0002H\u0006¢\u0006\u0002\u0010\rJ/\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0001\u0010\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u0002H\u0006¢\u0006\u0002\u0010\u0012J7\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0001\u0010\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u0002H\u0006¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/base/CJResult$Companion;", "", "<init>", "()V", "success", "Lcom/android/ttcjpaysdk/kmp/common/base/CJResult;", ExifInterface.GPS_DIRECTION_TRUE, "data", "(Ljava/lang/Object;)Lcom/android/ttcjpaysdk/kmp/common/base/CJResult;", "bizSuccess", "bizCode", "", "bizMsg", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Lcom/android/ttcjpaysdk/kmp/common/base/CJResult;", "fail", "code", "", "msg", "(ILjava/lang/String;Ljava/lang/Object;)Lcom/android/ttcjpaysdk/kmp/common/base/CJResult;", "bizFail", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Lcom/android/ttcjpaysdk/kmp/common/base/CJResult;", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final <T> CJResult<T> success(T r110) {
            return new CJResult(0, "", null, "", r110, 4, null);
        }

        public final <T> CJResult<T> bizSuccess(String r100, String r101, T r110) {
            Intrinsics.checkNotNullParameter(r100, "bizCode");
            Intrinsics.checkNotNullParameter(r101, "bizMsg");
            return new CJResult(0, "", r100, r101, r110);
        }

        public final <T> CJResult<T> fail(int r110, String r111, T r112) {
            Intrinsics.checkNotNullParameter(r111, "msg");
            return new CJResult(r110, r111, null, "", r112, 4, null);
        }

        public final <T> CJResult<T> bizFail(int r100, String r101, String r110, T r111) {
            Intrinsics.checkNotNullParameter(r101, "msg");
            Intrinsics.checkNotNullParameter(r110, "bizCode");
            return new CJResult(r100, r101, r110, "", r111);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public final String getBizCode() {
        return this.bizCode;
    }

    public final String getBizMsg() {
        return this.bizMsg;
    }

    public final int getCode() {
        return this.code;
    }

    public final T getData() {
        return this.data;
    }

    public final String getMsg() {
        return this.msg;
    }

    public CJResult(int r100, String r101, String r102, String r103, T r104) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        Intrinsics.checkNotNullParameter(r102, "bizCode");
        Intrinsics.checkNotNullParameter(r103, "bizMsg");
        this.code = r100;
        this.msg = r101;
        this.bizCode = r102;
        this.bizMsg = r103;
        this.data = r104;
    }

    public /* synthetic */ CJResult(int r100, String r101, String r102, String r110, Object r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 4) == 0) goto L5;
        r102 = "";
    L5:
        this(r100, r101, r102, r110, r111);
    }
}

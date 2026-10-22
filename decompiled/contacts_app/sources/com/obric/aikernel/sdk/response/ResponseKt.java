package com.obric.aikernel.sdk.response;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: Response.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001ai\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012K\u0010\u0003\u001aG\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0004\u001ak\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012M\u0010\u0003\u001aI\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u0001H\u0002¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0004¨\u0006\u0012"}, d2 = {"fail", "Lcom/obric/aikernel/sdk/response/Response;", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "errCode", "", "errInfo", "Lorg/json/JSONObject;", "extra", "", "ok", "", "isFinish", "data", "sdk_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ResponseKt {
    public static final <T> Response<T> ok(Response<T> r3, Function3<? super Boolean, ? super T, ? super JSONObject, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "block");
        if (r3.getErrorCode() != 0) goto L5;
    L6:
        r4.invoke(Boolean.valueOf(r3.isFinish()), r3.getData(), r3.getExtra());
    L7:
        return r3;
    L5:
        if (r3.getErrorCode() != 1) goto L7;
        goto L6
    }

    public static final <T> Response<T> fail(Response<T> r3, Function3<? super Integer, ? super String, ? super JSONObject, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "block");
        if (r3.getErrorCode() != 0) goto L5;
    L10:
        return r3;
    L5:
        if (r3.getErrorCode() == 1) goto L10;
        Integer r0 = Integer.valueOf(r3.getErrorCode());
        String r1 = r3.getErrorInfo();
        if (r1 != null) goto L9;
        r1 = "";
    L9:
        r4.invoke(r0, r1, r3.getExtra());
        goto L10
    }
}

package com.stepos.core.ota.remote;

import ai.onnxruntime.a;
import com.stepos.core.ota.data.OtaRemoteModel;
import com.stepos.deepbinder.annotation.BaseConstantsKt;
import e5.b;
import h0.e;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.g;
import v1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ApiResponse {

    @b("code")
    private final int code;

    @b(BaseConstantsKt.KEY_ERROR_CODE)
    private final String errorCode;

    @b("message")
    private final String message;

    @b("redirect")
    private final String redirect;

    @b("value")
    private final List<OtaRemoteModel> value;

    public ApiResponse() {
        this(0, null, null, null, null, 31, null);
    }

    public static /* synthetic */ ApiResponse copy$default(ApiResponse apiResponse, int i10, String str, String str2, String str3, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = apiResponse.code;
        }
        if ((i11 & 2) != 0) {
            str = apiResponse.errorCode;
        }
        if ((i11 & 4) != 0) {
            str2 = apiResponse.message;
        }
        if ((i11 & 8) != 0) {
            str3 = apiResponse.redirect;
        }
        if ((i11 & 16) != 0) {
            list = apiResponse.value;
        }
        List list2 = list;
        String str4 = str2;
        return apiResponse.copy(i10, str, str4, str3, list2);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.errorCode;
    }

    public final String component3() {
        return this.message;
    }

    public final String component4() {
        return this.redirect;
    }

    public final List<OtaRemoteModel> component5() {
        return this.value;
    }

    public final ApiResponse copy(int i10, String str, String message, String redirect, List<OtaRemoteModel> value) {
        g.f(message, "message");
        g.f(redirect, "redirect");
        g.f(value, "value");
        return new ApiResponse(i10, str, message, redirect, value);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ApiResponse)) {
            return false;
        }
        ApiResponse apiResponse = (ApiResponse) obj;
        return this.code == apiResponse.code && g.b(this.errorCode, apiResponse.errorCode) && g.b(this.message, apiResponse.message) && g.b(this.redirect, apiResponse.redirect) && g.b(this.value, apiResponse.value);
    }

    public final int getCode() {
        return this.code;
    }

    public final String getErrorCode() {
        return this.errorCode;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getRedirect() {
        return this.redirect;
    }

    public final List<OtaRemoteModel> getValue() {
        return this.value;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.code) * 31;
        String str = this.errorCode;
        return this.value.hashCode() + d.a(d.a((iHashCode + (str == null ? 0 : str.hashCode())) * 31, 31, this.message), 31, this.redirect);
    }

    public String toString() {
        int i10 = this.code;
        String str = this.errorCode;
        String str2 = this.message;
        String str3 = this.redirect;
        List<OtaRemoteModel> list = this.value;
        StringBuilder sbE = e.e("ApiResponse(code=", i10, ", errorCode=", str, ", message=");
        a.z(sbE, str2, ", redirect=", str3, ", value=");
        sbE.append(list);
        sbE.append(")");
        return sbE.toString();
    }

    public ApiResponse(int i10, String str, String message, String redirect, List<OtaRemoteModel> value) {
        g.f(message, "message");
        g.f(redirect, "redirect");
        g.f(value, "value");
        this.code = i10;
        this.errorCode = str;
        this.message = message;
        this.redirect = redirect;
        this.value = value;
    }

    public ApiResponse(int i10, String str, String str2, String str3, List list, int i11, kotlin.jvm.internal.e eVar) {
        this((i11 & 1) != 0 ? 0 : i10, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? "" : str2, (i11 & 8) != 0 ? "" : str3, (i11 & 16) != 0 ? EmptyList.f10001a : list);
    }
}

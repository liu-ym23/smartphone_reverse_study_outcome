package com.stepos.ailauncher.foundation.appstore.api;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0080\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B5\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0013\u001a\u00020\u0014J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\u0011JB\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u001a\u0010\b\u001a\u0004\u0018\u00018\u00008\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/stepos/ailauncher/foundation/appstore/api/AppStoreResponse;", ExifInterface.GPS_DIRECTION_TRUE, "", "code", "", "message", "", "redirect", UxipConstants.f30680s, "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "getRedirect", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "isSuccess", "", "component1", "component2", "component3", "component4", ChatTracker.CLICK_COPY, "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Lcom/stepos/ailauncher/foundation/appstore/api/AppStoreResponse;", "equals", "other", "hashCode", "toString", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AppStoreResponse<T> {

    @SerializedName("code")
    private final int code;

    @SerializedName("message")
    private final String message;

    @SerializedName("redirect")
    private final String redirect;

    @SerializedName(UxipConstants.f30680s)
    private final T value;

    public AppStoreResponse() {
        this(0, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AppStoreResponse copy$default(AppStoreResponse appStoreResponse, int i10, String str, String str2, Object obj, int i11, Object obj2) {
        if ((i11 & 1) != 0) {
            i10 = appStoreResponse.code;
        }
        if ((i11 & 2) != 0) {
            str = appStoreResponse.message;
        }
        if ((i11 & 4) != 0) {
            str2 = appStoreResponse.redirect;
        }
        if ((i11 & 8) != 0) {
            obj = appStoreResponse.value;
        }
        return appStoreResponse.copy(i10, str, str2, obj);
    }

    /* renamed from: component1, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component3, reason: from getter */
    public final String getRedirect() {
        return this.redirect;
    }

    public final T component4() {
        return this.value;
    }

    public final AppStoreResponse<T> copy(int code, String message, String redirect, T value) {
        return new AppStoreResponse<>(code, message, redirect, value);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppStoreResponse)) {
            return false;
        }
        AppStoreResponse appStoreResponse = (AppStoreResponse) other;
        return this.code == appStoreResponse.code && p.d(this.message, appStoreResponse.message) && p.d(this.redirect, appStoreResponse.redirect) && p.d(this.value, appStoreResponse.value);
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getRedirect() {
        return this.redirect;
    }

    public final T getValue() {
        return this.value;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.code) * 31;
        String str = this.message;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.redirect;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        T t10 = this.value;
        return iHashCode3 + (t10 != null ? t10.hashCode() : 0);
    }

    public final boolean isSuccess() {
        int i10 = this.code;
        return i10 == 0 || i10 == 200;
    }

    public String toString() {
        return "AppStoreResponse(code=" + this.code + ", message=" + this.message + ", redirect=" + this.redirect + ", value=" + this.value + ")";
    }

    public AppStoreResponse(int i10, String str, String str2, T t10) {
        this.code = i10;
        this.message = str;
        this.redirect = str2;
        this.value = t10;
    }

    public /* synthetic */ AppStoreResponse(int i10, String str, String str2, Object obj, int i11, i iVar) {
        this((i11 & 1) != 0 ? 0 : i10, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? null : str2, (i11 & 8) != 0 ? null : obj);
    }
}

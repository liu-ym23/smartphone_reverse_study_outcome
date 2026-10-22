package com.android.ttcjpaysdk.verify.data;

import android.util.Base64;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u0006\u0010\r\u001a\u00020\u0006J\b\u0010\u000e\u001a\u00020\u0003H\u0016R\u0012\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/verify/data/DyVerifyGetBioTokenResponse;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "code", "", "msg", "fingerprint_pay", "", "token", "bio_ids", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "getBioIds", "", "", "isSuccess", "toString", "dy-verify-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DyVerifyGetBioTokenResponse implements CJPayObject {
    public String bio_ids;
    public String code;
    public boolean fingerprint_pay;
    public String msg;
    public String token;

    public DyVerifyGetBioTokenResponse() {
        this(null, null, false, null, null, 31, null);
    }

    public final List<Integer> getBioIds() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L16
        JSONArray r101 = new JSONArray(new String(Base64.decode(this.bio_ids, 2), Charsets.UTF_8));     // Catch: Throwable -> L16
        ArrayList r102 = new ArrayList();     // Catch: Exception -> L9 Throwable -> L16
        int r103 = r101.length();     // Catch: Exception -> L9 Throwable -> L16
        int r104 = 0;
    L4:
        if (r104 >= r103) goto L11;
        Object r105 = r101.opt(r104);     // Catch: Exception -> L9 Throwable -> L16
        if ((r105 instanceof Integer) == false) goto L8;
        r102.add(r105);     // Catch: Exception -> L9 Throwable -> L16
    L8:
        r104 = r104 + 1;
    L11:
        if (r102 == null) goto L13;
        List r106 = r102;
    L14:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L16
    L18:
        List r108 = CollectionsKt.emptyList();
        if (Result.m9455isFailureimpl(r107) == false) goto L22;
        r107 = r108;
    L22:
        return (List) r107;
    L13:
        r106 = CollectionsKt.emptyList();     // Catch: Throwable -> L16
    L9:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L16
        r102 = null;
    L16:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L18
    }

    public final boolean isSuccess() {
        if (Intrinsics.areEqual(this.code, "MP000000") == true) goto L5;
    L9:
        return false;
    L5:
        if (this.fingerprint_pay == false) goto L9;
        if ((!StringsKt.isBlank(this.token)) == false) goto L9;
        return true;
    }

    public String toString() {
        return "DyVerifyGetBioTokenResponse(code='" + this.code + "', msg='" + this.msg + "', fingerprint_pay=" + this.fingerprint_pay + ", token='" + this.token + "')";
    }

    public DyVerifyGetBioTokenResponse(String r100, String r101, boolean r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "code");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Intrinsics.checkNotNullParameter(r103, "token");
        Intrinsics.checkNotNullParameter(r104, "bio_ids");
        this.code = r100;
        this.msg = r101;
        this.fingerprint_pay = r102;
        this.token = r103;
        this.bio_ids = r104;
    }

    public /* synthetic */ DyVerifyGetBioTokenResponse(String r100, String r101, boolean r102, String r103, String r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = "";
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r105 = "";
    L11:
        if ((r110 & 4) == 0) goto L13;
        boolean r106 = false;
    L15:
        if ((r110 & 8) == 0) goto L17;
        String r107 = "";
    L19:
        if ((r110 & 16) == 0) goto L21;
        String r113 = "";
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}

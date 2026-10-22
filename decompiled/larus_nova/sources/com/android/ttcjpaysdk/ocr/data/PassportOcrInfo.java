package com.android.ttcjpaysdk.ocr.data;

import com.amap.api.services.district.DistrictSearchQuery;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004¢\u0006\u0002\u0010\tJ\u0006\u0010\n\u001a\u00020\u000bR\u0012\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/ocr/data/PassportOcrInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "name", "", "id_code", DistrictSearchQuery.KEYWORDS_COUNTRY, "id_expire_date", "birthday", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toJson", "Lorg/json/JSONObject;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PassportOcrInfo implements CJPayObject, Serializable {
    public String birthday;
    public String country;
    public String id_code;
    public String id_expire_date;
    public String name;

    public PassportOcrInfo() {
        this(null, null, null, null, null, 31, null);
    }

    public final JSONObject toJson() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        JSONObject r101 = new JSONObject();     // Catch: Throwable -> L4
        KtSafeMethodExtensionKt.safePut(r101, "name", this.name);     // Catch: Throwable -> L4
        KtSafeMethodExtensionKt.safePut(r101, "id_code", this.id_code);     // Catch: Throwable -> L4
        KtSafeMethodExtensionKt.safePut(r101, DistrictSearchQuery.KEYWORDS_COUNTRY, this.country);     // Catch: Throwable -> L4
        KtSafeMethodExtensionKt.safePut(r101, "id_expire_date", this.id_expire_date);     // Catch: Throwable -> L4
        KtSafeMethodExtensionKt.safePut(r101, "birthday", this.birthday);     // Catch: Throwable -> L4
        Object r102 = Result.m9449constructorimpl(r101);     // Catch: Throwable -> L4
    L6:
        JSONObject r103 = new JSONObject();
        if (Result.m9455isFailureimpl(r102) == false) goto L10;
        r102 = r103;
    L10:
        return (JSONObject) r102;
    L4:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public PassportOcrInfo(String r100, String r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "id_code");
        Intrinsics.checkNotNullParameter(r102, DistrictSearchQuery.KEYWORDS_COUNTRY);
        Intrinsics.checkNotNullParameter(r103, "id_expire_date");
        Intrinsics.checkNotNullParameter(r104, "birthday");
        this.name = r100;
        this.id_code = r101;
        this.country = r102;
        this.id_expire_date = r103;
        this.birthday = r104;
    }

    public /* synthetic */ PassportOcrInfo(String r100, String r101, String r102, String r103, String r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = "";
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r105 = "";
    L11:
        if ((r110 & 4) == 0) goto L13;
        String r106 = "";
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

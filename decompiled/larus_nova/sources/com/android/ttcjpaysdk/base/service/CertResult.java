package com.android.ttcjpaysdk.base.service;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0006\u0010\n\u001a\u00020\u000bR\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/CertResult;", "Ljava/io/Serializable;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "code", "", "msg", "", "data", "Lorg/json/JSONObject;", "(ILjava/lang/String;Lorg/json/JSONObject;)V", "isSuccess", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CertResult implements Serializable, CJPayObject {
    public int code;
    public JSONObject data;
    public String msg;

    public CertResult() {
        this(0, null, null, 7, null);
    }

    public final boolean isSuccess() {
        if (this.code == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public CertResult(int r100, String r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        Intrinsics.checkNotNullParameter(r102, "data");
        this.code = r100;
        this.msg = r101;
        this.data = r102;
    }

    public /* synthetic */ CertResult(int r100, String r101, JSONObject r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = new JSONObject();
    L11:
        this(r100, r101, r102);
    }
}

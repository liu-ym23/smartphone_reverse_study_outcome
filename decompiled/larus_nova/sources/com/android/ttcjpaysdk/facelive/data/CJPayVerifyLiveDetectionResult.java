package com.android.ttcjpaysdk.facelive.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002BU\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004¢\u0006\u0002\u0010\fJ\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eR\u0012\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/facelive/data/CJPayVerifyLiveDetectionResult;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "status", "", "code", "msg", "ret_status", "face_content", "face_recognition_type", "name_mask", "asynchronous_invoke_result", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "isNeedRetry", "", "isResponseOk", "bdpay-facecheck_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayVerifyLiveDetectionResult implements CJPayObject, Serializable {
    public String asynchronous_invoke_result;
    public String code;
    public String face_content;
    public String face_recognition_type;
    public String msg;
    public String name_mask;
    public String ret_status;
    public String status;

    public CJPayVerifyLiveDetectionResult() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public final boolean isNeedRetry() {
        return Intrinsics.areEqual(this.code, "MP060005");
    }

    public final boolean isResponseOk() {
        return Intrinsics.areEqual(this.code, "MP000000");
    }

    public CJPayVerifyLiveDetectionResult(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107) {
        Intrinsics.checkNotNullParameter(r100, "status");
        Intrinsics.checkNotNullParameter(r101, "code");
        Intrinsics.checkNotNullParameter(r102, "msg");
        Intrinsics.checkNotNullParameter(r103, "ret_status");
        Intrinsics.checkNotNullParameter(r104, "face_content");
        Intrinsics.checkNotNullParameter(r105, "face_recognition_type");
        Intrinsics.checkNotNullParameter(r106, "name_mask");
        Intrinsics.checkNotNullParameter(r107, "asynchronous_invoke_result");
        this.status = r100;
        this.code = r101;
        this.msg = r102;
        this.ret_status = r103;
        this.face_content = r104;
        this.face_recognition_type = r105;
        this.name_mask = r106;
        this.asynchronous_invoke_result = r107;
    }

    public /* synthetic */ CJPayVerifyLiveDetectionResult(String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, int r118, DefaultConstructorMarker r119) {
        String r100 = "";
        if ((r118 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = "";
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = "";
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = "";
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = "";
    L31:
        if ((r118 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r102, r103, r104, r105, r106, r107, r100);
        return;
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}

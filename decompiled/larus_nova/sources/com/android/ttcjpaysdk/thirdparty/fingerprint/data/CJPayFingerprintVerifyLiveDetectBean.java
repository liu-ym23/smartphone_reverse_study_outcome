package com.android.ttcjpaysdk.thirdparty.fingerprint.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002BY\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u000bJ\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u000f\u001a\u00020\rR\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/fingerprint/data/CJPayFingerprintVerifyLiveDetectBean;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "status", "", "code", "msg", "ret_status", "face_content", "face_recognition_type", "name_mask", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "isNeedRetry", "", "isResponseOK", "isVerifySuccess", "bdpay-fingerprint_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayFingerprintVerifyLiveDetectBean implements CJPayObject, Serializable {
    public String code;
    public String face_content;
    public String face_recognition_type;
    public String msg;
    public String name_mask;
    public String ret_status;
    public String status;

    public CJPayFingerprintVerifyLiveDetectBean() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public final boolean isNeedRetry() {
        return Intrinsics.areEqual("MP060005", this.code);
    }

    public final boolean isResponseOK() {
        if (Intrinsics.areEqual("MP000000", this.code) == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual("CD000000", this.code) == true) goto L8;
        return false;
    }

    public final boolean isVerifySuccess() {
        return Intrinsics.areEqual("MP000000", this.code);
    }

    public CJPayFingerprintVerifyLiveDetectBean(String r100, String r101, String r102, String r103, String r104, String r105, String r106) {
        this.status = r100;
        this.code = r101;
        this.msg = r102;
        this.ret_status = r103;
        this.face_content = r104;
        this.face_recognition_type = r105;
        this.name_mask = r106;
    }

    public /* synthetic */ CJPayFingerprintVerifyLiveDetectBean(String r100, String r101, String r102, String r110, String r111, String r112, String r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        String r116 = "";
    L7:
        if ((r114 & 2) == 0) goto L9;
        String r103 = "";
    L11:
        if ((r114 & 4) == 0) goto L13;
        String r104 = "";
    L15:
        if ((r114 & 8) == 0) goto L17;
        String r105 = "";
    L19:
        if ((r114 & 16) == 0) goto L21;
        String r106 = "";
    L23:
        if ((r114 & 32) == 0) goto L25;
        String r107 = "";
    L27:
        if ((r114 & 64) == 0) goto L29;
        String r117 = "";
    L30:
        this(r116, r103, r104, r105, r106, r107, r117);
        return;
    L29:
        r117 = r113;
        goto L30
    L25:
        r107 = r112;
        goto L27
    L21:
        r106 = r111;
        goto L23
    L17:
        r105 = r110;
        goto L19
    L13:
        r104 = r102;
        goto L15
    L9:
        r103 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L7
    }
}

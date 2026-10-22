package com.android.ttcjpaysdk.verify.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.bytedance.android.ec.core.event.a;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0005B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/verify/data/DyVerifyQueryCertRes;", "Lcom/android/ttcjpaysdk/verify/data/DyVerifyCertBaseRes;", "cert_info", "Lcom/android/ttcjpaysdk/verify/data/DyVerifyQueryCertRes$DyVerifyCertInfo;", "(Lcom/android/ttcjpaysdk/verify/data/DyVerifyQueryCertRes$DyVerifyCertInfo;)V", "DyVerifyCertInfo", "dy-verify-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DyVerifyQueryCertRes extends DyVerifyCertBaseRes {
    public DyVerifyCertInfo cert_info;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004¢\u0006\u0002\u0010\tJ\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u000e\u001a\u00020\u000bR\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/verify/data/DyVerifyQueryCertRes$DyVerifyCertInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "cert_dn", "", "cert_sn", "expire_time", "", a.KEY_DID, "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "isEqual", "", "dn", "sn", "isValid", "dy-verify-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class DyVerifyCertInfo implements CJPayObject, Serializable {
        public String cert_dn;
        public String cert_sn;
        public String did;
        public long expire_time;

        public DyVerifyCertInfo() {
            this(null, null, 0, null, 15, null);
        }

        public final boolean isValid() {
            String r100 = this.cert_sn;
            if (r100 != null) goto L5;
            return false;
        L5:
            if ((!StringsKt.isBlank(r100)) != true) goto L9;
            return true;
        L9:
            return false;
        }

        public final boolean isEqual(String r100, String r101) {
            if (isValid() == true) goto L5;
        L7:
            return false;
        L5:
            if (Intrinsics.areEqual(this.cert_sn, r101) == false) goto L7;
            return true;
        }

        public DyVerifyCertInfo(String r100, String r101, long r102, String r103) {
            Intrinsics.checkNotNullParameter(r103, a.KEY_DID);
            this.cert_dn = r100;
            this.cert_sn = r101;
            this.expire_time = r102;
            this.did = r103;
        }

        public /* synthetic */ DyVerifyCertInfo(String r100, String r101, long r102, String r103, int r110, DefaultConstructorMarker r111) {
            if ((r110 & 1) == 0) goto L5;
            String r112 = "";
        L7:
            if ((r110 & 2) == 0) goto L9;
            String r104 = "";
        L11:
            if ((r110 & 4) == 0) goto L13;
            r102 = 0;
        L13:
            long r105 = r102;
            if ((r110 & 8) == 0) goto L16;
            String r113 = "";
        L17:
            this(r112, r104, r105, r113);
            return;
        L16:
            r113 = r103;
            goto L17
        L9:
            r104 = r101;
            goto L11
        L5:
            r112 = r100;
            goto L7
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DyVerifyQueryCertRes() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public DyVerifyQueryCertRes(DyVerifyCertInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "cert_info");
        super(null, null, null, 7, null);
        this.cert_info = r100;
    }

    public /* synthetic */ DyVerifyQueryCertRes(DyVerifyCertInfo r100, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        r100 = new DyVerifyCertInfo(null, null, 0, null, 15, null);
    L5:
        this(r100);
    }
}

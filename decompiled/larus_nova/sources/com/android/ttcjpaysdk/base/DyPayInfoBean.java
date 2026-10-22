package com.android.ttcjpaysdk.base;

import com.android.ttcjpaysdk.integrated.counter.outerpay.CJOuterPayManager;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\u0006\u0010\u000b\u001a\u00020\u0003R\u0012\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/base/DyPayInfoBean;", "Ljava/io/Serializable;", "pay_source", "", "token", CJOuterPayManager.KEY_DY_PAY_VERSION, "version", "appName", "pkgName", "appId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getOuterVersion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DyPayInfoBean implements Serializable {
    public String appId;
    public String appName;
    public String dypay_version;
    public String pay_source;
    public String pkgName;
    public String token;
    public String version;

    public DyPayInfoBean() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public final String getOuterVersion() {
        if (this.dypay_version.length() <= 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L9;
        return this.dypay_version;
    L9:
        return this.version;
    L5:
        r100 = false;
        goto L6
    }

    public DyPayInfoBean(String r100, String r101, String r102, String r103, String r104, String r105, String r106) {
        Intrinsics.checkNotNullParameter(r100, "pay_source");
        Intrinsics.checkNotNullParameter(r101, "token");
        Intrinsics.checkNotNullParameter(r102, CJOuterPayManager.KEY_DY_PAY_VERSION);
        Intrinsics.checkNotNullParameter(r103, "version");
        Intrinsics.checkNotNullParameter(r104, "appName");
        Intrinsics.checkNotNullParameter(r105, "pkgName");
        Intrinsics.checkNotNullParameter(r106, "appId");
        this.pay_source = r100;
        this.token = r101;
        this.dypay_version = r102;
        this.version = r103;
        this.appName = r104;
        this.pkgName = r105;
        this.appId = r106;
    }

    public /* synthetic */ DyPayInfoBean(String r100, String r101, String r102, String r110, String r111, String r112, String r113, int r114, DefaultConstructorMarker r115) {
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

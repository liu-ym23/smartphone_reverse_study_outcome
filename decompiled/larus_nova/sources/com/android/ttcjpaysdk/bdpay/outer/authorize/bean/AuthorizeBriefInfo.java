package com.android.ttcjpaysdk.bdpay.outer.authorize.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/outer/authorize/bean/AuthorizeBriefInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "display_desc", "", "display_url", "(Ljava/lang/String;Ljava/lang/String;)V", "bdpay-outer-authorize_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AuthorizeBriefInfo implements CJPayObject, Serializable {
    public String display_desc;
    public String display_url;

    /* JADX WARN: Multi-variable type inference failed */
    public AuthorizeBriefInfo() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public AuthorizeBriefInfo(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "display_desc");
        Intrinsics.checkNotNullParameter(r101, "display_url");
        this.display_desc = r100;
        this.display_url = r101;
    }

    public /* synthetic */ AuthorizeBriefInfo(String r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = "";
    L8:
        this(r100, r101);
    }
}

package com.android.ttcjpaysdk.base.settings.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004¢\u0006\u0002\u0010\tR\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/CJPayJhInfoBean;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "jh_merchant_id", "", "jh_app_id", "source", "tea_sourch_ntv", "tea_sourch_lynx", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayJhInfoBean implements CJPayObject, Serializable {
    public String jh_app_id;
    public String jh_merchant_id;
    public String source;
    public String tea_sourch_lynx;
    public String tea_sourch_ntv;

    public CJPayJhInfoBean() {
        this(null, null, null, null, null, 31, null);
    }

    public CJPayJhInfoBean(String r100, String r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "jh_merchant_id");
        Intrinsics.checkNotNullParameter(r101, "jh_app_id");
        Intrinsics.checkNotNullParameter(r102, "source");
        Intrinsics.checkNotNullParameter(r103, "tea_sourch_ntv");
        Intrinsics.checkNotNullParameter(r104, "tea_sourch_lynx");
        this.jh_merchant_id = r100;
        this.jh_app_id = r101;
        this.source = r102;
        this.tea_sourch_ntv = r103;
        this.tea_sourch_lynx = r104;
    }

    public /* synthetic */ CJPayJhInfoBean(String r100, String r101, String r102, String r103, String r104, int r105, DefaultConstructorMarker r110) {
        if ((r105 & 1) == 0) goto L6;
        r100 = "1200003766";
    L6:
        if ((r105 & 2) == 0) goto L8;
        r101 = "800037665481";
    L8:
        String r111 = r101;
        if ((r105 & 4) == 0) goto L11;
        r102 = "wallet_bcard_manage_add";
    L11:
        String r106 = r102;
        if ((r105 & 8) == 0) goto L14;
        r103 = "wallet_bcard_manage_add_ntv";
    L14:
        String r107 = r103;
        if ((r105 & 16) == 0) goto L17;
        r104 = "wallet_bcard_manage_add_lynx";
    L17:
        String r108 = r100;
        this(r108, r111, r106, r107, r104);
    }
}

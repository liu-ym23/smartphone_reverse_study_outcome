package com.android.ttcjpaysdk.base.service.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/bean/WxH5PayEnableConfig;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "open_from", "", "enable", "", "(Ljava/lang/String;Z)V", "isEnable", "openFrom", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WxH5PayEnableConfig implements CJPayObject, Serializable {
    public boolean enable;
    public String open_from;

    /* JADX WARN: Multi-variable type inference failed */
    public WxH5PayEnableConfig() {
        String r100 = null;
        this(r100, false, 3, 0 == true ? 1 : 0);
    }

    public final boolean isEnable(String r100) {
        Intrinsics.checkNotNullParameter(r100, "openFrom");
        if (this.enable == true) goto L5;
    L9:
        return false;
    L5:
        if (Intrinsics.areEqual(r100, this.open_from) == false) goto L9;
        if ((!StringsKt.isBlank(r100)) == false) goto L9;
        return true;
    }

    public WxH5PayEnableConfig(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "open_from");
        this.open_from = r100;
        this.enable = r101;
    }

    public /* synthetic */ WxH5PayEnableConfig(String r100, boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = false;
    L8:
        this(r100, r101);
    }
}

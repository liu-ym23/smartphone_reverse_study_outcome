package com.android.ttcjpaysdk.base.h5.utils;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\u0006\u0010\r\u001a\u00020\u000eR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/utils/WxH5PayUseAnnieXConfig;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", KtvSubElement.CONTAINER, "", "schema_host", "(Ljava/lang/String;Ljava/lang/String;)V", "getContainer", "()Ljava/lang/String;", "setContainer", "(Ljava/lang/String;)V", "getSchema_host", "setSchema_host", "useAnnieX", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WxH5PayUseAnnieXConfig implements CJPayObject, Serializable {
    private String container;
    private String schema_host;

    /* JADX WARN: Multi-variable type inference failed */
    public WxH5PayUseAnnieXConfig() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public final boolean useAnnieX() {
        if (Intrinsics.areEqual("anniex", this.container) == true) goto L5;
    L7:
        return false;
    L5:
        if ((!StringsKt.isBlank(this.schema_host)) == false) goto L7;
        return true;
    }

    public final String getContainer() {
        return this.container;
    }

    public final String getSchema_host() {
        return this.schema_host;
    }

    public final void setContainer(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.container = r100;
    }

    public final void setSchema_host(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.schema_host = r100;
    }

    public WxH5PayUseAnnieXConfig(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r101, "schema_host");
        this.container = r100;
        this.schema_host = r101;
    }

    public /* synthetic */ WxH5PayUseAnnieXConfig(String r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = "";
    L8:
        this(r100, r101);
    }
}

package com.android.ttcjpaysdk.base.ktextension;

import android.graphics.Paint;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"setMyFakeBoldText", "Landroid/graphics/Paint;", "isFakeBoldText", "", "cj-host-service-api_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class CJPayCanvasExtensionKt {
    public static final Paint setMyFakeBoldText(Paint r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.setFakeBoldText(r101);
        return r100;
    }
}

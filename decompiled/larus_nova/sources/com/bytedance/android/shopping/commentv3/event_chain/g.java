package com.bytedance.android.shopping.commentv3.event_chain;

import com.bytedance.android.ecom.arch.slice.BaseSlice;
import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class g {
    public static final Map<?, ?> a(EventContext r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getIncomingData");
        Map<String, ? extends Object> r101 = r100.f251278k;
        Object r102 = null;
        if (r101 == null) goto L5;
        Object r103 = r101.get("incoming_data");
    L7:
        if ((r103 instanceof Map) == false) goto L11;
        r102 = r103;
    L11:
        return (Map) r102;
    L5:
        r103 = null;
        goto L7
    }

    public static final String b(EventContext r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getSliceId");
        Map<String, ? extends Object> r101 = r100.f251278k;
        if (r101 == null) goto L7;
        Object r102 = r101.get(BaseSlice.KEY_SLICE_ID);
        if (r102 == null) goto L7;
        String r103 = r102.toString();
    L8:
        if (r103 != null) goto L10;
    L13:
        boolean r104 = true;
    L14:
        if (r104 == false) goto L17;
        return null;
    L17:
        return r103;
    L10:
        if (r103.length() == 0) goto L13;
        r104 = false;
    L7:
        r103 = null;
        goto L8
    }
}

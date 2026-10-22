package com.bytedance.android.ecom.arch.slice.utils;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"str2Num", "", "version", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
public final class SlcVersionUtil$version2Number$1 extends Lambda implements Function1<String, Integer> {
    public static final SlcVersionUtil$version2Number$1 INSTANCE = null;

    static {
        INSTANCE = new SlcVersionUtil$version2Number$1();
    }

    public SlcVersionUtil$version2Number$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2(String r110) {
        if (r110 != null) goto L5;
    L8:
        boolean r100 = true;
    L9:
        if (r100 == false) goto L11;
        return 0;
    L11:
        Integer r101 = StringsKt.toIntOrNull(r110);
        if (r101 != null) goto L24;
        if (StringsKt.contains$default(r110, "-", false, 2, null) == false) goto L25;
        List r111 = StringsKt.split$default(r110, new String[]{"-"}, false, 0, 6, null);
        if (CollectionsKt.getLastIndex(r111) < 0) goto L18;
        Object r112 = ListProtector.get(r111, 0);
    L19:
        Integer r113 = StringsKt.toIntOrNull((String) r112);
        if (r113 != null) goto L22;
        return 0;
    L22:
        return r113.intValue();
    L18:
        r112 = "0";
        goto L19
    L25:
        return 0;
    L24:
        return r101.intValue();
    L5:
        if (StringsKt.isBlank(r110) == true) goto L8;
        r100 = false;
        goto L9
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Integer invoke(String r100) {
        return Integer.valueOf(invoke2(r100));
    }
}

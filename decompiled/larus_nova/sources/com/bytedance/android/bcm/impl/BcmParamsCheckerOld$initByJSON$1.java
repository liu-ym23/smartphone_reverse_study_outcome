package com.bytedance.android.bcm.impl;

import com.bytedance.android.bcm.impl.model.e;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class BcmParamsCheckerOld$initByJSON$1 extends Lambda implements Function0<String> {
    public static final BcmParamsCheckerOld$initByJSON$1 INSTANCE = null;

    static {
        INSTANCE = new BcmParamsCheckerOld$initByJSON$1();
    }

    public BcmParamsCheckerOld$initByJSON$1() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        StringBuilder r100 = new StringBuilder("initByJSON, length: ");
        boolean r101 = BcmParamsCheckerOld.f41780a;
        List<e> r102 = BcmParamsCheckerOld.f41783d.a().a();
        if (r102 == null) goto L5;
        Integer r103 = Integer.valueOf(r102.size());
    L6:
        r100.append(r103);
        return r100.toString();
    L5:
        r103 = null;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }
}

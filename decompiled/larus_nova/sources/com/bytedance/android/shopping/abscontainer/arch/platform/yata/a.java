package com.bytedance.android.shopping.abscontainer.arch.platform.yata;

import android.content.Context;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonHandleSchemaUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a extends com.bytedance.android.shopping.yata.ability.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f164211c;

    @Override // com.bytedance.android.shopping.yata.ability.b, v96.e
    public final void openSchema(String r100) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        int r101 = SkuCommonHandleSchemaUtils.f182770a;
        SkuCommonHandleSchemaUtils.b(getContext(), r100, this.f164211c, null, 112);
    }

    public a(Context r100, boolean r101, Function0<? extends PageFinder> r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "pageFinderMethod");
        super(r100, r102);
        this.f164211c = r101;
    }
}

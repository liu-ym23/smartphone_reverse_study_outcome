package com.bytedance.android.live.revenue.common.player.vendor.link;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class RevSeiFrame$layoutTypeIndex$2 extends FunctionReferenceImpl implements Function0<Integer> {
    public RevSeiFrame$layoutTypeIndex$2(RevSeiFrame r100) {
        super(0, r100, RevSeiFrame.class, "parseLayoutTypeIndex", "parseLayoutTypeIndex()I", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2() {
        return StringsKt.indexOf$default(((RevSeiFrame) this.receiver).C, "layout_type", 0, false, 6, null);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Integer invoke() {
        return Integer.valueOf(invoke2());
    }
}

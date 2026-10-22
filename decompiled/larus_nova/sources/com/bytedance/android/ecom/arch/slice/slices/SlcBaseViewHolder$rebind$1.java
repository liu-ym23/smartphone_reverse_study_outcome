package com.bytedance.android.ecom.arch.slice.slices;

import com.bytedance.android.livesdk.dsl.api.DSLType;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/ecom/arch/slice/g;", DSLType.Slice, "", AbsMethodDelegate.TAG_INVOKE, "()Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class SlcBaseViewHolder$rebind$1 extends Lambda implements Function0<String> {
    public static final SlcBaseViewHolder$rebind$1 INSTANCE = null;

    static {
        INSTANCE = new SlcBaseViewHolder$rebind$1();
    }

    public SlcBaseViewHolder$rebind$1() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        return "SlcViewHolder rebindv1: slice is null";
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }
}

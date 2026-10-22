package com.bytedance.android.live.profit.dress.config;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/live/profit/dress/config/s;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/live/profit/dress/config/s;)Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class RolePropConfigKt$describe$2 extends Lambda implements Function1<s, String> {
    public static final RolePropConfigKt$describe$2 INSTANCE = null;

    static {
        INSTANCE = new RolePropConfigKt$describe$2();
    }

    public RolePropConfigKt$describe$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(s r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(s r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return RolePropConfigKt.a(r100);
    }
}

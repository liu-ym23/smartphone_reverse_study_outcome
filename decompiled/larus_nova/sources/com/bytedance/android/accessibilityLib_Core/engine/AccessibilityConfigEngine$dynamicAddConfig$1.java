package com.bytedance.android.accessibilityLib_Core.engine;

import com.bytedance.android.accessibilityLib_Core.config.base.IBaseConfig;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/bytedance/android/accessibilityLib_Core/config/base/IBaseConfig;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 1})
final class AccessibilityConfigEngine$dynamicAddConfig$1 extends Lambda implements Function1<IBaseConfig, Unit> {
    public static final AccessibilityConfigEngine$dynamicAddConfig$1 INSTANCE = null;

    static {
        INSTANCE = new AccessibilityConfigEngine$dynamicAddConfig$1();
    }

    public AccessibilityConfigEngine$dynamicAddConfig$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(IBaseConfig r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(IBaseConfig r100) {
        if (r100 == null) goto L5;
        AccessibilityConfigEngine.c(r100);
        return;
    }
}

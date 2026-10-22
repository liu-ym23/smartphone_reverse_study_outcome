package com.bytedance.android.accessibilityLib_Core.base.api;

import com.bytedance.android.accessibilityLib_Core.tool.d;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/bytedance/android/accessibilityLib_Core/tool/d;", AbsMethodDelegate.TAG_INVOKE, "()Lcom/bytedance/android/accessibilityLib_Core/tool/d;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
final class AbstractAccessibilityLibIsolation$AccessibilityLibGlobalLayoutListener$frequencyTrigger$2 extends Lambda implements Function0<d> {
    public static final AbstractAccessibilityLibIsolation$AccessibilityLibGlobalLayoutListener$frequencyTrigger$2 INSTANCE = null;

    static {
        INSTANCE = new AbstractAccessibilityLibIsolation$AccessibilityLibGlobalLayoutListener$frequencyTrigger$2();
    }

    public AbstractAccessibilityLibIsolation$AccessibilityLibGlobalLayoutListener$frequencyTrigger$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final d invoke() {
        return new d(30000, 2);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ d invoke() {
        return invoke();
    }
}

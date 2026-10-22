package com.bytedance.android.accessibilityLib_Core.config.base;

import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.bytedance.android.accessibilityLib_Core.config.bean.ViewVirtualNode;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/bytedance/android/accessibilityLib_Core/config/bean/ViewVirtualNode;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 1})
final class AbstractBaseConfig$setDesc$1 extends Lambda implements Function1<ViewVirtualNode, Unit> {
    final /* synthetic */ String $desc;
    final /* synthetic */ int $id;

    public AbstractBaseConfig$setDesc$1(int r100, String r101) {
        this.$id = r100;
        this.$desc = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ViewVirtualNode r100) {
        r100.f38152b = Integer.valueOf(this.$id);
        String r101 = this.$desc;
        ((AccessibilityNodeInfoCompat) r100.f38154d.getValue()).setContentDescription(r101);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ViewVirtualNode r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}

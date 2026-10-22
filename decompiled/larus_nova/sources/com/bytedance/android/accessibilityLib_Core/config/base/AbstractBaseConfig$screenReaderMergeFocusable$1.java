package com.bytedance.android.accessibilityLib_Core.config.base;

import android.content.Context;
import com.bytedance.android.accessibilityLib_Core.config.bean.ViewVirtualNode;
import com.bytedance.android.accessibilityLib_Core.config.remote.dsl.h;
import com.bytedance.android.accessibilityLib_Core.helper.a;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/bytedance/android/accessibilityLib_Core/config/bean/ViewVirtualNode;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 1})
final class AbstractBaseConfig$screenReaderMergeFocusable$1 extends Lambda implements Function1<ViewVirtualNode, Unit> {
    final /* synthetic */ h[] $hideExcludeFocus;
    final /* synthetic */ int $id;
    final /* synthetic */ AbstractBaseConfig this$0;

    public AbstractBaseConfig$screenReaderMergeFocusable$1(AbstractBaseConfig r100, int r101, h[] r102) {
        this.this$0 = r100;
        this.$id = r101;
        this.$hideExcludeFocus = r102;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ViewVirtualNode r100) {
        Context r101 = a.f38277a;
        r100.f38152b = Integer.valueOf(this.$id);
        boolean r102 = true;
        r100.f38164n = true;
        h[] r103 = this.$hideExcludeFocus;
        r100.f38158h = r103;
        if (r103 != null) goto L6;
        r102 = false;
    L6:
        r100.f38164n = r102;
        new StringBuilder("config for screen read end，now the virtualNodeInfo = ").append(this.this$0.getVirtualNode());
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ViewVirtualNode r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}

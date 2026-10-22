package com.bytedance.android.accessibilityLib_Core.config.base;

import android.content.Context;
import com.bytedance.android.accessibilityLib_Core.config.bean.a;
import com.bytedance.android.accessibilityLib_Core.config.bean.b;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/accessibilityLib_Core/config/bean/b;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/accessibilityLib_Core/config/bean/b;)V", "<anonymous>"}, k = 3, mv = {1, 4, 1})
final class AbstractBaseConfig$visitAllChildrenInRootTree$1 extends Lambda implements Function1<b, Unit> {
    final /* synthetic */ Function1 $action;

    public AbstractBaseConfig$visitAllChildrenInRootTree$1(Function1 r100) {
        this.$action = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(b r100) {
        StringBuilder r101 = new StringBuilder("visit child node : config name ");
        a r102 = r100.f38171a;
        String r103 = null;
        if (r102 == null) goto L5;
        IBaseConfig r104 = r102.f38170a;
    L6:
        if (r104 == null) goto L8;
        r103 = r104.name();
    L8:
        r101.append(r103);
        if (r101.toString() == null) goto L11;
        Context r105 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L11:
        this.$action.invoke(r100);
        return;
    L5:
        r104 = null;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(b r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}

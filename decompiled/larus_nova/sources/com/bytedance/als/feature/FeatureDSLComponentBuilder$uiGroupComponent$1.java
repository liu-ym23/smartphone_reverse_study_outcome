package com.bytedance.als.feature;

import android.os.SystemClock;
import com.bytedance.als.dsl.ComponentNothingBuilder;
import com.bytedance.als.ui.group.UIGroupLogicComponent;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.objectcontainer.ObjectContainer;
import e6.b;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\b\u001a\u00028\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000\"\u0010\b\u0001\u0010\u0003\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/bytedance/als/b;", "API_COMPONENT", "Lcom/bytedance/als/ui/group/UIGroupLogicComponent;", "LOGIC_COMPONENT", "Lcom/bytedance/objectcontainer/ObjectContainer;", "it", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/objectcontainer/ObjectContainer;)Lcom/bytedance/als/ui/group/UIGroupLogicComponent;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
public final class FeatureDSLComponentBuilder$uiGroupComponent$1 extends Lambda implements Function1<ObjectContainer, UIGroupLogicComponent<Object>> {
    final /* synthetic */ ComponentNothingBuilder $builder;
    final /* synthetic */ Function2 $init;
    final /* synthetic */ a this$0;

    public FeatureDSLComponentBuilder$uiGroupComponent$1(a r100, Function2 r101, ComponentNothingBuilder r102) {
        this.$init = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final UIGroupLogicComponent<Object> invoke2(ObjectContainer r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        int r101 = b.f471103a;
        SystemClock.uptimeMillis();
        UIGroupLogicComponent r102 = (UIGroupLogicComponent) this.$init.invoke(null, r100);
        throw null;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ UIGroupLogicComponent<Object> invoke(ObjectContainer r100) {
        return invoke2(r100);
    }
}

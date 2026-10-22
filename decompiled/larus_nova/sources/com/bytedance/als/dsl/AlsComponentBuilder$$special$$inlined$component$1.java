package com.bytedance.als.dsl;

import android.os.SystemClock;
import com.bytedance.als.lazy.ALSInternalLazyHelperComponent;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.objectcontainer.ObjectContainer;
import e6.b;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\t\u001a\u00028\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000\"\u0010\b\u0001\u0010\u0003\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/als/b;", "API_COMPONENT", "Lcom/bytedance/als/LogicComponent;", "LOGIC_COMPONENT", "Lcom/bytedance/objectcontainer/ObjectContainer;", "it", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/objectcontainer/ObjectContainer;)Lcom/bytedance/als/LogicComponent;", "com/bytedance/als/dsl/AlsComponentBuilder$component$1", "<anonymous>"}, k = 3, mv = {1, 4, 1})
public final class AlsComponentBuilder$$special$$inlined$component$1 extends Lambda implements Function1<ObjectContainer, ALSInternalLazyHelperComponent> {
    final /* synthetic */ ComponentNothingBuilder $builder;
    final /* synthetic */ AlsComponentBuilder this$0;

    public AlsComponentBuilder$$special$$inlined$component$1(AlsComponentBuilder r100, ComponentNothingBuilder r101) {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ALSInternalLazyHelperComponent invoke2(ObjectContainer r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        int r101 = b.f471103a;
        SystemClock.uptimeMillis();
        new ALSInternalLazyHelperComponent(r100);
        throw null;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.bytedance.als.LogicComponent, com.bytedance.als.lazy.ALSInternalLazyHelperComponent] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ALSInternalLazyHelperComponent invoke(ObjectContainer r100) {
        return invoke2(r100);
    }
}

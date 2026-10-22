package com.bytedance.als.dsl;

import android.os.SystemClock;
import com.bytedance.als.ui.UIPanelComponent;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.objectcontainer.ObjectContainer;
import e6.b;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\r\u001a\u00028\u0004\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000\"\u0016\b\u0001\u0010\u0003\u0018\u0001*\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0002\"\b\b\u0002\u0010\u0005*\u00020\u0004\"\b\b\u0003\u0010\u0006*\u00020\u0004\"\"\b\u0004\u0010\b\u0018\u0001*\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00072\u0006\u0010\n\u001a\u00020\tH\n¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lcom/bytedance/als/b;", "API_COMPONENT", "Lcom/bytedance/als/ui/UIScene;", "SCENE", "", "STATE", "ACTION", "Lcom/bytedance/als/ui/UIPanelComponent;", "LOGIC_COMPONENT", "Lcom/bytedance/objectcontainer/ObjectContainer;", "it", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/objectcontainer/ObjectContainer;)Lcom/bytedance/als/ui/UIPanelComponent;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
public final class AlsComponentBuilder$panelUIComponent$1 extends Lambda implements Function1<ObjectContainer, UIPanelComponent<Object, Object, Object, Object>> {
    final /* synthetic */ ComponentNothingBuilder $builder;
    final /* synthetic */ Function2 $init;
    final /* synthetic */ AlsComponentBuilder this$0;

    public AlsComponentBuilder$panelUIComponent$1(AlsComponentBuilder r100, Function2 r101, ComponentNothingBuilder r102) {
        this.$init = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final UIPanelComponent<Object, Object, Object, Object> invoke2(ObjectContainer r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        int r101 = b.f471103a;
        SystemClock.uptimeMillis();
        UIPanelComponent r102 = (UIPanelComponent) this.$init.invoke(null, r100);
        throw null;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ UIPanelComponent<Object, Object, Object, Object> invoke(ObjectContainer r100) {
        return invoke2(r100);
    }
}

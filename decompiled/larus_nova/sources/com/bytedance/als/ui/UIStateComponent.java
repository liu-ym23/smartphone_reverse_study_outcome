package com.bytedance.als.ui;

import com.bytedance.als.LogicComponent;
import com.bytedance.als.b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u0003*\b\b\u0002\u0010\u0005*\u00020\u00032\b\u0012\u0004\u0012\u00028\u00000\u00062\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/als/ui/UIStateComponent;", "Lcom/bytedance/als/b;", "API_COMPONENT", "", "STATE", "ACTION", "Lcom/bytedance/als/LogicComponent;", "<init>", "()V", "als_release"}, k = 1, mv = {1, 4, 1})
public abstract class UIStateComponent<API_COMPONENT extends b, STATE, ACTION> extends LogicComponent<API_COMPONENT> implements b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final UIStateComponent f38098c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f38099d;

    public abstract Function0<STATE> j();

    public UIStateComponent() {
        this.f38098c = this;
        this.f38099d = LazyKt.lazy(new UIStateComponent$sceneStatesContainer$2(this));
    }

    @Override // com.bytedance.als.LogicComponent
    public final API_COMPONENT i() {
        return this.f38098c;
    }
}

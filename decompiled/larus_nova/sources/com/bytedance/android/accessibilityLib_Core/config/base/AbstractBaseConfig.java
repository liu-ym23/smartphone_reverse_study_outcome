package com.bytedance.android.accessibilityLib_Core.config.base;

import com.bytedance.android.accessibilityLib_Core.base.AccessiblityScope;
import com.bytedance.android.accessibilityLib_Core.config.bean.ViewVirtualNode;
import com.bytedance.android.accessibilityLib_Core.config.bean.b;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes43.dex */
public abstract class AbstractBaseConfig implements IBaseConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f38148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f38149b;

    @Override // com.bytedance.android.accessibilityLib_Core.config.base.IBaseConfig
    public boolean enableLargeTouchArea() {
        return true;
    }

    @Override // com.bytedance.android.accessibilityLib_Core.config.base.IBaseConfig
    public final ViewVirtualNode getVirtualNode() {
        return (ViewVirtualNode) this.f38148a.getValue();
    }

    @Override // com.bytedance.android.accessibilityLib_Core.config.base.IBaseConfig
    public int layoutRoot() {
        return -1;
    }

    @Override // com.bytedance.android.accessibilityLib_Core.config.base.IBaseConfig
    public String name() {
        return "default";
    }

    public AbstractBaseConfig() {
        this.f38148a = LazyKt.lazy(AbstractBaseConfig$virtualNode$2.INSTANCE);
        this.f38149b = new b(this);
    }

    @Override // com.bytedance.android.accessibilityLib_Core.config.base.IBaseConfig
    public final void build() {
        int r100 = layoutRoot();
        ViewVirtualNode r101 = getVirtualNode();
        r101.f38151a = Integer.valueOf(r100);
        config(getVirtualNode());
    }

    @Override // com.bytedance.android.accessibilityLib_Core.config.base.IBaseConfig
    public AccessiblityScope getScope() {
        return AccessiblityScope.View;
    }
}

package com.bytedance.android.live.profile.ui.base;

import com.bytedance.android.live.base.model.user.NewProfileUser;
import kotlin.Deprecated;
import kotlin.ReplaceWith;

/* JADX INFO: loaded from: classes47.dex */
public abstract class a extends k {
    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    @Deprecated(message = "请使用BusinessOpenAreaDescription的canLoad方法", replaceWith = @ReplaceWith(expression = "BusinessOpenAreaDescription.canLoad", imports = {}))
    public final void f() {
    }

    @Override // com.bytedance.android.live.profile.ui.base.k
    public final void h() {
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public abstract /* synthetic */ void update(NewProfileUser r100);

    @Override // com.bytedance.android.live.profile.ui.base.g
    public ComponentType getComponentType() {
        return new ComponentType.BusinessOpenArea(null, null, 3, null);
    }

    public a() {
    }
}

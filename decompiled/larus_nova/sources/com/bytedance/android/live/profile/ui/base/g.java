package com.bytedance.android.live.profile.ui.base;

import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileSkin;

/* JADX INFO: loaded from: classes47.dex */
public interface g {
    void b(d r100);

    void d(NewProfileUser r100);

    void e(ProfileSkin r100);

    void f();

    void g(NewProfileUser r100);

    ComponentType getComponentType();

    void onComponentDestroy();

    void update(NewProfileUser r100);
}

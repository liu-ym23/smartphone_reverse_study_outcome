package com.bytedance.android.live.profile.ui.component.base;

import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import kotlin.jvm.internal.Intrinsics;
import ut0.f;

/* JADX INFO: loaded from: classes47.dex */
public interface e<T> {

    public static final class a {
        public static void a(NewProfileUser r100, f r101) {
            Intrinsics.checkNotNullParameter(r100, "user");
            Intrinsics.checkNotNullParameter(r101, "logUseCase");
        }

        public static <T> void update(e<T> r100, T r101, NewProfileUser r102) {
            Intrinsics.checkNotNullParameter(r102, "user");
        }
    }

    void a(T r100, NewProfileUser r101, f r102);

    void c(T r100, NewProfileUser r101);

    void d(T r100, ProfileSkin r101);

    void e(T r100);

    void update(T r100, NewProfileUser r101);
}

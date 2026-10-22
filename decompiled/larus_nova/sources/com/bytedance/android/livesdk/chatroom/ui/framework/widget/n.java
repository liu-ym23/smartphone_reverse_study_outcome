package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.content.res.Configuration;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.livesdk.ability.IAbility;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public interface n extends IAbility {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Configuration f113445a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f113446b;

        public a(Configuration r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "newConfig");
            this.f113445a = r100;
            this.f113446b = r101;
        }
    }

    PropertyOwner sa();
}

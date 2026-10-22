package com.bytedance.android.live.profile.profilecontext;

import com.bytedance.android.live.profile.ui.base.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class d {
    public static final void a(Object r100, h r101) {
        Intrinsics.checkNotNullParameter(r101, "profileContext");
        Intrinsics.checkNotNullParameter(r101, "$this$injectTo");
        if ((r100 instanceof c) == false) goto L6;
        ((c) r100).setProfileContext(r101);
        return;
    }
}

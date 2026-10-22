package com.bytedance.android.ec.core.arch.lifecycle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class g {
    public static final LifecycleOwner a(QContext r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$viewLifecycleOwner");
        Fragment r101 = r100.f450890a;
        if (r101 == null) goto L7;
        LifecycleOwner r102 = r101.getViewLifecycleOwner();
        if (r102 == null) goto L7;
        return r102;
    L7:
        return r100.e();
    }
}

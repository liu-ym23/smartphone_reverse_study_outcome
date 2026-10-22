package com.bytedance.android.livesdk.interactivity.comment.newinput.framework;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f135512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f135513b;

    public j(View r100, g r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "bridges");
        this.f135512a = r100;
        this.f135513b = r101;
    }
}

package com.bytedance.android.live.openplatform.impl.miniappanchor.debug;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f84362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View.OnClickListener f84363b;

    public c(a r100) {
        Intrinsics.checkNotNullParameter("扫描", "title");
        Intrinsics.checkNotNullParameter(r100, "onItemClickListener");
        this.f84362a = "";
        this.f84362a = "扫描";
        this.f84363b = r100;
    }
}

package com.bytedance.android.gamecp.business.download.recovery;

import com.bytedance.android.gamecp.common.setting.config.q0;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f52913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedList<Long> f52914b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q0 f52915c;

    public c(q0 r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f52915c = r100;
        this.f52914b = new LinkedList();
    }
}

package com.bytedance.android.shopping.anchorv4.log;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f167060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f167061b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f167062c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f167063d;

    public static final class a {
    }

    static {
    }

    public final Object getIdentifier() {
        return this.f167061b;
    }

    public e(d r100, Object r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "visibleWatcher");
        Intrinsics.checkNotNullParameter(r101, LocationMonitorConst.IDENTIFIER);
        this.f167060a = r100;
        this.f167061b = r101;
        this.f167062c = false;
        this.f167063d = r102;
    }
}

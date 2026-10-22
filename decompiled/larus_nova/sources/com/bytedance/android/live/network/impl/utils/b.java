package com.bytedance.android.live.network.impl.utils;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f83923c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Scene f83924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PATH f83925b;

    public static final class a {
        public static void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            ALogger.i("LiveApiRetryLogger", r100);
        }
    }

    static {
    }

    public b(Scene r100, PATH r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "path");
        this.f83924a = r100;
        this.f83925b = r101;
    }
}

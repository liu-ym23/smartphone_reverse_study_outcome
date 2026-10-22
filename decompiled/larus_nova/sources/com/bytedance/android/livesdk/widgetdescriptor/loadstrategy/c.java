package com.bytedance.android.livesdk.widgetdescriptor.loadstrategy;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f162401a = 0;

    static {
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        ALogger.i("ttlive_descriptor_load_new", "name:DescriptorLoadInorderStrategy, msg:" + r100);
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        ALogger.i("ttlive_descriptor_load_new", "name:DescriptorLoadTogetherStrategy, msg:".concat(r100));
    }
}

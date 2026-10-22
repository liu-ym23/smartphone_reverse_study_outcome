package com.bytedanceos.appstore.buss.network.ad;

import com.bytedanceos.appstore.buss.network.base.BaseHttpEngine;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes2.dex */
public final class AdHttpEngine extends BaseHttpEngine {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AdHttpEngine f8783b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f8784c = null;

    static {
        f8783b = new AdHttpEngine();
        f8784c = kotlin.b.b(AdHttpEngine$service$2.INSTANCE);
    }

    public AdHttpEngine() {
    }

    public static final /* synthetic */ Object e(AdHttpEngine r10, Class r11, String r12) {
        return r10.c(r11, r12);
    }

    public final AdService f() {
        return (AdService) f8784c.getValue();
    }
}

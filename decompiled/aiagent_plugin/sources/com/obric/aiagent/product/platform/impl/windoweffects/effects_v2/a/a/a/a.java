package com.obric.aiagent.product.platform.impl.windoweffects.effects_v2.a.a.a;

import android.content.res.Resources;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;

/* JADX INFO: compiled from: DisplayUnits.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final f f18912a = null;

    /* JADX INFO: renamed from: lambda$jAurzKYSd8fJWF9pEZFXQ-tHRm4, reason: not valid java name */
    public static /* synthetic */ float m245lambda$jAurzKYSd8fJWF9pEZFXQtHRm4() {
        return b();
    }

    static {
        f18912a = g.a($$Lambda$a$jAurzKYSd8fJWF9pEZFXQtHRm4.INSTANCE);
    }

    public static final float a() {
        return ((Number) ZeusTransformUtils.preCheckCast(f18912a.b(), Number.class, "com.obric.aiagent.plugin")).floatValue();
    }

    private static final float b() {
        return Resources.getSystem().getDisplayMetrics().density;
    }

    public static final float a(float r1) {
        return r1 * a();
    }
}

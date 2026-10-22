package com.obric.autoaction.vdplayer.components.cursor;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlinx.coroutines.b.ab;
import kotlinx.coroutines.b.ad;
import kotlinx.coroutines.b.j;
import kotlinx.coroutines.b.w;

/* JADX INFO: compiled from: VDPlayerEffectEventBus.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f25391a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final w<c> f25392b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ab<c> f25393c = null;

    private d() {
    }

    static {
        f25391a = new d();
        w<c> r0 = ad.a(0, 64, null, 4, null);
        f25392b = r0;
        f25393c = j.a(r0);
    }

    public final ab<c> a() {
        return f25393c;
    }

    public final void a(String r2, List<Float> r3, List<Float> r4) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        f25392b.a(new c(r2, r1, r5));
    }
}

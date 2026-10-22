package com.bytedance.android.shopping.prepurchase.arch.exposure;

import com.baidu.platform.comapi.map.MapController;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class j implements h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f180896d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<l, c> f180897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f180898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f180899c;

    public static final class a {
    }

    static {
        f180896d = new c(0, 0);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.exposure.h
    public final c a(l r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        c r101 = (c) ((LinkedHashMap) this.f180897a).get(r100);
        c r102 = f180896d;
        if (r101 != null) goto L9;
        r101 = this.f180898b.a(r100);
        Map<l, c> r103 = this.f180897a;
        if (r101 != null) goto L7;
        c r104 = r102;
    L8:
        r103.put(r100, r104);
        goto L9
    L7:
        r104 = r101;
    L9:
        f r105 = this.f180899c;
        if (r105 == null) goto L13;
        r105.d("Exposure", "getExposureInfo view=" + r100 + " impression=" + r101);
    L13:
        if (Intrinsics.areEqual(r101, r102) == false) goto L16;
        return null;
    L16:
        return r101;
    }

    public j(h r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
        this.f180898b = r100;
        this.f180899c = r101;
        this.f180897a = new LinkedHashMap();
    }
}

package com.bytedance.android.livesdk.livecommerce.promotion.card;

import com.ss.android.cert.manager.constants.EventConstant;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes10.dex */
public final class k implements Iterable<Map.Entry<? extends PromotionCardModuleName, ? extends IPromotionUIConfig.d>>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<PromotionCardModuleName, IPromotionUIConfig.d> f150096a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f150096a, ((k) r100).f150096a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        Map<PromotionCardModuleName, IPromotionUIConfig.d> r100 = this.f150096a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "UIConfigModel(config=" + this.f150096a + ")";
    }

    @Override // java.lang.Iterable
    public final Iterator<Map.Entry<? extends PromotionCardModuleName, ? extends IPromotionUIConfig.d>> iterator() {
        return this.f150096a.entrySet().iterator();
    }

    public k(Map<PromotionCardModuleName, IPromotionUIConfig.d> r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f150096a = r100;
    }

    public final IPromotionUIConfig.d a(PromotionCardModuleName r100) {
        Intrinsics.checkNotNullParameter(r100, EventConstant.Key.MODULE);
        return this.f150096a.get(r100);
    }
}

package com.bytedance.android.livesdk.ktvimpl.base.sei;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes10.dex */
public final class l implements Iterable<Pair<? extends String, ? extends Class<? extends com.bytedance.android.livesdk.ktvimpl.base.sei.a>>>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Pair<String, Class<? extends com.bytedance.android.livesdk.ktvimpl.base.sei.a>>> f143316a;

    public final class a implements Iterator<Pair<? extends String, ? extends Class<? extends com.bytedance.android.livesdk.ktvimpl.base.sei.a>>>, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f143317a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l f143318b;

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f143317a >= ((ArrayList) this.f143318b.f143316a).size()) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public final Pair<? extends String, ? extends Class<? extends com.bytedance.android.livesdk.ktvimpl.base.sei.a>> next() {
            List<Pair<String, Class<? extends com.bytedance.android.livesdk.ktvimpl.base.sei.a>>> r100 = this.f143318b.f143316a;
            int r101 = this.f143317a;
            this.f143317a = r101 + 1;
            return (Pair) ListProtector.get(r100, r101);
        }

        public a(l r100) {
            this.f143318b = r100;
        }
    }

    @Override // java.lang.Iterable
    public final Iterator<Pair<? extends String, ? extends Class<? extends com.bytedance.android.livesdk.ktvimpl.base.sei.a>>> iterator() {
        return new a(this);
    }

    public l() {
        this.f143316a = new ArrayList();
    }

    public final <T extends com.bytedance.android.livesdk.ktvimpl.base.sei.a> void a(String r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        List<Pair<String, Class<? extends com.bytedance.android.livesdk.ktvimpl.base.sei.a>>> r102 = this.f143316a;
        ArrayList r103 = (ArrayList) r102;
        r103.add(TuplesKt.to(r100, r101));
    }
}

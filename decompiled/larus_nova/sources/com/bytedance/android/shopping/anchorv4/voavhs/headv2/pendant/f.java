package com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant;

import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderPendantModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderPendantNative;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public abstract class f implements b<HeaderPendantNative> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f169883b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HeaderPendantModel f169884a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.b
    public void a(boolean r100) {
    }

    public void b(HeaderPendantNative r100) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.b
    public void c(boolean r100) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.b
    public void d(boolean r100, int r101) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.b
    public final void e() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.b
    public final void f(boolean r100) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.b
    public final void h(boolean r100) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.b
    public void o() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.b
    public final void onDestroy() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.pendant.b
    public void onPageSelected(int r100) {
    }

    public f(HeaderPendantModel r100) {
        Intrinsics.checkNotNullParameter(r100, "pendantModel");
        this.f169884a = r100;
        PendantType r101 = PendantType.TYPE_NATIVE;
    }

    public /* bridge */ /* synthetic */ void g(Object r100) {
        b((HeaderPendantNative) r100);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.o
    public final /* bridge */ /* synthetic */ void l(Object r100, int r101, Integer r102) {
        HeaderPendantNative r103 = (HeaderPendantNative) r100;
    }
}

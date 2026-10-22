package com.bytedance.android.shopping.utils.gallery;

import com.bytedance.android.shopping.utils.r;
import com.bytedance.android.ui.ec.widget.photodraweeview.OnDismissListener;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class f implements OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECGalleryActivity f187126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f187127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f187128c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ List f187129d;

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.OnDismissListener
    public final void onDismiss(int r100) {
        ECGalleryActivity r101 = this.f187126a;
        int r102 = ECGalleryActivity.f187097m;
        r101.getClass();
        int r103 = r.f187157a;
        Intrinsics.checkNotNullParameter("willDismiss", "type");
        this.f187126a.finish();
    }

    public f(ECGalleryActivity r100, List r101, List r102, List r103) {
        this.f187126a = r100;
        this.f187127b = r101;
        this.f187128c = r102;
        this.f187129d = r103;
    }
}

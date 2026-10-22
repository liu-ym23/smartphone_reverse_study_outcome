package com.bytedance.android.shopping.utils.gallery;

import com.bytedance.android.shopping.utils.r;
import com.bytedance.android.ui.ec.widget.photodraweeview.OnPageSelectedListener;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class g implements OnPageSelectedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECGalleryActivity f187130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f187131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f187132c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ List f187133d;

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.OnPageSelectedListener
    public final void onPageSelected(int r100) {
        this.f187130a.f187099k = r100;
        int r101 = r.f187157a;
        Intrinsics.checkNotNullParameter("didSwipe", "type");
    }

    public g(ECGalleryActivity r100, List r101, List r102, List r103) {
        this.f187130a = r100;
        this.f187131b = r101;
        this.f187132c = r102;
        this.f187133d = r103;
    }
}

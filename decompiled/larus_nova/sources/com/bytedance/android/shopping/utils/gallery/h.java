package com.bytedance.android.shopping.utils.gallery;

import android.content.DialogInterface;
import com.bytedance.android.shopping.utils.r;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class h implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECGalleryActivity f187134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f187135b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f187136c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ List f187137d;

    public h(ECGalleryActivity r100, List r101, List r102, List r103) {
        this.f187134a = r100;
        this.f187135b = r101;
        this.f187136c = r102;
        this.f187137d = r103;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r100) {
        int r101 = r.f187157a;
        int r102 = this.f187134a.f187099k;
        Intrinsics.checkNotNullParameter("willDismiss", "type");
        this.f187134a.finish();
    }
}

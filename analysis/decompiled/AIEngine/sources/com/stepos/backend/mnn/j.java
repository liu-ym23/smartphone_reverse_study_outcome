package com.stepos.backend.mnn;

import android.graphics.Bitmap;
import android.graphics.Point;
import com.stepos.backend.mnn.MnnImageInpaintModel;
import com.stepos.backend.mnn.MnnInteractiveSegmentModel;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class j implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5984a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bitmap f5985b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MnnModelBase f5986c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f5987d;

    public /* synthetic */ j(MnnModelBase mnnModelBase, Bitmap bitmap, Object obj, int i10) {
        this.f5984a = i10;
        this.f5986c = mnnModelBase;
        this.f5985b = bitmap;
        this.f5987d = obj;
    }

    @Override // zb.a
    public final Object invoke() {
        switch (this.f5984a) {
            case 0:
                return MnnImageInpaintModel.AnonymousClass1.invokeSuspend$lambda$2$lambda$1((MnnImageInpaintModel) this.f5986c, this.f5985b, (Bitmap) this.f5987d);
            default:
                return MnnInteractiveSegmentModel.AnonymousClass1.invokeSuspend$lambda$3((MnnInteractiveSegmentModel) this.f5986c, this.f5985b, (Point[]) this.f5987d);
        }
    }
}

package com.stepos.backend.mnn;

import android.graphics.Bitmap;
import android.graphics.Point;
import com.stepos.backend.mnn.MnnImageInpaintModel;
import com.stepos.backend.mnn.MnnInteractiveSegmentModel;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class i implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5980a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bitmap f5981b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MnnModelBase f5982c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f5983d;

    public /* synthetic */ i(MnnModelBase mnnModelBase, Bitmap bitmap, Object obj, int i10) {
        this.f5980a = i10;
        this.f5982c = mnnModelBase;
        this.f5981b = bitmap;
        this.f5983d = obj;
    }

    @Override // zb.a
    public final Object invoke() {
        switch (this.f5980a) {
            case 0:
                return MnnImageInpaintModel.AnonymousClass1.invokeSuspend$lambda$2((MnnImageInpaintModel) this.f5982c, this.f5981b, (Bitmap) this.f5983d);
            default:
                return MnnInteractiveSegmentModel.AnonymousClass1.invokeSuspend$lambda$3$lambda$2((MnnInteractiveSegmentModel) this.f5982c, this.f5981b, (Point[]) this.f5983d);
        }
    }
}

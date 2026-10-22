package com.bytedance.android.annie.service.business.latch;

import android.content.Context;
import android.net.Uri;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.lynx.tasm.LynxView;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements IAnnieBusinessLatchService {

    /* JADX INFO: renamed from: com.bytedance.android.annie.service.business.latch.a$a, reason: collision with other inner class name */
    public static final class C0745a implements IAnnieBusinessLatchService.b {
        public C0745a() {
        }

        @Override // com.bytedance.android.annie.service.business.latch.IAnnieBusinessLatchService.b
        public final void X0(IHybridComponent r100) {
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return true;
        }

        @Override // com.bytedance.android.annie.service.business.latch.IAnnieBusinessLatchService.b
        public final void Y0(LynxView r100) {
            Intrinsics.checkNotNullParameter(r100, "lynxView");
        }
    }

    public a() {
    }

    @Override // com.bytedance.android.annie.service.business.latch.IAnnieBusinessLatchService
    public final void P0(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "schema");
    }

    @Override // com.bytedance.android.annie.service.business.latch.IAnnieBusinessLatchService
    public final void d(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
    }

    @Override // com.bytedance.android.annie.service.business.latch.IAnnieBusinessLatchService
    public final String i(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        return null;
    }

    @Override // com.bytedance.android.annie.service.business.latch.IAnnieBusinessLatchService
    public final int w1(Context r100, String r101, Uri r102, IAnnieBusinessLatchService.a r103) {
        Intrinsics.checkNotNullParameter(r102, "schema");
        Intrinsics.checkNotNullParameter(r103, "latchProcessOptions");
        return -1;
    }

    @Override // com.bytedance.android.annie.service.business.latch.IAnnieBusinessLatchService
    public final Pair<IAnnieBusinessLatchService.PrefetchStrategy, String> k(Uri r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter(r101, "url");
        return new Pair(IAnnieBusinessLatchService.PrefetchStrategy.Nothing, "annie is not ready.");
    }

    @Override // com.bytedance.android.annie.service.business.latch.IAnnieBusinessLatchService
    public final IAnnieBusinessLatchService.a e(long r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "display");
        Intrinsics.checkNotNullParameter(r102, "errMsg");
        return new IAnnieBusinessLatchService.a();
    }

    @Override // com.bytedance.android.annie.service.business.latch.IAnnieBusinessLatchService
    public final IAnnieBusinessLatchService.b C0(Context r100, String r101, String r102, Uri r103, long r104, IAnnieBusinessLatchService.a r105, boolean r106) {
        Intrinsics.checkNotNullParameter(r101, "originUrl");
        Intrinsics.checkNotNullParameter(r102, ST.UUID_DEVICE);
        Intrinsics.checkNotNullParameter(r103, "schema");
        Intrinsics.checkNotNullParameter(r105, "latchProcessOptions");
        return new C0745a();
    }
}

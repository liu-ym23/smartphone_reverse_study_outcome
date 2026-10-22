package com.bytedance.android.shopping.prepurchase.business.pdp.util;

import android.net.Uri;
import com.bytedance.android.ec.sdk.helper.q;
import com.bytedance.android.shopping.anchorv4.data.AnchorV4DataManager;
import com.bytedance.android.shopping.anchorv4.data.k;
import com.bytedance.android.shopping.service.c;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.DelayKt;
import vg3.f0;

/* JADX INFO: loaded from: classes13.dex */
public final class BottomNavigationToaster {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f0 f182193a;

    public BottomNavigationToaster(f0 r100) {
        this.f182193a = r100;
    }

    public final void a(String r100) {
        Uri.Builder r101 = UriProtector.parse(r100).buildUpon();
        k r102 = AnchorV4DataManager.f166335a;
        r101.appendQueryParameter(LocationMonitorConst.IDENTIFIER, AnchorV4DataManager.f166338d);
        f0 r103 = this.f182193a;
        if (r103 == null) goto L5;
        r103.openSchema(r101.build().toString());
    L5:
        q.f48131a.e("detail_last_show_add_cart_popup", System.currentTimeMillis());
    }

    public final Object b(boolean r100, String r110, long r111, Continuation<? super Unit> r112) {
        if ((r112 instanceof BottomNavigationToaster$showCartEntranceVideo$1) == false) goto L7;
        BottomNavigationToaster$showCartEntranceVideo$1 r101 = (BottomNavigationToaster$showCartEntranceVideo$1) r112;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r113 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        r100 = r101.Z$0;
        r110 = (String) r101.L$1;
        BottomNavigationToaster r114 = (BottomNavigationToaster) r101.L$0;
        ResultKt.throwOnFailure(r113);
    L44:
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L40
        if (r100 == false) goto L36;
        r114.a(r110);     // Catch: Throwable -> L40
    L38:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L40
    L43:
        return Unit.INSTANCE;
    L36:
        if (c.f182609b.f182610a == false) goto L38;
        r114.a(r110);     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L43
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        if (r110 == null) goto L17;
        Ref.LongRef r117 = new Ref.LongRef();
        r117.element = 0;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L21
        r117.element = q.f48131a.getLong("detail_last_show_add_cart_popup", 0);     // Catch: Throwable -> L21
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L21
    L24:
        if ((System.currentTimeMillis() - r117.element) <= 86400000) goto L26;
        boolean r118 = true;
    L27:
        if (r118 == false) goto L43;
        r101.L$0 = this;
        r101.L$1 = r110;
        r101.Z$0 = r100;
        r101.label = 1;
        if (DelayKt.delay(r111, r101) != r103) goto L31;
        return r103;
    L31:
        r114 = this;
        goto L44
    L26:
        r118 = false;
    L21:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L24
    L17:
        return Unit.INSTANCE;
    L7:
        r101 = new BottomNavigationToaster$showCartEntranceVideo$1(this, r112);
        goto L8
    }
}

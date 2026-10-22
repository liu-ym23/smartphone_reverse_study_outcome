package com.bytedance.android.livesdk.chatroom.ssposter.util;

import android.graphics.Bitmap;
import com.bytedance.android.livehostapi.business.depend.share.IViewLoadCallback;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"onSuccess", "", SimplayerImageStrategy.RESULT_BITMAP, "Landroid/graphics/Bitmap;", AbsMethodDelegate.TAG_INVOKE, "com/bytedance/android/livesdk/chatroom/ssposter/util/BaseQrCodeShareHelper$startLoading$4$1"}, k = 3, mv = {1, 4, 3})
public final class BaseQrCodeShareHelper$startLoading$$inlined$forEach$lambda$3 extends Lambda implements Function1<Bitmap, Unit> {
    final /* synthetic */ e $originalPicInfo;
    final /* synthetic */ BaseQrCodeShareHelper this$0;

    public BaseQrCodeShareHelper$startLoading$$inlined$forEach$lambda$3(e r100, BaseQrCodeShareHelper r101) {
        this.$originalPicInfo = r100;
        this.this$0 = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Bitmap r100) {
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        e r101 = this.$originalPicInfo;
        if (r101.f111597c != null) goto L42;
        r101.f111597c = r100;
        CopyOnWriteArrayList<m> r102 = this.this$0.f111535e;
        ArrayList r103 = new ArrayList();
        Iterator<m> r104 = r102.iterator();
    L5:
        boolean r105 = false;
        if (r104.hasNext() == false) goto L12;
        m r106 = r104.next();
        if (r106.f111618a != this.$originalPicInfo.f111595a) goto L10;
        r105 = true;
    L10:
        if (r105 == false) goto L5;
        r103.add(r106);
        goto L5
    L12:
        Iterator r107 = r103.iterator();
    L14:
        if (r107.hasNext() == false) goto L21;
        m r108 = (m) r107.next();
        this.this$0.c(r108.f111619b, r100, r108.f111621d);
        i r109 = r108.f111620c;
        r109.getClass();
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        if (r109.f111608c == true) goto L14;
        r109.f111608c = true;
        IViewLoadCallback r110 = r109.f111609d;
        if (r110 == null) goto L14;
        r110.onOriginalPicLoadSuccess(r100);
        goto L14
    L21:
        if (BaseQrCodeShareHelper.b(this.this$0) == false) goto L28;
        BaseQrCodeShareHelper r111 = this.this$0;
        r111.f111537g = 0;
        Iterator<m> r112 = r111.f111535e.iterator();
    L24:
        if (r112.hasNext() == false) goto L26;
        r112.next().f111620c.b();
        goto L24
    L26:
        this.this$0.l();
        return;
    L28:
        if (this.this$0.d(this.$originalPicInfo.f111595a) == false) goto L63;
        CopyOnWriteArrayList<m> r113 = this.this$0.f111535e;
        ArrayList r114 = new ArrayList();
        Iterator<m> r115 = r113.iterator();
    L31:
        if (r115.hasNext() == false) goto L38;
        m r116 = r115.next();
        if (r116.f111618a != this.$originalPicInfo.f111595a) goto L35;
        boolean r117 = true;
    L36:
        if (r117 == false) goto L31;
        r114.add(r116);
        goto L31
    L35:
        r117 = false;
        goto L36
    L38:
        Iterator r118 = r114.iterator();
    L40:
        if (r118.hasNext() == false) goto L64;
        ((m) r118.next()).f111620c.b();
        goto L40
    L64:
        return;
    L63:
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Bitmap r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}

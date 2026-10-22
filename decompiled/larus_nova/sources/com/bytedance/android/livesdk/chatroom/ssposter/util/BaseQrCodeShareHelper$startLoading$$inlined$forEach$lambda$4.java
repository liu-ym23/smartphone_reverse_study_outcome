package com.bytedance.android.livesdk.chatroom.ssposter.util;

import com.bytedance.android.livehostapi.business.depend.share.IViewLoadCallback;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"onFail", "", AbsMethodDelegate.TAG_INVOKE, "com/bytedance/android/livesdk/chatroom/ssposter/util/BaseQrCodeShareHelper$startLoading$4$2"}, k = 3, mv = {1, 4, 3})
public final class BaseQrCodeShareHelper$startLoading$$inlined$forEach$lambda$4 extends Lambda implements Function0<Unit> {
    final /* synthetic */ e $originalPicInfo;
    final /* synthetic */ BaseQrCodeShareHelper this$0;

    public BaseQrCodeShareHelper$startLoading$$inlined$forEach$lambda$4(e r100, BaseQrCodeShareHelper r101) {
        this.$originalPicInfo = r100;
        this.this$0 = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        BaseQrCodeShareHelper r100 = this.this$0;
        boolean r101 = false;
        if (r100.f111537g == 1) goto L5;
    L34:
        CopyOnWriteArrayList<m> r102 = r100.f111535e;
        ArrayList r103 = new ArrayList();
        Iterator<m> r104 = r102.iterator();
    L36:
        if (r104.hasNext() == false) goto L43;
        m r105 = r104.next();
        if (r105.f111618a != this.$originalPicInfo.f111595a) goto L40;
        boolean r106 = true;
    L41:
        if (r106 == false) goto L36;
        r103.add(r105);
        goto L36
    L40:
        r106 = false;
        goto L41
    L43:
        Iterator r107 = r103.iterator();
    L45:
        if (r107.hasNext() == false) goto L72;
        ((m) r107.next()).f111620c.b();
        goto L45
    L72:
        return;
    L5:
        if (this.$originalPicInfo.f111597c != null) goto L34;
        CopyOnWriteArrayList<m> r108 = r100.f111535e;
        ArrayList r109 = new ArrayList();
        Iterator<m> r110 = r108.iterator();
    L8:
        if (r110.hasNext() == false) goto L15;
        m r111 = r110.next();
        if (r111.f111618a != this.$originalPicInfo.f111595a) goto L12;
        boolean r112 = true;
    L13:
        if (r112 == false) goto L8;
        r109.add(r111);
        goto L8
    L12:
        r112 = false;
        goto L13
    L15:
        Iterator r113 = r109.iterator();
    L17:
        if (r113.hasNext() == false) goto L25;
        i r114 = ((m) r113.next()).f111620c;
        if (r114.f111606a == true) goto L17;
        if (r114.f111607b == true) goto L17;
        r114.f111607b = true;
        IViewLoadCallback r115 = r114.f111609d;
        if (r115 == null) goto L17;
        r115.onLoadFail();
        goto L17
    L25:
        Iterator<m> r116 = this.this$0.f111535e.iterator();
    L27:
        if (r116.hasNext() == false) goto L31;
        if (r116.next().f111620c.a() == true) goto L27;
    L32:
        if (r101 == false) goto L47;
        BaseQrCodeShareHelper r117 = this.this$0;
        r117.f111537g = 2;
        r117.l();
        return;
    L47:
        return;
    L31:
        r101 = true;
        goto L32
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}

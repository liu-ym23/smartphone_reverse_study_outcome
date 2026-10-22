package com.bytedance.android.btm.impl.page.unknown;

import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.model.BufferBtm;
import com.bytedance.android.btm.impl.setting.BtmSetting;
import com.bytedance.android.btm.impl.util.BtmFormatUtils;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class UnionBufferQueue {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static UnionBufferBtm f42386a;

    static {
    }

    public static boolean a(final UnionData r100) {
        if (BtmSetting.f42469d.c().c().L() == 1) goto L5;
        return false;
    L5:
        ALogger.l(ALogger.f41996d, "UnionBufferQueue_consume", new UnionBufferQueue$consumeUnionBuffer$1(r100));
        if (r100.getUnionStep() <= 0) goto L8;
        return false;
    L8:
        UnionBufferBtm r101 = f42386a;
        if (r101 != null) goto L11;
        r100.setUnionStep(1);
        r100.setUnionPre(null);
        return false;
    L11:
        if (Intrinsics.areEqual(r101.getPageId(), r100.getPageId()) == false) goto L13;
        return false;
    L13:
        r100.setUnionStep(r101.getUnionStep() + 1);
        r100.setUnionPre(r101.getBtm());
        if ((r100 instanceof UnknownPageInfo) == true) goto L16;
        r100 = null;
    L16:
        UnknownPageInfo r102 = (UnknownPageInfo) r100;
        if (r102 == null) goto L19;
        r102.setBufferBtm(r101.getBufferBtm());
    L19:
        return true;
    }

    public static void b(final UnionData r100, final BufferBtm r101) {
        BtmSetting r102 = BtmSetting.f42469d;
        if (r102.c().c().L() == 1) goto L5;
        return;
    L5:
        ALogger.l(ALogger.f41996d, "UnionBufferQueue_set", new UnionBufferQueue$setUnionBuffer$1(r100, r101));
        if (r100.getUnionStep() < 1) goto L30;
        String r103 = r100.getPageBtm();
        if (r103 != null) goto L10;
    L13:
        boolean r104 = true;
    L14:
        if (r104 == true) goto L31;
        Lazy r105 = BtmFormatUtils.f42489a;
        String r106 = r100.getPageBtm();
        if (r106 != null) goto L19;
        Intrinsics.throwNpe();
    L19:
        String r107 = BtmFormatUtils.a(r106);
        if ((r100 instanceof UnknownPageInfo) == false) goto L22;
        ((UnknownPageInfo) r100).getMountBtmIds().add(r107);
    L22:
        Lazy r108 = UnionChainRecorder.f42387a;
        String r109 = r100.getUnionPre();
        if (r102.c().c().L() != 1) goto L28;
        if (r107 == null) goto L28;
        if (r109 == null) goto L28;
        UnionChainRecorder.f42390d.put(r107, r109);
    L28:
        f42386a = new UnionBufferBtm(r107, r100.getUnionStep(), r100.getPageId(), r101);
        return;
    L31:
        return;
    L10:
        if (r103.length() == 0) goto L13;
        r104 = false;
        goto L14
    }
}

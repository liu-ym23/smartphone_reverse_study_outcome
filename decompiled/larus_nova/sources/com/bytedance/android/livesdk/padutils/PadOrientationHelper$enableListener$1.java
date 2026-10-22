package com.bytedance.android.livesdk.padutils;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.nova.R;
import com.ss.android.download.api.constant.BaseConstants;
import j40.f4;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class PadOrientationHelper$enableListener$1 extends Lambda implements Function0<Unit> {
    public static final PadOrientationHelper$enableListener$1 INSTANCE = null;

    static {
        INSTANCE = new PadOrientationHelper$enableListener$1();
    }

    public PadOrientationHelper$enableListener$1() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        a r100 = b.f154213a;
        e<Long> r101 = f4.f497203f;
        Long r102 = r101.getValue();
        long r103 = System.currentTimeMillis();
        if (r102 == null) goto L11;
        if (r102.longValue() != (-1)) goto L11;
        if (PadConfigUtils.e(s1.getContext()) == true) goto L11;
        f.d(r101, Long.valueOf(r103));
    L16:
        boolean r104 = true;
    L18:
        if (r104 == true) goto L20;
        return;
    L20:
        c.a(s1.B(R.string.ttlive_pad_rotate_toast));
        return;
    L11:
        if ((r103 - r102.longValue()) >= BaseConstants.Time.DAY) goto L14;
    L17:
        r104 = false;
        goto L18
    L14:
        if (PadConfigUtils.e(s1.getContext()) == true) goto L17;
        f.d(r101, Long.valueOf(r103));
        goto L16
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}

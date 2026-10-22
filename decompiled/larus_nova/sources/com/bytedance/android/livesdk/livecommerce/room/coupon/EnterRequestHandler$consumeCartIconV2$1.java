package com.bytedance.android.livesdk.livecommerce.room.coupon;

import com.bytedance.android.ec.model.response.IconItem;
import com.bytedance.android.ec.model.response.LottieIconData;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"checkCartAnimIsValid", "", "icon", "Lcom/bytedance/android/ec/model/response/IconItem;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final class EnterRequestHandler$consumeCartIconV2$1 extends Lambda implements Function1<IconItem, Boolean> {
    public static final EnterRequestHandler$consumeCartIconV2$1 INSTANCE = null;

    static {
        INSTANCE = new EnterRequestHandler$consumeCartIconV2$1();
    }

    public EnterRequestHandler$consumeCartIconV2$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(IconItem r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (cg4.a.a(r100.getAnimatedIcon()) == true) goto L11;
        LottieIconData r101 = r100.getLottieIcon();
        if (r101 != null) goto L10;
        return false;
    L10:
        if (r101.isValid() == true) goto L11;
        return false;
    L11:
        return true;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(IconItem r100) {
        return Boolean.valueOf(invoke2(r100));
    }
}

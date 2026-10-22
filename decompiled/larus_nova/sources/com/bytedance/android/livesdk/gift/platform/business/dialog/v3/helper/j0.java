package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import com.bytedance.android.livesdk.gift.model.GiftMsgBoard;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.l2;
import com.bytedance.android.livesdk.gift.model.w1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class j0 {
    public static final boolean a(h1 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isBigGift");
        if (r100.getType() != 2) goto L5;
        return true;
    L5:
        if (r100.getType() != 8) goto L7;
        return true;
    L7:
        if (r100.getType() != 4) goto L9;
        return true;
    L9:
        if (r100.getType() == 13) goto L16;
        return false;
    L16:
        return true;
    }

    public static final boolean b(AbsPanel<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isBigPanel");
        Object r101 = r100.f126620h;
        if ((r101 instanceof h1) == true) goto L5;
        Object r102 = null;
    L6:
        h1 r103 = (h1) r102;
        if (r103 == null) goto L11;
        return a(r103);
    L11:
        if ((r101 instanceof l2) == true) goto L13;
        r101 = null;
    L13:
        l2 r104 = (l2) r101;
        if (r104 == null) goto L24;
        Intrinsics.checkNotNullParameter(r104, "$this$isBigProp");
        if (r104.getGift().getType() != 2) goto L18;
    L22:
        return true;
    L18:
        if (r104.getGift().getType() == 8) goto L22;
        if (r104.getGift().getType() == 4) goto L22;
        return false;
    L24:
        return false;
    L5:
        r102 = r101;
        goto L6
    }

    public static final boolean c(AbsPanel<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isMessageBoardPanel");
        Object r101 = r100.f126620h;
        if ((r101 instanceof h1) == true) goto L5;
        r101 = null;
    L5:
        h1 r102 = (h1) r101;
        if (r102 == null) goto L11;
        Intrinsics.checkNotNullParameter(r102, "$this$isMessageBoardGift");
        GiftMsgBoard r103 = r102.getGiftMsgBoard();
        if (r103 != null) goto L10;
        return false;
    L10:
        return r103.forMsgBoard;
    L11:
        return false;
    }

    public static final w1 d(w1 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$provideMainGiftPageWithClone");
        w1 r101 = (w1) vh7.f.c(w1.class);
        r101.setPageType(r100.getPageType());
        r101.setPageName(r100.getPageName());
        r101.setGifts(r100.getGifts());
        r101.setDisplay(r100.getDisplay());
        r101.setEventName(r100.getEventName());
        r101.setTopicList(r100.getTopicList());
        r101.setPageSortStrategy(r100.getPageSortStrategy());
        r101.setBackgroundImage(r100.getBackgroundImage());
        r101.setPageInfo(r100.getPageInfo());
        r101.setReceiversModBg(r100.getReceiversModBg());
        r101.setReceiversLongModBg(r100.getReceiversLongModBg());
        r101.setSectionList(r100.getSectionList());
        r101.setBaseGifts(r100.getBaseGifts());
        r101.setPageNameStyleInfo(r100.getPageNameStyleInfo());
        r101.setLynxConfig(r100.getLynxConfig());
        return r101;
    }

    public static final boolean e(h1 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$shouldLockGiftStatus");
        if (r100.getGiftPreviewInfo() == null) goto L11;
        com.bytedance.android.livesdk.gift.model.k0 r101 = r100.getGiftPreviewInfo();
        if (r101 == null) goto L11;
        if (r101.getLockStatus() != com.bytedance.android.livesdk.gift.model.k0.LOCKED_GRAY) goto L11;
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == true) goto L11;
        return true;
    L11:
        return false;
    }

    public static final boolean f(h1 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$shouldLockNormal");
        if (r100.getGiftPreviewInfo() == null) goto L11;
        com.bytedance.android.livesdk.gift.model.k0 r101 = r100.getGiftPreviewInfo();
        if (r101 == null) goto L11;
        if (r101.getLockStatus() != com.bytedance.android.livesdk.gift.model.k0.LOCKED_NORMAL) goto L11;
        if (com.bytedance.android.livesdk.gift.platform.core.utils.u.r() == true) goto L11;
        return true;
    L11:
        return false;
    }
}

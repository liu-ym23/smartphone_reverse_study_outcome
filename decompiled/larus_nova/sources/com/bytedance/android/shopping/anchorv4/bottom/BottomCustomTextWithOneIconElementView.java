package com.bytedance.android.shopping.anchorv4.bottom;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextWithOneIconElementView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/bottom/BottomCustomTextWithOneIconElementView;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/elements/TextWithOneIconElementView;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BottomCustomTextWithOneIconElementView extends TextWithOneIconElementView {
    public BottomCustomTextWithOneIconElementView(Context r100) {
        this(r100, null, 0, null, 30);
    }

    public BottomCustomTextWithOneIconElementView(Context r100, AttributeSet r101) {
        this(r100, r101, 0, null, 28);
    }

    public BottomCustomTextWithOneIconElementView(Context r100, AttributeSet r101, int r102) {
        this(r100, r101, r102, null, 24);
    }

    public final void d(String r110) {
        Intrinsics.checkNotNullParameter(r110, "data");
        TextWithOneIconElement r100 = getDescriptionVO();
        if (r100 == null) goto L10;
        TextElement r101 = r100.getContent();
        if (r101 == null) goto L11;
        TextElement r111 = TextElement.copy$default(r101, null, null, r110, null, null, null, null, null, 0, null, 1019, null);
        if (r111 == null) goto L12;
        getTextElementView().x(r111);
        return;
    L12:
        return;
    L11:
        return;
    }

    public BottomCustomTextWithOneIconElementView(Context r100, AttributeSet r110, int r111, String r112, int r113) {
        if ((r113 & 2) == 0) goto L5;
        AttributeSet r101 = null;
    L7:
        if ((r113 & 4) == 0) goto L9;
        int r102 = 0;
    L11:
        if ((r113 & 16) == 0) goto L13;
        String r103 = null;
    L14:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, null, r103);
        return;
    L13:
        r103 = r112;
        goto L14
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}

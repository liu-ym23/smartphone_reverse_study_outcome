package com.bytedance.android.live.profit.privilege.datalayer;

import com.bytedance.android.live.base.model.message.ITextPieceImage;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.b5;
import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.android.live.profit.privilege.model.touch.GiftPanelEntranceDetail;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b {
    public static final a5 a(List<? extends com.bytedance.android.live.profit.privilege.model.touch.n> r100) {
        if ((!r100.isEmpty()) == true) goto L6;
        return null;
    L6:
        StringBuilder r101 = new StringBuilder();
        b5 r102 = (b5) vh7.f.c(b5.class);
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r100.iterator();
        int r105 = 0;
    L8:
        if (r104.hasNext() == false) goto L31;
        com.bytedance.android.live.profit.privilege.model.touch.n r106 = (com.bytedance.android.live.profit.privilege.model.touch.n) r104.next();
        int r107 = r106.getRichTextType();
        if (r107 == GiftPanelEntranceDetail.RichTextType.RichTextTypeText.getValue()) goto L11;
        if (r107 != GiftPanelEntranceDetail.RichTextType.RichTextTypeImg.getValue()) goto L8;
        py.k r108 = r106.getImg();
        if (r108 == null) goto L8;
        r101.append("{" + r105 + ":image}");
        vh7.c r109 = vh7.f.c(c5.class);
        c5 r110 = (c5) r109;
        r110.setType(15);
        ITextPieceImage r111 = (ITextPieceImage) vh7.f.c(ITextPieceImage.class);
        r111.setImageModel(r108);
        Unit r112 = Unit.INSTANCE;
        r110.setImageValue(r111);
        r103.add(r109);
        r105 = r105 + 1;
        goto L8
    L11:
        String r113 = r106.getFontColor();
        Intrinsics.checkNotNull(r113);
        r102.setColor(r113);
        Long r114 = r106.getFontSize();
        if (r114 != null) goto L14;
    L17:
        int r115 = 13;
    L18:
        r102.setFontSize(r115);
        Long r116 = r106.getWeight();
        if (r116 != null) goto L21;
    L24:
        int r117 = 500;
    L25:
        r102.setWeight(r117);
        r101.append(r106.getText());
        goto L8
    L21:
        if (((int) r116.longValue()) <= 0) goto L24;
        r117 = (int) r116.longValue();
        goto L25
    L14:
        if (((int) r114.longValue()) <= 0) goto L17;
        r115 = (int) r114.longValue();
        goto L18
    L31:
        a5 r118 = (a5) vh7.f.c(a5.class);
        r118.setDefaultPattern(r101.toString());
        r118.setDefaultFormat(r102);
        r118.setPieces(r103);
        return r118;
    }
}

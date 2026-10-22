package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.message.k5;
import com.bytedance.android.livesdk.message.model.dm;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class c0 {
    public static final s a(dm r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$convert2Model");
        s r101 = new s();
        r101.f116191a = r100.getComponentType();
        String r102 = "";
        if (TextUtils.isEmpty(r100.getText()) == true) goto L9;
        String r103 = r100.getText();
        if (r103 != null) goto L7;
        r103 = "";
    L7:
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r101.f116192b = r103;
    L9:
        if (TextUtils.isEmpty(r100.getSchema()) == true) goto L14;
        String r104 = r100.getSchema();
        if (r104 != null) goto L13;
        r104 = "";
    L13:
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r101.f116195e = r104;
    L14:
        r101.f116193c = r100.getIcon();
        String r105 = r100.getExtraData();
        if (r105 == null) goto L18;
        r102 = r105;
    L18:
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r101.f116194d = r102;
        r101.f116196f = r100.getGroupId();
        r101.f116202l.f116104b = true;
        r101.f116197g = (int) r100.getShowType();
        List<k5> r106 = r100.getLowList();
        ArrayList r107 = null;
        if (r106 == null) goto L24;
        List<k5> r108 = r106;
        ArrayList r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r108, 10));
        Iterator<T> r110 = r108.iterator();
    L22:
        if (r110.hasNext() == false) goto L25;
        k5 r111 = (k5) r110.next();
        e0 r112 = new e0();
        r111.getId();
        r111.getAnchorOpType();
        r111.getAudienceOpType();
        r109.add(r112);
    L25:
        r101.f116201k = r109;
        List<k5> r113 = r100.getHighList();
        if (r113 == null) goto L31;
        List<k5> r114 = r113;
        r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r114, 10));
        Iterator<T> r115 = r114.iterator();
    L29:
        if (r115.hasNext() == false) goto L31;
        k5 r116 = (k5) r115.next();
        e0 r117 = new e0();
        r116.getId();
        r116.getAnchorOpType();
        r116.getAudienceOpType();
        r107.add(r117);
    L31:
        r101.f116200j = r107;
        return r101;
    L24:
        r109 = null;
        goto L25
    }
}

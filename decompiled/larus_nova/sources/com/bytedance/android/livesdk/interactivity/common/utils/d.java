package com.bytedance.android.livesdk.interactivity.common.utils;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.android.live.base.model.message.i5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d {
    static {
    }

    public static void a(a5 r100) {
        if (r100.getPieces() == null) goto L48;
        List<c5> r101 = r100.getPieces();
        if (r101 != null) goto L7;
        return;
    L7:
        if (r101.isEmpty() == true) goto L50;
        List<c5> r102 = r100.getPieces();
        if (r102 != null) goto L11;
        r102 = new ArrayList();
    L11:
        Intrinsics.checkNotNullParameter(r102, "pieces");
        int r103 = r102.size();
        int r104 = 0;
    L12:
        if (r104 >= r103) goto L19;
        i5 r105 = ((c5) ListProtector.get(r102, r104)).getUserValue();
        if (r105 == null) goto L18;
        IBaseUser r106 = r105.getUser();
        if (r106 == null) goto L18;
    L20:
        if (r106 != null) goto L22;
        return;
    L22:
        if (r106.getNickName() != null) goto L24;
        return;
    L24:
        if (Intrinsics.areEqual(r100.getKey(), "subscribe_purchase_tip") == false) goto L33;
        kz.a r107 = kz.b.f506725a;
        String r108 = r106.getNickName();
        if (r107 == null) goto L31;
        if (r107.a() == false) goto L31;
        r106.setNickName(String.valueOf(r108.charAt(0)) + "***" + r108.charAt(r108.length() - 1));
        return;
    L31:
        if (r108.length() <= 6) goto L54;
        r106.setNickName(r108.substring(0, 5) + "...");
        return;
    L54:
        return;
    L33:
        String r109 = r106.getNickName();
        int r110 = r109.length();
        if (r110 != 0) goto L36;
    L42:
        r106.setNickName(r109);
        return;
    L36:
        if (r110 != 1) goto L38;
        r109 = r109.concat("****");
        goto L42
    L38:
        if (r110 == 2) goto L40;
        r109 = String.valueOf(r109.charAt(0)) + "****" + r109.charAt(r109.length() - 1);
        goto L42
    L40:
        r109 = String.valueOf(r109.charAt(0)) + "****";
    L18:
        r104 = r104 + 1;
        goto L12
    L19:
        r106 = null;
        goto L20
    L50:
        return;
    }
}

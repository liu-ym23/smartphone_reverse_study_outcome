package com.bytedance.android.livesdk.dslservice.util;

import com.bytedance.android.livesdk.dsl.util.DSLActionEnum;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public final class g implements yt1.h {
    public g() {
    }

    @Override // yt1.h
    public final String a() {
        int r100 = j.f122975a;
        return "card_data_update";
    }

    @Override // yt1.h
    public final DSLActionEnum getName() {
        return DSLActionEnum.CardUpdate;
    }

    @Override // yt1.h
    public final void b(Map r100, yt1.j r101) {
        if (r100 == null) goto L12;
        int r102 = j.f122975a;
        Object r103 = r100.get("merge_type");
        if (r103 == null) goto L12;
        int r104 = com.bytedance.android.livesdk.dsl.util.c.f122805a;
        if ((r103 instanceof Number) == false) goto L9;
        int r105 = ((Number) r103).intValue();
    L13:
        if (r101 == null) goto L19;
        r101.c(r100, r105);
        return;
    L19:
        return;
    L9:
        if ((r103 instanceof String) == false) goto L12;
        r105 = CastIntegerProtector.parseInt((String) r103);     // Catch: Exception -> L16
    L12:
        r105 = 1;
        goto L13
    }
}

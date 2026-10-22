package com.bytedance.android.livesdk.interactivity.enteranim.utils;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes9.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DataCenter f136793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Integer, Boolean> f136794b;

    public h() {
        Boolean r100 = Boolean.TRUE;
        this.f136794b = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(0, r100), TuplesKt.to(1, r100), TuplesKt.to(2, r100), TuplesKt.to(3, r100), TuplesKt.to(6, r100), TuplesKt.to(4, r100), TuplesKt.to(5, r100), TuplesKt.to(7, r100), TuplesKt.to(8, r100), TuplesKt.to(9, r100)});
    }

    public final void a(View r100, int r101, boolean r102) {
        if (this.f136794b.containsKey(Integer.valueOf(r101)) == true) goto L5;
        return;
    L5:
        int r103 = 0;
        boolean r104 = true;
        switch(r101) {
            case 0: goto L16;
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L18;
            case 9: goto L8;
            default: goto L18;
        };
    L8:
        this.f136794b.put(9, Boolean.valueOf(r102));
        goto L18
    L9:
        this.f136794b.put(0, Boolean.valueOf(!r102));
        goto L18
    L10:
        this.f136794b.put(6, Boolean.valueOf(!r102));
        goto L18
    L11:
        this.f136794b.put(5, Boolean.valueOf(r102));
        goto L18
    L12:
        this.f136794b.put(4, Boolean.valueOf(!r102));
        goto L18
    L13:
        this.f136794b.put(3, Boolean.valueOf(!r102));
        goto L18
    L14:
        this.f136794b.put(2, Boolean.valueOf(!r102));
        goto L18
    L15:
        this.f136794b.put(1, Boolean.valueOf(!r102));
        goto L18
    L16:
        this.f136794b.put(0, Boolean.valueOf(r102));
    L18:
        if (r101 != 8) goto L24;
        if (r100 == null) goto L47;
        if (r102 == false) goto L22;
        float r105 = 0.0f;
    L23:
        r100.setAlpha(r105);
        return;
    L22:
        r105 = 1.0f;
        goto L23
    L47:
        return;
    L24:
        Iterator<Map.Entry<Integer, Boolean>> r106 = this.f136794b.entrySet().iterator();
    L26:
        if (r106.hasNext() == false) goto L30;
        Map.Entry<Integer, Boolean> r107 = r106.next();
        int r108 = r107.getKey().intValue();
        if (r107.getValue().booleanValue() == true) goto L26;
        ALogger.i("EnterAnimWidget", "hide. key=" + r108);
        r104 = false;
    L30:
        if (r104 == false) goto L32;
        int r109 = 0;
    L33:
        if (r100 != null) goto L35;
    L39:
        if (r104 == true) goto L42;
        r103 = 8;
    L42:
        UIUtils.setViewVisibility(r100, r103);
        return;
    L35:
        if (r100.getVisibility() == r109) goto L39;
        DataCenter r110 = this.f136793a;
        if (r110 == null) goto L39;
        r110.put("data_enter_anim_visiable", Boolean.valueOf(r104));
        goto L39
    L32:
        r109 = 8;
        goto L33
    }
}

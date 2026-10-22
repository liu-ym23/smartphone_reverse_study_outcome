package com.bytedance.android.live.liveinteract.aimv;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;

/* JADX INFO: loaded from: classes46.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f70933a = 0;

    public static List a() {
        ArrayList r100 = new ArrayList();
        Float r101 = Float.valueOf(0.0f);
        r100.add(new Pair(r101, r101));
        r100.add(new Pair(Float.valueOf(0.5f), r101));
        r100.add(new Pair(Float.valueOf(0.6f), Float.valueOf(0.8f)));
        Float r102 = Float.valueOf(0.7f);
        Float r103 = Float.valueOf(1.0f);
        r100.add(new Pair(r102, r103));
        r100.add(new Pair(r103, r103));
        return r100;
    }

    static {
    }

    public static boolean b(IRoom r100) {
        if (r100 == null) goto L9;
        Map<String, String> r101 = r100.getAnchorABMap();
        if (r101 == null) goto L9;
        String r102 = r101.get("linkmic_order_sing_ai_mv");
        if (r102 == null) goto L9;
        int r103 = CastIntegerProtector.parseInt(r102);
    L11:
        if (r103 != 1) goto L14;
        return true;
    L14:
        return false;
    L9:
        r103 = 0;
        goto L11
    }
}

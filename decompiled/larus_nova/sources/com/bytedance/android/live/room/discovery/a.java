package com.bytedance.android.live.room.discovery;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.di;
import com.bytedance.android.livesdk.config.ei;
import com.bytedance.android.livesdk.config.fi;
import com.bytedance.android.livesdk.config.gi;
import com.bytedance.android.livesdk.config.hi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<Integer> f99364a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<Integer, Integer> f99365b = null;

    static {
        f99364a = new ArrayList();
        f99365b = new HashMap();
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L6;
        StringBuilder r100 = new StringBuilder("MAX_SIZE=");
        hi r101 = hi.f120378a;
        r100.append((r101.getValue().intValue() * 3) / 2);
        r100.append(", COUNT_THRESHOLD=");
        r100.append(r101.getValue());
        r100.append(", POOR_THRESHOLD=");
        r100.append(fi.f120204a.getValue());
        r100.append(", BAD_THRESHOLD=");
        r100.append(di.f120034a.getValue());
        r100.append(", RISK_THRESHOLD=");
        r100.append(gi.f120289a.getValue());
        r100.append(", GOOD_THRESHOLD=");
        r100.append(ei.f120128a.getValue());
        ALogger.i("AnchorStableMode", r100.toString());
        return;
    }
}

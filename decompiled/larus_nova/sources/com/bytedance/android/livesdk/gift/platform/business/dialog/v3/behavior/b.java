package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.behavior;

import android.view.MotionEvent;
import com.bytedance.android.live.ai.api.IAiService;
import java.util.ArrayList;
import java.util.HashMap;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap<String, String> f127119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f127120b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f127121c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IAiService f127122d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList<com.bytedance.android.livesdk.behavior.a> f127123e;

    public b(int r100) {
        this.f127119a = new HashMap();
        this.f127120b = 1;
        IAiService r101 = (IAiService) k.f(IAiService.class);
        this.f127122d = r101;
        if (r101 == null) goto L5;
        r101.getHarService();
    L5:
        if (r101 == null) goto L7;
        r101.getOhrService();
    L7:
        this.f127120b = 3;
        this.f127121c = r100;
        this.f127119a.put("scene", String.valueOf(3));
        this.f127119a.put("touchSlop", String.valueOf(r100));
        this.f127119a.put("har", "0");
        this.f127119a.put("ohr", "0");
        this.f127123e = new ArrayList();
    }

    public final void setResult(HashMap<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f127119a = r100;
    }

    public final com.bytedance.android.livesdk.behavior.a a(MotionEvent r100, int r101, String r110, int r111, int r112, String r113) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        Intrinsics.checkNotNullParameter(r110, "roomId");
        Intrinsics.checkNotNullParameter(r113, "eventType");
        this.f127119a.put("roomId", r110);
        this.f127119a.put("position", String.valueOf(r101));
        this.f127119a.put("eventType", r113);
        this.f127119a.put("width", String.valueOf(r111));
        this.f127119a.put("height", String.valueOf(r112));
        com.bytedance.android.livesdk.behavior.a r114 = new com.bytedance.android.livesdk.behavior.a(r100, r101, this.f127121c, r111, r112);
        this.f127123e.add(r114);
        return r114;
    }
}

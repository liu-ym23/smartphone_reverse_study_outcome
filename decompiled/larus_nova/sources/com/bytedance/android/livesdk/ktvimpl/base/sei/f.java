package com.bytedance.android.livesdk.ktvimpl.base.sei;

import com.bytedance.android.live.liveinteract.plantform.utils.c0;
import com.bytedance.android.live.liveinteract.plantform.utils.d0;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.live.pushstream.d f143306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0 f143307b;

    public static final class a {
    }

    static {
    }

    public f(com.bytedance.android.live.pushstream.d r100, c0 r101) {
        Intrinsics.checkNotNullParameter(r100, "liveStream");
        this.f143306a = r100;
        this.f143307b = r101;
    }

    public final void a(String r100, JSONObject r110) {
        c0 r101 = this.f143307b;
        if (r101 != null) goto L5;
        this.f143306a.c1(r100, r110, 1, false, false);
        return;
    L5:
        if (d0.f77469b == true) goto L7;
    L8:
        if (r110 == null) goto L10;
        r110.put("sync_index", c0.f77465c.incrementAndGet());
    L10:
        Iterator<com.bytedance.android.live.liveinteract.plantform.utils.q> r102 = r101.f77466a.iterator();
    L12:
        if (r102.hasNext() == false) goto L17;
        r102.next().a(r100, r110);
        goto L12
    L17:
        return;
    L7:
        if (r101.f77467b == false) goto L10;
        goto L8
    }
}

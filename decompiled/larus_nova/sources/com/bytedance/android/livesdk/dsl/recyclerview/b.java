package com.bytedance.android.livesdk.dsl.recyclerview;

import com.bytedance.android.live.core.log.ALogger;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public class b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<BaseDSLViewHolder> f122784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Long f122785b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HashMap<String, Object> f122786c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f122787d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HashMap<String, Object> f122788e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f122789f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f122790g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f122791h;

    @Override // com.bytedance.android.livesdk.dsl.recyclerview.e
    public final String getGroupId() {
        return this.f122791h;
    }

    @Override // com.bytedance.android.livesdk.dsl.recyclerview.e
    public final int getItemType() {
        return this.f122790g;
    }

    public final void a(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        if (this.f122788e != null) goto L5;
        this.f122788e = new HashMap();
    L5:
        HashMap<String, Object> r101 = this.f122788e;
        if (r101 == null) goto L11;
        r101.putAll(r100);
        HashMap<String, Object> r102 = this.f122786c;
        if (r102 == null) goto L12;
        r102.putAll(r101);
        return;
    L12:
        return;
    }

    public final void b(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        long r101 = System.currentTimeMillis();
        String r102 = com.bytedance.android.livesdk.dsl.util.c.d(r100, "merge_type");
        if (r102 != null) goto L6;
        r102 = "1";
    L6:
        if (r102.hashCode() == 49) goto L9;
    L13:
        this.f122786c = new HashMap(r100);
    L14:
        WeakReference<BaseDSLViewHolder> r103 = this.f122784a;
        if (r103 == null) goto L17;
        BaseDSLViewHolder r104 = r103.get();
    L18:
        if (r104 == null) goto L23;
        b r105 = r104.f122774a;
        if (r105 != null) goto L22;
        nq.a.c(null, BaseDSLViewHolder$updateData$1.INSTANCE, 1);
        goto L23
    L22:
        r104.U3(r105, true);
    L23:
        ALogger.d("DSLItem", "update cost " + (System.currentTimeMillis() - r101));
        return;
    L17:
        r104 = null;
        goto L18
    L9:
        if (r102.equals("1") == false) goto L13;
        HashMap<String, Object> r106 = this.f122786c;
        if (r106 == null) goto L14;
        r106.putAll(r100);
        goto L14
    }

    public b(String r100, int r101, String r102) {
        this.f122789f = r100;
        this.f122790g = r101;
        this.f122791h = r102;
        this.f122787d = -1;
    }
}

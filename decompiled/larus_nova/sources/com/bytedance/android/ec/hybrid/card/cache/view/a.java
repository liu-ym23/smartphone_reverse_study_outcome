package com.bytedance.android.ec.hybrid.card.cache.view;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f46459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f46460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f46461c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Object> f46462d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f46463e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Long f46464f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f46465g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f46466h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f46467i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f46468j;

    public a() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L26;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f46459a, r101.f46459a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f46460b, r101.f46460b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f46461c, r101.f46461c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f46462d, r101.f46462d) == true) goto L14;
        return false;
    L14:
        if (this.f46463e == r101.f46463e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f46464f, r101.f46464f) == true) goto L18;
        return false;
    L18:
        if (this.f46465g == r101.f46465g) goto L20;
        return false;
    L20:
        if (this.f46466h == r101.f46466h) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f46467i, r101.f46467i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f46468j, r101.f46468j) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        Context r100 = this.f46459a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f46460b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f46461c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<Object> r110 = this.f46462d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        boolean r113 = this.f46463e;
        ?? r114 = 1;
        ?? r115 = r113;
        if (r113 == false) goto L21;
        r115 = 1;
    L21:
        int r116 = (r112 + r115) * 31;
        Long r117 = this.f46464f;
        if (r117 == null) goto L24;
        int r118 = r117.hashCode();
    L25:
        int r119 = (((r116 + r118) * 31) + this.f46465g) * 31;
        boolean r120 = this.f46466h;
        if (r120 == true) goto L29;
        r114 = r120;
    L29:
        int r121 = (r119 + r114) * 31;
        String r122 = this.f46467i;
        if (r122 == null) goto L32;
        int r123 = r122.hashCode();
    L33:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f46468j;
        if (r125 == null) goto L37;
        r101 = r125.hashCode();
    L37:
        return r124 + r101;
    L32:
        r123 = 0;
        goto L33
    L24:
        r118 = 0;
        goto L25
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "CreateKitViewCacheParams(context=" + this.f46459a + ", schema=" + this.f46460b + ", initData=" + this.f46461c + ", behaviors=" + this.f46462d + ", enableSyncFlush=" + this.f46463e + ", timeoutThreshold=" + this.f46464f + ", schemaType=" + this.f46465g + ", enableCommonMonitor=" + this.f46466h + ", pageName=" + this.f46467i + ", sceneId=" + this.f46468j + ")";
    }

    public final Context getContext() {
        return this.f46459a;
    }

    public a(Context r100, String r101, String r102, List r103, int r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "schema");
        Intrinsics.checkNotNullParameter(r103, "behaviors");
        Intrinsics.checkNotNullParameter(r105, "pageName");
        this.f46459a = r100;
        this.f46460b = r101;
        this.f46461c = r102;
        this.f46462d = r103;
        this.f46463e = false;
        this.f46464f = null;
        this.f46465g = r104;
        this.f46466h = false;
        this.f46467i = r105;
        this.f46468j = null;
    }
}

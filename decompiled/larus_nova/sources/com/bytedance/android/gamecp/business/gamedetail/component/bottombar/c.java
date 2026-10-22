package com.bytedance.android.gamecp.business.gamedetail.component.bottombar;

import com.bytedance.android.gamecp.business.gamedetail.page.comment.GameCommentTabWidget;
import com.bytedance.ies.sve_core.s;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class c implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f53839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f53840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f53841c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f53842d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f53843e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, Boolean> f53844f;

    public c() {
        this(false, null, null, false, null, new LinkedHashMap());
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L18;
        c r101 = (c) r100;
        if (this.f53839a == r101.f53839a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f53840b, r101.f53840b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f53841c, r101.f53841c) == true) goto L12;
        return false;
    L12:
        if (this.f53842d == r101.f53842d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f53843e, r101.f53843e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f53844f, r101.f53844f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    public final int hashCode() {
        boolean r100 = this.f53839a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        String r104 = this.f53840b;
        int r105 = 0;
        if (r104 == null) goto L8;
        int r106 = r104.hashCode();
    L9:
        int r107 = (r103 + r106) * 31;
        JSONObject r108 = this.f53841c;
        if (r108 == null) goto L12;
        int r109 = r108.hashCode();
    L13:
        int r110 = (r107 + r109) * 31;
        boolean r111 = this.f53842d;
        if (r111 == true) goto L17;
        r101 = r111;
    L17:
        int r112 = (r110 + r101) * 31;
        Integer r113 = this.f53843e;
        if (r113 == null) goto L20;
        int r114 = r113.hashCode();
    L21:
        int r115 = (r112 + r114) * 31;
        Map<String, Boolean> r116 = this.f53844f;
        if (r116 == null) goto L25;
        r105 = r116.hashCode();
    L25:
        return r115 + r105;
    L20:
        r114 = 0;
        goto L21
    L12:
        r109 = 0;
        goto L13
    L8:
        r106 = 0;
        goto L9
    }

    public final String toString() {
        return "BottomBarState(enableShow=" + this.f53839a + ", barClazz=" + this.f53840b + ", barData=" + this.f53841c + ", display=" + this.f53842d + ", containerHeight=" + this.f53843e + ", bottomDisplayMap=" + this.f53844f + ")";
    }

    public final void d(GameCommentTabWidget r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        Intrinsics.checkNotNullParameter("fast_evaluate", "componentClazz");
        this.f53844f.put("fast_evaluate", Boolean.valueOf(r101));
        r100.Eq().dispatch(dt.c.f469986b, new a.C0882a(r101));
    }

    public c(boolean r100, String r101, JSONObject r102, boolean r103, Integer r104, Map<String, Boolean> r105) {
        Intrinsics.checkNotNullParameter(r105, "bottomDisplayMap");
        this.f53839a = r100;
        this.f53840b = r101;
        this.f53841c = r102;
        this.f53842d = r103;
        this.f53843e = r104;
        this.f53844f = r105;
    }

    public static c c(c r100, boolean r101, String r102, JSONObject r110, boolean r111, Integer r112, int r113) {
        if ((r113 & 1) == 0) goto L5;
        r101 = r100.f53839a;
    L5:
        boolean r103 = r101;
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.f53840b;
    L8:
        String r104 = r102;
        if ((r113 & 4) == 0) goto L11;
        r110 = r100.f53841c;
    L11:
        JSONObject r105 = r110;
        if ((r113 & 8) == 0) goto L14;
        r111 = r100.f53842d;
    L14:
        boolean r106 = r111;
        if ((r113 & 16) == 0) goto L17;
        r112 = r100.f53843e;
    L17:
        Integer r107 = r112;
        if ((r113 & 32) == 0) goto L20;
        Map<String, Boolean> r108 = r100.f53844f;
    L21:
        Map<String, Boolean> r109 = r108;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r109, "bottomDisplayMap");
        return new c(r103, r104, r105, r106, r107, r109);
    L20:
        r108 = null;
        goto L21
    }
}

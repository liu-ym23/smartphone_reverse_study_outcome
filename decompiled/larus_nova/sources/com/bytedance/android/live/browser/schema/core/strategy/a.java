package com.bytedance.android.live.browser.schema.core.strategy;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.List;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class a extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f64211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f64212c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f64213d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f64214e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f64215f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f64216g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f64217h;

    /* JADX INFO: renamed from: com.bytedance.android.live.browser.schema.core.strategy.a$a, reason: collision with other inner class name */
    public static final class C1058a implements c.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f64218a;

        public C1058a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "appVersion");
            this.f64218a = r100;
        }

        @Override // com.bytedance.android.live.browser.schema.core.strategy.c.b
        public final c a(JSONObject r100) {
            Intrinsics.checkNotNullParameter(r100, "json");
            return new a(r100.optInt(com.heytap.mcssdk.constant.b.f276366p, -1), r100.optString("targetValue"), this.f64218a);
        }
    }

    public static Triple b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "version");
        List r101 = StringsKt.split$default(r100, new String[]{"."}, false, 0, 6, null);
        if (r101.size() == 3) goto L7;
        return new Triple(-1, -1, -1);
    L7:
        return new Triple(Integer.valueOf(CastIntegerProtector.parseInt((String) ListProtector.get(r101, 0))), Integer.valueOf(CastIntegerProtector.parseInt((String) ListProtector.get(r101, 1))), Integer.valueOf(CastIntegerProtector.parseInt((String) ListProtector.get(r101, 2))));
    }

    @Override // com.bytedance.android.live.browser.schema.core.strategy.c
    public final boolean a(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "currentState");
        if (this.f64215f == (-1)) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L55;
        if (this.f64216g.length() <= 0) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == false) goto L53;
        r100.put("current_version", this.f64217h);
        if (this.f64211b != (-1)) goto L15;
    L51:
        return false;
    L15:
        if (this.f64212c == (-1)) goto L51;
        if (this.f64213d == (-1)) goto L51;
        Triple r103 = b(this.f64216g);
        int r104 = ((Number) r103.component1()).intValue();
        int r105 = ((Number) r103.component2()).intValue();
        int r106 = (((Number) r103.component3()).intValue() + (r105 * 1000)) + (r104 * 1000000);
        int r107 = this.f64215f;
        if (r107 == 0) goto L47;
        if (r107 == 1) goto L44;
        if (r107 == 2) goto L41;
        if (r107 == 3) goto L38;
        if (r107 == 4) goto L35;
        if (r107 == 5) goto L32;
    L49:
        return false;
    L32:
        if (this.f64214e == r106) goto L49;
        return true;
    L35:
        if ((this.f64214e - r106) > 0) goto L49;
        return true;
    L38:
        if ((this.f64214e - r106) < 0) goto L49;
        return true;
    L41:
        if ((this.f64214e - r106) >= 0) goto L49;
        return true;
    L44:
        if ((this.f64214e - r106) <= 0) goto L49;
        return true;
    L47:
        if (this.f64214e != r106) goto L49;
        return true;
    L53:
        throw new IllegalStateException("targetValue not exists, please check config".toString());
    L10:
        r102 = false;
        goto L11
    L55:
        throw new IllegalStateException("rule value not exists, please check config".toString());
    L5:
        r101 = false;
        goto L6
    }

    public a(int r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "version");
        Intrinsics.checkNotNullParameter(r102, "appVersion");
        super(1);
        this.f64215f = r100;
        this.f64216g = r101;
        this.f64217h = r102;
        Triple r103 = b(r102);
        int r104 = ((Number) r103.component1()).intValue();
        int r105 = ((Number) r103.component2()).intValue();
        int r106 = ((Number) r103.component3()).intValue();
        this.f64211b = r104;
        this.f64212c = r105;
        this.f64213d = r106;
        this.f64214e = (r106 + (r105 * 1000)) + (r104 * 1000000);
    }
}

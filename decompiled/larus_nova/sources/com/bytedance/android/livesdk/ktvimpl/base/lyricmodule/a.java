package com.bytedance.android.livesdk.ktvimpl.base.lyricmodule;

import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public abstract class a implements ud2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<com.bytedance.component.lyric.model.b> f143046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f143047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f143048c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f143049d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList<Function1<List<com.bytedance.component.lyric.model.b>, Unit>> f143050e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList<com.bytedance.component.lyric.model.b> f143051f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Integer f143052g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Integer f143053h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.bytedance.android.livesdk.ktvapi.config.a f143054i;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.base.lyricmodule.a$a, reason: collision with other inner class name */
    public static final class C2241a {
    }

    static {
    }

    public final void g() {
        Integer r100 = this.f143052g;
        Integer r101 = this.f143053h;
        if (r100 == null) goto L15;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r100.intValue() >= 0) goto L8;
        return;
    L8:
        if (r100.intValue() < r101.intValue()) goto L10;
        return;
    L10:
        if (r101.intValue() > 0) goto L12;
        return;
    L12:
        if (r101.intValue() >= this.f143051f.size()) goto L20;
        List<com.bytedance.component.lyric.model.b> r102 = this.f143051f.subList(r100.intValue(), r101.intValue());
        ArrayList r103 = new ArrayList();
        r103.addAll(r102);
        this.f143046a.clear();
        this.f143046a.addAll(r103);
        ArrayList<com.bytedance.component.lyric.model.b> r104 = this.f143046a;
        com.bytedance.component.lyric.model.b r105 = new com.bytedance.component.lyric.model.b();
        r105.f203028a = 3;
        Unit r106 = Unit.INSTANCE;
        r104.add(r105);
        return;
    L20:
        return;
    }

    @Override // ud2.a
    public final int b() {
        return this.f143048c;
    }

    @Override // ud2.a
    public final List c() {
        return this.f143046a;
    }

    public a(com.bytedance.android.livesdk.ktvapi.config.a r100) {
        Intrinsics.checkNotNullParameter(r100, "baseConfig");
        this.f143054i = r100;
        this.f143046a = new ArrayList();
        this.f143050e = new ArrayList();
        this.f143051f = new ArrayList();
    }

    public final int f(long r100) {
        int r101 = this.f143046a.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L33;
        if (((com.bytedance.component.lyric.model.b) ListProtector.get(this.f143046a, r102)).f203028a != 0) goto L31;
        if (r100 < ((com.bytedance.component.lyric.model.b) ListProtector.get(this.f143046a, 0)).f203029b) goto L8;
        if (r100 >= ((com.bytedance.component.lyric.model.b) ListProtector.get(this.f143046a, r102)).f203029b) goto L20;
        if (r102 <= 0) goto L20;
        int r103 = r102 - 1;
        com.bytedance.component.lyric.model.b r104 = (com.bytedance.component.lyric.model.b) KtvUtilsKt.K(this.f143046a, r103);
        if (r104 != null) goto L15;
    L18:
        this.f143048c = r102;
        goto L33
    L15:
        if (r104.f203028a != 0) goto L18;
        this.f143048c = r103;
    L20:
        if (r102 != (this.f143046a.size() - 1)) goto L25;
        if (r100 < ((com.bytedance.component.lyric.model.b) ListProtector.get(this.f143046a, r102)).f203029b) goto L25;
        this.f143048c = this.f143046a.size() - 1;
    L25:
        if (r102 >= this.f143046a.size()) goto L31;
        if (r100 <= ((com.bytedance.component.lyric.model.b) ListProtector.get(this.f143046a, r102)).f203029b) goto L31;
        if (r100 >= ((com.bytedance.component.lyric.model.b) ListProtector.get(this.f143046a, r102)).f203030c) goto L31;
        this.f143048c = r102;
        goto L31
    L8:
        this.f143048c = 0;
    L31:
        r102 = r102 + 1;
    L33:
        return this.f143048c;
    }

    @Override // ud2.a
    public final void d(int r100, int r101) {
        this.f143052g = Integer.valueOf(r100);
        this.f143053h = Integer.valueOf(r101);
        g();
    }
}

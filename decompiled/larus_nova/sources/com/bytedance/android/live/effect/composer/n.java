package com.bytedance.android.live.effect.composer;

import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f67971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f67972b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f67973c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f67974d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f67975e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f67976f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f67977g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<Integer> f67978h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<p> f67979i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f67980j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f67981k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ILiveEffectComposerManager.EffectInstanceType f67982l;

    public final String toString() {
        return "LiveComposerNode(panel='" + this.f67971a + "', effectId='" + this.f67972b + "', resourceId='" + this.f67973c + "', path='" + this.f67974d + "', isWithoutFace=" + this.f67975e + ", isHighCost=" + this.f67976f + ", updateTime=" + this.f67977g + ", coexistGroup=" + this.f67978h + ", tagList=" + this.f67979i + ", use=" + this.f67980j + ')';
    }

    public final String a() {
        return this.f67972b;
    }

    public final String b() {
        return this.f67971a;
    }

    public final List<p> c() {
        return this.f67979i;
    }

    public final long d() {
        return this.f67977g;
    }

    public n(n r100) {
        Intrinsics.checkNotNullParameter(r100, "node");
        ArrayList r101 = new ArrayList();
        this.f67978h = r101;
        ArrayList r102 = new ArrayList();
        this.f67979i = r102;
        this.f67981k = "";
        this.f67982l = ILiveEffectComposerManager.EffectInstanceType.DEFAULT;
        this.f67971a = r100.f67971a;
        this.f67972b = r100.f67972b;
        this.f67973c = r100.f67973c;
        this.f67974d = r100.f67974d;
        this.f67975e = r100.f67975e;
        this.f67976f = r100.f67976f;
        this.f67977g = r100.f67977g;
        this.f67980j = r100.f67980j;
        r101.addAll(r100.f67978h);
        List<p> r103 = r100.f67979i;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
    L4:
        if (r105.hasNext() == false) goto L9;
        p r106 = (p) r105.next();
        if (LiveEffectSettings.LIVE_EFFECT_ENABLE_COMPOSER_TAG_NODE_DEEP_COPY.getValue().booleanValue() == false) goto L8;
        Intrinsics.checkNotNullParameter(r106, "node");
        p r107 = new p(r106.f67984b);
        r107.f67983a = r106.f67983a;
        r106 = r107;
    L8:
        r104.add(r106);
        goto L4
    L9:
        r102.addAll(r104);
        this.f67982l = r100.f67982l;
    }

    public n(String r100, String r101, String r102, String r103, boolean r104, boolean r105, long r106) {
        Intrinsics.checkNotNullParameter(r100, "panel");
        Intrinsics.checkNotNullParameter(r101, "effectId");
        Intrinsics.checkNotNullParameter(r102, "resourceId");
        Intrinsics.checkNotNullParameter(r103, "path");
        this.f67978h = new ArrayList();
        this.f67979i = new ArrayList();
        this.f67981k = "";
        this.f67982l = ILiveEffectComposerManager.EffectInstanceType.DEFAULT;
        this.f67971a = r100;
        this.f67972b = r101;
        this.f67973c = r102;
        this.f67974d = r103;
        this.f67975e = r104;
        this.f67976f = r105;
        this.f67977g = r106;
    }
}

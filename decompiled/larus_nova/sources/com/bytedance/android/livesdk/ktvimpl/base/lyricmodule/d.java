package com.bytedance.android.livesdk.ktvimpl.base.lyricmodule;

import android.graphics.Paint;
import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.ktvapi.config.ScrollLyricConfigV2;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes10.dex */
public final class d extends a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<String, Float> f143060j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ScrollLyricConfigV2 f143061k;

    @Override // ud2.a
    public final void clear() {
        this.f143046a.clear();
        this.f143047b = 0;
        this.f143048c = 0;
        Iterator<Function1<List<com.bytedance.component.lyric.model.b>, Unit>> r100 = this.f143050e.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().invoke(this.f143046a);
        goto L4
    L6:
        ((LinkedHashMap) this.f143060j).clear();
    }

    public d(ScrollLyricConfigV2 r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        super(r100);
        this.f143061k = r100;
        this.f143060j = new LinkedHashMap();
    }

    @Override // ud2.a
    public final void e(long r110) {
        f(r110);
        int r100 = this.f143048c;
        if (r100 >= 0) goto L5;
        return;
    L5:
        if (r100 >= this.f143046a.size()) goto L37;
        com.bytedance.component.lyric.model.b r101 = (com.bytedance.component.lyric.model.b) ListProtector.get(this.f143046a, this.f143048c);
        Intrinsics.checkNotNullParameter(r101, "lyricsLineInfo");
        Intrinsics.checkNotNullParameter(r101, "lyricsLineInfo");
        float r102 = 0.0f;
        if (TextUtils.isEmpty(r101.f203031d) == false) goto L9;
        Pair r103 = new Pair(Float.valueOf(0.0f), Float.valueOf(0.0f));
    L30:
        if (((Number) r103.getFirst()).floatValue() <= 0) goto L32;
        r102 = ((Number) r103.getSecond()).floatValue() / ((Number) r103.getFirst()).floatValue();
    L32:
        this.f143061k.f142304j.setValue(Float.valueOf(r102));
        return;
    L9:
        float r104 = h(r101.f203031d);
        long r105 = r101.f203029b;
        if (r110 >= r105) goto L12;
        String r106 = "calculateLineProgressPercent error, playTime:" + r110 + ", startTime:" + r101.f203029b;
        ALogger.e(bb0.b.b(), r106 + ", invoke class :" + com.bytedance.component.lyric.model.b.class.getSimpleName());
        r103 = new Pair(Float.valueOf(0.0f), Float.valueOf(0.0f));
        goto L30
    L12:
        long r107 = r110 - r105;
        StringBuilder r108 = new StringBuilder();
        int[] r109 = r101.f203034g;
        if (r109 == null) goto L27;
        int r111 = r109.length;
        long r112 = 0;
        int r113 = 0;
    L15:
        if (r113 >= r111) goto L27;
        long r114 = r109[r113];
        r112 = r112 + r114;
        String[] r115 = r101.f203033f;
        if (r115 == null) goto L20;
        String r116 = r115[r113];
        if (r116 == null) goto L20;
    L22:
        if (r107 < r112) goto L23;
        r108.append(r116);
        r113 = r113 + 1;
        goto L15
    L23:
        if (r113 <= 0) goto L25;
        r107 = r107 - (r112 - r114);
    L25:
        float r117 = (h(r116) / r109[r113]) * r107;
    L28:
        r103 = new Pair(Float.valueOf(r104), Float.valueOf(r117 + h(r108.toString())));
    L20:
        r116 = "";
    L27:
        r117 = 0.0f;
        goto L28
    }

    public final float h(String r100) {
        if (r100 != null) goto L4;
    L9:
        return 0.0f;
    L4:
        if (((LinkedHashMap) this.f143060j).get(r100) == null) goto L6;
        Float r101 = (Float) ((LinkedHashMap) this.f143060j).get(r100);
    L7:
        if (r101 == null) goto L9;
        return r101.floatValue();
    L6:
        float r102 = this.f143061k.f142315b.measureText(r100);
        this.f143060j.put(r100, Float.valueOf(r102));
        r101 = Float.valueOf(r102);
        goto L7
    }

    @Override // ud2.a
    public final void a(List<com.bytedance.component.lyric.model.b> r210, int r211, long r212) {
        StringBuilder r100 = new StringBuilder("addLyrics ");
        if (r210 == null) goto L5;
        Integer r101 = Integer.valueOf(r210.size());
    L6:
        r100.append(r101);
        ALogger.i("CommonLyricDisplayModel", r100.toString());
        clear();
        if (r210 == null) goto L86;
        Iterator<com.bytedance.component.lyric.model.b> r102 = r210.iterator();
    L10:
        if (r102.hasNext() == false) goto L86;
        com.bytedance.component.lyric.model.b r103 = r102.next();
        if (TextUtils.isEmpty(r103.f203031d) == true) goto L84;
        com.bytedance.android.livesdk.ktvapi.config.a r104 = this.f143054i;
        Paint r105 = r104.f142316c;
        float r106 = r104.f142318e;
        Intrinsics.checkNotNullParameter(r103, "lyricsLineInfo");
        Intrinsics.checkNotNullParameter(r105, "toolPaint");
        String r107 = r103.f203031d;
        int r108 = 0;
        this.f143047b = 0;
        if (r105.measureText(r107) > r106) goto L19;
        int r109 = this.f143049d + 1;
        this.f143049d = r109;
        if (this.f143047b >= r109) goto L84;
        this.f143046a.add(r103);
        goto L84
    L19:
        if (r211 != 2) goto L36;
        com.bytedance.component.lyric.model.b r110 = new com.bytedance.component.lyric.model.b();
        com.bytedance.component.lyric.model.b r111 = new com.bytedance.component.lyric.model.b();
        StringBuilder r112 = new StringBuilder();
        StringBuilder r113 = new StringBuilder();
        StringBuilder r114 = new StringBuilder();
        String r115 = r103.f203031d;
        if (r115 == null) goto L84;
        int r116 = r115.length();
    L23:
        if (r108 >= r116) goto L29;
        char r117 = r115.charAt(r108);
        r112.append(r117);
        if (r105.measureText(r112.toString()) <= r106) goto L27;
        r114.append(r117);
    L28:
        r108 = r108 + 1;
        goto L23
    L27:
        r113.append(r117);
        goto L28
    L29:
        r110.f203029b = r103.f203029b;
        r110.f203031d = r113.toString();
        int r118 = this.f143049d + 1;
        this.f143049d = r118;
        if (this.f143047b >= r118) goto L32;
        this.f143046a.add(r110);
    L32:
        r111.f203029b = r103.f203029b + 4000;
        r111.f203031d = r114.toString();
        int r119 = this.f143049d + 1;
        this.f143049d = r119;
        if (this.f143047b >= r119) goto L84;
        this.f143046a.add(r111);
        goto L84
    L36:
        if (r211 != 3) goto L84;
        com.bytedance.component.lyric.model.b r120 = new com.bytedance.component.lyric.model.b();
        com.bytedance.component.lyric.model.b r121 = new com.bytedance.component.lyric.model.b();
        StringBuilder r122 = new StringBuilder();
        String[] r123 = r103.f203033f;
        if (r123 == null) goto L84;
        ArrayList r124 = new ArrayList();
        ArrayList r125 = new ArrayList();
        ArrayList r126 = new ArrayList();
        StringBuilder r127 = new StringBuilder();
        StringBuilder r128 = new StringBuilder();
        ArrayList r129 = new ArrayList();
        int r130 = r103.f203029b;
        int r131 = r123.length;
        Iterator<com.bytedance.component.lyric.model.b> r132 = r102;
        int r133 = 0;
        int r134 = r130;
    L40:
        if (r133 >= r131) goto L54;
        int r135 = r131;
        String r136 = r123[r133];
        r122.append(r136);
        String[] r137 = r123;
        if (r105.measureText(r122.toString()) <= r106) goto L48;
        r126.add(r136);
        r128.append(r136);
        int[] r138 = r103.f203034g;
        if (r138 == null) goto L53;
        if (r133 >= r138.length) goto L53;
        r129.add(Integer.valueOf(r138[r133]));
    L53:
        r133 = r133 + 1;
        r131 = r135;
        r123 = r137;
        goto L40
    L48:
        r124.add(r136);
        r127.append(r136);
        int[] r139 = r103.f203034g;
        if (r139 == null) goto L53;
        if (r133 >= r139.length) goto L53;
        r125.add(Integer.valueOf(r139[r133]));
        r134 = r134 + r139[r133];
        goto L53
    L54:
        r120.f203029b = r103.f203029b;
        Object[] r140 = r124.toArray(new String[0]);
        if (r140 == null) goto L83;
        r120.f203033f = (String[]) r140;
        r120.f203034g = new int[r125.size()];
        int r141 = r125.size();
        int r142 = 0;
    L57:
        if (r142 >= r141) goto L62;
        int[] r143 = r120.f203034g;
        if (r143 == null) goto L61;
        r143[r142] = ((Number) ListProtector.get(r125, r142)).intValue();
    L61:
        r142 = r142 + 1;
        goto L57
    L62:
        String r144 = r127.toString();
        if (r144 == null) goto L81;
        r120.f203031d = StringsKt.trim(r144).toString();
        int r145 = this.f143049d + 1;
        this.f143049d = r145;
        if (this.f143047b >= r145) goto L67;
        this.f143046a.add(r120);
    L67:
        r121.f203029b = r134;
        int r146 = 0;
        Object[] r147 = r126.toArray(new String[0]);
        if (r147 == null) goto L79;
        r121.f203033f = (String[]) r147;
        r121.f203034g = new int[r129.size()];
        int r148 = r129.size();
    L70:
        if (r146 >= r148) goto L75;
        int[] r149 = r121.f203034g;
        if (r149 == null) goto L74;
        r149[r146] = ((Number) ListProtector.get(r129, r146)).intValue();
    L74:
        r146 = r146 + 1;
        goto L70
    L75:
        r121.f203031d = r128.toString();
        int r150 = this.f143049d + 1;
        this.f143049d = r150;
        if (this.f143047b >= r150) goto L85;
        this.f143046a.add(r121);
    L85:
        r102 = r132;
        goto L10
    L79:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L81:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L83:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L84:
        r132 = r102;
    L86:
        this.f143048c = f(r212);
        Iterator<Function1<List<com.bytedance.component.lyric.model.b>, Unit>> r151 = this.f143050e.iterator();
    L88:
        if (r151.hasNext() == false) goto L91;
        r151.next().invoke(this.f143046a);
        goto L88
    L91:
        if (this.f143046a.size() != 0) goto L93;
        return;
    L93:
        ArrayList<com.bytedance.component.lyric.model.b> r152 = this.f143046a;
        com.bytedance.component.lyric.model.b r153 = new com.bytedance.component.lyric.model.b();
        r153.f203028a = 3;
        Unit r154 = Unit.INSTANCE;
        r152.add(r153);
        this.f143051f.clear();
        this.f143051f.addAll(this.f143046a);
        g();
        return;
    L5:
        r101 = null;
        goto L6
    }
}

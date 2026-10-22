package com.bytedance.android.livesdk.ktvimpl.base.lyrics.widget;

import com.bytedance.component.lyric.model.b;
import java.util.LinkedList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<b> f143226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f143227b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f143228c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f143229d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f143230e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinkedList<Integer> f143231f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function1<? super Integer, Unit> f143232g;

    public a(Function1<? super Integer, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "countDownCallback");
        this.f143232g = r100;
        this.f143228c = -1;
        this.f143229d = 3000;
        this.f143230e = ((int) 3000) / 1000;
        this.f143231f = new LinkedList();
    }

    public final void a(long r100) {
        Integer r101 = this.f143227b;
        if (r101 != null) goto L5;
        return;
    L5:
        boolean r102 = false;
        if (r101 == null) goto L8;
        int r103 = r101.intValue();
    L9:
        long r104 = r103;
        if (r100 >= r104) goto L12;
        return;
    L12:
        long r105 = r100 - r104;
        long r106 = 1000;
        Long r107 = Long.valueOf(r105 / r106);
        if (r107.longValue() == this.f143228c) goto L16;
        r102 = true;
    L16:
        if (r102 == true) goto L19;
        r107 = null;
    L19:
        if (r107 == null) goto L32;
        long r108 = r107.longValue();
        long r109 = 0;
        if (r108 < 0) goto L25;
        r109 = r108;
    L25:
        if ((r108 * r106) < this.f143229d) goto L30;
        this.f143232g.invoke(null);
        if (this.f143231f.isEmpty() == false) goto L29;
        this.f143232g.invoke(-1);
    L29:
        this.f143227b = this.f143231f.poll();
        this.f143228c = -1;
        return;
    L30:
        this.f143228c = r109;
        this.f143232g.invoke(Integer.valueOf(this.f143230e - ((int) r109)));
        return;
    L32:
        return;
    L8:
        r103 = 0;
        goto L9
    }
}

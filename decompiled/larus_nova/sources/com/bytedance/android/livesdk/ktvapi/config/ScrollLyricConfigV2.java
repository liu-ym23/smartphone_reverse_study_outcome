package com.bytedance.android.livesdk.ktvapi.config;

import android.graphics.Paint;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class ScrollLyricConfigV2 extends com.bytedance.android.livesdk.ktvapi.config.a {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f142299t = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer f142300f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Integer f142301g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Integer f142302h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f142303i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final NextLiveData<Float> f142304j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList<WeakReference<Function1<Integer, Unit>>> f142305k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f142306l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f142307m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final NextLiveData<Integer> f142308n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f142309o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f142310p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f142311q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f142312r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f142313s;

    public static final class a {
    }

    static {
        f142299t = (int) UtilityKotlinExtentionsKt.h(TTVideoEngineInterface.PLAYER_OPTION_AE_LU_RANG);
    }

    public final void a() {
        float r100 = 23;
        this.f142315b.setTextSize(UtilityKotlinExtentionsKt.m(r100));
        this.f142316c.setTextSize(UtilityKotlinExtentionsKt.m(r100));
        this.f142317d.setTextSize(UtilityKotlinExtentionsKt.m(17));
    }

    public ScrollLyricConfigV2() {
        this.f142304j = new NextLiveData();
        this.f142305k = new ArrayList();
        this.f142306l = 7;
        this.f142308n = new NextLiveData();
        this.f142310p = true;
        this.f142312r = true;
        this.f142313s = true;
        AnonymousClass1 r100 = AnonymousClass1.INSTANCE;
        Intrinsics.checkNotNullParameter(r100, "func");
        r100.invoke(this.f142316c);
        this.f142314a = f142299t / this.f142306l;
        AnonymousClass2 r101 = AnonymousClass2.INSTANCE;
        Intrinsics.checkNotNullParameter(r101, "func");
        r101.invoke(this.f142315b);
        Paint r102 = this.f142317d;
        r102.setTextSize(UtilityKotlinExtentionsKt.h(17));
        r102.setStrokeWidth(1.0f);
        r102.setAntiAlias(true);
        r102.setLetterSpacing(0.05f);
        r102.setTextAlign(Paint.Align.CENTER);
        r102.setColor(ColorProtector.parseColor("#C9ffffff"));
    }

    public final void b(int r100) {
        this.f142303i = r100;
        Iterator<T> r101 = this.f142305k.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Function1 r102 = (Function1) ((WeakReference) r101.next()).get();
        if (r102 == null) goto L4;
        Unit r103 = (Unit) r102.invoke(Integer.valueOf(r100));
        goto L4
    }
}

package com.bytedance.android.live.effect.sticker.chain;

import android.content.Context;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.LiveEffectScene;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedList;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.live.effect.base.e f68168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f68169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f68170c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LiveEffectContextFactoryDelegate$Type f68171d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LiveEffectScene f68172e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f68173f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Sticker f68174g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, String> f68175h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LinkedList<m> f68176i;

    public final void a() {
        if (this.f68176i.isEmpty() == false) goto L6;
        this.f68169b = false;
    L6:
        if (this.f68169b == true) goto L8;
        return;
    L8:
        this.f68176i.remove().a(this);
    }

    public final Context getContext() {
        return this.f68170c;
    }

    public final LiveEffectContextFactoryDelegate$Type getType() {
        return this.f68171d;
    }

    public l(Context r100, LiveEffectContextFactoryDelegate$Type r101, LiveEffectScene r102, String r103, Sticker r104, Map<String, String> r105, LinkedList<m> r106) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r102, "scene");
        Intrinsics.checkNotNullParameter(r103, "panel");
        Intrinsics.checkNotNullParameter(r104, "sticker");
        Intrinsics.checkNotNullParameter(r105, "extra");
        Intrinsics.checkNotNullParameter(r106, "interceptors");
        this.f68170c = r100;
        this.f68171d = r101;
        this.f68172e = r102;
        this.f68173f = r103;
        this.f68174g = r104;
        this.f68175h = r105;
        this.f68176i = r106;
        this.f68168a = new com.bytedance.android.live.effect.base.e();
        this.f68169b = true;
    }
}

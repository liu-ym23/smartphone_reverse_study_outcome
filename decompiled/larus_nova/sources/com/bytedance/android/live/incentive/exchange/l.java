package com.bytedance.android.live.incentive.exchange;

import android.content.Context;
import com.bytedance.android.live.recharge.model.ExchangeType;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f69360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ExchangeType f69361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f69362c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final zv0.e f69363d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final py.k f69364e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, String> f69365f;

    public final String toString() {
        return "{ diamond = " + this.f69362c + ", type = " + this.f69361b + " }";
    }

    public final Context getContext() {
        return this.f69360a;
    }

    public final ExchangeType getType() {
        return this.f69361b;
    }

    public /* synthetic */ l(Context r110, ExchangeType r111, long r112, zv0.e r113, py.k r114) {
        this(r110, r111, r112, r113, r114, null, null);
    }

    public l(Context r100, ExchangeType r101, long r102, zv0.e r103, py.k r104, Map<String, String> r105, Long r106) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r103, "listener");
        this.f69360a = r100;
        this.f69361b = r101;
        this.f69362c = r102;
        this.f69363d = r103;
        this.f69364e = r104;
        this.f69365f = r105;
    }
}

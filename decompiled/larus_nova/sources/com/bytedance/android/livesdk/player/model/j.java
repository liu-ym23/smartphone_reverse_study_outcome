package com.bytedance.android.livesdk.player.model;

import android.graphics.RectF;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f155650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f155651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f155652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f155653d;

    public j(boolean r100, RectF r101, long r102, int r103) {
        Intrinsics.checkNotNullParameter(r101, EffectConfiguration.KEY_REGION);
        this.f155650a = r100;
        this.f155651b = r101;
        this.f155652c = r102;
        this.f155653d = r103;
    }
}

package com.bytedance.android.livesdk.chatroom.vs_host.business;

import android.content.Context;
import android.view.ViewGroup;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import vr1.e0;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements vr1.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i40.a f118258a;

    public a(i40.a r100) {
        this.f118258a = r100;
    }

    @Override // vr1.e
    public final e0 a(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, RootDescription.ROOT_ELEMENT);
        i40.d r102 = this.f118258a.a(r100, r101);
        if (r102 != null) goto L7;
        return null;
    L7:
        return new e0(r102.f488135a, r102.f488136b);
    }

    @Override // vr1.e
    public final e0 b(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        i40.d r102 = this.f118258a.b(r100, r101);
        if (r102 != null) goto L7;
        return null;
    L7:
        return new e0(r102.f488135a, r102.f488136b);
    }

    @Override // vr1.e
    public final e0 c(Context r100, ViewGroup r110, int r111, int r112, int r113, int r114) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, RootDescription.ROOT_ELEMENT);
        this.f118258a.c(r100, r110, r111, r112, r113, r114);
        return null;
    }
}

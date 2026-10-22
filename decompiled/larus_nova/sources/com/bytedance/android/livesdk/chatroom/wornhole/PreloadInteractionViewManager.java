package com.bytedance.android.livesdk.chatroom.wornhole;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.asynclayoutinflater.view.AsyncLayoutInflater;
import com.bytedance.android.live.core.tetris.widgets.d;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.livesdk.preinflate.LiveNitaViewInfo;
import com.bytedance.android.livesdk.utils.LiveInflateUtil;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/wornhole/PreloadInteractionViewManager;", "Landroidx/asynclayoutinflater/view/AsyncLayoutInflater$OnInflateFinishedListener;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreloadInteractionViewManager implements AsyncLayoutInflater.OnInflateFinishedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static View f119290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static AsyncLayoutInflater f119291b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f119292c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final PreloadInteractionViewManager f119293d = null;

    private PreloadInteractionViewManager() {
    }

    static {
        f119293d = new PreloadInteractionViewManager();
    }

    @Override // androidx.asynclayoutinflater.view.AsyncLayoutInflater.OnInflateFinishedListener
    public final void onCancel(int r100) {
        f119292c = false;
    }

    public static View a(Context r100, ViewGroup r101) {
        long r102 = System.currentTimeMillis();
        LiveNitaViewInfo r103 = LiveNitaViewInfo.TTLIVE_FRAGMENT_PORTRAIT_INTERACTION;
        Activity r104 = ContextUtil.contextToActivity(r100);
        if (r104 == null) goto L7;
        View r105 = LiveInflateUtil.b("AudiencePortraitInteractionFragment", r103, r104, r101);
        d.g("create view, use time: " + (System.currentTimeMillis() - r102));
        return r105;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    }

    public static void b(Context r100, ViewGroup r101) {
        if (f119292c == false) goto L5;
        return;
    L5:
        d.g("start async inflate interaction view");
        if (f119291b != null) goto L8;
        f119291b = new AsyncLayoutInflater(r100);
    L8:
        AsyncLayoutInflater r102 = f119291b;
        if (r102 == null) goto L12;
        f119292c = true;
        r102.inflate(R.layout.ttlive_fragment_portrait_interaction, r101, f119293d);
        return;
    }

    public static View c(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (d.b() == false) goto L11;
        View r102 = f119290a;
        if (r102 == null) goto L8;
        Intrinsics.checkNotNull(r102);
        f119290a = null;
        b(r100, r101);
        d.g("used preload view");
        return r102;
    L8:
        b(r100, r101);
        return a(r100, r101);
    L11:
        return a(r100, r101);
    }

    @Override // androidx.asynclayoutinflater.view.AsyncLayoutInflater.OnInflateFinishedListener
    public final void onInflateFinished(View r100, int r101, ViewGroup r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        f119292c = false;
        f119290a = r100;
        d.g("async inflate interaction view success");
    }
}

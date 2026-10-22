package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.topcontrol;

import android.widget.ImageView;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.utils.fresco.FrescoLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.r3;
import com.larus.nova.R;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f144257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f144258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f144259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LifecycleOwner f144260d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c f144261e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f144262f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f144263g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f144264h;

    public final void a(boolean r100) {
        ImageView r101 = this.f144257a;
        if (r101 == null) goto L22;
        StringBuilder r102 = new StringBuilder();
        r102.append(s1.B(R.string.ttlive_ktv_origin));
        if (r100 == false) goto L7;
        int r103 = R.string.ttlive_anchor_replay_pre_setting_open;
    L8:
        r102.append(s1.B(r103));
        String r104 = r102.toString();
        r3.a(this.f144257a, r104);
        if (r100 == false) goto L17;
        if (this.f144263g == false) goto L14;
        r101.setBackgroundResource(R.drawable.ttlive_ktv_mv_origin_opened);
        goto L22
    L14:
        if (this.f144262f == false) goto L22;
        FrescoLoader r105 = FrescoLoader.with(r101.getContext());
        int r106 = com.bytedance.android.live.ktv.common.util.h.f70689a;
        r105.load("https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_ktv_component_top_bar_origin_open_ic_new.png").into(r101);
        goto L22
    L17:
        if (this.f144263g == false) goto L20;
        r101.setBackgroundResource(R.drawable.ttlive_ktv_mv_origin_closed);
        goto L22
    L20:
        if (this.f144262f == false) goto L22;
        FrescoLoader r107 = FrescoLoader.with(r101.getContext());
        int r108 = com.bytedance.android.live.ktv.common.util.h.f70689a;
        r107.load("https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_ktv_component_top_bar_origin_close_ic_new.png").into(r101);
        goto L22
    L7:
        r103 = R.string.ttlive_anchor_replay_pre_setting_close;
    L22:
        this.f144259c = r100;
    }

    public f(LifecycleOwner r100, com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r101, boolean r102, boolean r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r104, "requestPage");
        this.f144260d = r100;
        this.f144261e = r101;
        this.f144262f = r102;
        this.f144263g = r103;
        this.f144264h = r104;
        this.f144258b = new CompositeDisposable();
    }
}

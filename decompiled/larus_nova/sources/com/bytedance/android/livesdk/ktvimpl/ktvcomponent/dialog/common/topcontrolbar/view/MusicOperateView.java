package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.model.MusicOperateType;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdk.utils.x0;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b'\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\"\u0010\r\u001a\u00020\u00068\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010%\u001a\u0004\u0018\u00010\u001e8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006&"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/topcontrolbar/view/MusicOperateView;", "Landroid/widget/RelativeLayout;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/topcontrolbar/view/b;", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "Landroidx/lifecycle/Lifecycle;", "getLifecycleCompat", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Ljava/lang/String;", "getRequestPage", "()Ljava/lang/String;", "setRequestPage", "(Ljava/lang/String;)V", "requestPage", "Landroid/widget/LinearLayout;", "c", "Landroid/widget/LinearLayout;", "getMusicOperateLl", "()Landroid/widget/LinearLayout;", "setMusicOperateLl", "(Landroid/widget/LinearLayout;)V", "musicOperateLl", "Lcom/bytedance/android/live/core/widget/HSImageView;", "d", "Lcom/bytedance/android/live/core/widget/HSImageView;", "getMusicOperateIv", "()Lcom/bytedance/android/live/core/widget/HSImageView;", "setMusicOperateIv", "(Lcom/bytedance/android/live/core/widget/HSImageView;)V", "musicOperateIv", "Landroid/view/View;", "e", "Landroid/view/View;", "getRedDot", "()Landroid/view/View;", "setRedDot", "(Landroid/view/View;)V", "redDot", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class MusicOperateView extends RelativeLayout implements b, LifecycleOwnerCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f144172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LifecycleRegistry f144173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinearLayout f144174c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HSImageView f144175d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f144176e;

    public void c(boolean r100) {
    }

    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.CC.$default$getLifecycle(this);
    }

    public void onRelease() {
    }

    public final void k() {
        LinearLayout r100 = this.f144174c;
        if (r100 == null) goto L5;
        r100.setPadding(0, 0, 0, 0);
    L5:
        View r101 = this.f144176e;
        if (r101 == null) goto L9;
        r101.setVisibility(8);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f144173b.setCurrentState(Lifecycle.State.STARTED);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f144173b.setCurrentState(Lifecycle.State.DESTROYED);
    }

    @Override // com.bytedance.android.livesdk.utils.LifecycleOwnerCompat
    public Lifecycle getLifecycleCompat() {
        return this.f144173b;
    }

    public final HSImageView getMusicOperateIv() {
        return this.f144175d;
    }

    public final LinearLayout getMusicOperateLl() {
        return this.f144174c;
    }

    public final View getRedDot() {
        return this.f144176e;
    }

    public final String getRequestPage() {
        return this.f144172a;
    }

    public void g(int r100) {
        if (r100 != 0) goto L4;
        setVisibility(0);
        return;
    L4:
        if (r100 == 8) goto L6;
        setVisibility(4);
        return;
    L6:
        setVisibility(8);
    }

    public void h(MusicOperateType r100) {
        Intrinsics.checkNotNullParameter(r100, "musicOperateType");
        UtilityKotlinExtentionsKt.f(this);
    }

    public final void setMusicOperateIv(HSImageView r100) {
        this.f144175d = r100;
    }

    public final void setMusicOperateLl(LinearLayout r100) {
        this.f144174c = r100;
    }

    public final void setRedDot(View r100) {
        this.f144176e = r100;
    }

    public final void setRequestPage(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f144172a = r100;
    }

    public MusicOperateView(final MusicOperateType r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "musicOperateType");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r101, null, 0);
        this.f144172a = "";
        LifecycleRegistry r102 = new LifecycleRegistry(this);
        this.f144173b = r102;
        r102.setCurrentState(Lifecycle.State.CREATED);
        ViewGroup.LayoutParams r103 = getLayoutParams();
        if (r103 == null) goto L5;
        r103.width = s1.f(42.0f);
        r103.height = s1.f(32.0f);
    L6:
        setLayoutParams(r103);
        LayoutInflater.from(r101).inflate(R.layout.ttlive_ktv_component_music_operate_view_layout, this, true);
        setPadding(s1.f(10.0f), 0, 0, 0);
        this.f144174c = (LinearLayout) findViewById(R.id.music_operate_ll);
        this.f144175d = (HSImageView) findViewById(R.id.music_operate_iv);
        this.f144176e = findViewById(R.id.red_dot);
        k();
        setOnClickListener(x0.a(new AnonymousClass1(this, r100)));
        h(r100);
        return;
    L5:
        r103 = new ViewGroup.LayoutParams(s1.f(42.0f), s1.f(32.0f));
        goto L6
    }
}

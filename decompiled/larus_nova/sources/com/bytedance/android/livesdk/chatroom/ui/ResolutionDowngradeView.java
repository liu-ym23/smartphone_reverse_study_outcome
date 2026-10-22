package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u00109\u001a\u000208¢\u0006\u0004\b:\u0010;R*\u0010\u000b\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010#\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R(\u0010,\u001a\b\u0012\u0004\u0012\u00020%0$8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R*\u00105\u001a\u00020-2\u0006\u0010.\u001a\u00020-8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u00106\u001a\u00020\u001c8\u0006X\u0086D¢\u0006\f\n\u0004\b6\u0010\u001e\u001a\u0004\b7\u0010 ¨\u0006<"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/ResolutionDowngradeView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Landroid/view/LayoutInflater;", "getLayoutInflater", "()Landroid/view/LayoutInflater;", "setLayoutInflater", "(Landroid/view/LayoutInflater;)V", "layoutInflater", "Landroid/view/ViewGroup;", "b", "Landroid/view/ViewGroup;", "getRootView", "()Landroid/view/ViewGroup;", "setRootView", "(Landroid/view/ViewGroup;)V", "rootView", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "getResolutionTextView", "()Landroid/widget/TextView;", "setResolutionTextView", "(Landroid/widget/TextView;)V", "resolutionTextView", "", "d", "Z", "getAnimShowed", "()Z", "setAnimShowed", "(Z)V", "animShowed", "Lkotlin/Function0;", "", "e", "Lkotlin/jvm/functions/Function0;", "getOnSelectResolutionDowngrade", "()Lkotlin/jvm/functions/Function0;", "setOnSelectResolutionDowngrade", "(Lkotlin/jvm/functions/Function0;)V", "onSelectResolutionDowngrade", "", "value", "f", "Ljava/lang/String;", "getResolutionText", "()Ljava/lang/String;", "setResolutionText", "(Ljava/lang/String;)V", "resolutionText", "enableAnim", "getEnableAnim", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "liveui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ResolutionDowngradeView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LayoutInflater f112487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewGroup f112488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f112489c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f112490d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function0<Unit> f112491e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f112492f;

    public final boolean getEnableAnim() {
        return false;
    }

    public final boolean getAnimShowed() {
        return this.f112490d;
    }

    public final LayoutInflater getLayoutInflater() {
        return this.f112487a;
    }

    public Function0<Unit> getOnSelectResolutionDowngrade() {
        return this.f112491e;
    }

    public String getResolutionText() {
        return this.f112492f;
    }

    public final TextView getResolutionTextView() {
        return this.f112489c;
    }

    @Override // android.view.View
    public final ViewGroup getRootView() {
        return this.f112488b;
    }

    public ResolutionDowngradeView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        LayoutInflater r101 = LayoutInflater.from(r100);
        this.f112487a = r101;
        this.f112491e = ResolutionDowngradeView$onSelectResolutionDowngrade$1.INSTANCE;
        this.f112492f = "";
        TextView r102 = (TextView) r101.inflate(R.layout.ttlive_resolution_downgrade_view, this, true).findViewById(R.id.notification_resolution);
        this.f112489c = r102;
        if (r102 == null) goto L6;
        r102.setOnClickListener(new s8(this));
        return;
    }

    public final void setAnimShowed(boolean r100) {
        this.f112490d = r100;
    }

    public final void setLayoutInflater(LayoutInflater r100) {
        this.f112487a = r100;
    }

    public void setOnSelectResolutionDowngrade(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f112491e = r100;
    }

    public void setResolutionText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f112492f = r100;
        TextView r101 = this.f112489c;
        if (r101 == null) goto L6;
        r101.setText(r100);
        return;
    }

    public final void setResolutionTextView(TextView r100) {
        this.f112489c = r100;
    }

    public final void setRootView(ViewGroup r100) {
        this.f112488b = r100;
    }
}

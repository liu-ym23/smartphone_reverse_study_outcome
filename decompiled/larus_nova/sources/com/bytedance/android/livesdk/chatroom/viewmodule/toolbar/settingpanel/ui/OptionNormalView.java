package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import com.bytedance.android.livesdk.r3;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 \u0012\b\b\u0002\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\b¨\u0006&"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/settingpanel/ui/OptionNormalView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/widget/TextView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Landroid/widget/TextView;", "getTvTitle", "()Landroid/widget/TextView;", "setTvTitle", "(Landroid/widget/TextView;)V", "tvTitle", "Landroid/widget/ImageView;", "b", "Landroid/widget/ImageView;", "getIvTitleAbout", "()Landroid/widget/ImageView;", "setIvTitleAbout", "(Landroid/widget/ImageView;)V", "ivTitleAbout", "Lcom/bytedance/android/livesdk/chatroom/ui/LiveSwitchButton;", "c", "Lcom/bytedance/android/livesdk/chatroom/ui/LiveSwitchButton;", "getSwitchButton", "()Lcom/bytedance/android/livesdk/chatroom/ui/LiveSwitchButton;", "setSwitchButton", "(Lcom/bytedance/android/livesdk/chatroom/ui/LiveSwitchButton;)V", "switchButton", "d", "getTvDesc", "setTvDesc", "tvDesc", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OptionNormalView extends ConstraintLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f116765f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f116766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f116767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LiveSwitchButton f116768c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f116769d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CompositeDisposable f116770e;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OptionNormalView f116771a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f116772b;

        public a(OptionNormalView r100, Context r101) {
            this.f116771a = r100;
            this.f116772b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (r3.l(this.f116772b) == false) goto L8;
            LiveSwitchButton r101 = this.f116771a.getSwitchButton();
            if (r101 == null) goto L9;
            r101.performClick();
            return;
        L9:
            return;
        }
    }

    public OptionNormalView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OptionNormalView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f116770e.clear();
    }

    public final ImageView getIvTitleAbout() {
        return this.f116767b;
    }

    public final LiveSwitchButton getSwitchButton() {
        return this.f116768c;
    }

    public final TextView getTvDesc() {
        return this.f116769d;
    }

    public final TextView getTvTitle() {
        return this.f116766a;
    }

    public final void R5(boolean r100) {
        r3.n(this.f116768c);
        setImportantForAccessibility(1);
        TextView r101 = this.f116766a;
        if (r101 == null) goto L16;
        CharSequence r102 = r101.getText();
        if (r102 == null) goto L17;
        String r103 = r102.toString();
        if (r103 == null) goto L18;
        StringBuilder r104 = new StringBuilder();
        r104.append(r103);
        r104.append(" ");
        if (r100 == false) goto L11;
        String r105 = "开启";
    L12:
        r104.append(r105);
        String r106 = r104.toString();
        if (r106 == null) goto L19;
        setContentDescription(r106);
        return;
    L19:
        return;
    L11:
        r105 = "关闭";
        goto L12
    L18:
        return;
    L17:
        return;
    }

    public final void setIvTitleAbout(ImageView r100) {
        this.f116767b = r100;
    }

    public final void setSwitchButton(LiveSwitchButton r100) {
        this.f116768c = r100;
    }

    public final void setTvDesc(TextView r100) {
        this.f116769d = r100;
    }

    public final void setTvTitle(TextView r100) {
        this.f116766a = r100;
    }

    public OptionNormalView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        int r103 = UtilityKotlinExtentionsKt.i(16);
        View r104 = LayoutInflater.from(r100).inflate(R.layout.ttlive_view_webcast_setting_option_normal, this);
        r104.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -2));
        r104.setPadding(0, 0, 0, r103);
        setImportantForAccessibility(1);
        setFocusable(true);
        setClickable(true);
        setOnClickListener(new a(this, r100));
        this.f116766a = (TextView) findViewById(R.id.tvTitle);
        this.f116767b = (ImageView) findViewById(R.id.ivTitleAbout);
        this.f116768c = (LiveSwitchButton) findViewById(R.id.switchButton);
        this.f116769d = (TextView) findViewById(R.id.tvDesc);
        this.f116770e = new CompositeDisposable();
    }

    public /* synthetic */ OptionNormalView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}

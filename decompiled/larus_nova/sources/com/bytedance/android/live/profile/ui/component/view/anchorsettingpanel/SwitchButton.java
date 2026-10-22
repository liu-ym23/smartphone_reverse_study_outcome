package com.bytedance.android.live.profile.ui.component.view.anchorsettingpanel;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.transition.TransitionManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0013B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J)\u0010\n\u001a\u00020\u00042!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00040\u0006¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/profile/ui/component/view/anchorsettingpanel/SwitchButton;", "Landroid/widget/FrameLayout;", "", "isChecked", "", "setState", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "action", "setSwitchListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SwitchButton extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ConstraintLayout f86852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f86853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f86854c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f86855d;

    public static final class a {
    }

    static {
    }

    public SwitchButton(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SwitchButton(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void a(boolean r100) {
        if (r100 == false) goto L4;
        int r101 = ColorProtector.parseColor("#33E088");
    L5:
        ConstraintLayout r102 = this.f86852a;
        Drawable r103 = null;
        if (r102 == null) goto L8;
        Drawable r104 = r102.getBackground();
    L10:
        if ((r104 instanceof GradientDrawable) == false) goto L13;
        r103 = r104;
    L13:
        GradientDrawable r105 = (GradientDrawable) r103;
        if (r105 != null) goto L16;
        return;
    L16:
        r105.mutate();
        r105.setColor(r101);
        return;
    L8:
        r104 = null;
        goto L10
    L4:
        r101 = ColorProtector.parseColor("#33161823");
        goto L5
    }

    public final void setState(boolean r100) {
        this.f86854c = r100;
        a(r100);
        b(r100, true);
    }

    public final void setSwitchListener(Function1<? super Boolean, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.f86855d = r100;
    }

    public final void b(boolean r100, boolean r101) {
        ConstraintLayout r102 = this.f86852a;
        if (r102 == null) goto L12;
        ConstraintSet r103 = new ConstraintSet();
        r103.clone(r102);
        if (r100 == false) goto L7;
        r103.clear(R.id.button, 1);
        r103.connect(R.id.button, 2, 0, 2);
    L8:
        if (r101 == false) goto L10;
        TransitionManager.beginDelayedTransition(r102);
    L10:
        r103.applyTo(r102);
        return;
    L7:
        r103.clear(R.id.button, 2);
        r103.connect(R.id.button, 1, 0, 1);
        goto L8
    }

    public SwitchButton(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(getContext()).inflate(R.layout.ttlive_profile_anchor_setting_panel_switch_button, this, true);
        this.f86852a = (ConstraintLayout) findViewById(R.id.root);
        this.f86853b = findViewById(R.id.button);
        ConstraintLayout r103 = this.f86852a;
        if (r103 == null) goto L6;
        r103.setOnClickListener(new com.bytedance.android.live.profile.ui.component.view.anchorsettingpanel.a(new SwitchButton$init$1(this)));
        return;
    }

    public /* synthetic */ SwitchButton(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}

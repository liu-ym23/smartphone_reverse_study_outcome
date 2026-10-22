package com.stepos.widget.toggle;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.R$attr;
import androidx.appcompat.widget.SwitchCompat;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.widget.R;
import com.stepos.widget.internal.SwitchHapticFeedback;
import f.C4027a;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import x5.d;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0016\u0018\u0000 #2\u00020\u0001:\u0001#B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0018\u0010\u0011R\u0016\u0010\u0019\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001aR*\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u000e8G@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010\u0011R\u0014\u0010\"\u001a\u00020\u000e8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001f¨\u0006$"}, d2 = {"Lcom/stepos/widget/toggle/StepOSSwitch;", "Landroidx/appcompat/widget/SwitchCompat;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "LY8/t;", "applyDisabledOpacity", "()V", "toggle", "", "checked", "setCheckedWithHapticFeedback", "(Z)V", "setChecked", "Landroid/view/MotionEvent;", "event", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", d.EXTRA_ENABLED, "setEnabled", "handlingTouch", "Z", "requestingHapticFeedback", "dispatchingCheckedChange", UxipConstants.f30680s, "isSwitchHapticFeedbackEnabled", "()Z", "setSwitchHapticFeedbackEnabled", "isUserCheckedChange$StepOSWidget_release", "isUserCheckedChange", "Companion", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public class StepOSSwitch extends SwitchCompat {
    private static final Companion Companion = new Companion(null);
    private static final float DISABLED_ALPHA = 0.3f;
    private boolean dispatchingCheckedChange;
    private boolean handlingTouch;
    private boolean isSwitchHapticFeedbackEnabled;
    private boolean requestingHapticFeedback;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/stepos/widget/toggle/StepOSSwitch$Companion;", "", "<init>", "()V", "DISABLED_ALPHA", "", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSSwitch(Context context) {
        this(context, null, 0, 6, null);
        p.i(context, "context");
    }

    private final void applyDisabledOpacity() {
        setAlpha(isEnabled() ? 1.0f : 0.3f);
    }

    /* renamed from: isSwitchHapticFeedbackEnabled, reason: from getter */
    public final boolean getIsSwitchHapticFeedbackEnabled() {
        return this.isSwitchHapticFeedbackEnabled;
    }

    public final boolean isUserCheckedChange$StepOSWidget_release() {
        return this.handlingTouch || this.requestingHapticFeedback;
    }

    @Override // androidx.appcompat.widget.SwitchCompat, android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        p.i(event, "event");
        boolean z10 = this.handlingTouch;
        this.handlingTouch = true;
        try {
            return super.onTouchEvent(event);
        } finally {
            this.handlingTouch = z10;
        }
    }

    @Override // androidx.appcompat.widget.SwitchCompat, android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean checked) {
        if (!this.dispatchingCheckedChange && ((this.handlingTouch || this.requestingHapticFeedback) && this.isSwitchHapticFeedbackEnabled && isChecked() != checked)) {
            SwitchHapticFeedback.INSTANCE.perform(this);
        }
        boolean z10 = this.dispatchingCheckedChange;
        this.dispatchingCheckedChange = true;
        try {
            super.setChecked(checked);
        } finally {
            this.dispatchingCheckedChange = z10;
        }
    }

    public final void setCheckedWithHapticFeedback(boolean checked) {
        boolean z10 = this.requestingHapticFeedback;
        this.requestingHapticFeedback = true;
        try {
            setChecked(checked);
        } finally {
            this.requestingHapticFeedback = z10;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        applyDisabledOpacity();
    }

    public final void setSwitchHapticFeedbackEnabled(boolean z10) {
        this.isSwitchHapticFeedbackEnabled = z10;
    }

    @Override // androidx.appcompat.widget.SwitchCompat, android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setCheckedWithHapticFeedback(!isChecked());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSSwitch(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        p.i(context, "context");
    }

    public /* synthetic */ StepOSSwitch(Context context, AttributeSet attributeSet, int i10, int i11, i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? R$attr.switchStyle : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSSwitch(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        p.i(context, "context");
        this.isSwitchHapticFeedbackEnabled = true;
        setBackground(null);
        setTrackDrawable(C4027a.b(context, R.drawable.stepos_switch_track));
        setThumbDrawable(C4027a.b(context, R.drawable.stepos_switch_thumb));
        setTrackTintList(C4027a.a(context, R.color.stepos_switch_track_tint));
        setThumbTintList(C4027a.a(context, R.color.stepos_switch_thumb_tint));
        setShowText(false);
        setSwitchMinWidth(getResources().getDimensionPixelSize(R.dimen.stepos_switch_track_width));
        applyDisabledOpacity();
    }
}

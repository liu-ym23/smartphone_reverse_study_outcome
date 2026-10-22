package com.obric.oui.oswitch;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.content.ContextCompat;
import com.bytedanceos.common.ui.CommonConfirmDialog;
import com.bytedanceos.common.ui.animation.AnimationConstants;
import com.obric.common.oui.R$attr;
import com.obric.common.oui.R$drawable;
import com.obric.common.oui.R$styleable;
import com.obric.oui.utils.log.L;
import com.tmall.wireless.tangram.structure.card.FixCard;
import com.ttnet.org.chromium.net.PrivateKeyType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.f;
import tc.l;
import td.c;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u0000 Q2\u00020\u0001:\u0001RB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u0015\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0018\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u001c\u0010\u0016J\u0017\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001d\u0010\u0016J\u0017\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001e\u0010\u0016J\u001f\u0010!\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0006H\u0016¢\u0006\u0004\b!\u0010\"J7\u0010(\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u0006H\u0014¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\fH\u0014¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\fH\u0002¢\u0006\u0004\b,\u0010+J\u000f\u0010-\u001a\u00020\fH\u0002¢\u0006\u0004\b-\u0010+J\u001f\u0010/\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010.\u001a\u00020\u0013H\u0002¢\u0006\u0004\b/\u00100J\u001f\u00103\u001a\u0002022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00101\u001a\u00020\u0013H\u0002¢\u0006\u0004\b3\u00104J\u0017\u00105\u001a\u00020\f2\u0006\u00101\u001a\u00020\u0013H\u0002¢\u0006\u0004\b5\u0010\u0016J\u0017\u00106\u001a\u00020\f2\u0006\u00101\u001a\u00020\u0013H\u0002¢\u0006\u0004\b6\u0010\u0016J\u001b\u0010:\u001a\n 9*\u0004\u0018\u00010808*\u000207H\u0002¢\u0006\u0004\b:\u0010;J#\u0010>\u001a\u00020\f2\b\b\u0002\u0010<\u001a\u00020\u00062\b\b\u0002\u0010=\u001a\u00020\u0006H\u0002¢\u0006\u0004\b>\u0010\"R\u0016\u0010A\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010C\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010@R\u0016\u0010F\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010I\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bG\u0010HR\u0014\u0010M\u001a\u00020J8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bK\u0010LR\u0014\u0010P\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bN\u0010O¨\u0006S"}, d2 = {"Lcom/obric/oui/oswitch/OSwitch;", "Lcom/obric/oui/oswitch/SwitchCompat;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/view/MotionEvent;", "ev", "", "stopDrag", "(Landroid/view/MotionEvent;)V", "Landroid/graphics/drawable/Drawable;", "getUncheckedDrawable", "()Landroid/graphics/drawable/Drawable;", "getCheckedDrawable", "", "change", "setChangeAlphaWhenDisable", "(Z)V", "enabled", "setEnabled", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", CommonConfirmDialog.ARGS_CHECKED, "setCheckedWithoutFeedback", "setChecked", "setCheckedNoAnim", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "onAttachedToWindow", "()V", "u", "t", "withAnim", "s", "(ZZ)V", "isChecked", "Lhd/a;", "q", "(Landroid/content/Context;Z)Lhd/a;", "n", "m", "Landroid/graphics/drawable/TransitionDrawable;", "", "kotlin.jvm.PlatformType", "r", "(Landroid/graphics/drawable/TransitionDrawable;)Ljava/lang/Object;", "xAmount", "yAmount", "o", "W", "I", "trackUnchecked", "a0", "trackChecked", "b0", "Z", "changeAlphaWhenDisable", "getTargetCheckedState", "()Z", "targetCheckedState", "", "getThumbPosition", "()F", "thumbPosition", "getTouchMode", "()I", "touchMode", "c0", "a", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSwitch extends SwitchCompat {

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final a f15709c0 = null;
    public int W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f15710a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f15711b0;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f15709c0 = new a(null);
    }

    @JvmOverloads
    public OSwitch(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    private final Drawable getCheckedDrawable() {
        if (this.f15710a0 != 0) goto L5;
        Drawable r10 = ContextCompat.d(getContext(), R$drawable.o_switch_track_checked);
        q.d(r10);
        Drawable r11 = r10.mutate();
        q.f(r11, "{\n            ContextCom…      .mutate()\n        }");
        return r11;
    L5:
        Drawable r12 = ContextCompat.d(getContext(), this.f15710a0);
        q.d(r12);
        Drawable r13 = r12.mutate();
        q.f(r13, "{\n            ContextCom…ked)!!.mutate()\n        }");
        return r13;
    }

    private final boolean getTargetCheckedState() {
        if (getThumbPosition() <= 0.5f) goto L5;
        return true;
    L5:
        return false;
    }

    private final float getThumbPosition() {
        Field r10 = SwitchCompat.class.getDeclaredField(FixCard.FixStyle.KEY_X);     // Catch: IllegalAccessException -> L5 NoSuchFieldException -> L7
        r10.setAccessible(true);     // Catch: IllegalAccessException -> L5 NoSuchFieldException -> L7
        Object r11 = r10.get(this);     // Catch: IllegalAccessException -> L5 NoSuchFieldException -> L7
        if (r11 == null) goto L10;
        return ((Float) r11).floatValue();
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");     // Catch: IllegalAccessException -> L5 NoSuchFieldException -> L7
    L5:
        e = move-exception;
        e.printStackTrace();
    L13:
        return 0.0f;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L13
    }

    private final int getTouchMode() {
        Field r10 = SwitchCompat.class.getDeclaredField("r");     // Catch: IllegalAccessException -> L5 NoSuchFieldException -> L7
        r10.setAccessible(true);     // Catch: IllegalAccessException -> L5 NoSuchFieldException -> L7
        Object r11 = r10.get(this);     // Catch: IllegalAccessException -> L5 NoSuchFieldException -> L7
        if (r11 == null) goto L10;
        return ((Integer) r11).intValue();
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");     // Catch: IllegalAccessException -> L5 NoSuchFieldException -> L7
    L5:
        e = move-exception;
        e.printStackTrace();
    L13:
        return 0;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L13
    }

    private final Drawable getUncheckedDrawable() {
        if (this.W != 0) goto L5;
        Drawable r10 = ContextCompat.d(getContext(), R$drawable.o_switch_track_unchecked);
        q.d(r10);
        Drawable r11 = r10.mutate();
        q.f(r11, "{\n            ContextCom…      .mutate()\n        }");
        return r11;
    L5:
        Drawable r12 = ContextCompat.d(getContext(), this.W);
        q.d(r12);
        Drawable r13 = r12.mutate();
        q.f(r13, "{\n            ContextCom…ked)!!.mutate()\n        }");
        return r13;
    }

    public static /* synthetic */ void p(OSwitch r10, int r11, int r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = 20;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r12 = 20;
    L8:
        r10.o(r11, r12);
    }

    private final void stopDrag(MotionEvent r10) {
        t();
        boolean r11 = true;
        if (r10.getAction() == 1) goto L5;
    L7:
        r11 = false;
    L8:
        boolean r12 = isChecked();
        if (r11 == false) goto L11;
        boolean r13 = getTargetCheckedState();
    L12:
        if (r13 == r12) goto L14;
        playSoundEffect(0);
    L14:
        setChecked(r13);
        MotionEvent r14 = MotionEvent.obtain(r10);
        r14.setAction(3);
        q.f(r14, "cancel");
        super.onTouchEvent(r14);
        r14.recycle();
        return;
    L11:
        r13 = r12;
        goto L12
    L5:
        if (isEnabled() == false) goto L7;
        goto L7
    }

    public final void m(boolean r10) {
        Drawable r11 = getTrackDrawable();
        if ((r11 instanceof TransitionDrawable) == false) goto L8;
        if (r10 == false) goto L6;
        r((TransitionDrawable) r11);
        return;
    L6:
        ((TransitionDrawable) r11).resetTransition();
        return;
    L8:
        if ((r11 instanceof hd.a) == false) goto L15;
        if (r10 == false) goto L11;
        ((hd.a) r11).d();
        return;
    L11:
        ((hd.a) r11).b();
        return;
    }

    public final void n(boolean r10) {
        Drawable r11 = getTrackDrawable();
        if ((r11 instanceof TransitionDrawable) == false) goto L8;
        if (r10 == false) goto L6;
        ((TransitionDrawable) r11).startTransition(260);
        return;
    L6:
        ((TransitionDrawable) r11).reverseTransition(100);
        return;
    L8:
        if ((r11 instanceof hd.a) == false) goto L15;
        if (r10 == false) goto L11;
        ((hd.a) r11).e(260);
        return;
    L11:
        ((hd.a) r11).c(100);
        return;
    }

    public final void o(int r10, int r11) {
        measure(0, 0);     // Catch: Exception -> L18
        int r12 = getMeasuredWidth();     // Catch: Exception -> L18
        int r13 = getMeasuredHeight();     // Catch: Exception -> L18
        if (r12 <= 0) goto L22;
        if (r13 <= 0) goto L27;
        int r14 = f.r(this, r10) + r12;     // Catch: Exception -> L18
        int r15 = f.r(this, r11) + r13;     // Catch: Exception -> L18
        c r16 = c.f24796a;     // Catch: Exception -> L18
        ViewParent r17 = getParent();     // Catch: Exception -> L18
        if (r17 != null) goto L11;
    L9:
        r17 = null;
    L12:
        ViewGroup r18 = (ViewGroup) r17;     // Catch: Exception -> L18
        if (r18 == null) goto L20;
        r18.measure(0, 0);     // Catch: Exception -> L18
        int r19 = r18.getMeasuredWidth();     // Catch: Exception -> L18
        if (r15 > r18.getMeasuredHeight()) goto L17;
        if (r14 <= r19) goto L20;
    L17:
        l.e(r18, r14, r15, false, 4, null);     // Catch: Exception -> L18
    L20:
        l.e(this, r14, r15, false, 4, null);     // Catch: Exception -> L18
        return;
    L11:
        if ((r17 instanceof ViewGroup) == false) goto L9;
    L27:
        return;
    L22:
        return;
    L18:
        e = move-exception;
        L.c("OSwitch", "increaseTouchArea, error", e);
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        p(this, 0, 0, 3, null);
    }

    @Override // com.obric.oui.oswitch.SwitchCompat, android.widget.TextView, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
    }

    @Override // com.obric.oui.oswitch.SwitchCompat, android.widget.TextView, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
    }

    @Override // com.obric.oui.oswitch.SwitchCompat, android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        q.g(r10, "ev");
        if (r10.getAction() == 3) goto L7;
        if (r10.getAction() == 1) goto L7;
    L11:
        return super.onTouchEvent(r10);
    L7:
        if (getTouchMode() != 2) goto L11;
        stopDrag(r10);
        super.onTouchEvent(r10);
        return true;
    }

    public final hd.a q(Context r10, boolean r11) {
        hd.a r12 = new hd.a(getUncheckedDrawable(), getCheckedDrawable());
        if (r11 == false) goto L5;
        r12.e(0);
    L6:
        return r12;
    L5:
        r12.b();
        goto L6
    }

    public final Object r(TransitionDrawable r10) {
        Method r11 = TransitionDrawable.class.getDeclaredMethod("showSecondLayer", null);     // Catch: Exception -> L4
        r11.setAccessible(true);     // Catch: Exception -> L4
        return r11.invoke(r10, null);
    L4:
        e = move-exception;
        L.c("OSwitch", "reflectShowSecondLayer, error", e);
        return Unit.f21064a;
    }

    public final void s(boolean r10, boolean r11) {
        if (r10 == isChecked()) goto L19;
        if (r11 == false) goto L19;
        if ((getTrackDrawable() instanceof TransitionDrawable) == false) goto L19;
        if (r10 == false) goto L14;
        Drawable r12 = getTrackDrawable();
        if (r12 == null) goto L13;
        ((TransitionDrawable) r12).startTransition(AnimationConstants.DURATION_180);
        goto L19
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
    L14:
        Drawable r13 = getTrackDrawable();
        if (r13 == null) goto L18;
        ((TransitionDrawable) r13).reverseTransition(AnimationConstants.DURATION_180);
        goto L19
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
    L19:
        super.setChecked(r10);
    }

    public final void setChangeAlphaWhenDisable(boolean r10) {
        if (this.f15711b0 == r10) goto L6;
        this.f15711b0 = r10;
        u();
        return;
    }

    @Override // com.obric.oui.oswitch.SwitchCompat, android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r10) {
        boolean r11 = isChecked();
        super.setChecked(r10);
        boolean r12 = isChecked();
        u();
        if (getWindowToken() != null) goto L5;
    L8:
        m(r12);
        return;
    L5:
        if (e() == false) goto L8;
        if (r11 == r12) goto L10;
        n(r12);
        return;
    }

    @Override // com.obric.oui.oswitch.SwitchCompat
    public void setCheckedNoAnim(boolean r10) {
        super.setCheckedNoAnim(r10);
        m(r10);
    }

    @Deprecated(message = "use setHapticFeedbackEnabled instead")
    public final void setCheckedWithoutFeedback(boolean r10) {
        s(r10, true);
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean r10) {
        super.setEnabled(r10);
        u();
    }

    public final void t() {
        Field r10 = SwitchCompat.class.getDeclaredField("r");     // Catch: IllegalAccessException -> L4 NoSuchFieldException -> L6
        r10.setAccessible(true);     // Catch: IllegalAccessException -> L4 NoSuchFieldException -> L6
        r10.set(this, 0);     // Catch: IllegalAccessException -> L4 NoSuchFieldException -> L6
    L14:
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    public final void u() {
        if (this.f15711b0 == true) goto L5;
        Drawable r10 = getTrackDrawable();
        if (r10 == null) goto L36;
        r10.setAlpha(PrivateKeyType.INVALID);
    L36:
        Drawable r11 = getThumbDrawable();
        if (r11 == null) goto L47;
        r11.setAlpha(PrivateKeyType.INVALID);
        return;
    L47:
        return;
    L5:
        if (isEnabled() == false) goto L15;
        Drawable r12 = getTrackDrawable();
        if (r12 == null) goto L10;
        r12.setAlpha(PrivateKeyType.INVALID);
    L10:
        Drawable r13 = getThumbDrawable();
        if (r13 == null) goto L44;
        r13.setAlpha(PrivateKeyType.INVALID);
        return;
    L44:
        return;
    L15:
        if (isChecked() == false) goto L24;
        Drawable r14 = getTrackDrawable();
        if (r14 == null) goto L20;
        r14.setAlpha(76);
    L20:
        Drawable r15 = getThumbDrawable();
        if (r15 == null) goto L45;
        r15.setAlpha(127);
        return;
    L45:
        return;
    L24:
        Drawable r16 = getTrackDrawable();
        if (r16 == null) goto L28;
        r16.setAlpha(76);
    L28:
        Drawable r17 = getThumbDrawable();
        if (r17 == null) goto L46;
        r17.setAlpha(PrivateKeyType.INVALID);
        return;
    }

    @JvmOverloads
    public OSwitch(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ OSwitch(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = R$attr.OUISwitchStyle;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public OSwitch(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        this.f15711b0 = true;
        int[] r13 = R$styleable.OSwitch;
        q.f(r13, "OSwitch");
        TypedArray r14 = r10.obtainStyledAttributes(r11, r13, r12, 0);
        q.f(r14, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        this.W = r14.getResourceId(R$styleable.OSwitch_oui_trackUnchecked, 0);
        this.f15710a0 = r14.getResourceId(R$styleable.OSwitch_oui_trackChecked, 0);
        this.f15711b0 = r14.getBoolean(R$styleable.OSwitch_oui_disabledAlpha, true);
        r14.recycle();
        if (getThumbDrawable() != null) goto L6;
        setThumbDrawable(ContextCompat.d(r10, R$drawable.o_switch_thumb));
    L6:
        if (getTrackDrawable() != null) goto L8;
        setTrackDrawable(q(r10, isChecked()));
    L8:
        setEnabled(isEnabled());
    }
}

package eb;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Vibrator;
import android.provider.Settings;
import android.view.MotionEvent;
import com.stepos.agentsafetycenter.R;
import id.k;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import m.k2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a extends k2 {

    /* renamed from: a0, reason: collision with root package name */
    public boolean f3745a0;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f3746b0;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f3747c0;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f3748d0;

    public a(Context context) {
        super(context);
        this.f3748d0 = true;
        setTrackDrawable(k.v(R.drawable.stepos_switch_track, context));
        setThumbDrawable(k.v(R.drawable.stepos_switch_thumb, context));
        setTrackTintList(k.u(R.color.stepos_switch_track_tint, context));
        setThumbTintList(k.u(R.color.stepos_switch_thumb_tint, context));
        setShowText(false);
        setSwitchMinWidth(getResources().getDimensionPixelSize(R.dimen.stepos_switch_track_width));
    }

    @Override // m.k2, android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        motionEvent.getClass();
        boolean z10 = this.f3745a0;
        this.f3745a0 = true;
        try {
            return super.onTouchEvent(motionEvent);
        } finally {
            this.f3745a0 = z10;
        }
    }

    @Override // m.k2, android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z10) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Vibrator vibrator;
        Method method;
        Boolean bool;
        Object objInvoke;
        Boolean bool2;
        ContentResolver contentResolver;
        if (!this.f3747c0 && ((this.f3745a0 || this.f3746b0) && this.f3748d0 && isChecked() != z10)) {
            Context context = getContext();
            context.getClass();
            try {
                contentResolver = context.getContentResolver();
            } catch (Exception unused) {
            }
            if (Settings.System.getInt(contentResolver, "vibrate_on", 1) != 0 && Settings.System.getInt(contentResolver, "haptic_feedback_enabled", 1) != 0) {
                if (Settings.System.getInt(contentResolver, "haptic_feedback_intensity", 2) != 0) {
                    try {
                        method = Class.forName("android.os.SystemProperties").getMethod("getBoolean", String.class, Boolean.TYPE);
                        bool = Boolean.FALSE;
                        objInvoke = method.invoke(null, "ro.stepos.shell_hapticfeedback_motor", bool);
                        bool2 = Boolean.TRUE;
                    } catch (Exception unused2) {
                    }
                    if (!yb.k.a(objInvoke, bool2)) {
                        if (!yb.k.a(method.invoke(null, "ro.stepos.use_qcom_vibrate", bool), bool2)) {
                            if (d3.a.a(context, "android.permission.VIBRATE") == 0 && (vibrator = (Vibrator) context.getSystemService(Vibrator.class)) != null && vibrator.hasVibrator()) {
                                vibrator.vibrate(50L);
                            }
                        }
                    }
                    performHapticFeedback(31022);
                }
            }
        }
        boolean z11 = this.f3747c0;
        this.f3747c0 = true;
        try {
            super.setChecked(z10);
        } finally {
            this.f3747c0 = z11;
        }
    }

    public final void setCheckedWithHapticFeedback(boolean z10) {
        boolean z11 = this.f3746b0;
        this.f3746b0 = true;
        try {
            setChecked(z10);
        } finally {
            this.f3746b0 = z11;
        }
    }

    public final void setSwitchHapticFeedbackEnabled(boolean z10) {
        this.f3748d0 = z10;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void toggle() {
        setCheckedWithHapticFeedback(!isChecked());
    }
}

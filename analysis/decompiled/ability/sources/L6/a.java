package L6;

import E6.i;
import android.view.MotionEvent;
import androidx.annotation.MainThread;
import androidx.appcompat.widget.SwitchCompat;
import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class a extends SwitchCompat {

    /* renamed from: a, reason: collision with root package name */
    public boolean f936a;
    public boolean b;
    public boolean c;
    public boolean d;

    @Override // androidx.appcompat.widget.SwitchCompat, android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent event) {
        k.f(event, "event");
        boolean z10 = this.f936a;
        this.f936a = true;
        try {
            return super.onTouchEvent(event);
        } finally {
            this.f936a = z10;
        }
    }

    @Override // androidx.appcompat.widget.SwitchCompat, android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z10) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (!this.c && ((this.f936a || this.b) && this.d && isChecked() != z10)) {
            i.a(this);
        }
        boolean z11 = this.c;
        this.c = true;
        try {
            super.setChecked(z10);
        } finally {
            this.c = z11;
        }
    }

    @MainThread
    public final void setCheckedWithHapticFeedback(boolean z10) {
        boolean z11 = this.b;
        this.b = true;
        try {
            setChecked(z10);
        } finally {
            this.b = z11;
        }
    }

    @MainThread
    public final void setSwitchHapticFeedbackEnabled(boolean z10) {
        this.d = z10;
    }

    @Override // androidx.appcompat.widget.SwitchCompat, android.widget.CompoundButton, android.widget.Checkable
    public final void toggle() {
        setCheckedWithHapticFeedback(!isChecked());
    }
}

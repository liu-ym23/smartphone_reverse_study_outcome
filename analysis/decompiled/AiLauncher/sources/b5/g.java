package b5;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import v9.C5685n;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0001¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroid/widget/EditText;", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Landroid/widget/EditText;)V", "agent_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class g {
    @SuppressLint({"ClickableViewAccessibility"})
    public static final void b(final EditText editText) {
        p.i(editText, "<this>");
        editText.setHapticFeedbackEnabled(false);
        editText.setLongClickable(false);
        editText.setTextIsSelectable(false);
        editText.setOnTouchListener(new View.OnTouchListener() { // from class: b5.f
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return g.c(editText, view, motionEvent);
            }
        });
    }

    public static final boolean c(EditText editText, View view, MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 1 && motionEvent.getEventTime() - motionEvent.getDownTime() < ViewConfiguration.getLongPressTimeout()) {
            editText.performClick();
            editText.requestFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) editText.getContext().getSystemService(InputMethodManager.class);
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(editText, 1);
            }
            editText.setSelection(C5685n.n(editText.getOffsetForPosition(motionEvent.getX(), motionEvent.getY()), 0, editText.getText().length()));
        }
        return true;
    }
}

package w1;

import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;
import com.stepos.stepclaw.SecurePrefs;
import g.g0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class v extends e0.b {
    public final TextInputLayout d;

    public v(TextInputLayout textInputLayout) {
        this.d = textInputLayout;
    }

    @Override // e0.b
    public final void d(View view, f0.g gVar) {
        AccessibilityNodeInfo accessibilityNodeInfo = gVar.f2542a;
        this.f2288a.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        TextInputLayout textInputLayout = this.d;
        EditText editText = textInputLayout.getEditText();
        Editable text = editText != null ? editText.getText() : null;
        CharSequence hint = textInputLayout.getHint();
        CharSequence error = textInputLayout.getError();
        CharSequence placeholderText = textInputLayout.getPlaceholderText();
        int counterMaxLength = textInputLayout.getCounterMaxLength();
        CharSequence counterOverflowDescription = textInputLayout.getCounterOverflowDescription();
        boolean zIsEmpty = TextUtils.isEmpty(text);
        boolean zIsEmpty2 = TextUtils.isEmpty(hint);
        boolean z = textInputLayout.f1394w0;
        boolean zIsEmpty3 = TextUtils.isEmpty(error);
        boolean z2 = (zIsEmpty3 && TextUtils.isEmpty(counterOverflowDescription)) ? false : true;
        String string = !zIsEmpty2 ? hint.toString() : SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        t tVar = textInputLayout.f1354b;
        g0 g0Var = tVar.f6170b;
        if (g0Var.getVisibility() == 0) {
            accessibilityNodeInfo.setLabelFor(g0Var);
            accessibilityNodeInfo.setTraversalAfter(g0Var);
        } else {
            accessibilityNodeInfo.setTraversalAfter(tVar.d);
        }
        if (!zIsEmpty) {
            accessibilityNodeInfo.setText(text);
        } else if (!TextUtils.isEmpty(string)) {
            accessibilityNodeInfo.setText(string);
            if (!z && placeholderText != null) {
                accessibilityNodeInfo.setText(string + ", " + ((Object) placeholderText));
            }
        } else if (placeholderText != null) {
            accessibilityNodeInfo.setText(placeholderText);
        }
        if (!TextUtils.isEmpty(string)) {
            accessibilityNodeInfo.setHintText(string);
            accessibilityNodeInfo.setShowingHintText(zIsEmpty);
        }
        if (text == null || text.length() != counterMaxLength) {
            counterMaxLength = -1;
        }
        accessibilityNodeInfo.setMaxTextLength(counterMaxLength);
        if (z2) {
            if (zIsEmpty3) {
                error = counterOverflowDescription;
            }
            accessibilityNodeInfo.setError(error);
        }
        g0 g0Var2 = textInputLayout.f1371l.y;
        if (g0Var2 != null) {
            accessibilityNodeInfo.setLabelFor(g0Var2);
        }
        textInputLayout.f1356c.b().m(gVar);
    }

    @Override // e0.b
    public final void e(View view, AccessibilityEvent accessibilityEvent) {
        super.e(view, accessibilityEvent);
        this.d.f1356c.b().n(accessibilityEvent);
    }
}

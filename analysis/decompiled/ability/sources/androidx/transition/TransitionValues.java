package androidx.transition;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class TransitionValues {

    @SuppressLint({"UnknownNullness"})
    public View view;
    public final Map<String, Object> values = new HashMap();
    final ArrayList<Transition> mTargetedTransitions = new ArrayList<>();

    @Deprecated
    public TransitionValues() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TransitionValues)) {
            return false;
        }
        TransitionValues transitionValues = (TransitionValues) obj;
        return this.view == transitionValues.view && this.values.equals(transitionValues.values);
    }

    public int hashCode() {
        return this.values.hashCode() + (this.view.hashCode() * 31);
    }

    @NonNull
    public String toString() {
        StringBuilder sbX = androidx.appfunctions.metadata.a.x("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n", "    view = ");
        sbX.append(this.view);
        sbX.append("\n");
        String strL = androidx.appfunctions.metadata.a.l(sbX.toString(), "    values:");
        for (String str : this.values.keySet()) {
            strL = strL + "    " + str + ": " + this.values.get(str) + "\n";
        }
        return strL;
    }

    public TransitionValues(@NonNull View view) {
        this.view = view;
    }
}

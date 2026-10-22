package androidx.transition;

import android.view.View;
import com.ss.android.lark.widget.codeblock.entity.LineContent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes17.dex */
public class TransitionValues {
    final ArrayList<Transition> mTargetedTransitions;
    public final Map<String, Object> values;
    public View view;

    public int hashCode() {
        return (this.view.hashCode() * 31) + this.values.hashCode();
    }

    public String toString() {
        String r100 = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.view + "\n") + "    values:";
        Iterator<String> r101 = this.values.keySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        String r102 = r101.next();
        r100 = r100 + LineContent.FOUR_SPACE + r102 + ": " + this.values.get(r102) + "\n";
        goto L4
    L6:
        return r100;
    }

    public TransitionValues() {
        this.values = new HashMap();
        this.mTargetedTransitions = new ArrayList();
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof TransitionValues) == false) goto L10;
        TransitionValues r101 = (TransitionValues) r100;
        if (this.view == r101.view) goto L7;
        return false;
    L7:
        if (this.values.equals(r101.values) == false) goto L13;
        return true;
    L13:
        return false;
    L10:
        return false;
    }
}

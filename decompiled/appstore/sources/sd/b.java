package sd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.obric.common.oui.R$layout;
import com.obric.oui.button.OButton;
import com.obric.oui.titlebar.optimize.OCTitleBar;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b {
    public static final OButton a(OCTitleBar r10, Context r11, int r12) {
        q.g(r10, "<this>");
        q.g(r11, "context");
        View r13 = LayoutInflater.from(r11).inflate(r12, r10, false);
        if (r13 == null) goto L7;
        return (OButton) r13;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.button.OButton");
    }

    public static final OButton b(OCTitleBar r10, Context r11) {
        q.g(r10, "<this>");
        q.g(r11, "context");
        return a(r10, r11, R$layout.o_widget_titlebar_trans_icon_button);
    }
}

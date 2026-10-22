package bd;

import android.content.Context;
import com.bytedanceos.common.toolbox.ServerElements;
import com.obric.oui.dialog.base.AbstractDialog;
import com.obric.oui.dialog.v2.alert.style.AlertDialogHost;
import com.obric.oui.dialog.v2.alert.style.DialogContainer;
import com.obric.oui.dialog.v2.alert.style.StyleController;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public class e implements StyleController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1 f5995a;

    public e(Function1 r10) {
        q.g(r10, ServerElements.BODY);
        this.f5995a = r10;
    }

    @Override // com.obric.oui.dialog.v2.alert.style.StyleController
    public void attachToDialog(AbstractDialog r10) {
        StyleController.a.a(this, r10);
    }

    @Override // com.obric.oui.dialog.v2.alert.style.StyleController
    public void attachToHost(AlertDialogHost r10) {
        q.g(r10, "host");
        StyleController.a.b(this, r10);
    }

    @Override // com.obric.oui.dialog.v2.alert.style.StyleController
    public void attachToParent(Context r10, DialogContainer r11) {
        q.g(r10, "context");
        q.g(r11, "dialogContainer");
        this.f5995a.invoke(r11);
    }
}

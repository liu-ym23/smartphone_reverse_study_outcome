package obric.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;

/* JADX INFO: loaded from: classes5.dex */
public class BaseResolverDialog extends Dialog {
    protected void handlePackagesChanged() {
    }

    public BaseResolverDialog(Context context) {
        super(context);
    }

    public BaseResolverDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    protected BaseResolverDialog(Context context, boolean cancelable, DialogInterface.OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }
}

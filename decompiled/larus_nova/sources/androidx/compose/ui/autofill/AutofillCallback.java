package androidx.compose.ui.autofill;

import android.view.View;
import com.xiaomi.mipush.sdk.MiPushClient;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/autofill/AutofillCallback;", "Landroid/view/autofill/AutofillManager$AutofillCallback;", "<init>", "()V", "onAutofillEvent", "", "view", "Landroid/view/View;", "virtualId", "", "event", MiPushClient.COMMAND_REGISTER, "autofill", "Landroidx/compose/ui/autofill/AndroidAutofill;", MiPushClient.COMMAND_UNREGISTER, "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AutofillCallback extends android.view.autofill.AutofillManager.AutofillCallback {
    public static final int $stable = 0;
    public static final AutofillCallback INSTANCE = null;

    static {
        INSTANCE = new AutofillCallback();
        $stable = 8;
    }

    private AutofillCallback() {
    }

    public final void register(AndroidAutofill r100) {
        r100.getAutofillManager().registerCallback(this);
    }

    public final void unregister(AndroidAutofill r100) {
        r100.getAutofillManager().unregisterCallback(this);
    }

    @Override // android.view.autofill.AutofillManager.AutofillCallback
    public void onAutofillEvent(View r100, int r101, int r102) {
        super.onAutofillEvent(r100, r101, r102);
    }
}

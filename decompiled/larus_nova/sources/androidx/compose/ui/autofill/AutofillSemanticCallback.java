package androidx.compose.ui.autofill;

import android.view.View;
import com.xiaomi.mipush.sdk.MiPushClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/autofill/AutofillSemanticCallback;", "Landroid/view/autofill/AutofillManager$AutofillCallback;", "<init>", "()V", "onAutofillEvent", "", "view", "Landroid/view/View;", "virtualId", "", "event", MiPushClient.COMMAND_REGISTER, "androidAutofillManager", "Landroidx/compose/ui/autofill/AndroidAutofillManager;", MiPushClient.COMMAND_UNREGISTER, "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AutofillSemanticCallback extends android.view.autofill.AutofillManager.AutofillCallback {
    public static final int $stable = 0;
    public static final AutofillSemanticCallback INSTANCE = null;

    static {
        INSTANCE = new AutofillSemanticCallback();
        $stable = 8;
    }

    private AutofillSemanticCallback() {
    }

    public final void register(AndroidAutofillManager r100) {
        PlatformAutofillManager r101 = r100.getPlatformAutofillManager();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type androidx.compose.ui.autofill.PlatformAutofillManagerImpl");
        ((PlatformAutofillManagerImpl) r101).getPlatformAndroidManager().registerCallback(this);
    }

    public final void unregister(AndroidAutofillManager r100) {
        PlatformAutofillManager r101 = r100.getPlatformAutofillManager();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type androidx.compose.ui.autofill.PlatformAutofillManagerImpl");
        ((PlatformAutofillManagerImpl) r101).getPlatformAndroidManager().unregisterCallback(this);
    }

    @Override // android.view.autofill.AutofillManager.AutofillCallback
    public void onAutofillEvent(View r100, int r101, int r102) {
        super.onAutofillEvent(r100, r101, r102);
    }
}

package android.preference;

import android.app.AlertDialog;
import android.content.DialogInterface;

/* loaded from: classes.dex */
public class StepOSListPreferenceExtImpl implements IStepOSListPreferenceExt {
    public void onAttach(ListPreference host) {
    }

    public void onPrepareListDialogBuilder(ListPreference host, AlertDialog.Builder builder) {
        if (host.getContext().isDeviceDefaultTheme()) {
            builder.setNegativeButton((CharSequence) null, (DialogInterface.OnClickListener) null);
        }
    }
}

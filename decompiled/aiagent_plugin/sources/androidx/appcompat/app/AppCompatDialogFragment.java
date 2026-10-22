package androidx.appcompat.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatDialogFragment extends DialogFragment {
    public AppCompatDialogFragment() {
    }

    public AppCompatDialogFragment(int r1) {
        super(r1);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle r4) {
        return new AppCompatDialog((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), getTheme());
    }

    @Override // androidx.fragment.app.DialogFragment
    public void setupDialog(Dialog r3, int r4) {
        if (ZeusTransformUtils.instanceOf(r3, AppCompatDialog.class) == false) goto L13;
        AppCompatDialog r2 = (AppCompatDialog) ZeusTransformUtils.preCheckCast(r3, AppCompatDialog.class, "com.obric.aiagent.plugin");
        if (r4 != 1) goto L7;
    L12:
        r2.supportRequestWindowFeature(1);
        return;
    L7:
        if (r4 == 2) goto L12;
        if (r4 != 3) goto L16;
        r3.getWindow().addFlags(24);
        goto L12
    L16:
        return;
    L13:
        super.setupDialog(r3, r4);
    }
}

package com.obric.oui.sheet;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: OSheet.kt */
/* JADX INFO: loaded from: classes4.dex */
public class OSheet extends BottomSheetDialogFragment {
    public OSheet() {
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle r5) {
        OBottomSheetDialog r6 = new OBottomSheetDialog((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.style.AppBottomSheetDialogTheme, "style", "AppBottomSheetDialogTheme"));
        r6.getBehavior().c(true);
        BottomSheetBehavior<FrameLayout> r4 = r6.getBehavior();
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r1, "context");
        r4.c(g.b(r1));
        return (Dialog) ZeusTransformUtils.preCheckCast(r6, Dialog.class, "com.obric.aiagent.plugin");
    }
}

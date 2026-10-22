package com.obric.oui.sheet;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OExpandableSheet.kt */
/* JADX INFO: loaded from: classes4.dex */
public class OExpandableSheet extends OSheet {
    public OExpandableSheet() {
    }

    @Override // com.obric.oui.sheet.OSheet, com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle r5) {
        OBottomSheetDialog r6 = new OBottomSheetDialog((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.style.AppBottomSheetDialogTheme, "style", "AppBottomSheetDialogTheme"));
        r6.setDismissWithAnimation(false);
        r6.getBehavior().c(true);
        r6.getBehavior().a(true);
        r6.setIs69Expandable(true);
        return (Dialog) ZeusTransformUtils.preCheckCast(r6, Dialog.class, "com.obric.aiagent.plugin");
    }
}

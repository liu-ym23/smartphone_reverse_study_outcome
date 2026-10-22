package com.obric.autoaction.app.launcherpage.detail.base;

import android.content.Context;
import com.obric.oui.sheet.v2.OSheet;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: BaseOSheetDialogFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class BottomImmersionOSheet extends OSheet {
    private boolean ignoreInsetBottom;

    public BottomImmersionOSheet(Context r9) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        super(r1, 0, 0, false, false, 30, null);
        this.ignoreInsetBottom = true;
    }

    @Override // com.obric.oui.sheet.v2.OSheet, com.obric.oui.sheet.v2.a
    public boolean getIgnoreInsetBottom() {
        return this.ignoreInsetBottom;
    }

    @Override // com.obric.oui.sheet.v2.OSheet, com.obric.oui.sheet.v2.a
    public void setIgnoreInsetBottom(boolean r1) {
        this.ignoreInsetBottom = r1;
    }
}

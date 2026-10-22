package com.bytedanceos.common.tangram.view;

import android.content.Context;
import com.bytedanceos.common.model.AppInfo;
import com.tmall.wireless.tangram.structure.BaseCell;

/* JADX INFO: loaded from: classes2.dex */
public class TangramViewPagerItemView extends TangramAppItemView {
    public TangramViewPagerItemView(Context r10) {
        super(r10);
        addLeftMarginForLine();
        addNameRlMargin();
        this.f9962a = false;
    }

    @Override // com.bytedanceos.common.tangram.view.TangramAppItemView, com.bytedanceos.common.tangram.Bind
    public /* bridge */ /* synthetic */ void bindData(AppInfo r10, BaseCell r11) {
        g(r10, r11);
    }

    @Override // com.bytedanceos.common.tangram.view.TangramAppItemView
    public void g(AppInfo r10, BaseCell r11) {
        super.g(r10, r11);
        int r12 = r11.extras.optInt("colum");     // Catch: Exception -> L7
        showLine(!i(r11.pos, r12, r11.extras.optInt("show_count") / r12));     // Catch: Exception -> L7
        if (j(r11.pos, r12) == false) goto L10;
        addRightMarginForAppStatusView();     // Catch: Exception -> L7
        addRightMarginForLine();     // Catch: Exception -> L7
        return;
    L10:
        return;
    }

    public final boolean i(int r10, int r11, int r12) {
        int r13 = 1;
    L3:
        if (r13 > r11) goto L8;
        if (r10 == ((r13 * r12) - 1)) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return true;
    L8:
        return false;
    }

    public final boolean j(int r10, int r11) {
        if ((r10 / r11) == (r11 - 1)) goto L7;
        return false;
    L7:
        return true;
    }
}

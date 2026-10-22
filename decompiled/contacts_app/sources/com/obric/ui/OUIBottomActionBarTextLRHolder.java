package com.obric.ui;

import android.content.Context;
import com.obric.oui.actionbar.v2.OBottomActionBarFloating;
import com.obric.oui.button.OButtonFloating;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OUIBottomActionBarTextLRHolder.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/obric/ui/OUIBottomActionBarTextLRHolder;", "", "bottomActionBar", "Lcom/obric/oui/actionbar/v2/OBottomActionBarFloating;", "leftBtnText", "", "rightBtnText", "(Lcom/obric/oui/actionbar/v2/OBottomActionBarFloating;Ljava/lang/String;Ljava/lang/String;)V", "getBottomActionBar", "()Lcom/obric/oui/actionbar/v2/OBottomActionBarFloating;", "leftBtn", "Lcom/obric/oui/button/OButtonFloating;", "getLeftBtn", "()Lcom/obric/oui/button/OButtonFloating;", "rightBtn", "getRightBtn", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class OUIBottomActionBarTextLRHolder {
    private final OBottomActionBarFloating bottomActionBar;
    private final OButtonFloating leftBtn;
    private final OButtonFloating rightBtn;

    public OUIBottomActionBarTextLRHolder(OBottomActionBarFloating r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r5, "bottomActionBar");
        Intrinsics.checkNotNullParameter(r6, "leftBtnText");
        Intrinsics.checkNotNullParameter(r7, "rightBtnText");
        this.bottomActionBar = r5;
        Context r0 = r5.getContext();
        Intrinsics.checkNotNullExpressionValue(r0, "bottomActionBar.context");
        OButtonFloating r8 = OUIHelper.OUIBottomActionBar.createSingleTextButton$default(r0, r6, null, 4, null);
        this.leftBtn = r8;
        Context r1 = r5.getContext();
        Intrinsics.checkNotNullExpressionValue(r1, "bottomActionBar.context");
        OButtonFloating r9 = OUIHelper.OUIBottomActionBar.createSingleTextButton$default(r1, r7, null, 4, null);
        this.rightBtn = r9;
        ArrayList r4 = new ArrayList();
        r4.add(r8);
        r4.add(r9);
        r5.setButtons(r4);
    }

    public final OBottomActionBarFloating getBottomActionBar() {
        return this.bottomActionBar;
    }

    public final OButtonFloating getLeftBtn() {
        return this.leftBtn;
    }

    public final OButtonFloating getRightBtn() {
        return this.rightBtn;
    }
}

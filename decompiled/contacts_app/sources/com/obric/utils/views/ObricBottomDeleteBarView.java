package com.obric.utils.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.android.contacts.R;
import com.obric.oui.actionbar.v2.OBottomActionBarFloating;
import com.obric.oui.button.OButtonFloating;
import com.obric.oui.layout.OUIRelativeLayout;
import com.obric.oui.utils.StyleUtil;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ObricBottomDeleteBarView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/obric/utils/views/ObricBottomDeleteBarView;", "Lcom/obric/oui/layout/OUIRelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "bottomDeleteFloatingBar", "Lcom/obric/oui/actionbar/v2/OBottomActionBarFloating;", "getBottomDeleteFloatingBar", "()Lcom/obric/oui/actionbar/v2/OBottomActionBarFloating;", "deleteBtn", "Lcom/obric/oui/button/OButtonFloating;", "getDeleteBtn", "()Lcom/obric/oui/button/OButtonFloating;", "createSingleButton", "text", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ObricBottomDeleteBarView extends OUIRelativeLayout {
    private final OBottomActionBarFloating bottomDeleteFloatingBar;
    private final OButtonFloating deleteBtn;

    public ObricBottomDeleteBarView(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, null, 0, 0, 14, null);
    }

    public ObricBottomDeleteBarView(Context r9, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, r10, 0, 0, 12, null);
    }

    public ObricBottomDeleteBarView(Context r9, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, r10, r11, 0, 8, null);
    }

    public /* synthetic */ ObricBottomDeleteBarView(Context r2, AttributeSet r3, int r4, int r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = 0;
    L11:
        this(r2, r3, r4, r5);
    }

    public ObricBottomDeleteBarView(Context r8, AttributeSet r9, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9, r10, null, 8, null);
        RelativeLayout.inflate(r8, R.layout.obric_bottom_delete_floating_bar, this);
        View r12 = findViewById(R.id.bottom_delete_floating_bar);
        Intrinsics.checkNotNull(r12);
        OBottomActionBarFloating r13 = (OBottomActionBarFloating) r12;
        this.bottomDeleteFloatingBar = r13;
        String r14 = r8.getResources().getString(R.string.delete_btn);
        Intrinsics.checkNotNullExpressionValue(r14, "context.resources.getString(R.string.delete_btn)");
        OButtonFloating r15 = createSingleButton(r8, r14);
        this.deleteBtn = r15;
        ArrayList r7 = new ArrayList();
        r7.add(r15);
        r13.setButtons(r7);
    }

    public final OButtonFloating getDeleteBtn() {
        return this.deleteBtn;
    }

    public final OBottomActionBarFloating getBottomDeleteFloatingBar() {
        return this.bottomDeleteFloatingBar;
    }

    private final OButtonFloating createSingleButton(final Context r1, final String r2) {
        return (OButtonFloating) StyleUtil.createWidgetWithStyle(r1, 2131952506, new AnonymousClass1(r2, r1));
    }
}

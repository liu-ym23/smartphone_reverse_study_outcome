package com.android.contacts.util;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.widget.FixHeightByItemCountListView;
import com.obric.oui.button.OButton;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.sheet.OInsetSheet;
import com.obric.oui.sheet.OInsetSheetTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public class AccountSelectionMenuDialog extends Dialog {
    private Context mContext;
    private OInsetSheet mOInsetSheet;

    public AccountSelectionMenuDialog(Context r2) {
        super(r2, R.style.MenuDialogTheme);
        this.mContext = r2;
        init();
    }

    @Override // android.app.Dialog
    public void setTitle(int r3) {
        this.mOInsetSheet.setHeaderView(getAccountSelectionHeaderView(this.mContext.getString(r3)));
    }

    public void setTitle(String r2) {
        this.mOInsetSheet.setHeaderView(getAccountSelectionHeaderView(r2));
    }

    private void init() {
        OInsetSheet r0 = new OInsetSheet(this.mContext);
        this.mOInsetSheet = r0;
        r0.setRootWidth(OInsetSheet.PanelWidth.NARROW_WIDTH);
        this.mOInsetSheet.setFooterView(null);
    }

    private View getAccountSelectionHeaderView(String r3) {
        OInsetSheetTitleBar r0 = new OInsetSheetTitleBar(getContext());
        r0.setShowLeftBack(false);
        r0.setTitleText(r3);
        OButton r4 = r0.createNeutralButton(getContext(), r0.mRightContainer);
        r4.setButtonSourceBitmap(R.drawable.o_ic_close);
        r4.setOnClickListener(new AnonymousClass1(this));
        return r0;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void setAdapter(ListAdapter r5, final DialogInterface.OnClickListener r6) {
        int r0 = ContactsUtils.dipTopx(getContext(), 15.0d);
        int r1 = ContactsUtils.dipTopx(getContext(), 10.0d);
        LinearLayout r2 = new LinearLayout(getContext());
        r2.setOrientation(1);
        r2.setPadding(r1, 0, r1, r0);
        LinearLayout.LayoutParams r3 = new LinearLayout.LayoutParams(-2, -2);
        r3.gravity = 17;
        FixHeightByItemCountListView r4 = new FixHeightByItemCountListView(getContext());
        r4.setItemHeight(OUnitExtensionKt.dp2px(68));
        r4.setAdapter(r5);
        r4.setOnItemClickListener(new AnonymousClass2(this, r6));
        r2.addView(r4, r3);
        this.mOInsetSheet.setContainerView(r2);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.mOInsetSheet.dismiss();
    }

    @Override // android.app.Dialog
    public void show() {
        this.mOInsetSheet.show();
    }
}

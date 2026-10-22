package br4;

import android.text.Editable;
import android.text.TextUtils;
import com.bytedance.ee.bear.bitable.card.view.cell.number.STNumberKeyboardView;
import com.bytedance.ee.bear.bitable.celleditor.bean.CommonEditorModel;
import com.bytedance.ee.bear.bitable.celleditor.editor.number.NumberEditorModel;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.bitable.databinding.BitableCardTextEditorPanelBinding;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import java.math.BigDecimal;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b extends yq4.a<NumberEditorModel> {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final hr4.a f20130u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final com.bytedance.ee.bear.bitable.celleditor.editor.b f20131v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final com.bytedance.ee.bear.bitable.card.view.cell.number.a f20132w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public NumberEditorModel f20133x;

    public static final class a implements com.bytedance.ee.bear.bitable.card.view.cell.number.a.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f20134a;

        public a(b r100) {
            this.f20134a = r100;
        }

        @Override // com.bytedance.ee.bear.bitable.card.view.cell.number.a.c
        public final void a(boolean r100) {
            this.f20134a.B();
        }
    }

    /* JADX INFO: renamed from: br4.b$b, reason: collision with other inner class name */
    public static final class C0346b implements com.bytedance.ee.bear.bitable.card.view.cell.number.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f20135a;

        public C0346b(b r100) {
            this.f20135a = r100;
        }

        @Override // com.bytedance.ee.bear.bitable.card.view.cell.number.a.d
        public final void a(int r100) {
            BitableAnalytic r101 = this.f20135a.f20130u.f486862d;
            r101.getClass();
            HashMap r102 = new HashMap();
            if (r100 != 1003) goto L5;
            r102.put("click", "minus");
        L5:
            r101.t(BitableAnalytic.KeyboardEvent.BITABLE_KEYBOARD_CLICK_EVENT, r102);
        }
    }

    public static final class c {
    }

    static {
    }

    @Override // yq4.a, com.bytedance.ee.bear.bitable.celleditor.editor.BaseEditorPanel, hp4.g, com.bytedance.ee.bear.bitable.celleditor.editor.g
    public final void show() {
        C(false, 200);
    }

    @Override // yq4.a
    public final void B() {
        com.bytedance.ee.bear.bitable.card.view.cell.number.a r100 = this.f20132w;
        if (r100.f207923c == false) goto L6;
        r100.c(false);
        return;
    }

    @Override // yq4.a
    public final void D() {
        com.bytedance.ee.bear.bitable.card.view.cell.number.a r100 = this.f20132w;
        if (r100.f207923c == true) goto L6;
        BitableCardTextEditorPanelBinding r101 = this.f568742r;
        r100.d(r101.f210712f, r101.f210711e.getText());
        return;
    }

    @Override // yq4.a
    public final void E() {
        String r100 = String.valueOf(this.f568742r.f210711e.getText());     // Catch: NumberFormatException -> L14
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L7:
        Double r101 = null;
    L8:
        hr4.a r102 = this.f20130u;     // Catch: NumberFormatException -> L14
        NumberEditorModel r103 = this.f20133x;     // Catch: NumberFormatException -> L14
        if (r103 == null) goto L11;
        String r104 = r103.getFieldUIType();     // Catch: NumberFormatException -> L14
    L12:
        r102.b(r104, null, null);     // Catch: NumberFormatException -> L14
        this.f20131v.c(r101);     // Catch: NumberFormatException -> L14
        return;
    L11:
        r104 = null;
        goto L12
    L5:
        if (TextUtils.equals("-", r100) == true) goto L7;
        r101 = Double.valueOf(CastDoubleProtector.parseDouble(r100));     // Catch: NumberFormatException -> L14
    L14:
        e = move-exception;
        tt5.a.e("NumberEditorPanel", "onEditCell error", e, false);
        if (TextUtils.equals(e.getMessage(), "multiple points") == false) goto L18;
        Toast.showFailureText(this.f486397a, R.string.Doc_Block_NotSupportMultiplePoints);
        return;
    L18:
        Toast.showFailureText(this.f486397a, R.string.Doc_Block_OnlySupportNumber);
    }

    @Override // yq4.a
    public final void A(Editable r100) {
        super.A(r100);
        if (r100 != null) goto L5;
        return;
    L5:
        com.bytedance.ee.bear.bitable.card.view.cell.number.a r101 = this.f20132w;
        if (r101.f207923c == false) goto L15;
        STNumberKeyboardView r102 = r101.f207922b;
        if (r102 == null) goto L10;
        Editable r103 = r102.getEditableText();
    L12:
        if (Intrinsics.areEqual(r103, r100) == true) goto L16;
        this.f20132w.a(r100);
        return;
    L16:
        return;
    L10:
        r103 = null;
        goto L12
    }

    public b(hr4.a r100, com.bytedance.ee.bear.bitable.celleditor.editor.b r101) {
        Intrinsics.checkNotNullParameter(r100, "mEditorContext");
        Intrinsics.checkNotNullParameter(r101, "mActionHandler");
        super(r100, r101);
        this.f20130u = r100;
        this.f20131v = r101;
        com.bytedance.ee.bear.bitable.card.view.cell.number.a r102 = new com.bytedance.ee.bear.bitable.card.view.cell.number.a(this.f486397a, false);
        this.f20132w = r102;
        rcb.c.b(this.f568742r.f210711e);
        r102.f207924d = new a(this);
        r102.f207925e = new C0346b(this);
    }

    @Override // com.bytedance.ee.bear.bitable.celleditor.editor.g
    public final void b(CommonEditorModel r100, String r101) {
        NumberEditorModel r102 = (NumberEditorModel) r100;
        Intrinsics.checkNotNullParameter(r102, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, "originData");
        this.f20133x = r102;
    L7:
        e = move-exception;
        tt5.a.e("NumberEditorPanel", "setData error", e, false);
    L9:
        String r103 = "";
    L10:
        this.f568742r.f210711e.setText(Editable.Factory.getInstance().newEditable(r103));
        this.f568742r.f210711e.setSelection(r103.length());
        this.f568742r.f210709c.setTitle(r102.getFieldName());
        return;
    L4:
        if (r102.getValue() == null) goto L9;
        r103 = new BigDecimal(String.valueOf(r102.getValue())).toPlainString();     // Catch: Exception -> L7
        goto L10
    }
}

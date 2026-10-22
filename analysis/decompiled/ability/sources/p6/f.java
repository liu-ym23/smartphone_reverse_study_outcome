package p6;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import com.google.android.material.button.MaterialButton;
import com.stepos.ability.R;
import f6.AbstractC1436a;

/* loaded from: classes3.dex */
public final class f extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    public m f5544a;
    public n b;
    public MaterialButton c;
    public MaterialButton d;

    @Override // android.app.Dialog
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_phone_authorization);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        View viewFindViewById = findViewById(R.id.btn_deny);
        kotlin.jvm.internal.k.e(viewFindViewById, "findViewById(...)");
        this.c = (MaterialButton) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.btn_confirm);
        kotlin.jvm.internal.k.e(viewFindViewById2, "findViewById(...)");
        MaterialButton materialButton = (MaterialButton) viewFindViewById2;
        this.d = materialButton;
        materialButton.setText(getContext().getString(R.string.auth_dialog_button_go_settings));
        MaterialButton materialButton2 = this.c;
        if (materialButton2 == null) {
            kotlin.jvm.internal.k.n("btnDeny");
            throw null;
        }
        final int i = 0;
        materialButton2.setOnClickListener(new View.OnClickListener(this) { // from class: p6.e
            public final /* synthetic */ f b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i) {
                    case 0:
                        AbstractC1436a.d("PhoneAuthorizationDialog", "[LOOP-DEBUG] PhoneAuthorizationDialog: DENY clicked", true);
                        f fVar = this.b;
                        n nVar = fVar.b;
                        if (nVar != null) {
                            nVar.invoke();
                        }
                        fVar.dismiss();
                        break;
                    default:
                        AbstractC1436a.d("PhoneAuthorizationDialog", "[LOOP-DEBUG] PhoneAuthorizationDialog: GO_SETTINGS clicked", true);
                        f fVar2 = this.b;
                        m mVar = fVar2.f5544a;
                        if (mVar != null) {
                            mVar.invoke();
                        }
                        fVar2.dismiss();
                        break;
                }
            }
        });
        MaterialButton materialButton3 = this.d;
        if (materialButton3 == null) {
            kotlin.jvm.internal.k.n("btnGoSettings");
            throw null;
        }
        final int i6 = 1;
        materialButton3.setOnClickListener(new View.OnClickListener(this) { // from class: p6.e
            public final /* synthetic */ f b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i6) {
                    case 0:
                        AbstractC1436a.d("PhoneAuthorizationDialog", "[LOOP-DEBUG] PhoneAuthorizationDialog: DENY clicked", true);
                        f fVar = this.b;
                        n nVar = fVar.b;
                        if (nVar != null) {
                            nVar.invoke();
                        }
                        fVar.dismiss();
                        break;
                    default:
                        AbstractC1436a.d("PhoneAuthorizationDialog", "[LOOP-DEBUG] PhoneAuthorizationDialog: GO_SETTINGS clicked", true);
                        f fVar2 = this.b;
                        m mVar = fVar2.f5544a;
                        if (mVar != null) {
                            mVar.invoke();
                        }
                        fVar2.dismiss();
                        break;
                }
            }
        });
    }
}

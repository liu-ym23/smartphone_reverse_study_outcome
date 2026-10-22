package p6;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.stepos.ability.R;
import f6.AbstractC1436a;

/* loaded from: classes3.dex */
public final class d extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    public final String f5542a;
    public final String b;
    public final String c;
    public final String d;
    public S7.a e;
    public S7.a f;
    public TextView g;
    public TextView h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context, String str, String str2, String str3, String str4, String logLabel) {
        super(com.stepos.statsrpk.d.P(context), R.style.PhoneAuthBottomSheetDialog);
        kotlin.jvm.internal.k.f(context, "context");
        kotlin.jvm.internal.k.f(logLabel, "logLabel");
        this.f5542a = str;
        this.b = str3;
        this.c = str4;
        this.d = logLabel;
    }

    public final void a() throws Resources.NotFoundException {
        AbstractC1436a.d("PhoneAuthBottomSheet", B7.a.n("[LOOP-DEBUG] PhoneAuthBottomSheetDialog.showFromService called, label=", this.d, ", thread=", Thread.currentThread().getName()), true);
        b.a(this, R.dimen.bottom_sheet_margin_horizontal, R.dimen.bottom_sheet_margin_bottom, R.dimen.bottom_sheet_padding_top, R.dimen.bottom_sheet_content_button_spacing, R.dimen.bottom_sheet_button_height, R.dimen.bottom_sheet_padding_bottom, 0.0f, true, 30);
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_phone_auth_bottom_sheet);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        View viewFindViewById = findViewById(R.id.btn_deny);
        kotlin.jvm.internal.k.e(viewFindViewById, "findViewById(...)");
        this.g = (TextView) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.btn_confirm);
        kotlin.jvm.internal.k.e(viewFindViewById2, "findViewById(...)");
        this.h = (TextView) viewFindViewById2;
        TextView textView = (TextView) findViewById(R.id.tv_title);
        String str = this.f5542a;
        if (j9.m.s0(str)) {
            textView.setVisibility(8);
        } else {
            textView.setText(str);
        }
        TextView textView2 = this.g;
        if (textView2 == null) {
            kotlin.jvm.internal.k.n("btnDeny");
            throw null;
        }
        textView2.setText(this.c);
        TextView textView3 = this.h;
        if (textView3 == null) {
            kotlin.jvm.internal.k.n("btnConfirm");
            throw null;
        }
        textView3.setText(this.b);
        TextView textView4 = this.g;
        if (textView4 == null) {
            kotlin.jvm.internal.k.n("btnDeny");
            throw null;
        }
        final int i = 0;
        textView4.setOnClickListener(new View.OnClickListener(this) { // from class: p6.c
            public final /* synthetic */ d b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i) {
                    case 0:
                        d dVar = this.b;
                        AbstractC1436a.d("PhoneAuthBottomSheet", "[LOOP-DEBUG] PhoneAuthBottomSheetDialog: DENY clicked, label=" + dVar.d, true);
                        S7.a aVar = dVar.f;
                        if (aVar != null) {
                            aVar.invoke();
                        }
                        dVar.dismiss();
                        break;
                    default:
                        d dVar2 = this.b;
                        AbstractC1436a.d("PhoneAuthBottomSheet", "[LOOP-DEBUG] PhoneAuthBottomSheetDialog: CONFIRM clicked, label=" + dVar2.d, true);
                        S7.a aVar2 = dVar2.e;
                        if (aVar2 != null) {
                            aVar2.invoke();
                        }
                        dVar2.dismiss();
                        break;
                }
            }
        });
        TextView textView5 = this.h;
        if (textView5 == null) {
            kotlin.jvm.internal.k.n("btnConfirm");
            throw null;
        }
        final int i6 = 1;
        textView5.setOnClickListener(new View.OnClickListener(this) { // from class: p6.c
            public final /* synthetic */ d b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i6) {
                    case 0:
                        d dVar = this.b;
                        AbstractC1436a.d("PhoneAuthBottomSheet", "[LOOP-DEBUG] PhoneAuthBottomSheetDialog: DENY clicked, label=" + dVar.d, true);
                        S7.a aVar = dVar.f;
                        if (aVar != null) {
                            aVar.invoke();
                        }
                        dVar.dismiss();
                        break;
                    default:
                        d dVar2 = this.b;
                        AbstractC1436a.d("PhoneAuthBottomSheet", "[LOOP-DEBUG] PhoneAuthBottomSheetDialog: CONFIRM clicked, label=" + dVar2.d, true);
                        S7.a aVar2 = dVar2.e;
                        if (aVar2 != null) {
                            aVar2.invoke();
                        }
                        dVar2.dismiss();
                        break;
                }
            }
        });
    }
}

package Ic;

import Ic.c;
import android.content.Context;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.stepos.common.R$dimen;
import java.util.Collections;
import java.util.List;
import stepos.support.v7.appcompat.R$id;
import stepos.support.v7.appcompat.R$layout;
import stepos.support.v7.appcompat.R$string;

/* loaded from: classes5.dex */
public class h implements d {

    /* renamed from: a, reason: collision with root package name */
    public final Context f3473a;

    /* renamed from: b, reason: collision with root package name */
    public TextView f3474b;

    /* renamed from: c, reason: collision with root package name */
    public TextView f3475c;

    /* renamed from: d, reason: collision with root package name */
    public stepos.support.v7.permission.e f3476d;

    public h(Context context) {
        this.f3473a = context;
        this.f3476d = stepos.support.v7.permission.e.b(context);
    }

    private int b(TextView textView, String str) {
        TransformationMethod transformationMethod = textView.getTransformationMethod();
        if (transformationMethod != null) {
            str = transformationMethod.getTransformation(str, textView).toString();
        }
        return (int) textView.getPaint().measureText(str);
    }

    private boolean c(TextView textView) {
        ViewGroup viewGroup = (ViewGroup) textView.getParent().getParent();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewGroup.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
        return (b(textView, textView.getText().toString()) + (((textView.getPaddingLeft() + textView.getPaddingRight()) + viewGroup.getPaddingLeft()) + viewGroup.getPaddingRight())) + (((marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) <= this.f3473a.getResources().getDimensionPixelOffset(R$dimen.stepos_alert_dialog_width);
    }

    @Override // Ic.d
    public void a(c.a aVar) {
        String str;
        if (TextUtils.isEmpty(aVar.f3440e)) {
            String[] strArr = aVar.f3438c;
            if (strArr == null || strArr.length <= 0) {
                str = null;
            } else {
                try {
                    StringBuilder sb2 = new StringBuilder();
                    int i10 = 0;
                    while (true) {
                        String[] strArr2 = aVar.f3438c;
                        if (i10 >= strArr2.length) {
                            break;
                        }
                        String strD = this.f3476d.d(this.f3473a, strArr2[i10]);
                        if (!TextUtils.isEmpty(strD)) {
                            sb2.append(strD);
                            sb2.append("、");
                        }
                        i10++;
                    }
                    if (sb2.length() > 0) {
                        sb2.setLength(sb2.length() - 1);
                    }
                    str = String.format(this.f3473a.getResources().getString(R$string.stepos_permission_message_supplement), aVar.f3436a, sb2.toString(), Integer.valueOf(aVar.f3438c.length));
                } catch (Exception unused) {
                }
            }
        } else {
            str = aVar.f3440e;
        }
        if (TextUtils.isEmpty(str)) {
            this.f3474b.setVisibility(8);
        } else {
            this.f3474b.setText(str);
        }
        if (c(this.f3474b)) {
            this.f3474b.setGravity(17);
        }
    }

    @Override // Ic.d
    public View createView(ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.f3473a).inflate(R$layout.stepos_permission_dialog_simple, viewGroup, false);
        this.f3474b = (TextView) viewInflate.findViewById(R$id.stepos_permission_dialog_message);
        this.f3475c = (TextView) viewInflate.findViewById(R$id.stepos_permission_dialog_terms);
        return viewInflate;
    }

    @Override // Ic.d
    public CheckBox getCheckBox() {
        return new CheckBox(this.f3473a);
    }

    @Override // Ic.d
    public List<stepos.support.v7.permission.d> getPermissions() {
        return Collections.EMPTY_LIST;
    }

    @Override // Ic.d
    public TextView getTermsView() {
        return this.f3475c;
    }
}

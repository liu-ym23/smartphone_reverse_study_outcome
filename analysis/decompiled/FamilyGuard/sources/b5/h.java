package b5;

import android.content.Context;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import b5.c;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class h implements d {

    /* renamed from: a, reason: collision with root package name */
    private final Context f11876a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f11877b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f11878c;

    /* renamed from: d, reason: collision with root package name */
    private Z4.e f11879d;

    public h(Context context) {
        this.f11876a = context;
        this.f11879d = Z4.e.b(context);
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
        return (b(textView, textView.getText().toString()) + (((textView.getPaddingLeft() + textView.getPaddingRight()) + viewGroup.getPaddingLeft()) + viewGroup.getPaddingRight())) + (((marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) <= this.f11876a.getResources().getDimensionPixelOffset(H1.f.f2128X);
    }

    @Override // b5.d
    public void a(c.a aVar) {
        String str;
        if (TextUtils.isEmpty(aVar.f11843e)) {
            String[] strArr = aVar.f11841c;
            if (strArr == null || strArr.length <= 0) {
                str = null;
            } else {
                try {
                    StringBuilder sb = new StringBuilder();
                    int i5 = 0;
                    while (true) {
                        String[] strArr2 = aVar.f11841c;
                        if (i5 >= strArr2.length) {
                            break;
                        }
                        String strD = this.f11879d.d(this.f11876a, strArr2[i5]);
                        if (!TextUtils.isEmpty(strD)) {
                            sb.append(strD);
                            sb.append("、");
                        }
                        i5++;
                    }
                    if (sb.length() > 0) {
                        sb.setLength(sb.length() - 1);
                    }
                    str = String.format(this.f11876a.getResources().getString(X4.j.f6061j), aVar.f11839a, sb.toString(), Integer.valueOf(aVar.f11841c.length));
                } catch (Exception unused) {
                }
            }
        } else {
            str = aVar.f11843e;
        }
        if (TextUtils.isEmpty(str)) {
            this.f11877b.setVisibility(8);
        } else {
            this.f11877b.setText(str);
        }
        if (c(this.f11877b)) {
            this.f11877b.setGravity(17);
        }
    }

    @Override // b5.d
    public View createView(ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.f11876a).inflate(X4.h.f6049u, viewGroup, false);
        this.f11877b = (TextView) viewInflate.findViewById(X4.f.f5986d0);
        this.f11878c = (TextView) viewInflate.findViewById(X4.f.f6000k0);
        return viewInflate;
    }

    @Override // b5.d
    public CheckBox getCheckBox() {
        return new CheckBox(this.f11876a);
    }

    @Override // b5.d
    public List<Z4.d> getPermissions() {
        return Collections.EMPTY_LIST;
    }

    @Override // b5.d
    public TextView getTermsView() {
        return this.f11878c;
    }
}

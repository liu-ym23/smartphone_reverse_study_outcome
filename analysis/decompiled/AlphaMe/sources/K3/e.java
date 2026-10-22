package K3;

import android.content.Context;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.method.TransformationMethod;
import android.util.Pair;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.stepos.alphame.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import stepos.support.v7.app.C0872q;
import stepos.support.v7.app.U;

/* loaded from: classes2.dex */
public final class e extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    public final f f1062a;

    public e(Context context) {
        super(context, null, 0);
        ArrayList arrayList = U.f14336q;
        f fVar = new f(context);
        this.f1062a = fVar;
        addView(fVar.c(this));
    }

    public CheckBox getCheckBox() {
        return this.f1062a.f1074l;
    }

    public Map<String, Boolean> getItemCheckedMap() {
        f fVar = this.f1062a;
        if (fVar instanceof f) {
            return fVar.f1083u;
        }
        return null;
    }

    public List<stepos.support.v7.permission.c> getPermissions() {
        return this.f1062a.f1076n;
    }

    public TextView getTermsView() {
        return this.f1062a.f1075m;
    }

    public void setPermissionDialogBuild(d dVar) {
        String[] strArr;
        f fVar = this.f1062a;
        fVar.getClass();
        boolean z4 = dVar.f1058g;
        Context context = fVar.f1063a;
        if (z4) {
            fVar.f1064b.setText(dVar.f1052a);
            TextView textView = fVar.f1064b;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
            int i4 = marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            int paddingRight = textView.getPaddingRight() + textView.getPaddingLeft();
            String string = textView.getText().toString();
            TransformationMethod transformationMethod = textView.getTransformationMethod();
            if (transformationMethod != null) {
                string = transformationMethod.getTransformation(string, textView).toString();
            }
            if (((int) textView.getPaint().measureText(string)) + paddingRight + i4 <= context.getResources().getDimensionPixelOffset(R.dimen.stepos_alert_dialog_width)) {
                fVar.f1064b.setGravity(17);
            }
        } else {
            fVar.f1064b.setVisibility(8);
        }
        if (dVar.f1057f) {
            fVar.f1064b.setTextColor(fVar.f1079q);
            fVar.f1075m.setTextColor(fVar.f1081s);
        }
        fVar.f1082t = dVar.f1059h;
        String[] strArr2 = dVar.f1054c;
        int i5 = 1;
        boolean z5 = strArr2 != null && strArr2.length > 0;
        List list = dVar.f1060i;
        boolean z6 = list != null && list.size() > 0;
        if (z5 || z6) {
            if (z5) {
                HashMap map = new HashMap();
                int i6 = 0;
                while (true) {
                    strArr = dVar.f1054c;
                    if (i6 >= strArr.length) {
                        break;
                    }
                    map.put(strArr[i6], dVar.f1055d[i6]);
                    i6++;
                }
                List<stepos.support.v7.permission.c> listB = fVar.f1077o.b(strArr, false);
                fVar.f1076n = listB;
                for (stepos.support.v7.permission.c cVar : listB) {
                    if (cVar.f14648d.size() > 0 && map.containsKey(cVar.f14646b)) {
                        cVar.f14648d.clear();
                    }
                }
                for (stepos.support.v7.permission.c cVar2 : fVar.f1076n) {
                    if (cVar2.f14648d.size() > 0) {
                        Iterator it = cVar2.f14648d.iterator();
                        while (it.hasNext()) {
                            stepos.support.v7.permission.b bVar = (stepos.support.v7.permission.b) it.next();
                            fVar.b(fVar.f1073k, bVar.a(), (String) map.get(bVar.f14643b), dVar.f1057f);
                        }
                    } else {
                        fVar.b(fVar.f1073k, cVar2.a(context), (String) map.get(cVar2.f14646b), dVar.f1057f);
                    }
                }
            }
            if (z6) {
                for (Pair pair : dVar.f1060i) {
                    fVar.b(fVar.f1073k, (String) pair.first, (String) pair.second, dVar.f1057f);
                }
            }
            fVar.f1067e.setOnScrollChangeListener(new C0872q(6, fVar));
            fVar.f1067e.post(new J3.a(i5, fVar));
        } else {
            fVar.f1065c.setVisibility(8);
        }
        if (dVar.f1053b) {
            fVar.f1074l.setVisibility(0);
        } else {
            fVar.f1074l.setVisibility(8);
            y.e eVar = (y.e) fVar.f1069g.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) eVar).topMargin = 0;
            fVar.f1069g.setLayoutParams(eVar);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) fVar.f1068f.getLayoutParams();
            layoutParams.bottomMargin = 0;
            fVar.f1068f.setLayoutParams(layoutParams);
        }
        if (!TextUtils.isEmpty(dVar.f1056e)) {
            fVar.f1071i.setText(dVar.f1056e);
            fVar.f1071i.setVisibility(0);
        } else {
            if (TextUtils.isEmpty(dVar.f1061j)) {
                fVar.f1071i.setVisibility(8);
                return;
            }
            fVar.f1071i.setText(dVar.f1061j);
            fVar.f1071i.setVisibility(0);
            fVar.f1071i.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }
}

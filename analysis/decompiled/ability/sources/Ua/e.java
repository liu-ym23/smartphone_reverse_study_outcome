package Ua;

import A6.l;
import android.content.Context;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.method.TransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.stepos.ability.R;
import com.stepos.common.scrollbarview.StepOSScrollBarView;
import com.stepos.common.scrollview.StepOSNestedScrollView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import stepos.support.v7.app.S;
import stepos.support.v7.widget.PermissionScrollView;

/* loaded from: classes4.dex */
public final class e extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    public final f f1282a;

    public e(Context context) {
        super(context, null, 0);
        ArrayList arrayList = S.f6233q;
        f fVar = new f(context);
        this.f1282a = fVar;
        View viewInflate = LayoutInflater.from(fVar.f1283a).inflate(R.layout.stepos_permission_dialog, (ViewGroup) this, false);
        fVar.g = (RelativeLayout) viewInflate.findViewById(R.id.permission_relative_layout);
        fVar.b = (TextView) viewInflate.findViewById(R.id.stepos_permission_dialog_title);
        fVar.c = (LinearLayout) viewInflate.findViewById(R.id.stepos_permission_dialog_container);
        fVar.d = viewInflate.findViewById(R.id.stepos_permission_dialog_scroll_indicator_up);
        fVar.e = (PermissionScrollView) viewInflate.findViewById(R.id.stepos_permission_dialog_scroll_view);
        fVar.h = (StepOSScrollBarView) viewInflate.findViewById(R.id.stepos_permission_dialog_scrollbarview_vertical);
        fVar.f = (StepOSNestedScrollView) viewInflate.findViewById(R.id.stepos_permission_dialog_scrollview);
        fVar.i = (TextView) viewInflate.findViewById(R.id.stepos_permission_dialog_reminder);
        fVar.f1284j = viewInflate.findViewById(R.id.stepos_permission_dialog_scroll_indicator_down);
        fVar.k = (LinearLayout) viewInflate.findViewById(R.id.stepos_permission_dialog_content_layout);
        fVar.l = (CheckBox) viewInflate.findViewById(R.id.stepos_permission_dialog_checkbox);
        fVar.m = (TextView) viewInflate.findViewById(R.id.stepos_permission_dialog_terms);
        Z4.h.a(fVar.f, fVar.h);
        addView(viewInflate);
    }

    public CheckBox getCheckBox() {
        return this.f1282a.l;
    }

    public Map<String, Boolean> getItemCheckedMap() {
        f fVar = this.f1282a;
        if (fVar != null) {
            return fVar.f1285q;
        }
        return null;
    }

    public List<stepos.support.v7.permission.c> getPermissions() {
        return this.f1282a.n;
    }

    public TextView getTermsView() {
        return this.f1282a.m;
    }

    public void setPermissionDialogBuild(d dVar) {
        String[] strArr;
        f fVar = this.f1282a;
        Context context = fVar.f1283a;
        if (dVar.d) {
            fVar.b.setText(dVar.f1281a);
            TextView textView = fVar.b;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
            int i = marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            int paddingRight = textView.getPaddingRight() + textView.getPaddingLeft();
            String string = textView.getText().toString();
            TransformationMethod transformationMethod = textView.getTransformationMethod();
            if (transformationMethod != null) {
                string = transformationMethod.getTransformation(string, textView).toString();
            }
            if (((int) textView.getPaint().measureText(string)) + paddingRight + i <= context.getResources().getDimensionPixelOffset(R.dimen.stepos_alert_dialog_width)) {
                fVar.b.setGravity(17);
            }
        } else {
            fVar.b.setVisibility(8);
        }
        String[] strArr2 = dVar.b;
        boolean z10 = strArr2 != null && strArr2.length > 0;
        if (z10) {
            if (z10) {
                HashMap map = new HashMap();
                int i6 = 0;
                while (true) {
                    strArr = dVar.b;
                    if (i6 >= strArr.length) {
                        break;
                    }
                    map.put(strArr[i6], dVar.c[i6]);
                    i6++;
                }
                List<stepos.support.v7.permission.c> listC = fVar.o.c(strArr, false);
                fVar.n = listC;
                for (stepos.support.v7.permission.c cVar : listC) {
                    if (cVar.d.size() > 0 && map.containsKey(cVar.b)) {
                        cVar.d.clear();
                    }
                }
                for (stepos.support.v7.permission.c cVar2 : fVar.n) {
                    if (cVar2.d.size() > 0) {
                        Iterator it = cVar2.d.iterator();
                        while (it.hasNext()) {
                            stepos.support.v7.permission.b bVar = (stepos.support.v7.permission.b) it.next();
                            fVar.b(fVar.k, bVar.a(), (String) map.get(bVar.b));
                        }
                    } else {
                        fVar.b(fVar.k, cVar2.a(context), (String) map.get(cVar2.b));
                    }
                }
            }
            fVar.e.setOnScrollChangeListener(new a5.d(fVar, 2));
            fVar.e.post(new l(fVar, 15));
        } else {
            fVar.c.setVisibility(8);
        }
        fVar.l.setVisibility(8);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) fVar.g.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = 0;
        fVar.g.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) fVar.f.getLayoutParams();
        layoutParams2.bottomMargin = 0;
        fVar.f.setLayoutParams(layoutParams2);
        if (!TextUtils.isEmpty(null)) {
            fVar.i.setText((CharSequence) null);
            fVar.i.setVisibility(0);
        } else {
            if (TextUtils.isEmpty(null)) {
                fVar.i.setVisibility(8);
                return;
            }
            fVar.i.setText((CharSequence) null);
            fVar.i.setVisibility(0);
            fVar.i.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }
}

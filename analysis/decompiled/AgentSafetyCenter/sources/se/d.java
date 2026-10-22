package se;

import android.content.Context;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.method.TransformationMethod;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.r;
import com.stepos.agentsafetycenter.R;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import stepos.support.v7.widget.PermissionScrollView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class d extends RelativeLayout {

    /* renamed from: c, reason: collision with root package name */
    public e f12205c;

    public CheckBox getCheckBox() {
        return this.f12205c.f12216l;
    }

    public Map<String, Boolean> getItemCheckedMap() {
        e eVar = this.f12205c;
        if (eVar != null) {
            return eVar.f12221q;
        }
        return null;
    }

    public List<qe.c> getPermissions() {
        return this.f12205c.f12218n;
    }

    public TextView getTermsView() {
        return this.f12205c.f12217m;
    }

    public void setPermissionDialogBuild(c cVar) {
        String[] strArr;
        e eVar = this.f12205c;
        Context context = eVar.f12206a;
        boolean z10 = cVar.f12204d;
        TextView textView = eVar.f12207b;
        if (z10) {
            textView.setText(cVar.f12201a);
            TextView textView2 = eVar.f12207b;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView2.getLayoutParams();
            int i = marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            int paddingRight = textView2.getPaddingRight() + textView2.getPaddingLeft();
            String string = textView2.getText().toString();
            TransformationMethod transformationMethod = textView2.getTransformationMethod();
            if (transformationMethod != null) {
                string = transformationMethod.getTransformation(string, textView2).toString();
            }
            if (((int) textView2.getPaint().measureText(string)) + paddingRight + i <= context.getResources().getDimensionPixelOffset(R.dimen.stepos_alert_dialog_width)) {
                eVar.f12207b.setGravity(17);
            }
        } else {
            textView.setVisibility(8);
        }
        String[] strArr2 = cVar.f12202b;
        int i3 = 1;
        boolean z11 = false;
        boolean z12 = strArr2 != null && strArr2.length > 0;
        if (z12) {
            if (z12) {
                HashMap map = new HashMap();
                int i10 = 0;
                while (true) {
                    strArr = cVar.f12202b;
                    if (i10 >= strArr.length) {
                        break;
                    }
                    map.put(strArr[i10], cVar.f12203c[i10]);
                    i10++;
                }
                List<qe.c> listC = eVar.f12219o.c(strArr, false);
                eVar.f12218n = listC;
                for (qe.c cVar2 : listC) {
                    if (cVar2.f10226h.size() > 0 && map.containsKey(cVar2.f10224f)) {
                        cVar2.f10226h.clear();
                    }
                }
                for (qe.c cVar3 : eVar.f12218n) {
                    if (cVar3.f10226h.size() > 0) {
                        ArrayList arrayList = cVar3.f10226h;
                        int size = arrayList.size();
                        int i11 = 0;
                        while (i11 < size) {
                            Object obj = arrayList.get(i11);
                            i11++;
                            qe.b bVar = (qe.b) obj;
                            eVar.b(eVar.f12215k, bVar.a(), (String) map.get(bVar.f10221f));
                        }
                    } else {
                        eVar.b(eVar.f12215k, cVar3.a(context), (String) map.get(cVar3.f10224f));
                    }
                }
            }
            PermissionScrollView permissionScrollView = eVar.f12210e;
            sa.c cVar4 = new sa.c(i3, z11);
            cVar4.f12170f = eVar;
            VarHandle.storeStoreFence();
            permissionScrollView.setOnScrollChangeListener(cVar4);
            PermissionScrollView permissionScrollView2 = eVar.f12210e;
            r rVar = new r(12);
            rVar.f1301f = eVar;
            VarHandle.storeStoreFence();
            permissionScrollView2.post(rVar);
        } else {
            eVar.f12208c.setVisibility(8);
        }
        eVar.f12216l.setVisibility(8);
        z2.d dVar = (z2.d) eVar.f12212g.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) dVar).topMargin = 0;
        eVar.f12212g.setLayoutParams(dVar);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) eVar.f12211f.getLayoutParams();
        layoutParams.bottomMargin = 0;
        eVar.f12211f.setLayoutParams(layoutParams);
        if (!TextUtils.isEmpty(null)) {
            eVar.i.setText((CharSequence) null);
            eVar.i.setVisibility(0);
            return;
        }
        boolean zIsEmpty = TextUtils.isEmpty(null);
        TextView textView3 = eVar.i;
        if (zIsEmpty) {
            textView3.setVisibility(8);
            return;
        }
        textView3.setText((CharSequence) null);
        eVar.i.setVisibility(0);
        eVar.i.setMovementMethod(LinkMovementMethod.getInstance());
    }
}

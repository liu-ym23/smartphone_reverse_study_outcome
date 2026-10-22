package fe;

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
import com.stepos.aiengine.R;
import com.stepos.common.scrollbarview.StepOSScrollBarView;
import com.stepos.common.scrollview.StepOSNestedScrollView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import stepos.support.v7.app.g0;
import stepos.support.v7.widget.PermissionScrollView;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    public final f f8854a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f8855a;

        /* renamed from: b, reason: collision with root package name */
        public String[] f8856b;

        /* renamed from: c, reason: collision with root package name */
        public String[] f8857c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f8858d;
    }

    public c(Context context) {
        super(context, null, 0);
        ArrayList<String> arrayList = g0.f12106q;
        f fVar = new f(context);
        this.f8854a = fVar;
        View viewInflate = LayoutInflater.from(fVar.f8861a).inflate(R.layout.stepos_permission_dialog, (ViewGroup) this, false);
        fVar.f8867g = (RelativeLayout) viewInflate.findViewById(R.id.permission_relative_layout);
        fVar.f8862b = (TextView) viewInflate.findViewById(R.id.stepos_permission_dialog_title);
        fVar.f8863c = (LinearLayout) viewInflate.findViewById(R.id.stepos_permission_dialog_container);
        fVar.f8864d = viewInflate.findViewById(R.id.stepos_permission_dialog_scroll_indicator_up);
        fVar.f8865e = (PermissionScrollView) viewInflate.findViewById(R.id.stepos_permission_dialog_scroll_view);
        fVar.h = (StepOSScrollBarView) viewInflate.findViewById(R.id.stepos_permission_dialog_scrollbarview_vertical);
        fVar.f8866f = (StepOSNestedScrollView) viewInflate.findViewById(R.id.stepos_permission_dialog_scrollview);
        fVar.f8868i = (TextView) viewInflate.findViewById(R.id.stepos_permission_dialog_reminder);
        fVar.f8869j = viewInflate.findViewById(R.id.stepos_permission_dialog_scroll_indicator_down);
        fVar.f8870k = (LinearLayout) viewInflate.findViewById(R.id.stepos_permission_dialog_content_layout);
        fVar.f8871l = (CheckBox) viewInflate.findViewById(R.id.stepos_permission_dialog_checkbox);
        fVar.f8872m = (TextView) viewInflate.findViewById(R.id.stepos_permission_dialog_terms);
        j8.e.a(fVar.f8866f, fVar.h);
        addView(viewInflate);
    }

    public CheckBox getCheckBox() {
        return this.f8854a.f8871l;
    }

    public Map<String, Boolean> getItemCheckedMap() {
        f fVar = this.f8854a;
        if (fVar != null) {
            return fVar.f8876q;
        }
        return null;
    }

    public List<stepos.support.v7.permission.d> getPermissions() {
        return this.f8854a.f8873n;
    }

    public TextView getTermsView() {
        return this.f8854a.f8872m;
    }

    public void setPermissionDialogBuild(a aVar) {
        String[] strArr;
        f fVar = this.f8854a;
        Context context = fVar.f8861a;
        if (aVar.f8858d) {
            fVar.f8862b.setText(aVar.f8855a);
            TextView textView = fVar.f8862b;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
            int i10 = marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            int paddingRight = textView.getPaddingRight() + textView.getPaddingLeft();
            String string = textView.getText().toString();
            TransformationMethod transformationMethod = textView.getTransformationMethod();
            if (transformationMethod != null) {
                string = transformationMethod.getTransformation(string, textView).toString();
            }
            if (((int) textView.getPaint().measureText(string)) + paddingRight + i10 <= context.getResources().getDimensionPixelOffset(R.dimen.stepos_alert_dialog_width)) {
                fVar.f8862b.setGravity(17);
            }
        } else {
            fVar.f8862b.setVisibility(8);
        }
        String[] strArr2 = aVar.f8856b;
        boolean z = strArr2 != null && strArr2.length > 0;
        if (z) {
            if (z) {
                HashMap map = new HashMap();
                int i11 = 0;
                while (true) {
                    strArr = aVar.f8856b;
                    if (i11 >= strArr.length) {
                        break;
                    }
                    map.put(strArr[i11], aVar.f8857c[i11]);
                    i11++;
                }
                List<stepos.support.v7.permission.d> listC = fVar.f8874o.c(strArr, false);
                fVar.f8873n = listC;
                for (stepos.support.v7.permission.d dVar : listC) {
                    if (dVar.f12318d.size() > 0 && map.containsKey(dVar.f12316b)) {
                        dVar.f12318d.clear();
                    }
                }
                for (stepos.support.v7.permission.d dVar2 : fVar.f8873n) {
                    if (dVar2.f12318d.size() > 0) {
                        ArrayList arrayList = dVar2.f12318d;
                        int size = arrayList.size();
                        int i12 = 0;
                        while (i12 < size) {
                            Object obj = arrayList.get(i12);
                            i12++;
                            stepos.support.v7.permission.c cVar = (stepos.support.v7.permission.c) obj;
                            fVar.b(fVar.f8870k, cVar.a(), (String) map.get(cVar.f12313b));
                        }
                    } else {
                        fVar.b(fVar.f8870k, dVar2.a(context), (String) map.get(dVar2.f12316b));
                    }
                }
            }
            fVar.f8865e.setOnScrollChangeListener(new d(fVar));
            fVar.f8865e.post(new e(fVar));
        } else {
            fVar.f8863c.setVisibility(8);
        }
        fVar.f8871l.setVisibility(8);
        ConstraintLayout.a aVar2 = (ConstraintLayout.a) fVar.f8867g.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) aVar2).topMargin = 0;
        fVar.f8867g.setLayoutParams(aVar2);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) fVar.f8866f.getLayoutParams();
        layoutParams.bottomMargin = 0;
        fVar.f8866f.setLayoutParams(layoutParams);
        if (!TextUtils.isEmpty(null)) {
            fVar.f8868i.setText((CharSequence) null);
            fVar.f8868i.setVisibility(0);
        } else {
            if (TextUtils.isEmpty(null)) {
                fVar.f8868i.setVisibility(8);
                return;
            }
            fVar.f8868i.setText((CharSequence) null);
            fVar.f8868i.setVisibility(0);
            fVar.f8868i.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }
}

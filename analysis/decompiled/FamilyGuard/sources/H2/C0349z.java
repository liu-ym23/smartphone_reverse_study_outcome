package H2;

import S1.b;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.ActivityC0516k;
import androidx.lifecycle.AbstractC0545z;
import com.stepos.common.picker.WheelPicker;
import com.stepos.common.widget.DatePicker;
import com.stepos.common.widget.c;
import com.stepos.familyguard.R;
import com.stepos.minor.Minor;
import com.stepos.minor.ui.MinorMainActivity;
import d.AbstractC0642c;
import d.C0640a;
import d.InterfaceC0641b;
import e.C0676c;
import f2.C0702g;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.libpag.BuildConfig;
import stepos.support.v7.app.c;
import v0.ComponentCallbacks2C1180c;
import z0.EnumC1335a;

/* renamed from: H2.z, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0349z extends C0304b {

    /* renamed from: g0, reason: collision with root package name */
    private F2.y f2828g0;

    /* renamed from: h0, reason: collision with root package name */
    private j2.n f2829h0;

    /* renamed from: i0, reason: collision with root package name */
    private final androidx.lifecycle.B<Minor> f2830i0 = new androidx.lifecycle.B<>();

    /* renamed from: j0, reason: collision with root package name */
    private AbstractC0642c<Intent> f2831j0;

    /* renamed from: k0, reason: collision with root package name */
    private AbstractC0642c<Intent> f2832k0;

    /* renamed from: l0, reason: collision with root package name */
    private AbstractC0642c<Intent> f2833l0;

    /* renamed from: m0, reason: collision with root package name */
    private AlertDialog f2834m0;

    /* renamed from: n0, reason: collision with root package name */
    private AlertDialog f2835n0;

    /* renamed from: o0, reason: collision with root package name */
    private AlertDialog f2836o0;

    /* renamed from: p0, reason: collision with root package name */
    private com.stepos.common.widget.c f2837p0;

    /* renamed from: q0, reason: collision with root package name */
    private stepos.support.v7.app.c f2838q0;

    /* renamed from: r0, reason: collision with root package name */
    private stepos.support.v7.app.c f2839r0;

    /* renamed from: s0, reason: collision with root package name */
    private WheelPicker f2840s0;

    /* renamed from: t0, reason: collision with root package name */
    private WheelPicker f2841t0;

    /* renamed from: u0, reason: collision with root package name */
    private EditText f2842u0;

    /* renamed from: v0, reason: collision with root package name */
    private String f2843v0;

    /* renamed from: w0, reason: collision with root package name */
    private String f2844w0;

    /* renamed from: x0, reason: collision with root package name */
    private int f2845x0;

    /* renamed from: y0, reason: collision with root package name */
    private Uri f2846y0;

    /* renamed from: z0, reason: collision with root package name */
    private String f2847z0;

    /* renamed from: H2.z$a */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ j2.v f2848a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ TextView f2849b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f2850c;

        a(j2.v vVar, TextView textView, List list) {
            this.f2848a = vVar;
            this.f2849b = textView;
            this.f2850c = list;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (C0349z.this.X2(this.f2848a.f17796b, this.f2849b, this.f2850c)) {
                this.f2848a.f17796b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        }
    }

    /* renamed from: H2.z$b */
    class b implements T0.g<Bitmap> {
        b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // T0.g
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean i(Bitmap bitmap, Object obj, U0.e<Bitmap> eVar, EnumC1335a enumC1335a, boolean z5) {
            C0702g.b("MinorEditFragment", "avatar onResourceReady: succeed");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            Minor minor = (Minor) C0349z.this.f2830i0.e();
            if (minor != null) {
                minor.setIcon(byteArray);
            }
            C0349z.this.f2830i0.k(minor);
            return k3.b.c(C0349z.this.A1(), C0349z.this.f2846y0);
        }

        @Override // T0.g
        public boolean h(C0.q qVar, Object obj, U0.e<Bitmap> eVar, boolean z5) {
            C0702g.b("MinorEditFragment", "avatar onLoadFailed: " + Log.getStackTraceString(qVar));
            return false;
        }
    }

    private int A2(String str) throws Resources.NotFoundException {
        String[] stringArray = Q().getStringArray(R.array.birth_ranges);
        for (int i5 = 0; i5 < stringArray.length; i5++) {
            if (TextUtils.equals(str, stringArray[i5])) {
                return i5;
            }
        }
        return -1;
    }

    private TextView B2(ViewGroup viewGroup) {
        int height = viewGroup.getHeight() / 2;
        int i5 = Integer.MAX_VALUE;
        View view = null;
        for (int i6 = 0; i6 < viewGroup.getChildCount(); i6++) {
            View childAt = viewGroup.getChildAt(i6);
            int iAbs = Math.abs(((childAt.getTop() + childAt.getBottom()) / 2) - height);
            if (iAbs < i5) {
                view = childAt;
                i5 = iAbs;
            }
        }
        if (view == null) {
            return null;
        }
        return C2(view);
    }

    private TextView C2(View view) {
        if (view instanceof TextView) {
            return (TextView) view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        for (int i5 = 0; i5 < viewGroup.getChildCount(); i5++) {
            TextView textViewC2 = C2(viewGroup.getChildAt(i5));
            if (textViewC2 != null) {
                return textViewC2;
            }
        }
        return null;
    }

    private String E2(int i5) throws Resources.NotFoundException {
        String[] stringArray = Q().getStringArray(R.array.birth_ranges);
        int i6 = i5 - 1;
        if (i6 < 0 || i6 >= stringArray.length) {
            if (3 >= stringArray.length) {
                return BuildConfig.FLAVOR;
            }
            i6 = 3;
        }
        return stringArray[i6];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F2(int i5, View view, String str) {
        this.f2843v0 = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G2(View view) {
        y2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H2(View view) {
        a3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I2(View view) {
        d3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J2(View view) {
        f3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K2(View view) {
        c3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L2(Minor minor, DialogInterface dialogInterface, int i5) {
        if (TextUtils.isEmpty(this.f2843v0)) {
            return;
        }
        minor.setBirthdayAge(Integer.parseInt(this.f2843v0.trim()));
        this.f2830i0.k(minor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M2(Minor minor, DialogInterface dialogInterface, int i5) throws Resources.NotFoundException {
        int iA2 = A2(this.f2843v0);
        if (iA2 >= 0) {
            minor.setBirthdayRange(iA2 + 1);
            this.f2830i0.k(minor);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N2(Minor minor, DialogInterface dialogInterface, int i5) {
        minor.setBirthType(i5);
        this.f2830i0.k(minor);
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O2(Minor minor, DatePicker datePicker, int i5, int i6, int i7) {
        boolean z5;
        boolean zJ = datePicker.J();
        minor.setBirthdayDateLunar(zJ ? 1 : 0);
        if (zJ) {
            int iD = N1.e.d(i5);
            if (iD <= 0 || i6 < iD) {
                z5 = false;
            } else {
                z5 = i6 == iD;
                i6--;
            }
            int[] iArrE = N1.e.e(i5, i6 + 1, i7, z5);
            i5 = iArrE[0];
            i6 = iArrE[1] - 1;
            i7 = iArrE[2];
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(i5, i6, i7);
        minor.setBirthdayDate(calendar.getTimeInMillis());
        this.f2830i0.k(minor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P2(Editable editable) {
        Button button;
        this.f2844w0 = editable.toString();
        stepos.support.v7.app.c cVar = this.f2838q0;
        if (cVar == null || (button = cVar.getButton(-1)) == null) {
            return;
        }
        button.setEnabled(!TextUtils.isEmpty(this.f2844w0.trim()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q2(Minor minor, DialogInterface dialogInterface, int i5) {
        this.f2829h0.f17742h.setText(this.f2844w0);
        minor.setName(this.f2844w0);
        this.f2830i0.k(minor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R2(DialogInterface dialogInterface, int i5) {
        p2.g.s(q(), "android.permission.QUERY_ALL_PACKAGES");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S2(Minor minor) {
        C0702g.b("MinorEditFragment", "onActiveMinorChanged() called with: minor = [" + minor + "]");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T2(C0640a c0640a) {
        Intent intentA;
        if (c0640a.c() != -1 || (intentA = c0640a.a()) == null) {
            return;
        }
        Uri data = intentA.getData();
        if (data == null) {
            data = this.f2846y0;
        }
        ComponentCallbacks2C1180c.t(A1()).i().l0(data).N(1024, 1024).k0(new b()).p0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U2(Minor minor) {
        byte[] icon = minor.getIcon();
        if (icon != null) {
            this.f2829h0.f17736b.setImageBitmap(C2.h.i(icon));
        }
        this.f2829h0.f17742h.setText(minor.getName());
        w2(minor);
        x2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V2(C0640a c0640a) {
        Intent intentA;
        if (c0640a.c() != -1 || (intentA = c0640a.a()) == null) {
            return;
        }
        byte[] byteArrayExtra = intentA.getByteArrayExtra("key_photo_data");
        Minor minorE = this.f2830i0.e();
        if (minorE != null) {
            minorE.setIcon(byteArrayExtra);
            this.f2830i0.k(minorE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W2(C0640a c0640a) {
        Intent intentA;
        if (c0640a.c() != -1 || (intentA = c0640a.a()) == null) {
            return;
        }
        Uri data = intentA.getData();
        this.f2846y0 = k3.b.d(A1());
        this.f2833l0.a(k3.b.f(A1(), data, this.f2846y0, 128, intentA.getType()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean X2(WheelPicker wheelPicker, TextView textView, List<String> list) {
        TextView textViewB2 = B2(wheelPicker);
        if (textViewB2 != null && textViewB2.getPaint() != null) {
            textView.setTextColor(textViewB2.getCurrentTextColor());
            Iterator<String> it = list.iterator();
            float fMax = 0.0f;
            while (it.hasNext()) {
                fMax = Math.max(fMax, textViewB2.getPaint().measureText(it.next()));
            }
            float left = wheelPicker.getLeft() + (wheelPicker.getWidth() / 2.0f) + (fMax / 2.0f) + (Q().getDisplayMetrics().density * 4.0f);
            float top = wheelPicker.getTop() + g3(textViewB2, wheelPicker) + textViewB2.getBaseline();
            if (textView.getBaseline() <= 0) {
                return false;
            }
            textView.setX(left);
            textView.setY(top - textView.getBaseline());
            if (wheelPicker.getWidth() > 0 && textView.getWidth() > 0) {
                return true;
            }
        }
        return false;
    }

    private void Y2() {
        final Minor minorE = this.f2830i0.e();
        ArrayList arrayList = new ArrayList();
        int i5 = 1;
        while (i5 <= 17) {
            StringBuilder sb = new StringBuilder();
            sb.append(i5 < 10 ? " " : BuildConfig.FLAVOR);
            sb.append(i5);
            arrayList.add(sb.toString());
            i5++;
        }
        if (minorE != null) {
            j2.v vVarZ2 = z2(arrayList, minorE.getBirthdayAge() - 1);
            this.f2841t0 = vVarZ2.f17796b;
            AlertDialog.Builder builder = new AlertDialog.Builder(A1());
            builder.setView(vVarZ2.b()).setPositiveButton(R.string.fg_common_ok, new DialogInterface.OnClickListener() { // from class: H2.k
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i6) {
                    this.f2793a.L2(minorE, dialogInterface, i6);
                }
            });
            AlertDialog alertDialogCreate = builder.create();
            this.f2836o0 = alertDialogCreate;
            alertDialogCreate.show();
        }
    }

    private void Z2() {
        final Minor minorE = this.f2830i0.e();
        if (minorE != null) {
            int birthdayRange = minorE.getBirthdayRange() - 1;
            ArrayList arrayList = new ArrayList(Arrays.asList(Q().getStringArray(R.array.birth_ranges)));
            if (birthdayRange < 0 || birthdayRange >= arrayList.size()) {
                birthdayRange = Math.min(Math.max(3, 0), arrayList.size() - 1);
            }
            j2.v vVarZ2 = z2(arrayList, birthdayRange);
            v2(vVarZ2, arrayList);
            this.f2840s0 = vVarZ2.f17796b;
            AlertDialog.Builder builder = new AlertDialog.Builder(A1());
            builder.setView(vVarZ2.b());
            builder.setPositiveButton(R.string.fg_common_ok, new DialogInterface.OnClickListener() { // from class: H2.m
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i5) throws Resources.NotFoundException {
                    this.f2798a.M2(minorE, dialogInterface, i5);
                }
            });
            AlertDialog alertDialogCreate = builder.create();
            this.f2835n0 = alertDialogCreate;
            alertDialogCreate.show();
        }
    }

    private void a3() {
        final Minor minorE = this.f2830i0.e();
        if (minorE != null) {
            int birthType = minorE.getBirthType();
            AlertDialog alertDialog = this.f2834m0;
            if (alertDialog == null) {
                this.f2834m0 = new AlertDialog.Builder(A1()).setTitle(R.string.mm_birth_types_title).setSingleChoiceItems(R.array.birth_types, birthType, new DialogInterface.OnClickListener() { // from class: H2.i
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i5) {
                        this.f2785a.N2(minorE, dialogInterface, i5);
                    }
                }).create();
            } else {
                alertDialog.getListView().setItemChecked(birthType, true);
            }
            this.f2834m0.show();
        }
    }

    private void b3() {
        final Minor minorE = this.f2830i0.e();
        if (minorE == null) {
            return;
        }
        boolean zIsBirthdayDateLunar = minorE.isBirthdayDateLunar();
        long birthdayDate = minorE.getBirthdayDate();
        Calendar calendar = Calendar.getInstance();
        int i5 = calendar.get(1);
        calendar.setTimeInMillis(birthdayDate);
        int i6 = calendar.get(1);
        int i7 = calendar.get(2);
        int i8 = calendar.get(5);
        if (zIsBirthdayDateLunar) {
            int[] iArrF = N1.e.f(i6, i7 + 1, i8);
            i6 = iArrF[0];
            i7 = iArrF[1] - 1;
            i8 = iArrF[2];
        }
        int i9 = i8;
        int i10 = i6;
        int i11 = i7;
        com.stepos.common.widget.c cVar = new com.stepos.common.widget.c(A1(), new c.InterfaceC0178c() { // from class: H2.l
            @Override // com.stepos.common.widget.c.InterfaceC0178c
            public final void a(DatePicker datePicker, int i12, int i13, int i14) {
                this.f2795a.O2(minorE, datePicker, i12, i13, i14);
            }
        }, i10, i11, i9);
        this.f2837p0 = cVar;
        cVar.i(zIsBirthdayDateLunar, false);
        this.f2837p0.k(Math.min(i10, i5 - 18));
        this.f2837p0.j(i5);
        DatePicker datePickerG = this.f2837p0.g();
        datePickerG.setMaxDate(System.currentTimeMillis());
        datePickerG.setMinDate(Math.min(birthdayDate, System.currentTimeMillis() - 567648000000L));
        datePickerG.T(i10, i11, i9, false);
        this.f2837p0.show();
    }

    private void c3() {
        final Minor minorE = this.f2830i0.e();
        if (minorE == null) {
            return;
        }
        if (this.f2838q0 == null) {
            j2.l lVarC = j2.l.c(F());
            EditText editText = lVarC.f17728b.getEditText();
            this.f2842u0 = editText;
            editText.addTextChangedListener(new b.a().b(new Q1.b() { // from class: H2.f
                @Override // Q1.b
                public final void accept(Object obj) {
                    this.f2779a.P2((Editable) obj);
                }
            }).a());
            stepos.support.v7.app.c cVarC = new c.a(A1()).x(R.string.mm_title_minor_name).u(R.string.fg_common_ok, new DialogInterface.OnClickListener() { // from class: H2.g
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i5) {
                    this.f2781a.Q2(minorE, dialogInterface, i5);
                }
            }).o(R.string.fg_common_cancel, new DialogInterface.OnClickListener() { // from class: H2.h
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i5) {
                    dialogInterface.dismiss();
                }
            }).c();
            this.f2838q0 = cVarC;
            cVarC.setView(lVarC.b());
        }
        String name = minorE.getName();
        if (TextUtils.isEmpty(name)) {
            name = this.f2847z0;
        }
        this.f2842u0.setText(name);
        this.f2842u0.setSelection(name.length());
        this.f2838q0.show();
    }

    private void d3() {
        Minor minorE = this.f2830i0.e();
        if (minorE != null) {
            int birthType = minorE.getBirthType();
            if (birthType == 0) {
                b3();
            } else if (birthType == 1) {
                Y2();
            } else {
                if (birthType != 2) {
                    return;
                }
                Z2();
            }
        }
    }

    private void e3(Context context) {
        Log.d("MinorEditFragment", "APP_LIST_DIALOG_FROM_MINOR_EDIT");
        if (this.f2839r0 == null) {
            this.f2839r0 = new C2.b(context).x(R.string.us_request_app_list_permission_title).m(R.string.mm_minors_mode_need_this_permission).u(R.string.fg_to_open, new DialogInterface.OnClickListener() { // from class: H2.n
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i5) {
                    this.f2802a.R2(dialogInterface, i5);
                }
            }).o(R.string.fg_relation_manager_logout, new DialogInterface.OnClickListener() { // from class: H2.p
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i5) {
                    dialogInterface.dismiss();
                }
            }).g(false).c();
        }
        this.f2839r0.show();
    }

    private void f3() {
        Minor minorE = this.f2830i0.e();
        Minor minorE2 = this.f2828g0.g0().e();
        boolean z5 = minorE2 != null && minorE2.getState() == 2;
        final ActivityC0516k activityC0516kY1 = y1();
        if (minorE == null) {
            return;
        }
        int i5 = this.f2845x0;
        if (i5 == 0) {
            if (!p2.g.v(A1())) {
                e3(A1());
                return;
            }
            minorE.setState(2);
            this.f2828g0.Y(minorE);
            ((MinorMainActivity) y1()).j0().j(2);
            if (g0()) {
                K().U0();
                return;
            }
            return;
        }
        if (i5 != 1) {
            if (i5 != 2) {
                return;
            }
            this.f2828g0.k0(minorE).T(new D3.c() { // from class: H2.j
                @Override // D3.c
                public final void accept(Object obj) {
                    activityC0516kY1.finish();
                }
            }, S1.a.b());
        } else {
            if (z5) {
                minorE.setState(2);
            } else {
                minorE.setState(1);
            }
            this.f2828g0.Y(minorE);
            activityC0516kY1.finish();
        }
    }

    private float g3(View view, View view2) {
        float top = 0.0f;
        while (view != null && view != view2) {
            top += view.getTop();
            if (!(view.getParent() instanceof View)) {
                return top;
            }
            view = (View) view.getParent();
        }
        return top;
    }

    private void v2(j2.v vVar, List<String> list) {
        String strW = W(R.string.mm_age_suffix);
        if (TextUtils.isEmpty(strW) || TextUtils.isEmpty(strW.trim())) {
            vVar.f17796b.setDrawFlagEnable(true);
            vVar.f17796b.setFlagText(strW);
            return;
        }
        if (!(vVar.f17796b.getParent() instanceof FrameLayout)) {
            vVar.f17796b.setDrawFlagEnable(true);
            return;
        }
        FrameLayout frameLayout = (FrameLayout) vVar.f17796b.getParent();
        vVar.f17796b.setDrawFlagEnable(false);
        ViewGroup.LayoutParams layoutParams = vVar.f17796b.getLayoutParams();
        layoutParams.width = -1;
        vVar.f17796b.setLayoutParams(layoutParams);
        TextView textView = new TextView(A1());
        textView.setText(strW);
        textView.setTextSize(0, Q().getDimension(R.dimen.mc_picker_text_size));
        textView.getPaint().setFakeBoldText(true);
        textView.setIncludeFontPadding(false);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 8388659;
        frameLayout.setClipChildren(false);
        frameLayout.addView(textView, layoutParams2);
        vVar.f17796b.getViewTreeObserver().addOnGlobalLayoutListener(new a(vVar, textView, list));
    }

    private void w2(Minor minor) {
        this.f2829h0.f17744j.setText(Q().getStringArray(R.array.birth_types)[minor.getBirthType()]);
        int birthType = minor.getBirthType();
        if (birthType == 0) {
            this.f2829h0.f17745k.setText(minor.getBirthDateDesc(A1()));
        } else if (birthType == 1) {
            this.f2829h0.f17745k.setText(String.valueOf(minor.getBirthdayAge()));
        } else {
            if (birthType != 2) {
                return;
            }
            this.f2829h0.f17745k.setText(E2(minor.getBirthdayRange()));
        }
    }

    private void x2() {
        Bundle bundleU = u();
        int i5 = bundleU != null ? bundleU.getInt("edit_minor_action", 0) : 0;
        this.f2829h0.f17738d.setText(i5 == 0 ? R.string.mm_add_minor_and_start_confirm : i5 == 1 ? R.string.mm_add_minor_confirm : R.string.fg_common_save);
    }

    private void y2() {
        Minor minorE = this.f2830i0.e();
        Intent intent = new Intent("stepos.intent.action.STEPOS_SELECT_PRESET_HEAD");
        intent.setPackage("com.android.dialer");
        if (minorE != null) {
            intent.putExtra("key_photo_data", minorE.getIcon());
        }
        if (y1().getPackageManager().resolveActivity(intent, 65536) != null) {
            this.f2831j0.a(intent);
            return;
        }
        Intent intent2 = new Intent("android.intent.action.PICK");
        intent2.setComponent(new ComponentName("com.stepos.media.gallery", "com.stepos.media.gallery.AlbumManagerActivity"));
        intent2.setType("image/*");
        intent2.setFlags(536870912);
        intent2.putExtra("fromContacts", true);
        this.f2832k0.a(intent2);
    }

    private j2.v z2(List<String> list, int i5) {
        j2.v vVarC = j2.v.c(LayoutInflater.from(A1()));
        if (i5 < 0 || i5 >= list.size()) {
            i5 = 0;
        }
        this.f2843v0 = list.get(i5);
        vVarC.f17796b.A(list, i5, true);
        vVarC.f17796b.setDrawFlagEnable(true);
        vVarC.f17796b.setFlagText(W(R.string.mm_age_suffix));
        vVarC.f17796b.setItemCount(5);
        vVarC.f17796b.setCurrentItem(i5);
        vVarC.f17796b.m(new WheelPicker.e() { // from class: H2.q
            @Override // com.stepos.common.picker.WheelPicker.e
            public final void a(int i6, View view, String str) {
                this.f2808a.F2(i6, view, str);
            }
        });
        return vVarC;
    }

    protected Minor D2() {
        Minor minor = new Minor();
        Bundle bundleU = u();
        if (bundleU != null) {
            this.f2847z0 = bundleU.getString("edit_minor_name");
            int i5 = bundleU.getInt("edit_minor_state", 2);
            if (TextUtils.isEmpty(this.f2847z0)) {
                this.f2847z0 = W(R.string.mm_minor_name_default);
            }
            minor.setName(this.f2847z0);
            minor.setState(i5);
            minor.setBirthdayDate(System.currentTimeMillis());
        }
        return minor;
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public void U0(View view, Bundle bundle) {
        super.U0(view, bundle);
        this.f2830i0.g(b0(), new androidx.lifecycle.C() { // from class: H2.u
            @Override // androidx.lifecycle.C
            public final void a(Object obj) {
                this.f2817a.U2((Minor) obj);
            }
        });
        this.f2829h0.f17736b.setOnClickListener(new View.OnClickListener() { // from class: H2.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f2820a.G2(view2);
            }
        });
        this.f2829h0.f17740f.setOnClickListener(new View.OnClickListener() { // from class: H2.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f2822a.H2(view2);
            }
        });
        this.f2829h0.f17741g.setOnClickListener(new View.OnClickListener() { // from class: H2.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f2824a.I2(view2);
            }
        });
        this.f2829h0.f17738d.setOnClickListener(new View.OnClickListener() { // from class: H2.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f2825a.J2(view2);
            }
        });
        this.f2829h0.f17737c.setOnClickListener(new View.OnClickListener() { // from class: H2.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f2777a.K2(view2);
            }
        });
        if (y1() instanceof MinorMainActivity) {
            ((MinorMainActivity) y1()).z0();
        }
    }

    @Override // com.stepos.familyguard.ui.base.BaseFragment
    protected void U1(stepos.support.v7.app.a aVar) {
        super.U1(aVar);
        aVar.P(R.string.mm_title_add_minor);
        aVar.E(true);
    }

    @Override // H2.C0304b, androidx.fragment.app.ComponentCallbacksC0511f
    public void v0(Bundle bundle) {
        long j5;
        super.v0(bundle);
        this.f2828g0 = (F2.y) new androidx.lifecycle.U(y1()).a(F2.y.class);
        Bundle bundleU = u();
        if (bundleU != null) {
            j5 = bundleU.getLong("edit_minor_id", -1L);
            this.f2845x0 = bundleU.getInt("edit_minor_action", 0);
        } else {
            j5 = -1;
        }
        if (j5 != -1) {
            AbstractC0545z<Minor> abstractC0545zF0 = W1().f0(j5);
            final androidx.lifecycle.B<Minor> b6 = this.f2830i0;
            Objects.requireNonNull(b6);
            abstractC0545zF0.g(this, new androidx.lifecycle.C() { // from class: H2.d
                @Override // androidx.lifecycle.C
                public final void a(Object obj) {
                    b6.n((Minor) obj);
                }
            });
        } else {
            this.f2830i0.n(D2());
        }
        this.f2831j0 = v1(new C0676c(), new InterfaceC0641b() { // from class: H2.o
            @Override // d.InterfaceC0641b
            public final void a(Object obj) {
                this.f2804a.V2((C0640a) obj);
            }
        });
        this.f2832k0 = v1(new C0676c(), new InterfaceC0641b() { // from class: H2.r
            @Override // d.InterfaceC0641b
            public final void a(Object obj) {
                this.f2810a.W2((C0640a) obj);
            }
        });
        this.f2833l0 = v1(new C0676c(), new InterfaceC0641b() { // from class: H2.s
            @Override // d.InterfaceC0641b
            public final void a(Object obj) {
                this.f2813a.T2((C0640a) obj);
            }
        });
        this.f2828g0.g0().g(this, new androidx.lifecycle.C() { // from class: H2.t
            @Override // androidx.lifecycle.C
            public final void a(Object obj) {
                this.f2815a.S2((Minor) obj);
            }
        });
    }

    @Override // androidx.fragment.app.ComponentCallbacksC0511f
    public View z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C0702g.b("MinorEditFragment", "onCreateView() called with: inflater = [" + layoutInflater + "], container = [" + viewGroup + "], savedInstanceState = [" + bundle + "]");
        this.f2829h0 = j2.n.c(layoutInflater);
        if (TextUtils.equals("CN", Q().getConfiguration().locale.getCountry())) {
            T1.g.e(1.18f, this.f2829h0.b());
        } else {
            T1.g.e(1.06f, this.f2829h0.b());
        }
        return this.f2829h0.b();
    }
}

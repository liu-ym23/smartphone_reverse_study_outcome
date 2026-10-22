package stepos.support.v7.app;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.stepos.agentsafetycenter.R;
import com.stepos.common.scrollbarview.StepOSScrollBarView;
import com.stepos.common.scrollview.StepOSNestedScrollView;
import com.stepos.policy.sdk.util.PolicySdkPermissionManifestUtils;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.HashMap;
import stepos.support.v7.widget.PermissionScrollView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class h0 {

    /* renamed from: q, reason: collision with root package name */
    public static final ArrayList f12319q;

    /* renamed from: a, reason: collision with root package name */
    public final Context f12320a;

    /* renamed from: b, reason: collision with root package name */
    public final int f12321b;

    /* renamed from: c, reason: collision with root package name */
    public String f12322c;

    /* renamed from: d, reason: collision with root package name */
    public String[] f12323d;

    /* renamed from: e, reason: collision with root package name */
    public String[] f12324e;

    /* renamed from: f, reason: collision with root package name */
    public com.stepos.policy.sdk.a f12325f;

    /* renamed from: g, reason: collision with root package name */
    public View.OnClickListener f12326g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f12327h;
    public final boolean i;

    /* renamed from: j, reason: collision with root package name */
    public f0 f12328j;

    /* renamed from: k, reason: collision with root package name */
    public CharSequence f12329k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f12330l;

    /* renamed from: m, reason: collision with root package name */
    public String f12331m;

    /* renamed from: n, reason: collision with root package name */
    public String f12332n;

    /* renamed from: o, reason: collision with root package name */
    public String f12333o;

    /* renamed from: p, reason: collision with root package name */
    public String f12334p;

    static {
        ArrayList arrayList = new ArrayList();
        f12319q = arrayList;
        arrayList.add("android.permission.CALL_PHONE");
        arrayList.add("android.permission.READ_CONTACTS");
        arrayList.add("android.permission.READ_SMS");
        arrayList.add(PolicySdkPermissionManifestUtils.WRITE_CONTACTS);
        arrayList.add("android.permission.SEND_SMS");
        arrayList.add("android.permission.RECEIVE_SMS");
        arrayList.add("android.permission.READ_CALL_LOG");
        arrayList.add(PolicySdkPermissionManifestUtils.RECORD_AUDIO);
    }

    public h0(Context context) {
        int iResolveDialogTheme = i.resolveDialogTheme(context, 0);
        this.f12325f = null;
        this.f12326g = null;
        this.f12327h = false;
        this.f12331m = null;
        this.f12332n = null;
        this.f12333o = null;
        this.f12334p = null;
        this.f12320a = context;
        this.f12321b = iResolveDialogTheme;
        this.i = context.getResources().getBoolean(R.bool.isTablet);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final g0 a() throws Resources.NotFoundException {
        Context context = this.f12320a;
        context.getString(R.string.stepos_permission_use_info);
        if (TextUtils.isEmpty(this.f12322c)) {
            g5.f.s("appName can't be null");
            return null;
        }
        String[] strArr = this.f12323d;
        char c9 = 1;
        int i = 0;
        boolean z10 = strArr != null && strArr.length > 0;
        Object[] objArr = (this.f12329k == null && this.f12325f == null && this.f12326g == null) ? false : true;
        if (!z10 && objArr != true) {
            g5.f.s("[permissions], [additional groups] and [terms] both null");
            return null;
        }
        if (strArr != null) {
            String[] strArr2 = this.f12324e;
            if (strArr2 == null) {
                g5.f.s("permissionReason can't be null");
                return null;
            }
            if (strArr2.length != strArr.length) {
                g5.f.s("permissionReason.length must equal permissions.length");
                return null;
            }
            if (this.i) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                int i3 = 0;
                while (true) {
                    String[] strArr3 = this.f12323d;
                    if (i3 >= strArr3.length) {
                        break;
                    }
                    String str = strArr3[i3];
                    if (!f12319q.contains(str)) {
                        arrayList.add(str);
                        String[] strArr4 = this.f12324e;
                        if (strArr4 != null) {
                            arrayList2.add(strArr4[i3]);
                        }
                    }
                    i3++;
                }
                this.f12323d = (String[]) arrayList.toArray(new String[0]);
                if (this.f12324e != null) {
                    this.f12324e = (String[]) arrayList2.toArray(new String[0]);
                }
            }
        }
        se.d dVar = new se.d(context, null, 0);
        se.e eVar = new se.e();
        eVar.f12221q = new HashMap();
        eVar.f12206a = context;
        context.getResources().getColor(R.color.stepos_alert_dialog_title_color_dark);
        context.getResources().getColor(R.color.stepos_permission_dialog_item_title_dark);
        context.getResources().getColor(R.color.stepos_permission_dialog_item_summary_dark);
        eVar.f12219o = qe.d.a(context);
        eVar.f12220p = LayoutInflater.from(context);
        VarHandle.storeStoreFence();
        dVar.f12205c = eVar;
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.stepos_permission_dialog, (ViewGroup) dVar, false);
        eVar.f12212g = (RelativeLayout) viewInflate.findViewById(R.id.permission_relative_layout);
        eVar.f12207b = (TextView) viewInflate.findViewById(R.id.stepos_permission_dialog_title);
        eVar.f12208c = (LinearLayout) viewInflate.findViewById(R.id.stepos_permission_dialog_container);
        eVar.f12209d = viewInflate.findViewById(R.id.stepos_permission_dialog_scroll_indicator_up);
        eVar.f12210e = (PermissionScrollView) viewInflate.findViewById(R.id.stepos_permission_dialog_scroll_view);
        eVar.f12213h = (StepOSScrollBarView) viewInflate.findViewById(R.id.stepos_permission_dialog_scrollbarview_vertical);
        eVar.f12211f = (StepOSNestedScrollView) viewInflate.findViewById(R.id.stepos_permission_dialog_scrollview);
        eVar.i = (TextView) viewInflate.findViewById(R.id.stepos_permission_dialog_reminder);
        eVar.f12214j = viewInflate.findViewById(R.id.stepos_permission_dialog_scroll_indicator_down);
        eVar.f12215k = (LinearLayout) viewInflate.findViewById(R.id.stepos_permission_dialog_content_layout);
        eVar.f12216l = (CheckBox) viewInflate.findViewById(R.id.stepos_permission_dialog_checkbox);
        eVar.f12217m = (TextView) viewInflate.findViewById(R.id.stepos_permission_dialog_terms);
        t9.g.a(eVar.f12211f, eVar.f12213h);
        dVar.addView(viewInflate);
        VarHandle.storeStoreFence();
        se.c cVar = new se.c();
        cVar.f12201a = this.f12322c;
        String[] strArr5 = this.f12323d;
        String[] strArr6 = this.f12324e;
        cVar.f12202b = strArr5;
        cVar.f12203c = strArr6;
        cVar.f12204d = false;
        dVar.setPermissionDialogBuild(cVar);
        h hVar = new h(context, this.f12321b);
        d dVar2 = hVar.f12317a;
        dVar2.f12306o = dVar;
        dVar2.f12301j = this.f12327h;
        b0 b0Var = new b0();
        b0Var.f12289b = this;
        b0Var.f12288a = dVar;
        VarHandle.storeStoreFence();
        dVar2.f12302k = b0Var;
        String string = !TextUtils.isEmpty(this.f12334p) ? this.f12334p : context.getResources().getString(R.string.stepos_permission_agree);
        c0 c0Var = new c0(i);
        c0Var.f12292g = this;
        c0Var.f12291f = dVar;
        VarHandle.storeStoreFence();
        dVar2.f12298f = string;
        dVar2.f12299g = c0Var;
        String string2 = this.f12333o;
        if (string2 == null) {
            string2 = !this.f12330l ? context.getString(R.string.stepos_reject) : context.getString(R.string.stepos_permission_deny);
        }
        c0 c0Var2 = new c0(c9 == true ? 1 : 0);
        c0Var2.f12292g = this;
        c0Var2.f12291f = dVar;
        VarHandle.storeStoreFence();
        dVar2.f12300h = string2;
        dVar2.i = c0Var2;
        dVar2.f12307p = -1;
        dVar2.f12308q = 0;
        dVar2.f12296d = this.f12322c;
        f fVar = new f(2);
        fVar.f12315f = this;
        VarHandle.storeStoreFence();
        g0 g0Var = (g0) hVar.a(fVar);
        CheckBox checkBox = dVar.getCheckBox();
        d0 d0Var = new d0();
        d0Var.f12309a = g0Var;
        VarHandle.storeStoreFence();
        checkBox.setOnCheckedChangeListener(d0Var);
        TextView termsView = dVar.getTermsView();
        if (this.f12329k == null) {
            qe.g gVar = new qe.g(context);
            gVar.f10236d = z10;
            gVar.f10234b = this.f12325f != null;
            gVar.f10235c = this.f12326g != null;
            gVar.f10238f = 0;
            gVar.f10239g = 0;
            gVar.f10240h = this.f12331m;
            gVar.i = this.f12332n;
            p5.e eVar2 = new p5.e(10);
            eVar2.f9723g = this;
            eVar2.f9722f = termsView;
            VarHandle.storeStoreFence();
            gVar.f10237e = eVar2;
            this.f12329k = gVar.b();
        }
        termsView.setText(this.f12329k);
        ViewTreeObserver viewTreeObserver = termsView.getViewTreeObserver();
        e0 e0Var = new e0(0);
        e0Var.f12313f = termsView;
        VarHandle.storeStoreFence();
        viewTreeObserver.addOnGlobalLayoutListener(e0Var);
        termsView.setMovementMethod(LinkMovementMethod.getInstance());
        termsView.setHighlightColor(0);
        return g0Var;
    }
}

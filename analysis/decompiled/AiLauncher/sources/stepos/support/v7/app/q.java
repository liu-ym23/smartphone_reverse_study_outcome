package stepos.support.v7.app;

import Ic.c;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.Pair;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.stepos.policy.sdk.util.PolicySdkPermissionManifestUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import stepos.support.v7.app.c;
import stepos.support.v7.appcompat.R$bool;
import stepos.support.v7.appcompat.R$string;
import stepos.support.v7.permission.TermsStringBuilder;

/* loaded from: classes5.dex */
public class q {

    /* renamed from: A, reason: collision with root package name */
    public static final ArrayList<String> f40709A;

    /* renamed from: z, reason: collision with root package name */
    public static final boolean f40710z = false;

    /* renamed from: a, reason: collision with root package name */
    public final Context f40711a;

    /* renamed from: b, reason: collision with root package name */
    public int f40712b;

    /* renamed from: c, reason: collision with root package name */
    public String f40713c;

    /* renamed from: d, reason: collision with root package name */
    public String[] f40714d;

    /* renamed from: e, reason: collision with root package name */
    public String[] f40715e;

    /* renamed from: f, reason: collision with root package name */
    public View.OnClickListener f40716f;

    /* renamed from: g, reason: collision with root package name */
    public View.OnClickListener f40717g;

    /* renamed from: h, reason: collision with root package name */
    public String f40718h;

    /* renamed from: i, reason: collision with root package name */
    public String f40719i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f40720j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f40721k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f40722l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f40723m;

    /* renamed from: n, reason: collision with root package name */
    public h f40724n;

    /* renamed from: o, reason: collision with root package name */
    public List<Pair<String, String>> f40725o;

    /* renamed from: p, reason: collision with root package name */
    public CharSequence f40726p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f40727q;

    /* renamed from: r, reason: collision with root package name */
    public int f40728r;

    /* renamed from: s, reason: collision with root package name */
    public int f40729s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f40730t;

    /* renamed from: u, reason: collision with root package name */
    public String f40731u;

    /* renamed from: v, reason: collision with root package name */
    public String f40732v;

    /* renamed from: w, reason: collision with root package name */
    public String f40733w;

    /* renamed from: x, reason: collision with root package name */
    public String f40734x;

    /* renamed from: y, reason: collision with root package name */
    public CharSequence f40735y;

    public class a implements DialogInterface.OnCancelListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ic.c f40736a;

        public a(Ic.c cVar) {
            this.f40736a = cVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            q.this.h(dialogInterface, this.f40736a.getCheckBox().isChecked(), false, this.f40736a.getItemCheckedMap());
        }
    }

    public class b implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ic.c f40738a;

        public b(Ic.c cVar) {
            this.f40738a = cVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            q.this.h(dialogInterface, this.f40738a.getCheckBox().isChecked(), true, this.f40738a.getItemCheckedMap());
        }
    }

    public class c implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ic.c f40740a;

        public c(Ic.c cVar) {
            this.f40740a = cVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            q.this.h(dialogInterface, this.f40740a.getCheckBox().isChecked(), false, this.f40740a.getItemCheckedMap());
        }
    }

    public class d implements c.a.b<i> {
        public d() {
        }

        @Override // stepos.support.v7.app.c.a.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public i newDialog(Context context, int i10) {
            return new i(context, i10, q.this.f40724n, null);
        }
    }

    public class e implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f40743a;

        public e(i iVar) {
            this.f40743a = iVar;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
            this.f40743a.getButton(-1).setEnabled(!z10);
        }
    }

    public class f implements TermsStringBuilder.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f40745a;

        public f(TextView textView) {
            this.f40745a = textView;
        }

        @Override // stepos.support.v7.permission.TermsStringBuilder.a
        public void onPrivacyPolicyClick(Context context) {
            if (q.this.f40716f != null) {
                q.this.f40716f.onClick(this.f40745a);
            }
        }

        @Override // stepos.support.v7.permission.TermsStringBuilder.a
        public void onUserAgreementClick(Context context) {
            if (q.this.f40717g != null) {
                q.this.f40717g.onClick(this.f40745a);
            }
        }
    }

    public class g implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f40747a;

        public g(TextView textView) {
            this.f40747a = textView;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            this.f40747a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            if (this.f40747a.getLineCount() == 1) {
                this.f40747a.setGravity(17);
            }
        }
    }

    public interface h {
        default void onPermissionClick(DialogInterface dialogInterface, boolean z10, boolean z11) {
        }

        default void onPermissionClick(DialogInterface dialogInterface, boolean z10, boolean z11, Map<String, Boolean> map) {
        }
    }

    public static class i extends stepos.support.v7.app.c {

        /* renamed from: a, reason: collision with root package name */
        public h f40749a;

        public /* synthetic */ i(Context context, int i10, h hVar, a aVar) {
            this(context, i10, hVar);
        }

        public final boolean isPerformanceTest() {
            try {
                return ((Boolean) O6.r.c("android.os.SystemProperties").a("getBoolean", String.class, Boolean.TYPE).a(null, "debug.perf.applunch", Boolean.FALSE)).booleanValue();
            } catch (Exception unused) {
                return false;
            }
        }

        public final boolean isShopDemo() {
            return false;
        }

        @Override // android.app.Dialog
        public void show() {
            if (!isPerformanceTest() && !isShopDemo()) {
                super.show();
                return;
            }
            h hVar = this.f40749a;
            if (hVar != null) {
                hVar.onPermissionClick(this, false, true);
            }
        }

        public i(Context context, int i10, h hVar) {
            super(context, i10);
            this.f40749a = hVar;
        }
    }

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        f40709A = arrayList;
        arrayList.add("android.permission.CALL_PHONE");
        arrayList.add("android.permission.READ_CONTACTS");
        arrayList.add("android.permission.READ_SMS");
        arrayList.add(PolicySdkPermissionManifestUtils.WRITE_CONTACTS);
        arrayList.add("android.permission.SEND_SMS");
        arrayList.add("android.permission.RECEIVE_SMS");
        arrayList.add("android.permission.READ_CALL_LOG");
        arrayList.add(PolicySdkPermissionManifestUtils.RECORD_AUDIO);
    }

    public q(Context context) {
        this(context, stepos.support.v7.app.c.resolveDialogTheme(context, 0));
    }

    public stepos.support.v7.app.c e() throws Resources.NotFoundException {
        List<Pair<String, String>> list;
        Resources resources;
        int i10;
        String string;
        String string2 = this.f40711a.getString(R$string.stepos_permission_use_info);
        if (this.f40729s == 0 && TextUtils.isEmpty(this.f40713c)) {
            throw new IllegalArgumentException("appName can't be null");
        }
        String[] strArr = this.f40714d;
        boolean z10 = (strArr != null && (strArr.length > 0 || (strArr.length == 0 && this.f40728r == 1))) || ((list = this.f40725o) != null && list.size() > 0);
        boolean z11 = f40710z;
        if (z11) {
            z10 = z10 || !TextUtils.isEmpty(this.f40718h);
        }
        boolean z12 = (this.f40726p == null && this.f40716f == null && this.f40717g == null) ? false : true;
        if (!z10 && !z12) {
            throw new IllegalArgumentException("[permissions], [additional groups] and [terms] both null");
        }
        String[] strArr2 = this.f40714d;
        if (strArr2 != null) {
            String[] strArr3 = this.f40715e;
            if (strArr3 == null) {
                throw new IllegalArgumentException("permissionReason can't be null");
            }
            if (strArr3.length != strArr2.length) {
                throw new IllegalArgumentException("permissionReason.length must equal permissions.length");
            }
            f();
        }
        Ic.c cVar = new Ic.c(this.f40711a);
        new c.a().d(this.f40729s == 0 ? this.f40713c : string2).j(this.f40721k).h(this.f40714d, this.f40715e).c(this.f40725o).g(this.f40718h).i(this.f40719i).e(this.f40735y).f(this.f40722l).b(this.f40730t).k(z11).a(cVar);
        c.a aVarO = new c.a(this.f40711a, this.f40712b).v(cVar).g(this.f40720j).o(new a(cVar));
        if (TextUtils.isEmpty(this.f40734x)) {
            if (this.f40729s == 1) {
                resources = this.f40711a.getResources();
                i10 = R$string.stepos_permission_i_know;
            } else {
                resources = this.f40711a.getResources();
                i10 = R$string.stepos_permission_agree;
            }
            string = resources.getString(i10);
        } else {
            string = this.f40734x;
        }
        aVarO.s(string, new b(cVar));
        int i11 = this.f40729s;
        if (i11 != 1) {
            String string3 = this.f40733w;
            if (string3 == null) {
                string3 = (this.f40727q || i11 == 3) ? this.f40711a.getString(R$string.stepos_permission_deny) : this.f40711a.getString(R$string.stepos_reject);
            }
            aVarO.n(string3, new c(cVar));
            aVarO.i(-1, 0);
        }
        if (!z11) {
            if (this.f40729s == 0) {
                string2 = this.f40713c;
            }
            aVarO.u(string2);
        }
        i iVar = (i) aVarO.d(new d());
        cVar.getCheckBox().setOnCheckedChangeListener(new e(iVar));
        TextView termsView = cVar.getTermsView();
        if (this.f40726p == null) {
            this.f40726p = new TermsStringBuilder(this.f40711a).i(z10).l(this.f40716f != null).n(this.f40717g != null).j(this.f40728r).h(this.f40729s).m(this.f40731u).o(this.f40732v).k(new f(termsView)).e();
        }
        termsView.setText(this.f40726p);
        termsView.getViewTreeObserver().addOnGlobalLayoutListener(new g(termsView));
        termsView.setMovementMethod(LinkMovementMethod.getInstance());
        termsView.setHighlightColor(0);
        return iVar;
    }

    public final void f() {
        if (this.f40723m) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int i10 = 0;
            while (true) {
                String[] strArr = this.f40714d;
                if (i10 >= strArr.length) {
                    break;
                }
                String str = strArr[i10];
                if (!f40709A.contains(str)) {
                    arrayList.add(str);
                    String[] strArr2 = this.f40715e;
                    if (strArr2 != null) {
                        arrayList2.add(strArr2[i10]);
                    }
                }
                i10++;
            }
            this.f40714d = (String[]) arrayList.toArray(new String[0]);
            if (this.f40715e != null) {
                this.f40715e = (String[]) arrayList2.toArray(new String[0]);
            }
        }
    }

    public boolean g(Context context) {
        return context.getResources().getBoolean(R$bool.isTablet);
    }

    public final void h(DialogInterface dialogInterface, boolean z10, boolean z11, Map<String, Boolean> map) {
        h hVar = this.f40724n;
        if (hVar == null) {
            return;
        }
        if (this.f40730t) {
            hVar.onPermissionClick(dialogInterface, z10, z11, map);
        } else {
            hVar.onPermissionClick(dialogInterface, z10, z11);
        }
    }

    public q i(String str) {
        this.f40713c = str;
        return this;
    }

    public q j(boolean z10) {
        this.f40720j = z10;
        return this;
    }

    public q k(String str) {
        this.f40733w = str;
        return this;
    }

    public q l(String str) {
        this.f40734x = str;
        return this;
    }

    public q m(CharSequence charSequence) {
        this.f40726p = charSequence;
        return this;
    }

    public q n(h hVar) {
        this.f40724n = hVar;
        return this;
    }

    public q o(String str) {
        this.f40731u = str;
        return this;
    }

    public q p(boolean z10) {
        this.f40727q = z10;
        return this;
    }

    public q q(String str) {
        this.f40732v = str;
        return this;
    }

    public q r(View.OnClickListener onClickListener) {
        this.f40716f = onClickListener;
        return this;
    }

    public q s(View.OnClickListener onClickListener) {
        this.f40717g = onClickListener;
        return this;
    }

    public q(Context context, int i10) {
        this.f40716f = null;
        this.f40717g = null;
        this.f40720j = false;
        this.f40728r = 0;
        this.f40729s = 0;
        this.f40731u = null;
        this.f40732v = null;
        this.f40733w = null;
        this.f40734x = null;
        this.f40711a = context;
        this.f40712b = i10;
        this.f40723m = g(context);
    }
}

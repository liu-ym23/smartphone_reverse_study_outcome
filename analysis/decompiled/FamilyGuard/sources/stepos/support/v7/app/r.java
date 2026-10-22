package stepos.support.v7.app;

import Z4.f;
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
import b5.c;
import com.stepos.policy.sdk.util.PolicySdkPermissionManifestUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import stepos.support.v7.app.c;

/* loaded from: classes.dex */
public class r {

    /* renamed from: A, reason: collision with root package name */
    private static final ArrayList<String> f21049A;

    /* renamed from: z, reason: collision with root package name */
    public static final boolean f21050z = false;

    /* renamed from: a, reason: collision with root package name */
    private final Context f21051a;

    /* renamed from: b, reason: collision with root package name */
    private int f21052b;

    /* renamed from: c, reason: collision with root package name */
    private String f21053c;

    /* renamed from: d, reason: collision with root package name */
    private String[] f21054d;

    /* renamed from: e, reason: collision with root package name */
    private String[] f21055e;

    /* renamed from: f, reason: collision with root package name */
    private View.OnClickListener f21056f;

    /* renamed from: g, reason: collision with root package name */
    private View.OnClickListener f21057g;

    /* renamed from: h, reason: collision with root package name */
    private String f21058h;

    /* renamed from: i, reason: collision with root package name */
    private String f21059i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f21060j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f21061k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f21062l;

    /* renamed from: m, reason: collision with root package name */
    private final boolean f21063m;

    /* renamed from: n, reason: collision with root package name */
    private h f21064n;

    /* renamed from: o, reason: collision with root package name */
    private List<Pair<String, String>> f21065o;

    /* renamed from: p, reason: collision with root package name */
    private CharSequence f21066p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f21067q;

    /* renamed from: r, reason: collision with root package name */
    private int f21068r;

    /* renamed from: s, reason: collision with root package name */
    private int f21069s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f21070t;

    /* renamed from: u, reason: collision with root package name */
    private String f21071u;

    /* renamed from: v, reason: collision with root package name */
    private String f21072v;

    /* renamed from: w, reason: collision with root package name */
    private String f21073w;

    /* renamed from: x, reason: collision with root package name */
    private String f21074x;

    /* renamed from: y, reason: collision with root package name */
    private CharSequence f21075y;

    class a implements DialogInterface.OnCancelListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b5.c f21076a;

        a(b5.c cVar) {
            this.f21076a = cVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            r.this.h(dialogInterface, this.f21076a.getCheckBox().isChecked(), false, this.f21076a.getItemCheckedMap());
        }
    }

    class b implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b5.c f21078a;

        b(b5.c cVar) {
            this.f21078a = cVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i5) {
            r.this.h(dialogInterface, this.f21078a.getCheckBox().isChecked(), true, this.f21078a.getItemCheckedMap());
        }
    }

    class c implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b5.c f21080a;

        c(b5.c cVar) {
            this.f21080a = cVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i5) {
            r.this.h(dialogInterface, this.f21080a.getCheckBox().isChecked(), false, this.f21080a.getItemCheckedMap());
        }
    }

    class d implements c.a.b<i> {
        d() {
        }

        @Override // stepos.support.v7.app.c.a.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public i newDialog(Context context, int i5) {
            return new i(context, i5, r.this.f21064n, null);
        }
    }

    class e implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f21083a;

        e(i iVar) {
            this.f21083a = iVar;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z5) {
            this.f21083a.getButton(-1).setEnabled(!z5);
        }
    }

    class f implements f.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TextView f21085a;

        f(TextView textView) {
            this.f21085a = textView;
        }

        @Override // Z4.f.c
        public void onPrivacyPolicyClick(Context context) {
            if (r.this.f21056f != null) {
                r.this.f21056f.onClick(this.f21085a);
            }
        }

        @Override // Z4.f.c
        public void onUserAgreementClick(Context context) {
            if (r.this.f21057g != null) {
                r.this.f21057g.onClick(this.f21085a);
            }
        }
    }

    class g implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TextView f21087a;

        g(TextView textView) {
            this.f21087a = textView;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            this.f21087a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            if (this.f21087a.getLineCount() == 1) {
                this.f21087a.setGravity(17);
            }
        }
    }

    public interface h {
        default void onPermissionClick(DialogInterface dialogInterface, boolean z5, boolean z6) {
        }

        default void onPermissionClick(DialogInterface dialogInterface, boolean z5, boolean z6, Map<String, Boolean> map) {
        }
    }

    private static class i extends stepos.support.v7.app.c {

        /* renamed from: a, reason: collision with root package name */
        private h f21089a;

        /* synthetic */ i(Context context, int i5, h hVar, a aVar) {
            this(context, i5, hVar);
        }

        private boolean isPerformanceTest() {
            try {
                return ((Boolean) N1.h.c("android.os.SystemProperties").a("getBoolean", String.class, Boolean.TYPE).a(null, "debug.perf.applunch", Boolean.FALSE)).booleanValue();
            } catch (Exception unused) {
                return false;
            }
        }

        private boolean isShopDemo() {
            return false;
        }

        @Override // android.app.Dialog
        public void show() {
            if (!isPerformanceTest() && !isShopDemo()) {
                super.show();
                return;
            }
            h hVar = this.f21089a;
            if (hVar != null) {
                hVar.onPermissionClick(this, false, true);
            }
        }

        private i(Context context, int i5, h hVar) {
            super(context, i5);
            this.f21089a = hVar;
        }
    }

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        f21049A = arrayList;
        arrayList.add("android.permission.CALL_PHONE");
        arrayList.add("android.permission.READ_CONTACTS");
        arrayList.add("android.permission.READ_SMS");
        arrayList.add(PolicySdkPermissionManifestUtils.WRITE_CONTACTS);
        arrayList.add("android.permission.SEND_SMS");
        arrayList.add("android.permission.RECEIVE_SMS");
        arrayList.add("android.permission.READ_CALL_LOG");
        arrayList.add(PolicySdkPermissionManifestUtils.RECORD_AUDIO);
    }

    public r(Context context) {
        this(context, stepos.support.v7.app.c.resolveDialogTheme(context, 0));
    }

    private void f() {
        if (this.f21063m) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int i5 = 0;
            while (true) {
                String[] strArr = this.f21054d;
                if (i5 >= strArr.length) {
                    break;
                }
                String str = strArr[i5];
                if (!f21049A.contains(str)) {
                    arrayList.add(str);
                    String[] strArr2 = this.f21055e;
                    if (strArr2 != null) {
                        arrayList2.add(strArr2[i5]);
                    }
                }
                i5++;
            }
            this.f21054d = (String[]) arrayList.toArray(new String[0]);
            if (this.f21055e != null) {
                this.f21055e = (String[]) arrayList2.toArray(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(DialogInterface dialogInterface, boolean z5, boolean z6, Map<String, Boolean> map) {
        h hVar = this.f21064n;
        if (hVar == null) {
            return;
        }
        if (this.f21070t) {
            hVar.onPermissionClick(dialogInterface, z5, z6, map);
        } else {
            hVar.onPermissionClick(dialogInterface, z5, z6);
        }
    }

    public stepos.support.v7.app.c e() throws Resources.NotFoundException {
        List<Pair<String, String>> list;
        Resources resources;
        int i5;
        String string;
        String string2 = this.f21051a.getString(X4.j.f6065n);
        if (this.f21069s == 0 && TextUtils.isEmpty(this.f21053c)) {
            throw new IllegalArgumentException("appName can't be null");
        }
        String[] strArr = this.f21054d;
        boolean z5 = (strArr != null && (strArr.length > 0 || (strArr.length == 0 && this.f21068r == 1))) || ((list = this.f21065o) != null && list.size() > 0);
        boolean z6 = f21050z;
        if (z6) {
            z5 = z5 || !TextUtils.isEmpty(this.f21058h);
        }
        boolean z7 = (this.f21066p == null && this.f21056f == null && this.f21057g == null) ? false : true;
        if (!z5 && !z7) {
            throw new IllegalArgumentException("[permissions], [additional groups] and [terms] both null");
        }
        String[] strArr2 = this.f21054d;
        if (strArr2 != null) {
            String[] strArr3 = this.f21055e;
            if (strArr3 == null) {
                throw new IllegalArgumentException("permissionReason can't be null");
            }
            if (strArr3.length != strArr2.length) {
                throw new IllegalArgumentException("permissionReason.length must equal permissions.length");
            }
            f();
        }
        b5.c cVar = new b5.c(this.f21051a);
        new c.a().d(this.f21069s == 0 ? this.f21053c : string2).j(this.f21061k).h(this.f21054d, this.f21055e).c(this.f21065o).g(this.f21058h).i(this.f21059i).e(this.f21075y).f(this.f21062l).b(this.f21070t).k(z6).a(cVar);
        c.a aVarS = new c.a(this.f21051a, this.f21052b).z(cVar).g(this.f21060j).s(new a(cVar));
        if (TextUtils.isEmpty(this.f21074x)) {
            if (this.f21069s == 1) {
                resources = this.f21051a.getResources();
                i5 = X4.j.f6057f;
            } else {
                resources = this.f21051a.getResources();
                i5 = X4.j.f6055d;
            }
            string = resources.getString(i5);
        } else {
            string = this.f21074x;
        }
        aVarS.v(string, new b(cVar));
        int i6 = this.f21069s;
        if (i6 != 1) {
            String string3 = this.f21073w;
            if (string3 == null) {
                string3 = (this.f21067q || i6 == 3) ? this.f21051a.getString(X4.j.f6056e) : this.f21051a.getString(X4.j.f6071t);
            }
            aVarS.p(string3, new c(cVar));
            aVarS.i(-1, 0);
        }
        if (!z6) {
            if (this.f21069s == 0) {
                string2 = this.f21053c;
            }
            aVarS.y(string2);
        }
        i iVar = (i) aVarS.d(new d());
        cVar.getCheckBox().setOnCheckedChangeListener(new e(iVar));
        TextView termsView = cVar.getTermsView();
        if (this.f21066p == null) {
            this.f21066p = new Z4.f(this.f21051a).i(z5).l(this.f21056f != null).n(this.f21057g != null).j(this.f21068r).h(this.f21069s).m(this.f21071u).o(this.f21072v).k(new f(termsView)).e();
        }
        termsView.setText(this.f21066p);
        termsView.getViewTreeObserver().addOnGlobalLayoutListener(new g(termsView));
        termsView.setMovementMethod(LinkMovementMethod.getInstance());
        termsView.setHighlightColor(0);
        return iVar;
    }

    public boolean g(Context context) {
        return context.getResources().getBoolean(X4.b.f5853c);
    }

    public r i(String str) {
        this.f21053c = str;
        return this;
    }

    public r j(boolean z5) {
        this.f21060j = z5;
        return this;
    }

    public r k(String str) {
        this.f21073w = str;
        return this;
    }

    public r l(String str) {
        this.f21074x = str;
        return this;
    }

    public r m(CharSequence charSequence) {
        this.f21066p = charSequence;
        return this;
    }

    public r n(h hVar) {
        this.f21064n = hVar;
        return this;
    }

    public r o(String str) {
        this.f21071u = str;
        return this;
    }

    public r p(boolean z5) {
        this.f21067q = z5;
        return this;
    }

    public r q(String str) {
        this.f21072v = str;
        return this;
    }

    public r r(View.OnClickListener onClickListener) {
        this.f21056f = onClickListener;
        return this;
    }

    public r s(View.OnClickListener onClickListener) {
        this.f21057g = onClickListener;
        return this;
    }

    public r(Context context, int i5) {
        this.f21056f = null;
        this.f21057g = null;
        this.f21060j = false;
        this.f21068r = 0;
        this.f21069s = 0;
        this.f21071u = null;
        this.f21072v = null;
        this.f21073w = null;
        this.f21074x = null;
        this.f21051a = context;
        this.f21052b = i5;
        this.f21063m = g(context);
    }
}

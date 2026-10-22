package stepos.support.v7.app;

import android.content.Context;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.stepos.ability.R;
import com.stepos.policy.sdk.util.PolicySdkPermissionManifestUtils;
import java.util.ArrayList;
import k2.C1621a;

/* loaded from: classes4.dex */
public final class S {

    /* renamed from: q, reason: collision with root package name */
    public static final ArrayList f6233q;

    /* renamed from: a, reason: collision with root package name */
    public final Context f6234a;
    public final int b;
    public String c;
    public String[] d;
    public String[] e;
    public com.stepos.policy.sdk.a f;
    public View.OnClickListener g;
    public boolean h;
    public final boolean i;

    /* renamed from: j, reason: collision with root package name */
    public P f6235j;
    public CharSequence k;
    public boolean l;
    public String m;
    public String n;
    public String o;
    public String p;

    static {
        ArrayList arrayList = new ArrayList();
        f6233q = arrayList;
        arrayList.add("android.permission.CALL_PHONE");
        arrayList.add("android.permission.READ_CONTACTS");
        arrayList.add("android.permission.READ_SMS");
        arrayList.add(PolicySdkPermissionManifestUtils.WRITE_CONTACTS);
        arrayList.add("android.permission.SEND_SMS");
        arrayList.add("android.permission.RECEIVE_SMS");
        arrayList.add("android.permission.READ_CALL_LOG");
        arrayList.add(PolicySdkPermissionManifestUtils.RECORD_AUDIO);
    }

    public S(Context context) {
        int iResolveDialogTheme = DialogInterfaceC1961j.resolveDialogTheme(context, 0);
        this.f = null;
        this.g = null;
        this.h = false;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.f6234a = context;
        this.b = iResolveDialogTheme;
        this.i = context.getResources().getBoolean(R.bool.isTablet);
    }

    public final Q a() {
        Context context = this.f6234a;
        context.getString(R.string.stepos_permission_use_info);
        if (TextUtils.isEmpty(this.c)) {
            throw new IllegalArgumentException("appName can't be null");
        }
        String[] strArr = this.d;
        boolean z10 = strArr != null && strArr.length > 0;
        boolean z11 = (this.k == null && this.f == null && this.g == null) ? false : true;
        if (!z10 && !z11) {
            throw new IllegalArgumentException("[permissions], [additional groups] and [terms] both null");
        }
        if (strArr != null) {
            String[] strArr2 = this.e;
            if (strArr2 == null) {
                throw new IllegalArgumentException("permissionReason can't be null");
            }
            if (strArr2.length != strArr.length) {
                throw new IllegalArgumentException("permissionReason.length must equal permissions.length");
            }
            if (this.i) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                int i = 0;
                while (true) {
                    String[] strArr3 = this.d;
                    if (i >= strArr3.length) {
                        break;
                    }
                    String str = strArr3[i];
                    if (!f6233q.contains(str)) {
                        arrayList.add(str);
                        String[] strArr4 = this.e;
                        if (strArr4 != null) {
                            arrayList2.add(strArr4[i]);
                        }
                    }
                    i++;
                }
                this.d = (String[]) arrayList.toArray(new String[0]);
                if (this.e != null) {
                    this.e = (String[]) arrayList2.toArray(new String[0]);
                }
            }
        }
        Ua.e eVar = new Ua.e(context);
        Ua.d dVar = new Ua.d();
        dVar.f1281a = this.c;
        String[] strArr5 = this.d;
        String[] strArr6 = this.e;
        dVar.b = strArr5;
        dVar.c = strArr6;
        dVar.d = false;
        eVar.setPermissionDialogBuild(dVar);
        C1960i c1960i = new C1960i(context, this.b);
        C1956e c1956e = c1960i.f6314a;
        c1956e.o = eVar;
        c1956e.f6296j = this.h;
        c1956e.k = new M(this, eVar);
        String string = !TextUtils.isEmpty(this.p) ? this.p : context.getResources().getString(R.string.stepos_permission_agree);
        N n = new N(this, eVar, 0);
        c1956e.f = string;
        c1956e.g = n;
        String string2 = this.o;
        if (string2 == null) {
            string2 = !this.l ? context.getString(R.string.stepos_reject) : context.getString(R.string.stepos_permission_deny);
        }
        N n7 = new N(this, eVar, 1);
        c1956e.h = string2;
        c1956e.i = n7;
        c1956e.p = -1;
        c1956e.f6297q = 0;
        c1956e.d = this.c;
        Q q5 = (Q) c1960i.a(new Z0.a(this));
        eVar.getCheckBox().setOnCheckedChangeListener(new Y4.a(q5, 1));
        TextView termsView = eVar.getTermsView();
        if (this.k == null) {
            stepos.support.v7.permission.f fVar = new stepos.support.v7.permission.f(context);
            fVar.d = z10;
            fVar.b = this.f != null;
            fVar.c = this.g != null;
            fVar.f = 0;
            fVar.g = 0;
            fVar.h = this.m;
            fVar.i = this.n;
            C1621a c1621a = new C1621a();
            c1621a.b = this;
            c1621a.f4793a = termsView;
            fVar.e = c1621a;
            this.k = fVar.b();
        }
        termsView.setText(this.k);
        termsView.getViewTreeObserver().addOnGlobalLayoutListener(new O(0, termsView));
        termsView.setMovementMethod(LinkMovementMethod.getInstance());
        termsView.setHighlightColor(0);
        return q5;
    }
}

package stepos.support.v7.app;

import android.content.Context;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.stepos.alphame.R;
import com.stepos.policy.sdk.util.PolicySdkPermissionManifestUtils;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class U {

    /* renamed from: q, reason: collision with root package name */
    public static final ArrayList f14336q;

    /* renamed from: a, reason: collision with root package name */
    public final Context f14337a;

    /* renamed from: b, reason: collision with root package name */
    public final int f14338b;

    /* renamed from: c, reason: collision with root package name */
    public String f14339c;

    /* renamed from: d, reason: collision with root package name */
    public String[] f14340d;

    /* renamed from: e, reason: collision with root package name */
    public String[] f14341e;

    /* renamed from: f, reason: collision with root package name */
    public View.OnClickListener f14342f;

    /* renamed from: g, reason: collision with root package name */
    public View.OnClickListener f14343g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f14344h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f14345i;

    /* renamed from: j, reason: collision with root package name */
    public S f14346j;

    /* renamed from: k, reason: collision with root package name */
    public CharSequence f14347k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f14348l;

    /* renamed from: m, reason: collision with root package name */
    public String f14349m;

    /* renamed from: n, reason: collision with root package name */
    public String f14350n;

    /* renamed from: o, reason: collision with root package name */
    public String f14351o;

    /* renamed from: p, reason: collision with root package name */
    public String f14352p;

    static {
        ArrayList arrayList = new ArrayList();
        f14336q = arrayList;
        arrayList.add("android.permission.CALL_PHONE");
        arrayList.add("android.permission.READ_CONTACTS");
        arrayList.add("android.permission.READ_SMS");
        arrayList.add(PolicySdkPermissionManifestUtils.WRITE_CONTACTS);
        arrayList.add("android.permission.SEND_SMS");
        arrayList.add("android.permission.RECEIVE_SMS");
        arrayList.add("android.permission.READ_CALL_LOG");
        arrayList.add(PolicySdkPermissionManifestUtils.RECORD_AUDIO);
    }

    public U(Context context) {
        int iResolveDialogTheme = DialogInterfaceC0865j.resolveDialogTheme(context, 0);
        this.f14342f = null;
        this.f14343g = null;
        this.f14344h = false;
        this.f14349m = null;
        this.f14350n = null;
        this.f14351o = null;
        this.f14352p = null;
        this.f14337a = context;
        this.f14338b = iResolveDialogTheme;
        this.f14345i = context.getResources().getBoolean(R.bool.isTablet);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final T a() {
        Context context = this.f14337a;
        context.getString(R.string.stepos_permission_use_info);
        if (TextUtils.isEmpty(this.f14339c)) {
            throw new IllegalArgumentException("appName can't be null");
        }
        String[] strArr = this.f14340d;
        int i4 = 0;
        char c4 = 1;
        boolean z4 = strArr != null && strArr.length > 0;
        Object[] objArr = (this.f14347k == null && this.f14342f == null && this.f14343g == null) ? false : true;
        if (!z4 && objArr != true) {
            throw new IllegalArgumentException("[permissions], [additional groups] and [terms] both null");
        }
        if (strArr != null) {
            String[] strArr2 = this.f14341e;
            if (strArr2 == null) {
                throw new IllegalArgumentException("permissionReason can't be null");
            }
            if (strArr2.length != strArr.length) {
                throw new IllegalArgumentException("permissionReason.length must equal permissions.length");
            }
            if (this.f14345i) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                int i5 = 0;
                while (true) {
                    String[] strArr3 = this.f14340d;
                    if (i5 >= strArr3.length) {
                        break;
                    }
                    String str = strArr3[i5];
                    if (!f14336q.contains(str)) {
                        arrayList.add(str);
                        String[] strArr4 = this.f14341e;
                        if (strArr4 != null) {
                            arrayList2.add(strArr4[i5]);
                        }
                    }
                    i5++;
                }
                this.f14340d = (String[]) arrayList.toArray(new String[0]);
                if (this.f14341e != null) {
                    this.f14341e = (String[]) arrayList2.toArray(new String[0]);
                }
            }
        }
        K3.e eVar = new K3.e(context);
        K3.d dVar = new K3.d();
        dVar.f1052a = this.f14339c;
        dVar.f1053b = false;
        String[] strArr5 = this.f14340d;
        String[] strArr6 = this.f14341e;
        dVar.f1054c = strArr5;
        dVar.f1055d = strArr6;
        dVar.f1060i = null;
        dVar.f1056e = null;
        dVar.f1061j = null;
        dVar.f1057f = false;
        dVar.f1059h = false;
        dVar.f1058g = false;
        eVar.setPermissionDialogBuild(dVar);
        C0864i c0864i = new C0864i(context, this.f14338b);
        C0861f c0861f = c0864i.f14506a;
        c0861f.f14466r = eVar;
        c0861f.f14459k = this.f14344h;
        c0861f.f14460l = new N(this, eVar);
        String string = !TextUtils.isEmpty(this.f14352p) ? this.f14352p : context.getResources().getString(R.string.stepos_permission_agree);
        O o4 = new O(this, eVar, i4);
        c0861f.f14455g = string;
        c0861f.f14456h = o4;
        String string2 = this.f14351o;
        if (string2 == null) {
            string2 = !this.f14348l ? context.getString(R.string.stepos_reject) : context.getString(R.string.stepos_permission_deny);
        }
        O o5 = new O(this, eVar, c4 == true ? 1 : 0);
        c0861f.f14457i = string2;
        c0861f.f14458j = o5;
        c0861f.f14469u = -1;
        c0861f.f14470v = 0;
        c0861f.f14452d = this.f14339c;
        T t4 = (T) c0864i.a(new C0872q(2, this));
        eVar.getCheckBox().setOnCheckedChangeListener(new P(t4));
        TextView termsView = eVar.getTermsView();
        if (this.f14347k == null) {
            stepos.support.v7.permission.f fVar = new stepos.support.v7.permission.f(context);
            fVar.f14656d = z4;
            fVar.f14654b = this.f14342f != null;
            fVar.f14655c = this.f14343g != null;
            fVar.f14658f = 0;
            fVar.f14659g = 0;
            fVar.f14660h = this.f14349m;
            fVar.f14661i = this.f14350n;
            fVar.f14657e = new B0.m(11, this, termsView);
            this.f14347k = fVar.b();
        }
        termsView.setText(this.f14347k);
        termsView.getViewTreeObserver().addOnGlobalLayoutListener(new Q(this, termsView, 0));
        termsView.setMovementMethod(LinkMovementMethod.getInstance());
        termsView.setHighlightColor(0);
        return t4;
    }
}

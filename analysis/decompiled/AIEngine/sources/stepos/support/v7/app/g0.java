package stepos.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.stepos.aiengine.R;
import com.stepos.policy.sdk.util.PolicySdkPermissionManifestUtils;
import fe.c;
import java.util.ArrayList;
import stepos.support.v7.app.c;
import stepos.support.v7.app.e;
import stepos.support.v7.permission.TermsStringBuilder;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g0 {

    /* renamed from: q, reason: collision with root package name */
    public static final ArrayList<String> f12106q;

    /* renamed from: a, reason: collision with root package name */
    public final Context f12107a;

    /* renamed from: b, reason: collision with root package name */
    public final int f12108b;

    /* renamed from: c, reason: collision with root package name */
    public String f12109c;

    /* renamed from: d, reason: collision with root package name */
    public String[] f12110d;

    /* renamed from: e, reason: collision with root package name */
    public String[] f12111e;

    /* renamed from: f, reason: collision with root package name */
    public com.stepos.policy.sdk.a f12112f;

    /* renamed from: g, reason: collision with root package name */
    public View.OnClickListener f12113g;
    public boolean h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f12114i;

    /* renamed from: j, reason: collision with root package name */
    public a f12115j;

    /* renamed from: k, reason: collision with root package name */
    public CharSequence f12116k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f12117l;

    /* renamed from: m, reason: collision with root package name */
    public String f12118m;

    /* renamed from: n, reason: collision with root package name */
    public String f12119n;

    /* renamed from: o, reason: collision with root package name */
    public String f12120o;

    /* renamed from: p, reason: collision with root package name */
    public String f12121p;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class b extends e {

        /* renamed from: a, reason: collision with root package name */
        public a f12122a;

        @Override // android.app.Dialog
        public final void show() {
            boolean zBooleanValue;
            try {
                zBooleanValue = ((Boolean) l8.e.b("android.os.SystemProperties").a("getBoolean", String.class, Boolean.TYPE).a(null, "debug.perf.applunch", Boolean.FALSE)).booleanValue();
            } catch (Exception unused) {
                zBooleanValue = false;
            }
            if (!zBooleanValue) {
                super.show();
                return;
            }
            a aVar = this.f12122a;
            if (aVar != null) {
                aVar.onPermissionClick(this, false, true);
            }
        }
    }

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        f12106q = arrayList;
        arrayList.add("android.permission.CALL_PHONE");
        arrayList.add("android.permission.READ_CONTACTS");
        arrayList.add("android.permission.READ_SMS");
        arrayList.add(PolicySdkPermissionManifestUtils.WRITE_CONTACTS);
        arrayList.add("android.permission.SEND_SMS");
        arrayList.add("android.permission.RECEIVE_SMS");
        arrayList.add("android.permission.READ_CALL_LOG");
        arrayList.add(PolicySdkPermissionManifestUtils.RECORD_AUDIO);
    }

    public g0(Context context) {
        int iResolveDialogTheme = e.resolveDialogTheme(context, 0);
        this.f12112f = null;
        this.f12113g = null;
        this.h = false;
        this.f12118m = null;
        this.f12119n = null;
        this.f12120o = null;
        this.f12121p = null;
        this.f12107a = context;
        this.f12108b = iResolveDialogTheme;
        this.f12114i = context.getResources().getBoolean(R.bool.isTablet);
    }

    public final b a() {
        Context context = this.f12107a;
        context.getString(R.string.stepos_permission_use_info);
        if (TextUtils.isEmpty(this.f12109c)) {
            throw new IllegalArgumentException("appName can't be null");
        }
        String[] strArr = this.f12110d;
        boolean z = strArr != null && strArr.length > 0;
        boolean z3 = (this.f12116k == null && this.f12112f == null && this.f12113g == null) ? false : true;
        if (!z && !z3) {
            throw new IllegalArgumentException("[permissions], [additional groups] and [terms] both null");
        }
        if (strArr != null) {
            String[] strArr2 = this.f12111e;
            if (strArr2 == null) {
                throw new IllegalArgumentException("permissionReason can't be null");
            }
            if (strArr2.length != strArr.length) {
                throw new IllegalArgumentException("permissionReason.length must equal permissions.length");
            }
            if (this.f12114i) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                int i10 = 0;
                while (true) {
                    String[] strArr3 = this.f12110d;
                    if (i10 >= strArr3.length) {
                        break;
                    }
                    String str = strArr3[i10];
                    if (!f12106q.contains(str)) {
                        arrayList.add(str);
                        String[] strArr4 = this.f12111e;
                        if (strArr4 != null) {
                            arrayList2.add(strArr4[i10]);
                        }
                    }
                    i10++;
                }
                this.f12110d = (String[]) arrayList.toArray(new String[0]);
                if (this.f12111e != null) {
                    this.f12111e = (String[]) arrayList2.toArray(new String[0]);
                }
            }
        }
        fe.c cVar = new fe.c(context);
        c.a aVar = new c.a();
        aVar.f8855a = this.f12109c;
        String[] strArr5 = this.f12110d;
        String[] strArr6 = this.f12111e;
        aVar.f8856b = strArr5;
        aVar.f8857c = strArr6;
        aVar.f8858d = false;
        cVar.setPermissionDialogBuild(aVar);
        e.a aVar2 = new e.a(context, this.f12108b);
        c.a aVar3 = aVar2.f12101a;
        aVar3.f12094o = cVar;
        aVar3.f12089j = this.h;
        aVar3.f12090k = new z(this, cVar);
        String string = !TextUtils.isEmpty(this.f12121p) ? this.f12121p : context.getResources().getString(R.string.stepos_permission_agree);
        a0 a0Var = new a0(this, cVar);
        aVar3.f12086f = string;
        aVar3.f12087g = a0Var;
        String string2 = this.f12120o;
        if (string2 == null) {
            string2 = !this.f12117l ? context.getString(R.string.stepos_reject) : context.getString(R.string.stepos_permission_deny);
        }
        b0 b0Var = new b0(this, cVar);
        aVar3.h = string2;
        aVar3.f12088i = b0Var;
        aVar3.f12095p = -1;
        aVar3.f12096q = 0;
        aVar3.f12084d = this.f12109c;
        b bVar = (b) aVar2.a(new c0(this));
        cVar.getCheckBox().setOnCheckedChangeListener(new d0(bVar));
        TextView termsView = cVar.getTermsView();
        if (this.f12116k == null) {
            TermsStringBuilder termsStringBuilder = new TermsStringBuilder(context);
            termsStringBuilder.f12304d = z;
            termsStringBuilder.f12302b = this.f12112f != null;
            termsStringBuilder.f12303c = this.f12113g != null;
            termsStringBuilder.f12306f = 0;
            termsStringBuilder.f12307g = 0;
            termsStringBuilder.h = this.f12118m;
            termsStringBuilder.f12308i = this.f12119n;
            termsStringBuilder.f12305e = new e0(this, termsView);
            this.f12116k = termsStringBuilder.b();
        }
        termsView.setText(this.f12116k);
        termsView.getViewTreeObserver().addOnGlobalLayoutListener(new f0(termsView));
        termsView.setMovementMethod(LinkMovementMethod.getInstance());
        termsView.setHighlightColor(0);
        return bVar;
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface a {
        default void onPermissionClick(DialogInterface dialogInterface, boolean z, boolean z3) {
        }
    }
}

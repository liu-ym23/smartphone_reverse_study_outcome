package com.obric.oui.window.permission;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.common.oui.R$drawable;
import com.obric.common.oui.R$string;
import com.obric.oui.privacy.OPrivacySheet;
import com.obric.oui.utils.log.L;
import com.tmall.wireless.tangram.dataparser.concrete.Card;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.t;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 32\u00020\u0001:\u0003456B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u0003J\u000f\u0010\u000e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0015¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0018\u0010\u0003J\u000f\u0010\u0019\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0019\u0010\u0003J\u000f\u0010\u001a\u001a\u00020\nH\u0014¢\u0006\u0004\b\u001a\u0010\u0003J\u000f\u0010\u001b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u001b\u0010\u0003J\u000f\u0010\u001c\u001a\u00020\nH\u0014¢\u0006\u0004\b\u001c\u0010\u0003J\u000f\u0010\u001d\u001a\u00020\nH\u0014¢\u0006\u0004\b\u001d\u0010\u0003J\u000f\u0010\u001e\u001a\u00020\nH\u0014¢\u0006\u0004\b\u001e\u0010\u0003J\u000f\u0010\u001f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001f\u0010\u0003J\u000f\u0010 \u001a\u00020\nH\u0016¢\u0006\u0004\b \u0010\u0003J\u000f\u0010!\u001a\u00020\nH\u0016¢\u0006\u0004\b!\u0010\u0003J\u000f\u0010\"\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\"\u0010\u0006R\u0016\u0010$\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010 R\u0016\u0010&\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010 R\u0016\u0010(\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010 R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010.\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010+R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101¨\u00067"}, d2 = {"Lcom/obric/oui/window/permission/PrivacyStatementActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "", "W", "()Z", "", "url", "title", "", "b0", "(Ljava/lang/String;Ljava/lang/String;)V", "U", "V", "()Ljava/lang/String;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/content/Intent;", MemorySourceLinkType.INTENT, "c0", "(Landroid/content/Intent;)V", "onContentChanged", "onBackPressed", "onStart", "onResume", "onPause", "onStop", "onDestroy", "X", "Z", "a0", "T", "c", "hasAgreed", "d", "showNetworkConfirm", "e", "useLinkTextAsTitle", "Landroid/view/View;", "f", "Landroid/view/View;", "root", "g", "contentChild", "Lcom/obric/oui/privacy/OPrivacySheet;", "h", "Lcom/obric/oui/privacy/OPrivacySheet;", "privacySheet", "i", "a", "LinkClickListener", "PrivacyConsentCallback", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class PrivacyStatementActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f17661i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Map f17662j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Map f17663k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Map f17664l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Map f17665m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Map f17666n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static int f17667o;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f17668c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f17669d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f17670e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f17671f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f17672g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public OPrivacySheet f17673h;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/obric/oui/window/permission/PrivacyStatementActivity$LinkClickListener;", "", "onLinkClick", "", "url", "", "context", "Landroid/content/Context;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface LinkClickListener {
        void onLinkClick(@NotNull String r10, @NotNull Context r11);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\u0010\u0010\u0002\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0003H'J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/obric/oui/window/permission/PrivacyStatementActivity$PrivacyConsentCallback;", "", "onAgree", "", "", "activity", "Landroid/app/Activity;", "onCancel", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface PrivacyConsentCallback {

        public static final class a {
            public static boolean a(PrivacyConsentCallback r10, Activity r11) {
                q.g(r10, "this");
                q.g(r11, "activity");
                return false;
            }
        }

        @Deprecated(message = "use onAgree(activity: Activity) instead")
        void onAgree();

        boolean onAgree(@NotNull Activity r10);

        @Deprecated(message = "use onCancel(activity: Activity) instead")
        void onCancel();

        boolean onCancel(@NotNull Activity r10);
    }

    public static final class a {

        /* JADX INFO: renamed from: com.obric.oui.window.permission.PrivacyStatementActivity$a$a, reason: collision with other inner class name */
        public static abstract class AbstractC0212a {
            public AbstractC0212a() {
            }

            public abstract void a(Intent r10);

            public abstract void b(Activity r10);

            public abstract void c(Activity r10);

            public abstract void d(Activity r10);

            public abstract void e(Activity r10);

            public abstract void f(Activity r10);

            public abstract void g(Activity r10);
        }

        public static final class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Context f17674a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f17675b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public String f17676c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public String f17677d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public String f17678e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public CharSequence f17679f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public List f17680g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public List f17681h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public int f17682i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public PrivacyConsentCallback f17683j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public LinkClickListener f17684k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public boolean f17685l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public String[] f17686m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public String f17687n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            public boolean f17688o;

            /* JADX INFO: renamed from: p, reason: collision with root package name */
            public String f17689p;

            /* JADX INFO: renamed from: q, reason: collision with root package name */
            public boolean f17690q;

            /* JADX INFO: renamed from: r, reason: collision with root package name */
            public boolean f17691r;

            /* JADX INFO: renamed from: s, reason: collision with root package name */
            public boolean f17692s;

            /* JADX INFO: renamed from: t, reason: collision with root package name */
            public boolean f17693t;

            public b(Context r10) {
                q.g(r10, "context");
                this.f17674a = r10;
                String r11 = r10.getString(R$string.default_title);
                q.f(r11, "context.getString(R.string.default_title)");
                this.f17675b = r11;
                this.f17680g = t.i();
                this.f17681h = t.i();
                this.f17682i = R$drawable.ic_default_icon;
                this.f17685l = true;
                this.f17686m = new String[0];
                this.f17691r = true;
                this.f17692s = true;
            }

            public final b a(String r10) {
                q.g(r10, "agreeText");
                this.f17678e = r10;
                return this;
            }

            public final b b(String r10) {
                q.g(r10, "cancelText");
                this.f17677d = r10;
                return this;
            }

            public final b c(PrivacyConsentCallback r10) {
                q.g(r10, "callback");
                this.f17683j = r10;
                return this;
            }

            public final b d(String r10) {
                q.g(r10, "packageName");
                this.f17689p = r10;
                return this;
            }

            public final b e(String r10) {
                q.g(r10, "description");
                this.f17676c = r10;
                return this;
            }

            public final b f(List r10) {
                q.g(r10, Card.KEY_ITEMS);
                this.f17681h = r10;
                return this;
            }

            public final b g(List r10) {
                q.g(r10, "linkTexts");
                this.f17680g = r10;
                return this;
            }

            public final b h(CharSequence r10) {
                q.g(r10, "privacyText");
                this.f17679f = r10;
                return this;
            }

            public final b i(String[] r10) {
                q.g(r10, "urls");
                this.f17686m = r10;
                return this;
            }

            public final b j(boolean r10) {
                this.f17685l = r10;
                return this;
            }

            public final b k(String r10) {
                q.g(r10, "title");
                this.f17675b = r10;
                return this;
            }

            public final b l() {
                this.f17688o = true;
                return this;
            }

            public final void m(AbstractC0212a r10) {
                L.a("PrivacyStatementActivity", "show");
                Intent r11 = new Intent(this.f17674a, PrivacyStatementActivity.class);
                r11.putExtra("title", this.f17675b);
                r11.putExtra("description", this.f17676c);
                r11.putExtra("cancelText", this.f17677d);
                r11.putExtra("agreeText", this.f17678e);
                r11.putExtra("privacyText", this.f17679f);
                r11.putExtra("iconResId", this.f17682i);
                r11.putExtra("urls", this.f17686m);
                r11.putExtra("showNetworkConfirm", this.f17685l);
                r11.putExtra("useLinkTextAsTitle", this.f17688o);
                r11.putExtra("customPackageName", this.f17689p);
                r11.putExtra("forceNightMode", this.f17690q);
                r11.putExtra("enableDim", this.f17691r);
                r11.putExtra("cancelable", this.f17692s);
                r11.putExtra("enableEnterAnim", this.f17693t);
                String r12 = this.f17687n;
                if (r12 != null) goto L6;
            L8:
                String r13 = a.a(PrivacyStatementActivity.f17661i);
                r11.putExtra("PrivacyStatementActivityInstanceId", r13);
                if (r10 == null) goto L11;
                PrivacyStatementActivity.H().put(r13, r10);
                r10.a(r11);
            L11:
                PrivacyStatementActivity.M().put(r13, this.f17681h);
                PrivacyStatementActivity.N().put(r13, this.f17680g);
                PrivacyStatementActivity.L().put(r13, this.f17683j);
                PrivacyStatementActivity.K().put(r13, this.f17684k);
                this.f17674a.startActivity(r11);
                return;
            L6:
                if (r12.length() <= 0) goto L8;
                r11.putExtra("customizedCancelText", this.f17687n);
                goto L8
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public static final /* synthetic */ String a(a r10) {
            return r10.b();
        }

        public final String b() {
            StringBuilder r10 = new StringBuilder();
            r10.append("PrivacyStatementActivity_");
            r10.append(UUID.randomUUID());
            r10.append('_');
            int r11 = PrivacyStatementActivity.I();
            PrivacyStatementActivity.R(r11 + 1);
            r10.append(r11);
            return r10.toString();
        }

        public a() {
        }
    }

    static {
        f17661i = new a(null);
        f17662j = new LinkedHashMap();
        f17663k = new LinkedHashMap();
        f17664l = new LinkedHashMap();
        f17665m = new LinkedHashMap();
        f17666n = new LinkedHashMap();
    }

    public PrivacyStatementActivity() {
        this.f17669d = true;
    }

    public static /* synthetic */ WindowInsetsCompat F(View r10, WindowInsetsCompat r11) {
        return Y(r10, r11);
    }

    public static final /* synthetic */ void G(PrivacyStatementActivity r10) {
        r10.U();
    }

    public static final /* synthetic */ Map H() {
        return f17664l;
    }

    public static final /* synthetic */ int I() {
        return f17667o;
    }

    public static final /* synthetic */ boolean J(PrivacyStatementActivity r10) {
        return r10.f17668c;
    }

    public static final /* synthetic */ Map K() {
        return f17663k;
    }

    public static final /* synthetic */ Map L() {
        return f17662j;
    }

    public static final /* synthetic */ Map M() {
        return f17666n;
    }

    public static final /* synthetic */ Map N() {
        return f17665m;
    }

    public static final /* synthetic */ OPrivacySheet O(PrivacyStatementActivity r10) {
        return r10.f17673h;
    }

    public static final /* synthetic */ boolean P(PrivacyStatementActivity r10) {
        return r10.f17669d;
    }

    public static final /* synthetic */ void Q(PrivacyStatementActivity r10, String r11, String r12) {
        r10.b0(r11, r12);
    }

    public static final /* synthetic */ void R(int r10) {
        f17667o = r10;
    }

    public static final /* synthetic */ void S(PrivacyStatementActivity r10, boolean r11) {
        r10.f17668c = r11;
    }

    private final String V() {
        String r10 = getIntent().getStringExtra("customPackageName");
        if (r10 != null) goto L5;
    L8:
        String r11 = getPackageName();
        q.f(r11, "{\n            packageName\n        }");
        return r11;
    L5:
        if (r10.length() == 0) goto L8;
        L.j("PrivacyStatementActivity", q.p("using custom packageName: ", r10));
        return r10;
    }

    public static final WindowInsetsCompat Y(View r10, WindowInsetsCompat r11) {
        int r12 = r11.m();
        r11.j();
        q.f(r10, "v");
        r10.setPadding(r10.getPaddingLeft(), r12, r10.getPaddingRight(), 0);
        return r11;
    }

    public boolean T() {
        return true;
    }

    public final void U() {
        String r10 = getIntent().getStringExtra("PrivacyStatementActivityInstanceId");
        if (r10 == null) goto L6;
        f17662j.remove(r10);
        f17663k.remove(r10);
        f17665m.remove(r10);
        List r11 = (List) f17666n.remove(r10);
    L6:
        finish();
    }

    public final boolean W() {
        View r10 = getWindow().getDecorView();
        q.f(r10, "window.decorView");
        return !r10.getFitsSystemWindows();
    }

    public void X() {
    }

    public void Z() {
    }

    public void a0() {
    }

    public final void b0(String r10, String r11) {
        WebViewActivity.U(this, r10, r11);
    }

    public final void c0(Intent r23) {
        q.g(r23, MemorySourceLinkType.INTENT);
        String r10 = r23.getStringExtra("title");
        if (r10 != null) goto L5;
        r10 = getString(R$string.default_title);
    L5:
        final String r11 = r10;
        q.f(r11, "intent.getStringExtra(\"t…g(R.string.default_title)");
        String r12 = r23.getStringExtra("description");
        String r16 = r23.getStringExtra("cancelText");
        String r15 = r23.getStringExtra("agreeText");
        CharSequence r13 = r23.getCharSequenceExtra("privacyText");
        String[] r14 = r23.getStringArrayExtra("urls");
        if (r14 != null) goto L8;
        r14 = new String[0];
    L8:
        final String[] r17 = r14;
        boolean r18 = r23.getBooleanExtra("enableDim", true);
        boolean r19 = r23.getBooleanExtra("cancelable", true);
        boolean r110 = r23.getBooleanExtra("enableEnterAnim", false);
        final PrivacyConsentCallback r20 = (PrivacyConsentCallback) f17662j.get(r23.getStringExtra("PrivacyStatementActivityInstanceId"));
        List r21 = (List) f17666n.get(r23.getStringExtra("PrivacyStatementActivityInstanceId"));
        final List r22 = (List) f17665m.get(r23.getStringExtra("PrivacyStatementActivityInstanceId"));
        final LinkClickListener r24 = (LinkClickListener) f17663k.get(r23.getStringExtra("PrivacyStatementActivityInstanceId"));
        String r25 = V();
        if (r21 != null) goto L11;
        List r111 = t.i();
    L12:
        if (r13 != null) goto L15;
        String r26 = null;
    L14:
        String r112 = r26;
        if (r22 != null) goto L18;
        List r113 = t.i();
    L19:
        this.f17673h = new OPrivacySheet(this, new com.obric.oui.privacy.d(r25, r11, r12, r111, r112, r113, r15, r16, r18, r19, r110)).p(new PrivacyStatementActivity$showSheetDialog$1(r20, this, r22, r17, r24, r11)).q();
        return;
    L18:
        r113 = r22;
        goto L19
    L15:
        r26 = r13.toString();
        goto L14
    L11:
        r111 = r21;
        goto L12
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        PrivacyConsentCallback r10 = (PrivacyConsentCallback) f17662j.get(getIntent().getStringExtra("PrivacyStatementActivityInstanceId"));
        if (r10 != null) goto L6;
    L8:
        if (r10 == null) goto L11;
        r10.onCancel();
    L11:
        Z();
        return;
    L6:
        if (r10.onCancel(this) != true) goto L8;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        super.onContentChanged();
        this.f17672g = ((ViewGroup) findViewById(R.id.content)).getChildAt(0);
        if (W() == false) goto L9;
        View r10 = this.f17672g;
        if (r10 == null) goto L10;
        ViewCompat.C0(r10, new com.obric.oui.window.permission.a());
        return;
    L10:
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r10) {
        if (s().m() != 2) goto L5;
        boolean r11 = true;
    L7:
        if ((getResources().getConfiguration().uiMode & 48) != 32) goto L9;
        boolean r12 = true;
    L10:
        L.a("PrivacyStatementActivity", q.p("onCreate savedInstanceState: ", r10));
        L.a("PrivacyStatementActivity", q.p("onCreate delegate.localNightMode: ", Integer.valueOf(s().m())));
        L.a("PrivacyStatementActivity", q.p("onCreate isLocalInNightMode: ", Boolean.valueOf(r11)));
        L.a("PrivacyStatementActivity", q.p("onCreate isConfigNightMode: ", Boolean.valueOf(r12)));
        boolean r13 = getIntent().getBooleanExtra("forceNightMode", false);
        L.a("PrivacyStatementActivity", q.p("onCreate forceNightMode: ", Boolean.valueOf(r13)));
        if (r12 == true) goto L14;
        if (r13 == false) goto L14;
        boolean r14 = true;
    L15:
        if (r10 != null) goto L18;
        if (r13 == false) goto L18;
        getIntent().putExtra("forceNightMode", false);
        s().J(2);
    L18:
        super.onCreate(r10);
        if (r10 != null) goto L21;
    L24:
        getWindow().setWindowAnimations(0);
        overridePendingTransition(0, 0);
        String r15 = getIntent().getStringExtra("PrivacyStatementActivityInstanceId");
        if (r15 == null) goto L32;
        a.AbstractC0212a r16 = (a.AbstractC0212a) f17664l.get(r15);
        if (r16 == null) goto L32;
        r16.b(this);
    L32:
        if (T() == false) goto L39;
        if (r10 == null) goto L39;
        L.j("PrivacyStatementActivity", "onCreate, savedInstanceState is not null");
        if (((PrivacyConsentCallback) f17662j.get(getIntent().getStringExtra("PrivacyStatementActivityInstanceId"))) != null) goto L38;
        L.j("PrivacyStatementActivity", "privacyConsentCallbacks is null, finish");
        finish();
        return;
    L38:
        L.e("PrivacyStatementActivity", "privacyConsentCallbacks is not null");
    L39:
        Window r17 = getWindow();
        r17.clearFlags(1024);
        r17.setBackgroundDrawableResource(R.color.transparent);
        r17.getAttributes().format = -2;
        this.f17669d = getIntent().getBooleanExtra("showNetworkConfirm", true);
        this.f17670e = getIntent().getBooleanExtra("useLinkTextAsTitle", false);
        this.f17671f = r17.getDecorView().getRootView();
        if (r14 == true) goto L43;
        Intent r18 = getIntent();
        q.f(r18, MemorySourceLinkType.INTENT);
        c0(r18);
        getIntent().putExtra("finishShowSheet", true);
        return;
    L43:
        return;
    L21:
        if (getIntent().getBooleanExtra("finishShowSheet", false) == false) goto L24;
        L.a("PrivacyStatementActivity", "onCreate -> finish when savedInstanceState is not null and finishShowSheet is true");
        finish();
        return;
    L14:
        r14 = false;
        goto L15
    L9:
        r12 = false;
        goto L10
    L5:
        r11 = false;
        goto L7
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        L.a("PrivacyStatementActivity", "onDestroy");
        View r10 = this.f17671f;
        if (r10 != null) goto L29;
    L8:
        View r11 = this.f17672g;
        if (r11 != null) goto L27;
    L14:
        OPrivacySheet r12 = this.f17673h;
        if (r12 == null) goto L18;
        r12.m();
    L18:
        this.f17671f = null;
        this.f17672g = null;
        this.f17673h = null;
        super.onDestroy();
        String r13 = getIntent().getStringExtra("PrivacyStatementActivityInstanceId");
        if (r13 == null) goto L31;
        Map r14 = f17664l;
        a.AbstractC0212a r15 = (a.AbstractC0212a) r14.get(r13);
        if (r15 == null) goto L25;
        r15.c(this);
    L25:
        a.AbstractC0212a r16 = (a.AbstractC0212a) r14.remove(r13);
        return;
    L31:
        return;
    L27:
        ViewCompat.C0(r11, null);     // Catch: Exception -> L13
    L13:
        L.b("PrivacyStatementActivity", "removing contentChild WindowInsets listener failed");
        goto L14
    L29:
        r10.setOnApplyWindowInsetsListener(null);     // Catch: Exception -> L7
    L7:
        L.b("PrivacyStatementActivity", "removing root WindowInsets listener failed");
        goto L8
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        String r10 = getIntent().getStringExtra("PrivacyStatementActivityInstanceId");
        if (r10 == null) goto L10;
        a.AbstractC0212a r11 = (a.AbstractC0212a) f17664l.get(r10);
        if (r11 == null) goto L11;
        r11.d(this);
        return;
    L11:
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        String r10 = getIntent().getStringExtra("PrivacyStatementActivityInstanceId");
        if (r10 == null) goto L10;
        a.AbstractC0212a r11 = (a.AbstractC0212a) f17664l.get(r10);
        if (r11 == null) goto L11;
        r11.e(this);
        return;
    L11:
        return;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        String r10 = getIntent().getStringExtra("PrivacyStatementActivityInstanceId");
        if (r10 == null) goto L10;
        a.AbstractC0212a r11 = (a.AbstractC0212a) f17664l.get(r10);
        if (r11 == null) goto L11;
        r11.f(this);
        return;
    L11:
        return;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        String r10 = getIntent().getStringExtra("PrivacyStatementActivityInstanceId");
        if (r10 == null) goto L10;
        a.AbstractC0212a r11 = (a.AbstractC0212a) f17664l.get(r10);
        if (r11 == null) goto L11;
        r11.g(this);
        return;
    L11:
        return;
    }
}

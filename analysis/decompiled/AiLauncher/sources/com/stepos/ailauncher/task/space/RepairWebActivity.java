package com.stepos.ailauncher.task.space;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.view.a0;
import b.AbstractC1417G;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.task.R$string;
import h8.C4148a;
import java.util.Locale;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import net.sqlcipher.database.SQLiteDatabase;
import z5.ActivityC6361a;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0015¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\n\u0010\u0003J\u0017\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u000f\u0010\u0003R\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/stepos/ailauncher/task/space/RepairWebActivity;", "Lz5/a;", "<init>", "()V", "LY8/t;", "w", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "", "baseUrl", "v", "(Ljava/lang/String;)Ljava/lang/String;", "z", "Lr6/c;", "binding", "Lr6/c;", "Companion", Const.INTENT_KEY_APIKEY, "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RepairWebActivity extends ActivityC6361a {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_TITLE_RES = "title_res";
    private static final String EXTRA_URL = "url";
    private static final String TAG = "AILauncher-RepairWeb";
    private r6.c binding;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ'\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/task/space/RepairWebActivity$a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "LY8/t;", "c", "(Landroid/content/Context;)V", Const.INTENT_KEY_PKGNAME, "", "titleRes", "", RepairWebActivity.EXTRA_URL, Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;ILjava/lang/String;)V", "TAG", "Ljava/lang/String;", "EXTRA_TITLE_RES", "EXTRA_URL", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.task.space.RepairWebActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final void a(Context context, int titleRes, String url) {
            Intent intentAddFlags = new Intent(context, (Class<?>) RepairWebActivity.class).putExtra(RepairWebActivity.EXTRA_TITLE_RES, titleRes).putExtra(RepairWebActivity.EXTRA_URL, url).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            kotlin.jvm.internal.p.h(intentAddFlags, "addFlags(...)");
            context.startActivity(intentAddFlags);
        }

        public final void b(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            a(context, R$string.repair_my_tasks_page_title, H5.a.INSTANCE.a(context).g());
        }

        public final void c(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            a(context, R$string.repair_subscription_page_title, H5.a.INSTANCE.a(context).v());
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/stepos/ailauncher/task/space/RepairWebActivity$b", "Lb/G;", "LY8/t;", "handleOnBackPressed", "()V", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends AbstractC1417G {
        public b() {
            super(true);
        }

        @Override // b.AbstractC1417G
        public void handleOnBackPressed() {
            r6.c cVar = RepairWebActivity.this.binding;
            r6.c cVar2 = null;
            if (cVar == null) {
                kotlin.jvm.internal.p.A("binding");
                cVar = null;
            }
            if (!cVar.webView.canGoBack()) {
                RepairWebActivity.this.finish();
                return;
            }
            r6.c cVar3 = RepairWebActivity.this.binding;
            if (cVar3 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                cVar2 = cVar3;
            }
            cVar2.webView.goBack();
        }
    }

    private final void w() {
        r6.c cVar = this.binding;
        if (cVar == null) {
            kotlin.jvm.internal.p.A("binding");
            cVar = null;
        }
        androidx.core.view.N.u0(cVar.root, new androidx.core.view.A() { // from class: com.stepos.ailauncher.task.space.p1
            @Override // androidx.core.view.A
            public final androidx.core.view.a0 a(View view, androidx.core.view.a0 a0Var) {
                return RepairWebActivity.x(view, a0Var);
            }
        });
    }

    public static final androidx.core.view.a0 x(View view, androidx.core.view.a0 insets) {
        kotlin.jvm.internal.p.i(view, "view");
        kotlin.jvm.internal.p.i(insets, "insets");
        t0.e eVarF = insets.f(a0.o.g());
        kotlin.jvm.internal.p.h(eVarF, "getInsets(...)");
        view.setPadding(0, eVarF.f41978b, 0, eVarF.f41980d);
        return insets;
    }

    public static final void y(RepairWebActivity repairWebActivity, View view) {
        repairWebActivity.finish();
    }

    @Override // androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    @SuppressLint({"SetJavaScriptEnabled"})
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        r6.c cVarB = r6.c.b(getLayoutInflater());
        kotlin.jvm.internal.p.h(cVarB, "inflate(...)");
        this.binding = cVarB;
        r6.c cVar = null;
        if (cVarB == null) {
            kotlin.jvm.internal.p.A("binding");
            cVarB = null;
        }
        setContentView(cVarB.root);
        r6.c cVar2 = this.binding;
        if (cVar2 == null) {
            kotlin.jvm.internal.p.A("binding");
            cVar2 = null;
        }
        cVar2.tvTitle.setText(getIntent().getIntExtra(EXTRA_TITLE_RES, R$string.repair_subscription_page_title));
        r6.c cVar3 = this.binding;
        if (cVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
            cVar3 = null;
        }
        cVar3.btnBack.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.space.o1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RepairWebActivity.y(this.f29080a, view);
            }
        });
        w();
        z();
        getOnBackPressedDispatcher().m(this, new b());
        String stringExtra = getIntent().getStringExtra(EXTRA_URL);
        if (stringExtra == null) {
            stringExtra = "";
        }
        if (La.H.x0(stringExtra)) {
            C4148a.u(TAG, "open without url, titleRes=" + getIntent().getIntExtra(EXTRA_TITLE_RES, 0), false, 4, null);
            return;
        }
        String strV = v(stringExtra);
        C4148a.k(TAG, "load h5 " + La.H.w1(stringExtra, '?', null, 2, null), false, 4, null);
        r6.c cVar4 = this.binding;
        if (cVar4 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            cVar = cVar4;
        }
        cVar.webView.loadUrl(strV);
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.r, android.app.Activity
    public void onDestroy() {
        r6.c cVar = this.binding;
        if (cVar != null) {
            if (cVar == null) {
                kotlin.jvm.internal.p.A("binding");
                cVar = null;
            }
            WebView webView = cVar.webView;
            kotlin.jvm.internal.p.h(webView, "webView");
            ViewParent parent = webView.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(webView);
            }
            webView.stopLoading();
            webView.setWebViewClient(new WebViewClient());
            webView.destroy();
        }
        super.onDestroy();
    }

    public final String v(String baseUrl) {
        Object objB;
        Object obj = "";
        try {
            Result.Companion companion = Result.INSTANCE;
            String strO = com.stepos.ailauncher.foundation.account.f.o(com.stepos.ailauncher.foundation.account.f.INSTANCE, false, null, 3, null);
            if (strO == null) {
                strO = "";
            }
            objB = Result.b(strO);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE == null) {
            obj = objB;
        } else {
            C4148a.t(TAG, "read access token failed", thE, false, 8, null);
        }
        String str = (String) obj;
        String str2 = Locale.getDefault().getLanguage() + "_" + Locale.getDefault().getCountry();
        return baseUrl + (La.H.f0(baseUrl, '?', false, 2, null) ? Const.STR_MART_ADD : "?") + "platform=android&access_token=" + str + "&uc_theme=dark&in_inverted_browser=false&lang=" + str2;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public final void z() {
        r6.c cVar = this.binding;
        r6.c cVar2 = null;
        if (cVar == null) {
            kotlin.jvm.internal.p.A("binding");
            cVar = null;
        }
        cVar.webView.setBackgroundColor(-16777216);
        r6.c cVar3 = this.binding;
        if (cVar3 == null) {
            kotlin.jvm.internal.p.A("binding");
            cVar3 = null;
        }
        cVar3.webView.getSettings().setJavaScriptEnabled(true);
        r6.c cVar4 = this.binding;
        if (cVar4 == null) {
            kotlin.jvm.internal.p.A("binding");
            cVar4 = null;
        }
        cVar4.webView.getSettings().setDomStorageEnabled(true);
        r6.c cVar5 = this.binding;
        if (cVar5 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            cVar2 = cVar5;
        }
        cVar2.webView.setWebViewClient(new WebViewClient());
    }
}

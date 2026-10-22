package com.stepos.ailauncher.chat.activity;

import Z8.C1173v;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Outline;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$drawable;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.ailauncher.chat.view.C2940q8;
import com.stepos.ailauncher.contract.api.express.IExpressService;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import z5.ActivityC6361a;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0006\u0018\u0000 ,2\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\u0003J\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0012\u0010\rJ\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010#\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020!2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b#\u0010$R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\n0%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R \u0010)\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e0(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R \u0010+\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00180(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010*¨\u0006."}, d2 = {"Lcom/stepos/ailauncher/chat/activity/SupportedAppsActivity;", "Lz5/a;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onCreate", "(Landroid/os/Bundle;)V", "onResume", "", "pkg", "D", "(Ljava/lang/String;)V", "Landroid/view/View;", "row", "x", "(Landroid/view/View;Ljava/lang/String;)V", ExifInterface.LONGITUDE_EAST, "", "B", "(Ljava/lang/String;)Ljava/lang/CharSequence;", "Landroid/widget/ImageView;", "view", "", "checked", "v", "(Landroid/widget/ImageView;Z)V", "icon", "", "dp", "w", "(Landroid/widget/ImageView;F)V", "Landroid/content/pm/PackageManager;", "pm", "C", "(Landroid/content/pm/PackageManager;Ljava/lang/String;)Z", "", "installing", "Ljava/util/Set;", "", "rows", "Ljava/util/Map;", "boundInstalled", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SupportedAppsActivity extends ActivityC6361a {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Set<String> installing = new LinkedHashSet();
    private final Map<String, View> rows = new LinkedHashMap();
    private final Map<String, Boolean> boundInstalled = new LinkedHashMap();

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/ailauncher/chat/activity/SupportedAppsActivity$a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/content/Intent;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)Landroid/content/Intent;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.activity.SupportedAppsActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final Intent a(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            return new Intent(context, (Class<?>) SupportedAppsActivity.class);
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/chat/activity/SupportedAppsActivity$b", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "LY8/t;", "getOutline", "(Landroid/view/View;Landroid/graphics/Outline;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends ViewOutlineProvider {
        final /* synthetic */ float $radiusPx;

        public b(float f10) {
            this.$radiusPx = f10;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            kotlin.jvm.internal.p.i(view, "view");
            kotlin.jvm.internal.p.i(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.$radiusPx);
        }
    }

    public static final void A(SupportedAppsActivity supportedAppsActivity, String str, View view) throws PackageManager.NameNotFoundException {
        supportedAppsActivity.E(str);
    }

    public static final void y(SupportedAppsActivity supportedAppsActivity, String str, View view) throws PackageManager.NameNotFoundException {
        supportedAppsActivity.E(str);
    }

    public static final void z(String str, SupportedAppsActivity supportedAppsActivity, ImageView imageView, View view) {
        com.stepos.ailauncher.chat.manager.U0 u02 = com.stepos.ailauncher.chat.manager.U0.INSTANCE;
        boolean z10 = !u02.n(str);
        u02.x(str, z10);
        kotlin.jvm.internal.p.f(imageView);
        supportedAppsActivity.v(imageView, z10);
    }

    public final CharSequence B(String pkg) {
        if (kotlin.jvm.internal.p.d(pkg, "com.xingin.xhs")) {
            String string = getString(R$string.express_app_name_xhs);
            kotlin.jvm.internal.p.h(string, "getString(...)");
            return string;
        }
        if (!kotlin.jvm.internal.p.d(pkg, "com.dianping.v1")) {
            return pkg;
        }
        String string2 = getString(R$string.express_app_name_dianping);
        kotlin.jvm.internal.p.h(string2, "getString(...)");
        return string2;
    }

    public final boolean C(PackageManager pm, String pkg) throws PackageManager.NameNotFoundException {
        try {
            pm.getApplicationInfo(pkg, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public final void D(String pkg) throws PackageManager.NameNotFoundException {
        View view = this.rows.get(pkg);
        if (view != null) {
            x(view, pkg);
        }
    }

    public final void E(String pkg) throws PackageManager.NameNotFoundException {
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + pkg)));
            this.installing.add(pkg);
            D(pkg);
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(this, R$string.express_market_not_found, 0).show();
        }
    }

    @Override // androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) throws PackageManager.NameNotFoundException {
        super.onCreate(savedInstanceState);
        setContentView(R$layout.activity_supported_apps);
        C2940q8.d(C2940q8.INSTANCE, this, R$string.supported_apps_title, null, 4, null);
        LinearLayout linearLayout = (LinearLayout) findViewById(R$id.supportedAppsCard);
        IExpressService iExpressService = (IExpressService) D5.a.INSTANCE.a(IExpressService.class);
        List<String> supportedPackages = iExpressService != null ? iExpressService.getSupportedPackages() : null;
        if (supportedPackages == null) {
            supportedPackages = C1173v.m();
        }
        int i10 = (int) (8 * getResources().getDisplayMetrics().density);
        int i11 = 0;
        for (Object obj : supportedPackages) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                C1173v.w();
            }
            String str = (String) obj;
            View viewInflate = LayoutInflater.from(this).inflate(R$layout.item_supported_app, (ViewGroup) linearLayout, false);
            kotlin.jvm.internal.p.f(viewInflate);
            x(viewInflate, str);
            viewInflate.setPadding(viewInflate.getPaddingLeft(), viewInflate.getPaddingTop() + (i11 == 0 ? i10 : 0), viewInflate.getPaddingRight(), viewInflate.getPaddingBottom() + (i11 == C1173v.o(supportedPackages) ? i10 : 0));
            this.rows.put(str, viewInflate);
            linearLayout.addView(viewInflate);
            i11 = i12;
        }
    }

    @Override // androidx.fragment.app.r, android.app.Activity
    public void onResume() throws PackageManager.NameNotFoundException {
        super.onResume();
        PackageManager packageManager = getPackageManager();
        for (String str : Z8.F.m1(this.rows.keySet())) {
            boolean zRemove = this.installing.remove(str);
            kotlin.jvm.internal.p.f(packageManager);
            boolean zC = C(packageManager, str);
            if (zRemove && zC) {
                com.stepos.ailauncher.chat.manager.U0.INSTANCE.t();
            }
            if (zRemove || !kotlin.jvm.internal.p.d(Boolean.valueOf(zC), this.boundInstalled.get(str))) {
                D(str);
            }
        }
    }

    public final void v(ImageView view, boolean checked) {
        view.setImageResource(checked ? R$drawable.ic_check_circle_on : R$drawable.ic_check_circle_off);
    }

    public final void w(ImageView icon, float dp) {
        float f10 = dp * getResources().getDisplayMetrics().density;
        icon.setClipToOutline(true);
        icon.setOutlineProvider(new b(f10));
    }

    public final void x(View row, final String pkg) throws PackageManager.NameNotFoundException {
        ApplicationInfo applicationInfo;
        PackageManager packageManager = getPackageManager();
        ImageView imageView = (ImageView) row.findViewById(R$id.appIcon);
        TextView textView = (TextView) row.findViewById(R$id.appName);
        final ImageView imageView2 = (ImageView) row.findViewById(R$id.appCheck);
        ProgressBar progressBar = (ProgressBar) row.findViewById(R$id.appLoading);
        try {
            applicationInfo = packageManager.getApplicationInfo(pkg, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            applicationInfo = null;
        }
        boolean z10 = applicationInfo != null;
        this.boundInstalled.put(pkg, Boolean.valueOf(z10));
        if (applicationInfo != null) {
            imageView.setImageDrawable(packageManager.getApplicationIcon(applicationInfo));
            textView.setText(packageManager.getApplicationLabel(applicationInfo));
        } else {
            imageView.setImageResource(R$drawable.ic_express_app_placeholder);
            textView.setText(B(pkg));
        }
        kotlin.jvm.internal.p.f(imageView);
        w(imageView, 5.0f);
        if (!z10 && this.installing.contains(pkg)) {
            progressBar.setVisibility(0);
            imageView2.setVisibility(8);
            row.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.activity.k2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws PackageManager.NameNotFoundException {
                    SupportedAppsActivity.y(this.f24841a, pkg, view);
                }
            });
        } else {
            if (!z10) {
                progressBar.setVisibility(8);
                imageView2.setVisibility(0);
                imageView2.setImageResource(R$drawable.ic_express_download);
                row.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.activity.m2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) throws PackageManager.NameNotFoundException {
                        SupportedAppsActivity.A(this.f24853a, pkg, view);
                    }
                });
                return;
            }
            progressBar.setVisibility(8);
            imageView2.setVisibility(0);
            kotlin.jvm.internal.p.f(imageView2);
            v(imageView2, com.stepos.ailauncher.chat.manager.U0.INSTANCE.n(pkg));
            row.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.activity.l2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SupportedAppsActivity.z(pkg, this, imageView2, view);
                }
            });
        }
    }
}

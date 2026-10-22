package com.stepos.ailauncher.oobe;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.LocaleList;
import android.view.Window;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import z5.ActivityC6361a;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0016\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0014X\u0094D¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/oobe/N;", "Lz5/a;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/content/Context;", "newBase", "attachBaseContext", "(Landroid/content/Context;)V", "", "preventScreenCapture", "Z", "s", "()Z", "Companion", Const.INTENT_KEY_APIKEY, "oobe_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public class N extends ActivityC6361a {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean preventScreenCapture = true;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/stepos/ailauncher/oobe/N$a;", "", "<init>", "()V", "Landroid/view/Window;", "window", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/view/Window;)V", "Landroid/content/Context;", "context", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;)Landroid/content/Context;", "oobe_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.oobe.N$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final void a(Window window) {
            kotlin.jvm.internal.p.i(window, "window");
            window.addFlags(com.stepos.agentframework.chatui.longtext.b.THRESHOLD);
        }

        public final Context b(Context context) {
            kotlin.jvm.internal.p.i(context, "context");
            Configuration configuration = new Configuration(context.getResources().getConfiguration());
            int i10 = configuration.uiMode;
            if ((i10 & 48) == 32) {
                return context;
            }
            configuration.uiMode = (i10 & (-49)) | 32;
            configuration.setLocales(LocaleList.getEmptyLocaleList());
            Context contextCreateConfigurationContext = context.createConfigurationContext(configuration);
            kotlin.jvm.internal.p.h(contextCreateConfigurationContext, "createConfigurationContext(...)");
            return contextCreateConfigurationContext;
        }

        public Companion() {
        }
    }

    @Override // z5.ActivityC6361a, androidx.appcompat.app.d, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context newBase) {
        kotlin.jvm.internal.p.i(newBase, "newBase");
        super.attachBaseContext(INSTANCE.b(newBase));
    }

    @Override // androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getPreventScreenCapture()) {
            Companion companion = INSTANCE;
            Window window = getWindow();
            kotlin.jvm.internal.p.h(window, "getWindow(...)");
            companion.a(window);
        }
    }

    /* renamed from: s, reason: from getter */
    public boolean getPreventScreenCapture() {
        return this.preventScreenCapture;
    }
}

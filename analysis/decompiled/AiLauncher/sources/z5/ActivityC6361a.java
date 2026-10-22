package z5;

import Y8.t;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.appcompat.app.d;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lz5/a;", "Landroidx/appcompat/app/d;", "<init>", "()V", "Landroid/content/Context;", "newBase", "LY8/t;", "attachBaseContext", "(Landroid/content/Context;)V", "Landroid/content/res/Resources;", "res", "r", "(Landroid/content/res/Resources;)V", "Companion", Const.INTENT_KEY_APIKEY, "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: z5.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class ActivityC6361a extends d {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final float MAX_FONT_SCALE = 1.18f;
    private static final String TAG = "AILauncher-FontCap";

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lz5/a$a;", "", "<init>", "()V", "Landroid/content/Context;", "base", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)Landroid/content/Context;", "", "TAG", "Ljava/lang/String;", "", "MAX_FONT_SCALE", "F", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: z5.a$a, reason: collision with other inner class name and from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final Context a(Context base) {
            p.i(base, "base");
            if (base.getResources().getConfiguration().fontScale <= 1.18f) {
                return base;
            }
            Context contextCreateConfigurationContext = base.createConfigurationContext(C6362b.INSTANCE.a(1.18f));
            p.h(contextCreateConfigurationContext, "createConfigurationContext(...)");
            return contextCreateConfigurationContext;
        }

        public Companion() {
        }
    }

    @Override // androidx.appcompat.app.d, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context newBase) {
        p.i(newBase, "newBase");
        float f10 = newBase.getResources().getConfiguration().fontScale;
        super.attachBaseContext(INSTANCE.a(newBase));
        Resources resources = getResources();
        p.h(resources, "getResources(...)");
        r(resources);
        try {
            Result.Companion companion = Result.INSTANCE;
            Resources resources2 = getApplicationContext().getResources();
            p.h(resources2, "getResources(...)");
            r(resources2);
            Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        if (f10 > 1.18f) {
            Log.i(TAG, "[FontCap] " + getClass().getSimpleName() + " capped " + f10 + " -> " + getResources().getConfiguration().fontScale + " (sd=" + getResources().getDisplayMetrics().scaledDensity + ")");
        }
    }

    public final void r(Resources res) {
        DisplayMetrics displayMetrics = res.getDisplayMetrics();
        float f10 = displayMetrics.density * res.getConfiguration().fontScale;
        if (displayMetrics.scaledDensity == f10) {
            return;
        }
        displayMetrics.scaledDensity = f10;
    }
}

package O6;

import android.annotation.SuppressLint;
import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\f\u0010\u000b¨\u0006\r"}, d2 = {"LO6/b;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "c", "(Landroid/content/Context;)Z", "", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)I", Const.INTENT_KEY_PKGNAME, "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class b {
    public static final b INSTANCE = new b();

    @SuppressLint({"DiscouragedApi", "InternalInsetResource"})
    public final int a(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        int identifier = context.getResources().getIdentifier("navigation_bar_height", "dimen", UxipConstants.f30662a);
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    @SuppressLint({"InternalInsetResource", "DiscouragedApi"})
    public final int b(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", UxipConstants.f30662a);
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public final boolean c(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        return a(context) > 0;
    }
}

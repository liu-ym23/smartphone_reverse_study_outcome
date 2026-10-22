package v5;

import android.content.Context;
import android.util.TypedValue;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lv5/a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "dp", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;I)I", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: v5.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C5659a {
    public static final C5659a INSTANCE = new C5659a();

    public final int a(Context context, int dp) {
        p.i(context, "context");
        return (int) TypedValue.applyDimension(1, dp, context.getResources().getDisplayMetrics());
    }
}

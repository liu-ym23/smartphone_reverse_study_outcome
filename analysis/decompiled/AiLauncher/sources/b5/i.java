package b5;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lb5/i;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;Landroid/content/Intent;)V", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class i {
    public static final i INSTANCE = new i();

    public final void a(Context context, Intent intent) {
        p.i(context, "context");
        p.i(intent, "intent");
        if (!(context instanceof Activity)) {
            intent.addFlags(268468224);
        }
        context.startActivity(intent);
    }
}

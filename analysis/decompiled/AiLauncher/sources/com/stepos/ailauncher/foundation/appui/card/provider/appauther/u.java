package com.stepos.ailauncher.foundation.appui.card.provider.appauther;

import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/u;", "", "<init>", "()V", "Landroid/view/View;", "hostRoot", "", Const.INTENT_KEY_PKGNAME, "(Landroid/view/View;)Z", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/view/View;)V", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class u {
    public static final u INSTANCE = new u();

    public static final void a(View hostRoot) {
        if (hostRoot == null) {
            return;
        }
        S.INSTANCE.v(hostRoot);
    }

    public static final boolean b(View hostRoot) {
        if (hostRoot == null) {
            return false;
        }
        return S.INSTANCE.E(hostRoot);
    }
}

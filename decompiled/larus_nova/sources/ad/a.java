package ad;

import android.app.Dialog;
import com.bytedance.android.btm.api.BtmPageLifecycle;
import com.bytedance.android.btm.api.BtmSDK;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f2930a = 0;

    static {
    }

    public static void b(Dialog r100) {
        BtmSDK r101 = BtmSDK.INSTANCE;
        r101.getPageLifecycle().c(r100, BtmPageLifecycle.State.RESUMED);
        r101.getPageLifecycle().g(r100, null, null);
    }

    public static void a(Dialog r100, Boolean r101) {
        BtmSDK r102 = BtmSDK.INSTANCE;
        r102.getPageLifecycle().c(r100, BtmPageLifecycle.State.DESTROYED);
        BtmPageLifecycle.a.a(r102.getPageLifecycle(), r100, r101, 4);
        r102.getPageLifecycle().a(r100);
    }
}

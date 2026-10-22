package ai0;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.revenue.adventure.AdventureContext;
import com.bytedance.android.live.liveinteract.revenue.adventure.AdventureState;
import com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.g;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.larus.nova.R;
import io.reactivex.disposables.CompositeDisposable;
import jc1.k;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f3721a = null;

    public c() {
    }

    static {
        f3721a = new c();
        new CompositeDisposable();
    }

    public final boolean c() {
        AdventureContext.Companion.getClass();
        return AdventureContext.a.a();
    }

    public final AdventureState a(DataCenter r100) {
        AdventureContext.Companion.getClass();
        IInteractService r101 = (IInteractService) k.f(IInteractService.class);
        if (r101 == null) goto L7;
        ih0.b r102 = r101.dynamicService(r100);
        if (r102 == null) goto L7;
        JsonObject r103 = r102.Nm();
    L8:
        if (r103 != null) goto L11;
        return null;
    L11:
        return (AdventureState) GsonProtectorUtils.fromJson(new Gson(), r103, AdventureState.class);
    L7:
        r103 = null;
        goto L8
    }

    public final boolean b(boolean r100) {
        com.bytedance.android.live.liveinteract.revenue.adventure.linkcore.a r101 = g.f77934a;
        if (g.f77939f == false) goto L7;
        if (r100 == false) goto L7;
        f2.b(R.string.ttlive_link_adventure_intercept_multi_link_toast, 0);
    L7:
        return g.f77939f;
    }

    public static void d(TextView r100, String r101) {
        r100.setTextColor(Color.parseColor(CustomHeaderConfig.COLOR_LIGHT));     // Catch: Exception -> L5
    L15:
        int r102 = Color.parseColor(r101);     // Catch: Exception -> L11
        Drawable r103 = r100.getBackground();     // Catch: Exception -> L11
        if (r103 == null) goto L9;
        r103.setColorFilter(r102, PorterDuff.Mode.SRC);     // Catch: Exception -> L11
    L9:
        r100.setBackground(r103);     // Catch: Exception -> L11
        return;
    L11:
        ALogger.i("AdventureOutService", "text background color parse error: ".concat(r101));
        return;
    L5:
        ALogger.i("AdventureOutService", "text color parse error: #FFFFFF");
        goto L15
    }
}

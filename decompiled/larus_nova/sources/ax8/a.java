package ax8;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.applog.api.IApplog;
import com.larus.caijing_pay.impl.config.CJHostRouterServiceImpl;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class a {
    public static final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uniqueTag");
        return "Caijing-Pay-" + r100;
    }

    public static final String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "originSchema");
        Uri r101 = UriProtector.parse(r100);
        if (Intrinsics.areEqual(UriProtector.getQueryParameter(r101, CJHostRouterServiceImpl.URI_KEY_MIX_CONTAINER_TYPE), "anniex") == true) goto L11;
        if (Intrinsics.areEqual(UriProtector.getQueryParameter(r101, CJHostRouterServiceImpl.URI_KEY_USE_ANNIEX), "1") == true) goto L11;
        Intrinsics.checkNotNullParameter(r100, "url");
        IApplog r102 = (IApplog) ServiceManager.get().getService(IApplog.class);
        if (r102 == null) goto L9;
        JSONObject r103 = new JSONObject();
        r103.put("scheme", r100);
        Unit r104 = Unit.INSTANCE;
        r102.reportEvent("cj_fe_scheme_error", r103);
    L9:
        r101 = r101.buildUpon().appendQueryParameter(CJHostRouterServiceImpl.URI_KEY_MIX_CONTAINER_TYPE, "anniex").build();
    L11:
        return r101.toString();
    }
}

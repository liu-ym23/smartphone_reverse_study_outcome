package com.stepos.ailauncher.foundation.appui.card.provider.amap;

import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.Gson;
import com.stepos.ailauncher.contract.api.amap.IPoiDetailPageProvider;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u001d\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006\"\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroid/content/Context;", "context", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/N;", "item", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/N;)V", "", "TAG", "Ljava/lang/String;", "foundation_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class V {
    private static final String TAG = "PoiDetailSheet";

    public static final void a(Context context, PoiDetailCardItem item) {
        Object objB;
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(item, "item");
        IPoiDetailPageProvider iPoiDetailPageProvider = (IPoiDetailPageProvider) D5.a.INSTANCE.a(IPoiDetailPageProvider.class);
        if (iPoiDetailPageProvider == null) {
            C4148a.u(TAG, "IPoiDetailPageProvider not registered", false, 4, null);
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(new Gson().toJson(item));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        String str = (String) objB;
        if (str == null || La.H.x0(str)) {
            C4148a.u(TAG, "serialize PoiDetailCardItem failed", false, 4, null);
            return;
        }
        C4148a.k(TAG, "open poiId=" + item.getPoiId() + " name=" + item.getName(), false, 4, null);
        iPoiDetailPageProvider.open(context, str);
    }
}

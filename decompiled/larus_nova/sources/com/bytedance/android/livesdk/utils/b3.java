package com.bytedance.android.livesdk.utils;

import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class b3 {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, String> f158889a;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.utils.b3$a$a, reason: collision with other inner class name */
        public static final class C2430a {
        }

        static {
        }

        public a() {
            this.f158889a = new HashMap();
        }
    }

    static {
    }

    @JvmStatic
    public static final void a(DataCenter r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r101, "adExtra");
        if (r100 != null) goto L5;
        return;
    L5:
        boolean r102 = c1.d(r100);
        Intrinsics.checkNotNullParameter("click", "eventLabel");
        Intrinsics.checkNotNullParameter(r101, "adExtra");
        if (r102 == false) goto L13;
        ILiveDouPlusService r103 = (ILiveDouPlusService) jc1.k.n(ILiveDouPlusService.class);
        a r104 = new a();
        Map<String, String> r105 = r104.f158889a;
        HashMap r106 = (HashMap) r105;
        r106.put("ad_extra_data", r101.toString());
        Map<String, String> r107 = c1.f(r100);
        if (r107.isEmpty() == true) goto L11;
        ((HashMap) r104.f158889a).putAll(r107);
    L11:
        Intrinsics.checkNotNullParameter("refer", "key");
        Intrinsics.checkNotNullParameter("live_automatic", "value");
        ((HashMap) r104.f158889a).put("refer", "live_automatic");
        Unit r108 = Unit.INSTANCE;
        r103.logEvent(true, "live_ad", "click", r104.f158889a);
        return;
    }
}

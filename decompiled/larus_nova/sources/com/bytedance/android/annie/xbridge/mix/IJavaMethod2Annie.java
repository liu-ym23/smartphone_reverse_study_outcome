package com.bytedance.android.annie.xbridge.mix;

import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/annie/xbridge/mix/IJavaMethod2Annie;", "Lcom/bytedance/android/annie/xbridge/mix/BaseBridgeMethod;", "annie_release"}, k = 1, mv = {1, 4, 3})
public abstract class IJavaMethod2Annie extends BaseBridgeMethod {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public n56.c f40130c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f40131d;

    public abstract n56.c c(m16.b r100);

    @Override // com.bytedance.ies.bullet.core.kit.bridge.c, com.bytedance.ies.bullet.service.base.bridge.a
    public final boolean i90() {
        return this.f40131d;
    }

    public IJavaMethod2Annie(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "contextProviderFactory");
        super(r100);
        this.f40131d = true;
    }

    @Override // com.bytedance.android.annie.xbridge.mix.BaseBridgeMethod
    public final void b(JSONObject r100, BaseBridgeMethod.a r110) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r110, "iReturn");
        JSONObject r101 = new JSONObject();
        n56.f r102 = new n56.f();
        r102.f518032d = r100;
        r102.f518031c = getName();
        if (this.f40130c != null) goto L19;
        this.f40130c = c(this.f246545a);
    L19:
        n56.c r103 = this.f40130c;     // Catch: Exception -> L16
        Intrinsics.checkNotNull(r103);     // Catch: Exception -> L16
        r103.call(r102, r101);     // Catch: Exception -> L16
        this.f40131d = r102.f518038j;     // Catch: Exception -> L16
        h16.e r104 = (h16.e) this.f246545a.c(h16.e.class);     // Catch: Exception -> L16
        if (r104 == null) goto L10;
        com.bytedance.ies.bullet.service.base.o r105 = r104.getKitView();     // Catch: Exception -> L16
        if (r105 == null) goto L10;
        KitType r106 = r105.getKitType();     // Catch: Exception -> L16
    L12:
        if (r106 != KitType.LYNX) goto L14;
        Object r107 = r101.remove("code");     // Catch: Exception -> L16
        r101.remove("__data");     // Catch: Exception -> L16
        JSONObject r108 = new JSONObject();     // Catch: Exception -> L16
        r108.put("data", r101);     // Catch: Exception -> L16
        r108.put("__msg_type", "callback");     // Catch: Exception -> L16
        r108.put(com.heytap.mcssdk.constant.b.f276361k, CastLongProtector.parseLong(r101.optString("__callback_id", "0")));     // Catch: Exception -> L16
        r108.put("__callback_id", "0");     // Catch: Exception -> L16
        r108.put("code", r107);     // Catch: Exception -> L16
        r110.b(r108);     // Catch: Exception -> L16
        return;
    L14:
        r110.b(r101);     // Catch: Exception -> L16
        return;
    L10:
        r106 = null;
    L16:
        e = move-exception;
        r110.a("[IJavaMethod2Annie]： " + e.getMessage());
    }
}

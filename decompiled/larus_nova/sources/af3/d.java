package af3;

import com.bytedance.android.shopping.mall.homepage.component.ECMFPageCardComponent;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.android.common.lib.AppLogNewUtils;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f3150b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3151c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f3152d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f3153e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g f3154f;

    public final void a() {
        if (this.f3151c == false) goto L5;
        return;
    L5:
        this.f3151c = true;
        JSONObject r100 = new JSONObject();
        r100.put(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);
        r100.put("enter_from", this.f3154f.f3167b);
        r100.put("page_name", this.f3154f.f3166a);
        r100.put("is_open", this.f3149a);
        int r101 = 0;
        r100.put("is_reopen", false);
        r100.put("is_special_reopen", false);
        this.f3152d.b();
        r100.put("is_visible", false);
        r100.put("component", a.d(this.f3153e.f3144b, "component"));
        r101 = JSONObjectProtectorUtils.getInt(this.f3153e.f3144b, "plan_id");     // Catch: Exception -> L16
    L7:
        r100.put("plan_id", r101);
        JSONObject r102 = this.f3153e.f3144b.optJSONObject("track_extra");
        String r103 = "";
        if (r102 == null) goto L10;
        String r104 = r102.optString("interest", "");
    L11:
        if (r104 == null) goto L14;
        r103 = r104;
    L14:
        r100.put("interest", r103);
        r100.put("duration", System.currentTimeMillis() - this.f3154f.f3168c);
        r100.put("api_key", "marketing_resource_get");
        r100.put("break_reason", this.f3150b);
        r100.put("card_source", "native");
        r100.put("is_first_screen_finished", this.f3152d.a());
        Unit r105 = Unit.INSTANCE;
        AppLogNewUtils.onEventV3("mall_popup_result_stat", r100);
        return;
    L10:
        r104 = null;
        goto L11
    }

    public d(ECMFPageCardComponent.a r100, a r101, g r102) {
        Intrinsics.checkNotNullParameter(r100, "mallAbility");
        Intrinsics.checkNotNullParameter(r101, "apiDataHelper");
        Intrinsics.checkNotNullParameter(r102, "queryMapHelper");
        this.f3152d = r100;
        this.f3153e = r101;
        this.f3154f = r102;
        this.f3150b = "";
    }
}

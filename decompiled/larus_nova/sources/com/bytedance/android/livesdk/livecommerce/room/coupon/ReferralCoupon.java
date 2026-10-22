package com.bytedance.android.livesdk.livecommerce.room.coupon;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.nova.R;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class ReferralCoupon {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f151773a = 0;

    static {
    }

    public static void b(final com.bytedance.android.ec.adapter.api.state.a r100, final Context r101, final boolean r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r101 != null) goto L7;
        return;
    L7:
        if ((!Intrinsics.areEqual(r100.f42701p.get("pop_fission_coupon"), "true")) == false) goto L9;
        return;
    L9:
        Function0<Unit> r103 = new ReferralCoupon$handleBackFlow$1(r100, r101, r102);
        if (r100.a() == true) goto L12;
        Bundle r104 = new Bundle();
        r104.putString("enter_from", "live_detail");
        r104.putString("source", "live");
        int r105 = ge.b.f480992h;
        ge.b.a r106 = new ge.b.a();
        String r107 = th.a.g(r101, R.string.ec_login_dialog_message);
        Intrinsics.checkNotNullParameter(r107, "msg");
        r106.f481000a = r107;
        Intrinsics.checkNotNullParameter("live_detail", "enterFrom");
        r106.f481004e = "live_detail";
        Intrinsics.checkNotNullParameter("live", "source");
        r106.f481003d = "live";
        yj2.b.a(r101, new ge.b(r106), new e(r103));
        return;
    L12:
        r103.invoke();
    }

    public static Uri.Builder a(com.bytedance.android.ec.adapter.api.state.a r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "schema");
        Intrinsics.checkNotNullParameter(r102, "referralId");
        Uri.Builder r104 = UriProtector.parse(r101).buildUpon();
        String r105 = null;
        if (r100 == null) goto L5;
        String r106 = r100.f42691f;
    L6:
        String r107 = "";
        if (r106 != null) goto L9;
        r106 = "";
    L9:
        r104.appendQueryParameter("room_id", r106);
        if (r100 == null) goto L12;
        String r108 = r100.f42692g;
    L13:
        if (r108 != null) goto L15;
        r108 = "";
    L15:
        r104.appendQueryParameter("anchor_id", r108);
        r104.appendQueryParameter("item_id", r102);
        JSONObject r109 = new JSONObject();
        if (r100 == null) goto L20;
        Map<String, String> r110 = r100.f42698m;
        if (r110 == null) goto L20;
        String r111 = r110.get("enter_method");
    L21:
        if (r111 != null) goto L23;
        r111 = "";
    L23:
        r109.put("enter_method", r111);
        r109.put(com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE, "live");
        if (r100 == null) goto L28;
        Map<String, String> r112 = r100.f42698m;
        if (r112 == null) goto L28;
        r105 = r112.get("enter_from_merge");
    L28:
        if (r105 == null) goto L31;
        r107 = r105;
    L31:
        r109.put("enter_from_merge", r107);
        r109.put(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);
        if (r103 == null) goto L34;
        r109.put(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM, r103);
    L34:
        Unit r113 = Unit.INSTANCE;
        r104.appendQueryParameter("log_data", r109.toString());
        return r104;
    L20:
        r111 = null;
        goto L21
    L12:
        r108 = null;
        goto L13
    L5:
        r106 = null;
        goto L6
    }
}

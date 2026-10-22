package com.obric.autoaction.app.launcherpage.api.b;

import android.app.Application;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.capabilitykit.apphost.AppHost;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.m;
import d.s;
import java.util.Map;

/* JADX INFO: compiled from: SmSCategoryNames.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f22885a = null;

    static {
        f22885a = new a();
    }

    private a() {
    }

    public final Map<String, String> a() {
        return ao.a(new m[]{s.a("otp_code", ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_sms_category_otp_code, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_sms_category_otp_code"))), s.a("parcel_pickup", ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_sms_category_parcel_pickup, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_sms_category_parcel_pickup"))), s.a("repay_due", ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_sms_category_repay_due, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_sms_category_repay_due"))), s.a("balance_tx", ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_sms_category_balance_tx, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_sms_category_balance_tx"))), s.a("flight_status", ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_sms_category_flight_status, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_sms_category_flight_status"))), s.a("flight_booking", ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_sms_category_flight_booking, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_sms_category_flight_booking"))), s.a("hotel_booking", ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_sms_category_hotel_booking, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_sms_category_hotel_booking"))), s.a("logistics_status", ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_sms_category_logistics_status, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_sms_category_logistics_status"))), s.a("ride_hailing_status", ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_sms_category_ride_hailing_status, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_sms_category_ride_hailing_status"))), s.a("calendar_reminder", ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_sms_category_calendar_reminder, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_sms_category_calendar_reminder"))), s.a("missed_call", ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_sms_category_missed_call, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_sms_category_missed_call"))), s.a("payment_failed", ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_sms_category_payment_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_sms_category_payment_failed"))), s.a("account_security", ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppHost.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_sms_category_account_security, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_sms_category_account_security")))});
    }
}

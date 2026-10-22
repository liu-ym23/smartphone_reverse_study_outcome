package com.obric.agent.card.weather;

import android.content.Context;
import android.net.Uri;
import android.widget.RemoteViews;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.autogui.common.api.assistant.IAssistCardResourceProvider;
import com.obric.capabilitykit.common.intent.WeatherShowParams;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: compiled from: SingleDateWeatherInfoCardProvider.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d extends com.obric.aiagent.assistant_card.provider_core.a {
    private static final String TAG = "SingleDateWeatherInfoCardProvider";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14274a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final IAssistCardResourceProvider f14275b;

    /* JADX INFO: compiled from: SingleDateWeatherInfoCardProvider.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: SingleDateWeatherInfoCardProvider.kt */
    @d.c.b.a.f(b = "SingleDateWeatherInfoCardProvider.kt", c = {166}, d = "onActionTriggered", e = "com.obric.agent.card.weather.SingleDateWeatherInfoCardProvider")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f14276a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f14277b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f14278c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f14279d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f14280e;

        b(d r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14279d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.f14278c = r7;
            this.f14280e |= Integer.MIN_VALUE;
            return this.f14279d.a(null, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f14274a = new a(null);
    }

    /* JADX INFO: renamed from: lambda$IR2UO-LF3AfF0peDCJ6WbqhbXBE, reason: not valid java name */
    public static /* synthetic */ x m68lambda$IR2UOLF3AfF0peDCJ6WbqhbXBE(SingleDateWeatherInfoCardData r0, d r1, Context r2, RemoteViews r3) {
        return a(r0, r1, r2, r3);
    }

    public static /* synthetic */ x lambda$w5GDHGoHingET5V89zTrlwYg6_A(d r0, Context r1, SingleDateWeatherInfoCardData r2, RemoteViews r3) {
        return a(r0, r1, r2, r3);
    }

    public d(String r3) {
        o.e(r3, "cardType");
        super(r3);
        Object r4 = ServiceManager.get().getService(IAssistCardResourceProvider.class);
        o.a(r4);
        this.f14275b = (IAssistCardResourceProvider) ZeusTransformUtils.preCheckCast(r4, IAssistCardResourceProvider.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant_card.provider_core.a
    public com.obric.aiagent.assistant_card.provider_core.bean.c a(Context r4, Uri r5, JSONObject r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        o.e(r5, "cardUri");
        ILogDepend.Companion.d(TAG, "getCard: " + r5);
        String r8 = r5.getQueryParameter("data");
        if (r8 != null) goto L6;
        ILogDepend.Companion.e(TAG, "cardDataJson is null");
        return null;
    L6:
        SingleDateWeatherInfoCardData r9 = (SingleDateWeatherInfoCardData) ZeusTransformUtils.preCheckCast(com.obric.capabilitykit.common.a.a().fromJson(r8, SingleDateWeatherInfoCardData.class), SingleDateWeatherInfoCardData.class, "com.obric.aiagent.plugin");
        if (r9.isToday() == false) goto L9;
        o.a(r9);
        return b(r7, r9);
    L9:
        o.a(r9);
        return a(r7, r9);
    }

    private final com.obric.aiagent.assistant_card.provider_core.bean.c a(Context r5, final SingleDateWeatherInfoCardData r6) {
        final Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.assistant_card.provider_core.bean.c.f16369a.a(r7, this.f14275b.getResId(r7, "layout_intent_card_other_day_weather_info", "layout")).a().a(new $$Lambda$d$IR2UOLF3AfF0peDCJ6WbqhbXBE(r6, this, r7)).a(this.f14275b.getResId(r7, "intent_card_container", DbHelper.COL_ID), "click_card", null).b();
    }

    private static final x a(SingleDateWeatherInfoCardData r12, d r13, Context r14, RemoteViews r15) {
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r14, Context.class, "com.obric.aiagent.plugin");
        o.e(r15, "$this$configDisplay");
        if (r12.isToday() == false) goto L5;
        r15.setTextViewText(r13.f14275b.getResId(r16, "time", DbHelper.COL_ID), (CharSequence) ZeusTransformUtils.preCheckCast(r12.getTimeStr(), CharSequence.class, "com.obric.aiagent.plugin"));
        r15.setTextViewText(r13.f14275b.getResId(r16, "temp_range", DbHelper.COL_ID), (CharSequence) ZeusTransformUtils.preCheckCast(r12.getTemp() + 176, CharSequence.class, "com.obric.aiagent.plugin"));
        r15.setTextViewText(r13.f14275b.getResId(r16, "temp", DbHelper.COL_ID), (CharSequence) ZeusTransformUtils.preCheckCast(r12.getLowTemp() + "° / " + r12.getHighTemp() + 176, CharSequence.class, "com.obric.aiagent.plugin"));
        r15.setViewVisibility(r13.f14275b.getResId(r16, "time", DbHelper.COL_ID), 0);
        r15.setViewVisibility(r13.f14275b.getResId(r16, "divider_between_weather_text_and_location", DbHelper.COL_ID), 0);
    L6:
        r15.setInt(r13.f14275b.getResId(r16, "intent_card_container", DbHelper.COL_ID), "setBackgroundResource", i.a(r16, r12.getBackgroundResName(), r12.getWeatherCode()));
        Integer r0 = i.a(r16, r12.getWeatherCode(), false);
        if (r0 == null) goto L9;
        r15.setImageViewResource(r13.f14275b.getResId(r16, "weather_icon", DbHelper.COL_ID), ((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.aiagent.plugin")).intValue());
    L9:
        int r1 = r13.f14275b.getResId(r16, "weather_text", DbHelper.COL_ID);
        String r2 = i.a(r16, r12.getWeatherCode());
        if (r2 != null) goto L12;
        r2 = "";
    L12:
        r15.setTextViewText(r1, (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"));
        r15.setTextViewText(r13.f14275b.getResId(r16, "location", DbHelper.COL_ID), (CharSequence) ZeusTransformUtils.preCheckCast(r12.getLocation(), CharSequence.class, "com.obric.aiagent.plugin"));
        return x.f38692a;
    L5:
        r15.setTextViewText(r13.f14275b.getResId(r16, "temp_range", DbHelper.COL_ID), (CharSequence) ZeusTransformUtils.preCheckCast(r12.getLowTemp() + "° / " + r12.getHighTemp() + 176, CharSequence.class, "com.obric.aiagent.plugin"));
        r15.setTextViewText(r13.f14275b.getResId(r16, "temp", DbHelper.COL_ID), (CharSequence) ZeusTransformUtils.preCheckCast(r12.getTimeStr(), CharSequence.class, "com.obric.aiagent.plugin"));
        r15.setViewVisibility(r13.f14275b.getResId(r16, "time", DbHelper.COL_ID), 8);
        r15.setViewVisibility(r13.f14275b.getResId(r16, "divider_between_weather_text_and_location", DbHelper.COL_ID), 8);
        goto L6
    }

    private final void a(Context r6, RemoteViews r7, int r8, int r9, SingleDateWeatherInfoCardData r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        if (r9 < r10.getHourForecastUIInfo().size()) goto L5;
        return;
    L5:
        HourForecastUIInfo r12 = (HourForecastUIInfo) ZeusTransformUtils.preCheckCast(r10.getHourForecastUIInfo().get(r9), HourForecastUIInfo.class, "com.obric.aiagent.plugin");
        int r13 = this.f14275b.getResId(r11, "hourly_time_" + r8, DbHelper.COL_ID);
        int r0 = this.f14275b.getResId(r11, "hourly_temp_" + r8, DbHelper.COL_ID);
        int r5 = this.f14275b.getResId(r11, "hourly_weather_icon_" + r8, DbHelper.COL_ID);
        r7.setTextViewText(r13, (CharSequence) ZeusTransformUtils.preCheckCast(r12.getTimeStr(), CharSequence.class, "com.obric.aiagent.plugin"));
        r7.setTextViewText(r0, (CharSequence) ZeusTransformUtils.preCheckCast(r12.getTemp() + 176, CharSequence.class, "com.obric.aiagent.plugin"));
        Integer r14 = i.a(r11, r12.getWeatherCode(), false);
        if (r14 == null) goto L9;
        r7.setImageViewResource(r5, ((Number) ZeusTransformUtils.preCheckCast(r14, Number.class, "com.obric.aiagent.plugin")).intValue());
        return;
    }

    private final com.obric.aiagent.assistant_card.provider_core.bean.c b(Context r5, final SingleDateWeatherInfoCardData r6) {
        final Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.assistant_card.provider_core.bean.c.f16369a.a(r7, this.f14275b.getResId(r7, "layout_intent_card_today_weather_info", "layout")).a().a(new $$Lambda$d$w5GDHGoHingET5V89zTrlwYg6_A(this, r7, r6)).a(this.f14275b.getResId(r7, "intent_card_container", DbHelper.COL_ID), "click_card", null).b();
    }

    private static final x a(d r8, Context r9, SingleDateWeatherInfoCardData r10, RemoteViews r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        o.e(r11, "$this$configDisplay");
        r11.setInt(r8.f14275b.getResId(r12, "intent_card_container", DbHelper.COL_ID), "setBackgroundResource", i.a(r12, r10.getBackgroundResName(), r10.getWeatherCode()));
        r11.setTextViewText(r8.f14275b.getResId(r12, "temp_range", DbHelper.COL_ID), (CharSequence) ZeusTransformUtils.preCheckCast(r10.getTemp() + 176, CharSequence.class, "com.obric.aiagent.plugin"));
        r11.setTextViewText(r8.f14275b.getResId(r12, "temp", DbHelper.COL_ID), (CharSequence) ZeusTransformUtils.preCheckCast(r10.getLowTemp() + "° / " + r10.getHighTemp() + 176, CharSequence.class, "com.obric.aiagent.plugin"));
        Integer r0 = i.a(r12, r10.getWeatherCode(), false);
        if (r0 == null) goto L5;
        r11.setImageViewResource(r8.f14275b.getResId(r12, "weather_icon", DbHelper.COL_ID), ((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.aiagent.plugin")).intValue());
    L5:
        int r1 = r8.f14275b.getResId(r12, "weather_text", DbHelper.COL_ID);
        String r2 = i.a(r12, r10.getWeatherCode());
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        r11.setTextViewText(r1, (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"));
        r11.setTextViewText(r8.f14275b.getResId(r12, "location", DbHelper.COL_ID), (CharSequence) ZeusTransformUtils.preCheckCast(r10.getLocation(), CharSequence.class, "com.obric.aiagent.plugin"));
        r11.setTextViewText(r8.f14275b.getResId(r12, "time", DbHelper.COL_ID), (CharSequence) ZeusTransformUtils.preCheckCast(r10.getTimeStr(), CharSequence.class, "com.obric.aiagent.plugin"));
        int r3 = 1;
    L9:
        if (r3 >= 7) goto L12;
        r8.a(r12, r11, r3 - 1, r3, r10);
        r3 = r3 + 1;
        goto L9
    L12:
        return x.f38692a;
    }

    @Override // com.obric.aiagent.assistant_card.provider_core.a
    public Object a(Context r9, Uri r10, String r11, JSONObject r12, d.c.d<? super x> r13) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r14, b.class) == false) goto L7;
        b r15 = (b) ZeusTransformUtils.preCheckCast(r14, b.class, "com.obric.aiagent.plugin");
        if ((r15.f14280e & Integer.MIN_VALUE) == 0) goto L7;
        r15.f14280e -= Integer.MIN_VALUE;
    L8:
        b r7 = r15;
        Object r16 = r7.f14278c;
        Object r17 = d.c.a.b.a();
        int r0 = r7.f14280e;
        if (r0 == 0) goto L14;
        if (r0 != 1) goto L13;
        r11 = (String) ZeusTransformUtils.preCheckCast(r7.f14277b, String.class, "com.obric.aiagent.plugin");
        r10 = (Uri) ZeusTransformUtils.preCheckCast(r7.f14276a, Uri.class, "com.obric.aiagent.plugin");
        d.o.a(r16);
    L17:
        ILogDepend.Companion.d(TAG, "onActionTriggered cardUri: " + r10);
        if (o.a(r11, "click_card") == false) goto L25;
        ILogDepend.Companion.d(TAG, "onActionTriggered: click_card");
        String r8 = r10.getQueryParameter("data");
        if (r8 != null) goto L23;
        ILogDepend.Companion.e(TAG, "cardDataJson is null");
        return x.f38692a;
    L23:
        com.obric.agent.utils.b.f15994a.a("Weather_Show", com.obric.agent.utils.b.f15994a.a(new WeatherShowParams(((SingleDateWeatherInfoCardData) ZeusTransformUtils.preCheckCast(com.obric.capabilitykit.common.a.a().fromJson(r8, SingleDateWeatherInfoCardData.class), SingleDateWeatherInfoCardData.class, "com.obric.aiagent.plugin")).getLocation(), "WEATHER")), null, UUID.randomUUID().toString().hashCode() & Integer.MAX_VALUE);
    L25:
        return x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r16);
        r7.f14276a = r10;
        r7.f14277b = r11;
        r7.f14280e = 1;
        if (super.a(r3, r10, r11, r12, r7) != r17) goto L17;
        return r17;
    L7:
        r15 = new b(this, r14);
        goto L8
    }
}

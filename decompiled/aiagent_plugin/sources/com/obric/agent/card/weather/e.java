package com.obric.agent.card.weather;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.widget.RemoteViews;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.assistant.IAssistCardResourceProvider;
import com.obric.capabilitykit.common.intent.WeatherShowParams;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: compiled from: SunRiseSetCardProvider.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class e extends com.obric.aiagent.assistant_card.provider_core.a {
    private static final String TAG = "SunRiseSetCardProvider";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14281a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final IAssistCardResourceProvider f14282b;

    /* JADX INFO: compiled from: SunRiseSetCardProvider.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: SunRiseSetCardProvider.kt */
    @d.c.b.a.f(b = "SunRiseSetCardProvider.kt", c = {148}, d = "onActionTriggered", e = "com.obric.agent.card.weather.SunRiseSetCardProvider")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f14283a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f14284b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f14285c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ e f14286d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f14287e;

        b(e r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14286d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.f14285c = r7;
            this.f14287e |= Integer.MIN_VALUE;
            return this.f14286d.a(null, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f14281a = new a(null);
    }

    /* JADX INFO: renamed from: lambda$u4OUSXYCx1mye9GeWpGt-EJPwio, reason: not valid java name */
    public static /* synthetic */ x m69lambda$u4OUSXYCx1mye9GeWpGtEJPwio(boolean r0, e r1, Context r2, SunRiseSetCardData r3, RemoteViews r4) {
        return a(r0, r1, r2, r3, r4);
    }

    public e(String r3) {
        o.e(r3, "cardType");
        super(r3);
        Object r4 = ServiceManager.get().getService(IAssistCardResourceProvider.class);
        o.a(r4);
        this.f14282b = (IAssistCardResourceProvider) ZeusTransformUtils.preCheckCast(r4, IAssistCardResourceProvider.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant_card.provider_core.a
    public com.obric.aiagent.assistant_card.provider_core.bean.c a(Context r5, Uri r6, JSONObject r7, final boolean r8) {
        final Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        o.e(r9, "context");
        o.e(r6, "cardUri");
        ILogDepend.Companion.d(TAG, "getCard: " + r6);
        String r10 = r6.getQueryParameter("data");
        if (r10 != null) goto L6;
        ILogDepend.Companion.e(TAG, "cardDataJson is null");
        return null;
    L6:
        final SunRiseSetCardData r11 = (SunRiseSetCardData) ZeusTransformUtils.preCheckCast(com.obric.capabilitykit.common.a.a().fromJson(r10, SunRiseSetCardData.class), SunRiseSetCardData.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.assistant_card.provider_core.bean.c.f16369a.a(r9, this.f14282b.getResId(r9, "layout_intent_card_sun_rise_set", "layout")).a().a(new $$Lambda$e$u4OUSXYCx1mye9GeWpGtEJPwio(r8, this, r9, r11)).a(this.f14282b.getResId(r9, "intent_card_container", DbHelper.COL_ID), "click_card", null).b();
    }

    private static final x a(boolean r22, e r23, Context r24, SunRiseSetCardData r25, RemoteViews r26) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r24, Context.class, "com.obric.aiagent.plugin");
        o.e(r26, "$this$configDisplay");
        if (r22 == false) goto L5;
        r26.setInt(r23.f14282b.getResId(r2, "intent_card_container", DbHelper.COL_ID), "setBackgroundResource", r23.f14282b.getResId(r2, "intent_card_bg_dark", "drawable"));
        r26.setInt(r23.f14282b.getResId(r2, "divider", DbHelper.COL_ID), "setBackgroundColor", Color.parseColor("#14FFFFFF"));
        r26.setInt(r23.f14282b.getResId(r2, "sun_divider", DbHelper.COL_ID), "setBackgroundColor", Color.parseColor("#1FFFFFFF"));
        r26.setTextColor(r23.f14282b.getResId(r2, DBDefinition.TITLE, DbHelper.COL_ID), Color.parseColor("#FFCCCCCC"));
        r26.setTextColor(r23.f14282b.getResId(r2, "sub_info", DbHelper.COL_ID), Color.parseColor("#FF777777"));
        r26.setTextColor(r23.f14282b.getResId(r2, "sunrise_time", DbHelper.COL_ID), Color.parseColor("#FFFFFFFF"));
        r26.setTextColor(r23.f14282b.getResId(r2, "sunset_time", DbHelper.COL_ID), Color.parseColor("#FFFFFFFF"));
        r26.setTextColor(r23.f14282b.getResId(r2, "sunrise_label", DbHelper.COL_ID), Color.parseColor("#FF777777"));
        r26.setTextColor(r23.f14282b.getResId(r2, "sunset_label", DbHelper.COL_ID), Color.parseColor("#FF777777"));
        r26.setImageViewResource(r23.f14282b.getResId(r2, "sunrise_icon", DbHelper.COL_ID), r23.f14282b.getResId(r2, "intent_card_ic_sunrise_dark", "drawable"));
        r26.setImageViewResource(r23.f14282b.getResId(r2, "sunset_icon", DbHelper.COL_ID), r23.f14282b.getResId(r2, "intent_card_ic_sunset_dark", "drawable"));
        String r7 = "sunrise_label";
        String r8 = "sunset_label";
    L7:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r25.getDateDesc(), CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L12;
        String r4 = r25.getLocation() + 65372 + r25.getDateDesc();
    L13:
        r26.setTextViewText(r23.f14282b.getResId(r2, "sub_info", DbHelper.COL_ID), (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"));
        r26.setTextViewText(r23.f14282b.getResId(r2, "sunrise_time", DbHelper.COL_ID), (CharSequence) ZeusTransformUtils.preCheckCast(r25.getSunRise(), CharSequence.class, "com.obric.aiagent.plugin"));
        r26.setTextViewText(r23.f14282b.getResId(r2, "sunset_time", DbHelper.COL_ID), (CharSequence) ZeusTransformUtils.preCheckCast(r25.getSunSet(), CharSequence.class, "com.obric.aiagent.plugin"));
        r26.setTextViewText(r23.f14282b.getResId(r2, r7, DbHelper.COL_ID), (CharSequence) ZeusTransformUtils.preCheckCast(r2.getString(ZeusTransformUtils.mapRes(R.string.obric_weather_widget_sunrise, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_weather_widget_sunrise")), CharSequence.class, "com.obric.aiagent.plugin"));
        r26.setTextViewText(r23.f14282b.getResId(r2, r8, DbHelper.COL_ID), (CharSequence) ZeusTransformUtils.preCheckCast(r2.getString(ZeusTransformUtils.mapRes(R.string.obric_weather_widget_sunset, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_weather_widget_sunset")), CharSequence.class, "com.obric.aiagent.plugin"));
        return x.f38692a;
    L12:
        r4 = r25.getLocation();
        goto L13
    L9:
        r3 = false;
        goto L10
    L5:
        r26.setInt(r23.f14282b.getResId(r2, "intent_card_container", DbHelper.COL_ID), "setBackgroundResource", r23.f14282b.getResId(r2, "intent_card_bg_light", "drawable"));
        r26.setInt(r23.f14282b.getResId(r2, "divider", DbHelper.COL_ID), "setBackgroundColor", Color.parseColor("#0F000000"));
        r26.setInt(r23.f14282b.getResId(r2, "sun_divider", DbHelper.COL_ID), "setBackgroundColor", Color.parseColor("#1A000000"));
        r26.setTextColor(r23.f14282b.getResId(r2, DBDefinition.TITLE, DbHelper.COL_ID), Color.parseColor("#FF666666"));
        r26.setTextColor(r23.f14282b.getResId(r2, "sub_info", DbHelper.COL_ID), Color.parseColor("#FF999999"));
        r26.setTextColor(r23.f14282b.getResId(r2, "sunrise_time", DbHelper.COL_ID), Color.parseColor("#FF000000"));
        r26.setTextColor(r23.f14282b.getResId(r2, "sunset_time", DbHelper.COL_ID), Color.parseColor("#FF000000"));
        r7 = "sunrise_label";
        r26.setTextColor(r23.f14282b.getResId(r2, r7, DbHelper.COL_ID), Color.parseColor("#FF999999"));
        r8 = "sunset_label";
        r26.setTextColor(r23.f14282b.getResId(r2, r8, DbHelper.COL_ID), Color.parseColor("#FF999999"));
        r26.setImageViewResource(r23.f14282b.getResId(r2, "sunrise_icon", DbHelper.COL_ID), r23.f14282b.getResId(r2, "intent_card_ic_sunrise_light", "drawable"));
        r26.setImageViewResource(r23.f14282b.getResId(r2, "sunset_icon", DbHelper.COL_ID), r23.f14282b.getResId(r2, "intent_card_ic_sunset_light", "drawable"));
        goto L7
    }

    @Override // com.obric.aiagent.assistant_card.provider_core.a
    public Object a(Context r9, Uri r10, String r11, JSONObject r12, d.c.d<? super x> r13) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r14, b.class) == false) goto L7;
        b r15 = (b) ZeusTransformUtils.preCheckCast(r14, b.class, "com.obric.aiagent.plugin");
        if ((r15.f14287e & Integer.MIN_VALUE) == 0) goto L7;
        r15.f14287e -= Integer.MIN_VALUE;
    L8:
        b r7 = r15;
        Object r16 = r7.f14285c;
        Object r17 = d.c.a.b.a();
        int r0 = r7.f14287e;
        if (r0 == 0) goto L14;
        if (r0 != 1) goto L13;
        r11 = (String) ZeusTransformUtils.preCheckCast(r7.f14284b, String.class, "com.obric.aiagent.plugin");
        r10 = (Uri) ZeusTransformUtils.preCheckCast(r7.f14283a, Uri.class, "com.obric.aiagent.plugin");
        d.o.a(r16);
    L17:
        ILogDepend.Companion.d(TAG, "onActionTriggered cardUri: " + r10);
        if (o.a(r11, "click_card") == false) goto L25;
        ILogDepend.Companion.d(TAG, "onActionTriggered: click_card");
        String r8 = r10.getQueryParameter("data");
        if (r8 != null) goto L23;
        ILogDepend.Companion.e(TAG, "onActionTriggered cardDataJson is null");
        return x.f38692a;
    L23:
        SunRiseSetCardData r18 = (SunRiseSetCardData) ZeusTransformUtils.preCheckCast(com.obric.capabilitykit.common.a.a().fromJson(r8, SunRiseSetCardData.class), SunRiseSetCardData.class, "com.obric.aiagent.plugin");
        com.obric.agent.utils.b.f15994a.a("Weather_Show", com.obric.agent.utils.b.f15994a.a(new WeatherShowParams(r18.getLocation(), r18.getQueryType())), null, UUID.randomUUID().toString().hashCode() & Integer.MAX_VALUE);
    L25:
        return x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r16);
        r7.f14283a = r10;
        r7.f14284b = r11;
        r7.f14287e = 1;
        if (super.a(r3, r10, r11, r12, r7) != r17) goto L17;
        return r17;
    L7:
        r15 = new b(this, r14);
        goto L8
    }
}

package com.obric.agent.card.weather;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.TypedValue;
import android.widget.RemoteViews;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.autogui.common.api.assistant.IAssistCardResourceProvider;
import com.obric.capabilitykit.common.intent.WeatherShowParams;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import d.l.n;
import d.r;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: compiled from: MultiDateWeatherInfoCardProvider.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c extends com.obric.aiagent.assistant_card.provider_core.a {
    private static final String TAG = "MultiDateWeatherInfoCardProvider";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14267a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final IAssistCardResourceProvider f14268b;

    /* JADX INFO: compiled from: MultiDateWeatherInfoCardProvider.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: MultiDateWeatherInfoCardProvider.kt */
    @d.c.b.a.f(b = "MultiDateWeatherInfoCardProvider.kt", c = {259}, d = "onActionTriggered", e = "com.obric.agent.card.weather.MultiDateWeatherInfoCardProvider")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f14269a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f14270b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f14271c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f14272d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f14273e;

        b(c r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14272d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.f14271c = r7;
            this.f14273e |= Integer.MIN_VALUE;
            return this.f14272d.a(null, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f14267a = new a(null);
    }

    /* JADX INFO: renamed from: lambda$bj-DvhjSSSymxpYr8bRTstwndfo, reason: not valid java name */
    public static /* synthetic */ x m67lambda$bjDvhjSSSymxpYr8bRTstwndfo(c r0, Context r1, MultiDateWeatherInfoCardData r2, int r3, int r4, RemoteViews r5) {
        return a(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ x lambda$l2oI6CSHi1gTyJSQ53iaLulXdZU(c r0, Context r1, MultiDateWeatherInfoCardData r2, RemoteViews r3) {
        return a(r0, r1, r2, r3);
    }

    public c(String r3) {
        o.e(r3, "cardType");
        super(r3);
        Object r4 = ServiceManager.get().getService(IAssistCardResourceProvider.class);
        o.a(r4);
        this.f14268b = (IAssistCardResourceProvider) ZeusTransformUtils.preCheckCast(r4, IAssistCardResourceProvider.class, "com.obric.aiagent.plugin");
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
        MultiDateWeatherInfoCardData r9 = (MultiDateWeatherInfoCardData) ZeusTransformUtils.preCheckCast(com.obric.capabilitykit.common.a.a().fromJson(r8, MultiDateWeatherInfoCardData.class), MultiDateWeatherInfoCardData.class, "com.obric.aiagent.plugin");
        if (r9.getStyleType() != 1) goto L9;
        o.a(r9);
        return a(r7, r9);
    L9:
        o.a(r9);
        return b(r7, r9);
    }

    private final com.obric.aiagent.assistant_card.provider_core.bean.c a(Context r9, final MultiDateWeatherInfoCardData r10) {
        final Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        final int r5 = n.a(r10.getDatas().size(), 0, 15);
        final int r4 = 15;
        return com.obric.aiagent.assistant_card.provider_core.bean.c.f16369a.a(r11, this.f14268b.getResId(r11, "layout_intent_card_multi_weather_horizontal", "layout")).a().a(new $$Lambda$c$bjDvhjSSSymxpYr8bRTstwndfo(this, r11, r10, r4, r5)).a(this.f14268b.getResId(r11, "intent_card_container", DbHelper.COL_ID), "click_card", null).b(this.f14268b.getResId(r11, "horizontal_container", DbHelper.COL_ID)).a(50).b();
    }

    private static final x a(c r17, Context r18, MultiDateWeatherInfoCardData r19, int r20, int r21, RemoteViews r22) {
        c r0 = r17;
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r18, Context.class, "com.obric.aiagent.plugin");
        o.e(r22, "$this$configDisplay");
        r22.setTextViewText(r0.f14268b.getResId(r3, "location", DbHelper.COL_ID), (CharSequence) ZeusTransformUtils.preCheckCast(r19.getLocation(), CharSequence.class, "com.obric.aiagent.plugin"));
        int r5 = 0;
        int r8 = 0;
    L3:
        if (r8 >= r20) goto L51;
        int r9 = r0.f14268b.getResId(r3, "weather_info_item_" + r8, DbHelper.COL_ID);
        if (r8 < r21) goto L9;
        if (r9 == 0) goto L8;
        r22.setViewVisibility(r9, 8);
    L8:
        int r10 = r5;
    L49:
        r8 = r8 + 1;
        r0 = r17;
        r5 = r10;
        goto L3
    L9:
        MultiDateWeatherInfoSingleDayCardData r11 = (MultiDateWeatherInfoSingleDayCardData) ZeusTransformUtils.preCheckCast(r19.getDatas().get(r8), MultiDateWeatherInfoSingleDayCardData.class, "com.obric.aiagent.plugin");
        if (r9 == 0) goto L12;
        r22.setViewVisibility(r9, r5);
    L12:
        int r12 = r0.f14268b.getResId(r3, "single_weather_info_week_text_" + r8, DbHelper.COL_ID);
        int r13 = r0.f14268b.getResId(r3, "single_weather_info_date_text_" + r8, DbHelper.COL_ID);
        int r14 = r0.f14268b.getResId(r3, "single_weather_temp_lowest_" + r8, DbHelper.COL_ID);
        int r15 = r0.f14268b.getResId(r3, "single_weather_temp_highest_" + r8, DbHelper.COL_ID);
        int r6 = r0.f14268b.getResId(r3, "single_weather_info_icon_" + r8, DbHelper.COL_ID);
        int r7 = r0.f14268b.getResId(r3, "weather_start_margin_" + r8, DbHelper.COL_ID);
        int r16 = r0.f14268b.getResId(r3, "weather_end_margin_" + r8, DbHelper.COL_ID);
        int r1 = r0.f14268b.getResId(r3, "weather_divider_" + r8, DbHelper.COL_ID);
        int r2 = r0.f14268b.getResId(r3, "weather_margin_" + r8, DbHelper.COL_ID);
        if (r12 == 0) goto L15;
        r22.setTextViewText(r12, (CharSequence) ZeusTransformUtils.preCheckCast(r11.getWeekDay(), CharSequence.class, "com.obric.aiagent.plugin"));
    L15:
        if (r13 == 0) goto L18;
        r22.setTextViewText(r13, (CharSequence) ZeusTransformUtils.preCheckCast(r11.getTimeStr(), CharSequence.class, "com.obric.aiagent.plugin"));
    L18:
        if (r14 == 0) goto L20;
        r22.setTextViewText(r14, (CharSequence) ZeusTransformUtils.preCheckCast(r11.getLowTemp() + 176, CharSequence.class, "com.obric.aiagent.plugin"));
    L20:
        if (r15 == 0) goto L22;
        r22.setTextViewText(r15, (CharSequence) ZeusTransformUtils.preCheckCast(r11.getHighTemp() + 176, CharSequence.class, "com.obric.aiagent.plugin"));
    L22:
        if (r6 == 0) goto L26;
        r10 = 0;
        Integer r23 = i.a(r3, r11.getWeatherCode(), false);
        if (r23 == null) goto L27;
        r22.setImageViewResource(r6, ((Number) ZeusTransformUtils.preCheckCast(r23, Number.class, "com.obric.aiagent.plugin")).intValue());
    L27:
        if (r7 == 0) goto L30;
        r22.setViewVisibility(r7, r10);
    L30:
        if (r8 != (r21 - 1)) goto L32;
        int r24 = 1;
    L33:
        if (r16 == 0) goto L38;
        if (r24 == 0) goto L36;
        int r25 = 8;
    L37:
        r22.setViewVisibility(r16, r25);
    L39:
        if (r2 == 0) goto L44;
        if (r24 == 0) goto L42;
        int r4 = r10;
    L43:
        r22.setViewVisibility(r16, r4);
        goto L44
    L42:
        r4 = 8;
    L44:
        if (r1 == 0) goto L49;
        if (r24 == 0) goto L47;
        int r26 = 8;
    L48:
        r22.setViewVisibility(r1, r26);
        goto L49
    L47:
        r26 = r10;
        goto L48
    L36:
        r25 = r10;
        goto L37
    L38:
        r16 = r16;
        goto L39
    L32:
        r24 = r10;
        goto L33
    L26:
        r10 = 0;
        goto L27
    L51:
        return x.f38692a;
    }

    private final com.obric.aiagent.assistant_card.provider_core.bean.c b(Context r5, final MultiDateWeatherInfoCardData r6) {
        final Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.assistant_card.provider_core.bean.c.f16369a.a(r7, this.f14268b.getResId(r7, "layout_intent_card_mulit_date_weather_info", "layout")).a().a(new $$Lambda$c$l2oI6CSHi1gTyJSQ53iaLulXdZU(this, r7, r6)).a(this.f14268b.getResId(r7, "intent_card_container", DbHelper.COL_ID), "click_card", null).b();
    }

    private static final x a(c r9, Context r10, MultiDateWeatherInfoCardData r11, RemoteViews r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        o.e(r12, "$this$configDisplay");
        r12.setTextViewText(r9.f14268b.getResId(r13, "location", DbHelper.COL_ID), (CharSequence) ZeusTransformUtils.preCheckCast(r11.getLocation(), CharSequence.class, "com.obric.aiagent.plugin"));
        r<Integer, Integer, Float> r0 = r9.a(r11);
        int r1 = n.d(r11.getDatas().size(), 7);
        r12.setViewLayoutHeight(r9.f14268b.getResId(r13, "intent_card_container", DbHelper.COL_ID), TypedValue.applyDimension(1, (r1 * 40) + 84, Resources.getSystem().getDisplayMetrics()), 0);
        int r8 = 0;
    L3:
        if (r8 >= r1) goto L6;
        r9.a(r13, r12, r8, r11, r0);
        r8 = r8 + 1;
        goto L3
    L6:
        return x.f38692a;
    }

    private final r<Integer, Integer, Float> a(MultiDateWeatherInfoCardData r8) {
        List r9 = p.c((Iterable) ZeusTransformUtils.preCheckCast(r8.getDatas(), Iterable.class, "com.obric.aiagent.plugin"), n.d(r8.getDatas().size(), 7));
        float r1 = 0.0f;
        if (r9.isEmpty() == true) goto L5;
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r2 = r0.iterator();
    L8:
        if (r2.hasNext() == false) goto L12;
        Object r4 = r2.next();
        if (a((MultiDateWeatherInfoSingleDayCardData) ZeusTransformUtils.preCheckCast(r4, MultiDateWeatherInfoSingleDayCardData.class, "com.obric.aiagent.plugin")) == true) goto L8;
        r3.add(r4);
        goto L8
    L12:
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        if (r5.hasNext() == false) goto L49;
        Object r6 = r5.next();
        if (r5.hasNext() == false) goto L23;
        int r7 = Integer.parseInt(((MultiDateWeatherInfoSingleDayCardData) ZeusTransformUtils.preCheckCast(r6, MultiDateWeatherInfoSingleDayCardData.class, "com.obric.aiagent.plugin")).getLowTemp());
    L18:
        Object r10 = r5.next();
        int r11 = Integer.parseInt(((MultiDateWeatherInfoSingleDayCardData) ZeusTransformUtils.preCheckCast(r10, MultiDateWeatherInfoSingleDayCardData.class, "com.obric.aiagent.plugin")).getLowTemp());
        if (r7 <= r11) goto L22;
        r6 = r10;
        r7 = r11;
    L22:
        if (r5.hasNext() == true) goto L18;
    L23:
        int r12 = Integer.parseInt(((MultiDateWeatherInfoSingleDayCardData) ZeusTransformUtils.preCheckCast(r6, MultiDateWeatherInfoSingleDayCardData.class, "com.obric.aiagent.plugin")).getLowTemp());
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin");
        Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r15 = r13.iterator();
    L25:
        if (r15.hasNext() == false) goto L29;
        Object r16 = r15.next();
        if (a((MultiDateWeatherInfoSingleDayCardData) ZeusTransformUtils.preCheckCast(r16, MultiDateWeatherInfoSingleDayCardData.class, "com.obric.aiagent.plugin")) == true) goto L25;
        r14.add(r16);
        goto L25
    L29:
        Iterator r17 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        if (r17.hasNext() == false) goto L47;
        Object r18 = r17.next();
        if (r17.hasNext() == false) goto L40;
        int r19 = Integer.parseInt(((MultiDateWeatherInfoSingleDayCardData) ZeusTransformUtils.preCheckCast(r18, MultiDateWeatherInfoSingleDayCardData.class, "com.obric.aiagent.plugin")).getHighTemp());
    L35:
        Object r20 = r17.next();
        int r21 = Integer.parseInt(((MultiDateWeatherInfoSingleDayCardData) ZeusTransformUtils.preCheckCast(r20, MultiDateWeatherInfoSingleDayCardData.class, "com.obric.aiagent.plugin")).getHighTemp());
        if (r19 >= r21) goto L39;
        r18 = r20;
        r19 = r21;
    L39:
        if (r17.hasNext() == true) goto L35;
    L40:
        int r22 = Integer.parseInt(((MultiDateWeatherInfoSingleDayCardData) ZeusTransformUtils.preCheckCast(r18, MultiDateWeatherInfoSingleDayCardData.class, "com.obric.aiagent.plugin")).getHighTemp());
        float r23 = r22 - r12;
        if (r23 <= 0.0f) goto L45;
        r1 = r23;
    L45:
        return new r(Integer.valueOf(r12), Integer.valueOf(r22), Float.valueOf(r1));
    L47:
        throw new NoSuchElementException();
    L49:
        throw new NoSuchElementException();
    L5:
        return new r(0, 0, Float.valueOf(0.0f));
    }

    private final boolean a(MultiDateWeatherInfoSingleDayCardData r2) {
        if (Integer.parseInt(r2.getLowTemp()) != Integer.MAX_VALUE) goto L5;
    L8:
        return true;
    L5:
        if (Integer.parseInt(r2.getHighTemp()) == Integer.MAX_VALUE) goto L8;
        return false;
    }

    private final void a(Context r11, RemoteViews r12, int r13, MultiDateWeatherInfoCardData r14, r<Integer, Integer, Float> r15) {
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        if (r13 < r14.getDatas().size()) goto L5;
        return;
    L5:
        MultiDateWeatherInfoSingleDayCardData r17 = (MultiDateWeatherInfoSingleDayCardData) ZeusTransformUtils.preCheckCast(r14.getDatas().get(r13), MultiDateWeatherInfoSingleDayCardData.class, "com.obric.aiagent.plugin");
        int r0 = this.f14268b.getResId(r16, "single_date_weather_info_" + r13, DbHelper.COL_ID);
        int r2 = this.f14268b.getResId(r16, "single_date_week_" + r13, DbHelper.COL_ID);
        int r4 = this.f14268b.getResId(r16, "single_date_time_" + r13, DbHelper.COL_ID);
        int r5 = this.f14268b.getResId(r16, "single_date_weather_temp_highest_" + r13, DbHelper.COL_ID);
        int r8 = this.f14268b.getResId(r16, "single_date_weather_icon_" + r13, DbHelper.COL_ID);
        int r3 = this.f14268b.getResId(r16, "single_date_weather_temp_lowest_" + r13, DbHelper.COL_ID);
        r12.setViewVisibility(r0, 0);
        r12.setTextViewText(r2, (CharSequence) ZeusTransformUtils.preCheckCast(r17.getWeekDay(), CharSequence.class, "com.obric.aiagent.plugin"));
        r12.setTextViewText(r4, (CharSequence) ZeusTransformUtils.preCheckCast(r17.getTimeStr(), CharSequence.class, "com.obric.aiagent.plugin"));
        r12.setTextViewText(r5, (CharSequence) ZeusTransformUtils.preCheckCast(r17.getHighTemp() + 176, CharSequence.class, "com.obric.aiagent.plugin"));
        r12.setTextViewText(r3, (CharSequence) ZeusTransformUtils.preCheckCast(r17.getLowTemp() + 176, CharSequence.class, "com.obric.aiagent.plugin"));
        a(r16, r12, r13, r17, r15);
        Integer r10 = i.a(r16, r17.getWeatherCode(), false);
        if (r10 == null) goto L9;
        r12.setImageViewResource(r8, ((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.aiagent.plugin")).intValue());
        return;
    }

    @Override // com.obric.aiagent.assistant_card.provider_core.a
    public Object a(Context r9, Uri r10, String r11, JSONObject r12, d.c.d<? super x> r13) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r14, b.class) == false) goto L7;
        b r15 = (b) ZeusTransformUtils.preCheckCast(r14, b.class, "com.obric.aiagent.plugin");
        if ((r15.f14273e & Integer.MIN_VALUE) == 0) goto L7;
        r15.f14273e -= Integer.MIN_VALUE;
    L8:
        b r7 = r15;
        Object r16 = r7.f14271c;
        Object r17 = d.c.a.b.a();
        int r0 = r7.f14273e;
        if (r0 == 0) goto L14;
        if (r0 != 1) goto L13;
        r11 = (String) ZeusTransformUtils.preCheckCast(r7.f14270b, String.class, "com.obric.aiagent.plugin");
        r10 = (Uri) ZeusTransformUtils.preCheckCast(r7.f14269a, Uri.class, "com.obric.aiagent.plugin");
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
        com.obric.agent.utils.b.f15994a.a("Weather_Show", com.obric.agent.utils.b.f15994a.a(new WeatherShowParams(((MultiDateWeatherInfoCardData) ZeusTransformUtils.preCheckCast(com.obric.capabilitykit.common.a.a().fromJson(r8, MultiDateWeatherInfoCardData.class), MultiDateWeatherInfoCardData.class, "com.obric.aiagent.plugin")).getLocation(), "WEATHER")), null, UUID.randomUUID().toString().hashCode() & Integer.MAX_VALUE);
    L25:
        return x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r16);
        r7.f14269a = r10;
        r7.f14270b = r11;
        r7.f14273e = 1;
        if (super.a(r3, r10, r11, r12, r7) != r17) goto L17;
        return r17;
    L7:
        r15 = new b(this, r14);
        goto L8
    }

    private final void a(Context r20, RemoteViews r21, int r22, MultiDateWeatherInfoSingleDayCardData r23, r<Integer, Integer, Float> r24) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r20, Context.class, "com.obric.aiagent.plugin");
        int r5 = d.i.a.a(TypedValue.applyDimension(1, 40, Resources.getSystem().getDisplayMetrics()));
        int r6 = d.i.a.a(TypedValue.applyDimension(1, 2, Resources.getSystem().getDisplayMetrics()));
        int r7 = 0;
        float r8 = 0;
        float r10 = r8 / 2.0f;
        float r9 = r5 - r8;
        int r14 = this.f14268b.getResId(r3, "single_date_weather_forecast_bar_" + r22 + "_2", DbHelper.COL_ID);
        int r4 = this.f14268b.getResId(r3, "single_date_weather_forecast_slide_btn_" + r22, DbHelper.COL_ID);
        if (r23.isToday() == true) goto L6;
        r7 = 8;
    L6:
        r21.setViewVisibility(r4, r7);
        float r0 = Float.parseFloat(r23.getLowTemp());
        float r11 = Float.parseFloat(r23.getHighTemp());
        d.n.a r13 = d.n.f38560a;     // Catch: Throwable -> L9
        c r15 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        Object r1 = d.n.f(Float.valueOf(n.a((r0 - ((Number) ZeusTransformUtils.preCheckCast(r24.a(), Number.class, "com.obric.aiagent.plugin")).floatValue()) / ((Number) ZeusTransformUtils.preCheckCast(r24.c(), Number.class, "com.obric.aiagent.plugin")).floatValue(), 0.0f, 1.0f)));     // Catch: Throwable -> L9
    L12:
        if (d.n.c(r1) == null) goto L15;
        r1 = Float.valueOf(0.0f);
    L15:
        float r16 = ((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.aiagent.plugin")).floatValue();
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L18
        c r12 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        Object r17 = d.n.f(Float.valueOf(n.a((((Number) ZeusTransformUtils.preCheckCast(r24.b(), Number.class, "com.obric.aiagent.plugin")).floatValue() - r11) / ((Number) ZeusTransformUtils.preCheckCast(r24.c(), Number.class, "com.obric.aiagent.plugin")).floatValue(), 0.0f, 1.0f)));     // Catch: Throwable -> L18
    L21:
        if (d.n.c(r17) == null) goto L24;
        r17 = Float.valueOf(1.0f);
    L24:
        r21.setViewPadding(r14, (int) ((r16 * r9) + r10), 0, (int) ((((Number) ZeusTransformUtils.preCheckCast(r17, Number.class, "com.obric.aiagent.plugin")).floatValue() * r9) + r10), 0);
        if (r23.isToday() == false) goto L43;
        float r18 = r23.getCurrentTemperatureCelsius();
        d.n.a r19 = d.n.f38560a;     // Catch: Throwable -> L29
        c r25 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L29
        Object r26 = d.n.f(Float.valueOf(n.a((r18 - ((Number) ZeusTransformUtils.preCheckCast(r24.a(), Number.class, "com.obric.aiagent.plugin")).floatValue()) / ((Number) ZeusTransformUtils.preCheckCast(r24.c(), Number.class, "com.obric.aiagent.plugin")).floatValue(), 0.0f, 1.0f)));     // Catch: Throwable -> L29
    L32:
        if (d.n.c(r26) == null) goto L35;
        r26 = Float.valueOf(0.5f);
    L35:
        r21.setViewPadding(r4, (int) ((r10 + (r9 * ((Number) ZeusTransformUtils.preCheckCast(r26, Number.class, "com.obric.aiagent.plugin")).floatValue())) - (r6 / 2.0f)), 0, 0, 0);
        return;
    L29:
        th = move-exception;
        d.n.a r27 = d.n.f38560a;
        r26 = d.n.f(d.o.a(th));
        goto L32
    L43:
        return;
    L18:
        th = move-exception;
        d.n.a r28 = d.n.f38560a;
        r17 = d.n.f(d.o.a(th));
    L9:
        th = move-exception;
        d.n.a r110 = d.n.f38560a;
        r1 = d.n.f(d.o.a(th));
        goto L12
    }
}

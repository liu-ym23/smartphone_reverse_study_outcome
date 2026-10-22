package com.obric.agent.card.weather;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.widget.RemoteViews;
import com.bytedance.bdturing.localstorage.DbHelper;
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

/* JADX INFO: compiled from: BaseInfoCardProvider.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends com.obric.aiagent.assistant_card.provider_core.a {
    private static final String TAG = "BaseInfoCardProvider";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0286a f14260a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final IAssistCardResourceProvider f14261b;

    /* JADX INFO: renamed from: com.obric.agent.card.weather.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BaseInfoCardProvider.kt */
    public static final class C0286a {
        public /* synthetic */ C0286a(d.h.b.h r1) {
            this();
        }

        private C0286a() {
        }
    }

    /* JADX INFO: compiled from: BaseInfoCardProvider.kt */
    @d.c.b.a.f(b = "BaseInfoCardProvider.kt", c = {135}, d = "onActionTriggered", e = "com.obric.agent.card.weather.BaseInfoCardProvider")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f14262a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f14263b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f14264c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f14265d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f14266e;

        b(a r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14265d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.f14264c = r7;
            this.f14266e |= Integer.MIN_VALUE;
            return this.f14265d.a(null, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f14260a = new C0286a(null);
    }

    public static /* synthetic */ x lambda$sH3dU2tTXi8gThMJkR9kh1Su3N0(a r0, Context r1, BaseInfoCardData r2, boolean r3, RemoteViews r4) {
        return a(r0, r1, r2, r3, r4);
    }

    public a(String r3) {
        o.e(r3, "cardType");
        super(r3);
        Object r4 = ServiceManager.get().getService(IAssistCardResourceProvider.class);
        o.a(r4);
        this.f14261b = (IAssistCardResourceProvider) ZeusTransformUtils.preCheckCast(r4, IAssistCardResourceProvider.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant_card.provider_core.a
    public com.obric.aiagent.assistant_card.provider_core.bean.c a(Context r5, Uri r6, JSONObject r7, final boolean r8) {
        final Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        o.e(r9, "context");
        o.e(r6, "cardUri");
        ILogDepend.Companion.d(TAG, "getCard: " + r6);
        String r10 = r6.getQueryParameter("data");
        if (r10 != null) goto L6;
        ILogDepend.Companion.e(TAG, "baseInfoCardDataJson is null");
        return null;
    L6:
        final BaseInfoCardData r11 = (BaseInfoCardData) ZeusTransformUtils.preCheckCast(com.obric.capabilitykit.common.a.a().fromJson(r10, BaseInfoCardData.class), BaseInfoCardData.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.assistant_card.provider_core.bean.c.f16369a.a(r9, this.f14261b.getResId(r9, "layout_intent_card_base_info", "layout")).a().a(new $$Lambda$a$sH3dU2tTXi8gThMJkR9kh1Su3N0(this, r9, r11, r8)).a(this.f14261b.getResId(r9, "intent_card_container", DbHelper.COL_ID), "click_card", null).b();
    }

    private static final x a(a r19, Context r20, BaseInfoCardData r21, boolean r22, RemoteViews r23) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r20, Context.class, "com.obric.aiagent.plugin");
        o.e(r23, "$this$configDisplay");
        r19.a(r3, r21.getQueryType(), false);
        if (r22 == false) goto L5;
        int r1 = r19.a(r3, r21.getQueryType(), true);
        int r18 = r1;
        r23.setInt(r19.f14261b.getResId(r3, "intent_card_container", DbHelper.COL_ID), "setBackgroundResource", r19.f14261b.getResId(r3, "intent_card_bg_dark", "drawable"));
        r23.setInt(r19.f14261b.getResId(r3, "sub_time_divider", DbHelper.COL_ID), "setBackgroundColor", Color.parseColor("#1FFFFFFF"));
        r23.setInt(ZeusTransformUtils.mapRes(R.id.divider, DbHelper.COL_ID, "divider"), "setBackgroundColor", Color.parseColor("#14FFFFFF"));
        r23.setTextColor(r19.f14261b.getResId(r3, "main_info", DbHelper.COL_ID), Color.parseColor("#FFFFFFFF"));
        r23.setTextColor(r19.f14261b.getResId(r3, "sub_info", DbHelper.COL_ID), Color.parseColor("#FF777777"));
        r23.setTextColor(ZeusTransformUtils.mapRes(R.id.time, DbHelper.COL_ID, "time"), Color.parseColor("#FF777777"));
        r23.setTextColor(ZeusTransformUtils.mapRes(R.id.title, DbHelper.COL_ID, DBDefinition.TITLE), Color.parseColor("#FFCCCCCC"));
    L6:
        int r4 = ZeusTransformUtils.mapRes(R.id.icon, DbHelper.COL_ID, "icon");
        r23.setImageViewResource(r4, r18);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r21.getTagText(), CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L9;
        boolean r16 = true;
    L10:
        if (r16 == false) goto L12;
        r23.setViewVisibility(r19.f14261b.getResId(r3, "tag_container", DbHelper.COL_ID), 0);
        r23.setTextViewText(r19.f14261b.getResId(r3, "tag_text", DbHelper.COL_ID), (CharSequence) ZeusTransformUtils.preCheckCast(r21.getTagText(), CharSequence.class, "com.obric.aiagent.plugin"));
        r23.setTextColor(r19.f14261b.getResId(r3, "tag_text", DbHelper.COL_ID), r19.a(r21.getTagType(), r22));
        r23.setInt(r19.f14261b.getResId(r3, "tag_container", DbHelper.COL_ID), "setBackgroundResource", r19.a(r3, r21.getTagType(), r22));
    L12:
        r23.setTextViewText(r19.f14261b.getResId(r3, "main_info", DbHelper.COL_ID), (CharSequence) ZeusTransformUtils.preCheckCast(r21.getMainInfo(), CharSequence.class, "com.obric.aiagent.plugin"));
        r23.setTextViewText(r19.f14261b.getResId(r3, "sub_info", DbHelper.COL_ID), (CharSequence) ZeusTransformUtils.preCheckCast(r21.getLocation(), CharSequence.class, "com.obric.aiagent.plugin"));
        r23.setTextViewText(r19.f14261b.getResId(r3, "time", DbHelper.COL_ID), (CharSequence) ZeusTransformUtils.preCheckCast(r21.getDateDesc(), CharSequence.class, "com.obric.aiagent.plugin"));
        return x.f38692a;
    L9:
        r16 = false;
        goto L10
    L5:
        int r2 = r19.a(r3, r21.getQueryType(), false);
        r18 = r2;
        r23.setInt(r19.f14261b.getResId(r3, "intent_card_container", DbHelper.COL_ID), "setBackgroundResource", r19.f14261b.getResId(r3, "intent_card_bg_light", "drawable"));
        r23.setInt(r19.f14261b.getResId(r3, "sub_time_divider", DbHelper.COL_ID), "setBackgroundColor", Color.parseColor("#1A000000"));
        r23.setInt(ZeusTransformUtils.mapRes(R.id.divider, DbHelper.COL_ID, "divider"), "setBackgroundColor", Color.parseColor("#1A000000"));
        r23.setTextColor(r19.f14261b.getResId(r3, "main_info", DbHelper.COL_ID), Color.parseColor("#FF000000"));
        r23.setTextColor(r19.f14261b.getResId(r3, "sub_info", DbHelper.COL_ID), Color.parseColor("#FF999999"));
        r23.setTextColor(ZeusTransformUtils.mapRes(R.id.time, DbHelper.COL_ID, "time"), Color.parseColor("#FF999999"));
        r23.setTextColor(ZeusTransformUtils.mapRes(R.id.title, DbHelper.COL_ID, DBDefinition.TITLE), Color.parseColor("#FF666666"));
        goto L6
    }

    @Override // com.obric.aiagent.assistant_card.provider_core.a
    public Object a(Context r9, Uri r10, String r11, JSONObject r12, d.c.d<? super x> r13) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r14, b.class) == false) goto L7;
        b r15 = (b) ZeusTransformUtils.preCheckCast(r14, b.class, "com.obric.aiagent.plugin");
        if ((r15.f14266e & Integer.MIN_VALUE) == 0) goto L7;
        r15.f14266e -= Integer.MIN_VALUE;
    L8:
        b r7 = r15;
        Object r16 = r7.f14264c;
        Object r17 = d.c.a.b.a();
        int r0 = r7.f14266e;
        if (r0 == 0) goto L14;
        if (r0 != 1) goto L13;
        r11 = (String) ZeusTransformUtils.preCheckCast(r7.f14263b, String.class, "com.obric.aiagent.plugin");
        r10 = (Uri) ZeusTransformUtils.preCheckCast(r7.f14262a, Uri.class, "com.obric.aiagent.plugin");
        d.o.a(r16);
    L17:
        ILogDepend.Companion.d(TAG, "onActionTriggered cardUri: " + r10);
        if (o.a(r11, "click_card") == false) goto L25;
        ILogDepend.Companion.d(TAG, "onActionTriggered: click_card");
        String r8 = r10.getQueryParameter("data");
        if (r8 != null) goto L23;
        ILogDepend.Companion.e(TAG, "onActionTriggered baseInfoCardDataJson is null");
        return x.f38692a;
    L23:
        BaseInfoCardData r18 = (BaseInfoCardData) ZeusTransformUtils.preCheckCast(com.obric.capabilitykit.common.a.a().fromJson(r8, BaseInfoCardData.class), BaseInfoCardData.class, "com.obric.aiagent.plugin");
        com.obric.agent.utils.b.f15994a.a("Weather_Show", com.obric.agent.utils.b.f15994a.a(new WeatherShowParams(r18.getLocation(), r18.getQueryType())), null, UUID.randomUUID().toString().hashCode() & Integer.MAX_VALUE);
    L25:
        return x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r16);
        r7.f14262a = r10;
        r7.f14263b = r11;
        r7.f14266e = 1;
        if (super.a(r3, r10, r11, r12, r7) != r17) goto L17;
        return r17;
    L7:
        r15 = new b(this, r14);
        goto L8
    }

    private final int a(Context r3, String r4, boolean r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        switch(r4.hashCode()) {
            case -1721883361: goto L36;
            case -437908363: goto L30;
            case -217870625: goto L24;
            case 2721: goto L18;
            case 69225531: goto L12;
            case 1330654387: goto L6;
            default: goto L41;
        };
    L41:
        return 0;
    L6:
        if (r4.equals("HUMIDITY") == false) goto L41;
        if (r5 == false) goto L44;
        return this.f14261b.getResId(r6, "intent_card_ic_humidity_dark", "drawable");
    L44:
        return this.f14261b.getResId(r6, "intent_card_ic_humidity_light", "drawable");
    L12:
        if (r4.equals("FEEL_TEMPERATURE") == false) goto L41;
        if (r5 == false) goto L46;
        return this.f14261b.getResId(r6, "intent_card_ic_feel_temp_dark", "drawable");
    L46:
        return this.f14261b.getResId(r6, "intent_card_ic_feel_temp_light", "drawable");
    L18:
        if (r4.equals("UV") == false) goto L41;
        if (r5 == false) goto L48;
        return this.f14261b.getResId(r6, "intent_card_ic_uv_dark", "drawable");
    L48:
        return this.f14261b.getResId(r6, "intent_card_ic_uv_light", "drawable");
    L24:
        if (r4.equals("MINUTE_RAIN") == false) goto L41;
        if (r5 == false) goto L50;
        return this.f14261b.getResId(r6, "intent_card_ic_minute_rain_dark", "drawable");
    L50:
        return this.f14261b.getResId(r6, "intent_card_ic_minute_rain_light", "drawable");
    L30:
        if (r4.equals("AIRQUALITY") == false) goto L41;
        if (r5 == false) goto L52;
        return this.f14261b.getResId(r6, "intent_card_ic_aqi_dark", "drawable");
    L52:
        return this.f14261b.getResId(r6, "intent_card_ic_aqi_light", "drawable");
    L36:
        if (r4.equals("WINDSPEED") == false) goto L41;
        if (r5 == false) goto L54;
        return this.f14261b.getResId(r6, "intent_card_ic_wind_dark", "drawable");
    L54:
        return this.f14261b.getResId(r6, "intent_card_ic_wind_light", "drawable");
    }

    private final int a(Context r3, int r4, boolean r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (r4 != CardTagType.GOOD.ordinal()) goto L8;
        if (r5 == false) goto L20;
        return this.f14261b.getResId(r6, "intent_card_tag_good_dark", "drawable");
    L20:
        return this.f14261b.getResId(r6, "intent_card_tag_good_light", "drawable");
    L8:
        if (r4 != CardTagType.MEDIUM.ordinal()) goto L13;
        if (r5 == false) goto L22;
        return this.f14261b.getResId(r6, "intent_card_tag_medium_dark", "drawable");
    L22:
        return this.f14261b.getResId(r6, "intent_card_tag_medium_light", "drawable");
    L13:
        if (r4 != CardTagType.BAD.ordinal()) goto L17;
        if (r5 == false) goto L24;
        return this.f14261b.getResId(r6, "intent_card_tag_bad_dark", "drawable");
    L24:
        return this.f14261b.getResId(r6, "intent_card_tag_bad_light", "drawable");
    L17:
        return 0;
    }

    private final int a(int r1, boolean r2) {
        if (r1 != CardTagType.GOOD.ordinal()) goto L8;
        if (r2 == false) goto L21;
        return Color.parseColor("#34C759");
    L21:
        return Color.parseColor("#289A45");
    L8:
        if (r1 != CardTagType.MEDIUM.ordinal()) goto L14;
        if (r2 == false) goto L23;
        return Color.parseColor("#4F7AB6");
    L23:
        return Color.parseColor("#4F7AB6");
    L14:
        if (r1 != CardTagType.BAD.ordinal()) goto L18;
        if (r2 == false) goto L25;
        return Color.parseColor("#FF9500");
    L25:
        return Color.parseColor("#EB8900");
    L18:
        return 0;
    }
}

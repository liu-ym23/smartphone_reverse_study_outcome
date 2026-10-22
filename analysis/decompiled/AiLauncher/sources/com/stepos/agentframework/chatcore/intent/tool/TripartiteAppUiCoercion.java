package com.stepos.agentframework.chatcore.intent.tool;

import La.B;
import La.C;
import La.C0951a;
import La.D;
import La.H;
import M5.e;
import O5.c;
import Y8.j;
import Y8.t;
import Z8.A;
import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import Z8.M;
import Z8.X;
import Z8.Y;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.intent.AgentTool;
import com.stepos.agentframework.chatcore.session.ChatCoreSdk;
import com.stepos.agentframework.chatcore.session.bean.AppUIData;
import com.stepos.ailauncher.chat.trace.f;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiLiveClickReceiver;
import com.stepos.ailauncher.foundation.appui.card.provider.appauther.z;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.q0;
import com.stepos.ailauncher.foundation.appui.card.provider.weather.WeatherCardProvider;
import com.stepos.ailauncher.taskstore.provider.c;
import com.stepos.ame.sdk.SkillStoreKt;
import com.stepos.core.download.ModelFlowMeta;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.widget.recipient.StepOSRecipientEmailHistory;
import h8.C4148a;
import h9.InterfaceC4149a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.jvm.internal.p;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import v9.C5680i;
import v9.C5685n;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010$\n\u0002\b\r\n\u0002\u0010\"\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002y6B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0014\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0013\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0014\u0010\u0012J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0019\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001d\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001d\u0010\u0012J\u0019\u0010\u001e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0013\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001e\u0010\u0012J\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0013\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\"\u0010#J\u001f\u0010$\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u0006H\u0002¢\u0006\u0004\b$\u0010#J\u0017\u0010%\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u000fH\u0002¢\u0006\u0004\b%\u0010 J)\u0010(\u001a\u0004\u0018\u00010\u00062\u0016\u0010'\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060&\"\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u000fH\u0002¢\u0006\u0004\b*\u0010 J\u0019\u0010,\u001a\u00020+2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b,\u0010-J\u0019\u0010.\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b.\u0010\u0012J\u0019\u0010/\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b/\u00100J\u0019\u00101\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0013\u001a\u00020\u000fH\u0002¢\u0006\u0004\b1\u00100J\u0017\u00103\u001a\u00020\u001a2\u0006\u00102\u001a\u00020\u000fH\u0002¢\u0006\u0004\b3\u00104J\u0019\u00105\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b5\u0010\u0012J\u0019\u00106\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0013\u001a\u00020\u000fH\u0002¢\u0006\u0004\b6\u0010\u0012J\u0019\u00107\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0013\u001a\u00020\u000fH\u0002¢\u0006\u0004\b7\u0010 J!\u00108\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b8\u00109J\u0017\u0010:\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b:\u0010;J\u0019\u0010<\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b<\u00100J\u0019\u0010=\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b=\u0010\u0012J\u0019\u0010>\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0013\u001a\u00020\u000fH\u0002¢\u0006\u0004\b>\u00100J\u0017\u00102\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u000fH\u0002¢\u0006\u0004\b2\u00104J!\u0010@\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010?\u001a\u00020\u0006H\u0002¢\u0006\u0004\b@\u0010#J\u0019\u0010B\u001a\u0004\u0018\u00010\u000f2\u0006\u0010A\u001a\u00020\u0006H\u0002¢\u0006\u0004\bB\u0010CJ+\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020E0G2\u0006\u0010D\u001a\u00020\u00062\u0006\u0010F\u001a\u00020EH\u0002¢\u0006\u0004\bH\u0010IJ+\u0010K\u001a\u000e\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020E0G2\u0006\u0010D\u001a\u00020\u00062\u0006\u0010F\u001a\u00020EH\u0002¢\u0006\u0004\bK\u0010IJ+\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020E0G2\u0006\u0010D\u001a\u00020\u00062\u0006\u0010F\u001a\u00020EH\u0002¢\u0006\u0004\bL\u0010IJ+\u0010M\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020E0G2\u0006\u0010D\u001a\u00020\u00062\u0006\u0010F\u001a\u00020EH\u0002¢\u0006\u0004\bM\u0010IJ\u001f\u0010N\u001a\u00020E2\u0006\u0010D\u001a\u00020\u00062\u0006\u0010F\u001a\u00020EH\u0002¢\u0006\u0004\bN\u0010OJ\u001f\u0010P\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\bP\u0010QJ'\u0010T\u001a\b\u0012\u0004\u0012\u00020\u000f0S2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010R\u001a\u00020EH\u0002¢\u0006\u0004\bT\u0010UJ\u0019\u0010V\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0013\u001a\u00020\u000fH\u0002¢\u0006\u0004\bV\u0010\u0012J1\u0010X\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u00062\u0006\u0010W\u001a\u00020\u0006H\u0002¢\u0006\u0004\bX\u0010YJ\u0017\u0010[\u001a\u00020\u000f2\u0006\u0010Z\u001a\u00020\u000fH\u0002¢\u0006\u0004\b[\u00100J\u001d\u0010\\\u001a\u0004\u0018\u00010\u0006*\u00020\u000f2\u0006\u0010?\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\\\u0010]J%\u0010`\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010_2\u0006\u0010^\u001a\u00020\u000fH\u0002¢\u0006\u0004\b`\u0010aJ\u001f\u0010D\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010S2\u0006\u0010b\u001a\u00020JH\u0002¢\u0006\u0004\bD\u0010cJ\u001b\u0010e\u001a\u0004\u0018\u00010\u00012\b\u0010d\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\be\u0010fR\u0014\u0010g\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\bg\u0010hR \u0010i\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060_8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010jR\u0014\u0010k\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\bk\u0010hR\u0014\u0010l\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\bl\u0010hR\u001a\u0010n\u001a\b\u0012\u0004\u0012\u00020\u00060m8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bn\u0010oR \u0010p\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060_8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bp\u0010jR\u001a\u0010q\u001a\b\u0012\u0004\u0012\u00020\u00060S8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bq\u0010rR\u0014\u0010s\u001a\u00020E8\u0002X\u0082T¢\u0006\u0006\n\u0004\bs\u0010\rR\u001a\u0010t\u001a\b\u0012\u0004\u0012\u00020\u00060m8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bt\u0010oR\u0014\u0010u\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\bu\u0010hR\u0014\u0010v\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\bv\u0010hR\u0014\u0010w\u001a\u00020E8\u0002X\u0082T¢\u0006\u0006\n\u0004\bw\u0010\rR\u001a\u0010x\u001a\b\u0012\u0004\u0012\u00020\u00060m8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bx\u0010o¨\u0006z"}, d2 = {"Lcom/stepos/agentframework/chatcore/intent/tool/TripartiteAppUiCoercion;", "", "<init>", "()V", "Lcom/stepos/agentframework/chatcore/intent/e;", "tool", "", "renderSource", "Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;", "m", "(Lcom/stepos/agentframework/chatcore/intent/e;Ljava/lang/String;)Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;", "result", "Lcom/stepos/agentframework/chatcore/intent/tool/TripartiteAppUiCoercion$a;", "I", "(Ljava/lang/String;)Lcom/stepos/agentframework/chatcore/intent/tool/TripartiteAppUiCoercion$a;", "Lorg/json/JSONObject;", Parameters.ROOT, "J", "(Lorg/json/JSONObject;)Lcom/stepos/agentframework/chatcore/intent/tool/TripartiteAppUiCoercion$a;", "node", "N", "structured", "LY8/t;", "w", "(Lorg/json/JSONObject;)V", "p", "", "v", "(Ljava/lang/String;)Z", "K", "O", ExifInterface.LONGITUDE_EAST, "(Lorg/json/JSONObject;)Ljava/lang/String;", "templateId", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;", "e", Const.INTENT_KEY_BACKGROUND_COMMAND, "", "values", "l", "([Ljava/lang/String;)Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Lcom/stepos/agentframework/chatcore/intent/tool/TripartiteAppUiCoercion$HoldPosition;", "D", "(Lorg/json/JSONObject;)Lcom/stepos/agentframework/chatcore/intent/tool/TripartiteAppUiCoercion$HoldPosition;", "F", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lorg/json/JSONObject;)Lorg/json/JSONObject;", "U", "o", "q", "(Lorg/json/JSONObject;)Z", "G", Const.INTENT_KEY_APIKEY, "u", "L", "(Lcom/stepos/agentframework/chatcore/intent/e;Ljava/lang/String;)Lcom/stepos/agentframework/chatcore/intent/tool/TripartiteAppUiCoercion$a;", "r", "(Lcom/stepos/agentframework/chatcore/intent/e;)Z", "k", "H", ExifInterface.GPS_DIRECTION_TRUE, "key", "f", "raw", "B", "(Ljava/lang/String;)Lorg/json/JSONObject;", "s", "", "start", "Lkotlin/Pair;", "z", "(Ljava/lang/String;I)Lkotlin/Pair;", "Lorg/json/JSONArray;", "y", "C", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "M", "(Ljava/lang/String;I)I", ExifInterface.LATITUDE_SOUTH, "(Lcom/stepos/agentframework/chatcore/intent/e;Ljava/lang/String;)Ljava/lang/String;", "depth", "", "Q", "(Lorg/json/JSONObject;I)Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "templateType", "c", "(Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)Lorg/json/JSONObject;", "action", Const.INTENT_KEY_UMID, "x", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;", "obj", "", "t", "(Lorg/json/JSONObject;)Ljava/util/Map;", "array", "(Lorg/json/JSONArray;)Ljava/util/List;", UxipConstants.f30680s, "P", "(Ljava/lang/Object;)Ljava/lang/Object;", "TAG", "Ljava/lang/String;", "CARD_CENTER_TEMPLATES", "Ljava/util/Map;", "MUSIC_LIST_TEMPLATE_TYPE", "CARD_CENTER_ALIAS", "", "ALIPAY_WRAPPER_KEYS", "Ljava/util/Set;", "AUTH_TEMPLATES", "AUTH_UNWRAP_KEYS", "Ljava/util/List;", "MAX_UNWRAP_DEPTH", "WEATHER_METHODS", "TEMPLATE_TYPE_WEATHER", "ABILITY_WRAPPER_NAME", "CODE_SUCCESS", "WEATHER_SHAPE_KEYS", "HoldPosition", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TripartiteAppUiCoercion {
    private static final String ABILITY_WRAPPER_NAME = "ability";
    private static final int CODE_SUCCESS = 200;
    private static final int MAX_UNWRAP_DEPTH = 4;
    private static final String MUSIC_LIST_TEMPLATE_TYPE = "music_list";
    private static final String TAG = "TripartiteAppUiCoercion";
    private static final String TEMPLATE_TYPE_WEATHER = "weather";
    public static final TripartiteAppUiCoercion INSTANCE = new TripartiteAppUiCoercion();
    public static final String CARD_CENTER_ALIAS = "app_ui_card_center";
    private static final Map<String, String> CARD_CENTER_TEMPLATES = kotlin.collections.a.m(j.a(CARD_CENTER_ALIAS, CARD_CENTER_ALIAS), j.a("oauth-authorize", CARD_CENTER_ALIAS), j.a("song-list", CARD_CENTER_ALIAS));
    private static final Set<String> ALIPAY_WRAPPER_KEYS = X.d("lifeServiceCard");
    private static final Map<String, String> AUTH_TEMPLATES = kotlin.collections.a.m(j.a("oauth-authorize", c.APP_AUTHER_OAUTH), j.a("bind-credential", c.APP_AUTHER_CREDENTIAL), j.a("guide-steps", c.APP_AUTHER_GUIDE), j.a("a2a-authorize", c.APP_AUTHER_A2A));
    private static final List<String> AUTH_UNWRAP_KEYS = C1173v.p("result", "stdout", "stderr", "blockReason");
    private static final Set<String> WEATHER_METHODS = Y.j("query_city_weather", "query_local_weather", "get_weather", "weather_get_current_location_weather");
    private static final Set<String> WEATHER_SHAPE_KEYS = Y.j(WeatherCardProvider.KEY_DAILY, WeatherCardProvider.KEY_HOURLY, "realtime");

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/agentframework/chatcore/intent/tool/TripartiteAppUiCoercion$HoldPosition;", "", "<init>", "(Ljava/lang/String;I)V", ModelFlowMeta.PLAN_NONE, "TOP", "BOTTOM", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class HoldPosition {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ HoldPosition[] $VALUES;
        public static final HoldPosition NONE = new HoldPosition(ModelFlowMeta.PLAN_NONE, 0);
        public static final HoldPosition TOP = new HoldPosition("TOP", 1);
        public static final HoldPosition BOTTOM = new HoldPosition("BOTTOM", 2);

        private static final /* synthetic */ HoldPosition[] $values() {
            return new HoldPosition[]{NONE, TOP, BOTTOM};
        }

        static {
            HoldPosition[] holdPositionArr$values = $values();
            $VALUES = holdPositionArr$values;
            $ENTRIES = kotlin.enums.a.a(holdPositionArr$values);
        }

        private HoldPosition(String str, int i10) {
        }

        public static InterfaceC4149a<HoldPosition> getEntries() {
            return $ENTRIES;
        }

        public static HoldPosition valueOf(String str) {
            return (HoldPosition) Enum.valueOf(HoldPosition.class, str);
        }

        public static HoldPosition[] values() {
            return (HoldPosition[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/stepos/agentframework/chatcore/intent/tool/TripartiteAppUiCoercion$a;", "", "Lorg/json/JSONObject;", "structured", "", "appUIName", "Lcom/stepos/agentframework/chatcore/intent/tool/TripartiteAppUiCoercion$HoldPosition;", "hold", "<init>", "(Lorg/json/JSONObject;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/intent/tool/TripartiteAppUiCoercion$HoldPosition;)V", "Lorg/json/JSONObject;", "c", "()Lorg/json/JSONObject;", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "()Ljava/lang/String;", "Lcom/stepos/agentframework/chatcore/intent/tool/TripartiteAppUiCoercion$HoldPosition;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/agentframework/chatcore/intent/tool/TripartiteAppUiCoercion$HoldPosition;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        private final String appUIName;
        private final HoldPosition hold;
        private final JSONObject structured;

        public a(JSONObject structured, String appUIName, HoldPosition hold) {
            p.i(structured, "structured");
            p.i(appUIName, "appUIName");
            p.i(hold, "hold");
            this.structured = structured;
            this.appUIName = appUIName;
            this.hold = hold;
        }

        /* renamed from: a, reason: from getter */
        public final String getAppUIName() {
            return this.appUIName;
        }

        /* renamed from: b, reason: from getter */
        public final HoldPosition getHold() {
            return this.hold;
        }

        /* renamed from: c, reason: from getter */
        public final JSONObject getStructured() {
            return this.structured;
        }
    }

    public static /* synthetic */ List R(TripartiteAppUiCoercion tripartiteAppUiCoercion, JSONObject jSONObject, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return tripartiteAppUiCoercion.Q(jSONObject, i10);
    }

    public static /* synthetic */ AppUIData n(TripartiteAppUiCoercion tripartiteAppUiCoercion, AgentTool agentTool, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = f.ENTRY_HISTORY;
        }
        return tripartiteAppUiCoercion.m(agentTool, str);
    }

    public final Pair<Object, Integer> A(String s10, int start) {
        char cCharAt;
        int i10;
        int i11 = start;
        while (i11 < s10.length() && (cCharAt = s10.charAt(i11)) != ']' && cCharAt != '}' && (cCharAt != ',' || ((i10 = i11 + 1) < s10.length() && s10.charAt(i10) != ' '))) {
            i11++;
        }
        String strSubstring = s10.substring(start, i11);
        p.h(strSubstring, "substring(...)");
        String string = H.D1(strSubstring).toString();
        if (string.length() == 0 || p.d(string, "null")) {
            return j.a(JSONObject.NULL, Integer.valueOf(i11));
        }
        Long lY = C.y(string);
        if (lY != null) {
            return j.a(Long.valueOf(lY.longValue()), Integer.valueOf(i11));
        }
        Double dT = B.t(string);
        return dT != null ? j.a(Double.valueOf(dT.doubleValue()), Integer.valueOf(i11)) : (p.d(string, "true") || p.d(string, "false")) ? j.a(Boolean.valueOf(Boolean.parseBoolean(string)), Integer.valueOf(i11)) : j.a(string, Integer.valueOf(i11));
    }

    public final JSONObject B(String raw) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(z(raw, 0).e());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        JSONObject jSONObject = (JSONObject) objB;
        if (jSONObject == null || jSONObject.length() <= 0) {
            return null;
        }
        return jSONObject;
    }

    public final Pair<Object, Integer> C(String s10, int start) {
        int iM = M(s10, start);
        if (iM >= s10.length()) {
            return j.a("", Integer.valueOf(iM));
        }
        char cCharAt = s10.charAt(iM);
        return cCharAt != '[' ? cCharAt != '{' ? A(s10, iM) : z(s10, iM) : y(s10, iM);
    }

    public final HoldPosition D(JSONObject node) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        if (node == null || (jSONObjectOptJSONObject = node.optJSONObject("_meta")) == null || (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("render")) == null) {
            return HoldPosition.NONE;
        }
        Object objOpt = jSONObjectOptJSONObject2.opt("hold");
        if (objOpt == null) {
            return HoldPosition.NONE;
        }
        if (objOpt instanceof Boolean) {
            return ((Boolean) objOpt).booleanValue() ? HoldPosition.BOTTOM : HoldPosition.NONE;
        }
        if (!(objOpt instanceof String)) {
            return HoldPosition.NONE;
        }
        String lowerCase = ((String) objOpt).toLowerCase(Locale.ROOT);
        p.h(lowerCase, "toLowerCase(...)");
        return p.d(lowerCase, "top") ? HoldPosition.TOP : p.d(lowerCase, "bottom") ? HoldPosition.BOTTOM : HoldPosition.NONE;
    }

    public final String E(JSONObject node) {
        JSONObject jSONObjectOptJSONObject = node.optJSONObject("_meta");
        if (jSONObjectOptJSONObject == null) {
            return null;
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("render");
        String strOptString = jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.optString("templateId") : null;
        JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject("ui");
        String strOptString2 = jSONObjectOptJSONObject3 != null ? jSONObjectOptJSONObject3.optString("templateId") : null;
        JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject.optJSONObject("ui");
        String strOptString3 = jSONObjectOptJSONObject4 != null ? jSONObjectOptJSONObject4.optString(e.FAIL_TEMPLATE) : null;
        JSONObject jSONObjectOptJSONObject5 = jSONObjectOptJSONObject.optJSONObject("ui");
        return l(strOptString, strOptString2, strOptString3, jSONObjectOptJSONObject5 != null ? jSONObjectOptJSONObject5.optString("template_id") : null);
    }

    public final a F(JSONObject root) {
        JSONObject jSONObjectJ = j(root);
        if (jSONObjectJ == null) {
            return null;
        }
        return new a(jSONObjectJ, CARD_CENTER_ALIAS, D(root));
    }

    public final a G(JSONObject root) {
        a aVarA;
        a aVarA2 = a(root);
        if (aVarA2 != null) {
            return aVarA2;
        }
        JSONObject jSONObjectOptJSONObject = root.optJSONObject("payload");
        if (jSONObjectOptJSONObject == null || (aVarA = INSTANCE.a(jSONObjectOptJSONObject)) == null) {
            return null;
        }
        return aVarA;
    }

    public final a H(JSONObject root) {
        Iterator it = R(this, root, 0, 2, null).iterator();
        while (it.hasNext()) {
            a aVarB = INSTANCE.b((JSONObject) it.next());
            if (aVarB != null) {
                return aVarB;
            }
        }
        return null;
    }

    public final a I(String result) throws JSONException {
        if (!v(result)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(result);
        a aVarH = H(jSONObject);
        if (aVarH != null) {
            return aVarH;
        }
        a aVarJ = J(jSONObject);
        if (aVarJ != null) {
            C4148a.k(TAG, "resolveCard hit protocol=song-list appUIName=" + aVarJ.getAppUIName(), false, 4, null);
            return aVarJ;
        }
        a aVarK = K(jSONObject);
        if (aVarK != null) {
            C4148a.k(TAG, "resolveCard hit protocol=① 正规A版(standard) appUIName=" + aVarK.getAppUIName(), false, 4, null);
            return aVarK;
        }
        a aVarF = F(jSONObject);
        if (aVarF != null) {
            C4148a.k(TAG, "resolveCard hit protocol=② 支付宝老协议(alipay) appUIName=" + aVarF.getAppUIName(), false, 4, null);
            return aVarF;
        }
        a aVarG = G(jSONObject);
        if (aVarG != null) {
            C4148a.k(TAG, "resolveCard hit protocol=③ 原子能力(atomicAbility) appUIName=" + aVarG.getAppUIName(), false, 4, null);
            return aVarG;
        }
        a aVarK2 = K(jSONObject);
        if (aVarK2 != null) {
            return aVarK2;
        }
        a aVarF2 = F(jSONObject);
        if (aVarF2 != null) {
            return aVarF2;
        }
        a aVarG2 = G(jSONObject);
        if (aVarG2 != null) {
            return aVarG2;
        }
        a aVarH2 = H(jSONObject);
        if (aVarH2 != null) {
            return aVarH2;
        }
        return null;
    }

    public final a J(JSONObject root) throws JSONException {
        a aVarN;
        a aVarN2 = N(root);
        if (aVarN2 != null) {
            return aVarN2;
        }
        JSONObject jSONObjectOptJSONObject = root.optJSONObject("result");
        if (jSONObjectOptJSONObject == null || (aVarN = INSTANCE.N(jSONObjectOptJSONObject)) == null) {
            return null;
        }
        return aVarN;
    }

    public final a K(JSONObject root) throws JSONException {
        a aVarO;
        a aVarO2 = O(root);
        if (aVarO2 != null) {
            return aVarO2;
        }
        JSONObject jSONObjectOptJSONObject = root.optJSONObject("result");
        if (jSONObjectOptJSONObject == null || (aVarO = INSTANCE.O(jSONObjectOptJSONObject)) == null) {
            return null;
        }
        return aVarO;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0030 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.agentframework.chatcore.intent.tool.TripartiteAppUiCoercion.a L(com.stepos.agentframework.chatcore.intent.AgentTool r19, java.lang.String r20) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.intent.tool.TripartiteAppUiCoercion.L(com.stepos.agentframework.chatcore.intent.e, java.lang.String):com.stepos.agentframework.chatcore.intent.tool.TripartiteAppUiCoercion$a");
    }

    public final int M(String s10, int start) {
        while (start < s10.length() && C0951a.c(s10.charAt(start))) {
            start++;
        }
        return start;
    }

    public final a N(JSONObject node) throws JSONException {
        String strOptString;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2 = node.optJSONObject("_meta");
        if (jSONObjectOptJSONObject2 == null || (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject("render")) == null || (strOptString = jSONObjectOptJSONObject.optString("templateId")) == null) {
            strOptString = "";
        }
        if (!p.d(strOptString, "song-list")) {
            return null;
        }
        String str = CARD_CENTER_TEMPLATES.get("song-list");
        if (str == null) {
            str = CARD_CENTER_ALIAS;
        }
        JSONObject jSONObjectOptJSONObject3 = node.optJSONObject("structuredContent");
        if (jSONObjectOptJSONObject3 == null) {
            return null;
        }
        if (jSONObjectOptJSONObject3.length() <= 0) {
            jSONObjectOptJSONObject3 = null;
        }
        if (jSONObjectOptJSONObject3 == null) {
            return null;
        }
        w(jSONObjectOptJSONObject3);
        return new a(jSONObjectOptJSONObject3, str, D(node));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.agentframework.chatcore.intent.tool.TripartiteAppUiCoercion.a O(org.json.JSONObject r6) throws org.json.JSONException {
        /*
            r5 = this;
            java.lang.String r0 = r5.E(r6)
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            java.util.Map<java.lang.String, java.lang.String> r2 = com.stepos.agentframework.chatcore.intent.tool.TripartiteAppUiCoercion.CARD_CENTER_TEMPLATES
            java.lang.Object r2 = r2.get(r0)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 != 0) goto L13
            return r1
        L13:
            java.lang.String r3 = "structuredContent"
            org.json.JSONObject r3 = r6.optJSONObject(r3)
            if (r3 == 0) goto L2d
            int r4 = r3.length()
            if (r4 <= 0) goto L22
            r1 = r3
        L22:
            if (r1 == 0) goto L2d
            com.stepos.agentframework.chatcore.intent.tool.TripartiteAppUiCoercion r3 = com.stepos.agentframework.chatcore.intent.tool.TripartiteAppUiCoercion.INSTANCE
            org.json.JSONObject r1 = r3.h(r1, r0)
            if (r1 == 0) goto L2d
            goto L31
        L2d:
            org.json.JSONObject r1 = r5.e(r6, r0)
        L31:
            com.stepos.agentframework.chatcore.intent.tool.TripartiteAppUiCoercion$a r0 = new com.stepos.agentframework.chatcore.intent.tool.TripartiteAppUiCoercion$a
            com.stepos.agentframework.chatcore.intent.tool.TripartiteAppUiCoercion$HoldPosition r5 = r5.D(r6)
            r0.<init>(r1, r2, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.intent.tool.TripartiteAppUiCoercion.O(org.json.JSONObject):com.stepos.agentframework.chatcore.intent.tool.TripartiteAppUiCoercion$a");
    }

    public final Object P(Object value) {
        if (value == null || p.d(value, JSONObject.NULL)) {
            return null;
        }
        if (value instanceof JSONObject) {
            return t((JSONObject) value);
        }
        if (value instanceof JSONArray) {
            return s((JSONArray) value);
        }
        if (p.d(value, "null")) {
            return null;
        }
        return value;
    }

    public final List<JSONObject> Q(JSONObject root, int depth) {
        Object objB;
        Object objB2;
        if (depth > 4) {
            return C1173v.m();
        }
        List<JSONObject> listS = C1173v.s(root);
        Iterator<T> it = AUTH_UNWRAP_KEYS.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String str = (String) it.next();
            JSONObject jSONObjectOptJSONObject = root.optJSONObject(str);
            if (jSONObjectOptJSONObject != null) {
                A.E(listS, INSTANCE.Q(jSONObjectOptJSONObject, depth + 1));
            }
            String strOptString = root.optString(str);
            p.f(strOptString);
            if (H.x0(strOptString) || !D.X(H.H1(strOptString).toString(), Const.STR_MART_JSON_BEGIN, false, 2, null)) {
                strOptString = null;
            }
            if (strOptString != null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    objB2 = Result.b(new JSONObject(strOptString));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB2 = Result.b(C4849c.a(th));
                }
                JSONObject jSONObject = (JSONObject) (Result.g(objB2) ? null : objB2);
                if (jSONObject != null) {
                    A.E(listS, INSTANCE.Q(jSONObject, depth + 1));
                }
            }
        }
        JSONArray jSONArrayOptJSONArray = root.optJSONArray(SkillStoreKt.SKILL_DOC_TYPE_CONTENT);
        if (jSONArrayOptJSONArray != null) {
            int length = jSONArrayOptJSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i10);
                if (jSONObjectOptJSONObject2 != null) {
                    String strOptString2 = jSONObjectOptJSONObject2.optString("text");
                    p.f(strOptString2);
                    if (H.x0(strOptString2) || !D.X(H.H1(strOptString2).toString(), Const.STR_MART_JSON_BEGIN, false, 2, null)) {
                        strOptString2 = null;
                    }
                    if (strOptString2 != null) {
                        try {
                            Result.Companion companion3 = Result.INSTANCE;
                            objB = Result.b(new JSONObject(strOptString2));
                        } catch (Throwable th2) {
                            Result.Companion companion4 = Result.INSTANCE;
                            objB = Result.b(C4849c.a(th2));
                        }
                        if (Result.g(objB)) {
                            objB = null;
                        }
                        JSONObject jSONObject2 = (JSONObject) objB;
                        if (jSONObject2 != null) {
                            A.E(listS, INSTANCE.Q(jSONObject2, depth + 1));
                        }
                    }
                }
            }
        }
        return listS;
    }

    public final String S(AgentTool tool, String result) {
        String toolCallId = tool.getToolCallId();
        if (H.x0(toolCallId) || D.L(toolCallId, "null", true)) {
            toolCallId = null;
        }
        if (toolCallId != null) {
            return toolCallId;
        }
        return "weather-" + result.hashCode();
    }

    public final JSONObject T(JSONObject node) {
        if (node.optInt("code", 200) != 200) {
            return null;
        }
        JSONObject jSONObjectF = f(node, UxipConstants.f30680s);
        if (jSONObjectF != null) {
            if (jSONObjectF.length() <= 0) {
                jSONObjectF = null;
            }
            if (jSONObjectF != null) {
                return jSONObjectF;
            }
        }
        JSONObject jSONObjectF2 = f(node, "structuredContent");
        if (jSONObjectF2 != null) {
            if (!INSTANCE.o(jSONObjectF2)) {
                jSONObjectF2 = null;
            }
            if (jSONObjectF2 != null) {
                return jSONObjectF2;
            }
        }
        if (INSTANCE.o(node)) {
            return node;
        }
        return null;
    }

    public final JSONObject U(JSONObject node) {
        Iterator<T> it = ALIPAY_WRAPPER_KEYS.iterator();
        while (it.hasNext()) {
            JSONObject jSONObjectOptJSONObject = node.optJSONObject((String) it.next());
            if (jSONObjectOptJSONObject != null && INSTANCE.q(jSONObjectOptJSONObject)) {
                return jSONObjectOptJSONObject;
            }
        }
        return null;
    }

    public final a a(JSONObject node) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        String strU = u(node);
        if (strU == null || (jSONObjectOptJSONObject = node.optJSONObject(SkillStoreKt.SKILL_DOC_TYPE_CONTENT)) == null || (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("structuredContent")) == null) {
            return null;
        }
        if (jSONObjectOptJSONObject2.length() <= 0) {
            jSONObjectOptJSONObject2 = null;
        }
        if (jSONObjectOptJSONObject2 != null) {
            return new a(jSONObjectOptJSONObject2, strU, D(node.optJSONObject(SkillStoreKt.SKILL_DOC_TYPE_CONTENT)));
        }
        return null;
    }

    public final a b(JSONObject node) {
        String str;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectC;
        JSONObject jSONObjectOptJSONObject2;
        JSONObject jSONObjectOptJSONObject3 = node.optJSONObject("_meta");
        String strOptString = (jSONObjectOptJSONObject3 == null || (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject3.optJSONObject("ui")) == null) ? null : jSONObjectOptJSONObject2.optString("templateId");
        if (strOptString != null && (str = AUTH_TEMPLATES.get(strOptString)) != null && (jSONObjectOptJSONObject = node.optJSONObject("structuredContent")) != null) {
            if (jSONObjectOptJSONObject.length() <= 0) {
                jSONObjectOptJSONObject = null;
            }
            if (jSONObjectOptJSONObject == null || (jSONObjectC = c(node, jSONObjectOptJSONObject, strOptString, str)) == null) {
                return null;
            }
            return new a(jSONObjectC, CARD_CENTER_ALIAS, HoldPosition.NONE);
        }
        return null;
    }

    public final JSONObject c(JSONObject node, JSONObject structured, String templateId, String templateType) throws JSONException {
        String str;
        String strX = x(structured, "pending_id");
        String strX2 = x(structured, "integration_id");
        String strX3 = x(structured, "vendor_id");
        if (strX != null) {
            str = strX;
        } else if (strX2 != null) {
            str = strX2;
        } else {
            if (strX3 == null) {
                C4148a.u(TAG, "auth_required 缺 pending_id/integration_id/vendor_id，无法确定 taskId，放弃出卡", false, 4, null);
                return null;
            }
            str = strX3;
        }
        JSONObject jSONObjectOptJSONObject = structured.optJSONObject("client_action");
        if (jSONObjectOptJSONObject == null) {
            jSONObjectOptJSONObject = structured.optJSONObject("action");
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("templateId", templateId);
        TripartiteAppUiCoercion tripartiteAppUiCoercion = INSTANCE;
        jSONObject.put("kind", tripartiteAppUiCoercion.x(structured, "kind"));
        jSONObject.put("frameStatus", tripartiteAppUiCoercion.x(node, "status"));
        jSONObject.put("vendorId", strX3);
        jSONObject.put("integrationId", strX2);
        jSONObject.put("integrationType", tripartiteAppUiCoercion.x(structured, "integration_type"));
        jSONObject.put("displayName", tripartiteAppUiCoercion.x(structured, StepOSRecipientEmailHistory.DISPLAY_NAME));
        jSONObject.put("iconUrl", tripartiteAppUiCoercion.x(structured, "icon_url"));
        jSONObject.put("pendingId", strX);
        jSONObject.put("reauth", structured.optBoolean("reauth", false));
        jSONObject.put("authText", tripartiteAppUiCoercion.x(structured, z.STEP_SOURCE_GUIDE_TEXT));
        jSONObject.put("modelInstruction", tripartiteAppUiCoercion.x(node, "model_instruction"));
        jSONObject.put("clientAction", jSONObjectOptJSONObject != null ? tripartiteAppUiCoercion.d(jSONObjectOptJSONObject) : null);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("templateType", templateType);
        jSONObject2.put("taskId", str);
        jSONObject2.put("taskTitle", tripartiteAppUiCoercion.x(structured, StepOSRecipientEmailHistory.DISPLAY_NAME));
        jSONObject2.put("businessData", jSONObject);
        return jSONObject2;
    }

    public final JSONObject d(JSONObject action) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        TripartiteAppUiCoercion tripartiteAppUiCoercion = INSTANCE;
        jSONObject.put("type", tripartiteAppUiCoercion.x(action, "type"));
        jSONObject.put("integrationId", tripartiteAppUiCoercion.x(action, "integration_id"));
        jSONObject.put(Const.JSON_KEY_PROVIDER, tripartiteAppUiCoercion.x(action, Const.JSON_KEY_PROVIDER));
        JSONObject jSONObjectOptJSONObject = action.optJSONObject("start_api");
        if (jSONObjectOptJSONObject != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("method", tripartiteAppUiCoercion.x(jSONObjectOptJSONObject, "method"));
            jSONObject2.put("path", tripartiteAppUiCoercion.x(jSONObjectOptJSONObject, "path"));
            jSONObject2.put("body", jSONObjectOptJSONObject.optJSONObject("body"));
            t tVar = t.f7040a;
            jSONObject.put("startApi", jSONObject2);
        }
        JSONObject jSONObjectOptJSONObject2 = action.optJSONObject("complete_api");
        if (jSONObjectOptJSONObject2 != null) {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("method", tripartiteAppUiCoercion.x(jSONObjectOptJSONObject2, "method"));
            jSONObject3.put("path", tripartiteAppUiCoercion.x(jSONObjectOptJSONObject2, "path"));
            jSONObject3.put("body", jSONObjectOptJSONObject2.optJSONObject("body"));
            t tVar2 = t.f7040a;
            jSONObject.put("completeApi", jSONObject3);
        }
        JSONObject jSONObjectOptJSONObject3 = action.optJSONObject("status_api");
        if (jSONObjectOptJSONObject3 != null) {
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("method", tripartiteAppUiCoercion.x(jSONObjectOptJSONObject3, "method"));
            String strX = tripartiteAppUiCoercion.x(jSONObjectOptJSONObject3, "path_template");
            if (strX == null) {
                strX = tripartiteAppUiCoercion.x(jSONObjectOptJSONObject3, "path");
            }
            jSONObject4.put("pathTemplate", strX);
            t tVar3 = t.f7040a;
            jSONObject.put("statusApi", jSONObject4);
        }
        JSONObject jSONObjectOptJSONObject4 = action.optJSONObject("poll_api");
        if (jSONObjectOptJSONObject4 != null) {
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("method", tripartiteAppUiCoercion.x(jSONObjectOptJSONObject4, "method"));
            String strX2 = tripartiteAppUiCoercion.x(jSONObjectOptJSONObject4, "path_template");
            if (strX2 == null) {
                strX2 = tripartiteAppUiCoercion.x(jSONObjectOptJSONObject4, "path");
            }
            jSONObject5.put("pathTemplate", strX2);
            t tVar4 = t.f7040a;
            jSONObject.put("pollApi", jSONObject5);
        }
        JSONArray jSONArrayOptJSONArray = action.optJSONArray("fields");
        if (jSONArrayOptJSONArray != null) {
            JSONArray jSONArray = new JSONArray();
            int length = jSONArrayOptJSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                JSONObject jSONObjectOptJSONObject5 = jSONArrayOptJSONArray.optJSONObject(i10);
                if (jSONObjectOptJSONObject5 != null) {
                    JSONObject jSONObject6 = new JSONObject();
                    TripartiteAppUiCoercion tripartiteAppUiCoercion2 = INSTANCE;
                    jSONObject6.put("name", tripartiteAppUiCoercion2.x(jSONObjectOptJSONObject5, "name"));
                    jSONObject6.put("label", tripartiteAppUiCoercion2.x(jSONObjectOptJSONObject5, "label"));
                    jSONObject6.put("helpUrl", tripartiteAppUiCoercion2.x(jSONObjectOptJSONObject5, "help_url"));
                    jSONObject6.put("helpText", tripartiteAppUiCoercion2.x(jSONObjectOptJSONObject5, z.STEP_SOURCE_HELP_TEXT));
                    jSONObject6.put("secret", jSONObjectOptJSONObject5.optBoolean("secret", true));
                    jSONArray.put(jSONObject6);
                }
            }
            t tVar5 = t.f7040a;
            jSONObject.put("fields", jSONArray);
        }
        TripartiteAppUiCoercion tripartiteAppUiCoercion3 = INSTANCE;
        Object objX = tripartiteAppUiCoercion3.x(action, "app_link");
        if (objX == null) {
            objX = tripartiteAppUiCoercion3.x(action, AlipayXuiLiveClickReceiver.EXTRA_APP_LINK);
        }
        jSONObject.put(AlipayXuiLiveClickReceiver.EXTRA_APP_LINK, objX);
        Object objX2 = tripartiteAppUiCoercion3.x(action, "web_link");
        if (objX2 == null) {
            objX2 = tripartiteAppUiCoercion3.x(action, "webLink");
        }
        jSONObject.put("webLink", objX2);
        return jSONObject;
    }

    public final JSONObject e(JSONObject node, String templateId) throws JSONException {
        JSONObject jSONObject = new JSONObject(node.toString());
        jSONObject.remove("_meta");
        String strG = g(jSONObject);
        JSONObject jSONObjectPut = new JSONObject().put("templateType", templateId);
        String strL = l(node.optString("taskId"), node.optString("id"));
        if (strL == null) {
            strL = i(node);
        }
        JSONObject jSONObjectPut2 = jSONObjectPut.put("taskId", strL).put(D6.a.KEY_TASK_STATUS, 91).put("bizChannel", strG).put(c.a.COL_SUMMARY, new JSONObject().put("title", l(node.optString("title"), node.optString("name"), node.optString("next_action")))).put("businessData", jSONObject);
        p.h(jSONObjectPut2, "put(...)");
        return jSONObjectPut2;
    }

    public final JSONObject f(JSONObject node, String key) {
        Object objB;
        JSONObject jSONObjectOptJSONObject = node.optJSONObject(key);
        if (jSONObjectOptJSONObject != null) {
            return jSONObjectOptJSONObject;
        }
        String strOptString = node.optString(key);
        p.h(strOptString, "optString(...)");
        String string = H.D1(strOptString).toString();
        if (H.x0(string) || !D.X(string, Const.STR_MART_JSON_BEGIN, false, 2, null)) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(new JSONObject(string));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        JSONObject jSONObject = (JSONObject) (Result.g(objB) ? null : objB);
        return jSONObject != null ? jSONObject : B(string);
    }

    public final String g(JSONObject node) {
        String string = node.toString();
        p.h(string, "toString(...)");
        String lowerCase = string.toLowerCase(Locale.ROOT);
        p.h(lowerCase, "toLowerCase(...)");
        String str = q0.CAOCAO;
        if (!H.g0(lowerCase, q0.CAOCAO, false, 2, null) && !H.g0(lowerCase, "曹操", false, 2, null) && !H.g0(lowerCase, "cn.caocaokeji.user", false, 2, null)) {
            str = q0.DIDI;
            if (!H.g0(lowerCase, q0.DIDI, false, 2, null) && !H.g0(lowerCase, "滴滴", false, 2, null) && !H.g0(lowerCase, "com.sdu.didi.psnger", false, 2, null)) {
                return "";
            }
        }
        return str;
    }

    public final JSONObject h(JSONObject structured, String templateId) throws JSONException {
        String strOptString = structured.optString("templateType");
        p.h(strOptString, "optString(...)");
        if (!H.x0(strOptString)) {
            return structured;
        }
        JSONObject jSONObjectPut = new JSONObject(structured.toString()).put("templateType", templateId);
        p.h(jSONObjectPut, "put(...)");
        return jSONObjectPut;
    }

    public final String i(JSONObject node) {
        return "oauth_authorize_" + Math.abs(node.toString().hashCode());
    }

    public final JSONObject j(JSONObject root) {
        Object objB;
        JSONObject jSONObjectU;
        JSONObject jSONObjectU2 = U(root);
        if (jSONObjectU2 != null) {
            return jSONObjectU2;
        }
        JSONArray jSONArrayOptJSONArray = root.optJSONArray(SkillStoreKt.SKILL_DOC_TYPE_CONTENT);
        if (jSONArrayOptJSONArray == null) {
            return null;
        }
        int length = jSONArrayOptJSONArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i10);
            if (jSONObjectOptJSONObject != null && p.d(jSONObjectOptJSONObject.optString("type"), "text")) {
                String strOptString = jSONObjectOptJSONObject.optString("text");
                p.f(strOptString);
                if (H.x0(strOptString)) {
                    strOptString = null;
                }
                if (strOptString == null) {
                    continue;
                } else {
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        objB = Result.b(new JSONObject(strOptString));
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.INSTANCE;
                        objB = Result.b(C4849c.a(th));
                    }
                    if (Result.g(objB)) {
                        objB = null;
                    }
                    JSONObject jSONObject = (JSONObject) objB;
                    if (jSONObject != null && (jSONObjectU = U(jSONObject)) != null) {
                        return jSONObjectU;
                    }
                }
            }
        }
        return null;
    }

    public final JSONObject k(JSONObject root) {
        TripartiteAppUiCoercion tripartiteAppUiCoercion;
        JSONObject jSONObjectF;
        JSONObject jSONObjectT;
        JSONObject jSONObjectT2;
        JSONObject jSONObjectT3;
        JSONObject jSONObjectT4;
        JSONObject jSONObjectT5 = T(root);
        if (jSONObjectT5 != null) {
            return jSONObjectT5;
        }
        JSONObject jSONObjectF2 = f(root, SkillStoreKt.SKILL_DOC_TYPE_CONTENT);
        if (jSONObjectF2 != null && (jSONObjectT4 = INSTANCE.T(jSONObjectF2)) != null) {
            return jSONObjectT4;
        }
        JSONObject jSONObjectF3 = f(root, "result");
        if (jSONObjectF3 != null && (jSONObjectT3 = INSTANCE.T(jSONObjectF3)) != null) {
            return jSONObjectT3;
        }
        JSONObject jSONObjectF4 = f(root, "payload");
        if (jSONObjectF4 != null && (jSONObjectT2 = INSTANCE.T(jSONObjectF4)) != null) {
            return jSONObjectT2;
        }
        JSONObject jSONObjectF5 = f(root, "details");
        if (jSONObjectF5 == null || (jSONObjectF = (tripartiteAppUiCoercion = INSTANCE).f(jSONObjectF5, "payload")) == null || (jSONObjectT = tripartiteAppUiCoercion.T(jSONObjectF)) == null) {
            return null;
        }
        return jSONObjectT;
    }

    public final String l(String... values) {
        int length = values.length;
        for (int i10 = 0; i10 < length; i10++) {
            String str = values[i10];
            if (!(str == null || H.x0(str))) {
                return str;
            }
        }
        return null;
    }

    public final AppUIData m(AgentTool tool, String renderSource) {
        Object objB;
        Object objB2;
        JSONArray jSONArrayOptJSONArray;
        p.i(tool, "tool");
        p.i(renderSource, "renderSource");
        try {
            Result.Companion companion = Result.INSTANCE;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (tool.getAppUIData() != null || !tool.getIsFinished()) {
            return null;
        }
        String result = tool.getResult();
        if (H.x0(result)) {
            result = null;
        }
        if (result == null) {
            return null;
        }
        a aVarI = I(result);
        if (aVarI == null && (aVarI = L(tool, result)) == null) {
            C4148a.k(TAG, "skip: no card matched toolCallId=" + tool.getToolCallId(), false, 4, null);
            return null;
        }
        JSONObject structured = aVarI.getStructured();
        if (p.d(renderSource, "realtime")) {
            structured.put("__client_render_source", "realtime");
        } else {
            structured.remove("__client_render_source");
        }
        HoldPosition hold = aVarI.getHold();
        boolean z10 = true;
        boolean z11 = hold != HoldPosition.NONE;
        boolean z12 = hold == HoldPosition.TOP;
        String toolCallId = tool.getToolCallId();
        String appUIName = aVarI.getAppUIName();
        if (structured.opt("bizChannelIcon") == null) {
            z10 = false;
        }
        Object objOpt = structured.opt("templateType");
        Object objOpt2 = structured.opt("taskId");
        Object objOpt3 = structured.opt("bizChannel");
        JSONObject jSONObjectOptJSONObject = structured.optJSONObject("businessData");
        C4148a.k(TAG, "coerce ok toolCallId=" + toolCallId + " appUIName=" + appUIName + " hold=" + hold + " hasIcon=" + z10 + " templateType=" + objOpt + " taskId=" + objOpt2 + " bizChannel=" + objOpt3 + " itemSize=" + ((jSONObjectOptJSONObject == null || (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray(DidiCardProvider.KEY_ITEMS)) == null) ? -1 : jSONArrayOptJSONArray.length()), false, 4, null);
        int iA = AppUIData.INSTANCE.a();
        String appUIName2 = aVarI.getAppUIName();
        try {
            objB2 = Result.b(ChatCoreSdk.INSTANCE.c().getPackageName());
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.INSTANCE;
            objB2 = Result.b(C4849c.a(th2));
        }
        if (Result.g(objB2)) {
            objB2 = "";
        }
        p.h(objB2, "getOrDefault(...)");
        objB = Result.b(new AppUIData(null, iA, null, false, appUIName2, null, null, t(structured), null, null, (String) objB2, null, null, null, z11, z12, 15213, null));
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.h(TAG, "coerce failed toolCallId=" + tool.getToolCallId() + ": " + thE.getMessage(), false, 4, null);
        }
        return (AppUIData) (Result.g(objB) ? null : objB);
    }

    public final boolean o(JSONObject node) {
        Set<String> set = WEATHER_SHAPE_KEYS;
        if ((set instanceof Collection) && set.isEmpty()) {
            return false;
        }
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            if (node.has((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    public final void p(JSONObject structured) throws JSONException {
        if (structured.has("autoPlay")) {
            JSONObject jSONObjectOptJSONObject = structured.optJSONObject("businessData");
            if (jSONObjectOptJSONObject == null) {
                jSONObjectOptJSONObject = new JSONObject();
                structured.put("businessData", jSONObjectOptJSONObject);
            }
            if (jSONObjectOptJSONObject.has("autoPlay")) {
                return;
            }
            jSONObjectOptJSONObject.put("autoPlay", structured.opt("autoPlay"));
        }
    }

    public final boolean q(JSONObject o10) {
        JSONArray jSONArrayOptJSONArray;
        String strOptString = o10.optString("templateType");
        p.h(strOptString, "optString(...)");
        if (!H.x0(strOptString)) {
            JSONObject jSONObjectOptJSONObject = o10.optJSONObject("businessData");
            if (((jSONObjectOptJSONObject == null || (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray(DidiCardProvider.KEY_ITEMS)) == null) ? 0 : jSONArrayOptJSONArray.length()) > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean r(AgentTool tool) {
        Object objB;
        Set<String> set = WEATHER_METHODS;
        if (set.contains(tool.getName()) || F.f0(set, tool.getApiName())) {
            return true;
        }
        if (!p.d(tool.getName(), ABILITY_WRAPPER_NAME) && !p.d(tool.getApiName(), ABILITY_WRAPPER_NAME)) {
            return false;
        }
        String parameter = tool.getParameter();
        if (H.x0(parameter)) {
            parameter = null;
        }
        if (parameter == null) {
            return false;
        }
        Set<String> set2 = set;
        if (!(set2 instanceof Collection) || !set2.isEmpty()) {
            Iterator<T> it = set2.iterator();
            while (it.hasNext()) {
                if (H.g0(parameter, (String) it.next(), false, 2, null)) {
                    Set<String> set3 = WEATHER_METHODS;
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        objB = Result.b(new JSONObject(parameter).optString("method"));
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.INSTANCE;
                        objB = Result.b(C4849c.a(th));
                    }
                    return F.f0(set3, Result.g(objB) ? null : objB);
                }
            }
        }
        return false;
    }

    public final List<Object> s(JSONArray array) {
        C5680i c5680iS = C5685n.s(0, array.length());
        ArrayList arrayList = new ArrayList(C1174w.x(c5680iS, 10));
        Iterator<Integer> it = c5680iS.iterator();
        while (it.hasNext()) {
            arrayList.add(INSTANCE.P(array.opt(((M) it).nextInt())));
        }
        return arrayList;
    }

    public final Map<String, Object> t(JSONObject obj) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(obj.length());
        Iterator<String> itKeys = obj.keys();
        p.h(itKeys, "keys(...)");
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            linkedHashMap.put(next, INSTANCE.P(obj.opt(next)));
        }
        return linkedHashMap;
    }

    public final String u(JSONObject node) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2 = node.optJSONObject("meta");
        if (jSONObjectOptJSONObject2 != null && (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject("appUI")) != null) {
            Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
            p.h(itKeys, "keys(...)");
            while (itKeys.hasNext()) {
                String str = CARD_CENTER_TEMPLATES.get(jSONObjectOptJSONObject.optString(itKeys.next()));
                if (str != null) {
                    return str;
                }
            }
        }
        return null;
    }

    public final boolean v(String result) {
        Set<String> setKeySet = CARD_CENTER_TEMPLATES.keySet();
        if (!(setKeySet instanceof Collection) || !setKeySet.isEmpty()) {
            Iterator<T> it = setKeySet.iterator();
            while (it.hasNext()) {
                if (H.g0(result, (String) it.next(), false, 2, null)) {
                    return true;
                }
            }
        }
        Set<String> set = ALIPAY_WRAPPER_KEYS;
        if (!(set instanceof Collection) || !set.isEmpty()) {
            Iterator<T> it2 = set.iterator();
            while (it2.hasNext()) {
                if (H.g0(result, (String) it2.next(), false, 2, null)) {
                    return true;
                }
            }
        }
        Set<String> setKeySet2 = AUTH_TEMPLATES.keySet();
        if (!(setKeySet2 instanceof Collection) || !setKeySet2.isEmpty()) {
            Iterator<T> it3 = setKeySet2.iterator();
            while (it3.hasNext()) {
                if (H.g0(result, (String) it3.next(), false, 2, null)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void w(JSONObject structured) throws JSONException {
        String strOptString = structured.optString("templateType");
        p.h(strOptString, "optString(...)");
        if (!H.x0(strOptString)) {
            p(structured);
            return;
        }
        structured.put("templateType", "music_list");
        JSONObject jSONObject = new JSONObject();
        String strOptString2 = structured.optString("title");
        p.f(strOptString2);
        if (H.x0(strOptString2)) {
            strOptString2 = null;
        }
        if (strOptString2 != null) {
            jSONObject.put("title", strOptString2);
        }
        String strOptString3 = structured.optString("brandName");
        p.f(strOptString3);
        if (H.x0(strOptString3)) {
            strOptString3 = null;
        }
        if (strOptString3 != null) {
            jSONObject.put("brandName", strOptString3);
        }
        String strOptString4 = structured.optString("brandLogoUrl");
        p.f(strOptString4);
        String str = H.x0(strOptString4) ? null : strOptString4;
        if (str != null) {
            jSONObject.put("brandLogoUrl", str);
        }
        JSONArray jSONArrayOptJSONArray = structured.optJSONArray(DidiCardProvider.KEY_ITEMS);
        if (jSONArrayOptJSONArray != null) {
            jSONObject.put(DidiCardProvider.KEY_ITEMS, jSONArrayOptJSONArray);
        }
        if (structured.has("autoPlay")) {
            jSONObject.put("autoPlay", structured.opt("autoPlay"));
        }
        if (jSONObject.length() > 0) {
            structured.put("businessData", jSONObject);
        }
    }

    public final String x(JSONObject jSONObject, String str) {
        String strOptString = jSONObject.optString(str);
        p.f(strOptString);
        if (H.x0(strOptString) || D.L(strOptString, "null", true)) {
            return null;
        }
        return strOptString;
    }

    public final Pair<JSONArray, Integer> y(String s10, int start) {
        JSONArray jSONArray = new JSONArray();
        while (true) {
            start++;
            while (start < s10.length()) {
                int iM = M(s10, start);
                if (iM < s10.length() && s10.charAt(iM) == ']') {
                    return j.a(jSONArray, Integer.valueOf(iM + 1));
                }
                Pair<Object, Integer> pairC = C(s10, iM);
                Object objA = pairC.a();
                int iIntValue = pairC.b().intValue();
                jSONArray.put(objA);
                start = M(s10, iIntValue);
                if (start >= s10.length() || s10.charAt(start) != ',') {
                }
            }
            return j.a(jSONArray, Integer.valueOf(start));
        }
    }

    public final Pair<JSONObject, Integer> z(String s10, int start) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        int iM = start + 1;
        while (true) {
            if (iM >= s10.length()) {
                break;
            }
            int iM2 = M(s10, iM);
            if (iM2 < s10.length() && s10.charAt(iM2) == '}') {
                return j.a(jSONObject, Integer.valueOf(iM2 + 1));
            }
            String str = s10;
            int iT0 = H.t0(str, '=', iM2, false, 4, null);
            if (iT0 < 0) {
                iM = iM2;
                break;
            }
            String strSubstring = str.substring(iM2, iT0);
            p.h(strSubstring, "substring(...)");
            String string = H.D1(strSubstring).toString();
            Pair<Object, Integer> pairC = C(str, iT0 + 1);
            Object objA = pairC.a();
            int iIntValue = pairC.b().intValue();
            if (string.length() > 0) {
                jSONObject.put(string, objA);
            }
            iM = M(str, iIntValue);
            if (iM < str.length() && str.charAt(iM) == ',') {
                iM++;
            }
            s10 = str;
        }
        return j.a(jSONObject, Integer.valueOf(iM));
    }
}

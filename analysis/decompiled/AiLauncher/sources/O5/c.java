package O5;

import N5.g;
import N5.h;
import com.stepos.agentframework.chatcore.intent.tool.TripartiteAppUiCoercion;
import com.stepos.agentframework.chatui.appui.f;
import com.stepos.ailauncher.agent.ability.VoiceAbilityService;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiCardProvider;
import com.stepos.ailauncher.foundation.appui.card.provider.amap.PoiDetailCardProvider;
import com.stepos.ailauncher.foundation.appui.card.provider.amap.PoiListCardProvider;
import com.stepos.ailauncher.foundation.appui.card.provider.amap.RouteCardProvider;
import com.stepos.ailauncher.foundation.appui.card.provider.appauther.C3286a;
import com.stepos.ailauncher.foundation.appui.card.provider.appauther.C3299n;
import com.stepos.ailauncher.foundation.appui.card.provider.appauther.C3303s;
import com.stepos.ailauncher.foundation.appui.card.provider.appauther.w;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.ailauncher.foundation.appui.card.provider.lifeservice.LifeServiceCardProvider;
import com.stepos.ailauncher.foundation.appui.card.provider.orderaction.OrderActionCardProvider;
import com.stepos.ailauncher.foundation.appui.card.provider.travel.HotelCardProvider;
import com.stepos.ailauncher.foundation.appui.card.provider.travel.TransportCardProvider;
import com.stepos.ailauncher.foundation.appui.card.provider.travel.x;
import com.stepos.ailauncher.foundation.appui.card.provider.weather.WeatherCardProvider;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\bR\u0014\u0010\u000e\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\bR\u0014\u0010\u000f\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\bR\u0014\u0010\u0010\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\bR\u0014\u0010\u0011\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\bR\u0014\u0010\u0012\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\bR\u0014\u0010\u0013\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\bR\u0014\u0010\u0014\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\bR\u0014\u0010\u0015\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\bR\u0014\u0010\u0016\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\bR\u0014\u0010\u0017\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\bR\u0014\u0010\u0018\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\bR\u0014\u0010\u0019\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\bR\u0014\u0010\u001a\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\b¨\u0006\u001b"}, d2 = {"LO5/c;", "", "<init>", "()V", "LY8/t;", "c", "", "QUERY_FLIGHT", "Ljava/lang/String;", "QUERY_TRAIN", "QUERY_HOTEL", "FLIGHT", "TRAIN", "HOTEL", "TRIP_COMBO", "LIFE_SERVICE", "WEATHER", "MAP_ROUTE", "MAP_POI_LIST", "MAP_POI_DETAIL", "DIDI", "ORDER_ACTION_CARD", "ALIPAY_XUI", "APP_AUTHER_OAUTH", "APP_AUTHER_CREDENTIAL", "APP_AUTHER_GUIDE", "APP_AUTHER_A2A", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class c {
    public static final String ALIPAY_XUI = "alipay_xui";
    public static final String APP_AUTHER_A2A = "appAutherA2a";
    public static final String APP_AUTHER_CREDENTIAL = "appAutherCredential";
    public static final String APP_AUTHER_GUIDE = "appAutherGuide";
    public static final String APP_AUTHER_OAUTH = "appAutherOauth";
    public static final String DIDI = "taxi";
    public static final String FLIGHT = "flight";
    public static final String HOTEL = "hotel";
    public static final c INSTANCE = new c();
    public static final String LIFE_SERVICE = "life_service";
    public static final String MAP_POI_DETAIL = "map_poi_detail";
    public static final String MAP_POI_LIST = "map_poi_list";
    public static final String MAP_ROUTE = "map_route";
    public static final String ORDER_ACTION_CARD = "order_action_card";
    public static final String QUERY_FLIGHT = "query_flight";
    public static final String QUERY_HOTEL = "query_hotel";
    public static final String QUERY_TRAIN = "query_train";
    public static final String TRAIN = "train";
    public static final String TRIP_COMBO = "trip_combo";
    public static final String WEATHER = "weather";

    public static final com.stepos.agentframework.chatui.appui.a d() {
        return new h();
    }

    public static final com.stepos.agentframework.chatui.appui.a e() {
        return new h();
    }

    public final void c() {
        f fVar = f.INSTANCE;
        fVar.b(TripartiteAppUiCoercion.CARD_CENTER_ALIAS, new InterfaceC5063a() { // from class: O5.a
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return c.d();
            }
        });
        fVar.b(VoiceAbilityService.TOOL_LOAD_TRIPARTITE_COMMON_CARD, new InterfaceC5063a() { // from class: O5.b
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return c.e();
            }
        });
        g gVar = g.INSTANCE;
        gVar.a(FLIGHT, new TransportCardProvider());
        gVar.a(TRAIN, new TransportCardProvider());
        gVar.a(HOTEL, new HotelCardProvider());
        gVar.a(QUERY_FLIGHT, new TransportCardProvider());
        gVar.a(QUERY_TRAIN, new TransportCardProvider());
        gVar.a(QUERY_HOTEL, new HotelCardProvider());
        gVar.a(TRIP_COMBO, new x());
        gVar.a(LIFE_SERVICE, new LifeServiceCardProvider(null, 1, null));
        gVar.a(ORDER_ACTION_CARD, new OrderActionCardProvider());
        gVar.a(DIDI, new DidiCardProvider());
        gVar.a(WEATHER, new WeatherCardProvider(null, 1, null));
        gVar.a(MAP_ROUTE, new RouteCardProvider());
        gVar.a(MAP_POI_LIST, new PoiListCardProvider());
        gVar.a(MAP_POI_DETAIL, new PoiDetailCardProvider());
        gVar.a(ALIPAY_XUI, new AlipayXuiCardProvider());
        gVar.a(APP_AUTHER_OAUTH, new w());
        gVar.a(APP_AUTHER_CREDENTIAL, new C3299n());
        gVar.a(APP_AUTHER_GUIDE, new C3303s());
        gVar.a(APP_AUTHER_A2A, new C3286a());
    }
}

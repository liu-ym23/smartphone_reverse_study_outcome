package M5;

import La.H;
import Y8.j;
import Y8.t;
import Z8.F;
import Z8.Q;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardModel;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.q0;
import h8.C4148a;
import io.ktor.sse.ServerSentEventKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.N;
import kotlin.Result;
import kotlin.jvm.internal.p;
import r9.C5227b;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010#\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\f\u0010\u000bJ\u0015\u0010\r\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u000eJ?\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00042\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J7\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00042\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0014H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070\u0006*\u00020\u0004H\u0002¢\u0006\u0004\b \u0010!J\u001f\u0010#\u001a\u0004\u0018\u00010\u00112\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¢\u0006\u0004\b#\u0010$J\u001d\u0010%\u001a\u00020\u00112\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¢\u0006\u0004\b%\u0010$J\u001f\u0010&\u001a\u0004\u0018\u00010\u00112\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¢\u0006\u0004\b&\u0010$R\u0014\u0010'\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b)\u0010(R\u0014\u0010*\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010(R\u0014\u0010+\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b+\u0010(R\u0014\u0010,\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b,\u0010(R\u0014\u0010-\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b-\u0010(R\u0014\u0010.\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b.\u0010(R\u0014\u0010/\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b/\u0010(R\u0014\u00100\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b0\u0010(R\u0014\u00101\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b1\u0010(R\u0014\u00102\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b2\u0010(R\u001a\u00104\u001a\b\u0012\u0004\u0012\u00020\u0011038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105¨\u00066"}, d2 = {"LM5/d;", "", "<init>", "()V", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y;", AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, "", "Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y$c;", "selectedTypes", "LY8/t;", "c", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y;Ljava/util/List;)V", "e", "n", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y;)V", "m", "l", "", "key", "sceneEvent", "", "extra", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;Ljava/lang/String;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y;Ljava/util/Map;)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y;Ljava/util/Map;)V", "o", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y;)Ljava/lang/String;", "", "status", "f", "(I)Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/foundation/appui/card/provider/didi/y;)Ljava/util/List;", "types", Const.INTENT_KEY_APIKEY, "(Ljava/util/List;)Ljava/lang/String;", "k", Const.INTENT_KEY_UMID, "TAG", "Ljava/lang/String;", "EVENT", "PAGE_NAME", "SCENE_ESTIMATE_EXPOSE", "SCENE_ORDER_CLICK", "SCENE_STATUS_EXPOSE", "SCENE_SIGN_EXPOSE", "SCENE_SIGN_CLICK", "SCENE_NORMAL", "SCENE_BARRIER_FREE", "BARRIER_FREE_CAR_KEYWORD", "", "exposedKeys", "Ljava/util/Set;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class d {
    private static final String BARRIER_FREE_CAR_KEYWORD = "无障碍";
    private static final String EVENT = "taxi_biz_event";
    public static final d INSTANCE = new d();
    private static final String PAGE_NAME = "chatview";
    private static final String SCENE_BARRIER_FREE = "barrierfree";
    private static final String SCENE_ESTIMATE_EXPOSE = "taxi_estimate_expose";
    private static final String SCENE_NORMAL = "normal";
    private static final String SCENE_ORDER_CLICK = "taxi_order_click";
    private static final String SCENE_SIGN_CLICK = "taxi_sign_click";
    private static final String SCENE_SIGN_EXPOSE = "taxi_sign_expose";
    private static final String SCENE_STATUS_EXPOSE = "taxi_status_expose";
    private static final String TAG = "TaxiBizTracker";
    private static final Set<String> exposedKeys;

    static {
        ConcurrentHashMap.KeySetView keySetViewNewKeySet = ConcurrentHashMap.newKeySet();
        p.h(keySetViewNewKeySet, "newKeySet(...)");
        exposedKeys = keySetViewNewKeySet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void h(d dVar, String str, DidiCardModel didiCardModel, Map map, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            map = kotlin.collections.a.i();
        }
        dVar.g(str, didiCardModel, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void j(d dVar, String str, String str2, DidiCardModel didiCardModel, Map map, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            map = kotlin.collections.a.i();
        }
        dVar.i(str, str2, didiCardModel, map);
    }

    public final String a(List<DidiCardModel.CarTypeItem> types) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = types.iterator();
        while (true) {
            String str = null;
            if (!it.hasNext()) {
                break;
            }
            String name = ((DidiCardModel.CarTypeItem) it.next()).getName();
            if (name != null && !H.x0(name)) {
                str = name;
            }
            if (str != null) {
                arrayList.add(str);
            }
        }
        ArrayList arrayList2 = !arrayList.isEmpty() ? arrayList : null;
        if (arrayList2 != null) {
            return F.A0(arrayList2, Const.STR_MART_COMMA, null, null, 0, null, null, 62, null);
        }
        return null;
    }

    public final List<DidiCardModel.CarTypeItem> b(DidiCardModel didiCardModel) {
        List<DidiCardModel.CarTypeItem> listK = didiCardModel.k();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listK) {
            if (((DidiCardModel.CarTypeItem) obj).getSelectedByDefault()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final void c(DidiCardModel model, List<DidiCardModel.CarTypeItem> selectedTypes) {
        p.i(model, "model");
        p.i(selectedTypes, "selectedTypes");
        if (selectedTypes.isEmpty()) {
            selectedTypes = null;
        }
        if (selectedTypes == null) {
            selectedTypes = b(model);
        }
        String strA = a(selectedTypes);
        i("estimate:" + model.getCardId() + ServerSentEventKt.COLON + o(model) + ServerSentEventKt.COLON + (strA == null ? "" : strA), SCENE_ESTIMATE_EXPOSE, model, kotlin.collections.a.m(j.a("result", "success"), j.a("is_signed", "true"), j.a("car_type", strA), j.a("estimate_price", d(selectedTypes)), j.a("scene_type", k(selectedTypes))));
    }

    public final String d(List<DidiCardModel.CarTypeItem> types) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = types.iterator();
        while (it.hasNext()) {
            Double priceValue = ((DidiCardModel.CarTypeItem) it.next()).getPriceValue();
            if (priceValue != null) {
                arrayList.add(priceValue);
            }
        }
        Double dL0 = F.L0(arrayList);
        if (dL0 != null) {
            return String.valueOf(C5227b.a(dL0.doubleValue() * 100));
        }
        return null;
    }

    public final void e(DidiCardModel model, List<DidiCardModel.CarTypeItem> selectedTypes) {
        p.i(model, "model");
        p.i(selectedTypes, "selectedTypes");
        if (selectedTypes.isEmpty()) {
            selectedTypes = null;
        }
        if (selectedTypes == null) {
            selectedTypes = b(model);
        }
        g(SCENE_ORDER_CLICK, model, kotlin.collections.a.m(j.a("car_type", a(selectedTypes)), j.a("scene_type", k(selectedTypes))));
    }

    public final String f(int status) {
        if (status == 0 || status == 27) {
            return "cancelled";
        }
        switch (status) {
            case 2:
                return "matching";
            case 3:
                return "arriving";
            case 4:
                return "arrived";
            case 5:
                return "in_trip";
            case 6:
                return "completed";
            case 7:
            case 8:
            case 9:
            case 10:
                return "cancelled";
            default:
                return null;
        }
    }

    public final void g(String sceneEvent, DidiCardModel model, Map<String, String> extra) {
        String str;
        Object objB;
        String strO = o(model);
        if (strO == null) {
            return;
        }
        String cardId = model.getCardId();
        if (H.x0(cardId)) {
            cardId = null;
        }
        if (cardId == null) {
            return;
        }
        LinkedHashMap linkedHashMapL = kotlin.collections.a.l(j.a("thirdapp_id", strO), j.a("task_id", cardId), j.a("scene_event", sceneEvent));
        for (Map.Entry<String, String> entry : extra.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (value != null && !H.x0(value)) {
                linkedHashMapL.put(key, value);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(Q.e(linkedHashMapL.size()));
        Iterator it = linkedHashMapL.entrySet().iterator();
        while (true) {
            str = "";
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry2 = (Map.Entry) it.next();
            Object key2 = entry2.getKey();
            String str2 = (String) entry2.getValue();
            if (str2 != null) {
                str = str2;
            }
            linkedHashMap.put(key2, str);
        }
        C4148a.k("Track", linkedHashMap.toString(), false, 4, null);
        try {
            Result.Companion companion = Result.INSTANCE;
            N.a(EVENT, "chatview", linkedHashMap);
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            String message = thE.getMessage();
            C4148a.u(TAG, message != null ? message : "", false, 4, null);
        }
    }

    public final void i(String key, String sceneEvent, DidiCardModel model, Map<String, String> extra) {
        if (exposedKeys.add(key)) {
            g(sceneEvent, model, extra);
        }
    }

    public final String k(List<DidiCardModel.CarTypeItem> types) {
        List<DidiCardModel.CarTypeItem> list = types;
        if ((list instanceof Collection) && list.isEmpty()) {
            return "normal";
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            String name = ((DidiCardModel.CarTypeItem) it.next()).getName();
            if (name != null && H.g0(name, BARRIER_FREE_CAR_KEYWORD, false, 2, null)) {
                return SCENE_BARRIER_FREE;
            }
        }
        return "normal";
    }

    public final void l(DidiCardModel model) {
        p.i(model, "model");
        if (model.getPrimaryAction() == null) {
            return;
        }
        h(this, SCENE_SIGN_CLICK, model, null, 4, null);
    }

    public final void m(DidiCardModel model) {
        p.i(model, "model");
        if (model.getPrimaryAction() == null) {
            return;
        }
        j(this, "sign:" + model.getCardId() + ServerSentEventKt.COLON + o(model), SCENE_SIGN_EXPOSE, model, null, 8, null);
    }

    public final void n(DidiCardModel model) {
        String orderNo;
        p.i(model, "model");
        String strF = f(model.getStatus());
        if (strF == null || (orderNo = model.getOrderNo()) == null) {
            return;
        }
        if (H.x0(orderNo)) {
            orderNo = null;
        }
        if (orderNo == null) {
            return;
        }
        i("status:" + model.getCardId() + ServerSentEventKt.COLON + orderNo + ServerSentEventKt.COLON + strF, SCENE_STATUS_EXPOSE, model, kotlin.collections.a.m(j.a("order_status", strF), j.a("order_id", orderNo)));
    }

    public final String o(DidiCardModel model) {
        String lowerCase;
        String string;
        String bizChannel = model.getBizChannel();
        if (bizChannel == null || (string = H.D1(bizChannel).toString()) == null) {
            lowerCase = null;
        } else {
            lowerCase = string.toLowerCase(Locale.ROOT);
            p.h(lowerCase, "toLowerCase(...)");
        }
        if (lowerCase == null) {
            lowerCase = "";
        }
        if (lowerCase.length() == 0 || p.d(lowerCase, q0.DIDI)) {
            return q0.DIDI;
        }
        if (p.d(lowerCase, q0.CAOCAO)) {
            return q0.CAOCAO;
        }
        return null;
    }
}

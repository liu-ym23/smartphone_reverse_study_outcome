package com.stepos.ailauncher.foundation.appui.card.provider.travel;

import N5.CardEnvelope;
import Z8.C1173v;
import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/travel/HotelCardProvider;", "LN5/v;", "<init>", "()V", "LN5/i;", "envelope", "LN5/n;", Const.INTENT_KEY_PKGNAME, "(LN5/i;)LN5/n;", "Landroid/content/Context;", "context", "LN5/d;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)LN5/d;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HotelCardProvider implements N5.v {
    @Override // N5.v
    public N5.d a(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        return new f(context, null, 0, 6, null);
    }

    @Override // N5.v
    public N5.n b(CardEnvelope envelope) {
        JsonElement jsonElement;
        String simpleName;
        List listM;
        kotlin.jvm.internal.p.i(envelope, "envelope");
        N5.k kVar = N5.k.INSTANCE;
        JsonObject jsonObjectC = kVar.c(envelope.e());
        if (jsonObjectC == null || (jsonElement = jsonObjectC.get(DidiCardProvider.KEY_ITEMS)) == null) {
            listM = C1173v.m();
        } else {
            try {
                listM = (List) kVar.b().fromJson(jsonElement, new TypeToken<List<? extends HotelItem>>() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.travel.HotelCardProvider$parse$$inlined$parseList$1
                }.getType());
                if (listM == null) {
                    listM = C1173v.m();
                }
            } catch (Exception e10) {
                R5.b bVar = R5.b.INSTANCE;
                Pair pairA = Y8.j.a("key", DidiCardProvider.KEY_ITEMS);
                Pair pairA2 = Y8.j.a("targetType", HotelItem.class.getSimpleName());
                if (jsonElement.isJsonArray()) {
                    simpleName = "array(size=" + jsonElement.getAsJsonArray().size() + ")";
                } else {
                    simpleName = jsonElement.isJsonObject() ? "object" : jsonElement.isJsonPrimitive() ? "primitive" : jsonElement.getClass().getSimpleName();
                }
                bVar.h("CardJson.parseList.fail", pairA, pairA2, Y8.j.a("elementKind", simpleName), Y8.j.a("exception", e10.getClass().getSimpleName()), Y8.j.a("message", e10.getMessage()));
                listM = C1173v.m();
            }
        }
        R5.b bVar2 = R5.b.INSTANCE;
        String taskId = envelope.getTaskId();
        if (taskId.length() == 0) {
            taskId = "null";
        }
        String str = "provider.hotel:" + ((Object) taskId);
        String taskId2 = envelope.getTaskId();
        Pair pairA3 = Y8.j.a("taskId", taskId2.length() != 0 ? taskId2 : "null");
        Pair pairA4 = Y8.j.a("templateType", envelope.getTemplateType());
        Pair pairA5 = Y8.j.a("providerCls", "HotelCardProvider");
        Pair pairA6 = Y8.j.a("itemCount", Integer.valueOf(listM.size()));
        Map<String, Object> mapE = envelope.e();
        if (!(mapE instanceof Map)) {
            mapE = null;
        }
        bVar2.e(str, "provider.parse", pairA3, pairA4, pairA5, pairA6, Y8.j.a("businessDataKeys", mapE != null ? mapE.keySet() : null));
        return new C3330b(envelope.getTaskId(), listM);
    }
}

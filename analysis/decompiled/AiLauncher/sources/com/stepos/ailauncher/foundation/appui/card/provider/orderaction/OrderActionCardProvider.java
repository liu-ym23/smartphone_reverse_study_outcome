package com.stepos.ailauncher.foundation.appui.card.provider.orderaction;

import D6.a;
import N5.BizChannelIcon;
import N5.CardEnvelope;
import N5.d;
import N5.k;
import N5.n;
import N5.v;
import P5.OrderActionItem;
import P5.e;
import R5.b;
import Y8.j;
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
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/orderaction/OrderActionCardProvider;", "LN5/v;", "<init>", "()V", "LN5/i;", "envelope", "LN5/n;", Const.INTENT_KEY_PKGNAME, "(LN5/i;)LN5/n;", "Landroid/content/Context;", "context", "LN5/d;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)LN5/d;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OrderActionCardProvider implements v {
    @Override // N5.v
    public d a(Context context) {
        p.i(context, "context");
        return new e(context, null, 0, 6, null);
    }

    @Override // N5.v
    public n b(CardEnvelope envelope) {
        JsonElement jsonElement;
        String simpleName;
        List listM;
        p.i(envelope, "envelope");
        k kVar = k.INSTANCE;
        JsonObject jsonObjectC = kVar.c(envelope.e());
        if (jsonObjectC == null || (jsonElement = jsonObjectC.get(DidiCardProvider.KEY_ITEMS)) == null) {
            listM = C1173v.m();
        } else {
            try {
                listM = (List) kVar.b().fromJson(jsonElement, new TypeToken<List<? extends OrderActionItem>>() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.orderaction.OrderActionCardProvider$parse$$inlined$parseList$1
                }.getType());
                if (listM == null) {
                    listM = C1173v.m();
                }
            } catch (Exception e10) {
                b bVar = b.INSTANCE;
                Pair pairA = j.a("key", DidiCardProvider.KEY_ITEMS);
                Pair pairA2 = j.a("targetType", OrderActionItem.class.getSimpleName());
                if (jsonElement.isJsonArray()) {
                    simpleName = "array(size=" + jsonElement.getAsJsonArray().size() + ")";
                } else {
                    simpleName = jsonElement.isJsonObject() ? "object" : jsonElement.isJsonPrimitive() ? "primitive" : jsonElement.getClass().getSimpleName();
                }
                bVar.h("CardJson.parseList.fail", pairA, pairA2, j.a("elementKind", simpleName), j.a("exception", e10.getClass().getSimpleName()), j.a("message", e10.getMessage()));
                listM = C1173v.m();
            }
        }
        List list = listM;
        b bVar2 = b.INSTANCE;
        String taskId = envelope.getTaskId();
        if (taskId.length() == 0) {
            taskId = "null";
        }
        String str = "provider.orderAction:" + ((Object) taskId);
        String taskId2 = envelope.getTaskId();
        Pair pairA3 = j.a("taskId", taskId2.length() != 0 ? taskId2 : "null");
        Pair pairA4 = j.a("templateType", envelope.getTemplateType());
        Pair pairA5 = j.a("providerCls", "OrderActionCardProvider");
        Pair pairA6 = j.a("itemCount", Integer.valueOf(list.size()));
        Pair pairA7 = j.a("bizChannel", envelope.getBizChannel());
        Pair pairA8 = j.a(a.KEY_TASK_STATUS, envelope.getTaskStatus());
        Map<String, Object> mapE = envelope.e();
        if (!(mapE instanceof Map)) {
            mapE = null;
        }
        bVar2.e(str, "provider.parse", pairA3, pairA4, pairA5, pairA6, pairA7, pairA8, j.a("businessDataKeys", mapE != null ? mapE.keySet() : null));
        String taskId3 = envelope.getTaskId();
        String bizChannel = envelope.getBizChannel();
        BizChannelIcon bizChannelIcon = envelope.getBizChannelIcon();
        return new P5.b(taskId3, list, bizChannel, bizChannelIcon != null ? bizChannelIcon.getIcon() : null, envelope.getTaskStatus());
    }
}

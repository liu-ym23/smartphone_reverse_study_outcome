package com.stepos.ailauncher.chat.view.sla;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.sla.SlaVoiceBridge;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a9\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00002\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000H\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"", "", "baseMeta", "params", "", Const.INTENT_KEY_APIKEY, "(Ljava/util/Map;Ljava/util/Map;)Z", "chat_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class p {
    public static final boolean a(Map<String, String> baseMeta, Map<String, String> map) {
        kotlin.jvm.internal.p.i(baseMeta, "baseMeta");
        String str = baseMeta.get(SlaVoiceBridge.META_KEY_INPUT_CHANNEL);
        if (str == null) {
            str = map != null ? map.get(SlaVoiceBridge.META_KEY_INPUT_CHANNEL) : null;
        }
        return kotlin.jvm.internal.p.d(str, "voice");
    }
}

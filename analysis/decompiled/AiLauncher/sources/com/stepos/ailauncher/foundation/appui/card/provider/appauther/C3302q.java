package com.stepos.ailauncher.foundation.appui.card.provider.appauther;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ%\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0011\u0010\u0003R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014RH\u0010\u0018\u001a6\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00160\u0015j\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0016`\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/q;", "", "<init>", "()V", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/q$a;", "key", "", "", "c", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/q$a;)Ljava/util/Map;", "fieldName", UxipConstants.f30680s, "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/q$a;Ljava/lang/String;Ljava/lang/String;)V", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/q$a;)V", Const.INTENT_KEY_UMID, "", "MAX_CARD_DRAFTS", "I", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "drafts", "Ljava/util/LinkedHashMap;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.appauther.q, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3302q {
    private static final int MAX_CARD_DRAFTS = 8;
    public static final C3302q INSTANCE = new C3302q();
    private static final LinkedHashMap<Key, Map<String, String>> drafts = new LinkedHashMap<>(8, 0.75f, true);

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0080\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\nR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0014\u0010\nR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0015\u0010\nR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0016\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/q$a;", "", "", "cardId", "vendorId", "integrationId", "mode", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getCardId", "getVendorId", "getIntegrationId", "getMode", "Companion", Const.INTENT_KEY_APIKEY, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.appauther.q$a, reason: from toString */
    public static final /* data */ class Key {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String cardId;
        private final String integrationId;
        private final String mode;
        private final String vendorId;

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/q$a$a;", "", "<init>", "()V", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/k;", AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/q$a;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/k;)Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/q$a;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.appauther.q$a$a, reason: collision with other inner class name and from kotlin metadata */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
                this();
            }

            public final Key a(AppAutherCardModel model) {
                kotlin.jvm.internal.p.i(model, "model");
                return new Key(model.getCardId(), model.getVendorId(), model.getIntegrationId(), model.getMode());
            }

            public Companion() {
            }
        }

        public Key(String cardId, String str, String str2, String mode) {
            kotlin.jvm.internal.p.i(cardId, "cardId");
            kotlin.jvm.internal.p.i(mode, "mode");
            this.cardId = cardId;
            this.vendorId = str;
            this.integrationId = str2;
            this.mode = mode;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Key)) {
                return false;
            }
            Key key = (Key) other;
            return kotlin.jvm.internal.p.d(this.cardId, key.cardId) && kotlin.jvm.internal.p.d(this.vendorId, key.vendorId) && kotlin.jvm.internal.p.d(this.integrationId, key.integrationId) && kotlin.jvm.internal.p.d(this.mode, key.mode);
        }

        public int hashCode() {
            int iHashCode = this.cardId.hashCode() * 31;
            String str = this.vendorId;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.integrationId;
            return ((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.mode.hashCode();
        }

        public String toString() {
            return "Key(cardId=" + this.cardId + ", vendorId=" + this.vendorId + ", integrationId=" + this.integrationId + ", mode=" + this.mode + ")";
        }
    }

    public final synchronized void a(Key key) {
        kotlin.jvm.internal.p.i(key, "key");
        drafts.remove(key);
    }

    public final synchronized void b(Key key, String fieldName, String value) {
        kotlin.jvm.internal.p.i(key, "key");
        kotlin.jvm.internal.p.i(fieldName, "fieldName");
        kotlin.jvm.internal.p.i(value, "value");
        if (value.length() == 0) {
            LinkedHashMap<Key, Map<String, String>> linkedHashMap = drafts;
            Map<String, String> map = linkedHashMap.get(key);
            if (map != null) {
                map.remove(fieldName);
                if (map.isEmpty()) {
                    linkedHashMap.remove(key);
                }
            }
            return;
        }
        LinkedHashMap<Key, Map<String, String>> linkedHashMap2 = drafts;
        Map<String, String> linkedHashMap3 = linkedHashMap2.get(key);
        if (linkedHashMap3 == null) {
            linkedHashMap3 = new LinkedHashMap<>();
            linkedHashMap2.put(key, linkedHashMap3);
        }
        linkedHashMap3.put(fieldName, value);
        d();
    }

    public final synchronized Map<String, String> c(Key key) {
        Map<String, String> mapA;
        try {
            kotlin.jvm.internal.p.i(key, "key");
            Map<String, String> map = drafts.get(key);
            mapA = map != null ? kotlin.collections.a.A(map) : null;
            if (mapA == null) {
                mapA = kotlin.collections.a.i();
            }
        } catch (Throwable th) {
            throw th;
        }
        return mapA;
    }

    public final void d() {
        while (true) {
            LinkedHashMap<Key, Map<String, String>> linkedHashMap = drafts;
            if (linkedHashMap.size() <= 8) {
                return;
            }
            Iterator<Map.Entry<Key, Map<String, String>>> it = linkedHashMap.entrySet().iterator();
            if (!it.hasNext()) {
                return;
            }
            it.next();
            it.remove();
        }
    }
}

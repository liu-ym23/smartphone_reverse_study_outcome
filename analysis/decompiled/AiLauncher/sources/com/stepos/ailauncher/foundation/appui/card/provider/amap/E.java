package com.stepos.ailauncher.foundation.appui.card.provider.amap;

import N5.CardEnvelope;
import N5.CardSummary;
import Z8.C1172u;
import Z8.C1173v;
import Z8.C1174w;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.ailauncher.taskstore.provider.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import v9.C5680i;
import v9.C5685n;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/E;", "", "<init>", "()V", "", "count", "", "sameTaskId", "", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/E$a;", Const.INTENT_KEY_APIKEY, "(IZ)Ljava/util/List;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/RouteCardProvider;", "c", "()Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/RouteCardProvider;", "", "taskId", "title", "offsetIndex", "LN5/i;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;I)LN5/i;", "", "BASE_LAT", "D", "BASE_LNG", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class E {
    private static final double BASE_LAT = 39.996d;
    private static final double BASE_LNG = 116.48d;
    public static final E INSTANCE = new E();

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/E$a;", "", "", "toolCallId", "LN5/i;", "envelope", "<init>", "(Ljava/lang/String;LN5/i;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "LN5/i;", Const.INTENT_KEY_APIKEY, "()LN5/i;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.amap.E$a, reason: from toString */
    public static final /* data */ class MockCard {
        private final CardEnvelope envelope;
        private final String toolCallId;

        public MockCard(String toolCallId, CardEnvelope envelope) {
            kotlin.jvm.internal.p.i(toolCallId, "toolCallId");
            kotlin.jvm.internal.p.i(envelope, "envelope");
            this.toolCallId = toolCallId;
            this.envelope = envelope;
        }

        /* renamed from: a, reason: from getter */
        public final CardEnvelope getEnvelope() {
            return this.envelope;
        }

        /* renamed from: b, reason: from getter */
        public final String getToolCallId() {
            return this.toolCallId;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MockCard)) {
                return false;
            }
            MockCard mockCard = (MockCard) other;
            return kotlin.jvm.internal.p.d(this.toolCallId, mockCard.toolCallId) && kotlin.jvm.internal.p.d(this.envelope, mockCard.envelope);
        }

        public int hashCode() {
            return (this.toolCallId.hashCode() * 31) + this.envelope.hashCode();
        }

        public String toString() {
            return "MockCard(toolCallId=" + this.toolCallId + ", envelope=" + this.envelope + ")";
        }
    }

    public final List<MockCard> a(int count, boolean sameTaskId) {
        String str;
        if (count < 1) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        C5680i c5680iS = C5685n.s(0, count);
        ArrayList arrayList = new ArrayList(C1174w.x(c5680iS, 10));
        Iterator<Integer> it = c5680iS.iterator();
        while (it.hasNext()) {
            int iNextInt = ((Z8.M) it).nextInt();
            int i10 = iNextInt + 1;
            String str2 = "mock-tool-route-" + i10;
            if (sameTaskId) {
                str = "mock_route_task_shared";
            } else {
                str = "mock_route_task_" + i10;
            }
            arrayList.add(new MockCard(str2, INSTANCE.b(str, "导航去咖啡店 #" + i10, iNextInt)));
        }
        return arrayList;
    }

    public final CardEnvelope b(String taskId, String title, int offsetIndex) {
        double d10 = offsetIndex;
        double d11 = 0.003d * d10;
        double d12 = BASE_LAT + d11;
        double d13 = d11 + BASE_LNG;
        double d14 = 0.008d + d12;
        double d15 = 0.006d + d13;
        Pair pairA = Y8.j.a("key", "driving");
        Pair pairA2 = Y8.j.a("label", "驾车");
        Boolean bool = Boolean.TRUE;
        Map mapM = kotlin.collections.a.m(pairA, pairA2, Y8.j.a(x5.d.EXTRA_ENABLED, bool), Y8.j.a("originText", "我的位置"), Y8.j.a(c.a.COL_SUMMARY, kotlin.collections.a.m(Y8.j.a("durationText", (offsetIndex + 12) + "分钟"), Y8.j.a("distanceText", ((0.3d * d10) + 1.2d) + "公里"), Y8.j.a("tags", C1172u.e(Z8.Q.f(Y8.j.a("text", "推荐")))))), Y8.j.a("waypoints", C1173v.p(kotlin.collections.a.m(Y8.j.a("type", "origin"), Y8.j.a("name", "我的位置"), Y8.j.a("location", kotlin.collections.a.m(Y8.j.a(Const.JSON_KEY_LAT, Double.valueOf(d12)), Y8.j.a("lng", Double.valueOf(d13))))), kotlin.collections.a.m(Y8.j.a("type", "destination"), Y8.j.a("name", "Mock 咖啡 · 终点 #" + offsetIndex), Y8.j.a("location", kotlin.collections.a.m(Y8.j.a(Const.JSON_KEY_LAT, Double.valueOf(d14)), Y8.j.a("lng", Double.valueOf(d15))))))));
        Map mapM2 = kotlin.collections.a.m(Y8.j.a("key", "walking"), Y8.j.a("label", "步行"), Y8.j.a(x5.d.EXTRA_ENABLED, bool), Y8.j.a(c.a.COL_SUMMARY, kotlin.collections.a.m(Y8.j.a("durationText", ((offsetIndex * 2) + 28) + "分钟"), Y8.j.a("distanceText", ((0.2d * d10) + 2.0d) + "公里"))), Y8.j.a("waypoints", C1173v.m()));
        return new CardEnvelope(O5.c.MAP_ROUTE, taskId, null, null, null, title, null, null, Const.STR_PUBLIC_TAG, null, new CardSummary(title, "mock route · pool cap=2", null, 4, null), null, null, Z8.Q.f(Y8.j.a(DidiCardProvider.KEY_ITEMS, C1172u.e(kotlin.collections.a.m(Y8.j.a("itemId", "mock_route_item_" + offsetIndex), Y8.j.a("selectedMode", "driving"), Y8.j.a("modes", C1173v.p(mapM, mapM2)))))), null, null, null, 121564, null);
    }

    public final RouteCardProvider c() {
        return new RouteCardProvider();
    }
}

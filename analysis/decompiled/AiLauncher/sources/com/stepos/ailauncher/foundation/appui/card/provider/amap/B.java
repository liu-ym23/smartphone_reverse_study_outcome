package com.stepos.ailauncher.foundation.appui.card.provider.amap;

import N5.CardEnvelope;
import N5.CardSummary;
import Z8.C1172u;
import Z8.C1173v;
import Z8.C1174w;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import v9.C5680i;
import v9.C5685n;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\b2\u0006\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001b*\u00020\u0018H\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020 8\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010\"¨\u0006$"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/B;", "", "<init>", "()V", "", "count", "", "sameTaskId", "", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/B$a;", Const.INTENT_KEY_APIKEY, "(IZ)Ljava/util/List;", "", Const.INTENT_KEY_UMID, "()Ljava/lang/String;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/PoiListCardProvider;", "f", "()Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/PoiListCardProvider;", "taskId", "title", "offsetIndex", "LN5/i;", "e", "(Ljava/lang/String;Ljava/lang/String;I)LN5/i;", "Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/L;", Const.INTENT_KEY_PKGNAME, "(I)Ljava/util/List;", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/L;)Ljava/util/Map;", "POOL_CAPACITY", "I", "", "BASE_LAT", "D", "BASE_LNG", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class B {
    private static final double BASE_LAT = 39.996d;
    private static final double BASE_LNG = 116.48d;
    public static final B INSTANCE = new B();
    public static final int POOL_CAPACITY = 2;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/amap/B$a;", "", "", "toolCallId", "LN5/i;", "envelope", "<init>", "(Ljava/lang/String;LN5/i;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "LN5/i;", Const.INTENT_KEY_APIKEY, "()LN5/i;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.amap.B$a, reason: from toString */
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

    public static final PoiDetailCardItem c(String str, String str2, double d10, double d11, String str3, String str4) {
        return new PoiDetailCardItem(str, str, new LatLng(Double.valueOf(d10), Double.valueOf(d11)), new MapPreview(null, null, null, new MapSpec(new LatLng(Double.valueOf(d10), Double.valueOf(d11)), Float.valueOf(16.0f), C1172u.e(new MapMarker(new LatLng(Double.valueOf(d10), Double.valueOf(d11)), str2, "poi", null, null, 24, null)), null, 8, null), null, 23, null), null, str2, str3, "128条", str4, "营业中", "10:00-22:00", "望京街 mock " + str, "¥35 / 人", "适中 · 建议下午前往", "mock 多店详情，可点开 LiteSheet。", null, 32784, null);
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
            String str2 = "mock-tool-coffee-" + i10;
            if (sameTaskId) {
                str = "mock_coffee_task_shared";
            } else {
                str = "mock_coffee_task_" + i10;
            }
            arrayList.add(new MockCard(str2, INSTANCE.e(str, "附近咖啡店 #" + i10, iNextInt)));
        }
        return arrayList;
    }

    public final List<PoiBrief> b(int offsetIndex) {
        double d10 = offsetIndex * 0.0015d;
        double d11 = d10 + BASE_LAT;
        Double dValueOf = Double.valueOf(d11);
        double d12 = d10 + BASE_LNG;
        double d13 = d11 + 0.0012d;
        double d14 = d12 - 8.0E-4d;
        double d15 = d11 - 9.0E-4d;
        double d16 = d12 + 0.0011d;
        return C1173v.p(new PoiBrief("mock_cafe_" + offsetIndex + "_1", "Mock 咖啡 · 望京 #" + offsetIndex + "-A", new LatLng(dValueOf, Double.valueOf(d12)), null, null, "4.6", "350m", C1172u.e(new CardTag("咖啡", null, null, 6, null)), c("mock_cafe_" + offsetIndex + "_1", "Mock 咖啡 · 望京 #" + offsetIndex + "-A", d11, d12, "4.6", "350m"), null, 536, null), new PoiBrief("mock_cafe_" + offsetIndex + "_2", "Mock 咖啡 · 阜通 #" + offsetIndex + "-B", new LatLng(Double.valueOf(d13), Double.valueOf(d14)), null, null, "4.4", "620m", C1172u.e(new CardTag("咖啡", null, null, 6, null)), c("mock_cafe_" + offsetIndex + "_2", "Mock 咖啡 · 阜通 #" + offsetIndex + "-B", d13, d14, "4.4", "620m"), null, 536, null), new PoiBrief("mock_cafe_" + offsetIndex + "_3", "Mock 咖啡 · 湖光 #" + offsetIndex + "-C", new LatLng(Double.valueOf(d15), Double.valueOf(d16)), null, null, "4.8", "890m", C1172u.e(new CardTag("咖啡", null, null, 6, null)), c("mock_cafe_" + offsetIndex + "_3", "Mock 咖啡 · 湖光 #" + offsetIndex + "-C", d15, d16, "4.8", "890m"), null, 536, null));
    }

    public final String d() {
        return com.stepos.ailauncher.amap.route.K.INSTANCE.I();
    }

    public final CardEnvelope e(String taskId, String title, int offsetIndex) {
        List<PoiBrief> listB = b(offsetIndex);
        CardSummary cardSummary = new CardSummary(title, "mock · " + listB.size() + " 家 · pool cap=2", null, 4, null);
        double d10 = ((double) offsetIndex) * 0.002d;
        Pair pairA = Y8.j.a("mapPreview", Z8.Q.f(Y8.j.a("spec", kotlin.collections.a.m(Y8.j.a("center", kotlin.collections.a.m(Y8.j.a(Const.JSON_KEY_LAT, Double.valueOf(BASE_LAT + d10)), Y8.j.a("lng", Double.valueOf(d10 + BASE_LNG)))), Y8.j.a("zoom", Float.valueOf(15.0f))))));
        List<PoiBrief> list = listB;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(INSTANCE.g((PoiBrief) it.next()));
        }
        return new CardEnvelope(O5.c.MAP_POI_LIST, taskId, null, null, null, title, null, null, Const.STR_PUBLIC_TAG, null, cardSummary, null, null, kotlin.collections.a.m(pairA, Y8.j.a(DidiCardProvider.KEY_ITEMS, arrayList)), null, null, null, 121564, null);
    }

    public final PoiListCardProvider f() {
        return new PoiListCardProvider();
    }

    public final Map<String, Object> g(PoiBrief poiBrief) {
        Map mapM;
        Map mapF;
        LatLng center;
        LatLng center2;
        Pair pairA = Y8.j.a("poiId", poiBrief.getPoiId());
        Pair pairA2 = Y8.j.a("name", poiBrief.getName());
        LatLng location = poiBrief.getLocation();
        Pair pairA3 = Y8.j.a(Const.JSON_KEY_LAT, location != null ? location.getLat() : null);
        LatLng location2 = poiBrief.getLocation();
        Pair pairA4 = Y8.j.a("location", kotlin.collections.a.m(pairA3, Y8.j.a("lng", location2 != null ? location2.getLng() : null)));
        Pair pairA5 = Y8.j.a("rating", poiBrief.getRating());
        Pair pairA6 = Y8.j.a("distanceText", poiBrief.getDistanceText());
        List<CardTag> listH = poiBrief.h();
        ArrayList arrayList = new ArrayList(C1174w.x(listH, 10));
        Iterator<T> it = listH.iterator();
        while (it.hasNext()) {
            arrayList.add(Z8.Q.f(Y8.j.a("text", ((CardTag) it.next()).getText())));
        }
        Pair pairA7 = Y8.j.a("tags", arrayList);
        PoiDetailCardItem detail = poiBrief.getDetail();
        if (detail != null) {
            Pair pairA8 = Y8.j.a("itemId", detail.getItemId());
            Pair pairA9 = Y8.j.a("poiId", detail.getPoiId());
            Pair pairA10 = Y8.j.a("name", detail.getName());
            LatLng location3 = detail.getLocation();
            Pair pairA11 = Y8.j.a(Const.JSON_KEY_LAT, location3 != null ? location3.getLat() : null);
            LatLng location4 = detail.getLocation();
            Pair pairA12 = Y8.j.a("location", kotlin.collections.a.m(pairA11, Y8.j.a("lng", location4 != null ? location4.getLng() : null)));
            Pair pairA13 = Y8.j.a("rating", detail.getRating());
            Pair pairA14 = Y8.j.a("reviewCountText", detail.getReviewCountText());
            Pair pairA15 = Y8.j.a("distanceText", detail.getDistanceText());
            Pair pairA16 = Y8.j.a("statusText", detail.getStatusText());
            Pair pairA17 = Y8.j.a("businessHoursText", detail.getBusinessHoursText());
            Pair pairA18 = Y8.j.a(Const.JSON_KEY_ADDRESS, detail.getAddressText());
            Pair pairA19 = Y8.j.a("priceText", detail.getPriceText());
            Pair pairA20 = Y8.j.a("tipText", detail.getTipText());
            Pair pairA21 = Y8.j.a("description", detail.getDescription());
            MapPreview mapPreview = detail.getMapPreview();
            if (mapPreview != null) {
                MapSpec spec = mapPreview.getSpec();
                Pair pairA22 = Y8.j.a(Const.JSON_KEY_LAT, (spec == null || (center2 = spec.getCenter()) == null) ? null : center2.getLat());
                MapSpec spec2 = mapPreview.getSpec();
                Pair pairA23 = Y8.j.a("center", kotlin.collections.a.m(pairA22, Y8.j.a("lng", (spec2 == null || (center = spec2.getCenter()) == null) ? null : center.getLng())));
                MapSpec spec3 = mapPreview.getSpec();
                mapF = Z8.Q.f(Y8.j.a("spec", kotlin.collections.a.m(pairA23, Y8.j.a("zoom", spec3 != null ? spec3.getZoom() : null))));
            } else {
                mapF = null;
            }
            mapM = kotlin.collections.a.m(pairA8, pairA9, pairA10, pairA12, pairA13, pairA14, pairA15, pairA16, pairA17, pairA18, pairA19, pairA20, pairA21, Y8.j.a("mapPreview", mapF));
        } else {
            mapM = null;
        }
        return kotlin.collections.a.m(pairA, pairA2, pairA4, pairA5, pairA6, pairA7, Y8.j.a("detail", mapM));
    }
}

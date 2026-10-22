package com.bytedance.android.live.revlink.link.core.service;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.link.player.DeviceType;
import com.bytedance.android.live.revlink.impl.multianchor.model.WindowType;
import com.bytedance.android.live.revlink.impl.plantform.AnchorLinkUserCenterV2;
import com.bytedance.android.live.revlink.link.core.layoutstatus.LayoutSnapShotCollect;
import com.bytedance.android.live.revlink.link.dynamiclayout.model.AnchorHeightFixMode;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes47.dex */
public final class AnchorDynamicLayoutImpl {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f98316g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o51.b f98317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LayoutSnapShotCollect f98318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.link.infra.rtcbiz.b f98319c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AnchorLinkUserCenterV2 f98320d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AnchorLayoutDataContext f98321e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g f98322f;

    public static final class a {
    }

    static {
    }

    public final String b(String r100) {
        com.bytedance.android.livesdk.link.model.p r101 = this.f98320d.getGuestInfo(null, r100);
        if (r101 == null) goto L11;
        IBaseUser r102 = r101.getUser();
        if (r102 == null) goto L12;
        String r103 = iz.a.a(r102);
        if (r103 != null) goto L10;
        return r100;
    L10:
        return r103;
    L12:
        return r100;
    L11:
        return r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r25v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v14, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21 */
    public static final void a(AnchorDynamicLayoutImpl r310, com.bytedance.android.live.revlink.link.core.layoutstatus.n r311) {
        r310.getClass();
        o51.e r100 = r311.f98309a;
        com.bytedance.android.live.revlink.link.core.layoutstatus.f r101 = r311.f98310b;
        Map<String, com.bytedance.android.live.revlink.link.infra.rtcbiz.d> r102 = r311.f98311c;
        List<Long> r103 = r311.f98312d;
        Map<String, Integer> r104 = r311.f98313e;
        Map<String, com.bytedance.android.live.revlink.link.core.layoutstatus.i> r105 = r311.f98314f;
        com.bytedance.android.live.revlink.link.core.layoutstatus.l r106 = r311.f98315g;
        String r110 = null;
        jy0.b.c("RevenueDynamicLayoutClient", "onSnapShotRefresh with layoutConfigSnap=" + r101 + ", validStream=" + r102 + ", forwardControl=" + r103 + ", anchorPosition=" + r104, null, 4);
        if (r100 == null) goto L311;
        if (r101 == null) goto L312;
        if (r102 == null) goto L313;
        if (r103 == null) goto L314;
        if (r104 == null) goto L315;
        if (r105 == null) goto L316;
        if (r106 == null) goto L317;
        Set<String> r107 = r102.keySet();
        ArrayList r111 = new ArrayList();
        Iterator r108 = r107.iterator();
    L19:
        if (r108.hasNext() == false) goto L54;
        Object r112 = r108.next();
        String r113 = (String) r112;
        com.bytedance.android.livesdk.link.model.p r114 = r310.f98320d.getGuestInfo(r110, r113);
        if (r114 == null) goto L25;
        IBaseUser r115 = r114.getUser();
        if (r115 == null) goto L25;
        Object r116 = Long.valueOf(com.bytedance.android.live.base.model.user.n.a(r115));
    L26:
        List<Long> r117 = r103;
        List<Long> r118 = r103;
        boolean r109 = CollectionsKt.contains(r117, r116);
        Map<String, Integer> r210 = r104;
        com.bytedance.android.live.revlink.link.core.layoutstatus.i r119 = r105.get(r113);
        Iterator r120 = r108;
        o51.e r211 = r100;
        Map<String, com.bytedance.android.live.revlink.link.infra.rtcbiz.d> r212 = r102;
        jy0.b.d("RevenueDynamicLayoutClient", "filter remote valid linker id " + r113 + ", guestInfo " + r114 + ", guestLiveRoomId " + r116 + ", contains " + r109 + ", handler " + r119 + ", accept " + com.bytedance.android.live.revlink.link.core.layoutstatus.k.a(r119));
        com.bytedance.android.livesdk.link.model.p r121 = r310.f98320d.getGuestInfo(null, r113);
        if (r121 == null) goto L35;
        IBaseUser r122 = r121.getUser();
        if (r122 == null) goto L35;
        Intrinsics.checkNotNullParameter(r122, "$this$ownRoomExt");
        py.o r123 = r122.getOwnRoom();
        if (r123 == null) goto L35;
        List<String> r124 = r123.getRoomIdStrList();
        if (r124 == null) goto L35;
        String r125 = (String) ListProtector.get(r124, 0);
    L36:
        if (r125 == null) goto L38;
        Long r126 = Long.valueOf(CastLongProtector.parseLong(r125));
    L39:
        com.bytedance.android.livesdk.link.model.p r127 = r310.f98320d.getGuestInfo(null, r113);
        if (r127 == null) goto L44;
        IBaseUser r128 = r127.getUser();
        if (r128 == null) goto L44;
        Long r129 = Long.valueOf(com.bytedance.android.live.base.model.user.n.a(r128));
    L45:
        jy0.b.d("RevenueDynamicLayoutClient", "filter remote valid linker id, roomIdStr " + r125 + ", roomIdLong " + r126 + ", liveRoomIdExt " + r129);
        if (CollectionsKt.contains(r117, r126) == true) goto L48;
    L50:
        boolean r130 = false;
    L51:
        if (r130 == false) goto L53;
        r111.add(r112);
    L53:
        r103 = r118;
        r108 = r120;
        r104 = r210;
        r100 = r211;
        r102 = r212;
        r110 = null;
        goto L19
    L48:
        if (com.bytedance.android.live.revlink.link.core.layoutstatus.k.a(r105.get(r113)) == false) goto L50;
        r130 = true;
    L44:
        r129 = null;
        goto L45
    L38:
        r126 = null;
    L35:
        r125 = null;
    L25:
        r116 = r110;
        goto L26
    L54:
        o51.e r213 = r100;
        Map<String, com.bytedance.android.live.revlink.link.infra.rtcbiz.d> r214 = r102;
        Map<String, Integer> r215 = r104;
        List r131 = CollectionsKt.mutableListOf(new String[]{r310.f98322f.Zl()});
        r131.addAll(r111);
        Unit r132 = Unit.INSTANCE;
        int r133 = r106.f98306a - r131.size();
        if (r133 <= 0) goto L62;
        if (1 > r133) goto L62;
        int r134 = 1;
    L59:
        r131.add("fake_linker_" + r134);
        if (r134 == r133) goto L62;
        r134 = r134 + 1;
    L62:
        int r135 = r131.size();
        t51.g r136 = r101.f98292b;
        t51.a r137 = r136.a(DeviceType.NORMAL_MOBILE, r135);
        if (r137 == null) goto L65;
        int r138 = r137.d();
    L66:
        if (r137 == null) goto L68;
        int r139 = com.bytedance.android.live.revenue.common.i.b(r137.e());
    L69:
        int r140 = r310.f98322f.getContainerWidth();
        if (r138 != AnchorHeightFixMode.OriginContainerHeight.ordinal()) goto L73;
        int r141 = r310.f98322f.l();
    L80:
        List<t51.e> r142 = r136.e().get(Integer.valueOf(r135));
        if (r142 == null) goto L318;
        List<t51.b> r143 = r136.d().get(Integer.valueOf(r135));
        List<t51.b> r144 = r136.f().get(Integer.valueOf(r135));
        if (r137 == null) goto L87;
        t51.c r145 = r137.i();
        if (r145 == null) goto L87;
    L88:
        t51.c r146 = r145;
        jy0.b.c("RevenueDynamicLayoutClient", "onSnapShotRefresh get layout count " + r135 + " config with config: " + r142 + ", mixStreamConfig: " + r143 + ", and seiConfig=" + r144, null, 4);
        Map<String, Integer> r147 = r106.f98307b;
        if (r147 != null) goto L91;
        r147 = r215;
    L91:
        Map r148 = MapsKt.toMutableMap(r147);
        LinkedHashMap r149 = new LinkedHashMap();
        ArrayList r150 = new ArrayList();
        IntRange r151 = RangesKt.until(0, r135);
        int r312 = r139;
        LinkedHashMap r152 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r151, 10)), 16));
        Iterator<Integer> r153 = r151.iterator();
    L93:
        if (r153.hasNext() == false) goto L95;
        Integer r154 = r153.next();
        r154.intValue();
        r152.put(r154, Boolean.TRUE);
        goto L93
    L95:
        Map r155 = MapsKt.toMutableMap(r152);
        LinkedHashMap r156 = new LinkedHashMap();
        List r157 = r131;
        Iterator r158 = r157.iterator();
    L97:
        if (r158.hasNext() == false) goto L102;
        String r159 = r310.b((String) r158.next());
        Iterator r216 = r158;
        Integer r160 = (Integer) r148.get(r159);
        if (r160 == null) goto L101;
        r156.put(r159, r160);
    L101:
        r158 = r216;
        goto L97
    L102:
        Iterator r161 = r157.iterator();
    L103:
        List<t51.b> r313 = r144;
        if (r161.hasNext() == false) goto L123;
        String r162 = (String) r161.next();
        Integer r163 = (Integer) r148.get(r310.b(r162));
        if (r163 == null) goto L108;
        int r164 = r163.intValue();
        int r165 = -1;
    L109:
        if (r164 != r165) goto L119;
        r150.add(r162);
        Map<String, com.bytedance.android.live.revlink.link.infra.rtcbiz.d> r166 = r214;
        if (r166.containsKey(r162) == false) goto L113;
    L116:
        boolean r167 = true;
    L117:
        r149.put(r162, Boolean.valueOf(r167));
        r214 = r166;
    L122:
        r161 = r161;
        r144 = r313;
        goto L103
    L113:
        if (Intrinsics.areEqual(r162, r310.f98322f.Zl()) == true) goto L116;
        r167 = false;
        goto L117
    L119:
        if (r155.containsKey(Integer.valueOf(r164)) == false) goto L121;
        r155.put(Integer.valueOf(r164), Boolean.FALSE);
    L121:
        r149.put(r162, Boolean.TRUE);
        goto L122
    L108:
        r165 = -1;
        r164 = -1;
        goto L109
    L123:
        Iterator r168 = r150.iterator();
    L125:
        if (r168.hasNext() == false) goto L140;
        String r169 = (String) r168.next();
        LinkedHashMap r170 = new LinkedHashMap();
        Iterator r171 = r155.entrySet().iterator();
    L128:
        if (r171.hasNext() == false) goto L132;
        Map.Entry r217 = (Map.Entry) r171.next();
        if (((Boolean) r217.getValue()).booleanValue() == false) goto L128;
        r170.put(r217.getKey(), r217.getValue());
        r168 = r168;
        r171 = r171;
        goto L128
    L132:
        Iterator r218 = r168;
        ArrayList r172 = new ArrayList(r170.size());
        Iterator r173 = r170.entrySet().iterator();
    L134:
        if (r173.hasNext() == false) goto L136;
        r172.add(Integer.valueOf(((Number) ((Map.Entry) r173.next()).getKey()).intValue()));
        goto L134
    L136:
        Integer r174 = (Integer) CollectionsKt.firstOrNull(r172);
        if (r174 == null) goto L139;
        int r175 = r174.intValue();
        r155.put(Integer.valueOf(r175), Boolean.FALSE);
        r148.put(r310.b(r169), Integer.valueOf(r175));
        r156.put(r310.b(r169), Integer.valueOf(r175));
    L139:
        r168 = r218;
        goto L125
    L140:
        Iterator r176 = r156.entrySet().iterator();
        int r177 = -1;
    L142:
        if (r176.hasNext() == false) goto L144;
        r177 = RangesKt.coerceAtLeast(r177, ((Number) ((Map.Entry) r176.next()).getValue()).intValue());
        goto L142
    L144:
        jy0.b.c("RevenueDynamicLayoutClient", "max position: " + r177 + " and count: " + r135, null, 4);
        StringBuilder r178 = new StringBuilder("safePositionMap: ");
        r178.append(r156);
        jy0.b.c("RevenueDynamicLayoutClient", r178.toString(), null, 4);
        r310.f98317a.getClass();
        Intrinsics.checkNotNullParameter(r156, "anchorPosition");
        Intrinsics.checkNotNullParameter(r213, "uiLayout");
        if ((r213 instanceof o51.e.f) == false) goto L147;
    L177:
        LinkedHashMap r179 = new LinkedHashMap(MapsKt.mapCapacity(r156.size()));
        Iterator r180 = r156.entrySet().iterator();
    L179:
        if (r180.hasNext() == false) goto L181;
        Map.Entry r181 = (Map.Entry) r180.next();
        r179.put(r181.getKey(), TuplesKt.to(r181.getValue(), 0));
    L181:
        Pair r182 = TuplesKt.to(r179, r149);
        Map r183 = (Map) r182.component1();
        Map r184 = (Map) r182.component2();
        LinkedHashMap r185 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r157, 10)), 16));
        Iterator r186 = r157.iterator();
    L183:
        if (r186.hasNext() == false) goto L204;
        Object r187 = r186.next();
        String r188 = (String) r187;
        Pair r189 = (Pair) r183.get(r310.b(r188));
        if (r189 != null) goto L187;
        r189 = TuplesKt.to(-1, 0);
    L187:
        int r190 = ((Number) r189.component1()).intValue();
        int r219 = ((Number) r189.component2()).intValue();
        Iterator r191 = r142.iterator();
    L189:
        if (r191.hasNext() == false) goto L197;
        Object r220 = r191.next();
        Iterator r314 = r186;
        if (((t51.e) r220).b() != r190) goto L193;
        boolean r192 = true;
    L194:
        if (r192 == true) goto L198;
        r186 = r314;
    L198:
        t51.e r221 = (t51.e) r220;
        if (r221 != null) goto L201;
        t51.e r222 = new t51.e();
    L202:
        r185.put(r187, c(r188, r222, r140, r141, Integer.valueOf(r190), r219, r143, r313, r312, Intrinsics.areEqual((Boolean) r184.get(r188), Boolean.TRUE)));
        r186 = r314;
        goto L183
    L201:
        r222 = r221;
        goto L202
    L193:
        r192 = false;
        goto L194
    L197:
        r314 = r186;
        r220 = null;
        goto L198
    L204:
        if ((r213 instanceof o51.e.c) == false) goto L210;
        y41.f r193 = y41.f.N;
        r193.getClass();
        if (((Boolean) y41.f.I.getValue(r193, y41.f.f565960a[33])).booleanValue() == false) goto L210;
        if (r214.size() <= 3) goto L210;
        boolean r194 = true;
    L211:
        if (r137 == null) goto L215;
        t51.d r195 = r137.c();
        if (r195 == null) goto L215;
        float r196 = r195.b();
    L216:
        float r197 = r141;
        int r198 = (int) (r196 * r197);
        if (r137 == null) goto L221;
        t51.d r199 = r137.c();
        if (r199 == null) goto L221;
        float r1100 = r199.a();
    L222:
        float r1101 = r140;
        int r1102 = (int) (r1100 * r1101);
        if ((r213 instanceof o51.e.i) == true) goto L225;
        int r223 = r135;
        int r315 = r198;
        ?? r200 = CollectionsKt.emptyList();
    L243:
        if ((r213 instanceof o51.e.h) == true) goto L246;
    L265:
        n r224 = null;
    L266:
        Matrix r316 = o51.a.a(new RectF(0.0f, 0.0f, 1.0f, 1.0f), new RectF(0.0f, 0.0f, r1101, r197));
        jy0.b.c("RevenueDynamicLayoutClient", "onSnapShotRefresh with containerHeight: " + r141 + ", containerWidth: " + r140 + " and frames=" + r185, null, 4);
        NextLiveData<p> r201 = r310.f98321e.getLayoutFrame();
        o51.e r202 = r310.f98318b.f98279k;
        if (r194 == false) goto L269;
        g r317 = new g(r1102, r315);
    L270:
        r201.setValue(new p(r185, r200, r224, r146, r223, r202, r316, r317, Integer.valueOf(r141), Integer.valueOf(r140)));
        return;
    L269:
        r317 = null;
        goto L270
    L246:
        if (((o51.e.h) r213).f522050e == false) goto L248;
        int r203 = 10002;
    L249:
        List<t51.e> r204 = r136.e().get(2);
        if (r204 == null) goto L265;
        Iterator r205 = r204.iterator();
    L253:
        if (r205.hasNext() == false) goto L260;
        Object r206 = r205.next();
        if (((t51.e) r206).b() != r203) goto L257;
        boolean r1103 = true;
    L258:
        if (r1103 == false) goto L253;
    L261:
        t51.e r225 = (t51.e) r206;
        if (r225 == null) goto L265;
        r224 = c("", r225, r140, r141, 0, 0, r136.d().get(2), r136.f().get(2), r312, true);
        goto L266
    L257:
        r1103 = false;
        goto L258
    L260:
        r206 = null;
        goto L261
    L248:
        r203 = 10001;
        goto L249
    L225:
        List<t51.b> r1104 = r136.d().get(2);
        List<t51.b> r207 = r136.f().get(2);
        r223 = r135;
        List<t51.e> r208 = r136.e().get(2);
        if (r208 == null) goto L241;
        ArrayList r1105 = new ArrayList();
        Iterator r209 = r208.iterator();
    L229:
        if (r209.hasNext() == false) goto L237;
        Object r1106 = r209.next();
        Iterator r226 = r209;
        int r318 = r198;
        if (((t51.e) r1106).getType() != WindowType.Guest.ordinal()) goto L233;
        boolean r227 = true;
    L234:
        if (r227 == false) goto L236;
        r1105.add(r1106);
    L236:
        r209 = r226;
        r198 = r318;
        goto L229
    L233:
        r227 = false;
        goto L234
    L237:
        r315 = r198;
        r200 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1105, 10));
        Iterator r228 = r1105.iterator();
    L239:
        if (r228.hasNext() == false) goto L243;
        t51.e r229 = (t51.e) r228.next();
        r200.add(c("", r229, r140, r141, Integer.valueOf(r229.b()), 20000, r1104, r207, r312, true));
        goto L239
    L241:
        r315 = r198;
        r200 = CollectionsKt.emptyList();
    L221:
        r1100 = 0.0f;
    L215:
        r196 = 0.0f;
    L210:
        r194 = false;
        goto L211
    L147:
        if ((r213 instanceof o51.e.d) == true) goto L177;
        if ((r213 instanceof o51.e.c) == true) goto L177;
        if ((r213 instanceof o51.e.g) == true) goto L177;
        if ((r213 instanceof o51.e.h) == true) goto L177;
        if ((r213 instanceof o51.e.C7015e) == true) goto L177;
        if ((r213 instanceof o51.e.a) == true) goto L177;
        if ((r213 instanceof o51.e.i) == false) goto L176;
        o51.e.i r230 = (o51.e.i) r213;
        r179 = new LinkedHashMap(MapsKt.mapCapacity(r156.size()));
        Iterator r231 = r156.entrySet().iterator();
    L163:
        if (r231.hasNext() == false) goto L181;
        Map.Entry r1107 = (Map.Entry) r231.next();
        Object r1108 = r1107.getKey();
        String r1109 = (String) r1107.getKey();
        int r1110 = ((Number) r1107.getValue()).intValue();
        Iterator r232 = r231;
        if (Intrinsics.areEqual(r1109, r230.f522054g) == false) goto L169;
        if (r230.f522052e == false) goto L169;
    L172:
        r1110 = r1110 + 30000;
        int r233 = 30000;
    L174:
        r179.put(r1108, TuplesKt.to(Integer.valueOf(r1110), Integer.valueOf(r233)));
        r231 = r232;
    L169:
        if (Intrinsics.areEqual(r1109, r230.f522055h) == true) goto L171;
    L173:
        r233 = 0;
        goto L174
    L171:
        if (r230.f522053f == false) goto L173;
    L176:
        throw new NoWhenBranchMatchedException();
    L87:
        r145 = new t51.c();
        goto L88
    L318:
        return;
    L73:
        if (r138 != AnchorHeightFixMode.RationTransformHeight.ordinal()) goto L76;
        int r234 = r310.f98322f.getContainerWidth();
    L79:
        r141 = (int) ((((double) r234) / 9.0d) * 16.0d);
        goto L80
    L76:
        if (r138 != AnchorHeightFixMode.PreviewHeight.ordinal()) goto L78;
        r141 = r310.f98322f.f98691n;
        goto L80
    L78:
        r234 = r310.f98322f.getContainerWidth();
        goto L79
    L68:
        r139 = 0;
        goto L69
    L65:
        r138 = AnchorHeightFixMode.RationTransformHeight.ordinal();
        goto L66
    L317:
        return;
    L316:
        return;
    L315:
        return;
    L314:
        return;
    L313:
        return;
    L312:
        return;
    }

    public AnchorDynamicLayoutImpl(s r100, com.bytedance.android.live.revlink.link.infra.rtcbiz.b r101, AnchorLinkUserCenterV2 r102, AnchorLayoutDataContext r110, com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g r111) {
        Intrinsics.checkNotNullParameter(r100, "dynamicLayoutClient");
        Intrinsics.checkNotNullParameter(r101, "rtcDataContext");
        Intrinsics.checkNotNullParameter(r102, "anchorLinkUserCenter");
        Intrinsics.checkNotNullParameter(r110, "anchorLayoutDataContext");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f98319c = r101;
        this.f98320d = r102;
        this.f98321e = r110;
        this.f98322f = r111;
        this.f98317a = new o51.b(r111);
        this.f98318b = new LayoutSnapShotCollect(r100, r101, r102, r111, new AnchorDynamicLayoutImpl$layoutSnapShotCollect$1(this));
    }

    public static n c(String r110, t51.e r111, int r112, int r113, Integer r114, int r115, List r116, List r210, int r211, boolean r212) {
        float r100 = r112;
        int r101 = (int) (r111.e() * r100);
        float r102 = r113;
        int r103 = ((int) (r111.f() * r102)) + r211;
        int r104 = (int) (r111.d() * r100);
        int r105 = (int) (r111.a() * r102);
        if (r114 == null) goto L5;
        int r106 = r114.intValue();
    L6:
        q r117 = new q(r110, r101, r103, r104, r105, r106 - r115, r111.g(), r111.getType(), r111.c(), r212);
        Object r107 = null;
        if (r116 == null) goto L23;
        Iterator r108 = r116.iterator();
    L10:
        if (r108.hasNext() == false) goto L20;
        Object r109 = r108.next();
        int r118 = ((t51.b) r109).b();
        if (r114 != null) goto L15;
    L17:
        boolean r119 = false;
    L18:
        if (r119 == false) goto L10;
    L21:
        t51.b r120 = (t51.b) r109;
        if (r120 == null) goto L23;
    L24:
        if (r210 == null) goto L39;
        Iterator r121 = r210.iterator();
    L27:
        if (r121.hasNext() == false) goto L37;
        Object r122 = r121.next();
        int r123 = ((t51.b) r122).b();
        if (r114 != null) goto L32;
    L34:
        boolean r124 = false;
    L35:
        if (r124 == false) goto L27;
        r107 = r122;
        goto L37
    L32:
        if (r123 != r114.intValue()) goto L34;
        r124 = true;
    L37:
        t51.b r125 = (t51.b) r107;
        if (r125 == null) goto L39;
    L41:
        return new n(r117, r111, r120, r125);
    L39:
        r125 = r111;
        goto L41
    L15:
        if (r118 != r114.intValue()) goto L17;
        r119 = true;
        goto L18
    L20:
        r109 = null;
    L23:
        r120 = r111;
        goto L24
    L5:
        r106 = 0;
        goto L6
    }
}

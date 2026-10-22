package com.bytedance.android.ec.hybrid.list.entity.dto;

import androidx.camera.video.AudioStats;
import com.bytedance.android.ec.hybrid.api.card.mita.ECHybridMitaCardConfig;
import com.bytedance.android.ec.hybrid.list.ECHybridListItemType;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.f;
import com.bytedance.android.ec.hybrid.list.entity.i;
import com.bytedance.android.ec.hybrid.list.entity.k;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kk.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u000b\u0018\u0000 >2\u00020\u0001:\u00018B\u0007¢\u0006\u0004\b<\u0010=J\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002R$\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR2\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R*\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010#\u001a\u00020\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020\"8\u0006X\u0087D¢\u0006\f\n\u0004\b)\u0010$\u001a\u0004\b*\u0010&R\u001c\u0010+\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001c\u0010/\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010,\u001a\u0004\b0\u0010.R0\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u0010\u000e\u001a\u0004\b2\u0010\u0010\"\u0004\b3\u0010\u0012R0\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u000204\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u0010\u000e\u001a\u0004\b6\u0010\u0010\"\u0004\b7\u0010\u0012R\"\u0010;\u001a\u00020\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u0010$\u001a\u0004\b9\u0010&\"\u0004\b:\u0010(¨\u0006?"}, d2 = {"Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListDTO;", "Ljava/io/Serializable;", "", "", "mapItemTypeToSchema", "Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListStyleDTO;", "listStyle", "Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListStyleDTO;", "getListStyle", "()Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListStyleDTO;", "setListStyle", "(Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListStyleDTO;)V", "Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECListItemConfigDTO;", "itemConfigs", "Ljava/util/Map;", "getItemConfigs", "()Ljava/util/Map;", "setItemConfigs", "(Ljava/util/Map;)V", "", "Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListSectionDTO;", "sections", "Ljava/util/List;", "getSections", "()Ljava/util/List;", "setSections", "(Ljava/util/List;)V", "", EffectConfiguration.KEY_CURSOR, "I", "getCursor", "()I", "setCursor", "(I)V", "", "hasMore", "Z", "getHasMore", "()Z", "setHasMore", "(Z)V", "keepSelectedTabOnRefresh", "getKeepSelectedTabOnRefresh", "preRequestCount", "Ljava/lang/Integer;", "getPreRequestCount", "()Ljava/lang/Integer;", "nextPageCount", "getNextPageCount", "extra", "getExtra", "setExtra", "", "commonLogData", "getCommonLogData", "setCommonLogData", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "getFastPathInjected", "setFastPathInjected", "fastPathInjected", "<init>", "()V", "Companion", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECHybridListDTO implements Serializable {
    public static final a Companion = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f47082b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient boolean f47083a;

    @SerializedName("common_log_data")
    private Map<String, ? extends Object> commonLogData;

    @SerializedName(EffectConfiguration.KEY_CURSOR)
    private int cursor;

    @SerializedName("extra")
    private Map<String, String> extra;

    @SerializedName("has_more")
    private boolean hasMore;

    @SerializedName("item_configs")
    private Map<String, ECListItemConfigDTO> itemConfigs;

    @SerializedName("refresh_keep_select")
    private final boolean keepSelectedTabOnRefresh;

    @SerializedName("list_style")
    private ECHybridListStyleDTO listStyle;

    @SerializedName("next_page_count")
    private final Integer nextPageCount;

    @SerializedName("pre_request_count")
    private final Integer preRequestCount;

    @SerializedName("sections")
    private List<ECHybridListSectionDTO> sections;

    public static final class a {
        public a() {
        }

        public static boolean b(Integer r100) {
            if (r100 != null) goto L5;
        L6:
            if (r100 != null) goto L9;
        L10:
            int r101 = ECHybridListItemType.NATIVE_FLEXIBLE_PRODUCT_CARD.getType();
            if (r100 != null) goto L14;
        L16:
            return false;
        L14:
            if (r100.intValue() != r101) goto L16;
        L17:
            return true;
        L9:
            if (r100.intValue() == 1002) goto L17;
        L5:
            if (r100.intValue() == 1001) goto L17;
            goto L6
        }

        public static void a(final k r100, final k r110) {
            Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
            if (((Boolean) ECHybridListDTO.access$getReorderOptimizeEnable$cp().getValue()).booleanValue() == false) goto L6;
            d.c(new ECHybridListDTO$Companion$handleNativeCardWithLastCacheDataOptimize$1(r110, r100));
            return;
        L6:
            if (r110 != null) goto L8;
            return;
        L8:
            ArrayList<i> r101 = r110.f47130c;
            int r102 = -1;
            int r103 = 0;
            Integer r104 = null;
            if (r101 == null) goto L19;
            Iterator<i> r105 = r101.iterator();
            int r106 = 0;
        L12:
            if (r105.hasNext() == false) goto L17;
            if (Intrinsics.areEqual(r105.next().f47107a, "favorite_section") == true) goto L18;
            r106 = r106 + 1;
        L18:
            Integer r107 = Integer.valueOf(r106);
        L20:
            if (r107 != null) goto L22;
            return;
        L22:
            if (r107.intValue() < 0) goto L94;
            ArrayList<i> r111 = r110.f47130c;
            Intrinsics.checkNotNull(r111);
            i r112 = (i) ListProtector.get(r111, r107.intValue());
            ArrayList<ECHybridListItemVO> r108 = r112.f47115i;
            if (r108 != null) goto L27;
        L30:
            boolean r109 = true;
        L31:
            if (r109 == false) goto L33;
            return;
        L33:
            ArrayList<ECHybridListItemVO> r113 = r112.f47115i;
            Intrinsics.checkNotNull(r113);
            ArrayList r114 = new ArrayList();
            Iterator<T> r115 = r113.iterator();
        L35:
            if (r115.hasNext() == false) goto L39;
            Object r116 = r115.next();
            a r117 = ECHybridListDTO.Companion;
            Integer r118 = ((ECHybridListItemVO) r116).f47028c;
            r117.getClass();
            if (b(r118) == false) goto L35;
            r114.add(r116);
            goto L35
        L39:
            List r119 = CollectionsKt.toMutableList(r114);
            List r120 = r119;
            if (r120 != null) goto L42;
        L45:
            boolean r121 = true;
        L46:
            if (r121 == false) goto L48;
            return;
        L48:
            ArrayList<i> r122 = r100.f47130c;
            if (r122 == null) goto L58;
            Iterator<i> r123 = r122.iterator();
            int r124 = 0;
        L52:
            if (r123.hasNext() == false) goto L57;
            if (Intrinsics.areEqual(r123.next().f47107a, "favorite_section") == true) goto L55;
            r124 = r124 + 1;
            goto L52
        L55:
            r102 = r124;
        L57:
            r104 = Integer.valueOf(r102);
        L58:
            if (r104 != null) goto L60;
            return;
        L60:
            if (r104.intValue() < 0) goto L93;
            ArrayList<i> r125 = r100.f47130c;
            Intrinsics.checkNotNull(r125);
            i r126 = (i) ListProtector.get(r125, r104.intValue());
            ArrayList<ECHybridListItemVO> r127 = r126.f47115i;
            if (r127 != null) goto L64;
        L67:
            boolean r128 = true;
        L68:
            if (r128 == false) goto L70;
            return;
        L70:
            ArrayList<ECHybridListItemVO> r129 = r126.f47115i;
            Intrinsics.checkNotNull(r129);
            int r130 = RangesKt.coerceAtMost(4, r129.size());
        L71:
            if (r103 >= r130) goto L95;
            ArrayList<ECHybridListItemVO> r131 = r126.f47115i;
            Intrinsics.checkNotNull(r131);
            if (b(((ECHybridListItemVO) ListProtector.get(r131, r103)).f47028c) == true) goto L77;
            if (r119.size() <= 0) goto L96;
            ECHybridListItemVO r132 = (ECHybridListItemVO) ListProtector.get(r119, r119.size() - 1);
            ArrayList<ECHybridListItemVO> r133 = r126.f47115i;
            Intrinsics.checkNotNull(r133);
            ListProtector.set(r133, r103, r132);
            ListProtector.remove(r119, r119.size() - 1);
            goto L77
        L96:
            return;
        L77:
            r103 = r103 + 1;
            goto L71
        L95:
            return;
        L64:
            if (r127.isEmpty() == true) goto L67;
            r128 = false;
            goto L68
        L93:
            return;
        L42:
            if (r120.isEmpty() == true) goto L45;
            r121 = false;
            goto L46
        L27:
            if (r108.isEmpty() == true) goto L30;
            r109 = false;
            goto L31
        L94:
            return;
        L17:
            r106 = -1;
            goto L18
        L19:
            r107 = null;
            goto L20
        }

        public static /* synthetic */ k e(a r100, ECHybridListDTO r101) {
            r100.getClass();
            return d(r101, false, null);
        }

        public static k d(ECHybridListDTO r110, boolean r111, com.bytedance.android.ec.hybrid.list.entity.dto.a r112) {
            Intrinsics.checkNotNullParameter(r110, "dto");
            k r100 = new k();
            ECHybridListStyleDTO.a r101 = ECHybridListStyleDTO.Companion;
            ECHybridListStyleDTO r102 = r110.getListStyle();
            r101.getClass();
            r100.f47128a = ECHybridListStyleDTO.a.a(r102);
            Map<String, ECListItemConfigDTO> r103 = r110.getItemConfigs();
            ArrayList<i> r104 = null;
            if (r103 == null) goto L34;
            Map r105 = new LinkedHashMap(MapsKt.mapCapacity(r103.size()));
            Iterator<T> r106 = r103.entrySet().iterator();
        L6:
            if (r106.hasNext() == false) goto L35;
            Map.Entry r107 = (Map.Entry) r106.next();
            Object r108 = r107.getKey();
            k.a r109 = new k.a(null);
            Gson r113 = new Gson();
            ECListItemConfigDTO r114 = (ECListItemConfigDTO) r107.getValue();
            if (r114 == null) goto L10;
            String r115 = r114.getLynxConfig();
        L11:
            ECLynxConfigDTO r116 = (ECLynxConfigDTO) GsonProtectorUtils.fromJson(r113, r115, ECLynxConfigDTO.class);
            ECLynxConfigDTO.Companion.getClass();
            f r117 = new f();
            if (r116 == null) goto L14;
            String r118 = r116.getLynxSchema();
        L15:
            r117.f47100a = r118;
            if (r116 == null) goto L18;
            double r119 = r116.getPredictHeight();
        L19:
            r117.f47101b = r119;
            if (r116 == null) goto L22;
            r116.getFixedHeight();
        L22:
            if (r116 == null) goto L24;
            boolean r120 = r116.getFormModifiable();
        L25:
            r117.f47102c = r120;
            if (r116 == null) goto L28;
            HashMap<String, String> r121 = r116.getExtra();
        L29:
            r117.f47103d = r121;
            r109.f47132a = r117;
            ECListItemConfigDTO r122 = (ECListItemConfigDTO) r107.getValue();
            if (r122 == null) goto L32;
            ECHybridMitaCardConfig r123 = r122.getMitaCardConfig();
        L33:
            r109.f47133b = r123;
            r105.put(r108, r109);
            goto L6
        L32:
            r123 = null;
            goto L33
        L28:
            r121 = null;
            goto L29
        L24:
            r120 = false;
            goto L25
        L18:
            r119 = AudioStats.AUDIO_AMPLITUDE_NONE;
            goto L19
        L14:
            r118 = null;
            goto L15
        L10:
            r115 = null;
        L35:
            if (r105 != null) goto L37;
            r105 = MapsKt.emptyMap();
        L37:
            r100.f47129b = new HashMap(r105);
            if (r112 != null) goto L40;
            r112 = new com.bytedance.android.ec.hybrid.list.entity.dto.a(-1, null, 254);
        L40:
            Map<String, String> r124 = r110.getExtra();
            if (r124 == null) goto L44;
            String r125 = r124.get("session_id");
            if (r125 == null) goto L44;
        L45:
            Intrinsics.checkNotNullParameter(r125, "<set-?>");
            r112.f47089d = r125;
            r112.f47091f = r110.getCommonLogData();
            r112.f47093h = Integer.valueOf(r110.getCursor());
            List<ECHybridListSectionDTO> r126 = r110.getSections();
            if (r126 == null) goto L51;
            List<ECHybridListSectionDTO> r127 = r126;
            r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r127, 10));
            Iterator<T> r128 = r127.iterator();
        L49:
            if (r128.hasNext() == false) goto L51;
            ECHybridListSectionDTO r129 = (ECHybridListSectionDTO) r128.next();
            ECHybridListSectionDTO.Companion.getClass();
            r104.add(ECHybridListSectionDTO.a.a(r129, r111, r112));
        L51:
            r100.f47130c = r104;
            r100.f47131d = r110.getExtra();
            return r100;
        L44:
            r125 = "";
            goto L45
        L34:
            r105 = null;
            goto L35
        }

        public static void c(k r100, boolean r110, boolean r111, boolean r112, boolean r113, boolean r114, Function1 r115) {
            Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
            Intrinsics.checkNotNullParameter(r115, "deepOpt");
            if (r110 == true) goto L5;
            return;
        L5:
            int r116 = -1;
            int r101 = 0;
            if (r111 == false) goto L26;
            ArrayList<i> r117 = r100.f47130c;     // Catch: Exception -> L23
            if (r117 == null) goto L18;
            Iterator<i> r118 = r117.iterator();     // Catch: Exception -> L23
            int r102 = 0;
        L11:
            if (r118.hasNext() == false) goto L16;
            if (Intrinsics.areEqual(r118.next().f47107a, "category_tab_section") == true) goto L17;
            r102 = r102 + 1;     // Catch: Exception -> L23
        L17:
            Integer r119 = Integer.valueOf(r102);     // Catch: Exception -> L23
        L19:
            if (r119 == null) goto L26;
            if (r119.intValue() < 0) goto L26;
            ArrayList<i> r103 = r100.f47130c;     // Catch: Exception -> L23
            Intrinsics.checkNotNull(r103);     // Catch: Exception -> L23
            ListProtector.remove(r103, r119.intValue());     // Catch: Exception -> L23
            goto L26
        L16:
            r102 = -1;
            goto L17
        L18:
            r119 = null;
        L23:
            e = move-exception;
            boolean r120 = com.bytedance.android.ec.hybrid.monitor.f.f47559a;
            com.bytedance.android.ec.hybrid.monitor.f.b("optDowngradeStraightOut", "handle data failed, error: " + e.getMessage(), null);
            return;
        L26:
            if (r112 == false) goto L72;
            ArrayList<i> r121 = r100.f47130c;     // Catch: Exception -> L23
            if (r121 == null) goto L38;
            Iterator<i> r122 = r121.iterator();     // Catch: Exception -> L23
            int r104 = 0;
        L31:
            if (r122.hasNext() == false) goto L36;
            if (Intrinsics.areEqual(r122.next().f47107a, "favorite_section") == true) goto L37;
            r104 = r104 + 1;     // Catch: Exception -> L23
        L37:
            Integer r123 = Integer.valueOf(r104);     // Catch: Exception -> L23
        L39:
            if (r123 == null) goto L72;
            if (r123.intValue() < 0) goto L72;
            ArrayList<i> r105 = r100.f47130c;     // Catch: Exception -> L23
            Intrinsics.checkNotNull(r105);     // Catch: Exception -> L23
            i r124 = (i) ListProtector.get(r105, r123.intValue());     // Catch: Exception -> L23
            ArrayList<ECHybridListItemVO> r106 = r124.f47115i;     // Catch: Exception -> L23
            if (r106 != null) goto L45;
        L48:
            boolean r107 = true;
        L49:
            if (r107 == false) goto L51;
            return;
        L51:
            ArrayList<ECHybridListItemVO> r108 = r124.f47115i;     // Catch: Exception -> L23
            Intrinsics.checkNotNull(r108);     // Catch: Exception -> L23
            int r109 = r108.size();     // Catch: Exception -> L23
            int r125 = r109 - 1;     // Catch: Exception -> L23
            int r126 = 0;
        L52:
            if (r126 >= r125) goto L63;
            ArrayList<ECHybridListItemVO> r127 = r124.f47115i;     // Catch: Exception -> L23
            Intrinsics.checkNotNull(r127);     // Catch: Exception -> L23
            if (b(((ECHybridListItemVO) ListProtector.get(r127, r126)).f47028c) == false) goto L55;
            r126 = r126 + 1;     // Catch: Exception -> L23
        L55:
            ArrayList<ECHybridListItemVO> r128 = r124.f47115i;     // Catch: Exception -> L23
            Intrinsics.checkNotNull(r128);     // Catch: Exception -> L23
            if (b(((ECHybridListItemVO) ListProtector.get(r128, r125)).f47028c) == true) goto L59;
            if (r126 >= r125) goto L59;
            r125 = r125 - 1;     // Catch: Exception -> L23
        L59:
            ArrayList<ECHybridListItemVO> r129 = r124.f47115i;     // Catch: Exception -> L23
            Intrinsics.checkNotNull(r129);     // Catch: Exception -> L23
            if (b(((ECHybridListItemVO) ListProtector.get(r129, r125)).f47028c) == false) goto L63;
            ArrayList<ECHybridListItemVO> r130 = r124.f47115i;     // Catch: Exception -> L23
            Intrinsics.checkNotNull(r130);     // Catch: Exception -> L23
            ECHybridListItemVO r131 = (ECHybridListItemVO) ListProtector.get(r130, r125);     // Catch: Exception -> L23
            ArrayList<ECHybridListItemVO> r132 = r124.f47115i;     // Catch: Exception -> L23
            Intrinsics.checkNotNull(r132);     // Catch: Exception -> L23
            ArrayList<ECHybridListItemVO> r133 = r124.f47115i;     // Catch: Exception -> L23
            Intrinsics.checkNotNull(r133);     // Catch: Exception -> L23
            ListProtector.set(r132, r125, ListProtector.get(r133, r126));     // Catch: Exception -> L23
            ArrayList<ECHybridListItemVO> r134 = r124.f47115i;     // Catch: Exception -> L23
            Intrinsics.checkNotNull(r134);     // Catch: Exception -> L23
            ListProtector.set(r134, r126, r131);     // Catch: Exception -> L23
            r126 = r126 + 1;     // Catch: Exception -> L23
            r125 = r125 - 1;     // Catch: Exception -> L23
        L63:
            int r135 = RangesKt.coerceAtMost(4, r109);     // Catch: Exception -> L23
            int r136 = 0;
            boolean r137 = true;
        L64:
            if (r136 >= r135) goto L69;
            ArrayList<ECHybridListItemVO> r138 = r124.f47115i;     // Catch: Exception -> L23
            Intrinsics.checkNotNull(r138);     // Catch: Exception -> L23
            if (b(((ECHybridListItemVO) ListProtector.get(r138, r136)).f47028c) == true) goto L68;
            r137 = false;
        L68:
            r136 = r136 + 1;     // Catch: Exception -> L23
            goto L64
        L69:
            if (r137 == true) goto L72;
            if (r113 == false) goto L72;
            r115.invoke(r100);     // Catch: Exception -> L23
            goto L72
        L45:
            if (r106.isEmpty() == true) goto L48;
            r107 = false;
            goto L49
        L36:
            r104 = -1;
            goto L37
        L38:
            r123 = null;
        L72:
            if (r114 == false) goto L132;
            ArrayList<i> r139 = r100.f47130c;     // Catch: Exception -> L23
            if (r139 == null) goto L83;
            Iterator<i> r140 = r139.iterator();     // Catch: Exception -> L23
            int r141 = 0;
        L77:
            if (r140.hasNext() == false) goto L82;
            if (Intrinsics.areEqual(r140.next().f47107a, "multi_in_one_section") == true) goto L80;
            r141 = r141 + 1;     // Catch: Exception -> L23
            goto L77
        L80:
            r116 = r141;
        L82:
            Integer r142 = Integer.valueOf(r116);     // Catch: Exception -> L23
        L84:
            if (r142 != null) goto L86;
            return;
        L86:
            if (r142.intValue() < 0) goto L134;
            ArrayList<i> r143 = r100.f47130c;     // Catch: Exception -> L23
            Intrinsics.checkNotNull(r143);     // Catch: Exception -> L23
            Iterator<T> r144 = r143.iterator();     // Catch: Exception -> L23
        L88:
            if (r144.hasNext() == false) goto L135;
            Object r145 = r144.next();     // Catch: Exception -> L23
            int r146 = r101 + 1;     // Catch: Exception -> L23
            if (r101 >= 0) goto L93;
            CollectionsKt.throwIndexOverflow();     // Catch: Exception -> L23
        L93:
            i r147 = (i) r145;     // Catch: Exception -> L23
            if (r101 <= r142.intValue()) goto L104;
            if ((!Intrinsics.areEqual(r147.f47107a, "category_tab_section")) == false) goto L104;
            ArrayList<ECHybridListItemVO> r148 = r147.f47115i;     // Catch: Exception -> L23
            if (r148 == null) goto L104;
            Iterator<T> r149 = r148.iterator();     // Catch: Exception -> L23
        L101:
            if (r149.hasNext() == false) goto L104;
            ((ECHybridListItemVO) r149.next()).f47050x = true;     // Catch: Exception -> L23
        L104:
            r101 = r146;
            goto L88
        L135:
            return;
        L134:
            return;
        L83:
            r142 = null;
            goto L84
        }
    }

    static {
        Companion = new a();
        f47082b = LazyKt.lazy(ECHybridListDTO$Companion$reorderOptimizeEnable$2.INSTANCE);
    }

    public final Map<String, String> mapItemTypeToSchema() {
        Map<String, ECListItemConfigDTO> r100 = this.itemConfigs;
        if (r100 == null) goto L13;
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<T> r102 = r100.keySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L12;
        String r103 = (String) r102.next();
        ECListItemConfigDTO r104 = r100.get(r103);
        if (r104 == null) goto L6;
        String r105 = r104.tackOutSchema();
        if (r105 == null) goto L6;
        r101.put(r103, r105);
        goto L6
    L12:
        return r101;
    L13:
        return null;
    }

    public ECHybridListDTO() {
        this.hasMore = true;
    }

    public static final /* synthetic */ Lazy access$getReorderOptimizeEnable$cp() {
        return f47082b;
    }

    public final Map<String, Object> getCommonLogData() {
        return this.commonLogData;
    }

    public final int getCursor() {
        return this.cursor;
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final boolean getFastPathInjected() {
        return this.f47083a;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final Map<String, ECListItemConfigDTO> getItemConfigs() {
        return this.itemConfigs;
    }

    public final boolean getKeepSelectedTabOnRefresh() {
        return this.keepSelectedTabOnRefresh;
    }

    public final ECHybridListStyleDTO getListStyle() {
        return this.listStyle;
    }

    public final Integer getNextPageCount() {
        return this.nextPageCount;
    }

    public final Integer getPreRequestCount() {
        return this.preRequestCount;
    }

    public final List<ECHybridListSectionDTO> getSections() {
        return this.sections;
    }

    public final void setCommonLogData(Map<String, ? extends Object> r100) {
        this.commonLogData = r100;
    }

    public final void setCursor(int r100) {
        this.cursor = r100;
    }

    public final void setExtra(Map<String, String> r100) {
        this.extra = r100;
    }

    public final void setFastPathInjected(boolean r100) {
        this.f47083a = r100;
    }

    public final void setHasMore(boolean r100) {
        this.hasMore = r100;
    }

    public final void setItemConfigs(Map<String, ECListItemConfigDTO> r100) {
        this.itemConfigs = r100;
    }

    public final void setListStyle(ECHybridListStyleDTO r100) {
        this.listStyle = r100;
    }

    public final void setSections(List<ECHybridListSectionDTO> r100) {
        this.sections = r100;
    }
}

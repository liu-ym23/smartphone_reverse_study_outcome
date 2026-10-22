package com.bytedance.android.ec.hybrid.list.entity.dto;

import android.util.Base64;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.ECHybridListItemType;
import com.bytedance.android.ec.hybrid.list.ability.n0;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.ECItemOperationType;
import com.bytedance.android.ec.hybrid.list.entity.e;
import com.bytedance.android.ec.hybrid.list.entity.n;
import com.bytedance.android.ec.hybrid.list.util.k;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kk.d;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 [2\u00020\u0001:\u0001[B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u00178\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u001f\u0010\u0010R\u001a\u0010 \u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b!\u0010\u0010R \u0010\"\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001d\"\u0004\b$\u0010%R\u0018\u0010&\u001a\u0004\u0018\u00010'8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0018\u0010*\u001a\u0004\u0018\u00010+8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R \u0010.\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001d\"\u0004\b0\u0010%R\u0018\u00101\u001a\u0004\u0018\u0001028\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0018\u00105\u001a\u0004\u0018\u0001068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\"\u00109\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b:\u0010\u0010\"\u0004\b;\u0010<R&\u0010=\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0007\"\u0004\b?\u0010\tR \u0010@\u001a\u0004\u0018\u00010A8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001e\u0010F\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\bG\u0010\u0010\"\u0004\bH\u0010<R\u0016\u0010I\u001a\u00020\u000b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010\rR\u001c\u0010K\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u001d\"\u0004\bM\u0010%R\"\u0010N\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\bO\u0010\u0010\"\u0004\bP\u0010<R\u0018\u0010Q\u001a\u0004\u0018\u00010R8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u0010TR \u0010U\u001a\u0004\u0018\u00010V8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010Z¨\u0006\\"}, d2 = {"Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListItemDTO;", "Ljava/io/Serializable;", "()V", SlcCommonAction.KEY_ACTIONS, "", "Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListItemAction;", "getActions", "()Ljava/util/List;", "setActions", "(Ljava/util/List;)V", "autoPlay", "", "getAutoPlay", "()I", "autoPlayDuration", "getAutoPlayDuration", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "extra", "Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECNAMallCardExtra;", "getExtra", "()Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECNAMallCardExtra;", "insertCardAutoPlay", "", "getInsertCardAutoPlay", "()Z", "insertOrientation", "", "getInsertOrientation", "()Ljava/lang/String;", "insertOriginalPosition", "getInsertOriginalPosition", "insertPosition", "getInsertPosition", "itemData", "getItemData", "setItemData", "(Ljava/lang/String;)V", "itemDataDecode", "Lcom/google/gson/JsonElement;", "getItemDataDecode", "()Lcom/google/gson/JsonElement;", "itemDigest", "Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECItemCardDigest;", "getItemDigest", "()Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECItemCardDigest;", "itemId", "getItemId", "setItemId", "itemLynxCardExtraData", "Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECItemLynxCardExtraData;", "getItemLynxCardExtraData", "()Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECItemLynxCardExtraData;", "itemStyle", "Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListItemStyleDTO;", "getItemStyle", "()Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECHybridListItemStyleDTO;", "itemType", "getItemType", "setItemType", "(Ljava/lang/Integer;)V", "operationPaths", "getOperationPaths", "setOperationPaths", "operationType", "Lcom/bytedance/android/ec/hybrid/list/entity/ECItemOperationType;", "getOperationType", "()Lcom/bytedance/android/ec/hybrid/list/entity/ECItemOperationType;", "setOperationType", "(Lcom/bytedance/android/ec/hybrid/list/entity/ECItemOperationType;)V", "originItemType", "getOriginItemType", "setOriginItemType", "playPriority", "getPlayPriority", "recommendInfoFromChunked", "getRecommendInfoFromChunked", "setRecommendInfoFromChunked", "spanSize", "getSpanSize", "setSpanSize", "ssrConfig", "Lcom/bytedance/android/ec/hybrid/list/entity/dto/SSRConfig;", "getSsrConfig", "()Lcom/bytedance/android/ec/hybrid/list/entity/dto/SSRConfig;", "trackData", "Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECTrackDataDTO;", "getTrackData", "()Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECTrackDataDTO;", "setTrackData", "(Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECTrackDataDTO;)V", "Companion", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECHybridListItemDTO implements Serializable {
    public static final Companion Companion = null;

    @SerializedName(SlcCommonAction.KEY_ACTIONS)
    private List<ECHybridListItemAction> actions;

    @SerializedName("auto_play")
    private final int autoPlay;

    @SerializedName("auto_play_duration")
    private final Integer autoPlayDuration;

    @SerializedName("extra")
    private final ECNAMallCardExtra extra;

    @SerializedName("insert_card_auto_play")
    private final boolean insertCardAutoPlay;

    @SerializedName("insert_orientation")
    private final String insertOrientation;

    @SerializedName("insert_original_position")
    private final Integer insertOriginalPosition;

    @SerializedName("insert_position")
    private final Integer insertPosition;

    @SerializedName("item_data")
    private String itemData;

    @SerializedName("item_data_encode")
    private final JsonElement itemDataDecode;

    @SerializedName("item_digest")
    private final ECItemCardDigest itemDigest;

    @SerializedName("item_id")
    private String itemId;

    @SerializedName("item_lynx_card_extra_data")
    private final ECItemLynxCardExtraData itemLynxCardExtraData;

    @SerializedName("item_style")
    private final ECHybridListItemStyleDTO itemStyle;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE)
    private Integer itemType;

    @SerializedName("item_operation_paths")
    private List<String> operationPaths;

    @SerializedName("item_operation_type")
    private ECItemOperationType operationType;
    private Integer originItemType;

    @SerializedName("play_priority")
    private final int playPriority;
    private String recommendInfoFromChunked;

    @SerializedName("span_size")
    private Integer spanSize;

    @SerializedName("ssr_config")
    private final SSRConfig ssrConfig;

    @SerializedName("track_data")
    private ECTrackDataDTO trackData;

    public static final class Companion {
        public Companion() {
        }

        public static Object a(final String r100, Integer r101) {
            Object r102 = null;
            if (r101 != null) goto L5;
            return null;
        L5:
            if (r100 != null) goto L7;
            return null;
        L7:
            ECHybridListItemType.a r103 = ECHybridListItemType.Companion;
            int r104 = r101.intValue();
            r103.getClass();
            if (ECHybridListItemType.a.c(r104) == true) goto L10;
            ECHybridListEngine.Companion r105 = ECHybridListEngine.f46869x;
            int r106 = r101.intValue();
            r105.getClass();
            n0 r107 = ECHybridListEngine.f46868w.get(Integer.valueOf(r106));
            if (r107 == null) goto L14;
            r102 = r107.a(r100);
        L14:
            if (r102 != null) goto L17;
            return r100;
        L17:
            return r102;
        L10:
            return d.a(r100, new ECHybridListItemDTO$Companion$parseListItemData$1(r100));
        }

        public static ECHybridListItemVO b(ECHybridListItemDTO r110, String r111, boolean r112, a r113) {
            if (r110 == null) goto L4;
            long r100 = System.currentTimeMillis();
            ECHybridListItemVO r101 = new ECHybridListItemVO();
            boolean r102 = true;
            int r103 = 0;
            if (r110.getAutoPlay() != 1) goto L8;
            boolean r104 = true;
        L9:
            r101.f47038l = r104;
            r101.f47039m = r110.getPlayPriority();
            r101.f47044r = r111;
            r110.getInsertCardAutoPlay();
            r101.f47040n = r110.getAutoPlayDuration();
            r101.f47026a = r110.getSpanSize();
            r101.f47028c = r110.getItemType();
            r101.f47027b = r110.getOriginItemType();
            r101.f47029d = r110.getItemId();
            if (r113 == null) goto L12;
            r101.D = r113;
        L12:
            ECItemOperationType r114 = r110.getOperationType();
            if (r114 == null) goto L15;
            Intrinsics.checkNotNullParameter(r114, "<set-?>");
            r101.f47042p = r114;
        L15:
            List<ECHybridListItemAction> r115 = r110.getActions();
            if (r115 == null) goto L25;
            Iterator<T> r116 = r115.iterator();
        L19:
            if (r116.hasNext() == false) goto L25;
            ECHybridListItemAction r105 = (ECHybridListItemAction) r116.next();
            if (r105 == null) goto L19;
            String r106 = r105.jointFilter();
            if (r106 == null) goto L19;
            ((ArrayList) r101.f47045s).add(r106);
        L25:
            List<String> r117 = r110.getOperationPaths();
            if (r117 == null) goto L28;
            r101.f47043q = r117;
        L28:
            ECTrackDataDTO r118 = r110.getTrackData();
            if (r118 == null) goto L33;
            ECTrackDataDTO.Companion.getClass();
            n r119 = ECTrackDataDTO.a.b(r118, r101);
            r101.f47041o = r119;
            HashMap<String, Object> r120 = r119.f47140b;
            if (r120 == null) goto L33;
            HashMap r107 = new HashMap();
            r107.put("track_common_data", r120);
            r101.E.put("ec_lynx_props_extra", r107);
        L33:
            ECNAMallCardExtra r121 = r110.getExtra();
            if (r121 == null) goto L36;
            r101.n(r121);
        L36:
            r110.getItemDigest();
            SSRConfig r122 = r110.getSsrConfig();
            if (r122 == null) goto L60;
            com.bytedance.android.ec.hybrid.card.api.c.f46377d.getClass();
            Intrinsics.checkNotNullParameter(r122, "dto");
            String r108 = r122.getHydrateUrl();
            if (r108 == null) goto L51;
            SSRDataDecodingFormat r109 = r122.getSsrDataDecodingFormat();
            if (r109 != null) goto L45;
        L46:
            String r123 = r122.getSsrData();
            if (r123 != null) goto L49;
            byte[] r124 = null;
        L50:
            if (r124 == null) goto L51;
            JSONObject r125 = k.c(r122.getHydrateData());
            if (r125 == null) goto L55;
            Map<String, Object> r126 = cd.a.e(r125);
        L56:
            com.bytedance.android.ec.hybrid.card.api.c r127 = new com.bytedance.android.ec.hybrid.card.api.c(r124, r126, r108);
        L57:
            r101.f47048v = r127;
            goto L60
        L55:
            r126 = null;
            goto L56
        L49:
            r124 = Base64.decode(r123, 0);
            goto L50
        L45:
            if (com.bytedance.android.ec.hybrid.card.api.b.f46376a[r109.ordinal()] == 1) goto L46;
            throw new NoWhenBranchMatchedException();
        L51:
            r127 = null;
        L60:
            ECHybridListItemStyleDTO r128 = r110.getItemStyle();
            if (r128 == null) goto L63;
            ECHybridListItemStyleDTO.Companion.getClass();
            e r129 = new e();
            r129.f47097a = r128.getBorderRadius();
            r129.f47098b = r128.getBorderRadiusList();
            r129.f47099c = r128.getBorderRadiusListMaxIndex();
            r101.L = r129;
        L63:
            r101.f47049w = false;
            if (r112 == false) goto L66;
            r101.f47049w = true;
            r101.E.put("isCacheData", 1);
        L67:
            ECItemLynxCardExtraData r130 = r110.getItemLynxCardExtraData();
            if (r130 == null) goto L72;
            String r131 = r130.getShowDividerLine();
            if (r131 == null) goto L72;
            r101.E.put("show_divider_line", r131);
        L72:
            ECHybridListItemDTO.Companion.getClass();
            String r132 = r110.getItemData();
            if (r132 != null) goto L75;
        L80:
            final JsonElement r133 = r110.getItemDataDecode();
            if (r133 == null) goto L111;
            String r134 = r110.getRecommendInfoFromChunked();
            if (r134 != null) goto L85;
        L88:
            if (r102 == true) goto L157;
        L103:
            ECHybridListItemType.a r135 = ECHybridListItemType.Companion;
            Integer r136 = r110.getItemType();
            if (r136 == null) goto L106;
            r103 = r136.intValue();
        L106:
            r135.getClass();
            if (ECHybridListItemType.a.c(r103) == false) goto L109;
            ECHybridListItemDTO.Companion.getClass();
            Triple r137 = new Triple(null, r134, (Map) d.a(null, new ECHybridListItemDTO$Companion$jsonElementToMap$1(r133)));
        L110:
            Triple r138 = r137;
        L112:
            String r139 = (String) r138.component1();
            String r140 = (String) r138.component2();
            Object r141 = (Map) r138.component3();
            r101.X = r110.getActions();
            r101.p(r139);
            r101.q(r140);
            if (r141 != null) goto L115;
            Companion r142 = ECHybridListItemDTO.Companion;
            String r143 = r101.g();
            Integer r144 = r110.getItemType();
            r142.getClass();
            r141 = a(r143, r144);
        L115:
            r101.o(r141);
            r101.f47051y = r110.getInsertPosition();
            r101.f47052z = r110.getInsertOriginalPosition();
            r101.A = r110.getInsertOrientation();
            long r145 = System.currentTimeMillis();
            r101.B = Long.valueOf(r100);
            r101.C = Long.valueOf(r145);
            if (r113 == null) goto L154;
            Map<String, ? extends Object> r146 = r113.f47091f;
            if (r146 == null) goto L154;
            ECHybridListItemDTO.Companion.getClass();
            n r147 = r101.f47041o;
            if (r147 == null) goto L129;
            List<com.bytedance.android.ec.hybrid.list.entity.c> r148 = r147.f47141c;
            if (r148 == null) goto L129;
            Iterator<T> r149 = r148.iterator();
        L125:
            if (r149.hasNext() == false) goto L129;
            Map<String, Object> r150 = ((com.bytedance.android.ec.hybrid.list.entity.c) r149.next()).f47072b;
            if (r150 == null) goto L125;
            r150.putAll(r146);
        L129:
            n r151 = r101.f47041o;
            if (r151 == null) goto L139;
            List<com.bytedance.android.ec.hybrid.list.entity.c> r152 = r151.f47143e;
            if (r152 == null) goto L139;
            Iterator<T> r153 = r152.iterator();
        L135:
            if (r153.hasNext() == false) goto L139;
            Map<String, Object> r154 = ((com.bytedance.android.ec.hybrid.list.entity.c) r153.next()).f47072b;
            if (r154 == null) goto L135;
            r154.putAll(r146);
        L139:
            n r155 = r101.f47041o;
            if (r155 == null) goto L149;
            List<com.bytedance.android.ec.hybrid.list.entity.c> r156 = r155.f47145g;
            if (r156 == null) goto L149;
            Iterator<T> r157 = r156.iterator();
        L145:
            if (r157.hasNext() == false) goto L149;
            Map<String, Object> r158 = ((com.bytedance.android.ec.hybrid.list.entity.c) r157.next()).f47072b;
            if (r158 == null) goto L145;
            r158.putAll(r146);
        L149:
            n r159 = r101.f47041o;
            if (r159 == null) goto L154;
            HashMap<String, Object> r160 = r159.f47140b;
            if (r160 == null) goto L154;
            r160.putAll(r146);
        L154:
            return r101;
        L109:
            r137 = new Triple(r133.toString(), r134, null);
            goto L110
        L157:
            Result.Companion r161 = Result.Companion;     // Catch: Throwable -> L99
            JsonElement r162 = r133.getAsJsonObject().getAsJsonObject("extra").get(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO);     // Catch: Throwable -> L99
            if (r162 == null) goto L94;
            String r163 = r162.getAsString();     // Catch: Throwable -> L99
            if (r163 == null) goto L94;
            Unit r164 = Unit.INSTANCE;     // Catch: Throwable -> L97
        L95:
            Result.m9449constructorimpl(r164);     // Catch: Throwable -> L97
        L102:
            r134 = r163;
        L97:
            Throwable th10 = th;
        L101:
            Result.Companion r165 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th10));
        L94:
            r163 = r134;
            r164 = null;
        L99:
            th = move-exception;
            r163 = r134;
            th10 = th;
            goto L101
        L85:
            if (r134.length() == 0) goto L88;
            r102 = false;
            goto L88
        L111:
            r138 = new Triple(null, null, null);
            goto L112
        L75:
            if (r132.length() <= 0) goto L77;
            boolean r166 = true;
        L78:
            if (r166 == false) goto L80;
            r138 = new Triple(r132, r110.getRecommendInfoFromChunked(), null);
            goto L112
        L77:
            r166 = false;
            goto L78
        L66:
            r101.E.put("isCacheData", 0);
            goto L67
        L8:
            r104 = false;
            goto L9
        L4:
            return new ECHybridListItemVO();
        }
    }

    static {
        Companion = new Companion();
    }

    public ECHybridListItemDTO() {
    }

    public final List<ECHybridListItemAction> getActions() {
        return this.actions;
    }

    public final int getAutoPlay() {
        return this.autoPlay;
    }

    public final Integer getAutoPlayDuration() {
        return this.autoPlayDuration;
    }

    public final ECNAMallCardExtra getExtra() {
        return this.extra;
    }

    public final boolean getInsertCardAutoPlay() {
        return this.insertCardAutoPlay;
    }

    public final String getInsertOrientation() {
        return this.insertOrientation;
    }

    public final Integer getInsertOriginalPosition() {
        return this.insertOriginalPosition;
    }

    public final Integer getInsertPosition() {
        return this.insertPosition;
    }

    public final String getItemData() {
        return this.itemData;
    }

    public final JsonElement getItemDataDecode() {
        return this.itemDataDecode;
    }

    public final ECItemCardDigest getItemDigest() {
        return this.itemDigest;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final ECItemLynxCardExtraData getItemLynxCardExtraData() {
        return this.itemLynxCardExtraData;
    }

    public final ECHybridListItemStyleDTO getItemStyle() {
        return this.itemStyle;
    }

    public final Integer getItemType() {
        return this.itemType;
    }

    public final List<String> getOperationPaths() {
        return this.operationPaths;
    }

    public final ECItemOperationType getOperationType() {
        return this.operationType;
    }

    public final Integer getOriginItemType() {
        return this.originItemType;
    }

    public final int getPlayPriority() {
        return this.playPriority;
    }

    public final String getRecommendInfoFromChunked() {
        return this.recommendInfoFromChunked;
    }

    public final Integer getSpanSize() {
        return this.spanSize;
    }

    public final SSRConfig getSsrConfig() {
        return this.ssrConfig;
    }

    public final ECTrackDataDTO getTrackData() {
        return this.trackData;
    }

    public final void setActions(List<ECHybridListItemAction> r100) {
        this.actions = r100;
    }

    public final void setItemData(String r100) {
        this.itemData = r100;
    }

    public final void setItemId(String r100) {
        this.itemId = r100;
    }

    public final void setItemType(Integer r100) {
        this.itemType = r100;
    }

    public final void setOperationPaths(List<String> r100) {
        this.operationPaths = r100;
    }

    public final void setOperationType(ECItemOperationType r100) {
        this.operationType = r100;
    }

    public final void setOriginItemType(Integer r100) {
        this.originItemType = r100;
    }

    public final void setRecommendInfoFromChunked(String r100) {
        this.recommendInfoFromChunked = r100;
    }

    public final void setSpanSize(Integer r100) {
        this.spanSize = r100;
    }

    public final void setTrackData(ECTrackDataDTO r100) {
        this.trackData = r100;
    }
}

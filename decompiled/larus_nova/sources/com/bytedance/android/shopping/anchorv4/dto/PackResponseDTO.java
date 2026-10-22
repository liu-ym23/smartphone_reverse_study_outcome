package com.bytedance.android.shopping.anchorv4.dto;

import com.bytedance.android.chunkstreamprediction.network.c;
import com.bytedance.android.chunkstreamprediction.network.d;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.base.settings.b;
import com.bytedance.android.ec.base.settings.g;
import com.bytedance.android.ec.base.settings.h;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.abtest.e;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.bytedance.android.ec.model.response.anchorv3.PromotionLogPbData;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.dto.meta.PageMeta;
import com.bytedance.services.apm.api.EnsureManager;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LinkedTreeMap;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import e73.i;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jj4.a;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\bZ\u0010[J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\n\u001a\u00020\u0005J\u0006\u0010\u000b\u001a\u00020\u0005J\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0005J\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0018\u001a\u00020\u000eJ\u0006\u0010\u0019\u001a\u00020\u0005J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001aH\u0016J\u0006\u0010\u001e\u001a\u00020\u000eJ\u0006\u0010\u001f\u001a\u00020\u0005J\u0006\u0010 \u001a\u00020\u0005J\b\u0010!\u001a\u00020\u0000H\u0016R\"\u0010\"\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010(\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010.\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010)\u001a\u0004\b/\u0010+\"\u0004\b0\u0010-R$\u00102\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R$\u00109\u001a\u0004\u0018\u0001088\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R$\u0010?\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u0017\u0010F\u001a\u00020E8\u0006¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR$\u0010P\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\"\u0010Q\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\"\u0010W\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bW\u0010#\u001a\u0004\bX\u0010%\"\u0004\bY\u0010'¨\u0006\\"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/PackResponseDTO;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "Ljava/io/Serializable;", "Lcom/bytedance/android/chunkstreamprediction/network/d;", "", "", "isMini", "isHitCache", "isChunk", "hasMultipleChunks", "isFirstChunk", "isLastChunk", "", "getValidChunkIndex", "", "markAsRefresh", "cache", "markAsHitCache", "", "time", "makeTimestamp", "", "chunkId", "markAsChunk", "markAsTraxex", "isTraxex", "Lcom/bytedance/android/chunkstreamprediction/network/c;", "o", "setChunkReadingReport", "getChunkReadingReport", "updatePdpBcmParams", "isOptRespProcess", "isForbidCache", "clone", "mini", "Z", "getMini", "()Z", "setMini", "(Z)V", DBDefinition.CHUNK_COUNT, "Ljava/lang/Integer;", "getChunkCount", "()Ljava/lang/Integer;", "setChunkCount", "(Ljava/lang/Integer;)V", "chunkIndex", "getChunkIndex", "setChunkIndex", "Lcom/bytedance/android/shopping/anchorv4/dto/PackParsedDTO;", "parsedDTO", "Lcom/bytedance/android/shopping/anchorv4/dto/PackParsedDTO;", "getParsedDTO", "()Lcom/bytedance/android/shopping/anchorv4/dto/PackParsedDTO;", "setParsedDTO", "(Lcom/bytedance/android/shopping/anchorv4/dto/PackParsedDTO;)V", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionLogPbData;", "logPb", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionLogPbData;", "getLogPb", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionLogPbData;", "setLogPb", "(Lcom/bytedance/android/ec/model/response/anchorv3/PromotionLogPbData;)V", "bdturing", "Ljava/lang/String;", "getBdturing", "()Ljava/lang/String;", "setBdturing", "(Ljava/lang/String;)V", "Le73/i;", "status", "Le73/i;", "getStatus", "()Le73/i;", "b", "Lcom/bytedance/android/shopping/anchorv4/dto/PackResponseDTO;", "getHeadChunk", "()Lcom/bytedance/android/shopping/anchorv4/dto/PackResponseDTO;", "setHeadChunk", "(Lcom/bytedance/android/shopping/anchorv4/dto/PackResponseDTO;)V", "headChunk", "timestamp", "J", "getTimestamp", "()J", "setTimestamp", "(J)V", "fromCache", "getFromCache", "setFromCache", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class PackResponseDTO extends CommerceBaseResponse implements d, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient c f166507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient PackResponseDTO f166508b;

    @SerializedName("bdturing")
    private String bdturing;

    @SerializedName("chunk_count")
    private Integer chunkCount;

    @SerializedName("chunk_index")
    private Integer chunkIndex;
    private boolean fromCache;

    @SerializedName("log_pb")
    private PromotionLogPbData logPb;

    @SerializedName("mini")
    private boolean mini;

    @SerializedName("promotion_v3")
    private PackParsedDTO parsedDTO;
    private final i status;
    private long timestamp;

    public final int getValidChunkIndex() {
        Integer r100 = this.chunkIndex;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    public final boolean isChunk() {
        return this.status.f471170d;
    }

    public final boolean isForbidCache() {
        PackParsedDTO r100 = this.parsedDTO;
        if (r100 == null) goto L9;
        Control r101 = r100.getControl();
        if (r101 == null) goto L9;
        if (r101.getForbidCache() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean isHitCache() {
        return this.status.f471168b;
    }

    public final boolean isOptRespProcess() {
        Lazy r100 = ECSettingKeys.f43616a;
        int r101 = b.f42814a;
        int r102 = e.f43640a;
        Object r103 = e.a(Boolean.TRUE, Boolean.FALSE);
        PackParsedDTO r104 = null;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L170
        h.a();     // Catch: Throwable -> L170
        SDKSettingsCacheManager r106 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L170
        r106.getClass();     // Catch: Throwable -> L58
        Object r107 = SDKSettingsCacheManager.f42809b.get("ec_pdp_handle_resp_opt");     // Catch: Throwable -> L58
        if (r107 != null) goto L10;
    L55:
        Object r108 = null;
    L56:
        Object r109 = Result.m9449constructorimpl(r108);     // Catch: Throwable -> L58
    L60:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);     // Catch: Throwable -> L170
        if (r110 == null) goto L64;
        EnsureManager.ensureNotReachHere(r110);     // Catch: Throwable -> L170
    L64:
        if (Result.m9455isFailureimpl(r109) == false) goto L67;
        r109 = null;
    L67:
        if ((r109 instanceof Boolean) == true) goto L69;
        r109 = null;
    L69:
        Object r111 = (Boolean) r109;     // Catch: Throwable -> L170
        if (r111 != null) goto L76;
        r106.getClass();     // Catch: Throwable -> L170
        Object r112 = SDKSettingsCacheManager.f42808a.get("ec_pdp_handle_resp_opt");     // Catch: Throwable -> L170
        if ((r112 instanceof Boolean) == true) goto L75;
        r112 = null;
    L75:
        r111 = (Boolean) r112;     // Catch: Throwable -> L170
    L76:
        if (r111 != null) goto L180;
        int r113 = g.f42821a;     // Catch: Throwable -> L170
    L157:
        th = move-exception;
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L170
        Object r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L170
    L160:
        if (Result.m9452exceptionOrNullimpl(r115) != null) goto L205;
    L167:
        r111 = r115;
    L168:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L170
        SDKSettingsCacheManager.e("ec_pdp_handle_resp_opt", r111);     // Catch: Throwable -> L170
        goto L180
    L205:
        r115 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("ec_pdp_handle_resp_opt", Boolean.class, r103);     // Catch: Throwable -> L164
    L165:
        if (r115 != null) goto L167;
        r111 = r103;
    L164:
        r115 = r103;
        goto L165
    L199:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L132
        Object r116 = SDKSettingsCacheManager.f42809b.get("ec_pdp_handle_resp_opt");     // Catch: Throwable -> L132
        if (r116 != null) goto L84;
    L129:
        Object r117 = null;
    L130:
        Object r118 = Result.m9449constructorimpl(r117);     // Catch: Throwable -> L132
    L134:
        Throwable r119 = Result.m9452exceptionOrNullimpl(r118);     // Catch: Throwable -> L157
        if (r119 == null) goto L138;
        EnsureManager.ensureNotReachHere(r119);     // Catch: Throwable -> L157
    L138:
        if (Result.m9455isFailureimpl(r118) == false) goto L141;
        r118 = null;
    L141:
        if ((r118 instanceof Boolean) == true) goto L143;
        r118 = null;
    L143:
        r115 = (Boolean) r118;     // Catch: Throwable -> L157
        if (r115 != null) goto L167;
        jj4.b r120 = jj4.b.f499326b;     // Catch: Throwable -> L157
        Object r121 = a.a("ec_pdp_handle_resp_opt", Boolean.class, r103, false);     // Catch: Throwable -> L157
        if (r121 != null) goto L150;
        Intrinsics.throwNpe();     // Catch: Throwable -> L157
    L150:
        if ((r121 instanceof Boolean) == true) goto L152;
        r121 = null;
    L152:
        Object r122 = (Boolean) r121;     // Catch: Throwable -> L157
        if (r122 != null) goto L155;
        r122 = r103;
    L155:
        r115 = Result.m9449constructorimpl(r122);     // Catch: Throwable -> L157
    L84:
        if ((r116 instanceof Boolean) == true) goto L86;
        Object r123 = null;
    L87:
        r117 = (Boolean) r123;     // Catch: Throwable -> L132
        if (r117 != null) goto L130;
        if ((r116 instanceof Number) == false) goto L117;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L99;
        Float r124 = Float.valueOf(((Number) r116).floatValue());     // Catch: Throwable -> L132
        if ((r124 instanceof Boolean) == true) goto L97;
        r124 = null;
    L97:
        r117 = (Boolean) r124;     // Catch: Throwable -> L132
        goto L130
    L99:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L105;
        Double r125 = Double.valueOf(((Number) r116).doubleValue());     // Catch: Throwable -> L132
        if ((r125 instanceof Boolean) == true) goto L103;
        r125 = null;
    L103:
        r117 = (Boolean) r125;     // Catch: Throwable -> L132
        goto L130
    L105:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L111;
        Integer r126 = Integer.valueOf(((Number) r116).intValue());     // Catch: Throwable -> L132
        if ((r126 instanceof Boolean) == true) goto L109;
        r126 = null;
    L109:
        r117 = (Boolean) r126;     // Catch: Throwable -> L132
        goto L130
    L111:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L117;
        Long r127 = Long.valueOf(((Number) r116).longValue());     // Catch: Throwable -> L132
        if ((r127 instanceof Boolean) == true) goto L115;
        r127 = null;
    L115:
        r117 = (Boolean) r127;     // Catch: Throwable -> L132
    L117:
        if ((r116 instanceof JSONObject) == false) goto L119;
    L209:
        Object r128 = SDKSettingsCacheManager.a().fromJson(r116.toString(), Boolean.class);     // Catch: Throwable -> L125
        if ((r128 instanceof Boolean) == true) goto L123;
        r128 = null;
    L123:
        Object r129 = Result.m9449constructorimpl((Boolean) r128);     // Catch: Throwable -> L125
    L127:
        r117 = r129;
        if (Result.m9455isFailureimpl(r117) == false) goto L130;
    L125:
        th = move-exception;
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L132
        r129 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L132
        goto L127
    L119:
        if ((r116 instanceof JSONArray) == false) goto L129;
    L86:
        r123 = r116;
    L132:
        th = move-exception;
        Result.Companion r131 = Result.Companion;     // Catch: Throwable -> L157
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L157
    L180:
        if (((Boolean) r111).booleanValue() == false) goto L183;
        return true;
    L183:
        if (hasMultipleChunks() == true) goto L185;
    L189:
        r104 = this.parsedDTO;
    L190:
        if (r104 == null) goto L213;
        Control r132 = r104.getControl();
        if (r132 == null) goto L214;
        e73.d r133 = r132.getChunkSplitDetail();
        if (r133 != null) goto L196;
        return false;
    L196:
        if (r133.a() != true) goto L216;
        return true;
    L216:
        return false;
    L214:
        return false;
    L213:
        return false;
    L185:
        if (getValidChunkIndex() <= 0) goto L189;
        PackResponseDTO r134 = this.f166508b;
        if (r134 == null) goto L190;
        r104 = r134.parsedDTO;
        goto L190
    L10:
        if ((r107 instanceof Boolean) == true) goto L12;
        Object r135 = null;
    L13:
        r108 = (Boolean) r135;     // Catch: Throwable -> L58
        if (r108 != null) goto L56;
        if ((r107 instanceof Number) == false) goto L43;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L25;
        Float r136 = Float.valueOf(((Number) r107).floatValue());     // Catch: Throwable -> L58
        if ((r136 instanceof Boolean) == true) goto L23;
        r136 = null;
    L23:
        r108 = (Boolean) r136;     // Catch: Throwable -> L58
        goto L56
    L25:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L31;
        Double r137 = Double.valueOf(((Number) r107).doubleValue());     // Catch: Throwable -> L58
        if ((r137 instanceof Boolean) == true) goto L29;
        r137 = null;
    L29:
        r108 = (Boolean) r137;     // Catch: Throwable -> L58
        goto L56
    L31:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L37;
        Integer r138 = Integer.valueOf(((Number) r107).intValue());     // Catch: Throwable -> L58
        if ((r138 instanceof Boolean) == true) goto L35;
        r138 = null;
    L35:
        r108 = (Boolean) r138;     // Catch: Throwable -> L58
        goto L56
    L37:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L43;
        Long r139 = Long.valueOf(((Number) r107).longValue());     // Catch: Throwable -> L58
        if ((r139 instanceof Boolean) == true) goto L41;
        r139 = null;
    L41:
        r108 = (Boolean) r139;     // Catch: Throwable -> L58
    L43:
        if ((r107 instanceof JSONObject) == false) goto L45;
    L211:
        Object r140 = SDKSettingsCacheManager.a().fromJson(r107.toString(), Boolean.class);     // Catch: Throwable -> L51
        if ((r140 instanceof Boolean) == true) goto L49;
        r140 = null;
    L49:
        Object r141 = Result.m9449constructorimpl((Boolean) r140);     // Catch: Throwable -> L51
    L53:
        r108 = r141;
        if (Result.m9455isFailureimpl(r108) == false) goto L56;
    L51:
        th = move-exception;
        Result.Companion r142 = Result.Companion;     // Catch: Throwable -> L58
        r141 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L58
        goto L53
    L45:
        if ((r107 instanceof JSONArray) == false) goto L55;
    L12:
        r135 = r107;
    L58:
        th = move-exception;
        Result.Companion r143 = Result.Companion;     // Catch: Throwable -> L170
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L170
    L170:
        th = move-exception;
        Result.Companion r144 = Result.Companion;
        Object r145 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r146 = Result.m9452exceptionOrNullimpl(r145);
        if (r146 == null) goto L175;
        EnsureManager.ensureNotReachHere(r146);
    L175:
        if (Result.m9455isFailureimpl(r145) == true) goto L178;
        r103 = r145;
    L178:
        r111 = r103;
        goto L180
    }

    public final boolean isTraxex() {
        return this.status.f471172f;
    }

    public final void markAsRefresh() {
        this.status.f471169c = true;
    }

    public final void markAsTraxex() {
        this.status.f471172f = true;
    }

    public final void updatePdpBcmParams() {
        PackParsedDTO r100 = this.parsedDTO;
        Boolean r101 = null;
        if (r100 == null) goto L7;
        PageMeta r102 = r100.getPageMeta();
        if (r102 == null) goto L7;
        CommonMeta r103 = r102.getCommonMeta();
    L8:
        PackParsedDTO r104 = this.parsedDTO;
        if (r104 == null) goto L13;
        PageMeta r105 = r104.getPageMeta();
        if (r105 == null) goto L13;
        LinkedTreeMap<String, Object> r106 = r105.getTrackMeta();
    L14:
        if (r103 == null) goto L16;
        Map<String, ? extends Object> r107 = r103.getPdpBcmParams();
    L17:
        if (r103 == null) goto L20;
        r101 = r103.getOptRespSize();
    L20:
        if ((!Intrinsics.areEqual(r101, Boolean.TRUE)) == true) goto L30;
        if (r106 == null) goto L31;
        if (r107 != null) goto L25;
        return;
    L25:
        if (TypeIntrinsics.isMutableMap(r107) == false) goto L27;
        r107.putAll(r106);
        Unit r108 = Unit.INSTANCE;
    L28:
        r103.setPdpBcmParams(r107);
        return;
    L27:
        HashMap r109 = new HashMap(r107.size() + r106.size());
        r109.putAll(r107);
        r109.putAll(r106);
        Unit r110 = Unit.INSTANCE;
        r107 = r109;
        goto L28
    L31:
        return;
    L30:
        return;
    L16:
        r107 = null;
    L13:
        r106 = null;
    L7:
        r103 = null;
        goto L8
    }

    public PackResponseDTO() {
        this.status = new i(0);
    }

    public PackResponseDTO clone() {
        Object r100 = super.clone();
        if (r100 == null) goto L7;
        return (PackResponseDTO) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.dto.PackResponseDTO");
    }

    public final boolean hasMultipleChunks() {
        if (isChunk() == false) goto L10;
        Integer r100 = this.chunkCount;
        if (r100 == null) goto L7;
        int r101 = r100.intValue();
    L8:
        if (r101 <= 1) goto L10;
        return true;
    L7:
        r101 = 1;
    L10:
        return false;
    }

    public final boolean isFirstChunk() {
        if (hasMultipleChunks() == false) goto L10;
        Integer r100 = this.chunkIndex;
        if (r100 == null) goto L10;
        if (r100.intValue() != 0) goto L10;
        return true;
    L10:
        return false;
    }

    public final boolean isLastChunk() {
        if (hasMultipleChunks() == false) goto L14;
        Integer r100 = this.chunkIndex;
        Integer r101 = this.chunkCount;
        if (r101 == null) goto L7;
        int r102 = r101.intValue();
    L8:
        int r103 = r102 - 1;
        if (r100 == null) goto L14;
        if (r100.intValue() != r103) goto L14;
        return true;
    L7:
        r102 = 1;
    L14:
        return false;
    }

    public final String getBdturing() {
        return this.bdturing;
    }

    public final Integer getChunkCount() {
        return this.chunkCount;
    }

    public final Integer getChunkIndex() {
        return this.chunkIndex;
    }

    public c getChunkReadingReport() {
        return this.f166507a;
    }

    public final boolean getFromCache() {
        return this.fromCache;
    }

    public final PackResponseDTO getHeadChunk() {
        return this.f166508b;
    }

    public final PromotionLogPbData getLogPb() {
        return this.logPb;
    }

    public final boolean getMini() {
        return this.mini;
    }

    public final PackParsedDTO getParsedDTO() {
        return this.parsedDTO;
    }

    public final i getStatus() {
        return this.status;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final boolean isMini() {
        return this.mini;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8286clone() {
        return clone();
    }

    public final void makeTimestamp(long r100) {
        this.status.f471167a = r100;
    }

    public final void markAsChunk(String r100) {
        Intrinsics.checkNotNullParameter(r100, "chunkId");
        i r101 = this.status;
        r101.f471170d = true;
        r101.f471171e = r100;
    }

    public final void markAsHitCache(boolean r100) {
        this.status.f471168b = r100;
    }

    public final void setBdturing(String r100) {
        this.bdturing = r100;
    }

    public final void setChunkCount(Integer r100) {
        this.chunkCount = r100;
    }

    public final void setChunkIndex(Integer r100) {
        this.chunkIndex = r100;
    }

    @Override // com.bytedance.android.chunkstreamprediction.network.d
    public void setChunkReadingReport(c r100) {
        Intrinsics.checkNotNullParameter(r100, "o");
        r100.getClass();
        monitor-enter(r100);
        List<c.a> r101 = r100.f42525a;     // Catch: Throwable -> L8
        monitor-exit(r100);
        this.f166507a = new c(r101, r100.f42526b);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void setFromCache(boolean r100) {
        this.fromCache = r100;
    }

    public final void setHeadChunk(PackResponseDTO r100) {
        this.f166508b = r100;
    }

    public final void setLogPb(PromotionLogPbData r100) {
        this.logPb = r100;
    }

    public final void setMini(boolean r100) {
        this.mini = r100;
    }

    public final void setParsedDTO(PackParsedDTO r100) {
        this.parsedDTO = r100;
    }

    public final void setTimestamp(long r100) {
        this.timestamp = r100;
    }
}

package com.bytedance.android.shopping.anchorv4.params;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.ec.model.ECAdLogParams;
import com.bytedance.android.shopping.anchorv3.compat.AdNationalTaskInfo;
import com.bytedance.android.shopping.anchorv4.components.WindowConfig;
import com.bytedance.android.shopping.api.anchorv3.ECSceneTransitionData;
import com.bytedance.android.shopping.api.anchorv3.ECShareFission;
import com.bytedance.android.shopping.api.anchorv3.WireFrameSchemaInfo;
import com.bytedance.android.shopping.api.model.ECAnchorV3ExtraData;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\bA\n\u0002\u0018\u0002\n\u0002\b?\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B½\u0004\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001a\u0012\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0003\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010%\u001a\u00020\u0003\u0012\b\b\u0002\u0010&\u001a\u00020\u0012\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u00101\u001a\u00020\u0012\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u000103\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u000107\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010=\u001a\u00020\u0003¢\u0006\u0002\u0010>J\n\u0010\u0086\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0087\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010_J\u0011\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010YJ\f\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\f\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u0018\u0010\u008f\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001aHÆ\u0003J\u0018\u0010\u0090\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001aHÆ\u0003J\n\u0010\u0091\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0092\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\n\u0010\u0095\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010\u0097\u0001\u001a\u0004\u0018\u00010\"HÆ\u0003J\f\u0010\u0098\u0001\u001a\u0004\u0018\u00010$HÆ\u0003J\n\u0010\u0099\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u009a\u0001\u001a\u00020\u0012HÆ\u0003J\f\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\n\u0010\u009c\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010\u009d\u0001\u001a\u0004\u0018\u00010)HÆ\u0003J\f\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010 \u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010¡\u0001\u001a\u0004\u0018\u00010.HÆ\u0003J\f\u0010¢\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010£\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\n\u0010¤\u0001\u001a\u00020\u0012HÆ\u0003J\f\u0010¥\u0001\u001a\u0004\u0018\u000103HÆ\u0003J\f\u0010¦\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010§\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010¨\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010©\u0001\u001a\u0004\u0018\u000107HÆ\u0003J\f\u0010ª\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010«\u0001\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010_J\f\u0010¬\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010_J\f\u0010®\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\n\u0010¯\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010°\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010±\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010²\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010³\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010´\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003JÈ\u0004\u0010µ\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\r\u001a\u00020\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001a2\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u001f\u001a\u00020\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\u00122\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u00101\u001a\u00020\u00122\n\b\u0002\u00102\u001a\u0004\u0018\u0001032\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u00106\u001a\u0004\u0018\u0001072\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010=\u001a\u00020\u0003HÆ\u0001¢\u0006\u0003\u0010¶\u0001J\u0016\u0010·\u0001\u001a\u00020\u00032\n\u0010¸\u0001\u001a\u0005\u0018\u00010¹\u0001HÖ\u0003J\n\u0010º\u0001\u001a\u00020\u0012HÖ\u0001J\n\u0010»\u0001\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0013\u0010'\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0018\u00106\u001a\u0004\u0018\u0001078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0013\u0010-\u001a\u0004\u0018\u00010.¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u0011\u0010%\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0013\u00105\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bI\u0010BR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010BR\u0013\u00100\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bK\u0010BR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bL\u0010BR\u001f\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bO\u0010HR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bP\u0010BR\u0013\u0010*\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010BR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bR\u0010BR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bS\u0010HR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010H\"\u0004\bU\u0010VR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bW\u0010HR\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010Z\u001a\u0004\bX\u0010YR\u001e\u0010=\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010H\"\u0004\b\\\u0010VR\u0011\u0010\u001c\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010HR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b]\u0010BR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010`\u001a\u0004\b^\u0010_R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\ba\u0010BR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bb\u0010BR\u0013\u0010 \u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bc\u0010BR\u0013\u0010,\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bd\u0010BR\u0013\u0010+\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\be\u0010BR\u0011\u00101\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\bf\u0010gR\u0015\u00109\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010`\u001a\u0004\bh\u0010_R\u0018\u0010<\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bi\u0010BR\u0013\u0010:\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bj\u0010BR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bk\u0010BR\u0013\u0010!\u001a\u0004\u0018\u00010\"¢\u0006\b\n\u0000\u001a\u0004\bl\u0010mR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\bn\u0010oR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bp\u0010BR\u0011\u0010\u001f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bq\u0010HR\u0011\u0010&\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\br\u0010gR\u0013\u00104\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bs\u0010BR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bt\u0010BR\u001f\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\bu\u0010NR\u0013\u00102\u001a\u0004\u0018\u000103¢\u0006\b\n\u0000\u001a\u0004\bv\u0010wR\u001d\u0010x\u001a\u0004\u0018\u00010y8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b|\u0010}\u001a\u0004\bz\u0010{R\u0013\u00108\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b~\u0010BR\u0015\u0010;\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010`\u001a\u0004\b\u007f\u0010_R\u0014\u0010/\u001a\u0004\u0018\u00010\u0007¢\u0006\t\n\u0000\u001a\u0005\b\u0080\u0001\u0010BR\u0014\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\t\n\u0000\u001a\u0005\b\u0081\u0001\u0010BR\u0015\u0010(\u001a\u0004\u0018\u00010)¢\u0006\n\n\u0000\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0015\u0010#\u001a\u0004\u0018\u00010$¢\u0006\n\n\u0000\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001¨\u0006¼\u0001"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/params/V4NativeParams;", "Ljava/io/Serializable;", "fullMode", "", "fromLive", "fromLiveCartList", "productId", "", "itemId", "shopId", "firstCid", "liveRoomId", "v3EventsAdditions", "disableLiveWindow", "sourcePage", "carrierType", "liveHotSaleComponent", "lastEcomSceneId", "", "halfHeadScale", "", "shareFission", "Lcom/bytedance/android/shopping/api/anchorv3/ECShareFission;", "adLogParams", "Lcom/bytedance/android/ec/model/ECAdLogParams;", "detailApiImagesConstraint", "", "storeRecommendApiImageConstraints", "isFromFeedProductGuessULike", "frameCovImage", "covImageUri", "showShareBtnAnimation", "maskColor", "sceneTransitionData", "Lcom/bytedance/android/shopping/api/anchorv3/ECSceneTransitionData;", "wireFrameSchemaInfo", "Lcom/bytedance/android/shopping/api/anchorv3/WireFrameSchemaInfo;", "asyncInflate", "showSkuPanel", "adUiControlParams", "windowConfig", "Lcom/bytedance/android/shopping/anchorv4/components/WindowConfig;", "fractionListenerId", "pageStateListenerId", "pageStateListenerExtra", "anchorV3ExtraData", "Lcom/bytedance/android/shopping/api/model/ECAnchorV3ExtraData;", "userId", "clearScreenUpon", "panelHeight", "taskInfo", "Lcom/bytedance/android/shopping/anchorv3/compat/AdNationalTaskInfo;", "sourceBtmToken", "bcmParams", "aiConversationContext", "Lcom/bytedance/android/shopping/anchorv4/params/PdpAIConversationContext;", "topLabelText", "panelHeightPercent", "pendantParams", "touTiaoAppId", "pdpEventTransparentId", "hasCustomWindowAnimation", "(ZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Float;Lcom/bytedance/android/shopping/api/anchorv3/ECShareFission;Lcom/bytedance/android/ec/model/ECAdLogParams;Ljava/util/Map;Ljava/util/Map;ZLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lcom/bytedance/android/shopping/api/anchorv3/ECSceneTransitionData;Lcom/bytedance/android/shopping/api/anchorv3/WireFrameSchemaInfo;ZILjava/lang/String;Lcom/bytedance/android/shopping/anchorv4/components/WindowConfig;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/api/model/ECAnchorV3ExtraData;Ljava/lang/String;Ljava/lang/String;ILcom/bytedance/android/shopping/anchorv3/compat/AdNationalTaskInfo;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv4/params/PdpAIConversationContext;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Z)V", "getAdLogParams", "()Lcom/bytedance/android/ec/model/ECAdLogParams;", "getAdUiControlParams", "()Ljava/lang/String;", "getAiConversationContext", "()Lcom/bytedance/android/shopping/anchorv4/params/PdpAIConversationContext;", "getAnchorV3ExtraData", "()Lcom/bytedance/android/shopping/api/model/ECAnchorV3ExtraData;", "getAsyncInflate", "()Z", "getBcmParams", "getCarrierType", "getClearScreenUpon", "getCovImageUri", "getDetailApiImagesConstraint", "()Ljava/util/Map;", "getDisableLiveWindow", "getFirstCid", "getFractionListenerId", "getFrameCovImage", "getFromLive", "getFromLiveCartList", "setFromLiveCartList", "(Z)V", "getFullMode", "getHalfHeadScale", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getHasCustomWindowAnimation", "setHasCustomWindowAnimation", "getItemId", "getLastEcomSceneId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLiveHotSaleComponent", "getLiveRoomId", "getMaskColor", "getPageStateListenerExtra", "getPageStateListenerId", "getPanelHeight", "()I", "getPanelHeightPercent", "getPdpEventTransparentId", "getPendantParams", "getProductId", "getSceneTransitionData", "()Lcom/bytedance/android/shopping/api/anchorv3/ECSceneTransitionData;", "getShareFission", "()Lcom/bytedance/android/shopping/api/anchorv3/ECShareFission;", "getShopId", "getShowShareBtnAnimation", "getShowSkuPanel", "getSourceBtmToken", "getSourcePage", "getStoreRecommendApiImageConstraints", "getTaskInfo", "()Lcom/bytedance/android/shopping/anchorv3/compat/AdNationalTaskInfo;", "taskRequestParams", "Lorg/json/JSONObject;", "getTaskRequestParams", "()Lorg/json/JSONObject;", "taskRequestParams$delegate", "Lkotlin/Lazy;", "getTopLabelText", "getTouTiaoAppId", "getUserId", "getV3EventsAdditions", "getWindowConfig", "()Lcom/bytedance/android/shopping/anchorv4/components/WindowConfig;", "getWireFrameSchemaInfo", "()Lcom/bytedance/android/shopping/api/anchorv3/WireFrameSchemaInfo;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component5", "component6", "component7", "component8", "component9", "copy", "(ZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Float;Lcom/bytedance/android/shopping/api/anchorv3/ECShareFission;Lcom/bytedance/android/ec/model/ECAdLogParams;Ljava/util/Map;Ljava/util/Map;ZLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lcom/bytedance/android/shopping/api/anchorv3/ECSceneTransitionData;Lcom/bytedance/android/shopping/api/anchorv3/WireFrameSchemaInfo;ZILjava/lang/String;Lcom/bytedance/android/shopping/anchorv4/components/WindowConfig;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/api/model/ECAnchorV3ExtraData;Ljava/lang/String;Ljava/lang/String;ILcom/bytedance/android/shopping/anchorv3/compat/AdNationalTaskInfo;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv4/params/PdpAIConversationContext;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Z)Lcom/bytedance/android/shopping/anchorv4/params/V4NativeParams;", "equals", "other", "", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class V4NativeParams implements Serializable {
    private final ECAdLogParams adLogParams;
    private final String adUiControlParams;

    @SerializedName("ai_conversation_context")
    private final PdpAIConversationContext aiConversationContext;
    private final ECAnchorV3ExtraData anchorV3ExtraData;
    private final boolean asyncInflate;
    private final String bcmParams;
    private final String carrierType;
    private final String clearScreenUpon;
    private final String covImageUri;
    private final Map<String, String> detailApiImagesConstraint;
    private final boolean disableLiveWindow;
    private final String firstCid;
    private final String fractionListenerId;
    private final String frameCovImage;
    private final boolean fromLive;
    private boolean fromLiveCartList;
    private final boolean fullMode;
    private final Float halfHeadScale;

    @SerializedName("has_custom_window_animation")
    private boolean hasCustomWindowAnimation;
    private final boolean isFromFeedProductGuessULike;
    private final String itemId;
    private final Integer lastEcomSceneId;
    private final String liveHotSaleComponent;
    private final String liveRoomId;
    private final String maskColor;
    private final String pageStateListenerExtra;
    private final String pageStateListenerId;
    private final int panelHeight;
    private final Integer panelHeightPercent;

    @SerializedName("pdp_event_transparent_id")
    private final String pdpEventTransparentId;
    private final String pendantParams;
    private final String productId;
    private final ECSceneTransitionData sceneTransitionData;
    private final ECShareFission shareFission;
    private final String shopId;
    private final boolean showShareBtnAnimation;
    private final int showSkuPanel;
    private final String sourceBtmToken;
    private final String sourcePage;
    private final Map<String, String> storeRecommendApiImageConstraints;
    private final AdNationalTaskInfo taskInfo;
    private final Lazy taskRequestParams$delegate;
    private final String topLabelText;
    private final Integer touTiaoAppId;
    private final String userId;
    private final String v3EventsAdditions;
    private final WindowConfig windowConfig;
    private final WireFrameSchemaInfo wireFrameSchemaInfo;

    public V4NativeParams() {
        this(false, false, false, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, false, null, null, false, null, null, null, false, 0, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, -1, 32767, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ V4NativeParams copy$default(V4NativeParams r110, boolean r111, boolean r112, boolean r210, String r211, String r212, String r213, String r214, String r215, String r216, boolean r217, String r218, String r219, String r310, Integer r311, Float r312, ECShareFission r313, ECAdLogParams r314, Map r315, Map r316, boolean r317, String r318, String r319, boolean r410, String r411, ECSceneTransitionData r412, WireFrameSchemaInfo r413, boolean r414, int r415, String r416, WindowConfig r417, String r418, String r419, String r510, ECAnchorV3ExtraData r511, String r512, String r513, int r514, AdNationalTaskInfo r515, String r516, String r517, PdpAIConversationContext r518, String r519, Integer r610, String r611, Integer r612, String r613, boolean r614, int r615, int r616, Object r617) {
        if ((r615 & 1) == 0) goto L5;
        boolean r100 = r110.fullMode;
    L7:
        if ((r615 & 2) == 0) goto L9;
        boolean r101 = r110.fromLive;
    L11:
        if ((r615 & 4) == 0) goto L13;
        boolean r102 = r110.fromLiveCartList;
    L15:
        if ((r615 & 8) == 0) goto L17;
        String r103 = r110.productId;
    L19:
        if ((r615 & 16) == 0) goto L21;
        String r104 = r110.itemId;
    L23:
        if ((r615 & 32) == 0) goto L25;
        String r105 = r110.shopId;
    L27:
        if ((r615 & 64) == 0) goto L29;
        String r106 = r110.firstCid;
    L31:
        if ((r615 & 128) == 0) goto L33;
        String r113 = r110.liveRoomId;
    L35:
        if ((r615 & 256) == 0) goto L37;
        String r114 = r110.v3EventsAdditions;
    L39:
        if ((r615 & 512) == 0) goto L41;
        boolean r115 = r110.disableLiveWindow;
    L43:
        if ((r615 & 1024) == 0) goto L45;
        String r116 = r110.sourcePage;
    L47:
        if ((r615 & 2048) == 0) goto L49;
        String r117 = r110.carrierType;
    L51:
        if ((r615 & 4096) == 0) goto L53;
        String r118 = r110.liveHotSaleComponent;
    L54:
        String r320 = r118;
        if ((r615 & 8192) == 0) goto L57;
        Integer r119 = r110.lastEcomSceneId;
    L58:
        Integer r321 = r119;
        if ((r615 & 16384) == 0) goto L61;
        Float r120 = r110.halfHeadScale;
    L62:
        Float r322 = r120;
        if ((r615 & 32768) == 0) goto L65;
        ECShareFission r121 = r110.shareFission;
    L66:
        ECShareFission r323 = r121;
        if ((r615 & 65536) == 0) goto L69;
        ECAdLogParams r122 = r110.adLogParams;
    L70:
        ECAdLogParams r324 = r122;
        if ((r615 & 131072) == 0) goto L73;
        Map r123 = r110.detailApiImagesConstraint;
    L74:
        Map r325 = r123;
        if ((r615 & 262144) == 0) goto L77;
        Map r124 = r110.storeRecommendApiImageConstraints;
    L78:
        Map r326 = r124;
        if ((r615 & 524288) == 0) goto L81;
        boolean r125 = r110.isFromFeedProductGuessULike;
    L82:
        boolean r327 = r125;
        if ((r615 & 1048576) == 0) goto L85;
        String r126 = r110.frameCovImage;
    L86:
        String r328 = r126;
        if ((r615 & 2097152) == 0) goto L89;
        String r127 = r110.covImageUri;
    L90:
        String r329 = r127;
        if ((r615 & 4194304) == 0) goto L93;
        boolean r128 = r110.showShareBtnAnimation;
    L94:
        boolean r420 = r128;
        if ((r615 & 8388608) == 0) goto L97;
        String r129 = r110.maskColor;
    L98:
        String r421 = r129;
        if ((r615 & 16777216) == 0) goto L101;
        ECSceneTransitionData r130 = r110.sceneTransitionData;
    L102:
        ECSceneTransitionData r422 = r130;
        if ((r615 & 33554432) == 0) goto L105;
        WireFrameSchemaInfo r131 = r110.wireFrameSchemaInfo;
    L106:
        WireFrameSchemaInfo r423 = r131;
        if ((r615 & 67108864) == 0) goto L109;
        boolean r132 = r110.asyncInflate;
    L110:
        boolean r424 = r132;
        if ((r615 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        int r133 = r110.showSkuPanel;
    L114:
        int r425 = r133;
        if ((r615 & 268435456) == 0) goto L117;
        String r134 = r110.adUiControlParams;
    L118:
        String r426 = r134;
        if ((r615 & 536870912) == 0) goto L121;
        WindowConfig r135 = r110.windowConfig;
    L122:
        WindowConfig r427 = r135;
        if ((r615 & 1073741824) == 0) goto L125;
        String r136 = r110.fractionListenerId;
    L127:
        if ((r615 & Integer.MIN_VALUE) == 0) goto L129;
        String r107 = r110.pageStateListenerId;
    L130:
        String r428 = r107;
        if ((r616 & 1) == 0) goto L133;
        String r108 = r110.pageStateListenerExtra;
    L134:
        String r520 = r108;
        if ((r616 & 2) == 0) goto L137;
        ECAnchorV3ExtraData r109 = r110.anchorV3ExtraData;
    L138:
        ECAnchorV3ExtraData r521 = r109;
        if ((r616 & 4) == 0) goto L141;
        String r137 = r110.userId;
    L142:
        String r522 = r137;
        if ((r616 & 8) == 0) goto L145;
        String r138 = r110.clearScreenUpon;
    L146:
        String r523 = r138;
        if ((r616 & 16) == 0) goto L149;
        int r139 = r110.panelHeight;
    L150:
        int r524 = r139;
        if ((r616 & 32) == 0) goto L153;
        AdNationalTaskInfo r140 = r110.taskInfo;
    L154:
        AdNationalTaskInfo r525 = r140;
        if ((r616 & 64) == 0) goto L157;
        String r141 = r110.sourceBtmToken;
    L158:
        String r526 = r141;
        if ((r616 & 128) == 0) goto L161;
        String r142 = r110.bcmParams;
    L162:
        String r527 = r142;
        if ((r616 & 256) == 0) goto L165;
        PdpAIConversationContext r143 = r110.aiConversationContext;
    L166:
        PdpAIConversationContext r528 = r143;
        if ((r616 & 512) == 0) goto L169;
        String r144 = r110.topLabelText;
    L170:
        String r529 = r144;
        if ((r616 & 1024) == 0) goto L173;
        Integer r145 = r110.panelHeightPercent;
    L174:
        Integer r618 = r145;
        if ((r616 & 2048) == 0) goto L177;
        String r146 = r110.pendantParams;
    L178:
        String r619 = r146;
        if ((r616 & 4096) == 0) goto L181;
        Integer r147 = r110.touTiaoAppId;
    L182:
        Integer r620 = r147;
        if ((r616 & 8192) == 0) goto L185;
        String r148 = r110.pdpEventTransparentId;
    L187:
        if ((r616 & 16384) == 0) goto L189;
        boolean r149 = r110.hasCustomWindowAnimation;
    L191:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r325, r326, r327, r328, r329, r420, r421, r422, r423, r424, r425, r426, r427, r136, r428, r520, r521, r522, r523, r524, r525, r526, r527, r528, r529, r618, r619, r620, r148, r149);
    L189:
        r149 = r614;
        goto L191
    L185:
        r148 = r613;
        goto L187
    L181:
        r147 = r612;
        goto L182
    L177:
        r146 = r611;
        goto L178
    L173:
        r145 = r610;
        goto L174
    L169:
        r144 = r519;
        goto L170
    L165:
        r143 = r518;
        goto L166
    L161:
        r142 = r517;
        goto L162
    L157:
        r141 = r516;
        goto L158
    L153:
        r140 = r515;
        goto L154
    L149:
        r139 = r514;
        goto L150
    L145:
        r138 = r513;
        goto L146
    L141:
        r137 = r512;
        goto L142
    L137:
        r109 = r511;
        goto L138
    L133:
        r108 = r510;
        goto L134
    L129:
        r107 = r419;
        goto L130
    L125:
        r136 = r418;
        goto L127
    L121:
        r135 = r417;
        goto L122
    L117:
        r134 = r416;
        goto L118
    L113:
        r133 = r415;
        goto L114
    L109:
        r132 = r414;
        goto L110
    L105:
        r131 = r413;
        goto L106
    L101:
        r130 = r412;
        goto L102
    L97:
        r129 = r411;
        goto L98
    L93:
        r128 = r410;
        goto L94
    L89:
        r127 = r319;
        goto L90
    L85:
        r126 = r318;
        goto L86
    L81:
        r125 = r317;
        goto L82
    L77:
        r124 = r316;
        goto L78
    L73:
        r123 = r315;
        goto L74
    L69:
        r122 = r314;
        goto L70
    L65:
        r121 = r313;
        goto L66
    L61:
        r120 = r312;
        goto L62
    L57:
        r119 = r311;
        goto L58
    L53:
        r118 = r310;
        goto L54
    L49:
        r117 = r219;
        goto L51
    L45:
        r116 = r218;
        goto L47
    L41:
        r115 = r217;
        goto L43
    L37:
        r114 = r216;
        goto L39
    L33:
        r113 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final boolean component1() {
        return this.fullMode;
    }

    public final boolean component10() {
        return this.disableLiveWindow;
    }

    public final String component11() {
        return this.sourcePage;
    }

    public final String component12() {
        return this.carrierType;
    }

    public final String component13() {
        return this.liveHotSaleComponent;
    }

    public final Integer component14() {
        return this.lastEcomSceneId;
    }

    public final Float component15() {
        return this.halfHeadScale;
    }

    public final ECShareFission component16() {
        return this.shareFission;
    }

    public final ECAdLogParams component17() {
        return this.adLogParams;
    }

    public final Map<String, String> component18() {
        return this.detailApiImagesConstraint;
    }

    public final Map<String, String> component19() {
        return this.storeRecommendApiImageConstraints;
    }

    public final boolean component2() {
        return this.fromLive;
    }

    public final boolean component20() {
        return this.isFromFeedProductGuessULike;
    }

    public final String component21() {
        return this.frameCovImage;
    }

    public final String component22() {
        return this.covImageUri;
    }

    public final boolean component23() {
        return this.showShareBtnAnimation;
    }

    public final String component24() {
        return this.maskColor;
    }

    public final ECSceneTransitionData component25() {
        return this.sceneTransitionData;
    }

    public final WireFrameSchemaInfo component26() {
        return this.wireFrameSchemaInfo;
    }

    public final boolean component27() {
        return this.asyncInflate;
    }

    public final int component28() {
        return this.showSkuPanel;
    }

    public final String component29() {
        return this.adUiControlParams;
    }

    public final boolean component3() {
        return this.fromLiveCartList;
    }

    public final WindowConfig component30() {
        return this.windowConfig;
    }

    public final String component31() {
        return this.fractionListenerId;
    }

    public final String component32() {
        return this.pageStateListenerId;
    }

    public final String component33() {
        return this.pageStateListenerExtra;
    }

    public final ECAnchorV3ExtraData component34() {
        return this.anchorV3ExtraData;
    }

    public final String component35() {
        return this.userId;
    }

    public final String component36() {
        return this.clearScreenUpon;
    }

    public final int component37() {
        return this.panelHeight;
    }

    public final AdNationalTaskInfo component38() {
        return this.taskInfo;
    }

    public final String component39() {
        return this.sourceBtmToken;
    }

    public final String component4() {
        return this.productId;
    }

    public final String component40() {
        return this.bcmParams;
    }

    public final PdpAIConversationContext component41() {
        return this.aiConversationContext;
    }

    public final String component42() {
        return this.topLabelText;
    }

    public final Integer component43() {
        return this.panelHeightPercent;
    }

    public final String component44() {
        return this.pendantParams;
    }

    public final Integer component45() {
        return this.touTiaoAppId;
    }

    public final String component46() {
        return this.pdpEventTransparentId;
    }

    public final boolean component47() {
        return this.hasCustomWindowAnimation;
    }

    public final String component5() {
        return this.itemId;
    }

    public final String component6() {
        return this.shopId;
    }

    public final String component7() {
        return this.firstCid;
    }

    public final String component8() {
        return this.liveRoomId;
    }

    public final String component9() {
        return this.v3EventsAdditions;
    }

    public final V4NativeParams copy(boolean r510, boolean r511, boolean r512, String r513, String r514, String r515, String r516, String r517, String r518, boolean r519, String r610, String r611, String r612, Integer r613, Float r614, ECShareFission r615, ECAdLogParams r616, Map<String, String> r617, Map<String, String> r618, boolean r619, String r710, String r711, boolean r712, String r713, ECSceneTransitionData r714, WireFrameSchemaInfo r715, boolean r716, int r717, String r718, WindowConfig r719, String r810, String r811, String r812, ECAnchorV3ExtraData r813, String r814, String r815, int r816, AdNationalTaskInfo r817, String r818, String r819, PdpAIConversationContext r910, String r911, Integer r912, String r913, Integer r914, String r915, boolean r916) {
        return new V4NativeParams(r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r710, r711, r712, r713, r714, r715, r716, r717, r718, r719, r810, r811, r812, r813, r814, r815, r816, r817, r818, r819, r910, r911, r912, r913, r914, r915, r916);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof V4NativeParams) == false) goto L100;
        V4NativeParams r101 = (V4NativeParams) r100;
        if (this.fullMode == r101.fullMode) goto L8;
        return false;
    L8:
        if (this.fromLive == r101.fromLive) goto L10;
        return false;
    L10:
        if (this.fromLiveCartList == r101.fromLiveCartList) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.productId, r101.productId) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.itemId, r101.itemId) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.shopId, r101.shopId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.firstCid, r101.firstCid) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.liveRoomId, r101.liveRoomId) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.v3EventsAdditions, r101.v3EventsAdditions) == true) goto L24;
        return false;
    L24:
        if (this.disableLiveWindow == r101.disableLiveWindow) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.sourcePage, r101.sourcePage) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.carrierType, r101.carrierType) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.liveHotSaleComponent, r101.liveHotSaleComponent) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.lastEcomSceneId, r101.lastEcomSceneId) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.halfHeadScale, r101.halfHeadScale) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.shareFission, r101.shareFission) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.adLogParams, r101.adLogParams) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.detailApiImagesConstraint, r101.detailApiImagesConstraint) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.storeRecommendApiImageConstraints, r101.storeRecommendApiImageConstraints) == true) goto L44;
        return false;
    L44:
        if (this.isFromFeedProductGuessULike == r101.isFromFeedProductGuessULike) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.frameCovImage, r101.frameCovImage) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.covImageUri, r101.covImageUri) == true) goto L50;
        return false;
    L50:
        if (this.showShareBtnAnimation == r101.showShareBtnAnimation) goto L52;
        return false;
    L52:
        if (Intrinsics.areEqual(this.maskColor, r101.maskColor) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.sceneTransitionData, r101.sceneTransitionData) == true) goto L56;
        return false;
    L56:
        if (Intrinsics.areEqual(this.wireFrameSchemaInfo, r101.wireFrameSchemaInfo) == true) goto L58;
        return false;
    L58:
        if (this.asyncInflate == r101.asyncInflate) goto L60;
        return false;
    L60:
        if (this.showSkuPanel == r101.showSkuPanel) goto L62;
        return false;
    L62:
        if (Intrinsics.areEqual(this.adUiControlParams, r101.adUiControlParams) == true) goto L64;
        return false;
    L64:
        if (Intrinsics.areEqual(this.windowConfig, r101.windowConfig) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.fractionListenerId, r101.fractionListenerId) == true) goto L68;
        return false;
    L68:
        if (Intrinsics.areEqual(this.pageStateListenerId, r101.pageStateListenerId) == true) goto L70;
        return false;
    L70:
        if (Intrinsics.areEqual(this.pageStateListenerExtra, r101.pageStateListenerExtra) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.anchorV3ExtraData, r101.anchorV3ExtraData) == true) goto L74;
        return false;
    L74:
        if (Intrinsics.areEqual(this.userId, r101.userId) == true) goto L76;
        return false;
    L76:
        if (Intrinsics.areEqual(this.clearScreenUpon, r101.clearScreenUpon) == true) goto L78;
        return false;
    L78:
        if (this.panelHeight == r101.panelHeight) goto L80;
        return false;
    L80:
        if (Intrinsics.areEqual(this.taskInfo, r101.taskInfo) == true) goto L82;
        return false;
    L82:
        if (Intrinsics.areEqual(this.sourceBtmToken, r101.sourceBtmToken) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.bcmParams, r101.bcmParams) == true) goto L86;
        return false;
    L86:
        if (Intrinsics.areEqual(this.aiConversationContext, r101.aiConversationContext) == true) goto L88;
        return false;
    L88:
        if (Intrinsics.areEqual(this.topLabelText, r101.topLabelText) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.panelHeightPercent, r101.panelHeightPercent) == true) goto L92;
        return false;
    L92:
        if (Intrinsics.areEqual(this.pendantParams, r101.pendantParams) == true) goto L94;
        return false;
    L94:
        if (Intrinsics.areEqual(this.touTiaoAppId, r101.touTiaoAppId) == true) goto L96;
        return false;
    L96:
        if (Intrinsics.areEqual(this.pdpEventTransparentId, r101.pdpEventTransparentId) == true) goto L98;
        return false;
    L98:
        if (this.hasCustomWindowAnimation == r101.hasCustomWindowAnimation) goto L151;
        return false;
    L151:
        return true;
    L100:
        return false;
    }

    public final JSONObject getTaskRequestParams() {
        return (JSONObject) this.taskRequestParams$delegate.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v19, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v93, types: [int] */
    /* JADX WARN: Type inference failed for: r0v94 */
    /* JADX WARN: Type inference failed for: r0v95 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v140 */
    /* JADX WARN: Type inference failed for: r2v144 */
    /* JADX WARN: Type inference failed for: r2v147 */
    /* JADX WARN: Type inference failed for: r2v157 */
    /* JADX WARN: Type inference failed for: r2v164 */
    /* JADX WARN: Type inference failed for: r2v165 */
    /* JADX WARN: Type inference failed for: r2v166 */
    /* JADX WARN: Type inference failed for: r2v167 */
    /* JADX WARN: Type inference failed for: r2v168 */
    /* JADX WARN: Type inference failed for: r2v169 */
    /* JADX WARN: Type inference failed for: r2v170 */
    /* JADX WARN: Type inference failed for: r2v171 */
    /* JADX WARN: Type inference failed for: r2v23, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v52, types: [int] */
    /* JADX WARN: Type inference failed for: r2v60, types: [int] */
    /* JADX WARN: Type inference failed for: r2v71, types: [int] */
    public int hashCode() {
        boolean r100 = this.fullMode;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.fromLive;
        ?? r105 = r104;
        if (r104 == false) goto L8;
        r105 = 1;
    L8:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.fromLiveCartList;
        ?? r108 = r107;
        if (r107 == false) goto L11;
        r108 = 1;
    L11:
        int r109 = (r106 + r108) * 31;
        String r110 = this.productId;
        int r111 = 0;
        if (r110 == null) goto L14;
        int r112 = r110.hashCode();
    L15:
        int r113 = (r109 + r112) * 31;
        String r114 = this.itemId;
        if (r114 == null) goto L18;
        int r115 = r114.hashCode();
    L19:
        int r116 = (r113 + r115) * 31;
        String r117 = this.shopId;
        if (r117 == null) goto L22;
        int r118 = r117.hashCode();
    L23:
        int r119 = (r116 + r118) * 31;
        String r120 = this.firstCid;
        if (r120 == null) goto L26;
        int r121 = r120.hashCode();
    L27:
        int r122 = (r119 + r121) * 31;
        String r123 = this.liveRoomId;
        if (r123 == null) goto L30;
        int r124 = r123.hashCode();
    L31:
        int r125 = (r122 + r124) * 31;
        String r126 = this.v3EventsAdditions;
        if (r126 == null) goto L34;
        int r127 = r126.hashCode();
    L35:
        int r128 = (r125 + r127) * 31;
        boolean r129 = this.disableLiveWindow;
        ?? r130 = r129;
        if (r129 == false) goto L38;
        r130 = 1;
    L38:
        int r131 = (r128 + r130) * 31;
        String r132 = this.sourcePage;
        if (r132 == null) goto L41;
        int r133 = r132.hashCode();
    L42:
        int r134 = (r131 + r133) * 31;
        String r135 = this.carrierType;
        if (r135 == null) goto L45;
        int r136 = r135.hashCode();
    L46:
        int r137 = (r134 + r136) * 31;
        String r138 = this.liveHotSaleComponent;
        if (r138 == null) goto L49;
        int r139 = r138.hashCode();
    L50:
        int r140 = (r137 + r139) * 31;
        Integer r141 = this.lastEcomSceneId;
        if (r141 == null) goto L53;
        int r142 = r141.hashCode();
    L54:
        int r143 = (r140 + r142) * 31;
        Float r144 = this.halfHeadScale;
        if (r144 == null) goto L57;
        int r145 = r144.hashCode();
    L58:
        int r146 = (r143 + r145) * 31;
        ECShareFission r147 = this.shareFission;
        if (r147 == null) goto L61;
        int r148 = r147.hashCode();
    L62:
        int r149 = (r146 + r148) * 31;
        ECAdLogParams r150 = this.adLogParams;
        if (r150 == null) goto L65;
        int r151 = r150.hashCode();
    L66:
        int r152 = (r149 + r151) * 31;
        Map<String, String> r153 = this.detailApiImagesConstraint;
        if (r153 == null) goto L69;
        int r154 = r153.hashCode();
    L70:
        int r155 = (r152 + r154) * 31;
        Map<String, String> r156 = this.storeRecommendApiImageConstraints;
        if (r156 == null) goto L73;
        int r157 = r156.hashCode();
    L74:
        int r158 = (r155 + r157) * 31;
        boolean r159 = this.isFromFeedProductGuessULike;
        ?? r160 = r159;
        if (r159 == false) goto L77;
        r160 = 1;
    L77:
        int r161 = (r158 + r160) * 31;
        String r162 = this.frameCovImage;
        if (r162 == null) goto L80;
        int r163 = r162.hashCode();
    L81:
        int r164 = (r161 + r163) * 31;
        String r165 = this.covImageUri;
        if (r165 == null) goto L84;
        int r166 = r165.hashCode();
    L85:
        int r167 = (r164 + r166) * 31;
        boolean r168 = this.showShareBtnAnimation;
        ?? r169 = r168;
        if (r168 == false) goto L88;
        r169 = 1;
    L88:
        int r170 = (r167 + r169) * 31;
        String r171 = this.maskColor;
        if (r171 == null) goto L91;
        int r172 = r171.hashCode();
    L92:
        int r173 = (r170 + r172) * 31;
        ECSceneTransitionData r174 = this.sceneTransitionData;
        if (r174 == null) goto L95;
        int r175 = r174.hashCode();
    L96:
        int r176 = (r173 + r175) * 31;
        WireFrameSchemaInfo r177 = this.wireFrameSchemaInfo;
        if (r177 == null) goto L99;
        int r178 = r177.hashCode();
    L100:
        int r179 = (r176 + r178) * 31;
        boolean r180 = this.asyncInflate;
        ?? r181 = r180;
        if (r180 == false) goto L103;
        r181 = 1;
    L103:
        int r182 = (((r179 + r181) * 31) + this.showSkuPanel) * 31;
        String r183 = this.adUiControlParams;
        if (r183 == null) goto L106;
        int r184 = r183.hashCode();
    L107:
        int r185 = (r182 + r184) * 31;
        WindowConfig r186 = this.windowConfig;
        if (r186 == null) goto L110;
        int r187 = r186.hashCode();
    L111:
        int r188 = (r185 + r187) * 31;
        String r189 = this.fractionListenerId;
        if (r189 == null) goto L114;
        int r190 = r189.hashCode();
    L115:
        int r191 = (r188 + r190) * 31;
        String r192 = this.pageStateListenerId;
        if (r192 == null) goto L118;
        int r193 = r192.hashCode();
    L119:
        int r194 = (r191 + r193) * 31;
        String r195 = this.pageStateListenerExtra;
        if (r195 == null) goto L122;
        int r196 = r195.hashCode();
    L123:
        int r197 = (r194 + r196) * 31;
        ECAnchorV3ExtraData r198 = this.anchorV3ExtraData;
        if (r198 == null) goto L126;
        int r199 = r198.hashCode();
    L127:
        int r200 = (r197 + r199) * 31;
        String r201 = this.userId;
        if (r201 == null) goto L130;
        int r202 = r201.hashCode();
    L131:
        int r203 = (r200 + r202) * 31;
        String r204 = this.clearScreenUpon;
        if (r204 == null) goto L134;
        int r205 = r204.hashCode();
    L135:
        int r206 = (((r203 + r205) * 31) + this.panelHeight) * 31;
        AdNationalTaskInfo r207 = this.taskInfo;
        if (r207 == null) goto L138;
        int r208 = r207.hashCode();
    L139:
        int r209 = (r206 + r208) * 31;
        String r210 = this.sourceBtmToken;
        if (r210 == null) goto L142;
        int r211 = r210.hashCode();
    L143:
        int r212 = (r209 + r211) * 31;
        String r213 = this.bcmParams;
        if (r213 == null) goto L146;
        int r214 = r213.hashCode();
    L147:
        int r215 = (r212 + r214) * 31;
        PdpAIConversationContext r216 = this.aiConversationContext;
        if (r216 == null) goto L150;
        int r217 = r216.hashCode();
    L151:
        int r218 = (r215 + r217) * 31;
        String r219 = this.topLabelText;
        if (r219 == null) goto L154;
        int r220 = r219.hashCode();
    L155:
        int r221 = (r218 + r220) * 31;
        Integer r222 = this.panelHeightPercent;
        if (r222 == null) goto L158;
        int r223 = r222.hashCode();
    L159:
        int r224 = (r221 + r223) * 31;
        String r225 = this.pendantParams;
        if (r225 == null) goto L162;
        int r226 = r225.hashCode();
    L163:
        int r227 = (r224 + r226) * 31;
        Integer r228 = this.touTiaoAppId;
        if (r228 == null) goto L166;
        int r229 = r228.hashCode();
    L167:
        int r230 = (r227 + r229) * 31;
        String r231 = this.pdpEventTransparentId;
        if (r231 == null) goto L170;
        r111 = r231.hashCode();
    L170:
        int r232 = (r230 + r111) * 31;
        boolean r233 = this.hasCustomWindowAnimation;
        if (r233 == true) goto L175;
        r101 = r233;
    L175:
        return r232 + r101;
    L166:
        r229 = 0;
        goto L167
    L162:
        r226 = 0;
        goto L163
    L158:
        r223 = 0;
        goto L159
    L154:
        r220 = 0;
        goto L155
    L150:
        r217 = 0;
        goto L151
    L146:
        r214 = 0;
        goto L147
    L142:
        r211 = 0;
        goto L143
    L138:
        r208 = 0;
        goto L139
    L134:
        r205 = 0;
        goto L135
    L130:
        r202 = 0;
        goto L131
    L126:
        r199 = 0;
        goto L127
    L122:
        r196 = 0;
        goto L123
    L118:
        r193 = 0;
        goto L119
    L114:
        r190 = 0;
        goto L115
    L110:
        r187 = 0;
        goto L111
    L106:
        r184 = 0;
        goto L107
    L99:
        r178 = 0;
        goto L100
    L95:
        r175 = 0;
        goto L96
    L91:
        r172 = 0;
        goto L92
    L84:
        r166 = 0;
        goto L85
    L80:
        r163 = 0;
        goto L81
    L73:
        r157 = 0;
        goto L74
    L69:
        r154 = 0;
        goto L70
    L65:
        r151 = 0;
        goto L66
    L61:
        r148 = 0;
        goto L62
    L57:
        r145 = 0;
        goto L58
    L53:
        r142 = 0;
        goto L54
    L49:
        r139 = 0;
        goto L50
    L45:
        r136 = 0;
        goto L46
    L41:
        r133 = 0;
        goto L42
    L34:
        r127 = 0;
        goto L35
    L30:
        r124 = 0;
        goto L31
    L26:
        r121 = 0;
        goto L27
    L22:
        r118 = 0;
        goto L23
    L18:
        r115 = 0;
        goto L19
    L14:
        r112 = 0;
        goto L15
    }

    public String toString() {
        return "V4NativeParams(fullMode=" + this.fullMode + ", fromLive=" + this.fromLive + ", fromLiveCartList=" + this.fromLiveCartList + ", productId=" + this.productId + ", itemId=" + this.itemId + ", shopId=" + this.shopId + ", firstCid=" + this.firstCid + ", liveRoomId=" + this.liveRoomId + ", v3EventsAdditions=" + this.v3EventsAdditions + ", disableLiveWindow=" + this.disableLiveWindow + ", sourcePage=" + this.sourcePage + ", carrierType=" + this.carrierType + ", liveHotSaleComponent=" + this.liveHotSaleComponent + ", lastEcomSceneId=" + this.lastEcomSceneId + ", halfHeadScale=" + this.halfHeadScale + ", shareFission=" + this.shareFission + ", adLogParams=" + this.adLogParams + ", detailApiImagesConstraint=" + this.detailApiImagesConstraint + ", storeRecommendApiImageConstraints=" + this.storeRecommendApiImageConstraints + ", isFromFeedProductGuessULike=" + this.isFromFeedProductGuessULike + ", frameCovImage=" + this.frameCovImage + ", covImageUri=" + this.covImageUri + ", showShareBtnAnimation=" + this.showShareBtnAnimation + ", maskColor=" + this.maskColor + ", sceneTransitionData=" + this.sceneTransitionData + ", wireFrameSchemaInfo=" + this.wireFrameSchemaInfo + ", asyncInflate=" + this.asyncInflate + ", showSkuPanel=" + this.showSkuPanel + ", adUiControlParams=" + this.adUiControlParams + ", windowConfig=" + this.windowConfig + ", fractionListenerId=" + this.fractionListenerId + ", pageStateListenerId=" + this.pageStateListenerId + ", pageStateListenerExtra=" + this.pageStateListenerExtra + ", anchorV3ExtraData=" + this.anchorV3ExtraData + ", userId=" + this.userId + ", clearScreenUpon=" + this.clearScreenUpon + ", panelHeight=" + this.panelHeight + ", taskInfo=" + this.taskInfo + ", sourceBtmToken=" + this.sourceBtmToken + ", bcmParams=" + this.bcmParams + ", aiConversationContext=" + this.aiConversationContext + ", topLabelText=" + this.topLabelText + ", panelHeightPercent=" + this.panelHeightPercent + ", pendantParams=" + this.pendantParams + ", touTiaoAppId=" + this.touTiaoAppId + ", pdpEventTransparentId=" + this.pdpEventTransparentId + ", hasCustomWindowAnimation=" + this.hasCustomWindowAnimation + ")";
    }

    public final ECAdLogParams getAdLogParams() {
        return this.adLogParams;
    }

    public final String getAdUiControlParams() {
        return this.adUiControlParams;
    }

    public final PdpAIConversationContext getAiConversationContext() {
        return this.aiConversationContext;
    }

    public final ECAnchorV3ExtraData getAnchorV3ExtraData() {
        return this.anchorV3ExtraData;
    }

    public final boolean getAsyncInflate() {
        return this.asyncInflate;
    }

    public final String getBcmParams() {
        return this.bcmParams;
    }

    public final String getCarrierType() {
        return this.carrierType;
    }

    public final String getClearScreenUpon() {
        return this.clearScreenUpon;
    }

    public final String getCovImageUri() {
        return this.covImageUri;
    }

    public final Map<String, String> getDetailApiImagesConstraint() {
        return this.detailApiImagesConstraint;
    }

    public final boolean getDisableLiveWindow() {
        return this.disableLiveWindow;
    }

    public final String getFirstCid() {
        return this.firstCid;
    }

    public final String getFractionListenerId() {
        return this.fractionListenerId;
    }

    public final String getFrameCovImage() {
        return this.frameCovImage;
    }

    public final boolean getFromLive() {
        return this.fromLive;
    }

    public final boolean getFromLiveCartList() {
        return this.fromLiveCartList;
    }

    public final boolean getFullMode() {
        return this.fullMode;
    }

    public final Float getHalfHeadScale() {
        return this.halfHeadScale;
    }

    public final boolean getHasCustomWindowAnimation() {
        return this.hasCustomWindowAnimation;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final Integer getLastEcomSceneId() {
        return this.lastEcomSceneId;
    }

    public final String getLiveHotSaleComponent() {
        return this.liveHotSaleComponent;
    }

    public final String getLiveRoomId() {
        return this.liveRoomId;
    }

    public final String getMaskColor() {
        return this.maskColor;
    }

    public final String getPageStateListenerExtra() {
        return this.pageStateListenerExtra;
    }

    public final String getPageStateListenerId() {
        return this.pageStateListenerId;
    }

    public final int getPanelHeight() {
        return this.panelHeight;
    }

    public final Integer getPanelHeightPercent() {
        return this.panelHeightPercent;
    }

    public final String getPdpEventTransparentId() {
        return this.pdpEventTransparentId;
    }

    public final String getPendantParams() {
        return this.pendantParams;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final ECSceneTransitionData getSceneTransitionData() {
        return this.sceneTransitionData;
    }

    public final ECShareFission getShareFission() {
        return this.shareFission;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final boolean getShowShareBtnAnimation() {
        return this.showShareBtnAnimation;
    }

    public final int getShowSkuPanel() {
        return this.showSkuPanel;
    }

    public final String getSourceBtmToken() {
        return this.sourceBtmToken;
    }

    public final String getSourcePage() {
        return this.sourcePage;
    }

    public final Map<String, String> getStoreRecommendApiImageConstraints() {
        return this.storeRecommendApiImageConstraints;
    }

    public final AdNationalTaskInfo getTaskInfo() {
        return this.taskInfo;
    }

    public final String getTopLabelText() {
        return this.topLabelText;
    }

    public final Integer getTouTiaoAppId() {
        return this.touTiaoAppId;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getV3EventsAdditions() {
        return this.v3EventsAdditions;
    }

    public final WindowConfig getWindowConfig() {
        return this.windowConfig;
    }

    public final WireFrameSchemaInfo getWireFrameSchemaInfo() {
        return this.wireFrameSchemaInfo;
    }

    public final boolean isFromFeedProductGuessULike() {
        return this.isFromFeedProductGuessULike;
    }

    public final void setFromLiveCartList(boolean r100) {
        this.fromLiveCartList = r100;
    }

    public final void setHasCustomWindowAnimation(boolean r100) {
        this.hasCustomWindowAnimation = r100;
    }

    public V4NativeParams(boolean r100, boolean r101, boolean r102, String r103, String r104, String r105, String r106, String r110, String r111, boolean r112, String r113, String r114, String r115, Integer r116, Float r117, ECShareFission r118, ECAdLogParams r119, Map<String, String> r210, Map<String, String> r211, boolean r212, String r213, String r214, boolean r215, String r216, ECSceneTransitionData r217, WireFrameSchemaInfo r218, boolean r219, int r310, String r311, WindowConfig r312, String r313, String r314, String r315, ECAnchorV3ExtraData r316, String r317, String r318, int r319, AdNationalTaskInfo r410, String r411, String r412, PdpAIConversationContext r413, String r414, Integer r415, String r416, Integer r417, String r418, boolean r419) {
        this.fullMode = r100;
        this.fromLive = r101;
        this.fromLiveCartList = r102;
        this.productId = r103;
        this.itemId = r104;
        this.shopId = r105;
        this.firstCid = r106;
        this.liveRoomId = r110;
        this.v3EventsAdditions = r111;
        this.disableLiveWindow = r112;
        this.sourcePage = r113;
        this.carrierType = r114;
        this.liveHotSaleComponent = r115;
        this.lastEcomSceneId = r116;
        this.halfHeadScale = r117;
        this.shareFission = r118;
        this.adLogParams = r119;
        this.detailApiImagesConstraint = r210;
        this.storeRecommendApiImageConstraints = r211;
        this.isFromFeedProductGuessULike = r212;
        this.frameCovImage = r213;
        this.covImageUri = r214;
        this.showShareBtnAnimation = r215;
        this.maskColor = r216;
        this.sceneTransitionData = r217;
        this.wireFrameSchemaInfo = r218;
        this.asyncInflate = r219;
        this.showSkuPanel = r310;
        this.adUiControlParams = r311;
        this.windowConfig = r312;
        this.fractionListenerId = r313;
        this.pageStateListenerId = r314;
        this.pageStateListenerExtra = r315;
        this.anchorV3ExtraData = r316;
        this.userId = r317;
        this.clearScreenUpon = r318;
        this.panelHeight = r319;
        this.taskInfo = r410;
        this.sourceBtmToken = r411;
        this.bcmParams = r412;
        this.aiConversationContext = r413;
        this.topLabelText = r414;
        this.panelHeightPercent = r415;
        this.pendantParams = r416;
        this.touTiaoAppId = r417;
        this.pdpEventTransparentId = r418;
        this.hasCustomWindowAnimation = r419;
        this.taskRequestParams$delegate = LazyKt.lazy(new V4NativeParams$taskRequestParams$2(this));
    }

    public /* synthetic */ V4NativeParams(boolean r410, boolean r411, boolean r412, String r510, String r511, String r512, String r513, String r514, String r515, boolean r516, String r517, String r518, String r519, Integer r610, Float r611, ECShareFission r612, ECAdLogParams r613, Map r614, Map r615, boolean r616, String r617, String r618, boolean r619, String r710, ECSceneTransitionData r711, WireFrameSchemaInfo r712, boolean r713, int r714, String r715, WindowConfig r716, String r717, String r718, String r719, ECAnchorV3ExtraData r810, String r811, String r812, int r813, AdNationalTaskInfo r814, String r815, String r816, PdpAIConversationContext r817, String r818, Integer r819, String r910, Integer r911, String r912, boolean r913, int r914, int r915, DefaultConstructorMarker r916) {
        if ((r914 & 1) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r914 & 2) == 0) goto L9;
        boolean r101 = false;
    L11:
        if ((r914 & 4) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r914 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r914 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r914 & 32) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r914 & 64) == 0) goto L29;
        String r110 = null;
    L31:
        if ((r914 & 128) == 0) goto L33;
        String r111 = null;
    L35:
        if ((r914 & 256) == 0) goto L37;
        String r112 = null;
    L39:
        if ((r914 & 512) == 0) goto L41;
        boolean r113 = false;
    L43:
        if ((r914 & 1024) == 0) goto L45;
        String r114 = null;
    L47:
        if ((r914 & 2048) == 0) goto L49;
        String r115 = null;
    L51:
        if ((r914 & 4096) == 0) goto L53;
        String r106 = null;
    L55:
        if ((r914 & 8192) == 0) goto L57;
        Integer r107 = null;
    L58:
        Integer r116 = r107;
        if ((r914 & 16384) == 0) goto L61;
        Float r108 = null;
    L63:
        if ((r914 & 32768) == 0) goto L65;
        ECShareFission r117 = null;
    L67:
        if ((r914 & 65536) == 0) goto L69;
        ECAdLogParams r118 = null;
    L71:
        if ((r914 & 131072) == 0) goto L73;
        Map r119 = null;
    L75:
        if ((r914 & 262144) == 0) goto L77;
        Map r210 = null;
    L79:
        if ((r914 & 524288) == 0) goto L81;
        boolean r211 = false;
    L83:
        if ((r914 & 1048576) == 0) goto L85;
        String r212 = null;
    L87:
        if ((r914 & 2097152) == 0) goto L89;
        String r213 = null;
    L91:
        if ((r914 & 4194304) == 0) goto L93;
        boolean r214 = false;
    L95:
        if ((r914 & 8388608) == 0) goto L97;
        String r215 = null;
    L99:
        if ((r914 & 16777216) == 0) goto L101;
        ECSceneTransitionData r216 = null;
    L103:
        if ((r914 & 33554432) == 0) goto L105;
        WireFrameSchemaInfo r217 = null;
    L107:
        if ((r914 & 67108864) == 0) goto L109;
        boolean r218 = true;
    L111:
        if ((r914 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        int r219 = 0;
    L115:
        if ((r914 & 268435456) == 0) goto L117;
        String r310 = null;
    L119:
        if ((r914 & 536870912) == 0) goto L121;
        WindowConfig r311 = null;
    L123:
        if ((r914 & 1073741824) == 0) goto L125;
        String r312 = null;
    L127:
        if ((r914 & Integer.MIN_VALUE) == 0) goto L129;
        String r109 = null;
    L131:
        if ((r915 & 1) == 0) goto L133;
        String r313 = null;
    L135:
        if ((r915 & 2) == 0) goto L137;
        ECAnchorV3ExtraData r314 = null;
    L139:
        if ((r915 & 4) == 0) goto L141;
        String r315 = null;
    L143:
        if ((r915 & 8) == 0) goto L145;
        String r316 = null;
    L147:
        if ((r915 & 16) == 0) goto L149;
        int r317 = 0;
    L151:
        if ((r915 & 32) == 0) goto L153;
        AdNationalTaskInfo r318 = null;
    L155:
        if ((r915 & 64) == 0) goto L157;
        String r319 = null;
    L158:
        String r917 = r109;
        if ((r915 & 128) == 0) goto L161;
        String r120 = null;
    L162:
        String r413 = r120;
        if ((r915 & 256) == 0) goto L165;
        PdpAIConversationContext r121 = null;
    L166:
        PdpAIConversationContext r414 = r121;
        if ((r915 & 512) == 0) goto L169;
        String r122 = null;
    L170:
        String r415 = r122;
        if ((r915 & 1024) == 0) goto L173;
        Integer r123 = null;
    L174:
        Integer r416 = r123;
        if ((r915 & 2048) == 0) goto L177;
        String r124 = null;
    L178:
        String r417 = r124;
        if ((r915 & 4096) == 0) goto L181;
        Integer r418 = 0;
    L183:
        if ((r915 & 8192) == 0) goto L185;
        String r125 = null;
    L187:
        if ((r915 & 16384) == 0) goto L189;
        boolean r126 = false;
    L190:
        this(r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r116, r108, r117, r118, r119, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r917, r313, r314, r315, r316, r317, r318, r319, r413, r414, r415, r416, r417, r418, r125, r126);
        return;
    L189:
        r126 = r913;
        goto L190
    L185:
        r125 = r912;
        goto L187
    L181:
        r418 = r911;
        goto L183
    L177:
        r124 = r910;
        goto L178
    L173:
        r123 = r819;
        goto L174
    L169:
        r122 = r818;
        goto L170
    L165:
        r121 = r817;
        goto L166
    L161:
        r120 = r816;
        goto L162
    L157:
        r319 = r815;
        goto L158
    L153:
        r318 = r814;
        goto L155
    L149:
        r317 = r813;
        goto L151
    L145:
        r316 = r812;
        goto L147
    L141:
        r315 = r811;
        goto L143
    L137:
        r314 = r810;
        goto L139
    L133:
        r313 = r719;
        goto L135
    L129:
        r109 = r718;
        goto L131
    L125:
        r312 = r717;
        goto L127
    L121:
        r311 = r716;
        goto L123
    L117:
        r310 = r715;
        goto L119
    L113:
        r219 = r714;
        goto L115
    L109:
        r218 = r713;
        goto L111
    L105:
        r217 = r712;
        goto L107
    L101:
        r216 = r711;
        goto L103
    L97:
        r215 = r710;
        goto L99
    L93:
        r214 = r619;
        goto L95
    L89:
        r213 = r618;
        goto L91
    L85:
        r212 = r617;
        goto L87
    L81:
        r211 = r616;
        goto L83
    L77:
        r210 = r615;
        goto L79
    L73:
        r119 = r614;
        goto L75
    L69:
        r118 = r613;
        goto L71
    L65:
        r117 = r612;
        goto L67
    L61:
        r108 = r611;
        goto L63
    L57:
        r107 = r610;
        goto L58
    L53:
        r106 = r519;
        goto L55
    L49:
        r115 = r518;
        goto L51
    L45:
        r114 = r517;
        goto L47
    L41:
        r113 = r516;
        goto L43
    L37:
        r112 = r515;
        goto L39
    L33:
        r111 = r514;
        goto L35
    L29:
        r110 = r513;
        goto L31
    L25:
        r105 = r512;
        goto L27
    L21:
        r104 = r511;
        goto L23
    L17:
        r103 = r510;
        goto L19
    L13:
        r102 = r412;
        goto L15
    L9:
        r101 = r411;
        goto L11
    L5:
        r100 = r410;
        goto L7
    }
}

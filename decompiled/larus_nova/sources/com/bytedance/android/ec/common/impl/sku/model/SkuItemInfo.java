package com.bytedance.android.ec.common.impl.sku.model;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.PromotionBenefitLabel;
import com.bytedance.android.ec.model.sku.ButtonTipComponent;
import com.bytedance.android.ec.model.sku.CarAdaptComponent;
import com.bytedance.android.ec.model.sku.PriceComponent;
import com.bytedance.android.ec.model.sku.SkuBottomButtons;
import com.bytedance.android.ec.model.sku.SkuStatusDetail;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0003\b\u0082\u0001\b\u0086\b\u0018\u00002\u00020\u0001B±\u0004\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010*\u001a\u00020+\u0012\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\u0014\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u000101\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u000104\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0003\u0012(\b\u0002\u00106\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u000107j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`8\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010:\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010+\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010+\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010>J\f\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010\u008d\u0001\u001a\u00020\u0011HÆ\u0003J\u0011\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010JJ\u0012\u0010\u008f\u0001\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014HÆ\u0003J\n\u0010\u0090\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0091\u0001\u001a\u00020\u0011HÆ\u0003J\f\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010JJ\n\u0010\u0094\u0001\u001a\u00020\u0005HÆ\u0003J\f\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\f\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010OJ\u0011\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010JJ\u0011\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010JJ\f\u0010\u009d\u0001\u001a\u0004\u0018\u00010$HÆ\u0003J\f\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010JJ\u0011\u0010 \u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010OJ\u0011\u0010¡\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010JJ\f\u0010¢\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010£\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010JJ\n\u0010¤\u0001\u001a\u00020+HÆ\u0003J\u0012\u0010¥\u0001\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\u0014HÆ\u0003J\f\u0010¦\u0001\u001a\u0004\u0018\u00010/HÆ\u0003J\f\u0010§\u0001\u001a\u0004\u0018\u000101HÆ\u0003J\f\u0010¨\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010©\u0001\u001a\u0004\u0018\u000104HÆ\u0003J\n\u0010ª\u0001\u001a\u00020\u0005HÆ\u0003J\f\u0010«\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J*\u0010¬\u0001\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u000107j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`8HÆ\u0003J\f\u0010\u00ad\u0001\u001a\u0004\u0018\u00010:HÆ\u0003J\u0011\u0010®\u0001\u001a\u0004\u0018\u00010+HÆ\u0003¢\u0006\u0002\u0010RJ\u0011\u0010¯\u0001\u001a\u0004\u0018\u00010+HÆ\u0003¢\u0006\u0002\u0010RJ\f\u0010°\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010±\u0001\u001a\u00020\u0005HÆ\u0003J\u0011\u0010²\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010JJ\n\u0010³\u0001\u001a\u00020\u0003HÆ\u0003J\u0011\u0010´\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010JJ\n\u0010µ\u0001\u001a\u00020\u0005HÆ\u0003JÄ\u0004\u0010¶\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00112\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010*\u001a\u00020+2\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\u00142\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00032(\b\u0002\u00106\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u000107j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`82\n\b\u0002\u00109\u001a\u0004\u0018\u00010:2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0003\u0010·\u0001J\u0015\u0010¸\u0001\u001a\u00020+2\t\u0010¹\u0001\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\n\u0010º\u0001\u001a\u00020\u0011HÖ\u0001J\n\u0010»\u0001\u001a\u00020\u0003HÖ\u0001R\u0018\u0010#\u001a\u0004\u0018\u00010$8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0018\u0010%\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u001e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0018\u0010(\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010BR\u0018\u00109\u001a\u0004\u0018\u00010:8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u001e\u0010,\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010DR\u001a\u0010\"\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010K\u001a\u0004\bI\u0010JR\u0016\u0010\u0016\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bL\u0010BR\u001a\u0010!\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010K\u001a\u0004\bM\u0010JR\u001a\u0010&\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010P\u001a\u0004\bN\u0010OR\u001a\u0010<\u001a\u0004\u0018\u00010+8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010S\u001a\u0004\bQ\u0010RR\u0016\u0010*\u001a\u00020+8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u0010UR\u0018\u0010.\u001a\u0004\u0018\u00010/8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bX\u0010BR\u001a\u0010 \u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010P\u001a\u0004\bY\u0010OR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010BR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b[\u0010BR\u001a\u0010'\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010K\u001a\u0004\b\\\u0010JR\"\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010K\u001a\u0004\b]\u0010J\"\u0004\b^\u0010_R\u001e\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010B\"\u0004\ba\u0010bR\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bc\u0010dR\u001a\u0010;\u001a\u0004\u0018\u00010+8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010S\u001a\u0004\be\u0010RR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010B\"\u0004\bg\u0010bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bh\u0010BR\u0016\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bi\u0010jR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bk\u0010BR\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010K\u001a\u0004\bl\u0010JR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bm\u0010BR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\u001e\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010j\"\u0004\bs\u0010tR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bu\u0010BR\u001e\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010j\"\u0004\bw\u0010tR\u0018\u00100\u001a\u0004\u0018\u0001018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bx\u0010yR\u0016\u0010\u0017\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bz\u0010oR\u0018\u0010=\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b{\u0010BR\u001a\u0010)\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010K\u001a\u0004\b|\u0010JR6\u00106\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u000107j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`88\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b}\u0010~R\u0018\u00105\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u007f\u0010BR\u001a\u00103\u001a\u0004\u0018\u0001048\u0006X\u0087\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000b\n\u0002\u0010K\u001a\u0005\b\u0082\u0001\u0010JR\u0019\u00102\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0083\u0001\u0010BR \u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0084\u0001\u0010j\"\u0005\b\u0085\u0001\u0010tR\u001b\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000b\n\u0002\u0010K\u001a\u0005\b\u0086\u0001\u0010JR\u0019\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0087\u0001\u0010BR\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000b\n\u0002\u0010K\u001a\u0005\b\u0088\u0001\u0010J¨\u0006¼\u0001"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/model/SkuItemInfo;", "Ljava/io/Serializable;", "id", "", "stockNum", "", "unpayNum", "price", "originPrice", "discountPrice", "discountPriceText", "userLimit", "lowerLimit", "upperLimitToast", "lowerLimitToast", "limitText", "nowStock", "", "skuType", "benefitLabels", "", "Lcom/bytedance/android/ec/model/PromotionBenefitLabel;", "campaignPriceHeader", "priceHeaderStyle", "newBonusText", "marketPrice", "epInfo", "", "presellDelayDesc", "deliveryDelayDesc", "deliveryDelayBackground", "delayDescIcon", "delayDescStyle", "campaignStartTime", "campaignEndTime", "activityIcon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "atmosphereHeader", "campaignSubType", "depositPrice", "buttonLabel", "serverTime", "canSelect", "", "buttons", "Lcom/bytedance/android/ec/model/sku/SkuBottomButtons;", "carAdaptComponent", "Lcom/bytedance/android/ec/model/sku/CarAdaptComponent;", "priceComponent", "Lcom/bytedance/android/ec/model/sku/PriceComponent;", "stockDesc", "skuStatusDetail", "Lcom/bytedance/android/ec/model/sku/SkuStatusDetail;", "skuExtra", "showEventTrack", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "buttonTipComponent", "Lcom/bytedance/android/ec/model/sku/ButtonTipComponent;", "hideTradeIn", "canAddCart", "promiseType", "(Ljava/lang/String;JLjava/lang/Long;JJLjava/lang/Long;Ljava/lang/String;Ljava/lang/Long;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Long;Ljava/util/List;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Long;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;ZLjava/util/List;Lcom/bytedance/android/ec/model/sku/CarAdaptComponent;Lcom/bytedance/android/ec/model/sku/PriceComponent;Ljava/lang/String;Lcom/bytedance/android/ec/model/sku/SkuStatusDetail;Ljava/lang/String;Ljava/util/HashMap;Lcom/bytedance/android/ec/model/sku/ButtonTipComponent;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)V", "getActivityIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "getAtmosphereHeader", "()Ljava/lang/String;", "getBenefitLabels", "()Ljava/util/List;", "getButtonLabel", "getButtonTipComponent", "()Lcom/bytedance/android/ec/model/sku/ButtonTipComponent;", "getButtons", "getCampaignEndTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCampaignPriceHeader", "getCampaignStartTime", "getCampaignSubType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCanAddCart", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCanSelect", "()Z", "getCarAdaptComponent", "()Lcom/bytedance/android/ec/model/sku/CarAdaptComponent;", "getDelayDescIcon", "getDelayDescStyle", "getDeliveryDelayBackground", "getDeliveryDelayDesc", "getDepositPrice", "getDiscountPrice", "setDiscountPrice", "(Ljava/lang/Long;)V", "getDiscountPriceText", "setDiscountPriceText", "(Ljava/lang/String;)V", "getEpInfo", "()Ljava/lang/Object;", "getHideTradeIn", "getId", "setId", "getLimitText", "getLowerLimit", "()J", "getLowerLimitToast", "getMarketPrice", "getNewBonusText", "getNowStock", "()I", "setNowStock", "(I)V", "getOriginPrice", "setOriginPrice", "(J)V", "getPresellDelayDesc", "getPrice", "setPrice", "getPriceComponent", "()Lcom/bytedance/android/ec/model/sku/PriceComponent;", "getPriceHeaderStyle", "getPromiseType", "getServerTime", "getShowEventTrack", "()Ljava/util/HashMap;", "getSkuExtra", "getSkuStatusDetail", "()Lcom/bytedance/android/ec/model/sku/SkuStatusDetail;", "getSkuType", "getStockDesc", "getStockNum", "setStockNum", "getUnpayNum", "getUpperLimitToast", "getUserLimit", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component44", "component45", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;JLjava/lang/Long;JJLjava/lang/Long;Ljava/lang/String;Ljava/lang/Long;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Long;Ljava/util/List;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Long;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;ZLjava/util/List;Lcom/bytedance/android/ec/model/sku/CarAdaptComponent;Lcom/bytedance/android/ec/model/sku/PriceComponent;Ljava/lang/String;Lcom/bytedance/android/ec/model/sku/SkuStatusDetail;Ljava/lang/String;Ljava/util/HashMap;Lcom/bytedance/android/ec/model/sku/ButtonTipComponent;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/bytedance/android/ec/common/impl/sku/model/SkuItemInfo;", "equals", "other", "hashCode", "toString", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuItemInfo implements Serializable {

    @SerializedName("activity_icon")
    private final ECUrlModel activityIcon;

    @SerializedName("atmosphere_header")
    private final String atmosphereHeader;

    @SerializedName("benefit_labels")
    private final List<PromotionBenefitLabel> benefitLabels;

    @SerializedName("button_label")
    private final String buttonLabel;

    @SerializedName("button_tip")
    private final ButtonTipComponent buttonTipComponent;

    @SerializedName("buttons")
    private final List<SkuBottomButtons> buttons;

    @SerializedName("campaign_end_time")
    private final Long campaignEndTime;

    @SerializedName("campaign_price_header")
    private final String campaignPriceHeader;

    @SerializedName("campaign_start_time")
    private final Long campaignStartTime;

    @SerializedName("campaign_sub_type")
    private final Integer campaignSubType;

    @SerializedName("can_add_cart")
    private final Boolean canAddCart;

    @SerializedName("can_select")
    private final boolean canSelect;

    @SerializedName("car_adapt_component")
    private final CarAdaptComponent carAdaptComponent;

    @SerializedName("delay_desc_icon")
    private final String delayDescIcon;

    @SerializedName("delay_desc_style")
    private final Integer delayDescStyle;

    @SerializedName("delivery_delay_background")
    private final String deliveryDelayBackground;

    @SerializedName("delivery_delay_desc")
    private final String deliveryDelayDesc;

    @SerializedName("deposit_price")
    private final Long depositPrice;

    @SerializedName("discount_price")
    private Long discountPrice;

    @SerializedName("discount_price_header")
    private String discountPriceText;

    @SerializedName("addition_modules_data")
    private final Object epInfo;

    @SerializedName("hide_trade_in")
    private final Boolean hideTradeIn;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName(a.KEY_SKU_ID)
    private String f43092id;

    @SerializedName("limit_text")
    private final String limitText;

    @SerializedName("user_min_limit")
    private final long lowerLimit;

    @SerializedName("min_limit_toast")
    private final String lowerLimitToast;

    @SerializedName(a.KEY_REGULAR_PRICE)
    private final Long marketPrice;

    @SerializedName("new_bonus_text")
    private final String newBonusText;

    @SerializedName("now_stock")
    private int nowStock;

    @SerializedName("origin_price")
    private long originPrice;

    @SerializedName("presell_delay_desc")
    private final String presellDelayDesc;

    @SerializedName("price")
    private long price;

    @SerializedName("price_component")
    private final PriceComponent priceComponent;

    @SerializedName("price_header_style")
    private final int priceHeaderStyle;

    @SerializedName("promise_type")
    private final String promiseType;

    @SerializedName("server_time")
    private final Long serverTime;

    @SerializedName("show_event_track")
    private final HashMap<String, String> showEventTrack;

    @SerializedName("sku_extra")
    private final String skuExtra;

    @SerializedName("sku_status_detail")
    private final SkuStatusDetail skuStatusDetail;

    @SerializedName("sku_type")
    private final Long skuType;

    @SerializedName("stock_desc")
    private final String stockDesc;

    @SerializedName("stock_num")
    private long stockNum;

    @SerializedName("unpay_num")
    private final Long unpayNum;

    @SerializedName("limit_toast")
    private final String upperLimitToast;

    @SerializedName("user_limit")
    private final Long userLimit;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SkuItemInfo copy$default(SkuItemInfo r110, String r111, long r112, Long r210, long r211, long r212, Long r213, String r214, Long r215, long r216, String r310, String r311, String r312, int r313, Long r314, List r315, String r316, int r317, String r318, Long r410, Object r411, String r412, String r413, String r414, String r415, Integer r416, Long r417, Long r418, ECUrlModel r419, String r510, Integer r511, Long r512, String r513, Long r514, boolean r515, List r516, CarAdaptComponent r517, PriceComponent r518, String r519, SkuStatusDetail r610, String r611, HashMap r612, ButtonTipComponent r613, Boolean r614, Boolean r615, String r616, int r617, int r618, Object r619) {
        if ((r617 & 1) == 0) goto L5;
        String r100 = r110.f43092id;
    L7:
        if ((r617 & 2) == 0) goto L9;
        long r101 = r110.stockNum;
    L11:
        if ((r617 & 4) == 0) goto L13;
        Long r102 = r110.unpayNum;
    L15:
        if ((r617 & 8) == 0) goto L17;
        long r103 = r110.price;
    L19:
        if ((r617 & 16) == 0) goto L21;
        long r104 = r110.originPrice;
    L23:
        if ((r617 & 32) == 0) goto L25;
        Long r113 = r110.discountPrice;
    L27:
        if ((r617 & 64) == 0) goto L29;
        String r114 = r110.discountPriceText;
    L31:
        if ((r617 & 128) == 0) goto L33;
        Long r115 = r110.userLimit;
    L35:
        if ((r617 & 256) == 0) goto L37;
        long r116 = r110.lowerLimit;
    L38:
        long r217 = r116;
        if ((r617 & 512) == 0) goto L41;
        String r117 = r110.upperLimitToast;
    L43:
        if ((r617 & 1024) == 0) goto L45;
        String r118 = r110.lowerLimitToast;
    L46:
        String r319 = r118;
        if ((r617 & 2048) == 0) goto L49;
        String r119 = r110.limitText;
    L50:
        String r320 = r119;
        if ((r617 & 4096) == 0) goto L53;
        int r120 = r110.nowStock;
    L54:
        int r321 = r120;
        if ((r617 & 8192) == 0) goto L57;
        Long r121 = r110.skuType;
    L58:
        Long r322 = r121;
        if ((r617 & 16384) == 0) goto L61;
        List r122 = r110.benefitLabels;
    L62:
        List r323 = r122;
        if ((r617 & 32768) == 0) goto L65;
        String r123 = r110.campaignPriceHeader;
    L66:
        String r324 = r123;
        if ((r617 & 65536) == 0) goto L69;
        int r124 = r110.priceHeaderStyle;
    L70:
        int r325 = r124;
        if ((r617 & 131072) == 0) goto L73;
        String r125 = r110.newBonusText;
    L74:
        String r326 = r125;
        if ((r617 & 262144) == 0) goto L77;
        Long r126 = r110.marketPrice;
    L78:
        Long r420 = r126;
        if ((r617 & 524288) == 0) goto L81;
        Object r127 = r110.epInfo;
    L82:
        Object r421 = r127;
        if ((r617 & 1048576) == 0) goto L85;
        String r128 = r110.presellDelayDesc;
    L86:
        String r422 = r128;
        if ((r617 & 2097152) == 0) goto L89;
        String r129 = r110.deliveryDelayDesc;
    L90:
        String r423 = r129;
        if ((r617 & 4194304) == 0) goto L93;
        String r130 = r110.deliveryDelayBackground;
    L94:
        String r424 = r130;
        if ((r617 & 8388608) == 0) goto L97;
        String r131 = r110.delayDescIcon;
    L98:
        String r425 = r131;
        if ((r617 & 16777216) == 0) goto L101;
        Integer r132 = r110.delayDescStyle;
    L102:
        Integer r426 = r132;
        if ((r617 & 33554432) == 0) goto L105;
        Long r133 = r110.campaignStartTime;
    L106:
        Long r427 = r133;
        if ((r617 & 67108864) == 0) goto L109;
        Long r134 = r110.campaignEndTime;
    L110:
        Long r428 = r134;
        if ((r617 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        ECUrlModel r135 = r110.activityIcon;
    L114:
        ECUrlModel r429 = r135;
        if ((r617 & 268435456) == 0) goto L117;
        String r136 = r110.atmosphereHeader;
    L118:
        String r520 = r136;
        if ((r617 & 536870912) == 0) goto L121;
        Integer r137 = r110.campaignSubType;
    L122:
        Integer r521 = r137;
        if ((r617 & 1073741824) == 0) goto L125;
        Long r138 = r110.depositPrice;
    L127:
        if ((r617 & Integer.MIN_VALUE) == 0) goto L129;
        String r105 = r110.buttonLabel;
    L130:
        String r522 = r105;
        if ((r618 & 1) == 0) goto L133;
        Long r106 = r110.serverTime;
    L134:
        Long r523 = r106;
        if ((r618 & 2) == 0) goto L137;
        boolean r107 = r110.canSelect;
    L138:
        boolean r524 = r107;
        if ((r618 & 4) == 0) goto L141;
        List r108 = r110.buttons;
    L142:
        List r525 = r108;
        if ((r618 & 8) == 0) goto L145;
        CarAdaptComponent r109 = r110.carAdaptComponent;
    L146:
        CarAdaptComponent r526 = r109;
        if ((r618 & 16) == 0) goto L149;
        PriceComponent r139 = r110.priceComponent;
    L150:
        PriceComponent r527 = r139;
        if ((r618 & 32) == 0) goto L153;
        String r140 = r110.stockDesc;
    L154:
        String r528 = r140;
        if ((r618 & 64) == 0) goto L157;
        SkuStatusDetail r141 = r110.skuStatusDetail;
    L158:
        SkuStatusDetail r620 = r141;
        if ((r618 & 128) == 0) goto L161;
        String r142 = r110.skuExtra;
    L162:
        String r621 = r142;
        if ((r618 & 256) == 0) goto L165;
        HashMap r143 = r110.showEventTrack;
    L166:
        HashMap r622 = r143;
        if ((r618 & 512) == 0) goto L169;
        ButtonTipComponent r144 = r110.buttonTipComponent;
    L170:
        ButtonTipComponent r623 = r144;
        if ((r618 & 1024) == 0) goto L173;
        Boolean r145 = r110.hideTradeIn;
    L174:
        Boolean r624 = r145;
        if ((r618 & 2048) == 0) goto L177;
        Boolean r146 = r110.canAddCart;
    L179:
        if ((r618 & 4096) == 0) goto L181;
        String r147 = r110.promiseType;
    L183:
        return r110.copy(r100, r101, r102, r103, r104, r113, r114, r115, r217, r117, r319, r320, r321, r322, r323, r324, r325, r326, r420, r421, r422, r423, r424, r425, r426, r427, r428, r429, r520, r521, r138, r522, r523, r524, r525, r526, r527, r528, r620, r621, r622, r623, r624, r146, r147);
    L181:
        r147 = r616;
        goto L183
    L177:
        r146 = r615;
        goto L179
    L173:
        r145 = r614;
        goto L174
    L169:
        r144 = r613;
        goto L170
    L165:
        r143 = r612;
        goto L166
    L161:
        r142 = r611;
        goto L162
    L157:
        r141 = r610;
        goto L158
    L153:
        r140 = r519;
        goto L154
    L149:
        r139 = r518;
        goto L150
    L145:
        r109 = r517;
        goto L146
    L141:
        r108 = r516;
        goto L142
    L137:
        r107 = r515;
        goto L138
    L133:
        r106 = r514;
        goto L134
    L129:
        r105 = r513;
        goto L130
    L125:
        r138 = r512;
        goto L127
    L121:
        r137 = r511;
        goto L122
    L117:
        r136 = r510;
        goto L118
    L113:
        r135 = r419;
        goto L114
    L109:
        r134 = r418;
        goto L110
    L105:
        r133 = r417;
        goto L106
    L101:
        r132 = r416;
        goto L102
    L97:
        r131 = r415;
        goto L98
    L93:
        r130 = r414;
        goto L94
    L89:
        r129 = r413;
        goto L90
    L85:
        r128 = r412;
        goto L86
    L81:
        r127 = r411;
        goto L82
    L77:
        r126 = r410;
        goto L78
    L73:
        r125 = r318;
        goto L74
    L69:
        r124 = r317;
        goto L70
    L65:
        r123 = r316;
        goto L66
    L61:
        r122 = r315;
        goto L62
    L57:
        r121 = r314;
        goto L58
    L53:
        r120 = r313;
        goto L54
    L49:
        r119 = r312;
        goto L50
    L45:
        r118 = r311;
        goto L46
    L41:
        r117 = r310;
        goto L43
    L37:
        r116 = r216;
        goto L38
    L33:
        r115 = r215;
        goto L35
    L29:
        r114 = r214;
        goto L31
    L25:
        r113 = r213;
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

    public final String component1() {
        return this.f43092id;
    }

    public final String component10() {
        return this.upperLimitToast;
    }

    public final String component11() {
        return this.lowerLimitToast;
    }

    public final String component12() {
        return this.limitText;
    }

    public final int component13() {
        return this.nowStock;
    }

    public final Long component14() {
        return this.skuType;
    }

    public final List<PromotionBenefitLabel> component15() {
        return this.benefitLabels;
    }

    public final String component16() {
        return this.campaignPriceHeader;
    }

    public final int component17() {
        return this.priceHeaderStyle;
    }

    public final String component18() {
        return this.newBonusText;
    }

    public final Long component19() {
        return this.marketPrice;
    }

    public final long component2() {
        return this.stockNum;
    }

    public final Object component20() {
        return this.epInfo;
    }

    public final String component21() {
        return this.presellDelayDesc;
    }

    public final String component22() {
        return this.deliveryDelayDesc;
    }

    public final String component23() {
        return this.deliveryDelayBackground;
    }

    public final String component24() {
        return this.delayDescIcon;
    }

    public final Integer component25() {
        return this.delayDescStyle;
    }

    public final Long component26() {
        return this.campaignStartTime;
    }

    public final Long component27() {
        return this.campaignEndTime;
    }

    public final ECUrlModel component28() {
        return this.activityIcon;
    }

    public final String component29() {
        return this.atmosphereHeader;
    }

    public final Long component3() {
        return this.unpayNum;
    }

    public final Integer component30() {
        return this.campaignSubType;
    }

    public final Long component31() {
        return this.depositPrice;
    }

    public final String component32() {
        return this.buttonLabel;
    }

    public final Long component33() {
        return this.serverTime;
    }

    public final boolean component34() {
        return this.canSelect;
    }

    public final List<SkuBottomButtons> component35() {
        return this.buttons;
    }

    public final CarAdaptComponent component36() {
        return this.carAdaptComponent;
    }

    public final PriceComponent component37() {
        return this.priceComponent;
    }

    public final String component38() {
        return this.stockDesc;
    }

    public final SkuStatusDetail component39() {
        return this.skuStatusDetail;
    }

    public final long component4() {
        return this.price;
    }

    public final String component40() {
        return this.skuExtra;
    }

    public final HashMap<String, String> component41() {
        return this.showEventTrack;
    }

    public final ButtonTipComponent component42() {
        return this.buttonTipComponent;
    }

    public final Boolean component43() {
        return this.hideTradeIn;
    }

    public final Boolean component44() {
        return this.canAddCart;
    }

    public final String component45() {
        return this.promiseType;
    }

    public final long component5() {
        return this.originPrice;
    }

    public final Long component6() {
        return this.discountPrice;
    }

    public final String component7() {
        return this.discountPriceText;
    }

    public final Long component8() {
        return this.userLimit;
    }

    public final long component9() {
        return this.lowerLimit;
    }

    public final SkuItemInfo copy(String r510, long r511, Long r512, long r513, long r514, Long r610, String r611, Long r612, long r613, String r614, String r615, String r616, int r617, Long r618, List<PromotionBenefitLabel> r710, String r711, int r712, String r713, Long r714, Object r715, String r716, String r717, String r718, String r719, Integer r810, Long r811, Long r812, ECUrlModel r813, String r814, Integer r815, Long r816, String r817, Long r818, boolean r819, List<SkuBottomButtons> r910, CarAdaptComponent r911, PriceComponent r912, String r913, SkuStatusDetail r914, String r915, HashMap<String, String> r916, ButtonTipComponent r917, Boolean r918, Boolean r919, String r100) {
        Intrinsics.checkNotNullParameter(r611, "discountPriceText");
        Intrinsics.checkNotNullParameter(r711, "campaignPriceHeader");
        return new SkuItemInfo(r510, r511, r512, r513, r514, r610, r611, r612, r613, r614, r615, r616, r617, r618, r710, r711, r712, r713, r714, r715, r716, r717, r718, r719, r810, r811, r812, r813, r814, r815, r816, r817, r818, r819, r910, r911, r912, r913, r914, r915, r916, r917, r918, r919, r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SkuItemInfo) == false) goto L96;
        SkuItemInfo r101 = (SkuItemInfo) r100;
        if (Intrinsics.areEqual(this.f43092id, r101.f43092id) == true) goto L8;
        return false;
    L8:
        if (this.stockNum == r101.stockNum) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.unpayNum, r101.unpayNum) == true) goto L12;
        return false;
    L12:
        if (this.price == r101.price) goto L14;
        return false;
    L14:
        if (this.originPrice == r101.originPrice) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.discountPrice, r101.discountPrice) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.discountPriceText, r101.discountPriceText) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.userLimit, r101.userLimit) == true) goto L22;
        return false;
    L22:
        if (this.lowerLimit == r101.lowerLimit) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.upperLimitToast, r101.upperLimitToast) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.lowerLimitToast, r101.lowerLimitToast) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.limitText, r101.limitText) == true) goto L30;
        return false;
    L30:
        if (this.nowStock == r101.nowStock) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.skuType, r101.skuType) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.benefitLabels, r101.benefitLabels) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.campaignPriceHeader, r101.campaignPriceHeader) == true) goto L38;
        return false;
    L38:
        if (this.priceHeaderStyle == r101.priceHeaderStyle) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.newBonusText, r101.newBonusText) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.marketPrice, r101.marketPrice) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.epInfo, r101.epInfo) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.presellDelayDesc, r101.presellDelayDesc) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.deliveryDelayDesc, r101.deliveryDelayDesc) == true) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.deliveryDelayBackground, r101.deliveryDelayBackground) == true) goto L52;
        return false;
    L52:
        if (Intrinsics.areEqual(this.delayDescIcon, r101.delayDescIcon) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.delayDescStyle, r101.delayDescStyle) == true) goto L56;
        return false;
    L56:
        if (Intrinsics.areEqual(this.campaignStartTime, r101.campaignStartTime) == true) goto L58;
        return false;
    L58:
        if (Intrinsics.areEqual(this.campaignEndTime, r101.campaignEndTime) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.activityIcon, r101.activityIcon) == true) goto L62;
        return false;
    L62:
        if (Intrinsics.areEqual(this.atmosphereHeader, r101.atmosphereHeader) == true) goto L64;
        return false;
    L64:
        if (Intrinsics.areEqual(this.campaignSubType, r101.campaignSubType) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.depositPrice, r101.depositPrice) == true) goto L68;
        return false;
    L68:
        if (Intrinsics.areEqual(this.buttonLabel, r101.buttonLabel) == true) goto L70;
        return false;
    L70:
        if (Intrinsics.areEqual(this.serverTime, r101.serverTime) == true) goto L72;
        return false;
    L72:
        if (this.canSelect == r101.canSelect) goto L74;
        return false;
    L74:
        if (Intrinsics.areEqual(this.buttons, r101.buttons) == true) goto L76;
        return false;
    L76:
        if (Intrinsics.areEqual(this.carAdaptComponent, r101.carAdaptComponent) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.priceComponent, r101.priceComponent) == true) goto L80;
        return false;
    L80:
        if (Intrinsics.areEqual(this.stockDesc, r101.stockDesc) == true) goto L82;
        return false;
    L82:
        if (Intrinsics.areEqual(this.skuStatusDetail, r101.skuStatusDetail) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.skuExtra, r101.skuExtra) == true) goto L86;
        return false;
    L86:
        if (Intrinsics.areEqual(this.showEventTrack, r101.showEventTrack) == true) goto L88;
        return false;
    L88:
        if (Intrinsics.areEqual(this.buttonTipComponent, r101.buttonTipComponent) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.hideTradeIn, r101.hideTradeIn) == true) goto L92;
        return false;
    L92:
        if (Intrinsics.areEqual(this.canAddCart, r101.canAddCart) == true) goto L94;
        return false;
    L94:
        if (Intrinsics.areEqual(this.promiseType, r101.promiseType) == true) goto L145;
        return false;
    L145:
        return true;
    L96:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v68, types: [int] */
    /* JADX WARN: Type inference failed for: r2v131 */
    /* JADX WARN: Type inference failed for: r2v158 */
    /* JADX WARN: Type inference failed for: r2v89, types: [int] */
    public int hashCode() {
        String r100 = this.f43092id;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.stockNum;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        Long r105 = this.unpayNum;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        long r108 = this.price;
        int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        long r110 = this.originPrice;
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        Long r112 = this.discountPrice;
        if (r112 == null) goto L13;
        int r113 = r112.hashCode();
    L14:
        int r114 = (r111 + r113) * 31;
        String r115 = this.discountPriceText;
        if (r115 == null) goto L17;
        int r116 = r115.hashCode();
    L18:
        int r117 = (r114 + r116) * 31;
        Long r118 = this.userLimit;
        if (r118 == null) goto L21;
        int r119 = r118.hashCode();
    L22:
        int r120 = (r117 + r119) * 31;
        long r121 = this.lowerLimit;
        int r122 = (r120 + ((int) (r121 ^ (r121 >>> 32)))) * 31;
        String r123 = this.upperLimitToast;
        if (r123 == null) goto L25;
        int r124 = r123.hashCode();
    L26:
        int r125 = (r122 + r124) * 31;
        String r126 = this.lowerLimitToast;
        if (r126 == null) goto L29;
        int r127 = r126.hashCode();
    L30:
        int r128 = (r125 + r127) * 31;
        String r129 = this.limitText;
        if (r129 == null) goto L33;
        int r130 = r129.hashCode();
    L34:
        int r131 = (((r128 + r130) * 31) + this.nowStock) * 31;
        Long r132 = this.skuType;
        if (r132 == null) goto L37;
        int r133 = r132.hashCode();
    L38:
        int r134 = (r131 + r133) * 31;
        List<PromotionBenefitLabel> r135 = this.benefitLabels;
        if (r135 == null) goto L41;
        int r136 = r135.hashCode();
    L42:
        int r137 = (r134 + r136) * 31;
        String r138 = this.campaignPriceHeader;
        if (r138 == null) goto L45;
        int r139 = r138.hashCode();
    L46:
        int r140 = (((r137 + r139) * 31) + this.priceHeaderStyle) * 31;
        String r141 = this.newBonusText;
        if (r141 == null) goto L49;
        int r142 = r141.hashCode();
    L50:
        int r143 = (r140 + r142) * 31;
        Long r144 = this.marketPrice;
        if (r144 == null) goto L53;
        int r145 = r144.hashCode();
    L54:
        int r146 = (r143 + r145) * 31;
        Object r147 = this.epInfo;
        if (r147 == null) goto L57;
        int r148 = r147.hashCode();
    L58:
        int r149 = (r146 + r148) * 31;
        String r150 = this.presellDelayDesc;
        if (r150 == null) goto L61;
        int r151 = r150.hashCode();
    L62:
        int r152 = (r149 + r151) * 31;
        String r153 = this.deliveryDelayDesc;
        if (r153 == null) goto L65;
        int r154 = r153.hashCode();
    L66:
        int r155 = (r152 + r154) * 31;
        String r156 = this.deliveryDelayBackground;
        if (r156 == null) goto L69;
        int r157 = r156.hashCode();
    L70:
        int r158 = (r155 + r157) * 31;
        String r159 = this.delayDescIcon;
        if (r159 == null) goto L73;
        int r160 = r159.hashCode();
    L74:
        int r161 = (r158 + r160) * 31;
        Integer r162 = this.delayDescStyle;
        if (r162 == null) goto L77;
        int r163 = r162.hashCode();
    L78:
        int r164 = (r161 + r163) * 31;
        Long r165 = this.campaignStartTime;
        if (r165 == null) goto L81;
        int r166 = r165.hashCode();
    L82:
        int r167 = (r164 + r166) * 31;
        Long r168 = this.campaignEndTime;
        if (r168 == null) goto L85;
        int r169 = r168.hashCode();
    L86:
        int r170 = (r167 + r169) * 31;
        ECUrlModel r171 = this.activityIcon;
        if (r171 == null) goto L89;
        int r172 = r171.hashCode();
    L90:
        int r173 = (r170 + r172) * 31;
        String r174 = this.atmosphereHeader;
        if (r174 == null) goto L93;
        int r175 = r174.hashCode();
    L94:
        int r176 = (r173 + r175) * 31;
        Integer r177 = this.campaignSubType;
        if (r177 == null) goto L97;
        int r178 = r177.hashCode();
    L98:
        int r179 = (r176 + r178) * 31;
        Long r180 = this.depositPrice;
        if (r180 == null) goto L101;
        int r181 = r180.hashCode();
    L102:
        int r182 = (r179 + r181) * 31;
        String r183 = this.buttonLabel;
        if (r183 == null) goto L105;
        int r184 = r183.hashCode();
    L106:
        int r185 = (r182 + r184) * 31;
        Long r186 = this.serverTime;
        if (r186 == null) goto L109;
        int r187 = r186.hashCode();
    L110:
        int r188 = (r185 + r187) * 31;
        boolean r189 = this.canSelect;
        ?? r190 = r189;
        if (r189 == false) goto L113;
        r190 = 1;
    L113:
        int r191 = (r188 + r190) * 31;
        List<SkuBottomButtons> r192 = this.buttons;
        if (r192 == null) goto L116;
        int r193 = r192.hashCode();
    L117:
        int r194 = (r191 + r193) * 31;
        CarAdaptComponent r195 = this.carAdaptComponent;
        if (r195 == null) goto L120;
        int r196 = r195.hashCode();
    L121:
        int r197 = (r194 + r196) * 31;
        PriceComponent r198 = this.priceComponent;
        if (r198 == null) goto L124;
        int r199 = r198.hashCode();
    L125:
        int r200 = (r197 + r199) * 31;
        String r201 = this.stockDesc;
        if (r201 == null) goto L128;
        int r202 = r201.hashCode();
    L129:
        int r203 = (r200 + r202) * 31;
        SkuStatusDetail r204 = this.skuStatusDetail;
        if (r204 == null) goto L132;
        int r205 = r204.hashCode();
    L133:
        int r206 = (r203 + r205) * 31;
        String r207 = this.skuExtra;
        if (r207 == null) goto L136;
        int r208 = r207.hashCode();
    L137:
        int r209 = (r206 + r208) * 31;
        HashMap<String, String> r210 = this.showEventTrack;
        if (r210 == null) goto L140;
        int r211 = r210.hashCode();
    L141:
        int r212 = (r209 + r211) * 31;
        ButtonTipComponent r213 = this.buttonTipComponent;
        if (r213 == null) goto L144;
        int r214 = r213.hashCode();
    L145:
        int r215 = (r212 + r214) * 31;
        Boolean r216 = this.hideTradeIn;
        if (r216 == null) goto L148;
        int r217 = r216.hashCode();
    L149:
        int r218 = (r215 + r217) * 31;
        Boolean r219 = this.canAddCart;
        if (r219 == null) goto L152;
        int r220 = r219.hashCode();
    L153:
        int r221 = (r218 + r220) * 31;
        String r222 = this.promiseType;
        if (r222 == null) goto L157;
        r101 = r222.hashCode();
    L157:
        return r221 + r101;
    L152:
        r220 = 0;
        goto L153
    L148:
        r217 = 0;
        goto L149
    L144:
        r214 = 0;
        goto L145
    L140:
        r211 = 0;
        goto L141
    L136:
        r208 = 0;
        goto L137
    L132:
        r205 = 0;
        goto L133
    L128:
        r202 = 0;
        goto L129
    L124:
        r199 = 0;
        goto L125
    L120:
        r196 = 0;
        goto L121
    L116:
        r193 = 0;
        goto L117
    L109:
        r187 = 0;
        goto L110
    L105:
        r184 = 0;
        goto L106
    L101:
        r181 = 0;
        goto L102
    L97:
        r178 = 0;
        goto L98
    L93:
        r175 = 0;
        goto L94
    L89:
        r172 = 0;
        goto L90
    L85:
        r169 = 0;
        goto L86
    L81:
        r166 = 0;
        goto L82
    L77:
        r163 = 0;
        goto L78
    L73:
        r160 = 0;
        goto L74
    L69:
        r157 = 0;
        goto L70
    L65:
        r154 = 0;
        goto L66
    L61:
        r151 = 0;
        goto L62
    L57:
        r148 = 0;
        goto L58
    L53:
        r145 = 0;
        goto L54
    L49:
        r142 = 0;
        goto L50
    L45:
        r139 = 0;
        goto L46
    L41:
        r136 = 0;
        goto L42
    L37:
        r133 = 0;
        goto L38
    L33:
        r130 = 0;
        goto L34
    L29:
        r127 = 0;
        goto L30
    L25:
        r124 = 0;
        goto L26
    L21:
        r119 = 0;
        goto L22
    L17:
        r116 = 0;
        goto L18
    L13:
        r113 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "SkuItemInfo(id=" + this.f43092id + ", stockNum=" + this.stockNum + ", unpayNum=" + this.unpayNum + ", price=" + this.price + ", originPrice=" + this.originPrice + ", discountPrice=" + this.discountPrice + ", discountPriceText=" + this.discountPriceText + ", userLimit=" + this.userLimit + ", lowerLimit=" + this.lowerLimit + ", upperLimitToast=" + this.upperLimitToast + ", lowerLimitToast=" + this.lowerLimitToast + ", limitText=" + this.limitText + ", nowStock=" + this.nowStock + ", skuType=" + this.skuType + ", benefitLabels=" + this.benefitLabels + ", campaignPriceHeader=" + this.campaignPriceHeader + ", priceHeaderStyle=" + this.priceHeaderStyle + ", newBonusText=" + this.newBonusText + ", marketPrice=" + this.marketPrice + ", epInfo=" + this.epInfo + ", presellDelayDesc=" + this.presellDelayDesc + ", deliveryDelayDesc=" + this.deliveryDelayDesc + ", deliveryDelayBackground=" + this.deliveryDelayBackground + ", delayDescIcon=" + this.delayDescIcon + ", delayDescStyle=" + this.delayDescStyle + ", campaignStartTime=" + this.campaignStartTime + ", campaignEndTime=" + this.campaignEndTime + ", activityIcon=" + this.activityIcon + ", atmosphereHeader=" + this.atmosphereHeader + ", campaignSubType=" + this.campaignSubType + ", depositPrice=" + this.depositPrice + ", buttonLabel=" + this.buttonLabel + ", serverTime=" + this.serverTime + ", canSelect=" + this.canSelect + ", buttons=" + this.buttons + ", carAdaptComponent=" + this.carAdaptComponent + ", priceComponent=" + this.priceComponent + ", stockDesc=" + this.stockDesc + ", skuStatusDetail=" + this.skuStatusDetail + ", skuExtra=" + this.skuExtra + ", showEventTrack=" + this.showEventTrack + ", buttonTipComponent=" + this.buttonTipComponent + ", hideTradeIn=" + this.hideTradeIn + ", canAddCart=" + this.canAddCart + ", promiseType=" + this.promiseType + ")";
    }

    public final ECUrlModel getActivityIcon() {
        return this.activityIcon;
    }

    public final String getAtmosphereHeader() {
        return this.atmosphereHeader;
    }

    public final List<PromotionBenefitLabel> getBenefitLabels() {
        return this.benefitLabels;
    }

    public final String getButtonLabel() {
        return this.buttonLabel;
    }

    public final ButtonTipComponent getButtonTipComponent() {
        return this.buttonTipComponent;
    }

    public final List<SkuBottomButtons> getButtons() {
        return this.buttons;
    }

    public final Long getCampaignEndTime() {
        return this.campaignEndTime;
    }

    public final String getCampaignPriceHeader() {
        return this.campaignPriceHeader;
    }

    public final Long getCampaignStartTime() {
        return this.campaignStartTime;
    }

    public final Integer getCampaignSubType() {
        return this.campaignSubType;
    }

    public final Boolean getCanAddCart() {
        return this.canAddCart;
    }

    public final boolean getCanSelect() {
        return this.canSelect;
    }

    public final CarAdaptComponent getCarAdaptComponent() {
        return this.carAdaptComponent;
    }

    public final String getDelayDescIcon() {
        return this.delayDescIcon;
    }

    public final Integer getDelayDescStyle() {
        return this.delayDescStyle;
    }

    public final String getDeliveryDelayBackground() {
        return this.deliveryDelayBackground;
    }

    public final String getDeliveryDelayDesc() {
        return this.deliveryDelayDesc;
    }

    public final Long getDepositPrice() {
        return this.depositPrice;
    }

    public final Long getDiscountPrice() {
        return this.discountPrice;
    }

    public final String getDiscountPriceText() {
        return this.discountPriceText;
    }

    public final Object getEpInfo() {
        return this.epInfo;
    }

    public final Boolean getHideTradeIn() {
        return this.hideTradeIn;
    }

    public final String getId() {
        return this.f43092id;
    }

    public final String getLimitText() {
        return this.limitText;
    }

    public final long getLowerLimit() {
        return this.lowerLimit;
    }

    public final String getLowerLimitToast() {
        return this.lowerLimitToast;
    }

    public final Long getMarketPrice() {
        return this.marketPrice;
    }

    public final String getNewBonusText() {
        return this.newBonusText;
    }

    public final int getNowStock() {
        return this.nowStock;
    }

    public final long getOriginPrice() {
        return this.originPrice;
    }

    public final String getPresellDelayDesc() {
        return this.presellDelayDesc;
    }

    public final long getPrice() {
        return this.price;
    }

    public final PriceComponent getPriceComponent() {
        return this.priceComponent;
    }

    public final int getPriceHeaderStyle() {
        return this.priceHeaderStyle;
    }

    public final String getPromiseType() {
        return this.promiseType;
    }

    public final Long getServerTime() {
        return this.serverTime;
    }

    public final HashMap<String, String> getShowEventTrack() {
        return this.showEventTrack;
    }

    public final String getSkuExtra() {
        return this.skuExtra;
    }

    public final SkuStatusDetail getSkuStatusDetail() {
        return this.skuStatusDetail;
    }

    public final Long getSkuType() {
        return this.skuType;
    }

    public final String getStockDesc() {
        return this.stockDesc;
    }

    public final long getStockNum() {
        return this.stockNum;
    }

    public final Long getUnpayNum() {
        return this.unpayNum;
    }

    public final String getUpperLimitToast() {
        return this.upperLimitToast;
    }

    public final Long getUserLimit() {
        return this.userLimit;
    }

    public final void setDiscountPrice(Long r100) {
        this.discountPrice = r100;
    }

    public final void setDiscountPriceText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.discountPriceText = r100;
    }

    public final void setId(String r100) {
        this.f43092id = r100;
    }

    public final void setNowStock(int r100) {
        this.nowStock = r100;
    }

    public final void setOriginPrice(long r100) {
        this.originPrice = r100;
    }

    public final void setPrice(long r100) {
        this.price = r100;
    }

    public final void setStockNum(long r100) {
        this.stockNum = r100;
    }

    public SkuItemInfo(String r100, long r101, Long r102, long r110, long r111, Long r112, String r113, Long r114, long r115, String r116, String r210, String r211, int r212, Long r213, List<PromotionBenefitLabel> r214, String r215, int r216, String r217, Long r218, Object r219, String r310, String r311, String r312, String r313, Integer r314, Long r315, Long r316, ECUrlModel r317, String r318, Integer r319, Long r410, String r411, Long r412, boolean r413, List<SkuBottomButtons> r414, CarAdaptComponent r415, PriceComponent r416, String r417, SkuStatusDetail r418, String r419, HashMap<String, String> r510, ButtonTipComponent r511, Boolean r512, Boolean r513, String r514) {
        Intrinsics.checkNotNullParameter(r113, "discountPriceText");
        Intrinsics.checkNotNullParameter(r215, "campaignPriceHeader");
        this.f43092id = r100;
        this.stockNum = r101;
        this.unpayNum = r102;
        this.price = r110;
        this.originPrice = r111;
        this.discountPrice = r112;
        this.discountPriceText = r113;
        this.userLimit = r114;
        this.lowerLimit = r115;
        this.upperLimitToast = r116;
        this.lowerLimitToast = r210;
        this.limitText = r211;
        this.nowStock = r212;
        this.skuType = r213;
        this.benefitLabels = r214;
        this.campaignPriceHeader = r215;
        this.priceHeaderStyle = r216;
        this.newBonusText = r217;
        this.marketPrice = r218;
        this.epInfo = r219;
        this.presellDelayDesc = r310;
        this.deliveryDelayDesc = r311;
        this.deliveryDelayBackground = r312;
        this.delayDescIcon = r313;
        this.delayDescStyle = r314;
        this.campaignStartTime = r315;
        this.campaignEndTime = r316;
        this.activityIcon = r317;
        this.atmosphereHeader = r318;
        this.campaignSubType = r319;
        this.depositPrice = r410;
        this.buttonLabel = r411;
        this.serverTime = r412;
        this.canSelect = r413;
        this.buttons = r414;
        this.carAdaptComponent = r415;
        this.priceComponent = r416;
        this.stockDesc = r417;
        this.skuStatusDetail = r418;
        this.skuExtra = r419;
        this.showEventTrack = r510;
        this.buttonTipComponent = r511;
        this.hideTradeIn = r512;
        this.canAddCart = r513;
        this.promiseType = r514;
    }

    public /* synthetic */ SkuItemInfo(String r510, long r511, Long r512, long r513, long r610, Long r611, String r612, Long r613, long r614, String r615, String r616, String r710, int r711, Long r712, List r713, String r714, int r715, String r716, Long r717, Object r718, String r719, String r810, String r811, String r812, Integer r813, Long r814, Long r815, ECUrlModel r816, String r817, Integer r818, Long r819, String r910, Long r911, boolean r912, List r913, CarAdaptComponent r914, PriceComponent r915, String r916, SkuStatusDetail r917, String r918, HashMap r919, ButtonTipComponent r100, Boolean r101, Boolean r102, String r103, int r104, int r105, DefaultConstructorMarker r106) {
        if ((r104 & 4) == 0) goto L5;
        Long r107 = null;
    L7:
        if ((r104 & 32) == 0) goto L9;
        Long r110 = null;
    L11:
        if ((r104 & 64) == 0) goto L13;
        String r111 = "";
    L15:
        if ((r104 & 128) == 0) goto L17;
        Long r112 = null;
    L19:
        if ((r104 & 256) == 0) goto L21;
        long r113 = 1;
    L23:
        if ((r104 & 512) == 0) goto L25;
        String r114 = null;
    L27:
        if ((r104 & 1024) == 0) goto L29;
        String r115 = null;
    L31:
        if ((r104 & 2048) == 0) goto L33;
        String r210 = null;
    L35:
        if ((r104 & 4096) == 0) goto L37;
        int r211 = -1;
    L39:
        if ((r104 & 8192) == 0) goto L41;
        Long r212 = null;
    L43:
        if ((r104 & 16384) == 0) goto L45;
        List r213 = null;
    L47:
        if ((32768 & r104) == 0) goto L49;
        String r214 = "";
    L51:
        if ((65536 & r104) == 0) goto L53;
        int r215 = -1;
    L55:
        if ((131072 & r104) == 0) goto L57;
        String r216 = null;
    L59:
        if ((262144 & r104) == 0) goto L61;
        Long r217 = null;
    L63:
        if ((524288 & r104) == 0) goto L65;
        Object r218 = null;
    L67:
        if ((1048576 & r104) == 0) goto L69;
        String r219 = null;
    L71:
        if ((2097152 & r104) == 0) goto L73;
        String r310 = null;
    L75:
        if ((4194304 & r104) == 0) goto L77;
        String r311 = null;
    L79:
        if ((8388608 & r104) == 0) goto L81;
        String r312 = null;
    L83:
        if ((16777216 & r104) == 0) goto L85;
        Integer r313 = null;
    L87:
        if ((33554432 & r104) == 0) goto L89;
        Long r314 = null;
    L91:
        if ((67108864 & r104) == 0) goto L93;
        Long r315 = null;
    L95:
        if ((134217728 & r104) == 0) goto L97;
        ECUrlModel r316 = null;
    L99:
        if ((268435456 & r104) == 0) goto L101;
        String r317 = null;
    L103:
        if ((536870912 & r104) == 0) goto L105;
        Integer r318 = null;
    L107:
        if ((1073741824 & r104) == 0) goto L109;
        Long r319 = null;
    L111:
        if ((r104 & Integer.MIN_VALUE) == 0) goto L113;
        String r410 = null;
    L115:
        if ((r105 & 1) == 0) goto L117;
        Long r411 = null;
    L119:
        if ((r105 & 2) == 0) goto L121;
        boolean r412 = false;
    L123:
        if ((r105 & 4) == 0) goto L125;
        List r413 = null;
    L127:
        if ((r105 & 8) == 0) goto L129;
        CarAdaptComponent r414 = null;
    L131:
        if ((r105 & 16) == 0) goto L133;
        PriceComponent r415 = null;
    L135:
        if ((r105 & 32) == 0) goto L137;
        String r416 = null;
    L139:
        if ((r105 & 64) == 0) goto L141;
        SkuStatusDetail r417 = null;
    L143:
        if ((r105 & 128) == 0) goto L145;
        String r418 = null;
    L147:
        if ((r105 & 256) == 0) goto L149;
        HashMap r419 = null;
    L151:
        if ((r105 & 512) == 0) goto L153;
        ButtonTipComponent r514 = null;
    L155:
        if ((r105 & 1024) == 0) goto L157;
        Boolean r515 = Boolean.FALSE;
    L159:
        if ((r105 & 2048) == 0) goto L161;
        Boolean r516 = Boolean.FALSE;
    L163:
        if ((r105 & 4096) == 0) goto L165;
        String r517 = null;
    L166:
        this(r510, r511, r107, r513, r610, r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r514, r515, r516, r517);
        return;
    L165:
        r517 = r103;
        goto L166
    L161:
        r516 = r102;
        goto L163
    L157:
        r515 = r101;
        goto L159
    L153:
        r514 = r100;
        goto L155
    L149:
        r419 = r919;
        goto L151
    L145:
        r418 = r918;
        goto L147
    L141:
        r417 = r917;
        goto L143
    L137:
        r416 = r916;
        goto L139
    L133:
        r415 = r915;
        goto L135
    L129:
        r414 = r914;
        goto L131
    L125:
        r413 = r913;
        goto L127
    L121:
        r412 = r912;
        goto L123
    L117:
        r411 = r911;
        goto L119
    L113:
        r410 = r910;
        goto L115
    L109:
        r319 = r819;
        goto L111
    L105:
        r318 = r818;
        goto L107
    L101:
        r317 = r817;
        goto L103
    L97:
        r316 = r816;
        goto L99
    L93:
        r315 = r815;
        goto L95
    L89:
        r314 = r814;
        goto L91
    L85:
        r313 = r813;
        goto L87
    L81:
        r312 = r812;
        goto L83
    L77:
        r311 = r811;
        goto L79
    L73:
        r310 = r810;
        goto L75
    L69:
        r219 = r719;
        goto L71
    L65:
        r218 = r718;
        goto L67
    L61:
        r217 = r717;
        goto L63
    L57:
        r216 = r716;
        goto L59
    L53:
        r215 = r715;
        goto L55
    L49:
        r214 = r714;
        goto L51
    L45:
        r213 = r713;
        goto L47
    L41:
        r212 = r712;
        goto L43
    L37:
        r211 = r711;
        goto L39
    L33:
        r210 = r710;
        goto L35
    L29:
        r115 = r616;
        goto L31
    L25:
        r114 = r615;
        goto L27
    L21:
        r113 = r614;
        goto L23
    L17:
        r112 = r613;
        goto L19
    L13:
        r111 = r612;
        goto L15
    L9:
        r110 = r611;
        goto L11
    L5:
        r107 = r512;
        goto L7
    }
}

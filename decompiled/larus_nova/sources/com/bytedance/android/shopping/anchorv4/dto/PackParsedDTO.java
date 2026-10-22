package com.bytedance.android.shopping.anchorv4.dto;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.ecom.arch.slice.g;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.shopping.anchorv4.bottomnav.BottomNavVO;
import com.bytedance.android.shopping.anchorv4.dto.adapter.JsonToStringAdapter;
import com.bytedance.android.shopping.anchorv4.dto.business.ComponentDTO;
import com.bytedance.android.shopping.anchorv4.dto.business.GalleryVO;
import com.bytedance.android.shopping.anchorv4.dto.business.HeadMoreVideo;
import com.bytedance.android.shopping.anchorv4.dto.meta.PageMeta;
import com.bytedance.android.shopping.anchorv4.dto.meta.PageMetaMappedMap;
import com.bytedance.android.shopping.anchorv4.topbanner.TopBannerVO;
import com.bytedance.android.shopping.anchorv4.topnav.TopNavVO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.google.gson.JsonObject;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import e73.a;
import e73.b;
import e73.e;
import e73.h;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\bQ\b\u0086\b\u0018\u00002\u00020\u0001B±\u0003\u0012\u0012\b\u0002\u00109\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010=\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0002\u0012\u0018\b\u0002\u0010>\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010J\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010L\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u0010M\u001a\u0004\u0018\u00010&\u0012\u0010\b\u0002\u0010N\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\u0002\u0012\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010,\u0012\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010U\u001a\u0004\u0018\u000101\u0012\n\b\u0002\u0010V\u001a\u0004\u0018\u000103\u0012\n\b\u0002\u0010W\u001a\u0004\u0018\u000105\u0012\u0010\b\u0002\u0010X\u001a\n\u0012\u0004\u0012\u000207\u0018\u00010\u0002¢\u0006\u0006\b®\u0001\u0010¯\u0001J\u0013\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0002HÆ\u0003J\u0019\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fHÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010 HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\"HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010$HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010&HÆ\u0003J\u0011\u0010)\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\u0002HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010,HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u000101HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u000103HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u000105HÆ\u0003J\u0011\u00108\u001a\n\u0012\u0004\u0012\u000207\u0018\u00010\u0002HÆ\u0003J±\u0003\u0010Y\u001a\u00020\u00002\u0012\b\u0002\u00109\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00022\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010=\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00022\u0018\b\u0002\u0010>\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010J\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010L\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010M\u001a\u0004\u0018\u00010&2\u0010\b\u0002\u0010N\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\u00022\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010,2\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010U\u001a\u0004\u0018\u0001012\n\b\u0002\u0010V\u001a\u0004\u0018\u0001032\n\b\u0002\u0010W\u001a\u0004\u0018\u0001052\u0010\b\u0002\u0010X\u001a\n\u0012\u0004\u0012\u000207\u0018\u00010\u0002HÆ\u0001J\t\u0010Z\u001a\u00020\nHÖ\u0001J\t\u0010\\\u001a\u00020[HÖ\u0001J\u0013\u0010`\u001a\u00020_2\b\u0010^\u001a\u0004\u0018\u00010]HÖ\u0003R,\u00109\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b9\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR$\u0010:\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b:\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\u001c\u0010;\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b;\u0010k\u001a\u0004\bl\u0010mR\u001c\u0010<\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b<\u0010k\u001a\u0004\bn\u0010mR\"\u0010=\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b=\u0010a\u001a\u0004\bo\u0010cR*\u0010>\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b>\u0010p\u001a\u0004\bq\u0010rR$\u0010?\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b?\u0010s\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR$\u0010@\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b@\u0010s\u001a\u0004\bx\u0010u\"\u0004\by\u0010wR\u001c\u0010A\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\bA\u0010z\u001a\u0004\b{\u0010|R\u001c\u0010B\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\bB\u0010z\u001a\u0004\b}\u0010|R\u001d\u0010C\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\r\n\u0004\bC\u0010~\u001a\u0005\b\u007f\u0010\u0080\u0001R\u001f\u0010D\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bD\u0010\u0081\u0001\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001f\u0010E\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bE\u0010\u0084\u0001\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001R\u001f\u0010F\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bF\u0010\u0087\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R\u001f\u0010G\u001a\u0004\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bG\u0010\u008a\u0001\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001R\u001d\u0010H\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\r\n\u0004\bH\u0010z\u001a\u0005\b\u008d\u0001\u0010|R\u001d\u0010I\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\r\n\u0004\bI\u0010z\u001a\u0005\b\u008e\u0001\u0010|R\u001f\u0010J\u001a\u0004\u0018\u00010 8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bJ\u0010\u008f\u0001\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001R\u001f\u0010K\u001a\u0004\u0018\u00010\"8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bK\u0010\u0092\u0001\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001R\u001f\u0010L\u001a\u0004\u0018\u00010$8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bL\u0010\u0095\u0001\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001R\u001f\u0010M\u001a\u0004\u0018\u00010&8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bM\u0010\u0098\u0001\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001R#\u0010N\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\r\n\u0004\bN\u0010a\u001a\u0005\b\u009b\u0001\u0010cR\u001d\u0010O\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\r\n\u0004\bO\u0010z\u001a\u0005\b\u009c\u0001\u0010|R\u001d\u0010P\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\r\n\u0004\bP\u0010z\u001a\u0005\b\u009d\u0001\u0010|R\u001f\u0010Q\u001a\u0004\u0018\u00010,8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bQ\u0010\u009e\u0001\u001a\u0006\b\u009f\u0001\u0010 \u0001R\u001d\u0010R\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\r\n\u0004\bR\u0010s\u001a\u0005\b¡\u0001\u0010uR\u001d\u0010S\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\r\n\u0004\bS\u0010z\u001a\u0005\b¢\u0001\u0010|R\u001d\u0010T\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\r\n\u0004\bT\u0010z\u001a\u0005\b£\u0001\u0010|R\u001f\u0010U\u001a\u0004\u0018\u0001018\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bU\u0010¤\u0001\u001a\u0006\b¥\u0001\u0010¦\u0001R\u001f\u0010V\u001a\u0004\u0018\u0001038\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bV\u0010§\u0001\u001a\u0006\b¨\u0001\u0010©\u0001R\u001f\u0010W\u001a\u0004\u0018\u0001058\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bW\u0010ª\u0001\u001a\u0006\b«\u0001\u0010¬\u0001R#\u0010X\u001a\n\u0012\u0004\u0012\u000207\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\r\n\u0004\bX\u0010a\u001a\u0005\b\u00ad\u0001\u0010c¨\u0006°\u0001"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/PackParsedDTO;", "Ljava/io/Serializable;", "", "Lcom/bytedance/android/ecom/arch/slice/g;", "component1", "Le73/b;", "component2", "Lcom/google/gson/JsonObject;", "component3", "component4", "", "component5", "", "Lcom/bytedance/android/ecom/arch/slice/render/SlcElement;", "component6", "component7", "component8", "Lcom/bytedance/android/shopping/anchorv4/dto/business/ComponentDTO;", "component9", "component10", "Lcom/bytedance/android/shopping/anchorv4/topnav/TopNavVO;", "component11", "Lcom/bytedance/android/shopping/anchorv4/bottomnav/BottomNavVO;", "component12", "Lcom/bytedance/android/shopping/anchorv4/topbanner/TopBannerVO;", "component13", "Lcom/bytedance/android/shopping/anchorv4/dto/business/GalleryVO;", "component14", "Lcom/bytedance/android/shopping/anchorv4/dto/business/HeadMoreVideo;", "component15", "component16", "component17", "Lcom/bytedance/android/shopping/anchorv4/dto/PageConfig;", "component18", "Lcom/bytedance/android/shopping/anchorv4/dto/QuestionnaireEntrance;", "component19", "Lcom/bytedance/android/shopping/anchorv4/dto/PendantContainer;", "component20", "Lcom/bytedance/android/shopping/anchorv4/dto/Control;", "component21", "Lcom/bytedance/android/shopping/anchorv4/dto/ScrollNode;", "component22", "component23", "component24", "Lcom/bytedance/android/shopping/anchorv4/dto/meta/PageMeta;", "component25", "component26", "component27", "component28", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/AnchorV4HeadV2VO;", "component29", "Le73/a;", "component30", "Le73/e;", "component31", "Le73/h;", "component32", "components", "actionStorage", "bottomButtonObject", "topRightMeta", "photoUrls", "templates", "screenShotParams", "screenShotPopupSchema", "bottomButton", "topRightControls", "topNavVO", "bottomNavVO", "topBannerVO", "galleryVO", "moreVideo", "shopFloatEntry", "backToTopEntry", "pageConfig", "questionnaireEntrance", "pendantContainer", "control", "scrollNodes", "halfStrandVO", "smallVideoVO", "pageMeta", "debugParams", "pendantInfo", "playBackFloatEntry", "headerV2", "actionGroup", "global", "prefetchImages", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/util/List;", "getComponents", "()Ljava/util/List;", "setComponents", "(Ljava/util/List;)V", "Le73/b;", "getActionStorage", "()Le73/b;", "setActionStorage", "(Le73/b;)V", "Lcom/google/gson/JsonObject;", "getBottomButtonObject", "()Lcom/google/gson/JsonObject;", "getTopRightMeta", "getPhotoUrls", "Ljava/util/Map;", "getTemplates", "()Ljava/util/Map;", "Ljava/lang/String;", "getScreenShotParams", "()Ljava/lang/String;", "setScreenShotParams", "(Ljava/lang/String;)V", "getScreenShotPopupSchema", "setScreenShotPopupSchema", "Lcom/bytedance/android/shopping/anchorv4/dto/business/ComponentDTO;", "getBottomButton", "()Lcom/bytedance/android/shopping/anchorv4/dto/business/ComponentDTO;", "getTopRightControls", "Lcom/bytedance/android/shopping/anchorv4/topnav/TopNavVO;", "getTopNavVO", "()Lcom/bytedance/android/shopping/anchorv4/topnav/TopNavVO;", "Lcom/bytedance/android/shopping/anchorv4/bottomnav/BottomNavVO;", "getBottomNavVO", "()Lcom/bytedance/android/shopping/anchorv4/bottomnav/BottomNavVO;", "Lcom/bytedance/android/shopping/anchorv4/topbanner/TopBannerVO;", "getTopBannerVO", "()Lcom/bytedance/android/shopping/anchorv4/topbanner/TopBannerVO;", "Lcom/bytedance/android/shopping/anchorv4/dto/business/GalleryVO;", "getGalleryVO", "()Lcom/bytedance/android/shopping/anchorv4/dto/business/GalleryVO;", "Lcom/bytedance/android/shopping/anchorv4/dto/business/HeadMoreVideo;", "getMoreVideo", "()Lcom/bytedance/android/shopping/anchorv4/dto/business/HeadMoreVideo;", "getShopFloatEntry", "getBackToTopEntry", "Lcom/bytedance/android/shopping/anchorv4/dto/PageConfig;", "getPageConfig", "()Lcom/bytedance/android/shopping/anchorv4/dto/PageConfig;", "Lcom/bytedance/android/shopping/anchorv4/dto/QuestionnaireEntrance;", "getQuestionnaireEntrance", "()Lcom/bytedance/android/shopping/anchorv4/dto/QuestionnaireEntrance;", "Lcom/bytedance/android/shopping/anchorv4/dto/PendantContainer;", "getPendantContainer", "()Lcom/bytedance/android/shopping/anchorv4/dto/PendantContainer;", "Lcom/bytedance/android/shopping/anchorv4/dto/Control;", "getControl", "()Lcom/bytedance/android/shopping/anchorv4/dto/Control;", "getScrollNodes", "getHalfStrandVO", "getSmallVideoVO", "Lcom/bytedance/android/shopping/anchorv4/dto/meta/PageMeta;", "getPageMeta", "()Lcom/bytedance/android/shopping/anchorv4/dto/meta/PageMeta;", "getDebugParams", "getPendantInfo", "getPlayBackFloatEntry", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/AnchorV4HeadV2VO;", "getHeaderV2", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/AnchorV4HeadV2VO;", "Le73/a;", "getActionGroup", "()Le73/a;", "Le73/e;", "getGlobal", "()Le73/e;", "getPrefetchImages", "<init>", "(Ljava/util/List;Le73/b;Lcom/google/gson/JsonObject;Lcom/google/gson/JsonObject;Ljava/util/List;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv4/dto/business/ComponentDTO;Lcom/bytedance/android/shopping/anchorv4/dto/business/ComponentDTO;Lcom/bytedance/android/shopping/anchorv4/topnav/TopNavVO;Lcom/bytedance/android/shopping/anchorv4/bottomnav/BottomNavVO;Lcom/bytedance/android/shopping/anchorv4/topbanner/TopBannerVO;Lcom/bytedance/android/shopping/anchorv4/dto/business/GalleryVO;Lcom/bytedance/android/shopping/anchorv4/dto/business/HeadMoreVideo;Lcom/bytedance/android/shopping/anchorv4/dto/business/ComponentDTO;Lcom/bytedance/android/shopping/anchorv4/dto/business/ComponentDTO;Lcom/bytedance/android/shopping/anchorv4/dto/PageConfig;Lcom/bytedance/android/shopping/anchorv4/dto/QuestionnaireEntrance;Lcom/bytedance/android/shopping/anchorv4/dto/PendantContainer;Lcom/bytedance/android/shopping/anchorv4/dto/Control;Ljava/util/List;Lcom/bytedance/android/shopping/anchorv4/dto/business/ComponentDTO;Lcom/bytedance/android/shopping/anchorv4/dto/business/ComponentDTO;Lcom/bytedance/android/shopping/anchorv4/dto/meta/PageMeta;Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv4/dto/business/ComponentDTO;Lcom/bytedance/android/shopping/anchorv4/dto/business/ComponentDTO;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/AnchorV4HeadV2VO;Le73/a;Le73/e;Ljava/util/List;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PackParsedDTO implements Serializable {

    @SerializedName(SlcCommonAction.KEY_ACTIONS)
    private final a actionGroup;

    @SerializedName("action_storage")
    private b actionStorage;

    @SerializedName("back_to_top_entry")
    private final ComponentDTO backToTopEntry;

    @SerializedName("bottom_button")
    private final ComponentDTO bottomButton;

    @SerializedName("bottom_button_meta")
    private final JsonObject bottomButtonObject;

    @SerializedName("bottom")
    private final BottomNavVO bottomNavVO;

    @SerializedName("components")
    private List<? extends g> components;

    @SerializedName("control")
    private final Control control;

    @SerializedName("debug_params")
    @JsonAdapter(JsonToStringAdapter.class)
    private final String debugParams;

    @SerializedName("gallery")
    private final GalleryVO galleryVO;

    @SerializedName("global")
    private final e global;

    @SerializedName("half_strand")
    private final ComponentDTO halfStrandVO;

    @SerializedName("header_v2")
    private final AnchorV4HeadV2VO headerV2;

    @SerializedName("head_more_video")
    private final HeadMoreVideo moreVideo;

    @SerializedName(LynxMonitorService.KEY_PAGE_CONFIG)
    private final PageConfig pageConfig;

    @SerializedName(PageMetaMappedMap.PAGE_META_KEY)
    private final PageMeta pageMeta;

    @SerializedName("pendant_container")
    private final PendantContainer pendantContainer;

    @SerializedName("pendant_info")
    private final ComponentDTO pendantInfo;

    @SerializedName("photo_urls")
    private final List<String> photoUrls;

    @SerializedName("play_back_float_entry")
    private final ComponentDTO playBackFloatEntry;

    @SerializedName("prefetch_images")
    private final List<h> prefetchImages;

    @SerializedName("questionnaire_entrance")
    private final QuestionnaireEntrance questionnaireEntrance;

    @SerializedName("screen_shot_params")
    private String screenShotParams;

    @SerializedName("screen_shot_popup_schema")
    private String screenShotPopupSchema;

    @SerializedName("scroll_nodes")
    private final List<ScrollNode> scrollNodes;

    @SerializedName("shop_float_entry")
    private final ComponentDTO shopFloatEntry;

    @SerializedName("small_video")
    private final ComponentDTO smallVideoVO;

    @SerializedName("templates")
    private final Map<String, SlcElement> templates;

    @SerializedName("top_banner")
    private final TopBannerVO topBannerVO;

    @SerializedName("top_nav")
    private final TopNavVO topNavVO;

    @SerializedName("top_right_controls")
    private final ComponentDTO topRightControls;

    @SerializedName("top_right_meta")
    private final JsonObject topRightMeta;

    public PackParsedDTO() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PackParsedDTO copy$default(PackParsedDTO r110, List r111, b r112, JsonObject r210, JsonObject r211, List r212, Map r213, String r214, String r215, ComponentDTO r216, ComponentDTO r217, TopNavVO r218, BottomNavVO r219, TopBannerVO r310, GalleryVO r311, HeadMoreVideo r312, ComponentDTO r313, ComponentDTO r314, PageConfig r315, QuestionnaireEntrance r316, PendantContainer r317, Control r318, List r319, ComponentDTO r410, ComponentDTO r411, PageMeta r412, String r413, ComponentDTO r414, ComponentDTO r415, AnchorV4HeadV2VO r416, a r417, e r418, List r419, int r510, Object r511) {
        if ((r510 & 1) == 0) goto L5;
        List r100 = r110.components;
    L7:
        if ((r510 & 2) == 0) goto L9;
        b r101 = r110.actionStorage;
    L11:
        if ((r510 & 4) == 0) goto L13;
        JsonObject r102 = r110.bottomButtonObject;
    L15:
        if ((r510 & 8) == 0) goto L17;
        JsonObject r103 = r110.topRightMeta;
    L19:
        if ((r510 & 16) == 0) goto L21;
        List r104 = r110.photoUrls;
    L23:
        if ((r510 & 32) == 0) goto L25;
        Map r105 = r110.templates;
    L27:
        if ((r510 & 64) == 0) goto L29;
        String r106 = r110.screenShotParams;
    L31:
        if ((r510 & 128) == 0) goto L33;
        String r107 = r110.screenShotPopupSchema;
    L35:
        if ((r510 & 256) == 0) goto L37;
        ComponentDTO r113 = r110.bottomButton;
    L39:
        if ((r510 & 512) == 0) goto L41;
        ComponentDTO r114 = r110.topRightControls;
    L43:
        if ((r510 & 1024) == 0) goto L45;
        TopNavVO r115 = r110.topNavVO;
    L47:
        if ((r510 & 2048) == 0) goto L49;
        BottomNavVO r116 = r110.bottomNavVO;
    L51:
        if ((r510 & 4096) == 0) goto L53;
        TopBannerVO r117 = r110.topBannerVO;
    L55:
        if ((r510 & 8192) == 0) goto L57;
        GalleryVO r118 = r110.galleryVO;
    L58:
        GalleryVO r320 = r118;
        if ((r510 & 16384) == 0) goto L61;
        HeadMoreVideo r119 = r110.moreVideo;
    L62:
        HeadMoreVideo r321 = r119;
        if ((r510 & 32768) == 0) goto L65;
        ComponentDTO r120 = r110.shopFloatEntry;
    L66:
        ComponentDTO r322 = r120;
        if ((r510 & 65536) == 0) goto L69;
        ComponentDTO r121 = r110.backToTopEntry;
    L70:
        ComponentDTO r323 = r121;
        if ((r510 & 131072) == 0) goto L73;
        PageConfig r122 = r110.pageConfig;
    L74:
        PageConfig r324 = r122;
        if ((r510 & 262144) == 0) goto L77;
        QuestionnaireEntrance r123 = r110.questionnaireEntrance;
    L78:
        QuestionnaireEntrance r325 = r123;
        if ((r510 & 524288) == 0) goto L81;
        PendantContainer r124 = r110.pendantContainer;
    L82:
        PendantContainer r326 = r124;
        if ((r510 & 1048576) == 0) goto L85;
        Control r125 = r110.control;
    L86:
        Control r327 = r125;
        if ((r510 & 2097152) == 0) goto L89;
        List r126 = r110.scrollNodes;
    L90:
        List r328 = r126;
        if ((r510 & 4194304) == 0) goto L93;
        ComponentDTO r127 = r110.halfStrandVO;
    L94:
        ComponentDTO r420 = r127;
        if ((r510 & 8388608) == 0) goto L97;
        ComponentDTO r128 = r110.smallVideoVO;
    L98:
        ComponentDTO r421 = r128;
        if ((r510 & 16777216) == 0) goto L101;
        PageMeta r129 = r110.pageMeta;
    L102:
        PageMeta r422 = r129;
        if ((r510 & 33554432) == 0) goto L105;
        String r130 = r110.debugParams;
    L106:
        String r423 = r130;
        if ((r510 & 67108864) == 0) goto L109;
        ComponentDTO r131 = r110.pendantInfo;
    L110:
        ComponentDTO r424 = r131;
        if ((r510 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        ComponentDTO r132 = r110.playBackFloatEntry;
    L114:
        ComponentDTO r425 = r132;
        if ((r510 & 268435456) == 0) goto L117;
        AnchorV4HeadV2VO r133 = r110.headerV2;
    L118:
        AnchorV4HeadV2VO r426 = r133;
        if ((r510 & 536870912) == 0) goto L121;
        a r134 = r110.actionGroup;
    L122:
        a r427 = r134;
        if ((r510 & 1073741824) == 0) goto L125;
        e r135 = r110.global;
    L127:
        if ((r510 & Integer.MIN_VALUE) == 0) goto L129;
        List r108 = r110.prefetchImages;
    L131:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r325, r326, r327, r328, r420, r421, r422, r423, r424, r425, r426, r427, r135, r108);
    L129:
        r108 = r419;
        goto L131
    L125:
        r135 = r418;
        goto L127
    L121:
        r134 = r417;
        goto L122
    L117:
        r133 = r416;
        goto L118
    L113:
        r132 = r415;
        goto L114
    L109:
        r131 = r414;
        goto L110
    L105:
        r130 = r413;
        goto L106
    L101:
        r129 = r412;
        goto L102
    L97:
        r128 = r411;
        goto L98
    L93:
        r127 = r410;
        goto L94
    L89:
        r126 = r319;
        goto L90
    L85:
        r125 = r318;
        goto L86
    L81:
        r124 = r317;
        goto L82
    L77:
        r123 = r316;
        goto L78
    L73:
        r122 = r315;
        goto L74
    L69:
        r121 = r314;
        goto L70
    L65:
        r120 = r313;
        goto L66
    L61:
        r119 = r312;
        goto L62
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
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

    public final List<g> component1() {
        return this.components;
    }

    public final ComponentDTO component10() {
        return this.topRightControls;
    }

    public final TopNavVO component11() {
        return this.topNavVO;
    }

    public final BottomNavVO component12() {
        return this.bottomNavVO;
    }

    public final TopBannerVO component13() {
        return this.topBannerVO;
    }

    public final GalleryVO component14() {
        return this.galleryVO;
    }

    public final HeadMoreVideo component15() {
        return this.moreVideo;
    }

    public final ComponentDTO component16() {
        return this.shopFloatEntry;
    }

    public final ComponentDTO component17() {
        return this.backToTopEntry;
    }

    public final PageConfig component18() {
        return this.pageConfig;
    }

    public final QuestionnaireEntrance component19() {
        return this.questionnaireEntrance;
    }

    public final b component2() {
        return this.actionStorage;
    }

    public final PendantContainer component20() {
        return this.pendantContainer;
    }

    public final Control component21() {
        return this.control;
    }

    public final List<ScrollNode> component22() {
        return this.scrollNodes;
    }

    public final ComponentDTO component23() {
        return this.halfStrandVO;
    }

    public final ComponentDTO component24() {
        return this.smallVideoVO;
    }

    public final PageMeta component25() {
        return this.pageMeta;
    }

    public final String component26() {
        return this.debugParams;
    }

    public final ComponentDTO component27() {
        return this.pendantInfo;
    }

    public final ComponentDTO component28() {
        return this.playBackFloatEntry;
    }

    public final AnchorV4HeadV2VO component29() {
        return this.headerV2;
    }

    public final JsonObject component3() {
        return this.bottomButtonObject;
    }

    public final a component30() {
        return this.actionGroup;
    }

    public final e component31() {
        return this.global;
    }

    public final List<h> component32() {
        return this.prefetchImages;
    }

    public final JsonObject component4() {
        return this.topRightMeta;
    }

    public final List<String> component5() {
        return this.photoUrls;
    }

    public final Map<String, SlcElement> component6() {
        return this.templates;
    }

    public final String component7() {
        return this.screenShotParams;
    }

    public final String component8() {
        return this.screenShotPopupSchema;
    }

    public final ComponentDTO component9() {
        return this.bottomButton;
    }

    public final PackParsedDTO copy(List<? extends g> r310, b r311, JsonObject r312, JsonObject r313, List<String> r314, Map<String, SlcElement> r410, String r411, String r412, ComponentDTO r413, ComponentDTO r414, TopNavVO r415, BottomNavVO r416, TopBannerVO r417, GalleryVO r418, HeadMoreVideo r419, ComponentDTO r510, ComponentDTO r511, PageConfig r512, QuestionnaireEntrance r513, PendantContainer r514, Control r515, List<ScrollNode> r516, ComponentDTO r517, ComponentDTO r518, PageMeta r519, String r610, ComponentDTO r611, ComponentDTO r612, AnchorV4HeadV2VO r613, a r614, e r615, List<h> r616) {
        return new PackParsedDTO(r310, r311, r312, r313, r314, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, r615, r616);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PackParsedDTO) == false) goto L70;
        PackParsedDTO r101 = (PackParsedDTO) r100;
        if (Intrinsics.areEqual(this.components, r101.components) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.actionStorage, r101.actionStorage) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.bottomButtonObject, r101.bottomButtonObject) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.topRightMeta, r101.topRightMeta) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.photoUrls, r101.photoUrls) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.templates, r101.templates) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.screenShotParams, r101.screenShotParams) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.screenShotPopupSchema, r101.screenShotPopupSchema) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.bottomButton, r101.bottomButton) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.topRightControls, r101.topRightControls) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.topNavVO, r101.topNavVO) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.bottomNavVO, r101.bottomNavVO) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.topBannerVO, r101.topBannerVO) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.galleryVO, r101.galleryVO) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.moreVideo, r101.moreVideo) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.shopFloatEntry, r101.shopFloatEntry) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.backToTopEntry, r101.backToTopEntry) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.pageConfig, r101.pageConfig) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.questionnaireEntrance, r101.questionnaireEntrance) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.pendantContainer, r101.pendantContainer) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.control, r101.control) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.scrollNodes, r101.scrollNodes) == true) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.halfStrandVO, r101.halfStrandVO) == true) goto L52;
        return false;
    L52:
        if (Intrinsics.areEqual(this.smallVideoVO, r101.smallVideoVO) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.pageMeta, r101.pageMeta) == true) goto L56;
        return false;
    L56:
        if (Intrinsics.areEqual(this.debugParams, r101.debugParams) == true) goto L58;
        return false;
    L58:
        if (Intrinsics.areEqual(this.pendantInfo, r101.pendantInfo) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.playBackFloatEntry, r101.playBackFloatEntry) == true) goto L62;
        return false;
    L62:
        if (Intrinsics.areEqual(this.headerV2, r101.headerV2) == true) goto L64;
        return false;
    L64:
        if (Intrinsics.areEqual(this.actionGroup, r101.actionGroup) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.global, r101.global) == true) goto L68;
        return false;
    L68:
        if (Intrinsics.areEqual(this.prefetchImages, r101.prefetchImages) == true) goto L106;
        return false;
    L106:
        return true;
    L70:
        return false;
    }

    public int hashCode() {
        List<? extends g> r100 = this.components;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        b r104 = this.actionStorage;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        JsonObject r107 = this.bottomButtonObject;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        JsonObject r110 = this.topRightMeta;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        List<String> r113 = this.photoUrls;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Map<String, SlcElement> r116 = this.templates;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.screenShotParams;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.screenShotPopupSchema;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        ComponentDTO r125 = this.bottomButton;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        ComponentDTO r128 = this.topRightControls;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        TopNavVO r131 = this.topNavVO;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        BottomNavVO r134 = this.bottomNavVO;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        TopBannerVO r137 = this.topBannerVO;
        if (r137 == null) goto L53;
        int r138 = r137.hashCode();
    L54:
        int r139 = (r136 + r138) * 31;
        GalleryVO r140 = this.galleryVO;
        if (r140 == null) goto L57;
        int r141 = r140.hashCode();
    L58:
        int r142 = (r139 + r141) * 31;
        HeadMoreVideo r143 = this.moreVideo;
        if (r143 == null) goto L61;
        int r144 = r143.hashCode();
    L62:
        int r145 = (r142 + r144) * 31;
        ComponentDTO r146 = this.shopFloatEntry;
        if (r146 == null) goto L65;
        int r147 = r146.hashCode();
    L66:
        int r148 = (r145 + r147) * 31;
        ComponentDTO r149 = this.backToTopEntry;
        if (r149 == null) goto L69;
        int r150 = r149.hashCode();
    L70:
        int r151 = (r148 + r150) * 31;
        PageConfig r152 = this.pageConfig;
        if (r152 == null) goto L73;
        int r153 = r152.hashCode();
    L74:
        int r154 = (r151 + r153) * 31;
        QuestionnaireEntrance r155 = this.questionnaireEntrance;
        if (r155 == null) goto L77;
        int r156 = r155.hashCode();
    L78:
        int r157 = (r154 + r156) * 31;
        PendantContainer r158 = this.pendantContainer;
        if (r158 == null) goto L81;
        int r159 = r158.hashCode();
    L82:
        int r160 = (r157 + r159) * 31;
        Control r161 = this.control;
        if (r161 == null) goto L85;
        int r162 = r161.hashCode();
    L86:
        int r163 = (r160 + r162) * 31;
        List<ScrollNode> r164 = this.scrollNodes;
        if (r164 == null) goto L89;
        int r165 = r164.hashCode();
    L90:
        int r166 = (r163 + r165) * 31;
        ComponentDTO r167 = this.halfStrandVO;
        if (r167 == null) goto L93;
        int r168 = r167.hashCode();
    L94:
        int r169 = (r166 + r168) * 31;
        ComponentDTO r170 = this.smallVideoVO;
        if (r170 == null) goto L97;
        int r171 = r170.hashCode();
    L98:
        int r172 = (r169 + r171) * 31;
        PageMeta r173 = this.pageMeta;
        if (r173 == null) goto L101;
        int r174 = r173.hashCode();
    L102:
        int r175 = (r172 + r174) * 31;
        String r176 = this.debugParams;
        if (r176 == null) goto L105;
        int r177 = r176.hashCode();
    L106:
        int r178 = (r175 + r177) * 31;
        ComponentDTO r179 = this.pendantInfo;
        if (r179 == null) goto L109;
        int r180 = r179.hashCode();
    L110:
        int r181 = (r178 + r180) * 31;
        ComponentDTO r182 = this.playBackFloatEntry;
        if (r182 == null) goto L113;
        int r183 = r182.hashCode();
    L114:
        int r184 = (r181 + r183) * 31;
        AnchorV4HeadV2VO r185 = this.headerV2;
        if (r185 == null) goto L117;
        int r186 = r185.hashCode();
    L118:
        int r187 = (r184 + r186) * 31;
        a r188 = this.actionGroup;
        if (r188 == null) goto L121;
        int r189 = r188.hashCode();
    L122:
        int r190 = (r187 + r189) * 31;
        e r191 = this.global;
        if (r191 == null) goto L125;
        int r192 = r191.hashCode();
    L126:
        int r193 = (r190 + r192) * 31;
        List<h> r194 = this.prefetchImages;
        if (r194 == null) goto L130;
        r101 = r194.hashCode();
    L130:
        return r193 + r101;
    L125:
        r192 = 0;
        goto L126
    L121:
        r189 = 0;
        goto L122
    L117:
        r186 = 0;
        goto L118
    L113:
        r183 = 0;
        goto L114
    L109:
        r180 = 0;
        goto L110
    L105:
        r177 = 0;
        goto L106
    L101:
        r174 = 0;
        goto L102
    L97:
        r171 = 0;
        goto L98
    L93:
        r168 = 0;
        goto L94
    L89:
        r165 = 0;
        goto L90
    L85:
        r162 = 0;
        goto L86
    L81:
        r159 = 0;
        goto L82
    L77:
        r156 = 0;
        goto L78
    L73:
        r153 = 0;
        goto L74
    L69:
        r150 = 0;
        goto L70
    L65:
        r147 = 0;
        goto L66
    L61:
        r144 = 0;
        goto L62
    L57:
        r141 = 0;
        goto L58
    L53:
        r138 = 0;
        goto L54
    L49:
        r135 = 0;
        goto L50
    L45:
        r132 = 0;
        goto L46
    L41:
        r129 = 0;
        goto L42
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "PackParsedDTO(components=" + this.components + ", actionStorage=" + this.actionStorage + ", bottomButtonObject=" + this.bottomButtonObject + ", topRightMeta=" + this.topRightMeta + ", photoUrls=" + this.photoUrls + ", templates=" + this.templates + ", screenShotParams=" + this.screenShotParams + ", screenShotPopupSchema=" + this.screenShotPopupSchema + ", bottomButton=" + this.bottomButton + ", topRightControls=" + this.topRightControls + ", topNavVO=" + this.topNavVO + ", bottomNavVO=" + this.bottomNavVO + ", topBannerVO=" + this.topBannerVO + ", galleryVO=" + this.galleryVO + ", moreVideo=" + this.moreVideo + ", shopFloatEntry=" + this.shopFloatEntry + ", backToTopEntry=" + this.backToTopEntry + ", pageConfig=" + this.pageConfig + ", questionnaireEntrance=" + this.questionnaireEntrance + ", pendantContainer=" + this.pendantContainer + ", control=" + this.control + ", scrollNodes=" + this.scrollNodes + ", halfStrandVO=" + this.halfStrandVO + ", smallVideoVO=" + this.smallVideoVO + ", pageMeta=" + this.pageMeta + ", debugParams=" + this.debugParams + ", pendantInfo=" + this.pendantInfo + ", playBackFloatEntry=" + this.playBackFloatEntry + ", headerV2=" + this.headerV2 + ", actionGroup=" + this.actionGroup + ", global=" + this.global + ", prefetchImages=" + this.prefetchImages + ")";
    }

    public final a getActionGroup() {
        return this.actionGroup;
    }

    public final b getActionStorage() {
        return this.actionStorage;
    }

    public final ComponentDTO getBackToTopEntry() {
        return this.backToTopEntry;
    }

    public final ComponentDTO getBottomButton() {
        return this.bottomButton;
    }

    public final JsonObject getBottomButtonObject() {
        return this.bottomButtonObject;
    }

    public final BottomNavVO getBottomNavVO() {
        return this.bottomNavVO;
    }

    public final List<g> getComponents() {
        return this.components;
    }

    public final Control getControl() {
        return this.control;
    }

    public final String getDebugParams() {
        return this.debugParams;
    }

    public final GalleryVO getGalleryVO() {
        return this.galleryVO;
    }

    public final e getGlobal() {
        return this.global;
    }

    public final ComponentDTO getHalfStrandVO() {
        return this.halfStrandVO;
    }

    public final AnchorV4HeadV2VO getHeaderV2() {
        return this.headerV2;
    }

    public final HeadMoreVideo getMoreVideo() {
        return this.moreVideo;
    }

    public final PageConfig getPageConfig() {
        return this.pageConfig;
    }

    public final PageMeta getPageMeta() {
        return this.pageMeta;
    }

    public final PendantContainer getPendantContainer() {
        return this.pendantContainer;
    }

    public final ComponentDTO getPendantInfo() {
        return this.pendantInfo;
    }

    public final List<String> getPhotoUrls() {
        return this.photoUrls;
    }

    public final ComponentDTO getPlayBackFloatEntry() {
        return this.playBackFloatEntry;
    }

    public final List<h> getPrefetchImages() {
        return this.prefetchImages;
    }

    public final QuestionnaireEntrance getQuestionnaireEntrance() {
        return this.questionnaireEntrance;
    }

    public final String getScreenShotParams() {
        return this.screenShotParams;
    }

    public final String getScreenShotPopupSchema() {
        return this.screenShotPopupSchema;
    }

    public final List<ScrollNode> getScrollNodes() {
        return this.scrollNodes;
    }

    public final ComponentDTO getShopFloatEntry() {
        return this.shopFloatEntry;
    }

    public final ComponentDTO getSmallVideoVO() {
        return this.smallVideoVO;
    }

    public final Map<String, SlcElement> getTemplates() {
        return this.templates;
    }

    public final TopBannerVO getTopBannerVO() {
        return this.topBannerVO;
    }

    public final TopNavVO getTopNavVO() {
        return this.topNavVO;
    }

    public final ComponentDTO getTopRightControls() {
        return this.topRightControls;
    }

    public final JsonObject getTopRightMeta() {
        return this.topRightMeta;
    }

    public final void setActionStorage(b r100) {
        this.actionStorage = r100;
    }

    public final void setComponents(List<? extends g> r100) {
        this.components = r100;
    }

    public final void setScreenShotParams(String r100) {
        this.screenShotParams = r100;
    }

    public final void setScreenShotPopupSchema(String r100) {
        this.screenShotPopupSchema = r100;
    }

    public PackParsedDTO(List<? extends g> r100, b r101, JsonObject r102, JsonObject r103, List<String> r104, Map<String, SlcElement> r105, String r106, String r110, ComponentDTO r111, ComponentDTO r112, TopNavVO r113, BottomNavVO r114, TopBannerVO r115, GalleryVO r116, HeadMoreVideo r117, ComponentDTO r118, ComponentDTO r119, PageConfig r210, QuestionnaireEntrance r211, PendantContainer r212, Control r213, List<ScrollNode> r214, ComponentDTO r215, ComponentDTO r216, PageMeta r217, String r218, ComponentDTO r219, ComponentDTO r310, AnchorV4HeadV2VO r311, a r312, e r313, List<h> r314) {
        this.components = r100;
        this.actionStorage = r101;
        this.bottomButtonObject = r102;
        this.topRightMeta = r103;
        this.photoUrls = r104;
        this.templates = r105;
        this.screenShotParams = r106;
        this.screenShotPopupSchema = r110;
        this.bottomButton = r111;
        this.topRightControls = r112;
        this.topNavVO = r113;
        this.bottomNavVO = r114;
        this.topBannerVO = r115;
        this.galleryVO = r116;
        this.moreVideo = r117;
        this.shopFloatEntry = r118;
        this.backToTopEntry = r119;
        this.pageConfig = r210;
        this.questionnaireEntrance = r211;
        this.pendantContainer = r212;
        this.control = r213;
        this.scrollNodes = r214;
        this.halfStrandVO = r215;
        this.smallVideoVO = r216;
        this.pageMeta = r217;
        this.debugParams = r218;
        this.pendantInfo = r219;
        this.playBackFloatEntry = r310;
        this.headerV2 = r311;
        this.actionGroup = r312;
        this.global = r313;
        this.prefetchImages = r314;
    }

    public /* synthetic */ PackParsedDTO(List r310, b r311, JsonObject r312, JsonObject r313, List r314, Map r315, String r410, String r411, ComponentDTO r412, ComponentDTO r413, TopNavVO r414, BottomNavVO r415, TopBannerVO r416, GalleryVO r417, HeadMoreVideo r418, ComponentDTO r419, ComponentDTO r510, PageConfig r511, QuestionnaireEntrance r512, PendantContainer r513, Control r514, List r515, ComponentDTO r516, ComponentDTO r517, PageMeta r518, String r519, ComponentDTO r610, ComponentDTO r611, AnchorV4HeadV2VO r612, a r613, e r614, List r615, int r616, DefaultConstructorMarker r617) {
        if ((r616 & 1) == 0) goto L5;
        List r100 = null;
    L7:
        if ((r616 & 2) == 0) goto L9;
        b r101 = null;
    L11:
        if ((r616 & 4) == 0) goto L13;
        JsonObject r102 = null;
    L15:
        if ((r616 & 8) == 0) goto L17;
        JsonObject r103 = null;
    L19:
        if ((r616 & 16) == 0) goto L21;
        List r104 = null;
    L23:
        if ((r616 & 32) == 0) goto L25;
        Map r105 = null;
    L27:
        if ((r616 & 64) == 0) goto L29;
        String r106 = null;
    L31:
        if ((r616 & 128) == 0) goto L33;
        String r107 = null;
    L35:
        if ((r616 & 256) == 0) goto L37;
        ComponentDTO r110 = null;
    L39:
        if ((r616 & 512) == 0) goto L41;
        ComponentDTO r111 = null;
    L43:
        if ((r616 & 1024) == 0) goto L45;
        TopNavVO r112 = null;
    L47:
        if ((r616 & 2048) == 0) goto L49;
        BottomNavVO r113 = null;
    L51:
        if ((r616 & 4096) == 0) goto L53;
        TopBannerVO r114 = null;
    L55:
        if ((r616 & 8192) == 0) goto L57;
        GalleryVO r115 = null;
    L59:
        if ((r616 & 16384) == 0) goto L61;
        HeadMoreVideo r108 = null;
    L63:
        if ((r616 & 32768) == 0) goto L65;
        ComponentDTO r116 = null;
    L67:
        if ((r616 & 65536) == 0) goto L69;
        ComponentDTO r117 = null;
    L71:
        if ((r616 & 131072) == 0) goto L73;
        PageConfig r118 = null;
    L75:
        if ((r616 & 262144) == 0) goto L77;
        QuestionnaireEntrance r119 = null;
    L79:
        if ((r616 & 524288) == 0) goto L81;
        PendantContainer r210 = null;
    L83:
        if ((r616 & 1048576) == 0) goto L85;
        Control r211 = null;
    L87:
        if ((r616 & 2097152) == 0) goto L89;
        List r212 = null;
    L91:
        if ((r616 & 4194304) == 0) goto L93;
        ComponentDTO r213 = null;
    L95:
        if ((r616 & 8388608) == 0) goto L97;
        ComponentDTO r214 = null;
    L99:
        if ((r616 & 16777216) == 0) goto L101;
        PageMeta r215 = null;
    L103:
        if ((r616 & 33554432) == 0) goto L105;
        String r216 = null;
    L107:
        if ((r616 & 67108864) == 0) goto L109;
        ComponentDTO r217 = null;
    L111:
        if ((r616 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        ComponentDTO r218 = null;
    L115:
        if ((r616 & 268435456) == 0) goto L117;
        AnchorV4HeadV2VO r219 = null;
    L119:
        if ((r616 & 536870912) == 0) goto L121;
        a r316 = null;
    L123:
        if ((r616 & 1073741824) == 0) goto L125;
        e r317 = null;
    L127:
        if ((r616 & Integer.MIN_VALUE) == 0) goto L129;
        List r109 = null;
    L130:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r108, r116, r117, r118, r119, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r316, r317, r109);
        return;
    L129:
        r109 = r615;
        goto L130
    L125:
        r317 = r614;
        goto L127
    L121:
        r316 = r613;
        goto L123
    L117:
        r219 = r612;
        goto L119
    L113:
        r218 = r611;
        goto L115
    L109:
        r217 = r610;
        goto L111
    L105:
        r216 = r519;
        goto L107
    L101:
        r215 = r518;
        goto L103
    L97:
        r214 = r517;
        goto L99
    L93:
        r213 = r516;
        goto L95
    L89:
        r212 = r515;
        goto L91
    L85:
        r211 = r514;
        goto L87
    L81:
        r210 = r513;
        goto L83
    L77:
        r119 = r512;
        goto L79
    L73:
        r118 = r511;
        goto L75
    L69:
        r117 = r510;
        goto L71
    L65:
        r116 = r419;
        goto L67
    L61:
        r108 = r418;
        goto L63
    L57:
        r115 = r417;
        goto L59
    L53:
        r114 = r416;
        goto L55
    L49:
        r113 = r415;
        goto L51
    L45:
        r112 = r414;
        goto L47
    L41:
        r111 = r413;
        goto L43
    L37:
        r110 = r412;
        goto L39
    L33:
        r107 = r411;
        goto L35
    L29:
        r106 = r410;
        goto L31
    L25:
        r105 = r315;
        goto L27
    L21:
        r104 = r314;
        goto L23
    L17:
        r103 = r313;
        goto L19
    L13:
        r102 = r312;
        goto L15
    L9:
        r101 = r311;
        goto L11
    L5:
        r100 = r310;
        goto L7
    }
}

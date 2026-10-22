package com.bytedance.android.shopping.anchorv4.bottom;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.shopping.anchorv4.dto.elements.ToastElement;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LinkedTreeMap;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0003\b\u0080\u0001\b\u0086\b\u0018\u00002\u00020\u0001B§\u0003\u0012\b\b\u0002\u00103\u001a\u00020\u0005\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010@\u001a\u00020\u0015\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u0017\u0012\u0016\b\u0002\u0010B\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a\u0012\b\b\u0002\u0010C\u001a\u00020\u0017\u0012\b\b\u0002\u0010D\u001a\u00020\u0015\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010F\u001a\u00020\u0015\u0012\b\b\u0002\u0010G\u001a\u00020\u0015\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010I\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010P\u001a\u00020\u0017\u0012\u001e\b\u0002\u0010Q\u001a\u0018\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010,j\u0004\u0018\u0001`-\u0012\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010S\u001a\u0004\u0018\u000101¢\u0006\u0006\b¯\u0001\u0010°\u0001J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\t\u0010\u0006\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0015HÆ\u0003J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aHÆ\u0003J\t\u0010\u001d\u001a\u00020\u0017HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0015HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010 \u001a\u00020\u0015HÆ\u0003J\t\u0010!\u001a\u00020\u0015HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010#HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0012\u0010'\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0004\b'\u0010\u0019J\u000b\u0010(\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0012\u0010)\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0004\b)\u0010\u0019J\u000b\u0010*\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010+\u001a\u00020\u0017HÆ\u0003J\u001f\u0010.\u001a\u0018\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010,j\u0004\u0018\u0001`-HÆ\u0003J\u0012\u0010/\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0004\b/\u00100J\u000b\u00102\u001a\u0004\u0018\u000101HÆ\u0003J®\u0003\u0010T\u001a\u00020\u00002\b\b\u0002\u00103\u001a\u00020\u00052\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010@\u001a\u00020\u00152\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u00172\u0016\b\u0002\u0010B\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a2\b\b\u0002\u0010C\u001a\u00020\u00172\b\b\u0002\u0010D\u001a\u00020\u00152\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010F\u001a\u00020\u00152\b\b\u0002\u0010G\u001a\u00020\u00152\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010I\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010P\u001a\u00020\u00172\u001e\b\u0002\u0010Q\u001a\u0018\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010,j\u0004\u0018\u0001`-2\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010S\u001a\u0004\u0018\u000101HÆ\u0001¢\u0006\u0004\bT\u0010UJ\t\u0010V\u001a\u00020\u0007HÖ\u0001J\t\u0010W\u001a\u00020\u0017HÖ\u0001J\u0013\u0010Y\u001a\u00020\u00152\b\u0010X\u001a\u0004\u0018\u00010\u001bHÖ\u0003R\"\u00103\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R$\u00104\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR$\u00105\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u0010_\u001a\u0004\bd\u0010a\"\u0004\be\u0010cR$\u00106\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u0010_\u001a\u0004\bf\u0010a\"\u0004\bg\u0010cR$\u00107\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u0010_\u001a\u0004\bh\u0010a\"\u0004\bi\u0010cR$\u00108\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u0010_\u001a\u0004\bj\u0010a\"\u0004\bk\u0010cR$\u00109\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010_\u001a\u0004\bl\u0010a\"\u0004\bm\u0010cR$\u0010:\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010_\u001a\u0004\bn\u0010a\"\u0004\bo\u0010cR$\u0010;\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010_\u001a\u0004\bp\u0010a\"\u0004\bq\u0010cR$\u0010<\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010_\u001a\u0004\br\u0010a\"\u0004\bs\u0010cR$\u0010=\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010_\u001a\u0004\bt\u0010a\"\u0004\bu\u0010cR$\u0010>\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010_\u001a\u0004\bv\u0010a\"\u0004\bw\u0010cR$\u0010?\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010x\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R$\u0010@\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b@\u0010}\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R(\u0010A\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\bA\u0010\u0082\u0001\u001a\u0005\b\u0083\u0001\u0010\u0019\"\u0006\b\u0084\u0001\u0010\u0085\u0001R5\u0010B\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bB\u0010\u0086\u0001\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001\"\u0006\b\u0089\u0001\u0010\u008a\u0001R\u001d\u0010C\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bC\u0010\u008b\u0001\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001R\u001b\u0010D\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\r\n\u0004\bD\u0010}\u001a\u0005\b\u008e\u0001\u0010\u007fR\u001d\u0010E\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\r\n\u0004\bE\u0010_\u001a\u0005\b\u008f\u0001\u0010aR\u001b\u0010F\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\r\n\u0004\bF\u0010}\u001a\u0005\b\u0090\u0001\u0010\u007fR\u001a\u0010G\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\bG\u0010}\u001a\u0004\bG\u0010\u007fR\u001d\u0010H\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\r\n\u0004\bH\u0010_\u001a\u0005\b\u0091\u0001\u0010aR\u001f\u0010I\u001a\u0004\u0018\u00010#8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bI\u0010\u0092\u0001\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001R\u001d\u0010J\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\r\n\u0004\bJ\u0010_\u001a\u0005\b\u0095\u0001\u0010aR&\u0010K\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0004\bK\u0010_\u001a\u0005\b\u0096\u0001\u0010a\"\u0005\b\u0097\u0001\u0010cR(\u0010L\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0005\bL\u0010\u0082\u0001\u001a\u0005\b\u0098\u0001\u0010\u0019\"\u0006\b\u0099\u0001\u0010\u0085\u0001R&\u0010M\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0004\bM\u0010_\u001a\u0005\b\u009a\u0001\u0010a\"\u0005\b\u009b\u0001\u0010cR(\u0010N\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0005\bN\u0010\u0082\u0001\u001a\u0005\b\u009c\u0001\u0010\u0019\"\u0006\b\u009d\u0001\u0010\u0085\u0001R&\u0010O\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0004\bO\u0010_\u001a\u0005\b\u009e\u0001\u0010a\"\u0005\b\u009f\u0001\u0010cR'\u0010P\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bP\u0010\u008b\u0001\u001a\u0006\b \u0001\u0010\u008d\u0001\"\u0006\b¡\u0001\u0010¢\u0001R=\u0010Q\u001a\u0018\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010,j\u0004\u0018\u0001`-8\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bQ\u0010£\u0001\u001a\u0006\b¤\u0001\u0010¥\u0001\"\u0006\b¦\u0001\u0010§\u0001R\u001e\u0010R\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bR\u0010¨\u0001\u001a\u0005\b©\u0001\u00100R)\u0010S\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bS\u0010ª\u0001\u001a\u0006\b«\u0001\u0010¬\u0001\"\u0006\b\u00ad\u0001\u0010®\u0001¨\u0006±\u0001"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/bottom/AddCartMeta;", "Ljava/io/Serializable;", "Lcom/bytedance/android/shopping/anchorv4/dto/meta/CommonMeta;", "commonMeta", "fillCommonMeta", "", "component1", "", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "Lcf/a;", "component13", "", "component14", "", "component15", "()Ljava/lang/Integer;", "", "", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/ToastElement;", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "Lcom/google/gson/internal/LinkedTreeMap;", "Lcom/bytedance/android/shopping/anchorv4/dto/meta/TrackMeta;", "component31", "component32", "()Ljava/lang/Boolean;", "Lcom/bytedance/android/ecom/arch/slice/action/IAction;", "component33", "promotionSource", "productId", "promotionId", "originType", "originId", "authorId", "secAuthorId", "liveRoomId", "shopId", "trackExtra", "marketChannel", "itemId", "addCartListener", "withAddCartGuide", "comboNum", "trackServerMeta", "addCartAnimationStyle", "addCartAnimationV2", "addCartCover", "setCartGrey", "isGroupingBuy", "receiveAddressId", "addCartToast", "addCartPopupSchema", RemoteMessageConst.Notification.CHANNEL_ID, "channelType", "bizCampaignType", "addCartWithoutCommonskus", "skuId", "cartBusinessLineId", "trackMeta", "addCartOptimize", "addCartAfterAction", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcf/a;ZLjava/lang/Integer;Ljava/util/Map;IZLjava/lang/String;ZZLjava/lang/String;Lcom/bytedance/android/shopping/anchorv4/dto/elements/ToastElement;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ILcom/google/gson/internal/LinkedTreeMap;Ljava/lang/Boolean;Lcom/bytedance/android/ecom/arch/slice/action/IAction;)Lcom/bytedance/android/shopping/anchorv4/bottom/AddCartMeta;", "toString", "hashCode", "other", "equals", "J", "getPromotionSource", "()J", "setPromotionSource", "(J)V", "Ljava/lang/String;", "getProductId", "()Ljava/lang/String;", "setProductId", "(Ljava/lang/String;)V", "getPromotionId", "setPromotionId", "getOriginType", "setOriginType", "getOriginId", "setOriginId", "getAuthorId", "setAuthorId", "getSecAuthorId", "setSecAuthorId", "getLiveRoomId", "setLiveRoomId", "getShopId", "setShopId", "getTrackExtra", "setTrackExtra", "getMarketChannel", "setMarketChannel", "getItemId", "setItemId", "Lcf/a;", "getAddCartListener", "()Lcf/a;", "setAddCartListener", "(Lcf/a;)V", "Z", "getWithAddCartGuide", "()Z", "setWithAddCartGuide", "(Z)V", "Ljava/lang/Integer;", "getComboNum", "setComboNum", "(Ljava/lang/Integer;)V", "Ljava/util/Map;", "getTrackServerMeta", "()Ljava/util/Map;", "setTrackServerMeta", "(Ljava/util/Map;)V", "I", "getAddCartAnimationStyle", "()I", "getAddCartAnimationV2", "getAddCartCover", "getSetCartGrey", "getReceiveAddressId", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/ToastElement;", "getAddCartToast", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/ToastElement;", "getAddCartPopupSchema", "getChannelId", "setChannelId", "getChannelType", "setChannelType", "getBizCampaignType", "setBizCampaignType", "getAddCartWithoutCommonskus", "setAddCartWithoutCommonskus", "getSkuId", "setSkuId", "getCartBusinessLineId", "setCartBusinessLineId", "(I)V", "Lcom/google/gson/internal/LinkedTreeMap;", "getTrackMeta", "()Lcom/google/gson/internal/LinkedTreeMap;", "setTrackMeta", "(Lcom/google/gson/internal/LinkedTreeMap;)V", "Ljava/lang/Boolean;", "getAddCartOptimize", "Lcom/bytedance/android/ecom/arch/slice/action/IAction;", "getAddCartAfterAction", "()Lcom/bytedance/android/ecom/arch/slice/action/IAction;", "setAddCartAfterAction", "(Lcom/bytedance/android/ecom/arch/slice/action/IAction;)V", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcf/a;ZLjava/lang/Integer;Ljava/util/Map;IZLjava/lang/String;ZZLjava/lang/String;Lcom/bytedance/android/shopping/anchorv4/dto/elements/ToastElement;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ILcom/google/gson/internal/LinkedTreeMap;Ljava/lang/Boolean;Lcom/bytedance/android/ecom/arch/slice/action/IAction;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AddCartMeta implements Serializable {

    @SerializedName("add_cart_after_action")
    private IAction addCartAfterAction;

    @SerializedName("add_cart_animation_style")
    private final int addCartAnimationStyle;

    @SerializedName("add_cart_animation_v2")
    private final boolean addCartAnimationV2;

    @SerializedName("add_cart_cover")
    private final String addCartCover;
    private cf.a addCartListener;

    @SerializedName("add_cart_optimize")
    private final Boolean addCartOptimize;

    @SerializedName("add_cart_success_schema")
    private final String addCartPopupSchema;

    @SerializedName("add_cart_success_toast")
    private final ToastElement addCartToast;

    @SerializedName("add_cart_without_commonskus")
    private Integer addCartWithoutCommonskus;
    private String authorId;

    @SerializedName("biz_campaign_type")
    private String bizCampaignType;

    @SerializedName("cart_business_line_id")
    private int cartBusinessLineId;

    @SerializedName("channel_id")
    private String channelId;

    @SerializedName(WsConstants.KEY_CHANNEL_TYPE)
    private Integer channelType;
    private Integer comboNum;

    @SerializedName("is_group_buy")
    private final boolean isGroupingBuy;
    private String itemId;
    private String liveRoomId;
    private String marketChannel;
    private String originId;
    private String originType;
    private String productId;
    private String promotionId;
    private long promotionSource;

    @SerializedName("receive_address_id")
    private final String receiveAddressId;
    private String secAuthorId;

    @SerializedName("set_cart_gray")
    private final boolean setCartGrey;
    private String shopId;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SKU_ID)
    private String skuId;
    private String trackExtra;

    @SerializedName("add_cart_track_meta")
    private LinkedTreeMap<String, Object> trackMeta;
    private Map<String, ? extends Object> trackServerMeta;
    private boolean withAddCartGuide;

    public AddCartMeta() {
        this(0, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, 0, false, null, false, false, null, null, null, null, null, null, null, null, 0, null, null, null, -1, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AddCartMeta copy$default(AddCartMeta r110, long r111, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, String r310, cf.a r311, boolean r312, Integer r313, Map r314, int r315, boolean r316, String r317, boolean r318, boolean r319, String r410, ToastElement r411, String r412, String r413, Integer r414, String r415, Integer r416, String r417, int r418, LinkedTreeMap r419, Boolean r510, IAction r511, int r512, int r513, Object r514) {
        if ((r512 & 1) == 0) goto L5;
        long r100 = r110.promotionSource;
    L7:
        if ((r512 & 2) == 0) goto L9;
        String r101 = r110.productId;
    L11:
        if ((r512 & 4) == 0) goto L13;
        String r102 = r110.promotionId;
    L15:
        if ((r512 & 8) == 0) goto L17;
        String r103 = r110.originType;
    L19:
        if ((r512 & 16) == 0) goto L21;
        String r104 = r110.originId;
    L23:
        if ((r512 & 32) == 0) goto L25;
        String r105 = r110.authorId;
    L27:
        if ((r512 & 64) == 0) goto L29;
        String r106 = r110.secAuthorId;
    L31:
        if ((r512 & 128) == 0) goto L33;
        String r112 = r110.liveRoomId;
    L35:
        if ((r512 & 256) == 0) goto L37;
        String r113 = r110.shopId;
    L39:
        if ((r512 & 512) == 0) goto L41;
        String r114 = r110.trackExtra;
    L43:
        if ((r512 & 1024) == 0) goto L45;
        String r115 = r110.marketChannel;
    L47:
        if ((r512 & 2048) == 0) goto L49;
        String r116 = r110.itemId;
    L51:
        if ((r512 & 4096) == 0) goto L53;
        cf.a r117 = r110.addCartListener;
    L54:
        cf.a r320 = r117;
        if ((r512 & 8192) == 0) goto L57;
        boolean r118 = r110.withAddCartGuide;
    L58:
        boolean r321 = r118;
        if ((r512 & 16384) == 0) goto L61;
        Integer r119 = r110.comboNum;
    L62:
        Integer r322 = r119;
        if ((r512 & 32768) == 0) goto L65;
        Map r120 = r110.trackServerMeta;
    L66:
        Map r323 = r120;
        if ((r512 & 65536) == 0) goto L69;
        int r121 = r110.addCartAnimationStyle;
    L70:
        int r324 = r121;
        if ((r512 & 131072) == 0) goto L73;
        boolean r122 = r110.addCartAnimationV2;
    L74:
        boolean r325 = r122;
        if ((r512 & 262144) == 0) goto L77;
        String r123 = r110.addCartCover;
    L78:
        String r326 = r123;
        if ((r512 & 524288) == 0) goto L81;
        boolean r124 = r110.setCartGrey;
    L82:
        boolean r327 = r124;
        if ((r512 & 1048576) == 0) goto L85;
        boolean r125 = r110.isGroupingBuy;
    L86:
        boolean r328 = r125;
        if ((r512 & 2097152) == 0) goto L89;
        String r126 = r110.receiveAddressId;
    L90:
        String r420 = r126;
        if ((r512 & 4194304) == 0) goto L93;
        ToastElement r127 = r110.addCartToast;
    L94:
        ToastElement r421 = r127;
        if ((r512 & 8388608) == 0) goto L97;
        String r128 = r110.addCartPopupSchema;
    L98:
        String r422 = r128;
        if ((r512 & 16777216) == 0) goto L101;
        String r129 = r110.channelId;
    L102:
        String r423 = r129;
        if ((r512 & 33554432) == 0) goto L105;
        Integer r130 = r110.channelType;
    L106:
        Integer r424 = r130;
        if ((r512 & 67108864) == 0) goto L109;
        String r131 = r110.bizCampaignType;
    L110:
        String r425 = r131;
        if ((r512 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        Integer r132 = r110.addCartWithoutCommonskus;
    L114:
        Integer r426 = r132;
        if ((r512 & 268435456) == 0) goto L117;
        String r133 = r110.skuId;
    L118:
        String r427 = r133;
        if ((r512 & 536870912) == 0) goto L121;
        int r134 = r110.cartBusinessLineId;
    L122:
        int r428 = r134;
        if ((r512 & 1073741824) == 0) goto L125;
        LinkedTreeMap r135 = r110.trackMeta;
    L127:
        if ((r512 & Integer.MIN_VALUE) == 0) goto L129;
        Boolean r107 = r110.addCartOptimize;
    L130:
        Boolean r515 = r107;
        if ((r513 & 1) == 0) goto L133;
        IAction r108 = r110.addCartAfterAction;
    L135:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r112, r113, r114, r115, r116, r320, r321, r322, r323, r324, r325, r326, r327, r328, r420, r421, r422, r423, r424, r425, r426, r427, r428, r135, r515, r108);
    L133:
        r108 = r511;
        goto L135
    L129:
        r107 = r510;
        goto L130
    L125:
        r135 = r419;
        goto L127
    L121:
        r134 = r418;
        goto L122
    L117:
        r133 = r417;
        goto L118
    L113:
        r132 = r416;
        goto L114
    L109:
        r131 = r415;
        goto L110
    L105:
        r130 = r414;
        goto L106
    L101:
        r129 = r413;
        goto L102
    L97:
        r128 = r412;
        goto L98
    L93:
        r127 = r411;
        goto L94
    L89:
        r126 = r410;
        goto L90
    L85:
        r125 = r319;
        goto L86
    L81:
        r124 = r318;
        goto L82
    L77:
        r123 = r317;
        goto L78
    L73:
        r122 = r316;
        goto L74
    L69:
        r121 = r315;
        goto L70
    L65:
        r120 = r314;
        goto L66
    L61:
        r119 = r313;
        goto L62
    L57:
        r118 = r312;
        goto L58
    L53:
        r117 = r311;
        goto L54
    L49:
        r116 = r310;
        goto L51
    L45:
        r115 = r219;
        goto L47
    L41:
        r114 = r218;
        goto L43
    L37:
        r113 = r217;
        goto L39
    L33:
        r112 = r216;
        goto L35
    L29:
        r106 = r215;
        goto L31
    L25:
        r105 = r214;
        goto L27
    L21:
        r104 = r213;
        goto L23
    L17:
        r103 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final long component1() {
        return this.promotionSource;
    }

    public final String component10() {
        return this.trackExtra;
    }

    public final String component11() {
        return this.marketChannel;
    }

    public final String component12() {
        return this.itemId;
    }

    public final cf.a component13() {
        return this.addCartListener;
    }

    public final boolean component14() {
        return this.withAddCartGuide;
    }

    public final Integer component15() {
        return this.comboNum;
    }

    public final Map<String, Object> component16() {
        return this.trackServerMeta;
    }

    public final int component17() {
        return this.addCartAnimationStyle;
    }

    public final boolean component18() {
        return this.addCartAnimationV2;
    }

    public final String component19() {
        return this.addCartCover;
    }

    public final String component2() {
        return this.productId;
    }

    public final boolean component20() {
        return this.setCartGrey;
    }

    public final boolean component21() {
        return this.isGroupingBuy;
    }

    public final String component22() {
        return this.receiveAddressId;
    }

    public final ToastElement component23() {
        return this.addCartToast;
    }

    public final String component24() {
        return this.addCartPopupSchema;
    }

    public final String component25() {
        return this.channelId;
    }

    public final Integer component26() {
        return this.channelType;
    }

    public final String component27() {
        return this.bizCampaignType;
    }

    public final Integer component28() {
        return this.addCartWithoutCommonskus;
    }

    public final String component29() {
        return this.skuId;
    }

    public final String component3() {
        return this.promotionId;
    }

    public final int component30() {
        return this.cartBusinessLineId;
    }

    public final LinkedTreeMap<String, Object> component31() {
        return this.trackMeta;
    }

    public final Boolean component32() {
        return this.addCartOptimize;
    }

    public final IAction component33() {
        return this.addCartAfterAction;
    }

    public final String component4() {
        return this.originType;
    }

    public final String component5() {
        return this.originId;
    }

    public final String component6() {
        return this.authorId;
    }

    public final String component7() {
        return this.secAuthorId;
    }

    public final String component8() {
        return this.liveRoomId;
    }

    public final String component9() {
        return this.shopId;
    }

    public final AddCartMeta copy(long r310, String r311, String r410, String r411, String r412, String r413, String r414, String r415, String r416, String r417, String r418, String r419, cf.a r510, boolean r511, Integer r512, Map<String, ? extends Object> r513, int r514, boolean r515, String r516, boolean r517, boolean r518, String r519, ToastElement r610, String r611, String r612, Integer r613, String r614, Integer r615, String r616, int r617, LinkedTreeMap<String, Object> r618, Boolean r619, IAction r710) {
        return new AddCartMeta(r310, r311, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r710);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AddCartMeta) == false) goto L72;
        AddCartMeta r101 = (AddCartMeta) r100;
        if (this.promotionSource == r101.promotionSource) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.productId, r101.productId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.promotionId, r101.promotionId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.originType, r101.originType) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.originId, r101.originId) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.authorId, r101.authorId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.secAuthorId, r101.secAuthorId) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.liveRoomId, r101.liveRoomId) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.shopId, r101.shopId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.trackExtra, r101.trackExtra) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.marketChannel, r101.marketChannel) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.itemId, r101.itemId) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.addCartListener, r101.addCartListener) == true) goto L32;
        return false;
    L32:
        if (this.withAddCartGuide == r101.withAddCartGuide) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.comboNum, r101.comboNum) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.trackServerMeta, r101.trackServerMeta) == true) goto L38;
        return false;
    L38:
        if (this.addCartAnimationStyle == r101.addCartAnimationStyle) goto L40;
        return false;
    L40:
        if (this.addCartAnimationV2 == r101.addCartAnimationV2) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.addCartCover, r101.addCartCover) == true) goto L44;
        return false;
    L44:
        if (this.setCartGrey == r101.setCartGrey) goto L46;
        return false;
    L46:
        if (this.isGroupingBuy == r101.isGroupingBuy) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.receiveAddressId, r101.receiveAddressId) == true) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.addCartToast, r101.addCartToast) == true) goto L52;
        return false;
    L52:
        if (Intrinsics.areEqual(this.addCartPopupSchema, r101.addCartPopupSchema) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.channelId, r101.channelId) == true) goto L56;
        return false;
    L56:
        if (Intrinsics.areEqual(this.channelType, r101.channelType) == true) goto L58;
        return false;
    L58:
        if (Intrinsics.areEqual(this.bizCampaignType, r101.bizCampaignType) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.addCartWithoutCommonskus, r101.addCartWithoutCommonskus) == true) goto L62;
        return false;
    L62:
        if (Intrinsics.areEqual(this.skuId, r101.skuId) == true) goto L64;
        return false;
    L64:
        if (this.cartBusinessLineId == r101.cartBusinessLineId) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.trackMeta, r101.trackMeta) == true) goto L68;
        return false;
    L68:
        if (Intrinsics.areEqual(this.addCartOptimize, r101.addCartOptimize) == true) goto L70;
        return false;
    L70:
        if (Intrinsics.areEqual(this.addCartAfterAction, r101.addCartAfterAction) == true) goto L109;
        return false;
    L109:
        return true;
    L72:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v102 */
    /* JADX WARN: Type inference failed for: r0v115 */
    /* JADX WARN: Type inference failed for: r0v116 */
    /* JADX WARN: Type inference failed for: r0v117 */
    /* JADX WARN: Type inference failed for: r0v39, types: [int] */
    /* JADX WARN: Type inference failed for: r0v48, types: [int] */
    /* JADX WARN: Type inference failed for: r0v53, types: [int] */
    /* JADX WARN: Type inference failed for: r0v97 */
    /* JADX WARN: Type inference failed for: r0v99 */
    /* JADX WARN: Type inference failed for: r1v26, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        long r100 = this.promotionSource;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.productId;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.promotionId;
        if (r106 == null) goto L9;
        int r107 = r106.hashCode();
    L10:
        int r108 = (r105 + r107) * 31;
        String r109 = this.originType;
        if (r109 == null) goto L13;
        int r110 = r109.hashCode();
    L14:
        int r111 = (r108 + r110) * 31;
        String r112 = this.originId;
        if (r112 == null) goto L17;
        int r113 = r112.hashCode();
    L18:
        int r114 = (r111 + r113) * 31;
        String r115 = this.authorId;
        if (r115 == null) goto L21;
        int r116 = r115.hashCode();
    L22:
        int r117 = (r114 + r116) * 31;
        String r118 = this.secAuthorId;
        if (r118 == null) goto L25;
        int r119 = r118.hashCode();
    L26:
        int r120 = (r117 + r119) * 31;
        String r121 = this.liveRoomId;
        if (r121 == null) goto L29;
        int r122 = r121.hashCode();
    L30:
        int r123 = (r120 + r122) * 31;
        String r124 = this.shopId;
        if (r124 == null) goto L33;
        int r125 = r124.hashCode();
    L34:
        int r126 = (r123 + r125) * 31;
        String r127 = this.trackExtra;
        if (r127 == null) goto L37;
        int r128 = r127.hashCode();
    L38:
        int r129 = (r126 + r128) * 31;
        String r130 = this.marketChannel;
        if (r130 == null) goto L41;
        int r131 = r130.hashCode();
    L42:
        int r132 = (r129 + r131) * 31;
        String r133 = this.itemId;
        if (r133 == null) goto L45;
        int r134 = r133.hashCode();
    L46:
        int r135 = (r132 + r134) * 31;
        cf.a r136 = this.addCartListener;
        if (r136 == null) goto L49;
        int r137 = r136.hashCode();
    L50:
        int r138 = (r135 + r137) * 31;
        boolean r139 = this.withAddCartGuide;
        ?? r140 = 1;
        ?? r141 = r139;
        if (r139 == false) goto L53;
        r141 = 1;
    L53:
        int r142 = (r138 + r141) * 31;
        Integer r143 = this.comboNum;
        if (r143 == null) goto L56;
        int r144 = r143.hashCode();
    L57:
        int r145 = (r142 + r144) * 31;
        Map<String, ? extends Object> r146 = this.trackServerMeta;
        if (r146 == null) goto L60;
        int r147 = r146.hashCode();
    L61:
        int r148 = (((r145 + r147) * 31) + this.addCartAnimationStyle) * 31;
        boolean r149 = this.addCartAnimationV2;
        ?? r150 = r149;
        if (r149 == false) goto L64;
        r150 = 1;
    L64:
        int r151 = (r148 + r150) * 31;
        String r152 = this.addCartCover;
        if (r152 == null) goto L67;
        int r153 = r152.hashCode();
    L68:
        int r154 = (r151 + r153) * 31;
        boolean r155 = this.setCartGrey;
        ?? r156 = r155;
        if (r155 == false) goto L71;
        r156 = 1;
    L71:
        int r157 = (r154 + r156) * 31;
        boolean r158 = this.isGroupingBuy;
        if (r158 == true) goto L75;
        r140 = r158;
    L75:
        int r159 = (r157 + r140) * 31;
        String r160 = this.receiveAddressId;
        if (r160 == null) goto L78;
        int r161 = r160.hashCode();
    L79:
        int r162 = (r159 + r161) * 31;
        ToastElement r163 = this.addCartToast;
        if (r163 == null) goto L82;
        int r164 = r163.hashCode();
    L83:
        int r165 = (r162 + r164) * 31;
        String r166 = this.addCartPopupSchema;
        if (r166 == null) goto L86;
        int r167 = r166.hashCode();
    L87:
        int r168 = (r165 + r167) * 31;
        String r169 = this.channelId;
        if (r169 == null) goto L90;
        int r170 = r169.hashCode();
    L91:
        int r171 = (r168 + r170) * 31;
        Integer r172 = this.channelType;
        if (r172 == null) goto L94;
        int r173 = r172.hashCode();
    L95:
        int r174 = (r171 + r173) * 31;
        String r175 = this.bizCampaignType;
        if (r175 == null) goto L98;
        int r176 = r175.hashCode();
    L99:
        int r177 = (r174 + r176) * 31;
        Integer r178 = this.addCartWithoutCommonskus;
        if (r178 == null) goto L102;
        int r179 = r178.hashCode();
    L103:
        int r180 = (r177 + r179) * 31;
        String r181 = this.skuId;
        if (r181 == null) goto L106;
        int r182 = r181.hashCode();
    L107:
        int r183 = (((r180 + r182) * 31) + this.cartBusinessLineId) * 31;
        LinkedTreeMap<String, Object> r184 = this.trackMeta;
        if (r184 == null) goto L110;
        int r185 = r184.hashCode();
    L111:
        int r186 = (r183 + r185) * 31;
        Boolean r187 = this.addCartOptimize;
        if (r187 == null) goto L114;
        int r188 = r187.hashCode();
    L115:
        int r189 = (r186 + r188) * 31;
        IAction r190 = this.addCartAfterAction;
        if (r190 == null) goto L119;
        r103 = r190.hashCode();
    L119:
        return r189 + r103;
    L114:
        r188 = 0;
        goto L115
    L110:
        r185 = 0;
        goto L111
    L106:
        r182 = 0;
        goto L107
    L102:
        r179 = 0;
        goto L103
    L98:
        r176 = 0;
        goto L99
    L94:
        r173 = 0;
        goto L95
    L90:
        r170 = 0;
        goto L91
    L86:
        r167 = 0;
        goto L87
    L82:
        r164 = 0;
        goto L83
    L78:
        r161 = 0;
        goto L79
    L67:
        r153 = 0;
        goto L68
    L60:
        r147 = 0;
        goto L61
    L56:
        r144 = 0;
        goto L57
    L49:
        r137 = 0;
        goto L50
    L45:
        r134 = 0;
        goto L46
    L41:
        r131 = 0;
        goto L42
    L37:
        r128 = 0;
        goto L38
    L33:
        r125 = 0;
        goto L34
    L29:
        r122 = 0;
        goto L30
    L25:
        r119 = 0;
        goto L26
    L21:
        r116 = 0;
        goto L22
    L17:
        r113 = 0;
        goto L18
    L13:
        r110 = 0;
        goto L14
    L9:
        r107 = 0;
        goto L10
    L5:
        r104 = 0;
        goto L6
    }

    public String toString() {
        return "AddCartMeta(promotionSource=" + this.promotionSource + ", productId=" + this.productId + ", promotionId=" + this.promotionId + ", originType=" + this.originType + ", originId=" + this.originId + ", authorId=" + this.authorId + ", secAuthorId=" + this.secAuthorId + ", liveRoomId=" + this.liveRoomId + ", shopId=" + this.shopId + ", trackExtra=" + this.trackExtra + ", marketChannel=" + this.marketChannel + ", itemId=" + this.itemId + ", addCartListener=" + this.addCartListener + ", withAddCartGuide=" + this.withAddCartGuide + ", comboNum=" + this.comboNum + ", trackServerMeta=" + this.trackServerMeta + ", addCartAnimationStyle=" + this.addCartAnimationStyle + ", addCartAnimationV2=" + this.addCartAnimationV2 + ", addCartCover=" + this.addCartCover + ", setCartGrey=" + this.setCartGrey + ", isGroupingBuy=" + this.isGroupingBuy + ", receiveAddressId=" + this.receiveAddressId + ", addCartToast=" + this.addCartToast + ", addCartPopupSchema=" + this.addCartPopupSchema + ", channelId=" + this.channelId + ", channelType=" + this.channelType + ", bizCampaignType=" + this.bizCampaignType + ", addCartWithoutCommonskus=" + this.addCartWithoutCommonskus + ", skuId=" + this.skuId + ", cartBusinessLineId=" + this.cartBusinessLineId + ", trackMeta=" + this.trackMeta + ", addCartOptimize=" + this.addCartOptimize + ", addCartAfterAction=" + this.addCartAfterAction + ")";
    }

    public final IAction getAddCartAfterAction() {
        return this.addCartAfterAction;
    }

    public final int getAddCartAnimationStyle() {
        return this.addCartAnimationStyle;
    }

    public final boolean getAddCartAnimationV2() {
        return this.addCartAnimationV2;
    }

    public final String getAddCartCover() {
        return this.addCartCover;
    }

    public final cf.a getAddCartListener() {
        return this.addCartListener;
    }

    public final Boolean getAddCartOptimize() {
        return this.addCartOptimize;
    }

    public final String getAddCartPopupSchema() {
        return this.addCartPopupSchema;
    }

    public final ToastElement getAddCartToast() {
        return this.addCartToast;
    }

    public final Integer getAddCartWithoutCommonskus() {
        return this.addCartWithoutCommonskus;
    }

    public final String getAuthorId() {
        return this.authorId;
    }

    public final String getBizCampaignType() {
        return this.bizCampaignType;
    }

    public final int getCartBusinessLineId() {
        return this.cartBusinessLineId;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final Integer getChannelType() {
        return this.channelType;
    }

    public final Integer getComboNum() {
        return this.comboNum;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final String getLiveRoomId() {
        return this.liveRoomId;
    }

    public final String getMarketChannel() {
        return this.marketChannel;
    }

    public final String getOriginId() {
        return this.originId;
    }

    public final String getOriginType() {
        return this.originType;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getPromotionId() {
        return this.promotionId;
    }

    public final long getPromotionSource() {
        return this.promotionSource;
    }

    public final String getReceiveAddressId() {
        return this.receiveAddressId;
    }

    public final String getSecAuthorId() {
        return this.secAuthorId;
    }

    public final boolean getSetCartGrey() {
        return this.setCartGrey;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final String getSkuId() {
        return this.skuId;
    }

    public final String getTrackExtra() {
        return this.trackExtra;
    }

    public final LinkedTreeMap<String, Object> getTrackMeta() {
        return this.trackMeta;
    }

    public final Map<String, Object> getTrackServerMeta() {
        return this.trackServerMeta;
    }

    public final boolean getWithAddCartGuide() {
        return this.withAddCartGuide;
    }

    public final boolean isGroupingBuy() {
        return this.isGroupingBuy;
    }

    public final AddCartMeta fillCommonMeta(CommonMeta r100) {
        Integer r101 = null;
        if (r100 == null) goto L5;
        Long r102 = Long.valueOf(r100.getPromotionSource());
    L6:
        if (r102 == null) goto L61;
        this.promotionSource = r102.longValue();
        if (r100 == null) goto L10;
        String r103 = r100.getProductId();
    L11:
        this.productId = r103;
        if (r100 == null) goto L14;
        String r104 = r100.getPromotionId();
    L15:
        this.promotionId = r104;
        if (r100 == null) goto L18;
        String r105 = r100.getOriginType();
    L19:
        this.originType = r105;
        if (r100 == null) goto L22;
        String r106 = r100.getOriginId();
    L23:
        this.originId = r106;
        if (r100 == null) goto L26;
        String r107 = r100.getAuthorId();
    L27:
        this.authorId = r107;
        if (r100 == null) goto L30;
        String r108 = r100.getSecAuthorId();
    L31:
        this.secAuthorId = r108;
        if (r100 == null) goto L34;
        String r109 = r100.getLiveRoomId();
    L35:
        this.liveRoomId = r109;
        if (r100 == null) goto L38;
        String r110 = r100.getShopId();
    L39:
        this.shopId = r110;
        if (r100 == null) goto L42;
        String r111 = r100.getTrackExtra();
    L43:
        this.trackExtra = r111;
        if (r100 == null) goto L46;
        String r112 = r100.getMarketingChannel();
    L47:
        this.marketChannel = r112;
        if (r100 == null) goto L50;
        String r113 = r100.getItemId();
    L51:
        this.itemId = r113;
        if (r100 == null) goto L54;
        String r114 = r100.getChannelId();
    L55:
        this.channelId = r114;
        if (r100 == null) goto L58;
        r101 = r100.getChannelType();
    L58:
        this.channelType = r101;
        return this;
    L54:
        r114 = null;
        goto L55
    L50:
        r113 = null;
        goto L51
    L46:
        r112 = null;
        goto L47
    L42:
        r111 = null;
        goto L43
    L38:
        r110 = null;
        goto L39
    L34:
        r109 = null;
        goto L35
    L30:
        r108 = null;
        goto L31
    L26:
        r107 = null;
        goto L27
    L22:
        r106 = null;
        goto L23
    L18:
        r105 = null;
        goto L19
    L14:
        r104 = null;
        goto L15
    L10:
        r103 = null;
        goto L11
    L61:
        throw new IllegalStateException("Required value was null.".toString());
    L5:
        r102 = null;
        goto L6
    }

    public final void setAddCartAfterAction(IAction r100) {
        this.addCartAfterAction = r100;
    }

    public final void setAddCartListener(cf.a r100) {
        this.addCartListener = r100;
    }

    public final void setAddCartWithoutCommonskus(Integer r100) {
        this.addCartWithoutCommonskus = r100;
    }

    public final void setAuthorId(String r100) {
        this.authorId = r100;
    }

    public final void setBizCampaignType(String r100) {
        this.bizCampaignType = r100;
    }

    public final void setCartBusinessLineId(int r100) {
        this.cartBusinessLineId = r100;
    }

    public final void setChannelId(String r100) {
        this.channelId = r100;
    }

    public final void setChannelType(Integer r100) {
        this.channelType = r100;
    }

    public final void setComboNum(Integer r100) {
        this.comboNum = r100;
    }

    public final void setItemId(String r100) {
        this.itemId = r100;
    }

    public final void setLiveRoomId(String r100) {
        this.liveRoomId = r100;
    }

    public final void setMarketChannel(String r100) {
        this.marketChannel = r100;
    }

    public final void setOriginId(String r100) {
        this.originId = r100;
    }

    public final void setOriginType(String r100) {
        this.originType = r100;
    }

    public final void setProductId(String r100) {
        this.productId = r100;
    }

    public final void setPromotionId(String r100) {
        this.promotionId = r100;
    }

    public final void setPromotionSource(long r100) {
        this.promotionSource = r100;
    }

    public final void setSecAuthorId(String r100) {
        this.secAuthorId = r100;
    }

    public final void setShopId(String r100) {
        this.shopId = r100;
    }

    public final void setSkuId(String r100) {
        this.skuId = r100;
    }

    public final void setTrackExtra(String r100) {
        this.trackExtra = r100;
    }

    public final void setTrackMeta(LinkedTreeMap<String, Object> r100) {
        this.trackMeta = r100;
    }

    public final void setTrackServerMeta(Map<String, ? extends Object> r100) {
        this.trackServerMeta = r100;
    }

    public final void setWithAddCartGuide(boolean r100) {
        this.withAddCartGuide = r100;
    }

    public AddCartMeta(long r100, String r101, String r102, String r103, String r104, String r110, String r111, String r112, String r113, String r114, String r115, String r116, cf.a r117, boolean r118, Integer r119, Map<String, ? extends Object> r210, int r211, boolean r212, String r213, boolean r214, boolean r215, String r216, ToastElement r217, String r218, String r219, Integer r310, String r311, Integer r312, String r313, int r314, LinkedTreeMap<String, Object> r315, Boolean r316, IAction r317) {
        this.promotionSource = r100;
        this.productId = r101;
        this.promotionId = r102;
        this.originType = r103;
        this.originId = r104;
        this.authorId = r110;
        this.secAuthorId = r111;
        this.liveRoomId = r112;
        this.shopId = r113;
        this.trackExtra = r114;
        this.marketChannel = r115;
        this.itemId = r116;
        this.addCartListener = r117;
        this.withAddCartGuide = r118;
        this.comboNum = r119;
        this.trackServerMeta = r210;
        this.addCartAnimationStyle = r211;
        this.addCartAnimationV2 = r212;
        this.addCartCover = r213;
        this.setCartGrey = r214;
        this.isGroupingBuy = r215;
        this.receiveAddressId = r216;
        this.addCartToast = r217;
        this.addCartPopupSchema = r218;
        this.channelId = r219;
        this.channelType = r310;
        this.bizCampaignType = r311;
        this.addCartWithoutCommonskus = r312;
        this.skuId = r313;
        this.cartBusinessLineId = r314;
        this.trackMeta = r315;
        this.addCartOptimize = r316;
        this.addCartAfterAction = r317;
    }

    public /* synthetic */ AddCartMeta(long r310, String r311, String r312, String r313, String r314, String r410, String r411, String r412, String r413, String r414, String r415, String r416, cf.a r417, boolean r418, Integer r419, Map r510, int r511, boolean r512, String r513, boolean r514, boolean r515, String r516, ToastElement r517, String r518, String r519, Integer r610, String r611, Integer r612, String r613, int r614, LinkedTreeMap r615, Boolean r616, IAction r617, int r618, int r619, DefaultConstructorMarker r710) {
        if ((r618 & 1) == 0) goto L5;
        long r100 = 0;
    L7:
        if ((r618 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r618 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r618 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r618 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r618 & 32) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r618 & 64) == 0) goto L29;
        String r106 = null;
    L31:
        if ((r618 & 128) == 0) goto L33;
        String r110 = null;
    L35:
        if ((r618 & 256) == 0) goto L37;
        String r111 = null;
    L39:
        if ((r618 & 512) == 0) goto L41;
        String r112 = null;
    L43:
        if ((r618 & 1024) == 0) goto L45;
        String r113 = null;
    L47:
        if ((r618 & 2048) == 0) goto L49;
        String r114 = null;
    L51:
        if ((r618 & 4096) == 0) goto L53;
        cf.a r115 = null;
    L54:
        int r116 = 0;
        if ((r618 & 8192) == 0) goto L57;
        boolean r107 = false;
    L58:
        boolean r711 = r107;
        if ((r618 & 16384) == 0) goto L61;
        Integer r108 = null;
    L63:
        if ((r618 & 32768) == 0) goto L65;
        Map r117 = null;
    L67:
        if ((r618 & 65536) == 0) goto L69;
        int r118 = 0;
    L71:
        if ((r618 & 131072) == 0) goto L73;
        boolean r119 = false;
    L75:
        if ((r618 & 262144) == 0) goto L77;
        String r210 = null;
    L79:
        if ((r618 & 524288) == 0) goto L81;
        boolean r211 = false;
    L83:
        if ((r618 & 1048576) == 0) goto L85;
        boolean r212 = false;
    L87:
        if ((r618 & 2097152) == 0) goto L89;
        String r213 = null;
    L91:
        if ((r618 & 4194304) == 0) goto L93;
        ToastElement r214 = null;
    L95:
        if ((r618 & 8388608) == 0) goto L97;
        String r215 = null;
    L99:
        if ((r618 & 16777216) == 0) goto L101;
        String r216 = null;
    L103:
        if ((r618 & 33554432) == 0) goto L105;
        Integer r217 = 0;
    L107:
        if ((r618 & 67108864) == 0) goto L109;
        String r218 = null;
    L111:
        if ((r618 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        Integer r219 = 0;
    L115:
        if ((r618 & 268435456) == 0) goto L117;
        String r315 = null;
    L119:
        if ((r618 & 536870912) != 0) goto L123;
        r116 = r614;
    L123:
        if ((r618 & 1073741824) == 0) goto L125;
        LinkedTreeMap r316 = null;
    L127:
        if ((r618 & Integer.MIN_VALUE) == 0) goto L129;
        Boolean r109 = Boolean.TRUE;
    L131:
        if ((r619 & 1) == 0) goto L133;
        IAction r317 = null;
    L134:
        this(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r711, r108, r117, r118, r119, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r315, r116, r316, r109, r317);
        return;
    L133:
        r317 = r617;
        goto L134
    L129:
        r109 = r616;
        goto L131
    L125:
        r316 = r615;
        goto L127
    L117:
        r315 = r613;
        goto L119
    L113:
        r219 = r612;
        goto L115
    L109:
        r218 = r611;
        goto L111
    L105:
        r217 = r610;
        goto L107
    L101:
        r216 = r519;
        goto L103
    L97:
        r215 = r518;
        goto L99
    L93:
        r214 = r517;
        goto L95
    L89:
        r213 = r516;
        goto L91
    L85:
        r212 = r515;
        goto L87
    L81:
        r211 = r514;
        goto L83
    L77:
        r210 = r513;
        goto L79
    L73:
        r119 = r512;
        goto L75
    L69:
        r118 = r511;
        goto L71
    L65:
        r117 = r510;
        goto L67
    L61:
        r108 = r419;
        goto L63
    L57:
        r107 = r418;
        goto L58
    L53:
        r115 = r417;
        goto L54
    L49:
        r114 = r416;
        goto L51
    L45:
        r113 = r415;
        goto L47
    L41:
        r112 = r414;
        goto L43
    L37:
        r111 = r413;
        goto L39
    L33:
        r110 = r412;
        goto L35
    L29:
        r106 = r411;
        goto L31
    L25:
        r105 = r410;
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

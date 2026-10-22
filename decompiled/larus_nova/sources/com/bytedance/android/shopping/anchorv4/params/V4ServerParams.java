package com.bytedance.android.shopping.anchorv4.params;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.ec.model.promotion.ECFindSimilarConfig;
import com.bytedance.android.livehostapi.business.depend.livead.MiniAppConstants;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.ugc.aweme.search.vision.model.data.PhotoEnterModel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000+\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b(\n\u0002\u0010\u0007\n\u0003\bÈ\u0001\b\u0086\b\u0018\u00002\u00020\u0001BÍ\u0006\u0012\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010U\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010W\u001a\u00020\b\u0012\b\b\u0002\u0010X\u001a\u00020\b\u0012\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010]\u001a\u00020\u0004\u0012\b\b\u0002\u0010^\u001a\u00020\u0006\u0012\b\b\u0002\u0010_\u001a\u00020\u0004\u0012\n\b\u0002\u0010`\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010a\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010c\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010d\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010e\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010g\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010h\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010i\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010j\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010k\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010l\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010m\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010o\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010p\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010q\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010r\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010s\u001a\u00020\u0004\u0012\b\b\u0002\u0010t\u001a\u00020\u0004\u0012\n\b\u0002\u0010u\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010v\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010w\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010x\u001a\u00020\u0006\u0012\b\b\u0002\u0010y\u001a\u00020\u0004\u0012\b\b\u0002\u0010z\u001a\u000201\u0012\n\b\u0002\u0010{\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010|\u001a\u00020\u0004\u0012\n\b\u0002\u0010}\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010~\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u007f\u001a\u00020\u0004\u0012\t\b\u0002\u0010\u0080\u0001\u001a\u00020\u0006\u0012\t\b\u0002\u0010\u0081\u0001\u001a\u00020\u0006\u0012\t\b\u0002\u0010\u0082\u0001\u001a\u00020\u0004\u0012\t\b\u0002\u0010\u0083\u0001\u001a\u00020\u0004\u0012\u000b\b\u0002\u0010\u0084\u0001\u001a\u0004\u0018\u00010\b\u0012\u000b\b\u0002\u0010\u0085\u0001\u001a\u0004\u0018\u000101\u0012\u000b\b\u0002\u0010\u0086\u0001\u001a\u0004\u0018\u00010\b\u0012\u000b\b\u0002\u0010\u0087\u0001\u001a\u0004\u0018\u00010\b\u0012\u000b\b\u0002\u0010\u0088\u0001\u001a\u0004\u0018\u00010\b\u0012\u000b\b\u0002\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0006\u0012\u000b\b\u0002\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u0006\u0012\u000b\b\u0002\u0010\u008b\u0001\u001a\u0004\u0018\u00010\b\u0012\u000b\b\u0002\u0010\u008c\u0001\u001a\u0004\u0018\u00010\b\u0012\u000b\b\u0002\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u0006\u0012\u000b\b\u0002\u0010\u008e\u0001\u001a\u0004\u0018\u00010\b\u0012\u000b\b\u0002\u0010\u008f\u0001\u001a\u0004\u0018\u00010\b\u0012\u000b\b\u0002\u0010\u0090\u0001\u001a\u0004\u0018\u00010\b\u0012\u000b\b\u0002\u0010\u0091\u0001\u001a\u0004\u0018\u00010\b\u0012\t\b\u0002\u0010\u0092\u0001\u001a\u00020\u0004\u0012\t\b\u0002\u0010\u0093\u0001\u001a\u00020\u0004\u0012\u000b\b\u0002\u0010\u0094\u0001\u001a\u0004\u0018\u00010\b\u0012\u000b\b\u0002\u0010\u0095\u0001\u001a\u0004\u0018\u000101\u0012\u000b\b\u0002\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u0006\u0012\t\b\u0002\u0010\u0097\u0001\u001a\u00020\u0004\u0012\u000b\b\u0002\u0010\u0098\u0001\u001a\u0004\u0018\u00010\b\u0012\t\b\u0002\u0010\u0099\u0001\u001a\u00020\u0004¢\u0006\u0006\b÷\u0001\u0010ø\u0001J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u000b\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010\r\u001a\u00020\bHÆ\u0003J\t\u0010\u000e\u001a\u00020\bHÆ\u0003J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010*\u001a\u00020\u0004HÆ\u0003J\t\u0010+\u001a\u00020\u0004HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010/\u001a\u00020\u0006HÆ\u0003J\t\u00100\u001a\u00020\u0004HÆ\u0003J\t\u00102\u001a\u000201HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u00104\u001a\u00020\u0004HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u00106\u001a\u00020\u0004HÆ\u0003J\t\u00107\u001a\u00020\u0004HÆ\u0003J\t\u00108\u001a\u00020\u0006HÆ\u0003J\t\u00109\u001a\u00020\u0006HÆ\u0003J\t\u0010:\u001a\u00020\u0004HÆ\u0003J\t\u0010;\u001a\u00020\u0004HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0012\u0010=\u001a\u0004\u0018\u000101HÆ\u0003¢\u0006\u0004\b=\u0010>J\u000b\u0010?\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0012\u0010B\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\bB\u0010\u0010J\u0012\u0010C\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\bC\u0010\u0010J\u000b\u0010D\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0012\u0010F\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\bF\u0010\u0010J\u000b\u0010G\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010K\u001a\u00020\u0004HÆ\u0003J\t\u0010L\u001a\u00020\u0004HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0012\u0010N\u001a\u0004\u0018\u000101HÆ\u0003¢\u0006\u0004\bN\u0010>J\u0012\u0010O\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\bO\u0010\u0010J\t\u0010P\u001a\u00020\u0004HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010R\u001a\u00020\u0004HÆ\u0003J×\u0006\u0010\u009a\u0001\u001a\u00020\u00002\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010U\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010W\u001a\u00020\b2\b\b\u0002\u0010X\u001a\u00020\b2\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010]\u001a\u00020\u00042\b\b\u0002\u0010^\u001a\u00020\u00062\b\b\u0002\u0010_\u001a\u00020\u00042\n\b\u0002\u0010`\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010a\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010c\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010d\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010g\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010h\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010i\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010j\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010k\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010l\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010m\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010o\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010p\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010q\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010r\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010s\u001a\u00020\u00042\b\b\u0002\u0010t\u001a\u00020\u00042\n\b\u0002\u0010u\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010v\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010w\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010x\u001a\u00020\u00062\b\b\u0002\u0010y\u001a\u00020\u00042\b\b\u0002\u0010z\u001a\u0002012\n\b\u0002\u0010{\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010|\u001a\u00020\u00042\n\b\u0002\u0010}\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010~\u001a\u00020\u00042\b\b\u0002\u0010\u007f\u001a\u00020\u00042\t\b\u0002\u0010\u0080\u0001\u001a\u00020\u00062\t\b\u0002\u0010\u0081\u0001\u001a\u00020\u00062\t\b\u0002\u0010\u0082\u0001\u001a\u00020\u00042\t\b\u0002\u0010\u0083\u0001\u001a\u00020\u00042\u000b\b\u0002\u0010\u0084\u0001\u001a\u0004\u0018\u00010\b2\u000b\b\u0002\u0010\u0085\u0001\u001a\u0004\u0018\u0001012\u000b\b\u0002\u0010\u0086\u0001\u001a\u0004\u0018\u00010\b2\u000b\b\u0002\u0010\u0087\u0001\u001a\u0004\u0018\u00010\b2\u000b\b\u0002\u0010\u0088\u0001\u001a\u0004\u0018\u00010\b2\u000b\b\u0002\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u00062\u000b\b\u0002\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u00062\u000b\b\u0002\u0010\u008b\u0001\u001a\u0004\u0018\u00010\b2\u000b\b\u0002\u0010\u008c\u0001\u001a\u0004\u0018\u00010\b2\u000b\b\u0002\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u00062\u000b\b\u0002\u0010\u008e\u0001\u001a\u0004\u0018\u00010\b2\u000b\b\u0002\u0010\u008f\u0001\u001a\u0004\u0018\u00010\b2\u000b\b\u0002\u0010\u0090\u0001\u001a\u0004\u0018\u00010\b2\u000b\b\u0002\u0010\u0091\u0001\u001a\u0004\u0018\u00010\b2\t\b\u0002\u0010\u0092\u0001\u001a\u00020\u00042\t\b\u0002\u0010\u0093\u0001\u001a\u00020\u00042\u000b\b\u0002\u0010\u0094\u0001\u001a\u0004\u0018\u00010\b2\u000b\b\u0002\u0010\u0095\u0001\u001a\u0004\u0018\u0001012\u000b\b\u0002\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u00062\t\b\u0002\u0010\u0097\u0001\u001a\u00020\u00042\u000b\b\u0002\u0010\u0098\u0001\u001a\u0004\u0018\u00010\b2\t\b\u0002\u0010\u0099\u0001\u001a\u00020\u0004HÆ\u0001¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J\n\u0010\u009c\u0001\u001a\u00020\bHÖ\u0001R\u001f\u0010S\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bS\u0010\u009d\u0001\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001R\u001f\u0010T\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bT\u0010\u009d\u0001\u001a\u0006\b \u0001\u0010\u009f\u0001R)\u0010U\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bU\u0010\u009d\u0001\u001a\u0006\b¡\u0001\u0010\u009f\u0001\"\u0006\b¢\u0001\u0010£\u0001R)\u0010V\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bV\u0010\u009d\u0001\u001a\u0006\b¤\u0001\u0010\u009f\u0001\"\u0006\b¥\u0001\u0010£\u0001R'\u0010W\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bW\u0010\u009d\u0001\u001a\u0006\b¦\u0001\u0010\u009f\u0001\"\u0006\b§\u0001\u0010£\u0001R&\u0010X\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0005\bX\u0010\u009d\u0001\u001a\u0005\bX\u0010\u009f\u0001\"\u0006\b¨\u0001\u0010£\u0001R\u001e\u0010Y\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bY\u0010©\u0001\u001a\u0005\bª\u0001\u0010\u0010R)\u0010Z\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bZ\u0010\u009d\u0001\u001a\u0006\b«\u0001\u0010\u009f\u0001\"\u0006\b¬\u0001\u0010£\u0001R\u001f\u0010[\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\b[\u0010\u009d\u0001\u001a\u0006\b\u00ad\u0001\u0010\u009f\u0001R\u001f\u0010\\\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\b\\\u0010\u009d\u0001\u001a\u0006\b®\u0001\u0010\u009f\u0001R'\u0010]\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\b]\u0010¯\u0001\u001a\u0006\b°\u0001\u0010±\u0001\"\u0006\b²\u0001\u0010³\u0001R\u001d\u0010^\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\b^\u0010´\u0001\u001a\u0006\bµ\u0001\u0010¶\u0001R\u001c\u0010_\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b_\u0010¯\u0001\u001a\u0005\b_\u0010±\u0001R\u001f\u0010`\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\b`\u0010\u009d\u0001\u001a\u0006\b·\u0001\u0010\u009f\u0001R\u001f\u0010a\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\ba\u0010\u009d\u0001\u001a\u0006\b¸\u0001\u0010\u009f\u0001R\u001f\u0010b\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bb\u0010\u009d\u0001\u001a\u0006\b¹\u0001\u0010\u009f\u0001R\u001f\u0010c\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bc\u0010\u009d\u0001\u001a\u0006\bº\u0001\u0010\u009f\u0001R\u001f\u0010d\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bd\u0010\u009d\u0001\u001a\u0006\b»\u0001\u0010\u009f\u0001R\u001f\u0010e\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\be\u0010\u009d\u0001\u001a\u0006\b¼\u0001\u0010\u009f\u0001R\u001f\u0010f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bf\u0010\u009d\u0001\u001a\u0006\b½\u0001\u0010\u009f\u0001R\u001f\u0010g\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bg\u0010\u009d\u0001\u001a\u0006\b¾\u0001\u0010\u009f\u0001R)\u0010h\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bh\u0010\u009d\u0001\u001a\u0006\b¿\u0001\u0010\u009f\u0001\"\u0006\bÀ\u0001\u0010£\u0001R)\u0010i\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bi\u0010\u009d\u0001\u001a\u0006\bÁ\u0001\u0010\u009f\u0001\"\u0006\bÂ\u0001\u0010£\u0001R\u001f\u0010j\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bj\u0010\u009d\u0001\u001a\u0006\bÃ\u0001\u0010\u009f\u0001R\u001f\u0010k\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bk\u0010\u009d\u0001\u001a\u0006\bÄ\u0001\u0010\u009f\u0001R\u001f\u0010l\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bl\u0010\u009d\u0001\u001a\u0006\bÅ\u0001\u0010\u009f\u0001R\u001f\u0010m\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bm\u0010\u009d\u0001\u001a\u0006\bÆ\u0001\u0010\u009f\u0001R\u001f\u0010n\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bn\u0010\u009d\u0001\u001a\u0006\bÇ\u0001\u0010\u009f\u0001R\u001f\u0010o\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bo\u0010\u009d\u0001\u001a\u0006\bÈ\u0001\u0010\u009f\u0001R\u001f\u0010p\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bp\u0010\u009d\u0001\u001a\u0006\bÉ\u0001\u0010\u009f\u0001R\u001f\u0010q\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bq\u0010\u009d\u0001\u001a\u0006\bÊ\u0001\u0010\u009f\u0001R\u001f\u0010r\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\br\u0010\u009d\u0001\u001a\u0006\bË\u0001\u0010\u009f\u0001R\u001d\u0010s\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bs\u0010¯\u0001\u001a\u0006\bÌ\u0001\u0010±\u0001R\u001d\u0010t\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bt\u0010¯\u0001\u001a\u0006\bÍ\u0001\u0010±\u0001R\u001f\u0010u\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bu\u0010\u009d\u0001\u001a\u0006\bÎ\u0001\u0010\u009f\u0001R\u001f\u0010v\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bv\u0010\u009d\u0001\u001a\u0006\bÏ\u0001\u0010\u009f\u0001R\u001f\u0010w\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bw\u0010\u009d\u0001\u001a\u0006\bÐ\u0001\u0010\u009f\u0001R\u001d\u0010x\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bx\u0010´\u0001\u001a\u0006\bÑ\u0001\u0010¶\u0001R\u001d\u0010y\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\by\u0010¯\u0001\u001a\u0006\bÒ\u0001\u0010±\u0001R\u001d\u0010z\u001a\u0002018\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bz\u0010Ó\u0001\u001a\u0006\bÔ\u0001\u0010Õ\u0001R\u001f\u0010{\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\b{\u0010\u009d\u0001\u001a\u0006\bÖ\u0001\u0010\u009f\u0001R\u001c\u0010|\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b|\u0010¯\u0001\u001a\u0005\b|\u0010±\u0001R)\u0010}\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\b}\u0010\u009d\u0001\u001a\u0006\b×\u0001\u0010\u009f\u0001\"\u0006\bØ\u0001\u0010£\u0001R\u001c\u0010~\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b~\u0010¯\u0001\u001a\u0005\b~\u0010±\u0001R\u001c\u0010\u007f\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u007f\u0010¯\u0001\u001a\u0005\b\u007f\u0010±\u0001R\u001f\u0010\u0080\u0001\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b\u0080\u0001\u0010´\u0001\u001a\u0006\bÙ\u0001\u0010¶\u0001R\u001f\u0010\u0081\u0001\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b\u0081\u0001\u0010´\u0001\u001a\u0006\bÚ\u0001\u0010¶\u0001R\u001f\u0010\u0082\u0001\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b\u0082\u0001\u0010¯\u0001\u001a\u0006\b\u0082\u0001\u0010±\u0001R\u001f\u0010\u0083\u0001\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b\u0083\u0001\u0010¯\u0001\u001a\u0006\bÛ\u0001\u0010±\u0001R!\u0010\u0084\u0001\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b\u0084\u0001\u0010\u009d\u0001\u001a\u0006\bÜ\u0001\u0010\u009f\u0001R \u0010\u0085\u0001\u001a\u0004\u0018\u0001018\u0006X\u0087\u0004¢\u0006\u000f\n\u0006\b\u0085\u0001\u0010Ý\u0001\u001a\u0005\bÞ\u0001\u0010>R!\u0010\u0086\u0001\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b\u0086\u0001\u0010\u009d\u0001\u001a\u0006\bß\u0001\u0010\u009f\u0001R!\u0010\u0087\u0001\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b\u0087\u0001\u0010\u009d\u0001\u001a\u0006\bà\u0001\u0010\u009f\u0001R!\u0010\u0088\u0001\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b\u0088\u0001\u0010\u009d\u0001\u001a\u0006\bá\u0001\u0010\u009f\u0001R \u0010\u0089\u0001\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000f\n\u0006\b\u0089\u0001\u0010©\u0001\u001a\u0005\bâ\u0001\u0010\u0010R \u0010\u008a\u0001\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000f\n\u0006\b\u008a\u0001\u0010©\u0001\u001a\u0005\bã\u0001\u0010\u0010R+\u0010\u008b\u0001\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u008b\u0001\u0010\u009d\u0001\u001a\u0006\b\u008b\u0001\u0010\u009f\u0001\"\u0006\bä\u0001\u0010£\u0001R!\u0010\u008c\u0001\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b\u008c\u0001\u0010\u009d\u0001\u001a\u0006\bå\u0001\u0010\u009f\u0001R*\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0006\b\u008d\u0001\u0010©\u0001\u001a\u0005\bæ\u0001\u0010\u0010\"\u0006\bç\u0001\u0010è\u0001R!\u0010\u008e\u0001\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b\u008e\u0001\u0010\u009d\u0001\u001a\u0006\bé\u0001\u0010\u009f\u0001R!\u0010\u008f\u0001\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b\u008f\u0001\u0010\u009d\u0001\u001a\u0006\bê\u0001\u0010\u009f\u0001R!\u0010\u0090\u0001\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b\u0090\u0001\u0010\u009d\u0001\u001a\u0006\bë\u0001\u0010\u009f\u0001R!\u0010\u0091\u0001\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b\u0091\u0001\u0010\u009d\u0001\u001a\u0006\bì\u0001\u0010\u009f\u0001R\u001f\u0010\u0092\u0001\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b\u0092\u0001\u0010¯\u0001\u001a\u0006\bí\u0001\u0010±\u0001R\u001f\u0010\u0093\u0001\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b\u0093\u0001\u0010¯\u0001\u001a\u0006\bî\u0001\u0010±\u0001R!\u0010\u0094\u0001\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b\u0094\u0001\u0010\u009d\u0001\u001a\u0006\bï\u0001\u0010\u009f\u0001R*\u0010\u0095\u0001\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0006\b\u0095\u0001\u0010Ý\u0001\u001a\u0005\bð\u0001\u0010>\"\u0006\bñ\u0001\u0010ò\u0001R*\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0006\b\u0096\u0001\u0010©\u0001\u001a\u0005\bó\u0001\u0010\u0010\"\u0006\bô\u0001\u0010è\u0001R)\u0010\u0097\u0001\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0097\u0001\u0010¯\u0001\u001a\u0006\b\u0097\u0001\u0010±\u0001\"\u0006\bõ\u0001\u0010³\u0001R!\u0010\u0098\u0001\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b\u0098\u0001\u0010\u009d\u0001\u001a\u0006\bö\u0001\u0010\u009f\u0001R\u001f\u0010\u0099\u0001\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b\u0099\u0001\u0010¯\u0001\u001a\u0006\b\u0099\u0001\u0010±\u0001¨\u0006ù\u0001"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/params/V4ServerParams;", "Ljava/io/Serializable;", "", "other", "", "equals", "", "hashCode", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "()Ljava/lang/Integer;", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component50", "component51", "()Ljava/lang/Float;", "component52", "component53", "component54", "component55", "component56", "component57", "component58", "component59", "component60", "component61", "component62", "component63", "component64", "component65", "component66", "component67", "component68", "component69", "component70", "component71", "promotionId", "productId", "normalSkuId", "selectedIds", "skuSwitch", "isExpanded", "followStatus", "adLogExtraJStr", "boldParamJStr", "entranceInfo", "fullMode", "showSkuPanel", "isLuban", "pageId", "sourcePage", "enterMethod", "eComEntranceForm", "v3EventsAdditions", "whichAccount", "recommendInfo", "requestId", "productSourcePage", "moduleLabel", "labelNameFromLive", "labelNameLive", "baseVerifiedCategory", "transitionTrackerData", "threeDLogData", "requestAdditions", ReportConstant.COMMON_ACTION_TYPE, "iconType", "liveRoomId", "fromVideo", "fromLive", "searchId", "sourceMethod", "carrierSource", "goodsDetailVersion", "largeFontMode", "fontScale", "clientAbsJStr", "isMcpScene", "clientStorageJStr", "isShortScreen", "isWindowRepositionEnable", "usefulScreenWidth", "usefulScreenHeight", "isRecommendEnable", "bffSnapshotSwitch", "pdpSessionId", "mainPicScale", "coverImage", "productPreInfo", RemoteMessageConst.Notification.CHANNEL_ID, "channelType", "panelHeightPercent", "isAuth", "headerConfig", "shopRecommendTabIndex", "nativeControlFlags", "shareGroupInfo", "pdpFrequencyControl", "sourceBtmToken", "autoBuyNow", "autoAddToCart", "skuId", "halfHeadScale", "halfHeadSpace", "isInSplit", "splitScene", "isOptSplit", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IZFLjava/lang/String;ZLjava/lang/String;ZZIIZZLjava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/Float;Ljava/lang/Integer;ZLjava/lang/String;Z)Lcom/bytedance/android/shopping/anchorv4/params/V4ServerParams;", "toString", "Ljava/lang/String;", "getPromotionId", "()Ljava/lang/String;", "getProductId", "getNormalSkuId", "setNormalSkuId", "(Ljava/lang/String;)V", "getSelectedIds", "setSelectedIds", "getSkuSwitch", "setSkuSwitch", "setExpanded", "Ljava/lang/Integer;", "getFollowStatus", "getAdLogExtraJStr", "setAdLogExtraJStr", "getBoldParamJStr", "getEntranceInfo", "Z", "getFullMode", "()Z", "setFullMode", "(Z)V", "I", "getShowSkuPanel", "()I", "getPageId", "getSourcePage", "getEnterMethod", "getEComEntranceForm", "getV3EventsAdditions", "getWhichAccount", "getRecommendInfo", "getRequestId", "getProductSourcePage", "setProductSourcePage", "getModuleLabel", "setModuleLabel", "getLabelNameFromLive", "getLabelNameLive", "getBaseVerifiedCategory", "getTransitionTrackerData", "getThreeDLogData", "getRequestAdditions", "getActionType", "getIconType", "getLiveRoomId", "getFromVideo", "getFromLive", "getSearchId", "getSourceMethod", "getCarrierSource", "getGoodsDetailVersion", "getLargeFontMode", FaceService.girlLabel, "getFontScale", "()F", "getClientAbsJStr", "getClientStorageJStr", "setClientStorageJStr", "getUsefulScreenWidth", "getUsefulScreenHeight", "getBffSnapshotSwitch", "getPdpSessionId", "Ljava/lang/Float;", "getMainPicScale", "getCoverImage", "getProductPreInfo", "getChannelId", "getChannelType", "getPanelHeightPercent", "setAuth", "getHeaderConfig", "getShopRecommendTabIndex", "setShopRecommendTabIndex", "(Ljava/lang/Integer;)V", "getNativeControlFlags", "getShareGroupInfo", "getPdpFrequencyControl", "getSourceBtmToken", "getAutoBuyNow", "getAutoAddToCart", "getSkuId", "getHalfHeadScale", "setHalfHeadScale", "(Ljava/lang/Float;)V", "getHalfHeadSpace", "setHalfHeadSpace", "setInSplit", "getSplitScene", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IZFLjava/lang/String;ZLjava/lang/String;ZZIIZZLjava/lang/String;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/Float;Ljava/lang/Integer;ZLjava/lang/String;Z)V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class V4ServerParams implements Serializable {

    @SerializedName("action_type")
    private final String actionType;

    @SerializedName(PdpOpenThirdParam.KEY_AD_LOG_EXTRA)
    private String adLogExtraJStr;

    @SerializedName("auto_add_to_cart")
    private final boolean autoAddToCart;

    @SerializedName("auto_buy_now")
    private final boolean autoBuyNow;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_BASE_VERIFIED_CATEGORY)
    private final String baseVerifiedCategory;

    @SerializedName("bff_snapshot_switch")
    private final boolean bffSnapshotSwitch;

    @SerializedName("bolt_param")
    private final String boldParamJStr;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE)
    private final String carrierSource;

    @SerializedName("channel_id")
    private final String channelId;

    @SerializedName(WsConstants.KEY_CHANNEL_TYPE)
    private final Integer channelType;

    @SerializedName("client_abs")
    private final String clientAbsJStr;

    @SerializedName("client_storage")
    private String clientStorageJStr;

    @SerializedName("cover_img")
    private final String coverImage;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM)
    private final String eComEntranceForm;

    @SerializedName("enter_method")
    private final String enterMethod;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO)
    private final String entranceInfo;

    @SerializedName("follow_status")
    private final Integer followStatus;

    @SerializedName("font_scale")
    private final float fontScale;

    @SerializedName("from_live")
    private final boolean fromLive;

    @SerializedName("from_video")
    private final boolean fromVideo;

    @SerializedName("full_mode")
    private boolean fullMode;

    @SerializedName("iesec_new_goods_detail_edition")
    private final int goodsDetailVersion;

    @SerializedName("half_head_scale")
    private Float halfHeadScale;

    @SerializedName("half_head_space")
    private Integer halfHeadSpace;

    @SerializedName("header_config")
    private final String headerConfig;

    @SerializedName("icon_type")
    private final String iconType;

    @SerializedName("is_auth")
    private String isAuth;

    @SerializedName("is_expanded")
    private String isExpanded;

    @SerializedName("is_in_split")
    private boolean isInSplit;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_IS_LUBAN)
    private final boolean isLuban;

    @SerializedName("is_mcp_scene")
    private final boolean isMcpScene;

    @SerializedName("is_opt_split")
    private final boolean isOptSplit;

    @SerializedName("is_recommend_enable")
    private final boolean isRecommendEnable;

    @SerializedName("is_short_screen")
    private final boolean isShortScreen;

    @SerializedName("window_reposition")
    private final boolean isWindowRepositionEnable;

    @SerializedName("label_name_from_live")
    private final String labelNameFromLive;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME_LIVE)
    private final String labelNameLive;

    @SerializedName("large_font_scale")
    private final boolean largeFontMode;

    @SerializedName(MiniAppConstants.KEY_MINI_APP_LIVE_ROOM_ID)
    private final String liveRoomId;

    @SerializedName("main_pic_scale")
    private final Float mainPicScale;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL)
    private String moduleLabel;

    @SerializedName("native_control_flags")
    private final String nativeControlFlags;

    @SerializedName("normal_sku_id")
    private String normalSkuId;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_PAGE_ID)
    private final String pageId;

    @SerializedName(ECFindSimilarConfig.HEIGHT_PERCENT)
    private final Integer panelHeightPercent;

    @SerializedName("pdp_frequency_control")
    private final String pdpFrequencyControl;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_PDP_SESSION_ID)
    private final String pdpSessionId;

    @SerializedName("product_id")
    private final String productId;

    @SerializedName("product_pre_info")
    private final String productPreInfo;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_SOURCE_PAGE)
    private String productSourcePage;

    @SerializedName("promotion_id")
    private final String promotionId;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO)
    private final String recommendInfo;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_REQUEST_ADDITIONS)
    private final String requestAdditions;

    @SerializedName("request_id")
    private final String requestId;

    @SerializedName("search_id")
    private final String searchId;

    @SerializedName("selected_ids")
    private String selectedIds;

    @SerializedName("share_group_info")
    private final String shareGroupInfo;

    @SerializedName("shop_recommend_tab_index")
    private Integer shopRecommendTabIndex;

    @SerializedName("show_sku_panel")
    private final int showSkuPanel;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SKU_ID)
    private final String skuId;

    @SerializedName("sku_switch")
    private String skuSwitch;

    @SerializedName(PhotoEnterModel.SOURCE_BTM_TOKEN)
    private final String sourceBtmToken;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SOURCE_METHOD)
    private final String sourceMethod;

    @SerializedName("source_page")
    private final String sourcePage;

    @SerializedName("split_scene")
    private final String splitScene;

    @SerializedName("three_d_log_data")
    private final String threeDLogData;

    @SerializedName("transition_tracker_data")
    private final String transitionTrackerData;

    @SerializedName("useful_screen_height")
    private final int usefulScreenHeight;

    @SerializedName("useful_screen_width")
    private final int usefulScreenWidth;

    @SerializedName("v3_events_additions")
    private final String v3EventsAdditions;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_WHICH_ACCOUNT)
    private final String whichAccount;

    public V4ServerParams() {
        this(null, null, null, null, null, null, null, null, null, null, false, 0, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, null, null, null, 0, false, 0.0f, null, false, null, false, false, 0, 0, false, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, null, null, null, false, null, false, -1, -1, 127, null);
    }

    public static int a(boolean r100) {
        if (r100 == false) goto L4;
        return 1231;
    L4:
        return 1237;
    }

    public static /* synthetic */ V4ServerParams copy$default(V4ServerParams r210, String r211, String r212, String r213, String r214, String r215, String r310, Integer r311, String r312, String r313, String r314, boolean r315, int r316, boolean r317, String r318, String r319, String r410, String r411, String r412, String r413, String r414, String r415, String r416, String r417, String r418, String r419, String r510, String r511, String r512, String r513, String r514, String r515, String r516, boolean r517, boolean r518, String r519, String r610, String r611, int r612, boolean r613, float r614, String r615, boolean r616, String r617, boolean r618, boolean r619, int r710, int r711, boolean r712, boolean r713, String r714, Float r715, String r716, String r717, String r718, Integer r719, Integer r810, String r811, String r812, Integer r813, String r814, String r815, String r816, String r817, boolean r818, boolean r819, String r910, Float r911, Integer r912, boolean r913, String r914, boolean r915, int r916, int r917, int r918, Object r919) {
        if ((r916 & 1) == 0) goto L5;
        String r100 = r210.promotionId;
    L7:
        if ((r916 & 2) == 0) goto L9;
        String r101 = r210.productId;
    L11:
        if ((r916 & 4) == 0) goto L13;
        String r102 = r210.normalSkuId;
    L15:
        if ((r916 & 8) == 0) goto L17;
        String r103 = r210.selectedIds;
    L19:
        if ((r916 & 16) == 0) goto L21;
        String r104 = r210.skuSwitch;
    L23:
        if ((r916 & 32) == 0) goto L25;
        String r105 = r210.isExpanded;
    L27:
        if ((r916 & 64) == 0) goto L29;
        Integer r106 = r210.followStatus;
    L31:
        if ((r916 & 128) == 0) goto L33;
        String r110 = r210.adLogExtraJStr;
    L35:
        if ((r916 & 256) == 0) goto L37;
        String r111 = r210.boldParamJStr;
    L39:
        if ((r916 & 512) == 0) goto L41;
        String r112 = r210.entranceInfo;
    L43:
        if ((r916 & 1024) == 0) goto L45;
        boolean r113 = r210.fullMode;
    L47:
        if ((r916 & 2048) == 0) goto L49;
        int r114 = r210.showSkuPanel;
    L51:
        if ((r916 & 4096) == 0) goto L53;
        boolean r115 = r210.isLuban;
    L54:
        boolean r320 = r115;
        if ((r916 & 8192) == 0) goto L57;
        String r116 = r210.pageId;
    L58:
        String r321 = r116;
        if ((r916 & 16384) == 0) goto L61;
        String r117 = r210.sourcePage;
    L62:
        String r322 = r117;
        if ((r916 & 32768) == 0) goto L65;
        String r118 = r210.enterMethod;
    L66:
        String r420 = r118;
        if ((r916 & 65536) == 0) goto L69;
        String r119 = r210.eComEntranceForm;
    L70:
        String r421 = r119;
        if ((r916 & 131072) == 0) goto L73;
        String r120 = r210.v3EventsAdditions;
    L74:
        String r422 = r120;
        if ((r916 & 262144) == 0) goto L77;
        String r121 = r210.whichAccount;
    L78:
        String r423 = r121;
        if ((r916 & 524288) == 0) goto L81;
        String r122 = r210.recommendInfo;
    L82:
        String r424 = r122;
        if ((r916 & 1048576) == 0) goto L85;
        String r123 = r210.requestId;
    L86:
        String r425 = r123;
        if ((r916 & 2097152) == 0) goto L89;
        String r124 = r210.productSourcePage;
    L90:
        String r426 = r124;
        if ((r916 & 4194304) == 0) goto L93;
        String r125 = r210.moduleLabel;
    L94:
        String r427 = r125;
        if ((r916 & 8388608) == 0) goto L97;
        String r126 = r210.labelNameFromLive;
    L98:
        String r428 = r126;
        if ((r916 & 16777216) == 0) goto L101;
        String r127 = r210.labelNameLive;
    L102:
        String r429 = r127;
        if ((r916 & 33554432) == 0) goto L105;
        String r128 = r210.baseVerifiedCategory;
    L106:
        String r520 = r128;
        if ((r916 & 67108864) == 0) goto L109;
        String r129 = r210.transitionTrackerData;
    L110:
        String r521 = r129;
        if ((r916 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        String r130 = r210.threeDLogData;
    L114:
        String r522 = r130;
        if ((r916 & 268435456) == 0) goto L117;
        String r131 = r210.requestAdditions;
    L118:
        String r523 = r131;
        if ((r916 & 536870912) == 0) goto L121;
        String r132 = r210.actionType;
    L122:
        String r524 = r132;
        if ((r916 & 1073741824) == 0) goto L125;
        String r133 = r210.iconType;
    L127:
        if ((r916 & Integer.MIN_VALUE) == 0) goto L129;
        String r107 = r210.liveRoomId;
    L130:
        String r525 = r107;
        if ((r917 & 1) == 0) goto L133;
        boolean r108 = r210.fromVideo;
    L134:
        boolean r526 = r108;
        if ((r917 & 2) == 0) goto L137;
        boolean r109 = r210.fromLive;
    L138:
        boolean r527 = r109;
        if ((r917 & 4) == 0) goto L141;
        String r134 = r210.searchId;
    L142:
        String r528 = r134;
        if ((r917 & 8) == 0) goto L145;
        String r135 = r210.sourceMethod;
    L146:
        String r620 = r135;
        if ((r917 & 16) == 0) goto L149;
        String r136 = r210.carrierSource;
    L150:
        String r621 = r136;
        if ((r917 & 32) == 0) goto L153;
        int r137 = r210.goodsDetailVersion;
    L154:
        int r622 = r137;
        if ((r917 & 64) == 0) goto L157;
        boolean r138 = r210.largeFontMode;
    L158:
        boolean r623 = r138;
        if ((r917 & 128) == 0) goto L161;
        float r139 = r210.fontScale;
    L162:
        float r624 = r139;
        if ((r917 & 256) == 0) goto L165;
        String r140 = r210.clientAbsJStr;
    L166:
        String r625 = r140;
        if ((r917 & 512) == 0) goto L169;
        boolean r141 = r210.isMcpScene;
    L170:
        boolean r626 = r141;
        if ((r917 & 1024) == 0) goto L173;
        String r142 = r210.clientStorageJStr;
    L174:
        String r627 = r142;
        if ((r917 & 2048) == 0) goto L177;
        boolean r143 = r210.isShortScreen;
    L178:
        boolean r628 = r143;
        if ((r917 & 4096) == 0) goto L181;
        boolean r144 = r210.isWindowRepositionEnable;
    L182:
        boolean r629 = r144;
        if ((r917 & 8192) == 0) goto L185;
        int r145 = r210.usefulScreenWidth;
    L186:
        int r720 = r145;
        if ((r917 & 16384) == 0) goto L189;
        int r146 = r210.usefulScreenHeight;
    L190:
        int r721 = r146;
        if ((r917 & 32768) == 0) goto L193;
        boolean r147 = r210.isRecommendEnable;
    L194:
        boolean r722 = r147;
        if ((r917 & 65536) == 0) goto L197;
        boolean r148 = r210.bffSnapshotSwitch;
    L198:
        boolean r723 = r148;
        if ((r917 & 131072) == 0) goto L201;
        String r149 = r210.pdpSessionId;
    L202:
        String r724 = r149;
        if ((r917 & 262144) == 0) goto L205;
        Float r150 = r210.mainPicScale;
    L206:
        Float r725 = r150;
        if ((r917 & 524288) == 0) goto L209;
        String r151 = r210.coverImage;
    L210:
        String r726 = r151;
        if ((r917 & 1048576) == 0) goto L213;
        String r152 = r210.productPreInfo;
    L214:
        String r727 = r152;
        if ((r917 & 2097152) == 0) goto L217;
        String r153 = r210.channelId;
    L218:
        String r728 = r153;
        if ((r917 & 4194304) == 0) goto L221;
        Integer r154 = r210.channelType;
    L222:
        Integer r729 = r154;
        if ((r917 & 8388608) == 0) goto L225;
        Integer r155 = r210.panelHeightPercent;
    L226:
        Integer r820 = r155;
        if ((r917 & 16777216) == 0) goto L229;
        String r156 = r210.isAuth;
    L230:
        String r821 = r156;
        if ((r917 & 33554432) == 0) goto L233;
        String r157 = r210.headerConfig;
    L234:
        String r822 = r157;
        if ((r917 & 67108864) == 0) goto L237;
        Integer r158 = r210.shopRecommendTabIndex;
    L238:
        Integer r823 = r158;
        if ((r917 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L241;
        String r159 = r210.nativeControlFlags;
    L242:
        String r824 = r159;
        if ((r917 & 268435456) == 0) goto L245;
        String r160 = r210.shareGroupInfo;
    L246:
        String r825 = r160;
        if ((r917 & 536870912) == 0) goto L249;
        String r161 = r210.pdpFrequencyControl;
    L250:
        String r826 = r161;
        if ((r917 & 1073741824) == 0) goto L253;
        String r162 = r210.sourceBtmToken;
    L255:
        if ((r917 & Integer.MIN_VALUE) == 0) goto L257;
        boolean r163 = r210.autoBuyNow;
    L258:
        boolean r827 = r163;
        if ((r918 & 1) == 0) goto L261;
        boolean r164 = r210.autoAddToCart;
    L262:
        boolean r828 = r164;
        if ((r918 & 2) == 0) goto L265;
        String r165 = r210.skuId;
    L266:
        String r920 = r165;
        if ((r918 & 4) == 0) goto L269;
        Float r166 = r210.halfHeadScale;
    L270:
        Float r921 = r166;
        if ((r918 & 8) == 0) goto L273;
        Integer r167 = r210.halfHeadSpace;
    L274:
        Integer r922 = r167;
        if ((r918 & 16) == 0) goto L277;
        boolean r168 = r210.isInSplit;
    L278:
        boolean r923 = r168;
        if ((r918 & 32) == 0) goto L281;
        String r169 = r210.splitScene;
    L282:
        String r924 = r169;
        if ((r918 & 64) == 0) goto L285;
        boolean r170 = r210.isOptSplit;
    L287:
        return r210.copy(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r320, r321, r322, r420, r421, r422, r423, r424, r425, r426, r427, r428, r429, r520, r521, r522, r523, r524, r133, r525, r526, r527, r528, r620, r621, r622, r623, r624, r625, r626, r627, r628, r629, r720, r721, r722, r723, r724, r725, r726, r727, r728, r729, r820, r821, r822, r823, r824, r825, r826, r162, r827, r828, r920, r921, r922, r923, r924, r170);
    L285:
        r170 = r915;
        goto L287
    L281:
        r169 = r914;
        goto L282
    L277:
        r168 = r913;
        goto L278
    L273:
        r167 = r912;
        goto L274
    L269:
        r166 = r911;
        goto L270
    L265:
        r165 = r910;
        goto L266
    L261:
        r164 = r819;
        goto L262
    L257:
        r163 = r818;
        goto L258
    L253:
        r162 = r817;
        goto L255
    L249:
        r161 = r816;
        goto L250
    L245:
        r160 = r815;
        goto L246
    L241:
        r159 = r814;
        goto L242
    L237:
        r158 = r813;
        goto L238
    L233:
        r157 = r812;
        goto L234
    L229:
        r156 = r811;
        goto L230
    L225:
        r155 = r810;
        goto L226
    L221:
        r154 = r719;
        goto L222
    L217:
        r153 = r718;
        goto L218
    L213:
        r152 = r717;
        goto L214
    L209:
        r151 = r716;
        goto L210
    L205:
        r150 = r715;
        goto L206
    L201:
        r149 = r714;
        goto L202
    L197:
        r148 = r713;
        goto L198
    L193:
        r147 = r712;
        goto L194
    L189:
        r146 = r711;
        goto L190
    L185:
        r145 = r710;
        goto L186
    L181:
        r144 = r619;
        goto L182
    L177:
        r143 = r618;
        goto L178
    L173:
        r142 = r617;
        goto L174
    L169:
        r141 = r616;
        goto L170
    L165:
        r140 = r615;
        goto L166
    L161:
        r139 = r614;
        goto L162
    L157:
        r138 = r613;
        goto L158
    L153:
        r137 = r612;
        goto L154
    L149:
        r136 = r611;
        goto L150
    L145:
        r135 = r610;
        goto L146
    L141:
        r134 = r519;
        goto L142
    L137:
        r109 = r518;
        goto L138
    L133:
        r108 = r517;
        goto L134
    L129:
        r107 = r516;
        goto L130
    L125:
        r133 = r515;
        goto L127
    L121:
        r132 = r514;
        goto L122
    L117:
        r131 = r513;
        goto L118
    L113:
        r130 = r512;
        goto L114
    L109:
        r129 = r511;
        goto L110
    L105:
        r128 = r510;
        goto L106
    L101:
        r127 = r419;
        goto L102
    L97:
        r126 = r418;
        goto L98
    L93:
        r125 = r417;
        goto L94
    L89:
        r124 = r416;
        goto L90
    L85:
        r123 = r415;
        goto L86
    L81:
        r122 = r414;
        goto L82
    L77:
        r121 = r413;
        goto L78
    L73:
        r120 = r412;
        goto L74
    L69:
        r119 = r411;
        goto L70
    L65:
        r118 = r410;
        goto L66
    L61:
        r117 = r319;
        goto L62
    L57:
        r116 = r318;
        goto L58
    L53:
        r115 = r317;
        goto L54
    L49:
        r114 = r316;
        goto L51
    L45:
        r113 = r315;
        goto L47
    L41:
        r112 = r314;
        goto L43
    L37:
        r111 = r313;
        goto L39
    L33:
        r110 = r312;
        goto L35
    L29:
        r106 = r311;
        goto L31
    L25:
        r105 = r310;
        goto L27
    L21:
        r104 = r215;
        goto L23
    L17:
        r103 = r214;
        goto L19
    L13:
        r102 = r213;
        goto L15
    L9:
        r101 = r212;
        goto L11
    L5:
        r100 = r211;
        goto L7
    }

    public final String component1() {
        return this.promotionId;
    }

    public final String component10() {
        return this.entranceInfo;
    }

    public final boolean component11() {
        return this.fullMode;
    }

    public final int component12() {
        return this.showSkuPanel;
    }

    public final boolean component13() {
        return this.isLuban;
    }

    public final String component14() {
        return this.pageId;
    }

    public final String component15() {
        return this.sourcePage;
    }

    public final String component16() {
        return this.enterMethod;
    }

    public final String component17() {
        return this.eComEntranceForm;
    }

    public final String component18() {
        return this.v3EventsAdditions;
    }

    public final String component19() {
        return this.whichAccount;
    }

    public final String component2() {
        return this.productId;
    }

    public final String component20() {
        return this.recommendInfo;
    }

    public final String component21() {
        return this.requestId;
    }

    public final String component22() {
        return this.productSourcePage;
    }

    public final String component23() {
        return this.moduleLabel;
    }

    public final String component24() {
        return this.labelNameFromLive;
    }

    public final String component25() {
        return this.labelNameLive;
    }

    public final String component26() {
        return this.baseVerifiedCategory;
    }

    public final String component27() {
        return this.transitionTrackerData;
    }

    public final String component28() {
        return this.threeDLogData;
    }

    public final String component29() {
        return this.requestAdditions;
    }

    public final String component3() {
        return this.normalSkuId;
    }

    public final String component30() {
        return this.actionType;
    }

    public final String component31() {
        return this.iconType;
    }

    public final String component32() {
        return this.liveRoomId;
    }

    public final boolean component33() {
        return this.fromVideo;
    }

    public final boolean component34() {
        return this.fromLive;
    }

    public final String component35() {
        return this.searchId;
    }

    public final String component36() {
        return this.sourceMethod;
    }

    public final String component37() {
        return this.carrierSource;
    }

    public final int component38() {
        return this.goodsDetailVersion;
    }

    public final boolean component39() {
        return this.largeFontMode;
    }

    public final String component4() {
        return this.selectedIds;
    }

    public final float component40() {
        return this.fontScale;
    }

    public final String component41() {
        return this.clientAbsJStr;
    }

    public final boolean component42() {
        return this.isMcpScene;
    }

    public final String component43() {
        return this.clientStorageJStr;
    }

    public final boolean component44() {
        return this.isShortScreen;
    }

    public final boolean component45() {
        return this.isWindowRepositionEnable;
    }

    public final int component46() {
        return this.usefulScreenWidth;
    }

    public final int component47() {
        return this.usefulScreenHeight;
    }

    public final boolean component48() {
        return this.isRecommendEnable;
    }

    public final boolean component49() {
        return this.bffSnapshotSwitch;
    }

    public final String component5() {
        return this.skuSwitch;
    }

    public final String component50() {
        return this.pdpSessionId;
    }

    public final Float component51() {
        return this.mainPicScale;
    }

    public final String component52() {
        return this.coverImage;
    }

    public final String component53() {
        return this.productPreInfo;
    }

    public final String component54() {
        return this.channelId;
    }

    public final Integer component55() {
        return this.channelType;
    }

    public final Integer component56() {
        return this.panelHeightPercent;
    }

    public final String component57() {
        return this.isAuth;
    }

    public final String component58() {
        return this.headerConfig;
    }

    public final Integer component59() {
        return this.shopRecommendTabIndex;
    }

    public final String component6() {
        return this.isExpanded;
    }

    public final String component60() {
        return this.nativeControlFlags;
    }

    public final String component61() {
        return this.shareGroupInfo;
    }

    public final String component62() {
        return this.pdpFrequencyControl;
    }

    public final String component63() {
        return this.sourceBtmToken;
    }

    public final boolean component64() {
        return this.autoBuyNow;
    }

    public final boolean component65() {
        return this.autoAddToCart;
    }

    public final String component66() {
        return this.skuId;
    }

    public final Float component67() {
        return this.halfHeadScale;
    }

    public final Integer component68() {
        return this.halfHeadSpace;
    }

    public final boolean component69() {
        return this.isInSplit;
    }

    public final Integer component7() {
        return this.followStatus;
    }

    public final String component70() {
        return this.splitScene;
    }

    public final boolean component71() {
        return this.isOptSplit;
    }

    public final String component8() {
        return this.adLogExtraJStr;
    }

    public final String component9() {
        return this.boldParamJStr;
    }

    public final V4ServerParams copy(String r710, String r711, String r712, String r713, String r714, String r715, Integer r810, String r811, String r812, String r813, boolean r814, int r815, boolean r816, String r817, String r818, String r819, String r910, String r911, String r912, String r913, String r914, String r915, String r916, String r917, String r918, String r919, String r100, String r101, String r102, String r103, String r104, String r105, boolean r106, boolean r107, String r108, String r109, String r110, int r111, boolean r112, float r113, String r114, boolean r115, String r116, boolean r117, boolean r118, int r119, int r120, boolean r121, boolean r122, String r123, Float r124, String r125, String r126, String r127, Integer r128, Integer r129, String r130, String r131, Integer r132, String r133, String r134, String r135, String r136, boolean r137, boolean r138, String r139, Float r140, Integer r141, boolean r142, String r143, boolean r144) {
        Intrinsics.checkNotNullParameter(r714, "skuSwitch");
        Intrinsics.checkNotNullParameter(r715, "isExpanded");
        return new V4ServerParams(r710, r711, r712, r713, r714, r715, r810, r811, r812, r813, r814, r815, r816, r817, r818, r819, r910, r911, r912, r913, r914, r915, r916, r917, r918, r919, r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144);
    }

    public String toString() {
        return "V4ServerParams(promotionId=" + this.promotionId + ", productId=" + this.productId + ", normalSkuId=" + this.normalSkuId + ", selectedIds=" + this.selectedIds + ", skuSwitch=" + this.skuSwitch + ", isExpanded=" + this.isExpanded + ", followStatus=" + this.followStatus + ", adLogExtraJStr=" + this.adLogExtraJStr + ", boldParamJStr=" + this.boldParamJStr + ", entranceInfo=" + this.entranceInfo + ", fullMode=" + this.fullMode + ", showSkuPanel=" + this.showSkuPanel + ", isLuban=" + this.isLuban + ", pageId=" + this.pageId + ", sourcePage=" + this.sourcePage + ", enterMethod=" + this.enterMethod + ", eComEntranceForm=" + this.eComEntranceForm + ", v3EventsAdditions=" + this.v3EventsAdditions + ", whichAccount=" + this.whichAccount + ", recommendInfo=" + this.recommendInfo + ", requestId=" + this.requestId + ", productSourcePage=" + this.productSourcePage + ", moduleLabel=" + this.moduleLabel + ", labelNameFromLive=" + this.labelNameFromLive + ", labelNameLive=" + this.labelNameLive + ", baseVerifiedCategory=" + this.baseVerifiedCategory + ", transitionTrackerData=" + this.transitionTrackerData + ", threeDLogData=" + this.threeDLogData + ", requestAdditions=" + this.requestAdditions + ", actionType=" + this.actionType + ", iconType=" + this.iconType + ", liveRoomId=" + this.liveRoomId + ", fromVideo=" + this.fromVideo + ", fromLive=" + this.fromLive + ", searchId=" + this.searchId + ", sourceMethod=" + this.sourceMethod + ", carrierSource=" + this.carrierSource + ", goodsDetailVersion=" + this.goodsDetailVersion + ", largeFontMode=" + this.largeFontMode + ", fontScale=" + this.fontScale + ", clientAbsJStr=" + this.clientAbsJStr + ", isMcpScene=" + this.isMcpScene + ", clientStorageJStr=" + this.clientStorageJStr + ", isShortScreen=" + this.isShortScreen + ", isWindowRepositionEnable=" + this.isWindowRepositionEnable + ", usefulScreenWidth=" + this.usefulScreenWidth + ", usefulScreenHeight=" + this.usefulScreenHeight + ", isRecommendEnable=" + this.isRecommendEnable + ", bffSnapshotSwitch=" + this.bffSnapshotSwitch + ", pdpSessionId=" + this.pdpSessionId + ", mainPicScale=" + this.mainPicScale + ", coverImage=" + this.coverImage + ", productPreInfo=" + this.productPreInfo + ", channelId=" + this.channelId + ", channelType=" + this.channelType + ", panelHeightPercent=" + this.panelHeightPercent + ", isAuth=" + this.isAuth + ", headerConfig=" + this.headerConfig + ", shopRecommendTabIndex=" + this.shopRecommendTabIndex + ", nativeControlFlags=" + this.nativeControlFlags + ", shareGroupInfo=" + this.shareGroupInfo + ", pdpFrequencyControl=" + this.pdpFrequencyControl + ", sourceBtmToken=" + this.sourceBtmToken + ", autoBuyNow=" + this.autoBuyNow + ", autoAddToCart=" + this.autoAddToCart + ", skuId=" + this.skuId + ", halfHeadScale=" + this.halfHeadScale + ", halfHeadSpace=" + this.halfHeadSpace + ", isInSplit=" + this.isInSplit + ", splitScene=" + this.splitScene + ", isOptSplit=" + this.isOptSplit + ")";
    }

    public int hashCode() {
        String r100 = this.promotionId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.productId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.followStatus;
        if (r107 == null) goto L13;
        int r108 = r107.intValue();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.adLogExtraJStr;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.boldParamJStr;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.entranceInfo;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (((((((r115 + r117) * 31) + a(this.fullMode)) * 31) + this.showSkuPanel) * 31) + a(this.isLuban)) * 31;
        String r119 = this.pageId;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.sourcePage;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.enterMethod;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.eComEntranceForm;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.v3EventsAdditions;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.whichAccount;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.recommendInfo;
        if (r137 == null) goto L53;
        int r138 = r137.hashCode();
    L54:
        int r139 = (r136 + r138) * 31;
        String r140 = this.requestId;
        if (r140 == null) goto L57;
        int r141 = r140.hashCode();
    L58:
        int r142 = (r139 + r141) * 31;
        String r143 = this.productSourcePage;
        if (r143 == null) goto L61;
        int r144 = r143.hashCode();
    L62:
        int r145 = (r142 + r144) * 31;
        String r146 = this.moduleLabel;
        if (r146 == null) goto L65;
        int r147 = r146.hashCode();
    L66:
        int r148 = (r145 + r147) * 31;
        String r149 = this.labelNameFromLive;
        if (r149 == null) goto L69;
        int r150 = r149.hashCode();
    L70:
        int r151 = (r148 + r150) * 31;
        String r152 = this.labelNameLive;
        if (r152 == null) goto L73;
        int r153 = r152.hashCode();
    L74:
        int r154 = (r151 + r153) * 31;
        String r155 = this.baseVerifiedCategory;
        if (r155 == null) goto L77;
        int r156 = r155.hashCode();
    L78:
        int r157 = (r154 + r156) * 31;
        String r158 = this.transitionTrackerData;
        if (r158 == null) goto L81;
        int r159 = r158.hashCode();
    L82:
        int r160 = (r157 + r159) * 31;
        String r161 = this.threeDLogData;
        if (r161 == null) goto L85;
        int r162 = r161.hashCode();
    L86:
        int r163 = (r160 + r162) * 31;
        String r164 = this.requestAdditions;
        if (r164 == null) goto L89;
        int r165 = r164.hashCode();
    L90:
        int r166 = (r163 + r165) * 31;
        String r167 = this.actionType;
        if (r167 == null) goto L93;
        int r168 = r167.hashCode();
    L94:
        int r169 = (r166 + r168) * 31;
        String r170 = this.iconType;
        if (r170 == null) goto L97;
        int r171 = r170.hashCode();
    L98:
        int r172 = (r169 + r171) * 31;
        String r173 = this.liveRoomId;
        if (r173 == null) goto L101;
        int r174 = r173.hashCode();
    L102:
        int r175 = (((((r172 + r174) * 31) + a(this.fromVideo)) * 31) + a(this.fromLive)) * 31;
        String r176 = this.searchId;
        if (r176 == null) goto L105;
        int r177 = r176.hashCode();
    L106:
        int r178 = (r175 + r177) * 31;
        String r179 = this.sourceMethod;
        if (r179 == null) goto L109;
        int r180 = r179.hashCode();
    L110:
        int r181 = (r178 + r180) * 31;
        String r182 = this.carrierSource;
        if (r182 == null) goto L113;
        int r183 = r182.hashCode();
    L114:
        int r184 = (((((((r181 + r183) * 31) + this.goodsDetailVersion) * 31) + a(this.largeFontMode)) * 31) + Float.floatToIntBits(this.fontScale)) * 31;
        String r185 = this.clientAbsJStr;
        if (r185 == null) goto L117;
        int r186 = r185.hashCode();
    L118:
        int r187 = (((r184 + r186) * 31) + a(this.isMcpScene)) * 31;
        String r188 = this.clientStorageJStr;
        if (r188 == null) goto L121;
        int r189 = r188.hashCode();
    L122:
        int r190 = (((((r187 + r189) * 31) + this.usefulScreenWidth) * 31) + a(this.isRecommendEnable)) * 31;
        String r191 = this.channelId;
        if (r191 == null) goto L125;
        int r192 = r191.hashCode();
    L126:
        int r193 = (r190 + r192) * 31;
        Integer r194 = this.channelType;
        if (r194 == null) goto L129;
        int r195 = r194.intValue();
    L130:
        int r196 = (r193 + r195) * 31;
        String r197 = this.sourceBtmToken;
        if (r197 == null) goto L133;
        int r198 = r197.hashCode();
    L134:
        int r199 = (((((r196 + r198) * 31) + a(this.autoBuyNow)) * 31) + a(this.autoAddToCart)) * 31;
        String r200 = this.skuId;
        if (r200 == null) goto L138;
        r101 = r200.hashCode();
    L138:
        return r199 + r101;
    L133:
        r198 = 0;
        goto L134
    L129:
        r195 = 0;
        goto L130
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

    public final String getActionType() {
        return this.actionType;
    }

    public final String getAdLogExtraJStr() {
        return this.adLogExtraJStr;
    }

    public final boolean getAutoAddToCart() {
        return this.autoAddToCart;
    }

    public final boolean getAutoBuyNow() {
        return this.autoBuyNow;
    }

    public final String getBaseVerifiedCategory() {
        return this.baseVerifiedCategory;
    }

    public final boolean getBffSnapshotSwitch() {
        return this.bffSnapshotSwitch;
    }

    public final String getBoldParamJStr() {
        return this.boldParamJStr;
    }

    public final String getCarrierSource() {
        return this.carrierSource;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final Integer getChannelType() {
        return this.channelType;
    }

    public final String getClientAbsJStr() {
        return this.clientAbsJStr;
    }

    public final String getClientStorageJStr() {
        return this.clientStorageJStr;
    }

    public final String getCoverImage() {
        return this.coverImage;
    }

    public final String getEComEntranceForm() {
        return this.eComEntranceForm;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final String getEntranceInfo() {
        return this.entranceInfo;
    }

    public final Integer getFollowStatus() {
        return this.followStatus;
    }

    public final float getFontScale() {
        return this.fontScale;
    }

    public final boolean getFromLive() {
        return this.fromLive;
    }

    public final boolean getFromVideo() {
        return this.fromVideo;
    }

    public final boolean getFullMode() {
        return this.fullMode;
    }

    public final int getGoodsDetailVersion() {
        return this.goodsDetailVersion;
    }

    public final Float getHalfHeadScale() {
        return this.halfHeadScale;
    }

    public final Integer getHalfHeadSpace() {
        return this.halfHeadSpace;
    }

    public final String getHeaderConfig() {
        return this.headerConfig;
    }

    public final String getIconType() {
        return this.iconType;
    }

    public final String getLabelNameFromLive() {
        return this.labelNameFromLive;
    }

    public final String getLabelNameLive() {
        return this.labelNameLive;
    }

    public final boolean getLargeFontMode() {
        return this.largeFontMode;
    }

    public final String getLiveRoomId() {
        return this.liveRoomId;
    }

    public final Float getMainPicScale() {
        return this.mainPicScale;
    }

    public final String getModuleLabel() {
        return this.moduleLabel;
    }

    public final String getNativeControlFlags() {
        return this.nativeControlFlags;
    }

    public final String getNormalSkuId() {
        return this.normalSkuId;
    }

    public final String getPageId() {
        return this.pageId;
    }

    public final Integer getPanelHeightPercent() {
        return this.panelHeightPercent;
    }

    public final String getPdpFrequencyControl() {
        return this.pdpFrequencyControl;
    }

    public final String getPdpSessionId() {
        return this.pdpSessionId;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getProductPreInfo() {
        return this.productPreInfo;
    }

    public final String getProductSourcePage() {
        return this.productSourcePage;
    }

    public final String getPromotionId() {
        return this.promotionId;
    }

    public final String getRecommendInfo() {
        return this.recommendInfo;
    }

    public final String getRequestAdditions() {
        return this.requestAdditions;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final String getSearchId() {
        return this.searchId;
    }

    public final String getSelectedIds() {
        return this.selectedIds;
    }

    public final String getShareGroupInfo() {
        return this.shareGroupInfo;
    }

    public final Integer getShopRecommendTabIndex() {
        return this.shopRecommendTabIndex;
    }

    public final int getShowSkuPanel() {
        return this.showSkuPanel;
    }

    public final String getSkuId() {
        return this.skuId;
    }

    public final String getSkuSwitch() {
        return this.skuSwitch;
    }

    public final String getSourceBtmToken() {
        return this.sourceBtmToken;
    }

    public final String getSourceMethod() {
        return this.sourceMethod;
    }

    public final String getSourcePage() {
        return this.sourcePage;
    }

    public final String getSplitScene() {
        return this.splitScene;
    }

    public final String getThreeDLogData() {
        return this.threeDLogData;
    }

    public final String getTransitionTrackerData() {
        return this.transitionTrackerData;
    }

    public final int getUsefulScreenHeight() {
        return this.usefulScreenHeight;
    }

    public final int getUsefulScreenWidth() {
        return this.usefulScreenWidth;
    }

    public final String getV3EventsAdditions() {
        return this.v3EventsAdditions;
    }

    public final String getWhichAccount() {
        return this.whichAccount;
    }

    public final String isAuth() {
        return this.isAuth;
    }

    public final String isExpanded() {
        return this.isExpanded;
    }

    public final boolean isInSplit() {
        return this.isInSplit;
    }

    public final boolean isLuban() {
        return this.isLuban;
    }

    public final boolean isMcpScene() {
        return this.isMcpScene;
    }

    public final boolean isOptSplit() {
        return this.isOptSplit;
    }

    public final boolean isRecommendEnable() {
        return this.isRecommendEnable;
    }

    public final boolean isShortScreen() {
        return this.isShortScreen;
    }

    public final boolean isWindowRepositionEnable() {
        return this.isWindowRepositionEnable;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(V4ServerParams.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L159;
        V4ServerParams r102 = (V4ServerParams) r100;
        if ((!Intrinsics.areEqual(this.promotionId, r102.promotionId)) == false) goto L17;
        return false;
    L17:
        if ((!Intrinsics.areEqual(this.productId, r102.productId)) == false) goto L20;
        return false;
    L20:
        if ((!Intrinsics.areEqual(this.followStatus, r102.followStatus)) == false) goto L23;
        return false;
    L23:
        if ((!Intrinsics.areEqual(this.adLogExtraJStr, r102.adLogExtraJStr)) == false) goto L26;
        return false;
    L26:
        if ((!Intrinsics.areEqual(this.boldParamJStr, r102.boldParamJStr)) == false) goto L29;
        return false;
    L29:
        if ((!Intrinsics.areEqual(this.entranceInfo, r102.entranceInfo)) == false) goto L32;
        return false;
    L32:
        if (this.fullMode == r102.fullMode) goto L35;
        return false;
    L35:
        if (this.showSkuPanel == r102.showSkuPanel) goto L38;
        return false;
    L38:
        if (this.isLuban == r102.isLuban) goto L41;
        return false;
    L41:
        if ((!Intrinsics.areEqual(this.pageId, r102.pageId)) == false) goto L44;
        return false;
    L44:
        if ((!Intrinsics.areEqual(this.sourcePage, r102.sourcePage)) == false) goto L47;
        return false;
    L47:
        if ((!Intrinsics.areEqual(this.enterMethod, r102.enterMethod)) == false) goto L50;
        return false;
    L50:
        if ((!Intrinsics.areEqual(this.eComEntranceForm, r102.eComEntranceForm)) == false) goto L53;
        return false;
    L53:
        if ((!Intrinsics.areEqual(this.v3EventsAdditions, r102.v3EventsAdditions)) == false) goto L56;
        return false;
    L56:
        if ((!Intrinsics.areEqual(this.whichAccount, r102.whichAccount)) == false) goto L59;
        return false;
    L59:
        if ((!Intrinsics.areEqual(this.recommendInfo, r102.recommendInfo)) == false) goto L62;
        return false;
    L62:
        if ((!Intrinsics.areEqual(this.requestId, r102.requestId)) == false) goto L65;
        return false;
    L65:
        if ((!Intrinsics.areEqual(this.productSourcePage, r102.productSourcePage)) == false) goto L68;
        return false;
    L68:
        if ((!Intrinsics.areEqual(this.moduleLabel, r102.moduleLabel)) == false) goto L71;
        return false;
    L71:
        if ((!Intrinsics.areEqual(this.labelNameFromLive, r102.labelNameFromLive)) == false) goto L74;
        return false;
    L74:
        if ((!Intrinsics.areEqual(this.labelNameLive, r102.labelNameLive)) == false) goto L77;
        return false;
    L77:
        if ((!Intrinsics.areEqual(this.baseVerifiedCategory, r102.baseVerifiedCategory)) == false) goto L80;
        return false;
    L80:
        if ((!Intrinsics.areEqual(this.transitionTrackerData, r102.transitionTrackerData)) == false) goto L83;
        return false;
    L83:
        if ((!Intrinsics.areEqual(this.threeDLogData, r102.threeDLogData)) == false) goto L86;
        return false;
    L86:
        if ((!Intrinsics.areEqual(this.requestAdditions, r102.requestAdditions)) == false) goto L89;
        return false;
    L89:
        if ((!Intrinsics.areEqual(this.actionType, r102.actionType)) == false) goto L92;
        return false;
    L92:
        if ((!Intrinsics.areEqual(this.iconType, r102.iconType)) == false) goto L95;
        return false;
    L95:
        if ((!Intrinsics.areEqual(this.liveRoomId, r102.liveRoomId)) == false) goto L98;
        return false;
    L98:
        if (this.fromVideo == r102.fromVideo) goto L101;
        return false;
    L101:
        if (this.fromLive == r102.fromLive) goto L104;
        return false;
    L104:
        if ((!Intrinsics.areEqual(this.searchId, r102.searchId)) == false) goto L107;
        return false;
    L107:
        if ((!Intrinsics.areEqual(this.sourceMethod, r102.sourceMethod)) == false) goto L110;
        return false;
    L110:
        if ((!Intrinsics.areEqual(this.carrierSource, r102.carrierSource)) == false) goto L113;
        return false;
    L113:
        if (this.goodsDetailVersion == r102.goodsDetailVersion) goto L116;
        return false;
    L116:
        if (this.largeFontMode == r102.largeFontMode) goto L119;
        return false;
    L119:
        if (this.fontScale == r102.fontScale) goto L122;
        return false;
    L122:
        if ((!Intrinsics.areEqual(this.clientAbsJStr, r102.clientAbsJStr)) == false) goto L125;
        return false;
    L125:
        if (this.isMcpScene == r102.isMcpScene) goto L128;
        return false;
    L128:
        if ((!Intrinsics.areEqual(this.clientStorageJStr, r102.clientStorageJStr)) == false) goto L131;
        return false;
    L131:
        if (this.isShortScreen == r102.isShortScreen) goto L134;
        return false;
    L134:
        if (this.usefulScreenWidth == r102.usefulScreenWidth) goto L137;
        return false;
    L137:
        if (this.isRecommendEnable == r102.isRecommendEnable) goto L140;
        return false;
    L140:
        if ((!Intrinsics.areEqual(this.channelId, r102.channelId)) == false) goto L143;
        return false;
    L143:
        if ((!Intrinsics.areEqual(this.channelType, r102.channelType)) == false) goto L146;
        return false;
    L146:
        if ((!Intrinsics.areEqual(this.sourceBtmToken, r102.sourceBtmToken)) == false) goto L149;
        return false;
    L149:
        if (this.autoBuyNow == r102.autoBuyNow) goto L152;
        return false;
    L152:
        if (this.autoAddToCart == r102.autoAddToCart) goto L155;
        return false;
    L155:
        if ((!Intrinsics.areEqual(this.skuId, r102.skuId)) == false) goto L157;
        return false;
    L157:
        return true;
    L159:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.params.V4ServerParams");
    L8:
        r101 = null;
        goto L10
    }

    public final void setAdLogExtraJStr(String r100) {
        this.adLogExtraJStr = r100;
    }

    public final void setAuth(String r100) {
        this.isAuth = r100;
    }

    public final void setClientStorageJStr(String r100) {
        this.clientStorageJStr = r100;
    }

    public final void setExpanded(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.isExpanded = r100;
    }

    public final void setFullMode(boolean r100) {
        this.fullMode = r100;
    }

    public final void setHalfHeadScale(Float r100) {
        this.halfHeadScale = r100;
    }

    public final void setHalfHeadSpace(Integer r100) {
        this.halfHeadSpace = r100;
    }

    public final void setInSplit(boolean r100) {
        this.isInSplit = r100;
    }

    public final void setModuleLabel(String r100) {
        this.moduleLabel = r100;
    }

    public final void setNormalSkuId(String r100) {
        this.normalSkuId = r100;
    }

    public final void setProductSourcePage(String r100) {
        this.productSourcePage = r100;
    }

    public final void setSelectedIds(String r100) {
        this.selectedIds = r100;
    }

    public final void setShopRecommendTabIndex(Integer r100) {
        this.shopRecommendTabIndex = r100;
    }

    public final void setSkuSwitch(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.skuSwitch = r100;
    }

    public V4ServerParams(String r100, String r101, String r102, String r103, String r104, String r110, Integer r111, String r112, String r113, String r114, boolean r115, int r116, boolean r117, String r118, String r119, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, String r310, String r311, String r312, String r313, String r314, String r315, String r316, boolean r317, boolean r318, String r319, String r410, String r411, int r412, boolean r413, float r414, String r415, boolean r416, String r417, boolean r418, boolean r419, int r510, int r511, boolean r512, boolean r513, String r514, Float r515, String r516, String r517, String r518, Integer r519, Integer r610, String r611, String r612, Integer r613, String r614, String r615, String r616, String r617, boolean r618, boolean r619, String r710, Float r711, Integer r712, boolean r713, String r714, boolean r715) {
        Intrinsics.checkNotNullParameter(r104, "skuSwitch");
        Intrinsics.checkNotNullParameter(r110, "isExpanded");
        this.promotionId = r100;
        this.productId = r101;
        this.normalSkuId = r102;
        this.selectedIds = r103;
        this.skuSwitch = r104;
        this.isExpanded = r110;
        this.followStatus = r111;
        this.adLogExtraJStr = r112;
        this.boldParamJStr = r113;
        this.entranceInfo = r114;
        this.fullMode = r115;
        this.showSkuPanel = r116;
        this.isLuban = r117;
        this.pageId = r118;
        this.sourcePage = r119;
        this.enterMethod = r210;
        this.eComEntranceForm = r211;
        this.v3EventsAdditions = r212;
        this.whichAccount = r213;
        this.recommendInfo = r214;
        this.requestId = r215;
        this.productSourcePage = r216;
        this.moduleLabel = r217;
        this.labelNameFromLive = r218;
        this.labelNameLive = r219;
        this.baseVerifiedCategory = r310;
        this.transitionTrackerData = r311;
        this.threeDLogData = r312;
        this.requestAdditions = r313;
        this.actionType = r314;
        this.iconType = r315;
        this.liveRoomId = r316;
        this.fromVideo = r317;
        this.fromLive = r318;
        this.searchId = r319;
        this.sourceMethod = r410;
        this.carrierSource = r411;
        this.goodsDetailVersion = r412;
        this.largeFontMode = r413;
        this.fontScale = r414;
        this.clientAbsJStr = r415;
        this.isMcpScene = r416;
        this.clientStorageJStr = r417;
        this.isShortScreen = r418;
        this.isWindowRepositionEnable = r419;
        this.usefulScreenWidth = r510;
        this.usefulScreenHeight = r511;
        this.isRecommendEnable = r512;
        this.bffSnapshotSwitch = r513;
        this.pdpSessionId = r514;
        this.mainPicScale = r515;
        this.coverImage = r516;
        this.productPreInfo = r517;
        this.channelId = r518;
        this.channelType = r519;
        this.panelHeightPercent = r610;
        this.isAuth = r611;
        this.headerConfig = r612;
        this.shopRecommendTabIndex = r613;
        this.nativeControlFlags = r614;
        this.shareGroupInfo = r615;
        this.pdpFrequencyControl = r616;
        this.sourceBtmToken = r617;
        this.autoBuyNow = r618;
        this.autoAddToCart = r619;
        this.skuId = r710;
        this.halfHeadScale = r711;
        this.halfHeadSpace = r712;
        this.isInSplit = r713;
        this.splitScene = r714;
        this.isOptSplit = r715;
    }

    public /* synthetic */ V4ServerParams(String r710, String r711, String r712, String r713, String r714, String r715, Integer r716, String r717, String r810, String r811, boolean r812, int r813, boolean r814, String r815, String r816, String r817, String r818, String r819, String r910, String r911, String r912, String r913, String r914, String r915, String r916, String r917, String r918, String r919, String r100, String r101, String r102, String r103, boolean r104, boolean r105, String r106, String r107, String r108, int r109, boolean r110, float r111, String r112, boolean r113, String r114, boolean r115, boolean r116, int r117, int r118, boolean r119, boolean r120, String r121, Float r122, String r123, String r124, String r125, Integer r126, Integer r127, String r128, String r129, Integer r130, String r131, String r132, String r133, String r134, boolean r135, boolean r136, String r137, Float r138, Integer r139, boolean r140, String r141, boolean r142, int r143, int r144, int r145, DefaultConstructorMarker r146) {
        if ((r143 & 1) == 0) goto L5;
        String r147 = null;
    L7:
        if ((r143 & 2) == 0) goto L9;
        String r148 = null;
    L11:
        if ((r143 & 4) == 0) goto L13;
        String r149 = null;
    L15:
        if ((r143 & 8) == 0) goto L17;
        String r150 = null;
    L18:
        String r151 = "0";
        if ((r143 & 16) == 0) goto L21;
        String r152 = "0";
    L23:
        if ((r143 & 32) != 0) goto L27;
        r151 = r715;
    L27:
        if ((r143 & 64) == 0) goto L29;
        Integer r153 = null;
    L31:
        if ((r143 & 128) == 0) goto L33;
        String r154 = null;
    L35:
        if ((r143 & 256) == 0) goto L37;
        String r155 = null;
    L39:
        if ((r143 & 512) == 0) goto L41;
        String r156 = null;
    L43:
        if ((r143 & 1024) == 0) goto L45;
        boolean r157 = false;
    L47:
        if ((r143 & 2048) == 0) goto L49;
        int r158 = 0;
    L51:
        if ((r143 & 4096) == 0) goto L53;
        boolean r159 = false;
    L55:
        if ((r143 & 8192) == 0) goto L57;
        String r160 = null;
    L58:
        String r161 = r160;
        if ((r143 & 16384) == 0) goto L61;
        String r162 = null;
    L63:
        if ((r143 & 32768) == 0) goto L65;
        String r163 = null;
    L67:
        if ((r143 & 65536) == 0) goto L69;
        String r210 = null;
    L71:
        if ((r143 & 131072) == 0) goto L73;
        String r211 = null;
    L75:
        if ((r143 & 262144) == 0) goto L77;
        String r212 = null;
    L79:
        if ((r143 & 524288) == 0) goto L81;
        String r213 = null;
    L83:
        if ((r143 & 1048576) == 0) goto L85;
        String r214 = null;
    L87:
        if ((r143 & 2097152) == 0) goto L89;
        String r215 = null;
    L91:
        if ((r143 & 4194304) == 0) goto L93;
        String r216 = null;
    L95:
        if ((r143 & 8388608) == 0) goto L97;
        String r217 = null;
    L99:
        if ((r143 & 16777216) == 0) goto L101;
        String r310 = null;
    L103:
        if ((r143 & 33554432) == 0) goto L105;
        String r311 = null;
    L107:
        if ((r143 & 67108864) == 0) goto L109;
        String r312 = null;
    L111:
        if ((r143 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        String r313 = null;
    L115:
        if ((r143 & 268435456) == 0) goto L117;
        String r314 = null;
    L119:
        if ((r143 & 536870912) == 0) goto L121;
        String r315 = null;
    L123:
        if ((r143 & 1073741824) == 0) goto L125;
        String r316 = null;
    L127:
        if ((r143 & Integer.MIN_VALUE) == 0) goto L129;
        String r164 = null;
    L131:
        if ((r144 & 1) == 0) goto L133;
        boolean r317 = false;
    L135:
        if ((r144 & 2) == 0) goto L137;
        boolean r318 = false;
    L139:
        if ((r144 & 4) == 0) goto L141;
        String r319 = null;
    L143:
        if ((r144 & 8) == 0) goto L145;
        String r410 = null;
    L147:
        if ((r144 & 16) == 0) goto L149;
        String r411 = null;
    L151:
        if ((r144 & 32) == 0) goto L153;
        int r412 = 0;
    L155:
        if ((r144 & 64) == 0) goto L157;
        boolean r413 = false;
    L158:
        String r1410 = r164;
        if ((r144 & 128) == 0) goto L161;
        float r165 = 1.0f;
    L162:
        float r414 = r165;
        if ((r144 & 256) == 0) goto L165;
        String r166 = null;
    L166:
        String r415 = r166;
        if ((r144 & 512) == 0) goto L169;
        boolean r167 = false;
    L170:
        boolean r416 = r167;
        if ((r144 & 1024) == 0) goto L173;
        String r168 = null;
    L174:
        String r417 = r168;
        if ((r144 & 2048) == 0) goto L177;
        boolean r169 = false;
    L178:
        boolean r418 = r169;
        if ((r144 & 4096) == 0) goto L181;
        boolean r170 = false;
    L182:
        boolean r419 = r170;
        if ((r144 & 8192) == 0) goto L185;
        int r171 = 0;
    L186:
        int r510 = r171;
        if ((r144 & 16384) == 0) goto L189;
        int r172 = 0;
    L191:
        if ((r144 & 32768) == 0) goto L193;
        boolean r173 = false;
    L195:
        if ((r144 & 65536) == 0) goto L197;
        boolean r174 = false;
    L199:
        if ((r144 & 131072) == 0) goto L201;
        String r218 = null;
    L203:
        if ((r144 & 262144) == 0) goto L205;
        Float r219 = null;
    L207:
        if ((r144 & 524288) == 0) goto L209;
        String r511 = null;
    L211:
        if ((r144 & 1048576) == 0) goto L213;
        String r512 = null;
    L215:
        if ((r144 & 2097152) == 0) goto L217;
        String r513 = null;
    L219:
        if ((r144 & 4194304) == 0) goto L221;
        Integer r514 = 0;
    L223:
        if ((r144 & 8388608) == 0) goto L225;
        Integer r515 = null;
    L227:
        if ((r144 & 16777216) == 0) goto L229;
        String r516 = null;
    L231:
        if ((r144 & 33554432) == 0) goto L233;
        String r517 = null;
    L235:
        if ((r144 & 67108864) == 0) goto L237;
        Integer r518 = null;
    L239:
        if ((r144 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L241;
        String r519 = null;
    L243:
        if ((r144 & 268435456) == 0) goto L245;
        String r610 = null;
    L247:
        if ((r144 & 536870912) == 0) goto L249;
        String r611 = null;
    L251:
        if ((r144 & 1073741824) == 0) goto L253;
        String r612 = null;
    L255:
        if ((r144 & Integer.MIN_VALUE) == 0) goto L257;
        boolean r175 = false;
    L259:
        if ((r145 & 1) == 0) goto L261;
        boolean r613 = false;
    L263:
        if ((r145 & 2) == 0) goto L265;
        String r614 = null;
    L267:
        if ((r145 & 4) == 0) goto L269;
        Float r615 = Float.valueOf(0.0f);
    L271:
        if ((r145 & 8) == 0) goto L273;
        boolean r616 = false;
        Integer r617 = 0;
    L275:
        if ((r145 & 16) == 0) goto L277;
        boolean r618 = false;
    L279:
        if ((r145 & 32) == 0) goto L281;
        String r619 = null;
    L283:
        if ((r145 & 64) != 0) goto L286;
        r616 = r142;
    L286:
        this(r147, r148, r149, r150, r152, r151, r153, r154, r155, r156, r157, r158, r159, r161, r162, r163, r210, r211, r212, r213, r214, r215, r216, r217, r310, r311, r312, r313, r314, r315, r316, r1410, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r172, r173, r174, r218, r219, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r175, r613, r614, r615, r617, r618, r619, r616);
        return;
    L281:
        r619 = r141;
        goto L283
    L277:
        r618 = r140;
        goto L279
    L273:
        r616 = false;
        r617 = r139;
        goto L275
    L269:
        r615 = r138;
        goto L271
    L265:
        r614 = r137;
        goto L267
    L261:
        r613 = r136;
        goto L263
    L257:
        r175 = r135;
        goto L259
    L253:
        r612 = r134;
        goto L255
    L249:
        r611 = r133;
        goto L251
    L245:
        r610 = r132;
        goto L247
    L241:
        r519 = r131;
        goto L243
    L237:
        r518 = r130;
        goto L239
    L233:
        r517 = r129;
        goto L235
    L229:
        r516 = r128;
        goto L231
    L225:
        r515 = r127;
        goto L227
    L221:
        r514 = r126;
        goto L223
    L217:
        r513 = r125;
        goto L219
    L213:
        r512 = r124;
        goto L215
    L209:
        r511 = r123;
        goto L211
    L205:
        r219 = r122;
        goto L207
    L201:
        r218 = r121;
        goto L203
    L197:
        r174 = r120;
        goto L199
    L193:
        r173 = r119;
        goto L195
    L189:
        r172 = r118;
        goto L191
    L185:
        r171 = r117;
        goto L186
    L181:
        r170 = r116;
        goto L182
    L177:
        r169 = r115;
        goto L178
    L173:
        r168 = r114;
        goto L174
    L169:
        r167 = r113;
        goto L170
    L165:
        r166 = r112;
        goto L166
    L161:
        r165 = r111;
        goto L162
    L157:
        r413 = r110;
        goto L158
    L153:
        r412 = r109;
        goto L155
    L149:
        r411 = r108;
        goto L151
    L145:
        r410 = r107;
        goto L147
    L141:
        r319 = r106;
        goto L143
    L137:
        r318 = r105;
        goto L139
    L133:
        r317 = r104;
        goto L135
    L129:
        r164 = r103;
        goto L131
    L125:
        r316 = r102;
        goto L127
    L121:
        r315 = r101;
        goto L123
    L117:
        r314 = r100;
        goto L119
    L113:
        r313 = r919;
        goto L115
    L109:
        r312 = r918;
        goto L111
    L105:
        r311 = r917;
        goto L107
    L101:
        r310 = r916;
        goto L103
    L97:
        r217 = r915;
        goto L99
    L93:
        r216 = r914;
        goto L95
    L89:
        r215 = r913;
        goto L91
    L85:
        r214 = r912;
        goto L87
    L81:
        r213 = r911;
        goto L83
    L77:
        r212 = r910;
        goto L79
    L73:
        r211 = r819;
        goto L75
    L69:
        r210 = r818;
        goto L71
    L65:
        r163 = r817;
        goto L67
    L61:
        r162 = r816;
        goto L63
    L57:
        r160 = r815;
        goto L58
    L53:
        r159 = r814;
        goto L55
    L49:
        r158 = r813;
        goto L51
    L45:
        r157 = r812;
        goto L47
    L41:
        r156 = r811;
        goto L43
    L37:
        r155 = r810;
        goto L39
    L33:
        r154 = r717;
        goto L35
    L29:
        r153 = r716;
        goto L31
    L21:
        r152 = r714;
        goto L23
    L17:
        r150 = r713;
        goto L18
    L13:
        r149 = r712;
        goto L15
    L9:
        r148 = r711;
        goto L11
    L5:
        r147 = r710;
        goto L7
    }
}

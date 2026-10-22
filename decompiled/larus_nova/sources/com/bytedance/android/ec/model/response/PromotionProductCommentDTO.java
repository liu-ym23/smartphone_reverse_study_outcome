package com.bytedance.android.ec.model.response;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductCommentPhotoStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionVideoInfo;
import com.bytedance.sdk.account.platform.api.ITwitterService;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b3\n\u0002\u0010\u0000\n\u0002\b\\\b\u0086\b\u0018\u00002\u00020\u0001B£\u0004\u0012\b\u0010E\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010F\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010G\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010H\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010I\u001a\u0004\u0018\u00010\b\u0012\u000e\u0010J\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\b\u0010K\u001a\u0004\u0018\u00010\b\u0012\b\u0010L\u001a\u0004\u0018\u00010\b\u0012\b\u0010M\u001a\u0004\u0018\u00010\b\u0012\b\u0010N\u001a\u0004\u0018\u00010\b\u0012\b\u0010O\u001a\u0004\u0018\u00010\b\u0012\b\u0010P\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010Q\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010R\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010S\u001a\u0004\u0018\u00010\b\u0012\b\u0010T\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010U\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010V\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010W\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010X\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010Y\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010Z\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010[\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\\\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010]\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010^\u001a\u0004\u0018\u00010\u001a\u0012\u000e\u0010_\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\n\u0012\u000e\u0010`\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\n\u0012\u0010\b\u0002\u0010a\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010\n\u0012\u0010\b\u0002\u0010b\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\n\u0012\n\b\u0002\u0010c\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010d\u001a\u0004\u0018\u00010/\u0012\u0010\b\u0002\u0010e\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\n\u0012\n\b\u0002\u0010f\u001a\u0004\u0018\u000103\u0012\n\b\u0002\u0010g\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u0010h\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010i\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010j\u001a\u00020\u0002\u0012\n\b\u0002\u0010k\u001a\u0004\u0018\u000109\u0012\n\b\u0002\u0010l\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010m\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010n\u001a\u00020\u001a\u0012\u0016\b\u0002\u0010o\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010>\u0012\n\b\u0002\u0010p\u001a\u0004\u0018\u00010@\u0012\b\b\u0002\u0010q\u001a\u00020\u0012\u0012\n\b\u0002\u0010r\u001a\u0004\u0018\u00010C¢\u0006\u0006\bÑ\u0001\u0010Ò\u0001J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u000b\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0004J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0004J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0004J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0014J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0014J\u0012\u0010 \u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b \u0010\u0014J\u0012\u0010!\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b!\u0010\u0004J\u0012\u0010\"\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\"\u0010\u0004J\u0012\u0010#\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b#\u0010\u0004J\u0012\u0010$\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b$\u0010\u0004J\u0012\u0010%\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0004\b%\u0010\u001cJ\u0011\u0010'\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\nHÆ\u0003J\u0011\u0010)\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\nHÆ\u0003J\u0011\u0010+\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010\nHÆ\u0003J\u0011\u0010-\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\nHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010/HÆ\u0003J\u0011\u00102\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\nHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u000103HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010*HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\t\u00108\u001a\u00020\u0002HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u000109HÆ\u0003J\u0012\u0010;\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b;\u0010\u0014J\u000b\u0010<\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010=\u001a\u00020\u001aHÆ\u0003J\u0017\u0010?\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010>HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010@HÆ\u0003J\t\u0010B\u001a\u00020\u0012HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010CHÆ\u0003Jâ\u0004\u0010s\u001a\u00020\u00002\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010J\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010U\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010W\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010X\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010^\u001a\u0004\u0018\u00010\u001a2\u0010\b\u0002\u0010_\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\n2\u0010\b\u0002\u0010`\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\n2\u0010\b\u0002\u0010a\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010\n2\u0010\b\u0002\u0010b\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\n2\n\b\u0002\u0010c\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010d\u001a\u0004\u0018\u00010/2\u0010\b\u0002\u0010e\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\n2\n\b\u0002\u0010f\u001a\u0004\u0018\u0001032\n\b\u0002\u0010g\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010h\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010i\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010j\u001a\u00020\u00022\n\b\u0002\u0010k\u001a\u0004\u0018\u0001092\n\b\u0002\u0010l\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010m\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010n\u001a\u00020\u001a2\u0016\b\u0002\u0010o\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010>2\n\b\u0002\u0010p\u001a\u0004\u0018\u00010@2\b\b\u0002\u0010q\u001a\u00020\u00122\n\b\u0002\u0010r\u001a\u0004\u0018\u00010CHÆ\u0001¢\u0006\u0004\bs\u0010tJ\t\u0010u\u001a\u00020\bHÖ\u0001J\t\u0010v\u001a\u00020\u001aHÖ\u0001J\u0013\u0010y\u001a\u00020\u00122\b\u0010x\u001a\u0004\u0018\u00010wHÖ\u0003R$\u0010E\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bE\u0010z\u001a\u0004\b{\u0010\u0004\"\u0004\b|\u0010}R\u001c\u0010F\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bF\u0010z\u001a\u0004\b~\u0010\u0004R\u001c\u0010G\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bG\u0010z\u001a\u0004\b\u007f\u0010\u0004R\u001d\u0010H\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\r\n\u0004\bH\u0010z\u001a\u0005\b\u0080\u0001\u0010\u0004R\u001f\u0010I\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bI\u0010\u0081\u0001\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R%\u0010J\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bJ\u0010\u0084\u0001\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001R\u001f\u0010K\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bK\u0010\u0081\u0001\u001a\u0006\b\u0087\u0001\u0010\u0083\u0001R\u001f\u0010L\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bL\u0010\u0081\u0001\u001a\u0006\b\u0088\u0001\u0010\u0083\u0001R\u001f\u0010M\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bM\u0010\u0081\u0001\u001a\u0006\b\u0089\u0001\u0010\u0083\u0001R\u001f\u0010N\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bN\u0010\u0081\u0001\u001a\u0006\b\u008a\u0001\u0010\u0083\u0001R\u001f\u0010O\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bO\u0010\u0081\u0001\u001a\u0006\b\u008b\u0001\u0010\u0083\u0001R\u001d\u0010P\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\r\n\u0005\bP\u0010\u008c\u0001\u001a\u0004\bP\u0010\u0014R\u001d\u0010Q\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\r\n\u0004\bQ\u0010z\u001a\u0005\b\u008d\u0001\u0010\u0004R\u001d\u0010R\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\r\n\u0004\bR\u0010z\u001a\u0005\b\u008e\u0001\u0010\u0004R\u001f\u0010S\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bS\u0010\u0081\u0001\u001a\u0006\b\u008f\u0001\u0010\u0083\u0001R\u001f\u0010T\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bT\u0010\u0090\u0001\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001R\u001e\u0010U\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bU\u0010\u0093\u0001\u001a\u0005\b\u0094\u0001\u0010\u001cR&\u0010V\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0004\bV\u0010z\u001a\u0005\b\u0095\u0001\u0010\u0004\"\u0005\b\u0096\u0001\u0010}R(\u0010W\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0005\bW\u0010\u008c\u0001\u001a\u0005\b\u0097\u0001\u0010\u0014\"\u0006\b\u0098\u0001\u0010\u0099\u0001R\u001e\u0010X\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bX\u0010\u008c\u0001\u001a\u0005\b\u009a\u0001\u0010\u0014R\u001e\u0010Y\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bY\u0010\u008c\u0001\u001a\u0005\b\u009b\u0001\u0010\u0014R\u001d\u0010Z\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\r\n\u0004\bZ\u0010z\u001a\u0005\b\u009c\u0001\u0010\u0004R\u001d\u0010[\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\r\n\u0004\b[\u0010z\u001a\u0005\b\u009d\u0001\u0010\u0004R\u001d\u0010\\\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\r\n\u0004\b\\\u0010z\u001a\u0005\b\u009e\u0001\u0010\u0004R\u001d\u0010]\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\r\n\u0004\b]\u0010z\u001a\u0005\b\u009f\u0001\u0010\u0004R\u001e\u0010^\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b^\u0010\u0093\u0001\u001a\u0005\b \u0001\u0010\u001cR%\u0010_\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\b_\u0010\u0084\u0001\u001a\u0006\b¡\u0001\u0010\u0086\u0001R%\u0010`\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\b`\u0010\u0084\u0001\u001a\u0006\b¢\u0001\u0010\u0086\u0001R%\u0010a\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\ba\u0010\u0084\u0001\u001a\u0006\b£\u0001\u0010\u0086\u0001R%\u0010b\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bb\u0010\u0084\u0001\u001a\u0006\b¤\u0001\u0010\u0086\u0001R\u001f\u0010c\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bc\u0010\u0081\u0001\u001a\u0006\b¥\u0001\u0010\u0083\u0001R\u001f\u0010d\u001a\u0004\u0018\u00010/8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bd\u0010¦\u0001\u001a\u0006\b§\u0001\u0010¨\u0001R%\u0010e\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\be\u0010\u0084\u0001\u001a\u0006\b©\u0001\u0010\u0086\u0001R\u001f\u0010f\u001a\u0004\u0018\u0001038\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bf\u0010ª\u0001\u001a\u0006\b«\u0001\u0010¬\u0001R\u001f\u0010g\u001a\u0004\u0018\u00010*8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bg\u0010\u00ad\u0001\u001a\u0006\b®\u0001\u0010¯\u0001R\u001f\u0010h\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bh\u0010\u0081\u0001\u001a\u0006\b°\u0001\u0010\u0083\u0001R\u001f\u0010i\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bi\u0010\u0090\u0001\u001a\u0006\b±\u0001\u0010\u0092\u0001R'\u0010j\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bj\u0010²\u0001\u001a\u0006\b³\u0001\u0010´\u0001\"\u0006\bµ\u0001\u0010¶\u0001R\u001f\u0010k\u001a\u0004\u0018\u0001098\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bk\u0010·\u0001\u001a\u0006\b¸\u0001\u0010¹\u0001R\u001d\u0010l\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\r\n\u0005\bl\u0010\u008c\u0001\u001a\u0004\bl\u0010\u0014R\u001f\u0010m\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bm\u0010\u0081\u0001\u001a\u0006\bº\u0001\u0010\u0083\u0001R'\u0010n\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bn\u0010»\u0001\u001a\u0006\b¼\u0001\u0010½\u0001\"\u0006\b¾\u0001\u0010¿\u0001R+\u0010o\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010>8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bo\u0010À\u0001\u001a\u0006\bÁ\u0001\u0010Â\u0001R)\u0010p\u001a\u0004\u0018\u00010@8\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bp\u0010Ã\u0001\u001a\u0006\bÄ\u0001\u0010Å\u0001\"\u0006\bÆ\u0001\u0010Ç\u0001R&\u0010q\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0005\bq\u0010È\u0001\u001a\u0005\bq\u0010É\u0001\"\u0006\bÊ\u0001\u0010Ë\u0001R)\u0010r\u001a\u0004\u0018\u00010C8\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\br\u0010Ì\u0001\u001a\u0006\bÍ\u0001\u0010Î\u0001\"\u0006\bÏ\u0001\u0010Ð\u0001¨\u0006Ó\u0001"}, d2 = {"Lcom/bytedance/android/ec/model/response/PromotionProductCommentDTO;", "Ljava/io/Serializable;", "", "component1", "()Ljava/lang/Long;", "component2", "component3", "component4", "", "component5", "", "Lcom/bytedance/android/ec/model/response/g;", "component6", "component7", "component8", "component9", "component10", "component11", "", "component12", "()Ljava/lang/Boolean;", "component13", "component14", "component15", "Lcom/bytedance/android/ec/model/ECUrlModel;", "component16", "", "component17", "()Ljava/lang/Integer;", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "Lcom/bytedance/android/ec/model/response/PromotionProductCommentAppendDTO;", "component27", "Lcom/bytedance/android/ec/model/response/PromotionProductCommentPhotoDTO;", "component28", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionVideoInfo;", "component29", "Lcom/bytedance/android/ec/model/response/ECCommentVideo;", "component30", "component31", "Lcom/bytedance/android/ec/model/response/PromotionShopCommentProductCard;", "component32", "Lcom/bytedance/android/ec/model/response/PromotionProductCommentTagsStruct;", "component33", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductCommentPhotoStruct;", "component34", "component35", "component36", "component37", "component38", "Lcom/bytedance/android/ec/model/response/o1;", "component39", "component40", "component41", "component42", "", "component43", "Lcom/bytedance/android/ec/model/response/MoreActions;", "component44", "component45", "Lcom/bytedance/android/ec/model/response/ReplyData;", "component46", "id", "productId", "orderId", "parentId", "content", "highlights", "origContent", "shopReply", "commentTime", ECPromotion.SKU, "shopDescription", "isSelected", "userId", "userType", "userName", "userAvatar", "appId", "likes", "liked", "consed", "recommend", "rank", "rankShop", "rankLogistic", "rankProduct", "rankType", "appends", "photos", "videos", "videosV2", "posterUrl", "productCard", PromotionProductPrivilegesStruct.TAGS, "photoPoster", "videoPoster", "browseCount", "rankTypeIcon", "replyCount", "showOrderInfo", "isAnonymous", "userPageSchema", "lowQualityType", "logMap", "moreActions", "isAuthor", "replyData", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Lcom/bytedance/android/ec/model/response/PromotionShopCommentProductCard;Ljava/util/List;Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductCommentPhotoStruct;Lcom/bytedance/android/ec/model/response/anchorv3/PromotionVideoInfo;Ljava/lang/String;Lcom/bytedance/android/ec/model/ECUrlModel;JLcom/bytedance/android/ec/model/response/o1;Ljava/lang/Boolean;Ljava/lang/String;ILjava/util/Map;Lcom/bytedance/android/ec/model/response/MoreActions;ZLcom/bytedance/android/ec/model/response/ReplyData;)Lcom/bytedance/android/ec/model/response/PromotionProductCommentDTO;", "toString", "hashCode", "", "other", "equals", "Ljava/lang/Long;", "getId", "setId", "(Ljava/lang/Long;)V", "getProductId", "getOrderId", "getParentId", "Ljava/lang/String;", "getContent", "()Ljava/lang/String;", "Ljava/util/List;", "getHighlights", "()Ljava/util/List;", "getOrigContent", "getShopReply", "getCommentTime", "getSku", "getShopDescription", "Ljava/lang/Boolean;", "getUserId", "getUserType", "getUserName", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getUserAvatar", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "Ljava/lang/Integer;", "getAppId", "getLikes", "setLikes", "getLiked", "setLiked", "(Ljava/lang/Boolean;)V", "getConsed", "getRecommend", "getRank", "getRankShop", "getRankLogistic", "getRankProduct", "getRankType", "getAppends", "getPhotos", "getVideos", "getVideosV2", "getPosterUrl", "Lcom/bytedance/android/ec/model/response/PromotionShopCommentProductCard;", "getProductCard", "()Lcom/bytedance/android/ec/model/response/PromotionShopCommentProductCard;", "getTags", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductCommentPhotoStruct;", "getPhotoPoster", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductCommentPhotoStruct;", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionVideoInfo;", "getVideoPoster", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionVideoInfo;", "getBrowseCount", "getRankTypeIcon", "J", "getReplyCount", "()J", "setReplyCount", "(J)V", "Lcom/bytedance/android/ec/model/response/o1;", "getShowOrderInfo", "()Lcom/bytedance/android/ec/model/response/o1;", "getUserPageSchema", "I", "getLowQualityType", "()I", "setLowQualityType", "(I)V", "Ljava/util/Map;", "getLogMap", "()Ljava/util/Map;", "Lcom/bytedance/android/ec/model/response/MoreActions;", "getMoreActions", "()Lcom/bytedance/android/ec/model/response/MoreActions;", "setMoreActions", "(Lcom/bytedance/android/ec/model/response/MoreActions;)V", "Z", "()Z", "setAuthor", "(Z)V", "Lcom/bytedance/android/ec/model/response/ReplyData;", "getReplyData", "()Lcom/bytedance/android/ec/model/response/ReplyData;", "setReplyData", "(Lcom/bytedance/android/ec/model/response/ReplyData;)V", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Lcom/bytedance/android/ec/model/response/PromotionShopCommentProductCard;Ljava/util/List;Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductCommentPhotoStruct;Lcom/bytedance/android/ec/model/response/anchorv3/PromotionVideoInfo;Ljava/lang/String;Lcom/bytedance/android/ec/model/ECUrlModel;JLcom/bytedance/android/ec/model/response/o1;Ljava/lang/Boolean;Ljava/lang/String;ILjava/util/Map;Lcom/bytedance/android/ec/model/response/MoreActions;ZLcom/bytedance/android/ec/model/response/ReplyData;)V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionProductCommentDTO implements Serializable {

    @SerializedName("app_id")
    private final Integer appId;

    @SerializedName("appends")
    private final List<PromotionProductCommentAppendDTO> appends;

    @SerializedName("browse_count")
    private final String browseCount;

    @SerializedName("comment_time")
    private final String commentTime;

    @SerializedName("consed")
    private final Boolean consed;

    @SerializedName("content")
    private final String content;

    @SerializedName("highlights")
    private final List<g> highlights;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private Long f47918id;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_IS_ANONYMOUS)
    private final Boolean isAnonymous;

    @SerializedName("is_author")
    private boolean isAuthor;

    @SerializedName("is_selected")
    private final Boolean isSelected;

    @SerializedName("liked")
    private Boolean liked;

    @SerializedName("likes")
    private Long likes;

    @SerializedName("log_map")
    private final Map<String, String> logMap;

    @SerializedName("low_quality_type")
    private int lowQualityType;

    @SerializedName("more_actions")
    private MoreActions moreActions;

    @SerializedName("order_id")
    private final Long orderId;

    @SerializedName("orig_content")
    private final String origContent;

    @SerializedName("parent_id")
    private final Long parentId;

    @SerializedName("photo_poster")
    private final PromotionProductCommentPhotoStruct photoPoster;

    @SerializedName("photos")
    private final List<PromotionProductCommentPhotoDTO> photos;

    @SerializedName("poster_url")
    private final String posterUrl;

    @SerializedName("product_card")
    private final PromotionShopCommentProductCard productCard;

    @SerializedName("product_id")
    private final Long productId;

    @SerializedName("rank")
    private final Long rank;

    @SerializedName("rank_logistic")
    private final Long rankLogistic;

    @SerializedName("rank_product")
    private final Long rankProduct;

    @SerializedName("rank_shop")
    private final Long rankShop;

    @SerializedName("rank_type")
    private final Integer rankType;

    @SerializedName("rank_icon")
    private final ECUrlModel rankTypeIcon;

    @SerializedName("recommend")
    private final Boolean recommend;

    @SerializedName("aweme_reply_count")
    private long replyCount;

    @SerializedName("reply_data")
    private ReplyData replyData;

    @SerializedName("shop_description")
    private final String shopDescription;

    @SerializedName("shop_reply")
    private final String shopReply;

    @SerializedName("show_order_info")
    private final o1 showOrderInfo;

    @SerializedName(ECPromotion.SKU)
    private final String sku;

    @SerializedName(PromotionProductPrivilegesStruct.TAGS)
    private final List<PromotionProductCommentTagsStruct> tags;

    @SerializedName("user_avatar")
    private final ECUrlModel userAvatar;

    @SerializedName("user_id")
    private final Long userId;

    @SerializedName(ITwitterService.ResponseConstants.USER_NAME)
    private final String userName;

    @SerializedName("user_page_schema")
    private final String userPageSchema;

    @SerializedName("user_type")
    private final Long userType;

    @SerializedName("video_poster")
    private final PromotionVideoInfo videoPoster;

    @SerializedName("videos")
    private final List<PromotionVideoInfo> videos;

    @SerializedName("videos_v2")
    private final List<ECCommentVideo> videosV2;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PromotionProductCommentDTO copy$default(PromotionProductCommentDTO r110, Long r111, Long r112, Long r210, Long r211, String r212, List r213, String r214, String r215, String r216, String r217, String r218, Boolean r219, Long r310, Long r311, String r312, ECUrlModel r313, Integer r314, Long r315, Boolean r316, Boolean r317, Boolean r318, Long r319, Long r410, Long r411, Long r412, Integer r413, List r414, List r415, List r416, List r417, String r418, PromotionShopCommentProductCard r419, List r510, PromotionProductCommentPhotoStruct r511, PromotionVideoInfo r512, String r513, ECUrlModel r514, long r515, o1 r516, Boolean r517, String r518, int r610, Map r611, MoreActions r612, boolean r613, ReplyData r614, int r615, int r616, Object r617) {
        if ((r615 & 1) == 0) goto L5;
        Long r100 = r110.f47918id;
    L7:
        if ((r615 & 2) == 0) goto L9;
        Long r101 = r110.productId;
    L11:
        if ((r615 & 4) == 0) goto L13;
        Long r102 = r110.orderId;
    L15:
        if ((r615 & 8) == 0) goto L17;
        Long r103 = r110.parentId;
    L19:
        if ((r615 & 16) == 0) goto L21;
        String r104 = r110.content;
    L23:
        if ((r615 & 32) == 0) goto L25;
        List r105 = r110.highlights;
    L27:
        if ((r615 & 64) == 0) goto L29;
        String r106 = r110.origContent;
    L31:
        if ((r615 & 128) == 0) goto L33;
        String r113 = r110.shopReply;
    L35:
        if ((r615 & 256) == 0) goto L37;
        String r114 = r110.commentTime;
    L39:
        if ((r615 & 512) == 0) goto L41;
        String r115 = r110.sku;
    L43:
        if ((r615 & 1024) == 0) goto L45;
        String r116 = r110.shopDescription;
    L47:
        if ((r615 & 2048) == 0) goto L49;
        Boolean r117 = r110.isSelected;
    L51:
        if ((r615 & 4096) == 0) goto L53;
        Long r118 = r110.userId;
    L54:
        Long r320 = r118;
        if ((r615 & 8192) == 0) goto L57;
        Long r119 = r110.userType;
    L58:
        Long r321 = r119;
        if ((r615 & 16384) == 0) goto L61;
        String r120 = r110.userName;
    L62:
        String r322 = r120;
        if ((r615 & 32768) == 0) goto L65;
        ECUrlModel r121 = r110.userAvatar;
    L66:
        ECUrlModel r323 = r121;
        if ((r615 & 65536) == 0) goto L69;
        Integer r122 = r110.appId;
    L70:
        Integer r324 = r122;
        if ((r615 & 131072) == 0) goto L73;
        Long r123 = r110.likes;
    L74:
        Long r325 = r123;
        if ((r615 & 262144) == 0) goto L77;
        Boolean r124 = r110.liked;
    L78:
        Boolean r326 = r124;
        if ((r615 & 524288) == 0) goto L81;
        Boolean r125 = r110.consed;
    L82:
        Boolean r327 = r125;
        if ((r615 & 1048576) == 0) goto L85;
        Boolean r126 = r110.recommend;
    L86:
        Boolean r328 = r126;
        if ((r615 & 2097152) == 0) goto L89;
        Long r127 = r110.rank;
    L90:
        Long r329 = r127;
        if ((r615 & 4194304) == 0) goto L93;
        Long r128 = r110.rankShop;
    L94:
        Long r420 = r128;
        if ((r615 & 8388608) == 0) goto L97;
        Long r129 = r110.rankLogistic;
    L98:
        Long r421 = r129;
        if ((r615 & 16777216) == 0) goto L101;
        Long r130 = r110.rankProduct;
    L102:
        Long r422 = r130;
        if ((r615 & 33554432) == 0) goto L105;
        Integer r131 = r110.rankType;
    L106:
        Integer r423 = r131;
        if ((r615 & 67108864) == 0) goto L109;
        List r132 = r110.appends;
    L110:
        List r424 = r132;
        if ((r615 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        List r133 = r110.photos;
    L114:
        List r425 = r133;
        if ((r615 & 268435456) == 0) goto L117;
        List r134 = r110.videos;
    L118:
        List r426 = r134;
        if ((r615 & 536870912) == 0) goto L121;
        List r135 = r110.videosV2;
    L122:
        List r427 = r135;
        if ((r615 & 1073741824) == 0) goto L125;
        String r136 = r110.posterUrl;
    L127:
        if ((r615 & Integer.MIN_VALUE) == 0) goto L129;
        PromotionShopCommentProductCard r107 = r110.productCard;
    L130:
        PromotionShopCommentProductCard r428 = r107;
        if ((r616 & 1) == 0) goto L133;
        List r108 = r110.tags;
    L134:
        List r519 = r108;
        if ((r616 & 2) == 0) goto L137;
        PromotionProductCommentPhotoStruct r109 = r110.photoPoster;
    L138:
        PromotionProductCommentPhotoStruct r520 = r109;
        if ((r616 & 4) == 0) goto L141;
        PromotionVideoInfo r137 = r110.videoPoster;
    L142:
        PromotionVideoInfo r521 = r137;
        if ((r616 & 8) == 0) goto L145;
        String r138 = r110.browseCount;
    L146:
        String r522 = r138;
        if ((r616 & 16) == 0) goto L149;
        ECUrlModel r139 = r110.rankTypeIcon;
    L150:
        Boolean r220 = r117;
        String r429 = r136;
        if ((r616 & 32) == 0) goto L153;
        long r140 = r110.replyCount;
    L154:
        long r523 = r140;
        if ((r616 & 64) == 0) goto L157;
        o1 r141 = r110.showOrderInfo;
    L159:
        if ((r616 & 128) == 0) goto L161;
        Boolean r142 = r110.isAnonymous;
    L162:
        Boolean r524 = r142;
        if ((r616 & 256) == 0) goto L165;
        String r143 = r110.userPageSchema;
    L166:
        String r525 = r143;
        if ((r616 & 512) == 0) goto L169;
        int r144 = r110.lowQualityType;
    L170:
        int r618 = r144;
        if ((r616 & 1024) == 0) goto L173;
        Map r145 = r110.logMap;
    L174:
        Map r619 = r145;
        if ((r616 & 2048) == 0) goto L177;
        MoreActions r146 = r110.moreActions;
    L178:
        MoreActions r620 = r146;
        if ((r616 & 4096) == 0) goto L181;
        boolean r147 = r110.isAuthor;
    L183:
        if ((r616 & 8192) == 0) goto L185;
        ReplyData r148 = r110.replyData;
    L187:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r113, r114, r115, r116, r220, r320, r321, r322, r323, r324, r325, r326, r327, r328, r329, r420, r421, r422, r423, r424, r425, r426, r427, r429, r428, r519, r520, r521, r522, r139, r523, r141, r524, r525, r618, r619, r620, r147, r148);
    L185:
        r148 = r614;
        goto L187
    L181:
        r147 = r613;
        goto L183
    L177:
        r146 = r612;
        goto L178
    L173:
        r145 = r611;
        goto L174
    L169:
        r144 = r610;
        goto L170
    L165:
        r143 = r518;
        goto L166
    L161:
        r142 = r517;
        goto L162
    L157:
        r141 = r516;
        goto L159
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

    public final Long component1() {
        return this.f47918id;
    }

    public final String component10() {
        return this.sku;
    }

    public final String component11() {
        return this.shopDescription;
    }

    public final Boolean component12() {
        return this.isSelected;
    }

    public final Long component13() {
        return this.userId;
    }

    public final Long component14() {
        return this.userType;
    }

    public final String component15() {
        return this.userName;
    }

    public final ECUrlModel component16() {
        return this.userAvatar;
    }

    public final Integer component17() {
        return this.appId;
    }

    public final Long component18() {
        return this.likes;
    }

    public final Boolean component19() {
        return this.liked;
    }

    public final Long component2() {
        return this.productId;
    }

    public final Boolean component20() {
        return this.consed;
    }

    public final Boolean component21() {
        return this.recommend;
    }

    public final Long component22() {
        return this.rank;
    }

    public final Long component23() {
        return this.rankShop;
    }

    public final Long component24() {
        return this.rankLogistic;
    }

    public final Long component25() {
        return this.rankProduct;
    }

    public final Integer component26() {
        return this.rankType;
    }

    public final List<PromotionProductCommentAppendDTO> component27() {
        return this.appends;
    }

    public final List<PromotionProductCommentPhotoDTO> component28() {
        return this.photos;
    }

    public final List<PromotionVideoInfo> component29() {
        return this.videos;
    }

    public final Long component3() {
        return this.orderId;
    }

    public final List<ECCommentVideo> component30() {
        return this.videosV2;
    }

    public final String component31() {
        return this.posterUrl;
    }

    public final PromotionShopCommentProductCard component32() {
        return this.productCard;
    }

    public final List<PromotionProductCommentTagsStruct> component33() {
        return this.tags;
    }

    public final PromotionProductCommentPhotoStruct component34() {
        return this.photoPoster;
    }

    public final PromotionVideoInfo component35() {
        return this.videoPoster;
    }

    public final String component36() {
        return this.browseCount;
    }

    public final ECUrlModel component37() {
        return this.rankTypeIcon;
    }

    public final long component38() {
        return this.replyCount;
    }

    public final o1 component39() {
        return this.showOrderInfo;
    }

    public final Long component4() {
        return this.parentId;
    }

    public final Boolean component40() {
        return this.isAnonymous;
    }

    public final String component41() {
        return this.userPageSchema;
    }

    public final int component42() {
        return this.lowQualityType;
    }

    public final Map<String, String> component43() {
        return this.logMap;
    }

    public final MoreActions component44() {
        return this.moreActions;
    }

    public final boolean component45() {
        return this.isAuthor;
    }

    public final ReplyData component46() {
        return this.replyData;
    }

    public final String component5() {
        return this.content;
    }

    public final List<g> component6() {
        return this.highlights;
    }

    public final String component7() {
        return this.origContent;
    }

    public final String component8() {
        return this.shopReply;
    }

    public final String component9() {
        return this.commentTime;
    }

    public final PromotionProductCommentDTO copy(Long r510, Long r511, Long r512, Long r513, String r514, List<g> r515, String r516, String r517, String r518, String r519, String r610, Boolean r611, Long r612, Long r613, String r614, ECUrlModel r615, Integer r616, Long r617, Boolean r618, Boolean r619, Boolean r710, Long r711, Long r712, Long r713, Long r714, Integer r715, List<PromotionProductCommentAppendDTO> r716, List<PromotionProductCommentPhotoDTO> r717, List<PromotionVideoInfo> r718, List<ECCommentVideo> r719, String r810, PromotionShopCommentProductCard r811, List<PromotionProductCommentTagsStruct> r812, PromotionProductCommentPhotoStruct r813, PromotionVideoInfo r814, String r815, ECUrlModel r816, long r817, o1 r818, Boolean r910, String r911, int r912, Map<String, String> r913, MoreActions r914, boolean r915, ReplyData r916) {
        return new PromotionProductCommentDTO(r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r710, r711, r712, r713, r714, r715, r716, r717, r718, r719, r810, r811, r812, r813, r814, r815, r816, r817, r818, r910, r911, r912, r913, r914, r915, r916);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PromotionProductCommentDTO) == false) goto L98;
        PromotionProductCommentDTO r101 = (PromotionProductCommentDTO) r100;
        if (Intrinsics.areEqual(this.f47918id, r101.f47918id) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.productId, r101.productId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.orderId, r101.orderId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.parentId, r101.parentId) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.highlights, r101.highlights) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.origContent, r101.origContent) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.shopReply, r101.shopReply) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.commentTime, r101.commentTime) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.sku, r101.sku) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.shopDescription, r101.shopDescription) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.isSelected, r101.isSelected) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.userId, r101.userId) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.userType, r101.userType) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.userName, r101.userName) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.userAvatar, r101.userAvatar) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.appId, r101.appId) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.likes, r101.likes) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.liked, r101.liked) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.consed, r101.consed) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.recommend, r101.recommend) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.rank, r101.rank) == true) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.rankShop, r101.rankShop) == true) goto L52;
        return false;
    L52:
        if (Intrinsics.areEqual(this.rankLogistic, r101.rankLogistic) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.rankProduct, r101.rankProduct) == true) goto L56;
        return false;
    L56:
        if (Intrinsics.areEqual(this.rankType, r101.rankType) == true) goto L58;
        return false;
    L58:
        if (Intrinsics.areEqual(this.appends, r101.appends) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.photos, r101.photos) == true) goto L62;
        return false;
    L62:
        if (Intrinsics.areEqual(this.videos, r101.videos) == true) goto L64;
        return false;
    L64:
        if (Intrinsics.areEqual(this.videosV2, r101.videosV2) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.posterUrl, r101.posterUrl) == true) goto L68;
        return false;
    L68:
        if (Intrinsics.areEqual(this.productCard, r101.productCard) == true) goto L70;
        return false;
    L70:
        if (Intrinsics.areEqual(this.tags, r101.tags) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.photoPoster, r101.photoPoster) == true) goto L74;
        return false;
    L74:
        if (Intrinsics.areEqual(this.videoPoster, r101.videoPoster) == true) goto L76;
        return false;
    L76:
        if (Intrinsics.areEqual(this.browseCount, r101.browseCount) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.rankTypeIcon, r101.rankTypeIcon) == true) goto L80;
        return false;
    L80:
        if (this.replyCount == r101.replyCount) goto L82;
        return false;
    L82:
        if (Intrinsics.areEqual(this.showOrderInfo, r101.showOrderInfo) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.isAnonymous, r101.isAnonymous) == true) goto L86;
        return false;
    L86:
        if (Intrinsics.areEqual(this.userPageSchema, r101.userPageSchema) == true) goto L88;
        return false;
    L88:
        if (this.lowQualityType == r101.lowQualityType) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.logMap, r101.logMap) == true) goto L92;
        return false;
    L92:
        if (Intrinsics.areEqual(this.moreActions, r101.moreActions) == true) goto L94;
        return false;
    L94:
        if (this.isAuthor == r101.isAuthor) goto L96;
        return false;
    L96:
        if (Intrinsics.areEqual(this.replyData, r101.replyData) == true) goto L148;
        return false;
    L148:
        return true;
    L98:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v90, types: [int] */
    /* JADX WARN: Type inference failed for: r2v127, types: [int] */
    /* JADX WARN: Type inference failed for: r2v129 */
    /* JADX WARN: Type inference failed for: r2v171 */
    public int hashCode() {
        Long r100 = this.f47918id;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Long r104 = this.productId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.orderId;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.parentId;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.content;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        List<g> r116 = this.highlights;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.origContent;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.shopReply;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.commentTime;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.sku;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.shopDescription;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        Boolean r134 = this.isSelected;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        Long r137 = this.userId;
        if (r137 == null) goto L53;
        int r138 = r137.hashCode();
    L54:
        int r139 = (r136 + r138) * 31;
        Long r140 = this.userType;
        if (r140 == null) goto L57;
        int r141 = r140.hashCode();
    L58:
        int r142 = (r139 + r141) * 31;
        String r143 = this.userName;
        if (r143 == null) goto L61;
        int r144 = r143.hashCode();
    L62:
        int r145 = (r142 + r144) * 31;
        ECUrlModel r146 = this.userAvatar;
        if (r146 == null) goto L65;
        int r147 = r146.hashCode();
    L66:
        int r148 = (r145 + r147) * 31;
        Integer r149 = this.appId;
        if (r149 == null) goto L69;
        int r150 = r149.hashCode();
    L70:
        int r151 = (r148 + r150) * 31;
        Long r152 = this.likes;
        if (r152 == null) goto L73;
        int r153 = r152.hashCode();
    L74:
        int r154 = (r151 + r153) * 31;
        Boolean r155 = this.liked;
        if (r155 == null) goto L77;
        int r156 = r155.hashCode();
    L78:
        int r157 = (r154 + r156) * 31;
        Boolean r158 = this.consed;
        if (r158 == null) goto L81;
        int r159 = r158.hashCode();
    L82:
        int r160 = (r157 + r159) * 31;
        Boolean r161 = this.recommend;
        if (r161 == null) goto L85;
        int r162 = r161.hashCode();
    L86:
        int r163 = (r160 + r162) * 31;
        Long r164 = this.rank;
        if (r164 == null) goto L89;
        int r165 = r164.hashCode();
    L90:
        int r166 = (r163 + r165) * 31;
        Long r167 = this.rankShop;
        if (r167 == null) goto L93;
        int r168 = r167.hashCode();
    L94:
        int r169 = (r166 + r168) * 31;
        Long r170 = this.rankLogistic;
        if (r170 == null) goto L97;
        int r171 = r170.hashCode();
    L98:
        int r172 = (r169 + r171) * 31;
        Long r173 = this.rankProduct;
        if (r173 == null) goto L101;
        int r174 = r173.hashCode();
    L102:
        int r175 = (r172 + r174) * 31;
        Integer r176 = this.rankType;
        if (r176 == null) goto L105;
        int r177 = r176.hashCode();
    L106:
        int r178 = (r175 + r177) * 31;
        List<PromotionProductCommentAppendDTO> r179 = this.appends;
        if (r179 == null) goto L109;
        int r180 = r179.hashCode();
    L110:
        int r181 = (r178 + r180) * 31;
        List<PromotionProductCommentPhotoDTO> r182 = this.photos;
        if (r182 == null) goto L113;
        int r183 = r182.hashCode();
    L114:
        int r184 = (r181 + r183) * 31;
        List<PromotionVideoInfo> r185 = this.videos;
        if (r185 == null) goto L117;
        int r186 = r185.hashCode();
    L118:
        int r187 = (r184 + r186) * 31;
        List<ECCommentVideo> r188 = this.videosV2;
        if (r188 == null) goto L121;
        int r189 = r188.hashCode();
    L122:
        int r190 = (r187 + r189) * 31;
        String r191 = this.posterUrl;
        if (r191 == null) goto L125;
        int r192 = r191.hashCode();
    L126:
        int r193 = (r190 + r192) * 31;
        PromotionShopCommentProductCard r194 = this.productCard;
        if (r194 == null) goto L129;
        int r195 = r194.hashCode();
    L130:
        int r196 = (r193 + r195) * 31;
        List<PromotionProductCommentTagsStruct> r197 = this.tags;
        if (r197 == null) goto L133;
        int r198 = r197.hashCode();
    L134:
        int r199 = (r196 + r198) * 31;
        PromotionProductCommentPhotoStruct r200 = this.photoPoster;
        if (r200 == null) goto L137;
        int r201 = r200.hashCode();
    L138:
        int r202 = (r199 + r201) * 31;
        PromotionVideoInfo r203 = this.videoPoster;
        if (r203 == null) goto L141;
        int r204 = r203.hashCode();
    L142:
        int r205 = (r202 + r204) * 31;
        String r206 = this.browseCount;
        if (r206 == null) goto L145;
        int r207 = r206.hashCode();
    L146:
        int r208 = (r205 + r207) * 31;
        ECUrlModel r209 = this.rankTypeIcon;
        if (r209 == null) goto L149;
        int r210 = r209.hashCode();
    L150:
        int r211 = (r208 + r210) * 31;
        long r212 = this.replyCount;
        int r213 = (r211 + ((int) (r212 ^ (r212 >>> 32)))) * 31;
        o1 r214 = this.showOrderInfo;
        if (r214 == null) goto L153;
        int r215 = r214.hashCode();
    L154:
        int r216 = (r213 + r215) * 31;
        Boolean r217 = this.isAnonymous;
        if (r217 == null) goto L157;
        int r218 = r217.hashCode();
    L158:
        int r219 = (r216 + r218) * 31;
        String r220 = this.userPageSchema;
        if (r220 == null) goto L161;
        int r221 = r220.hashCode();
    L162:
        int r222 = (((r219 + r221) * 31) + this.lowQualityType) * 31;
        Map<String, String> r223 = this.logMap;
        if (r223 == null) goto L165;
        int r224 = r223.hashCode();
    L166:
        int r225 = (r222 + r224) * 31;
        MoreActions r226 = this.moreActions;
        if (r226 == null) goto L169;
        int r227 = r226.hashCode();
    L170:
        int r228 = (r225 + r227) * 31;
        boolean r229 = this.isAuthor;
        ?? r230 = r229;
        if (r229 == false) goto L173;
        r230 = 1;
    L173:
        int r231 = (r228 + r230) * 31;
        ReplyData r232 = this.replyData;
        if (r232 == null) goto L177;
        r101 = r232.hashCode();
    L177:
        return r231 + r101;
    L169:
        r227 = 0;
        goto L170
    L165:
        r224 = 0;
        goto L166
    L161:
        r221 = 0;
        goto L162
    L157:
        r218 = 0;
        goto L158
    L153:
        r215 = 0;
        goto L154
    L149:
        r210 = 0;
        goto L150
    L145:
        r207 = 0;
        goto L146
    L141:
        r204 = 0;
        goto L142
    L137:
        r201 = 0;
        goto L138
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

    public String toString() {
        return "PromotionProductCommentDTO(id=" + this.f47918id + ", productId=" + this.productId + ", orderId=" + this.orderId + ", parentId=" + this.parentId + ", content=" + this.content + ", highlights=" + this.highlights + ", origContent=" + this.origContent + ", shopReply=" + this.shopReply + ", commentTime=" + this.commentTime + ", sku=" + this.sku + ", shopDescription=" + this.shopDescription + ", isSelected=" + this.isSelected + ", userId=" + this.userId + ", userType=" + this.userType + ", userName=" + this.userName + ", userAvatar=" + this.userAvatar + ", appId=" + this.appId + ", likes=" + this.likes + ", liked=" + this.liked + ", consed=" + this.consed + ", recommend=" + this.recommend + ", rank=" + this.rank + ", rankShop=" + this.rankShop + ", rankLogistic=" + this.rankLogistic + ", rankProduct=" + this.rankProduct + ", rankType=" + this.rankType + ", appends=" + this.appends + ", photos=" + this.photos + ", videos=" + this.videos + ", videosV2=" + this.videosV2 + ", posterUrl=" + this.posterUrl + ", productCard=" + this.productCard + ", tags=" + this.tags + ", photoPoster=" + this.photoPoster + ", videoPoster=" + this.videoPoster + ", browseCount=" + this.browseCount + ", rankTypeIcon=" + this.rankTypeIcon + ", replyCount=" + this.replyCount + ", showOrderInfo=" + this.showOrderInfo + ", isAnonymous=" + this.isAnonymous + ", userPageSchema=" + this.userPageSchema + ", lowQualityType=" + this.lowQualityType + ", logMap=" + this.logMap + ", moreActions=" + this.moreActions + ", isAuthor=" + this.isAuthor + ", replyData=" + this.replyData + ")";
    }

    public final Integer getAppId() {
        return this.appId;
    }

    public final List<PromotionProductCommentAppendDTO> getAppends() {
        return this.appends;
    }

    public final String getBrowseCount() {
        return this.browseCount;
    }

    public final String getCommentTime() {
        return this.commentTime;
    }

    public final Boolean getConsed() {
        return this.consed;
    }

    public final String getContent() {
        return this.content;
    }

    public final List<g> getHighlights() {
        return this.highlights;
    }

    public final Long getId() {
        return this.f47918id;
    }

    public final Boolean getLiked() {
        return this.liked;
    }

    public final Long getLikes() {
        return this.likes;
    }

    public final Map<String, String> getLogMap() {
        return this.logMap;
    }

    public final int getLowQualityType() {
        return this.lowQualityType;
    }

    public final MoreActions getMoreActions() {
        return this.moreActions;
    }

    public final Long getOrderId() {
        return this.orderId;
    }

    public final String getOrigContent() {
        return this.origContent;
    }

    public final Long getParentId() {
        return this.parentId;
    }

    public final PromotionProductCommentPhotoStruct getPhotoPoster() {
        return this.photoPoster;
    }

    public final List<PromotionProductCommentPhotoDTO> getPhotos() {
        return this.photos;
    }

    public final String getPosterUrl() {
        return this.posterUrl;
    }

    public final PromotionShopCommentProductCard getProductCard() {
        return this.productCard;
    }

    public final Long getProductId() {
        return this.productId;
    }

    public final Long getRank() {
        return this.rank;
    }

    public final Long getRankLogistic() {
        return this.rankLogistic;
    }

    public final Long getRankProduct() {
        return this.rankProduct;
    }

    public final Long getRankShop() {
        return this.rankShop;
    }

    public final Integer getRankType() {
        return this.rankType;
    }

    public final ECUrlModel getRankTypeIcon() {
        return this.rankTypeIcon;
    }

    public final Boolean getRecommend() {
        return this.recommend;
    }

    public final long getReplyCount() {
        return this.replyCount;
    }

    public final ReplyData getReplyData() {
        return this.replyData;
    }

    public final String getShopDescription() {
        return this.shopDescription;
    }

    public final String getShopReply() {
        return this.shopReply;
    }

    public final o1 getShowOrderInfo() {
        return this.showOrderInfo;
    }

    public final String getSku() {
        return this.sku;
    }

    public final List<PromotionProductCommentTagsStruct> getTags() {
        return this.tags;
    }

    public final ECUrlModel getUserAvatar() {
        return this.userAvatar;
    }

    public final Long getUserId() {
        return this.userId;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final String getUserPageSchema() {
        return this.userPageSchema;
    }

    public final Long getUserType() {
        return this.userType;
    }

    public final PromotionVideoInfo getVideoPoster() {
        return this.videoPoster;
    }

    public final List<PromotionVideoInfo> getVideos() {
        return this.videos;
    }

    public final List<ECCommentVideo> getVideosV2() {
        return this.videosV2;
    }

    public final Boolean isAnonymous() {
        return this.isAnonymous;
    }

    public final boolean isAuthor() {
        return this.isAuthor;
    }

    public final Boolean isSelected() {
        return this.isSelected;
    }

    public final void setAuthor(boolean r100) {
        this.isAuthor = r100;
    }

    public final void setId(Long r100) {
        this.f47918id = r100;
    }

    public final void setLiked(Boolean r100) {
        this.liked = r100;
    }

    public final void setLikes(Long r100) {
        this.likes = r100;
    }

    public final void setLowQualityType(int r100) {
        this.lowQualityType = r100;
    }

    public final void setMoreActions(MoreActions r100) {
        this.moreActions = r100;
    }

    public final void setReplyCount(long r100) {
        this.replyCount = r100;
    }

    public final void setReplyData(ReplyData r100) {
        this.replyData = r100;
    }

    public PromotionProductCommentDTO(Long r100, Long r101, Long r102, Long r103, String r104, List<g> r105, String r110, String r111, String r112, String r113, String r114, Boolean r115, Long r116, Long r117, String r118, ECUrlModel r119, Integer r210, Long r211, Boolean r212, Boolean r213, Boolean r214, Long r215, Long r216, Long r217, Long r218, Integer r219, List<PromotionProductCommentAppendDTO> r310, List<PromotionProductCommentPhotoDTO> r311, List<PromotionVideoInfo> r312, List<ECCommentVideo> r313, String r314, PromotionShopCommentProductCard r315, List<PromotionProductCommentTagsStruct> r316, PromotionProductCommentPhotoStruct r317, PromotionVideoInfo r318, String r319, ECUrlModel r410, long r411, o1 r412, Boolean r413, String r414, int r415, Map<String, String> r416, MoreActions r417, boolean r418, ReplyData r510) {
        this.f47918id = r100;
        this.productId = r101;
        this.orderId = r102;
        this.parentId = r103;
        this.content = r104;
        this.highlights = r105;
        this.origContent = r110;
        this.shopReply = r111;
        this.commentTime = r112;
        this.sku = r113;
        this.shopDescription = r114;
        this.isSelected = r115;
        this.userId = r116;
        this.userType = r117;
        this.userName = r118;
        this.userAvatar = r119;
        this.appId = r210;
        this.likes = r211;
        this.liked = r212;
        this.consed = r213;
        this.recommend = r214;
        this.rank = r215;
        this.rankShop = r216;
        this.rankLogistic = r217;
        this.rankProduct = r218;
        this.rankType = r219;
        this.appends = r310;
        this.photos = r311;
        this.videos = r312;
        this.videosV2 = r313;
        this.posterUrl = r314;
        this.productCard = r315;
        this.tags = r316;
        this.photoPoster = r317;
        this.videoPoster = r318;
        this.browseCount = r319;
        this.rankTypeIcon = r410;
        this.replyCount = r411;
        this.showOrderInfo = r412;
        this.isAnonymous = r413;
        this.userPageSchema = r414;
        this.lowQualityType = r415;
        this.logMap = r416;
        this.moreActions = r417;
        this.isAuthor = r418;
        this.replyData = r510;
    }

    public /* synthetic */ PromotionProductCommentDTO(Long r510, Long r511, Long r512, Long r513, String r514, List r515, String r516, String r517, String r610, String r611, String r612, Boolean r613, Long r614, Long r615, String r616, ECUrlModel r617, Integer r618, Long r619, Boolean r710, Boolean r711, Boolean r712, Long r713, Long r714, Long r715, Long r716, Integer r717, List r718, List r719, List r810, List r811, String r812, PromotionShopCommentProductCard r813, List r814, PromotionProductCommentPhotoStruct r815, PromotionVideoInfo r816, String r817, ECUrlModel r818, long r819, o1 r910, Boolean r911, String r912, int r913, Map r914, MoreActions r915, boolean r916, ReplyData r917, int r918, int r100, DefaultConstructorMarker r101) {
        if ((r918 & 268435456) == 0) goto L5;
        List r310 = null;
    L7:
        if ((r918 & 536870912) == 0) goto L9;
        List r311 = null;
    L11:
        if ((r918 & 1073741824) == 0) goto L13;
        String r312 = null;
    L15:
        if ((r918 & Integer.MIN_VALUE) == 0) goto L17;
        PromotionShopCommentProductCard r313 = null;
    L19:
        if ((r100 & 1) == 0) goto L21;
        List r314 = null;
    L23:
        if ((r100 & 2) == 0) goto L25;
        PromotionProductCommentPhotoStruct r315 = null;
    L27:
        if ((r100 & 4) == 0) goto L29;
        PromotionVideoInfo r316 = null;
    L31:
        if ((r100 & 8) == 0) goto L33;
        String r317 = null;
    L35:
        if ((r100 & 16) == 0) goto L37;
        ECUrlModel r410 = null;
    L39:
        if ((r100 & 32) == 0) goto L41;
        long r411 = 0;
    L43:
        if ((r100 & 64) == 0) goto L45;
        o1 r412 = null;
    L47:
        if ((r100 & 128) == 0) goto L49;
        Boolean r413 = Boolean.FALSE;
    L51:
        if ((r100 & 256) == 0) goto L53;
        String r414 = null;
    L55:
        if ((r100 & 512) == 0) goto L57;
        int r415 = 0;
    L59:
        if ((r100 & 1024) == 0) goto L61;
        Map r416 = null;
    L63:
        if ((r100 & 2048) == 0) goto L65;
        MoreActions r417 = null;
    L67:
        if ((r100 & 4096) == 0) goto L69;
        boolean r418 = false;
    L71:
        if ((r100 & 8192) == 0) goto L73;
        ReplyData r518 = null;
    L74:
        this(r510, r511, r512, r513, r514, r515, r516, r517, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r710, r711, r712, r713, r714, r715, r716, r717, r718, r719, r310, r311, r312, r313, r314, r315, r316, r317, r410, r411, r412, r413, r414, r415, r416, r417, r418, r518);
        return;
    L73:
        r518 = r917;
        goto L74
    L69:
        r418 = r916;
        goto L71
    L65:
        r417 = r915;
        goto L67
    L61:
        r416 = r914;
        goto L63
    L57:
        r415 = r913;
        goto L59
    L53:
        r414 = r912;
        goto L55
    L49:
        r413 = r911;
        goto L51
    L45:
        r412 = r910;
        goto L47
    L41:
        r411 = r819;
        goto L43
    L37:
        r410 = r818;
        goto L39
    L33:
        r317 = r817;
        goto L35
    L29:
        r316 = r816;
        goto L31
    L25:
        r315 = r815;
        goto L27
    L21:
        r314 = r814;
        goto L23
    L17:
        r313 = r813;
        goto L19
    L13:
        r312 = r812;
        goto L15
    L9:
        r311 = r811;
        goto L11
    L5:
        r310 = r810;
        goto L7
    }
}

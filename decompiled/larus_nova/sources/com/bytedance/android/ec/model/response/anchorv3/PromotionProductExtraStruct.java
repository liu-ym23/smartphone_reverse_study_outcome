package com.bytedance.android.ec.model.response.anchorv3;

import androidx.camera.video.AudioStats;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.ec.model.response.anchorv3.matchpurchase.ImageComponent;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000¥\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0003\b¤\u0001\b\u0086\b\u0018\u0000 ç\u00012\u00020\u0001:\u0002è\u0001Bå\u0004\u0012\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010U\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010W\u001a\u00020\u0014\u0012\n\b\u0002\u0010X\u001a\u0004\u0018\u00010\u0016\u0012\u0010\b\u0002\u0010Y\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019\u0012\u0010\b\u0002\u0010Z\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0019\u0012\b\b\u0002\u0010[\u001a\u00020\u001d\u0012\b\b\u0002\u0010\\\u001a\u00020\u001d\u0012\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010^\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010_\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010`\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010a\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010b\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u0010c\u001a\u0004\u0018\u00010(\u0012\n\b\u0002\u0010d\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u0010e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010f\u001a\u0004\u0018\u00010-\u0012\n\b\u0002\u0010g\u001a\u0004\u0018\u00010/\u0012\b\b\u0002\u0010h\u001a\u00020\u0016\u0012\n\b\u0002\u0010i\u001a\u0004\u0018\u000102\u0012\n\b\u0002\u0010j\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010k\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010l\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010\u0019\u0012\u0010\b\u0002\u0010m\u001a\n\u0012\u0004\u0012\u000208\u0018\u00010\u0019\u0012\n\b\u0002\u0010n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010o\u001a\u0004\u0018\u00010;\u0012\n\b\u0002\u0010p\u001a\u0004\u0018\u00010=\u0012\n\b\u0002\u0010q\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010r\u001a\u0004\u0018\u00010@\u0012\n\b\u0002\u0010s\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010t\u001a\u0004\u0018\u00010C\u0012\u0016\b\u0002\u0010u\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010E\u0012\n\b\u0002\u0010v\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010w\u001a\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010x\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010E\u0012\n\b\u0002\u0010y\u001a\u0004\u0018\u00010\u0002¢\u0006\u0006\bå\u0001\u0010æ\u0001J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000eJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u000eJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0014HÆ\u0003J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0019HÆ\u0003J\t\u0010\u001e\u001a\u00020\u001dHÆ\u0003J\t\u0010\u001f\u001a\u00020\u001dHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0012\u0010!\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0004\b!\u0010\u0018J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010#HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010&HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010(HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010*HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010-HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010/HÆ\u0003J\t\u00101\u001a\u00020\u0016HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u000102HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0011\u00107\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010\u0019HÆ\u0003J\u0011\u00109\u001a\n\u0012\u0004\u0012\u000208\u0018\u00010\u0019HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010;HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010=HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010@HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010CHÆ\u0003J\u0017\u0010F\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010EHÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0017\u0010I\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010EHÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0002HÆ\u0003Jì\u0004\u0010z\u001a\u00020\u00002\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010U\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010W\u001a\u00020\u00142\n\b\u0002\u0010X\u001a\u0004\u0018\u00010\u00162\u0010\b\u0002\u0010Y\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00192\u0010\b\u0002\u0010Z\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00192\b\b\u0002\u0010[\u001a\u00020\u001d2\b\b\u0002\u0010\\\u001a\u00020\u001d2\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010^\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010_\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010`\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010b\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010c\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010d\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010f\u001a\u0004\u0018\u00010-2\n\b\u0002\u0010g\u001a\u0004\u0018\u00010/2\b\b\u0002\u0010h\u001a\u00020\u00162\n\b\u0002\u0010i\u001a\u0004\u0018\u0001022\n\b\u0002\u0010j\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010k\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010l\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010\u00192\u0010\b\u0002\u0010m\u001a\n\u0012\u0004\u0012\u000208\u0018\u00010\u00192\n\b\u0002\u0010n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010o\u001a\u0004\u0018\u00010;2\n\b\u0002\u0010p\u001a\u0004\u0018\u00010=2\n\b\u0002\u0010q\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010r\u001a\u0004\u0018\u00010@2\n\b\u0002\u0010s\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010t\u001a\u0004\u0018\u00010C2\u0016\b\u0002\u0010u\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010E2\n\b\u0002\u0010v\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010w\u001a\u0004\u0018\u00010\u00022\u0016\b\u0002\u0010x\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010E2\n\b\u0002\u0010y\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\bz\u0010{J\t\u0010|\u001a\u00020\u0002HÖ\u0001J\t\u0010}\u001a\u00020\u0016HÖ\u0001J\u0013\u0010\u007f\u001a\u00020\f2\b\u0010~\u001a\u0004\u0018\u00010&HÖ\u0003R\u001f\u0010K\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bK\u0010\u0080\u0001\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001f\u0010L\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bL\u0010\u0080\u0001\u001a\u0006\b\u0083\u0001\u0010\u0082\u0001R\u001f\u0010M\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bM\u0010\u0080\u0001\u001a\u0006\b\u0084\u0001\u0010\u0082\u0001R\u001f\u0010N\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bN\u0010\u0080\u0001\u001a\u0006\b\u0085\u0001\u0010\u0082\u0001R\u001f\u0010O\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bO\u0010\u0080\u0001\u001a\u0006\b\u0086\u0001\u0010\u0082\u0001R\u001f\u0010P\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bP\u0010\u0080\u0001\u001a\u0006\b\u0087\u0001\u0010\u0082\u0001R\u001f\u0010Q\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bQ\u0010\u0080\u0001\u001a\u0006\b\u0088\u0001\u0010\u0082\u0001R'\u0010R\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bR\u0010\u0089\u0001\u001a\u0004\bR\u0010\u000e\"\u0006\b\u008a\u0001\u0010\u008b\u0001R(\u0010S\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0005\bS\u0010\u0089\u0001\u001a\u0005\b\u008c\u0001\u0010\u000e\"\u0006\b\u008d\u0001\u0010\u008b\u0001R(\u0010T\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0005\bT\u0010\u0089\u0001\u001a\u0005\b\u008e\u0001\u0010\u000e\"\u0006\b\u008f\u0001\u0010\u008b\u0001R(\u0010U\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0005\bU\u0010\u0089\u0001\u001a\u0005\b\u0090\u0001\u0010\u000e\"\u0006\b\u0091\u0001\u0010\u008b\u0001R)\u0010V\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bV\u0010\u0092\u0001\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001\"\u0006\b\u0095\u0001\u0010\u0096\u0001R\u001d\u0010W\u001a\u00020\u00148\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bW\u0010\u0097\u0001\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001R(\u0010X\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0005\bX\u0010\u009a\u0001\u001a\u0005\b\u009b\u0001\u0010\u0018\"\u0006\b\u009c\u0001\u0010\u009d\u0001R%\u0010Y\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bY\u0010\u009e\u0001\u001a\u0006\b\u009f\u0001\u0010 \u0001R%\u0010Z\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bZ\u0010\u009e\u0001\u001a\u0006\b¡\u0001\u0010 \u0001R\u001d\u0010[\u001a\u00020\u001d8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\b[\u0010¢\u0001\u001a\u0006\b£\u0001\u0010¤\u0001R\u001d\u0010\\\u001a\u00020\u001d8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\b\\\u0010¢\u0001\u001a\u0006\b¥\u0001\u0010¤\u0001R\u001f\u0010]\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\b]\u0010\u0080\u0001\u001a\u0006\b¦\u0001\u0010\u0082\u0001R\u001e\u0010^\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b^\u0010\u009a\u0001\u001a\u0005\b§\u0001\u0010\u0018R\u001f\u0010_\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\b_\u0010\u0080\u0001\u001a\u0006\b¨\u0001\u0010\u0082\u0001R\u001f\u0010`\u001a\u0004\u0018\u00010#8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\b`\u0010©\u0001\u001a\u0006\bª\u0001\u0010«\u0001R)\u0010a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\ba\u0010\u0080\u0001\u001a\u0006\b¬\u0001\u0010\u0082\u0001\"\u0006\b\u00ad\u0001\u0010®\u0001R\u001f\u0010b\u001a\u0004\u0018\u00010&8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bb\u0010¯\u0001\u001a\u0006\b°\u0001\u0010±\u0001R\u001f\u0010c\u001a\u0004\u0018\u00010(8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bc\u0010²\u0001\u001a\u0006\b³\u0001\u0010´\u0001R\u001f\u0010d\u001a\u0004\u0018\u00010*8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bd\u0010µ\u0001\u001a\u0006\b¶\u0001\u0010·\u0001R\u001f\u0010e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\be\u0010\u0080\u0001\u001a\u0006\b¸\u0001\u0010\u0082\u0001R\u001f\u0010f\u001a\u0004\u0018\u00010-8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bf\u0010¹\u0001\u001a\u0006\bº\u0001\u0010»\u0001R)\u0010g\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bg\u0010¼\u0001\u001a\u0006\b½\u0001\u0010¾\u0001\"\u0006\b¿\u0001\u0010À\u0001R'\u0010h\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bh\u0010Á\u0001\u001a\u0006\bÂ\u0001\u0010Ã\u0001\"\u0006\bÄ\u0001\u0010Å\u0001R)\u0010i\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bi\u0010Æ\u0001\u001a\u0006\bÇ\u0001\u0010È\u0001\"\u0006\bÉ\u0001\u0010Ê\u0001R\u001f\u0010j\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bj\u0010\u0080\u0001\u001a\u0006\bË\u0001\u0010\u0082\u0001R\u001f\u0010k\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bk\u0010\u0080\u0001\u001a\u0006\bÌ\u0001\u0010\u0082\u0001R%\u0010l\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bl\u0010\u009e\u0001\u001a\u0006\bÍ\u0001\u0010 \u0001R%\u0010m\u001a\n\u0012\u0004\u0012\u000208\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bm\u0010\u009e\u0001\u001a\u0006\bÎ\u0001\u0010 \u0001R\u001f\u0010n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bn\u0010\u0080\u0001\u001a\u0006\bÏ\u0001\u0010\u0082\u0001R\u001f\u0010o\u001a\u0004\u0018\u00010;8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bo\u0010Ð\u0001\u001a\u0006\bÑ\u0001\u0010Ò\u0001R\u001f\u0010p\u001a\u0004\u0018\u00010=8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bp\u0010Ó\u0001\u001a\u0006\bÔ\u0001\u0010Õ\u0001R\u001f\u0010q\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bq\u0010\u0080\u0001\u001a\u0006\bÖ\u0001\u0010\u0082\u0001R\u001f\u0010r\u001a\u0004\u0018\u00010@8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\br\u0010×\u0001\u001a\u0006\bØ\u0001\u0010Ù\u0001R\u001f\u0010s\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bs\u0010\u0080\u0001\u001a\u0006\bÚ\u0001\u0010\u0082\u0001R\u001f\u0010t\u001a\u0004\u0018\u00010C8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bt\u0010Û\u0001\u001a\u0006\bÜ\u0001\u0010Ý\u0001R+\u0010u\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010E8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bu\u0010Þ\u0001\u001a\u0006\bß\u0001\u0010à\u0001R\u001f\u0010v\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bv\u0010\u0080\u0001\u001a\u0006\bá\u0001\u0010\u0082\u0001R\u001f\u0010w\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bw\u0010\u0080\u0001\u001a\u0006\bâ\u0001\u0010\u0082\u0001R+\u0010x\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010E8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bx\u0010Þ\u0001\u001a\u0006\bã\u0001\u0010à\u0001R\u001f\u0010y\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\by\u0010\u0080\u0001\u001a\u0006\bä\u0001\u0010\u0082\u0001¨\u0006é\u0001"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductExtraStruct;", "Ljava/io/Serializable;", "", "getBuyinTrack", "getCBizCombo", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "", "component8", "()Ljava/lang/Boolean;", "component9", "component10", "component11", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductButtonStruct;", "component12", "", "component13", "", "component14", "()Ljava/lang/Integer;", "", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionLampStruct;", "component15", "component16", "", "component17", "component18", "component19", "component20", "component21", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionBottomButtonStruct;", "component22", "component23", "", "component24", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionAdditionModulesInfoDTO;", "component25", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionCrossBorderStruct;", "component26", "component27", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionReplayInfo;", "component28", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionVideoInfo;", "component29", "component30", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionBigSaleStruct;", "component31", "component32", "component33", "Lcom/bytedance/android/ec/model/response/anchorv3/ImageExtend;", "component34", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionShoppingGuideItemStruct;", "component35", "component36", "Lcom/bytedance/android/ec/model/response/anchorv3/matchpurchase/ImageComponent;", "component37", "Lcom/bytedance/android/ec/model/response/anchorv3/TimeSkuStruct;", "component38", "component39", "Lcom/bytedance/android/ec/model/response/anchorv3/ProductTopicInfo;", "component40", "component41", "Lcom/bytedance/android/ec/model/response/anchorv3/CategoryInfo;", "component42", "", "component43", "component44", "component45", "component46", "component47", "originType", "originId", "allianceKey", "imUrl", "cartUrl", "detailUrl", "shareTemplate", "isVirtualProduct", "alreadyBuy", "needCheck", "favorited", "buyButton", "visitorCount", "payType", "lamps", "mobiles", "reputationScore", "reputationPercentage", "shopId", "applyCoupon", "trackExtra", "shopEntry", "logExtra", "additionModulesData", "additionModulesInfo", "crossborderInfo", "entranceInfo", "replayInfo", "productVideo", "cartNum", "bigSaleInfo", "scene", "innerFlowVerifyInfo", "imageExtend", "shoppingGuideAttr", "shoppingGuideSchema", "combination", "timeSku", "similarProductType", "topicInfo", "marketingChannel", "categoryInfo", "extra", "titleSearchSchema", "imgSearchSchema", "imageSearchParams", "screenshotSearchSchema", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductButtonStruct;JLjava/lang/Integer;Ljava/util/List;Ljava/util/List;DDLjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/android/ec/model/response/anchorv3/PromotionBottomButtonStruct;Ljava/lang/String;Ljava/lang/Object;Lcom/bytedance/android/ec/model/response/anchorv3/PromotionAdditionModulesInfoDTO;Lcom/bytedance/android/ec/model/response/anchorv3/PromotionCrossBorderStruct;Ljava/lang/String;Lcom/bytedance/android/ec/model/response/anchorv3/PromotionReplayInfo;Lcom/bytedance/android/ec/model/response/anchorv3/PromotionVideoInfo;ILcom/bytedance/android/ec/model/response/anchorv3/PromotionBigSaleStruct;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Lcom/bytedance/android/ec/model/response/anchorv3/matchpurchase/ImageComponent;Lcom/bytedance/android/ec/model/response/anchorv3/TimeSkuStruct;Ljava/lang/String;Lcom/bytedance/android/ec/model/response/anchorv3/ProductTopicInfo;Ljava/lang/String;Lcom/bytedance/android/ec/model/response/anchorv3/CategoryInfo;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductExtraStruct;", "toString", "hashCode", "other", "equals", "Ljava/lang/String;", "getOriginType", "()Ljava/lang/String;", "getOriginId", "getAllianceKey", "getImUrl", "getCartUrl", "getDetailUrl", "getShareTemplate", "Ljava/lang/Boolean;", "setVirtualProduct", "(Ljava/lang/Boolean;)V", "getAlreadyBuy", "setAlreadyBuy", "getNeedCheck", "setNeedCheck", "getFavorited", "setFavorited", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductButtonStruct;", "getBuyButton", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductButtonStruct;", "setBuyButton", "(Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductButtonStruct;)V", "J", "getVisitorCount", "()J", "Ljava/lang/Integer;", "getPayType", "setPayType", "(Ljava/lang/Integer;)V", "Ljava/util/List;", "getLamps", "()Ljava/util/List;", "getMobiles", "D", "getReputationScore", "()D", "getReputationPercentage", "getShopId", "getApplyCoupon", "getTrackExtra", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionBottomButtonStruct;", "getShopEntry", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionBottomButtonStruct;", "getLogExtra", "setLogExtra", "(Ljava/lang/String;)V", "Ljava/lang/Object;", "getAdditionModulesData", "()Ljava/lang/Object;", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionAdditionModulesInfoDTO;", "getAdditionModulesInfo", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionAdditionModulesInfoDTO;", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionCrossBorderStruct;", "getCrossborderInfo", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionCrossBorderStruct;", "getEntranceInfo", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionReplayInfo;", "getReplayInfo", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionReplayInfo;", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionVideoInfo;", "getProductVideo", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionVideoInfo;", "setProductVideo", "(Lcom/bytedance/android/ec/model/response/anchorv3/PromotionVideoInfo;)V", "I", "getCartNum", "()I", "setCartNum", "(I)V", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionBigSaleStruct;", "getBigSaleInfo", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionBigSaleStruct;", "setBigSaleInfo", "(Lcom/bytedance/android/ec/model/response/anchorv3/PromotionBigSaleStruct;)V", "getScene", "getInnerFlowVerifyInfo", "getImageExtend", "getShoppingGuideAttr", "getShoppingGuideSchema", "Lcom/bytedance/android/ec/model/response/anchorv3/matchpurchase/ImageComponent;", "getCombination", "()Lcom/bytedance/android/ec/model/response/anchorv3/matchpurchase/ImageComponent;", "Lcom/bytedance/android/ec/model/response/anchorv3/TimeSkuStruct;", "getTimeSku", "()Lcom/bytedance/android/ec/model/response/anchorv3/TimeSkuStruct;", "getSimilarProductType", "Lcom/bytedance/android/ec/model/response/anchorv3/ProductTopicInfo;", "getTopicInfo", "()Lcom/bytedance/android/ec/model/response/anchorv3/ProductTopicInfo;", "getMarketingChannel", "Lcom/bytedance/android/ec/model/response/anchorv3/CategoryInfo;", "getCategoryInfo", "()Lcom/bytedance/android/ec/model/response/anchorv3/CategoryInfo;", "Ljava/util/Map;", "getExtra", "()Ljava/util/Map;", "getTitleSearchSchema", "getImgSearchSchema", "getImageSearchParams", "getScreenshotSearchSchema", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductButtonStruct;JLjava/lang/Integer;Ljava/util/List;Ljava/util/List;DDLjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/android/ec/model/response/anchorv3/PromotionBottomButtonStruct;Ljava/lang/String;Ljava/lang/Object;Lcom/bytedance/android/ec/model/response/anchorv3/PromotionAdditionModulesInfoDTO;Lcom/bytedance/android/ec/model/response/anchorv3/PromotionCrossBorderStruct;Ljava/lang/String;Lcom/bytedance/android/ec/model/response/anchorv3/PromotionReplayInfo;Lcom/bytedance/android/ec/model/response/anchorv3/PromotionVideoInfo;ILcom/bytedance/android/ec/model/response/anchorv3/PromotionBigSaleStruct;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Lcom/bytedance/android/ec/model/response/anchorv3/matchpurchase/ImageComponent;Lcom/bytedance/android/ec/model/response/anchorv3/TimeSkuStruct;Ljava/lang/String;Lcom/bytedance/android/ec/model/response/anchorv3/ProductTopicInfo;Ljava/lang/String;Lcom/bytedance/android/ec/model/response/anchorv3/CategoryInfo;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionProductExtraStruct implements Serializable {
    public static final int CANNOT_APPLY_COUPON = 0;
    public static final int CAN_APPLY_COUPON = 1;
    public static final a Companion = null;
    public static final String INNER_FLOW_REC_COM = "inner_flow_rec_com";

    @SerializedName("addition_modules_data")
    private final Object additionModulesData;

    @SerializedName("modules_info")
    private final PromotionAdditionModulesInfoDTO additionModulesInfo;

    @SerializedName("alliance_key")
    private final String allianceKey;

    @SerializedName("already_buy")
    private Boolean alreadyBuy;

    @SerializedName("apply_coupon")
    private final Integer applyCoupon;

    @SerializedName("big_sale_info")
    private PromotionBigSaleStruct bigSaleInfo;

    @SerializedName("buy_button")
    private PromotionProductButtonStruct buyButton;

    @SerializedName("cart_num")
    private int cartNum;

    @SerializedName("cart_url")
    private final String cartUrl;

    @SerializedName("category_info")
    private final CategoryInfo categoryInfo;

    @SerializedName("combination")
    private final ImageComponent combination;

    @SerializedName("crossborder_info")
    private final PromotionCrossBorderStruct crossborderInfo;

    @SerializedName("detail_url")
    private final String detailUrl;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO)
    private final String entranceInfo;

    @SerializedName("extra")
    private final Map<String, String> extra;

    @SerializedName("favorited")
    private Boolean favorited;

    @SerializedName("im_url")
    private final String imUrl;

    @SerializedName("image_extend")
    private final List<ImageExtend> imageExtend;

    @SerializedName("img_search_params")
    private final Map<String, String> imageSearchParams;

    @SerializedName("img_search_schema")
    private final String imgSearchSchema;

    @SerializedName("verify_info")
    private final String innerFlowVerifyInfo;

    @SerializedName("is_virtual_product")
    private Boolean isVirtualProduct;

    @SerializedName("lamps")
    private final List<PromotionLampStruct> lamps;

    @SerializedName("log_extra")
    private String logExtra;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_MARKET_CHANNEL)
    private final String marketingChannel;

    @SerializedName("mobiles")
    private final List<String> mobiles;

    @SerializedName("need_check")
    private Boolean needCheck;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_ORIGIN_ID)
    private final String originId;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_ORIGIN_TYPE)
    private final String originType;

    @SerializedName("pay_type")
    private Integer payType;

    @SerializedName("product_video")
    private PromotionVideoInfo productVideo;

    @SerializedName("replay_info")
    private final PromotionReplayInfo replayInfo;

    @SerializedName("reputation_percentage")
    private final double reputationPercentage;

    @SerializedName("reputation_score")
    private final double reputationScore;

    @SerializedName("scene")
    private final String scene;

    @SerializedName("screenshot_search_schema")
    private final String screenshotSearchSchema;

    @SerializedName("share_template")
    private final String shareTemplate;

    @SerializedName("shop_entry")
    private final PromotionBottomButtonStruct shopEntry;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID)
    private final String shopId;

    @SerializedName("shopping_guide_attr")
    private final List<PromotionShoppingGuideItemStruct> shoppingGuideAttr;

    @SerializedName("shopping_guide_schema")
    private final String shoppingGuideSchema;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SIMILAR_TYPE)
    private final String similarProductType;

    @SerializedName("time_sku")
    private final TimeSkuStruct timeSku;

    @SerializedName("title_search_schema")
    private final String titleSearchSchema;

    @SerializedName("topic_info")
    private final ProductTopicInfo topicInfo;

    @SerializedName("track_extra")
    private final String trackExtra;

    @SerializedName("visitor_count")
    private final long visitorCount;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public PromotionProductExtraStruct() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 32767, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PromotionProductExtraStruct copy$default(PromotionProductExtraStruct r110, String r111, String r112, String r210, String r211, String r212, String r213, String r214, Boolean r215, Boolean r216, Boolean r217, Boolean r218, PromotionProductButtonStruct r219, long r310, Integer r311, List r312, List r313, double r314, double r315, String r316, Integer r410, String r411, PromotionBottomButtonStruct r412, String r413, Object r414, PromotionAdditionModulesInfoDTO r415, PromotionCrossBorderStruct r416, String r417, PromotionReplayInfo r418, PromotionVideoInfo r419, int r510, PromotionBigSaleStruct r511, String r512, String r513, List r514, List r515, String r516, ImageComponent r517, TimeSkuStruct r518, String r519, ProductTopicInfo r610, String r611, CategoryInfo r612, Map r613, String r614, String r615, Map r616, String r617, int r618, int r619, Object r710) {
        if ((r618 & 1) == 0) goto L5;
        String r100 = r110.originType;
    L7:
        if ((r618 & 2) == 0) goto L9;
        String r101 = r110.originId;
    L11:
        if ((r618 & 4) == 0) goto L13;
        String r102 = r110.allianceKey;
    L15:
        if ((r618 & 8) == 0) goto L17;
        String r103 = r110.imUrl;
    L19:
        if ((r618 & 16) == 0) goto L21;
        String r104 = r110.cartUrl;
    L23:
        if ((r618 & 32) == 0) goto L25;
        String r105 = r110.detailUrl;
    L27:
        if ((r618 & 64) == 0) goto L29;
        String r106 = r110.shareTemplate;
    L31:
        if ((r618 & 128) == 0) goto L33;
        Boolean r113 = r110.isVirtualProduct;
    L35:
        if ((r618 & 256) == 0) goto L37;
        Boolean r114 = r110.alreadyBuy;
    L39:
        if ((r618 & 512) == 0) goto L41;
        Boolean r115 = r110.needCheck;
    L43:
        if ((r618 & 1024) == 0) goto L45;
        Boolean r116 = r110.favorited;
    L47:
        if ((r618 & 2048) == 0) goto L49;
        PromotionProductButtonStruct r117 = r110.buyButton;
    L50:
        PromotionProductButtonStruct r220 = r117;
        if ((r618 & 4096) == 0) goto L53;
        long r118 = r110.visitorCount;
    L54:
        long r317 = r118;
        if ((r618 & 8192) == 0) goto L57;
        Integer r119 = r110.payType;
    L59:
        if ((r618 & 16384) == 0) goto L61;
        List r120 = r110.lamps;
    L62:
        List r318 = r120;
        if ((r618 & 32768) == 0) goto L65;
        List r121 = r110.mobiles;
    L66:
        Integer r319 = r119;
        List r320 = r121;
        if ((r618 & 65536) == 0) goto L69;
        double r122 = r110.reputationScore;
    L70:
        double r321 = r122;
        if ((r618 & 131072) == 0) goto L73;
        double r123 = r110.reputationPercentage;
    L74:
        double r322 = r123;
        if ((r618 & 262144) == 0) goto L77;
        String r124 = r110.shopId;
    L79:
        if ((524288 & r618) == 0) goto L81;
        Integer r125 = r110.applyCoupon;
    L82:
        Integer r420 = r125;
        if ((r618 & 1048576) == 0) goto L85;
        String r126 = r110.trackExtra;
    L86:
        String r421 = r126;
        if ((r618 & 2097152) == 0) goto L89;
        PromotionBottomButtonStruct r127 = r110.shopEntry;
    L90:
        PromotionBottomButtonStruct r422 = r127;
        if ((r618 & 4194304) == 0) goto L93;
        String r128 = r110.logExtra;
    L94:
        String r423 = r128;
        if ((r618 & 8388608) == 0) goto L97;
        Object r129 = r110.additionModulesData;
    L98:
        Object r424 = r129;
        if ((r618 & 16777216) == 0) goto L101;
        PromotionAdditionModulesInfoDTO r130 = r110.additionModulesInfo;
    L102:
        PromotionAdditionModulesInfoDTO r425 = r130;
        if ((r618 & 33554432) == 0) goto L105;
        PromotionCrossBorderStruct r131 = r110.crossborderInfo;
    L106:
        PromotionCrossBorderStruct r426 = r131;
        if ((r618 & 67108864) == 0) goto L109;
        String r132 = r110.entranceInfo;
    L110:
        String r427 = r132;
        if ((r618 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        PromotionReplayInfo r133 = r110.replayInfo;
    L114:
        PromotionReplayInfo r428 = r133;
        if ((r618 & 268435456) == 0) goto L117;
        PromotionVideoInfo r134 = r110.productVideo;
    L118:
        PromotionVideoInfo r429 = r134;
        if ((r618 & 536870912) == 0) goto L121;
        int r135 = r110.cartNum;
    L122:
        int r520 = r135;
        if ((r618 & 1073741824) == 0) goto L125;
        PromotionBigSaleStruct r136 = r110.bigSaleInfo;
    L127:
        if ((r618 & Integer.MIN_VALUE) == 0) goto L129;
        String r107 = r110.scene;
    L130:
        String r521 = r107;
        if ((r619 & 1) == 0) goto L133;
        String r108 = r110.innerFlowVerifyInfo;
    L134:
        String r522 = r108;
        if ((r619 & 2) == 0) goto L137;
        List r109 = r110.imageExtend;
    L138:
        List r523 = r109;
        if ((r619 & 4) == 0) goto L141;
        List r137 = r110.shoppingGuideAttr;
    L142:
        List r524 = r137;
        if ((r619 & 8) == 0) goto L145;
        String r138 = r110.shoppingGuideSchema;
    L146:
        String r525 = r138;
        if ((r619 & 16) == 0) goto L149;
        ImageComponent r139 = r110.combination;
    L150:
        ImageComponent r526 = r139;
        if ((r619 & 32) == 0) goto L153;
        TimeSkuStruct r140 = r110.timeSku;
    L154:
        TimeSkuStruct r527 = r140;
        if ((r619 & 64) == 0) goto L157;
        String r141 = r110.similarProductType;
    L158:
        String r528 = r141;
        if ((r619 & 128) == 0) goto L161;
        ProductTopicInfo r142 = r110.topicInfo;
    L162:
        ProductTopicInfo r620 = r142;
        if ((r619 & 256) == 0) goto L165;
        String r143 = r110.marketingChannel;
    L166:
        String r621 = r143;
        if ((r619 & 512) == 0) goto L169;
        CategoryInfo r144 = r110.categoryInfo;
    L170:
        CategoryInfo r622 = r144;
        if ((r619 & 1024) == 0) goto L173;
        Map r145 = r110.extra;
    L174:
        Map r623 = r145;
        if ((r619 & 2048) == 0) goto L177;
        String r146 = r110.titleSearchSchema;
    L178:
        String r624 = r146;
        if ((r619 & 4096) == 0) goto L181;
        String r147 = r110.imgSearchSchema;
    L182:
        String r625 = r147;
        if ((r619 & 8192) == 0) goto L185;
        Map r148 = r110.imageSearchParams;
    L187:
        if ((r619 & 16384) == 0) goto L189;
        String r149 = r110.screenshotSearchSchema;
    L191:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r113, r114, r115, r116, r220, r317, r319, r318, r320, r321, r322, r124, r420, r421, r422, r423, r424, r425, r426, r427, r428, r429, r520, r136, r521, r522, r523, r524, r525, r526, r527, r528, r620, r621, r622, r623, r624, r625, r148, r149);
    L189:
        r149 = r617;
        goto L191
    L185:
        r148 = r616;
        goto L187
    L181:
        r147 = r615;
        goto L182
    L177:
        r146 = r614;
        goto L178
    L173:
        r145 = r613;
        goto L174
    L169:
        r144 = r612;
        goto L170
    L165:
        r143 = r611;
        goto L166
    L161:
        r142 = r610;
        goto L162
    L157:
        r141 = r519;
        goto L158
    L153:
        r140 = r518;
        goto L154
    L149:
        r139 = r517;
        goto L150
    L145:
        r138 = r516;
        goto L146
    L141:
        r137 = r515;
        goto L142
    L137:
        r109 = r514;
        goto L138
    L133:
        r108 = r513;
        goto L134
    L129:
        r107 = r512;
        goto L130
    L125:
        r136 = r511;
        goto L127
    L121:
        r135 = r510;
        goto L122
    L117:
        r134 = r419;
        goto L118
    L113:
        r133 = r418;
        goto L114
    L109:
        r132 = r417;
        goto L110
    L105:
        r131 = r416;
        goto L106
    L101:
        r130 = r415;
        goto L102
    L97:
        r129 = r414;
        goto L98
    L93:
        r128 = r413;
        goto L94
    L89:
        r127 = r412;
        goto L90
    L85:
        r126 = r411;
        goto L86
    L81:
        r125 = r410;
        goto L82
    L77:
        r124 = r316;
        goto L79
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
        goto L59
    L53:
        r118 = r310;
        goto L54
    L49:
        r117 = r219;
        goto L50
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

    public final String component1() {
        return this.originType;
    }

    public final Boolean component10() {
        return this.needCheck;
    }

    public final Boolean component11() {
        return this.favorited;
    }

    public final PromotionProductButtonStruct component12() {
        return this.buyButton;
    }

    public final long component13() {
        return this.visitorCount;
    }

    public final Integer component14() {
        return this.payType;
    }

    public final List<PromotionLampStruct> component15() {
        return this.lamps;
    }

    public final List<String> component16() {
        return this.mobiles;
    }

    public final double component17() {
        return this.reputationScore;
    }

    public final double component18() {
        return this.reputationPercentage;
    }

    public final String component19() {
        return this.shopId;
    }

    public final String component2() {
        return this.originId;
    }

    public final Integer component20() {
        return this.applyCoupon;
    }

    public final String component21() {
        return this.trackExtra;
    }

    public final PromotionBottomButtonStruct component22() {
        return this.shopEntry;
    }

    public final String component23() {
        return this.logExtra;
    }

    public final Object component24() {
        return this.additionModulesData;
    }

    public final PromotionAdditionModulesInfoDTO component25() {
        return this.additionModulesInfo;
    }

    public final PromotionCrossBorderStruct component26() {
        return this.crossborderInfo;
    }

    public final String component27() {
        return this.entranceInfo;
    }

    public final PromotionReplayInfo component28() {
        return this.replayInfo;
    }

    public final PromotionVideoInfo component29() {
        return this.productVideo;
    }

    public final String component3() {
        return this.allianceKey;
    }

    public final int component30() {
        return this.cartNum;
    }

    public final PromotionBigSaleStruct component31() {
        return this.bigSaleInfo;
    }

    public final String component32() {
        return this.scene;
    }

    public final String component33() {
        return this.innerFlowVerifyInfo;
    }

    public final List<ImageExtend> component34() {
        return this.imageExtend;
    }

    public final List<PromotionShoppingGuideItemStruct> component35() {
        return this.shoppingGuideAttr;
    }

    public final String component36() {
        return this.shoppingGuideSchema;
    }

    public final ImageComponent component37() {
        return this.combination;
    }

    public final TimeSkuStruct component38() {
        return this.timeSku;
    }

    public final String component39() {
        return this.similarProductType;
    }

    public final String component4() {
        return this.imUrl;
    }

    public final ProductTopicInfo component40() {
        return this.topicInfo;
    }

    public final String component41() {
        return this.marketingChannel;
    }

    public final CategoryInfo component42() {
        return this.categoryInfo;
    }

    public final Map<String, String> component43() {
        return this.extra;
    }

    public final String component44() {
        return this.titleSearchSchema;
    }

    public final String component45() {
        return this.imgSearchSchema;
    }

    public final Map<String, String> component46() {
        return this.imageSearchParams;
    }

    public final String component47() {
        return this.screenshotSearchSchema;
    }

    public final String component5() {
        return this.cartUrl;
    }

    public final String component6() {
        return this.detailUrl;
    }

    public final String component7() {
        return this.shareTemplate;
    }

    public final Boolean component8() {
        return this.isVirtualProduct;
    }

    public final Boolean component9() {
        return this.alreadyBuy;
    }

    public final PromotionProductExtraStruct copy(String r510, String r511, String r512, String r513, String r514, String r515, String r516, Boolean r610, Boolean r611, Boolean r612, Boolean r613, PromotionProductButtonStruct r614, long r615, Integer r616, List<PromotionLampStruct> r617, List<String> r618, double r710, double r711, String r712, Integer r713, String r714, PromotionBottomButtonStruct r715, String r716, Object r717, PromotionAdditionModulesInfoDTO r810, PromotionCrossBorderStruct r811, String r812, PromotionReplayInfo r813, PromotionVideoInfo r814, int r815, PromotionBigSaleStruct r816, String r817, String r818, List<ImageExtend> r819, List<PromotionShoppingGuideItemStruct> r910, String r911, ImageComponent r912, TimeSkuStruct r913, String r914, ProductTopicInfo r915, String r916, CategoryInfo r917, Map<String, String> r918, String r919, String r100, Map<String, String> r101, String r102) {
        return new PromotionProductExtraStruct(r510, r511, r512, r513, r514, r515, r516, r610, r611, r612, r613, r614, r615, r616, r617, r618, r710, r711, r712, r713, r714, r715, r716, r717, r810, r811, r812, r813, r814, r815, r816, r817, r818, r819, r910, r911, r912, r913, r914, r915, r916, r917, r918, r919, r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PromotionProductExtraStruct) == false) goto L100;
        PromotionProductExtraStruct r101 = (PromotionProductExtraStruct) r100;
        if (Intrinsics.areEqual(this.originType, r101.originType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.originId, r101.originId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.allianceKey, r101.allianceKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.imUrl, r101.imUrl) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.cartUrl, r101.cartUrl) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.detailUrl, r101.detailUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.shareTemplate, r101.shareTemplate) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.isVirtualProduct, r101.isVirtualProduct) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.alreadyBuy, r101.alreadyBuy) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.needCheck, r101.needCheck) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.favorited, r101.favorited) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.buyButton, r101.buyButton) == true) goto L30;
        return false;
    L30:
        if (this.visitorCount == r101.visitorCount) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.payType, r101.payType) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.lamps, r101.lamps) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.mobiles, r101.mobiles) == true) goto L38;
        return false;
    L38:
        if (Double.compare(this.reputationScore, r101.reputationScore) == 0) goto L40;
        return false;
    L40:
        if (Double.compare(this.reputationPercentage, r101.reputationPercentage) == 0) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.shopId, r101.shopId) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.applyCoupon, r101.applyCoupon) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.trackExtra, r101.trackExtra) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.shopEntry, r101.shopEntry) == true) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.logExtra, r101.logExtra) == true) goto L52;
        return false;
    L52:
        if (Intrinsics.areEqual(this.additionModulesData, r101.additionModulesData) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.additionModulesInfo, r101.additionModulesInfo) == true) goto L56;
        return false;
    L56:
        if (Intrinsics.areEqual(this.crossborderInfo, r101.crossborderInfo) == true) goto L58;
        return false;
    L58:
        if (Intrinsics.areEqual(this.entranceInfo, r101.entranceInfo) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.replayInfo, r101.replayInfo) == true) goto L62;
        return false;
    L62:
        if (Intrinsics.areEqual(this.productVideo, r101.productVideo) == true) goto L64;
        return false;
    L64:
        if (this.cartNum == r101.cartNum) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.bigSaleInfo, r101.bigSaleInfo) == true) goto L68;
        return false;
    L68:
        if (Intrinsics.areEqual(this.scene, r101.scene) == true) goto L70;
        return false;
    L70:
        if (Intrinsics.areEqual(this.innerFlowVerifyInfo, r101.innerFlowVerifyInfo) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.imageExtend, r101.imageExtend) == true) goto L74;
        return false;
    L74:
        if (Intrinsics.areEqual(this.shoppingGuideAttr, r101.shoppingGuideAttr) == true) goto L76;
        return false;
    L76:
        if (Intrinsics.areEqual(this.shoppingGuideSchema, r101.shoppingGuideSchema) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.combination, r101.combination) == true) goto L80;
        return false;
    L80:
        if (Intrinsics.areEqual(this.timeSku, r101.timeSku) == true) goto L82;
        return false;
    L82:
        if (Intrinsics.areEqual(this.similarProductType, r101.similarProductType) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.topicInfo, r101.topicInfo) == true) goto L86;
        return false;
    L86:
        if (Intrinsics.areEqual(this.marketingChannel, r101.marketingChannel) == true) goto L88;
        return false;
    L88:
        if (Intrinsics.areEqual(this.categoryInfo, r101.categoryInfo) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L92;
        return false;
    L92:
        if (Intrinsics.areEqual(this.titleSearchSchema, r101.titleSearchSchema) == true) goto L94;
        return false;
    L94:
        if (Intrinsics.areEqual(this.imgSearchSchema, r101.imgSearchSchema) == true) goto L96;
        return false;
    L96:
        if (Intrinsics.areEqual(this.imageSearchParams, r101.imageSearchParams) == true) goto L98;
        return false;
    L98:
        if (Intrinsics.areEqual(this.screenshotSearchSchema, r101.screenshotSearchSchema) == true) goto L151;
        return false;
    L151:
        return true;
    L100:
        return false;
    }

    public int hashCode() {
        String r100 = this.originType;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.originId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.allianceKey;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.imUrl;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.cartUrl;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.detailUrl;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.shareTemplate;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Boolean r122 = this.isVirtualProduct;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        Boolean r125 = this.alreadyBuy;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        Boolean r128 = this.needCheck;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        Boolean r131 = this.favorited;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        PromotionProductButtonStruct r134 = this.buyButton;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        long r137 = this.visitorCount;
        int r138 = (r136 + ((int) (r137 ^ (r137 >>> 32)))) * 31;
        Integer r139 = this.payType;
        if (r139 == null) goto L53;
        int r140 = r139.hashCode();
    L54:
        int r141 = (r138 + r140) * 31;
        List<PromotionLampStruct> r142 = this.lamps;
        if (r142 == null) goto L57;
        int r143 = r142.hashCode();
    L58:
        int r144 = (r141 + r143) * 31;
        List<String> r145 = this.mobiles;
        if (r145 == null) goto L61;
        int r146 = r145.hashCode();
    L62:
        int r147 = (r144 + r146) * 31;
        long r148 = Double.doubleToLongBits(this.reputationScore);
        int r149 = (r147 + ((int) (r148 ^ (r148 >>> 32)))) * 31;
        long r150 = Double.doubleToLongBits(this.reputationPercentage);
        int r151 = (r149 + ((int) (r150 ^ (r150 >>> 32)))) * 31;
        String r152 = this.shopId;
        if (r152 == null) goto L65;
        int r153 = r152.hashCode();
    L66:
        int r154 = (r151 + r153) * 31;
        Integer r155 = this.applyCoupon;
        if (r155 == null) goto L69;
        int r156 = r155.hashCode();
    L70:
        int r157 = (r154 + r156) * 31;
        String r158 = this.trackExtra;
        if (r158 == null) goto L73;
        int r159 = r158.hashCode();
    L74:
        int r160 = (r157 + r159) * 31;
        PromotionBottomButtonStruct r161 = this.shopEntry;
        if (r161 == null) goto L77;
        int r162 = r161.hashCode();
    L78:
        int r163 = (r160 + r162) * 31;
        String r164 = this.logExtra;
        if (r164 == null) goto L81;
        int r165 = r164.hashCode();
    L82:
        int r166 = (r163 + r165) * 31;
        Object r167 = this.additionModulesData;
        if (r167 == null) goto L85;
        int r168 = r167.hashCode();
    L86:
        int r169 = (r166 + r168) * 31;
        PromotionAdditionModulesInfoDTO r170 = this.additionModulesInfo;
        if (r170 == null) goto L89;
        int r171 = r170.hashCode();
    L90:
        int r172 = (r169 + r171) * 31;
        PromotionCrossBorderStruct r173 = this.crossborderInfo;
        if (r173 == null) goto L93;
        int r174 = r173.hashCode();
    L94:
        int r175 = (r172 + r174) * 31;
        String r176 = this.entranceInfo;
        if (r176 == null) goto L97;
        int r177 = r176.hashCode();
    L98:
        int r178 = (r175 + r177) * 31;
        PromotionReplayInfo r179 = this.replayInfo;
        if (r179 == null) goto L101;
        int r180 = r179.hashCode();
    L102:
        int r181 = (r178 + r180) * 31;
        PromotionVideoInfo r182 = this.productVideo;
        if (r182 == null) goto L105;
        int r183 = r182.hashCode();
    L106:
        int r184 = (((r181 + r183) * 31) + this.cartNum) * 31;
        PromotionBigSaleStruct r185 = this.bigSaleInfo;
        if (r185 == null) goto L109;
        int r186 = r185.hashCode();
    L110:
        int r187 = (r184 + r186) * 31;
        String r188 = this.scene;
        if (r188 == null) goto L113;
        int r189 = r188.hashCode();
    L114:
        int r190 = (r187 + r189) * 31;
        String r191 = this.innerFlowVerifyInfo;
        if (r191 == null) goto L117;
        int r192 = r191.hashCode();
    L118:
        int r193 = (r190 + r192) * 31;
        List<ImageExtend> r194 = this.imageExtend;
        if (r194 == null) goto L121;
        int r195 = r194.hashCode();
    L122:
        int r196 = (r193 + r195) * 31;
        List<PromotionShoppingGuideItemStruct> r197 = this.shoppingGuideAttr;
        if (r197 == null) goto L125;
        int r198 = r197.hashCode();
    L126:
        int r199 = (r196 + r198) * 31;
        String r200 = this.shoppingGuideSchema;
        if (r200 == null) goto L129;
        int r201 = r200.hashCode();
    L130:
        int r202 = (r199 + r201) * 31;
        ImageComponent r203 = this.combination;
        if (r203 == null) goto L133;
        int r204 = r203.hashCode();
    L134:
        int r205 = (r202 + r204) * 31;
        TimeSkuStruct r206 = this.timeSku;
        if (r206 == null) goto L137;
        int r207 = r206.hashCode();
    L138:
        int r208 = (r205 + r207) * 31;
        String r209 = this.similarProductType;
        if (r209 == null) goto L141;
        int r210 = r209.hashCode();
    L142:
        int r211 = (r208 + r210) * 31;
        ProductTopicInfo r212 = this.topicInfo;
        if (r212 == null) goto L145;
        int r213 = r212.hashCode();
    L146:
        int r214 = (r211 + r213) * 31;
        String r215 = this.marketingChannel;
        if (r215 == null) goto L149;
        int r216 = r215.hashCode();
    L150:
        int r217 = (r214 + r216) * 31;
        CategoryInfo r218 = this.categoryInfo;
        if (r218 == null) goto L153;
        int r219 = r218.hashCode();
    L154:
        int r220 = (r217 + r219) * 31;
        Map<String, String> r221 = this.extra;
        if (r221 == null) goto L157;
        int r222 = r221.hashCode();
    L158:
        int r223 = (r220 + r222) * 31;
        String r224 = this.titleSearchSchema;
        if (r224 == null) goto L161;
        int r225 = r224.hashCode();
    L162:
        int r226 = (r223 + r225) * 31;
        String r227 = this.imgSearchSchema;
        if (r227 == null) goto L165;
        int r228 = r227.hashCode();
    L166:
        int r229 = (r226 + r228) * 31;
        Map<String, String> r230 = this.imageSearchParams;
        if (r230 == null) goto L169;
        int r231 = r230.hashCode();
    L170:
        int r232 = (r229 + r231) * 31;
        String r233 = this.screenshotSearchSchema;
        if (r233 == null) goto L174;
        r101 = r233.hashCode();
    L174:
        return r232 + r101;
    L169:
        r231 = 0;
        goto L170
    L165:
        r228 = 0;
        goto L166
    L161:
        r225 = 0;
        goto L162
    L157:
        r222 = 0;
        goto L158
    L153:
        r219 = 0;
        goto L154
    L149:
        r216 = 0;
        goto L150
    L145:
        r213 = 0;
        goto L146
    L141:
        r210 = 0;
        goto L142
    L137:
        r207 = 0;
        goto L138
    L133:
        r204 = 0;
        goto L134
    L129:
        r201 = 0;
        goto L130
    L125:
        r198 = 0;
        goto L126
    L121:
        r195 = 0;
        goto L122
    L117:
        r192 = 0;
        goto L118
    L113:
        r189 = 0;
        goto L114
    L109:
        r186 = 0;
        goto L110
    L105:
        r183 = 0;
        goto L106
    L101:
        r180 = 0;
        goto L102
    L97:
        r177 = 0;
        goto L98
    L93:
        r174 = 0;
        goto L94
    L89:
        r171 = 0;
        goto L90
    L85:
        r168 = 0;
        goto L86
    L81:
        r165 = 0;
        goto L82
    L77:
        r162 = 0;
        goto L78
    L73:
        r159 = 0;
        goto L74
    L69:
        r156 = 0;
        goto L70
    L65:
        r153 = 0;
        goto L66
    L61:
        r146 = 0;
        goto L62
    L57:
        r143 = 0;
        goto L58
    L53:
        r140 = 0;
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
        return "PromotionProductExtraStruct(originType=" + this.originType + ", originId=" + this.originId + ", allianceKey=" + this.allianceKey + ", imUrl=" + this.imUrl + ", cartUrl=" + this.cartUrl + ", detailUrl=" + this.detailUrl + ", shareTemplate=" + this.shareTemplate + ", isVirtualProduct=" + this.isVirtualProduct + ", alreadyBuy=" + this.alreadyBuy + ", needCheck=" + this.needCheck + ", favorited=" + this.favorited + ", buyButton=" + this.buyButton + ", visitorCount=" + this.visitorCount + ", payType=" + this.payType + ", lamps=" + this.lamps + ", mobiles=" + this.mobiles + ", reputationScore=" + this.reputationScore + ", reputationPercentage=" + this.reputationPercentage + ", shopId=" + this.shopId + ", applyCoupon=" + this.applyCoupon + ", trackExtra=" + this.trackExtra + ", shopEntry=" + this.shopEntry + ", logExtra=" + this.logExtra + ", additionModulesData=" + this.additionModulesData + ", additionModulesInfo=" + this.additionModulesInfo + ", crossborderInfo=" + this.crossborderInfo + ", entranceInfo=" + this.entranceInfo + ", replayInfo=" + this.replayInfo + ", productVideo=" + this.productVideo + ", cartNum=" + this.cartNum + ", bigSaleInfo=" + this.bigSaleInfo + ", scene=" + this.scene + ", innerFlowVerifyInfo=" + this.innerFlowVerifyInfo + ", imageExtend=" + this.imageExtend + ", shoppingGuideAttr=" + this.shoppingGuideAttr + ", shoppingGuideSchema=" + this.shoppingGuideSchema + ", combination=" + this.combination + ", timeSku=" + this.timeSku + ", similarProductType=" + this.similarProductType + ", topicInfo=" + this.topicInfo + ", marketingChannel=" + this.marketingChannel + ", categoryInfo=" + this.categoryInfo + ", extra=" + this.extra + ", titleSearchSchema=" + this.titleSearchSchema + ", imgSearchSchema=" + this.imgSearchSchema + ", imageSearchParams=" + this.imageSearchParams + ", screenshotSearchSchema=" + this.screenshotSearchSchema + ")";
    }

    public final String getBuyinTrack() {
        if (this.trackExtra != null) goto L8;
        return null;
    L8:
        return JSONObjectProtectorUtils.getString(new JSONObject(this.trackExtra), com.bytedance.android.ec.core.event.a.KEY_BUYIN_TRACK);
    L7:
        return null;
    }

    public final String getCBizCombo() {
        if (this.trackExtra != null) goto L8;
        return null;
    L8:
        return JSONObjectProtectorUtils.getString(new JSONObject(this.trackExtra), com.bytedance.android.ec.core.event.a.KEY_C_BIZ_COMBO);
    L7:
        return null;
    }

    public final Object getAdditionModulesData() {
        return this.additionModulesData;
    }

    public final PromotionAdditionModulesInfoDTO getAdditionModulesInfo() {
        return this.additionModulesInfo;
    }

    public final String getAllianceKey() {
        return this.allianceKey;
    }

    public final Boolean getAlreadyBuy() {
        return this.alreadyBuy;
    }

    public final Integer getApplyCoupon() {
        return this.applyCoupon;
    }

    public final PromotionBigSaleStruct getBigSaleInfo() {
        return this.bigSaleInfo;
    }

    public final PromotionProductButtonStruct getBuyButton() {
        return this.buyButton;
    }

    public final int getCartNum() {
        return this.cartNum;
    }

    public final String getCartUrl() {
        return this.cartUrl;
    }

    public final CategoryInfo getCategoryInfo() {
        return this.categoryInfo;
    }

    public final ImageComponent getCombination() {
        return this.combination;
    }

    public final PromotionCrossBorderStruct getCrossborderInfo() {
        return this.crossborderInfo;
    }

    public final String getDetailUrl() {
        return this.detailUrl;
    }

    public final String getEntranceInfo() {
        return this.entranceInfo;
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final Boolean getFavorited() {
        return this.favorited;
    }

    public final String getImUrl() {
        return this.imUrl;
    }

    public final List<ImageExtend> getImageExtend() {
        return this.imageExtend;
    }

    public final Map<String, String> getImageSearchParams() {
        return this.imageSearchParams;
    }

    public final String getImgSearchSchema() {
        return this.imgSearchSchema;
    }

    public final String getInnerFlowVerifyInfo() {
        return this.innerFlowVerifyInfo;
    }

    public final List<PromotionLampStruct> getLamps() {
        return this.lamps;
    }

    public final String getLogExtra() {
        return this.logExtra;
    }

    public final String getMarketingChannel() {
        return this.marketingChannel;
    }

    public final List<String> getMobiles() {
        return this.mobiles;
    }

    public final Boolean getNeedCheck() {
        return this.needCheck;
    }

    public final String getOriginId() {
        return this.originId;
    }

    public final String getOriginType() {
        return this.originType;
    }

    public final Integer getPayType() {
        return this.payType;
    }

    public final PromotionVideoInfo getProductVideo() {
        return this.productVideo;
    }

    public final PromotionReplayInfo getReplayInfo() {
        return this.replayInfo;
    }

    public final double getReputationPercentage() {
        return this.reputationPercentage;
    }

    public final double getReputationScore() {
        return this.reputationScore;
    }

    public final String getScene() {
        return this.scene;
    }

    public final String getScreenshotSearchSchema() {
        return this.screenshotSearchSchema;
    }

    public final String getShareTemplate() {
        return this.shareTemplate;
    }

    public final PromotionBottomButtonStruct getShopEntry() {
        return this.shopEntry;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final List<PromotionShoppingGuideItemStruct> getShoppingGuideAttr() {
        return this.shoppingGuideAttr;
    }

    public final String getShoppingGuideSchema() {
        return this.shoppingGuideSchema;
    }

    public final String getSimilarProductType() {
        return this.similarProductType;
    }

    public final TimeSkuStruct getTimeSku() {
        return this.timeSku;
    }

    public final String getTitleSearchSchema() {
        return this.titleSearchSchema;
    }

    public final ProductTopicInfo getTopicInfo() {
        return this.topicInfo;
    }

    public final String getTrackExtra() {
        return this.trackExtra;
    }

    public final long getVisitorCount() {
        return this.visitorCount;
    }

    public final Boolean isVirtualProduct() {
        return this.isVirtualProduct;
    }

    public final void setAlreadyBuy(Boolean r100) {
        this.alreadyBuy = r100;
    }

    public final void setBigSaleInfo(PromotionBigSaleStruct r100) {
        this.bigSaleInfo = r100;
    }

    public final void setBuyButton(PromotionProductButtonStruct r100) {
        this.buyButton = r100;
    }

    public final void setCartNum(int r100) {
        this.cartNum = r100;
    }

    public final void setFavorited(Boolean r100) {
        this.favorited = r100;
    }

    public final void setLogExtra(String r100) {
        this.logExtra = r100;
    }

    public final void setNeedCheck(Boolean r100) {
        this.needCheck = r100;
    }

    public final void setPayType(Integer r100) {
        this.payType = r100;
    }

    public final void setProductVideo(PromotionVideoInfo r100) {
        this.productVideo = r100;
    }

    public final void setVirtualProduct(Boolean r100) {
        this.isVirtualProduct = r100;
    }

    public PromotionProductExtraStruct(String r100, String r101, String r102, String r103, String r104, String r105, String r110, Boolean r111, Boolean r112, Boolean r113, Boolean r114, PromotionProductButtonStruct r115, long r116, Integer r117, List<PromotionLampStruct> r118, List<String> r210, double r211, double r212, String r213, Integer r214, String r215, PromotionBottomButtonStruct r216, String r217, Object r310, PromotionAdditionModulesInfoDTO r311, PromotionCrossBorderStruct r312, String r313, PromotionReplayInfo r314, PromotionVideoInfo r315, int r316, PromotionBigSaleStruct r317, String r318, String r319, List<ImageExtend> r410, List<PromotionShoppingGuideItemStruct> r411, String r412, ImageComponent r413, TimeSkuStruct r414, String r415, ProductTopicInfo r416, String r417, CategoryInfo r418, Map<String, String> r419, String r510, String r511, Map<String, String> r512, String r513) {
        this.originType = r100;
        this.originId = r101;
        this.allianceKey = r102;
        this.imUrl = r103;
        this.cartUrl = r104;
        this.detailUrl = r105;
        this.shareTemplate = r110;
        this.isVirtualProduct = r111;
        this.alreadyBuy = r112;
        this.needCheck = r113;
        this.favorited = r114;
        this.buyButton = r115;
        this.visitorCount = r116;
        this.payType = r117;
        this.lamps = r118;
        this.mobiles = r210;
        this.reputationScore = r211;
        this.reputationPercentage = r212;
        this.shopId = r213;
        this.applyCoupon = r214;
        this.trackExtra = r215;
        this.shopEntry = r216;
        this.logExtra = r217;
        this.additionModulesData = r310;
        this.additionModulesInfo = r311;
        this.crossborderInfo = r312;
        this.entranceInfo = r313;
        this.replayInfo = r314;
        this.productVideo = r315;
        this.cartNum = r316;
        this.bigSaleInfo = r317;
        this.scene = r318;
        this.innerFlowVerifyInfo = r319;
        this.imageExtend = r410;
        this.shoppingGuideAttr = r411;
        this.shoppingGuideSchema = r412;
        this.combination = r413;
        this.timeSku = r414;
        this.similarProductType = r415;
        this.topicInfo = r416;
        this.marketingChannel = r417;
        this.categoryInfo = r418;
        this.extra = r419;
        this.titleSearchSchema = r510;
        this.imgSearchSchema = r511;
        this.imageSearchParams = r512;
        this.screenshotSearchSchema = r513;
    }

    public /* synthetic */ PromotionProductExtraStruct(String r510, String r511, String r512, String r513, String r514, String r515, String r516, Boolean r517, Boolean r518, Boolean r519, Boolean r610, PromotionProductButtonStruct r611, long r612, Integer r613, List r614, List r615, double r616, double r617, String r710, Integer r711, String r712, PromotionBottomButtonStruct r713, String r714, Object r715, PromotionAdditionModulesInfoDTO r716, PromotionCrossBorderStruct r717, String r718, PromotionReplayInfo r810, PromotionVideoInfo r811, int r812, PromotionBigSaleStruct r813, String r814, String r815, List r816, List r817, String r818, ImageComponent r819, TimeSkuStruct r910, String r911, ProductTopicInfo r912, String r913, CategoryInfo r914, Map r915, String r916, String r917, Map r918, String r919, int r100, int r101, DefaultConstructorMarker r102) {
        if ((r100 & 1) == 0) goto L5;
        String r103 = null;
    L7:
        if ((r100 & 2) == 0) goto L9;
        String r104 = null;
    L11:
        if ((r100 & 4) == 0) goto L13;
        String r105 = null;
    L15:
        if ((r100 & 8) == 0) goto L17;
        String r106 = null;
    L19:
        if ((r100 & 16) == 0) goto L21;
        String r107 = null;
    L23:
        if ((r100 & 32) == 0) goto L25;
        String r108 = null;
    L27:
        if ((r100 & 64) == 0) goto L29;
        String r109 = null;
    L31:
        if ((r100 & 128) == 0) goto L33;
        Boolean r110 = null;
    L35:
        if ((r100 & 256) == 0) goto L37;
        Boolean r111 = null;
    L39:
        if ((r100 & 512) == 0) goto L41;
        Boolean r112 = null;
    L43:
        if ((r100 & 1024) == 0) goto L45;
        Boolean r113 = null;
    L47:
        if ((r100 & 2048) == 0) goto L49;
        PromotionProductButtonStruct r114 = null;
    L51:
        if ((r100 & 4096) == 0) goto L53;
        long r115 = 0;
    L55:
        if ((r100 & 8192) == 0) goto L57;
        Integer r116 = null;
    L58:
        Integer r117 = r116;
        if ((r100 & 16384) == 0) goto L61;
        List r118 = null;
    L63:
        if ((r100 & 32768) == 0) goto L65;
        List r119 = null;
    L66:
        int r120 = r100 & 65536;
        double r210 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (r120 == 0) goto L69;
        double r211 = 0.0d;
    L71:
        if ((r100 & 131072) != 0) goto L75;
        r210 = r617;
    L75:
        if ((r100 & 262144) == 0) goto L77;
        String r121 = null;
    L79:
        if ((r100 & 524288) == 0) goto L81;
        Integer r212 = null;
    L83:
        if ((r100 & 1048576) == 0) goto L85;
        String r213 = null;
    L87:
        if ((r100 & 2097152) == 0) goto L89;
        PromotionBottomButtonStruct r214 = null;
    L91:
        if ((r100 & 4194304) == 0) goto L93;
        String r215 = null;
    L95:
        if ((r100 & 8388608) == 0) goto L97;
        Object r216 = null;
    L99:
        if ((r100 & 16777216) == 0) goto L101;
        PromotionAdditionModulesInfoDTO r217 = null;
    L103:
        if ((r100 & 33554432) == 0) goto L105;
        PromotionCrossBorderStruct r310 = null;
    L107:
        if ((r100 & 67108864) == 0) goto L109;
        String r311 = null;
    L111:
        if ((r100 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        PromotionReplayInfo r312 = null;
    L115:
        if ((r100 & 268435456) == 0) goto L117;
        PromotionVideoInfo r313 = null;
    L119:
        if ((r100 & 536870912) == 0) goto L121;
        int r314 = 0;
    L123:
        if ((r100 & 1073741824) == 0) goto L125;
        PromotionBigSaleStruct r315 = null;
    L127:
        if ((r100 & Integer.MIN_VALUE) == 0) goto L129;
        String r122 = null;
    L131:
        if ((r101 & 1) == 0) goto L133;
        String r316 = null;
    L135:
        if ((r101 & 2) == 0) goto L137;
        List r317 = null;
    L139:
        if ((r101 & 4) == 0) goto L141;
        List r318 = null;
    L143:
        if ((r101 & 8) == 0) goto L145;
        String r319 = null;
    L147:
        if ((r101 & 16) == 0) goto L149;
        ImageComponent r410 = null;
    L151:
        if ((r101 & 32) == 0) goto L153;
        TimeSkuStruct r411 = null;
    L155:
        if ((r101 & 64) == 0) goto L157;
        String r412 = null;
    L158:
        String r1010 = r122;
        if ((r101 & 128) == 0) goto L161;
        ProductTopicInfo r123 = null;
    L162:
        ProductTopicInfo r413 = r123;
        if ((r101 & 256) == 0) goto L165;
        String r124 = null;
    L166:
        String r414 = r124;
        if ((r101 & 512) == 0) goto L169;
        CategoryInfo r125 = null;
    L170:
        CategoryInfo r415 = r125;
        if ((r101 & 1024) == 0) goto L173;
        Map r126 = null;
    L174:
        Map r416 = r126;
        if ((r101 & 2048) == 0) goto L177;
        String r127 = null;
    L178:
        String r417 = r127;
        if ((r101 & 4096) == 0) goto L181;
        String r128 = null;
    L182:
        String r418 = r128;
        if ((r101 & 8192) == 0) goto L185;
        Map r129 = null;
    L187:
        if ((r101 & 16384) == 0) goto L189;
        String r130 = null;
    L190:
        this(r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r117, r118, r119, r211, r210, r121, r212, r213, r214, r215, r216, r217, r310, r311, r312, r313, r314, r315, r1010, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r417, r418, r129, r130);
        return;
    L189:
        r130 = r919;
        goto L190
    L185:
        r129 = r918;
        goto L187
    L181:
        r128 = r917;
        goto L182
    L177:
        r127 = r916;
        goto L178
    L173:
        r126 = r915;
        goto L174
    L169:
        r125 = r914;
        goto L170
    L165:
        r124 = r913;
        goto L166
    L161:
        r123 = r912;
        goto L162
    L157:
        r412 = r911;
        goto L158
    L153:
        r411 = r910;
        goto L155
    L149:
        r410 = r819;
        goto L151
    L145:
        r319 = r818;
        goto L147
    L141:
        r318 = r817;
        goto L143
    L137:
        r317 = r816;
        goto L139
    L133:
        r316 = r815;
        goto L135
    L129:
        r122 = r814;
        goto L131
    L125:
        r315 = r813;
        goto L127
    L121:
        r314 = r812;
        goto L123
    L117:
        r313 = r811;
        goto L119
    L113:
        r312 = r810;
        goto L115
    L109:
        r311 = r718;
        goto L111
    L105:
        r310 = r717;
        goto L107
    L101:
        r217 = r716;
        goto L103
    L97:
        r216 = r715;
        goto L99
    L93:
        r215 = r714;
        goto L95
    L89:
        r214 = r713;
        goto L91
    L85:
        r213 = r712;
        goto L87
    L81:
        r212 = r711;
        goto L83
    L77:
        r121 = r710;
        goto L79
    L69:
        r211 = r616;
        goto L71
    L65:
        r119 = r615;
        goto L66
    L61:
        r118 = r614;
        goto L63
    L57:
        r116 = r613;
        goto L58
    L53:
        r115 = r612;
        goto L55
    L49:
        r114 = r611;
        goto L51
    L45:
        r113 = r610;
        goto L47
    L41:
        r112 = r519;
        goto L43
    L37:
        r111 = r518;
        goto L39
    L33:
        r110 = r517;
        goto L35
    L29:
        r109 = r516;
        goto L31
    L25:
        r108 = r515;
        goto L27
    L21:
        r107 = r514;
        goto L23
    L17:
        r106 = r513;
        goto L19
    L13:
        r105 = r512;
        goto L15
    L9:
        r104 = r511;
        goto L11
    L5:
        r103 = r510;
        goto L7
    }
}

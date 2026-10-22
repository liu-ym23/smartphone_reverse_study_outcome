package com.bytedance.android.livesdk.message.model;

import android.text.TextUtils;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import com.ss.android.downloadlib.constants.DownloadConstants;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.data.KtvSongStruct")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0097\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0003\b®\u0001\b\u0087\b\u0018\u0000 ï\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0002ð\u0001Bï\u0003\u0012\b\b\u0002\u0010E\u001a\u00020\u0014\u0012\b\b\u0002\u0010F\u001a\u00020\u0003\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010I\u001a\u00020\u0005\u0012\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010K\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u001b\u0012\b\b\u0002\u0010L\u001a\u00020\u0014\u0012\b\b\u0002\u0010M\u001a\u00020\u001e\u0012\n\b\u0002\u0010N\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u0010R\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010U\u001a\u00020\n\u0012\n\b\u0002\u0010V\u001a\u0004\u0018\u00010+\u0012\u0010\b\u0002\u0010W\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010-\u0012\u0016\b\u0002\u0010X\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010/\u0012\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010Z\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010\u001b\u0012\u0010\b\u0002\u0010[\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010\u001b\u0012\b\b\u0002\u0010\\\u001a\u00020\u0005\u0012\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010^\u001a\u00020\u0014\u0012\u0010\b\u0002\u0010_\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001b\u0012\u0010\b\u0002\u0010`\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001b\u0012\b\b\u0002\u0010a\u001a\u00020\u0005\u0012\n\b\u0002\u0010b\u001a\u0004\u0018\u00010;\u0012\u0012\b\u0002\u0010c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001b\u0012\n\b\u0002\u0010d\u001a\u0004\u0018\u00010>\u0012\u0012\b\u0002\u0010e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010@\u0018\u00010\u001b\u0012\u0010\b\u0002\u0010f\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001b\u0012\u0016\b\u0002\u0010g\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020C\u0018\u00010/¢\u0006\u0006\bí\u0001\u0010î\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u0010\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0003J\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0003J\u0010\u0010\u000f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0000J\u0010\u0010\u0010\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0000J\u0010\u0010\u0013\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\t\u0010\u0015\u001a\u00020\u0014HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u001bHÆ\u0003J\t\u0010\u001d\u001a\u00020\u0014HÆ\u0003J\t\u0010\u001f\u001a\u00020\u001eHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010 HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\"HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010%HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010%HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010*\u001a\u00020\nHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010+HÆ\u0003J\u0011\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010-HÆ\u0003J\u0017\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010/HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u00103\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010\u001bHÆ\u0003J\u0011\u00104\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010\u001bHÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0014HÆ\u0003J\u0011\u00108\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001bHÆ\u0003J\u0011\u00109\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001bHÆ\u0003J\t\u0010:\u001a\u00020\u0005HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010;HÆ\u0003J\u0013\u0010=\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001bHÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010>HÆ\u0003J\u0013\u0010A\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010@\u0018\u00010\u001bHÆ\u0003J\u0011\u0010B\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001bHÆ\u0003J\u0017\u0010D\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020C\u0018\u00010/HÆ\u0003Jï\u0003\u0010h\u001a\u00020\u00002\b\b\u0002\u0010E\u001a\u00020\u00142\b\b\u0002\u0010F\u001a\u00020\u00032\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010I\u001a\u00020\u00052\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010K\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u001b2\b\b\u0002\u0010L\u001a\u00020\u00142\b\b\u0002\u0010M\u001a\u00020\u001e2\n\b\u0002\u0010N\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010R\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010U\u001a\u00020\n2\n\b\u0002\u0010V\u001a\u0004\u0018\u00010+2\u0010\b\u0002\u0010W\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010-2\u0016\b\u0002\u0010X\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010/2\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010Z\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010\u001b2\u0010\b\u0002\u0010[\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010\u001b2\b\b\u0002\u0010\\\u001a\u00020\u00052\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010^\u001a\u00020\u00142\u0010\b\u0002\u0010_\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001b2\u0010\b\u0002\u0010`\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001b2\b\b\u0002\u0010a\u001a\u00020\u00052\n\b\u0002\u0010b\u001a\u0004\u0018\u00010;2\u0012\b\u0002\u0010c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001b2\n\b\u0002\u0010d\u001a\u0004\u0018\u00010>2\u0012\b\u0002\u0010e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010@\u0018\u00010\u001b2\u0010\b\u0002\u0010f\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001b2\u0016\b\u0002\u0010g\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020C\u0018\u00010/HÆ\u0001J\t\u0010i\u001a\u00020\u0005HÖ\u0001J\u0013\u0010j\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003R\"\u0010E\u001a\u00020\u00148\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bE\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR\"\u0010F\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bF\u0010p\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR$\u0010G\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bG\u0010p\u001a\u0004\bu\u0010r\"\u0004\bv\u0010tR$\u0010H\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bH\u0010p\u001a\u0004\bw\u0010r\"\u0004\bx\u0010tR\"\u0010I\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bI\u0010y\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R$\u0010J\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bJ\u0010p\u001a\u0004\b~\u0010r\"\u0004\b\u007f\u0010tR1\u0010K\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u001b8\u0016@\u0016X\u0097\u000e¢\u0006\u0017\n\u0005\bK\u0010\u0080\u0001\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R$\u0010L\u001a\u00020\u00148\u0016@\u0016X\u0097\u000e¢\u0006\u0014\n\u0004\bL\u0010k\u001a\u0005\b\u0085\u0001\u0010m\"\u0005\b\u0086\u0001\u0010oR'\u0010M\u001a\u00020\u001e8\u0016@\u0016X\u0097\u000e¢\u0006\u0017\n\u0005\bM\u0010\u0087\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R)\u0010N\u001a\u0004\u0018\u00010 8\u0016@\u0016X\u0097\u000e¢\u0006\u0017\n\u0005\bN\u0010\u008c\u0001\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001\"\u0006\b\u008f\u0001\u0010\u0090\u0001R)\u0010O\u001a\u0004\u0018\u00010\"8\u0016@\u0016X\u0097\u000e¢\u0006\u0017\n\u0005\bO\u0010\u0091\u0001\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001\"\u0006\b\u0094\u0001\u0010\u0095\u0001R&\u0010P\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0014\n\u0004\bP\u0010p\u001a\u0005\b\u0096\u0001\u0010r\"\u0005\b\u0097\u0001\u0010tR)\u0010Q\u001a\u0004\u0018\u00010%8\u0016@\u0016X\u0097\u000e¢\u0006\u0017\n\u0005\bQ\u0010\u0098\u0001\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001\"\u0006\b\u009b\u0001\u0010\u009c\u0001R)\u0010R\u001a\u0004\u0018\u00010%8\u0016@\u0016X\u0097\u000e¢\u0006\u0017\n\u0005\bR\u0010\u0098\u0001\u001a\u0006\b\u009d\u0001\u0010\u009a\u0001\"\u0006\b\u009e\u0001\u0010\u009c\u0001R&\u0010S\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0014\n\u0004\bS\u0010p\u001a\u0005\b\u009f\u0001\u0010r\"\u0005\b \u0001\u0010tR&\u0010T\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0004\bT\u0010p\u001a\u0005\b¡\u0001\u0010r\"\u0005\b¢\u0001\u0010tR&\u0010U\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0016\n\u0005\bU\u0010£\u0001\u001a\u0005\bU\u0010¤\u0001\"\u0006\b¥\u0001\u0010¦\u0001R)\u0010V\u001a\u0004\u0018\u00010+8\u0016@\u0016X\u0097\u000e¢\u0006\u0017\n\u0005\bV\u0010§\u0001\u001a\u0006\b¨\u0001\u0010©\u0001\"\u0006\bª\u0001\u0010«\u0001R/\u0010W\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010-8\u0016@\u0016X\u0097\u000e¢\u0006\u0017\n\u0005\bW\u0010\u0080\u0001\u001a\u0006\b¬\u0001\u0010\u0082\u0001\"\u0006\b\u00ad\u0001\u0010\u0084\u0001R5\u0010X\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010/8\u0016@\u0016X\u0097\u000e¢\u0006\u0017\n\u0005\bX\u0010®\u0001\u001a\u0006\b¯\u0001\u0010°\u0001\"\u0006\b±\u0001\u0010²\u0001R&\u0010Y\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0014\n\u0004\bY\u0010p\u001a\u0005\b³\u0001\u0010r\"\u0005\b´\u0001\u0010tR/\u0010Z\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010\u001b8\u0016@\u0016X\u0097\u000e¢\u0006\u0017\n\u0005\bZ\u0010\u0080\u0001\u001a\u0006\bµ\u0001\u0010\u0082\u0001\"\u0006\b¶\u0001\u0010\u0084\u0001R/\u0010[\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010\u001b8\u0016@\u0016X\u0097\u000e¢\u0006\u0017\n\u0005\b[\u0010\u0080\u0001\u001a\u0006\b·\u0001\u0010\u0082\u0001\"\u0006\b¸\u0001\u0010\u0084\u0001R$\u0010\\\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0014\n\u0004\b\\\u0010y\u001a\u0005\b¹\u0001\u0010{\"\u0005\bº\u0001\u0010}R&\u0010]\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0014\n\u0004\b]\u0010p\u001a\u0005\b»\u0001\u0010r\"\u0005\b¼\u0001\u0010tR$\u0010^\u001a\u00020\u00148\u0016@\u0016X\u0097\u000e¢\u0006\u0014\n\u0004\b^\u0010k\u001a\u0005\b½\u0001\u0010m\"\u0005\b¾\u0001\u0010oR/\u0010_\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001b8\u0016@\u0016X\u0097\u000e¢\u0006\u0017\n\u0005\b_\u0010\u0080\u0001\u001a\u0006\b¿\u0001\u0010\u0082\u0001\"\u0006\bÀ\u0001\u0010\u0084\u0001R/\u0010`\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001b8\u0016@\u0016X\u0097\u000e¢\u0006\u0017\n\u0005\b`\u0010\u0080\u0001\u001a\u0006\bÁ\u0001\u0010\u0082\u0001\"\u0006\bÂ\u0001\u0010\u0084\u0001R$\u0010a\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0014\n\u0004\ba\u0010y\u001a\u0005\bÃ\u0001\u0010{\"\u0005\bÄ\u0001\u0010}R)\u0010b\u001a\u0004\u0018\u00010;8\u0016@\u0016X\u0097\u000e¢\u0006\u0017\n\u0005\bb\u0010Å\u0001\u001a\u0006\bÆ\u0001\u0010Ç\u0001\"\u0006\bÈ\u0001\u0010É\u0001R1\u0010c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001b8\u0016@\u0016X\u0097\u000e¢\u0006\u0017\n\u0005\bc\u0010\u0080\u0001\u001a\u0006\bÊ\u0001\u0010\u0082\u0001\"\u0006\bË\u0001\u0010\u0084\u0001R)\u0010d\u001a\u0004\u0018\u00010>8\u0016@\u0016X\u0097\u000e¢\u0006\u0017\n\u0005\bd\u0010Ì\u0001\u001a\u0006\bÍ\u0001\u0010Î\u0001\"\u0006\bÏ\u0001\u0010Ð\u0001R1\u0010e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010@\u0018\u00010\u001b8\u0016@\u0016X\u0097\u000e¢\u0006\u0017\n\u0005\be\u0010\u0080\u0001\u001a\u0006\bÑ\u0001\u0010\u0082\u0001\"\u0006\bÒ\u0001\u0010\u0084\u0001R/\u0010f\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001b8\u0016@\u0016X\u0097\u000e¢\u0006\u0017\n\u0005\bf\u0010\u0080\u0001\u001a\u0006\bÓ\u0001\u0010\u0082\u0001\"\u0006\bÔ\u0001\u0010\u0084\u0001R5\u0010g\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020C\u0018\u00010/8\u0016@\u0016X\u0097\u000e¢\u0006\u0017\n\u0005\bg\u0010®\u0001\u001a\u0006\bÕ\u0001\u0010°\u0001\"\u0006\bÖ\u0001\u0010²\u0001R,\u0010×\u0001\u001a\u0004\u0018\u00010\u00032\t\u0010×\u0001\u001a\u0004\u0018\u00010\u00038F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bØ\u0001\u0010r\"\u0005\bÙ\u0001\u0010tR\u0013\u0010Û\u0001\u001a\u00020\u00148G¢\u0006\u0007\u001a\u0005\bÚ\u0001\u0010mR\u0014\u0010Þ\u0001\u001a\u0002028F¢\u0006\b\u001a\u0006\bÜ\u0001\u0010Ý\u0001R\u0013\u0010à\u0001\u001a\u00020\u00038F¢\u0006\u0007\u001a\u0005\bß\u0001\u0010rR\u0013\u0010â\u0001\u001a\u00020\u00038F¢\u0006\u0007\u001a\u0005\bá\u0001\u0010rR(\u0010æ\u0001\u001a\u00020\u00142\u0007\u0010ã\u0001\u001a\u00020\u00148F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bä\u0001\u0010m\"\u0005\bå\u0001\u0010oR.\u0010é\u0001\u001a\u0004\u0018\u00010+2\t\u0010ã\u0001\u001a\u0004\u0018\u00010+8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bç\u0001\u0010©\u0001\"\u0006\bè\u0001\u0010«\u0001R(\u0010ì\u0001\u001a\u00020\u00052\u0007\u0010ã\u0001\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bê\u0001\u0010{\"\u0005\bë\u0001\u0010}¨\u0006ñ\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/KtvMusic;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/message/model/m8;", "", "toString", "", "type", "", "correctLyricsType", "userId", "", "isOrderedBy", "currentUserId", "isSinger", "music", "isSameKtvMusic", "isSameKtvMusicByIdStr", "", "other", "isSameForDiffUpdate", "", "component1", "component2", "component3", "component4", "component5", "component6", "", "component7", "component8", "", "component9", "Lcom/bytedance/android/livesdk/message/model/PersonalSongInfo;", "component10", "Lcom/bytedance/android/livesdk/message/model/WantListenInfo;", "component11", "component12", "Lcom/bytedance/android/livesdk/message/model/AudioInfo;", "component13", "component14", "component15", "component16", "component17", "Lcom/bytedance/android/livesdk/message/model/OrderInfo;", "component18", "", "component19", "", "component20", "component21", "Lcom/bytedance/android/livesdk/message/model/MusicInterval;", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "Lcom/bytedance/android/livesdk/message/model/ChallengeInfo;", "component30", "component31", "Lcom/bytedance/android/livesdk/message/model/RealTimeChorusInfo;", "component32", "Lcom/bytedance/android/livesdk/message/model/RecommendRealTimeChorusInfo;", "component33", "component34", "Lcom/bytedance/android/livesdk/message/model/RegionList;", "component35", NativeDownloadModel.JsonKey.ID, "mIdStr", "mTitle", "mAuthor", "mLyricType", "mSongUrl", "mLyricUrlList", "mDuration", "mPreviewStartTime", "personalSongInfo", "wantListenInfo", "mNewCoverUrl", "mFullTrack", "mAccompanimentTrack", "midiUrl", "vocalUrl", Keys.API_EVENT_KEY_IS_FAVORITE, "orderInfoFlex", PromotionProductPrivilegesStruct.TAGS, "ext", "extraJson", "mMusicClimax", DBDefinition.SEGMENT_TABLE_NAME, "musicType", "addSongSource", "totalOrderCount", "artistIds", "artistIdstrs", "totalOrderWithCurAnchor", "challengeInfo", "copyRightList", "realTimeChorusInfo", "recommendRealTimeChorusInfos", "copyrightedAppIds", "globalCopyrightRegionInfo", "copy", "hashCode", "equals", "J", "getMId", "()J", "setMId", "(J)V", "Ljava/lang/String;", "getMIdStr", "()Ljava/lang/String;", "setMIdStr", "(Ljava/lang/String;)V", "getMTitle", "setMTitle", "getMAuthor", "setMAuthor", "I", "getMLyricType", "()I", "setMLyricType", "(I)V", "getMSongUrl", "setMSongUrl", "Ljava/util/List;", "getMLyricUrlList", "()Ljava/util/List;", "setMLyricUrlList", "(Ljava/util/List;)V", "getMDuration", "setMDuration", FaceService.girlLabel, "getMPreviewStartTime", "()F", "setMPreviewStartTime", "(F)V", "Lcom/bytedance/android/livesdk/message/model/PersonalSongInfo;", "getPersonalSongInfo", "()Lcom/bytedance/android/livesdk/message/model/PersonalSongInfo;", "setPersonalSongInfo", "(Lcom/bytedance/android/livesdk/message/model/PersonalSongInfo;)V", "Lcom/bytedance/android/livesdk/message/model/WantListenInfo;", "getWantListenInfo", "()Lcom/bytedance/android/livesdk/message/model/WantListenInfo;", "setWantListenInfo", "(Lcom/bytedance/android/livesdk/message/model/WantListenInfo;)V", "getMNewCoverUrl", "setMNewCoverUrl", "Lcom/bytedance/android/livesdk/message/model/AudioInfo;", "getMFullTrack", "()Lcom/bytedance/android/livesdk/message/model/AudioInfo;", "setMFullTrack", "(Lcom/bytedance/android/livesdk/message/model/AudioInfo;)V", "getMAccompanimentTrack", "setMAccompanimentTrack", "getMidiUrl", "setMidiUrl", "getVocalUrl", "setVocalUrl", "Z", "()Z", "setFavorite", "(Z)V", "Lcom/bytedance/android/livesdk/message/model/OrderInfo;", "getOrderInfoFlex", "()Lcom/bytedance/android/livesdk/message/model/OrderInfo;", "setOrderInfoFlex", "(Lcom/bytedance/android/livesdk/message/model/OrderInfo;)V", "getTags", "setTags", "Ljava/util/Map;", "getExt", "()Ljava/util/Map;", "setExt", "(Ljava/util/Map;)V", "getExtraJson", "setExtraJson", "getMMusicClimax", "setMMusicClimax", "getSegments", "setSegments", "getMusicType", "setMusicType", "getAddSongSource", "setAddSongSource", "getTotalOrderCount", "setTotalOrderCount", "getArtistIds", "setArtistIds", "getArtistIdstrs", "setArtistIdstrs", "getTotalOrderWithCurAnchor", "setTotalOrderWithCurAnchor", "Lcom/bytedance/android/livesdk/message/model/ChallengeInfo;", "getChallengeInfo", "()Lcom/bytedance/android/livesdk/message/model/ChallengeInfo;", "setChallengeInfo", "(Lcom/bytedance/android/livesdk/message/model/ChallengeInfo;)V", "getCopyRightList", "setCopyRightList", "Lcom/bytedance/android/livesdk/message/model/RealTimeChorusInfo;", "getRealTimeChorusInfo", "()Lcom/bytedance/android/livesdk/message/model/RealTimeChorusInfo;", "setRealTimeChorusInfo", "(Lcom/bytedance/android/livesdk/message/model/RealTimeChorusInfo;)V", "getRecommendRealTimeChorusInfos", "setRecommendRealTimeChorusInfos", "getCopyrightedAppIds", "setCopyrightedAppIds", "getGlobalCopyrightRegionInfo", "setGlobalCopyrightRegionInfo", "coverUrl", "getCoverUrl", "setCoverUrl", "getTurnId", "turnId", "getFirstClimax", "()Lcom/bytedance/android/livesdk/message/model/MusicInterval;", "firstClimax", "getOrderUserIdString", "orderUserIdString", "getTitle", "title", "value", "getId", "setId", "id", "getOrderInfo", "setOrderInfo", "orderInfo", "getSongType", "setSongType", "songType", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/util/List;JFLcom/bytedance/android/livesdk/message/model/PersonalSongInfo;Lcom/bytedance/android/livesdk/message/model/WantListenInfo;Ljava/lang/String;Lcom/bytedance/android/livesdk/message/model/AudioInfo;Lcom/bytedance/android/livesdk/message/model/AudioInfo;Ljava/lang/String;Ljava/lang/String;ZLcom/bytedance/android/livesdk/message/model/OrderInfo;Ljava/util/List;Ljava/util/Map;Ljava/lang/String;Ljava/util/List;Ljava/util/List;ILjava/lang/String;JLjava/util/List;Ljava/util/List;ILcom/bytedance/android/livesdk/message/model/ChallengeInfo;Ljava/util/List;Lcom/bytedance/android/livesdk/message/model/RealTimeChorusInfo;Ljava/util/List;Ljava/util/List;Ljava/util/Map;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvMusic extends FlexModelBase<m8> implements m8, vh7.h {
    public static final a Companion = null;
    public static final float DEFAULT_LINE_DURATION = 1000.0f;
    public static final String EFFECT_TAG = "灯效";
    public static final int LRC_TYPE_KRC = 3;
    public static final int LRC_TYPE_LRC = 2;
    public static final String ORIGIN_TAG = "原唱";
    public static final int SONG_COPYRIGHT_LIVE = 2;
    public static final int SONG_COPYRIGHT_NONE = 0;
    public static final int SONG_COPYRIGHT_SHORT_VIDEO = 1;
    public static final int SONG_COPYRIGHT_SOLO_KTV_HIGHRISK = 5;
    public static final int SONG_PATTERN_M4A = 1;
    public static final int SONG_PATTERN_MP3 = 2;
    public static final int SONG_PATTERN_UNKNOWN = 0;
    public static final int SONG_TYPE_NORMAL = 0;

    @SerializedName("add_song_source")
    protected String addSongSource;

    @SerializedName("artist_ids")
    protected List<Long> artistIds;

    @SerializedName("artist_idstrs")
    protected List<String> artistIdstrs;

    @SerializedName("challenge_info")
    protected ChallengeInfo challengeInfo;

    @SerializedName("song_copyright")
    protected List<Integer> copyRightList;

    @SerializedName("karaoke_copyrighted_app_ids")
    protected List<Long> copyrightedAppIds;

    @SerializedName("ext")
    protected Map<String, String> ext;

    @SerializedName(DownloadConstants.KEY_EXTRA_JSON)
    protected String extraJson;

    @SerializedName("global_copyright_region_info")
    protected Map<Long, RegionList> globalCopyrightRegionInfo;

    @SerializedName("is_favorite")
    protected boolean isFavorite;

    @SerializedName("accompaniment_track")
    protected AudioInfo mAccompanimentTrack;

    @SerializedName("author")
    protected String mAuthor;

    @SerializedName("duration")
    protected long mDuration;

    @SerializedName("full_track")
    protected AudioInfo mFullTrack;

    @SerializedName("id")
    protected long mId;

    @SerializedName("id_str")
    protected String mIdStr;

    @SerializedName("lyric_type")
    protected int mLyricType;

    @SerializedName("lyric_url_list")
    protected List<String> mLyricUrlList;

    @SerializedName("music_climax")
    protected List<MusicInterval> mMusicClimax;

    @SerializedName("new_cover_url")
    protected String mNewCoverUrl;

    @SerializedName("preview_start_time")
    protected float mPreviewStartTime;

    @SerializedName("song_url")
    protected String mSongUrl;

    @SerializedName("title")
    protected String mTitle;

    @SerializedName("midi_url")
    protected String midiUrl;

    @SerializedName("song_type")
    protected int musicType;

    @SerializedName("order_info")
    protected OrderInfo orderInfoFlex;

    @SerializedName("personal_song_info")
    protected PersonalSongInfo personalSongInfo;

    @SerializedName("real_time_chorus_info")
    protected RealTimeChorusInfo realTimeChorusInfo;

    @SerializedName("recommend_real_time_chorus_infos")
    protected List<RecommendRealTimeChorusInfo> recommendRealTimeChorusInfos;

    @SerializedName(DBDefinition.SEGMENT_TABLE_NAME)
    protected List<MusicInterval> segments;

    @SerializedName(PromotionProductPrivilegesStruct.TAGS)
    protected List<String> tags;

    @SerializedName("global_total_order")
    protected long totalOrderCount;

    @SerializedName("total_order_with_cur_anchor")
    protected int totalOrderWithCurAnchor;

    @SerializedName("vocal_url")
    protected String vocalUrl;

    @SerializedName("want_listen_info")
    protected WantListenInfo wantListenInfo;

    public static final class a {
        public a() {
        }

        public static long a(KtvMusic r100) {
            if (d(r100) == true) goto L5;
            if (r100 != null) goto L16;
            return 0;
        L16:
            return r100.getMDuration();
        L5:
            if (r100 == null) goto L9;
            MusicInterval r101 = r100.getFirstClimax();
            if (r101 == null) goto L9;
            long r102 = r101.getDurationMs();
        L15:
            return RangesKt.coerceAtMost(r102, 60000) / ((long) 1000);
        L9:
            r102 = 60000;
            goto L15
        }

        public static long c(KtvMusic r100) {
            if (d(r100) == false) goto L8;
            if (r100 == null) goto L8;
            MusicInterval r101 = r100.getFirstClimax();
            if (r101 == null) goto L8;
            return r101.getStartMs();
        L8:
            return 0;
        }

        public static boolean d(KtvMusic r100) {
            if (r100 == null) goto L7;
            List<Integer> r101 = r100.getCopyRightList();
            if (r101 == null) goto L7;
            boolean r102 = r101.contains(5);
        L8:
            if (r100 == null) goto L10;
            OrderInfo r103 = r100.getOrderInfo();
        L12:
            if (r103 == null) goto L20;
            OrderInfo r104 = r100.getOrderInfo();
            if (r104 == null) goto L21;
            Intrinsics.checkNotNullParameter(r104, "$this$topUserFlex");
            b8 r105 = r104.getTopUser();
            if (r105 == null) goto L21;
            if (r105.isSupportHighRiskHandleVersion() == true) goto L20;
        L21:
            boolean r106 = false;
        L22:
            if (r102 == false) goto L26;
            if (r106 == false) goto L27;
            return true;
        L27:
            return false;
        L26:
            return false;
        L20:
            r106 = true;
            goto L22
        L10:
            r103 = null;
        L7:
            r102 = false;
            goto L8
        }

        public static long b(KtvMusic r100, long r101) {
            return RangesKt.coerceAtLeast(r101 - c(r100), 0);
        }

        public static void e(KtvMusic r100, KtvMusic r101) {
            Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
            Intrinsics.checkNotNullParameter(r101, "other");
            if (r100.getExt() != null) goto L6;
            r100.setExt(new HashMap());
        L6:
            if (r101.getExt() == null) goto L13;
            Map<String, String> r102 = r101.getExt();
            Intrinsics.checkNotNull(r102);
            Iterator<Map.Entry<String, String>> r103 = r102.entrySet().iterator();
        L9:
            if (r103.hasNext() == false) goto L19;
            Map.Entry<String, String> r104 = r103.next();
            String r105 = r104.getKey();
            String r106 = r104.getValue();
            Map<String, String> r107 = r100.getExt();
            Intrinsics.checkNotNull(r107);
            if (r107.containsKey(r105) == true) goto L9;
            Map<String, String> r108 = r100.getExt();
            Intrinsics.checkNotNull(r108);
            r108.put(r105, r106);
            goto L9
        L19:
            return;
        }
    }

    public KtvMusic(long r100, String r101, String r102, String r103, int r110, String r111, List<String> r112, long r113, float r114, PersonalSongInfo r115, WantListenInfo r116, String r117, AudioInfo r118, AudioInfo r210, String r211, String r212, boolean r213, OrderInfo r214, List<String> r215, Map<String, String> r216, String r217, List<MusicInterval> r218, List<MusicInterval> r219, int r310, String r311, long r312, List<Long> r313, List<String> r314, int r315, ChallengeInfo r316, List<Integer> r317, RealTimeChorusInfo r318, List<RecommendRealTimeChorusInfo> r410, List<Long> r411, Map<Long, RegionList> r412) {
        Intrinsics.checkNotNullParameter(r101, "mIdStr");
        super(m8.class);
        this.mId = r100;
        this.mIdStr = r101;
        this.mTitle = r102;
        this.mAuthor = r103;
        this.mLyricType = r110;
        this.mSongUrl = r111;
        this.mLyricUrlList = r112;
        this.mDuration = r113;
        this.mPreviewStartTime = r114;
        this.personalSongInfo = r115;
        this.wantListenInfo = r116;
        this.mNewCoverUrl = r117;
        this.mFullTrack = r118;
        this.mAccompanimentTrack = r210;
        this.midiUrl = r211;
        this.vocalUrl = r212;
        this.isFavorite = r213;
        this.orderInfoFlex = r214;
        this.tags = r215;
        this.ext = r216;
        this.extraJson = r217;
        this.mMusicClimax = r218;
        this.segments = r219;
        this.musicType = r310;
        this.addSongSource = r311;
        this.totalOrderCount = r312;
        this.artistIds = r313;
        this.artistIdstrs = r314;
        this.totalOrderWithCurAnchor = r315;
        this.challengeInfo = r316;
        this.copyRightList = r317;
        this.realTimeChorusInfo = r318;
        this.recommendRealTimeChorusInfos = r410;
        this.copyrightedAppIds = r411;
        this.globalCopyrightRegionInfo = r412;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ KtvMusic copy$default(KtvMusic r310, long r311, String r312, String r313, String r410, int r411, String r412, List r413, long r414, float r415, PersonalSongInfo r416, WantListenInfo r417, String r418, AudioInfo r510, AudioInfo r511, String r512, String r513, boolean r514, OrderInfo r515, List r516, Map r517, String r518, List r519, List r610, int r611, String r612, long r613, List r614, List r615, int r616, ChallengeInfo r617, List r618, RealTimeChorusInfo r710, List r711, List r712, Map r713, int r714, int r715, Object r716) {
        if ((r714 & 1) == 0) goto L5;
        long r100 = r310.getMId();
    L7:
        if ((r714 & 2) == 0) goto L9;
        String r101 = r310.getMIdStr();
    L11:
        if ((r714 & 4) == 0) goto L13;
        String r102 = r310.getMTitle();
    L15:
        if ((r714 & 8) == 0) goto L17;
        String r103 = r310.getMAuthor();
    L19:
        if ((r714 & 16) == 0) goto L21;
        int r104 = r310.getMLyricType();
    L23:
        if ((r714 & 32) == 0) goto L25;
        String r105 = r310.getMSongUrl();
    L27:
        if ((r714 & 64) == 0) goto L29;
        List r106 = r310.getMLyricUrlList();
    L31:
        if ((r714 & 128) == 0) goto L33;
        long r107 = r310.getMDuration();
    L35:
        if ((r714 & 256) == 0) goto L37;
        float r110 = r310.getMPreviewStartTime();
    L39:
        if ((r714 & 512) == 0) goto L41;
        PersonalSongInfo r111 = r310.getPersonalSongInfo();
    L43:
        if ((r714 & 1024) == 0) goto L45;
        WantListenInfo r112 = r310.getWantListenInfo();
    L47:
        if ((r714 & 2048) == 0) goto L49;
        String r113 = r310.getMNewCoverUrl();
    L51:
        if ((r714 & 4096) == 0) goto L53;
        AudioInfo r114 = r310.getMFullTrack();
    L54:
        AudioInfo r520 = r114;
        if ((r714 & 8192) == 0) goto L57;
        AudioInfo r115 = r310.getMAccompanimentTrack();
    L58:
        AudioInfo r521 = r115;
        if ((r714 & 16384) == 0) goto L61;
        String r116 = r310.getMidiUrl();
    L62:
        String r419 = r113;
        String r522 = r116;
        if ((r714 & 32768) == 0) goto L65;
        String r117 = r310.vocalUrl;
    L67:
        if ((r714 & 65536) == 0) goto L69;
        boolean r118 = r310.isFavorite();
    L71:
        if ((r714 & 131072) == 0) goto L73;
        OrderInfo r119 = r310.getOrderInfoFlex();
    L75:
        if ((r714 & 262144) == 0) goto L77;
        List r120 = r310.getTags();
    L79:
        if ((r714 & 524288) == 0) goto L81;
        Map r121 = r310.getExt();
    L83:
        if ((r714 & 1048576) == 0) goto L85;
        String r210 = r310.getExtraJson();
    L87:
        if ((r714 & 2097152) == 0) goto L89;
        List r211 = r310.getMMusicClimax();
    L91:
        if ((r714 & 4194304) == 0) goto L93;
        List r212 = r310.getSegments();
    L95:
        if ((r714 & 8388608) == 0) goto L97;
        int r213 = r310.getMusicType();
    L99:
        if ((r714 & 16777216) == 0) goto L101;
        String r214 = r310.getAddSongSource();
    L103:
        if ((r714 & 33554432) == 0) goto L105;
        long r215 = r310.getTotalOrderCount();
    L107:
        if ((r714 & 67108864) == 0) goto L109;
        List r216 = r310.getArtistIds();
    L111:
        if ((r714 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        List r217 = r310.getArtistIdstrs();
    L115:
        if ((r714 & 268435456) == 0) goto L117;
        int r218 = r310.getTotalOrderWithCurAnchor();
    L119:
        if ((r714 & 536870912) == 0) goto L121;
        ChallengeInfo r314 = r310.getChallengeInfo();
    L123:
        if ((r714 & 1073741824) == 0) goto L125;
        List r315 = r310.getCopyRightList();
    L127:
        if ((r714 & Integer.MIN_VALUE) == 0) goto L129;
        RealTimeChorusInfo r108 = r310.getRealTimeChorusInfo();
    L131:
        if ((r715 & 1) == 0) goto L133;
        List r316 = r310.getRecommendRealTimeChorusInfos();
    L135:
        if ((r715 & 2) == 0) goto L137;
        List r317 = r310.getCopyrightedAppIds();
    L139:
        if ((r715 & 4) == 0) goto L141;
        Map r318 = r310.getGlobalCopyrightRegionInfo();
    L143:
        return r310.copy(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r419, r520, r521, r522, r117, r118, r119, r120, r121, r210, r211, r212, r213, r214, r215, r216, r217, r218, r314, r315, r108, r316, r317, r318);
    L141:
        r318 = r713;
        goto L143
    L137:
        r317 = r712;
        goto L139
    L133:
        r316 = r711;
        goto L135
    L129:
        r108 = r710;
        goto L131
    L125:
        r315 = r618;
        goto L127
    L121:
        r314 = r617;
        goto L123
    L117:
        r218 = r616;
        goto L119
    L113:
        r217 = r615;
        goto L115
    L109:
        r216 = r614;
        goto L111
    L105:
        r215 = r613;
        goto L107
    L101:
        r214 = r612;
        goto L103
    L97:
        r213 = r611;
        goto L99
    L93:
        r212 = r610;
        goto L95
    L89:
        r211 = r519;
        goto L91
    L85:
        r210 = r518;
        goto L87
    L81:
        r121 = r517;
        goto L83
    L77:
        r120 = r516;
        goto L79
    L73:
        r119 = r515;
        goto L75
    L69:
        r118 = r514;
        goto L71
    L65:
        r117 = r513;
        goto L67
    L61:
        r116 = r512;
        goto L62
    L57:
        r115 = r511;
        goto L58
    L53:
        r114 = r510;
        goto L54
    L49:
        r113 = r418;
        goto L51
    L45:
        r112 = r417;
        goto L47
    L41:
        r111 = r416;
        goto L43
    L37:
        r110 = r415;
        goto L39
    L33:
        r107 = r414;
        goto L35
    L29:
        r106 = r413;
        goto L31
    L25:
        r105 = r412;
        goto L27
    L21:
        r104 = r411;
        goto L23
    L17:
        r103 = r410;
        goto L19
    L13:
        r102 = r313;
        goto L15
    L9:
        r101 = r312;
        goto L11
    L5:
        r100 = r311;
        goto L7
    }

    public final long component1() {
        return getMId();
    }

    public final PersonalSongInfo component10() {
        return getPersonalSongInfo();
    }

    public final WantListenInfo component11() {
        return getWantListenInfo();
    }

    public final String component12() {
        return getMNewCoverUrl();
    }

    public final AudioInfo component13() {
        return getMFullTrack();
    }

    public final AudioInfo component14() {
        return getMAccompanimentTrack();
    }

    public final String component15() {
        return getMidiUrl();
    }

    public final String component16() {
        return this.vocalUrl;
    }

    public final boolean component17() {
        return isFavorite();
    }

    public final OrderInfo component18() {
        return getOrderInfoFlex();
    }

    public final List<String> component19() {
        return getTags();
    }

    public final String component2() {
        return getMIdStr();
    }

    public final Map<String, String> component20() {
        return getExt();
    }

    public final String component21() {
        return getExtraJson();
    }

    public final List<MusicInterval> component22() {
        return getMMusicClimax();
    }

    public final List<MusicInterval> component23() {
        return getSegments();
    }

    public final int component24() {
        return getMusicType();
    }

    public final String component25() {
        return getAddSongSource();
    }

    public final long component26() {
        return getTotalOrderCount();
    }

    public final List<Long> component27() {
        return getArtistIds();
    }

    public final List<String> component28() {
        return getArtistIdstrs();
    }

    public final int component29() {
        return getTotalOrderWithCurAnchor();
    }

    public final String component3() {
        return getMTitle();
    }

    public final ChallengeInfo component30() {
        return getChallengeInfo();
    }

    public final List<Integer> component31() {
        return getCopyRightList();
    }

    public final RealTimeChorusInfo component32() {
        return getRealTimeChorusInfo();
    }

    public final List<RecommendRealTimeChorusInfo> component33() {
        return getRecommendRealTimeChorusInfos();
    }

    public final List<Long> component34() {
        return getCopyrightedAppIds();
    }

    public final Map<Long, RegionList> component35() {
        return getGlobalCopyrightRegionInfo();
    }

    public final String component4() {
        return getMAuthor();
    }

    public final int component5() {
        return getMLyricType();
    }

    public final String component6() {
        return getMSongUrl();
    }

    public final List<String> component7() {
        return getMLyricUrlList();
    }

    public final long component8() {
        return getMDuration();
    }

    public final float component9() {
        return getMPreviewStartTime();
    }

    public final KtvMusic copy(long r410, String r411, String r412, String r413, int r414, String r415, List<String> r416, long r417, float r510, PersonalSongInfo r511, WantListenInfo r512, String r513, AudioInfo r514, AudioInfo r515, String r516, String r517, boolean r518, OrderInfo r610, List<String> r611, Map<String, String> r612, String r613, List<MusicInterval> r614, List<MusicInterval> r615, int r616, String r617, long r618, List<Long> r710, List<String> r711, int r712, ChallengeInfo r713, List<Integer> r714, RealTimeChorusInfo r715, List<RecommendRealTimeChorusInfo> r716, List<Long> r717, Map<Long, RegionList> r718) {
        Intrinsics.checkNotNullParameter(r411, "mIdStr");
        return new KtvMusic(r410, r411, r412, r413, r414, r415, r416, r417, r510, r511, r512, r513, r514, r515, r516, r517, r518, r610, r611, r612, r613, r614, r615, r616, r617, r618, r710, r711, r712, r713, r714, r715, r716, r717, r718);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof KtvMusic) == false) goto L76;
        KtvMusic r101 = (KtvMusic) r100;
        if (getMId() == r101.getMId()) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(getMIdStr(), r101.getMIdStr()) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(getMTitle(), r101.getMTitle()) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(getMAuthor(), r101.getMAuthor()) == true) goto L14;
        return false;
    L14:
        if (getMLyricType() == r101.getMLyricType()) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(getMSongUrl(), r101.getMSongUrl()) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(getMLyricUrlList(), r101.getMLyricUrlList()) == true) goto L20;
        return false;
    L20:
        if (getMDuration() == r101.getMDuration()) goto L22;
        return false;
    L22:
        if (Float.compare(getMPreviewStartTime(), r101.getMPreviewStartTime()) == 0) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(getPersonalSongInfo(), r101.getPersonalSongInfo()) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(getWantListenInfo(), r101.getWantListenInfo()) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(getMNewCoverUrl(), r101.getMNewCoverUrl()) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(getMFullTrack(), r101.getMFullTrack()) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(getMAccompanimentTrack(), r101.getMAccompanimentTrack()) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(getMidiUrl(), r101.getMidiUrl()) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.vocalUrl, r101.vocalUrl) == true) goto L38;
        return false;
    L38:
        if (isFavorite() == r101.isFavorite()) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(getOrderInfoFlex(), r101.getOrderInfoFlex()) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(getTags(), r101.getTags()) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(getExt(), r101.getExt()) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(getExtraJson(), r101.getExtraJson()) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(getMMusicClimax(), r101.getMMusicClimax()) == true) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(getSegments(), r101.getSegments()) == true) goto L52;
        return false;
    L52:
        if (getMusicType() == r101.getMusicType()) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(getAddSongSource(), r101.getAddSongSource()) == true) goto L56;
        return false;
    L56:
        if (getTotalOrderCount() == r101.getTotalOrderCount()) goto L58;
        return false;
    L58:
        if (Intrinsics.areEqual(getArtistIds(), r101.getArtistIds()) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(getArtistIdstrs(), r101.getArtistIdstrs()) == true) goto L62;
        return false;
    L62:
        if (getTotalOrderWithCurAnchor() == r101.getTotalOrderWithCurAnchor()) goto L64;
        return false;
    L64:
        if (Intrinsics.areEqual(getChallengeInfo(), r101.getChallengeInfo()) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(getCopyRightList(), r101.getCopyRightList()) == true) goto L68;
        return false;
    L68:
        if (Intrinsics.areEqual(getRealTimeChorusInfo(), r101.getRealTimeChorusInfo()) == true) goto L70;
        return false;
    L70:
        if (Intrinsics.areEqual(getRecommendRealTimeChorusInfos(), r101.getRecommendRealTimeChorusInfos()) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(getCopyrightedAppIds(), r101.getCopyrightedAppIds()) == true) goto L74;
        return false;
    L74:
        if (Intrinsics.areEqual(getGlobalCopyrightRegionInfo(), r101.getGlobalCopyrightRegionInfo()) == true) goto L115;
        return false;
    L115:
        return true;
    L76:
        return false;
    }

    public int hashCode() {
        long r100 = getMId();
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = getMIdStr();
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = getMTitle();
        if (r106 == null) goto L9;
        int r107 = r106.hashCode();
    L10:
        int r108 = (r105 + r107) * 31;
        String r109 = getMAuthor();
        if (r109 == null) goto L13;
        int r110 = r109.hashCode();
    L14:
        int r111 = (((r108 + r110) * 31) + getMLyricType()) * 31;
        String r112 = getMSongUrl();
        if (r112 == null) goto L17;
        int r113 = r112.hashCode();
    L18:
        int r114 = (r111 + r113) * 31;
        List<String> r115 = getMLyricUrlList();
        if (r115 == null) goto L21;
        int r116 = r115.hashCode();
    L22:
        long r117 = getMDuration();
        int r118 = (((((r114 + r116) * 31) + ((int) (r117 ^ (r117 >>> 32)))) * 31) + Float.floatToIntBits(getMPreviewStartTime())) * 31;
        PersonalSongInfo r119 = getPersonalSongInfo();
        if (r119 == null) goto L25;
        int r120 = r119.hashCode();
    L26:
        int r121 = (r118 + r120) * 31;
        WantListenInfo r122 = getWantListenInfo();
        if (r122 == null) goto L29;
        int r123 = r122.hashCode();
    L30:
        int r124 = (r121 + r123) * 31;
        String r125 = getMNewCoverUrl();
        if (r125 == null) goto L33;
        int r126 = r125.hashCode();
    L34:
        int r127 = (r124 + r126) * 31;
        AudioInfo r128 = getMFullTrack();
        if (r128 == null) goto L37;
        int r129 = r128.hashCode();
    L38:
        int r130 = (r127 + r129) * 31;
        AudioInfo r131 = getMAccompanimentTrack();
        if (r131 == null) goto L41;
        int r132 = r131.hashCode();
    L42:
        int r133 = (r130 + r132) * 31;
        String r134 = getMidiUrl();
        if (r134 == null) goto L45;
        int r135 = r134.hashCode();
    L46:
        int r136 = (r133 + r135) * 31;
        String r137 = this.vocalUrl;
        if (r137 == null) goto L49;
        int r138 = r137.hashCode();
    L50:
        int r139 = (r136 + r138) * 31;
        boolean r140 = isFavorite();
        int r141 = r140;
        if (r140 == false) goto L53;
        r141 = 1;
    L53:
        int r142 = (r139 + r141) * 31;
        OrderInfo r143 = getOrderInfoFlex();
        if (r143 == null) goto L56;
        int r144 = r143.hashCode();
    L57:
        int r145 = (r142 + r144) * 31;
        List<String> r146 = getTags();
        if (r146 == null) goto L60;
        int r147 = r146.hashCode();
    L61:
        int r148 = (r145 + r147) * 31;
        Map<String, String> r149 = getExt();
        if (r149 == null) goto L64;
        int r150 = r149.hashCode();
    L65:
        int r151 = (r148 + r150) * 31;
        String r152 = getExtraJson();
        if (r152 == null) goto L68;
        int r153 = r152.hashCode();
    L69:
        int r154 = (r151 + r153) * 31;
        List<MusicInterval> r155 = getMMusicClimax();
        if (r155 == null) goto L72;
        int r156 = r155.hashCode();
    L73:
        int r157 = (r154 + r156) * 31;
        List<MusicInterval> r158 = getSegments();
        if (r158 == null) goto L76;
        int r159 = r158.hashCode();
    L77:
        int r160 = (((r157 + r159) * 31) + getMusicType()) * 31;
        String r161 = getAddSongSource();
        if (r161 == null) goto L80;
        int r162 = r161.hashCode();
    L81:
        long r163 = getTotalOrderCount();
        int r164 = (((r160 + r162) * 31) + ((int) (r163 ^ (r163 >>> 32)))) * 31;
        List<Long> r165 = getArtistIds();
        if (r165 == null) goto L84;
        int r166 = r165.hashCode();
    L85:
        int r167 = (r164 + r166) * 31;
        List<String> r168 = getArtistIdstrs();
        if (r168 == null) goto L88;
        int r169 = r168.hashCode();
    L89:
        int r170 = (((r167 + r169) * 31) + getTotalOrderWithCurAnchor()) * 31;
        ChallengeInfo r171 = getChallengeInfo();
        if (r171 == null) goto L92;
        int r172 = r171.hashCode();
    L93:
        int r173 = (r170 + r172) * 31;
        List<Integer> r174 = getCopyRightList();
        if (r174 == null) goto L96;
        int r175 = r174.hashCode();
    L97:
        int r176 = (r173 + r175) * 31;
        RealTimeChorusInfo r177 = getRealTimeChorusInfo();
        if (r177 == null) goto L100;
        int r178 = r177.hashCode();
    L101:
        int r179 = (r176 + r178) * 31;
        List<RecommendRealTimeChorusInfo> r180 = getRecommendRealTimeChorusInfos();
        if (r180 == null) goto L104;
        int r181 = r180.hashCode();
    L105:
        int r182 = (r179 + r181) * 31;
        List<Long> r183 = getCopyrightedAppIds();
        if (r183 == null) goto L108;
        int r184 = r183.hashCode();
    L109:
        int r185 = (r182 + r184) * 31;
        Map<Long, RegionList> r186 = getGlobalCopyrightRegionInfo();
        if (r186 == null) goto L113;
        r103 = r186.hashCode();
    L113:
        return r185 + r103;
    L108:
        r184 = 0;
        goto L109
    L104:
        r181 = 0;
        goto L105
    L100:
        r178 = 0;
        goto L101
    L96:
        r175 = 0;
        goto L97
    L92:
        r172 = 0;
        goto L93
    L88:
        r169 = 0;
        goto L89
    L84:
        r166 = 0;
        goto L85
    L80:
        r162 = 0;
        goto L81
    L76:
        r159 = 0;
        goto L77
    L72:
        r156 = 0;
        goto L73
    L68:
        r153 = 0;
        goto L69
    L64:
        r150 = 0;
        goto L65
    L60:
        r147 = 0;
        goto L61
    L56:
        r144 = 0;
        goto L57
    L49:
        r138 = 0;
        goto L50
    L45:
        r135 = 0;
        goto L46
    L41:
        r132 = 0;
        goto L42
    L37:
        r129 = 0;
        goto L38
    L33:
        r126 = 0;
        goto L34
    L29:
        r123 = 0;
        goto L30
    L25:
        r120 = 0;
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

    static {
        Companion = new a();
    }

    public KtvMusic() {
        super(m8.class);
        this.mId = 0;
        this.mIdStr = "";
        this.mTitle = "";
        this.mAuthor = "";
        this.mLyricType = 3;
        this.mSongUrl = "";
        this.mLyricUrlList = null;
        this.mDuration = 0;
        this.mPreviewStartTime = 0.0f;
        this.personalSongInfo = null;
        this.wantListenInfo = null;
        this.mNewCoverUrl = "";
        this.mFullTrack = null;
        this.mAccompanimentTrack = null;
        this.midiUrl = "";
        this.vocalUrl = "";
        this.isFavorite = false;
        this.orderInfoFlex = null;
        this.tags = null;
        this.ext = null;
        this.extraJson = null;
        this.mMusicClimax = null;
        this.segments = null;
        this.musicType = 0;
        this.addSongSource = "";
        this.totalOrderCount = 0;
        this.artistIds = null;
        this.artistIdstrs = null;
        this.totalOrderWithCurAnchor = 0;
        this.challengeInfo = null;
        this.copyRightList = null;
        this.realTimeChorusInfo = null;
        this.recommendRealTimeChorusInfos = null;
        this.copyrightedAppIds = null;
        this.globalCopyrightRegionInfo = null;
    }

    public String toString() {
        return "[id=" + getMId() + ",title=" + getMTitle() + ",lyrics_type=" + getMLyricType() + "]";
    }

    @Override // com.bytedance.android.livesdk.message.model.m8
    public /* bridge */ /* synthetic */ r6 getChallengeInfo() {
        return getChallengeInfo();
    }

    public final String getCoverUrl() {
        String r100 = getMNewCoverUrl();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public final MusicInterval getFirstClimax() {
        if (getMMusicClimax() == null) goto L9;
        List<MusicInterval> r100 = getMMusicClimax();
        Intrinsics.checkNotNull(r100);
        if (r100.isEmpty() == true) goto L9;
        List<MusicInterval> r101 = getMMusicClimax();
        Intrinsics.checkNotNull(r101);
        return (MusicInterval) ListProtector.get(r101, 0);
    L9:
        return new MusicInterval();
    }

    public final long getId() {
        return getMId();
    }

    @Override // com.bytedance.android.livesdk.message.model.m8
    public /* bridge */ /* synthetic */ m6 getMAccompanimentTrack() {
        return getMAccompanimentTrack();
    }

    @Override // com.bytedance.android.livesdk.message.model.m8
    public /* bridge */ /* synthetic */ m6 getMFullTrack() {
        return getMFullTrack();
    }

    public final OrderInfo getOrderInfo() {
        return getOrderInfoFlex();
    }

    @Override // com.bytedance.android.livesdk.message.model.m8
    public /* bridge */ /* synthetic */ za getOrderInfoFlex() {
        return getOrderInfoFlex();
    }

    public final String getOrderUserIdString() {
        OrderInfo r100 = getOrderInfoFlex();
        if (r100 == null) goto L8;
        Intrinsics.checkNotNullParameter(r100, "$this$topUserFlex");
        b8 r101 = r100.getTopUser();
        if (r101 == null) goto L8;
        String r102 = n8.b(r101);
        if (r102 == null) goto L8;
        return r102;
    L8:
        return "";
    }

    @Override // com.bytedance.android.livesdk.message.model.m8
    public /* bridge */ /* synthetic */ bb getPersonalSongInfo() {
        return getPersonalSongInfo();
    }

    @Override // com.bytedance.android.livesdk.message.model.m8
    public /* bridge */ /* synthetic */ kb getRealTimeChorusInfo() {
        return getRealTimeChorusInfo();
    }

    public final int getSongType() {
        return getMusicType();
    }

    public final String getTitle() {
        String r100 = getMTitle();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Deprecated(message = "")
    public final long getTurnId() {
        Map<String, String> r100 = getExt();
        if (r100 == null) goto L5;
        String r101 = r100.get("term_id");
    L7:
        return com.bytedance.android.livesdk.utils.d5.c(r101);
    L5:
        r101 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.message.model.m8
    public /* bridge */ /* synthetic */ jc getWantListenInfo() {
        return getWantListenInfo();
    }

    @Override // com.bytedance.android.livesdk.message.model.m8
    public String getAddSongSource() {
        return this.addSongSource;
    }

    @Override // com.bytedance.android.livesdk.message.model.m8
    public List<Long> getArtistIds() {
        return this.artistIds;
    }

    @Override // com.bytedance.android.livesdk.message.model.m8
    public List<String> getArtistIdstrs() {
        return this.artistIdstrs;
    }

    @Override // com.bytedance.android.livesdk.message.model.m8
    public List<Integer> getCopyRightList() {
        return this.copyRightList;
    }

    @Override // com.bytedance.android.livesdk.message.model.m8
    public List<Long> getCopyrightedAppIds() {
        return this.copyrightedAppIds;
    }

    @Override // com.bytedance.android.livesdk.message.model.m8
    public Map<String, String> getExt() {
        return this.ext;
    }

    @Override // com.bytedance.android.livesdk.message.model.m8
    public String getExtraJson() {
        return this.extraJson;
    }

    @Override // com.bytedance.android.livesdk.message.model.m8
    public Map<Long, RegionList> getGlobalCopyrightRegionInfo() {
        return this.globalCopyrightRegionInfo;
    }

    @Override // com.bytedance.android.livesdk.message.model.m8
    public String getMAuthor() {
        return this.mAuthor;
    }

    @Override // com.bytedance.android.livesdk.message.model.m8
    public long getMDuration() {
        return this.mDuration;
    }

    @Override // com.bytedance.android.livesdk.message.model.m8
    public long getMId() {
        return this.mId;
    }

    @Override // com.bytedance.android.livesdk.message.model.m8
    public String getMIdStr() {
        return this.mIdStr;
    }

    @Override // com.bytedance.android.livesdk.message.model.m8
    public int getMLyricType() {
        return this.mLyricType;
    }

    @Override // com.bytedance.android.livesdk.message.model.m8
    public List<String> getMLyricUrlList() {
        return this.mLyricUrlList;
    }

    @Override // com.bytedance.android.livesdk.message.model.m8
    public List<MusicInterval> getMMusicClimax() {
        return this.mMusicClimax;
    }

    @Override // com.bytedance.android.livesdk.message.model.m8
    public String getMNewCoverUrl() {
        return this.mNewCoverUrl;
    }

    @Override // com.bytedance.android.livesdk.message.model.m8
    public float getMPreviewStartTime() {
        return this.mPreviewStartTime;
    }

    @Override // com.bytedance.android.livesdk.message.model.m8
    public String getMSongUrl() {
        return this.mSongUrl;
    }

    @Override // com.bytedance.android.livesdk.message.model.m8
    public String getMTitle() {
        return this.mTitle;
    }

    @Override // com.bytedance.android.livesdk.message.model.m8
    public String getMidiUrl() {
        return this.midiUrl;
    }

    @Override // com.bytedance.android.livesdk.message.model.m8
    public int getMusicType() {
        return this.musicType;
    }

    @Override // com.bytedance.android.livesdk.message.model.m8
    public List<RecommendRealTimeChorusInfo> getRecommendRealTimeChorusInfos() {
        return this.recommendRealTimeChorusInfos;
    }

    @Override // com.bytedance.android.livesdk.message.model.m8
    public List<MusicInterval> getSegments() {
        return this.segments;
    }

    @Override // com.bytedance.android.livesdk.message.model.m8
    public List<String> getTags() {
        return this.tags;
    }

    @Override // com.bytedance.android.livesdk.message.model.m8
    public long getTotalOrderCount() {
        return this.totalOrderCount;
    }

    @Override // com.bytedance.android.livesdk.message.model.m8
    public int getTotalOrderWithCurAnchor() {
        return this.totalOrderWithCurAnchor;
    }

    public final String getVocalUrl() {
        return this.vocalUrl;
    }

    @Override // com.bytedance.android.livesdk.message.model.m8
    public boolean isFavorite() {
        return this.isFavorite;
    }

    @Override // com.bytedance.android.livesdk.message.model.m8
    public ChallengeInfo getChallengeInfo() {
        return this.challengeInfo;
    }

    @Override // com.bytedance.android.livesdk.message.model.m8
    public AudioInfo getMAccompanimentTrack() {
        return this.mAccompanimentTrack;
    }

    @Override // com.bytedance.android.livesdk.message.model.m8
    public AudioInfo getMFullTrack() {
        return this.mFullTrack;
    }

    @Override // com.bytedance.android.livesdk.message.model.m8
    public OrderInfo getOrderInfoFlex() {
        return this.orderInfoFlex;
    }

    @Override // com.bytedance.android.livesdk.message.model.m8
    public PersonalSongInfo getPersonalSongInfo() {
        return this.personalSongInfo;
    }

    @Override // com.bytedance.android.livesdk.message.model.m8
    public RealTimeChorusInfo getRealTimeChorusInfo() {
        return this.realTimeChorusInfo;
    }

    @Override // com.bytedance.android.livesdk.message.model.m8
    public WantListenInfo getWantListenInfo() {
        return this.wantListenInfo;
    }

    public KtvMusic(am3.g r110) {
        super(m8.class);
        this.mLyricUrlList = new ArrayList();
        this.tags = new ArrayList();
        this.ext = new HashMap();
        this.mMusicClimax = new ArrayList();
        this.segments = new ArrayList();
        this.artistIds = new ArrayList();
        this.artistIdstrs = new ArrayList();
        this.copyRightList = new ArrayList();
        this.recommendRealTimeChorusInfos = new ArrayList();
        this.copyrightedAppIds = new ArrayList();
        this.globalCopyrightRegionInfo = new HashMap();
        setThreadSafe(false);
        long r100 = r110.c();
        int r101 = 0;
    L3:
        int r102 = r110.f();
        Object r103 = null;
        if (r102 == (-1)) goto L83;
        am3.g.a r104 = decodeExtensionFields(r102, r110);
        if (r102 == 22) goto L82;
        if (r102 != 38) goto L9;
        this.personalSongInfo = new PersonalSongInfo(r110);
        goto L3
    L9:
        switch(r102) {
            case 1: goto L80;
            case 2: goto L79;
            case 3: goto L78;
            case 4: goto L77;
            case 5: goto L76;
            case 6: goto L73;
            case 7: goto L72;
            default: goto L11;
        };
    L72:
        this.mDuration = r110.j();
        r101 = r101 | 4;
        goto L3
    L73:
        List r105 = this.mLyricUrlList;
    L74:
        Object r106 = am3.h.c(r110);
    L75:
        r105.add(r106);
        goto L3
    L76:
        this.mSongUrl = am3.h.c(r110);
        goto L3
    L77:
        this.mLyricType = (int) r110.j();
        r101 = r101 | 2;
        goto L3
    L78:
        this.mAuthor = am3.h.c(r110);
        goto L3
    L79:
        this.mTitle = am3.h.c(r110);
        goto L3
    L80:
        this.mId = r110.j();
        r101 = r101 | 1;
        goto L3
    L11:
        switch(r102) {
            case 10: goto L71;
            case 11: goto L70;
            case 12: goto L69;
            case 13: goto L68;
            case 14: goto L67;
            case 15: goto L66;
            case 16: goto L65;
            case 17: goto L64;
            case 18: goto L48;
            case 19: goto L47;
            default: goto L12;
        };
    L47:
        r105 = this.mMusicClimax;
        r106 = new MusicInterval(r110);
        goto L75
    L48:
        long r111 = r110.c();
        Object r107 = null;
    L49:
        int r108 = r110.f();
        if (r108 == (-1)) goto L56;
        if (r108 != 1) goto L52;
        r103 = am3.h.c(r110);
        goto L49
    L52:
        if (r108 != 2) goto L53;
        r107 = am3.h.c(r110);
        goto L49
    L53:
        am3.h.e(r110);
        goto L49
    L56:
        r110.d(r111);
        Map r109 = this.ext;
        if (r103 == null) goto L63;
        if (r107 == null) goto L61;
    L59:
        r109.put(r103, r107);
        goto L3
    L61:
        throw new IllegalStateException("Value must not be null");
    L63:
        throw new IllegalStateException("Key must not be null");
    L64:
        r105 = this.tags;
        goto L74
    L65:
        this.orderInfoFlex = new OrderInfo(r110);
        goto L3
    L66:
        this.isFavorite = am3.h.a(r110);
        r101 = r101 | 16;
        goto L3
    L67:
        this.midiUrl = am3.h.c(r110);
        goto L3
    L68:
        this.mNewCoverUrl = am3.h.c(r110);
        goto L3
    L69:
        this.mAccompanimentTrack = new AudioInfo(r110);
        goto L3
    L70:
        this.mFullTrack = new AudioInfo(r110);
        goto L3
    L71:
        this.mPreviewStartTime = (float) Double.longBitsToDouble(r110.h());
        r101 = r101 | 8;
        goto L3
    L12:
        switch(r102) {
            case 28: goto L46;
            case 29: goto L45;
            case 30: goto L44;
            case 31: goto L43;
            case 32: goto L41;
            case 33: goto L40;
            case 34: goto L39;
            default: goto L13;
        };
    L39:
        r105 = this.copyRightList;
        r106 = Integer.valueOf(r110.i());
        goto L75
    L40:
        this.mIdStr = am3.h.c(r110);
        goto L3
    L41:
        r105 = this.artistIds;
    L42:
        r106 = Long.valueOf(r110.j());
        goto L75
    L43:
        this.totalOrderCount = r110.j();
        r101 = r101 | 64;
        goto L3
    L44:
        this.totalOrderWithCurAnchor = (int) r110.j();
        r101 = r101 | 128;
        goto L3
    L45:
        this.addSongSource = am3.h.c(r110);
        goto L3
    L46:
        this.musicType = r110.i();
        r101 = r101 | 32;
        goto L3
    L13:
        switch(r102) {
            case 41: goto L38;
            case 42: goto L37;
            case 43: goto L36;
            case 44: goto L35;
            case 45: goto L34;
            case 46: goto L33;
            case 47: goto L17;
            case 48: goto L16;
            case 49: goto L15;
            default: goto L14;
        };
    L15:
        this.vocalUrl = am3.h.c(r110);
        goto L3
    L16:
        r105 = this.artistIdstrs;
        goto L74
    L17:
        long r112 = r110.c();
        r107 = null;
    L18:
        int r113 = r110.f();
        if (r113 == (-1)) goto L25;
        if (r113 != 1) goto L21;
        r103 = Long.valueOf(r110.j());
        goto L18
    L21:
        if (r113 != 2) goto L22;
        r107 = new RegionList(r110);
        goto L18
    L22:
        am3.h.e(r110);
        goto L18
    L25:
        r110.d(r112);
        r109 = this.globalCopyrightRegionInfo;
        if (r103 == null) goto L32;
        if (r107 != null) goto L59;
        throw new IllegalStateException("Value must not be null");
    L32:
        throw new IllegalStateException("Key must not be null");
    L33:
        r105 = this.copyrightedAppIds;
        goto L42
    L34:
        r105 = this.recommendRealTimeChorusInfos;
        r106 = new RecommendRealTimeChorusInfo(r110);
        goto L75
    L35:
        this.extraJson = am3.h.c(r110);
        goto L3
    L36:
        this.realTimeChorusInfo = new RealTimeChorusInfo(r110);
        goto L3
    L37:
        this.challengeInfo = new ChallengeInfo(r110);
        goto L3
    L38:
        this.wantListenInfo = new WantListenInfo(r110);
        goto L3
    L14:
        am3.h.d(r104, r110);
        goto L3
    L82:
        r105 = this.segments;
        r106 = new MusicInterval(r110);
        goto L75
    L83:
        r110.d(r100);
        setThreadSafe(true);
        if ((r101 & 1) != 0) goto L87;
        this.mId = 0;
    L87:
        if (this.mIdStr != null) goto L90;
        this.mIdStr = "";
    L90:
        if (this.mTitle != null) goto L93;
        this.mTitle = "";
    L93:
        if (this.mAuthor != null) goto L96;
        this.mAuthor = "";
    L96:
        if ((r101 & 2) != 0) goto L99;
        this.mLyricType = 3;
    L99:
        if (this.mSongUrl != null) goto L102;
        this.mSongUrl = "";
    L102:
        if (this.mLyricUrlList.isEmpty() == false) goto L105;
        this.mLyricUrlList = null;
    L105:
        if ((r101 & 4) != 0) goto L108;
        this.mDuration = 0;
    L108:
        if ((r101 & 8) != 0) goto L111;
        this.mPreviewStartTime = 0.0f;
    L111:
        if (this.personalSongInfo != null) goto L114;
        this.personalSongInfo = null;
    L114:
        if (this.wantListenInfo != null) goto L117;
        this.wantListenInfo = null;
    L117:
        if (this.mNewCoverUrl != null) goto L120;
        this.mNewCoverUrl = "";
    L120:
        if (this.mFullTrack != null) goto L123;
        this.mFullTrack = null;
    L123:
        if (this.mAccompanimentTrack != null) goto L126;
        this.mAccompanimentTrack = null;
    L126:
        if (this.midiUrl != null) goto L129;
        this.midiUrl = "";
    L129:
        if (this.vocalUrl != null) goto L132;
        this.vocalUrl = "";
    L132:
        if ((r101 & 16) != 0) goto L135;
        this.isFavorite = false;
    L135:
        if (this.orderInfoFlex != null) goto L138;
        this.orderInfoFlex = null;
    L138:
        if (this.tags.isEmpty() == false) goto L141;
        this.tags = null;
    L141:
        if (this.ext != null) goto L144;
        this.ext = null;
    L144:
        if (this.extraJson != null) goto L147;
        this.extraJson = null;
    L147:
        if (this.mMusicClimax.isEmpty() == false) goto L150;
        this.mMusicClimax = null;
    L150:
        if (this.segments.isEmpty() == false) goto L153;
        this.segments = null;
    L153:
        if ((r101 & 32) != 0) goto L156;
        this.musicType = 0;
    L156:
        if (this.addSongSource != null) goto L159;
        this.addSongSource = "";
    L159:
        if ((r101 & 64) != 0) goto L162;
        this.totalOrderCount = 0;
    L162:
        if (this.artistIds.isEmpty() == false) goto L165;
        this.artistIds = null;
    L165:
        if (this.artistIdstrs.isEmpty() == false) goto L168;
        this.artistIdstrs = null;
    L168:
        if ((r101 & 128) != 0) goto L171;
        this.totalOrderWithCurAnchor = 0;
    L171:
        if (this.challengeInfo != null) goto L174;
        this.challengeInfo = null;
    L174:
        if (this.copyRightList.isEmpty() == false) goto L177;
        this.copyRightList = null;
    L177:
        if (this.realTimeChorusInfo != null) goto L180;
        this.realTimeChorusInfo = null;
    L180:
        if (this.recommendRealTimeChorusInfos.isEmpty() == false) goto L183;
        this.recommendRealTimeChorusInfos = null;
    L183:
        if (this.copyrightedAppIds.isEmpty() == false) goto L186;
        this.copyrightedAppIds = null;
    L186:
        if (this.globalCopyrightRegionInfo != null) goto L280;
        this.globalCopyrightRegionInfo = null;
        return;
    }

    public final void correctLyricsType(int r100) {
        setMLyricType(r100);
    }

    public final boolean isOrderedBy(String r100) {
        if (getOrderInfoFlex() == null) goto L9;
        OrderInfo r101 = getOrderInfoFlex();
        Intrinsics.checkNotNull(r101);
        Intrinsics.checkNotNullParameter(r101, "$this$topUserFlex");
        if (r101.getTopUser() == null) goto L9;
        OrderInfo r102 = getOrderInfoFlex();
        Intrinsics.checkNotNull(r102);
        Intrinsics.checkNotNullParameter(r102, "$this$topUserFlex");
        b8 r103 = r102.getTopUser();
        Intrinsics.checkNotNull(r103);
        if (TextUtils.equals(n8.b(r103), r100) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean isSameForDiffUpdate(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this != r100) goto L9;
        return true;
    L9:
        if ((!Intrinsics.areEqual(KtvMusic.class, r100.getClass())) == false) goto L11;
        return false;
    L11:
        KtvMusic r101 = (KtvMusic) r100;
        if (getMId() == r101.getMId()) goto L15;
        return false;
    L15:
        if ((!Intrinsics.areEqual(getPersonalSongInfo(), r101.getPersonalSongInfo())) == false) goto L18;
        return false;
    L18:
        if ((!Intrinsics.areEqual(getWantListenInfo(), r101.getWantListenInfo())) == false) goto L21;
        return false;
    L21:
        if ((!Intrinsics.areEqual(getChallengeInfo(), r101.getChallengeInfo())) == false) goto L24;
        return false;
    L24:
        if ((!Intrinsics.areEqual(getRecommendRealTimeChorusInfos(), r101.getRecommendRealTimeChorusInfos())) == false) goto L26;
        return false;
    L26:
        return true;
    }

    public final boolean isSameKtvMusic(KtvMusic r100) {
        if (r100 != null) goto L4;
    L8:
        return false;
    L4:
        if (r100.getMId() != getMId()) goto L8;
        if (Intrinsics.areEqual(getOrderUserIdString(), r100.getOrderUserIdString()) == false) goto L8;
        return true;
    }

    public final boolean isSameKtvMusicByIdStr(KtvMusic r100) {
        if (r100 != null) goto L4;
    L8:
        return false;
    L4:
        if (Intrinsics.areEqual(r100.getMIdStr(), getMIdStr()) == false) goto L8;
        if (Intrinsics.areEqual(getOrderUserIdString(), r100.getOrderUserIdString()) == false) goto L8;
        return true;
    }

    public final boolean isSinger(String r100) {
        Intrinsics.checkNotNullParameter(r100, "currentUserId");
        if (getOrderInfoFlex() == null) goto L16;
        OrderInfo r101 = getOrderInfoFlex();
        String r102 = null;
        if (r101 == null) goto L7;
        Intrinsics.checkNotNullParameter(r101, "$this$topUserFlex");
        b8 r103 = r101.getTopUser();
    L8:
        if (r103 == null) goto L16;
        OrderInfo r104 = getOrderInfoFlex();
        if (r104 == null) goto L18;
        Intrinsics.checkNotNullParameter(r104, "$this$topUserFlex");
        b8 r105 = r104.getTopUser();
        if (r105 == null) goto L18;
        r102 = n8.b(r105);
    L18:
        return Intrinsics.areEqual(r100, r102);
    L7:
        r103 = null;
    L16:
        return false;
    }

    public void setAddSongSource(String r100) {
        this.addSongSource = r100;
    }

    public void setArtistIds(List<Long> r100) {
        this.artistIds = r100;
    }

    public void setArtistIdstrs(List<String> r100) {
        this.artistIdstrs = r100;
    }

    public void setChallengeInfo(ChallengeInfo r100) {
        this.challengeInfo = r100;
    }

    public void setCopyRightList(List<Integer> r100) {
        this.copyRightList = r100;
    }

    public void setCopyrightedAppIds(List<Long> r100) {
        this.copyrightedAppIds = r100;
    }

    public final void setCoverUrl(String r100) {
        setMNewCoverUrl(r100);
    }

    public void setExt(Map<String, String> r100) {
        this.ext = r100;
    }

    public void setExtraJson(String r100) {
        this.extraJson = r100;
    }

    public void setFavorite(boolean r100) {
        this.isFavorite = r100;
    }

    public void setGlobalCopyrightRegionInfo(Map<Long, RegionList> r100) {
        this.globalCopyrightRegionInfo = r100;
    }

    public final void setId(long r100) {
        setMId(r100);
    }

    public void setMAccompanimentTrack(AudioInfo r100) {
        this.mAccompanimentTrack = r100;
    }

    public void setMAuthor(String r100) {
        this.mAuthor = r100;
    }

    public void setMDuration(long r100) {
        this.mDuration = r100;
    }

    public void setMFullTrack(AudioInfo r100) {
        this.mFullTrack = r100;
    }

    public void setMId(long r100) {
        this.mId = r100;
    }

    public void setMIdStr(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.mIdStr = r100;
    }

    public void setMLyricType(int r100) {
        this.mLyricType = r100;
    }

    public void setMLyricUrlList(List<String> r100) {
        this.mLyricUrlList = r100;
    }

    public void setMMusicClimax(List<MusicInterval> r100) {
        this.mMusicClimax = r100;
    }

    public void setMNewCoverUrl(String r100) {
        this.mNewCoverUrl = r100;
    }

    public void setMPreviewStartTime(float r100) {
        this.mPreviewStartTime = r100;
    }

    public void setMSongUrl(String r100) {
        this.mSongUrl = r100;
    }

    public void setMTitle(String r100) {
        this.mTitle = r100;
    }

    public void setMidiUrl(String r100) {
        this.midiUrl = r100;
    }

    public void setMusicType(int r100) {
        this.musicType = r100;
    }

    public final void setOrderInfo(OrderInfo r100) {
        setOrderInfoFlex(r100);
    }

    public void setOrderInfoFlex(OrderInfo r100) {
        this.orderInfoFlex = r100;
    }

    public void setPersonalSongInfo(PersonalSongInfo r100) {
        this.personalSongInfo = r100;
    }

    public void setRealTimeChorusInfo(RealTimeChorusInfo r100) {
        this.realTimeChorusInfo = r100;
    }

    public void setRecommendRealTimeChorusInfos(List<RecommendRealTimeChorusInfo> r100) {
        this.recommendRealTimeChorusInfos = r100;
    }

    public void setSegments(List<MusicInterval> r100) {
        this.segments = r100;
    }

    public final void setSongType(int r100) {
        setMusicType(r100);
    }

    public void setTags(List<String> r100) {
        this.tags = r100;
    }

    public void setTotalOrderCount(long r100) {
        this.totalOrderCount = r100;
    }

    public void setTotalOrderWithCurAnchor(int r100) {
        this.totalOrderWithCurAnchor = r100;
    }

    public final void setVocalUrl(String r100) {
        this.vocalUrl = r100;
    }

    public void setWantListenInfo(WantListenInfo r100) {
        this.wantListenInfo = r100;
    }

    public /* synthetic */ KtvMusic(long r310, String r410, String r411, String r412, int r413, String r414, List r415, long r416, float r417, PersonalSongInfo r418, WantListenInfo r510, String r511, AudioInfo r512, AudioInfo r513, String r514, String r515, boolean r516, OrderInfo r517, List r518, Map r519, String r610, List r611, List r612, int r613, String r614, long r615, List r616, List r617, int r618, ChallengeInfo r710, List r711, RealTimeChorusInfo r712, List r713, List r714, Map r715, int r716, int r717, DefaultConstructorMarker r718) {
        if ((r716 & 1) == 0) goto L5;
        long r100 = 0;
    L7:
        if ((r716 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r716 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r716 & 8) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r716 & 16) == 0) goto L21;
        int r104 = 3;
    L23:
        if ((r716 & 32) == 0) goto L25;
        String r110 = "";
    L27:
        if ((r716 & 64) == 0) goto L29;
        List r111 = null;
    L31:
        if ((r716 & 128) == 0) goto L33;
        long r112 = 0;
    L35:
        if ((r716 & 256) == 0) goto L37;
        float r113 = 0.0f;
    L39:
        if ((r716 & 512) == 0) goto L41;
        PersonalSongInfo r105 = null;
    L43:
        if ((r716 & 1024) == 0) goto L45;
        WantListenInfo r106 = null;
    L47:
        if ((r716 & 2048) == 0) goto L49;
        String r114 = "";
    L51:
        if ((r716 & 4096) == 0) goto L53;
        AudioInfo r107 = null;
    L54:
        AudioInfo r719 = r107;
        if ((r716 & 8192) == 0) goto L57;
        AudioInfo r108 = null;
    L58:
        AudioInfo r115 = r108;
        if ((r716 & 16384) == 0) goto L61;
        String r109 = "";
    L63:
        if ((r716 & 32768) == 0) goto L65;
        String r116 = "";
    L66:
        int r210 = 0;
        if ((r716 & 65536) == 0) goto L69;
        boolean r211 = false;
    L71:
        if ((r716 & 131072) == 0) goto L73;
        OrderInfo r212 = null;
    L75:
        if ((r716 & 262144) == 0) goto L77;
        List r213 = null;
    L79:
        if ((r716 & 524288) == 0) goto L81;
        Map r214 = null;
    L83:
        if ((r716 & 1048576) == 0) goto L85;
        String r215 = null;
    L87:
        if ((r716 & 2097152) == 0) goto L89;
        List r216 = null;
    L91:
        if ((r716 & 4194304) == 0) goto L93;
        List r217 = null;
    L95:
        if ((r716 & 8388608) == 0) goto L97;
        int r218 = 0;
    L99:
        if ((r716 & 16777216) == 0) goto L101;
        String r219 = "";
    L103:
        if ((r716 & 33554432) == 0) goto L105;
        long r117 = 0;
    L107:
        if ((r716 & 67108864) == 0) goto L109;
        List r311 = null;
    L111:
        if ((r716 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        List r312 = null;
    L115:
        if ((r716 & 268435456) != 0) goto L119;
        r210 = r618;
    L119:
        if ((r716 & 536870912) == 0) goto L121;
        ChallengeInfo r313 = null;
    L123:
        if ((r716 & 1073741824) == 0) goto L125;
        List r314 = null;
    L127:
        if ((r716 & Integer.MIN_VALUE) == 0) goto L129;
        RealTimeChorusInfo r118 = null;
    L131:
        if ((r717 & 1) == 0) goto L133;
        List r315 = null;
    L135:
        if ((r717 & 2) == 0) goto L137;
        List r316 = null;
    L139:
        if ((r717 & 4) == 0) goto L141;
        Map r317 = null;
    L142:
        this(r100, r101, r102, r103, r104, r110, r111, r112, r113, r105, r106, r114, r719, r115, r109, r116, r211, r212, r213, r214, r215, r216, r217, r218, r219, r117, r311, r312, r210, r313, r314, r118, r315, r316, r317);
        return;
    L141:
        r317 = r715;
        goto L142
    L137:
        r316 = r714;
        goto L139
    L133:
        r315 = r713;
        goto L135
    L129:
        r118 = r712;
        goto L131
    L125:
        r314 = r711;
        goto L127
    L121:
        r313 = r710;
        goto L123
    L113:
        r312 = r617;
        goto L115
    L109:
        r311 = r616;
        goto L111
    L105:
        r117 = r615;
        goto L107
    L101:
        r219 = r614;
        goto L103
    L97:
        r218 = r613;
        goto L99
    L93:
        r217 = r612;
        goto L95
    L89:
        r216 = r611;
        goto L91
    L85:
        r215 = r610;
        goto L87
    L81:
        r214 = r519;
        goto L83
    L77:
        r213 = r518;
        goto L79
    L73:
        r212 = r517;
        goto L75
    L69:
        r211 = r516;
        goto L71
    L65:
        r116 = r515;
        goto L66
    L61:
        r109 = r514;
        goto L63
    L57:
        r108 = r513;
        goto L58
    L53:
        r107 = r512;
        goto L54
    L49:
        r114 = r511;
        goto L51
    L45:
        r106 = r510;
        goto L47
    L41:
        r105 = r418;
        goto L43
    L37:
        r113 = r417;
        goto L39
    L33:
        r112 = r416;
        goto L35
    L29:
        r111 = r415;
        goto L31
    L25:
        r110 = r414;
        goto L27
    L21:
        r104 = r413;
        goto L23
    L17:
        r103 = r412;
        goto L19
    L13:
        r102 = r411;
        goto L15
    L9:
        r101 = r410;
        goto L11
    L5:
        r100 = r310;
        goto L7
    }
}

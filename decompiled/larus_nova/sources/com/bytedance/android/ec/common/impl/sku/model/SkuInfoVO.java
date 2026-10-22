package com.bytedance.android.ec.common.impl.sku.model;

import android.os.SystemClock;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.ec.common.impl.sku.repository.dto.SkuAddCartGuideInfo;
import com.bytedance.android.ec.common.impl.sku.repository.dto.UpdateActionOption;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.api.LogPbData;
import com.bytedance.android.ec.model.sku.ButtonTipComponent;
import com.bytedance.android.ec.model.sku.CarAdaptComponent;
import com.bytedance.android.ec.model.sku.DisplayConfig;
import com.bytedance.android.ec.model.sku.OrderComponent;
import com.bytedance.android.ec.model.sku.SafeguardComponent;
import com.bytedance.android.ec.model.sku.SkuBottomButtons;
import com.bytedance.android.ec.model.sku.SkuPoiInfo;
import com.bytedance.android.ec.model.sku.SkuTrustTags;
import com.bytedance.android.ec.model.sku.TopBannerComponent;
import com.bytedance.android.ec.model.sku.TradeModeComponent;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¿\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0003\bß\u0001\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001Bã\u0007\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010-\u001a\u00020*\u0012\b\b\u0002\u0010.\u001a\u00020\u0011\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u00100\u001a\u00020\u0011\u0012\b\b\u0002\u00101\u001a\u00020\u0011\u0012\b\b\u0002\u00102\u001a\u00020\u0011\u0012\b\b\u0002\u00103\u001a\u00020\u0011\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u000105\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u000107\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u000105\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010<\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010?\u0012\b\b\u0002\u0010@\u001a\u00020<\u0012\b\b\u0002\u0010A\u001a\u00020*\u0012\b\b\u0002\u0010B\u001a\u00020*\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010D\u0012\u0010\b\u0002\u0010E\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010\u0007\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010H\u0012\n\b\u0002\u0010I\u001a\u0004\u0018\u00010J\u0012\n\b\u0002\u0010K\u001a\u0004\u0018\u00010L\u0012\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010<\u0012\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010U\u001a\u0004\u0018\u00010<\u0012\n\b\u0002\u0010V\u001a\u0004\u0018\u00010<\u0012\n\b\u0002\u0010W\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010X\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010<\u0012\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010^\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010_\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010`\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010a\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010b\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u0010c\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010d\u001a\u0004\u0018\u00010e\u0012\u0016\b\u0002\u0010f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010g\u001a\u0004\u0018\u00010h\u0012\n\b\u0002\u0010i\u001a\u0004\u0018\u00010j¢\u0006\u0002\u0010kJ\u0016\u0010÷\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\n\u0010ø\u0001\u001a\u00020\u0011HÆ\u0003J\f\u0010ù\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\n\u0010ú\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010û\u0001\u001a\u00020\u0015HÆ\u0003J\u0012\u0010ü\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0003\u0010\u008f\u0001J\u0012\u0010ý\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0003\u0010\u008f\u0001J\f\u0010þ\u0001\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0012\u0010ÿ\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0003\u0010\u008f\u0001J\f\u0010\u0080\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u0081\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u0082\u0002\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\f\u0010\u0083\u0002\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\f\u0010\u0084\u0002\u001a\u0004\u0018\u00010 HÆ\u0003J\f\u0010\u0085\u0002\u001a\u0004\u0018\u00010\"HÆ\u0003J\f\u0010\u0086\u0002\u001a\u0004\u0018\u00010$HÆ\u0003J\f\u0010\u0087\u0002\u001a\u0004\u0018\u00010&HÆ\u0003J\f\u0010\u0088\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u0089\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0011\u0010\u008a\u0002\u001a\u0004\u0018\u00010*HÆ\u0003¢\u0006\u0002\u0010tJ\f\u0010\u008b\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0012\u0010\u008c\u0002\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0003\u0010\u008f\u0001J\f\u0010\u008d\u0002\u001a\u0004\u0018\u00010\nHÆ\u0003J\n\u0010\u008e\u0002\u001a\u00020*HÆ\u0003J\n\u0010\u008f\u0002\u001a\u00020\u0011HÆ\u0003J\f\u0010\u0090\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\n\u0010\u0091\u0002\u001a\u00020\u0011HÆ\u0003J\n\u0010\u0092\u0002\u001a\u00020\u0011HÆ\u0003J\n\u0010\u0093\u0002\u001a\u00020\u0011HÆ\u0003J\n\u0010\u0094\u0002\u001a\u00020\u0011HÆ\u0003J\f\u0010\u0095\u0002\u001a\u0004\u0018\u000105HÆ\u0003J\f\u0010\u0096\u0002\u001a\u0004\u0018\u000107HÆ\u0003J\f\u0010\u0097\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u0098\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010\u0099\u0002\u001a\u0004\u0018\u000105HÆ\u0003J\u0011\u0010\u009a\u0002\u001a\u0004\u0018\u00010*HÆ\u0003¢\u0006\u0002\u0010tJ\u0012\u0010\u009b\u0002\u001a\u0004\u0018\u00010<HÆ\u0003¢\u0006\u0003\u0010\u009a\u0001J\u0011\u0010\u009c\u0002\u001a\u0004\u0018\u00010*HÆ\u0003¢\u0006\u0002\u0010tJ\f\u0010\u009d\u0002\u001a\u0004\u0018\u00010?HÆ\u0003J\n\u0010\u009e\u0002\u001a\u00020<HÆ\u0003J\n\u0010\u009f\u0002\u001a\u00020*HÆ\u0003J\n\u0010 \u0002\u001a\u00020*HÆ\u0003J\f\u0010¡\u0002\u001a\u0004\u0018\u00010DHÆ\u0003J\u0012\u0010¢\u0002\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010\u0007HÆ\u0003J\f\u0010£\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010¤\u0002\u001a\u0004\u0018\u00010HHÆ\u0003J\f\u0010¥\u0002\u001a\u0004\u0018\u00010JHÆ\u0003J\f\u0010¦\u0002\u001a\u0004\u0018\u00010LHÆ\u0003J\u0012\u0010§\u0002\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0003\u0010\u008f\u0001J\f\u0010¨\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010©\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0012\u0010ª\u0002\u001a\u0004\u0018\u00010<HÆ\u0003¢\u0006\u0003\u0010\u009a\u0001J\f\u0010«\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0012\u0010¬\u0002\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0003\u0010\u008f\u0001J\f\u0010\u00ad\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0018\u0010®\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010¯\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0012\u0010°\u0002\u001a\u0004\u0018\u00010<HÆ\u0003¢\u0006\u0003\u0010\u009a\u0001J\u0012\u0010±\u0002\u001a\u0004\u0018\u00010<HÆ\u0003¢\u0006\u0003\u0010\u009a\u0001J\f\u0010²\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0012\u0010³\u0002\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0003\u0010\u008f\u0001J\u0012\u0010´\u0002\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0003\u0010\u008f\u0001J\f\u0010µ\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010¶\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0012\u0010·\u0002\u001a\u0004\u0018\u00010<HÆ\u0003¢\u0006\u0003\u0010\u009a\u0001J\f\u0010¸\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0018\u0010¹\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0012\u0010º\u0002\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0003\u0010\u008f\u0001J\u0012\u0010»\u0002\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0003\u0010\u008f\u0001J\f\u0010¼\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010½\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0011\u0010¾\u0002\u001a\u0004\u0018\u00010*HÆ\u0003¢\u0006\u0002\u0010tJ\f\u0010¿\u0002\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\f\u0010À\u0002\u001a\u0004\u0018\u00010eHÆ\u0003J\u0018\u0010Á\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010Â\u0002\u001a\u0004\u0018\u00010hHÆ\u0003J\f\u0010Ã\u0002\u001a\u0004\u0018\u00010jHÆ\u0003J\u0018\u0010Ä\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\n\u0010Å\u0002\u001a\u00020\u0011HÆ\u0003Jî\u0007\u0010Æ\u0002\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010-\u001a\u00020*2\b\b\u0002\u0010.\u001a\u00020\u00112\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u00100\u001a\u00020\u00112\b\b\u0002\u00101\u001a\u00020\u00112\b\b\u0002\u00102\u001a\u00020\u00112\b\b\u0002\u00103\u001a\u00020\u00112\n\b\u0002\u00104\u001a\u0004\u0018\u0001052\n\b\u0002\u00106\u001a\u0004\u0018\u0001072\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u00109\u001a\u0004\u0018\u0001052\n\b\u0002\u0010:\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010<2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010?2\b\b\u0002\u0010@\u001a\u00020<2\b\b\u0002\u0010A\u001a\u00020*2\b\b\u0002\u0010B\u001a\u00020*2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010D2\u0010\b\u0002\u0010E\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010\u00072\n\b\u0002\u0010G\u001a\u0004\u0018\u00010H2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010J2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010L2\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010P\u001a\u0004\u0018\u00010<2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010U\u001a\u0004\u0018\u00010<2\n\b\u0002\u0010V\u001a\u0004\u0018\u00010<2\n\b\u0002\u0010W\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010X\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010<2\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010^\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010_\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010`\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010a\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010b\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010c\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010d\u001a\u0004\u0018\u00010e2\u0016\b\u0002\u0010f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010g\u001a\u0004\u0018\u00010h2\n\b\u0002\u0010i\u001a\u0004\u0018\u00010jHÆ\u0001¢\u0006\u0003\u0010Ç\u0002J\u0016\u0010È\u0002\u001a\u00020<2\n\u0010É\u0002\u001a\u0005\u0018\u00010Ê\u0002HÖ\u0003J\n\u0010Ë\u0002\u001a\u00020*HÖ\u0001J\u0007\u0010Ì\u0002\u001a\u00020<J\u0007\u0010Í\u0002\u001a\u00020<J\u0007\u0010Î\u0002\u001a\u00020<J\u0007\u0010Ï\u0002\u001a\u00020<J\u0007\u0010Ð\u0002\u001a\u00020<J\u0007\u0010Ñ\u0002\u001a\u00020<J\u0007\u0010Ò\u0002\u001a\u00020<J\u0007\u0010Ó\u0002\u001a\u00020<J\n\u0010Ô\u0002\u001a\u00020\u0004HÖ\u0001R\u0013\u00104\u001a\u0004\u0018\u000105¢\u0006\b\n\u0000\u001a\u0004\bl\u0010mR\u0013\u0010g\u001a\u0004\u0018\u00010h¢\u0006\b\n\u0000\u001a\u0004\bn\u0010oR\u0013\u00109\u001a\u0004\u0018\u000105¢\u0006\b\n\u0000\u001a\u0004\bp\u0010mR\u0013\u00108\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\bq\u0010rR\u001e\u0010b\u001a\u0004\u0018\u00010*X\u0086\u000e¢\u0006\u0010\n\u0002\u0010w\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\bx\u0010rR\u001f\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\by\u0010zR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b{\u0010rR\u0013\u0010d\u001a\u0004\u0018\u00010e¢\u0006\b\n\u0000\u001a\u0004\b|\u0010}R\u001c\u00101\u001a\u00020\u0011X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R\u001d\u00100\u001a\u00020\u0011X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u0082\u0001\u0010\u007f\"\u0006\b\u0083\u0001\u0010\u0081\u0001R\u0016\u0010:\u001a\u0004\u0018\u00010*¢\u0006\u000b\n\u0002\u0010w\u001a\u0005\b\u0084\u0001\u0010tR\u0015\u0010I\u001a\u0004\u0018\u00010J¢\u0006\n\n\u0000\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0000\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0089\u0001\u0010rR\u001b\u0010E\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010\u0007¢\u0006\n\n\u0000\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u008c\u0001\u0010rR\u0012\u0010.\u001a\u00020\u0011¢\u0006\t\n\u0000\u001a\u0005\b\u008d\u0001\u0010\u007fR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u0011¢\u0006\r\n\u0003\u0010\u0090\u0001\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001R\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0091\u0001\u0010rR\u0013\u0010B\u001a\u00020*¢\u0006\n\n\u0000\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001R\u0015\u0010G\u001a\u0004\u0018\u00010H¢\u0006\n\n\u0000\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001R#\u0010M\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u0090\u0001\u001a\u0006\b\u0096\u0001\u0010\u008f\u0001\"\u0006\b\u0097\u0001\u0010\u0098\u0001R#\u0010P\u001a\u0004\u0018\u00010<X\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u009d\u0001\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001\"\u0006\b\u009b\u0001\u0010\u009c\u0001R\u001f\u0010N\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u009e\u0001\u0010r\"\u0006\b\u009f\u0001\u0010 \u0001R\u001f\u0010O\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b¡\u0001\u0010r\"\u0006\b¢\u0001\u0010 \u0001R\u001f\u0010Q\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b£\u0001\u0010r\"\u0006\b¤\u0001\u0010 \u0001R\u0016\u0010=\u001a\u0004\u0018\u00010*¢\u0006\u000b\n\u0002\u0010w\u001a\u0005\b¥\u0001\u0010tR\u0018\u0010;\u001a\u0004\u0018\u00010<¢\u0006\r\n\u0003\u0010\u009d\u0001\u001a\u0006\b¦\u0001\u0010\u009a\u0001R#\u0010_\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u0090\u0001\u001a\u0006\b§\u0001\u0010\u008f\u0001\"\u0006\b¨\u0001\u0010\u0098\u0001R#\u0010^\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u0090\u0001\u001a\u0006\b©\u0001\u0010\u008f\u0001\"\u0006\bª\u0001\u0010\u0098\u0001R\u001f\u0010`\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b«\u0001\u0010r\"\u0006\b¬\u0001\u0010 \u0001R\u001f\u0010a\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u00ad\u0001\u0010r\"\u0006\b®\u0001\u0010 \u0001R\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\n\n\u0000\u001a\u0006\b¯\u0001\u0010°\u0001R\u0014\u0010/\u001a\u0004\u0018\u00010\u0004¢\u0006\t\n\u0000\u001a\u0005\b±\u0001\u0010rR\u0014\u0010'\u001a\u0004\u0018\u00010\u0004¢\u0006\t\n\u0000\u001a\u0005\b²\u0001\u0010rR\u0015\u0010C\u001a\u0004\u0018\u00010D¢\u0006\n\n\u0000\u001a\u0006\b³\u0001\u0010´\u0001R\u0013\u0010\u0016\u001a\u00020\u0015¢\u0006\n\n\u0000\u001a\u0006\bµ\u0001\u0010¶\u0001R\u0012\u00103\u001a\u00020\u0011¢\u0006\t\n\u0000\u001a\u0005\b·\u0001\u0010\u007fR\u0012\u0010\u0012\u001a\u00020\u0011¢\u0006\t\n\u0000\u001a\u0005\b¸\u0001\u0010\u007fR\u0012\u0010\u0010\u001a\u00020\u0011¢\u0006\t\n\u0000\u001a\u0005\b¹\u0001\u0010\u007fR\u001f\u0010+\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\bº\u0001\u0010r\"\u0006\b»\u0001\u0010 \u0001R\u0015\u0010K\u001a\u0004\u0018\u00010L¢\u0006\n\n\u0000\u001a\u0006\b¼\u0001\u0010½\u0001R \u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\b¾\u0001\u0010zR\u0015\u00106\u001a\u0004\u0018\u000107¢\u0006\n\n\u0000\u001a\u0006\b¿\u0001\u0010À\u0001R\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u0004¢\u0006\t\n\u0000\u001a\u0005\bÁ\u0001\u0010rR\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u0011¢\u0006\r\n\u0003\u0010\u0090\u0001\u001a\u0006\bÂ\u0001\u0010\u008f\u0001R\u0014\u0010(\u001a\u0004\u0018\u00010\u0004¢\u0006\t\n\u0000\u001a\u0005\bÃ\u0001\u0010rR \u0010)\u001a\u0004\u0018\u00010*X\u0086\u000e¢\u0006\u0012\n\u0002\u0010w\u001a\u0005\bÄ\u0001\u0010t\"\u0005\bÅ\u0001\u0010vR#\u0010X\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u0090\u0001\u001a\u0006\bÆ\u0001\u0010\u008f\u0001\"\u0006\bÇ\u0001\u0010\u0098\u0001R\u0014\u0010c\u001a\u0004\u0018\u00010\u0004¢\u0006\t\n\u0000\u001a\u0005\bÈ\u0001\u0010rR#\u0010Y\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u0090\u0001\u001a\u0006\bÉ\u0001\u0010\u008f\u0001\"\u0006\bÊ\u0001\u0010\u0098\u0001R#\u0010\\\u001a\u0004\u0018\u00010<X\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u009d\u0001\u001a\u0006\bË\u0001\u0010\u009a\u0001\"\u0006\bÌ\u0001\u0010\u009c\u0001R\u001f\u0010Z\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\bÍ\u0001\u0010r\"\u0006\bÎ\u0001\u0010 \u0001R\u001f\u0010[\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\bÏ\u0001\u0010r\"\u0006\bÐ\u0001\u0010 \u0001R\u001f\u0010]\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\bÑ\u0001\u0010r\"\u0006\bÒ\u0001\u0010 \u0001R\u0015\u0010!\u001a\u0004\u0018\u00010\"¢\u0006\n\n\u0000\u001a\u0006\bÓ\u0001\u0010Ô\u0001R#\u0010R\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u0090\u0001\u001a\u0006\bÕ\u0001\u0010\u008f\u0001\"\u0006\bÖ\u0001\u0010\u0098\u0001R\u0018\u0010V\u001a\u0004\u0018\u00010<¢\u0006\r\n\u0003\u0010\u009d\u0001\u001a\u0006\b×\u0001\u0010\u009a\u0001R#\u0010U\u001a\u0004\u0018\u00010<X\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u009d\u0001\u001a\u0006\bØ\u0001\u0010\u009a\u0001\"\u0006\bÙ\u0001\u0010\u009c\u0001R\u001f\u0010S\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\bÚ\u0001\u0010r\"\u0006\bÛ\u0001\u0010 \u0001R\u001f\u0010T\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\bÜ\u0001\u0010r\"\u0006\bÝ\u0001\u0010 \u0001R\u001f\u0010W\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\bÞ\u0001\u0010r\"\u0006\bß\u0001\u0010 \u0001R\u0012\u00102\u001a\u00020\u0011¢\u0006\t\n\u0000\u001a\u0005\bà\u0001\u0010\u007fR\u0013\u0010A\u001a\u00020*¢\u0006\n\n\u0000\u001a\u0006\bá\u0001\u0010\u0093\u0001R\u0013\u0010@\u001a\u00020<¢\u0006\n\n\u0000\u001a\u0006\bâ\u0001\u0010ã\u0001R \u0010f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\bä\u0001\u0010zR\u0015\u0010>\u001a\u0004\u0018\u00010?¢\u0006\n\n\u0000\u001a\u0006\bå\u0001\u0010æ\u0001R\u001e\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\t\n\u0000\u001a\u0005\bç\u0001\u0010zR#\u0010,\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0015\n\u0003\u0010\u0090\u0001\u001a\u0006\bè\u0001\u0010\u008f\u0001\"\u0006\bé\u0001\u0010\u0098\u0001R \u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\bê\u0001\u0010zR\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\n\n\u0000\u001a\u0006\bë\u0001\u0010\u008b\u0001R\u0013\u0010-\u001a\u00020*¢\u0006\n\n\u0000\u001a\u0006\bì\u0001\u0010\u0093\u0001R\u0015\u0010#\u001a\u0004\u0018\u00010$¢\u0006\n\n\u0000\u001a\u0006\bí\u0001\u0010î\u0001R\u0015\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\n\n\u0000\u001a\u0006\bï\u0001\u0010ð\u0001R\u0015\u0010%\u001a\u0004\u0018\u00010&¢\u0006\n\n\u0000\u001a\u0006\bñ\u0001\u0010ò\u0001R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u0011¢\u0006\r\n\u0003\u0010\u0090\u0001\u001a\u0006\bó\u0001\u0010\u008f\u0001R\u0015\u0010i\u001a\u0004\u0018\u00010j¢\u0006\n\n\u0000\u001a\u0006\bô\u0001\u0010õ\u0001R\u0013\u0010\u0014\u001a\u00020\u0015¢\u0006\n\n\u0000\u001a\u0006\bö\u0001\u0010¶\u0001¨\u0006Õ\u0002"}, d2 = {"Lcom/bytedance/android/ec/common/impl/sku/model/SkuInfoVO;", "Ljava/io/Serializable;", "skuList", "", "", "Lcom/bytedance/android/ec/common/impl/sku/model/SkuItemInfoVO;", "specInfoList", "", "Lcom/bytedance/android/ec/common/impl/sku/model/SpecInfo;", "clothesSizeAssistant", "Lcom/bytedance/android/ec/common/impl/sku/model/ClothesSizeAssistantStruct;", "cover", "bigCover", "pictureMap", "bigPicMap", "smallPicMap", "minPrice", "", "maxPrice", "buttonLabel", "upperLimit", "Lcom/bytedance/android/ec/common/impl/sku/model/SkuLimit;", "lowerLimit", "unUseMinPrice", "discountPrice", "discountPriceHeader", "presellType", "deliveryDelayDesc", "presellDelayDesc", "installmentInfo", "Lcom/bytedance/android/ec/common/impl/sku/model/SkuInstallmentItemInfo;", "tradeModeComponent", "Lcom/bytedance/android/ec/model/sku/TradeModeComponent;", "safeguardComponent", "Lcom/bytedance/android/ec/model/sku/SafeguardComponent;", "topBannerComponent", "Lcom/bytedance/android/ec/model/sku/TopBannerComponent;", "trustTags", "Lcom/bytedance/android/ec/model/sku/SkuTrustTags;", "logExtra", "priceHeader", "priceHeaderStyle", "", "newBonusText", "skuType", "status", "depositPrice", "limitText", "campaignStartTime", "campaignEndTime", "serverTime", "marketPrice", "activityIcon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "poiInfo", "Lcom/bytedance/android/ec/model/sku/SkuPoiInfo;", "atmosphereHeader", "atmosphereBackground", "campaignSubType", "hasGivenProduct", "", "givenProductStock", "skuBanner", "Lcom/bytedance/android/ec/common/impl/sku/model/SkuBannerStruct;", "showStock", "showPriceStyle", "discountPriceStyleType", "logPb", "Lcom/bytedance/android/ec/model/api/LogPbData;", "defaultButtons", "Lcom/bytedance/android/ec/model/sku/SkuBottomButtons;", "displayConfig", "Lcom/bytedance/android/ec/model/sku/DisplayConfig;", "carAdaptComponent", "Lcom/bytedance/android/ec/model/sku/CarAdaptComponent;", "orderComponent", "Lcom/bytedance/android/ec/model/sku/OrderComponent;", "firstPrice", "firstPricePrefix", "firstPriceSuffix", "firstPriceIsUnderline", "firstPriceSupplement", "secondPrice", "secondPricePrefix", "secondPriceSuffix", "secondPriceIsUnderline", "secondPriceIsReducePrice", "secondPriceSupplement", "priceType", "regularPrice", "regularPricePrefix", "regularPriceSuffix", "regularPriceIsUnderline", "regularPriceSupplement", "hotMinPrice", "hotMaxPrice", "hotPricePrefix", "hotPriceSupplement", "atmosphereStyle", "productExtra", "buttonTipComponent", "Lcom/bytedance/android/ec/model/sku/ButtonTipComponent;", "showTrackParams", "addCartGuideInfo", "Lcom/bytedance/android/ec/common/impl/sku/repository/dto/SkuAddCartGuideInfo;", "updateActionOption", "Lcom/bytedance/android/ec/common/impl/sku/repository/dto/UpdateActionOption;", "(Ljava/util/Map;Ljava/util/List;Lcom/bytedance/android/ec/common/impl/sku/model/ClothesSizeAssistantStruct;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;JJLjava/lang/String;Lcom/bytedance/android/ec/common/impl/sku/model/SkuLimit;Lcom/bytedance/android/ec/common/impl/sku/model/SkuLimit;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/common/impl/sku/model/SkuInstallmentItemInfo;Lcom/bytedance/android/ec/model/sku/TradeModeComponent;Lcom/bytedance/android/ec/model/sku/SafeguardComponent;Lcom/bytedance/android/ec/model/sku/TopBannerComponent;Lcom/bytedance/android/ec/model/sku/SkuTrustTags;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;IJLjava/lang/String;JJJJLcom/bytedance/android/ec/model/ECUrlModel;Lcom/bytedance/android/ec/model/sku/SkuPoiInfo;Ljava/lang/String;Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Lcom/bytedance/android/ec/common/impl/sku/model/SkuBannerStruct;ZIILcom/bytedance/android/ec/model/api/LogPbData;Ljava/util/List;Lcom/bytedance/android/ec/model/sku/DisplayConfig;Lcom/bytedance/android/ec/model/sku/CarAdaptComponent;Lcom/bytedance/android/ec/model/sku/OrderComponent;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/android/ec/model/sku/ButtonTipComponent;Ljava/util/Map;Lcom/bytedance/android/ec/common/impl/sku/repository/dto/SkuAddCartGuideInfo;Lcom/bytedance/android/ec/common/impl/sku/repository/dto/UpdateActionOption;)V", "getActivityIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "getAddCartGuideInfo", "()Lcom/bytedance/android/ec/common/impl/sku/repository/dto/SkuAddCartGuideInfo;", "getAtmosphereBackground", "getAtmosphereHeader", "()Ljava/lang/String;", "getAtmosphereStyle", "()Ljava/lang/Integer;", "setAtmosphereStyle", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getBigCover", "getBigPicMap", "()Ljava/util/Map;", "getButtonLabel", "getButtonTipComponent", "()Lcom/bytedance/android/ec/model/sku/ButtonTipComponent;", "getCampaignEndTime", "()J", "setCampaignEndTime", "(J)V", "getCampaignStartTime", "setCampaignStartTime", "getCampaignSubType", "getCarAdaptComponent", "()Lcom/bytedance/android/ec/model/sku/CarAdaptComponent;", "getClothesSizeAssistant", "()Lcom/bytedance/android/ec/common/impl/sku/model/ClothesSizeAssistantStruct;", "getCover", "getDefaultButtons", "()Ljava/util/List;", "getDeliveryDelayDesc", "getDepositPrice", "getDiscountPrice", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDiscountPriceHeader", "getDiscountPriceStyleType", "()I", "getDisplayConfig", "()Lcom/bytedance/android/ec/model/sku/DisplayConfig;", "getFirstPrice", "setFirstPrice", "(Ljava/lang/Long;)V", "getFirstPriceIsUnderline", "()Ljava/lang/Boolean;", "setFirstPriceIsUnderline", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getFirstPricePrefix", "setFirstPricePrefix", "(Ljava/lang/String;)V", "getFirstPriceSuffix", "setFirstPriceSuffix", "getFirstPriceSupplement", "setFirstPriceSupplement", "getGivenProductStock", "getHasGivenProduct", "getHotMaxPrice", "setHotMaxPrice", "getHotMinPrice", "setHotMinPrice", "getHotPricePrefix", "setHotPricePrefix", "getHotPriceSupplement", "setHotPriceSupplement", "getInstallmentInfo", "()Lcom/bytedance/android/ec/common/impl/sku/model/SkuInstallmentItemInfo;", "getLimitText", "getLogExtra", "getLogPb", "()Lcom/bytedance/android/ec/model/api/LogPbData;", "getLowerLimit", "()Lcom/bytedance/android/ec/common/impl/sku/model/SkuLimit;", "getMarketPrice", "getMaxPrice", "getMinPrice", "getNewBonusText", "setNewBonusText", "getOrderComponent", "()Lcom/bytedance/android/ec/model/sku/OrderComponent;", "getPictureMap", "getPoiInfo", "()Lcom/bytedance/android/ec/model/sku/SkuPoiInfo;", "getPresellDelayDesc", "getPresellType", "getPriceHeader", "getPriceHeaderStyle", "setPriceHeaderStyle", "getPriceType", "setPriceType", "getProductExtra", "getRegularPrice", "setRegularPrice", "getRegularPriceIsUnderline", "setRegularPriceIsUnderline", "getRegularPricePrefix", "setRegularPricePrefix", "getRegularPriceSuffix", "setRegularPriceSuffix", "getRegularPriceSupplement", "setRegularPriceSupplement", "getSafeguardComponent", "()Lcom/bytedance/android/ec/model/sku/SafeguardComponent;", "getSecondPrice", "setSecondPrice", "getSecondPriceIsReducePrice", "getSecondPriceIsUnderline", "setSecondPriceIsUnderline", "getSecondPricePrefix", "setSecondPricePrefix", "getSecondPriceSuffix", "setSecondPriceSuffix", "getSecondPriceSupplement", "setSecondPriceSupplement", "getServerTime", "getShowPriceStyle", "getShowStock", "()Z", "getShowTrackParams", "getSkuBanner", "()Lcom/bytedance/android/ec/common/impl/sku/model/SkuBannerStruct;", "getSkuList", "getSkuType", "setSkuType", "getSmallPicMap", "getSpecInfoList", "getStatus", "getTopBannerComponent", "()Lcom/bytedance/android/ec/model/sku/TopBannerComponent;", "getTradeModeComponent", "()Lcom/bytedance/android/ec/model/sku/TradeModeComponent;", "getTrustTags", "()Lcom/bytedance/android/ec/model/sku/SkuTrustTags;", "getUnUseMinPrice", "getUpdateActionOption", "()Lcom/bytedance/android/ec/common/impl/sku/repository/dto/UpdateActionOption;", "getUpperLimit", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component5", "component50", "component51", "component52", "component53", "component54", "component55", "component56", "component57", "component58", "component59", "component6", "component60", "component61", "component62", "component63", "component64", "component65", "component66", "component67", "component68", "component69", "component7", "component70", "component71", "component72", "component73", "component74", "component75", "component76", "component77", "component78", "component79", "component8", "component9", "copy", "(Ljava/util/Map;Ljava/util/List;Lcom/bytedance/android/ec/common/impl/sku/model/ClothesSizeAssistantStruct;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;JJLjava/lang/String;Lcom/bytedance/android/ec/common/impl/sku/model/SkuLimit;Lcom/bytedance/android/ec/common/impl/sku/model/SkuLimit;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/common/impl/sku/model/SkuInstallmentItemInfo;Lcom/bytedance/android/ec/model/sku/TradeModeComponent;Lcom/bytedance/android/ec/model/sku/SafeguardComponent;Lcom/bytedance/android/ec/model/sku/TopBannerComponent;Lcom/bytedance/android/ec/model/sku/SkuTrustTags;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;IJLjava/lang/String;JJJJLcom/bytedance/android/ec/model/ECUrlModel;Lcom/bytedance/android/ec/model/sku/SkuPoiInfo;Ljava/lang/String;Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Lcom/bytedance/android/ec/common/impl/sku/model/SkuBannerStruct;ZIILcom/bytedance/android/ec/model/api/LogPbData;Ljava/util/List;Lcom/bytedance/android/ec/model/sku/DisplayConfig;Lcom/bytedance/android/ec/model/sku/CarAdaptComponent;Lcom/bytedance/android/ec/model/sku/OrderComponent;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/android/ec/model/sku/ButtonTipComponent;Ljava/util/Map;Lcom/bytedance/android/ec/common/impl/sku/repository/dto/SkuAddCartGuideInfo;Lcom/bytedance/android/ec/common/impl/sku/repository/dto/UpdateActionOption;)Lcom/bytedance/android/ec/common/impl/sku/model/SkuInfoVO;", "equals", "other", "", "hashCode", "isGroupBuyDefault", "isInActivityDefault", "isInDepositPresaleDefault", "isInPreSecKillDefault", "isInSecKillDefault", "isRangePrice", "isSoldOut", "isUnderStock", "toString", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuInfoVO implements Serializable {
    private final ECUrlModel activityIcon;
    private final SkuAddCartGuideInfo addCartGuideInfo;
    private final ECUrlModel atmosphereBackground;
    private final String atmosphereHeader;
    private Integer atmosphereStyle;
    private final String bigCover;
    private final Map<String, String> bigPicMap;
    private final String buttonLabel;
    private final ButtonTipComponent buttonTipComponent;
    private long campaignEndTime;
    private long campaignStartTime;
    private final Integer campaignSubType;
    private final CarAdaptComponent carAdaptComponent;
    private final ClothesSizeAssistantStruct clothesSizeAssistant;
    private final String cover;
    private final List<SkuBottomButtons> defaultButtons;
    private final String deliveryDelayDesc;
    private final long depositPrice;
    private final Long discountPrice;
    private final String discountPriceHeader;
    private final int discountPriceStyleType;
    private final DisplayConfig displayConfig;
    private Long firstPrice;
    private Boolean firstPriceIsUnderline;
    private String firstPricePrefix;
    private String firstPriceSuffix;
    private String firstPriceSupplement;
    private final Integer givenProductStock;
    private final Boolean hasGivenProduct;
    private Long hotMaxPrice;
    private Long hotMinPrice;
    private String hotPricePrefix;
    private String hotPriceSupplement;
    private final SkuInstallmentItemInfo installmentInfo;
    private final String limitText;
    private final String logExtra;
    private final LogPbData logPb;
    private final SkuLimit lowerLimit;
    private final long marketPrice;
    private final long maxPrice;
    private final long minPrice;
    private String newBonusText;
    private final OrderComponent orderComponent;
    private final Map<String, String> pictureMap;
    private final SkuPoiInfo poiInfo;
    private final String presellDelayDesc;
    private final Long presellType;
    private final String priceHeader;
    private Integer priceHeaderStyle;
    private Long priceType;
    private final String productExtra;
    private Long regularPrice;
    private Boolean regularPriceIsUnderline;
    private String regularPricePrefix;
    private String regularPriceSuffix;
    private String regularPriceSupplement;
    private final SafeguardComponent safeguardComponent;
    private Long secondPrice;
    private final Boolean secondPriceIsReducePrice;
    private Boolean secondPriceIsUnderline;
    private String secondPricePrefix;
    private String secondPriceSuffix;
    private String secondPriceSupplement;
    private final long serverTime;
    private final int showPriceStyle;
    private final boolean showStock;
    private final Map<String, String> showTrackParams;
    private final SkuBannerStruct skuBanner;
    private final Map<String, SkuItemInfoVO> skuList;
    private Long skuType;
    private final Map<String, String> smallPicMap;
    private final List<SpecInfo> specInfoList;
    private final int status;
    private final TopBannerComponent topBannerComponent;
    private final TradeModeComponent tradeModeComponent;
    private final SkuTrustTags trustTags;
    private final Long unUseMinPrice;
    private final UpdateActionOption updateActionOption;
    private final SkuLimit upperLimit;

    public SkuInfoVO() {
        this(null, null, null, null, null, null, null, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, 0, null, 0, 0, 0, 0, null, null, null, null, null, null, null, null, false, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, -1, 32767, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SkuInfoVO copy$default(SkuInfoVO r210, Map r211, List r212, ClothesSizeAssistantStruct r213, String r214, String r215, Map r310, Map r311, Map r312, long r313, long r314, String r315, SkuLimit r316, SkuLimit r317, Long r410, Long r411, String r412, Long r413, String r414, String r415, SkuInstallmentItemInfo r416, TradeModeComponent r417, SafeguardComponent r418, TopBannerComponent r419, SkuTrustTags r510, String r511, String r512, Integer r513, String r514, Long r515, int r516, long r517, String r518, long r610, long r611, long r612, long r613, ECUrlModel r614, SkuPoiInfo r615, String r710, ECUrlModel r711, Integer r712, Boolean r713, Integer r714, SkuBannerStruct r715, boolean r716, int r717, int r718, LogPbData r719, List r810, DisplayConfig r811, CarAdaptComponent r812, OrderComponent r813, Long r814, String r815, String r816, Boolean r817, String r818, Long r819, String r910, String r911, Boolean r912, Boolean r913, String r914, Long r915, Long r916, String r917, String r918, Boolean r919, String r100, Long r101, Long r102, String r103, String r104, Integer r105, String r106, ButtonTipComponent r107, Map r108, SkuAddCartGuideInfo r109, UpdateActionOption r110, int r111, int r112, int r113, Object r114) {
        if ((r111 & 1) == 0) goto L5;
        Map r115 = r210.skuList;
    L7:
        if ((r111 & 2) == 0) goto L9;
        List r116 = r210.specInfoList;
    L11:
        if ((r111 & 4) == 0) goto L13;
        ClothesSizeAssistantStruct r117 = r210.clothesSizeAssistant;
    L15:
        if ((r111 & 8) == 0) goto L17;
        String r118 = r210.cover;
    L19:
        if ((r111 & 16) == 0) goto L21;
        String r119 = r210.bigCover;
    L23:
        if ((r111 & 32) == 0) goto L25;
        Map r120 = r210.pictureMap;
    L27:
        if ((r111 & 64) == 0) goto L29;
        Map r121 = r210.bigPicMap;
    L31:
        if ((r111 & 128) == 0) goto L33;
        Map r122 = r210.smallPicMap;
    L35:
        if ((r111 & 256) == 0) goto L37;
        long r123 = r210.minPrice;
    L39:
        if ((r111 & 512) == 0) goto L41;
        long r124 = r210.maxPrice;
    L42:
        long r318 = r124;
        if ((r111 & 1024) == 0) goto L45;
        String r125 = r210.buttonLabel;
    L47:
        if ((r111 & 2048) == 0) goto L49;
        SkuLimit r126 = r210.upperLimit;
    L50:
        SkuLimit r319 = r126;
        if ((r111 & 4096) == 0) goto L53;
        SkuLimit r127 = r210.lowerLimit;
    L54:
        SkuLimit r320 = r127;
        if ((r111 & 8192) == 0) goto L57;
        Long r128 = r210.unUseMinPrice;
    L58:
        Long r420 = r128;
        if ((r111 & 16384) == 0) goto L61;
        Long r129 = r210.discountPrice;
    L62:
        Long r421 = r129;
        if ((r111 & 32768) == 0) goto L65;
        String r130 = r210.discountPriceHeader;
    L66:
        String r422 = r130;
        if ((r111 & 65536) == 0) goto L69;
        Long r131 = r210.presellType;
    L70:
        Long r423 = r131;
        if ((r111 & 131072) == 0) goto L73;
        String r132 = r210.deliveryDelayDesc;
    L74:
        String r424 = r132;
        if ((r111 & 262144) == 0) goto L77;
        String r133 = r210.presellDelayDesc;
    L78:
        String r425 = r133;
        if ((r111 & 524288) == 0) goto L81;
        SkuInstallmentItemInfo r134 = r210.installmentInfo;
    L82:
        SkuInstallmentItemInfo r426 = r134;
        if ((r111 & 1048576) == 0) goto L85;
        TradeModeComponent r135 = r210.tradeModeComponent;
    L86:
        TradeModeComponent r427 = r135;
        if ((r111 & 2097152) == 0) goto L89;
        SafeguardComponent r136 = r210.safeguardComponent;
    L90:
        SafeguardComponent r428 = r136;
        if ((r111 & 4194304) == 0) goto L93;
        TopBannerComponent r137 = r210.topBannerComponent;
    L94:
        TopBannerComponent r429 = r137;
        if ((r111 & 8388608) == 0) goto L97;
        SkuTrustTags r138 = r210.trustTags;
    L98:
        SkuTrustTags r519 = r138;
        if ((r111 & 16777216) == 0) goto L101;
        String r139 = r210.logExtra;
    L102:
        String r520 = r139;
        if ((r111 & 33554432) == 0) goto L105;
        String r140 = r210.priceHeader;
    L106:
        String r521 = r140;
        if ((r111 & 67108864) == 0) goto L109;
        Integer r141 = r210.priceHeaderStyle;
    L110:
        Integer r522 = r141;
        if ((r111 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        String r142 = r210.newBonusText;
    L114:
        String r523 = r142;
        if ((r111 & 268435456) == 0) goto L117;
        Long r143 = r210.skuType;
    L118:
        Long r524 = r143;
        if ((r111 & 536870912) == 0) goto L121;
        int r144 = r210.status;
    L122:
        String r321 = r125;
        int r525 = r144;
        if ((r111 & 1073741824) == 0) goto L125;
        long r145 = r210.depositPrice;
    L127:
        if ((r111 & Integer.MIN_VALUE) == 0) goto L129;
        String r146 = r210.limitText;
    L130:
        long r526 = r145;
        if ((r112 & 1) == 0) goto L133;
        long r147 = r210.campaignStartTime;
    L134:
        long r616 = r147;
        if ((r112 & 2) == 0) goto L137;
        long r148 = r210.campaignEndTime;
    L138:
        long r617 = r148;
        if ((r112 & 4) == 0) goto L141;
        long r149 = r210.serverTime;
    L142:
        long r618 = r149;
        if ((r112 & 8) == 0) goto L145;
        long r150 = r210.marketPrice;
    L146:
        long r619 = r150;
        if ((r112 & 16) == 0) goto L149;
        ECUrlModel r151 = r210.activityIcon;
    L151:
        if ((r112 & 32) == 0) goto L153;
        SkuPoiInfo r152 = r210.poiInfo;
    L154:
        SkuPoiInfo r620 = r152;
        if ((r112 & 64) == 0) goto L157;
        String r153 = r210.atmosphereHeader;
    L158:
        String r720 = r153;
        if ((r112 & 128) == 0) goto L161;
        ECUrlModel r154 = r210.atmosphereBackground;
    L162:
        ECUrlModel r721 = r154;
        if ((r112 & 256) == 0) goto L165;
        Integer r155 = r210.campaignSubType;
    L166:
        Integer r722 = r155;
        if ((r112 & 512) == 0) goto L169;
        Boolean r156 = r210.hasGivenProduct;
    L170:
        Boolean r723 = r156;
        if ((r112 & 1024) == 0) goto L173;
        Integer r157 = r210.givenProductStock;
    L174:
        Integer r724 = r157;
        if ((r112 & 2048) == 0) goto L177;
        SkuBannerStruct r158 = r210.skuBanner;
    L178:
        SkuBannerStruct r725 = r158;
        if ((r112 & 4096) == 0) goto L181;
        boolean r159 = r210.showStock;
    L182:
        boolean r726 = r159;
        if ((r112 & 8192) == 0) goto L185;
        int r160 = r210.showPriceStyle;
    L186:
        int r727 = r160;
        if ((r112 & 16384) == 0) goto L189;
        int r161 = r210.discountPriceStyleType;
    L190:
        int r728 = r161;
        if ((r112 & 32768) == 0) goto L193;
        LogPbData r162 = r210.logPb;
    L194:
        LogPbData r729 = r162;
        if ((r112 & 65536) == 0) goto L197;
        List r163 = r210.defaultButtons;
    L198:
        List r820 = r163;
        if ((r112 & 131072) == 0) goto L201;
        DisplayConfig r164 = r210.displayConfig;
    L202:
        DisplayConfig r821 = r164;
        if ((r112 & 262144) == 0) goto L205;
        CarAdaptComponent r165 = r210.carAdaptComponent;
    L206:
        CarAdaptComponent r822 = r165;
        if ((r112 & 524288) == 0) goto L209;
        OrderComponent r166 = r210.orderComponent;
    L210:
        OrderComponent r823 = r166;
        if ((r112 & 1048576) == 0) goto L213;
        Long r167 = r210.firstPrice;
    L214:
        Long r824 = r167;
        if ((r112 & 2097152) == 0) goto L217;
        String r168 = r210.firstPricePrefix;
    L218:
        String r825 = r168;
        if ((r112 & 4194304) == 0) goto L221;
        String r169 = r210.firstPriceSuffix;
    L222:
        String r826 = r169;
        if ((r112 & 8388608) == 0) goto L225;
        Boolean r170 = r210.firstPriceIsUnderline;
    L226:
        Boolean r827 = r170;
        if ((r112 & 16777216) == 0) goto L229;
        String r171 = r210.firstPriceSupplement;
    L230:
        String r828 = r171;
        if ((r112 & 33554432) == 0) goto L233;
        Long r172 = r210.secondPrice;
    L234:
        Long r829 = r172;
        if ((r112 & 67108864) == 0) goto L237;
        String r173 = r210.secondPricePrefix;
    L238:
        String r920 = r173;
        if ((r112 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L241;
        String r174 = r210.secondPriceSuffix;
    L242:
        String r921 = r174;
        if ((r112 & 268435456) == 0) goto L245;
        Boolean r175 = r210.secondPriceIsUnderline;
    L246:
        Boolean r922 = r175;
        if ((r112 & 536870912) == 0) goto L249;
        Boolean r176 = r210.secondPriceIsReducePrice;
    L250:
        Boolean r923 = r176;
        if ((r112 & 1073741824) == 0) goto L253;
        String r177 = r210.secondPriceSupplement;
    L255:
        if ((r112 & Integer.MIN_VALUE) == 0) goto L257;
        Long r178 = r210.priceType;
    L258:
        Long r924 = r178;
        if ((r113 & 1) == 0) goto L261;
        Long r179 = r210.regularPrice;
    L262:
        Long r925 = r179;
        if ((r113 & 2) == 0) goto L265;
        String r180 = r210.regularPricePrefix;
    L266:
        String r926 = r180;
        if ((r113 & 4) == 0) goto L269;
        String r181 = r210.regularPriceSuffix;
    L270:
        String r927 = r181;
        if ((r113 & 8) == 0) goto L273;
        Boolean r182 = r210.regularPriceIsUnderline;
    L274:
        Boolean r928 = r182;
        if ((r113 & 16) == 0) goto L277;
        String r183 = r210.regularPriceSupplement;
    L278:
        String r1010 = r183;
        if ((r113 & 32) == 0) goto L281;
        Long r184 = r210.hotMinPrice;
    L282:
        Long r1011 = r184;
        if ((r113 & 64) == 0) goto L285;
        Long r185 = r210.hotMaxPrice;
    L286:
        Long r1012 = r185;
        if ((r113 & 128) == 0) goto L289;
        String r186 = r210.hotPricePrefix;
    L290:
        String r1013 = r186;
        if ((r113 & 256) == 0) goto L293;
        String r187 = r210.hotPriceSupplement;
    L294:
        String r1014 = r187;
        if ((r113 & 512) == 0) goto L297;
        Integer r188 = r210.atmosphereStyle;
    L298:
        Integer r1015 = r188;
        if ((r113 & 1024) == 0) goto L301;
        String r189 = r210.productExtra;
    L302:
        String r1016 = r189;
        if ((r113 & 2048) == 0) goto L305;
        ButtonTipComponent r190 = r210.buttonTipComponent;
    L306:
        ButtonTipComponent r1017 = r190;
        if ((r113 & 4096) == 0) goto L309;
        Map r191 = r210.showTrackParams;
    L310:
        Map r1018 = r191;
        if ((r113 & 8192) == 0) goto L313;
        SkuAddCartGuideInfo r192 = r210.addCartGuideInfo;
    L315:
        if ((r113 & 16384) == 0) goto L317;
        UpdateActionOption r193 = r210.updateActionOption;
    L319:
        return r210.copy(r115, r116, r117, r118, r119, r120, r121, r122, r123, r318, r321, r319, r320, r420, r421, r422, r423, r424, r425, r426, r427, r428, r429, r519, r520, r521, r522, r523, r524, r525, r526, r146, r616, r617, r618, r619, r151, r620, r720, r721, r722, r723, r724, r725, r726, r727, r728, r729, r820, r821, r822, r823, r824, r825, r826, r827, r828, r829, r920, r921, r922, r923, r177, r924, r925, r926, r927, r928, r1010, r1011, r1012, r1013, r1014, r1015, r1016, r1017, r1018, r192, r193);
    L317:
        r193 = r110;
        goto L319
    L313:
        r192 = r109;
        goto L315
    L309:
        r191 = r108;
        goto L310
    L305:
        r190 = r107;
        goto L306
    L301:
        r189 = r106;
        goto L302
    L297:
        r188 = r105;
        goto L298
    L293:
        r187 = r104;
        goto L294
    L289:
        r186 = r103;
        goto L290
    L285:
        r185 = r102;
        goto L286
    L281:
        r184 = r101;
        goto L282
    L277:
        r183 = r100;
        goto L278
    L273:
        r182 = r919;
        goto L274
    L269:
        r181 = r918;
        goto L270
    L265:
        r180 = r917;
        goto L266
    L261:
        r179 = r916;
        goto L262
    L257:
        r178 = r915;
        goto L258
    L253:
        r177 = r914;
        goto L255
    L249:
        r176 = r913;
        goto L250
    L245:
        r175 = r912;
        goto L246
    L241:
        r174 = r911;
        goto L242
    L237:
        r173 = r910;
        goto L238
    L233:
        r172 = r819;
        goto L234
    L229:
        r171 = r818;
        goto L230
    L225:
        r170 = r817;
        goto L226
    L221:
        r169 = r816;
        goto L222
    L217:
        r168 = r815;
        goto L218
    L213:
        r167 = r814;
        goto L214
    L209:
        r166 = r813;
        goto L210
    L205:
        r165 = r812;
        goto L206
    L201:
        r164 = r811;
        goto L202
    L197:
        r163 = r810;
        goto L198
    L193:
        r162 = r719;
        goto L194
    L189:
        r161 = r718;
        goto L190
    L185:
        r160 = r717;
        goto L186
    L181:
        r159 = r716;
        goto L182
    L177:
        r158 = r715;
        goto L178
    L173:
        r157 = r714;
        goto L174
    L169:
        r156 = r713;
        goto L170
    L165:
        r155 = r712;
        goto L166
    L161:
        r154 = r711;
        goto L162
    L157:
        r153 = r710;
        goto L158
    L153:
        r152 = r615;
        goto L154
    L149:
        r151 = r614;
        goto L151
    L145:
        r150 = r613;
        goto L146
    L141:
        r149 = r612;
        goto L142
    L137:
        r148 = r611;
        goto L138
    L133:
        r147 = r610;
        goto L134
    L129:
        r146 = r518;
        goto L130
    L125:
        r145 = r517;
        goto L127
    L121:
        r144 = r516;
        goto L122
    L117:
        r143 = r515;
        goto L118
    L113:
        r142 = r514;
        goto L114
    L109:
        r141 = r513;
        goto L110
    L105:
        r140 = r512;
        goto L106
    L101:
        r139 = r511;
        goto L102
    L97:
        r138 = r510;
        goto L98
    L93:
        r137 = r419;
        goto L94
    L89:
        r136 = r418;
        goto L90
    L85:
        r135 = r417;
        goto L86
    L81:
        r134 = r416;
        goto L82
    L77:
        r133 = r415;
        goto L78
    L73:
        r132 = r414;
        goto L74
    L69:
        r131 = r413;
        goto L70
    L65:
        r130 = r412;
        goto L66
    L61:
        r129 = r411;
        goto L62
    L57:
        r128 = r410;
        goto L58
    L53:
        r127 = r317;
        goto L54
    L49:
        r126 = r316;
        goto L50
    L45:
        r125 = r315;
        goto L47
    L41:
        r124 = r314;
        goto L42
    L37:
        r123 = r313;
        goto L39
    L33:
        r122 = r312;
        goto L35
    L29:
        r121 = r311;
        goto L31
    L25:
        r120 = r310;
        goto L27
    L21:
        r119 = r215;
        goto L23
    L17:
        r118 = r214;
        goto L19
    L13:
        r117 = r213;
        goto L15
    L9:
        r116 = r212;
        goto L11
    L5:
        r115 = r211;
        goto L7
    }

    public final Map<String, SkuItemInfoVO> component1() {
        return this.skuList;
    }

    public final long component10() {
        return this.maxPrice;
    }

    public final String component11() {
        return this.buttonLabel;
    }

    public final SkuLimit component12() {
        return this.upperLimit;
    }

    public final SkuLimit component13() {
        return this.lowerLimit;
    }

    public final Long component14() {
        return this.unUseMinPrice;
    }

    public final Long component15() {
        return this.discountPrice;
    }

    public final String component16() {
        return this.discountPriceHeader;
    }

    public final Long component17() {
        return this.presellType;
    }

    public final String component18() {
        return this.deliveryDelayDesc;
    }

    public final String component19() {
        return this.presellDelayDesc;
    }

    public final List<SpecInfo> component2() {
        return this.specInfoList;
    }

    public final SkuInstallmentItemInfo component20() {
        return this.installmentInfo;
    }

    public final TradeModeComponent component21() {
        return this.tradeModeComponent;
    }

    public final SafeguardComponent component22() {
        return this.safeguardComponent;
    }

    public final TopBannerComponent component23() {
        return this.topBannerComponent;
    }

    public final SkuTrustTags component24() {
        return this.trustTags;
    }

    public final String component25() {
        return this.logExtra;
    }

    public final String component26() {
        return this.priceHeader;
    }

    public final Integer component27() {
        return this.priceHeaderStyle;
    }

    public final String component28() {
        return this.newBonusText;
    }

    public final Long component29() {
        return this.skuType;
    }

    public final ClothesSizeAssistantStruct component3() {
        return this.clothesSizeAssistant;
    }

    public final int component30() {
        return this.status;
    }

    public final long component31() {
        return this.depositPrice;
    }

    public final String component32() {
        return this.limitText;
    }

    public final long component33() {
        return this.campaignStartTime;
    }

    public final long component34() {
        return this.campaignEndTime;
    }

    public final long component35() {
        return this.serverTime;
    }

    public final long component36() {
        return this.marketPrice;
    }

    public final ECUrlModel component37() {
        return this.activityIcon;
    }

    public final SkuPoiInfo component38() {
        return this.poiInfo;
    }

    public final String component39() {
        return this.atmosphereHeader;
    }

    public final String component4() {
        return this.cover;
    }

    public final ECUrlModel component40() {
        return this.atmosphereBackground;
    }

    public final Integer component41() {
        return this.campaignSubType;
    }

    public final Boolean component42() {
        return this.hasGivenProduct;
    }

    public final Integer component43() {
        return this.givenProductStock;
    }

    public final SkuBannerStruct component44() {
        return this.skuBanner;
    }

    public final boolean component45() {
        return this.showStock;
    }

    public final int component46() {
        return this.showPriceStyle;
    }

    public final int component47() {
        return this.discountPriceStyleType;
    }

    public final LogPbData component48() {
        return this.logPb;
    }

    public final List<SkuBottomButtons> component49() {
        return this.defaultButtons;
    }

    public final String component5() {
        return this.bigCover;
    }

    public final DisplayConfig component50() {
        return this.displayConfig;
    }

    public final CarAdaptComponent component51() {
        return this.carAdaptComponent;
    }

    public final OrderComponent component52() {
        return this.orderComponent;
    }

    public final Long component53() {
        return this.firstPrice;
    }

    public final String component54() {
        return this.firstPricePrefix;
    }

    public final String component55() {
        return this.firstPriceSuffix;
    }

    public final Boolean component56() {
        return this.firstPriceIsUnderline;
    }

    public final String component57() {
        return this.firstPriceSupplement;
    }

    public final Long component58() {
        return this.secondPrice;
    }

    public final String component59() {
        return this.secondPricePrefix;
    }

    public final Map<String, String> component6() {
        return this.pictureMap;
    }

    public final String component60() {
        return this.secondPriceSuffix;
    }

    public final Boolean component61() {
        return this.secondPriceIsUnderline;
    }

    public final Boolean component62() {
        return this.secondPriceIsReducePrice;
    }

    public final String component63() {
        return this.secondPriceSupplement;
    }

    public final Long component64() {
        return this.priceType;
    }

    public final Long component65() {
        return this.regularPrice;
    }

    public final String component66() {
        return this.regularPricePrefix;
    }

    public final String component67() {
        return this.regularPriceSuffix;
    }

    public final Boolean component68() {
        return this.regularPriceIsUnderline;
    }

    public final String component69() {
        return this.regularPriceSupplement;
    }

    public final Map<String, String> component7() {
        return this.bigPicMap;
    }

    public final Long component70() {
        return this.hotMinPrice;
    }

    public final Long component71() {
        return this.hotMaxPrice;
    }

    public final String component72() {
        return this.hotPricePrefix;
    }

    public final String component73() {
        return this.hotPriceSupplement;
    }

    public final Integer component74() {
        return this.atmosphereStyle;
    }

    public final String component75() {
        return this.productExtra;
    }

    public final ButtonTipComponent component76() {
        return this.buttonTipComponent;
    }

    public final Map<String, String> component77() {
        return this.showTrackParams;
    }

    public final SkuAddCartGuideInfo component78() {
        return this.addCartGuideInfo;
    }

    public final UpdateActionOption component79() {
        return this.updateActionOption;
    }

    public final Map<String, String> component8() {
        return this.smallPicMap;
    }

    public final long component9() {
        return this.minPrice;
    }

    public final SkuInfoVO copy(Map<String, SkuItemInfoVO> r910, List<SpecInfo> r911, ClothesSizeAssistantStruct r912, String r913, String r914, Map<String, String> r915, Map<String, String> r916, Map<String, String> r917, long r918, long r100, String r102, SkuLimit r103, SkuLimit r104, Long r105, Long r106, String r107, Long r108, String r109, String r110, SkuInstallmentItemInfo r111, TradeModeComponent r112, SafeguardComponent r113, TopBannerComponent r114, SkuTrustTags r115, String r116, String r117, Integer r118, String r119, Long r120, int r121, long r122, String r124, long r125, long r127, long r129, long r131, ECUrlModel r133, SkuPoiInfo r134, String r135, ECUrlModel r136, Integer r137, Boolean r138, Integer r139, SkuBannerStruct r140, boolean r141, int r142, int r143, LogPbData r144, List<SkuBottomButtons> r145, DisplayConfig r146, CarAdaptComponent r147, OrderComponent r148, Long r149, String r150, String r151, Boolean r152, String r153, Long r154, String r155, String r156, Boolean r157, Boolean r158, String r159, Long r160, Long r161, String r162, String r163, Boolean r164, String r165, Long r166, Long r167, String r168, String r169, Integer r170, String r171, ButtonTipComponent r172, Map<String, String> r173, SkuAddCartGuideInfo r174, UpdateActionOption r175) {
        Intrinsics.checkNotNullParameter(r910, "skuList");
        Intrinsics.checkNotNullParameter(r911, "specInfoList");
        Intrinsics.checkNotNullParameter(r103, "upperLimit");
        Intrinsics.checkNotNullParameter(r104, "lowerLimit");
        return new SkuInfoVO(r910, r911, r912, r913, r914, r915, r916, r917, r918, r100, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r124, r125, r127, r129, r131, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r150, r151, r152, r153, r154, r155, r156, r157, r158, r159, r160, r161, r162, r163, r164, r165, r166, r167, r168, r169, r170, r171, r172, r173, r174, r175);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SkuInfoVO) == false) goto L164;
        SkuInfoVO r101 = (SkuInfoVO) r100;
        if (Intrinsics.areEqual(this.skuList, r101.skuList) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.specInfoList, r101.specInfoList) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.clothesSizeAssistant, r101.clothesSizeAssistant) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.cover, r101.cover) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.bigCover, r101.bigCover) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.pictureMap, r101.pictureMap) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.bigPicMap, r101.bigPicMap) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.smallPicMap, r101.smallPicMap) == true) goto L22;
        return false;
    L22:
        if (this.minPrice == r101.minPrice) goto L24;
        return false;
    L24:
        if (this.maxPrice == r101.maxPrice) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.buttonLabel, r101.buttonLabel) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.upperLimit, r101.upperLimit) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.lowerLimit, r101.lowerLimit) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.unUseMinPrice, r101.unUseMinPrice) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.discountPrice, r101.discountPrice) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.discountPriceHeader, r101.discountPriceHeader) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.presellType, r101.presellType) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.deliveryDelayDesc, r101.deliveryDelayDesc) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.presellDelayDesc, r101.presellDelayDesc) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.installmentInfo, r101.installmentInfo) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.tradeModeComponent, r101.tradeModeComponent) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.safeguardComponent, r101.safeguardComponent) == true) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.topBannerComponent, r101.topBannerComponent) == true) goto L52;
        return false;
    L52:
        if (Intrinsics.areEqual(this.trustTags, r101.trustTags) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.logExtra, r101.logExtra) == true) goto L56;
        return false;
    L56:
        if (Intrinsics.areEqual(this.priceHeader, r101.priceHeader) == true) goto L58;
        return false;
    L58:
        if (Intrinsics.areEqual(this.priceHeaderStyle, r101.priceHeaderStyle) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.newBonusText, r101.newBonusText) == true) goto L62;
        return false;
    L62:
        if (Intrinsics.areEqual(this.skuType, r101.skuType) == true) goto L64;
        return false;
    L64:
        if (this.status == r101.status) goto L66;
        return false;
    L66:
        if (this.depositPrice == r101.depositPrice) goto L68;
        return false;
    L68:
        if (Intrinsics.areEqual(this.limitText, r101.limitText) == true) goto L70;
        return false;
    L70:
        if (this.campaignStartTime == r101.campaignStartTime) goto L72;
        return false;
    L72:
        if (this.campaignEndTime == r101.campaignEndTime) goto L74;
        return false;
    L74:
        if (this.serverTime == r101.serverTime) goto L76;
        return false;
    L76:
        if (this.marketPrice == r101.marketPrice) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.activityIcon, r101.activityIcon) == true) goto L80;
        return false;
    L80:
        if (Intrinsics.areEqual(this.poiInfo, r101.poiInfo) == true) goto L82;
        return false;
    L82:
        if (Intrinsics.areEqual(this.atmosphereHeader, r101.atmosphereHeader) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.atmosphereBackground, r101.atmosphereBackground) == true) goto L86;
        return false;
    L86:
        if (Intrinsics.areEqual(this.campaignSubType, r101.campaignSubType) == true) goto L88;
        return false;
    L88:
        if (Intrinsics.areEqual(this.hasGivenProduct, r101.hasGivenProduct) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.givenProductStock, r101.givenProductStock) == true) goto L92;
        return false;
    L92:
        if (Intrinsics.areEqual(this.skuBanner, r101.skuBanner) == true) goto L94;
        return false;
    L94:
        if (this.showStock == r101.showStock) goto L96;
        return false;
    L96:
        if (this.showPriceStyle == r101.showPriceStyle) goto L98;
        return false;
    L98:
        if (this.discountPriceStyleType == r101.discountPriceStyleType) goto L100;
        return false;
    L100:
        if (Intrinsics.areEqual(this.logPb, r101.logPb) == true) goto L102;
        return false;
    L102:
        if (Intrinsics.areEqual(this.defaultButtons, r101.defaultButtons) == true) goto L104;
        return false;
    L104:
        if (Intrinsics.areEqual(this.displayConfig, r101.displayConfig) == true) goto L106;
        return false;
    L106:
        if (Intrinsics.areEqual(this.carAdaptComponent, r101.carAdaptComponent) == true) goto L108;
        return false;
    L108:
        if (Intrinsics.areEqual(this.orderComponent, r101.orderComponent) == true) goto L110;
        return false;
    L110:
        if (Intrinsics.areEqual(this.firstPrice, r101.firstPrice) == true) goto L112;
        return false;
    L112:
        if (Intrinsics.areEqual(this.firstPricePrefix, r101.firstPricePrefix) == true) goto L114;
        return false;
    L114:
        if (Intrinsics.areEqual(this.firstPriceSuffix, r101.firstPriceSuffix) == true) goto L116;
        return false;
    L116:
        if (Intrinsics.areEqual(this.firstPriceIsUnderline, r101.firstPriceIsUnderline) == true) goto L118;
        return false;
    L118:
        if (Intrinsics.areEqual(this.firstPriceSupplement, r101.firstPriceSupplement) == true) goto L120;
        return false;
    L120:
        if (Intrinsics.areEqual(this.secondPrice, r101.secondPrice) == true) goto L122;
        return false;
    L122:
        if (Intrinsics.areEqual(this.secondPricePrefix, r101.secondPricePrefix) == true) goto L124;
        return false;
    L124:
        if (Intrinsics.areEqual(this.secondPriceSuffix, r101.secondPriceSuffix) == true) goto L126;
        return false;
    L126:
        if (Intrinsics.areEqual(this.secondPriceIsUnderline, r101.secondPriceIsUnderline) == true) goto L128;
        return false;
    L128:
        if (Intrinsics.areEqual(this.secondPriceIsReducePrice, r101.secondPriceIsReducePrice) == true) goto L130;
        return false;
    L130:
        if (Intrinsics.areEqual(this.secondPriceSupplement, r101.secondPriceSupplement) == true) goto L132;
        return false;
    L132:
        if (Intrinsics.areEqual(this.priceType, r101.priceType) == true) goto L134;
        return false;
    L134:
        if (Intrinsics.areEqual(this.regularPrice, r101.regularPrice) == true) goto L136;
        return false;
    L136:
        if (Intrinsics.areEqual(this.regularPricePrefix, r101.regularPricePrefix) == true) goto L138;
        return false;
    L138:
        if (Intrinsics.areEqual(this.regularPriceSuffix, r101.regularPriceSuffix) == true) goto L140;
        return false;
    L140:
        if (Intrinsics.areEqual(this.regularPriceIsUnderline, r101.regularPriceIsUnderline) == true) goto L142;
        return false;
    L142:
        if (Intrinsics.areEqual(this.regularPriceSupplement, r101.regularPriceSupplement) == true) goto L144;
        return false;
    L144:
        if (Intrinsics.areEqual(this.hotMinPrice, r101.hotMinPrice) == true) goto L146;
        return false;
    L146:
        if (Intrinsics.areEqual(this.hotMaxPrice, r101.hotMaxPrice) == true) goto L148;
        return false;
    L148:
        if (Intrinsics.areEqual(this.hotPricePrefix, r101.hotPricePrefix) == true) goto L150;
        return false;
    L150:
        if (Intrinsics.areEqual(this.hotPriceSupplement, r101.hotPriceSupplement) == true) goto L152;
        return false;
    L152:
        if (Intrinsics.areEqual(this.atmosphereStyle, r101.atmosphereStyle) == true) goto L154;
        return false;
    L154:
        if (Intrinsics.areEqual(this.productExtra, r101.productExtra) == true) goto L156;
        return false;
    L156:
        if (Intrinsics.areEqual(this.buttonTipComponent, r101.buttonTipComponent) == true) goto L158;
        return false;
    L158:
        if (Intrinsics.areEqual(this.showTrackParams, r101.showTrackParams) == true) goto L160;
        return false;
    L160:
        if (Intrinsics.areEqual(this.addCartGuideInfo, r101.addCartGuideInfo) == true) goto L162;
        return false;
    L162:
        if (Intrinsics.areEqual(this.updateActionOption, r101.updateActionOption) == true) goto L247;
        return false;
    L247:
        return true;
    L164:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v121, types: [int] */
    /* JADX WARN: Type inference failed for: r2v249 */
    /* JADX WARN: Type inference failed for: r2v285 */
    public int hashCode() {
        Map<String, SkuItemInfoVO> r100 = this.skuList;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<SpecInfo> r104 = this.specInfoList;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ClothesSizeAssistantStruct r107 = this.clothesSizeAssistant;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.cover;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.bigCover;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Map<String, String> r116 = this.pictureMap;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Map<String, String> r119 = this.bigPicMap;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Map<String, String> r122 = this.smallPicMap;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        long r125 = this.minPrice;
        int r126 = (r124 + ((int) (r125 ^ (r125 >>> 32)))) * 31;
        long r127 = this.maxPrice;
        int r128 = (r126 + ((int) (r127 ^ (r127 >>> 32)))) * 31;
        String r129 = this.buttonLabel;
        if (r129 == null) goto L37;
        int r130 = r129.hashCode();
    L38:
        int r131 = (r128 + r130) * 31;
        SkuLimit r132 = this.upperLimit;
        if (r132 == null) goto L41;
        int r133 = r132.hashCode();
    L42:
        int r134 = (r131 + r133) * 31;
        SkuLimit r135 = this.lowerLimit;
        if (r135 == null) goto L45;
        int r136 = r135.hashCode();
    L46:
        int r137 = (r134 + r136) * 31;
        Long r138 = this.unUseMinPrice;
        if (r138 == null) goto L49;
        int r139 = r138.hashCode();
    L50:
        int r140 = (r137 + r139) * 31;
        Long r141 = this.discountPrice;
        if (r141 == null) goto L53;
        int r142 = r141.hashCode();
    L54:
        int r143 = (r140 + r142) * 31;
        String r144 = this.discountPriceHeader;
        if (r144 == null) goto L57;
        int r145 = r144.hashCode();
    L58:
        int r146 = (r143 + r145) * 31;
        Long r147 = this.presellType;
        if (r147 == null) goto L61;
        int r148 = r147.hashCode();
    L62:
        int r149 = (r146 + r148) * 31;
        String r150 = this.deliveryDelayDesc;
        if (r150 == null) goto L65;
        int r151 = r150.hashCode();
    L66:
        int r152 = (r149 + r151) * 31;
        String r153 = this.presellDelayDesc;
        if (r153 == null) goto L69;
        int r154 = r153.hashCode();
    L70:
        int r155 = (r152 + r154) * 31;
        SkuInstallmentItemInfo r156 = this.installmentInfo;
        if (r156 == null) goto L73;
        int r157 = r156.hashCode();
    L74:
        int r158 = (r155 + r157) * 31;
        TradeModeComponent r159 = this.tradeModeComponent;
        if (r159 == null) goto L77;
        int r160 = r159.hashCode();
    L78:
        int r161 = (r158 + r160) * 31;
        SafeguardComponent r162 = this.safeguardComponent;
        if (r162 == null) goto L81;
        int r163 = r162.hashCode();
    L82:
        int r164 = (r161 + r163) * 31;
        TopBannerComponent r165 = this.topBannerComponent;
        if (r165 == null) goto L85;
        int r166 = r165.hashCode();
    L86:
        int r167 = (r164 + r166) * 31;
        SkuTrustTags r168 = this.trustTags;
        if (r168 == null) goto L89;
        int r169 = r168.hashCode();
    L90:
        int r170 = (r167 + r169) * 31;
        String r171 = this.logExtra;
        if (r171 == null) goto L93;
        int r172 = r171.hashCode();
    L94:
        int r173 = (r170 + r172) * 31;
        String r174 = this.priceHeader;
        if (r174 == null) goto L97;
        int r175 = r174.hashCode();
    L98:
        int r176 = (r173 + r175) * 31;
        Integer r177 = this.priceHeaderStyle;
        if (r177 == null) goto L101;
        int r178 = r177.hashCode();
    L102:
        int r179 = (r176 + r178) * 31;
        String r180 = this.newBonusText;
        if (r180 == null) goto L105;
        int r181 = r180.hashCode();
    L106:
        int r182 = (r179 + r181) * 31;
        Long r183 = this.skuType;
        if (r183 == null) goto L109;
        int r184 = r183.hashCode();
    L110:
        int r185 = (((r182 + r184) * 31) + this.status) * 31;
        long r186 = this.depositPrice;
        int r187 = (r185 + ((int) (r186 ^ (r186 >>> 32)))) * 31;
        String r188 = this.limitText;
        if (r188 == null) goto L113;
        int r189 = r188.hashCode();
    L114:
        int r190 = (r187 + r189) * 31;
        long r191 = this.campaignStartTime;
        int r192 = (r190 + ((int) (r191 ^ (r191 >>> 32)))) * 31;
        long r193 = this.campaignEndTime;
        int r194 = (r192 + ((int) (r193 ^ (r193 >>> 32)))) * 31;
        long r195 = this.serverTime;
        int r196 = (r194 + ((int) (r195 ^ (r195 >>> 32)))) * 31;
        long r197 = this.marketPrice;
        int r198 = (r196 + ((int) (r197 ^ (r197 >>> 32)))) * 31;
        ECUrlModel r199 = this.activityIcon;
        if (r199 == null) goto L117;
        int r200 = r199.hashCode();
    L118:
        int r201 = (r198 + r200) * 31;
        SkuPoiInfo r202 = this.poiInfo;
        if (r202 == null) goto L121;
        int r203 = r202.hashCode();
    L122:
        int r204 = (r201 + r203) * 31;
        String r205 = this.atmosphereHeader;
        if (r205 == null) goto L125;
        int r206 = r205.hashCode();
    L126:
        int r207 = (r204 + r206) * 31;
        ECUrlModel r208 = this.atmosphereBackground;
        if (r208 == null) goto L129;
        int r209 = r208.hashCode();
    L130:
        int r210 = (r207 + r209) * 31;
        Integer r211 = this.campaignSubType;
        if (r211 == null) goto L133;
        int r212 = r211.hashCode();
    L134:
        int r213 = (r210 + r212) * 31;
        Boolean r214 = this.hasGivenProduct;
        if (r214 == null) goto L137;
        int r215 = r214.hashCode();
    L138:
        int r216 = (r213 + r215) * 31;
        Integer r217 = this.givenProductStock;
        if (r217 == null) goto L141;
        int r218 = r217.hashCode();
    L142:
        int r219 = (r216 + r218) * 31;
        SkuBannerStruct r220 = this.skuBanner;
        if (r220 == null) goto L145;
        int r221 = r220.hashCode();
    L146:
        int r222 = (r219 + r221) * 31;
        boolean r223 = this.showStock;
        ?? r224 = r223;
        if (r223 == false) goto L149;
        r224 = 1;
    L149:
        int r225 = (((((r222 + r224) * 31) + this.showPriceStyle) * 31) + this.discountPriceStyleType) * 31;
        LogPbData r226 = this.logPb;
        if (r226 == null) goto L152;
        int r227 = r226.hashCode();
    L153:
        int r228 = (r225 + r227) * 31;
        List<SkuBottomButtons> r229 = this.defaultButtons;
        if (r229 == null) goto L156;
        int r230 = r229.hashCode();
    L157:
        int r231 = (r228 + r230) * 31;
        DisplayConfig r232 = this.displayConfig;
        if (r232 == null) goto L160;
        int r233 = r232.hashCode();
    L161:
        int r234 = (r231 + r233) * 31;
        CarAdaptComponent r235 = this.carAdaptComponent;
        if (r235 == null) goto L164;
        int r236 = r235.hashCode();
    L165:
        int r237 = (r234 + r236) * 31;
        OrderComponent r238 = this.orderComponent;
        if (r238 == null) goto L168;
        int r239 = r238.hashCode();
    L169:
        int r240 = (r237 + r239) * 31;
        Long r241 = this.firstPrice;
        if (r241 == null) goto L172;
        int r242 = r241.hashCode();
    L173:
        int r243 = (r240 + r242) * 31;
        String r244 = this.firstPricePrefix;
        if (r244 == null) goto L176;
        int r245 = r244.hashCode();
    L177:
        int r246 = (r243 + r245) * 31;
        String r247 = this.firstPriceSuffix;
        if (r247 == null) goto L180;
        int r248 = r247.hashCode();
    L181:
        int r249 = (r246 + r248) * 31;
        Boolean r250 = this.firstPriceIsUnderline;
        if (r250 == null) goto L184;
        int r251 = r250.hashCode();
    L185:
        int r252 = (r249 + r251) * 31;
        String r253 = this.firstPriceSupplement;
        if (r253 == null) goto L188;
        int r254 = r253.hashCode();
    L189:
        int r255 = (r252 + r254) * 31;
        Long r256 = this.secondPrice;
        if (r256 == null) goto L192;
        int r257 = r256.hashCode();
    L193:
        int r258 = (r255 + r257) * 31;
        String r259 = this.secondPricePrefix;
        if (r259 == null) goto L196;
        int r260 = r259.hashCode();
    L197:
        int r261 = (r258 + r260) * 31;
        String r262 = this.secondPriceSuffix;
        if (r262 == null) goto L200;
        int r263 = r262.hashCode();
    L201:
        int r264 = (r261 + r263) * 31;
        Boolean r265 = this.secondPriceIsUnderline;
        if (r265 == null) goto L204;
        int r266 = r265.hashCode();
    L205:
        int r267 = (r264 + r266) * 31;
        Boolean r268 = this.secondPriceIsReducePrice;
        if (r268 == null) goto L208;
        int r269 = r268.hashCode();
    L209:
        int r270 = (r267 + r269) * 31;
        String r271 = this.secondPriceSupplement;
        if (r271 == null) goto L212;
        int r272 = r271.hashCode();
    L213:
        int r273 = (r270 + r272) * 31;
        Long r274 = this.priceType;
        if (r274 == null) goto L216;
        int r275 = r274.hashCode();
    L217:
        int r276 = (r273 + r275) * 31;
        Long r277 = this.regularPrice;
        if (r277 == null) goto L220;
        int r278 = r277.hashCode();
    L221:
        int r279 = (r276 + r278) * 31;
        String r280 = this.regularPricePrefix;
        if (r280 == null) goto L224;
        int r281 = r280.hashCode();
    L225:
        int r282 = (r279 + r281) * 31;
        String r283 = this.regularPriceSuffix;
        if (r283 == null) goto L228;
        int r284 = r283.hashCode();
    L229:
        int r285 = (r282 + r284) * 31;
        Boolean r286 = this.regularPriceIsUnderline;
        if (r286 == null) goto L232;
        int r287 = r286.hashCode();
    L233:
        int r288 = (r285 + r287) * 31;
        String r289 = this.regularPriceSupplement;
        if (r289 == null) goto L236;
        int r290 = r289.hashCode();
    L237:
        int r291 = (r288 + r290) * 31;
        Long r292 = this.hotMinPrice;
        if (r292 == null) goto L240;
        int r293 = r292.hashCode();
    L241:
        int r294 = (r291 + r293) * 31;
        Long r295 = this.hotMaxPrice;
        if (r295 == null) goto L244;
        int r296 = r295.hashCode();
    L245:
        int r297 = (r294 + r296) * 31;
        String r298 = this.hotPricePrefix;
        if (r298 == null) goto L248;
        int r299 = r298.hashCode();
    L249:
        int r300 = (r297 + r299) * 31;
        String r301 = this.hotPriceSupplement;
        if (r301 == null) goto L252;
        int r302 = r301.hashCode();
    L253:
        int r303 = (r300 + r302) * 31;
        Integer r304 = this.atmosphereStyle;
        if (r304 == null) goto L256;
        int r305 = r304.hashCode();
    L257:
        int r306 = (r303 + r305) * 31;
        String r307 = this.productExtra;
        if (r307 == null) goto L260;
        int r308 = r307.hashCode();
    L261:
        int r309 = (r306 + r308) * 31;
        ButtonTipComponent r310 = this.buttonTipComponent;
        if (r310 == null) goto L264;
        int r311 = r310.hashCode();
    L265:
        int r312 = (r309 + r311) * 31;
        Map<String, String> r313 = this.showTrackParams;
        if (r313 == null) goto L268;
        int r314 = r313.hashCode();
    L269:
        int r315 = (r312 + r314) * 31;
        SkuAddCartGuideInfo r316 = this.addCartGuideInfo;
        if (r316 == null) goto L272;
        int r317 = r316.hashCode();
    L273:
        int r318 = (r315 + r317) * 31;
        UpdateActionOption r319 = this.updateActionOption;
        if (r319 == null) goto L277;
        r101 = r319.hashCode();
    L277:
        return r318 + r101;
    L272:
        r317 = 0;
        goto L273
    L268:
        r314 = 0;
        goto L269
    L264:
        r311 = 0;
        goto L265
    L260:
        r308 = 0;
        goto L261
    L256:
        r305 = 0;
        goto L257
    L252:
        r302 = 0;
        goto L253
    L248:
        r299 = 0;
        goto L249
    L244:
        r296 = 0;
        goto L245
    L240:
        r293 = 0;
        goto L241
    L236:
        r290 = 0;
        goto L237
    L232:
        r287 = 0;
        goto L233
    L228:
        r284 = 0;
        goto L229
    L224:
        r281 = 0;
        goto L225
    L220:
        r278 = 0;
        goto L221
    L216:
        r275 = 0;
        goto L217
    L212:
        r272 = 0;
        goto L213
    L208:
        r269 = 0;
        goto L209
    L204:
        r266 = 0;
        goto L205
    L200:
        r263 = 0;
        goto L201
    L196:
        r260 = 0;
        goto L197
    L192:
        r257 = 0;
        goto L193
    L188:
        r254 = 0;
        goto L189
    L184:
        r251 = 0;
        goto L185
    L180:
        r248 = 0;
        goto L181
    L176:
        r245 = 0;
        goto L177
    L172:
        r242 = 0;
        goto L173
    L168:
        r239 = 0;
        goto L169
    L164:
        r236 = 0;
        goto L165
    L160:
        r233 = 0;
        goto L161
    L156:
        r230 = 0;
        goto L157
    L152:
        r227 = 0;
        goto L153
    L145:
        r221 = 0;
        goto L146
    L141:
        r218 = 0;
        goto L142
    L137:
        r215 = 0;
        goto L138
    L133:
        r212 = 0;
        goto L134
    L129:
        r209 = 0;
        goto L130
    L125:
        r206 = 0;
        goto L126
    L121:
        r203 = 0;
        goto L122
    L117:
        r200 = 0;
        goto L118
    L113:
        r189 = 0;
        goto L114
    L109:
        r184 = 0;
        goto L110
    L105:
        r181 = 0;
        goto L106
    L101:
        r178 = 0;
        goto L102
    L97:
        r175 = 0;
        goto L98
    L93:
        r172 = 0;
        goto L94
    L89:
        r169 = 0;
        goto L90
    L85:
        r166 = 0;
        goto L86
    L81:
        r163 = 0;
        goto L82
    L77:
        r160 = 0;
        goto L78
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
    L37:
        r130 = 0;
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
        return "SkuInfoVO(skuList=" + this.skuList + ", specInfoList=" + this.specInfoList + ", clothesSizeAssistant=" + this.clothesSizeAssistant + ", cover=" + this.cover + ", bigCover=" + this.bigCover + ", pictureMap=" + this.pictureMap + ", bigPicMap=" + this.bigPicMap + ", smallPicMap=" + this.smallPicMap + ", minPrice=" + this.minPrice + ", maxPrice=" + this.maxPrice + ", buttonLabel=" + this.buttonLabel + ", upperLimit=" + this.upperLimit + ", lowerLimit=" + this.lowerLimit + ", unUseMinPrice=" + this.unUseMinPrice + ", discountPrice=" + this.discountPrice + ", discountPriceHeader=" + this.discountPriceHeader + ", presellType=" + this.presellType + ", deliveryDelayDesc=" + this.deliveryDelayDesc + ", presellDelayDesc=" + this.presellDelayDesc + ", installmentInfo=" + this.installmentInfo + ", tradeModeComponent=" + this.tradeModeComponent + ", safeguardComponent=" + this.safeguardComponent + ", topBannerComponent=" + this.topBannerComponent + ", trustTags=" + this.trustTags + ", logExtra=" + this.logExtra + ", priceHeader=" + this.priceHeader + ", priceHeaderStyle=" + this.priceHeaderStyle + ", newBonusText=" + this.newBonusText + ", skuType=" + this.skuType + ", status=" + this.status + ", depositPrice=" + this.depositPrice + ", limitText=" + this.limitText + ", campaignStartTime=" + this.campaignStartTime + ", campaignEndTime=" + this.campaignEndTime + ", serverTime=" + this.serverTime + ", marketPrice=" + this.marketPrice + ", activityIcon=" + this.activityIcon + ", poiInfo=" + this.poiInfo + ", atmosphereHeader=" + this.atmosphereHeader + ", atmosphereBackground=" + this.atmosphereBackground + ", campaignSubType=" + this.campaignSubType + ", hasGivenProduct=" + this.hasGivenProduct + ", givenProductStock=" + this.givenProductStock + ", skuBanner=" + this.skuBanner + ", showStock=" + this.showStock + ", showPriceStyle=" + this.showPriceStyle + ", discountPriceStyleType=" + this.discountPriceStyleType + ", logPb=" + this.logPb + ", defaultButtons=" + this.defaultButtons + ", displayConfig=" + this.displayConfig + ", carAdaptComponent=" + this.carAdaptComponent + ", orderComponent=" + this.orderComponent + ", firstPrice=" + this.firstPrice + ", firstPricePrefix=" + this.firstPricePrefix + ", firstPriceSuffix=" + this.firstPriceSuffix + ", firstPriceIsUnderline=" + this.firstPriceIsUnderline + ", firstPriceSupplement=" + this.firstPriceSupplement + ", secondPrice=" + this.secondPrice + ", secondPricePrefix=" + this.secondPricePrefix + ", secondPriceSuffix=" + this.secondPriceSuffix + ", secondPriceIsUnderline=" + this.secondPriceIsUnderline + ", secondPriceIsReducePrice=" + this.secondPriceIsReducePrice + ", secondPriceSupplement=" + this.secondPriceSupplement + ", priceType=" + this.priceType + ", regularPrice=" + this.regularPrice + ", regularPricePrefix=" + this.regularPricePrefix + ", regularPriceSuffix=" + this.regularPriceSuffix + ", regularPriceIsUnderline=" + this.regularPriceIsUnderline + ", regularPriceSupplement=" + this.regularPriceSupplement + ", hotMinPrice=" + this.hotMinPrice + ", hotMaxPrice=" + this.hotMaxPrice + ", hotPricePrefix=" + this.hotPricePrefix + ", hotPriceSupplement=" + this.hotPriceSupplement + ", atmosphereStyle=" + this.atmosphereStyle + ", productExtra=" + this.productExtra + ", buttonTipComponent=" + this.buttonTipComponent + ", showTrackParams=" + this.showTrackParams + ", addCartGuideInfo=" + this.addCartGuideInfo + ", updateActionOption=" + this.updateActionOption + ")";
    }

    public final boolean isGroupBuyDefault() {
        Long r100 = this.skuType;
        if (r100 != null) goto L6;
    L8:
        return false;
    L6:
        if (r100.longValue() != 120) goto L8;
        return true;
    }

    public final boolean isInDepositPresaleDefault() {
        Long r100 = this.skuType;
        if (r100 != null) goto L6;
    L13:
        return false;
    L6:
        if (r100.longValue() != 10) goto L13;
        long r101 = this.campaignStartTime;
        long r102 = this.campaignEndTime;
        long r103 = SystemClock.elapsedRealtime();
        if (r101 > r103) goto L13;
        if (r102 < r103) goto L13;
        return true;
    }

    public final boolean isInPreSecKillDefault() {
        Long r100 = this.skuType;
        if (r100 != null) goto L6;
    L10:
        return false;
    L6:
        if (r100.longValue() != 7) goto L10;
        if (SystemClock.elapsedRealtime() >= this.campaignStartTime) goto L10;
        return true;
    }

    public final boolean isInSecKillDefault() {
        Long r100 = this.skuType;
        if (r100 != null) goto L6;
    L13:
        return false;
    L6:
        if (r100.longValue() != 7) goto L13;
        long r101 = this.campaignStartTime;
        long r102 = this.campaignEndTime;
        long r103 = SystemClock.elapsedRealtime();
        if (r101 > r103) goto L13;
        if (r102 < r103) goto L13;
        return true;
    }

    public final boolean isRangePrice() {
        if (this.maxPrice <= this.minPrice) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isSoldOut() {
        Iterator<T> r100 = this.skuList.values().iterator();
        long r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L7;
        r101 = r101 + ((SkuItemInfoVO) r100.next()).getStockNum();
        goto L4
    L7:
        if (r101 > 0) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean isUnderStock() {
        Collection<SkuItemInfoVO> r100 = this.skuList.values();
        boolean r101 = false;
        if ((r100 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r102 = r100.iterator();
    L9:
        if (r102.hasNext() == false) goto L17;
        SkuItemInfoVO r103 = (SkuItemInfoVO) r102.next();
        if (r103.getStockNum() < r103.getLowerLimit()) goto L13;
        boolean r104 = true;
    L14:
        if (r104 == false) goto L9;
        r101 = true;
        goto L17
    L13:
        r104 = false;
    L17:
        return !r101;
    L5:
        if (r100.isEmpty() == false) goto L7;
        goto L7
    }

    public final boolean isInActivityDefault() {
        if (isInSecKillDefault() == false) goto L5;
    L10:
        return true;
    L5:
        if (isInPreSecKillDefault() == true) goto L10;
        if (isGroupBuyDefault() == true) goto L10;
        return false;
    }

    public final ECUrlModel getActivityIcon() {
        return this.activityIcon;
    }

    public final SkuAddCartGuideInfo getAddCartGuideInfo() {
        return this.addCartGuideInfo;
    }

    public final ECUrlModel getAtmosphereBackground() {
        return this.atmosphereBackground;
    }

    public final String getAtmosphereHeader() {
        return this.atmosphereHeader;
    }

    public final Integer getAtmosphereStyle() {
        return this.atmosphereStyle;
    }

    public final String getBigCover() {
        return this.bigCover;
    }

    public final Map<String, String> getBigPicMap() {
        return this.bigPicMap;
    }

    public final String getButtonLabel() {
        return this.buttonLabel;
    }

    public final ButtonTipComponent getButtonTipComponent() {
        return this.buttonTipComponent;
    }

    public final long getCampaignEndTime() {
        return this.campaignEndTime;
    }

    public final long getCampaignStartTime() {
        return this.campaignStartTime;
    }

    public final Integer getCampaignSubType() {
        return this.campaignSubType;
    }

    public final CarAdaptComponent getCarAdaptComponent() {
        return this.carAdaptComponent;
    }

    public final ClothesSizeAssistantStruct getClothesSizeAssistant() {
        return this.clothesSizeAssistant;
    }

    public final String getCover() {
        return this.cover;
    }

    public final List<SkuBottomButtons> getDefaultButtons() {
        return this.defaultButtons;
    }

    public final String getDeliveryDelayDesc() {
        return this.deliveryDelayDesc;
    }

    public final long getDepositPrice() {
        return this.depositPrice;
    }

    public final Long getDiscountPrice() {
        return this.discountPrice;
    }

    public final String getDiscountPriceHeader() {
        return this.discountPriceHeader;
    }

    public final int getDiscountPriceStyleType() {
        return this.discountPriceStyleType;
    }

    public final DisplayConfig getDisplayConfig() {
        return this.displayConfig;
    }

    public final Long getFirstPrice() {
        return this.firstPrice;
    }

    public final Boolean getFirstPriceIsUnderline() {
        return this.firstPriceIsUnderline;
    }

    public final String getFirstPricePrefix() {
        return this.firstPricePrefix;
    }

    public final String getFirstPriceSuffix() {
        return this.firstPriceSuffix;
    }

    public final String getFirstPriceSupplement() {
        return this.firstPriceSupplement;
    }

    public final Integer getGivenProductStock() {
        return this.givenProductStock;
    }

    public final Boolean getHasGivenProduct() {
        return this.hasGivenProduct;
    }

    public final Long getHotMaxPrice() {
        return this.hotMaxPrice;
    }

    public final Long getHotMinPrice() {
        return this.hotMinPrice;
    }

    public final String getHotPricePrefix() {
        return this.hotPricePrefix;
    }

    public final String getHotPriceSupplement() {
        return this.hotPriceSupplement;
    }

    public final SkuInstallmentItemInfo getInstallmentInfo() {
        return this.installmentInfo;
    }

    public final String getLimitText() {
        return this.limitText;
    }

    public final String getLogExtra() {
        return this.logExtra;
    }

    public final LogPbData getLogPb() {
        return this.logPb;
    }

    public final SkuLimit getLowerLimit() {
        return this.lowerLimit;
    }

    public final long getMarketPrice() {
        return this.marketPrice;
    }

    public final long getMaxPrice() {
        return this.maxPrice;
    }

    public final long getMinPrice() {
        return this.minPrice;
    }

    public final String getNewBonusText() {
        return this.newBonusText;
    }

    public final OrderComponent getOrderComponent() {
        return this.orderComponent;
    }

    public final Map<String, String> getPictureMap() {
        return this.pictureMap;
    }

    public final SkuPoiInfo getPoiInfo() {
        return this.poiInfo;
    }

    public final String getPresellDelayDesc() {
        return this.presellDelayDesc;
    }

    public final Long getPresellType() {
        return this.presellType;
    }

    public final String getPriceHeader() {
        return this.priceHeader;
    }

    public final Integer getPriceHeaderStyle() {
        return this.priceHeaderStyle;
    }

    public final Long getPriceType() {
        return this.priceType;
    }

    public final String getProductExtra() {
        return this.productExtra;
    }

    public final Long getRegularPrice() {
        return this.regularPrice;
    }

    public final Boolean getRegularPriceIsUnderline() {
        return this.regularPriceIsUnderline;
    }

    public final String getRegularPricePrefix() {
        return this.regularPricePrefix;
    }

    public final String getRegularPriceSuffix() {
        return this.regularPriceSuffix;
    }

    public final String getRegularPriceSupplement() {
        return this.regularPriceSupplement;
    }

    public final SafeguardComponent getSafeguardComponent() {
        return this.safeguardComponent;
    }

    public final Long getSecondPrice() {
        return this.secondPrice;
    }

    public final Boolean getSecondPriceIsReducePrice() {
        return this.secondPriceIsReducePrice;
    }

    public final Boolean getSecondPriceIsUnderline() {
        return this.secondPriceIsUnderline;
    }

    public final String getSecondPricePrefix() {
        return this.secondPricePrefix;
    }

    public final String getSecondPriceSuffix() {
        return this.secondPriceSuffix;
    }

    public final String getSecondPriceSupplement() {
        return this.secondPriceSupplement;
    }

    public final long getServerTime() {
        return this.serverTime;
    }

    public final int getShowPriceStyle() {
        return this.showPriceStyle;
    }

    public final boolean getShowStock() {
        return this.showStock;
    }

    public final Map<String, String> getShowTrackParams() {
        return this.showTrackParams;
    }

    public final SkuBannerStruct getSkuBanner() {
        return this.skuBanner;
    }

    public final Map<String, SkuItemInfoVO> getSkuList() {
        return this.skuList;
    }

    public final Long getSkuType() {
        return this.skuType;
    }

    public final Map<String, String> getSmallPicMap() {
        return this.smallPicMap;
    }

    public final List<SpecInfo> getSpecInfoList() {
        return this.specInfoList;
    }

    public final int getStatus() {
        return this.status;
    }

    public final TopBannerComponent getTopBannerComponent() {
        return this.topBannerComponent;
    }

    public final TradeModeComponent getTradeModeComponent() {
        return this.tradeModeComponent;
    }

    public final SkuTrustTags getTrustTags() {
        return this.trustTags;
    }

    public final Long getUnUseMinPrice() {
        return this.unUseMinPrice;
    }

    public final UpdateActionOption getUpdateActionOption() {
        return this.updateActionOption;
    }

    public final SkuLimit getUpperLimit() {
        return this.upperLimit;
    }

    public final void setAtmosphereStyle(Integer r100) {
        this.atmosphereStyle = r100;
    }

    public final void setCampaignEndTime(long r100) {
        this.campaignEndTime = r100;
    }

    public final void setCampaignStartTime(long r100) {
        this.campaignStartTime = r100;
    }

    public final void setFirstPrice(Long r100) {
        this.firstPrice = r100;
    }

    public final void setFirstPriceIsUnderline(Boolean r100) {
        this.firstPriceIsUnderline = r100;
    }

    public final void setFirstPricePrefix(String r100) {
        this.firstPricePrefix = r100;
    }

    public final void setFirstPriceSuffix(String r100) {
        this.firstPriceSuffix = r100;
    }

    public final void setFirstPriceSupplement(String r100) {
        this.firstPriceSupplement = r100;
    }

    public final void setHotMaxPrice(Long r100) {
        this.hotMaxPrice = r100;
    }

    public final void setHotMinPrice(Long r100) {
        this.hotMinPrice = r100;
    }

    public final void setHotPricePrefix(String r100) {
        this.hotPricePrefix = r100;
    }

    public final void setHotPriceSupplement(String r100) {
        this.hotPriceSupplement = r100;
    }

    public final void setNewBonusText(String r100) {
        this.newBonusText = r100;
    }

    public final void setPriceHeaderStyle(Integer r100) {
        this.priceHeaderStyle = r100;
    }

    public final void setPriceType(Long r100) {
        this.priceType = r100;
    }

    public final void setRegularPrice(Long r100) {
        this.regularPrice = r100;
    }

    public final void setRegularPriceIsUnderline(Boolean r100) {
        this.regularPriceIsUnderline = r100;
    }

    public final void setRegularPricePrefix(String r100) {
        this.regularPricePrefix = r100;
    }

    public final void setRegularPriceSuffix(String r100) {
        this.regularPriceSuffix = r100;
    }

    public final void setRegularPriceSupplement(String r100) {
        this.regularPriceSupplement = r100;
    }

    public final void setSecondPrice(Long r100) {
        this.secondPrice = r100;
    }

    public final void setSecondPriceIsUnderline(Boolean r100) {
        this.secondPriceIsUnderline = r100;
    }

    public final void setSecondPricePrefix(String r100) {
        this.secondPricePrefix = r100;
    }

    public final void setSecondPriceSuffix(String r100) {
        this.secondPriceSuffix = r100;
    }

    public final void setSecondPriceSupplement(String r100) {
        this.secondPriceSupplement = r100;
    }

    public final void setSkuType(Long r100) {
        this.skuType = r100;
    }

    public SkuInfoVO(Map<String, SkuItemInfoVO> r100, List<SpecInfo> r101, ClothesSizeAssistantStruct r102, String r110, String r111, Map<String, String> r112, Map<String, String> r113, Map<String, String> r114, long r115, long r116, String r117, SkuLimit r210, SkuLimit r211, Long r212, Long r213, String r214, Long r215, String r216, String r217, SkuInstallmentItemInfo r218, TradeModeComponent r219, SafeguardComponent r310, TopBannerComponent r311, SkuTrustTags r312, String r313, String r314, Integer r315, String r316, Long r317, int r318, long r319, String r410, long r411, long r412, long r413, long r414, ECUrlModel r510, SkuPoiInfo r511, String r512, ECUrlModel r513, Integer r514, Boolean r515, Integer r516, SkuBannerStruct r517, boolean r518, int r519, int r610, LogPbData r611, List<SkuBottomButtons> r612, DisplayConfig r613, CarAdaptComponent r614, OrderComponent r615, Long r616, String r617, String r618, Boolean r619, String r710, Long r711, String r712, String r713, Boolean r714, Boolean r715, String r716, Long r717, Long r718, String r719, String r810, Boolean r811, String r812, Long r813, Long r814, String r815, String r816, Integer r817, String r818, ButtonTipComponent r819, Map<String, String> r910, SkuAddCartGuideInfo r911, UpdateActionOption r912) {
        Intrinsics.checkNotNullParameter(r100, "skuList");
        Intrinsics.checkNotNullParameter(r101, "specInfoList");
        Intrinsics.checkNotNullParameter(r210, "upperLimit");
        Intrinsics.checkNotNullParameter(r211, "lowerLimit");
        this.skuList = r100;
        this.specInfoList = r101;
        this.clothesSizeAssistant = r102;
        this.cover = r110;
        this.bigCover = r111;
        this.pictureMap = r112;
        this.bigPicMap = r113;
        this.smallPicMap = r114;
        this.minPrice = r115;
        this.maxPrice = r116;
        this.buttonLabel = r117;
        this.upperLimit = r210;
        this.lowerLimit = r211;
        this.unUseMinPrice = r212;
        this.discountPrice = r213;
        this.discountPriceHeader = r214;
        this.presellType = r215;
        this.deliveryDelayDesc = r216;
        this.presellDelayDesc = r217;
        this.installmentInfo = r218;
        this.tradeModeComponent = r219;
        this.safeguardComponent = r310;
        this.topBannerComponent = r311;
        this.trustTags = r312;
        this.logExtra = r313;
        this.priceHeader = r314;
        this.priceHeaderStyle = r315;
        this.newBonusText = r316;
        this.skuType = r317;
        this.status = r318;
        this.depositPrice = r319;
        this.limitText = r410;
        this.campaignStartTime = r411;
        this.campaignEndTime = r412;
        this.serverTime = r413;
        this.marketPrice = r414;
        this.activityIcon = r510;
        this.poiInfo = r511;
        this.atmosphereHeader = r512;
        this.atmosphereBackground = r513;
        this.campaignSubType = r514;
        this.hasGivenProduct = r515;
        this.givenProductStock = r516;
        this.skuBanner = r517;
        this.showStock = r518;
        this.showPriceStyle = r519;
        this.discountPriceStyleType = r610;
        this.logPb = r611;
        this.defaultButtons = r612;
        this.displayConfig = r613;
        this.carAdaptComponent = r614;
        this.orderComponent = r615;
        this.firstPrice = r616;
        this.firstPricePrefix = r617;
        this.firstPriceSuffix = r618;
        this.firstPriceIsUnderline = r619;
        this.firstPriceSupplement = r710;
        this.secondPrice = r711;
        this.secondPricePrefix = r712;
        this.secondPriceSuffix = r713;
        this.secondPriceIsUnderline = r714;
        this.secondPriceIsReducePrice = r715;
        this.secondPriceSupplement = r716;
        this.priceType = r717;
        this.regularPrice = r718;
        this.regularPricePrefix = r719;
        this.regularPriceSuffix = r810;
        this.regularPriceIsUnderline = r811;
        this.regularPriceSupplement = r812;
        this.hotMinPrice = r813;
        this.hotMaxPrice = r814;
        this.hotPricePrefix = r815;
        this.hotPriceSupplement = r816;
        this.atmosphereStyle = r817;
        this.productExtra = r818;
        this.buttonTipComponent = r819;
        this.showTrackParams = r910;
        this.addCartGuideInfo = r911;
        this.updateActionOption = r912;
    }

    public /* synthetic */ SkuInfoVO(Map r810, List r811, ClothesSizeAssistantStruct r812, String r813, String r814, Map r815, Map r910, Map r911, long r912, long r913, String r914, SkuLimit r915, SkuLimit r916, Long r917, Long r100, String r101, Long r102, String r103, String r104, SkuInstallmentItemInfo r105, TradeModeComponent r106, SafeguardComponent r107, TopBannerComponent r108, SkuTrustTags r109, String r110, String r111, Integer r112, String r113, Long r114, int r115, long r116, String r118, long r119, long r121, long r123, long r125, ECUrlModel r127, SkuPoiInfo r128, String r129, ECUrlModel r130, Integer r131, Boolean r132, Integer r133, SkuBannerStruct r134, boolean r135, int r136, int r137, LogPbData r138, List r139, DisplayConfig r140, CarAdaptComponent r141, OrderComponent r142, Long r143, String r144, String r145, Boolean r146, String r147, Long r148, String r149, String r150, Boolean r151, Boolean r152, String r153, Long r154, Long r155, String r156, String r157, Boolean r158, String r159, Long r160, Long r161, String r162, String r163, Integer r164, String r165, ButtonTipComponent r166, Map r167, SkuAddCartGuideInfo r168, UpdateActionOption r169, int r170, int r171, int r172, DefaultConstructorMarker r173) {
        if ((r170 & 1) == 0) goto L5;
        Map r117 = new HashMap();
    L7:
        if ((r170 & 2) == 0) goto L9;
        List r120 = CollectionsKt.emptyList();
    L11:
        if ((r170 & 4) == 0) goto L13;
        ClothesSizeAssistantStruct r122 = null;
    L15:
        if ((r170 & 8) == 0) goto L17;
        String r124 = null;
    L19:
        if ((r170 & 16) == 0) goto L21;
        String r126 = null;
    L23:
        if ((r170 & 32) == 0) goto L25;
        Map r174 = null;
    L27:
        if ((r170 & 64) == 0) goto L29;
        Map r175 = null;
    L31:
        if ((r170 & 128) == 0) goto L33;
        Map r176 = null;
    L35:
        if ((r170 & 256) == 0) goto L37;
        long r177 = 0;
    L39:
        if ((r170 & 512) == 0) goto L41;
        long r178 = 0;
    L43:
        if ((r170 & 1024) == 0) goto L45;
        String r179 = null;
    L47:
        if ((r170 & 2048) == 0) goto L49;
        SkuLimit r180 = new SkuLimit(Long.MAX_VALUE, null);
    L51:
        if ((r170 & 4096) == 0) goto L53;
        SkuLimit r181 = new SkuLimit(1, null);
    L55:
        if ((r170 & 8192) == 0) goto L57;
        Long r182 = null;
    L59:
        if ((r170 & 16384) == 0) goto L61;
        Long r183 = null;
    L63:
        if ((r170 & 32768) == 0) goto L65;
        String r210 = null;
    L67:
        if ((r170 & 65536) == 0) goto L69;
        Long r211 = null;
    L71:
        if ((r170 & 131072) == 0) goto L73;
        String r212 = null;
    L75:
        if ((r170 & 262144) == 0) goto L77;
        String r213 = null;
    L79:
        if ((r170 & 524288) == 0) goto L81;
        SkuInstallmentItemInfo r214 = null;
    L83:
        if ((r170 & 1048576) == 0) goto L85;
        TradeModeComponent r215 = null;
    L87:
        if ((r170 & 2097152) == 0) goto L89;
        SafeguardComponent r310 = null;
    L91:
        if ((r170 & 4194304) == 0) goto L93;
        TopBannerComponent r311 = null;
    L95:
        if ((r170 & 8388608) == 0) goto L97;
        SkuTrustTags r312 = null;
    L99:
        if ((r170 & 16777216) == 0) goto L101;
        String r313 = null;
    L103:
        if ((r170 & 33554432) == 0) goto L105;
        String r314 = null;
    L106:
        int r315 = 0;
        if ((r170 & 67108864) == 0) goto L109;
        Integer r316 = 0;
    L111:
        if ((r170 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        String r317 = null;
    L115:
        if ((r170 & 268435456) == 0) goto L117;
        Long r318 = null;
    L119:
        if ((r170 & 536870912) == 0) goto L121;
        int r319 = 2;
    L123:
        if ((r170 & 1073741824) == 0) goto L125;
        long r410 = 0;
    L127:
        if ((r170 & Integer.MIN_VALUE) == 0) goto L129;
        String r184 = null;
    L131:
        if ((r171 & 1) == 0) goto L133;
        long r411 = 0;
    L135:
        if ((r171 & 2) == 0) goto L137;
        long r412 = 0;
    L139:
        if ((r171 & 4) == 0) goto L141;
        long r413 = 0;
    L143:
        if ((r171 & 8) == 0) goto L145;
        long r414 = 0;
    L147:
        if ((r171 & 16) == 0) goto L149;
        ECUrlModel r510 = null;
    L151:
        if ((r171 & 32) == 0) goto L153;
        SkuPoiInfo r511 = null;
    L155:
        if ((r171 & 64) == 0) goto L157;
        String r512 = null;
    L159:
        if ((r171 & 128) == 0) goto L161;
        ECUrlModel r185 = null;
    L162:
        ECUrlModel r1710 = r185;
        if ((r171 & 256) == 0) goto L165;
        Integer r186 = null;
    L166:
        Integer r513 = r186;
        if ((r171 & 512) == 0) goto L169;
        Boolean r187 = null;
    L170:
        Boolean r514 = r187;
        if ((r171 & 1024) == 0) goto L173;
        Integer r188 = null;
    L174:
        Integer r515 = r188;
        if ((r171 & 2048) == 0) goto L177;
        SkuBannerStruct r189 = null;
    L178:
        SkuBannerStruct r516 = r189;
        if ((r171 & 4096) == 0) goto L181;
        boolean r190 = true;
    L182:
        boolean r517 = r190;
        if ((r171 & 8192) == 0) goto L185;
        int r191 = 0;
    L186:
        int r518 = r191;
        if ((r171 & 16384) != 0) goto L191;
        r315 = r137;
    L191:
        if ((r171 & 32768) == 0) goto L193;
        LogPbData r192 = null;
    L195:
        if ((r171 & 65536) == 0) goto L197;
        List r193 = null;
    L199:
        if ((r171 & 131072) == 0) goto L201;
        DisplayConfig r216 = null;
    L203:
        if ((r171 & 262144) == 0) goto L205;
        CarAdaptComponent r217 = null;
    L207:
        if ((r171 & 524288) == 0) goto L209;
        OrderComponent r218 = null;
    L211:
        if ((r171 & 1048576) == 0) goto L213;
        Long r519 = null;
    L215:
        if ((r171 & 2097152) == 0) goto L217;
        String r610 = null;
    L219:
        if ((r171 & 4194304) == 0) goto L221;
        String r611 = null;
    L223:
        if ((r171 & 8388608) == 0) goto L225;
        Boolean r612 = null;
    L227:
        if ((r171 & 16777216) == 0) goto L229;
        String r613 = null;
    L231:
        if ((r171 & 33554432) == 0) goto L233;
        Long r614 = null;
    L235:
        if ((r171 & 67108864) == 0) goto L237;
        String r615 = null;
    L239:
        if ((r171 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L241;
        String r616 = null;
    L243:
        if ((r171 & 268435456) == 0) goto L245;
        Boolean r617 = null;
    L247:
        if ((r171 & 536870912) == 0) goto L249;
        Boolean r618 = null;
    L251:
        if ((r171 & 1073741824) == 0) goto L253;
        String r619 = null;
    L255:
        if ((r171 & Integer.MIN_VALUE) == 0) goto L257;
        Long r194 = null;
    L259:
        if ((r172 & 1) == 0) goto L261;
        Long r710 = null;
    L263:
        if ((r172 & 2) == 0) goto L265;
        String r711 = null;
    L267:
        if ((r172 & 4) == 0) goto L269;
        String r712 = null;
    L271:
        if ((r172 & 8) == 0) goto L273;
        Boolean r713 = null;
    L275:
        if ((r172 & 16) == 0) goto L277;
        String r714 = null;
    L279:
        if ((r172 & 32) == 0) goto L281;
        Long r715 = null;
    L283:
        if ((r172 & 64) == 0) goto L285;
        Long r716 = null;
    L286:
        Long r1711 = r194;
        if ((r172 & 128) == 0) goto L289;
        String r195 = null;
    L290:
        String r717 = r195;
        if ((r172 & 256) == 0) goto L293;
        String r196 = null;
    L294:
        String r718 = r196;
        if ((r172 & 512) == 0) goto L297;
        Integer r197 = null;
    L298:
        Integer r719 = r197;
        if ((r172 & 1024) == 0) goto L301;
        String r198 = null;
    L302:
        String r816 = r198;
        if ((r172 & 2048) == 0) goto L305;
        ButtonTipComponent r199 = null;
    L306:
        ButtonTipComponent r817 = r199;
        if ((r172 & 4096) == 0) goto L309;
        Map r200 = null;
    L310:
        Map r818 = r200;
        if ((r172 & 8192) == 0) goto L313;
        SkuAddCartGuideInfo r201 = null;
    L315:
        if ((r172 & 16384) == 0) goto L317;
        UpdateActionOption r202 = null;
    L318:
        this(r117, r120, r122, r124, r126, r174, r175, r176, r177, r178, r179, r180, r181, r182, r183, r210, r211, r212, r213, r214, r215, r310, r311, r312, r313, r314, r316, r317, r318, r319, r410, r184, r411, r412, r413, r414, r510, r511, r512, r1710, r513, r514, r515, r516, r517, r518, r315, r192, r193, r216, r217, r218, r519, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r1711, r710, r711, r712, r713, r714, r715, r716, r717, r718, r719, r816, r817, r818, r201, r202);
        return;
    L317:
        r202 = r169;
        goto L318
    L313:
        r201 = r168;
        goto L315
    L309:
        r200 = r167;
        goto L310
    L305:
        r199 = r166;
        goto L306
    L301:
        r198 = r165;
        goto L302
    L297:
        r197 = r164;
        goto L298
    L293:
        r196 = r163;
        goto L294
    L289:
        r195 = r162;
        goto L290
    L285:
        r716 = r161;
        goto L286
    L281:
        r715 = r160;
        goto L283
    L277:
        r714 = r159;
        goto L279
    L273:
        r713 = r158;
        goto L275
    L269:
        r712 = r157;
        goto L271
    L265:
        r711 = r156;
        goto L267
    L261:
        r710 = r155;
        goto L263
    L257:
        r194 = r154;
        goto L259
    L253:
        r619 = r153;
        goto L255
    L249:
        r618 = r152;
        goto L251
    L245:
        r617 = r151;
        goto L247
    L241:
        r616 = r150;
        goto L243
    L237:
        r615 = r149;
        goto L239
    L233:
        r614 = r148;
        goto L235
    L229:
        r613 = r147;
        goto L231
    L225:
        r612 = r146;
        goto L227
    L221:
        r611 = r145;
        goto L223
    L217:
        r610 = r144;
        goto L219
    L213:
        r519 = r143;
        goto L215
    L209:
        r218 = r142;
        goto L211
    L205:
        r217 = r141;
        goto L207
    L201:
        r216 = r140;
        goto L203
    L197:
        r193 = r139;
        goto L199
    L193:
        r192 = r138;
        goto L195
    L185:
        r191 = r136;
        goto L186
    L181:
        r190 = r135;
        goto L182
    L177:
        r189 = r134;
        goto L178
    L173:
        r188 = r133;
        goto L174
    L169:
        r187 = r132;
        goto L170
    L165:
        r186 = r131;
        goto L166
    L161:
        r185 = r130;
        goto L162
    L157:
        r512 = r129;
        goto L159
    L153:
        r511 = r128;
        goto L155
    L149:
        r510 = r127;
        goto L151
    L145:
        r414 = r125;
        goto L147
    L141:
        r413 = r123;
        goto L143
    L137:
        r412 = r121;
        goto L139
    L133:
        r411 = r119;
        goto L135
    L129:
        r184 = r118;
        goto L131
    L125:
        r410 = r116;
        goto L127
    L121:
        r319 = r115;
        goto L123
    L117:
        r318 = r114;
        goto L119
    L113:
        r317 = r113;
        goto L115
    L109:
        r316 = r112;
        goto L111
    L105:
        r314 = r111;
        goto L106
    L101:
        r313 = r110;
        goto L103
    L97:
        r312 = r109;
        goto L99
    L93:
        r311 = r108;
        goto L95
    L89:
        r310 = r107;
        goto L91
    L85:
        r215 = r106;
        goto L87
    L81:
        r214 = r105;
        goto L83
    L77:
        r213 = r104;
        goto L79
    L73:
        r212 = r103;
        goto L75
    L69:
        r211 = r102;
        goto L71
    L65:
        r210 = r101;
        goto L67
    L61:
        r183 = r100;
        goto L63
    L57:
        r182 = r917;
        goto L59
    L53:
        r181 = r916;
        goto L55
    L49:
        r180 = r915;
        goto L51
    L45:
        r179 = r914;
        goto L47
    L41:
        r178 = r913;
        goto L43
    L37:
        r177 = r912;
        goto L39
    L33:
        r176 = r911;
        goto L35
    L29:
        r175 = r910;
        goto L31
    L25:
        r174 = r815;
        goto L27
    L21:
        r126 = r814;
        goto L23
    L17:
        r124 = r813;
        goto L19
    L13:
        r122 = r812;
        goto L15
    L9:
        r120 = r811;
        goto L11
    L5:
        r117 = r810;
        goto L7
    }
}

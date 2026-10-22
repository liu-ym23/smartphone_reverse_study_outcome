package com.bytedance.android.shopping.anchorv3;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.ec.model.ECBoltParam;
import com.bytedance.android.ec.model.InnerFlowAdRawData;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.anchorv3.compat.AdNationalTaskInfo;
import com.bytedance.android.shopping.anchorv3.repository.api.AnchorV3PromotionRequestParam;
import com.bytedance.android.shopping.anchorv3.repository.dto.FallbackPage;
import com.bytedance.android.shopping.anchorv3.view.SellPointVO;
import com.bytedance.android.shopping.api.anchorv3.ECLogExtraData;
import com.bytedance.android.shopping.api.anchorv3.ECUIParam;
import com.bytedance.android.shopping.api.model.ECAnchorV3ExtraData;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\bp\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BÍ\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\"\u001a\u00020\u0007\u0012\b\b\u0002\u0010#\u001a\u00020\u0007\u0012\b\b\u0002\u0010$\u001a\u00020\u0007\u0012\b\b\u0002\u0010%\u001a\u00020\u0007\u0012\b\b\u0002\u0010&\u001a\u00020\u001a\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u00102\u001a\u00020\u0012\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u000106\u0012\b\b\u0002\u00107\u001a\u00020\u0012\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010:\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010:\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010@\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010B\u001a\u00020\u0007\u0012\b\b\u0002\u0010C\u001a\u00020\u001a¢\u0006\u0002\u0010DJ\n\u0010§\u0001\u001a\u00020\u0003HÆ\u0003J\u0011\u0010¨\u0001\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010wJ\f\u0010©\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010ª\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010«\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010¬\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010®\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\n\u0010¯\u0001\u001a\u00020\u001aHÆ\u0003J\f\u0010°\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010±\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\n\u0010²\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010³\u0001\u001a\u00020\u0012HÆ\u0003J\f\u0010´\u0001\u001a\u0004\u0018\u00010\u001fHÆ\u0003J\f\u0010µ\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010¶\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\n\u0010·\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010¸\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010¹\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010º\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010»\u0001\u001a\u00020\u001aHÆ\u0003J\f\u0010¼\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010½\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010¾\u0001\u001a\u0004\u0018\u00010)HÆ\u0003J\f\u0010¿\u0001\u001a\u0004\u0018\u00010+HÆ\u0003J\f\u0010À\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010Á\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010Â\u0001\u001a\u0004\u0018\u00010/HÆ\u0003J\f\u0010Ã\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010Ä\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\n\u0010Å\u0001\u001a\u00020\u0012HÆ\u0003J\f\u0010Æ\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010Ç\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0012\u0010È\u0001\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tHÆ\u0003J\f\u0010É\u0001\u001a\u0004\u0018\u000106HÆ\u0003J\n\u0010Ê\u0001\u001a\u00020\u0012HÆ\u0003J\f\u0010Ë\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010Ì\u0001\u001a\u0004\u0018\u00010:HÆ\u0003¢\u0006\u0002\u0010sJ\f\u0010Í\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010Î\u0001\u001a\u0004\u0018\u00010:HÆ\u0003¢\u0006\u0002\u0010sJ\f\u0010Ï\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010Ð\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010Ñ\u0001\u001a\u0004\u0018\u00010@HÆ\u0003J\f\u0010Ò\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\f\u0010Ó\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\n\u0010Ô\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010Õ\u0001\u001a\u00020\u001aHÆ\u0003J\n\u0010Ö\u0001\u001a\u00020\u0007HÆ\u0003J\n\u0010×\u0001\u001a\u00020\u0007HÆ\u0003J\f\u0010Ø\u0001\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\f\u0010Ù\u0001\u001a\u0004\u0018\u00010\u0010HÆ\u0003JÜ\u0004\u0010Ú\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u001d\u001a\u00020\u00122\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\"\u001a\u00020\u00072\b\b\u0002\u0010#\u001a\u00020\u00072\b\b\u0002\u0010$\u001a\u00020\u00072\b\b\u0002\u0010%\u001a\u00020\u00072\b\b\u0002\u0010&\u001a\u00020\u001a2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u00102\u001a\u00020\u00122\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\b\b\u0002\u00107\u001a\u00020\u00122\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u00109\u001a\u0004\u0018\u00010:2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010<\u001a\u0004\u0018\u00010:2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010?\u001a\u0004\u0018\u00010@2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010B\u001a\u00020\u00072\b\b\u0002\u0010C\u001a\u00020\u001aHÆ\u0001¢\u0006\u0003\u0010Û\u0001J\u0016\u0010Ü\u0001\u001a\u00020\u001a2\n\u0010Ý\u0001\u001a\u0005\u0018\u00010Þ\u0001HÖ\u0003J\n\u0010ß\u0001\u001a\u00020\u0012HÖ\u0001J\n\u0010à\u0001\u001a\u00020\u0007HÖ\u0001R\u001c\u00101\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001c\u00100\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010F\"\u0004\bJ\u0010HR\u001c\u0010?\u001a\u0004\u0018\u00010@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\bO\u0010PR\u0013\u00108\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010FR\u0013\u00104\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bR\u0010FR\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u001c\u0010 \u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010F\"\u0004\bX\u0010HR\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bY\u0010FR\u0011\u0010B\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010FR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\\R\u001a\u00102\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u001a\u0010%\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010F\"\u0004\bb\u0010HR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bg\u0010FR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bh\u0010FR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bi\u0010FR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010F\"\u0004\bk\u0010HR\u001c\u0010l\u001a\u0004\u0018\u00010mX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\u0015\u0010<\u001a\u0004\u0018\u00010:¢\u0006\n\n\u0002\u0010t\u001a\u0004\br\u0010sR\u0013\u0010=\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\bu\u0010FR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\n\n\u0002\u0010x\u001a\u0004\bv\u0010wR\u0013\u0010,\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\by\u0010FR\u0015\u00109\u001a\u0004\u0018\u00010:¢\u0006\n\n\u0002\u0010t\u001a\u0004\bz\u0010sR\u0013\u0010;\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b{\u0010FR\u001a\u0010$\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010F\"\u0004\b}\u0010HR\u001b\u0010&\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b&\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010~R\u0011\u0010C\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\bC\u0010~R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010FR\u0015\u0010*\u001a\u0004\u0018\u00010+¢\u0006\n\n\u0000\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001c\u0010\"\u001a\u00020\u0007X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0083\u0001\u0010F\"\u0005\b\u0084\u0001\u0010HR\u001c\u0010#\u001a\u00020\u0007X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0085\u0001\u0010F\"\u0005\b\u0086\u0001\u0010HR\u0012\u00107\u001a\u00020\u0012¢\u0006\t\n\u0000\u001a\u0005\b\u0087\u0001\u0010^R\u001e\u0010>\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0088\u0001\u0010F\"\u0005\b\u0089\u0001\u0010HR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008a\u0001\u0010F\"\u0005\b\u008b\u0001\u0010HR&\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001\"\u0006\b\u008e\u0001\u0010\u008f\u0001R\u001e\u0010A\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0090\u0001\u0010F\"\u0005\b\u0091\u0001\u0010HR\u0014\u0010'\u001a\u0004\u0018\u00010\u0007¢\u0006\t\n\u0000\u001a\u0005\b\u0092\u0001\u0010FR\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0000\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001R\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u0007¢\u0006\t\n\u0000\u001a\u0005\b\u0095\u0001\u0010FR\u0012\u0010\f\u001a\u00020\u0007¢\u0006\t\n\u0000\u001a\u0005\b\u0096\u0001\u0010FR \u0010.\u001a\u0004\u0018\u00010/X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001\"\u0006\b\u0099\u0001\u0010\u009a\u0001R\u0014\u00103\u001a\u0004\u0018\u00010\u0007¢\u0006\t\n\u0000\u001a\u0005\b\u009b\u0001\u0010FR\u0012\u0010\u001d\u001a\u00020\u0012¢\u0006\t\n\u0000\u001a\u0005\b\u009c\u0001\u0010^R\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u0007¢\u0006\t\n\u0000\u001a\u0005\b\u009d\u0001\u0010FR\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u0007¢\u0006\t\n\u0000\u001a\u0005\b\u009e\u0001\u0010FR\u0015\u00105\u001a\u0004\u0018\u000106¢\u0006\n\n\u0000\u001a\u0006\b\u009f\u0001\u0010 \u0001R\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\n\n\u0000\u001a\u0006\b¡\u0001\u0010¢\u0001R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b£\u0001\u0010F\"\u0005\b¤\u0001\u0010HR\u0014\u0010-\u001a\u0004\u0018\u00010\u0007¢\u0006\t\n\u0000\u001a\u0005\b¥\u0001\u0010FR\u0014\u0010!\u001a\u0004\u0018\u00010\u0007¢\u0006\t\n\u0000\u001a\u0005\b¦\u0001\u0010F¨\u0006á\u0001"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/AnchorV3Param;", "Ljava/io/Serializable;", "requestParam", "Lcom/bytedance/android/shopping/anchorv3/repository/api/AnchorV3PromotionRequestParam;", "currentPromotion", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStruct;", "productId", "", "promotions", "", "currentPromotionId", "authorId", "secAuthorId", "adLogExtra", "Lcom/bytedance/android/ec/model/ECAdLogExtra;", "boltParam", "Lcom/bytedance/android/ec/model/ECBoltParam;", "followStatus", "", "enterMethod", "entranceInfo", "sourceBtmToken", "sourceMethod", "searchId", "isReceptor", "isLuban", "", "eComEntranceFrom", "v3EventsAdditions", "showSkuPanel", "uiParam", "Lcom/bytedance/android/shopping/api/anchorv3/ECUIParam;", "applyCouponIds", "whichAccount", "monitorName", "newMonitorName", "fullPageMonitorName", "commentMonitorName", "isFullScreen", "recommendInfo", "anchorV3ExtraData", "Lcom/bytedance/android/shopping/api/model/ECAnchorV3ExtraData;", "logExtraData", "Lcom/bytedance/android/shopping/api/anchorv3/ECLogExtraData;", "frameCoverImage", "videoId", "sellingPoint", "Lcom/bytedance/android/shopping/anchorv3/view/SellPointVO;", "activityType", "activityLabel", "commentEnterFrom", "sessionId", "adUiControlParams", "taskInfo", "Lcom/bytedance/android/shopping/anchorv3/compat/AdNationalTaskInfo;", "pageInternalFlowStyle", "adType", "frontCategoryId", "", "frontCategoryName", "firstCategoryId", "firstCategoryName", "pageName", "adInnerFlowLogExtra", "Lcom/bytedance/android/ec/model/InnerFlowAdRawData;", "rawCreativeId", "authorOpenId", "isOptInflowCode", "(Lcom/bytedance/android/shopping/anchorv3/repository/api/AnchorV3PromotionRequestParam;Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStruct;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/model/ECAdLogExtra;Lcom/bytedance/android/ec/model/ECBoltParam;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ILcom/bytedance/android/shopping/api/anchorv3/ECUIParam;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lcom/bytedance/android/shopping/api/model/ECAnchorV3ExtraData;Lcom/bytedance/android/shopping/api/anchorv3/ECLogExtraData;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv3/view/SellPointVO;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv3/compat/AdNationalTaskInfo;ILjava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/model/InnerFlowAdRawData;Ljava/lang/String;Ljava/lang/String;Z)V", "getActivityLabel", "()Ljava/lang/String;", "setActivityLabel", "(Ljava/lang/String;)V", "getActivityType", "setActivityType", "getAdInnerFlowLogExtra", "()Lcom/bytedance/android/ec/model/InnerFlowAdRawData;", "setAdInnerFlowLogExtra", "(Lcom/bytedance/android/ec/model/InnerFlowAdRawData;)V", "getAdLogExtra", "()Lcom/bytedance/android/ec/model/ECAdLogExtra;", "getAdType", "getAdUiControlParams", "getAnchorV3ExtraData", "()Lcom/bytedance/android/shopping/api/model/ECAnchorV3ExtraData;", "setAnchorV3ExtraData", "(Lcom/bytedance/android/shopping/api/model/ECAnchorV3ExtraData;)V", "getApplyCouponIds", "setApplyCouponIds", "getAuthorId", "getAuthorOpenId", "getBoltParam", "()Lcom/bytedance/android/ec/model/ECBoltParam;", "getCommentEnterFrom", "()I", "setCommentEnterFrom", "(I)V", "getCommentMonitorName", "setCommentMonitorName", "getCurrentPromotion", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStruct;", "setCurrentPromotion", "(Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStruct;)V", "getCurrentPromotionId", "getEComEntranceFrom", "getEnterMethod", "getEntranceInfo", "setEntranceInfo", "fallbackPage", "Lcom/bytedance/android/shopping/anchorv3/repository/dto/FallbackPage;", "getFallbackPage", "()Lcom/bytedance/android/shopping/anchorv3/repository/dto/FallbackPage;", "setFallbackPage", "(Lcom/bytedance/android/shopping/anchorv3/repository/dto/FallbackPage;)V", "getFirstCategoryId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getFirstCategoryName", "getFollowStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFrameCoverImage", "getFrontCategoryId", "getFrontCategoryName", "getFullPageMonitorName", "setFullPageMonitorName", "()Z", "setFullScreen", "(Z)V", "getLogExtraData", "()Lcom/bytedance/android/shopping/api/anchorv3/ECLogExtraData;", "getMonitorName", "setMonitorName", "getNewMonitorName", "setNewMonitorName", "getPageInternalFlowStyle", "getPageName", "setPageName", "getProductId", "setProductId", "getPromotions", "()Ljava/util/List;", "setPromotions", "(Ljava/util/List;)V", "getRawCreativeId", "setRawCreativeId", "getRecommendInfo", "getRequestParam", "()Lcom/bytedance/android/shopping/anchorv3/repository/api/AnchorV3PromotionRequestParam;", "getSearchId", "getSecAuthorId", "getSellingPoint", "()Lcom/bytedance/android/shopping/anchorv3/view/SellPointVO;", "setSellingPoint", "(Lcom/bytedance/android/shopping/anchorv3/view/SellPointVO;)V", "getSessionId", "getShowSkuPanel", "getSourceBtmToken", "getSourceMethod", "getTaskInfo", "()Lcom/bytedance/android/shopping/anchorv3/compat/AdNationalTaskInfo;", "getUiParam", "()Lcom/bytedance/android/shopping/api/anchorv3/ECUIParam;", "getV3EventsAdditions", "setV3EventsAdditions", "getVideoId", "getWhichAccount", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component5", "component50", "component51", "component6", "component7", "component8", "component9", "copy", "(Lcom/bytedance/android/shopping/anchorv3/repository/api/AnchorV3PromotionRequestParam;Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductStruct;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/model/ECAdLogExtra;Lcom/bytedance/android/ec/model/ECBoltParam;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ILcom/bytedance/android/shopping/api/anchorv3/ECUIParam;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lcom/bytedance/android/shopping/api/model/ECAnchorV3ExtraData;Lcom/bytedance/android/shopping/api/anchorv3/ECLogExtraData;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv3/view/SellPointVO;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv3/compat/AdNationalTaskInfo;ILjava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/model/InnerFlowAdRawData;Ljava/lang/String;Ljava/lang/String;Z)Lcom/bytedance/android/shopping/anchorv3/AnchorV3Param;", "equals", "other", "", "hashCode", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class AnchorV3Param implements Serializable {
    private String activityLabel;
    private String activityType;
    private InnerFlowAdRawData adInnerFlowLogExtra;
    private final ECAdLogExtra adLogExtra;
    private final String adType;
    private final String adUiControlParams;
    private ECAnchorV3ExtraData anchorV3ExtraData;
    private String applyCouponIds;
    private final String authorId;
    private final String authorOpenId;
    private final ECBoltParam boltParam;
    private int commentEnterFrom;
    private String commentMonitorName;
    private PromotionProductStruct currentPromotion;
    private final String currentPromotionId;
    private final String eComEntranceFrom;
    private final String enterMethod;
    private String entranceInfo;
    private FallbackPage fallbackPage;
    private final Long firstCategoryId;
    private final String firstCategoryName;
    private final Integer followStatus;
    private final String frameCoverImage;
    private final Long frontCategoryId;
    private final String frontCategoryName;
    private String fullPageMonitorName;
    private boolean isFullScreen;
    private final boolean isLuban;
    private final boolean isOptInflowCode;
    private final String isReceptor;
    private final ECLogExtraData logExtraData;
    private String monitorName;
    private String newMonitorName;
    private final int pageInternalFlowStyle;
    private String pageName;
    private String productId;
    private List<? extends PromotionProductStruct> promotions;
    private String rawCreativeId;
    private final String recommendInfo;
    private final AnchorV3PromotionRequestParam requestParam;
    private final String searchId;
    private final String secAuthorId;
    private SellPointVO sellingPoint;
    private final String sessionId;
    private final int showSkuPanel;
    private final String sourceBtmToken;
    private final String sourceMethod;
    private final AdNationalTaskInfo taskInfo;
    private final ECUIParam uiParam;
    private String v3EventsAdditions;
    private final String videoId;
    private final String whichAccount;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnchorV3Param copy$default(AnchorV3Param r210, AnchorV3PromotionRequestParam r211, PromotionProductStruct r212, String r213, List r214, String r215, String r216, String r217, ECAdLogExtra r218, ECBoltParam r310, Integer r311, String r312, String r313, String r314, String r315, String r316, String r317, boolean r318, String r319, String r410, int r411, ECUIParam r412, String r413, String r414, String r415, String r416, String r417, String r418, boolean r419, String r510, ECAnchorV3ExtraData r511, ECLogExtraData r512, String r513, String r514, SellPointVO r515, String r516, String r517, int r518, String r519, String r610, AdNationalTaskInfo r611, int r612, String r613, Long r614, String r615, Long r616, String r617, String r618, InnerFlowAdRawData r619, String r710, String r711, boolean r712, int r713, int r714, Object r715) {
        if ((r713 & 1) == 0) goto L5;
        AnchorV3PromotionRequestParam r100 = r210.requestParam;
    L7:
        if ((r713 & 2) == 0) goto L9;
        PromotionProductStruct r101 = r210.currentPromotion;
    L11:
        if ((r713 & 4) == 0) goto L13;
        String r102 = r210.productId;
    L15:
        if ((r713 & 8) == 0) goto L17;
        List r103 = r210.promotions;
    L19:
        if ((r713 & 16) == 0) goto L21;
        String r104 = r210.currentPromotionId;
    L23:
        if ((r713 & 32) == 0) goto L25;
        String r105 = r210.authorId;
    L27:
        if ((r713 & 64) == 0) goto L29;
        String r106 = r210.secAuthorId;
    L31:
        if ((r713 & 128) == 0) goto L33;
        ECAdLogExtra r110 = r210.adLogExtra;
    L35:
        if ((r713 & 256) == 0) goto L37;
        ECBoltParam r111 = r210.boltParam;
    L39:
        if ((r713 & 512) == 0) goto L41;
        Integer r112 = r210.followStatus;
    L43:
        if ((r713 & 1024) == 0) goto L45;
        String r113 = r210.enterMethod;
    L47:
        if ((r713 & 2048) == 0) goto L49;
        String r114 = r210.entranceInfo;
    L51:
        if ((r713 & 4096) == 0) goto L53;
        String r115 = r210.sourceBtmToken;
    L54:
        String r320 = r115;
        if ((r713 & 8192) == 0) goto L57;
        String r116 = r210.sourceMethod;
    L58:
        String r321 = r116;
        if ((r713 & 16384) == 0) goto L61;
        String r117 = r210.searchId;
    L62:
        String r322 = r117;
        if ((r713 & 32768) == 0) goto L65;
        String r118 = r210.isReceptor;
    L66:
        String r323 = r118;
        if ((r713 & 65536) == 0) goto L69;
        boolean r119 = r210.isLuban;
    L70:
        boolean r324 = r119;
        if ((r713 & 131072) == 0) goto L73;
        String r120 = r210.eComEntranceFrom;
    L74:
        String r325 = r120;
        if ((r713 & 262144) == 0) goto L77;
        String r121 = r210.v3EventsAdditions;
    L78:
        String r420 = r121;
        if ((r713 & 524288) == 0) goto L81;
        int r122 = r210.showSkuPanel;
    L82:
        int r421 = r122;
        if ((r713 & 1048576) == 0) goto L85;
        ECUIParam r123 = r210.uiParam;
    L86:
        ECUIParam r422 = r123;
        if ((r713 & 2097152) == 0) goto L89;
        String r124 = r210.applyCouponIds;
    L90:
        String r423 = r124;
        if ((r713 & 4194304) == 0) goto L93;
        String r125 = r210.whichAccount;
    L94:
        String r424 = r125;
        if ((r713 & 8388608) == 0) goto L97;
        String r126 = r210.monitorName;
    L98:
        String r425 = r126;
        if ((r713 & 16777216) == 0) goto L101;
        String r127 = r210.newMonitorName;
    L102:
        String r426 = r127;
        if ((r713 & 33554432) == 0) goto L105;
        String r128 = r210.fullPageMonitorName;
    L106:
        String r427 = r128;
        if ((r713 & 67108864) == 0) goto L109;
        String r129 = r210.commentMonitorName;
    L110:
        String r428 = r129;
        if ((r713 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        boolean r130 = r210.isFullScreen;
    L114:
        boolean r429 = r130;
        if ((r713 & 268435456) == 0) goto L117;
        String r131 = r210.recommendInfo;
    L118:
        String r520 = r131;
        if ((r713 & 536870912) == 0) goto L121;
        ECAnchorV3ExtraData r132 = r210.anchorV3ExtraData;
    L122:
        ECAnchorV3ExtraData r521 = r132;
        if ((r713 & 1073741824) == 0) goto L125;
        ECLogExtraData r133 = r210.logExtraData;
    L127:
        if ((r713 & Integer.MIN_VALUE) == 0) goto L129;
        String r107 = r210.frameCoverImage;
    L130:
        String r522 = r107;
        if ((r714 & 1) == 0) goto L133;
        String r108 = r210.videoId;
    L134:
        String r523 = r108;
        if ((r714 & 2) == 0) goto L137;
        SellPointVO r109 = r210.sellingPoint;
    L138:
        SellPointVO r524 = r109;
        if ((r714 & 4) == 0) goto L141;
        String r134 = r210.activityType;
    L142:
        String r525 = r134;
        if ((r714 & 8) == 0) goto L145;
        String r135 = r210.activityLabel;
    L146:
        String r526 = r135;
        if ((r714 & 16) == 0) goto L149;
        int r136 = r210.commentEnterFrom;
    L150:
        int r527 = r136;
        if ((r714 & 32) == 0) goto L153;
        String r137 = r210.sessionId;
    L154:
        String r528 = r137;
        if ((r714 & 64) == 0) goto L157;
        String r138 = r210.adUiControlParams;
    L158:
        String r620 = r138;
        if ((r714 & 128) == 0) goto L161;
        AdNationalTaskInfo r139 = r210.taskInfo;
    L162:
        AdNationalTaskInfo r621 = r139;
        if ((r714 & 256) == 0) goto L165;
        int r140 = r210.pageInternalFlowStyle;
    L166:
        int r622 = r140;
        if ((r714 & 512) == 0) goto L169;
        String r141 = r210.adType;
    L170:
        String r623 = r141;
        if ((r714 & 1024) == 0) goto L173;
        Long r142 = r210.frontCategoryId;
    L174:
        Long r624 = r142;
        if ((r714 & 2048) == 0) goto L177;
        String r143 = r210.frontCategoryName;
    L178:
        String r625 = r143;
        if ((r714 & 4096) == 0) goto L181;
        Long r144 = r210.firstCategoryId;
    L182:
        Long r626 = r144;
        if ((r714 & 8192) == 0) goto L185;
        String r145 = r210.firstCategoryName;
    L186:
        String r627 = r145;
        if ((r714 & 16384) == 0) goto L189;
        String r146 = r210.pageName;
    L190:
        String r628 = r146;
        if ((r714 & 32768) == 0) goto L193;
        InnerFlowAdRawData r147 = r210.adInnerFlowLogExtra;
    L194:
        InnerFlowAdRawData r629 = r147;
        if ((r714 & 65536) == 0) goto L197;
        String r148 = r210.rawCreativeId;
    L198:
        String r716 = r148;
        if ((r714 & 131072) == 0) goto L201;
        String r149 = r210.authorOpenId;
    L203:
        if ((r714 & 262144) == 0) goto L205;
        boolean r150 = r210.isOptInflowCode;
    L207:
        return r210.copy(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r320, r321, r322, r323, r324, r325, r420, r421, r422, r423, r424, r425, r426, r427, r428, r429, r520, r521, r133, r522, r523, r524, r525, r526, r527, r528, r620, r621, r622, r623, r624, r625, r626, r627, r628, r629, r716, r149, r150);
    L205:
        r150 = r712;
        goto L207
    L201:
        r149 = r711;
        goto L203
    L197:
        r148 = r710;
        goto L198
    L193:
        r147 = r619;
        goto L194
    L189:
        r146 = r618;
        goto L190
    L185:
        r145 = r617;
        goto L186
    L181:
        r144 = r616;
        goto L182
    L177:
        r143 = r615;
        goto L178
    L173:
        r142 = r614;
        goto L174
    L169:
        r141 = r613;
        goto L170
    L165:
        r140 = r612;
        goto L166
    L161:
        r139 = r611;
        goto L162
    L157:
        r138 = r610;
        goto L158
    L153:
        r137 = r519;
        goto L154
    L149:
        r136 = r518;
        goto L150
    L145:
        r135 = r517;
        goto L146
    L141:
        r134 = r516;
        goto L142
    L137:
        r109 = r515;
        goto L138
    L133:
        r108 = r514;
        goto L134
    L129:
        r107 = r513;
        goto L130
    L125:
        r133 = r512;
        goto L127
    L121:
        r132 = r511;
        goto L122
    L117:
        r131 = r510;
        goto L118
    L113:
        r130 = r419;
        goto L114
    L109:
        r129 = r418;
        goto L110
    L105:
        r128 = r417;
        goto L106
    L101:
        r127 = r416;
        goto L102
    L97:
        r126 = r415;
        goto L98
    L93:
        r125 = r414;
        goto L94
    L89:
        r124 = r413;
        goto L90
    L85:
        r123 = r412;
        goto L86
    L81:
        r122 = r411;
        goto L82
    L77:
        r121 = r410;
        goto L78
    L73:
        r120 = r319;
        goto L74
    L69:
        r119 = r318;
        goto L70
    L65:
        r118 = r317;
        goto L66
    L61:
        r117 = r316;
        goto L62
    L57:
        r116 = r315;
        goto L58
    L53:
        r115 = r314;
        goto L54
    L49:
        r114 = r313;
        goto L51
    L45:
        r113 = r312;
        goto L47
    L41:
        r112 = r311;
        goto L43
    L37:
        r111 = r310;
        goto L39
    L33:
        r110 = r218;
        goto L35
    L29:
        r106 = r217;
        goto L31
    L25:
        r105 = r216;
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

    public final AnchorV3PromotionRequestParam component1() {
        return this.requestParam;
    }

    public final Integer component10() {
        return this.followStatus;
    }

    public final String component11() {
        return this.enterMethod;
    }

    public final String component12() {
        return this.entranceInfo;
    }

    public final String component13() {
        return this.sourceBtmToken;
    }

    public final String component14() {
        return this.sourceMethod;
    }

    public final String component15() {
        return this.searchId;
    }

    public final String component16() {
        return this.isReceptor;
    }

    public final boolean component17() {
        return this.isLuban;
    }

    public final String component18() {
        return this.eComEntranceFrom;
    }

    public final String component19() {
        return this.v3EventsAdditions;
    }

    public final PromotionProductStruct component2() {
        return this.currentPromotion;
    }

    public final int component20() {
        return this.showSkuPanel;
    }

    public final ECUIParam component21() {
        return this.uiParam;
    }

    public final String component22() {
        return this.applyCouponIds;
    }

    public final String component23() {
        return this.whichAccount;
    }

    public final String component24() {
        return this.monitorName;
    }

    public final String component25() {
        return this.newMonitorName;
    }

    public final String component26() {
        return this.fullPageMonitorName;
    }

    public final String component27() {
        return this.commentMonitorName;
    }

    public final boolean component28() {
        return this.isFullScreen;
    }

    public final String component29() {
        return this.recommendInfo;
    }

    public final String component3() {
        return this.productId;
    }

    public final ECAnchorV3ExtraData component30() {
        return this.anchorV3ExtraData;
    }

    public final ECLogExtraData component31() {
        return this.logExtraData;
    }

    public final String component32() {
        return this.frameCoverImage;
    }

    public final String component33() {
        return this.videoId;
    }

    public final SellPointVO component34() {
        return this.sellingPoint;
    }

    public final String component35() {
        return this.activityType;
    }

    public final String component36() {
        return this.activityLabel;
    }

    public final int component37() {
        return this.commentEnterFrom;
    }

    public final String component38() {
        return this.sessionId;
    }

    public final String component39() {
        return this.adUiControlParams;
    }

    public final List<PromotionProductStruct> component4() {
        return this.promotions;
    }

    public final AdNationalTaskInfo component40() {
        return this.taskInfo;
    }

    public final int component41() {
        return this.pageInternalFlowStyle;
    }

    public final String component42() {
        return this.adType;
    }

    public final Long component43() {
        return this.frontCategoryId;
    }

    public final String component44() {
        return this.frontCategoryName;
    }

    public final Long component45() {
        return this.firstCategoryId;
    }

    public final String component46() {
        return this.firstCategoryName;
    }

    public final String component47() {
        return this.pageName;
    }

    public final InnerFlowAdRawData component48() {
        return this.adInnerFlowLogExtra;
    }

    public final String component49() {
        return this.rawCreativeId;
    }

    public final String component5() {
        return this.currentPromotionId;
    }

    public final String component50() {
        return this.authorOpenId;
    }

    public final boolean component51() {
        return this.isOptInflowCode;
    }

    public final String component6() {
        return this.authorId;
    }

    public final String component7() {
        return this.secAuthorId;
    }

    public final ECAdLogExtra component8() {
        return this.adLogExtra;
    }

    public final ECBoltParam component9() {
        return this.boltParam;
    }

    public final AnchorV3Param copy(AnchorV3PromotionRequestParam r510, PromotionProductStruct r511, String r512, List<? extends PromotionProductStruct> r513, String r514, String r610, String r611, ECAdLogExtra r612, ECBoltParam r613, Integer r614, String r615, String r616, String r617, String r618, String r619, String r710, boolean r711, String r712, String r713, int r714, ECUIParam r715, String r716, String r717, String r718, String r719, String r810, String r811, boolean r812, String r813, ECAnchorV3ExtraData r814, ECLogExtraData r815, String r816, String r817, SellPointVO r818, String r819, String r910, int r911, String r912, String r913, AdNationalTaskInfo r914, int r915, String r916, Long r917, String r918, Long r919, String r100, String r101, InnerFlowAdRawData r102, String r103, String r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r510, "requestParam");
        Intrinsics.checkNotNullParameter(r511, "currentPromotion");
        Intrinsics.checkNotNullParameter(r610, "authorId");
        Intrinsics.checkNotNullParameter(r611, "secAuthorId");
        Intrinsics.checkNotNullParameter(r718, "monitorName");
        Intrinsics.checkNotNullParameter(r719, "newMonitorName");
        Intrinsics.checkNotNullParameter(r810, "fullPageMonitorName");
        Intrinsics.checkNotNullParameter(r811, "commentMonitorName");
        Intrinsics.checkNotNullParameter(r104, "authorOpenId");
        return new AnchorV3Param(r510, r511, r512, r513, r514, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r710, r711, r712, r713, r714, r715, r716, r717, r718, r719, r810, r811, r812, r813, r814, r815, r816, r817, r818, r819, r910, r911, r912, r913, r914, r915, r916, r917, r918, r919, r100, r101, r102, r103, r104, r105);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AnchorV3Param) == false) goto L108;
        AnchorV3Param r101 = (AnchorV3Param) r100;
        if (Intrinsics.areEqual(this.requestParam, r101.requestParam) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.currentPromotion, r101.currentPromotion) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.productId, r101.productId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.promotions, r101.promotions) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.currentPromotionId, r101.currentPromotionId) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.authorId, r101.authorId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.secAuthorId, r101.secAuthorId) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.adLogExtra, r101.adLogExtra) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.boltParam, r101.boltParam) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.followStatus, r101.followStatus) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.enterMethod, r101.enterMethod) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.entranceInfo, r101.entranceInfo) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.sourceBtmToken, r101.sourceBtmToken) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.sourceMethod, r101.sourceMethod) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.searchId, r101.searchId) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.isReceptor, r101.isReceptor) == true) goto L38;
        return false;
    L38:
        if (this.isLuban == r101.isLuban) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.eComEntranceFrom, r101.eComEntranceFrom) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.v3EventsAdditions, r101.v3EventsAdditions) == true) goto L44;
        return false;
    L44:
        if (this.showSkuPanel == r101.showSkuPanel) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.uiParam, r101.uiParam) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.applyCouponIds, r101.applyCouponIds) == true) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.whichAccount, r101.whichAccount) == true) goto L52;
        return false;
    L52:
        if (Intrinsics.areEqual(this.monitorName, r101.monitorName) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.newMonitorName, r101.newMonitorName) == true) goto L56;
        return false;
    L56:
        if (Intrinsics.areEqual(this.fullPageMonitorName, r101.fullPageMonitorName) == true) goto L58;
        return false;
    L58:
        if (Intrinsics.areEqual(this.commentMonitorName, r101.commentMonitorName) == true) goto L60;
        return false;
    L60:
        if (this.isFullScreen == r101.isFullScreen) goto L62;
        return false;
    L62:
        if (Intrinsics.areEqual(this.recommendInfo, r101.recommendInfo) == true) goto L64;
        return false;
    L64:
        if (Intrinsics.areEqual(this.anchorV3ExtraData, r101.anchorV3ExtraData) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.logExtraData, r101.logExtraData) == true) goto L68;
        return false;
    L68:
        if (Intrinsics.areEqual(this.frameCoverImage, r101.frameCoverImage) == true) goto L70;
        return false;
    L70:
        if (Intrinsics.areEqual(this.videoId, r101.videoId) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.sellingPoint, r101.sellingPoint) == true) goto L74;
        return false;
    L74:
        if (Intrinsics.areEqual(this.activityType, r101.activityType) == true) goto L76;
        return false;
    L76:
        if (Intrinsics.areEqual(this.activityLabel, r101.activityLabel) == true) goto L78;
        return false;
    L78:
        if (this.commentEnterFrom == r101.commentEnterFrom) goto L80;
        return false;
    L80:
        if (Intrinsics.areEqual(this.sessionId, r101.sessionId) == true) goto L82;
        return false;
    L82:
        if (Intrinsics.areEqual(this.adUiControlParams, r101.adUiControlParams) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.taskInfo, r101.taskInfo) == true) goto L86;
        return false;
    L86:
        if (this.pageInternalFlowStyle == r101.pageInternalFlowStyle) goto L88;
        return false;
    L88:
        if (Intrinsics.areEqual(this.adType, r101.adType) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.frontCategoryId, r101.frontCategoryId) == true) goto L92;
        return false;
    L92:
        if (Intrinsics.areEqual(this.frontCategoryName, r101.frontCategoryName) == true) goto L94;
        return false;
    L94:
        if (Intrinsics.areEqual(this.firstCategoryId, r101.firstCategoryId) == true) goto L96;
        return false;
    L96:
        if (Intrinsics.areEqual(this.firstCategoryName, r101.firstCategoryName) == true) goto L98;
        return false;
    L98:
        if (Intrinsics.areEqual(this.pageName, r101.pageName) == true) goto L100;
        return false;
    L100:
        if (Intrinsics.areEqual(this.adInnerFlowLogExtra, r101.adInnerFlowLogExtra) == true) goto L102;
        return false;
    L102:
        if (Intrinsics.areEqual(this.rawCreativeId, r101.rawCreativeId) == true) goto L104;
        return false;
    L104:
        if (Intrinsics.areEqual(this.authorOpenId, r101.authorOpenId) == true) goto L106;
        return false;
    L106:
        if (this.isOptInflowCode == r101.isOptInflowCode) goto L163;
        return false;
    L163:
        return true;
    L108:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v102, types: [int] */
    /* JADX WARN: Type inference failed for: r0v34, types: [int] */
    /* JADX WARN: Type inference failed for: r2v156 */
    /* JADX WARN: Type inference failed for: r2v166 */
    /* JADX WARN: Type inference failed for: r2v182 */
    /* JADX WARN: Type inference failed for: r2v183 */
    /* JADX WARN: Type inference failed for: r2v46, types: [int] */
    /* JADX WARN: Type inference failed for: r2v76, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        AnchorV3PromotionRequestParam r100 = this.requestParam;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        PromotionProductStruct r104 = this.currentPromotion;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.productId;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<? extends PromotionProductStruct> r110 = this.promotions;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.currentPromotionId;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.authorId;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.secAuthorId;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        ECAdLogExtra r122 = this.adLogExtra;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        ECBoltParam r125 = this.boltParam;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        Integer r128 = this.followStatus;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.enterMethod;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.entranceInfo;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.sourceBtmToken;
        if (r137 == null) goto L53;
        int r138 = r137.hashCode();
    L54:
        int r139 = (r136 + r138) * 31;
        String r140 = this.sourceMethod;
        if (r140 == null) goto L57;
        int r141 = r140.hashCode();
    L58:
        int r142 = (r139 + r141) * 31;
        String r143 = this.searchId;
        if (r143 == null) goto L61;
        int r144 = r143.hashCode();
    L62:
        int r145 = (r142 + r144) * 31;
        String r146 = this.isReceptor;
        if (r146 == null) goto L65;
        int r147 = r146.hashCode();
    L66:
        int r148 = (r145 + r147) * 31;
        boolean r149 = this.isLuban;
        ?? r150 = 1;
        ?? r151 = r149;
        if (r149 == false) goto L69;
        r151 = 1;
    L69:
        int r152 = (r148 + r151) * 31;
        String r153 = this.eComEntranceFrom;
        if (r153 == null) goto L72;
        int r154 = r153.hashCode();
    L73:
        int r155 = (r152 + r154) * 31;
        String r156 = this.v3EventsAdditions;
        if (r156 == null) goto L76;
        int r157 = r156.hashCode();
    L77:
        int r158 = (((r155 + r157) * 31) + this.showSkuPanel) * 31;
        ECUIParam r159 = this.uiParam;
        if (r159 == null) goto L80;
        int r160 = r159.hashCode();
    L81:
        int r161 = (r158 + r160) * 31;
        String r162 = this.applyCouponIds;
        if (r162 == null) goto L84;
        int r163 = r162.hashCode();
    L85:
        int r164 = (r161 + r163) * 31;
        String r165 = this.whichAccount;
        if (r165 == null) goto L88;
        int r166 = r165.hashCode();
    L89:
        int r167 = (r164 + r166) * 31;
        String r168 = this.monitorName;
        if (r168 == null) goto L92;
        int r169 = r168.hashCode();
    L93:
        int r170 = (r167 + r169) * 31;
        String r171 = this.newMonitorName;
        if (r171 == null) goto L96;
        int r172 = r171.hashCode();
    L97:
        int r173 = (r170 + r172) * 31;
        String r174 = this.fullPageMonitorName;
        if (r174 == null) goto L100;
        int r175 = r174.hashCode();
    L101:
        int r176 = (r173 + r175) * 31;
        String r177 = this.commentMonitorName;
        if (r177 == null) goto L104;
        int r178 = r177.hashCode();
    L105:
        int r179 = (r176 + r178) * 31;
        boolean r180 = this.isFullScreen;
        ?? r181 = r180;
        if (r180 == false) goto L108;
        r181 = 1;
    L108:
        int r182 = (r179 + r181) * 31;
        String r183 = this.recommendInfo;
        if (r183 == null) goto L111;
        int r184 = r183.hashCode();
    L112:
        int r185 = (r182 + r184) * 31;
        ECAnchorV3ExtraData r186 = this.anchorV3ExtraData;
        if (r186 == null) goto L115;
        int r187 = r186.hashCode();
    L116:
        int r188 = (r185 + r187) * 31;
        ECLogExtraData r189 = this.logExtraData;
        if (r189 == null) goto L119;
        int r190 = r189.hashCode();
    L120:
        int r191 = (r188 + r190) * 31;
        String r192 = this.frameCoverImage;
        if (r192 == null) goto L123;
        int r193 = r192.hashCode();
    L124:
        int r194 = (r191 + r193) * 31;
        String r195 = this.videoId;
        if (r195 == null) goto L127;
        int r196 = r195.hashCode();
    L128:
        int r197 = (r194 + r196) * 31;
        SellPointVO r198 = this.sellingPoint;
        if (r198 == null) goto L131;
        int r199 = r198.hashCode();
    L132:
        int r200 = (r197 + r199) * 31;
        String r201 = this.activityType;
        if (r201 == null) goto L135;
        int r202 = r201.hashCode();
    L136:
        int r203 = (r200 + r202) * 31;
        String r204 = this.activityLabel;
        if (r204 == null) goto L139;
        int r205 = r204.hashCode();
    L140:
        int r206 = (((r203 + r205) * 31) + this.commentEnterFrom) * 31;
        String r207 = this.sessionId;
        if (r207 == null) goto L143;
        int r208 = r207.hashCode();
    L144:
        int r209 = (r206 + r208) * 31;
        String r210 = this.adUiControlParams;
        if (r210 == null) goto L147;
        int r211 = r210.hashCode();
    L148:
        int r212 = (r209 + r211) * 31;
        AdNationalTaskInfo r213 = this.taskInfo;
        if (r213 == null) goto L151;
        int r214 = r213.hashCode();
    L152:
        int r215 = (((r212 + r214) * 31) + this.pageInternalFlowStyle) * 31;
        String r216 = this.adType;
        if (r216 == null) goto L155;
        int r217 = r216.hashCode();
    L156:
        int r218 = (r215 + r217) * 31;
        Long r219 = this.frontCategoryId;
        if (r219 == null) goto L159;
        int r220 = r219.hashCode();
    L160:
        int r221 = (r218 + r220) * 31;
        String r222 = this.frontCategoryName;
        if (r222 == null) goto L163;
        int r223 = r222.hashCode();
    L164:
        int r224 = (r221 + r223) * 31;
        Long r225 = this.firstCategoryId;
        if (r225 == null) goto L167;
        int r226 = r225.hashCode();
    L168:
        int r227 = (r224 + r226) * 31;
        String r228 = this.firstCategoryName;
        if (r228 == null) goto L171;
        int r229 = r228.hashCode();
    L172:
        int r230 = (r227 + r229) * 31;
        String r231 = this.pageName;
        if (r231 == null) goto L175;
        int r232 = r231.hashCode();
    L176:
        int r233 = (r230 + r232) * 31;
        InnerFlowAdRawData r234 = this.adInnerFlowLogExtra;
        if (r234 == null) goto L179;
        int r235 = r234.hashCode();
    L180:
        int r236 = (r233 + r235) * 31;
        String r237 = this.rawCreativeId;
        if (r237 == null) goto L183;
        int r238 = r237.hashCode();
    L184:
        int r239 = (r236 + r238) * 31;
        String r240 = this.authorOpenId;
        if (r240 == null) goto L187;
        r101 = r240.hashCode();
    L187:
        int r241 = (r239 + r101) * 31;
        boolean r242 = this.isOptInflowCode;
        if (r242 == true) goto L192;
        r150 = r242;
    L192:
        return r241 + r150;
    L183:
        r238 = 0;
        goto L184
    L179:
        r235 = 0;
        goto L180
    L175:
        r232 = 0;
        goto L176
    L171:
        r229 = 0;
        goto L172
    L167:
        r226 = 0;
        goto L168
    L163:
        r223 = 0;
        goto L164
    L159:
        r220 = 0;
        goto L160
    L155:
        r217 = 0;
        goto L156
    L151:
        r214 = 0;
        goto L152
    L147:
        r211 = 0;
        goto L148
    L143:
        r208 = 0;
        goto L144
    L139:
        r205 = 0;
        goto L140
    L135:
        r202 = 0;
        goto L136
    L131:
        r199 = 0;
        goto L132
    L127:
        r196 = 0;
        goto L128
    L123:
        r193 = 0;
        goto L124
    L119:
        r190 = 0;
        goto L120
    L115:
        r187 = 0;
        goto L116
    L111:
        r184 = 0;
        goto L112
    L104:
        r178 = 0;
        goto L105
    L100:
        r175 = 0;
        goto L101
    L96:
        r172 = 0;
        goto L97
    L92:
        r169 = 0;
        goto L93
    L88:
        r166 = 0;
        goto L89
    L84:
        r163 = 0;
        goto L85
    L80:
        r160 = 0;
        goto L81
    L76:
        r157 = 0;
        goto L77
    L72:
        r154 = 0;
        goto L73
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
        return "AnchorV3Param(requestParam=" + this.requestParam + ", currentPromotion=" + this.currentPromotion + ", productId=" + this.productId + ", promotions=" + this.promotions + ", currentPromotionId=" + this.currentPromotionId + ", authorId=" + this.authorId + ", secAuthorId=" + this.secAuthorId + ", adLogExtra=" + this.adLogExtra + ", boltParam=" + this.boltParam + ", followStatus=" + this.followStatus + ", enterMethod=" + this.enterMethod + ", entranceInfo=" + this.entranceInfo + ", sourceBtmToken=" + this.sourceBtmToken + ", sourceMethod=" + this.sourceMethod + ", searchId=" + this.searchId + ", isReceptor=" + this.isReceptor + ", isLuban=" + this.isLuban + ", eComEntranceFrom=" + this.eComEntranceFrom + ", v3EventsAdditions=" + this.v3EventsAdditions + ", showSkuPanel=" + this.showSkuPanel + ", uiParam=" + this.uiParam + ", applyCouponIds=" + this.applyCouponIds + ", whichAccount=" + this.whichAccount + ", monitorName=" + this.monitorName + ", newMonitorName=" + this.newMonitorName + ", fullPageMonitorName=" + this.fullPageMonitorName + ", commentMonitorName=" + this.commentMonitorName + ", isFullScreen=" + this.isFullScreen + ", recommendInfo=" + this.recommendInfo + ", anchorV3ExtraData=" + this.anchorV3ExtraData + ", logExtraData=" + this.logExtraData + ", frameCoverImage=" + this.frameCoverImage + ", videoId=" + this.videoId + ", sellingPoint=" + this.sellingPoint + ", activityType=" + this.activityType + ", activityLabel=" + this.activityLabel + ", commentEnterFrom=" + this.commentEnterFrom + ", sessionId=" + this.sessionId + ", adUiControlParams=" + this.adUiControlParams + ", taskInfo=" + this.taskInfo + ", pageInternalFlowStyle=" + this.pageInternalFlowStyle + ", adType=" + this.adType + ", frontCategoryId=" + this.frontCategoryId + ", frontCategoryName=" + this.frontCategoryName + ", firstCategoryId=" + this.firstCategoryId + ", firstCategoryName=" + this.firstCategoryName + ", pageName=" + this.pageName + ", adInnerFlowLogExtra=" + this.adInnerFlowLogExtra + ", rawCreativeId=" + this.rawCreativeId + ", authorOpenId=" + this.authorOpenId + ", isOptInflowCode=" + this.isOptInflowCode + ")";
    }

    public final String getActivityLabel() {
        return this.activityLabel;
    }

    public final String getActivityType() {
        return this.activityType;
    }

    public final InnerFlowAdRawData getAdInnerFlowLogExtra() {
        return this.adInnerFlowLogExtra;
    }

    public final ECAdLogExtra getAdLogExtra() {
        return this.adLogExtra;
    }

    public final String getAdType() {
        return this.adType;
    }

    public final String getAdUiControlParams() {
        return this.adUiControlParams;
    }

    public final ECAnchorV3ExtraData getAnchorV3ExtraData() {
        return this.anchorV3ExtraData;
    }

    public final String getApplyCouponIds() {
        return this.applyCouponIds;
    }

    public final String getAuthorId() {
        return this.authorId;
    }

    public final String getAuthorOpenId() {
        return this.authorOpenId;
    }

    public final ECBoltParam getBoltParam() {
        return this.boltParam;
    }

    public final int getCommentEnterFrom() {
        return this.commentEnterFrom;
    }

    public final String getCommentMonitorName() {
        return this.commentMonitorName;
    }

    public final PromotionProductStruct getCurrentPromotion() {
        return this.currentPromotion;
    }

    public final String getCurrentPromotionId() {
        return this.currentPromotionId;
    }

    public final String getEComEntranceFrom() {
        return this.eComEntranceFrom;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final String getEntranceInfo() {
        return this.entranceInfo;
    }

    public final FallbackPage getFallbackPage() {
        return this.fallbackPage;
    }

    public final Long getFirstCategoryId() {
        return this.firstCategoryId;
    }

    public final String getFirstCategoryName() {
        return this.firstCategoryName;
    }

    public final Integer getFollowStatus() {
        return this.followStatus;
    }

    public final String getFrameCoverImage() {
        return this.frameCoverImage;
    }

    public final Long getFrontCategoryId() {
        return this.frontCategoryId;
    }

    public final String getFrontCategoryName() {
        return this.frontCategoryName;
    }

    public final String getFullPageMonitorName() {
        return this.fullPageMonitorName;
    }

    public final ECLogExtraData getLogExtraData() {
        return this.logExtraData;
    }

    public final String getMonitorName() {
        return this.monitorName;
    }

    public final String getNewMonitorName() {
        return this.newMonitorName;
    }

    public final int getPageInternalFlowStyle() {
        return this.pageInternalFlowStyle;
    }

    public final String getPageName() {
        return this.pageName;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final List<PromotionProductStruct> getPromotions() {
        return this.promotions;
    }

    public final String getRawCreativeId() {
        return this.rawCreativeId;
    }

    public final String getRecommendInfo() {
        return this.recommendInfo;
    }

    public final AnchorV3PromotionRequestParam getRequestParam() {
        return this.requestParam;
    }

    public final String getSearchId() {
        return this.searchId;
    }

    public final String getSecAuthorId() {
        return this.secAuthorId;
    }

    public final SellPointVO getSellingPoint() {
        return this.sellingPoint;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final int getShowSkuPanel() {
        return this.showSkuPanel;
    }

    public final String getSourceBtmToken() {
        return this.sourceBtmToken;
    }

    public final String getSourceMethod() {
        return this.sourceMethod;
    }

    public final AdNationalTaskInfo getTaskInfo() {
        return this.taskInfo;
    }

    public final ECUIParam getUiParam() {
        return this.uiParam;
    }

    public final String getV3EventsAdditions() {
        return this.v3EventsAdditions;
    }

    public final String getVideoId() {
        return this.videoId;
    }

    public final String getWhichAccount() {
        return this.whichAccount;
    }

    public final boolean isFullScreen() {
        return this.isFullScreen;
    }

    public final boolean isLuban() {
        return this.isLuban;
    }

    public final boolean isOptInflowCode() {
        return this.isOptInflowCode;
    }

    public final String isReceptor() {
        return this.isReceptor;
    }

    public final void setActivityLabel(String r100) {
        this.activityLabel = r100;
    }

    public final void setActivityType(String r100) {
        this.activityType = r100;
    }

    public final void setAdInnerFlowLogExtra(InnerFlowAdRawData r100) {
        this.adInnerFlowLogExtra = r100;
    }

    public final void setAnchorV3ExtraData(ECAnchorV3ExtraData r100) {
        this.anchorV3ExtraData = r100;
    }

    public final void setApplyCouponIds(String r100) {
        this.applyCouponIds = r100;
    }

    public final void setCommentEnterFrom(int r100) {
        this.commentEnterFrom = r100;
    }

    public final void setCommentMonitorName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.commentMonitorName = r100;
    }

    public final void setCurrentPromotion(PromotionProductStruct r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.currentPromotion = r100;
    }

    public final void setEntranceInfo(String r100) {
        this.entranceInfo = r100;
    }

    public final void setFallbackPage(FallbackPage r100) {
        this.fallbackPage = r100;
    }

    public final void setFullPageMonitorName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.fullPageMonitorName = r100;
    }

    public final void setFullScreen(boolean r100) {
        this.isFullScreen = r100;
    }

    public final void setMonitorName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.monitorName = r100;
    }

    public final void setNewMonitorName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.newMonitorName = r100;
    }

    public final void setPageName(String r100) {
        this.pageName = r100;
    }

    public final void setProductId(String r100) {
        this.productId = r100;
    }

    public final void setPromotions(List<? extends PromotionProductStruct> r100) {
        this.promotions = r100;
    }

    public final void setRawCreativeId(String r100) {
        this.rawCreativeId = r100;
    }

    public final void setSellingPoint(SellPointVO r100) {
        this.sellingPoint = r100;
    }

    public final void setV3EventsAdditions(String r100) {
        this.v3EventsAdditions = r100;
    }

    public AnchorV3Param(AnchorV3PromotionRequestParam r110, PromotionProductStruct r111, String r112, List<? extends PromotionProductStruct> r113, String r114, String r115, String r116, ECAdLogExtra r117, ECBoltParam r210, Integer r211, String r212, String r213, String r214, String r215, String r216, String r217, boolean r218, String r219, String r310, int r311, ECUIParam r312, String r313, String r314, String r315, String r316, String r317, String r318, boolean r319, String r410, ECAnchorV3ExtraData r411, ECLogExtraData r412, String r413, String r414, SellPointVO r415, String r416, String r417, int r418, String r419, String r510, AdNationalTaskInfo r511, int r512, String r513, Long r514, String r515, Long r516, String r517, String r518, InnerFlowAdRawData r519, String r610, String r611, boolean r612) {
        Intrinsics.checkNotNullParameter(r110, "requestParam");
        Intrinsics.checkNotNullParameter(r111, "currentPromotion");
        Intrinsics.checkNotNullParameter(r115, "authorId");
        Intrinsics.checkNotNullParameter(r116, "secAuthorId");
        Intrinsics.checkNotNullParameter(r315, "monitorName");
        Intrinsics.checkNotNullParameter(r316, "newMonitorName");
        Intrinsics.checkNotNullParameter(r317, "fullPageMonitorName");
        Intrinsics.checkNotNullParameter(r318, "commentMonitorName");
        Intrinsics.checkNotNullParameter(r611, "authorOpenId");
        this.requestParam = r110;
        this.currentPromotion = r111;
        this.productId = r112;
        this.promotions = r113;
        this.currentPromotionId = r114;
        this.authorId = r115;
        this.secAuthorId = r116;
        this.adLogExtra = r117;
        this.boltParam = r210;
        this.followStatus = r211;
        this.enterMethod = r212;
        this.entranceInfo = r213;
        this.sourceBtmToken = r214;
        this.sourceMethod = r215;
        this.searchId = r216;
        this.isReceptor = r217;
        this.isLuban = r218;
        this.eComEntranceFrom = r219;
        this.v3EventsAdditions = r310;
        this.showSkuPanel = r311;
        this.uiParam = r312;
        this.applyCouponIds = r313;
        this.whichAccount = r314;
        this.monitorName = r315;
        this.newMonitorName = r316;
        this.fullPageMonitorName = r317;
        this.commentMonitorName = r318;
        this.isFullScreen = r319;
        this.recommendInfo = r410;
        this.anchorV3ExtraData = r411;
        this.logExtraData = r412;
        this.frameCoverImage = r413;
        this.videoId = r414;
        this.sellingPoint = r415;
        this.activityType = r416;
        this.activityLabel = r417;
        this.commentEnterFrom = r418;
        this.sessionId = r419;
        this.adUiControlParams = r510;
        this.taskInfo = r511;
        this.pageInternalFlowStyle = r512;
        this.adType = r513;
        this.frontCategoryId = r514;
        this.frontCategoryName = r515;
        this.firstCategoryId = r516;
        this.firstCategoryName = r517;
        this.pageName = r518;
        this.adInnerFlowLogExtra = r519;
        this.rawCreativeId = r610;
        this.authorOpenId = r611;
        this.isOptInflowCode = r612;
    }

    public /* synthetic */ AnchorV3Param(AnchorV3PromotionRequestParam r510, PromotionProductStruct r511, String r512, List r513, String r514, String r515, String r516, ECAdLogExtra r517, ECBoltParam r518, Integer r610, String r611, String r612, String r613, String r614, String r615, String r616, boolean r617, String r618, String r619, int r710, ECUIParam r711, String r712, String r713, String r714, String r715, String r716, String r717, boolean r718, String r719, ECAnchorV3ExtraData r810, ECLogExtraData r811, String r812, String r813, SellPointVO r814, String r815, String r816, int r817, String r818, String r819, AdNationalTaskInfo r910, int r911, String r912, Long r913, String r914, Long r915, String r916, String r917, InnerFlowAdRawData r918, String r919, String r100, boolean r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r102 & 4) == 0) goto L5;
        String r105 = null;
    L7:
        if ((r102 & 8) == 0) goto L9;
        List r106 = null;
    L11:
        if ((r102 & 16) == 0) goto L13;
        String r107 = null;
    L15:
        if ((r102 & 32) == 0) goto L17;
        String r108 = "";
    L19:
        if ((r102 & 64) == 0) goto L21;
        String r109 = "";
    L23:
        if ((r102 & 128) == 0) goto L25;
        ECAdLogExtra r110 = null;
    L27:
        if ((r102 & 256) == 0) goto L29;
        ECBoltParam r111 = null;
    L31:
        if ((r102 & 512) == 0) goto L33;
        Integer r112 = null;
    L35:
        if ((r102 & 1024) == 0) goto L37;
        String r113 = null;
    L39:
        if ((r102 & 2048) == 0) goto L41;
        String r114 = null;
    L43:
        if ((r102 & 4096) == 0) goto L45;
        String r115 = null;
    L47:
        if ((r102 & 8192) == 0) goto L49;
        String r116 = null;
    L51:
        if ((r102 & 16384) == 0) goto L53;
        String r117 = null;
    L55:
        if ((r102 & 32768) == 0) goto L57;
        String r118 = null;
    L58:
        boolean r210 = false;
        if ((r102 & 65536) == 0) goto L61;
        boolean r119 = false;
    L63:
        if ((r102 & 131072) == 0) goto L65;
        String r211 = null;
    L67:
        if ((r102 & 262144) == 0) goto L69;
        String r212 = null;
    L71:
        if ((r102 & 524288) == 0) goto L73;
        int r213 = 0;
    L75:
        if ((r102 & 1048576) == 0) goto L77;
        ECUIParam r214 = null;
    L79:
        if ((r102 & 2097152) == 0) goto L81;
        String r215 = null;
    L83:
        if ((r102 & 4194304) == 0) goto L85;
        String r216 = null;
    L87:
        if ((r102 & 8388608) == 0) goto L89;
        String r217 = "";
    L91:
        if ((r102 & 16777216) == 0) goto L93;
        String r310 = "";
    L95:
        if ((r102 & 33554432) == 0) goto L97;
        String r311 = "";
    L99:
        if ((r102 & 67108864) == 0) goto L101;
        String r312 = "";
    L103:
        if ((r102 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L105;
        boolean r313 = false;
    L107:
        if ((r102 & 268435456) == 0) goto L109;
        String r314 = null;
    L111:
        if ((r102 & 536870912) == 0) goto L113;
        ECAnchorV3ExtraData r315 = null;
    L115:
        if ((r102 & 1073741824) == 0) goto L117;
        ECLogExtraData r316 = null;
    L119:
        if ((r102 & Integer.MIN_VALUE) == 0) goto L121;
        String r120 = null;
    L123:
        if ((r103 & 1) == 0) goto L125;
        String r317 = null;
    L127:
        if ((r103 & 2) == 0) goto L129;
        SellPointVO r318 = null;
    L131:
        if ((r103 & 4) == 0) goto L133;
        String r319 = null;
    L135:
        if ((r103 & 8) == 0) goto L137;
        String r410 = null;
    L139:
        if ((r103 & 16) == 0) goto L141;
        int r411 = 0;
    L143:
        if ((r103 & 32) == 0) goto L145;
        String r412 = null;
    L147:
        if ((r103 & 64) == 0) goto L149;
        String r413 = null;
    L151:
        if ((r103 & 128) == 0) goto L153;
        AdNationalTaskInfo r121 = null;
    L154:
        AdNationalTaskInfo r1010 = r121;
        if ((r103 & 256) == 0) goto L157;
        int r122 = 0;
    L158:
        int r414 = r122;
        if ((r103 & 512) == 0) goto L161;
        String r123 = null;
    L162:
        String r415 = r123;
        if ((r103 & 1024) == 0) goto L165;
        Long r124 = null;
    L166:
        Long r416 = r124;
        if ((r103 & 2048) == 0) goto L169;
        String r125 = null;
    L170:
        String r417 = r125;
        if ((r103 & 4096) == 0) goto L173;
        Long r126 = null;
    L174:
        Long r418 = r126;
        if ((r103 & 8192) == 0) goto L177;
        String r127 = null;
    L178:
        String r419 = r127;
        if ((r103 & 16384) == 0) goto L181;
        String r128 = null;
    L183:
        if ((r103 & 32768) == 0) goto L185;
        InnerFlowAdRawData r129 = null;
    L187:
        if ((r103 & 65536) == 0) goto L189;
        String r130 = null;
    L191:
        if ((r103 & 131072) == 0) goto L193;
        String r218 = "";
    L195:
        if ((r103 & 262144) != 0) goto L198;
        r210 = r101;
    L198:
        this(r510, r511, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r211, r212, r213, r214, r215, r216, r217, r310, r311, r312, r313, r314, r315, r316, r120, r317, r318, r319, r410, r411, r412, r413, r1010, r414, r415, r416, r417, r418, r419, r128, r129, r130, r218, r210);
        return;
    L193:
        r218 = r100;
        goto L195
    L189:
        r130 = r919;
        goto L191
    L185:
        r129 = r918;
        goto L187
    L181:
        r128 = r917;
        goto L183
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
        r122 = r911;
        goto L158
    L153:
        r121 = r910;
        goto L154
    L149:
        r413 = r819;
        goto L151
    L145:
        r412 = r818;
        goto L147
    L141:
        r411 = r817;
        goto L143
    L137:
        r410 = r816;
        goto L139
    L133:
        r319 = r815;
        goto L135
    L129:
        r318 = r814;
        goto L131
    L125:
        r317 = r813;
        goto L127
    L121:
        r120 = r812;
        goto L123
    L117:
        r316 = r811;
        goto L119
    L113:
        r315 = r810;
        goto L115
    L109:
        r314 = r719;
        goto L111
    L105:
        r313 = r718;
        goto L107
    L101:
        r312 = r717;
        goto L103
    L97:
        r311 = r716;
        goto L99
    L93:
        r310 = r715;
        goto L95
    L89:
        r217 = r714;
        goto L91
    L85:
        r216 = r713;
        goto L87
    L81:
        r215 = r712;
        goto L83
    L77:
        r214 = r711;
        goto L79
    L73:
        r213 = r710;
        goto L75
    L69:
        r212 = r619;
        goto L71
    L65:
        r211 = r618;
        goto L67
    L61:
        r119 = r617;
        goto L63
    L57:
        r118 = r616;
        goto L58
    L53:
        r117 = r615;
        goto L55
    L49:
        r116 = r614;
        goto L51
    L45:
        r115 = r613;
        goto L47
    L41:
        r114 = r612;
        goto L43
    L37:
        r113 = r611;
        goto L39
    L33:
        r112 = r610;
        goto L35
    L29:
        r111 = r518;
        goto L31
    L25:
        r110 = r517;
        goto L27
    L21:
        r109 = r516;
        goto L23
    L17:
        r108 = r515;
        goto L19
    L13:
        r107 = r514;
        goto L15
    L9:
        r106 = r513;
        goto L11
    L5:
        r105 = r512;
        goto L7
    }
}

package com.bytedance.android.shopping.anchorv4.bottom;

import android.os.SystemClock;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.ec.model.ECBoltParam;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.android.shopping.slice.action.entity.SendClosePdpEventParam;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.downloadlib.constants.EventConstants;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0003\bµ\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0083\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0012\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010+\u001a\u00020\u001a\u0012\b\b\u0002\u0010,\u001a\u00020\u001a\u0012\b\b\u0002\u0010-\u001a\u00020\u001a\u0012\b\b\u0002\u0010.\u001a\u00020\u000f\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u00106\u001a\u00020\u001a\u0012\b\b\u0002\u00107\u001a\u00020\u001a\u0012\b\b\u0002\u00108\u001a\u00020\u001a\u0012\b\b\u0002\u00109\u001a\u00020\u001a\u0012\b\b\u0002\u0010:\u001a\u00020\u001a\u0012\b\b\u0002\u0010;\u001a\u00020\u001a\u0012\b\b\u0002\u0010<\u001a\u00020\u001a\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010I\u001a\u00020\u001a\u0012\b\b\u0002\u0010J\u001a\u00020\u000f\u0012\b\b\u0002\u0010K\u001a\u00020\u000f\u0012\b\b\u0002\u0010L\u001a\u00020\u000f\u0012\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010Q\u001a\u00020\u0012\u0012\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010U\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010VJ\u001b\u0010Ó\u0001\u001a\u0004\u0018\u00010\u00032\u0007\u0010Ô\u0001\u001a\u00020\u001a2\u0007\u0010Õ\u0001\u001a\u00020\u001aJ\u001b\u0010Ö\u0001\u001a\u0004\u0018\u00010\u00032\u0007\u0010Ô\u0001\u001a\u00020\u001a2\u0007\u0010Õ\u0001\u001a\u00020\u001aJ\u0013\u0010×\u0001\u001a\u00020\u00002\n\u0010Ø\u0001\u001a\u0005\u0018\u00010Ù\u0001J\u0007\u0010Ú\u0001\u001a\u00020\u001aR\u0018\u0010T\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bW\u0010XR\u0018\u0010N\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bY\u0010XR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010X\"\u0004\bc\u0010dR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010X\"\u0004\bf\u0010dR\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010X\"\u0004\bl\u0010dR\u0018\u0010P\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bm\u0010XR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010X\"\u0004\bo\u0010dR\u0018\u0010O\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bp\u0010XR\u001c\u0010'\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010X\"\u0004\br\u0010dR\u001e\u0010(\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u0010w\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR\u0018\u0010U\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bx\u0010XR\u0018\u0010D\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\by\u0010XR\u0018\u0010G\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bz\u0010XR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010X\"\u0004\b|\u0010dR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b}\u0010X\"\u0004\b~\u0010dR\u001d\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b\u007f\u0010X\"\u0005\b\u0080\u0001\u0010dR\u0019\u0010S\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0081\u0001\u0010XR\u001c\u0010\u001f\u001a\u00020\u0012X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0082\u0001\u0010_\"\u0005\b\u0083\u0001\u0010aR\u001e\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001\"\u0006\b\u0086\u0001\u0010\u0087\u0001R\u001e\u0010\u001b\u001a\u00020\u001aX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0088\u0001\u0010\u0085\u0001\"\u0006\b\u0089\u0001\u0010\u0087\u0001R\u0019\u00101\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u008a\u0001\u0010XR\u0019\u00102\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u008b\u0001\u0010XR\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008c\u0001\u0010X\"\u0005\b\u008d\u0001\u0010dR\u0019\u0010C\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u008e\u0001\u0010XR\u0019\u0010F\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u008f\u0001\u0010XR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0090\u0001\u0010X\"\u0005\b\u0091\u0001\u0010dR\u0018\u0010I\u001a\u00020\u001a8\u0006X\u0087\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0092\u0001\u0010\u0085\u0001R\"\u00104\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0093\u0001\u0010X\"\u0005\b\u0094\u0001\u0010dR\u0017\u00109\u001a\u00020\u001a8\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b9\u0010\u0085\u0001R\u001d\u0010*\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b*\u0010X\"\u0005\b\u0095\u0001\u0010dR\u001d\u0010+\u001a\u00020\u001aX\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b+\u0010\u0085\u0001\"\u0006\b\u0096\u0001\u0010\u0087\u0001R\u0017\u00106\u001a\u00020\u001a8\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b6\u0010\u0085\u0001R\u0017\u00108\u001a\u00020\u001a8\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b8\u0010\u0085\u0001R\u0017\u0010;\u001a\u00020\u001a8\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b;\u0010\u0085\u0001R\u0017\u0010:\u001a\u00020\u001a8\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b:\u0010\u0085\u0001R\u001d\u0010-\u001a\u00020\u001aX\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b-\u0010\u0085\u0001\"\u0006\b\u0097\u0001\u0010\u0087\u0001R\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0098\u0001\u0010X\"\u0005\b\u0099\u0001\u0010dR\u0019\u0010H\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u009a\u0001\u0010XR\u0019\u0010R\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u009b\u0001\u0010XR\u001e\u0010%\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009c\u0001\u0010X\"\u0005\b\u009d\u0001\u0010dR\u001e\u0010$\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009e\u0001\u0010X\"\u0005\b\u009f\u0001\u0010dR\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b \u0001\u0010X\"\u0005\b¡\u0001\u0010dR\u001e\u0010)\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¢\u0001\u0010X\"\u0005\b£\u0001\u0010dR\u0019\u0010@\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b¤\u0001\u0010XR\u001e\u0010&\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¥\u0001\u0010X\"\u0005\b¦\u0001\u0010dR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b§\u0001\u0010X\"\u0005\b¨\u0001\u0010dR\u0019\u0010?\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b©\u0001\u0010XR\u0017\u0010Q\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\bª\u0001\u0010_R\u0019\u0010B\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b«\u0001\u0010XR\u0019\u0010E\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b¬\u0001\u0010XR\u0019\u0010M\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u00ad\u0001\u0010XR\u001e\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b®\u0001\u0010X\"\u0005\b¯\u0001\u0010dR\u001e\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b°\u0001\u0010X\"\u0005\b±\u0001\u0010dR\u0018\u0010.\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\n\n\u0000\u001a\u0006\b²\u0001\u0010³\u0001R\u001e\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b´\u0001\u0010X\"\u0005\bµ\u0001\u0010dR\u001e\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¶\u0001\u0010³\u0001\"\u0006\b·\u0001\u0010¸\u0001R\u0019\u0010=\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\b¹\u0001\u0010XR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bº\u0001\u0010X\"\u0005\b»\u0001\u0010dR\u0018\u0010J\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\n\n\u0000\u001a\u0006\b¼\u0001\u0010³\u0001R\u0018\u0010K\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\n\n\u0000\u001a\u0006\b½\u0001\u0010³\u0001R\u0018\u0010L\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\n\n\u0000\u001a\u0006\b¾\u0001\u0010³\u0001R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¿\u0001\u0010X\"\u0005\bÀ\u0001\u0010dR\u0019\u00100\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\bÁ\u0001\u0010XR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÂ\u0001\u0010X\"\u0005\bÃ\u0001\u0010dR\u0019\u0010/\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\bÄ\u0001\u0010XR\u0019\u0010>\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\bÅ\u0001\u0010XR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÆ\u0001\u0010X\"\u0005\bÇ\u0001\u0010dR\u0019\u00105\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\bÈ\u0001\u0010XR\u0019\u00103\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\bÉ\u0001\u0010XR\u001e\u0010,\u001a\u00020\u001aX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÊ\u0001\u0010\u0085\u0001\"\u0006\bË\u0001\u0010\u0087\u0001R\u0019\u0010A\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\t\n\u0000\u001a\u0005\bÌ\u0001\u0010XR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÍ\u0001\u0010X\"\u0005\bÎ\u0001\u0010dR\u0018\u0010<\u001a\u00020\u001a8\u0006X\u0087\u0004¢\u0006\n\n\u0000\u001a\u0006\bÏ\u0001\u0010\u0085\u0001R\u0018\u00107\u001a\u00020\u001a8\u0006X\u0087\u0004¢\u0006\n\n\u0000\u001a\u0006\bÐ\u0001\u0010\u0085\u0001R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÑ\u0001\u0010X\"\u0005\bÒ\u0001\u0010d¨\u0006Û\u0001"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/bottom/BuyMeta;", "Ljava/io/Serializable;", "transmissibleJson", "", "v3EventsAdditions", "requestAdditions", "sourcePage", "enterMethod", "entranceInfo", "passThroughEventData", "eComEntranceFrom", "metaParam", "productId", "promotionId", "promotionSource", "", "shopId", "applyCoupon", "", "baseVerifiedCategory", "cardStatus", "brandVerified", "hasReplay", "goodsType", "liveRoomId", "fromLive", "", "fromVideo", "authorId", "secAuthorId", "itemId", "followStatus", "adLogExtra", "Lcom/bytedance/android/ec/model/ECAdLogExtra;", "boltParam", "Lcom/bytedance/android/ec/model/ECBoltParam;", "labelNameLive", "labelName", "marketingChannel", RemoteMessageConst.Notification.CHANNEL_ID, "channelType", "logData", "isAuthenticInsure", "isCrossBorderProduct", "thirdParty", "isVirtual", "productMinPrice", "shopName", "shopCover", "goodTitle", "goodTitleTags", "subtitle", "icon", "subTitleTextColor", "isDepositPreSaleProduct", "useNewOrderSchema", "isInsuranceProduct", "isAuctionProduct", "isScarceBuyProduct", "isMemberSampleProduct", "useNativeBuy", "recommendInfo", "smallAppUrl", "openAppUrl", "lynxUrl", "toast", "orderUrl", "groupBuyOrderUrl", "customBuyOrderUrl", "orderUrlV2", "groupBuyOrderUrlV2", "customBuyOrderUrlV2", "joinMemberUrl", "hasSecActivity", "secActivityBeginTime", "secActivityEndTime", "secActivityServerTime", "packageSale", "activityGroupId", "cashRebate", "campaignSubType", "orderStatus", "joinedCouponIdsStr", "findSameGoodsUrl", "JoinMemberType", "commonSchema", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/bytedance/android/ec/model/ECAdLogExtra;Lcom/bytedance/android/ec/model/ECBoltParam;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;ZZZJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZJJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getJoinMemberType", "()Ljava/lang/String;", "getActivityGroupId", "getAdLogExtra", "()Lcom/bytedance/android/ec/model/ECAdLogExtra;", "setAdLogExtra", "(Lcom/bytedance/android/ec/model/ECAdLogExtra;)V", "getApplyCoupon", "()I", "setApplyCoupon", "(I)V", "getAuthorId", "setAuthorId", "(Ljava/lang/String;)V", "getBaseVerifiedCategory", "setBaseVerifiedCategory", "getBoltParam", "()Lcom/bytedance/android/ec/model/ECBoltParam;", "setBoltParam", "(Lcom/bytedance/android/ec/model/ECBoltParam;)V", "getBrandVerified", "setBrandVerified", "getCampaignSubType", "getCardStatus", "setCardStatus", "getCashRebate", "getChannelId", "setChannelId", "getChannelType", "()Ljava/lang/Integer;", "setChannelType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getCommonSchema", "getCustomBuyOrderUrl", "getCustomBuyOrderUrlV2", "getEComEntranceFrom", "setEComEntranceFrom", "getEnterMethod", "setEnterMethod", "getEntranceInfo", "setEntranceInfo", "getFindSameGoodsUrl", "getFollowStatus", "setFollowStatus", "getFromLive", "()Z", "setFromLive", "(Z)V", "getFromVideo", "setFromVideo", "getGoodTitle", "getGoodTitleTags", "getGoodsType", "setGoodsType", "getGroupBuyOrderUrl", "getGroupBuyOrderUrlV2", "getHasReplay", "setHasReplay", "getHasSecActivity", "getIcon", "setIcon", "setAuthenticInsure", "setCrossBorderProduct", "setVirtual", "getItemId", "setItemId", "getJoinMemberUrl", "getJoinedCouponIdsStr", "getLabelName", "setLabelName", "getLabelNameLive", "setLabelNameLive", "getLiveRoomId", "setLiveRoomId", "getLogData", "setLogData", "getLynxUrl", "getMarketingChannel", "setMarketingChannel", "getMetaParam", "setMetaParam", "getOpenAppUrl", "getOrderStatus", "getOrderUrl", "getOrderUrlV2", "getPackageSale", "getPassThroughEventData", "setPassThroughEventData", "getProductId", "setProductId", "getProductMinPrice", "()J", "getPromotionId", "setPromotionId", "getPromotionSource", "setPromotionSource", "(J)V", "getRecommendInfo", "getRequestAdditions", "setRequestAdditions", "getSecActivityBeginTime", "getSecActivityEndTime", "getSecActivityServerTime", "getSecAuthorId", "setSecAuthorId", "getShopCover", "getShopId", "setShopId", "getShopName", "getSmallAppUrl", "getSourcePage", "setSourcePage", "getSubTitleTextColor", "getSubtitle", "getThirdParty", "setThirdParty", "getToast", "getTransmissibleJson", "setTransmissibleJson", "getUseNativeBuy", "getUseNewOrderSchema", "getV3EventsAdditions", "setV3EventsAdditions", "chooseTheRightOrderUrl", "isGroupBuying", "isCustomBuying", "chooseTheRightOrderUrlV2", "fillCommonMeta", "commonMeta", "Lcom/bytedance/android/shopping/anchorv4/dto/meta/CommonMeta;", "secKillActivityOnGoing", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BuyMeta implements Serializable {

    @SerializedName("join_member_type")
    private final String JoinMemberType;

    @SerializedName("activity_group_id")
    private final String activityGroupId;
    private ECAdLogExtra adLogExtra;
    private int applyCoupon;
    private String authorId;
    private String baseVerifiedCategory;
    private ECBoltParam boltParam;
    private String brandVerified;

    @SerializedName("campaign_sub_type")
    private final String campaignSubType;
    private String cardStatus;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_CASH_REBATE)
    private final String cashRebate;
    private String channelId;
    private Integer channelType;

    @SerializedName("common_schema")
    private final String commonSchema;

    @SerializedName("custom_buy_order_url")
    private final String customBuyOrderUrl;

    @SerializedName("custom_buy_order_url_v2")
    private final String customBuyOrderUrlV2;
    private String eComEntranceFrom;
    private String enterMethod;
    private String entranceInfo;

    @SerializedName("find_same_goods_url")
    private final String findSameGoodsUrl;
    private int followStatus;
    private boolean fromLive;
    private boolean fromVideo;

    @SerializedName("good_title")
    private final String goodTitle;

    @SerializedName("good_title_tags")
    private final String goodTitleTags;
    private String goodsType;

    @SerializedName("group_buy_order_url")
    private final String groupBuyOrderUrl;

    @SerializedName("group_buy_order_url_v2")
    private final String groupBuyOrderUrlV2;
    private String hasReplay;

    @SerializedName("has_sec_activity")
    private final boolean hasSecActivity;

    @SerializedName("icon")
    private String icon;

    @SerializedName("is_auction_product")
    private final boolean isAuctionProduct;
    private String isAuthenticInsure;
    private boolean isCrossBorderProduct;

    @SerializedName("is_deposit_pre_sale_product")
    private final boolean isDepositPreSaleProduct;

    @SerializedName("is_insurance_product")
    private final boolean isInsuranceProduct;

    @SerializedName("is_member_sample_product")
    private final boolean isMemberSampleProduct;

    @SerializedName("is_scarce_buy_product")
    private final boolean isScarceBuyProduct;
    private boolean isVirtual;
    private String itemId;

    @SerializedName("join_member_url")
    private final String joinMemberUrl;

    @SerializedName("joined_coupon_ids")
    private final String joinedCouponIdsStr;
    private String labelName;
    private String labelNameLive;
    private String liveRoomId;
    private String logData;

    @SerializedName(SendClosePdpEventParam.KEY_LYNX_URL)
    private final String lynxUrl;
    private String marketingChannel;
    private String metaParam;

    @SerializedName(PdpOpenThirdParam.KEY_OPEN_APP_URL)
    private final String openAppUrl;

    @SerializedName(EventConstants.ExtraJson.KEY_ORDER_STATUS)
    private final int orderStatus;

    @SerializedName("order_url")
    private final String orderUrl;

    @SerializedName("order_url_v2")
    private final String orderUrlV2;

    @SerializedName("package_sale")
    private final String packageSale;
    private String passThroughEventData;
    private String productId;

    @SerializedName("product_min_price")
    private final long productMinPrice;
    private String promotionId;
    private long promotionSource;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO)
    private final String recommendInfo;
    private String requestAdditions;

    @SerializedName("sec_activity_begin_time")
    private final long secActivityBeginTime;

    @SerializedName("sec_activity_end_time")
    private final long secActivityEndTime;

    @SerializedName("sec_activity_server_time")
    private final long secActivityServerTime;
    private String secAuthorId;

    @SerializedName("shop_cover")
    private final String shopCover;
    private String shopId;

    @SerializedName("shop_name")
    private final String shopName;

    @SerializedName("small_app_url")
    private final String smallAppUrl;
    private String sourcePage;

    @SerializedName("sub_title_text_color")
    private final String subTitleTextColor;

    @SerializedName(BdpAppEventConstant.PARAMS_SUB_TITLE)
    private final String subtitle;
    private boolean thirdParty;

    @SerializedName("toast")
    private final String toast;
    private String transmissibleJson;

    @SerializedName("use_native_buy")
    private final boolean useNativeBuy;

    @SerializedName("use_new_order_schema")
    private final boolean useNewOrderSchema;
    private String v3EventsAdditions;

    public BuyMeta() {
        this(null, null, null, null, null, null, null, null, null, null, null, 0, null, 0, null, null, null, null, null, null, false, false, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, false, false, 0, null, null, null, null, null, null, null, false, false, false, false, false, false, false, null, null, null, null, null, null, null, null, null, null, null, null, false, 0, 0, 0, null, null, null, null, 0, null, null, null, null, -1, -1, 16383, null);
    }

    public final boolean secKillActivityOnGoing() {
        long r100 = SystemClock.elapsedRealtime() / 1000;
        long r101 = this.secActivityBeginTime + 1;
        long r102 = this.secActivityEndTime;
        if (r101 <= r100) goto L6;
    L8:
        boolean r103 = false;
    L9:
        if (r103 == true) goto L11;
    L13:
        return false;
    L11:
        if (this.hasSecActivity == false) goto L13;
        return true;
    L6:
        if (r102 <= r100) goto L8;
        r103 = true;
        goto L9
    }

    public final String getActivityGroupId() {
        return this.activityGroupId;
    }

    public final ECAdLogExtra getAdLogExtra() {
        return this.adLogExtra;
    }

    public final int getApplyCoupon() {
        return this.applyCoupon;
    }

    public final String getAuthorId() {
        return this.authorId;
    }

    public final String getBaseVerifiedCategory() {
        return this.baseVerifiedCategory;
    }

    public final ECBoltParam getBoltParam() {
        return this.boltParam;
    }

    public final String getBrandVerified() {
        return this.brandVerified;
    }

    public final String getCampaignSubType() {
        return this.campaignSubType;
    }

    public final String getCardStatus() {
        return this.cardStatus;
    }

    public final String getCashRebate() {
        return this.cashRebate;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final Integer getChannelType() {
        return this.channelType;
    }

    public final String getCommonSchema() {
        return this.commonSchema;
    }

    public final String getCustomBuyOrderUrl() {
        return this.customBuyOrderUrl;
    }

    public final String getCustomBuyOrderUrlV2() {
        return this.customBuyOrderUrlV2;
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

    public final String getFindSameGoodsUrl() {
        return this.findSameGoodsUrl;
    }

    public final int getFollowStatus() {
        return this.followStatus;
    }

    public final boolean getFromLive() {
        return this.fromLive;
    }

    public final boolean getFromVideo() {
        return this.fromVideo;
    }

    public final String getGoodTitle() {
        return this.goodTitle;
    }

    public final String getGoodTitleTags() {
        return this.goodTitleTags;
    }

    public final String getGoodsType() {
        return this.goodsType;
    }

    public final String getGroupBuyOrderUrl() {
        return this.groupBuyOrderUrl;
    }

    public final String getGroupBuyOrderUrlV2() {
        return this.groupBuyOrderUrlV2;
    }

    public final String getHasReplay() {
        return this.hasReplay;
    }

    public final boolean getHasSecActivity() {
        return this.hasSecActivity;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final String getJoinMemberType() {
        return this.JoinMemberType;
    }

    public final String getJoinMemberUrl() {
        return this.joinMemberUrl;
    }

    public final String getJoinedCouponIdsStr() {
        return this.joinedCouponIdsStr;
    }

    public final String getLabelName() {
        return this.labelName;
    }

    public final String getLabelNameLive() {
        return this.labelNameLive;
    }

    public final String getLiveRoomId() {
        return this.liveRoomId;
    }

    public final String getLogData() {
        return this.logData;
    }

    public final String getLynxUrl() {
        return this.lynxUrl;
    }

    public final String getMarketingChannel() {
        return this.marketingChannel;
    }

    public final String getMetaParam() {
        return this.metaParam;
    }

    public final String getOpenAppUrl() {
        return this.openAppUrl;
    }

    public final int getOrderStatus() {
        return this.orderStatus;
    }

    public final String getOrderUrl() {
        return this.orderUrl;
    }

    public final String getOrderUrlV2() {
        return this.orderUrlV2;
    }

    public final String getPackageSale() {
        return this.packageSale;
    }

    public final String getPassThroughEventData() {
        return this.passThroughEventData;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final long getProductMinPrice() {
        return this.productMinPrice;
    }

    public final String getPromotionId() {
        return this.promotionId;
    }

    public final long getPromotionSource() {
        return this.promotionSource;
    }

    public final String getRecommendInfo() {
        return this.recommendInfo;
    }

    public final String getRequestAdditions() {
        return this.requestAdditions;
    }

    public final long getSecActivityBeginTime() {
        return this.secActivityBeginTime;
    }

    public final long getSecActivityEndTime() {
        return this.secActivityEndTime;
    }

    public final long getSecActivityServerTime() {
        return this.secActivityServerTime;
    }

    public final String getSecAuthorId() {
        return this.secAuthorId;
    }

    public final String getShopCover() {
        return this.shopCover;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final String getShopName() {
        return this.shopName;
    }

    public final String getSmallAppUrl() {
        return this.smallAppUrl;
    }

    public final String getSourcePage() {
        return this.sourcePage;
    }

    public final String getSubTitleTextColor() {
        return this.subTitleTextColor;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final boolean getThirdParty() {
        return this.thirdParty;
    }

    public final String getToast() {
        return this.toast;
    }

    public final String getTransmissibleJson() {
        return this.transmissibleJson;
    }

    public final boolean getUseNativeBuy() {
        return this.useNativeBuy;
    }

    public final boolean getUseNewOrderSchema() {
        return this.useNewOrderSchema;
    }

    public final String getV3EventsAdditions() {
        return this.v3EventsAdditions;
    }

    public final boolean isAuctionProduct() {
        return this.isAuctionProduct;
    }

    public final String isAuthenticInsure() {
        return this.isAuthenticInsure;
    }

    public final boolean isCrossBorderProduct() {
        return this.isCrossBorderProduct;
    }

    public final boolean isDepositPreSaleProduct() {
        return this.isDepositPreSaleProduct;
    }

    public final boolean isInsuranceProduct() {
        return this.isInsuranceProduct;
    }

    public final boolean isMemberSampleProduct() {
        return this.isMemberSampleProduct;
    }

    public final boolean isScarceBuyProduct() {
        return this.isScarceBuyProduct;
    }

    public final boolean isVirtual() {
        return this.isVirtual;
    }

    public final BuyMeta fillCommonMeta(CommonMeta r100) {
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.getV3EventsAdditions();
    L6:
        this.v3EventsAdditions = r102;
        if (r100 == null) goto L9;
        String r103 = r100.getLabelName();
    L10:
        this.labelName = r103;
        if (r100 == null) goto L13;
        String r104 = r100.getBrandVerified();
    L14:
        this.brandVerified = r104;
        if (r100 == null) goto L17;
        String r105 = r100.getTransmissibleJson();
    L18:
        this.transmissibleJson = r105;
        if (r100 == null) goto L21;
        String r106 = r100.getRequestAdditions();
    L22:
        this.requestAdditions = r106;
        if (r100 == null) goto L25;
        String r107 = r100.getSourcePage();
    L26:
        this.sourcePage = r107;
        if (r100 == null) goto L29;
        String r108 = r100.getEnterMethod();
    L30:
        this.enterMethod = r108;
        if (r100 == null) goto L33;
        String r109 = r100.getEntranceInfo();
    L34:
        this.entranceInfo = r109;
        if (r100 == null) goto L37;
        String r110 = r100.getEComEntranceForm();
    L38:
        this.eComEntranceFrom = r110;
        if (r100 == null) goto L41;
        String r111 = r100.getTransitionTrackerData();
    L42:
        this.passThroughEventData = r111;
        if (r100 == null) goto L45;
        String r112 = r100.getMetaParam();
    L46:
        this.metaParam = r112;
        if (r100 == null) goto L49;
        Boolean r113 = Boolean.valueOf(r100.getThirdParty());
    L50:
        this.thirdParty = com.bytedance.android.shopping.extensions.k.i(r113);
        if (r100 == null) goto L53;
        Boolean r114 = Boolean.valueOf(r100.isVirtual());
    L54:
        this.isVirtual = com.bytedance.android.shopping.extensions.k.i(r114);
        if (r100 == null) goto L57;
        String r115 = r100.getProductId();
    L58:
        this.productId = r115;
        if (r100 == null) goto L61;
        String r116 = r100.getPromotionId();
    L62:
        this.promotionId = r116;
        if (r100 == null) goto L65;
        Long r117 = Long.valueOf(r100.getPromotionSource());
    L66:
        this.promotionSource = com.bytedance.android.shopping.extensions.k.h(r117);
        if (r100 == null) goto L69;
        String r118 = r100.getShopId();
    L70:
        this.shopId = r118;
        if (r100 == null) goto L73;
        Integer r119 = Integer.valueOf(r100.getApplyCoupon());
    L74:
        this.applyCoupon = com.bytedance.android.shopping.extensions.k.f(r119);
        if (r100 == null) goto L77;
        String r120 = r100.getBaseVerifiedCategory();
    L78:
        this.baseVerifiedCategory = r120;
        if (r100 == null) goto L81;
        String r121 = r100.getCardStatus();
    L82:
        this.cardStatus = r121;
        if (r100 == null) goto L85;
        Boolean r122 = Boolean.valueOf(r100.isCrossBorderProduct());
    L86:
        this.isCrossBorderProduct = com.bytedance.android.shopping.extensions.k.i(r122);
        if (r100 == null) goto L89;
        String r123 = r100.isAuthenticInsure();
    L90:
        String r124 = "";
        if (r123 != null) goto L93;
        r123 = "";
    L93:
        this.isAuthenticInsure = r123;
        if (r100 == null) goto L96;
        String r125 = r100.getLiveRoomId();
    L97:
        if (r125 == null) goto L100;
        r124 = r125;
    L100:
        this.liveRoomId = r124;
        if (r100 == null) goto L103;
        Boolean r126 = Boolean.valueOf(r100.getFromLive());
    L104:
        this.fromLive = com.bytedance.android.shopping.extensions.k.i(r126);
        if (r100 == null) goto L107;
        Boolean r127 = Boolean.valueOf(r100.getFromVideo());
    L108:
        this.fromVideo = com.bytedance.android.shopping.extensions.k.i(r127);
        if (r100 == null) goto L111;
        String r128 = r100.getAuthorId();
    L112:
        this.authorId = r128;
        if (r100 == null) goto L115;
        String r129 = r100.getSecAuthorId();
    L116:
        this.secAuthorId = r129;
        if (r100 == null) goto L119;
        String r130 = r100.getItemId();
    L120:
        this.itemId = r130;
        if (r100 == null) goto L123;
        Integer r131 = Integer.valueOf(r100.getFollowStatus());
    L124:
        this.followStatus = com.bytedance.android.shopping.extensions.k.f(r131);
        if (r100 == null) goto L127;
        ECAdLogExtra r132 = r100.getAdLogExtra();
    L128:
        this.adLogExtra = r132;
        if (r100 == null) goto L131;
        ECBoltParam r133 = r100.getBoltParam();
    L132:
        this.boltParam = r133;
        if (r100 == null) goto L135;
        String r134 = r100.getLabelNameLive();
    L136:
        this.labelNameLive = r134;
        if (r100 == null) goto L139;
        String r135 = r100.getMarketingChannel();
    L140:
        this.marketingChannel = r135;
        if (r100 == null) goto L143;
        String r136 = r100.getHasReplay();
    L144:
        this.hasReplay = com.bytedance.android.shopping.extensions.k.j(r136);
        if (r100 == null) goto L147;
        String r137 = r100.getChannelId();
    L148:
        this.channelId = r137;
        if (r100 == null) goto L151;
        Integer r138 = r100.getChannelType();
    L152:
        this.channelType = r138;
        if (r100 == null) goto L155;
        r101 = r100.getLogData();
    L155:
        this.logData = r101;
        return this;
    L151:
        r138 = null;
        goto L152
    L147:
        r137 = null;
        goto L148
    L143:
        r136 = null;
        goto L144
    L139:
        r135 = null;
        goto L140
    L135:
        r134 = null;
        goto L136
    L131:
        r133 = null;
        goto L132
    L127:
        r132 = null;
        goto L128
    L123:
        r131 = null;
        goto L124
    L119:
        r130 = null;
        goto L120
    L115:
        r129 = null;
        goto L116
    L111:
        r128 = null;
        goto L112
    L107:
        r127 = null;
        goto L108
    L103:
        r126 = null;
        goto L104
    L96:
        r125 = null;
        goto L97
    L89:
        r123 = null;
        goto L90
    L85:
        r122 = null;
        goto L86
    L81:
        r121 = null;
        goto L82
    L77:
        r120 = null;
        goto L78
    L73:
        r119 = null;
        goto L74
    L69:
        r118 = null;
        goto L70
    L65:
        r117 = null;
        goto L66
    L61:
        r116 = null;
        goto L62
    L57:
        r115 = null;
        goto L58
    L53:
        r114 = null;
        goto L54
    L49:
        r113 = null;
        goto L50
    L45:
        r112 = null;
        goto L46
    L41:
        r111 = null;
        goto L42
    L37:
        r110 = null;
        goto L38
    L33:
        r109 = null;
        goto L34
    L29:
        r108 = null;
        goto L30
    L25:
        r107 = null;
        goto L26
    L21:
        r106 = null;
        goto L22
    L17:
        r105 = null;
        goto L18
    L13:
        r104 = null;
        goto L14
    L9:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public final void setAdLogExtra(ECAdLogExtra r100) {
        this.adLogExtra = r100;
    }

    public final void setApplyCoupon(int r100) {
        this.applyCoupon = r100;
    }

    public final void setAuthenticInsure(String r100) {
        this.isAuthenticInsure = r100;
    }

    public final void setAuthorId(String r100) {
        this.authorId = r100;
    }

    public final void setBaseVerifiedCategory(String r100) {
        this.baseVerifiedCategory = r100;
    }

    public final void setBoltParam(ECBoltParam r100) {
        this.boltParam = r100;
    }

    public final void setBrandVerified(String r100) {
        this.brandVerified = r100;
    }

    public final void setCardStatus(String r100) {
        this.cardStatus = r100;
    }

    public final void setChannelId(String r100) {
        this.channelId = r100;
    }

    public final void setChannelType(Integer r100) {
        this.channelType = r100;
    }

    public final void setCrossBorderProduct(boolean r100) {
        this.isCrossBorderProduct = r100;
    }

    public final void setEComEntranceFrom(String r100) {
        this.eComEntranceFrom = r100;
    }

    public final void setEnterMethod(String r100) {
        this.enterMethod = r100;
    }

    public final void setEntranceInfo(String r100) {
        this.entranceInfo = r100;
    }

    public final void setFollowStatus(int r100) {
        this.followStatus = r100;
    }

    public final void setFromLive(boolean r100) {
        this.fromLive = r100;
    }

    public final void setFromVideo(boolean r100) {
        this.fromVideo = r100;
    }

    public final void setGoodsType(String r100) {
        this.goodsType = r100;
    }

    public final void setHasReplay(String r100) {
        this.hasReplay = r100;
    }

    public final void setIcon(String r100) {
        this.icon = r100;
    }

    public final void setItemId(String r100) {
        this.itemId = r100;
    }

    public final void setLabelName(String r100) {
        this.labelName = r100;
    }

    public final void setLabelNameLive(String r100) {
        this.labelNameLive = r100;
    }

    public final void setLiveRoomId(String r100) {
        this.liveRoomId = r100;
    }

    public final void setLogData(String r100) {
        this.logData = r100;
    }

    public final void setMarketingChannel(String r100) {
        this.marketingChannel = r100;
    }

    public final void setMetaParam(String r100) {
        this.metaParam = r100;
    }

    public final void setPassThroughEventData(String r100) {
        this.passThroughEventData = r100;
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

    public final void setRequestAdditions(String r100) {
        this.requestAdditions = r100;
    }

    public final void setSecAuthorId(String r100) {
        this.secAuthorId = r100;
    }

    public final void setShopId(String r100) {
        this.shopId = r100;
    }

    public final void setSourcePage(String r100) {
        this.sourcePage = r100;
    }

    public final void setThirdParty(boolean r100) {
        this.thirdParty = r100;
    }

    public final void setTransmissibleJson(String r100) {
        this.transmissibleJson = r100;
    }

    public final void setV3EventsAdditions(String r100) {
        this.v3EventsAdditions = r100;
    }

    public final void setVirtual(boolean r100) {
        this.isVirtual = r100;
    }

    public final String chooseTheRightOrderUrl(boolean r100, boolean r101) {
        if (r101 == true) goto L8;
        if (r100 == false) goto L7;
        return this.groupBuyOrderUrl;
    L7:
        return this.orderUrl;
    L8:
        return this.customBuyOrderUrl;
    }

    public final String chooseTheRightOrderUrlV2(boolean r100, boolean r101) {
        if (r101 == true) goto L8;
        if (r100 == false) goto L7;
        return this.groupBuyOrderUrlV2;
    L7:
        return this.orderUrlV2;
    L8:
        return this.customBuyOrderUrlV2;
    }

    public BuyMeta(String r100, String r101, String r102, String r103, String r104, String r105, String r110, String r111, String r112, String r113, String r114, long r115, String r116, int r117, String r118, String r210, String r211, String r212, String r213, String r214, boolean r215, boolean r216, String r217, String r218, String r219, int r310, ECAdLogExtra r311, ECBoltParam r312, String r313, String r314, String r315, String r316, Integer r317, String r318, String r319, boolean r410, boolean r411, boolean r412, long r413, String r414, String r415, String r416, String r417, String r418, String r510, String r511, boolean r512, boolean r513, boolean r514, boolean r515, boolean r516, boolean r517, boolean r518, String r519, String r610, String r611, String r612, String r613, String r614, String r615, String r616, String r617, String r618, String r619, String r710, boolean r711, long r712, long r713, long r714, String r715, String r716, String r810, String r811, int r812, String r813, String r814, String r815, String r816) {
        this.transmissibleJson = r100;
        this.v3EventsAdditions = r101;
        this.requestAdditions = r102;
        this.sourcePage = r103;
        this.enterMethod = r104;
        this.entranceInfo = r105;
        this.passThroughEventData = r110;
        this.eComEntranceFrom = r111;
        this.metaParam = r112;
        this.productId = r113;
        this.promotionId = r114;
        this.promotionSource = r115;
        this.shopId = r116;
        this.applyCoupon = r117;
        this.baseVerifiedCategory = r118;
        this.cardStatus = r210;
        this.brandVerified = r211;
        this.hasReplay = r212;
        this.goodsType = r213;
        this.liveRoomId = r214;
        this.fromLive = r215;
        this.fromVideo = r216;
        this.authorId = r217;
        this.secAuthorId = r218;
        this.itemId = r219;
        this.followStatus = r310;
        this.adLogExtra = r311;
        this.boltParam = r312;
        this.labelNameLive = r313;
        this.labelName = r314;
        this.marketingChannel = r315;
        this.channelId = r316;
        this.channelType = r317;
        this.logData = r318;
        this.isAuthenticInsure = r319;
        this.isCrossBorderProduct = r410;
        this.thirdParty = r411;
        this.isVirtual = r412;
        this.productMinPrice = r413;
        this.shopName = r414;
        this.shopCover = r415;
        this.goodTitle = r416;
        this.goodTitleTags = r417;
        this.subtitle = r418;
        this.icon = r510;
        this.subTitleTextColor = r511;
        this.isDepositPreSaleProduct = r512;
        this.useNewOrderSchema = r513;
        this.isInsuranceProduct = r514;
        this.isAuctionProduct = r515;
        this.isScarceBuyProduct = r516;
        this.isMemberSampleProduct = r517;
        this.useNativeBuy = r518;
        this.recommendInfo = r519;
        this.smallAppUrl = r610;
        this.openAppUrl = r611;
        this.lynxUrl = r612;
        this.toast = r613;
        this.orderUrl = r614;
        this.groupBuyOrderUrl = r615;
        this.customBuyOrderUrl = r616;
        this.orderUrlV2 = r617;
        this.groupBuyOrderUrlV2 = r618;
        this.customBuyOrderUrlV2 = r619;
        this.joinMemberUrl = r710;
        this.hasSecActivity = r711;
        this.secActivityBeginTime = r712;
        this.secActivityEndTime = r713;
        this.secActivityServerTime = r714;
        this.packageSale = r715;
        this.activityGroupId = r716;
        this.cashRebate = r810;
        this.campaignSubType = r811;
        this.orderStatus = r812;
        this.joinedCouponIdsStr = r813;
        this.findSameGoodsUrl = r814;
        this.JoinMemberType = r815;
        this.commonSchema = r816;
    }

    public /* synthetic */ BuyMeta(String r810, String r811, String r812, String r813, String r814, String r815, String r816, String r817, String r910, String r911, String r912, long r913, String r914, int r915, String r916, String r917, String r918, String r100, String r101, String r102, boolean r103, boolean r104, String r105, String r106, String r107, int r108, ECAdLogExtra r109, ECBoltParam r110, String r111, String r112, String r113, String r114, Integer r115, String r116, String r117, boolean r118, boolean r119, boolean r120, long r121, String r123, String r124, String r125, String r126, String r127, String r128, String r129, boolean r130, boolean r131, boolean r132, boolean r133, boolean r134, boolean r135, boolean r136, String r137, String r138, String r139, String r140, String r141, String r142, String r143, String r144, String r145, String r146, String r147, String r148, boolean r149, long r150, long r152, long r154, String r156, String r157, String r158, String r159, int r160, String r161, String r162, String r163, String r164, int r165, int r166, int r167, DefaultConstructorMarker r168) {
        if ((r165 & 1) == 0) goto L5;
        String r122 = null;
    L7:
        if ((r165 & 2) == 0) goto L9;
        String r151 = null;
    L11:
        if ((r165 & 4) == 0) goto L13;
        String r153 = null;
    L15:
        if ((r165 & 8) == 0) goto L17;
        String r155 = null;
    L19:
        if ((r165 & 16) == 0) goto L21;
        String r169 = null;
    L23:
        if ((r165 & 32) == 0) goto L25;
        String r170 = null;
    L27:
        if ((r165 & 64) == 0) goto L29;
        String r171 = null;
    L31:
        if ((r165 & 128) == 0) goto L33;
        String r172 = null;
    L35:
        if ((r165 & 256) == 0) goto L37;
        String r173 = null;
    L39:
        if ((r165 & 512) == 0) goto L41;
        String r174 = null;
    L43:
        if ((r165 & 1024) == 0) goto L45;
        String r175 = null;
    L46:
        long r176 = 0;
        if ((r165 & 2048) == 0) goto L49;
        long r177 = 0;
    L51:
        if ((r165 & 4096) == 0) goto L53;
        String r178 = null;
    L54:
        int r210 = 0;
        if ((r165 & 8192) == 0) goto L57;
        int r179 = 0;
    L58:
        int r211 = r179;
        if ((r165 & 16384) == 0) goto L61;
        String r180 = null;
    L63:
        if ((r165 & 32768) == 0) goto L65;
        String r212 = null;
    L67:
        if ((r165 & 65536) == 0) goto L69;
        String r213 = null;
    L71:
        if ((r165 & 131072) == 0) goto L73;
        String r214 = null;
    L75:
        if ((r165 & 262144) == 0) goto L77;
        String r215 = null;
    L79:
        if ((r165 & 524288) == 0) goto L81;
        String r310 = null;
    L83:
        if ((r165 & 1048576) == 0) goto L85;
        boolean r311 = false;
    L87:
        if ((r165 & 2097152) == 0) goto L89;
        boolean r312 = false;
    L91:
        if ((r165 & 4194304) == 0) goto L93;
        String r313 = null;
    L95:
        if ((r165 & 8388608) == 0) goto L97;
        String r314 = null;
    L99:
        if ((r165 & 16777216) == 0) goto L101;
        String r315 = null;
    L103:
        if ((r165 & 33554432) == 0) goto L105;
        int r316 = 0;
    L107:
        if ((r165 & 67108864) == 0) goto L109;
        ECAdLogExtra r317 = null;
    L111:
        if ((r165 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        ECBoltParam r318 = null;
    L115:
        if ((r165 & 268435456) == 0) goto L117;
        String r319 = null;
    L119:
        if ((r165 & 536870912) == 0) goto L121;
        String r410 = null;
    L123:
        if ((r165 & 1073741824) == 0) goto L125;
        String r411 = null;
    L127:
        if ((r165 & Integer.MIN_VALUE) == 0) goto L129;
        String r181 = null;
    L131:
        if ((r166 & 1) == 0) goto L133;
        Integer r412 = null;
    L135:
        if ((r166 & 2) == 0) goto L137;
        String r413 = null;
    L139:
        if ((r166 & 4) == 0) goto L141;
        String r414 = null;
    L143:
        if ((r166 & 8) == 0) goto L145;
        boolean r415 = false;
    L147:
        if ((r166 & 16) == 0) goto L149;
        boolean r416 = false;
    L151:
        if ((r166 & 32) == 0) goto L153;
        boolean r417 = false;
    L155:
        if ((r166 & 64) == 0) goto L157;
        long r418 = 0;
    L158:
        String r1610 = r181;
        if ((r166 & 128) == 0) goto L161;
        String r182 = null;
    L162:
        String r510 = r182;
        if ((r166 & 256) == 0) goto L165;
        String r183 = null;
    L166:
        String r511 = r183;
        if ((r166 & 512) == 0) goto L169;
        String r184 = null;
    L170:
        String r512 = r184;
        if ((r166 & 1024) == 0) goto L173;
        String r185 = null;
    L174:
        String r513 = r185;
        if ((r166 & 2048) == 0) goto L177;
        String r186 = null;
    L178:
        String r514 = r186;
        if ((r166 & 4096) == 0) goto L181;
        String r187 = null;
    L182:
        String r515 = r187;
        if ((r166 & 8192) == 0) goto L185;
        String r188 = null;
    L186:
        String r516 = r188;
        if ((r166 & 16384) == 0) goto L189;
        boolean r189 = false;
    L191:
        if ((r166 & 32768) == 0) goto L193;
        boolean r216 = false;
    L195:
        if ((r166 & 65536) == 0) goto L197;
        boolean r217 = false;
    L199:
        if ((r166 & 131072) == 0) goto L201;
        boolean r218 = false;
    L203:
        if ((r166 & 262144) == 0) goto L205;
        boolean r219 = false;
    L207:
        if ((r166 & 524288) == 0) goto L209;
        boolean r517 = false;
    L211:
        if ((r166 & 1048576) == 0) goto L213;
        boolean r518 = false;
    L215:
        if ((r166 & 2097152) == 0) goto L217;
        String r519 = null;
    L219:
        if ((r166 & 4194304) == 0) goto L221;
        String r610 = null;
    L223:
        if ((r166 & 8388608) == 0) goto L225;
        String r611 = null;
    L227:
        if ((r166 & 16777216) == 0) goto L229;
        String r612 = null;
    L231:
        if ((r166 & 33554432) == 0) goto L233;
        String r613 = null;
    L235:
        if ((r166 & 67108864) == 0) goto L237;
        String r614 = null;
    L239:
        if ((r166 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L241;
        String r615 = null;
    L243:
        if ((r166 & 268435456) == 0) goto L245;
        String r616 = null;
    L247:
        if ((r166 & 536870912) == 0) goto L249;
        String r617 = null;
    L251:
        if ((r166 & 1073741824) == 0) goto L253;
        String r618 = null;
    L255:
        if ((r166 & Integer.MIN_VALUE) == 0) goto L257;
        String r190 = null;
    L259:
        if ((r167 & 1) == 0) goto L261;
        String r619 = null;
    L263:
        if ((r167 & 2) == 0) goto L265;
        boolean r710 = false;
    L267:
        if ((r167 & 4) == 0) goto L269;
        long r711 = 0;
    L271:
        if ((r167 & 8) == 0) goto L273;
        long r712 = 0;
    L275:
        if ((r167 & 16) != 0) goto L279;
        r176 = r154;
    L279:
        if ((r167 & 32) == 0) goto L281;
        String r713 = null;
    L283:
        if ((r167 & 64) == 0) goto L285;
        String r714 = null;
    L286:
        String r1611 = r190;
        if ((r167 & 128) == 0) goto L289;
        String r191 = null;
    L290:
        String r715 = r191;
        if ((r167 & 256) == 0) goto L293;
        String r192 = null;
    L294:
        String r716 = r192;
        if ((r167 & 512) != 0) goto L299;
        r210 = r160;
    L299:
        if ((r167 & 1024) == 0) goto L301;
        String r193 = null;
    L302:
        String r717 = r193;
        if ((r167 & 2048) == 0) goto L305;
        String r194 = null;
    L306:
        String r818 = r194;
        if ((r167 & 4096) == 0) goto L309;
        String r195 = null;
    L311:
        if ((r167 & 8192) == 0) goto L313;
        String r196 = null;
    L314:
        this(r122, r151, r153, r155, r169, r170, r171, r172, r173, r174, r175, r177, r178, r211, r180, r212, r213, r214, r215, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r1610, r412, r413, r414, r415, r416, r417, r418, r510, r511, r512, r513, r514, r515, r516, r189, r216, r217, r218, r219, r517, r518, r519, r610, r611, r612, r613, r614, r615, r616, r617, r618, r1611, r619, r710, r711, r712, r176, r713, r714, r715, r716, r210, r717, r818, r195, r196);
        return;
    L313:
        r196 = r164;
        goto L314
    L309:
        r195 = r163;
        goto L311
    L305:
        r194 = r162;
        goto L306
    L301:
        r193 = r161;
        goto L302
    L293:
        r192 = r159;
        goto L294
    L289:
        r191 = r158;
        goto L290
    L285:
        r714 = r157;
        goto L286
    L281:
        r713 = r156;
        goto L283
    L273:
        r712 = r152;
        goto L275
    L269:
        r711 = r150;
        goto L271
    L265:
        r710 = r149;
        goto L267
    L261:
        r619 = r148;
        goto L263
    L257:
        r190 = r147;
        goto L259
    L253:
        r618 = r146;
        goto L255
    L249:
        r617 = r145;
        goto L251
    L245:
        r616 = r144;
        goto L247
    L241:
        r615 = r143;
        goto L243
    L237:
        r614 = r142;
        goto L239
    L233:
        r613 = r141;
        goto L235
    L229:
        r612 = r140;
        goto L231
    L225:
        r611 = r139;
        goto L227
    L221:
        r610 = r138;
        goto L223
    L217:
        r519 = r137;
        goto L219
    L213:
        r518 = r136;
        goto L215
    L209:
        r517 = r135;
        goto L211
    L205:
        r219 = r134;
        goto L207
    L201:
        r218 = r133;
        goto L203
    L197:
        r217 = r132;
        goto L199
    L193:
        r216 = r131;
        goto L195
    L189:
        r189 = r130;
        goto L191
    L185:
        r188 = r129;
        goto L186
    L181:
        r187 = r128;
        goto L182
    L177:
        r186 = r127;
        goto L178
    L173:
        r185 = r126;
        goto L174
    L169:
        r184 = r125;
        goto L170
    L165:
        r183 = r124;
        goto L166
    L161:
        r182 = r123;
        goto L162
    L157:
        r418 = r121;
        goto L158
    L153:
        r417 = r120;
        goto L155
    L149:
        r416 = r119;
        goto L151
    L145:
        r415 = r118;
        goto L147
    L141:
        r414 = r117;
        goto L143
    L137:
        r413 = r116;
        goto L139
    L133:
        r412 = r115;
        goto L135
    L129:
        r181 = r114;
        goto L131
    L125:
        r411 = r113;
        goto L127
    L121:
        r410 = r112;
        goto L123
    L117:
        r319 = r111;
        goto L119
    L113:
        r318 = r110;
        goto L115
    L109:
        r317 = r109;
        goto L111
    L105:
        r316 = r108;
        goto L107
    L101:
        r315 = r107;
        goto L103
    L97:
        r314 = r106;
        goto L99
    L93:
        r313 = r105;
        goto L95
    L89:
        r312 = r104;
        goto L91
    L85:
        r311 = r103;
        goto L87
    L81:
        r310 = r102;
        goto L83
    L77:
        r215 = r101;
        goto L79
    L73:
        r214 = r100;
        goto L75
    L69:
        r213 = r918;
        goto L71
    L65:
        r212 = r917;
        goto L67
    L61:
        r180 = r916;
        goto L63
    L57:
        r179 = r915;
        goto L58
    L53:
        r178 = r914;
        goto L54
    L49:
        r177 = r913;
        goto L51
    L45:
        r175 = r912;
        goto L46
    L41:
        r174 = r911;
        goto L43
    L37:
        r173 = r910;
        goto L39
    L33:
        r172 = r817;
        goto L35
    L29:
        r171 = r816;
        goto L31
    L25:
        r170 = r815;
        goto L27
    L21:
        r169 = r814;
        goto L23
    L17:
        r155 = r813;
        goto L19
    L13:
        r153 = r812;
        goto L15
    L9:
        r151 = r811;
        goto L11
    L5:
        r122 = r810;
        goto L7
    }
}

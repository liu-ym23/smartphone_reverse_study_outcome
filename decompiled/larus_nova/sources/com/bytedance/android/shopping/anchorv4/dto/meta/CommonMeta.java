package com.bytedance.android.shopping.anchorv4.dto.meta;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.ec.model.ECBoltParam;
import com.bytedance.android.ec.model.PromotionDepositPresaleActivity;
import com.bytedance.android.livehostapi.business.depend.livead.MiniAppConstants;
import com.bytedance.android.shopping.anchorv4.dto.business.BottomRightControl;
import com.bytedance.android.shopping.anchorv4.dto.business.FindSameGoodsStruct;
import com.bytedance.android.shopping.anchorv4.dto.business.SkuSpecInfo;
import com.bytedance.android.shopping.anchorv4.voavhs.baseinfo.ActivityVO;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ies.sdk.widgets.priority.PriorityModule;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import e73.j;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b+\n\u0002\u0010\t\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\bE\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001BÇ\u000b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010+\u001a\u00020\t\u0012\b\b\u0002\u0010-\u001a\u00020\t\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010=\u001a\u00020\t\u0012\b\b\u0002\u0010@\u001a\u00020?\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010N\u001a\u00020\t\u0012\b\b\u0002\u0010O\u001a\u00020\t\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010U\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010W\u001a\u00020\t\u0012\b\b\u0002\u0010X\u001a\u00020\u0013\u0012\b\b\u0002\u0010Z\u001a\u00020\u0013\u0012\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010^\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010`\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010c\u001a\u0004\u0018\u00010b\u0012\n\b\u0002\u0010g\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010i\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010k\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010m\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010o\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010q\u001a\u00020\t\u0012\n\b\u0002\u0010s\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010u\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010w\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010y\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010{\u001a\u00020\u0013\u0012\b\b\u0002\u0010}\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u007f\u001a\u0004\u0018\u00010?\u0012\u000b\b\u0002\u0010\u0083\u0001\u001a\u0004\u0018\u00010?\u0012\u000b\b\u0002\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0002\u0012\t\b\u0002\u0010\u0087\u0001\u001a\u00020\t\u0012\u000b\b\u0002\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u008d\u0001\u001a\u0004\u0018\u00010?\u0012\u000b\b\u0002\u0010\u008f\u0001\u001a\u0004\u0018\u00010?\u0012\u000b\b\u0002\u0010\u0091\u0001\u001a\u0004\u0018\u00010?\u0012\u000b\b\u0002\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u0002\u0012\t\b\u0002\u0010\u009f\u0001\u001a\u00020\u0013\u0012\u000b\b\u0002\u0010¡\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010£\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010¥\u0001\u001a\u0004\u0018\u00010\u0002\u0012\t\b\u0002\u0010§\u0001\u001a\u00020\t\u0012\f\b\u0002\u0010©\u0001\u001a\u0005\u0018\u00010¨\u0001\u0012\f\b\u0002\u0010®\u0001\u001a\u0005\u0018\u00010\u00ad\u0001\u0012\u000b\b\u0002\u0010²\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010´\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010¶\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010¸\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010º\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010¼\u0001\u001a\u0004\u0018\u00010\u0002\u0012\t\b\u0002\u0010¾\u0001\u001a\u00020\t\u0012\t\b\u0002\u0010À\u0001\u001a\u00020\u0013\u0012\u000b\b\u0002\u0010Â\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010Ä\u0001\u001a\u0004\u0018\u00010\t\u0012\f\b\u0002\u0010É\u0001\u001a\u0005\u0018\u00010È\u0001\u0012\f\b\u0002\u0010Í\u0001\u001a\u0005\u0018\u00010È\u0001\u0012\t\b\u0002\u0010Ï\u0001\u001a\u00020\u0002\u0012\u000b\b\u0002\u0010Ñ\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010Ó\u0001\u001a\u0004\u0018\u00010\u0002\u0012\f\b\u0002\u0010×\u0001\u001a\u0005\u0018\u00010Ö\u0001\u0012\t\b\u0002\u0010Û\u0001\u001a\u00020\u0013\u0012\u0013\b\u0002\u0010ß\u0001\u001a\f\u0012\u0005\u0012\u00030Þ\u0001\u0018\u00010Ý\u0001\u0012\f\b\u0002\u0010ä\u0001\u001a\u0005\u0018\u00010ã\u0001\u0012\u000b\b\u0002\u0010è\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010ê\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010í\u0001\u001a\u0004\u0018\u00010\u0002\u0012\f\b\u0002\u0010ñ\u0001\u001a\u0005\u0018\u00010ð\u0001\u0012\f\b\u0002\u0010ö\u0001\u001a\u0005\u0018\u00010õ\u0001\u0012\u000b\b\u0002\u0010ú\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010ü\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010þ\u0001\u001a\u0004\u0018\u00010\u0013\u0012\u000b\b\u0002\u0010\u0082\u0002\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u0084\u0002\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u0086\u0002\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u0088\u0002\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u008a\u0002\u001a\u0004\u0018\u00010\u0002\u0012\u001b\b\u0002\u0010\u008e\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0007\u0012\u0005\u0018\u00010\u008d\u0002\u0018\u00010\u008c\u0002\u0012\u000b\b\u0002\u0010\u0092\u0002\u001a\u0004\u0018\u00010\u0013\u0012\f\b\u0002\u0010\u0095\u0002\u001a\u0005\u0018\u00010\u0094\u0002\u0012\f\b\u0002\u0010\u009c\u0002\u001a\u0005\u0018\u00010\u009b\u0002\u0012\u000b\b\u0002\u0010 \u0002\u001a\u0004\u0018\u00010\u0002\u0012\t\b\u0002\u0010¢\u0002\u001a\u00020\t\u0012\u001b\b\u0002\u0010£\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0007\u0012\u0005\u0018\u00010\u008d\u0002\u0018\u00010\u008c\u0002\u0012\u000b\b\u0002\u0010§\u0002\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010ª\u0002\u001a\u0004\u0018\u00010\u0002\u0012\f\b\u0002\u0010®\u0002\u001a\u0005\u0018\u00010\u00ad\u0002\u0012\u000b\b\u0002\u0010²\u0002\u001a\u0004\u0018\u00010\t\u0012\u000b\b\u0002\u0010´\u0002\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010¶\u0002\u001a\u0004\u0018\u00010\t\u0012\u000b\b\u0002\u0010¸\u0002\u001a\u0004\u0018\u00010\t¢\u0006\u0006\b¾\u0002\u0010¿\u0002R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\"\u0010\u0011\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001a\u0010\f\"\u0004\b\u001b\u0010\u000eR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006R\u001c\u0010 \u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006R$\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR\u001c\u0010%\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006R\u001c\u0010'\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006R\u001c\u0010)\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010\u0004\u001a\u0004\b*\u0010\u0006R\u001a\u0010+\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010\u000b\u001a\u0004\b,\u0010\fR\u001a\u0010-\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010\u000b\u001a\u0004\b.\u0010\fR\u001c\u0010/\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010\u0004\u001a\u0004\b0\u0010\u0006R\u001c\u00101\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b1\u0010\u0004\u001a\u0004\b2\u0010\u0006R\u001c\u00103\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b3\u0010\u0004\u001a\u0004\b4\u0010\u0006R\u001c\u00105\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b5\u0010\u0004\u001a\u0004\b6\u0010\u0006R\u001c\u00107\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b7\u0010\u0004\u001a\u0004\b8\u0010\u0006R\u001c\u00109\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b9\u0010\u0004\u001a\u0004\b:\u0010\u0006R\u001c\u0010;\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b;\u0010\u0004\u001a\u0004\b<\u0010\u0006R\u001a\u0010=\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b=\u0010\u000b\u001a\u0004\b>\u0010\fR\u001a\u0010@\u001a\u00020?8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u001c\u0010D\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bD\u0010\u0004\u001a\u0004\bE\u0010\u0006R\u001c\u0010F\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bF\u0010\u0004\u001a\u0004\bG\u0010\u0006R\u001c\u0010H\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bH\u0010\u0004\u001a\u0004\bI\u0010\u0006R\u001c\u0010J\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bJ\u0010\u0004\u001a\u0004\bK\u0010\u0006R\u001c\u0010L\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bL\u0010\u0004\u001a\u0004\bM\u0010\u0006R\u001a\u0010N\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bN\u0010\u000b\u001a\u0004\bN\u0010\fR\u001a\u0010O\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bO\u0010\u000b\u001a\u0004\bO\u0010\fR\u001c\u0010P\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bP\u0010\u0004\u001a\u0004\bP\u0010\u0006R\u001c\u0010Q\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bQ\u0010\u0004\u001a\u0004\bR\u0010\u0006R\u001c\u0010S\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bS\u0010\u0004\u001a\u0004\bT\u0010\u0006R\u001c\u0010U\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bU\u0010\u0004\u001a\u0004\bV\u0010\u0006R\u001a\u0010W\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bW\u0010\u000b\u001a\u0004\bW\u0010\fR\u001a\u0010X\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\bX\u0010\u0015\u001a\u0004\bY\u0010\u0017R\u001a\u0010Z\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\bZ\u0010\u0015\u001a\u0004\b[\u0010\u0017R\u001c\u0010\\\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\\\u0010\u0004\u001a\u0004\b]\u0010\u0006R\u001c\u0010^\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b^\u0010\u0004\u001a\u0004\b_\u0010\u0006R\u001c\u0010`\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b`\u0010\u0004\u001a\u0004\ba\u0010\u0006R\u001c\u0010c\u001a\u0004\u0018\u00010b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bc\u0010d\u001a\u0004\be\u0010fR\u001c\u0010g\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bg\u0010\u0004\u001a\u0004\bh\u0010\u0006R\u001c\u0010i\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bi\u0010\u0004\u001a\u0004\bj\u0010\u0006R\u001c\u0010k\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bk\u0010\u0004\u001a\u0004\bl\u0010\u0006R\u001c\u0010m\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bm\u0010\u0004\u001a\u0004\bn\u0010\u0006R\u001c\u0010o\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bo\u0010\u0004\u001a\u0004\bp\u0010\u0006R\u001a\u0010q\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bq\u0010\u000b\u001a\u0004\br\u0010\fR\u001c\u0010s\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bs\u0010\u0004\u001a\u0004\bt\u0010\u0006R\u001c\u0010u\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bu\u0010\u0004\u001a\u0004\bv\u0010\u0006R\u001c\u0010w\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bw\u0010\u0004\u001a\u0004\bx\u0010\u0006R\u001c\u0010y\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\by\u0010\u0004\u001a\u0004\bz\u0010\u0006R\u001a\u0010{\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b{\u0010\u0015\u001a\u0004\b|\u0010\u0017R\u001a\u0010}\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b}\u0010\u0015\u001a\u0004\b~\u0010\u0017R\u001f\u0010\u007f\u001a\u0004\u0018\u00010?8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\b\u007f\u0010\u0080\u0001\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R!\u0010\u0083\u0001\u001a\u0004\u0018\u00010?8\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b\u0083\u0001\u0010\u0080\u0001\u001a\u0006\b\u0084\u0001\u0010\u0082\u0001R\u001f\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0085\u0001\u0010\u0004\u001a\u0005\b\u0086\u0001\u0010\u0006R\u001d\u0010\u0087\u0001\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0087\u0001\u0010\u000b\u001a\u0005\b\u0088\u0001\u0010\fR\u001f\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0089\u0001\u0010\u0004\u001a\u0005\b\u008a\u0001\u0010\u0006R\u001f\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u008b\u0001\u0010\u0004\u001a\u0005\b\u008c\u0001\u0010\u0006R!\u0010\u008d\u0001\u001a\u0004\u0018\u00010?8\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b\u008d\u0001\u0010\u0080\u0001\u001a\u0006\b\u008e\u0001\u0010\u0082\u0001R!\u0010\u008f\u0001\u001a\u0004\u0018\u00010?8\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b\u008f\u0001\u0010\u0080\u0001\u001a\u0006\b\u0090\u0001\u0010\u0082\u0001R!\u0010\u0091\u0001\u001a\u0004\u0018\u00010?8\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b\u0091\u0001\u0010\u0080\u0001\u001a\u0006\b\u0092\u0001\u0010\u0082\u0001R\u001f\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0093\u0001\u0010\u0004\u001a\u0005\b\u0094\u0001\u0010\u0006R\u001f\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0095\u0001\u0010\u0004\u001a\u0005\b\u0096\u0001\u0010\u0006R\u001f\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0097\u0001\u0010\u0004\u001a\u0005\b\u0098\u0001\u0010\u0006R\u001f\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0099\u0001\u0010\u0004\u001a\u0005\b\u009a\u0001\u0010\u0006R\u001f\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u009b\u0001\u0010\u0004\u001a\u0005\b\u009c\u0001\u0010\u0006R\u001f\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u009d\u0001\u0010\u0004\u001a\u0005\b\u009e\u0001\u0010\u0006R\u001d\u0010\u009f\u0001\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u009f\u0001\u0010\u0015\u001a\u0005\b \u0001\u0010\u0017R\u001f\u0010¡\u0001\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b¡\u0001\u0010\u0004\u001a\u0005\b¢\u0001\u0010\u0006R\u001f\u0010£\u0001\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b£\u0001\u0010\u0004\u001a\u0005\b¤\u0001\u0010\u0006R\u001f\u0010¥\u0001\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b¥\u0001\u0010\u0004\u001a\u0005\b¦\u0001\u0010\u0006R\u001d\u0010§\u0001\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b§\u0001\u0010\u000b\u001a\u0005\b§\u0001\u0010\fR\"\u0010©\u0001\u001a\u0005\u0018\u00010¨\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b©\u0001\u0010ª\u0001\u001a\u0006\b«\u0001\u0010¬\u0001R\"\u0010®\u0001\u001a\u0005\u0018\u00010\u00ad\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b®\u0001\u0010¯\u0001\u001a\u0006\b°\u0001\u0010±\u0001R\u001f\u0010²\u0001\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b²\u0001\u0010\u0004\u001a\u0005\b³\u0001\u0010\u0006R\u001f\u0010´\u0001\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b´\u0001\u0010\u0004\u001a\u0005\bµ\u0001\u0010\u0006R\u001f\u0010¶\u0001\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b¶\u0001\u0010\u0004\u001a\u0005\b·\u0001\u0010\u0006R\u001f\u0010¸\u0001\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b¸\u0001\u0010\u0004\u001a\u0005\b¹\u0001\u0010\u0006R\u001f\u0010º\u0001\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bº\u0001\u0010\u0004\u001a\u0005\b»\u0001\u0010\u0006R\u001f\u0010¼\u0001\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b¼\u0001\u0010\u0004\u001a\u0005\b½\u0001\u0010\u0006R\u001d\u0010¾\u0001\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b¾\u0001\u0010\u000b\u001a\u0005\b¿\u0001\u0010\fR\u001d\u0010À\u0001\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bÀ\u0001\u0010\u0015\u001a\u0005\bÁ\u0001\u0010\u0017R\u001f\u0010Â\u0001\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bÂ\u0001\u0010\u0004\u001a\u0005\bÃ\u0001\u0010\u0006R!\u0010Ä\u0001\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\bÄ\u0001\u0010Å\u0001\u001a\u0006\bÆ\u0001\u0010Ç\u0001R\"\u0010É\u0001\u001a\u0005\u0018\u00010È\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\bÉ\u0001\u0010Ê\u0001\u001a\u0006\bË\u0001\u0010Ì\u0001R\"\u0010Í\u0001\u001a\u0005\u0018\u00010È\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\bÍ\u0001\u0010Ê\u0001\u001a\u0006\bÎ\u0001\u0010Ì\u0001R\u001d\u0010Ï\u0001\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bÏ\u0001\u0010\u0004\u001a\u0005\bÐ\u0001\u0010\u0006R\u001f\u0010Ñ\u0001\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bÑ\u0001\u0010\u0004\u001a\u0005\bÒ\u0001\u0010\u0006R(\u0010Ó\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÓ\u0001\u0010\u0004\u001a\u0005\bÔ\u0001\u0010\u0006\"\u0005\bÕ\u0001\u0010\bR\"\u0010×\u0001\u001a\u0005\u0018\u00010Ö\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b×\u0001\u0010Ø\u0001\u001a\u0006\bÙ\u0001\u0010Ú\u0001R\u001d\u0010Û\u0001\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bÛ\u0001\u0010\u0015\u001a\u0005\bÜ\u0001\u0010\u0017R)\u0010ß\u0001\u001a\f\u0012\u0005\u0012\u00030Þ\u0001\u0018\u00010Ý\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\bß\u0001\u0010à\u0001\u001a\u0006\bá\u0001\u0010â\u0001R\"\u0010ä\u0001\u001a\u0005\u0018\u00010ã\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\bä\u0001\u0010å\u0001\u001a\u0006\bæ\u0001\u0010ç\u0001R\u001f\u0010è\u0001\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bè\u0001\u0010\u0004\u001a\u0005\bé\u0001\u0010\u0006R(\u0010ê\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bê\u0001\u0010\u0004\u001a\u0005\bë\u0001\u0010\u0006\"\u0005\bì\u0001\u0010\bR(\u0010í\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bí\u0001\u0010\u0004\u001a\u0005\bî\u0001\u0010\u0006\"\u0005\bï\u0001\u0010\bR\"\u0010ñ\u0001\u001a\u0005\u0018\u00010ð\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\bñ\u0001\u0010ò\u0001\u001a\u0006\bó\u0001\u0010ô\u0001R\"\u0010ö\u0001\u001a\u0005\u0018\u00010õ\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\bö\u0001\u0010÷\u0001\u001a\u0006\bø\u0001\u0010ù\u0001R\u001f\u0010ú\u0001\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bú\u0001\u0010\u0004\u001a\u0005\bû\u0001\u0010\u0006R\u001f\u0010ü\u0001\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\bü\u0001\u0010\u0004\u001a\u0005\bý\u0001\u0010\u0006R!\u0010þ\u0001\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\bþ\u0001\u0010ÿ\u0001\u001a\u0006\b\u0080\u0002\u0010\u0081\u0002R\u001f\u0010\u0082\u0002\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0082\u0002\u0010\u0004\u001a\u0005\b\u0083\u0002\u0010\u0006R\u001f\u0010\u0084\u0002\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0084\u0002\u0010\u0004\u001a\u0005\b\u0085\u0002\u0010\u0006R\u001f\u0010\u0086\u0002\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0086\u0002\u0010\u0004\u001a\u0005\b\u0087\u0002\u0010\u0006R\u001f\u0010\u0088\u0002\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0088\u0002\u0010\u0004\u001a\u0005\b\u0089\u0002\u0010\u0006R\u001f\u0010\u008a\u0002\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u008a\u0002\u0010\u0004\u001a\u0005\b\u008b\u0002\u0010\u0006R1\u0010\u008e\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0007\u0012\u0005\u0018\u00010\u008d\u0002\u0018\u00010\u008c\u00028\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b\u008e\u0002\u0010\u008f\u0002\u001a\u0006\b\u0090\u0002\u0010\u0091\u0002R!\u0010\u0092\u0002\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b\u0092\u0002\u0010ÿ\u0001\u001a\u0006\b\u0093\u0002\u0010\u0081\u0002R,\u0010\u0095\u0002\u001a\u0005\u0018\u00010\u0094\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0095\u0002\u0010\u0096\u0002\u001a\u0006\b\u0097\u0002\u0010\u0098\u0002\"\u0006\b\u0099\u0002\u0010\u009a\u0002R\"\u0010\u009c\u0002\u001a\u0005\u0018\u00010\u009b\u00028\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b\u009c\u0002\u0010\u009d\u0002\u001a\u0006\b\u009e\u0002\u0010\u009f\u0002R\u001f\u0010 \u0002\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b \u0002\u0010\u0004\u001a\u0005\b¡\u0002\u0010\u0006R\u001d\u0010¢\u0002\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b¢\u0002\u0010\u000b\u001a\u0005\b¢\u0002\u0010\fR;\u0010£\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0007\u0012\u0005\u0018\u00010\u008d\u0002\u0018\u00010\u008c\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0006\b£\u0002\u0010\u008f\u0002\u001a\u0006\b¤\u0002\u0010\u0091\u0002\"\u0006\b¥\u0002\u0010¦\u0002R(\u0010§\u0002\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b§\u0002\u0010\u0004\u001a\u0005\b¨\u0002\u0010\u0006\"\u0005\b©\u0002\u0010\bR(\u0010ª\u0002\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bª\u0002\u0010\u0004\u001a\u0005\b«\u0002\u0010\u0006\"\u0005\b¬\u0002\u0010\bR\"\u0010®\u0002\u001a\u0005\u0018\u00010\u00ad\u00028\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b®\u0002\u0010¯\u0002\u001a\u0006\b°\u0002\u0010±\u0002R!\u0010²\u0002\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b²\u0002\u0010Å\u0001\u001a\u0006\b³\u0002\u0010Ç\u0001R\u001f\u0010´\u0002\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b´\u0002\u0010\u0004\u001a\u0005\bµ\u0002\u0010\u0006R!\u0010¶\u0002\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b¶\u0002\u0010Å\u0001\u001a\u0006\b·\u0002\u0010Ç\u0001R!\u0010¸\u0002\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b¸\u0002\u0010Å\u0001\u001a\u0006\b¹\u0002\u0010Ç\u0001R\u0013\u0010»\u0002\u001a\u00020\t8F¢\u0006\u0007\u001a\u0005\bº\u0002\u0010\fR\u0015\u0010½\u0002\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0007\u001a\u0005\b¼\u0002\u0010\u0006¨\u0006À\u0002"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/meta/CommonMeta;", "Ljava/io/Serializable;", "", "commentMonitorName", "Ljava/lang/String;", "getCommentMonitorName", "()Ljava/lang/String;", "setCommentMonitorName", "(Ljava/lang/String;)V", "", "isGalleryOpen", "Z", "()Z", "setGalleryOpen", "(Z)V", "isScreenShotPaused", "setScreenShotPaused", "isHeadViewScrollToGUL", "setHeadViewScrollToGUL", "", "gulVHCount", "I", "getGulVHCount", "()I", "setGulVHCount", "(I)V", "isBottomTipExist", "setBottomTipExist", "transmissibleJson", "getTransmissibleJson", "sourcePage", "getSourcePage", "enterMethod", "getEnterMethod", "entranceInfo", "getEntranceInfo", "setEntranceInfo", "metaParam", "getMetaParam", "v3EventsAdditions", "getV3EventsAdditions", "eComEntranceForm", "getEComEntranceForm", "fromLive", "getFromLive", "fromVideo", "getFromVideo", "searchId", "getSearchId", "searchParams", "getSearchParams", "sourceMethod", "getSourceMethod", "normalSkuId", "getNormalSkuId", "carrierSource", "getCarrierSource", "productId", "getProductId", "promotionId", "getPromotionId", "thirdParty", "getThirdParty", "", "promotionSource", "J", "getPromotionSource", "()J", "shopId", "getShopId", "groupId", "getGroupId", "originType", "getOriginType", "originId", "getOriginId", "brandVerified", "getBrandVerified", "isCrossBorderProduct", "isLiked", "isAuthenticInsure", "hasReplay", "getHasReplay", "withVideo", "getWithVideo", "threeDLogData", "getThreeDLogData", "isVirtual", "applyCoupon", "getApplyCoupon", "preSellType", "getPreSellType", "preSellDelayDes", "getPreSellDelayDes", "deliveryDelayDes", "getDeliveryDelayDes", "logData", "getLogData", "Lcom/bytedance/android/ec/model/PromotionDepositPresaleActivity;", "depositPreSaleActivity", "Lcom/bytedance/android/ec/model/PromotionDepositPresaleActivity;", "getDepositPreSaleActivity", "()Lcom/bytedance/android/ec/model/PromotionDepositPresaleActivity;", "rebateId", "getRebateId", "withSku", "getWithSku", "campaignType", "getCampaignType", "avlDiscount", "getAvlDiscount", "couponId", "getCouponId", "showInstallmentFlag", "getShowInstallmentFlag", "baseVerifiedCategory", "getBaseVerifiedCategory", "cardStatus", "getCardStatus", "requestAdditions", "getRequestAdditions", "payType", "getPayType", "presellType", "getPresellType", "productType", "getProductType", "discountMinPrice", "Ljava/lang/Long;", "getDiscountMinPrice", "()Ljava/lang/Long;", "productMinPrice", "getProductMinPrice", "choosePanelText", "getChoosePanelText", "productDeleted", "getProductDeleted", "hotSaleType", "getHotSaleType", "hotSaleSkuId", "getHotSaleSkuId", "regularPrice", "getRegularPrice", "subsidyPrice", "getSubsidyPrice", "subsidyMarketPrice", "getSubsidyMarketPrice", "skuId", "getSkuId", "gulCacheId", "getGulCacheId", "liveRoomId", "getLiveRoomId", "itemId", "getItemId", "authorId", "getAuthorId", "secAuthorId", "getSecAuthorId", "followStatus", "getFollowStatus", "whichAccount", "getWhichAccount", "kolUserTags", "getKolUserTags", "commentAuthorId", "getCommentAuthorId", "isLuban", "Lcom/bytedance/android/ec/model/ECAdLogExtra;", "adLogExtra", "Lcom/bytedance/android/ec/model/ECAdLogExtra;", "getAdLogExtra", "()Lcom/bytedance/android/ec/model/ECAdLogExtra;", "Lcom/bytedance/android/ec/model/ECBoltParam;", "boltParam", "Lcom/bytedance/android/ec/model/ECBoltParam;", "getBoltParam", "()Lcom/bytedance/android/ec/model/ECBoltParam;", "pageId", "getPageId", "trackExtra", "getTrackExtra", "labelNameLive", "getLabelNameLive", "labelName", "getLabelName", "marketingChannel", "getMarketingChannel", "userAddrId", "getUserAddrId", "productIsInvalid", "getProductIsInvalid", "commentEnterFrom", "getCommentEnterFrom", "buttonStatus", "getButtonStatus", "needEnlarged", "Ljava/lang/Boolean;", "getNeedEnlarged", "()Ljava/lang/Boolean;", "", "enlargeStandardSize", "Ljava/lang/Float;", "getEnlargeStandardSize", "()Ljava/lang/Float;", "horizontalPadding", "getHorizontalPadding", "forbidSkuSwitch", "getForbidSkuSwitch", "transitionTrackerData", "getTransitionTrackerData", "screenShotPopupSchema", "getScreenShotPopupSchema", "setScreenShotPopupSchema", "Lcom/bytedance/android/shopping/anchorv4/dto/business/FindSameGoodsStruct;", "fullScreenFindSame", "Lcom/bytedance/android/shopping/anchorv4/dto/business/FindSameGoodsStruct;", "getFullScreenFindSame", "()Lcom/bytedance/android/shopping/anchorv4/dto/business/FindSameGoodsStruct;", "supermarketType", "getSupermarketType", "", "Lcom/bytedance/android/shopping/anchorv4/dto/business/SkuSpecInfo;", "skuSpecInfo", "Ljava/util/List;", "getSkuSpecInfo", "()Ljava/util/List;", "Lcom/bytedance/android/shopping/anchorv4/dto/business/BottomRightControl;", "bottomRightControl", "Lcom/bytedance/android/shopping/anchorv4/dto/business/BottomRightControl;", "getBottomRightControl", "()Lcom/bytedance/android/shopping/anchorv4/dto/business/BottomRightControl;", "productBuyStatus", "getProductBuyStatus", "screenShotParams", "getScreenShotParams", "setScreenShotParams", "screenShotWithQr", "getScreenShotWithQr", "setScreenShotWithQr", "Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/ActivityVO;", "activityInfo", "Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/ActivityVO;", "getActivityInfo", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/ActivityVO;", "Lcom/bytedance/android/shopping/anchorv4/dto/meta/PDPBusinessFlags;", "pdpBusinessFlags", "Lcom/bytedance/android/shopping/anchorv4/dto/meta/PDPBusinessFlags;", "getPdpBusinessFlags", "()Lcom/bytedance/android/shopping/anchorv4/dto/meta/PDPBusinessFlags;", "tagGuaranteeHeader", "getTagGuaranteeHeader", RemoteMessageConst.Notification.CHANNEL_ID, "getChannelId", "channelType", "Ljava/lang/Integer;", "getChannelType", "()Ljava/lang/Integer;", "cpsTrack", "getCpsTrack", "cBizCombo", "getCBizCombo", "buyinTrack", "getBuyinTrack", "ecomSceneId", "getEcomSceneId", "searchPageSchema", "getSearchPageSchema", "", "", "searchPageParams", "Ljava/util/Map;", "getSearchPageParams", "()Ljava/util/Map;", "productCommentDataType", "getProductCommentDataType", "Lcom/google/gson/JsonObject;", "pdpLynxData", "Lcom/google/gson/JsonObject;", "getPdpLynxData", "()Lcom/google/gson/JsonObject;", "setPdpLynxData", "(Lcom/google/gson/JsonObject;)V", "Lcom/bytedance/android/shopping/anchorv4/dto/meta/SearchItemTrackParams;", "searchItemTrackParams", "Lcom/bytedance/android/shopping/anchorv4/dto/meta/SearchItemTrackParams;", "getSearchItemTrackParams", "()Lcom/bytedance/android/shopping/anchorv4/dto/meta/SearchItemTrackParams;", "bizCampaignType", "getBizCampaignType", "isCollected", "pdpBcmParams", "getPdpBcmParams", "setPdpBcmParams", "(Ljava/util/Map;)V", "screenShotPhotoSchema", "getScreenShotPhotoSchema", "setScreenShotPhotoSchema", "productBizIdentifier", "getProductBizIdentifier", "setProductBizIdentifier", "Le73/j;", "schemaUnion", "Le73/j;", "getSchemaUnion", "()Le73/j;", "hasGirdle", "getHasGirdle", "footPrint", "getFootPrint", "onSale", "getOnSale", "optRespSize", "getOptRespSize", "getEnablePDPOptimize", "enablePDPOptimize", "getLastEcomSceneId", "lastEcomSceneId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/model/PromotionDepositPresaleActivity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/Long;Ljava/lang/Long;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/bytedance/android/ec/model/ECAdLogExtra;Lcom/bytedance/android/ec/model/ECBoltParam;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/String;Ljava/lang/Boolean;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv4/dto/business/FindSameGoodsStruct;ILjava/util/List;Lcom/bytedance/android/shopping/anchorv4/dto/business/BottomRightControl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/ActivityVO;Lcom/bytedance/android/shopping/anchorv4/dto/meta/PDPBusinessFlags;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Integer;Lcom/google/gson/JsonObject;Lcom/bytedance/android/shopping/anchorv4/dto/meta/SearchItemTrackParams;Ljava/lang/String;ZLjava/util/Map;Ljava/lang/String;Ljava/lang/String;Le73/j;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonMeta implements Serializable {

    @SerializedName("activity_info")
    private final ActivityVO activityInfo;

    @SerializedName(PdpOpenThirdParam.KEY_AD_LOG_EXTRA)
    private final ECAdLogExtra adLogExtra;

    @SerializedName("apply_coupon")
    private final int applyCoupon;

    @SerializedName("author_id")
    private final String authorId;

    @SerializedName(a.KEY_AVL_DISCOUNT)
    private final String avlDiscount;

    @SerializedName(a.KEY_BASE_VERIFIED_CATEGORY)
    private final String baseVerifiedCategory;

    @SerializedName("biz_campaign_type")
    private final String bizCampaignType;

    @SerializedName("bolt_param")
    private final ECBoltParam boltParam;

    @SerializedName("bottom_right_control")
    private final BottomRightControl bottomRightControl;

    @SerializedName(a.KEY_BRAND_VERIFIED)
    private final String brandVerified;

    @SerializedName(a.KEY_BUTTON_STATUS)
    private final String buttonStatus;

    @SerializedName(a.KEY_BUYIN_TRACK)
    private final String buyinTrack;

    @SerializedName(a.KEY_C_BIZ_COMBO)
    private final String cBizCombo;

    @SerializedName("campaign_type")
    private final String campaignType;

    @SerializedName(a.KEY_CARD_STATUS)
    private final String cardStatus;

    @SerializedName(a.KEY_CARRIER_SOURCE)
    private final String carrierSource;

    @SerializedName("channel_id")
    private final String channelId;

    @SerializedName(WsConstants.KEY_CHANNEL_TYPE)
    private final Integer channelType;

    @SerializedName("choose_panel_text")
    private final String choosePanelText;

    @SerializedName("comment_author_id")
    private final String commentAuthorId;

    @SerializedName("comment_enter_from")
    private final int commentEnterFrom;
    private String commentMonitorName;

    @SerializedName("coupon_id")
    private final String couponId;

    @SerializedName("cps_track")
    private final String cpsTrack;

    @SerializedName("delivery_delay_des")
    private final String deliveryDelayDes;

    @SerializedName("deposit_pre_sale_activity")
    private final PromotionDepositPresaleActivity depositPreSaleActivity;

    @SerializedName(a.KEY_DISCOUNT_MIN_PRICE)
    private final Long discountMinPrice;

    @SerializedName(a.KEY_ECOM_ENTRANCE_FORM)
    private final String eComEntranceForm;

    @SerializedName("ecom_scene_id")
    private final String ecomSceneId;

    @SerializedName("enlarge_standard_size")
    private final Float enlargeStandardSize;

    @SerializedName("enter_method")
    private final String enterMethod;

    @SerializedName(a.KEY_ENTRANCE_INFO)
    private String entranceInfo;

    @SerializedName("follow_status")
    private final int followStatus;

    @SerializedName("foot_print")
    private final String footPrint;

    @SerializedName("forbid_sku_switch")
    private final String forbidSkuSwitch;

    @SerializedName("from_live")
    private final boolean fromLive;

    @SerializedName("from_video")
    private final boolean fromVideo;

    @SerializedName("full_screen_find_same")
    private final FindSameGoodsStruct fullScreenFindSame;

    @SerializedName("group_id")
    private final String groupId;

    @SerializedName("guess_like_cache_id")
    private final String gulCacheId;
    private int gulVHCount;

    @SerializedName("has_girdle")
    private final Boolean hasGirdle;

    @SerializedName("has_replay")
    private final String hasReplay;

    @SerializedName("horizontal_padding")
    private final Float horizontalPadding;

    @SerializedName("hot_sale_sku_id")
    private final String hotSaleSkuId;

    @SerializedName("hot_sale_type")
    private final String hotSaleType;

    @SerializedName(a.KEY_IS_AUTHENTIC_INSURE)
    private final String isAuthenticInsure;
    private boolean isBottomTipExist;

    @SerializedName("is_collected")
    private final boolean isCollected;

    @SerializedName("is_cross_border_product")
    private final boolean isCrossBorderProduct;
    private boolean isGalleryOpen;
    private boolean isHeadViewScrollToGUL;

    @SerializedName("is_liked")
    private final boolean isLiked;

    @SerializedName(a.KEY_IS_LUBAN)
    private final boolean isLuban;
    private boolean isScreenShotPaused;

    @SerializedName("is_virtual")
    private final boolean isVirtual;

    @SerializedName("item_id")
    private final String itemId;

    @SerializedName("kol_user_tags")
    private final String kolUserTags;

    @SerializedName(a.KEY_LABEL_NAME)
    private final String labelName;

    @SerializedName(a.KEY_LABEL_NAME_LIVE)
    private final String labelNameLive;

    @SerializedName(MiniAppConstants.KEY_MINI_APP_LIVE_ROOM_ID)
    private final String liveRoomId;

    @SerializedName("log_data")
    private final String logData;

    @SerializedName(a.KEY_MARKET_CHANNEL)
    private final String marketingChannel;

    @SerializedName(a.KEY_META_PARAM)
    private final String metaParam;

    @SerializedName("need_enlarged")
    private final Boolean needEnlarged;

    @SerializedName("normal_sku_id")
    private final String normalSkuId;

    @SerializedName("on_sale")
    private final Boolean onSale;

    @SerializedName("opt_resp_size")
    private final Boolean optRespSize;

    @SerializedName(a.KEY_ORIGIN_ID)
    private final String originId;

    @SerializedName(a.KEY_ORIGIN_TYPE)
    private final String originType;

    @SerializedName(a.KEY_PAGE_ID)
    private final String pageId;

    @SerializedName("pay_type")
    private final String payType;

    @SerializedName("pdp_bcm_params")
    private Map<String, ? extends Object> pdpBcmParams;

    @SerializedName("pdp_business_flags")
    private final PDPBusinessFlags pdpBusinessFlags;

    @SerializedName("pdp_lynx_data")
    private JsonObject pdpLynxData;

    @SerializedName("pre_sell_delay_des")
    private final String preSellDelayDes;

    @SerializedName("pre_sell_type")
    private final int preSellType;

    @SerializedName("presell_type")
    private final int presellType;

    @SerializedName("product_biz_identifier")
    private String productBizIdentifier;

    @SerializedName(a.KEY_PRODUCT_BUY_STATUS)
    private final String productBuyStatus;

    @SerializedName("product_comment_data_type")
    private final Integer productCommentDataType;

    @SerializedName("product_deleted")
    private final boolean productDeleted;

    @SerializedName("product_id")
    private final String productId;

    @SerializedName("product_is_invalid")
    private final boolean productIsInvalid;

    @SerializedName("product_min_price")
    private final Long productMinPrice;

    @SerializedName("product_type")
    private final int productType;

    @SerializedName("promotion_id")
    private final String promotionId;

    @SerializedName(PdpOpenThirdParam.KEY_PROMOTION_SOURCE)
    private final long promotionSource;

    @SerializedName("rebate_id")
    private final String rebateId;

    @SerializedName(a.KEY_REGULAR_PRICE)
    private final Long regularPrice;

    @SerializedName(a.KEY_REQUEST_ADDITIONS)
    private final String requestAdditions;

    @SerializedName("schema_union")
    private final j schemaUnion;

    @SerializedName("screen_shot_params")
    private String screenShotParams;

    @SerializedName("screen_shot_photo_schema")
    private String screenShotPhotoSchema;

    @SerializedName("screen_shot_popup_schema")
    private String screenShotPopupSchema;

    @SerializedName("screen_shot_with_qr")
    private String screenShotWithQr;

    @SerializedName("search_id")
    private final String searchId;

    @SerializedName("search_item_track_params")
    private final SearchItemTrackParams searchItemTrackParams;

    @SerializedName("search_page_params")
    private final Map<String, Object> searchPageParams;

    @SerializedName("search_page_schema")
    private final String searchPageSchema;

    @SerializedName("search_params")
    private final String searchParams;

    @SerializedName("sec_author_id")
    private final String secAuthorId;

    @SerializedName(a.KEY_SHOP_ID)
    private final String shopId;

    @SerializedName("show_installment_flag")
    private final boolean showInstallmentFlag;

    @SerializedName(a.KEY_SKU_ID)
    private final String skuId;

    @SerializedName("sku_spec_info")
    private final List<SkuSpecInfo> skuSpecInfo;

    @SerializedName(a.KEY_SOURCE_METHOD)
    private final String sourceMethod;

    @SerializedName("source_page")
    private final String sourcePage;

    @SerializedName(a.KEY_SUBSIDY_MARKET_PRICE)
    private final Long subsidyMarketPrice;

    @SerializedName(a.KEY_SUBSIDY_PRICE)
    private final Long subsidyPrice;

    @SerializedName("supermarket_type")
    private final int supermarketType;

    @SerializedName("tag_guarantee_header")
    private final String tagGuaranteeHeader;

    @SerializedName(PriorityModule.SCENE_THIRD_PARTY)
    private final boolean thirdParty;

    @SerializedName("three_d_log_data")
    private final String threeDLogData;

    @SerializedName("track_extra")
    private final String trackExtra;

    @SerializedName("transition_tracker_data")
    private final String transitionTrackerData;

    @SerializedName("transmissible_json")
    private final String transmissibleJson;

    @SerializedName("user_addr_id")
    private final String userAddrId;

    @SerializedName("v3_events_additions")
    private final String v3EventsAdditions;

    @SerializedName(a.KEY_WHICH_ACCOUNT)
    private final String whichAccount;

    @SerializedName(a.KEY_WITH_SKU)
    private final String withSku;

    @SerializedName("with_video")
    private final String withVideo;

    public CommonMeta() {
        this(null, null, null, null, null, null, null, false, false, null, null, null, null, null, null, null, false, 0, null, null, null, null, null, false, false, null, null, null, null, false, 0, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, 0, 0, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, false, null, null, null, null, null, null, null, null, false, 0, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, -1, -1, -1, 1048575, null);
    }

    public final boolean getEnablePDPOptimize() {
        PDPBusinessFlags r100 = this.pdpBusinessFlags;
        if (r100 == null) goto L5;
        Integer r101 = r100.getEnablePDPOptimize();
    L6:
        if (r101 != null) goto L9;
    L10:
        return true;
    L9:
        if (r101.intValue() != 0) goto L10;
        return false;
    L5:
        r101 = null;
        goto L6
    }

    public final String getLastEcomSceneId() {
        String r100 = this.ecomSceneId;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L12;
        return null;
    L12:
        List r103 = StringsKt.split$default(r100, new char[]{','}, false, 0, 6, null);
        List r104 = r103;
        if (r104 != null) goto L15;
    L16:
        r101 = true;
    L17:
        if (r101 == false) goto L20;
        return null;
    L20:
        return (String) CollectionsKt.getOrNull(r103, r103.size() - 1);
    L15:
        if (r104.isEmpty() == false) goto L17;
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L10
    }

    public final ActivityVO getActivityInfo() {
        return this.activityInfo;
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

    public final String getAvlDiscount() {
        return this.avlDiscount;
    }

    public final String getBaseVerifiedCategory() {
        return this.baseVerifiedCategory;
    }

    public final String getBizCampaignType() {
        return this.bizCampaignType;
    }

    public final ECBoltParam getBoltParam() {
        return this.boltParam;
    }

    public final BottomRightControl getBottomRightControl() {
        return this.bottomRightControl;
    }

    public final String getBrandVerified() {
        return this.brandVerified;
    }

    public final String getButtonStatus() {
        return this.buttonStatus;
    }

    public final String getBuyinTrack() {
        return this.buyinTrack;
    }

    public final String getCBizCombo() {
        return this.cBizCombo;
    }

    public final String getCampaignType() {
        return this.campaignType;
    }

    public final String getCardStatus() {
        return this.cardStatus;
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

    public final String getChoosePanelText() {
        return this.choosePanelText;
    }

    public final String getCommentAuthorId() {
        return this.commentAuthorId;
    }

    public final int getCommentEnterFrom() {
        return this.commentEnterFrom;
    }

    public final String getCommentMonitorName() {
        return this.commentMonitorName;
    }

    public final String getCouponId() {
        return this.couponId;
    }

    public final String getCpsTrack() {
        return this.cpsTrack;
    }

    public final String getDeliveryDelayDes() {
        return this.deliveryDelayDes;
    }

    public final PromotionDepositPresaleActivity getDepositPreSaleActivity() {
        return this.depositPreSaleActivity;
    }

    public final Long getDiscountMinPrice() {
        return this.discountMinPrice;
    }

    public final String getEComEntranceForm() {
        return this.eComEntranceForm;
    }

    public final String getEcomSceneId() {
        return this.ecomSceneId;
    }

    public final Float getEnlargeStandardSize() {
        return this.enlargeStandardSize;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final String getEntranceInfo() {
        return this.entranceInfo;
    }

    public final int getFollowStatus() {
        return this.followStatus;
    }

    public final String getFootPrint() {
        return this.footPrint;
    }

    public final String getForbidSkuSwitch() {
        return this.forbidSkuSwitch;
    }

    public final boolean getFromLive() {
        return this.fromLive;
    }

    public final boolean getFromVideo() {
        return this.fromVideo;
    }

    public final FindSameGoodsStruct getFullScreenFindSame() {
        return this.fullScreenFindSame;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final String getGulCacheId() {
        return this.gulCacheId;
    }

    public final int getGulVHCount() {
        return this.gulVHCount;
    }

    public final Boolean getHasGirdle() {
        return this.hasGirdle;
    }

    public final String getHasReplay() {
        return this.hasReplay;
    }

    public final Float getHorizontalPadding() {
        return this.horizontalPadding;
    }

    public final String getHotSaleSkuId() {
        return this.hotSaleSkuId;
    }

    public final String getHotSaleType() {
        return this.hotSaleType;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final String getKolUserTags() {
        return this.kolUserTags;
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

    public final String getMarketingChannel() {
        return this.marketingChannel;
    }

    public final String getMetaParam() {
        return this.metaParam;
    }

    public final Boolean getNeedEnlarged() {
        return this.needEnlarged;
    }

    public final String getNormalSkuId() {
        return this.normalSkuId;
    }

    public final Boolean getOnSale() {
        return this.onSale;
    }

    public final Boolean getOptRespSize() {
        return this.optRespSize;
    }

    public final String getOriginId() {
        return this.originId;
    }

    public final String getOriginType() {
        return this.originType;
    }

    public final String getPageId() {
        return this.pageId;
    }

    public final String getPayType() {
        return this.payType;
    }

    public final Map<String, Object> getPdpBcmParams() {
        return this.pdpBcmParams;
    }

    public final PDPBusinessFlags getPdpBusinessFlags() {
        return this.pdpBusinessFlags;
    }

    public final JsonObject getPdpLynxData() {
        return this.pdpLynxData;
    }

    public final String getPreSellDelayDes() {
        return this.preSellDelayDes;
    }

    public final int getPreSellType() {
        return this.preSellType;
    }

    public final int getPresellType() {
        return this.presellType;
    }

    public final String getProductBizIdentifier() {
        return this.productBizIdentifier;
    }

    public final String getProductBuyStatus() {
        return this.productBuyStatus;
    }

    public final Integer getProductCommentDataType() {
        return this.productCommentDataType;
    }

    public final boolean getProductDeleted() {
        return this.productDeleted;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final boolean getProductIsInvalid() {
        return this.productIsInvalid;
    }

    public final Long getProductMinPrice() {
        return this.productMinPrice;
    }

    public final int getProductType() {
        return this.productType;
    }

    public final String getPromotionId() {
        return this.promotionId;
    }

    public final long getPromotionSource() {
        return this.promotionSource;
    }

    public final String getRebateId() {
        return this.rebateId;
    }

    public final Long getRegularPrice() {
        return this.regularPrice;
    }

    public final String getRequestAdditions() {
        return this.requestAdditions;
    }

    public final j getSchemaUnion() {
        return this.schemaUnion;
    }

    public final String getScreenShotParams() {
        return this.screenShotParams;
    }

    public final String getScreenShotPhotoSchema() {
        return this.screenShotPhotoSchema;
    }

    public final String getScreenShotPopupSchema() {
        return this.screenShotPopupSchema;
    }

    public final String getScreenShotWithQr() {
        return this.screenShotWithQr;
    }

    public final String getSearchId() {
        return this.searchId;
    }

    public final SearchItemTrackParams getSearchItemTrackParams() {
        return this.searchItemTrackParams;
    }

    public final Map<String, Object> getSearchPageParams() {
        return this.searchPageParams;
    }

    public final String getSearchPageSchema() {
        return this.searchPageSchema;
    }

    public final String getSearchParams() {
        return this.searchParams;
    }

    public final String getSecAuthorId() {
        return this.secAuthorId;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final boolean getShowInstallmentFlag() {
        return this.showInstallmentFlag;
    }

    public final String getSkuId() {
        return this.skuId;
    }

    public final List<SkuSpecInfo> getSkuSpecInfo() {
        return this.skuSpecInfo;
    }

    public final String getSourceMethod() {
        return this.sourceMethod;
    }

    public final String getSourcePage() {
        return this.sourcePage;
    }

    public final Long getSubsidyMarketPrice() {
        return this.subsidyMarketPrice;
    }

    public final Long getSubsidyPrice() {
        return this.subsidyPrice;
    }

    public final int getSupermarketType() {
        return this.supermarketType;
    }

    public final String getTagGuaranteeHeader() {
        return this.tagGuaranteeHeader;
    }

    public final boolean getThirdParty() {
        return this.thirdParty;
    }

    public final String getThreeDLogData() {
        return this.threeDLogData;
    }

    public final String getTrackExtra() {
        return this.trackExtra;
    }

    public final String getTransitionTrackerData() {
        return this.transitionTrackerData;
    }

    public final String getTransmissibleJson() {
        return this.transmissibleJson;
    }

    public final String getUserAddrId() {
        return this.userAddrId;
    }

    public final String getV3EventsAdditions() {
        return this.v3EventsAdditions;
    }

    public final String getWhichAccount() {
        return this.whichAccount;
    }

    public final String getWithSku() {
        return this.withSku;
    }

    public final String getWithVideo() {
        return this.withVideo;
    }

    public final String isAuthenticInsure() {
        return this.isAuthenticInsure;
    }

    public final boolean isBottomTipExist() {
        return this.isBottomTipExist;
    }

    public final boolean isCollected() {
        return this.isCollected;
    }

    public final boolean isCrossBorderProduct() {
        return this.isCrossBorderProduct;
    }

    public final boolean isGalleryOpen() {
        return this.isGalleryOpen;
    }

    public final boolean isHeadViewScrollToGUL() {
        return this.isHeadViewScrollToGUL;
    }

    public final boolean isLiked() {
        return this.isLiked;
    }

    public final boolean isLuban() {
        return this.isLuban;
    }

    public final boolean isScreenShotPaused() {
        return this.isScreenShotPaused;
    }

    public final boolean isVirtual() {
        return this.isVirtual;
    }

    public final void setBottomTipExist(boolean r100) {
        this.isBottomTipExist = r100;
    }

    public final void setCommentMonitorName(String r100) {
        this.commentMonitorName = r100;
    }

    public final void setEntranceInfo(String r100) {
        this.entranceInfo = r100;
    }

    public final void setGalleryOpen(boolean r100) {
        this.isGalleryOpen = r100;
    }

    public final void setGulVHCount(int r100) {
        this.gulVHCount = r100;
    }

    public final void setHeadViewScrollToGUL(boolean r100) {
        this.isHeadViewScrollToGUL = r100;
    }

    public final void setPdpBcmParams(Map<String, ? extends Object> r100) {
        this.pdpBcmParams = r100;
    }

    public final void setPdpLynxData(JsonObject r100) {
        this.pdpLynxData = r100;
    }

    public final void setProductBizIdentifier(String r100) {
        this.productBizIdentifier = r100;
    }

    public final void setScreenShotParams(String r100) {
        this.screenShotParams = r100;
    }

    public final void setScreenShotPaused(boolean r100) {
        this.isScreenShotPaused = r100;
    }

    public final void setScreenShotPhotoSchema(String r100) {
        this.screenShotPhotoSchema = r100;
    }

    public final void setScreenShotPopupSchema(String r100) {
        this.screenShotPopupSchema = r100;
    }

    public final void setScreenShotWithQr(String r100) {
        this.screenShotWithQr = r100;
    }

    public CommonMeta(String r100, String r101, String r102, String r103, String r104, String r110, String r111, boolean r112, boolean r113, String r114, String r115, String r116, String r117, String r118, String r119, String r210, boolean r211, long r212, String r213, String r214, String r215, String r216, String r217, boolean r218, boolean r310, String r311, String r312, String r313, String r314, boolean r315, int r316, int r317, String r318, String r319, String r410, PromotionDepositPresaleActivity r411, String r412, String r413, String r414, String r415, String r416, boolean r417, String r418, String r419, String r510, String r511, int r512, int r513, Long r514, Long r515, String r516, boolean r517, String r518, String r519, Long r610, Long r611, Long r612, String r613, String r614, String r615, String r616, String r617, String r618, int r619, String r710, String r711, String r712, boolean r713, ECAdLogExtra r714, ECBoltParam r715, String r716, String r717, String r718, String r719, String r810, String r811, boolean r812, int r813, String r814, Boolean r815, Float r816, Float r817, String r818, String r819, String r910, FindSameGoodsStruct r911, int r912, List<SkuSpecInfo> r913, BottomRightControl r914, String r915, String r916, String r917, ActivityVO r918, PDPBusinessFlags r919, String r105, String r106, Integer r107, String r108, String r109, String r1010, String r1011, String r1012, Map<String, ? extends Object> r1013, Integer r1014, JsonObject r1110, SearchItemTrackParams r1111, String r1112, boolean r1113, Map<String, ? extends Object> r1114, String r1115, String r1116, j r1117, Boolean r1118, String r1119, Boolean r120, Boolean r121) {
        Intrinsics.checkNotNullParameter(r818, "forbidSkuSwitch");
        this.transmissibleJson = r100;
        this.sourcePage = r101;
        this.enterMethod = r102;
        this.entranceInfo = r103;
        this.metaParam = r104;
        this.v3EventsAdditions = r110;
        this.eComEntranceForm = r111;
        this.fromLive = r112;
        this.fromVideo = r113;
        this.searchId = r114;
        this.searchParams = r115;
        this.sourceMethod = r116;
        this.normalSkuId = r117;
        this.carrierSource = r118;
        this.productId = r119;
        this.promotionId = r210;
        this.thirdParty = r211;
        this.promotionSource = r212;
        this.shopId = r213;
        this.groupId = r214;
        this.originType = r215;
        this.originId = r216;
        this.brandVerified = r217;
        this.isCrossBorderProduct = r218;
        this.isLiked = r310;
        this.isAuthenticInsure = r311;
        this.hasReplay = r312;
        this.withVideo = r313;
        this.threeDLogData = r314;
        this.isVirtual = r315;
        this.applyCoupon = r316;
        this.preSellType = r317;
        this.preSellDelayDes = r318;
        this.deliveryDelayDes = r319;
        this.logData = r410;
        this.depositPreSaleActivity = r411;
        this.rebateId = r412;
        this.withSku = r413;
        this.campaignType = r414;
        this.avlDiscount = r415;
        this.couponId = r416;
        this.showInstallmentFlag = r417;
        this.baseVerifiedCategory = r418;
        this.cardStatus = r419;
        this.requestAdditions = r510;
        this.payType = r511;
        this.presellType = r512;
        this.productType = r513;
        this.discountMinPrice = r514;
        this.productMinPrice = r515;
        this.choosePanelText = r516;
        this.productDeleted = r517;
        this.hotSaleType = r518;
        this.hotSaleSkuId = r519;
        this.regularPrice = r610;
        this.subsidyPrice = r611;
        this.subsidyMarketPrice = r612;
        this.skuId = r613;
        this.gulCacheId = r614;
        this.liveRoomId = r615;
        this.itemId = r616;
        this.authorId = r617;
        this.secAuthorId = r618;
        this.followStatus = r619;
        this.whichAccount = r710;
        this.kolUserTags = r711;
        this.commentAuthorId = r712;
        this.isLuban = r713;
        this.adLogExtra = r714;
        this.boltParam = r715;
        this.pageId = r716;
        this.trackExtra = r717;
        this.labelNameLive = r718;
        this.labelName = r719;
        this.marketingChannel = r810;
        this.userAddrId = r811;
        this.productIsInvalid = r812;
        this.commentEnterFrom = r813;
        this.buttonStatus = r814;
        this.needEnlarged = r815;
        this.enlargeStandardSize = r816;
        this.horizontalPadding = r817;
        this.forbidSkuSwitch = r818;
        this.transitionTrackerData = r819;
        this.screenShotPopupSchema = r910;
        this.fullScreenFindSame = r911;
        this.supermarketType = r912;
        this.skuSpecInfo = r913;
        this.bottomRightControl = r914;
        this.productBuyStatus = r915;
        this.screenShotParams = r916;
        this.screenShotWithQr = r917;
        this.activityInfo = r918;
        this.pdpBusinessFlags = r919;
        this.tagGuaranteeHeader = r105;
        this.channelId = r106;
        this.channelType = r107;
        this.cpsTrack = r108;
        this.cBizCombo = r109;
        this.buyinTrack = r1010;
        this.ecomSceneId = r1011;
        this.searchPageSchema = r1012;
        this.searchPageParams = r1013;
        this.productCommentDataType = r1014;
        this.pdpLynxData = r1110;
        this.searchItemTrackParams = r1111;
        this.bizCampaignType = r1112;
        this.isCollected = r1113;
        this.pdpBcmParams = r1114;
        this.screenShotPhotoSchema = r1115;
        this.productBizIdentifier = r1116;
        this.schemaUnion = r1117;
        this.hasGirdle = r1118;
        this.footPrint = r1119;
        this.onSale = r120;
        this.optRespSize = r121;
        this.commentMonitorName = "";
    }

    public /* synthetic */ CommonMeta(String r116, String r117, String r118, String r119, String r120, String r121, String r122, boolean r123, boolean r124, String r125, String r126, String r127, String r128, String r129, String r130, String r131, boolean r132, long r133, String r135, String r136, String r137, String r138, String r139, boolean r140, boolean r141, String r142, String r143, String r144, String r145, boolean r146, int r147, int r148, String r149, String r150, String r151, PromotionDepositPresaleActivity r152, String r153, String r154, String r155, String r156, String r157, boolean r158, String r159, String r160, String r161, String r162, int r163, int r164, Long r165, Long r166, String r167, boolean r168, String r169, String r170, Long r171, Long r172, Long r173, String r174, String r175, String r176, String r177, String r178, String r179, int r180, String r181, String r182, String r183, boolean r184, ECAdLogExtra r185, ECBoltParam r186, String r187, String r188, String r189, String r190, String r191, String r192, boolean r193, int r194, String r195, Boolean r196, Float r197, Float r198, String r199, String r200, String r201, FindSameGoodsStruct r202, int r203, List r204, BottomRightControl r205, String r206, String r207, String r208, ActivityVO r209, PDPBusinessFlags r210, String r211, String r212, Integer r213, String r214, String r215, String r216, String r217, String r218, Map r219, Integer r220, JsonObject r221, SearchItemTrackParams r222, String r223, boolean r224, Map r225, String r226, String r227, j r228, Boolean r229, String r230, Boolean r231, Boolean r232, int r233, int r234, int r235, int r236, DefaultConstructorMarker r237) {
        if ((r233 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r233 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r233 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r233 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r233 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r233 & 32) == 0) goto L25;
        String r110 = null;
    L27:
        if ((r233 & 64) == 0) goto L29;
        String r111 = null;
    L31:
        if ((r233 & 128) == 0) goto L33;
        boolean r112 = false;
    L35:
        if ((r233 & 256) == 0) goto L37;
        boolean r113 = false;
    L39:
        if ((r233 & 512) == 0) goto L41;
        String r114 = null;
    L43:
        if ((r233 & 1024) == 0) goto L45;
        String r105 = null;
    L47:
        if ((r233 & 2048) == 0) goto L49;
        String r115 = null;
    L50:
        String r134 = r115;
        if ((r233 & 4096) == 0) goto L53;
        String r1100 = null;
    L54:
        String r1101 = r1100;
        if ((r233 & 8192) == 0) goto L57;
        String r1102 = null;
    L58:
        String r1103 = r1102;
        if ((r233 & 16384) == 0) goto L61;
        String r1104 = null;
    L63:
        if ((r233 & 32768) == 0) goto L65;
        String r238 = null;
    L67:
        if ((r233 & 65536) == 0) goto L69;
        boolean r239 = false;
    L71:
        if ((r233 & 131072) == 0) goto L73;
        long r240 = 0;
    L75:
        if ((r233 & 262144) == 0) goto L77;
        String r241 = null;
    L79:
        if ((r233 & 524288) == 0) goto L81;
        String r242 = null;
    L83:
        if ((r233 & 1048576) == 0) goto L85;
        String r310 = "";
    L87:
        if ((r233 & 2097152) == 0) goto L89;
        String r311 = "";
    L91:
        if ((r233 & 4194304) == 0) goto L93;
        String r312 = null;
    L95:
        if ((r233 & 8388608) == 0) goto L97;
        boolean r313 = false;
    L99:
        if ((r233 & 16777216) == 0) goto L101;
        boolean r314 = false;
    L103:
        if ((r233 & 33554432) == 0) goto L105;
        String r315 = null;
    L107:
        if ((r233 & 67108864) == 0) goto L109;
        String r316 = null;
    L111:
        if ((r233 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        String r317 = null;
    L115:
        if ((r233 & 268435456) == 0) goto L117;
        String r318 = null;
    L119:
        if ((r233 & 536870912) == 0) goto L121;
        boolean r319 = false;
    L123:
        if ((r233 & 1073741824) == 0) goto L125;
        int r410 = 0;
    L127:
        if ((r233 & Integer.MIN_VALUE) == 0) goto L129;
        int r106 = 0;
    L131:
        if ((r234 & 1) == 0) goto L133;
        String r411 = null;
    L135:
        if ((r234 & 2) == 0) goto L137;
        String r412 = null;
    L139:
        if ((r234 & 4) == 0) goto L141;
        String r413 = null;
    L143:
        if ((r234 & 8) == 0) goto L145;
        PromotionDepositPresaleActivity r414 = null;
    L147:
        if ((r234 & 16) == 0) goto L149;
        String r415 = null;
    L151:
        if ((r234 & 32) == 0) goto L153;
        String r416 = null;
    L155:
        if ((r234 & 64) == 0) goto L157;
        String r417 = null;
    L158:
        int r2310 = r106;
        if ((r234 & 128) == 0) goto L161;
        String r107 = null;
    L162:
        String r418 = r107;
        if ((r234 & 256) == 0) goto L165;
        String r108 = null;
    L166:
        String r419 = r108;
        if ((r234 & 512) == 0) goto L169;
        boolean r109 = false;
    L170:
        boolean r510 = r109;
        if ((r234 & 1024) == 0) goto L173;
        String r243 = null;
    L174:
        String r511 = r243;
        if ((r234 & 2048) == 0) goto L177;
        String r244 = null;
    L178:
        String r512 = r244;
        if ((r234 & 4096) == 0) goto L181;
        String r245 = null;
    L182:
        String r513 = r245;
        if ((r234 & 8192) == 0) goto L185;
        String r246 = null;
    L186:
        String r514 = r246;
        if ((r234 & 16384) == 0) goto L189;
        int r247 = 0;
    L191:
        if ((r234 & 32768) == 0) goto L193;
        int r515 = 0;
    L195:
        if ((r234 & 65536) == 0) goto L197;
        Long r516 = null;
    L199:
        if ((r234 & 131072) == 0) goto L201;
        Long r517 = null;
    L203:
        if ((r234 & 262144) == 0) goto L205;
        String r518 = null;
    L207:
        if ((r234 & 524288) == 0) goto L209;
        boolean r519 = false;
    L211:
        if ((r234 & 1048576) == 0) goto L213;
        String r610 = null;
    L215:
        if ((r234 & 2097152) == 0) goto L217;
        String r611 = null;
    L219:
        if ((r234 & 4194304) == 0) goto L221;
        Long r612 = null;
    L223:
        if ((r234 & 8388608) == 0) goto L225;
        Long r613 = null;
    L227:
        if ((r234 & 16777216) == 0) goto L229;
        Long r614 = null;
    L231:
        if ((r234 & 33554432) == 0) goto L233;
        String r615 = null;
    L235:
        if ((r234 & 67108864) == 0) goto L237;
        String r616 = null;
    L239:
        if ((r234 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L241;
        String r617 = null;
    L243:
        if ((r234 & 268435456) == 0) goto L245;
        String r618 = null;
    L247:
        if ((r234 & 536870912) == 0) goto L249;
        String r619 = null;
    L251:
        if ((r234 & 1073741824) == 0) goto L253;
        String r710 = null;
    L255:
        if ((r234 & Integer.MIN_VALUE) == 0) goto L257;
        int r248 = 0;
    L259:
        if ((r235 & 1) == 0) goto L261;
        String r711 = null;
    L263:
        if ((r235 & 2) == 0) goto L265;
        String r712 = null;
    L267:
        if ((r235 & 4) == 0) goto L269;
        String r713 = null;
    L271:
        if ((r235 & 8) == 0) goto L273;
        boolean r714 = false;
    L275:
        if ((r235 & 16) == 0) goto L277;
        ECAdLogExtra r715 = null;
    L279:
        if ((r235 & 32) == 0) goto L281;
        ECBoltParam r716 = null;
    L283:
        if ((r235 & 64) == 0) goto L285;
        String r717 = "";
    L286:
        int r2311 = r248;
        if ((r235 & 128) == 0) goto L289;
        String r249 = null;
    L290:
        String r718 = r249;
        if ((r235 & 256) == 0) goto L293;
        String r250 = null;
    L294:
        String r719 = r250;
        if ((r235 & 512) == 0) goto L297;
        String r251 = null;
    L298:
        String r810 = r251;
        if ((r235 & 1024) == 0) goto L301;
        String r252 = null;
    L302:
        String r811 = r252;
        if ((r235 & 2048) == 0) goto L305;
        String r253 = null;
    L306:
        String r812 = r253;
        if ((r235 & 4096) == 0) goto L309;
        boolean r254 = false;
    L310:
        boolean r813 = r254;
        if ((r235 & 8192) == 0) goto L313;
        int r255 = 0;
    L314:
        int r814 = r255;
        if ((r235 & 16384) == 0) goto L317;
        String r256 = "";
    L319:
        if ((r235 & 32768) == 0) goto L321;
        Boolean r815 = Boolean.FALSE;
    L323:
        if ((r235 & 65536) == 0) goto L325;
        Float r816 = null;
    L327:
        if ((r235 & 131072) == 0) goto L329;
        Float r817 = null;
    L331:
        if ((r235 & 262144) == 0) goto L333;
        String r818 = "0";
    L335:
        if ((r235 & 524288) == 0) goto L337;
        String r819 = null;
    L339:
        if ((r235 & 1048576) == 0) goto L341;
        String r910 = null;
    L343:
        if ((r235 & 2097152) == 0) goto L345;
        FindSameGoodsStruct r911 = null;
    L347:
        if ((r235 & 4194304) == 0) goto L349;
        int r912 = 0;
    L351:
        if ((r235 & 8388608) == 0) goto L353;
        List r913 = null;
    L355:
        if ((r235 & 16777216) == 0) goto L357;
        BottomRightControl r914 = null;
    L359:
        if ((r235 & 33554432) == 0) goto L361;
        String r915 = null;
    L363:
        if ((r235 & 67108864) == 0) goto L365;
        String r916 = null;
    L367:
        if ((r235 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L369;
        String r917 = null;
    L371:
        if ((r235 & 268435456) == 0) goto L373;
        ActivityVO r918 = null;
    L375:
        if ((r235 & 536870912) == 0) goto L377;
        PDPBusinessFlags r919 = null;
    L379:
        if ((r235 & 1073741824) == 0) goto L381;
        String r1010 = null;
    L383:
        if ((r235 & Integer.MIN_VALUE) == 0) goto L385;
        String r257 = null;
    L387:
        if ((r236 & 1) == 0) goto L389;
        boolean r1011 = false;
        Integer r1012 = 0;
    L391:
        if ((r236 & 2) == 0) goto L393;
        String r1013 = null;
    L395:
        if ((r236 & 4) == 0) goto L397;
        String r1014 = null;
    L399:
        if ((r236 & 8) == 0) goto L401;
        String r1015 = null;
    L403:
        if ((r236 & 16) == 0) goto L405;
        String r1016 = null;
    L407:
        if ((r236 & 32) == 0) goto L409;
        String r1017 = null;
    L411:
        if ((r236 & 64) == 0) goto L413;
        Map r1018 = null;
    L414:
        String r2312 = r257;
        if ((r236 & 128) == 0) goto L417;
        Integer r258 = null;
    L418:
        Integer r1019 = r258;
        if ((r236 & 256) == 0) goto L421;
        JsonObject r259 = null;
    L422:
        JsonObject r1110 = r259;
        if ((r236 & 512) == 0) goto L425;
        SearchItemTrackParams r260 = null;
    L426:
        SearchItemTrackParams r1111 = r260;
        if ((r236 & 1024) == 0) goto L429;
        String r261 = null;
    L430:
        String r1112 = r261;
        if ((r236 & 2048) != 0) goto L435;
        r1011 = r224;
    L435:
        if ((r236 & 4096) == 0) goto L437;
        Map r262 = null;
    L438:
        Map r1113 = r262;
        if ((r236 & 8192) == 0) goto L441;
        String r263 = null;
    L442:
        String r1114 = r263;
        if ((r236 & 16384) == 0) goto L445;
        String r264 = null;
    L447:
        if ((r236 & 32768) == 0) goto L449;
        j r1105 = null;
    L451:
        if ((r236 & 65536) == 0) goto L453;
        Boolean r265 = null;
    L455:
        if ((r236 & 131072) == 0) goto L457;
        String r266 = null;
    L459:
        if ((r236 & 262144) == 0) goto L461;
        Boolean r267 = null;
    L463:
        if ((r236 & 524288) == 0) goto L465;
        Boolean r268 = null;
    L466:
        this(r100, r101, r102, r103, r104, r110, r111, r112, r113, r114, r105, r134, r1101, r1103, r1104, r238, r239, r240, r241, r242, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r2310, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r512, r513, r514, r247, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r710, r2311, r711, r712, r713, r714, r715, r716, r717, r718, r719, r810, r811, r812, r813, r814, r256, r815, r816, r817, r818, r819, r910, r911, r912, r913, r914, r915, r916, r917, r918, r919, r1010, r2312, r1012, r1013, r1014, r1015, r1016, r1017, r1018, r1019, r1110, r1111, r1112, r1011, r1113, r1114, r264, r1105, r265, r266, r267, r268);
        return;
    L465:
        r268 = r232;
        goto L466
    L461:
        r267 = r231;
        goto L463
    L457:
        r266 = r230;
        goto L459
    L453:
        r265 = r229;
        goto L455
    L449:
        r1105 = r228;
        goto L451
    L445:
        r264 = r227;
        goto L447
    L441:
        r263 = r226;
        goto L442
    L437:
        r262 = r225;
        goto L438
    L429:
        r261 = r223;
        goto L430
    L425:
        r260 = r222;
        goto L426
    L421:
        r259 = r221;
        goto L422
    L417:
        r258 = r220;
        goto L418
    L413:
        r1018 = r219;
        goto L414
    L409:
        r1017 = r218;
        goto L411
    L405:
        r1016 = r217;
        goto L407
    L401:
        r1015 = r216;
        goto L403
    L397:
        r1014 = r215;
        goto L399
    L393:
        r1013 = r214;
        goto L395
    L389:
        r1011 = false;
        r1012 = r213;
        goto L391
    L385:
        r257 = r212;
        goto L387
    L381:
        r1010 = r211;
        goto L383
    L377:
        r919 = r210;
        goto L379
    L373:
        r918 = r209;
        goto L375
    L369:
        r917 = r208;
        goto L371
    L365:
        r916 = r207;
        goto L367
    L361:
        r915 = r206;
        goto L363
    L357:
        r914 = r205;
        goto L359
    L353:
        r913 = r204;
        goto L355
    L349:
        r912 = r203;
        goto L351
    L345:
        r911 = r202;
        goto L347
    L341:
        r910 = r201;
        goto L343
    L337:
        r819 = r200;
        goto L339
    L333:
        r818 = r199;
        goto L335
    L329:
        r817 = r198;
        goto L331
    L325:
        r816 = r197;
        goto L327
    L321:
        r815 = r196;
        goto L323
    L317:
        r256 = r195;
        goto L319
    L313:
        r255 = r194;
        goto L314
    L309:
        r254 = r193;
        goto L310
    L305:
        r253 = r192;
        goto L306
    L301:
        r252 = r191;
        goto L302
    L297:
        r251 = r190;
        goto L298
    L293:
        r250 = r189;
        goto L294
    L289:
        r249 = r188;
        goto L290
    L285:
        r717 = r187;
        goto L286
    L281:
        r716 = r186;
        goto L283
    L277:
        r715 = r185;
        goto L279
    L273:
        r714 = r184;
        goto L275
    L269:
        r713 = r183;
        goto L271
    L265:
        r712 = r182;
        goto L267
    L261:
        r711 = r181;
        goto L263
    L257:
        r248 = r180;
        goto L259
    L253:
        r710 = r179;
        goto L255
    L249:
        r619 = r178;
        goto L251
    L245:
        r618 = r177;
        goto L247
    L241:
        r617 = r176;
        goto L243
    L237:
        r616 = r175;
        goto L239
    L233:
        r615 = r174;
        goto L235
    L229:
        r614 = r173;
        goto L231
    L225:
        r613 = r172;
        goto L227
    L221:
        r612 = r171;
        goto L223
    L217:
        r611 = r170;
        goto L219
    L213:
        r610 = r169;
        goto L215
    L209:
        r519 = r168;
        goto L211
    L205:
        r518 = r167;
        goto L207
    L201:
        r517 = r166;
        goto L203
    L197:
        r516 = r165;
        goto L199
    L193:
        r515 = r164;
        goto L195
    L189:
        r247 = r163;
        goto L191
    L185:
        r246 = r162;
        goto L186
    L181:
        r245 = r161;
        goto L182
    L177:
        r244 = r160;
        goto L178
    L173:
        r243 = r159;
        goto L174
    L169:
        r109 = r158;
        goto L170
    L165:
        r108 = r157;
        goto L166
    L161:
        r107 = r156;
        goto L162
    L157:
        r417 = r155;
        goto L158
    L153:
        r416 = r154;
        goto L155
    L149:
        r415 = r153;
        goto L151
    L145:
        r414 = r152;
        goto L147
    L141:
        r413 = r151;
        goto L143
    L137:
        r412 = r150;
        goto L139
    L133:
        r411 = r149;
        goto L135
    L129:
        r106 = r148;
        goto L131
    L125:
        r410 = r147;
        goto L127
    L121:
        r319 = r146;
        goto L123
    L117:
        r318 = r145;
        goto L119
    L113:
        r317 = r144;
        goto L115
    L109:
        r316 = r143;
        goto L111
    L105:
        r315 = r142;
        goto L107
    L101:
        r314 = r141;
        goto L103
    L97:
        r313 = r140;
        goto L99
    L93:
        r312 = r139;
        goto L95
    L89:
        r311 = r138;
        goto L91
    L85:
        r310 = r137;
        goto L87
    L81:
        r242 = r136;
        goto L83
    L77:
        r241 = r135;
        goto L79
    L73:
        r240 = r133;
        goto L75
    L69:
        r239 = r132;
        goto L71
    L65:
        r238 = r131;
        goto L67
    L61:
        r1104 = r130;
        goto L63
    L57:
        r1102 = r129;
        goto L58
    L53:
        r1100 = r128;
        goto L54
    L49:
        r115 = r127;
        goto L50
    L45:
        r105 = r126;
        goto L47
    L41:
        r114 = r125;
        goto L43
    L37:
        r113 = r124;
        goto L39
    L33:
        r112 = r123;
        goto L35
    L29:
        r111 = r122;
        goto L31
    L25:
        r110 = r121;
        goto L27
    L21:
        r104 = r120;
        goto L23
    L17:
        r103 = r119;
        goto L19
    L13:
        r102 = r118;
        goto L15
    L9:
        r101 = r117;
        goto L11
    L5:
        r100 = r116;
        goto L7
    }
}

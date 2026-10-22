package com.bytedance.android.ec.model.sku;

import com.alipay.sdk.m.p.e;
import com.android.ttcjpaysdk.integrated.sign.counter.activity.SignCounterLaunchArgs;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ec.model.BuyNowPreloadParams;
import com.bytedance.android.ec.model.ECAdInfo;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.ec.model.ECBoltParam;
import com.bytedance.android.ec.model.PromotionBenefitLabel;
import com.bytedance.android.ec.model.promotion.ECFindSimilarConfig;
import com.bytedance.android.livesdkapi.paramtransfer.produce.RoomParamsProduceManager;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.Gson;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b;\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\u001e\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010$\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001Bñ\t\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u000101\u0012\b\b\u0002\u00107\u001a\u000206\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010=\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u000106\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010=\u0012\b\b\u0002\u0010J\u001a\u00020\u0004\u0012\b\b\u0002\u0010N\u001a\u00020\u0004\u0012\b\b\u0002\u0010P\u001a\u00020=\u0012\n\b\u0002\u0010R\u001a\u0004\u0018\u000106\u0012\b\b\u0002\u0010T\u001a\u00020\u0004\u0012\n\b\u0002\u0010V\u001a\u0004\u0018\u00010=\u0012\u0006\u0010X\u001a\u00020=\u0012\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010=\u0012\b\b\u0002\u0010\\\u001a\u00020\u0004\u0012\n\b\u0002\u0010]\u001a\u0004\u0018\u00010=\u0012\n\b\u0002\u0010_\u001a\u0004\u0018\u00010=\u0012\b\b\u0002\u0010a\u001a\u00020=\u0012\b\b\u0002\u0010c\u001a\u00020=\u0012\b\b\u0002\u0010e\u001a\u00020=\u0012\n\b\u0002\u0010g\u001a\u0004\u0018\u00010=\u0012\n\b\u0002\u0010i\u001a\u0004\u0018\u00010=\u0012\b\b\u0002\u0010k\u001a\u00020\u0004\u0012\b\b\u0002\u0010l\u001a\u000206\u0012\b\b\u0002\u0010n\u001a\u000206\u0012\n\b\u0002\u0010p\u001a\u0004\u0018\u00010=\u0012\n\b\u0002\u0010s\u001a\u0004\u0018\u00010=\u0012\b\b\u0002\u0010u\u001a\u000206\u0012\n\b\u0002\u0010w\u001a\u0004\u0018\u00010=\u0012\u0010\b\u0002\u0010{\u001a\n\u0012\u0004\u0012\u00020z\u0018\u00010y\u0012\n\b\u0002\u0010\u007f\u001a\u0004\u0018\u00010=\u0012\u000b\b\u0002\u0010\u0081\u0001\u001a\u0004\u0018\u00010=\u0012\u000b\b\u0002\u0010\u0083\u0001\u001a\u0004\u0018\u00010=\u0012\u000b\b\u0002\u0010\u0085\u0001\u001a\u0004\u0018\u000106\u0012\u000b\b\u0002\u0010\u0087\u0001\u001a\u0004\u0018\u00010=\u0012\u000b\b\u0002\u0010\u0089\u0001\u001a\u0004\u0018\u00010=\u0012\u000b\b\u0002\u0010\u008b\u0001\u001a\u0004\u0018\u00010=\u0012\u000b\b\u0002\u0010\u008d\u0001\u001a\u0004\u0018\u00010=\u0012\u000b\b\u0002\u0010\u008f\u0001\u001a\u0004\u0018\u000106\u0012\u000b\b\u0002\u0010\u0091\u0001\u001a\u0004\u0018\u00010=\u0012\f\b\u0002\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0093\u0001\u0012\u000b\b\u0002\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u0004\u0012\u000b\b\u0002\u0010\u009c\u0001\u001a\u0004\u0018\u00010=\u0012\t\b\u0002\u0010\u009e\u0001\u001a\u00020\u0004\u0012\u000b\b\u0002\u0010 \u0001\u001a\u0004\u0018\u000106\u0012\u000b\b\u0002\u0010¢\u0001\u001a\u0004\u0018\u000106\u0012\f\b\u0002\u0010§\u0001\u001a\u0005\u0018\u00010¦\u0001\u0012\u000b\b\u0002\u0010\u00ad\u0001\u001a\u0004\u0018\u000106\u0012\t\b\u0002\u0010°\u0001\u001a\u00020\u0004\u0012\t\b\u0002\u0010³\u0001\u001a\u00020\u0004\u0012\t\b\u0002\u0010µ\u0001\u001a\u00020\u0004\u0012\u000b\b\u0002\u0010¸\u0001\u001a\u0004\u0018\u000106\u0012\u000b\b\u0002\u0010½\u0001\u001a\u0004\u0018\u000106\u0012\u000b\b\u0002\u0010À\u0001\u001a\u0004\u0018\u000106\u0012\u000b\b\u0002\u0010Á\u0001\u001a\u0004\u0018\u00010=\u0012\n\b\u0002\u0010Æ\u0001\u001a\u00030Å\u0001\u0012\u000b\b\u0002\u0010Ê\u0001\u001a\u0004\u0018\u00010\u0004\u0012\f\b\u0002\u0010Í\u0001\u001a\u0005\u0018\u00010Ì\u0001\u0012\f\b\u0002\u0010Ò\u0001\u001a\u0005\u0018\u00010Ñ\u0001\u0012\f\b\u0002\u0010×\u0001\u001a\u0005\u0018\u00010Ö\u0001\u0012\u000b\b\u0002\u0010Û\u0001\u001a\u0004\u0018\u00010=\u0012\u000b\b\u0002\u0010Ý\u0001\u001a\u0004\u0018\u00010=\u0012\u000b\b\u0002\u0010à\u0001\u001a\u0004\u0018\u00010=\u0012\u000b\b\u0002\u0010é\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u0018\b\u0002\u0010ë\u0001\u001a\u0011\u0012\u0004\u0012\u00020=\u0012\u0006\u0012\u0004\u0018\u00010=0ê\u0001\u0012\u000b\b\u0002\u0010ñ\u0001\u001a\u0004\u0018\u00010=\u0012\t\b\u0002\u0010ô\u0001\u001a\u00020=\u0012\u000b\b\u0002\u0010ö\u0001\u001a\u0004\u0018\u00010=\u0012\n\b\u0002\u0010ù\u0001\u001a\u00030¦\u0001\u0012\u0007\u0010ÿ\u0001\u001a\u00020=\u0012\u000b\b\u0002\u0010\u0081\u0002\u001a\u0004\u0018\u00010=\u0012\u000b\b\u0002\u0010\u0083\u0002\u001a\u0004\u0018\u00010=\u0012\u000b\b\u0002\u0010\u0085\u0002\u001a\u0004\u0018\u00010=\u0012\u000b\b\u0002\u0010\u0087\u0002\u001a\u0004\u0018\u00010=\u0012\u000b\b\u0002\u0010\u0089\u0002\u001a\u0004\u0018\u00010=\u0012\t\b\u0002\u0010\u008b\u0002\u001a\u00020\u0004\u0012\u000b\b\u0002\u0010\u008d\u0002\u001a\u0004\u0018\u00010=\u0012\u000b\b\u0002\u0010\u008f\u0002\u001a\u0004\u0018\u00010=\u0012\f\b\u0002\u0010\u0092\u0002\u001a\u0005\u0018\u00010\u0091\u0002\u0012\u000b\b\u0002\u0010\u0096\u0002\u001a\u0004\u0018\u00010=\u0012\u000b\b\u0002\u0010\u0098\u0002\u001a\u0004\u0018\u00010=\u0012\u000b\b\u0002\u0010\u009b\u0002\u001a\u0004\u0018\u00010=\u0012\u0016\b\u0002\u0010\u009d\u0002\u001a\u000f\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020=0ê\u0001\u0012\t\b\u0002\u0010\u009f\u0002\u001a\u000206\u0012\t\b\u0002\u0010¢\u0002\u001a\u000206\u0012\t\b\u0002\u0010¤\u0002\u001a\u00020\u0004\u0012\u000b\b\u0002\u0010§\u0002\u001a\u0004\u0018\u00010=\u0012\t\b\u0002\u0010ª\u0002\u001a\u00020=\u0012\t\b\u0002\u0010¬\u0002\u001a\u00020=\u0012\t\b\u0002\u0010®\u0002\u001a\u00020\u0004\u0012\u000b\b\u0002\u0010¯\u0002\u001a\u0004\u0018\u00010=\u0012\u000b\b\u0002\u0010²\u0002\u001a\u0004\u0018\u00010=\u0012\u000b\b\u0002\u0010µ\u0002\u001a\u0004\u0018\u00010=\u0012\f\b\u0002\u0010¹\u0002\u001a\u0005\u0018\u00010¸\u0002\u0012\u000b\b\u0002\u0010½\u0002\u001a\u0004\u0018\u00010=\u0012\u000b\b\u0002\u0010À\u0002\u001a\u0004\u0018\u00010=\u0012\u000b\b\u0002\u0010Ã\u0002\u001a\u0004\u0018\u00010=\u0012\u000b\b\u0002\u0010Æ\u0002\u001a\u0004\u0018\u00010=¢\u0006\u0006\bÉ\u0002\u0010Ê\u0002J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u0004J\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\u0004J\u0006\u0010\u0014\u001a\u00020\u0004J\u0006\u0010\u0015\u001a\u00020\u0004J\u0006\u0010\u0016\u001a\u00020\u0004J\u0006\u0010\u0017\u001a\u00020\u0004R$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0019\u0010'\u001a\u0004\u0018\u00010&8\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R$\u0010+\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0019\u00102\u001a\u0004\u0018\u0001018\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\"\u00107\u001a\u0002068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R$\u0010>\u001a\u0004\u0018\u00010=8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u0019\u0010D\u001a\u0004\u0018\u0001068\u0006¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u0019\u0010H\u001a\u0004\u0018\u00010=8\u0006¢\u0006\f\n\u0004\bH\u0010?\u001a\u0004\bI\u0010AR\u0017\u0010J\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\u0017\u0010N\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\bN\u0010K\u001a\u0004\bO\u0010MR\u0017\u0010P\u001a\u00020=8\u0006¢\u0006\f\n\u0004\bP\u0010?\u001a\u0004\bQ\u0010AR\u0019\u0010R\u001a\u0004\u0018\u0001068\u0006¢\u0006\f\n\u0004\bR\u0010E\u001a\u0004\bS\u0010GR\u0017\u0010T\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\bT\u0010K\u001a\u0004\bU\u0010MR\u0019\u0010V\u001a\u0004\u0018\u00010=8\u0006¢\u0006\f\n\u0004\bV\u0010?\u001a\u0004\bW\u0010AR\u0017\u0010X\u001a\u00020=8\u0006¢\u0006\f\n\u0004\bX\u0010?\u001a\u0004\bY\u0010AR\u0019\u0010Z\u001a\u0004\u0018\u00010=8\u0006¢\u0006\f\n\u0004\bZ\u0010?\u001a\u0004\b[\u0010AR\u0017\u0010\\\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\\\u0010K\u001a\u0004\b\\\u0010MR\u0019\u0010]\u001a\u0004\u0018\u00010=8\u0006¢\u0006\f\n\u0004\b]\u0010?\u001a\u0004\b^\u0010AR\u0019\u0010_\u001a\u0004\u0018\u00010=8\u0006¢\u0006\f\n\u0004\b_\u0010?\u001a\u0004\b`\u0010AR\u0017\u0010a\u001a\u00020=8\u0006¢\u0006\f\n\u0004\ba\u0010?\u001a\u0004\bb\u0010AR\u0017\u0010c\u001a\u00020=8\u0006¢\u0006\f\n\u0004\bc\u0010?\u001a\u0004\bd\u0010AR\u0017\u0010e\u001a\u00020=8\u0006¢\u0006\f\n\u0004\be\u0010?\u001a\u0004\bf\u0010AR\u0019\u0010g\u001a\u0004\u0018\u00010=8\u0006¢\u0006\f\n\u0004\bg\u0010?\u001a\u0004\bh\u0010AR\u0019\u0010i\u001a\u0004\u0018\u00010=8\u0006¢\u0006\f\n\u0004\bi\u0010?\u001a\u0004\bj\u0010AR\u0017\u0010k\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\bk\u0010K\u001a\u0004\bk\u0010MR\u0017\u0010l\u001a\u0002068\u0006¢\u0006\f\n\u0004\bl\u00108\u001a\u0004\bm\u0010:R\u0017\u0010n\u001a\u0002068\u0006¢\u0006\f\n\u0004\bn\u00108\u001a\u0004\bo\u0010:R$\u0010p\u001a\u0004\u0018\u00010=8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bp\u0010?\u001a\u0004\bq\u0010A\"\u0004\br\u0010CR\u0019\u0010s\u001a\u0004\u0018\u00010=8\u0006¢\u0006\f\n\u0004\bs\u0010?\u001a\u0004\bt\u0010AR\u0017\u0010u\u001a\u0002068\u0006¢\u0006\f\n\u0004\bu\u00108\u001a\u0004\bv\u0010:R\u0019\u0010w\u001a\u0004\u0018\u00010=8\u0006¢\u0006\f\n\u0004\bw\u0010?\u001a\u0004\bx\u0010AR\u001f\u0010{\u001a\n\u0012\u0004\u0012\u00020z\u0018\u00010y8\u0006¢\u0006\f\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~R\u001a\u0010\u007f\u001a\u0004\u0018\u00010=8\u0006¢\u0006\r\n\u0004\b\u007f\u0010?\u001a\u0005\b\u0080\u0001\u0010AR\u001c\u0010\u0081\u0001\u001a\u0004\u0018\u00010=8\u0006¢\u0006\u000e\n\u0005\b\u0081\u0001\u0010?\u001a\u0005\b\u0082\u0001\u0010AR\u001c\u0010\u0083\u0001\u001a\u0004\u0018\u00010=8\u0006¢\u0006\u000e\n\u0005\b\u0083\u0001\u0010?\u001a\u0005\b\u0084\u0001\u0010AR\u001c\u0010\u0085\u0001\u001a\u0004\u0018\u0001068\u0006¢\u0006\u000e\n\u0005\b\u0085\u0001\u0010E\u001a\u0005\b\u0086\u0001\u0010GR\u001c\u0010\u0087\u0001\u001a\u0004\u0018\u00010=8\u0006¢\u0006\u000e\n\u0005\b\u0087\u0001\u0010?\u001a\u0005\b\u0088\u0001\u0010AR\u001c\u0010\u0089\u0001\u001a\u0004\u0018\u00010=8\u0006¢\u0006\u000e\n\u0005\b\u0089\u0001\u0010?\u001a\u0005\b\u008a\u0001\u0010AR\u001c\u0010\u008b\u0001\u001a\u0004\u0018\u00010=8\u0006¢\u0006\u000e\n\u0005\b\u008b\u0001\u0010?\u001a\u0005\b\u008c\u0001\u0010AR\u001c\u0010\u008d\u0001\u001a\u0004\u0018\u00010=8\u0006¢\u0006\u000e\n\u0005\b\u008d\u0001\u0010?\u001a\u0005\b\u008e\u0001\u0010AR\u001c\u0010\u008f\u0001\u001a\u0004\u0018\u0001068\u0006¢\u0006\u000e\n\u0005\b\u008f\u0001\u0010E\u001a\u0005\b\u0090\u0001\u0010GR\u001c\u0010\u0091\u0001\u001a\u0004\u0018\u00010=8\u0006¢\u0006\u000e\n\u0005\b\u0091\u0001\u0010?\u001a\u0005\b\u0092\u0001\u0010AR,\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0093\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0094\u0001\u0010\u0095\u0001\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001\"\u0006\b\u0098\u0001\u0010\u0099\u0001R\u001c\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\u000e\n\u0005\b\u009a\u0001\u0010,\u001a\u0005\b\u009b\u0001\u0010.R\u001c\u0010\u009c\u0001\u001a\u0004\u0018\u00010=8\u0006¢\u0006\u000e\n\u0005\b\u009c\u0001\u0010?\u001a\u0005\b\u009d\u0001\u0010AR\u001a\u0010\u009e\u0001\u001a\u00020\u00048\u0006¢\u0006\u000e\n\u0005\b\u009e\u0001\u0010K\u001a\u0005\b\u009f\u0001\u0010MR\u001c\u0010 \u0001\u001a\u0004\u0018\u0001068\u0006¢\u0006\u000e\n\u0005\b \u0001\u0010E\u001a\u0005\b¡\u0001\u0010GR)\u0010¢\u0001\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b¢\u0001\u0010E\u001a\u0005\b£\u0001\u0010G\"\u0006\b¤\u0001\u0010¥\u0001R,\u0010§\u0001\u001a\u0005\u0018\u00010¦\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b§\u0001\u0010¨\u0001\u001a\u0006\b©\u0001\u0010ª\u0001\"\u0006\b«\u0001\u0010¬\u0001R)\u0010\u00ad\u0001\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b\u00ad\u0001\u0010E\u001a\u0005\b®\u0001\u0010G\"\u0006\b¯\u0001\u0010¥\u0001R'\u0010°\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b°\u0001\u0010K\u001a\u0005\b°\u0001\u0010M\"\u0006\b±\u0001\u0010²\u0001R'\u0010³\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b³\u0001\u0010K\u001a\u0005\b³\u0001\u0010M\"\u0006\b´\u0001\u0010²\u0001R'\u0010µ\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\bµ\u0001\u0010K\u001a\u0005\b¶\u0001\u0010M\"\u0006\b·\u0001\u0010²\u0001R\u001c\u0010¸\u0001\u001a\u0004\u0018\u0001068\u0006¢\u0006\u000e\n\u0005\b¸\u0001\u0010E\u001a\u0005\b¹\u0001\u0010GR)\u0010½\u0001\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\bº\u0001\u0010E\u001a\u0005\b»\u0001\u0010G\"\u0006\b¼\u0001\u0010¥\u0001R\u001c\u0010À\u0001\u001a\u0004\u0018\u0001068\u0006¢\u0006\u000e\n\u0005\b¾\u0001\u0010E\u001a\u0005\b¿\u0001\u0010GR'\u0010Á\u0001\u001a\u0004\u0018\u00010=8\u0006X\u0087\u0004¢\u0006\u0016\n\u0005\bÁ\u0001\u0010?\u0012\u0006\bÃ\u0001\u0010Ä\u0001\u001a\u0005\bÂ\u0001\u0010AR\u001d\u0010Æ\u0001\u001a\u00030Å\u00018\u0006¢\u0006\u0010\n\u0006\bÆ\u0001\u0010Ç\u0001\u001a\u0006\bÈ\u0001\u0010É\u0001R\u001c\u0010Ê\u0001\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\u000e\n\u0005\bÊ\u0001\u0010,\u001a\u0005\bË\u0001\u0010.R\u001f\u0010Í\u0001\u001a\u0005\u0018\u00010Ì\u00018\u0006¢\u0006\u0010\n\u0006\bÍ\u0001\u0010Î\u0001\u001a\u0006\bÏ\u0001\u0010Ð\u0001R\u001f\u0010Ò\u0001\u001a\u0005\u0018\u00010Ñ\u00018\u0006¢\u0006\u0010\n\u0006\bÒ\u0001\u0010Ó\u0001\u001a\u0006\bÔ\u0001\u0010Õ\u0001R\u001f\u0010×\u0001\u001a\u0005\u0018\u00010Ö\u00018\u0006¢\u0006\u0010\n\u0006\b×\u0001\u0010Ø\u0001\u001a\u0006\bÙ\u0001\u0010Ú\u0001R\u001c\u0010Û\u0001\u001a\u0004\u0018\u00010=8\u0006¢\u0006\u000e\n\u0005\bÛ\u0001\u0010?\u001a\u0005\bÜ\u0001\u0010AR(\u0010Ý\u0001\u001a\u0004\u0018\u00010=8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bÝ\u0001\u0010?\u001a\u0005\bÞ\u0001\u0010A\"\u0005\bß\u0001\u0010CR(\u0010à\u0001\u001a\u0004\u0018\u00010=8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bà\u0001\u0010?\u001a\u0005\bá\u0001\u0010A\"\u0005\bâ\u0001\u0010CR+\u0010é\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bã\u0001\u0010ä\u0001\u001a\u0006\bå\u0001\u0010æ\u0001\"\u0006\bç\u0001\u0010è\u0001R8\u0010ë\u0001\u001a\u0011\u0012\u0004\u0012\u00020=\u0012\u0006\u0012\u0004\u0018\u00010=0ê\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bë\u0001\u0010ì\u0001\u001a\u0006\bí\u0001\u0010î\u0001\"\u0006\bï\u0001\u0010ð\u0001R(\u0010ñ\u0001\u001a\u0004\u0018\u00010=8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bñ\u0001\u0010?\u001a\u0005\bò\u0001\u0010A\"\u0005\bó\u0001\u0010CR\u001a\u0010ô\u0001\u001a\u00020=8\u0006¢\u0006\u000e\n\u0005\bô\u0001\u0010?\u001a\u0005\bõ\u0001\u0010AR(\u0010ö\u0001\u001a\u0004\u0018\u00010=8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bö\u0001\u0010?\u001a\u0005\b÷\u0001\u0010A\"\u0005\bø\u0001\u0010CR*\u0010ù\u0001\u001a\u00030¦\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bù\u0001\u0010ú\u0001\u001a\u0006\bû\u0001\u0010ü\u0001\"\u0006\bý\u0001\u0010þ\u0001R\u001a\u0010ÿ\u0001\u001a\u00020=8\u0006¢\u0006\u000e\n\u0005\bÿ\u0001\u0010?\u001a\u0005\b\u0080\u0002\u0010AR\u001c\u0010\u0081\u0002\u001a\u0004\u0018\u00010=8\u0006¢\u0006\u000e\n\u0005\b\u0081\u0002\u0010?\u001a\u0005\b\u0082\u0002\u0010AR\u001c\u0010\u0083\u0002\u001a\u0004\u0018\u00010=8\u0006¢\u0006\u000e\n\u0005\b\u0083\u0002\u0010?\u001a\u0005\b\u0084\u0002\u0010AR\u001c\u0010\u0085\u0002\u001a\u0004\u0018\u00010=8\u0006¢\u0006\u000e\n\u0005\b\u0085\u0002\u0010?\u001a\u0005\b\u0086\u0002\u0010AR\u001c\u0010\u0087\u0002\u001a\u0004\u0018\u00010=8\u0006¢\u0006\u000e\n\u0005\b\u0087\u0002\u0010?\u001a\u0005\b\u0088\u0002\u0010AR\u001c\u0010\u0089\u0002\u001a\u0004\u0018\u00010=8\u0006¢\u0006\u000e\n\u0005\b\u0089\u0002\u0010?\u001a\u0005\b\u008a\u0002\u0010AR\u001a\u0010\u008b\u0002\u001a\u00020\u00048\u0006¢\u0006\u000e\n\u0005\b\u008b\u0002\u0010K\u001a\u0005\b\u008c\u0002\u0010MR\u001c\u0010\u008d\u0002\u001a\u0004\u0018\u00010=8\u0006¢\u0006\u000e\n\u0005\b\u008d\u0002\u0010?\u001a\u0005\b\u008e\u0002\u0010AR\u001c\u0010\u008f\u0002\u001a\u0004\u0018\u00010=8\u0006¢\u0006\u000e\n\u0005\b\u008f\u0002\u0010?\u001a\u0005\b\u0090\u0002\u0010AR\u001f\u0010\u0092\u0002\u001a\u0005\u0018\u00010\u0091\u00028\u0006¢\u0006\u0010\n\u0006\b\u0092\u0002\u0010\u0093\u0002\u001a\u0006\b\u0094\u0002\u0010\u0095\u0002R\u001c\u0010\u0096\u0002\u001a\u0004\u0018\u00010=8\u0006¢\u0006\u000e\n\u0005\b\u0096\u0002\u0010?\u001a\u0005\b\u0097\u0002\u0010AR(\u0010\u0098\u0002\u001a\u0004\u0018\u00010=8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0098\u0002\u0010?\u001a\u0005\b\u0099\u0002\u0010A\"\u0005\b\u009a\u0002\u0010CR\u001c\u0010\u009b\u0002\u001a\u0004\u0018\u00010=8\u0006¢\u0006\u000e\n\u0005\b\u009b\u0002\u0010?\u001a\u0005\b\u009c\u0002\u0010AR)\u0010\u009d\u0002\u001a\u000f\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020=0ê\u00018\u0006¢\u0006\u0010\n\u0006\b\u009d\u0002\u0010ì\u0001\u001a\u0006\b\u009e\u0002\u0010î\u0001R&\u0010\u009f\u0002\u001a\u0002068\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u009f\u0002\u00108\u001a\u0005\b \u0002\u0010:\"\u0005\b¡\u0002\u0010<R\u001a\u0010¢\u0002\u001a\u0002068\u0006¢\u0006\u000e\n\u0005\b¢\u0002\u00108\u001a\u0005\b£\u0002\u0010:R'\u0010¤\u0002\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b¤\u0002\u0010K\u001a\u0005\b¥\u0002\u0010M\"\u0006\b¦\u0002\u0010²\u0001R(\u0010§\u0002\u001a\u0004\u0018\u00010=8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b§\u0002\u0010?\u001a\u0005\b¨\u0002\u0010A\"\u0005\b©\u0002\u0010CR\u001a\u0010ª\u0002\u001a\u00020=8\u0006¢\u0006\u000e\n\u0005\bª\u0002\u0010?\u001a\u0005\b«\u0002\u0010AR\u001a\u0010¬\u0002\u001a\u00020=8\u0006¢\u0006\u000e\n\u0005\b¬\u0002\u0010?\u001a\u0005\b\u00ad\u0002\u0010AR\u001a\u0010®\u0002\u001a\u00020\u00048\u0006¢\u0006\u000e\n\u0005\b®\u0002\u0010K\u001a\u0005\b®\u0002\u0010MR(\u0010¯\u0002\u001a\u0004\u0018\u00010=8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b¯\u0002\u0010?\u001a\u0005\b°\u0002\u0010A\"\u0005\b±\u0002\u0010CR(\u0010²\u0002\u001a\u0004\u0018\u00010=8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b²\u0002\u0010?\u001a\u0005\b³\u0002\u0010A\"\u0005\b´\u0002\u0010CR(\u0010µ\u0002\u001a\u0004\u0018\u00010=8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bµ\u0002\u0010?\u001a\u0005\b¶\u0002\u0010A\"\u0005\b·\u0002\u0010CR\u001f\u0010¹\u0002\u001a\u0005\u0018\u00010¸\u00028\u0006¢\u0006\u0010\n\u0006\b¹\u0002\u0010º\u0002\u001a\u0006\b»\u0002\u0010¼\u0002R(\u0010½\u0002\u001a\u0004\u0018\u00010=8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b½\u0002\u0010?\u001a\u0005\b¾\u0002\u0010A\"\u0005\b¿\u0002\u0010CR(\u0010À\u0002\u001a\u0004\u0018\u00010=8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bÀ\u0002\u0010?\u001a\u0005\bÁ\u0002\u0010A\"\u0005\bÂ\u0002\u0010CR(\u0010Ã\u0002\u001a\u0004\u0018\u00010=8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bÃ\u0002\u0010?\u001a\u0005\bÄ\u0002\u0010A\"\u0005\bÅ\u0002\u0010CR(\u0010Æ\u0002\u001a\u0004\u0018\u00010=8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\bÆ\u0002\u0010?\u001a\u0005\bÇ\u0002\u0010A\"\u0005\bÈ\u0002\u0010C¨\u0006Ë\u0002"}, d2 = {"Lcom/bytedance/android/ec/model/sku/SkuParams;", "Ljava/io/Serializable;", "Lorg/json/JSONObject;", "asJsonDescription", "", "isFromCartOrInsurance", "isFromShopCart", "isFromAnchorV3", "isFromInsuranceApply", "isFromHomePageOneCent", "isFromSuperMarket", "isFromMixPage", "isFromMatchPurchase", "isFromMatchLive", "isFromMatchAnchor", "isFromMatchNoPic", "isFromVideoFeed", "isFromMallFeed", "isFromLiveRoom", "isFromPlayback", "isFrom3D", "isFromLiveAIIM", "isLiveSkuCheck", "isFromProductDetail", "Lcom/bytedance/android/ec/model/sku/DefaultSelect;", "defaultSelect", "Lcom/bytedance/android/ec/model/sku/DefaultSelect;", "getDefaultSelect", "()Lcom/bytedance/android/ec/model/sku/DefaultSelect;", "setDefaultSelect", "(Lcom/bytedance/android/ec/model/sku/DefaultSelect;)V", "Lcom/bytedance/android/ec/model/sku/SkuExtraData;", "skuExtraData", "Lcom/bytedance/android/ec/model/sku/SkuExtraData;", "getSkuExtraData", "()Lcom/bytedance/android/ec/model/sku/SkuExtraData;", "setSkuExtraData", "(Lcom/bytedance/android/ec/model/sku/SkuExtraData;)V", "Lcom/bytedance/android/ec/model/sku/SkuRestoreState;", "skuState", "Lcom/bytedance/android/ec/model/sku/SkuRestoreState;", "getSkuState", "()Lcom/bytedance/android/ec/model/sku/SkuRestoreState;", "createNewActivity", "Ljava/lang/Boolean;", "getCreateNewActivity", "()Ljava/lang/Boolean;", "setCreateNewActivity", "(Ljava/lang/Boolean;)V", "Lcom/bytedance/android/ec/model/BuyNowPreloadParams;", "buyNowPreloadParams", "Lcom/bytedance/android/ec/model/BuyNowPreloadParams;", "getBuyNowPreloadParams", "()Lcom/bytedance/android/ec/model/BuyNowPreloadParams;", "", "roomType", "I", "getRoomType", "()I", "setRoomType", "(I)V", "", "skuLogId", "Ljava/lang/String;", "getSkuLogId", "()Ljava/lang/String;", "setSkuLogId", "(Ljava/lang/String;)V", "roomItemType", "Ljava/lang/Integer;", "getRoomItemType", "()Ljava/lang/Integer;", "promotionLogId", "getPromotionLogId", "preCheckSpecItem", "Z", "getPreCheckSpecItem", "()Z", "usePrerenderSku", "getUsePrerenderSku", "skuPrerenderId", "getSkuPrerenderId", "addCartOptLive", "getAddCartOptLive", "showNotice", "getShowNotice", "productId", "getProductId", "promotionId", "getPromotionId", "commodityType", "getCommodityType", "isMulti", "shopId", "getShopId", "combinationId", "getCombinationId", "authorId", "getAuthorId", "secAuthorId", "getSecAuthorId", "authorOpenId", "getAuthorOpenId", "itemId", "getItemId", "roomId", "getRoomId", "isGroupingBuy", ReportConstant.COMMON_ACTION_TYPE, "getActionType", SignCounterLaunchArgs.EXTRA_SCENE_TYPE, "getSceneType", "selectCarId", "getSelectCarId", "setSelectCarId", "h5Url", "getH5Url", "applyCoupon", "getApplyCoupon", "detailUrl", "getDetailUrl", "", "Lcom/bytedance/android/ec/model/PromotionBenefitLabel;", "benefitLabels", "Ljava/util/List;", "getBenefitLabels", "()Ljava/util/List;", "nGroupBuyToken", "getNGroupBuyToken", "bizIdentifier", "getBizIdentifier", RemoteMessageConst.Notification.CHANNEL_ID, "getChannelId", "channelType", "getChannelType", "enterFrom", "getEnterFrom", "ecomEntranceForm", "getEcomEntranceForm", "productSourcePage", "getProductSourcePage", "bizCampaignType", "getBizCampaignType", "touTiaoAppId", "getTouTiaoAppId", "receiveAddressId", "getReceiveAddressId", "Lcom/bytedance/android/ec/model/sku/SkuPoiInfo;", "poiInfo", "Lcom/bytedance/android/ec/model/sku/SkuPoiInfo;", "getPoiInfo", "()Lcom/bytedance/android/ec/model/sku/SkuPoiInfo;", "setPoiInfo", "(Lcom/bytedance/android/ec/model/sku/SkuPoiInfo;)V", "popOnWindow", "getPopOnWindow", "skuSessionId", "getSkuSessionId", "scrollToDouInstallment", "getScrollToDouInstallment", "termCount", "getTermCount", "specMode", "getSpecMode", "setSpecMode", "(Ljava/lang/Integer;)V", "", "specModeTime", "Ljava/lang/Long;", "getSpecModeTime", "()Ljava/lang/Long;", "setSpecModeTime", "(Ljava/lang/Long;)V", "forceYataSku", "getForceYataSku", "setForceYataSku", "isSplitScreen", "setSplitScreen", "(Z)V", "isSplitScreenOpen", "setSplitScreenOpen", "splitScreenHalfMode", "getSplitScreenHalfMode", "setSplitScreenHalfMode", "panelWidth", "getPanelWidth", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "getHeightPercent", "setHeightPercent", "heightPercent", "b", "getForceHeight", "forceHeight", "maskBackgroundColor", "getMaskBackgroundColor", "getMaskBackgroundColor$annotations", "()V", "", "maskAlpha", FaceService.girlLabel, "getMaskAlpha", "()F", "openWithSass", "getOpenWithSass", "Lcom/bytedance/android/ec/model/ECAdLogExtra;", "adLogExtra", "Lcom/bytedance/android/ec/model/ECAdLogExtra;", "getAdLogExtra", "()Lcom/bytedance/android/ec/model/ECAdLogExtra;", "Lcom/bytedance/android/ec/model/ECBoltParam;", "boltParam", "Lcom/bytedance/android/ec/model/ECBoltParam;", "getBoltParam", "()Lcom/bytedance/android/ec/model/ECBoltParam;", "Lcom/bytedance/android/ec/model/sku/CpsParams;", "cpsParams", "Lcom/bytedance/android/ec/model/sku/CpsParams;", "getCpsParams", "()Lcom/bytedance/android/ec/model/sku/CpsParams;", "cpsTrack", "getCpsTrack", "trackExtra", "getTrackExtra", "setTrackExtra", "entranceInfo", "getEntranceInfo", "setEntranceInfo", "c", "Lorg/json/JSONObject;", "getCouponLogData", "()Lorg/json/JSONObject;", "setCouponLogData", "(Lorg/json/JSONObject;)V", "couponLogData", "", "eventParams", "Ljava/util/Map;", "getEventParams", "()Ljava/util/Map;", "setEventParams", "(Ljava/util/Map;)V", "logData", "getLogData", "setLogData", e.f25671s, "getMethod", "monitorId", "getMonitorId", "setMonitorId", "resumeTime", "J", "getResumeTime", "()J", "setResumeTime", "(J)V", "processMonitorRdTag", "getProcessMonitorRdTag", "ecomGroupType", "getEcomGroupType", "enterFromMerge", "getEnterFromMerge", "sourcePage", "getSourcePage", "enterMethod", "getEnterMethod", "searchParams", "getSearchParams", "addShopCart", "getAddShopCart", "anchorBuyNowLogData", "getAnchorBuyNowLogData", "spellGroupId", "getSpellGroupId", "Lcom/bytedance/android/ec/model/ECAdInfo;", "latestRecommendFeedAdInfo", "Lcom/bytedance/android/ec/model/ECAdInfo;", "getLatestRecommendFeedAdInfo", "()Lcom/bytedance/android/ec/model/ECAdInfo;", "v3EventAdditions", "getV3EventAdditions", "transmissibleJson", "getTransmissibleJson", "setTransmissibleJson", "skuLogExtra", "getSkuLogExtra", "liveEventParams", "getLiveEventParams", "addToastType", "getAddToastType", "setAddToastType", "standardAddCartToastType", "getStandardAddCartToastType", "enableAddCartFailToastForSchema", "getEnableAddCartFailToastForSchema", "setEnableAddCartFailToastForSchema", "addCartEntranceInfo", "getAddCartEntranceInfo", "setAddCartEntranceInfo", "originType", "getOriginType", "originId", "getOriginId", "isSchemaOpen", "addressDetail", "getAddressDetail", "setAddressDetail", "extraParams", "getExtraParams", "setExtraParams", "eventSessionId", "getEventSessionId", "setEventSessionId", "Lcom/bytedance/android/ec/model/sku/SkuOrderParams;", "orderParams", "Lcom/bytedance/android/ec/model/sku/SkuOrderParams;", "getOrderParams", "()Lcom/bytedance/android/ec/model/sku/SkuOrderParams;", "diffTag", "getDiffTag", "setDiffTag", "uniqueId", "getUniqueId", "setUniqueId", "warehouseListID", "getWarehouseListID", "setWarehouseListID", "liveShopMode", "getLiveShopMode", "setLiveShopMode", "<init>", "(Lcom/bytedance/android/ec/model/sku/DefaultSelect;Lcom/bytedance/android/ec/model/sku/SkuExtraData;Lcom/bytedance/android/ec/model/sku/SkuRestoreState;Ljava/lang/Boolean;Lcom/bytedance/android/ec/model/BuyNowPreloadParams;ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/Integer;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZIILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/bytedance/android/ec/model/sku/SkuPoiInfo;Ljava/lang/Boolean;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;ZZZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;FLjava/lang/Boolean;Lcom/bytedance/android/ec/model/ECAdLogExtra;Lcom/bytedance/android/ec/model/ECBoltParam;Lcom/bytedance/android/ec/model/sku/CpsParams;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/model/ECAdInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;IIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/model/sku/SkuOrderParams;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class SkuParams implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Integer f47966a;
    private final int actionType;
    private final ECAdLogExtra adLogExtra;
    private String addCartEntranceInfo;
    private final Integer addCartOptLive;
    private final boolean addShopCart;
    private int addToastType;
    private String addressDetail;
    private final String anchorBuyNowLogData;
    private final int applyCoupon;
    private final String authorId;
    private final String authorOpenId;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final transient Integer f47967b;
    private final List<PromotionBenefitLabel> benefitLabels;
    private final String bizCampaignType;
    private final String bizIdentifier;
    private final ECBoltParam boltParam;
    private final BuyNowPreloadParams buyNowPreloadParams;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient JSONObject f47968c;
    private final String channelId;
    private final Integer channelType;
    private final String combinationId;
    private final String commodityType;
    private final CpsParams cpsParams;
    private final String cpsTrack;
    private Boolean createNewActivity;
    private DefaultSelect defaultSelect;
    private final String detailUrl;
    private String diffTag;
    private final String ecomEntranceForm;
    private final String ecomGroupType;
    private boolean enableAddCartFailToastForSchema;
    private final String enterFrom;
    private final String enterFromMerge;
    private final String enterMethod;
    private String entranceInfo;
    private Map<String, String> eventParams;
    private String eventSessionId;
    private String extraParams;
    private Integer forceYataSku;
    private final String h5Url;
    private final boolean isGroupingBuy;
    private final boolean isMulti;
    private final boolean isSchemaOpen;
    private boolean isSplitScreen;
    private boolean isSplitScreenOpen;
    private final String itemId;
    private final ECAdInfo latestRecommendFeedAdInfo;
    private final Map<String, String> liveEventParams;
    private String liveShopMode;
    private String logData;
    private final float maskAlpha;
    private final String maskBackgroundColor;
    private final String method;
    private String monitorId;
    private final String nGroupBuyToken;
    private final Boolean openWithSass;
    private final SkuOrderParams orderParams;
    private final String originId;
    private final String originType;
    private final Integer panelWidth;
    private SkuPoiInfo poiInfo;
    private final Boolean popOnWindow;
    private final boolean preCheckSpecItem;
    private final String processMonitorRdTag;
    private final String productId;
    private final String productSourcePage;
    private final String promotionId;
    private final String promotionLogId;
    private final String receiveAddressId;
    private long resumeTime;
    private final String roomId;
    private final Integer roomItemType;
    private int roomType;
    private final int sceneType;
    private final boolean scrollToDouInstallment;
    private final String searchParams;
    private final String secAuthorId;
    private String selectCarId;
    private final String shopId;
    private final boolean showNotice;
    private SkuExtraData skuExtraData;
    private final String skuLogExtra;
    private String skuLogId;
    private final String skuPrerenderId;
    private final String skuSessionId;
    private final SkuRestoreState skuState;
    private final String sourcePage;
    private Integer specMode;
    private Long specModeTime;
    private final String spellGroupId;
    private boolean splitScreenHalfMode;
    private final int standardAddCartToastType;
    private final Integer termCount;
    private final Integer touTiaoAppId;
    private String trackExtra;
    private String transmissibleJson;
    private String uniqueId;
    private final boolean usePrerenderSku;
    private final String v3EventAdditions;
    private String warehouseListID;

    @Deprecated(message = "Android蒙层对自定义颜色适配有问题，采用dim方案，用&mask_alpha=0.5")
    public static /* synthetic */ void getMaskBackgroundColor$annotations() {
    }

    public final boolean isFromProductDetail() {
        return CollectionsKt.listOf(new Integer[]{101, 102}).contains(Integer.valueOf(this.sceneType));
    }

    public final JSONObject asJsonDescription() {
        JSONObject r100 = new JSONObject();
        DefaultSelect r101 = this.defaultSelect;
        JSONObject r102 = null;
        if (r101 == null) goto L5;
        JSONObject r103 = r101.asJSONDescription();
    L6:
        r100.put("default_select", r103);
        SkuExtraData r104 = this.skuExtraData;
        if (r104 == null) goto L9;
        JSONObject r105 = r104.asJSONDescription();
    L10:
        r100.put("sku_extra_data", r105);
        r100.put("sku_state", this.skuState);
        r100.put("create_new_activity", this.createNewActivity);
        BuyNowPreloadParams r106 = this.buyNowPreloadParams;
        if (r106 == null) goto L13;
        JSONObject r107 = r106.asJSONDescription();
    L14:
        r100.put("buy_now_preload_params", r107);
        r100.put(IPerformanceManager.Params.room_type, this.roomType);
        r100.put("sku_log_id", this.skuLogId);
        r100.put("room_item_type", this.roomItemType);
        r100.put("promotion_log_id", this.promotionLogId);
        r100.put("pre_check_spec_item", this.preCheckSpecItem);
        r100.put("use_prerender_sku", this.usePrerenderSku);
        r100.put("sku_prerender_id", this.skuPrerenderId);
        r100.put("add_cart_opt_live", this.addCartOptLive);
        r100.put("show_notice", this.showNotice);
        r100.put("product_id", this.productId);
        r100.put("promotion_id", this.promotionId);
        r100.put(a.KEY_COMMODITY_TYPE, this.commodityType);
        r100.put("is_multi", this.isMulti);
        r100.put(a.KEY_SHOP_ID, this.shopId);
        r100.put(a.KEY_COMBINATION_ID, this.combinationId);
        r100.put("author_id", this.authorId);
        r100.put("sec_author_id", this.secAuthorId);
        r100.put("author_open_id", this.authorOpenId);
        r100.put("item_id", this.itemId);
        r100.put("room_id", this.roomId);
        r100.put("is_grouping_buy", this.isGroupingBuy);
        r100.put("action_type", this.actionType);
        r100.put("scene_type", this.sceneType);
        r100.put("select_car_id", this.selectCarId);
        r100.put("h5_url", this.h5Url);
        r100.put("apply_coupon", this.applyCoupon);
        r100.put("detail_url", this.detailUrl);
        r100.put("benefit_labels", this.benefitLabels);
        r100.put("channel_id", this.channelId);
        r100.put(WsConstants.KEY_CHANNEL_TYPE, this.channelType);
        r100.put("enter_from", this.enterFrom);
        r100.put(a.KEY_ECOM_ENTRANCE_FORM, this.ecomEntranceForm);
        r100.put(a.KEY_PRODUCT_SOURCE_PAGE, this.productSourcePage);
        r100.put("receive_address_id", this.receiveAddressId);
        r100.put("pop_on_window", this.popOnWindow);
        r100.put("sku_session_id", this.skuSessionId);
        r100.put("scroll_to_dou_installment", this.scrollToDouInstallment);
        r100.put("term_count", this.termCount);
        r100.put("spec_mode", this.specMode);
        r100.put("spec_mode_time", this.specModeTime);
        r100.put("panel_width", this.panelWidth);
        r100.put(ECFindSimilarConfig.HEIGHT_PERCENT, this.f47966a);
        r100.put("mask_background_color", this.maskBackgroundColor);
        r100.put("mask_alpha", Float.valueOf(this.maskAlpha));
        r100.put("open_with_saas", this.openWithSass);
        r100.put(PdpOpenThirdParam.KEY_AD_LOG_EXTRA, GsonProtectorUtils.toJson(new Gson(), this.adLogExtra));
        r100.put("bolt_param", GsonProtectorUtils.toJson(new Gson(), this.boltParam));
        r100.put("cps_params", GsonProtectorUtils.toJson(new Gson(), this.cpsParams));
        r100.put("cps_track", this.cpsTrack);
        r100.put("track_extra", this.trackExtra);
        r100.put(a.KEY_ENTRANCE_INFO, this.entranceInfo);
        r100.put("eventParams", new JSONObject(this.eventParams));
        r100.put("log_data", this.logData);
        r100.put("monitor_id", this.monitorId);
        r100.put("resume_time", this.resumeTime);
        r100.put(e.f25671s, this.method);
        r100.put(a.KEY_ECOM_GROUP_TYPE, this.ecomGroupType);
        r100.put("enter_from_merge", this.enterFromMerge);
        r100.put("source_page", this.sourcePage);
        r100.put("enter_method", this.enterMethod);
        r100.put("search_params", this.searchParams);
        r100.put("add_shop_cart", this.addShopCart);
        r100.put("anchor_buy_now_log_data", this.anchorBuyNowLogData);
        r100.put("spell_group_id", this.spellGroupId);
        ECAdInfo r108 = this.latestRecommendFeedAdInfo;
        if (r108 == null) goto L17;
        r102 = r108.asJSONDescription();
    L17:
        r100.put("latest_recommend_feed_ad_info", r102);
        r100.put("v3_event_additions", this.v3EventAdditions);
        r100.put("transmissible_json", this.transmissibleJson);
        r100.put("sku_log_extra", this.skuLogExtra);
        r100.put(RoomParamsProduceManager.BRAND_EVENT, new JSONObject(this.liveEventParams));
        r100.put("add_toast_type", this.addToastType);
        r100.put("add_cart_entrance_info", this.addCartEntranceInfo);
        r100.put(a.KEY_ORIGIN_TYPE, this.originType);
        r100.put(a.KEY_ORIGIN_ID, this.originId);
        r100.put("is_schema_open", this.isSchemaOpen);
        r100.put("extra_params", this.extraParams);
        r100.put("event_session_id", this.eventSessionId);
        return r100;
    L13:
        r107 = null;
        goto L14
    L9:
        r105 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    public final boolean isFrom3D() {
        if (this.sceneType != 601) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isFromAnchorV3() {
        int r100 = this.sceneType;
        if (r100 != 101) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 102) goto L8;
        return false;
    }

    public final boolean isFromHomePageOneCent() {
        if (this.sceneType != 1101) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isFromInsuranceApply() {
        if (this.sceneType != 1001) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isFromLiveAIIM() {
        if (this.sceneType != 6302) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isFromLiveRoom() {
        if (this.sceneType != 201) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isFromMallFeed() {
        if (this.sceneType != 302) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isFromMatchAnchor() {
        if (this.sceneType != 701) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isFromMatchLive() {
        if (this.sceneType != 702) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isFromMatchNoPic() {
        if (this.sceneType != 703) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isFromMixPage() {
        if (this.sceneType != 1301) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isFromPlayback() {
        if (this.sceneType != 202) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isFromShopCart() {
        if (this.sceneType != 901) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isFromSuperMarket() {
        if (this.sceneType != 1201) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isFromVideoFeed() {
        if (this.sceneType != 301) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isFromCartOrInsurance() {
        if (isFromShopCart() == false) goto L5;
    L8:
        return true;
    L5:
        if (isFromInsuranceApply() == true) goto L8;
        return false;
    }

    public final boolean isFromMatchPurchase() {
        if (isFromMatchLive() == false) goto L5;
    L10:
        return true;
    L5:
        if (isFromMatchAnchor() == true) goto L10;
        if (isFromMatchNoPic() == true) goto L10;
        return false;
    }

    public final boolean isLiveSkuCheck() {
        if (isFromPlayback() == false) goto L5;
    L10:
        return true;
    L5:
        if (isFromLiveRoom() == true) goto L10;
        if (isFromLiveAIIM() == true) goto L10;
        return false;
    }

    public final int getActionType() {
        return this.actionType;
    }

    public final ECAdLogExtra getAdLogExtra() {
        return this.adLogExtra;
    }

    public final String getAddCartEntranceInfo() {
        return this.addCartEntranceInfo;
    }

    public final Integer getAddCartOptLive() {
        return this.addCartOptLive;
    }

    public final boolean getAddShopCart() {
        return this.addShopCart;
    }

    public final int getAddToastType() {
        return this.addToastType;
    }

    public final String getAddressDetail() {
        return this.addressDetail;
    }

    public final String getAnchorBuyNowLogData() {
        return this.anchorBuyNowLogData;
    }

    public final int getApplyCoupon() {
        return this.applyCoupon;
    }

    public final String getAuthorId() {
        return this.authorId;
    }

    public final String getAuthorOpenId() {
        return this.authorOpenId;
    }

    public final List<PromotionBenefitLabel> getBenefitLabels() {
        return this.benefitLabels;
    }

    public final String getBizCampaignType() {
        return this.bizCampaignType;
    }

    public final String getBizIdentifier() {
        return this.bizIdentifier;
    }

    public final ECBoltParam getBoltParam() {
        return this.boltParam;
    }

    public final BuyNowPreloadParams getBuyNowPreloadParams() {
        return this.buyNowPreloadParams;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final Integer getChannelType() {
        return this.channelType;
    }

    public final String getCombinationId() {
        return this.combinationId;
    }

    public final String getCommodityType() {
        return this.commodityType;
    }

    public final JSONObject getCouponLogData() {
        return this.f47968c;
    }

    public final CpsParams getCpsParams() {
        return this.cpsParams;
    }

    public final String getCpsTrack() {
        return this.cpsTrack;
    }

    public final Boolean getCreateNewActivity() {
        return this.createNewActivity;
    }

    public final DefaultSelect getDefaultSelect() {
        return this.defaultSelect;
    }

    public final String getDetailUrl() {
        return this.detailUrl;
    }

    public final String getDiffTag() {
        return this.diffTag;
    }

    public final String getEcomEntranceForm() {
        return this.ecomEntranceForm;
    }

    public final String getEcomGroupType() {
        return this.ecomGroupType;
    }

    public final boolean getEnableAddCartFailToastForSchema() {
        return this.enableAddCartFailToastForSchema;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final String getEnterFromMerge() {
        return this.enterFromMerge;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final String getEntranceInfo() {
        return this.entranceInfo;
    }

    public final Map<String, String> getEventParams() {
        return this.eventParams;
    }

    public final String getEventSessionId() {
        return this.eventSessionId;
    }

    public final String getExtraParams() {
        return this.extraParams;
    }

    public final Integer getForceHeight() {
        return this.f47967b;
    }

    public final Integer getForceYataSku() {
        return this.forceYataSku;
    }

    public final String getH5Url() {
        return this.h5Url;
    }

    public final Integer getHeightPercent() {
        return this.f47966a;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final ECAdInfo getLatestRecommendFeedAdInfo() {
        return this.latestRecommendFeedAdInfo;
    }

    public final Map<String, String> getLiveEventParams() {
        return this.liveEventParams;
    }

    public final String getLiveShopMode() {
        return this.liveShopMode;
    }

    public final String getLogData() {
        return this.logData;
    }

    public final float getMaskAlpha() {
        return this.maskAlpha;
    }

    public final String getMaskBackgroundColor() {
        return this.maskBackgroundColor;
    }

    public final String getMethod() {
        return this.method;
    }

    public final String getMonitorId() {
        return this.monitorId;
    }

    public final String getNGroupBuyToken() {
        return this.nGroupBuyToken;
    }

    public final Boolean getOpenWithSass() {
        return this.openWithSass;
    }

    public final SkuOrderParams getOrderParams() {
        return this.orderParams;
    }

    public final String getOriginId() {
        return this.originId;
    }

    public final String getOriginType() {
        return this.originType;
    }

    public final Integer getPanelWidth() {
        return this.panelWidth;
    }

    public final SkuPoiInfo getPoiInfo() {
        return this.poiInfo;
    }

    public final Boolean getPopOnWindow() {
        return this.popOnWindow;
    }

    public final boolean getPreCheckSpecItem() {
        return this.preCheckSpecItem;
    }

    public final String getProcessMonitorRdTag() {
        return this.processMonitorRdTag;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getProductSourcePage() {
        return this.productSourcePage;
    }

    public final String getPromotionId() {
        return this.promotionId;
    }

    public final String getPromotionLogId() {
        return this.promotionLogId;
    }

    public final String getReceiveAddressId() {
        return this.receiveAddressId;
    }

    public final long getResumeTime() {
        return this.resumeTime;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final Integer getRoomItemType() {
        return this.roomItemType;
    }

    public final int getRoomType() {
        return this.roomType;
    }

    public final int getSceneType() {
        return this.sceneType;
    }

    public final boolean getScrollToDouInstallment() {
        return this.scrollToDouInstallment;
    }

    public final String getSearchParams() {
        return this.searchParams;
    }

    public final String getSecAuthorId() {
        return this.secAuthorId;
    }

    public final String getSelectCarId() {
        return this.selectCarId;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final boolean getShowNotice() {
        return this.showNotice;
    }

    public final SkuExtraData getSkuExtraData() {
        return this.skuExtraData;
    }

    public final String getSkuLogExtra() {
        return this.skuLogExtra;
    }

    public final String getSkuLogId() {
        return this.skuLogId;
    }

    public final String getSkuPrerenderId() {
        return this.skuPrerenderId;
    }

    public final String getSkuSessionId() {
        return this.skuSessionId;
    }

    public final SkuRestoreState getSkuState() {
        return this.skuState;
    }

    public final String getSourcePage() {
        return this.sourcePage;
    }

    public final Integer getSpecMode() {
        return this.specMode;
    }

    public final Long getSpecModeTime() {
        return this.specModeTime;
    }

    public final String getSpellGroupId() {
        return this.spellGroupId;
    }

    public final boolean getSplitScreenHalfMode() {
        return this.splitScreenHalfMode;
    }

    public final int getStandardAddCartToastType() {
        return this.standardAddCartToastType;
    }

    public final Integer getTermCount() {
        return this.termCount;
    }

    public final Integer getTouTiaoAppId() {
        return this.touTiaoAppId;
    }

    public final String getTrackExtra() {
        return this.trackExtra;
    }

    public final String getTransmissibleJson() {
        return this.transmissibleJson;
    }

    public final String getUniqueId() {
        return this.uniqueId;
    }

    public final boolean getUsePrerenderSku() {
        return this.usePrerenderSku;
    }

    public final String getV3EventAdditions() {
        return this.v3EventAdditions;
    }

    public final String getWarehouseListID() {
        return this.warehouseListID;
    }

    public final boolean isGroupingBuy() {
        return this.isGroupingBuy;
    }

    public final boolean isMulti() {
        return this.isMulti;
    }

    public final boolean isSchemaOpen() {
        return this.isSchemaOpen;
    }

    public final boolean isSplitScreen() {
        return this.isSplitScreen;
    }

    public final boolean isSplitScreenOpen() {
        return this.isSplitScreenOpen;
    }

    public final void setAddCartEntranceInfo(String r100) {
        this.addCartEntranceInfo = r100;
    }

    public final void setAddToastType(int r100) {
        this.addToastType = r100;
    }

    public final void setAddressDetail(String r100) {
        this.addressDetail = r100;
    }

    public final void setCouponLogData(JSONObject r100) {
        this.f47968c = r100;
    }

    public final void setCreateNewActivity(Boolean r100) {
        this.createNewActivity = r100;
    }

    public final void setDefaultSelect(DefaultSelect r100) {
        this.defaultSelect = r100;
    }

    public final void setDiffTag(String r100) {
        this.diffTag = r100;
    }

    public final void setEnableAddCartFailToastForSchema(boolean r100) {
        this.enableAddCartFailToastForSchema = r100;
    }

    public final void setEntranceInfo(String r100) {
        this.entranceInfo = r100;
    }

    public final void setEventParams(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.eventParams = r100;
    }

    public final void setEventSessionId(String r100) {
        this.eventSessionId = r100;
    }

    public final void setExtraParams(String r100) {
        this.extraParams = r100;
    }

    public final void setForceYataSku(Integer r100) {
        this.forceYataSku = r100;
    }

    public final void setHeightPercent(Integer r100) {
        this.f47966a = r100;
    }

    public final void setLiveShopMode(String r100) {
        this.liveShopMode = r100;
    }

    public final void setLogData(String r100) {
        this.logData = r100;
    }

    public final void setMonitorId(String r100) {
        this.monitorId = r100;
    }

    public final void setPoiInfo(SkuPoiInfo r100) {
        this.poiInfo = r100;
    }

    public final void setResumeTime(long r100) {
        this.resumeTime = r100;
    }

    public final void setRoomType(int r100) {
        this.roomType = r100;
    }

    public final void setSelectCarId(String r100) {
        this.selectCarId = r100;
    }

    public final void setSkuExtraData(SkuExtraData r100) {
        this.skuExtraData = r100;
    }

    public final void setSkuLogId(String r100) {
        this.skuLogId = r100;
    }

    public final void setSpecMode(Integer r100) {
        this.specMode = r100;
    }

    public final void setSpecModeTime(Long r100) {
        this.specModeTime = r100;
    }

    public final void setSplitScreen(boolean r100) {
        this.isSplitScreen = r100;
    }

    public final void setSplitScreenHalfMode(boolean r100) {
        this.splitScreenHalfMode = r100;
    }

    public final void setSplitScreenOpen(boolean r100) {
        this.isSplitScreenOpen = r100;
    }

    public final void setTrackExtra(String r100) {
        this.trackExtra = r100;
    }

    public final void setTransmissibleJson(String r100) {
        this.transmissibleJson = r100;
    }

    public final void setUniqueId(String r100) {
        this.uniqueId = r100;
    }

    public final void setWarehouseListID(String r100) {
        this.warehouseListID = r100;
    }

    public SkuParams(DefaultSelect r110, SkuExtraData r111, SkuRestoreState r112, Boolean r113, BuyNowPreloadParams r114, int r115, String r210, Integer r211, String r212, boolean r213, boolean r214, String r215, Integer r216, boolean r217, String r218, String r219, String r310, boolean r311, String r312, String r313, String r314, String r315, String r316, String r317, String r318, boolean r319, int r410, int r411, String r412, String r413, int r414, String r415, List<PromotionBenefitLabel> r416, String r417, String r418, String r419, Integer r510, String r511, String r512, String r513, String r514, Integer r515, String r516, SkuPoiInfo r517, Boolean r518, String r519, boolean r610, Integer r611, Integer r612, Long r613, Integer r614, boolean r615, boolean r616, boolean r617, Integer r618, Integer r619, Integer r710, String r711, float r712, Boolean r713, ECAdLogExtra r714, ECBoltParam r715, CpsParams r716, String r717, String r718, String r719, JSONObject r810, Map<String, String> r811, String r812, String r813, String r814, long r815, String r816, String r817, String r818, String r910, String r911, String r912, boolean r913, String r914, String r915, ECAdInfo r916, String r917, String r918, String r919, Map<String, String> r100, int r101, int r102, boolean r103, String r104, String r105, String r106, boolean r107, String r108, String r109, String r116, SkuOrderParams r117, String r118, String r119, String r1110, String r1111) {
        Intrinsics.checkNotNullParameter(r215, "skuPrerenderId");
        Intrinsics.checkNotNullParameter(r219, "promotionId");
        Intrinsics.checkNotNullParameter(r314, "authorId");
        Intrinsics.checkNotNullParameter(r315, "secAuthorId");
        Intrinsics.checkNotNullParameter(r316, "authorOpenId");
        Intrinsics.checkNotNullParameter(r811, "eventParams");
        Intrinsics.checkNotNullParameter(r813, e.f25671s);
        Intrinsics.checkNotNullParameter(r816, "processMonitorRdTag");
        Intrinsics.checkNotNullParameter(r100, "liveEventParams");
        Intrinsics.checkNotNullParameter(r105, "originType");
        Intrinsics.checkNotNullParameter(r106, "originId");
        this.defaultSelect = r110;
        this.skuExtraData = r111;
        this.skuState = r112;
        this.createNewActivity = r113;
        this.buyNowPreloadParams = r114;
        this.roomType = r115;
        this.skuLogId = r210;
        this.roomItemType = r211;
        this.promotionLogId = r212;
        this.preCheckSpecItem = r213;
        this.usePrerenderSku = r214;
        this.skuPrerenderId = r215;
        this.addCartOptLive = r216;
        this.showNotice = r217;
        this.productId = r218;
        this.promotionId = r219;
        this.commodityType = r310;
        this.isMulti = r311;
        this.shopId = r312;
        this.combinationId = r313;
        this.authorId = r314;
        this.secAuthorId = r315;
        this.authorOpenId = r316;
        this.itemId = r317;
        this.roomId = r318;
        this.isGroupingBuy = r319;
        this.actionType = r410;
        this.sceneType = r411;
        this.selectCarId = r412;
        this.h5Url = r413;
        this.applyCoupon = r414;
        this.detailUrl = r415;
        this.benefitLabels = r416;
        this.nGroupBuyToken = r417;
        this.bizIdentifier = r418;
        this.channelId = r419;
        this.channelType = r510;
        this.enterFrom = r511;
        this.ecomEntranceForm = r512;
        this.productSourcePage = r513;
        this.bizCampaignType = r514;
        this.touTiaoAppId = r515;
        this.receiveAddressId = r516;
        this.poiInfo = r517;
        this.popOnWindow = r518;
        this.skuSessionId = r519;
        this.scrollToDouInstallment = r610;
        this.termCount = r611;
        this.specMode = r612;
        this.specModeTime = r613;
        this.forceYataSku = r614;
        this.isSplitScreen = r615;
        this.isSplitScreenOpen = r616;
        this.splitScreenHalfMode = r617;
        this.panelWidth = r618;
        this.f47966a = r619;
        this.f47967b = r710;
        this.maskBackgroundColor = r711;
        this.maskAlpha = r712;
        this.openWithSass = r713;
        this.adLogExtra = r714;
        this.boltParam = r715;
        this.cpsParams = r716;
        this.cpsTrack = r717;
        this.trackExtra = r718;
        this.entranceInfo = r719;
        this.f47968c = r810;
        this.eventParams = r811;
        this.logData = r812;
        this.method = r813;
        this.monitorId = r814;
        this.resumeTime = r815;
        this.processMonitorRdTag = r816;
        this.ecomGroupType = r817;
        this.enterFromMerge = r818;
        this.sourcePage = r910;
        this.enterMethod = r911;
        this.searchParams = r912;
        this.addShopCart = r913;
        this.anchorBuyNowLogData = r914;
        this.spellGroupId = r915;
        this.latestRecommendFeedAdInfo = r916;
        this.v3EventAdditions = r917;
        this.transmissibleJson = r918;
        this.skuLogExtra = r919;
        this.liveEventParams = r100;
        this.addToastType = r101;
        this.standardAddCartToastType = r102;
        this.enableAddCartFailToastForSchema = r103;
        this.addCartEntranceInfo = r104;
        this.originType = r105;
        this.originId = r106;
        this.isSchemaOpen = r107;
        this.addressDetail = r108;
        this.extraParams = r109;
        this.eventSessionId = r116;
        this.orderParams = r117;
        this.diffTag = r118;
        this.uniqueId = r119;
        this.warehouseListID = r1110;
        this.liveShopMode = r1111;
    }

    public /* synthetic */ SkuParams(DefaultSelect r109, SkuExtraData r110, SkuRestoreState r111, Boolean r112, BuyNowPreloadParams r113, int r114, String r115, Integer r116, String r117, boolean r118, boolean r119, String r120, Integer r121, boolean r122, String r123, String r124, String r125, boolean r126, String r127, String r128, String r129, String r130, String r131, String r132, String r133, boolean r134, int r135, int r136, String r137, String r138, int r139, String r140, List r141, String r142, String r143, String r144, Integer r145, String r146, String r147, String r148, String r149, Integer r150, String r151, SkuPoiInfo r152, Boolean r153, String r154, boolean r155, Integer r156, Integer r157, Long r158, Integer r159, boolean r160, boolean r161, boolean r162, Integer r163, Integer r164, Integer r165, String r166, float r167, Boolean r168, ECAdLogExtra r169, ECBoltParam r170, CpsParams r171, String r172, String r173, String r174, JSONObject r175, Map r176, String r177, String r178, String r179, long r180, String r182, String r183, String r184, String r185, String r186, String r187, boolean r188, String r189, String r190, ECAdInfo r191, String r192, String r193, String r194, Map r195, int r196, int r197, boolean r198, String r199, String r200, String r201, boolean r202, String r203, String r204, String r205, SkuOrderParams r206, String r207, String r208, String r209, String r210, int r211, int r212, int r213, int r214, DefaultConstructorMarker r215) {
        if ((r211 & 1) == 0) goto L5;
        DefaultSelect r100 = null;
    L7:
        if ((r211 & 2) == 0) goto L9;
        SkuExtraData r101 = null;
    L11:
        if ((r211 & 4) == 0) goto L13;
        SkuRestoreState r102 = null;
    L15:
        if ((r211 & 8) == 0) goto L17;
        Boolean r103 = Boolean.FALSE;
    L19:
        if ((r211 & 16) == 0) goto L21;
        BuyNowPreloadParams r181 = null;
    L23:
        if ((r211 & 32) == 0) goto L25;
        int r1100 = -1;
    L27:
        if ((r211 & 64) == 0) goto L29;
        String r1101 = null;
    L31:
        if ((r211 & 128) == 0) goto L33;
        Integer r1102 = null;
    L35:
        if ((r211 & 256) == 0) goto L37;
        String r1103 = null;
    L39:
        if ((r211 & 512) == 0) goto L41;
        boolean r1104 = false;
    L43:
        if ((r211 & 1024) == 0) goto L45;
        boolean r1105 = false;
    L47:
        if ((r211 & 2048) == 0) goto L49;
        String r104 = "";
    L51:
        if ((r211 & 4096) == 0) goto L53;
        Integer r1106 = 0;
    L55:
        if ((r211 & 8192) == 0) goto L57;
        boolean r1107 = false;
    L59:
        if ((r211 & 16384) == 0) goto L61;
        String r216 = null;
    L63:
        if ((r211 & 65536) == 0) goto L65;
        String r217 = null;
    L67:
        if ((r211 & 131072) == 0) goto L69;
        boolean r218 = true;
    L71:
        if ((r211 & 262144) == 0) goto L73;
        String r219 = null;
    L75:
        if ((r211 & 524288) == 0) goto L77;
        String r220 = null;
    L79:
        if ((r211 & 1048576) == 0) goto L81;
        String r221 = "";
    L83:
        if ((r211 & 2097152) == 0) goto L85;
        String r310 = "";
    L87:
        if ((r211 & 4194304) == 0) goto L89;
        String r311 = "";
    L91:
        if ((r211 & 8388608) == 0) goto L93;
        String r312 = null;
    L95:
        if ((r211 & 16777216) == 0) goto L97;
        String r313 = null;
    L99:
        if ((r211 & 33554432) == 0) goto L101;
        boolean r314 = false;
    L103:
        if ((r211 & 67108864) == 0) goto L105;
        int r315 = 0;
    L107:
        if ((r211 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L109;
        int r316 = 0;
    L111:
        if ((r211 & 268435456) == 0) goto L113;
        String r317 = null;
    L115:
        if ((r211 & 536870912) == 0) goto L117;
        String r318 = null;
    L119:
        if ((r211 & 1073741824) == 0) goto L121;
        int r319 = 0;
    L123:
        if ((r211 & Integer.MIN_VALUE) == 0) goto L125;
        String r105 = null;
    L127:
        if ((r212 & 1) == 0) goto L129;
        List r410 = null;
    L131:
        if ((r212 & 2) == 0) goto L133;
        String r411 = null;
    L135:
        if ((r212 & 4) == 0) goto L137;
        String r412 = null;
    L139:
        if ((r212 & 8) == 0) goto L141;
        String r413 = null;
    L143:
        if ((r212 & 16) == 0) goto L145;
        Integer r414 = 0;
    L147:
        if ((r212 & 32) == 0) goto L149;
        String r415 = null;
    L151:
        if ((r212 & 64) == 0) goto L153;
        String r416 = null;
    L155:
        if ((r212 & 128) == 0) goto L157;
        String r106 = null;
    L159:
        if ((r212 & 256) == 0) goto L161;
        String r417 = null;
    L163:
        if ((r212 & 512) == 0) goto L165;
        Integer r418 = 0;
    L167:
        if ((r212 & 1024) == 0) goto L169;
        String r419 = null;
    L171:
        if ((r212 & 2048) == 0) goto L173;
        SkuPoiInfo r510 = null;
    L175:
        if ((r212 & 4096) == 0) goto L177;
        Boolean r511 = null;
    L179:
        if ((r212 & 8192) == 0) goto L181;
        String r512 = null;
    L183:
        if ((r212 & 16384) == 0) goto L185;
        boolean r513 = false;
    L187:
        if ((32768 & r212) == 0) goto L189;
        Integer r514 = 0;
    L191:
        if ((r212 & 65536) == 0) goto L193;
        Integer r515 = null;
    L195:
        if ((r212 & 131072) == 0) goto L197;
        Long r516 = null;
    L199:
        if ((r212 & 262144) == 0) goto L201;
        Integer r517 = 0;
    L203:
        if ((r212 & 524288) == 0) goto L205;
        boolean r518 = false;
    L207:
        if ((r212 & 1048576) == 0) goto L209;
        boolean r519 = false;
    L211:
        if ((2097152 & r212) == 0) goto L213;
        boolean r610 = false;
    L215:
        if ((4194304 & r212) == 0) goto L217;
        Integer r611 = null;
    L219:
        if ((8388608 & r212) == 0) goto L221;
        int r107 = 0;
        Integer r612 = 0;
    L223:
        if ((r212 & 16777216) == 0) goto L225;
        Integer r613 = Integer.valueOf(r107);
    L227:
        if ((r212 & 33554432) == 0) goto L229;
        String r614 = null;
    L231:
        if ((r212 & 67108864) == 0) goto L233;
        float r615 = 0.5f;
    L235:
        if ((r212 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L237;
        Boolean r616 = null;
    L239:
        if ((r212 & 268435456) == 0) goto L241;
        ECAdLogExtra r617 = null;
    L243:
        if ((r212 & 536870912) == 0) goto L245;
        ECBoltParam r618 = null;
    L247:
        if ((r212 & 1073741824) == 0) goto L249;
        CpsParams r619 = null;
    L251:
        if ((r212 & Integer.MIN_VALUE) == 0) goto L253;
        String r108 = null;
    L255:
        if ((r213 & 1) == 0) goto L257;
        String r710 = null;
    L259:
        if ((r213 & 2) == 0) goto L261;
        String r711 = null;
    L263:
        if ((r213 & 4) == 0) goto L265;
        JSONObject r712 = null;
    L267:
        if ((r213 & 8) == 0) goto L269;
        Map r713 = MapsKt.emptyMap();
    L271:
        if ((r213 & 16) == 0) goto L273;
        String r714 = null;
    L275:
        if ((r213 & 32) == 0) goto L277;
        String r715 = "";
    L279:
        if ((r213 & 64) == 0) goto L281;
        String r716 = null;
    L283:
        if ((r213 & 128) == 0) goto L285;
        long r717 = 0;
    L287:
        if ((r213 & 512) == 0) goto L289;
        String r810 = null;
    L291:
        if ((r213 & 1024) == 0) goto L293;
        String r811 = null;
    L295:
        if ((r213 & 2048) == 0) goto L297;
        String r812 = null;
    L299:
        if ((r213 & 4096) == 0) goto L301;
        String r813 = null;
    L303:
        if ((r213 & 8192) == 0) goto L305;
        String r814 = null;
    L307:
        if ((r213 & 16384) == 0) goto L309;
        boolean r815 = false;
    L311:
        if ((32768 & r213) == 0) goto L313;
        int r222 = 65536;
        String r816 = null;
    L315:
        if ((r222 & r213) == 0) goto L317;
        String r817 = null;
    L319:
        if ((r213 & 131072) == 0) goto L321;
        ECAdInfo r818 = null;
    L323:
        if ((r213 & 262144) == 0) goto L325;
        String r819 = null;
    L327:
        if ((r213 & 524288) == 0) goto L329;
        String r910 = null;
    L331:
        if ((r213 & 1048576) == 0) goto L333;
        String r911 = null;
    L335:
        if ((2097152 & r213) == 0) goto L337;
        Map r912 = MapsKt.emptyMap();
    L339:
        if ((4194304 & r213) == 0) goto L341;
        int r913 = 0;
    L343:
        if ((8388608 & r213) == 0) goto L345;
        int r914 = 0;
    L347:
        if ((16777216 & r213) == 0) goto L349;
        boolean r915 = false;
    L351:
        if ((33554432 & r213) == 0) goto L353;
        String r916 = null;
    L355:
        if ((67108864 & r213) == 0) goto L357;
        String r917 = "";
    L359:
        if ((134217728 & r213) == 0) goto L361;
        String r918 = "";
    L363:
        if ((268435456 & r213) == 0) goto L365;
        boolean r919 = false;
    L367:
        if ((536870912 & r213) == 0) goto L369;
        String r1010 = null;
    L371:
        if ((1073741824 & r213) == 0) goto L373;
        String r1011 = null;
    L375:
        if ((r213 & Integer.MIN_VALUE) == 0) goto L377;
        String r1012 = null;
    L379:
        if ((r214 & 1) == 0) goto L381;
        SkuOrderParams r1013 = null;
    L383:
        if ((r214 & 2) == 0) goto L385;
        String r1014 = null;
    L387:
        if ((r214 & 4) == 0) goto L389;
        String r1015 = null;
    L391:
        if ((r214 & 8) == 0) goto L393;
        String r1016 = null;
    L395:
        if ((r214 & 16) == 0) goto L397;
        String r1017 = null;
    L398:
        this(r100, r101, r102, r103, r181, r1100, r1101, r1102, r1103, r1104, r1105, r104, r1106, r1107, r216, r124, r217, r218, r219, r220, r221, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r105, r410, r411, r412, r413, r414, r415, r416, r106, r417, r418, r419, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r108, r710, r711, r712, r713, r714, r715, r716, r717, r182, r810, r811, r812, r813, r814, r815, r816, r817, r818, r819, r910, r911, r912, r913, r914, r915, r916, r917, r918, r919, r1010, r1011, r1012, r1013, r1014, r1015, r1016, r1017);
        return;
    L397:
        r1017 = r210;
        goto L398
    L393:
        r1016 = r209;
        goto L395
    L389:
        r1015 = r208;
        goto L391
    L385:
        r1014 = r207;
        goto L387
    L381:
        r1013 = r206;
        goto L383
    L377:
        r1012 = r205;
        goto L379
    L373:
        r1011 = r204;
        goto L375
    L369:
        r1010 = r203;
        goto L371
    L365:
        r919 = r202;
        goto L367
    L361:
        r918 = r201;
        goto L363
    L357:
        r917 = r200;
        goto L359
    L353:
        r916 = r199;
        goto L355
    L349:
        r915 = r198;
        goto L351
    L345:
        r914 = r197;
        goto L347
    L341:
        r913 = r196;
        goto L343
    L337:
        r912 = r195;
        goto L339
    L333:
        r911 = r194;
        goto L335
    L329:
        r910 = r193;
        goto L331
    L325:
        r819 = r192;
        goto L327
    L321:
        r818 = r191;
        goto L323
    L317:
        r817 = r190;
        goto L319
    L313:
        r816 = r189;
        r222 = 65536;
        goto L315
    L309:
        r815 = r188;
        goto L311
    L305:
        r814 = r187;
        goto L307
    L301:
        r813 = r186;
        goto L303
    L297:
        r812 = r185;
        goto L299
    L293:
        r811 = r184;
        goto L295
    L289:
        r810 = r183;
        goto L291
    L285:
        r717 = r180;
        goto L287
    L281:
        r716 = r179;
        goto L283
    L277:
        r715 = r178;
        goto L279
    L273:
        r714 = r177;
        goto L275
    L269:
        r713 = r176;
        goto L271
    L265:
        r712 = r175;
        goto L267
    L261:
        r711 = r174;
        goto L263
    L257:
        r710 = r173;
        goto L259
    L253:
        r108 = r172;
        goto L255
    L249:
        r619 = r171;
        goto L251
    L245:
        r618 = r170;
        goto L247
    L241:
        r617 = r169;
        goto L243
    L237:
        r616 = r168;
        goto L239
    L233:
        r615 = r167;
        goto L235
    L229:
        r614 = r166;
        goto L231
    L225:
        r613 = r165;
        goto L227
    L221:
        r107 = 0;
        r612 = r164;
        goto L223
    L217:
        r611 = r163;
        goto L219
    L213:
        r610 = r162;
        goto L215
    L209:
        r519 = r161;
        goto L211
    L205:
        r518 = r160;
        goto L207
    L201:
        r517 = r159;
        goto L203
    L197:
        r516 = r158;
        goto L199
    L193:
        r515 = r157;
        goto L195
    L189:
        r514 = r156;
        goto L191
    L185:
        r513 = r155;
        goto L187
    L181:
        r512 = r154;
        goto L183
    L177:
        r511 = r153;
        goto L179
    L173:
        r510 = r152;
        goto L175
    L169:
        r419 = r151;
        goto L171
    L165:
        r418 = r150;
        goto L167
    L161:
        r417 = r149;
        goto L163
    L157:
        r106 = r148;
        goto L159
    L153:
        r416 = r147;
        goto L155
    L149:
        r415 = r146;
        goto L151
    L145:
        r414 = r145;
        goto L147
    L141:
        r413 = r144;
        goto L143
    L137:
        r412 = r143;
        goto L139
    L133:
        r411 = r142;
        goto L135
    L129:
        r410 = r141;
        goto L131
    L125:
        r105 = r140;
        goto L127
    L121:
        r319 = r139;
        goto L123
    L117:
        r318 = r138;
        goto L119
    L113:
        r317 = r137;
        goto L115
    L109:
        r316 = r136;
        goto L111
    L105:
        r315 = r135;
        goto L107
    L101:
        r314 = r134;
        goto L103
    L97:
        r313 = r133;
        goto L99
    L93:
        r312 = r132;
        goto L95
    L89:
        r311 = r131;
        goto L91
    L85:
        r310 = r130;
        goto L87
    L81:
        r221 = r129;
        goto L83
    L77:
        r220 = r128;
        goto L79
    L73:
        r219 = r127;
        goto L75
    L69:
        r218 = r126;
        goto L71
    L65:
        r217 = r125;
        goto L67
    L61:
        r216 = r123;
        goto L63
    L57:
        r1107 = r122;
        goto L59
    L53:
        r1106 = r121;
        goto L55
    L49:
        r104 = r120;
        goto L51
    L45:
        r1105 = r119;
        goto L47
    L41:
        r1104 = r118;
        goto L43
    L37:
        r1103 = r117;
        goto L39
    L33:
        r1102 = r116;
        goto L35
    L29:
        r1101 = r115;
        goto L31
    L25:
        r1100 = r114;
        goto L27
    L21:
        r181 = r113;
        goto L23
    L17:
        r103 = r112;
        goto L19
    L13:
        r102 = r111;
        goto L15
    L9:
        r101 = r110;
        goto L11
    L5:
        r100 = r109;
        goto L7
    }
}

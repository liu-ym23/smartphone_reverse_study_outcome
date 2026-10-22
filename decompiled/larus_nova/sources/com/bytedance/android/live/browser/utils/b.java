package com.bytedance.android.live.browser.utils;

import androidx.exifinterface.media.ExifInterface;
import com.amap.api.col.s.ce;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.dtf.face.config.IConstValues;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.tencent.qqmusic.third.api.contract.Keys;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\u0012\n\u0002\u0010\u0007\n\u0002\b}\n\u0002\u0010\u000b\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\t¢\u0006\u0006\bï\u0001\u0010ð\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001c\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0004\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\"\u0010'\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\"\u0010*\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u001d\u001a\u0004\b+\u0010\u001e\"\u0004\b,\u0010 R\"\u0010-\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010\u0004\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\"\u00100\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010\u0004\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR\"\u00103\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010\u0004\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\bR\"\u00106\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u0010\u0004\u001a\u0004\b7\u0010\u0006\"\u0004\b8\u0010\bR\"\u00109\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b9\u0010\u0004\u001a\u0004\b:\u0010\u0006\"\u0004\b;\u0010\bR\"\u0010<\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b<\u0010\u0004\u001a\u0004\b=\u0010\u0006\"\u0004\b>\u0010\bR\"\u0010@\u001a\u00020?8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\"\u0010F\u001a\u00020?8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bF\u0010A\u001a\u0004\bG\u0010C\"\u0004\bH\u0010ER\"\u0010I\u001a\u00020?8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bI\u0010A\u001a\u0004\bJ\u0010C\"\u0004\bK\u0010ER0\u0010M\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010L8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\"\u0010S\u001a\u00020?8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bS\u0010A\u001a\u0004\bT\u0010C\"\u0004\bU\u0010ER0\u0010V\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010L8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bV\u0010N\u001a\u0004\bW\u0010P\"\u0004\bX\u0010RR\"\u0010Y\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bY\u0010\u0004\u001a\u0004\bZ\u0010\u0006\"\u0004\b[\u0010\bR\"\u0010\\\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\\\u0010\u0004\u001a\u0004\b]\u0010\u0006\"\u0004\b^\u0010\bR\"\u0010`\u001a\u00020_8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b`\u0010/\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u001a\u0010e\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\be\u0010\u0004\u001a\u0004\bf\u0010\u0006R\"\u0010g\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bg\u0010\u001d\u001a\u0004\bh\u0010\u001e\"\u0004\bi\u0010 R\"\u0010j\u001a\u00020_8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bj\u0010/\u001a\u0004\bk\u0010b\"\u0004\bl\u0010dR\"\u0010m\u001a\u00020_8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bm\u0010/\u001a\u0004\bn\u0010b\"\u0004\bo\u0010dR\"\u0010p\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bp\u0010\u001d\u001a\u0004\bq\u0010\u001e\"\u0004\br\u0010 R\"\u0010s\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bs\u0010\u001d\u001a\u0004\bt\u0010\u001e\"\u0004\bu\u0010 R\"\u0010v\u001a\u00020_8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bv\u0010/\u001a\u0004\bw\u0010b\"\u0004\bx\u0010dR\"\u0010y\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\by\u0010\u001d\u001a\u0004\by\u0010\u001e\"\u0004\b\u001d\u0010 R\"\u0010z\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bz\u0010\u001d\u001a\u0004\b{\u0010\u001e\"\u0004\b|\u0010 R\"\u0010}\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b}\u0010\u001d\u001a\u0004\b}\u0010\u001e\"\u0004\b~\u0010 R$\u0010\u007f\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0004\b\u007f\u0010\u001d\u001a\u0005\b\u0080\u0001\u0010\u001e\"\u0005\b\u0081\u0001\u0010 R\u001d\u0010\u0082\u0001\u001a\u00020\u00028\u0006X\u0087D¢\u0006\u000e\n\u0005\b\u0082\u0001\u0010\u0004\u001a\u0005\b\u0083\u0001\u0010\u0006R&\u0010\u0084\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0084\u0001\u0010\u0004\u001a\u0005\b\u0085\u0001\u0010\u0006\"\u0005\b\u0086\u0001\u0010\bR&\u0010\u0087\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0087\u0001\u0010\u0004\u001a\u0005\b\u0088\u0001\u0010\u0006\"\u0005\b\u0089\u0001\u0010\bR&\u0010\u008a\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u008a\u0001\u0010\u0004\u001a\u0005\b\u008b\u0001\u0010\u0006\"\u0005\b\u008c\u0001\u0010\bR&\u0010\u008d\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u008d\u0001\u0010\u0004\u001a\u0005\b\u008e\u0001\u0010\u0006\"\u0005\b\u008f\u0001\u0010\bR&\u0010\u0090\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0090\u0001\u0010\u0004\u001a\u0005\b\u0091\u0001\u0010\u0006\"\u0005\b\u0092\u0001\u0010\bR&\u0010\u0093\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0093\u0001\u0010\u0004\u001a\u0005\b\u0094\u0001\u0010\u0006\"\u0005\b\u0095\u0001\u0010\bR&\u0010\u0096\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0096\u0001\u0010\u0004\u001a\u0005\b\u0097\u0001\u0010\u0006\"\u0005\b\u0098\u0001\u0010\bR&\u0010\u0099\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u0099\u0001\u0010\u0004\u001a\u0005\b\u009a\u0001\u0010\u0006\"\u0005\b\u009b\u0001\u0010\bR&\u0010\u009c\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u009c\u0001\u0010\u0004\u001a\u0005\b\u009d\u0001\u0010\u0006\"\u0005\b\u009e\u0001\u0010\bR&\u0010\u009f\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b\u009f\u0001\u0010\u0004\u001a\u0005\b \u0001\u0010\u0006\"\u0005\b¡\u0001\u0010\bR&\u0010¢\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b¢\u0001\u0010\u0004\u001a\u0005\b£\u0001\u0010\u0006\"\u0005\b¤\u0001\u0010\bR&\u0010¥\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b¥\u0001\u0010\u0004\u001a\u0005\b¦\u0001\u0010\u0006\"\u0005\b§\u0001\u0010\bR&\u0010¨\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b¨\u0001\u0010\u0004\u001a\u0005\b©\u0001\u0010\u0006\"\u0005\bª\u0001\u0010\bR&\u0010«\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b«\u0001\u0010\u0004\u001a\u0005\b¬\u0001\u0010\u0006\"\u0005\b\u00ad\u0001\u0010\bR&\u0010®\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b®\u0001\u0010\u0004\u001a\u0005\b¯\u0001\u0010\u0006\"\u0005\b°\u0001\u0010\bR&\u0010±\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b±\u0001\u0010\u0004\u001a\u0005\b²\u0001\u0010\u0006\"\u0005\b³\u0001\u0010\bR&\u0010´\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b´\u0001\u0010\u0004\u001a\u0005\bµ\u0001\u0010\u0006\"\u0005\b¶\u0001\u0010\bR&\u0010·\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b·\u0001\u0010\u0004\u001a\u0005\b¸\u0001\u0010\u0006\"\u0005\b¹\u0001\u0010\bR&\u0010º\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bº\u0001\u0010\u0004\u001a\u0005\b»\u0001\u0010\u0006\"\u0005\b¼\u0001\u0010\bR&\u0010½\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\b½\u0001\u0010\u0004\u001a\u0005\b¾\u0001\u0010\u0006\"\u0005\b¿\u0001\u0010\bR&\u0010À\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÀ\u0001\u0010\u0004\u001a\u0005\bÁ\u0001\u0010\u0006\"\u0005\bÂ\u0001\u0010\bR&\u0010Ã\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÃ\u0001\u0010\u0004\u001a\u0005\bÄ\u0001\u0010\u0006\"\u0005\bÅ\u0001\u0010\bR&\u0010Æ\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÆ\u0001\u0010\u0004\u001a\u0005\bÇ\u0001\u0010\u0006\"\u0005\bÈ\u0001\u0010\bR&\u0010É\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÉ\u0001\u0010\u0004\u001a\u0005\bÊ\u0001\u0010\u0006\"\u0005\bË\u0001\u0010\bR&\u0010Ì\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÌ\u0001\u0010\u0004\u001a\u0005\bÍ\u0001\u0010\u0006\"\u0005\bÎ\u0001\u0010\bR&\u0010Ï\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÏ\u0001\u0010\u0004\u001a\u0005\bÐ\u0001\u0010\u0006\"\u0005\bÑ\u0001\u0010\bR&\u0010Ò\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÒ\u0001\u0010\u0004\u001a\u0005\bÓ\u0001\u0010\u0006\"\u0005\bÔ\u0001\u0010\bR&\u0010Õ\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÕ\u0001\u0010\u0004\u001a\u0005\bÖ\u0001\u0010\u0006\"\u0005\b×\u0001\u0010\bR&\u0010Ø\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bØ\u0001\u0010\u0004\u001a\u0005\bØ\u0001\u0010\u0006\"\u0005\bÙ\u0001\u0010\bR&\u0010Ú\u0001\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bÚ\u0001\u0010\u0004\u001a\u0005\bÛ\u0001\u0010\u0006\"\u0005\bÜ\u0001\u0010\bR)\u0010Þ\u0001\u001a\u00030Ý\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0017\n\u0005\bÞ\u0001\u0010r\u001a\u0006\bÞ\u0001\u0010ß\u0001\"\u0006\bà\u0001\u0010á\u0001R\u001f\u0010â\u0001\u001a\u00030Ý\u00018\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\bâ\u0001\u0010r\u001a\u0006\bâ\u0001\u0010ß\u0001R(\u0010ã\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bã\u0001\u0010\u0004\u001a\u0005\bä\u0001\u0010\u0006\"\u0005\bå\u0001\u0010\bR4\u0010æ\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010L8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bæ\u0001\u0010N\u001a\u0005\bç\u0001\u0010P\"\u0005\bè\u0001\u0010RR&\u0010é\u0001\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bé\u0001\u0010\u001d\u001a\u0005\bê\u0001\u0010\u001e\"\u0005\bë\u0001\u0010 R&\u0010ì\u0001\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0015\n\u0005\bì\u0001\u0010\u001d\u001a\u0005\bí\u0001\u0010\u001e\"\u0005\bî\u0001\u0010 ¨\u0006ñ\u0001"}, d2 = {"Lcom/bytedance/android/live/browser/utils/b;", "", "", "channel", "Ljava/lang/String;", "getChannel", "()Ljava/lang/String;", "l", "(Ljava/lang/String;)V", "aid", "getAid", "d", "appName", "getAppName", ce.f26391f, "appTheme", "getAppTheme", "h", RuleConditionBean.VERSION_CODE_KEY, "getVersionCode", "k0", "updateVersionCode", "getUpdateVersionCode", "h0", "webcastSdkVersion", "getWebcastSdkVersion", "p0", "", "isTeenMode", "I", "()I", "f0", "(I)V", "location", "getLocation", ExifInterface.LONGITUDE_EAST, "containerID", "getContainerID", "m", "initTimestamp", "getInitTimestamp", "B", OperationName.OPERATION_OFFLINE_AVAILABLE, "getOffline", "K", "lynxVersion", "getLynxVersion", FaceService.girlLabel, "userID", "getUserID", "i0", "secUserID", "getSecUserID", "b0", "anchorID", "getAnchorID", "e", "secAnchorID", "getSecAnchorID", "a0", "roomID", "getRoomID", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/google/gson/JsonObject;", "settings", "Lcom/google/gson/JsonObject;", "getSettings", "()Lcom/google/gson/JsonObject;", "c0", "(Lcom/google/gson/JsonObject;)V", "activitySettings", "getActivitySettings", "b", "dynamicSettings", "getDynamicSettings", "u", "", "abParams", "Ljava/util/Map;", "getAbParams", "()Ljava/util/Map;", "setAbParams", "(Ljava/util/Map;)V", "queryItems", "getQueryItems", "R", "injectJson", "getInjectJson", "C", "openUDid", "getOpenUDid", "L", "deviceId", "getDeviceId", "q", "", "systemFontScale", "getSystemFontScale", "()F", "e0", "(F)V", "devicePlatform", "getDevicePlatform", "orientation", "getOrientation", "M", "screenWidth", "getScreenWidth", "Y", "screenHeight", "getScreenHeight", ExifInterface.LONGITUDE_WEST, "screenWidthPx", "getScreenWidthPx", "Z", "screenHeightPx", "getScreenHeightPx", "X", "statusBarHeight", "getStatusBarHeight", "d0", "isNotch", PerfLog.TAG_PERF, "getPerf", "Q", "isPad", "P", "padOptType", "getPadOptType", "setPadOptType", "os", "getOs", "osVersion", "getOsVersion", "O", TTVideoEngineInterface.PLAY_API_KEY_AC, "getAc", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "currentNetworkQualityInfo", "getCurrentNetworkQualityInfo", "o", "webcastLocale", "getWebcastLocale", "o0", "webcastGpsAccess", "getWebcastGpsAccess", Keys.API_PARAM_KEY_M0, "language", "getLanguage", "D", "webcastLanguage", "getWebcastLanguage", "n0", IConstValues.DEVICE_TYPE, "getDeviceType", "s", "deviceScore", "getDeviceScore", "r", "veDeviceScore", "getVeDeviceScore", "j0", "deviceBrand", "getDeviceBrand", "p", WsConstants.KEY_INSTALL_ID, "getIid", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "minorStatus", "getMinorStatus", FaceService.neutralLabel, "osApi", "getOsApi", "N", "fakeRegion", "getFakeRegion", "x", "hostAbi", "getHostAbi", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "cpuSupport64", "getCpuSupport64", OfficeSDKRequestTag.KEY_NEW_USER, "resolution", "getResolution", ExifInterface.LATITUDE_SOUTH, "ts", "getTs", "g0", "manifestVersionCode", "getManifestVersionCode", "G", "oaid", "getOaid", "J", "cdid", "getCdid", ce.f26396k, "appType", "getAppType", RXScreenCaptureService.KEY_INDEX, "dpi", "getDpi", "t", "effectChannel", "getEffectChannel", "w", "versionName", "getVersionName", "l0", "addressBookAccess", "getAddressBookAccess", "c", "rticket", "getRticket", "U", "isAndroidPad", "f", "saasWebcastAppId", "getSaasWebcastAppId", "V", "", "isLiveSaas", "()Z", "setLiveSaas", "(Z)V", "isLiveSaasFullFuse", "ecHostAppId", "getEcHostAppId", BaseSwitches.V, "feParamExtra", "getFeParamExtra", "y", "bottomBarHeight", "getBottomBarHeight", ce.f26395j, "webcastVersion", "getWebcastVersion", "setWebcastVersion", "<init>", "()V", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName(AppConstants.BUNDLE_ACTIVITY_AB_PARAMS_KEYS)
    private Map<String, ? extends Object> abParams;

    /* JADX INFO: renamed from: ac, reason: collision with root package name */
    @SerializedName(TTVideoEngineInterface.PLAY_API_KEY_AC)
    private String f64302ac;

    @SerializedName("activity_setting")
    private JsonObject activitySettings;

    @SerializedName("address_book_access")
    private String addressBookAccess;

    @SerializedName("aid")
    private String aid;

    @SerializedName("anchor_id")
    private String anchorID;

    @SerializedName("app_name")
    private String appName;

    @SerializedName("appTheme")
    private String appTheme;

    @SerializedName("app_type")
    private String appType;

    @SerializedName("bottom_bar_height")
    private int bottomBarHeight;

    @SerializedName("cdid")
    private String cdid;

    @SerializedName("channel")
    private String channel;

    @SerializedName("containerID")
    private String containerID;

    @SerializedName("cpu_support64")
    private String cpuSupport64;

    @SerializedName("current_network_quality_info")
    private String currentNetworkQualityInfo;

    @SerializedName("device_brand")
    private String deviceBrand;

    @SerializedName("device_id")
    private String deviceId;

    @SerializedName("device_platform")
    private final String devicePlatform;

    @SerializedName("device_score")
    private String deviceScore;

    @SerializedName("device_type")
    private String deviceType;

    @SerializedName("dpi")
    private String dpi;

    @SerializedName(AppConstants.BUNDLE_ACTIVITY_DYNAMIC_SETTINGS_KEYS)
    private JsonObject dynamicSettings;

    @SerializedName("ecom_host_appid")
    private String ecHostAppId;

    @SerializedName("effect_channel")
    private String effectChannel;

    @SerializedName("fake_region")
    private String fakeRegion;

    @SerializedName("fe_param_extra")
    private Map<String, String> feParamExtra;

    @SerializedName("host_abi")
    private String hostAbi;

    @SerializedName(WsConstants.KEY_INSTALL_ID)
    private String iid;

    @SerializedName("initTimestamp")
    private String initTimestamp;

    @SerializedName("inject_json")
    private Map<String, ? extends Object> injectJson;

    @SerializedName("is_android_pad")
    private String isAndroidPad;

    @SerializedName("is_live_saas")
    private boolean isLiveSaas;

    @SerializedName("is_live_saas_full_fuse")
    private final boolean isLiveSaasFullFuse;

    @SerializedName("is_notch")
    private int isNotch;

    @SerializedName("is_pad")
    private int isPad;

    @SerializedName("isTeenMode")
    private int isTeenMode;

    @SerializedName("language")
    private String language;

    @SerializedName("location")
    private String location;

    @SerializedName("lynx_version")
    private String lynxVersion;

    @SerializedName("manifest_version_code")
    private String manifestVersionCode;

    @SerializedName("minor_status")
    private String minorStatus;

    @SerializedName("oaid")
    private String oaid;

    @SerializedName(OperationName.OPERATION_OFFLINE_AVAILABLE)
    private int offline;

    @SerializedName("openudid")
    private String openUDid;

    @SerializedName("orientation")
    private int orientation;

    /* JADX INFO: renamed from: os, reason: collision with root package name */
    @SerializedName("os")
    private final String f64303os;

    @SerializedName("os_api")
    private String osApi;

    @SerializedName("os_version")
    private String osVersion;

    @SerializedName("pad_opt_type")
    private int padOptType;

    @SerializedName(PerfLog.TAG_PERF)
    private int perf;

    @SerializedName("queryItems")
    private JsonObject queryItems;

    @SerializedName("resolution")
    private String resolution;

    @SerializedName("room_id")
    private String roomID;

    @SerializedName("_rticket")
    private String rticket;

    @SerializedName("saas_webcast_app_id")
    private String saasWebcastAppId;

    @SerializedName("screenHeight")
    private float screenHeight;

    @SerializedName("screenHeightPx")
    private int screenHeightPx;

    @SerializedName("screenWidth")
    private float screenWidth;

    @SerializedName("screenWidthPx")
    private int screenWidthPx;

    @SerializedName("sec_anchor_id")
    private String secAnchorID;

    @SerializedName("sec_user_id")
    private String secUserID;

    @SerializedName("settings")
    private JsonObject settings;

    @SerializedName("status_bar_height")
    private float statusBarHeight;

    @SerializedName("systemFontScale")
    private float systemFontScale;

    /* JADX INFO: renamed from: ts, reason: collision with root package name */
    @SerializedName("ts")
    private String f64304ts;

    @SerializedName("update_version_code")
    private String updateVersionCode;

    @SerializedName("user_id")
    private String userID;

    @SerializedName("ve_device_score")
    private String veDeviceScore;

    @SerializedName("version_code")
    private String versionCode;

    @SerializedName("version_name")
    private String versionName;

    @SerializedName("webcast_gps_access")
    private String webcastGpsAccess;

    @SerializedName("webcast_language")
    private String webcastLanguage;

    @SerializedName("webcast_locale")
    private String webcastLocale;

    @SerializedName("webcast_sdk_version")
    private String webcastSdkVersion;

    @SerializedName("webcast_version")
    private int webcastVersion;

    public final String toString() {
        return "GlobalPropsParams(channel='" + this.channel + "', aid='" + this.aid + "', appName='" + this.appName + "', appTheme='" + this.appTheme + "', versionCode='" + this.versionCode + "', updateVersionCode='" + this.updateVersionCode + "', webcastSdkVersion='" + this.webcastSdkVersion + "', isTeenMode=" + this.isTeenMode + ", location='" + this.location + "', containerID='" + this.containerID + "', initTimestamp='" + this.initTimestamp + "', offline=" + this.offline + ", lynxVersion='" + this.lynxVersion + "', userID='" + this.userID + "', secUserID='" + this.secUserID + "', anchorID='" + this.anchorID + "', secAnchorID='" + this.secAnchorID + "', roomID='" + this.roomID + "', settings=" + this.settings + ", queryItems=" + this.queryItems + ", injectJson=" + this.injectJson + ", openUDid='" + this.openUDid + "', deviceId='" + this.deviceId + "', devicePlatform='" + this.devicePlatform + "', orientation=" + this.orientation + ", screenWidth=" + this.screenWidth + ", screenHeight=" + this.screenHeight + ", screenWidthPx=" + this.screenWidthPx + ", screenHeightPx=" + this.screenHeightPx + ", statusBarHeight=" + this.statusBarHeight + ", isNotch=" + this.isNotch + ", perf=" + this.perf + ", isPad=" + this.isPad + ", padOptType=" + this.padOptType + ", os='" + this.f64303os + "', osVersion='" + this.osVersion + "', ac='" + this.f64302ac + "', currentNetworkQualityInfo='" + this.currentNetworkQualityInfo + "', webcastLocale='" + this.webcastLocale + "', webcastGpsAccess='" + this.webcastGpsAccess + "', language='" + this.language + "', webcastLanguage='" + this.webcastLanguage + "', deviceType='" + this.deviceType + "', deviceBrand='" + this.deviceBrand + "', iid='" + this.iid + "', minorStatus='" + this.minorStatus + "', osApi='" + this.osApi + "', fakeRegion='" + this.fakeRegion + "', hostAbi='" + this.hostAbi + "', cpuSupport64='" + this.cpuSupport64 + "', resolution='" + this.resolution + "', ts='" + this.f64304ts + "', manifestVersionCode='" + this.manifestVersionCode + "', oaid='" + this.oaid + "', cdid='" + this.cdid + "', appType='" + this.appType + "', dpi='" + this.dpi + "', effectChannel='" + this.effectChannel + "', versionName='" + this.versionName + "', addressBookAccess='" + this.addressBookAccess + "', rticket='" + this.rticket + "', isAndroidPad='" + this.isAndroidPad + "', saasWebcastAppId='" + this.saasWebcastAppId + "', bottomBarHeight=" + this.bottomBarHeight + ", webcastVersion=" + this.webcastVersion + ", ecHostAppId=" + this.ecHostAppId + ')';
    }

    public b() {
        this.channel = "";
        this.aid = "";
        this.appName = "";
        this.appTheme = "";
        this.versionCode = "";
        this.updateVersionCode = "";
        this.webcastSdkVersion = "";
        this.isTeenMode = -1;
        this.location = "";
        this.containerID = "-1";
        this.initTimestamp = "";
        this.lynxVersion = "";
        this.userID = "0";
        this.secUserID = "0";
        this.anchorID = "0";
        this.secAnchorID = "0";
        this.roomID = "0";
        this.settings = new JsonObject();
        this.activitySettings = new JsonObject();
        this.dynamicSettings = new JsonObject();
        this.abParams = new HashMap();
        this.queryItems = new JsonObject();
        this.injectJson = new HashMap();
        this.openUDid = "0";
        this.deviceId = "0";
        this.systemFontScale = 1.0f;
        this.devicePlatform = "android";
        this.f64303os = "Android";
        this.osVersion = "";
        this.f64302ac = "";
        this.currentNetworkQualityInfo = SliceInitService.DEFAULT_SWITCH;
        this.webcastLocale = "";
        this.webcastGpsAccess = "";
        this.language = "";
        this.webcastLanguage = "";
        this.deviceType = "";
        this.deviceScore = "0";
        this.veDeviceScore = "0";
        this.deviceBrand = "";
        this.iid = "";
        this.minorStatus = "0";
        this.osApi = "";
        this.fakeRegion = "";
        this.hostAbi = "";
        this.cpuSupport64 = "";
        this.resolution = "";
        this.f64304ts = "";
        this.manifestVersionCode = "";
        this.oaid = "";
        this.cdid = "";
        this.appType = "";
        this.dpi = "0";
        this.effectChannel = "";
        this.versionName = "";
        this.addressBookAccess = "";
        this.rticket = "";
        this.isAndroidPad = "";
        this.saasWebcastAppId = "0";
        this.isLiveSaas = true;
        int r100 = com.bytedance.android.livesdk.paas.d.f154207a;
        this.isLiveSaasFullFuse = true;
        this.webcastVersion = com.bytedance.android.livesdk.paas.c.b();
    }

    public final void A(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.iid = r100;
    }

    public final void B(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.initTimestamp = r100;
    }

    public final void C(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.injectJson = r100;
    }

    public final void D(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.language = r100;
    }

    public final void E(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.location = r100;
    }

    public final void F(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.lynxVersion = r100;
    }

    public final void G(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.manifestVersionCode = r100;
    }

    public final void H(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.minorStatus = r100;
    }

    public final void I(int r100) {
        this.isNotch = r100;
    }

    public final void J(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.oaid = r100;
    }

    public final void K(int r100) {
        this.offline = r100;
    }

    public final void L(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.openUDid = r100;
    }

    public final void M(int r100) {
        this.orientation = r100;
    }

    public final void N(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.osApi = r100;
    }

    public final void O(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.osVersion = r100;
    }

    public final void P(int r100) {
        this.isPad = r100;
    }

    public final void Q(int r100) {
        this.perf = r100;
    }

    public final void R(JsonObject r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.queryItems = r100;
    }

    public final void S(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.resolution = r100;
    }

    public final void T(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.roomID = r100;
    }

    public final void U(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.rticket = r100;
    }

    public final void V(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.saasWebcastAppId = r100;
    }

    public final void W(float r100) {
        this.screenHeight = r100;
    }

    public final void X(int r100) {
        this.screenHeightPx = r100;
    }

    public final void Y(float r100) {
        this.screenWidth = r100;
    }

    public final void Z(int r100) {
        this.screenWidthPx = r100;
    }

    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f64302ac = r100;
    }

    public final void a0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.secAnchorID = r100;
    }

    public final void b(JsonObject r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.activitySettings = r100;
    }

    public final void b0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.secUserID = r100;
    }

    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.addressBookAccess = r100;
    }

    public final void c0(JsonObject r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.settings = r100;
    }

    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.aid = r100;
    }

    public final void d0(float r100) {
        this.statusBarHeight = r100;
    }

    public final void e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.anchorID = r100;
    }

    public final void e0(float r100) {
        this.systemFontScale = r100;
    }

    public final void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.isAndroidPad = r100;
    }

    public final void f0(int r100) {
        this.isTeenMode = r100;
    }

    public final void g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.appName = r100;
    }

    public final void g0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f64304ts = r100;
    }

    public final void h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.appTheme = r100;
    }

    public final void h0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.updateVersionCode = r100;
    }

    public final void i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.appType = r100;
    }

    public final void i0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.userID = r100;
    }

    public final void j(int r100) {
        this.bottomBarHeight = r100;
    }

    public final void j0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.veDeviceScore = r100;
    }

    public final void k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.cdid = r100;
    }

    public final void k0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.versionCode = r100;
    }

    public final void l(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.channel = r100;
    }

    public final void l0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.versionName = r100;
    }

    public final void m(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.containerID = r100;
    }

    public final void m0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.webcastGpsAccess = r100;
    }

    public final void n(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.cpuSupport64 = r100;
    }

    public final void n0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.webcastLanguage = r100;
    }

    public final void o(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.currentNetworkQualityInfo = r100;
    }

    public final void o0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.webcastLocale = r100;
    }

    public final void p(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.deviceBrand = r100;
    }

    public final void p0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.webcastSdkVersion = r100;
    }

    public final void q(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.deviceId = r100;
    }

    public final void r(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.deviceScore = r100;
    }

    public final void s(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.deviceType = r100;
    }

    public final void t(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.dpi = r100;
    }

    public final void u(JsonObject r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.dynamicSettings = r100;
    }

    public final void v(String r100) {
        this.ecHostAppId = r100;
    }

    public final void w(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.effectChannel = r100;
    }

    public final void x(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.fakeRegion = r100;
    }

    public final void y(Map<String, String> r100) {
        this.feParamExtra = r100;
    }

    public final void z(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.hostAbi = r100;
    }
}

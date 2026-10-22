package com.android.ttcjpaysdk.ttcjpayapi;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import cd4.r;
import com.alipay.sdk.m.p.e;
import com.alipay.sdk.m.x.d;
import com.android.ttcjpaysdk.base.adapter.ICJExternalEventCenterAdapter;
import com.android.ttcjpaysdk.base.adapter.ICJExternalLynxServiceAdapter;
import com.android.ttcjpaysdk.base.adapter.TTCJPayLoadingAdapter;
import com.android.ttcjpaysdk.base.adapter.TTCJPayNetworkErrorAdapter;
import com.android.ttcjpaysdk.base.adapter.TTCJPayToastAdapter;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.service.ICJPayBasisPaymentService;
import com.android.ttcjpaysdk.base.service.ICJPayServiceRetCallBack;
import com.android.ttcjpaysdk.base.service.IPayLifecycle;
import com.android.ttcjpaysdk.base.service.ITTCJPayComponent;
import com.android.ttcjpaysdk.demo.api.ICJDemoRouter;
import com.android.ttcjpaysdk.ktextension.CJSchemaExtensionKt;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.caijing.sdk.biz.pay.api.CJPayApiService;
import com.bytedance.caijing.sdk.biz.pay.api.ITTCJPayUtilsCompat;
import com.bytedance.caijing.sdk.infra.base.api.alog.ALogService;
import com.bytedance.caijing.sdk.infra.base.api.applog.AppLogService;
import com.bytedance.caijing.sdk.infra.base.api.container.IJsbService;
import com.bytedance.caijing.sdk.infra.base.api.env.CJHostService;
import com.bytedance.caijing.sdk.infra.base.api.env.INetEnv;
import com.bytedance.caijing.sdk.infra.base.api.env.plugin.CJPluginLoadedResult;
import com.bytedance.caijing.sdk.infra.base.api.localtest.CJLocalTestService;
import com.bytedance.caijing.sdk.infra.base.api.monitor.MonitorService;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.heytap.mcssdk.constant.b;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.tencent.open.SocialConstants;
import faceverify.w;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000ª\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 Ý\u00022\u00020\u0001:\u0002Ý\u0002B\u000b\b\u0002¢\u0006\u0006\bÛ\u0002\u0010Ü\u0002J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0002J&\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J(\u0010\u000e\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fj\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\rH\u0002J\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0006\u0010\u0014\u001a\u00020\u0013J\u0010\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0002H\u0007J\u0010\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0013H\u0007J\u0010\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0013H\u0007J\b\u0010\u001b\u001a\u00020\u0000H\u0007J\u0010\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0013H\u0007J:\u0010#\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\u00022\b\u0010 \u001a\u0004\u0018\u00010\u00022\b\u0010!\u001a\u0004\u0018\u00010\u00022\b\u0010\"\u001a\u0004\u0018\u00010\u0002H\u0007J0\u0010#\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\u00022\b\u0010 \u001a\u0004\u0018\u00010\u00022\b\u0010!\u001a\u0004\u0018\u00010\u0002H\u0007J:\u0010$\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\u00022\b\u0010 \u001a\u0004\u0018\u00010\u00022\b\u0010!\u001a\u0004\u0018\u00010\u00022\b\u0010\"\u001a\u0004\u0018\u00010\u0002H\u0007J\u0010\u0010'\u001a\u00020\u00002\u0006\u0010&\u001a\u00020%H\u0007J\u0006\u0010(\u001a\u00020\u0007J.\u0010*\u001a\u00020\u00002&\u0010)\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\fj\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\rJ\u0010\u0010-\u001a\u00020\u00002\b\u0010,\u001a\u0004\u0018\u00010+J\u0010\u0010/\u001a\u00020\u00002\u0006\u0010.\u001a\u00020%H\u0007J\u000e\u00102\u001a\u00020\u00002\u0006\u00101\u001a\u000200J\u0010\u00103\u001a\u00020\u00002\b\u0010\u001f\u001a\u0004\u0018\u00010\u0002J\u0010\u00104\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002J\u0010\u00106\u001a\u00020\u00002\b\u00105\u001a\u0004\u0018\u00010\u0002J\u0010\u00108\u001a\u00020\u00002\b\u00107\u001a\u0004\u0018\u00010\u0002J\u000e\u0010:\u001a\u00020\u00002\u0006\u00109\u001a\u00020\u0013J\u001e\u0010=\u001a\u00020\u00002\u0016\u0010<\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010;J\u0010\u0010?\u001a\u00020\u00002\b\u0010>\u001a\u0004\u0018\u00010\u0002J\u001c\u0010B\u001a\u00020\u00002\u0014\u0010A\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010@J\u0010\u0010E\u001a\u00020\u00002\b\u0010D\u001a\u0004\u0018\u00010CJ6\u0010K\u001a\u00020\u00072\b\u0010F\u001a\u0004\u0018\u00010\u00022\b\u0010G\u001a\u0004\u0018\u00010\u00102\b\u0010H\u001a\u0004\u0018\u00010\u00102\u0006\u0010I\u001a\u00020%2\b\u0010J\u001a\u0004\u0018\u00010\u0002J\u000e\u0010M\u001a\u00020\u00002\u0006\u0010L\u001a\u00020\u0013J\u000e\u0010O\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\u0013J\u000e\u0010R\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020PJ\u001e\u0010T\u001a\u00020\u00002\u0016\u0010S\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010@J\u0006\u0010U\u001a\u00020\u0007J\u0006\u0010V\u001a\u00020\u0007J\u000e\u0010X\u001a\u00020\u00002\u0006\u0010W\u001a\u00020\u0002J\u000e\u0010Z\u001a\u00020\u00002\u0006\u0010Y\u001a\u00020\u0013J\u000e\u0010\\\u001a\u00020\u00002\u0006\u0010[\u001a\u00020\u0013J\u0010\u0010^\u001a\u00020\u00002\u0006\u0010]\u001a\u00020\u0013H\u0007J\u000e\u0010`\u001a\u00020\u00002\u0006\u0010_\u001a\u00020\u0013J\u0010\u0010b\u001a\u00020\u00002\b\u0010a\u001a\u0004\u0018\u00010\u0002J\u0010\u0010e\u001a\u00020\u00002\b\u0010d\u001a\u0004\u0018\u00010cJ\u000e\u0010h\u001a\u00020\u00002\u0006\u0010g\u001a\u00020fJ\u000e\u0010j\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020iJ\u0012\u0010m\u001a\u00020\u00002\b\u0010l\u001a\u0004\u0018\u00010kH\u0007J\u0010\u0010o\u001a\u00020\u00002\b\u0010n\u001a\u0004\u0018\u00010\u0002J\u0010\u0010r\u001a\u00020\u00002\b\u0010q\u001a\u0004\u0018\u00010pJ\u001c\u0010u\u001a\u00020\u0000\"\u0004\b\u0000\u0010s2\u000e\u0010q\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010tJ\u0010\u0010w\u001a\u00020\u00002\b\u0010q\u001a\u0004\u0018\u00010vJ\u000e\u0010z\u001a\u00020\u00002\u0006\u0010y\u001a\u00020xJ\u000e\u0010|\u001a\u00020\u00072\u0006\u0010{\u001a\u00020\u0013J\u0010\u0010~\u001a\u00020\u00072\b\u0010}\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\u0081\u0001\u001a\u00020\u00002\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u007fJ\u0012\u0010\u0083\u0001\u001a\u00020\u00002\t\u0010q\u001a\u0005\u0018\u00010\u0082\u0001J\u0012\u0010\u0085\u0001\u001a\u00020\u00002\t\u0010q\u001a\u0005\u0018\u00010\u0084\u0001J\u0011\u0010\u0088\u0001\u001a\u00020\u00002\b\u0010\u0087\u0001\u001a\u00030\u0086\u0001J\u0012\u0010\u008a\u0001\u001a\u00020\u00072\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0001J\u0011\u0010\u008d\u0001\u001a\u00020\u00002\b\u0010\u008c\u0001\u001a\u00030\u008b\u0001J\u0011\u0010\u0090\u0001\u001a\u00020\u00002\b\u0010\u008f\u0001\u001a\u00030\u008e\u0001J\u0011\u0010\u0093\u0001\u001a\u00020\u00072\b\u0010\u0092\u0001\u001a\u00030\u0091\u0001J\u0010\u0010\u0095\u0001\u001a\u00020\u00002\u0007\u0010\u0094\u0001\u001a\u00020\u0013J\u0015\u0010\u0098\u0001\u001a\u00020\u00002\n\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0096\u0001H\u0007J\u0013\u0010\u009b\u0001\u001a\u00020\u00002\n\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u0099\u0001J\u0014\u0010\u009d\u0001\u001a\u00020\u00002\t\u0010\u000f\u001a\u0005\u0018\u00010\u009c\u0001H\u0007J\u0014\u0010\u009f\u0001\u001a\u00020\u00002\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010¡\u0001\u001a\u00020\u00002\t\u0010 \u0001\u001a\u0004\u0018\u00010\u0002J\u0010\u0010£\u0001\u001a\u00020\u00002\u0007\u0010¢\u0001\u001a\u00020%J\u0012\u0010¥\u0001\u001a\u00020\u00002\t\b\u0002\u0010¤\u0001\u001a\u00020\u0013J\u0010\u0010§\u0001\u001a\u00020\u00002\u0007\u0010¦\u0001\u001a\u00020\u0013J\u0012\u0010©\u0001\u001a\u00020\u00002\t\u0010¨\u0001\u001a\u0004\u0018\u00010\u0010J\u0011\u0010¬\u0001\u001a\u00020\u00002\b\u0010«\u0001\u001a\u00030ª\u0001J\u001e\u0010®\u0001\u001a\u00020\u00002\u0015\u0010\u00ad\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020%\u0018\u00010@J\u0012\u0010°\u0001\u001a\u00020\u00002\t\u0010¯\u0001\u001a\u0004\u0018\u00010\u0002J\u0012\u0010²\u0001\u001a\u00020\u00072\t\u0010±\u0001\u001a\u0004\u0018\u00010\u0002J2\u0010¶\u0001\u001a\u00020\u00072\b\u0010F\u001a\u0004\u0018\u00010\u00022\t\u0010³\u0001\u001a\u0004\u0018\u00010\u00022\t\u0010´\u0001\u001a\u0004\u0018\u00010\u00022\t\u0010µ\u0001\u001a\u0004\u0018\u00010\u0002J=\u0010¶\u0001\u001a\u00020\u00072\b\u0010F\u001a\u0004\u0018\u00010\u00022\t\u0010³\u0001\u001a\u0004\u0018\u00010\u00022\t\u0010´\u0001\u001a\u0004\u0018\u00010\u00022\t\u0010µ\u0001\u001a\u0004\u0018\u00010\u00022\t\u0010·\u0001\u001a\u0004\u0018\u00010\u0002JG\u0010½\u0001\u001a\u00020\u00072\t\u0010¸\u0001\u001a\u0004\u0018\u00010\u00022\u0007\u0010«\u0001\u001a\u00020%2\t\u0010¹\u0001\u001a\u0004\u0018\u00010\u00022\t\u0010º\u0001\u001a\u0004\u0018\u00010\u00022\t\u0010»\u0001\u001a\u0004\u0018\u00010\u00022\t\u0010\b\u001a\u0005\u0018\u00010¼\u0001JR\u0010½\u0001\u001a\u00020\u00072\t\u0010¸\u0001\u001a\u0004\u0018\u00010\u00022\u0007\u0010«\u0001\u001a\u00020%2\t\u0010¹\u0001\u001a\u0004\u0018\u00010\u00022\t\u0010º\u0001\u001a\u0004\u0018\u00010\u00022\t\u0010»\u0001\u001a\u0004\u0018\u00010\u00022\t\u0010¾\u0001\u001a\u0004\u0018\u00010\u00022\t\u0010\b\u001a\u0005\u0018\u00010¼\u0001Jf\u0010½\u0001\u001a\u00020\u00072\t\u0010¸\u0001\u001a\u0004\u0018\u00010\u00022\u0007\u0010«\u0001\u001a\u00020%2\t\u0010¹\u0001\u001a\u0004\u0018\u00010\u00022\t\u0010º\u0001\u001a\u0004\u0018\u00010\u00022\t\u0010»\u0001\u001a\u0004\u0018\u00010\u00022\t\u0010¾\u0001\u001a\u0004\u0018\u00010\u00022\t\u0010¿\u0001\u001a\u0004\u0018\u00010\u00132\t\u0010\b\u001a\u0005\u0018\u00010¼\u0001¢\u0006\u0006\b½\u0001\u0010À\u0001J=\u0010Ç\u0001\u001a\u00020\u00072\b\u0010,\u001a\u0004\u0018\u00010+2\t\u0010Á\u0001\u001a\u0004\u0018\u00010\u00022\u0007\u0010Â\u0001\u001a\u00020\u00022\n\u0010Ä\u0001\u001a\u0005\u0018\u00010Ã\u00012\n\u0010Æ\u0001\u001a\u0005\u0018\u00010Å\u0001J4\u0010È\u0001\u001a\u00020\u00072\b\u0010,\u001a\u0004\u0018\u00010+2\t\u0010Á\u0001\u001a\u0004\u0018\u00010\u00022\n\u0010Ä\u0001\u001a\u0005\u0018\u00010Ã\u00012\n\u0010Æ\u0001\u001a\u0005\u0018\u00010Å\u0001J4\u0010É\u0001\u001a\u00020\u00072\b\u0010,\u001a\u0004\u0018\u00010+2\t\u0010Á\u0001\u001a\u0004\u0018\u00010\u00022\n\u0010Ä\u0001\u001a\u0005\u0018\u00010Ã\u00012\n\u0010Æ\u0001\u001a\u0005\u0018\u00010Å\u0001J1\u0010Ç\u0001\u001a\u00020\u00072\b\u0010,\u001a\u0004\u0018\u00010+2\t\u0010Á\u0001\u001a\u0004\u0018\u00010\u00022\u0007\u0010Â\u0001\u001a\u00020\u00022\n\u0010Ä\u0001\u001a\u0005\u0018\u00010Ã\u0001J(\u0010È\u0001\u001a\u00020\u00072\b\u0010,\u001a\u0004\u0018\u00010+2\t\u0010Á\u0001\u001a\u0004\u0018\u00010\u00022\n\u0010Ä\u0001\u001a\u0005\u0018\u00010Ã\u0001J(\u0010É\u0001\u001a\u00020\u00072\b\u0010,\u001a\u0004\u0018\u00010+2\t\u0010Á\u0001\u001a\u0004\u0018\u00010\u00022\n\u0010Ä\u0001\u001a\u0005\u0018\u00010Ã\u0001J\u000f\u0010Ê\u0001\u001a\u00020\u00132\u0006\u0010,\u001a\u00020+J,\u0010Ð\u0001\u001a\u00020\u00072\b\u0010Ì\u0001\u001a\u00030Ë\u00012\u0007\u0010Í\u0001\u001a\u00020\u00022\u0007\u0010Î\u0001\u001a\u00020\u00132\u0007\u0010\b\u001a\u00030Ï\u0001J\u0007\u0010Ñ\u0001\u001a\u00020\u0007J\u0007\u0010Ò\u0001\u001a\u00020\u0007JG\u0010Ó\u0001\u001a\u00020\u00072\t\u0010¸\u0001\u001a\u0004\u0018\u00010\u00022\u0007\u0010«\u0001\u001a\u00020%2\t\u0010¹\u0001\u001a\u0004\u0018\u00010\u00022\t\u0010º\u0001\u001a\u0004\u0018\u00010\u00022\t\u0010»\u0001\u001a\u0004\u0018\u00010\u00022\t\u0010\b\u001a\u0005\u0018\u00010¼\u0001J\u0007\u0010Ô\u0001\u001a\u00020\u0002J\u0010\u0010Ö\u0001\u001a\u00020\u00072\u0007\u0010Õ\u0001\u001a\u00020\u0002J \u0010Ø\u0001\u001a\u00020\u00072\u0006\u0010,\u001a\u00020+2\u0007\u0010×\u0001\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010J\u0007\u0010Ù\u0001\u001a\u00020\u0002J\u0007\u0010Ú\u0001\u001a\u00020\u0002J\u0007\u0010Û\u0001\u001a\u00020\u0007J\u0007\u0010Ü\u0001\u001a\u00020\u0007J\u0007\u0010Ý\u0001\u001a\u00020\u0007J\u0007\u0010Þ\u0001\u001a\u00020\u0007J\u0007\u0010ß\u0001\u001a\u00020\u0007J+\u0010â\u0001\u001a\u00020\u00072\u0007\u0010à\u0001\u001a\u00020%2\u0007\u0010á\u0001\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0002H\u0007J\u0007\u0010ã\u0001\u001a\u00020\u0007J2\u0010ç\u0001\u001a\u00020\u00072\u0006\u0010F\u001a\u00020\u00022\u0006\u0010I\u001a\u00020%2\u0007\u0010ä\u0001\u001a\u00020\u00132\u0007\u0010å\u0001\u001a\u00020\u00022\u0007\u0010æ\u0001\u001a\u00020%J>\u0010ç\u0001\u001a\u00020\u00072\b\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010F\u001a\u00020\u00022\u0006\u0010I\u001a\u00020%2\u0007\u0010ä\u0001\u001a\u00020\u00132\u0007\u0010å\u0001\u001a\u00020\u00022\u0007\u0010æ\u0001\u001a\u00020%H\u0007JH\u0010ç\u0001\u001a\u00020\u00072\b\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010F\u001a\u00020\u00022\u0006\u0010I\u001a\u00020%2\u0007\u0010ä\u0001\u001a\u00020\u00132\u0007\u0010å\u0001\u001a\u00020\u00022\u0007\u0010æ\u0001\u001a\u00020%2\b\u0010é\u0001\u001a\u00030è\u0001H\u0007J)\u0010ë\u0001\u001a\u00020\u00072\u0006\u0010,\u001a\u00020+2\u0007\u0010×\u0001\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0007\u0010\b\u001a\u00030ê\u0001J\u0007\u0010ì\u0001\u001a\u00020\u0007J\u001c\u0010î\u0001\u001a\u0017\u0012\u0004\u0012\u00020\u0002\u0012\r\u0012\u000b\u0012\u0006\b\u0001\u0012\u00020\u00010í\u00010@J\u0007\u0010ï\u0001\u001a\u00020\u0007J\u0010\u0010ñ\u0001\u001a\u00020\u00072\u0007\u0010ð\u0001\u001a\u00020\u0002J\u0010\u0010ó\u0001\u001a\u00020\u00072\u0007\u0010ò\u0001\u001a\u00020\u0002J\u0012\u0010ô\u0001\u001a\u00020\u00072\u0007\u0010ò\u0001\u001a\u00020\u0002H\u0007J3\u0010÷\u0001\u001a\u00020\u00072\b\u0010Ì\u0001\u001a\u00030Ë\u00012\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\u0007\u0010õ\u0001\u001a\u00020\u00022\u0007\u0010\b\u001a\u00030ö\u0001JE\u0010÷\u0001\u001a\u00020\u00072\b\u0010Ì\u0001\u001a\u00030Ë\u00012\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\u0007\u0010õ\u0001\u001a\u00020\u00022\u0007\u0010ø\u0001\u001a\u00020\u00022\u0007\u0010ù\u0001\u001a\u00020\u00022\u0007\u0010\b\u001a\u00030ö\u0001JN\u0010÷\u0001\u001a\u00020\u00072\b\u0010Ì\u0001\u001a\u00030Ë\u00012\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\u0007\u0010õ\u0001\u001a\u00020\u00022\u0007\u0010ø\u0001\u001a\u00020\u00022\u0007\u0010ù\u0001\u001a\u00020\u00022\u0007\u0010ú\u0001\u001a\u00020\u00022\u0007\u0010\b\u001a\u00030ö\u0001J\u001c\u0010þ\u0001\u001a\u00020\u00072\u0007\u0010û\u0001\u001a\u00020\u00022\n\u0010ý\u0001\u001a\u0005\u0018\u00010ü\u0001J\u0013\u0010þ\u0001\u001a\u00020\u00072\n\u0010ý\u0001\u001a\u0005\u0018\u00010ü\u0001J?\u0010\u0081\u0002\u001a\u00020\u00072\n\u0010Ì\u0001\u001a\u0005\u0018\u00010Ë\u00012\b\u0010\u001f\u001a\u0004\u0018\u00010\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u00022\t\u0010ÿ\u0001\u001a\u0004\u0018\u00010\u00022\t\u0010\b\u001a\u0005\u0018\u00010\u0080\u0002H\u0007J\u0010\u0010\u0083\u0002\u001a\u00020\u00072\u0007\u0010\u0082\u0002\u001a\u00020%J\u0010\u0010\u0084\u0002\u001a\u00020\u00072\u0007\u0010\u0082\u0002\u001a\u00020%J\u0007\u0010\u0085\u0002\u001a\u00020\u0007J\u0007\u0010\u0086\u0002\u001a\u00020\u0007J\u0012\u0010\u0088\u0002\u001a\u0004\u0018\u00010\u00022\u0007\u0010\u0087\u0002\u001a\u00020\u0002J\u0016\u0010\u008c\u0002\u001a\u0005\u0018\u00010\u008b\u00022\n\u0010\u008a\u0002\u001a\u0005\u0018\u00010\u0089\u0002J\u0007\u0010\u008d\u0002\u001a\u00020\u0010J\u0007\u0010\u008e\u0002\u001a\u00020\u0010J2\u0010\u0091\u0002\u001a\u00020\u00102\u0007\u0010ù\u0001\u001a\u00020\u00022\u0007\u0010\u008f\u0002\u001a\u00020\u00022\u0017\b\u0002\u0010\u0090\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010@J\u0007\u0010\u0092\u0002\u001a\u00020\u0007J \u0010\u0093\u0002\u001a\u00020\u00072\u0006\u0010,\u001a\u00020+2\u0006\u0010\u0011\u001a\u00020\u00102\u0007\u0010\b\u001a\u00030ê\u0001J.\u0010\u0095\u0002\u001a\u0004\u0018\u00010\u00102#\u0010\u0094\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\fj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\rJ\u0012\u0010\u0097\u0002\u001a\u00020%2\u0007\u0010\u0096\u0002\u001a\u00020+H\u0007J5\u0010\u009c\u0002\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u00022\u0007\u0010\u0098\u0002\u001a\u00020\u00022\b\u0010\u009a\u0002\u001a\u00030\u0099\u00022\u0007\u0010\u009b\u0002\u001a\u00020\u00022\b\u0010\"\u001a\u0004\u0018\u00010\u0010J\u0019\u0010\u009d\u0002\u001a\u00020\u00132\b\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010F\u001a\u00020\u0002J\u0019\u0010\u009e\u0002\u001a\u00020\u00072\u0007\u0010\u0087\u0002\u001a\u00020\u00022\u0007\u0010\u009e\u0001\u001a\u00020\u0002J\u0019\u0010 \u0002\u001a\u00020\u00022\u0007\u0010\u0087\u0002\u001a\u00020\u00022\u0007\u0010\u009f\u0002\u001a\u00020\u0002J\u001a\u0010¡\u0002\u001a\u00020\u00072\b\u0010Ì\u0001\u001a\u00030Ë\u00012\u0007\u0010ð\u0001\u001a\u00020\u0002J$\u0010¤\u0002\u001a\u00020\u00072\u0006\u0010,\u001a\u00020+2\t\u0010±\u0001\u001a\u0004\u0018\u00010\u00022\b\u0010£\u0002\u001a\u00030¢\u0002JZ\u0010¤\u0002\u001a\u00020\u00072\u0006\u0010,\u001a\u00020+2\t\u0010±\u0001\u001a\u0004\u0018\u00010\u00022\u0015\u0010¥\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010@2\t\u0010¦\u0002\u001a\u0004\u0018\u00010\u00022\t\u0010§\u0002\u001a\u0004\u0018\u00010\u00022\u0007\u0010¨\u0002\u001a\u00020\u00132\b\u0010£\u0002\u001a\u00030¢\u0002JH\u0010©\u0002\u001a\u00020\u00072\u0006\u0010,\u001a\u00020+2\u0013\u0010¸\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020@2\u0017\u0010¥\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010@2\t\u0010\b\u001a\u0005\u0018\u00010¢\u0002R\u001f\u0010®\u0002\u001a\u00020\u00028\u0006X\u0086D¢\u0006\u0010\n\u0006\bª\u0002\u0010«\u0002\u001a\u0006\b¬\u0002\u0010\u00ad\u0002R\u0017\u0010¯\u0002\u001a\u00020\u00028\u0002X\u0082D¢\u0006\b\n\u0006\b¯\u0002\u0010«\u0002R\u0017\u0010°\u0002\u001a\u00020\u00028\u0002X\u0082D¢\u0006\b\n\u0006\b°\u0002\u0010«\u0002R\u0017\u0010±\u0002\u001a\u00020\u00028\u0002X\u0082D¢\u0006\b\n\u0006\b±\u0002\u0010«\u0002R\u0017\u0010²\u0002\u001a\u00020\u00028\u0002X\u0082D¢\u0006\b\n\u0006\b²\u0002\u0010«\u0002R\u0017\u0010³\u0002\u001a\u00020\u00028\u0002X\u0082D¢\u0006\b\n\u0006\b³\u0002\u0010«\u0002R\u001e\u0010µ\u0002\u001a\t\u0012\u0004\u0012\u00020\u00010´\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bµ\u0002\u0010¶\u0002R\u001b\u0010·\u0002\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b·\u0002\u0010¸\u0002R,\u0010¹\u0002\u001a\u0005\u0018\u00010\u008b\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¹\u0002\u0010º\u0002\u001a\u0006\b»\u0002\u0010¼\u0002\"\u0006\b½\u0002\u0010¾\u0002R\u001b\u0010¿\u0002\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¿\u0002\u0010À\u0002R\u001b\u0010Á\u0002\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÁ\u0002\u0010Â\u0002R\u001a\u0010Ä\u0002\u001a\u00030Ã\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÄ\u0002\u0010Å\u0002R!\u0010Ë\u0002\u001a\u00030Æ\u00028BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bÇ\u0002\u0010È\u0002\u001a\u0006\bÉ\u0002\u0010Ê\u0002R!\u0010Ð\u0002\u001a\u00030Ì\u00028BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bÍ\u0002\u0010È\u0002\u001a\u0006\bÎ\u0002\u0010Ï\u0002R!\u0010Õ\u0002\u001a\u00030Ñ\u00028BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bÒ\u0002\u0010È\u0002\u001a\u0006\bÓ\u0002\u0010Ô\u0002R#\u0010Ú\u0002\u001a\u0005\u0018\u00010Ö\u00028BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b×\u0002\u0010È\u0002\u001a\u0006\bØ\u0002\u0010Ù\u0002¨\u0006Þ\u0002"}, d2 = {"Lcom/android/ttcjpaysdk/ttcjpayapi/TTCJPayUtils;", "", "", "triggerFrom", "Lcom/bytedance/caijing/sdk/biz/pay/api/ITTCJPayUtilsCompat;", "getCJPayUtils", "Lkotlin/Function1;", "", "callback", "loadCJPluginAndGetCJPayUtils", "Lcom/android/ttcjpaysdk/demo/api/ICJDemoRouter;", "getCJPayDemoRouter", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getCategoryCommonParams", "event", "Lorg/json/JSONObject;", "params", "reportTea", "", "isCJSDKValid", BaseHttpRequestInfo.KEY_USER_AGENT, "setCustomUA", "isExposed", "setIsBalancePaymentExposed", "isHide", "setIsHideStatusBar", "privateFetchSettings", "isPreload", "setIsAggregatePayment", "appId", "merchantId", "uId", "firstDefaultPayType", "exts", "preLoadCheckoutCounterData", "preLoadCheckoutCounterDataForH5", "", "status", "updateLoginStatus", "preLoadYuefuTemplate", "extraHeaderMap", "setExtraHeaderMap", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "setContext", "type", "setServerType", "", "fontScale", "setFontScale", "setMerchantId", "setAppId", "aid", "setAid", a.KEY_DID, "setDid", "isUsingGecko", "setIsUsingGecko", "", "riskInfoParams", "setRiskInfoParams", "languageTypeStr", "setLanguageTypeStr", "", "loginTokenMap", "setLoginToken", "Lcom/android/ttcjpaysdk/ttcjpayapi/TTCJPayObserver;", "observer", "setObserver", "url", "orderInfo", "channelInfo", "payCashDeskType", "navigationBarColor", "openH5CashDesk", "isNewGameStyle", "setGameNewStyle", "isGameNewCounterStyle", "setGameNewCounterStyle", "Landroid/graphics/Bitmap;", SimplayerImageStrategy.RESULT_BITMAP, "setTitleBitmap", "requestParams", "setRequestParams", "execute", "releaseAll", "titleStr", "setTitleStr", "isUsingTTNet", "setIsUsingTTNet", "isTransCheckoutCounterActivityWhenLoading", "setIsTransCheckoutCounterActivityWhenLoading", "needLoading", "setNeedLoading", "isUnifyHideLoading", "setUnifyHideLoading", "appUpdateVersion", "setAppUpdateVersion", "Lcom/android/ttcjpaysdk/ttcjpayapi/TTCJPayDoFaceLive;", "faceLive", "setFaceLive", "Lcom/android/ttcjpaysdk/ttcjpayapi/IBlockDialog;", "blockDialog", "setBlockDialog", "Lcom/android/ttcjpaysdk/ttcjpayapi/IH5NotificationCallback;", "setH5NotificationCallback", "Lcom/android/ttcjpaysdk/ttcjpayapi/ICustomActionListener;", "customActionListener", "setCustomActionListener", "uid", "setUid", "Lcom/android/ttcjpaysdk/base/adapter/TTCJPayToastAdapter;", "adapter", "setToastAdapter", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/android/ttcjpaysdk/base/adapter/TTCJPayLoadingAdapter;", "setLoadingAdapter", "Lcom/android/ttcjpaysdk/base/adapter/TTCJPayNetworkErrorAdapter;", "setNetworkErrorAdapter", "Lcom/android/ttcjpaysdk/ttcjpayapi/IBasicMode;", "basicModeCallback", "setBasicModeCallback", "isFollow", "setFollowSystemTheme", "inheritTheme", "setInheritTheme", "Lcom/android/ttcjpaysdk/ttcjpayapi/TTCJPayOpenSchemeWithContextInterface;", "openSchemeWithContextCallback", "setOpenSchemeWithContextCallback", "Lcom/android/ttcjpaysdk/base/adapter/ICJExternalLynxServiceAdapter;", "setExternalLynxServiceAdapter", "Lcom/android/ttcjpaysdk/base/adapter/ICJExternalEventCenterAdapter;", "setExternalEventCenterAdapter", "Lcom/android/ttcjpaysdk/ttcjpayapi/ICustomerServiceCallback;", "customerServiceCallback", "setCustomerServiceCallback", "interceptor", "setNetworkInterceptor", "Lcom/android/ttcjpaysdk/ttcjpayapi/ITTCJPayPhoneCarrierService;", "phoneCarrierService", "setPhoneCarrierService", "Lcom/android/ttcjpaysdk/ttcjpayapi/ICJHostLoginService;", "loginService", "setHostLoginService", "Lcom/android/ttcjpaysdk/ttcjpayapi/TTCJPayHostJSBMethodsInterface;", "hostJSBMethodsInterface", "setHostJSBMethodsInterface", "fromImRedPacket", "setFromImRedPacket", "Lcom/android/ttcjpaysdk/ttcjpayapi/TTCJPayOpenSchemeInterface;", "openSchemeInterface", "setOpenSchemeCallback", "Lcom/android/ttcjpaysdk/ttcjpayapi/TTCJPayMonitor;", "monitor", "setMonitor", "Lcom/android/ttcjpaysdk/ttcjpayapi/TTCJPayEvent;", "setEvent", "value", "setBoeEnv", "channel", "setEnvChannel", "screenOrientationType", "setScreenOrientationType", "backEnable", "setBackEnable", "needJSBridgeAuth", "setJSBridgeAuth", "trackInfoJson", "setTrackInfo", "Lcom/android/ttcjpaysdk/ttcjpayapi/ICJHostPrivacyService;", "service", "setHostPrivacyService", "animationResourceMap", "setAnimationResourceMap", "integratedDomain", "setIntegratedHostDomain", "sdkInfoStr", "bdPayForImRedPacket", "title", "isTransTitleBar", "statusBarColor", "openH5", "backButtonColor", d.D, "subWay", AppConstants.BUNDLE_REFERER, "ext", "Lcom/android/ttcjpaysdk/ttcjpayapi/IH5PayCallback;", "pay", "from", "needOriginErrorCode", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/android/ttcjpaysdk/ttcjpayapi/IH5PayCallback;)V", "data", "wxPayType", "Lcom/android/ttcjpaysdk/base/service/ICJPayBasisPaymentService$OnPayResultCallback;", "onPayResultCallback", "Lcom/android/ttcjpaysdk/base/service/ICJPayBasisPaymentService$OnResultCallback;", "onResultCallback", "wxPay", "aliPay", "cloudUnionPay", "isCloudUnionPayInstalled", "Landroid/app/Activity;", "activity", w.META_COLL_KEY_AUTH_INFO, "isShowLoading", "Lcom/android/ttcjpaysdk/ttcjpayapi/TTCJPayAlipayAuthCallback;", "authAlipay", "releaseAllFromSubProcess", "closeSDK", "payFromSubProcess", "getSDKVersion", "scheme", "openH5ByScheme", e.f25671s, "executeCloseAndCallback", "getBioType", "getJailBreak", "bdPay", "init", "initMini", "doRefreshOnNetworkError", "sign", "amount", "tradeName", "executeAggregatePayment", "executeWithdraw", "enableAnim", "bgColor", DyPayConstant.KEY_SHOW_LOADING, "openH5ModalView", "Landroid/net/Uri;", "uri", "Lcom/android/ttcjpaysdk/ttcjpayapi/ICJPayXBridgeCallback;", "handleXBridgeMethod", "registerCJPayXbridge", "Ljava/lang/Class;", "getCJPayXBridgeMethods", PbRequest.SwitchType.RECHARGE, "schema", "myBankCard", "smchId", "tradeRecord", "tradeManager", "eventTrack", "Lcom/android/ttcjpaysdk/ttcjpayapi/TTCJPayRealNameAuthCallback;", "openRealNameAuth", "theme", "scene", "style", b.f276366p, "Lcom/android/ttcjpaysdk/base/service/ICJPayServiceRetCallBack;", "callBack", "openOCR", "channelOrderInfo", "Lcom/android/ttcjpaysdk/ttcjpayapi/TTCJPayRealNamePasswordCallback;", "openRealNameSetPassword", "heightInPx", "fastPay", "fastPayShowLoading", "fastPayHideLoading", "fastPayOnlySendRequest", "key", "getSettingsInfo", "Lcom/android/ttcjpaysdk/base/service/IPayLifecycle;", NewBroadcastMonitor.STAGE.LIFECYCLE, "Lcom/android/ttcjpaysdk/base/service/ITTCJPayComponent;", "getPayComponent", "getFinanceRisk", "getCJPassThroughInfo", "triggerAction", "extraReportMap", "getFinanceRiskWithScene", "preLoadFinanceRisk", "openPayScoreWithParams", "sceneContext", "getCJPayInfo", "applicationContext", "getAppVersionCode", "name", "", "timestamp", SocialConstants.PARAM_APP_DESC, "externalBizReport", "handleCodeScanResult", "storeString", "defaultValue", "readString", "openTestPage", "Lwc4/a;", "payCallback", "outerBDPay", "extraInfo", "source", "sceneSource", "isInvokeForInner", "routeSign", "TAG$1", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "OPEN_SCHEMA_EVENT_NAME", "CJPAY_OPEN_SCHEMA_AFTER_LOAD_PLUGIN", "CJPAY_GET_CJPAYUTILS_AFTER_LOAD_PLUGIN", "CJPAY_REGISTER_XBRIDGE_FAIL", "CJPAY_CJPAYUTILS_IS_NULL", "Ljava/util/concurrent/CopyOnWriteArrayList;", "mNetInterceptors", "Ljava/util/concurrent/CopyOnWriteArrayList;", "mFaceLive", "Lcom/android/ttcjpaysdk/ttcjpayapi/TTCJPayDoFaceLive;", "cjComponent", "Lcom/android/ttcjpaysdk/base/service/ITTCJPayComponent;", "getCjComponent", "()Lcom/android/ttcjpaysdk/base/service/ITTCJPayComponent;", "setCjComponent", "(Lcom/android/ttcjpaysdk/base/service/ITTCJPayComponent;)V", "mCjPayUtils", "Lcom/bytedance/caijing/sdk/biz/pay/api/ITTCJPayUtilsCompat;", "mCjPayDemoRouter", "Lcom/android/ttcjpaysdk/demo/api/ICJDemoRouter;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hostInitTriggered", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Lcom/bytedance/caijing/sdk/infra/base/api/env/CJHostService;", "hostService$delegate", "Lkotlin/Lazy;", "getHostService", "()Lcom/bytedance/caijing/sdk/infra/base/api/env/CJHostService;", "hostService", "Lcom/bytedance/caijing/sdk/infra/base/api/alog/ALogService;", "logService$delegate", "getLogService", "()Lcom/bytedance/caijing/sdk/infra/base/api/alog/ALogService;", "logService", "Lcom/bytedance/caijing/sdk/infra/base/api/applog/AppLogService;", "eventService$delegate", "getEventService", "()Lcom/bytedance/caijing/sdk/infra/base/api/applog/AppLogService;", "eventService", "Lcom/bytedance/caijing/sdk/infra/base/api/monitor/MonitorService;", "monitorService$delegate", "getMonitorService", "()Lcom/bytedance/caijing/sdk/infra/base/api/monitor/MonitorService;", "monitorService", "<init>", "()V", "Companion", "cjpay-se-api_release"}, k = 1, mv = {1, 6, 0})
public final class TTCJPayUtils {
    private static final String CJPAY_HOST = null;
    public static final Companion Companion = null;
    private static final String TAG = null;
    private static final boolean isNew = false;
    private static final Lazy<TTCJPayUtils> singleInstance$delegate = null;
    private final String CJPAY_CJPAYUTILS_IS_NULL;
    private final String CJPAY_GET_CJPAYUTILS_AFTER_LOAD_PLUGIN;
    private final String CJPAY_OPEN_SCHEMA_AFTER_LOAD_PLUGIN;
    private final String CJPAY_REGISTER_XBRIDGE_FAIL;
    private final String OPEN_SCHEMA_EVENT_NAME;
    private final String TAG$1;
    private ITTCJPayComponent cjComponent;
    private final Lazy eventService$delegate;
    private AtomicBoolean hostInitTriggered;
    private final Lazy hostService$delegate;
    private final Lazy logService$delegate;
    private ICJDemoRouter mCjPayDemoRouter;
    private volatile ITTCJPayUtilsCompat mCjPayUtils;
    private TTCJPayDoFaceLive mFaceLive;
    private final CopyOnWriteArrayList<Object> mNetInterceptors;
    private final Lazy monitorService$delegate;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u0014\u001a\u00020\u00152,\u0010\u0016\u001a(\u0012\u0004\u0012\u00020\u000e\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00150\u0017¢\u0006\u0002\b\u001bH\u0007J\b\u0010\u001c\u001a\u00020\u000eH\u0007R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048\u0002X\u0083D¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0002R\u001c\u0010\t\u001a\u00020\n8\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\u0002\u001a\u0004\b\t\u0010\fR!\u0010\r\u001a\u00020\u000e8FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u0012\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/android/ttcjpaysdk/ttcjpayapi/TTCJPayUtils$Companion;", "", "()V", "CJPAY_HOST", "", "getCJPAY_HOST", "()Ljava/lang/String;", "TAG", "getTAG$annotations", "isNew", "", "isNew$annotations", "()Z", "singleInstance", "Lcom/android/ttcjpaysdk/ttcjpayapi/TTCJPayUtils;", "getSingleInstance$annotations", "getSingleInstance", "()Lcom/android/ttcjpaysdk/ttcjpayapi/TTCJPayUtils;", "singleInstance$delegate", "Lkotlin/Lazy;", "ensureInitPlugin", "", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "loadPluginSuccess", "Lkotlin/ExtensionFunctionType;", "getInstance", "cjpay-se-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getSingleInstance$annotations() {
        }

        @JvmStatic
        private static /* synthetic */ void getTAG$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void isNew$annotations() {
        }

        public final String getCJPAY_HOST() {
            return TTCJPayUtils.access$getCJPAY_HOST$cp();
        }

        @JvmStatic
        public final TTCJPayUtils getInstance() {
            return getSingleInstance();
        }

        public final TTCJPayUtils getSingleInstance() {
            return (TTCJPayUtils) TTCJPayUtils.access$getSingleInstance$delegate$cp().getValue();
        }

        public final boolean isNew() {
            return TTCJPayUtils.access$isNew$cp();
        }

        @JvmStatic
        public final void ensureInitPlugin(final Function2<? super TTCJPayUtils, ? super Boolean, Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "callback");
            TTCJPayUtils.access$loadCJPluginAndGetCJPayUtils(getSingleInstance(), "ensureInitPlugin", new TTCJPayUtils$Companion$ensureInitPlugin$1(r100));
        }
    }

    /* JADX INFO: renamed from: com.android.ttcjpaysdk.ttcjpayapi.TTCJPayUtils$loadCJPluginAndGetCJPayUtils$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: loaded from: classes39.dex */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"com/android/ttcjpaysdk/ttcjpayapi/TTCJPayUtils$loadCJPluginAndGetCJPayUtils$1", "Lwe4/a;", "Lcom/bytedance/caijing/sdk/infra/base/api/env/plugin/CJPluginLoadedResult;", "Lwe4/b;", "result", "", "onResult", "cjpay-se-api_release"}, k = 1, mv = {1, 6, 0})
    public static final class C97251 implements we4.a<CJPluginLoadedResult> {
        final /* synthetic */ Function1<ITTCJPayUtilsCompat, Unit> $callback;
        final /* synthetic */ long $startTimestamp;
        final /* synthetic */ String $triggerFrom;
        final /* synthetic */ TTCJPayUtils this$0;

        @Override // we4.a
        public void onResult(we4.b<CJPluginLoadedResult> r110) {
            Intrinsics.checkNotNullParameter(r110, "result");
            TTCJPayUtils.access$getLogService(this.this$0).i(this.this$0.getTAG(), "[loadCJPluginAndGetCJPayUtils] loadPlugin result: " + r110);
            boolean r100 = true;
            if (r110.f559397c != CJPluginLoadedResult.SUCCESS) goto L5;
            boolean r101 = true;
        L6:
            ITTCJPayUtilsCompat r102 = TTCJPayUtils.access$getCJPayUtils(this.this$0, "loadSuccess_" + this.$triggerFrom);
            if (r102 != null) goto L10;
            r100 = false;
        L10:
            this.$callback.invoke(r102);
            TTCJPayUtils r103 = this.this$0;
            String r104 = TTCJPayUtils.access$getCJPAY_GET_CJPAYUTILS_AFTER_LOAD_PLUGIN$p(r103);
            JSONObject r105 = new JSONObject();
            long r106 = this.$startTimestamp;
            KtSafeMethodExtensionKt.safePut(r105, "load_error_msg", r110.f559396b);
            KtSafeMethodExtensionKt.safePut(r105, "duration", Long.valueOf(System.currentTimeMillis() - r106));
            String r111 = "1";
            if (r101 == false) goto L13;
            Object r107 = "1";
        L14:
            KtSafeMethodExtensionKt.safePut(r105, "loadPluginSuccess", r107);
            if (r100 == true) goto L18;
            r111 = "0";
        L18:
            KtSafeMethodExtensionKt.safePut(r105, "get_cjpayutils_success", r111);
            Unit r112 = Unit.INSTANCE;
            TTCJPayUtils.access$reportTea(r103, r104, r105);
            return;
        L13:
            r107 = "0";
            goto L14
        L5:
            r101 = false;
            goto L6
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C97251(TTCJPayUtils r100, String r101, Function1<? super ITTCJPayUtilsCompat, Unit> r102, long r103) {
            this.this$0 = r100;
            this.$triggerFrom = r101;
            this.$callback = r102;
            this.$startTimestamp = r103;
        }
    }

    public /* synthetic */ TTCJPayUtils(DefaultConstructorMarker r100) {
        this();
    }

    @JvmStatic
    public static final void ensureInitPlugin(Function2<? super TTCJPayUtils, ? super Boolean, Unit> r100) {
        Companion.ensureInitPlugin(r100);
    }

    @JvmStatic
    public static final TTCJPayUtils getInstance() {
        return Companion.getInstance();
    }

    public static final TTCJPayUtils getSingleInstance() {
        return Companion.getSingleInstance();
    }

    public static final boolean isNew() {
        return Companion.isNew();
    }

    public final boolean isCJSDKValid() {
        if (getCJPayUtils$default(this, null, 1, null) != null) goto L7;
        return false;
    L7:
        return true;
    }

    @Deprecated(message = "this function is deprecated!")
    public final TTCJPayUtils preLoadCheckoutCounterData(String r100, String r101, String r102, String r103) {
        return this;
    }

    @Deprecated(message = "this function is deprecated!")
    public final TTCJPayUtils preLoadCheckoutCounterData(String r100, String r101, String r102, String r103, String r104) {
        return this;
    }

    @Deprecated(message = "this function is deprecated!")
    public final TTCJPayUtils preLoadCheckoutCounterDataForH5(String r100, String r101, String r102, String r103, String r104) {
        return this;
    }

    @Deprecated(message = "this function is deprecated!")
    public final TTCJPayUtils privateFetchSettings() {
        return this;
    }

    @Deprecated(message = "this function is deprecated!")
    public final TTCJPayUtils setCustomUA(String r100) {
        Intrinsics.checkNotNullParameter(r100, BaseHttpRequestInfo.KEY_USER_AGENT);
        return this;
    }

    @Deprecated(message = "this function is deprecated!")
    public final TTCJPayUtils setIsAggregatePayment(boolean r100) {
        return this;
    }

    @Deprecated(message = "this function is deprecated!")
    public final TTCJPayUtils setIsBalancePaymentExposed(boolean r100) {
        return this;
    }

    @Deprecated(message = "this function is deprecated!")
    public final TTCJPayUtils setIsHideStatusBar(boolean r100) {
        return this;
    }

    @Deprecated(message = "this function is deprecated!")
    public final TTCJPayUtils updateLoginStatus(int r100) {
        return this;
    }

    static {
        Companion = new Companion(null);
        TAG = "TTCJPayUtils";
        singleInstance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, TTCJPayUtils$Companion$singleInstance$2.INSTANCE);
        CJPAY_HOST = "cjpay";
        isNew = true;
    }

    private final ICJDemoRouter getCJPayDemoRouter() {
        ICJDemoRouter r100 = this.mCjPayDemoRouter;     // Catch: Exception -> L11
        if (r100 == null) goto L6;
        return r100;
    L6:
        if (this.hostInitTriggered.getAndSet(true) == true) goto L8;
        getHostService().onSDKInvoke();     // Catch: Exception -> L11
    L8:
        ve4.a.f554342a.getClass();     // Catch: Exception -> L11
        this.mCjPayDemoRouter = (ICJDemoRouter) ve4.a.a(ICJDemoRouter.class);     // Catch: Exception -> L11
    L10:
        return this.mCjPayDemoRouter;
    }

    private final HashMap<String, Object> getCategoryCommonParams() {
        getHostService().getEnvController();
        getHostService().getEnvController();
        return MapsKt.hashMapOf(new Pair[]{TuplesKt.to("aid", getHostService().getHostAid()), TuplesKt.to("os_name", "Android" + Build.VERSION.RELEASE), TuplesKt.to("host_app_chanel", getHostService().getHostChannel()), TuplesKt.to("app_platform", "native"), TuplesKt.to("params_for_special", a.VALUE_PARAMS_FOR_SPECIAL), TuplesKt.to("is_chaselight", 1), TuplesKt.to("host_version_code", Integer.valueOf(getHostService().getHostVersionCode())), TuplesKt.to("host_update_version_code", Integer.valueOf(getHostService().getHostUpdateVersionCode())), TuplesKt.to("cj_plugin_sdk_version", null), TuplesKt.to("cj_plugin_host_version_code", null), TuplesKt.to("device_id", getHostService().getDeviceId()), TuplesKt.to("is_cjpay", 1), TuplesKt.to("is_grey_channel", Integer.valueOf(getHostService().isGreyChannel() ? 1 : 0))});
    }

    private final AppLogService getEventService() {
        return (AppLogService) this.eventService$delegate.getValue();
    }

    private final CJHostService getHostService() {
        return (CJHostService) this.hostService$delegate.getValue();
    }

    private final ALogService getLogService() {
        return (ALogService) this.logService$delegate.getValue();
    }

    private final MonitorService getMonitorService() {
        return (MonitorService) this.monitorService$delegate.getValue();
    }

    public final void bdPay() {
        ITTCJPayUtilsCompat r100 = getCJPayUtils("bdPay");
        if (r100 == null) goto L6;
        r100.bdPay();
        return;
    }

    public final void closeSDK() {
        ITTCJPayUtilsCompat r100 = getCJPayUtils("closeSDK");
        if (r100 == null) goto L6;
        r100.closeSDK();
        return;
    }

    public final void doRefreshOnNetworkError() {
        ITTCJPayUtilsCompat r100 = getCJPayUtils("doRefreshOnNetworkError");
        if (r100 == null) goto L6;
        r100.doRefreshOnNetworkError();
        return;
    }

    public final void execute() {
        ITTCJPayUtilsCompat r100 = getCJPayUtils("execute");
        if (r100 == null) goto L6;
        r100.execute();
        return;
    }

    public final void executeWithdraw() {
        ITTCJPayUtilsCompat r100 = getCJPayUtils("executeWithdraw");
        if (r100 == null) goto L6;
        r100.executeWithdraw();
        return;
    }

    public final void fastPayHideLoading() {
        ITTCJPayUtilsCompat r100 = getCJPayUtils("fastPayHideLoading");
        if (r100 == null) goto L6;
        r100.fastPayHideLoading();
        return;
    }

    public final void fastPayOnlySendRequest() {
        ITTCJPayUtilsCompat r100 = getCJPayUtils("fastPayOnlySendRequest");
        if (r100 == null) goto L6;
        r100.fastPayOnlySendRequest();
        return;
    }

    public final String getBioType() {
        ITTCJPayUtilsCompat r100 = getCJPayUtils("getBioType");
        if (r100 == null) goto L6;
        String r101 = r100.getBioType();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    public final JSONObject getCJPassThroughInfo() {
        ITTCJPayUtilsCompat r100 = getCJPayUtils("getCJPassThroughInfo");
        if (r100 == null) goto L7;
        JSONObject r101 = r100.getCJPassThroughInfo();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return new JSONObject();
    }

    public final JSONObject getFinanceRisk() {
        return getFinanceRiskWithScene$default(this, "default", "default", null, 4, null);
    }

    public final String getJailBreak() {
        ITTCJPayUtilsCompat r100 = getCJPayUtils("getJailBreak");
        if (r100 == null) goto L6;
        String r101 = r100.getJailBreak();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    public final String getSDKVersion() {
        ITTCJPayUtilsCompat r100 = getCJPayUtils("getSDKVersion");
        if (r100 == null) goto L6;
        String r101 = r100.getSDKVersion();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    public final void init() {
        ITTCJPayUtilsCompat r100 = getCJPayUtils("init");
        if (r100 == null) goto L6;
        r100.init();
        return;
    }

    public final void initMini() {
        ITTCJPayUtilsCompat r100 = getCJPayUtils("initMini");
        if (r100 == null) goto L6;
        r100.initMini();
        return;
    }

    private TTCJPayUtils() {
        this.TAG$1 = "TTCJPayUtils";
        this.OPEN_SCHEMA_EVENT_NAME = "cjpay_open_schema_entrance";
        this.CJPAY_OPEN_SCHEMA_AFTER_LOAD_PLUGIN = "cjpay_open_schema_after_load_plugin";
        this.CJPAY_GET_CJPAYUTILS_AFTER_LOAD_PLUGIN = "cjpay_get_cjpayutils_after_load_plugin";
        this.CJPAY_REGISTER_XBRIDGE_FAIL = "cjpay_register_xbridge_fail";
        this.CJPAY_CJPAYUTILS_IS_NULL = "cjpay_cjpayutils_is_null";
        this.mNetInterceptors = new CopyOnWriteArrayList();
        this.hostInitTriggered = new AtomicBoolean(false);
        this.hostService$delegate = LazyKt.lazy(TTCJPayUtils$hostService$2.INSTANCE);
        this.logService$delegate = LazyKt.lazy(TTCJPayUtils$logService$2.INSTANCE);
        this.eventService$delegate = LazyKt.lazy(TTCJPayUtils$eventService$2.INSTANCE);
        this.monitorService$delegate = LazyKt.lazy(TTCJPayUtils$monitorService$2.INSTANCE);
    }

    public final Map<String, Class<? extends Object>> getCJPayXBridgeMethods() {
        getLogService().i(this.TAG$1, "getCJPayXBridgeMethods invoke");
        ITTCJPayUtilsCompat r100 = getCJPayUtils("getCJPayXBridgeMethods");
        if (r100 == null) goto L7;
        Map<String, Class<? extends Object>> r101 = r100.getCJPayXBridgeMethods();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return new HashMap();
    }

    public final void preLoadFinanceRisk() {
        ITTCJPayUtilsCompat r100 = getCJPayUtils("preLoadFinanceRisk");
        if (r100 == null) goto L5;
        r100.preLoadFinanceRisk();
    L5:
        ITTCJPayUtilsCompat r101 = getCJPayUtils("getJailBreak");
        if (r101 == null) goto L9;
        r101.getJailBreak();
        return;
    }

    public final void preLoadYuefuTemplate() {
        ITTCJPayUtilsCompat r100 = getCJPayUtils("preLoadYuefuTemplate");
        if (r100 == null) goto L6;
        r100.preLoadYuefuTemplate();
        return;
    }

    public final void recharge() {
        ITTCJPayUtilsCompat r100 = getCJPayUtils(PbRequest.SwitchType.RECHARGE);
        if (r100 == null) goto L6;
        r100.recharge();
        return;
    }

    public final void registerCJPayXbridge() {
        getLogService().i(this.TAG$1, "registerCJPayXbridge invoke");
        ITTCJPayUtilsCompat r100 = getCJPayUtils("registerCJPayXbridge");
        if (r100 == null) goto L19;
        r100.registerCJPayXbridge();
        return;
    L19:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L15
        getLogService().i(this.TAG$1, "registerCJPayXbridge opt");     // Catch: Throwable -> L15
        ve4.a.f554342a.getClass();     // Catch: Throwable -> L15
        IJsbService r102 = (IJsbService) ve4.a.a(IJsbService.class);     // Catch: Throwable -> L15
        if (r102 == null) goto L10;
        r r103 = r102.getXBridgeHelper();     // Catch: Throwable -> L15
        if (r103 == null) goto L10;
        r103.a();     // Catch: Throwable -> L15
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L15
    L11:
        if (r104 != null) goto L13;
        String r105 = this.CJPAY_REGISTER_XBRIDGE_FAIL;     // Catch: Throwable -> L15
        JSONObject r106 = new JSONObject();     // Catch: Throwable -> L15
        KtSafeMethodExtensionKt.safePut(r106, "is_opt", "1");     // Catch: Throwable -> L15
        KtSafeMethodExtensionKt.safePut(r106, "getCJPayUtils", "null");     // Catch: Throwable -> L15
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L15
        reportTea(r105, r106);     // Catch: Throwable -> L15
    L13:
        Object r108 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        Result.m9448boximpl(r108);
        return;
    L10:
        r104 = null;
    L15:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    }

    public final void releaseAll() {
        ITTCJPayUtilsCompat r100 = getCJPayUtils("releaseAll");
        if (r100 == null) goto L6;
        r100.releaseAll();
        return;
    }

    public final void releaseAllFromSubProcess() {
        ITTCJPayUtilsCompat r100 = getCJPayUtils("releaseAllFromSubProcess");
        if (r100 == null) goto L6;
        r100.releaseAllFromSubProcess();
        return;
    }

    public final void sign() {
        ITTCJPayUtilsCompat r100 = getCJPayUtils("sign");
        if (r100 == null) goto L6;
        r100.sign();
        return;
    }

    public static final /* synthetic */ String access$getCJPAY_HOST$cp() {
        return CJPAY_HOST;
    }

    public static final /* synthetic */ Lazy access$getSingleInstance$delegate$cp() {
        return singleInstance$delegate;
    }

    public static final /* synthetic */ boolean access$isNew$cp() {
        return isNew;
    }

    public final ITTCJPayComponent getCjComponent() {
        return this.cjComponent;
    }

    public final String getTAG() {
        return this.TAG$1;
    }

    public static final /* synthetic */ String access$getCJPAY_GET_CJPAYUTILS_AFTER_LOAD_PLUGIN$p(TTCJPayUtils r100) {
        return r100.CJPAY_GET_CJPAYUTILS_AFTER_LOAD_PLUGIN;
    }

    public static final /* synthetic */ String access$getCJPAY_OPEN_SCHEMA_AFTER_LOAD_PLUGIN$p(TTCJPayUtils r100) {
        return r100.CJPAY_OPEN_SCHEMA_AFTER_LOAD_PLUGIN;
    }

    public static final /* synthetic */ ALogService access$getLogService(TTCJPayUtils r100) {
        return r100.getLogService();
    }

    private final ITTCJPayUtilsCompat getCJPayUtils(String r110) {
        ITTCJPayUtilsCompat r100 = this.mCjPayUtils;
        if (r100 == null) goto L5;
        return r100;
    L5:
        boolean r101 = true;
        if (this.hostInitTriggered.getAndSet(true) == true) goto L8;
        getHostService().onSDKInvoke();
    L8:
        int r102 = vc4.a.f554107a;
        ve4.a.f554342a.getClass();
        CJPayApiService r103 = (CJPayApiService) ve4.a.a(CJPayApiService.class);
        if (r103 == null) goto L11;
        ITTCJPayUtilsCompat r104 = r103.getTTCJPayUtilsCompat();
    L12:
        this.mCjPayUtils = r104;
        ITTCJPayUtilsCompat r105 = this.mCjPayUtils;
        if (r105 == null) goto L29;
        Iterator<T> r106 = this.mNetInterceptors.iterator();
    L16:
        if (r106.hasNext() == false) goto L18;
        r105.setNetworkInterceptor(r106.next());
        goto L16
    L18:
        r105.setFaceLive(this.mFaceLive);
        if (getHostService().isLocalTestChannel() == false) goto L29;
        INetEnv r107 = getHostService().getNetEnvHelper();
        if (r107 != null) goto L23;
    L25:
        r101 = false;
    L26:
        if (r101 == false) goto L29;
        r105.setServerType(2);
        goto L29
    L23:
        if (r107.isBoe() != true) goto L25;
    L29:
        if (this.mCjPayUtils != null) goto L41;
        if (getHostService().isLocalTestChannel() == false) goto L35;
        ve4.a.f554342a.getClass();
        CJLocalTestService r108 = (CJLocalTestService) ve4.a.a(CJLocalTestService.class);
        if (r108 == null) goto L35;
        r108.showPluginNotReadyEnvTip();
    L35:
        getLogService().w(this.TAG$1, "mCjPayUtils is null!");
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L38
        String r111 = this.CJPAY_CJPAYUTILS_IS_NULL;     // Catch: Throwable -> L38
        JSONObject r112 = new JSONObject();     // Catch: Throwable -> L38
        KtSafeMethodExtensionKt.safePut(r112, "trigger_from", r110);     // Catch: Throwable -> L38
        KtSafeMethodExtensionKt.safePut(r112, "stack_trace", ArraysKt.joinToString$default(ThreadMethodProxy.currentThread().getStackTrace(), "\n ", null, null, 0, null, null, 62, null));     // Catch: Throwable -> L38
        Unit r113 = Unit.INSTANCE;     // Catch: Throwable -> L38
        reportTea(r111, r112);     // Catch: Throwable -> L38
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L41:
        return this.mCjPayUtils;
    L11:
        r104 = null;
        goto L12
    }

    public final void bdPayForImRedPacket(String r100) {
        ITTCJPayUtilsCompat r101 = getCJPayUtils("bdPayForImRedPacket");
        if (r101 == null) goto L6;
        r101.bdPayForImRedPacket(r100);
        return;
    }

    public final void fastPay(int r100) {
        ITTCJPayUtilsCompat r101 = getCJPayUtils("fastPay");
        if (r101 == null) goto L6;
        r101.fastPay(r100);
        return;
    }

    public final void fastPayShowLoading(int r100) {
        ITTCJPayUtilsCompat r101 = getCJPayUtils("fastPayShowLoading");
        if (r101 == null) goto L6;
        r101.fastPayShowLoading(r100);
        return;
    }

    @Deprecated(message = "to be removed")
    public final int getAppVersionCode(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "applicationContext");
        ITTCJPayUtilsCompat r101 = getCJPayUtils("getAppVersionCode");
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.getAppVersionCode(r100);
    }

    public final JSONObject getCJPayInfo(HashMap<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "sceneContext");
        ITTCJPayUtilsCompat r101 = getCJPayUtils("getCJPayInfo");
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getCJPayInfo(r100);
    }

    public final ITTCJPayComponent getPayComponent(IPayLifecycle r100) {
        ITTCJPayUtilsCompat r101 = getCJPayUtils("getPayComponent");
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getPayComponent(r100);
    }

    public final String getSettingsInfo(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        ITTCJPayUtilsCompat r101 = getCJPayUtils("getSettingsInfo");
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getSettingsInfo(r100);
    }

    public final boolean isCloudUnionPayInstalled(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        ITTCJPayUtilsCompat r101 = getCJPayUtils("cloudUnionPay");
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.isCloudUnionPayInstalled(r100);
    }

    public final void myBankCard(String r100) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        ITTCJPayUtilsCompat r101 = getCJPayUtils("myBankCard");
        if (r101 == null) goto L6;
        r101.myBankCard(r100);
        return;
    }

    public final void openH5ByScheme(String r110) {
        Intrinsics.checkNotNullParameter(r110, "scheme");
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L22
        ITTCJPayUtilsCompat r101 = getCJPayUtils("openH5ByScheme");     // Catch: Throwable -> L22
        if (r101 == null) goto L33;
        r101.openH5ByScheme(r110);     // Catch: Throwable -> L22
        boolean r102 = true;
    L12:
        String r103 = this.OPEN_SCHEMA_EVENT_NAME;     // Catch: Throwable -> L22
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L22
        KtSafeMethodExtensionKt.safePut(r104, "schema", r110);     // Catch: Throwable -> L22
        KtSafeMethodExtensionKt.safePut(r104, "first_open_success", KtSafeMethodExtensionKt.tf(r102, "1", "0"));     // Catch: Throwable -> L22
        String r105 = CJSchemaExtensionKt.getQueryParameter(r110, "url");     // Catch: Throwable -> L22
        String r106 = "";
        if (r105 != null) goto L16;
        r105 = "";
    L16:
        KtSafeMethodExtensionKt.safePut(r104, "url", r105);     // Catch: Throwable -> L22
        String r107 = CJSchemaExtensionKt.getQueryParameter(r110, "surl");     // Catch: Throwable -> L22
        if (r107 == null) goto L20;
        r106 = r107;
    L20:
        KtSafeMethodExtensionKt.safePut(r104, "surl", r106);     // Catch: Throwable -> L22
        KtSafeMethodExtensionKt.safePut(r104, "function", "openH5ByScheme");     // Catch: Throwable -> L22
        KtSafeMethodExtensionKt.safePut(r104, "tag", "1");     // Catch: Throwable -> L22
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L22
        reportTea(r103, r104);     // Catch: Throwable -> L22
        Object r109 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L22
    L24:
        Throwable r111 = Result.m9452exceptionOrNullimpl(r109);
        if (r111 == null) goto L35;
        ITTCJPayUtilsCompat r112 = getCJPayUtils("openH5ByScheme");
        if (r112 == null) goto L29;
        r112.openH5ByScheme(r110);
    L29:
        getLogService().i(this.TAG$1, r111.getMessage());
        return;
    L35:
        return;
    L33:
        System.currentTimeMillis();     // Catch: Throwable -> L9
        getHostService().getEnvController();     // Catch: Throwable -> L9
        Object r113 = Result.m9449constructorimpl(null);     // Catch: Throwable -> L9
    L11:
        Result.m9448boximpl(r113);     // Catch: Throwable -> L22
        r102 = false;
        goto L12
    L9:
        th = move-exception;
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L22
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L24
    }

    public final void openOCR(ICJPayServiceRetCallBack r100) {
        ITTCJPayUtilsCompat r101 = getCJPayUtils("openOCR1");
        if (r101 == null) goto L6;
        r101.openOCR(r100);
        return;
    }

    public final TTCJPayUtils setAid(String r100) {
        ITTCJPayUtilsCompat r101 = getCJPayUtils("setAid");
        if (r101 == null) goto L5;
        r101.setAid(r100);
    L5:
        return this;
    }

    public final TTCJPayUtils setAnimationResourceMap(Map<String, Integer> r100) {
        ITTCJPayUtilsCompat r101 = getCJPayUtils("setAnimationResourceMap");
        if (r101 == null) goto L5;
        r101.setAnimationResourceMap(r100);
    L5:
        return this;
    }

    public final TTCJPayUtils setAppId(String r100) {
        ITTCJPayUtilsCompat r101 = getCJPayUtils("setAppId");
        if (r101 == null) goto L5;
        r101.setAppId(r100);
    L5:
        return this;
    }

    public final TTCJPayUtils setAppUpdateVersion(String r100) {
        ITTCJPayUtilsCompat r101 = getCJPayUtils("setAppUpdateVersion");
        if (r101 == null) goto L5;
        r101.setAppUpdateVersion(r100);
    L5:
        return this;
    }

    public final TTCJPayUtils setBackEnable(boolean r100) {
        ITTCJPayUtilsCompat r101 = getCJPayUtils("setBackEnable");
        if (r101 == null) goto L5;
        r101.setBackEnable(r100);
    L5:
        return this;
    }

    public final TTCJPayUtils setBasicModeCallback(IBasicMode r100) {
        Intrinsics.checkNotNullParameter(r100, "basicModeCallback");
        ITTCJPayUtilsCompat r101 = getCJPayUtils("setBasicModeCallback");
        if (r101 == null) goto L5;
        r101.setBasicModeCallback(r100);
    L5:
        return this;
    }

    public final TTCJPayUtils setBlockDialog(IBlockDialog r100) {
        Intrinsics.checkNotNullParameter(r100, "blockDialog");
        ITTCJPayUtilsCompat r101 = getCJPayUtils("setBlockDialog");
        if (r101 == null) goto L5;
        r101.setBlockDialog(r100);
    L5:
        return this;
    }

    @Deprecated(message = "this function is deprecated!")
    public final TTCJPayUtils setBoeEnv(String r100) {
        ITTCJPayUtilsCompat r101 = getCJPayUtils("setBoeEnv");
        if (r101 == null) goto L5;
        r101.setBoeEnv(r100);
    L5:
        return this;
    }

    public final void setCjComponent(ITTCJPayComponent r100) {
        this.cjComponent = r100;
    }

    public final TTCJPayUtils setContext(Context r100) {
        ITTCJPayUtilsCompat r101 = getCJPayUtils("setContext");
        if (r101 == null) goto L5;
        r101.setContext(r100);
    L5:
        return this;
    }

    @Deprecated(message = "this function is deprecated!")
    public final TTCJPayUtils setCustomActionListener(ICustomActionListener r100) {
        ITTCJPayUtilsCompat r101 = getCJPayUtils("setCustomActionListener");
        if (r101 == null) goto L5;
        r101.setCustomActionListener(r100);
    L5:
        return this;
    }

    public final TTCJPayUtils setCustomerServiceCallback(ICustomerServiceCallback r100) {
        Intrinsics.checkNotNullParameter(r100, "customerServiceCallback");
        ITTCJPayUtilsCompat r101 = getCJPayUtils("setCustomerServiceCallback");
        if (r101 == null) goto L5;
        r101.setCustomerServiceCallback(r100);
    L5:
        return this;
    }

    public final TTCJPayUtils setDid(String r100) {
        ITTCJPayUtilsCompat r101 = getCJPayUtils("setDid");
        if (r101 == null) goto L5;
        r101.setDid(r100);
    L5:
        return this;
    }

    public final TTCJPayUtils setEnvChannel(String r100) {
        ITTCJPayUtilsCompat r101 = getCJPayUtils("setEnvChannel");
        if (r101 == null) goto L5;
        r101.setEnvChannel(r100);
    L5:
        return this;
    }

    @Deprecated(message = "this function is deprecated!")
    public final TTCJPayUtils setEvent(TTCJPayEvent r100) {
        ITTCJPayUtilsCompat r101 = getCJPayUtils("setEvent");
        if (r101 == null) goto L5;
        r101.setEvent(r100);
    L5:
        return this;
    }

    public final TTCJPayUtils setExternalEventCenterAdapter(ICJExternalEventCenterAdapter r100) {
        ITTCJPayUtilsCompat r101 = getCJPayUtils("setExternalEventCenterAdapter");
        if (r101 == null) goto L5;
        r101.setExternalEventCenterAdapter(r100);
    L5:
        return this;
    }

    public final TTCJPayUtils setExternalLynxServiceAdapter(ICJExternalLynxServiceAdapter r100) {
        ITTCJPayUtilsCompat r101 = getCJPayUtils("setExternalLynxServiceAdapter");
        if (r101 == null) goto L5;
        r101.setExternalLynxServiceAdapter(r100);
    L5:
        return this;
    }

    public final TTCJPayUtils setExtraHeaderMap(HashMap<String, String> r100) {
        ITTCJPayUtilsCompat r101 = getCJPayUtils("setExtraHeaderMap");
        if (r101 == null) goto L5;
        r101.setExtraHeaderMap(r100);
    L5:
        return this;
    }

    public final TTCJPayUtils setFaceLive(TTCJPayDoFaceLive r100) {
        if (this.mCjPayUtils == null) goto L7;
        ITTCJPayUtilsCompat r101 = this.mCjPayUtils;
        if (r101 == null) goto L8;
        r101.setFaceLive(r100);
    L8:
        return this;
    L7:
        this.mFaceLive = r100;
        goto L8
    }

    public final void setFollowSystemTheme(boolean r100) {
        ITTCJPayUtilsCompat r101 = getCJPayUtils("setFollowSystemTheme");
        if (r101 == null) goto L6;
        r101.setFollowSystemTheme(r100);
        return;
    }

    public final TTCJPayUtils setFontScale(float r100) {
        ITTCJPayUtilsCompat r101 = getCJPayUtils("setFontScale");
        if (r101 == null) goto L5;
        r101.setFontScale(r100);
    L5:
        return this;
    }

    public final TTCJPayUtils setFromImRedPacket(boolean r100) {
        ITTCJPayUtilsCompat r101 = getCJPayUtils("setFromImRedPacket");
        if (r101 == null) goto L5;
        r101.setFromImRedPacket(r100);
    L5:
        return this;
    }

    public final TTCJPayUtils setGameNewCounterStyle(boolean r100) {
        ITTCJPayUtilsCompat r101 = getCJPayUtils("setGameNewCounterStyle");
        if (r101 == null) goto L5;
        r101.setGameNewCounterStyle(r100);
    L5:
        return this;
    }

    public final TTCJPayUtils setGameNewStyle(boolean r100) {
        ITTCJPayUtilsCompat r101 = getCJPayUtils("setGameNewStyle");
        if (r101 == null) goto L5;
        r101.setGameNewStyle(r100);
    L5:
        return this;
    }

    public final TTCJPayUtils setH5NotificationCallback(IH5NotificationCallback r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        ITTCJPayUtilsCompat r101 = getCJPayUtils("setH5NotificationCallback");
        if (r101 == null) goto L5;
        r101.setH5NotificationCallback(r100);
    L5:
        return this;
    }

    public final void setHostJSBMethodsInterface(TTCJPayHostJSBMethodsInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "hostJSBMethodsInterface");
        ITTCJPayUtilsCompat r101 = getCJPayUtils("setHostJSBMethodsInterface");
        if (r101 == null) goto L6;
        r101.setHostJSBMethodsInterface(r100);
        return;
    }

    public final TTCJPayUtils setHostLoginService(ICJHostLoginService r100) {
        Intrinsics.checkNotNullParameter(r100, "loginService");
        ITTCJPayUtilsCompat r101 = getCJPayUtils("setHostLoginService");
        if (r101 == null) goto L5;
        r101.setHostLoginService(r100);
    L5:
        return this;
    }

    public final TTCJPayUtils setHostPrivacyService(ICJHostPrivacyService r100) {
        Intrinsics.checkNotNullParameter(r100, "service");
        ITTCJPayUtilsCompat r101 = getCJPayUtils("setHostPrivacyService");
        if (r101 == null) goto L5;
        r101.setHostPrivacyService(r100);
    L5:
        return this;
    }

    public final void setInheritTheme(String r100) {
        ITTCJPayUtilsCompat r101 = getCJPayUtils("setInheritTheme");
        if (r101 == null) goto L6;
        r101.setInheritTheme(r100);
        return;
    }

    public final TTCJPayUtils setIntegratedHostDomain(String r100) {
        ITTCJPayUtilsCompat r101 = getCJPayUtils("setIntegratedHostDomain");
        if (r101 == null) goto L5;
        r101.setIntegratedHostDomain(r100);
    L5:
        return this;
    }

    public final TTCJPayUtils setIsTransCheckoutCounterActivityWhenLoading(boolean r100) {
        ITTCJPayUtilsCompat r101 = getCJPayUtils("setIsTransCheckoutCounterActivityWhenLoading");
        if (r101 == null) goto L5;
        r101.setIsTransCheckoutCounterActivityWhenLoading(r100);
    L5:
        return this;
    }

    public final TTCJPayUtils setIsUsingGecko(boolean r100) {
        ITTCJPayUtilsCompat r101 = getCJPayUtils("setIsUsingGecko");
        if (r101 == null) goto L5;
        r101.setIsUsingGecko(r100);
    L5:
        return this;
    }

    public final TTCJPayUtils setIsUsingTTNet(boolean r100) {
        ITTCJPayUtilsCompat r101 = getCJPayUtils("setIsUsingTTNet");
        if (r101 == null) goto L5;
        r101.setIsUsingTTNet(r100);
    L5:
        return this;
    }

    public final TTCJPayUtils setJSBridgeAuth(boolean r100) {
        ITTCJPayUtilsCompat r101 = getCJPayUtils("setJSBridgeAuth");
        if (r101 == null) goto L5;
        r101.setJSBridgeAuth(r100);
    L5:
        return this;
    }

    public final TTCJPayUtils setLanguageTypeStr(String r100) {
        ITTCJPayUtilsCompat r101 = getCJPayUtils("setLanguageTypeStr");
        if (r101 == null) goto L5;
        r101.setLanguageTypeStr(r100);
    L5:
        return this;
    }

    public final <T> TTCJPayUtils setLoadingAdapter(TTCJPayLoadingAdapter<T> r100) {
        ITTCJPayUtilsCompat r101 = getCJPayUtils("setLoadingAdapter");
        if (r101 == null) goto L5;
        r101.setLoadingAdapter(r100);
    L5:
        return this;
    }

    public final TTCJPayUtils setLoginToken(Map<String, String> r100) {
        ITTCJPayUtilsCompat r101 = getCJPayUtils("setLoginToken");
        if (r101 == null) goto L5;
        r101.setLoginToken(r100);
    L5:
        return this;
    }

    public final TTCJPayUtils setMerchantId(String r100) {
        ITTCJPayUtilsCompat r101 = getCJPayUtils("setMerchantId");
        if (r101 == null) goto L5;
        r101.setMerchantId(r100);
    L5:
        return this;
    }

    public final TTCJPayUtils setMonitor(TTCJPayMonitor r100) {
        ITTCJPayUtilsCompat r101 = getCJPayUtils("setMonitor");
        if (r101 == null) goto L5;
        r101.setMonitor(r100);
    L5:
        return this;
    }

    @Deprecated(message = "聚合收银台已不适用，将默认展示loading")
    public final TTCJPayUtils setNeedLoading(boolean r100) {
        ITTCJPayUtilsCompat r101 = getCJPayUtils("setNeedLoading");
        if (r101 == null) goto L5;
        r101.setNeedLoading(r100);
    L5:
        return this;
    }

    public final TTCJPayUtils setNetworkErrorAdapter(TTCJPayNetworkErrorAdapter r100) {
        ITTCJPayUtilsCompat r101 = getCJPayUtils("setNetworkErrorAdapter");
        if (r101 == null) goto L5;
        r101.setNetworkErrorAdapter(r100);
    L5:
        return this;
    }

    public final void setNetworkInterceptor(Object r100) {
        if (this.mCjPayUtils == null) goto L7;
        ITTCJPayUtilsCompat r101 = this.mCjPayUtils;
        if (r101 == null) goto L10;
        r101.setNetworkInterceptor(r100);
        return;
    L10:
        return;
    L7:
        if (r100 == null) goto L12;
        this.mNetInterceptors.add(r100);
        return;
    }

    public final TTCJPayUtils setObserver(TTCJPayObserver r100) {
        ITTCJPayUtilsCompat r101 = getCJPayUtils("setObserver");
        if (r101 == null) goto L5;
        r101.setObserver(r100);
    L5:
        return this;
    }

    @Deprecated(message = "this function is deprecated!")
    public final TTCJPayUtils setOpenSchemeCallback(TTCJPayOpenSchemeInterface r100) {
        ITTCJPayUtilsCompat r101 = getCJPayUtils("setOpenSchemeCallback");
        if (r101 == null) goto L5;
        r101.setOpenSchemeCallback(r100);
    L5:
        return this;
    }

    public final TTCJPayUtils setOpenSchemeWithContextCallback(TTCJPayOpenSchemeWithContextInterface r100) {
        ITTCJPayUtilsCompat r101 = getCJPayUtils("setOpenSchemeWithContextCallback");
        if (r101 == null) goto L5;
        r101.setOpenSchemeWithContextCallback(r100);
    L5:
        return this;
    }

    public final TTCJPayUtils setPhoneCarrierService(ITTCJPayPhoneCarrierService r100) {
        Intrinsics.checkNotNullParameter(r100, "phoneCarrierService");
        ITTCJPayUtilsCompat r101 = getCJPayUtils("setPhoneCarrierService");
        if (r101 == null) goto L5;
        r101.setPhoneCarrierService(r100);
    L5:
        return this;
    }

    public final TTCJPayUtils setRequestParams(Map<String, String> r100) {
        ITTCJPayUtilsCompat r101 = getCJPayUtils("setRequestParams");
        if (r101 == null) goto L5;
        r101.setRequestParams(r100);
    L5:
        return this;
    }

    public final TTCJPayUtils setRiskInfoParams(Map<String, String> r100) {
        ITTCJPayUtilsCompat r101 = getCJPayUtils("setRiskInfoParams");
        if (r101 == null) goto L5;
        r101.setRiskInfoParams(r100);
    L5:
        return this;
    }

    public final TTCJPayUtils setScreenOrientationType(int r100) {
        ITTCJPayUtilsCompat r101 = getCJPayUtils("setScreenOrientationType");
        if (r101 == null) goto L5;
        r101.setScreenOrientationType(r100);
    L5:
        return this;
    }

    @Deprecated(message = "this function is deprecated!")
    public final TTCJPayUtils setServerType(int r100) {
        ITTCJPayUtilsCompat r101 = getCJPayUtils("setServerType");
        if (r101 == null) goto L5;
        r101.setServerType(r100);
    L5:
        return this;
    }

    public final TTCJPayUtils setTitleBitmap(Bitmap r100) {
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        ITTCJPayUtilsCompat r101 = getCJPayUtils("setTitleBitmap");
        if (r101 == null) goto L5;
        r101.setTitleBitmap(r100);
    L5:
        return this;
    }

    public final TTCJPayUtils setTitleStr(String r100) {
        Intrinsics.checkNotNullParameter(r100, "titleStr");
        ITTCJPayUtilsCompat r101 = getCJPayUtils("setTitleStr");
        if (r101 == null) goto L5;
        r101.setTitleStr(r100);
    L5:
        return this;
    }

    public final TTCJPayUtils setToastAdapter(TTCJPayToastAdapter r100) {
        ITTCJPayUtilsCompat r101 = getCJPayUtils("setToastAdapter");
        if (r101 == null) goto L5;
        r101.setToastAdapter(r100);
    L5:
        return this;
    }

    public final TTCJPayUtils setTrackInfo(JSONObject r100) {
        ITTCJPayUtilsCompat r101 = getCJPayUtils("setTrackInfo");
        if (r101 == null) goto L5;
        r101.setTrackInfo(r100);
    L5:
        return this;
    }

    public final TTCJPayUtils setUid(String r100) {
        ITTCJPayUtilsCompat r101 = getCJPayUtils("setUid");
        if (r101 == null) goto L5;
        r101.setUid(r100);
    L5:
        return this;
    }

    public final TTCJPayUtils setUnifyHideLoading(boolean r100) {
        ITTCJPayUtilsCompat r101 = getCJPayUtils("setUnifyHideLoading");
        if (r101 == null) goto L5;
        r101.setUnifyHideLoading(r100);
    L5:
        return this;
    }

    public final void tradeManager(String r100) {
        Intrinsics.checkNotNullParameter(r100, "smchId");
        ITTCJPayUtilsCompat r101 = getCJPayUtils("tradeManager");
        if (r101 == null) goto L6;
        r101.tradeManager(r100);
        return;
    }

    public final void tradeRecord(String r100) {
        Intrinsics.checkNotNullParameter(r100, "smchId");
        ITTCJPayUtilsCompat r101 = getCJPayUtils("tradeRecord");
        if (r101 == null) goto L6;
        r101.tradeRecord(r100);
        return;
    }

    public static final /* synthetic */ ITTCJPayUtilsCompat access$getCJPayUtils(TTCJPayUtils r100, String r101) {
        return r100.getCJPayUtils(r101);
    }

    private final void loadCJPluginAndGetCJPayUtils(String r100, Function1<? super ITTCJPayUtilsCompat, Unit> r101) {
        ITTCJPayUtilsCompat r102 = getCJPayUtils("loadCJPlugin_" + r100);
        if (r102 == null) goto L5;
        r101.invoke(r102);
        Unit r103 = Unit.INSTANCE;
    L6:
        if (r103 != null) goto L9;
        System.currentTimeMillis();
        getHostService().getEnvController();
        r101.invoke(getCJPayUtils("fallback_" + r100));
        return;
    L9:
        return;
    L5:
        r103 = null;
        goto L6
    }

    private final void reportTea(String r100, JSONObject r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L4
        JSONObject r103 = new JSONObject(getCategoryCommonParams());     // Catch: Throwable -> L4
        KtSafeMethodExtensionKt.safePutAll(r103, r101);     // Catch: Throwable -> L4
        KtSafeMethodExtensionKt.safePut(r103, "report_event_name", r100);     // Catch: Throwable -> L4
        getEventService().onEventV3(r100, r103);     // Catch: Throwable -> L4
        getLogService().i(this.TAG$1, r103.toString());     // Catch: Throwable -> L4
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public final boolean handleCodeScanResult(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "url");
        List r102 = CollectionsKt.listOf(new String[]{"https://tp-pay.snssdk.com/.*", "https://api.doupay.com/.*", "https://pay-boe.snssdk.com/.*"});
        getLogService().i(this.TAG$1, "handleCodeScanResult url:" + r101);
        List r103 = r102;
        if ((r103 instanceof Collection) == true) goto L5;
    L7:
        Iterator r104 = r103.iterator();
    L9:
        if (r104.hasNext() == false) goto L6;
        if (new Regex((String) r104.next()).matches(r101) == false) goto L9;
        boolean r105 = true;
    L13:
        if (r105 == false) goto L21;
        ITTCJPayUtilsCompat r106 = getCJPayUtils("handleCodeScanResult");
        if (r106 != null) goto L17;
        return false;
    L17:
        return r106.verifyScanResultSync(r100, r101);
    L21:
        return false;
    L6:
        r105 = false;
        goto L13
    L5:
        if (r103.isEmpty() == false) goto L7;
        goto L6
    }

    public final void openOCR(String r100, ICJPayServiceRetCallBack r101) {
        Intrinsics.checkNotNullParameter(r100, b.f276366p);
        ITTCJPayUtilsCompat r102 = getCJPayUtils("openOCR");
        if (r102 == null) goto L6;
        r102.openOCR(r100, r101);
        return;
    }

    public final void openTestPage(Activity r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "schema");
        ICJDemoRouter r102 = getCJPayDemoRouter();
        if (r102 == null) goto L6;
        r102.openTestPage(r100, r101);
        return;
    }

    public final String readString(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "defaultValue");
        ITTCJPayUtilsCompat r102 = getCJPayUtils("readString");
        if (r102 == null) goto L9;
        String r103 = r102.readString(r100, r101);
        if (r103 != null) goto L8;
        return r101;
    L8:
        return r103;
    L9:
        return r101;
    }

    public final void storeString(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        ITTCJPayUtilsCompat r102 = getCJPayUtils("storeString");
        if (r102 == null) goto L6;
        r102.storeString(r100, r101);
        return;
    }

    public static final /* synthetic */ void access$loadCJPluginAndGetCJPayUtils(TTCJPayUtils r100, String r101, Function1 r102) {
        r100.loadCJPluginAndGetCJPayUtils(r101, r102);
    }

    public static final /* synthetic */ void access$reportTea(TTCJPayUtils r100, String r101, JSONObject r102) {
        r100.reportTea(r101, r102);
    }

    public final void aliPay(Context r100, String r101, ICJPayBasisPaymentService.OnPayResultCallback r102) {
        ITTCJPayUtilsCompat r103 = getCJPayUtils("aliPay2");
        if (r103 == null) goto L6;
        r103.aliPay(r100, r101, r102);
        return;
    }

    public final void cloudUnionPay(Context r100, String r101, ICJPayBasisPaymentService.OnPayResultCallback r102) {
        ITTCJPayUtilsCompat r103 = getCJPayUtils("cloudUnionPay2");
        if (r103 == null) goto L6;
        r103.cloudUnionPay(r100, r101, r102);
        return;
    }

    public final void executeCloseAndCallback(Context r100, String r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, e.f25671s);
        Intrinsics.checkNotNullParameter(r102, "params");
        ITTCJPayUtilsCompat r103 = getCJPayUtils("executeCloseAndCallback");
        if (r103 == null) goto L6;
        r103.executeCloseAndCallback(r100, r101, r102);
        return;
    }

    public final JSONObject getFinanceRiskWithScene(String r100, String r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "triggerAction");
        ITTCJPayUtilsCompat r103 = getCJPayUtils("getFinanceRiskWithScene");
        if (r103 == null) goto L7;
        JSONObject r104 = r103.getFinanceRiskWithScene(r100, r101, r102);
        if (r104 == null) goto L7;
        return r104;
    L7:
        return new JSONObject();
    }

    public final void openPayScoreWithParams(Context r100, JSONObject r101, ICJPayXBridgeCallback r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        ITTCJPayUtilsCompat r103 = getCJPayUtils("openPayScoreWithParams");
        if (r103 == null) goto L6;
        r103.openPayScoreWithParams(r100, r101, r102);
        return;
    }

    public final void outerBDPay(Context r100, String r101, wc4.a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "payCallback");
        ITTCJPayUtilsCompat r103 = getCJPayUtils("outerBDPay");
        if (r103 == null) goto L6;
        r103.outerBDPay(r100, r101, r102);
        return;
    }

    public static /* synthetic */ ITTCJPayUtilsCompat getCJPayUtils$default(TTCJPayUtils r100, String r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = "unknown";
    L6:
        return r100.getCJPayUtils(r101);
    }

    public static /* synthetic */ TTCJPayUtils setBackEnable$default(TTCJPayUtils r100, boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = false;
    L6:
        return r100.setBackEnable(r101);
    }

    public final void aliPay(Context r100, String r101, ICJPayBasisPaymentService.OnPayResultCallback r102, ICJPayBasisPaymentService.OnResultCallback r103) {
        ITTCJPayUtilsCompat r104 = getCJPayUtils("aliPay1");
        if (r104 == null) goto L6;
        r104.aliPay(r100, r101, r102, r103);
        return;
    }

    public final void authAlipay(final Activity r100, final String r101, final boolean r102, final TTCJPayAlipayAuthCallback r103) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, w.META_COLL_KEY_AUTH_INFO);
        Intrinsics.checkNotNullParameter(r103, "callback");
        ITTCJPayUtilsCompat r104 = getCJPayUtils("authAlipay");
        if (r104 == null) goto L5;
        r104.authAlipay(r100, r101, r102, r103);
        Unit r105 = Unit.INSTANCE;
    L6:
        if (r105 != null) goto L9;
        loadCJPluginAndGetCJPayUtils("authAlipay", new AnonymousClass1(r100, r101, r102, r103));
        return;
    L9:
        return;
    L5:
        r105 = null;
        goto L6
    }

    public final void cloudUnionPay(Context r100, String r101, ICJPayBasisPaymentService.OnPayResultCallback r102, ICJPayBasisPaymentService.OnResultCallback r103) {
        ITTCJPayUtilsCompat r104 = getCJPayUtils("cloudUnionPay1");
        if (r104 == null) goto L6;
        r104.cloudUnionPay(r100, r101, r102, r103);
        return;
    }

    @Deprecated(message = "this function is deprecated!", replaceWith = @ReplaceWith(expression = "execute()", imports = {}))
    public final void executeAggregatePayment(int r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "tradeName");
        Intrinsics.checkNotNullParameter(r102, "appId");
        Intrinsics.checkNotNullParameter(r103, "merchantId");
        ITTCJPayUtilsCompat r104 = getCJPayUtils("executeAggregatePayment");
        if (r104 == null) goto L6;
        r104.executeAggregatePayment(r100, r101, r102, r103);
        return;
    }

    public final void handleXBridgeMethod(Context r100, String r101, JSONObject r102, ICJPayXBridgeCallback r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, e.f25671s);
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r103, "callback");
        ITTCJPayUtilsCompat r104 = getCJPayUtils("handleXBridgeMethod");
        if (r104 == null) goto L6;
        r104.handleXBridgeMethod(r100, r101, r102, r103);
        return;
    }

    public final void openH5(String r100, String r101, String r102, String r110) {
        openH5(r100, r101, r102, r110, null);
        String r103 = this.OPEN_SCHEMA_EVENT_NAME;
        JSONObject r104 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r104, "schema", r100);
        KtSafeMethodExtensionKt.safePut(r104, "function", "openH5");
        KtSafeMethodExtensionKt.safePut(r104, "tag", "1");
        Unit r105 = Unit.INSTANCE;
        reportTea(r103, r104);
    }

    public final void routeSign(Context r100, Map<String, String> r101, Map<String, ? extends Object> r102, wc4.a r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, d.D);
        ITTCJPayUtilsCompat r104 = getCJPayUtils("routeSign");
        if (r104 == null) goto L6;
        r104.routeSign(r100, r101, r102, r103);
        return;
    }

    public final void wxPay(Context r100, String r101, String r102, ICJPayBasisPaymentService.OnPayResultCallback r103) {
        Intrinsics.checkNotNullParameter(r102, "wxPayType");
        ITTCJPayUtilsCompat r104 = getCJPayUtils("wxPay2");
        if (r104 == null) goto L6;
        r104.wxPay(r100, r101, r102, r103);
        return;
    }

    public final void externalBizReport(String r100, String r110, long r111, String r112, JSONObject r113) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r110, "name");
        Intrinsics.checkNotNullParameter(r112, SocialConstants.PARAM_APP_DESC);
        ITTCJPayUtilsCompat r101 = getCJPayUtils("externalBizReport");
        if (r101 == null) goto L6;
        r101.externalBizReport(r100, r110, r111, r112, r113);
        return;
    }

    public final void openH5(String r100, String r101, String r110, String r111, String r112) {
        ITTCJPayUtilsCompat r102 = getCJPayUtils("openH5");
        if (r102 == null) goto L5;
        r102.openH5(r100, r101, r110, r111, r112);
    L5:
        String r103 = this.OPEN_SCHEMA_EVENT_NAME;
        JSONObject r113 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r113, "schema", r100);
        KtSafeMethodExtensionKt.safePut(r113, "function", "openH5");
        KtSafeMethodExtensionKt.safePut(r113, "tag", "2");
        Unit r104 = Unit.INSTANCE;
        reportTea(r103, r113);
    }

    public final void openH5CashDesk(String r100, JSONObject r101, JSONObject r110, int r111, String r112) {
        ITTCJPayUtilsCompat r102 = getCJPayUtils("openH5CashDesk");
        if (r102 == null) goto L5;
        r102.openH5CashDesk(r100, r101, r110, r111, r112);
    L5:
        String r103 = this.OPEN_SCHEMA_EVENT_NAME;
        JSONObject r113 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r113, "schema", r100);
        KtSafeMethodExtensionKt.safePut(r113, "function", "openH5CashDesk");
        KtSafeMethodExtensionKt.safePut(r113, "tag", "1");
        Unit r104 = Unit.INSTANCE;
        reportTea(r103, r113);
    }

    public final void openH5ModalView(String r100, int r101, boolean r110, String r111, int r112) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r111, "bgColor");
        ITTCJPayUtilsCompat r102 = getCJPayUtils("openH5ModalView");
        if (r102 == null) goto L5;
        r102.openH5ModalView(r100, r101, r110, r111, r112);
    L5:
        String r103 = this.OPEN_SCHEMA_EVENT_NAME;
        JSONObject r113 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r113, "schema", r100);
        KtSafeMethodExtensionKt.safePut(r113, "function", "openH5ModalView");
        KtSafeMethodExtensionKt.safePut(r113, "tag", "1");
        Unit r104 = Unit.INSTANCE;
        reportTea(r103, r113);
    }

    public final void openRealNameAuth(Activity r100, String r101, String r110, String r111, TTCJPayRealNameAuthCallback r112) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "merchantId");
        Intrinsics.checkNotNullParameter(r110, "appId");
        Intrinsics.checkNotNullParameter(r111, "eventTrack");
        Intrinsics.checkNotNullParameter(r112, "callback");
        ITTCJPayUtilsCompat r102 = getCJPayUtils("openRealNameAuth");
        if (r102 == null) goto L6;
        r102.openRealNameAuth(r100, r101, r110, r111, r112);
        return;
    }

    @Deprecated(message = "this function is deprecated!")
    public final void openRealNameSetPassword(Activity r100, String r101, String r110, String r111, TTCJPayRealNamePasswordCallback r112) {
        ITTCJPayUtilsCompat r102 = getCJPayUtils("openRealNameSetPassword");
        if (r102 == null) goto L6;
        r102.openRealNameSetPassword(r100, r101, r110, r111, r112);
        return;
    }

    public final void wxPay(Context r100, String r101, String r110, ICJPayBasisPaymentService.OnPayResultCallback r111, ICJPayBasisPaymentService.OnResultCallback r112) {
        Intrinsics.checkNotNullParameter(r110, "wxPayType");
        ITTCJPayUtilsCompat r102 = getCJPayUtils("wxPay1");
        if (r102 == null) goto L6;
        r102.wxPay(r100, r101, r110, r111, r112);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ JSONObject getFinanceRiskWithScene$default(TTCJPayUtils r100, String r101, String r102, Map r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L6;
        r103 = null;
    L6:
        return r100.getFinanceRiskWithScene(r101, r102, r103);
    }

    @Deprecated(message = "this function is deprecated!")
    public final void openH5ModalView(Context r100, String r110, int r111, boolean r112, String r113, int r114) {
        Intrinsics.checkNotNullParameter(r110, "url");
        Intrinsics.checkNotNullParameter(r113, "bgColor");
        ITTCJPayUtilsCompat r101 = getCJPayUtils("openH5ModalView1");
        if (r101 == null) goto L5;
        r101.openH5ModalView(r100, r110, r111, r112, r113, r114);
    L5:
        String r102 = this.OPEN_SCHEMA_EVENT_NAME;
        JSONObject r115 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r115, "schema", r110);
        KtSafeMethodExtensionKt.safePut(r115, "function", "openH5ModalView");
        KtSafeMethodExtensionKt.safePut(r115, "tag", "2");
        Unit r116 = Unit.INSTANCE;
        reportTea(r102, r115);
    }

    public final void pay(String r100, int r110, String r111, String r112, String r113, IH5PayCallback r114) {
        ITTCJPayUtilsCompat r101 = getCJPayUtils("pay1");
        if (r101 == null) goto L6;
        r101.pay(r100, r110, r111, r112, r113, r114);
        return;
    }

    public final void payFromSubProcess(String r100, int r110, String r111, String r112, String r113, IH5PayCallback r114) {
        ITTCJPayUtilsCompat r101 = getCJPayUtils("payFromSubProcess");
        if (r101 == null) goto L6;
        r101.payFromSubProcess(r100, r110, r111, r112, r113, r114);
        return;
    }

    @Deprecated(message = "this function is deprecated!")
    public final void openH5ModalView(Context r110, String r111, int r112, boolean r113, String r114, int r115, Uri r116) {
        Intrinsics.checkNotNullParameter(r111, "url");
        Intrinsics.checkNotNullParameter(r114, "bgColor");
        Intrinsics.checkNotNullParameter(r116, "uri");
        ITTCJPayUtilsCompat r100 = getCJPayUtils("openH5ModalView2");
        if (r100 == null) goto L5;
        r100.openH5ModalView(r110, r111, r112, r113, r114, r115, r116);
    L5:
        String r101 = this.OPEN_SCHEMA_EVENT_NAME;
        JSONObject r102 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r102, "schema", r111);
        KtSafeMethodExtensionKt.safePut(r102, "function", "openH5ModalView");
        KtSafeMethodExtensionKt.safePut(r102, "tag", "3");
        Unit r103 = Unit.INSTANCE;
        reportTea(r101, r102);
    }

    public final void openRealNameAuth(Activity r110, String r111, String r112, String r113, String r114, String r115, TTCJPayRealNameAuthCallback r116) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "merchantId");
        Intrinsics.checkNotNullParameter(r112, "appId");
        Intrinsics.checkNotNullParameter(r113, "eventTrack");
        Intrinsics.checkNotNullParameter(r114, "theme");
        Intrinsics.checkNotNullParameter(r115, "scene");
        Intrinsics.checkNotNullParameter(r116, "callback");
        ITTCJPayUtilsCompat r100 = getCJPayUtils("openRealNameAuth1");
        if (r100 == null) goto L6;
        r100.openRealNameAuth(r110, r111, r112, r113, r114, r115, r116);
        return;
    }

    public final void outerBDPay(Context r110, String r111, Map<String, String> r112, String r113, String r114, boolean r115, wc4.a r116) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r116, "payCallback");
        ITTCJPayUtilsCompat r100 = getCJPayUtils("outerBDPay1");
        if (r100 == null) goto L6;
        r100.outerBDPay(r110, r111, r112, r113, r114, r115, r116);
        return;
    }

    public final void pay(String r110, int r111, String r112, String r113, String r114, String r115, IH5PayCallback r116) {
        ITTCJPayUtilsCompat r100 = getCJPayUtils("pay2");
        if (r100 == null) goto L6;
        r100.pay(r110, r111, r112, r113, r114, r115, r116);
        return;
    }

    public final void openRealNameAuth(Activity r110, String r111, String r112, String r113, String r114, String r115, String r116, TTCJPayRealNameAuthCallback r117) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "merchantId");
        Intrinsics.checkNotNullParameter(r112, "appId");
        Intrinsics.checkNotNullParameter(r113, "eventTrack");
        Intrinsics.checkNotNullParameter(r114, "theme");
        Intrinsics.checkNotNullParameter(r115, "scene");
        Intrinsics.checkNotNullParameter(r116, "style");
        Intrinsics.checkNotNullParameter(r117, "callback");
        ITTCJPayUtilsCompat r100 = getCJPayUtils("openRealNameAuth2");
        if (r100 == null) goto L6;
        r100.openRealNameAuth(r110, r111, r112, r113, r114, r115, r116, r117);
        return;
    }

    public final void pay(String r110, int r111, String r112, String r113, String r114, String r115, Boolean r116, IH5PayCallback r117) {
        ITTCJPayUtilsCompat r100 = getCJPayUtils("pay3");
        if (r100 == null) goto L6;
        r100.pay(r110, r111, r112, r113, r114, r115, r116, r117);
        return;
    }
}

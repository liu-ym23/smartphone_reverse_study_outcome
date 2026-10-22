package com.bytedance.ai.widget.contianer;

import android.app.Activity;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.ai.api.model.view.WidgetEvent;
import com.bytedance.ai.ext.ext_sharedviewmodel.SharedViewModelExtKt;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.model.widgets.f1;
import com.bytedance.ai.monitor.AppletErrorCode;
import com.bytedance.ai.resource.AIManager;
import com.bytedance.ai.utils.LifecycleRegistryExtKt;
import com.bytedance.ai.utils.o;
import com.bytedance.ai.widget.UIContextStrategy;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.keva.Keva;
import com.google.gson.JsonObject;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.ss.android.lark.utils.statistics.PerfLog;
import d3.b0;
import d3.w;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import k2.u;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import m5.i1;
import m5.y0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000¸\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 Ü\u00012\u00020\u00012\u00020\u0002:\u0006Ü\u0001Ý\u0001Þ\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0003\u0010\u0007J\u0010\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020<H\u0002J\u0012\u0010p\u001a\u00020^2\b\u0010k\u001a\u0004\u0018\u00010mH\u0016J\u0010\u0010v\u001a\u00020\u001e2\u0006\u0010w\u001a\u00020xH\u0016J\b\u0010j\u001a\u00020\u001eH\u0016J\u0010\u0010y\u001a\u00020^2\u0006\u0010z\u001a\u00020\u001eH\u0016J\b\u0010{\u001a\u00020\u0006H\u0016J\n\u0010|\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010}\u001a\u00020^2\u0006\u0010~\u001a\u00020\u00062\n\b\u0002\u0010\u007f\u001a\u0004\u0018\u00010\u0006H\u0016J\u0015\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u00062\b\u0010\u007f\u001a\u0004\u0018\u00010\u0006H\u0016J \u0010\u0081\u0001\u001a\u00020^2\u0015\u0010\u0082\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020^\u0018\u00010hH\u0016J\u0017\u0010\u0083\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020^\u0018\u00010hH\u0016J\u0012\u0010\u0084\u0001\u001a\u00020^2\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0006J\u0007\u0010\u0086\u0001\u001a\u00020^J\u000b\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u0006H\u0016J\t\u0010\u0088\u0001\u001a\u00020\u0006H\u0016J\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010\rJ\u000b\u0010\u008a\u0001\u001a\u0004\u0018\u00010xH\u0016J\u000b\u0010\u008b\u0001\u001a\u0004\u0018\u00010xH\u0016J\n\u0010+\u001a\u0004\u0018\u00010,H\u0016J\f\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008d\u0001H\u0016J\t\u0010\u008e\u0001\u001a\u00020^H\u0016J\t\u0010\u008f\u0001\u001a\u00020^H\u0002J+\u0010\u0090\u0001\u001a\u00020^2\u0007\u0010\u0091\u0001\u001a\u00020\u00062\u0017\b\u0002\u0010\u0092\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020/\u0018\u00010.H\u0004J+\u0010\u0093\u0001\u001a\u00020^2\u0007\u0010\u0094\u0001\u001a\u00020\u00062\u0017\b\u0002\u0010\u0092\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020/\u0018\u00010.H\u0002J\t\u0010\u0095\u0001\u001a\u00020\u0006H\u0002J\u0012\u0010\u0096\u0001\u001a\u00020^2\u0007\u0010\u0097\u0001\u001a\u00020\u0006H\u0016J\u001e\u0010\u0098\u0001\u001a\u00020^2\u0007\u0010\u0091\u0001\u001a\u00020\u00062\n\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u009a\u0001H\u0016J\u001c\u0010\u009b\u0001\u001a\u00020^2\b\u0010\u009c\u0001\u001a\u00030\u009d\u00012\u0007\u0010_\u001a\u00030\u009d\u0001H\u0016J\u0013\u0010\u009e\u0001\u001a\u00020^2\b\u0010\u009f\u0001\u001a\u00030 \u0001H\u0004J\u001b\u0010¡\u0001\u001a\u0004\u0018\u00010,2\u0007\u0010¢\u0001\u001a\u00020&H\u0082@¢\u0006\u0003\u0010£\u0001J\t\u0010¤\u0001\u001a\u00020^H\u0002J\u0019\u0010¥\u0001\u001a\u00020^2\u0007\u0010¢\u0001\u001a\u00020&H\u0096@¢\u0006\u0003\u0010£\u0001J\u0014\u0010¦\u0001\u001a\u00020^2\t\u0010§\u0001\u001a\u0004\u0018\u000101H\u0016J\u0013\u0010¨\u0001\u001a\u00020\u001e2\b\u0010©\u0001\u001a\u00030ª\u0001H\u0016J\u000b\u0010«\u0001\u001a\u0004\u0018\u00010\u0013H\u0002J\u0011\u0010¬\u0001\u001a\u00020^2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u00ad\u0001\u001a\u00020^2\u0007\u0010¢\u0001\u001a\u00020&H\u0002J\t\u0010®\u0001\u001a\u00020^H\u0016J\t\u0010¯\u0001\u001a\u00020^H\u0016J\t\u0010°\u0001\u001a\u00020^H\u0016J\u0012\u0010±\u0001\u001a\u00020^2\u0007\u0010²\u0001\u001a\u00020\u001eH\u0016J\t\u0010³\u0001\u001a\u00020^H\u0016J\t\u0010´\u0001\u001a\u00020^H\u0016J\t\u0010µ\u0001\u001a\u00020^H\u0016J\u0012\u0010¶\u0001\u001a\u00020^2\u0007\u0010¢\u0001\u001a\u00020&H\u0016J\u0014\u0010·\u0001\u001a\u00020^2\t\u0010¸\u0001\u001a\u0004\u0018\u00010\u0006H\u0016J\u0014\u0010¹\u0001\u001a\u00020^2\t\u0010¸\u0001\u001a\u0004\u0018\u00010\u0006H\u0016J\u0014\u0010º\u0001\u001a\u00020^2\t\u0010»\u0001\u001a\u0004\u0018\u00010\u0006H\u0016J\t\u0010¼\u0001\u001a\u00020\u001eH\u0016J\b\u0010A\u001a\u0004\u0018\u00010BJ\u0012\u0010½\u0001\u001a\u00020^2\u0007\u0010¾\u0001\u001a\u00020\u0006H\u0002J\u0012\u0010¿\u0001\u001a\u00020^2\u0007\u0010À\u0001\u001a\u00020!H\u0016J\u0012\u0010Á\u0001\u001a\u00020^2\u0007\u0010À\u0001\u001a\u00020!H\u0016J\t\u0010Â\u0001\u001a\u00020^H\u0016J\t\u0010Ã\u0001\u001a\u00020^H\u0016J\u0010\u0010Ä\u0001\u001a\u00020^2\u0007\u0010Å\u0001\u001a\u00020BJ\t\u0010Æ\u0001\u001a\u00020\u001eH\u0016J\t\u0010Ç\u0001\u001a\u00020^H\u0016J\u001d\u0010È\u0001\u001a\u0004\u0018\u00010\u001c2\u0007\u0010É\u0001\u001a\u00020\u001e2\u0007\u0010Ê\u0001\u001a\u00020\u0006H\u0016J\u000b\u0010Ë\u0001\u001a\u0004\u0018\u00010\u0006H\u0016J\f\u0010Ì\u0001\u001a\u0005\u0018\u00010Í\u0001H\u0016J\t\u0010Î\u0001\u001a\u00020^H\u0002J\u0012\u0010Ï\u0001\u001a\u00020^2\u0007\u0010Ð\u0001\u001a\u00020\u0006H\u0016J\u001d\u0010Ñ\u0001\u001a\u00020^2\b\u0010Ò\u0001\u001a\u00030Ó\u00012\b\u0010Ô\u0001\u001a\u00030Ó\u0001H\u0016J\"\u0010Õ\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0005\u0012\u00030×\u00010Ö\u00012\t\u0010Ø\u0001\u001a\u0004\u0018\u00010&H\u0007J\u0013\u0010Ù\u0001\u001a\u00020^2\b\u0010\u009f\u0001\u001a\u00030Ú\u0001H\u0007J\t\u0010Û\u0001\u001a\u00020\u001eH\u0004R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0007R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020/\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u00100\u001a\u0004\u0018\u000101X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0019\u00106\u001a\n 8*\u0004\u0018\u00010707¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u000e\u0010;\u001a\u00020<X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010=\u001a\u00020>X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0010\u0010A\u001a\u0004\u0018\u00010BX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010D\u001a\u0004\u0018\u00010EX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u0010\u0010J\u001a\u0004\u0018\u00010KX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010L\u001a\u0004\u0018\u00010MX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u0014\u0010R\u001a\u00020S8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bT\u0010UR\u001b\u0010V\u001a\u00020W8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010[\u001a\u0004\bX\u0010YR\u000e\u0010\\\u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010`\u001a\u00020aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bb\u0010cR\u001a\u0010d\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010e\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bf\u0010\nR\u001c\u0010g\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020^\u0018\u00010hX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010k\u001a\n\u0012\u0004\u0012\u00020m\u0018\u00010lX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\u0014\u0010r\u001a\u00020s8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bt\u0010u¨\u0006ß\u0001"}, d2 = {"Lcom/bytedance/ai/widget/contianer/WidgetContainer;", "Lcom/bytedance/ai/widget/contianer/IWidgetContainer;", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "()V", "traceId", "", "(Ljava/lang/String;)V", "conversationId", "getConversationId", "()Ljava/lang/String;", "setConversationId", "webView", "Landroid/webkit/WebView;", "containerJSBridge", "Lcom/bytedance/ai/widget/contianer/ContainerJSBridge;", "ivyWebViewClient", "Lcom/ivy/ivykit/api/plugin/web/IvyWebClient;", "ivyWebView", "Lcom/ivy/ivykit/api/plugin/render/WebViewPluginView;", "_lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "get_lifecycleRegistry", "()Landroidx/lifecycle/LifecycleRegistry;", "set_lifecycleRegistry", "(Landroidx/lifecycle/LifecycleRegistry;)V", "aiViewModelMap", "", "Lcom/bytedance/ai/viewmodel/IAIViewModel;", "isOverScrolled", "", "lifeCycleObserverList", "", "Lcom/bytedance/ai/api/model/view/IWidgetLifeObserver;", "getLifeCycleObserverList", "()Ljava/util/List;", "containerId", "currentData", "Lcom/bytedance/ai/widget/contianer/WidgetContainerData;", "getCurrentData", "()Lcom/bytedance/ai/widget/contianer/WidgetContainerData;", "setCurrentData", "(Lcom/bytedance/ai/widget/contianer/WidgetContainerData;)V", "widget", "Lcom/bytedance/ai/model/objects/Widget;", "appSettings", "", "", "widgetConfig", "Lcom/bytedance/ai/model/objects/WidgetConfig;", "getWidgetConfig", "()Lcom/bytedance/ai/model/objects/WidgetConfig;", "setWidgetConfig", "(Lcom/bytedance/ai/model/objects/WidgetConfig;)V", "widgetHeightRepo", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", "getWidgetHeightRepo", "()Lcom/bytedance/keva/Keva;", "widgetSavedHeight", "", "widgetHeightDebouncer", "Lcom/bytedance/ai/utils/CoroutineDebouncer;", "getWidgetHeightDebouncer", "()Lcom/bytedance/ai/utils/CoroutineDebouncer;", "currentLifeCycle", "Lcom/bytedance/ai/widget/contianer/WidgetContainer$LifecycleEvent;", "pendingOnShow", "aiBridge", "Lcom/bytedance/ai/bridge/AIBridge;", "getAiBridge", "()Lcom/bytedance/ai/bridge/AIBridge;", "setAiBridge", "(Lcom/bytedance/ai/bridge/AIBridge;)V", "webViewPort", "Lcom/bytedance/ai/applet/render/core/web/WebViewAIBridgePort;", "longPressController", "Lcom/bytedance/ai/utils/IWidgetLongPressController;", "getLongPressController", "()Lcom/bytedance/ai/utils/IWidgetLongPressController;", "setLongPressController", "(Lcom/bytedance/ai/utils/IWidgetLongPressController;)V", NewBroadcastMonitor.STAGE.LIFECYCLE, "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "finishHandler", "Lcom/bytedance/ai/widget/contianer/WidgetContainer$FinishHandler;", "getFinishHandler", "()Lcom/bytedance/ai/widget/contianer/WidgetContainer$FinishHandler;", "finishHandler$delegate", "Lkotlin/Lazy;", "monitorEventLifecycleObserver", "updateLayoutHeight", "", "height", "uiContextStrategy", "Lcom/bytedance/ai/widget/UIContextStrategy;", "getUiContextStrategy", "()Lcom/bytedance/ai/widget/UIContextStrategy;", "additionalContext", "defaultBotId", "getDefaultBotId", "additionalContextCallback", "Lkotlin/Function1;", "visible", "isForeground", "prefetcher", "Ljava/lang/ref/WeakReference;", "Lcom/bytedance/ai/widget/WidgetPrefetcher;", "getPrefetcher", "()Ljava/lang/ref/WeakReference;", "setPrefetcher", "(Ljava/lang/ref/WeakReference;)V", "renderType", "Lcom/bytedance/ai/widget/WidgetRenderType;", "getRenderType", "()Lcom/bytedance/ai/widget/WidgetRenderType;", "containsView", "view", "Landroid/view/View;", "setForeground", "foreground", "getPageID", "getBotId", "setAdditionalContext", "ctx", "botId", "getAdditionalContext", "setAdditionalContextCallback", "callback", "getAdditionalContextCallback", "sendUIContext", "uiContext", "scrollToHostBottom", "getMessageId", "getContainerId", "getWebView", "realView", "engineView", "getActivity", "Landroid/app/Activity;", "onCreated", "setupAIBridge", "reportWidgetEvent", "eventName", "extraParams", "reportErrorEvent", "msg", "viewContext", "onMessageToJS", "message", "onMessageToAIBridge", "params", "Lcom/google/gson/JsonObject;", "handleContentSizeChange", "width", "", "sendWidgetEvent", "event", "Lcom/bytedance/ai/api/model/view/WidgetEvent;", "getWidget", "widgetContainerData", "(Lcom/bytedance/ai/widget/contianer/WidgetContainerData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "releaseWidget", "bindData", "updateStyle", "config", "isSameContext", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getRenderView", "bindWebView", "injectWebViewData", LiveCommonConstants.REASON_ON_DEDTROY, SendEventContainerMethodParamModel.EventKinds.onShow, "onHide", "onFocusChange", "hasFocus", "onHostShow", "onHostHide", "onHostDestroy", "updateData", "onViewStart", "url", "onViewFinish", "onViewError", "errorMsg", "hasError", "dispatchLifecycleEventToWeb", "lifecycleEventName", "addLifeCycleObserver", "widgetLifeObserver", "removeLifeCycleObserver", "resetLifeCycleObserver", "clearLongClickCallback", "dispatchLifecycleEvent", "lifecycleEvent", "checkViewVisible", "resendLifecycleEvent", "getViewModel", "isShared", "groupId", "getAppletId", "getAIBridge", "Lcom/bytedance/ai/bridge/IAIBridge;", "clearAiViewModel", "sendUIAction", "action", "handleWebViewDrawEnd", "navigationStart", "", "drawEnd", "getThreadStrategy", "Lkotlin/Pair;", "Lcom/lynx/tasm/ThreadStrategyForRendering;", "data", "testLifecycle", "Landroidx/lifecycle/Lifecycle$Event;", "isShow", "Companion", "FinishHandler", "LifecycleEvent", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class WidgetContainer extends h implements LifecycleOwner {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ int f37965x = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f37966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LifecycleRegistry f37967c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, a6.a> f37968d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<u> f37969e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f37970f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public m f37971g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Widget f37972h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Map<String, ? extends Object> f37973i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public h5.j f37974j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Keva f37975k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.bytedance.ai.utils.d f37976l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public LifecycleEvent f37977m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f37978n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public w f37979o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public com.bytedance.ai.utils.i f37980p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f37981q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final d f37982r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Map<String, String> f37983s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f37984t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Function1<? super h, Unit> f37985u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f37986v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f37987w;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ai/widget/contianer/WidgetContainer$LifecycleEvent;", "", "<init>", "(Ljava/lang/String;I)V", "ON_START", "ON_LOAD_START", "ON_LOAD_ERROR", "ON_LOAD_FINISHED", "ON_DESTROY", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum LifecycleEvent extends Enum<LifecycleEvent> {
        public static final LifecycleEvent ON_DESTROY = null;
        public static final LifecycleEvent ON_LOAD_ERROR = null;
        public static final LifecycleEvent ON_LOAD_FINISHED = null;
        public static final LifecycleEvent ON_LOAD_START = null;
        public static final LifecycleEvent ON_START = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LifecycleEvent[] f37988a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f37989b = null;

        public static EnumEntries<LifecycleEvent> getEntries() {
            return f37989b;
        }

        static {
            LifecycleEvent r100 = new LifecycleEvent("ON_START", 0);
            ON_START = r100;
            LifecycleEvent r101 = new LifecycleEvent("ON_LOAD_START", 1);
            ON_LOAD_START = r101;
            LifecycleEvent r102 = new LifecycleEvent("ON_LOAD_ERROR", 2);
            ON_LOAD_ERROR = r102;
            LifecycleEvent r103 = new LifecycleEvent("ON_LOAD_FINISHED", 3);
            ON_LOAD_FINISHED = r103;
            LifecycleEvent r104 = new LifecycleEvent("ON_DESTROY", 4);
            ON_DESTROY = r104;
            LifecycleEvent[] r105 = {r100, r101, r102, r103, r104};
            f37988a = r105;
            f37989b = EnumEntriesKt.enumEntries(r105);
        }

        public static LifecycleEvent[] values() {
            return (LifecycleEvent[]) f37988a.clone();
        }

        public static LifecycleEvent valueOf(String r100) {
            return (LifecycleEvent) r27.a.a(LifecycleEvent.class, r100);
        }

        public LifecycleEvent(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public static final class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<WidgetContainer> f37990a;

        public static final class a {
        }

        static {
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            if (r100.what != 3) goto L20;
            WidgetContainer r101 = this.f37990a.get();
            m r102 = null;
            if (r101 == null) goto L7;
            LifecycleEvent r103 = r101.f37977m;
        L9:
            if (r103 != LifecycleEvent.ON_START) goto L22;
            com.bytedance.ai.utils.g.f37637a.d("WidgetContainer", "request time out " + this.f37990a.get());
            WidgetContainer r104 = this.f37990a.get();
            if (r104 == null) goto L23;
            StringBuilder r105 = new StringBuilder("request time out widget=");
            WidgetContainer r106 = this.f37990a.get();
            if (r106 == null) goto L15;
            Widget r107 = r106.f37972h;
        L16:
            r105.append(r107);
            r105.append(" data=");
            WidgetContainer r108 = this.f37990a.get();
            if (r108 == null) goto L19;
            r102 = r108.f37971g;
        L19:
            r105.append(r102);
            r104.onViewError(r105.toString());
            return;
        L15:
            r107 = null;
            goto L16
        L23:
            return;
        L22:
            return;
        L7:
            r103 = null;
            goto L9
        L20:
            super.handleMessage(r100);
        }

        public b(Looper r100, WidgetContainer r101) {
            Intrinsics.checkNotNullParameter(r100, "looper");
            Intrinsics.checkNotNullParameter(r101, "widgetContainer");
            super(r100);
            this.f37990a = new WeakReference(r101);
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f37991a = null;

        static {
            int[] r100 = new int[LifecycleEvent.values().length];
            r100[LifecycleEvent.ON_START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[LifecycleEvent.ON_LOAD_START.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[LifecycleEvent.ON_LOAD_FINISHED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[LifecycleEvent.ON_LOAD_ERROR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[LifecycleEvent.ON_DESTROY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f37991a = r100;
        }
    }

    public static final class d implements u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f37992a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WidgetContainer f37993b;

        @Override // k2.u
        public final void onDestroy() {
        }

        @Override // k2.u
        public void onEvent(WidgetEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
        }

        @Override // k2.u
        public final void onStart() {
        }

        @Override // k2.u
        public final void b() {
            LinkedHashMap r100 = new LinkedHashMap();
            if (this.f37992a <= 0) goto L5;
            r100.put(WiseOpenHianalyticsData.UNION_COSTTIME, Long.valueOf(System.currentTimeMillis() - this.f37992a));
        L5:
            this.f37993b.getClass();
            Boolean r101 = Boolean.FALSE;
            r100.put("isPreload", r101);
            r100.put("isSuccessful", r101);
            WidgetContainer r102 = this.f37993b;
            r102.getClass();
            Intrinsics.checkNotNullParameter("applet_view_load_finish", "eventName");
            com.bytedance.ai.monitor.b.d("applet_view_load_finish", new l(r102, r100));
        }

        @Override // k2.u
        public final void c() {
            LinkedHashMap r100 = new LinkedHashMap();
            if (this.f37992a <= 0) goto L5;
            r100.put(WiseOpenHianalyticsData.UNION_COSTTIME, Long.valueOf(System.currentTimeMillis() - this.f37992a));
        L5:
            this.f37993b.getClass();
            r100.put("isPreload", Boolean.FALSE);
            r100.put("isSuccessful", Boolean.TRUE);
            WidgetContainer r101 = this.f37993b;
            r101.getClass();
            Intrinsics.checkNotNullParameter("applet_view_load_finish", "eventName");
            com.bytedance.ai.monitor.b.d("applet_view_load_finish", new l(r101, r100));
        }

        @Override // k2.u
        public final void a() {
            this.f37992a = System.currentTimeMillis();
            WidgetContainer r100 = this.f37993b;
            int r101 = WidgetContainer.f37965x;
            r100.getClass();
            Intrinsics.checkNotNullParameter("applet_view_start", "eventName");
            com.bytedance.ai.monitor.b.d("applet_view_start", new l(r100, null));
        }

        public d(WidgetContainer r100) {
            this.f37993b = r100;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ai.widget.contianer.WidgetContainer$handleContentSizeChange$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.widget.contianer.WidgetContainer$handleContentSizeChange$1", f = "WidgetContainer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
        /* synthetic */ int I$0;
        int label;
        final /* synthetic */ WidgetContainer this$0;

        public AnonymousClass1(WidgetContainer r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            AnonymousClass1 r102 = new AnonymousClass1(this.this$0, r101);
            r102.I$0 = ((Number) r100).intValue();
            return r102;
        }

        public final Object invoke(int r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(Integer.valueOf(r100), r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Integer r100, Continuation<? super Unit> r101) {
            return invoke(r100.intValue(), r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L40;
            ResultKt.throwOnFailure(r100);
            int r101 = this.I$0;
            com.bytedance.ai.utils.g r102 = com.bytedance.ai.utils.g.f37637a;
            StringBuilder r103 = new StringBuilder("handleContentSizeChange: ");
            m r104 = this.this$0.f37971g;
            String r105 = null;
            if (r104 == null) goto L7;
            String r106 = r104.a();
        L8:
            r103.append(r106);
            r103.append(" widget change height to ");
            r103.append(r101);
            r102.d("WidgetContainer", r103.toString());
            WidgetContainer r107 = this.this$0;
            LifecycleEvent r108 = r107.f37977m;
            LifecycleEvent r109 = LifecycleEvent.ON_LOAD_FINISHED;
            if (r108 == r109) goto L11;
            r107.r(r109);
        L12:
            WidgetContainer r110 = this.this$0;
            View r111 = r110.realView();
            if (r111 == null) goto L15;
            ViewGroup.LayoutParams r112 = r111.getLayoutParams();
        L16:
            if (r112 == null) goto L18;
            r112.height = r101;
        L18:
            View r113 = r110.realView();
            if (r113 == null) goto L21;
            r113.setLayoutParams(r112);
        L21:
            View r114 = r110.realView();
            if (r114 == null) goto L27;
            ViewParent r115 = r114.getParent();
            if (r115 == null) goto L27;
            r115.requestLayout();
        L27:
            if (r110.f37987w == false) goto L38;
            if (r101 <= 0) goto L38;
            Keva r116 = r110.f37975k;
            m r117 = r110.f37971g;
            if (r117 == null) goto L32;
            String r118 = r117.a();
        L33:
            r116.storeInt(r118, r101);
            StringBuilder r119 = new StringBuilder();
            m r120 = r110.f37971g;
            if (r120 == null) goto L36;
            r105 = r120.a();
        L36:
            r119.append(r105);
            r119.append(" storeInt ");
            r119.append(r101);
            r102.d("WidgetContainer", r119.toString());
            goto L38
        L32:
            r118 = null;
        L38:
            return Unit.INSTANCE;
        L15:
            r112 = null;
            goto L16
        L11:
            r107.u(WidgetEvent.PAGE_UPDATE);
            goto L12
        L7:
            r106 = null;
            goto L8
        L40:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ai.widget.contianer.WidgetContainer$handleContentSizeChange$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.widget.contianer.WidgetContainer$handleContentSizeChange$2", f = "WidgetContainer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ WidgetContainer this$0;

        public AnonymousClass2(WidgetContainer r100, Continuation<? super AnonymousClass2> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass2(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r100);
            this.this$0.u(WidgetEvent.PAGE_UPDATE);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
    }

    public View engineView() {
        return null;
    }

    @Override // com.bytedance.ai.widget.contianer.h
    public void o(m r100) {
        Intrinsics.checkNotNullParameter(r100, "widgetContainerData");
    }

    @Override // k2.i
    public final void onHide() {
        this.f37978n = false;
        if (this.f37987w == true) goto L5;
        return;
    L5:
        if (this.f37986v == false) goto L10;
        s("onHide");
        this.f37986v = false;
        return;
    }

    @Override // k2.i
    public final void onHostHide() {
        this.f37987w = false;
        s("onBackground");
    }

    @Override // k2.i
    public final void onHostShow() {
        this.f37987w = true;
        s("onForeground");
    }

    @Override // k2.r
    public final void onMessageToJS(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
    }

    @Override // com.bytedance.ai.widget.contianer.h
    public final boolean f() {
        Rect r100 = new Rect();
        View r101 = realView();
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L17;
        View r103 = realView();
        if (r103 != null) goto L12;
    L14:
        boolean r104 = false;
    L15:
        if (r104 == false) goto L17;
        return true;
    L12:
        if (r103.getGlobalVisibleRect(r100) != true) goto L14;
        r104 = true;
    L17:
        return false;
    L5:
        if (r101.isAttachedToWindow() != true) goto L7;
        r102 = true;
        goto L8
    }

    @Override // com.bytedance.ai.widget.contianer.h
    public Activity getActivity() {
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r100 = AppletRuntimeManager.f36749d;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.currentActivity();
    }

    @Override // k2.i
    public final String getAppletId() {
        m r100 = this.f37971g;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f38015a;
    }

    @Override // k2.i
    public final String getBotId() {
        m r100 = this.f37971g;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f38018d;
    }

    @Override // com.bytedance.ai.widget.contianer.h
    public final String l() {
        m r100 = this.f37971g;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f38019e;
    }

    @Override // com.bytedance.ai.widget.contianer.h
    public final void m() {
        ((ArrayList) this.f37969e).clear();
        d r100 = this.f37982r;
        Intrinsics.checkNotNullParameter(r100, "widgetLifeObserver");
        ((ArrayList) this.f37969e).add(r100);
    }

    @Override // k2.i
    public final void onDestroy() {
        r(LifecycleEvent.ON_DESTROY);
        s(LiveCommonConstants.REASON_ON_DEDTROY);
        Iterator r100 = ((LinkedHashMap) this.f37968d).values().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((a6.a) r100.next()).getIStorage().cleanup();
        goto L4
    L6:
        ((ConcurrentHashMap) this.f37983s).clear();
    }

    @Override // k2.i
    public void onHostDestroy() {
        ((b) this.f37981q.getValue()).postDelayed(new i(this), 2000);
        CoroutineScopeKt.cancel$default(this.f37976l.f37634b, null, 1, null);
        com.bytedance.ai.utils.g.f37637a.i("CoroutineDebouncer", "Debouncer cancel");
        Widget r100 = this.f37972h;
        if (r100 == null) goto L5;
        r100.g();
    L5:
        this.f37972h = null;
        this.f37985u = null;
        ((ArrayList) this.f37969e).clear();
    }

    @Override // k2.i
    public final void onShow() {
        if (this.f37987w == true) goto L5;
        return;
    L5:
        if (this.f37986v == false) goto L8;
        return;
    L8:
        if (this.f37977m == LifecycleEvent.ON_LOAD_FINISHED) goto L11;
        this.f37978n = true;
        return;
    L11:
        s(SendEventContainerMethodParamModel.EventKinds.onShow);
        this.f37986v = true;
        LifecycleRegistryExtKt.a(this.f37967c, Lifecycle.Event.ON_START);
    }

    public WidgetContainer() {
        this.f37967c = new LifecycleRegistry(this);
        this.f37968d = new LinkedHashMap();
        this.f37969e = new ArrayList();
        this.f37970f = UUID.randomUUID().toString();
        this.f37975k = Keva.getRepo("WIDGET_HEIGHT");
        this.f37976l = new com.bytedance.ai.utils.d();
        this.f37981q = LazyKt.lazy(new k(this));
        this.f37982r = new d(this);
        UIContextStrategy r100 = UIContextStrategy.DEFAULT;
        this.f37983s = new ConcurrentHashMap();
        this.f37984t = "default_context_widget_bot_id";
        this.f37987w = true;
    }

    public View realView() {
        if (getActivity() == null) goto L9;
        com.bytedance.ai.utils.g.f37637a.e("WidgetContainer", "Fail to create render view.");
        r(LifecycleEvent.ON_LOAD_ERROR);
        t(this, "Fail to create render view.");
        m r100 = this.f37971g;
        if (r100 == null) goto L10;
        i1 r101 = y0.f512051a;
        y0.b(r100.f38019e, "Fail to create render view.", AppletErrorCode.WEB_VIEW_CREATE_ERROR.getType(), "applet_widget_timeline_full");
        return null;
    L10:
        return null;
    L9:
        return null;
    }

    @Override // k2.h
    public final b0 getAIBridge() {
        return this.f37979o;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return this.f37967c;
    }

    @Override // k2.i
    public final String getPageID() {
        return this.f37970f;
    }

    @Override // com.bytedance.ai.widget.contianer.h
    public final String j() {
        return this.f37970f;
    }

    @Override // com.bytedance.ai.widget.contianer.h
    public final m k() {
        return this.f37971g;
    }

    public Widget x() {
        return this.f37972h;
    }

    @Override // com.bytedance.ai.widget.contianer.h
    public final boolean g(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (super.g(r100) == true) goto L12;
        View r101 = engineView();
        if ((r101 instanceof WebView) == false) goto L7;
        WebView r102 = (WebView) r101;
    L9:
        if (Intrinsics.areEqual(r102, r100) == true) goto L12;
        return false;
    L7:
        r102 = null;
    L12:
        return true;
    }

    @Override // com.bytedance.ai.widget.contianer.h
    public final String h(String r100) {
        Map<String, String> r101 = this.f37983s;
        if (r100 != null) goto L11;
        m r102 = this.f37971g;
        if (r102 == null) goto L7;
        r100 = r102.f38018d;
    L8:
        if (r100 != null) goto L11;
        r100 = this.f37984t;
        goto L11
    L7:
        r100 = null;
    L11:
        return (String) ((ConcurrentHashMap) r101).get(r100);
    }

    @Override // k2.i
    public final void onViewError(String r100) {
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        String r101 = "Fail to load widget: ".concat(r100);
        com.bytedance.ai.utils.g.f37637a.e("WidgetContainer", r101);
        r(LifecycleEvent.ON_LOAD_ERROR);
        t(this, r101);
    }

    public final void r(LifecycleEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleEvent");
        com.bytedance.ai.utils.g.f37637a.d("WidgetContainer", this + " dispatchLifecycleEvent " + r100);
        this.f37977m = r100;
        Iterator<T> r101 = this.f37969e.iterator();
    L4:
        if (r101.hasNext() == false) goto L28;
        u r102 = (u) r101.next();
        int r103 = c.f37991a[r100.ordinal()];
        if (r103 != 1) goto L8;
        r102.onStart();
        goto L4
    L8:
        if (r103 != 2) goto L10;
        r102.a();
        goto L4
    L10:
        if (r103 != 3) goto L12;
        r102.c();
        new Rect();
        if (this.f37978n == true) goto L25;
        if (this.f37987w == false) goto L4;
        if (f() == false) goto L4;
    L25:
        onShow();
        goto L4
    L12:
        if (r103 != 4) goto L14;
        r102.b();
        goto L4
    L14:
        if (r103 != 5) goto L17;
        r102.onDestroy();
        goto L4
    L17:
        throw new NoWhenBranchMatchedException();
    }

    public final void s(String r100) {
        com.bytedance.ai.utils.g.f37637a.d("WidgetContainer", "dispatchLifecycleEventToWeb " + this + " lifecycle ==> " + r100);
        w r101 = this.f37979o;
        if (r101 == null) goto L50;
        JsonObject r102 = new JsonObject();
        Pair[] r103 = new Pair[10];
        r103[0] = TuplesKt.to("viewId", this.f37970f);
        m r104 = this.f37971g;
        String r105 = "";
        if (r104 == null) goto L8;
        String r106 = r104.f38016b;
        if (r106 == null) goto L8;
    L9:
        r103[1] = TuplesKt.to("pageName", r106);
        m r107 = this.f37971g;
        if (r107 == null) goto L13;
        String r108 = r107.f38018d;
        if (r108 == null) goto L13;
    L14:
        r103[2] = TuplesKt.to("botId", r108);
        m r109 = this.f37971g;
        if (r109 == null) goto L18;
        String r110 = r109.f38019e;
        if (r110 == null) goto L18;
    L19:
        r103[3] = TuplesKt.to(RemoteMessageConst.MSGID, r110);
        m r111 = this.f37971g;
        if (r111 == null) goto L23;
        String r112 = r111.f38024j;
        if (r112 == null) goto L23;
    L24:
        r103[4] = TuplesKt.to("mixtureCardId", r112);
        m r113 = this.f37971g;
        if (r113 == null) goto L30;
        String r114 = r113.f38021g;
        if (r114 == null) goto L30;
        r105 = r114;
    L30:
        r103[5] = TuplesKt.to("replyFor", r105);
        r103[6] = TuplesKt.to("conversationId", this.f37966b);
        m r115 = this.f37971g;
        Map<String, Object> r116 = null;
        if (r115 == null) goto L35;
        Map<String, Object> r117 = r115.f38023i;
        if (r117 == null) goto L35;
        Object r118 = r117.get("createTime");
    L36:
        r103[7] = TuplesKt.to("msgCreateTime", r118);
        r103[8] = TuplesKt.to("appSettings", this.f37973i);
        m r119 = this.f37971g;
        if (r119 == null) goto L39;
        r116 = r119.f38023i;
    L39:
        r103[9] = TuplesKt.to("extra", r116);
        Map r120 = MapsKt.mutableMapOf(r103);
        m r121 = this.f37971g;
        if (r121 == null) goto L47;
        Map<String, String> r122 = r121.f38022h;
        if (r122 == null) goto L47;
        Iterator<Map.Entry<String, String>> r123 = r122.entrySet().iterator();
    L45:
        if (r123.hasNext() == false) goto L47;
        Map.Entry<String, String> r124 = r123.next();
        r120.put(r124.getKey(), r124.getValue());
    L47:
        r102.addProperty("eventName", new JSONObject(MapsKt.toMap(r120)).toString());
        Unit r125 = Unit.INSTANCE;
        r101.a(r100, r102);
        return;
    L35:
        r118 = null;
    L23:
        r112 = "";
    L18:
        r110 = "";
    L13:
        r108 = "";
    L8:
        r106 = "";
        goto L9
    }

    public final void u(WidgetEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Iterator<T> r101 = this.f37969e.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((u) r101.next()).onEvent(r100);
        goto L4
    }

    public void w(h5.j r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f37974j = r100;
        if (this.f37972h == null) goto L35;
        View r101 = realView();
        ViewGroup r102 = null;
        if (r101 == null) goto L9;
        ViewParent r103 = r101.getParent();
    L11:
        if ((r103 instanceof ViewGroup) == false) goto L13;
        r102 = (ViewGroup) r103;
    L13:
        if (r102 != null) goto L15;
        return;
    L15:
        Widget r104 = this.f37972h;
        int r105 = 1;
        int r106 = 0;
        if (r104 != null) goto L18;
    L20:
        boolean r107 = false;
    L21:
        if (r107 == true) goto L23;
        return;
    L23:
        if (Build.VERSION.SDK_INT < 23) goto L37;
        GradientDrawable r108 = new GradientDrawable();
        r108.setShape(0);
        h5.j r109 = this.f37974j;
        if (r109 == null) goto L27;
        r105 = r109.f483831b;
    L27:
        if (r109 == null) goto L29;
        r106 = r109.f483832c;
    L29:
        r108.setStroke(r105, r106);
        h5.j r110 = this.f37974j;
        if (r110 == null) goto L32;
        float r111 = r110.f483833d;
    L33:
        r108.setCornerRadius(r111);
        r102.setForeground(r108);
        return;
    L32:
        r111 = 0.0f;
        goto L33
    L37:
        return;
    L18:
        if (r104.O != true) goto L20;
        r107 = true;
        goto L21
    L9:
        r103 = null;
        goto L11
    }

    public static void t(final WidgetContainer r100, String r101) {
        r100.getClass();
        com.bytedance.ai.utils.g.f37637a.i("WidgetContainer", "reportErrorEvent: " + r101);
        AtomicBoolean r102 = com.bytedance.ai.monitor.b.f37194a;
        final Map r103 = null;
        com.bytedance.ai.monitor.b.a(AppletErrorCode.WIDGET_LOAD_ERROR, r101, null, new j(r100, r103));
    }

    @Override // u4.a
    public final a6.a getViewModel(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "groupId");
        if (r100 == false) goto L8;
        com.bytedance.ai.utils.g.f37637a.d("WidgetContainer", "getViewModel state " + getLifecycle().getCurrentState());
        if (getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) goto L12;
        return null;
    L12:
        return SharedViewModelExtKt.b(this, r101);
    L8:
        a6.a r102 = (a6.a) ((LinkedHashMap) this.f37968d).get(r101);
        if (r102 != null) goto L14;
        f1.b r103 = new f1.b(r101);
        this.f37968d.put(r101, r103);
        return r103;
    L14:
        return r102;
    }

    public final void handleContentSizeChange(double r100, double r110) {
        int r101 = o.a((float) r110);
        com.bytedance.ai.utils.g r111 = com.bytedance.ai.utils.g.f37637a;
        StringBuilder r112 = new StringBuilder("handleContentSizeChange: ");
        m r102 = this.f37971g;
        if (r102 == null) goto L5;
        String r103 = r102.a();
    L6:
        r112.append(r103);
        r112.append(" widgetSavedHeight = 0, webContentHeight = ");
        r112.append(r101);
        r111.d("WidgetContainer", r112.toString());
        if (r101 <= 0) goto L16;
        StringBuilder r113 = new StringBuilder("handleContentSizeChange: ");
        m r114 = this.f37971g;
        if (r114 == null) goto L11;
        String r115 = r114.a();
    L12:
        r113.append(r115);
        r113.append(" immediate = false");
        r111.d("WidgetContainer", r113.toString());
        this.f37976l.a(Integer.valueOf(r101), new AnonymousClass1(this, null));
        if (this.f37977m != LifecycleEvent.ON_LOAD_FINISHED) goto L17;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.f36604e), null, null, new AnonymousClass2(this, null), 3, null);
        return;
    L17:
        return;
    L11:
        r115 = null;
        goto L12
    L16:
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // k2.o
    public final void handleWebViewDrawEnd(long r100, long r101) {
        com.bytedance.ai.utils.g.f37637a.d("WidgetContainer", "navigationStart:" + r100 + " drawEnd:" + r101 + ", duration:" + (r101 - r100));
    }

    @Override // k2.r
    public final void onMessageToAIBridge(String r100, JsonObject r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        w r102 = this.f37979o;
        if (r102 == null) goto L6;
        r102.a(r100, r101);
        return;
    }

    public final void v(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        Map<String, String> r102 = this.f37983s;
        if (r101 != null) goto L10;
        m r103 = this.f37971g;
        if (r103 == null) goto L7;
        r101 = r103.f38018d;
    L8:
        if (r101 != null) goto L10;
        r101 = this.f37984t;
        goto L10
    L7:
        r101 = null;
    L10:
        ((ConcurrentHashMap) r102).put(r101, r100);
        Function1<? super h, Unit> r104 = this.f37985u;
        if (r104 == null) goto L14;
        r104.invoke(this);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.bytedance.ai.model.objects.AIPackage, com.bytedance.ai.model.objects.Widget] */
    public static final Object p(WidgetContainer r100, m r110, Continuation r111) {
        r100.getClass();
        if ((r111 instanceof WidgetContainer$getWidget$1) == false) goto L7;
        WidgetContainer$getWidget$1 r101 = (WidgetContainer$getWidget$1) r111;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r112 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        r110 = (m) r101.L$0;
        ResultKt.throwOnFailure(r112);
    L23:
        r103 = (Widget) r112;
        if (r103 != 0) goto L26;
        com.bytedance.ai.utils.g.f37637a.e("WidgetContainer", "<createWidget> 404: can't find widget named '" + r110.f38016b + '\'');
        r100.r(LifecycleEvent.ON_LOAD_ERROR);
        t(r100, "Not Found Widget");
    L26:
        if (r103 == 0) goto L28;
        r103.e();
    L28:
        return r103;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        AIManager r113 = AIManager.f37211a;
        String r105 = r110.f38015a;
        String r106 = r110.f38016b;
        m r107 = r100.f37971g;
        if (r107 == null) goto L19;
        Map<String, Object> r108 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(MusicAppletPage.KEY_MESSAGE_ID, r107.f38019e), TuplesKt.to("botId", r107.f38018d)});
        String r109 = r107.f38033s;
        if (r109 == null) goto L20;
        r108.put("version_tag", r109);
    L20:
        r101.L$0 = r110;
        r101.label = 1;
        r112 = r113.E(r105, r106, r108, r101);
        if (r112 != r103) goto L23;
    L19:
        r108 = null;
    L7:
        r101 = new WidgetContainer$getWidget$1(r100, r111);
        goto L8
    }
}

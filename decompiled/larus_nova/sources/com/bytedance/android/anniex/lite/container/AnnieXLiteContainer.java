package com.bytedance.android.anniex.lite.container;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.anniex.base.builder.UIComponentBuilder;
import com.bytedance.android.anniex.container.util.AnnieXContainerManager;
import com.bytedance.android.anniex.monitor.MonitorManager;
import com.bytedance.android.anniex.monitor.salamander.SLMonitorCompat;
import com.bytedance.android.anniex.web.model.AnnieXWebModel;
import com.bytedance.android.anniex.worker.AnnieXJSWorkerManager;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.bullet.base.utils.keyboard.SoftInputKt;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.sdk.param.LaunchMode;
import com.bytedance.ies.bullet.ui.common.DebugTagTextView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.salamander.anniex.SLContainerTiming;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.LynxView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import y36.r;
import y36.s;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\b\t*\u0002Ë\u0001\b!\u0018\u0000 Ñ\u00012\u00020\u0001:\u0002Ò\u0001B\u0011\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0006\bÏ\u0001\u0010Ð\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0012\u001a\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u000fH\u0002J\b\u0010\u0014\u001a\u00020\u000fH\u0002J\b\u0010\u0015\u001a\u00020\u000fH\u0002J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\rH\u0002J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0018\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\rH\u0002J\b\u0010\u001f\u001a\u00020\u001bH\u0002J\u0010\u0010 \u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\rH\u0002J\b\u0010!\u001a\u00020\u001bH\u0002J\b\u0010\"\u001a\u00020\u001bH\u0002J\b\u0010#\u001a\u00020\u000fH\u0002J\u0010\u0010&\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020$H\u0002J\b\u0010'\u001a\u00020\u000fH\u0002J\b\u0010(\u001a\u00020\u000fH\u0002J\b\u0010)\u001a\u00020\u000fH\u0002J$\u0010.\u001a\u00020\u000f2\b\u0010*\u001a\u0004\u0018\u00010\u00182\u0006\u0010,\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020\u001bH\u0002J,\u00103\u001a\u0010\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u000201\u0018\u00010/2\u0014\u00102\u001a\u0010\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u000201\u0018\u00010/H\u0002J\u0012\u00106\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000104H\u0002J\b\u00107\u001a\u00020\u000fH\u0002J\u0006\u00108\u001a\u000200J\b\u00109\u001a\u000200H\u0014J\b\u0010;\u001a\u00020:H\u0016J\u0010\u0010>\u001a\u00020\u000f2\u0006\u0010=\u001a\u00020<H\u0004J\b\u0010?\u001a\u00020\u000fH\u0014J\b\u0010@\u001a\u00020\u000fH\u0004J\b\u0010A\u001a\u00020\u000fH\u0016J\u0010\u0010C\u001a\u00020\u000f2\u0006\u0010B\u001a\u00020\u001bH\u0004J\u0010\u0010E\u001a\u00020\u000f2\u0006\u0010D\u001a\u00020+H\u0016J!\u0010H\u001a\u00020\u000f2\u0006\u0010F\u001a\u00020\u001b2\b\u0010G\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\bH\u0010IJ\b\u0010J\u001a\u000200H\u0016J\b\u0010K\u001a\u000200H\u0016J\b\u0010M\u001a\u00020LH\u0016J\b\u0010N\u001a\u000200H\u0016J\n\u0010P\u001a\u0004\u0018\u00010OH\u0016J&\u0010R\u001a\u00020\u000f2\u0006\u0010Q\u001a\u0002002\u0014\u00102\u001a\u0010\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u000201\u0018\u00010/H\u0016J:\u0010R\u001a\u00020\u000f2\u0006\u0010Q\u001a\u0002002\u0014\u00102\u001a\u0010\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u000201\u0018\u00010/2\b\u00105\u001a\u0004\u0018\u0001042\b\u0010T\u001a\u0004\u0018\u00010SH\u0016J\b\u0010V\u001a\u00020UH\u0016J\u0010\u0010W\u001a\u00020O2\u0006\u0010Q\u001a\u000200H\u0016J\n\u0010X\u001a\u0004\u0018\u00010OH\u0016J\u0010\u0010[\u001a\u00020\u000f2\u0006\u0010Z\u001a\u00020YH\u0016J\b\u0010\\\u001a\u00020\u001bH\u0016J\b\u0010]\u001a\u00020\u000fH\u0016J\b\u0010^\u001a\u00020\u000fH\u0016J\u001e\u0010_\u001a\u00020\u000f2\u0014\u00102\u001a\u0010\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u000201\u0018\u00010/H\u0016J\b\u0010`\u001a\u00020\u001bH\u0016J\b\u0010a\u001a\u00020\u000fH\u0016J\b\u0010b\u001a\u00020\u000fH\u0016J\n\u0010c\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010d\u001a\u00020\u000fH\u0016J\u0010\u0010f\u001a\u00020\u000f2\u0006\u0010e\u001a\u000200H\u0016J+\u0010k\u001a\u00020\u000f\"\u0004\b\u0000\u0010g2\f\u0010i\u001a\b\u0012\u0004\u0012\u00028\u00000h2\u0006\u0010j\u001a\u00028\u0000H\u0016¢\u0006\u0004\bk\u0010lJ\u001c\u0010n\u001a\u00020\u000f2\u0012\u0010m\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u0002010/H\u0016J\u001c\u0010p\u001a\u00020\u000f2\u0012\u0010o\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u0002010/H\u0016J\u0010\u0010p\u001a\u00020\u000f2\u0006\u0010o\u001a\u000200H\u0016J\n\u0010q\u001a\u0004\u0018\u000104H\u0016J\u0018\u0010s\u001a\u00020\u000f2\u0006\u0010r\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\rH\u0016J\u0014\u0010u\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020t0/H\u0016J\b\u0010v\u001a\u000200H\u0016J\u0010\u0010x\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010U0wH\u0016J\b\u0010y\u001a\u00020\u001bH\u0016J\u0010\u0010{\u001a\u00020\u000f2\u0006\u0010z\u001a\u00020\u001bH\u0016J\b\u0010|\u001a\u00020\u000fH\u0016J\u0012\u0010~\u001a\u00020\u000f2\b\u0010}\u001a\u0004\u0018\u000100H\u0016J\b\u0010\u007f\u001a\u00020\u000fH\u0016J\t\u0010\u0080\u0001\u001a\u00020\u000fH\u0016J\u000b\u0010\u0081\u0001\u001a\u0004\u0018\u000100H\u0016J\n\u0010\u0083\u0001\u001a\u00030\u0082\u0001H\u0016J-\u0010\u0088\u0001\u001a\u00020\u000f2\u0007\u0010\u0084\u0001\u001a\u00020\r2\u0007\u0010\u0085\u0001\u001a\u00020\r2\u0007\u0010\u0086\u0001\u001a\u00020\r2\u0007\u0010\u0087\u0001\u001a\u00020\rH\u0016R\u001a\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\u000f\n\u0005\b\u0003\u0010\u0089\u0001\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R\u001c\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008c\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R \u0010\u0090\u0001\u001a\u00030\u008f\u00018\u0004X\u0084\u0004¢\u0006\u0010\n\u0006\b\u0090\u0001\u0010\u0091\u0001\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001R#\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u0094\u00018FX\u0086\u0084\u0002¢\u0006\u0010\n\u0006\b\u0095\u0001\u0010\u0096\u0001\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001R\u0017\u0010\u009a\u0001\u001a\u0002008\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009a\u0001\u0010\u009b\u0001R\u001f\u0010\u009c\u0001\u001a\u00020U8\u0004X\u0084\u0004¢\u0006\u0010\n\u0006\b\u009c\u0001\u0010\u009d\u0001\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001R\u001f\u0010\n\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\u0010\n\u0006\b \u0001\u0010\u0096\u0001\u001a\u0006\b¡\u0001\u0010¢\u0001R \u0010¦\u0001\u001a\u00020\u000b8DX\u0084\u0084\u0002¢\u0006\u0010\n\u0006\b£\u0001\u0010\u0096\u0001\u001a\u0006\b¤\u0001\u0010¥\u0001R\u0017\u0010=\u001a\u00020<8\u0002@\u0002X\u0082.¢\u0006\u0007\n\u0005\b=\u0010§\u0001R*\u0010©\u0001\u001a\u00030¨\u00018\u0004@\u0004X\u0084.¢\u0006\u0018\n\u0006\b©\u0001\u0010ª\u0001\u001a\u0006\b«\u0001\u0010¬\u0001\"\u0006\b\u00ad\u0001\u0010®\u0001R\u0019\u0010¯\u0001\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¯\u0001\u0010°\u0001R\u0019\u0010±\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b±\u0001\u0010²\u0001R\u0019\u0010³\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b³\u0001\u0010²\u0001R\u0019\u0010´\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b´\u0001\u0010²\u0001R\u001c\u0010¶\u0001\u001a\u0005\u0018\u00010µ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¶\u0001\u0010·\u0001R\u0019\u0010¸\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¸\u0001\u0010²\u0001R\u001b\u0010¹\u0001\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¹\u0001\u0010º\u0001R\u0019\u0010»\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b»\u0001\u0010²\u0001R\u001b\u0010¼\u0001\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¼\u0001\u0010º\u0001R\u001b\u0010½\u0001\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b½\u0001\u0010º\u0001R\u001b\u0010¾\u0001\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¾\u0001\u0010º\u0001R \u0010À\u0001\u001a\t\u0012\u0004\u0012\u00020\r0¿\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÀ\u0001\u0010Á\u0001R)\u0010Â\u0001\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÂ\u0001\u0010²\u0001\u001a\u0006\bÃ\u0001\u0010Ä\u0001\"\u0006\bÅ\u0001\u0010Æ\u0001R\u0017\u0010y\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\by\u0010²\u0001R\u0019\u0010Ç\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÇ\u0001\u0010²\u0001R\u001b\u0010È\u0001\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÈ\u0001\u0010É\u0001R\u001b\u0010Ê\u0001\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÊ\u0001\u0010É\u0001R\u001a\u0010Ì\u0001\u001a\u00030Ë\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÌ\u0001\u0010Í\u0001R\u0019\u0010Î\u0001\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÎ\u0001\u0010°\u0001¨\u0006Ó\u0001"}, d2 = {"Lcom/bytedance/android/anniex/lite/container/AnnieXLiteContainer;", "Lia/b;", "Lcom/bytedance/android/anniex/base/builder/UIComponentBuilder;", "builder", "Lqa/a;", "createAnnieXContext", "Landroid/os/Bundle;", "bundle", "Landroid/net/Uri;", "getUriByBundle", "annieXContext", "Lna/a;", "createEngine", "", "state", "", "putState", "changeState", "transferToTargetState", "initContainerColor", "addScreenCaptureListener", "removeScreenCaptureListener", "softHeight", "possiblyResizeChildOfContent", "Landroid/view/View;", "decorView", "getContentView", "", "isShowing", "height", "sendKeyboardStatusChangeEvent", "needAdapterKeyboard", "possiblyResizeChildOfContent4Web", "needAdapterKeyboard4Web", "useSystemDialog", "addTagView", "Lg16/b;", "debugInfo", "showContainerTag", "setContainerColor", "setBackgroundColor", "updateLynxScreenMetrics", "view", "Landroid/content/res/Configuration;", "configuration", "isKitViewCreate", "padAdaptation", "", "", "", "renderData", "completeRenderData", "Lm16/b;", "contextProviderFactory", "mergeContext", "bindWebOnScrollChangeListener", "getUrl", "getPageOptType", "Lcom/bytedance/ies/bullet/core/common/Scenes;", "getScenes", "Lia/j;", "uiComponent", "setUiComponent", "addKitView", "initUi", "observerKeyboardStatusChange", "hasSoftInput", "onSoftInputChange", "newConfig", "onConfigurationChanged", "visible", "hasReadySendVisibleEvent", "onVisibleChange", "(ZLjava/lang/Boolean;)V", "getBid", "getContainerId", "Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "getKitType", "getCurrentUrl", "Lt36/d;", "getSchemaData", "schema", "loadSchema", "Lcom/bytedance/android/anniex/base/lifecycle/a;", NewBroadcastMonitor.STAGE.LIFECYCLE, "Landroid/content/Context;", "getSystemContext", "generateSchemaData", "getCurrentSchema", "Lcom/bytedance/ies/bullet/core/kit/bridge/h;", "event", "sendEvent", "canBackPress", "enterForeground", "enterBackground", "reload", "canGoBack", "goBack", "release", "getKitView", "removeKitView", "url", "recreateKitView", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "clazz", MapController.ITEM_LAYER_TAG, "registerWeakHolder", "(Ljava/lang/Class;Ljava/lang/Object;)V", "globalProps", "updateGlobalProps", "data", "updateData", "getContextProviderFactory", "width", "updateScreenMetrics", "", "getPerfMap", "getViewType", "Ljava/lang/ref/WeakReference;", "getWeakContext", "isVisibility", "enable", "interceptBackPress", "showError", "text", DyPayConstant.KEY_SHOW_LOADING, "hideLoading", "close", "getBDXTag", "Lcom/bytedance/ies/bullet/service/sdk/param/LaunchMode;", "getBDXLaunchMode", "scrollX", "scrollY", "oldScrollX", "oldScrollY", "onWebScrollChanged", "Lcom/bytedance/android/anniex/base/builder/UIComponentBuilder;", "getBuilder", "()Lcom/bytedance/android/anniex/base/builder/UIComponentBuilder;", "Lb46/e;", "screenCaptureListener", "Lb46/e;", "Lcom/bytedance/android/anniex/container/b;", "lifecycleDispatcher", "Lcom/bytedance/android/anniex/container/b;", "getLifecycleDispatcher", "()Lcom/bytedance/android/anniex/container/b;", "Lv36/a;", "containerModel$delegate", "Lkotlin/Lazy;", "getContainerModel", "()Lv36/a;", "containerModel", "currentBid", "Ljava/lang/String;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "annieXContext$delegate", "getAnnieXContext", "()Lqa/a;", "engine$delegate", "getEngine", "()Lna/a;", "engine", "Lia/j;", "Landroid/view/ViewGroup;", "parentViewGroup", "Landroid/view/ViewGroup;", "getParentViewGroup", "()Landroid/view/ViewGroup;", "setParentViewGroup", "(Landroid/view/ViewGroup;)V", "currentState", "I", "isResuming", "Z", "isRuntimeReady", "loadSuccess", "Landroid/graphics/drawable/Drawable;", "originBackground", "Landroid/graphics/drawable/Drawable;", "useCustomBackground", "errorView", "Landroid/view/View;", "errorViewAdded", "loadingView", "noticeView", "denyView", "Ljava/util/concurrent/ArrayBlockingQueue;", "stateBlockingQueue", "Ljava/util/concurrent/ArrayBlockingQueue;", "containerVisible", "getContainerVisible", "()Z", "setContainerVisible", "(Z)V", "isNotRelease", "padAdapterWidth", "Ljava/lang/Integer;", "padAdapterHeight", "com/bytedance/android/anniex/lite/container/AnnieXLiteContainer$b", "annieLifeCycle", "Lcom/bytedance/android/anniex/lite/container/AnnieXLiteContainer$b;", "usableHeightPrevious", "<init>", "(Lcom/bytedance/android/anniex/base/builder/UIComponentBuilder;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "anniex_release"}, k = 1, mv = {1, 4, 3})
public abstract class AnnieXLiteContainer extends ia.b {
    public static final a Companion = null;
    private static final int LOAD_STATUS_CREATE_KIT_VIEW = 2;
    private static final int LOAD_STATUS_DESTROY = 6;
    private static final int LOAD_STATUS_FINISH = 4;
    private static final int LOAD_STATUS_INIT_UI = 0;
    private static final int LOAD_STATUS_LOADING = 3;
    private static final int LOAD_STATUS_PARSE_SCHEMA = 1;
    private static final int LOAD_STATUS_RUNTIME_READY = 5;
    private static final int LOAD_STATUS_UNKNOWN = -1;
    private static final String TAG = "AnnieXContainer";
    private static final String VISIBLE_CHANGE_TYPE_APP = "app";
    private static final String VISIBLE_CHANGE_TYPE_PAGE = "page";
    private b annieLifeCycle;
    private final Lazy annieXContext$delegate;
    private final UIComponentBuilder builder;
    private final Lazy containerModel$delegate;
    private volatile boolean containerVisible;
    private final Context context;
    private final String currentBid;
    private int currentState;
    private View denyView;
    private final Lazy engine$delegate;
    private View errorView;
    private boolean errorViewAdded;
    private boolean isNotRelease;
    private boolean isResuming;
    private boolean isRuntimeReady;
    private volatile boolean isVisibility;
    private final com.bytedance.android.anniex.container.b lifecycleDispatcher;
    private boolean loadSuccess;
    private View loadingView;
    private View noticeView;
    private Drawable originBackground;
    private Integer padAdapterHeight;
    private Integer padAdapterWidth;
    protected ViewGroup parentViewGroup;
    private b46.e screenCaptureListener;
    private ArrayBlockingQueue<Integer> stateBlockingQueue;
    private ia.j uiComponent;
    private int usableHeightPrevious;
    private boolean useCustomBackground;

    public static final class a {
        public a() {
        }
    }

    public static final class b extends com.bytedance.android.anniex.base.lifecycle.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnnieXLiteContainer f40837a;

        public b(AnnieXLiteContainer r100) {
            this.f40837a = r100;
        }

        @Override // com.bytedance.android.anniex.base.lifecycle.a
        public final void d(String r100, ia.c r101) {
            Intrinsics.checkNotNullParameter(r100, "schema");
            Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
            this.f40837a.getLifecycleDispatcher().d(r100, r101);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.bytedance.android.anniex.base.lifecycle.a
        public final void e(String r100, ia.c r101) {
            Intrinsics.checkNotNullParameter(r100, "schema");
            Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
            HybridLogger r102 = HybridLogger.f246343a;
            r r103 = null;
            HybridLogger.m(AnnieXLiteContainer.TAG, "===onKitViewCreate:  " + r100, null, null, 12);
            AnnieXLiteContainer.access$putState(this.f40837a, 1);
            AnnieXLiteContainer.access$putState(this.f40837a, 2);
            View r104 = r101.getKitView();
            if (r104 == null) goto L25;
            AnnieXLiteContainer r105 = this.f40837a;
            v36.a r106 = r105.getContainerModel();
            if (r106 == null) goto L14;
            r r107 = r106.f552853r;
            if (r107 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("webBgColor");
            r107 = null;
        L10:
            if (r107 == null) goto L14;
            Integer r108 = (Integer) r107.f565862b;
            if (r108 == null) goto L14;
            r104.setBackgroundColor(r108.intValue());
        L14:
            v36.a r109 = r105.getContainerModel();
            if (r109 == null) goto L24;
            r r110 = r109.f562367e;
            if (r110 == null) goto L19;
            r103 = r110;
        L20:
            if (r103 == null) goto L24;
            Integer r111 = (Integer) r103.f565862b;
            if (r111 == null) goto L24;
            r104.setBackgroundColor(r111.intValue());
            goto L24
        L19:
            Intrinsics.throwUninitializedPropertyAccessException("contentBgColor");
        L24:
            ExecutorService r112 = com.bytedance.ies.bullet.service.monitor.a.f247969a;
            com.bytedance.ies.bullet.service.monitor.a.b(r101.getContainerId(), r104, r101.getKitType().getTag());
        L25:
            this.f40837a.onKitViewCreate();
            this.f40837a.getLifecycleDispatcher().e(this.f40837a.getUrl(), this.f40837a);
            AnnieXLiteContainer.access$bindWebOnScrollChangeListener(this.f40837a);
            AnnieXLiteContainer.access$addScreenCaptureListener(this.f40837a);
        }

        @Override // com.bytedance.android.anniex.base.lifecycle.a
        public final void f(String r100, ia.c r101) {
            Intrinsics.checkNotNullParameter(r100, "schema");
            Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
            HybridLogger r102 = HybridLogger.f246343a;
            HybridLogger.m(AnnieXLiteContainer.TAG, "kit_view_destroy", MapsKt.mapOf(TuplesKt.to("url", r100)), null, 8);
            AnnieXLiteContainer.access$putState(this.f40837a, 6);
            this.f40837a.getLifecycleDispatcher().f(this.f40837a.getUrl(), this.f40837a);
        }

        @Override // com.bytedance.android.anniex.base.lifecycle.a
        public final void h(String r100, ia.c r101) {
            Intrinsics.checkNotNullParameter(r100, "schema");
            Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
            HybridLogger r102 = HybridLogger.f246343a;
            HybridLogger.m(AnnieXLiteContainer.TAG, "===onLoadStart:  " + r100, null, null, 12);
            AnnieXLiteContainer.access$putState(this.f40837a, 3);
            super.h(r100, r101);
            this.f40837a.getLifecycleDispatcher().h(this.f40837a.getUrl(), this.f40837a);
        }

        @Override // com.bytedance.android.anniex.base.lifecycle.a
        public final void i(String r100, ia.c r101) {
            Intrinsics.checkNotNullParameter(r100, "schema");
            Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
            AnnieXLiteContainer.access$setLoadSuccess$p(this.f40837a, true);
            AnnieXLiteContainer.access$putState(this.f40837a, 4);
            this.f40837a.getLifecycleDispatcher().i(this.f40837a.getUrl(), this.f40837a);
        }

        @Override // com.bytedance.android.anniex.base.lifecycle.a
        public final void k(String r100, ia.c r101) {
            Intrinsics.checkNotNullParameter(r100, "schema");
            Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
            HybridLogger r102 = HybridLogger.f246343a;
            HybridLogger.m(AnnieXLiteContainer.TAG, "===onRuntimeReady:  " + r100, null, null, 12);
            AnnieXLiteContainer.access$putState(this.f40837a, 5);
            this.f40837a.getLifecycleDispatcher().k(this.f40837a.getUrl(), this.f40837a);
        }

        @Override // com.bytedance.android.anniex.base.lifecycle.a
        public final void g(String r100, ia.c r101, Throwable r102) {
            Intrinsics.checkNotNullParameter(r100, "schema");
            Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
            Intrinsics.checkNotNullParameter(r102, LynxError.LYNX_THROWABLE);
            AnnieXLiteContainer.access$setLoadSuccess$p(this.f40837a, false);
            AnnieXLiteContainer.access$putState(this.f40837a, 4);
            this.f40837a.getLifecycleDispatcher().g(this.f40837a.getUrl(), this.f40837a, r102);
        }
    }

    public static final class c implements SSWebView.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnnieXLiteContainer f40838a;

        public c(AnnieXLiteContainer r100) {
            this.f40838a = r100;
        }

        @Override // com.bytedance.ies.bullet.kit.web.SSWebView.e
        public final void onScrollChanged(int r100, int r101, int r102, int r103) {
            this.f40838a.onWebScrollChanged(r100, r101, r102, r103);
        }
    }

    public static final class d implements com.bytedance.ies.bullet.core.kit.bridge.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f40839a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f40840b;

        @Override // com.bytedance.ies.bullet.core.kit.bridge.h
        public final Object getParams() {
            JSONObject r100 = new JSONObject();
            if (this.f40840b == false) goto L5;
            r100.put("type", "systemBack");
        L5:
            return r100;
        }

        @Override // com.bytedance.ies.bullet.core.kit.bridge.h
        public final String getName() {
            return this.f40839a;
        }

        public d(String r100, boolean r101) {
            this.f40839a = r100;
            this.f40840b = r101;
        }
    }

    public static final class e implements com.bytedance.ies.bullet.core.kit.bridge.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f40841a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AnnieXLiteContainer f40842b;

        @Override // com.bytedance.ies.bullet.core.kit.bridge.h
        public final String getName() {
            return "pageVisibilityChange";
        }

        @Override // com.bytedance.ies.bullet.core.kit.bridge.h
        public final Object getParams() {
            JSONObject r100 = new JSONObject();
            boolean r101 = this.f40841a;
            AnnieXLiteContainer r102 = this.f40842b;
            r100.put("visible", r101);
            if (Intrinsics.areEqual(r102.getViewType(), BrowserDependency.UrlClickType.CARD) == true) goto L12;
            ia.j r103 = AnnieXLiteContainer.access$getUiComponent$p(r102);
            if (r103 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("uiComponent");
            r103 = null;
        L8:
            if (r103.e() == false) goto L10;
            String r104 = "app";
        L11:
            r100.put("source", r104);
            goto L12
        L10:
            r104 = "page";
        L12:
            return r100;
        }

        public e(boolean r100, AnnieXLiteContainer r101) {
            this.f40841a = r100;
            this.f40842b = r101;
        }
    }

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnnieXLiteContainer f40843a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f40844b;

        public f(AnnieXLiteContainer r100, int r101) {
            this.f40843a = r100;
            this.f40844b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AnnieXLiteContainer.access$changeState(this.f40843a, this.f40844b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class g implements com.bytedance.ies.bullet.core.kit.bridge.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final JSONObject f40845a;

        @Override // com.bytedance.ies.bullet.core.kit.bridge.h
        public final String getName() {
            return "H5_keyboardStatusChange";
        }

        @Override // com.bytedance.ies.bullet.core.kit.bridge.h
        public final Object getParams() {
            return this.f40845a;
        }

        public g(JSONObject r100) {
            this.f40845a = r100;
        }
    }

    public static final class h implements com.bytedance.ies.bullet.core.kit.bridge.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final JSONObject f40846a;

        @Override // com.bytedance.ies.bullet.core.kit.bridge.h
        public final String getName() {
            return "keyboardStatusChange";
        }

        @Override // com.bytedance.ies.bullet.core.kit.bridge.h
        public final Object getParams() {
            return this.f40846a;
        }

        public h(JSONObject r100) {
            this.f40846a = r100;
        }
    }

    static {
        Companion = new a();
    }

    @Override // ia.b, ia.c
    public void enterBackground() {
        this.isVisibility = false;
        getEngine().enterBackground();
    }

    @Override // ia.b, ia.c
    public void enterForeground() {
        this.isVisibility = true;
        getEngine().enterForeground();
    }

    public String getPageOptType() {
        return "lite_page";
    }

    @Override // ia.b, ia.c
    public String getViewType() {
        return BrowserDependency.UrlClickType.CARD;
    }

    @Override // ia.b, ia.c
    public void goBack() {
        HybridLogger.m(TAG, "goBack", null, null, 12);
        if (getEngine().canGoBack() == false) goto L5;
        getEngine().goBack();
        return;
    L5:
        close();
    }

    public void onWebScrollChanged(int r100, int r101, int r102, int r103) {
    }

    private final void addTagView() {
        HybridLogger r100 = HybridLogger.f246343a;
        DebugTagTextView r101 = null;
        HybridLogger.m(TAG, "===addTagView: " + getUrl(), null, null, 12);
        ConcurrentHashMap<String, g16.b> r102 = g16.a.f479613a;
        g16.b r103 = g16.a.a(this.currentBid);
        if (showContainerTag(r103) == true) goto L6;
        r103 = null;
    L6:
        if (r103 == null) goto L12;
        View r104 = LayoutInflater.from(this.context).inflate(R.layout.bullet_debug_tag_view, getParentViewGroup(), false);
        if ((r104 instanceof DebugTagTextView) == false) goto L10;
        r101 = (DebugTagTextView) r104;
    L10:
        FrameLayout.LayoutParams r105 = new FrameLayout.LayoutParams(-2, -2);
        r105.gravity = 8388661;
        getParentViewGroup().addView(r101, r105);
        return;
    }

    private final void transferToTargetState() {
    L3:
        if ((!this.stateBlockingQueue.isEmpty()) == false) goto L5;
        changeState(this.stateBlockingQueue.take().intValue());
        goto L3
    }

    private final boolean useSystemDialog() {
        return !(this instanceof AnnieXFlowPageContainer);
    }

    public void addKitView() {
        HybridLogger r100 = HybridLogger.f246343a;
        HybridLogger.m(TAG, "===addKitView: " + getUrl(), null, null, 12);
        getParentViewGroup().removeAllViews();
        View r101 = getEngine().d();
        if (r101 == null) goto L6;
        getParentViewGroup().addView(r101);
        padAdaptation(r101, this.context.getResources().getConfiguration(), true);
        this.lifecycleDispatcher.a(getUrl(), this);
        return;
    }

    @Override // ia.b, ia.c
    public void close() {
        HybridLogger r100 = HybridLogger.f246343a;
        ia.j r101 = null;
        HybridLogger.m(TAG, "===close: " + getUrl(), null, null, 12);
        if (this.isNotRelease == false) goto L10;
        ia.j r102 = this.uiComponent;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("uiComponent");
    L8:
        r101.a();
        return;
    L7:
        r101 = r102;
        goto L8
    }

    public final qa.a getAnnieXContext() {
        return (qa.a) this.annieXContext$delegate.getValue();
    }

    public final v36.a getContainerModel() {
        return (v36.a) this.containerModel$delegate.getValue();
    }

    public final na.a getEngine() {
        return (na.a) this.engine$delegate.getValue();
    }

    public final ViewGroup getParentViewGroup() {
        ViewGroup r100 = this.parentViewGroup;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("parentViewGroup");
        return null;
    }

    @Override // ia.b, ia.c
    public Map<String, Long> getPerfMap() {
        return new LinkedHashMap();
    }

    @Override // ia.b, ia.c
    public WeakReference<Context> getWeakContext() {
        return new WeakReference(getAnnieXContext().getContext());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ia.b, ia.c
    public void hideLoading() {
        HybridLogger r100 = HybridLogger.f246343a;
        com.bytedance.ies.bullet.service.base.q r101 = null;
        HybridLogger.m(TAG, "===hideLoading: " + getUrl(), null, null, 12);
        View r102 = this.loadingView;
        boolean r103 = r102 instanceof com.bytedance.ies.bullet.service.base.q;
        if (r103 == false) goto L8;
        if (r103 == false) goto L6;
        r101 = (com.bytedance.ies.bullet.service.base.q) r102;
    L6:
        if (r101 == null) goto L12;
        r101.hide();
        return;
    L12:
        return;
    L8:
        if (r102 == 0) goto L14;
        r102.setVisibility(8);
        return;
    }

    public final void initUi() {
        HybridLogger r100 = HybridLogger.f246343a;
        HybridLogger.m(TAG, "===initUi: " + getUrl(), null, null, 12);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        observerKeyboardStatusChange();     // Catch: Throwable -> L5
        putState(0);     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L13;
        HybridLogger r104 = HybridLogger.f246343a;
        HybridLogger.i(TAG, "initUi===>" + r103.getMessage(), null, 12);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // ia.b, ia.c
    public void release() {
        if (this.isNotRelease == true) goto L5;
        return;
    L5:
        super.release();
        HybridLogger r100 = HybridLogger.f246343a;
        HybridLogger.m(TAG, "===release: " + getUrl(), null, null, 12);
        removeScreenCaptureListener();
        getEngine().release();
        getAnnieXContext().release();
        this.errorView = null;
        this.loadingView = null;
        this.noticeView = null;
        this.denyView = null;
        this.isNotRelease = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ia.b, ia.c
    public void showError() {
        HybridLogger r100 = HybridLogger.f246343a;
        ia.j r101 = null;
        HybridLogger.m(TAG, "===showError: " + getUrl(), null, null, 12);
        if (this.errorView == null) goto L5;
    L13:
        View r102 = this.errorView;
        if (r102 != 0) goto L16;
        return;
    L16:
        if (this.errorViewAdded == true) goto L19;
        getParentViewGroup().addView(r102);
        this.errorViewAdded = true;
    L19:
        if ((r102 instanceof com.bytedance.ies.bullet.service.base.i) == false) goto L21;
        ((com.bytedance.ies.bullet.service.base.i) r102).show();
        return;
    L21:
        r102.setVisibility(0);
        return;
    L5:
        if (this.isNotRelease == false) goto L13;
        HybridLogger.m(TAG, "create error view", null, null, 12);
        ia.j r103 = this.uiComponent;
        if (r103 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("uiComponent");
    L10:
        View r104 = r101.b();
        if (r104 == null) goto L13;
        this.errorView = r104;
        goto L13
    L9:
        r101 = r103;
        goto L10
    }

    private final void addScreenCaptureListener() {
        if (com.bytedance.ies.bullet.service.base.h.e() == true) goto L5;
        return;
    L5:
        na.a r100 = getEngine();
        Context r101 = this.context;
        if ((r101 instanceof Activity) == false) goto L8;
        Activity r102 = (Activity) r101;
    L9:
        r100.c(r102);
        return;
    L8:
        r102 = null;
        goto L9
    }

    private final void bindWebOnScrollChangeListener() {
        if ((getKitView() instanceof SSWebView) == false) goto L6;
        View r100 = getKitView();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.ies.bullet.kit.web.SSWebView");
        ((SSWebView) r100).setWebScrollListener(new c(this));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initContainerColor() {
        v36.a r100 = getContainerModel();
        if (r100 == null) goto L16;
        Integer r101 = (Integer) r100.e().f565862b;
        if (r101 != null) goto L7;
        r101 = (Integer) r100.b().f565862b;
    L7:
        if (r101 == null) goto L17;
        int r102 = r101.intValue();
        Drawable r103 = getParentViewGroup().getBackground();
        if (r103 == null) goto L13;
        Drawable.ConstantState r104 = r103.getConstantState();
        if (r104 == null) goto L13;
        Drawable r105 = r104.newDrawable();
    L14:
        this.originBackground = r105;
        this.useCustomBackground = true;
        getParentViewGroup().setBackgroundColor(r102);
        return;
    L13:
        r105 = null;
        goto L14
    L17:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean needAdapterKeyboard() {
        if ((getEngine().d() instanceof LynxView) == false) goto L5;
        return false;
    L5:
        v36.a r100 = getContainerModel();
        if (r100 == null) goto L15;
        y36.d r101 = r100.f552861z;
        if (r101 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("softInputMode");
        r101 = null;
    L11:
        if (r101 == null) goto L15;
        Integer r102 = (Integer) r101.f565862b;
        if (r102 == null) goto L15;
        int r103 = r102.intValue();
    L17:
        if (r103 <= (-1)) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(getViewType(), "page") == false) goto L40;
        v36.a r104 = getContainerModel();
        if (r104 == null) goto L26;
        y36.a r105 = r104.h();
        if (r105 == null) goto L26;
        boolean r106 = Intrinsics.areEqual(r105.f565862b, Boolean.TRUE);
    L27:
        if (r106 == true) goto L36;
        v36.a r107 = getContainerModel();
        if (r107 == null) goto L33;
        y36.a r108 = r107.j();
        if (r108 == null) goto L33;
        boolean r109 = Intrinsics.areEqual(r108.f565862b, Boolean.TRUE);
    L34:
        if (r109 == true) goto L36;
        return false;
    L33:
        r109 = false;
    L36:
        if (r103 != (-2)) goto L45;
        return true;
    L45:
        return false;
    L26:
        r106 = false;
        goto L27
    L40:
        if (Intrinsics.areEqual(getViewType(), "popup") == false) goto L46;
        if (r103 != (-1)) goto L47;
        return true;
    L47:
        return false;
    L46:
        return false;
    L15:
        r103 = 0;
        goto L17
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean needAdapterKeyboard4Web() {
        if (getKitType() != KitType.LYNX) goto L5;
        return false;
    L5:
        v36.a r100 = getContainerModel();
        if (r100 == null) goto L15;
        y36.d r101 = r100.f552861z;
        if (r101 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("softInputMode");
        r101 = null;
    L11:
        if (r101 == null) goto L15;
        Integer r102 = (Integer) r101.f565862b;
        if (r102 == null) goto L15;
        int r103 = r102.intValue();
    L16:
        if (r103 <= (-1)) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(getViewType(), "page") == false) goto L39;
        v36.a r104 = getContainerModel();
        if (r104 == null) goto L25;
        y36.a r105 = r104.h();
        if (r105 == null) goto L25;
        boolean r106 = Intrinsics.areEqual(r105.f565862b, Boolean.TRUE);
    L26:
        if (r106 == true) goto L35;
        v36.a r107 = getContainerModel();
        if (r107 == null) goto L32;
        y36.a r108 = r107.j();
        if (r108 == null) goto L32;
        boolean r109 = Intrinsics.areEqual(r108.f565862b, Boolean.TRUE);
    L33:
        if (r109 == true) goto L35;
        return false;
    L32:
        r109 = false;
    L35:
        if (r103 != (-2)) goto L44;
        return true;
    L44:
        return false;
    L25:
        r106 = false;
        goto L26
    L39:
        if (Intrinsics.areEqual(getViewType(), "popup") == false) goto L45;
        if (r103 != (-1)) goto L46;
        return true;
    L46:
        return false;
    L45:
        return false;
    L15:
        r103 = -1;
        goto L16
    }

    private final void removeScreenCaptureListener() {
        if (com.bytedance.ies.bullet.service.base.h.e() == true) goto L5;
        return;
    L5:
        na.a r100 = getEngine();
        Context r101 = this.context;
        if ((r101 instanceof Activity) == false) goto L8;
        Activity r102 = (Activity) r101;
    L9:
        r100.e(r102);
        return;
    L8:
        r102 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setBackgroundColor() {
        v36.a r100 = getContainerModel();
        Intrinsics.checkNotNull(r100);
        Integer r101 = (Integer) r100.b().f565862b;
        if (r101 == null) goto L5;
        int r102 = r101.intValue();
        getParentViewGroup().setBackgroundColor(r102);
        Unit r103 = Unit.INSTANCE;
    L6:
        if (r103 == null) goto L8;
        return;
    L8:
        if (this.useCustomBackground == false) goto L12;
        getParentViewGroup().setBackground(this.originBackground);
        this.useCustomBackground = false;
        return;
    L12:
        return;
    L5:
        r103 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setContainerColor() {
        v36.a r100 = getContainerModel();
        if (r100 == null) goto L23;
        XBaseRuntime.f270095a.getClass();
        IHostContextDepend r101 = XBaseRuntime.f270100f;
        Unit r102 = null;
        if (r101 == null) goto L7;
        String r103 = r101.getSkinName();
    L8:
        if (r103 != null) goto L10;
        setBackgroundColor();
        return;
    L10:
        if (Intrinsics.areEqual(r103.toLowerCase(), "light") == false) goto L16;
        Integer r104 = (Integer) r100.d().f565862b;
        if (r104 == null) goto L14;
        getParentViewGroup().setBackgroundColor(r104.intValue());
        r102 = Unit.INSTANCE;
    L14:
        if (r102 != null) goto L24;
        setBackgroundColor();
        return;
    L24:
        return;
    L16:
        Integer r105 = (Integer) r100.c().f565862b;
        if (r105 == null) goto L19;
        getParentViewGroup().setBackgroundColor(r105.intValue());
        r102 = Unit.INSTANCE;
    L19:
        if (r102 != null) goto L26;
        setBackgroundColor();
        return;
    L26:
        return;
    L7:
        r103 = null;
        goto L8
    }

    private final void updateLynxScreenMetrics() {
        View r100 = getEngine().d();
        if (r100 == null) goto L10;
        t36.j r101 = getAnnieXContext().f532202f;
        Integer r102 = b46.c.f17525a;
        Intrinsics.areEqual(getViewType(), "page");
        Scenes r103 = Scenes.AbsActivity;
        b46.c.d(r101);
        Context r104 = r100.getContext();
        if (r104 == null) goto L11;
        b46.i r105 = b46.m.a(r104);
        if (r105 == null) goto L12;
        updateScreenMetrics(r105.f17540a, r105.f17541b);
        HybridLogger r106 = HybridLogger.f246343a;
        HybridLogger.m(TAG, "updateLynxScreenMetrics : enableIpadAdapter false , width " + r105.f17540a + " , height " + r105.f17541b, null, null, 12);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // ia.b, ia.c
    public boolean canBackPress() {
        v36.a r100 = getContainerModel();
        if (r100 == null) goto L7;
        y36.a r101 = r100.g();
        if (r101 == null) goto L7;
        boolean r102 = Intrinsics.areEqual(r101.f565862b, Boolean.TRUE);
    L8:
        if (r102 == false) goto L10;
        String r103 = "containerShouldClose";
    L11:
        sendEvent(new d(r103, r102));
        return !r102;
    L10:
        r103 = "on_key_back";
    L7:
        r102 = false;
        goto L8
    }

    @Override // ia.b, ia.c
    public boolean canGoBack() {
        return getEngine().canGoBack();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ia.b, ia.c
    public LaunchMode getBDXLaunchMode() {
        LaunchMode r100 = (LaunchMode) new y36.e(getAnnieXContext().f532202f.f544443a, null).f565862b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return LaunchMode.MODE_UNSPECIFIED;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ia.b, ia.c
    public String getBDXTag() {
        return (String) new y36.p(getAnnieXContext().f532202f.f544443a, "bdx_tag", null).f565862b;
    }

    @Override // ia.b, ia.c
    public String getBid() {
        return getAnnieXContext().f532199c;
    }

    @Override // ia.b, ia.c
    public String getContainerId() {
        return getAnnieXContext().f532198b;
    }

    @Override // ia.b, ia.c
    public m16.b getContextProviderFactory() {
        return getAnnieXContext().f532204h;
    }

    @Override // ia.b, ia.c
    public t36.d getCurrentSchema() {
        return getAnnieXContext().f532202f.f544443a;
    }

    @Override // ia.b, ia.c
    public String getCurrentUrl() {
        return getAnnieXContext().f532201e;
    }

    @Override // ia.b, ia.c
    public KitType getKitType() {
        return getAnnieXContext().f532200d;
    }

    @Override // ia.b, ia.c
    public View getKitView() {
        return getEngine().d();
    }

    @Override // ia.b, ia.c
    public t36.d getSchemaData() {
        return getAnnieXContext().f532202f.f544443a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String getUrl() {
        v36.a r100 = getContainerModel();
        if (r100 == null) goto L9;
        s r101 = r100.f();
        if (r101 == null) goto L9;
        Uri r102 = (Uri) r101.f565862b;
        if (r102 == null) goto L9;
        String r103 = r102.toString();
    L10:
        if (r103 != null) goto L13;
        return "unknown";
    L13:
        return r103;
    L9:
        r103 = null;
        goto L10
    }

    @Override // ia.b
    public void observerKeyboardStatusChange() {
        if (com.bytedance.ies.bullet.service.base.h.o0() == false) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(getViewType(), BrowserDependency.UrlClickType.CARD) == true) goto L14;
        Context r100 = this.context;
        if ((r100 instanceof Activity) == false) goto L10;
        final Activity r101 = (Activity) r100;
    L11:
        if (r101 == null) goto L15;
        SoftInputKt.c(r101, new AnnieXLiteContainer$observerKeyboardStatusChange$1$1(r101, this));
        return;
    L15:
        return;
    L10:
        r101 = null;
        goto L11
    }

    @Override // ia.b
    public void removeKitView() {
        removeScreenCaptureListener();
        getEngine().release();
    }

    public final UIComponentBuilder getBuilder() {
        return this.builder;
    }

    public final boolean getContainerVisible() {
        return this.containerVisible;
    }

    public final Context getContext() {
        return this.context;
    }

    public final com.bytedance.android.anniex.container.b getLifecycleDispatcher() {
        return this.lifecycleDispatcher;
    }

    public Scenes getScenes() {
        return Scenes.LitePage;
    }

    @Override // ia.b, ia.c
    public Context getSystemContext() {
        return this.context;
    }

    @Override // ia.b
    public boolean isVisibility() {
        return this.isVisibility;
    }

    public AnnieXLiteContainer(UIComponentBuilder r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        this.builder = r100;
        com.bytedance.android.anniex.container.b r101 = new com.bytedance.android.anniex.container.b();
        com.bytedance.android.anniex.base.lifecycle.a r102 = r100.f40263f;
        if (r102 == null) goto L5;
        Intrinsics.checkNotNullParameter(r102, NewBroadcastMonitor.STAGE.LIFECYCLE);
        r101.f40349a.add(r102);
    L5:
        this.lifecycleDispatcher = r101;
        this.containerModel$delegate = LazyKt.lazy(new AnnieXLiteContainer$containerModel$2(this));
        this.currentBid = r100.f40259b;
        Context r103 = r100.f40258a;
        if (r103 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("systemContext");
        r103 = null;
    L9:
        this.context = r103;
        this.annieXContext$delegate = LazyKt.lazy(new AnnieXLiteContainer$annieXContext$2(this));
        this.engine$delegate = LazyKt.lazy(new AnnieXLiteContainer$engine$2(this));
        this.currentState = -1;
        this.stateBlockingQueue = new ArrayBlockingQueue(10);
        this.isNotRelease = true;
        this.annieLifeCycle = new b(this);
    }

    public static final /* synthetic */ void access$addScreenCaptureListener(AnnieXLiteContainer r100) {
        r100.addScreenCaptureListener();
    }

    public static final /* synthetic */ void access$bindWebOnScrollChangeListener(AnnieXLiteContainer r100) {
        r100.bindWebOnScrollChangeListener();
    }

    public static final /* synthetic */ ia.j access$getUiComponent$p(AnnieXLiteContainer r100) {
        return r100.uiComponent;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void changeState(int r100) {
        this.currentState = r100;
        if (r100 != 0) goto L5;
        transferToTargetState();
        initContainerColor();
        return;
    L5:
        if (r100 == 1) goto L52;
        if (r100 != 2) goto L9;
        getParentViewGroup().removeAllViews();
        this.errorViewAdded = false;
        addKitView();
        v36.a r101 = getContainerModel();
        if (r101 == null) goto L74;
        y36.a r102 = r101.i();
        if (r102 == null) goto L75;
        Boolean r103 = (Boolean) r102.f565862b;
        if (r103 != null) goto L28;
        return;
    L28:
        if (r103.booleanValue() == true) goto L31;
        r103 = null;
    L31:
        if (r103 == null) goto L77;
        r103.booleanValue();
        if (this.loadingView == null) goto L35;
    L40:
        View r104 = this.loadingView;
        if (r104 == null) goto L50;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        if ((r105 instanceof FrameLayout.LayoutParams) == false) goto L45;
        FrameLayout.LayoutParams r106 = (FrameLayout.LayoutParams) r105;
    L46:
        if (r106 == null) goto L49;
        r106.gravity = 17;
    L49:
        getParentViewGroup().addView(r104);
        goto L50
    L45:
        r106 = null;
    L50:
        showLoading(null);
        return;
    L35:
        if (this.isNotRelease == false) goto L40;
        HybridLogger.m(TAG, "create loading view", null, null, 12);
        ia.j r107 = this.uiComponent;
        if (r107 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("uiComponent");
        r107 = null;
    L39:
        this.loadingView = r107.c();
        goto L40
    L77:
        return;
    L75:
        return;
    L74:
        return;
    L9:
        if (r100 == 4) goto L17;
        if (r100 != 5) goto L80;
        this.isRuntimeReady = true;
        if (this.isResuming == false) goto L71;
        getEngine().enterForeground();
        return;
    L71:
        return;
    L80:
        return;
    L17:
        if (this.loadSuccess == false) goto L19;
        HybridLogger.f(TAG, "load success", null, 12);
        setContainerColor();
    L20:
        hideLoading();
        addTagView();
        return;
    L19:
        HybridLogger.f(TAG, "load fail", null, 12);
        showError();
        goto L20
    L52:
        if (Intrinsics.areEqual(getViewType(), "popup") == false) goto L61;
        com.bytedance.android.anniex.assemble.a r108 = com.bytedance.android.anniex.assemble.a.f40251a;
        Iterator r109 = com.bytedance.android.anniex.assemble.a.e().entrySet().iterator();
    L55:
        if (r109.hasNext() == false) goto L61;
        ia.c r110 = (ia.c) ((WeakReference) ((Map.Entry) r109.next()).getValue()).get();
        if (r110 == null) goto L55;
        if (Intrinsics.areEqual(r110.getWeakContext().get(), this.context) == false) goto L55;
        r110.onVisibleChange(false, Boolean.FALSE);
    L61:
        AnnieXContainerManager.INSTANCE.addContainer(this);
    }

    private final Map<String, Object> completeRenderData(Map<String, ? extends Object> r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        String r102 = getAnnieXContext().f532198b;
        if (r102 == null) goto L15;
        Map<String, i36.d> r103 = MonitorManager.f40977a;
        Intrinsics.checkNotNullParameter(r102, "sessionId");
        i36.d r104 = (i36.d) ((LinkedHashMap) MonitorManager.f40977a).get(r102);
        if (r104 == null) goto L7;
        LinkedHashMap r105 = new LinkedHashMap();
        r105.put("open_time", Long.valueOf(r104.b("open_time")));
        r105.put("container_init_start", Long.valueOf(r104.b("container_init_start")));
        r105.put("container_init_end", Long.valueOf(r104.b("container_init_end")));
    L8:
        if (r105 == null) goto L15;
        r101.putAll(r105);
        Object r106 = r105.get("open_time");
        if (r106 == null) goto L15;
        if (Intrinsics.areEqual(this.builder.f40259b, "webcast") == false) goto L14;
        r101.put("initTimestamp", r106.toString());
        r101.remove("open_time");
        goto L15
    L14:
        r101.put("containerInitTime", r106);
        goto L15
    L7:
        r105 = null;
    L15:
        r101.put("page_type_opt", getPageOptType());
        if (r100 == null) goto L18;
        r101.putAll(r100);
    L18:
        return r101;
    }

    private final qa.a createAnnieXContext(UIComponentBuilder r110) {
        Uri r100 = getUriByBundle(r110.f40260c);
        String r101 = q26.i.b(r100, r110.f40260c);
        LruCache<String, AnnieXWebModel> r102 = com.bytedance.android.anniex.lite.c.f40797a;
        t36.j r103 = com.bytedance.android.anniex.lite.c.a(this.currentBid, r100, r101);
        String r104 = r103.f544443a.c().get("url");
        if (r104 != null) goto L5;
        r104 = r100.toString();
    L5:
        String r105 = r104;
        AnnieXJSWorkerManager r106 = AnnieXJSWorkerManager.f41481a;
        Context r107 = this.context.getApplicationContext();
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type android.app.Application");
        r106.c((Application) r107, r100.toString());
        qa.a r108 = new qa.a(getScenes(), r101, this.currentBid, r110.f40260c, r105, com.bytedance.android.anniex.lite.utils.c.a(UriProtector.parse(r105)), r103);
        Context r111 = r110.f40258a;
        if (r111 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("systemContext");
        r111 = null;
    L9:
        r108.f532203g = r111;
        return r108;
    }

    private final na.a createEngine(qa.a r100) {
        if (r100.f532200d == KitType.LYNX) goto L17;
        Map<String, Map<Class<?>, Object>> r101 = x26.a.f562251a;
        w26.g r102 = (w26.g) x26.a.a(w26.g.class);
        if (r102 == null) goto L10;
        w26.e r103 = (w26.e) r102.n0(w26.e.class);
        if (r103 == null) goto L10;
        boolean r104 = r103.h0();
    L11:
        if (r104 == false) goto L16;
        if (StringsKt.contains$default(r100.f532201e, "template.js", false, 2, null) == false) goto L16;
        HybridLogger r105 = HybridLogger.f246343a;
        HybridLogger.i(TAG, "===createEngine Web error:" + r100.f532202f.f544443a.getOriginUrl(), null, 12);
    L16:
        return new o(r100, this);
    L10:
        r104 = true;
        goto L11
    L17:
        return new l(r100, this);
    }

    private final View getContentView(View r100) {
        View r101 = r100.findViewById(android.R.id.content);
        if ((r101 instanceof ViewGroup) == true) goto L7;
        return null;
    L7:
        return (ViewGroup) r101;
    }

    private final Uri getUriByBundle(Bundle r100) {
        String r101 = r100.getString("__x_inner_schema");
        if (r101 == null) goto L5;
        Uri r102 = UriProtector.parse(r101);
    L6:
        if (r102 == null) goto L8;
        return r102;
    L8:
        return Uri.EMPTY;
    L5:
        r102 = null;
        goto L6
    }

    private final m16.b mergeContext(m16.b r100) {
        m16.b r101 = getAnnieXContext().f532204h;
        if (r100 == null) goto L5;
        r101.b(r100);
    L5:
        r101.d(com.bytedance.android.anniex.lite.utils.a.class, new com.bytedance.android.anniex.lite.utils.a("nl"));
        return r101;
    }

    private final void possiblyResizeChildOfContent(int r100) {
        if (needAdapterKeyboard() == true) goto L5;
        return;
    L5:
        View r101 = getParentViewGroup().getRootView();
        int r102 = r101.getHeight();
        int r103 = r102 - r100;
        if (r103 == this.usableHeightPrevious) goto L18;
        View r104 = getContentView(r101);
        if (r104 == null) goto L10;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
    L11:
        if (r105 != null) goto L13;
        return;
    L13:
        if (r100 <= (r102 / 4)) goto L15;
        r105.height = r103;
    L16:
        r104.requestLayout();
        this.usableHeightPrevious = r103;
        return;
    L15:
        r105.height = r102;
        goto L16
    L10:
        r105 = null;
        goto L11
    }

    private final void possiblyResizeChildOfContent4Web(int r100) {
        if (needAdapterKeyboard4Web() == true) goto L5;
        return;
    L5:
        v36.a r101 = getContainerModel();
        ViewGroup.LayoutParams r102 = null;
        if (r101 == null) goto L13;
        y36.a r103 = r101.G;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("disableInputScroll");
        r103 = null;
    L11:
        if (r103 == null) goto L13;
        boolean r104 = Intrinsics.areEqual(r103.f565862b, Boolean.TRUE);
    L14:
        if (r104 == false) goto L16;
        return;
    L16:
        View r105 = getParentViewGroup().getRootView();
        int r106 = r105.getHeight();
        int r107 = r106 - r100;
        if (r107 == this.usableHeightPrevious) goto L38;
        View r108 = getContentView(r105);
        if (useSystemDialog() == true) goto L21;
    L29:
        if (r108 == null) goto L31;
        r102 = r108.getLayoutParams();
    L31:
        if (r102 != null) goto L33;
        return;
    L33:
        if (r100 <= (r106 / 4)) goto L35;
        r102.height = r107;
    L36:
        r108.requestLayout();
        this.usableHeightPrevious = r107;
        return;
    L35:
        r102.height = r106;
        goto L36
    L21:
        if (AnnieXContainerManager.isTopContainer(this) == false) goto L29;
        if (r100 != 0) goto L25;
        if (r108 == null) goto L27;
        r108.scrollTo(0, 0);
    L27:
        this.usableHeightPrevious = r107;
        return;
    L25:
        if (r108 == null) goto L27;
        r108.scrollBy(0, r100);
        goto L27
    L38:
        return;
    L13:
        r104 = false;
        goto L14
    }

    private final void putState(int r100) {
        if (this.parentViewGroup == null) goto L10;
        Context r101 = this.context;
        if ((r101 instanceof Activity) == false) goto L7;
        Activity r102 = (Activity) r101;
    L8:
        if (r102 == null) goto L12;
        r102.runOnUiThread(new f(this, r100));
        return;
    L12:
        return;
    L7:
        r102 = null;
        goto L8
    L10:
        this.stateBlockingQueue.put(Integer.valueOf(r100));
    }

    private final boolean showContainerTag(g16.b r100) {
        com.bytedance.ies.bullet.core.h r101 = com.bytedance.ies.bullet.core.h.f246501h;
        com.bytedance.ies.bullet.core.h r102 = com.bytedance.ies.bullet.core.h.f246501h;
        if (r102.f246502a == false) goto L7;
        r102.getClass();
        if (r100.f479614a == false) goto L7;
        return true;
    L7:
        return false;
    }

    @Override // ia.b, ia.c
    public t36.d generateSchemaData(String r100) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        return getAnnieXContext().f532202f.f544443a;
    }

    @Override // ia.b, ia.c
    public void interceptBackPress(boolean r100) {
        v36.a r101 = getContainerModel();
        if (r101 == null) goto L6;
        y36.a r102 = new y36.a(Boolean.valueOf(r100));
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r101.f552844i = r102;
    L6:
        ia.j r103 = this.uiComponent;
        if (r103 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("uiComponent");
        r103 = null;
    L9:
        r103.d(r100);
    }

    public void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        padAdaptation$default(this, getEngine().d(), r100, false, 4, null);
        updateLynxScreenMetrics();
    }

    public final void onSoftInputChange(boolean r100) {
        Context r101 = this.context;
        if ((r101 instanceof Activity) == false) goto L5;
        Activity r102 = (Activity) r101;
    L6:
        if (r102 == null) goto L25;
        if (r100 == false) goto L21;
        int r103 = z06.c.b(r102);
        int r104 = (int) com.bytedance.android.anniex.container.util.i.f40626a.e(z06.c.b(r102));
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L11
        possiblyResizeChildOfContent4Web(r103);     // Catch: Throwable -> L11
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        sendKeyboardStatusChangeEvent(true, r104);
        return;
    L11:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    L21:
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L17
        possiblyResizeChildOfContent4Web(0);     // Catch: Throwable -> L17
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L19:
        sendKeyboardStatusChangeEvent(false, 0);
        return;
    L17:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L19
    L25:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // ia.b
    public void recreateKitView(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        loadSchema(r100, null);
    }

    @Override // ia.b, ia.c
    public void reload(Map<String, ? extends Object> r100) {
        if (this.loadSuccess == false) goto L10;
        int r101 = this.currentState;
        if (r101 != 5) goto L7;
    L8:
        getEngine().reload();
        return;
    L7:
        if (r101 == 4) goto L8;
    L10:
        loadSchema(getUrl(), r100);
    }

    @Override // ia.b, ia.c
    public void sendEvent(com.bytedance.ies.bullet.core.kit.bridge.h r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        getEngine().sendEvent(r100);
    }

    public final void setContainerVisible(boolean r100) {
        this.containerVisible = r100;
    }

    public final void setParentViewGroup(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.parentViewGroup = r100;
    }

    public final void setUiComponent(ia.j r100) {
        Intrinsics.checkNotNullParameter(r100, "uiComponent");
        this.uiComponent = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ia.b, ia.c
    public void showLoading(String r100) {
        HybridLogger r101 = HybridLogger.f246343a;
        com.bytedance.ies.bullet.service.base.q r102 = null;
        HybridLogger.m(TAG, "===showLoading: " + getUrl(), null, null, 12);
        View r103 = this.loadingView;
        boolean r104 = r103 instanceof com.bytedance.ies.bullet.service.base.q;
        if (r104 == false) goto L8;
        if (r104 == false) goto L6;
        r102 = (com.bytedance.ies.bullet.service.base.q) r103;
    L6:
        if (r102 == null) goto L12;
        r102.show();
        return;
    L12:
        return;
    L8:
        if (r103 == 0) goto L14;
        r103.setVisibility(0);
        return;
    }

    @Override // ia.b
    public void updateData(String r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        getEngine().updateData(r100);
    }

    @Override // ia.b, ia.c
    public void updateGlobalProps(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "globalProps");
        getAnnieXContext().f532205i.putAll(r100);
        getEngine().updateGlobalProps(r100);
    }

    @Override // ia.b, ia.c
    public void updateData(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        getEngine().updateData(r100);
    }

    public static final /* synthetic */ void access$changeState(AnnieXLiteContainer r100, int r101) {
        r100.changeState(r101);
    }

    public static final /* synthetic */ qa.a access$createAnnieXContext(AnnieXLiteContainer r100, UIComponentBuilder r101) {
        return r100.createAnnieXContext(r101);
    }

    public static final /* synthetic */ na.a access$createEngine(AnnieXLiteContainer r100, qa.a r101) {
        return r100.createEngine(r101);
    }

    public static final /* synthetic */ void access$possiblyResizeChildOfContent(AnnieXLiteContainer r100, int r101) {
        r100.possiblyResizeChildOfContent(r101);
    }

    public static final /* synthetic */ void access$putState(AnnieXLiteContainer r100, int r101) {
        r100.putState(r101);
    }

    public static final /* synthetic */ void access$setLoadSuccess$p(AnnieXLiteContainer r100, boolean r101) {
        r100.loadSuccess = r101;
    }

    private final void sendKeyboardStatusChangeEvent(boolean r100, int r101) {
        JSONObject r102 = new JSONObject();
        r102.put("visible", r100);
        r102.put("height", r101);
        sendEvent(new g(r102));
        sendEvent(new h(r102));
    }

    @Override // ia.b, ia.c
    public void loadSchema(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        loadSchema(r100, r101, null, this.annieLifeCycle);
    }

    @Override // ia.b, ia.c
    public void onVisibleChange(boolean r100, Boolean r101) {
        if (r100 != this.containerVisible) goto L5;
        return;
    L5:
        this.containerVisible = r100;
        sendEvent(new e(r100, this));
    }

    @Override // ia.b, ia.c
    public <T> void registerWeakHolder(Class<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        m16.b r102 = getAnnieXContext().f532204h;
        if (r102 == null) goto L6;
        r102.g(r100, r101);
        return;
    }

    @Override // ia.b, ia.c
    public void updateScreenMetrics(int r100, int r101) {
        getEngine().a();
    }

    public static final /* synthetic */ void access$sendKeyboardStatusChangeEvent(AnnieXLiteContainer r100, boolean r101, int r102) {
        r100.sendKeyboardStatusChangeEvent(r101, r102);
    }

    private final void padAdaptation(View r100, Configuration r101, boolean r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        Intrinsics.areEqual(getViewType(), "page");
        Scenes r103 = Scenes.AbsActivity;
        Integer r104 = b46.c.f17525a;
        b46.c.d(getAnnieXContext().f532202f);
        HybridLogger r105 = HybridLogger.f246343a;
        HybridLogger.m(TAG, "padAdaptation : current scenes=" + getViewType() + ",padAdapterWidth=" + this.padAdapterWidth + ",padAdapterHeight=" + this.padAdapterHeight, null, null, 12);
    }

    @Override // ia.b
    public void loadSchema(String r100, Map<String, ? extends Object> r101, m16.b r102, com.bytedance.android.anniex.base.lifecycle.a r103) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        String r104 = getAnnieXContext().f532198b;
        if (r104 == null) goto L5;
        Map<String, i36.d> r105 = MonitorManager.f40977a;
        Intrinsics.checkNotNullParameter(r104, "sessionId");
        long r106 = System.currentTimeMillis();
        MonitorManager.d0(MonitorManager.f40977a, r104).c("container_init_end", Long.valueOf(r106));
        ExecutorService r107 = com.bytedance.ies.bullet.service.monitor.a.f247969a;
        com.bytedance.ies.bullet.service.monitor.a.c(r104, "container_init_end", Long.valueOf(r106));
        SLMonitorCompat r108 = SLMonitorCompat.f41001a;
        SLContainerTiming r109 = SLContainerTiming.ContainerInitEnd;
        r108.getClass();
        SLMonitorCompat.g(r104, r109, r106);
        SLMonitorCompat.r(r104, r100);
    L5:
        getEngine().b(r100, completeRenderData(r101), mergeContext(r102), this.annieLifeCycle);
    }

    public static /* synthetic */ void padAdaptation$default(AnnieXLiteContainer r100, View r101, Configuration r102, boolean r103, int r104, Object r105) {
        if (r105 != null) goto L9;
        if ((r104 & 4) == 0) goto L6;
        r103 = false;
    L6:
        r100.padAdaptation(r101, r102, r103);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: padAdaptation");
    }
}

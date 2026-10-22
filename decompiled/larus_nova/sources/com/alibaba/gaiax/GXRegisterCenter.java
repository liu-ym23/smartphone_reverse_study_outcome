package com.alibaba.gaiax;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.gaiax.api.GXRegisterCenterApi;
import com.alibaba.gaiax.api.IGXRegisterCenter;
import com.alibaba.gaiax.context.GXTemplateContext;
import com.alibaba.gaiax.render.node.GXINodeEvent;
import com.alibaba.gaiax.render.node.GXTemplateNode;
import com.alibaba.gaiax.render.view.GXViewFactory;
import com.alibaba.gaiax.render.view.container.GXContainer;
import com.alibaba.gaiax.render.view.container.GXContainerViewAdapter;
import com.alibaba.gaiax.template.GXFlexBox;
import com.alibaba.gaiax.template.GXGridConfig;
import com.alibaba.gaiax.template.GXMeasureSize;
import com.alibaba.gaiax.template.GXScrollConfig;
import com.alibaba.gaiax.template.GXStyle;
import com.alibaba.gaiax.template.GXTemplateInfo;
import com.alibaba.gaiax.template.GXTemplateItem;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.alibaba.gaiax.template.animation.GXLottieAnimation;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b*\u0002\u0004\u0007\b\u0007\u0018\u0000 ¨\u00012\u00020\u0001:\u0014¨\u0001©\u0001ª\u0001«\u0001¬\u0001\u00ad\u0001®\u0001¯\u0001°\u0001±\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010}\u001a\u00020\u00012\u0006\u0010~\u001a\u00020\u000b2\u0006\u0010\u007f\u001a\u00020\fH\u0016J\u0011\u0010\u0080\u0001\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0011\u0010\u0081\u0001\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u000f\u0010\u0082\u0001\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001eJ\u000f\u0010\u0083\u0001\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$J\u000f\u0010\u0084\u0001\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*J\u0012\u0010\u0085\u0001\u001a\u00020\u00002\u0007\u0010\u0086\u0001\u001a\u000200H\u0016J\u000f\u0010\u0087\u0001\u001a\u00020\u00002\u0006\u00105\u001a\u000206J\u0011\u0010\u0088\u0001\u001a\u00020\u00002\u0006\u0010;\u001a\u00020<H\u0016J\u0011\u0010\u0089\u0001\u001a\u00020\u00002\u0006\u0010A\u001a\u00020BH\u0016J\u0013\u0010\u008a\u0001\u001a\u00020\u00002\b\u0010\u008b\u0001\u001a\u00030\u008c\u0001H\u0016J\u000f\u0010\u008d\u0001\u001a\u00020\u00002\u0006\u0010G\u001a\u00020HJ\u000f\u0010\u008e\u0001\u001a\u00020\u00002\u0006\u0010M\u001a\u00020NJ\u000f\u0010\u008f\u0001\u001a\u00020\u00002\u0006\u0010S\u001a\u00020TJ\u000f\u0010\u0090\u0001\u001a\u00020\u00002\u0006\u0010Y\u001a\u00020ZJ\u0011\u0010\u0091\u0001\u001a\u00020\u00002\u0006\u0010_\u001a\u00020`H\u0016J\u0011\u0010\u0092\u0001\u001a\u00020\u00002\u0006\u0010e\u001a\u00020fH\u0016J\u001b\u0010\u0093\u0001\u001a\u00020\u00002\b\u0010\u0094\u0001\u001a\u00030\u0095\u00012\b\u0010\u0096\u0001\u001a\u00030\u0097\u0001J\u001d\u0010\u0098\u0001\u001a\u00020\u00002\b\u0010\u0094\u0001\u001a\u00030\u0099\u00012\b\u0010\u0096\u0001\u001a\u00030\u0097\u0001H\u0016J\u0012\u0010\u009a\u0001\u001a\u00020\u00002\u0007\u0010\u009b\u0001\u001a\u00020lH\u0016J*\u0010\u009c\u0001\u001a\u00020\u00002\u0007\u0010\u009d\u0001\u001a\u00020\u000b2\u0016\u0010\u009e\u0001\u001a\u0011\u0012\u0005\u0012\u00030 \u0001\u0012\u0005\u0012\u00030¡\u00010\u009f\u0001H\u0016J \u0010\u009c\u0001\u001a\u00020\u00002\u0007\u0010\u009d\u0001\u001a\u00020\u000b2\f\u0010¢\u0001\u001a\u0007\u0012\u0002\b\u00030£\u0001H\u0016J\u0011\u0010¤\u0001\u001a\u00020\u00002\u0006\u0010w\u001a\u00020xH\u0016J\u0011\u0010¥\u0001\u001a\u00020\u00002\u0006\u0010q\u001a\u00020rH\u0016J\n\u0010¦\u0001\u001a\u00030§\u0001H\u0016R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR&\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010/\u001a\u0004\u0018\u000100X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001c\u00105\u001a\u0004\u0018\u000106X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001c\u0010;\u001a\u0004\u0018\u00010<X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001c\u0010A\u001a\u0004\u0018\u00010BX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001c\u0010G\u001a\u0004\u0018\u00010HX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001c\u0010M\u001a\u0004\u0018\u00010NX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u001c\u0010S\u001a\u0004\u0018\u00010TX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001c\u0010Y\u001a\u0004\u0018\u00010ZX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u001c\u0010_\u001a\u0004\u0018\u00010`X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u001c\u0010e\u001a\u0004\u0018\u00010fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\u001e\u0010k\u001a\u0004\u0018\u00010l8@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\u001e\u0010q\u001a\u0004\u0018\u00010r8@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR\u001c\u0010w\u001a\u0004\u0018\u00010xX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010z\"\u0004\b{\u0010|¨\u0006²\u0001"}, d2 = {"Lcom/alibaba/gaiax/GXRegisterCenter;", "Lcom/alibaba/gaiax/api/IGXRegisterCenter;", "()V", "defaultExtensionViewClass", "com/alibaba/gaiax/GXRegisterCenter$defaultExtensionViewClass$1", "Lcom/alibaba/gaiax/GXRegisterCenter$defaultExtensionViewClass$1;", "defaultImageLoader", "com/alibaba/gaiax/GXRegisterCenter$defaultImageLoader$1", "Lcom/alibaba/gaiax/GXRegisterCenter$defaultImageLoader$1;", "experimentMap", "", "", "", "getExperimentMap$GaiaX", "()Ljava/util/Map;", "setExperimentMap$GaiaX", "(Ljava/util/Map;)V", "extensionBizMap", "Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXIExtensionBizMap;", "getExtensionBizMap$GaiaX", "()Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXIExtensionBizMap;", "setExtensionBizMap$GaiaX", "(Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXIExtensionBizMap;)V", "extensionColor", "Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXIExtensionColor;", "getExtensionColor$GaiaX", "()Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXIExtensionColor;", "setExtensionColor$GaiaX", "(Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXIExtensionColor;)V", "extensionCompatibility", "Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionCompatibility;", "getExtensionCompatibility$GaiaX", "()Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionCompatibility;", "setExtensionCompatibility$GaiaX", "(Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionCompatibility;)V", "extensionContainerDataUpdate", "Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionContainerDataUpdate;", "getExtensionContainerDataUpdate$GaiaX", "()Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionContainerDataUpdate;", "setExtensionContainerDataUpdate$GaiaX", "(Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionContainerDataUpdate;)V", "extensionContainerItemBind", "Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionContainerItemBind;", "getExtensionContainerItemBind$GaiaX", "()Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionContainerItemBind;", "setExtensionContainerItemBind$GaiaX", "(Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionContainerItemBind;)V", "extensionDataBinding", "Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXIExtensionDataBinding;", "getExtensionDataBinding$GaiaX", "()Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXIExtensionDataBinding;", "setExtensionDataBinding$GaiaX", "(Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXIExtensionDataBinding;)V", "extensionDynamicProperty", "Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionDynamicProperty;", "getExtensionDynamicProperty$GaiaX", "()Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionDynamicProperty;", "setExtensionDynamicProperty$GaiaX", "(Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionDynamicProperty;)V", "extensionException", "Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXIExtensionException;", "getExtensionException$GaiaX", "()Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXIExtensionException;", "setExtensionException$GaiaX", "(Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXIExtensionException;)V", "extensionExpression", "Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXIExtensionExpression;", "getExtensionExpression$GaiaX", "()Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXIExtensionExpression;", "setExtensionExpression$GaiaX", "(Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXIExtensionExpression;)V", "extensionGrid", "Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionGrid;", "getExtensionGrid$GaiaX", "()Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionGrid;", "setExtensionGrid$GaiaX", "(Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionGrid;)V", "extensionLottieAnimation", "Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionLottieAnimation;", "getExtensionLottieAnimation$GaiaX", "()Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionLottieAnimation;", "setExtensionLottieAnimation$GaiaX", "(Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionLottieAnimation;)V", "extensionNodeEvent", "Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionNodeEvent;", "getExtensionNodeEvent$GaiaX", "()Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionNodeEvent;", "setExtensionNodeEvent$GaiaX", "(Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionNodeEvent;)V", "extensionScroll", "Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionScroll;", "getExtensionScroll$GaiaX", "()Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionScroll;", "setExtensionScroll$GaiaX", "(Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionScroll;)V", "extensionSize", "Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXIExtensionSize;", "getExtensionSize$GaiaX", "()Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXIExtensionSize;", "setExtensionSize$GaiaX", "(Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXIExtensionSize;)V", "extensionStaticProperty", "Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXIExtensionStaticProperty;", "getExtensionStaticProperty$GaiaX", "()Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXIExtensionStaticProperty;", "setExtensionStaticProperty$GaiaX", "(Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXIExtensionStaticProperty;)V", "extensionViewClass", "Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXIExtensionViewClass;", "getExtensionViewClass$GaiaX", "()Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXIExtensionViewClass;", "setExtensionViewClass$GaiaX", "(Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXIExtensionViewClass;)V", "imageLoader", "Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXImageLoader;", "getImageLoader$GaiaX", "()Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXImageLoader;", "setImageLoader$GaiaX", "(Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXImageLoader;)V", "monitor", "Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXMonitor;", "getMonitor", "()Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXMonitor;", "setMonitor", "(Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXMonitor;)V", "registerExperiment", "key", "value", "registerExtensionBizMapRelation", "registerExtensionColor", "registerExtensionCompatibility", "registerExtensionContainerDataUpdate", "registerExtensionContainerItemBind", "registerExtensionDataBinding", "databindingExtensionDataBinding", "registerExtensionDynamicProperty", "registerExtensionException", "registerExtensionExpression", "registerExtensionFontFamily", "extensionFontFamily", "Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXIExtensionFontFamily;", "registerExtensionGrid", "registerExtensionLottieAnimation", "registerExtensionNodeEvent", "registerExtensionScroll", "registerExtensionSize", "registerExtensionStaticProperty", "registerExtensionTemplateInfoSource", "source", "Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionTemplateInfoSource;", "priority", "", "registerExtensionTemplateSource", "Lcom/alibaba/gaiax/api/GXRegisterCenterApi$GXIExtensionTemplateSource;", "registerExtensionViewClass", "viewClassConvertor", "registerExtensionViewSupport", "viewType", "viewCreator", "Lkotlin/Function1;", "Landroid/content/Context;", "Landroid/view/View;", "clazz", "Ljava/lang/Class;", "registerGXMonitor", "registerImageLoader", BasicTestActionHandler.TEST_ACTION_RESET, "", "Companion", "GXIExtensionCompatibility", "GXIExtensionContainerDataUpdate", "GXIExtensionContainerItemBind", "GXIExtensionDynamicProperty", "GXIExtensionGrid", "GXIExtensionLottieAnimation", "GXIExtensionNodeEvent", "GXIExtensionScroll", "GXIExtensionTemplateInfoSource", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GXRegisterCenter implements IGXRegisterCenter {
    public static final Companion Companion = null;
    private static final Lazy<GXRegisterCenter> instance$delegate = null;
    private final GXRegisterCenter$defaultExtensionViewClass$1 defaultExtensionViewClass;
    private final GXRegisterCenter$defaultImageLoader$1 defaultImageLoader;
    private Map<String, Object> experimentMap;
    private GXRegisterCenterApi.GXIExtensionBizMap extensionBizMap;
    private GXRegisterCenterApi.GXIExtensionColor extensionColor;
    private GXIExtensionCompatibility extensionCompatibility;
    private GXIExtensionContainerDataUpdate extensionContainerDataUpdate;
    private GXIExtensionContainerItemBind extensionContainerItemBind;
    private GXRegisterCenterApi.GXIExtensionDataBinding extensionDataBinding;
    private GXIExtensionDynamicProperty extensionDynamicProperty;
    private GXRegisterCenterApi.GXIExtensionException extensionException;
    private GXRegisterCenterApi.GXIExtensionExpression extensionExpression;
    private GXIExtensionGrid extensionGrid;
    private GXIExtensionLottieAnimation extensionLottieAnimation;
    private GXIExtensionNodeEvent extensionNodeEvent;
    private GXIExtensionScroll extensionScroll;
    private GXRegisterCenterApi.GXIExtensionSize extensionSize;
    private GXRegisterCenterApi.GXIExtensionStaticProperty extensionStaticProperty;
    private GXRegisterCenterApi.GXIExtensionViewClass extensionViewClass;
    private GXRegisterCenterApi.GXImageLoader imageLoader;
    private GXRegisterCenterApi.GXMonitor monitor;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/alibaba/gaiax/GXRegisterCenter$Companion;", "", "()V", "instance", "Lcom/alibaba/gaiax/GXRegisterCenter;", "getInstance", "()Lcom/alibaba/gaiax/GXRegisterCenter;", "instance$delegate", "Lkotlin/Lazy;", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final GXRegisterCenter getInstance() {
            return (GXRegisterCenter) GXRegisterCenter.access$getInstance$delegate$cp().getValue();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016¨\u0006\n"}, d2 = {"Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionCompatibility;", "", "isCompatibilityContainerDataPassSequence", "", "isCompatibilityContainerNestTemplateJudgementCondition", "isCompatibilityDataBindingFitContent", "isPreventAccessibilityThrowException", "isPreventContainerDataSourceThrowException", "isPreventFitContentThrowException", "isPreventIconFontTypefaceThrowException", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface GXIExtensionCompatibility {

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class DefaultImpls {
            public static boolean isCompatibilityContainerDataPassSequence(GXIExtensionCompatibility r100) {
                return false;
            }

            public static boolean isCompatibilityContainerNestTemplateJudgementCondition(GXIExtensionCompatibility r100) {
                return false;
            }

            public static boolean isCompatibilityDataBindingFitContent(GXIExtensionCompatibility r100) {
                return false;
            }

            public static boolean isPreventAccessibilityThrowException(GXIExtensionCompatibility r100) {
                return false;
            }

            public static boolean isPreventContainerDataSourceThrowException(GXIExtensionCompatibility r100) {
                return false;
            }

            public static boolean isPreventFitContentThrowException(GXIExtensionCompatibility r100) {
                return false;
            }

            public static boolean isPreventIconFontTypefaceThrowException(GXIExtensionCompatibility r100) {
                return false;
            }
        }

        boolean isCompatibilityContainerDataPassSequence();

        boolean isCompatibilityContainerNestTemplateJudgementCondition();

        boolean isCompatibilityDataBindingFitContent();

        boolean isPreventAccessibilityThrowException();

        boolean isPreventContainerDataSourceThrowException();

        boolean isPreventFitContentThrowException();

        boolean isPreventIconFontTypefaceThrowException();
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH&¨\u0006\u000b"}, d2 = {"Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionContainerDataUpdate;", "", "update", "", "gxTemplateContext", "Lcom/alibaba/gaiax/context/GXTemplateContext;", "gxContainerViewAdapter", "Lcom/alibaba/gaiax/render/view/container/GXContainerViewAdapter;", "old", "Lorg/json/JSONArray;", "new", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface GXIExtensionContainerDataUpdate {
        void update(GXTemplateContext r100, GXContainerViewAdapter r101, JSONArray r102, JSONArray r103);
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001JF\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH&¨\u0006\u0010"}, d2 = {"Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionContainerItemBind;", "", "bindViewHolder", "tag", "childItemContainer", "Landroid/view/ViewGroup;", "childMeasureSize", "Lcom/alibaba/gaiax/template/GXMeasureSize;", "childTemplateItem", "Lcom/alibaba/gaiax/template/GXTemplateItem;", "childItemPosition", "", "childVisualNestTemplateNode", "Lcom/alibaba/gaiax/render/node/GXTemplateNode;", "childItemData", "Lorg/json/JSONObject;", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface GXIExtensionContainerItemBind {
        Object bindViewHolder(Object r100, ViewGroup r101, GXMeasureSize r102, GXTemplateItem r103, int r104, GXTemplateNode r105, JSONObject r106);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0005J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H&¨\u0006\u0006"}, d2 = {"Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionDynamicProperty;", "", "convert", "params", "Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionDynamicProperty$GXParams;", "GXParams", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface GXIExtensionDynamicProperty {

        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0002\u0010\u0005J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0001HÆ\u0003J\u001d\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0001HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006%"}, d2 = {"Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionDynamicProperty$GXParams;", "", "propertyName", "", "value", "(Ljava/lang/String;Ljava/lang/Object;)V", "cssStyle", "Lcom/alibaba/gaiax/template/GXStyle;", "getCssStyle", "()Lcom/alibaba/gaiax/template/GXStyle;", "setCssStyle", "(Lcom/alibaba/gaiax/template/GXStyle;)V", "flexBox", "Lcom/alibaba/gaiax/template/GXFlexBox;", "getFlexBox", "()Lcom/alibaba/gaiax/template/GXFlexBox;", "setFlexBox", "(Lcom/alibaba/gaiax/template/GXFlexBox;)V", "gridConfig", "Lcom/alibaba/gaiax/template/GXGridConfig;", "getGridConfig", "()Lcom/alibaba/gaiax/template/GXGridConfig;", "setGridConfig", "(Lcom/alibaba/gaiax/template/GXGridConfig;)V", "getPropertyName", "()Ljava/lang/String;", "getValue", "()Ljava/lang/Object;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class GXParams {
            private GXStyle cssStyle;
            private GXFlexBox flexBox;
            private GXGridConfig gridConfig;
            private final String propertyName;
            private final Object value;

            public static /* synthetic */ GXParams copy$default(GXParams r100, String r101, Object r102, int r103, Object r104) {
                if ((r103 & 1) == 0) goto L6;
                r101 = r100.propertyName;
            L6:
                if ((r103 & 2) == 0) goto L9;
                r102 = r100.value;
            L9:
                return r100.copy(r101, r102);
            }

            public final String component1() {
                return this.propertyName;
            }

            public final Object component2() {
                return this.value;
            }

            public final GXParams copy(String r100, Object r101) {
                Intrinsics.checkNotNullParameter(r100, "propertyName");
                Intrinsics.checkNotNullParameter(r101, "value");
                return new GXParams(r100, r101);
            }

            public boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof GXParams) == true) goto L8;
                return false;
            L8:
                GXParams r101 = (GXParams) r100;
                if (Intrinsics.areEqual(this.propertyName, r101.propertyName) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.value, r101.value) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public int hashCode() {
                return (this.propertyName.hashCode() * 31) + this.value.hashCode();
            }

            public String toString() {
                return "GXParams(propertyName=" + this.propertyName + ", value=" + this.value + ')';
            }

            public final GXStyle getCssStyle() {
                return this.cssStyle;
            }

            public final GXFlexBox getFlexBox() {
                return this.flexBox;
            }

            public final GXGridConfig getGridConfig() {
                return this.gridConfig;
            }

            public final String getPropertyName() {
                return this.propertyName;
            }

            public final Object getValue() {
                return this.value;
            }

            public final void setCssStyle(GXStyle r100) {
                this.cssStyle = r100;
            }

            public final void setFlexBox(GXFlexBox r100) {
                this.flexBox = r100;
            }

            public final void setGridConfig(GXGridConfig r100) {
                this.gridConfig = r100;
            }

            public GXParams(String r100, Object r101) {
                Intrinsics.checkNotNullParameter(r100, "propertyName");
                Intrinsics.checkNotNullParameter(r101, "value");
                this.propertyName = r100;
                this.value = r101;
            }
        }

        Object convert(GXParams r100);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionGrid;", "", "convert", "propertyName", "", "gxTemplateContext", "Lcom/alibaba/gaiax/context/GXTemplateContext;", "gridConfig", "Lcom/alibaba/gaiax/template/GXGridConfig;", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface GXIExtensionGrid {
        Object convert(String r100, GXTemplateContext r101, GXGridConfig r102);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionLottieAnimation;", "", "create", "Lcom/alibaba/gaiax/template/animation/GXLottieAnimation;", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface GXIExtensionLottieAnimation {
        GXLottieAnimation create();
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionNodeEvent;", "", "create", "Lcom/alibaba/gaiax/render/node/GXINodeEvent;", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface GXIExtensionNodeEvent {
        GXINodeEvent create();
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\"\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionScroll;", "", "convert", "propertyName", "", "gxTemplateContext", "Lcom/alibaba/gaiax/context/GXTemplateContext;", "scrollConfig", "Lcom/alibaba/gaiax/template/GXScrollConfig;", "scrollIndex", "", KtvSubElement.CONTAINER, "Lcom/alibaba/gaiax/render/view/container/GXContainer;", GXTemplateKey.GAIAX_EXTEND, "Lorg/json/JSONObject;", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface GXIExtensionScroll {

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class DefaultImpls {
            public static Object convert(GXIExtensionScroll r100, String r101, GXTemplateContext r102, GXScrollConfig r103) {
                Intrinsics.checkNotNullParameter(r101, "propertyName");
                Intrinsics.checkNotNullParameter(r102, "gxTemplateContext");
                Intrinsics.checkNotNullParameter(r103, "scrollConfig");
                return null;
            }

            public static void scrollIndex(GXIExtensionScroll r100, GXTemplateContext r101, GXContainer r102, JSONObject r103) {
                Intrinsics.checkNotNullParameter(r101, "gxTemplateContext");
                Intrinsics.checkNotNullParameter(r102, KtvSubElement.CONTAINER);
            }
        }

        Object convert(String r100, GXTemplateContext r101, GXScrollConfig r102);

        void scrollIndex(GXTemplateContext r100, GXContainer r101, JSONObject r102);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionTemplateInfoSource;", "", "getTemplateInfo", "Lcom/alibaba/gaiax/template/GXTemplateInfo;", "gxTemplateItem", "Lcom/alibaba/gaiax/template/GXTemplateItem;", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface GXIExtensionTemplateInfoSource {
        GXTemplateInfo getTemplateInfo(GXTemplateItem r100);
    }

    @Override // com.alibaba.gaiax.api.IGXRegisterCenter
    public void reset() {
        this.extensionBizMap = null;
        this.extensionDataBinding = null;
        this.extensionColor = null;
        this.extensionSize = null;
        this.extensionDynamicProperty = null;
        this.extensionStaticProperty = null;
        this.extensionScroll = null;
        this.extensionGrid = null;
        this.extensionNodeEvent = null;
        this.extensionCompatibility = null;
        this.extensionExpression = null;
        this.extensionContainerDataUpdate = null;
        this.extensionContainerItemBind = null;
        this.extensionException = null;
    }

    static {
        Companion = new Companion(null);
        instance$delegate = LazyKt.lazy(GXRegisterCenter$Companion$instance$2.INSTANCE);
    }

    public final GXRegisterCenterApi.GXIExtensionViewClass getExtensionViewClass$GaiaX() {
        GXRegisterCenterApi.GXIExtensionViewClass r100 = this.extensionViewClass;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return this.defaultExtensionViewClass;
    }

    public final GXRegisterCenterApi.GXImageLoader getImageLoader$GaiaX() {
        GXRegisterCenterApi.GXImageLoader r100 = this.imageLoader;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return this.defaultImageLoader;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.alibaba.gaiax.GXRegisterCenter$defaultImageLoader$1] */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.alibaba.gaiax.GXRegisterCenter$defaultExtensionViewClass$1] */
    public GXRegisterCenter() {
        this.experimentMap = new LinkedHashMap();
        this.defaultImageLoader = new GXRegisterCenter$defaultImageLoader$1();
        this.defaultExtensionViewClass = new GXRegisterCenter$defaultExtensionViewClass$1();
    }

    public static final /* synthetic */ Lazy access$getInstance$delegate$cp() {
        return instance$delegate;
    }

    public final Map<String, Object> getExperimentMap$GaiaX() {
        return this.experimentMap;
    }

    public final GXRegisterCenterApi.GXIExtensionBizMap getExtensionBizMap$GaiaX() {
        return this.extensionBizMap;
    }

    public final GXRegisterCenterApi.GXIExtensionColor getExtensionColor$GaiaX() {
        return this.extensionColor;
    }

    public final GXIExtensionCompatibility getExtensionCompatibility$GaiaX() {
        return this.extensionCompatibility;
    }

    public final GXIExtensionContainerDataUpdate getExtensionContainerDataUpdate$GaiaX() {
        return this.extensionContainerDataUpdate;
    }

    public final GXIExtensionContainerItemBind getExtensionContainerItemBind$GaiaX() {
        return this.extensionContainerItemBind;
    }

    public final GXRegisterCenterApi.GXIExtensionDataBinding getExtensionDataBinding$GaiaX() {
        return this.extensionDataBinding;
    }

    public final GXIExtensionDynamicProperty getExtensionDynamicProperty$GaiaX() {
        return this.extensionDynamicProperty;
    }

    public final GXRegisterCenterApi.GXIExtensionException getExtensionException$GaiaX() {
        return this.extensionException;
    }

    public final GXRegisterCenterApi.GXIExtensionExpression getExtensionExpression$GaiaX() {
        return this.extensionExpression;
    }

    public final GXIExtensionGrid getExtensionGrid$GaiaX() {
        return this.extensionGrid;
    }

    public final GXIExtensionLottieAnimation getExtensionLottieAnimation$GaiaX() {
        return this.extensionLottieAnimation;
    }

    public final GXIExtensionNodeEvent getExtensionNodeEvent$GaiaX() {
        return this.extensionNodeEvent;
    }

    public final GXIExtensionScroll getExtensionScroll$GaiaX() {
        return this.extensionScroll;
    }

    public final GXRegisterCenterApi.GXIExtensionSize getExtensionSize$GaiaX() {
        return this.extensionSize;
    }

    public final GXRegisterCenterApi.GXIExtensionStaticProperty getExtensionStaticProperty$GaiaX() {
        return this.extensionStaticProperty;
    }

    public final GXRegisterCenterApi.GXMonitor getMonitor() {
        return this.monitor;
    }

    @Override // com.alibaba.gaiax.api.IGXRegisterCenter
    public GXRegisterCenter registerExtensionBizMapRelation(GXRegisterCenterApi.GXIExtensionBizMap r100) {
        Intrinsics.checkNotNullParameter(r100, "extensionBizMap");
        this.extensionBizMap = r100;
        return this;
    }

    @Override // com.alibaba.gaiax.api.IGXRegisterCenter
    public GXRegisterCenter registerExtensionColor(GXRegisterCenterApi.GXIExtensionColor r100) {
        Intrinsics.checkNotNullParameter(r100, "extensionColor");
        this.extensionColor = r100;
        return this;
    }

    public final GXRegisterCenter registerExtensionCompatibility(GXIExtensionCompatibility r100) {
        Intrinsics.checkNotNullParameter(r100, "extensionCompatibility");
        this.extensionCompatibility = r100;
        return this;
    }

    public final GXRegisterCenter registerExtensionContainerDataUpdate(GXIExtensionContainerDataUpdate r100) {
        Intrinsics.checkNotNullParameter(r100, "extensionContainerDataUpdate");
        this.extensionContainerDataUpdate = r100;
        return this;
    }

    public final GXRegisterCenter registerExtensionContainerItemBind(GXIExtensionContainerItemBind r100) {
        Intrinsics.checkNotNullParameter(r100, "extensionContainerItemBind");
        this.extensionContainerItemBind = r100;
        return this;
    }

    @Override // com.alibaba.gaiax.api.IGXRegisterCenter
    public GXRegisterCenter registerExtensionDataBinding(GXRegisterCenterApi.GXIExtensionDataBinding r100) {
        Intrinsics.checkNotNullParameter(r100, "databindingExtensionDataBinding");
        this.extensionDataBinding = r100;
        return this;
    }

    public final GXRegisterCenter registerExtensionDynamicProperty(GXIExtensionDynamicProperty r100) {
        Intrinsics.checkNotNullParameter(r100, "extensionDynamicProperty");
        this.extensionDynamicProperty = r100;
        return this;
    }

    @Override // com.alibaba.gaiax.api.IGXRegisterCenter
    public GXRegisterCenter registerExtensionException(GXRegisterCenterApi.GXIExtensionException r100) {
        Intrinsics.checkNotNullParameter(r100, "extensionException");
        this.extensionException = r100;
        return this;
    }

    @Override // com.alibaba.gaiax.api.IGXRegisterCenter
    public GXRegisterCenter registerExtensionExpression(GXRegisterCenterApi.GXIExtensionExpression r100) {
        Intrinsics.checkNotNullParameter(r100, "extensionExpression");
        this.extensionExpression = r100;
        return this;
    }

    @Override // com.alibaba.gaiax.api.IGXRegisterCenter
    public GXRegisterCenter registerExtensionFontFamily(final GXRegisterCenterApi.GXIExtensionFontFamily r100) {
        Intrinsics.checkNotNullParameter(r100, "extensionFontFamily");
        this.extensionStaticProperty = new AnonymousClass1(r100);
        return this;
    }

    public final GXRegisterCenter registerExtensionGrid(GXIExtensionGrid r100) {
        Intrinsics.checkNotNullParameter(r100, "extensionGrid");
        this.extensionGrid = r100;
        return this;
    }

    public final GXRegisterCenter registerExtensionLottieAnimation(GXIExtensionLottieAnimation r100) {
        Intrinsics.checkNotNullParameter(r100, "extensionLottieAnimation");
        this.extensionLottieAnimation = r100;
        return this;
    }

    public final GXRegisterCenter registerExtensionNodeEvent(GXIExtensionNodeEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "extensionNodeEvent");
        this.extensionNodeEvent = r100;
        return this;
    }

    public final GXRegisterCenter registerExtensionScroll(GXIExtensionScroll r100) {
        Intrinsics.checkNotNullParameter(r100, "extensionScroll");
        this.extensionScroll = r100;
        return this;
    }

    @Override // com.alibaba.gaiax.api.IGXRegisterCenter
    public GXRegisterCenter registerExtensionSize(GXRegisterCenterApi.GXIExtensionSize r100) {
        Intrinsics.checkNotNullParameter(r100, "extensionSize");
        this.extensionSize = r100;
        return this;
    }

    @Override // com.alibaba.gaiax.api.IGXRegisterCenter
    public GXRegisterCenter registerExtensionStaticProperty(GXRegisterCenterApi.GXIExtensionStaticProperty r100) {
        Intrinsics.checkNotNullParameter(r100, "extensionStaticProperty");
        this.extensionStaticProperty = r100;
        return this;
    }

    @Override // com.alibaba.gaiax.api.IGXRegisterCenter
    public GXRegisterCenter registerExtensionViewClass(GXRegisterCenterApi.GXIExtensionViewClass r100) {
        Intrinsics.checkNotNullParameter(r100, "viewClassConvertor");
        this.extensionViewClass = r100;
        return this;
    }

    @Override // com.alibaba.gaiax.api.IGXRegisterCenter
    public GXRegisterCenter registerGXMonitor(GXRegisterCenterApi.GXMonitor r100) {
        Intrinsics.checkNotNullParameter(r100, "monitor");
        this.monitor = r100;
        return this;
    }

    @Override // com.alibaba.gaiax.api.IGXRegisterCenter
    public GXRegisterCenter registerImageLoader(GXRegisterCenterApi.GXImageLoader r100) {
        Intrinsics.checkNotNullParameter(r100, "imageLoader");
        this.imageLoader = r100;
        return this;
    }

    public final void setExperimentMap$GaiaX(Map<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.experimentMap = r100;
    }

    public final void setExtensionBizMap$GaiaX(GXRegisterCenterApi.GXIExtensionBizMap r100) {
        this.extensionBizMap = r100;
    }

    public final void setExtensionColor$GaiaX(GXRegisterCenterApi.GXIExtensionColor r100) {
        this.extensionColor = r100;
    }

    public final void setExtensionCompatibility$GaiaX(GXIExtensionCompatibility r100) {
        this.extensionCompatibility = r100;
    }

    public final void setExtensionContainerDataUpdate$GaiaX(GXIExtensionContainerDataUpdate r100) {
        this.extensionContainerDataUpdate = r100;
    }

    public final void setExtensionContainerItemBind$GaiaX(GXIExtensionContainerItemBind r100) {
        this.extensionContainerItemBind = r100;
    }

    public final void setExtensionDataBinding$GaiaX(GXRegisterCenterApi.GXIExtensionDataBinding r100) {
        this.extensionDataBinding = r100;
    }

    public final void setExtensionDynamicProperty$GaiaX(GXIExtensionDynamicProperty r100) {
        this.extensionDynamicProperty = r100;
    }

    public final void setExtensionException$GaiaX(GXRegisterCenterApi.GXIExtensionException r100) {
        this.extensionException = r100;
    }

    public final void setExtensionExpression$GaiaX(GXRegisterCenterApi.GXIExtensionExpression r100) {
        this.extensionExpression = r100;
    }

    public final void setExtensionGrid$GaiaX(GXIExtensionGrid r100) {
        this.extensionGrid = r100;
    }

    public final void setExtensionLottieAnimation$GaiaX(GXIExtensionLottieAnimation r100) {
        this.extensionLottieAnimation = r100;
    }

    public final void setExtensionNodeEvent$GaiaX(GXIExtensionNodeEvent r100) {
        this.extensionNodeEvent = r100;
    }

    public final void setExtensionScroll$GaiaX(GXIExtensionScroll r100) {
        this.extensionScroll = r100;
    }

    public final void setExtensionSize$GaiaX(GXRegisterCenterApi.GXIExtensionSize r100) {
        this.extensionSize = r100;
    }

    public final void setExtensionStaticProperty$GaiaX(GXRegisterCenterApi.GXIExtensionStaticProperty r100) {
        this.extensionStaticProperty = r100;
    }

    public final void setExtensionViewClass$GaiaX(GXRegisterCenterApi.GXIExtensionViewClass r100) {
        this.extensionViewClass = r100;
    }

    public final void setImageLoader$GaiaX(GXRegisterCenterApi.GXImageLoader r100) {
        this.imageLoader = r100;
    }

    public final void setMonitor(GXRegisterCenterApi.GXMonitor r100) {
        this.monitor = r100;
    }

    @Override // com.alibaba.gaiax.api.IGXRegisterCenter
    public /* bridge */ /* synthetic */ IGXRegisterCenter registerExtensionBizMapRelation(GXRegisterCenterApi.GXIExtensionBizMap r100) {
        return registerExtensionBizMapRelation(r100);
    }

    @Override // com.alibaba.gaiax.api.IGXRegisterCenter
    public /* bridge */ /* synthetic */ IGXRegisterCenter registerExtensionColor(GXRegisterCenterApi.GXIExtensionColor r100) {
        return registerExtensionColor(r100);
    }

    @Override // com.alibaba.gaiax.api.IGXRegisterCenter
    public /* bridge */ /* synthetic */ IGXRegisterCenter registerExtensionDataBinding(GXRegisterCenterApi.GXIExtensionDataBinding r100) {
        return registerExtensionDataBinding(r100);
    }

    @Override // com.alibaba.gaiax.api.IGXRegisterCenter
    public /* bridge */ /* synthetic */ IGXRegisterCenter registerExtensionException(GXRegisterCenterApi.GXIExtensionException r100) {
        return registerExtensionException(r100);
    }

    @Override // com.alibaba.gaiax.api.IGXRegisterCenter
    public /* bridge */ /* synthetic */ IGXRegisterCenter registerExtensionExpression(GXRegisterCenterApi.GXIExtensionExpression r100) {
        return registerExtensionExpression(r100);
    }

    @Override // com.alibaba.gaiax.api.IGXRegisterCenter
    public /* bridge */ /* synthetic */ IGXRegisterCenter registerExtensionFontFamily(GXRegisterCenterApi.GXIExtensionFontFamily r100) {
        return registerExtensionFontFamily(r100);
    }

    @Override // com.alibaba.gaiax.api.IGXRegisterCenter
    public /* bridge */ /* synthetic */ IGXRegisterCenter registerExtensionSize(GXRegisterCenterApi.GXIExtensionSize r100) {
        return registerExtensionSize(r100);
    }

    @Override // com.alibaba.gaiax.api.IGXRegisterCenter
    public /* bridge */ /* synthetic */ IGXRegisterCenter registerExtensionStaticProperty(GXRegisterCenterApi.GXIExtensionStaticProperty r100) {
        return registerExtensionStaticProperty(r100);
    }

    @Override // com.alibaba.gaiax.api.IGXRegisterCenter
    public /* bridge */ /* synthetic */ IGXRegisterCenter registerExtensionViewClass(GXRegisterCenterApi.GXIExtensionViewClass r100) {
        return registerExtensionViewClass(r100);
    }

    @Override // com.alibaba.gaiax.api.IGXRegisterCenter
    public /* bridge */ /* synthetic */ IGXRegisterCenter registerGXMonitor(GXRegisterCenterApi.GXMonitor r100) {
        return registerGXMonitor(r100);
    }

    @Override // com.alibaba.gaiax.api.IGXRegisterCenter
    public /* bridge */ /* synthetic */ IGXRegisterCenter registerImageLoader(GXRegisterCenterApi.GXImageLoader r100) {
        return registerImageLoader(r100);
    }

    @Override // com.alibaba.gaiax.api.IGXRegisterCenter
    public IGXRegisterCenter registerExperiment(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.experimentMap.put(r100, r101);
        return this;
    }

    public final GXRegisterCenter registerExtensionTemplateInfoSource(GXIExtensionTemplateInfoSource r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        GXTemplateEngine.Companion.getInstance().getData$GaiaX().getTemplateInfoSource().registerByPriority(r100, r101);
        return this;
    }

    @Override // com.alibaba.gaiax.api.IGXRegisterCenter
    public GXRegisterCenter registerExtensionTemplateSource(GXRegisterCenterApi.GXIExtensionTemplateSource r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        GXTemplateEngine.Companion.getInstance().getData$GaiaX().getTemplateSource().registerByPriority(r100, r101);
        return this;
    }

    @Override // com.alibaba.gaiax.api.IGXRegisterCenter
    public GXRegisterCenter registerExtensionViewSupport(String r100, Function1<? super Context, ? extends View> r101) {
        Intrinsics.checkNotNullParameter(r100, "viewType");
        Intrinsics.checkNotNullParameter(r101, "viewCreator");
        GXViewFactory.INSTANCE.getViewCreatorSupport$GaiaX().put(r100, r101);
        return this;
    }

    @Override // com.alibaba.gaiax.api.IGXRegisterCenter
    public /* bridge */ /* synthetic */ IGXRegisterCenter registerExtensionTemplateSource(GXRegisterCenterApi.GXIExtensionTemplateSource r100, int r101) {
        return registerExtensionTemplateSource(r100, r101);
    }

    @Override // com.alibaba.gaiax.api.IGXRegisterCenter
    public GXRegisterCenter registerExtensionViewSupport(String r100, Class<?> r101) {
        Intrinsics.checkNotNullParameter(r100, "viewType");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        GXViewFactory.INSTANCE.getViewSupport$GaiaX().put(r100, r101);
        return this;
    }

    @Override // com.alibaba.gaiax.api.IGXRegisterCenter
    public /* bridge */ /* synthetic */ IGXRegisterCenter registerExtensionViewSupport(String r100, Class r101) {
        return registerExtensionViewSupport(r100, r101);
    }

    @Override // com.alibaba.gaiax.api.IGXRegisterCenter
    public /* bridge */ /* synthetic */ IGXRegisterCenter registerExtensionViewSupport(String r100, Function1 r101) {
        return registerExtensionViewSupport(r100, r101);
    }
}

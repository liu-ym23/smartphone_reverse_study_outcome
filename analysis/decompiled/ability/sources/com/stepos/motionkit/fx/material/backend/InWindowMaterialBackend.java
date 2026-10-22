package com.stepos.motionkit.fx.material.backend;

import B7.a;
import C7.r;
import D6.m;
import D7.v;
import I4.l;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.util.Log;
import android.view.Display;
import android.view.View;
import androidx.autofill.HintConstants;
import androidx.compose.ui.text.d;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;
import stepos.view.effects.StepOSGlassMaterial;

@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\bÀ\u0002\u0018\u00002\u00020\u0001:\u0003XYZB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0013\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0013\u0010\u0014JU\u0010\u001d\u001a\u00020\b2\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u00152\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u00182\u0010\u0010\u001b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u001a2\u0016\u0010\u001c\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u001a\"\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010!\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\rH\u0002¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020#2\u0006\u0010\f\u001a\u00020\rH\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020#2\u0006\u0010\f\u001a\u00020\rH\u0002¢\u0006\u0004\b&\u0010%J\u0017\u0010'\u001a\u00020#2\u0006\u0010\f\u001a\u00020\rH\u0002¢\u0006\u0004\b'\u0010%J\u0017\u0010(\u001a\u00020#2\u0006\u0010\f\u001a\u00020\rH\u0002¢\u0006\u0004\b(\u0010%J!\u0010,\u001a\u00028\u0000\"\u0004\b\u0000\u0010)2\f\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000*¢\u0006\u0004\b,\u0010-J\u0017\u0010/\u001a\u0004\u0018\u00010.2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b/\u00100J\u001d\u00102\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u00101\u001a\u00020#¢\u0006\u0004\b2\u00103J\u001d\u00105\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u00104\u001a\u00020#¢\u0006\u0004\b5\u00103R\u0014\u00106\u001a\u00020\u00188\u0002X\u0082T¢\u0006\u0006\n\u0004\b6\u00107R\u0014\u00108\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010:\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\b:\u00109R\u0014\u0010;\u001a\u00020\u00188\u0002X\u0082T¢\u0006\u0006\n\u0004\b;\u00107R\u0014\u0010=\u001a\u00020<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u001a\u0010?\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u001a\u0010A\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010@R\u0016\u0010C\u001a\u0004\u0018\u00010B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010E\u001a\u0004\u0018\u00010B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010DR \u0010G\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010I\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u00109R\u001a\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00060J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR4\u0010O\u001a\"\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010B0Mj\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010B`N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0018\u00109\u001a\u0006\u0012\u0002\b\u00030\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010@R\u0018\u0010Q\u001a\u0006\u0012\u0002\b\u00030\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010@R\u0018\u0010R\u001a\u0006\u0012\u0002\b\u00030\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010@R\u0018\u0010S\u001a\u0006\u0012\u0002\b\u00030\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010@R\u0014\u0010V\u001a\u00020<8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bT\u0010UR\u0011\u0010W\u001a\u00020<8F¢\u0006\u0006\u001a\u0004\bW\u0010U¨\u0006["}, d2 = {"Lcom/stepos/motionkit/fx/material/backend/InWindowMaterialBackend;", "", AppAgent.CONSTRUCT, "()V", "Landroid/view/View;", "view", "Lcom/stepos/motionkit/fx/material/backend/InWindowMaterialBackend$Holder;", "h", "LC7/r;", "releaseHolder", "(Landroid/view/View;Lcom/stepos/motionkit/fx/material/backend/InWindowMaterialBackend$Holder;)V", "Lcom/stepos/motionkit/fx/material/backend/InWindowMaterialBackend$Config;", "c", "", "effCgMode", "buildMaterial", "(Lcom/stepos/motionkit/fx/material/backend/InWindowMaterialBackend$Config;I)Ljava/lang/Object;", "Landroid/graphics/RenderEffect;", "blur", "buildGlassEffectSdk", "(Lcom/stepos/motionkit/fx/material/backend/InWindowMaterialBackend$Config;Landroid/graphics/RenderEffect;I)Landroid/graphics/RenderEffect;", "Ljava/lang/Class;", "cls", TypedValues.AttributesType.S_TARGET, "", HintConstants.AUTOFILL_HINT_NAME, "", "types", "args", "call", "(Ljava/lang/Class;Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)V", "mode", Key.ROTATION, "rotateModeForDisplay", "(II)I", "", "alpha", "(I)F", "red", "green", "blue", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function0;", "body", "batch", "(LS7/a;)Ljava/lang/Object;", "Lcom/stepos/motionkit/fx/material/backend/InWindowMaterialBackend$Token;", "acquire", "(Landroid/view/View;)Lcom/stepos/motionkit/fx/material/backend/InWindowMaterialBackend$Token;", "px", "setCornerRadius", "(Landroid/view/View;F)V", "v", "setCornerSmoothness", "TAG", "Ljava/lang/String;", "BLEND_DODGE", "I", "BLEND_OVERLAY", "SDK_CLASS", "", "sdkAvailable", "Z", "builderClass", "Ljava/lang/Class;", "materialParamsClass", "Ljava/lang/reflect/Method;", "createGlassEffect", "Ljava/lang/reflect/Method;", "createStepOSBlurEffect", "Ljava/util/WeakHashMap;", "holders", "Ljava/util/WeakHashMap;", "batchDepth", "", "dirtyHolders", "Ljava/util/Set;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "methodCache", "Ljava/util/HashMap;", "F", "B", "IA", "getReflectAvailable", "()Z", "reflectAvailable", "isAvailable", "Config", "Token", "Holder", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InWindowMaterialBackend {
    private static final Class<?> B;
    public static final int BLEND_DODGE = 2;
    public static final int BLEND_OVERLAY = 3;
    private static final Class<?> F;
    private static final Class<?> I;
    private static final Class<?> IA;
    public static final InWindowMaterialBackend INSTANCE;
    private static final String SDK_CLASS = "stepos.view.effects.StepOSGlassMaterial";
    private static final String TAG = "MotionKitInWindowMaterial";
    private static int batchDepth;
    private static final Class<?> builderClass;
    private static final Method createGlassEffect;
    private static final Method createStepOSBlurEffect;
    private static final Set<Holder> dirtyHolders;
    private static final WeakHashMap<View, Holder> holders;
    private static final Class<?> materialParamsClass;
    private static final HashMap<String, Method> methodCache;
    private static final boolean sdkAvailable;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\bX\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001a\u0010\u0019\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR\u001a\u0010\u001c\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR,\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110!0 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0013\"\u0004\b(\u0010\u0015R\u001a\u0010)\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0007\"\u0004\b+\u0010\tR\u001a\u0010,\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0013\"\u0004\b.\u0010\u0015R\u001a\u0010/\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0013\"\u0004\b1\u0010\u0015R\u001a\u00102\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0013\"\u0004\b4\u0010\u0015R\u001a\u00105\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0007\"\u0004\b7\u0010\tR\u001a\u00108\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0013\"\u0004\b:\u0010\u0015R\u001a\u0010;\u001a\u00020<X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001a\u0010A\u001a\u00020<X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010>\"\u0004\bC\u0010@R\u001a\u0010D\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u0007\"\u0004\bF\u0010\tR\u001a\u0010G\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0007\"\u0004\bI\u0010\tR\u001a\u0010J\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u0007\"\u0004\bL\u0010\tR\u001a\u0010M\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u0007\"\u0004\bO\u0010\tR\u001a\u0010P\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u0013\"\u0004\bR\u0010\u0015R\u001a\u0010S\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\u0007\"\u0004\bU\u0010\tR\u001a\u0010V\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\u0007\"\u0004\bX\u0010\tR\u001a\u0010Y\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\u0007\"\u0004\b[\u0010\tR\u001a\u0010\\\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010\u0007\"\u0004\b^\u0010\tR\u001a\u0010_\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\u0007\"\u0004\ba\u0010\tR\u001a\u0010b\u001a\u00020<X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010>\"\u0004\bd\u0010@R\u001a\u0010e\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010\u0013\"\u0004\bg\u0010\u0015R\u001a\u0010h\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010\u0013\"\u0004\bj\u0010\u0015R\u001a\u0010k\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010\u0007\"\u0004\bm\u0010\tR\u001a\u0010n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010\u0007\"\u0004\bp\u0010\tR\u001a\u0010q\u001a\u00020<X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010>\"\u0004\bs\u0010@R\u001a\u0010t\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010\u0013\"\u0004\bv\u0010\u0015R\u001a\u0010w\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010\u0007\"\u0004\by\u0010\tR\u001a\u0010z\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010\u0007\"\u0004\b|\u0010\tR\u001a\u0010}\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u0010\u0007\"\u0004\b\u007f\u0010\tR\u001d\u0010\u0080\u0001\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0001\u0010\u0007\"\u0005\b\u0082\u0001\u0010\tR\u001d\u0010\u0083\u0001\u001a\u00020<X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0084\u0001\u0010>\"\u0005\b\u0085\u0001\u0010@R\u001d\u0010\u0086\u0001\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0087\u0001\u0010\u0007\"\u0005\b\u0088\u0001\u0010\tR\u001d\u0010\u0089\u0001\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008a\u0001\u0010\u0007\"\u0005\b\u008b\u0001\u0010\tR\u001d\u0010\u008c\u0001\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008d\u0001\u0010\u0007\"\u0005\b\u008e\u0001\u0010\tR\u001d\u0010\u008f\u0001\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0090\u0001\u0010\u0007\"\u0005\b\u0091\u0001\u0010\tR\u0013\u0010\u0092\u0001\u001a\u00020<8F¢\u0006\u0007\u001a\u0005\b\u0093\u0001\u0010>¨\u0006\u0094\u0001"}, d2 = {"Lcom/stepos/motionkit/fx/material/backend/InWindowMaterialBackend$Config;", "", AppAgent.CONSTRUCT, "()V", "radius", "", "getRadius", "()F", "setRadius", "(F)V", "cornerRadius", "getCornerRadius", "setCornerRadius", "cornerSmoothness", "getCornerSmoothness", "setCornerSmoothness", "tintColor", "", "getTintColor", "()I", "setTintColor", "(I)V", "blendMode", "getBlendMode", "setBlendMode", "blendColor", "getBlendColor", "setBlendColor", "frost", "getFrost", "setFrost", "blendStages", "", "Lkotlin/Pair;", "getBlendStages", "()Ljava/util/List;", "setBlendStages", "(Ljava/util/List;)V", "blurMode", "getBlurMode", "setBlurMode", "blurScale", "getBlurScale", "setBlurScale", "cgStart", "getCgStart", "setCgStart", "cgMiddle", "getCgMiddle", "setCgMiddle", "cgEnd", "getCgEnd", "setCgEnd", "cgMidpoint", "getCgMidpoint", "setCgMidpoint", "cgMode", "getCgMode", "setCgMode", "useAospBlur", "", "getUseAospBlur", "()Z", "setUseAospBlur", "(Z)V", "strokeEnabled", "getStrokeEnabled", "setStrokeEnabled", "strokeWidth", "getStrokeWidth", "setStrokeWidth", "strokeSoftness", "getStrokeSoftness", "setStrokeSoftness", "strokeIntensity", "getStrokeIntensity", "setStrokeIntensity", "strokeSpread", "getStrokeSpread", "setStrokeSpread", "strokeColor", "getStrokeColor", "setStrokeColor", "light0X", "getLight0X", "setLight0X", "light0Y", "getLight0Y", "setLight0Y", "light1X", "getLight1X", "setLight1X", "light1Y", "getLight1Y", "setLight1Y", "ambient", "getAmbient", "setAmbient", "anisoRim", "getAnisoRim", "setAnisoRim", "edgeColor", "getEdgeColor", "setEdgeColor", "darkColor", "getDarkColor", "setDarkColor", "darkWidth", "getDarkWidth", "setDarkWidth", "edgeWidth", "getEdgeWidth", "setEdgeWidth", "innerEnabled", "getInnerEnabled", "setInnerEnabled", "innerColor", "getInnerColor", "setInnerColor", "innerRadius", "getInnerRadius", "setInnerRadius", "innerOffsetX", "getInnerOffsetX", "setInnerOffsetX", "innerOffsetY", "getInnerOffsetY", "setInnerOffsetY", "innerIntensity", "getInnerIntensity", "setInnerIntensity", "refractEnabled", "getRefractEnabled", "setRefractEnabled", "refractStrength", "getRefractStrength", "setRefractStrength", "refractWidth", "getRefractWidth", "setRefractWidth", "dispersion", "getDispersion", "setDispersion", "depthEffect", "getDepthEffect", "setDepthEffect", "anyGlass", "getAnyGlass", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Config {
        private float ambient;
        private boolean anisoRim;
        private int blurMode;
        private float blurScale;
        private int cgEnd;
        private int cgMiddle;
        private int cgMode;
        private int cgStart;
        private float cornerRadius;
        private float cornerSmoothness;
        private float dispersion;
        private float frost;
        private boolean innerEnabled;
        private float innerOffsetX;
        private float innerOffsetY;
        private float light0X;
        private float light1X;
        private float radius;
        private boolean refractEnabled;
        private boolean strokeEnabled;
        private boolean useAospBlur;
        private int tintColor = ViewCompat.MEASURED_SIZE_MASK;
        private int blendMode = 2;
        private float blendColor = 0.1f;
        private List<Pair<Integer, Integer>> blendStages = EmptyList.f4893a;
        private float cgMidpoint = 0.5f;
        private float strokeWidth = 2.0f;
        private float strokeSoftness = 2.0f;
        private float strokeIntensity = 1.0f;
        private float strokeSpread = 2.0f;
        private int strokeColor = -1;
        private float light0Y = -1.0f;
        private float light1Y = 1.0f;
        private int edgeColor = -3355444;
        private int darkColor = -3092272;
        private float darkWidth = 1.0f;
        private float edgeWidth = 1.0f;
        private int innerColor = 1711276032;
        private float innerRadius = 14.0f;
        private float innerIntensity = 1.0f;
        private float refractStrength = 20.0f;
        private float refractWidth = 40.0f;
        private float depthEffect = 0.4f;

        public final float getAmbient() {
            return this.ambient;
        }

        public final boolean getAnisoRim() {
            return this.anisoRim;
        }

        public final boolean getAnyGlass() {
            return this.strokeEnabled || this.innerEnabled || this.refractEnabled || this.dispersion > 0.0f || this.cgMode != 0;
        }

        public final float getBlendColor() {
            return this.blendColor;
        }

        public final int getBlendMode() {
            return this.blendMode;
        }

        public final List<Pair<Integer, Integer>> getBlendStages() {
            return this.blendStages;
        }

        public final int getBlurMode() {
            return this.blurMode;
        }

        public final float getBlurScale() {
            return this.blurScale;
        }

        public final int getCgEnd() {
            return this.cgEnd;
        }

        public final int getCgMiddle() {
            return this.cgMiddle;
        }

        public final float getCgMidpoint() {
            return this.cgMidpoint;
        }

        public final int getCgMode() {
            return this.cgMode;
        }

        public final int getCgStart() {
            return this.cgStart;
        }

        public final float getCornerRadius() {
            return this.cornerRadius;
        }

        public final float getCornerSmoothness() {
            return this.cornerSmoothness;
        }

        public final int getDarkColor() {
            return this.darkColor;
        }

        public final float getDarkWidth() {
            return this.darkWidth;
        }

        public final float getDepthEffect() {
            return this.depthEffect;
        }

        public final float getDispersion() {
            return this.dispersion;
        }

        public final int getEdgeColor() {
            return this.edgeColor;
        }

        public final float getEdgeWidth() {
            return this.edgeWidth;
        }

        public final float getFrost() {
            return this.frost;
        }

        public final int getInnerColor() {
            return this.innerColor;
        }

        public final boolean getInnerEnabled() {
            return this.innerEnabled;
        }

        public final float getInnerIntensity() {
            return this.innerIntensity;
        }

        public final float getInnerOffsetX() {
            return this.innerOffsetX;
        }

        public final float getInnerOffsetY() {
            return this.innerOffsetY;
        }

        public final float getInnerRadius() {
            return this.innerRadius;
        }

        public final float getLight0X() {
            return this.light0X;
        }

        public final float getLight0Y() {
            return this.light0Y;
        }

        public final float getLight1X() {
            return this.light1X;
        }

        public final float getLight1Y() {
            return this.light1Y;
        }

        public final float getRadius() {
            return this.radius;
        }

        public final boolean getRefractEnabled() {
            return this.refractEnabled;
        }

        public final float getRefractStrength() {
            return this.refractStrength;
        }

        public final float getRefractWidth() {
            return this.refractWidth;
        }

        public final int getStrokeColor() {
            return this.strokeColor;
        }

        public final boolean getStrokeEnabled() {
            return this.strokeEnabled;
        }

        public final float getStrokeIntensity() {
            return this.strokeIntensity;
        }

        public final float getStrokeSoftness() {
            return this.strokeSoftness;
        }

        public final float getStrokeSpread() {
            return this.strokeSpread;
        }

        public final float getStrokeWidth() {
            return this.strokeWidth;
        }

        public final int getTintColor() {
            return this.tintColor;
        }

        public final boolean getUseAospBlur() {
            return this.useAospBlur;
        }

        public final void setAmbient(float f) {
            this.ambient = f;
        }

        public final void setAnisoRim(boolean z10) {
            this.anisoRim = z10;
        }

        public final void setBlendColor(float f) {
            this.blendColor = f;
        }

        public final void setBlendMode(int i) {
            this.blendMode = i;
        }

        public final void setBlendStages(List<Pair<Integer, Integer>> list) {
            k.f(list, "<set-?>");
            this.blendStages = list;
        }

        public final void setBlurMode(int i) {
            this.blurMode = i;
        }

        public final void setBlurScale(float f) {
            this.blurScale = f;
        }

        public final void setCgEnd(int i) {
            this.cgEnd = i;
        }

        public final void setCgMiddle(int i) {
            this.cgMiddle = i;
        }

        public final void setCgMidpoint(float f) {
            this.cgMidpoint = f;
        }

        public final void setCgMode(int i) {
            this.cgMode = i;
        }

        public final void setCgStart(int i) {
            this.cgStart = i;
        }

        public final void setCornerRadius(float f) {
            this.cornerRadius = f;
        }

        public final void setCornerSmoothness(float f) {
            this.cornerSmoothness = f;
        }

        public final void setDarkColor(int i) {
            this.darkColor = i;
        }

        public final void setDarkWidth(float f) {
            this.darkWidth = f;
        }

        public final void setDepthEffect(float f) {
            this.depthEffect = f;
        }

        public final void setDispersion(float f) {
            this.dispersion = f;
        }

        public final void setEdgeColor(int i) {
            this.edgeColor = i;
        }

        public final void setEdgeWidth(float f) {
            this.edgeWidth = f;
        }

        public final void setFrost(float f) {
            this.frost = f;
        }

        public final void setInnerColor(int i) {
            this.innerColor = i;
        }

        public final void setInnerEnabled(boolean z10) {
            this.innerEnabled = z10;
        }

        public final void setInnerIntensity(float f) {
            this.innerIntensity = f;
        }

        public final void setInnerOffsetX(float f) {
            this.innerOffsetX = f;
        }

        public final void setInnerOffsetY(float f) {
            this.innerOffsetY = f;
        }

        public final void setInnerRadius(float f) {
            this.innerRadius = f;
        }

        public final void setLight0X(float f) {
            this.light0X = f;
        }

        public final void setLight0Y(float f) {
            this.light0Y = f;
        }

        public final void setLight1X(float f) {
            this.light1X = f;
        }

        public final void setLight1Y(float f) {
            this.light1Y = f;
        }

        public final void setRadius(float f) {
            this.radius = f;
        }

        public final void setRefractEnabled(boolean z10) {
            this.refractEnabled = z10;
        }

        public final void setRefractStrength(float f) {
            this.refractStrength = f;
        }

        public final void setRefractWidth(float f) {
            this.refractWidth = f;
        }

        public final void setStrokeColor(int i) {
            this.strokeColor = i;
        }

        public final void setStrokeEnabled(boolean z10) {
            this.strokeEnabled = z10;
        }

        public final void setStrokeIntensity(float f) {
            this.strokeIntensity = f;
        }

        public final void setStrokeSoftness(float f) {
            this.strokeSoftness = f;
        }

        public final void setStrokeSpread(float f) {
            this.strokeSpread = f;
        }

        public final void setStrokeWidth(float f) {
            this.strokeWidth = f;
        }

        public final void setTintColor(int i) {
            this.tintColor = i;
        }

        public final void setUseAospBlur(boolean z10) {
            this.useAospBlur = z10;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000e\u001a\u00020\b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b0\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\u0011R\"\u0010\u0015\u001a\u0010\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00020\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/stepos/motionkit/fx/material/backend/InWindowMaterialBackend$Holder;", "", "Landroid/view/View;", "view", AppAgent.CONSTRUCT, "(Landroid/view/View;)V", "Landroid/graphics/RenderEffect;", "effect", "LC7/r;", "applyEffect", "(Landroid/view/View;Landroid/graphics/RenderEffect;)V", "Lkotlin/Function1;", "Lcom/stepos/motionkit/fx/material/backend/InWindowMaterialBackend$Config;", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "config", "(LS7/k;)V", "rebuild", "()V", "clear", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "viewRef", "Ljava/lang/ref/WeakReference;", "", "refCount", "I", "getRefCount", "()I", "setRefCount", "(I)V", "cfg", "Lcom/stepos/motionkit/fx/material/backend/InWindowMaterialBackend$Config;", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Holder {
        private final Config cfg;
        private int refCount;
        private final WeakReference<View> viewRef;

        public Holder(View view) {
            k.f(view, "view");
            this.viewRef = new WeakReference<>(view);
            this.cfg = new Config();
        }

        private final void applyEffect(View view, RenderEffect effect) {
            BackdropRenderEffectAccess.INSTANCE.set(view, effect);
            Object parent = view.getParent();
            View view2 = parent instanceof View ? (View) parent : null;
            if (view2 != null) {
                view2.invalidate();
            }
        }

        public final void clear() {
            View view = this.viewRef.get();
            if (view == null) {
                return;
            }
            BackdropRenderEffectAccess.INSTANCE.set(view, null);
        }

        public final void config(S7.k action) {
            k.f(action, "action");
            action.invoke(this.cfg);
            if (InWindowMaterialBackend.batchDepth > 0) {
                InWindowMaterialBackend.dirtyHolders.add(this);
            } else {
                rebuild();
            }
        }

        public final int getRefCount() {
            return this.refCount;
        }

        public final void rebuild() {
            RenderEffect renderEffectCreateStepOSBlurEffect;
            RenderEffect renderEffectCreateBlurEffect;
            View view = this.viewRef.get();
            if (view == null) {
                return;
            }
            try {
                if (this.cfg.getRadius() <= 0.0f && !this.cfg.getAnyGlass()) {
                    Log.d(InWindowMaterialBackend.TAG, "rebuild: radius<=0 且无玻璃 → clear effect");
                    applyEffect(view, null);
                    return;
                }
                float radius = this.cfg.getRadius() > 0.0f ? this.cfg.getRadius() : 0.1f;
                boolean z10 = true;
                boolean z11 = InWindowMaterialBackend.sdkAvailable || InWindowMaterialBackend.createStepOSBlurEffect != null;
                if ((this.cfg.getBlurMode() != 0 || !this.cfg.getUseAospBlur()) && z11) {
                    z10 = false;
                }
                Display display = view.getDisplay();
                int rotation = display != null ? display.getRotation() : 0;
                if (z10) {
                    renderEffectCreateBlurEffect = RenderEffect.createBlurEffect(radius, radius, Shader.TileMode.CLAMP);
                    k.c(renderEffectCreateBlurEffect);
                } else {
                    int iRotateModeForDisplay = InWindowMaterialBackend.INSTANCE.rotateModeForDisplay(this.cfg.getBlurMode(), rotation);
                    if (InWindowMaterialBackend.sdkAvailable) {
                        renderEffectCreateStepOSBlurEffect = StepOSGlassMaterial.createStepOSBlurEffect(radius, iRotateModeForDisplay, this.cfg.getBlurScale());
                    } else {
                        Method method = InWindowMaterialBackend.createStepOSBlurEffect;
                        k.c(method);
                        Object objInvoke = method.invoke(null, Float.valueOf(radius), Integer.valueOf(iRotateModeForDisplay), Float.valueOf(this.cfg.getBlurScale()));
                        renderEffectCreateStepOSBlurEffect = objInvoke instanceof RenderEffect ? (RenderEffect) objInvoke : null;
                    }
                    if (renderEffectCreateStepOSBlurEffect == null) {
                        renderEffectCreateBlurEffect = RenderEffect.createBlurEffect(radius, radius, Shader.TileMode.CLAMP);
                        k.e(renderEffectCreateBlurEffect, "createBlurEffect(...)");
                    } else {
                        renderEffectCreateBlurEffect = renderEffectCreateStepOSBlurEffect;
                    }
                }
                InWindowMaterialBackend inWindowMaterialBackend = InWindowMaterialBackend.INSTANCE;
                int iRotateModeForDisplay2 = inWindowMaterialBackend.rotateModeForDisplay(this.cfg.getCgMode(), rotation);
                if (this.cfg.getAnyGlass()) {
                    if (InWindowMaterialBackend.sdkAvailable) {
                        renderEffectCreateBlurEffect = inWindowMaterialBackend.buildGlassEffectSdk(this.cfg, renderEffectCreateBlurEffect, iRotateModeForDisplay2);
                    } else {
                        Object objBuildMaterial = inWindowMaterialBackend.buildMaterial(this.cfg, iRotateModeForDisplay2);
                        if (objBuildMaterial != null) {
                            Method method2 = InWindowMaterialBackend.createGlassEffect;
                            k.c(method2);
                            Object objInvoke2 = method2.invoke(null, objBuildMaterial, Integer.valueOf(this.cfg.getTintColor()), renderEffectCreateBlurEffect);
                            k.d(objInvoke2, "null cannot be cast to non-null type android.graphics.RenderEffect");
                            renderEffectCreateBlurEffect = (RenderEffect) objInvoke2;
                        }
                    }
                }
                Log.d(InWindowMaterialBackend.TAG, "rebuild: r=" + this.cfg.getRadius() + " anyGlass=" + this.cfg.getAnyGlass() + " stroke=" + this.cfg.getStrokeEnabled() + " inner=" + this.cfg.getInnerEnabled() + " refract=" + this.cfg.getRefractEnabled() + " effect=" + System.identityHashCode(renderEffectCreateBlurEffect) + " view=" + System.identityHashCode(view));
                applyEffect(view, renderEffectCreateBlurEffect);
            } catch (Throwable th) {
                th = th;
                Throwable cause = th.getCause();
                if (cause != null) {
                    th = cause;
                }
                Log.e(InWindowMaterialBackend.TAG, a.n("rebuild failed: ", th.getClass().getSimpleName(), ": ", th.getMessage()), th);
            }
        }

        public final void setRefCount(int i) {
            this.refCount = i;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\f\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0004\b\f\u0010\rJ#\u0010\u000f\u001a\u00020\n2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0004\b\u000f\u0010\rR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0010R\"\u0010\u0013\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00020\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/stepos/motionkit/fx/material/backend/InWindowMaterialBackend$Token;", "", "Landroid/view/View;", "view", "Lcom/stepos/motionkit/fx/material/backend/InWindowMaterialBackend$Holder;", "h", AppAgent.CONSTRUCT, "(Landroid/view/View;Lcom/stepos/motionkit/fx/material/backend/InWindowMaterialBackend$Holder;)V", "Lkotlin/Function1;", "Lcom/stepos/motionkit/fx/material/backend/InWindowMaterialBackend$Config;", "LC7/r;", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "config", "(LS7/k;)V", "reset", "release", "Lcom/stepos/motionkit/fx/material/backend/InWindowMaterialBackend$Holder;", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "viewRef", "Ljava/lang/ref/WeakReference;", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Token {
        private final Holder h;
        private final WeakReference<View> viewRef;

        public Token(View view, Holder h) {
            k.f(view, "view");
            k.f(h, "h");
            this.h = h;
            this.viewRef = new WeakReference<>(view);
        }

        public static /* synthetic */ void release$default(Token token, S7.k kVar, int i, Object obj) {
            if ((i & 1) != 0) {
                kVar = new d(27);
            }
            token.release(kVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final r release$lambda$0(Config it) {
            k.f(it, "it");
            return r.f317a;
        }

        public final void config(S7.k action) {
            k.f(action, "action");
            this.h.config(action);
        }

        public final void release(S7.k reset) {
            k.f(reset, "reset");
            this.h.config(reset);
            View view = this.viewRef.get();
            if (view == null) {
                return;
            }
            InWindowMaterialBackend.INSTANCE.releaseHolder(view, this.h);
        }
    }

    static {
        boolean z10;
        Class<?> cls;
        Class<?> cls2;
        Method method;
        Class<?> cls3 = Float.TYPE;
        INSTANCE = new InWindowMaterialBackend();
        try {
            Class.forName(SDK_CLASS);
            z10 = true;
        } catch (Throwable th) {
            Log.i(TAG, "StepOSGlassMaterial 不可用，将尝试反射 BackdropMaterialParams/createGlassMaterialEffect: " + th.getClass().getSimpleName() + ": " + th.getMessage());
            z10 = false;
        }
        sdkAvailable = z10;
        Method method2 = null;
        try {
            cls = Class.forName("android.graphics.BackdropMaterialParams$Builder");
        } catch (Throwable th2) {
            Log.e(TAG, "BackdropMaterialParams.Builder unavailable: " + th2.getClass().getSimpleName() + ": " + th2.getMessage());
            cls = null;
        }
        builderClass = cls;
        try {
            cls2 = Class.forName("android.graphics.BackdropMaterialParams");
        } catch (Throwable unused) {
            cls2 = null;
        }
        materialParamsClass = cls2;
        Class<?> cls4 = Integer.TYPE;
        if (cls2 != null) {
            try {
                method = RenderEffect.class.getMethod("createGlassMaterialEffect", cls2, cls4, RenderEffect.class);
                method.setAccessible(true);
            } catch (Throwable th3) {
                Log.e(TAG, "createGlassMaterialEffect unavailable: " + th3.getClass().getSimpleName() + ": " + th3.getMessage());
            }
        } else {
            method = null;
        }
        createGlassEffect = method;
        try {
            Method method3 = RenderEffect.class.getMethod("createStepOSBlurEffect", cls3, cls4, cls3);
            method3.setAccessible(true);
            method2 = method3;
        } catch (Throwable th4) {
            androidx.constraintlayout.core.dsl.a.x("createStepOSBlurEffect(3-arg) unavailable: ", th4.getClass().getSimpleName(), ": ", th4.getMessage(), TAG);
        }
        createStepOSBlurEffect = method2;
        holders = new WeakHashMap<>();
        dirtyHolders = new LinkedHashSet();
        methodCache = new HashMap<>();
        k.c(cls4);
        I = cls4;
        k.c(cls3);
        F = cls3;
        Class<?> cls5 = Boolean.TYPE;
        k.c(cls5);
        B = cls5;
        IA = int[].class;
    }

    private InWindowMaterialBackend() {
    }

    private final float alpha(int c) {
        return ((c >>> 24) & 255) / 255.0f;
    }

    private final float blue(int c) {
        return (c & 255) / 255.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RenderEffect buildGlassEffectSdk(Config c, RenderEffect blur, int effCgMode) {
        Object objNewGlassMaterialBuilder = StepOSGlassMaterial.newGlassMaterialBuilder();
        if (objNewGlassMaterialBuilder == null) {
            return blur;
        }
        StepOSGlassMaterial.gmSetGeometry(objNewGlassMaterialBuilder, 0.0f, 0.0f, c.getCornerRadius(), c.getCornerRadius(), c.getCornerRadius(), c.getCornerRadius());
        StepOSGlassMaterial.gmSetCornerSmoothness(objNewGlassMaterialBuilder, c.getCornerSmoothness());
        StepOSGlassMaterial.gmSetBlend(objNewGlassMaterialBuilder, c.getBlendMode(), c.getBlendColor(), alpha(c.getTintColor()));
        List listA1 = v.a1(c.getBlendStages(), 4);
        if (!listA1.isEmpty()) {
            int size = listA1.size();
            int[] iArr = new int[size];
            for (int i = 0; i < size; i++) {
                iArr[i] = ((Number) ((Pair) listA1.get(i)).f4886a).intValue();
            }
            int size2 = listA1.size();
            int[] iArr2 = new int[size2];
            for (int i6 = 0; i6 < size2; i6++) {
                iArr2[i6] = ((Number) ((Pair) listA1.get(i6)).b).intValue();
            }
            StepOSGlassMaterial.gmSetBlendArray(objNewGlassMaterialBuilder, iArr, iArr2);
        }
        StepOSGlassMaterial.gmSetFrost(objNewGlassMaterialBuilder, c.getFrost());
        StepOSGlassMaterial.gmSetStroke(objNewGlassMaterialBuilder, c.getStrokeEnabled(), c.getStrokeWidth(), c.getStrokeSoftness(), c.getStrokeIntensity(), red(c.getStrokeColor()), green(c.getStrokeColor()), blue(c.getStrokeColor()), alpha(c.getStrokeColor()));
        StepOSGlassMaterial.gmSetStrokeSpread(objNewGlassMaterialBuilder, c.getStrokeSpread());
        StepOSGlassMaterial.gmSetLightDirs(objNewGlassMaterialBuilder, c.getLight0X(), c.getLight0Y(), c.getLight1X(), c.getLight1Y());
        StepOSGlassMaterial.gmSetAmbient(objNewGlassMaterialBuilder, c.getAmbient());
        StepOSGlassMaterial.gmSetAnisoRim(objNewGlassMaterialBuilder, c.getAnisoRim());
        StepOSGlassMaterial.gmSetEdgeColor(objNewGlassMaterialBuilder, c.getEdgeColor());
        StepOSGlassMaterial.gmSetDarkColor(objNewGlassMaterialBuilder, c.getDarkColor());
        StepOSGlassMaterial.gmSetDarkWidth(objNewGlassMaterialBuilder, c.getDarkWidth());
        StepOSGlassMaterial.gmSetEdgeWidth(objNewGlassMaterialBuilder, c.getEdgeWidth());
        StepOSGlassMaterial.gmSetInnerShadow(objNewGlassMaterialBuilder, c.getInnerEnabled(), red(c.getInnerColor()), green(c.getInnerColor()), blue(c.getInnerColor()), alpha(c.getInnerColor()), c.getInnerRadius(), c.getInnerOffsetX(), c.getInnerOffsetY(), c.getInnerIntensity());
        StepOSGlassMaterial.gmSetRefraction(objNewGlassMaterialBuilder, c.getRefractEnabled(), c.getRefractStrength(), c.getRefractWidth());
        StepOSGlassMaterial.gmSetDepthEffect(objNewGlassMaterialBuilder, c.getDepthEffect());
        StepOSGlassMaterial.gmSetDispersion(objNewGlassMaterialBuilder, c.getDispersion());
        StepOSGlassMaterial.gmSetUseShapeAlpha(objNewGlassMaterialBuilder, c.getStrokeEnabled() || c.getInnerEnabled());
        StepOSGlassMaterial.gmSetColorGradient(objNewGlassMaterialBuilder, c.getCgStart(), c.getCgMiddle(), c.getCgEnd(), c.getCgMidpoint(), effCgMode);
        RenderEffect renderEffectBuildGlassMaterialEffect = StepOSGlassMaterial.buildGlassMaterialEffect(objNewGlassMaterialBuilder, c.getTintColor(), blur);
        k.e(renderEffectBuildGlassMaterialEffect, "buildGlassMaterialEffect(...)");
        return renderEffectBuildGlassMaterialEffect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object buildMaterial(Config c, int effCgMode) {
        Float fValueOf = Float.valueOf(0.0f);
        Class<?> cls = builderClass;
        if (cls == null) {
            return null;
        }
        try {
            Object objNewInstance = cls.getConstructor(null).newInstance(null);
            k.c(objNewInstance);
            Class<?> cls2 = F;
            call(cls, objNewInstance, "setGeometry", new Class[]{cls2, cls2, cls2, cls2, cls2, cls2}, fValueOf, fValueOf, Float.valueOf(c.getCornerRadius()), Float.valueOf(c.getCornerRadius()), Float.valueOf(c.getCornerRadius()), Float.valueOf(c.getCornerRadius()));
            call(cls, objNewInstance, "setCornerSmoothness", new Class[]{cls2}, Float.valueOf(c.getCornerSmoothness()));
            call(cls, objNewInstance, "setBlend", new Class[]{I, cls2, cls2}, Integer.valueOf(c.getBlendMode()), Float.valueOf(c.getBlendColor()), Float.valueOf(alpha(c.getTintColor())));
            List listA1 = v.a1(c.getBlendStages(), 4);
            if (!listA1.isEmpty()) {
                int size = listA1.size();
                int[] iArr = new int[size];
                for (int i = 0; i < size; i++) {
                    iArr[i] = ((Number) ((Pair) listA1.get(i)).f4886a).intValue();
                }
                int size2 = listA1.size();
                int[] iArr2 = new int[size2];
                for (int i6 = 0; i6 < size2; i6++) {
                    iArr2[i6] = ((Number) ((Pair) listA1.get(i6)).b).intValue();
                }
                Class<?> cls3 = IA;
                call(cls, objNewInstance, "setBlendArray", new Class[]{cls3, cls3}, iArr, iArr2);
            }
            Class<?> cls4 = F;
            call(cls, objNewInstance, "setFrost", new Class[]{cls4}, Float.valueOf(c.getFrost()));
            Class<?> cls5 = B;
            call(cls, objNewInstance, "setStroke", new Class[]{cls5, cls4, cls4, cls4, cls4, cls4, cls4, cls4}, Boolean.valueOf(c.getStrokeEnabled()), Float.valueOf(c.getStrokeWidth()), Float.valueOf(c.getStrokeSoftness()), Float.valueOf(c.getStrokeIntensity()), Float.valueOf(red(c.getStrokeColor())), Float.valueOf(green(c.getStrokeColor())), Float.valueOf(blue(c.getStrokeColor())), Float.valueOf(alpha(c.getStrokeColor())));
            call(cls, objNewInstance, "setStrokeSpread", new Class[]{cls4}, Float.valueOf(c.getStrokeSpread()));
            call(cls, objNewInstance, "setLightDirs", new Class[]{cls4, cls4, cls4, cls4}, Float.valueOf(c.getLight0X()), Float.valueOf(c.getLight0Y()), Float.valueOf(c.getLight1X()), Float.valueOf(c.getLight1Y()));
            call(cls, objNewInstance, "setAmbient", new Class[]{cls4}, Float.valueOf(c.getAmbient()));
            call(cls, objNewInstance, "setAnisoRim", new Class[]{cls5}, Boolean.valueOf(c.getAnisoRim()));
            Class<?> cls6 = I;
            call(cls, objNewInstance, "setEdgeColor", new Class[]{cls6}, Integer.valueOf(c.getEdgeColor()));
            call(cls, objNewInstance, "setDarkColor", new Class[]{cls6}, Integer.valueOf(c.getDarkColor()));
            call(cls, objNewInstance, "setDarkWidth", new Class[]{cls4}, Float.valueOf(c.getDarkWidth()));
            call(cls, objNewInstance, "setEdgeWidth", new Class[]{cls4}, Float.valueOf(c.getEdgeWidth()));
            call(cls, objNewInstance, "setInnerShadow", new Class[]{cls5, cls4, cls4, cls4, cls4, cls4, cls4, cls4, cls4}, Boolean.valueOf(c.getInnerEnabled()), Float.valueOf(red(c.getInnerColor())), Float.valueOf(green(c.getInnerColor())), Float.valueOf(blue(c.getInnerColor())), Float.valueOf(alpha(c.getInnerColor())), Float.valueOf(c.getInnerRadius()), Float.valueOf(c.getInnerOffsetX()), Float.valueOf(c.getInnerOffsetY()), Float.valueOf(c.getInnerIntensity()));
            call(cls, objNewInstance, "setRefraction", new Class[]{cls5, cls4, cls4}, Boolean.valueOf(c.getRefractEnabled()), Float.valueOf(c.getRefractStrength()), Float.valueOf(c.getRefractWidth()));
            call(cls, objNewInstance, "setDepthEffect", new Class[]{cls4}, Float.valueOf(c.getDepthEffect()));
            call(cls, objNewInstance, "setDispersion", new Class[]{cls4}, Float.valueOf(c.getDispersion()));
            call(cls, objNewInstance, "setUseShapeAlpha", new Class[]{cls5}, Boolean.valueOf(c.getStrokeEnabled() || c.getInnerEnabled()));
            call(cls, objNewInstance, "setColorGradient", new Class[]{cls6, cls6, cls6, cls4, cls6}, Integer.valueOf(c.getCgStart()), Integer.valueOf(c.getCgMiddle()), Integer.valueOf(c.getCgEnd()), Float.valueOf(c.getCgMidpoint()), Integer.valueOf(effCgMode));
            return cls.getMethod(JsonPOJOBuilder.DEFAULT_BUILD_METHOD, null).invoke(objNewInstance, null);
        } catch (Throwable th) {
            th = th;
            Throwable cause = th.getCause();
            if (cause != null) {
                th = cause;
            }
            Log.e(TAG, "buildMaterial failed: " + th.getClass().getSimpleName() + ": " + th.getMessage());
            return null;
        }
    }

    private final void call(Class<?> cls, Object target, String name, Class<?>[] types, Object... args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method;
        String str = name + types.length;
        HashMap<String, Method> map = methodCache;
        Method method2 = map.get(str);
        if (method2 == null) {
            try {
                method = cls.getMethod(name, (Class[]) Arrays.copyOf(types, types.length));
            } catch (Throwable th) {
                Log.e(TAG, name + " reflection failed: " + th.getClass().getSimpleName() + ": " + th.getMessage());
                method = null;
            }
            method2 = method;
            map.put(str, method2);
        }
        Method method3 = method2;
        if (method3 == null) {
            return;
        }
        method3.invoke(target, Arrays.copyOf(args, args.length));
    }

    private final boolean getReflectAvailable() {
        return (builderClass == null || materialParamsClass == null || createGlassEffect == null) ? false : true;
    }

    private final float green(int c) {
        return ((c >>> 8) & 255) / 255.0f;
    }

    private final float red(int c) {
        return ((c >>> 16) & 255) / 255.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void releaseHolder(View view, Holder h) {
        try {
            h.setRefCount(h.getRefCount() - 1);
            if (h.getRefCount() <= 0) {
                if (view.isAttachedToWindow()) {
                    view.post(new l(view, 13, h));
                } else {
                    h.clear();
                    holders.remove(view);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void releaseHolder$lambda$7(Holder holder, View view) {
        synchronized (INSTANCE) {
            if (holder.getRefCount() <= 0) {
                holder.clear();
                holders.remove(view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int rotateModeForDisplay(int mode, int rotation) {
        int i = 0;
        if (mode == 0) {
            return 0;
        }
        int i6 = mode != 3 ? mode != 4 ? 0 : -1 : 1;
        int i10 = mode != 1 ? mode != 2 ? 0 : -1 : 1;
        while (i < ((rotation % 4) + 4) % 4) {
            int i11 = -i10;
            i++;
            i10 = i6;
            i6 = i11;
        }
        if (i6 == 0 && i10 == 1) {
            return 1;
        }
        if (i6 == 0 && i10 == -1) {
            return 2;
        }
        if (i6 == 1 && i10 == 0) {
            return 3;
        }
        if (i6 == -1 && i10 == 0) {
            return 4;
        }
        return mode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r setCornerRadius$lambda$4(float f, Config it) {
        k.f(it, "it");
        it.setCornerRadius(f);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r setCornerSmoothness$lambda$5(float f, Config it) {
        k.f(it, "it");
        it.setCornerSmoothness(f);
        return r.f317a;
    }

    public final synchronized Token acquire(View view) {
        k.f(view, "view");
        boolean z10 = true;
        if (!isAvailable()) {
            boolean z11 = builderClass != null;
            boolean z12 = materialParamsClass != null;
            if (createGlassEffect == null) {
                z10 = false;
            }
            Log.w(TAG, "acquire: isAvailable=false (builder=" + z11 + " mp=" + z12 + " glassFx=" + z10 + " setBackdrop=" + BackdropRenderEffectAccess.INSTANCE.isAvailable() + ")");
            return null;
        }
        WeakHashMap<View, Holder> weakHashMap = holders;
        Holder holder = weakHashMap.get(view);
        if (holder == null) {
            holder = new Holder(view);
            weakHashMap.put(view, holder);
        }
        Holder holder2 = holder;
        holder2.setRefCount(holder2.getRefCount() + 1);
        Log.d(TAG, "acquire: holder=" + System.identityHashCode(holder2) + " refCount=" + holder2.getRefCount() + " view=" + System.identityHashCode(view));
        return new Token(view, holder2);
    }

    public final synchronized <T> T batch(S7.a body) {
        T t9;
        k.f(body, "body");
        batchDepth++;
        try {
            t9 = (T) body.invoke();
            int i = batchDepth - 1;
            batchDepth = i;
            if (i == 0) {
                Set<Holder> set = dirtyHolders;
                List listF1 = v.f1(set);
                set.clear();
                Iterator<T> it = listF1.iterator();
                while (it.hasNext()) {
                    ((Holder) it.next()).rebuild();
                }
            }
        } catch (Throwable th) {
            batchDepth--;
            if (batchDepth == 0) {
                Set<Holder> set2 = dirtyHolders;
                List listF12 = v.f1(set2);
                set2.clear();
                Iterator<T> it2 = listF12.iterator();
                while (it2.hasNext()) {
                    ((Holder) it2.next()).rebuild();
                }
            }
            throw th;
        }
        return t9;
    }

    public final boolean isAvailable() {
        return (sdkAvailable || getReflectAvailable()) && BackdropRenderEffectAccess.INSTANCE.isAvailable();
    }

    public final synchronized void setCornerRadius(View view, float px) {
        k.f(view, "view");
        Holder holder = holders.get(view);
        if (holder == null) {
            return;
        }
        holder.config(new m(px, 4));
    }

    public final synchronized void setCornerSmoothness(View view, float v10) {
        k.f(view, "view");
        Holder holder = holders.get(view);
        if (holder == null) {
            return;
        }
        holder.config(new m(v10, 5));
    }
}

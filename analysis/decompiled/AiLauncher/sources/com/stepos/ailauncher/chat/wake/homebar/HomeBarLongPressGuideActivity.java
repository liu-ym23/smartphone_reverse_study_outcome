package com.stepos.ailauncher.chat.wake.homebar;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.LinearGradient;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Property;
import android.view.AttachedSurfaceControl;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.N;
import androidx.core.view.Y;
import androidx.core.view.a0;
import androidx.dynamicanimation.animation.e;
import androidx.exifinterface.media.ExifInterface;
import b.AbstractC1417G;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.LottieOnCompositionLoadedListener;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieValueCallback;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.view.C2851i7;
import com.stepos.ailauncher.chat.wake.blur.BlurConfig;
import h8.C4148a;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import l5.C4872a;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;
import y7.E;

@Metadata(d1 = {"\u0000ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b*\u0002\u0094\u0001\u0018\u0000 \u009d\u00012\u00020\u0001:\u0002\u009e\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\f\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\f\u0010\u0003J\u001f\u0010\u000f\u001a\u00020\u00062\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0011\u001a\u00020\u00062\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0003J\u000f\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0003J\u000f\u0010\u0014\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0003J\u000f\u0010\u0016\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\u0003J\u000f\u0010\u0017\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\u0003J\u000f\u0010\u0018\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0003J\u000f\u0010\u0019\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0019\u0010\u0003J\u000f\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001a\u0010\u0003J\u0017\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001f\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b \u0010\u001eJA\u0010)\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u001b2\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\rH\u0002¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0006H\u0002¢\u0006\u0004\b+\u0010\u0003J\u000f\u0010,\u001a\u00020\u0006H\u0002¢\u0006\u0004\b,\u0010\u0003JG\u00106\u001a\u00020\u00062\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020/2\u0006\u00102\u001a\u00020/2\u0016\b\u0002\u00105\u001a\u0010\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000204\u0018\u000103H\u0002¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\u0006H\u0002¢\u0006\u0004\b8\u0010\u0003J\u000f\u00109\u001a\u00020\u0006H\u0002¢\u0006\u0004\b9\u0010\u0003J\u000f\u0010:\u001a\u00020\u0006H\u0002¢\u0006\u0004\b:\u0010\u0003J\u000f\u0010;\u001a\u00020\u0006H\u0002¢\u0006\u0004\b;\u0010\u0003J\u000f\u0010<\u001a\u00020\u0006H\u0002¢\u0006\u0004\b<\u0010\u0003J\u000f\u0010>\u001a\u00020=H\u0002¢\u0006\u0004\b>\u0010?J\u000f\u0010@\u001a\u00020\u0006H\u0002¢\u0006\u0004\b@\u0010\u0003J\u0017\u0010C\u001a\u00020\u00062\u0006\u0010B\u001a\u00020AH\u0002¢\u0006\u0004\bC\u0010DJ\u000f\u0010E\u001a\u00020\u0006H\u0002¢\u0006\u0004\bE\u0010\u0003J\u000f\u0010F\u001a\u00020\u0006H\u0002¢\u0006\u0004\bF\u0010\u0003J\u000f\u0010G\u001a\u00020%H\u0002¢\u0006\u0004\bG\u0010HJ\u001f\u0010L\u001a\u00020K2\u0006\u0010\"\u001a\u00020!2\u0006\u0010J\u001a\u00020IH\u0002¢\u0006\u0004\bL\u0010MJ\u001f\u0010N\u001a\u00020K2\u0006\u0010\"\u001a\u00020!2\u0006\u0010J\u001a\u00020IH\u0002¢\u0006\u0004\bN\u0010MJ\u000f\u0010O\u001a\u00020\u0006H\u0002¢\u0006\u0004\bO\u0010\u0003J\u000f\u0010P\u001a\u00020\u0006H\u0002¢\u0006\u0004\bP\u0010\u0003J\u0017\u0010Q\u001a\u00020\u00062\u0006\u0010.\u001a\u00020-H\u0002¢\u0006\u0004\bQ\u0010RJ\u000f\u0010S\u001a\u00020\u0006H\u0002¢\u0006\u0004\bS\u0010\u0003R\u0016\u0010U\u001a\u00020T8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010W\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u00106R\u0016\u0010X\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u00106R\u001e\u0010Y\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010\\\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\u0018\u0010_\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0014\u0010b\u001a\u00020a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010d\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u00106R\u0016\u0010e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u00106R\u0016\u0010f\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u00106R\u0016\u0010g\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u00106R\u0016\u0010h\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u00106R0\u0010k\u001a\u001e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u0002040ij\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000204`j8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bk\u0010lR\u0014\u0010n\u001a\u00020m8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bn\u0010oR\u001a\u0010r\u001a\b\u0012\u0004\u0012\u00020q0p8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\br\u0010sR\u0014\u0010t\u001a\u00020m8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bt\u0010oR\u001a\u0010u\u001a\b\u0012\u0004\u0012\u00020q0p8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bu\u0010sR\u001a\u0010v\u001a\b\u0012\u0004\u0012\u00020q0p8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bv\u0010sR\u0014\u0010w\u001a\u00020m8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bw\u0010oR\u001a\u0010x\u001a\b\u0012\u0004\u0012\u00020q0p8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bx\u0010sR\u001a\u0010y\u001a\b\u0012\u0004\u0012\u00020q0p8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\by\u0010sR\u0014\u0010z\u001a\u00020a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bz\u0010cR\u0014\u0010{\u001a\u00020a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b{\u0010cR\u001a\u0010~\u001a\b\u0012\u0004\u0012\u00020}0|8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b~\u0010\u007fR\u001f\u0010\u0082\u0001\u001a\n\u0012\u0005\u0012\u00030\u0081\u00010\u0080\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0018\u0010\u0085\u0001\u001a\u00030\u0084\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R\u001c\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0087\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0016\u0010\u008a\u0001\u001a\u00020a8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u008a\u0001\u0010cR\u0018\u0010\u008b\u0001\u001a\u00030\u0084\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008b\u0001\u0010\u0086\u0001R\u0016\u0010\u008c\u0001\u001a\u00020a8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u008c\u0001\u0010cR\u0019\u0010\u008d\u0001\u001a\u00020q8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R\u0019\u0010\u008f\u0001\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R\u001a\u0010\u0092\u0001\u001a\u00030\u0091\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R\u0018\u0010\u0095\u0001\u001a\u00030\u0094\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001R\u0018\u0010\u0098\u0001\u001a\u00030\u0097\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0098\u0001\u0010\u0099\u0001R\u0017\u0010\u009c\u0001\u001a\u00020\u001b8BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001¨\u0006\u009f\u0001"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/homebar/HomeBarLongPressGuideActivity;", "Landroidx/appcompat/app/d;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onCreate", "(Landroid/os/Bundle;)V", "onPause", "onResume", "onStop", "onDestroy", "Lkotlin/Function0;", "onFinished", "x0", "(Lp9/a;)V", "g0", "v0", "T0", "t0", "U0", "w0", "F0", "O0", "q0", "G0", "", "hidden", "I0", "(Z)V", "H0", "J0", "Landroid/view/View;", "target", "Landroidx/dynamicanimation/animation/e$s;", "property", "", "finalPosition", "exit", "onEnd", "P0", "(Landroid/view/View;Landroidx/dynamicanimation/animation/e$s;FZLp9/a;)V", "Y", "A0", "Lcom/airbnb/lottie/LottieAnimationView;", "view", "", "jsonAsset", "imageDir", "assetsFolder", "", "Landroid/graphics/Bitmap;", "imageCache", "Z", "(Lcom/airbnb/lottie/LottieAnimationView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "r0", ExifInterface.LONGITUDE_WEST, "B0", "K0", "U", "Landroid/graphics/drawable/PaintDrawable;", "m0", "()Landroid/graphics/drawable/PaintDrawable;", "X", "Landroid/widget/LinearLayout;", "layer", "h0", "(Landroid/widget/LinearLayout;)V", ExifInterface.GPS_DIRECTION_TRUE, "e0", "d0", "()F", "Landroid/animation/TimeInterpolator;", "interpolator", "Landroid/animation/ObjectAnimator;", "i0", "(Landroid/view/View;Landroid/animation/TimeInterpolator;)Landroid/animation/ObjectAnimator;", "j0", "k0", "D0", "C0", "(Lcom/airbnb/lottie/LottieAnimationView;)V", "f0", "Ll5/a;", "binding", "Ll5/a;", "exiting", "destroyed", "exitCallback", "Lp9/a;", "Landroid/animation/Animator;", "enterFade", "Landroid/animation/Animator;", "Landroid/animation/AnimatorSet;", "exitFade", "Landroid/animation/AnimatorSet;", "Ljava/lang/Runnable;", "startContentExit", "Ljava/lang/Runnable;", "enterStarted", "backgroundEnterStarted", "backgroundEnterDone", "illustrationCompositionReady", "enterLayoutReady", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "illustrationImageCache", "Ljava/util/HashMap;", "Lcom/airbnb/lottie/model/KeyPath;", "pressGlowPath", "Lcom/airbnb/lottie/model/KeyPath;", "Lcom/airbnb/lottie/value/LottieValueCallback;", "", "hidePressGlow", "Lcom/airbnb/lottie/value/LottieValueCallback;", "fingertipHighlightPath", "hideFingertipHighlight", "showFingertipHighlight", "thumbPath", "hideThumb", "showThumb", "startContentAfterBackground", "revealFollowLayers", "", "Landroidx/dynamicanimation/animation/i;", "springs", "Ljava/util/List;", "", "Lcom/stepos/ailauncher/chat/wake/blur/c;", "hostBandBlurs", "[Lcom/stepos/ailauncher/chat/wake/blur/c;", "Landroid/view/View$OnLayoutChangeListener;", "hostPageBlurLayoutListener", "Landroid/view/View$OnLayoutChangeListener;", "Ly7/E;", "capsuleGlassHandle", "Ly7/E;", "playGlow", "tapLayoutListener", "applyTapRegion", "homeBarGlowCycle", "I", "lastIllustrationProgress", "F", "", "lastLoopAtElapsed", "J", "com/stepos/ailauncher/chat/wake/homebar/HomeBarLongPressGuideActivity$f", "illustrationLoopListener", "Lcom/stepos/ailauncher/chat/wake/homebar/HomeBarLongPressGuideActivity$f;", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "illustrationGlowFrameListener", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "l0", "()Z", "canAnimate", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HomeBarLongPressGuideActivity extends androidx.appcompat.app.d {
    private static final int BLUR_BANDS = 16;
    private static final int BLUR_BANDS_LOWER = 6;
    private static final int BLUR_BANDS_UPPER = 10;
    private static final float BLUR_END_DP = 20.0f;
    private static final float CAPSULE_HOMEBAR_GAP_DP = 12.0f;
    private static final float CAPSULE_MIN_BOTTOM_DP = 32.0f;
    private static final int COLOR_BOTTOM = -16777216;
    private static final int COLOR_MID = -436207616;
    private static final int COLOR_TOP = 1710618;
    private static final boolean ENABLE_HOST_BLUR = true;
    private static final String GLOW_FOLDER = "homebar_guide/glow/";
    private static final String GLOW_IMAGES = "homebar_guide/glow/images";
    private static final String GLOW_JSON = "homebar_guide/glow/data.json";
    private static final String ILLUSTRATION_FINGERTIP_LAYER = "Group 2147228629";
    private static final String ILLUSTRATION_FOLDER = "homebar_guide/illustration/";
    private static final String ILLUSTRATION_IMAGES = "homebar_guide/illustration/images";
    private static final String ILLUSTRATION_JSON = "homebar_guide/illustration/data.json";
    private static final String ILLUSTRATION_PRESS_GLOW_LAYER = "手指按压发光.png";
    private static final String ILLUSTRATION_THUMB_LAYER = "大拇指";
    private static final String TAG = "HomeBarLpGuide";
    private static WeakReference<HomeBarLongPressGuideActivity> instance;
    private final Runnable applyTapRegion;
    private boolean backgroundEnterDone;
    private boolean backgroundEnterStarted;
    private C4872a binding;
    private E capsuleGlassHandle;
    private boolean destroyed;
    private Animator enterFade;
    private boolean enterLayoutReady;
    private boolean enterStarted;
    private InterfaceC5063a<Y8.t> exitCallback;
    private AnimatorSet exitFade;
    private boolean exiting;
    private int homeBarGlowCycle;
    private final com.stepos.ailauncher.chat.wake.blur.c[] hostBandBlurs;
    private final View.OnLayoutChangeListener hostPageBlurLayoutListener;
    private boolean illustrationCompositionReady;
    private final ValueAnimator.AnimatorUpdateListener illustrationGlowFrameListener;
    private final f illustrationLoopListener;
    private float lastIllustrationProgress;
    private long lastLoopAtElapsed;
    private final Runnable playGlow;
    private final View.OnLayoutChangeListener tapLayoutListener;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String[] ILLUSTRATION_PNGS = {"img_0.png", "img_1.png", "img_2.png", "img_3.png"};
    private final Runnable startContentExit = new Runnable() { // from class: com.stepos.ailauncher.chat.wake.homebar.h
        @Override // java.lang.Runnable
        public final void run() {
            HomeBarLongPressGuideActivity.N0(this.f26785a);
        }
    };
    private final HashMap<String, Bitmap> illustrationImageCache = new HashMap<>(4);
    private final KeyPath pressGlowPath = new KeyPath(ILLUSTRATION_PRESS_GLOW_LAYER);
    private final LottieValueCallback<Integer> hidePressGlow = new LottieValueCallback<>(0);
    private final KeyPath fingertipHighlightPath = new KeyPath(ILLUSTRATION_FINGERTIP_LAYER);
    private final LottieValueCallback<Integer> hideFingertipHighlight = new LottieValueCallback<>(0);
    private final LottieValueCallback<Integer> showFingertipHighlight = new LottieValueCallback<>(100);
    private final KeyPath thumbPath = new KeyPath(ILLUSTRATION_THUMB_LAYER);
    private final LottieValueCallback<Integer> hideThumb = new LottieValueCallback<>(0);
    private final LottieValueCallback<Integer> showThumb = new LottieValueCallback<>(100);
    private final Runnable startContentAfterBackground = new Runnable() { // from class: com.stepos.ailauncher.chat.wake.homebar.n
        @Override // java.lang.Runnable
        public final void run() {
            HomeBarLongPressGuideActivity.M0(this.f26796a);
        }
    };
    private final Runnable revealFollowLayers = new Runnable() { // from class: com.stepos.ailauncher.chat.wake.homebar.o
        @Override // java.lang.Runnable
        public final void run() {
            HomeBarLongPressGuideActivity.E0(this.f26797a);
        }
    };
    private final List<androidx.dynamicanimation.animation.i> springs = new ArrayList();

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\f\u001a\u00020\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\f\u0010\u000bJ\u001b\u0010\r\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0016R\u0014\u0010\u001d\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0016R\u0014\u0010\u001e\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u0016R\u0014\u0010\u001f\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010\u001bR\u0014\u0010 \u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010\u001bR\u0014\u0010!\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\u0011R\u0014\u0010\"\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010\u0011R\u0014\u0010#\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010\u0011R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000f0$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010\u0011R\u0014\u0010(\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010\u0011R\u0014\u0010)\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b)\u0010\u0011R\u0014\u0010*\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010\u0011R\u0014\u0010+\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b+\u0010\u0011R\u0014\u0010,\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b,\u0010\u0011R\u001e\u0010/\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100¨\u00061"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/homebar/HomeBarLongPressGuideActivity$a;", "", "<init>", "()V", "", "c", "()Z", "Lkotlin/Function0;", "LY8/t;", "onFinished", Const.INTENT_KEY_UMID, "(Lp9/a;)V", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "(Lp9/a;)Z", "", "TAG", "Ljava/lang/String;", "ENABLE_HOST_BLUR", "Z", "", "COLOR_TOP", "I", "COLOR_MID", "COLOR_BOTTOM", "", "BLUR_END_DP", "F", "BLUR_BANDS_UPPER", "BLUR_BANDS_LOWER", "BLUR_BANDS", "CAPSULE_MIN_BOTTOM_DP", "CAPSULE_HOMEBAR_GAP_DP", "ILLUSTRATION_JSON", "ILLUSTRATION_FOLDER", "ILLUSTRATION_IMAGES", "", "ILLUSTRATION_PNGS", "[Ljava/lang/String;", "ILLUSTRATION_PRESS_GLOW_LAYER", "ILLUSTRATION_FINGERTIP_LAYER", "ILLUSTRATION_THUMB_LAYER", "GLOW_JSON", "GLOW_FOLDER", "GLOW_IMAGES", "Ljava/lang/ref/WeakReference;", "Lcom/stepos/ailauncher/chat/wake/homebar/HomeBarLongPressGuideActivity;", "instance", "Ljava/lang/ref/WeakReference;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.wake.homebar.HomeBarLongPressGuideActivity$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final void a(InterfaceC5063a<Y8.t> onFinished) {
            WeakReference weakReference = HomeBarLongPressGuideActivity.instance;
            HomeBarLongPressGuideActivity homeBarLongPressGuideActivity = weakReference != null ? (HomeBarLongPressGuideActivity) weakReference.get() : null;
            if (homeBarLongPressGuideActivity != null) {
                C4148a.k(HomeBarLongPressGuideActivity.TAG, "dismiss now, remove guide task", false, 4, null);
                homeBarLongPressGuideActivity.g0(onFinished);
            } else if (onFinished != null) {
                onFinished.invoke();
            }
        }

        public final boolean b(InterfaceC5063a<Y8.t> onFinished) {
            HomeBarLongPressGuideActivity homeBarLongPressGuideActivity;
            kotlin.jvm.internal.p.i(onFinished, "onFinished");
            WeakReference weakReference = HomeBarLongPressGuideActivity.instance;
            if (weakReference == null || (homeBarLongPressGuideActivity = (HomeBarLongPressGuideActivity) weakReference.get()) == null || homeBarLongPressGuideActivity.destroyed) {
                return false;
            }
            C4148a.k(HomeBarLongPressGuideActivity.TAG, "dismiss now if present", false, 4, null);
            homeBarLongPressGuideActivity.g0(onFinished);
            return true;
        }

        public final boolean c() {
            HomeBarLongPressGuideActivity homeBarLongPressGuideActivity;
            WeakReference weakReference = HomeBarLongPressGuideActivity.instance;
            return (weakReference == null || (homeBarLongPressGuideActivity = (HomeBarLongPressGuideActivity) weakReference.get()) == null || homeBarLongPressGuideActivity.isFinishing() || homeBarLongPressGuideActivity.exiting) ? false : true;
        }

        public final void d(InterfaceC5063a<Y8.t> onFinished) {
            WeakReference weakReference = HomeBarLongPressGuideActivity.instance;
            HomeBarLongPressGuideActivity homeBarLongPressGuideActivity = weakReference != null ? (HomeBarLongPressGuideActivity) weakReference.get() : null;
            if (homeBarLongPressGuideActivity != null) {
                C4148a.k(HomeBarLongPressGuideActivity.TAG, "exit for next-scene interaction", false, 4, null);
                homeBarLongPressGuideActivity.x0(onFinished);
            } else if (onFinished != null) {
                onFinished.invoke();
            }
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JW\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"androidx/core/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View;", "view", "", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "LY8/t;", "onLayoutChange", "(Landroid/view/View;IIIIIIII)V", "core-ktx_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements View.OnLayoutChangeListener {
        final /* synthetic */ LinearLayout $capsule$inlined;

        public b(LinearLayout linearLayout) {
            this.$capsule$inlined = linearLayout;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            view.removeOnLayoutChangeListener(this);
            if (HomeBarLongPressGuideActivity.this.destroyed || HomeBarLongPressGuideActivity.this.exiting || !this.$capsule$inlined.isAttachedToWindow() || HomeBarLongPressGuideActivity.this.capsuleGlassHandle != null) {
                return;
            }
            float fMin = (Math.min(this.$capsule$inlined.getWidth(), this.$capsule$inlined.getHeight()) / 2.0f) / this.$capsule$inlined.getResources().getDisplayMetrics().density;
            if (fMin > 0.0f) {
                C2851i7 c2851i7 = C2851i7.INSTANCE;
                c2851i7.a(this.$capsule$inlined, fMin);
                HomeBarLongPressGuideActivity.this.capsuleGlassHandle = C2851i7.d(c2851i7, this.$capsule$inlined, false, Float.valueOf(fMin), null, 8, null);
                c2851i7.i(this.$capsule$inlined, HomeBarLongPressGuideActivity.this.capsuleGlassHandle, HomeBarLongPressGuideActivity.this.new c());
            }
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class c implements InterfaceC5074l<E, Y8.t> {
        public c() {
        }

        public final void a(E it) {
            kotlin.jvm.internal.p.i(it, "it");
            HomeBarLongPressGuideActivity.this.capsuleGlassHandle = null;
        }

        @Override // p9.InterfaceC5074l
        public /* bridge */ /* synthetic */ Y8.t invoke(E e10) {
            a(e10);
            return Y8.t.f7040a;
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JW\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"androidx/core/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View;", "view", "", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "LY8/t;", "onLayoutChange", "(Landroid/view/View;IIIIIIII)V", "core-ktx_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d implements View.OnLayoutChangeListener {
        public d() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            view.removeOnLayoutChangeListener(this);
            HomeBarLongPressGuideActivity.this.T();
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"com/stepos/ailauncher/chat/wake/homebar/HomeBarLongPressGuideActivity$e", "Landroid/graphics/drawable/ShapeDrawable$ShaderFactory;", "", "width", "height", "Landroid/graphics/Shader;", "resize", "(II)Landroid/graphics/Shader;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class e extends ShapeDrawable.ShaderFactory {
        @Override // android.graphics.drawable.ShapeDrawable.ShaderFactory
        public Shader resize(int width, int height) {
            float f10 = width * 0.5f;
            return new LinearGradient(f10, 0.0f, f10, C5685n.f(height, 1), new int[]{HomeBarLongPressGuideActivity.COLOR_TOP, HomeBarLongPressGuideActivity.COLOR_MID, HomeBarLongPressGuideActivity.COLOR_BOTTOM}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/chat/wake/homebar/HomeBarLongPressGuideActivity$f", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "LY8/t;", "onAnimationRepeat", "(Landroid/animation/Animator;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class f extends AnimatorListenerAdapter {
        public f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
            kotlin.jvm.internal.p.i(animation, "animation");
            HomeBarLongPressGuideActivity.this.q0();
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JW\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"androidx/core/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View;", "view", "", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "LY8/t;", "onLayoutChange", "(Landroid/view/View;IIIIIIII)V", "core-ktx_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class g implements View.OnLayoutChangeListener {
        public g() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            view.removeOnLayoutChangeListener(this);
            HomeBarLongPressGuideActivity.this.enterLayoutReady = true;
            HomeBarLongPressGuideActivity.this.T0();
            HomeBarLongPressGuideActivity.this.U0();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/stepos/ailauncher/chat/wake/homebar/HomeBarLongPressGuideActivity$h", "Lb/G;", "LY8/t;", "handleOnBackPressed", "()V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class h extends AbstractC1417G {
        public h() {
            super(true);
        }

        @Override // b.AbstractC1417G
        public void handleOnBackPressed() {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/stepos/ailauncher/chat/wake/homebar/HomeBarLongPressGuideActivity$i", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "LY8/t;", "onAnimationEnd", "(Landroid/animation/Animator;)V", "onAnimationCancel", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class i extends AnimatorListenerAdapter {
        public i() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            kotlin.jvm.internal.p.i(animation, "animation");
            HomeBarLongPressGuideActivity.this.k0();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            kotlin.jvm.internal.p.i(animation, "animation");
            HomeBarLongPressGuideActivity.this.k0();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/chat/wake/homebar/HomeBarLongPressGuideActivity$j", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "LY8/t;", "onAnimationEnd", "(Landroid/animation/Animator;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class j extends AnimatorListenerAdapter {
        public j() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            kotlin.jvm.internal.p.i(animation, "animation");
            if (HomeBarLongPressGuideActivity.this.l0()) {
                HomeBarLongPressGuideActivity.this.I0(false);
            }
        }
    }

    public HomeBarLongPressGuideActivity() {
        com.stepos.ailauncher.chat.wake.blur.c[] cVarArr = new com.stepos.ailauncher.chat.wake.blur.c[16];
        for (int i10 = 0; i10 < 16; i10++) {
            cVarArr[i10] = new com.stepos.ailauncher.chat.wake.blur.c();
        }
        this.hostBandBlurs = cVarArr;
        this.hostPageBlurLayoutListener = new View.OnLayoutChangeListener() { // from class: com.stepos.ailauncher.chat.wake.homebar.p
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
                HomeBarLongPressGuideActivity.n0(this.f26798a, view, i11, i12, i13, i14, i15, i16, i17, i18);
            }
        };
        this.playGlow = new Runnable() { // from class: com.stepos.ailauncher.chat.wake.homebar.q
            @Override // java.lang.Runnable
            public final void run() {
                HomeBarLongPressGuideActivity.z0(this.f26799a);
            }
        };
        this.tapLayoutListener = new View.OnLayoutChangeListener() { // from class: com.stepos.ailauncher.chat.wake.homebar.r
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
                HomeBarLongPressGuideActivity.S0(this.f26800a, view, i11, i12, i13, i14, i15, i16, i17, i18);
            }
        };
        this.applyTapRegion = new Runnable() { // from class: com.stepos.ailauncher.chat.wake.homebar.s
            @Override // java.lang.Runnable
            public final void run() {
                HomeBarLongPressGuideActivity.V(this.f26801a);
            }
        };
        this.illustrationLoopListener = new f();
        this.illustrationGlowFrameListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.ailauncher.chat.wake.homebar.t
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                HomeBarLongPressGuideActivity.o0(this.f26802a, valueAnimator);
            }
        };
    }

    public static final void E0(HomeBarLongPressGuideActivity homeBarLongPressGuideActivity) {
        if (homeBarLongPressGuideActivity.l0()) {
            homeBarLongPressGuideActivity.H0(false);
            homeBarLongPressGuideActivity.J0(false);
        }
    }

    public static final void L0(HomeBarLongPressGuideActivity homeBarLongPressGuideActivity, View view) {
        y0(homeBarLongPressGuideActivity, null, 1, null);
    }

    public static final void M0(HomeBarLongPressGuideActivity homeBarLongPressGuideActivity) {
        if (homeBarLongPressGuideActivity.l0()) {
            homeBarLongPressGuideActivity.backgroundEnterDone = true;
            homeBarLongPressGuideActivity.U0();
        }
    }

    public static final void N0(HomeBarLongPressGuideActivity homeBarLongPressGuideActivity) {
        homeBarLongPressGuideActivity.v0();
    }

    public static /* synthetic */ void Q0(HomeBarLongPressGuideActivity homeBarLongPressGuideActivity, View view, e.s sVar, float f10, boolean z10, InterfaceC5063a interfaceC5063a, int i10, Object obj) {
        if ((i10 & 16) != 0) {
            interfaceC5063a = null;
        }
        homeBarLongPressGuideActivity.P0(view, sVar, f10, z10, interfaceC5063a);
    }

    public static final void R0(HomeBarLongPressGuideActivity homeBarLongPressGuideActivity, InterfaceC5063a interfaceC5063a, androidx.dynamicanimation.animation.e eVar, boolean z10, float f10, float f11) {
        if (z10 || !homeBarLongPressGuideActivity.l0()) {
            return;
        }
        interfaceC5063a.invoke();
    }

    public static final void S0(HomeBarLongPressGuideActivity homeBarLongPressGuideActivity, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        homeBarLongPressGuideActivity.U();
    }

    public static final void V(HomeBarLongPressGuideActivity homeBarLongPressGuideActivity) {
        homeBarLongPressGuideActivity.U();
    }

    public static /* synthetic */ void a0(HomeBarLongPressGuideActivity homeBarLongPressGuideActivity, LottieAnimationView lottieAnimationView, String str, String str2, String str3, Map map, int i10, Object obj) {
        if ((i10 & 16) != 0) {
            map = null;
        }
        homeBarLongPressGuideActivity.Z(lottieAnimationView, str, str2, str3, map);
    }

    public static final void b0(String str, LottieAnimationView lottieAnimationView, HomeBarLongPressGuideActivity homeBarLongPressGuideActivity, Throwable th) {
        kotlin.jvm.internal.p.f(th);
        C4148a.g(TAG, "lottie failed " + str, th, false, 8, null);
        C4872a c4872a = homeBarLongPressGuideActivity.binding;
        if (c4872a == null) {
            kotlin.jvm.internal.p.A("binding");
            c4872a = null;
        }
        if (lottieAnimationView == c4872a.homebarGuideIllustration) {
            homeBarLongPressGuideActivity.illustrationCompositionReady = true;
            homeBarLongPressGuideActivity.U0();
        }
    }

    public static final Bitmap c0(Map map, String str, HomeBarLongPressGuideActivity homeBarLongPressGuideActivity, LottieImageAsset lottieImageAsset) {
        Object objB;
        Bitmap bitmap;
        String fileName = lottieImageAsset.getFileName();
        if (fileName == null) {
            return null;
        }
        if (map != null && (bitmap = (Bitmap) map.get(fileName)) != null) {
            return bitmap;
        }
        String str2 = str + "/" + fileName;
        try {
            Result.Companion companion = Result.INSTANCE;
            InputStream inputStreamOpen = homeBarLongPressGuideActivity.getAssets().open(str2);
            try {
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpen);
                l9.b.a(inputStreamOpen, null);
                objB = Result.b(bitmapDecodeStream);
            } finally {
            }
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.g(TAG, "lottie image miss " + str2, thE, false, 8, null);
        }
        return (Bitmap) (Result.g(objB) ? null : objB);
    }

    public static final void n0(HomeBarLongPressGuideActivity homeBarLongPressGuideActivity, View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        homeBarLongPressGuideActivity.T();
    }

    public static final void o0(HomeBarLongPressGuideActivity homeBarLongPressGuideActivity, ValueAnimator it) {
        kotlin.jvm.internal.p.i(it, "it");
        if (homeBarLongPressGuideActivity.l0()) {
            C4872a c4872a = homeBarLongPressGuideActivity.binding;
            if (c4872a == null) {
                kotlin.jvm.internal.p.A("binding");
                c4872a = null;
            }
            float progress = c4872a.homebarGuideIllustration.getProgress();
            if (homeBarLongPressGuideActivity.lastIllustrationProgress > 0.85f && progress < 0.15f) {
                homeBarLongPressGuideActivity.q0();
            }
            homeBarLongPressGuideActivity.lastIllustrationProgress = progress;
        }
    }

    public static final void p0(HomeBarLongPressGuideActivity homeBarLongPressGuideActivity, LottieComposition lottieComposition) {
        homeBarLongPressGuideActivity.illustrationCompositionReady = true;
        homeBarLongPressGuideActivity.I0(true);
        homeBarLongPressGuideActivity.U0();
    }

    public static final a0 s0(HomeBarLongPressGuideActivity homeBarLongPressGuideActivity, View view, a0 insets) {
        kotlin.jvm.internal.p.i(view, "<unused var>");
        kotlin.jvm.internal.p.i(insets, "insets");
        int i10 = insets.f(a0.o.e()).f41980d;
        float f10 = homeBarLongPressGuideActivity.getResources().getDisplayMetrics().density;
        C4872a c4872a = homeBarLongPressGuideActivity.binding;
        if (c4872a == null) {
            kotlin.jvm.internal.p.A("binding");
            c4872a = null;
        }
        LinearLayout homebarGuideCapsule = c4872a.homebarGuideCapsule;
        kotlin.jvm.internal.p.h(homebarGuideCapsule, "homebarGuideCapsule");
        ViewGroup.LayoutParams layoutParams = homebarGuideCapsule.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = Math.max((int) (CAPSULE_MIN_BOTTOM_DP * f10), i10 + ((int) (f10 * 12.0f)));
        homebarGuideCapsule.setLayoutParams(bVar);
        return insets;
    }

    public static final Y8.t u0(View view, HomeBarLongPressGuideActivity homeBarLongPressGuideActivity) {
        view.removeCallbacks(homeBarLongPressGuideActivity.startContentAfterBackground);
        view.postDelayed(homeBarLongPressGuideActivity.startContentAfterBackground, 500L);
        return Y8.t.f7040a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void y0(HomeBarLongPressGuideActivity homeBarLongPressGuideActivity, InterfaceC5063a interfaceC5063a, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            interfaceC5063a = null;
        }
        homeBarLongPressGuideActivity.x0(interfaceC5063a);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void z0(com.stepos.ailauncher.chat.wake.homebar.HomeBarLongPressGuideActivity r5) {
        /*
            boolean r0 = r5.l0()
            if (r0 != 0) goto L7
            return
        L7:
            l5.a r5 = r5.binding
            r0 = 0
            if (r5 != 0) goto L12
            java.lang.String r5 = "binding"
            kotlin.jvm.internal.p.A(r5)
            r5 = r0
        L12:
            com.airbnb.lottie.LottieAnimationView r5 = r5.homebarGuideGlow
            java.lang.String r1 = "homebarGuideGlow"
            kotlin.jvm.internal.p.h(r5, r1)
            D5.a r1 = D5.a.INSTANCE
            java.lang.Class<com.stepos.ailauncher.contract.api.homebar.IHomeBarSysUiService> r2 = com.stepos.ailauncher.contract.api.homebar.IHomeBarSysUiService.class
            java.lang.Object r1 = r1.a(r2)
            com.stepos.ailauncher.contract.api.homebar.IHomeBarSysUiService r1 = (com.stepos.ailauncher.contract.api.homebar.IHomeBarSysUiService) r1
            r2 = 0
            if (r1 == 0) goto L2e
            boolean r1 = r1.notifyHomeBarLighted()
            r3 = 1
            if (r1 != r3) goto L2e
            goto L2f
        L2e:
            r3 = r2
        L2f:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = "play guide homebar glow sysUi="
            r1.append(r4)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r3 = 4
            java.lang.String r4 = "HomeBarLpGuide"
            h8.C4148a.k(r4, r1, r2, r3, r0)
            r0 = 1065353216(0x3f800000, float:1.0)
            r5.setAlpha(r0)
            r0 = 0
            r5.setProgress(r0)
            r5.playAnimation()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.wake.homebar.HomeBarLongPressGuideActivity.z0(com.stepos.ailauncher.chat.wake.homebar.HomeBarLongPressGuideActivity):void");
    }

    public final void A0() {
        Object objB;
        Bitmap bitmap;
        this.illustrationImageCache.clear();
        for (String str : ILLUSTRATION_PNGS) {
            String str2 = "homebar_guide/illustration/images/" + str;
            try {
                Result.Companion companion = Result.INSTANCE;
                InputStream inputStreamOpen = getAssets().open(str2);
                try {
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpen);
                    l9.b.a(inputStreamOpen, null);
                    objB = Result.b(bitmapDecodeStream);
                } finally {
                }
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            if (Result.h(objB) && (bitmap = (Bitmap) objB) != null) {
                this.illustrationImageCache.put(str, bitmap);
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.g(TAG, "preload illustration miss " + str2, thE, false, 8, null);
            }
        }
    }

    public final void B0() {
        C2851i7.INSTANCE.h(this.capsuleGlassHandle);
        this.capsuleGlassHandle = null;
    }

    public final void C0(LottieAnimationView view) {
        view.removeAllAnimatorListeners();
        view.removeAllUpdateListeners();
        view.removeAllLottieOnCompositionLoadedListener();
        view.animate().cancel();
        view.cancelAnimation();
        view.setImageAssetDelegate(null);
        view.setFailureListener(null);
        view.setImageDrawable(null);
    }

    public final void D0() {
        Iterator<T> it = this.springs.iterator();
        while (it.hasNext()) {
            ((androidx.dynamicanimation.animation.i) it.next()).d();
        }
        this.springs.clear();
        Animator animator = this.enterFade;
        if (animator != null) {
            animator.removeAllListeners();
        }
        Animator animator2 = this.enterFade;
        if (animator2 != null) {
            animator2.cancel();
        }
        this.enterFade = null;
        AnimatorSet animatorSet = this.exitFade;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
        }
        AnimatorSet animatorSet2 = this.exitFade;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        this.exitFade = null;
        C4872a c4872a = this.binding;
        if (c4872a == null) {
            return;
        }
        if (c4872a == null) {
            kotlin.jvm.internal.p.A("binding");
            c4872a = null;
        }
        LottieAnimationView homebarGuideGlow = c4872a.homebarGuideGlow;
        kotlin.jvm.internal.p.h(homebarGuideGlow, "homebarGuideGlow");
        C4872a c4872a2 = this.binding;
        if (c4872a2 == null) {
            kotlin.jvm.internal.p.A("binding");
            c4872a2 = null;
        }
        View homebarGuideTapExit = c4872a2.homebarGuideTapExit;
        kotlin.jvm.internal.p.h(homebarGuideTapExit, "homebarGuideTapExit");
        C4872a c4872a3 = this.binding;
        if (c4872a3 == null) {
            kotlin.jvm.internal.p.A("binding");
            c4872a3 = null;
        }
        c4872a3.homebarGuideScrim.animate().cancel();
        C4872a c4872a4 = this.binding;
        if (c4872a4 == null) {
            kotlin.jvm.internal.p.A("binding");
            c4872a4 = null;
        }
        c4872a4.homebarGuideHostBlur.animate().cancel();
        C4872a c4872a5 = this.binding;
        if (c4872a5 == null) {
            kotlin.jvm.internal.p.A("binding");
            c4872a5 = null;
        }
        c4872a5.homebarGuideCapsule.animate().cancel();
        C4872a c4872a6 = this.binding;
        if (c4872a6 == null) {
            kotlin.jvm.internal.p.A("binding");
            c4872a6 = null;
        }
        c4872a6.homebarGuideStill.animate().cancel();
        homebarGuideGlow.removeCallbacks(this.playGlow);
        C4872a c4872a7 = this.binding;
        if (c4872a7 == null) {
            kotlin.jvm.internal.p.A("binding");
            c4872a7 = null;
        }
        c4872a7.homebarGuideScrim.removeCallbacks(this.startContentAfterBackground);
        C4872a c4872a8 = this.binding;
        if (c4872a8 == null) {
            kotlin.jvm.internal.p.A("binding");
            c4872a8 = null;
        }
        c4872a8.homebarGuideIllustration.removeCallbacks(this.revealFollowLayers);
        homebarGuideTapExit.removeCallbacks(this.applyTapRegion);
        homebarGuideTapExit.removeOnLayoutChangeListener(this.tapLayoutListener);
        homebarGuideTapExit.setOnClickListener(null);
        I0(false);
        H0(false);
        J0(false);
        C4872a c4872a9 = this.binding;
        if (c4872a9 == null) {
            kotlin.jvm.internal.p.A("binding");
            c4872a9 = null;
        }
        LottieAnimationView homebarGuideIllustration = c4872a9.homebarGuideIllustration;
        kotlin.jvm.internal.p.h(homebarGuideIllustration, "homebarGuideIllustration");
        C0(homebarGuideIllustration);
        C0(homebarGuideGlow);
        this.illustrationImageCache.clear();
        C4872a c4872a10 = this.binding;
        if (c4872a10 == null) {
            kotlin.jvm.internal.p.A("binding");
            c4872a10 = null;
        }
        N.u0(c4872a10.b(), null);
    }

    public final void F0() {
        C4872a c4872a = this.binding;
        if (c4872a == null) {
            return;
        }
        C4872a c4872a2 = null;
        if (c4872a == null) {
            kotlin.jvm.internal.p.A("binding");
            c4872a = null;
        }
        ImageView homebarGuideStill = c4872a.homebarGuideStill;
        kotlin.jvm.internal.p.h(homebarGuideStill, "homebarGuideStill");
        C4872a c4872a3 = this.binding;
        if (c4872a3 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c4872a2 = c4872a3;
        }
        LottieAnimationView homebarGuideIllustration = c4872a2.homebarGuideIllustration;
        kotlin.jvm.internal.p.h(homebarGuideIllustration, "homebarGuideIllustration");
        homebarGuideIllustration.setAlpha(0.0f);
        homebarGuideIllustration.pauseAnimation();
        if (homebarGuideStill.getAlpha() <= 0.0f) {
            homebarGuideStill.setAlpha(1.0f);
        }
    }

    public final void G0() {
        if (l0()) {
            C4872a c4872a = this.binding;
            if (c4872a == null) {
                kotlin.jvm.internal.p.A("binding");
                c4872a = null;
            }
            LottieAnimationView homebarGuideGlow = c4872a.homebarGuideGlow;
            kotlin.jvm.internal.p.h(homebarGuideGlow, "homebarGuideGlow");
            homebarGuideGlow.removeCallbacks(this.playGlow);
            homebarGuideGlow.cancelAnimation();
            homebarGuideGlow.setProgress(0.0f);
            homebarGuideGlow.postDelayed(this.playGlow, 667L);
        }
    }

    public final void H0(boolean hidden) {
        C4872a c4872a = this.binding;
        if (c4872a == null) {
            return;
        }
        if (c4872a == null) {
            kotlin.jvm.internal.p.A("binding");
            c4872a = null;
        }
        c4872a.homebarGuideIllustration.addValueCallback(this.fingertipHighlightPath, (KeyPath) LottieProperty.TRANSFORM_OPACITY, (LottieValueCallback<KeyPath>) (hidden ? this.hideFingertipHighlight : this.showFingertipHighlight));
    }

    public final void I0(boolean hidden) {
        C4872a c4872a = this.binding;
        if (c4872a == null) {
            return;
        }
        if (c4872a == null) {
            kotlin.jvm.internal.p.A("binding");
            c4872a = null;
        }
        c4872a.homebarGuideIllustration.addValueCallback(this.pressGlowPath, (KeyPath) LottieProperty.TRANSFORM_OPACITY, (LottieValueCallback<KeyPath>) (hidden ? this.hidePressGlow : null));
    }

    public final void J0(boolean hidden) {
        C4872a c4872a = this.binding;
        if (c4872a == null) {
            return;
        }
        if (c4872a == null) {
            kotlin.jvm.internal.p.A("binding");
            c4872a = null;
        }
        c4872a.homebarGuideIllustration.addValueCallback(this.thumbPath, (KeyPath) LottieProperty.TRANSFORM_OPACITY, (LottieValueCallback<KeyPath>) (hidden ? this.hideThumb : this.showThumb));
    }

    public final void K0() {
        C4872a c4872a = this.binding;
        if (c4872a == null) {
            kotlin.jvm.internal.p.A("binding");
            c4872a = null;
        }
        View homebarGuideTapExit = c4872a.homebarGuideTapExit;
        kotlin.jvm.internal.p.h(homebarGuideTapExit, "homebarGuideTapExit");
        homebarGuideTapExit.setFocusable(true);
        homebarGuideTapExit.setFocusableInTouchMode(true);
        homebarGuideTapExit.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.wake.homebar.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeBarLongPressGuideActivity.L0(this.f26795a, view);
            }
        });
        homebarGuideTapExit.addOnLayoutChangeListener(this.tapLayoutListener);
        homebarGuideTapExit.post(this.applyTapRegion);
    }

    public final void O0() {
        if (l0()) {
            C4872a c4872a = this.binding;
            if (c4872a == null) {
                kotlin.jvm.internal.p.A("binding");
                c4872a = null;
            }
            LottieAnimationView homebarGuideIllustration = c4872a.homebarGuideIllustration;
            kotlin.jvm.internal.p.h(homebarGuideIllustration, "homebarGuideIllustration");
            homebarGuideIllustration.removeAllAnimatorListeners();
            homebarGuideIllustration.removeAllUpdateListeners();
            homebarGuideIllustration.addAnimatorListener(this.illustrationLoopListener);
            homebarGuideIllustration.addAnimatorUpdateListener(this.illustrationGlowFrameListener);
            this.homeBarGlowCycle = 1;
            this.lastLoopAtElapsed = 0L;
            this.lastIllustrationProgress = 0.0f;
            homebarGuideIllustration.playAnimation();
        }
    }

    public final void P0(View target, e.s property, float finalPosition, boolean exit, final InterfaceC5063a<Y8.t> onEnd) {
        androidx.dynamicanimation.animation.i iVarB = new androidx.dynamicanimation.animation.i(target, property, finalPosition).B(exit ? com.stepos.ailauncher.chat.wake.homebar.e.INSTANCE.c(finalPosition) : com.stepos.ailauncher.chat.wake.homebar.e.INSTANCE.a(finalPosition));
        if (onEnd != null) {
            iVarB.b(new e.q() { // from class: com.stepos.ailauncher.chat.wake.homebar.i
                @Override // androidx.dynamicanimation.animation.e.q
                public final void a(androidx.dynamicanimation.animation.e eVar, boolean z10, float f10, float f11) {
                    HomeBarLongPressGuideActivity.R0(this.f26786a, onEnd, eVar, z10, f10, f11);
                }
            });
        }
        this.springs.add(iVarB);
        iVarB.t();
    }

    public final void T() {
        C4872a c4872a;
        if (this.destroyed || this.exiting || (c4872a = this.binding) == null) {
            return;
        }
        if (c4872a == null) {
            kotlin.jvm.internal.p.A("binding");
            c4872a = null;
        }
        LinearLayout homebarGuideHostBlur = c4872a.homebarGuideHostBlur;
        kotlin.jvm.internal.p.h(homebarGuideHostBlur, "homebarGuideHostBlur");
        if (homebarGuideHostBlur.getWidth() <= 0 || homebarGuideHostBlur.getHeight() <= 0 || !homebarGuideHostBlur.isAttachedToWindow()) {
            return;
        }
        h0(homebarGuideHostBlur);
        float fD0 = d0();
        float fE = C5685n.e(homebarGuideHostBlur.getHeight(), 1.0f);
        for (int i10 = 0; i10 < 16; i10++) {
            View childAt = homebarGuideHostBlur.getChildAt(i10);
            if (childAt != null && childAt.getHeight() > 0) {
                float top = ((childAt.getTop() + (childAt.getHeight() / 2.0f)) / fE) * fD0;
                com.stepos.ailauncher.chat.wake.blur.c cVar = this.hostBandBlurs[i10];
                if (top < 0.02f || !cVar.f()) {
                    childAt.setAlpha(1.0f);
                    cVar.g();
                } else {
                    int iF = C5685n.f((int) Math.ceil(top), 1);
                    childAt.setAlpha(C5685n.m(top / iF, 0.02f, 1.0f));
                    cVar.d(childAt, new BlurConfig(iF, 0.0f, 0));
                }
            }
        }
    }

    public final void T0() {
        if (l0() && !this.backgroundEnterStarted && this.enterLayoutReady) {
            this.backgroundEnterStarted = true;
            t0();
        }
    }

    public final void U() {
        C4872a c4872a;
        Object objB;
        if (this.destroyed || (c4872a = this.binding) == null) {
            return;
        }
        if (c4872a == null) {
            kotlin.jvm.internal.p.A("binding");
            c4872a = null;
        }
        View homebarGuideTapExit = c4872a.homebarGuideTapExit;
        kotlin.jvm.internal.p.h(homebarGuideTapExit, "homebarGuideTapExit");
        if (homebarGuideTapExit.getWidth() <= 0 || homebarGuideTapExit.getHeight() <= 0) {
            return;
        }
        int[] iArr = new int[2];
        homebarGuideTapExit.getLocationInWindow(iArr);
        int i10 = iArr[0];
        boolean z10 = true;
        Region region = new Region(i10, iArr[1], homebarGuideTapExit.getWidth() + i10, iArr[1] + homebarGuideTapExit.getHeight());
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.flags = (attributes.flags | 32) & (-25);
        getWindow().setAttributes(attributes);
        try {
            Result.Companion companion = Result.INSTANCE;
            AttachedSurfaceControl rootSurfaceControl = homebarGuideTapExit.getRootSurfaceControl();
            if (rootSurfaceControl == null) {
                C4872a c4872a2 = this.binding;
                if (c4872a2 == null) {
                    kotlin.jvm.internal.p.A("binding");
                    c4872a2 = null;
                }
                rootSurfaceControl = c4872a2.b().getRootSurfaceControl();
            }
            if (rootSurfaceControl != null) {
                rootSurfaceControl.setTouchableRegion(region);
            } else {
                z10 = false;
            }
            objB = Result.b(Boolean.valueOf(z10));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "tap-exit touchable region failed", thE, false, 8, null);
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        if (!((Boolean) objB).booleanValue()) {
            C4148a.u(TAG, "tap-exit region not applied, keep pass-through", false, 4, null);
            getWindow().addFlags(16);
        }
        if (homebarGuideTapExit.hasFocus()) {
            return;
        }
        homebarGuideTapExit.requestFocus();
    }

    public final void U0() {
        if (l0() && !this.enterStarted && this.illustrationCompositionReady && this.enterLayoutReady && this.backgroundEnterDone) {
            this.enterStarted = true;
            w0();
        }
    }

    public final void W() {
        C4872a c4872a = this.binding;
        if (c4872a == null) {
            kotlin.jvm.internal.p.A("binding");
            c4872a = null;
        }
        LinearLayout homebarGuideCapsule = c4872a.homebarGuideCapsule;
        kotlin.jvm.internal.p.h(homebarGuideCapsule, "homebarGuideCapsule");
        if (!homebarGuideCapsule.isLaidOut() || homebarGuideCapsule.isLayoutRequested()) {
            homebarGuideCapsule.addOnLayoutChangeListener(new b(homebarGuideCapsule));
            return;
        }
        if (this.destroyed || this.exiting || !homebarGuideCapsule.isAttachedToWindow() || this.capsuleGlassHandle != null) {
            return;
        }
        float fMin = (Math.min(homebarGuideCapsule.getWidth(), homebarGuideCapsule.getHeight()) / 2.0f) / homebarGuideCapsule.getResources().getDisplayMetrics().density;
        if (fMin > 0.0f) {
            C2851i7 c2851i7 = C2851i7.INSTANCE;
            c2851i7.a(homebarGuideCapsule, fMin);
            this.capsuleGlassHandle = C2851i7.d(c2851i7, homebarGuideCapsule, false, Float.valueOf(fMin), null, 8, null);
            c2851i7.i(homebarGuideCapsule, this.capsuleGlassHandle, new c());
        }
    }

    public final void X() {
        C4872a c4872a = this.binding;
        if (c4872a == null) {
            kotlin.jvm.internal.p.A("binding");
            c4872a = null;
        }
        LinearLayout homebarGuideHostBlur = c4872a.homebarGuideHostBlur;
        kotlin.jvm.internal.p.h(homebarGuideHostBlur, "homebarGuideHostBlur");
        h0(homebarGuideHostBlur);
        homebarGuideHostBlur.addOnLayoutChangeListener(this.hostPageBlurLayoutListener);
        if (!homebarGuideHostBlur.isLaidOut() || homebarGuideHostBlur.isLayoutRequested()) {
            homebarGuideHostBlur.addOnLayoutChangeListener(new d());
        } else {
            T();
        }
    }

    public final void Y() {
        A0();
        C4872a c4872a = this.binding;
        C4872a c4872a2 = null;
        if (c4872a == null) {
            kotlin.jvm.internal.p.A("binding");
            c4872a = null;
        }
        LottieAnimationView homebarGuideIllustration = c4872a.homebarGuideIllustration;
        kotlin.jvm.internal.p.h(homebarGuideIllustration, "homebarGuideIllustration");
        Z(homebarGuideIllustration, ILLUSTRATION_JSON, ILLUSTRATION_IMAGES, ILLUSTRATION_FOLDER, this.illustrationImageCache);
        C4872a c4872a3 = this.binding;
        if (c4872a3 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c4872a2 = c4872a3;
        }
        LottieAnimationView homebarGuideGlow = c4872a2.homebarGuideGlow;
        kotlin.jvm.internal.p.h(homebarGuideGlow, "homebarGuideGlow");
        a0(this, homebarGuideGlow, GLOW_JSON, GLOW_IMAGES, GLOW_FOLDER, null, 16, null);
    }

    public final void Z(final LottieAnimationView view, final String jsonAsset, final String imageDir, String assetsFolder, final Map<String, Bitmap> imageCache) {
        view.setFailureListener(new LottieListener() { // from class: com.stepos.ailauncher.chat.wake.homebar.k
            @Override // com.airbnb.lottie.LottieListener
            public final void onResult(Object obj) {
                HomeBarLongPressGuideActivity.b0(jsonAsset, view, this, (Throwable) obj);
            }
        });
        view.setImageAssetsFolder(assetsFolder);
        view.setImageAssetDelegate(new ImageAssetDelegate() { // from class: com.stepos.ailauncher.chat.wake.homebar.l
            @Override // com.airbnb.lottie.ImageAssetDelegate
            public final Bitmap fetchBitmap(LottieImageAsset lottieImageAsset) {
                return HomeBarLongPressGuideActivity.c0(imageCache, imageDir, this, lottieImageAsset);
            }
        });
        view.setCacheComposition(false);
        view.setCacheComposition(false);
        view.setAnimation(jsonAsset);
    }

    public final float d0() {
        return getResources().getDisplayMetrics().density * 20.0f;
    }

    public final void e0() {
        C4872a c4872a = this.binding;
        if (c4872a != null) {
            if (c4872a == null) {
                kotlin.jvm.internal.p.A("binding");
                c4872a = null;
            }
            c4872a.homebarGuideHostBlur.removeOnLayoutChangeListener(this.hostPageBlurLayoutListener);
        }
        for (com.stepos.ailauncher.chat.wake.blur.c cVar : this.hostBandBlurs) {
            cVar.g();
        }
    }

    public final void f0() {
        InterfaceC5063a<Y8.t> interfaceC5063a = this.exitCallback;
        this.exitCallback = null;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    public final void g0(InterfaceC5063a<Y8.t> onFinished) {
        if (onFinished != null) {
            this.exitCallback = onFinished;
        }
        this.exiting = true;
        if (this.destroyed) {
            f0();
            return;
        }
        if (isFinishing()) {
            return;
        }
        C4872a c4872a = this.binding;
        if (c4872a != null) {
            C4872a c4872a2 = null;
            if (c4872a == null) {
                kotlin.jvm.internal.p.A("binding");
                c4872a = null;
            }
            c4872a.homebarGuideGlow.removeCallbacks(this.playGlow);
            C4872a c4872a3 = this.binding;
            if (c4872a3 == null) {
                kotlin.jvm.internal.p.A("binding");
                c4872a3 = null;
            }
            c4872a3.homebarGuideStill.removeCallbacks(this.startContentExit);
            C4872a c4872a4 = this.binding;
            if (c4872a4 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                c4872a2 = c4872a4;
            }
            c4872a2.homebarGuideIllustration.removeCallbacks(this.startContentExit);
        }
        finish();
        overridePendingTransition(0, 0);
    }

    public final void h0(LinearLayout layer) {
        if (layer.getChildCount() == 16) {
            return;
        }
        layer.removeAllViews();
        for (int i10 = 0; i10 < 10; i10++) {
            layer.addView(new View(layer.getContext()), new LinearLayout.LayoutParams(-1, 0, 0.05f));
        }
        for (int i11 = 0; i11 < 6; i11++) {
            layer.addView(new View(layer.getContext()), new LinearLayout.LayoutParams(-1, 0, 0.083333336f));
        }
    }

    public final ObjectAnimator i0(View target, TimeInterpolator interpolator) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(target, (Property<View, Float>) View.ALPHA, 0.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(500L);
        objectAnimatorOfFloat.setInterpolator(interpolator);
        kotlin.jvm.internal.p.h(objectAnimatorOfFloat, "apply(...)");
        return objectAnimatorOfFloat;
    }

    public final ObjectAnimator j0(View target, TimeInterpolator interpolator) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(target, (Property<View, Float>) View.ALPHA, target.getAlpha(), 0.0f);
        objectAnimatorOfFloat.setDuration(400L);
        objectAnimatorOfFloat.setInterpolator(interpolator);
        kotlin.jvm.internal.p.h(objectAnimatorOfFloat, "apply(...)");
        return objectAnimatorOfFloat;
    }

    public final void k0() {
        if (this.destroyed || isFinishing()) {
            return;
        }
        finish();
        overridePendingTransition(0, 0);
    }

    public final boolean l0() {
        return (this.destroyed || this.exiting || isFinishing() || this.binding == null) ? false : true;
    }

    public final PaintDrawable m0() {
        PaintDrawable paintDrawable = new PaintDrawable();
        paintDrawable.setShape(new RectShape());
        paintDrawable.setShaderFactory(new e());
        return paintDrawable;
    }

    @Override // androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        instance = new WeakReference<>(this);
        overridePendingTransition(0, 0);
        super.onCreate(savedInstanceState);
        C4872a c4872aC = C4872a.c(getLayoutInflater());
        kotlin.jvm.internal.p.h(c4872aC, "inflate(...)");
        this.binding = c4872aC;
        C4872a c4872a = null;
        if (c4872aC == null) {
            kotlin.jvm.internal.p.A("binding");
            c4872aC = null;
        }
        setContentView(c4872aC.b());
        Y.b(getWindow(), false);
        getWindow().addFlags(528);
        getWindow().setStatusBarColor(0);
        getWindow().setNavigationBarColor(0);
        C4872a c4872a2 = this.binding;
        if (c4872a2 == null) {
            kotlin.jvm.internal.p.A("binding");
            c4872a2 = null;
        }
        c4872a2.homebarGuideScrim.setForeground(m0());
        X();
        Y();
        r0();
        W();
        K0();
        getOnBackPressedDispatcher().m(this, new h());
        C4872a c4872a3 = this.binding;
        if (c4872a3 == null) {
            kotlin.jvm.internal.p.A("binding");
            c4872a3 = null;
        }
        c4872a3.homebarGuideIllustration.addLottieOnCompositionLoadedListener(new LottieOnCompositionLoadedListener() { // from class: com.stepos.ailauncher.chat.wake.homebar.u
            @Override // com.airbnb.lottie.LottieOnCompositionLoadedListener
            public final void onCompositionLoaded(LottieComposition lottieComposition) {
                HomeBarLongPressGuideActivity.p0(this.f26803a, lottieComposition);
            }
        });
        C4872a c4872a4 = this.binding;
        if (c4872a4 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c4872a = c4872a4;
        }
        ConstraintLayout constraintLayoutB = c4872a.b();
        kotlin.jvm.internal.p.h(constraintLayoutB, "getRoot(...)");
        if (!constraintLayoutB.isLaidOut() || constraintLayoutB.isLayoutRequested()) {
            constraintLayoutB.addOnLayoutChangeListener(new g());
            return;
        }
        this.enterLayoutReady = true;
        T0();
        U0();
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.r, android.app.Activity
    public void onDestroy() {
        this.destroyed = true;
        B0();
        D0();
        e0();
        WeakReference<HomeBarLongPressGuideActivity> weakReference = instance;
        if ((weakReference != null ? weakReference.get() : null) == this) {
            instance = null;
        }
        f0();
        com.stepos.ailauncher.chat.wake.homebar.g.INSTANCE.j();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.r, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.exiting) {
            return;
        }
        e0();
    }

    @Override // androidx.fragment.app.r, android.app.Activity
    public void onResume() {
        super.onResume();
        if (l0()) {
            X();
        }
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.r, android.app.Activity
    public void onStop() {
        super.onStop();
        if (!this.exiting || this.destroyed || isFinishing()) {
            return;
        }
        k0();
    }

    public final void q0() {
        if (l0()) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (jElapsedRealtime - this.lastLoopAtElapsed < 400) {
                return;
            }
            this.lastLoopAtElapsed = jElapsedRealtime;
            int i10 = this.homeBarGlowCycle + 1;
            this.homeBarGlowCycle = i10;
            if (i10 >= 2) {
                G0();
            }
        }
    }

    public final void r0() {
        C4872a c4872a = this.binding;
        C4872a c4872a2 = null;
        if (c4872a == null) {
            kotlin.jvm.internal.p.A("binding");
            c4872a = null;
        }
        N.u0(c4872a.b(), new androidx.core.view.A() { // from class: com.stepos.ailauncher.chat.wake.homebar.j
            @Override // androidx.core.view.A
            public final a0 a(View view, a0 a0Var) {
                return HomeBarLongPressGuideActivity.s0(this.f26788a, view, a0Var);
            }
        });
        C4872a c4872a3 = this.binding;
        if (c4872a3 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c4872a2 = c4872a3;
        }
        N.e0(c4872a2.b());
    }

    public final void t0() {
        if (l0()) {
            C4872a c4872a = this.binding;
            C4872a c4872a2 = null;
            if (c4872a == null) {
                kotlin.jvm.internal.p.A("binding");
                c4872a = null;
            }
            final View homebarGuideScrim = c4872a.homebarGuideScrim;
            kotlin.jvm.internal.p.h(homebarGuideScrim, "homebarGuideScrim");
            C4872a c4872a3 = this.binding;
            if (c4872a3 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                c4872a2 = c4872a3;
            }
            LinearLayout homebarGuideHostBlur = c4872a2.homebarGuideHostBlur;
            kotlin.jvm.internal.p.h(homebarGuideHostBlur, "homebarGuideHostBlur");
            homebarGuideScrim.setAlpha(0.0f);
            homebarGuideHostBlur.setAlpha(0.0f);
            e.s ALPHA = androidx.dynamicanimation.animation.e.f13701y;
            kotlin.jvm.internal.p.h(ALPHA, "ALPHA");
            Q0(this, homebarGuideHostBlur, ALPHA, 1.0f, false, null, 16, null);
            kotlin.jvm.internal.p.h(ALPHA, "ALPHA");
            P0(homebarGuideScrim, ALPHA, 1.0f, false, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.homebar.v
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return HomeBarLongPressGuideActivity.u0(homebarGuideScrim, this);
                }
            });
        }
    }

    public final void v0() {
        if (this.destroyed || isFinishing()) {
            k0();
            return;
        }
        F0();
        C4872a c4872a = this.binding;
        C4872a c4872a2 = null;
        if (c4872a == null) {
            kotlin.jvm.internal.p.A("binding");
            c4872a = null;
        }
        LinearLayout homebarGuideCapsule = c4872a.homebarGuideCapsule;
        kotlin.jvm.internal.p.h(homebarGuideCapsule, "homebarGuideCapsule");
        e.s ALPHA = androidx.dynamicanimation.animation.e.f13701y;
        kotlin.jvm.internal.p.h(ALPHA, "ALPHA");
        Q0(this, homebarGuideCapsule, ALPHA, 0.0f, true, null, 16, null);
        e.s SCALE_X = androidx.dynamicanimation.animation.e.f13693q;
        kotlin.jvm.internal.p.h(SCALE_X, "SCALE_X");
        Q0(this, homebarGuideCapsule, SCALE_X, 0.9f, true, null, 16, null);
        e.s SCALE_Y = androidx.dynamicanimation.animation.e.f13694r;
        kotlin.jvm.internal.p.h(SCALE_Y, "SCALE_Y");
        Q0(this, homebarGuideCapsule, SCALE_Y, 0.9f, true, null, 16, null);
        C4872a c4872a3 = this.binding;
        if (c4872a3 == null) {
            kotlin.jvm.internal.p.A("binding");
            c4872a3 = null;
        }
        ImageView homebarGuideStill = c4872a3.homebarGuideStill;
        kotlin.jvm.internal.p.h(homebarGuideStill, "homebarGuideStill");
        C4872a c4872a4 = this.binding;
        if (c4872a4 == null) {
            kotlin.jvm.internal.p.A("binding");
            c4872a4 = null;
        }
        LottieAnimationView homebarGuideGlow = c4872a4.homebarGuideGlow;
        kotlin.jvm.internal.p.h(homebarGuideGlow, "homebarGuideGlow");
        C4872a c4872a5 = this.binding;
        if (c4872a5 == null) {
            kotlin.jvm.internal.p.A("binding");
            c4872a5 = null;
        }
        View homebarGuideScrim = c4872a5.homebarGuideScrim;
        kotlin.jvm.internal.p.h(homebarGuideScrim, "homebarGuideScrim");
        C4872a c4872a6 = this.binding;
        if (c4872a6 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c4872a2 = c4872a6;
        }
        LinearLayout homebarGuideHostBlur = c4872a2.homebarGuideHostBlur;
        kotlin.jvm.internal.p.h(homebarGuideHostBlur, "homebarGuideHostBlur");
        AnimatorSet animatorSet = new AnimatorSet();
        com.stepos.ailauncher.chat.wake.homebar.e eVar = com.stepos.ailauncher.chat.wake.homebar.e.INSTANCE;
        animatorSet.playTogether(j0(homebarGuideStill, eVar.e()), j0(homebarGuideGlow, eVar.d()), j0(homebarGuideScrim, eVar.d()), j0(homebarGuideHostBlur, eVar.d()));
        animatorSet.addListener(new i());
        animatorSet.start();
        this.exitFade = animatorSet;
    }

    public final void w0() {
        if (l0()) {
            C4872a c4872a = this.binding;
            C4872a c4872a2 = null;
            if (c4872a == null) {
                kotlin.jvm.internal.p.A("binding");
                c4872a = null;
            }
            LinearLayout homebarGuideCapsule = c4872a.homebarGuideCapsule;
            kotlin.jvm.internal.p.h(homebarGuideCapsule, "homebarGuideCapsule");
            C4872a c4872a3 = this.binding;
            if (c4872a3 == null) {
                kotlin.jvm.internal.p.A("binding");
                c4872a3 = null;
            }
            LottieAnimationView homebarGuideIllustration = c4872a3.homebarGuideIllustration;
            kotlin.jvm.internal.p.h(homebarGuideIllustration, "homebarGuideIllustration");
            C4872a c4872a4 = this.binding;
            if (c4872a4 == null) {
                kotlin.jvm.internal.p.A("binding");
                c4872a4 = null;
            }
            ImageView homebarGuideStill = c4872a4.homebarGuideStill;
            kotlin.jvm.internal.p.h(homebarGuideStill, "homebarGuideStill");
            C4872a c4872a5 = this.binding;
            if (c4872a5 == null) {
                kotlin.jvm.internal.p.A("binding");
                c4872a5 = null;
            }
            LottieAnimationView homebarGuideGlow = c4872a5.homebarGuideGlow;
            kotlin.jvm.internal.p.h(homebarGuideGlow, "homebarGuideGlow");
            if (homebarGuideCapsule.getWidth() > 0 && homebarGuideCapsule.getHeight() > 0) {
                homebarGuideCapsule.setPivotX(homebarGuideCapsule.getWidth() / 2.0f);
                homebarGuideCapsule.setPivotY(homebarGuideCapsule.getHeight() / 2.0f);
            }
            homebarGuideCapsule.setAlpha(0.0f);
            homebarGuideCapsule.setScaleX(0.8f);
            homebarGuideCapsule.setScaleY(0.8f);
            homebarGuideStill.setAlpha(0.0f);
            homebarGuideIllustration.setAlpha(0.0f);
            homebarGuideIllustration.setScaleX(1.0f);
            homebarGuideIllustration.setScaleY(1.0f);
            homebarGuideIllustration.setProgress(0.0f);
            homebarGuideGlow.setAlpha(0.0f);
            homebarGuideGlow.setProgress(0.0f);
            I0(true);
            H0(true);
            J0(true);
            homebarGuideIllustration.removeCallbacks(this.revealFollowLayers);
            homebarGuideIllustration.postDelayed(this.revealFollowLayers, 166L);
            e.s ALPHA = androidx.dynamicanimation.animation.e.f13701y;
            kotlin.jvm.internal.p.h(ALPHA, "ALPHA");
            Q0(this, homebarGuideCapsule, ALPHA, 1.0f, false, null, 16, null);
            e.s SCALE_X = androidx.dynamicanimation.animation.e.f13693q;
            kotlin.jvm.internal.p.h(SCALE_X, "SCALE_X");
            Q0(this, homebarGuideCapsule, SCALE_X, 1.0f, false, null, 16, null);
            e.s SCALE_Y = androidx.dynamicanimation.animation.e.f13694r;
            kotlin.jvm.internal.p.h(SCALE_Y, "SCALE_Y");
            Q0(this, homebarGuideCapsule, SCALE_Y, 1.0f, false, null, 16, null);
            Animator animator = this.enterFade;
            if (animator != null) {
                animator.cancel();
            }
            ObjectAnimator objectAnimatorI0 = i0(homebarGuideIllustration, com.stepos.ailauncher.chat.wake.homebar.e.INSTANCE.e());
            objectAnimatorI0.addListener(new j());
            objectAnimatorI0.start();
            this.enterFade = objectAnimatorI0;
            O0();
            C4872a c4872a6 = this.binding;
            if (c4872a6 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                c4872a2 = c4872a6;
            }
            c4872a2.homebarGuideStill.setAlpha(0.0f);
        }
    }

    public final void x0(InterfaceC5063a<Y8.t> onFinished) {
        if (onFinished != null) {
            this.exitCallback = onFinished;
        }
        if (this.destroyed) {
            f0();
            return;
        }
        if (this.exiting || isFinishing()) {
            return;
        }
        this.exiting = true;
        getWindow().setBackgroundDrawableResource(R.color.transparent);
        e0();
        Iterator<T> it = this.springs.iterator();
        while (it.hasNext()) {
            ((androidx.dynamicanimation.animation.i) it.next()).d();
        }
        this.springs.clear();
        Animator animator = this.enterFade;
        if (animator != null) {
            animator.removeAllListeners();
        }
        Animator animator2 = this.enterFade;
        if (animator2 != null) {
            animator2.cancel();
        }
        C4872a c4872a = null;
        this.enterFade = null;
        C4872a c4872a2 = this.binding;
        if (c4872a2 == null) {
            kotlin.jvm.internal.p.A("binding");
            c4872a2 = null;
        }
        c4872a2.homebarGuideGlow.removeCallbacks(this.playGlow);
        C4872a c4872a3 = this.binding;
        if (c4872a3 == null) {
            kotlin.jvm.internal.p.A("binding");
            c4872a3 = null;
        }
        c4872a3.homebarGuideScrim.removeCallbacks(this.startContentAfterBackground);
        C4872a c4872a4 = this.binding;
        if (c4872a4 == null) {
            kotlin.jvm.internal.p.A("binding");
            c4872a4 = null;
        }
        c4872a4.homebarGuideIllustration.removeCallbacks(this.revealFollowLayers);
        C4872a c4872a5 = this.binding;
        if (c4872a5 == null) {
            kotlin.jvm.internal.p.A("binding");
            c4872a5 = null;
        }
        c4872a5.homebarGuideIllustration.animate().cancel();
        C4872a c4872a6 = this.binding;
        if (c4872a6 == null) {
            kotlin.jvm.internal.p.A("binding");
            c4872a6 = null;
        }
        c4872a6.homebarGuideIllustration.pauseAnimation();
        C4872a c4872a7 = this.binding;
        if (c4872a7 == null) {
            kotlin.jvm.internal.p.A("binding");
            c4872a7 = null;
        }
        c4872a7.homebarGuideGlow.pauseAnimation();
        I0(true);
        C4872a c4872a8 = this.binding;
        if (c4872a8 == null) {
            kotlin.jvm.internal.p.A("binding");
        } else {
            c4872a = c4872a8;
        }
        c4872a.homebarGuideStill.post(this.startContentExit);
    }
}

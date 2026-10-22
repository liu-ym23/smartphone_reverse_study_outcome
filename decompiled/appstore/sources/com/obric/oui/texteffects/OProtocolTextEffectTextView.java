package com.obric.oui.texteffects;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.BlendMode;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import bg.h;
import com.bytedance.apm.constant.CommonKey;
import com.obric.oui.texteffects.core.BlendSpec;
import com.obric.oui.texteffects.core.Direction;
import com.obric.oui.texteffects.core.TextSource;
import com.tmall.wireless.tangram.structure.card.FixCard;
import io.reactivex.annotations.SchedulerSupport;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.q;
import od.g;
import od.j;
import od.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001b\b&\u0018\u0000 \u001e2\u00020\u0001:\u0002\u008d\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J+\u0010\u001a\u001a\u00020\f*\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u0006*\u00020\u0015H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u0006*\u00020\u0015H\u0002¢\u0006\u0004\b\u001e\u0010\u001dJ\u0013\u0010!\u001a\u00020 *\u00020\u001fH\u0002¢\u0006\u0004\b!\u0010\"J\u0011\u0010$\u001a\u0004\u0018\u00010#H\u0004¢\u0006\u0004\b$\u0010%J\u0017\u0010(\u001a\u00020\f2\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\fH\u0016¢\u0006\u0004\b*\u0010\u0010J\u000f\u0010+\u001a\u00020\fH\u0014¢\u0006\u0004\b+\u0010\u0010J\u000f\u0010,\u001a\u00020\fH\u0014¢\u0006\u0004\b,\u0010\u0010J/\u00101\u001a\u00020\f2\u0006\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u0006H\u0014¢\u0006\u0004\b1\u00102J1\u00108\u001a\u00020\f2\b\u00104\u001a\u0004\u0018\u0001032\u0006\u00105\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u0006H\u0014¢\u0006\u0004\b8\u00109J\u0017\u0010:\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0016H\u0014¢\u0006\u0004\b:\u0010;JM\u0010B\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010=\u001a\u00020<2\b\b\u0002\u0010>\u001a\u00020\u00112\n\b\u0002\u0010?\u001a\u0004\u0018\u0001032\n\b\u0002\u0010@\u001a\u0004\u0018\u0001032\n\b\u0002\u0010A\u001a\u0004\u0018\u000103H\u0004¢\u0006\u0004\bB\u0010CJ3\u0010D\u001a\u00020\f2\n\b\u0002\u0010?\u001a\u0004\u0018\u0001032\n\b\u0002\u0010@\u001a\u0004\u0018\u0001032\n\b\u0002\u0010A\u001a\u0004\u0018\u000103H\u0004¢\u0006\u0004\bD\u0010EJ\u001f\u0010F\u001a\u00020\f2\u0006\u0010=\u001a\u00020<2\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\bF\u0010GJ\u000f\u0010H\u001a\u00020\fH\u0014¢\u0006\u0004\bH\u0010\u0010J'\u0010K\u001a\u00020\f2\u0006\u0010=\u001a\u00020<2\u0006\u0010J\u001a\u00020I2\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\bK\u0010LJ'\u0010Q\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010N\u001a\u00020M2\u0006\u0010P\u001a\u00020OH\u0014¢\u0006\u0004\bQ\u0010RJ\u001f\u0010-\u001a\u00020&2\u0006\u0010S\u001a\u00020&2\u0006\u0010T\u001a\u00020&H\u0014¢\u0006\u0004\b-\u0010UJc\u0010c\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010W\u001a\u00020V2\u0006\u0010Y\u001a\u00020X2\u0006\u0010Z\u001a\u00020&2\u0006\u0010[\u001a\u00020&2\u0006\u0010\\\u001a\u00020&2\u0006\u0010]\u001a\u00020&2\u0006\u0010_\u001a\u00020^2\b\u0010`\u001a\u0004\u0018\u00010 2\b\u0010b\u001a\u0004\u0018\u00010aH\u0014¢\u0006\u0004\bc\u0010dJ'\u0010g\u001a\u00020\f2\u0006\u0010W\u001a\u00020V2\u0006\u0010f\u001a\u00020e2\u0006\u0010Y\u001a\u00020XH\u0014¢\u0006\u0004\bg\u0010hJ\u001f\u0010j\u001a\u00020\f2\u0006\u0010W\u001a\u00020V2\u0006\u0010i\u001a\u00020\u001fH\u0014¢\u0006\u0004\bj\u0010kJ!\u0010l\u001a\u0004\u0018\u00010M2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010P\u001a\u00020OH\u0004¢\u0006\u0004\bl\u0010mJ\u0017\u0010.\u001a\u00020X2\u0006\u0010o\u001a\u00020nH\u0004¢\u0006\u0004\b.\u0010pJ\u0017\u0010q\u001a\u00020X2\u0006\u00104\u001a\u000203H\u0014¢\u0006\u0004\bq\u0010rJ\u001f\u0010s\u001a\u00020\u00112\u0006\u0010Y\u001a\u00020X2\u0006\u00104\u001a\u000203H\u0004¢\u0006\u0004\bs\u0010tJ\u0017\u0010v\u001a\u00020&2\u0006\u0010u\u001a\u00020&H\u0014¢\u0006\u0004\bv\u0010wJ\u000f\u0010x\u001a\u00020&H\u0004¢\u0006\u0004\bx\u0010yJ!\u0010|\u001a\u0004\u0018\u00010{2\u0006\u0010Y\u001a\u00020X2\u0006\u0010f\u001a\u00020zH\u0014¢\u0006\u0004\b|\u0010}J\u001c\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u007f2\u0006\u0010~\u001a\u00020&H\u0004¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\u0011\u0010\u0082\u0001\u001a\u00020\fH\u0004¢\u0006\u0005\b\u0082\u0001\u0010\u0010J\u001b\u0010\u0084\u0001\u001a\u00020I2\u0007\u0010\u0083\u0001\u001a\u00020IH\u0004¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J+\u0010\u0089\u0001\u001a\u00020&*\u00020O2\n\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0086\u00012\u0007\u0010\u0088\u0001\u001a\u00020&H\u0004¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001J\u0019\u0010\u008b\u0001\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0016H\u0014¢\u0006\u0005\b\u008b\u0001\u0010;R$\u0010\u008f\u0001\u001a\u000f\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&0\u008c\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R!\u0010\u0095\u0001\u001a\u00030\u0090\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0091\u0001\u0010\u0092\u0001\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001R\u001b\u0010\u0098\u0001\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0096\u0001\u0010\u0097\u0001R\u001b\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u0099\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bj\u0010\u009a\u0001R\u0016\u0010J\u001a\u00020I8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010*R\u001a\u0010\u009d\u0001\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b|\u0010\u009c\u0001R\u001a\u0010\u009e\u0001\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bq\u0010\u009c\u0001R\u001a\u0010\u009f\u0001\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b.\u0010\u009c\u0001R\u001b\u0010¡\u0001\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0082\u0001\u0010 \u0001R\u001a\u0010¢\u0001\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bx\u0010 \u0001R\u001a\u0010£\u0001\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bv\u0010 \u0001R*\u0010¨\u0001\u001a\u00020<2\u0007\u0010¤\u0001\u001a\u00020<8\u0004@BX\u0084\u000e¢\u0006\u0010\n\u0006\b\u0089\u0001\u0010¥\u0001\u001a\u0006\b¦\u0001\u0010§\u0001R'\u0010ª\u0001\u001a\u00020&2\u0007\u0010¤\u0001\u001a\u00020&8\u0004@BX\u0084\u000e¢\u0006\r\n\u0004\b\u001a\u0010B\u001a\u0005\b©\u0001\u0010yR\u001f\u0010¬\u0001\u001a\u00020<8\u0014X\u0094D¢\u0006\u0010\n\u0006\b\u008b\u0001\u0010¥\u0001\u001a\u0006\b«\u0001\u0010§\u0001R\u001c\u0010®\u0001\u001a\u00020&8\u0014X\u0094D¢\u0006\r\n\u0004\bc\u0010B\u001a\u0005\b\u00ad\u0001\u0010yR\u001c\u0010°\u0001\u001a\u00020&8\u0014X\u0094D¢\u0006\r\n\u0004\bQ\u0010B\u001a\u0005\b¯\u0001\u0010yR\u0017\u0010³\u0001\u001a\u00020I8DX\u0084\u0004¢\u0006\b\u001a\u0006\b±\u0001\u0010²\u0001¨\u0006´\u0001"}, d2 = {"Lcom/obric/oui/texteffects/OProtocolTextEffectTextView;", "Landroid/widget/TextView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lod/k;", "spec", "", "D", "(Lod/k;)V", "t", "()V", "", "keepFrame", "H", "(Z)V", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/Canvas;", "canvas", "left", "top", "m", "(Landroid/graphics/drawable/Drawable;Landroid/graphics/Canvas;II)V", "r", "(Landroid/graphics/drawable/Drawable;)I", "q", "Lcom/obric/oui/texteffects/core/BlendSpec;", "Landroid/graphics/BlendMode;", "K", "(Lcom/obric/oui/texteffects/core/BlendSpec;)Landroid/graphics/BlendMode;", "Lcom/obric/oui/texteffects/runtime/d;", "B", "()Lcom/obric/oui/texteffects/runtime/d;", "", "scale", "setDebugAnimationDurationScale", "(F)V", "J", "A", "onDetachedFromWindow", "w", "h", "oldw", "oldh", "onSizeChanged", "(IIII)V", "", "text", "start", "lengthBefore", "lengthAfter", "onTextChanged", "(Ljava/lang/CharSequence;III)V", "onDraw", "(Landroid/graphics/Canvas;)V", "", "effectName", "restart", "finalText", "oldText", "newText", "F", "(Lod/k;Ljava/lang/String;ZLjava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V", "L", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V", "z", "(Ljava/lang/String;Lod/k;)V", FixCard.FixStyle.KEY_Y, "", "playTimeMs", FixCard.FixStyle.KEY_X, "(Ljava/lang/String;JLod/k;)V", "Lod/b$b;", "layer", "Lcom/obric/oui/texteffects/runtime/c;", "frame", "p", "(Landroid/graphics/Canvas;Lod/b$b;Lcom/obric/oui/texteffects/runtime/c;)V", "translationX", "blurPx", "(FF)F", "Landroid/graphics/Paint;", "paint", "Lqd/c;", "cache", "layerLeft", "layerRight", "drawX", "scanProgress", "Lod/j$b;", "selector", "originalBlendMode", "Landroid/graphics/Xfermode;", "originalXfermode", "o", "(Landroid/graphics/Canvas;Landroid/graphics/Paint;Lqd/c;FFFFLod/j$b;Landroid/graphics/BlendMode;Landroid/graphics/Xfermode;)V", "Lod/e;", "fill", "e", "(Landroid/graphics/Paint;Lod/e;Lqd/c;)V", "blend", "d", "(Landroid/graphics/Paint;Lcom/obric/oui/texteffects/core/BlendSpec;)V", "s", "(Lod/k;Lcom/obric/oui/texteffects/runtime/c;)Lod/b$b;", "Lcom/obric/oui/texteffects/core/TextSource;", "source", "(Lcom/obric/oui/texteffects/core/TextSource;)Lqd/c;", "g", "(Ljava/lang/CharSequence;)Lqd/c;", "v", "(Lqd/c;Ljava/lang/CharSequence;)Z", "textWidth", "k", "(F)F", "j", "()F", "Lod/e$a;", "Landroid/graphics/LinearGradient;", "f", "(Lqd/c;Lod/e$a;)Landroid/graphics/LinearGradient;", "radiusPx", "Landroid/graphics/BlurMaskFilter;", "u", "(F)Landroid/graphics/BlurMaskFilter;", "i", "durationMs", "C", "(J)J", "Lod/d;", CommonKey.KEY_VALUE, "defaultDp", "l", "(Lcom/obric/oui/texteffects/runtime/c;Lod/d;F)F", "n", "Lkotlin/Function1;", "a", "Lkotlin/jvm/functions/Function1;", "dp", "Lqd/a;", "b", "Lkotlin/Lazy;", "getBlurFilterCache", "()Lqd/a;", "blurFilterCache", "c", "Lod/k;", "activeSpec", "Landroid/animation/ValueAnimator;", "Landroid/animation/ValueAnimator;", "animator", "Ljava/lang/CharSequence;", "finalTextOnEnd", "oldTextForEffect", "newTextForEffect", "Lqd/c;", "currentTextCache", "oldTextCache", "newTextCache", "<set-?>", "Ljava/lang/String;", "getActiveEffectName", "()Ljava/lang/String;", "activeEffectName", "getDebugAnimationDurationScale", "debugAnimationDurationScale", "getLogTag", "logTag", "getMaxBlurRadiusDp", "maxBlurRadiusDp", "getBlurFilterCacheGranularityPx", "blurFilterCacheGranularityPx", "getCurrentEffectPlayTimeMs", "()J", "currentEffectPlayTimeMs", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class OProtocolTextEffectTextView extends TextView {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final a f17284q = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1 f17285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f17286b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public k f17287c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ValueAnimator f17288d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f17289e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CharSequence f17290f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CharSequence f17291g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CharSequence f17292h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public qd.c f17293i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public qd.c f17294j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public qd.c f17295k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f17296l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f17297m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f17298n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final float f17299o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final float f17300p;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17301a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f17302b = null;

        static {
            int[] r10 = new int[TextSource.values().length];
            r10[TextSource.Current.ordinal()] = 1;
            r10[TextSource.Old.ordinal()] = 2;
            r10[TextSource.New.ordinal()] = 3;
            f17301a = r10;
            int[] r11 = new int[BlendSpec.values().length];
            r11[BlendSpec.CLEAR.ordinal()] = 1;
            r11[BlendSpec.SRC.ordinal()] = 2;
            r11[BlendSpec.DST.ordinal()] = 3;
            r11[BlendSpec.SRC_OVER.ordinal()] = 4;
            r11[BlendSpec.DST_OVER.ordinal()] = 5;
            r11[BlendSpec.SRC_IN.ordinal()] = 6;
            r11[BlendSpec.DST_IN.ordinal()] = 7;
            r11[BlendSpec.SRC_OUT.ordinal()] = 8;
            r11[BlendSpec.DST_OUT.ordinal()] = 9;
            r11[BlendSpec.SRC_ATOP.ordinal()] = 10;
            r11[BlendSpec.DST_ATOP.ordinal()] = 11;
            r11[BlendSpec.XOR.ordinal()] = 12;
            r11[BlendSpec.PLUS.ordinal()] = 13;
            r11[BlendSpec.MODULATE.ordinal()] = 14;
            r11[BlendSpec.SCREEN.ordinal()] = 15;
            r11[BlendSpec.OVERLAY.ordinal()] = 16;
            r11[BlendSpec.DARKEN.ordinal()] = 17;
            r11[BlendSpec.LIGHTEN.ordinal()] = 18;
            r11[BlendSpec.COLOR_DODGE.ordinal()] = 19;
            r11[BlendSpec.COLOR_BURN.ordinal()] = 20;
            r11[BlendSpec.HARD_LIGHT.ordinal()] = 21;
            r11[BlendSpec.SOFT_LIGHT.ordinal()] = 22;
            r11[BlendSpec.DIFFERENCE.ordinal()] = 23;
            r11[BlendSpec.EXCLUSION.ordinal()] = 24;
            r11[BlendSpec.MULTIPLY.ordinal()] = 25;
            r11[BlendSpec.HUE.ordinal()] = 26;
            r11[BlendSpec.SATURATION.ordinal()] = 27;
            r11[BlendSpec.COLOR.ordinal()] = 28;
            r11[BlendSpec.LUMINOSITY.ordinal()] = 29;
            f17302b = r11;
        }
    }

    public static final class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref$BooleanRef f17303a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OProtocolTextEffectTextView f17304b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ k f17305c;

        public c(Ref$BooleanRef r10, OProtocolTextEffectTextView r11, k r12) {
            this.f17303a = r10;
            this.f17304b = r11;
            this.f17305c = r12;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r10) {
            q.g(r10, "animation");
            this.f17303a.element = true;
            e r11 = e.f17314a;
            String r12 = this.f17304b.getLogTag();
            k r13 = this.f17305c;
            if (e.a() == false) goto L6;
            Log.d(q.p("OUITextEffects/", r12), q.p("animator cancel spec=", r13.b()));
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            q.g(r10, "animation");
            e r11 = e.f17314a;
            String r12 = this.f17304b.getLogTag();
            k r13 = this.f17305c;
            Ref$BooleanRef r14 = this.f17303a;
            if (e.a() == false) goto L6;
            Log.d(q.p("OUITextEffects/", r12), "animator end spec=" + r13.b() + ", canceled=" + r14.element);
        L6:
            if (this.f17303a.element == false) goto L8;
            return;
        L8:
            if (q.b(this.f17305c.c(), g.a.f22581a) == true) goto L12;
            OProtocolTextEffectTextView.b(this.f17304b);
            return;
        }
    }

    static {
        f17284q = new a(null);
    }

    @JvmOverloads
    public OProtocolTextEffectTextView(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public static final void E(OProtocolTextEffectTextView r10, k r11, ValueAnimator r12) {
        q.g(r10, "this$0");
        q.g(r11, "$spec");
        q.g(r12, "valueAnimator");
        r10.f17289e = (long) (r12.getAnimatedFraction() * r11.a());
        e r13 = e.f17314a;
        String r14 = r10.getLogTag();
        if (e.a() == true) goto L5;
    L7:
        r10.x(r10.f17296l, r10.f17289e, r11);
        r10.invalidate();
        return;
    L5:
        if (e.b() == false) goto L7;
        Log.d(q.p("OUITextEffects/", r14), "animator update spec=" + r11.b() + ", playTime=" + r10.f17289e);
        goto L7
    }

    public static /* synthetic */ void G(OProtocolTextEffectTextView r10, k r11, String r12, boolean r13, CharSequence r14, CharSequence r15, CharSequence r16, int r17, Object r18) {
        if (r18 != null) goto L21;
        if ((r17 & 4) == 0) goto L6;
        r13 = false;
    L6:
        boolean r19 = r13;
        if ((r17 & 8) == 0) goto L9;
        CharSequence r20 = null;
    L11:
        if ((r17 & 16) == 0) goto L13;
        CharSequence r21 = null;
    L15:
        if ((r17 & 32) == 0) goto L17;
        CharSequence r22 = null;
    L18:
        r10.F(r11, r12, r19, r20, r21, r22);
        return;
    L17:
        r22 = r16;
        goto L18
    L13:
        r21 = r15;
        goto L15
    L9:
        r20 = r14;
        goto L11
    L21:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startTextEffect");
    }

    public static /* synthetic */ void I(OProtocolTextEffectTextView r10, boolean r11, int r12, Object r13) {
        if (r13 != null) goto L9;
        if ((r12 & 1) == 0) goto L6;
        r11 = false;
    L6:
        r10.H(r11);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stopAnimator");
    }

    public static /* synthetic */ void M(OProtocolTextEffectTextView r10, CharSequence r11, CharSequence r12, CharSequence r13, int r14, Object r15) {
        if (r15 != null) goto L15;
        if ((r14 & 1) == 0) goto L7;
        r11 = r10.f17290f;
    L7:
        if ((r14 & 2) == 0) goto L10;
        r12 = r10.f17291g;
    L10:
        if ((r14 & 4) == 0) goto L12;
        r13 = r10.f17292h;
    L12:
        r10.L(r11, r12, r13);
        return;
    L15:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateTextEffectSnapshots");
    }

    public static /* synthetic */ void a(OProtocolTextEffectTextView r10, k r11, ValueAnimator r12) {
        E(r10, r11, r12);
    }

    public static final /* synthetic */ void b(OProtocolTextEffectTextView r10) {
        r10.t();
    }

    public static final /* synthetic */ Function1 c(OProtocolTextEffectTextView r10) {
        return r10.f17285a;
    }

    private final qd.a getBlurFilterCache() {
        return (qd.a) this.f17286b.getValue();
    }

    public void A() {
    }

    public final com.obric.oui.texteffects.runtime.d B() {
        k r10 = this.f17287c;
        if (r10 != null) goto L7;
        return null;
    L7:
        return com.obric.oui.texteffects.runtime.e.f17347a.l(r10, this.f17289e);
    }

    public final long C(long r10) {
        return h.d(yf.b.b(r10 * this.f17297m), 1);
    }

    public final void D(final k r10) {
        Ref$BooleanRef r11 = new Ref$BooleanRef();
        ValueAnimator r12 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r12.setDuration(C(r10.a()));
        r12.setInterpolator(new LinearInterpolator());
        if (q.b(r10.c(), g.a.f22581a) == false) goto L5;
        int r13 = -1;
    L6:
        r12.setRepeatCount(r13);
        r12.setRepeatMode(1);
        r12.addUpdateListener(new d(this, r10));
        r12.addListener(new c(r11, this, r10));
        r12.start();
        this.f17288d = r12;
        return;
    L5:
        r13 = 0;
        goto L6
    }

    public final void F(k r10, String r11, boolean r12, CharSequence r13, CharSequence r14, CharSequence r15) {
        q.g(r10, "spec");
        q.g(r11, "effectName");
        e r16 = e.f17314a;
        String r17 = getLogTag();
        if (e.a() == false) goto L6;
        Log.d(q.p("OUITextEffects/", r17), "startTextEffect id=" + r10.b() + ", effect=" + r11 + ", duration=" + r10.a() + ", loop=" + r10.c() + ", restart=" + r12 + ", finalText=" + r13);
    L6:
        if (r12 == true) goto L8;
        I(this, false, 1, null);
    L9:
        this.f17287c = r10;
        this.f17296l = r11;
        this.f17289e = 0;
        this.f17290f = r13;
        this.f17291g = r14;
        this.f17292h = r15;
        this.f17294j = null;
        this.f17295k = null;
        z(r11, r10);
        D(r10);
        invalidate();
        return;
    L8:
        H(true);
        goto L9
    }

    public final void H(boolean r10) {
        if (this.f17288d == null) goto L7;
        e r11 = e.f17314a;
        String r12 = getLogTag();
        if (e.a() == false) goto L7;
        Log.d(q.p("OUITextEffects/", r12), q.p("stopAnimator keepFrame=", Boolean.valueOf(r10)));
    L7:
        ValueAnimator r13 = this.f17288d;
        if (r13 == null) goto L11;
        r13.cancel();
    L11:
        this.f17288d = null;
        if (r10 == true) goto L15;
        this.f17289e = 0;
        return;
    }

    public void J() {
        e r10 = e.f17314a;
        String r11 = getLogTag();
        if (e.a() == false) goto L5;
        Log.d(q.p("OUITextEffects/", r11), q.p("stopEffect effect=", getActiveEffectName()));
    L5:
        I(this, false, 1, null);
        this.f17287c = null;
        this.f17296l = SchedulerSupport.NONE;
        this.f17289e = 0;
        this.f17290f = null;
        this.f17291g = null;
        this.f17292h = null;
        this.f17294j = null;
        this.f17295k = null;
        A();
        invalidate();
    }

    public final BlendMode K(BlendSpec r10) {
        switch(b.f17302b[r10.ordinal()]) {
            case 1: goto L35;
            case 2: goto L63;
            case 3: goto L62;
            case 4: goto L61;
            case 5: goto L60;
            case 6: goto L59;
            case 7: goto L58;
            case 8: goto L57;
            case 9: goto L56;
            case 10: goto L55;
            case 11: goto L54;
            case 12: goto L53;
            case 13: goto L52;
            case 14: goto L51;
            case 15: goto L50;
            case 16: goto L49;
            case 17: goto L48;
            case 18: goto L47;
            case 19: goto L46;
            case 20: goto L45;
            case 21: goto L44;
            case 22: goto L43;
            case 23: goto L42;
            case 24: goto L41;
            case 25: goto L40;
            case 26: goto L39;
            case 27: goto L38;
            case 28: goto L37;
            case 29: goto L36;
            default: goto L5;
        };
    L5:
        throw new NoWhenBranchMatchedException();
    L36:
        return BlendMode.LUMINOSITY;
    L37:
        return BlendMode.COLOR;
    L38:
        return BlendMode.SATURATION;
    L39:
        return BlendMode.HUE;
    L40:
        return BlendMode.MULTIPLY;
    L41:
        return BlendMode.EXCLUSION;
    L42:
        return BlendMode.DIFFERENCE;
    L43:
        return BlendMode.SOFT_LIGHT;
    L44:
        return BlendMode.HARD_LIGHT;
    L45:
        return BlendMode.COLOR_BURN;
    L46:
        return BlendMode.COLOR_DODGE;
    L47:
        return BlendMode.LIGHTEN;
    L48:
        return BlendMode.DARKEN;
    L49:
        return BlendMode.OVERLAY;
    L50:
        return BlendMode.SCREEN;
    L51:
        return BlendMode.MODULATE;
    L52:
        return BlendMode.PLUS;
    L53:
        return BlendMode.XOR;
    L54:
        return BlendMode.DST_ATOP;
    L55:
        return BlendMode.SRC_ATOP;
    L56:
        return BlendMode.DST_OUT;
    L57:
        return BlendMode.SRC_OUT;
    L58:
        return BlendMode.DST_IN;
    L59:
        return BlendMode.SRC_IN;
    L60:
        return BlendMode.DST_OVER;
    L61:
        return BlendMode.SRC_OVER;
    L62:
        return BlendMode.DST;
    L63:
        return BlendMode.SRC;
    L35:
        return BlendMode.CLEAR;
    }

    public final void L(CharSequence r10, CharSequence r11, CharSequence r12) {
        this.f17290f = r10;
        this.f17291g = r11;
        this.f17292h = r12;
        this.f17294j = null;
        this.f17295k = null;
        invalidate();
    }

    public void d(Paint r10, BlendSpec r11) {
        q.g(r10, "paint");
        q.g(r11, "blend");
        if (r11 != BlendSpec.SRC_OVER) goto L6;
        r10.setBlendMode(null);
        return;
    L6:
        r10.setBlendMode(K(r11));
    }

    public void e(Paint r10, od.e r11, qd.c r12) {
        q.g(r10, "paint");
        q.g(r11, "fill");
        q.g(r12, "cache");
        if (q.b(r11, od.e.b.f22578a) == false) goto L6;
        r10.setShader(null);
        r10.setColor(getCurrentTextColor());
        return;
    L6:
        if ((r11 instanceof od.e.a) == false) goto L10;
        r10.setShader(f(r12, (od.e.a) r11));
        return;
    }

    public LinearGradient f(qd.c r10, od.e.a r11) {
        q.g(r10, "cache");
        q.g(r11, "fill");
        if (r10.b() > 0.01f) goto L6;
        return null;
    L6:
        float r12 = r10.a();
        return new LinearGradient(r12, 0.0f, r12 + r10.b(), 0.0f, r11.a(), r11.b(), Shader.TileMode.CLAMP);
    }

    public qd.c g(CharSequence r10) {
        q.g(r10, "text");
        qd.d r11 = qd.d.f23654a;
        TextPaint r12 = getPaint();
        q.f(r12, "paint");
        return r11.a(r10, r12, j(), getEllipsize(), new OProtocolTextEffectTextView$buildTextCache$1(this), OProtocolTextEffectTextView$buildTextCache$2.INSTANCE);
    }

    @NotNull
    public final String getActiveEffectName() {
        return this.f17296l;
    }

    public float getBlurFilterCacheGranularityPx() {
        return this.f17300p;
    }

    public final long getCurrentEffectPlayTimeMs() {
        return this.f17289e;
    }

    public final float getDebugAnimationDurationScale() {
        return this.f17297m;
    }

    @NotNull
    public String getLogTag() {
        return this.f17298n;
    }

    public float getMaxBlurRadiusDp() {
        return this.f17299o;
    }

    public final qd.c h(TextSource r10) {
        q.g(r10, "source");
        int r11 = b.f17301a[r10.ordinal()];
        CharSequence r12 = "";
        qd.c r13 = null;
        if (r11 != 1) goto L5;
        CharSequence r14 = getText();
        if (r14 == null) goto L46;
        r12 = r14;
    L46:
        qd.c r15 = this.f17293i;
        if (r15 != null) goto L50;
    L52:
        if (r13 != null) goto L56;
        r13 = g(r12);
        this.f17293i = r13;
        e r16 = e.f17314a;
        String r17 = getLogTag();
        if (e.a() == false) goto L56;
        Log.d(q.p("OUITextEffects/", r17), "build current text cache, text=" + r12 + ", width=" + r13.b());
    L56:
        return r13;
    L50:
        if (v(r15, r12) == false) goto L52;
        r13 = r15;
        goto L52
    L5:
        if (r11 != 2) goto L7;
        CharSequence r18 = this.f17291g;
        if (r18 != null) goto L29;
        r18 = getText();
    L29:
        if (r18 == null) goto L32;
        r12 = r18;
    L32:
        qd.c r19 = this.f17294j;
        if (r19 != null) goto L36;
    L38:
        if (r13 != null) goto L56;
        r13 = g(r12);
        this.f17294j = r13;
        e r20 = e.f17314a;
        String r21 = getLogTag();
        if (e.a() == false) goto L56;
        Log.d(q.p("OUITextEffects/", r21), "build old text cache, text=" + r12 + ", width=" + r13.b());
        goto L56
    L36:
        if (v(r19, r12) == false) goto L38;
        r13 = r19;
        goto L38
    L7:
        if (r11 != 3) goto L25;
        CharSequence r22 = this.f17292h;
        if (r22 != null) goto L11;
        r22 = getText();
    L11:
        if (r22 == null) goto L14;
        r12 = r22;
    L14:
        qd.c r23 = this.f17295k;
        if (r23 != null) goto L18;
    L20:
        if (r13 != null) goto L56;
        r13 = g(r12);
        this.f17295k = r13;
        e r24 = e.f17314a;
        String r25 = getLogTag();
        if (e.a() == false) goto L56;
        Log.d(q.p("OUITextEffects/", r25), "build new text cache, text=" + r12 + ", width=" + r13.b());
        goto L56
    L18:
        if (v(r23, r12) == false) goto L20;
        r13 = r23;
        goto L20
    L25:
        throw new NoWhenBranchMatchedException();
    }

    public final void i() {
        this.f17293i = null;
        this.f17294j = null;
        this.f17295k = null;
    }

    public final float j() {
        return h.c((getWidth() - getCompoundPaddingLeft()) - getCompoundPaddingRight(), 0.0f);
    }

    public float k(float r10) {
        float r11 = j();
        int r12 = getGravity() & 7;
        float r13 = getCompoundPaddingLeft();
        if (r12 != 1) goto L5;
        float r14 = (r11 - r10) / 2.0f;
    L12:
        return r13 + r14;
    L5:
        if (r12 != 5) goto L7;
    L9:
        r14 = r11 - r10;
        goto L12
    L7:
        if (r12 == 8388613) goto L9;
        return r13;
    }

    public final float l(com.obric.oui.texteffects.runtime.c r10, od.d r11, float r12) {
        q.g(r10, "<this>");
        if ((r11 instanceof od.d.a) == false) goto L6;
        return ((Number) this.f17285a.invoke(Float.valueOf(((od.d.a) r11).a()))).floatValue();
    L6:
        if ((r11 instanceof od.d.b) == false) goto L9;
        return ((od.d.b) r11).a();
    L9:
        return ((Number) this.f17285a.invoke(Float.valueOf(r12))).floatValue();
    }

    public final void m(Drawable r10, Canvas r11, int r12, int r13) {
        int r14 = r11.save();
        r11.translate(r12, r13);     // Catch: Throwable -> L6
        r10.draw(r11);     // Catch: Throwable -> L6
        r11.restoreToCount(r14);
        return;
    L6:
        th = move-exception;
        r11.restoreToCount(r14);
        throw th;
    }

    public void n(Canvas r10) {
        q.g(r10, "canvas");
        Drawable[] r11 = getCompoundDrawables();
        q.f(r11, "compoundDrawables");
        int r12 = getCompoundPaddingLeft();
        int r13 = getCompoundPaddingTop();
        int r14 = getWidth() - getCompoundPaddingRight();
        int r15 = getHeight() - getCompoundPaddingBottom();
        int r16 = h.d(r14 - r12, 0);
        int r17 = h.d(r15 - r13, 0);
        Drawable r18 = r11[0];
        if (r18 == null) goto L6;
        m(r18, r10, getPaddingLeft(), ((r17 - q(r18)) / 2) + r13);
    L6:
        Drawable r19 = r11[1];
        if (r19 == null) goto L10;
        m(r19, r10, ((r16 - r(r19)) / 2) + r12, getPaddingTop());
    L10:
        Drawable r20 = r11[2];
        if (r20 == null) goto L14;
        m(r20, r10, (getWidth() - getPaddingRight()) - r(r20), r13 + ((r17 - q(r20)) / 2));
    L14:
        Drawable r21 = r11[3];
        if (r21 == null) goto L19;
        m(r21, r10, r12 + ((r16 - r(r21)) / 2), (getHeight() - getPaddingBottom()) - q(r21));
        return;
    }

    public void o(Canvas r16, Paint r17, qd.c r18, float r19, float r20, float r21, float r22, j.b r23, BlendMode r24, Xfermode r25) {
        q.g(r16, "canvas");
        q.g(r17, "paint");
        q.g(r18, "cache");
        q.g(r23, "selector");
        float r10 = r21 + (r18.b() * r22);
        float r11 = h.c(r18.b() * r23.b(), ((Number) this.f17285a.invoke(Float.valueOf(r23.d()))).floatValue());
        e r12 = e.f17314a;
        String r13 = getLogTag();
        if (e.a() == true) goto L5;
    L7:
        qd.b r14 = qd.b.f23637a;
        Paint r15 = r14.a(r17);
        float r26 = getBaseline();
        float r110 = r10 + r11;
        float r111 = getHeight();
        if (r23.c() == Direction.RightToLeft) goto L11;
        boolean r27 = true;
    L12:
        r14.c(r16, r19, r20, r15, r17, r18, r21, r26, r10, r110, r111, r27, r24, r25);
        return;
    L11:
        r27 = false;
        goto L12
    L5:
        if (e.b() == false) goto L7;
        Log.d(q.p("OUITextEffects/", r13), "drawScanLayer progress=" + r22 + ", scanX=" + r10 + ", featherWidth=" + r11 + ", direction=" + r23.a());
        goto L7
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        e r10 = e.f17314a;
        String r11 = getLogTag();
        if (e.a() == false) goto L5;
        Log.d(q.p("OUITextEffects/", r11), "onDetachedFromWindow, clear animator and blur cache");
    L5:
        J();
        getBlurFilterCache().a();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas r10) {
        q.g(r10, "canvas");
        k r11 = this.f17287c;
        if (r11 != null) goto L6;
        super.onDraw(r10);
        return;
    L6:
        com.obric.oui.texteffects.runtime.d r12 = com.obric.oui.texteffects.runtime.e.f17347a.l(r11, this.f17289e);
        e r13 = e.f17314a;
        String r14 = getLogTag();
        if (e.a() == true) goto L9;
    L11:
        n(r10);
        int r15 = r10.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null);
        Iterator r16 = r12.a().iterator();     // Catch: Throwable -> L20
    L14:
        if (r16.hasNext() == false) goto L22;
        com.obric.oui.texteffects.runtime.c r17 = (com.obric.oui.texteffects.runtime.c) r16.next();     // Catch: Throwable -> L20
        od.b.C0328b r18 = s(r11, r17);     // Catch: Throwable -> L20
        if (r18 == null) goto L14;
        p(r10, r18, r17);     // Catch: Throwable -> L20
        goto L14
    L22:
        r10.restoreToCount(r15);
        return;
    L20:
        th = move-exception;
        r10.restoreToCount(r15);
        throw th;
    L9:
        if (e.b() == false) goto L11;
        Log.d(q.p("OUITextEffects/", r14), "onDraw effect=" + getActiveEffectName() + ", spec=" + r11.b() + ", playTime=" + this.f17289e + ", layers=" + r12.a().size());
        goto L11
    }

    @Override // android.view.View
    public void onSizeChanged(int r10, int r11, int r12, int r13) {
        super.onSizeChanged(r10, r11, r12, r13);
        e r14 = e.f17314a;
        String r15 = getLogTag();
        if (e.a() == false) goto L5;
        Log.d(q.p("OUITextEffects/", r15), "onSizeChanged " + r12 + " x " + r13 + " -> " + r10 + " x " + r11 + ", clear text caches");
    L5:
        i();
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence r10, int r11, int r12, int r13) {
        super.onTextChanged(r10, r11, r12, r13);
        this.f17293i = null;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 8591. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:99)
        */
    public void p(android.graphics.Canvas r39, od.b.C0328b r40, com.obric.oui.texteffects.runtime.c r41) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001b: INVOKE (r15v0 ?? I:qd.c) = 
              (r38v0 'this' ?? I:com.obric.oui.texteffects.OProtocolTextEffectTextView A[IMMUTABLE_TYPE, THIS])
              (r2v3 com.obric.oui.texteffects.core.TextSource)
             VIRTUAL call: com.obric.oui.texteffects.OProtocolTextEffectTextView.h(com.obric.oui.texteffects.core.TextSource):qd.c A[DECLARE_VAR, MD:(com.obric.oui.texteffects.core.TextSource):qd.c (m)] in method: com.obric.oui.texteffects.OProtocolTextEffectTextView.p(android.graphics.Canvas, od.b$b, com.obric.oui.texteffects.runtime.c):void, file: classes4.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 859
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.obric.oui.texteffects.OProtocolTextEffectTextView.p(android.graphics.Canvas, od.b$b, com.obric.oui.texteffects.runtime.c):void");
    }

    public final int q(Drawable r10) {
        Integer r11 = Integer.valueOf(r10.getBounds().height());
        if (r11.intValue() > 0) goto L6;
        r11 = null;
    L6:
        if (r11 != null) goto L9;
        return h.d(r10.getIntrinsicHeight(), 0);
    L9:
        return r11.intValue();
    }

    public final int r(Drawable r10) {
        Integer r11 = Integer.valueOf(r10.getBounds().width());
        if (r11.intValue() > 0) goto L6;
        r11 = null;
    L6:
        if (r11 != null) goto L9;
        return h.d(r10.getIntrinsicWidth(), 0);
    L9:
        return r11.intValue();
    }

    public final od.b.C0328b s(k r10, com.obric.oui.texteffects.runtime.c r11) {
        q.g(r10, "spec");
        q.g(r11, "frame");
        Iterator r12 = r10.d().iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        Object r13 = r12.next();
        if (q.b(((od.c) r13).b(), r11.g()) == false) goto L4;
    L9:
        od.c r14 = (od.c) r13;
        if (r14 != null) goto L12;
        return null;
    L12:
        Iterator r15 = r14.c().iterator();
    L14:
        if (r15.hasNext() == false) goto L18;
        Object r16 = r15.next();
        if (q.b(((od.b) r16).a(), r11.e()) == false) goto L14;
    L20:
        if ((r16 instanceof od.b.C0328b) == true) goto L22;
        return null;
    L22:
        return (od.b.C0328b) r16;
    L18:
        r16 = null;
        goto L20
    L8:
        r13 = null;
        goto L9
    }

    public void setDebugAnimationDurationScale(float r10) {
        if (Float.isNaN(r10) == false) goto L5;
    L8:
        float r11 = 1.0f;
    L10:
        if (this.f17297m != r11) goto L12;
        return;
    L12:
        this.f17297m = r11;
        e r12 = e.f17314a;
        String r13 = getLogTag();
        if (e.a() == false) goto L16;
        Log.d(q.p("OUITextEffects/", r13), q.p("setDebugAnimationDurationScale scale=", Float.valueOf(r11)));
        return;
    L16:
        return;
    L5:
        if (Float.isInfinite(r10) == true) goto L8;
        r11 = h.j(r10, 0.1f, 10.0f);
        goto L10
    }

    public final void t() {
        e r10 = e.f17314a;
        String r11 = getLogTag();
        if (e.a() == false) goto L5;
        Log.d(q.p("OUITextEffects/", r11), "finishEffect effect=" + getActiveEffectName() + ", finalText=" + this.f17290f);
    L5:
        CharSequence r12 = this.f17290f;
        if (r12 == null) goto L9;
        setText(r12);
    L9:
        this.f17287c = null;
        this.f17296l = SchedulerSupport.NONE;
        this.f17289e = 0;
        this.f17290f = null;
        this.f17291g = null;
        this.f17292h = null;
        this.f17294j = null;
        this.f17295k = null;
        this.f17288d = null;
        y();
        invalidate();
    }

    public final BlurMaskFilter u(float r10) {
        return getBlurFilterCache().b(r10);
    }

    public final boolean v(qd.c r10, CharSequence r11) {
        q.g(r10, "cache");
        q.g(r11, "text");
        if (q.b(r10.g(), r11) == true) goto L5;
    L11:
        return false;
    L5:
        if (r10.d() != j()) goto L11;
        if (r10.e() != getEllipsize()) goto L11;
        if (r10.h() != getPaint().getTextSize()) goto L11;
        return true;
    }

    public float w(float r10, float r11) {
        return Math.max(((Number) this.f17285a.invoke(Float.valueOf(getMaxBlurRadiusDp()))).floatValue(), r11) + Math.abs(r10);
    }

    public void x(String r10, long r11, k r12) {
        q.g(r10, "effectName");
        q.g(r12, "spec");
    }

    public void y() {
    }

    public void z(String r10, k r11) {
        q.g(r10, "effectName");
        q.g(r11, "spec");
    }

    @JvmOverloads
    public OProtocolTextEffectTextView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ OProtocolTextEffectTextView(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public OProtocolTextEffectTextView(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
        this.f17285a = new OProtocolTextEffectTextView$dp$1(this);
        this.f17286b = kotlin.b.b(new OProtocolTextEffectTextView$blurFilterCache$2(this));
        this.f17296l = SchedulerSupport.NONE;
        this.f17297m = 1.0f;
        this.f17298n = "ProtocolTextEffectView";
        this.f17299o = 16.0f;
        this.f17300p = 0.5f;
    }
}

package com.alibaba.gaiax.template.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import com.alibaba.gaiax.context.GXTemplateContext;
import com.alibaba.gaiax.render.node.GXNode;
import com.alibaba.gaiax.template.GXColor;
import com.alibaba.gaiax.template.GXIExpression;
import com.alibaba.gaiax.template.GXSize;
import com.alibaba.gaiax.utils.GXExtJsonKt;
import com.alibaba.gaiax.utils.JsonExt;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0007 !\"#$%&B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J4\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J \u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006'"}, d2 = {"Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet;", "Lcom/alibaba/gaiax/template/animation/GXIAnimation;", "Lcom/alibaba/gaiax/template/animation/GXIPropAnimation;", "()V", "animations", "", "getAnimations", "()Ljava/util/List;", GXPropOrderingType.KEY_ORDERING, "Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet$GXPropOrderingType;", "getOrdering", "()Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet$GXPropOrderingType;", "setOrdering", "(Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet$GXPropOrderingType;)V", "createAnimator", "Landroid/animation/Animator;", "targetView", "Landroid/view/View;", "executeAnimation", "", "gxState", "Lcom/alibaba/gaiax/template/GXIExpression;", "gxAnimationExpression", "gxTemplateContext", "Lcom/alibaba/gaiax/context/GXTemplateContext;", "gxNode", "Lcom/alibaba/gaiax/render/node/GXNode;", "gxTemplateData", "Lorg/json/JSONObject;", "playAnimation", PerfLog.PARAM_KEY_CONTEXT_ID, MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "Companion", "GXPropInterpolator", "GXPropLoopMode", "GXPropName", "GXPropOrderingType", "GXPropValue", "GXPropValueType", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GXPropAnimationSet implements GXIAnimation, GXIPropAnimation {
    public static final Companion Companion = null;
    private static final String KEY_ANIMATORS = "animators";
    private static final String KEY_PROP_ANIMATOR = "propAnimator";
    private static final String KEY_PROP_ANIMATOR_SET = "propAnimatorSet";
    private final List<GXIPropAnimation> animations;
    private GXPropOrderingType ordering;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet$Companion;", "", "()V", "KEY_ANIMATORS", "", "KEY_PROP_ANIMATOR", "KEY_PROP_ANIMATOR_SET", "create", "Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet;", "data", "Lorg/json/JSONObject;", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final GXPropAnimationSet create(JSONObject r100) {
            if (r100 == null) goto L12;
            JSONArray r101 = r100.optJSONArray(GXPropAnimationSet.KEY_ANIMATORS);
            if (r101 == null) goto L12;
            if (r101.length() <= 0) goto L12;
            final GXPropAnimationSet r102 = new GXPropAnimationSet();
            GXExtJsonKt.forEach(r101, new GXPropAnimationSet$Companion$create$1(r102));
            String r103 = r100.optString(GXPropOrderingType.KEY_ORDERING, null);
            if (r103 == null) goto L11;
            r102.setOrdering(GXPropOrderingType.Companion.create(r103));
        L11:
            return r102;
        L12:
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet$GXPropInterpolator;", "", "(Ljava/lang/String;I)V", "value", "Landroid/view/animation/Interpolator;", GXPropInterpolator.KEY_LINEAR, GXPropInterpolator.KEY_ACCELERATE, GXPropInterpolator.KEY_DECELERATE, GXPropInterpolator.KEY_STANDARD, GXPropInterpolator.KEY_ANTICIPATE, GXPropInterpolator.KEY_OVERSHOOT, GXPropInterpolator.KEY_SPRING, GXPropInterpolator.KEY_BOUNCE, GXPropInterpolator.KEY_COSINE, "Companion", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final enum GXPropInterpolator extends Enum<GXPropInterpolator> {
        private static final /* synthetic */ GXPropInterpolator[] $VALUES = null;
        public static final GXPropInterpolator ACCELERATE = null;
        public static final GXPropInterpolator ANTICIPATE = null;
        public static final GXPropInterpolator BOUNCE = null;
        public static final GXPropInterpolator COSINE = null;
        public static final Companion Companion = null;
        public static final GXPropInterpolator DECELERATE = null;
        private static final String KEY_ACCELERATE = "ACCELERATE";
        private static final String KEY_ANTICIPATE = "ANTICIPATE";
        private static final String KEY_BOUNCE = "BOUNCE";
        private static final String KEY_COSINE = "COSINE";
        private static final String KEY_DECELERATE = "DECELERATE";
        private static final String KEY_LINEAR = "LINEAR";
        private static final String KEY_OVERSHOOT = "OVERSHOOT";
        private static final String KEY_SPRING = "SPRING";
        private static final String KEY_STANDARD = "STANDARD";
        public static final GXPropInterpolator LINEAR = null;
        public static final GXPropInterpolator OVERSHOOT = null;
        public static final GXPropInterpolator SPRING = null;
        public static final GXPropInterpolator STANDARD = null;

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet$GXPropInterpolator$Companion;", "", "()V", "KEY_ACCELERATE", "", "KEY_ANTICIPATE", "KEY_BOUNCE", "KEY_COSINE", "KEY_DECELERATE", "KEY_LINEAR", "KEY_OVERSHOOT", "KEY_SPRING", "KEY_STANDARD", "create", "Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet$GXPropInterpolator;", "value", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }

            public final GXPropInterpolator create(String r100) {
                Intrinsics.checkNotNullParameter(r100, "value");
                if (StringsKt.equals(r100, GXPropInterpolator.KEY_LINEAR, true) == false) goto L6;
                return GXPropInterpolator.LINEAR;
            L6:
                if (StringsKt.equals(r100, GXPropInterpolator.KEY_ACCELERATE, true) == false) goto L9;
                return GXPropInterpolator.ACCELERATE;
            L9:
                if (StringsKt.equals(r100, GXPropInterpolator.KEY_DECELERATE, true) == false) goto L12;
                return GXPropInterpolator.DECELERATE;
            L12:
                if (StringsKt.equals(r100, GXPropInterpolator.KEY_STANDARD, true) == false) goto L15;
                return GXPropInterpolator.STANDARD;
            L15:
                if (StringsKt.equals(r100, GXPropInterpolator.KEY_ANTICIPATE, true) == false) goto L18;
                return GXPropInterpolator.ANTICIPATE;
            L18:
                if (StringsKt.equals(r100, GXPropInterpolator.KEY_OVERSHOOT, true) == false) goto L21;
                return GXPropInterpolator.OVERSHOOT;
            L21:
                if (StringsKt.equals(r100, GXPropInterpolator.KEY_SPRING, true) == false) goto L24;
                return GXPropInterpolator.SPRING;
            L24:
                if (StringsKt.equals(r100, GXPropInterpolator.KEY_BOUNCE, true) == false) goto L27;
                return GXPropInterpolator.BOUNCE;
            L27:
                if (StringsKt.equals(r100, GXPropInterpolator.KEY_COSINE, true) == false) goto L30;
                return GXPropInterpolator.COSINE;
            L30:
                return GXPropInterpolator.STANDARD;
            }
        }

        private static final /* synthetic */ GXPropInterpolator[] $values() {
            return new GXPropInterpolator[]{LINEAR, ACCELERATE, DECELERATE, STANDARD, ANTICIPATE, OVERSHOOT, SPRING, BOUNCE, COSINE};
        }

        public static GXPropInterpolator valueOf(String r100) {
            return (GXPropInterpolator) r27.a.a(GXPropInterpolator.class, r100);
        }

        public static GXPropInterpolator[] values() {
            return (GXPropInterpolator[]) $VALUES.clone();
        }

        static {
            LINEAR = new GXPropInterpolator(KEY_LINEAR, 0);
            ACCELERATE = new GXPropInterpolator(KEY_ACCELERATE, 1);
            DECELERATE = new GXPropInterpolator(KEY_DECELERATE, 2);
            STANDARD = new GXPropInterpolator(KEY_STANDARD, 3);
            ANTICIPATE = new GXPropInterpolator(KEY_ANTICIPATE, 4);
            OVERSHOOT = new GXPropInterpolator(KEY_OVERSHOOT, 5);
            SPRING = new GXPropInterpolator(KEY_SPRING, 6);
            BOUNCE = new GXPropInterpolator(KEY_BOUNCE, 7);
            COSINE = new GXPropInterpolator(KEY_COSINE, 8);
            $VALUES = $values();
            Companion = new Companion(null);
        }

        public final Interpolator value() {
            return new LinearInterpolator();
        }

        private GXPropInterpolator(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0006"}, d2 = {"Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet$GXPropLoopMode;", "", "(Ljava/lang/String;I)V", "RESET", "REVERSE", "Companion", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final enum GXPropLoopMode extends Enum<GXPropLoopMode> {
        private static final /* synthetic */ GXPropLoopMode[] $VALUES = null;
        public static final Companion Companion = null;
        public static final String KEY_LOOP_MODE = "loopMode";
        public static final GXPropLoopMode RESET = null;
        public static final GXPropLoopMode REVERSE = null;

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet$GXPropLoopMode$Companion;", "", "()V", "KEY_LOOP_MODE", "", "create", "Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet$GXPropLoopMode;", "data", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }

            public final GXPropLoopMode create(String r100) {
                Intrinsics.checkNotNullParameter(r100, "data");
                if (StringsKt.equals(r100, "'RESET'", true) == false) goto L6;
                return GXPropLoopMode.RESET;
            L6:
                if (StringsKt.equals(r100, "'REVERSE'", true) == false) goto L9;
                return GXPropLoopMode.REVERSE;
            L9:
                return GXPropLoopMode.RESET;
            }
        }

        private static final /* synthetic */ GXPropLoopMode[] $values() {
            return new GXPropLoopMode[]{RESET, REVERSE};
        }

        public static GXPropLoopMode valueOf(String r100) {
            return (GXPropLoopMode) r27.a.a(GXPropLoopMode.class, r100);
        }

        public static GXPropLoopMode[] values() {
            return (GXPropLoopMode[]) $VALUES.clone();
        }

        static {
            RESET = new GXPropLoopMode("RESET", 0);
            REVERSE = new GXPropLoopMode("REVERSE", 1);
            $VALUES = $values();
            Companion = new Companion(null);
        }

        private GXPropLoopMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0012\b\u0086\u0001\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001cB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\bH\u0002J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0016\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u000bj\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001b¨\u0006\u001d"}, d2 = {"Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet$GXPropName;", "", "(Ljava/lang/String;I)V", "setColorValue", "", "targetView", "Landroid/view/View;", "color", "", "setOpacity", "value", "", "setPositionX", "setPositionY", "setRenderColor", "setRotation", "setScaleX", "setScaleY", "setValue", "finalValue", "POSITION_X", "POSITION_Y", "OPACITY", "SCALE", "SCALE_X", "SCALE_Y", "ROTATION", "RENDER_COLOR", "Companion", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final enum GXPropName extends Enum<GXPropName> {
        private static final /* synthetic */ GXPropName[] $VALUES = null;
        public static final Companion Companion = null;
        private static final String KEY_OPACITY = "'opacity'";
        private static final String KEY_POSITION_X = "'positionX'";
        private static final String KEY_POSITION_Y = "'positionY'";
        private static final String KEY_RENDER_COLOR = "'renderColor'";
        private static final String KEY_ROTATION = "'rotation'";
        private static final String KEY_SCALE = "'scale'";
        private static final String KEY_SCALEX = "'scaleX'";
        private static final String KEY_SCALEY = "'scaleY'";
        public static final GXPropName OPACITY = null;
        public static final GXPropName POSITION_X = null;
        public static final GXPropName POSITION_Y = null;
        public static final GXPropName RENDER_COLOR = null;
        public static final GXPropName ROTATION = null;
        public static final GXPropName SCALE = null;
        public static final GXPropName SCALE_X = null;
        public static final GXPropName SCALE_Y = null;

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet$GXPropName$Companion;", "", "()V", "KEY_OPACITY", "", "KEY_POSITION_X", "KEY_POSITION_Y", "KEY_RENDER_COLOR", "KEY_ROTATION", "KEY_SCALE", "KEY_SCALEX", "KEY_SCALEY", "create", "Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet$GXPropName;", "value", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }

            public final GXPropName create(String r100) {
                if (StringsKt.equals(r100, GXPropName.KEY_POSITION_X, true) == false) goto L6;
                return GXPropName.POSITION_X;
            L6:
                if (StringsKt.equals(r100, GXPropName.KEY_POSITION_Y, true) == false) goto L9;
                return GXPropName.POSITION_Y;
            L9:
                if (StringsKt.equals(r100, GXPropName.KEY_OPACITY, true) == false) goto L12;
                return GXPropName.OPACITY;
            L12:
                if (StringsKt.equals(r100, GXPropName.KEY_SCALE, true) == false) goto L15;
                return GXPropName.SCALE;
            L15:
                if (StringsKt.equals(r100, GXPropName.KEY_SCALEX, true) == false) goto L18;
                return GXPropName.SCALE_X;
            L18:
                if (StringsKt.equals(r100, GXPropName.KEY_SCALEY, true) == false) goto L21;
                return GXPropName.SCALE_Y;
            L21:
                if (StringsKt.equals(r100, GXPropName.KEY_ROTATION, true) == false) goto L24;
                return GXPropName.ROTATION;
            L24:
                if (StringsKt.equals(r100, GXPropName.KEY_RENDER_COLOR, true) == true) goto L35;
                return null;
            L35:
                return GXPropName.RENDER_COLOR;
            }
        }

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] r100 = new int[GXPropName.values().length];
                r100[GXPropName.POSITION_X.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
            L21:
                r100[GXPropName.POSITION_Y.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
            L31:
                r100[GXPropName.OPACITY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
            L23:
                r100[GXPropName.SCALE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
            L25:
                r100[GXPropName.SCALE_X.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
            L19:
                r100[GXPropName.SCALE_Y.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
            L27:
                r100[GXPropName.ROTATION.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
            L10:
                $EnumSwitchMapping$0 = r100;
            }
        }

        private static final /* synthetic */ GXPropName[] $values() {
            return new GXPropName[]{POSITION_X, POSITION_Y, OPACITY, SCALE, SCALE_X, SCALE_Y, ROTATION, RENDER_COLOR};
        }

        public static GXPropName valueOf(String r100) {
            return (GXPropName) r27.a.a(GXPropName.class, r100);
        }

        public static GXPropName[] values() {
            return (GXPropName[]) $VALUES.clone();
        }

        static {
            POSITION_X = new GXPropName("POSITION_X", 0);
            POSITION_Y = new GXPropName("POSITION_Y", 1);
            OPACITY = new GXPropName("OPACITY", 2);
            SCALE = new GXPropName("SCALE", 3);
            SCALE_X = new GXPropName("SCALE_X", 4);
            SCALE_Y = new GXPropName("SCALE_Y", 5);
            ROTATION = new GXPropName("ROTATION", 6);
            RENDER_COLOR = new GXPropName("RENDER_COLOR", 7);
            $VALUES = $values();
            Companion = new Companion(null);
        }

        private GXPropName(String r100, int r101) {
            super(r100, r101);
        }

        private final void setOpacity(View r100, float r101) {
            r100.setAlpha(r101);
        }

        private final void setPositionX(View r100, float r101) {
            r100.setTranslationX(GXSize.Companion.dpToPx(r101));
        }

        private final void setPositionY(View r100, float r101) {
            r100.setTranslationY(GXSize.Companion.dpToPx(r101));
        }

        private final void setRenderColor(View r100, int r101) {
            if ((r100 instanceof TextView) == false) goto L5;
            ((TextView) r100).setTextColor(r101);
            return;
        L5:
            r100.setBackgroundColor(r101);
        }

        private final void setRotation(View r100, float r101) {
            r100.setRotation(r101);
        }

        private final void setScaleX(View r100, float r101) {
            r100.setScaleX(r101);
        }

        private final void setScaleY(View r100, float r101) {
            r100.setScaleY(r101);
        }

        public final void setColorValue(View r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "targetView");
            setRenderColor(r100, r101);
        }

        public final void setValue(View r100, float r101) {
            Intrinsics.checkNotNullParameter(r100, "targetView");
            switch(WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
                case 1: goto L11;
                case 2: goto L10;
                case 3: goto L9;
                case 4: goto L8;
                case 5: goto L7;
                case 6: goto L6;
                case 7: goto L5;
                default: goto L19;
            };
        L5:
            setRotation(r100, r101);
            return;
        L6:
            setScaleY(r100, r101);
            return;
        L7:
            setScaleX(r100, r101);
            return;
        L8:
            setScaleX(r100, r101);
            setScaleY(r100, r101);
            return;
        L9:
            setOpacity(r100, r101);
            return;
        L10:
            setPositionY(r100, r101);
            return;
        L11:
            setPositionX(r100, r101);
            return;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0006"}, d2 = {"Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet$GXPropOrderingType;", "", "(Ljava/lang/String;I)V", "TOGETHER", GXPropOrderingType.KEY_SEQUENTIALLY, "Companion", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final enum GXPropOrderingType extends Enum<GXPropOrderingType> {
        private static final /* synthetic */ GXPropOrderingType[] $VALUES = null;
        public static final Companion Companion = null;
        public static final String KEY_ORDERING = "ordering";
        private static final String KEY_SEQUENTIALLY = "SEQUENTIALLY";
        private static final String KEY_SEQUENTIALLY_2 = "'SEQUENTIALLY'";
        public static final GXPropOrderingType SEQUENTIALLY = null;
        public static final GXPropOrderingType TOGETHER = null;

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet$GXPropOrderingType$Companion;", "", "()V", "KEY_ORDERING", "", "KEY_SEQUENTIALLY", "KEY_SEQUENTIALLY_2", "create", "Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet$GXPropOrderingType;", "value", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }

            public final GXPropOrderingType create(String r100) {
                Intrinsics.checkNotNullParameter(r100, "value");
                if (StringsKt.equals(r100, GXPropOrderingType.KEY_SEQUENTIALLY, true) == true) goto L9;
                if (StringsKt.equals(r100, GXPropOrderingType.KEY_SEQUENTIALLY_2, true) == true) goto L9;
                return GXPropOrderingType.TOGETHER;
            L9:
                return GXPropOrderingType.SEQUENTIALLY;
            }
        }

        private static final /* synthetic */ GXPropOrderingType[] $values() {
            return new GXPropOrderingType[]{TOGETHER, SEQUENTIALLY};
        }

        public static GXPropOrderingType valueOf(String r100) {
            return (GXPropOrderingType) r27.a.a(GXPropOrderingType.class, r100);
        }

        public static GXPropOrderingType[] values() {
            return (GXPropOrderingType[]) $VALUES.clone();
        }

        static {
            TOGETHER = new GXPropOrderingType("TOGETHER", 0);
            SEQUENTIALLY = new GXPropOrderingType(KEY_SEQUENTIALLY, 1);
            $VALUES = $values();
            Companion = new Companion(null);
        }

        private GXPropOrderingType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00032\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet$GXPropValue;", "", "()V", "Companion", "GXPropValueColor", "GXPropValueFloat", "Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet$GXPropValue$GXPropValueColor;", "Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet$GXPropValue$GXPropValueFloat;", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static abstract class GXPropValue {
        public static final Companion Companion = null;
        private static final String KEY_VALUE_FROM = "valueFrom";
        private static final String KEY_VALUE_TO = "valueTo";
        private static final String KEY_VALUE_TYPE = "valueType";

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet$GXPropValue$Companion;", "", "()V", "KEY_VALUE_FROM", "", "KEY_VALUE_TO", "KEY_VALUE_TYPE", "create", "Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet$GXPropValue;", "data", "Lorg/json/JSONObject;", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {

            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

                static {
                    int[] r100 = new int[GXPropValueType.values().length];
                    r100[GXPropValueType.IntType.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
                L11:
                    r100[GXPropValueType.FloatType.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
                L15:
                    r100[GXPropValueType.ColorType.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
                L6:
                    $EnumSwitchMapping$0 = r100;
                }
            }

            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }

            public final GXPropValue create(JSONObject r100) {
                Intrinsics.checkNotNullParameter(r100, "data");
                GXPropValueType r101 = GXPropValueType.Companion.create(JsonExt.INSTANCE.getStringExt(r100, GXPropValue.KEY_VALUE_TYPE));
                if (r101 == null) goto L16;
                int r102 = WhenMappings.$EnumSwitchMapping$0[r101.ordinal()];
                if (r102 == 1) goto L15;
                if (r102 == 2) goto L19;
                if (r102 != 3) goto L12;
                return GXPropValueColor.Companion.create(r100);
            L12:
                throw new NoWhenBranchMatchedException();
            L19:
                return GXPropValueFloat.Companion.create(r100);
            L15:
                return GXPropValueFloat.Companion.create(r100);
            L16:
                return null;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet$GXPropValue$GXPropValueColor;", "Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet$GXPropValue;", GXPropValue.KEY_VALUE_FROM, "Lcom/alibaba/gaiax/template/GXColor;", GXPropValue.KEY_VALUE_TO, "(Lcom/alibaba/gaiax/template/GXColor;Lcom/alibaba/gaiax/template/GXColor;)V", "getValueFrom", "()Lcom/alibaba/gaiax/template/GXColor;", "getValueTo", "Companion", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class GXPropValueColor extends GXPropValue {
            public static final Companion Companion = null;
            private final GXColor valueFrom;
            private final GXColor valueTo;

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet$GXPropValue$GXPropValueColor$Companion;", "", "()V", "create", "Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet$GXPropValue$GXPropValueColor;", "data", "Lorg/json/JSONObject;", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                    this();
                }

                public final GXPropValueColor create(JSONObject r100) {
                    Intrinsics.checkNotNullParameter(r100, "data");
                    JsonExt r101 = JsonExt.INSTANCE;
                    String r102 = r101.getStringExt(r100, GXPropValue.KEY_VALUE_FROM);
                    String r103 = r101.getStringExt(r100, GXPropValue.KEY_VALUE_TO);
                    boolean r104 = true;
                    if (r102.length() <= 0) goto L5;
                    boolean r105 = true;
                L6:
                    if (r105 == true) goto L8;
                    return null;
                L8:
                    if (r102.length() > 0) goto L11;
                    r104 = false;
                L11:
                    if (r104 == false) goto L19;
                    GXColor.Companion r106 = GXColor.Companion;
                    GXColor r107 = r106.create(r102);
                    GXColor r108 = r106.create(r103);
                    if (r107 == null) goto L20;
                    if (r108 != null) goto L16;
                    return null;
                L16:
                    return new GXPropValueColor(r107, r108);
                L20:
                    return null;
                L19:
                    return null;
                L5:
                    r105 = false;
                    goto L6
                }
            }

            static {
                Companion = new Companion(null);
            }

            public final GXColor getValueFrom() {
                return this.valueFrom;
            }

            public final GXColor getValueTo() {
                return this.valueTo;
            }

            public GXPropValueColor(GXColor r100, GXColor r101) {
                Intrinsics.checkNotNullParameter(r100, GXPropValue.KEY_VALUE_FROM);
                Intrinsics.checkNotNullParameter(r101, GXPropValue.KEY_VALUE_TO);
                super(null);
                this.valueFrom = r100;
                this.valueTo = r101;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet$GXPropValue$GXPropValueFloat;", "Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet$GXPropValue;", GXPropValue.KEY_VALUE_FROM, "", GXPropValue.KEY_VALUE_TO, "(FF)V", "getValueFrom", "()F", "getValueTo", "Companion", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class GXPropValueFloat extends GXPropValue {
            public static final Companion Companion = null;
            private final float valueFrom;
            private final float valueTo;

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet$GXPropValue$GXPropValueFloat$Companion;", "", "()V", "create", "Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet$GXPropValue$GXPropValueFloat;", "data", "Lorg/json/JSONObject;", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                    this();
                }

                public final GXPropValueFloat create(JSONObject r100) {
                    Intrinsics.checkNotNullParameter(r100, "data");
                    JsonExt r101 = JsonExt.INSTANCE;
                    String r102 = r101.getStringExt(r100, GXPropValue.KEY_VALUE_FROM);
                    String r103 = r101.getStringExt(r100, GXPropValue.KEY_VALUE_TO);
                    boolean r104 = true;
                    if (r102.length() <= 0) goto L5;
                    boolean r105 = true;
                L6:
                    if (r105 == true) goto L8;
                    return null;
                L8:
                    if (r102.length() > 0) goto L11;
                    r104 = false;
                L11:
                    if (r104 == true) goto L13;
                    return null;
                L13:
                    return new GXPropValueFloat(CastFloatProtector.parseFloat(r102), CastFloatProtector.parseFloat(r103));
                L5:
                    r105 = false;
                    goto L6
                }
            }

            static {
                Companion = new Companion(null);
            }

            public final float getValueFrom() {
                return this.valueFrom;
            }

            public final float getValueTo() {
                return this.valueTo;
            }

            public GXPropValueFloat(float r100, float r101) {
                super(null);
                this.valueFrom = r100;
                this.valueTo = r101;
            }
        }

        static {
            Companion = new Companion(null);
        }

        private GXPropValue() {
        }

        public /* synthetic */ GXPropValue(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, d2 = {"Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet$GXPropValueType;", "", "(Ljava/lang/String;I)V", "IntType", "FloatType", "ColorType", "Companion", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final enum GXPropValueType extends Enum<GXPropValueType> {
        private static final /* synthetic */ GXPropValueType[] $VALUES = null;
        public static final GXPropValueType ColorType = null;
        public static final Companion Companion = null;
        public static final GXPropValueType FloatType = null;
        public static final GXPropValueType IntType = null;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet$GXPropValueType$Companion;", "", "()V", "create", "Lcom/alibaba/gaiax/template/animation/GXPropAnimationSet$GXPropValueType;", "value", "", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }

            public final GXPropValueType create(String r100) {
                Intrinsics.checkNotNullParameter(r100, "value");
                int r101 = r100.hashCode();
                if (r101 == (-1216325979)) goto L18;
                if (r101 == (-81946127)) goto L14;
                if (r101 == 1906481816) goto L10;
            L19:
                return null;
            L10:
                if (r100.equals("'floatType'") == false) goto L19;
                return GXPropValueType.FloatType;
            L14:
                if (r100.equals("'colorType'") == false) goto L19;
                return GXPropValueType.ColorType;
            L18:
                if (r100.equals("'intType'") == false) goto L19;
                return GXPropValueType.IntType;
            }
        }

        private static final /* synthetic */ GXPropValueType[] $values() {
            return new GXPropValueType[]{IntType, FloatType, ColorType};
        }

        public static GXPropValueType valueOf(String r100) {
            return (GXPropValueType) r27.a.a(GXPropValueType.class, r100);
        }

        public static GXPropValueType[] values() {
            return (GXPropValueType[]) $VALUES.clone();
        }

        static {
            IntType = new GXPropValueType("IntType", 0);
            FloatType = new GXPropValueType("FloatType", 1);
            ColorType = new GXPropValueType("ColorType", 2);
            $VALUES = $values();
            Companion = new Companion(null);
        }

        private GXPropValueType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[GXPropOrderingType.values().length];
            r100[GXPropOrderingType.TOGETHER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[GXPropOrderingType.SEQUENTIALLY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r100;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public GXPropAnimationSet() {
        this.ordering = GXPropOrderingType.TOGETHER;
        this.animations = new ArrayList();
    }

    public final List<GXIPropAnimation> getAnimations() {
        return this.animations;
    }

    public final GXPropOrderingType getOrdering() {
        return this.ordering;
    }

    @Override // com.alibaba.gaiax.template.animation.GXIPropAnimation
    public Animator createAnimator(View r100) {
        Intrinsics.checkNotNullParameter(r100, "targetView");
        AnimatorSet r101 = new AnimatorSet();
        GXPropOrderingType r102 = this.ordering;
        int r103 = WhenMappings.$EnumSwitchMapping$0[r102.ordinal()];
        if (r103 != 1) goto L5;
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = this.animations.iterator();
    L14:
        if (r105.hasNext() == false) goto L16;
        r104.add(((GXIPropAnimation) r105.next()).createAnimator(r100));
        goto L14
    L16:
        r101.playTogether(r104);
    L17:
        return r101;
    L5:
        if (r103 != 2) goto L17;
        ArrayList r106 = new ArrayList();
        Iterator<T> r107 = this.animations.iterator();
    L9:
        if (r107.hasNext() == false) goto L11;
        r106.add(((GXIPropAnimation) r107.next()).createAnimator(r100));
        goto L9
    L11:
        r101.playSequentially(r106);
        goto L17
    }

    public final void setOrdering(GXPropOrderingType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.ordering = r100;
    }

    private final void playAnimation(final GXTemplateContext r100, final GXNode r101, final View r102) {
        if (r101.getPropAnimatorSet() != null) goto L6;
        Animator r103 = createAnimator(r102);
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.animation.AnimatorSet");
        r101.setPropAnimatorSet((AnimatorSet) r103);
    L6:
        if (r101.isAnimating() == true) goto L14;
        AnimatorSet r104 = r101.getPropAnimatorSet();
        if (r104 == null) goto L12;
        boolean r105 = true;
        if (r104.isRunning() != true) goto L12;
    L13:
        if (r105 == true) goto L14;
    L18:
        AnimatorSet r106 = r101.getPropAnimatorSet();
        if (r106 == null) goto L21;
        r106.removeAllListeners();
    L21:
        AnimatorSet r107 = r101.getPropAnimatorSet();
        if (r107 == null) goto L24;
        r107.addListener(new AnonymousClass1(r100, r101, r102));
    L24:
        AnimatorSet r108 = r101.getPropAnimatorSet();
        if (r108 == null) goto L28;
        r108.start();
        return;
    L28:
        return;
    L12:
        r105 = false;
    L14:
        AnimatorSet r109 = r101.getPropAnimatorSet();
        if (r109 == null) goto L17;
        r109.cancel();
    L17:
        r101.setAnimating(false);
        goto L18
    }

    @Override // com.alibaba.gaiax.template.animation.GXIAnimation
    public void executeAnimation(GXIExpression r100, GXIExpression r101, GXTemplateContext r102, GXNode r103, JSONObject r104) {
        Intrinsics.checkNotNullParameter(r102, "gxTemplateContext");
        Intrinsics.checkNotNullParameter(r103, "gxNode");
        Intrinsics.checkNotNullParameter(r104, "gxTemplateData");
        View r105 = r103.getView();
        if (r105 == null) goto L6;
        playAnimation(r102, r103, r105);
        return;
    }
}

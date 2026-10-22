package com.stepos.ailauncher.chat.voice.longpress;

import Z8.C1173v;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.voice.longpress.i0;
import com.stepos.ailauncher.speech.R$string;
import com.stepos.launcher.assistant.slidepanel.ConstConfig;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$BooleanRef;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import r9.C5227b;
import v9.C5685n;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001:\u0003vwxB\u0099\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e\u0012\u0014\u0010\u0012\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u00100\u000e\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0013¢\u0006\u0004\b\u0017\u0010\u0018J-\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00152\b\b\u0003\u0010\u001b\u001a\u00020\u001a2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010 \u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0015¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\u00102\b\b\u0001\u0010\"\u001a\u00020\u001a¢\u0006\u0004\b#\u0010$J\u0015\u0010'\u001a\u00020\u00102\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J\u001d\u0010)\u001a\u00020\u00102\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013¢\u0006\u0004\b)\u0010*J\u001b\u0010+\u001a\u00020\u00102\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013¢\u0006\u0004\b+\u0010*J\u001b\u0010,\u001a\u00020\u00102\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013¢\u0006\u0004\b,\u0010*J\r\u0010-\u001a\u00020\u0010¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0010H\u0002¢\u0006\u0004\b/\u0010.J\u0017\u00102\u001a\u00020\u00102\u0006\u00101\u001a\u000200H\u0002¢\u0006\u0004\b2\u00103J'\u00107\u001a\u00020\u00102\u0006\u00101\u001a\u0002002\u0006\u00105\u001a\u0002042\u0006\u00106\u001a\u00020\u0015H\u0002¢\u0006\u0004\b7\u00108J\u001f\u0010:\u001a\u00020\u00102\u0006\u00105\u001a\u0002042\u0006\u00109\u001a\u00020\u000fH\u0002¢\u0006\u0004\b:\u0010;J\u0017\u0010<\u001a\u00020\u00102\u0006\u00101\u001a\u000200H\u0002¢\u0006\u0004\b<\u00103J\u001f\u0010?\u001a\u00020\u00102\u0006\u0010=\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u000fH\u0002¢\u0006\u0004\b?\u0010@J\u0017\u0010A\u001a\u00020\u00102\u0006\u00101\u001a\u000200H\u0002¢\u0006\u0004\bA\u00103J\u0017\u0010C\u001a\u00020\u00102\u0006\u0010B\u001a\u00020\u0015H\u0002¢\u0006\u0004\bC\u0010!J\u0017\u0010E\u001a\u00020\u00102\u0006\u0010D\u001a\u00020\u0015H\u0002¢\u0006\u0004\bE\u0010!J\u000f\u0010F\u001a\u000204H\u0002¢\u0006\u0004\bF\u0010GJ\u0017\u0010I\u001a\u00020H2\u0006\u0010=\u001a\u00020\u0005H\u0002¢\u0006\u0004\bI\u0010JJ'\u0010K\u001a\u00020\u00102\u0006\u0010=\u001a\u00020\u00052\u0006\u00105\u001a\u00020H2\u0006\u00109\u001a\u00020\u000fH\u0002¢\u0006\u0004\bK\u0010LJ9\u0010O\u001a\u00020\u00102\u0006\u0010M\u001a\u00020%2\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00100\u000e2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013H\u0002¢\u0006\u0004\bO\u0010PJ\u0017\u0010R\u001a\u00020\u001a2\u0006\u0010Q\u001a\u00020\u000fH\u0002¢\u0006\u0004\bR\u0010SJ\u0017\u0010T\u001a\u00020\u000f2\u0006\u0010Q\u001a\u00020\u000fH\u0002¢\u0006\u0004\bT\u0010UJ'\u0010W\u001a\u00020\u000f2\u0006\u00105\u001a\u00020\u000f2\u0006\u0010V\u001a\u00020\u000f2\u0006\u00109\u001a\u00020\u000fH\u0002¢\u0006\u0004\bW\u0010XR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010YR\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010YR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010ZR\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010[R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010[R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\\R\u0014\u0010\f\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010ZR\u0014\u0010\r\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010ZR \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010]R\"\u0010\u0012\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\u00100\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010]R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010^R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010^R\u0014\u0010_\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010`R\u001c\u0010c\u001a\n b*\u0004\u0018\u00010a0a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010dR\u0018\u0010e\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010fR\u0016\u0010h\u001a\u00020g8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010iR\u0018\u0010k\u001a\u0004\u0018\u00010j8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010lR\u0018\u0010n\u001a\u0004\u0018\u00010m8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010oR\u0016\u0010p\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010\u0019\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010rR\u0018\u0010s\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010tR\u0016\u0010u\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010rR\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010q¨\u0006y"}, d2 = {"Lcom/stepos/ailauncher/chat/voice/longpress/g0;", "", "Landroid/view/ViewGroup;", "mainInput", "inputContainer", "Landroid/view/View;", "leftContent", "", "centerContents", "rightContents", "Landroid/widget/TextView;", "statusTip", "finalizingContent", "finalizingLeftContent", "Lkotlin/Function1;", "", "LY8/t;", "onOutgoingAlphaChanged", "onCornerRadiusChanged", "Lkotlin/Function0;", "onBoundsChanged", "", "isMultiRow", "<init>", "(Landroid/view/ViewGroup;Landroid/view/ViewGroup;Landroid/view/View;Ljava/util/List;Ljava/util/List;Landroid/widget/TextView;Landroid/view/View;Landroid/view/View;Lp9/l;Lp9/l;Lp9/a;Lp9/a;)V", "moveCenterHorizontally", "", "recordingHintRes", "onFinished", "B", "(ZILp9/a;)V", "cancel", "M", "(Z)V", "hintRes", "P", "(I)V", "", "remainingMs", "Q", "(J)V", ExifInterface.LONGITUDE_EAST, "(Lp9/a;)V", "u", "H", "L", "()V", "R", "Lcom/stepos/ailauncher/chat/voice/longpress/i0$a;", "frame", "o", "(Lcom/stepos/ailauncher/chat/voice/longpress/i0$a;)V", "Lcom/stepos/ailauncher/chat/voice/longpress/g0$c;", "start", "showFinalizing", "p", "(Lcom/stepos/ailauncher/chat/voice/longpress/i0$a;Lcom/stepos/ailauncher/chat/voice/longpress/g0$c;Z)V", "progress", "q", "(Lcom/stepos/ailauncher/chat/voice/longpress/g0$c;F)V", "s", "view", "pageDeltaDp", "n", "(Landroid/view/View;F)V", "r", "interactive", "N", "accessible", "O", "y", "()Lcom/stepos/ailauncher/chat/voice/longpress/g0$c;", "Lcom/stepos/ailauncher/chat/voice/longpress/g0$a;", "x", "(Landroid/view/View;)Lcom/stepos/ailauncher/chat/voice/longpress/g0$a;", "t", "(Landroid/view/View;Lcom/stepos/ailauncher/chat/voice/longpress/g0$a;F)V", "durationMs", "onFrame", "l", "(JLp9/l;Lp9/a;)V", UxipConstants.f30680s, "z", "(F)I", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(F)F", com.stepos.ailauncher.container.wallpaper.a.PHASE_END, "K", "(FFF)F", "Landroid/view/ViewGroup;", "Landroid/view/View;", "Ljava/util/List;", "Landroid/widget/TextView;", "Lp9/l;", "Lp9/a;", "density", "F", "Landroid/content/res/ColorStateList;", "kotlin.jvm.PlatformType", "listeningTextColors", "Landroid/content/res/ColorStateList;", "originalInputHeight", "Ljava/lang/Integer;", "Lcom/stepos/ailauncher/chat/voice/longpress/h0;", "geometry", "Lcom/stepos/ailauncher/chat/voice/longpress/h0;", "Lcom/stepos/ailauncher/chat/voice/longpress/g0$b;", "originalMargins", "Lcom/stepos/ailauncher/chat/voice/longpress/g0$b;", "Landroid/animation/ValueAnimator;", "animator", "Landroid/animation/ValueAnimator;", "plannedWidthExpansionPx", "I", "Z", "recordingRemainingMs", "Ljava/lang/Long;", "inCancelState", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "c", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class g0 {
    private ValueAnimator animator;
    private final List<View> centerContents;
    private final float density;
    private final View finalizingContent;
    private final View finalizingLeftContent;
    private h0 geometry;
    private boolean inCancelState;
    private final ViewGroup inputContainer;
    private final InterfaceC5063a<Boolean> isMultiRow;
    private final View leftContent;
    private final ColorStateList listeningTextColors;
    private final ViewGroup mainInput;
    private boolean moveCenterHorizontally;
    private final InterfaceC5063a<Y8.t> onBoundsChanged;
    private final InterfaceC5074l<Float, Y8.t> onCornerRadiusChanged;
    private final InterfaceC5074l<Float, Y8.t> onOutgoingAlphaChanged;
    private Integer originalInputHeight;
    private Margins originalMargins;
    private int plannedWidthExpansionPx;
    private int recordingHintRes;
    private Long recordingRemainingMs;
    private final List<View> rightContents;
    private final TextView statusTip;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0015\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/chat/voice/longpress/g0$a;", "", "", "translationX", "translationY", ConstConfig.KEY_VIEW_ALPHA_PROPERTY, "<init>", "(FFF)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "F", Const.INTENT_KEY_PKGNAME, "()F", "c", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.voice.longpress.g0$a, reason: from toString */
    public static final /* data */ class ElementSnapshot {
        private final float alpha;
        private final float translationX;
        private final float translationY;

        public ElementSnapshot(float f10, float f11, float f12) {
            this.translationX = f10;
            this.translationY = f11;
            this.alpha = f12;
        }

        /* renamed from: a, reason: from getter */
        public final float getAlpha() {
            return this.alpha;
        }

        /* renamed from: b, reason: from getter */
        public final float getTranslationX() {
            return this.translationX;
        }

        /* renamed from: c, reason: from getter */
        public final float getTranslationY() {
            return this.translationY;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ElementSnapshot)) {
                return false;
            }
            ElementSnapshot elementSnapshot = (ElementSnapshot) other;
            return Float.compare(this.translationX, elementSnapshot.translationX) == 0 && Float.compare(this.translationY, elementSnapshot.translationY) == 0 && Float.compare(this.alpha, elementSnapshot.alpha) == 0;
        }

        public int hashCode() {
            return (((Float.hashCode(this.translationX) * 31) + Float.hashCode(this.translationY)) * 31) + Float.hashCode(this.alpha);
        }

        public String toString() {
            return "ElementSnapshot(translationX=" + this.translationX + ", translationY=" + this.translationY + ", alpha=" + this.alpha + ")";
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u000bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0012\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/stepos/ailauncher/chat/voice/longpress/g0$b;", "", "", "left", "right", "<init>", "(II)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.voice.longpress.g0$b, reason: from toString */
    public static final /* data */ class Margins {
        private final int left;
        private final int right;

        public Margins(int i10, int i11) {
            this.left = i10;
            this.right = i11;
        }

        /* renamed from: a, reason: from getter */
        public final int getLeft() {
            return this.left;
        }

        /* renamed from: b, reason: from getter */
        public final int getRight() {
            return this.right;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Margins)) {
                return false;
            }
            Margins margins = (Margins) other;
            return this.left == margins.left && this.right == margins.right;
        }

        public int hashCode() {
            return (Integer.hashCode(this.left) * 31) + Integer.hashCode(this.right);
        }

        public String toString() {
            return "Margins(left=" + this.left + ", right=" + this.right + ")";
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0082\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u0015R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001a\u001a\u0004\b\u001c\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001d\u0010\u0015R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b8\u0006¢\u0006\f\n\u0004\b\t\u0010!\u001a\u0004\b\"\u0010#R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\b8\u0006¢\u0006\f\n\u0004\b\n\u0010!\u001a\u0004\b$\u0010#R\u0017\u0010\u000b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001e\u001a\u0004\b%\u0010 R\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010)\u001a\u0004\b*\u0010\u0013¨\u0006+"}, d2 = {"Lcom/stepos/ailauncher/chat/voice/longpress/g0$c;", "", "", "heightPx", "leftMargin", "rightMargin", "Lcom/stepos/ailauncher/chat/voice/longpress/g0$a;", "left", "", "center", "right", "finalizingLeft", "", "statusAlpha", "", "statusText", "<init>", "(IIILcom/stepos/ailauncher/chat/voice/longpress/g0$a;Ljava/util/List;Ljava/util/List;Lcom/stepos/ailauncher/chat/voice/longpress/g0$a;FLjava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "c", "e", Const.INTENT_KEY_BACKGROUND_COMMAND, "Lcom/stepos/ailauncher/chat/voice/longpress/g0$a;", Const.INTENT_KEY_UMID, "()Lcom/stepos/ailauncher/chat/voice/longpress/g0$a;", "Ljava/util/List;", Const.INTENT_KEY_APIKEY, "()Ljava/util/List;", "f", Const.INTENT_KEY_PKGNAME, "F", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()F", "Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.voice.longpress.g0$c, reason: from toString */
    public static final /* data */ class VisualSnapshot {
        private final List<ElementSnapshot> center;
        private final ElementSnapshot finalizingLeft;
        private final int heightPx;
        private final ElementSnapshot left;
        private final int leftMargin;
        private final List<ElementSnapshot> right;
        private final int rightMargin;
        private final float statusAlpha;
        private final String statusText;

        public VisualSnapshot(int i10, int i11, int i12, ElementSnapshot left, List<ElementSnapshot> center, List<ElementSnapshot> right, ElementSnapshot finalizingLeft, float f10, String statusText) {
            kotlin.jvm.internal.p.i(left, "left");
            kotlin.jvm.internal.p.i(center, "center");
            kotlin.jvm.internal.p.i(right, "right");
            kotlin.jvm.internal.p.i(finalizingLeft, "finalizingLeft");
            kotlin.jvm.internal.p.i(statusText, "statusText");
            this.heightPx = i10;
            this.leftMargin = i11;
            this.rightMargin = i12;
            this.left = left;
            this.center = center;
            this.right = right;
            this.finalizingLeft = finalizingLeft;
            this.statusAlpha = f10;
            this.statusText = statusText;
        }

        public final List<ElementSnapshot> a() {
            return this.center;
        }

        /* renamed from: b, reason: from getter */
        public final ElementSnapshot getFinalizingLeft() {
            return this.finalizingLeft;
        }

        /* renamed from: c, reason: from getter */
        public final int getHeightPx() {
            return this.heightPx;
        }

        /* renamed from: d, reason: from getter */
        public final ElementSnapshot getLeft() {
            return this.left;
        }

        /* renamed from: e, reason: from getter */
        public final int getLeftMargin() {
            return this.leftMargin;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VisualSnapshot)) {
                return false;
            }
            VisualSnapshot visualSnapshot = (VisualSnapshot) other;
            return this.heightPx == visualSnapshot.heightPx && this.leftMargin == visualSnapshot.leftMargin && this.rightMargin == visualSnapshot.rightMargin && kotlin.jvm.internal.p.d(this.left, visualSnapshot.left) && kotlin.jvm.internal.p.d(this.center, visualSnapshot.center) && kotlin.jvm.internal.p.d(this.right, visualSnapshot.right) && kotlin.jvm.internal.p.d(this.finalizingLeft, visualSnapshot.finalizingLeft) && Float.compare(this.statusAlpha, visualSnapshot.statusAlpha) == 0 && kotlin.jvm.internal.p.d(this.statusText, visualSnapshot.statusText);
        }

        public final List<ElementSnapshot> f() {
            return this.right;
        }

        /* renamed from: g, reason: from getter */
        public final int getRightMargin() {
            return this.rightMargin;
        }

        /* renamed from: h, reason: from getter */
        public final float getStatusAlpha() {
            return this.statusAlpha;
        }

        public int hashCode() {
            return (((((((((((((((Integer.hashCode(this.heightPx) * 31) + Integer.hashCode(this.leftMargin)) * 31) + Integer.hashCode(this.rightMargin)) * 31) + this.left.hashCode()) * 31) + this.center.hashCode()) * 31) + this.right.hashCode()) * 31) + this.finalizingLeft.hashCode()) * 31) + Float.hashCode(this.statusAlpha)) * 31) + this.statusText.hashCode();
        }

        /* renamed from: i, reason: from getter */
        public final String getStatusText() {
            return this.statusText;
        }

        public String toString() {
            return "VisualSnapshot(heightPx=" + this.heightPx + ", leftMargin=" + this.leftMargin + ", rightMargin=" + this.rightMargin + ", left=" + this.left + ", center=" + this.center + ", right=" + this.right + ", finalizingLeft=" + this.finalizingLeft + ", statusAlpha=" + this.statusAlpha + ", statusText=" + this.statusText + ")";
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0006¨\u0006\n"}, d2 = {"com/stepos/ailauncher/chat/voice/longpress/g0$d", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animator", "LY8/t;", "onAnimationRepeat", "(Landroid/animation/Animator;)V", "onAnimationEnd", "onAnimationCancel", "onAnimationStart", "core-ktx_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d implements Animator.AnimatorListener {
        final /* synthetic */ Ref$BooleanRef $cancelled$inlined;
        final /* synthetic */ Ref$BooleanRef $cancelled$inlined$1;
        final /* synthetic */ long $durationMs$inlined;
        final /* synthetic */ InterfaceC5063a $onFinished$inlined;
        final /* synthetic */ InterfaceC5074l $onFrame$inlined;

        public d(Ref$BooleanRef ref$BooleanRef, InterfaceC5074l interfaceC5074l, long j10, InterfaceC5063a interfaceC5063a, Ref$BooleanRef ref$BooleanRef2) {
            this.$cancelled$inlined = ref$BooleanRef;
            this.$onFrame$inlined = interfaceC5074l;
            this.$durationMs$inlined = j10;
            this.$onFinished$inlined = interfaceC5063a;
            this.$cancelled$inlined$1 = ref$BooleanRef2;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.$cancelled$inlined$1.f34815a = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (g0.this.animator == animator) {
                g0.this.animator = null;
            }
            if (this.$cancelled$inlined.f34815a) {
                return;
            }
            this.$onFrame$inlined.invoke(Long.valueOf(this.$durationMs$inlined));
            this.$onFinished$inlined.invoke();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g0(ViewGroup mainInput, ViewGroup inputContainer, View leftContent, List<? extends View> centerContents, List<? extends View> rightContents, TextView statusTip, View finalizingContent, View finalizingLeftContent, InterfaceC5074l<? super Float, Y8.t> onOutgoingAlphaChanged, InterfaceC5074l<? super Float, Y8.t> onCornerRadiusChanged, InterfaceC5063a<Y8.t> onBoundsChanged, InterfaceC5063a<Boolean> isMultiRow) {
        kotlin.jvm.internal.p.i(mainInput, "mainInput");
        kotlin.jvm.internal.p.i(inputContainer, "inputContainer");
        kotlin.jvm.internal.p.i(leftContent, "leftContent");
        kotlin.jvm.internal.p.i(centerContents, "centerContents");
        kotlin.jvm.internal.p.i(rightContents, "rightContents");
        kotlin.jvm.internal.p.i(statusTip, "statusTip");
        kotlin.jvm.internal.p.i(finalizingContent, "finalizingContent");
        kotlin.jvm.internal.p.i(finalizingLeftContent, "finalizingLeftContent");
        kotlin.jvm.internal.p.i(onOutgoingAlphaChanged, "onOutgoingAlphaChanged");
        kotlin.jvm.internal.p.i(onCornerRadiusChanged, "onCornerRadiusChanged");
        kotlin.jvm.internal.p.i(onBoundsChanged, "onBoundsChanged");
        kotlin.jvm.internal.p.i(isMultiRow, "isMultiRow");
        this.mainInput = mainInput;
        this.inputContainer = inputContainer;
        this.leftContent = leftContent;
        this.centerContents = centerContents;
        this.rightContents = rightContents;
        this.statusTip = statusTip;
        this.finalizingContent = finalizingContent;
        this.finalizingLeftContent = finalizingLeftContent;
        this.onOutgoingAlphaChanged = onOutgoingAlphaChanged;
        this.onCornerRadiusChanged = onCornerRadiusChanged;
        this.onBoundsChanged = onBoundsChanged;
        this.isMultiRow = isMultiRow;
        this.density = mainInput.getResources().getDisplayMetrics().density;
        this.listeningTextColors = statusTip.getTextColors();
        this.geometry = new h0(false, 56.0f);
        ViewGroup.LayoutParams layoutParams = mainInput.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        this.originalMargins = marginLayoutParams != null ? new Margins(marginLayoutParams.leftMargin, marginLayoutParams.rightMargin) : null;
        this.moveCenterHorizontally = true;
        this.recordingHintRes = R$string.speech_release_to_send_swipe_up_to_cancel;
    }

    public static final Y8.t C(g0 g0Var, boolean z10, long j10) {
        g0Var.o(i0.INSTANCE.b(j10, z10));
        return Y8.t.f7040a;
    }

    public static final Y8.t D(g0 g0Var, InterfaceC5063a interfaceC5063a) {
        g0Var.O(false);
        interfaceC5063a.invoke();
        return Y8.t.f7040a;
    }

    public static final Y8.t F(g0 g0Var, VisualSnapshot visualSnapshot, long j10) {
        g0Var.p(i0.INSTANCE.c(j10), visualSnapshot, true);
        return Y8.t.f7040a;
    }

    public static final Y8.t G(g0 g0Var, InterfaceC5063a interfaceC5063a) {
        g0Var.N(true);
        interfaceC5063a.invoke();
        return Y8.t.f7040a;
    }

    public static final Y8.t I(g0 g0Var, VisualSnapshot visualSnapshot, float f10, float f11, long j10) {
        float fD = i0.INSTANCE.d(j10);
        g0Var.q(visualSnapshot, fD);
        float f12 = 1.0f - fD;
        g0Var.finalizingContent.setAlpha(f10 * f12);
        g0Var.statusTip.setAlpha(f11 * f12);
        g0Var.leftContent.setAlpha(g0Var.K(visualSnapshot.getLeft().getAlpha(), 1.0f, fD));
        int i10 = 0;
        int i11 = 0;
        for (Object obj : g0Var.centerContents) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                C1173v.w();
            }
            ((View) obj).setAlpha(g0Var.K(visualSnapshot.a().get(i11).getAlpha(), 1.0f, fD));
            i11 = i12;
        }
        for (Object obj2 : g0Var.rightContents) {
            int i13 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            ((View) obj2).setAlpha(g0Var.K(visualSnapshot.f().get(i10).getAlpha(), 1.0f, fD));
            i10 = i13;
        }
        g0Var.onOutgoingAlphaChanged.invoke(Float.valueOf(fD));
        return Y8.t.f7040a;
    }

    public static final Y8.t J(g0 g0Var, InterfaceC5063a interfaceC5063a) {
        g0Var.L();
        interfaceC5063a.invoke();
        return Y8.t.f7040a;
    }

    public static final void m(InterfaceC5074l interfaceC5074l, long j10, ValueAnimator valueAnimator) {
        kotlin.jvm.internal.p.i(valueAnimator, "valueAnimator");
        interfaceC5074l.invoke(Long.valueOf((long) (j10 * valueAnimator.getAnimatedFraction())));
    }

    public static final Y8.t v(g0 g0Var, VisualSnapshot visualSnapshot, long j10) {
        g0Var.p(i0.INSTANCE.c(j10), visualSnapshot, false);
        return Y8.t.f7040a;
    }

    public static final Y8.t w(g0 g0Var, InterfaceC5063a interfaceC5063a) {
        g0Var.L();
        interfaceC5063a.invoke();
        return Y8.t.f7040a;
    }

    public final float A(float value) {
        return value * this.density;
    }

    public final void B(final boolean moveCenterHorizontally, int recordingHintRes, final InterfaceC5063a<Y8.t> onFinished) {
        kotlin.jvm.internal.p.i(onFinished, "onFinished");
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.recordingHintRes = recordingHintRes;
        this.recordingRemainingMs = null;
        this.inCancelState = false;
        this.moveCenterHorizontally = moveCenterHorizontally;
        this.originalInputHeight = Integer.valueOf(this.inputContainer.getLayoutParams().height);
        this.geometry = new h0(this.isMultiRow.invoke().booleanValue(), this.inputContainer.getHeight() / this.density);
        ViewGroup.LayoutParams layoutParams = this.mainInput.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        this.originalMargins = marginLayoutParams != null ? new Margins(marginLayoutParams.leftMargin, marginLayoutParams.rightMargin) : null;
        this.onCornerRadiusChanged.invoke(Float.valueOf(this.geometry.b(56.0f)));
        int iZ = z(this.geometry.e());
        Margins margins = this.originalMargins;
        int left = margins != null ? margins.getLeft() : 0;
        Margins margins2 = this.originalMargins;
        this.plannedWidthExpansionPx = C5685n.f(Math.min(iZ, Math.min(left, margins2 != null ? margins2.getRight() : 0) * 2), 0);
        this.finalizingContent.setVisibility(4);
        this.finalizingContent.setAlpha(0.0f);
        this.statusTip.setText(recordingHintRes);
        this.statusTip.setTextColor(this.listeningTextColors);
        this.statusTip.setVisibility(0);
        this.statusTip.setAlpha(1.0f);
        O(true);
        l(300L, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.voice.longpress.e0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return g0.C(this.f26464a, moveCenterHorizontally, ((Long) obj).longValue());
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.voice.longpress.f0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return g0.D(this.f26468a, onFinished);
            }
        });
    }

    public final void E(final InterfaceC5063a<Y8.t> onFinished) {
        kotlin.jvm.internal.p.i(onFinished, "onFinished");
        final VisualSnapshot visualSnapshotY = y();
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.finalizingContent.setVisibility(0);
        this.finalizingContent.setAlpha(0.0f);
        this.statusTip.setVisibility(0);
        O(false);
        N(false);
        l(250L, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.voice.longpress.a0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return g0.F(this.f26453a, visualSnapshotY, ((Long) obj).longValue());
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.voice.longpress.b0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return g0.G(this.f26456a, onFinished);
            }
        });
    }

    public final void H(final InterfaceC5063a<Y8.t> onFinished) {
        kotlin.jvm.internal.p.i(onFinished, "onFinished");
        final VisualSnapshot visualSnapshotY = y();
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        final float alpha = this.finalizingContent.getAlpha();
        final float alpha2 = this.statusTip.getAlpha();
        l(150L, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.voice.longpress.c0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return g0.I(this.f26458a, visualSnapshotY, alpha, alpha2, ((Long) obj).longValue());
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.voice.longpress.d0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return g0.J(this.f26462a, onFinished);
            }
        });
    }

    public final float K(float start, float end, float progress) {
        return start + ((end - start) * progress);
    }

    public final void L() {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.recordingHintRes = R$string.speech_release_to_send_swipe_up_to_cancel;
        this.recordingRemainingMs = null;
        this.inCancelState = false;
        this.statusTip.setTextColor(this.listeningTextColors);
        this.animator = null;
        Integer num = this.originalInputHeight;
        if (num != null) {
            int iIntValue = num.intValue();
            ViewGroup viewGroup = this.inputContainer;
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            layoutParams.height = iIntValue;
            viewGroup.setLayoutParams(layoutParams);
        }
        this.originalInputHeight = null;
        this.onCornerRadiusChanged.invoke(null);
        Margins margins = this.originalMargins;
        if (margins != null) {
            ViewGroup.LayoutParams layoutParams2 = this.mainInput.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : null;
            if (marginLayoutParams != null) {
                marginLayoutParams.leftMargin = margins.getLeft();
                marginLayoutParams.rightMargin = margins.getRight();
                this.mainInput.setLayoutParams(marginLayoutParams);
            }
        }
        this.leftContent.setTranslationX(0.0f);
        this.leftContent.setTranslationY(0.0f);
        for (View view : this.centerContents) {
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
            view.setAlpha(1.0f);
        }
        for (View view2 : this.rightContents) {
            view2.setTranslationX(0.0f);
            view2.setTranslationY(0.0f);
            view2.setAlpha(1.0f);
        }
        this.leftContent.setAlpha(1.0f);
        O(true);
        N(false);
        this.finalizingContent.setAlpha(0.0f);
        this.finalizingContent.setVisibility(4);
        this.finalizingLeftContent.setTranslationX(0.0f);
        this.finalizingLeftContent.setTranslationY(0.0f);
        this.statusTip.setAlpha(0.0f);
        this.statusTip.setVisibility(8);
        this.inputContainer.requestLayout();
        this.mainInput.requestLayout();
        this.onBoundsChanged.invoke();
    }

    public final void M(boolean cancel) {
        this.inCancelState = cancel;
        R();
    }

    public final void N(boolean interactive) {
        View viewFindViewById = this.finalizingContent.findViewById(R$id.voice_finalizing_stop);
        if (viewFindViewById != null) {
            viewFindViewById.setClickable(interactive);
        }
        if (viewFindViewById != null) {
            viewFindViewById.setEnabled(interactive);
        }
        if (viewFindViewById != null) {
            viewFindViewById.setImportantForAccessibility(interactive ? 1 : 2);
        }
    }

    public final void O(boolean accessible) {
        int i10 = accessible ? 0 : 4;
        this.leftContent.setImportantForAccessibility(i10);
        Iterator<T> it = this.centerContents.iterator();
        while (it.hasNext()) {
            ((View) it.next()).setImportantForAccessibility(i10);
        }
        Iterator<T> it2 = this.rightContents.iterator();
        while (it2.hasNext()) {
            ((View) it2.next()).setImportantForAccessibility(i10);
        }
    }

    public final void P(int hintRes) {
        this.recordingHintRes = hintRes;
        if (this.finalizingContent.getVisibility() != 0) {
            this.statusTip.setVisibility(0);
            this.statusTip.setAlpha(1.0f);
        }
        R();
    }

    public final void Q(long remainingMs) {
        this.recordingRemainingMs = Long.valueOf(remainingMs);
        R();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void R() {
        /*
            r7 = this;
            android.widget.TextView r0 = r7.statusTip
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L79
            android.view.View r0 = r7.finalizingContent
            int r0 = r0.getVisibility()
            if (r0 == 0) goto L79
            boolean r0 = r7.inCancelState
            if (r0 == 0) goto L1c
            android.widget.TextView r0 = r7.statusTip
            r1 = -16886(0xffffffffffffbe0a, float:NaN)
            r0.setTextColor(r1)
            goto L23
        L1c:
            android.widget.TextView r0 = r7.statusTip
            android.content.res.ColorStateList r1 = r7.listeningTextColors
            r0.setTextColor(r1)
        L23:
            java.lang.Long r0 = r7.recordingRemainingMs
            android.widget.TextView r1 = r7.statusTip
            boolean r2 = r7.inCancelState
            if (r2 == 0) goto L36
            android.content.Context r7 = r1.getContext()
            int r0 = com.stepos.ailauncher.speech.R$string.speech_release_to_cancel
            java.lang.String r7 = r7.getString(r0)
            goto L76
        L36:
            if (r0 == 0) goto L6a
            long r2 = r0.longValue()
            r4 = 1
            int r4 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r4 > 0) goto L6a
            r4 = 30001(0x7531, double:1.48225E-319)
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 >= 0) goto L6a
            android.widget.TextView r7 = r7.statusTip
            android.content.Context r7 = r7.getContext()
            int r2 = com.stepos.ailauncher.chat.R$string.voice_recording_stops_in_seconds
            long r3 = r0.longValue()
            r0 = 999(0x3e7, float:1.4E-42)
            long r5 = (long) r0
            long r3 = r3 + r5
            r0 = 1000(0x3e8, float:1.401E-42)
            long r5 = (long) r0
            long r3 = r3 / r5
            int r0 = (int) r3
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.Object[] r0 = new java.lang.Object[]{r0}
            java.lang.String r7 = r7.getString(r2, r0)
            goto L76
        L6a:
            android.widget.TextView r0 = r7.statusTip
            android.content.Context r0 = r0.getContext()
            int r7 = r7.recordingHintRes
            java.lang.String r7 = r0.getString(r7)
        L76:
            r1.setText(r7)
        L79:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.voice.longpress.g0.R():void");
    }

    public final void l(final long durationMs, final InterfaceC5074l<? super Long, Y8.t> onFrame, InterfaceC5063a<Y8.t> onFinished) {
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(durationMs);
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.ailauncher.chat.voice.longpress.Z
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                g0.m(onFrame, durationMs, valueAnimator);
            }
        });
        kotlin.jvm.internal.p.f(valueAnimatorOfFloat);
        valueAnimatorOfFloat.addListener(new d(ref$BooleanRef, onFrame, durationMs, onFinished, ref$BooleanRef));
        valueAnimatorOfFloat.start();
        this.animator = valueAnimatorOfFloat;
    }

    public final void n(View view, float pageDeltaDp) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ConstraintLayout.b bVar = layoutParams instanceof ConstraintLayout.b ? (ConstraintLayout.b) layoutParams : null;
        float f10 = 1.0f;
        if (bVar != null) {
            int i10 = bVar.f12642i;
            if (i10 == 0 && bVar.f12648l == 0) {
                f10 = bVar.f12607H;
            } else if (i10 == 0) {
                f10 = 0.0f;
            }
        }
        view.setTranslationY(A(this.geometry.d(pageDeltaDp, this.inputContainer.getLayoutParams().height / this.density, f10)));
    }

    public final void o(i0.Frame frame) {
        s(frame);
        this.leftContent.setAlpha(frame.getOutgoingAlpha());
        Iterator<T> it = this.centerContents.iterator();
        while (it.hasNext()) {
            ((View) it.next()).setAlpha(frame.getOutgoingAlpha());
        }
        Iterator<T> it2 = this.rightContents.iterator();
        while (it2.hasNext()) {
            ((View) it2.next()).setAlpha(frame.getOutgoingAlpha());
        }
        this.onOutgoingAlphaChanged.invoke(Float.valueOf(frame.getOutgoingAlpha()));
        this.statusTip.setAlpha(frame.getListeningAlpha());
    }

    public final void p(i0.Frame frame, VisualSnapshot start, boolean showFinalizing) {
        q(start, C5685n.m((88.0f - frame.getHeightDp()) / 32.0f, 0.0f, 1.0f));
        float statusAlpha = start.getStatusAlpha() * frame.getListeningAlpha();
        this.finalizingContent.setAlpha(showFinalizing ? frame.getFinalizingAlpha() : 0.0f);
        if (showFinalizing) {
            r(frame);
        }
        float listeningAlpha = 1.0f - frame.getListeningAlpha();
        int i10 = 0;
        if (!showFinalizing) {
            this.statusTip.setAlpha(statusAlpha);
            this.leftContent.setAlpha(K(start.getLeft().getAlpha(), 1.0f, listeningAlpha));
            int i11 = 0;
            for (Object obj : this.centerContents) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    C1173v.w();
                }
                ((View) obj).setAlpha(K(start.a().get(i11).getAlpha(), 1.0f, listeningAlpha));
                i11 = i12;
            }
            for (Object obj2 : this.rightContents) {
                int i13 = i10 + 1;
                if (i10 < 0) {
                    C1173v.w();
                }
                ((View) obj2).setAlpha(K(start.f().get(i10).getAlpha(), 1.0f, listeningAlpha));
                i10 = i13;
            }
            return;
        }
        this.leftContent.setAlpha(start.getLeft().getAlpha() * frame.getListeningAlpha());
        int i14 = 0;
        for (Object obj3 : this.centerContents) {
            int i15 = i14 + 1;
            if (i14 < 0) {
                C1173v.w();
            }
            ((View) obj3).setAlpha(start.a().get(i14).getAlpha() * frame.getListeningAlpha());
            i14 = i15;
        }
        for (Object obj4 : this.rightContents) {
            int i16 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            ((View) obj4).setAlpha(start.f().get(i10).getAlpha() * frame.getListeningAlpha());
            i10 = i16;
        }
        this.statusTip.setText(start.getStatusText());
        this.statusTip.setAlpha(statusAlpha);
    }

    public final void q(VisualSnapshot start, float progress) {
        ViewGroup viewGroup = this.inputContainer;
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        layoutParams.height = C5227b.b(K(start.getHeightPx(), A(this.geometry.c(56.0f)), progress));
        viewGroup.setLayoutParams(layoutParams);
        this.onCornerRadiusChanged.invoke(Float.valueOf(this.geometry.b(this.inputContainer.getLayoutParams().height / this.density)));
        if (this.originalMargins != null) {
            ViewGroup.LayoutParams layoutParams2 = this.mainInput.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : null;
            if (marginLayoutParams != null) {
                marginLayoutParams.leftMargin = C5227b.b(K(start.getLeftMargin(), r0.getLeft(), progress));
                marginLayoutParams.rightMargin = C5227b.b(K(start.getRightMargin(), r0.getRight(), progress));
                this.mainInput.setLayoutParams(marginLayoutParams);
            }
        }
        t(this.leftContent, start.getLeft(), progress);
        int i10 = 0;
        int i11 = 0;
        for (Object obj : this.centerContents) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                C1173v.w();
            }
            t((View) obj, start.a().get(i11), progress);
            i11 = i12;
        }
        for (Object obj2 : this.rightContents) {
            int i13 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            t((View) obj2, start.f().get(i10), progress);
            i10 = i13;
        }
        t(this.finalizingLeftContent, start.getFinalizingLeft(), progress);
        this.inputContainer.requestLayout();
        this.mainInput.requestLayout();
        this.onBoundsChanged.invoke();
    }

    public final void r(i0.Frame frame) {
        this.finalizingLeftContent.setTranslationX(A(frame.getFinalizingLeftTranslationXDp()));
        this.finalizingLeftContent.setTranslationY(A(frame.getFinalizingLeftTranslationYDp()));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void s(com.stepos.ailauncher.chat.voice.longpress.i0.Frame r8) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.voice.longpress.g0.s(com.stepos.ailauncher.chat.voice.longpress.i0$a):void");
    }

    public final void t(View view, ElementSnapshot start, float progress) {
        view.setTranslationX(K(start.getTranslationX(), 0.0f, progress));
        view.setTranslationY(K(start.getTranslationY(), 0.0f, progress));
    }

    public final void u(final InterfaceC5063a<Y8.t> onFinished) {
        kotlin.jvm.internal.p.i(onFinished, "onFinished");
        final VisualSnapshot visualSnapshotY = y();
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.finalizingContent.setVisibility(4);
        this.finalizingContent.setAlpha(0.0f);
        this.statusTip.setVisibility(0);
        O(false);
        N(false);
        l(250L, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.voice.longpress.X
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return g0.v(this.f26446a, visualSnapshotY, ((Long) obj).longValue());
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.voice.longpress.Y
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return g0.w(this.f26448a, onFinished);
            }
        });
    }

    public final ElementSnapshot x(View view) {
        return new ElementSnapshot(view.getTranslationX(), view.getTranslationY(), view.getAlpha());
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005d A[LOOP:0: B:21:0x0057->B:23:0x005d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0082 A[LOOP:1: B:25:0x007c->B:27:0x0082, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.ailauncher.chat.voice.longpress.g0.VisualSnapshot y() {
        /*
            r13 = this;
            android.view.ViewGroup r0 = r13.mainInput
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            boolean r1 = r0 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r1 == 0) goto Ld
            android.view.ViewGroup$MarginLayoutParams r0 = (android.view.ViewGroup.MarginLayoutParams) r0
            goto Le
        Ld:
            r0 = 0
        Le:
            android.view.ViewGroup r1 = r13.inputContainer
            int r1 = r1.getHeight()
            r2 = 1113587712(0x42600000, float:56.0)
            int r2 = r13.z(r2)
            int r4 = v9.C5685n.f(r1, r2)
            r1 = 0
            if (r0 == 0) goto L25
            int r2 = r0.leftMargin
        L23:
            r5 = r2
            goto L2f
        L25:
            com.stepos.ailauncher.chat.voice.longpress.g0$b r2 = r13.originalMargins
            if (r2 == 0) goto L2e
            int r2 = r2.getLeft()
            goto L23
        L2e:
            r5 = r1
        L2f:
            if (r0 == 0) goto L35
            int r1 = r0.rightMargin
        L33:
            r6 = r1
            goto L3e
        L35:
            com.stepos.ailauncher.chat.voice.longpress.g0$b r0 = r13.originalMargins
            if (r0 == 0) goto L33
            int r1 = r0.getRight()
            goto L33
        L3e:
            android.view.View r0 = r13.leftContent
            com.stepos.ailauncher.chat.voice.longpress.g0$a r7 = r13.x(r0)
            java.util.List<android.view.View> r0 = r13.centerContents
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r8 = new java.util.ArrayList
            r1 = 10
            int r2 = Z8.C1174w.x(r0, r1)
            r8.<init>(r2)
            java.util.Iterator r0 = r0.iterator()
        L57:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L6b
            java.lang.Object r2 = r0.next()
            android.view.View r2 = (android.view.View) r2
            com.stepos.ailauncher.chat.voice.longpress.g0$a r2 = r13.x(r2)
            r8.add(r2)
            goto L57
        L6b:
            java.util.List<android.view.View> r0 = r13.rightContents
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r9 = new java.util.ArrayList
            int r1 = Z8.C1174w.x(r0, r1)
            r9.<init>(r1)
            java.util.Iterator r0 = r0.iterator()
        L7c:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L90
            java.lang.Object r1 = r0.next()
            android.view.View r1 = (android.view.View) r1
            com.stepos.ailauncher.chat.voice.longpress.g0$a r1 = r13.x(r1)
            r9.add(r1)
            goto L7c
        L90:
            android.view.View r0 = r13.finalizingLeftContent
            com.stepos.ailauncher.chat.voice.longpress.g0$a r10 = r13.x(r0)
            android.widget.TextView r0 = r13.statusTip
            float r11 = r0.getAlpha()
            android.widget.TextView r13 = r13.statusTip
            java.lang.CharSequence r13 = r13.getText()
            java.lang.String r12 = r13.toString()
            com.stepos.ailauncher.chat.voice.longpress.g0$c r3 = new com.stepos.ailauncher.chat.voice.longpress.g0$c
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.voice.longpress.g0.y():com.stepos.ailauncher.chat.voice.longpress.g0$c");
    }

    public final int z(float value) {
        return (int) ((value * this.density) + 0.5f);
    }
}

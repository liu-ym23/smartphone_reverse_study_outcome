package com.obric.utils.views.commonitemview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.obric.callsummary.CallSummaryGenerateManagerKt;
import com.obric.common.oea.foundation.animation.builder.PropertyAnimatable;
import com.obric.common.oea.foundation.animation.builder.PropertyAnimatableKt;
import com.obric.common.oea.foundation.animation.constants.RepeatMode;
import com.obric.common.oea.foundation.animation.constants.RunMode;
import com.obric.common.oea.foundation.animation.manager.AnimationManager;
import com.obric.common.oea.foundation.animation.spec.AnimationSpecKt;
import com.obric.common.oea.foundation.animation.spec.spring.FloatSpringSpec;
import com.obric.common.oea.foundation.animation.token.AnimationProperty;
import com.obric.common.oea.foundation.animation.token.Token;
import com.obric.oui.texteffects.ODimPointGenerateEffectView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: CallLogSummaryCardView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u008d\u00012\u00020\u0001:\u000e\u008c\u0001\u008d\u0001\u008e\u0001\u008f\u0001\u0090\u0001\u0091\u0001\u0092\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010.\u001a\u00020/H\u0002J\u0010\u00100\u001a\u00020 2\u0006\u00101\u001a\u00020\u0007H\u0002J\u000e\u00102\u001a\u00020 2\u0006\u00103\u001a\u00020\u000eJ\b\u00104\u001a\u00020 H\u0002J\u0010\u00105\u001a\u0002062\u0006\u00103\u001a\u00020\u000eH\u0002J\u0016\u00107\u001a\u00020\u00162\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;J\b\u0010<\u001a\u00020 H\u0002J\b\u0010=\u001a\u00020 H\u0002J\b\u0010>\u001a\u00020 H\u0002J\u0010\u0010?\u001a\u00020\u00162\u0006\u0010@\u001a\u00020AH\u0002J\u0010\u0010B\u001a\u00020\u00162\u0006\u0010@\u001a\u00020AH\u0002J\u0014\u0010C\u001a\u0004\u0018\u00010;2\b\u0010D\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010E\u001a\u00020\u001bH\u0002J\b\u0010F\u001a\u00020/H\u0002J\b\u0010G\u001a\u00020 H\u0002J\b\u0010H\u001a\u00020\u0007H\u0002J\u001c\u0010I\u001a\u00020\u00162\b\u0010D\u001a\u0004\u0018\u00010\f2\b\u0010J\u001a\u0004\u0018\u00010KH\u0002J$\u0010L\u001a\u00020\u00162\b\u0010D\u001a\u0004\u0018\u00010\f2\u0006\u0010M\u001a\u00020N2\b\u0010J\u001a\u0004\u0018\u00010KH\u0002J\u0006\u0010O\u001a\u00020 J\u0006\u0010P\u001a\u00020\u0016J\u0012\u0010Q\u001a\u00020;2\b\u0010D\u001a\u0004\u0018\u00010\fH\u0002J\u0012\u0010R\u001a\u00020;2\b\u0010J\u001a\u0004\u0018\u00010KH\u0002J\u0012\u0010S\u001a\u00020;2\b\u0010J\u001a\u0004\u0018\u00010KH\u0002J\b\u0010T\u001a\u00020 H\u0014J\u0012\u0010U\u001a\u00020 2\b\u0010D\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010V\u001a\u00020 2\u0006\u0010W\u001a\u00020\u0007H\u0002J\b\u0010X\u001a\u00020\u0007H\u0002J\u0012\u0010Y\u001a\u00020 2\b\u0010D\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010Z\u001a\u00020 H\u0002J$\u0010[\u001a\u00020 2\b\u0010D\u001a\u0004\u0018\u00010\f2\u0006\u0010M\u001a\u00020N2\b\u0010J\u001a\u0004\u0018\u00010KH\u0002J\u001a\u0010\\\u001a\u00020 2\b\u0010D\u001a\u0004\u0018\u00010\f2\u0006\u0010]\u001a\u00020KH\u0002J$\u0010^\u001a\u00020 2\b\u0010D\u001a\u0004\u0018\u00010\f2\u0006\u0010]\u001a\u00020K2\b\b\u0002\u0010_\u001a\u00020\u0016H\u0002J.\u0010`\u001a\u00020 2\b\u0010D\u001a\u0004\u0018\u00010\f2\u0006\u0010a\u001a\u00020K2\b\b\u0002\u0010_\u001a\u00020\u00162\b\b\u0002\u0010b\u001a\u00020\u0016H\u0002J\u001a\u0010c\u001a\u00020 2\b\u0010D\u001a\u0004\u0018\u00010\f2\u0006\u0010a\u001a\u00020KH\u0002J\u001a\u0010d\u001a\u00020 2\b\u0010e\u001a\u0004\u0018\u00010\u000e2\u0006\u00103\u001a\u00020\u000eH\u0002J\b\u0010f\u001a\u00020 H\u0002J\b\u0010g\u001a\u00020 H\u0002J\u0010\u0010h\u001a\u00020A2\u0006\u0010i\u001a\u000206H\u0002J\b\u0010j\u001a\u00020 H\u0002J\u0012\u0010k\u001a\u00020 2\b\u0010D\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010l\u001a\u00020 2\b\u0010m\u001a\u0004\u0018\u00010nJ\u0010\u0010o\u001a\u00020\u00162\u0006\u0010@\u001a\u00020AH\u0002J\u0010\u0010p\u001a\u00020\u00162\u0006\u0010@\u001a\u00020AH\u0002J\"\u0010q\u001a\u00020\u00162\u0006\u0010r\u001a\u00020\u00162\u0006\u0010s\u001a\u00020\u00162\b\u0010t\u001a\u0004\u0018\u00010KH\u0002J4\u0010u\u001a\u00020\u00162\u0006\u0010r\u001a\u00020\u00162\u0006\u0010s\u001a\u00020\u00162\b\u0010D\u001a\u0004\u0018\u00010\f2\u0006\u0010a\u001a\u00020K2\b\u0010t\u001a\u0004\u0018\u00010KH\u0002JG\u0010v\u001a\u00020 2\f\u0010w\u001a\b\u0012\u0004\u0012\u00020y0x2\f\u0010z\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112!\u0010{\u001a\u001d\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b}\u0012\b\b~\u0012\u0004\b\b(\u007f\u0012\u0004\u0012\u00020 0|H\u0002J\t\u0010\u0080\u0001\u001a\u00020 H\u0002J\t\u0010\u0081\u0001\u001a\u00020 H\u0002J(\u0010\u0082\u0001\u001a\u00030\u0083\u00012\b\u0010\u0084\u0001\u001a\u00030\u0085\u00012\b\u0010\u0086\u0001\u001a\u00030\u0087\u00012\b\u0010\u0088\u0001\u001a\u00030\u0089\u0001H\u0002J\t\u0010\u008a\u0001\u001a\u00020/H\u0002J\u0013\u0010\u008b\u0001\u001a\u00020 2\b\u0010D\u001a\u0004\u0018\u00010\fH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0012\u0010%\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010&R\u0010\u0010'\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0093\u0001"}, d2 = {"Lcom/obric/utils/views/commonitemview/CallLogSummaryCardView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cardView", "Landroid/view/View;", "collapsingItemKey", "Lcom/obric/utils/views/commonitemview/CallLogSummaryCardView$ItemKey;", "currentData", "Lcom/obric/utils/views/commonitemview/CallLogSummaryCardView$BindData;", "currentItemKey", "failureCollapseAnimators", "", "Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "failureCollapseRunnable", "Ljava/lang/Runnable;", "hasConsumedFailureCollapse", "", "hasConsumedInitialExpand", "initialExpandAnimators", "isLeftIconAnimating", "leftIconDrawable", "Landroid/graphics/drawable/Drawable;", "leftIconView", "Landroid/widget/ImageView;", "onConsumeTempFailure", "Lkotlin/Function0;", "", "getOnConsumeTempFailure", "()Lkotlin/jvm/functions/Function0;", "setOnConsumeTempFailure", "(Lkotlin/jvm/functions/Function0;)V", "originalTopMargin", "Ljava/lang/Integer;", "pendingFailureCollapseItemKey", "rightIconView", "scheduledFailureCollapseItemKey", "textEffectView", "Lcom/obric/oui/texteffects/ODimPointGenerateEffectView;", "textRenderSnapshot", "Lcom/obric/utils/views/commonitemview/CallLogSummaryCardView$TextRenderSnapshot;", "appearStartCardTranslationY", "", "applyAnimatedLayoutSpace", "totalHeight", "bind", "data", "bindLeftIcon", "buildStateInput", "Lcom/obric/utils/views/commonitemview/CallLogSummaryCardView$StateInput;", "canKeepTempFailure", "date", "", "number", "", "cancelFailureCollapseAnimation", "cancelFailureCollapseRequest", "cancelInitialExpandAnimation", "consumeFailureCollapseOnce", "state", "Lcom/obric/utils/views/commonitemview/CallLogSummaryCardView$UiState;", "consumeInitialExpandOnce", "consumptionKey", "itemKey", "createLeftIconDrawable", "disappearEndCardTranslationY", "ensureCardVisible", "getInitialExpandTargetHeight", "hasChangedContentPendingText", "text", "", "hasSameTextRender", "mode", "Lcom/obric/utils/views/commonitemview/CallLogSummaryCardView$TextRenderMode;", "hideCard", "isCardVisible", "logKey", "logText", "normalizeText", "onDetachedFromWindow", "playFailureCollapseAnimation", "playInitialExpandAnimation", "targetHeight", "prepareInitialExpandAnimation", "refreshForPendingFailureCollapse", "rememberOriginalTopMargin", "rememberTextRender", "renderContentPending", "contentText", "renderContentText", "preferStatic", "renderPromptFailure", "promptText", "collapseAfterRender", "renderPromptPending", "resetFailureCollapseConsumptionIfNewWorking", "previousData", "resetFailureCollapseVisuals", "resetInitialExpandVisuals", "resolveUiState", "input", "restoreNaturalLayout", "scheduleFailureCollapse", "setOnCardClickListener", "listener", "Landroid/view/View$OnClickListener;", "shouldConsumeFailureCollapse", "shouldConsumeInitialExpand", "shouldShowContentPending", "isWorking", "hasSummary", "summaryText", "shouldUseStaticText", "startAnimators", "builders", "", "Lcom/obric/common/oea/foundation/animation/builder/PropertyAnimatable$Builder;", "holders", "onFinished", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "finished", "startLeftIconAnimation", "stopLeftIconAnimation", "summaryScaleSpring", "Lcom/obric/common/oea/foundation/animation/spec/spring/FloatSpringSpec;", "bounce", "Lcom/obric/common/oea/foundation/animation/token/Token$Bounce;", "duration", "Lcom/obric/common/oea/foundation/animation/token/Token$Duration;", "delay", "Lcom/obric/common/oea/foundation/animation/token/Token$Delay;", "targetCardTranslationY", "updateConsumptionScope", "BindData", "Companion", "ItemKey", "StateInput", "TextRenderMode", "TextRenderSnapshot", "UiState", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CallLogSummaryCardView extends FrameLayout {
    private static final float CARD_APPEAR_START_SCALE = 0.95f;
    private static final int CARD_APPEAR_START_TRANSLATION_Y_DP = -4;
    private static final float CARD_DISAPPEAR_END_SCALE = 0.95f;
    private static final int CARD_DISAPPEAR_END_TRANSLATION_Y_DP = -4;
    private static final int CARD_LIST_OFFSET_DP = 38;
    private static final int CARD_TOP_SPACE_DP = 6;
    private static final int CARD_VISIBLE_HEIGHT_DP = 32;
    private static final Companion Companion = null;
    private static final long FAILURE_COLLAPSE_DELAY_MS = 3000;
    private static final int INITIAL_EXPAND_KEY_LIMIT = 500;
    private static final float SPRING_SPEC_ACCURACY = 1.0E-4f;
    private static final LinkedHashSet<String> consumedInitialExpandKeys = null;
    private final View cardView;
    private ItemKey collapsingItemKey;
    private BindData currentData;
    private ItemKey currentItemKey;
    private final List<AnimationManager> failureCollapseAnimators;
    private Runnable failureCollapseRunnable;
    private boolean hasConsumedFailureCollapse;
    private boolean hasConsumedInitialExpand;
    private final List<AnimationManager> initialExpandAnimators;
    private boolean isLeftIconAnimating;
    private Drawable leftIconDrawable;
    private final ImageView leftIconView;
    private Function0<Unit> onConsumeTempFailure;
    private Integer originalTopMargin;
    private ItemKey pendingFailureCollapseItemKey;
    private final ImageView rightIconView;
    private ItemKey scheduledFailureCollapseItemKey;
    private final ODimPointGenerateEffectView textEffectView;
    private TextRenderSnapshot textRenderSnapshot;

    /* JADX INFO: compiled from: CallLogSummaryCardView.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b \n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000b¢\u0006\u0002\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u000bHÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010$\u001a\u00020\u000bHÆ\u0003J\t\u0010%\u001a\u00020\u000bHÆ\u0003J\t\u0010&\u001a\u00020\u000bHÆ\u0003J\t\u0010'\u001a\u00020\u000bHÆ\u0003Jq\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000bHÆ\u0001J\u0013\u0010)\u001a\u00020\u000b2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\r\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u000f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014¨\u0006."}, d2 = {"Lcom/obric/utils/views/commonitemview/CallLogSummaryCardView$BindData;", "", "date", "", "number", "", "summaryText", "", "promptText", "failureText", "summaryEnabled", "", "isWorking", "hasSummary", "hasFailure", "hasTempFailure", "(JLjava/lang/String;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZZZZZ)V", "getDate", "()J", "getFailureText", "()Ljava/lang/CharSequence;", "getHasFailure", "()Z", "getHasSummary", "getHasTempFailure", "getNumber", "()Ljava/lang/String;", "getPromptText", "getSummaryEnabled", "getSummaryText", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class BindData {
        private final long date;
        private final CharSequence failureText;
        private final boolean hasFailure;
        private final boolean hasSummary;
        private final boolean hasTempFailure;
        private final boolean isWorking;
        private final String number;
        private final CharSequence promptText;
        private final boolean summaryEnabled;
        private final CharSequence summaryText;

        public static /* synthetic */ BindData copy$default(BindData r12, long r13, String r15, CharSequence r16, CharSequence r17, CharSequence r18, boolean r19, boolean r20, boolean r21, boolean r22, boolean r23, int r24, Object r25) {
            if ((r24 & 1) == 0) goto L5;
            long r2 = r12.date;
        L7:
            if ((r24 & 2) == 0) goto L9;
            String r4 = r12.number;
        L11:
            if ((r24 & 4) == 0) goto L13;
            CharSequence r5 = r12.summaryText;
        L15:
            if ((r24 & 8) == 0) goto L17;
            CharSequence r6 = r12.promptText;
        L19:
            if ((r24 & 16) == 0) goto L21;
            CharSequence r7 = r12.failureText;
        L23:
            if ((r24 & 32) == 0) goto L25;
            boolean r8 = r12.summaryEnabled;
        L27:
            if ((r24 & 64) == 0) goto L29;
            boolean r9 = r12.isWorking;
        L31:
            if ((r24 & 128) == 0) goto L33;
            boolean r10 = r12.hasSummary;
        L35:
            if ((r24 & 256) == 0) goto L37;
            boolean r11 = r12.hasFailure;
        L39:
            if ((r24 & 512) == 0) goto L41;
            boolean r1 = r12.hasTempFailure;
        L43:
            return r12.copy(r2, r4, r5, r6, r7, r8, r9, r10, r11, r1);
        L41:
            r1 = r23;
            goto L43
        L37:
            r11 = r22;
            goto L39
        L33:
            r10 = r21;
            goto L35
        L29:
            r9 = r20;
            goto L31
        L25:
            r8 = r19;
            goto L27
        L21:
            r7 = r18;
            goto L23
        L17:
            r6 = r17;
            goto L19
        L13:
            r5 = r16;
            goto L15
        L9:
            r4 = r15;
            goto L11
        L5:
            r2 = r13;
            goto L7
        }

        public final long component1() {
            return this.date;
        }

        public final boolean component10() {
            return this.hasTempFailure;
        }

        public final String component2() {
            return this.number;
        }

        public final CharSequence component3() {
            return this.summaryText;
        }

        public final CharSequence component4() {
            return this.promptText;
        }

        public final CharSequence component5() {
            return this.failureText;
        }

        public final boolean component6() {
            return this.summaryEnabled;
        }

        public final boolean component7() {
            return this.isWorking;
        }

        public final boolean component8() {
            return this.hasSummary;
        }

        public final boolean component9() {
            return this.hasFailure;
        }

        public final BindData copy(long r14, String r16, CharSequence r17, CharSequence r18, CharSequence r19, boolean r20, boolean r21, boolean r22, boolean r23, boolean r24) {
            Intrinsics.checkNotNullParameter(r16, "number");
            Intrinsics.checkNotNullParameter(r18, "promptText");
            return new BindData(r14, r16, r17, r18, r19, r20, r21, r22, r23, r24);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof BindData) == true) goto L8;
            return false;
        L8:
            BindData r9 = (BindData) r8;
            if (this.date == r9.date) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.number, r9.number) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.summaryText, r9.summaryText) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.promptText, r9.promptText) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.failureText, r9.failureText) == true) goto L24;
            return false;
        L24:
            if (this.summaryEnabled == r9.summaryEnabled) goto L27;
            return false;
        L27:
            if (this.isWorking == r9.isWorking) goto L30;
            return false;
        L30:
            if (this.hasSummary == r9.hasSummary) goto L33;
            return false;
        L33:
            if (this.hasFailure == r9.hasFailure) goto L36;
            return false;
        L36:
            if (this.hasTempFailure == r9.hasTempFailure) goto L38;
            return false;
        L38:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v11, types: [int] */
        /* JADX WARN: Type inference failed for: r0v13, types: [int] */
        /* JADX WARN: Type inference failed for: r0v15, types: [int] */
        /* JADX WARN: Type inference failed for: r0v17, types: [int] */
        /* JADX WARN: Type inference failed for: r0v19, types: [int] */
        /* JADX WARN: Type inference failed for: r1v11, types: [int] */
        /* JADX WARN: Type inference failed for: r1v13, types: [int] */
        /* JADX WARN: Type inference failed for: r1v15, types: [int] */
        /* JADX WARN: Type inference failed for: r1v16 */
        /* JADX WARN: Type inference failed for: r1v17 */
        /* JADX WARN: Type inference failed for: r1v18 */
        /* JADX WARN: Type inference failed for: r1v19 */
        /* JADX WARN: Type inference failed for: r1v21 */
        /* JADX WARN: Type inference failed for: r1v22 */
        /* JADX WARN: Type inference failed for: r1v23 */
        /* JADX WARN: Type inference failed for: r1v24 */
        /* JADX WARN: Type inference failed for: r1v9, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2 */
        /* JADX WARN: Type inference failed for: r2v3, types: [int] */
        /* JADX WARN: Type inference failed for: r2v4 */
        public int hashCode() {
            int r0 = ((Long.hashCode(this.date) * 31) + this.number.hashCode()) * 31;
            CharSequence r1 = this.summaryText;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (((r0 + r3) * 31) + this.promptText.hashCode()) * 31;
            CharSequence r5 = this.failureText;
            if (r5 == null) goto L10;
            r2 = r5.hashCode();
        L10:
            int r6 = (r4 + r2) * 31;
            boolean r7 = this.summaryEnabled;
            ?? r8 = 1;
            ?? r9 = r7;
            if (r7 == false) goto L13;
            r9 = 1;
        L13:
            int r10 = (r6 + r9) * 31;
            boolean r11 = this.isWorking;
            ?? r12 = r11;
            if (r11 == false) goto L16;
            r12 = 1;
        L16:
            int r13 = (r10 + r12) * 31;
            boolean r14 = this.hasSummary;
            ?? r15 = r14;
            if (r14 == false) goto L19;
            r15 = 1;
        L19:
            int r16 = (r13 + r15) * 31;
            boolean r17 = this.hasFailure;
            ?? r18 = r17;
            if (r17 == false) goto L22;
            r18 = 1;
        L22:
            int r19 = (r16 + r18) * 31;
            boolean r20 = this.hasTempFailure;
            if (r20 == true) goto L27;
            r8 = r20;
        L27:
            return r19 + r8;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "BindData(date=" + this.date + ", number=" + this.number + ", summaryText=" + this.summaryText + ", promptText=" + this.promptText + ", failureText=" + this.failureText + ", summaryEnabled=" + this.summaryEnabled + ", isWorking=" + this.isWorking + ", hasSummary=" + this.hasSummary + ", hasFailure=" + this.hasFailure + ", hasTempFailure=" + this.hasTempFailure + ')';
        }

        public BindData(long r2, String r4, CharSequence r5, CharSequence r6, CharSequence r7, boolean r8, boolean r9, boolean r10, boolean r11, boolean r12) {
            Intrinsics.checkNotNullParameter(r4, "number");
            Intrinsics.checkNotNullParameter(r6, "promptText");
            this.date = r2;
            this.number = r4;
            this.summaryText = r5;
            this.promptText = r6;
            this.failureText = r7;
            this.summaryEnabled = r8;
            this.isWorking = r9;
            this.hasSummary = r10;
            this.hasFailure = r11;
            this.hasTempFailure = r12;
        }

        public final long getDate() {
            return this.date;
        }

        public final String getNumber() {
            return this.number;
        }

        public final CharSequence getSummaryText() {
            return this.summaryText;
        }

        public final CharSequence getPromptText() {
            return this.promptText;
        }

        public final CharSequence getFailureText() {
            return this.failureText;
        }

        public final boolean getSummaryEnabled() {
            return this.summaryEnabled;
        }

        public final boolean isWorking() {
            return this.isWorking;
        }

        public final boolean getHasSummary() {
            return this.hasSummary;
        }

        public final boolean getHasFailure() {
            return this.hasFailure;
        }

        public final boolean getHasTempFailure() {
            return this.hasTempFailure;
        }
    }

    /* JADX INFO: compiled from: CallLogSummaryCardView.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0012H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/utils/views/commonitemview/CallLogSummaryCardView$Companion;", "", "()V", "CARD_APPEAR_START_SCALE", "", "CARD_APPEAR_START_TRANSLATION_Y_DP", "", "CARD_DISAPPEAR_END_SCALE", "CARD_DISAPPEAR_END_TRANSLATION_Y_DP", "CARD_LIST_OFFSET_DP", "CARD_TOP_SPACE_DP", "CARD_VISIBLE_HEIGHT_DP", "FAILURE_COLLAPSE_DELAY_MS", "", "INITIAL_EXPAND_KEY_LIMIT", "SPRING_SPEC_ACCURACY", "consumedInitialExpandKeys", "Ljava/util/LinkedHashSet;", "", "Lkotlin/collections/LinkedHashSet;", "hasConsumedInitialExpandKey", "", "key", "rememberConsumedInitialExpandKey", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public static final /* synthetic */ boolean access$hasConsumedInitialExpandKey(Companion r0, String r1) {
            return r0.hasConsumedInitialExpandKey(r1);
        }

        public static final /* synthetic */ void access$rememberConsumedInitialExpandKey(Companion r0, String r1) {
            r0.rememberConsumedInitialExpandKey(r1);
        }

        private final boolean hasConsumedInitialExpandKey(String r1) {
            return CallLogSummaryCardView.access$getConsumedInitialExpandKeys$cp().contains(r1);
        }

        private final void rememberConsumedInitialExpandKey(String r1) {
            CallLogSummaryCardView.access$getConsumedInitialExpandKeys$cp().remove(r1);
            CallLogSummaryCardView.access$getConsumedInitialExpandKeys$cp().add(r1);
        L4:
            if (CallLogSummaryCardView.access$getConsumedInitialExpandKeys$cp().size() <= 500) goto L9;
            Iterator r0 = CallLogSummaryCardView.access$getConsumedInitialExpandKeys$cp().iterator();
            Intrinsics.checkNotNullExpressionValue(r0, "consumedInitialExpandKeys.iterator()");
            if (r0.hasNext() == false) goto L12;
            r0.next();
            r0.remove();
            goto L4
        L12:
            return;
        }
    }

    /* JADX INFO: compiled from: CallLogSummaryCardView.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/obric/utils/views/commonitemview/CallLogSummaryCardView$ItemKey;", "", "date", "", "number", "", "(JLjava/lang/String;)V", "getDate", "()J", "getNumber", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class ItemKey {
        private final long date;
        private final String number;

        public static /* synthetic */ ItemKey copy$default(ItemKey r0, long r1, String r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.date;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r3 = r0.number;
        L9:
            return r0.copy(r1, r3);
        }

        public final long component1() {
            return this.date;
        }

        public final String component2() {
            return this.number;
        }

        public final ItemKey copy(long r1, String r3) {
            Intrinsics.checkNotNullParameter(r3, "number");
            return new ItemKey(r1, r3);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof ItemKey) == true) goto L8;
            return false;
        L8:
            ItemKey r9 = (ItemKey) r8;
            if (this.date == r9.date) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.number, r9.number) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Long.hashCode(this.date) * 31) + this.number.hashCode();
        }

        public String toString() {
            return "ItemKey(date=" + this.date + ", number=" + this.number + ')';
        }

        public ItemKey(long r2, String r4) {
            Intrinsics.checkNotNullParameter(r4, "number");
            this.date = r2;
            this.number = r4;
        }

        public final long getDate() {
            return this.date;
        }

        public final String getNumber() {
            return this.number;
        }
    }

    /* JADX INFO: compiled from: CallLogSummaryCardView.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001BO\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0002\u0010\rJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003Je\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u0005HÆ\u0001J\u0013\u0010#\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\u0016\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006)"}, d2 = {"Lcom/obric/utils/views/commonitemview/CallLogSummaryCardView$StateInput;", "", "itemKey", "Lcom/obric/utils/views/commonitemview/CallLogSummaryCardView$ItemKey;", "summaryEnabled", "", "isWorking", "hasSummary", "hasFailure", "requestFailureCollapse", "isCardCurrentlyVisible", "hasConsumedInitialExpand", "hasConsumedFailureCollapse", "(Lcom/obric/utils/views/commonitemview/CallLogSummaryCardView$ItemKey;ZZZZZZZZ)V", "getHasConsumedFailureCollapse", "()Z", "getHasConsumedInitialExpand", "getHasFailure", "getHasSummary", "getItemKey", "()Lcom/obric/utils/views/commonitemview/CallLogSummaryCardView$ItemKey;", "getRequestFailureCollapse", "shouldShowCard", "getShouldShowCard", "getSummaryEnabled", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class StateInput {
        private final boolean hasConsumedFailureCollapse;
        private final boolean hasConsumedInitialExpand;
        private final boolean hasFailure;
        private final boolean hasSummary;
        private final boolean isCardCurrentlyVisible;
        private final boolean isWorking;
        private final ItemKey itemKey;
        private final boolean requestFailureCollapse;
        private final boolean summaryEnabled;

        public static /* synthetic */ StateInput copy$default(StateInput r10, ItemKey r11, boolean r12, boolean r13, boolean r14, boolean r15, boolean r16, boolean r17, boolean r18, boolean r19, int r20, Object r21) {
            if ((r20 & 1) == 0) goto L5;
            ItemKey r2 = r10.itemKey;
        L7:
            if ((r20 & 2) == 0) goto L9;
            boolean r3 = r10.summaryEnabled;
        L11:
            if ((r20 & 4) == 0) goto L13;
            boolean r4 = r10.isWorking;
        L15:
            if ((r20 & 8) == 0) goto L17;
            boolean r5 = r10.hasSummary;
        L19:
            if ((r20 & 16) == 0) goto L21;
            boolean r6 = r10.hasFailure;
        L23:
            if ((r20 & 32) == 0) goto L25;
            boolean r7 = r10.requestFailureCollapse;
        L27:
            if ((r20 & 64) == 0) goto L29;
            boolean r8 = r10.isCardCurrentlyVisible;
        L31:
            if ((r20 & 128) == 0) goto L33;
            boolean r9 = r10.hasConsumedInitialExpand;
        L35:
            if ((r20 & 256) == 0) goto L37;
            boolean r1 = r10.hasConsumedFailureCollapse;
        L39:
            return r10.copy(r2, r3, r4, r5, r6, r7, r8, r9, r1);
        L37:
            r1 = r19;
            goto L39
        L33:
            r9 = r18;
            goto L35
        L29:
            r8 = r17;
            goto L31
        L25:
            r7 = r16;
            goto L27
        L21:
            r6 = r15;
            goto L23
        L17:
            r5 = r14;
            goto L19
        L13:
            r4 = r13;
            goto L15
        L9:
            r3 = r12;
            goto L11
        L5:
            r2 = r11;
            goto L7
        }

        public final ItemKey component1() {
            return this.itemKey;
        }

        public final boolean component2() {
            return this.summaryEnabled;
        }

        public final boolean component3() {
            return this.isWorking;
        }

        public final boolean component4() {
            return this.hasSummary;
        }

        public final boolean component5() {
            return this.hasFailure;
        }

        public final boolean component6() {
            return this.requestFailureCollapse;
        }

        public final boolean component7() {
            return this.isCardCurrentlyVisible;
        }

        public final boolean component8() {
            return this.hasConsumedInitialExpand;
        }

        public final boolean component9() {
            return this.hasConsumedFailureCollapse;
        }

        public final StateInput copy(ItemKey r12, boolean r13, boolean r14, boolean r15, boolean r16, boolean r17, boolean r18, boolean r19, boolean r20) {
            return new StateInput(r12, r13, r14, r15, r16, r17, r18, r19, r20);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof StateInput) == true) goto L8;
            return false;
        L8:
            StateInput r6 = (StateInput) r5;
            if (Intrinsics.areEqual(this.itemKey, r6.itemKey) == true) goto L12;
            return false;
        L12:
            if (this.summaryEnabled == r6.summaryEnabled) goto L15;
            return false;
        L15:
            if (this.isWorking == r6.isWorking) goto L18;
            return false;
        L18:
            if (this.hasSummary == r6.hasSummary) goto L21;
            return false;
        L21:
            if (this.hasFailure == r6.hasFailure) goto L24;
            return false;
        L24:
            if (this.requestFailureCollapse == r6.requestFailureCollapse) goto L27;
            return false;
        L27:
            if (this.isCardCurrentlyVisible == r6.isCardCurrentlyVisible) goto L30;
            return false;
        L30:
            if (this.hasConsumedInitialExpand == r6.hasConsumedInitialExpand) goto L33;
            return false;
        L33:
            if (this.hasConsumedFailureCollapse == r6.hasConsumedFailureCollapse) goto L35;
            return false;
        L35:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10, types: [int] */
        /* JADX WARN: Type inference failed for: r0v12, types: [int] */
        /* JADX WARN: Type inference failed for: r0v14, types: [int] */
        /* JADX WARN: Type inference failed for: r0v16, types: [int] */
        /* JADX WARN: Type inference failed for: r0v18, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v11, types: [int] */
        /* JADX WARN: Type inference failed for: r1v13, types: [int] */
        /* JADX WARN: Type inference failed for: r1v14 */
        /* JADX WARN: Type inference failed for: r1v15 */
        /* JADX WARN: Type inference failed for: r1v16 */
        /* JADX WARN: Type inference failed for: r1v17 */
        /* JADX WARN: Type inference failed for: r1v18 */
        /* JADX WARN: Type inference failed for: r1v19 */
        /* JADX WARN: Type inference failed for: r1v20 */
        /* JADX WARN: Type inference failed for: r1v21 */
        /* JADX WARN: Type inference failed for: r1v22 */
        /* JADX WARN: Type inference failed for: r1v23 */
        /* JADX WARN: Type inference failed for: r1v24 */
        /* JADX WARN: Type inference failed for: r1v25 */
        /* JADX WARN: Type inference failed for: r1v26 */
        /* JADX WARN: Type inference failed for: r1v27 */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v7, types: [int] */
        /* JADX WARN: Type inference failed for: r1v9, types: [int] */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2 */
        public int hashCode() {
            ItemKey r0 = this.itemKey;
            if (r0 != null) goto L5;
            int r1 = 0;
        L6:
            int r2 = r1 * 31;
            boolean r3 = this.summaryEnabled;
            ?? r4 = 1;
            ?? r5 = r3;
            if (r3 == false) goto L9;
            r5 = 1;
        L9:
            int r6 = (r2 + r5) * 31;
            boolean r7 = this.isWorking;
            ?? r8 = r7;
            if (r7 == false) goto L12;
            r8 = 1;
        L12:
            int r9 = (r6 + r8) * 31;
            boolean r10 = this.hasSummary;
            ?? r11 = r10;
            if (r10 == false) goto L15;
            r11 = 1;
        L15:
            int r12 = (r9 + r11) * 31;
            boolean r13 = this.hasFailure;
            ?? r14 = r13;
            if (r13 == false) goto L18;
            r14 = 1;
        L18:
            int r15 = (r12 + r14) * 31;
            boolean r16 = this.requestFailureCollapse;
            ?? r17 = r16;
            if (r16 == false) goto L21;
            r17 = 1;
        L21:
            int r18 = (r15 + r17) * 31;
            boolean r19 = this.isCardCurrentlyVisible;
            ?? r20 = r19;
            if (r19 == false) goto L24;
            r20 = 1;
        L24:
            int r21 = (r18 + r20) * 31;
            boolean r22 = this.hasConsumedInitialExpand;
            ?? r23 = r22;
            if (r22 == false) goto L27;
            r23 = 1;
        L27:
            int r24 = (r21 + r23) * 31;
            boolean r25 = this.hasConsumedFailureCollapse;
            if (r25 == true) goto L32;
            r4 = r25;
        L32:
            return r24 + r4;
        L5:
            r1 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "StateInput(itemKey=" + this.itemKey + ", summaryEnabled=" + this.summaryEnabled + ", isWorking=" + this.isWorking + ", hasSummary=" + this.hasSummary + ", hasFailure=" + this.hasFailure + ", requestFailureCollapse=" + this.requestFailureCollapse + ", isCardCurrentlyVisible=" + this.isCardCurrentlyVisible + ", hasConsumedInitialExpand=" + this.hasConsumedInitialExpand + ", hasConsumedFailureCollapse=" + this.hasConsumedFailureCollapse + ')';
        }

        public StateInput(ItemKey r1, boolean r2, boolean r3, boolean r4, boolean r5, boolean r6, boolean r7, boolean r8, boolean r9) {
            this.itemKey = r1;
            this.summaryEnabled = r2;
            this.isWorking = r3;
            this.hasSummary = r4;
            this.hasFailure = r5;
            this.requestFailureCollapse = r6;
            this.isCardCurrentlyVisible = r7;
            this.hasConsumedInitialExpand = r8;
            this.hasConsumedFailureCollapse = r9;
        }

        public final ItemKey getItemKey() {
            return this.itemKey;
        }

        public final boolean getSummaryEnabled() {
            return this.summaryEnabled;
        }

        public final boolean isWorking() {
            return this.isWorking;
        }

        public final boolean getHasSummary() {
            return this.hasSummary;
        }

        public final boolean getHasFailure() {
            return this.hasFailure;
        }

        public final boolean getRequestFailureCollapse() {
            return this.requestFailureCollapse;
        }

        public final boolean isCardCurrentlyVisible() {
            return this.isCardCurrentlyVisible;
        }

        public final boolean getHasConsumedInitialExpand() {
            return this.hasConsumedInitialExpand;
        }

        public final boolean getHasConsumedFailureCollapse() {
            return this.hasConsumedFailureCollapse;
        }

        public final boolean getShouldShowCard() {
            if (this.summaryEnabled == false) goto L5;
        L8:
            return true;
        L5:
            if (this.isWorking == true) goto L8;
            return false;
        }
    }

    /* JADX INFO: compiled from: CallLogSummaryCardView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/utils/views/commonitemview/CallLogSummaryCardView$TextRenderMode;", "", "(Ljava/lang/String;I)V", "PROMPT_PENDING", "CONTENT_PENDING", "CONTENT_SUCCESS", "PROMPT_FAILURE", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final enum TextRenderMode extends Enum<TextRenderMode> {
        private static final /* synthetic */ TextRenderMode[] $VALUES = null;
        public static final TextRenderMode CONTENT_PENDING = null;
        public static final TextRenderMode CONTENT_SUCCESS = null;
        public static final TextRenderMode PROMPT_FAILURE = null;
        public static final TextRenderMode PROMPT_PENDING = null;

        private static final /* synthetic */ TextRenderMode[] $values() {
            return new TextRenderMode[]{PROMPT_PENDING, CONTENT_PENDING, CONTENT_SUCCESS, PROMPT_FAILURE};
        }

        public static TextRenderMode valueOf(String r1) {
            return (TextRenderMode) Enum.valueOf(TextRenderMode.class, r1);
        }

        public static TextRenderMode[] values() {
            return (TextRenderMode[]) $VALUES.clone();
        }

        private TextRenderMode(String r1, int r2) {
            super(r1, r2);
        }

        static {
            PROMPT_PENDING = new TextRenderMode("PROMPT_PENDING", 0);
            CONTENT_PENDING = new TextRenderMode("CONTENT_PENDING", 1);
            CONTENT_SUCCESS = new TextRenderMode("CONTENT_SUCCESS", 2);
            PROMPT_FAILURE = new TextRenderMode("PROMPT_FAILURE", 3);
            $VALUES = $values();
        }
    }

    /* JADX INFO: compiled from: CallLogSummaryCardView.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/obric/utils/views/commonitemview/CallLogSummaryCardView$TextRenderSnapshot;", "", "itemKey", "Lcom/obric/utils/views/commonitemview/CallLogSummaryCardView$ItemKey;", "mode", "Lcom/obric/utils/views/commonitemview/CallLogSummaryCardView$TextRenderMode;", "text", "", "(Lcom/obric/utils/views/commonitemview/CallLogSummaryCardView$ItemKey;Lcom/obric/utils/views/commonitemview/CallLogSummaryCardView$TextRenderMode;Ljava/lang/String;)V", "getItemKey", "()Lcom/obric/utils/views/commonitemview/CallLogSummaryCardView$ItemKey;", "getMode", "()Lcom/obric/utils/views/commonitemview/CallLogSummaryCardView$TextRenderMode;", "getText", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class TextRenderSnapshot {
        private final ItemKey itemKey;
        private final TextRenderMode mode;
        private final String text;

        public static /* synthetic */ TextRenderSnapshot copy$default(TextRenderSnapshot r0, ItemKey r1, TextRenderMode r2, String r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.itemKey;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.mode;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.text;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final ItemKey component1() {
            return this.itemKey;
        }

        public final TextRenderMode component2() {
            return this.mode;
        }

        public final String component3() {
            return this.text;
        }

        public final TextRenderSnapshot copy(ItemKey r1, TextRenderMode r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "mode");
            Intrinsics.checkNotNullParameter(r3, "text");
            return new TextRenderSnapshot(r1, r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof TextRenderSnapshot) == true) goto L8;
            return false;
        L8:
            TextRenderSnapshot r6 = (TextRenderSnapshot) r5;
            if (Intrinsics.areEqual(this.itemKey, r6.itemKey) == true) goto L12;
            return false;
        L12:
            if (this.mode == r6.mode) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.text, r6.text) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            ItemKey r0 = this.itemKey;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (((r1 * 31) + this.mode.hashCode()) * 31) + this.text.hashCode();
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public String toString() {
            return "TextRenderSnapshot(itemKey=" + this.itemKey + ", mode=" + this.mode + ", text=" + this.text + ')';
        }

        public TextRenderSnapshot(ItemKey r2, TextRenderMode r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "mode");
            Intrinsics.checkNotNullParameter(r4, "text");
            this.itemKey = r2;
            this.mode = r3;
            this.text = r4;
        }

        public final ItemKey getItemKey() {
            return this.itemKey;
        }

        public final TextRenderMode getMode() {
            return this.mode;
        }

        public final String getText() {
            return this.text;
        }
    }

    /* JADX INFO: compiled from: CallLogSummaryCardView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/utils/views/commonitemview/CallLogSummaryCardView$UiState;", "", "(Ljava/lang/String;I)V", "FIRST_EXPAND", "SUMMARY_PENDING", "SUMMARY_SUCCESS", "SUMMARY_FAILURE", "FAILURE_COLLAPSE", "HIDDEN", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final enum UiState extends Enum<UiState> {
        private static final /* synthetic */ UiState[] $VALUES = null;
        public static final UiState FAILURE_COLLAPSE = null;
        public static final UiState FIRST_EXPAND = null;
        public static final UiState HIDDEN = null;
        public static final UiState SUMMARY_FAILURE = null;
        public static final UiState SUMMARY_PENDING = null;
        public static final UiState SUMMARY_SUCCESS = null;

        private static final /* synthetic */ UiState[] $values() {
            return new UiState[]{FIRST_EXPAND, SUMMARY_PENDING, SUMMARY_SUCCESS, SUMMARY_FAILURE, FAILURE_COLLAPSE, HIDDEN};
        }

        public static UiState valueOf(String r1) {
            return (UiState) Enum.valueOf(UiState.class, r1);
        }

        public static UiState[] values() {
            return (UiState[]) $VALUES.clone();
        }

        private UiState(String r1, int r2) {
            super(r1, r2);
        }

        static {
            FIRST_EXPAND = new UiState("FIRST_EXPAND", 0);
            SUMMARY_PENDING = new UiState("SUMMARY_PENDING", 1);
            SUMMARY_SUCCESS = new UiState("SUMMARY_SUCCESS", 2);
            SUMMARY_FAILURE = new UiState("SUMMARY_FAILURE", 3);
            FAILURE_COLLAPSE = new UiState("FAILURE_COLLAPSE", 4);
            HIDDEN = new UiState("HIDDEN", 5);
            $VALUES = $values();
        }
    }

    /* JADX INFO: compiled from: CallLogSummaryCardView.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[UiState.values().length];
            r0[UiState.FIRST_EXPAND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[UiState.SUMMARY_SUCCESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[UiState.SUMMARY_PENDING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[UiState.SUMMARY_FAILURE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[UiState.FAILURE_COLLAPSE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[UiState.HIDDEN.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$m8mP2_sv-5GJaiNFHdhoQQO-vXw, reason: not valid java name */
    public static /* synthetic */ void m784$r8$lambda$m8mP2_sv5GJaiNFHdhoQQOvXw(CallLogSummaryCardView r0, ItemKey r1) {
        scheduleFailureCollapse$lambda$7(r0, r1);
    }

    public CallLogSummaryCardView(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public CallLogSummaryCardView(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ CallLogSummaryCardView(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public static final /* synthetic */ LinkedHashSet access$getConsumedInitialExpandKeys$cp() {
        return consumedInitialExpandKeys;
    }

    public static final /* synthetic */ ItemKey access$getCurrentItemKey$p(CallLogSummaryCardView r0) {
        return r0.currentItemKey;
    }

    public static final /* synthetic */ String access$logKey(CallLogSummaryCardView r0, ItemKey r1) {
        return r0.logKey(r1);
    }

    public static final /* synthetic */ void access$resetFailureCollapseVisuals(CallLogSummaryCardView r0) {
        r0.resetFailureCollapseVisuals();
    }

    public static final /* synthetic */ void access$resetInitialExpandVisuals(CallLogSummaryCardView r0) {
        r0.resetInitialExpandVisuals();
    }

    public static final /* synthetic */ void access$setCollapsingItemKey$p(CallLogSummaryCardView r0, ItemKey r1) {
        r0.collapsingItemKey = r1;
    }

    public static final /* synthetic */ void access$setPendingFailureCollapseItemKey$p(CallLogSummaryCardView r0, ItemKey r1) {
        r0.pendingFailureCollapseItemKey = r1;
    }

    public CallLogSummaryCardView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.initialExpandAnimators = new ArrayList();
        this.failureCollapseAnimators = new ArrayList();
        LayoutInflater.from(r3).inflate(R.layout.call_log_summary_card_view, this, true);
        setClipChildren(false);
        setClipToPadding(false);
        View r6 = findViewById(R.id.call_log_summary_card);
        Intrinsics.checkNotNullExpressionValue(r6, "findViewById(R.id.call_log_summary_card)");
        this.cardView = r6;
        View r7 = findViewById(R.id.call_log_summary_left_icon);
        Intrinsics.checkNotNullExpressionValue(r7, "findViewById(R.id.call_log_summary_left_icon)");
        this.leftIconView = (ImageView) r7;
        View r8 = findViewById(R.id.call_log_summary_text);
        Intrinsics.checkNotNullExpressionValue(r8, "findViewById(R.id.call_log_summary_text)");
        ODimPointGenerateEffectView r9 = (ODimPointGenerateEffectView) r8;
        this.textEffectView = r9;
        View r10 = findViewById(R.id.call_log_summary_right_icon);
        Intrinsics.checkNotNullExpressionValue(r10, "findViewById(R.id.call_log_summary_right_icon)");
        ImageView r11 = (ImageView) r10;
        this.rightIconView = r11;
        bindLeftIcon();
        r11.setImageDrawable(AppCompatResources.getDrawable(r3, R.drawable.ic_call_summary_arrow));
        r9.setText("");
    }

    static {
        Companion = new Companion(null);
        consumedInitialExpandKeys = new LinkedHashSet();
    }

    public final Function0<Unit> getOnConsumeTempFailure() {
        return this.onConsumeTempFailure;
    }

    public final void setOnConsumeTempFailure(Function0<Unit> r1) {
        this.onConsumeTempFailure = r1;
    }

    public final void bind(BindData r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
        BindData r0 = this.currentData;
        this.currentData = r10;
        StateInput r1 = buildStateInput(r10);
        resetFailureCollapseConsumptionIfNewWorking(r0, r10);
        UiState r2 = resolveUiState(r1);
        ItemKey r3 = r1.getItemKey();
        boolean r8 = shouldShowContentPending(r10.isWorking(), r10.getHasSummary(), r10.getSummaryText());
        boolean r4 = shouldUseStaticText(r10.isWorking(), r10.getHasSummary(), r3, r10.getPromptText(), r10.getSummaryText());
        if (ContactsUtils.DEBUG == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(CallSummaryGenerateManagerKt.SUMMARY_LOG_TAG, "summary card bind " + logKey(r3) + " state=" + r2 + " enabled=" + r10.getSummaryEnabled() + " working=" + r10.isWorking() + " hasSummary=" + r10.getHasSummary() + " hasFailure=" + r10.getHasFailure() + " tempFail=" + r10.getHasTempFailure() + " contentPending=" + r8 + " staticText=" + r4 + ' ' + logText(r10.getSummaryText()));
    L6:
        switch(WhenMappings.$EnumSwitchMapping$0[r2.ordinal()]) {
            case 1: goto L26;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L68;
        };
    L8:
        hideCard();
        return;
    L9:
        consumeFailureCollapseOnce(r2);
        playFailureCollapseAnimation(r3);
        return;
    L10:
        CharSequence r5 = r10.getFailureText();
        if (r5 != null) goto L13;
    L14:
        renderPromptFailure$default(this, r3, r4, false, r10.getHasTempFailure(), 4, null);
        return;
    L13:
        CharSequence r6 = r5;
        goto L14
    L15:
        renderPromptPending(r3, r10.getPromptText());
        return;
    L16:
        if (r8 == false) goto L21;
        CharSequence r11 = r10.getSummaryText();
        if (r11 != null) goto L20;
    L20:
        renderContentPending(r3, r11);
        return;
    L21:
        CharSequence r12 = r10.getSummaryText();
        if (r12 != null) goto L24;
    L24:
        renderContentText(r3, r12, r4);
        return;
    L68:
        return;
    L26:
        if (r10.isWorking() == true) goto L28;
    L34:
        boolean r7 = false;
    L35:
        if (r7 == false) goto L37;
        Integer r9 = Integer.valueOf(prepareInitialExpandAnimation());
    L39:
        if (r10.getHasSummary() == false) goto L45;
        CharSequence r13 = r10.getSummaryText();
        if (r13 != null) goto L43;
    L43:
        renderContentText(r3, r13, true);
        return;
    L45:
        if (r10.isWorking() == false) goto L50;
        renderPromptPending(r3, r10.getPromptText());
        if (r9 == null) goto L65;
        playInitialExpandAnimation(r9.intValue());
        return;
    L65:
        return;
    L50:
        if (r10.getHasFailure() == false) goto L56;
        CharSequence r14 = r10.getFailureText();
        if (r14 != null) goto L54;
    L55:
        renderPromptFailure$default(this, r3, r4, true, false, 8, null);
        return;
    L54:
        CharSequence r15 = r14;
        goto L55
    L56:
        hideCard();
        return;
    L37:
        r9 = null;
        goto L39
    L28:
        if (r10.getHasSummary() == true) goto L34;
        if (r10.getHasFailure() == true) goto L34;
        if (consumeInitialExpandOnce(r2) == false) goto L34;
        r7 = true;
        goto L35
    }

    public final void hideCard() {
        cancelInitialExpandAnimation();
        cancelFailureCollapseRequest();
        cancelFailureCollapseAnimation();
        Function0<Unit> r0 = this.onConsumeTempFailure;
        if (r0 == null) goto L5;
        r0.invoke();
    L5:
        this.cardView.setVisibility(8);
        setVisibility(8);
        stopLeftIconAnimation();
        this.textEffectView.setText("");
        this.textRenderSnapshot = null;
    }

    public final void setOnCardClickListener(View.OnClickListener r1) {
        this.cardView.setOnClickListener(r1);
    }

    public final boolean isCardVisible() {
        if (getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L14;
        if (this.cardView.getVisibility() != 0) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L14;
        return true;
    L10:
        r3 = false;
    L14:
        return false;
    L5:
        r0 = false;
        goto L6
    }

    public final boolean canKeepTempFailure(long r2, String r4) {
        Intrinsics.checkNotNullParameter(r4, "number");
        ItemKey r0 = new ItemKey(r2, r4);
        if (isCardVisible() == false) goto L5;
    L12:
        return true;
    L5:
        if (Intrinsics.areEqual(this.scheduledFailureCollapseItemKey, r0) == true) goto L12;
        if (Intrinsics.areEqual(this.pendingFailureCollapseItemKey, r0) == true) goto L12;
        if (Intrinsics.areEqual(this.collapsingItemKey, r0) == true) goto L12;
        return false;
    }

    private final Drawable createLeftIconDrawable() {
        Drawable r1 = ImageDecoder.decodeDrawable(ImageDecoder.createSource(getResources(), R.drawable.calllog_summary_star_processing));
        Intrinsics.checkNotNullExpressionValue(r1, "decodeDrawable(\n        …tar_processing)\n        )");
        return r1;
    }

    private final void bindLeftIcon() {
        Drawable r0 = createLeftIconDrawable();
        this.leftIconDrawable = r0;
        this.leftIconView.setImageDrawable(r0);
    }

    private final void startLeftIconAnimation() {
        Drawable r0 = this.leftIconDrawable;
        if ((r0 instanceof AnimatedImageDrawable) == false) goto L5;
        AnimatedImageDrawable r1 = (AnimatedImageDrawable) r0;
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        r1.setRepeatCount(-1);
        if (r1.isRunning() == true) goto L11;
        r1.start();
    L11:
        this.isLeftIconAnimating = true;
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final void stopLeftIconAnimation() {
        if (this.isLeftIconAnimating == true) goto L5;
        return;
    L5:
        Drawable r0 = this.leftIconDrawable;
        if ((r0 instanceof AnimatedImageDrawable) == false) goto L8;
        AnimatedImageDrawable r1 = (AnimatedImageDrawable) r0;
    L9:
        if (r1 != null) goto L11;
        return;
    L11:
        r1.stop();
        this.isLeftIconAnimating = false;
        bindLeftIcon();
        return;
    L8:
        r1 = null;
        goto L9
    }

    private final String consumptionKey(ItemKey r3) {
        if (r3 != null) goto L6;
        return null;
    L6:
        return r3.getDate() + ':' + r3.getNumber();
    }

    private final void updateConsumptionScope(ItemKey r3) {
        if (Intrinsics.areEqual(this.currentItemKey, r3) == false) goto L5;
        return;
    L5:
        cancelInitialExpandAnimation();
        cancelFailureCollapseRequest();
        cancelFailureCollapseAnimation();
        this.currentItemKey = r3;
        String r4 = consumptionKey(r3);
        if (r4 == null) goto L10;
        boolean r1 = true;
        if (Companion.access$hasConsumedInitialExpandKey(Companion, r4) != true) goto L10;
    L11:
        this.hasConsumedInitialExpand = r1;
        this.hasConsumedFailureCollapse = false;
        this.textRenderSnapshot = null;
        return;
    L10:
        r1 = false;
        goto L11
    }

    private final String normalizeText(CharSequence r1) {
        if (r1 == null) goto L4;
        String r0 = r1.toString();
    L5:
        if (r0 != null) goto L8;
        return "";
    L8:
        return r0;
    L4:
        r0 = null;
        goto L5
    }

    private final String logKey(ItemKey r3) {
        if (r3 == null) goto L5;
        String r2 = "date=" + r3.getDate();
        if (r2 == null) goto L5;
        return r2;
    L5:
        return "key=null";
    }

    private final String logText(CharSequence r3) {
        StringBuilder r2 = new StringBuilder("textEmpty=");
        int r0 = 0;
        if (r3 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        StringBuilder r4 = r2.append(r1).append(" textLen=");
        if (r3 == null) goto L13;
        r0 = r3.length();
    L13:
        return r4.append(r0).toString();
    L5:
        if (r3.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    private final void cancelInitialExpandAnimation() {
        if (this.initialExpandAnimators.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator r0 = CollectionsKt.toList(this.initialExpandAnimators).iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        AnimationManager.cancelAnimation$default((AnimationManager) r0.next(), false, 1, null);
        goto L7
    L9:
        this.initialExpandAnimators.clear();
        resetInitialExpandVisuals();
    }

    private final void cancelFailureCollapseRequest() {
        Runnable r0 = this.failureCollapseRunnable;
        if (r0 == null) goto L5;
    L9:
        if (r0 == null) goto L11;
        removeCallbacks(r0);
    L11:
        this.failureCollapseRunnable = null;
        this.scheduledFailureCollapseItemKey = null;
        this.pendingFailureCollapseItemKey = null;
        return;
    L5:
        if (this.scheduledFailureCollapseItemKey != null) goto L9;
        if (this.pendingFailureCollapseItemKey != null) goto L9;
    }

    private final void cancelFailureCollapseAnimation() {
        if (this.failureCollapseAnimators.isEmpty() == false) goto L6;
        this.collapsingItemKey = null;
        return;
    L6:
        Iterator r0 = CollectionsKt.toList(this.failureCollapseAnimators).iterator();
    L8:
        if (r0.hasNext() == false) goto L10;
        AnimationManager.cancelAnimation$default((AnimationManager) r0.next(), false, 1, null);
        goto L8
    L10:
        this.failureCollapseAnimators.clear();
        this.collapsingItemKey = null;
        resetFailureCollapseVisuals();
    }

    private final void resetFailureCollapseVisuals() {
        restoreNaturalLayout();
        setAlpha(1.0f);
        this.cardView.setAlpha(1.0f);
        this.cardView.setScaleX(1.0f);
        this.cardView.setScaleY(1.0f);
        this.cardView.setTranslationY(0.0f);
    }

    private final void scheduleFailureCollapse(final ItemKey r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (this.failureCollapseRunnable != null) goto L7;
    L9:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(CallSummaryGenerateManagerKt.SUMMARY_LOG_TAG, "summary card scheduleCollapse " + logKey(r4) + " delay=3000");
        cancelFailureCollapseRequest();
        Runnable r0 = new CallLogSummaryCardView$$ExternalSyntheticLambda0(this, r4);
        this.scheduledFailureCollapseItemKey = r4;
        this.failureCollapseRunnable = r0;
        postDelayed(r0, 3000);
        return;
    L7:
        if (Intrinsics.areEqual(this.scheduledFailureCollapseItemKey, r4) == false) goto L9;
    }

    private static final void scheduleFailureCollapse$lambda$7(CallLogSummaryCardView r1, ItemKey r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.failureCollapseRunnable = null;
        r1.scheduledFailureCollapseItemKey = null;
        r1.pendingFailureCollapseItemKey = r2;
        r1.refreshForPendingFailureCollapse(r2);
    }

    private final void refreshForPendingFailureCollapse(ItemKey r3) {
        if (r3 != null) goto L5;
    L19:
        this.pendingFailureCollapseItemKey = null;
        return;
    L5:
        if (Intrinsics.areEqual(this.currentItemKey, r3) == false) goto L19;
        BindData r4 = this.currentData;
        if (r4 != null) goto L10;
    L17:
        this.pendingFailureCollapseItemKey = null;
        return;
    L10:
        if (r4.getNumber().length() != 0) goto L12;
        boolean r1 = true;
    L13:
        if (r1 == true) goto L17;
        bind(r4);
        return;
    L12:
        r1 = false;
        goto L13
    }

    private final void playFailureCollapseAnimation(final ItemKey r28) {
        if (r28 != null) goto L7;
        hideCard();
        return;
    L7:
        if (Intrinsics.areEqual(this.collapsingItemKey, r28) == true) goto L9;
    L11:
        cancelFailureCollapseAnimation();
        cancelFailureCollapseRequest();
        if (getHeight() <= 0) goto L15;
        int r2 = getHeight();
    L25:
        if (r2 <= 0) goto L39;
        CallLogSummaryCardView r5 = this;
        if (r5.getVisibility() != 0) goto L29;
        boolean r6 = true;
    L30:
        if (r6 == false) goto L39;
        if (this.cardView.getVisibility() != 0) goto L34;
        boolean r7 = true;
    L35:
        if (r7 == false) goto L39;
        this.collapsingItemKey = r28;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(CallSummaryGenerateManagerKt.SUMMARY_LOG_TAG, "summary card collapseStart " + logKey(r28) + " height=" + r2);
        int r3 = Math.max(r2, MathKt.roundToInt(TypedValue.applyDimension(1, 38, Resources.getSystem().getDisplayMetrics())));
        applyAnimatedLayoutSpace(r3);
        this.cardView.setAlpha(1.0f);
        this.cardView.setScaleX(1.0f);
        this.cardView.setScaleY(1.0f);
        this.cardView.setTranslationY(targetCardTranslationY());
        startAnimators(CollectionsKt.listOf(new PropertyAnimatable.Builder[]{PropertyAnimatable.Builder.ofInt$default(PropertyAnimatableKt.animator$default(r5, 0.0f, 1, null), AnimationProperty.IntProperty.HEIGHT, Integer.valueOf(r3), 0, AnimationSpecKt.springInt(Token.Bounce.OUI_ANIMATION_BOUNCE_SNAPPY_3, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_4, Token.Delay.OUI_ANIMATION_DELAY_SHORT_1), null, 16, null), PropertyAnimatable.Builder.of$default(PropertyAnimatable.Builder.of$default(PropertyAnimatable.Builder.of$default(PropertyAnimatable.Builder.of$default(PropertyAnimatableKt.animator$default(this.cardView, 0.0f, 1, null), AnimationProperty.FloatProperty.SCALE_X, Float.valueOf(1.0f), 0.95f, summaryScaleSpring(Token.Bounce.OUI_ANIMATION_BOUNCE_SNAPPY_3, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_4, Token.Delay.OUI_ANIMATION_DELAY_NONE), null, 16, null), AnimationProperty.FloatProperty.SCALE_Y, Float.valueOf(1.0f), 0.95f, summaryScaleSpring(Token.Bounce.OUI_ANIMATION_BOUNCE_SNAPPY_3, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_4, Token.Delay.OUI_ANIMATION_DELAY_NONE), null, 16, null), AnimationProperty.FloatProperty.TRANSLATION_Y, Float.valueOf(targetCardTranslationY()), disappearEndCardTranslationY(), AnimationSpecKt.spring(Token.Bounce.OUI_ANIMATION_BOUNCE_SNAPPY_3, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_4, Token.Delay.OUI_ANIMATION_DELAY_NONE), null, 16, null), AnimationProperty.FloatProperty.ALPHA, Float.valueOf(1.0f), 0.0f, AnimationSpecKt.tween(Token.Duration.OUI_ANIMATION_DURATION_SHORT_4, Token.Delay.OUI_ANIMATION_DELAY_NONE, Token.Easing.OUI_ANIMATION_EASING_EASE_OUT), null, 16, null)}), this.failureCollapseAnimators, new AnonymousClass1(this, r28));
        return;
    L34:
        r7 = false;
        goto L35
    L29:
        r6 = false;
    L39:
        this.pendingFailureCollapseItemKey = null;
        this.collapsingItemKey = null;
        hideCard();
        return;
    L15:
        if (getMeasuredHeight() <= 0) goto L18;
        r2 = getMeasuredHeight();
        goto L25
    L18:
        if (this.cardView.getHeight() <= 0) goto L21;
        r2 = this.cardView.getHeight();
        goto L25
    L21:
        if (this.cardView.getMeasuredHeight() <= 0) goto L23;
        r2 = this.cardView.getMeasuredHeight();
        goto L25
    L23:
        r2 = MathKt.roundToInt(TypedValue.applyDimension(1, 32, Resources.getSystem().getDisplayMetrics()));
        goto L25
    L9:
        if ((!this.failureCollapseAnimators.isEmpty()) == false) goto L11;
    }

    private final void resetInitialExpandVisuals() {
        restoreNaturalLayout();
        setAlpha(1.0f);
        this.cardView.setAlpha(1.0f);
        this.cardView.setScaleX(1.0f);
        this.cardView.setScaleY(1.0f);
        this.cardView.setTranslationY(0.0f);
    }

    private final int prepareInitialExpandAnimation() {
        cancelInitialExpandAnimation();
        int r0 = getInitialExpandTargetHeight();
        rememberOriginalTopMargin();
        applyAnimatedLayoutSpace(0);
        setVisibility(0);
        this.cardView.setVisibility(0);
        setAlpha(1.0f);
        this.cardView.setAlpha(0.0f);
        this.cardView.setScaleX(0.95f);
        this.cardView.setScaleY(0.95f);
        this.cardView.setTranslationY(appearStartCardTranslationY());
        return r0;
    }

    private final void playInitialExpandAnimation(int r30) {
        CallLogSummaryCardView r1 = this;
        if (r1.getVisibility() != 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L8;
    L18:
        resetInitialExpandVisuals();
        return;
    L8:
        if (this.cardView.getVisibility() != 0) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L18;
        if (r30 > 0) goto L16;
        resetInitialExpandVisuals();
        return;
    L16:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(CallSummaryGenerateManagerKt.SUMMARY_LOG_TAG, "summary card initialExpandStart " + logKey(this.currentItemKey) + " height=" + r30);
        startAnimators(CollectionsKt.listOf(new PropertyAnimatable.Builder[]{PropertyAnimatable.Builder.ofInt$default(PropertyAnimatableKt.animator$default(r1, 0.0f, 1, null), AnimationProperty.IntProperty.HEIGHT, 0, r30, AnimationSpecKt.springInt(Token.Bounce.OUI_ANIMATION_BOUNCE_SNAPPY_4, Token.Duration.OUI_ANIMATION_DURATION_LONG_2, Token.Delay.OUI_ANIMATION_DELAY_NONE), null, 16, null), PropertyAnimatable.Builder.of$default(PropertyAnimatable.Builder.of$default(PropertyAnimatable.Builder.of$default(PropertyAnimatable.Builder.of$default(PropertyAnimatableKt.animator$default(this.cardView, 0.0f, 1, null), AnimationProperty.FloatProperty.SCALE_X, Float.valueOf(0.95f), 1.0f, summaryScaleSpring(Token.Bounce.OUI_ANIMATION_BOUNCE_SNAPPY_4, Token.Duration.OUI_ANIMATION_DURATION_LONG_2, Token.Delay.OUI_ANIMATION_DELAY_SHORT_1), null, 16, null), AnimationProperty.FloatProperty.SCALE_Y, Float.valueOf(0.95f), 1.0f, summaryScaleSpring(Token.Bounce.OUI_ANIMATION_BOUNCE_SNAPPY_4, Token.Duration.OUI_ANIMATION_DURATION_LONG_2, Token.Delay.OUI_ANIMATION_DELAY_SHORT_1), null, 16, null), AnimationProperty.FloatProperty.TRANSLATION_Y, Float.valueOf(appearStartCardTranslationY()), targetCardTranslationY(), AnimationSpecKt.spring(Token.Bounce.OUI_ANIMATION_BOUNCE_SNAPPY_4, Token.Duration.OUI_ANIMATION_DURATION_LONG_2, Token.Delay.OUI_ANIMATION_DELAY_SHORT_1), null, 16, null), AnimationProperty.FloatProperty.ALPHA, Float.valueOf(0.0f), 1.0f, AnimationSpecKt.tween(Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_1, Token.Delay.OUI_ANIMATION_DELAY_SHORT_1, Token.Easing.OUI_ANIMATION_EASING_EASE_IN), null, 16, null)}), this.initialExpandAnimators, new C04461(this));
        return;
    L10:
        r3 = false;
        goto L11
    L5:
        r2 = false;
        goto L6
    }

    private final void startAnimators(final List<PropertyAnimatable.Builder> r11, final List<AnimationManager> r12, final Function1<? super Boolean, Unit> r13) {
        if (r11.isEmpty() == false) goto L6;
        r13.invoke(true);
        return;
    L6:
        final Ref.IntRef r10 = new Ref.IntRef();
        final Ref.BooleanRef r6 = new Ref.BooleanRef();
        r6.element = true;
        Iterator<T> r7 = r11.iterator();
    L8:
        if (r7.hasNext() == false) goto L10;
        r12.add(((PropertyAnimatable.Builder) r7.next()).onEnd(new CallLogSummaryCardView$startAnimators$1$1(r6, r10, r11, r12, r13)).build().start(RunMode.PARALLEL, RepeatMode.NORMAL));
        goto L8
    }

    private final void rememberOriginalTopMargin() {
        if (this.originalTopMargin == null) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r0 = getLayoutParams();
        Integer r2 = null;
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L8;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
    L9:
        if (r1 == null) goto L11;
        r2 = Integer.valueOf(r1.topMargin);
    L11:
        this.originalTopMargin = r2;
        return;
    L8:
        r1 = null;
        goto L9
    }

    private final void applyAnimatedLayoutSpace(int r4) {
        rememberOriginalTopMargin();
        ViewGroup.LayoutParams r0 = getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ((ViewGroup.MarginLayoutParams) r0).topMargin = 0;
    L5:
        r0.height = Math.max(0, r4);
        setLayoutParams(r0);
    }

    private final void restoreNaturalLayout() {
        ViewGroup.LayoutParams r0 = getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L9;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
        Integer r2 = this.originalTopMargin;
        if (r2 == null) goto L7;
        int r3 = r2.intValue();
    L8:
        r1.topMargin = r3;
        goto L9
    L7:
        r3 = r1.topMargin;
    L9:
        r0.height = -2;
        setLayoutParams(r0);
    }

    private final FloatSpringSpec summaryScaleSpring(Token.Bounce r1, Token.Duration r2, Token.Delay r3) {
        FloatSpringSpec r0 = AnimationSpecKt.spring(r1, r2, r3);
        r0.setAccuracy(1.0E-4f);
        return r0;
    }

    private final void ensureCardVisible() {
        setVisibility(0);
        this.cardView.setVisibility(0);
    }

    private final boolean hasSameTextRender(ItemKey r3, TextRenderMode r4, CharSequence r5) {
        String r6 = normalizeText(r5);
        TextRenderSnapshot r2 = this.textRenderSnapshot;
        if (r2 != null) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r2.getItemKey(), r3) == true) goto L8;
        return false;
    L8:
        if (r2.getMode() == r4) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(r2.getText(), r6) == false) goto L15;
        return true;
    L15:
        return false;
    }

    private final boolean hasChangedContentPendingText(ItemKey r3, CharSequence r4) {
        String r5 = normalizeText(r4);
        TextRenderSnapshot r2 = this.textRenderSnapshot;
        if (r2 != null) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r2.getItemKey(), r3) == true) goto L8;
        return false;
    L8:
        if (r2.getMode() == TextRenderMode.CONTENT_PENDING) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(r2.getText(), r5) == true) goto L15;
        return true;
    L15:
        return false;
    }

    private final void rememberTextRender(ItemKey r2, TextRenderMode r3, CharSequence r4) {
        this.textRenderSnapshot = new TextRenderSnapshot(r2, r3, normalizeText(r4));
    }

    private final void renderPromptPending(ItemKey r2, CharSequence r3) {
        cancelFailureCollapseRequest();
        cancelFailureCollapseAnimation();
        Function0<Unit> r0 = this.onConsumeTempFailure;
        if (r0 == null) goto L5;
        r0.invoke();
    L5:
        String r4 = normalizeText(r3);
        if (r4.length() != 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        hideCard();
        return;
    L12:
        ensureCardVisible();
        startLeftIconAnimation();
        if (hasSameTextRender(r2, TextRenderMode.PROMPT_PENDING, r4) == true) goto L16;
        this.textEffectView.showPromptPending(r4);
        rememberTextRender(r2, TextRenderMode.PROMPT_PENDING, r4);
        return;
    L16:
        return;
    L8:
        r1 = false;
        goto L9
    }

    private final void renderContentPending(ItemKey r2, CharSequence r3) {
        cancelFailureCollapseRequest();
        cancelFailureCollapseAnimation();
        Function0<Unit> r0 = this.onConsumeTempFailure;
        if (r0 == null) goto L5;
        r0.invoke();
    L5:
        String r4 = normalizeText(r3);
        if (r4.length() != 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        hideCard();
        return;
    L12:
        ensureCardVisible();
        startLeftIconAnimation();
        if (hasSameTextRender(r2, TextRenderMode.CONTENT_PENDING, r4) == true) goto L16;
        this.textEffectView.showContentPending(r4);
        rememberTextRender(r2, TextRenderMode.CONTENT_PENDING, r4);
        return;
    L16:
        return;
    L8:
        r1 = false;
        goto L9
    }

    static /* synthetic */ void renderContentText$default(CallLogSummaryCardView r0, ItemKey r1, CharSequence r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = false;
    L5:
        r0.renderContentText(r1, r2, r3);
    }

    private final void renderContentText(ItemKey r2, CharSequence r3, boolean r4) {
        cancelInitialExpandAnimation();
        cancelFailureCollapseRequest();
        cancelFailureCollapseAnimation();
        Function0<Unit> r0 = this.onConsumeTempFailure;
        if (r0 == null) goto L5;
        r0.invoke();
    L5:
        String r5 = normalizeText(r3);
        if (r5.length() != 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        hideCard();
        return;
    L12:
        ensureCardVisible();
        stopLeftIconAnimation();
        if (hasSameTextRender(r2, TextRenderMode.CONTENT_SUCCESS, r5) == true) goto L19;
        if (r4 == false) goto L16;
        this.textEffectView.setText(r5);
    L17:
        rememberTextRender(r2, TextRenderMode.CONTENT_SUCCESS, r5);
        return;
    L16:
        this.textEffectView.submitContentText(r5);
        goto L17
    L19:
        return;
    L8:
        r1 = false;
        goto L9
    }

    static /* synthetic */ void renderPromptFailure$default(CallLogSummaryCardView r1, ItemKey r2, CharSequence r3, boolean r4, boolean r5, int r6, Object r7) {
        if ((r6 & 4) == 0) goto L6;
        r4 = false;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = false;
    L8:
        r1.renderPromptFailure(r2, r3, r4, r5);
    }

    private final void renderPromptFailure(ItemKey r2, CharSequence r3, boolean r4, boolean r5) {
        cancelInitialExpandAnimation();
        if (r4 == true) goto L5;
        if (r5 == false) goto L5;
    L6:
        String r6 = normalizeText(r3);
        if (r6.length() != 0) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == false) goto L13;
        hideCard();
        return;
    L13:
        ensureCardVisible();
        stopLeftIconAnimation();
        if (hasSameTextRender(r2, TextRenderMode.PROMPT_FAILURE, r6) == true) goto L21;
        if (r4 == false) goto L17;
        this.textEffectView.setText(r6);
    L20:
        rememberTextRender(r2, TextRenderMode.PROMPT_FAILURE, r6);
        return;
    L17:
        this.textEffectView.showPromptFailure(r6);
        if (r5 == false) goto L20;
        scheduleFailureCollapse(r2);
        goto L20
    L21:
        if (r4 == true) goto L26;
        if (r5 == false) goto L27;
        scheduleFailureCollapse(r2);
        return;
    L27:
        return;
    L26:
        return;
    L9:
        r0 = false;
    L5:
        cancelFailureCollapseRequest();
        cancelFailureCollapseAnimation();
        goto L6
    }

    private final boolean shouldShowContentPending(boolean r1, boolean r2, CharSequence r3) {
        if (r1 == false) goto L15;
        if (r2 == true) goto L6;
        return false;
    L6:
        if (r3 != null) goto L8;
    L11:
        boolean r4 = true;
    L12:
        if (r4 == false) goto L14;
        return false;
    L14:
        return true;
    L8:
        if (r3.length() == 0) goto L11;
        r4 = false;
        goto L12
    L15:
        return false;
    }

    private final boolean shouldUseStaticText(boolean r2, boolean r3, ItemKey r4, CharSequence r5, CharSequence r6) {
        if (r2 == true) goto L11;
        if (r3 == false) goto L14;
        boolean r7 = hasSameTextRender(r4, TextRenderMode.PROMPT_PENDING, r5);
        boolean r1 = hasChangedContentPendingText(r4, r6);
        if (r7 == true) goto L12;
        if (r1 == true) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L14:
        return false;
    L11:
        return false;
    }

    private final StateInput buildStateInput(BindData r12) {
        ItemKey r1 = new ItemKey(r12.getDate(), r12.getNumber());
        updateConsumptionScope(r1);
        boolean r2 = r12.getSummaryEnabled();
        boolean r3 = r12.isWorking();
        boolean r4 = r12.getHasSummary();
        boolean r5 = r12.getHasFailure();
        if (Intrinsics.areEqual(this.pendingFailureCollapseItemKey, r1) == false) goto L5;
    L8:
        boolean r13 = true;
    L10:
        return new StateInput(r1, r2, r3, r4, r5, r13, isCardVisible(), this.hasConsumedInitialExpand, this.hasConsumedFailureCollapse);
    L5:
        if (Intrinsics.areEqual(this.collapsingItemKey, r1) == true) goto L8;
        r13 = false;
        goto L10
    }

    private final UiState resolveUiState(StateInput r2) {
        if (r2.getShouldShowCard() == true) goto L6;
        return UiState.HIDDEN;
    L6:
        if (r2.getItemKey() == null) goto L11;
        if (Intrinsics.areEqual(r2.getItemKey(), this.collapsingItemKey) == false) goto L11;
        return UiState.FAILURE_COLLAPSE;
    L11:
        if (r2.getRequestFailureCollapse() == false) goto L18;
        if (r2.getHasFailure() == false) goto L18;
        if (r2.getHasConsumedFailureCollapse() == true) goto L18;
        return UiState.FAILURE_COLLAPSE;
    L18:
        if (r2.isCardCurrentlyVisible() == true) goto L29;
        if (r2.getHasConsumedInitialExpand() == true) goto L29;
        if (r2.isWorking() == true) goto L42;
        if (r2.getHasSummary() == true) goto L42;
        if (r2.getHasFailure() == false) goto L29;
    L42:
        return UiState.FIRST_EXPAND;
    L29:
        if (r2.getHasSummary() == false) goto L32;
        return UiState.SUMMARY_SUCCESS;
    L32:
        if (r2.getHasFailure() == false) goto L35;
        return UiState.SUMMARY_FAILURE;
    L35:
        if (r2.isWorking() == false) goto L38;
        return UiState.SUMMARY_PENDING;
    L38:
        return UiState.HIDDEN;
    }

    private final boolean shouldConsumeInitialExpand(UiState r2) {
        if (r2 == UiState.FIRST_EXPAND) goto L5;
    L7:
        return false;
    L5:
        if (this.hasConsumedInitialExpand == true) goto L7;
        return true;
    }

    private final boolean consumeInitialExpandOnce(UiState r2) {
        if (shouldConsumeInitialExpand(r2) == true) goto L6;
        return false;
    L6:
        this.hasConsumedInitialExpand = true;
        String r1 = consumptionKey(this.currentItemKey);
        if (r1 == null) goto L9;
        Companion.access$rememberConsumedInitialExpandKey(Companion, r1);
    L9:
        return true;
    }

    private final boolean shouldConsumeFailureCollapse(UiState r2) {
        if (r2 == UiState.FAILURE_COLLAPSE) goto L5;
    L7:
        return false;
    L5:
        if (this.hasConsumedFailureCollapse == true) goto L7;
        return true;
    }

    private final boolean consumeFailureCollapseOnce(UiState r1) {
        if (shouldConsumeFailureCollapse(r1) == true) goto L6;
        return false;
    L6:
        this.hasConsumedFailureCollapse = true;
        return true;
    }

    private final void resetFailureCollapseConsumptionIfNewWorking(BindData r2, BindData r3) {
        if (r3.isWorking() == true) goto L5;
        return;
    L5:
        if (r2 == null) goto L9;
        boolean r0 = true;
        if (r2.isWorking() != true) goto L9;
    L10:
        if (r0 == false) goto L12;
        return;
    L12:
        if (this.hasConsumedFailureCollapse == false) goto L18;
        this.hasConsumedFailureCollapse = false;
        return;
    L18:
        return;
    L9:
        r0 = false;
        goto L10
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        cancelInitialExpandAnimation();
        cancelFailureCollapseRequest();
        cancelFailureCollapseAnimation();
        this.textEffectView.stopEffect();
        stopLeftIconAnimation();
        super.onDetachedFromWindow();
    }

    private final int getInitialExpandTargetHeight() {
        return MathKt.roundToInt(TypedValue.applyDimension(1, 38, Resources.getSystem().getDisplayMetrics()));
    }

    private final float targetCardTranslationY() {
        return MathKt.roundToInt(TypedValue.applyDimension(1, 6, Resources.getSystem().getDisplayMetrics()));
    }

    private final float appearStartCardTranslationY() {
        return MathKt.roundToInt(TypedValue.applyDimension(1, 2, Resources.getSystem().getDisplayMetrics()));
    }

    private final float disappearEndCardTranslationY() {
        return MathKt.roundToInt(TypedValue.applyDimension(1, 2, Resources.getSystem().getDisplayMetrics()));
    }
}

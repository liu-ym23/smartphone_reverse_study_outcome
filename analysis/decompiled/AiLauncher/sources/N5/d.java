package N5;

import La.D;
import La.H;
import Z8.F;
import Z8.Y;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import com.stepos.ailauncher.common.utils.C3202f;
import com.stepos.ailauncher.foundation.R$anim;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h8.C4148a;
import io.ktor.sse.ServerSentEventKt;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import net.sqlcipher.database.SQLiteDatabase;
import p7.AppUI;

@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u0000 \u0099\u00012\u00020\u0001:\u0002\u009a\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0014¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0004¢\u0006\u0004\b\u000f\u0010\u0010J/\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u0011\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b\u0011\u0010!J\u000f\u0010#\u001a\u00020\"H\u0014¢\u0006\u0004\b#\u0010$J!\u0010)\u001a\u00020\n2\u0006\u0010&\u001a\u00020%2\b\u0010(\u001a\u0004\u0018\u00010'H\u0004¢\u0006\u0004\b)\u0010*JM\u00101\u001a\u00020\u000e2\b\u0010+\u001a\u0004\u0018\u00010'2\b\u0010,\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010'2\b\b\u0002\u0010.\u001a\u00020\u000e2\b\b\u0002\u0010/\u001a\u00020\u000e2\b\b\u0002\u00100\u001a\u00020\u000eH\u0004¢\u0006\u0004\b1\u00102J\u0017\u00104\u001a\u00020\n2\u0006\u00103\u001a\u00020'H\u0004¢\u0006\u0004\b4\u00105J!\u00108\u001a\u00020\n2\u0006\u00106\u001a\u00020'2\b\b\u0002\u00107\u001a\u00020\u000eH\u0004¢\u0006\u0004\b8\u00109J\u0017\u0010:\u001a\u00020\n2\u0006\u00106\u001a\u00020'H\u0004¢\u0006\u0004\b:\u00105J\u0017\u0010<\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020'H\u0004¢\u0006\u0004\b<\u0010=J\u0017\u0010@\u001a\u00020\n2\u0006\u0010?\u001a\u00020>H\u0014¢\u0006\u0004\b@\u0010AJ\u0017\u0010B\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u001fH\u0014¢\u0006\u0004\bB\u0010CJ!\u0010D\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0014¢\u0006\u0004\bD\u0010!J\u0017\u0010E\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001dH\u0014¢\u0006\u0004\bE\u0010FJ\u001b\u0010I\u001a\u0004\u0018\u00010H2\b\u0010G\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\bI\u0010JJ\u0019\u0010M\u001a\u00020\n2\b\u0010L\u001a\u0004\u0018\u00010KH\u0002¢\u0006\u0004\bM\u0010NJ\u001b\u0010Q\u001a\u0004\u0018\u00010P2\b\u0010O\u001a\u0004\u0018\u00010'H\u0002¢\u0006\u0004\bQ\u0010RJ\u0017\u0010S\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\bS\u0010FJ\u0017\u0010T\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\bT\u0010UJ\u000f\u0010V\u001a\u00020\nH\u0002¢\u0006\u0004\bV\u0010\fJ\u000f\u0010W\u001a\u00020\nH\u0002¢\u0006\u0004\bW\u0010\fJ\u000f\u0010X\u001a\u00020\nH\u0002¢\u0006\u0004\bX\u0010\fJ\u0019\u0010[\u001a\u00020\n2\b\u0010Z\u001a\u0004\u0018\u00010YH\u0002¢\u0006\u0004\b[\u0010\\J\u0017\u0010^\u001a\u00020\n2\u0006\u0010]\u001a\u00020\u000eH\u0002¢\u0006\u0004\b^\u0010_J!\u0010`\u001a\u00020\n2\u0006\u0010&\u001a\u00020%2\b\u0010(\u001a\u0004\u0018\u00010'H\u0002¢\u0006\u0004\b`\u0010*J\u000f\u0010a\u001a\u00020\nH\u0002¢\u0006\u0004\ba\u0010\fJ\u000f\u0010b\u001a\u00020\nH\u0002¢\u0006\u0004\bb\u0010\fJA\u0010e\u001a\u00020\u000e2\u0006\u0010c\u001a\u00020'2\n\b\u0002\u0010d\u001a\u0004\u0018\u00010'2\b\b\u0002\u0010.\u001a\u00020\u000e2\b\b\u0002\u0010/\u001a\u00020\u000e2\b\b\u0002\u00100\u001a\u00020\u000eH\u0002¢\u0006\u0004\be\u0010fJ\u0019\u0010i\u001a\u0004\u0018\u00010'2\u0006\u0010h\u001a\u00020gH\u0002¢\u0006\u0004\bi\u0010jJ!\u0010l\u001a\u00020\u000e2\u0006\u0010h\u001a\u00020g2\b\u0010k\u001a\u0004\u0018\u00010HH\u0002¢\u0006\u0004\bl\u0010mJ!\u0010n\u001a\u00020\n2\u0006\u0010h\u001a\u00020g2\b\u0010k\u001a\u0004\u0018\u00010HH\u0002¢\u0006\u0004\bn\u0010oJ\u0011\u0010p\u001a\u0004\u0018\u00010HH\u0002¢\u0006\u0004\bp\u0010qJ\u001b\u0010r\u001a\u0004\u0018\u00010H2\b\u0010G\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\br\u0010JJ\u0011\u0010s\u001a\u0004\u0018\u00010PH\u0002¢\u0006\u0004\bs\u0010tR\u001a\u0010v\u001a\u00020u8\u0004X\u0084\u0004¢\u0006\f\n\u0004\bv\u0010w\u001a\u0004\bx\u0010yR\u0014\u0010z\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bz\u0010{R\u0014\u0010|\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b|\u0010{R\u0014\u0010}\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b}\u0010{R\u0016\u0010~\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010\u007fR\u0019\u0010\u0080\u0001\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R-\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u001d2\b\u0010(\u001a\u0004\u0018\u00010\u001d8\u0000@BX\u0080\u000e¢\u0006\u0010\n\u0006\b\u0082\u0001\u0010\u0083\u0001\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001R\u001b\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R\u001b\u0010\u0088\u0001\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0081\u0001R\u001b\u0010\u0089\u0001\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u0081\u0001R\u0018\u0010\u008b\u0001\u001a\u00030\u008a\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001R\u0018\u0010\u008e\u0001\u001a\u00030\u008d\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001R\u0018\u0010\u0091\u0001\u001a\u00030\u0090\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u0092\u0001R\u0018\u0010\u0093\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0093\u0001\u0010\u007fR\u0018\u0010\u0094\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0094\u0001\u0010\u007fR\u001d\u0010\u0095\u0001\u001a\u00020\u000e8\u0014X\u0094D¢\u0006\u000e\n\u0005\b\u0095\u0001\u0010\u007f\u001a\u0005\b\u0096\u0001\u0010\u0010R\u001d\u0010\u0097\u0001\u001a\u00020\u000e8\u0014X\u0094D¢\u0006\u000e\n\u0005\b\u0097\u0001\u0010\u007f\u001a\u0005\b\u0098\u0001\u0010\u0010¨\u0006\u009b\u0001"}, d2 = {"LN5/d;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "LY8/t;", "onAttachedToWindow", "()V", "onDetachedFromWindow", "", "w", "()Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "oldw", "oldh", "onSizeChanged", "(IIII)V", "visibility", "onWindowVisibilityChanged", "(I)V", "Landroid/view/View;", "changedView", "onVisibilityChanged", "(Landroid/view/View;I)V", "LN5/i;", "envelope", "LN5/n;", AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, "(LN5/i;LN5/n;)V", "Landroid/widget/ImageView;", "p", "()Landroid/widget/ImageView;", "Landroid/widget/TextView;", "tv", "", UxipConstants.f30680s, "n", "(Landroid/widget/TextView;Ljava/lang/String;)V", "app", AppUI.TYPE_WEB, "preferredPackage", "dismissWakeNoAnim", "systemSlide", "preserveWakeDialog", "F", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZ)Z", "action", "R", "(Ljava/lang/String;)V", "target", "noAnim", "z", "(Ljava/lang/String;Z)V", "B", "text", "P", "(Ljava/lang/String;)Z", "Landroid/widget/FrameLayout;", "container", ExifInterface.LONGITUDE_EAST, "(Landroid/widget/FrameLayout;)V", "C", "(LN5/n;)V", "D", "Q", "(LN5/i;)Z", "ctx", "Landroid/app/Activity;", "s", "(Landroid/content/Context;)Landroid/app/Activity;", "LN5/e;", "icon", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(LN5/e;)V", "data", "Landroid/graphics/Bitmap;", "q", "(Ljava/lang/String;)Landroid/graphics/Bitmap;", "t", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(LN5/i;)V", "u", "M", "L", "LN5/w;", "source", "l", "(LN5/w;)V", "expanded", "setBodyExpanded", "(Z)V", "k", "N", "J", "uri", "targetPackage", "H", "(Ljava/lang/String;Ljava/lang/String;ZZZ)Z", "Landroid/content/Intent;", "intent", "K", "(Landroid/content/Intent;)Ljava/lang/String;", "activity", "x", "(Landroid/content/Intent;Landroid/app/Activity;)Z", "y", "(Landroid/content/Intent;Landroid/app/Activity;)V", "v", "()Landroid/app/Activity;", ExifInterface.LATITUDE_SOUTH, "o", "()Landroid/graphics/Bitmap;", "LT5/j;", "binding", "LT5/j;", "getBinding", "()LT5/j;", "defaultRootPaddingTop", "I", "defaultRootPaddingBottom", "defaultCustomContentMarginTop", "customInflated", "Z", "traceTaskId", "Ljava/lang/String;", "boundEnvelope", "LN5/i;", "getBoundEnvelope$foundation_release", "()LN5/i;", "boundModel", "LN5/n;", "boundExposureIdentity", "exposureReportedKey", "Landroid/graphics/Rect;", "exposureRect", "Landroid/graphics/Rect;", "Ljava/lang/Runnable;", "exposureRunnable", "Ljava/lang/Runnable;", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "scrollChangedListener", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "scrollListenerRegistered", "firstSizedLogged", "hidesCommonChrome", "getHidesCommonChrome", "showsChannelLogo", "getShowsChannelLogo", "Companion", Const.INTENT_KEY_APIKEY, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public class d extends LinearLayout {
    private static final String ACTION_CARD_OPEN_SLIDE = "com.stepos.ailauncher.action.CARD_OPEN_SLIDE";
    private static final String ACTION_CARD_SEND_TEXT = "com.stepos.ailauncher.action.CARD_SEND_TEXT";
    private static final String ACTION_DISMISS_WAKE = "com.stepos.ailauncher.action.DISMISS_WAKE";
    private static final String ACTION_HIDE_WAKE = "com.stepos.ailauncher.action.HIDE_WAKE";
    public static final String EXTRA_CARD_OPEN_URI = "card_open_uri";
    private static final String EXTRA_CARD_TEXT = "card_text";
    public static final String EXTRA_DISMISS_NO_ANIM = "dismiss_no_anim";
    private static final String TAG = "BaseCardView";
    private final T5.j binding;
    private CardEnvelope boundEnvelope;
    private String boundExposureIdentity;
    private n boundModel;
    private boolean customInflated;
    private final int defaultCustomContentMarginTop;
    private final int defaultRootPaddingBottom;
    private final int defaultRootPaddingTop;
    private final Rect exposureRect;
    private String exposureReportedKey;
    private final Runnable exposureRunnable;
    private boolean firstSizedLogged;
    private final boolean hidesCommonChrome;
    private final ViewTreeObserver.OnScrollChangedListener scrollChangedListener;
    private boolean scrollListenerRegistered;
    private final boolean showsChannelLogo;
    private String traceTaskId;
    private static final Set<String> CHROMELESS_BIZ_CHANNELS = Y.j("ctrip", "meituan");
    private static final Set<String> CHROMELESS_TEMPLATE_TYPES = Y.j(O5.c.MAP_ROUTE, O5.c.MAP_POI_LIST, O5.c.MAP_POI_DETAIL);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        T5.j jVarC = T5.j.c(LayoutInflater.from(context), this, true);
        kotlin.jvm.internal.p.h(jVarC, "inflate(...)");
        this.binding = jVarC;
        this.defaultRootPaddingTop = jVarC.b().getPaddingTop();
        this.defaultRootPaddingBottom = jVarC.b().getPaddingBottom();
        ViewGroup.LayoutParams layoutParams = jVarC.flCustomContent.getLayoutParams();
        kotlin.jvm.internal.p.g(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        this.defaultCustomContentMarginTop = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.traceTaskId = "";
        this.exposureRect = new Rect();
        this.exposureRunnable = new Runnable() { // from class: N5.a
            @Override // java.lang.Runnable
            public final void run() {
                d.r(this.f4847a);
            }
        };
        this.scrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() { // from class: N5.b
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                d.O(this.f4848a);
            }
        };
        this.showsChannelLogo = true;
    }

    public static /* synthetic */ void A(d dVar, String str, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: notifyHostDismiss");
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        dVar.z(str, z10);
    }

    public static /* synthetic */ boolean G(d dVar, String str, String str2, String str3, boolean z10, boolean z11, boolean z12, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openLink");
        }
        if ((i10 & 4) != 0) {
            str3 = null;
        }
        return dVar.F(str, str2, str3, (i10 & 8) != 0 ? false : z10, (i10 & 16) != 0 ? false : z11, (i10 & 32) != 0 ? false : z12);
    }

    public static /* synthetic */ boolean I(d dVar, String str, String str2, boolean z10, boolean z11, boolean z12, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openUri");
        }
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        return dVar.H(str, str2, (i10 & 4) != 0 ? false : z10, (i10 & 8) != 0 ? false : z11, (i10 & 16) != 0 ? false : z12);
    }

    public static final void O(d dVar) {
        dVar.N();
    }

    private final Activity S(Context ctx) {
        while (ctx instanceof ContextWrapper) {
            if (ctx instanceof Activity) {
                Activity activity = (Activity) ctx;
                if (activity.isFinishing() || activity.isDestroyed()) {
                    ctx = null;
                }
                return (Activity) ctx;
            }
            ctx = ((ContextWrapper) ctx).getBaseContext();
        }
        return null;
    }

    public static final void m(d dVar, View view) {
        dVar.setBodyExpanded(dVar.binding.llCardBody.getVisibility() != 0);
    }

    public static final void r(d dVar) {
        dVar.J();
    }

    private final void setBodyExpanded(boolean expanded) {
        this.binding.llCardBody.setVisibility(expanded ? 0 : 8);
        this.binding.tvSearchChevron.setText(expanded ? "⌄" : "⌃");
    }

    public final void B(String target) {
        Object objB;
        kotlin.jvm.internal.p.i(target, "target");
        try {
            Result.Companion companion = Result.INSTANCE;
            getContext().sendBroadcast(new Intent("com.stepos.ailauncher.action.HIDE_WAKE").setPackage(getContext().getPackageName()));
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            R5.b.INSTANCE.h("view.hideWake.fail", Y8.j.a("uri", target), Y8.j.a("exception", thE.getClass().getSimpleName()), Y8.j.a("message", thE.getMessage()));
        }
    }

    public void C(n model) {
        kotlin.jvm.internal.p.i(model, "model");
    }

    public void D(CardEnvelope envelope, n model) {
        kotlin.jvm.internal.p.i(envelope, "envelope");
    }

    public void E(FrameLayout container) {
        kotlin.jvm.internal.p.i(container, "container");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x000f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean F(java.lang.String r9, java.lang.String r10, java.lang.String r11, boolean r12, boolean r13, boolean r14) {
        /*
            r8 = this;
            if (r9 == 0) goto Lf
            int r0 = r9.length()
            if (r0 <= 0) goto L9
            goto La
        L9:
            r9 = 0
        La:
            if (r9 != 0) goto Ld
            goto Lf
        Ld:
            r1 = r9
            goto L10
        Lf:
            r1 = r10
        L10:
            if (r1 == 0) goto L3b
            int r9 = r1.length()
            if (r9 != 0) goto L19
            goto L3b
        L19:
            if (r11 == 0) goto L21
            int r9 = r11.length()
            if (r9 != 0) goto L26
        L21:
            r0 = r8
            r3 = r12
            r4 = r13
            r5 = r14
            goto L33
        L26:
            r0 = r8
            r2 = r11
            r3 = r12
            r4 = r13
            r5 = r14
            boolean r8 = r0.H(r1, r2, r3, r4, r5)
            if (r8 == 0) goto L33
            r8 = 1
            return r8
        L33:
            r6 = 2
            r7 = 0
            r2 = 0
            boolean r8 = I(r0, r1, r2, r3, r4, r5, r6, r7)
            return r8
        L3b:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: N5.d.F(java.lang.String, java.lang.String, java.lang.String, boolean, boolean, boolean):boolean");
    }

    public final boolean H(String uri, String targetPackage, boolean dismissWakeNoAnim, boolean systemSlide, boolean preserveWakeDialog) {
        String lowerCase;
        String scheme;
        String strT = D.T(D.T(D.T(D.T(D.T(uri, "&amp;", Const.STR_MART_ADD, false, 4, null), "&lt;", "<", false, 4, null), "&gt;", ">", false, 4, null), "&quot;", "\"", false, 4, null), "&#39;", "'", false, 4, null);
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(strT));
            if (targetPackage != null && targetPackage.length() != 0) {
                intent.setPackage(targetPackage);
            }
            Uri data = intent.getData();
            if (data == null || (scheme = data.getScheme()) == null) {
                lowerCase = null;
            } else {
                lowerCase = scheme.toLowerCase(Locale.ROOT);
                kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
            }
            boolean z10 = (lowerCase == null || lowerCase.length() == 0 || kotlin.jvm.internal.p.d(lowerCase, "http") || kotlin.jvm.internal.p.d(lowerCase, "https")) ? false : true;
            String strK = z10 ? K(intent) : null;
            boolean z11 = z10 && !kotlin.jvm.internal.p.d(strK, getContext().getPackageName());
            Activity activityV = v();
            if (z11) {
                intent.addFlags(268468224);
            } else if (activityV == null) {
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            }
            if (preserveWakeDialog) {
                B(strT);
            } else {
                z(strT, dismissWakeNoAnim && !systemSlide);
            }
            boolean z12 = systemSlide && x(intent, activityV);
            if (!systemSlide) {
                (activityV != null ? activityV : getContext()).startActivity(intent);
            } else if (!z12) {
                y(intent, activityV);
            }
            R5.b bVar = R5.b.INSTANCE;
            Pair pairA = Y8.j.a("uri", strT);
            Pair pairA2 = Y8.j.a("pkg", targetPackage);
            Pair pairA3 = Y8.j.a("decoded", Boolean.valueOf(!kotlin.jvm.internal.p.d(strT, uri)));
            Pair pairA4 = Y8.j.a("wakeNoAnim", Boolean.valueOf(dismissWakeNoAnim));
            Pair pairA5 = Y8.j.a("preserveWake", Boolean.valueOf(preserveWakeDialog));
            Pair pairA6 = Y8.j.a("slideOverlay", Boolean.valueOf(z12));
            if (strK == null) {
                strK = "null";
            }
            bVar.c("view.openUri", pairA, pairA2, pairA3, pairA4, pairA5, pairA6, Y8.j.a("targetPkg", strK), Y8.j.a("clearTask", Boolean.valueOf(z11)));
            return true;
        } catch (Exception e10) {
            t.INSTANCE.k();
            R5.b.INSTANCE.h("view.openUri.fail", Y8.j.a("uri", strT), Y8.j.a("pkg", targetPackage), Y8.j.a("exception", e10.getClass().getSimpleName()), Y8.j.a("message", e10.getMessage()));
            C4148a.h(TAG, "openUri failed: " + strT + ", " + e10.getMessage(), false, 4, null);
            return false;
        }
    }

    public final void J() {
        CardEnvelope iVar = this.boundEnvelope;
        if (iVar != null && isAttachedToWindow() && isShown() && getWidth() > 0 && getHeight() > 0 && getGlobalVisibleRect(this.exposureRect) && !this.exposureRect.isEmpty()) {
            String strO = iVar.getTaskId();
            n nVar = this.boundModel;
            String cardId = nVar != null ? nVar.getCardId() : null;
            if (cardId == null) {
                cardId = "";
            }
            String str = strO + ServerSentEventKt.COLON + cardId;
            if (kotlin.jvm.internal.p.d(str, this.exposureReportedKey)) {
                return;
            }
            M5.e.INSTANCE.d(iVar, this.boundModel);
            D(iVar, this.boundModel);
            this.exposureReportedKey = str;
        }
    }

    public final String K(Intent intent) {
        Object objB;
        ActivityInfo activityInfo;
        try {
            Result.Companion companion = Result.INSTANCE;
            ResolveInfo resolveInfoResolveActivity = getContext().getPackageManager().resolveActivity(intent, 65536);
            objB = Result.b((resolveInfoResolveActivity == null || (activityInfo = resolveInfoResolveActivity.activityInfo) == null) ? null : activityInfo.packageName);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        return (String) (Result.g(objB) ? null : objB);
    }

    public final void L() {
        ViewGroup.LayoutParams layoutParams = this.binding.flCustomContent.getLayoutParams();
        kotlin.jvm.internal.p.g(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        int i10 = marginLayoutParams.topMargin;
        int i11 = this.defaultCustomContentMarginTop;
        if (i10 == i11) {
            return;
        }
        marginLayoutParams.topMargin = i11;
        this.binding.flCustomContent.setLayoutParams(marginLayoutParams);
    }

    public final void M() {
        if (this.binding.b().getPaddingTop() == this.defaultRootPaddingTop && this.binding.b().getPaddingBottom() == this.defaultRootPaddingBottom) {
            return;
        }
        this.binding.b().setPadding(this.binding.b().getPaddingLeft(), this.defaultRootPaddingTop, this.binding.b().getPaddingRight(), this.defaultRootPaddingBottom);
    }

    public final void N() {
        removeCallbacks(this.exposureRunnable);
        if (isAttachedToWindow() && getWindowVisibility() == 0) {
            post(this.exposureRunnable);
        }
    }

    public final boolean P(String text) {
        Object objB;
        kotlin.jvm.internal.p.i(text, "text");
        if (H.x0(text)) {
            return false;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            getContext().sendBroadcast(new Intent("com.stepos.ailauncher.action.CARD_SEND_TEXT").setPackage(getContext().getPackageName()).putExtra("card_text", text));
            R5.b.INSTANCE.c("view.sendChatText", Y8.j.a("len", Integer.valueOf(text.length())));
            objB = Result.b(Boolean.TRUE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            R5.b.INSTANCE.h("view.sendChatText.fail", Y8.j.a("exception", thE.getClass().getSimpleName()), Y8.j.a("message", thE.getMessage()));
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        return ((Boolean) objB).booleanValue();
    }

    public boolean Q(CardEnvelope envelope) {
        kotlin.jvm.internal.p.i(envelope, "envelope");
        return true;
    }

    public final void R(String action) {
        kotlin.jvm.internal.p.i(action, "action");
        M5.e.INSTANCE.a(this.boundEnvelope, this.boundModel, action);
    }

    public final T5.j getBinding() {
        return this.binding;
    }

    /* renamed from: getBoundEnvelope$foundation_release, reason: from getter */
    public final CardEnvelope getBoundEnvelope() {
        return this.boundEnvelope;
    }

    public boolean getHidesCommonChrome() {
        return this.hidesCommonChrome;
    }

    public boolean getShowsChannelLogo() {
        return this.showsChannelLogo;
    }

    public final void h(CardEnvelope envelope, n model) {
        kotlin.jvm.internal.p.i(envelope, "envelope");
        this.traceTaskId = envelope.getTaskId();
        if (t(envelope) && Q(envelope)) {
            setVisibility(8);
            R5.b bVar = R5.b.INSTANCE;
            String strO = envelope.getTaskId();
            bVar.c("view.hide.emptyItems", Y8.j.a("taskId", strO.length() != 0 ? strO : "null"), Y8.j.a("templateType", envelope.getTemplateType()));
            return;
        }
        this.boundEnvelope = envelope;
        this.boundModel = model;
        if (!kotlin.jvm.internal.p.d(this.boundExposureIdentity, envelope.getTaskId())) {
            this.boundExposureIdentity = envelope.getTaskId();
            this.exposureReportedKey = null;
        }
        setVisibility(0);
        N();
        R5.b bVar2 = R5.b.INSTANCE;
        String strO2 = envelope.getTaskId();
        if (strO2.length() == 0) {
            strO2 = "null";
        }
        String str = "view.bind:" + ((Object) strO2);
        String strO3 = envelope.getTaskId();
        bVar2.e(str, "view.bind", Y8.j.a("taskId", strO3.length() != 0 ? strO3 : "null"), Y8.j.a("templateType", envelope.getTemplateType()), Y8.j.a("viewCls", getClass().getSimpleName()), Y8.j.a("hasModel", Boolean.valueOf(model != null)));
        j(envelope);
        if (!this.customInflated) {
            FrameLayout flCustomContent = this.binding.flCustomContent;
            kotlin.jvm.internal.p.h(flCustomContent, "flCustomContent");
            E(flCustomContent);
            this.customInflated = true;
        }
        if (model != null) {
            C(model);
        }
        i(envelope.getBizChannelIcon());
    }

    public final void i(BizChannelIcon icon) {
        ImageView ivChannelLogo;
        ImageView imageView;
        ImageView imageViewP;
        String iconBaseData;
        if (!getShowsChannelLogo()) {
            this.binding.ivChannelLogo.setVisibility(8);
            this.binding.ivChannelLogo.setImageDrawable(null);
            ImageView imageViewP2 = p();
            if (imageViewP2 != this.binding.ivChannelLogo) {
                imageViewP2.setVisibility(8);
                imageViewP2.setImageDrawable(null);
                return;
            }
            return;
        }
        Bitmap bitmapQ = q(icon != null ? icon.getIconBaseData() : null);
        C4148a.d(TAG, "bindChannelLogo iconUrl=" + (icon != null ? icon.getIcon() : null) + " base64Len=" + ((icon == null || (iconBaseData = icon.getIconBaseData()) == null) ? -1 : iconBaseData.length()) + " bitmapNull=" + (bitmapQ == null), false, 4, null);
        if (bitmapQ == null) {
            this.binding.ivChannelLogo.setVisibility(8);
            this.binding.ivChannelLogo.setImageDrawable(null);
            if (!getHidesCommonChrome() || (imageViewP = p()) == this.binding.ivChannelLogo) {
                return;
            }
            imageViewP.setVisibility(8);
            imageViewP.setImageDrawable(null);
            return;
        }
        if (getHidesCommonChrome()) {
            ivChannelLogo = p();
        } else {
            ivChannelLogo = this.binding.ivChannelLogo;
            kotlin.jvm.internal.p.h(ivChannelLogo, "ivChannelLogo");
        }
        if (getHidesCommonChrome() && ivChannelLogo != (imageView = this.binding.ivChannelLogo)) {
            imageView.setVisibility(8);
            this.binding.ivChannelLogo.setImageDrawable(null);
        }
        ivChannelLogo.setImageBitmap(bitmapQ);
        ivChannelLogo.setVisibility(0);
    }

    public final void j(CardEnvelope envelope) {
        String lowerCase;
        String string;
        Set<String> set = CHROMELESS_BIZ_CHANNELS;
        String strC = envelope.getBizChannel();
        CardSearchSource cardSearchSource = null;
        if (strC == null || (string = H.D1(strC).toString()) == null) {
            lowerCase = null;
        } else {
            lowerCase = string.toLowerCase(Locale.ROOT);
            kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
        }
        boolean zF0 = F.f0(set, lowerCase);
        boolean zContains = CHROMELESS_TEMPLATE_TYPES.contains(envelope.getTemplateType());
        if (zF0 || getHidesCommonChrome() || zContains) {
            u();
            if (!zF0 && !zContains) {
                M();
                L();
                return;
            } else {
                this.binding.b().setPadding(this.binding.b().getPaddingLeft(), 0, this.binding.b().getPaddingRight(), 0);
                ViewGroup.LayoutParams layoutParams = this.binding.flCustomContent.getLayoutParams();
                kotlin.jvm.internal.p.g(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = 0;
                return;
            }
        }
        M();
        L();
        CardSearchSource cardSearchSourceL = envelope.getSearchSource();
        if (cardSearchSourceL == null) {
            String strC2 = envelope.getBizChannel();
            if (strC2 != null) {
                if (strC2.length() <= 0) {
                    strC2 = null;
                }
                if (strC2 != null) {
                    cardSearchSource = new CardSearchSource("搜索" + strC2, true);
                }
            }
        } else {
            cardSearchSource = cardSearchSourceL;
        }
        l(cardSearchSource);
        this.binding.tvCardTitle.setVisibility(0);
        TextView textView = this.binding.tvCardTitle;
        String strQ = envelope.getTaskTitle();
        if (strQ == null) {
            strQ = "";
        }
        textView.setText(strQ);
        this.binding.tvCardStatus.setVisibility(8);
        envelope.getSummary();
    }

    public final void k(TextView tv, String value) {
        if (value == null || H.x0(value) || D.L(value, "null", true)) {
            tv.setVisibility(8);
        } else {
            tv.setText(value);
            tv.setVisibility(0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(N5.CardSearchSource r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L14
            T5.j r4 = r3.binding
            android.widget.LinearLayout r4 = r4.llSearchHeader
            r1 = 8
            r4.setVisibility(r1)
            T5.j r3 = r3.binding
            android.widget.LinearLayout r3 = r3.llCardBody
            r3.setVisibility(r0)
            return
        L14:
            T5.j r1 = r3.binding
            android.widget.LinearLayout r1 = r1.llSearchHeader
            r1.setVisibility(r0)
            T5.j r0 = r3.binding
            android.widget.TextView r0 = r0.tvSearchSource
            java.lang.String r1 = r4.getLabel()
            if (r1 == 0) goto L30
            int r2 = r1.length()
            if (r2 <= 0) goto L2c
            goto L2d
        L2c:
            r1 = 0
        L2d:
            if (r1 == 0) goto L30
            goto L33
        L30:
            java.lang.String r1 = "搜索携程"
        L33:
            r0.setText(r1)
            boolean r4 = r4.getExpanded()
            r3.setBodyExpanded(r4)
            T5.j r4 = r3.binding
            android.widget.LinearLayout r4 = r4.llSearchHeader
            N5.c r0 = new N5.c
            r0.<init>()
            r4.setOnClickListener(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: N5.d.l(N5.w):void");
    }

    public final void n(TextView tv, String value) {
        kotlin.jvm.internal.p.i(tv, "tv");
        k(tv, value);
    }

    public final Bitmap o() {
        Object objB;
        if (!isAttachedToWindow()) {
            return null;
        }
        View rootView = getRootView();
        int width = rootView.getWidth();
        int height = rootView.getHeight();
        if (width <= 0 || height <= 0) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            kotlin.jvm.internal.p.h(bitmapCreateBitmap, "createBitmap(...)");
            rootView.draw(new Canvas(bitmapCreateBitmap));
            objB = Result.b(bitmapCreateBitmap);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        return (Bitmap) (Result.g(objB) ? null : objB);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!this.scrollListenerRegistered && getViewTreeObserver().isAlive()) {
            getViewTreeObserver().addOnScrollChangedListener(this.scrollChangedListener);
            this.scrollListenerRegistered = true;
        }
        N();
        Context context = getContext();
        R5.b bVar = R5.b.INSTANCE;
        String str = this.traceTaskId;
        if (str.length() == 0) {
            str = "null";
        }
        String str2 = "view.attach:" + ((Object) str) + ServerSentEventKt.COLON + hashCode();
        String str3 = this.traceTaskId;
        Pair pairA = Y8.j.a("taskId", str3.length() != 0 ? str3 : "null");
        Pair pairA2 = Y8.j.a("viewCls", getClass().getSimpleName());
        Pair pairA3 = Y8.j.a("viewHash", Integer.valueOf(hashCode()));
        Pair pairA4 = Y8.j.a("ctxHash", Integer.valueOf(context.hashCode()));
        Pair pairA5 = Y8.j.a("ctxCls", context.getClass().getSimpleName());
        boolean z10 = context instanceof Activity;
        Activity activity = z10 ? (Activity) context : null;
        Pair pairA6 = Y8.j.a("ctxDestroyed", activity != null ? Boolean.valueOf(activity.isDestroyed()) : null);
        Activity activity2 = z10 ? (Activity) context : null;
        bVar.e(str2, "view.attach", pairA, pairA2, pairA3, pairA4, pairA5, pairA6, Y8.j.a("ctxFinishing", activity2 != null ? Boolean.valueOf(activity2.isFinishing()) : null));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.exposureRunnable);
        if (this.scrollListenerRegistered) {
            if (getViewTreeObserver().isAlive()) {
                getViewTreeObserver().removeOnScrollChangedListener(this.scrollChangedListener);
            }
            this.scrollListenerRegistered = false;
        }
        Context context = getContext();
        boolean zW = w();
        R5.b bVar = R5.b.INSTANCE;
        String str = this.traceTaskId;
        if (str.length() == 0) {
            str = "null";
        }
        String str2 = "view.detach:" + ((Object) str) + ServerSentEventKt.COLON + hashCode();
        String str3 = this.traceTaskId;
        bVar.e(str2, "view.detach", Y8.j.a("taskId", str3.length() != 0 ? str3 : "null"), Y8.j.a("viewCls", getClass().getSimpleName()), Y8.j.a("viewHash", Integer.valueOf(hashCode())), Y8.j.a("ctxHash", Integer.valueOf(context.hashCode())), Y8.j.a("dying", Boolean.valueOf(zW)));
        if (zW && this.traceTaskId.length() > 0 && z.INSTANCE.c(this.traceTaskId) != null) {
            bVar.c("view.cache.evict", Y8.j.a("taskId", this.traceTaskId), Y8.j.a("reason", "activity_dying"));
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onSizeChanged(int w10, int h10, int oldw, int oldh) {
        super.onSizeChanged(w10, h10, oldw, oldh);
        N();
        if (this.firstSizedLogged) {
            return;
        }
        this.firstSizedLogged = true;
        R5.b bVar = R5.b.INSTANCE;
        String str = this.traceTaskId;
        if (str.length() == 0) {
            str = "null";
        }
        bVar.c("view.sized", Y8.j.a("taskId", str), Y8.j.a("viewCls", getClass().getSimpleName()), Y8.j.a("width", Integer.valueOf(w10)), Y8.j.a("height", Integer.valueOf(h10)));
    }

    @Override // android.view.View
    public void onVisibilityChanged(View changedView, int visibility) {
        kotlin.jvm.internal.p.i(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        if (visibility == 0) {
            N();
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        if (visibility == 0) {
            N();
        } else {
            removeCallbacks(this.exposureRunnable);
        }
    }

    public ImageView p() {
        ImageView ivChannelLogo = this.binding.ivChannelLogo;
        kotlin.jvm.internal.p.h(ivChannelLogo, "ivChannelLogo");
        return ivChannelLogo;
    }

    public final Bitmap q(String data) {
        Object objB;
        if (data == null) {
            return null;
        }
        if (H.x0(data)) {
            data = null;
        }
        if (data == null) {
            return null;
        }
        String strN1 = H.n1(data, "base64,", data);
        try {
            Result.Companion companion = Result.INSTANCE;
            byte[] bArrDecode = Base64.decode(strN1, 0);
            objB = Result.b(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        return (Bitmap) (Result.g(objB) ? null : objB);
    }

    public final Activity s(Context ctx) {
        while (ctx instanceof ContextWrapper) {
            if (ctx instanceof Activity) {
                return (Activity) ctx;
            }
            ctx = ((ContextWrapper) ctx).getBaseContext();
        }
        return null;
    }

    public final boolean t(CardEnvelope envelope) {
        Map<String, Object> mapE = envelope.e();
        Object obj = mapE != null ? mapE.get(DidiCardProvider.KEY_ITEMS) : null;
        List list = obj instanceof List ? (List) obj : null;
        return list != null && list.isEmpty();
    }

    public final void u() {
        this.binding.llSearchHeader.setVisibility(8);
        this.binding.llCardBody.setVisibility(0);
        this.binding.tvCardTitle.setVisibility(8);
        this.binding.tvCardStatus.setVisibility(8);
        this.binding.tvSummaryTitle.setVisibility(8);
        this.binding.tvSummaryDesc.setVisibility(8);
        this.binding.tvUpdatedAt.setVisibility(8);
        this.binding.llLinks.setVisibility(8);
        this.binding.ivChannelLogo.setVisibility(8);
    }

    public final Activity v() {
        Activity activityA;
        Activity activityS = S(getContext());
        if (activityS != null) {
            return activityS;
        }
        Object parent = getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            Activity activityS2 = S(view.getContext());
            if (activityS2 != null) {
                return activityS2;
            }
            parent = view.getParent();
        }
        if (isAttachedToWindow()) {
            Activity activityS3 = S(getRootView().getContext());
            if (activityS3 != null) {
                return activityS3;
            }
            Object objA = android.view.View.a(this);
            Activity activity = null;
            Activity activity2 = objA instanceof Activity ? (Activity) objA : null;
            if (activity2 != null) {
                if (!activity2.isFinishing() && !activity2.isDestroyed()) {
                    activity = activity2;
                }
                if (activity != null) {
                    return activity;
                }
            }
            for (Object parent2 = this; parent2 instanceof View; parent2 = ((View) parent2).getParent()) {
                if ((parent2 instanceof com.stepos.ailauncher.common.utils.z) && (activityA = ((com.stepos.ailauncher.common.utils.z) parent2).a()) != null) {
                    return activityA;
                }
            }
        }
        return S(C3202f.INSTANCE.c());
    }

    public final boolean w() {
        Activity activityS = s(getContext());
        if (activityS == null) {
            return false;
        }
        return activityS.isDestroyed() || activityS.isFinishing();
    }

    public final boolean x(Intent intent, Activity activity) throws Throwable {
        Object objB;
        t tVar = t.INSTANCE;
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        if (!tVar.p(context, o())) {
            return false;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            (activity != null ? activity : getContext()).startActivity(intent);
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.e(objB) != null) {
            t.INSTANCE.k();
        }
        C4849c.b(objB);
        t.INSTANCE.o();
        return true;
    }

    public final void y(Intent intent, Activity activity) {
        if (activity != null) {
            int i10 = R$anim.card_activity_open_enter;
            int i11 = R$anim.card_activity_open_exit;
            activity.startActivity(intent, ActivityOptions.makeCustomAnimation(activity, i10, i11).toBundle());
            activity.overridePendingTransition(i10, i11);
            return;
        }
        u.INSTANCE.a(o());
        Intent intentAddCategory = new Intent(ACTION_CARD_OPEN_SLIDE).setPackage(getContext().getPackageName()).addCategory("android.intent.category.DEFAULT");
        kotlin.jvm.internal.p.h(intentAddCategory, "addCategory(...)");
        intentAddCategory.putExtra(EXTRA_CARD_OPEN_URI, intent.getDataString());
        intentAddCategory.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intentAddCategory.addFlags(65536);
        getContext().startActivity(intentAddCategory);
    }

    public final void z(String target, boolean noAnim) {
        Object objB;
        kotlin.jvm.internal.p.i(target, "target");
        try {
            Result.Companion companion = Result.INSTANCE;
            Intent intent = new Intent("com.stepos.ailauncher.action.DISMISS_WAKE").setPackage(getContext().getPackageName());
            kotlin.jvm.internal.p.h(intent, "setPackage(...)");
            if (noAnim) {
                intent.putExtra(EXTRA_DISMISS_NO_ANIM, true);
            }
            getContext().sendBroadcast(intent);
            objB = Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            R5.b.INSTANCE.h("view.dismissWake.fail", Y8.j.a("uri", target), Y8.j.a("exception", thE.getClass().getSimpleName()), Y8.j.a("message", thE.getMessage()));
        }
    }

    public /* synthetic */ d(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}

package com.stepos.ailauncher.mcpservice.risk;

import E4.FloatCardContent;
import E4.FloatCardOption;
import E4.FloatCardOptions;
import E4.FloatCardPage;
import E4.FloatCardRequest;
import E4.FloatCardRiskBadge;
import E4.d;
import E4.e;
import E4.g;
import E4.n;
import La.H;
import Y8.t;
import Z8.C1172u;
import Z8.C1174w;
import Z8.F;
import Z8.X;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Insets;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.floatcard.R$id;
import com.stepos.agentframework.floatcard.api.FloatCardOptionStyle;
import com.stepos.agentframework.floatcard.api.FloatCardRiskLevel;
import com.stepos.agentframework.floatcard.api.FloatCardScene;
import com.stepos.agentframework.floatcard.api.FloatCardSkipMode;
import com.stepos.agentframework.floatcard.api.SelectionMode;
import com.stepos.agentframework.floatcard.view.FloatCardContainerView;
import com.stepos.ailauncher.contract.api.livenotification.IRiskLiveNotificationService;
import com.stepos.ailauncher.contract.api.livenotification.RiskLiveButton;
import com.stepos.ailauncher.floatcard.api.IFloatCardEventHandler;
import com.stepos.ailauncher.floatcard.api.IFloatCardService;
import com.stepos.ailauncher.mcpservice.R$drawable;
import com.stepos.ailauncher.mcpservice.R$string;
import com.stepos.ailauncher.mcpservice.risk.q;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import h8.C4148a;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import y7.E;

@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 n2\u00020\u0001:\u0001oB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\f\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0007¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0011\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0012\u0010\u000fJ\u000f\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u001bH\u0002¢\u0006\u0004\b \u0010\u001eJ\u000f\u0010!\u001a\u00020\nH\u0002¢\u0006\u0004\b!\u0010\u000fJ\u0017\u0010%\u001a\u00020$2\u0006\u0010#\u001a\u00020\"H\u0002¢\u0006\u0004\b%\u0010&J\u001f\u0010)\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010(\u001a\u00020'H\u0002¢\u0006\u0004\b)\u0010*J\u0017\u0010,\u001a\u00020\u00132\u0006\u0010+\u001a\u00020\u001bH\u0002¢\u0006\u0004\b,\u0010-J\u000f\u0010/\u001a\u00020.H\u0002¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u0013H\u0002¢\u0006\u0004\b1\u0010\u0015J\u000f\u00102\u001a\u00020\u0013H\u0002¢\u0006\u0004\b2\u0010\u0015J\u000f\u00103\u001a\u00020\u0013H\u0002¢\u0006\u0004\b3\u0010\u0015J\u000f\u00104\u001a\u00020\nH\u0002¢\u0006\u0004\b4\u0010\u000fJ\u000f\u00106\u001a\u000205H\u0002¢\u0006\u0004\b6\u00107J\u0017\u0010:\u001a\u00020\n2\u0006\u00109\u001a\u000208H\u0002¢\u0006\u0004\b:\u0010;J\u0017\u0010<\u001a\u00020\n2\u0006\u00109\u001a\u000208H\u0002¢\u0006\u0004\b<\u0010;J\u000f\u0010=\u001a\u00020\nH\u0002¢\u0006\u0004\b=\u0010\u000fJ\u0017\u0010?\u001a\u00020\n2\u0006\u0010>\u001a\u000208H\u0002¢\u0006\u0004\b?\u0010;J\u000f\u0010A\u001a\u00020@H\u0002¢\u0006\u0004\bA\u0010BJ\u0011\u0010D\u001a\u0004\u0018\u00010CH\u0002¢\u0006\u0004\bD\u0010EJ\u0017\u0010G\u001a\u00020\n2\u0006\u0010F\u001a\u00020\tH\u0002¢\u0006\u0004\bG\u0010HJ\u000f\u0010I\u001a\u00020\nH\u0002¢\u0006\u0004\bI\u0010\u000fJ\u000f\u0010J\u001a\u00020\nH\u0003¢\u0006\u0004\bJ\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010KR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010LR\u0014\u0010N\u001a\u00020M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010Q\u001a\u0004\u0018\u00010P8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010S\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0014\u0010U\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010TR\u0018\u0010V\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0018\u0010Y\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010[\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010]\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010\\R\u0016\u0010^\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010\\R\u0016\u0010_\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010\\R\u0016\u0010`\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010\\R$\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010aR\u0014\u0010c\u001a\u00020b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010dR\u0018\u0010f\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u0014\u0010i\u001a\u00020h8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010jR\u0018\u0010l\u001a\u0004\u0018\u00010k8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010m¨\u0006p"}, d2 = {"Lcom/stepos/ailauncher/mcpservice/risk/o;", "", "Landroid/content/Context;", "context", "Lcom/stepos/ailauncher/mcpservice/risk/p;", "params", "<init>", "(Landroid/content/Context;Lcom/stepos/ailauncher/mcpservice/risk/p;)V", "Lkotlin/Function1;", "Lcom/stepos/ailauncher/mcpservice/risk/q;", "LY8/t;", "onResult", "Y", "(Lp9/l;)V", "F", "()V", ExifInterface.GPS_DIRECTION_TRUE, "b0", "H", "", "K", "()Z", "Lcom/stepos/agentframework/floatcard/view/FloatCardContainerView;", "container", "Landroid/widget/FrameLayout;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lcom/stepos/agentframework/floatcard/view/FloatCardContainerView;)Landroid/widget/FrameLayout;", "Landroid/view/View;", "card", "t", "(Landroid/view/View;)V", "target", "u", "U", "", UxipConstants.f30680s, "", "G", "(F)I", "Landroid/view/MotionEvent;", "ev", "L", "(Lcom/stepos/agentframework/floatcard/view/FloatCardContainerView;Landroid/view/MotionEvent;)Z", Parameters.ROOT, "s", "(Landroid/view/View;)Z", "Landroid/view/WindowManager$LayoutParams;", "z", "()Landroid/view/WindowManager$LayoutParams;", "N", "X", ExifInterface.LONGITUDE_WEST, "y", "Lcom/stepos/ailauncher/floatcard/api/IFloatCardEventHandler;", "J", "()Lcom/stepos/ailauncher/floatcard/api/IFloatCardEventHandler;", "", "buttonId", ExifInterface.LATITUDE_SOUTH, "(Ljava/lang/String;)V", "O", "D", "reason", "C", "LE4/k;", "x", "()LE4/k;", "LE4/l;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "()LE4/l;", "result", "B", "(Lcom/stepos/ailauncher/mcpservice/risk/q;)V", "I", ExifInterface.LONGITUDE_EAST, "Landroid/content/Context;", "Lcom/stepos/ailauncher/mcpservice/risk/p;", "Landroid/view/WindowManager;", "windowManager", "Landroid/view/WindowManager;", "Lcom/stepos/ailauncher/floatcard/api/IFloatCardService;", "service", "Lcom/stepos/ailauncher/floatcard/api/IFloatCardService;", "cardId", "Ljava/lang/String;", "businessType", "overlayRoot", "Landroid/widget/FrameLayout;", "LG4/h;", "host", "LG4/h;", "shownOnKeyguard", "Z", "unlockPending", "delivered", "suppressingLockScreenAutoFinish", "handedOffToNotification", "Lp9/l;", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "Ly7/E;", "glassHandle", "Ly7/E;", "Ljava/lang/Runnable;", "keyguardRecheck", "Ljava/lang/Runnable;", "Landroid/content/BroadcastReceiver;", "screenOffReceiver", "Landroid/content/BroadcastReceiver;", "Companion", Const.INTENT_KEY_APIKEY, "mcpservice_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class o {
    public static final float CARD_CORNER_DP = 24.0f;
    public static final float CARD_MARGIN_BOTTOM_DP = 5.0f;
    public static final float CARD_MARGIN_HORIZONTAL_DP = 12.0f;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final long KEYGUARD_SETTLE_DELAY_MS = 500;
    public static final String SELECTION_ID = "risk";
    public static final String TAG = "RiskStatementFloatCard";
    private static o activePopup;
    private final String businessType;
    private final String cardId;
    private final Context context;
    private boolean delivered;
    private E glassHandle;
    private boolean handedOffToNotification;
    private G4.h host;
    private final Runnable keyguardRecheck;
    private final Handler mainHandler;
    private InterfaceC5074l<? super q, t> onResult;
    private FrameLayout overlayRoot;
    private final RiskStatementParams params;
    private BroadcastReceiver screenOffReceiver;
    private final IFloatCardService service;
    private boolean shownOnKeyguard;
    private boolean suppressingLockScreenAutoFinish;
    private boolean unlockPending;
    private final WindowManager windowManager;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\r\u001a\u00020\f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00118\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/mcpservice/risk/o$a;", "", "<init>", "()V", "", "requestId", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)V", "TAG", "Ljava/lang/String;", "SELECTION_ID", "", "CARD_MARGIN_HORIZONTAL_DP", "F", "CARD_MARGIN_BOTTOM_DP", "CARD_CORNER_DP", "", "KEYGUARD_SETTLE_DELAY_MS", "J", "mcpservice_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.mcpservice.risk.o$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final void a(String requestId) {
            kotlin.jvm.internal.p.i(requestId, "requestId");
            o oVar = o.activePopup;
            if (oVar != null) {
                if (!kotlin.jvm.internal.p.d(oVar.params.getRequestId(), requestId)) {
                    oVar = null;
                }
                if (oVar != null) {
                    oVar.F();
                }
            }
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\n¨\u0006\f"}, d2 = {"com/stepos/ailauncher/mcpservice/risk/o$b", "Landroid/widget/FrameLayout;", "Landroid/view/KeyEvent;", "event", "", "dispatchKeyEvent", "(Landroid/view/KeyEvent;)Z", "Landroid/view/MotionEvent;", "ev", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "onTouchEvent", "mcpservice_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends FrameLayout {
        final /* synthetic */ FloatCardContainerView $container;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(FloatCardContainerView floatCardContainerView, Context context) {
            super(context);
            this.$container = floatCardContainerView;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent event) {
            kotlin.jvm.internal.p.i(event, "event");
            if (event.getKeyCode() == 4) {
                return true;
            }
            return super.dispatchKeyEvent(event);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent ev) {
            kotlin.jvm.internal.p.i(ev, "ev");
            if (ev.getActionMasked() != 0 || o.this.L(this.$container, ev)) {
                return super.onInterceptTouchEvent(ev);
            }
            return true;
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent event) {
            kotlin.jvm.internal.p.i(event, "event");
            return true;
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096@¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"com/stepos/ailauncher/mcpservice/risk/o$c", "Lcom/stepos/ailauncher/floatcard/api/IFloatCardEventHandler;", "LE4/d;", "event", "LE4/e;", "handle", "(LE4/d;Le9/c;)Ljava/lang/Object;", "", "businessType", "Ljava/lang/String;", "getBusinessType", "()Ljava/lang/String;", "mcpservice_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c implements IFloatCardEventHandler {
        private final String businessType;

        public c() {
            this.businessType = o.this.businessType;
        }

        @Override // com.stepos.ailauncher.floatcard.api.IFloatCardEventHandler
        public String getBusinessType() {
            return this.businessType;
        }

        @Override // com.stepos.ailauncher.floatcard.api.IFloatCardEventHandler
        public Object handle(E4.d dVar, InterfaceC4014c<? super E4.e> interfaceC4014c) {
            List<String> listA;
            if (dVar instanceof d.Submit) {
                E4.n nVar = ((d.Submit) dVar).a().get(o.SELECTION_ID);
                n.Selected selected = nVar instanceof n.Selected ? (n.Selected) nVar : null;
                String str = (selected == null || (listA = selected.a()) == null) ? null : (String) F.s0(listA);
                if (str != null) {
                    C4148a.k(o.TAG, "user choice | requestId=" + o.this.params.getRequestId() + ", buttonId=" + str + ", scene=" + o.this.params.getScene(), false, 4, null);
                    o.this.S(str);
                } else {
                    o.this.C("submit_without_choice");
                }
            }
            return e.C0026e.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/mcpservice/risk/o$d", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "receiverContext", "Landroid/content/Intent;", "intent", "LY8/t;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "mcpservice_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d extends BroadcastReceiver {
        public d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context receiverContext, Intent intent) {
            if (kotlin.jvm.internal.p.d(intent != null ? intent.getAction() : null, "android.intent.action.SCREEN_OFF")) {
                if (!o.this.params.i()) {
                    o.this.mainHandler.removeCallbacks(o.this.keyguardRecheck);
                    o.this.mainHandler.postDelayed(o.this.keyguardRecheck, 500L);
                    return;
                }
                C4148a.k(o.TAG, "screen off while unlock risk showing | requestId=" + o.this.params.getRequestId() + ", unlockPending=" + o.this.unlockPending + " -> cancel", false, 4, null);
                o.this.C(com.stepos.ailauncher.chat.trace.h.STATE_SCREEN_OFF);
            }
        }
    }

    public o(Context context, RiskStatementParams params) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(params, "params");
        this.context = context;
        this.params = params;
        Object systemService = context.getSystemService("window");
        kotlin.jvm.internal.p.g(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        this.windowManager = (WindowManager) systemService;
        this.service = (IFloatCardService) D5.a.INSTANCE.a(IFloatCardService.class);
        this.cardId = "risk_statement_" + params.getRequestId();
        this.businessType = "risk_statement_" + params.getRequestId();
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.keyguardRecheck = new Runnable() { // from class: com.stepos.ailauncher.mcpservice.risk.i
            @Override // java.lang.Runnable
            public final void run() {
                o.M(this.f27475a);
            }
        };
    }

    public static final void M(o oVar) {
        oVar.H();
    }

    public static final t P(o oVar) {
        oVar.E();
        return t.f7040a;
    }

    public static final t Q(o oVar, UnlockSceneResult unlockResult) {
        kotlin.jvm.internal.p.i(unlockResult, "unlockResult");
        oVar.unlockPending = false;
        oVar.B(new q.Unlock(unlockResult));
        return t.f7040a;
    }

    public static final void R(o oVar) {
        if (oVar.unlockPending) {
            C4148a.k(TAG, "dismiss overlay + yield conversation host windows after unlock activity started | requestId=" + oVar.params.getRequestId(), false, 4, null);
            oVar.E();
            com.stepos.ailauncher.common.utils.E.INSTANCE.m();
        }
    }

    public static final t Z(final FloatCardContainerView floatCardContainerView, final o oVar, boolean z10, FloatCardOptions floatCardOptions) {
        kotlin.jvm.internal.p.i(floatCardOptions, "<unused var>");
        if (z10) {
            floatCardContainerView.post(new Runnable() { // from class: com.stepos.ailauncher.mcpservice.risk.j
                @Override // java.lang.Runnable
                public final void run() {
                    o.a0(floatCardContainerView, oVar);
                }
            });
        } else {
            oVar.C("card_dismissed_by_framework");
        }
        return t.f7040a;
    }

    public static final void a0(FloatCardContainerView floatCardContainerView, o oVar) {
        View childAt = floatCardContainerView.getChildAt(0);
        if (childAt != null) {
            oVar.t(childAt);
        }
        oVar.y();
    }

    public static final void v(final o oVar, View view) {
        if (oVar.delivered || oVar.overlayRoot == null || !view.isAttachedToWindow() || oVar.glassHandle != null) {
            return;
        }
        com.stepos.ailauncher.container.glass.h hVar = com.stepos.ailauncher.container.glass.h.INSTANCE;
        E eM = com.stepos.ailauncher.container.glass.h.m(hVar, view, true, Float.valueOf(24.0f), y7.o.INSTANCE.h(), false, 16, null);
        if (eM == null) {
            C4148a.k(TAG, "card glass fully degraded, fallback to bg_risk_float_card | requestId=" + oVar.params.getRequestId(), false, 4, null);
            return;
        }
        oVar.glassHandle = eM;
        hVar.G(view, eM, new InterfaceC5074l() { // from class: com.stepos.ailauncher.mcpservice.risk.g
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return o.w(this.f27472a, (E) obj);
            }
        });
        C4148a.d(TAG, "card glass attached | requestId=" + oVar.params.getRequestId(), false, 4, null);
    }

    public static final t w(o oVar, E released) {
        kotlin.jvm.internal.p.i(released, "released");
        if (oVar.glassHandle == released) {
            oVar.glassHandle = null;
        }
        return t.f7040a;
    }

    public final FrameLayout A(FloatCardContainerView container) {
        b bVar = new b(container, this.context);
        bVar.addView(container, new FrameLayout.LayoutParams(-1, -1));
        return bVar;
    }

    public final void B(q result) {
        if (this.delivered) {
            C4148a.u(TAG, "deliver ignored duplicate | requestId=" + this.params.getRequestId() + ", result=" + result, false, 4, null);
            return;
        }
        this.delivered = true;
        C4148a.k(TAG, "deliver | requestId=" + this.params.getRequestId() + ", scene=" + this.params.getScene() + ", result=" + result, false, 4, null);
        E();
        InterfaceC5074l<? super q, t> interfaceC5074l = this.onResult;
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(result);
        }
        this.onResult = null;
        I();
    }

    public final void C(String reason) {
        if (this.delivered) {
            return;
        }
        if (this.unlockPending) {
            C4148a.u(TAG, "deliver cancelled ignored during unlock | requestId=" + this.params.getRequestId() + ", reason=" + reason, false, 4, null);
            return;
        }
        C4148a.k(TAG, "deliver cancelled | requestId=" + this.params.getRequestId() + ", scene=" + this.params.getScene() + ", reason=" + reason, false, 4, null);
        B(this.params.i() ? new q.Unlock(UnlockSceneResult.CANCELLED) : q.a.INSTANCE);
    }

    public final void D() {
        FrameLayout frameLayout = this.overlayRoot;
        if (frameLayout != null) {
            frameLayout.setClickable(false);
            frameLayout.setFocusable(false);
            frameLayout.setFocusableInTouchMode(false);
        }
    }

    public final void E() {
        Object objB;
        Object objB2;
        if (this.overlayRoot == null && this.host == null) {
            if (activePopup == this) {
                activePopup = null;
                return;
            }
            return;
        }
        this.mainHandler.removeCallbacks(this.keyguardRecheck);
        b0();
        IFloatCardService iFloatCardService = this.service;
        if (iFloatCardService != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                IFloatCardService.dismiss$default(iFloatCardService, this.cardId, false, 2, null);
                Result.b(t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
            try {
                iFloatCardService.unregisterEventHandler(this.businessType);
                Result.b(t.f7040a);
            } catch (Throwable th2) {
                Result.Companion companion3 = Result.INSTANCE;
                Result.b(C4849c.a(th2));
            }
            G4.h hVar = this.host;
            if (hVar != null) {
                try {
                    iFloatCardService.unregisterHost(hVar);
                    objB = Result.b(t.f7040a);
                } catch (Throwable th3) {
                    Result.Companion companion4 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th3));
                }
                Result.a(objB);
            }
        }
        this.host = null;
        U();
        FrameLayout frameLayout = this.overlayRoot;
        if (frameLayout != null) {
            try {
                Result.Companion companion5 = Result.INSTANCE;
                this.windowManager.removeViewImmediate(frameLayout);
                objB2 = Result.b(t.f7040a);
            } catch (Throwable th4) {
                Result.Companion companion6 = Result.INSTANCE;
                objB2 = Result.b(C4849c.a(th4));
            }
            Result.a(objB2);
        }
        this.overlayRoot = null;
        if (activePopup == this) {
            activePopup = null;
        }
    }

    public final void F() {
        if (this.delivered) {
            return;
        }
        this.delivered = true;
        this.onResult = null;
        I();
        E();
    }

    public final int G(float value) {
        return (int) ((value * this.context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final void H() {
        if (this.delivered || this.unlockPending || this.overlayRoot == null || this.shownOnKeyguard || !a.INSTANCE.c(this.context)) {
            return;
        }
        C4148a.k(TAG, "overlay hidden by keyguard | requestId=" + this.params.getRequestId() + ", scene=" + this.params.getScene() + ", sessionId=" + this.params.getSessionId() + ", hostWindow=" + com.stepos.ailauncher.common.utils.E.INSTANCE.f() + " -> hand off to live notification", false, 4, null);
        this.handedOffToNotification = true;
        E();
        I();
        if (K()) {
            return;
        }
        com.stepos.ailauncher.mcpservice.risk.notification.a.m(com.stepos.ailauncher.mcpservice.risk.notification.a.INSTANCE, this.context, this.params, 0, null, false, false, 0, null, 252, null);
    }

    public final void I() {
        if (this.suppressingLockScreenAutoFinish) {
            com.stepos.ailauncher.common.utils.E.INSTANCE.d();
            this.suppressingLockScreenAutoFinish = false;
        }
    }

    public final IFloatCardEventHandler J() {
        return new c();
    }

    public final boolean K() {
        String sessionId;
        Object objB;
        if (!this.params.i() && (sessionId = this.params.getSessionId()) != null) {
            String str = !H.x0(sessionId) ? sessionId : null;
            if (str != null) {
                IRiskLiveNotificationService iRiskLiveNotificationService = (IRiskLiveNotificationService) D5.a.INSTANCE.a(IRiskLiveNotificationService.class);
                if (iRiskLiveNotificationService == null) {
                    C4148a.k(TAG, "session live handoff skip: no IRiskLiveNotificationService | requestId=" + this.params.getRequestId(), false, 4, null);
                    return false;
                }
                try {
                    Result.Companion companion = Result.INSTANCE;
                    String requestId = this.params.getRequestId();
                    String title = this.params.getTitle();
                    String body = this.params.getBody();
                    String riskLevel = this.params.getRiskLevel();
                    List<RiskStatementButton> listB = this.params.b();
                    ArrayList arrayList = new ArrayList(C1174w.x(listB, 10));
                    for (RiskStatementButton riskStatementButton : listB) {
                        arrayList.add(new RiskLiveButton(riskStatementButton.getId(), riskStatementButton.getText(), riskStatementButton.getStyle().name()));
                    }
                    Long timeoutMs = this.params.getTimeoutMs();
                    objB = Result.b(Boolean.valueOf(iRiskLiveNotificationService.showSessionRiskCard(str, requestId, title, body, riskLevel, arrayList, timeoutMs != null ? timeoutMs.longValue() : 0L)));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th));
                }
                Throwable thE = Result.e(objB);
                if (thE != null) {
                    C4148a.t(TAG, "session live handoff error | requestId=" + this.params.getRequestId(), thE, false, 8, null);
                    objB = Boolean.FALSE;
                }
                return ((Boolean) objB).booleanValue();
            }
        }
        return false;
    }

    public final boolean L(FloatCardContainerView container, MotionEvent ev) {
        View childAt = container.getChildAt(0);
        if (childAt == null) {
            return true;
        }
        float x10 = ev.getX();
        float y10 = ev.getY();
        return x10 >= ((float) childAt.getLeft()) && x10 <= ((float) childAt.getRight()) && y10 >= ((float) childAt.getTop()) && y10 <= ((float) childAt.getBottom());
    }

    public final boolean N() {
        if (this.params.i() && a.INSTANCE.g(this.context)) {
            return true;
        }
        return com.stepos.ailauncher.common.utils.E.INSTANCE.f();
    }

    public final void O(String buttonId) {
        boolean z10 = this.shownOnKeyguard || a.INSTANCE.g(this.context);
        s sVar = s.INSTANCE;
        q.Unlock unlockB = sVar.b(this.params, buttonId, z10);
        if (unlockB != null) {
            B(unlockB);
            return;
        }
        C4148a.k(TAG, "unlock scene request keyguard | requestId=" + this.params.getRequestId() + ", buttonId=" + buttonId + ", shownOnKeyguard=" + this.shownOnKeyguard, false, 4, null);
        D();
        this.unlockPending = true;
        f.INSTANCE.h(this.params.getRequestId(), new InterfaceC5063a() { // from class: com.stepos.ailauncher.mcpservice.risk.l
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return o.P(this.f27480a);
            }
        });
        sVar.c(this.context, this.params.getRequestId(), new InterfaceC5074l() { // from class: com.stepos.ailauncher.mcpservice.risk.m
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return o.Q(this.f27481a, (UnlockSceneResult) obj);
            }
        });
        FrameLayout frameLayout = this.overlayRoot;
        if (frameLayout != null) {
            frameLayout.post(new Runnable() { // from class: com.stepos.ailauncher.mcpservice.risk.n
                @Override // java.lang.Runnable
                public final void run() {
                    o.R(this.f27482a);
                }
            });
        }
    }

    public final void S(String buttonId) {
        if (this.params.i()) {
            O(buttonId);
        } else {
            B(new q.Chosen(buttonId));
        }
    }

    public final void T() {
        Object objB;
        d dVar = new d();
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(this.context.registerReceiver(dVar, new IntentFilter("android.intent.action.SCREEN_OFF"), 4));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.h(objB)) {
            this.screenOffReceiver = dVar;
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "register SCREEN_OFF failed | requestId=" + this.params.getRequestId(), thE, false, 8, null);
        }
    }

    public final void U() {
        com.stepos.ailauncher.container.glass.h.INSTANCE.F(this.glassHandle);
        this.glassHandle = null;
    }

    public final FloatCardRiskBadge V() {
        if (H.x0(this.params.getRiskLevel())) {
            return null;
        }
        String lowerCase = this.params.getRiskLevel().toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
        if (!kotlin.jvm.internal.p.d(lowerCase, "high")) {
            return null;
        }
        FloatCardRiskLevel floatCardRiskLevel = FloatCardRiskLevel.High;
        String string = this.context.getString(R$string.risk_level_high_mcp);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        return new FloatCardRiskBadge(floatCardRiskLevel, string, null, null, 12, null);
    }

    public final boolean W() {
        return !this.params.i() && a.INSTANCE.c(this.context);
    }

    public final boolean X() {
        return this.params.i() && a.INSTANCE.g(this.context);
    }

    public final void Y(InterfaceC5074l<? super q, t> onResult) {
        kotlin.jvm.internal.p.i(onResult, "onResult");
        this.onResult = onResult;
        if (W()) {
            C4148a.k(TAG, "lock screen: skip FloatCard, hand off to live | requestId=" + this.params.getRequestId() + ", scene=" + this.params.getScene() + ", sessionId=" + this.params.getSessionId() + ", keyguardLocked=" + a.INSTANCE.c(this.context) + ", hostWindow=" + com.stepos.ailauncher.common.utils.E.INSTANCE.f(), false, 4, null);
            this.handedOffToNotification = true;
            if (K()) {
                return;
            }
            com.stepos.ailauncher.mcpservice.risk.notification.a.m(com.stepos.ailauncher.mcpservice.risk.notification.a.INSTANCE, this.context, this.params, 0, null, false, false, 0, null, 252, null);
            return;
        }
        com.stepos.ailauncher.common.utils.E e10 = com.stepos.ailauncher.common.utils.E.INSTANCE;
        if (e10.h()) {
            e10.b();
            this.suppressingLockScreenAutoFinish = true;
        }
        String requestId = this.params.getRequestId();
        String scene = this.params.getScene();
        String str = this.cardId;
        a aVar = a.INSTANCE;
        C4148a.k(TAG, "show start | requestId=" + requestId + ", scene=" + scene + ", cardId=" + str + ", keyguardLocked=" + aVar.c(this.context) + ", screenOn=" + aVar.d(this.context), false, 4, null);
        IFloatCardService iFloatCardService = this.service;
        if (iFloatCardService == null) {
            C4148a.u(TAG, "show failed | requestId=" + this.params.getRequestId() + ", reason=IFloatCardService missing", false, 4, null);
            C("float_card_service_missing");
            return;
        }
        final FloatCardContainerView floatCardContainerView = new FloatCardContainerView(this.context, null, 0, 6, null);
        FrameLayout frameLayoutA = A(floatCardContainerView);
        this.overlayRoot = frameLayoutA;
        G4.h hVar = new G4.h("risk_statement_host_" + this.params.getRequestId(), 1000, this.context, floatCardContainerView, X.d(FloatCardScene.Any), new p9.p() { // from class: com.stepos.ailauncher.mcpservice.risk.h
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return o.Z(floatCardContainerView, this, ((Boolean) obj).booleanValue(), (FloatCardOptions) obj2);
            }
        }, null, null, 192, null);
        this.host = hVar;
        iFloatCardService.registerHost(hVar);
        iFloatCardService.registerEventHandler(J());
        if (!s(frameLayoutA)) {
            C("add_overlay_failed");
            return;
        }
        o oVar = activePopup;
        if (oVar != null) {
            if (oVar == this) {
                oVar = null;
            }
            if (oVar != null) {
                if (kotlin.jvm.internal.p.d(oVar.params.getRequestId(), this.params.getRequestId())) {
                    C4148a.u(TAG, "supersede same-request stale overlay, silent dismiss | requestId=" + this.params.getRequestId(), false, 4, null);
                    oVar.E();
                } else {
                    C4148a.u(TAG, "dismiss stale risk overlay | staleReq=" + oVar.params.getRequestId() + ", newReq=" + this.params.getRequestId(), false, 4, null);
                    oVar.C("superseded_by_new_risk_popup");
                }
            }
        }
        activePopup = this;
        C4148a.k(TAG, "show overlay attached | requestId=" + this.params.getRequestId() + ", cardId=" + this.cardId, false, 4, null);
        T();
        iFloatCardService.show(x());
    }

    public final void b0() {
        BroadcastReceiver broadcastReceiver = this.screenOffReceiver;
        if (broadcastReceiver == null) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            this.context.unregisterReceiver(broadcastReceiver);
            Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        this.screenOffReceiver = null;
    }

    public final boolean s(View root) {
        try {
            this.windowManager.addView(root, z());
            return true;
        } catch (Throwable th) {
            C4148a.g(TAG, "addView failed", th, false, 8, null);
            return false;
        }
    }

    public final void t(View card) {
        Insets insets;
        View viewFindViewById = card.findViewById(R$id.float_card_root);
        if (viewFindViewById == null) {
            viewFindViewById = card;
        }
        viewFindViewById.setBackgroundResource(R$drawable.bg_risk_float_card);
        int iG = G(16.0f);
        viewFindViewById.setPadding(iG, iG, iG, iG);
        ViewGroup.LayoutParams layoutParams = card.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            int iG2 = G(12.0f);
            marginLayoutParams.leftMargin = iG2;
            marginLayoutParams.rightMargin = iG2;
            WindowInsets rootWindowInsets = card.getRootWindowInsets();
            marginLayoutParams.bottomMargin = G(5.0f) + ((rootWindowInsets == null || (insets = rootWindowInsets.getInsets(WindowInsets.Type.navigationBars())) == null) ? 0 : insets.bottom);
            card.setLayoutParams(marginLayoutParams);
        }
        u(viewFindViewById);
    }

    public final void u(final View target) {
        U();
        com.stepos.ailauncher.container.glass.h.INSTANCE.j(target, 24.0f);
        target.post(new Runnable() { // from class: com.stepos.ailauncher.mcpservice.risk.k
            @Override // java.lang.Runnable
            public final void run() {
                o.v(this.f27478a, target);
            }
        });
    }

    public final FloatCardRequest x() {
        String str = this.cardId;
        String str2 = this.businessType;
        FloatCardScene floatCardScene = FloatCardScene.Any;
        FloatCardOptions floatCardOptions = new FloatCardOptions(false, false, false, false, true, 13, null);
        String title = this.params.getTitle();
        String body = this.params.getBody();
        if (H.x0(body)) {
            body = null;
        }
        String str3 = body;
        FloatCardRiskBadge floatCardRiskBadgeV = V();
        List<RiskStatementButton> listE = com.stepos.ailauncher.mcpservice.risk.notification.b.e(this.params.b());
        ArrayList arrayList = new ArrayList(C1174w.x(listE, 10));
        for (RiskStatementButton riskStatementButton : listE) {
            arrayList.add(new FloatCardOption(riskStatementButton.getId(), riskStatementButton.getText(), false, false, false, 28, null));
        }
        return new FloatCardRequest(str, null, str2, floatCardScene, new FloatCardContent(C1172u.e(new FloatCardPage(title, str3, null, null, C1172u.e(new g.Selection(SELECTION_ID, null, arrayList, SelectionMode.Single, FloatCardOptionStyle.Plain, false, 34, null)), FloatCardSkipMode.Hidden, null, null, null, floatCardRiskBadgeV, 460, null)), null, null, null, null, 30, null), floatCardOptions, null, 66, null);
    }

    public final void y() {
        FrameLayout frameLayout;
        Object objB;
        if (this.shownOnKeyguard && (frameLayout = this.overlayRoot) != null) {
            ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
            WindowManager.LayoutParams layoutParams2 = layoutParams instanceof WindowManager.LayoutParams ? (WindowManager.LayoutParams) layoutParams : null;
            if (layoutParams2 == null) {
                return;
            }
            int i10 = layoutParams2.flags;
            if ((2097152 & i10) == 0) {
                return;
            }
            layoutParams2.flags = i10 & (-2097153);
            try {
                Result.Companion companion = Result.INSTANCE;
                this.windowManager.updateViewLayout(frameLayout, layoutParams2);
                objB = Result.b(t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.t(TAG, "clear FLAG_TURN_SCREEN_ON failed | requestId=" + this.params.getRequestId(), thE, false, 8, null);
            }
            C4148a.d(TAG, "cleared FLAG_TURN_SCREEN_ON after visible | requestId=" + this.params.getRequestId(), false, 4, null);
        }
    }

    public final WindowManager.LayoutParams z() {
        boolean zX = X();
        this.shownOnKeyguard = zX;
        boolean zN = N();
        int i10 = zN ? 2009 : 2038;
        int i11 = zX ? 2622208 : 768;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -1, i10, i11, -3);
        layoutParams.gravity = 8388659;
        C4148a.d(TAG, "overlay layout | requestId=" + this.params.getRequestId() + ", showOnKeyguard=" + zX + ", hostLevelWindow=" + zN + ", windowType=" + i10 + ", flags=" + i11, false, 4, null);
        return layoutParams;
    }
}

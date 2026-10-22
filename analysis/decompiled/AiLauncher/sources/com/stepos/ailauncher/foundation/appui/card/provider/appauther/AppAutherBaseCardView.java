package com.stepos.ailauncher.foundation.appui.card.provider.appauther;

import N5.CardEnvelope;
import Ua.C1060i;
import Ua.L0;
import Ua.Y;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatui.appui.BaseAppUIHostView;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import com.stepos.ailauncher.foundation.R$color;
import com.stepos.ailauncher.foundation.R$drawable;
import com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherCardModel;
import com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherReturnContext;
import com.stepos.ailauncher.foundation.credential.api.AuthSessionDto;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\t\b \u0018\u0000 \u008a\u00012\u00020\u0001:\u0004\u008b\u0001\u008c\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0017\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0018\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0019\u0010\u0016J\u000f\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u001fH\u0002¢\u0006\u0004\b\"\u0010#J\u0019\u0010%\u001a\u0004\u0018\u00010\u00062\u0006\u0010$\u001a\u00020\u001aH\u0002¢\u0006\u0004\b%\u0010&J\u0019\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010'\u001a\u00020\u0002H\u0002¢\u0006\u0004\b)\u0010*J)\u0010.\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010+\u001a\u00020\u001d2\b\u0010-\u001a\u0004\u0018\u00010,H\u0002¢\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b0\u0010\u0016J/\u00105\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u00102\u001a\u0002012\u0006\u0010+\u001a\u00020\u001d2\u0006\u00104\u001a\u000203H\u0002¢\u0006\u0004\b5\u00106J\u0017\u00107\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b7\u0010\u0016J\u0017\u00108\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b8\u0010\u0016J\u0019\u0010:\u001a\u00020\u000e2\b\u00109\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\u001dH\u0002¢\u0006\u0004\b<\u0010=J\u0017\u0010@\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020>H$¢\u0006\u0004\b@\u0010AJ\u000f\u0010B\u001a\u00020\u001fH$¢\u0006\u0004\bB\u0010#J\u0017\u0010C\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0013H$¢\u0006\u0004\bC\u0010\u0016J\u0011\u0010E\u001a\u0004\u0018\u00010DH$¢\u0006\u0004\bE\u0010FJ\u0011\u0010G\u001a\u0004\u0018\u00010DH\u0014¢\u0006\u0004\bG\u0010FJ\u0011\u0010I\u001a\u0004\u0018\u00010HH$¢\u0006\u0004\bI\u0010JJ\u0011\u0010K\u001a\u0004\u0018\u00010DH$¢\u0006\u0004\bK\u0010FJ\u000f\u0010L\u001a\u00020\u000eH\u0014¢\u0006\u0004\bL\u0010\u0012J\u001f\u0010O\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010N\u001a\u00020MH\u0014¢\u0006\u0004\bO\u0010PJ\u001b\u0010R\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d0QH\u0014¢\u0006\u0004\bR\u0010SJ\u000f\u0010T\u001a\u00020\u000eH\u0014¢\u0006\u0004\bT\u0010\u0012J\u0017\u0010U\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020>H\u0004¢\u0006\u0004\bU\u0010AJ\u0017\u0010W\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020VH\u0004¢\u0006\u0004\bW\u0010XJ!\u0010[\u001a\u00020\u000e2\u0006\u0010Z\u001a\u00020Y2\b\u0010\u0014\u001a\u0004\u0018\u00010VH\u0004¢\u0006\u0004\b[\u0010\\J\u0017\u0010]\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0013H\u0014¢\u0006\u0004\b]\u0010\u0016J\u0017\u0010^\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0013H$¢\u0006\u0004\b^\u0010\u0016J\u0017\u0010_\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0013H\u0004¢\u0006\u0004\b_\u0010\u0016J\u0017\u0010`\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0013H\u0004¢\u0006\u0004\b`\u0010\u0016J%\u0010c\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010b\u001a\b\u0012\u0004\u0012\u00020\u000e0aH\u0004¢\u0006\u0004\bc\u0010dJ\u0017\u0010e\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0013H\u0004¢\u0006\u0004\be\u0010\u0016J\u0017\u0010g\u001a\u00020\u000e2\u0006\u0010f\u001a\u00020\u001dH\u0004¢\u0006\u0004\bg\u0010;J\u000f\u0010h\u001a\u00020\u000eH\u0014¢\u0006\u0004\bh\u0010\u0012J\u0017\u0010j\u001a\u00020\u000e2\u0006\u0010i\u001a\u00020\u001fH\u0016¢\u0006\u0004\bj\u0010kJ\u000f\u0010l\u001a\u00020\u000eH\u0014¢\u0006\u0004\bl\u0010\u0012J!\u0010n\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020H2\b\u0010m\u001a\u0004\u0018\u00010\u001dH\u0004¢\u0006\u0004\bn\u0010oR\u001a\u0010p\u001a\u00020\u001f8\u0014X\u0094D¢\u0006\f\n\u0004\bp\u0010q\u001a\u0004\br\u0010#R(\u0010s\u001a\u0004\u0018\u00010\u00132\b\u0010'\u001a\u0004\u0018\u00010\u00138\u0004@BX\u0084\u000e¢\u0006\f\n\u0004\bs\u0010t\u001a\u0004\bu\u0010vR$\u0010w\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u00068\u0004@BX\u0084\u000e¢\u0006\f\n\u0004\bw\u0010x\u001a\u0004\by\u0010zR$\u0010{\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u001f8\u0004@BX\u0084\u000e¢\u0006\f\n\u0004\b{\u0010q\u001a\u0004\b|\u0010#R\u0016\u0010}\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010~R\u0018\u0010\u007f\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u007f\u0010~R\u001b\u0010\u0080\u0001\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u001a\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0082\u0001\u0010~R\u0019\u00104\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b4\u0010\u0083\u0001R\u001c\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0084\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R\u001c\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0084\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0086\u0001R\u001c\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0084\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0086\u0001R\u0018\u0010\u0089\u0001\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0089\u0001\u0010q¨\u0006\u008d\u0001"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/AppAutherBaseCardView;", "LN5/d;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lcom/stepos/agentframework/chatui/appui/BaseAppUIHostView;", "t0", "()Lcom/stepos/agentframework/chatui/appui/BaseAppUIHostView;", "next", "LY8/t;", "setPhase", "(I)V", "l0", "()V", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/k;", AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, "m0", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/k;)V", "o0", "Z0", "O0", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/AppAutherReturnContext$ReturnTarget;", "M0", "()Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/AppAutherReturnContext$ReturnTarget;", "", "resourceName", "", "v0", "(Ljava/lang/String;)Z", "u0", "()Z", "target", "K0", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/AppAutherReturnContext$ReturnTarget;)Ljava/lang/Integer;", UxipConstants.f30680s, "Landroid/app/Activity;", ExifInterface.LATITUDE_SOUTH, "(Landroid/content/Context;)Landroid/app/Activity;", "pollPath", "", "intervalMs", "T0", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/k;Ljava/lang/String;Ljava/lang/Long;)V", "G0", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/AppAutherBaseCardView$b;", AuthSessionDto.STATUS_PENDING, "LUa/M;", "scope", "R0", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/k;Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/AppAutherBaseCardView$b;Ljava/lang/String;LUa/M;)V", "I0", "B0", "status", "Y0", "(Ljava/lang/String;)V", "L0", "()Ljava/lang/String;", "Landroid/widget/FrameLayout;", "container", "w0", "(Landroid/widget/FrameLayout;)V", "x0", "J0", "Landroid/widget/TextView;", "F0", "()Landroid/widget/TextView;", "N0", "Landroid/widget/ImageView;", "V0", "()Landroid/widget/ImageView;", "W0", "C0", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/k$a;", "action", "z0", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/k;Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/k$a;)Ljava/lang/String;", "", "H0", "()Ljava/util/Map;", "q0", ExifInterface.LONGITUDE_EAST, "LN5/n;", "C", "(LN5/n;)V", "LN5/i;", "envelope", "D", "(LN5/i;LN5/n;)V", "E0", "D0", "Q0", "r0", "Lkotlin/Function0;", "onJumped", "y0", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/k;Lp9/a;)V", "X0", "message", "s0", "onAttachedToWindow", "isVisible", "onVisibilityAggregated", "(Z)V", "onDetachedFromWindow", "url", "A0", "(Landroid/widget/ImageView;Ljava/lang/String;)V", "hidesCommonChrome", "Z", "getHidesCommonChrome", "lastModel", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/k;", "getLastModel", "()Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/k;", "phase", "I", "getPhase", "()I", "attemptedAuth", "getAttemptedAuth", "analyticsAuthStatus", "Ljava/lang/String;", "boundFingerprint", "pendingSession", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/AppAutherBaseCardView$b;", "initialStatusQueriedFor", "LUa/M;", "Lkotlinx/coroutines/g;", "pollJob", "Lkotlinx/coroutines/g;", "recheckJob", "a2aStatusJob", "isShowingInConversation", "Companion", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class AppAutherBaseCardView extends N5.d {
    private static final long A2A_STATUS_INTERVAL_MS = 2000;
    private static final long A2A_STATUS_TIMEOUT_MS = 900000;
    protected static final a Companion = new a(null);
    public static final String ERR_EMPTY_KEY = "请先填写授权密匙";
    public static final String ERR_JUMP_FAILED = "无法打开授权页面，请稍后重试";
    public static final String ERR_NO_AUTH_URL = "未获取到授权地址，请稍后重试";
    public static final int ICON_CORNER_DP = 12;
    private static final int MAX_HOST_PARENT_DEPTH = 12;
    private kotlinx.coroutines.g a2aStatusJob;
    private String analyticsAuthStatus;
    private boolean attemptedAuth;
    private String boundFingerprint;
    private final boolean hidesCommonChrome;
    private String initialStatusQueriedFor;
    private boolean isShowingInConversation;
    private AppAutherCardModel lastModel;
    private PendingSession pendingSession;
    private int phase;
    private kotlinx.coroutines.g pollJob;
    private kotlinx.coroutines.g recheckJob;
    private Ua.M scope;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0084\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/AppAutherBaseCardView$a;", "", "<init>", "()V", "", "ICON_CORNER_DP", "I", "", "ERR_EMPTY_KEY", "Ljava/lang/String;", "ERR_JUMP_FAILED", "ERR_NO_AUTH_URL", "", "A2A_STATUS_INTERVAL_MS", "J", "A2A_STATUS_TIMEOUT_MS", "MAX_HOST_PARENT_DEPTH", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0082\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\tR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/AppAutherBaseCardView$b;", "", "", "pollPath", "", "intervalMs", "<init>", "(Ljava/lang/String;Ljava/lang/Long;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/Long;", Const.INTENT_KEY_APIKEY, "()Ljava/lang/Long;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherBaseCardView$b, reason: from toString */
    public static final /* data */ class PendingSession {
        private final Long intervalMs;
        private final String pollPath;

        public PendingSession(String str, Long l10) {
            this.pollPath = str;
            this.intervalMs = l10;
        }

        /* renamed from: a, reason: from getter */
        public final Long getIntervalMs() {
            return this.intervalMs;
        }

        /* renamed from: b, reason: from getter */
        public final String getPollPath() {
            return this.pollPath;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PendingSession)) {
                return false;
            }
            PendingSession pendingSession = (PendingSession) other;
            return kotlin.jvm.internal.p.d(this.pollPath, pendingSession.pollPath) && kotlin.jvm.internal.p.d(this.intervalMs, pendingSession.intervalMs);
        }

        public int hashCode() {
            String str = this.pollPath;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            Long l10 = this.intervalMs;
            return iHashCode + (l10 != null ? l10.hashCode() : 0);
        }

        public String toString() {
            return "PendingSession(pollPath=" + this.pollPath + ", intervalMs=" + this.intervalMs + ")";
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppAutherBaseCardView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        this.hidesCommonChrome = true;
        this.analyticsAuthStatus = M5.b.AUTH_STATUS_UNAUTHORIZED;
    }

    public static final Y8.t P0(AppAutherBaseCardView appAutherBaseCardView, kotlinx.coroutines.g gVar, Throwable th) {
        if (appAutherBaseCardView.a2aStatusJob == gVar) {
            appAutherBaseCardView.a2aStatusJob = null;
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t S0(AppAutherBaseCardView appAutherBaseCardView, kotlinx.coroutines.g gVar, Throwable th) {
        if (appAutherBaseCardView.recheckJob == gVar) {
            appAutherBaseCardView.recheckJob = null;
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t U0(AppAutherBaseCardView appAutherBaseCardView, kotlinx.coroutines.g gVar, Throwable th) {
        if (appAutherBaseCardView.pollJob == gVar) {
            appAutherBaseCardView.pollJob = null;
        }
        return Y8.t.f7040a;
    }

    public static final void n0(AppAutherCardModel appAutherCardModel, AppAutherBaseCardView appAutherBaseCardView, AppAutherCardModel.ActionItem actionItem, View view) {
        M5.b.INSTANCE.c(appAutherCardModel, appAutherBaseCardView.L0(), actionItem.getKind());
        appAutherBaseCardView.D0(appAutherCardModel);
    }

    public static final void p0(AppAutherCardModel appAutherCardModel, AppAutherBaseCardView appAutherBaseCardView, AppAutherCardModel.ActionItem actionItem, View view) {
        M5.b.INSTANCE.c(appAutherCardModel, appAutherBaseCardView.L0(), actionItem.getKind());
        appAutherBaseCardView.E0(appAutherCardModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setPhase(int next) {
        this.phase = next;
        AppAutherCardModel appAutherCardModel = this.lastModel;
        if (appAutherCardModel == null) {
            return;
        }
        l0();
        J0(appAutherCardModel);
        m0(appAutherCardModel);
    }

    private final BaseAppUIHostView t0() {
        ViewParent parent = getParent();
        for (int i10 = 0; i10 < 12; i10++) {
            if (parent instanceof BaseAppUIHostView) {
                return (BaseAppUIHostView) parent;
            }
            if (parent == null) {
                parent = null;
            }
            parent = parent != null ? parent.getParent() : null;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0067 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A0(android.widget.ImageView r24, java.lang.String r25) {
        /*
            r23 = this;
            r1 = r24
            java.lang.String r0 = "target"
            kotlin.jvm.internal.p.i(r1, r0)
            int r4 = com.stepos.ailauncher.foundation.R$drawable.ic_card_auther_app_placeholder
            if (r25 == 0) goto L12
            int r0 = r25.length()
            if (r0 != 0) goto L15
        L12:
            r8 = r4
            goto L9e
        L15:
            kotlin.Result$a r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L55
            com.stepos.ailauncher.common.imageloader.g r0 = com.stepos.ailauncher.common.imageloader.g.INSTANCE     // Catch: java.lang.Throwable -> L55
            com.stepos.ailauncher.common.imageloader.i r2 = new com.stepos.ailauncher.common.imageloader.i     // Catch: java.lang.Throwable -> L55
            r21 = 262104(0x3ffd8, float:3.67286E-40)
            r22 = 0
            r6 = 0
            r7 = 0
            r8 = 12
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r5 = r4
            r3 = r25
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)     // Catch: java.lang.Throwable -> L55
            r8 = r4
            android.content.Context r3 = r23.getContext()     // Catch: java.lang.Throwable -> L53
            android.content.Context r5 = r3.getApplicationContext()     // Catch: java.lang.Throwable -> L53
            r6 = 12
            r7 = 0
            r3 = 0
            r4 = 0
            com.stepos.ailauncher.common.imageloader.g.s(r0, r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L53
            Y8.t r0 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L53
            java.lang.Object r0 = kotlin.Result.b(r0)     // Catch: java.lang.Throwable -> L53
            goto L61
        L53:
            r0 = move-exception
            goto L57
        L55:
            r0 = move-exception
            r8 = r4
        L57:
            kotlin.Result$a r2 = kotlin.Result.INSTANCE
            java.lang.Object r0 = kotlin.C4849c.a(r0)
            java.lang.Object r0 = kotlin.Result.b(r0)
        L61:
            java.lang.Throwable r2 = kotlin.Result.e(r0)
            if (r2 == 0) goto L9d
            r1.setImageResource(r8)     // Catch: java.lang.Throwable -> L70
            Y8.t r0 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L70
            kotlin.Result.b(r0)     // Catch: java.lang.Throwable -> L70
            goto L7a
        L70:
            r0 = move-exception
            kotlin.Result$a r1 = kotlin.Result.INSTANCE
            java.lang.Object r0 = kotlin.C4849c.a(r0)
            kotlin.Result.b(r0)
        L7a:
            R5.b r0 = R5.b.INSTANCE
            java.lang.Class r1 = r2.getClass()
            java.lang.String r1 = r1.getSimpleName()
            java.lang.String r3 = "exception"
            kotlin.Pair r1 = Y8.j.a(r3, r1)
            java.lang.String r3 = "message"
            java.lang.String r2 = r2.getMessage()
            kotlin.Pair r2 = Y8.j.a(r3, r2)
            kotlin.Pair[] r1 = new kotlin.Pair[]{r1, r2}
            java.lang.String r2 = "auther.image.fail"
            r0.h(r2, r1)
        L9d:
            return
        L9e:
            kotlin.Result$a r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> Lab
            com.stepos.ailauncher.common.imageloader.g r0 = com.stepos.ailauncher.common.imageloader.g.INSTANCE     // Catch: java.lang.Throwable -> Lab
            r0.l(r1)     // Catch: java.lang.Throwable -> Lab
            Y8.t r0 = Y8.t.f7040a     // Catch: java.lang.Throwable -> Lab
            kotlin.Result.b(r0)     // Catch: java.lang.Throwable -> Lab
            goto Lb5
        Lab:
            r0 = move-exception
            kotlin.Result$a r2 = kotlin.Result.INSTANCE
            java.lang.Object r0 = kotlin.C4849c.a(r0)
            kotlin.Result.b(r0)
        Lb5:
            r1.setImageResource(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherBaseCardView.A0(android.widget.ImageView, java.lang.String):void");
    }

    public final void B0(AppAutherCardModel model) {
        kotlinx.coroutines.g gVar = this.pollJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        kotlinx.coroutines.g gVar2 = this.a2aStatusJob;
        if (gVar2 != null) {
            kotlinx.coroutines.g.Y0(gVar2, null, 1, null);
        }
        this.a2aStatusJob = null;
        this.pendingSession = null;
        this.attemptedAuth = false;
        this.analyticsAuthStatus = "authorized";
        setPhase(2);
        R5.b.INSTANCE.c("auther.authorized", Y8.j.a("taskId", model.getCardId()), Y8.j.a("mode", model.getMode()));
    }

    @Override // N5.d
    public final void C(N5.n model) {
        kotlin.jvm.internal.p.i(model, "model");
        if ((model instanceof AppAutherCardModel) && x0()) {
            AppAutherCardModel appAutherCardModel = (AppAutherCardModel) model;
            String str = appAutherCardModel.getCardId() + "|" + appAutherCardModel.getVendorId();
            if (!kotlin.jvm.internal.p.d(str, this.boundFingerprint)) {
                this.boundFingerprint = str;
                this.phase = 0;
                this.attemptedAuth = false;
                this.analyticsAuthStatus = M5.b.AUTH_STATUS_UNAUTHORIZED;
                this.pendingSession = null;
                kotlinx.coroutines.g gVar = this.pollJob;
                if (gVar != null) {
                    kotlinx.coroutines.g.Y0(gVar, null, 1, null);
                }
                this.pollJob = null;
                kotlinx.coroutines.g gVar2 = this.recheckJob;
                if (gVar2 != null) {
                    kotlinx.coroutines.g.Y0(gVar2, null, 1, null);
                }
                this.recheckJob = null;
                kotlinx.coroutines.g gVar3 = this.a2aStatusJob;
                if (gVar3 != null) {
                    kotlinx.coroutines.g.Y0(gVar3, null, 1, null);
                }
                this.a2aStatusJob = null;
                this.initialStatusQueriedFor = null;
                C0();
            }
            this.lastModel = appAutherCardModel;
            J0(appAutherCardModel);
            l0();
            m0(appAutherCardModel);
        }
    }

    public void C0() {
    }

    @Override // N5.d
    public final void D(CardEnvelope envelope, N5.n model) {
        kotlin.jvm.internal.p.i(envelope, "envelope");
        AppAutherCardModel appAutherCardModel = model instanceof AppAutherCardModel ? (AppAutherCardModel) model : null;
        if (appAutherCardModel == null) {
            return;
        }
        M5.b.INSTANCE.f(appAutherCardModel, L0(), this.analyticsAuthStatus);
    }

    public abstract void D0(AppAutherCardModel model);

    @Override // N5.d
    public final void E(FrameLayout container) {
        kotlin.jvm.internal.p.i(container, "container");
        w0(container);
    }

    public void E0(AppAutherCardModel model) {
        kotlin.jvm.internal.p.i(model, "model");
    }

    public abstract TextView F0();

    public final void G0(AppAutherCardModel model) {
        String vendorId;
        if (model.x()) {
            O0(model);
            return;
        }
        Ua.M m10 = this.scope;
        if (m10 == null || (vendorId = model.getVendorId()) == null || kotlin.jvm.internal.p.d(this.initialStatusQueriedFor, this.boundFingerprint)) {
            return;
        }
        this.initialStatusQueriedFor = this.boundFingerprint;
        C1060i.d(m10, null, null, new AppAutherBaseCardView$queryInitialStatus$1(vendorId, model, this, null), 3, null);
    }

    public Map<String, String> H0() {
        return kotlin.collections.a.i();
    }

    public final void I0(AppAutherCardModel model) {
        PendingSession pendingSession;
        Ua.M m10 = this.scope;
        if (m10 == null) {
            return;
        }
        kotlinx.coroutines.g gVar = this.recheckJob;
        if ((gVar == null || !gVar.b()) && (pendingSession = this.pendingSession) != null) {
            String pollPath = pendingSession.getPollPath();
            if (pollPath != null) {
                R0(model, pendingSession, pollPath, m10);
                return;
            }
            String vendorId = model.getVendorId();
            if (vendorId == null) {
                return;
            }
            C1060i.d(m10, null, null, new AppAutherBaseCardView$recheckOnReturn$1(vendorId, model, this, null), 3, null);
        }
    }

    public abstract void J0(AppAutherCardModel model);

    public final Integer K0(AppAutherReturnContext.ReturnTarget target) {
        if (target != AppAutherReturnContext.ReturnTarget.ACTIVITY) {
            return null;
        }
        View view = this;
        while (view != null) {
            Context context = view.getContext();
            kotlin.jvm.internal.p.h(context, "getContext(...)");
            Activity activityS = S(context);
            Integer numValueOf = activityS != null ? Integer.valueOf(activityS.getTaskId()) : null;
            if (numValueOf != null && numValueOf.intValue() > 0) {
                return numValueOf;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return null;
    }

    public final String L0() {
        String requestSessionId;
        String sessionId;
        String chatSessionId;
        BaseAppUIHostView baseAppUIHostViewT0 = t0();
        String str = null;
        if (baseAppUIHostViewT0 != null && (chatSessionId = baseAppUIHostViewT0.getChatSessionId()) != null) {
            if (La.H.x0(chatSessionId)) {
                chatSessionId = null;
            }
            if (chatSessionId != null) {
                return chatSessionId;
            }
        }
        if (baseAppUIHostViewT0 == null || (requestSessionId = baseAppUIHostViewT0.getRequestSessionId()) == null || La.H.x0(requestSessionId)) {
            requestSessionId = null;
        }
        if (requestSessionId != null) {
            return requestSessionId;
        }
        CardEnvelope boundEnvelope = getBoundEnvelope();
        if (boundEnvelope != null && (sessionId = boundEnvelope.getSessionId()) != null && !La.H.x0(sessionId)) {
            str = sessionId;
        }
        return str == null ? "" : str;
    }

    public final AppAutherReturnContext.ReturnTarget M0() {
        return v0("wake_root") ? AppAutherReturnContext.ReturnTarget.WAKE_DIALOG : (v0("view_pager") || v0("view_pager_wrapper")) ? AppAutherReturnContext.ReturnTarget.LAUNCHER_OVERLAY : u0() ? AppAutherReturnContext.ReturnTarget.ACTIVITY : AppAutherReturnContext.ReturnTarget.LAUNCHER_OVERLAY;
    }

    public TextView N0() {
        return null;
    }

    public final void O0(AppAutherCardModel model) {
        String statusPath;
        Ua.M m10;
        if (!model.x() || (statusPath = model.getStatusPath()) == null || La.H.x0(statusPath) || (m10 = this.scope) == null) {
            return;
        }
        kotlinx.coroutines.g gVar = this.a2aStatusJob;
        if (gVar == null || !gVar.b()) {
            final kotlinx.coroutines.g gVarD = C1060i.d(m10, null, null, new AppAutherBaseCardView$startA2aStatusRefresh$job$1(this, model, null), 3, null);
            this.a2aStatusJob = gVarD;
            gVarD.J(new InterfaceC5074l() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.appauther.g
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return AppAutherBaseCardView.P0(this.f27355a, gVarD, (Throwable) obj);
                }
            });
        }
    }

    public final void Q0(AppAutherCardModel model) {
        kotlin.jvm.internal.p.i(model, "model");
        Ua.M m10 = this.scope;
        if (m10 == null) {
            return;
        }
        String strL0 = L0();
        setPhase(1);
        C1060i.d(m10, null, null, new AppAutherBaseCardView$startAuthSession$1(model, this, strL0, null), 3, null);
    }

    public final void R0(AppAutherCardModel model, PendingSession pending, String pollPath, Ua.M scope) {
        final kotlinx.coroutines.g gVarD = C1060i.d(scope, null, null, new AppAutherBaseCardView$startImmediateSessionRecheck$job$1(pollPath, this, model, pending, null), 3, null);
        this.recheckJob = gVarD;
        gVarD.J(new InterfaceC5074l() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.appauther.f
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AppAutherBaseCardView.S0(this.f27353a, gVarD, (Throwable) obj);
            }
        });
    }

    public final Activity S(Context value) {
        while (value instanceof ContextWrapper) {
            if (!(value instanceof Activity)) {
                Context baseContext = ((ContextWrapper) value).getBaseContext();
                if (baseContext == value) {
                    break;
                }
                value = baseContext;
            } else {
                return (Activity) value;
            }
        }
        if (value instanceof Activity) {
            return (Activity) value;
        }
        return null;
    }

    public final void T0(AppAutherCardModel model, String pollPath, Long intervalMs) {
        Ua.M m10 = this.scope;
        if (m10 == null) {
            return;
        }
        kotlinx.coroutines.g gVar = this.pollJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        final kotlinx.coroutines.g gVarD = C1060i.d(m10, null, null, new AppAutherBaseCardView$startPolling$job$1(pollPath, intervalMs, this, model, null), 3, null);
        this.pollJob = gVarD;
        gVarD.J(new InterfaceC5074l() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.appauther.h
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AppAutherBaseCardView.U0(this.f27357a, gVarD, (Throwable) obj);
            }
        });
    }

    public abstract ImageView V0();

    public abstract TextView W0();

    public final void X0(AppAutherCardModel model) {
        String vendorId;
        kotlin.jvm.internal.p.i(model, "model");
        Ua.M m10 = this.scope;
        if (m10 == null || (vendorId = model.getVendorId()) == null) {
            return;
        }
        Map<String, String> mapH0 = H0();
        if (!mapH0.isEmpty()) {
            Collection<String> collectionValues = mapH0.values();
            if (!(collectionValues instanceof Collection) || !collectionValues.isEmpty()) {
                Iterator<T> it = collectionValues.iterator();
                while (it.hasNext()) {
                    if (La.H.x0((String) it.next())) {
                    }
                }
            }
            M5.b.INSTANCE.d(model, L0());
            setPhase(1);
            C1060i.d(m10, null, null, new AppAutherBaseCardView$submitCredential$2(vendorId, model, mapH0, this, null), 3, null);
            return;
        }
        s0(ERR_EMPTY_KEY);
    }

    public final void Y0(String status) {
        String str = "authorized";
        if (!La.D.L(status, "authorized", true)) {
            str = "expired";
            if (!La.D.L(status, "expired", true)) {
                str = M5.b.AUTH_STATUS_INVALID;
                if (!La.D.L(status, M5.b.AUTH_STATUS_INVALID, true) && !La.D.L(status, "failed", true)) {
                    str = M5.b.AUTH_STATUS_UNAUTHORIZED;
                }
            }
        }
        this.analyticsAuthStatus = str;
    }

    public final void Z0(AppAutherCardModel model) {
        String statusPath;
        Ua.M m10 = this.scope;
        if (m10 == null || (statusPath = model.getStatusPath()) == null) {
            return;
        }
        C1060i.d(m10, null, null, new AppAutherBaseCardView$verifyA2aStatus$1(statusPath, model, null), 3, null);
    }

    public final boolean getAttemptedAuth() {
        return this.attemptedAuth;
    }

    @Override // N5.d
    public boolean getHidesCommonChrome() {
        return this.hidesCommonChrome;
    }

    public final AppAutherCardModel getLastModel() {
        return this.lastModel;
    }

    public final int getPhase() {
        return this.phase;
    }

    public final void l0() {
        boolean z10 = this.phase == 2;
        int iC = androidx.core.content.a.c(getContext(), z10 ? R$color.card_auther_status_authorized : R$color.card_auther_status_unauthorized);
        TextView textViewW0 = W0();
        if (textViewW0 != null) {
            textViewW0.setText(z10 ? "已授权" : AbstractC3297l.STATUS_UNAUTHORIZED);
            textViewW0.setTextColor(iC);
        }
        ImageView imageViewV0 = V0();
        if (imageViewV0 != null) {
            imageViewV0.setColorFilter(iC);
        }
    }

    public final void m0(final AppAutherCardModel model) {
        TextView textViewF0 = F0();
        if (textViewF0 == null) {
            return;
        }
        final AppAutherCardModel.ActionItem primaryAction = model.getPrimaryAction();
        if (primaryAction == null) {
            textViewF0.setVisibility(8);
            return;
        }
        boolean z10 = false;
        textViewF0.setVisibility(0);
        int i10 = this.phase;
        boolean z11 = i10 == 2;
        boolean z12 = i10 == 1;
        if (!z11 && !z12) {
            z10 = true;
        }
        textViewF0.setText(z11 ? "已授权" : z0(model, primaryAction));
        textViewF0.setEnabled(z10);
        textViewF0.setBackgroundResource(z10 ? primaryAction.getBackgroundRes() : R$drawable.bg_card_auther_cta_disabled);
        textViewF0.setTextColor(androidx.core.content.a.c(getContext(), z10 ? primaryAction.getTextColorRes() : R$color.card_text_secondary));
        textViewF0.setOnClickListener(z10 ? new View.OnClickListener() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.appauther.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppAutherBaseCardView.n0(model, this, primaryAction, view);
            }
        } : null);
        o0(model);
    }

    public final void o0(final AppAutherCardModel model) {
        TextView textViewN0 = N0();
        if (textViewN0 == null) {
            return;
        }
        final AppAutherCardModel.ActionItem secondaryAction = model.getSecondaryAction();
        boolean z10 = (secondaryAction == null || this.phase == 2) ? false : true;
        textViewN0.setVisibility(z10 ? 0 : 8);
        if (!z10 || secondaryAction == null) {
            textViewN0.setOnClickListener(null);
            return;
        }
        textViewN0.setText(secondaryAction.getLabel());
        textViewN0.setBackgroundResource(secondaryAction.getBackgroundRes());
        textViewN0.setTextColor(androidx.core.content.a.c(getContext(), secondaryAction.getTextColorRes()));
        textViewN0.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.appauther.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppAutherBaseCardView.p0(model, this, secondaryAction, view);
            }
        });
    }

    @Override // N5.d, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.scope == null) {
            this.scope = kotlinx.coroutines.d.a(L0.b(null, 1, null).plus(Y.c().getImmediate()));
        }
    }

    @Override // N5.d, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Context context = getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null && (activity.isDestroyed() || activity.isFinishing())) {
            kotlinx.coroutines.g gVar = this.pollJob;
            if (gVar != null) {
                kotlinx.coroutines.g.Y0(gVar, null, 1, null);
            }
            this.pollJob = null;
            kotlinx.coroutines.g gVar2 = this.recheckJob;
            if (gVar2 != null) {
                kotlinx.coroutines.g.Y0(gVar2, null, 1, null);
            }
            this.recheckJob = null;
            kotlinx.coroutines.g gVar3 = this.a2aStatusJob;
            if (gVar3 != null) {
                kotlinx.coroutines.g.Y0(gVar3, null, 1, null);
            }
            this.a2aStatusJob = null;
            Ua.M m10 = this.scope;
            if (m10 != null) {
                kotlinx.coroutines.d.e(m10, null, 1, null);
            }
            this.scope = null;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onVisibilityAggregated(boolean isVisible) {
        super.onVisibilityAggregated(isVisible);
        if (this.isShowingInConversation == isVisible) {
            return;
        }
        this.isShowingInConversation = isVisible;
        AppAutherCardModel appAutherCardModel = this.lastModel;
        if (appAutherCardModel == null) {
            return;
        }
        if (!isVisible) {
            kotlinx.coroutines.g gVar = this.pollJob;
            if (gVar != null) {
                kotlinx.coroutines.g.Y0(gVar, null, 1, null);
            }
            this.pollJob = null;
            kotlinx.coroutines.g gVar2 = this.recheckJob;
            if (gVar2 != null) {
                kotlinx.coroutines.g.Y0(gVar2, null, 1, null);
            }
            this.recheckJob = null;
            kotlinx.coroutines.g gVar3 = this.a2aStatusJob;
            if (gVar3 != null) {
                kotlinx.coroutines.g.Y0(gVar3, null, 1, null);
            }
            this.a2aStatusJob = null;
            R5.b.INSTANCE.c("auther.poll.pause", Y8.j.a("taskId", appAutherCardModel.getCardId()));
            return;
        }
        if (this.phase == 2) {
            return;
        }
        if (appAutherCardModel.x()) {
            O0(appAutherCardModel);
            return;
        }
        kotlinx.coroutines.g gVar4 = this.pollJob;
        if (gVar4 == null || !gVar4.b()) {
            kotlinx.coroutines.g gVar5 = this.recheckJob;
            if (gVar5 == null || !gVar5.b()) {
                if (this.pendingSession == null) {
                    G0(appAutherCardModel);
                } else {
                    R5.b.INSTANCE.c("auther.poll.resume", Y8.j.a("taskId", appAutherCardModel.getCardId()));
                    I0(appAutherCardModel);
                }
            }
        }
    }

    public void q0() {
    }

    public final void r0(AppAutherCardModel model) {
        String completePath;
        kotlin.jvm.internal.p.i(model, "model");
        Ua.M m10 = this.scope;
        if (m10 == null || (completePath = model.getCompletePath()) == null) {
            return;
        }
        kotlinx.coroutines.g gVar = this.a2aStatusJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        this.a2aStatusJob = null;
        setPhase(1);
        C1060i.d(m10, null, null, new AppAutherBaseCardView$completeA2aConsent$1(completePath, model, this, null), 3, null);
    }

    public final void s0(String message) {
        String cardId;
        kotlin.jvm.internal.p.i(message, "message");
        kotlinx.coroutines.g gVar = this.pollJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        setPhase(0);
        try {
            Result.Companion companion = Result.INSTANCE;
            Toast.makeText(getContext(), message, 0).show();
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
        R5.b bVar = R5.b.INSTANCE;
        AppAutherCardModel appAutherCardModel = this.lastModel;
        if (appAutherCardModel == null || (cardId = appAutherCardModel.getCardId()) == null) {
            cardId = "null";
        }
        bVar.h("auther.fail", Y8.j.a("taskId", cardId), Y8.j.a("message", message));
    }

    public final boolean u0() {
        View view = this;
        while (view != null) {
            Context context = view.getContext();
            kotlin.jvm.internal.p.h(context, "getContext(...)");
            if (S(context) != null) {
                return true;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherBaseCardView] */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r3v5, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    public final boolean v0(String resourceName) {
        Object objB;
        while (this != 0) {
            int id = this.getId();
            if (id != -1) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    objB = Result.b(this.getResources().getResourceEntryName(id));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th));
                }
                if (Result.g(objB)) {
                    objB = null;
                }
                if (kotlin.jvm.internal.p.d((String) objB, resourceName)) {
                    return true;
                }
            }
            Object parent = this.getParent();
            this = parent instanceof View ? (View) parent : 0;
        }
        return false;
    }

    public abstract void w0(FrameLayout container);

    public abstract boolean x0();

    public final void y0(AppAutherCardModel model, InterfaceC5063a<Y8.t> onJumped) {
        String jumpWebLink;
        kotlin.jvm.internal.p.i(model, "model");
        kotlin.jvm.internal.p.i(onJumped, "onJumped");
        String jumpAppLink = model.getJumpAppLink();
        boolean z10 = ((jumpAppLink == null || La.H.x0(jumpAppLink)) && ((jumpWebLink = model.getJumpWebLink()) == null || La.H.x0(jumpWebLink))) ? false : true;
        boolean zG = N5.d.G(this, model.getJumpAppLink(), model.getJumpWebLink(), null, false, false, false, 60, null);
        M5.b.INSTANCE.g(model, L0(), zG, zG ? null : !z10 ? M5.b.FAIL_MISSING_TARGET : M5.b.FAIL_OPEN_TARGET);
        if (zG) {
            onJumped.invoke();
        } else {
            s0(ERR_JUMP_FAILED);
        }
    }

    public String z0(AppAutherCardModel model, AppAutherCardModel.ActionItem action) {
        kotlin.jvm.internal.p.i(model, "model");
        kotlin.jvm.internal.p.i(action, "action");
        return action.getLabel();
    }
}

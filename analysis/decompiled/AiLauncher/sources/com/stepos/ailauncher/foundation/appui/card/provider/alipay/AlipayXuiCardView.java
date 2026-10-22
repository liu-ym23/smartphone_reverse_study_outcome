package com.stepos.ailauncher.foundation.appui.card.provider.alipay;

import T5.C1018b;
import T5.C1019c;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatui.appui.BaseAppUIHostView;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import com.stepos.ailauncher.common.imageloader.ImageRequest;
import com.stepos.ailauncher.contract.api.chat.IChatRoundAbortService;
import com.stepos.ailauncher.foundation.R$drawable;
import com.stepos.ailauncher.foundation.appstore.AppDetailRepository;
import com.stepos.ailauncher.foundation.appstore.api.AppDetail;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiCardModel;
import io.ktor.http.ContentDisposition;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import net.sqlcipher.database.SQLiteDatabase;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0002\u0085\u0001\u0018\u0000 \u008e\u00012\u00020\u0001:\u0002\u008f\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\fH\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0013H\u0000¢\u0006\u0004\b\u001b\u0010\u0017J\u0017\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u0013H\u0000¢\u0006\u0004\b\u001d\u0010\u0017J\u000f\u0010\u001e\u001a\u00020\fH\u0014¢\u0006\u0004\b\u001e\u0010\u0019J\u000f\u0010\u001f\u001a\u00020\fH\u0014¢\u0006\u0004\b\u001f\u0010\u0019J\u000f\u0010 \u001a\u00020\fH\u0002¢\u0006\u0004\b \u0010\u0019J\u0017\u0010\"\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020!H\u0002¢\u0006\u0004\b\"\u0010#J)\u0010*\u001a\u00020\f2\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&2\b\u0010)\u001a\u0004\u0018\u00010(H\u0002¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\fH\u0002¢\u0006\u0004\b,\u0010\u0019J\u0017\u0010-\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020!H\u0002¢\u0006\u0004\b-\u0010#J\u0017\u0010.\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020!H\u0002¢\u0006\u0004\b.\u0010#J\u0017\u0010/\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020!H\u0002¢\u0006\u0004\b/\u0010#J\u0019\u00102\u001a\u00020\f2\b\u00101\u001a\u0004\u0018\u000100H\u0002¢\u0006\u0004\b2\u00103J!\u00106\u001a\u00020\f2\u0006\u00105\u001a\u0002042\b\u00101\u001a\u0004\u0018\u000100H\u0002¢\u0006\u0004\b6\u00107J\u001f\u0010:\u001a\u00020\f2\u0006\u00109\u001a\u0002082\u0006\u00101\u001a\u000200H\u0002¢\u0006\u0004\b:\u0010;J\u0017\u0010<\u001a\u00020\u00152\u0006\u00101\u001a\u000200H\u0002¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\fH\u0002¢\u0006\u0004\b>\u0010\u0019J\u0017\u0010?\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0013H\u0002¢\u0006\u0004\b?\u0010@J\u0011\u0010B\u001a\u0004\u0018\u00010AH\u0002¢\u0006\u0004\bB\u0010CJ\u000f\u0010D\u001a\u00020\fH\u0002¢\u0006\u0004\bD\u0010\u0019J\u0017\u0010F\u001a\u00020\u00152\u0006\u0010E\u001a\u00020\u0013H\u0002¢\u0006\u0004\bF\u0010\u0017J)\u0010K\u001a\u00020\f2\u0006\u0010H\u001a\u00020G2\b\u0010I\u001a\u0004\u0018\u00010\u00132\u0006\u0010J\u001a\u00020\u0006H\u0002¢\u0006\u0004\bK\u0010LJ\u0011\u0010M\u001a\u0004\u0018\u00010$H\u0002¢\u0006\u0004\bM\u0010NJ\u001f\u0010Q\u001a\u00020\f2\u0006\u00109\u001a\u0002082\u0006\u0010P\u001a\u00020OH\u0002¢\u0006\u0004\bQ\u0010RJ3\u0010X\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010S2\u0006\u0010U\u001a\u00020T2\u0012\u0010W\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00028\u00000VH\u0002¢\u0006\u0004\bX\u0010YJ\u0017\u0010Z\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020!H\u0002¢\u0006\u0004\bZ\u0010#J\u0017\u0010\\\u001a\u00020\f2\u0006\u0010[\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\\\u0010@J\u000f\u0010]\u001a\u00020\fH\u0002¢\u0006\u0004\b]\u0010\u0019J\u000f\u0010^\u001a\u00020\fH\u0002¢\u0006\u0004\b^\u0010\u0019J\u000f\u0010_\u001a\u00020\fH\u0002¢\u0006\u0004\b_\u0010\u0019J\u000f\u0010`\u001a\u00020\fH\u0002¢\u0006\u0004\b`\u0010\u0019J\u000f\u0010a\u001a\u00020\u0015H\u0002¢\u0006\u0004\ba\u0010bJ\u000f\u0010c\u001a\u00020\u0015H\u0002¢\u0006\u0004\bc\u0010bJ\u0011\u0010e\u001a\u0004\u0018\u00010dH\u0002¢\u0006\u0004\be\u0010fJ\u0017\u0010h\u001a\u00020\f2\u0006\u0010g\u001a\u00020\u0013H\u0002¢\u0006\u0004\bh\u0010@J\u000f\u0010i\u001a\u00020\fH\u0002¢\u0006\u0004\bi\u0010\u0019J\u000f\u0010j\u001a\u00020\fH\u0002¢\u0006\u0004\bj\u0010\u0019J\u000f\u0010k\u001a\u00020\fH\u0002¢\u0006\u0004\bk\u0010\u0019J\u000f\u0010l\u001a\u00020\fH\u0002¢\u0006\u0004\bl\u0010\u0019J\u000f\u0010m\u001a\u00020\fH\u0002¢\u0006\u0004\bm\u0010\u0019J\u000f\u0010n\u001a\u00020\fH\u0002¢\u0006\u0004\bn\u0010\u0019R\u0016\u0010p\u001a\u00020o8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bp\u0010qR\u0018\u0010r\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010sR\u0018\u0010t\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010uR\u0016\u0010v\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010wR\u0018\u0010x\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010yR\u0018\u0010{\u001a\u0004\u0018\u00010z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010|R\u0016\u0010}\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010wR\u0015\u0010\u007f\u001a\u00020~8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u001d\u0010\u0081\u0001\u001a\u00020\u00158\u0014X\u0094D¢\u0006\u000e\n\u0005\b\u0081\u0001\u0010w\u001a\u0005\b\u0082\u0001\u0010bR\u001d\u0010\u0083\u0001\u001a\u00020\u00158\u0014X\u0094D¢\u0006\u000e\n\u0005\b\u0083\u0001\u0010w\u001a\u0005\b\u0084\u0001\u0010bR\u0018\u0010\u0086\u0001\u001a\u00030\u0085\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R\u0018\u0010\u0088\u0001\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0088\u0001\u0010wR\u001e\u0010\u008a\u0001\u001a\t\u0012\u0004\u0012\u00020\f0\u0089\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\u001b\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001¨\u0006\u0090\u0001"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiCardView;", "LN5/d;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/widget/FrameLayout;", "container", "LY8/t;", ExifInterface.LONGITUDE_EAST, "(Landroid/widget/FrameLayout;)V", "LN5/n;", AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, "C", "(LN5/n;)V", "", "title", "", "f0", "(Ljava/lang/String;)Z", "J0", "()V", "taskId", "E0", AlipayXuiLiveClickReceiver.EXTRA_APP_LINK, "L0", "onAttachedToWindow", "onDetachedFromWindow", "x0", "Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/w;", "l0", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/w;)V", "LT5/b;", "block", "Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/w$b;", "app", "Lcom/stepos/ailauncher/foundation/appstore/api/AppDetail;", "detail", "e0", "(LT5/b;Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/w$b;Lcom/stepos/ailauncher/foundation/appstore/api/AppDetail;)V", "t0", "m0", "p0", "n0", "Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/w$a;", "action", "i0", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/w$a;)V", "Landroid/widget/TextView;", "button", "g0", "(Landroid/widget/TextView;Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/w$a;)V", "Landroid/view/View;", "view", "j0", "(Landroid/view/View;Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/w$a;)V", "C0", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/w$a;)Z", "O0", "a0", "(Ljava/lang/String;)V", "Lcom/stepos/agentframework/chatui/appui/BaseAppUIHostView;", "w0", "()Lcom/stepos/agentframework/chatui/appui/BaseAppUIHostView;", "h0", "pkg", "F0", "Landroid/widget/ImageView;", "target", "url", "placeholder", "G0", "(Landroid/widget/ImageView;Ljava/lang/String;I)V", "d0", "()LT5/b;", "", "radiusDp", "q0", "(Landroid/view/View;F)V", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/ViewStub;", "stub", "Lkotlin/Function1;", "bind", "z0", "(Landroid/view/ViewStub;Lp9/l;)Ljava/lang/Object;", "R0", "cardId", "r0", "P0", "T0", "H0", "K0", "D0", "()Z", "y0", "Landroid/app/Activity;", "v0", "()Landroid/app/Activity;", "reason", "b0", "s0", "Q0", "o0", "N0", "S0", "M0", "LT5/c;", "xui", "LT5/c;", "appStore", "LT5/b;", "lastModel", "Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/w;", "dimmed", "Z", "autoJumpTaskId", "Ljava/lang/String;", "Landroid/view/ViewTreeObserver$OnDrawListener;", "autoJumpDrawListener", "Landroid/view/ViewTreeObserver$OnDrawListener;", "autoJumpVisiblePosted", "Landroid/graphics/Rect;", "autoJumpVisibleRect", "Landroid/graphics/Rect;", "hidesCommonChrome", "getHidesCommonChrome", "showsChannelLogo", "getShowsChannelLogo", "com/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiCardView$c", "packageReceiver", "Lcom/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiCardView$c;", "receiverRegistered", "Lkotlin/Function0;", "installObserver", "Lp9/a;", "lastDimmedStatus", "Ljava/lang/Integer;", "Companion", Const.INTENT_KEY_APIKEY, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AlipayXuiCardView extends N5.d {
    private static final float AUTH_ICON_RADIUS_DP = 8.0f;
    private static final float INSTALL_ICON_RADIUS_DP = 12.0f;
    private C1018b appStore;
    private ViewTreeObserver.OnDrawListener autoJumpDrawListener;
    private String autoJumpTaskId;
    private boolean autoJumpVisiblePosted;
    private final Rect autoJumpVisibleRect;
    private boolean dimmed;
    private final boolean hidesCommonChrome;
    private final InterfaceC5063a<Y8.t> installObserver;
    private Integer lastDimmedStatus;
    private AlipayXuiCardModel lastModel;
    private final c packageReceiver;
    private boolean receiverRegistered;
    private final boolean showsChannelLogo;
    private C1019c xui;
    private static final boolean JUMP_VIA_PERFBINDER = true;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiCardView$b", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "LY8/t;", "getOutline", "(Landroid/view/View;Landroid/graphics/Outline;)V", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends ViewOutlineProvider {
        final /* synthetic */ float $radiusPx;

        public b(float f10) {
            this.$radiusPx = f10;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            kotlin.jvm.internal.p.i(view, "view");
            kotlin.jvm.internal.p.i(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.$radiusPx);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/foundation/appui/card/provider/alipay/AlipayXuiCardView$c", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "LY8/t;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c extends BroadcastReceiver {
        public c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Uri data;
            String schemeSpecificPart;
            if (intent == null || (data = intent.getData()) == null || (schemeSpecificPart = data.getSchemeSpecificPart()) == null || !kotlin.jvm.internal.p.d(schemeSpecificPart, C3236a.PKG_ALIPAY)) {
                return;
            }
            R5.b.INSTANCE.c("alipay.install.event", Y8.j.a("action", intent.getAction()), Y8.j.a("pkg", schemeSpecificPart));
            if (kotlin.jvm.internal.p.d(intent.getAction(), "android.intent.action.PACKAGE_REMOVED")) {
                C3245j.INSTANCE.b();
            }
            AlipayXuiCardView.this.M0();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlipayXuiCardView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        this.autoJumpVisibleRect = new Rect();
        this.hidesCommonChrome = true;
        this.packageReceiver = new c();
        this.installObserver = new InterfaceC5063a() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.alipay.D
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return AlipayXuiCardView.A0(this.f27168a);
            }
        };
    }

    public static final Y8.t A0(final AlipayXuiCardView alipayXuiCardView) {
        alipayXuiCardView.post(new Runnable() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.alipay.x
            @Override // java.lang.Runnable
            public final void run() {
                AlipayXuiCardView.B0(this.f27182a);
            }
        });
        return Y8.t.f7040a;
    }

    public static final void B0(AlipayXuiCardView alipayXuiCardView) {
        alipayXuiCardView.M0();
    }

    public static final void I0(AlipayXuiCardView alipayXuiCardView) {
        alipayXuiCardView.K0();
    }

    public static final void U0(AlipayXuiCardView alipayXuiCardView) {
        alipayXuiCardView.H0();
    }

    public static final void V0(AlipayXuiCardView alipayXuiCardView) {
        alipayXuiCardView.H0();
    }

    public static final void k0(AlipayXuiCardView alipayXuiCardView, AlipayXuiCardModel.ActionItem actionItem, View view) {
        String launchPackage;
        if (alipayXuiCardView.dimmed) {
            return;
        }
        R5.b bVar = R5.b.INSTANCE;
        Pair pairA = Y8.j.a("label", actionItem.getLabel());
        Pair pairA2 = Y8.j.a("localDim", Boolean.valueOf(actionItem.getLocalDim()));
        Pair pairA3 = Y8.j.a("launchPkg", actionItem.getLaunchPackage());
        Pair pairA4 = Y8.j.a(AlipayXuiLiveClickReceiver.EXTRA_APP_LINK, actionItem.getAppLink());
        AlipayXuiCardModel alipayXuiCardModel = alipayXuiCardView.lastModel;
        bVar.c("alipay.click", pairA, pairA2, pairA3, pairA4, Y8.j.a("status", alipayXuiCardModel != null ? Integer.valueOf(alipayXuiCardModel.getStatus()) : null));
        if (alipayXuiCardView.C0(actionItem)) {
            alipayXuiCardView.O0();
            return;
        }
        AlipayXuiCardModel alipayXuiCardModel2 = alipayXuiCardView.lastModel;
        String str = C3236a.PKG_ALIPAY;
        if (alipayXuiCardModel2 != null && alipayXuiCardModel2.getStatus() == 1) {
            C3245j c3245j = C3245j.INSTANCE;
            Context context = alipayXuiCardView.getContext();
            AlipayXuiCardModel alipayXuiCardModel3 = alipayXuiCardView.lastModel;
            if (kotlin.jvm.internal.p.d(c3245j.j(context, alipayXuiCardModel3 != null ? alipayXuiCardModel3.getBackendInstallState() : null), "installed")) {
                String launchPackage2 = actionItem.getLaunchPackage();
                if (launchPackage2 != null) {
                    str = launchPackage2;
                }
                if (alipayXuiCardView.F0(str)) {
                    return;
                }
                bVar.h("alipay.click.noJump", Y8.j.a("label", actionItem.getLabel()), Y8.j.a("launchPkg", str));
                return;
            }
            c3245j.e();
            alipayXuiCardView.M0();
            boolean zG = N5.d.G(alipayXuiCardView, actionItem.getAppLink(), actionItem.getWebLink(), actionItem.getIntentPackage(), false, false, false, 56, null);
            if (!zG && (launchPackage = actionItem.getLaunchPackage()) != null && launchPackage.length() != 0) {
                String launchPackage3 = actionItem.getLaunchPackage();
                kotlin.jvm.internal.p.f(launchPackage3);
                alipayXuiCardView.F0(launchPackage3);
            }
            if (zG) {
                return;
            }
            String launchPackage4 = actionItem.getLaunchPackage();
            if (launchPackage4 == null || launchPackage4.length() == 0) {
                bVar.h("alipay.click.noJump", Y8.j.a("label", actionItem.getLabel()), Y8.j.a(AlipayXuiLiveClickReceiver.EXTRA_APP_LINK, actionItem.getAppLink()));
                return;
            }
            return;
        }
        if (JUMP_VIA_PERFBINDER) {
            String strD = N5.j.INSTANCE.d(actionItem.getAppLink());
            if (strD != null) {
                boolean zG2 = N5.d.G(alipayXuiCardView, strD, null, actionItem.getIntentPackage(), false, false, false, 56, null);
                if (zG2 && actionItem.getArmAuthResume()) {
                    C3237b.INSTANCE.a();
                }
                if (zG2) {
                    return;
                }
                bVar.h("alipay.click.noJump", Y8.j.a("label", actionItem.getLabel()), Y8.j.a(AlipayXuiLiveClickReceiver.EXTRA_APP_LINK, strD));
                return;
            }
            AlipayXuiCardModel alipayXuiCardModel4 = alipayXuiCardView.lastModel;
            String cardId = alipayXuiCardModel4 != null ? alipayXuiCardModel4.getCardId() : null;
            if (cardId == null) {
                cardId = "";
            }
            boolean zI = v.INSTANCE.i(cardId);
            if (zI && actionItem.getArmAuthResume()) {
                C3237b.INSTANCE.a();
            }
            if (zI) {
                return;
            }
            bVar.h("alipay.click.noJump", Y8.j.a("label", actionItem.getLabel()), Y8.j.a("reason", "perfBinder"), Y8.j.a("taskId", cardId));
            return;
        }
        if (N5.d.G(alipayXuiCardView, actionItem.getAppLink(), actionItem.getWebLink(), actionItem.getIntentPackage(), false, false, false, 56, null)) {
            if (actionItem.getArmAuthResume()) {
                C3237b.INSTANCE.a();
                return;
            }
            return;
        }
        String launchPackage5 = actionItem.getLaunchPackage();
        if (launchPackage5 != null && launchPackage5.length() != 0) {
            String launchPackage6 = actionItem.getLaunchPackage();
            kotlin.jvm.internal.p.f(launchPackage6);
            if (alipayXuiCardView.F0(launchPackage6)) {
                if (actionItem.getArmAuthResume()) {
                    C3237b.INSTANCE.a();
                    return;
                }
                return;
            }
        }
        boolean zF0 = alipayXuiCardView.F0(C3236a.PKG_ALIPAY);
        if (!zF0) {
            bVar.h("alipay.click.noJump", Y8.j.a("label", actionItem.getLabel()), Y8.j.a(AlipayXuiLiveClickReceiver.EXTRA_APP_LINK, actionItem.getAppLink()));
        }
        if (zF0 && actionItem.getArmAuthResume()) {
            C3237b.INSTANCE.a();
        }
    }

    public static final Y8.t u0(AlipayXuiCardView alipayXuiCardView, AppDetail appDetail) {
        AlipayXuiCardModel alipayXuiCardModel;
        if (appDetail != null && (alipayXuiCardModel = alipayXuiCardView.lastModel) != null && alipayXuiCardModel.getStatus() == 1) {
            AlipayXuiCardModel.AppItem app = alipayXuiCardModel.getApp();
            C1018b c1018b = alipayXuiCardView.appStore;
            if (app != null && c1018b != null) {
                alipayXuiCardView.e0(c1018b, app, appDetail);
            }
            R5.b bVar = R5.b.INSTANCE;
            Pair pairA = Y8.j.a("name", appDetail.getName());
            Pair pairA2 = Y8.j.a(ContentDisposition.Parameters.Size, appDetail.getSizeText());
            String description = appDetail.getDescription();
            bVar.c("alipay.store.detail", pairA, pairA2, Y8.j.a(Const.JSON_KEY_DESC, description != null ? La.K.R1(description, 40) : null));
            return Y8.t.f7040a;
        }
        return Y8.t.f7040a;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0053  */
    @Override // N5.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void C(N5.n r3) {
        /*
            r2 = this;
            java.lang.String r0 = "model"
            kotlin.jvm.internal.p.i(r3, r0)
            boolean r0 = r3 instanceof com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiCardModel
            if (r0 != 0) goto La
            goto Le
        La:
            T5.c r0 = r2.xui
            if (r0 != 0) goto Lf
        Le:
            return
        Lf:
            com.stepos.ailauncher.foundation.appui.card.provider.alipay.w r3 = (com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiCardModel) r3
            r2.lastModel = r3
            r2.x0()
            int r0 = r3.getStatus()
            java.lang.Integer r1 = r2.lastDimmedStatus
            if (r1 != 0) goto L1f
            goto L25
        L1f:
            int r1 = r1.intValue()
            if (r0 == r1) goto L35
        L25:
            boolean r0 = r3.getDimmed()
            r2.dimmed = r0
            int r0 = r3.getStatus()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r2.lastDimmedStatus = r0
        L35:
            r2.h0()
            int r0 = r3.getStatus()
            r1 = 1
            if (r0 == r1) goto L57
            r1 = 2
            if (r0 == r1) goto L53
            r1 = 3
            if (r0 == r1) goto L53
            r1 = 5
            if (r0 == r1) goto L4f
            r1 = 7
            if (r0 == r1) goto L53
            r2.p0(r3)
            goto L5a
        L4f:
            r2.n0(r3)
            goto L5a
        L53:
            r2.m0(r3)
            goto L5a
        L57:
            r2.l0(r3)
        L5a:
            r2.t0()
            r2.M0()
            r2.R0(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiCardView.C(N5.n):void");
    }

    public final boolean C0(AlipayXuiCardModel.ActionItem action) {
        AlipayXuiCardModel alipayXuiCardModel = this.lastModel;
        Integer numValueOf = alipayXuiCardModel != null ? Integer.valueOf(alipayXuiCardModel.getStatus()) : null;
        if ((numValueOf == null || numValueOf.intValue() != 2) && ((numValueOf == null || numValueOf.intValue() != 7) && (numValueOf == null || numValueOf.intValue() != 3))) {
            return false;
        }
        AlipayXuiCardModel alipayXuiCardModel2 = this.lastModel;
        return action == (alipayXuiCardModel2 != null ? alipayXuiCardModel2.getSecondaryAction() : null);
    }

    public final boolean D0() {
        if (!isAttachedToWindow() || !isShown() || getWidth() <= 0 || getHeight() <= 0) {
            return false;
        }
        return getGlobalVisibleRect(this.autoJumpVisibleRect);
    }

    @Override // N5.d
    public void E(FrameLayout container) {
        kotlin.jvm.internal.p.i(container, "container");
        C1019c c1019cB = C1019c.b(LayoutInflater.from(getContext()), container, true);
        kotlin.jvm.internal.p.h(c1019cB, "inflate(...)");
        this.xui = c1019cB;
        if (c1019cB == null) {
            kotlin.jvm.internal.p.A("xui");
            c1019cB = null;
        }
        ImageView ivAlipayAuthIcon = c1019cB.ivAlipayAuthIcon;
        kotlin.jvm.internal.p.h(ivAlipayAuthIcon, "ivAlipayAuthIcon");
        q0(ivAlipayAuthIcon, 8.0f);
        ViewGroup.LayoutParams layoutParams = getBinding().flCustomContent.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            marginLayoutParams.topMargin = 0;
        }
    }

    public final boolean E0(String taskId) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        AlipayXuiCardModel alipayXuiCardModel = this.lastModel;
        if (kotlin.jvm.internal.p.d(alipayXuiCardModel != null ? alipayXuiCardModel.getCardId() : null, taskId) && !y0()) {
            return D0();
        }
        return false;
    }

    public final boolean F0(String pkg) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            Intent launchIntentForPackage = getContext().getPackageManager().getLaunchIntentForPackage(pkg);
            boolean z10 = false;
            if (launchIntentForPackage == null) {
                R5.b.INSTANCE.h("alipay.launch.noIntent", Y8.j.a("pkg", pkg));
            } else {
                N5.d.A(this, pkg, false, 2, null);
                if (!(getContext() instanceof Activity)) {
                    launchIntentForPackage.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                }
                getContext().startActivity(launchIntentForPackage);
                R5.b.INSTANCE.c("alipay.launch.ok", Y8.j.a("pkg", pkg));
                z10 = true;
            }
            objB = Result.b(Boolean.valueOf(z10));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            R5.b.INSTANCE.h("alipay.launch.fail", Y8.j.a("pkg", pkg), Y8.j.a("exception", thE.getClass().getSimpleName()), Y8.j.a("message", thE.getMessage()));
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        return ((Boolean) objB).booleanValue();
    }

    public final void G0(ImageView target, String url, int placeholder) {
        String strD = N5.j.INSTANCE.d(url);
        if (strD == null) {
            target.setImageResource(placeholder);
        } else {
            com.stepos.ailauncher.common.imageloader.g.s(com.stepos.ailauncher.common.imageloader.g.INSTANCE, target, new ImageRequest(strD, placeholder, placeholder, null, null, 0, 0, 0, 0, false, null, false, false, false, false, null, 0.0f, false, 262136, null), null, null, getContext().getApplicationContext(), 12, null);
        }
    }

    public final void H0() {
        if (this.autoJumpVisiblePosted || !D0()) {
            return;
        }
        this.autoJumpVisiblePosted = true;
        post(new Runnable() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.alipay.C
            @Override // java.lang.Runnable
            public final void run() {
                AlipayXuiCardView.I0(this.f27167a);
            }
        });
    }

    public final void J0() {
        AlipayXuiCardModel alipayXuiCardModel;
        if (this.xui == null || (alipayXuiCardModel = this.lastModel) == null) {
            return;
        }
        if (alipayXuiCardModel.getStatus() == 2 || alipayXuiCardModel.getStatus() == 7 || alipayXuiCardModel.getStatus() == 3) {
            C1019c c1019c = this.xui;
            if (c1019c == null) {
                kotlin.jvm.internal.p.A("xui");
                c1019c = null;
            }
            TextView btnAlipaySecondary = c1019c.btnAlipaySecondary;
            kotlin.jvm.internal.p.h(btnAlipaySecondary, "btnAlipaySecondary");
            g0(btnAlipaySecondary, alipayXuiCardModel.getSecondaryAction());
        }
    }

    public final void K0() {
        AlipayXuiCardModel.ActionItem primaryAction;
        String cardId = this.autoJumpTaskId;
        String strD = null;
        if (cardId == null) {
            AlipayXuiCardModel alipayXuiCardModel = this.lastModel;
            cardId = alipayXuiCardModel != null ? alipayXuiCardModel.getCardId() : null;
            if (cardId == null) {
                cardId = "";
            }
        }
        if (cardId.length() == 0) {
            Q0();
            return;
        }
        if (!D0()) {
            this.autoJumpVisiblePosted = false;
            return;
        }
        AlipayXuiCardModel alipayXuiCardModel2 = this.lastModel;
        if (!kotlin.jvm.internal.p.d(alipayXuiCardModel2 != null ? alipayXuiCardModel2.getCardId() : null, cardId)) {
            s0();
            return;
        }
        AlipayXuiCardModel alipayXuiCardModel3 = this.lastModel;
        if (alipayXuiCardModel3 != null && alipayXuiCardModel3.getStatus() == 2) {
            N5.j jVar = N5.j.INSTANCE;
            AlipayXuiCardModel alipayXuiCardModel4 = this.lastModel;
            if (alipayXuiCardModel4 != null && (primaryAction = alipayXuiCardModel4.getPrimaryAction()) != null) {
                strD = primaryAction.getAppLink();
            }
            strD = jVar.d(strD);
        }
        if (AlipayExecutingAutoJump.INSTANCE.f(cardId, strD)) {
            Q0();
        } else {
            Q0();
        }
    }

    public final boolean L0(String appLink) {
        kotlin.jvm.internal.p.i(appLink, "appLink");
        return N5.d.G(this, appLink, null, null, false, true, false, 44, null);
    }

    public final void M0() {
        AlipayXuiCardModel.ActionItem primaryAction;
        AlipayXuiCardModel alipayXuiCardModel = this.lastModel;
        if (alipayXuiCardModel == null || alipayXuiCardModel.getStatus() != 1 || (primaryAction = alipayXuiCardModel.getPrimaryAction()) == null || this.appStore == null) {
            return;
        }
        C3245j c3245j = C3245j.INSTANCE;
        String strJ = c3245j.j(getContext(), alipayXuiCardModel.getBackendInstallState());
        AlipayXuiCardModel.ActionItem actionItemB = AlipayXuiCardModel.ActionItem.b(primaryAction, c3245j.c(strJ), null, null, 0, 0, c3245j.d(strJ), kotlin.jvm.internal.p.d(strJ, "installing"), null, false, false, 926, null);
        this.lastModel = AlipayXuiCardModel.c(alipayXuiCardModel, null, 0, null, null, null, null, null, null, actionItemB, null, false, 1791, null);
        i0(actionItemB);
    }

    public final void N0() {
        Object objB;
        if (this.receiverRegistered) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme("package");
        try {
            Result.Companion companion = Result.INSTANCE;
            getContext().getApplicationContext().registerReceiver(this.packageReceiver, intentFilter, 4);
            objB = Result.b(Boolean.TRUE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            R5.b.INSTANCE.h("alipay.install.register.fail", Y8.j.a("exception", thE.getClass().getSimpleName()), Y8.j.a("message", thE.getMessage()));
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        this.receiverRegistered = ((Boolean) objB).booleanValue();
    }

    public final void O0() {
        AlipayXuiCardModel alipayXuiCardModel = this.lastModel;
        String cardId = alipayXuiCardModel != null ? alipayXuiCardModel.getCardId() : null;
        if (cardId == null) {
            cardId = "";
        }
        if (cardId.length() == 0) {
            return;
        }
        b0("cancelRequest");
        a0(cardId);
        if (v.INSTANCE.m(cardId)) {
            J0();
        }
    }

    public final void P0() {
        AlipayXuiCardModel alipayXuiCardModel = this.lastModel;
        if (alipayXuiCardModel == null) {
            return;
        }
        String cardId = alipayXuiCardModel.getCardId();
        if (AlipayExecutingAutoJump.INSTANCE.e(cardId)) {
            this.autoJumpTaskId = cardId;
            T0();
        }
    }

    public final void Q0() {
        ViewTreeObserver.OnDrawListener onDrawListener = this.autoJumpDrawListener;
        if (onDrawListener == null) {
            return;
        }
        this.autoJumpDrawListener = null;
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            try {
                Result.Companion companion = Result.INSTANCE;
                viewTreeObserver.removeOnDrawListener(onDrawListener);
                Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
    }

    public final void R0(AlipayXuiCardModel model) {
        r0(model.getCardId());
        if (model.getStatus() != 2) {
            P0();
            return;
        }
        String cardId = model.getCardId();
        N5.j jVar = N5.j.INSTANCE;
        AlipayXuiCardModel.ActionItem primaryAction = model.getPrimaryAction();
        if (AlipayExecutingAutoJump.INSTANCE.k(cardId, jVar.d(primaryAction != null ? primaryAction.getAppLink() : null))) {
            this.autoJumpTaskId = cardId;
            T0();
        }
    }

    public final void S0() {
        if (this.receiverRegistered) {
            this.receiverRegistered = false;
            try {
                Result.Companion companion = Result.INSTANCE;
                getContext().getApplicationContext().unregisterReceiver(this.packageReceiver);
                Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
    }

    public final void T0() {
        Object objB;
        Q0();
        this.autoJumpVisiblePosted = false;
        if (isAttachedToWindow()) {
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (!viewTreeObserver.isAlive()) {
                viewTreeObserver = null;
            }
            if (viewTreeObserver == null) {
                return;
            }
            ViewTreeObserver.OnDrawListener onDrawListener = new ViewTreeObserver.OnDrawListener() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.alipay.y
                @Override // android.view.ViewTreeObserver.OnDrawListener
                public final void onDraw() {
                    AlipayXuiCardView.U0(this.f27183a);
                }
            };
            this.autoJumpDrawListener = onDrawListener;
            try {
                Result.Companion companion = Result.INSTANCE;
                viewTreeObserver.addOnDrawListener(onDrawListener);
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                this.autoJumpDrawListener = null;
                R5.b.INSTANCE.h("alipay.autoJump.draw.listen.fail", Y8.j.a("exception", thE.getClass().getSimpleName()), Y8.j.a("message", thE.getMessage()));
            }
            post(new Runnable() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.alipay.z
                @Override // java.lang.Runnable
                public final void run() {
                    AlipayXuiCardView.V0(this.f27184a);
                }
            });
        }
    }

    public final void a0(String taskId) {
        BaseAppUIHostView baseAppUIHostViewW0 = w0();
        IChatRoundAbortService iChatRoundAbortService = (IChatRoundAbortService) D5.a.INSTANCE.a(IChatRoundAbortService.class);
        if (iChatRoundAbortService != null) {
            String chatSessionId = baseAppUIHostViewW0 != null ? baseAppUIHostViewW0.getChatSessionId() : null;
            if (chatSessionId == null) {
                chatSessionId = "";
            }
            String requestSessionId = baseAppUIHostViewW0 != null ? baseAppUIHostViewW0.getRequestSessionId() : null;
            iChatRoundAbortService.abortRound(chatSessionId, requestSessionId != null ? requestSessionId : "", taskId);
        }
    }

    public final void b0(String reason) {
        String cardId = this.autoJumpTaskId;
        if (cardId == null) {
            AlipayXuiCardModel alipayXuiCardModel = this.lastModel;
            cardId = alipayXuiCardModel != null ? alipayXuiCardModel.getCardId() : null;
            if (cardId == null) {
                cardId = "";
            }
        }
        s0();
        AlipayExecutingAutoJump.INSTANCE.b(cardId, reason);
    }

    public final C1018b d0() {
        C1018b c1018b = this.appStore;
        if (c1018b != null) {
            return c1018b;
        }
        C1019c c1019c = this.xui;
        if (c1019c == null) {
            kotlin.jvm.internal.p.A("xui");
            c1019c = null;
        }
        ViewStub stubAlipayAppStore = c1019c.stubAlipayAppStore;
        kotlin.jvm.internal.p.h(stubAlipayAppStore, "stubAlipayAppStore");
        C1018b c1018b2 = (C1018b) z0(stubAlipayAppStore, AlipayXuiCardView$appStoreBlock$1.INSTANCE);
        if (c1018b2 == null) {
            return null;
        }
        this.appStore = c1018b2;
        ImageView ivAlipayAppIcon = c1018b2.ivAlipayAppIcon;
        kotlin.jvm.internal.p.h(ivAlipayAppIcon, "ivAlipayAppIcon");
        q0(ivAlipayAppIcon, 12.0f);
        return c1018b2;
    }

    public final void e0(C1018b block, AlipayXuiCardModel.AppItem app, AppDetail detail) {
        String iconUrl;
        String name;
        String sizeText;
        String extraText;
        ImageView ivAlipayAppIcon = block.ivAlipayAppIcon;
        kotlin.jvm.internal.p.h(ivAlipayAppIcon, "ivAlipayAppIcon");
        if (detail == null || (iconUrl = detail.getIconUrl()) == null) {
            iconUrl = app.getIconUrl();
        }
        G0(ivAlipayAppIcon, iconUrl, R$drawable.ic_card_alipay_app);
        TextView tvAlipayAppName = block.tvAlipayAppName;
        kotlin.jvm.internal.p.h(tvAlipayAppName, "tvAlipayAppName");
        if (detail == null || (name = detail.getName()) == null) {
            name = app.getName();
        }
        n(tvAlipayAppName, name);
        TextView tvAlipayAppSize = block.tvAlipayAppSize;
        kotlin.jvm.internal.p.h(tvAlipayAppSize, "tvAlipayAppSize");
        if (detail == null || (sizeText = detail.getSizeText()) == null) {
            sizeText = app.getSizeText();
        }
        n(tvAlipayAppSize, sizeText);
        TextView tvAlipayAppExtra = block.tvAlipayAppExtra;
        kotlin.jvm.internal.p.h(tvAlipayAppExtra, "tvAlipayAppExtra");
        if (detail == null || (extraText = detail.getDescription()) == null) {
            extraText = app.getExtraText();
        }
        n(tvAlipayAppExtra, extraText);
    }

    public final boolean f0(String title) {
        AlipayXuiCardModel alipayXuiCardModel;
        if (this.xui == null || (alipayXuiCardModel = this.lastModel) == null || alipayXuiCardModel.getStatus() != 2) {
            return false;
        }
        this.lastModel = AlipayXuiCardModel.c(alipayXuiCardModel, null, 0, null, null, null, null, title, null, null, null, false, 1983, null);
        C1019c c1019c = this.xui;
        if (c1019c == null) {
            kotlin.jvm.internal.p.A("xui");
            c1019c = null;
        }
        TextView tvAlipayAuthSubtitle = c1019c.tvAlipayAuthSubtitle;
        kotlin.jvm.internal.p.h(tvAlipayAuthSubtitle, "tvAlipayAuthSubtitle");
        n(tvAlipayAuthSubtitle, title);
        return true;
    }

    public final void g0(TextView button, AlipayXuiCardModel.ActionItem action) {
        if (action == null) {
            button.setVisibility(8);
            button.setOnClickListener(null);
            return;
        }
        boolean z10 = false;
        button.setVisibility(0);
        button.setClickable(true);
        button.setFocusable(true);
        button.setText(action.getLabel());
        button.setBackgroundResource(action.getBackgroundRes());
        button.setTextColor(androidx.core.content.a.c(getContext(), action.getTextColorRes()));
        C1019c c1019c = this.xui;
        if (c1019c == null) {
            kotlin.jvm.internal.p.A("xui");
            c1019c = null;
        }
        if (button == c1019c.btnAlipaySecondary) {
            v vVar = v.INSTANCE;
            AlipayXuiCardModel alipayXuiCardModel = this.lastModel;
            String cardId = alipayXuiCardModel != null ? alipayXuiCardModel.getCardId() : null;
            if (cardId == null) {
                cardId = "";
            }
            if (vVar.h(cardId)) {
                z10 = true;
            }
        }
        button.setEnabled(!z10);
        button.setClickable(!z10);
        j0(button, action);
    }

    @Override // N5.d
    public boolean getHidesCommonChrome() {
        return this.hidesCommonChrome;
    }

    @Override // N5.d
    public boolean getShowsChannelLogo() {
        return this.showsChannelLogo;
    }

    public final void h0() {
        boolean z10 = this.dimmed;
        C1019c c1019c = this.xui;
        C1019c c1019c2 = null;
        if (c1019c == null) {
            kotlin.jvm.internal.p.A("xui");
            c1019c = null;
        }
        c1019c.vAlipayDimScrim.setClickable(z10);
        C1019c c1019c3 = this.xui;
        if (c1019c3 == null) {
            kotlin.jvm.internal.p.A("xui");
            c1019c3 = null;
        }
        c1019c3.vAlipayDimScrim.setFocusable(z10);
        C1019c c1019c4 = this.xui;
        if (c1019c4 == null) {
            kotlin.jvm.internal.p.A("xui");
            c1019c4 = null;
        }
        c1019c4.vAlipayDimScrim.setVisibility(z10 ? 0 : 8);
        if (z10) {
            C1019c c1019c5 = this.xui;
            if (c1019c5 == null) {
                kotlin.jvm.internal.p.A("xui");
                c1019c5 = null;
            }
            c1019c5.vAlipayDimScrim.bringToFront();
            C1019c c1019c6 = this.xui;
            if (c1019c6 == null) {
                kotlin.jvm.internal.p.A("xui");
            } else {
                c1019c2 = c1019c6;
            }
            c1019c2.vAlipayDimScrim.requestLayout();
        }
    }

    public final void i0(AlipayXuiCardModel.ActionItem action) {
        C1018b c1018b = this.appStore;
        if (c1018b == null) {
            return;
        }
        if (action == null) {
            c1018b.flAlipayInstall.setVisibility(8);
            return;
        }
        c1018b.flAlipayInstall.setVisibility(0);
        c1018b.flAlipayInstall.setBackgroundResource(action.getBackgroundRes());
        c1018b.flAlipayInstall.setContentDescription(action.getLabel());
        c1018b.tvAlipayInstall.setText(action.getLabel());
        c1018b.tvAlipayInstall.setTextColor(androidx.core.content.a.c(getContext(), action.getTextColorRes()));
        c1018b.tvAlipayInstall.setVisibility(action.getShowLoading() ? 8 : 0);
        c1018b.ivAlipayInstallLoading.setVisibility(action.getShowLoading() ? 0 : 8);
        Object drawable = c1018b.ivAlipayInstallLoading.getDrawable();
        Animatable animatable = drawable instanceof Animatable ? (Animatable) drawable : null;
        if (action.getShowLoading()) {
            if (animatable != null) {
                animatable.start();
            }
        } else if (animatable != null) {
            animatable.stop();
        }
        FrameLayout flAlipayInstall = c1018b.flAlipayInstall;
        kotlin.jvm.internal.p.h(flAlipayInstall, "flAlipayInstall");
        j0(flAlipayInstall, action);
    }

    public final void j0(View view, final AlipayXuiCardModel.ActionItem action) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.alipay.A
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AlipayXuiCardView.k0(this.f27164a, action, view2);
            }
        });
    }

    public final void l0(AlipayXuiCardModel model) {
        AlipayXuiCardModel.AppItem app = model.getApp();
        if (app == null) {
            return;
        }
        C1019c c1019c = this.xui;
        C1019c c1019c2 = null;
        if (c1019c == null) {
            kotlin.jvm.internal.p.A("xui");
            c1019c = null;
        }
        c1019c.llAlipayStoreHeader.setVisibility(0);
        C1019c c1019c3 = this.xui;
        if (c1019c3 == null) {
            kotlin.jvm.internal.p.A("xui");
        } else {
            c1019c2 = c1019c3;
        }
        TextView tvAlipayStoreName = c1019c2.tvAlipayStoreName;
        kotlin.jvm.internal.p.h(tvAlipayStoreName, "tvAlipayStoreName");
        n(tvAlipayStoreName, model.getStoreName());
        C1018b c1018bD0 = d0();
        if (c1018bD0 == null) {
            return;
        }
        c1018bD0.b().setVisibility(0);
        e0(c1018bD0, app, AppDetailRepository.INSTANCE.p(C3236a.PKG_ALIPAY));
        i0(model.getPrimaryAction());
    }

    public final void m0(AlipayXuiCardModel model) {
        n0(model);
        C1019c c1019c = this.xui;
        C1019c c1019c2 = null;
        if (c1019c == null) {
            kotlin.jvm.internal.p.A("xui");
            c1019c = null;
        }
        c1019c.llAlipayButtons.setVisibility(0);
        C1019c c1019c3 = this.xui;
        if (c1019c3 == null) {
            kotlin.jvm.internal.p.A("xui");
            c1019c3 = null;
        }
        TextView btnAlipayPrimary = c1019c3.btnAlipayPrimary;
        kotlin.jvm.internal.p.h(btnAlipayPrimary, "btnAlipayPrimary");
        g0(btnAlipayPrimary, model.getPrimaryAction());
        C1019c c1019c4 = this.xui;
        if (c1019c4 == null) {
            kotlin.jvm.internal.p.A("xui");
        } else {
            c1019c2 = c1019c4;
        }
        TextView btnAlipaySecondary = c1019c2.btnAlipaySecondary;
        kotlin.jvm.internal.p.h(btnAlipaySecondary, "btnAlipaySecondary");
        g0(btnAlipaySecondary, model.getSecondaryAction());
    }

    public final void n0(AlipayXuiCardModel model) {
        C1019c c1019c = this.xui;
        C1019c c1019c2 = null;
        if (c1019c == null) {
            kotlin.jvm.internal.p.A("xui");
            c1019c = null;
        }
        c1019c.llAlipayAuthHeader.setVisibility(0);
        C1019c c1019c3 = this.xui;
        if (c1019c3 == null) {
            kotlin.jvm.internal.p.A("xui");
            c1019c3 = null;
        }
        c1019c3.ivAlipayAuthIcon.setImageResource(R$drawable.ic_card_alipay_abao);
        C1019c c1019c4 = this.xui;
        if (c1019c4 == null) {
            kotlin.jvm.internal.p.A("xui");
            c1019c4 = null;
        }
        TextView tvAlipayAuthTitle = c1019c4.tvAlipayAuthTitle;
        kotlin.jvm.internal.p.h(tvAlipayAuthTitle, "tvAlipayAuthTitle");
        n(tvAlipayAuthTitle, model.getTitle());
        C1019c c1019c5 = this.xui;
        if (c1019c5 == null) {
            kotlin.jvm.internal.p.A("xui");
        } else {
            c1019c2 = c1019c5;
        }
        TextView tvAlipayAuthSubtitle = c1019c2.tvAlipayAuthSubtitle;
        kotlin.jvm.internal.p.h(tvAlipayAuthSubtitle, "tvAlipayAuthSubtitle");
        n(tvAlipayAuthSubtitle, model.getSubtitle());
    }

    public final void o0() {
        N0();
        C3244i.INSTANCE.h();
        C3245j c3245j = C3245j.INSTANCE;
        c3245j.i(this.installObserver);
        c3245j.a(this.installObserver);
        M0();
    }

    @Override // N5.d, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        C3237b.INSTANCE.c("card_reattached");
        P0();
        AlipayXuiCardModel alipayXuiCardModel = this.lastModel;
        if (alipayXuiCardModel == null || alipayXuiCardModel.getStatus() != 1) {
            return;
        }
        o0();
    }

    @Override // N5.d, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        C3245j.INSTANCE.i(this.installObserver);
        S0();
        if (y0()) {
            b0("hostDying");
        } else {
            s0();
        }
        super.onDetachedFromWindow();
    }

    public final void p0(AlipayXuiCardModel model) {
        n0(model);
        C1019c c1019c = this.xui;
        if (c1019c == null) {
            kotlin.jvm.internal.p.A("xui");
            c1019c = null;
        }
        TextView btnAlipaySingleCta = c1019c.btnAlipaySingleCta;
        kotlin.jvm.internal.p.h(btnAlipaySingleCta, "btnAlipaySingleCta");
        g0(btnAlipaySingleCta, model.getPrimaryAction());
    }

    public final void q0(View view, float radiusDp) {
        view.setOutlineProvider(new b(radiusDp * getResources().getDisplayMetrics().density));
        view.setClipToOutline(true);
    }

    public final void r0(String cardId) {
        String str = this.autoJumpTaskId;
        if (str == null || kotlin.jvm.internal.p.d(str, cardId)) {
            return;
        }
        s0();
    }

    public final void s0() {
        Q0();
        this.autoJumpTaskId = null;
    }

    public final void t0() {
        AppDetailRepository.INSTANCE.i(C3236a.PKG_ALIPAY, new InterfaceC5074l() { // from class: com.stepos.ailauncher.foundation.appui.card.provider.alipay.B
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AlipayXuiCardView.u0(this.f27166a, (AppDetail) obj);
            }
        });
    }

    public final Activity v0() {
        for (Context context = getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    public final BaseAppUIHostView w0() {
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

    public final void x0() {
        LinearLayout linearLayoutB;
        C1019c c1019c = this.xui;
        C1019c c1019c2 = null;
        if (c1019c == null) {
            kotlin.jvm.internal.p.A("xui");
            c1019c = null;
        }
        c1019c.llAlipayStoreHeader.setVisibility(8);
        C1019c c1019c3 = this.xui;
        if (c1019c3 == null) {
            kotlin.jvm.internal.p.A("xui");
            c1019c3 = null;
        }
        c1019c3.llAlipayAuthHeader.setVisibility(8);
        C1019c c1019c4 = this.xui;
        if (c1019c4 == null) {
            kotlin.jvm.internal.p.A("xui");
            c1019c4 = null;
        }
        c1019c4.tvAlipayAuthSubtitle.setVisibility(8);
        C1019c c1019c5 = this.xui;
        if (c1019c5 == null) {
            kotlin.jvm.internal.p.A("xui");
            c1019c5 = null;
        }
        c1019c5.llAlipayButtons.setVisibility(8);
        C1018b c1018b = this.appStore;
        if (c1018b != null && (linearLayoutB = c1018b.b()) != null) {
            linearLayoutB.setVisibility(8);
        }
        C1019c c1019c6 = this.xui;
        if (c1019c6 == null) {
            kotlin.jvm.internal.p.A("xui");
            c1019c6 = null;
        }
        c1019c6.btnAlipaySecondary.setVisibility(8);
        C1019c c1019c7 = this.xui;
        if (c1019c7 == null) {
            kotlin.jvm.internal.p.A("xui");
            c1019c7 = null;
        }
        c1019c7.btnAlipayPrimary.setVisibility(8);
        C1019c c1019c8 = this.xui;
        if (c1019c8 == null) {
            kotlin.jvm.internal.p.A("xui");
        } else {
            c1019c2 = c1019c8;
        }
        c1019c2.btnAlipaySingleCta.setVisibility(8);
    }

    public final boolean y0() {
        Activity activityV0 = v0();
        if (activityV0 == null) {
            return false;
        }
        return activityV0.isDestroyed() || activityV0.isFinishing();
    }

    public final <T> T z0(ViewStub stub, InterfaceC5074l<? super View, ? extends T> bind) {
        T t10;
        try {
            Result.Companion companion = Result.INSTANCE;
            View viewInflate = stub.inflate();
            kotlin.jvm.internal.p.h(viewInflate, "inflate(...)");
            t10 = (T) Result.b(bind.invoke(viewInflate));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            t10 = (T) Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(t10);
        if (thE != null) {
            R5.b.INSTANCE.h("alipay.stub.inflate.fail", Y8.j.a("exception", thE.getClass().getSimpleName()), Y8.j.a("message", thE.getMessage()));
        }
        if (Result.g(t10)) {
            return null;
        }
        return t10;
    }

    public /* synthetic */ AlipayXuiCardView(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}

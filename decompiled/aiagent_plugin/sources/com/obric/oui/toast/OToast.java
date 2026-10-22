package com.obric.oui.toast;

import android.app.Activity;
import android.content.Context;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.common.style.f;
import com.obric.oui.common.style.j;
import com.obric.oui.common.util.g;
import com.obric.oui.common.util.k;
import com.obric.oui.d.c;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.popover.SingleChildFrameLayout;
import com.obric.oui.progress.ODownloadProgressView;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.h.b.p;
import d.x;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: OToast.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OToast {
    private static final String TAG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f36774a = null;
    private static WeakReference<OToast> q;
    private static final Handler r = null;
    private static final ArrayDeque<OToast> s = null;
    private static OToast t;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f36775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f36776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f36777d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f36778e;
    private Boolean f;
    private int g;
    private View h;
    private final TN i;
    private Toast j;
    private final int k;
    private final int l;
    private final int m;
    private int n;
    private View o;
    private OButton p;

    /* JADX INFO: compiled from: OToast.kt */
    public final class OutlineProvider extends ViewOutlineProvider {
        private final Rect rect;
        private float scaleX;
        private float scaleY;
        final /* synthetic */ OToast this$0;
        private int yShift;

        public OutlineProvider(OToast r2, int r3, float r4, float r5) {
            o.e(r2, "this$0");
            this.this$0 = r2;
            this.yShift = r3;
            this.scaleX = r4;
            this.scaleY = r5;
            this.rect = new Rect();
        }

        public final int getYShift() {
            return this.yShift;
        }

        public final void setYShift(int r1) {
            this.yShift = r1;
        }

        public final float getScaleX() {
            return this.scaleX;
        }

        public final void setScaleX(float r1) {
            this.scaleX = r1;
        }

        public final float getScaleY() {
            return this.scaleY;
        }

        public final void setScaleY(float r1) {
            this.scaleY = r1;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View r4, Outline r5) {
            if (r4 == null) goto L8;
            Drawable r6 = r4.getBackground();
            if (r6 == null) goto L8;
            r6.copyBounds(this.rect);
        L8:
            scaleX(this.rect, this.scaleX);
            scaleY(this.rect, this.scaleY);
            this.rect.offset(0, this.yShift);
            if (r5 == null) goto L13;
            r5.setRoundRect(this.rect, ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(OToast.d(this.this$0), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDimension(ZeusTransformUtils.mapRes(R.dimen.oui_r_l1, "dimen", "oui_r_l1")));
            return;
        }

        private final void scaleX(Rect r2, float r3) {
            if (r3 != 1.0f) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == true) goto L9;
            r2.left = (int) ((r2.left * r3) + 0.5f);
            r2.right = (int) ((r2.right * r3) + 0.5f);
            return;
        L9:
            return;
        L5:
            r1 = false;
            goto L6
        }

        private final void scaleY(Rect r2, float r3) {
            if (r3 != 1.0f) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == true) goto L9;
            r2.top = (int) ((r2.top * r3) + 0.5f);
            r2.bottom = (int) ((r2.bottom * r3) + 0.5f);
            return;
        L9:
            return;
        L5:
            r1 = false;
            goto L6
        }
    }

    /* JADX INFO: compiled from: OToast.kt */
    private static final class TN {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Companion f36779a = null;
        private static final int s = 0;
        private static final int t = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final WindowManager.LayoutParams f36780b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Boolean f36781c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Handler f36782d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f36783e;
        private int f;
        private int g;
        private float h;
        private float i;
        private int j;
        private View k;
        private View l;
        private Context m;
        private IBinder n;
        private Integer o;
        private WindowManager p;
        private boolean q;
        private d.h.a.a<x> r;

        /* JADX INFO: compiled from: OToast.kt */
        public static final class Companion {

            /* JADX INFO: compiled from: OToast.kt */
            private static final class ToastHandler extends Handler {
                private final TN mTn;

                public static /* synthetic */ int access$000(String r0, String r1) {
                    return Log.v(r0, r1);
                }

                public ToastHandler(TN r2) {
                    o.e(r2, "tn");
                    super(Looper.getMainLooper());
                    this.mTn = r2;
                }

                @Override // android.os.Handler
                public void handleMessage(Message r4) {
                    o.e(r4, "msg");
                    INVOKESTATIC_com_obric_oui_toast_OToast$TN$Companion$ToastHandler_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_v(OToast.f36774a.a(), "handleMessage " + r4.what + ' ' + this.mTn);
                    TN.a(this.mTn, r4);
                }

                @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
                public static int INVOKESTATIC_com_obric_oui_toast_OToast$TN$Companion$ToastHandler_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_v(String r1, String r2) {
                    if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
                    return 0;
                L5:
                    return Log.v(r1, r2);
                }
            }

            public /* synthetic */ Companion(h r1) {
                this();
            }

            private Companion() {
            }

            public final int a(String r1, String r2) {
                o.e(r1, "type");
                return ZeusTransformUtils.forName(o.a("com.android.internal.R$", r1), "com.obric.aiagent.plugin").getField(r2).getInt(null);
            L5:
                e = move-exception;
                e.printStackTrace();
                return 0;
            }
        }

        public TN() {
            WindowManager.LayoutParams r0 = new WindowManager.LayoutParams();
            this.f36780b = r0;
            this.f36782d = (Handler) ZeusTransformUtils.preCheckCast(new Companion.ToastHandler(this), Handler.class, "com.obric.aiagent.plugin");
            this.j = DownloadErrorCode.ERROR_CRONET_ERROR_BASE;
            this.q = true;
            r0.height = -2;
            r0.width = -2;
            r0.format = -3;
            r0.windowAnimations = f36779a.a("style", "Animation_Toast");
            r0.type = 2;
            r0.flags = OCardListItem.DEFAULT_TAIL_DETAIL_MAX_WIDTH_DP;
            r0.setTitle((CharSequence) ZeusTransformUtils.preCheckCast("ObricCustomToast", CharSequence.class, "com.obric.aiagent.plugin"));
        }

        public static final /* synthetic */ void a(TN r0, Message r1) {
            r0.a(r1);
        }

        public final void a(Boolean r1) {
            this.f36781c = r1;
        }

        public final Handler a() {
            return this.f36782d;
        }

        public final void a(int r1) {
            this.f36783e = r1;
        }

        public final void b(int r1) {
            this.g = r1;
        }

        public final int b() {
            return this.j;
        }

        public final void c(int r1) {
            this.j = r1;
        }

        public final void a(View r1) {
            this.l = r1;
        }

        public final void a(Context r3) {
            this.m = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        }

        public final void a(d.h.a.a<x> r3) {
            this.r = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        }

        public final void c() {
            a(OToast.f36774a.a(), o.a("SHOW: ", this));
            Handler r0 = this.f36782d;
            int r1 = s;
            r0.removeMessages(r1);
            Handler r2 = this.f36782d;
            int r3 = t;
            r2.removeMessages(r3);
            this.f36782d.sendEmptyMessage(r1);
            this.f36782d.sendEmptyMessageDelayed(r3, this.j);
        }

        public final void d() {
            a(OToast.f36774a.a(), o.a("HIDE: ", this));
            this.f36782d.removeMessages(s);
            Handler r0 = this.f36782d;
            int r1 = t;
            r0.removeMessages(r1);
            this.f36782d.sendEmptyMessage(r1);
        }

        public final void e() {
            a(OToast.f36774a.a(), "clearPendingMessages");
            this.f36782d.removeMessages(s);
            this.f36782d.removeMessages(t);
            this.f36782d.removeCallbacksAndMessages(null);
        }

        private final void a(Message r2) {
            int r3 = r2.what;
            if (r3 != s) goto L6;
            f();
            return;
        L6:
            if (r3 != t) goto L13;
            g();
            this.l = null;
            this.m = ZeusTransformUtils.wrapperContext(null, "com.obric.aiagent.plugin");
            this.p = null;
            this.n = null;
            d.h.a.a<x> r0 = this.r;
            this.r = null;
            if (r0 == null) goto L14;
            r0.invoke();
            return;
        L14:
            return;
        }

        private final void f() {
            a(OToast.f36774a.a(), "HANDLE SHOW: " + this + " mView=" + this.k + " mNextView=" + this.l);
            g();
            Context r0 = this.m;
            if (r0 != null) goto L5;
            Activity r1 = null;
        L6:
            Context r2 = this.m;
            View r3 = this.l;
            o.a(r3);
            View r4 = a(r2, r3, this.g);
            this.k = r4;
            o.a(r4);
            Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            View r6 = this.k;
            o.a(r6);
            String r7 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getPackageName();
            if (r5 != null) goto L9;
            View r8 = this.k;
            o.a(r8);
            r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        L9:
            o.a(r5);
            Object r9 = r5.getSystemService("window");
            Objects.requireNonNull(r9, "null cannot be cast to non-null type android.view.WindowManager");
            this.p = (WindowManager) ZeusTransformUtils.preCheckCast(r9, WindowManager.class, "com.obric.aiagent.plugin");
            View r10 = this.k;
            o.a(r10);
            int r11 = Gravity.getAbsoluteGravity(this.f36783e, ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getConfiguration().getLayoutDirection());
            this.f36780b.gravity = r11;
            if ((r11 & 7) != 7) goto L13;
            this.f36780b.horizontalWeight = 1.0f;
        L13:
            if ((r11 & 112) != 112) goto L15;
            this.f36780b.verticalWeight = 1.0f;
        L15:
            this.f36780b.x = this.f;
            this.f36780b.y = this.g;
            this.f36780b.verticalMargin = this.i;
            this.f36780b.horizontalMargin = this.h;
            Integer r12 = this.o;
            if (r12 == null) goto L20;
            this.f36780b.type = ((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.aiagent.plugin")).intValue();
        L20:
            if (this.q == true) goto L22;
            this.f36780b.flags |= 16;
        L22:
            com.obric.oui.window.a.a(r5, this.f36780b, this.f36781c);
            this.f36780b.y = 0;
            this.f36780b.width = -1;
            if (r1 == null) goto L25;
            this.f36780b.token = ZeusTransformUtils.getWindow(r1, "com.obric.aiagent.plugin").getAttributes().token;
        L28:
            this.f36780b.packageName = r7;
            View r13 = this.k;
            o.a(r13);
            if (r13.getParent() == null) goto L31;
            a(OToast.f36774a.a(), "REMOVE! " + this.k + " in " + this);
            WindowManager r14 = this.p;
            o.a(r14);
            r14.removeView(this.k);
        L31:
            a(OToast.f36774a.a(), "ADD! " + this.k + " in " + this);
            WindowManager r15 = this.p;     // Catch: Exception -> L34
            o.a(r15);     // Catch: Exception -> L34
            r15.addView(this.k, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(this.f36780b, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L34
            return;
        L34:
            e = move-exception;
            e.printStackTrace();
            return;
        L25:
            IBinder r16 = this.n;
            if (r16 == null) goto L28;
            this.f36780b.token = r16;
            goto L28
        L5:
            r1 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.oui.window.a.f36851a.getActivity(r0), "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin");
            goto L6
        }

        private final void g() {
            a(OToast.f36774a.a(), "handleHide " + this.k + " in " + this);
            if (this.k == null) goto L15;
            String r0 = OToast.f36774a.a();
            View r1 = this.k;
            o.a(r1);
            a(r0, o.a("handleHide parent ", r1.getParent()));
            View r2 = this.k;
            o.a(r2);
            if (r2.getParent() == null) goto L11;
            a(OToast.f36774a.a(), "REMOVE! " + this.k + " in " + this);
            WindowManager r3 = this.p;     // Catch: Exception -> L9
            o.a(r3);     // Catch: Exception -> L9
            r3.removeView(this.k);     // Catch: Exception -> L9
        L9:
            e = move-exception;
            e.printStackTrace();
        L11:
            this.k = null;
            return;
        }

        private final View a(Context r12, View r13, int r14) {
            Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
            if (r11 != null) goto L5;
            return r13;
        L5:
            c r15 = c.f35012a;
            if (r13 != null) goto L9;
        L7:
            View r1 = null;
        L11:
            ToastBackgroundView r2 = (ToastBackgroundView) ZeusTransformUtils.preCheckCast(r1, ToastBackgroundView.class, "com.obric.aiagent.plugin");
            if (r2 != null) goto L14;
            int r3 = 24;
        L15:
            View r4 = ZeusTransformUtils.inflate(LayoutInflater.from(r11), ZeusTransformUtils.mapRes(R.layout.o_layout_popover_shadow_frame, "layout", "o_layout_popover_shadow_frame"), null, "com.obric.aiagent.plugin");
            Objects.requireNonNull(r4, "null cannot be cast to non-null type com.obric.oui.popover.SingleChildFrameLayout");
            SingleChildFrameLayout r5 = (SingleChildFrameLayout) ZeusTransformUtils.preCheckCast(r4, SingleChildFrameLayout.class, "com.obric.aiagent.plugin");
            r5.addView(r13, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-2, -2), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
            r5.setShadowCornerRadius(r3);
            List<j> r16 = f.a(r11, "oui_shadow_thick");
            if (r16 != null) goto L18;
            int r6 = 0;
        L33:
            SingleChildFrameLayout r17 = new SingleChildFrameLayout(r11, null, 2, null);
            r17.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new ViewGroup.MarginLayoutParams(-2, -2), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
            View r18 = (View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.aiagent.plugin");
            FrameLayout.LayoutParams r19 = new FrameLayout.LayoutParams(-2, -2);
            r19.gravity = 1;
            x r7 = x.f38692a;
            r17.addView(r18, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r19, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
            r17.setClipChildren(false);
            r17.setClipToPadding(false);
            r17.setPadding(0, r6, 0, r14);
            return (View) ZeusTransformUtils.preCheckCast(r17, View.class, "com.obric.aiagent.plugin");
        L18:
            Iterator r110 = ((Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.aiagent.plugin")).iterator();
            r6 = 0;
            int r8 = 0;
            int r9 = 0;
            int r10 = 0;
        L20:
            if (r110.hasNext() == false) goto L33;
            j r20 = (j) ZeusTransformUtils.preCheckCast(r110.next(), j.class, "com.obric.aiagent.plugin");
            if ((r20.b() - r20.c()) <= r8) goto L25;
            r8 = d.i.a.a(r20.b() - r20.c());
        L25:
            if ((r20.b() + r20.c()) <= r9) goto L28;
            r9 = d.i.a.a(r20.b() + r20.c());
        L28:
            if ((r20.b() - r20.d()) <= r6) goto L31;
            r6 = d.i.a.a(r20.b() - r20.d());
        L31:
            if ((r20.b() + r20.d()) <= r10) goto L20;
            r10 = d.i.a.a(r20.b() + r20.d());
            goto L20
        L14:
            r3 = r2.getCornerRadius();
            goto L15
        L9:
            if (ZeusTransformUtils.instanceOf(r13, ToastBackgroundView.class) == false) goto L7;
            r1 = r13;
            goto L11
        }

        static {
            f36779a = new Companion(null);
            s = 1;
            t = 2;
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.v(r1, r2);
        }
    }

    /* JADX INFO: compiled from: OToast.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        /* JADX INFO: renamed from: lambda$7OiY5HA-t-RY-FV9r_AN4MA7zBU, reason: not valid java name */
        public static /* synthetic */ void m1239lambda$7OiY5HAtRYFV9r_AN4MA7zBU(OToast r0) {
            f(r0);
        }

        public static /* synthetic */ void lambda$UbiGvP8nBbovJkRkBghkbLBD9ZA(OToast r0) {
            d(r0);
        }

        /* JADX INFO: renamed from: lambda$bUgD9PgyNNJ5-voi89HARkZuZgY, reason: not valid java name */
        public static /* synthetic */ void m1240lambda$bUgD9PgyNNJ5voi89HARkZuZgY(OToast r0) {
            e(r0);
        }

        private a() {
        }

        public static final /* synthetic */ void a(a r0, OToast r1) {
            r0.b(r1);
        }

        public static final /* synthetic */ void b(a r0, OToast r1) {
            r0.a(r1);
        }

        public static final /* synthetic */ void c(a r0, OToast r1) {
            r0.c(r1);
        }

        public final String a() {
            return OToast.g();
        }

        public static /* synthetic */ void a(a r1, Context r2, String r3, int r4, int r5, Object r6) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            if ((r5 & 4) == 0) goto L5;
            r4 = 80;
        L5:
            r1.a(r7, r3, r4);
        }

        public final void a(Context r9, String r10, int r11) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
            o.e(r1, "context");
            o.e(r10, "msg");
            a(this, r1, r10, r11, null, 0, 24, null);
        }

        static /* synthetic */ void a(a r6, Context r7, String r8, int r9, Boolean r10, int r11, int r12, Object r13) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
            if ((r12 & 8) == 0) goto L5;
            r10 = null;
        L5:
            Boolean r4 = r10;
            if ((r12 & 16) == 0) goto L8;
            r11 = 0;
        L8:
            r6.a(r1, r8, r9, r4, r11);
        }

        private final void a(Context r10, String r11, int r12, Boolean r13, int r14) {
            OToast r9 = new OToast((Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin"), r11, r12, false, r13, r14, 8, null);
            a r15 = OToast.f36774a;
            OToast.a(new WeakReference(r9));
            r9.f();
        }

        private final void a(final OToast r2) {
            OToast.h().post(new $$Lambda$OToast$a$UbiGvP8nBbovJkRkBghkbLBD9ZA(r2));
        }

        private static final void d(OToast r3) {
            o.e(r3, "$toast");
            if (OToast.i() != r3) goto L5;
            return;
        L5:
            if (OToast.j().contains(r3) == true) goto L18;
            int r0 = OToast.j().size();
            if (OToast.i() != null) goto L10;
            int r1 = 0;
        L11:
            int r2 = r0 + r1;
            if (r2 < 50) goto L15;
            com.obric.oui.d.a.b.d(OToast.f36774a.a(), "Package has already queued " + r2 + " toasts. Not showing more.");
            return;
        L15:
            OToast.j().offer(r3);
            OToast.f36774a.b();
            return;
        L10:
            r1 = 1;
            goto L11
        }

        private final void b(final OToast r2) {
            OToast.h().post(new $$Lambda$OToast$a$bUgD9PgyNNJ5voi89HARkZuZgY(r2));
        }

        private static final void e(OToast r1) {
            o.e(r1, "$toast");
            if (OToast.i() != r1) goto L5;
            OToast.c(r1);
            a r2 = OToast.f36774a;
            OToast.a(null);
            OToast.f36774a.b();
            return;
        L5:
            OToast.j().remove(r1);
        }

        private final void c(final OToast r2) {
            OToast.h().post(new $$Lambda$OToast$a$7OiY5HAtRYFV9r_AN4MA7zBU(r2));
        }

        private static final void f(OToast r1) {
            o.e(r1, "$toast");
            if (OToast.i() != r1) goto L5;
            a r2 = OToast.f36774a;
            OToast.a(null);
            OToast.f36774a.b();
            return;
        L5:
            OToast.j().remove(r1);
        }

        private final void b() {
            if (OToast.i() == null) goto L5;
            return;
        L5:
            OToast r2 = (OToast) ZeusTransformUtils.preCheckCast(OToast.j().poll(), OToast.class, "com.obric.aiagent.plugin");
            if (r2 != null) goto L8;
            return;
        L8:
            OToast.a(r2);
            OToast.b(r2);
        }
    }

    /* JADX INFO: compiled from: OToast.kt */
    static final class b extends p implements d.h.a.a<x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OToast f36784a;

        b(OToast r1) {
            this.f36784a = r1;
            super(0);
        }

        public final void a() {
            a.c(OToast.f36774a, this.f36784a);
        }

        @Override // d.h.a.a
        public /* synthetic */ x invoke() {
            a();
            return x.f38692a;
        }
    }

    public static /* synthetic */ void lambda$rHbBCoaUqondtoqVPG61zJQ2svs(OToast r0) {
        e(r0);
    }

    public OToast(Context r3, String r4, int r5, boolean r6, Boolean r7, int r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r9, "mContext");
        o.e(r4, "msg");
        Context r10 = ZeusTransformUtils.wrapperContext(r9, "com.obric.aiagent.plugin");
        this.f36775b = r10;
        this.f36776c = r4;
        this.f36777d = r5;
        this.f36778e = r6;
        this.f = r7;
        this.g = r8;
        TN r11 = new TN();
        this.i = r11;
        int r12 = g.a(r10, 73);
        this.k = r12;
        this.l = g.a(r10, 28);
        if (com.obric.oui.common.util.h.f34570a.a(r10) == true) goto L5;
        int r13 = g.a(r10) - r12;
    L6:
        this.m = r13;
        this.n = r13;
        LayoutInflater r14 = LayoutInflater.from(r10);
        int r15 = this.g;
        if (r15 != 0) goto L9;
        int r16 = ZeusTransformUtils.mapRes(R.layout.o_toast, "layout", "o_toast");
    L13:
        View r17 = ZeusTransformUtils.inflate(r14, r16, null, "com.obric.aiagent.plugin");
        o.c(r17, "from(mContext)\n        .…   }\n            }, null)");
        this.o = r17;
        if (this.f36777d == 80) goto L16;
        this.f36777d = 80;
        com.obric.oui.d.a.b.d(TAG, "custom position is not supported! position " + this.f36777d + '!');
    L16:
        r11.b(96);
        r11.a(this.f36777d);
        ((TextView) ZeusTransformUtils.preCheckCast(this.o.findViewById(ZeusTransformUtils.mapRes(R.id.tv_msg, DbHelper.COL_ID, "tv_msg")), TextView.class, "com.obric.aiagent.plugin")).setText((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"));
        View r18 = this.o.findViewById(ZeusTransformUtils.mapRes(R.id.right_button, DbHelper.COL_ID, "right_button"));
        o.c(r18, "contentView.findViewById(R.id.right_button)");
        this.p = (OButton) ZeusTransformUtils.preCheckCast(r18, OButton.class, "com.obric.aiagent.plugin");
        k();
        return;
    L9:
        if (r15 == 2) goto L11;
        r16 = ZeusTransformUtils.mapRes(R.layout.o_toast_light, "layout", "o_toast_light");
        goto L13
    L11:
        r16 = ZeusTransformUtils.mapRes(R.layout.o_toast_dark, "layout", "o_toast_dark");
        goto L13
    L5:
        r13 = g.a(r10, 288);
        goto L6
    }

    public /* synthetic */ OToast(Context r8, String r9, int r10, boolean r11, Boolean r12, int r13, int r14, h r15) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        if ((r14 & 4) == 0) goto L5;
        r10 = 80;
    L5:
        int r3 = r10;
        if ((r14 & 8) == 0) goto L8;
        boolean r4 = false;
    L10:
        if ((r14 & 16) == 0) goto L12;
        r12 = null;
    L12:
        Boolean r5 = r12;
        if ((r14 & 32) == 0) goto L15;
        int r6 = 0;
    L16:
        this(r1, r9, r3, r4, r5, r6);
        return;
    L15:
        r6 = r13;
        goto L16
    L8:
        r4 = r11;
        goto L10
    }

    public static final /* synthetic */ void a(OToast r0) {
        t = r0;
    }

    public static final /* synthetic */ void a(WeakReference r0) {
        q = r0;
    }

    public static final /* synthetic */ void b(OToast r0) {
        r0.m();
    }

    public static final /* synthetic */ void c(OToast r0) {
        r0.l();
    }

    public static final /* synthetic */ Context d(OToast r0) {
        return r0.f36775b;
    }

    public static final /* synthetic */ String g() {
        return TAG;
    }

    public static final /* synthetic */ Handler h() {
        return r;
    }

    public static final /* synthetic */ OToast i() {
        return t;
    }

    public static final /* synthetic */ ArrayDeque j() {
        return s;
    }

    public final View a() {
        return this.h;
    }

    static {
        f36774a = new a(null);
        TAG = "OToast";
        q = new WeakReference(null);
        r = new Handler(Looper.getMainLooper());
        s = new ArrayDeque();
    }

    public final View b() {
        return this.o;
    }

    public final OButton c() {
        return this.p;
    }

    private final void k() {
        View r0 = this.o.findViewById(ZeusTransformUtils.mapRes(R.id.iv_icon, DbHelper.COL_ID, "iv_icon"));
        o.c(r0, "contentView.findViewById<ImageView>(R.id.iv_icon)");
        if (k.e(r0) == false) goto L8;
        View r1 = this.o.findViewById(ZeusTransformUtils.mapRes(R.id.toast_progress, DbHelper.COL_ID, "toast_progress"));
        o.c(r1, "contentView.findViewById…iew>(R.id.toast_progress)");
        if (k.e(r1) == false) goto L8;
        boolean r2 = false;
    L9:
        if (r2 == false) goto L11;
        int r3 = this.m - this.l;
    L12:
        this.n = r3;
        ((TextView) ZeusTransformUtils.preCheckCast(this.o.findViewById(ZeusTransformUtils.mapRes(R.id.tv_msg, DbHelper.COL_ID, "tv_msg")), TextView.class, "com.obric.aiagent.plugin")).setMaxWidth(this.n);
        return;
    L11:
        r3 = this.m;
    L8:
        r2 = true;
        goto L9
    }

    public final void d() {
        ODownloadProgressView r0 = (ODownloadProgressView) ZeusTransformUtils.preCheckCast(this.o.findViewById(ZeusTransformUtils.mapRes(R.id.toast_progress, DbHelper.COL_ID, "toast_progress")), ODownloadProgressView.class, "com.obric.aiagent.plugin");
        o.c(r0, "it");
        k.a((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin"));
        ImageView r1 = (ImageView) ZeusTransformUtils.preCheckCast(this.o.findViewById(ZeusTransformUtils.mapRes(R.id.iv_icon, DbHelper.COL_ID, "iv_icon")), ImageView.class, "com.obric.aiagent.plugin");
        o.c(r1, "it");
        k.b((View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin"));
        k();
    }

    public final OToast a(Integer r6) {
        if (r6 == null) goto L5;
        ((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.aiagent.plugin")).intValue();
        ImageView r0 = (ImageView) ZeusTransformUtils.preCheckCast(b().findViewById(ZeusTransformUtils.mapRes(R.id.iv_icon, DbHelper.COL_ID, "iv_icon")), ImageView.class, "com.obric.aiagent.plugin");
        r0.setImageResource(r6.intValue());
        o.c(r0, "it");
        k.a((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin"));
        k();
    L5:
        return this;
    }

    public final void a(int r1) {
        this.i.c(r1);
    }

    public final void e() {
        a.a(f36774a, this);
    }

    private final void l() {
        a(TAG, "cancel()");
        this.i.e();
        this.i.d();
        Toast r0 = this.j;
        if (r0 == null) goto L6;
        r0.cancel();
    L6:
        this.j = null;
    }

    public static /* synthetic */ OToast a(OToast r1, String r2, View.OnClickListener r3, int r4, int r5, Object r6) {
        View.OnClickListener r7 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.aiagent.plugin");
        if ((r5 & 4) == 0) goto L6;
        r4 = ZeusTransformUtils.mapRes(R.color.oui_toast_button_background, "color", "oui_toast_button_background");
    L6:
        return r1.a(r2, r7, r4);
    }

    public final OToast a(String r5, View.OnClickListener r6, int r7) {
        View.OnClickListener r8 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r6, View.OnClickListener.class, "com.obric.aiagent.plugin");
        o.e(r5, WsChannelMultiProcessSharedProvider.STRING_TYPE);
        TextView r9 = (TextView) ZeusTransformUtils.preCheckCast(this.o.findViewById(ZeusTransformUtils.mapRes(R.id.tv_msg, DbHelper.COL_ID, "tv_msg")), TextView.class, "com.obric.aiagent.plugin");
        int r1 = this.n;
        o.c(r9, "it");
        this.n = r1 - g.a((View) ZeusTransformUtils.preCheckCast(r9, View.class, "com.obric.aiagent.plugin"), 52);
        k.a((View) ZeusTransformUtils.preCheckCast(this.p, View.class, "com.obric.aiagent.plugin"));
        this.p.setText((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"));
        this.p.setOnClickListener(r8);
        return this;
    }

    public final void f() {
        a.b(f36774a, this);
    }

    private final void m() {
    L43:
        e = move-exception;
        com.obric.oui.common.util.j.a(o.a("Try DeadObjectException occur, ", e.getMessage()));
        Exception r1 = (Exception) ZeusTransformUtils.preCheckCast(e, Exception.class, "com.obric.aiagent.plugin");
    L47:
        com.obric.oui.common.util.j.a(o.a(TAG, ", showAsDropDown exception occur, try showAtLocation"));
        a.c(f36774a, this);
        Boolean.valueOf(true);
        return;
    L45:
        e = move-exception;
        com.obric.oui.common.util.j.a(o.a("Try runtimeException occur, ", e.getMessage()));
        Exception r2 = (Exception) ZeusTransformUtils.preCheckCast(e, Exception.class, "com.obric.aiagent.plugin");
        goto L47
    L4:
        if (this.g == 0) goto L6;
        boolean r3 = true;
    L7:
        if (r3 == false) goto L9;
    L18:
        b(TAG, "show toast by ocean");     // Catch: DeadObjectException -> L43 RuntimeException -> L45
        int r4 = this.f36777d;     // Catch: DeadObjectException -> L43 RuntimeException -> L45
        if (r4 != 17) goto L21;
    L24:
        int r5 = 0;
    L29:
        if (a() == null) goto L31;
        ((LinearLayout) ZeusTransformUtils.preCheckCast(b().findViewById(ZeusTransformUtils.mapRes(R.id.toast_root, DbHelper.COL_ID, "toast_root")), LinearLayout.class, "com.obric.aiagent.plugin")).addView(a());     // Catch: DeadObjectException -> L43 RuntimeException -> L45
    L31:
        ((TextView) ZeusTransformUtils.preCheckCast(b().findViewById(ZeusTransformUtils.mapRes(R.id.tv_msg, DbHelper.COL_ID, "tv_msg")), TextView.class, "com.obric.aiagent.plugin")).setMaxWidth(this.n);     // Catch: DeadObjectException -> L43 RuntimeException -> L45
        b().measure(0, 0);     // Catch: DeadObjectException -> L43 RuntimeException -> L45
        c r6 = c.f35012a;     // Catch: DeadObjectException -> L43 RuntimeException -> L45
        View r7 = b();     // Catch: DeadObjectException -> L43 RuntimeException -> L45
        if (r7 != null) goto L35;
    L33:
        r7 = null;
    L36:
        ToastBackgroundView r8 = (ToastBackgroundView) ZeusTransformUtils.preCheckCast(r7, ToastBackgroundView.class, "com.obric.aiagent.plugin");     // Catch: DeadObjectException -> L43 RuntimeException -> L45
        if (r8 == null) goto L40;
        ToastBackgroundView.setupBackground$default(r8, b().getMeasuredHeight(), 0, null, 6, null);     // Catch: DeadObjectException -> L43 RuntimeException -> L45
    L40:
        TN r9 = this.i;     // Catch: DeadObjectException -> L43 RuntimeException -> L45
        r9.a(b());     // Catch: DeadObjectException -> L43 RuntimeException -> L45
        r9.a(this.f36775b);     // Catch: DeadObjectException -> L43 RuntimeException -> L45
        r9.a(this.f36777d);     // Catch: DeadObjectException -> L43 RuntimeException -> L45
        r9.b(r5);     // Catch: DeadObjectException -> L43 RuntimeException -> L45
        r9.a(this.f);     // Catch: DeadObjectException -> L43 RuntimeException -> L45
        r9.a((d.h.a.a) ZeusTransformUtils.preCheckCast(new b(this), d.h.a.a.class, "com.obric.aiagent.plugin"));     // Catch: DeadObjectException -> L43 RuntimeException -> L45
        r9.c();     // Catch: DeadObjectException -> L43 RuntimeException -> L45
    L41:
        x r11 = x.f38692a;     // Catch: DeadObjectException -> L43 RuntimeException -> L45
    L51:
        return;
    L35:
        if (ZeusTransformUtils.instanceOf(r7, ToastBackgroundView.class) == false) goto L33;
    L21:
        if (r4 != 48) goto L23;
        r5 = g.a(this.f36775b, 20);     // Catch: DeadObjectException -> L43 RuntimeException -> L45
        goto L29
    L23:
        if (r4 != 80) goto L24;
        r5 = g.a(this.f36775b, 96);     // Catch: DeadObjectException -> L43 RuntimeException -> L45
        goto L29
    L9:
        if (this.f36778e == true) goto L18;
        if (k.e((View) ZeusTransformUtils.preCheckCast(c(), View.class, "com.obric.aiagent.plugin")) == false) goto L13;
    L14:
        b(TAG, "show toast by system");     // Catch: DeadObjectException -> L43 RuntimeException -> L45
        Context r10 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f36775b.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: DeadObjectException -> L43 RuntimeException -> L45
        if (r10 != null) goto L17;
        r10 = this.f36775b;     // Catch: DeadObjectException -> L43 RuntimeException -> L45
    L17:
        Toast r12 = Toast.makeText(r10, (CharSequence) ZeusTransformUtils.preCheckCast(this.f36776c, CharSequence.class, "com.obric.aiagent.plugin"), 0);     // Catch: DeadObjectException -> L43 RuntimeException -> L45
        this.j = r12;     // Catch: DeadObjectException -> L43 RuntimeException -> L45
        r12.show();     // Catch: DeadObjectException -> L43 RuntimeException -> L45
        this.i.a().postDelayed(new $$Lambda$OToast$rHbBCoaUqondtoqVPG61zJQ2svs(this), this.i.b());     // Catch: DeadObjectException -> L43 RuntimeException -> L45
        goto L41
    L13:
        if (c().isClickable() == true) goto L18;
    L6:
        r3 = false;
        goto L7
    }

    private static final void e(OToast r1) {
        o.e(r1, "this$0");
        a.c(f36774a, r1);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.v(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }
}

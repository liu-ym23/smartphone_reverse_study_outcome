package com.bumptech.glide.request.target;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.bumptech.glide.f.j;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public abstract class CustomViewTarget<T extends View, Z> implements i<Z> {
    private static final String TAG = "CustomViewTarget";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f3945b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final T f3946a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SizeDeterminer f3947c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View.OnAttachStateChangeListener f3948d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f3949e;
    private boolean f;

    /* JADX INFO: renamed from: com.bumptech.glide.request.target.CustomViewTarget$1, reason: invalid class name */
    class AnonymousClass1 implements View.OnAttachStateChangeListener {
        final /* synthetic */ CustomViewTarget this$0;

        AnonymousClass1(CustomViewTarget r1) {
            this.this$0 = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View r1) {
            this.this$0.b();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View r1) {
            this.this$0.c();
        }
    }

    static final class SizeDeterminer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static Integer f3950a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f3951b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final View f3952c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List<h> f3953d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private SizeDeterminerLayoutListener f3954e;

        private static final class SizeDeterminerLayoutListener implements ViewTreeObserver.OnPreDrawListener {
            private final WeakReference<SizeDeterminer> sizeDeterminerRef;

            public static /* synthetic */ boolean access$000(String r0, int r1) {
                return Log.isLoggable(r0, r1);
            }

            public static /* synthetic */ int access$001(String r0, String r1) {
                return Log.v(r0, r1);
            }

            SizeDeterminerLayoutListener(SizeDeterminer r2) {
                this.sizeDeterminerRef = new WeakReference(r2);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (INVOKESTATIC_com_bumptech_glide_request_target_CustomViewTarget$SizeDeterminer$SizeDeterminerLayoutListener_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_isLoggable(CustomViewTarget.TAG, 2) == false) goto L5;
                INVOKESTATIC_com_bumptech_glide_request_target_CustomViewTarget$SizeDeterminer$SizeDeterminerLayoutListener_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_v(CustomViewTarget.TAG, "OnGlobalLayoutListener called attachStateListener=" + this);
            L5:
                SizeDeterminer r3 = (SizeDeterminer) ZeusTransformUtils.preCheckCast(this.sizeDeterminerRef.get(), SizeDeterminer.class, "com.obric.aiagent.plugin");
                if (r3 == null) goto L10;
                r3.a();
                return true;
            L10:
                return true;
            }

            @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
            public static boolean INVOKESTATIC_com_bumptech_glide_request_target_CustomViewTarget$SizeDeterminer$SizeDeterminerLayoutListener_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_isLoggable(String r1, int r2) {
                if (com.obric.aiagent.apm.impl.a.a() == true) goto L7;
                return Log.isLoggable(r1, r2);
            L7:
                if (r2 == 6) goto L9;
            L11:
                return false;
            L9:
                if (Log.isLoggable(r1, r2) == false) goto L11;
                return true;
            }

            @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
            public static int INVOKESTATIC_com_bumptech_glide_request_target_CustomViewTarget$SizeDeterminer$SizeDeterminerLayoutListener_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_v(String r1, String r2) {
                if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
                return 0;
            L5:
                return Log.v(r1, r2);
            }
        }

        private boolean a(int r1) {
            if (r1 <= 0) goto L4;
        L7:
            return true;
        L4:
            if (r1 == Integer.MIN_VALUE) goto L7;
            return false;
        }

        SizeDeterminer(View r2) {
            this.f3953d = new ArrayList();
            this.f3952c = r2;
        }

        private static int a(Context r2) {
            Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            if (f3950a != null) goto L6;
            Display r4 = ((WindowManager) ZeusTransformUtils.preCheckCast(j.a((WindowManager) ZeusTransformUtils.preCheckCast(r3.getSystemService("window"), WindowManager.class, "com.obric.aiagent.plugin")), WindowManager.class, "com.obric.aiagent.plugin")).getDefaultDisplay();
            Point r0 = new Point();
            r4.getSize(r0);
            f3950a = Integer.valueOf(Math.max(r0.x, r0.y));
        L6:
            return f3950a.intValue();
        }

        private void a(int r4, int r5) {
            Iterator r3 = new ArrayList(this.f3953d).iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            ((h) ZeusTransformUtils.preCheckCast(r3.next(), h.class, "com.obric.aiagent.plugin")).a(r4, r5);
            goto L4
        }

        void a() {
            if (this.f3953d.isEmpty() == false) goto L5;
            return;
        L5:
            int r0 = d();
            int r1 = c();
            if (b(r0, r1) == true) goto L8;
            return;
        L8:
            a(r0, r1);
            b();
        }

        void a(h r4) {
            h r5 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.aiagent.plugin");
            int r0 = d();
            int r1 = c();
            if (b(r0, r1) == false) goto L7;
            r5.a(r0, r1);
            return;
        L7:
            if (this.f3953d.contains(r5) == true) goto L10;
            this.f3953d.add(r5);
        L10:
            if (this.f3954e != null) goto L13;
            ViewTreeObserver r6 = this.f3952c.getViewTreeObserver();
            SizeDeterminerLayoutListener r2 = new SizeDeterminerLayoutListener(this);
            this.f3954e = r2;
            r6.addOnPreDrawListener(r2);
            return;
        }

        void b(h r3) {
            h r4 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
            this.f3953d.remove(r4);
        }

        void b() {
            ViewTreeObserver r0 = this.f3952c.getViewTreeObserver();
            if (r0.isAlive() == false) goto L5;
            r0.removeOnPreDrawListener(this.f3954e);
        L5:
            this.f3954e = null;
            this.f3953d.clear();
        }

        private boolean b(int r1, int r2) {
            if (a(r1) == true) goto L5;
        L7:
            return false;
        L5:
            if (a(r2) == false) goto L7;
            return true;
        }

        private int c() {
            int r0 = this.f3952c.getPaddingTop() + this.f3952c.getPaddingBottom();
            ViewGroup.LayoutParams r1 = this.f3952c.getLayoutParams();
            if (r1 == null) goto L5;
            int r2 = r1.height;
        L7:
            return a(this.f3952c.getHeight(), r2, r0);
        L5:
            r2 = 0;
            goto L7
        }

        private int d() {
            int r0 = this.f3952c.getPaddingLeft() + this.f3952c.getPaddingRight();
            ViewGroup.LayoutParams r1 = this.f3952c.getLayoutParams();
            if (r1 == null) goto L5;
            int r2 = r1.width;
        L7:
            return a(this.f3952c.getWidth(), r2, r0);
        L5:
            r2 = 0;
            goto L7
        }

        private int a(int r3, int r4, int r5) {
            int r0 = r4 - r5;
            if (r0 <= 0) goto L6;
            return r0;
        L6:
            if (this.f3951b == true) goto L8;
        L10:
            int r6 = r3 - r5;
            if (r6 <= 0) goto L14;
            return r6;
        L14:
            if (this.f3952c.isLayoutRequested() == false) goto L16;
        L22:
            return 0;
        L16:
            if (r4 != (-2)) goto L22;
            if (a(CustomViewTarget.TAG, 4) == false) goto L21;
            a(CustomViewTarget.TAG, "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
        L21:
            return a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f3952c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        L8:
            if (this.f3952c.isLayoutRequested() == false) goto L10;
            return 0;
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static boolean a(String r1, int r2) {
            if (com.obric.aiagent.apm.impl.a.a() == true) goto L7;
            return Log.isLoggable(r1, r2);
        L7:
            if (r2 == 6) goto L9;
        L11:
            return false;
        L9:
            if (Log.isLoggable(r1, r2) == false) goto L11;
            return true;
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.i(r1, r2);
        }
    }

    public abstract void d(Drawable r1);

    public void e(Drawable r1) {
    }

    @Override // com.bumptech.glide.manager.i
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.i
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.i
    public void onStop() {
    }

    static {
        f3945b = ZeusTransformUtils.mapRes(R.id.glide_custom_view_target_tag, DbHelper.COL_ID, "glide_custom_view_target_tag");
    }

    public CustomViewTarget(T r4) {
        this.f3946a = (T) ZeusTransformUtils.preCheckCast(j.a(r4), View.class, "com.obric.aiagent.plugin");
        this.f3947c = new SizeDeterminer(r4);
    }

    @Override // com.bumptech.glide.request.target.i
    public final void a(h r3) {
        h r4 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
        this.f3947c.a(r4);
    }

    @Override // com.bumptech.glide.request.target.i
    public final void b(h r3) {
        h r4 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
        this.f3947c.b(r4);
    }

    @Override // com.bumptech.glide.request.target.i
    public final void a(Drawable r1) {
        e();
        e(r1);
    }

    @Override // com.bumptech.glide.request.target.i
    public final void c(Drawable r2) {
        this.f3947c.b();
        d(r2);
        if (this.f3949e == true) goto L6;
        f();
        return;
    }

    @Override // com.bumptech.glide.request.target.i
    public final void a(com.bumptech.glide.request.d r3) {
        a((com.bumptech.glide.request.d) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.bumptech.glide.request.target.i
    public final com.bumptech.glide.request.d a() {
        Object r2 = d();
        if (r2 != null) goto L5;
        return null;
    L5:
        if (ZeusTransformUtils.instanceOf(r2, com.bumptech.glide.request.d.class) == false) goto L9;
        return (com.bumptech.glide.request.d) ZeusTransformUtils.preCheckCast(r2, com.bumptech.glide.request.d.class, "com.obric.aiagent.plugin");
    L9:
        throw new IllegalArgumentException("You must not pass non-R.id ids to setTag(id)");
    }

    public String toString() {
        return "Target for: " + this.f3946a;
    }

    final void b() {
        com.bumptech.glide.request.d r1 = a();
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.f() == false) goto L9;
        r1.a();
        return;
    }

    final void c() {
        com.bumptech.glide.request.d r0 = a();
        if (r0 == null) goto L6;
        this.f3949e = true;
        r0.b();
        this.f3949e = false;
        return;
    }

    private void a(Object r2) {
        this.f3946a.setTag(f3945b, r2);
    }

    private Object d() {
        return this.f3946a.getTag(f3945b);
    }

    private void e() {
        View.OnAttachStateChangeListener r0 = this.f3948d;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.f == true) goto L10;
        this.f3946a.addOnAttachStateChangeListener(r0);
        this.f = true;
        return;
    }

    private void f() {
        View.OnAttachStateChangeListener r0 = this.f3948d;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.f == false) goto L10;
        this.f3946a.removeOnAttachStateChangeListener(r0);
        this.f = false;
        return;
    }
}

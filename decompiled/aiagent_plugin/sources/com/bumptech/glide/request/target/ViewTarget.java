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
@Deprecated
public abstract class ViewTarget<T extends View, Z> extends a<Z> {
    private static final String TAG = "ViewTarget";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f3955b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f3956c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final T f3957a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SizeDeterminer f3958d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View.OnAttachStateChangeListener f3959e;
    private boolean f;
    private boolean g;

    static final class SizeDeterminer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static Integer f3960a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f3961b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final View f3962c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List<h> f3963d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private SizeDeterminerLayoutListener f3964e;

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
                if (INVOKESTATIC_com_bumptech_glide_request_target_ViewTarget$SizeDeterminer$SizeDeterminerLayoutListener_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_isLoggable(ViewTarget.TAG, 2) == false) goto L5;
                INVOKESTATIC_com_bumptech_glide_request_target_ViewTarget$SizeDeterminer$SizeDeterminerLayoutListener_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_v(ViewTarget.TAG, "OnGlobalLayoutListener called attachStateListener=" + this);
            L5:
                SizeDeterminer r3 = (SizeDeterminer) ZeusTransformUtils.preCheckCast(this.sizeDeterminerRef.get(), SizeDeterminer.class, "com.obric.aiagent.plugin");
                if (r3 == null) goto L10;
                r3.a();
                return true;
            L10:
                return true;
            }

            @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
            public static boolean INVOKESTATIC_com_bumptech_glide_request_target_ViewTarget$SizeDeterminer$SizeDeterminerLayoutListener_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_isLoggable(String r1, int r2) {
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
            public static int INVOKESTATIC_com_bumptech_glide_request_target_ViewTarget$SizeDeterminer$SizeDeterminerLayoutListener_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_v(String r1, String r2) {
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
            this.f3963d = new ArrayList();
            this.f3962c = r2;
        }

        private static int a(Context r2) {
            Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            if (f3960a != null) goto L6;
            Display r4 = ((WindowManager) ZeusTransformUtils.preCheckCast(j.a((WindowManager) ZeusTransformUtils.preCheckCast(r3.getSystemService("window"), WindowManager.class, "com.obric.aiagent.plugin")), WindowManager.class, "com.obric.aiagent.plugin")).getDefaultDisplay();
            Point r0 = new Point();
            r4.getSize(r0);
            f3960a = Integer.valueOf(Math.max(r0.x, r0.y));
        L6:
            return f3960a.intValue();
        }

        private void a(int r4, int r5) {
            Iterator r3 = new ArrayList(this.f3963d).iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            ((h) ZeusTransformUtils.preCheckCast(r3.next(), h.class, "com.obric.aiagent.plugin")).a(r4, r5);
            goto L4
        }

        void a() {
            if (this.f3963d.isEmpty() == false) goto L5;
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
            if (this.f3963d.contains(r5) == true) goto L10;
            this.f3963d.add(r5);
        L10:
            if (this.f3964e != null) goto L13;
            ViewTreeObserver r6 = this.f3962c.getViewTreeObserver();
            SizeDeterminerLayoutListener r2 = new SizeDeterminerLayoutListener(this);
            this.f3964e = r2;
            r6.addOnPreDrawListener(r2);
            return;
        }

        void b(h r3) {
            h r4 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
            this.f3963d.remove(r4);
        }

        void b() {
            ViewTreeObserver r0 = this.f3962c.getViewTreeObserver();
            if (r0.isAlive() == false) goto L5;
            r0.removeOnPreDrawListener(this.f3964e);
        L5:
            this.f3964e = null;
            this.f3963d.clear();
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
            int r0 = this.f3962c.getPaddingTop() + this.f3962c.getPaddingBottom();
            ViewGroup.LayoutParams r1 = this.f3962c.getLayoutParams();
            if (r1 == null) goto L5;
            int r2 = r1.height;
        L7:
            return a(this.f3962c.getHeight(), r2, r0);
        L5:
            r2 = 0;
            goto L7
        }

        private int d() {
            int r0 = this.f3962c.getPaddingLeft() + this.f3962c.getPaddingRight();
            ViewGroup.LayoutParams r1 = this.f3962c.getLayoutParams();
            if (r1 == null) goto L5;
            int r2 = r1.width;
        L7:
            return a(this.f3962c.getWidth(), r2, r0);
        L5:
            r2 = 0;
            goto L7
        }

        private int a(int r3, int r4, int r5) {
            int r0 = r4 - r5;
            if (r0 <= 0) goto L6;
            return r0;
        L6:
            if (this.f3961b == true) goto L8;
        L10:
            int r6 = r3 - r5;
            if (r6 <= 0) goto L14;
            return r6;
        L14:
            if (this.f3962c.isLayoutRequested() == false) goto L16;
        L22:
            return 0;
        L16:
            if (r4 != (-2)) goto L22;
            if (a(ViewTarget.TAG, 4) == false) goto L21;
            a(ViewTarget.TAG, "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
        L21:
            return a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f3962c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        L8:
            if (this.f3962c.isLayoutRequested() == false) goto L10;
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

    static {
        f3956c = ZeusTransformUtils.mapRes(R.id.glide_custom_view_target_tag, DbHelper.COL_ID, "glide_custom_view_target_tag");
    }

    public ViewTarget(T r4) {
        this.f3957a = (T) ZeusTransformUtils.preCheckCast(j.a(r4), View.class, "com.obric.aiagent.plugin");
        this.f3958d = new SizeDeterminer(r4);
    }

    public final ViewTarget<T, Z> b() {
        if (this.f3959e == null) goto L5;
        return this;
    L5:
        this.f3959e = new AnonymousClass1(this);
        e();
        return this;
    }

    void c() {
        com.bumptech.glide.request.d r1 = a();
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.f() == false) goto L9;
        r1.a();
        return;
    }

    void d() {
        com.bumptech.glide.request.d r0 = a();
        if (r0 == null) goto L6;
        this.f = true;
        r0.b();
        this.f = false;
        return;
    }

    @Override // com.bumptech.glide.request.target.a, com.bumptech.glide.request.target.i
    public void a(Drawable r1) {
        super.a(r1);
        e();
    }

    private void e() {
        View.OnAttachStateChangeListener r0 = this.f3959e;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.g == true) goto L10;
        this.f3957a.addOnAttachStateChangeListener(r0);
        this.g = true;
        return;
    }

    private void f() {
        View.OnAttachStateChangeListener r0 = this.f3959e;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.g == false) goto L10;
        this.f3957a.removeOnAttachStateChangeListener(r0);
        this.g = false;
        return;
    }

    @Override // com.bumptech.glide.request.target.i
    public void a(h r3) {
        h r4 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
        this.f3958d.a(r4);
    }

    @Override // com.bumptech.glide.request.target.i
    public void b(h r3) {
        h r4 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
        this.f3958d.b(r4);
    }

    @Override // com.bumptech.glide.request.target.a, com.bumptech.glide.request.target.i
    public void c(Drawable r1) {
        super.c(r1);
        this.f3958d.b();
        if (this.f == true) goto L6;
        f();
        return;
    }

    @Override // com.bumptech.glide.request.target.a, com.bumptech.glide.request.target.i
    public void a(com.bumptech.glide.request.d r3) {
        a((com.bumptech.glide.request.d) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.request.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.bumptech.glide.request.target.a, com.bumptech.glide.request.target.i
    public com.bumptech.glide.request.d a() {
        Object r2 = g();
        if (r2 != null) goto L5;
        return null;
    L5:
        if (ZeusTransformUtils.instanceOf(r2, com.bumptech.glide.request.d.class) == false) goto L8;
        return (com.bumptech.glide.request.d) ZeusTransformUtils.preCheckCast(r2, com.bumptech.glide.request.d.class, "com.obric.aiagent.plugin");
    L8:
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    public String toString() {
        return "Target for: " + this.f3957a;
    }

    private void a(Object r2) {
        f3955b = true;
        this.f3957a.setTag(f3956c, r2);
    }

    private Object g() {
        return this.f3957a.getTag(f3956c);
    }
}

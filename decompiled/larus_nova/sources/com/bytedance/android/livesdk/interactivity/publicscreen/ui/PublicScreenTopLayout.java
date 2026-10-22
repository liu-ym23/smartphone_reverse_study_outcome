package com.bytedance.android.livesdk.interactivity.publicscreen.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\rB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/ui/PublicScreenTopLayout;", "Landroid/widget/LinearLayout;", "", "topMargin", "", "setTopMarginWhenShowing", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", SlcElement.KEY_ATTR, "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PublicScreenTopLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f140194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f140195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f140196c;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PublicScreenTopLayout f140197a;

        public b(PublicScreenTopLayout r100) {
            this.f140197a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a1.o(this.f140197a, 0);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PublicScreenTopLayout f140198a;

        public c(PublicScreenTopLayout r100) {
            this.f140198a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PublicScreenTopLayout r100 = this.f140198a;     // Catch: Throwable -> L4
            a1.o(r100, r100.f140196c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public PublicScreenTopLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PublicScreenTopLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void a() {
        int r100 = a1.h(this);
        boolean r101 = this.f140195b;
        if (r101 == true) goto L5;
    L6:
        if (r100 <= 0) goto L8;
        b(0, r100, r101, this.f140196c);
        postOnAnimation(new b(this));
        return;
    L8:
        if (r101 == false) goto L15;
        int r102 = this.f140196c;
        if (r102 <= 0) goto L16;
        if (r100 == r102) goto L17;
        b(r102, r100, r101, r102);
        postOnAnimation(new c(this));
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    L5:
        if (this.f140196c > 0) goto L8;
        goto L6
    }

    public final void setTopMarginWhenShowing(int r100) {
        this.f140196c = r100;
        a();
    }

    public PublicScreenTopLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f140194a = s1.f(5.0f);
    }

    public /* synthetic */ PublicScreenTopLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public static void b(int r100, int r101, boolean r102, int r103) {
        ALogger.i("PublicScreenTopLayout", "newTopMargin:" + r100 + ", children showing:" + r102 + ", topMarginWhenShowing:" + r103 + ", oldTopMargin:" + r101);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        int r104 = this.f140194a;
        if (r103 >= r104) goto L6;
        if (r101 <= r104) goto L6;
        this.f140195b = true;
        ALogger.i("PublicScreenTopLayout", "has showing children, old h:" + r103 + ", new h:" + r101 + ' ');
        a();
        return;
    L6:
        if (r103 <= r104) goto L11;
        if (r101 >= r104) goto L12;
        this.f140195b = false;
        ALogger.i("PublicScreenTopLayout", "children all dismiss, old h:" + r103 + ", new h:" + r101 + ' ');
        a();
        return;
    L12:
        return;
    }
}

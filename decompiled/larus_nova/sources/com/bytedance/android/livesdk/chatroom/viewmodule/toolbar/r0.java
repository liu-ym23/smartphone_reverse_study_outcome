package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.graphics.Rect;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.v81;
import com.bytedance.android.livesdk.config.xu0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f116687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f116688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v81 f116689c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f116690d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f116691e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f116692f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f116693g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f116694h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f116695i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ViewGroup f116696j;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r0 f116697a;

        public a(r0 r100) {
            this.f116697a = r100;
        }

        public final void a() {
            View r100 = this.f116697a.f116688b;
            if (r100 == null) goto L10;
            Rect r101 = new Rect();
            View r102 = this.f116697a.f116688b;
            Intrinsics.checkNotNull(r102);
            r102.getHitRect(r101);
            new Rect(r101);
            r101.top -= com.bytedance.android.live.core.utils.s1.f(this.f116697a.f116689c.d());
            Object r103 = r100.getParent();
            if ((r103 instanceof View) == true) goto L7;
            r103 = null;
        L7:
            View r104 = (View) r103;
            if (r104 == null) goto L10;
            r104.setTouchDelegate(new e4(r101, this.f116697a, r100));
        L10:
            this.f116697a.f116693g.set(false);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r0 f116698a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f116699b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float f116700c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float f116701d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f116702e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f116703f;

        public b(r0 r100, String r101, float r102, float r103, int r104, String r105) {
            this.f116698a = r100;
            this.f116699b = r101;
            this.f116700c = r102;
            this.f116701d = r103;
            this.f116702e = r104;
            this.f116703f = r105;
        }

        public final void a() {
            r0 r100 = this.f116698a;
            String r101 = this.f116699b;
            float r102 = this.f116700c;
            float r103 = this.f116701d;
            int r104 = this.f116702e;
            String r105 = this.f116703f;
            r100.getClass();
            Intrinsics.checkNotNullParameter(r101, "type");
            Intrinsics.checkNotNullParameter(r105, "info");
            HashMap r106 = new HashMap();
            JSONObject r107 = new JSONObject();
            r107.put("x", Float.valueOf(r102));
            r107.put("y", Float.valueOf(r103));
            r107.put("position", r104);
            String r108 = r107.put("info", r105).toString();
            r106.put("scene", "3");
            r106.put("time", String.valueOf(System.currentTimeMillis()));
            r106.put("type", r101);
            r106.put("detail", r108);
            qm0.b r109 = om0.c.g();
            if (r109 == null) goto L6;
            r109.sendLog("livesdk_use_behavior_recognition", r106, new Object[0]);
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final void a() {
        if (this.f116689c.a() == true) goto L5;
        return;
    L5:
        if (this.f116689c.c() == true) goto L7;
        return;
    L7:
        if (this.f116693g.get() == false) goto L9;
        return;
    L9:
        if (this.f116688b == null) goto L15;
        this.f116693g.set(true);
        com.bytedance.android.live.core.utils.i0.h(new a(this));
        return;
    }

    public r0(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "mToolbarContainer");
        this.f116696j = r100;
        this.f116687a = "LiveToolbarExpand";
        this.f116689c = xu0.f121633a.getValue();
        this.f116690d = -1.0f;
        this.f116691e = -1.0f;
        this.f116693g = new AtomicBoolean(false);
        this.f116695i = true;
    }

    public final boolean b(int r210, float r211, float r310, String r311) {
        Intrinsics.checkNotNullParameter(r311, "type");
        if (this.f116695i == true) goto L5;
    L79:
        return false;
    L5:
        if (this.f116694h == true) goto L79;
        if (this.f116696j.getVisibility() != 0) goto L79;
        if (r210 != 0) goto L13;
        this.f116690d = r211;
        this.f116691e = r310;
        this.f116692f = false;
    L78:
        boolean r100 = this.f116692f;
    L61:
        return !r100;
    L13:
        if (r210 == 2) goto L15;
        if (r210 != 1) goto L78;
        if (this.f116692f == true) goto L78;
        float r101 = this.f116690d;
        if (r101 == (-1.0f)) goto L78;
        if (this.f116691e == (-1.0f)) goto L78;
        if (Math.abs(r211 - r101) >= ViewConfiguration.getTouchSlop()) goto L78;
        if (Math.abs(r310 - this.f116691e) >= ViewConfiguration.getTouchSlop()) goto L78;
        if (r211 > 0) goto L33;
    L50:
        int r102 = -1;
    L51:
        if (r102 >= 0) goto L53;
    L77:
        this.f116690d = -1.0f;
        this.f116691e = -1.0f;
        goto L78
    L53:
        if (r102 >= this.f116696j.getChildCount()) goto L77;
        View r103 = this.f116696j.getChildAt(r102);
        if ((r103 instanceof View) == true) goto L57;
        r103 = null;
    L57:
        View r110 = r103;
        if (r110 != null) goto L62;
        r100 = this.f116692f;
        goto L61
    L62:
        ArrayList<View> r104 = r110.getTouchables();
        Object r105 = r110.getTag(R.id.ttlive_toolbar_tag_of_component_id);
        if (Intrinsics.areEqual(r105, 29) == false) goto L65;
        r100 = this.f116692f;
        goto L61
    L65:
        if (r105 != null) goto L67;
        ALogger.d(this.f116687a, "toolbar tag is null, view:" + r110);
        String r106 = r110.toString();
    L68:
        String r111 = r106;
        if (r104.size() != 1) goto L72;
        ((View) ListProtector.get(r104, 0)).performClick();
    L76:
        r110.post(new b(this, r311, r211, r310, r102, r111));
        goto L77
    L72:
        if (r104.size() <= 1) goto L76;
        if (this.f116689c.b() == false) goto L76;
        long r112 = SystemClock.uptimeMillis();
        r110.dispatchTouchEvent(MotionEvent.obtain(r112, r112, 0, r110.getWidth() / 2.0f, r110.getHeight() / 2.0f, 0));
        long r212 = SystemClock.uptimeMillis();
        r110.dispatchTouchEvent(MotionEvent.obtain(r212, r212, 1, r110.getWidth() / 2.0f, r110.getHeight() / 2.0f, 0));
        goto L76
    L67:
        r106 = r105.toString();
        goto L68
    L33:
        if (r211 >= this.f116696j.getWidth()) goto L50;
        int r107 = this.f116696j.getChildCount();
        int r108 = 0;
        int r109 = 0;
    L35:
        if (r108 >= r107) goto L50;
        View r113 = this.f116696j.getChildAt(r108);
        if (r113.getVisibility() == 8) goto L49;
        if (r113.getLayoutParams() == null) goto L45;
        ViewGroup.LayoutParams r114 = r113.getLayoutParams();
        if (r114 == null) goto L44;
        ViewGroup.MarginLayoutParams r115 = (ViewGroup.MarginLayoutParams) r114;
        r109 = r109 + ((r115.leftMargin + r113.getWidth()) + r115.rightMargin);
    L47:
        if (r211 >= r109) goto L49;
        r102 = r108;
        goto L51
    L44:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L45:
        r109 = r109 + r113.getWidth();
    L49:
        r108 = r108 + 1;
        goto L35
    L15:
        if (Math.abs(r211 - this.f116690d) <= ViewConfiguration.getTouchSlop()) goto L17;
    L18:
        this.f116692f = true;
        goto L78
    L17:
        if (Math.abs(r310 - this.f116691e) <= ViewConfiguration.getTouchSlop()) goto L78;
        goto L18
    }
}

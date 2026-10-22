package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import com.bytedance.librarian.LibrarianImpl;
import com.obric.oui.constraintlayout.widget.R$id;
import com.obric.oui.constraintlayout.widget.R$styleable;
import io.reactivex.annotations.SchedulerSupport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes4.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MotionLayout f13819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public zc.c f13820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f13821c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f13822d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList f13823e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f13824f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ArrayList f13825g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SparseArray f13826h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public HashMap f13827i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public SparseIntArray f13828j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f13829k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f13830l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public MotionEvent f13831m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f13832n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f13833o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public MotionLayout.MotionTracker f13834p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f13835q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final s f13836r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f13837s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f13838t;

    public class a implements Interpolator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ vc.c f13839a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ o f13840b;

        public a(o r10, vc.c r11) {
            this.f13840b = r10;
            this.f13839a = r11;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float r10) {
            return (float) this.f13839a.a(r10);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f13841a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f13842b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f13843c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f13844d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f13845e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f13846f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f13847g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f13848h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f13849i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final o f13850j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public ArrayList f13851k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public p f13852l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public ArrayList f13853m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f13854n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f13855o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f13856p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f13857q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f13858r;

        public static class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final b f13859a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f13860b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f13861c;

            public a(Context r10, b r11, XmlPullParser r12) {
                this.f13860b = -1;
                this.f13861c = 17;
                this.f13859a = r11;
                TypedArray r13 = r10.obtainStyledAttributes(Xml.asAttributeSet(r12), R$styleable.OnClick);
                int r14 = r13.getIndexCount();
                int r15 = 0;
            L3:
                if (r15 >= r14) goto L11;
                int r16 = r13.getIndex(r15);
                if (r16 != R$styleable.OnClick_targetId) goto L8;
                this.f13860b = r13.getResourceId(r16, this.f13860b);
            L10:
                r15 = r15 + 1;
                goto L3
            L8:
                if (r16 != R$styleable.OnClick_clickAction) goto L10;
                this.f13861c = r13.getInt(r16, this.f13861c);
                goto L10
            L11:
                r13.recycle();
            }

            public void a(MotionLayout r10, int r11, b r12) {
                int r13 = this.f13860b;
                View r14 = r10;
                if (r13 == (-1)) goto L6;
                r14 = r10.findViewById(r13);
            L6:
                if (r14 != null) goto L9;
                Log.e("MotionScene", "OnClick could not find id " + this.f13860b);
                return;
            L9:
                int r15 = b.c(r12);
                int r16 = b.a(r12);
                if (r15 != (-1)) goto L13;
                r14.setOnClickListener(this);
                return;
            L13:
                int r17 = this.f13861c;
                boolean r18 = false;
                if ((r17 & 1) == 0) goto L17;
                if (r11 != r15) goto L17;
                boolean r19 = true;
            L19:
                if ((r17 & 256) == 0) goto L22;
                if (r11 != r15) goto L22;
                boolean r20 = true;
            L23:
                boolean r21 = r19 | r20;
                if ((r17 & 1) == 0) goto L27;
                if (r11 != r15) goto L27;
                boolean r22 = true;
            L28:
                boolean r23 = r22 | r21;
                if ((r17 & 16) == 0) goto L32;
                if (r11 != r16) goto L32;
                boolean r24 = true;
            L33:
                boolean r25 = r23 | r24;
                if ((r17 & 4096) == 0) goto L38;
                if (r11 != r16) goto L38;
                r18 = true;
            L38:
                if ((r25 | r18) == false) goto L41;
                r14.setOnClickListener(this);
                return;
            L41:
                return;
            L32:
                r24 = false;
            L27:
                r22 = false;
            L22:
                r20 = false;
            L17:
                r19 = false;
                goto L19
            }

            public boolean b(b r10, MotionLayout r11) {
                b r12 = this.f13859a;
                if (r12 != r10) goto L5;
                return true;
            L5:
                int r13 = b.a(r12);
                int r14 = b.c(this.f13859a);
                if (r14 == (-1)) goto L8;
                int r15 = r11.E;
                if (r15 == r14) goto L19;
                if (r15 != r13) goto L17;
                return true;
            L17:
                return false;
            L19:
                return true;
            L8:
                if (r11.E == r13) goto L11;
                return true;
            L11:
                return false;
            }

            public void c(MotionLayout r10) {
                int r11 = this.f13860b;
                if (r11 != (-1)) goto L5;
                return;
            L5:
                View r12 = r10.findViewById(r11);
                if (r12 != null) goto L9;
                Log.e("MotionScene", " (*)  could not find id " + this.f13860b);
                return;
            L9:
                r12.setOnClickListener(null);
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View r10) {
                MotionLayout r11 = o.d(b.s(this.f13859a));
                if (r11.p0() == true) goto L6;
                return;
            L6:
                if (b.c(this.f13859a) != (-1)) goto L13;
                int r12 = r11.getCurrentState();
                if (r12 != (-1)) goto L11;
                r11.D0(b.a(this.f13859a));
                return;
            L11:
                b r13 = new b(b.s(this.f13859a), this.f13859a);
                b.d(r13, r12);
                b.b(r13, b.a(this.f13859a));
                r11.setTransition(r13);
                r11.A0();
                return;
            L13:
                b r14 = b.s(this.f13859a).f13821c;
                int r15 = this.f13861c;
                boolean r16 = false;
                if ((r15 & 1) == 0) goto L16;
            L19:
                boolean r17 = true;
            L21:
                if ((r15 & 16) == 0) goto L23;
            L26:
                boolean r18 = true;
            L27:
                if (r17 == false) goto L38;
                if (r18 == false) goto L38;
                b r19 = b.s(this.f13859a).f13821c;
                b r20 = this.f13859a;
                if (r19 == r20) goto L33;
                r11.setTransition(r20);
            L33:
                if (r11.getCurrentState() == r11.getEndState()) goto L40;
                if (r11.getProgress() > 0.5f) goto L40;
                r18 = false;
            L40:
                if (b(r14, r11) == false) goto L58;
                if (r16 == true) goto L43;
            L45:
                if (r18 == true) goto L47;
            L49:
                if (r16 == true) goto L51;
            L53:
                if (r18 == true) goto L55;
                return;
            L55:
                if ((this.f13861c & 4096) == 0) goto L63;
                r11.setTransition(this.f13859a);
                r11.setProgress(0.0f);
                return;
            L63:
                return;
            L51:
                if ((this.f13861c & 256) == 0) goto L53;
                r11.setTransition(this.f13859a);
                r11.setProgress(1.0f);
                return;
            L47:
                if ((this.f13861c & 16) == 0) goto L49;
                r11.setTransition(this.f13859a);
                r11.C0();
                return;
            L43:
                if ((this.f13861c & 1) == 0) goto L45;
                r11.setTransition(this.f13859a);
                r11.A0();
                return;
            L58:
                return;
            L38:
                r16 = r17;
                goto L40
            L23:
                if ((r15 & 4096) != 0) goto L26;
                r18 = false;
                goto L27
            L16:
                if ((r15 & 256) != 0) goto L19;
                r17 = false;
                goto L21
            }
        }

        public b(o r10, b r11) {
            this.f13841a = -1;
            this.f13842b = false;
            this.f13843c = -1;
            this.f13844d = -1;
            this.f13845e = 0;
            this.f13846f = null;
            this.f13847g = -1;
            this.f13848h = 400;
            this.f13849i = 0.0f;
            this.f13851k = new ArrayList();
            this.f13852l = null;
            this.f13853m = new ArrayList();
            this.f13854n = 0;
            this.f13855o = false;
            this.f13856p = -1;
            this.f13857q = 0;
            this.f13858r = 0;
            this.f13850j = r10;
            this.f13848h = o.e(r10);
            if (r11 == null) goto L6;
            this.f13856p = r11.f13856p;
            this.f13845e = r11.f13845e;
            this.f13846f = r11.f13846f;
            this.f13847g = r11.f13847g;
            this.f13848h = r11.f13848h;
            this.f13851k = r11.f13851k;
            this.f13849i = r11.f13849i;
            this.f13857q = r11.f13857q;
            return;
        }

        public static /* synthetic */ int a(b r10) {
            return r10.f13843c;
        }

        public static /* synthetic */ int b(b r10, int r11) {
            r10.f13843c = r11;
            return r11;
        }

        public static /* synthetic */ int c(b r10) {
            return r10.f13844d;
        }

        public static /* synthetic */ int d(b r10, int r11) {
            r10.f13844d = r11;
            return r11;
        }

        public static /* synthetic */ boolean e(b r10) {
            return r10.f13842b;
        }

        public static /* synthetic */ ArrayList f(b r10) {
            return r10.f13851k;
        }

        public static /* synthetic */ int g(b r10) {
            return r10.f13845e;
        }

        public static /* synthetic */ String h(b r10) {
            return r10.f13846f;
        }

        public static /* synthetic */ int i(b r10) {
            return r10.f13847g;
        }

        public static /* synthetic */ int j(b r10) {
            return r10.f13848h;
        }

        public static /* synthetic */ int k(b r10) {
            return r10.f13856p;
        }

        public static /* synthetic */ p l(b r10) {
            return r10.f13852l;
        }

        public static /* synthetic */ float m(b r10) {
            return r10.f13849i;
        }

        public static /* synthetic */ p n(b r10, p r11) {
            r10.f13852l = r11;
            return r11;
        }

        public static /* synthetic */ int o(b r10) {
            return r10.f13841a;
        }

        public static /* synthetic */ ArrayList p(b r10) {
            return r10.f13853m;
        }

        public static /* synthetic */ boolean q(b r10) {
            return r10.f13855o;
        }

        public static /* synthetic */ int r(b r10) {
            return r10.f13854n;
        }

        public static /* synthetic */ o s(b r10) {
            return r10.f13850j;
        }

        public int A() {
            return this.f13844d;
        }

        public p B() {
            return this.f13852l;
        }

        public boolean C() {
            return !this.f13855o;
        }

        public boolean D(int r10) {
            if ((this.f13858r & r10) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public void E(int r10) {
            this.f13848h = Math.max(r10, 8);
        }

        public void F(boolean r10) {
            this.f13855o = !r10;
        }

        public void G(int r10, String r11, int r12) {
            this.f13845e = r10;
            this.f13846f = r11;
            this.f13847g = r12;
        }

        public void H(int r10) {
            p r11 = B();
            if (r11 == null) goto L6;
            r11.y(r10);
            return;
        }

        public void I(int r10) {
            this.f13856p = r10;
        }

        public void t(f r10) {
            this.f13851k.add(r10);
        }

        public void u(Context r10, XmlPullParser r11) {
            this.f13853m.add(new a(r10, this, r11));
        }

        public final void v(o r10, Context r11, TypedArray r12) {
            int r13 = r12.getIndexCount();
            int r14 = 0;
        L4:
            if (r14 >= r13) goto L65;
            int r15 = r12.getIndex(r14);
            if (r15 != R$styleable.Transition_constraintSetEnd) goto L14;
            this.f13843c = r12.getResourceId(r15, -1);
            String r16 = r11.getResources().getResourceTypeName(this.f13843c);
            if ("layout".equals(r16) == false) goto L11;
            com.obric.oui.constraintlayout.widget.a r17 = new com.obric.oui.constraintlayout.widget.a();
            r17.B(r11, this.f13843c);
            o.b(r10).append(this.f13843c, r17);
        L63:
            r14 = r14 + 1;
            goto L4
        L11:
            if ("xml".equals(r16) == false) goto L63;
            this.f13843c = o.c(r10, r11, this.f13843c);
            goto L63
        L14:
            if (r15 != R$styleable.Transition_constraintSetStart) goto L22;
            this.f13844d = r12.getResourceId(r15, this.f13844d);
            String r18 = r11.getResources().getResourceTypeName(this.f13844d);
            if ("layout".equals(r18) == false) goto L19;
            com.obric.oui.constraintlayout.widget.a r19 = new com.obric.oui.constraintlayout.widget.a();
            r19.B(r11, this.f13844d);
            o.b(r10).append(this.f13844d, r19);
            goto L63
        L19:
            if ("xml".equals(r18) == false) goto L63;
            this.f13844d = o.c(r10, r11, this.f13844d);
            goto L63
        L22:
            if (r15 != R$styleable.Transition_motionInterpolator) goto L38;
            int r20 = r12.peekValue(r15).type;
            if (r20 != 1) goto L29;
            int r21 = r12.getResourceId(r15, -1);
            this.f13847g = r21;
            if (r21 == (-1)) goto L63;
            this.f13845e = -2;
            goto L63
        L29:
            if (r20 != 3) goto L36;
            String r22 = r12.getString(r15);
            this.f13846f = r22;
            if (r22 == null) goto L63;
            if (r22.indexOf(LibrarianImpl.Constants.SEPARATOR) <= 0) goto L35;
            this.f13847g = r12.getResourceId(r15, -1);
            this.f13845e = -2;
            goto L63
        L35:
            this.f13845e = -1;
            goto L63
        L36:
            this.f13845e = r12.getInteger(r15, this.f13845e);
            goto L63
        L38:
            if (r15 != R$styleable.Transition_duration) goto L43;
            int r23 = r12.getInt(r15, this.f13848h);
            this.f13848h = r23;
            if (r23 >= 8) goto L63;
            this.f13848h = 8;
            goto L63
        L43:
            if (r15 != R$styleable.Transition_staggered) goto L46;
            this.f13849i = r12.getFloat(r15, this.f13849i);
            goto L63
        L46:
            if (r15 != R$styleable.Transition_autoTransition) goto L49;
            this.f13854n = r12.getInteger(r15, this.f13854n);
            goto L63
        L49:
            if (r15 != R$styleable.Transition_android_id) goto L52;
            this.f13841a = r12.getResourceId(r15, this.f13841a);
            goto L63
        L52:
            if (r15 != R$styleable.Transition_transitionDisable) goto L55;
            this.f13855o = r12.getBoolean(r15, this.f13855o);
            goto L63
        L55:
            if (r15 != R$styleable.Transition_pathMotionArc) goto L58;
            this.f13856p = r12.getInteger(r15, -1);
            goto L63
        L58:
            if (r15 != R$styleable.Transition_layoutDuringTransition) goto L61;
            this.f13857q = r12.getInteger(r15, 0);
            goto L63
        L61:
            if (r15 != R$styleable.Transition_transitionFlags) goto L63;
            this.f13858r = r12.getInteger(r15, 0);
            goto L63
        L65:
            if (this.f13844d != (-1)) goto L91;
            this.f13842b = true;
            return;
        }

        public final void w(o r10, Context r11, AttributeSet r12) {
            TypedArray r13 = r11.obtainStyledAttributes(r12, R$styleable.Transition);
            v(r10, r11, r13);
            r13.recycle();
        }

        public int x() {
            return this.f13854n;
        }

        public int y() {
            return this.f13843c;
        }

        public int z() {
            return this.f13857q;
        }

        public b(int r10, o r11, int r12, int r13) {
            this.f13841a = -1;
            this.f13842b = false;
            this.f13843c = -1;
            this.f13844d = -1;
            this.f13845e = 0;
            this.f13846f = null;
            this.f13847g = -1;
            this.f13848h = 400;
            this.f13849i = 0.0f;
            this.f13851k = new ArrayList();
            this.f13852l = null;
            this.f13853m = new ArrayList();
            this.f13854n = 0;
            this.f13855o = false;
            this.f13856p = -1;
            this.f13857q = 0;
            this.f13858r = 0;
            this.f13841a = r10;
            this.f13850j = r11;
            this.f13844d = r12;
            this.f13843c = r13;
            this.f13848h = o.e(r11);
            this.f13857q = o.a(r11);
        }

        public b(o r10, Context r11, XmlPullParser r12) {
            this.f13841a = -1;
            this.f13842b = false;
            this.f13843c = -1;
            this.f13844d = -1;
            this.f13845e = 0;
            this.f13846f = null;
            this.f13847g = -1;
            this.f13848h = 400;
            this.f13849i = 0.0f;
            this.f13851k = new ArrayList();
            this.f13852l = null;
            this.f13853m = new ArrayList();
            this.f13854n = 0;
            this.f13855o = false;
            this.f13856p = -1;
            this.f13857q = 0;
            this.f13858r = 0;
            this.f13848h = o.e(r10);
            this.f13857q = o.a(r10);
            this.f13850j = r10;
            w(r10, r11, Xml.asAttributeSet(r12));
        }
    }

    public o(Context r10, MotionLayout r11, int r12) {
        this.f13820b = null;
        this.f13821c = null;
        this.f13822d = false;
        this.f13823e = new ArrayList();
        this.f13824f = null;
        this.f13825g = new ArrayList();
        this.f13826h = new SparseArray();
        this.f13827i = new HashMap();
        this.f13828j = new SparseIntArray();
        this.f13829k = 400;
        this.f13830l = 0;
        this.f13832n = false;
        this.f13833o = false;
        this.f13819a = r11;
        this.f13836r = new s(r11);
        K(r10, r12);
        SparseArray r13 = this.f13826h;
        int r14 = R$id.motion_base;
        r13.put(r14, new com.obric.oui.constraintlayout.widget.a());
        this.f13827i.put("motion_base", Integer.valueOf(r14));
    }

    public static /* synthetic */ int a(o r10) {
        return r10.f13830l;
    }

    public static String a0(String r10) {
        if (r10 != null) goto L5;
        return "";
    L5:
        int r11 = r10.indexOf(47);
        if (r11 >= 0) goto L9;
        return r10;
    L9:
        return r10.substring(r11 + 1);
    }

    public static /* synthetic */ SparseArray b(o r10) {
        return r10.f13826h;
    }

    public static /* synthetic */ int c(o r10, Context r11, int r12) {
        return r10.M(r11, r12);
    }

    public static /* synthetic */ MotionLayout d(o r10) {
        return r10.f13819a;
    }

    public static /* synthetic */ int e(o r10) {
        return r10.f13829k;
    }

    public float A() {
        b r10 = this.f13821c;
        if (r10 != null) goto L5;
        return 0.0f;
    L5:
        if (b.l(r10) != null) goto L7;
        return 0.0f;
    L7:
        return b.l(this.f13821c).l();
    }

    public float B() {
        b r10 = this.f13821c;
        if (r10 != null) goto L5;
        return 0.0f;
    L5:
        if (b.l(r10) != null) goto L7;
        return 0.0f;
    L7:
        return b.l(this.f13821c).m();
    }

    public float C() {
        b r10 = this.f13821c;
        if (r10 != null) goto L5;
        return 0.0f;
    L5:
        if (b.l(r10) != null) goto L7;
        return 0.0f;
    L7:
        return b.l(this.f13821c).n();
    }

    public float D() {
        b r10 = this.f13821c;
        if (r10 != null) goto L5;
        return 0.0f;
    L5:
        if (b.l(r10) != null) goto L7;
        return 0.0f;
    L7:
        return b.l(this.f13821c).o();
    }

    public float E() {
        b r10 = this.f13821c;
        if (r10 != null) goto L5;
        return 0.0f;
    L5:
        return b.m(r10);
    }

    public int F() {
        b r10 = this.f13821c;
        if (r10 != null) goto L7;
        return -1;
    L7:
        return b.c(r10);
    }

    public b G(int r10) {
        Iterator r11 = this.f13823e.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        b r12 = (b) r11.next();
        if (b.o(r12) != r10) goto L4;
        return r12;
    L8:
        return null;
    }

    public List H(int r10) {
        int r11 = y(r10);
        ArrayList r12 = new ArrayList();
        Iterator r13 = this.f13823e.iterator();
    L4:
        if (r13.hasNext() == false) goto L10;
        b r14 = (b) r13.next();
        if (b.c(r14) == r11) goto L9;
        if (b.a(r14) != r11) goto L4;
    L9:
        r12.add(r14);
        goto L4
    L10:
        return r12;
    }

    public final boolean I(int r10) {
        int r11 = this.f13828j.get(r10);
        int r12 = this.f13828j.size();
    L3:
        if (r11 <= 0) goto L11;
        if (r11 == r10) goto L6;
        int r13 = r12 - 1;
        if (r12 < 0) goto L9;
        r11 = this.f13828j.get(r11);
        r12 = r13;
        goto L3
    L9:
        return true;
    L6:
        return true;
    L11:
        return false;
    }

    public final boolean J() {
        if (this.f13834p == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void K(Context r10, int r11) {
        XmlResourceParser r12 = r10.getResources().getXml(r11);
        int r13 = r12.getEventType();     // Catch: IOException -> L15 XmlPullParserException -> L17
        b r14 = null;
    L4:
        byte r15 = 1;
        if (r13 == 1) goto L105;
        if (r13 != 2) goto L79;
        String r16 = r12.getName();     // Catch: IOException -> L15 XmlPullParserException -> L17
        switch(r16.hashCode()) {
            case -1349929691: goto L44;
            case -1239391468: goto L41;
            case -687739768: goto L38;
            case 61998586: goto L35;
            case 269306229: goto L32;
            case 312750793: goto L29;
            case 327855227: goto L26;
            case 793277014: goto L23;
            case 1382829617: goto L20;
            case 1942574248: goto L13;
            default: goto L46;
        };     // Catch: IOException -> L15 XmlPullParserException -> L17
    L46:
        r15 = -1;
    L47:
        switch(r15) {
            case 0: goto L78;
            case 1: goto L64;
            case 2: goto L60;
            case 3: goto L56;
            case 4: goto L55;
            case 5: goto L54;
            case 6: goto L53;
            case 7: goto L53;
            case 8: goto L50;
            case 9: goto L49;
            default: goto L79;
        };     // Catch: IOException -> L15 XmlPullParserException -> L17
    L49:
        this.f13836r.b(new r(r10, r12));     // Catch: IOException -> L15 XmlPullParserException -> L17
        goto L79
    L50:
        f r17 = new f(r10, r12);     // Catch: IOException -> L15 XmlPullParserException -> L17
        if (r14 == null) goto L79;
        b.f(r14).add(r17);     // Catch: IOException -> L15 XmlPullParserException -> L17
        goto L79
    L53:
        N(r10, r12);     // Catch: IOException -> L15 XmlPullParserException -> L17
        goto L79
    L54:
        L(r10, r12);     // Catch: IOException -> L15 XmlPullParserException -> L17
        goto L79
    L55:
        this.f13820b = new zc.c(r10, r12);     // Catch: IOException -> L15 XmlPullParserException -> L17
        goto L79
    L56:
        if (r14 == null) goto L79;
        if (this.f13819a.isInEditMode() == true) goto L79;
        r14.u(r10, r12);     // Catch: IOException -> L15 XmlPullParserException -> L17
        goto L79
    L60:
        if (r14 != null) goto L62;
        Log.v("MotionScene", " OnSwipe (" + r10.getResources().getResourceEntryName(r11) + ".xml:" + r12.getLineNumber() + ")");     // Catch: IOException -> L15 XmlPullParserException -> L17
    L62:
        if (r14 == null) goto L79;
        b.n(r14, new p(r10, this.f13819a, r12));     // Catch: IOException -> L15 XmlPullParserException -> L17
        goto L79
    L64:
        ArrayList r18 = this.f13823e;     // Catch: IOException -> L15 XmlPullParserException -> L17
        r14 = new b(this, r10, r12);     // Catch: IOException -> L15 XmlPullParserException -> L17
        r18.add(r14);     // Catch: IOException -> L15 XmlPullParserException -> L17
        if (this.f13821c != null) goto L72;
        if (b.e(r14) == true) goto L72;
        this.f13821c = r14;     // Catch: IOException -> L15 XmlPullParserException -> L17
        if (b.l(r14) == null) goto L72;
        b.l(this.f13821c).x(this.f13835q);     // Catch: IOException -> L15 XmlPullParserException -> L17
    L72:
        if (b.e(r14) == false) goto L79;
        if (b.a(r14) != (-1)) goto L76;
        this.f13824f = r14;     // Catch: IOException -> L15 XmlPullParserException -> L17
    L77:
        this.f13823e.remove(r14);     // Catch: IOException -> L15 XmlPullParserException -> L17
        goto L79
    L76:
        this.f13825g.add(r14);     // Catch: IOException -> L15 XmlPullParserException -> L17
        goto L77
    L78:
        O(r10, r12);     // Catch: IOException -> L15 XmlPullParserException -> L17
        goto L79
    L13:
        if (r16.equals("include") == false) goto L46;
        r15 = 6;
        goto L47
    L20:
        if (r16.equals("StateSet") == false) goto L46;
        r15 = 4;
        goto L47
    L23:
        if (r16.equals("MotionScene") == false) goto L46;
        r15 = 0;
        goto L47
    L26:
        if (r16.equals("OnSwipe") == false) goto L46;
        r15 = 2;
        goto L47
    L29:
        if (r16.equals("OnClick") == false) goto L46;
        r15 = 3;
        goto L47
    L32:
        if (r16.equals("Transition") == false) goto L46;
    L35:
        if (r16.equals("ViewTransition") == false) goto L46;
        r15 = 9;
        goto L47
    L38:
        if (r16.equals("Include") == false) goto L46;
        r15 = 7;
        goto L47
    L41:
        if (r16.equals("KeyFrameSet") == false) goto L46;
        r15 = 8;
        goto L47
    L44:
        if (r16.equals("ConstraintSet") == false) goto L46;
        r15 = 5;
    L79:
        r13 = r12.next();     // Catch: IOException -> L15 XmlPullParserException -> L17
    L105:
        return;
    L15:
        e = move-exception;
        Log.e("MotionScene", "Error parsing resource: " + r11, e);
        return;
    L17:
        e = move-exception;
        Log.e("MotionScene", "Error parsing resource: " + r11, e);
    }

    public final int L(Context r18, XmlPullParser r19) {
        com.obric.oui.constraintlayout.widget.a r10 = new com.obric.oui.constraintlayout.widget.a();
        r10.P(false);
        int r11 = r19.getAttributeCount();
        int r12 = 0;
        int r13 = -1;
        int r14 = -1;
    L3:
        if (r12 >= r11) goto L62;
        String r15 = r19.getAttributeName(r12);
        String r16 = r19.getAttributeValue(r12);
        r15.hashCode();
        switch(r15.hashCode()) {
            case -1496482599: goto L20;
            case -1153153640: goto L16;
            case 3355: goto L12;
            case 973381616: goto L8;
            default: goto L6;
        };
    L6:
        byte r17 = -1;
    L23:
        switch(r17) {
            case 0: goto L59;
            case 1: goto L71;
            case 2: goto L26;
            case 3: goto L25;
            default: goto L60;
        };
    L25:
        r10.R(r16);
        goto L60
    L26:
        r13 = r(r18, r16);
        this.f13827i.put(a0(r16), Integer.valueOf(r13));
        r10.f14165b = com.obric.oui.constraintlayout.motion.widget.a.c(r18, r13);
        goto L60
    L59:
        r14 = r(r18, r16);
        goto L60
    L71:
        r10.f14168e = Integer.parseInt(r16);     // Catch: NumberFormatException -> L29
    L29:
        r16.hashCode();
        switch(r16.hashCode()) {
            case -768416914: goto L49;
            case 3317767: goto L45;
            case 3387192: goto L41;
            case 108511772: goto L37;
            case 1954540437: goto L33;
            default: goto L31;
        };
    L31:
        byte r110 = -1;
    L52:
        switch(r110) {
            case 0: goto L58;
            case 1: goto L57;
            case 2: goto L56;
            case 3: goto L55;
            case 4: goto L54;
            default: goto L60;
        };
    L54:
        r10.f14168e = 3;
        goto L60
    L55:
        r10.f14168e = 1;
        goto L60
    L56:
        r10.f14168e = 0;
        goto L60
    L57:
        r10.f14168e = 2;
        goto L60
    L58:
        r10.f14168e = 4;
        goto L60
    L33:
        if (r16.equals("x_right") == false) goto L31;
        r110 = 4;
        goto L52
    L37:
        if (r16.equals("right") == false) goto L31;
        r110 = 3;
        goto L52
    L41:
        if (r16.equals(SchedulerSupport.NONE) == false) goto L31;
        r110 = 2;
        goto L52
    L45:
        if (r16.equals("left") == false) goto L31;
        r110 = 1;
        goto L52
    L49:
        if (r16.equals("x_left") == false) goto L31;
        r110 = 0;
    L60:
        r12 = r12 + 1;
        goto L3
    L8:
        if (r15.equals("stateLabels") == false) goto L6;
        r17 = 3;
        goto L23
    L12:
        if (r15.equals("id") == false) goto L6;
        r17 = 2;
        goto L23
    L16:
        if (r15.equals("constraintRotate") == false) goto L6;
        r17 = 1;
        goto L23
    L20:
        if (r15.equals("deriveConstraintsFrom") == false) goto L6;
        r17 = 0;
        goto L23
    L62:
        if (r13 != (-1)) goto L64;
    L70:
        return r13;
    L64:
        if (this.f13819a.W == 0) goto L66;
        r10.S(true);
    L66:
        r10.C(r18, r19);
        if (r14 == (-1)) goto L69;
        this.f13828j.put(r13, r14);
    L69:
        this.f13826h.put(r13, r10);
        goto L70
    }

    public final int M(Context r10, int r11) {
        XmlResourceParser r12 = r10.getResources().getXml(r11);
        int r13 = r12.getEventType();     // Catch: IOException -> L12 XmlPullParserException -> L14
    L5:
        if (r13 == 1) goto L29;
        String r14 = r12.getName();     // Catch: IOException -> L12 XmlPullParserException -> L14
        if (2 != r13) goto L16;
        if ("ConstraintSet".equals(r14) == false) goto L16;
        return L(r10, r12);
    L16:
        r13 = r12.next();     // Catch: IOException -> L12 XmlPullParserException -> L14
        goto L5
    L29:
        return -1;
    L12:
        e = move-exception;
        Log.e("MotionScene", "Error parsing resource: " + r11, e);
        return -1;
    L14:
        e = move-exception;
        Log.e("MotionScene", "Error parsing resource: " + r11, e);
        return -1;
    }

    public final void N(Context r10, XmlPullParser r11) {
        TypedArray r12 = r10.obtainStyledAttributes(Xml.asAttributeSet(r11), R$styleable.include);
        int r13 = r12.getIndexCount();
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        int r15 = r12.getIndex(r14);
        if (r15 != R$styleable.include_constraintSet) goto L7;
        M(r10, r12.getResourceId(r15, -1));
    L7:
        r14 = r14 + 1;
        goto L3
    L8:
        r12.recycle();
    }

    public final void O(Context r10, XmlPullParser r11) {
        TypedArray r12 = r10.obtainStyledAttributes(Xml.asAttributeSet(r11), R$styleable.MotionScene);
        int r13 = r12.getIndexCount();
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L13;
        int r15 = r12.getIndex(r14);
        if (r15 != R$styleable.MotionScene_defaultDuration) goto L10;
        int r16 = r12.getInt(r15, this.f13829k);
        this.f13829k = r16;
        if (r16 >= 8) goto L12;
        this.f13829k = 8;
    L12:
        r14 = r14 + 1;
        goto L3
    L10:
        if (r15 != R$styleable.MotionScene_layoutDuringTransition) goto L12;
        this.f13830l = r12.getInteger(r15, 0);
        goto L12
    L13:
        r12.recycle();
    }

    public void P(float r10, float r11) {
        b r12 = this.f13821c;
        if (r12 != null) goto L5;
        return;
    L5:
        if (b.l(r12) == null) goto L9;
        b.l(this.f13821c).u(r10, r11);
        return;
    }

    public void Q(float r10, float r11) {
        b r12 = this.f13821c;
        if (r12 != null) goto L5;
        return;
    L5:
        if (b.l(r12) == null) goto L9;
        b.l(this.f13821c).v(r10, r11);
        return;
    }

    public void R(MotionEvent r12, int r13, MotionLayout r14) {
        RectF r10 = new RectF();
        if (this.f13834p != null) goto L5;
        this.f13834p = this.f13819a.q0();
    L5:
        this.f13834p.addMovement(r12);
        if (r13 == (-1)) goto L47;
        int r11 = r12.getAction();
        boolean r15 = false;
        if (r11 != 0) goto L10;
        this.f13837s = r12.getRawX();
        this.f13838t = r12.getRawY();
        this.f13831m = r12;
        this.f13832n = false;
        if (b.l(this.f13821c) == null) goto L65;
        RectF r16 = b.l(this.f13821c).f(this.f13819a, r10);
        if (r16 != null) goto L35;
    L38:
        RectF r17 = b.l(this.f13821c).p(this.f13819a, r10);
        if (r17 != null) goto L41;
    L43:
        this.f13833o = false;
    L44:
        b.l(this.f13821c).w(this.f13837s, this.f13838t);
        return;
    L41:
        if (r17.contains(this.f13831m.getX(), this.f13831m.getY()) == true) goto L43;
        this.f13833o = true;
        goto L44
    L35:
        if (r16.contains(this.f13831m.getX(), this.f13831m.getY()) == true) goto L38;
        this.f13831m = null;
        this.f13832n = true;
        return;
    L65:
        return;
    L10:
        if (r11 != 2) goto L47;
        if (this.f13832n == true) goto L47;
        float r18 = r12.getRawY() - this.f13838t;
        float r19 = r12.getRawX() - this.f13837s;
        if (r19 == 0.0d) goto L18;
    L19:
        MotionEvent r20 = this.f13831m;
        if (r20 == null) goto L64;
        b r21 = i(r13, r19, r18, r20);
        if (r21 == null) goto L47;
        r14.setTransition(r21);
        RectF r22 = b.l(this.f13821c).p(this.f13819a, r10);
        if (r22 != null) goto L27;
    L29:
        this.f13833o = r15;
        b.l(this.f13821c).z(this.f13837s, this.f13838t);
        goto L47
    L27:
        if (r22.contains(this.f13831m.getX(), this.f13831m.getY()) == true) goto L29;
        r15 = true;
        goto L29
    L64:
        return;
    L18:
        if (r18 != 0.0d) goto L19;
        return;
    L47:
        if (this.f13832n == false) goto L49;
        return;
    L49:
        b r23 = this.f13821c;
        if (r23 != null) goto L52;
    L56:
        this.f13837s = r12.getRawX();
        this.f13838t = r12.getRawY();
        if (r12.getAction() != 1) goto L66;
        MotionLayout.MotionTracker r110 = this.f13834p;
        if (r110 == null) goto L67;
        r110.recycle();
        this.f13834p = null;
        int r111 = r14.E;
        if (r111 == (-1)) goto L68;
        h(r14, r111);
        return;
    L68:
        return;
    L67:
        return;
    L66:
        return;
    L52:
        if (b.l(r23) == null) goto L56;
        if (this.f13833o == true) goto L56;
        b.l(this.f13821c).s(r12, this.f13834p, r13, this);
        goto L56
    }

    public final void S(int r10, MotionLayout r11) {
        com.obric.oui.constraintlayout.widget.a r12 = (com.obric.oui.constraintlayout.widget.a) this.f13826h.get(r10);
        r12.f14166c = r12.f14165b;
        int r13 = this.f13828j.get(r10);
        if (r13 <= 0) goto L9;
        S(r13, r11);
        com.obric.oui.constraintlayout.widget.a r14 = (com.obric.oui.constraintlayout.widget.a) this.f13826h.get(r13);
        if (r14 != null) goto L8;
        Log.e("MotionScene", "ERROR! invalid deriveConstraintsFrom: @id/" + com.obric.oui.constraintlayout.motion.widget.a.c(this.f13819a.getContext(), r13));
        return;
    L8:
        r12.f14166c += LibrarianImpl.Constants.SEPARATOR + r14.f14166c;
        r12.K(r14);
    L10:
        r12.h(r12);
        return;
    L9:
        r12.f14166c += "  layout";
        r12.J(r11);
        goto L10
    }

    public void T(MotionLayout r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.f13826h.size()) goto L10;
        int r12 = this.f13826h.keyAt(r11);
        if (I(r12) == true) goto L7;
        S(r12, r10);
        r11 = r11 + 1;
        goto L4
    L7:
        Log.e("MotionScene", "Cannot be derived from yourself");
        return;
    }

    public void U(int r10, com.obric.oui.constraintlayout.widget.a r11) {
        this.f13826h.put(r10, r11);
    }

    public void V(int r10) {
        b r11 = this.f13821c;
        if (r11 == null) goto L5;
        r11.E(r10);
        return;
    L5:
        this.f13829k = r10;
    }

    public void W(boolean r10) {
        this.f13835q = r10;
        b r11 = this.f13821c;
        if (r11 != null) goto L5;
        return;
    L5:
        if (b.l(r11) == null) goto L9;
        b.l(this.f13821c).x(this.f13835q);
        return;
    }

    public void X(int r10, int r11) {
        zc.c r12 = this.f13820b;
        if (r12 == null) goto L12;
        int r13 = r12.c(r10, -1, -1);
        if (r13 != (-1)) goto L8;
        r13 = r10;
    L8:
        int r14 = this.f13820b.c(r11, -1, -1);
        if (r14 != (-1)) goto L13;
    L11:
        r14 = r11;
    L13:
        b r15 = this.f13821c;
        if (r15 != null) goto L16;
    L20:
        Iterator r16 = this.f13823e.iterator();
    L22:
        if (r16.hasNext() == false) goto L37;
        b r17 = (b) r16.next();
        if (b.a(r17) != r14) goto L28;
        if (b.c(r17) != r13) goto L28;
    L31:
        this.f13821c = r17;
        if (r17 != null) goto L34;
        return;
    L34:
        if (b.l(r17) == null) goto L61;
        b.l(this.f13821c).x(this.f13835q);
        return;
    L61:
        return;
    L28:
        if (b.a(r17) != r11) goto L22;
        if (b.c(r17) != r10) goto L22;
    L37:
        b r18 = this.f13824f;
        Iterator r19 = this.f13825g.iterator();
    L39:
        if (r19.hasNext() == false) goto L43;
        b r20 = (b) r19.next();
        if (b.a(r20) != r11) goto L39;
        r18 = r20;
        goto L39
    L43:
        b r21 = new b(this, r18);
        b.d(r21, r13);
        b.b(r21, r14);
        if (r13 == (-1)) goto L46;
        this.f13823e.add(r21);
    L46:
        this.f13821c = r21;
        return;
    L16:
        if (b.a(r15) != r11) goto L20;
        if (b.c(this.f13821c) != r10) goto L20;
        return;
    L12:
        r13 = r10;
        goto L11
    }

    public void Y(b r10) {
        this.f13821c = r10;
        if (r10 != null) goto L5;
        return;
    L5:
        if (b.l(r10) == null) goto L9;
        b.l(this.f13821c).x(this.f13835q);
        return;
    }

    public void Z() {
        b r10 = this.f13821c;
        if (r10 != null) goto L5;
        return;
    L5:
        if (b.l(r10) == null) goto L9;
        b.l(this.f13821c).A();
        return;
    }

    public boolean b0() {
        Iterator r10 = this.f13823e.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        if (b.l((b) r10.next()) == null) goto L4;
        return true;
    L8:
        b r11 = this.f13821c;
        if (r11 != null) goto L11;
    L13:
        return false;
    L11:
        if (b.l(r11) == null) goto L13;
        return true;
    }

    public void c0(int r10, View... r11) {
        this.f13836r.i(r10, r11);
    }

    public void f(MotionLayout r10, int r11) {
        Iterator r12 = this.f13823e.iterator();
    L4:
        if (r12.hasNext() == false) goto L11;
        b r13 = (b) r12.next();
        if (b.p(r13).size() <= 0) goto L4;
        Iterator r14 = b.p(r13).iterator();
    L9:
        if (r14.hasNext() == false) goto L4;
        ((b.a) r14.next()).c(r10);
        goto L9
    L11:
        Iterator r15 = this.f13825g.iterator();
    L13:
        if (r15.hasNext() == false) goto L20;
        b r16 = (b) r15.next();
        if (b.p(r16).size() <= 0) goto L13;
        Iterator r17 = b.p(r16).iterator();
    L18:
        if (r17.hasNext() == false) goto L13;
        ((b.a) r17.next()).c(r10);
        goto L18
    L20:
        Iterator r18 = this.f13823e.iterator();
    L22:
        if (r18.hasNext() == false) goto L29;
        b r19 = (b) r18.next();
        if (b.p(r19).size() <= 0) goto L22;
        Iterator r20 = b.p(r19).iterator();
    L27:
        if (r20.hasNext() == false) goto L22;
        ((b.a) r20.next()).a(r10, r11, r19);
        goto L27
    L29:
        Iterator r21 = this.f13825g.iterator();
    L31:
        if (r21.hasNext() == false) goto L38;
        b r22 = (b) r21.next();
        if (b.p(r22).size() <= 0) goto L31;
        Iterator r23 = b.p(r22).iterator();
    L36:
        if (r23.hasNext() == false) goto L31;
        ((b.a) r23.next()).a(r10, r11, r22);
        goto L36
    }

    public boolean g(int r10, l r11) {
        return this.f13836r.e(r10, r11);
    }

    public boolean h(MotionLayout r10, int r11) {
        if (J() == false) goto L6;
        return false;
    L6:
        if (this.f13822d == false) goto L8;
        return false;
    L8:
        Iterator r12 = this.f13823e.iterator();
    L10:
        if (r12.hasNext() == false) goto L41;
        b r13 = (b) r12.next();
        if (b.r(r13) == 0) goto L10;
        b r14 = this.f13821c;
        if (r14 != r13) goto L20;
        if (r14.D(2) == true) goto L10;
    L20:
        if (r11 != b.c(r13)) goto L31;
        if (b.r(r13) == 4) goto L25;
        if (b.r(r13) != 2) goto L31;
    L25:
        MotionLayout.TransitionState r15 = MotionLayout.TransitionState.FINISHED;
        r10.setState(r15);
        r10.setTransition(r13);
        if (b.r(r13) != 4) goto L28;
        r10.A0();
        r10.setState(MotionLayout.TransitionState.SETUP);
        r10.setState(MotionLayout.TransitionState.MOVING);
    L29:
        return true;
    L28:
        r10.setProgress(1.0f);
        r10.c0(true);
        r10.setState(MotionLayout.TransitionState.SETUP);
        r10.setState(MotionLayout.TransitionState.MOVING);
        r10.setState(r15);
        r10.r0();
    L31:
        if (r11 != b.a(r13)) goto L10;
        if (b.r(r13) == 3) goto L36;
        if (b.r(r13) != 1) goto L10;
    L36:
        MotionLayout.TransitionState r16 = MotionLayout.TransitionState.FINISHED;
        r10.setState(r16);
        r10.setTransition(r13);
        if (b.r(r13) != 3) goto L39;
        r10.C0();
        r10.setState(MotionLayout.TransitionState.SETUP);
        r10.setState(MotionLayout.TransitionState.MOVING);
    L40:
        return true;
    L39:
        r10.setProgress(0.0f);
        r10.c0(true);
        r10.setState(MotionLayout.TransitionState.SETUP);
        r10.setState(MotionLayout.TransitionState.MOVING);
        r10.setState(r16);
        r10.r0();
        goto L40
    L41:
        return false;
    }

    public b i(int r17, float r18, float r19, MotionEvent r20) {
        if (r17 == (-1)) goto L38;
        List r10 = H(r17);
        RectF r11 = new RectF();
        Iterator r12 = r10.iterator();
        float r13 = 0.0f;
        b r14 = null;
    L6:
        if (r12.hasNext() == false) goto L36;
        b r15 = (b) r12.next();
        if (b.q(r15) == true) goto L6;
        if (b.l(r15) == null) goto L6;
        b.l(r15).x(this.f13835q);
        RectF r16 = b.l(r15).p(this.f13819a, r11);
        if (r16 == null) goto L18;
        if (r20 == null) goto L18;
        if (r16.contains(r20.getX(), r20.getY()) == false) goto L6;
    L18:
        RectF r21 = b.l(r15).f(this.f13819a, r11);
        if (r21 == null) goto L24;
        if (r20 == null) goto L24;
        if (r21.contains(r20.getX(), r20.getY()) == false) goto L6;
    L24:
        float r22 = b.l(r15).a(r18, r19);
        if (b.l(r15).f13873l == false) goto L29;
        if (r20 == null) goto L29;
        float r23 = r20.getX() - b.l(r15).f13870i;
        float r110 = r20.getY() - b.l(r15).f13871j;
        r22 = ((float) (Math.atan2(r19 + r110, r18 + r23) - Math.atan2(r23, r110))) * 10.0f;
    L29:
        if (b.a(r15) != r17) goto L32;
        float r111 = -1.0f;
    L31:
        float r24 = r22 * r111;
        if (r24 <= r13) goto L6;
        r14 = r15;
        r13 = r24;
        goto L6
    L32:
        r111 = 1.1f;
        goto L31
    L36:
        return r14;
    L38:
        return this.f13821c;
    }

    public int j() {
        b r10 = this.f13821c;
        if (r10 != null) goto L7;
        return -1;
    L7:
        return b.k(r10);
    }

    public int k() {
        b r10 = this.f13821c;
        if (r10 != null) goto L5;
        return 0;
    L5:
        if (b.l(r10) != null) goto L7;
        return 0;
    L7:
        return b.l(this.f13821c).d();
    }

    public com.obric.oui.constraintlayout.widget.a l(int r10) {
        return m(r10, -1, -1);
    }

    public com.obric.oui.constraintlayout.widget.a m(int r10, int r11, int r12) {
        zc.c r13 = this.f13820b;
        if (r13 == null) goto L8;
        int r14 = r13.c(r10, r11, r12);
        if (r14 == (-1)) goto L8;
        r10 = r14;
    L8:
        if (this.f13826h.get(r10) != null) goto L12;
        Log.e("MotionScene", "Warning could not find ConstraintSet id/" + com.obric.oui.constraintlayout.motion.widget.a.c(this.f13819a.getContext(), r10) + " In MotionScene");
        SparseArray r15 = this.f13826h;
        return (com.obric.oui.constraintlayout.widget.a) r15.get(r15.keyAt(0));
    L12:
        return (com.obric.oui.constraintlayout.widget.a) this.f13826h.get(r10);
    }

    public int[] n() {
        int r10 = this.f13826h.size();
        int[] r11 = new int[r10];
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L5;
        r11[r12] = this.f13826h.keyAt(r12);
        r12 = r12 + 1;
        goto L3
    L5:
        return r11;
    }

    public ArrayList o() {
        return this.f13823e;
    }

    public int p() {
        b r10 = this.f13821c;
        if (r10 == null) goto L7;
        return b.j(r10);
    L7:
        return this.f13829k;
    }

    public int q() {
        b r10 = this.f13821c;
        if (r10 != null) goto L7;
        return -1;
    L7:
        return b.a(r10);
    }

    public final int r(Context r10, String r11) {
        if (r11.contains(LibrarianImpl.Constants.SEPARATOR) == false) goto L5;
        int r12 = r10.getResources().getIdentifier(r11.substring(r11.indexOf(47) + 1), "id", r10.getPackageName());
    L6:
        if (r12 == (-1)) goto L8;
        return r12;
    L8:
        if (r11.length() > 1) goto L13;
        Log.e("MotionScene", "error in parsing id");
        return r12;
    L13:
        return Integer.parseInt(r11.substring(1));
    L5:
        r12 = -1;
        goto L6
    }

    public Interpolator s() {
        int r10 = b.g(this.f13821c);
        if (r10 == (-2)) goto L34;
        if (r10 == (-1)) goto L32;
        if (r10 == 0) goto L30;
        if (r10 == 1) goto L28;
        if (r10 == 2) goto L26;
        if (r10 == 4) goto L24;
        if (r10 == 5) goto L22;
        if (r10 == 6) goto L20;
        return null;
    L20:
        return new AnticipateInterpolator();
    L22:
        return new OvershootInterpolator();
    L24:
        return new BounceInterpolator();
    L26:
        return new DecelerateInterpolator();
    L28:
        return new AccelerateInterpolator();
    L30:
        return new AccelerateDecelerateInterpolator();
    L32:
        return new a(this, vc.c.c(b.h(this.f13821c)));
    L34:
        return AnimationUtils.loadInterpolator(this.f13819a.getContext(), b.i(this.f13821c));
    }

    public void t(l r10) {
        b r11 = this.f13821c;
        if (r11 != null) goto L11;
        b r12 = this.f13824f;
        if (r12 == null) goto L10;
        Iterator r13 = b.f(r12).iterator();
    L8:
        if (r13.hasNext() == false) goto L18;
        ((f) r13.next()).b(r10);
        goto L8
    L18:
        return;
    L10:
        return;
    L11:
        Iterator r14 = b.f(r11).iterator();
    L13:
        if (r14.hasNext() == false) goto L15;
        ((f) r14.next()).b(r10);
        goto L13
    }

    public float u() {
        b r10 = this.f13821c;
        if (r10 != null) goto L5;
        return 0.0f;
    L5:
        if (b.l(r10) != null) goto L7;
        return 0.0f;
    L7:
        return b.l(this.f13821c).g();
    }

    public float v() {
        b r10 = this.f13821c;
        if (r10 != null) goto L5;
        return 0.0f;
    L5:
        if (b.l(r10) != null) goto L7;
        return 0.0f;
    L7:
        return b.l(this.f13821c).h();
    }

    public boolean w() {
        b r10 = this.f13821c;
        if (r10 != null) goto L5;
        return false;
    L5:
        if (b.l(r10) != null) goto L7;
        return false;
    L7:
        return b.l(this.f13821c).i();
    }

    public float x(float r10, float r11) {
        b r12 = this.f13821c;
        if (r12 != null) goto L5;
        return 0.0f;
    L5:
        if (b.l(r12) != null) goto L7;
        return 0.0f;
    L7:
        return b.l(this.f13821c).j(r10, r11);
    }

    public final int y(int r10) {
        zc.c r11 = this.f13820b;
        if (r11 == null) goto L7;
        int r12 = r11.c(r10, -1, -1);
        if (r12 == (-1)) goto L7;
        return r12;
    L7:
        return r10;
    }

    public int z() {
        b r10 = this.f13821c;
        if (r10 != null) goto L5;
        return 0;
    L5:
        if (b.l(r10) != null) goto L7;
        return 0;
    L7:
        return b.l(this.f13821c).k();
    }
}

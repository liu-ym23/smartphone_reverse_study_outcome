package androidx.constraintlayout.motion.widget;

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
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R$id;
import androidx.constraintlayout.widget.R$styleable;
import com.bytedance.librarian.LibrarianImpl;
import io.reactivex.annotations.SchedulerSupport;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MotionLayout f1947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public androidx.constraintlayout.widget.a f1948b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f1949c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1950d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList f1951e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f1952f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ArrayList f1953g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SparseArray f1954h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public HashMap f1955i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public SparseIntArray f1956j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f1957k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f1958l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f1959m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public MotionEvent f1960n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f1961o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f1962p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public MotionLayout.MotionTracker f1963q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f1964r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final s f1965s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f1966t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f1967u;

    public class a implements Interpolator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p001j.c f1968a;

        public a(o r10, p001j.c r11) {
            this.f1968a = r11;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float r10) {
            return (float) this.f1968a.a(r10);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1969a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f1970b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1971c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f1972d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f1973e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f1974f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f1975g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f1976h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f1977i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final o f1978j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public ArrayList f1979k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public p f1980l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public ArrayList f1981m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f1982n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f1983o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f1984p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f1985q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f1986r;

        public static class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final b f1987a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f1988b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f1989c;

            public a(Context r10, b r11, XmlPullParser r12) {
                this.f1988b = -1;
                this.f1989c = 17;
                this.f1987a = r11;
                TypedArray r13 = r10.obtainStyledAttributes(Xml.asAttributeSet(r12), R$styleable.OnClick);
                int r14 = r13.getIndexCount();
                int r15 = 0;
            L3:
                if (r15 >= r14) goto L11;
                int r16 = r13.getIndex(r15);
                if (r16 != R$styleable.OnClick_targetId) goto L8;
                this.f1988b = r13.getResourceId(r16, this.f1988b);
            L10:
                r15 = r15 + 1;
                goto L3
            L8:
                if (r16 != R$styleable.OnClick_clickAction) goto L10;
                this.f1989c = r13.getInt(r16, this.f1989c);
                goto L10
            L11:
                r13.recycle();
            }

            public void a(MotionLayout r10, int r11, b r12) {
                int r13 = this.f1988b;
                View r14 = r10;
                if (r13 == (-1)) goto L6;
                r14 = r10.findViewById(r13);
            L6:
                if (r14 != null) goto L9;
                Log.e("MotionScene", "OnClick could not find id " + this.f1988b);
                return;
            L9:
                int r15 = b.c(r12);
                int r16 = b.a(r12);
                if (r15 != (-1)) goto L13;
                r14.setOnClickListener(this);
                return;
            L13:
                int r17 = this.f1989c;
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
                b r12 = this.f1987a;
                if (r12 != r10) goto L5;
                return true;
            L5:
                int r13 = b.a(r12);
                int r14 = b.c(this.f1987a);
                if (r14 == (-1)) goto L8;
                int r15 = r11.f1736f;
                if (r15 == r14) goto L19;
                if (r15 != r13) goto L17;
                return true;
            L17:
                return false;
            L19:
                return true;
            L8:
                if (r11.f1736f == r13) goto L11;
                return true;
            L11:
                return false;
            }

            public void c(MotionLayout r10) {
                int r11 = this.f1988b;
                if (r11 != (-1)) goto L5;
                return;
            L5:
                View r12 = r10.findViewById(r11);
                if (r12 != null) goto L9;
                Log.e("MotionScene", " (*)  could not find id " + this.f1988b);
                return;
            L9:
                r12.setOnClickListener(null);
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View r10) {
                MotionLayout r11 = o.d(b.s(this.f1987a));
                if (r11.X() == true) goto L6;
                return;
            L6:
                if (b.c(this.f1987a) != (-1)) goto L13;
                int r12 = r11.getCurrentState();
                if (r12 != (-1)) goto L11;
                r11.l0(b.a(this.f1987a));
                return;
            L11:
                b r13 = new b(b.s(this.f1987a), this.f1987a);
                b.d(r13, r12);
                b.b(r13, b.a(this.f1987a));
                r11.setTransition(r13);
                r11.i0();
                return;
            L13:
                b r14 = b.s(this.f1987a).f1949c;
                int r15 = this.f1989c;
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
                b r19 = b.s(this.f1987a).f1949c;
                b r20 = this.f1987a;
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
                if ((this.f1989c & 4096) == 0) goto L63;
                r11.setTransition(this.f1987a);
                r11.setProgress(0.0f);
                return;
            L63:
                return;
            L51:
                if ((this.f1989c & 256) == 0) goto L53;
                r11.setTransition(this.f1987a);
                r11.setProgress(1.0f);
                return;
            L47:
                if ((this.f1989c & 16) == 0) goto L49;
                r11.setTransition(this.f1987a);
                r11.k0();
                return;
            L43:
                if ((this.f1989c & 1) == 0) goto L45;
                r11.setTransition(this.f1987a);
                r11.i0();
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
            this.f1969a = -1;
            this.f1970b = false;
            this.f1971c = -1;
            this.f1972d = -1;
            this.f1973e = 0;
            this.f1974f = null;
            this.f1975g = -1;
            this.f1976h = 400;
            this.f1977i = 0.0f;
            this.f1979k = new ArrayList();
            this.f1980l = null;
            this.f1981m = new ArrayList();
            this.f1982n = 0;
            this.f1983o = false;
            this.f1984p = -1;
            this.f1985q = 0;
            this.f1986r = 0;
            this.f1978j = r10;
            this.f1976h = o.e(r10);
            if (r11 == null) goto L6;
            this.f1984p = r11.f1984p;
            this.f1973e = r11.f1973e;
            this.f1974f = r11.f1974f;
            this.f1975g = r11.f1975g;
            this.f1976h = r11.f1976h;
            this.f1979k = r11.f1979k;
            this.f1977i = r11.f1977i;
            this.f1985q = r11.f1985q;
            return;
        }

        public static /* synthetic */ int a(b r10) {
            return r10.f1971c;
        }

        public static /* synthetic */ int b(b r10, int r11) {
            r10.f1971c = r11;
            return r11;
        }

        public static /* synthetic */ int c(b r10) {
            return r10.f1972d;
        }

        public static /* synthetic */ int d(b r10, int r11) {
            r10.f1972d = r11;
            return r11;
        }

        public static /* synthetic */ boolean e(b r10) {
            return r10.f1970b;
        }

        public static /* synthetic */ ArrayList f(b r10) {
            return r10.f1979k;
        }

        public static /* synthetic */ int g(b r10) {
            return r10.f1973e;
        }

        public static /* synthetic */ String h(b r10) {
            return r10.f1974f;
        }

        public static /* synthetic */ int i(b r10) {
            return r10.f1975g;
        }

        public static /* synthetic */ int j(b r10) {
            return r10.f1976h;
        }

        public static /* synthetic */ int k(b r10) {
            return r10.f1984p;
        }

        public static /* synthetic */ p l(b r10) {
            return r10.f1980l;
        }

        public static /* synthetic */ float m(b r10) {
            return r10.f1977i;
        }

        public static /* synthetic */ p n(b r10, p r11) {
            r10.f1980l = r11;
            return r11;
        }

        public static /* synthetic */ int o(b r10) {
            return r10.f1969a;
        }

        public static /* synthetic */ ArrayList p(b r10) {
            return r10.f1981m;
        }

        public static /* synthetic */ boolean q(b r10) {
            return r10.f1983o;
        }

        public static /* synthetic */ int r(b r10) {
            return r10.f1982n;
        }

        public static /* synthetic */ o s(b r10) {
            return r10.f1978j;
        }

        public int A() {
            return this.f1972d;
        }

        public p B() {
            return this.f1980l;
        }

        public boolean C() {
            return !this.f1983o;
        }

        public boolean D(int r10) {
            if ((this.f1986r & r10) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public void E(int r10) {
            this.f1976h = Math.max(r10, 8);
        }

        public void F(boolean r10) {
            this.f1983o = !r10;
        }

        public void G(int r10, String r11, int r12) {
            this.f1973e = r10;
            this.f1974f = r11;
            this.f1975g = r12;
        }

        public void H(int r10) {
            p r11 = B();
            if (r11 == null) goto L6;
            r11.y(r10);
            return;
        }

        public void I(int r10) {
            this.f1984p = r10;
        }

        public void t(f r10) {
            this.f1979k.add(r10);
        }

        public void u(Context r10, XmlPullParser r11) {
            this.f1981m.add(new a(r10, this, r11));
        }

        public final void v(o r10, Context r11, TypedArray r12) {
            int r13 = r12.getIndexCount();
            int r14 = 0;
        L4:
            if (r14 >= r13) goto L65;
            int r15 = r12.getIndex(r14);
            if (r15 != R$styleable.Transition_constraintSetEnd) goto L14;
            this.f1971c = r12.getResourceId(r15, -1);
            String r16 = r11.getResources().getResourceTypeName(this.f1971c);
            if ("layout".equals(r16) == false) goto L11;
            ConstraintSet r17 = new ConstraintSet();
            r17.I(r11, this.f1971c);
            o.b(r10).append(this.f1971c, r17);
        L63:
            r14 = r14 + 1;
            goto L4
        L11:
            if ("xml".equals(r16) == false) goto L63;
            this.f1971c = o.c(r10, r11, this.f1971c);
            goto L63
        L14:
            if (r15 != R$styleable.Transition_constraintSetStart) goto L22;
            this.f1972d = r12.getResourceId(r15, this.f1972d);
            String r18 = r11.getResources().getResourceTypeName(this.f1972d);
            if ("layout".equals(r18) == false) goto L19;
            ConstraintSet r19 = new ConstraintSet();
            r19.I(r11, this.f1972d);
            o.b(r10).append(this.f1972d, r19);
            goto L63
        L19:
            if ("xml".equals(r18) == false) goto L63;
            this.f1972d = o.c(r10, r11, this.f1972d);
            goto L63
        L22:
            if (r15 != R$styleable.Transition_motionInterpolator) goto L38;
            int r20 = r12.peekValue(r15).type;
            if (r20 != 1) goto L29;
            int r21 = r12.getResourceId(r15, -1);
            this.f1975g = r21;
            if (r21 == (-1)) goto L63;
            this.f1973e = -2;
            goto L63
        L29:
            if (r20 != 3) goto L36;
            String r22 = r12.getString(r15);
            this.f1974f = r22;
            if (r22 == null) goto L63;
            if (r22.indexOf(LibrarianImpl.Constants.SEPARATOR) <= 0) goto L35;
            this.f1975g = r12.getResourceId(r15, -1);
            this.f1973e = -2;
            goto L63
        L35:
            this.f1973e = -1;
            goto L63
        L36:
            this.f1973e = r12.getInteger(r15, this.f1973e);
            goto L63
        L38:
            if (r15 != R$styleable.Transition_duration) goto L43;
            int r23 = r12.getInt(r15, this.f1976h);
            this.f1976h = r23;
            if (r23 >= 8) goto L63;
            this.f1976h = 8;
            goto L63
        L43:
            if (r15 != R$styleable.Transition_staggered) goto L46;
            this.f1977i = r12.getFloat(r15, this.f1977i);
            goto L63
        L46:
            if (r15 != R$styleable.Transition_autoTransition) goto L49;
            this.f1982n = r12.getInteger(r15, this.f1982n);
            goto L63
        L49:
            if (r15 != R$styleable.Transition_android_id) goto L52;
            this.f1969a = r12.getResourceId(r15, this.f1969a);
            goto L63
        L52:
            if (r15 != R$styleable.Transition_transitionDisable) goto L55;
            this.f1983o = r12.getBoolean(r15, this.f1983o);
            goto L63
        L55:
            if (r15 != R$styleable.Transition_pathMotionArc) goto L58;
            this.f1984p = r12.getInteger(r15, -1);
            goto L63
        L58:
            if (r15 != R$styleable.Transition_layoutDuringTransition) goto L61;
            this.f1985q = r12.getInteger(r15, 0);
            goto L63
        L61:
            if (r15 != R$styleable.Transition_transitionFlags) goto L63;
            this.f1986r = r12.getInteger(r15, 0);
            goto L63
        L65:
            if (this.f1972d != (-1)) goto L91;
            this.f1970b = true;
            return;
        }

        public final void w(o r10, Context r11, AttributeSet r12) {
            TypedArray r13 = r11.obtainStyledAttributes(r12, R$styleable.Transition);
            v(r10, r11, r13);
            r13.recycle();
        }

        public int x() {
            return this.f1982n;
        }

        public int y() {
            return this.f1971c;
        }

        public int z() {
            return this.f1985q;
        }

        public b(int r10, o r11, int r12, int r13) {
            this.f1969a = -1;
            this.f1970b = false;
            this.f1971c = -1;
            this.f1972d = -1;
            this.f1973e = 0;
            this.f1974f = null;
            this.f1975g = -1;
            this.f1976h = 400;
            this.f1977i = 0.0f;
            this.f1979k = new ArrayList();
            this.f1980l = null;
            this.f1981m = new ArrayList();
            this.f1982n = 0;
            this.f1983o = false;
            this.f1984p = -1;
            this.f1985q = 0;
            this.f1986r = 0;
            this.f1969a = r10;
            this.f1978j = r11;
            this.f1972d = r12;
            this.f1971c = r13;
            this.f1976h = o.e(r11);
            this.f1985q = o.a(r11);
        }

        public b(o r10, Context r11, XmlPullParser r12) {
            this.f1969a = -1;
            this.f1970b = false;
            this.f1971c = -1;
            this.f1972d = -1;
            this.f1973e = 0;
            this.f1974f = null;
            this.f1975g = -1;
            this.f1976h = 400;
            this.f1977i = 0.0f;
            this.f1979k = new ArrayList();
            this.f1980l = null;
            this.f1981m = new ArrayList();
            this.f1982n = 0;
            this.f1983o = false;
            this.f1984p = -1;
            this.f1985q = 0;
            this.f1986r = 0;
            this.f1976h = o.e(r10);
            this.f1985q = o.a(r10);
            this.f1978j = r10;
            w(r10, r11, Xml.asAttributeSet(r12));
        }
    }

    public o(Context r10, MotionLayout r11, int r12) {
        this.f1948b = null;
        this.f1949c = null;
        this.f1950d = false;
        this.f1951e = new ArrayList();
        this.f1952f = null;
        this.f1953g = new ArrayList();
        this.f1954h = new SparseArray();
        this.f1955i = new HashMap();
        this.f1956j = new SparseIntArray();
        this.f1957k = false;
        this.f1958l = 400;
        this.f1959m = 0;
        this.f1961o = false;
        this.f1962p = false;
        this.f1947a = r11;
        this.f1965s = new s(r11);
        L(r10, r12);
        SparseArray r13 = this.f1954h;
        int r14 = R$id.motion_base;
        r13.put(r14, new ConstraintSet());
        this.f1955i.put("motion_base", Integer.valueOf(r14));
    }

    public static /* synthetic */ int a(o r10) {
        return r10.f1959m;
    }

    public static /* synthetic */ SparseArray b(o r10) {
        return r10.f1954h;
    }

    public static /* synthetic */ int c(o r10, Context r11, int r12) {
        return r10.O(r11, r12);
    }

    public static /* synthetic */ MotionLayout d(o r10) {
        return r10.f1947a;
    }

    public static String d0(String r10) {
        if (r10 != null) goto L5;
        return "";
    L5:
        int r11 = r10.indexOf(47);
        if (r11 >= 0) goto L9;
        return r10;
    L9:
        return r10.substring(r11 + 1);
    }

    public static /* synthetic */ int e(o r10) {
        return r10.f1958l;
    }

    public float A() {
        b r10 = this.f1949c;
        if (r10 != null) goto L5;
        return 0.0f;
    L5:
        if (b.l(r10) != null) goto L7;
        return 0.0f;
    L7:
        return b.l(this.f1949c).l();
    }

    public float B() {
        b r10 = this.f1949c;
        if (r10 != null) goto L5;
        return 0.0f;
    L5:
        if (b.l(r10) != null) goto L7;
        return 0.0f;
    L7:
        return b.l(this.f1949c).m();
    }

    public float C() {
        b r10 = this.f1949c;
        if (r10 != null) goto L5;
        return 0.0f;
    L5:
        if (b.l(r10) != null) goto L7;
        return 0.0f;
    L7:
        return b.l(this.f1949c).n();
    }

    public float D() {
        b r10 = this.f1949c;
        if (r10 != null) goto L5;
        return 0.0f;
    L5:
        if (b.l(r10) != null) goto L7;
        return 0.0f;
    L7:
        return b.l(this.f1949c).o();
    }

    public float E() {
        b r10 = this.f1949c;
        if (r10 != null) goto L5;
        return 0.0f;
    L5:
        return b.m(r10);
    }

    public int F() {
        b r10 = this.f1949c;
        if (r10 != null) goto L7;
        return -1;
    L7:
        return b.c(r10);
    }

    public b G(int r10) {
        Iterator r11 = this.f1951e.iterator();
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
        Iterator r13 = this.f1951e.iterator();
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
        int r11 = this.f1956j.get(r10);
        int r12 = this.f1956j.size();
    L3:
        if (r11 <= 0) goto L11;
        if (r11 == r10) goto L6;
        int r13 = r12 - 1;
        if (r12 < 0) goto L9;
        r11 = this.f1956j.get(r11);
        r12 = r13;
        goto L3
    L9:
        return true;
    L6:
        return true;
    L11:
        return false;
    }

    public boolean J(View r10, int r11) {
        b r12 = this.f1949c;
        if (r12 != null) goto L5;
        return false;
    L5:
        Iterator r13 = b.f(r12).iterator();
    L7:
        if (r13.hasNext() == false) goto L15;
        Iterator r14 = ((f) r13.next()).d(r10.getId()).iterator();
    L10:
        if (r14.hasNext() == false) goto L7;
        if (((c) r14.next()).f1834a != r11) goto L10;
        return true;
    L15:
        return false;
    }

    public final boolean K() {
        if (this.f1963q == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void L(Context r10, int r11) {
        XmlResourceParser r12 = r10.getResources().getXml(r11);
        int r13 = r12.getEventType();     // Catch: IOException -> L13 XmlPullParserException -> L15
        b r14 = null;
    L4:
        byte r15 = 1;
        if (r13 == 1) goto L119;
        if (r13 != 0) goto L8;
        r12.getName();     // Catch: IOException -> L13 XmlPullParserException -> L15
    L83:
        r13 = r12.next();     // Catch: IOException -> L13 XmlPullParserException -> L15
    L8:
        if (r13 != 2) goto L83;
        String r16 = r12.getName();     // Catch: IOException -> L13 XmlPullParserException -> L15
        if (this.f1957k == false) goto L19;
        System.out.println("parsing = " + r16);     // Catch: IOException -> L13 XmlPullParserException -> L15
    L19:
        switch(r16.hashCode()) {
            case -1349929691: goto L49;
            case -1239391468: goto L46;
            case -687739768: goto L43;
            case 61998586: goto L40;
            case 269306229: goto L37;
            case 312750793: goto L34;
            case 327855227: goto L31;
            case 793277014: goto L28;
            case 1382829617: goto L25;
            case 1942574248: goto L22;
            default: goto L117;
        };
    L117:
        r15 = -1;
    L52:
        switch(r15) {
            case 0: goto L81;
            case 1: goto L67;
            case 2: goto L63;
            case 3: goto L61;
            case 4: goto L60;
            case 5: goto L59;
            case 6: goto L58;
            case 7: goto L58;
            case 8: goto L55;
            case 9: goto L54;
            default: goto L83;
        };     // Catch: IOException -> L13 XmlPullParserException -> L15
    L54:
        this.f1965s.b(new r(r10, r12));     // Catch: IOException -> L13 XmlPullParserException -> L15
        goto L83
    L55:
        f r17 = new f(r10, r12);     // Catch: IOException -> L13 XmlPullParserException -> L15
        if (r14 == null) goto L83;
        b.f(r14).add(r17);     // Catch: IOException -> L13 XmlPullParserException -> L15
        goto L83
    L58:
        P(r10, r12);     // Catch: IOException -> L13 XmlPullParserException -> L15
        goto L83
    L59:
        N(r10, r12);     // Catch: IOException -> L13 XmlPullParserException -> L15
        goto L83
    L60:
        this.f1948b = new androidx.constraintlayout.widget.a(r10, r12);     // Catch: IOException -> L13 XmlPullParserException -> L15
        goto L83
    L61:
        if (r14 == null) goto L83;
        r14.u(r10, r12);     // Catch: IOException -> L13 XmlPullParserException -> L15
        goto L83
    L63:
        if (r14 != null) goto L65;
        Log.v("MotionScene", " OnSwipe (" + r10.getResources().getResourceEntryName(r11) + ".xml:" + r12.getLineNumber() + ")");     // Catch: IOException -> L13 XmlPullParserException -> L15
    L65:
        if (r14 == null) goto L83;
        b.n(r14, new p(r10, this.f1947a, r12));     // Catch: IOException -> L13 XmlPullParserException -> L15
        goto L83
    L67:
        ArrayList r18 = this.f1951e;     // Catch: IOException -> L13 XmlPullParserException -> L15
        r14 = new b(this, r10, r12);     // Catch: IOException -> L13 XmlPullParserException -> L15
        r18.add(r14);     // Catch: IOException -> L13 XmlPullParserException -> L15
        if (this.f1949c != null) goto L75;
        if (b.e(r14) == true) goto L75;
        this.f1949c = r14;     // Catch: IOException -> L13 XmlPullParserException -> L15
        if (b.l(r14) == null) goto L75;
        b.l(this.f1949c).x(this.f1964r);     // Catch: IOException -> L13 XmlPullParserException -> L15
    L75:
        if (b.e(r14) == false) goto L83;
        if (b.a(r14) != (-1)) goto L79;
        this.f1952f = r14;     // Catch: IOException -> L13 XmlPullParserException -> L15
    L80:
        this.f1951e.remove(r14);     // Catch: IOException -> L13 XmlPullParserException -> L15
        goto L83
    L79:
        this.f1953g.add(r14);     // Catch: IOException -> L13 XmlPullParserException -> L15
        goto L80
    L81:
        Q(r10, r12);     // Catch: IOException -> L13 XmlPullParserException -> L15
        goto L83
    L22:
        if (r16.equals("include") == false) goto L51;
        r15 = 6;
        goto L52
    L51:
        r15 = -1;
        goto L52
    L25:
        if (r16.equals("StateSet") == false) goto L108;
        r15 = 4;
        goto L52
    L108:
        r15 = -1;
        goto L52
    L28:
        if (r16.equals("MotionScene") == false) goto L109;
        r15 = 0;
        goto L52
    L109:
        r15 = -1;
        goto L52
    L31:
        if (r16.equals("OnSwipe") == false) goto L110;
        r15 = 2;
        goto L52
    L110:
        r15 = -1;
        goto L52
    L34:
        if (r16.equals("OnClick") == false) goto L111;
        r15 = 3;
        goto L52
    L111:
        r15 = -1;
        goto L52
    L37:
        if (r16.equals("Transition") == true) goto L52;
        r15 = -1;
        goto L52
    L40:
        if (r16.equals("ViewTransition") == false) goto L113;
        r15 = 9;
        goto L52
    L113:
        r15 = -1;
        goto L52
    L43:
        if (r16.equals("Include") == false) goto L114;
        r15 = 7;
        goto L52
    L114:
        r15 = -1;
        goto L52
    L46:
        if (r16.equals("KeyFrameSet") == false) goto L115;
        r15 = 8;
        goto L52
    L115:
        r15 = -1;
        goto L52
    L49:
        if (r16.equals("ConstraintSet") == false) goto L116;
        r15 = 5;
        goto L52
    L116:
        r15 = -1;
        goto L52
    L119:
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        return;
    L15:
        e = move-exception;
        e.printStackTrace();
    }

    public int M(String r10) {
        Integer r11 = (Integer) this.f1955i.get(r10);
        if (r11 != null) goto L7;
        return 0;
    L7:
        return r11.intValue();
    }

    public final int N(Context r17, XmlPullParser r18) {
        ConstraintSet r10 = new ConstraintSet();
        r10.Y(false);
        int r11 = r18.getAttributeCount();
        int r12 = 0;
        int r13 = -1;
        int r14 = -1;
    L3:
        if (r12 >= r11) goto L62;
        String r15 = r18.getAttributeName(r12);
        String r16 = r18.getAttributeValue(r12);
        if (this.f1957k == false) goto L7;
        System.out.println("id string = " + r16);
    L7:
        r15.hashCode();
        switch(r15.hashCode()) {
            case -1496482599: goto L19;
            case -1153153640: goto L15;
            case 3355: goto L11;
            default: goto L9;
        };
    L9:
        byte r19 = -1;
    L22:
        switch(r19) {
            case 0: goto L59;
            case 1: goto L71;
            case 2: goto L24;
            default: goto L60;
        };
    L24:
        r13 = r(r17, r16);
        this.f1955i.put(d0(r16), Integer.valueOf(r13));
        r10.f2267b = androidx.constraintlayout.motion.widget.a.c(r17, r13);
        goto L60
    L59:
        r14 = r(r17, r16);
        goto L60
    L71:
        r10.f2269d = Integer.parseInt(r16);     // Catch: NumberFormatException -> L29
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
        byte r20 = -1;
    L52:
        switch(r20) {
            case 0: goto L58;
            case 1: goto L57;
            case 2: goto L56;
            case 3: goto L55;
            case 4: goto L54;
            default: goto L60;
        };
    L54:
        r10.f2269d = 3;
        goto L60
    L55:
        r10.f2269d = 1;
        goto L60
    L56:
        r10.f2269d = 0;
        goto L60
    L57:
        r10.f2269d = 2;
        goto L60
    L58:
        r10.f2269d = 4;
        goto L60
    L33:
        if (r16.equals("x_right") == false) goto L31;
        r20 = 4;
        goto L52
    L37:
        if (r16.equals("right") == false) goto L31;
        r20 = 3;
        goto L52
    L41:
        if (r16.equals(SchedulerSupport.NONE) == false) goto L31;
        r20 = 2;
        goto L52
    L45:
        if (r16.equals("left") == false) goto L31;
        r20 = 1;
        goto L52
    L49:
        if (r16.equals("x_left") == false) goto L31;
        r20 = 0;
    L60:
        r12 = r12 + 1;
        goto L3
    L11:
        if (r15.equals("id") == false) goto L9;
        r19 = 2;
        goto L22
    L15:
        if (r15.equals("constraintRotate") == false) goto L9;
        r19 = 1;
        goto L22
    L19:
        if (r15.equals("deriveConstraintsFrom") == false) goto L9;
        r19 = 0;
        goto L22
    L62:
        if (r13 != (-1)) goto L64;
    L70:
        return r13;
    L64:
        if (this.f1947a.f1772x == 0) goto L66;
        r10.c0(true);
    L66:
        r10.J(r17, r18);
        if (r14 == (-1)) goto L69;
        this.f1956j.put(r13, r14);
    L69:
        this.f1954h.put(r13, r10);
        goto L70
    }

    public final int O(Context r10, int r11) {
        XmlResourceParser r12 = r10.getResources().getXml(r11);
        int r13 = r12.getEventType();     // Catch: IOException -> L12 XmlPullParserException -> L14
    L5:
        if (r13 == 1) goto L29;
        String r14 = r12.getName();     // Catch: IOException -> L12 XmlPullParserException -> L14
        if (2 != r13) goto L16;
        if ("ConstraintSet".equals(r14) == false) goto L16;
        return N(r10, r12);
    L16:
        r13 = r12.next();     // Catch: IOException -> L12 XmlPullParserException -> L14
        goto L5
    L29:
        return -1;
    L12:
        e = move-exception;
        e.printStackTrace();
        return -1;
    L14:
        e = move-exception;
        e.printStackTrace();
        return -1;
    }

    public final void P(Context r10, XmlPullParser r11) {
        TypedArray r12 = r10.obtainStyledAttributes(Xml.asAttributeSet(r11), R$styleable.include);
        int r13 = r12.getIndexCount();
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        int r15 = r12.getIndex(r14);
        if (r15 != R$styleable.include_constraintSet) goto L7;
        O(r10, r12.getResourceId(r15, -1));
    L7:
        r14 = r14 + 1;
        goto L3
    L8:
        r12.recycle();
    }

    public final void Q(Context r10, XmlPullParser r11) {
        TypedArray r12 = r10.obtainStyledAttributes(Xml.asAttributeSet(r11), R$styleable.MotionScene);
        int r13 = r12.getIndexCount();
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L13;
        int r15 = r12.getIndex(r14);
        if (r15 != R$styleable.MotionScene_defaultDuration) goto L10;
        int r16 = r12.getInt(r15, this.f1958l);
        this.f1958l = r16;
        if (r16 >= 8) goto L12;
        this.f1958l = 8;
    L12:
        r14 = r14 + 1;
        goto L3
    L10:
        if (r15 != R$styleable.MotionScene_layoutDuringTransition) goto L12;
        this.f1959m = r12.getInteger(r15, 0);
        goto L12
    L13:
        r12.recycle();
    }

    public void R(float r10, float r11) {
        b r12 = this.f1949c;
        if (r12 != null) goto L5;
        return;
    L5:
        if (b.l(r12) == null) goto L9;
        b.l(this.f1949c).u(r10, r11);
        return;
    }

    public void S(float r10, float r11) {
        b r12 = this.f1949c;
        if (r12 != null) goto L5;
        return;
    L5:
        if (b.l(r12) == null) goto L9;
        b.l(this.f1949c).v(r10, r11);
        return;
    }

    public void T(MotionEvent r12, int r13, MotionLayout r14) {
        RectF r10 = new RectF();
        if (this.f1963q != null) goto L5;
        this.f1963q = this.f1947a.Z();
    L5:
        this.f1963q.addMovement(r12);
        if (r13 == (-1)) goto L47;
        int r11 = r12.getAction();
        boolean r15 = false;
        if (r11 != 0) goto L10;
        this.f1966t = r12.getRawX();
        this.f1967u = r12.getRawY();
        this.f1960n = r12;
        this.f1961o = false;
        if (b.l(this.f1949c) == null) goto L65;
        RectF r16 = b.l(this.f1949c).f(this.f1947a, r10);
        if (r16 != null) goto L35;
    L38:
        RectF r17 = b.l(this.f1949c).p(this.f1947a, r10);
        if (r17 != null) goto L41;
    L43:
        this.f1962p = false;
    L44:
        b.l(this.f1949c).w(this.f1966t, this.f1967u);
        return;
    L41:
        if (r17.contains(this.f1960n.getX(), this.f1960n.getY()) == true) goto L43;
        this.f1962p = true;
        goto L44
    L35:
        if (r16.contains(this.f1960n.getX(), this.f1960n.getY()) == true) goto L38;
        this.f1960n = null;
        this.f1961o = true;
        return;
    L65:
        return;
    L10:
        if (r11 != 2) goto L47;
        if (this.f1961o == true) goto L47;
        float r18 = r12.getRawY() - this.f1967u;
        float r19 = r12.getRawX() - this.f1966t;
        if (r19 == 0.0d) goto L18;
    L19:
        MotionEvent r20 = this.f1960n;
        if (r20 == null) goto L64;
        b r21 = i(r13, r19, r18, r20);
        if (r21 == null) goto L47;
        r14.setTransition(r21);
        RectF r22 = b.l(this.f1949c).p(this.f1947a, r10);
        if (r22 != null) goto L27;
    L29:
        this.f1962p = r15;
        b.l(this.f1949c).z(this.f1966t, this.f1967u);
        goto L47
    L27:
        if (r22.contains(this.f1960n.getX(), this.f1960n.getY()) == true) goto L29;
        r15 = true;
        goto L29
    L64:
        return;
    L18:
        if (r18 != 0.0d) goto L19;
        return;
    L47:
        if (this.f1961o == false) goto L49;
        return;
    L49:
        b r23 = this.f1949c;
        if (r23 != null) goto L52;
    L56:
        this.f1966t = r12.getRawX();
        this.f1967u = r12.getRawY();
        if (r12.getAction() != 1) goto L66;
        MotionLayout.MotionTracker r110 = this.f1963q;
        if (r110 == null) goto L67;
        r110.recycle();
        this.f1963q = null;
        int r111 = r14.f1736f;
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
        if (this.f1962p == true) goto L56;
        b.l(this.f1949c).s(r12, this.f1963q, r13, this);
        goto L56
    }

    public final void U(int r10, MotionLayout r11) {
        ConstraintSet r12 = (ConstraintSet) this.f1954h.get(r10);
        r12.f2268c = r12.f2267b;
        int r13 = this.f1956j.get(r10);
        if (r13 <= 0) goto L9;
        U(r13, r11);
        ConstraintSet r14 = (ConstraintSet) this.f1954h.get(r13);
        if (r14 != null) goto L8;
        Log.e("MotionScene", "ERROR! invalid deriveConstraintsFrom: @id/" + androidx.constraintlayout.motion.widget.a.c(this.f1947a.getContext(), r13));
        return;
    L8:
        r12.f2268c += LibrarianImpl.Constants.SEPARATOR + r14.f2268c;
        r12.R(r14);
    L10:
        r12.h(r12);
        return;
    L9:
        r12.f2268c += "  layout";
        r12.Q(r11);
        goto L10
    }

    public void V(MotionLayout r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.f1954h.size()) goto L10;
        int r12 = this.f1954h.keyAt(r11);
        if (I(r12) == true) goto L7;
        U(r12, r10);
        r11 = r11 + 1;
        goto L4
    L7:
        Log.e("MotionScene", "Cannot be derived from yourself");
        return;
    }

    public void W(int r10, ConstraintSet r11) {
        this.f1954h.put(r10, r11);
    }

    public void X(int r10) {
        b r11 = this.f1949c;
        if (r11 == null) goto L5;
        r11.E(r10);
        return;
    L5:
        this.f1958l = r10;
    }

    public void Y(View r10, int r11, String r12, Object r13) {
        b r14 = this.f1949c;
        if (r14 != null) goto L5;
        return;
    L5:
        Iterator r15 = b.f(r14).iterator();
    L7:
        if (r15.hasNext() == false) goto L16;
        Iterator r16 = ((f) r15.next()).d(r10.getId()).iterator();
    L10:
        if (r16.hasNext() == false) goto L7;
        if (((c) r16.next()).f1834a != r11) goto L10;
        if (r13 == null) goto L15;
        Float r17 = (Float) r13;
    L15:
        r12.equalsIgnoreCase("app:PerpendicularPath_percent");
        goto L10
    }

    public void Z(boolean r10) {
        this.f1964r = r10;
        b r11 = this.f1949c;
        if (r11 != null) goto L5;
        return;
    L5:
        if (b.l(r11) == null) goto L9;
        b.l(this.f1949c).x(this.f1964r);
        return;
    }

    public void a0(int r10, int r11) {
        androidx.constraintlayout.widget.a r12 = this.f1948b;
        if (r12 == null) goto L12;
        int r13 = r12.c(r10, -1, -1);
        if (r13 != (-1)) goto L8;
        r13 = r10;
    L8:
        int r14 = this.f1948b.c(r11, -1, -1);
        if (r14 != (-1)) goto L13;
    L11:
        r14 = r11;
    L13:
        b r15 = this.f1949c;
        if (r15 != null) goto L16;
    L20:
        Iterator r16 = this.f1951e.iterator();
    L22:
        if (r16.hasNext() == false) goto L37;
        b r17 = (b) r16.next();
        if (b.a(r17) != r14) goto L28;
        if (b.c(r17) != r13) goto L28;
    L31:
        this.f1949c = r17;
        if (r17 != null) goto L34;
        return;
    L34:
        if (b.l(r17) == null) goto L61;
        b.l(this.f1949c).x(this.f1964r);
        return;
    L61:
        return;
    L28:
        if (b.a(r17) != r11) goto L22;
        if (b.c(r17) != r10) goto L22;
    L37:
        b r18 = this.f1952f;
        Iterator r19 = this.f1953g.iterator();
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
        this.f1951e.add(r21);
    L46:
        this.f1949c = r21;
        return;
    L16:
        if (b.a(r15) != r11) goto L20;
        if (b.c(this.f1949c) != r10) goto L20;
        return;
    L12:
        r13 = r10;
        goto L11
    }

    public void b0(b r10) {
        this.f1949c = r10;
        if (r10 != null) goto L5;
        return;
    L5:
        if (b.l(r10) == null) goto L9;
        b.l(this.f1949c).x(this.f1964r);
        return;
    }

    public void c0() {
        b r10 = this.f1949c;
        if (r10 != null) goto L5;
        return;
    L5:
        if (b.l(r10) == null) goto L9;
        b.l(this.f1949c).A();
        return;
    }

    public boolean e0() {
        Iterator r10 = this.f1951e.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        if (b.l((b) r10.next()) == null) goto L4;
        return true;
    L8:
        b r11 = this.f1949c;
        if (r11 != null) goto L11;
    L13:
        return false;
    L11:
        if (b.l(r11) == null) goto L13;
        return true;
    }

    public void f(MotionLayout r10, int r11) {
        Iterator r12 = this.f1951e.iterator();
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
        Iterator r15 = this.f1953g.iterator();
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
        Iterator r18 = this.f1951e.iterator();
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
        Iterator r21 = this.f1953g.iterator();
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
        return this.f1965s.e(r10, r11);
    }

    public boolean h(MotionLayout r10, int r11) {
        if (K() == false) goto L6;
        return false;
    L6:
        if (this.f1950d == false) goto L8;
        return false;
    L8:
        Iterator r12 = this.f1951e.iterator();
    L10:
        if (r12.hasNext() == false) goto L41;
        b r13 = (b) r12.next();
        if (b.r(r13) == 0) goto L10;
        b r14 = this.f1949c;
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
        r10.i0();
        r10.setState(MotionLayout.TransitionState.SETUP);
        r10.setState(MotionLayout.TransitionState.MOVING);
    L29:
        return true;
    L28:
        r10.setProgress(1.0f);
        r10.M(true);
        r10.setState(MotionLayout.TransitionState.SETUP);
        r10.setState(MotionLayout.TransitionState.MOVING);
        r10.setState(r15);
        r10.a0();
    L31:
        if (r11 != b.a(r13)) goto L10;
        if (b.r(r13) == 3) goto L36;
        if (b.r(r13) != 1) goto L10;
    L36:
        MotionLayout.TransitionState r16 = MotionLayout.TransitionState.FINISHED;
        r10.setState(r16);
        r10.setTransition(r13);
        if (b.r(r13) != 3) goto L39;
        r10.k0();
        r10.setState(MotionLayout.TransitionState.SETUP);
        r10.setState(MotionLayout.TransitionState.MOVING);
    L40:
        return true;
    L39:
        r10.setProgress(0.0f);
        r10.M(true);
        r10.setState(MotionLayout.TransitionState.SETUP);
        r10.setState(MotionLayout.TransitionState.MOVING);
        r10.setState(r16);
        r10.a0();
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
        b.l(r15).x(this.f1964r);
        RectF r16 = b.l(r15).p(this.f1947a, r11);
        if (r16 == null) goto L18;
        if (r20 == null) goto L18;
        if (r16.contains(r20.getX(), r20.getY()) == false) goto L6;
    L18:
        RectF r21 = b.l(r15).f(this.f1947a, r11);
        if (r21 == null) goto L24;
        if (r20 == null) goto L24;
        if (r21.contains(r20.getX(), r20.getY()) == false) goto L6;
    L24:
        float r22 = b.l(r15).a(r18, r19);
        if (b.l(r15).f2001l == false) goto L29;
        if (r20 == null) goto L29;
        float r23 = r20.getX() - b.l(r15).f1998i;
        float r110 = r20.getY() - b.l(r15).f1999j;
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
        return this.f1949c;
    }

    public int j() {
        b r10 = this.f1949c;
        if (r10 != null) goto L7;
        return -1;
    L7:
        return b.k(r10);
    }

    public int k() {
        b r10 = this.f1949c;
        if (r10 != null) goto L5;
        return 0;
    L5:
        if (b.l(r10) != null) goto L7;
        return 0;
    L7:
        return b.l(this.f1949c).d();
    }

    public ConstraintSet l(int r10) {
        return m(r10, -1, -1);
    }

    public ConstraintSet m(int r10, int r11, int r12) {
        if (this.f1957k == false) goto L5;
        PrintStream r13 = System.out;
        r13.println("id " + r10);
        r13.println("size " + this.f1954h.size());
    L5:
        androidx.constraintlayout.widget.a r14 = this.f1948b;
        if (r14 == null) goto L11;
        int r15 = r14.c(r10, r11, r12);
        if (r15 == (-1)) goto L11;
        r10 = r15;
    L11:
        if (this.f1954h.get(r10) != null) goto L15;
        Log.e("MotionScene", "Warning could not find ConstraintSet id/" + androidx.constraintlayout.motion.widget.a.c(this.f1947a.getContext(), r10) + " In MotionScene");
        SparseArray r16 = this.f1954h;
        return (ConstraintSet) r16.get(r16.keyAt(0));
    L15:
        return (ConstraintSet) this.f1954h.get(r10);
    }

    public int[] n() {
        int r10 = this.f1954h.size();
        int[] r11 = new int[r10];
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L5;
        r11[r12] = this.f1954h.keyAt(r12);
        r12 = r12 + 1;
        goto L3
    L5:
        return r11;
    }

    public ArrayList o() {
        return this.f1951e;
    }

    public int p() {
        b r10 = this.f1949c;
        if (r10 == null) goto L7;
        return b.j(r10);
    L7:
        return this.f1958l;
    }

    public int q() {
        b r10 = this.f1949c;
        if (r10 != null) goto L7;
        return -1;
    L7:
        return b.a(r10);
    }

    public final int r(Context r10, String r11) {
        if (r11.contains(LibrarianImpl.Constants.SEPARATOR) == false) goto L7;
        int r12 = r10.getResources().getIdentifier(r11.substring(r11.indexOf(47) + 1), "id", r10.getPackageName());
        if (this.f1957k == false) goto L8;
        System.out.println("id getMap res = " + r12);
    L8:
        if (r12 == (-1)) goto L10;
        return r12;
    L10:
        if (r11.length() > 1) goto L15;
        Log.e("MotionScene", "error in parsing id");
        return r12;
    L15:
        return Integer.parseInt(r11.substring(1));
    L7:
        r12 = -1;
        goto L8
    }

    public Interpolator s() {
        int r10 = b.g(this.f1949c);
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
        return new a(this, p001j.c.c(b.h(this.f1949c)));
    L34:
        return AnimationUtils.loadInterpolator(this.f1947a.getContext(), b.i(this.f1949c));
    }

    public void t(l r10) {
        b r11 = this.f1949c;
        if (r11 != null) goto L11;
        b r12 = this.f1952f;
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
        b r10 = this.f1949c;
        if (r10 != null) goto L5;
        return 0.0f;
    L5:
        if (b.l(r10) != null) goto L7;
        return 0.0f;
    L7:
        return b.l(this.f1949c).g();
    }

    public float v() {
        b r10 = this.f1949c;
        if (r10 != null) goto L5;
        return 0.0f;
    L5:
        if (b.l(r10) != null) goto L7;
        return 0.0f;
    L7:
        return b.l(this.f1949c).h();
    }

    public boolean w() {
        b r10 = this.f1949c;
        if (r10 != null) goto L5;
        return false;
    L5:
        if (b.l(r10) != null) goto L7;
        return false;
    L7:
        return b.l(this.f1949c).i();
    }

    public float x(float r10, float r11) {
        b r12 = this.f1949c;
        if (r12 != null) goto L5;
        return 0.0f;
    L5:
        if (b.l(r12) != null) goto L7;
        return 0.0f;
    L7:
        return b.l(this.f1949c).j(r10, r11);
    }

    public final int y(int r10) {
        androidx.constraintlayout.widget.a r11 = this.f1948b;
        if (r11 == null) goto L7;
        int r12 = r11.c(r10, -1, -1);
        if (r12 == (-1)) goto L7;
        return r12;
    L7:
        return r10;
    }

    public int z() {
        b r10 = this.f1949c;
        if (r10 != null) goto L5;
        return 0;
    L5:
        if (b.l(r10) != null) goto L7;
        return 0;
    L7:
        return b.l(this.f1949c).k();
    }
}

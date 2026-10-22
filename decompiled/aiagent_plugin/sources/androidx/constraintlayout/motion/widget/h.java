package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: KeyPosition.java */
/* JADX INFO: loaded from: classes.dex */
public class h extends i {
    private static final String TAG = "KeyPosition";
    String g;
    int h;
    int i;
    float j;
    float k;
    float l;
    float m;
    float n;
    float o;
    int p;
    private float r;
    private float s;

    /* JADX INFO: compiled from: KeyPosition.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static SparseIntArray f887a;

        static /* synthetic */ void a(h r0, TypedArray r1) {
            b(r0, r1);
        }

        static {
            SparseIntArray r0 = new SparseIntArray();
            f887a = r0;
            r0.append(ZeusTransformUtils.mapRes(R.styleable.KeyPosition_motionTarget, "styleable", "KeyPosition_motionTarget"), 1);
            f887a.append(ZeusTransformUtils.mapRes(R.styleable.KeyPosition_framePosition, "styleable", "KeyPosition_framePosition"), 2);
            f887a.append(ZeusTransformUtils.mapRes(R.styleable.KeyPosition_transitionEasing, "styleable", "KeyPosition_transitionEasing"), 3);
            f887a.append(ZeusTransformUtils.mapRes(R.styleable.KeyPosition_curveFit, "styleable", "KeyPosition_curveFit"), 4);
            f887a.append(ZeusTransformUtils.mapRes(R.styleable.KeyPosition_drawPath, "styleable", "KeyPosition_drawPath"), 5);
            f887a.append(ZeusTransformUtils.mapRes(R.styleable.KeyPosition_percentX, "styleable", "KeyPosition_percentX"), 6);
            f887a.append(ZeusTransformUtils.mapRes(R.styleable.KeyPosition_percentY, "styleable", "KeyPosition_percentY"), 7);
            f887a.append(ZeusTransformUtils.mapRes(R.styleable.KeyPosition_keyPositionType, "styleable", "KeyPosition_keyPositionType"), 9);
            f887a.append(ZeusTransformUtils.mapRes(R.styleable.KeyPosition_sizePercent, "styleable", "KeyPosition_sizePercent"), 8);
            f887a.append(ZeusTransformUtils.mapRes(R.styleable.KeyPosition_percentWidth, "styleable", "KeyPosition_percentWidth"), 11);
            f887a.append(ZeusTransformUtils.mapRes(R.styleable.KeyPosition_percentHeight, "styleable", "KeyPosition_percentHeight"), 12);
            f887a.append(ZeusTransformUtils.mapRes(R.styleable.KeyPosition_pathMotionArc, "styleable", "KeyPosition_pathMotionArc"), 10);
        }

        private static void b(h r8, TypedArray r9) {
            int r0 = r9.getIndexCount();
            int r2 = 0;
        L4:
            if (r2 >= r0) goto L33;
            int r5 = r9.getIndex(r2);
            switch(f887a.get(r5)) {
                case 1: goto L23;
                case 2: goto L21;
                case 3: goto L18;
                case 4: goto L16;
                case 5: goto L15;
                case 6: goto L14;
                case 7: goto L13;
                case 8: goto L12;
                case 9: goto L11;
                case 10: goto L10;
                case 11: goto L9;
                case 12: goto L8;
                default: goto L7;
            };
        L7:
            a(h.TAG, "unused attribute 0x" + Integer.toHexString(r5) + "   " + f887a.get(r5));
        L31:
            r2 = r2 + 1;
            goto L4
        L8:
            r8.k = r9.getFloat(r5, r8.k);
            goto L31
        L9:
            r8.j = r9.getFloat(r5, r8.j);
            goto L31
        L10:
            r8.h = r9.getInt(r5, r8.h);
            goto L31
        L11:
            r8.p = r9.getInt(r5, r8.p);
            goto L31
        L12:
            float r3 = r9.getFloat(r5, r8.k);
            r8.j = r3;
            r8.k = r3;
            goto L31
        L13:
            r8.m = r9.getFloat(r5, r8.m);
            goto L31
        L14:
            r8.l = r9.getFloat(r5, r8.l);
            goto L31
        L15:
            r8.i = r9.getInt(r5, r8.i);
            goto L31
        L16:
            r8.q = r9.getInteger(r5, r8.q);
            goto L31
        L21:
            r8.f879b = r9.getInt(r5, r8.f879b);
            goto L31
        L18:
            if (r9.peekValue(r5).type != 3) goto L20;
            r8.g = r9.getString(r5);
            goto L31
        L20:
            r8.g = androidx.constraintlayout.a.a.a.c.f615c[r9.getInteger(r5, 0)];
            goto L31
        L23:
            if (MotionLayout.IS_IN_EDIT_MODE == false) goto L28;
            r8.f880c = r9.getResourceId(r5, r8.f880c);
            if (r8.f880c != (-1)) goto L31;
            r8.f881d = r9.getString(r5);
            goto L31
        L28:
            if (r9.peekValue(r5).type != 3) goto L30;
            r8.f881d = r9.getString(r5);
            goto L31
        L30:
            r8.f880c = r9.getResourceId(r5, r8.f880c);
            goto L31
        L33:
            if (r8.f879b != (-1)) goto L54;
            a(h.TAG, "no frame position");
            return;
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r0, String r1) {
            return Log.e(r0, r1);
        }
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public void a(HashMap<String, androidx.constraintlayout.motion.utils.c> r1) {
    }

    public h() {
        this.g = null;
        this.h = f878a;
        this.i = 0;
        this.j = Float.NaN;
        this.k = Float.NaN;
        this.l = Float.NaN;
        this.m = Float.NaN;
        this.n = Float.NaN;
        this.o = Float.NaN;
        this.p = 0;
        this.r = Float.NaN;
        this.s = Float.NaN;
        this.f882e = 2;
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public /* synthetic */ Object clone() {
        return a();
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public void a(Context r3, AttributeSet r4) {
        a.a(this, ((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin")).obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), R.styleable.KeyPosition));
    }

    public void c(int r1) {
        this.p = r1;
    }

    public void a(String r3, Object r4) {
        r3.hashCode();
        byte r1 = -1;
        switch(r3.hashCode()) {
            case -1812823328: goto L30;
            case -1127236479: goto L26;
            case -1017587252: goto L22;
            case -827014263: goto L18;
            case -200259324: goto L14;
            case 428090547: goto L10;
            case 428090548: goto L6;
            default: goto L33;
        };
    L33:
        switch(r1) {
            case 0: goto L41;
            case 1: goto L40;
            case 2: goto L39;
            case 3: goto L38;
            case 4: goto L37;
            case 5: goto L36;
            case 6: goto L35;
            default: goto L49;
        };
    L35:
        this.m = a(r4);
        return;
    L36:
        this.l = a(r4);
        return;
    L37:
        float r5 = a(r4);
        this.j = r5;
        this.k = r5;
        return;
    L38:
        this.i = b(r4);
        return;
    L39:
        this.k = a(r4);
        return;
    L40:
        this.j = a(r4);
        return;
    L41:
        this.g = r4.toString();
        return;
    L49:
        return;
    L6:
        if (r3.equals("percentY") == false) goto L33;
        r1 = 6;
        goto L33
    L10:
        if (r3.equals("percentX") == false) goto L33;
        r1 = 5;
        goto L33
    L14:
        if (r3.equals("sizePercent") == false) goto L33;
        r1 = 4;
        goto L33
    L18:
        if (r3.equals("drawPath") == false) goto L33;
        r1 = 3;
        goto L33
    L22:
        if (r3.equals("percentHeight") == false) goto L33;
        r1 = 2;
        goto L33
    L26:
        if (r3.equals("percentWidth") == false) goto L33;
        r1 = 1;
        goto L33
    L30:
        if (r3.equals("transitionEasing") == false) goto L33;
        r1 = 0;
        goto L33
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public d a(d r3) {
        super.a(r3);
        h r4 = (h) ZeusTransformUtils.preCheckCast(r3, h.class, "com.obric.aiagent.plugin");
        this.g = r4.g;
        this.h = r4.h;
        this.i = r4.i;
        this.j = r4.j;
        this.k = Float.NaN;
        this.l = r4.l;
        this.m = r4.m;
        this.n = r4.n;
        this.o = r4.o;
        this.r = r4.r;
        this.s = r4.s;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.d
    public d a() {
        return new h().a(this);
    }
}

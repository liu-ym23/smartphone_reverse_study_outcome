package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.stepos.alphame.utils.Property;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;
import v.C0944d;
import v.C0945e;
import v.C0948h;
import w.C0968n;
import y.AbstractC0984c;
import y.d;
import y.e;
import y.g;
import y.n;
import y.o;
import y.p;
import y.r;
import y.s;

/* loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {

    /* renamed from: r, reason: collision with root package name */
    public static s f3228r;

    /* renamed from: a, reason: collision with root package name */
    public final SparseArray f3229a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f3230b;

    /* renamed from: c, reason: collision with root package name */
    public final C0945e f3231c;

    /* renamed from: d, reason: collision with root package name */
    public int f3232d;

    /* renamed from: e, reason: collision with root package name */
    public int f3233e;

    /* renamed from: f, reason: collision with root package name */
    public int f3234f;

    /* renamed from: g, reason: collision with root package name */
    public int f3235g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f3236h;

    /* renamed from: i, reason: collision with root package name */
    public int f3237i;

    /* renamed from: j, reason: collision with root package name */
    public n f3238j;

    /* renamed from: k, reason: collision with root package name */
    public g f3239k;

    /* renamed from: l, reason: collision with root package name */
    public int f3240l;

    /* renamed from: m, reason: collision with root package name */
    public HashMap f3241m;

    /* renamed from: n, reason: collision with root package name */
    public final SparseArray f3242n;

    /* renamed from: o, reason: collision with root package name */
    public final C0968n f3243o;

    /* renamed from: p, reason: collision with root package name */
    public int f3244p;

    /* renamed from: q, reason: collision with root package name */
    public int f3245q;

    public ConstraintLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) throws XmlPullParserException, IOException, NumberFormatException {
        super(context, attributeSet);
        this.f3229a = new SparseArray();
        this.f3230b = new ArrayList(4);
        this.f3231c = new C0945e();
        this.f3232d = 0;
        this.f3233e = 0;
        this.f3234f = Integer.MAX_VALUE;
        this.f3235g = Integer.MAX_VALUE;
        this.f3236h = true;
        this.f3237i = 257;
        this.f3238j = null;
        this.f3239k = null;
        this.f3240l = -1;
        this.f3241m = new HashMap();
        this.f3242n = new SparseArray();
        this.f3243o = new C0968n(this, this);
        this.f3244p = 0;
        this.f3245q = 0;
        c(attributeSet, 0);
    }

    public static e a() {
        e eVar = new e(-2, -2);
        eVar.f15978a = -1;
        eVar.f15980b = -1;
        eVar.f15982c = -1.0f;
        eVar.f15984d = true;
        eVar.f15986e = -1;
        eVar.f15988f = -1;
        eVar.f15990g = -1;
        eVar.f15992h = -1;
        eVar.f15994i = -1;
        eVar.f15996j = -1;
        eVar.f15998k = -1;
        eVar.f16000l = -1;
        eVar.f16002m = -1;
        eVar.f16004n = -1;
        eVar.f16006o = -1;
        eVar.f16008p = -1;
        eVar.f16010q = 0;
        eVar.f16011r = Property.DEFAULT_FLOAT_VALUE;
        eVar.f16012s = -1;
        eVar.f16013t = -1;
        eVar.f16014u = -1;
        eVar.f16015v = -1;
        eVar.f16016w = Integer.MIN_VALUE;
        eVar.f16017x = Integer.MIN_VALUE;
        eVar.f16018y = Integer.MIN_VALUE;
        eVar.f16019z = Integer.MIN_VALUE;
        eVar.f15953A = Integer.MIN_VALUE;
        eVar.f15954B = Integer.MIN_VALUE;
        eVar.f15955C = Integer.MIN_VALUE;
        eVar.f15956D = 0;
        eVar.f15957E = 0.5f;
        eVar.f15958F = 0.5f;
        eVar.f15959G = null;
        eVar.f15960H = -1.0f;
        eVar.f15961I = -1.0f;
        eVar.f15962J = 0;
        eVar.f15963K = 0;
        eVar.f15964L = 0;
        eVar.f15965M = 0;
        eVar.f15966N = 0;
        eVar.f15967O = 0;
        eVar.f15968P = 0;
        eVar.f15969Q = 0;
        eVar.f15970R = 1.0f;
        eVar.f15971S = 1.0f;
        eVar.T = -1;
        eVar.f15972U = -1;
        eVar.f15973V = -1;
        eVar.f15974W = false;
        eVar.f15975X = false;
        eVar.f15976Y = null;
        eVar.f15977Z = 0;
        eVar.f15979a0 = true;
        eVar.f15981b0 = true;
        eVar.f15983c0 = false;
        eVar.f15985d0 = false;
        eVar.f15987e0 = false;
        eVar.f15989f0 = -1;
        eVar.f15991g0 = -1;
        eVar.f15993h0 = -1;
        eVar.f15995i0 = -1;
        eVar.f15997j0 = Integer.MIN_VALUE;
        eVar.f15999k0 = Integer.MIN_VALUE;
        eVar.f16001l0 = 0.5f;
        eVar.f16009p0 = new C0944d();
        return eVar;
    }

    private int getPaddingWidth() {
        int iMax = Math.max(0, getPaddingRight()) + Math.max(0, getPaddingLeft());
        int iMax2 = Math.max(0, getPaddingEnd()) + Math.max(0, getPaddingStart());
        return iMax2 > 0 ? iMax2 : iMax;
    }

    public static s getSharedValues() {
        if (f3228r == null) {
            s sVar = new s();
            new SparseIntArray();
            new HashMap();
            f3228r = sVar;
        }
        return f3228r;
    }

    public final C0944d b(View view) {
        if (view == this) {
            return this.f3231c;
        }
        if (view == null) {
            return null;
        }
        if (view.getLayoutParams() instanceof e) {
            return ((e) view.getLayoutParams()).f16009p0;
        }
        view.setLayoutParams(generateLayoutParams(view.getLayoutParams()));
        if (view.getLayoutParams() instanceof e) {
            return ((e) view.getLayoutParams()).f16009p0;
        }
        return null;
    }

    public final void c(AttributeSet attributeSet, int i4) throws XmlPullParserException, IOException, NumberFormatException {
        C0945e c0945e = this.f3231c;
        c0945e.f15560f0 = this;
        C0968n c0968n = this.f3243o;
        c0945e.f15606u0 = c0968n;
        c0945e.f15604s0.f15749f = c0968n;
        this.f3229a.put(getId(), this);
        this.f3238j = null;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, r.f16152b, i4, 0);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i5 = 0; i5 < indexCount; i5++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i5);
                if (index == 16) {
                    this.f3232d = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f3232d);
                } else if (index == 17) {
                    this.f3233e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f3233e);
                } else if (index == 14) {
                    this.f3234f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f3234f);
                } else if (index == 15) {
                    this.f3235g = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f3235g);
                } else if (index == 113) {
                    this.f3237i = typedArrayObtainStyledAttributes.getInt(index, this.f3237i);
                } else if (index == 56) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            e(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.f3239k = null;
                        }
                    }
                } else if (index == 34) {
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    try {
                        n nVar = new n();
                        this.f3238j = nVar;
                        nVar.e(resourceId2, getContext());
                    } catch (Resources.NotFoundException unused2) {
                        this.f3238j = null;
                    }
                    this.f3240l = resourceId2;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        c0945e.f15594D0 = this.f3237i;
        t.e.f15277p = c0945e.X(512);
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) throws NumberFormatException {
        Object tag;
        int size;
        ArrayList arrayList = this.f3230b;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i4 = 0; i4 < size; i4++) {
                ((AbstractC0984c) arrayList.get(i4)).getClass();
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            float width = getWidth();
            float height = getHeight();
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] strArrSplit = ((String) tag).split(",");
                    if (strArrSplit.length == 4) {
                        int i6 = Integer.parseInt(strArrSplit[0]);
                        int i7 = Integer.parseInt(strArrSplit[1]);
                        int i8 = Integer.parseInt(strArrSplit[2]);
                        int i9 = (int) ((i6 / 1080.0f) * width);
                        int i10 = (int) ((i7 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f4 = i9;
                        float f5 = i10;
                        float f6 = i9 + ((int) ((i8 / 1080.0f) * width));
                        canvas.drawLine(f4, f5, f6, f5, paint);
                        float f7 = i10 + ((int) ((Integer.parseInt(strArrSplit[3]) / 1920.0f) * height));
                        canvas.drawLine(f6, f5, f6, f7, paint);
                        canvas.drawLine(f6, f7, f4, f7, paint);
                        canvas.drawLine(f4, f7, f4, f5, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f4, f5, f6, f7, paint);
                        canvas.drawLine(f4, f7, f6, f5, paint);
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(int r11) throws org.xmlpull.v1.XmlPullParserException, android.content.res.Resources.NotFoundException, java.io.IOException, java.lang.NumberFormatException {
        /*
            r10 = this;
            y.g r0 = new y.g
            android.content.Context r1 = r10.getContext()
            r0.<init>()
            r2 = -1
            r0.f16025a = r2
            r0.f16026b = r2
            android.util.SparseArray r3 = new android.util.SparseArray
            r3.<init>()
            r0.f16028d = r3
            android.util.SparseArray r3 = new android.util.SparseArray
            r3.<init>()
            r0.f16029e = r3
            r3 = 0
            r0.f16027c = r10
            android.content.res.Resources r4 = r1.getResources()
            android.content.res.XmlResourceParser r11 = r4.getXml(r11)
            int r4 = r11.getEventType()     // Catch: java.io.IOException -> L4d org.xmlpull.v1.XmlPullParserException -> L50
        L2b:
            r5 = 1
            if (r4 == r5) goto Lb4
            if (r4 == 0) goto La4
            r6 = 2
            if (r4 == r6) goto L35
            goto La7
        L35:
            java.lang.String r4 = r11.getName()     // Catch: java.io.IOException -> L4d org.xmlpull.v1.XmlPullParserException -> L50
            int r7 = r4.hashCode()     // Catch: java.io.IOException -> L4d org.xmlpull.v1.XmlPullParserException -> L50
            r8 = 4
            r9 = 3
            switch(r7) {
                case -1349929691: goto L70;
                case 80204913: goto L66;
                case 1382829617: goto L5d;
                case 1657696882: goto L53;
                case 1901439077: goto L43;
                default: goto L42;
            }     // Catch: java.io.IOException -> L4d org.xmlpull.v1.XmlPullParserException -> L50
        L42:
            goto L7a
        L43:
            java.lang.String r5 = "Variant"
            boolean r4 = r4.equals(r5)     // Catch: java.io.IOException -> L4d org.xmlpull.v1.XmlPullParserException -> L50
            if (r4 == 0) goto L7a
            r5 = r9
            goto L7b
        L4d:
            r11 = move-exception
            goto Lad
        L50:
            r11 = move-exception
            goto Lb1
        L53:
            java.lang.String r5 = "layoutDescription"
            boolean r4 = r4.equals(r5)     // Catch: java.io.IOException -> L4d org.xmlpull.v1.XmlPullParserException -> L50
            if (r4 == 0) goto L7a
            r5 = 0
            goto L7b
        L5d:
            java.lang.String r7 = "StateSet"
            boolean r4 = r4.equals(r7)     // Catch: java.io.IOException -> L4d org.xmlpull.v1.XmlPullParserException -> L50
            if (r4 == 0) goto L7a
            goto L7b
        L66:
            java.lang.String r5 = "State"
            boolean r4 = r4.equals(r5)     // Catch: java.io.IOException -> L4d org.xmlpull.v1.XmlPullParserException -> L50
            if (r4 == 0) goto L7a
            r5 = r6
            goto L7b
        L70:
            java.lang.String r5 = "ConstraintSet"
            boolean r4 = r4.equals(r5)     // Catch: java.io.IOException -> L4d org.xmlpull.v1.XmlPullParserException -> L50
            if (r4 == 0) goto L7a
            r5 = r8
            goto L7b
        L7a:
            r5 = r2
        L7b:
            if (r5 == r6) goto L95
            if (r5 == r9) goto L86
            if (r5 == r8) goto L82
            goto La7
        L82:
            r0.a(r1, r11)     // Catch: java.io.IOException -> L4d org.xmlpull.v1.XmlPullParserException -> L50
            goto La7
        L86:
            y.f r4 = new y.f     // Catch: java.io.IOException -> L4d org.xmlpull.v1.XmlPullParserException -> L50
            r4.<init>(r1, r11)     // Catch: java.io.IOException -> L4d org.xmlpull.v1.XmlPullParserException -> L50
            if (r3 == 0) goto La7
            java.lang.Object r5 = r3.f2437c     // Catch: java.io.IOException -> L4d org.xmlpull.v1.XmlPullParserException -> L50
            java.util.ArrayList r5 = (java.util.ArrayList) r5     // Catch: java.io.IOException -> L4d org.xmlpull.v1.XmlPullParserException -> L50
            r5.add(r4)     // Catch: java.io.IOException -> L4d org.xmlpull.v1.XmlPullParserException -> L50
            goto La7
        L95:
            androidx.activity.result.i r3 = new androidx.activity.result.i     // Catch: java.io.IOException -> L4d org.xmlpull.v1.XmlPullParserException -> L50
            r3.<init>(r1, r11)     // Catch: java.io.IOException -> L4d org.xmlpull.v1.XmlPullParserException -> L50
            java.lang.Object r4 = r0.f16028d     // Catch: java.io.IOException -> L4d org.xmlpull.v1.XmlPullParserException -> L50
            android.util.SparseArray r4 = (android.util.SparseArray) r4     // Catch: java.io.IOException -> L4d org.xmlpull.v1.XmlPullParserException -> L50
            int r5 = r3.f2435a     // Catch: java.io.IOException -> L4d org.xmlpull.v1.XmlPullParserException -> L50
            r4.put(r5, r3)     // Catch: java.io.IOException -> L4d org.xmlpull.v1.XmlPullParserException -> L50
            goto La7
        La4:
            r11.getName()     // Catch: java.io.IOException -> L4d org.xmlpull.v1.XmlPullParserException -> L50
        La7:
            int r4 = r11.next()     // Catch: java.io.IOException -> L4d org.xmlpull.v1.XmlPullParserException -> L50
            goto L2b
        Lad:
            r11.printStackTrace()
            goto Lb4
        Lb1:
            r11.printStackTrace()
        Lb4:
            r10.f3239k = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.e(int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:159:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x04d3  */
    /* JADX WARN: Removed duplicated region for block: B:425:0x04d7 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(v.C0945e r25, int r26, int r27, int r28) {
        /*
            Method dump skipped, instructions count: 1747
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.f(v.e, int, int, int):void");
    }

    @Override // android.view.View
    public final void forceLayout() {
        this.f3236h = true;
        super.forceLayout();
    }

    public final void g(C0944d c0944d, e eVar, SparseArray sparseArray, int i4, int i5) {
        View view = (View) this.f3229a.get(i4);
        C0944d c0944d2 = (C0944d) sparseArray.get(i4);
        if (c0944d2 == null || view == null || !(view.getLayoutParams() instanceof e)) {
            return;
        }
        eVar.f15983c0 = true;
        if (i5 == 6) {
            e eVar2 = (e) view.getLayoutParams();
            eVar2.f15983c0 = true;
            eVar2.f16009p0.f15528E = true;
        }
        c0944d.j(6).b(c0944d2.j(i5), eVar.f15956D, eVar.f15955C, true);
        c0944d.f15528E = true;
        c0944d.j(3).j();
        c0944d.j(5).j();
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return a();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) throws NumberFormatException {
        Context context = getContext();
        e eVar = new e(context, attributeSet);
        eVar.f15978a = -1;
        eVar.f15980b = -1;
        eVar.f15982c = -1.0f;
        eVar.f15984d = true;
        eVar.f15986e = -1;
        eVar.f15988f = -1;
        eVar.f15990g = -1;
        eVar.f15992h = -1;
        eVar.f15994i = -1;
        eVar.f15996j = -1;
        eVar.f15998k = -1;
        eVar.f16000l = -1;
        eVar.f16002m = -1;
        eVar.f16004n = -1;
        eVar.f16006o = -1;
        eVar.f16008p = -1;
        eVar.f16010q = 0;
        eVar.f16011r = Property.DEFAULT_FLOAT_VALUE;
        eVar.f16012s = -1;
        eVar.f16013t = -1;
        eVar.f16014u = -1;
        eVar.f16015v = -1;
        eVar.f16016w = Integer.MIN_VALUE;
        eVar.f16017x = Integer.MIN_VALUE;
        eVar.f16018y = Integer.MIN_VALUE;
        eVar.f16019z = Integer.MIN_VALUE;
        eVar.f15953A = Integer.MIN_VALUE;
        eVar.f15954B = Integer.MIN_VALUE;
        eVar.f15955C = Integer.MIN_VALUE;
        eVar.f15956D = 0;
        eVar.f15957E = 0.5f;
        eVar.f15958F = 0.5f;
        eVar.f15959G = null;
        eVar.f15960H = -1.0f;
        eVar.f15961I = -1.0f;
        eVar.f15962J = 0;
        eVar.f15963K = 0;
        eVar.f15964L = 0;
        eVar.f15965M = 0;
        eVar.f15966N = 0;
        eVar.f15967O = 0;
        eVar.f15968P = 0;
        eVar.f15969Q = 0;
        eVar.f15970R = 1.0f;
        eVar.f15971S = 1.0f;
        eVar.T = -1;
        eVar.f15972U = -1;
        eVar.f15973V = -1;
        eVar.f15974W = false;
        eVar.f15975X = false;
        eVar.f15976Y = null;
        eVar.f15977Z = 0;
        eVar.f15979a0 = true;
        eVar.f15981b0 = true;
        eVar.f15983c0 = false;
        eVar.f15985d0 = false;
        eVar.f15987e0 = false;
        eVar.f15989f0 = -1;
        eVar.f15991g0 = -1;
        eVar.f15993h0 = -1;
        eVar.f15995i0 = -1;
        eVar.f15997j0 = Integer.MIN_VALUE;
        eVar.f15999k0 = Integer.MIN_VALUE;
        eVar.f16001l0 = 0.5f;
        eVar.f16009p0 = new C0944d();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.f16152b);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i4 = 0; i4 < indexCount; i4++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i4);
            int i5 = d.f15952a.get(index);
            switch (i5) {
                case 1:
                    eVar.f15973V = typedArrayObtainStyledAttributes.getInt(index, eVar.f15973V);
                    break;
                case 2:
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f16008p);
                    eVar.f16008p = resourceId;
                    if (resourceId == -1) {
                        eVar.f16008p = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    eVar.f16010q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.f16010q);
                    break;
                case 4:
                    float f4 = typedArrayObtainStyledAttributes.getFloat(index, eVar.f16011r) % 360.0f;
                    eVar.f16011r = f4;
                    if (f4 < Property.DEFAULT_FLOAT_VALUE) {
                        eVar.f16011r = (360.0f - f4) % 360.0f;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    eVar.f15978a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, eVar.f15978a);
                    break;
                case 6:
                    eVar.f15980b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, eVar.f15980b);
                    break;
                case 7:
                    eVar.f15982c = typedArrayObtainStyledAttributes.getFloat(index, eVar.f15982c);
                    break;
                case 8:
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f15986e);
                    eVar.f15986e = resourceId2;
                    if (resourceId2 == -1) {
                        eVar.f15986e = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f15988f);
                    eVar.f15988f = resourceId3;
                    if (resourceId3 == -1) {
                        eVar.f15988f = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 10:
                    int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f15990g);
                    eVar.f15990g = resourceId4;
                    if (resourceId4 == -1) {
                        eVar.f15990g = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    int resourceId5 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f15992h);
                    eVar.f15992h = resourceId5;
                    if (resourceId5 == -1) {
                        eVar.f15992h = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    int resourceId6 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f15994i);
                    eVar.f15994i = resourceId6;
                    if (resourceId6 == -1) {
                        eVar.f15994i = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    int resourceId7 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f15996j);
                    eVar.f15996j = resourceId7;
                    if (resourceId7 == -1) {
                        eVar.f15996j = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    int resourceId8 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f15998k);
                    eVar.f15998k = resourceId8;
                    if (resourceId8 == -1) {
                        eVar.f15998k = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    int resourceId9 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f16000l);
                    eVar.f16000l = resourceId9;
                    if (resourceId9 == -1) {
                        eVar.f16000l = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    int resourceId10 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f16002m);
                    eVar.f16002m = resourceId10;
                    if (resourceId10 == -1) {
                        eVar.f16002m = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    int resourceId11 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f16012s);
                    eVar.f16012s = resourceId11;
                    if (resourceId11 == -1) {
                        eVar.f16012s = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 18:
                    int resourceId12 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f16013t);
                    eVar.f16013t = resourceId12;
                    if (resourceId12 == -1) {
                        eVar.f16013t = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 19:
                    int resourceId13 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f16014u);
                    eVar.f16014u = resourceId13;
                    if (resourceId13 == -1) {
                        eVar.f16014u = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 20:
                    int resourceId14 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f16015v);
                    eVar.f16015v = resourceId14;
                    if (resourceId14 == -1) {
                        eVar.f16015v = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 21:
                    eVar.f16016w = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.f16016w);
                    break;
                case 22:
                    eVar.f16017x = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.f16017x);
                    break;
                case 23:
                    eVar.f16018y = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.f16018y);
                    break;
                case 24:
                    eVar.f16019z = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.f16019z);
                    break;
                case 25:
                    eVar.f15953A = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.f15953A);
                    break;
                case 26:
                    eVar.f15954B = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.f15954B);
                    break;
                case 27:
                    eVar.f15974W = typedArrayObtainStyledAttributes.getBoolean(index, eVar.f15974W);
                    break;
                case 28:
                    eVar.f15975X = typedArrayObtainStyledAttributes.getBoolean(index, eVar.f15975X);
                    break;
                case 29:
                    eVar.f15957E = typedArrayObtainStyledAttributes.getFloat(index, eVar.f15957E);
                    break;
                case 30:
                    eVar.f15958F = typedArrayObtainStyledAttributes.getFloat(index, eVar.f15958F);
                    break;
                case 31:
                    int i6 = typedArrayObtainStyledAttributes.getInt(index, 0);
                    eVar.f15964L = i6;
                    if (i6 == 1) {
                        Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                        break;
                    } else {
                        break;
                    }
                case 32:
                    int i7 = typedArrayObtainStyledAttributes.getInt(index, 0);
                    eVar.f15965M = i7;
                    if (i7 == 1) {
                        Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                        break;
                    } else {
                        break;
                    }
                case 33:
                    try {
                        eVar.f15966N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.f15966N);
                        break;
                    } catch (Exception unused) {
                        if (typedArrayObtainStyledAttributes.getInt(index, eVar.f15966N) == -2) {
                            eVar.f15966N = -2;
                            break;
                        } else {
                            break;
                        }
                    }
                case 34:
                    try {
                        eVar.f15968P = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.f15968P);
                        break;
                    } catch (Exception unused2) {
                        if (typedArrayObtainStyledAttributes.getInt(index, eVar.f15968P) == -2) {
                            eVar.f15968P = -2;
                            break;
                        } else {
                            break;
                        }
                    }
                case 35:
                    eVar.f15970R = Math.max(Property.DEFAULT_FLOAT_VALUE, typedArrayObtainStyledAttributes.getFloat(index, eVar.f15970R));
                    eVar.f15964L = 2;
                    break;
                case 36:
                    try {
                        eVar.f15967O = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.f15967O);
                        break;
                    } catch (Exception unused3) {
                        if (typedArrayObtainStyledAttributes.getInt(index, eVar.f15967O) == -2) {
                            eVar.f15967O = -2;
                            break;
                        } else {
                            break;
                        }
                    }
                case 37:
                    try {
                        eVar.f15969Q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.f15969Q);
                        break;
                    } catch (Exception unused4) {
                        if (typedArrayObtainStyledAttributes.getInt(index, eVar.f15969Q) == -2) {
                            eVar.f15969Q = -2;
                            break;
                        } else {
                            break;
                        }
                    }
                case 38:
                    eVar.f15971S = Math.max(Property.DEFAULT_FLOAT_VALUE, typedArrayObtainStyledAttributes.getFloat(index, eVar.f15971S));
                    eVar.f15965M = 2;
                    break;
                default:
                    switch (i5) {
                        case 44:
                            n.h(eVar, typedArrayObtainStyledAttributes.getString(index));
                            break;
                        case 45:
                            eVar.f15960H = typedArrayObtainStyledAttributes.getFloat(index, eVar.f15960H);
                            break;
                        case 46:
                            eVar.f15961I = typedArrayObtainStyledAttributes.getFloat(index, eVar.f15961I);
                            break;
                        case 47:
                            eVar.f15962J = typedArrayObtainStyledAttributes.getInt(index, 0);
                            break;
                        case 48:
                            eVar.f15963K = typedArrayObtainStyledAttributes.getInt(index, 0);
                            break;
                        case 49:
                            eVar.T = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, eVar.T);
                            break;
                        case 50:
                            eVar.f15972U = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, eVar.f15972U);
                            break;
                        case 51:
                            eVar.f15976Y = typedArrayObtainStyledAttributes.getString(index);
                            break;
                        case 52:
                            int resourceId15 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f16004n);
                            eVar.f16004n = resourceId15;
                            if (resourceId15 == -1) {
                                eVar.f16004n = typedArrayObtainStyledAttributes.getInt(index, -1);
                                break;
                            } else {
                                break;
                            }
                        case 53:
                            int resourceId16 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f16006o);
                            eVar.f16006o = resourceId16;
                            if (resourceId16 == -1) {
                                eVar.f16006o = typedArrayObtainStyledAttributes.getInt(index, -1);
                                break;
                            } else {
                                break;
                            }
                        case 54:
                            eVar.f15956D = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.f15956D);
                            break;
                        case 55:
                            eVar.f15955C = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.f15955C);
                            break;
                        default:
                            switch (i5) {
                                case 64:
                                    n.g(eVar, typedArrayObtainStyledAttributes, index, 0);
                                    break;
                                case 65:
                                    n.g(eVar, typedArrayObtainStyledAttributes, index, 1);
                                    break;
                                case 66:
                                    eVar.f15977Z = typedArrayObtainStyledAttributes.getInt(index, eVar.f15977Z);
                                    break;
                                case 67:
                                    eVar.f15984d = typedArrayObtainStyledAttributes.getBoolean(index, eVar.f15984d);
                                    break;
                            }
                    }
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        eVar.a();
        return eVar;
    }

    public int getMaxHeight() {
        return this.f3235g;
    }

    public int getMaxWidth() {
        return this.f3234f;
    }

    public int getMinHeight() {
        return this.f3233e;
    }

    public int getMinWidth() {
        return this.f3232d;
    }

    public int getOptimizationLevel() {
        return this.f3231c.f15594D0;
    }

    public String getSceneString() {
        int id;
        StringBuilder sb = new StringBuilder();
        C0945e c0945e = this.f3231c;
        if (c0945e.f15567j == null) {
            int id2 = getId();
            if (id2 != -1) {
                c0945e.f15567j = getContext().getResources().getResourceEntryName(id2);
            } else {
                c0945e.f15567j = "parent";
            }
        }
        if (c0945e.f15564h0 == null) {
            c0945e.f15564h0 = c0945e.f15567j;
            Log.v("ConstraintLayout", " setDebugName " + c0945e.f15564h0);
        }
        Iterator it = c0945e.f15674q0.iterator();
        while (it.hasNext()) {
            C0944d c0944d = (C0944d) it.next();
            View view = (View) c0944d.f15560f0;
            if (view != null) {
                if (c0944d.f15567j == null && (id = view.getId()) != -1) {
                    c0944d.f15567j = getContext().getResources().getResourceEntryName(id);
                }
                if (c0944d.f15564h0 == null) {
                    c0944d.f15564h0 = c0944d.f15567j;
                    Log.v("ConstraintLayout", " setDebugName " + c0944d.f15564h0);
                }
            }
        }
        c0945e.o(sb);
        return sb.toString();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        int childCount = getChildCount();
        boolean zIsInEditMode = isInEditMode();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            e eVar = (e) childAt.getLayoutParams();
            C0944d c0944d = eVar.f16009p0;
            if (childAt.getVisibility() != 8 || eVar.f15985d0 || eVar.f15987e0 || zIsInEditMode) {
                int iS = c0944d.s();
                int iT = c0944d.t();
                childAt.layout(iS, iT, c0944d.r() + iS, c0944d.l() + iT);
            }
        }
        ArrayList arrayList = this.f3230b;
        int size = arrayList.size();
        if (size > 0) {
            for (int i9 = 0; i9 < size; i9++) {
                ((AbstractC0984c) arrayList.get(i9)).getClass();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0395  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x03f3  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x051a  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0520  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r24, int r25) throws java.lang.IllegalAccessException, android.content.res.Resources.NotFoundException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 1508
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup
    public final void onViewAdded(View view) {
        super.onViewAdded(view);
        C0944d c0944dB = b(view);
        if ((view instanceof p) && !(c0944dB instanceof C0948h)) {
            e eVar = (e) view.getLayoutParams();
            C0948h c0948h = new C0948h();
            eVar.f16009p0 = c0948h;
            eVar.f15985d0 = true;
            c0948h.T(eVar.f15973V);
        }
        if (view instanceof AbstractC0984c) {
            AbstractC0984c abstractC0984c = (AbstractC0984c) view;
            abstractC0984c.i();
            ((e) view.getLayoutParams()).f15987e0 = true;
            ArrayList arrayList = this.f3230b;
            if (!arrayList.contains(abstractC0984c)) {
                arrayList.add(abstractC0984c);
            }
        }
        this.f3229a.put(view.getId(), view);
        this.f3236h = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.f3229a.remove(view.getId());
        C0944d c0944dB = b(view);
        this.f3231c.f15674q0.remove(c0944dB);
        c0944dB.D();
        this.f3230b.remove(view);
        this.f3236h = true;
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        this.f3236h = true;
        super.requestLayout();
    }

    public void setConstraintSet(n nVar) {
        this.f3238j = nVar;
    }

    @Override // android.view.View
    public void setId(int i4) {
        int id = getId();
        SparseArray sparseArray = this.f3229a;
        sparseArray.remove(id);
        super.setId(i4);
        sparseArray.put(getId(), this);
    }

    public void setMaxHeight(int i4) {
        if (i4 == this.f3235g) {
            return;
        }
        this.f3235g = i4;
        requestLayout();
    }

    public void setMaxWidth(int i4) {
        if (i4 == this.f3234f) {
            return;
        }
        this.f3234f = i4;
        requestLayout();
    }

    public void setMinHeight(int i4) {
        if (i4 == this.f3233e) {
            return;
        }
        this.f3233e = i4;
        requestLayout();
    }

    public void setMinWidth(int i4) {
        if (i4 == this.f3232d) {
            return;
        }
        this.f3232d = i4;
        requestLayout();
    }

    public void setOnConstraintsChanged(o oVar) {
        g gVar = this.f3239k;
        if (gVar != null) {
            gVar.f16030f = oVar;
        }
    }

    public void setOptimizationLevel(int i4) {
        this.f3237i = i4;
        C0945e c0945e = this.f3231c;
        c0945e.f15594D0 = i4;
        t.e.f15277p = c0945e.X(512);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i4) throws XmlPullParserException, IOException, NumberFormatException {
        super(context, attributeSet, i4);
        this.f3229a = new SparseArray();
        this.f3230b = new ArrayList(4);
        this.f3231c = new C0945e();
        this.f3232d = 0;
        this.f3233e = 0;
        this.f3234f = Integer.MAX_VALUE;
        this.f3235g = Integer.MAX_VALUE;
        this.f3236h = true;
        this.f3237i = 257;
        this.f3238j = null;
        this.f3239k = null;
        this.f3240l = -1;
        this.f3241m = new HashMap();
        this.f3242n = new SparseArray();
        this.f3243o = new C0968n(this, this);
        this.f3244p = 0;
        this.f3245q = 0;
        c(attributeSet, i4);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        e eVar = new e(layoutParams);
        eVar.f15978a = -1;
        eVar.f15980b = -1;
        eVar.f15982c = -1.0f;
        eVar.f15984d = true;
        eVar.f15986e = -1;
        eVar.f15988f = -1;
        eVar.f15990g = -1;
        eVar.f15992h = -1;
        eVar.f15994i = -1;
        eVar.f15996j = -1;
        eVar.f15998k = -1;
        eVar.f16000l = -1;
        eVar.f16002m = -1;
        eVar.f16004n = -1;
        eVar.f16006o = -1;
        eVar.f16008p = -1;
        eVar.f16010q = 0;
        eVar.f16011r = Property.DEFAULT_FLOAT_VALUE;
        eVar.f16012s = -1;
        eVar.f16013t = -1;
        eVar.f16014u = -1;
        eVar.f16015v = -1;
        eVar.f16016w = Integer.MIN_VALUE;
        eVar.f16017x = Integer.MIN_VALUE;
        eVar.f16018y = Integer.MIN_VALUE;
        eVar.f16019z = Integer.MIN_VALUE;
        eVar.f15953A = Integer.MIN_VALUE;
        eVar.f15954B = Integer.MIN_VALUE;
        eVar.f15955C = Integer.MIN_VALUE;
        eVar.f15956D = 0;
        eVar.f15957E = 0.5f;
        eVar.f15958F = 0.5f;
        eVar.f15959G = null;
        eVar.f15960H = -1.0f;
        eVar.f15961I = -1.0f;
        eVar.f15962J = 0;
        eVar.f15963K = 0;
        eVar.f15964L = 0;
        eVar.f15965M = 0;
        eVar.f15966N = 0;
        eVar.f15967O = 0;
        eVar.f15968P = 0;
        eVar.f15969Q = 0;
        eVar.f15970R = 1.0f;
        eVar.f15971S = 1.0f;
        eVar.T = -1;
        eVar.f15972U = -1;
        eVar.f15973V = -1;
        eVar.f15974W = false;
        eVar.f15975X = false;
        eVar.f15976Y = null;
        eVar.f15977Z = 0;
        eVar.f15979a0 = true;
        eVar.f15981b0 = true;
        eVar.f15983c0 = false;
        eVar.f15985d0 = false;
        eVar.f15987e0 = false;
        eVar.f15989f0 = -1;
        eVar.f15991g0 = -1;
        eVar.f15993h0 = -1;
        eVar.f15995i0 = -1;
        eVar.f15997j0 = Integer.MIN_VALUE;
        eVar.f15999k0 = Integer.MIN_VALUE;
        eVar.f16001l0 = 0.5f;
        eVar.f16009p0 = new C0944d();
        return eVar;
    }
}

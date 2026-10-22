package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import b0.z;
import com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2.FastDoubleMath;
import com.google.crypto.tink.aead.internal.InsecureNonceXChaCha20;
import com.google.crypto.tink.shaded.protobuf.Reader;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParserException;
import p5.l;
import u2.c;
import w2.f;
import w2.g;
import z2.b;
import z2.d;
import z2.e;
import z2.m;
import z2.n;
import z2.o;
import z2.q;
import z2.r;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {

    /* renamed from: v, reason: collision with root package name */
    public static r f995v;

    /* renamed from: c, reason: collision with root package name */
    public final SparseArray f996c;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f997f;

    /* renamed from: g, reason: collision with root package name */
    public final f f998g;

    /* renamed from: h, reason: collision with root package name */
    public int f999h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public int f1000j;

    /* renamed from: k, reason: collision with root package name */
    public int f1001k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f1002l;

    /* renamed from: m, reason: collision with root package name */
    public int f1003m;

    /* renamed from: n, reason: collision with root package name */
    public m f1004n;

    /* renamed from: o, reason: collision with root package name */
    public l f1005o;

    /* renamed from: p, reason: collision with root package name */
    public int f1006p;

    /* renamed from: q, reason: collision with root package name */
    public HashMap f1007q;

    /* renamed from: r, reason: collision with root package name */
    public final SparseArray f1008r;

    /* renamed from: s, reason: collision with root package name */
    public final e f1009s;

    /* renamed from: t, reason: collision with root package name */
    public int f1010t;

    /* renamed from: u, reason: collision with root package name */
    public int f1011u;

    public ConstraintLayout(Context context) throws XmlPullParserException, IOException, NumberFormatException {
        super(context);
        this.f996c = new SparseArray();
        this.f997f = new ArrayList(4);
        this.f998g = new f();
        this.f999h = 0;
        this.i = 0;
        this.f1000j = Reader.READ_DONE;
        this.f1001k = Reader.READ_DONE;
        this.f1002l = true;
        this.f1003m = 257;
        this.f1004n = null;
        this.f1005o = null;
        this.f1006p = -1;
        this.f1007q = new HashMap();
        this.f1008r = new SparseArray();
        this.f1009s = new e(this, this);
        this.f1010t = 0;
        this.f1011u = 0;
        c(null, 0, 0);
    }

    public static d a() {
        d dVar = new d(-2, -2);
        dVar.f16191a = -1;
        dVar.f16193b = -1;
        dVar.f16195c = -1.0f;
        dVar.f16197d = true;
        dVar.f16199e = -1;
        dVar.f16200f = -1;
        dVar.f16201g = -1;
        dVar.f16203h = -1;
        dVar.i = -1;
        dVar.f16206j = -1;
        dVar.f16208k = -1;
        dVar.f16210l = -1;
        dVar.f16212m = -1;
        dVar.f16214n = -1;
        dVar.f16216o = -1;
        dVar.f16218p = -1;
        dVar.f16220q = 0;
        dVar.f16221r = 0.0f;
        dVar.f16222s = -1;
        dVar.f16223t = -1;
        dVar.f16224u = -1;
        dVar.f16225v = -1;
        dVar.f16226w = Integer.MIN_VALUE;
        dVar.f16227x = Integer.MIN_VALUE;
        dVar.f16228y = Integer.MIN_VALUE;
        dVar.f16229z = Integer.MIN_VALUE;
        dVar.A = Integer.MIN_VALUE;
        dVar.B = Integer.MIN_VALUE;
        dVar.C = Integer.MIN_VALUE;
        dVar.D = 0;
        dVar.E = 0.5f;
        dVar.F = 0.5f;
        dVar.G = null;
        dVar.H = -1.0f;
        dVar.I = -1.0f;
        dVar.J = 0;
        dVar.K = 0;
        dVar.L = 0;
        dVar.M = 0;
        dVar.N = 0;
        dVar.O = 0;
        dVar.P = 0;
        dVar.Q = 0;
        dVar.R = 1.0f;
        dVar.S = 1.0f;
        dVar.T = -1;
        dVar.U = -1;
        dVar.V = -1;
        dVar.W = false;
        dVar.X = false;
        dVar.Y = null;
        dVar.Z = 0;
        dVar.f16192a0 = true;
        dVar.f16194b0 = true;
        dVar.f16196c0 = false;
        dVar.f16198d0 = false;
        dVar.e0 = false;
        dVar.f0 = -1;
        dVar.f16202g0 = -1;
        dVar.f16204h0 = -1;
        dVar.f16205i0 = -1;
        dVar.f16207j0 = Integer.MIN_VALUE;
        dVar.f16209k0 = Integer.MIN_VALUE;
        dVar.f16211l0 = 0.5f;
        dVar.f16219p0 = new w2.e();
        return dVar;
    }

    private int getPaddingWidth() {
        int iMax = Math.max(0, getPaddingRight()) + Math.max(0, getPaddingLeft());
        int iMax2 = Math.max(0, getPaddingEnd()) + Math.max(0, getPaddingStart());
        return iMax2 > 0 ? iMax2 : iMax;
    }

    public static r getSharedValues() {
        if (f995v == null) {
            r rVar = new r();
            new SparseIntArray();
            new HashMap();
            f995v = rVar;
        }
        return f995v;
    }

    public final w2.e b(View view) {
        if (view == this) {
            return this.f998g;
        }
        if (view == null) {
            return null;
        }
        if (view.getLayoutParams() instanceof d) {
            return ((d) view.getLayoutParams()).f16219p0;
        }
        view.setLayoutParams(generateLayoutParams(view.getLayoutParams()));
        if (view.getLayoutParams() instanceof d) {
            return ((d) view.getLayoutParams()).f16219p0;
        }
        return null;
    }

    public final void c(AttributeSet attributeSet, int i, int i3) throws XmlPullParserException, IOException, NumberFormatException {
        f fVar = this.f998g;
        fVar.e0 = this;
        e eVar = this.f1009s;
        fVar.f15200t0 = eVar;
        fVar.f15198r0.f9476g = eVar;
        this.f996c.put(getId(), this);
        this.f1004n = null;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, q.f16333b, i, i3);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == 16) {
                    this.f999h = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f999h);
                } else if (index == 17) {
                    this.i = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.i);
                } else if (index == 14) {
                    this.f1000j = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f1000j);
                } else if (index == 15) {
                    this.f1001k = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f1001k);
                } else if (index == 113) {
                    this.f1003m = typedArrayObtainStyledAttributes.getInt(index, this.f1003m);
                } else if (index == 56) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            d(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.f1005o = null;
                        }
                    }
                } else if (index == 34) {
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    try {
                        m mVar = new m();
                        this.f1004n = mVar;
                        mVar.d(resourceId2, getContext());
                    } catch (Resources.NotFoundException unused2) {
                        this.f1004n = null;
                    }
                    this.f1006p = resourceId2;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        fVar.C0 = this.f1003m;
        c.f13995p = fVar.S(512);
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof d;
    }

    public final void d(int i) throws XmlPullParserException, Resources.NotFoundException, IOException {
        String str;
        Context context = getContext();
        l lVar = new l();
        lVar.f9738c = new SparseArray();
        lVar.f9739f = new SparseArray();
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            z zVar = null;
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    switch (name.hashCode()) {
                        case -1349929691:
                            if (name.equals("ConstraintSet")) {
                                lVar.q(context, xml);
                                break;
                            } else {
                                break;
                            }
                        case 80204913:
                            if (name.equals("State")) {
                                zVar = new z(context, xml);
                                ((SparseArray) lVar.f9738c).put(zVar.f1801c, zVar);
                                break;
                            } else {
                                break;
                            }
                        case 1382829617:
                            str = "StateSet";
                            name.equals(str);
                            break;
                        case 1657696882:
                            str = "layoutDescription";
                            name.equals(str);
                            break;
                        case 1901439077:
                            if (name.equals("Variant")) {
                                z2.f fVar = new z2.f(context, xml);
                                if (zVar != null) {
                                    ((ArrayList) zVar.f1803g).add(fVar);
                                    break;
                                } else {
                                    break;
                                }
                            } else {
                                break;
                            }
                    }
                }
            }
        } catch (IOException e10) {
            e10.printStackTrace();
        } catch (XmlPullParserException e11) {
            e11.printStackTrace();
        }
        this.f1005o = lVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) throws NumberFormatException {
        Object tag;
        int size;
        ArrayList arrayList = this.f997f;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i = 0; i < size; i++) {
                ((b) arrayList.get(i)).getClass();
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            float width = getWidth();
            float height = getHeight();
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] strArrSplit = ((String) tag).split(",");
                    if (strArrSplit.length == 4) {
                        int i10 = Integer.parseInt(strArrSplit[0]);
                        int i11 = Integer.parseInt(strArrSplit[1]);
                        int i12 = Integer.parseInt(strArrSplit[2]);
                        int i13 = (int) ((i10 / 1080.0f) * width);
                        int i14 = (int) ((i11 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f5 = i13;
                        float f10 = i14;
                        float f11 = i13 + ((int) ((i12 / 1080.0f) * width));
                        canvas.drawLine(f5, f10, f11, f10, paint);
                        float f12 = i14 + ((int) ((Integer.parseInt(strArrSplit[3]) / 1920.0f) * height));
                        canvas.drawLine(f11, f10, f11, f12, paint);
                        canvas.drawLine(f11, f12, f5, f12, paint);
                        canvas.drawLine(f5, f12, f5, f10, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f5, f10, f11, f12, paint);
                        canvas.drawLine(f5, f12, f11, f10, paint);
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:157:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0477  */
    /* JADX WARN: Type inference failed for: r11v52 */
    /* JADX WARN: Type inference failed for: r11v53 */
    /* JADX WARN: Type inference failed for: r11v6, types: [int] */
    /* JADX WARN: Type inference failed for: r9v11, types: [java.util.ArrayList] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(w2.f r28, int r29, int r30, int r31) {
        /*
            Method dump skipped, instructions count: 1631
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.e(w2.f, int, int, int):void");
    }

    public final void f(w2.e eVar, d dVar, SparseArray sparseArray, int i, int i3) {
        View view = (View) this.f996c.get(i);
        w2.e eVar2 = (w2.e) sparseArray.get(i);
        if (eVar2 == null || view == null || !(view.getLayoutParams() instanceof d)) {
            return;
        }
        dVar.f16196c0 = true;
        if (i3 == 6) {
            d dVar2 = (d) view.getLayoutParams();
            dVar2.f16196c0 = true;
            dVar2.f16219p0.E = true;
        }
        eVar.g(6).a(eVar2.g(i3), dVar.D, dVar.C);
        eVar.E = true;
        eVar.g(3).g();
        eVar.g(5).g();
    }

    @Override // android.view.View
    public final void forceLayout() {
        this.f1002l = true;
        super.forceLayout();
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return a();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) throws NumberFormatException {
        Context context = getContext();
        d dVar = new d(context, attributeSet);
        dVar.f16191a = -1;
        dVar.f16193b = -1;
        dVar.f16195c = -1.0f;
        dVar.f16197d = true;
        dVar.f16199e = -1;
        dVar.f16200f = -1;
        dVar.f16201g = -1;
        dVar.f16203h = -1;
        dVar.i = -1;
        dVar.f16206j = -1;
        dVar.f16208k = -1;
        dVar.f16210l = -1;
        dVar.f16212m = -1;
        dVar.f16214n = -1;
        dVar.f16216o = -1;
        dVar.f16218p = -1;
        dVar.f16220q = 0;
        dVar.f16221r = 0.0f;
        dVar.f16222s = -1;
        dVar.f16223t = -1;
        dVar.f16224u = -1;
        dVar.f16225v = -1;
        dVar.f16226w = Integer.MIN_VALUE;
        dVar.f16227x = Integer.MIN_VALUE;
        dVar.f16228y = Integer.MIN_VALUE;
        dVar.f16229z = Integer.MIN_VALUE;
        dVar.A = Integer.MIN_VALUE;
        dVar.B = Integer.MIN_VALUE;
        dVar.C = Integer.MIN_VALUE;
        dVar.D = 0;
        dVar.E = 0.5f;
        dVar.F = 0.5f;
        dVar.G = null;
        dVar.H = -1.0f;
        dVar.I = -1.0f;
        dVar.J = 0;
        dVar.K = 0;
        dVar.L = 0;
        dVar.M = 0;
        dVar.N = 0;
        dVar.O = 0;
        dVar.P = 0;
        dVar.Q = 0;
        dVar.R = 1.0f;
        dVar.S = 1.0f;
        dVar.T = -1;
        dVar.U = -1;
        dVar.V = -1;
        dVar.W = false;
        dVar.X = false;
        dVar.Y = null;
        dVar.Z = 0;
        dVar.f16192a0 = true;
        dVar.f16194b0 = true;
        dVar.f16196c0 = false;
        dVar.f16198d0 = false;
        dVar.e0 = false;
        dVar.f0 = -1;
        dVar.f16202g0 = -1;
        dVar.f16204h0 = -1;
        dVar.f16205i0 = -1;
        dVar.f16207j0 = Integer.MIN_VALUE;
        dVar.f16209k0 = Integer.MIN_VALUE;
        dVar.f16211l0 = 0.5f;
        dVar.f16219p0 = new w2.e();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, q.f16333b);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            int i3 = z2.c.f16190a.get(index);
            switch (i3) {
                case 1:
                    dVar.V = typedArrayObtainStyledAttributes.getInt(index, dVar.V);
                    break;
                case 2:
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, dVar.f16218p);
                    dVar.f16218p = resourceId;
                    if (resourceId == -1) {
                        dVar.f16218p = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    dVar.f16220q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, dVar.f16220q);
                    break;
                case 4:
                    float f5 = typedArrayObtainStyledAttributes.getFloat(index, dVar.f16221r) % 360.0f;
                    dVar.f16221r = f5;
                    if (f5 < 0.0f) {
                        dVar.f16221r = (360.0f - f5) % 360.0f;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    dVar.f16191a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, dVar.f16191a);
                    break;
                case 6:
                    dVar.f16193b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, dVar.f16193b);
                    break;
                case 7:
                    dVar.f16195c = typedArrayObtainStyledAttributes.getFloat(index, dVar.f16195c);
                    break;
                case 8:
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, dVar.f16199e);
                    dVar.f16199e = resourceId2;
                    if (resourceId2 == -1) {
                        dVar.f16199e = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(index, dVar.f16200f);
                    dVar.f16200f = resourceId3;
                    if (resourceId3 == -1) {
                        dVar.f16200f = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 10:
                    int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(index, dVar.f16201g);
                    dVar.f16201g = resourceId4;
                    if (resourceId4 == -1) {
                        dVar.f16201g = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    int resourceId5 = typedArrayObtainStyledAttributes.getResourceId(index, dVar.f16203h);
                    dVar.f16203h = resourceId5;
                    if (resourceId5 == -1) {
                        dVar.f16203h = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    int resourceId6 = typedArrayObtainStyledAttributes.getResourceId(index, dVar.i);
                    dVar.i = resourceId6;
                    if (resourceId6 == -1) {
                        dVar.i = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    int resourceId7 = typedArrayObtainStyledAttributes.getResourceId(index, dVar.f16206j);
                    dVar.f16206j = resourceId7;
                    if (resourceId7 == -1) {
                        dVar.f16206j = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    int resourceId8 = typedArrayObtainStyledAttributes.getResourceId(index, dVar.f16208k);
                    dVar.f16208k = resourceId8;
                    if (resourceId8 == -1) {
                        dVar.f16208k = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    int resourceId9 = typedArrayObtainStyledAttributes.getResourceId(index, dVar.f16210l);
                    dVar.f16210l = resourceId9;
                    if (resourceId9 == -1) {
                        dVar.f16210l = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    int resourceId10 = typedArrayObtainStyledAttributes.getResourceId(index, dVar.f16212m);
                    dVar.f16212m = resourceId10;
                    if (resourceId10 == -1) {
                        dVar.f16212m = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    int resourceId11 = typedArrayObtainStyledAttributes.getResourceId(index, dVar.f16222s);
                    dVar.f16222s = resourceId11;
                    if (resourceId11 == -1) {
                        dVar.f16222s = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 18:
                    int resourceId12 = typedArrayObtainStyledAttributes.getResourceId(index, dVar.f16223t);
                    dVar.f16223t = resourceId12;
                    if (resourceId12 == -1) {
                        dVar.f16223t = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 19:
                    int resourceId13 = typedArrayObtainStyledAttributes.getResourceId(index, dVar.f16224u);
                    dVar.f16224u = resourceId13;
                    if (resourceId13 == -1) {
                        dVar.f16224u = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                    int resourceId14 = typedArrayObtainStyledAttributes.getResourceId(index, dVar.f16225v);
                    dVar.f16225v = resourceId14;
                    if (resourceId14 == -1) {
                        dVar.f16225v = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                    dVar.f16226w = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, dVar.f16226w);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                    dVar.f16227x = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, dVar.f16227x);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                    dVar.f16228y = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, dVar.f16228y);
                    break;
                case InsecureNonceXChaCha20.NONCE_SIZE_IN_BYTES /* 24 */:
                    dVar.f16229z = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, dVar.f16229z);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                    dVar.A = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, dVar.A);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                    dVar.B = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, dVar.B);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_DESC /* 27 */:
                    dVar.W = typedArrayObtainStyledAttributes.getBoolean(index, dVar.W);
                    break;
                case 28:
                    dVar.X = typedArrayObtainStyledAttributes.getBoolean(index, dVar.X);
                    break;
                case 29:
                    dVar.E = typedArrayObtainStyledAttributes.getFloat(index, dVar.E);
                    break;
                case PolicyBasicListVO.TYPE_ID_HEAD_LIST /* 30 */:
                    dVar.F = typedArrayObtainStyledAttributes.getFloat(index, dVar.F);
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_NUMBER /* 31 */:
                    int i10 = typedArrayObtainStyledAttributes.getInt(index, 0);
                    dVar.L = i10;
                    if (i10 == 1) {
                        Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                        break;
                    } else {
                        break;
                    }
                case 32:
                    int i11 = typedArrayObtainStyledAttributes.getInt(index, 0);
                    dVar.M = i11;
                    if (i11 == 1) {
                        Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                        break;
                    } else {
                        break;
                    }
                case 33:
                    try {
                        dVar.N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, dVar.N);
                        break;
                    } catch (Exception unused) {
                        if (typedArrayObtainStyledAttributes.getInt(index, dVar.N) == -2) {
                            dVar.N = -2;
                            break;
                        } else {
                            break;
                        }
                    }
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_CHECKBOX_OFF /* 34 */:
                    try {
                        dVar.P = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, dVar.P);
                        break;
                    } catch (Exception unused2) {
                        if (typedArrayObtainStyledAttributes.getInt(index, dVar.P) == -2) {
                            dVar.P = -2;
                            break;
                        } else {
                            break;
                        }
                    }
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_ARROW_WITH_CHECKBOX_ON /* 35 */:
                    dVar.R = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, dVar.R));
                    dVar.L = 2;
                    break;
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_LARGE /* 36 */:
                    try {
                        dVar.O = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, dVar.O);
                        break;
                    } catch (Exception unused3) {
                        if (typedArrayObtainStyledAttributes.getInt(index, dVar.O) == -2) {
                            dVar.O = -2;
                            break;
                        } else {
                            break;
                        }
                    }
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_DOUBLE_LINE_LARGE_TITLE /* 37 */:
                    try {
                        dVar.Q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, dVar.Q);
                        break;
                    } catch (Exception unused4) {
                        if (typedArrayObtainStyledAttributes.getInt(index, dVar.Q) == -2) {
                            dVar.Q = -2;
                            break;
                        } else {
                            break;
                        }
                    }
                case PolicyBasicListVO.TYPE_ID_LIST_BASCI_MULTI_LINE_LONG_LARGE /* 38 */:
                    dVar.S = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, dVar.S));
                    dVar.M = 2;
                    break;
                default:
                    switch (i3) {
                        case 44:
                            m.g(dVar, typedArrayObtainStyledAttributes.getString(index));
                            break;
                        case 45:
                            dVar.H = typedArrayObtainStyledAttributes.getFloat(index, dVar.H);
                            break;
                        case 46:
                            dVar.I = typedArrayObtainStyledAttributes.getFloat(index, dVar.I);
                            break;
                        case 47:
                            dVar.J = typedArrayObtainStyledAttributes.getInt(index, 0);
                            break;
                        case 48:
                            dVar.K = typedArrayObtainStyledAttributes.getInt(index, 0);
                            break;
                        case 49:
                            dVar.T = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, dVar.T);
                            break;
                        case 50:
                            dVar.U = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, dVar.U);
                            break;
                        case 51:
                            dVar.Y = typedArrayObtainStyledAttributes.getString(index);
                            break;
                        case 52:
                            int resourceId15 = typedArrayObtainStyledAttributes.getResourceId(index, dVar.f16214n);
                            dVar.f16214n = resourceId15;
                            if (resourceId15 == -1) {
                                dVar.f16214n = typedArrayObtainStyledAttributes.getInt(index, -1);
                                break;
                            } else {
                                break;
                            }
                        case FastDoubleMath.DOUBLE_SIGNIFICAND_WIDTH /* 53 */:
                            int resourceId16 = typedArrayObtainStyledAttributes.getResourceId(index, dVar.f16216o);
                            dVar.f16216o = resourceId16;
                            if (resourceId16 == -1) {
                                dVar.f16216o = typedArrayObtainStyledAttributes.getInt(index, -1);
                                break;
                            } else {
                                break;
                            }
                        case 54:
                            dVar.D = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, dVar.D);
                            break;
                        case 55:
                            dVar.C = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, dVar.C);
                            break;
                        default:
                            switch (i3) {
                                case 64:
                                    m.f(dVar, typedArrayObtainStyledAttributes, index, 0);
                                    break;
                                case 65:
                                    m.f(dVar, typedArrayObtainStyledAttributes, index, 1);
                                    break;
                                case 66:
                                    dVar.Z = typedArrayObtainStyledAttributes.getInt(index, dVar.Z);
                                    break;
                                case 67:
                                    dVar.f16197d = typedArrayObtainStyledAttributes.getBoolean(index, dVar.f16197d);
                                    break;
                            }
                    }
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        dVar.a();
        return dVar;
    }

    public int getMaxHeight() {
        return this.f1001k;
    }

    public int getMaxWidth() {
        return this.f1000j;
    }

    public int getMinHeight() {
        return this.i;
    }

    public int getMinWidth() {
        return this.f999h;
    }

    public int getOptimizationLevel() {
        return this.f998g.C0;
    }

    public String getSceneString() {
        int id2;
        StringBuilder sb2 = new StringBuilder();
        f fVar = this.f998g;
        if (fVar.f15173j == null) {
            int id3 = getId();
            if (id3 != -1) {
                fVar.f15173j = getContext().getResources().getResourceEntryName(id3);
            } else {
                fVar.f15173j = "parent";
            }
        }
        if (fVar.f15169g0 == null) {
            fVar.f15169g0 = fVar.f15173j;
            Log.v("ConstraintLayout", " setDebugName " + fVar.f15169g0);
        }
        ArrayList arrayList = fVar.f15196p0;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            w2.e eVar = (w2.e) obj;
            View view = eVar.e0;
            if (view != null) {
                if (eVar.f15173j == null && (id2 = view.getId()) != -1) {
                    eVar.f15173j = getContext().getResources().getResourceEntryName(id2);
                }
                if (eVar.f15169g0 == null) {
                    eVar.f15169g0 = eVar.f15173j;
                    Log.v("ConstraintLayout", " setDebugName " + eVar.f15169g0);
                }
            }
        }
        fVar.l(sb2);
        return sb2.toString();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i, int i3, int i10, int i11) {
        int childCount = getChildCount();
        boolean zIsInEditMode = isInEditMode();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            d dVar = (d) childAt.getLayoutParams();
            w2.e eVar = dVar.f16219p0;
            if (childAt.getVisibility() != 8 || dVar.f16198d0 || dVar.e0 || zIsInEditMode) {
                int iP = eVar.p();
                int iQ = eVar.q();
                childAt.layout(iP, iQ, eVar.o() + iP, eVar.i() + iQ);
            }
        }
        ArrayList arrayList = this.f997f;
        int size = arrayList.size();
        if (size > 0) {
            for (int i13 = 0; i13 < size; i13++) {
                ((b) arrayList.get(i13)).getClass();
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:292:0x071b  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x072e  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0747  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x0763  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x078b  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x079f  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x07bc  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x07cc  */
    /* JADX WARN: Removed duplicated region for block: B:338:0x07ec  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x07f4  */
    /* JADX WARN: Removed duplicated region for block: B:413:0x0914  */
    /* JADX WARN: Removed duplicated region for block: B:416:0x091a  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r34, int r35) throws java.lang.IllegalAccessException, android.content.res.Resources.NotFoundException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 2546
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup
    public final void onViewAdded(View view) {
        super.onViewAdded(view);
        w2.e eVarB = b(view);
        if ((view instanceof o) && !(eVarB instanceof g)) {
            d dVar = (d) view.getLayoutParams();
            g gVar = new g();
            dVar.f16219p0 = gVar;
            dVar.f16198d0 = true;
            gVar.O(dVar.V);
        }
        if (view instanceof b) {
            b bVar = (b) view;
            bVar.e();
            ((d) view.getLayoutParams()).e0 = true;
            ArrayList arrayList = this.f997f;
            if (!arrayList.contains(bVar)) {
                arrayList.add(bVar);
            }
        }
        this.f996c.put(view.getId(), view);
        this.f1002l = true;
    }

    @Override // android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.f996c.remove(view.getId());
        w2.e eVarB = b(view);
        this.f998g.f15196p0.remove(eVarB);
        eVarB.A();
        this.f997f.remove(view);
        this.f1002l = true;
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        this.f1002l = true;
        super.requestLayout();
    }

    public void setConstraintSet(m mVar) {
        this.f1004n = mVar;
    }

    @Override // android.view.View
    public void setId(int i) {
        int id2 = getId();
        SparseArray sparseArray = this.f996c;
        sparseArray.remove(id2);
        super.setId(i);
        sparseArray.put(getId(), this);
    }

    public void setMaxHeight(int i) {
        if (i == this.f1001k) {
            return;
        }
        this.f1001k = i;
        requestLayout();
    }

    public void setMaxWidth(int i) {
        if (i == this.f1000j) {
            return;
        }
        this.f1000j = i;
        requestLayout();
    }

    public void setMinHeight(int i) {
        if (i == this.i) {
            return;
        }
        this.i = i;
        requestLayout();
    }

    public void setMinWidth(int i) {
        if (i == this.f999h) {
            return;
        }
        this.f999h = i;
        requestLayout();
    }

    public void setOnConstraintsChanged(n nVar) {
        l lVar = this.f1005o;
        if (lVar != null) {
            lVar.getClass();
        }
    }

    public void setOptimizationLevel(int i) {
        this.f1003m = i;
        f fVar = this.f998g;
        fVar.C0 = i;
        c.f13995p = fVar.S(512);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) throws XmlPullParserException, IOException, NumberFormatException {
        super(context, attributeSet);
        this.f996c = new SparseArray();
        this.f997f = new ArrayList(4);
        this.f998g = new f();
        this.f999h = 0;
        this.i = 0;
        this.f1000j = Reader.READ_DONE;
        this.f1001k = Reader.READ_DONE;
        this.f1002l = true;
        this.f1003m = 257;
        this.f1004n = null;
        this.f1005o = null;
        this.f1006p = -1;
        this.f1007q = new HashMap();
        this.f1008r = new SparseArray();
        this.f1009s = new e(this, this);
        this.f1010t = 0;
        this.f1011u = 0;
        c(attributeSet, 0, 0);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i) throws XmlPullParserException, IOException, NumberFormatException {
        super(context, attributeSet, i);
        this.f996c = new SparseArray();
        this.f997f = new ArrayList(4);
        this.f998g = new f();
        this.f999h = 0;
        this.i = 0;
        this.f1000j = Reader.READ_DONE;
        this.f1001k = Reader.READ_DONE;
        this.f1002l = true;
        this.f1003m = 257;
        this.f1004n = null;
        this.f1005o = null;
        this.f1006p = -1;
        this.f1007q = new HashMap();
        this.f1008r = new SparseArray();
        this.f1009s = new e(this, this);
        this.f1010t = 0;
        this.f1011u = 0;
        c(attributeSet, i, 0);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i, int i3) throws XmlPullParserException, IOException, NumberFormatException {
        super(context, attributeSet, i, i3);
        this.f996c = new SparseArray();
        this.f997f = new ArrayList(4);
        this.f998g = new f();
        this.f999h = 0;
        this.i = 0;
        this.f1000j = Reader.READ_DONE;
        this.f1001k = Reader.READ_DONE;
        this.f1002l = true;
        this.f1003m = 257;
        this.f1004n = null;
        this.f1005o = null;
        this.f1006p = -1;
        this.f1007q = new HashMap();
        this.f1008r = new SparseArray();
        this.f1009s = new e(this, this);
        this.f1010t = 0;
        this.f1011u = 0;
        c(attributeSet, i, i3);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        d dVar = new d(layoutParams);
        dVar.f16191a = -1;
        dVar.f16193b = -1;
        dVar.f16195c = -1.0f;
        dVar.f16197d = true;
        dVar.f16199e = -1;
        dVar.f16200f = -1;
        dVar.f16201g = -1;
        dVar.f16203h = -1;
        dVar.i = -1;
        dVar.f16206j = -1;
        dVar.f16208k = -1;
        dVar.f16210l = -1;
        dVar.f16212m = -1;
        dVar.f16214n = -1;
        dVar.f16216o = -1;
        dVar.f16218p = -1;
        dVar.f16220q = 0;
        dVar.f16221r = 0.0f;
        dVar.f16222s = -1;
        dVar.f16223t = -1;
        dVar.f16224u = -1;
        dVar.f16225v = -1;
        dVar.f16226w = Integer.MIN_VALUE;
        dVar.f16227x = Integer.MIN_VALUE;
        dVar.f16228y = Integer.MIN_VALUE;
        dVar.f16229z = Integer.MIN_VALUE;
        dVar.A = Integer.MIN_VALUE;
        dVar.B = Integer.MIN_VALUE;
        dVar.C = Integer.MIN_VALUE;
        dVar.D = 0;
        dVar.E = 0.5f;
        dVar.F = 0.5f;
        dVar.G = null;
        dVar.H = -1.0f;
        dVar.I = -1.0f;
        dVar.J = 0;
        dVar.K = 0;
        dVar.L = 0;
        dVar.M = 0;
        dVar.N = 0;
        dVar.O = 0;
        dVar.P = 0;
        dVar.Q = 0;
        dVar.R = 1.0f;
        dVar.S = 1.0f;
        dVar.T = -1;
        dVar.U = -1;
        dVar.V = -1;
        dVar.W = false;
        dVar.X = false;
        dVar.Y = null;
        dVar.Z = 0;
        dVar.f16192a0 = true;
        dVar.f16194b0 = true;
        dVar.f16196c0 = false;
        dVar.f16198d0 = false;
        dVar.e0 = false;
        dVar.f0 = -1;
        dVar.f16202g0 = -1;
        dVar.f16204h0 = -1;
        dVar.f16205i0 = -1;
        dVar.f16207j0 = Integer.MIN_VALUE;
        dVar.f16209k0 = Integer.MIN_VALUE;
        dVar.f16211l0 = 0.5f;
        dVar.f16219p0 = new w2.e();
        return dVar;
    }
}

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
import androidx.emoji2.text.p;
import f1.b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import o.d;
import o.e;
import o.h;
import org.bouncycastle.asn1.BERTags;
import org.xmlpull.v1.XmlPullParserException;
import r.c;
import r.f;
import r.g;
import r.n;
import r.o;
import r.r;
import r.s;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {

    /* renamed from: s, reason: collision with root package name */
    public static s f359s;

    /* renamed from: a, reason: collision with root package name */
    public final SparseArray f360a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f361b;

    /* renamed from: c, reason: collision with root package name */
    public final e f362c;
    public int d;

    /* renamed from: e, reason: collision with root package name */
    public int f363e;

    /* renamed from: f, reason: collision with root package name */
    public int f364f;

    /* renamed from: g, reason: collision with root package name */
    public int f365g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f366h;

    /* renamed from: j, reason: collision with root package name */
    public int f367j;

    /* renamed from: k, reason: collision with root package name */
    public n f368k;

    /* renamed from: l, reason: collision with root package name */
    public p f369l;

    /* renamed from: m, reason: collision with root package name */
    public int f370m;

    /* renamed from: n, reason: collision with root package name */
    public HashMap f371n;

    /* renamed from: o, reason: collision with root package name */
    public final SparseArray f372o;

    /* renamed from: p, reason: collision with root package name */
    public final f f373p;

    /* renamed from: q, reason: collision with root package name */
    public int f374q;

    /* renamed from: r, reason: collision with root package name */
    public int f375r;

    public ConstraintLayout(Context context, AttributeSet attributeSet) throws XmlPullParserException, IOException, NumberFormatException {
        super(context, attributeSet);
        this.f360a = new SparseArray();
        this.f361b = new ArrayList(4);
        this.f362c = new e();
        this.d = 0;
        this.f363e = 0;
        this.f364f = Integer.MAX_VALUE;
        this.f365g = Integer.MAX_VALUE;
        this.f366h = true;
        this.f367j = 257;
        this.f368k = null;
        this.f369l = null;
        this.f370m = -1;
        this.f371n = new HashMap();
        this.f372o = new SparseArray();
        this.f373p = new f(this, this);
        this.f374q = 0;
        this.f375r = 0;
        i(attributeSet, 0);
    }

    public static r.e g() {
        r.e eVar = new r.e(-2, -2);
        eVar.f4919a = -1;
        eVar.f4921b = -1;
        eVar.f4923c = -1.0f;
        eVar.d = -1;
        eVar.f4926e = -1;
        eVar.f4928f = -1;
        eVar.f4930g = -1;
        eVar.f4932h = -1;
        eVar.f4934i = -1;
        eVar.f4936j = -1;
        eVar.f4938k = -1;
        eVar.f4939l = -1;
        eVar.f4941m = -1;
        eVar.f4943n = -1;
        eVar.f4945o = -1;
        eVar.f4947p = 0;
        eVar.f4948q = 0.0f;
        eVar.f4949r = -1;
        eVar.f4950s = -1;
        eVar.f4951t = -1;
        eVar.f4952u = -1;
        eVar.f4953v = Integer.MIN_VALUE;
        eVar.f4954w = Integer.MIN_VALUE;
        eVar.f4955x = Integer.MIN_VALUE;
        eVar.y = Integer.MIN_VALUE;
        eVar.z = Integer.MIN_VALUE;
        eVar.A = Integer.MIN_VALUE;
        eVar.B = Integer.MIN_VALUE;
        eVar.C = 0;
        eVar.D = 0.5f;
        eVar.E = 0.5f;
        eVar.F = null;
        eVar.G = -1.0f;
        eVar.H = -1.0f;
        eVar.I = 0;
        eVar.J = 0;
        eVar.K = 0;
        eVar.L = 0;
        eVar.M = 0;
        eVar.N = 0;
        eVar.O = 0;
        eVar.P = 0;
        eVar.Q = 1.0f;
        eVar.R = 1.0f;
        eVar.S = -1;
        eVar.T = -1;
        eVar.U = -1;
        eVar.V = false;
        eVar.W = false;
        eVar.X = null;
        eVar.Y = 0;
        eVar.Z = true;
        eVar.f4920a0 = true;
        eVar.f4922b0 = false;
        eVar.f4924c0 = false;
        eVar.f4925d0 = false;
        eVar.f4927e0 = -1;
        eVar.f4929f0 = -1;
        eVar.f4931g0 = -1;
        eVar.f4933h0 = -1;
        eVar.f4935i0 = Integer.MIN_VALUE;
        eVar.f4937j0 = Integer.MIN_VALUE;
        eVar.k0 = 0.5f;
        eVar.f4946o0 = new d();
        return eVar;
    }

    private int getPaddingWidth() {
        int iMax = Math.max(0, getPaddingRight()) + Math.max(0, getPaddingLeft());
        int iMax2 = Math.max(0, getPaddingEnd()) + Math.max(0, getPaddingStart());
        return iMax2 > 0 ? iMax2 : iMax;
    }

    public static s getSharedValues() {
        if (f359s == null) {
            s sVar = new s();
            new SparseIntArray();
            new HashMap();
            f359s = sVar;
        }
        return f359s;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof r.e;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) throws NumberFormatException {
        Object tag;
        int size;
        ArrayList arrayList = this.f361b;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i8 = 0; i8 < size; i8++) {
                ((c) arrayList.get(i8)).getClass();
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            float width = getWidth();
            float height = getHeight();
            int childCount = getChildCount();
            for (int i9 = 0; i9 < childCount; i9++) {
                View childAt = getChildAt(i9);
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
                        float f3 = i13;
                        float f7 = i14;
                        float f9 = i13 + ((int) ((i12 / 1080.0f) * width));
                        canvas.drawLine(f3, f7, f9, f7, paint);
                        float f10 = i14 + ((int) ((Integer.parseInt(strArrSplit[3]) / 1920.0f) * height));
                        canvas.drawLine(f9, f7, f9, f10, paint);
                        canvas.drawLine(f9, f10, f3, f10, paint);
                        canvas.drawLine(f3, f10, f3, f7, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f3, f7, f9, f10, paint);
                        canvas.drawLine(f3, f10, f9, f7, paint);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public final void forceLayout() {
        this.f366h = true;
        super.forceLayout();
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return g();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        r.e eVar = new r.e(context, attributeSet);
        eVar.f4919a = -1;
        eVar.f4921b = -1;
        eVar.f4923c = -1.0f;
        eVar.d = -1;
        eVar.f4926e = -1;
        eVar.f4928f = -1;
        eVar.f4930g = -1;
        eVar.f4932h = -1;
        eVar.f4934i = -1;
        eVar.f4936j = -1;
        eVar.f4938k = -1;
        eVar.f4939l = -1;
        eVar.f4941m = -1;
        eVar.f4943n = -1;
        eVar.f4945o = -1;
        eVar.f4947p = 0;
        eVar.f4948q = 0.0f;
        eVar.f4949r = -1;
        eVar.f4950s = -1;
        eVar.f4951t = -1;
        eVar.f4952u = -1;
        eVar.f4953v = Integer.MIN_VALUE;
        eVar.f4954w = Integer.MIN_VALUE;
        eVar.f4955x = Integer.MIN_VALUE;
        eVar.y = Integer.MIN_VALUE;
        eVar.z = Integer.MIN_VALUE;
        eVar.A = Integer.MIN_VALUE;
        eVar.B = Integer.MIN_VALUE;
        eVar.C = 0;
        eVar.D = 0.5f;
        eVar.E = 0.5f;
        eVar.F = null;
        eVar.G = -1.0f;
        eVar.H = -1.0f;
        eVar.I = 0;
        eVar.J = 0;
        eVar.K = 0;
        eVar.L = 0;
        eVar.M = 0;
        eVar.N = 0;
        eVar.O = 0;
        eVar.P = 0;
        eVar.Q = 1.0f;
        eVar.R = 1.0f;
        eVar.S = -1;
        eVar.T = -1;
        eVar.U = -1;
        eVar.V = false;
        eVar.W = false;
        eVar.X = null;
        eVar.Y = 0;
        eVar.Z = true;
        eVar.f4920a0 = true;
        eVar.f4922b0 = false;
        eVar.f4924c0 = false;
        eVar.f4925d0 = false;
        eVar.f4927e0 = -1;
        eVar.f4929f0 = -1;
        eVar.f4931g0 = -1;
        eVar.f4933h0 = -1;
        eVar.f4935i0 = Integer.MIN_VALUE;
        eVar.f4937j0 = Integer.MIN_VALUE;
        eVar.k0 = 0.5f;
        eVar.f4946o0 = new d();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.f5051b);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i8 = 0; i8 < indexCount; i8++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i8);
            int i9 = r.d.f4918a.get(index);
            switch (i9) {
                case 1:
                    eVar.U = typedArrayObtainStyledAttributes.getInt(index, eVar.U);
                    break;
                case 2:
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f4945o);
                    eVar.f4945o = resourceId;
                    if (resourceId == -1) {
                        eVar.f4945o = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    eVar.f4947p = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.f4947p);
                    break;
                case 4:
                    float f3 = typedArrayObtainStyledAttributes.getFloat(index, eVar.f4948q) % 360.0f;
                    eVar.f4948q = f3;
                    if (f3 < 0.0f) {
                        eVar.f4948q = (360.0f - f3) % 360.0f;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    eVar.f4919a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, eVar.f4919a);
                    break;
                case 6:
                    eVar.f4921b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, eVar.f4921b);
                    break;
                case 7:
                    eVar.f4923c = typedArrayObtainStyledAttributes.getFloat(index, eVar.f4923c);
                    break;
                case 8:
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.d);
                    eVar.d = resourceId2;
                    if (resourceId2 == -1) {
                        eVar.d = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f4926e);
                    eVar.f4926e = resourceId3;
                    if (resourceId3 == -1) {
                        eVar.f4926e = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 10:
                    int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f4928f);
                    eVar.f4928f = resourceId4;
                    if (resourceId4 == -1) {
                        eVar.f4928f = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case BERTags.EMBEDDED_PDV /* 11 */:
                    int resourceId5 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f4930g);
                    eVar.f4930g = resourceId5;
                    if (resourceId5 == -1) {
                        eVar.f4930g = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    int resourceId6 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f4932h);
                    eVar.f4932h = resourceId6;
                    if (resourceId6 == -1) {
                        eVar.f4932h = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case BERTags.RELATIVE_OID /* 13 */:
                    int resourceId7 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f4934i);
                    eVar.f4934i = resourceId7;
                    if (resourceId7 == -1) {
                        eVar.f4934i = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case BERTags.TIME /* 14 */:
                    int resourceId8 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f4936j);
                    eVar.f4936j = resourceId8;
                    if (resourceId8 == -1) {
                        eVar.f4936j = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    int resourceId9 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f4938k);
                    eVar.f4938k = resourceId9;
                    if (resourceId9 == -1) {
                        eVar.f4938k = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    int resourceId10 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f4939l);
                    eVar.f4939l = resourceId10;
                    if (resourceId10 == -1) {
                        eVar.f4939l = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    int resourceId11 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f4949r);
                    eVar.f4949r = resourceId11;
                    if (resourceId11 == -1) {
                        eVar.f4949r = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case BERTags.NUMERIC_STRING /* 18 */:
                    int resourceId12 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f4950s);
                    eVar.f4950s = resourceId12;
                    if (resourceId12 == -1) {
                        eVar.f4950s = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 19:
                    int resourceId13 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f4951t);
                    eVar.f4951t = resourceId13;
                    if (resourceId13 == -1) {
                        eVar.f4951t = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 20:
                    int resourceId14 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f4952u);
                    eVar.f4952u = resourceId14;
                    if (resourceId14 == -1) {
                        eVar.f4952u = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case BERTags.VIDEOTEX_STRING /* 21 */:
                    eVar.f4953v = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.f4953v);
                    break;
                case BERTags.IA5_STRING /* 22 */:
                    eVar.f4954w = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.f4954w);
                    break;
                case BERTags.UTC_TIME /* 23 */:
                    eVar.f4955x = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.f4955x);
                    break;
                case 24:
                    eVar.y = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.y);
                    break;
                case BERTags.GRAPHIC_STRING /* 25 */:
                    eVar.z = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.z);
                    break;
                case BERTags.VISIBLE_STRING /* 26 */:
                    eVar.A = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.A);
                    break;
                case BERTags.GENERAL_STRING /* 27 */:
                    eVar.V = typedArrayObtainStyledAttributes.getBoolean(index, eVar.V);
                    break;
                case BERTags.UNIVERSAL_STRING /* 28 */:
                    eVar.W = typedArrayObtainStyledAttributes.getBoolean(index, eVar.W);
                    break;
                case BERTags.UNRESTRICTED_STRING /* 29 */:
                    eVar.D = typedArrayObtainStyledAttributes.getFloat(index, eVar.D);
                    break;
                case 30:
                    eVar.E = typedArrayObtainStyledAttributes.getFloat(index, eVar.E);
                    break;
                case BERTags.DATE /* 31 */:
                    int i10 = typedArrayObtainStyledAttributes.getInt(index, 0);
                    eVar.K = i10;
                    if (i10 == 1) {
                        Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                        break;
                    } else {
                        break;
                    }
                case 32:
                    int i11 = typedArrayObtainStyledAttributes.getInt(index, 0);
                    eVar.L = i11;
                    if (i11 == 1) {
                        Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                        break;
                    } else {
                        break;
                    }
                case BERTags.DATE_TIME /* 33 */:
                    try {
                        eVar.M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.M);
                        break;
                    } catch (Exception unused) {
                        if (typedArrayObtainStyledAttributes.getInt(index, eVar.M) == -2) {
                            eVar.M = -2;
                            break;
                        } else {
                            break;
                        }
                    }
                case BERTags.DURATION /* 34 */:
                    try {
                        eVar.O = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.O);
                        break;
                    } catch (Exception unused2) {
                        if (typedArrayObtainStyledAttributes.getInt(index, eVar.O) == -2) {
                            eVar.O = -2;
                            break;
                        } else {
                            break;
                        }
                    }
                case BERTags.OBJECT_IDENTIFIER_IRI /* 35 */:
                    eVar.Q = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, eVar.Q));
                    eVar.K = 2;
                    break;
                case BERTags.RELATIVE_OID_IRI /* 36 */:
                    try {
                        eVar.N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.N);
                        break;
                    } catch (Exception unused3) {
                        if (typedArrayObtainStyledAttributes.getInt(index, eVar.N) == -2) {
                            eVar.N = -2;
                            break;
                        } else {
                            break;
                        }
                    }
                case 37:
                    try {
                        eVar.P = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.P);
                        break;
                    } catch (Exception unused4) {
                        if (typedArrayObtainStyledAttributes.getInt(index, eVar.P) == -2) {
                            eVar.P = -2;
                            break;
                        } else {
                            break;
                        }
                    }
                case 38:
                    eVar.R = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, eVar.R));
                    eVar.L = 2;
                    break;
                default:
                    switch (i9) {
                        case 44:
                            n.h(eVar, typedArrayObtainStyledAttributes.getString(index));
                            break;
                        case 45:
                            eVar.G = typedArrayObtainStyledAttributes.getFloat(index, eVar.G);
                            break;
                        case 46:
                            eVar.H = typedArrayObtainStyledAttributes.getFloat(index, eVar.H);
                            break;
                        case 47:
                            eVar.I = typedArrayObtainStyledAttributes.getInt(index, 0);
                            break;
                        case 48:
                            eVar.J = typedArrayObtainStyledAttributes.getInt(index, 0);
                            break;
                        case 49:
                            eVar.S = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, eVar.S);
                            break;
                        case 50:
                            eVar.T = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, eVar.T);
                            break;
                        case 51:
                            eVar.X = typedArrayObtainStyledAttributes.getString(index);
                            break;
                        case 52:
                            int resourceId15 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f4941m);
                            eVar.f4941m = resourceId15;
                            if (resourceId15 == -1) {
                                eVar.f4941m = typedArrayObtainStyledAttributes.getInt(index, -1);
                                break;
                            } else {
                                break;
                            }
                        case 53:
                            int resourceId16 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f4943n);
                            eVar.f4943n = resourceId16;
                            if (resourceId16 == -1) {
                                eVar.f4943n = typedArrayObtainStyledAttributes.getInt(index, -1);
                                break;
                            } else {
                                break;
                            }
                        case 54:
                            eVar.C = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.C);
                            break;
                        case 55:
                            eVar.B = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.B);
                            break;
                        default:
                            switch (i9) {
                                case 64:
                                    n.g(eVar, typedArrayObtainStyledAttributes, index, 0);
                                    break;
                                case 65:
                                    n.g(eVar, typedArrayObtainStyledAttributes, index, 1);
                                    break;
                                case 66:
                                    eVar.Y = typedArrayObtainStyledAttributes.getInt(index, eVar.Y);
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
        return this.f365g;
    }

    public int getMaxWidth() {
        return this.f364f;
    }

    public int getMinHeight() {
        return this.f363e;
    }

    public int getMinWidth() {
        return this.d;
    }

    public int getOptimizationLevel() {
        return this.f362c.C0;
    }

    public final d h(View view) {
        if (view == this) {
            return this.f362c;
        }
        if (view == null) {
            return null;
        }
        if (view.getLayoutParams() instanceof r.e) {
            return ((r.e) view.getLayoutParams()).f4946o0;
        }
        view.setLayoutParams(generateLayoutParams(view.getLayoutParams()));
        if (view.getLayoutParams() instanceof r.e) {
            return ((r.e) view.getLayoutParams()).f4946o0;
        }
        return null;
    }

    public final void i(AttributeSet attributeSet, int i8) throws XmlPullParserException, IOException, NumberFormatException {
        e eVar = this.f362c;
        eVar.f4220e0 = this;
        f fVar = this.f373p;
        eVar.f4253t0 = fVar;
        eVar.f4251r0.f4607f = fVar;
        this.f360a.put(getId(), this);
        this.f368k = null;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, r.f5051b, i8, 0);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i9 = 0; i9 < indexCount; i9++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i9);
                if (index == 16) {
                    this.d = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.d);
                } else if (index == 17) {
                    this.f363e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f363e);
                } else if (index == 14) {
                    this.f364f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f364f);
                } else if (index == 15) {
                    this.f365g = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f365g);
                } else if (index == 112) {
                    this.f367j = typedArrayObtainStyledAttributes.getInt(index, this.f367j);
                } else if (index == 55) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            j(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.f369l = null;
                        }
                    }
                } else if (index == 34) {
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    try {
                        n nVar = new n();
                        this.f368k = nVar;
                        nVar.e(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.f368k = null;
                    }
                    this.f370m = resourceId2;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        eVar.C0 = this.f367j;
        m.c.f3855p = eVar.R(512);
    }

    public final void j(int i8) throws XmlPullParserException, Resources.NotFoundException, IOException, NumberFormatException {
        String str;
        Context context = getContext();
        p pVar = new p(18, false);
        pVar.f623b = new SparseArray();
        pVar.f624c = new SparseArray();
        XmlResourceParser xml = context.getResources().getXml(i8);
        try {
            b bVar = null;
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    switch (name.hashCode()) {
                        case -1349929691:
                            if (name.equals("ConstraintSet")) {
                                pVar.s(context, xml);
                                break;
                            } else {
                                break;
                            }
                        case 80204913:
                            if (name.equals("State")) {
                                bVar = new b(context, xml);
                                ((SparseArray) pVar.f623b).put(bVar.f2546a, bVar);
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
                                g gVar = new g(context, xml);
                                if (bVar != null) {
                                    ((ArrayList) bVar.f2548c).add(gVar);
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
        } catch (IOException e9) {
            e9.printStackTrace();
        } catch (XmlPullParserException e10) {
            e10.printStackTrace();
        }
        this.f369l = pVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:160:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0368  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(o.e r28, int r29, int r30, int r31) {
        /*
            Method dump skipped, instructions count: 1754
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.k(o.e, int, int, int):void");
    }

    public final void l(d dVar, r.e eVar, SparseArray sparseArray, int i8, int i9) {
        View view = (View) this.f360a.get(i8);
        d dVar2 = (d) sparseArray.get(i8);
        if (dVar2 == null || view == null || !(view.getLayoutParams() instanceof r.e)) {
            return;
        }
        eVar.f4922b0 = true;
        if (i9 == 6) {
            r.e eVar2 = (r.e) view.getLayoutParams();
            eVar2.f4922b0 = true;
            eVar2.f4946o0.D = true;
        }
        dVar.i(6).b(dVar2.i(i9), eVar.C, eVar.B, true);
        dVar.D = true;
        dVar.i(3).j();
        dVar.i(5).j();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i8, int i9, int i10, int i11) {
        int childCount = getChildCount();
        boolean zIsInEditMode = isInEditMode();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            r.e eVar = (r.e) childAt.getLayoutParams();
            d dVar = eVar.f4946o0;
            if (childAt.getVisibility() != 8 || eVar.f4924c0 || eVar.f4925d0 || zIsInEditMode) {
                int iO = dVar.o();
                int iP = dVar.p();
                childAt.layout(iO, iP, dVar.n() + iO, dVar.k() + iP);
            }
        }
        ArrayList arrayList = this.f361b;
        int size = arrayList.size();
        if (size > 0) {
            for (int i13 = 0; i13 < size; i13++) {
                ((c) arrayList.get(i13)).getClass();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0354  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0372  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0394  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x03fe  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0409  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0427  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x042f  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x0554  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x055a  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r35, int r36) throws android.content.res.Resources.NotFoundException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 1562
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup
    public final void onViewAdded(View view) {
        super.onViewAdded(view);
        d dVarH = h(view);
        if ((view instanceof r.p) && !(dVarH instanceof h)) {
            r.e eVar = (r.e) view.getLayoutParams();
            h hVar = new h();
            eVar.f4946o0 = hVar;
            eVar.f4924c0 = true;
            hVar.N(eVar.U);
        }
        if (view instanceof c) {
            c cVar = (c) view;
            cVar.i();
            ((r.e) view.getLayoutParams()).f4925d0 = true;
            ArrayList arrayList = this.f361b;
            if (!arrayList.contains(cVar)) {
                arrayList.add(cVar);
            }
        }
        this.f360a.put(view.getId(), view);
        this.f366h = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.f360a.remove(view.getId());
        d dVarH = h(view);
        this.f362c.f4249p0.remove(dVarH);
        dVarH.z();
        this.f361b.remove(view);
        this.f366h = true;
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        this.f366h = true;
        super.requestLayout();
    }

    public void setConstraintSet(n nVar) {
        this.f368k = nVar;
    }

    @Override // android.view.View
    public void setId(int i8) {
        int id = getId();
        SparseArray sparseArray = this.f360a;
        sparseArray.remove(id);
        super.setId(i8);
        sparseArray.put(getId(), this);
    }

    public void setMaxHeight(int i8) {
        if (i8 == this.f365g) {
            return;
        }
        this.f365g = i8;
        requestLayout();
    }

    public void setMaxWidth(int i8) {
        if (i8 == this.f364f) {
            return;
        }
        this.f364f = i8;
        requestLayout();
    }

    public void setMinHeight(int i8) {
        if (i8 == this.f363e) {
            return;
        }
        this.f363e = i8;
        requestLayout();
    }

    public void setMinWidth(int i8) {
        if (i8 == this.d) {
            return;
        }
        this.d = i8;
        requestLayout();
    }

    public void setOnConstraintsChanged(o oVar) {
        p pVar = this.f369l;
        if (pVar != null) {
            pVar.getClass();
        }
    }

    public void setOptimizationLevel(int i8) {
        this.f367j = i8;
        e eVar = this.f362c;
        eVar.C0 = i8;
        m.c.f3855p = eVar.R(512);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i8) throws XmlPullParserException, IOException, NumberFormatException {
        super(context, attributeSet, i8);
        this.f360a = new SparseArray();
        this.f361b = new ArrayList(4);
        this.f362c = new e();
        this.d = 0;
        this.f363e = 0;
        this.f364f = Integer.MAX_VALUE;
        this.f365g = Integer.MAX_VALUE;
        this.f366h = true;
        this.f367j = 257;
        this.f368k = null;
        this.f369l = null;
        this.f370m = -1;
        this.f371n = new HashMap();
        this.f372o = new SparseArray();
        this.f373p = new f(this, this);
        this.f374q = 0;
        this.f375r = 0;
        i(attributeSet, i8);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        r.e eVar = new r.e(layoutParams);
        eVar.f4919a = -1;
        eVar.f4921b = -1;
        eVar.f4923c = -1.0f;
        eVar.d = -1;
        eVar.f4926e = -1;
        eVar.f4928f = -1;
        eVar.f4930g = -1;
        eVar.f4932h = -1;
        eVar.f4934i = -1;
        eVar.f4936j = -1;
        eVar.f4938k = -1;
        eVar.f4939l = -1;
        eVar.f4941m = -1;
        eVar.f4943n = -1;
        eVar.f4945o = -1;
        eVar.f4947p = 0;
        eVar.f4948q = 0.0f;
        eVar.f4949r = -1;
        eVar.f4950s = -1;
        eVar.f4951t = -1;
        eVar.f4952u = -1;
        eVar.f4953v = Integer.MIN_VALUE;
        eVar.f4954w = Integer.MIN_VALUE;
        eVar.f4955x = Integer.MIN_VALUE;
        eVar.y = Integer.MIN_VALUE;
        eVar.z = Integer.MIN_VALUE;
        eVar.A = Integer.MIN_VALUE;
        eVar.B = Integer.MIN_VALUE;
        eVar.C = 0;
        eVar.D = 0.5f;
        eVar.E = 0.5f;
        eVar.F = null;
        eVar.G = -1.0f;
        eVar.H = -1.0f;
        eVar.I = 0;
        eVar.J = 0;
        eVar.K = 0;
        eVar.L = 0;
        eVar.M = 0;
        eVar.N = 0;
        eVar.O = 0;
        eVar.P = 0;
        eVar.Q = 1.0f;
        eVar.R = 1.0f;
        eVar.S = -1;
        eVar.T = -1;
        eVar.U = -1;
        eVar.V = false;
        eVar.W = false;
        eVar.X = null;
        eVar.Y = 0;
        eVar.Z = true;
        eVar.f4920a0 = true;
        eVar.f4922b0 = false;
        eVar.f4924c0 = false;
        eVar.f4925d0 = false;
        eVar.f4927e0 = -1;
        eVar.f4929f0 = -1;
        eVar.f4931g0 = -1;
        eVar.f4933h0 = -1;
        eVar.f4935i0 = Integer.MIN_VALUE;
        eVar.f4937j0 = Integer.MIN_VALUE;
        eVar.k0 = 0.5f;
        eVar.f4946o0 = new d();
        return eVar;
    }
}

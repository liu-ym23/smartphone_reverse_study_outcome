package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public int f12865a = -1;

    /* renamed from: b, reason: collision with root package name */
    public int f12866b = -1;

    /* renamed from: c, reason: collision with root package name */
    public int f12867c = -1;

    /* renamed from: d, reason: collision with root package name */
    public SparseArray<a> f12868d = new SparseArray<>();

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f12869a;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList<b> f12870b = new ArrayList<>();

        /* renamed from: c, reason: collision with root package name */
        public int f12871c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f12872d;

        public a(Context context, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
            this.f12871c = -1;
            this.f12872d = false;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.State);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R$styleable.State_android_id) {
                    this.f12869a = typedArrayObtainStyledAttributes.getResourceId(index, this.f12869a);
                } else if (index == R$styleable.State_constraints) {
                    this.f12871c = typedArrayObtainStyledAttributes.getResourceId(index, this.f12871c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f12871c);
                    context.getResources().getResourceName(this.f12871c);
                    if ("layout".equals(resourceTypeName)) {
                        this.f12872d = true;
                    }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public void a(b bVar) {
            this.f12870b.add(bVar);
        }

        public int b(float f10, float f11) {
            for (int i10 = 0; i10 < this.f12870b.size(); i10++) {
                if (this.f12870b.get(i10).a(f10, f11)) {
                    return i10;
                }
            }
            return -1;
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public float f12873a;

        /* renamed from: b, reason: collision with root package name */
        public float f12874b;

        /* renamed from: c, reason: collision with root package name */
        public float f12875c;

        /* renamed from: d, reason: collision with root package name */
        public float f12876d;

        /* renamed from: e, reason: collision with root package name */
        public int f12877e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f12878f;

        public b(Context context, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
            this.f12873a = Float.NaN;
            this.f12874b = Float.NaN;
            this.f12875c = Float.NaN;
            this.f12876d = Float.NaN;
            this.f12877e = -1;
            this.f12878f = false;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.Variant);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R$styleable.Variant_constraints) {
                    this.f12877e = typedArrayObtainStyledAttributes.getResourceId(index, this.f12877e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f12877e);
                    context.getResources().getResourceName(this.f12877e);
                    if ("layout".equals(resourceTypeName)) {
                        this.f12878f = true;
                    }
                } else if (index == R$styleable.Variant_region_heightLessThan) {
                    this.f12876d = typedArrayObtainStyledAttributes.getDimension(index, this.f12876d);
                } else if (index == R$styleable.Variant_region_heightMoreThan) {
                    this.f12874b = typedArrayObtainStyledAttributes.getDimension(index, this.f12874b);
                } else if (index == R$styleable.Variant_region_widthLessThan) {
                    this.f12875c = typedArrayObtainStyledAttributes.getDimension(index, this.f12875c);
                } else if (index == R$styleable.Variant_region_widthMoreThan) {
                    this.f12873a = typedArrayObtainStyledAttributes.getDimension(index, this.f12873a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public boolean a(float f10, float f11) {
            if (!Float.isNaN(this.f12873a) && f10 < this.f12873a) {
                return false;
            }
            if (!Float.isNaN(this.f12874b) && f11 < this.f12874b) {
                return false;
            }
            if (Float.isNaN(this.f12875c) || f10 <= this.f12875c) {
                return Float.isNaN(this.f12876d) || f11 <= this.f12876d;
            }
            return false;
        }
    }

    public h(Context context, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        b(context, xmlPullParser);
    }

    public int a(int i10, int i11, float f10, float f11) {
        a aVar = this.f12868d.get(i11);
        if (aVar == null) {
            return i11;
        }
        if (f10 != -1.0f && f11 != -1.0f) {
            Iterator<b> it = aVar.f12870b.iterator();
            b bVar = null;
            while (it.hasNext()) {
                b next = it.next();
                if (next.a(f10, f11)) {
                    if (i10 != next.f12877e) {
                        bVar = next;
                    }
                }
            }
            return bVar != null ? bVar.f12877e : aVar.f12871c;
        }
        if (aVar.f12871c != i10) {
            Iterator<b> it2 = aVar.f12870b.iterator();
            while (it2.hasNext()) {
                if (i10 == it2.next().f12877e) {
                }
            }
            return aVar.f12871c;
        }
        return i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(android.content.Context r11, org.xmlpull.v1.XmlPullParser r12) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r10 = this;
            java.lang.String r0 = "Error parsing XML resource"
            java.lang.String r1 = "ConstraintLayoutStates"
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r12)
            int[] r3 = androidx.constraintlayout.widget.R$styleable.StateSet
            android.content.res.TypedArray r2 = r11.obtainStyledAttributes(r2, r3)
            int r3 = r2.getIndexCount()
            r4 = 0
            r5 = r4
        L14:
            if (r5 >= r3) goto L29
            int r6 = r2.getIndex(r5)
            int r7 = androidx.constraintlayout.widget.R$styleable.StateSet_defaultState
            if (r6 != r7) goto L26
            int r7 = r10.f12865a
            int r6 = r2.getResourceId(r6, r7)
            r10.f12865a = r6
        L26:
            int r5 = r5 + 1
            goto L14
        L29:
            r2.recycle()
            int r2 = r12.getEventType()     // Catch: java.io.IOException -> L4a org.xmlpull.v1.XmlPullParserException -> L4c
            r3 = 0
        L31:
            r5 = 1
            if (r2 == r5) goto La8
            java.lang.String r6 = "StateSet"
            r7 = 3
            r8 = 2
            if (r2 == r8) goto L4e
            if (r2 == r7) goto L3e
            goto L9c
        L3e:
            java.lang.String r2 = r12.getName()     // Catch: java.io.IOException -> L4a org.xmlpull.v1.XmlPullParserException -> L4c
            boolean r2 = r6.equals(r2)     // Catch: java.io.IOException -> L4a org.xmlpull.v1.XmlPullParserException -> L4c
            if (r2 == 0) goto L9c
            goto La8
        L4a:
            r10 = move-exception
            goto La1
        L4c:
            r10 = move-exception
            goto La5
        L4e:
            java.lang.String r2 = r12.getName()     // Catch: java.io.IOException -> L4a org.xmlpull.v1.XmlPullParserException -> L4c
            int r9 = r2.hashCode()     // Catch: java.io.IOException -> L4a org.xmlpull.v1.XmlPullParserException -> L4c
            switch(r9) {
                case 80204913: goto L75;
                case 1301459538: goto L6b;
                case 1382829617: goto L64;
                case 1901439077: goto L5a;
                default: goto L59;
            }     // Catch: java.io.IOException -> L4a org.xmlpull.v1.XmlPullParserException -> L4c
        L59:
            goto L7f
        L5a:
            java.lang.String r5 = "Variant"
            boolean r2 = r2.equals(r5)     // Catch: java.io.IOException -> L4a org.xmlpull.v1.XmlPullParserException -> L4c
            if (r2 == 0) goto L7f
            r5 = r7
            goto L80
        L64:
            boolean r2 = r2.equals(r6)     // Catch: java.io.IOException -> L4a org.xmlpull.v1.XmlPullParserException -> L4c
            if (r2 == 0) goto L7f
            goto L80
        L6b:
            java.lang.String r5 = "LayoutDescription"
            boolean r2 = r2.equals(r5)     // Catch: java.io.IOException -> L4a org.xmlpull.v1.XmlPullParserException -> L4c
            if (r2 == 0) goto L7f
            r5 = r4
            goto L80
        L75:
            java.lang.String r5 = "State"
            boolean r2 = r2.equals(r5)     // Catch: java.io.IOException -> L4a org.xmlpull.v1.XmlPullParserException -> L4c
            if (r2 == 0) goto L7f
            r5 = r8
            goto L80
        L7f:
            r5 = -1
        L80:
            if (r5 == r8) goto L90
            if (r5 == r7) goto L85
            goto L9c
        L85:
            androidx.constraintlayout.widget.h$b r2 = new androidx.constraintlayout.widget.h$b     // Catch: java.io.IOException -> L4a org.xmlpull.v1.XmlPullParserException -> L4c
            r2.<init>(r11, r12)     // Catch: java.io.IOException -> L4a org.xmlpull.v1.XmlPullParserException -> L4c
            if (r3 == 0) goto L9c
            r3.a(r2)     // Catch: java.io.IOException -> L4a org.xmlpull.v1.XmlPullParserException -> L4c
            goto L9c
        L90:
            androidx.constraintlayout.widget.h$a r3 = new androidx.constraintlayout.widget.h$a     // Catch: java.io.IOException -> L4a org.xmlpull.v1.XmlPullParserException -> L4c
            r3.<init>(r11, r12)     // Catch: java.io.IOException -> L4a org.xmlpull.v1.XmlPullParserException -> L4c
            android.util.SparseArray<androidx.constraintlayout.widget.h$a> r2 = r10.f12868d     // Catch: java.io.IOException -> L4a org.xmlpull.v1.XmlPullParserException -> L4c
            int r5 = r3.f12869a     // Catch: java.io.IOException -> L4a org.xmlpull.v1.XmlPullParserException -> L4c
            r2.put(r5, r3)     // Catch: java.io.IOException -> L4a org.xmlpull.v1.XmlPullParserException -> L4c
        L9c:
            int r2 = r12.next()     // Catch: java.io.IOException -> L4a org.xmlpull.v1.XmlPullParserException -> L4c
            goto L31
        La1:
            android.util.Log.e(r1, r0, r10)
            goto La8
        La5:
            android.util.Log.e(r1, r0, r10)
        La8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.h.b(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    public int c(int i10, int i11, int i12) {
        return d(-1, i10, i11, i12);
    }

    public int d(int i10, int i11, float f10, float f11) {
        int iB;
        if (i10 == i11) {
            a aVarValueAt = i11 == -1 ? this.f12868d.valueAt(0) : this.f12868d.get(this.f12866b);
            if (aVarValueAt == null) {
                return -1;
            }
            return ((this.f12867c == -1 || !aVarValueAt.f12870b.get(i10).a(f10, f11)) && i10 != (iB = aVarValueAt.b(f10, f11))) ? iB == -1 ? aVarValueAt.f12871c : aVarValueAt.f12870b.get(iB).f12877e : i10;
        }
        a aVar = this.f12868d.get(i11);
        if (aVar == null) {
            return -1;
        }
        int iB2 = aVar.b(f10, f11);
        return iB2 == -1 ? aVar.f12871c : aVar.f12870b.get(iB2).f12877e;
    }
}

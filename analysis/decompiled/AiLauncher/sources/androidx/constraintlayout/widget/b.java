package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f12694a;

    /* renamed from: b, reason: collision with root package name */
    public c f12695b;

    /* renamed from: c, reason: collision with root package name */
    public int f12696c = -1;

    /* renamed from: d, reason: collision with root package name */
    public int f12697d = -1;

    /* renamed from: e, reason: collision with root package name */
    public SparseArray<a> f12698e = new SparseArray<>();

    /* renamed from: f, reason: collision with root package name */
    public SparseArray<c> f12699f = new SparseArray<>();

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f12700a;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList<C0152b> f12701b = new ArrayList<>();

        /* renamed from: c, reason: collision with root package name */
        public int f12702c;

        /* renamed from: d, reason: collision with root package name */
        public c f12703d;

        public a(Context context, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
            this.f12702c = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.State);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R$styleable.State_android_id) {
                    this.f12700a = typedArrayObtainStyledAttributes.getResourceId(index, this.f12700a);
                } else if (index == R$styleable.State_constraints) {
                    this.f12702c = typedArrayObtainStyledAttributes.getResourceId(index, this.f12702c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f12702c);
                    context.getResources().getResourceName(this.f12702c);
                    if ("layout".equals(resourceTypeName)) {
                        c cVar = new c();
                        this.f12703d = cVar;
                        cVar.o(context, this.f12702c);
                    }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public void a(C0152b c0152b) {
            this.f12701b.add(c0152b);
        }

        public int b(float f10, float f11) {
            for (int i10 = 0; i10 < this.f12701b.size(); i10++) {
                if (this.f12701b.get(i10).a(f10, f11)) {
                    return i10;
                }
            }
            return -1;
        }
    }

    /* renamed from: androidx.constraintlayout.widget.b$b, reason: collision with other inner class name */
    public static class C0152b {

        /* renamed from: a, reason: collision with root package name */
        public float f12704a;

        /* renamed from: b, reason: collision with root package name */
        public float f12705b;

        /* renamed from: c, reason: collision with root package name */
        public float f12706c;

        /* renamed from: d, reason: collision with root package name */
        public float f12707d;

        /* renamed from: e, reason: collision with root package name */
        public int f12708e;

        /* renamed from: f, reason: collision with root package name */
        public c f12709f;

        public C0152b(Context context, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
            this.f12704a = Float.NaN;
            this.f12705b = Float.NaN;
            this.f12706c = Float.NaN;
            this.f12707d = Float.NaN;
            this.f12708e = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.Variant);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R$styleable.Variant_constraints) {
                    this.f12708e = typedArrayObtainStyledAttributes.getResourceId(index, this.f12708e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f12708e);
                    context.getResources().getResourceName(this.f12708e);
                    if ("layout".equals(resourceTypeName)) {
                        c cVar = new c();
                        this.f12709f = cVar;
                        cVar.o(context, this.f12708e);
                    }
                } else if (index == R$styleable.Variant_region_heightLessThan) {
                    this.f12707d = typedArrayObtainStyledAttributes.getDimension(index, this.f12707d);
                } else if (index == R$styleable.Variant_region_heightMoreThan) {
                    this.f12705b = typedArrayObtainStyledAttributes.getDimension(index, this.f12705b);
                } else if (index == R$styleable.Variant_region_widthLessThan) {
                    this.f12706c = typedArrayObtainStyledAttributes.getDimension(index, this.f12706c);
                } else if (index == R$styleable.Variant_region_widthMoreThan) {
                    this.f12704a = typedArrayObtainStyledAttributes.getDimension(index, this.f12704a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public boolean a(float f10, float f11) {
            if (!Float.isNaN(this.f12704a) && f10 < this.f12704a) {
                return false;
            }
            if (!Float.isNaN(this.f12705b) && f11 < this.f12705b) {
                return false;
            }
            if (Float.isNaN(this.f12706c) || f10 <= this.f12706c) {
                return Float.isNaN(this.f12707d) || f11 <= this.f12707d;
            }
            return false;
        }
    }

    public b(Context context, ConstraintLayout constraintLayout, int i10) throws XmlPullParserException, Resources.NotFoundException, IOException, NumberFormatException {
        this.f12694a = constraintLayout;
        a(context, i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(android.content.Context r11, int r12) throws org.xmlpull.v1.XmlPullParserException, android.content.res.Resources.NotFoundException, java.io.IOException, java.lang.NumberFormatException {
        /*
            r10 = this;
            java.lang.String r0 = "Error parsing resource: "
            java.lang.String r1 = "ConstraintLayoutStates"
            android.content.res.Resources r2 = r11.getResources()
            android.content.res.XmlResourceParser r2 = r2.getXml(r12)
            int r3 = r2.getEventType()     // Catch: java.io.IOException -> L31 org.xmlpull.v1.XmlPullParserException -> L33
            r4 = 0
        L11:
            r5 = 1
            if (r3 == r5) goto Lab
            r6 = 2
            if (r3 == r6) goto L19
            goto L81
        L19:
            java.lang.String r3 = r2.getName()     // Catch: java.io.IOException -> L31 org.xmlpull.v1.XmlPullParserException -> L33
            int r7 = r3.hashCode()     // Catch: java.io.IOException -> L31 org.xmlpull.v1.XmlPullParserException -> L33
            r8 = 4
            r9 = 3
            switch(r7) {
                case -1349929691: goto L53;
                case 80204913: goto L49;
                case 1382829617: goto L40;
                case 1657696882: goto L36;
                case 1901439077: goto L27;
                default: goto L26;
            }     // Catch: java.io.IOException -> L31 org.xmlpull.v1.XmlPullParserException -> L33
        L26:
            goto L5d
        L27:
            java.lang.String r5 = "Variant"
            boolean r3 = r3.equals(r5)     // Catch: java.io.IOException -> L31 org.xmlpull.v1.XmlPullParserException -> L33
            if (r3 == 0) goto L5d
            r5 = r9
            goto L5e
        L31:
            r10 = move-exception
            goto L86
        L33:
            r10 = move-exception
            goto L99
        L36:
            java.lang.String r5 = "layoutDescription"
            boolean r3 = r3.equals(r5)     // Catch: java.io.IOException -> L31 org.xmlpull.v1.XmlPullParserException -> L33
            if (r3 == 0) goto L5d
            r5 = 0
            goto L5e
        L40:
            java.lang.String r7 = "StateSet"
            boolean r3 = r3.equals(r7)     // Catch: java.io.IOException -> L31 org.xmlpull.v1.XmlPullParserException -> L33
            if (r3 == 0) goto L5d
            goto L5e
        L49:
            java.lang.String r5 = "State"
            boolean r3 = r3.equals(r5)     // Catch: java.io.IOException -> L31 org.xmlpull.v1.XmlPullParserException -> L33
            if (r3 == 0) goto L5d
            r5 = r6
            goto L5e
        L53:
            java.lang.String r5 = "ConstraintSet"
            boolean r3 = r3.equals(r5)     // Catch: java.io.IOException -> L31 org.xmlpull.v1.XmlPullParserException -> L33
            if (r3 == 0) goto L5d
            r5 = r8
            goto L5e
        L5d:
            r5 = -1
        L5e:
            if (r5 == r6) goto L74
            if (r5 == r9) goto L69
            if (r5 == r8) goto L65
            goto L81
        L65:
            r10.b(r11, r2)     // Catch: java.io.IOException -> L31 org.xmlpull.v1.XmlPullParserException -> L33
            goto L81
        L69:
            androidx.constraintlayout.widget.b$b r3 = new androidx.constraintlayout.widget.b$b     // Catch: java.io.IOException -> L31 org.xmlpull.v1.XmlPullParserException -> L33
            r3.<init>(r11, r2)     // Catch: java.io.IOException -> L31 org.xmlpull.v1.XmlPullParserException -> L33
            if (r4 == 0) goto L81
            r4.a(r3)     // Catch: java.io.IOException -> L31 org.xmlpull.v1.XmlPullParserException -> L33
            goto L81
        L74:
            androidx.constraintlayout.widget.b$a r3 = new androidx.constraintlayout.widget.b$a     // Catch: java.io.IOException -> L31 org.xmlpull.v1.XmlPullParserException -> L33
            r3.<init>(r11, r2)     // Catch: java.io.IOException -> L31 org.xmlpull.v1.XmlPullParserException -> L33
            android.util.SparseArray<androidx.constraintlayout.widget.b$a> r4 = r10.f12698e     // Catch: java.io.IOException -> L31 org.xmlpull.v1.XmlPullParserException -> L33
            int r5 = r3.f12700a     // Catch: java.io.IOException -> L31 org.xmlpull.v1.XmlPullParserException -> L33
            r4.put(r5, r3)     // Catch: java.io.IOException -> L31 org.xmlpull.v1.XmlPullParserException -> L33
            r4 = r3
        L81:
            int r3 = r2.next()     // Catch: java.io.IOException -> L31 org.xmlpull.v1.XmlPullParserException -> L33
            goto L11
        L86:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r0)
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            android.util.Log.e(r1, r11, r10)
            goto Lab
        L99:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r0)
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            android.util.Log.e(r1, r11, r10)
        Lab:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.b.a(android.content.Context, int):void");
    }

    public final void b(Context context, XmlPullParser xmlPullParser) throws XmlPullParserException, NumberFormatException, IOException {
        c cVar = new c();
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i10 = 0; i10 < attributeCount; i10++) {
            String attributeName = xmlPullParser.getAttributeName(i10);
            String attributeValue = xmlPullParser.getAttributeValue(i10);
            if (attributeName != null && attributeValue != null && "id".equals(attributeName)) {
                int identifier = attributeValue.contains("/") ? context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName()) : -1;
                if (identifier == -1) {
                    if (attributeValue.length() > 1) {
                        identifier = Integer.parseInt(attributeValue.substring(1));
                    } else {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                    }
                }
                cVar.K(context, xmlPullParser);
                this.f12699f.put(identifier, cVar);
                return;
            }
        }
    }

    public void c(e eVar) {
    }

    public void d(int i10, float f10, float f11) {
        int iB;
        int i11 = this.f12696c;
        if (i11 == i10) {
            a aVarValueAt = i10 == -1 ? this.f12698e.valueAt(0) : this.f12698e.get(i11);
            int i12 = this.f12697d;
            if ((i12 == -1 || !aVarValueAt.f12701b.get(i12).a(f10, f11)) && this.f12697d != (iB = aVarValueAt.b(f10, f11))) {
                c cVar = iB == -1 ? this.f12695b : aVarValueAt.f12701b.get(iB).f12709f;
                if (iB != -1) {
                    int i13 = aVarValueAt.f12701b.get(iB).f12708e;
                }
                if (cVar == null) {
                    return;
                }
                this.f12697d = iB;
                cVar.i(this.f12694a);
                return;
            }
            return;
        }
        this.f12696c = i10;
        a aVar = this.f12698e.get(i10);
        int iB2 = aVar.b(f10, f11);
        c cVar2 = iB2 == -1 ? aVar.f12703d : aVar.f12701b.get(iB2).f12709f;
        if (iB2 != -1) {
            int i14 = aVar.f12701b.get(iB2).f12708e;
        }
        if (cVar2 != null) {
            this.f12697d = iB2;
            cVar2.i(this.f12694a);
            return;
        }
        Log.v("ConstraintLayoutStates", "NO Constraint set found ! id=" + i10 + ", dim =" + f10 + ", " + f11);
    }
}

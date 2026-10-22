package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import com.stepos.minor.Minor;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f8912a;

    /* renamed from: b, reason: collision with root package name */
    d f8913b;

    /* renamed from: c, reason: collision with root package name */
    int f8914c = -1;

    /* renamed from: d, reason: collision with root package name */
    int f8915d = -1;

    /* renamed from: e, reason: collision with root package name */
    private SparseArray<a> f8916e = new SparseArray<>();

    /* renamed from: f, reason: collision with root package name */
    private SparseArray<d> f8917f = new SparseArray<>();

    static class a {

        /* renamed from: a, reason: collision with root package name */
        int f8918a;

        /* renamed from: b, reason: collision with root package name */
        ArrayList<b> f8919b = new ArrayList<>();

        /* renamed from: c, reason: collision with root package name */
        int f8920c;

        /* renamed from: d, reason: collision with root package name */
        d f8921d;

        public a(Context context, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
            this.f8920c = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), i.t7);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i5 = 0; i5 < indexCount; i5++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i5);
                if (index == i.u7) {
                    this.f8918a = typedArrayObtainStyledAttributes.getResourceId(index, this.f8918a);
                } else if (index == i.v7) {
                    this.f8920c = typedArrayObtainStyledAttributes.getResourceId(index, this.f8920c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f8920c);
                    context.getResources().getResourceName(this.f8920c);
                    if ("layout".equals(resourceTypeName)) {
                        d dVar = new d();
                        this.f8921d = dVar;
                        dVar.f(context, this.f8920c);
                    }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        void a(b bVar) {
            this.f8919b.add(bVar);
        }

        public int b(float f5, float f6) {
            for (int i5 = 0; i5 < this.f8919b.size(); i5++) {
                if (this.f8919b.get(i5).a(f5, f6)) {
                    return i5;
                }
            }
            return -1;
        }
    }

    static class b {

        /* renamed from: a, reason: collision with root package name */
        float f8922a;

        /* renamed from: b, reason: collision with root package name */
        float f8923b;

        /* renamed from: c, reason: collision with root package name */
        float f8924c;

        /* renamed from: d, reason: collision with root package name */
        float f8925d;

        /* renamed from: e, reason: collision with root package name */
        int f8926e;

        /* renamed from: f, reason: collision with root package name */
        d f8927f;

        public b(Context context, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
            this.f8922a = Float.NaN;
            this.f8923b = Float.NaN;
            this.f8924c = Float.NaN;
            this.f8925d = Float.NaN;
            this.f8926e = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), i.R7);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i5 = 0; i5 < indexCount; i5++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i5);
                if (index == i.S7) {
                    this.f8926e = typedArrayObtainStyledAttributes.getResourceId(index, this.f8926e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f8926e);
                    context.getResources().getResourceName(this.f8926e);
                    if ("layout".equals(resourceTypeName)) {
                        d dVar = new d();
                        this.f8927f = dVar;
                        dVar.f(context, this.f8926e);
                    }
                } else if (index == i.T7) {
                    this.f8925d = typedArrayObtainStyledAttributes.getDimension(index, this.f8925d);
                } else if (index == i.U7) {
                    this.f8923b = typedArrayObtainStyledAttributes.getDimension(index, this.f8923b);
                } else if (index == i.V7) {
                    this.f8924c = typedArrayObtainStyledAttributes.getDimension(index, this.f8924c);
                } else if (index == i.W7) {
                    this.f8922a = typedArrayObtainStyledAttributes.getDimension(index, this.f8922a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        boolean a(float f5, float f6) {
            if (!Float.isNaN(this.f8922a) && f5 < this.f8922a) {
                return false;
            }
            if (!Float.isNaN(this.f8923b) && f6 < this.f8923b) {
                return false;
            }
            if (Float.isNaN(this.f8924c) || f5 <= this.f8924c) {
                return Float.isNaN(this.f8925d) || f6 <= this.f8925d;
            }
            return false;
        }
    }

    c(Context context, ConstraintLayout constraintLayout, int i5) throws XmlPullParserException, Resources.NotFoundException, IOException, NumberFormatException {
        this.f8912a = constraintLayout;
        a(context, i5);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(android.content.Context r8, int r9) throws org.xmlpull.v1.XmlPullParserException, android.content.res.Resources.NotFoundException, java.io.IOException, java.lang.NumberFormatException {
        /*
            r7 = this;
            android.content.res.Resources r0 = r8.getResources()
            android.content.res.XmlResourceParser r9 = r0.getXml(r9)
            int r0 = r9.getEventType()     // Catch: java.io.IOException -> L82 org.xmlpull.v1.XmlPullParserException -> L87
            r1 = 0
        Ld:
            r2 = 1
            if (r0 == r2) goto L8b
            if (r0 == 0) goto L7a
            r3 = 2
            if (r0 == r3) goto L17
            goto L7d
        L17:
            java.lang.String r0 = r9.getName()     // Catch: java.io.IOException -> L82 org.xmlpull.v1.XmlPullParserException -> L87
            int r4 = r0.hashCode()     // Catch: java.io.IOException -> L82 org.xmlpull.v1.XmlPullParserException -> L87
            r5 = 4
            r6 = 3
            switch(r4) {
                case -1349929691: goto L4c;
                case 80204913: goto L42;
                case 1382829617: goto L39;
                case 1657696882: goto L2f;
                case 1901439077: goto L25;
                default: goto L24;
            }     // Catch: java.io.IOException -> L82 org.xmlpull.v1.XmlPullParserException -> L87
        L24:
            goto L56
        L25:
            java.lang.String r2 = "Variant"
            boolean r0 = r0.equals(r2)     // Catch: java.io.IOException -> L82 org.xmlpull.v1.XmlPullParserException -> L87
            if (r0 == 0) goto L56
            r2 = r6
            goto L57
        L2f:
            java.lang.String r2 = "layoutDescription"
            boolean r0 = r0.equals(r2)     // Catch: java.io.IOException -> L82 org.xmlpull.v1.XmlPullParserException -> L87
            if (r0 == 0) goto L56
            r2 = 0
            goto L57
        L39:
            java.lang.String r4 = "StateSet"
            boolean r0 = r0.equals(r4)     // Catch: java.io.IOException -> L82 org.xmlpull.v1.XmlPullParserException -> L87
            if (r0 == 0) goto L56
            goto L57
        L42:
            java.lang.String r2 = "State"
            boolean r0 = r0.equals(r2)     // Catch: java.io.IOException -> L82 org.xmlpull.v1.XmlPullParserException -> L87
            if (r0 == 0) goto L56
            r2 = r3
            goto L57
        L4c:
            java.lang.String r2 = "ConstraintSet"
            boolean r0 = r0.equals(r2)     // Catch: java.io.IOException -> L82 org.xmlpull.v1.XmlPullParserException -> L87
            if (r0 == 0) goto L56
            r2 = r5
            goto L57
        L56:
            r2 = -1
        L57:
            if (r2 == r3) goto L6d
            if (r2 == r6) goto L62
            if (r2 == r5) goto L5e
            goto L7d
        L5e:
            r7.b(r8, r9)     // Catch: java.io.IOException -> L82 org.xmlpull.v1.XmlPullParserException -> L87
            goto L7d
        L62:
            androidx.constraintlayout.widget.c$b r0 = new androidx.constraintlayout.widget.c$b     // Catch: java.io.IOException -> L82 org.xmlpull.v1.XmlPullParserException -> L87
            r0.<init>(r8, r9)     // Catch: java.io.IOException -> L82 org.xmlpull.v1.XmlPullParserException -> L87
            if (r1 == 0) goto L7d
            r1.a(r0)     // Catch: java.io.IOException -> L82 org.xmlpull.v1.XmlPullParserException -> L87
            goto L7d
        L6d:
            androidx.constraintlayout.widget.c$a r1 = new androidx.constraintlayout.widget.c$a     // Catch: java.io.IOException -> L82 org.xmlpull.v1.XmlPullParserException -> L87
            r1.<init>(r8, r9)     // Catch: java.io.IOException -> L82 org.xmlpull.v1.XmlPullParserException -> L87
            android.util.SparseArray<androidx.constraintlayout.widget.c$a> r0 = r7.f8916e     // Catch: java.io.IOException -> L82 org.xmlpull.v1.XmlPullParserException -> L87
            int r2 = r1.f8918a     // Catch: java.io.IOException -> L82 org.xmlpull.v1.XmlPullParserException -> L87
            r0.put(r2, r1)     // Catch: java.io.IOException -> L82 org.xmlpull.v1.XmlPullParserException -> L87
            goto L7d
        L7a:
            r9.getName()     // Catch: java.io.IOException -> L82 org.xmlpull.v1.XmlPullParserException -> L87
        L7d:
            int r0 = r9.next()     // Catch: java.io.IOException -> L82 org.xmlpull.v1.XmlPullParserException -> L87
            goto Ld
        L82:
            r7 = move-exception
            r7.printStackTrace()
            goto L8b
        L87:
            r7 = move-exception
            r7.printStackTrace()
        L8b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.c.a(android.content.Context, int):void");
    }

    private void b(Context context, XmlPullParser xmlPullParser) throws NumberFormatException {
        d dVar = new d();
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i5 = 0; i5 < attributeCount; i5++) {
            String attributeName = xmlPullParser.getAttributeName(i5);
            String attributeValue = xmlPullParser.getAttributeValue(i5);
            if (attributeName != null && attributeValue != null && Minor.COLUMN_ID.equals(attributeName)) {
                int identifier = attributeValue.contains("/") ? context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), Minor.COLUMN_ID, context.getPackageName()) : -1;
                if (identifier == -1) {
                    if (attributeValue.length() > 1) {
                        identifier = Integer.parseInt(attributeValue.substring(1));
                    } else {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                    }
                }
                dVar.t(context, xmlPullParser);
                this.f8917f.put(identifier, dVar);
                return;
            }
        }
    }

    public void c(f fVar) {
    }

    public void d(int i5, float f5, float f6) {
        int iB;
        int i6 = this.f8914c;
        if (i6 == i5) {
            a aVarValueAt = i5 == -1 ? this.f8916e.valueAt(0) : this.f8916e.get(i6);
            int i7 = this.f8915d;
            if ((i7 == -1 || !aVarValueAt.f8919b.get(i7).a(f5, f6)) && this.f8915d != (iB = aVarValueAt.b(f5, f6))) {
                d dVar = iB == -1 ? this.f8913b : aVarValueAt.f8919b.get(iB).f8927f;
                if (iB != -1) {
                    int i8 = aVarValueAt.f8919b.get(iB).f8926e;
                }
                if (dVar == null) {
                    return;
                }
                this.f8915d = iB;
                dVar.c(this.f8912a);
                return;
            }
            return;
        }
        this.f8914c = i5;
        a aVar = this.f8916e.get(i5);
        int iB2 = aVar.b(f5, f6);
        d dVar2 = iB2 == -1 ? aVar.f8921d : aVar.f8919b.get(iB2).f8927f;
        if (iB2 != -1) {
            int i9 = aVar.f8919b.get(iB2).f8926e;
        }
        if (dVar2 != null) {
            this.f8915d = iB2;
            dVar2.c(this.f8912a);
            return;
        }
        Log.v("ConstraintLayoutStates", "NO Constraint set found ! id=" + i5 + ", dim =" + f5 + ", " + f6);
    }
}

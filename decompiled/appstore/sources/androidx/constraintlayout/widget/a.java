package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2391c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SparseArray f2392d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SparseArray f2393e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ConstraintsChangedListener f2394f;

    /* JADX INFO: renamed from: androidx.constraintlayout.widget.a$a, reason: collision with other inner class name */
    public static class C0012a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2395a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList f2396b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2397c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f2398d;

        public C0012a(Context r10, XmlPullParser r11) {
            this.f2396b = new ArrayList();
            this.f2397c = -1;
            int r12 = 0;
            this.f2398d = false;
            TypedArray r13 = r10.obtainStyledAttributes(Xml.asAttributeSet(r11), R$styleable.State);
            int r14 = r13.getIndexCount();
        L3:
            if (r12 >= r14) goto L13;
            int r15 = r13.getIndex(r12);
            if (r15 != R$styleable.State_android_id) goto L8;
            this.f2395a = r13.getResourceId(r15, this.f2395a);
        L12:
            r12 = r12 + 1;
            goto L3
        L8:
            if (r15 != R$styleable.State_constraints) goto L12;
            this.f2397c = r13.getResourceId(r15, this.f2397c);
            String r16 = r10.getResources().getResourceTypeName(this.f2397c);
            r10.getResources().getResourceName(this.f2397c);
            if ("layout".equals(r16) == false) goto L12;
            this.f2398d = true;
            goto L12
        L13:
            r13.recycle();
        }

        public void a(b r10) {
            this.f2396b.add(r10);
        }

        public int b(float r10, float r11) {
            int r12 = 0;
        L4:
            if (r12 >= this.f2396b.size()) goto L9;
            if (((b) this.f2396b.get(r12)).a(r10, r11) == true) goto L7;
            r12 = r12 + 1;
            goto L4
        L7:
            return r12;
        L9:
            return -1;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f2399a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f2400b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f2401c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f2402d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f2403e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f2404f;

        public b(Context r10, XmlPullParser r11) {
            this.f2399a = Float.NaN;
            this.f2400b = Float.NaN;
            this.f2401c = Float.NaN;
            this.f2402d = Float.NaN;
            this.f2403e = -1;
            int r12 = 0;
            this.f2404f = false;
            TypedArray r13 = r10.obtainStyledAttributes(Xml.asAttributeSet(r11), R$styleable.Variant);
            int r14 = r13.getIndexCount();
        L3:
            if (r12 >= r14) goto L23;
            int r15 = r13.getIndex(r12);
            if (r15 != R$styleable.Variant_constraints) goto L10;
            this.f2403e = r13.getResourceId(r15, this.f2403e);
            String r16 = r10.getResources().getResourceTypeName(this.f2403e);
            r10.getResources().getResourceName(this.f2403e);
            if ("layout".equals(r16) == false) goto L22;
            this.f2404f = true;
        L22:
            r12 = r12 + 1;
            goto L3
        L10:
            if (r15 != R$styleable.Variant_region_heightLessThan) goto L13;
            this.f2402d = r13.getDimension(r15, this.f2402d);
            goto L22
        L13:
            if (r15 != R$styleable.Variant_region_heightMoreThan) goto L16;
            this.f2400b = r13.getDimension(r15, this.f2400b);
            goto L22
        L16:
            if (r15 != R$styleable.Variant_region_widthLessThan) goto L19;
            this.f2401c = r13.getDimension(r15, this.f2401c);
            goto L22
        L19:
            if (r15 != R$styleable.Variant_region_widthMoreThan) goto L21;
            this.f2399a = r13.getDimension(r15, this.f2399a);
            goto L22
        L21:
            Log.v("ConstraintLayoutStates", "Unknown tag");
            goto L22
        L23:
            r13.recycle();
        }

        public boolean a(float r10, float r11) {
            if (Float.isNaN(this.f2399a) == true) goto L8;
            if (r10 >= this.f2399a) goto L8;
            return false;
        L8:
            if (Float.isNaN(this.f2400b) == true) goto L13;
            if (r11 >= this.f2400b) goto L13;
            return false;
        L13:
            if (Float.isNaN(this.f2401c) == true) goto L18;
            if (r10 <= this.f2401c) goto L18;
            return false;
        L18:
            if (Float.isNaN(this.f2402d) == false) goto L20;
            return true;
        L20:
            if (r11 <= this.f2402d) goto L24;
            return false;
        L24:
            return true;
        }
    }

    public a(Context r10, XmlPullParser r11) {
        this.f2389a = -1;
        this.f2390b = -1;
        this.f2391c = -1;
        this.f2392d = new SparseArray();
        this.f2393e = new SparseArray();
        this.f2394f = null;
        b(r10, r11);
    }

    public int a(int r10, int r11, float r12, float r13) {
        C0012a r14 = (C0012a) this.f2392d.get(r11);
        if (r14 != null) goto L6;
        return r11;
    L6:
        if (r12 == (-1.0f)) goto L25;
        if (r13 == (-1.0f)) goto L25;
        Iterator r15 = r14.f2396b.iterator();
        b r16 = null;
    L12:
        if (r15.hasNext() == false) goto L19;
        b r17 = (b) r15.next();
        if (r17.a(r12, r13) == false) goto L12;
        if (r10 == r17.f2403e) goto L17;
        r16 = r17;
        goto L12
    L17:
        return r10;
    L19:
        if (r16 == null) goto L23;
        return r16.f2403e;
    L23:
        return r14.f2397c;
    L25:
        if (r14.f2397c != r10) goto L27;
        return r10;
    L27:
        Iterator r18 = r14.f2396b.iterator();
    L29:
        if (r18.hasNext() == false) goto L34;
        if (r10 != ((b) r18.next()).f2403e) goto L29;
        return r10;
    L34:
        return r14.f2397c;
    }

    public final void b(Context r10, XmlPullParser r11) {
        TypedArray r12 = r10.obtainStyledAttributes(Xml.asAttributeSet(r11), R$styleable.StateSet);
        int r13 = r12.getIndexCount();
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        int r15 = r12.getIndex(r14);
        if (r15 != R$styleable.StateSet_defaultState) goto L7;
        this.f2389a = r12.getResourceId(r15, this.f2389a);
    L7:
        r14 = r14 + 1;
        goto L3
    L8:
        r12.recycle();
        int r16 = r11.getEventType();     // Catch: IOException -> L21 XmlPullParserException -> L23
        C0012a r17 = null;
    L11:
        byte r18 = 1;
        if (r16 == 1) goto L69;
        if (r16 != 0) goto L15;
        r11.getName();     // Catch: IOException -> L21 XmlPullParserException -> L23
    L49:
        r16 = r11.next();     // Catch: IOException -> L21 XmlPullParserException -> L23
        goto L11
    L15:
        if (r16 == 2) goto L25;
        if (r16 != 3) goto L49;
        if ("StateSet".equals(r11.getName()) == false) goto L49;
        return;
    L25:
        String r19 = r11.getName();     // Catch: IOException -> L21 XmlPullParserException -> L23
        switch(r19.hashCode()) {
            case 80204913: goto L38;
            case 1301459538: goto L35;
            case 1382829617: goto L32;
            case 1901439077: goto L29;
            default: goto L40;
        };     // Catch: IOException -> L21 XmlPullParserException -> L23
    L40:
        r18 = -1;
    L41:
        if (r18 == 2) goto L47;
        if (r18 != 3) goto L49;
        b r20 = new b(r10, r11);     // Catch: IOException -> L21 XmlPullParserException -> L23
        if (r17 == null) goto L49;
        r17.a(r20);     // Catch: IOException -> L21 XmlPullParserException -> L23
        goto L49
    L47:
        r17 = new C0012a(r10, r11);     // Catch: IOException -> L21 XmlPullParserException -> L23
        this.f2392d.put(r17.f2395a, r17);     // Catch: IOException -> L21 XmlPullParserException -> L23
        goto L49
    L29:
        if (r19.equals("Variant") == false) goto L40;
        r18 = 3;
        goto L41
    L32:
        if (r19.equals("StateSet") == false) goto L40;
    L35:
        if (r19.equals("LayoutDescription") == false) goto L40;
        r18 = 0;
        goto L41
    L38:
        if (r19.equals("State") == false) goto L40;
        r18 = 2;
        goto L41
    L69:
        return;
    L21:
        e = move-exception;
        e.printStackTrace();
        return;
    L23:
        e = move-exception;
        e.printStackTrace();
    }

    public int c(int r10, int r11, int r12) {
        return d(-1, r10, r11, r12);
    }

    public int d(int r10, int r11, float r12, float r13) {
        if (r10 != r11) goto L21;
        if (r11 != (-1)) goto L6;
        C0012a r14 = (C0012a) this.f2392d.valueAt(0);
    L7:
        if (r14 != null) goto L10;
        return -1;
    L10:
        if (this.f2391c != (-1)) goto L12;
    L14:
        int r15 = r14.b(r12, r13);
        if (r10 != r15) goto L17;
        return r10;
    L17:
        if (r15 != (-1)) goto L20;
        return r14.f2397c;
    L20:
        return ((b) r14.f2396b.get(r15)).f2403e;
    L12:
        if (((b) r14.f2396b.get(r10)).a(r12, r13) == false) goto L14;
        return r10;
    L6:
        r14 = (C0012a) this.f2392d.get(this.f2390b);
        goto L7
    L21:
        C0012a r16 = (C0012a) this.f2392d.get(r11);
        if (r16 != null) goto L24;
        return -1;
    L24:
        int r17 = r16.b(r12, r13);
        if (r17 != (-1)) goto L28;
        return r16.f2397c;
    L28:
        return ((b) r16.f2396b.get(r17)).f2403e;
    }
}

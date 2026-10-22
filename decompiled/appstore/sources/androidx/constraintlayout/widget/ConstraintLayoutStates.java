package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import com.bytedance.librarian.LibrarianImpl;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintLayoutStates {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f2246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ConstraintSet f2247b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2248c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2249d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SparseArray f2250e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SparseArray f2251f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ConstraintsChangedListener f2252g;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2253a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList f2254b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2255c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ConstraintSet f2256d;

        public a(Context r10, XmlPullParser r11) {
            this.f2254b = new ArrayList();
            this.f2255c = -1;
            TypedArray r12 = r10.obtainStyledAttributes(Xml.asAttributeSet(r11), R$styleable.State);
            int r13 = r12.getIndexCount();
            int r14 = 0;
        L3:
            if (r14 >= r13) goto L13;
            int r15 = r12.getIndex(r14);
            if (r15 != R$styleable.State_android_id) goto L8;
            this.f2253a = r12.getResourceId(r15, this.f2253a);
        L12:
            r14 = r14 + 1;
            goto L3
        L8:
            if (r15 != R$styleable.State_constraints) goto L12;
            this.f2255c = r12.getResourceId(r15, this.f2255c);
            String r16 = r10.getResources().getResourceTypeName(this.f2255c);
            r10.getResources().getResourceName(this.f2255c);
            if ("layout".equals(r16) == false) goto L12;
            ConstraintSet r17 = new ConstraintSet();
            this.f2256d = r17;
            r17.p(r10, this.f2255c);
            goto L12
        L13:
            r12.recycle();
        }

        public void a(b r10) {
            this.f2254b.add(r10);
        }

        public int b(float r10, float r11) {
            int r12 = 0;
        L4:
            if (r12 >= this.f2254b.size()) goto L9;
            if (((b) this.f2254b.get(r12)).a(r10, r11) == true) goto L7;
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
        public float f2257a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f2258b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f2259c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f2260d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f2261e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ConstraintSet f2262f;

        public b(Context r10, XmlPullParser r11) {
            this.f2257a = Float.NaN;
            this.f2258b = Float.NaN;
            this.f2259c = Float.NaN;
            this.f2260d = Float.NaN;
            this.f2261e = -1;
            TypedArray r12 = r10.obtainStyledAttributes(Xml.asAttributeSet(r11), R$styleable.Variant);
            int r13 = r12.getIndexCount();
            int r14 = 0;
        L3:
            if (r14 >= r13) goto L23;
            int r15 = r12.getIndex(r14);
            if (r15 != R$styleable.Variant_constraints) goto L10;
            this.f2261e = r12.getResourceId(r15, this.f2261e);
            String r16 = r10.getResources().getResourceTypeName(this.f2261e);
            r10.getResources().getResourceName(this.f2261e);
            if ("layout".equals(r16) == false) goto L22;
            ConstraintSet r17 = new ConstraintSet();
            this.f2262f = r17;
            r17.p(r10, this.f2261e);
        L22:
            r14 = r14 + 1;
            goto L3
        L10:
            if (r15 != R$styleable.Variant_region_heightLessThan) goto L13;
            this.f2260d = r12.getDimension(r15, this.f2260d);
            goto L22
        L13:
            if (r15 != R$styleable.Variant_region_heightMoreThan) goto L16;
            this.f2258b = r12.getDimension(r15, this.f2258b);
            goto L22
        L16:
            if (r15 != R$styleable.Variant_region_widthLessThan) goto L19;
            this.f2259c = r12.getDimension(r15, this.f2259c);
            goto L22
        L19:
            if (r15 != R$styleable.Variant_region_widthMoreThan) goto L21;
            this.f2257a = r12.getDimension(r15, this.f2257a);
            goto L22
        L21:
            Log.v("ConstraintLayoutStates", "Unknown tag");
            goto L22
        L23:
            r12.recycle();
        }

        public boolean a(float r10, float r11) {
            if (Float.isNaN(this.f2257a) == true) goto L8;
            if (r10 >= this.f2257a) goto L8;
            return false;
        L8:
            if (Float.isNaN(this.f2258b) == true) goto L13;
            if (r11 >= this.f2258b) goto L13;
            return false;
        L13:
            if (Float.isNaN(this.f2259c) == true) goto L18;
            if (r10 <= this.f2259c) goto L18;
            return false;
        L18:
            if (Float.isNaN(this.f2260d) == false) goto L20;
            return true;
        L20:
            if (r11 <= this.f2260d) goto L24;
            return false;
        L24:
            return true;
        }
    }

    public ConstraintLayoutStates(Context r10, ConstraintLayout r11, int r12) {
        this.f2248c = -1;
        this.f2249d = -1;
        this.f2250e = new SparseArray();
        this.f2251f = new SparseArray();
        this.f2252g = null;
        this.f2246a = r11;
        a(r10, r12);
    }

    public final void a(Context r10, int r11) {
        XmlResourceParser r12 = r10.getResources().getXml(r11);
        int r13 = r12.getEventType();     // Catch: IOException -> L16 XmlPullParserException -> L18
        a r14 = null;
    L4:
        byte r15 = 1;
        if (r13 == 1) goto L60;
        if (r13 != 0) goto L8;
        r12.getName();     // Catch: IOException -> L16 XmlPullParserException -> L18
    L43:
        r13 = r12.next();     // Catch: IOException -> L16 XmlPullParserException -> L18
    L8:
        if (r13 != 2) goto L43;
        String r16 = r12.getName();     // Catch: IOException -> L16 XmlPullParserException -> L18
        switch(r16.hashCode()) {
            case -1349929691: goto L30;
            case 80204913: goto L27;
            case 1382829617: goto L24;
            case 1657696882: goto L21;
            case 1901439077: goto L14;
            default: goto L32;
        };     // Catch: IOException -> L16 XmlPullParserException -> L18
    L32:
        r15 = -1;
    L33:
        if (r15 == 2) goto L41;
        if (r15 == 3) goto L38;
        if (r15 != 4) goto L43;
        b(r10, r12);     // Catch: IOException -> L16 XmlPullParserException -> L18
        goto L43
    L38:
        b r17 = new b(r10, r12);     // Catch: IOException -> L16 XmlPullParserException -> L18
        if (r14 == null) goto L43;
        r14.a(r17);     // Catch: IOException -> L16 XmlPullParserException -> L18
        goto L43
    L41:
        r14 = new a(r10, r12);     // Catch: IOException -> L16 XmlPullParserException -> L18
        this.f2250e.put(r14.f2253a, r14);     // Catch: IOException -> L16 XmlPullParserException -> L18
        goto L43
    L14:
        if (r16.equals("Variant") == false) goto L32;
        r15 = 3;
        goto L33
    L21:
        if (r16.equals("layoutDescription") == false) goto L32;
        r15 = 0;
        goto L33
    L24:
        if (r16.equals("StateSet") == false) goto L32;
    L27:
        if (r16.equals("State") == false) goto L32;
        r15 = 2;
        goto L33
    L30:
        if (r16.equals("ConstraintSet") == false) goto L32;
        r15 = 4;
        goto L33
    L60:
        return;
    L16:
        e = move-exception;
        e.printStackTrace();
        return;
    L18:
        e = move-exception;
        e.printStackTrace();
    }

    public final void b(Context r10, XmlPullParser r11) {
        ConstraintSet r12 = new ConstraintSet();
        int r13 = r11.getAttributeCount();
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L27;
        String r15 = r11.getAttributeName(r14);
        String r16 = r11.getAttributeValue(r14);
        if (r15 == null) goto L20;
        if (r16 == null) goto L20;
        if ("id".equals(r15) == false) goto L20;
        if (r16.contains(LibrarianImpl.Constants.SEPARATOR) == false) goto L13;
        int r17 = r10.getResources().getIdentifier(r16.substring(r16.indexOf(47) + 1), "id", r10.getPackageName());
    L14:
        if (r17 == (-1)) goto L16;
    L19:
        r12.J(r10, r11);
        this.f2251f.put(r17, r12);
        return;
    L16:
        if (r16.length() <= 1) goto L18;
        r17 = Integer.parseInt(r16.substring(1));
        goto L19
    L18:
        Log.e("ConstraintLayoutStates", "error in parsing id");
        goto L19
    L13:
        r17 = -1;
    L20:
        r14 = r14 + 1;
        goto L3
    }

    public void c(ConstraintsChangedListener r10) {
        this.f2252g = r10;
    }

    public void d(int r10, float r11, float r12) {
        int r13 = this.f2248c;
        if (r13 != r10) goto L29;
        if (r10 != (-1)) goto L6;
        a r14 = (a) this.f2250e.valueAt(0);
    L7:
        int r15 = this.f2249d;
        if (r15 != (-1)) goto L10;
    L12:
        int r16 = r14.b(r11, r12);
        if (this.f2249d != r16) goto L15;
        return;
    L15:
        if (r16 != (-1)) goto L17;
        ConstraintSet r17 = this.f2247b;
    L18:
        if (r16 != (-1)) goto L20;
        int r18 = r14.f2255c;
    L21:
        if (r17 != null) goto L23;
        return;
    L23:
        this.f2249d = r16;
        ConstraintsChangedListener r19 = this.f2252g;
        if (r19 == null) goto L26;
        r19.b(-1, r18);
    L26:
        r17.i(this.f2246a);
        ConstraintsChangedListener r20 = this.f2252g;
        if (r20 == null) goto L46;
        r20.a(-1, r18);
        return;
    L46:
        return;
    L20:
        r18 = ((b) r14.f2254b.get(r16)).f2261e;
        goto L21
    L17:
        r17 = ((b) r14.f2254b.get(r16)).f2262f;
        goto L18
    L10:
        if (((b) r14.f2254b.get(r15)).a(r11, r12) == false) goto L12;
        return;
    L6:
        r14 = (a) this.f2250e.get(r13);
        goto L7
    L29:
        this.f2248c = r10;
        a r21 = (a) this.f2250e.get(r10);
        int r22 = r21.b(r11, r12);
        if (r22 != (-1)) goto L32;
        ConstraintSet r23 = r21.f2256d;
    L33:
        if (r22 != (-1)) goto L35;
        int r24 = r21.f2255c;
    L36:
        if (r23 != null) goto L39;
        Log.v("ConstraintLayoutStates", "NO Constraint set found ! id=" + r10 + ", dim =" + r11 + ", " + r12);
        return;
    L39:
        this.f2249d = r22;
        ConstraintsChangedListener r25 = this.f2252g;
        if (r25 == null) goto L42;
        r25.b(r10, r24);
    L42:
        r23.i(this.f2246a);
        ConstraintsChangedListener r26 = this.f2252g;
        if (r26 == null) goto L48;
        r26.a(r10, r24);
        return;
    L48:
        return;
    L35:
        r24 = ((b) r21.f2254b.get(r22)).f2261e;
        goto L36
    L32:
        r23 = ((b) r21.f2254b.get(r22)).f2262f;
        goto L33
    }
}

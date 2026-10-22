package zc;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import com.bytedance.librarian.LibrarianImpl;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.constraintlayout.widget.R$styleable;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f26345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.obric.oui.constraintlayout.widget.a f26346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f26347c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f26348d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SparseArray f26349e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SparseArray f26350f;

    /* JADX INFO: renamed from: zc.a$a, reason: collision with other inner class name */
    public static class C0422a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f26351a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList f26352b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f26353c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public com.obric.oui.constraintlayout.widget.a f26354d;

        public C0422a(Context r10, XmlPullParser r11) {
            this.f26352b = new ArrayList();
            this.f26353c = -1;
            TypedArray r12 = r10.obtainStyledAttributes(Xml.asAttributeSet(r11), R$styleable.State);
            int r13 = r12.getIndexCount();
            int r14 = 0;
        L3:
            if (r14 >= r13) goto L13;
            int r15 = r12.getIndex(r14);
            if (r15 != R$styleable.State_android_id) goto L8;
            this.f26351a = r12.getResourceId(r15, this.f26351a);
        L12:
            r14 = r14 + 1;
            goto L3
        L8:
            if (r15 != R$styleable.State_constraints) goto L12;
            this.f26353c = r12.getResourceId(r15, this.f26353c);
            String r16 = r10.getResources().getResourceTypeName(this.f26353c);
            r10.getResources().getResourceName(this.f26353c);
            if ("layout".equals(r16) == false) goto L12;
            com.obric.oui.constraintlayout.widget.a r17 = new com.obric.oui.constraintlayout.widget.a();
            this.f26354d = r17;
            r17.n(r10, this.f26353c);
            goto L12
        L13:
            r12.recycle();
        }

        public void a(b r10) {
            this.f26352b.add(r10);
        }

        public int b(float r10, float r11) {
            int r12 = 0;
        L4:
            if (r12 >= this.f26352b.size()) goto L9;
            if (((b) this.f26352b.get(r12)).a(r10, r11) == true) goto L7;
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
        public float f26355a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f26356b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f26357c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f26358d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f26359e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public com.obric.oui.constraintlayout.widget.a f26360f;

        public b(Context r10, XmlPullParser r11) {
            this.f26355a = Float.NaN;
            this.f26356b = Float.NaN;
            this.f26357c = Float.NaN;
            this.f26358d = Float.NaN;
            this.f26359e = -1;
            TypedArray r12 = r10.obtainStyledAttributes(Xml.asAttributeSet(r11), R$styleable.Variant);
            int r13 = r12.getIndexCount();
            int r14 = 0;
        L3:
            if (r14 >= r13) goto L23;
            int r15 = r12.getIndex(r14);
            if (r15 != R$styleable.Variant_constraints) goto L10;
            this.f26359e = r12.getResourceId(r15, this.f26359e);
            String r16 = r10.getResources().getResourceTypeName(this.f26359e);
            r10.getResources().getResourceName(this.f26359e);
            if ("layout".equals(r16) == false) goto L22;
            com.obric.oui.constraintlayout.widget.a r17 = new com.obric.oui.constraintlayout.widget.a();
            this.f26360f = r17;
            r17.n(r10, this.f26359e);
        L22:
            r14 = r14 + 1;
            goto L3
        L10:
            if (r15 != R$styleable.Variant_region_heightLessThan) goto L13;
            this.f26358d = r12.getDimension(r15, this.f26358d);
            goto L22
        L13:
            if (r15 != R$styleable.Variant_region_heightMoreThan) goto L16;
            this.f26356b = r12.getDimension(r15, this.f26356b);
            goto L22
        L16:
            if (r15 != R$styleable.Variant_region_widthLessThan) goto L19;
            this.f26357c = r12.getDimension(r15, this.f26357c);
            goto L22
        L19:
            if (r15 != R$styleable.Variant_region_widthMoreThan) goto L21;
            this.f26355a = r12.getDimension(r15, this.f26355a);
            goto L22
        L21:
            Log.v("ConstraintLayoutStates", "Unknown tag");
            goto L22
        L23:
            r12.recycle();
        }

        public boolean a(float r10, float r11) {
            if (Float.isNaN(this.f26355a) == true) goto L8;
            if (r10 >= this.f26355a) goto L8;
            return false;
        L8:
            if (Float.isNaN(this.f26356b) == true) goto L13;
            if (r11 >= this.f26356b) goto L13;
            return false;
        L13:
            if (Float.isNaN(this.f26357c) == true) goto L18;
            if (r10 <= this.f26357c) goto L18;
            return false;
        L18:
            if (Float.isNaN(this.f26358d) == false) goto L20;
            return true;
        L20:
            if (r11 <= this.f26358d) goto L24;
            return false;
        L24:
            return true;
        }
    }

    public a(Context r10, ConstraintLayout r11, int r12) {
        this.f26347c = -1;
        this.f26348d = -1;
        this.f26349e = new SparseArray();
        this.f26350f = new SparseArray();
        this.f26345a = r11;
        a(r10, r12);
    }

    public final void a(Context r11, int r12) {
        XmlResourceParser r10 = r11.getResources().getXml(r12);
        int r13 = r10.getEventType();     // Catch: IOException -> L15 XmlPullParserException -> L17
        C0422a r14 = null;
    L4:
        byte r15 = 1;
        if (r13 == 1) goto L57;
        if (r13 != 2) goto L41;
        String r16 = r10.getName();     // Catch: IOException -> L15 XmlPullParserException -> L17
        switch(r16.hashCode()) {
            case -1349929691: goto L29;
            case 80204913: goto L26;
            case 1382829617: goto L23;
            case 1657696882: goto L20;
            case 1901439077: goto L13;
            default: goto L31;
        };     // Catch: IOException -> L15 XmlPullParserException -> L17
    L31:
        r15 = -1;
    L32:
        if (r15 == 2) goto L40;
        if (r15 == 3) goto L37;
        if (r15 != 4) goto L41;
        b(r11, r10);     // Catch: IOException -> L15 XmlPullParserException -> L17
        goto L41
    L37:
        b r17 = new b(r11, r10);     // Catch: IOException -> L15 XmlPullParserException -> L17
        if (r14 == null) goto L41;
        r14.a(r17);     // Catch: IOException -> L15 XmlPullParserException -> L17
        goto L41
    L40:
        C0422a r18 = new C0422a(r11, r10);     // Catch: IOException -> L15 XmlPullParserException -> L17
        this.f26349e.put(r18.f26351a, r18);     // Catch: IOException -> L15 XmlPullParserException -> L17
        r14 = r18;
        goto L41
    L13:
        if (r16.equals("Variant") == false) goto L31;
        r15 = 3;
        goto L32
    L20:
        if (r16.equals("layoutDescription") == false) goto L31;
        r15 = 0;
        goto L32
    L23:
        if (r16.equals("StateSet") == false) goto L31;
    L26:
        if (r16.equals("State") == false) goto L31;
        r15 = 2;
        goto L32
    L29:
        if (r16.equals("ConstraintSet") == false) goto L31;
        r15 = 4;
    L41:
        r13 = r10.next();     // Catch: IOException -> L15 XmlPullParserException -> L17
    L57:
        return;
    L15:
        e = move-exception;
        Log.e("ConstraintLayoutStates", "Error parsing resource: " + r12, e);
        return;
    L17:
        e = move-exception;
        Log.e("ConstraintLayoutStates", "Error parsing resource: " + r12, e);
    }

    public final void b(Context r10, XmlPullParser r11) {
        com.obric.oui.constraintlayout.widget.a r12 = new com.obric.oui.constraintlayout.widget.a();
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
        r12.C(r10, r11);
        this.f26350f.put(r17, r12);
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

    public void c(zc.b r10) {
    }

    public void d(int r10, float r11, float r12) {
        int r13 = this.f26347c;
        if (r13 != r10) goto L24;
        if (r10 != (-1)) goto L6;
        C0422a r14 = (C0422a) this.f26349e.valueAt(0);
    L7:
        int r15 = this.f26348d;
        if (r15 != (-1)) goto L10;
    L12:
        int r16 = r14.b(r11, r12);
        if (this.f26348d != r16) goto L15;
        return;
    L15:
        if (r16 != (-1)) goto L17;
        com.obric.oui.constraintlayout.widget.a r17 = this.f26346b;
    L18:
        if (r16 == (-1)) goto L21;
        int r18 = ((b) r14.f26352b.get(r16)).f26359e;
    L21:
        if (r17 != null) goto L23;
        return;
    L23:
        this.f26348d = r16;
        r17.i(this.f26345a);
        return;
    L17:
        r17 = ((b) r14.f26352b.get(r16)).f26360f;
        goto L18
    L10:
        if (((b) r14.f26352b.get(r15)).a(r11, r12) == false) goto L12;
        return;
    L6:
        r14 = (C0422a) this.f26349e.get(r13);
        goto L7
    L24:
        this.f26347c = r10;
        C0422a r19 = (C0422a) this.f26349e.get(r10);
        int r20 = r19.b(r11, r12);
        if (r20 != (-1)) goto L27;
        com.obric.oui.constraintlayout.widget.a r21 = r19.f26354d;
    L28:
        if (r20 == (-1)) goto L31;
        int r22 = ((b) r19.f26352b.get(r20)).f26359e;
    L31:
        if (r21 != null) goto L34;
        Log.v("ConstraintLayoutStates", "NO Constraint set found ! id=" + r10 + ", dim =" + r11 + ", " + r12);
        return;
    L34:
        this.f26348d = r20;
        r21.i(this.f26345a);
        return;
    L27:
        r21 = ((b) r19.f26352b.get(r20)).f26360f;
        goto L28
    }
}

package zc;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import com.obric.oui.constraintlayout.widget.R$styleable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes4.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f26361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f26362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f26363c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SparseArray f26364d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f26365a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList f26366b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f26367c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f26368d;

        public a(Context r10, XmlPullParser r11) {
            this.f26366b = new ArrayList();
            this.f26367c = -1;
            int r12 = 0;
            this.f26368d = false;
            TypedArray r13 = r10.obtainStyledAttributes(Xml.asAttributeSet(r11), R$styleable.State);
            int r14 = r13.getIndexCount();
        L3:
            if (r12 >= r14) goto L13;
            int r15 = r13.getIndex(r12);
            if (r15 != R$styleable.State_android_id) goto L8;
            this.f26365a = r13.getResourceId(r15, this.f26365a);
        L12:
            r12 = r12 + 1;
            goto L3
        L8:
            if (r15 != R$styleable.State_constraints) goto L12;
            this.f26367c = r13.getResourceId(r15, this.f26367c);
            String r16 = r10.getResources().getResourceTypeName(this.f26367c);
            r10.getResources().getResourceName(this.f26367c);
            if ("layout".equals(r16) == false) goto L12;
            this.f26368d = true;
            goto L12
        L13:
            r13.recycle();
        }

        public void a(b r10) {
            this.f26366b.add(r10);
        }

        public int b(float r10, float r11) {
            int r12 = 0;
        L4:
            if (r12 >= this.f26366b.size()) goto L9;
            if (((b) this.f26366b.get(r12)).a(r10, r11) == true) goto L7;
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
        public float f26369a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f26370b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f26371c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f26372d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f26373e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f26374f;

        public b(Context r10, XmlPullParser r11) {
            this.f26369a = Float.NaN;
            this.f26370b = Float.NaN;
            this.f26371c = Float.NaN;
            this.f26372d = Float.NaN;
            this.f26373e = -1;
            int r12 = 0;
            this.f26374f = false;
            TypedArray r13 = r10.obtainStyledAttributes(Xml.asAttributeSet(r11), R$styleable.Variant);
            int r14 = r13.getIndexCount();
        L3:
            if (r12 >= r14) goto L23;
            int r15 = r13.getIndex(r12);
            if (r15 != R$styleable.Variant_constraints) goto L10;
            this.f26373e = r13.getResourceId(r15, this.f26373e);
            String r16 = r10.getResources().getResourceTypeName(this.f26373e);
            r10.getResources().getResourceName(this.f26373e);
            if ("layout".equals(r16) == false) goto L22;
            this.f26374f = true;
        L22:
            r12 = r12 + 1;
            goto L3
        L10:
            if (r15 != R$styleable.Variant_region_heightLessThan) goto L13;
            this.f26372d = r13.getDimension(r15, this.f26372d);
            goto L22
        L13:
            if (r15 != R$styleable.Variant_region_heightMoreThan) goto L16;
            this.f26370b = r13.getDimension(r15, this.f26370b);
            goto L22
        L16:
            if (r15 != R$styleable.Variant_region_widthLessThan) goto L19;
            this.f26371c = r13.getDimension(r15, this.f26371c);
            goto L22
        L19:
            if (r15 != R$styleable.Variant_region_widthMoreThan) goto L21;
            this.f26369a = r13.getDimension(r15, this.f26369a);
            goto L22
        L21:
            Log.v("ConstraintLayoutStates", "Unknown tag");
            goto L22
        L23:
            r13.recycle();
        }

        public boolean a(float r10, float r11) {
            if (Float.isNaN(this.f26369a) == true) goto L8;
            if (r10 >= this.f26369a) goto L8;
            return false;
        L8:
            if (Float.isNaN(this.f26370b) == true) goto L13;
            if (r11 >= this.f26370b) goto L13;
            return false;
        L13:
            if (Float.isNaN(this.f26371c) == true) goto L18;
            if (r10 <= this.f26371c) goto L18;
            return false;
        L18:
            if (Float.isNaN(this.f26372d) == false) goto L20;
            return true;
        L20:
            if (r11 <= this.f26372d) goto L24;
            return false;
        L24:
            return true;
        }
    }

    public c(Context r10, XmlPullParser r11) {
        this.f26361a = -1;
        this.f26362b = -1;
        this.f26363c = -1;
        this.f26364d = new SparseArray();
        b(r10, r11);
    }

    public int a(int r10, int r11, float r12, float r13) {
        a r14 = (a) this.f26364d.get(r11);
        if (r14 != null) goto L6;
        return r11;
    L6:
        if (r12 == (-1.0f)) goto L25;
        if (r13 == (-1.0f)) goto L25;
        Iterator r15 = r14.f26366b.iterator();
        b r16 = null;
    L12:
        if (r15.hasNext() == false) goto L19;
        b r17 = (b) r15.next();
        if (r17.a(r12, r13) == false) goto L12;
        if (r10 == r17.f26373e) goto L17;
        r16 = r17;
        goto L12
    L17:
        return r10;
    L19:
        if (r16 == null) goto L23;
        return r16.f26373e;
    L23:
        return r14.f26367c;
    L25:
        if (r14.f26367c != r10) goto L27;
        return r10;
    L27:
        Iterator r18 = r14.f26366b.iterator();
    L29:
        if (r18.hasNext() == false) goto L34;
        if (r10 != ((b) r18.next()).f26373e) goto L29;
        return r10;
    L34:
        return r14.f26367c;
    }

    public final void b(Context r11, XmlPullParser r12) {
        TypedArray r10 = r11.obtainStyledAttributes(Xml.asAttributeSet(r12), R$styleable.StateSet);
        int r13 = r10.getIndexCount();
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        int r15 = r10.getIndex(r14);
        if (r15 != R$styleable.StateSet_defaultState) goto L7;
        this.f26361a = r10.getResourceId(r15, this.f26361a);
    L7:
        r14 = r14 + 1;
        goto L3
    L8:
        r10.recycle();
        int r16 = r12.getEventType();     // Catch: IOException -> L20 XmlPullParserException -> L22
        a r17 = null;
    L11:
        byte r18 = 1;
        if (r16 == 1) goto L66;
        if (r16 == 2) goto L24;
        if (r16 != 3) goto L47;
        if ("StateSet".equals(r12.getName()) == false) goto L47;
        return;
    L47:
        r16 = r12.next();     // Catch: IOException -> L20 XmlPullParserException -> L22
        goto L11
    L24:
        String r19 = r12.getName();     // Catch: IOException -> L20 XmlPullParserException -> L22
        switch(r19.hashCode()) {
            case 80204913: goto L37;
            case 1301459538: goto L34;
            case 1382829617: goto L31;
            case 1901439077: goto L28;
            default: goto L39;
        };     // Catch: IOException -> L20 XmlPullParserException -> L22
    L39:
        r18 = -1;
    L40:
        if (r18 == 2) goto L46;
        if (r18 != 3) goto L47;
        b r20 = new b(r11, r12);     // Catch: IOException -> L20 XmlPullParserException -> L22
        if (r17 == null) goto L47;
        r17.a(r20);     // Catch: IOException -> L20 XmlPullParserException -> L22
        goto L47
    L46:
        r17 = new a(r11, r12);     // Catch: IOException -> L20 XmlPullParserException -> L22
        this.f26364d.put(r17.f26365a, r17);     // Catch: IOException -> L20 XmlPullParserException -> L22
        goto L47
    L28:
        if (r19.equals("Variant") == false) goto L39;
        r18 = 3;
        goto L40
    L31:
        if (r19.equals("StateSet") == false) goto L39;
    L34:
        if (r19.equals("LayoutDescription") == false) goto L39;
        r18 = 0;
        goto L40
    L37:
        if (r19.equals("State") == false) goto L39;
        r18 = 2;
        goto L40
    L66:
        return;
    L20:
        e = move-exception;
        Log.e("ConstraintLayoutStates", "Error parsing XML resource", e);
        return;
    L22:
        e = move-exception;
        Log.e("ConstraintLayoutStates", "Error parsing XML resource", e);
    }

    public int c(int r10, int r11, int r12) {
        return d(-1, r10, r11, r12);
    }

    public int d(int r10, int r11, float r12, float r13) {
        if (r10 != r11) goto L21;
        if (r11 != (-1)) goto L6;
        a r14 = (a) this.f26364d.valueAt(0);
    L7:
        if (r14 != null) goto L10;
        return -1;
    L10:
        if (this.f26363c != (-1)) goto L12;
    L14:
        int r15 = r14.b(r12, r13);
        if (r10 != r15) goto L17;
        return r10;
    L17:
        if (r15 != (-1)) goto L20;
        return r14.f26367c;
    L20:
        return ((b) r14.f26366b.get(r15)).f26373e;
    L12:
        if (((b) r14.f26366b.get(r10)).a(r12, r13) == false) goto L14;
        return r10;
    L6:
        r14 = (a) this.f26364d.get(this.f26362b);
        goto L7
    L21:
        a r16 = (a) this.f26364d.get(r11);
        if (r16 != null) goto L24;
        return -1;
    L24:
        int r17 = r16.b(r12, r13);
        if (r17 != (-1)) goto L28;
        return r16.f26367c;
    L28:
        return ((b) r16.f26366b.get(r17)).f26373e;
    }
}

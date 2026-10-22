package Z2;

import Z2.l;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;
import java.io.IOException;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes2.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    public final int f7264a;

    /* renamed from: b, reason: collision with root package name */
    public final l f7265b;

    /* renamed from: c, reason: collision with root package name */
    public final int[][] f7266c;

    /* renamed from: d, reason: collision with root package name */
    public final l[] f7267d;

    /* renamed from: e, reason: collision with root package name */
    public final r f7268e;

    /* renamed from: f, reason: collision with root package name */
    public final r f7269f;

    /* renamed from: g, reason: collision with root package name */
    public final r f7270g;

    /* renamed from: h, reason: collision with root package name */
    public final r f7271h;

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public int f7272a;

        /* renamed from: b, reason: collision with root package name */
        public l f7273b;

        /* renamed from: c, reason: collision with root package name */
        public int[][] f7274c;

        /* renamed from: d, reason: collision with root package name */
        public l[] f7275d;

        /* renamed from: e, reason: collision with root package name */
        public r f7276e;

        /* renamed from: f, reason: collision with root package name */
        public r f7277f;

        /* renamed from: g, reason: collision with root package name */
        public r f7278g;

        /* renamed from: h, reason: collision with root package name */
        public r f7279h;

        public b i(int[] iArr, l lVar) {
            int i10 = this.f7272a;
            if (i10 == 0 || iArr.length == 0) {
                this.f7273b = lVar;
            }
            if (i10 >= this.f7274c.length) {
                l(i10, i10 + 10);
            }
            int[][] iArr2 = this.f7274c;
            int i11 = this.f7272a;
            iArr2[i11] = iArr;
            this.f7275d[i11] = lVar;
            this.f7272a = i11 + 1;
            return this;
        }

        public s j() {
            if (this.f7272a == 0) {
                return null;
            }
            return new s(this);
        }

        public final boolean k(int i10, int i11) {
            return (i10 | i11) == i10;
        }

        public final void l(int i10, int i11) {
            int[][] iArr = new int[i11][];
            System.arraycopy(this.f7274c, 0, iArr, 0, i10);
            this.f7274c = iArr;
            l[] lVarArr = new l[i11];
            System.arraycopy(this.f7275d, 0, lVarArr, 0, i10);
            this.f7275d = lVarArr;
        }

        public final void m() {
            this.f7273b = new l();
            this.f7274c = new int[10][];
            this.f7275d = new l[10];
        }

        public b n(r rVar, int i10) {
            if (k(i10, 1)) {
                this.f7276e = rVar;
            }
            if (k(i10, 2)) {
                this.f7277f = rVar;
            }
            if (k(i10, 4)) {
                this.f7278g = rVar;
            }
            if (k(i10, 8)) {
                this.f7279h = rVar;
            }
            return this;
        }

        public b(s sVar) {
            int i10 = sVar.f7264a;
            this.f7272a = i10;
            this.f7273b = sVar.f7265b;
            int[][] iArr = sVar.f7266c;
            int[][] iArr2 = new int[iArr.length][];
            this.f7274c = iArr2;
            this.f7275d = new l[sVar.f7267d.length];
            System.arraycopy(iArr, 0, iArr2, 0, i10);
            System.arraycopy(sVar.f7267d, 0, this.f7275d, 0, this.f7272a);
            this.f7276e = sVar.f7268e;
            this.f7277f = sVar.f7269f;
            this.f7278g = sVar.f7270g;
            this.f7279h = sVar.f7271h;
        }

        public b(l lVar) {
            m();
            i(StateSet.WILD_CARD, lVar);
        }

        public b(Context context, int i10) throws Resources.NotFoundException {
            int next;
            m();
            try {
                XmlResourceParser xml = context.getResources().getXml(i10);
                try {
                    AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                    do {
                        next = xml.next();
                        if (next == 2) {
                            break;
                        }
                    } while (next != 1);
                    if (next == 2) {
                        if (xml.getName().equals("selector")) {
                            s.g(this, context, xml, attributeSetAsAttributeSet, context.getTheme());
                        }
                        xml.close();
                        return;
                    }
                    throw new XmlPullParserException("No start tag found");
                } catch (Throwable th) {
                    if (xml != null) {
                        try {
                            xml.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (Resources.NotFoundException | IOException | XmlPullParserException unused) {
                m();
            }
        }
    }

    public static s b(Context context, TypedArray typedArray, int i10) {
        int resourceId = typedArray.getResourceId(i10, 0);
        if (resourceId != 0 && Objects.equals(context.getResources().getResourceTypeName(resourceId), "xml")) {
            return new b(context, resourceId).j();
        }
        return null;
    }

    public static void g(b bVar, Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next == 3) {
                return;
            }
            if (next == 2 && depth2 <= depth && xmlPullParser.getName().equals("item")) {
                TypedArray typedArrayObtainAttributes = theme == null ? context.getResources().obtainAttributes(attributeSet, R$styleable.MaterialShape) : theme.obtainStyledAttributes(attributeSet, R$styleable.MaterialShape, 0, 0);
                l lVarM = l.b(context, typedArrayObtainAttributes.getResourceId(R$styleable.MaterialShape_shapeAppearance, 0), typedArrayObtainAttributes.getResourceId(R$styleable.MaterialShape_shapeAppearanceOverlay, 0)).m();
                typedArrayObtainAttributes.recycle();
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr = new int[attributeCount];
                int i10 = 0;
                for (int i11 = 0; i11 < attributeCount; i11++) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i11);
                    if (attributeNameResource != R$attr.shapeAppearance && attributeNameResource != R$attr.shapeAppearanceOverlay) {
                        int i12 = i10 + 1;
                        if (!attributeSet.getAttributeBooleanValue(i11, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr[i10] = attributeNameResource;
                        i10 = i12;
                    }
                }
                bVar.i(StateSet.trimStateSet(iArr, i10), lVarM);
            }
        }
    }

    public static int h(int i10) {
        int i11 = i10 & 5;
        return ((i10 & 10) >> 1) | (i11 << 1);
    }

    public l c(boolean z10) {
        if (!z10 || (this.f7268e == null && this.f7269f == null && this.f7270g == null && this.f7271h == null)) {
            return this.f7265b;
        }
        l.b bVarW = this.f7265b.w();
        r rVar = this.f7268e;
        if (rVar != null) {
            bVarW.D(rVar.e());
        }
        r rVar2 = this.f7269f;
        if (rVar2 != null) {
            bVarW.H(rVar2.e());
        }
        r rVar3 = this.f7270g;
        if (rVar3 != null) {
            bVarW.v(rVar3.e());
        }
        r rVar4 = this.f7271h;
        if (rVar4 != null) {
            bVarW.z(rVar4.e());
        }
        return bVarW.m();
    }

    public l d(int[] iArr) {
        int iE = e(iArr);
        if (iE < 0) {
            iE = e(StateSet.WILD_CARD);
        }
        if (this.f7268e == null && this.f7269f == null && this.f7270g == null && this.f7271h == null) {
            return this.f7267d[iE];
        }
        l.b bVarW = this.f7267d[iE].w();
        r rVar = this.f7268e;
        if (rVar != null) {
            bVarW.D(rVar.d(iArr));
        }
        r rVar2 = this.f7269f;
        if (rVar2 != null) {
            bVarW.H(rVar2.d(iArr));
        }
        r rVar3 = this.f7270g;
        if (rVar3 != null) {
            bVarW.v(rVar3.d(iArr));
        }
        r rVar4 = this.f7271h;
        if (rVar4 != null) {
            bVarW.z(rVar4.d(iArr));
        }
        return bVarW.m();
    }

    public final int e(int[] iArr) {
        int[][] iArr2 = this.f7266c;
        for (int i10 = 0; i10 < this.f7264a; i10++) {
            if (StateSet.stateSetMatches(iArr2[i10], iArr)) {
                return i10;
            }
        }
        return -1;
    }

    public boolean f() {
        r rVar;
        r rVar2;
        r rVar3;
        r rVar4;
        return this.f7264a > 1 || ((rVar = this.f7268e) != null && rVar.h()) || (((rVar2 = this.f7269f) != null && rVar2.h()) || (((rVar3 = this.f7270g) != null && rVar3.h()) || ((rVar4 = this.f7271h) != null && rVar4.h())));
    }

    public b i() {
        return new b(this);
    }

    public s(b bVar) {
        this.f7264a = bVar.f7272a;
        this.f7265b = bVar.f7273b;
        this.f7266c = bVar.f7274c;
        this.f7267d = bVar.f7275d;
        this.f7268e = bVar.f7276e;
        this.f7269f = bVar.f7277f;
        this.f7270g = bVar.f7278g;
        this.f7271h = bVar.f7279h;
    }
}

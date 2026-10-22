package t1;

import a1.C0409b;
import a1.C0418k;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import java.io.IOException;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import t1.l;

/* loaded from: classes.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    final int f22460a;

    /* renamed from: b, reason: collision with root package name */
    final l f22461b;

    /* renamed from: c, reason: collision with root package name */
    final int[][] f22462c;

    /* renamed from: d, reason: collision with root package name */
    final l[] f22463d;

    /* renamed from: e, reason: collision with root package name */
    final p f22464e;

    /* renamed from: f, reason: collision with root package name */
    final p f22465f;

    /* renamed from: g, reason: collision with root package name */
    final p f22466g;

    /* renamed from: h, reason: collision with root package name */
    final p f22467h;

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private int f22468a;

        /* renamed from: b, reason: collision with root package name */
        private l f22469b;

        /* renamed from: c, reason: collision with root package name */
        private int[][] f22470c;

        /* renamed from: d, reason: collision with root package name */
        private l[] f22471d;

        /* renamed from: e, reason: collision with root package name */
        private p f22472e;

        /* renamed from: f, reason: collision with root package name */
        private p f22473f;

        /* renamed from: g, reason: collision with root package name */
        private p f22474g;

        /* renamed from: h, reason: collision with root package name */
        private p f22475h;

        private boolean k(int i5, int i6) {
            return (i5 | i6) == i5;
        }

        private void l(int i5, int i6) {
            int[][] iArr = new int[i6][];
            System.arraycopy(this.f22470c, 0, iArr, 0, i5);
            this.f22470c = iArr;
            l[] lVarArr = new l[i6];
            System.arraycopy(this.f22471d, 0, lVarArr, 0, i5);
            this.f22471d = lVarArr;
        }

        private void m() {
            this.f22469b = new l();
            this.f22470c = new int[10][];
            this.f22471d = new l[10];
        }

        public b i(int[] iArr, l lVar) {
            int i5 = this.f22468a;
            if (i5 == 0 || iArr.length == 0) {
                this.f22469b = lVar;
            }
            if (i5 >= this.f22470c.length) {
                l(i5, i5 + 10);
            }
            int[][] iArr2 = this.f22470c;
            int i6 = this.f22468a;
            iArr2[i6] = iArr;
            this.f22471d[i6] = lVar;
            this.f22468a = i6 + 1;
            return this;
        }

        public q j() {
            if (this.f22468a == 0) {
                return null;
            }
            return new q(this);
        }

        public b n(p pVar, int i5) {
            if (k(i5, 1)) {
                this.f22472e = pVar;
            }
            if (k(i5, 2)) {
                this.f22473f = pVar;
            }
            if (k(i5, 4)) {
                this.f22474g = pVar;
            }
            if (k(i5, 8)) {
                this.f22475h = pVar;
            }
            return this;
        }

        public b(q qVar) {
            int i5 = qVar.f22460a;
            this.f22468a = i5;
            this.f22469b = qVar.f22461b;
            int[][] iArr = qVar.f22462c;
            int[][] iArr2 = new int[iArr.length][];
            this.f22470c = iArr2;
            this.f22471d = new l[qVar.f22463d.length];
            System.arraycopy(iArr, 0, iArr2, 0, i5);
            System.arraycopy(qVar.f22463d, 0, this.f22471d, 0, this.f22468a);
            this.f22472e = qVar.f22464e;
            this.f22473f = qVar.f22465f;
            this.f22474g = qVar.f22466g;
            this.f22475h = qVar.f22467h;
        }

        public b(l lVar) {
            m();
            i(StateSet.WILD_CARD, lVar);
        }

        private b(Context context, int i5) throws Resources.NotFoundException {
            int next;
            m();
            try {
                XmlResourceParser xml = context.getResources().getXml(i5);
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
                            q.g(this, context, xml, attributeSetAsAttributeSet, context.getTheme());
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

    public static q b(Context context, TypedArray typedArray, int i5) {
        int resourceId = typedArray.getResourceId(i5, 0);
        if (resourceId != 0 && Objects.equals(context.getResources().getResourceTypeName(resourceId), "xml")) {
            return new b(context, resourceId).j();
        }
        return null;
    }

    private int e(int[] iArr) {
        int[][] iArr2 = this.f22462c;
        for (int i5 = 0; i5 < this.f22460a; i5++) {
            if (StateSet.stateSetMatches(iArr2[i5], iArr)) {
                return i5;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
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
                TypedArray typedArrayObtainAttributes = theme == null ? context.getResources().obtainAttributes(attributeSet, C0418k.f7178n3) : theme.obtainStyledAttributes(attributeSet, C0418k.f7178n3, 0, 0);
                l lVarM = l.b(context, typedArrayObtainAttributes.getResourceId(C0418k.f7184o3, 0), typedArrayObtainAttributes.getResourceId(C0418k.f7190p3, 0)).m();
                typedArrayObtainAttributes.recycle();
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr = new int[attributeCount];
                int i5 = 0;
                for (int i6 = 0; i6 < attributeCount; i6++) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i6);
                    if (attributeNameResource != C0409b.f6701K && attributeNameResource != C0409b.f6702L) {
                        int i7 = i5 + 1;
                        if (!attributeSet.getAttributeBooleanValue(i6, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr[i5] = attributeNameResource;
                        i5 = i7;
                    }
                }
                bVar.i(StateSet.trimStateSet(iArr, i5), lVarM);
            }
        }
    }

    public static int h(int i5) {
        int i6 = i5 & 5;
        return ((i5 & 10) >> 1) | (i6 << 1);
    }

    public l c(boolean z5) {
        if (!z5 || (this.f22464e == null && this.f22465f == null && this.f22466g == null && this.f22467h == null)) {
            return this.f22461b;
        }
        l.b bVarW = this.f22461b.w();
        p pVar = this.f22464e;
        if (pVar != null) {
            bVarW.D(pVar.e());
        }
        p pVar2 = this.f22465f;
        if (pVar2 != null) {
            bVarW.H(pVar2.e());
        }
        p pVar3 = this.f22466g;
        if (pVar3 != null) {
            bVarW.v(pVar3.e());
        }
        p pVar4 = this.f22467h;
        if (pVar4 != null) {
            bVarW.z(pVar4.e());
        }
        return bVarW.m();
    }

    protected l d(int[] iArr) {
        int iE = e(iArr);
        if (iE < 0) {
            iE = e(StateSet.WILD_CARD);
        }
        if (this.f22464e == null && this.f22465f == null && this.f22466g == null && this.f22467h == null) {
            return this.f22463d[iE];
        }
        l.b bVarW = this.f22463d[iE].w();
        p pVar = this.f22464e;
        if (pVar != null) {
            bVarW.D(pVar.d(iArr));
        }
        p pVar2 = this.f22465f;
        if (pVar2 != null) {
            bVarW.H(pVar2.d(iArr));
        }
        p pVar3 = this.f22466g;
        if (pVar3 != null) {
            bVarW.v(pVar3.d(iArr));
        }
        p pVar4 = this.f22467h;
        if (pVar4 != null) {
            bVarW.z(pVar4.d(iArr));
        }
        return bVarW.m();
    }

    public boolean f() {
        p pVar;
        p pVar2;
        p pVar3;
        p pVar4;
        return this.f22460a > 1 || ((pVar = this.f22464e) != null && pVar.h()) || (((pVar2 = this.f22465f) != null && pVar2.h()) || (((pVar3 = this.f22466g) != null && pVar3.h()) || ((pVar4 = this.f22467h) != null && pVar4.h())));
    }

    public b i() {
        return new b(this);
    }

    private q(b bVar) {
        this.f22460a = bVar.f22468a;
        this.f22461b = bVar.f22469b;
        this.f22462c = bVar.f22470c;
        this.f22463d = bVar.f22471d;
        this.f22464e = bVar.f22472e;
        this.f22465f = bVar.f22473f;
        this.f22466g = bVar.f22474g;
        this.f22467h = bVar.f22475h;
    }
}

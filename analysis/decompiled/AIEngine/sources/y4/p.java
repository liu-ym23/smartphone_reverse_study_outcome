package y4;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import com.stepos.aiengine.R;
import java.io.IOException;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParserException;
import y4.j;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final int f14119a;

    /* renamed from: b, reason: collision with root package name */
    public final j f14120b;

    /* renamed from: c, reason: collision with root package name */
    public final int[][] f14121c;

    /* renamed from: d, reason: collision with root package name */
    public final j[] f14122d;

    /* renamed from: e, reason: collision with root package name */
    public final o f14123e;

    /* renamed from: f, reason: collision with root package name */
    public final o f14124f;

    /* renamed from: g, reason: collision with root package name */
    public final o f14125g;
    public final o h;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public int f14126a;

        /* renamed from: b, reason: collision with root package name */
        public j f14127b;

        /* renamed from: c, reason: collision with root package name */
        public int[][] f14128c;

        /* renamed from: d, reason: collision with root package name */
        public j[] f14129d;

        /* renamed from: e, reason: collision with root package name */
        public o f14130e;

        /* renamed from: f, reason: collision with root package name */
        public o f14131f;

        /* renamed from: g, reason: collision with root package name */
        public o f14132g;
        public o h;

        public a(j jVar) {
            b();
            a(StateSet.WILD_CARD, jVar);
        }

        public final void a(int[] iArr, j jVar) {
            int i10 = this.f14126a;
            if (i10 == 0 || iArr.length == 0) {
                this.f14127b = jVar;
            }
            int[][] iArr2 = this.f14128c;
            if (i10 >= iArr2.length) {
                int i11 = i10 + 10;
                int[][] iArr3 = new int[i11][];
                System.arraycopy(iArr2, 0, iArr3, 0, i10);
                this.f14128c = iArr3;
                j[] jVarArr = new j[i11];
                System.arraycopy(this.f14129d, 0, jVarArr, 0, i10);
                this.f14129d = jVarArr;
            }
            int[][] iArr4 = this.f14128c;
            int i12 = this.f14126a;
            iArr4[i12] = iArr;
            this.f14129d[i12] = jVar;
            this.f14126a = i12 + 1;
        }

        public final void b() {
            this.f14127b = new j();
            this.f14128c = new int[10][];
            this.f14129d = new j[10];
        }
    }

    public p(a aVar) {
        this.f14119a = aVar.f14126a;
        this.f14120b = aVar.f14127b;
        this.f14121c = aVar.f14128c;
        this.f14122d = aVar.f14129d;
        this.f14123e = aVar.f14130e;
        this.f14124f = aVar.f14131f;
        this.f14125g = aVar.f14132g;
        this.h = aVar.h;
    }

    public static void a(a aVar, Context context, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1) {
                return;
            }
            int depth2 = xmlResourceParser.getDepth();
            if (depth2 < depth && next == 3) {
                return;
            }
            if (next == 2 && depth2 <= depth && xmlResourceParser.getName().equals("item")) {
                Resources resources = context.getResources();
                int[] iArr = k4.a.f9916v;
                TypedArray typedArrayObtainAttributes = theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
                j jVarA = j.a(context, typedArrayObtainAttributes.getResourceId(0, 0), typedArrayObtainAttributes.getResourceId(1, 0), new y4.a(0)).a();
                typedArrayObtainAttributes.recycle();
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr2 = new int[attributeCount];
                int i10 = 0;
                for (int i11 = 0; i11 < attributeCount; i11++) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i11);
                    if (attributeNameResource != R.attr.shapeAppearance && attributeNameResource != R.attr.shapeAppearanceOverlay) {
                        int i12 = i10 + 1;
                        if (!attributeSet.getAttributeBooleanValue(i11, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr2[i10] = attributeNameResource;
                        i10 = i12;
                    }
                }
                aVar.a(StateSet.trimStateSet(iArr2, i10), jVarA);
            }
        }
    }

    public static p b(Context context, TypedArray typedArray, int i10) {
        XmlResourceParser xml;
        int next;
        int resourceId = typedArray.getResourceId(i10, 0);
        if (resourceId == 0 || !Objects.equals(context.getResources().getResourceTypeName(resourceId), "xml")) {
            return null;
        }
        a aVar = new a();
        aVar.b();
        try {
            xml = context.getResources().getXml(resourceId);
        } catch (Resources.NotFoundException | IOException | XmlPullParserException unused) {
            aVar.b();
        }
        try {
            AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next != 2) {
                throw new XmlPullParserException("No start tag found");
            }
            if (xml.getName().equals("selector")) {
                a(aVar, context, xml, attributeSetAsAttributeSet, context.getTheme());
            }
            xml.close();
            if (aVar.f14126a == 0) {
                return null;
            }
            return new p(aVar);
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
    }

    public final j c() {
        j jVar = this.f14120b;
        o oVar = this.h;
        o oVar2 = this.f14125g;
        o oVar3 = this.f14124f;
        o oVar4 = this.f14123e;
        if (oVar4 == null && oVar3 == null && oVar2 == null && oVar == null) {
            return jVar;
        }
        j.a aVarF = jVar.f();
        if (oVar4 != null) {
            aVarF.f14077e = oVar4.f14116b;
        }
        if (oVar3 != null) {
            aVarF.f14078f = oVar3.f14116b;
        }
        if (oVar2 != null) {
            aVarF.h = oVar2.f14116b;
        }
        if (oVar != null) {
            aVarF.f14079g = oVar.f14116b;
        }
        return aVarF.a();
    }

    public final boolean d() {
        o oVar;
        o oVar2;
        o oVar3;
        o oVar4;
        return this.f14119a > 1 || ((oVar = this.f14123e) != null && oVar.f14115a > 1) || (((oVar2 = this.f14124f) != null && oVar2.f14115a > 1) || (((oVar3 = this.f14125g) != null && oVar3.f14115a > 1) || ((oVar4 = this.h) != null && oVar4.f14115a > 1)));
    }
}

package y4;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.StateSet;
import com.stepos.aiengine.R;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public int f14115a;

    /* renamed from: b, reason: collision with root package name */
    public d f14116b;

    /* renamed from: c, reason: collision with root package name */
    public int[][] f14117c = new int[10][];

    /* renamed from: d, reason: collision with root package name */
    public d[] f14118d = new d[10];

    public static o b(d dVar) {
        o oVar = new o();
        oVar.a(StateSet.WILD_CARD, dVar);
        return oVar;
    }

    public final void a(int[] iArr, d dVar) {
        int i10 = this.f14115a;
        if (i10 == 0 || iArr.length == 0) {
            this.f14116b = dVar;
        }
        int[][] iArr2 = this.f14117c;
        if (i10 >= iArr2.length) {
            int i11 = i10 + 10;
            int[][] iArr3 = new int[i11][];
            System.arraycopy(iArr2, 0, iArr3, 0, i10);
            this.f14117c = iArr3;
            d[] dVarArr = new d[i11];
            System.arraycopy(this.f14118d, 0, dVarArr, 0, i10);
            this.f14118d = dVarArr;
        }
        int[][] iArr4 = this.f14117c;
        int i12 = this.f14115a;
        iArr4[i12] = iArr;
        this.f14118d[i12] = dVar;
        this.f14115a = i12 + 1;
    }

    public final d c(int[] iArr) {
        int i10;
        int[][] iArr2 = this.f14117c;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            i10 = -1;
            if (i12 >= this.f14115a) {
                i12 = -1;
                break;
            }
            if (StateSet.stateSetMatches(iArr2[i12], iArr)) {
                break;
            }
            i12++;
        }
        if (i12 < 0) {
            int[] iArr3 = StateSet.WILD_CARD;
            int[][] iArr4 = this.f14117c;
            while (true) {
                if (i11 >= this.f14115a) {
                    break;
                }
                if (StateSet.stateSetMatches(iArr4[i11], iArr3)) {
                    i10 = i11;
                    break;
                }
                i11++;
            }
            i12 = i10;
        }
        return i12 < 0 ? this.f14116b : this.f14118d[i12];
    }

    public final void d(Context context, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
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
                int[] iArr = k4.a.D;
                TypedArray typedArrayObtainAttributes = theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
                d dVarC = j.c(typedArrayObtainAttributes, 5, new a(0.0f));
                typedArrayObtainAttributes.recycle();
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr2 = new int[attributeCount];
                int i10 = 0;
                for (int i11 = 0; i11 < attributeCount; i11++) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i11);
                    if (attributeNameResource != R.attr.cornerSize) {
                        int i12 = i10 + 1;
                        if (!attributeSet.getAttributeBooleanValue(i11, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr2[i10] = attributeNameResource;
                        i10 = i12;
                    }
                }
                a(StateSet.trimStateSet(iArr2, i10), dVarC);
            }
        }
    }
}

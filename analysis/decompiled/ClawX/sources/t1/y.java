package t1;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.StateSet;
import com.stepos.stepclaw.R;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public int f5549a;

    /* renamed from: b, reason: collision with root package name */
    public d f5550b;

    /* renamed from: c, reason: collision with root package name */
    public int[][] f5551c = new int[10][];
    public d[] d = new d[10];

    public static y b(d dVar) {
        y yVar = new y();
        yVar.a(StateSet.WILD_CARD, dVar);
        return yVar;
    }

    public final void a(int[] iArr, d dVar) {
        int i8 = this.f5549a;
        if (i8 == 0 || iArr.length == 0) {
            this.f5550b = dVar;
        }
        int[][] iArr2 = this.f5551c;
        if (i8 >= iArr2.length) {
            int i9 = i8 + 10;
            int[][] iArr3 = new int[i9][];
            System.arraycopy(iArr2, 0, iArr3, 0, i8);
            this.f5551c = iArr3;
            d[] dVarArr = new d[i9];
            System.arraycopy(this.d, 0, dVarArr, 0, i8);
            this.d = dVarArr;
        }
        int[][] iArr4 = this.f5551c;
        int i10 = this.f5549a;
        iArr4[i10] = iArr;
        this.d[i10] = dVar;
        this.f5549a = i10 + 1;
    }

    public final d c(int[] iArr) {
        int i8;
        int[][] iArr2 = this.f5551c;
        int i9 = 0;
        int i10 = 0;
        while (true) {
            i8 = -1;
            if (i10 >= this.f5549a) {
                i10 = -1;
                break;
            }
            if (StateSet.stateSetMatches(iArr2[i10], iArr)) {
                break;
            }
            i10++;
        }
        if (i10 < 0) {
            int[] iArr3 = StateSet.WILD_CARD;
            int[][] iArr4 = this.f5551c;
            while (true) {
                if (i9 >= this.f5549a) {
                    break;
                }
                if (StateSet.stateSetMatches(iArr4[i9], iArr3)) {
                    i8 = i9;
                    break;
                }
                i9++;
            }
            i10 = i8;
        }
        return i10 < 0 ? this.f5550b : this.d[i10];
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
                int[] iArr = d1.a.f1777s;
                TypedArray typedArrayObtainAttributes = theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
                d dVarC = n.c(typedArrayObtainAttributes, 5, new a(0.0f));
                typedArrayObtainAttributes.recycle();
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr2 = new int[attributeCount];
                int i8 = 0;
                for (int i9 = 0; i9 < attributeCount; i9++) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i9);
                    if (attributeNameResource != R.attr.cornerSize) {
                        int i10 = i8 + 1;
                        if (!attributeSet.getAttributeBooleanValue(i9, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr2[i8] = attributeNameResource;
                        i8 = i10;
                    }
                }
                a(StateSet.trimStateSet(iArr2, i8), dVarC);
            }
        }
    }
}

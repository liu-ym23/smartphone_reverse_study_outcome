package e3;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.StateSet;
import com.stepos.ability.R;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: e3.B, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1408B {

    /* renamed from: a, reason: collision with root package name */
    public int f4337a;
    public InterfaceC1415d b;
    public int[][] c = new int[10][];
    public InterfaceC1415d[] d = new InterfaceC1415d[10];

    public static C1408B b(InterfaceC1415d interfaceC1415d) {
        C1408B c1408b = new C1408B();
        c1408b.a(StateSet.WILD_CARD, interfaceC1415d);
        return c1408b;
    }

    public final void a(int[] iArr, InterfaceC1415d interfaceC1415d) {
        int i = this.f4337a;
        if (i == 0 || iArr.length == 0) {
            this.b = interfaceC1415d;
        }
        int[][] iArr2 = this.c;
        if (i >= iArr2.length) {
            int i6 = i + 10;
            int[][] iArr3 = new int[i6][];
            System.arraycopy(iArr2, 0, iArr3, 0, i);
            this.c = iArr3;
            InterfaceC1415d[] interfaceC1415dArr = new InterfaceC1415d[i6];
            System.arraycopy(this.d, 0, interfaceC1415dArr, 0, i);
            this.d = interfaceC1415dArr;
        }
        int[][] iArr4 = this.c;
        int i10 = this.f4337a;
        iArr4[i10] = iArr;
        this.d[i10] = interfaceC1415d;
        this.f4337a = i10 + 1;
    }

    public final InterfaceC1415d c(int[] iArr) {
        int i;
        int[][] iArr2 = this.c;
        int i6 = 0;
        int i10 = 0;
        while (true) {
            i = -1;
            if (i10 >= this.f4337a) {
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
            int[][] iArr4 = this.c;
            while (true) {
                if (i6 >= this.f4337a) {
                    break;
                }
                if (StateSet.stateSetMatches(iArr4[i6], iArr3)) {
                    i = i6;
                    break;
                }
                i6++;
            }
            i10 = i;
        }
        return i10 < 0 ? this.b : this.d[i10];
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
                int[] iArr = P2.a.f1065D;
                TypedArray typedArrayObtainAttributes = theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
                InterfaceC1415d interfaceC1415dC = p.c(typedArrayObtainAttributes, 5, new C1412a(0.0f));
                typedArrayObtainAttributes.recycle();
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr2 = new int[attributeCount];
                int i = 0;
                for (int i6 = 0; i6 < attributeCount; i6++) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i6);
                    if (attributeNameResource != R.attr.cornerSize) {
                        int i10 = i + 1;
                        if (!attributeSet.getAttributeBooleanValue(i6, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr2[i] = attributeNameResource;
                        i = i10;
                    }
                }
                a(StateSet.trimStateSet(iArr2, i), interfaceC1415dC);
            }
        }
    }
}

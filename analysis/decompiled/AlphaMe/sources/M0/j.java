package M0;

import L0.m;
import android.content.res.AssetManager;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import androidx.appcompat.widget.C0238z;
import androidx.room.AbstractC0351g;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.v;
import com.airbnb.lottie.z;
import com.stepos.alphame.utils.Property;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class j extends b {

    /* renamed from: A, reason: collision with root package name */
    public final HashMap f1421A;

    /* renamed from: B, reason: collision with root package name */
    public final H0.c f1422B;

    /* renamed from: C, reason: collision with root package name */
    public final v f1423C;

    /* renamed from: D, reason: collision with root package name */
    public final LottieComposition f1424D;

    /* renamed from: E, reason: collision with root package name */
    public final H0.b f1425E;

    /* renamed from: F, reason: collision with root package name */
    public final H0.b f1426F;

    /* renamed from: G, reason: collision with root package name */
    public final H0.c f1427G;

    /* renamed from: H, reason: collision with root package name */
    public final H0.c f1428H;

    /* renamed from: v, reason: collision with root package name */
    public final char[] f1429v;

    /* renamed from: w, reason: collision with root package name */
    public final RectF f1430w;

    /* renamed from: x, reason: collision with root package name */
    public final Matrix f1431x;

    /* renamed from: y, reason: collision with root package name */
    public final i f1432y;

    /* renamed from: z, reason: collision with root package name */
    public final i f1433z;

    public j(v vVar, e eVar) {
        K0.b bVar;
        K0.b bVar2;
        K0.a aVar;
        K0.a aVar2;
        super(vVar, eVar);
        this.f1429v = new char[1];
        this.f1430w = new RectF();
        this.f1431x = new Matrix();
        this.f1432y = new i(0);
        this.f1433z = new i(1);
        this.f1421A = new HashMap();
        this.f1423C = vVar;
        this.f1424D = eVar.f1394b;
        H0.c cVar = new H0.c(4, (List) eVar.f1409q.f825b);
        this.f1422B = cVar;
        cVar.a(this);
        c(cVar);
        t.d dVar = eVar.f1410r;
        if (dVar != null && (aVar2 = (K0.a) dVar.f15273a) != null) {
            H0.b bVarC = aVar2.c();
            this.f1425E = bVarC;
            bVarC.a(this);
            c(bVarC);
        }
        if (dVar != null && (aVar = (K0.a) dVar.f15274b) != null) {
            H0.b bVarC2 = aVar.c();
            this.f1426F = bVarC2;
            bVarC2.a(this);
            c(bVarC2);
        }
        if (dVar != null && (bVar2 = (K0.b) dVar.f15275c) != null) {
            H0.b bVarC3 = bVar2.c();
            this.f1427G = (H0.c) bVarC3;
            bVarC3.a(this);
            c(bVarC3);
        }
        if (dVar == null || (bVar = (K0.b) dVar.f15276d) == null) {
            return;
        }
        H0.b bVarC4 = bVar.c();
        this.f1428H = (H0.c) bVarC4;
        bVarC4.a(this);
        c(bVarC4);
    }

    public static void p(char[] cArr, i iVar, Canvas canvas) {
        if (iVar.getColor() == 0) {
            return;
        }
        if (iVar.getStyle() == Paint.Style.STROKE && iVar.getStrokeWidth() == Property.DEFAULT_FLOAT_VALUE) {
            return;
        }
        canvas.drawText(cArr, 0, 1, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, iVar);
    }

    public static void q(Path path, i iVar, Canvas canvas) {
        if (iVar.getColor() == 0) {
            return;
        }
        if (iVar.getStyle() == Paint.Style.STROKE && iVar.getStrokeWidth() == Property.DEFAULT_FLOAT_VALUE) {
            return;
        }
        canvas.drawPath(path, iVar);
    }

    @Override // M0.b, J0.f
    public final void f(Object obj, Q0.b bVar) {
        H0.c cVar;
        H0.c cVar2;
        H0.b bVar2;
        H0.b bVar3;
        super.f(obj, bVar);
        PointF pointF = z.f4588a;
        if (obj == 1 && (bVar3 = this.f1425E) != null) {
            bVar3.i(bVar);
            return;
        }
        if (obj == 2 && (bVar2 = this.f1426F) != null) {
            bVar2.i(bVar);
            return;
        }
        if (obj == z.f4594g && (cVar2 = this.f1427G) != null) {
            cVar2.i(bVar);
        } else {
            if (obj != z.f4595h || (cVar = this.f1428H) == null) {
                return;
            }
            cVar.i(bVar);
        }
    }

    @Override // M0.b
    public final void k(Canvas canvas, Matrix matrix, int i4) {
        C0238z c0238z;
        LottieComposition lottieComposition;
        String str;
        String str2;
        int i5;
        List list;
        int i6;
        canvas.save();
        v vVar = this.f1423C;
        if (vVar.f4575b.getCharacters().f13973c <= 0) {
            canvas.setMatrix(matrix);
        }
        J0.b bVar = (J0.b) this.f1422B.e();
        LottieComposition lottieComposition2 = this.f1424D;
        J0.c cVar = lottieComposition2.getFonts().get(bVar.f855b);
        if (cVar == null) {
            canvas.restore();
            return;
        }
        H0.b bVar2 = this.f1425E;
        i iVar = this.f1432y;
        if (bVar2 != null) {
            iVar.setColor(((Integer) bVar2.e()).intValue());
        } else {
            iVar.setColor(bVar.f861h);
        }
        H0.b bVar3 = this.f1426F;
        i iVar2 = this.f1433z;
        if (bVar3 != null) {
            iVar2.setColor(((Integer) bVar3.e()).intValue());
        } else {
            iVar2.setColor(bVar.f862i);
        }
        int iIntValue = (((Integer) ((H0.b) this.f1381t.f13801f).e()).intValue() * 255) / 100;
        iVar.setAlpha(iIntValue);
        iVar2.setAlpha(iIntValue);
        H0.c cVar2 = this.f1427G;
        if (cVar2 != null) {
            iVar2.setStrokeWidth(((Float) cVar2.e()).floatValue());
        } else {
            iVar2.setStrokeWidth((float) (bVar.f863j * P0.c.c() * P0.c.d(matrix)));
        }
        boolean z4 = vVar.f4575b.getCharacters().f13973c > 0;
        H0.c cVar3 = this.f1428H;
        int i7 = bVar.f858e;
        boolean z5 = bVar.f864k;
        String str3 = bVar.f854a;
        double d4 = bVar.f856c;
        String str4 = cVar.f866b;
        String str5 = cVar.f865a;
        if (z4) {
            float f4 = ((float) d4) / 100.0f;
            float fD = P0.c.d(matrix);
            int i8 = 0;
            while (i8 < str3.length()) {
                String str6 = str3;
                J0.d dVar = (J0.d) lottieComposition2.getCharacters().c(str4.hashCode() + AbstractC0351g.d(str5, str3.charAt(i8) * 31, 31));
                if (dVar == null) {
                    lottieComposition = lottieComposition2;
                    str2 = str5;
                    str = str4;
                    i5 = i8;
                    i6 = i7;
                } else {
                    HashMap map = this.f1421A;
                    if (map.containsKey(dVar)) {
                        list = (List) map.get(dVar);
                        lottieComposition = lottieComposition2;
                        str2 = str5;
                        str = str4;
                        i5 = i8;
                    } else {
                        lottieComposition = lottieComposition2;
                        List list2 = dVar.f867a;
                        str = str4;
                        int size = list2.size();
                        str2 = str5;
                        ArrayList arrayList = new ArrayList(size);
                        i5 = i8;
                        int i9 = 0;
                        while (i9 < size) {
                            arrayList.add(new G0.d(vVar, this, (m) list2.get(i9)));
                            i9++;
                            size = size;
                            list2 = list2;
                        }
                        map.put(dVar, arrayList);
                        list = arrayList;
                    }
                    int i10 = 0;
                    while (i10 < list.size()) {
                        Path pathE = ((G0.d) list.get(i10)).e();
                        pathE.computeBounds(this.f1430w, false);
                        Matrix matrix2 = this.f1431x;
                        matrix2.set(matrix);
                        int i11 = i7;
                        matrix2.preTranslate(Property.DEFAULT_FLOAT_VALUE, P0.c.c() * ((float) (-bVar.f860g)));
                        matrix2.preScale(f4, f4);
                        pathE.transform(matrix2);
                        if (z5) {
                            q(pathE, iVar, canvas);
                            q(pathE, iVar2, canvas);
                        } else {
                            q(pathE, iVar2, canvas);
                            q(pathE, iVar, canvas);
                        }
                        i10++;
                        i7 = i11;
                    }
                    float fC = P0.c.c() * ((float) dVar.f869c) * f4 * fD;
                    i6 = i7;
                    float fFloatValue = i6 / 10.0f;
                    if (cVar3 != null) {
                        fFloatValue += ((Float) cVar3.e()).floatValue();
                    }
                    canvas.translate((fFloatValue * fD) + fC, Property.DEFAULT_FLOAT_VALUE);
                }
                i8 = i5 + 1;
                i7 = i6;
                str3 = str6;
                lottieComposition2 = lottieComposition;
                str4 = str;
                str5 = str2;
            }
        } else {
            String str7 = str3;
            float fD2 = P0.c.d(matrix);
            Typeface typeface = null;
            if (vVar.getCallback() == null) {
                c0238z = null;
            } else {
                if (vVar.f4581h == null) {
                    Drawable.Callback callback = vVar.getCallback();
                    C0238z c0238z2 = new C0238z();
                    c0238z2.f3212a = new B0.m(4, 0);
                    c0238z2.f3213b = new HashMap();
                    c0238z2.f3214c = new HashMap();
                    c0238z2.f3217f = ".ttf";
                    c0238z2.f3216e = null;
                    if (callback instanceof View) {
                        c0238z2.f3215d = ((View) callback).getContext().getAssets();
                    } else {
                        Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
                        c0238z2.f3215d = null;
                    }
                    vVar.f4581h = c0238z2;
                }
                c0238z = vVar.f4581h;
            }
            if (c0238z != null) {
                B0.m mVar = (B0.m) c0238z.f3212a;
                mVar.f155b = str5;
                mVar.f156c = str4;
                Typeface typefaceCreate = (Typeface) ((Map) c0238z.f3213b).get(mVar);
                if (typefaceCreate == null) {
                    typefaceCreate = (Typeface) ((Map) c0238z.f3214c).get(str5);
                    if (typefaceCreate == null) {
                        B0.g.y(c0238z.f3216e);
                        B0.g.y(c0238z.f3216e);
                        typefaceCreate = Typeface.createFromAsset((AssetManager) c0238z.f3215d, "fonts/" + str5 + ((String) c0238z.f3217f));
                        ((Map) c0238z.f3214c).put(str5, typefaceCreate);
                    }
                    boolean zContains = str4.contains("Italic");
                    boolean zContains2 = str4.contains("Bold");
                    int i12 = (zContains && zContains2) ? 3 : zContains ? 2 : zContains2 ? 1 : 0;
                    if (typefaceCreate.getStyle() != i12) {
                        typefaceCreate = Typeface.create(typefaceCreate, i12);
                    }
                    ((Map) c0238z.f3213b).put((B0.m) c0238z.f3212a, typefaceCreate);
                }
                typeface = typefaceCreate;
            }
            if (typeface != null) {
                iVar.setTypeface(typeface);
                iVar.setTextSize((float) (d4 * P0.c.c()));
                iVar2.setTypeface(iVar.getTypeface());
                iVar2.setTextSize(iVar.getTextSize());
                int i13 = 0;
                while (i13 < str7.length()) {
                    String str8 = str7;
                    char cCharAt = str8.charAt(i13);
                    char[] cArr = this.f1429v;
                    cArr[0] = cCharAt;
                    if (z5) {
                        p(cArr, iVar, canvas);
                        p(cArr, iVar2, canvas);
                    } else {
                        p(cArr, iVar2, canvas);
                        p(cArr, iVar, canvas);
                    }
                    cArr[0] = cCharAt;
                    float fMeasureText = iVar.measureText(cArr, 0, 1);
                    float fFloatValue2 = i7 / 10.0f;
                    if (cVar3 != null) {
                        fFloatValue2 += ((Float) cVar3.e()).floatValue();
                    }
                    canvas.translate((fFloatValue2 * fD2) + fMeasureText, Property.DEFAULT_FLOAT_VALUE);
                    i13++;
                    str7 = str8;
                }
            }
        }
        canvas.restore();
    }
}

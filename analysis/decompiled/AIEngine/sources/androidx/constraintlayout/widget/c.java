package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.d;
import com.stepos.core.common.notification.ModelDownloadNotifier;
import com.stepos.core.common.telemetry.FailStage;
import com.stepos.core.data.base.Content;
import com.stepos.core.ota.crypto.FekEnvelope;
import com.stepos.deepbinder.core.exception.ErrorCodes;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f1336d = {0, 4, 8};

    /* renamed from: e, reason: collision with root package name */
    public static final SparseIntArray f1337e;

    /* renamed from: f, reason: collision with root package name */
    public static final SparseIntArray f1338f;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap<String, ConstraintAttribute> f1339a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    public final boolean f1340b = true;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap<Integer, a> f1341c = new HashMap<>();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f1342a;

        /* renamed from: b, reason: collision with root package name */
        public final d f1343b;

        /* renamed from: c, reason: collision with root package name */
        public final C0007c f1344c;

        /* renamed from: d, reason: collision with root package name */
        public final b f1345d;

        /* renamed from: e, reason: collision with root package name */
        public final e f1346e;

        /* renamed from: f, reason: collision with root package name */
        public HashMap<String, ConstraintAttribute> f1347f;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        /* renamed from: androidx.constraintlayout.widget.c$a$a, reason: collision with other inner class name */
        public static class C0006a {

            /* renamed from: a, reason: collision with root package name */
            public int[] f1348a = new int[10];

            /* renamed from: b, reason: collision with root package name */
            public int[] f1349b = new int[10];

            /* renamed from: c, reason: collision with root package name */
            public int f1350c = 0;

            /* renamed from: d, reason: collision with root package name */
            public int[] f1351d = new int[10];

            /* renamed from: e, reason: collision with root package name */
            public float[] f1352e = new float[10];

            /* renamed from: f, reason: collision with root package name */
            public int f1353f = 0;

            /* renamed from: g, reason: collision with root package name */
            public int[] f1354g = new int[5];
            public String[] h = new String[5];

            /* renamed from: i, reason: collision with root package name */
            public int f1355i = 0;

            /* renamed from: j, reason: collision with root package name */
            public int[] f1356j = new int[4];

            /* renamed from: k, reason: collision with root package name */
            public boolean[] f1357k = new boolean[4];

            /* renamed from: l, reason: collision with root package name */
            public int f1358l = 0;

            public final void a(float f8, int i10) {
                int i11 = this.f1353f;
                int[] iArr = this.f1351d;
                if (i11 >= iArr.length) {
                    this.f1351d = Arrays.copyOf(iArr, iArr.length * 2);
                    float[] fArr = this.f1352e;
                    this.f1352e = Arrays.copyOf(fArr, fArr.length * 2);
                }
                int[] iArr2 = this.f1351d;
                int i12 = this.f1353f;
                iArr2[i12] = i10;
                float[] fArr2 = this.f1352e;
                this.f1353f = i12 + 1;
                fArr2[i12] = f8;
            }

            public final void b(int i10, int i11) {
                int i12 = this.f1350c;
                int[] iArr = this.f1348a;
                if (i12 >= iArr.length) {
                    this.f1348a = Arrays.copyOf(iArr, iArr.length * 2);
                    int[] iArr2 = this.f1349b;
                    this.f1349b = Arrays.copyOf(iArr2, iArr2.length * 2);
                }
                int[] iArr3 = this.f1348a;
                int i13 = this.f1350c;
                iArr3[i13] = i10;
                int[] iArr4 = this.f1349b;
                this.f1350c = i13 + 1;
                iArr4[i13] = i11;
            }

            public final void c(int i10, String str) {
                int i11 = this.f1355i;
                int[] iArr = this.f1354g;
                if (i11 >= iArr.length) {
                    this.f1354g = Arrays.copyOf(iArr, iArr.length * 2);
                    String[] strArr = this.h;
                    this.h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                }
                int[] iArr2 = this.f1354g;
                int i12 = this.f1355i;
                iArr2[i12] = i10;
                String[] strArr2 = this.h;
                this.f1355i = i12 + 1;
                strArr2[i12] = str;
            }

            public final void d(int i10, boolean z) {
                int i11 = this.f1358l;
                int[] iArr = this.f1356j;
                if (i11 >= iArr.length) {
                    this.f1356j = Arrays.copyOf(iArr, iArr.length * 2);
                    boolean[] zArr = this.f1357k;
                    this.f1357k = Arrays.copyOf(zArr, zArr.length * 2);
                }
                int[] iArr2 = this.f1356j;
                int i12 = this.f1358l;
                iArr2[i12] = i10;
                boolean[] zArr2 = this.f1357k;
                this.f1358l = i12 + 1;
                zArr2[i12] = z;
            }
        }

        public a() {
            d dVar = new d();
            dVar.f1405a = 0;
            dVar.f1406b = 0;
            dVar.f1407c = 1.0f;
            dVar.f1408d = Float.NaN;
            this.f1343b = dVar;
            C0007c c0007c = new C0007c();
            c0007c.f1397a = -1;
            c0007c.f1398b = 0;
            c0007c.f1399c = -1;
            c0007c.f1400d = Float.NaN;
            c0007c.f1401e = Float.NaN;
            c0007c.f1402f = Float.NaN;
            c0007c.f1403g = -1;
            c0007c.h = null;
            c0007c.f1404i = -1;
            this.f1344c = c0007c;
            this.f1345d = new b();
            e eVar = new e();
            eVar.f1410a = 0.0f;
            eVar.f1411b = 0.0f;
            eVar.f1412c = 0.0f;
            eVar.f1413d = 1.0f;
            eVar.f1414e = 1.0f;
            eVar.f1415f = Float.NaN;
            eVar.f1416g = Float.NaN;
            eVar.h = -1;
            eVar.f1417i = 0.0f;
            eVar.f1418j = 0.0f;
            eVar.f1419k = 0.0f;
            eVar.f1420l = false;
            eVar.f1421m = 0.0f;
            this.f1346e = eVar;
            this.f1347f = new HashMap<>();
        }

        public final void a(ConstraintLayout.a aVar) {
            b bVar = this.f1345d;
            aVar.f1287e = bVar.h;
            aVar.f1289f = bVar.f1373i;
            aVar.f1291g = bVar.f1375j;
            aVar.h = bVar.f1377k;
            aVar.f1294i = bVar.f1379l;
            aVar.f1296j = bVar.f1381m;
            aVar.f1298k = bVar.f1383n;
            aVar.f1300l = bVar.f1385o;
            aVar.f1302m = bVar.f1387p;
            aVar.f1304n = bVar.f1388q;
            aVar.f1306o = bVar.r;
            aVar.f1311s = bVar.f1389s;
            aVar.f1312t = bVar.f1390t;
            aVar.f1313u = bVar.f1391u;
            aVar.f1314v = bVar.f1392v;
            ((ViewGroup.MarginLayoutParams) aVar).leftMargin = bVar.F;
            ((ViewGroup.MarginLayoutParams) aVar).rightMargin = bVar.G;
            ((ViewGroup.MarginLayoutParams) aVar).topMargin = bVar.H;
            ((ViewGroup.MarginLayoutParams) aVar).bottomMargin = bVar.I;
            aVar.A = bVar.R;
            aVar.B = bVar.Q;
            aVar.f1316x = bVar.N;
            aVar.z = bVar.P;
            aVar.E = bVar.f1393w;
            aVar.F = bVar.f1394x;
            aVar.f1308p = bVar.z;
            aVar.f1310q = bVar.A;
            aVar.r = bVar.B;
            aVar.G = bVar.f1395y;
            aVar.T = bVar.C;
            aVar.U = bVar.D;
            aVar.I = bVar.T;
            aVar.H = bVar.U;
            aVar.K = bVar.W;
            aVar.J = bVar.V;
            aVar.W = bVar.f1380l0;
            aVar.X = bVar.f1382m0;
            aVar.L = bVar.X;
            aVar.M = bVar.Y;
            aVar.P = bVar.Z;
            aVar.Q = bVar.f1361a0;
            aVar.N = bVar.b0;
            aVar.O = bVar.c0;
            aVar.R = bVar.f1365d0;
            aVar.S = bVar.f1367e0;
            aVar.V = bVar.E;
            aVar.f1284c = bVar.f1368f;
            aVar.f1281a = bVar.f1364d;
            aVar.f1283b = bVar.f1366e;
            ((ViewGroup.MarginLayoutParams) aVar).width = bVar.f1362b;
            ((ViewGroup.MarginLayoutParams) aVar).height = bVar.f1363c;
            String str = bVar.f1378k0;
            if (str != null) {
                aVar.Y = str;
            }
            aVar.Z = bVar.f1386o0;
            aVar.setMarginStart(bVar.K);
            aVar.setMarginEnd(bVar.J);
            aVar.a();
        }

        public final void b(int i10, ConstraintLayout.a aVar) {
            this.f1342a = i10;
            int i11 = aVar.f1287e;
            b bVar = this.f1345d;
            bVar.h = i11;
            bVar.f1373i = aVar.f1289f;
            bVar.f1375j = aVar.f1291g;
            bVar.f1377k = aVar.h;
            bVar.f1379l = aVar.f1294i;
            bVar.f1381m = aVar.f1296j;
            bVar.f1383n = aVar.f1298k;
            bVar.f1385o = aVar.f1300l;
            bVar.f1387p = aVar.f1302m;
            bVar.f1388q = aVar.f1304n;
            bVar.r = aVar.f1306o;
            bVar.f1389s = aVar.f1311s;
            bVar.f1390t = aVar.f1312t;
            bVar.f1391u = aVar.f1313u;
            bVar.f1392v = aVar.f1314v;
            bVar.f1393w = aVar.E;
            bVar.f1394x = aVar.F;
            bVar.f1395y = aVar.G;
            bVar.z = aVar.f1308p;
            bVar.A = aVar.f1310q;
            bVar.B = aVar.r;
            bVar.C = aVar.T;
            bVar.D = aVar.U;
            bVar.E = aVar.V;
            bVar.f1368f = aVar.f1284c;
            bVar.f1364d = aVar.f1281a;
            bVar.f1366e = aVar.f1283b;
            bVar.f1362b = ((ViewGroup.MarginLayoutParams) aVar).width;
            bVar.f1363c = ((ViewGroup.MarginLayoutParams) aVar).height;
            bVar.F = ((ViewGroup.MarginLayoutParams) aVar).leftMargin;
            bVar.G = ((ViewGroup.MarginLayoutParams) aVar).rightMargin;
            bVar.H = ((ViewGroup.MarginLayoutParams) aVar).topMargin;
            bVar.I = ((ViewGroup.MarginLayoutParams) aVar).bottomMargin;
            bVar.L = aVar.D;
            bVar.T = aVar.I;
            bVar.U = aVar.H;
            bVar.W = aVar.K;
            bVar.V = aVar.J;
            bVar.f1380l0 = aVar.W;
            bVar.f1382m0 = aVar.X;
            bVar.X = aVar.L;
            bVar.Y = aVar.M;
            bVar.Z = aVar.P;
            bVar.f1361a0 = aVar.Q;
            bVar.b0 = aVar.N;
            bVar.c0 = aVar.O;
            bVar.f1365d0 = aVar.R;
            bVar.f1367e0 = aVar.S;
            bVar.f1378k0 = aVar.Y;
            bVar.N = aVar.f1316x;
            bVar.P = aVar.z;
            bVar.M = aVar.f1315w;
            bVar.O = aVar.f1317y;
            bVar.R = aVar.A;
            bVar.Q = aVar.B;
            bVar.S = aVar.C;
            bVar.f1386o0 = aVar.Z;
            bVar.J = aVar.getMarginEnd();
            bVar.K = aVar.getMarginStart();
        }

        public final void c(int i10, d.a aVar) {
            b(i10, aVar);
            this.f1343b.f1407c = aVar.f1422r0;
            float f8 = aVar.f1425u0;
            e eVar = this.f1346e;
            eVar.f1410a = f8;
            eVar.f1411b = aVar.f1426v0;
            eVar.f1412c = aVar.f1427w0;
            eVar.f1413d = aVar.f1428x0;
            eVar.f1414e = aVar.f1429y0;
            eVar.f1415f = aVar.z0;
            eVar.f1416g = aVar.A0;
            eVar.f1417i = aVar.B0;
            eVar.f1418j = aVar.C0;
            eVar.f1419k = aVar.D0;
            eVar.f1421m = aVar.f1424t0;
            eVar.f1420l = aVar.f1423s0;
        }

        public final Object clone() {
            a aVar = new a();
            b bVar = aVar.f1345d;
            bVar.getClass();
            b bVar2 = this.f1345d;
            bVar.f1360a = bVar2.f1360a;
            bVar.f1362b = bVar2.f1362b;
            bVar.f1363c = bVar2.f1363c;
            bVar.f1364d = bVar2.f1364d;
            bVar.f1366e = bVar2.f1366e;
            bVar.f1368f = bVar2.f1368f;
            bVar.f1370g = bVar2.f1370g;
            bVar.h = bVar2.h;
            bVar.f1373i = bVar2.f1373i;
            bVar.f1375j = bVar2.f1375j;
            bVar.f1377k = bVar2.f1377k;
            bVar.f1379l = bVar2.f1379l;
            bVar.f1381m = bVar2.f1381m;
            bVar.f1383n = bVar2.f1383n;
            bVar.f1385o = bVar2.f1385o;
            bVar.f1387p = bVar2.f1387p;
            bVar.f1388q = bVar2.f1388q;
            bVar.r = bVar2.r;
            bVar.f1389s = bVar2.f1389s;
            bVar.f1390t = bVar2.f1390t;
            bVar.f1391u = bVar2.f1391u;
            bVar.f1392v = bVar2.f1392v;
            bVar.f1393w = bVar2.f1393w;
            bVar.f1394x = bVar2.f1394x;
            bVar.f1395y = bVar2.f1395y;
            bVar.z = bVar2.z;
            bVar.A = bVar2.A;
            bVar.B = bVar2.B;
            bVar.C = bVar2.C;
            bVar.D = bVar2.D;
            bVar.E = bVar2.E;
            bVar.F = bVar2.F;
            bVar.G = bVar2.G;
            bVar.H = bVar2.H;
            bVar.I = bVar2.I;
            bVar.J = bVar2.J;
            bVar.K = bVar2.K;
            bVar.L = bVar2.L;
            bVar.M = bVar2.M;
            bVar.N = bVar2.N;
            bVar.O = bVar2.O;
            bVar.P = bVar2.P;
            bVar.Q = bVar2.Q;
            bVar.R = bVar2.R;
            bVar.S = bVar2.S;
            bVar.T = bVar2.T;
            bVar.U = bVar2.U;
            bVar.V = bVar2.V;
            bVar.W = bVar2.W;
            bVar.X = bVar2.X;
            bVar.Y = bVar2.Y;
            bVar.Z = bVar2.Z;
            bVar.f1361a0 = bVar2.f1361a0;
            bVar.b0 = bVar2.b0;
            bVar.c0 = bVar2.c0;
            bVar.f1365d0 = bVar2.f1365d0;
            bVar.f1367e0 = bVar2.f1367e0;
            bVar.f1369f0 = bVar2.f1369f0;
            bVar.f1371g0 = bVar2.f1371g0;
            bVar.f1372h0 = bVar2.f1372h0;
            bVar.f1378k0 = bVar2.f1378k0;
            int[] iArr = bVar2.f1374i0;
            if (iArr == null || bVar2.f1376j0 != null) {
                bVar.f1374i0 = null;
            } else {
                bVar.f1374i0 = Arrays.copyOf(iArr, iArr.length);
            }
            bVar.f1376j0 = bVar2.f1376j0;
            bVar.f1380l0 = bVar2.f1380l0;
            bVar.f1382m0 = bVar2.f1382m0;
            bVar.f1384n0 = bVar2.f1384n0;
            bVar.f1386o0 = bVar2.f1386o0;
            C0007c c0007c = aVar.f1344c;
            c0007c.getClass();
            C0007c c0007c2 = this.f1344c;
            c0007c2.getClass();
            c0007c.f1397a = c0007c2.f1397a;
            c0007c.f1399c = c0007c2.f1399c;
            c0007c.f1401e = c0007c2.f1401e;
            c0007c.f1400d = c0007c2.f1400d;
            d dVar = this.f1343b;
            int i10 = dVar.f1405a;
            d dVar2 = aVar.f1343b;
            dVar2.f1405a = i10;
            dVar2.f1407c = dVar.f1407c;
            dVar2.f1408d = dVar.f1408d;
            dVar2.f1406b = dVar.f1406b;
            e eVar = aVar.f1346e;
            eVar.getClass();
            e eVar2 = this.f1346e;
            eVar2.getClass();
            eVar.f1410a = eVar2.f1410a;
            eVar.f1411b = eVar2.f1411b;
            eVar.f1412c = eVar2.f1412c;
            eVar.f1413d = eVar2.f1413d;
            eVar.f1414e = eVar2.f1414e;
            eVar.f1415f = eVar2.f1415f;
            eVar.f1416g = eVar2.f1416g;
            eVar.h = eVar2.h;
            eVar.f1417i = eVar2.f1417i;
            eVar.f1418j = eVar2.f1418j;
            eVar.f1419k = eVar2.f1419k;
            eVar.f1420l = eVar2.f1420l;
            eVar.f1421m = eVar2.f1421m;
            aVar.f1342a = this.f1342a;
            return aVar;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class b {

        /* renamed from: p0, reason: collision with root package name */
        public static final SparseIntArray f1359p0;

        /* renamed from: b, reason: collision with root package name */
        public int f1362b;

        /* renamed from: c, reason: collision with root package name */
        public int f1363c;

        /* renamed from: i0, reason: collision with root package name */
        public int[] f1374i0;

        /* renamed from: j0, reason: collision with root package name */
        public String f1376j0;

        /* renamed from: k0, reason: collision with root package name */
        public String f1378k0;

        /* renamed from: a, reason: collision with root package name */
        public boolean f1360a = false;

        /* renamed from: d, reason: collision with root package name */
        public int f1364d = -1;

        /* renamed from: e, reason: collision with root package name */
        public int f1366e = -1;

        /* renamed from: f, reason: collision with root package name */
        public float f1368f = -1.0f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f1370g = true;
        public int h = -1;

        /* renamed from: i, reason: collision with root package name */
        public int f1373i = -1;

        /* renamed from: j, reason: collision with root package name */
        public int f1375j = -1;

        /* renamed from: k, reason: collision with root package name */
        public int f1377k = -1;

        /* renamed from: l, reason: collision with root package name */
        public int f1379l = -1;

        /* renamed from: m, reason: collision with root package name */
        public int f1381m = -1;

        /* renamed from: n, reason: collision with root package name */
        public int f1383n = -1;

        /* renamed from: o, reason: collision with root package name */
        public int f1385o = -1;

        /* renamed from: p, reason: collision with root package name */
        public int f1387p = -1;

        /* renamed from: q, reason: collision with root package name */
        public int f1388q = -1;
        public int r = -1;

        /* renamed from: s, reason: collision with root package name */
        public int f1389s = -1;

        /* renamed from: t, reason: collision with root package name */
        public int f1390t = -1;

        /* renamed from: u, reason: collision with root package name */
        public int f1391u = -1;

        /* renamed from: v, reason: collision with root package name */
        public int f1392v = -1;

        /* renamed from: w, reason: collision with root package name */
        public float f1393w = 0.5f;

        /* renamed from: x, reason: collision with root package name */
        public float f1394x = 0.5f;

        /* renamed from: y, reason: collision with root package name */
        public String f1395y = null;
        public int z = -1;
        public int A = 0;
        public float B = 0.0f;
        public int C = -1;
        public int D = -1;
        public int E = -1;
        public int F = 0;
        public int G = 0;
        public int H = 0;
        public int I = 0;
        public int J = 0;
        public int K = 0;
        public int L = 0;
        public int M = Integer.MIN_VALUE;
        public int N = Integer.MIN_VALUE;
        public int O = Integer.MIN_VALUE;
        public int P = Integer.MIN_VALUE;
        public int Q = Integer.MIN_VALUE;
        public int R = Integer.MIN_VALUE;
        public int S = Integer.MIN_VALUE;
        public float T = -1.0f;
        public float U = -1.0f;
        public int V = 0;
        public int W = 0;
        public int X = 0;
        public int Y = 0;
        public int Z = 0;

        /* renamed from: a0, reason: collision with root package name */
        public int f1361a0 = 0;
        public int b0 = 0;
        public int c0 = 0;

        /* renamed from: d0, reason: collision with root package name */
        public float f1365d0 = 1.0f;

        /* renamed from: e0, reason: collision with root package name */
        public float f1367e0 = 1.0f;

        /* renamed from: f0, reason: collision with root package name */
        public int f1369f0 = -1;

        /* renamed from: g0, reason: collision with root package name */
        public int f1371g0 = 0;

        /* renamed from: h0, reason: collision with root package name */
        public int f1372h0 = -1;

        /* renamed from: l0, reason: collision with root package name */
        public boolean f1380l0 = false;

        /* renamed from: m0, reason: collision with root package name */
        public boolean f1382m0 = false;

        /* renamed from: n0, reason: collision with root package name */
        public boolean f1384n0 = true;

        /* renamed from: o0, reason: collision with root package name */
        public int f1386o0 = 0;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f1359p0 = sparseIntArray;
            sparseIntArray.append(43, 24);
            sparseIntArray.append(44, 25);
            sparseIntArray.append(46, 28);
            sparseIntArray.append(47, 29);
            sparseIntArray.append(52, 35);
            sparseIntArray.append(51, 34);
            sparseIntArray.append(24, 4);
            sparseIntArray.append(23, 3);
            sparseIntArray.append(19, 1);
            sparseIntArray.append(61, 6);
            sparseIntArray.append(62, 7);
            sparseIntArray.append(31, 17);
            sparseIntArray.append(32, 18);
            sparseIntArray.append(33, 19);
            sparseIntArray.append(15, 90);
            sparseIntArray.append(0, 26);
            sparseIntArray.append(48, 31);
            sparseIntArray.append(49, 32);
            sparseIntArray.append(30, 10);
            sparseIntArray.append(29, 9);
            sparseIntArray.append(66, 13);
            sparseIntArray.append(69, 16);
            sparseIntArray.append(67, 14);
            sparseIntArray.append(64, 11);
            sparseIntArray.append(68, 15);
            sparseIntArray.append(65, 12);
            sparseIntArray.append(55, 38);
            sparseIntArray.append(41, 37);
            sparseIntArray.append(40, 39);
            sparseIntArray.append(54, 40);
            sparseIntArray.append(39, 20);
            sparseIntArray.append(53, 36);
            sparseIntArray.append(28, 5);
            sparseIntArray.append(42, 91);
            sparseIntArray.append(50, 91);
            sparseIntArray.append(45, 91);
            sparseIntArray.append(22, 91);
            sparseIntArray.append(18, 91);
            sparseIntArray.append(3, 23);
            sparseIntArray.append(5, 27);
            sparseIntArray.append(7, 30);
            sparseIntArray.append(8, 8);
            sparseIntArray.append(4, 33);
            sparseIntArray.append(6, 2);
            sparseIntArray.append(1, 22);
            sparseIntArray.append(2, 21);
            sparseIntArray.append(56, 41);
            sparseIntArray.append(34, 42);
            sparseIntArray.append(17, 87);
            sparseIntArray.append(16, 88);
            sparseIntArray.append(71, 76);
            sparseIntArray.append(25, 61);
            sparseIntArray.append(27, 62);
            sparseIntArray.append(26, 63);
            sparseIntArray.append(60, 69);
            sparseIntArray.append(38, 70);
            sparseIntArray.append(12, 71);
            sparseIntArray.append(10, 72);
            sparseIntArray.append(11, 73);
            sparseIntArray.append(13, 74);
            sparseIntArray.append(9, 75);
            sparseIntArray.append(58, 84);
            sparseIntArray.append(59, 86);
            sparseIntArray.append(58, 83);
            sparseIntArray.append(37, 85);
            sparseIntArray.append(56, 87);
            sparseIntArray.append(34, 88);
            sparseIntArray.append(91, 89);
            sparseIntArray.append(15, 90);
        }

        public final void a(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j0.d.f9644f);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                SparseIntArray sparseIntArray = f1359p0;
                int i11 = sparseIntArray.get(index);
                switch (i11) {
                    case 1:
                        this.f1387p = c.f(typedArrayObtainStyledAttributes, index, this.f1387p);
                        break;
                    case 2:
                        this.I = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.I);
                        break;
                    case 3:
                        this.f1385o = c.f(typedArrayObtainStyledAttributes, index, this.f1385o);
                        break;
                    case 4:
                        this.f1383n = c.f(typedArrayObtainStyledAttributes, index, this.f1383n);
                        break;
                    case 5:
                        this.f1395y = typedArrayObtainStyledAttributes.getString(index);
                        break;
                    case 6:
                        this.C = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.C);
                        break;
                    case 7:
                        this.D = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.D);
                        break;
                    case 8:
                        this.J = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.J);
                        break;
                    case 9:
                        this.f1392v = c.f(typedArrayObtainStyledAttributes, index, this.f1392v);
                        break;
                    case 10:
                        this.f1391u = c.f(typedArrayObtainStyledAttributes, index, this.f1391u);
                        break;
                    case 11:
                        this.P = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.P);
                        break;
                    case 12:
                        this.Q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.Q);
                        break;
                    case 13:
                        this.M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.M);
                        break;
                    case 14:
                        this.O = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.O);
                        break;
                    case 15:
                        this.R = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.R);
                        break;
                    case 16:
                        this.N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.N);
                        break;
                    case 17:
                        this.f1364d = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f1364d);
                        break;
                    case 18:
                        this.f1366e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f1366e);
                        break;
                    case 19:
                        this.f1368f = typedArrayObtainStyledAttributes.getFloat(index, this.f1368f);
                        break;
                    case 20:
                        this.f1393w = typedArrayObtainStyledAttributes.getFloat(index, this.f1393w);
                        break;
                    case 21:
                        this.f1363c = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.f1363c);
                        break;
                    case 22:
                        this.f1362b = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.f1362b);
                        break;
                    case 23:
                        this.F = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.F);
                        break;
                    case ErrorCodes.GET_INSTANCE_METHOD_INVOCATION_ERROR /* 24 */:
                        this.h = c.f(typedArrayObtainStyledAttributes, index, this.h);
                        break;
                    case 25:
                        this.f1373i = c.f(typedArrayObtainStyledAttributes, index, this.f1373i);
                        break;
                    case 26:
                        this.E = typedArrayObtainStyledAttributes.getInt(index, this.E);
                        break;
                    case 27:
                        this.G = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.G);
                        break;
                    case ErrorCodes.GET_CONTENT_URI_ERROR /* 28 */:
                        this.f1375j = c.f(typedArrayObtainStyledAttributes, index, this.f1375j);
                        break;
                    case ErrorCodes.GET_PACKAGE_INFO_ERROR /* 29 */:
                        this.f1377k = c.f(typedArrayObtainStyledAttributes, index, this.f1377k);
                        break;
                    case 30:
                        this.K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.K);
                        break;
                    case 31:
                        this.f1389s = c.f(typedArrayObtainStyledAttributes, index, this.f1389s);
                        break;
                    case 32:
                        this.f1390t = c.f(typedArrayObtainStyledAttributes, index, this.f1390t);
                        break;
                    case 33:
                        this.H = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.H);
                        break;
                    case 34:
                        this.f1381m = c.f(typedArrayObtainStyledAttributes, index, this.f1381m);
                        break;
                    case 35:
                        this.f1379l = c.f(typedArrayObtainStyledAttributes, index, this.f1379l);
                        break;
                    case 36:
                        this.f1394x = typedArrayObtainStyledAttributes.getFloat(index, this.f1394x);
                        break;
                    case 37:
                        this.U = typedArrayObtainStyledAttributes.getFloat(index, this.U);
                        break;
                    case 38:
                        this.T = typedArrayObtainStyledAttributes.getFloat(index, this.T);
                        break;
                    case 39:
                        this.V = typedArrayObtainStyledAttributes.getInt(index, this.V);
                        break;
                    case 40:
                        this.W = typedArrayObtainStyledAttributes.getInt(index, this.W);
                        break;
                    case 41:
                        c.g(this, typedArrayObtainStyledAttributes, index, 0);
                        break;
                    case 42:
                        c.g(this, typedArrayObtainStyledAttributes, index, 1);
                        break;
                    default:
                        switch (i11) {
                            case 61:
                                this.z = c.f(typedArrayObtainStyledAttributes, index, this.z);
                                break;
                            case 62:
                                this.A = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.A);
                                break;
                            case 63:
                                this.B = typedArrayObtainStyledAttributes.getFloat(index, this.B);
                                break;
                            default:
                                switch (i11) {
                                    case 69:
                                        this.f1365d0 = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                        break;
                                    case 70:
                                        this.f1367e0 = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                        break;
                                    case 71:
                                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                        break;
                                    case 72:
                                        this.f1369f0 = typedArrayObtainStyledAttributes.getInt(index, this.f1369f0);
                                        break;
                                    case 73:
                                        this.f1371g0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f1371g0);
                                        break;
                                    case 74:
                                        this.f1376j0 = typedArrayObtainStyledAttributes.getString(index);
                                        break;
                                    case 75:
                                        this.f1384n0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f1384n0);
                                        break;
                                    case 76:
                                        this.f1386o0 = typedArrayObtainStyledAttributes.getInt(index, this.f1386o0);
                                        break;
                                    case 77:
                                        this.f1388q = c.f(typedArrayObtainStyledAttributes, index, this.f1388q);
                                        break;
                                    case 78:
                                        this.r = c.f(typedArrayObtainStyledAttributes, index, this.r);
                                        break;
                                    case 79:
                                        this.S = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.S);
                                        break;
                                    case 80:
                                        this.L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.L);
                                        break;
                                    case 81:
                                        this.X = typedArrayObtainStyledAttributes.getInt(index, this.X);
                                        break;
                                    case 82:
                                        this.Y = typedArrayObtainStyledAttributes.getInt(index, this.Y);
                                        break;
                                    case 83:
                                        this.f1361a0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f1361a0);
                                        break;
                                    case 84:
                                        this.Z = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.Z);
                                        break;
                                    case 85:
                                        this.c0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.c0);
                                        break;
                                    case 86:
                                        this.b0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.b0);
                                        break;
                                    case 87:
                                        this.f1380l0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f1380l0);
                                        break;
                                    case 88:
                                        this.f1382m0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f1382m0);
                                        break;
                                    case 89:
                                        this.f1378k0 = typedArrayObtainStyledAttributes.getString(index);
                                        break;
                                    case 90:
                                        this.f1370g = typedArrayObtainStyledAttributes.getBoolean(index, this.f1370g);
                                        break;
                                    case 91:
                                        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                                        break;
                                    default:
                                        Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                                        break;
                                }
                        }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: androidx.constraintlayout.widget.c$c, reason: collision with other inner class name */
    public static class C0007c {

        /* renamed from: j, reason: collision with root package name */
        public static final SparseIntArray f1396j;

        /* renamed from: a, reason: collision with root package name */
        public int f1397a;

        /* renamed from: b, reason: collision with root package name */
        public int f1398b;

        /* renamed from: c, reason: collision with root package name */
        public int f1399c;

        /* renamed from: d, reason: collision with root package name */
        public float f1400d;

        /* renamed from: e, reason: collision with root package name */
        public float f1401e;

        /* renamed from: f, reason: collision with root package name */
        public float f1402f;

        /* renamed from: g, reason: collision with root package name */
        public int f1403g;
        public String h;

        /* renamed from: i, reason: collision with root package name */
        public int f1404i;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f1396j = sparseIntArray;
            sparseIntArray.append(3, 1);
            sparseIntArray.append(5, 2);
            sparseIntArray.append(9, 3);
            sparseIntArray.append(2, 4);
            sparseIntArray.append(1, 5);
            sparseIntArray.append(0, 6);
            sparseIntArray.append(4, 7);
            sparseIntArray.append(8, 8);
            sparseIntArray.append(7, 9);
            sparseIntArray.append(6, 10);
        }

        public final void a(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j0.d.f9645g);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                switch (f1396j.get(index)) {
                    case 1:
                        this.f1401e = typedArrayObtainStyledAttributes.getFloat(index, this.f1401e);
                        break;
                    case 2:
                        this.f1399c = typedArrayObtainStyledAttributes.getInt(index, this.f1399c);
                        break;
                    case 3:
                        if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                            typedArrayObtainStyledAttributes.getString(index);
                            break;
                        } else {
                            String str = f0.a.f8667b[typedArrayObtainStyledAttributes.getInteger(index, 0)];
                            break;
                        }
                    case 4:
                        typedArrayObtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.f1397a = c.f(typedArrayObtainStyledAttributes, index, this.f1397a);
                        break;
                    case 6:
                        this.f1398b = typedArrayObtainStyledAttributes.getInteger(index, this.f1398b);
                        break;
                    case 7:
                        this.f1400d = typedArrayObtainStyledAttributes.getFloat(index, this.f1400d);
                        break;
                    case 8:
                        this.f1403g = typedArrayObtainStyledAttributes.getInteger(index, this.f1403g);
                        break;
                    case 9:
                        this.f1402f = typedArrayObtainStyledAttributes.getFloat(index, this.f1402f);
                        break;
                    case 10:
                        int i11 = typedArrayObtainStyledAttributes.peekValue(index).type;
                        if (i11 == 1) {
                            this.f1404i = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                            break;
                        } else if (i11 == 3) {
                            String string = typedArrayObtainStyledAttributes.getString(index);
                            this.h = string;
                            if (string.indexOf("/") > 0) {
                                this.f1404i = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                                break;
                            } else {
                                break;
                            }
                        } else {
                            typedArrayObtainStyledAttributes.getInteger(index, this.f1404i);
                            break;
                        }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public int f1405a;

        /* renamed from: b, reason: collision with root package name */
        public int f1406b;

        /* renamed from: c, reason: collision with root package name */
        public float f1407c;

        /* renamed from: d, reason: collision with root package name */
        public float f1408d;

        public final void a(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j0.d.f9646i);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == 1) {
                    this.f1407c = typedArrayObtainStyledAttributes.getFloat(index, this.f1407c);
                } else if (index == 0) {
                    int i11 = typedArrayObtainStyledAttributes.getInt(index, this.f1405a);
                    this.f1405a = i11;
                    this.f1405a = c.f1336d[i11];
                } else if (index == 4) {
                    this.f1406b = typedArrayObtainStyledAttributes.getInt(index, this.f1406b);
                } else if (index == 3) {
                    this.f1408d = typedArrayObtainStyledAttributes.getFloat(index, this.f1408d);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class e {

        /* renamed from: n, reason: collision with root package name */
        public static final SparseIntArray f1409n;

        /* renamed from: a, reason: collision with root package name */
        public float f1410a;

        /* renamed from: b, reason: collision with root package name */
        public float f1411b;

        /* renamed from: c, reason: collision with root package name */
        public float f1412c;

        /* renamed from: d, reason: collision with root package name */
        public float f1413d;

        /* renamed from: e, reason: collision with root package name */
        public float f1414e;

        /* renamed from: f, reason: collision with root package name */
        public float f1415f;

        /* renamed from: g, reason: collision with root package name */
        public float f1416g;
        public int h;

        /* renamed from: i, reason: collision with root package name */
        public float f1417i;

        /* renamed from: j, reason: collision with root package name */
        public float f1418j;

        /* renamed from: k, reason: collision with root package name */
        public float f1419k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f1420l;

        /* renamed from: m, reason: collision with root package name */
        public float f1421m;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f1409n = sparseIntArray;
            sparseIntArray.append(6, 1);
            sparseIntArray.append(7, 2);
            sparseIntArray.append(8, 3);
            sparseIntArray.append(4, 4);
            sparseIntArray.append(5, 5);
            sparseIntArray.append(0, 6);
            sparseIntArray.append(1, 7);
            sparseIntArray.append(2, 8);
            sparseIntArray.append(3, 9);
            sparseIntArray.append(9, 10);
            sparseIntArray.append(10, 11);
            sparseIntArray.append(11, 12);
        }

        public final void a(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j0.d.f9648k);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                switch (f1409n.get(index)) {
                    case 1:
                        this.f1410a = typedArrayObtainStyledAttributes.getFloat(index, this.f1410a);
                        break;
                    case 2:
                        this.f1411b = typedArrayObtainStyledAttributes.getFloat(index, this.f1411b);
                        break;
                    case 3:
                        this.f1412c = typedArrayObtainStyledAttributes.getFloat(index, this.f1412c);
                        break;
                    case 4:
                        this.f1413d = typedArrayObtainStyledAttributes.getFloat(index, this.f1413d);
                        break;
                    case 5:
                        this.f1414e = typedArrayObtainStyledAttributes.getFloat(index, this.f1414e);
                        break;
                    case 6:
                        this.f1415f = typedArrayObtainStyledAttributes.getDimension(index, this.f1415f);
                        break;
                    case 7:
                        this.f1416g = typedArrayObtainStyledAttributes.getDimension(index, this.f1416g);
                        break;
                    case 8:
                        this.f1417i = typedArrayObtainStyledAttributes.getDimension(index, this.f1417i);
                        break;
                    case 9:
                        this.f1418j = typedArrayObtainStyledAttributes.getDimension(index, this.f1418j);
                        break;
                    case 10:
                        this.f1419k = typedArrayObtainStyledAttributes.getDimension(index, this.f1419k);
                        break;
                    case 11:
                        this.f1420l = true;
                        this.f1421m = typedArrayObtainStyledAttributes.getDimension(index, this.f1421m);
                        break;
                    case 12:
                        this.h = c.f(typedArrayObtainStyledAttributes, index, this.h);
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f1337e = sparseIntArray;
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        f1338f = sparseIntArray2;
        sparseIntArray.append(82, 25);
        sparseIntArray.append(83, 26);
        sparseIntArray.append(85, 29);
        sparseIntArray.append(86, 30);
        sparseIntArray.append(92, 36);
        sparseIntArray.append(91, 35);
        sparseIntArray.append(63, 4);
        sparseIntArray.append(62, 3);
        sparseIntArray.append(58, 1);
        sparseIntArray.append(60, 91);
        sparseIntArray.append(59, 92);
        sparseIntArray.append(101, 6);
        sparseIntArray.append(102, 7);
        sparseIntArray.append(70, 17);
        sparseIntArray.append(71, 18);
        sparseIntArray.append(72, 19);
        sparseIntArray.append(54, 99);
        sparseIntArray.append(0, 27);
        sparseIntArray.append(87, 32);
        sparseIntArray.append(88, 33);
        sparseIntArray.append(69, 10);
        sparseIntArray.append(68, 9);
        sparseIntArray.append(Content.Types.TYPE_FLOAT_ARRAY, 13);
        sparseIntArray.append(109, 16);
        sparseIntArray.append(Content.Types.TYPE_INT_ARRAY, 14);
        sparseIntArray.append(Content.Types.TYPE_BOOLEAN, 11);
        sparseIntArray.append(Content.Types.TYPE_DOUBLE_ARRAY, 15);
        sparseIntArray.append(Content.Types.TYPE_STRING, 12);
        sparseIntArray.append(95, 40);
        sparseIntArray.append(80, 39);
        sparseIntArray.append(79, 41);
        sparseIntArray.append(94, 42);
        sparseIntArray.append(78, 20);
        sparseIntArray.append(93, 37);
        sparseIntArray.append(67, 5);
        sparseIntArray.append(81, 87);
        sparseIntArray.append(90, 87);
        sparseIntArray.append(84, 87);
        sparseIntArray.append(61, 87);
        sparseIntArray.append(57, 87);
        sparseIntArray.append(5, 24);
        sparseIntArray.append(7, 28);
        sparseIntArray.append(23, 31);
        sparseIntArray.append(24, 8);
        sparseIntArray.append(6, 34);
        sparseIntArray.append(8, 2);
        sparseIntArray.append(3, 23);
        sparseIntArray.append(4, 21);
        sparseIntArray.append(96, 95);
        sparseIntArray.append(73, 96);
        sparseIntArray.append(2, 22);
        sparseIntArray.append(13, 43);
        sparseIntArray.append(26, 44);
        sparseIntArray.append(21, 45);
        sparseIntArray.append(22, 46);
        sparseIntArray.append(20, 60);
        sparseIntArray.append(18, 47);
        sparseIntArray.append(19, 48);
        sparseIntArray.append(14, 49);
        sparseIntArray.append(15, 50);
        sparseIntArray.append(16, 51);
        sparseIntArray.append(17, 52);
        sparseIntArray.append(25, 53);
        sparseIntArray.append(97, 54);
        sparseIntArray.append(74, 55);
        sparseIntArray.append(98, 56);
        sparseIntArray.append(75, 57);
        sparseIntArray.append(99, 58);
        sparseIntArray.append(76, 59);
        sparseIntArray.append(64, 61);
        sparseIntArray.append(66, 62);
        sparseIntArray.append(65, 63);
        sparseIntArray.append(28, 64);
        sparseIntArray.append(121, 65);
        sparseIntArray.append(35, 66);
        sparseIntArray.append(FekEnvelope.EXPECTED_EPK_CHARS, 67);
        sparseIntArray.append(113, 79);
        sparseIntArray.append(1, 38);
        sparseIntArray.append(112, 68);
        sparseIntArray.append(100, 69);
        sparseIntArray.append(77, 70);
        sparseIntArray.append(111, 97);
        sparseIntArray.append(32, 71);
        sparseIntArray.append(30, 72);
        sparseIntArray.append(31, 73);
        sparseIntArray.append(33, 74);
        sparseIntArray.append(29, 75);
        sparseIntArray.append(114, 76);
        sparseIntArray.append(89, 77);
        sparseIntArray.append(123, 78);
        sparseIntArray.append(56, 80);
        sparseIntArray.append(55, 81);
        sparseIntArray.append(116, 82);
        sparseIntArray.append(120, 83);
        sparseIntArray.append(119, 84);
        sparseIntArray.append(118, 85);
        sparseIntArray.append(117, 86);
        sparseIntArray2.append(85, 6);
        sparseIntArray2.append(85, 7);
        sparseIntArray2.append(0, 27);
        sparseIntArray2.append(89, 13);
        sparseIntArray2.append(92, 16);
        sparseIntArray2.append(90, 14);
        sparseIntArray2.append(87, 11);
        sparseIntArray2.append(91, 15);
        sparseIntArray2.append(88, 12);
        sparseIntArray2.append(78, 40);
        sparseIntArray2.append(71, 39);
        sparseIntArray2.append(70, 41);
        sparseIntArray2.append(77, 42);
        sparseIntArray2.append(69, 20);
        sparseIntArray2.append(76, 37);
        sparseIntArray2.append(60, 5);
        sparseIntArray2.append(72, 87);
        sparseIntArray2.append(75, 87);
        sparseIntArray2.append(73, 87);
        sparseIntArray2.append(57, 87);
        sparseIntArray2.append(56, 87);
        sparseIntArray2.append(5, 24);
        sparseIntArray2.append(7, 28);
        sparseIntArray2.append(23, 31);
        sparseIntArray2.append(24, 8);
        sparseIntArray2.append(6, 34);
        sparseIntArray2.append(8, 2);
        sparseIntArray2.append(3, 23);
        sparseIntArray2.append(4, 21);
        sparseIntArray2.append(79, 95);
        sparseIntArray2.append(64, 96);
        sparseIntArray2.append(2, 22);
        sparseIntArray2.append(13, 43);
        sparseIntArray2.append(26, 44);
        sparseIntArray2.append(21, 45);
        sparseIntArray2.append(22, 46);
        sparseIntArray2.append(20, 60);
        sparseIntArray2.append(18, 47);
        sparseIntArray2.append(19, 48);
        sparseIntArray2.append(14, 49);
        sparseIntArray2.append(15, 50);
        sparseIntArray2.append(16, 51);
        sparseIntArray2.append(17, 52);
        sparseIntArray2.append(25, 53);
        sparseIntArray2.append(80, 54);
        sparseIntArray2.append(65, 55);
        sparseIntArray2.append(81, 56);
        sparseIntArray2.append(66, 57);
        sparseIntArray2.append(82, 58);
        sparseIntArray2.append(67, 59);
        sparseIntArray2.append(59, 62);
        sparseIntArray2.append(58, 63);
        sparseIntArray2.append(28, 64);
        sparseIntArray2.append(Content.Types.TYPE_STRING, 65);
        sparseIntArray2.append(34, 66);
        sparseIntArray2.append(Content.Types.TYPE_FLOAT_ARRAY, 67);
        sparseIntArray2.append(96, 79);
        sparseIntArray2.append(1, 38);
        sparseIntArray2.append(97, 98);
        sparseIntArray2.append(95, 68);
        sparseIntArray2.append(83, 69);
        sparseIntArray2.append(68, 70);
        sparseIntArray2.append(32, 71);
        sparseIntArray2.append(30, 72);
        sparseIntArray2.append(31, 73);
        sparseIntArray2.append(33, 74);
        sparseIntArray2.append(29, 75);
        sparseIntArray2.append(98, 76);
        sparseIntArray2.append(74, 77);
        sparseIntArray2.append(Content.Types.TYPE_INT_ARRAY, 78);
        sparseIntArray2.append(55, 80);
        sparseIntArray2.append(54, 81);
        sparseIntArray2.append(100, 82);
        sparseIntArray2.append(Content.Types.TYPE_BOOLEAN, 83);
        sparseIntArray2.append(Content.Types.TYPE_DOUBLE, 84);
        sparseIntArray2.append(102, 85);
        sparseIntArray2.append(101, 86);
        sparseIntArray2.append(94, 97);
    }

    public static int[] c(androidx.constraintlayout.widget.a aVar, String str) throws IllegalAccessException, IllegalArgumentException {
        int iIntValue;
        String[] strArrSplit = str.split(",");
        Context context = aVar.getContext();
        int[] iArr = new int[strArrSplit.length];
        int i10 = 0;
        int i11 = 0;
        while (i10 < strArrSplit.length) {
            String strTrim = strArrSplit[i10].trim();
            Integer num = null;
            try {
                iIntValue = j0.c.class.getField(strTrim).getInt(null);
            } catch (Exception unused) {
                iIntValue = 0;
            }
            if (iIntValue == 0) {
                iIntValue = context.getResources().getIdentifier(strTrim, ModelDownloadNotifier.EXTRA_NOTIF_ID, context.getPackageName());
            }
            if (iIntValue == 0 && aVar.isInEditMode() && (aVar.getParent() instanceof ConstraintLayout)) {
                ConstraintLayout constraintLayout = (ConstraintLayout) aVar.getParent();
                if (strTrim != null) {
                    HashMap<String, Integer> map = constraintLayout.f1279p;
                    if (map != null && map.containsKey(strTrim)) {
                        num = constraintLayout.f1279p.get(strTrim);
                    }
                } else {
                    constraintLayout.getClass();
                }
                if (num != null && (num instanceof Integer)) {
                    iIntValue = num.intValue();
                }
            }
            iArr[i11] = iIntValue;
            i10++;
            i11++;
        }
        return i11 != strArrSplit.length ? Arrays.copyOf(iArr, i11) : iArr;
    }

    public static a d(Context context, AttributeSet attributeSet, boolean z) {
        int i10;
        boolean z3;
        String str;
        a aVar = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z ? j0.d.f9641c : j0.d.f9639a);
        d dVar = aVar.f1343b;
        e eVar = aVar.f1346e;
        C0007c c0007c = aVar.f1344c;
        b bVar = aVar.f1345d;
        int[] iArr = f1336d;
        String[] strArr = f0.a.f8667b;
        String str2 = "Unknown attribute 0x";
        SparseIntArray sparseIntArray = f1337e;
        if (z) {
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            a.C0006a c0006a = new a.C0006a();
            c0007c.getClass();
            bVar.getClass();
            eVar.getClass();
            int i11 = 0;
            while (i11 < indexCount) {
                int i12 = indexCount;
                int index = typedArrayObtainStyledAttributes.getIndex(i11);
                int i13 = i11;
                switch (f1338f.get(index)) {
                    case 2:
                        str = str2;
                        c0006a.b(2, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, bVar.I));
                        break;
                    case 3:
                    case 4:
                    case 9:
                    case 10:
                    case 25:
                    case 26:
                    case ErrorCodes.GET_PACKAGE_INFO_ERROR /* 29 */:
                    case 30:
                    case 32:
                    case 33:
                    case 35:
                    case 36:
                    case 61:
                    case 88:
                    case 89:
                    case 90:
                    case 91:
                    case 92:
                    default:
                        StringBuilder sb2 = new StringBuilder(str2);
                        str = str2;
                        sb2.append(Integer.toHexString(index));
                        sb2.append("   ");
                        sb2.append(sparseIntArray.get(index));
                        Log.w("ConstraintSet", sb2.toString());
                        break;
                    case 5:
                        str = str2;
                        c0006a.c(5, typedArrayObtainStyledAttributes.getString(index));
                        break;
                    case 6:
                        str = str2;
                        c0006a.b(6, typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, bVar.C));
                        break;
                    case 7:
                        str = str2;
                        c0006a.b(7, typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, bVar.D));
                        break;
                    case 8:
                        str = str2;
                        c0006a.b(8, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, bVar.J));
                        break;
                    case 11:
                        str = str2;
                        c0006a.b(11, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, bVar.P));
                        break;
                    case 12:
                        str = str2;
                        c0006a.b(12, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, bVar.Q));
                        break;
                    case 13:
                        str = str2;
                        c0006a.b(13, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, bVar.M));
                        break;
                    case 14:
                        str = str2;
                        c0006a.b(14, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, bVar.O));
                        break;
                    case 15:
                        str = str2;
                        c0006a.b(15, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, bVar.R));
                        break;
                    case 16:
                        str = str2;
                        c0006a.b(16, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, bVar.N));
                        break;
                    case 17:
                        str = str2;
                        c0006a.b(17, typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, bVar.f1364d));
                        break;
                    case 18:
                        str = str2;
                        c0006a.b(18, typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, bVar.f1366e));
                        break;
                    case 19:
                        str = str2;
                        c0006a.a(typedArrayObtainStyledAttributes.getFloat(index, bVar.f1368f), 19);
                        break;
                    case 20:
                        str = str2;
                        c0006a.a(typedArrayObtainStyledAttributes.getFloat(index, bVar.f1393w), 20);
                        break;
                    case 21:
                        str = str2;
                        c0006a.b(21, typedArrayObtainStyledAttributes.getLayoutDimension(index, bVar.f1363c));
                        break;
                    case 22:
                        str = str2;
                        c0006a.b(22, iArr[typedArrayObtainStyledAttributes.getInt(index, dVar.f1405a)]);
                        break;
                    case 23:
                        str = str2;
                        c0006a.b(23, typedArrayObtainStyledAttributes.getLayoutDimension(index, bVar.f1362b));
                        break;
                    case ErrorCodes.GET_INSTANCE_METHOD_INVOCATION_ERROR /* 24 */:
                        str = str2;
                        c0006a.b(24, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, bVar.F));
                        break;
                    case 27:
                        str = str2;
                        c0006a.b(27, typedArrayObtainStyledAttributes.getInt(index, bVar.E));
                        break;
                    case ErrorCodes.GET_CONTENT_URI_ERROR /* 28 */:
                        str = str2;
                        c0006a.b(28, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, bVar.G));
                        break;
                    case 31:
                        str = str2;
                        c0006a.b(31, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, bVar.K));
                        break;
                    case 34:
                        str = str2;
                        c0006a.b(34, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, bVar.H));
                        break;
                    case 37:
                        str = str2;
                        c0006a.a(typedArrayObtainStyledAttributes.getFloat(index, bVar.f1394x), 37);
                        break;
                    case 38:
                        str = str2;
                        int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, aVar.f1342a);
                        aVar.f1342a = resourceId;
                        c0006a.b(38, resourceId);
                        break;
                    case 39:
                        str = str2;
                        c0006a.a(typedArrayObtainStyledAttributes.getFloat(index, bVar.U), 39);
                        break;
                    case 40:
                        str = str2;
                        c0006a.a(typedArrayObtainStyledAttributes.getFloat(index, bVar.T), 40);
                        break;
                    case 41:
                        str = str2;
                        c0006a.b(41, typedArrayObtainStyledAttributes.getInt(index, bVar.V));
                        break;
                    case 42:
                        str = str2;
                        c0006a.b(42, typedArrayObtainStyledAttributes.getInt(index, bVar.W));
                        break;
                    case ErrorCodes.API_VERSION_CODE_TOO_HIGH /* 43 */:
                        str = str2;
                        c0006a.a(typedArrayObtainStyledAttributes.getFloat(index, dVar.f1407c), 43);
                        break;
                    case ErrorCodes.NOT_SET_VERSION_CODE_ERROR /* 44 */:
                        str = str2;
                        c0006a.d(44, true);
                        c0006a.a(typedArrayObtainStyledAttributes.getDimension(index, eVar.f1421m), 44);
                        break;
                    case ErrorCodes.CALLER_NOT_IN_METHOD_WHITE_LIST_ERROR /* 45 */:
                        str = str2;
                        c0006a.a(typedArrayObtainStyledAttributes.getFloat(index, eVar.f1411b), 45);
                        break;
                    case ErrorCodes.CALLER_IN_METHOD_BLACK_LIST_ERROR /* 46 */:
                        str = str2;
                        c0006a.a(typedArrayObtainStyledAttributes.getFloat(index, eVar.f1412c), 46);
                        break;
                    case ErrorCodes.CALLER_NOT_IN_SERVICE_WHITE_LIST_ERROR /* 47 */:
                        str = str2;
                        c0006a.a(typedArrayObtainStyledAttributes.getFloat(index, eVar.f1413d), 47);
                        break;
                    case ErrorCodes.CALLER_IN_SERVICE_BLACK_LIST_ERROR /* 48 */:
                        str = str2;
                        c0006a.a(typedArrayObtainStyledAttributes.getFloat(index, eVar.f1414e), 48);
                        break;
                    case ErrorCodes.PRE_SERVICE_METHOD_INTERCEPT_ERROR /* 49 */:
                        str = str2;
                        c0006a.a(typedArrayObtainStyledAttributes.getDimension(index, eVar.f1415f), 49);
                        break;
                    case ErrorCodes.AFTER_SERVICE_METHOD_INTERCEPT_ERROR /* 50 */:
                        str = str2;
                        c0006a.a(typedArrayObtainStyledAttributes.getDimension(index, eVar.f1416g), 50);
                        break;
                    case ErrorCodes.SERVICE_RECYCLE_ERROR /* 51 */:
                        str = str2;
                        c0006a.a(typedArrayObtainStyledAttributes.getDimension(index, eVar.f1417i), 51);
                        break;
                    case ErrorCodes.CALLER_PROTOCOL_VERSION_TOO_HIGH /* 52 */:
                        str = str2;
                        c0006a.a(typedArrayObtainStyledAttributes.getDimension(index, eVar.f1418j), 52);
                        break;
                    case ErrorCodes.CALLBACK_RECYCLE_ERROR /* 53 */:
                        str = str2;
                        c0006a.a(typedArrayObtainStyledAttributes.getDimension(index, eVar.f1419k), 53);
                        break;
                    case 54:
                        str = str2;
                        c0006a.b(54, typedArrayObtainStyledAttributes.getInt(index, bVar.X));
                        break;
                    case 55:
                        str = str2;
                        c0006a.b(55, typedArrayObtainStyledAttributes.getInt(index, bVar.Y));
                        break;
                    case 56:
                        str = str2;
                        c0006a.b(56, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, bVar.Z));
                        break;
                    case 57:
                        str = str2;
                        c0006a.b(57, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, bVar.f1361a0));
                        break;
                    case 58:
                        str = str2;
                        c0006a.b(58, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, bVar.b0));
                        break;
                    case 59:
                        str = str2;
                        c0006a.b(59, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, bVar.c0));
                        break;
                    case 60:
                        str = str2;
                        c0006a.a(typedArrayObtainStyledAttributes.getFloat(index, eVar.f1410a), 60);
                        break;
                    case 62:
                        str = str2;
                        c0006a.b(62, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, bVar.A));
                        break;
                    case 63:
                        str = str2;
                        c0006a.a(typedArrayObtainStyledAttributes.getFloat(index, bVar.B), 63);
                        break;
                    case 64:
                        str = str2;
                        c0006a.b(64, f(typedArrayObtainStyledAttributes, index, c0007c.f1397a));
                        break;
                    case 65:
                        str = str2;
                        if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                            c0006a.c(65, typedArrayObtainStyledAttributes.getString(index));
                            break;
                        } else {
                            c0006a.c(65, strArr[typedArrayObtainStyledAttributes.getInteger(index, 0)]);
                            break;
                        }
                    case 66:
                        str = str2;
                        c0006a.b(66, typedArrayObtainStyledAttributes.getInt(index, 0));
                        break;
                    case 67:
                        str = str2;
                        c0006a.a(typedArrayObtainStyledAttributes.getFloat(index, c0007c.f1401e), 67);
                        break;
                    case 68:
                        str = str2;
                        c0006a.a(typedArrayObtainStyledAttributes.getFloat(index, dVar.f1408d), 68);
                        break;
                    case 69:
                        str = str2;
                        c0006a.a(typedArrayObtainStyledAttributes.getFloat(index, 1.0f), 69);
                        break;
                    case 70:
                        str = str2;
                        c0006a.a(typedArrayObtainStyledAttributes.getFloat(index, 1.0f), 70);
                        break;
                    case 71:
                        str = str2;
                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                        break;
                    case 72:
                        str = str2;
                        c0006a.b(72, typedArrayObtainStyledAttributes.getInt(index, bVar.f1369f0));
                        break;
                    case 73:
                        str = str2;
                        c0006a.b(73, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, bVar.f1371g0));
                        break;
                    case 74:
                        str = str2;
                        c0006a.c(74, typedArrayObtainStyledAttributes.getString(index));
                        break;
                    case 75:
                        str = str2;
                        c0006a.d(75, typedArrayObtainStyledAttributes.getBoolean(index, bVar.f1384n0));
                        break;
                    case 76:
                        str = str2;
                        c0006a.b(76, typedArrayObtainStyledAttributes.getInt(index, c0007c.f1399c));
                        break;
                    case 77:
                        str = str2;
                        c0006a.c(77, typedArrayObtainStyledAttributes.getString(index));
                        break;
                    case 78:
                        str = str2;
                        c0006a.b(78, typedArrayObtainStyledAttributes.getInt(index, dVar.f1406b));
                        break;
                    case 79:
                        str = str2;
                        c0006a.a(typedArrayObtainStyledAttributes.getFloat(index, c0007c.f1400d), 79);
                        break;
                    case 80:
                        str = str2;
                        c0006a.d(80, typedArrayObtainStyledAttributes.getBoolean(index, bVar.f1380l0));
                        break;
                    case 81:
                        str = str2;
                        c0006a.d(81, typedArrayObtainStyledAttributes.getBoolean(index, bVar.f1382m0));
                        break;
                    case 82:
                        str = str2;
                        c0006a.b(82, typedArrayObtainStyledAttributes.getInteger(index, c0007c.f1398b));
                        break;
                    case 83:
                        str = str2;
                        c0006a.b(83, f(typedArrayObtainStyledAttributes, index, eVar.h));
                        break;
                    case 84:
                        str = str2;
                        c0006a.b(84, typedArrayObtainStyledAttributes.getInteger(index, c0007c.f1403g));
                        break;
                    case 85:
                        str = str2;
                        c0006a.a(typedArrayObtainStyledAttributes.getFloat(index, c0007c.f1402f), 85);
                        break;
                    case 86:
                        str = str2;
                        int i14 = typedArrayObtainStyledAttributes.peekValue(index).type;
                        if (i14 == 1) {
                            int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                            c0007c.f1404i = resourceId2;
                            c0006a.b(89, resourceId2);
                            if (c0007c.f1404i != -1) {
                                c0006a.b(88, -2);
                                break;
                            } else {
                                break;
                            }
                        } else if (i14 == 3) {
                            String string = typedArrayObtainStyledAttributes.getString(index);
                            c0007c.h = string;
                            c0006a.c(90, string);
                            if (c0007c.h.indexOf("/") > 0) {
                                int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                                c0007c.f1404i = resourceId3;
                                c0006a.b(89, resourceId3);
                                c0006a.b(88, -2);
                                break;
                            } else {
                                c0006a.b(88, -1);
                                break;
                            }
                        } else {
                            c0006a.b(88, typedArrayObtainStyledAttributes.getInteger(index, c0007c.f1404i));
                            break;
                        }
                    case 87:
                        str = str2;
                        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                        break;
                    case 93:
                        str = str2;
                        c0006a.b(93, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, bVar.L));
                        break;
                    case 94:
                        str = str2;
                        c0006a.b(94, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, bVar.S));
                        break;
                    case 95:
                        str = str2;
                        g(c0006a, typedArrayObtainStyledAttributes, index, 0);
                        break;
                    case 96:
                        str = str2;
                        g(c0006a, typedArrayObtainStyledAttributes, index, 1);
                        break;
                    case 97:
                        str = str2;
                        c0006a.b(97, typedArrayObtainStyledAttributes.getInt(index, bVar.f1386o0));
                        break;
                    case 98:
                        str = str2;
                        int i15 = MotionLayout.I;
                        if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                            typedArrayObtainStyledAttributes.getString(index);
                            break;
                        } else {
                            aVar.f1342a = typedArrayObtainStyledAttributes.getResourceId(index, aVar.f1342a);
                            break;
                        }
                    case 99:
                        str = str2;
                        c0006a.d(99, typedArrayObtainStyledAttributes.getBoolean(index, bVar.f1370g));
                        break;
                }
                i11 = i13 + 1;
                indexCount = i12;
                str2 = str;
            }
        } else {
            int i16 = 0;
            for (int indexCount2 = typedArrayObtainStyledAttributes.getIndexCount(); i16 < indexCount2; indexCount2 = i10) {
                int index2 = typedArrayObtainStyledAttributes.getIndex(i16);
                if (index2 != 1 && 23 != index2) {
                    if (24 != index2) {
                        c0007c.getClass();
                        bVar.getClass();
                        eVar.getClass();
                    }
                }
                switch (sparseIntArray.get(index2)) {
                    case 1:
                        i10 = indexCount2;
                        bVar.f1387p = f(typedArrayObtainStyledAttributes, index2, bVar.f1387p);
                        break;
                    case 2:
                        i10 = indexCount2;
                        bVar.I = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, bVar.I);
                        break;
                    case 3:
                        i10 = indexCount2;
                        bVar.f1385o = f(typedArrayObtainStyledAttributes, index2, bVar.f1385o);
                        break;
                    case 4:
                        i10 = indexCount2;
                        bVar.f1383n = f(typedArrayObtainStyledAttributes, index2, bVar.f1383n);
                        break;
                    case 5:
                        i10 = indexCount2;
                        bVar.f1395y = typedArrayObtainStyledAttributes.getString(index2);
                        break;
                    case 6:
                        i10 = indexCount2;
                        bVar.C = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index2, bVar.C);
                        break;
                    case 7:
                        i10 = indexCount2;
                        bVar.D = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index2, bVar.D);
                        break;
                    case 8:
                        i10 = indexCount2;
                        bVar.J = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, bVar.J);
                        break;
                    case 9:
                        i10 = indexCount2;
                        bVar.f1392v = f(typedArrayObtainStyledAttributes, index2, bVar.f1392v);
                        break;
                    case 10:
                        i10 = indexCount2;
                        bVar.f1391u = f(typedArrayObtainStyledAttributes, index2, bVar.f1391u);
                        break;
                    case 11:
                        i10 = indexCount2;
                        bVar.P = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, bVar.P);
                        break;
                    case 12:
                        i10 = indexCount2;
                        bVar.Q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, bVar.Q);
                        break;
                    case 13:
                        i10 = indexCount2;
                        bVar.M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, bVar.M);
                        break;
                    case 14:
                        i10 = indexCount2;
                        bVar.O = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, bVar.O);
                        break;
                    case 15:
                        i10 = indexCount2;
                        bVar.R = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, bVar.R);
                        break;
                    case 16:
                        i10 = indexCount2;
                        bVar.N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, bVar.N);
                        break;
                    case 17:
                        i10 = indexCount2;
                        bVar.f1364d = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index2, bVar.f1364d);
                        break;
                    case 18:
                        i10 = indexCount2;
                        bVar.f1366e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index2, bVar.f1366e);
                        break;
                    case 19:
                        i10 = indexCount2;
                        bVar.f1368f = typedArrayObtainStyledAttributes.getFloat(index2, bVar.f1368f);
                        break;
                    case 20:
                        i10 = indexCount2;
                        bVar.f1393w = typedArrayObtainStyledAttributes.getFloat(index2, bVar.f1393w);
                        break;
                    case 21:
                        i10 = indexCount2;
                        bVar.f1363c = typedArrayObtainStyledAttributes.getLayoutDimension(index2, bVar.f1363c);
                        break;
                    case 22:
                        i10 = indexCount2;
                        int i17 = typedArrayObtainStyledAttributes.getInt(index2, dVar.f1405a);
                        dVar.f1405a = i17;
                        dVar.f1405a = iArr[i17];
                        break;
                    case 23:
                        i10 = indexCount2;
                        bVar.f1362b = typedArrayObtainStyledAttributes.getLayoutDimension(index2, bVar.f1362b);
                        break;
                    case ErrorCodes.GET_INSTANCE_METHOD_INVOCATION_ERROR /* 24 */:
                        i10 = indexCount2;
                        bVar.F = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, bVar.F);
                        break;
                    case 25:
                        i10 = indexCount2;
                        bVar.h = f(typedArrayObtainStyledAttributes, index2, bVar.h);
                        break;
                    case 26:
                        i10 = indexCount2;
                        bVar.f1373i = f(typedArrayObtainStyledAttributes, index2, bVar.f1373i);
                        break;
                    case 27:
                        i10 = indexCount2;
                        bVar.E = typedArrayObtainStyledAttributes.getInt(index2, bVar.E);
                        break;
                    case ErrorCodes.GET_CONTENT_URI_ERROR /* 28 */:
                        i10 = indexCount2;
                        bVar.G = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, bVar.G);
                        break;
                    case ErrorCodes.GET_PACKAGE_INFO_ERROR /* 29 */:
                        i10 = indexCount2;
                        bVar.f1375j = f(typedArrayObtainStyledAttributes, index2, bVar.f1375j);
                        break;
                    case 30:
                        i10 = indexCount2;
                        bVar.f1377k = f(typedArrayObtainStyledAttributes, index2, bVar.f1377k);
                        break;
                    case 31:
                        i10 = indexCount2;
                        bVar.K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, bVar.K);
                        break;
                    case 32:
                        i10 = indexCount2;
                        bVar.f1389s = f(typedArrayObtainStyledAttributes, index2, bVar.f1389s);
                        break;
                    case 33:
                        i10 = indexCount2;
                        bVar.f1390t = f(typedArrayObtainStyledAttributes, index2, bVar.f1390t);
                        break;
                    case 34:
                        i10 = indexCount2;
                        bVar.H = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, bVar.H);
                        break;
                    case 35:
                        i10 = indexCount2;
                        bVar.f1381m = f(typedArrayObtainStyledAttributes, index2, bVar.f1381m);
                        break;
                    case 36:
                        i10 = indexCount2;
                        bVar.f1379l = f(typedArrayObtainStyledAttributes, index2, bVar.f1379l);
                        break;
                    case 37:
                        i10 = indexCount2;
                        bVar.f1394x = typedArrayObtainStyledAttributes.getFloat(index2, bVar.f1394x);
                        break;
                    case 38:
                        i10 = indexCount2;
                        aVar.f1342a = typedArrayObtainStyledAttributes.getResourceId(index2, aVar.f1342a);
                        break;
                    case 39:
                        i10 = indexCount2;
                        bVar.U = typedArrayObtainStyledAttributes.getFloat(index2, bVar.U);
                        break;
                    case 40:
                        i10 = indexCount2;
                        bVar.T = typedArrayObtainStyledAttributes.getFloat(index2, bVar.T);
                        break;
                    case 41:
                        i10 = indexCount2;
                        bVar.V = typedArrayObtainStyledAttributes.getInt(index2, bVar.V);
                        break;
                    case 42:
                        i10 = indexCount2;
                        bVar.W = typedArrayObtainStyledAttributes.getInt(index2, bVar.W);
                        break;
                    case ErrorCodes.API_VERSION_CODE_TOO_HIGH /* 43 */:
                        i10 = indexCount2;
                        dVar.f1407c = typedArrayObtainStyledAttributes.getFloat(index2, dVar.f1407c);
                        break;
                    case ErrorCodes.NOT_SET_VERSION_CODE_ERROR /* 44 */:
                        i10 = indexCount2;
                        eVar.f1420l = true;
                        eVar.f1421m = typedArrayObtainStyledAttributes.getDimension(index2, eVar.f1421m);
                        break;
                    case ErrorCodes.CALLER_NOT_IN_METHOD_WHITE_LIST_ERROR /* 45 */:
                        i10 = indexCount2;
                        eVar.f1411b = typedArrayObtainStyledAttributes.getFloat(index2, eVar.f1411b);
                        break;
                    case ErrorCodes.CALLER_IN_METHOD_BLACK_LIST_ERROR /* 46 */:
                        i10 = indexCount2;
                        eVar.f1412c = typedArrayObtainStyledAttributes.getFloat(index2, eVar.f1412c);
                        break;
                    case ErrorCodes.CALLER_NOT_IN_SERVICE_WHITE_LIST_ERROR /* 47 */:
                        i10 = indexCount2;
                        eVar.f1413d = typedArrayObtainStyledAttributes.getFloat(index2, eVar.f1413d);
                        break;
                    case ErrorCodes.CALLER_IN_SERVICE_BLACK_LIST_ERROR /* 48 */:
                        i10 = indexCount2;
                        eVar.f1414e = typedArrayObtainStyledAttributes.getFloat(index2, eVar.f1414e);
                        break;
                    case ErrorCodes.PRE_SERVICE_METHOD_INTERCEPT_ERROR /* 49 */:
                        i10 = indexCount2;
                        eVar.f1415f = typedArrayObtainStyledAttributes.getDimension(index2, eVar.f1415f);
                        break;
                    case ErrorCodes.AFTER_SERVICE_METHOD_INTERCEPT_ERROR /* 50 */:
                        i10 = indexCount2;
                        eVar.f1416g = typedArrayObtainStyledAttributes.getDimension(index2, eVar.f1416g);
                        break;
                    case ErrorCodes.SERVICE_RECYCLE_ERROR /* 51 */:
                        i10 = indexCount2;
                        eVar.f1417i = typedArrayObtainStyledAttributes.getDimension(index2, eVar.f1417i);
                        break;
                    case ErrorCodes.CALLER_PROTOCOL_VERSION_TOO_HIGH /* 52 */:
                        i10 = indexCount2;
                        eVar.f1418j = typedArrayObtainStyledAttributes.getDimension(index2, eVar.f1418j);
                        break;
                    case ErrorCodes.CALLBACK_RECYCLE_ERROR /* 53 */:
                        i10 = indexCount2;
                        eVar.f1419k = typedArrayObtainStyledAttributes.getDimension(index2, eVar.f1419k);
                        break;
                    case 54:
                        i10 = indexCount2;
                        bVar.X = typedArrayObtainStyledAttributes.getInt(index2, bVar.X);
                        break;
                    case 55:
                        i10 = indexCount2;
                        bVar.Y = typedArrayObtainStyledAttributes.getInt(index2, bVar.Y);
                        break;
                    case 56:
                        i10 = indexCount2;
                        bVar.Z = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, bVar.Z);
                        break;
                    case 57:
                        i10 = indexCount2;
                        bVar.f1361a0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, bVar.f1361a0);
                        break;
                    case 58:
                        i10 = indexCount2;
                        bVar.b0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, bVar.b0);
                        break;
                    case 59:
                        i10 = indexCount2;
                        bVar.c0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, bVar.c0);
                        break;
                    case 60:
                        i10 = indexCount2;
                        eVar.f1410a = typedArrayObtainStyledAttributes.getFloat(index2, eVar.f1410a);
                        break;
                    case 61:
                        i10 = indexCount2;
                        bVar.z = f(typedArrayObtainStyledAttributes, index2, bVar.z);
                        break;
                    case 62:
                        i10 = indexCount2;
                        bVar.A = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, bVar.A);
                        break;
                    case 63:
                        i10 = indexCount2;
                        bVar.B = typedArrayObtainStyledAttributes.getFloat(index2, bVar.B);
                        break;
                    case 64:
                        i10 = indexCount2;
                        c0007c.f1397a = f(typedArrayObtainStyledAttributes, index2, c0007c.f1397a);
                        break;
                    case 65:
                        i10 = indexCount2;
                        if (typedArrayObtainStyledAttributes.peekValue(index2).type == 3) {
                            typedArrayObtainStyledAttributes.getString(index2);
                            c0007c.getClass();
                            break;
                        } else {
                            String str3 = strArr[typedArrayObtainStyledAttributes.getInteger(index2, 0)];
                            c0007c.getClass();
                            break;
                        }
                    case 66:
                        i10 = indexCount2;
                        z3 = false;
                        typedArrayObtainStyledAttributes.getInt(index2, 0);
                        c0007c.getClass();
                        break;
                    case 67:
                        i10 = indexCount2;
                        c0007c.f1401e = typedArrayObtainStyledAttributes.getFloat(index2, c0007c.f1401e);
                        break;
                    case 68:
                        i10 = indexCount2;
                        dVar.f1408d = typedArrayObtainStyledAttributes.getFloat(index2, dVar.f1408d);
                        break;
                    case 69:
                        i10 = indexCount2;
                        bVar.f1365d0 = typedArrayObtainStyledAttributes.getFloat(index2, 1.0f);
                        break;
                    case 70:
                        i10 = indexCount2;
                        bVar.f1367e0 = typedArrayObtainStyledAttributes.getFloat(index2, 1.0f);
                        break;
                    case 71:
                        i10 = indexCount2;
                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                        break;
                    case 72:
                        i10 = indexCount2;
                        bVar.f1369f0 = typedArrayObtainStyledAttributes.getInt(index2, bVar.f1369f0);
                        break;
                    case 73:
                        i10 = indexCount2;
                        bVar.f1371g0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, bVar.f1371g0);
                        break;
                    case 74:
                        i10 = indexCount2;
                        bVar.f1376j0 = typedArrayObtainStyledAttributes.getString(index2);
                        break;
                    case 75:
                        i10 = indexCount2;
                        bVar.f1384n0 = typedArrayObtainStyledAttributes.getBoolean(index2, bVar.f1384n0);
                        break;
                    case 76:
                        i10 = indexCount2;
                        c0007c.f1399c = typedArrayObtainStyledAttributes.getInt(index2, c0007c.f1399c);
                        break;
                    case 77:
                        i10 = indexCount2;
                        bVar.f1378k0 = typedArrayObtainStyledAttributes.getString(index2);
                        break;
                    case 78:
                        i10 = indexCount2;
                        dVar.f1406b = typedArrayObtainStyledAttributes.getInt(index2, dVar.f1406b);
                        break;
                    case 79:
                        i10 = indexCount2;
                        c0007c.f1400d = typedArrayObtainStyledAttributes.getFloat(index2, c0007c.f1400d);
                        break;
                    case 80:
                        i10 = indexCount2;
                        bVar.f1380l0 = typedArrayObtainStyledAttributes.getBoolean(index2, bVar.f1380l0);
                        break;
                    case 81:
                        i10 = indexCount2;
                        bVar.f1382m0 = typedArrayObtainStyledAttributes.getBoolean(index2, bVar.f1382m0);
                        break;
                    case 82:
                        i10 = indexCount2;
                        c0007c.f1398b = typedArrayObtainStyledAttributes.getInteger(index2, c0007c.f1398b);
                        break;
                    case 83:
                        i10 = indexCount2;
                        eVar.h = f(typedArrayObtainStyledAttributes, index2, eVar.h);
                        break;
                    case 84:
                        i10 = indexCount2;
                        c0007c.f1403g = typedArrayObtainStyledAttributes.getInteger(index2, c0007c.f1403g);
                        break;
                    case 85:
                        i10 = indexCount2;
                        c0007c.f1402f = typedArrayObtainStyledAttributes.getFloat(index2, c0007c.f1402f);
                        break;
                    case 86:
                        i10 = indexCount2;
                        int i18 = typedArrayObtainStyledAttributes.peekValue(index2).type;
                        if (i18 == 1) {
                            c0007c.f1404i = typedArrayObtainStyledAttributes.getResourceId(index2, -1);
                        } else if (i18 == 3) {
                            String string2 = typedArrayObtainStyledAttributes.getString(index2);
                            c0007c.h = string2;
                            if (string2.indexOf("/") > 0) {
                                c0007c.f1404i = typedArrayObtainStyledAttributes.getResourceId(index2, -1);
                            }
                        } else {
                            typedArrayObtainStyledAttributes.getInteger(index2, c0007c.f1404i);
                        }
                        break;
                    case 87:
                        i10 = indexCount2;
                        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index2) + "   " + sparseIntArray.get(index2));
                        break;
                    case 88:
                    case 89:
                    case 90:
                    default:
                        i10 = indexCount2;
                        Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index2) + "   " + sparseIntArray.get(index2));
                        break;
                    case 91:
                        i10 = indexCount2;
                        bVar.f1388q = f(typedArrayObtainStyledAttributes, index2, bVar.f1388q);
                        break;
                    case 92:
                        i10 = indexCount2;
                        bVar.r = f(typedArrayObtainStyledAttributes, index2, bVar.r);
                        break;
                    case 93:
                        i10 = indexCount2;
                        bVar.L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, bVar.L);
                        break;
                    case 94:
                        i10 = indexCount2;
                        bVar.S = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, bVar.S);
                        break;
                    case 95:
                        i10 = indexCount2;
                        z3 = false;
                        g(bVar, typedArrayObtainStyledAttributes, index2, 0);
                        break;
                    case 96:
                        i10 = indexCount2;
                        g(bVar, typedArrayObtainStyledAttributes, index2, 1);
                        break;
                    case 97:
                        i10 = indexCount2;
                        bVar.f1386o0 = typedArrayObtainStyledAttributes.getInt(index2, bVar.f1386o0);
                        break;
                }
                i16++;
            }
            if (bVar.f1376j0 != null) {
                bVar.f1374i0 = null;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return aVar;
    }

    public static int f(TypedArray typedArray, int i10, int i11) {
        int resourceId = typedArray.getResourceId(i10, i11);
        return resourceId == -1 ? typedArray.getInt(i10, -1) : resourceId;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void g(java.lang.Object r7, android.content.res.TypedArray r8, int r9, int r10) {
        /*
            Method dump skipped, instructions count: 370
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.c.g(java.lang.Object, android.content.res.TypedArray, int, int):void");
    }

    public static void h(ConstraintLayout.a aVar, String str) {
        if (str != null) {
            int length = str.length();
            int iIndexOf = str.indexOf(44);
            int i10 = -1;
            if (iIndexOf > 0 && iIndexOf < length - 1) {
                String strSubstring = str.substring(0, iIndexOf);
                i10 = strSubstring.equalsIgnoreCase("W") ? 0 : strSubstring.equalsIgnoreCase("H") ? 1 : -1;
                i = iIndexOf + 1;
            }
            int iIndexOf2 = str.indexOf(58);
            try {
                if (iIndexOf2 < 0 || iIndexOf2 >= length - 1) {
                    String strSubstring2 = str.substring(i);
                    if (strSubstring2.length() > 0) {
                        Float.parseFloat(strSubstring2);
                    }
                } else {
                    String strSubstring3 = str.substring(i, iIndexOf2);
                    String strSubstring4 = str.substring(iIndexOf2 + 1);
                    if (strSubstring3.length() > 0 && strSubstring4.length() > 0) {
                        float f8 = Float.parseFloat(strSubstring3);
                        float f9 = Float.parseFloat(strSubstring4);
                        if (f8 > 0.0f && f9 > 0.0f) {
                            if (i10 == 1) {
                                Math.abs(f9 / f8);
                            } else {
                                Math.abs(f8 / f9);
                            }
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
        aVar.G = str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void a(ConstraintLayout constraintLayout) {
        HashSet hashSet;
        int i10;
        HashMap<String, ConstraintAttribute> map;
        String resourceEntryName;
        c cVar = this;
        int childCount = constraintLayout.getChildCount();
        HashMap<Integer, a> map2 = cVar.f1341c;
        HashSet hashSet2 = new HashSet(map2.keySet());
        int i11 = 0;
        while (i11 < childCount) {
            View childAt = constraintLayout.getChildAt(i11);
            int id2 = childAt.getId();
            if (!map2.containsKey(Integer.valueOf(id2))) {
                StringBuilder sb2 = new StringBuilder("id unknown ");
                try {
                    resourceEntryName = childAt.getContext().getResources().getResourceEntryName(childAt.getId());
                } catch (Exception unused) {
                    resourceEntryName = FailStage.UNKNOWN;
                }
                sb2.append(resourceEntryName);
                Log.w("ConstraintSet", sb2.toString());
            } else {
                if (cVar.f1340b && id2 == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (id2 != -1) {
                    if (map2.containsKey(Integer.valueOf(id2))) {
                        hashSet2.remove(Integer.valueOf(id2));
                        a aVar = map2.get(Integer.valueOf(id2));
                        if (aVar != null) {
                            d dVar = aVar.f1343b;
                            b bVar = aVar.f1345d;
                            e eVar = aVar.f1346e;
                            if (childAt instanceof androidx.constraintlayout.widget.a) {
                                bVar.f1372h0 = 1;
                                androidx.constraintlayout.widget.a aVar2 = (androidx.constraintlayout.widget.a) childAt;
                                aVar2.setId(id2);
                                aVar2.setType(bVar.f1369f0);
                                aVar2.setMargin(bVar.f1371g0);
                                aVar2.setAllowsGoneWidget(bVar.f1384n0);
                                int[] iArr = bVar.f1374i0;
                                if (iArr != null) {
                                    aVar2.setReferencedIds(iArr);
                                } else {
                                    String str = bVar.f1376j0;
                                    if (str != null) {
                                        int[] iArrC = c(aVar2, str);
                                        bVar.f1374i0 = iArrC;
                                        aVar2.setReferencedIds(iArrC);
                                    }
                                }
                            }
                            ConstraintLayout.a aVar3 = (ConstraintLayout.a) childAt.getLayoutParams();
                            aVar3.a();
                            aVar.a(aVar3);
                            HashMap<String, ConstraintAttribute> map3 = aVar.f1347f;
                            Class<?> cls = childAt.getClass();
                            for (String str2 : map3.keySet()) {
                                ConstraintAttribute constraintAttribute = map3.get(str2);
                                HashSet hashSet3 = hashSet2;
                                String strK = !constraintAttribute.f1252a ? ai.onnxruntime.a.k("set", str2) : str2;
                                int i12 = i11;
                                try {
                                    int iOrdinal = constraintAttribute.f1254c.ordinal();
                                    Class cls2 = Float.TYPE;
                                    Class cls3 = Integer.TYPE;
                                    switch (iOrdinal) {
                                        case 0:
                                            map = map3;
                                            cls.getMethod(strK, cls3).invoke(childAt, Integer.valueOf(constraintAttribute.f1255d));
                                            break;
                                        case 1:
                                            map = map3;
                                            cls.getMethod(strK, cls2).invoke(childAt, Float.valueOf(constraintAttribute.f1256e));
                                            break;
                                        case 2:
                                            map = map3;
                                            cls.getMethod(strK, cls3).invoke(childAt, Integer.valueOf(constraintAttribute.h));
                                            break;
                                        case 3:
                                            Method method = cls.getMethod(strK, Drawable.class);
                                            map = map3;
                                            try {
                                                ColorDrawable colorDrawable = new ColorDrawable();
                                                colorDrawable.setColor(constraintAttribute.h);
                                                method.invoke(childAt, colorDrawable);
                                            } catch (IllegalAccessException e10) {
                                                e = e10;
                                                StringBuilder sbQ = a0.a.q(" Custom Attribute \"", str2, "\" not found on ");
                                                sbQ.append(cls.getName());
                                                Log.e("TransitionLayout", sbQ.toString(), e);
                                                hashSet2 = hashSet3;
                                                i11 = i12;
                                                map3 = map;
                                            } catch (NoSuchMethodException e11) {
                                                e = e11;
                                                Log.e("TransitionLayout", cls.getName() + " must have a method " + strK, e);
                                                hashSet2 = hashSet3;
                                                i11 = i12;
                                                map3 = map;
                                            } catch (InvocationTargetException e12) {
                                                e = e12;
                                                StringBuilder sbQ2 = a0.a.q(" Custom Attribute \"", str2, "\" not found on ");
                                                sbQ2.append(cls.getName());
                                                Log.e("TransitionLayout", sbQ2.toString(), e);
                                                hashSet2 = hashSet3;
                                                i11 = i12;
                                                map3 = map;
                                            }
                                        case 4:
                                            cls.getMethod(strK, CharSequence.class).invoke(childAt, constraintAttribute.f1257f);
                                            map = map3;
                                            break;
                                        case 5:
                                            cls.getMethod(strK, Boolean.TYPE).invoke(childAt, Boolean.valueOf(constraintAttribute.f1258g));
                                            map = map3;
                                            break;
                                        case 6:
                                            cls.getMethod(strK, cls2).invoke(childAt, Float.valueOf(constraintAttribute.f1256e));
                                            map = map3;
                                            break;
                                        case 7:
                                            cls.getMethod(strK, cls3).invoke(childAt, Integer.valueOf(constraintAttribute.f1255d));
                                            map = map3;
                                            break;
                                        default:
                                            map = map3;
                                            break;
                                    }
                                } catch (IllegalAccessException e13) {
                                    e = e13;
                                    map = map3;
                                } catch (NoSuchMethodException e14) {
                                    e = e14;
                                    map = map3;
                                } catch (InvocationTargetException e15) {
                                    e = e15;
                                    map = map3;
                                }
                                hashSet2 = hashSet3;
                                i11 = i12;
                                map3 = map;
                            }
                            hashSet = hashSet2;
                            i10 = i11;
                            childAt.setLayoutParams(aVar3);
                            if (dVar.f1406b == 0) {
                                childAt.setVisibility(dVar.f1405a);
                            }
                            childAt.setAlpha(dVar.f1407c);
                            childAt.setRotation(eVar.f1410a);
                            childAt.setRotationX(eVar.f1411b);
                            childAt.setRotationY(eVar.f1412c);
                            childAt.setScaleX(eVar.f1413d);
                            childAt.setScaleY(eVar.f1414e);
                            if (eVar.h != -1) {
                                if (((View) childAt.getParent()).findViewById(eVar.h) != null) {
                                    float bottom = (r0.getBottom() + r0.getTop()) / 2.0f;
                                    float right = (r0.getRight() + r0.getLeft()) / 2.0f;
                                    if (childAt.getRight() - childAt.getLeft() > 0 && childAt.getBottom() - childAt.getTop() > 0) {
                                        childAt.setPivotX(right - childAt.getLeft());
                                        childAt.setPivotY(bottom - childAt.getTop());
                                    }
                                }
                            } else {
                                if (!Float.isNaN(eVar.f1415f)) {
                                    childAt.setPivotX(eVar.f1415f);
                                }
                                if (!Float.isNaN(eVar.f1416g)) {
                                    childAt.setPivotY(eVar.f1416g);
                                }
                            }
                            childAt.setTranslationX(eVar.f1417i);
                            childAt.setTranslationY(eVar.f1418j);
                            childAt.setTranslationZ(eVar.f1419k);
                            if (eVar.f1420l) {
                                childAt.setElevation(eVar.f1421m);
                            }
                        }
                    } else {
                        hashSet = hashSet2;
                        i10 = i11;
                        Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id2);
                    }
                }
                i11 = i10 + 1;
                cVar = this;
                hashSet2 = hashSet;
            }
            hashSet = hashSet2;
            i10 = i11;
            i11 = i10 + 1;
            cVar = this;
            hashSet2 = hashSet;
        }
        Iterator it = hashSet2.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            a aVar4 = map2.get(num);
            if (aVar4 != null) {
                b bVar2 = aVar4.f1345d;
                if (bVar2.f1372h0 == 1) {
                    Context context = constraintLayout.getContext();
                    androidx.constraintlayout.widget.a aVar5 = new androidx.constraintlayout.widget.a(context);
                    aVar5.f1329a = new int[32];
                    aVar5.f1334j = null;
                    aVar5.f1335k = new HashMap<>();
                    aVar5.f1331c = context;
                    aVar5.g(null);
                    aVar5.setVisibility(8);
                    aVar5.setId(num.intValue());
                    int[] iArr2 = bVar2.f1374i0;
                    if (iArr2 != null) {
                        aVar5.setReferencedIds(iArr2);
                    } else {
                        String str3 = bVar2.f1376j0;
                        if (str3 != null) {
                            int[] iArrC2 = c(aVar5, str3);
                            bVar2.f1374i0 = iArrC2;
                            aVar5.setReferencedIds(iArrC2);
                        }
                    }
                    aVar5.setType(bVar2.f1369f0);
                    aVar5.setMargin(bVar2.f1371g0);
                    ConstraintLayout.a aVar6 = new ConstraintLayout.a();
                    aVar5.i();
                    aVar4.a(aVar6);
                    constraintLayout.addView(aVar5, aVar6);
                }
                if (bVar2.f1360a) {
                    View eVar2 = new androidx.constraintlayout.widget.e(constraintLayout.getContext());
                    eVar2.setId(num.intValue());
                    ConstraintLayout.a aVar7 = new ConstraintLayout.a();
                    aVar4.a(aVar7);
                    constraintLayout.addView(eVar2, aVar7);
                }
            }
        }
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt2 = constraintLayout.getChildAt(i13);
            if (childAt2 instanceof androidx.constraintlayout.widget.b) {
                ((androidx.constraintlayout.widget.b) childAt2).e(constraintLayout);
            }
        }
    }

    public final void b(ConstraintLayout constraintLayout) {
        int i10;
        HashMap<Integer, a> map;
        int i11;
        c cVar = this;
        int childCount = constraintLayout.getChildCount();
        HashMap<Integer, a> map2 = cVar.f1341c;
        map2.clear();
        int i12 = 0;
        while (i12 < childCount) {
            View childAt = constraintLayout.getChildAt(i12);
            ConstraintLayout.a aVar = (ConstraintLayout.a) childAt.getLayoutParams();
            int id2 = childAt.getId();
            if (cVar.f1340b && id2 == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!map2.containsKey(Integer.valueOf(id2))) {
                map2.put(Integer.valueOf(id2), new a());
            }
            a aVar2 = map2.get(Integer.valueOf(id2));
            if (aVar2 == null) {
                i10 = childCount;
                map = map2;
                i11 = i12;
            } else {
                d dVar = aVar2.f1343b;
                b bVar = aVar2.f1345d;
                e eVar = aVar2.f1346e;
                i10 = childCount;
                HashMap<String, ConstraintAttribute> map3 = new HashMap<>();
                map = map2;
                Class<?> cls = childAt.getClass();
                i11 = i12;
                HashMap<String, ConstraintAttribute> map4 = cVar.f1339a;
                for (String str : map4.keySet()) {
                    ConstraintAttribute constraintAttribute = map4.get(str);
                    HashMap<String, ConstraintAttribute> map5 = map4;
                    try {
                        if (str.equals("BackgroundColor")) {
                            map3.put(str, new ConstraintAttribute(constraintAttribute, Integer.valueOf(((ColorDrawable) childAt.getBackground()).getColor())));
                        } else {
                            map3.put(str, new ConstraintAttribute(constraintAttribute, cls.getMethod("getMap" + str, null).invoke(childAt, null)));
                        }
                    } catch (IllegalAccessException e10) {
                        StringBuilder sbQ = a0.a.q(" Custom Attribute \"", str, "\" not found on ");
                        sbQ.append(cls.getName());
                        Log.e("TransitionLayout", sbQ.toString(), e10);
                    } catch (NoSuchMethodException e11) {
                        Log.e("TransitionLayout", cls.getName() + " must have a method " + str, e11);
                    } catch (InvocationTargetException e12) {
                        StringBuilder sbQ2 = a0.a.q(" Custom Attribute \"", str, "\" not found on ");
                        sbQ2.append(cls.getName());
                        Log.e("TransitionLayout", sbQ2.toString(), e12);
                    }
                    map4 = map5;
                }
                aVar2.f1347f = map3;
                aVar2.b(id2, aVar);
                dVar.f1405a = childAt.getVisibility();
                dVar.f1407c = childAt.getAlpha();
                eVar.f1410a = childAt.getRotation();
                eVar.f1411b = childAt.getRotationX();
                eVar.f1412c = childAt.getRotationY();
                eVar.f1413d = childAt.getScaleX();
                eVar.f1414e = childAt.getScaleY();
                float pivotX = childAt.getPivotX();
                float pivotY = childAt.getPivotY();
                if (pivotX != 0.0d || pivotY != 0.0d) {
                    eVar.f1415f = pivotX;
                    eVar.f1416g = pivotY;
                }
                eVar.f1417i = childAt.getTranslationX();
                eVar.f1418j = childAt.getTranslationY();
                eVar.f1419k = childAt.getTranslationZ();
                if (eVar.f1420l) {
                    eVar.f1421m = childAt.getElevation();
                }
                if (childAt instanceof androidx.constraintlayout.widget.a) {
                    androidx.constraintlayout.widget.a aVar3 = (androidx.constraintlayout.widget.a) childAt;
                    bVar.f1384n0 = aVar3.getAllowsGoneWidget();
                    bVar.f1374i0 = aVar3.getReferencedIds();
                    bVar.f1369f0 = aVar3.getType();
                    bVar.f1371g0 = aVar3.getMargin();
                }
            }
            i12 = i11 + 1;
            cVar = this;
            childCount = i10;
            map2 = map;
        }
    }

    public final void e(int i10, Context context) {
        XmlResourceParser xml = context.getResources().getXml(i10);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 2) {
                    String name = xml.getName();
                    a aVarD = d(context, Xml.asAttributeSet(xml), false);
                    if (name.equalsIgnoreCase("Guideline")) {
                        aVarD.f1345d.f1360a = true;
                    }
                    this.f1341c.put(Integer.valueOf(aVarD.f1342a), aVarD);
                }
            }
        } catch (IOException e10) {
            Log.e("ConstraintSet", "Error parsing resource: " + i10, e10);
        } catch (XmlPullParserException e11) {
            Log.e("ConstraintSet", "Error parsing resource: " + i10, e11);
        }
    }
}

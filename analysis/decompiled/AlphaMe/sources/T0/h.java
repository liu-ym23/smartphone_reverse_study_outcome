package T0;

import android.content.Context;
import com.stepos.alphame.utils.Property;
import g3.C0580d;
import java.util.Vector;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final Context f1826a;

    /* renamed from: b, reason: collision with root package name */
    public final C0580d f1827b;

    /* renamed from: c, reason: collision with root package name */
    public final U0.b f1828c;

    /* renamed from: d, reason: collision with root package name */
    public String f1829d;

    /* renamed from: e, reason: collision with root package name */
    public String f1830e;

    /* renamed from: f, reason: collision with root package name */
    public int f1831f;

    /* renamed from: g, reason: collision with root package name */
    public String f1832g;

    /* renamed from: h, reason: collision with root package name */
    public String[] f1833h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f1834i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f1835j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f1836k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f1837l;

    /* renamed from: m, reason: collision with root package name */
    public int f1838m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f1839n;

    public h(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f1826a = context;
        this.f1827b = new C0580d(false);
        U0.b bVar = new U0.b();
        bVar.f1892a = -1L;
        bVar.f1893b = false;
        bVar.f1894c = 1;
        bVar.f1895d = 4;
        bVar.f1896e = "LITE_POWER_HIGH";
        bVar.f1897f = null;
        bVar.f1898g = Property.DEFAULT_FLOAT_VALUE;
        bVar.f1899h = new Vector();
        bVar.f1900i = 960;
        bVar.f1901j = null;
        bVar.f1902k = null;
        bVar.f1903l = false;
        bVar.f1904m = "";
        bVar.f1906o = "";
        bVar.f1907p = "";
        bVar.f1908q = "";
        bVar.f1909r = Boolean.FALSE;
        this.f1828c = bVar;
        this.f1829d = "models/ocr_v2_for_cpu";
        this.f1830e = "labels/ppocr_keys_v1.txt";
        this.f1831f = 4;
        this.f1832g = "LITE_POWER_HIGH";
        this.f1833h = new String[0];
        this.f1834i = true;
        this.f1835j = true;
        this.f1836k = true;
        this.f1838m = 960;
    }

    public static final void a(h hVar, i iVar) {
        hVar.getClass();
        hVar.f1829d = iVar.f1840a;
        hVar.f1830e = iVar.f1841b;
        hVar.f1831f = iVar.f1842c;
        hVar.f1832g = iVar.f1843d.name();
        float f4 = iVar.f1844e;
        hVar.getClass();
        hVar.f1833h = new String[]{iVar.f1846g, iVar.f1847h, iVar.f1848i};
        hVar.f1838m = iVar.f1845f;
        hVar.f1835j = iVar.f1849j;
        hVar.f1834i = iVar.f1850k;
        hVar.f1836k = iVar.f1851l;
        hVar.f1837l = iVar.f1852m;
        hVar.f1839n = iVar.f1853n;
    }
}

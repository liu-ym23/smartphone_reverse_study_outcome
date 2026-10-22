package t;

import java.text.DecimalFormat;
import java.util.ArrayList;

/* renamed from: t.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1104d {

    /* renamed from: a, reason: collision with root package name */
    private a f22293a;

    /* renamed from: b, reason: collision with root package name */
    private String f22294b;

    /* renamed from: c, reason: collision with root package name */
    private int f22295c = 0;

    /* renamed from: d, reason: collision with root package name */
    private String f22296d = null;

    /* renamed from: e, reason: collision with root package name */
    public int f22297e = 0;

    /* renamed from: f, reason: collision with root package name */
    ArrayList<b> f22298f = new ArrayList<>();

    /* renamed from: t.d$a */
    static class a {
        public double a(float f5) {
            throw null;
        }
    }

    /* renamed from: t.d$b */
    static class b {

        /* renamed from: a, reason: collision with root package name */
        int f22299a;

        /* renamed from: b, reason: collision with root package name */
        float f22300b;
    }

    public float a(float f5) {
        return (float) this.f22293a.a(f5);
    }

    public String toString() {
        String str = this.f22294b;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        ArrayList<b> arrayList = this.f22298f;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            b bVar = arrayList.get(i5);
            i5++;
            str = str + "[" + bVar.f22299a + " , " + decimalFormat.format(r4.f22300b) + "] ";
        }
        return str;
    }
}

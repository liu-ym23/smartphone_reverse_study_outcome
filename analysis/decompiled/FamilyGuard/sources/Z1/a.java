package Z1;

import f2.C0711p;

/* loaded from: classes.dex */
public class a implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public long f6629a;

    /* renamed from: b, reason: collision with root package name */
    public long f6630b;

    /* renamed from: c, reason: collision with root package name */
    public int f6631c;

    public a(long j5, long j6, int i5) {
        this.f6629a = j5;
        this.f6630b = j6;
        this.f6631c = i5;
    }

    public static String e(int i5) {
        return i5 != -1 ? i5 != 0 ? i5 != 1 ? i5 != 2 ? "休息日到工作日" : "工作日到休息日" : "休息日" : "工作日" : "未定义";
    }

    public boolean b(long j5) {
        if (g()) {
            return true;
        }
        if (d()) {
            return (j5 >= 0 && j5 <= this.f6630b - 86400000) || (j5 >= this.f6629a && j5 <= 86400000);
        }
        return j5 <= this.f6630b && j5 >= this.f6629a;
    }

    public Object clone() {
        try {
            a aVar = (a) super.clone();
            aVar.f6629a = this.f6629a;
            aVar.f6630b = this.f6630b;
            aVar.f6631c = this.f6631c;
            return aVar;
        } catch (CloneNotSupportedException e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public boolean d() {
        return this.f6629a < 86400000 && this.f6630b > 86400000;
    }

    public boolean g() {
        return this.f6630b - this.f6629a >= 86400000;
    }

    public String toString() {
        return "Period{" + C0711p.F(this.f6629a) + "~" + C0711p.F(this.f6630b) + ", meregedWeekDayType =" + e(this.f6631c) + '}';
    }
}

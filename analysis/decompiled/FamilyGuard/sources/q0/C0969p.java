package q0;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import o0.C0888a;
import o0.InterfaceC0890c;
import p0.AbstractC0918e;

/* renamed from: q0.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0969p extends AbstractC0918e implements U, p0.t, InterfaceC0973u {

    /* renamed from: b, reason: collision with root package name */
    public static final C0969p f19871b = new C0969p();

    /* renamed from: a, reason: collision with root package name */
    private DatatypeFactory f19872a;

    @Override // q0.U
    public void b(C0946I c0946i, Object obj, Object obj2, Type type, int i5) throws IOException {
        char[] charArray;
        e0 e0Var = c0946i.f19676k;
        if (obj == null) {
            e0Var.Y();
            return;
        }
        Calendar gregorianCalendar = obj instanceof XMLGregorianCalendar ? ((XMLGregorianCalendar) obj).toGregorianCalendar() : (Calendar) obj;
        if (!e0Var.v(f0.UseISO8601DateFormat)) {
            c0946i.G(gregorianCalendar.getTime());
            return;
        }
        char c6 = e0Var.v(f0.UseSingleQuotes) ? '\'' : '\"';
        e0Var.append(c6);
        int i6 = gregorianCalendar.get(1);
        int i7 = gregorianCalendar.get(2) + 1;
        int i8 = gregorianCalendar.get(5);
        int i9 = gregorianCalendar.get(11);
        int i10 = gregorianCalendar.get(12);
        int i11 = gregorianCalendar.get(13);
        int i12 = gregorianCalendar.get(14);
        if (i12 != 0) {
            charArray = "0000-00-00T00:00:00.000".toCharArray();
            u0.g.f(i12, 23, charArray);
            u0.g.f(i11, 19, charArray);
            u0.g.f(i10, 16, charArray);
            u0.g.f(i9, 13, charArray);
            u0.g.f(i8, 10, charArray);
            u0.g.f(i7, 7, charArray);
            u0.g.f(i6, 4, charArray);
        } else if (i11 == 0 && i10 == 0 && i9 == 0) {
            charArray = "0000-00-00".toCharArray();
            u0.g.f(i8, 10, charArray);
            u0.g.f(i7, 7, charArray);
            u0.g.f(i6, 4, charArray);
        } else {
            charArray = "0000-00-00T00:00:00".toCharArray();
            u0.g.f(i11, 19, charArray);
            u0.g.f(i10, 16, charArray);
            u0.g.f(i9, 13, charArray);
            u0.g.f(i8, 10, charArray);
            u0.g.f(i7, 7, charArray);
            u0.g.f(i6, 4, charArray);
        }
        e0Var.write(charArray);
        float offset = gregorianCalendar.getTimeZone().getOffset(gregorianCalendar.getTimeInMillis()) / 3600000.0f;
        int i13 = (int) offset;
        if (i13 == 0.0d) {
            e0Var.write(90);
        } else {
            if (i13 > 9) {
                e0Var.write(43);
                e0Var.V(i13);
            } else if (i13 > 0) {
                e0Var.write(43);
                e0Var.write(48);
                e0Var.V(i13);
            } else if (i13 < -9) {
                e0Var.write(45);
                e0Var.V(i13);
            } else if (i13 < 0) {
                e0Var.write(45);
                e0Var.write(48);
                e0Var.V(-i13);
            }
            e0Var.write(58);
            e0Var.append(String.format("%02d", Integer.valueOf((int) ((offset - i13) * 60.0f))));
        }
        e0Var.append(c6);
    }

    @Override // q0.InterfaceC0973u
    public void c(C0946I c0946i, Object obj, C0963j c0963j) {
        e0 e0Var = c0946i.f19676k;
        String strB = c0963j.b();
        Calendar calendar = (Calendar) obj;
        if (strB.equals("unixtime")) {
            e0Var.V((int) (calendar.getTimeInMillis() / 1000));
            return;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(strB);
        simpleDateFormat.setTimeZone(c0946i.f19684s);
        e0Var.h0(simpleDateFormat.format(calendar.getTime()));
    }

    @Override // p0.t
    public int d() {
        return 2;
    }

    @Override // p0.AbstractC0918e, p0.t
    public <T> T e(C0888a c0888a, Type type, Object obj) {
        return (T) f(c0888a, type, obj, null, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v4, types: [T, java.util.Calendar] */
    @Override // p0.AbstractC0918e
    public <T> T f(C0888a c0888a, Type type, Object obj, String str, int i5) {
        T t5 = (T) C0975w.f19876a.f(c0888a, type, obj, str, i5);
        if (t5 instanceof Calendar) {
            return t5;
        }
        Date date = (Date) t5;
        if (date == null) {
            return null;
        }
        InterfaceC0890c interfaceC0890c = c0888a.f18948f;
        ?? r8 = (T) Calendar.getInstance(interfaceC0890c.O(), interfaceC0890c.s0());
        r8.setTime(date);
        return type == XMLGregorianCalendar.class ? (T) g((GregorianCalendar) r8) : r8;
    }

    public XMLGregorianCalendar g(Calendar calendar) {
        if (this.f19872a == null) {
            try {
                this.f19872a = DatatypeFactory.newInstance();
            } catch (DatatypeConfigurationException e6) {
                throw new IllegalStateException("Could not obtain an instance of DatatypeFactory.", e6);
            }
        }
        return this.f19872a.newXMLGregorianCalendar((GregorianCalendar) calendar);
    }
}

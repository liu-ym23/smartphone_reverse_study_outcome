package com.stepos.common.widget;

import androidx.appcompat.app.C0186l;
import com.stepos.alphame.awareness.AwarenessDataItem;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: classes.dex */
public final class B {

    /* renamed from: a, reason: collision with root package name */
    public int f11443a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f11444b = 9;

    /* renamed from: c, reason: collision with root package name */
    public int f11445c = 10;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ScrollTextView f11446d;

    public B(ScrollTextView scrollTextView) {
        this.f11446d = scrollTextView;
    }

    public final String a(int i4) {
        x xVar;
        String str;
        if (i4 < 0 || i4 >= this.f11445c || (xVar = this.f11446d.f11765r) == null) {
            return null;
        }
        C0186l c0186l = (C0186l) xVar;
        switch (c0186l.f2659a) {
            case 3:
                int i5 = c0186l.f2660b;
                if (i5 == 1) {
                    return String.format(Locale.getDefault(), "%d", Integer.valueOf(i4 + ((DatePicker) c0186l.f2661c).f11546l));
                }
                if (i5 == 2) {
                    DatePicker datePicker = (DatePicker) c0186l.f2661c;
                    if (datePicker.f11542h) {
                        return datePicker.f(i4);
                    }
                    Calendar calendar = datePicker.f11548n;
                    if (calendar != null) {
                        int i6 = calendar.get(1);
                        DatePicker datePicker2 = (DatePicker) c0186l.f2661c;
                        if (i6 == datePicker2.f11545k) {
                            i4 += datePicker2.f11548n.get(2);
                        }
                    }
                    String[] strArr = ((DatePicker) c0186l.f2661c).f11552r;
                    if (i4 < strArr.length) {
                        return strArr[i4];
                    }
                    return null;
                }
                if (i5 != 3) {
                    return null;
                }
                DatePicker datePicker3 = (DatePicker) c0186l.f2661c;
                if (datePicker3.f11542h) {
                    String[] strArr2 = datePicker3.f11531L;
                    if (i4 > strArr2.length - 1) {
                        return null;
                    }
                    return strArr2[i4];
                }
                Calendar calendar2 = datePicker3.f11548n;
                if (calendar2 != null) {
                    int i7 = calendar2.get(1);
                    DatePicker datePicker4 = (DatePicker) c0186l.f2661c;
                    if (i7 == datePicker4.f11545k) {
                        int i8 = datePicker4.f11548n.get(2);
                        DatePicker datePicker5 = (DatePicker) c0186l.f2661c;
                        if (i8 == datePicker5.f11544j) {
                            return datePicker5.f11532M[datePicker5.f11548n.get(5) + i4];
                        }
                    }
                }
                return ((DatePicker) c0186l.f2661c).f11532M[i4 + 1];
            case 4:
                int i9 = c0186l.f2660b;
                if (i9 == 4) {
                    return ((DayTimeDatePicker) c0186l.f2661c).f11592q[i4];
                }
                if (i9 == 5) {
                    return ((DayTimeDatePicker) c0186l.f2661c).f11593r[i4];
                }
                if (i9 != 6) {
                    return null;
                }
                DayTimeDatePicker dayTimeDatePicker = (DayTimeDatePicker) c0186l.f2661c;
                boolean z4 = dayTimeDatePicker.f11582g;
                String str2 = AwarenessDataItem.PERMISSION_SPLITTER;
                if (z4) {
                    int i10 = dayTimeDatePicker.f11585j;
                    int iA = DayTimeDatePicker.a(dayTimeDatePicker, i4);
                    if (iA > ((DayTimeDatePicker) c0186l.f2661c).e(i10) - 1) {
                        iA -= ((DayTimeDatePicker) c0186l.f2661c).e(i10);
                        i10++;
                    } else if (iA < 0) {
                        iA += ((DayTimeDatePicker) c0186l.f2661c).e(i10 - 1);
                        i10--;
                    }
                    int length = iA + 1;
                    String[] strArr3 = ((DayTimeDatePicker) c0186l.f2661c).f11568D;
                    int iC = m2.d.c(i10);
                    if (iC == 0 || length <= iC) {
                        if (iA >= strArr3.length) {
                            length = strArr3.length - 1;
                        }
                        str = strArr3[length - 1];
                    } else {
                        str = strArr3[iA - 1];
                    }
                    int iB = DayTimeDatePicker.b((DayTimeDatePicker) c0186l.f2661c, i4);
                    StringBuilder sbS = B0.g.s(str);
                    if (((DayTimeDatePicker) c0186l.f2661c).f()) {
                        str2 = ((DayTimeDatePicker) c0186l.f2661c).f11574J;
                    }
                    sbS.append(str2);
                    int i11 = iB - 1;
                    String[] strArr4 = ((DayTimeDatePicker) c0186l.f2661c).f11569E;
                    sbS.append(i11 <= strArr4.length - 1 ? strArr4[i11] : null);
                    return sbS.toString();
                }
                int iA2 = DayTimeDatePicker.a(dayTimeDatePicker, i4);
                DayTimeDatePicker dayTimeDatePicker2 = (DayTimeDatePicker) c0186l.f2661c;
                if (iA2 > dayTimeDatePicker2.e(dayTimeDatePicker2.f11585j) - 1) {
                    DayTimeDatePicker dayTimeDatePicker3 = (DayTimeDatePicker) c0186l.f2661c;
                    iA2 -= dayTimeDatePicker3.e(dayTimeDatePicker3.f11585j);
                } else if (iA2 < 0) {
                    DayTimeDatePicker dayTimeDatePicker4 = (DayTimeDatePicker) c0186l.f2661c;
                    iA2 += dayTimeDatePicker4.e(dayTimeDatePicker4.f11585j);
                }
                if (!((DayTimeDatePicker) c0186l.f2661c).f()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(((DayTimeDatePicker) c0186l.f2661c).f11568D[iA2]);
                    sb.append(AwarenessDataItem.PERMISSION_SPLITTER);
                    DayTimeDatePicker dayTimeDatePicker5 = (DayTimeDatePicker) c0186l.f2661c;
                    sb.append(dayTimeDatePicker5.f11573I[DayTimeDatePicker.b(dayTimeDatePicker5, i4)]);
                    return sb.toString();
                }
                int i12 = iA2 + 1;
                Calendar calendar3 = ((DayTimeDatePicker) c0186l.f2661c).f11590o;
                if (calendar3 != null) {
                    int i13 = calendar3.get(1);
                    DayTimeDatePicker dayTimeDatePicker6 = (DayTimeDatePicker) c0186l.f2661c;
                    if (i13 == dayTimeDatePicker6.f11585j && dayTimeDatePicker6.f11590o.get(2) == ((DayTimeDatePicker) c0186l.f2661c).f11584i) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(i12);
                        sb2.append(((DayTimeDatePicker) c0186l.f2661c).f11574J);
                        DayTimeDatePicker dayTimeDatePicker7 = (DayTimeDatePicker) c0186l.f2661c;
                        sb2.append(dayTimeDatePicker7.f11573I[((DayTimeDatePicker) c0186l.f2661c).f11590o.get(5) + (DayTimeDatePicker.b(dayTimeDatePicker7, i4) - 1)]);
                        sb2.append(((DayTimeDatePicker) c0186l.f2661c).f11575K);
                        return sb2.toString();
                    }
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append(i12);
                sb3.append(((DayTimeDatePicker) c0186l.f2661c).f11574J);
                DayTimeDatePicker dayTimeDatePicker8 = (DayTimeDatePicker) c0186l.f2661c;
                sb3.append(dayTimeDatePicker8.f11573I[DayTimeDatePicker.b(dayTimeDatePicker8, i4)]);
                sb3.append(((DayTimeDatePicker) c0186l.f2661c).f11575K);
                return sb3.toString();
            default:
                int i14 = c0186l.f2660b;
                if (i14 == 1) {
                    if (((TimePicker) c0186l.f2661c).f11869c.booleanValue()) {
                        return ((TimePicker) c0186l.f2661c).f11884r[i4];
                    }
                    if (i4 == 0) {
                        i4 = 12;
                    }
                    return ((TimePicker) c0186l.f2661c).f11884r[i4];
                }
                if (i14 == 2) {
                    return ((TimePicker) c0186l.f2661c).f11885s[i4];
                }
                if (i14 != 3) {
                    return null;
                }
                if (i4 == 0) {
                    return ((TimePicker) c0186l.f2661c).f11874h;
                }
                if (i4 == 1) {
                    return ((TimePicker) c0186l.f2661c).f11875i;
                }
                return null;
        }
    }
}

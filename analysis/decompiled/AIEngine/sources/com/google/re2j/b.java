package com.google.re2j;

import com.google.re2j.Regexp;
import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {
    public static Regexp a(Regexp regexp) {
        ArrayList arrayList;
        if (regexp == null) {
            return null;
        }
        int i10 = 0;
        switch (regexp.f5495a.ordinal()) {
            case 12:
            case 17:
            case 18:
                Regexp regexp2 = regexp;
                int i11 = 0;
                while (true) {
                    Regexp[] regexpArr = regexp.f5497c;
                    if (i11 >= regexpArr.length) {
                        return regexp2;
                    }
                    Regexp regexp3 = regexpArr[i11];
                    Regexp regexpA = a(regexp3);
                    if (regexp2 == regexp && regexpA != regexp3) {
                        regexp2 = new Regexp();
                        regexp2.f5495a = regexp.f5495a;
                        regexp2.f5496b = regexp.f5496b;
                        regexp2.f5497c = regexp.f5497c;
                        regexp2.f5499e = regexp.f5499e;
                        regexp2.f5500f = regexp.f5500f;
                        regexp2.f5501g = regexp.f5501g;
                        regexp2.h = regexp.h;
                        regexp2.f5502i = regexp.f5502i;
                        regexp2.f5498d = null;
                        Regexp[] regexpArr2 = regexp.f5497c;
                        regexp2.f5497c = Parser.v(regexpArr2, 0, regexpArr2.length);
                    }
                    if (regexp2 != regexp) {
                        regexp2.f5497c[i11] = regexpA;
                    }
                    i11++;
                }
            case 13:
            case 14:
            case 15:
                return b(regexp.f5495a, regexp.f5496b, a(regexp.f5497c[0]), regexp);
            case 16:
                if (regexp.f5499e == 0 && regexp.f5500f == 0) {
                    return new Regexp(Regexp.Op.f5504b);
                }
                Regexp regexpA2 = a(regexp.f5497c[0]);
                int i12 = regexp.f5500f;
                Regexp.Op op = Regexp.Op.f5518u;
                if (i12 == -1) {
                    int i13 = regexp.f5499e;
                    if (i13 == 0) {
                        return b(Regexp.Op.f5515q, regexp.f5496b, regexpA2, null);
                    }
                    Regexp.Op op2 = Regexp.Op.r;
                    if (i13 == 1) {
                        return b(op2, regexp.f5496b, regexpA2, null);
                    }
                    Regexp regexp4 = new Regexp(op);
                    ArrayList arrayList2 = new ArrayList();
                    while (i10 < regexp.f5499e - 1) {
                        arrayList2.add(regexpA2);
                        i10++;
                    }
                    arrayList2.add(b(op2, regexp.f5496b, regexpA2, null));
                    regexp4.f5497c = (Regexp[]) arrayList2.toArray(new Regexp[arrayList2.size()]);
                    return regexp4;
                }
                int i14 = regexp.f5499e;
                if (i14 == 1 && i12 == 1) {
                    return regexpA2;
                }
                if (i14 > 0) {
                    arrayList = new ArrayList();
                    while (i10 < regexp.f5499e) {
                        arrayList.add(regexpA2);
                        i10++;
                    }
                } else {
                    arrayList = null;
                }
                if (regexp.f5500f > regexp.f5499e) {
                    int i15 = regexp.f5496b;
                    Regexp.Op op3 = Regexp.Op.f5516s;
                    Regexp regexpB = b(op3, i15, regexpA2, null);
                    for (int i16 = regexp.f5499e + 1; i16 < regexp.f5500f; i16++) {
                        Regexp regexp5 = new Regexp(op);
                        regexp5.f5497c = new Regexp[]{regexpA2, regexpB};
                        regexpB = b(op3, regexp.f5496b, regexp5, null);
                    }
                    if (arrayList == null) {
                        return regexpB;
                    }
                    arrayList.add(regexpB);
                }
                if (arrayList == null) {
                    return new Regexp(Regexp.Op.f5503a);
                }
                Regexp regexp6 = new Regexp(op);
                regexp6.f5497c = (Regexp[]) arrayList.toArray(new Regexp[arrayList.size()]);
                return regexp6;
            default:
                return regexp;
        }
    }

    public static Regexp b(Regexp.Op op, int i10, Regexp regexp, Regexp regexp2) {
        Regexp.Op op2 = regexp.f5495a;
        if (op2 == Regexp.Op.f5504b || (op == op2 && (i10 & 32) == (regexp.f5496b & 32))) {
            return regexp;
        }
        if (regexp2 != null && regexp2.f5495a == op && (regexp2.f5496b & 32) == (i10 & 32) && regexp == regexp2.f5497c[0]) {
            return regexp2;
        }
        Regexp regexp3 = new Regexp(op);
        regexp3.f5496b = i10;
        regexp3.f5497c = new Regexp[]{regexp};
        return regexp3;
    }
}

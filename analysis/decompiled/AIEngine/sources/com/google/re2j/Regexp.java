package com.google.re2j;

import java.util.Arrays;
import java.util.Map;
import l5.j;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class Regexp {

    /* renamed from: j, reason: collision with root package name */
    public static final Regexp[] f5494j = new Regexp[0];

    /* renamed from: a, reason: collision with root package name */
    public Op f5495a;

    /* renamed from: b, reason: collision with root package name */
    public int f5496b;

    /* renamed from: c, reason: collision with root package name */
    public Regexp[] f5497c;

    /* renamed from: d, reason: collision with root package name */
    public int[] f5498d;

    /* renamed from: e, reason: collision with root package name */
    public int f5499e;

    /* renamed from: f, reason: collision with root package name */
    public int f5500f;

    /* renamed from: g, reason: collision with root package name */
    public int f5501g;
    public String h;

    /* renamed from: i, reason: collision with root package name */
    public Map<String, Integer> f5502i;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Op {

        /* renamed from: a, reason: collision with root package name */
        public static final Op f5503a;

        /* renamed from: b, reason: collision with root package name */
        public static final Op f5504b;

        /* renamed from: c, reason: collision with root package name */
        public static final Op f5505c;

        /* renamed from: d, reason: collision with root package name */
        public static final Op f5506d;

        /* renamed from: e, reason: collision with root package name */
        public static final Op f5507e;
        public static final Op h;

        /* renamed from: j, reason: collision with root package name */
        public static final Op f5508j;

        /* renamed from: k, reason: collision with root package name */
        public static final Op f5509k;

        /* renamed from: l, reason: collision with root package name */
        public static final Op f5510l;

        /* renamed from: m, reason: collision with root package name */
        public static final Op f5511m;

        /* renamed from: n, reason: collision with root package name */
        public static final Op f5512n;

        /* renamed from: o, reason: collision with root package name */
        public static final Op f5513o;

        /* renamed from: p, reason: collision with root package name */
        public static final Op f5514p;

        /* renamed from: q, reason: collision with root package name */
        public static final Op f5515q;
        public static final Op r;

        /* renamed from: s, reason: collision with root package name */
        public static final Op f5516s;

        /* renamed from: t, reason: collision with root package name */
        public static final Op f5517t;

        /* renamed from: u, reason: collision with root package name */
        public static final Op f5518u;

        /* renamed from: v, reason: collision with root package name */
        public static final Op f5519v;

        /* renamed from: w, reason: collision with root package name */
        public static final Op f5520w;

        /* renamed from: x, reason: collision with root package name */
        public static final Op f5521x;

        /* renamed from: y, reason: collision with root package name */
        public static final /* synthetic */ Op[] f5522y;

        static {
            Op op = new Op("NO_MATCH", 0);
            f5503a = op;
            Op op2 = new Op("EMPTY_MATCH", 1);
            f5504b = op2;
            Op op3 = new Op("LITERAL", 2);
            f5505c = op3;
            Op op4 = new Op("CHAR_CLASS", 3);
            f5506d = op4;
            Op op5 = new Op("ANY_CHAR_NOT_NL", 4);
            f5507e = op5;
            Op op6 = new Op("ANY_CHAR", 5);
            h = op6;
            Op op7 = new Op("BEGIN_LINE", 6);
            f5508j = op7;
            Op op8 = new Op("END_LINE", 7);
            f5509k = op8;
            Op op9 = new Op("BEGIN_TEXT", 8);
            f5510l = op9;
            Op op10 = new Op("END_TEXT", 9);
            f5511m = op10;
            Op op11 = new Op("WORD_BOUNDARY", 10);
            f5512n = op11;
            Op op12 = new Op("NO_WORD_BOUNDARY", 11);
            f5513o = op12;
            Op op13 = new Op("CAPTURE", 12);
            f5514p = op13;
            Op op14 = new Op("STAR", 13);
            f5515q = op14;
            Op op15 = new Op("PLUS", 14);
            r = op15;
            Op op16 = new Op("QUEST", 15);
            f5516s = op16;
            Op op17 = new Op("REPEAT", 16);
            f5517t = op17;
            Op op18 = new Op("CONCAT", 17);
            f5518u = op18;
            Op op19 = new Op("ALTERNATE", 18);
            f5519v = op19;
            Op op20 = new Op("LEFT_PAREN", 19);
            f5520w = op20;
            Op op21 = new Op("VERTICAL_BAR", 20);
            f5521x = op21;
            f5522y = new Op[]{op, op2, op3, op4, op5, op6, op7, op8, op9, op10, op11, op12, op13, op14, op15, op16, op17, op18, op19, op20, op21};
        }

        public Op() {
            throw null;
        }

        public static Op valueOf(String str) {
            return (Op) Enum.valueOf(Op.class, str);
        }

        public static Op[] values() {
            return (Op[]) f5522y.clone();
        }
    }

    public Regexp(Op op) {
        this.f5495a = op;
    }

    public final void a(StringBuilder sb2) {
        int i10 = 0;
        switch (this.f5495a.ordinal()) {
            case 0:
                sb2.append("[^\\x00-\\x{10FFFF}]");
                break;
            case 1:
                sb2.append("(?:)");
                break;
            case 2:
                if ((this.f5496b & 1) != 0) {
                    sb2.append("(?i:");
                }
                int[] iArr = this.f5498d;
                int length = iArr.length;
                while (i10 < length) {
                    j.b(sb2, iArr[i10]);
                    i10++;
                }
                if ((this.f5496b & 1) != 0) {
                    sb2.append(')');
                    break;
                }
                break;
            case 3:
                if (this.f5498d.length % 2 == 0) {
                    sb2.append('[');
                    int[] iArr2 = this.f5498d;
                    if (iArr2.length == 0) {
                        sb2.append("^\\x00-\\x{10FFFF}");
                    } else if (iArr2[0] == 0 && iArr2[iArr2.length - 1] == 1114111) {
                        sb2.append('^');
                        int i11 = 1;
                        while (true) {
                            int[] iArr3 = this.f5498d;
                            if (i11 < iArr3.length - 1) {
                                int i12 = iArr3[i11] + 1;
                                int i13 = iArr3[i11 + 1] - 1;
                                if (i12 == 45) {
                                    sb2.append('\\');
                                }
                                j.b(sb2, i12);
                                if (i12 != i13) {
                                    sb2.append('-');
                                    if (i13 == 45) {
                                        sb2.append('\\');
                                    }
                                    j.b(sb2, i13);
                                }
                                i11 += 2;
                            }
                        }
                    } else {
                        while (true) {
                            int[] iArr4 = this.f5498d;
                            if (i10 < iArr4.length) {
                                int i14 = iArr4[i10];
                                int i15 = iArr4[i10 + 1];
                                if (i14 == 45) {
                                    sb2.append('\\');
                                }
                                j.b(sb2, i14);
                                if (i14 != i15) {
                                    sb2.append('-');
                                    if (i15 == 45) {
                                        sb2.append('\\');
                                    }
                                    j.b(sb2, i15);
                                }
                                i10 += 2;
                            }
                        }
                    }
                    sb2.append(']');
                    break;
                } else {
                    sb2.append("[invalid char class]");
                    break;
                }
                break;
            case 4:
                sb2.append("(?-s:.)");
                break;
            case 5:
                sb2.append("(?s:.)");
                break;
            case 6:
                sb2.append('^');
                break;
            case 7:
                sb2.append('$');
                break;
            case 8:
                sb2.append("\\A");
                break;
            case 9:
                if ((this.f5496b & 256) == 0) {
                    sb2.append("\\z");
                    break;
                } else {
                    sb2.append("(?-m:$)");
                    break;
                }
            case 10:
                sb2.append("\\b");
                break;
            case 11:
                sb2.append("\\B");
                break;
            case 12:
                String str = this.h;
                if (str == null || str.isEmpty()) {
                    sb2.append('(');
                } else {
                    sb2.append("(?P<");
                    sb2.append(this.h);
                    sb2.append(">");
                }
                Regexp regexp = this.f5497c[0];
                if (regexp.f5495a != Op.f5504b) {
                    regexp.a(sb2);
                }
                sb2.append(')');
                break;
            case 13:
            case 14:
            case 15:
            case 16:
                Regexp regexp2 = this.f5497c[0];
                if (regexp2.f5495a.ordinal() > 12 || (regexp2.f5495a == Op.f5505c && regexp2.f5498d.length > 1)) {
                    sb2.append("(?:");
                    regexp2.a(sb2);
                    sb2.append(')');
                } else {
                    regexp2.a(sb2);
                }
                switch (this.f5495a.ordinal()) {
                    case 13:
                        sb2.append('*');
                        break;
                    case 14:
                        sb2.append('+');
                        break;
                    case 15:
                        sb2.append('?');
                        break;
                    case 16:
                        sb2.append('{');
                        sb2.append(this.f5499e);
                        if (this.f5499e != this.f5500f) {
                            sb2.append(',');
                            int i16 = this.f5500f;
                            if (i16 >= 0) {
                                sb2.append(i16);
                            }
                        }
                        sb2.append('}');
                        break;
                }
                if ((this.f5496b & 32) != 0) {
                    sb2.append('?');
                    break;
                }
                break;
            case 17:
                Regexp[] regexpArr = this.f5497c;
                int length2 = regexpArr.length;
                while (i10 < length2) {
                    Regexp regexp3 = regexpArr[i10];
                    if (regexp3.f5495a == Op.f5519v) {
                        sb2.append("(?:");
                        regexp3.a(sb2);
                        sb2.append(')');
                    } else {
                        regexp3.a(sb2);
                    }
                    i10++;
                }
                break;
            case 18:
                Regexp[] regexpArr2 = this.f5497c;
                int length3 = regexpArr2.length;
                String str2 = "";
                while (i10 < length3) {
                    Regexp regexp4 = regexpArr2[i10];
                    sb2.append(str2);
                    regexp4.a(sb2);
                    i10++;
                    str2 = "|";
                }
                break;
            default:
                sb2.append(this.f5495a);
                break;
        }
    }

    public final int b() {
        int i10 = this.f5495a == Op.f5514p ? this.f5501g : 0;
        Regexp[] regexpArr = this.f5497c;
        if (regexpArr != null) {
            for (Regexp regexp : regexpArr) {
                int iB = regexp.b();
                if (i10 < iB) {
                    i10 = iB;
                }
            }
        }
        return i10;
    }

    public final boolean equals(Object obj) {
        String str;
        if (!(obj instanceof Regexp)) {
            return false;
        }
        Regexp regexp = (Regexp) obj;
        Op op = this.f5495a;
        if (op != regexp.f5495a) {
            return false;
        }
        int iOrdinal = op.ordinal();
        if (iOrdinal == 2 || iOrdinal == 3) {
            return Arrays.equals(this.f5498d, regexp.f5498d);
        }
        if (iOrdinal == 9) {
            return (this.f5496b & 256) == (regexp.f5496b & 256);
        }
        switch (iOrdinal) {
            case 12:
                if (this.f5501g != regexp.f5501g || ((str = this.h) != null ? !str.equals(regexp.h) : regexp.h != null) || !this.f5497c[0].equals(regexp.f5497c[0])) {
                }
                break;
            case 13:
            case 14:
            case 15:
                if ((this.f5496b & 32) != (regexp.f5496b & 32) || !this.f5497c[0].equals(regexp.f5497c[0])) {
                }
                break;
            case 16:
                if ((this.f5496b & 32) != (regexp.f5496b & 32) || this.f5499e != regexp.f5499e || this.f5500f != regexp.f5500f || !this.f5497c[0].equals(regexp.f5497c[0])) {
                }
                break;
            case 17:
            case 18:
                if (this.f5497c.length == regexp.f5497c.length) {
                    int i10 = 0;
                    while (true) {
                        Regexp[] regexpArr = this.f5497c;
                        if (i10 >= regexpArr.length) {
                            break;
                        } else if (!regexpArr[i10].equals(regexp.f5497c[i10])) {
                            break;
                        } else {
                            i10++;
                        }
                    }
                }
                break;
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode;
        int iHashCode2;
        int iHashCode3;
        int iHashCode4;
        int iHashCode5 = this.f5495a.hashCode();
        int iOrdinal = this.f5495a.ordinal();
        if (iOrdinal == 2 || iOrdinal == 3) {
            iHashCode = Arrays.hashCode(this.f5498d);
        } else if (iOrdinal != 9) {
            switch (iOrdinal) {
                case 12:
                    int i10 = this.f5501g * 31;
                    String str = this.h;
                    iHashCode3 = ((str != null ? str.hashCode() : 0) * 31) + i10;
                    iHashCode4 = this.f5497c[0].hashCode();
                    iHashCode2 = (iHashCode4 * 31) + iHashCode3;
                    return iHashCode2 + iHashCode5;
                case 13:
                case 14:
                case 15:
                    iHashCode2 = (this.f5497c[0].hashCode() * 31) + ((this.f5496b & 32) * 31);
                    return iHashCode2 + iHashCode5;
                case 16:
                    iHashCode3 = (this.f5500f * 31) + (this.f5499e * 31);
                    iHashCode4 = this.f5497c[0].hashCode();
                    iHashCode2 = (iHashCode4 * 31) + iHashCode3;
                    return iHashCode2 + iHashCode5;
                case 17:
                case 18:
                    iHashCode = Arrays.deepHashCode(this.f5497c);
                    break;
                default:
                    return iHashCode5;
            }
        } else {
            iHashCode = this.f5496b & 256;
        }
        iHashCode2 = iHashCode * 31;
        return iHashCode2 + iHashCode5;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        a(sb2);
        return sb2.toString();
    }
}

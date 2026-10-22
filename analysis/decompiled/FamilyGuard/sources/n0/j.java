package n0;

import com.stepos.policy.sdk.bean.PolicyBasicListVO;

/* loaded from: classes.dex */
public class j {

    /* renamed from: e, reason: collision with root package name */
    public static final j f18895e = new j(0, null, 1443168256, 1);

    /* renamed from: f, reason: collision with root package name */
    public static final j f18896f = new j(1, null, 1509950721, 1);

    /* renamed from: g, reason: collision with root package name */
    public static final j f18897g = new j(2, null, 1124075009, 1);

    /* renamed from: h, reason: collision with root package name */
    public static final j f18898h = new j(3, null, 1107297537, 1);

    /* renamed from: i, reason: collision with root package name */
    public static final j f18899i = new j(4, null, 1392510721, 1);

    /* renamed from: j, reason: collision with root package name */
    public static final j f18900j = new j(5, null, 1224736769, 1);

    /* renamed from: k, reason: collision with root package name */
    public static final j f18901k = new j(6, null, 1174536705, 1);

    /* renamed from: l, reason: collision with root package name */
    public static final j f18902l = new j(7, null, 1241579778, 1);

    /* renamed from: m, reason: collision with root package name */
    public static final j f18903m = new j(8, null, 1141048066, 1);

    /* renamed from: a, reason: collision with root package name */
    protected final int f18904a;

    /* renamed from: b, reason: collision with root package name */
    private final char[] f18905b;

    /* renamed from: c, reason: collision with root package name */
    private final int f18906c;

    /* renamed from: d, reason: collision with root package name */
    private final int f18907d;

    private j(int i5, char[] cArr, int i6, int i7) {
        this.f18904a = i5;
        this.f18905b = cArr;
        this.f18906c = i6;
        this.f18907d = i7;
    }

    static j[] a(String str) {
        char[] charArray = str.toCharArray();
        int i5 = 1;
        int i6 = 1;
        int i7 = 0;
        while (true) {
            int i8 = i6 + 1;
            char c6 = charArray[i6];
            if (c6 == ')') {
                break;
            }
            if (c6 == 'L') {
                while (true) {
                    i6 = i8 + 1;
                    if (charArray[i8] == ';') {
                        break;
                    }
                    i8 = i6;
                }
                i7++;
            } else {
                if (c6 != '[') {
                    i7++;
                }
                i6 = i8;
            }
        }
        j[] jVarArr = new j[i7];
        int i9 = 0;
        while (charArray[i5] != ')') {
            j jVarH = h(charArray, i5);
            jVarArr[i9] = jVarH;
            i5 += jVarH.f18907d + (jVarH.f18904a == 10 ? 2 : 0);
            i9++;
        }
        return jVarArr;
    }

    public static int b(String str) {
        int i5;
        int i6 = 1;
        int i7 = 1;
        int i8 = 1;
        while (true) {
            i5 = i7 + 1;
            char cCharAt = str.charAt(i7);
            if (cCharAt == ')') {
                break;
            }
            if (cCharAt == 'L') {
                while (true) {
                    i7 = i5 + 1;
                    if (str.charAt(i5) == ';') {
                        break;
                    }
                    i5 = i7;
                }
                i8++;
            } else {
                i8 = (cCharAt == 'D' || cCharAt == 'J') ? i8 + 2 : i8 + 1;
                i7 = i5;
            }
        }
        char cCharAt2 = str.charAt(i5);
        int i9 = i8 << 2;
        if (cCharAt2 == 'V') {
            i6 = 0;
        } else if (cCharAt2 == 'D' || cCharAt2 == 'J') {
            i6 = 2;
        }
        return i9 | i6;
    }

    private int e() {
        int i5 = 1;
        while (this.f18905b[this.f18906c + i5] == '[') {
            i5++;
        }
        return i5;
    }

    public static j g(String str) {
        return h(str.toCharArray(), 0);
    }

    private static j h(char[] cArr, int i5) {
        char c6;
        char c7 = cArr[i5];
        if (c7 == 'F') {
            return f18901k;
        }
        if (c7 == 'S') {
            return f18899i;
        }
        if (c7 == 'V') {
            return f18895e;
        }
        if (c7 == 'I') {
            return f18900j;
        }
        if (c7 == 'J') {
            return f18902l;
        }
        if (c7 == 'Z') {
            return f18896f;
        }
        if (c7 != '[') {
            switch (c7) {
                case 'B':
                    return f18898h;
                case 'C':
                    return f18897g;
                case 'D':
                    return f18903m;
                default:
                    int i6 = 1;
                    while (cArr[i5 + i6] != ';') {
                        i6++;
                    }
                    return new j(10, cArr, i5 + 1, i6 - 1);
            }
        }
        int i7 = 1;
        while (true) {
            c6 = cArr[i5 + i7];
            if (c6 != '[') {
                break;
            }
            i7++;
        }
        if (c6 == 'L') {
            do {
                i7++;
            } while (cArr[i5 + i7] != ';');
        }
        return new j(9, cArr, i5, i7 + 1);
    }

    protected String c() {
        switch (this.f18904a) {
            case 0:
                return "void";
            case 1:
                return "boolean";
            case 2:
                return "char";
            case 3:
                return "byte";
            case 4:
                return "short";
            case 5:
                return "int";
            case 6:
                return "float";
            case 7:
                return "long";
            case 8:
                return "double";
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_WITH_BUTTON /* 9 */:
                StringBuilder sb = new StringBuilder(h(this.f18905b, this.f18906c + e()).c());
                for (int iE = e(); iE > 0; iE--) {
                    sb.append("[]");
                }
                return sb.toString();
            default:
                return new String(this.f18905b, this.f18906c, this.f18907d).replace('/', '.');
        }
    }

    String d() {
        return new String(this.f18905b, this.f18906c, this.f18907d);
    }

    public String f() {
        return new String(this.f18905b, this.f18906c, this.f18907d);
    }
}

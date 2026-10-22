package androidx.datastore.preferences.protobuf;

import com.baidu.entity.pb.PoiResult;
import com.stepos.alphame.utils.Property;
import d.C0527a;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import net.zetetic.database.sqlcipher.SQLiteDatabase;
import sun.misc.Unsafe;

/* loaded from: classes.dex */
public final class Y implements InterfaceC0262i0 {

    /* renamed from: o, reason: collision with root package name */
    public static final int[] f3443o = new int[0];

    /* renamed from: p, reason: collision with root package name */
    public static final Unsafe f3444p = z0.l();

    /* renamed from: a, reason: collision with root package name */
    public final int[] f3445a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f3446b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3447c;

    /* renamed from: d, reason: collision with root package name */
    public final int f3448d;

    /* renamed from: e, reason: collision with root package name */
    public final AbstractC0247b f3449e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f3450f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f3451g;

    /* renamed from: h, reason: collision with root package name */
    public final int[] f3452h;

    /* renamed from: i, reason: collision with root package name */
    public final int f3453i;

    /* renamed from: j, reason: collision with root package name */
    public final int f3454j;

    /* renamed from: k, reason: collision with root package name */
    public final C0246a0 f3455k;

    /* renamed from: l, reason: collision with root package name */
    public final L f3456l;

    /* renamed from: m, reason: collision with root package name */
    public final r0 f3457m;

    /* renamed from: n, reason: collision with root package name */
    public final T f3458n;

    public Y(int[] iArr, Object[] objArr, int i4, int i5, AbstractC0247b abstractC0247b, boolean z4, int[] iArr2, int i6, int i7, C0246a0 c0246a0, L l4, r0 r0Var, C0271s c0271s, T t4) {
        this.f3445a = iArr;
        this.f3446b = objArr;
        this.f3447c = i4;
        this.f3448d = i5;
        this.f3450f = abstractC0247b instanceof A;
        this.f3451g = z4;
        this.f3452h = iArr2;
        this.f3453i = i6;
        this.f3454j = i7;
        this.f3455k = c0246a0;
        this.f3456l = l4;
        this.f3457m = r0Var;
        this.f3449e = abstractC0247b;
        this.f3458n = t4;
    }

    public static int A(long j4, Object obj) {
        return ((Integer) z0.f3558d.i(j4, obj)).intValue();
    }

    public static long B(long j4, Object obj) {
        return ((Long) z0.f3558d.i(j4, obj)).longValue();
    }

    public static Field H(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            StringBuilder sbW = B0.g.w("Field ", str, " for ");
            sbW.append(cls.getName());
            sbW.append(" not found. Known fields are ");
            sbW.append(Arrays.toString(declaredFields));
            throw new RuntimeException(sbW.toString());
        }
    }

    public static int K(int i4) {
        return (i4 & 267386880) >>> 20;
    }

    public static void O(int i4, Object obj, C0527a c0527a) {
        if (!(obj instanceof String)) {
            c0527a.r(i4, (AbstractC0259h) obj);
        } else {
            ((AbstractC0268o) c0527a.f12410b).V(i4, (String) obj);
        }
    }

    public static List s(long j4, Object obj) {
        return (List) z0.f3558d.i(j4, obj);
    }

    public static Y x(V v4, C0246a0 c0246a0, L l4, r0 r0Var, C0271s c0271s, T t4) {
        if (v4 instanceof C0258g0) {
            return y((C0258g0) v4, c0246a0, l4, r0Var, c0271s, t4);
        }
        B0.g.y(v4);
        throw null;
    }

    public static Y y(C0258g0 c0258g0, C0246a0 c0246a0, L l4, r0 r0Var, C0271s c0271s, T t4) {
        int i4;
        int iCharAt;
        int iCharAt2;
        int i5;
        int i6;
        int i7;
        int i8;
        int[] iArr;
        int i9;
        int i10;
        char cCharAt;
        int i11;
        char cCharAt2;
        int i12;
        char cCharAt3;
        int i13;
        char cCharAt4;
        int i14;
        char cCharAt5;
        int i15;
        char cCharAt6;
        int i16;
        char cCharAt7;
        int i17;
        char cCharAt8;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        String str;
        char c4;
        int i26;
        int iObjectFieldOffset;
        int i27;
        int i28;
        int iObjectFieldOffset2;
        Field fieldH;
        int i29;
        char cCharAt9;
        int i30;
        int i31;
        int i32;
        Field fieldH2;
        Field fieldH3;
        int i33;
        char cCharAt10;
        int i34;
        char cCharAt11;
        int i35;
        char cCharAt12;
        int i36;
        char cCharAt13;
        char cCharAt14;
        int i37 = 0;
        boolean z4 = c0258g0.d() == 2;
        String strC = c0258g0.c();
        int length = strC.length();
        int iCharAt3 = strC.charAt(0);
        if (iCharAt3 >= 55296) {
            int i38 = iCharAt3 & 8191;
            int i39 = 1;
            int i40 = 13;
            while (true) {
                i4 = i39 + 1;
                cCharAt14 = strC.charAt(i39);
                if (cCharAt14 < 55296) {
                    break;
                }
                i38 |= (cCharAt14 & 8191) << i40;
                i40 += 13;
                i39 = i4;
            }
            iCharAt3 = i38 | (cCharAt14 << i40);
        } else {
            i4 = 1;
        }
        int i41 = i4 + 1;
        int iCharAt4 = strC.charAt(i4);
        if (iCharAt4 >= 55296) {
            int i42 = iCharAt4 & 8191;
            int i43 = 13;
            while (true) {
                i36 = i41 + 1;
                cCharAt13 = strC.charAt(i41);
                if (cCharAt13 < 55296) {
                    break;
                }
                i42 |= (cCharAt13 & 8191) << i43;
                i43 += 13;
                i41 = i36;
            }
            iCharAt4 = i42 | (cCharAt13 << i43);
            i41 = i36;
        }
        if (iCharAt4 == 0) {
            i9 = 0;
            iCharAt = 0;
            iCharAt2 = 0;
            i8 = 0;
            i6 = 0;
            iArr = f3443o;
            i7 = 0;
        } else {
            int i44 = i41 + 1;
            int iCharAt5 = strC.charAt(i41);
            if (iCharAt5 >= 55296) {
                int i45 = iCharAt5 & 8191;
                int i46 = 13;
                while (true) {
                    i17 = i44 + 1;
                    cCharAt8 = strC.charAt(i44);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i45 |= (cCharAt8 & 8191) << i46;
                    i46 += 13;
                    i44 = i17;
                }
                iCharAt5 = i45 | (cCharAt8 << i46);
                i44 = i17;
            }
            int i47 = i44 + 1;
            int iCharAt6 = strC.charAt(i44);
            if (iCharAt6 >= 55296) {
                int i48 = iCharAt6 & 8191;
                int i49 = 13;
                while (true) {
                    i16 = i47 + 1;
                    cCharAt7 = strC.charAt(i47);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i48 |= (cCharAt7 & 8191) << i49;
                    i49 += 13;
                    i47 = i16;
                }
                iCharAt6 = i48 | (cCharAt7 << i49);
                i47 = i16;
            }
            int i50 = i47 + 1;
            iCharAt = strC.charAt(i47);
            if (iCharAt >= 55296) {
                int i51 = iCharAt & 8191;
                int i52 = 13;
                while (true) {
                    i15 = i50 + 1;
                    cCharAt6 = strC.charAt(i50);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i51 |= (cCharAt6 & 8191) << i52;
                    i52 += 13;
                    i50 = i15;
                }
                iCharAt = i51 | (cCharAt6 << i52);
                i50 = i15;
            }
            int i53 = i50 + 1;
            iCharAt2 = strC.charAt(i50);
            if (iCharAt2 >= 55296) {
                int i54 = iCharAt2 & 8191;
                int i55 = 13;
                while (true) {
                    i14 = i53 + 1;
                    cCharAt5 = strC.charAt(i53);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i54 |= (cCharAt5 & 8191) << i55;
                    i55 += 13;
                    i53 = i14;
                }
                iCharAt2 = i54 | (cCharAt5 << i55);
                i53 = i14;
            }
            int i56 = i53 + 1;
            int iCharAt7 = strC.charAt(i53);
            if (iCharAt7 >= 55296) {
                int i57 = iCharAt7 & 8191;
                int i58 = 13;
                while (true) {
                    i13 = i56 + 1;
                    cCharAt4 = strC.charAt(i56);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i57 |= (cCharAt4 & 8191) << i58;
                    i58 += 13;
                    i56 = i13;
                }
                iCharAt7 = i57 | (cCharAt4 << i58);
                i56 = i13;
            }
            int i59 = i56 + 1;
            int iCharAt8 = strC.charAt(i56);
            if (iCharAt8 >= 55296) {
                int i60 = iCharAt8 & 8191;
                int i61 = 13;
                while (true) {
                    i12 = i59 + 1;
                    cCharAt3 = strC.charAt(i59);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i60 |= (cCharAt3 & 8191) << i61;
                    i61 += 13;
                    i59 = i12;
                }
                iCharAt8 = i60 | (cCharAt3 << i61);
                i59 = i12;
            }
            int i62 = i59 + 1;
            int iCharAt9 = strC.charAt(i59);
            if (iCharAt9 >= 55296) {
                int i63 = iCharAt9 & 8191;
                int i64 = i62;
                int i65 = 13;
                while (true) {
                    i11 = i64 + 1;
                    cCharAt2 = strC.charAt(i64);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i63 |= (cCharAt2 & 8191) << i65;
                    i65 += 13;
                    i64 = i11;
                }
                iCharAt9 = i63 | (cCharAt2 << i65);
                i5 = i11;
            } else {
                i5 = i62;
            }
            int i66 = i5 + 1;
            int iCharAt10 = strC.charAt(i5);
            if (iCharAt10 >= 55296) {
                int i67 = iCharAt10 & 8191;
                int i68 = i66;
                int i69 = 13;
                while (true) {
                    i10 = i68 + 1;
                    cCharAt = strC.charAt(i68);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i67 |= (cCharAt & 8191) << i69;
                    i69 += 13;
                    i68 = i10;
                }
                iCharAt10 = i67 | (cCharAt << i69);
                i66 = i10;
            }
            int[] iArr2 = new int[iCharAt10 + iCharAt8 + iCharAt9];
            i6 = (iCharAt5 * 2) + iCharAt6;
            i7 = iCharAt8;
            i8 = iCharAt10;
            i37 = iCharAt5;
            i41 = i66;
            int i70 = iCharAt7;
            iArr = iArr2;
            i9 = i70;
        }
        Object[] objArrB = c0258g0.b();
        Class<?> cls = c0258g0.a().getClass();
        int[] iArr3 = new int[i9 * 3];
        Object[] objArr = new Object[i9 * 2];
        int i71 = i8 + i7;
        int i72 = i8;
        int i73 = i71;
        int i74 = 0;
        int i75 = 0;
        while (i41 < length) {
            int i76 = i41 + 1;
            int iCharAt11 = strC.charAt(i41);
            if (iCharAt11 >= 55296) {
                int i77 = iCharAt11 & 8191;
                int i78 = i76;
                int i79 = 13;
                while (true) {
                    i35 = i78 + 1;
                    cCharAt12 = strC.charAt(i78);
                    i18 = length;
                    if (cCharAt12 < 55296) {
                        break;
                    }
                    i77 |= (cCharAt12 & 8191) << i79;
                    i79 += 13;
                    i78 = i35;
                    length = i18;
                }
                iCharAt11 = i77 | (cCharAt12 << i79);
                i19 = i35;
            } else {
                i18 = length;
                i19 = i76;
            }
            int i80 = i19 + 1;
            int iCharAt12 = strC.charAt(i19);
            if (iCharAt12 >= 55296) {
                int i81 = iCharAt12 & 8191;
                int i82 = i80;
                int i83 = 13;
                while (true) {
                    i34 = i82 + 1;
                    cCharAt11 = strC.charAt(i82);
                    i20 = i8;
                    if (cCharAt11 < 55296) {
                        break;
                    }
                    i81 |= (cCharAt11 & 8191) << i83;
                    i83 += 13;
                    i82 = i34;
                    i8 = i20;
                }
                iCharAt12 = i81 | (cCharAt11 << i83);
                i21 = i34;
            } else {
                i20 = i8;
                i21 = i80;
            }
            int i84 = iCharAt12 & 255;
            boolean z5 = z4;
            if ((iCharAt12 & 1024) != 0) {
                iArr[i74] = i75;
                i74++;
            }
            Unsafe unsafe = f3444p;
            int i85 = i74;
            if (i84 >= 51) {
                int i86 = i21 + 1;
                int iCharAt13 = strC.charAt(i21);
                if (iCharAt13 >= 55296) {
                    int i87 = iCharAt13 & 8191;
                    int i88 = i86;
                    int i89 = 13;
                    while (true) {
                        i33 = i88 + 1;
                        cCharAt10 = strC.charAt(i88);
                        i23 = iCharAt2;
                        if (cCharAt10 < 55296) {
                            break;
                        }
                        i87 |= (cCharAt10 & 8191) << i89;
                        i89 += 13;
                        i88 = i33;
                        iCharAt2 = i23;
                    }
                    iCharAt13 = i87 | (cCharAt10 << i89);
                    i31 = i33;
                } else {
                    i23 = iCharAt2;
                    i31 = i86;
                }
                int i90 = i84 - 51;
                int i91 = i31;
                if (i90 == 9 || i90 == 17) {
                    i32 = 2;
                    objArr[((i75 / 3) * 2) + 1] = objArrB[i6];
                    i6++;
                } else {
                    if (i90 == 12 && (iCharAt3 & 1) == 1) {
                        objArr[((i75 / 3) * 2) + 1] = objArrB[i6];
                        i6++;
                    }
                    i32 = 2;
                }
                int i92 = iCharAt13 * i32;
                Object obj = objArrB[i92];
                if (obj instanceof Field) {
                    fieldH2 = (Field) obj;
                } else {
                    fieldH2 = H(cls, (String) obj);
                    objArrB[i92] = fieldH2;
                }
                i22 = iCharAt;
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldH2);
                int i93 = i92 + 1;
                Object obj2 = objArrB[i93];
                if (obj2 instanceof Field) {
                    fieldH3 = (Field) obj2;
                } else {
                    fieldH3 = H(cls, (String) obj2);
                    objArrB[i93] = fieldH3;
                }
                i24 = iCharAt12;
                i28 = i6;
                i26 = i91;
                c4 = 2;
                str = strC;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldH3);
                i27 = 0;
            } else {
                i22 = iCharAt;
                i23 = iCharAt2;
                int i94 = i6 + 1;
                Field fieldH4 = H(cls, (String) objArrB[i6]);
                if (i84 == 9 || i84 == 17) {
                    i24 = iCharAt12;
                    i25 = 1;
                    objArr[((i75 / 3) * 2) + 1] = fieldH4.getType();
                } else {
                    if (i84 == 27 || i84 == 49) {
                        i24 = iCharAt12;
                        i25 = 1;
                        i30 = i6 + 2;
                        objArr[((i75 / 3) * 2) + 1] = objArrB[i94];
                    } else if (i84 == 12 || i84 == 30 || i84 == 44) {
                        i24 = iCharAt12;
                        i25 = 1;
                        if ((iCharAt3 & 1) == 1) {
                            i30 = i6 + 2;
                            objArr[((i75 / 3) * 2) + 1] = objArrB[i94];
                        }
                    } else if (i84 == 50) {
                        int i95 = i72 + 1;
                        iArr[i72] = i75;
                        int i96 = (i75 / 3) * 2;
                        int i97 = i6 + 2;
                        objArr[i96] = objArrB[i94];
                        if ((iCharAt12 & 2048) != 0) {
                            i94 = i6 + 3;
                            objArr[i96 + 1] = objArrB[i97];
                            i24 = iCharAt12;
                            i72 = i95;
                            i25 = 1;
                        } else {
                            i72 = i95;
                            i94 = i97;
                            i24 = iCharAt12;
                            i25 = 1;
                        }
                    } else {
                        i24 = iCharAt12;
                        i25 = 1;
                    }
                    i94 = i30;
                }
                int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldH4);
                if ((iCharAt3 & 1) != i25 || i84 > 17) {
                    str = strC;
                    c4 = 2;
                    i26 = i21;
                    iObjectFieldOffset = 0;
                    i27 = 0;
                } else {
                    i26 = i21 + 1;
                    int iCharAt14 = strC.charAt(i21);
                    if (iCharAt14 >= 55296) {
                        int i98 = iCharAt14 & 8191;
                        int i99 = 13;
                        while (true) {
                            i29 = i26 + 1;
                            cCharAt9 = strC.charAt(i26);
                            if (cCharAt9 < 55296) {
                                break;
                            }
                            i98 |= (cCharAt9 & 8191) << i99;
                            i99 += 13;
                            i26 = i29;
                        }
                        iCharAt14 = i98 | (cCharAt9 << i99);
                        i26 = i29;
                    }
                    c4 = 2;
                    int i100 = (iCharAt14 / 32) + (i37 * 2);
                    Object obj3 = objArrB[i100];
                    if (obj3 instanceof Field) {
                        fieldH = (Field) obj3;
                    } else {
                        fieldH = H(cls, (String) obj3);
                        objArrB[i100] = fieldH;
                    }
                    str = strC;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldH);
                    i27 = iCharAt14 % 32;
                }
                if (i84 >= 18 && i84 <= 49) {
                    iArr[i73] = iObjectFieldOffset3;
                    i73++;
                }
                i28 = i94;
                iObjectFieldOffset2 = iObjectFieldOffset3;
            }
            int i101 = i75 + 1;
            iArr3[i75] = iCharAt11;
            int i102 = i75 + 2;
            int i103 = i28;
            int i104 = i24;
            iArr3[i101] = ((i104 & 512) != 0 ? SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING : 0) | ((i104 & 256) != 0 ? SQLiteDatabase.CREATE_IF_NECESSARY : 0) | (i84 << 20) | iObjectFieldOffset2;
            i75 += 3;
            iArr3[i102] = iObjectFieldOffset | (i27 << 20);
            i41 = i26;
            strC = str;
            z4 = z5;
            i6 = i103;
            length = i18;
            i8 = i20;
            i74 = i85;
            iCharAt = i22;
            iCharAt2 = i23;
        }
        return new Y(iArr3, objArr, iCharAt, iCharAt2, c0258g0.a(), z4, iArr, i8, i71, c0246a0, l4, r0Var, c0271s, t4);
    }

    public static long z(int i4) {
        return i4 & 1048575;
    }

    public final int C(int i4) {
        if (i4 < this.f3447c || i4 > this.f3448d) {
            return -1;
        }
        int[] iArr = this.f3445a;
        int length = (iArr.length / 3) - 1;
        int i5 = 0;
        while (i5 <= length) {
            int i6 = (length + i5) >>> 1;
            int i7 = i6 * 3;
            int i8 = iArr[i7];
            if (i4 == i8) {
                return i7;
            }
            if (i4 < i8) {
                length = i6 - 1;
            } else {
                i5 = i6 + 1;
            }
        }
        return -1;
    }

    public final void D(Object obj, long j4, InterfaceC0260h0 interfaceC0260h0, InterfaceC0262i0 interfaceC0262i0, r rVar) {
        interfaceC0260h0.z(this.f3456l.c(j4, obj), interfaceC0262i0, rVar);
    }

    public final void E(Object obj, int i4, InterfaceC0260h0 interfaceC0260h0, InterfaceC0262i0 interfaceC0262i0, r rVar) {
        interfaceC0260h0.D(this.f3456l.c(i4 & 1048575, obj), interfaceC0262i0, rVar);
    }

    public final void F(Object obj, int i4, InterfaceC0260h0 interfaceC0260h0) {
        if ((536870912 & i4) != 0) {
            z0.r(i4 & 1048575, obj, interfaceC0260h0.H());
        } else if (this.f3450f) {
            z0.r(i4 & 1048575, obj, interfaceC0260h0.n());
        } else {
            z0.r(i4 & 1048575, obj, interfaceC0260h0.v());
        }
    }

    public final void G(Object obj, int i4, InterfaceC0260h0 interfaceC0260h0) {
        boolean z4 = (536870912 & i4) != 0;
        L l4 = this.f3456l;
        if (z4) {
            interfaceC0260h0.u(l4.c(i4 & 1048575, obj));
        } else {
            interfaceC0260h0.r(l4.c(i4 & 1048575, obj));
        }
    }

    public final void I(int i4, Object obj) {
        if (this.f3451g) {
            return;
        }
        int i5 = this.f3445a[i4 + 2];
        long j4 = i5 & 1048575;
        z0.p(z0.f3558d.g(j4, obj) | (1 << (i5 >>> 20)), j4, obj);
    }

    public final void J(int i4, int i5, Object obj) {
        z0.p(i4, this.f3445a[i5 + 2] & 1048575, obj);
    }

    public final int L(int i4) {
        return this.f3445a[i4 + 1];
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void M(Object obj, C0527a c0527a) {
        int i4;
        boolean z4;
        int[] iArr = this.f3445a;
        int length = iArr.length;
        int i5 = -1;
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7 += 3) {
            int iL = L(i7);
            int i8 = iArr[i7];
            int iK = K(iL);
            boolean z5 = this.f3451g;
            Unsafe unsafe = f3444p;
            if (z5 || iK > 17) {
                i4 = 0;
            } else {
                int i9 = iArr[i7 + 2];
                int i10 = i9 & 1048575;
                if (i10 != i5) {
                    i6 = unsafe.getInt(obj, i10);
                    i5 = i10;
                }
                i4 = 1 << (i9 >>> 20);
            }
            long j4 = iL & 1048575;
            switch (iK) {
                case 0:
                    if ((i4 & i6) != 0) {
                        c0527a.s(i8, z0.f3558d.e(j4, obj));
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if ((i4 & i6) != 0) {
                        c0527a.w(z0.f3558d.f(j4, obj), i8);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if ((i4 & i6) != 0) {
                        c0527a.z(i8, unsafe.getLong(obj, j4));
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if ((i4 & i6) != 0) {
                        c0527a.G(i8, unsafe.getLong(obj, j4));
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if ((i4 & i6) != 0) {
                        c0527a.y(i8, unsafe.getInt(obj, j4));
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if ((i4 & i6) != 0) {
                        c0527a.v(i8, unsafe.getLong(obj, j4));
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if ((i4 & i6) != 0) {
                        c0527a.u(i8, unsafe.getInt(obj, j4));
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if ((i4 & i6) != 0) {
                        c0527a.q(i8, z0.f3558d.c(j4, obj));
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if ((i4 & i6) != 0) {
                        O(i8, unsafe.getObject(obj, j4), c0527a);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if ((i4 & i6) != 0) {
                        c0527a.A(i8, n(i7), unsafe.getObject(obj, j4));
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if ((i4 & i6) != 0) {
                        c0527a.r(i8, (AbstractC0259h) unsafe.getObject(obj, j4));
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if ((i4 & i6) != 0) {
                        c0527a.F(i8, unsafe.getInt(obj, j4));
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if ((i4 & i6) != 0) {
                        c0527a.t(i8, unsafe.getInt(obj, j4));
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if ((i4 & i6) != 0) {
                        c0527a.B(i8, unsafe.getInt(obj, j4));
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if ((i4 & i6) != 0) {
                        c0527a.C(i8, unsafe.getLong(obj, j4));
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if ((i4 & i6) != 0) {
                        c0527a.D(i8, unsafe.getInt(obj, j4));
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if ((i4 & i6) != 0) {
                        c0527a.E(i8, unsafe.getLong(obj, j4));
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if ((i4 & i6) != 0) {
                        c0527a.x(i8, n(i7), unsafe.getObject(obj, j4));
                        break;
                    } else {
                        break;
                    }
                case 18:
                    j0.F(iArr[i7], (List) unsafe.getObject(obj, j4), c0527a, false);
                    break;
                case 19:
                    j0.J(iArr[i7], (List) unsafe.getObject(obj, j4), c0527a, false);
                    break;
                case 20:
                    j0.M(iArr[i7], (List) unsafe.getObject(obj, j4), c0527a, false);
                    break;
                case 21:
                    j0.U(iArr[i7], (List) unsafe.getObject(obj, j4), c0527a, false);
                    break;
                case 22:
                    j0.L(iArr[i7], (List) unsafe.getObject(obj, j4), c0527a, false);
                    break;
                case 23:
                    j0.I(iArr[i7], (List) unsafe.getObject(obj, j4), c0527a, false);
                    break;
                case 24:
                    j0.H(iArr[i7], (List) unsafe.getObject(obj, j4), c0527a, false);
                    break;
                case 25:
                    j0.D(iArr[i7], (List) unsafe.getObject(obj, j4), c0527a, false);
                    break;
                case 26:
                    j0.S(iArr[i7], (List) unsafe.getObject(obj, j4), c0527a);
                    break;
                case 27:
                    j0.N(iArr[i7], (List) unsafe.getObject(obj, j4), c0527a, n(i7));
                    break;
                case 28:
                    j0.E(iArr[i7], (List) unsafe.getObject(obj, j4), c0527a);
                    break;
                case 29:
                    z4 = false;
                    j0.T(iArr[i7], (List) unsafe.getObject(obj, j4), c0527a, false);
                    break;
                case 30:
                    z4 = false;
                    j0.G(iArr[i7], (List) unsafe.getObject(obj, j4), c0527a, false);
                    break;
                case 31:
                    z4 = false;
                    j0.O(iArr[i7], (List) unsafe.getObject(obj, j4), c0527a, false);
                    break;
                case 32:
                    z4 = false;
                    j0.P(iArr[i7], (List) unsafe.getObject(obj, j4), c0527a, false);
                    break;
                case 33:
                    z4 = false;
                    j0.Q(iArr[i7], (List) unsafe.getObject(obj, j4), c0527a, false);
                    break;
                case 34:
                    z4 = false;
                    j0.R(iArr[i7], (List) unsafe.getObject(obj, j4), c0527a, false);
                    break;
                case 35:
                    j0.F(iArr[i7], (List) unsafe.getObject(obj, j4), c0527a, true);
                    break;
                case 36:
                    j0.J(iArr[i7], (List) unsafe.getObject(obj, j4), c0527a, true);
                    break;
                case 37:
                    j0.M(iArr[i7], (List) unsafe.getObject(obj, j4), c0527a, true);
                    break;
                case 38:
                    j0.U(iArr[i7], (List) unsafe.getObject(obj, j4), c0527a, true);
                    break;
                case 39:
                    j0.L(iArr[i7], (List) unsafe.getObject(obj, j4), c0527a, true);
                    break;
                case 40:
                    j0.I(iArr[i7], (List) unsafe.getObject(obj, j4), c0527a, true);
                    break;
                case 41:
                    j0.H(iArr[i7], (List) unsafe.getObject(obj, j4), c0527a, true);
                    break;
                case 42:
                    j0.D(iArr[i7], (List) unsafe.getObject(obj, j4), c0527a, true);
                    break;
                case 43:
                    j0.T(iArr[i7], (List) unsafe.getObject(obj, j4), c0527a, true);
                    break;
                case 44:
                    j0.G(iArr[i7], (List) unsafe.getObject(obj, j4), c0527a, true);
                    break;
                case 45:
                    j0.O(iArr[i7], (List) unsafe.getObject(obj, j4), c0527a, true);
                    break;
                case 46:
                    j0.P(iArr[i7], (List) unsafe.getObject(obj, j4), c0527a, true);
                    break;
                case 47:
                    j0.Q(iArr[i7], (List) unsafe.getObject(obj, j4), c0527a, true);
                    break;
                case 48:
                    j0.R(iArr[i7], (List) unsafe.getObject(obj, j4), c0527a, true);
                    break;
                case 49:
                    j0.K(iArr[i7], (List) unsafe.getObject(obj, j4), c0527a, n(i7));
                    break;
                case 50:
                    N(c0527a, i8, unsafe.getObject(obj, j4), i7);
                    break;
                case 51:
                    if (r(i8, i7, obj)) {
                        c0527a.s(i8, ((Double) z0.f3558d.i(j4, obj)).doubleValue());
                    }
                    break;
                case 52:
                    if (r(i8, i7, obj)) {
                        c0527a.w(((Float) z0.f3558d.i(j4, obj)).floatValue(), i8);
                    }
                    break;
                case 53:
                    if (r(i8, i7, obj)) {
                        c0527a.z(i8, B(j4, obj));
                    }
                    break;
                case 54:
                    if (r(i8, i7, obj)) {
                        c0527a.G(i8, B(j4, obj));
                    }
                    break;
                case 55:
                    if (r(i8, i7, obj)) {
                        c0527a.y(i8, A(j4, obj));
                    }
                    break;
                case 56:
                    if (r(i8, i7, obj)) {
                        c0527a.v(i8, B(j4, obj));
                    }
                    break;
                case 57:
                    if (r(i8, i7, obj)) {
                        c0527a.u(i8, A(j4, obj));
                    }
                    break;
                case 58:
                    if (r(i8, i7, obj)) {
                        c0527a.q(i8, ((Boolean) z0.f3558d.i(j4, obj)).booleanValue());
                    }
                    break;
                case PoiResult.Contents.CITY_FIELD_NUMBER /* 59 */:
                    if (r(i8, i7, obj)) {
                        O(i8, unsafe.getObject(obj, j4), c0527a);
                    }
                    break;
                case PoiResult.Contents.PROVINCE_FIELD_NUMBER /* 60 */:
                    if (r(i8, i7, obj)) {
                        c0527a.A(i8, n(i7), unsafe.getObject(obj, j4));
                    }
                    break;
                case 61:
                    if (r(i8, i7, obj)) {
                        c0527a.r(i8, (AbstractC0259h) unsafe.getObject(obj, j4));
                    }
                    break;
                case 62:
                    if (r(i8, i7, obj)) {
                        c0527a.F(i8, A(j4, obj));
                    }
                    break;
                case 63:
                    if (r(i8, i7, obj)) {
                        c0527a.t(i8, A(j4, obj));
                    }
                    break;
                case 64:
                    if (r(i8, i7, obj)) {
                        c0527a.B(i8, A(j4, obj));
                    }
                    break;
                case 65:
                    if (r(i8, i7, obj)) {
                        c0527a.C(i8, B(j4, obj));
                    }
                    break;
                case 66:
                    if (r(i8, i7, obj)) {
                        c0527a.D(i8, A(j4, obj));
                    }
                    break;
                case 67:
                    if (r(i8, i7, obj)) {
                        c0527a.E(i8, B(j4, obj));
                    }
                    break;
                case 68:
                    if (r(i8, i7, obj)) {
                        c0527a.x(i8, n(i7), unsafe.getObject(obj, j4));
                    }
                    break;
            }
        }
        this.f3457m.getClass();
        ((A) obj).unknownFields.d(c0527a);
    }

    public final void N(C0527a c0527a, int i4, Object obj, int i5) {
        if (obj != null) {
            Object objM = m(i5);
            this.f3458n.getClass();
            t.d dVar = ((Q) objM).f3434a;
            ((AbstractC0268o) c0527a.f12410b).getClass();
            for (Map.Entry entry : ((S) obj).entrySet()) {
                ((AbstractC0268o) c0527a.f12410b).X(i4, 2);
                ((AbstractC0268o) c0527a.f12410b).Z(Q.a(dVar, entry.getKey(), entry.getValue()));
                Q.b((AbstractC0268o) c0527a.f12410b, dVar, entry.getKey(), entry.getValue());
            }
        }
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0262i0
    public final void a(Object obj, InterfaceC0260h0 interfaceC0260h0, r rVar) throws Throwable {
        rVar.getClass();
        t(this.f3457m, obj, interfaceC0260h0, rVar);
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0262i0
    public final void b(Object obj, Object obj2) {
        obj2.getClass();
        int i4 = 0;
        while (true) {
            int[] iArr = this.f3445a;
            if (i4 >= iArr.length) {
                if (this.f3451g) {
                    return;
                }
                j0.B(this.f3457m, obj, obj2);
                return;
            }
            int iL = L(i4);
            long j4 = 1048575 & iL;
            int i5 = iArr[i4];
            switch (K(iL)) {
                case 0:
                    if (!q(i4, obj2)) {
                        break;
                    } else {
                        y0 y0Var = z0.f3558d;
                        y0Var.m(obj, j4, y0Var.e(j4, obj2));
                        I(i4, obj);
                        break;
                    }
                case 1:
                    if (!q(i4, obj2)) {
                        break;
                    } else {
                        y0 y0Var2 = z0.f3558d;
                        y0Var2.n(obj, j4, y0Var2.f(j4, obj2));
                        I(i4, obj);
                        break;
                    }
                case 2:
                    if (!q(i4, obj2)) {
                        break;
                    } else {
                        z0.q(obj, j4, z0.f3558d.h(j4, obj2));
                        I(i4, obj);
                        break;
                    }
                case 3:
                    if (!q(i4, obj2)) {
                        break;
                    } else {
                        z0.q(obj, j4, z0.f3558d.h(j4, obj2));
                        I(i4, obj);
                        break;
                    }
                case 4:
                    if (!q(i4, obj2)) {
                        break;
                    } else {
                        z0.p(z0.f3558d.g(j4, obj2), j4, obj);
                        I(i4, obj);
                        break;
                    }
                case 5:
                    if (!q(i4, obj2)) {
                        break;
                    } else {
                        z0.q(obj, j4, z0.f3558d.h(j4, obj2));
                        I(i4, obj);
                        break;
                    }
                case 6:
                    if (!q(i4, obj2)) {
                        break;
                    } else {
                        z0.p(z0.f3558d.g(j4, obj2), j4, obj);
                        I(i4, obj);
                        break;
                    }
                case 7:
                    if (!q(i4, obj2)) {
                        break;
                    } else {
                        y0 y0Var3 = z0.f3558d;
                        y0Var3.k(obj, j4, y0Var3.c(j4, obj2));
                        I(i4, obj);
                        break;
                    }
                case 8:
                    if (!q(i4, obj2)) {
                        break;
                    } else {
                        z0.r(j4, obj, z0.f3558d.i(j4, obj2));
                        I(i4, obj);
                        break;
                    }
                case 9:
                    v(i4, obj, obj2);
                    break;
                case 10:
                    if (!q(i4, obj2)) {
                        break;
                    } else {
                        z0.r(j4, obj, z0.f3558d.i(j4, obj2));
                        I(i4, obj);
                        break;
                    }
                case 11:
                    if (!q(i4, obj2)) {
                        break;
                    } else {
                        z0.p(z0.f3558d.g(j4, obj2), j4, obj);
                        I(i4, obj);
                        break;
                    }
                case 12:
                    if (!q(i4, obj2)) {
                        break;
                    } else {
                        z0.p(z0.f3558d.g(j4, obj2), j4, obj);
                        I(i4, obj);
                        break;
                    }
                case 13:
                    if (!q(i4, obj2)) {
                        break;
                    } else {
                        z0.p(z0.f3558d.g(j4, obj2), j4, obj);
                        I(i4, obj);
                        break;
                    }
                case 14:
                    if (!q(i4, obj2)) {
                        break;
                    } else {
                        z0.q(obj, j4, z0.f3558d.h(j4, obj2));
                        I(i4, obj);
                        break;
                    }
                case 15:
                    if (!q(i4, obj2)) {
                        break;
                    } else {
                        z0.p(z0.f3558d.g(j4, obj2), j4, obj);
                        I(i4, obj);
                        break;
                    }
                case 16:
                    if (!q(i4, obj2)) {
                        break;
                    } else {
                        z0.q(obj, j4, z0.f3558d.h(j4, obj2));
                        I(i4, obj);
                        break;
                    }
                case 17:
                    v(i4, obj, obj2);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.f3456l.b(j4, obj, obj2);
                    break;
                case 50:
                    Class cls = j0.f3492a;
                    y0 y0Var4 = z0.f3558d;
                    Object objI = y0Var4.i(j4, obj);
                    Object objI2 = y0Var4.i(j4, obj2);
                    this.f3458n.getClass();
                    z0.r(j4, obj, T.b(objI, objI2));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case PoiResult.Contents.CITY_FIELD_NUMBER /* 59 */:
                    if (!r(i5, i4, obj2)) {
                        break;
                    } else {
                        z0.r(j4, obj, z0.f3558d.i(j4, obj2));
                        J(i5, i4, obj);
                        break;
                    }
                case PoiResult.Contents.PROVINCE_FIELD_NUMBER /* 60 */:
                    w(i4, obj, obj2);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (!r(i5, i4, obj2)) {
                        break;
                    } else {
                        z0.r(j4, obj, z0.f3558d.i(j4, obj2));
                        J(i5, i4, obj);
                        break;
                    }
                case 68:
                    w(i4, obj, obj2);
                    break;
            }
            i4 += 3;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0262i0
    public final void c(Object obj, C0527a c0527a) {
        c0527a.getClass();
        if (!this.f3451g) {
            M(obj, c0527a);
            return;
        }
        int[] iArr = this.f3445a;
        int length = iArr.length;
        for (int i4 = 0; i4 < length; i4 += 3) {
            int iL = L(i4);
            int i5 = iArr[i4];
            switch (K(iL)) {
                case 0:
                    if (q(i4, obj)) {
                        c0527a.s(i5, z0.f3558d.e(iL & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (q(i4, obj)) {
                        c0527a.w(z0.f3558d.f(iL & 1048575, obj), i5);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (q(i4, obj)) {
                        c0527a.z(i5, z0.f3558d.h(iL & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (q(i4, obj)) {
                        c0527a.G(i5, z0.f3558d.h(iL & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (q(i4, obj)) {
                        c0527a.y(i5, z0.f3558d.g(iL & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (q(i4, obj)) {
                        c0527a.v(i5, z0.f3558d.h(iL & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (q(i4, obj)) {
                        c0527a.u(i5, z0.f3558d.g(iL & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (q(i4, obj)) {
                        c0527a.q(i5, z0.f3558d.c(iL & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (q(i4, obj)) {
                        O(i5, z0.f3558d.i(iL & 1048575, obj), c0527a);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if (q(i4, obj)) {
                        c0527a.A(i5, n(i4), z0.f3558d.i(iL & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (q(i4, obj)) {
                        c0527a.r(i5, (AbstractC0259h) z0.f3558d.i(iL & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (q(i4, obj)) {
                        c0527a.F(i5, z0.f3558d.g(iL & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (q(i4, obj)) {
                        c0527a.t(i5, z0.f3558d.g(iL & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (q(i4, obj)) {
                        c0527a.B(i5, z0.f3558d.g(iL & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (q(i4, obj)) {
                        c0527a.C(i5, z0.f3558d.h(iL & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (q(i4, obj)) {
                        c0527a.D(i5, z0.f3558d.g(iL & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (q(i4, obj)) {
                        c0527a.E(i5, z0.f3558d.h(iL & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (q(i4, obj)) {
                        c0527a.x(i5, n(i4), z0.f3558d.i(iL & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 18:
                    j0.F(iArr[i4], (List) z0.f3558d.i(iL & 1048575, obj), c0527a, false);
                    break;
                case 19:
                    j0.J(iArr[i4], (List) z0.f3558d.i(iL & 1048575, obj), c0527a, false);
                    break;
                case 20:
                    j0.M(iArr[i4], (List) z0.f3558d.i(iL & 1048575, obj), c0527a, false);
                    break;
                case 21:
                    j0.U(iArr[i4], (List) z0.f3558d.i(iL & 1048575, obj), c0527a, false);
                    break;
                case 22:
                    j0.L(iArr[i4], (List) z0.f3558d.i(iL & 1048575, obj), c0527a, false);
                    break;
                case 23:
                    j0.I(iArr[i4], (List) z0.f3558d.i(iL & 1048575, obj), c0527a, false);
                    break;
                case 24:
                    j0.H(iArr[i4], (List) z0.f3558d.i(iL & 1048575, obj), c0527a, false);
                    break;
                case 25:
                    j0.D(iArr[i4], (List) z0.f3558d.i(iL & 1048575, obj), c0527a, false);
                    break;
                case 26:
                    j0.S(iArr[i4], (List) z0.f3558d.i(iL & 1048575, obj), c0527a);
                    break;
                case 27:
                    j0.N(iArr[i4], (List) z0.f3558d.i(iL & 1048575, obj), c0527a, n(i4));
                    break;
                case 28:
                    j0.E(iArr[i4], (List) z0.f3558d.i(iL & 1048575, obj), c0527a);
                    break;
                case 29:
                    j0.T(iArr[i4], (List) z0.f3558d.i(iL & 1048575, obj), c0527a, false);
                    break;
                case 30:
                    j0.G(iArr[i4], (List) z0.f3558d.i(iL & 1048575, obj), c0527a, false);
                    break;
                case 31:
                    j0.O(iArr[i4], (List) z0.f3558d.i(iL & 1048575, obj), c0527a, false);
                    break;
                case 32:
                    j0.P(iArr[i4], (List) z0.f3558d.i(iL & 1048575, obj), c0527a, false);
                    break;
                case 33:
                    j0.Q(iArr[i4], (List) z0.f3558d.i(iL & 1048575, obj), c0527a, false);
                    break;
                case 34:
                    j0.R(iArr[i4], (List) z0.f3558d.i(iL & 1048575, obj), c0527a, false);
                    break;
                case 35:
                    j0.F(iArr[i4], (List) z0.f3558d.i(iL & 1048575, obj), c0527a, true);
                    break;
                case 36:
                    j0.J(iArr[i4], (List) z0.f3558d.i(iL & 1048575, obj), c0527a, true);
                    break;
                case 37:
                    j0.M(iArr[i4], (List) z0.f3558d.i(iL & 1048575, obj), c0527a, true);
                    break;
                case 38:
                    j0.U(iArr[i4], (List) z0.f3558d.i(iL & 1048575, obj), c0527a, true);
                    break;
                case 39:
                    j0.L(iArr[i4], (List) z0.f3558d.i(iL & 1048575, obj), c0527a, true);
                    break;
                case 40:
                    j0.I(iArr[i4], (List) z0.f3558d.i(iL & 1048575, obj), c0527a, true);
                    break;
                case 41:
                    j0.H(iArr[i4], (List) z0.f3558d.i(iL & 1048575, obj), c0527a, true);
                    break;
                case 42:
                    j0.D(iArr[i4], (List) z0.f3558d.i(iL & 1048575, obj), c0527a, true);
                    break;
                case 43:
                    j0.T(iArr[i4], (List) z0.f3558d.i(iL & 1048575, obj), c0527a, true);
                    break;
                case 44:
                    j0.G(iArr[i4], (List) z0.f3558d.i(iL & 1048575, obj), c0527a, true);
                    break;
                case 45:
                    j0.O(iArr[i4], (List) z0.f3558d.i(iL & 1048575, obj), c0527a, true);
                    break;
                case 46:
                    j0.P(iArr[i4], (List) z0.f3558d.i(iL & 1048575, obj), c0527a, true);
                    break;
                case 47:
                    j0.Q(iArr[i4], (List) z0.f3558d.i(iL & 1048575, obj), c0527a, true);
                    break;
                case 48:
                    j0.R(iArr[i4], (List) z0.f3558d.i(iL & 1048575, obj), c0527a, true);
                    break;
                case 49:
                    j0.K(iArr[i4], (List) z0.f3558d.i(iL & 1048575, obj), c0527a, n(i4));
                    break;
                case 50:
                    N(c0527a, i5, z0.f3558d.i(iL & 1048575, obj), i4);
                    break;
                case 51:
                    if (r(i5, i4, obj)) {
                        c0527a.s(i5, ((Double) z0.f3558d.i(iL & 1048575, obj)).doubleValue());
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (r(i5, i4, obj)) {
                        c0527a.w(((Float) z0.f3558d.i(iL & 1048575, obj)).floatValue(), i5);
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (r(i5, i4, obj)) {
                        c0527a.z(i5, B(iL & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (r(i5, i4, obj)) {
                        c0527a.G(i5, B(iL & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (r(i5, i4, obj)) {
                        c0527a.y(i5, A(iL & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (r(i5, i4, obj)) {
                        c0527a.v(i5, B(iL & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (r(i5, i4, obj)) {
                        c0527a.u(i5, A(iL & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (r(i5, i4, obj)) {
                        c0527a.q(i5, ((Boolean) z0.f3558d.i(iL & 1048575, obj)).booleanValue());
                        break;
                    } else {
                        break;
                    }
                case PoiResult.Contents.CITY_FIELD_NUMBER /* 59 */:
                    if (r(i5, i4, obj)) {
                        O(i5, z0.f3558d.i(iL & 1048575, obj), c0527a);
                        break;
                    } else {
                        break;
                    }
                case PoiResult.Contents.PROVINCE_FIELD_NUMBER /* 60 */:
                    if (r(i5, i4, obj)) {
                        c0527a.A(i5, n(i4), z0.f3558d.i(iL & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (r(i5, i4, obj)) {
                        c0527a.r(i5, (AbstractC0259h) z0.f3558d.i(iL & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (r(i5, i4, obj)) {
                        c0527a.F(i5, A(iL & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (r(i5, i4, obj)) {
                        c0527a.t(i5, A(iL & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (r(i5, i4, obj)) {
                        c0527a.B(i5, A(iL & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (r(i5, i4, obj)) {
                        c0527a.C(i5, B(iL & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (r(i5, i4, obj)) {
                        c0527a.D(i5, A(iL & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (r(i5, i4, obj)) {
                        c0527a.E(i5, B(iL & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (r(i5, i4, obj)) {
                        c0527a.x(i5, n(i4), z0.f3558d.i(iL & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
            }
        }
        this.f3457m.getClass();
        ((A) obj).unknownFields.d(c0527a);
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0262i0
    public final void d(Object obj) {
        int[] iArr;
        int i4;
        int i5 = this.f3453i;
        while (true) {
            iArr = this.f3452h;
            i4 = this.f3454j;
            if (i5 >= i4) {
                break;
            }
            long jL = L(iArr[i5]) & 1048575;
            Object objI = z0.f3558d.i(jL, obj);
            if (objI != null) {
                this.f3458n.getClass();
                ((S) objI).f3438a = false;
                z0.r(jL, obj, objI);
            }
            i5++;
        }
        int length = iArr.length;
        while (i4 < length) {
            this.f3456l.a(iArr[i4], obj);
            i4++;
        }
        this.f3457m.getClass();
        ((A) obj).unknownFields.f3531e = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x010a  */
    @Override // androidx.datastore.preferences.protobuf.InterfaceC0262i0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean e(java.lang.Object r15) {
        /*
            Method dump skipped, instructions count: 291
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Y.e(java.lang.Object):boolean");
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0262i0
    public final boolean f(Object obj, Object obj2) {
        boolean zC;
        int[] iArr = this.f3445a;
        int length = iArr.length;
        for (int i4 = 0; i4 < length; i4 += 3) {
            int iL = L(i4);
            long j4 = iL & 1048575;
            switch (K(iL)) {
                case 0:
                    if (j(i4, obj, obj2)) {
                        y0 y0Var = z0.f3558d;
                        if (Double.doubleToLongBits(y0Var.e(j4, obj)) == Double.doubleToLongBits(y0Var.e(j4, obj2))) {
                            continue;
                        }
                    }
                    return false;
                case 1:
                    if (j(i4, obj, obj2)) {
                        y0 y0Var2 = z0.f3558d;
                        if (Float.floatToIntBits(y0Var2.f(j4, obj)) == Float.floatToIntBits(y0Var2.f(j4, obj2))) {
                            continue;
                        }
                    }
                    return false;
                case 2:
                    if (j(i4, obj, obj2)) {
                        y0 y0Var3 = z0.f3558d;
                        if (y0Var3.h(j4, obj) == y0Var3.h(j4, obj2)) {
                            continue;
                        }
                    }
                    return false;
                case 3:
                    if (j(i4, obj, obj2)) {
                        y0 y0Var4 = z0.f3558d;
                        if (y0Var4.h(j4, obj) == y0Var4.h(j4, obj2)) {
                            continue;
                        }
                    }
                    return false;
                case 4:
                    if (j(i4, obj, obj2)) {
                        y0 y0Var5 = z0.f3558d;
                        if (y0Var5.g(j4, obj) == y0Var5.g(j4, obj2)) {
                            continue;
                        }
                    }
                    return false;
                case 5:
                    if (j(i4, obj, obj2)) {
                        y0 y0Var6 = z0.f3558d;
                        if (y0Var6.h(j4, obj) == y0Var6.h(j4, obj2)) {
                            continue;
                        }
                    }
                    return false;
                case 6:
                    if (j(i4, obj, obj2)) {
                        y0 y0Var7 = z0.f3558d;
                        if (y0Var7.g(j4, obj) == y0Var7.g(j4, obj2)) {
                            continue;
                        }
                    }
                    return false;
                case 7:
                    if (j(i4, obj, obj2)) {
                        y0 y0Var8 = z0.f3558d;
                        if (y0Var8.c(j4, obj) == y0Var8.c(j4, obj2)) {
                            continue;
                        }
                    }
                    return false;
                case 8:
                    if (j(i4, obj, obj2)) {
                        y0 y0Var9 = z0.f3558d;
                        if (j0.C(y0Var9.i(j4, obj), y0Var9.i(j4, obj2))) {
                            continue;
                        }
                    }
                    return false;
                case 9:
                    if (j(i4, obj, obj2)) {
                        y0 y0Var10 = z0.f3558d;
                        if (j0.C(y0Var10.i(j4, obj), y0Var10.i(j4, obj2))) {
                            continue;
                        }
                    }
                    return false;
                case 10:
                    if (j(i4, obj, obj2)) {
                        y0 y0Var11 = z0.f3558d;
                        if (j0.C(y0Var11.i(j4, obj), y0Var11.i(j4, obj2))) {
                            continue;
                        }
                    }
                    return false;
                case 11:
                    if (j(i4, obj, obj2)) {
                        y0 y0Var12 = z0.f3558d;
                        if (y0Var12.g(j4, obj) == y0Var12.g(j4, obj2)) {
                            continue;
                        }
                    }
                    return false;
                case 12:
                    if (j(i4, obj, obj2)) {
                        y0 y0Var13 = z0.f3558d;
                        if (y0Var13.g(j4, obj) == y0Var13.g(j4, obj2)) {
                            continue;
                        }
                    }
                    return false;
                case 13:
                    if (j(i4, obj, obj2)) {
                        y0 y0Var14 = z0.f3558d;
                        if (y0Var14.g(j4, obj) == y0Var14.g(j4, obj2)) {
                            continue;
                        }
                    }
                    return false;
                case 14:
                    if (j(i4, obj, obj2)) {
                        y0 y0Var15 = z0.f3558d;
                        if (y0Var15.h(j4, obj) == y0Var15.h(j4, obj2)) {
                            continue;
                        }
                    }
                    return false;
                case 15:
                    if (j(i4, obj, obj2)) {
                        y0 y0Var16 = z0.f3558d;
                        if (y0Var16.g(j4, obj) == y0Var16.g(j4, obj2)) {
                            continue;
                        }
                    }
                    return false;
                case 16:
                    if (j(i4, obj, obj2)) {
                        y0 y0Var17 = z0.f3558d;
                        if (y0Var17.h(j4, obj) == y0Var17.h(j4, obj2)) {
                            continue;
                        }
                    }
                    return false;
                case 17:
                    if (j(i4, obj, obj2)) {
                        y0 y0Var18 = z0.f3558d;
                        if (j0.C(y0Var18.i(j4, obj), y0Var18.i(j4, obj2))) {
                            continue;
                        }
                    }
                    return false;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    y0 y0Var19 = z0.f3558d;
                    zC = j0.C(y0Var19.i(j4, obj), y0Var19.i(j4, obj2));
                    break;
                case 50:
                    y0 y0Var20 = z0.f3558d;
                    zC = j0.C(y0Var20.i(j4, obj), y0Var20.i(j4, obj2));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case PoiResult.Contents.CITY_FIELD_NUMBER /* 59 */:
                case PoiResult.Contents.PROVINCE_FIELD_NUMBER /* 60 */:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long j5 = iArr[i4 + 2] & 1048575;
                    y0 y0Var21 = z0.f3558d;
                    if (y0Var21.g(j5, obj) != y0Var21.g(j5, obj2) || !j0.C(y0Var21.i(j4, obj), y0Var21.i(j4, obj2))) {
                        return false;
                    }
                    continue;
                    break;
                default:
            }
            if (!zC) {
                return false;
            }
        }
        this.f3457m.getClass();
        return ((A) obj).unknownFields.equals(((A) obj2).unknownFields);
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0262i0
    public final int g(Object obj) {
        return this.f3451g ? p(obj) : o(obj);
    }

    @Override // androidx.datastore.preferences.protobuf.InterfaceC0262i0
    public final Object h() {
        this.f3455k.getClass();
        return ((A) this.f3449e).d(4);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00e1 A[PHI: r3
      0x00e1: PHI (r3v32 int) = (r3v10 int), (r3v33 int) binds: [B:83:0x0216, B:41:0x00df] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.datastore.preferences.protobuf.InterfaceC0262i0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int i(java.lang.Object r12) {
        /*
            Method dump skipped, instructions count: 796
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Y.i(java.lang.Object):int");
    }

    public final boolean j(int i4, Object obj, Object obj2) {
        return q(i4, obj) == q(i4, obj2);
    }

    public final void k(Object obj, int i4, Object obj2) {
        int i5 = this.f3445a[i4];
        if (z0.f3558d.i(L(i4) & 1048575, obj) == null) {
            return;
        }
        l(i4);
    }

    public final void l(int i4) {
        B0.g.y(this.f3446b[((i4 / 3) * 2) + 1]);
    }

    public final Object m(int i4) {
        return this.f3446b[(i4 / 3) * 2];
    }

    public final InterfaceC0262i0 n(int i4) {
        int i5 = (i4 / 3) * 2;
        Object[] objArr = this.f3446b;
        InterfaceC0262i0 interfaceC0262i0 = (InterfaceC0262i0) objArr[i5];
        if (interfaceC0262i0 != null) {
            return interfaceC0262i0;
        }
        InterfaceC0262i0 interfaceC0262i0A = C0254e0.f3467c.a((Class) objArr[i5 + 1]);
        objArr[i5] = interfaceC0262i0A;
        return interfaceC0262i0A;
    }

    public final int o(Object obj) {
        int i4;
        int iN;
        int iL;
        int i5 = -1;
        int i6 = 0;
        int iA = 0;
        int i7 = 0;
        while (true) {
            int[] iArr = this.f3445a;
            if (i6 >= iArr.length) {
                this.f3457m.getClass();
                return ((A) obj).unknownFields.a() + iA;
            }
            int iL2 = L(i6);
            int i8 = iArr[i6];
            int iK = K(iL2);
            Unsafe unsafe = f3444p;
            if (iK <= 17) {
                int i9 = iArr[i6 + 2];
                int i10 = i9 & 1048575;
                i4 = 1 << (i9 >>> 20);
                if (i10 != i5) {
                    i7 = unsafe.getInt(obj, i10);
                    i5 = i10;
                }
            } else {
                i4 = 0;
            }
            long j4 = iL2 & 1048575;
            switch (iK) {
                case 0:
                    if ((i4 & i7) == 0) {
                        break;
                    } else {
                        iN = AbstractC0268o.n(i8);
                        iA += iN;
                        break;
                    }
                case 1:
                    if ((i4 & i7) == 0) {
                        break;
                    } else {
                        iN = AbstractC0268o.r(i8);
                        iA += iN;
                        break;
                    }
                case 2:
                    if ((i4 & i7) == 0) {
                        break;
                    } else {
                        iN = AbstractC0268o.v(i8, unsafe.getLong(obj, j4));
                        iA += iN;
                        break;
                    }
                case 3:
                    if ((i4 & i7) == 0) {
                        break;
                    } else {
                        iN = AbstractC0268o.F(i8, unsafe.getLong(obj, j4));
                        iA += iN;
                        break;
                    }
                case 4:
                    if ((i4 & i7) == 0) {
                        break;
                    } else {
                        iN = AbstractC0268o.t(i8, unsafe.getInt(obj, j4));
                        iA += iN;
                        break;
                    }
                case 5:
                    if ((i4 & i7) == 0) {
                        break;
                    } else {
                        iN = AbstractC0268o.q(i8);
                        iA += iN;
                        break;
                    }
                case 6:
                    if ((i4 & i7) == 0) {
                        break;
                    } else {
                        iN = AbstractC0268o.p(i8);
                        iA += iN;
                        break;
                    }
                case 7:
                    if ((i4 & i7) == 0) {
                        break;
                    } else {
                        iN = AbstractC0268o.k(i8);
                        iA += iN;
                        break;
                    }
                case 8:
                    if ((i4 & i7) == 0) {
                        break;
                    } else {
                        Object object = unsafe.getObject(obj, j4);
                        iL = object instanceof AbstractC0259h ? AbstractC0268o.l(i8, (AbstractC0259h) object) : AbstractC0268o.A(i8, (String) object);
                        iA = iL + iA;
                        break;
                    }
                case 9:
                    if ((i4 & i7) == 0) {
                        break;
                    } else {
                        iN = j0.o(i8, n(i6), unsafe.getObject(obj, j4));
                        iA += iN;
                        break;
                    }
                case 10:
                    if ((i4 & i7) == 0) {
                        break;
                    } else {
                        iN = AbstractC0268o.l(i8, (AbstractC0259h) unsafe.getObject(obj, j4));
                        iA += iN;
                        break;
                    }
                case 11:
                    if ((i4 & i7) == 0) {
                        break;
                    } else {
                        iN = AbstractC0268o.D(i8, unsafe.getInt(obj, j4));
                        iA += iN;
                        break;
                    }
                case 12:
                    if ((i4 & i7) == 0) {
                        break;
                    } else {
                        iN = AbstractC0268o.o(i8, unsafe.getInt(obj, j4));
                        iA += iN;
                        break;
                    }
                case 13:
                    if ((i4 & i7) == 0) {
                        break;
                    } else {
                        iN = AbstractC0268o.w(i8);
                        iA += iN;
                        break;
                    }
                case 14:
                    if ((i4 & i7) == 0) {
                        break;
                    } else {
                        iN = AbstractC0268o.x(i8);
                        iA += iN;
                        break;
                    }
                case 15:
                    if ((i4 & i7) == 0) {
                        break;
                    } else {
                        iN = AbstractC0268o.y(i8, unsafe.getInt(obj, j4));
                        iA += iN;
                        break;
                    }
                case 16:
                    if ((i4 & i7) == 0) {
                        break;
                    } else {
                        iN = AbstractC0268o.z(i8, unsafe.getLong(obj, j4));
                        iA += iN;
                        break;
                    }
                case 17:
                    if ((i4 & i7) == 0) {
                        break;
                    } else {
                        iN = AbstractC0268o.s(i8, (AbstractC0247b) unsafe.getObject(obj, j4), n(i6));
                        iA += iN;
                        break;
                    }
                case 18:
                    iN = j0.h(i8, (List) unsafe.getObject(obj, j4));
                    iA += iN;
                    break;
                case 19:
                    iN = j0.f(i8, (List) unsafe.getObject(obj, j4));
                    iA += iN;
                    break;
                case 20:
                    iN = j0.m(i8, (List) unsafe.getObject(obj, j4));
                    iA += iN;
                    break;
                case 21:
                    iN = j0.x(i8, (List) unsafe.getObject(obj, j4));
                    iA += iN;
                    break;
                case 22:
                    iN = j0.k(i8, (List) unsafe.getObject(obj, j4));
                    iA += iN;
                    break;
                case 23:
                    iN = j0.h(i8, (List) unsafe.getObject(obj, j4));
                    iA += iN;
                    break;
                case 24:
                    iN = j0.f(i8, (List) unsafe.getObject(obj, j4));
                    iA += iN;
                    break;
                case 25:
                    iN = j0.a(i8, (List) unsafe.getObject(obj, j4));
                    iA += iN;
                    break;
                case 26:
                    iN = j0.u(i8, (List) unsafe.getObject(obj, j4));
                    iA += iN;
                    break;
                case 27:
                    iN = j0.p(i8, (List) unsafe.getObject(obj, j4), n(i6));
                    iA += iN;
                    break;
                case 28:
                    iN = j0.c(i8, (List) unsafe.getObject(obj, j4));
                    iA += iN;
                    break;
                case 29:
                    iN = j0.v(i8, (List) unsafe.getObject(obj, j4));
                    iA += iN;
                    break;
                case 30:
                    iN = j0.d(i8, (List) unsafe.getObject(obj, j4));
                    iA += iN;
                    break;
                case 31:
                    iN = j0.f(i8, (List) unsafe.getObject(obj, j4));
                    iA += iN;
                    break;
                case 32:
                    iN = j0.h(i8, (List) unsafe.getObject(obj, j4));
                    iA += iN;
                    break;
                case 33:
                    iN = j0.q(i8, (List) unsafe.getObject(obj, j4));
                    iA += iN;
                    break;
                case 34:
                    iN = j0.s(i8, (List) unsafe.getObject(obj, j4));
                    iA += iN;
                    break;
                case 35:
                    int i11 = j0.i((List) unsafe.getObject(obj, j4));
                    if (i11 <= 0) {
                        break;
                    } else {
                        iA = B0.g.A(i11, AbstractC0268o.C(i8), i11, iA);
                        break;
                    }
                case 36:
                    int iG = j0.g((List) unsafe.getObject(obj, j4));
                    if (iG <= 0) {
                        break;
                    } else {
                        iA = B0.g.A(iG, AbstractC0268o.C(i8), iG, iA);
                        break;
                    }
                case 37:
                    int iN2 = j0.n((List) unsafe.getObject(obj, j4));
                    if (iN2 <= 0) {
                        break;
                    } else {
                        iA = B0.g.A(iN2, AbstractC0268o.C(i8), iN2, iA);
                        break;
                    }
                case 38:
                    int iY = j0.y((List) unsafe.getObject(obj, j4));
                    if (iY <= 0) {
                        break;
                    } else {
                        iA = B0.g.A(iY, AbstractC0268o.C(i8), iY, iA);
                        break;
                    }
                case 39:
                    int iL3 = j0.l((List) unsafe.getObject(obj, j4));
                    if (iL3 <= 0) {
                        break;
                    } else {
                        iA = B0.g.A(iL3, AbstractC0268o.C(i8), iL3, iA);
                        break;
                    }
                case 40:
                    int i12 = j0.i((List) unsafe.getObject(obj, j4));
                    if (i12 <= 0) {
                        break;
                    } else {
                        iA = B0.g.A(i12, AbstractC0268o.C(i8), i12, iA);
                        break;
                    }
                case 41:
                    int iG2 = j0.g((List) unsafe.getObject(obj, j4));
                    if (iG2 <= 0) {
                        break;
                    } else {
                        iA = B0.g.A(iG2, AbstractC0268o.C(i8), iG2, iA);
                        break;
                    }
                case 42:
                    int iB = j0.b((List) unsafe.getObject(obj, j4));
                    if (iB <= 0) {
                        break;
                    } else {
                        iA = B0.g.A(iB, AbstractC0268o.C(i8), iB, iA);
                        break;
                    }
                case 43:
                    int iW = j0.w((List) unsafe.getObject(obj, j4));
                    if (iW <= 0) {
                        break;
                    } else {
                        iA = B0.g.A(iW, AbstractC0268o.C(i8), iW, iA);
                        break;
                    }
                case 44:
                    int iE = j0.e((List) unsafe.getObject(obj, j4));
                    if (iE <= 0) {
                        break;
                    } else {
                        iA = B0.g.A(iE, AbstractC0268o.C(i8), iE, iA);
                        break;
                    }
                case 45:
                    int iG3 = j0.g((List) unsafe.getObject(obj, j4));
                    if (iG3 <= 0) {
                        break;
                    } else {
                        iA = B0.g.A(iG3, AbstractC0268o.C(i8), iG3, iA);
                        break;
                    }
                case 46:
                    int i13 = j0.i((List) unsafe.getObject(obj, j4));
                    if (i13 <= 0) {
                        break;
                    } else {
                        iA = B0.g.A(i13, AbstractC0268o.C(i8), i13, iA);
                        break;
                    }
                case 47:
                    int iR = j0.r((List) unsafe.getObject(obj, j4));
                    if (iR <= 0) {
                        break;
                    } else {
                        iA = B0.g.A(iR, AbstractC0268o.C(i8), iR, iA);
                        break;
                    }
                case 48:
                    int iT = j0.t((List) unsafe.getObject(obj, j4));
                    if (iT <= 0) {
                        break;
                    } else {
                        iA = B0.g.A(iT, AbstractC0268o.C(i8), iT, iA);
                        break;
                    }
                case 49:
                    iN = j0.j(i8, (List) unsafe.getObject(obj, j4), n(i6));
                    iA += iN;
                    break;
                case 50:
                    Object object2 = unsafe.getObject(obj, j4);
                    Object objM = m(i6);
                    this.f3458n.getClass();
                    iN = T.a(i8, object2, objM);
                    iA += iN;
                    break;
                case 51:
                    if (!r(i8, i6, obj)) {
                        break;
                    } else {
                        iN = AbstractC0268o.n(i8);
                        iA += iN;
                        break;
                    }
                case 52:
                    if (!r(i8, i6, obj)) {
                        break;
                    } else {
                        iN = AbstractC0268o.r(i8);
                        iA += iN;
                        break;
                    }
                case 53:
                    if (!r(i8, i6, obj)) {
                        break;
                    } else {
                        iN = AbstractC0268o.v(i8, B(j4, obj));
                        iA += iN;
                        break;
                    }
                case 54:
                    if (!r(i8, i6, obj)) {
                        break;
                    } else {
                        iN = AbstractC0268o.F(i8, B(j4, obj));
                        iA += iN;
                        break;
                    }
                case 55:
                    if (!r(i8, i6, obj)) {
                        break;
                    } else {
                        iN = AbstractC0268o.t(i8, A(j4, obj));
                        iA += iN;
                        break;
                    }
                case 56:
                    if (!r(i8, i6, obj)) {
                        break;
                    } else {
                        iN = AbstractC0268o.q(i8);
                        iA += iN;
                        break;
                    }
                case 57:
                    if (!r(i8, i6, obj)) {
                        break;
                    } else {
                        iN = AbstractC0268o.p(i8);
                        iA += iN;
                        break;
                    }
                case 58:
                    if (!r(i8, i6, obj)) {
                        break;
                    } else {
                        iN = AbstractC0268o.k(i8);
                        iA += iN;
                        break;
                    }
                case PoiResult.Contents.CITY_FIELD_NUMBER /* 59 */:
                    if (!r(i8, i6, obj)) {
                        break;
                    } else {
                        Object object3 = unsafe.getObject(obj, j4);
                        iL = object3 instanceof AbstractC0259h ? AbstractC0268o.l(i8, (AbstractC0259h) object3) : AbstractC0268o.A(i8, (String) object3);
                        iA = iL + iA;
                        break;
                    }
                case PoiResult.Contents.PROVINCE_FIELD_NUMBER /* 60 */:
                    if (!r(i8, i6, obj)) {
                        break;
                    } else {
                        iN = j0.o(i8, n(i6), unsafe.getObject(obj, j4));
                        iA += iN;
                        break;
                    }
                case 61:
                    if (!r(i8, i6, obj)) {
                        break;
                    } else {
                        iN = AbstractC0268o.l(i8, (AbstractC0259h) unsafe.getObject(obj, j4));
                        iA += iN;
                        break;
                    }
                case 62:
                    if (!r(i8, i6, obj)) {
                        break;
                    } else {
                        iN = AbstractC0268o.D(i8, A(j4, obj));
                        iA += iN;
                        break;
                    }
                case 63:
                    if (!r(i8, i6, obj)) {
                        break;
                    } else {
                        iN = AbstractC0268o.o(i8, A(j4, obj));
                        iA += iN;
                        break;
                    }
                case 64:
                    if (!r(i8, i6, obj)) {
                        break;
                    } else {
                        iN = AbstractC0268o.w(i8);
                        iA += iN;
                        break;
                    }
                case 65:
                    if (!r(i8, i6, obj)) {
                        break;
                    } else {
                        iN = AbstractC0268o.x(i8);
                        iA += iN;
                        break;
                    }
                case 66:
                    if (!r(i8, i6, obj)) {
                        break;
                    } else {
                        iN = AbstractC0268o.y(i8, A(j4, obj));
                        iA += iN;
                        break;
                    }
                case 67:
                    if (!r(i8, i6, obj)) {
                        break;
                    } else {
                        iN = AbstractC0268o.z(i8, B(j4, obj));
                        iA += iN;
                        break;
                    }
                case 68:
                    if (!r(i8, i6, obj)) {
                        break;
                    } else {
                        iN = AbstractC0268o.s(i8, (AbstractC0247b) unsafe.getObject(obj, j4), n(i6));
                        iA += iN;
                        break;
                    }
            }
            i6 += 3;
        }
    }

    public final int p(Object obj) {
        int iN;
        int i4 = 0;
        int iA = 0;
        while (true) {
            int[] iArr = this.f3445a;
            if (i4 >= iArr.length) {
                this.f3457m.getClass();
                return ((A) obj).unknownFields.a() + iA;
            }
            int iL = L(i4);
            int iK = K(iL);
            int i5 = iArr[i4];
            long j4 = iL & 1048575;
            if (iK >= EnumC0274v.f3543b.a() && iK <= EnumC0274v.f3544c.a()) {
                int i6 = iArr[i4 + 2];
            }
            Unsafe unsafe = f3444p;
            switch (iK) {
                case 0:
                    if (q(i4, obj)) {
                        iN = AbstractC0268o.n(i5);
                        break;
                    } else {
                        i4 += 3;
                    }
                case 1:
                    if (q(i4, obj)) {
                        iN = AbstractC0268o.r(i5);
                        break;
                    } else {
                        i4 += 3;
                    }
                case 2:
                    if (q(i4, obj)) {
                        iN = AbstractC0268o.v(i5, z0.j(j4, obj));
                        break;
                    } else {
                        i4 += 3;
                    }
                case 3:
                    if (q(i4, obj)) {
                        iN = AbstractC0268o.F(i5, z0.j(j4, obj));
                        break;
                    } else {
                        i4 += 3;
                    }
                case 4:
                    if (q(i4, obj)) {
                        iN = AbstractC0268o.t(i5, z0.i(j4, obj));
                        break;
                    } else {
                        i4 += 3;
                    }
                case 5:
                    if (q(i4, obj)) {
                        iN = AbstractC0268o.q(i5);
                        break;
                    } else {
                        i4 += 3;
                    }
                case 6:
                    if (q(i4, obj)) {
                        iN = AbstractC0268o.p(i5);
                        break;
                    } else {
                        i4 += 3;
                    }
                case 7:
                    if (q(i4, obj)) {
                        iN = AbstractC0268o.k(i5);
                        break;
                    } else {
                        i4 += 3;
                    }
                case 8:
                    if (q(i4, obj)) {
                        Object objK = z0.k(j4, obj);
                        if (!(objK instanceof AbstractC0259h)) {
                            iN = AbstractC0268o.A(i5, (String) objK);
                            break;
                        } else {
                            iN = AbstractC0268o.l(i5, (AbstractC0259h) objK);
                            break;
                        }
                    } else {
                        i4 += 3;
                    }
                case 9:
                    if (q(i4, obj)) {
                        iN = j0.o(i5, n(i4), z0.k(j4, obj));
                        break;
                    } else {
                        i4 += 3;
                    }
                case 10:
                    if (q(i4, obj)) {
                        iN = AbstractC0268o.l(i5, (AbstractC0259h) z0.k(j4, obj));
                        break;
                    } else {
                        i4 += 3;
                    }
                case 11:
                    if (q(i4, obj)) {
                        iN = AbstractC0268o.D(i5, z0.i(j4, obj));
                        break;
                    } else {
                        i4 += 3;
                    }
                case 12:
                    if (q(i4, obj)) {
                        iN = AbstractC0268o.o(i5, z0.i(j4, obj));
                        break;
                    } else {
                        i4 += 3;
                    }
                case 13:
                    if (q(i4, obj)) {
                        iN = AbstractC0268o.w(i5);
                        break;
                    } else {
                        i4 += 3;
                    }
                case 14:
                    if (q(i4, obj)) {
                        iN = AbstractC0268o.x(i5);
                        break;
                    } else {
                        i4 += 3;
                    }
                case 15:
                    if (q(i4, obj)) {
                        iN = AbstractC0268o.y(i5, z0.i(j4, obj));
                        break;
                    } else {
                        i4 += 3;
                    }
                case 16:
                    if (q(i4, obj)) {
                        iN = AbstractC0268o.z(i5, z0.j(j4, obj));
                        break;
                    } else {
                        i4 += 3;
                    }
                case 17:
                    if (q(i4, obj)) {
                        iN = AbstractC0268o.s(i5, (AbstractC0247b) z0.k(j4, obj), n(i4));
                        break;
                    } else {
                        i4 += 3;
                    }
                case 18:
                    iN = j0.h(i5, s(j4, obj));
                    break;
                case 19:
                    iN = j0.f(i5, s(j4, obj));
                    break;
                case 20:
                    iN = j0.m(i5, s(j4, obj));
                    break;
                case 21:
                    iN = j0.x(i5, s(j4, obj));
                    break;
                case 22:
                    iN = j0.k(i5, s(j4, obj));
                    break;
                case 23:
                    iN = j0.h(i5, s(j4, obj));
                    break;
                case 24:
                    iN = j0.f(i5, s(j4, obj));
                    break;
                case 25:
                    iN = j0.a(i5, s(j4, obj));
                    break;
                case 26:
                    iN = j0.u(i5, s(j4, obj));
                    break;
                case 27:
                    iN = j0.p(i5, s(j4, obj), n(i4));
                    break;
                case 28:
                    iN = j0.c(i5, s(j4, obj));
                    break;
                case 29:
                    iN = j0.v(i5, s(j4, obj));
                    break;
                case 30:
                    iN = j0.d(i5, s(j4, obj));
                    break;
                case 31:
                    iN = j0.f(i5, s(j4, obj));
                    break;
                case 32:
                    iN = j0.h(i5, s(j4, obj));
                    break;
                case 33:
                    iN = j0.q(i5, s(j4, obj));
                    break;
                case 34:
                    iN = j0.s(i5, s(j4, obj));
                    break;
                case 35:
                    int i7 = j0.i((List) unsafe.getObject(obj, j4));
                    if (i7 > 0) {
                        iA = B0.g.A(i7, AbstractC0268o.C(i5), i7, iA);
                    } else {
                        continue;
                    }
                    i4 += 3;
                case 36:
                    int iG = j0.g((List) unsafe.getObject(obj, j4));
                    if (iG > 0) {
                        iA = B0.g.A(iG, AbstractC0268o.C(i5), iG, iA);
                    } else {
                        continue;
                    }
                    i4 += 3;
                case 37:
                    int iN2 = j0.n((List) unsafe.getObject(obj, j4));
                    if (iN2 > 0) {
                        iA = B0.g.A(iN2, AbstractC0268o.C(i5), iN2, iA);
                    } else {
                        continue;
                    }
                    i4 += 3;
                case 38:
                    int iY = j0.y((List) unsafe.getObject(obj, j4));
                    if (iY > 0) {
                        iA = B0.g.A(iY, AbstractC0268o.C(i5), iY, iA);
                    } else {
                        continue;
                    }
                    i4 += 3;
                case 39:
                    int iL2 = j0.l((List) unsafe.getObject(obj, j4));
                    if (iL2 > 0) {
                        iA = B0.g.A(iL2, AbstractC0268o.C(i5), iL2, iA);
                    } else {
                        continue;
                    }
                    i4 += 3;
                case 40:
                    int i8 = j0.i((List) unsafe.getObject(obj, j4));
                    if (i8 > 0) {
                        iA = B0.g.A(i8, AbstractC0268o.C(i5), i8, iA);
                    } else {
                        continue;
                    }
                    i4 += 3;
                case 41:
                    int iG2 = j0.g((List) unsafe.getObject(obj, j4));
                    if (iG2 > 0) {
                        iA = B0.g.A(iG2, AbstractC0268o.C(i5), iG2, iA);
                    } else {
                        continue;
                    }
                    i4 += 3;
                case 42:
                    int iB = j0.b((List) unsafe.getObject(obj, j4));
                    if (iB > 0) {
                        iA = B0.g.A(iB, AbstractC0268o.C(i5), iB, iA);
                    } else {
                        continue;
                    }
                    i4 += 3;
                case 43:
                    int iW = j0.w((List) unsafe.getObject(obj, j4));
                    if (iW > 0) {
                        iA = B0.g.A(iW, AbstractC0268o.C(i5), iW, iA);
                    } else {
                        continue;
                    }
                    i4 += 3;
                case 44:
                    int iE = j0.e((List) unsafe.getObject(obj, j4));
                    if (iE > 0) {
                        iA = B0.g.A(iE, AbstractC0268o.C(i5), iE, iA);
                    } else {
                        continue;
                    }
                    i4 += 3;
                case 45:
                    int iG3 = j0.g((List) unsafe.getObject(obj, j4));
                    if (iG3 > 0) {
                        iA = B0.g.A(iG3, AbstractC0268o.C(i5), iG3, iA);
                    } else {
                        continue;
                    }
                    i4 += 3;
                case 46:
                    int i9 = j0.i((List) unsafe.getObject(obj, j4));
                    if (i9 > 0) {
                        iA = B0.g.A(i9, AbstractC0268o.C(i5), i9, iA);
                    } else {
                        continue;
                    }
                    i4 += 3;
                case 47:
                    int iR = j0.r((List) unsafe.getObject(obj, j4));
                    if (iR > 0) {
                        iA = B0.g.A(iR, AbstractC0268o.C(i5), iR, iA);
                    } else {
                        continue;
                    }
                    i4 += 3;
                case 48:
                    int iT = j0.t((List) unsafe.getObject(obj, j4));
                    if (iT > 0) {
                        iA = B0.g.A(iT, AbstractC0268o.C(i5), iT, iA);
                    } else {
                        continue;
                    }
                    i4 += 3;
                case 49:
                    iN = j0.j(i5, s(j4, obj), n(i4));
                    break;
                case 50:
                    Object objK2 = z0.k(j4, obj);
                    Object objM = m(i4);
                    this.f3458n.getClass();
                    iN = T.a(i5, objK2, objM);
                    break;
                case 51:
                    if (r(i5, i4, obj)) {
                        iN = AbstractC0268o.n(i5);
                        break;
                    } else {
                        i4 += 3;
                    }
                case 52:
                    if (r(i5, i4, obj)) {
                        iN = AbstractC0268o.r(i5);
                        break;
                    } else {
                        i4 += 3;
                    }
                case 53:
                    if (r(i5, i4, obj)) {
                        iN = AbstractC0268o.v(i5, B(j4, obj));
                        break;
                    } else {
                        i4 += 3;
                    }
                case 54:
                    if (r(i5, i4, obj)) {
                        iN = AbstractC0268o.F(i5, B(j4, obj));
                        break;
                    } else {
                        i4 += 3;
                    }
                case 55:
                    if (r(i5, i4, obj)) {
                        iN = AbstractC0268o.t(i5, A(j4, obj));
                        break;
                    } else {
                        i4 += 3;
                    }
                case 56:
                    if (r(i5, i4, obj)) {
                        iN = AbstractC0268o.q(i5);
                        break;
                    } else {
                        i4 += 3;
                    }
                case 57:
                    if (r(i5, i4, obj)) {
                        iN = AbstractC0268o.p(i5);
                        break;
                    } else {
                        i4 += 3;
                    }
                case 58:
                    if (r(i5, i4, obj)) {
                        iN = AbstractC0268o.k(i5);
                        break;
                    } else {
                        i4 += 3;
                    }
                case PoiResult.Contents.CITY_FIELD_NUMBER /* 59 */:
                    if (r(i5, i4, obj)) {
                        Object objK3 = z0.k(j4, obj);
                        if (!(objK3 instanceof AbstractC0259h)) {
                            iN = AbstractC0268o.A(i5, (String) objK3);
                            break;
                        } else {
                            iN = AbstractC0268o.l(i5, (AbstractC0259h) objK3);
                            break;
                        }
                    } else {
                        i4 += 3;
                    }
                case PoiResult.Contents.PROVINCE_FIELD_NUMBER /* 60 */:
                    if (r(i5, i4, obj)) {
                        iN = j0.o(i5, n(i4), z0.k(j4, obj));
                        break;
                    } else {
                        i4 += 3;
                    }
                case 61:
                    if (r(i5, i4, obj)) {
                        iN = AbstractC0268o.l(i5, (AbstractC0259h) z0.k(j4, obj));
                        break;
                    } else {
                        i4 += 3;
                    }
                case 62:
                    if (r(i5, i4, obj)) {
                        iN = AbstractC0268o.D(i5, A(j4, obj));
                        break;
                    } else {
                        i4 += 3;
                    }
                case 63:
                    if (r(i5, i4, obj)) {
                        iN = AbstractC0268o.o(i5, A(j4, obj));
                        break;
                    } else {
                        i4 += 3;
                    }
                case 64:
                    if (r(i5, i4, obj)) {
                        iN = AbstractC0268o.w(i5);
                        break;
                    } else {
                        i4 += 3;
                    }
                case 65:
                    if (r(i5, i4, obj)) {
                        iN = AbstractC0268o.x(i5);
                        break;
                    } else {
                        i4 += 3;
                    }
                case 66:
                    if (r(i5, i4, obj)) {
                        iN = AbstractC0268o.y(i5, A(j4, obj));
                        break;
                    } else {
                        i4 += 3;
                    }
                case 67:
                    if (r(i5, i4, obj)) {
                        iN = AbstractC0268o.z(i5, B(j4, obj));
                        break;
                    } else {
                        i4 += 3;
                    }
                case 68:
                    if (r(i5, i4, obj)) {
                        iN = AbstractC0268o.s(i5, (AbstractC0247b) z0.k(j4, obj), n(i4));
                        break;
                    } else {
                        i4 += 3;
                    }
                default:
                    i4 += 3;
            }
            iA = iN + iA;
            i4 += 3;
        }
    }

    public final boolean q(int i4, Object obj) {
        if (!this.f3451g) {
            int i5 = this.f3445a[i4 + 2];
            return (z0.f3558d.g((long) (i5 & 1048575), obj) & (1 << (i5 >>> 20))) != 0;
        }
        int iL = L(i4);
        long j4 = iL & 1048575;
        switch (K(iL)) {
            case 0:
                return z0.f3558d.e(j4, obj) != 0.0d;
            case 1:
                return z0.f3558d.f(j4, obj) != Property.DEFAULT_FLOAT_VALUE;
            case 2:
                return z0.f3558d.h(j4, obj) != 0;
            case 3:
                return z0.f3558d.h(j4, obj) != 0;
            case 4:
                return z0.f3558d.g(j4, obj) != 0;
            case 5:
                return z0.f3558d.h(j4, obj) != 0;
            case 6:
                return z0.f3558d.g(j4, obj) != 0;
            case 7:
                return z0.f3558d.c(j4, obj);
            case 8:
                Object objI = z0.f3558d.i(j4, obj);
                if (objI instanceof String) {
                    return !((String) objI).isEmpty();
                }
                if (objI instanceof AbstractC0259h) {
                    return !AbstractC0259h.f3480b.equals(objI);
                }
                throw new IllegalArgumentException();
            case 9:
                return z0.f3558d.i(j4, obj) != null;
            case 10:
                return !AbstractC0259h.f3480b.equals(z0.f3558d.i(j4, obj));
            case 11:
                return z0.f3558d.g(j4, obj) != 0;
            case 12:
                return z0.f3558d.g(j4, obj) != 0;
            case 13:
                return z0.f3558d.g(j4, obj) != 0;
            case 14:
                return z0.f3558d.h(j4, obj) != 0;
            case 15:
                return z0.f3558d.g(j4, obj) != 0;
            case 16:
                return z0.f3558d.h(j4, obj) != 0;
            case 17:
                return z0.f3558d.i(j4, obj) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    public final boolean r(int i4, int i5, Object obj) {
        return z0.f3558d.g((long) (this.f3445a[i5 + 2] & 1048575), obj) == i4;
    }

    /* JADX WARN: Removed duplicated region for block: B:134:0x05f1 A[Catch: all -> 0x024d, TryCatch #3 {all -> 0x024d, blocks: (B:132:0x05ec, B:134:0x05f1, B:136:0x05f8, B:138:0x05ff, B:73:0x0248, B:76:0x0250, B:77:0x0260, B:78:0x0270, B:79:0x0280, B:80:0x0290, B:81:0x02a6, B:82:0x02b6, B:83:0x02c6, B:84:0x02d6, B:85:0x02e6, B:86:0x02f6, B:87:0x0306, B:88:0x0316, B:89:0x0326, B:90:0x0336, B:91:0x0346, B:92:0x0356, B:93:0x0366, B:94:0x0376, B:95:0x038c, B:96:0x039c, B:97:0x03ac, B:98:0x03c0, B:99:0x03c8, B:100:0x03d8, B:101:0x03e8, B:102:0x03f8, B:103:0x0408, B:104:0x0418, B:105:0x0428, B:106:0x0438, B:107:0x0448, B:109:0x0451, B:110:0x046e, B:111:0x0482, B:112:0x0495, B:113:0x04a8, B:114:0x04bb, B:115:0x04ce, B:116:0x04e4, B:117:0x04f7, B:118:0x050a, B:120:0x0513, B:121:0x0530, B:122:0x0544, B:123:0x054f, B:124:0x0564, B:125:0x0577, B:126:0x058a, B:127:0x059d, B:128:0x05b0, B:129:0x05c2, B:130:0x05d6), top: B:160:0x05ec }] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0605 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t(androidx.datastore.preferences.protobuf.r0 r18, java.lang.Object r19, androidx.datastore.preferences.protobuf.InterfaceC0260h0 r20, androidx.datastore.preferences.protobuf.r r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1730
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Y.t(androidx.datastore.preferences.protobuf.r0, java.lang.Object, androidx.datastore.preferences.protobuf.h0, androidx.datastore.preferences.protobuf.r):void");
    }

    public final void u(Object obj, int i4, Object obj2, r rVar, InterfaceC0260h0 interfaceC0260h0) {
        long jL = L(i4) & 1048575;
        Object objI = z0.f3558d.i(jL, obj);
        T t4 = this.f3458n;
        if (objI == null) {
            t4.getClass();
            objI = S.f3437b.b();
            z0.r(jL, obj, objI);
        } else {
            t4.getClass();
            if (!((S) objI).f3438a) {
                S sB = S.f3437b.b();
                T.b(sB, objI);
                z0.r(jL, obj, sB);
                objI = sB;
            }
        }
        t4.getClass();
        interfaceC0260h0.d((S) objI, ((Q) obj2).f3434a, rVar);
    }

    public final void v(int i4, Object obj, Object obj2) {
        long jL = L(i4) & 1048575;
        if (q(i4, obj2)) {
            y0 y0Var = z0.f3558d;
            Object objI = y0Var.i(jL, obj);
            Object objI2 = y0Var.i(jL, obj2);
            if (objI != null && objI2 != null) {
                z0.r(jL, obj, D.c(objI, objI2));
                I(i4, obj);
            } else if (objI2 != null) {
                z0.r(jL, obj, objI2);
                I(i4, obj);
            }
        }
    }

    public final void w(int i4, Object obj, Object obj2) {
        int iL = L(i4);
        int i5 = this.f3445a[i4];
        long j4 = iL & 1048575;
        if (r(i5, i4, obj2)) {
            y0 y0Var = z0.f3558d;
            Object objI = y0Var.i(j4, obj);
            Object objI2 = y0Var.i(j4, obj2);
            if (objI != null && objI2 != null) {
                z0.r(j4, obj, D.c(objI, objI2));
                J(i5, i4, obj);
            } else if (objI2 != null) {
                z0.r(j4, obj, objI2);
                J(i5, i4, obj);
            }
        }
    }
}

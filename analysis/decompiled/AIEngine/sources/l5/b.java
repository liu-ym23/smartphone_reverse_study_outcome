package l5;

import com.stepos.core.ota.crypto.FekEnvelope;
import java.util.HashMap;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    public static final HashMap<String, b> f10235c;

    /* renamed from: d, reason: collision with root package name */
    public static final HashMap<String, b> f10236d;

    /* renamed from: a, reason: collision with root package name */
    public final int f10237a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f10238b;

    static {
        int[] iArr = {48, 57};
        int[] iArr2 = {9, 10, 12, 13, 32, 32};
        int[] iArr3 = {48, 57, 65, 90, 95, 95, 97, FekEnvelope.EXPECTED_EPK_CHARS};
        HashMap<String, b> map = new HashMap<>();
        f10235c = map;
        map.put("\\d", new b(iArr, 1));
        map.put("\\D", new b(iArr, -1));
        map.put("\\s", new b(iArr2, 1));
        map.put("\\S", new b(iArr2, -1));
        map.put("\\w", new b(iArr3, 1));
        map.put("\\W", new b(iArr3, -1));
        int[] iArr4 = {48, 57, 65, 90, 97, FekEnvelope.EXPECTED_EPK_CHARS};
        int[] iArr5 = {65, 90, 97, FekEnvelope.EXPECTED_EPK_CHARS};
        int[] iArr6 = {0, 127};
        int[] iArr7 = {9, 9, 32, 32};
        int[] iArr8 = {0, 31, 127, 127};
        int[] iArr9 = {48, 57};
        int[] iArr10 = {33, 126};
        int[] iArr11 = {97, FekEnvelope.EXPECTED_EPK_CHARS};
        int[] iArr12 = {32, 126};
        int[] iArr13 = {33, 47, 58, 64, 91, 96, 123, 126};
        int[] iArr14 = {9, 13, 32, 32};
        int[] iArr15 = {65, 90};
        int[] iArr16 = {48, 57, 65, 90, 95, 95, 97, FekEnvelope.EXPECTED_EPK_CHARS};
        int[] iArr17 = {48, 57, 65, 70, 97, 102};
        HashMap<String, b> map2 = new HashMap<>();
        f10236d = map2;
        map2.put("[:alnum:]", new b(iArr4, 1));
        map2.put("[:^alnum:]", new b(iArr4, -1));
        map2.put("[:alpha:]", new b(iArr5, 1));
        map2.put("[:^alpha:]", new b(iArr5, -1));
        map2.put("[:ascii:]", new b(iArr6, 1));
        map2.put("[:^ascii:]", new b(iArr6, -1));
        map2.put("[:blank:]", new b(iArr7, 1));
        map2.put("[:^blank:]", new b(iArr7, -1));
        map2.put("[:cntrl:]", new b(iArr8, 1));
        map2.put("[:^cntrl:]", new b(iArr8, -1));
        map2.put("[:digit:]", new b(iArr9, 1));
        map2.put("[:^digit:]", new b(iArr9, -1));
        map2.put("[:graph:]", new b(iArr10, 1));
        map2.put("[:^graph:]", new b(iArr10, -1));
        map2.put("[:lower:]", new b(iArr11, 1));
        map2.put("[:^lower:]", new b(iArr11, -1));
        map2.put("[:print:]", new b(iArr12, 1));
        map2.put("[:^print:]", new b(iArr12, -1));
        map2.put("[:punct:]", new b(iArr13, 1));
        map2.put("[:^punct:]", new b(iArr13, -1));
        map2.put("[:space:]", new b(iArr14, 1));
        map2.put("[:^space:]", new b(iArr14, -1));
        map2.put("[:upper:]", new b(iArr15, 1));
        map2.put("[:^upper:]", new b(iArr15, -1));
        map2.put("[:word:]", new b(iArr16, 1));
        map2.put("[:^word:]", new b(iArr16, -1));
        map2.put("[:xdigit:]", new b(iArr17, 1));
        map2.put("[:^xdigit:]", new b(iArr17, -1));
    }

    public b(int[] iArr, int i10) {
        this.f10237a = i10;
        this.f10238b = iArr;
    }
}

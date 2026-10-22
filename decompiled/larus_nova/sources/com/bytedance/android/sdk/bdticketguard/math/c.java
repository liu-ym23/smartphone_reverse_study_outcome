package com.bytedance.android.sdk.bdticketguard.math;

import android.util.Base64;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes12.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f163966a = 0;

    static {
    }

    public static byte[] a(List r110) {
        Iterator r100 = r110.iterator();
        int r101 = 0;
        int r102 = 0;
    L4:
        if (r100.hasNext() == false) goto L6;
        r102 = r102 + ((byte[]) r100.next()).length;
        goto L4
    L6:
        byte[] r103 = new byte[r102];
        Iterator r111 = r110.iterator();
    L8:
        if (r111.hasNext() == false) goto L10;
        byte[] r104 = (byte[]) r111.next();
        ArraysKt.copyInto$default(r104, r103, r101, 0, 0, 12, null);
        r101 = r101 + r104.length;
        goto L8
    L10:
        return r103;
    }

    public static byte[] b(String r210) {
        List r100 = StringsKt.split$default(r210, new char[]{'.'}, false, 0, 6, null);
        int r101 = 10;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r102.add(Long.valueOf(CastLongProtector.parseLong((String) r103.next())));
        goto L4
    L6:
        int r104 = 2;
        if (r102.size() < 2) goto L9;
        boolean r105 = true;
    L10:
        if (r105 == false) goto L52;
        long r106 = ((Number) ListProtector.get(r102, 0)).longValue();
        long r107 = ((Number) ListProtector.get(r102, 1)).longValue();
        long r110 = 2;
        if (0 <= r106) goto L15;
    L17:
        boolean r108 = false;
    L18:
        if (r108 == false) goto L50;
        long r111 = 39;
        if (0 > r107) goto L24;
        if (r111 < r107) goto L24;
    L25:
        boolean r109 = true;
    L27:
        if (r109 == false) goto L48;
        ByteArrayOutputStream r112 = new ByteArrayOutputStream();
        r112.write((int) ((r106 * ((long) 40)) + r107));
        int r113 = r102.size();
    L29:
        if (r104 >= r113) goto L46;
        long r114 = ((Number) ListProtector.get(r102, r104)).longValue();
        if (r114 < 0) goto L33;
        boolean r115 = true;
    L34:
        if (r115 == false) goto L44;
        ArrayList r116 = new ArrayList(r101);
        long r117 = 127;
        int r118 = r104;
        r116.add(Integer.valueOf((int) (r114 & 127)));
        long r119 = r114 >>> 7;
    L37:
        if (r119 == 0) goto L39;
        r116.add(Integer.valueOf((int) ((r119 & r117) | 128)));
        r119 = r119 >>> 7;
        r117 = 127;
        goto L37
    L39:
        int r120 = r116.size() - 1;
    L40:
        if (r120 < 0) goto L42;
        r112.write(((Number) ListProtector.get(r116, r120)).intValue());
        r120 = r120 - 1;
        goto L40
    L42:
        r104 = r118 + 1;
        r101 = 10;
        goto L29
    L44:
        throw new IllegalArgumentException("Invalid OID arc: ".concat(r210).toString());
    L33:
        r115 = false;
        goto L34
    L46:
        return e(6, r112.toByteArray());
    L48:
        throw new IllegalArgumentException("Invalid OID second arc: ".concat(r210).toString());
    L24:
        if (r106 == 2) goto L25;
        r109 = false;
        goto L27
    L50:
        throw new IllegalArgumentException("Invalid OID first arc: ".concat(r210).toString());
    L15:
        if (r110 < r106) goto L17;
        r108 = true;
        goto L18
    L52:
        throw new IllegalArgumentException("Invalid OID: ".concat(r210).toString());
    L9:
        r105 = false;
        goto L10
    }

    public static byte[] d(byte[]... r100) {
        return e(48, a(ArraysKt.toList(r100)));
    }

    public static String c(String r100, byte[] r101) {
        String r102 = Base64.encodeToString(r101, 2);
        StringBuilder r103 = new StringBuilder("-----BEGIN ");
        r103.append(r100);
        r103.append("-----\n");
        int r104 = 0;
    L4:
        if (r104 >= r102.length()) goto L6;
        int r105 = Math.min(r104 + 64, r102.length());
        r103.append(r102, r104, r105);
        r103.append("\n");
        r104 = r105;
        goto L4
    L6:
        r103.append("-----END ");
        r103.append(r100);
        r103.append("-----\n");
        return r103.toString();
    }

    public static byte[] e(int r110, byte[] r111) {
        int r100 = r111.length;
        if (r100 < 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L19;
        if (r100 >= 128) goto L10;
        byte[] r102 = {(byte) r100};
    L16:
        byte[] r103 = new byte[(r102.length + 1) + r111.length];
        r103[0] = (byte) (r110 & 255);
        ArraysKt.copyInto$default(r102, r103, 1, 0, 0, 12, null);
        ArraysKt.copyInto$default(r111, r103, r102.length + 1, 0, 0, 12, null);
        return r103;
    L10:
        int r104 = r100;
        int r105 = 0;
    L11:
        if (r104 == 0) goto L13;
        r105 = r105 + 1;
        r104 = r104 >>> 8;
        goto L11
    L13:
        r102 = new byte[r105 + 1];
        r102[0] = (byte) (r105 | 128);
        int r106 = 0;
    L14:
        if (r106 >= r105) goto L16;
        r102[r105 - r106] = (byte) ((r100 >>> (r106 * 8)) & 255);
        r106 = r106 + 1;
        goto L14
    L19:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r101 = false;
        goto L6
    }
}

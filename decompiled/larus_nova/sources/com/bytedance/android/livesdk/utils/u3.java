package com.bytedance.android.livesdk.utils;

import android.text.Editable;

/* JADX INFO: loaded from: classes11.dex */
public final class u3 {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f159177a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f159178b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f159179c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f159180d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f159181e;

        public a() {
        }

        public final String toString() {
            return "InputCheckResult{validEndIndex=" + this.f159177a + ", totalCount=" + this.f159178b + ", emojiCount=" + this.f159179c + ", liveEmojiCount=" + this.f159180d + ", length=" + this.f159181e + '}';
        }
    }

    public static a a(Editable r110, int r111) {
        if (r110 == null) goto L41;
        String r100 = r110.toString();
        int r101 = 0;
        e90.a[] r102 = (e90.a[]) r110.getSpans(0, r100.length(), e90.a.class);
        if (r102 != null) goto L7;
    L9:
        e90.a r103 = null;
        int r104 = 0;
    L10:
        char[] r105 = r100.toCharArray();
        int r112 = r104;
        int r106 = 0;
        int r107 = 0;
        int r108 = 0;
        int r109 = 0;
        int r113 = 0;
    L12:
        if (r101 >= r100.length()) goto L34;
        if (l1.b(r105[r101]) == false) goto L21;
        int r114 = r101 + 1;
        if (r114 < r100.length()) goto L18;
    L20:
        r101 = r114;
    L32:
        if (r108 > r111) goto L12;
        r109 = r101;
        goto L12
    L18:
        if (l1.b(r105[r114]) == false) goto L20;
        r108 = r108 + 1;
        r106 = r106 + 1;
        r101 = r101 + 2;
        goto L32
    L21:
        if (r103 == null) goto L31;
        if (r101 != r112) goto L31;
        r108 = r108 + 1;
        r107 = r107 + 1;
        if (r103.getDesc() == null) goto L26;
        r101 = r101 + r103.getDesc().length();
    L27:
        r113 = r113 + 1;
        if (r113 >= r102.length) goto L30;
        r103 = r102[r113];
        r112 = r110.getSpanStart(r103);
        goto L32
    L30:
        r103 = null;
        goto L32
    L26:
        r101 = r101 + 4;
    L31:
        r108 = r108 + 1;
        r101 = r101 + 1;
        goto L32
    L34:
        a r115 = new a();
        r115.f159179c = r106;
        r115.f159180d = r107;
        r115.f159181e = r100.length();
        r115.f159178b = r108;
        r115.f159177a = r109;
        return r115;
    L7:
        if (r102.length <= 0) goto L9;
        r103 = r102[0];
        r104 = r110.getSpanStart(r103);
        goto L10
    L41:
        return null;
    }
}

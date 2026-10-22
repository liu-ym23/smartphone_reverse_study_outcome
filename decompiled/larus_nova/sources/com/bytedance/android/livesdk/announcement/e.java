package com.bytedance.android.livesdk.announcement;

import android.text.InputFilter;
import android.text.Spanned;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes7.dex */
public final class e implements InputFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f103360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c1 f103361b;

    public e(int r100, z r101) {
        this.f103360a = r100;
        this.f103361b = r101;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence r100, int r101, int r102, Spanned r103, int r104, int r110) {
        if (r100 == null) goto L31;
        if (r103 == null) goto L33;
        int r105 = this.f103360a - (r103.length() - (r110 - r104));
        boolean r106 = false;
        if (r105 > 0) goto L16;
        if (r100.length() <= 0) goto L11;
        r106 = true;
    L11:
        if (r106 == false) goto L32;
        c1 r107 = this.f103361b;
        if (r107 == null) goto L32;
        r107.a();
    L32:
        return "";
    L16:
        if (StringsKt.contains$default(r100.toString(), '\n', false, 2, null) == true) goto L32;
        if (r105 >= (r102 - r101)) goto L34;
        int r108 = r105 + r101;
        if (Character.isHighSurrogate(r100.charAt(r108 - 1)) == false) goto L26;
        r108 = r108 - 1;
        if (r108 != r101) goto L26;
        return "";
    L26:
        c1 r109 = this.f103361b;
        if (r109 == null) goto L30;
        r109.a();
    L30:
        return r100.subSequence(r101, r108);
    L34:
        return null;
    L33:
        return null;
    L31:
        return null;
    }
}

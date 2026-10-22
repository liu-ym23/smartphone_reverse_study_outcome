package com.bytedance.android.livesdk.chatroom.roommanage.blockword;

import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import com.bytedance.android.live.core.utils.f2;

/* JADX INFO: loaded from: classes7.dex */
public final class c implements InputFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f111339a;

    public c(String r100) {
        this.f111339a = r100;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence r100, int r101, int r102, Spanned r103, int r104, int r105) {
        int r106 = 10 - (r103.length() - (r105 - r104));
        if (r106 > 0) goto L9;
        if (TextUtils.isEmpty(r100) == true) goto L7;
        f2.c(this.f111339a, 0);
    L7:
        return "";
    L9:
        if (r106 < (r102 - r101)) goto L12;
        return null;
    L12:
        int r107 = r106 + r101;
        int r108 = r107 - 1;
        if (Character.isHighSurrogate(r100.charAt(r108)) == false) goto L18;
        if (r108 != r101) goto L17;
        f2.c(this.f111339a, 0);
        return "";
    L17:
        r107 = r108;
    L18:
        f2.c(this.f111339a, 0);
        return r100.subSequence(r101, r107);
    }
}

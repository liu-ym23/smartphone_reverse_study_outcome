package com.bytedance.android.shopping.service;

import android.graphics.Typeface;
import com.bytedance.android.ec.core.utils.font.ECFontHelper;
import com.lynx.tasm.behavior.shadow.text.g;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements g.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f182607a = null;

    static {
        f182607a = new a();
    }

    public a() {
    }

    @Override // com.lynx.tasm.behavior.shadow.text.g.b
    public final Typeface a(String r100, int r101) {
        if (r100 == null) goto L20;
        int r102 = r100.hashCode();
        if (r102 == (-1461481587)) goto L18;
        if (r102 == (-981614931)) goto L15;
        if (r102 != 1866312093) goto L20;
        if (r100.equals("DouyinNumberABC-Medium") == false) goto L20;
        return ECFontHelper.f45592e.b("DouyinNumberABC", 400, false);
    L15:
        if (r100.equals("DouyinNumberABC-Bold") == false) goto L20;
        return ECFontHelper.f45592e.b("DouyinNumberABC", 500, false);
    L18:
        if (r100.equals("DouyinNumberABC-ExtraBold") == false) goto L20;
        return ECFontHelper.f45592e.b("DouyinNumberABC", 600, false);
    L20:
        return null;
    }
}

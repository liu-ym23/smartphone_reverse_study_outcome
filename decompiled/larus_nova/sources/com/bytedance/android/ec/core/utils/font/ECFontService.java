package com.bytedance.android.ec.core.utils.font;

import android.graphics.Typeface;
import com.bytedance.android.ec.hybrid.service.IECFontService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ec/core/utils/font/ECFontService;", "Lcom/bytedance/android/ec/hybrid/service/IECFontService;", "()V", "getFontSync", "Landroid/graphics/Typeface;", "fontFamily", "", "fontWeight", "", "isItalic", "", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECFontService implements IECFontService {
    public ECFontService() {
    }

    @Override // com.bytedance.android.ec.hybrid.service.IECFontService
    public Typeface getFontSync(String r100, int r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "fontFamily");
        return ECFontHelper.f45592e.b(r100, r101, r102);
    }
}

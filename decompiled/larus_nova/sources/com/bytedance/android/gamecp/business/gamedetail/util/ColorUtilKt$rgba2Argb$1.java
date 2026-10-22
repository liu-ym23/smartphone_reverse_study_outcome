package com.bytedance.android.gamecp.business.gamedetail.util;

import com.bytedance.locallife.pdp.album.model.CustomAlbumViewModel;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"to2HexString", "", "num", "", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Integer;)Ljava/lang/String;"}, k = 3, mv = {1, 4, 3})
public final class ColorUtilKt$rgba2Argb$1 extends Lambda implements Function1<Integer, String> {
    public static final ColorUtilKt$rgba2Argb$1 INSTANCE = null;

    static {
        INSTANCE = new ColorUtilKt$rgba2Argb$1();
    }

    public ColorUtilKt$rgba2Argb$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(Integer r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(Integer r100) {
        if (r100 == null) goto L8;
        r100.intValue();
        String r101 = Integer.toHexString(r100.intValue());
        if (r101.length() != 2) goto L7;
        return r101;
    L7:
        return "0".concat(r101);
    L8:
        return CustomAlbumViewModel.DEFAULT_TAB_ID;
    }
}

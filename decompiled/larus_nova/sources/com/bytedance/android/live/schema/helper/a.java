package com.bytedance.android.live.schema.helper;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.bytedance.android.live.schema.convert.HybridType;
import com.bytedance.android.live.schema.convert.HybridUiType;
import com.bytedance.android.live.schema.convert.PopupGraType;
import com.bytedance.android.live.schema.vo.BaseHybridParamVo;
import com.bytedance.android.live.schema.vo.LynxHybridParamVo;
import com.bytedance.android.live.schema.vo.PopupHybridParamVo;
import com.bytedance.android.live.schema.vo.WebHybridParamVo;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f100513a = 0;

    static {
    }

    @JvmStatic
    public static final PopupHybridParamVo b(String r100, Uri r101, Bundle r102) {
        Parcelable r103 = null;
        Parcelable r104 = ka1.b.a(new ia1.b(r100, r101, r102, null), new ia1.a(HybridType.COMMON, HybridUiType.POPUP), false);
        if ((r104 instanceof PopupHybridParamVo) == false) goto L7;
        r103 = r104;
    L7:
        return (PopupHybridParamVo) r103;
    }

    @JvmStatic
    public static final PopupHybridParamVo d(String r100, Uri r101, Bundle r102) {
        Parcelable r103 = null;
        Parcelable r104 = ka1.b.a(new ia1.b(r100, r101, r102, null), new ia1.a(HybridType.Lynx, HybridUiType.POPUP, PopupGraType.OTHER), false);
        if ((r104 instanceof PopupHybridParamVo) == false) goto L7;
        r103 = r104;
    L7:
        return (PopupHybridParamVo) r103;
    }

    @JvmStatic
    public static final PopupHybridParamVo e(String r100, Uri r101, Bundle r102) {
        Parcelable r103 = null;
        Parcelable r104 = ka1.b.a(new ia1.b(r100, r101, r102, null), new ia1.a(HybridType.H5, HybridUiType.POPUP, PopupGraType.BOTTOM), false);
        if ((r104 instanceof PopupHybridParamVo) == false) goto L7;
        r103 = r104;
    L7:
        return (PopupHybridParamVo) r103;
    }

    @JvmStatic
    public static final WebHybridParamVo f(String r100, Uri r101, Bundle r102) {
        Parcelable r103 = null;
        Parcelable r104 = ka1.b.a(new ia1.b(r100, r101, r102, null), new ia1.a(HybridType.H5, HybridUiType.FULLSCREEN, PopupGraType.OTHER), false);
        if ((r104 instanceof WebHybridParamVo) == false) goto L7;
        r103 = r104;
    L7:
        return (WebHybridParamVo) r103;
    }

    @JvmStatic
    public static final BaseHybridParamVo a(String r100, Uri r101, Bundle r102, ja1.a r103) {
        Parcelable r104 = ka1.b.a(new ia1.b(r100, r101, r102, r103), new ia1.a(HybridType.COMMON, HybridUiType.FULLSCREEN), false);
        if ((r104 instanceof BaseHybridParamVo) == true) goto L6;
        r104 = null;
    L6:
        return (BaseHybridParamVo) r104;
    }

    @JvmStatic
    public static final LynxHybridParamVo c(String r100, Uri r101, Bundle r102, ja1.a r103, boolean r104) {
        Parcelable r105 = ka1.b.a(new ia1.b(r100, r101, r102, r103), new ia1.a(HybridType.Lynx, HybridUiType.FULLSCREEN, PopupGraType.OTHER), r104);
        if ((r105 instanceof LynxHybridParamVo) == true) goto L6;
        r105 = null;
    L6:
        return (LynxHybridParamVo) r105;
    }
}

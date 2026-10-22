package com.bytedance.android.annie.param;

import android.net.Uri;
import android.os.Bundle;
import com.bytedance.android.annie.scheme.convert.HybridTypeNew;
import com.bytedance.android.annie.scheme.vo.refactor.CardParamVoNew;
import com.bytedance.android.annie.scheme.vo.refactor.PageType;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f39699a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f39700a = null;

        static {
            int[] r100 = new int[HybridTypeNew.values().length];
            r100[HybridTypeNew.H5.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f39700a = r100;
        }
    }

    static {
    }

    public static HybridTypeNew b(Uri r100) {
        String r101 = UriProtector.getQueryParameter(r100, "hybrid_type");
        if (r101 == null) goto L9;
        if (Intrinsics.areEqual("lynx", r101) == false) goto L14;
        return HybridTypeNew.Lynx;
    L14:
        return HybridTypeNew.H5;
    L9:
        if (Intrinsics.areEqual("webcast_lynxview", r100.getHost()) == false) goto L12;
        return HybridTypeNew.Lynx;
    L12:
        return HybridTypeNew.H5;
    }

    @JvmStatic
    public static final CardParamVoNew a(Uri r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        HybridTypeNew r102 = b(r100);
        u8.a r103 = new u8.a(UriProtector.getQueryParameter(r100, "url"), r100, r101, r102, null);
        CardParamVoNew r104 = new CardParamVoNew(0);
        r104.F(r103);
        com.bytedance.android.annie.scheme.helper.a.d(r104, "is_fullScreen", Boolean.TRUE);
        com.bytedance.android.annie.scheme.helper.a.d(r104, "page_type", PageType.CARD);
        return r104;
    }
}

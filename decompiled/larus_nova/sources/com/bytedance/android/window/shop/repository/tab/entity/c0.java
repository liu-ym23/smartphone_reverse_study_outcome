package com.bytedance.android.window.shop.repository.tab.entity;

import com.bytedance.android.ec.window.base.repository.dto.WindowV2ProductItemDTO;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.window.shop.repository.dto.d1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public class c0 extends o0 {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f189527s = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public List<? extends WindowV2ProductItemVO> f189528q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public List<String> f189529r;

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r1v1, types: [java.util.List<? extends com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO>] */
        /* JADX WARN: Type inference failed for: r1v2, types: [java.util.ArrayList] */
        public static c0 a(int r100, d1 r101) {
            Intrinsics.checkNotNullParameter(r101, "dto");
            c0 r102 = new c0(r100);
            r102.f189615j = r101.a();
            r102.f189617l = r101.c();
            r102.f189618m = r101.d();
            r102.f189616k = r101.h();
            List<WindowV2ProductItemDTO> r103 = r101.f();
            if (r103 == null) goto L8;
            List<WindowV2ProductItemDTO> r104 = r103;
            ?? r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
            Iterator r106 = r104.iterator();
        L6:
            if (r106.hasNext() == false) goto L9;
            WindowV2ProductItemDTO r107 = (WindowV2ProductItemDTO) r106.next();
            r105.add(WindowV2ProductItemVO.a.c(WindowV2ProductItemVO.P, r107));
        L9:
            r102.f189528q = r105;
            r102.f189529r = r101.b();
            r102.f189620o = r101.e();
            return r102;
        L8:
            r105 = CollectionsKt.emptyList();
            goto L9
        }
    }

    static {
    }

    public c0(int r100) {
        super(r100);
    }
}

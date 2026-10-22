package com.bytedance.android.shopping.utils.gallery;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv3.detail.widget.VideoHolder;
import com.bytedance.android.shopping.gallery2.playerblockcompat.GalleryViewerPlayerBlockCompat;
import com.bytedance.android.ui.ec.widget.photodraweeview.PhotoViewerDialog;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f187141a = 0;

    public k() {
    }

    static {
    }

    public static void a(Context r100, List r110, List r111, List r112, int r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "videos");
        Intrinsics.checkNotNullParameter(r111, "images");
        Intrinsics.checkNotNullParameter(r112, "titlesList");
        ArrayList r101 = new ArrayList();
        r101.addAll(r111);
        List r102 = r110;
        if ((r111.size() + (!r102.isEmpty() ? 1 : 0)) != 0) goto L5;
        return;
    L5:
        String r103 = "";
        if ((!r102.isEmpty()) == false) goto L11;
        fj.d r104 = (fj.d) ListProtector.get(r110, 0);
        VideoHolder r105 = new VideoHolder(r100, false, false, 30);
        ECUrlModel r106 = new ECUrlModel();
        String r107 = r104.f477440g;
        if (r107 != null) goto L10;
        r107 = "";
    L10:
        r106.setUrlList(CollectionsKt.listOf(r107));
        Unit r108 = Unit.INSTANCE;
        r105.f(r104, r106, ECGalleryServiceUtil$startGalleryService$videoHolder$1$2.INSTANCE);
        r105.b();
    L13:
        if ((r100 instanceof FragmentActivity) == false) goto L15;
        ((FragmentActivity) r100).getLifecycle().addObserver(new VideoPlayListener(r105));
    L15:
        if (r114 == true) goto L27;
        if ((!r102.isEmpty()) == false) goto L27;
        if ((!r111.isEmpty()) == false) goto L21;
        ListProtector.add(r101, 0, ListProtector.get(r111, 0));
        goto L27
    L21:
        String r115 = ((fj.d) ListProtector.get(r110, 0)).f477440g;
        if (r115 == null) goto L25;
        r103 = r115;
    L25:
        ListProtector.add(r101, 0, r103);
    L27:
        if ((r105 instanceof ee3.c) == false) goto L29;
        ee3.c r116 = r105;
    L30:
        GalleryViewerPlayerBlockCompat r117 = new GalleryViewerPlayerBlockCompat(r100);
        ArrayList r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r118 = r101.iterator();
    L32:
        if (r118.hasNext() == false) goto L34;
        String r119 = (String) r118.next();
        com.bytedance.android.ec.model.k r120 = new com.bytedance.android.ec.model.k();
        r120.f47873b = r119;
        r109.add(r120);
        goto L32
    L34:
        r117.a(r109, r114);
        if (r114 == false) goto L40;
        ee3.f r121 = r117.f176178d;
        FrameLayout r122 = r121.f472281c;
        if (r122 != null) goto L39;
        r121.f472284f = 8;
        goto L40
    L39:
        r122.setVisibility(8);
    L40:
        r117.setOnDismissListener(new i(r101, r105, r112));
        r117.setOnPageSelectedListener(new j());
        r117.b(r116);
        r117.f176145b.setData(r112);
        PhotoViewerDialog.showAnimated$default(r117, r113, null, 2, null);
        return;
    L29:
        r116 = null;
        goto L30
    L11:
        r105 = null;
        goto L13
    }
}

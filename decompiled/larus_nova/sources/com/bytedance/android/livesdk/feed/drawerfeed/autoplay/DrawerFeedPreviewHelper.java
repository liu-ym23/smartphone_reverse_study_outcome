package com.bytedance.android.livesdk.feed.drawerfeed.autoplay;

import android.os.Handler;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Arrays;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class DrawerFeedPreviewHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f123708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RecyclerView f123709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f123710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f123711d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f123712e;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DrawerFeedPreviewHelper f123713a;

        public a(DrawerFeedPreviewHelper r100) {
            this.f123713a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f123713a.c();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DrawerFeedPreviewHelper f123714a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f123715b;

        public b(DrawerFeedPreviewHelper r100, RecyclerView r101) {
            this.f123714a = r100;
            this.f123715b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            uv1.a r101 = (uv1.a) r100;
            String r102 = (String) xv1.b.a().get("play_type");
            if (r102 == null) goto L5;
            int r103 = CastIntegerProtector.parseInt(r102);
        L7:
            if (r103 != 1) goto L9;
            DrawerFeedPreviewHelper r104 = this.f123714a;
            int[] r105 = r104.f123708a;
            if (r105 != null) goto L24;
            r104.d();
            return;
        L24:
            if (r101.f551790b > ArraysKt.last(r105)) goto L48;
            RecyclerView r106 = this.f123714a.f123709b;
            RecyclerView.LayoutManager r107 = null;
            if (r106 == null) goto L29;
            RecyclerView.LayoutManager r108 = r106.getLayoutManager();
        L31:
            if ((r108 instanceof GridLayoutManager) == false) goto L34;
            r107 = r108;
        L34:
            GridLayoutManager r109 = (GridLayoutManager) r107;
            if (r109 == null) goto L49;
            int r110 = r109.getSpanSizeLookup().getSpanIndex(r101.f551790b, r109.getSpanCount());
            RecyclerView r111 = this.f123714a.f123709b;
            if (r111 == null) goto L45;
            r111.postDelayed(new com.bytedance.android.livesdk.feed.drawerfeed.autoplay.a(this, r110, r101), 300);
            return;
        L45:
            return;
        L49:
            return;
        L29:
            r108 = null;
            goto L31
        L48:
            return;
        L9:
            if (r103 != 2) goto L46;
            DrawerFeedPreviewHelper r112 = this.f123714a;
            int[] r113 = r112.f123708a;
            if (r113 != null) goto L15;
            r112.d();
            return;
        L15:
            if (r101.f551790b > ArraysKt.last(r113)) goto L47;
            RecyclerView r114 = this.f123714a.f123709b;
            if (r114 == null) goto L42;
            r114.postDelayed(new com.bytedance.android.livesdk.feed.drawerfeed.autoplay.b(this), 300);
            return;
        L42:
            return;
        L47:
            return;
        L46:
            return;
        L5:
            r103 = 0;
            goto L7
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DrawerFeedPreviewHelper f123716a;

        public c(DrawerFeedPreviewHelper r100) {
            this.f123716a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f123716a.d();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final int a() {
        RecyclerView r100 = this.f123709b;
        if (r100 != null) goto L5;
        return -1;
    L5:
        RecyclerView.LayoutManager r101 = r100.getLayoutManager();
        if ((r101 instanceof GridLayoutManager) == true) goto L8;
        r101 = null;
    L8:
        GridLayoutManager r102 = (GridLayoutManager) r101;
        if (r102 != null) goto L11;
        return -1;
    L11:
        int r103 = r102.findFirstCompletelyVisibleItemPosition();
        int r104 = r102.findLastCompletelyVisibleItemPosition();
        if (r103 == (-1)) goto L20;
        if (r104 == (-1)) goto L20;
    L16:
        if ((r100.findViewHolderForAdapterPosition(r103) instanceof an2.a) == true) goto L19;
        if (r103 > r104) goto L19;
        r103 = r103 + 1;
    L19:
        return r103;
    L20:
        return -1;
    }

    public final void c() {
        int[] r100 = this.f123708a;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100 == null) goto L20;
        int r101 = r100.length;
        int r102 = 0;
    L8:
        if (r102 >= r101) goto L20;
        int r103 = r100[r102];
        RecyclerView r104 = this.f123709b;
        if (r104 == null) goto L12;
        Object r105 = r104.findViewHolderForAdapterPosition(r103);
    L14:
        if ((r105 instanceof an2.a) == true) goto L16;
        r105 = null;
    L16:
        an2.a r106 = (an2.a) r105;
        if (r106 == null) goto L19;
        r106.reset();
    L19:
        r102 = r102 + 1;
        goto L8
    L12:
        r105 = null;
    L20:
        this.f123708a = null;
    }

    public DrawerFeedPreviewHelper() {
        this.f123711d = new c(this);
        this.f123712e = new a(this);
    }

    public final void d() {
        if ((!xv1.b.a().isEmpty()) == true) goto L5;
        return;
    L5:
        RecyclerView r100 = this.f123709b;
        if (r100 != null) goto L8;
        return;
    L8:
        int r101 = a();
        int r102 = 0;
        if (r101 >= 0) goto L11;
        int[] r103 = new int[0];
    L53:
        if (r103.length != 0) goto L55;
        boolean r104 = true;
    L56:
        if (r104 == false) goto L58;
        return;
    L58:
        int[] r105 = this.f123708a;
        if (r105 != null) goto L61;
    L62:
        int[] r106 = this.f123708a;
        if (r106 == null) goto L73;
        int r107 = r106.length;
        int r108 = 0;
    L65:
        if (r108 >= r107) goto L73;
        Object r109 = r100.findViewHolderForAdapterPosition(r106[r108]);
        if ((r109 instanceof an2.a) == true) goto L69;
        r109 = null;
    L69:
        an2.a r110 = (an2.a) r109;
        if (r110 == null) goto L72;
        r110.reset();
    L72:
        r108 = r108 + 1;
    L73:
        int r111 = r103.length;
        int r112 = 0;
    L74:
        if (r102 >= r111) goto L84;
        Object r113 = r100.findViewHolderForAdapterPosition(r103[r102]);
        if ((r113 instanceof an2.a) == true) goto L78;
        r113 = null;
    L78:
        an2.a r114 = (an2.a) r113;
        if (r114 == null) goto L83;
        if (r114.t7() == false) goto L83;
        r114.play();
        r112 = r112 + 1;
    L83:
        r102 = r102 + 1;
        goto L74
    L84:
        r103.toString();
        if (r112 <= 0) goto L94;
        Handler r115 = i0.c();
        a r116 = this.f123712e;
        if ((true ^ xv1.b.a().isEmpty()) == false) goto L92;
        String r117 = (String) xv1.b.a().get("play_duration");
        if (r117 == null) goto L91;
        long r118 = CastLongProtector.parseLong(r117);
    L93:
        r115.postDelayed(r116, r118);
        goto L94
    L91:
        r118 = 5000;
        goto L93
    L92:
        r118 = -1;
    L94:
        this.f123708a = r103;
        return;
    L61:
        if (Arrays.equals(r105, r103) != true) goto L62;
        return;
    L55:
        r104 = false;
        goto L56
    L11:
        String r119 = (String) xv1.b.a().get("play_type");
        if (r119 == null) goto L14;
        int r120 = CastIntegerProtector.parseInt(r119);
    L16:
        if (r120 == 1) goto L21;
        if (r120 == 2) goto L19;
        r103 = new int[0];
        goto L53
    L19:
        int[] r121 = {r101, r101 + 1};
    L20:
        r103 = r121;
        goto L53
    L21:
        r121 = new int[1];
        RecyclerView r122 = this.f123709b;
        if (r122 == null) goto L24;
        RecyclerView.LayoutManager r123 = r122.getLayoutManager();
    L26:
        if ((r123 instanceof GridLayoutManager) == true) goto L28;
        r123 = null;
    L28:
        GridLayoutManager r124 = (GridLayoutManager) r123;
        if (r124 == null) goto L50;
        GridLayoutManager.SpanSizeLookup r125 = r124.getSpanSizeLookup();
        if (r125 == null) goto L34;
        Integer r126 = Integer.valueOf(r125.getSpanGroupIndex(r101, r124.getSpanCount()));
    L35:
        if (r126 == null) goto L50;
        r126.intValue();
        RecyclerView r127 = this.f123709b;
        if (r127 == null) goto L43;
        RecyclerView.Adapter r128 = r127.getAdapter();
        if (r128 == null) goto L43;
        if (r128.getItemViewType(0) != R.layout.ttlive_feed_view_drawer_banner) goto L43;
        boolean r129 = true;
    L44:
        if (r129 == false) goto L47;
        r126 = Integer.valueOf(r126.intValue() - 1);
    L47:
        if ((r126.intValue() % 2) == 0) goto L51;
        r101 = r101 + 1;
    L51:
        r121[0] = r101;
    L43:
        r129 = false;
        goto L44
    L34:
        r126 = null;
    L50:
        r101 = 0;
        goto L51
    L24:
        r123 = null;
        goto L26
    L14:
        r120 = 0;
        goto L16
    }

    public final void b(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        if ((!xv1.b.a().isEmpty()) == true) goto L5;
        return;
    L5:
        this.f123709b = r100;
        r100.addOnScrollListener(new DrawerFeedPreviewHelper$initPreview$1(this));
        this.f123710c = xs2.b.a().b(uv1.a.class).subscribe(new b(this, r100));
    }
}

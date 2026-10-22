package com.bytedance.android.shopping.anchorv4.voavhs.headbottom;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.anchorv3.PdpMessageOpt;
import com.bytedance.android.ec.core.anchorv3.PdpPerfOpt;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.imagex.s0;
import com.bytedance.android.ec.core.utils.UIUtils;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.dto.base.VideoModel;
import com.bytedance.android.shopping.anchorv4.experiment.h;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderContentModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderMediaModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.t;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.larus.nova.R;
import io.reactivex.disposables.Disposable;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headbottom/HeadBottomAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headbottom/HeadBottomAdapter$HeadBottomHolder;", "HeadBottomHolder", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HeadBottomAdapter extends RecyclerView.Adapter<HeadBottomHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<? extends ECUrlModel> f168972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, Disposable> f168973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix f168974c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BitmapFactory.Options f168975d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Rect f168976e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SparseArray<Bitmap> f168977f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final SparseArray<Bitmap> f168978g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f168979h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f168980i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final RecyclerView f168981j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Context f168982k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final d83.b f168983l;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headbottom/HeadBottomAdapter$HeadBottomHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class HeadBottomHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ImageView f168984a;

        public HeadBottomHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        if (this.f168972a != null) goto L9;
        d83.b r100 = this.f168983l;
        if (r100 == null) goto L7;
        List<ECUrlModel> r101 = r100.k();
    L8:
        this.f168972a = r101;
        goto L9
    L7:
        r101 = null;
    L9:
        List<? extends ECUrlModel> r102 = this.f168972a;
        if (r102 != null) goto L14;
        return 0;
    L14:
        return r102.size();
    }

    public final boolean A2(int r100) {
        ECUrlModel r101 = null;
        if (this.f168972a != null) goto L9;
        d83.b r102 = this.f168983l;
        if (r102 == null) goto L7;
        List<ECUrlModel> r103 = r102.k();
    L8:
        this.f168972a = r103;
        goto L9
    L7:
        r103 = null;
    L9:
        List<? extends ECUrlModel> r104 = this.f168972a;
        if (r104 == null) goto L12;
        r101 = (ECUrlModel) CollectionsKt.getOrNull(r104, r100);
    L12:
        if (r101 == null) goto L14;
        return true;
    L14:
        return false;
    }

    public final boolean B2(int r100, ECUrlModel r101) {
        if (r101 != null) goto L5;
        return false;
    L5:
        d83.b r102 = this.f168983l;
        VideoModel r103 = null;
        if ((r102 instanceof s) == true) goto L8;
        r102 = null;
    L8:
        s r104 = (s) r102;
        if (r104 != null) goto L11;
        return false;
    L11:
        AnchorV4HeadV2VO r105 = r104.K10();
        if (r105 == null) goto L25;
        List<HeaderContentModel> r106 = r105.getCells();
        if (r106 == null) goto L25;
        HeaderContentModel r107 = (HeaderContentModel) CollectionsKt.getOrNull(r106, r100);
        if (r107 == null) goto L25;
        HeaderMediaModel r108 = r107.getMedia();
        if (r108 == null) goto L20;
        r103 = r108.getVideo();
    L20:
        if (r103 == null) goto L25;
        if (t.a(r104, r100, Integer.valueOf(r101.getWidth()), Integer.valueOf(r101.getHeight())) == true) goto L25;
        return true;
    L25:
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, final int r101) {
        final HeadBottomHolder r102 = (HeadBottomHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        final String r103 = String.valueOf(r102.hashCode());
        Disposable r104 = this.f168973b.get(r103);
        if (r104 == null) goto L5;
        r104.dispose();
    L5:
        this.f168973b.remove(r103);
        d83.b r105 = this.f168983l;
        ECUrlModel r106 = null;
        if ((r105 instanceof s) == true) goto L8;
        r105 = null;
    L8:
        s r107 = (s) r105;
        if (r107 == null) goto L30;
        if (r107.W4() <= 0) goto L30;
        boolean r108 = true;
        if (r107.W4() != 1) goto L16;
        if (r101 != 0) goto L16;
    L18:
        if (r108 == true) goto L27;
        if (r107.isExpanded() == true) goto L27;
        if (r101 >= r107.W4()) goto L27;
        int r109 = com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper.b.f169180k;
        int r110 = com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper.b.a.b(((s) this.f168983l).getContext(), ((s) this.f168983l).s00(), ((s) this.f168983l).rR().d());
        if (r110 == r102.itemView.getLayoutParams().width) goto L30;
        View r111 = r102.itemView;
        ViewGroup.LayoutParams r112 = r111.getLayoutParams();
        r112.width = r110;
        r112.height = -1;
        Unit r113 = Unit.INSTANCE;
        r111.setLayoutParams(r112);
    L27:
        if (r102.itemView.getWidth() == (-1)) goto L30;
        View r114 = r102.itemView;
        ViewGroup.LayoutParams r115 = r114.getLayoutParams();
        r115.width = -1;
        r115.height = -1;
        Unit r116 = Unit.INSTANCE;
        r114.setLayoutParams(r115);
    L16:
        r108 = false;
    L30:
        if (A2(r101) == true) goto L35;
        ImageView r117 = r102.f168984a;
        if (r117 == null) goto L59;
        r117.setImageBitmap(null);
        return;
    L59:
        return;
    L35:
        if (this.f168980i == false) goto L47;
        List<? extends ECUrlModel> r118 = this.f168972a;
        if (r118 == null) goto L39;
        ECUrlModel r119 = (ECUrlModel) CollectionsKt.getOrNull(r118, r101);
    L41:
        if (B2(r101, r119) == false) goto L47;
        Bitmap r120 = this.f168977f.get(r101);
        if (r120 == null) goto L61;
        ImageView r121 = r102.f168984a;
        if (r121 == null) goto L62;
        r121.setImageBitmap(r120);
        return;
    L62:
        return;
    L61:
        return;
    L39:
        r119 = null;
    L47:
        Lazy r122 = PdpPerfOpt.f43774a;
        if (PdpMessageOpt.f43752b.e() == false) goto L54;
        Bitmap r123 = this.f168978g.get(r101);
        if (r123 == null) goto L64;
        ImageView r124 = r102.f168984a;
        if (r124 == null) goto L65;
        r124.setImageBitmap(r123);
        return;
    L65:
        return;
    L64:
        return;
    L54:
        int r125 = s0.f44945f;
        List<? extends ECUrlModel> r126 = this.f168972a;
        if (r126 == null) goto L57;
        r106 = (ECUrlModel) CollectionsKt.getOrNull(r126, r101);
    L57:
        int r127 = r.f44937h;
        this.f168973b.put(r103, new s0(r106, r.a.a("HeadBottomView")).a(new HeadBottomAdapter$onBindViewHolder$disposable$1(this, r102, r101, r103)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (PdpPerfOpt.e() == false) goto L5;
        ImageView r102 = new ImageView(r100.getContext());
        r102.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r102.setScaleType(ImageView.ScaleType.FIT_XY);
        FrameLayout r103 = new FrameLayout(r100.getContext());
        r103.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r103.addView(r102);
        Unit r104 = Unit.INSTANCE;
        HeadBottomHolder r105 = new HeadBottomHolder(r103);
        r105.f168984a = r102;
        return r105;
    L5:
        View r106 = th.a.c(r100.getContext(), R.layout.ec_commerce_anchor_v4_head_bottom_view_item, r100, false);
        HeadBottomHolder r107 = new HeadBottomHolder(r106);
        r107.f168984a = (ImageView) r106.findViewById(R.id.head_bottom_picture);
        return r107;
    }

    public final void z2(int r100, Bitmap r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        RecyclerView.ViewHolder r102 = this.f168981j.findViewHolderForAdapterPosition(r100);
        if ((r102 instanceof HeadBottomHolder) == true) goto L7;
        r102 = null;
    L7:
        HeadBottomHolder r103 = (HeadBottomHolder) r102;
        if (r103 == null) goto L12;
        ImageView r104 = r103.f168984a;
        if (r104 == null) goto L14;
        r104.setImageBitmap(r101);
        return;
    L14:
        return;
    L12:
        notifyItemChanged(r100);
    }

    public HeadBottomAdapter(RecyclerView r100, Context r101, d83.b r102) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        Intrinsics.checkNotNullParameter(r101, "ctx");
        this.f168981j = r100;
        this.f168982k = r101;
        this.f168983l = r102;
        this.f168973b = new HashMap();
        Matrix r103 = new Matrix();
        r103.setScale(1.0f, -1.0f);
        Unit r104 = Unit.INSTANCE;
        this.f168974c = r103;
        BitmapFactory.Options r105 = new BitmapFactory.Options();
        r105.inPreferredConfig = Bitmap.Config.ARGB_8888;
        this.f168975d = r105;
        this.f168976e = new Rect();
        this.f168977f = new SparseArray();
        this.f168978g = new SparseArray();
        this.f168979h = com.bytedance.android.shopping.extensions.b.b(12);
    }

    public final boolean C2(int r100, int r101, int r102) {
        if (h.a() == false) goto L11;
        d83.b r103 = this.f168983l;
        Boolean r104 = null;
        if ((r103 instanceof s) == true) goto L7;
        r103 = null;
    L7:
        s r105 = (s) r103;
        if (r105 == null) goto L19;
        r104 = Boolean.valueOf(t.a(r105, r100, Integer.valueOf(r101), Integer.valueOf(r102)));
    L19:
        return true ^ Intrinsics.areEqual(r104, Boolean.TRUE);
    L11:
        d83.b r106 = this.f168983l;
        if (r106 != null) goto L14;
    L17:
        return false;
    L14:
        if (r106.i() != true) goto L17;
        if (r101 != r102) goto L17;
        return true;
    }

    public static final void y2(HeadBottomAdapter r110, PolarisFileInputStreamWrapper r111, HeadBottomHolder r112, int r113) {
        r110.getClass();
        ByteArrayInputStream r100 = null;
        Bitmap r101 = null;
        ByteArrayInputStream r102 = null;
        ByteArrayInputStream r103 = null;
        ByteArrayInputStream r104 = null;
        ByteArrayOutputStream r105 = new ByteArrayOutputStream();     // Catch: Throwable -> L28 Exception -> L36
        byte[] r106 = new byte[1024];     // Catch: Throwable -> L28 Exception -> L36
    L4:
        int r107 = r111.read(r106);     // Catch: Throwable -> L28 Exception -> L36
        if (r107 == (-1)) goto L7;
        r105.write(r106, 0, r107);     // Catch: Throwable -> L28 Exception -> L36
        goto L4
    L7:
        r105.flush();     // Catch: Throwable -> L28 Exception -> L36
        ByteArrayInputStream r108 = new ByteArrayInputStream(r105.toByteArray());     // Catch: Throwable -> L28 Exception -> L36
        ByteArrayInputStream r109 = new ByteArrayInputStream(r105.toByteArray());     // Catch: Throwable -> L24 Exception -> L26
        goto L27
    L52:
        BitmapRegionDecoder r114 = BitmapRegionDecoder.newInstance(r108, false);     // Catch: Throwable -> L21 Exception -> L23
        BitmapFactory.Options r115 = new BitmapFactory.Options();     // Catch: Throwable -> L21 Exception -> L23
        r115.inJustDecodeBounds = true;     // Catch: Throwable -> L21 Exception -> L23
        BitmapFactory.decodeStream(r109, null, r115);     // Catch: Throwable -> L21 Exception -> L23
        int r116 = r115.outWidth;     // Catch: Throwable -> L21 Exception -> L23
        int r117 = r115.outHeight;     // Catch: Throwable -> L21 Exception -> L23
        if (r110.C2(r113, r116, r117) == false) goto L14;
        Lazy r118 = UIUtils.f45548a;     // Catch: Throwable -> L21 Exception -> L23
        UIUtils.e(new b(r112));     // Catch: Throwable -> L21 Exception -> L23
    L12:
        r108.close();     // Catch: Exception -> L44
    L41:
        r109.close();     // Catch: Exception -> L44
    L42:
        r111.close();     // Catch: Exception -> L44
        return;
    L14:
        Rect r119 = r110.f168976e;     // Catch: Throwable -> L21 Exception -> L23
        r119.left = 0;     // Catch: Throwable -> L21 Exception -> L23
        r119.top = r117 - r110.f168979h;     // Catch: Throwable -> L21 Exception -> L23
        r119.right = r116;     // Catch: Throwable -> L21 Exception -> L23
        r119.bottom = r117;     // Catch: Throwable -> L21 Exception -> L23
        if (r114 == null) goto L17;
        r101 = r114.decodeRegion(r119, r110.f168975d);     // Catch: Throwable -> L21 Exception -> L23
    L17:
        Bitmap r120 = r101;
        if (r120 == null) goto L12;
        Bitmap r121 = Bitmap.createBitmap(r120, 0, 0, r120.getWidth(), r120.getHeight(), r110.f168974c, true);     // Catch: Throwable -> L21 Exception -> L23
        Lazy r122 = UIUtils.f45548a;     // Catch: Throwable -> L21 Exception -> L23
        UIUtils.e(new a(r121, r112));     // Catch: Throwable -> L21 Exception -> L23
    L23:
        r102 = r109;
    L21:
        th = th;
        r103 = r109;
    L25:
        ByteArrayInputStream r123 = r103;
        r100 = r108;
    L30:
        if (r100 != null) goto L48;
    L32:
        if (r123 == null) goto L34;
        r123.close();     // Catch: Exception -> L45
    L34:
        r111.close();     // Catch: Exception -> L45
    L35:
        throw th;
    L48:
        r100.close();     // Catch: Exception -> L45
    L24:
        th = th;
    L27:
        ByteArrayInputStream r124 = r102;
        r104 = r108;
    L37:
        if (r104 == null) goto L39;
        r104.close();     // Catch: Exception -> L44
    L39:
        if (r124 == null) goto L42;
        r109 = r124;
        goto L41
    L36:
        r124 = null;
    L28:
        th = th;
        r123 = null;
    }
}

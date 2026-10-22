package com.bytedance.android.gamecp.business.imagechoose;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.gamecp.base.core.service.depend.w;
import com.bytedance.android.gamecp.common.ui.HSImageView;
import com.bytedance.android.gamecp.common.utils.ToastUtil;
import com.bytedance.android.gamecp.common.utils.y;
import com.bytedance.android.gamecp.common.utils.y0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/gamecp/business/imagechoose/ImageChooseAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ViewHolder", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ImageChooseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f56006q = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f56007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<w> f56008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f56009c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedList<w> f56010d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList<Integer> f56011e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile int f56012f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f56013g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f56014h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function1<? super LinkedList<w>, Unit> f56015i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function0<Unit> f56016j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Context f56017k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f56018l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final double f56019m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Integer f56020n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f56021o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Function1<Integer, Unit> f56022p;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/gamecp/business/imagechoose/ImageChooseAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public HSImageView f56023a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public TextView f56024b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public View f56025c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f56026d;

        public final void U3() {
            TextView r100 = this.f56024b;
            if (r100 == null) goto L5;
            r100.setText("");
        L5:
            TextView r101 = this.f56024b;
            if (r101 == null) goto L8;
            r101.setBackgroundResource(R.drawable.gamecp_game_promote_image_unselected);
        L8:
            View r102 = this.f56025c;
            if (r102 == null) goto L12;
            r102.setVisibility(8);
            return;
        }

        public ViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
        }

        public final void T3(int r100) {
            TextView r101 = this.f56024b;
            if (r101 == null) goto L5;
            r101.setText(String.valueOf(r100));
        L5:
            TextView r102 = this.f56024b;
            if (r102 == null) goto L8;
            r102.setBackgroundResource(R.drawable.gamecp_game_promote_image_selected);
        L8:
            View r103 = this.f56025c;
            if (r103 == null) goto L12;
            r103.setVisibility(0);
            return;
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int r100) {
        return r100;
    }

    public final int y2() {
        return ((Number) this.f56014h.getValue()).intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f56008b.size();
    }

    public final void B2(View r100) {
        if (r100 == null) goto L12;
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.width == y2()) goto L9;
        r101.width = y2();
    L9:
        if (r101.height == ((int) (((double) y2()) * this.f56019m))) goto L14;
        r101.height = (int) (((double) y2()) * this.f56019m);
        return;
    L14:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        if (((w) ListProtector.get(this.f56008b, r100)).A != (-1)) goto L5;
        return 1;
    L5:
        return 0;
    }

    public static void A2(ImageChooseAdapter r100, w r101) {
        r100.getClass();
        if (r101.f51412b == false) goto L25;
        r100.f56009c--;
        r101.f51412b = false;
        r100.f56010d.remove(r101);
        int r102 = r101.f51413c;
        Iterator<w> r103 = r100.f56010d.iterator();
    L6:
        if (r103.hasNext() == false) goto L10;
        w r104 = r103.next();
        int r105 = r104.f51413c;
        if (r105 <= r102) goto L6;
        r104.f51413c = r105 - 1;
        goto L6
    L10:
        Iterator<Integer> r106 = r100.f56011e.iterator();
    L12:
        if (r106.hasNext() == false) goto L14;
        r100.notifyItemChanged(r106.next().intValue());
        goto L12
    L14:
        int r107 = r101.f51414d;
        if (r107 != (-1)) goto L17;
        r100.f56012f--;
        return;
    L17:
        r100.f56011e.remove(Integer.valueOf(r107));
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "holder");
        ViewHolder r112 = (ViewHolder) r110;
        B2(r112.f56023a);
        B2(r112.f56025c);
        w r100 = (w) ListProtector.get(this.f56008b, r111);
        if (r100.A != (-1)) goto L6;
        r112.itemView.setOnClickListener(new com.bytedance.android.gamecp.business.imagechoose.a(this));
        return;
    L6:
        if (this.f56012f <= 0) goto L19;
        Iterator<w> r101 = this.f56010d.iterator();
    L9:
        if (r101.hasNext() == false) goto L19;
        w r102 = r101.next();
        if (r102.f51414d != (-1)) goto L9;
        if (r100.A != r102.A) goto L9;
        r100.f51412b = r102.f51412b;
        r100.f51413c = r102.f51413c;
        r100.f51414d = r111;
        LinkedList<w> r103 = this.f56010d;
        r103.set(r103.indexOf(r102), r100);
        this.f56011e.add(Integer.valueOf(r111));
        this.f56012f--;
        Function1<? super LinkedList<w>, Unit> r104 = this.f56015i;
        if (r104 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mOnSelectedImageChangeListener");
    L17:
        r104.invoke(this.f56010d);
    L19:
        if (r100.f51412b == false) goto L21;
        r112.T3(r100.f51413c);
    L22:
        String r105 = r100.f51415e;
        if (TextUtils.equals(r112.f56026d, r105) == true) goto L26;
        r112.f56026d = r105;
        y.c(r112.f56023a, r105, y2() / 2, y2() / 2, 0);
    L26:
        if (this.f56013g == false) goto L31;
        Function1<? super LinkedList<w>, Unit> r106 = this.f56015i;
        if (r106 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mOnSelectedImageChangeListener");
    L30:
        r106.invoke(this.f56010d);
        this.f56013g = false;
    L31:
        r112.itemView.setOnClickListener(new b(this, r112));
        TextView r107 = r112.f56024b;
        if (r107 == null) goto L42;
        r107.setOnClickListener(new c(this, r100, r112, r111));
        return;
    L42:
        return;
    L21:
        r112.U3();
        goto L22
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (r101 != 1) goto L18;
        this.f56007a = LayoutInflater.from(this.f56017k).inflate(R.layout.gamecp_game_promote_comment_editor_image_item_v2, r100, false);
        View r102 = this.f56007a;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mConvertView");
    L7:
        ViewHolder r103 = new ViewHolder(r102);
        View r104 = this.f56007a;
        if (r104 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mConvertView");
    L10:
        ConstraintLayout r105 = (ConstraintLayout) r104.findViewById(R.id.iv_cancel);
        if (r105 == null) goto L13;
        r105.setVisibility(8);
    L13:
        View r106 = this.f56007a;
        if (r106 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mConvertView");
    L16:
        r103.f56025c = r106.findViewById(R.id.iv_background);
        return r103;
    L18:
        this.f56007a = LayoutInflater.from(this.f56017k).inflate(R.layout.gamecp_game_promote_image_choose_item, r100, false);
        View r107 = this.f56007a;
        if (r107 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mConvertView");
    L21:
        ViewHolder r108 = new ViewHolder(r107);
        View r109 = this.f56007a;
        if (r109 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mConvertView");
    L24:
        r108.f56023a = (HSImageView) r109.findViewById(R.id.media_view);
        View r110 = this.f56007a;
        if (r110 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mConvertView");
    L27:
        r108.f56024b = (TextView) r110.findViewById(R.id.tv_image_select);
        View r111 = this.f56007a;
        if (r111 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mConvertView");
    L30:
        r108.f56025c = r111.findViewById(R.id.shadow_view);
        return r108;
    }

    public final boolean z2(w r100, ViewHolder r101, int r102) {
        if (r100.f51412b == true) goto L15;
        if (this.f56009c < this.f56018l) goto L15;
        String r103 = this.f56021o;
        if (r103.length() != 0) goto L9;
        boolean r104 = true;
    L10:
        if (r104 == false) goto L12;
        r103 = y0.j(R.string.ttlive_game_promote_select_image_maximum_tip, new Object[]{Integer.valueOf(this.f56018l)});
    L12:
        ToastUtil.b(r103, 0);
        return false;
    L9:
        r104 = false;
    L15:
        if (r100.f51412b == true) goto L17;
        this.f56009c++;
        r100.f51412b = true;
        r100.f51413c = this.f56009c;
        r100.f51414d = r102;
        this.f56010d.add(r100);
        this.f56011e.add(Integer.valueOf(r102));
        r101.T3(this.f56009c);
    L17:
        return true;
    }

    public ImageChooseAdapter(Context r100, int r101, ArrayList r102, Integer r103, String r104, Function1 r105) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        Intrinsics.checkNotNullParameter(r104, "limitText");
        this.f56017k = r100;
        this.f56018l = r101;
        this.f56019m = 1.0d;
        this.f56020n = r103;
        this.f56021o = r104;
        this.f56022p = r105;
        this.f56008b = new ArrayList();
        this.f56010d = new LinkedList();
        this.f56011e = new ArrayList();
        if (r102 == null) goto L11;
        this.f56012f = r102.size();
        if (this.f56012f <= 0) goto L7;
        this.f56013g = true;
    L7:
        Iterator r106 = r102.iterator();
    L9:
        if (r106.hasNext() == false) goto L11;
        w r107 = (w) r106.next();
        w r108 = new w(r107.A);
        r108.f51415e = r107.f51415e;
        r108.f51417g = r107.f51417g;
        r108.f51416f = r107.f51416f;
        r108.f51426p = r107.f51426p;
        r108.f51427q = r107.f51427q;
        r108.f51412b = r107.f51412b;
        r108.f51413c = r107.f51413c;
        r108.f51414d = -1;
        this.f56010d.add(r108);
        this.f56009c++;
    L11:
        final int r109 = 4;
        final int r110 = 2;
        final int r111 = 0;
        this.f56014h = LazyKt.lazy(new ImageChooseAdapter$mItemSize$2(this, r109, r110, r111));
    }
}

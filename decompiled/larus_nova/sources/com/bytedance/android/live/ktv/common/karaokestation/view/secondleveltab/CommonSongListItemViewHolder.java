package com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab;

import android.graphics.Rect;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.utils.x0;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/ktv/common/karaokestation/view/secondleveltab/CommonSongListItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CommonSongListItemViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f69663l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f69664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f69665b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f69666c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f69667d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f69668e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f69669f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f69670g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f69671h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public MusicPanel f69672i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b f69673j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final d f69674k;

    public static final class a {
    }

    public static final class b implements ic0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonSongListItemViewHolder f69675a;

        public b(CommonSongListItemViewHolder r100) {
            this.f69675a = r100;
        }

        @Override // ic0.a
        public final void a(boolean r100) {
            CommonSongListItemViewHolder r101 = this.f69675a;
            int r102 = CommonSongListItemViewHolder.f69663l;
            r101.U3(r100);
            if (r100 == false) goto L5;
            int r103 = R.string.ttlive_ktv_add_favorite_success;
        L6:
            f2.b(r103, 0);
            MusicPanel r104 = this.f69675a.f69672i;
            if (r104 == null) goto L11;
            KtvMusic r105 = r104.f153577a;
            if (r105 == null) goto L11;
            r105.setFavorite(r100);
        L11:
            if (r100 == false) goto L16;
            CommonSongListItemViewHolder r106 = this.f69675a;
            MusicPanel r107 = r106.f69672i;
            if (r107 == null) goto L17;
            Rect r108 = new Rect();
            int[] r109 = new int[2];
            r106.itemView.getLocationInWindow(r109);
            View r110 = r106.itemView;
            r108.left = r109[0] + ((int) r110.findViewById(R.id.favorite).getX());
            r108.top = r109[1] + ((int) r110.findViewById(R.id.favorite).getY());
            r108.right = r108.left + r110.findViewById(R.id.favorite).getWidth();
            r108.bottom = r108.top + r110.findViewById(R.id.favorite).getHeight();
            Intrinsics.checkNotNullParameter(r108, "<set-?>");
            r107.f153598v = r108;
            return;
        L17:
            return;
        L16:
            return;
        L5:
            r103 = R.string.ttlive_ktv_del_favorite_success;
            goto L6
        }
    }

    static {
    }

    public final TextView T3() {
        return (TextView) this.f69670g.getValue();
    }

    public final void U3(boolean r100) {
        View r101 = (View) this.f69669f.getValue();
        if (r101 == null) goto L8;
        if (r100 == false) goto L6;
        int r102 = R.drawable.ttlive_ktv_selected_music_star_yellow;
    L7:
        r101.setBackgroundResource(r102);
        goto L8
    L6:
        r102 = KtvOrderSongThemeManager.a(103);
    L8:
        KtvUtilsKt.L((View) this.f69669f.getValue(), r100);
        View r103 = (View) this.f69669f.getValue();
        if (r103 == null) goto L15;
        if (r100 == false) goto L12;
        float r104 = 1.0f;
    L13:
        r103.setAlpha(r104);
        return;
    L12:
        r104 = 0.6f;
        goto L13
    }

    public final void V3(boolean r100) {
        if (r100 == false) goto L18;
        TextView r101 = T3();
        if (r101 == null) goto L6;
        r101.setClickable(false);
    L6:
        TextView r102 = T3();
        if (r102 == null) goto L9;
        KtvOrderSongThemeManager.c(r102, 102);
    L9:
        TextView r103 = T3();
        if (r103 == null) goto L12;
        r103.setText(s1.B(R.string.ttlive_ktv_tab_selected));
    L12:
        TextView r104 = T3();
        if (r104 == null) goto L15;
        r104.setTextColor(s1.h(R.color.ttlive_ktv_music_selected_font_color));
    L15:
        TextView r105 = T3();
        if (r105 == null) goto L31;
        KtvOrderSongThemeManager.d(r105, 106);
        return;
    L31:
        return;
    L18:
        TextView r106 = T3();
        if (r106 == null) goto L21;
        r106.setClickable(true);
    L21:
        TextView r107 = T3();
        if (r107 == null) goto L24;
        r107.setBackgroundResource(R.drawable.ttlive_bg_ktv_red_bt);
    L24:
        TextView r108 = T3();
        if (r108 == null) goto L27;
        r108.setText(s1.B(R.string.ttlive_ktv_tab_select));
    L27:
        TextView r109 = T3();
        if (r109 == null) goto L33;
        r109.setTextColor(s1.h(R.color.ttlive_ktv_music_select_font_color));
        return;
    }

    public CommonSongListItemViewHolder(final View r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f69674k = r101;
        this.f69664a = LazyKt.lazy(new CommonSongListItemViewHolder$contentContainer$2(r100));
        this.f69665b = LazyKt.lazy(new CommonSongListItemViewHolder$musicCover$2(r100));
        this.f69666c = LazyKt.lazy(new CommonSongListItemViewHolder$musicDuration$2(r100));
        Lazy r102 = LazyKt.lazy(new CommonSongListItemViewHolder$musicName$2(r100));
        this.f69667d = r102;
        Lazy r103 = LazyKt.lazy(new CommonSongListItemViewHolder$musicAuthor$2(r100));
        this.f69668e = r103;
        Lazy r104 = LazyKt.lazy(new CommonSongListItemViewHolder$favorite$2(r100));
        this.f69669f = r104;
        this.f69670g = LazyKt.lazy(new CommonSongListItemViewHolder$selectMusicBtn$2(r100));
        Lazy r105 = LazyKt.lazy(new CommonSongListItemViewHolder$footerView$2(r100));
        this.f69671h = r105;
        TextView r106 = (TextView) r102.getValue();
        if (r106 == null) goto L5;
        KtvOrderSongThemeManager.d(r106, 10);
    L5:
        TextView r107 = (TextView) r103.getValue();
        if (r107 == null) goto L8;
        KtvOrderSongThemeManager.d(r107, 101);
    L8:
        TextView r108 = (TextView) r105.getValue();
        if (r108 == null) goto L11;
        KtvOrderSongThemeManager.d(r108, KtvOrderSongThemeManager.f70202k);
    L11:
        KtvUtilsKt.b((TextView) r102.getValue());
        KtvUtilsKt.b((TextView) r103.getValue());
        View r109 = (View) r104.getValue();
        if (r109 == null) goto L14;
        r109.setOnClickListener(new com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab.b(this));
    L14:
        TextView r110 = T3();
        if (r110 == null) goto L17;
        r110.setOnClickListener(x0.a(new CommonSongListItemViewHolder$bindClickListener$2(this)));
    L17:
        this.f69673j = new b(this);
    }
}

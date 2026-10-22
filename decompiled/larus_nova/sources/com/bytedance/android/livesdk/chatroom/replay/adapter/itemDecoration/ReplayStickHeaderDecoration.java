package com.bytedance.android.livesdk.chatroom.replay.adapter.itemDecoration;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeGroup;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/adapter/itemDecoration/ReplayStickHeaderDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplayStickHeaderDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f108124e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f108125f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f108126g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f108127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f108128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f108129c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f108130d;

    public static final class a {
    }

    static {
        f108124e = s1.f(44.0f);
        f108125f = s1.f(16.0f);
        f108126g = s1.f(15.0f);
    }

    public ReplayStickHeaderDecoration() {
        Paint r100 = new Paint(1);
        this.f108127a = r100;
        Paint r101 = new Paint(1);
        this.f108128b = r101;
        Paint r102 = new Paint(1);
        this.f108129c = r102;
        this.f108130d = new Rect();
        r101.setColor(-16777216);
        r100.setColor(0);
        r102.setTextSize(f108126g);
        r102.setColor(-1);
    }

    public final String h(List<?> r100, int r101) {
        Object r102 = ListProtector.get(r100, r101);
        if ((r102 instanceof EpisodeGroup) == false) goto L11;
        Object r103 = ListProtector.get(r100, r101);
        if (r103 == null) goto L9;
        return String.valueOf(((EpisodeGroup) r103).groupName);
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeGroup");
    L11:
        if ((r102 instanceof com.bytedance.android.livesdk.chatroom.replay.adapter.a) == false) goto L18;
        Object r104 = ListProtector.get(r100, r101);
        if (r104 == null) goto L17;
        return String.valueOf(((com.bytedance.android.livesdk.chatroom.replay.adapter.a) r104).f108113b);
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.replay.adapter.EpisodeWrapper");
    L18:
        return "";
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDraw(Canvas r110, RecyclerView r111, RecyclerView.State r112) {
        Intrinsics.checkNotNullParameter(r110, "c");
        Intrinsics.checkNotNullParameter(r111, "parent");
        Intrinsics.checkNotNullParameter(r112, "state");
        if (r111.getAdapter() == null) goto L17;
        RecyclerView.Adapter r100 = r111.getAdapter();
        if (r100 == null) goto L16;
        List<?> r101 = ((MultiTypeAdapter) r100).f513437a;
        int r113 = r111.getChildCount();
        int r114 = 0;
    L7:
        if (r114 >= r113) goto L21;
        View r115 = r111.getChildAt(r114);
        int r116 = r111.getChildLayoutPosition(r115);
        if (r101.size() > r116) goto L11;
        boolean r102 = false;
    L12:
        if (r102 == false) goto L14;
        int r103 = r115.getTop();
        int r117 = f108124e;
        r110.drawRect(0.0f, r103 - r117, r111.getWidth(), r115.getTop(), this.f108127a);
        this.f108129c.getTextBounds(h(r101, r116), 0, h(r101, r116).length(), this.f108130d);
        r110.drawText(h(r101, r116), f108125f, (r115.getTop() - ((r117 - 6) / 2)) + (this.f108130d.height() / 2), this.f108129c);
    L14:
        r114 = r114 + 1;
        goto L7
    L11:
        r102 = ListProtector.get(r101, r116) instanceof EpisodeGroup;
        goto L12
    L21:
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type me.drakeet.multitype.MultiTypeAdapter");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDrawOver(Canvas r110, RecyclerView r111, RecyclerView.State r112) {
        Intrinsics.checkNotNullParameter(r110, "c");
        Intrinsics.checkNotNullParameter(r111, "parent");
        Intrinsics.checkNotNullParameter(r112, "state");
        if (r111.getAdapter() != null) goto L5;
        return;
    L5:
        if (r111.getLayoutManager() == null) goto L51;
        RecyclerView.Adapter r113 = r111.getAdapter();
        if (r113 == null) goto L49;
        List<?> r114 = ((MultiTypeAdapter) r113).f513437a;
        RecyclerView.LayoutManager r100 = r111.getLayoutManager();
        if (r100 == null) goto L47;
        int r101 = ((LinearLayoutManager) r100).findFirstVisibleItemPosition();
        RecyclerView.ViewHolder r102 = r111.findViewHolderForAdapterPosition(r101);
        if (r102 == null) goto L52;
        View r103 = r102.itemView;
        if (r103 == null) goto L53;
        int r104 = r101 + 1;
        if (r114.size() > r104) goto L17;
        boolean r105 = false;
    L19:
        if (r105 == false) goto L38;
        if (r101 == 0) goto L38;
        int r106 = f108124e;
        int r107 = Math.min(r106, r103.getBottom());
        this.f108129c.getTextBounds(h(r114, r101), 0, h(r114, r101).length(), this.f108130d);
        if (uk1.a.f550486d == false) goto L37;
        Bitmap r108 = uk1.a.a();
        if (r108 == null) goto L36;
        Rect r109 = new Rect(0, 0, r111.getWidth(), r107);
        if (r103.getBottom() >= r106) goto L35;
        new Matrix().postTranslate(0.0f, r106 - r107);
        int r115 = (int) (((double) r107) + 0.5d);
        if (r115 <= 0) goto L36;
        if (r115 > r108.getHeight()) goto L36;
        int r116 = r111.getWidth();
        if (r116 <= r108.getWidth()) goto L34;
        r116 = r108.getWidth();
    L34:
        r110.drawBitmap(Bitmap.createBitmap(r108, 0, 0, r116, r115), null, r109, this.f108128b);
        goto L36
    L35:
        r110.drawBitmap(r108, null, r109, this.f108128b);
    L36:
        r110.drawText(h(r114, r101), f108125f, ((this.f108130d.height() / 2) - ((r106 - 6) / 2)) + r107, this.f108129c);
    L45:
        r110.save();
        return;
    L37:
        r110.drawRect(new Rect(0, 0, r111.getWidth(), r107), this.f108128b);
        r110.drawText(h(r114, r101), f108125f, ((this.f108130d.height() / 2) - ((r106 - 6) / 2)) + r107, this.f108129c);
    L38:
        int r117 = r111.getWidth();
        int r118 = f108124e;
        Rect r119 = new Rect(0, 0, r117, r118);
        if (uk1.a.f550486d == false) goto L43;
        Bitmap r120 = uk1.a.a();
        if (r120 == null) goto L44;
        r110.drawBitmap(r120, null, r119, this.f108128b);
    L44:
        this.f108129c.getTextBounds(h(r114, r101), 0, h(r114, r101).length(), this.f108130d);
        r110.drawText(h(r114, r101), f108125f, ((r118 + 6) / 2) + (this.f108130d.height() / 2), this.f108129c);
        goto L45
    L43:
        r110.drawRect(r119, this.f108128b);
        goto L44
    L17:
        r105 = ListProtector.get(r114, r104) instanceof EpisodeGroup;
        goto L19
    L53:
        return;
    L52:
        return;
    L47:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
    L49:
        throw new NullPointerException("null cannot be cast to non-null type me.drakeet.multitype.MultiTypeAdapter");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        if (r102.getAdapter() == null) goto L11;
        MultiTypeAdapter r104 = (MultiTypeAdapter) r102.getAdapter();
        Intrinsics.checkNotNull(r104);
        List<?> r105 = r104.f513437a;
        int r106 = r102.getChildLayoutPosition(r101);
        if (r105.size() > r106) goto L7;
        boolean r107 = false;
    L8:
        if (r107 == false) goto L12;
        r100.top = f108124e;
        return;
    L12:
        return;
    L7:
        r107 = ListProtector.get(r105, r106) instanceof EpisodeGroup;
        goto L8
    }
}

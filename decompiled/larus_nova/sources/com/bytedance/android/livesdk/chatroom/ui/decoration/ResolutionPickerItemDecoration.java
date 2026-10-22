package com.bytedance.android.livesdk.chatroom.ui.decoration;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/decoration/ResolutionPickerItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "<init>", "()V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ResolutionPickerItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f112745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f112746b;

    public ResolutionPickerItemDecoration() {
        this.f112745a = UtilityKotlinExtentionsKt.i(1);
        Paint r100 = new Paint();
        r100.setAntiAlias(true);
        r100.setColor(s1.h(R.color.ttlive_dialog_divider_line));
        Unit r101 = Unit.INSTANCE;
        this.f112746b = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDraw(Canvas r110, RecyclerView r111, RecyclerView.State r112) {
        Intrinsics.checkNotNullParameter(r110, "c");
        Intrinsics.checkNotNullParameter(r111, "parent");
        Intrinsics.checkNotNullParameter(r112, "state");
        super.onDraw(r110, r111, r112);
        int r113 = r111.getChildCount();
        int r100 = 0;
    L3:
        if (r100 >= r113) goto L8;
        View r101 = r111.getChildAt(r100);
        if (r111.getChildAdapterPosition(r101) == 0) goto L7;
        r110.drawRect(0, r101.getTop() - this.f112745a, r111.getWidth(), r101.getTop(), this.f112746b);
    L7:
        r100 = r100 + 1;
        goto L3
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        super.getItemOffsets(r100, r101, r102, r103);
        if (r102.getChildAdapterPosition(r101) == 0) goto L6;
        r100.top = this.f112745a;
        return;
    }
}

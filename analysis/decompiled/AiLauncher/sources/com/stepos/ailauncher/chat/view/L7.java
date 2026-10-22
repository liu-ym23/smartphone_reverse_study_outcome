package com.stepos.ailauncher.chat.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB'\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ'\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/stepos/ailauncher/chat/view/L7;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "", "", "sectionViewTypes", "", "radiusPx", "fillColor", "<init>", "(Ljava/util/Set;FI)V", "Landroid/graphics/Canvas;", "c", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", VoiceWakeupReceiver.EXTRA_STATE, "LY8/t;", "onDraw", "(Landroid/graphics/Canvas;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "Ljava/util/Set;", "radius", "F", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Paint;", "Landroid/graphics/Path;", "path", "Landroid/graphics/Path;", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class L7 extends RecyclerView.ItemDecoration {
    private static final a Companion = new a(null);
    private static final int DEFAULT_COLOR = Color.parseColor("#1F74747F");
    private final Paint paint;
    private final Path path;
    private final float radius;
    private final Set<Integer> sectionViewTypes;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/stepos/ailauncher/chat/view/L7$a;", "", "<init>", "()V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    public L7(Set<Integer> sectionViewTypes, float f10, int i10) {
        kotlin.jvm.internal.p.i(sectionViewTypes, "sectionViewTypes");
        this.sectionViewTypes = sectionViewTypes;
        this.radius = f10;
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(i10);
        this.paint = paint;
        this.path = new Path();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas c10, RecyclerView parent, RecyclerView.State state) {
        int itemCount;
        kotlin.jvm.internal.p.i(c10, "c");
        kotlin.jvm.internal.p.i(parent, "parent");
        kotlin.jvm.internal.p.i(state, "state");
        RecyclerView.Adapter adapter = parent.getAdapter();
        if (adapter == null || (itemCount = adapter.getItemCount()) == 0) {
            return;
        }
        int childCount = parent.getChildCount();
        float fMax = -3.4028235E38f;
        float f10 = Float.MAX_VALUE;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = parent.getChildAt(i10);
            int childAdapterPosition = parent.getChildAdapterPosition(childAt);
            if (childAdapterPosition != -1 && this.sectionViewTypes.contains(Integer.valueOf(adapter.getItemViewType(childAdapterPosition)))) {
                float top = childAt.getTop() + childAt.getTranslationY();
                float bottom = childAt.getBottom() + childAt.getTranslationY();
                if (top < f10) {
                    f10 = top;
                }
                if (bottom > fMax) {
                    fMax = bottom;
                }
                boolean z13 = childAdapterPosition > 0 && this.sectionViewTypes.contains(Integer.valueOf(adapter.getItemViewType(childAdapterPosition + (-1))));
                boolean z14 = childAdapterPosition < itemCount + (-1) && this.sectionViewTypes.contains(Integer.valueOf(adapter.getItemViewType(childAdapterPosition + 1)));
                if (!z13) {
                    z12 = true;
                }
                if (z14) {
                    z10 = true;
                } else {
                    z10 = true;
                    z11 = true;
                }
            }
        }
        if (z10) {
            float paddingLeft = parent.getPaddingLeft();
            float width = parent.getWidth() - parent.getPaddingRight();
            if (z11) {
                fMax = Math.max(fMax, parent.getHeight());
            }
            float f11 = fMax;
            float f12 = z12 ? this.radius : 0.0f;
            float f13 = z11 ? this.radius : 0.0f;
            this.path.reset();
            this.path.addRoundRect(paddingLeft, f10, width, f11, new float[]{f12, f12, f12, f12, f13, f13, f13, f13}, Path.Direction.CW);
            c10.drawPath(this.path, this.paint);
        }
    }

    public /* synthetic */ L7(Set set, float f10, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(set, f10, (i11 & 4) != 0 ? DEFAULT_COLOR : i10);
    }
}

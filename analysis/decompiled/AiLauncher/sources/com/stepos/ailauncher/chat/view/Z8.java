package com.stepos.ailauncher.chat.view;

import android.content.Context;
import android.graphics.Paint;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/stepos/ailauncher/chat/view/Z8;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/graphics/Canvas;", "c", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", VoiceWakeupReceiver.EXTRA_STATE, "LY8/t;", "onDrawOver", "(Landroid/graphics/Canvas;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "", "density", "F", "thickness", "leftInset", "rightInset", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Paint;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Z8 extends RecyclerView.ItemDecoration {
    private final float density;
    private final float leftInset;
    private final Paint paint;
    private final float rightInset;
    private final float thickness;

    public Z8(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        float f10 = context.getResources().getDisplayMetrics().density;
        this.density = f10;
        this.thickness = C5685n.e(f10, 1.0f);
        this.leftInset = 56.0f * f10;
        this.rightInset = f10 * 16.0f;
        Paint paint = new Paint(1);
        paint.setColor(352321535);
        this.paint = paint;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0032  */
    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onDrawOver(android.graphics.Canvas r12, androidx.recyclerview.widget.RecyclerView r13, androidx.recyclerview.widget.RecyclerView.State r14) {
        /*
            r11 = this;
            java.lang.String r0 = "c"
            kotlin.jvm.internal.p.i(r12, r0)
            java.lang.String r0 = "parent"
            kotlin.jvm.internal.p.i(r13, r0)
            java.lang.String r0 = "state"
            kotlin.jvm.internal.p.i(r14, r0)
            androidx.recyclerview.widget.RecyclerView$Adapter r14 = r13.getAdapter()
            if (r14 != 0) goto L18
            goto L67
        L18:
            int r0 = r13.getChildCount()
            r1 = 0
        L1d:
            if (r1 >= r0) goto L67
            android.view.View r2 = r13.getChildAt(r1)
            int r3 = r13.getChildAdapterPosition(r2)
            r4 = -1
            if (r3 == r4) goto L32
            int r4 = r14.getItemCount()
            int r4 = r4 + (-1)
            if (r3 < r4) goto L34
        L32:
            r5 = r12
            goto L63
        L34:
            int r3 = r2.getLeft()
            int r4 = r13.getPaddingLeft()
            int r3 = r3 - r4
            float r3 = (float) r3
            float r4 = r11.leftInset
            float r6 = r3 + r4
            int r3 = r2.getRight()
            int r4 = r13.getPaddingRight()
            int r3 = r3 + r4
            float r3 = (float) r3
            float r4 = r11.rightInset
            float r8 = r3 - r4
            int r3 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r3 <= 0) goto L32
            int r2 = r2.getBottom()
            float r7 = (float) r2
            float r2 = r11.thickness
            float r9 = r7 + r2
            android.graphics.Paint r10 = r11.paint
            r5 = r12
            r5.drawRect(r6, r7, r8, r9, r10)
        L63:
            int r1 = r1 + 1
            r12 = r5
            goto L1d
        L67:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.view.Z8.onDrawOver(android.graphics.Canvas, androidx.recyclerview.widget.RecyclerView, androidx.recyclerview.widget.RecyclerView$State):void");
    }
}

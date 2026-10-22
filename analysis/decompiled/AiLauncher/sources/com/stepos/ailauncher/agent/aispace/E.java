package com.stepos.ailauncher.agent.aispace;

import android.content.Context;
import android.graphics.Paint;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tJ'\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/E;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/content/Context;", "context", "Lkotlin/Function1;", "", "", "isEligible", "<init>", "(Landroid/content/Context;Lp9/l;)V", "Landroid/graphics/Canvas;", "c", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", VoiceWakeupReceiver.EXTRA_STATE, "LY8/t;", "onDrawOver", "(Landroid/graphics/Canvas;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "Lp9/l;", "", "density", "F", "height", "leftInset", "rightInset", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Paint;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class E extends RecyclerView.ItemDecoration {
    private final float density;
    private final float height;
    private final InterfaceC5074l<Integer, Boolean> isEligible;
    private final float leftInset;
    private final Paint paint;
    private final float rightInset;

    /* JADX WARN: Multi-variable type inference failed */
    public E(Context context, InterfaceC5074l<? super Integer, Boolean> isEligible) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(isEligible, "isEligible");
        this.isEligible = isEligible;
        float f10 = context.getResources().getDisplayMetrics().density;
        this.density = f10;
        this.height = C5685n.e(0.5f * f10, 1.0f);
        this.leftInset = 56.0f * f10;
        this.rightInset = f10 * 16.0f;
        Paint paint = new Paint(1);
        paint.setColor(b5.m.INSTANCE.f(context));
        this.paint = paint;
    }

    public static final boolean b(int i10) {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005f  */
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
            if (r14 != 0) goto L19
            goto L90
        L19:
            int r0 = r13.getChildCount()
            r1 = 0
        L1e:
            if (r1 >= r0) goto L90
            android.view.View r2 = r13.getChildAt(r1)
            int r3 = r13.getChildAdapterPosition(r2)
            r4 = -1
            if (r3 == r4) goto L5f
            int r4 = r3 + 1
            int r5 = r14.getItemCount()
            if (r4 >= r5) goto L5f
            int r3 = r14.getItemViewType(r3)
            int r4 = r14.getItemViewType(r4)
            p9.l<java.lang.Integer, java.lang.Boolean> r5 = r11.isEligible
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.Object r3 = r5.invoke(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L5f
            p9.l<java.lang.Integer, java.lang.Boolean> r3 = r11.isEligible
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.Object r3 = r3.invoke(r4)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 != 0) goto L61
        L5f:
            r5 = r12
            goto L8c
        L61:
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
            int r2 = r2.getBottom()
            float r7 = (float) r2
            float r2 = r11.height
            float r9 = r7 + r2
            android.graphics.Paint r10 = r11.paint
            r5 = r12
            r5.drawRect(r6, r7, r8, r9, r10)
        L8c:
            int r1 = r1 + 1
            r12 = r5
            goto L1e
        L90:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.E.onDrawOver(android.graphics.Canvas, androidx.recyclerview.widget.RecyclerView, androidx.recyclerview.widget.RecyclerView$State):void");
    }

    public /* synthetic */ E(Context context, InterfaceC5074l interfaceC5074l, int i10, kotlin.jvm.internal.i iVar) {
        this(context, (i10 & 2) != 0 ? new InterfaceC5074l() { // from class: com.stepos.ailauncher.agent.aispace.D
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(E.b(((Integer) obj).intValue()));
            }
        } : interfaceC5074l);
    }
}

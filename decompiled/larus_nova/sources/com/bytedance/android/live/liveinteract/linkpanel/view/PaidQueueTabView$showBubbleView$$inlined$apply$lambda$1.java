package com.bytedance.android.live.liveinteract.linkpanel.view;

import android.widget.TextView;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"updateAllBubbleSelectUi", "", "selectSortType", "", AbsMethodDelegate.TAG_INVOKE, "com/bytedance/android/live/liveinteract/linkpanel/view/PaidQueueTabView$showBubbleView$1$1"}, k = 3, mv = {1, 5, 1})
final class PaidQueueTabView$showBubbleView$$inlined$apply$lambda$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ Ref.ObjectRef $fanTv;
    final /* synthetic */ Ref.ObjectRef $firstFocusableView$inlined;
    final /* synthetic */ Ref.ObjectRef $recommendTv;
    final /* synthetic */ int $sortType$inlined;
    final /* synthetic */ Ref.ObjectRef $timeTv;
    final /* synthetic */ int $txPadding$inlined;
    final /* synthetic */ PaidQueueTabView this$0;

    public PaidQueueTabView$showBubbleView$$inlined$apply$lambda$1(Ref.ObjectRef r100, Ref.ObjectRef r101, Ref.ObjectRef r102, PaidQueueTabView r103, int r104, Ref.ObjectRef r105, int r106) {
        this.$timeTv = r100;
        this.$fanTv = r101;
        this.$recommendTv = r102;
        this.this$0 = r103;
        this.$txPadding$inlined = r104;
        this.$firstFocusableView$inlined = r105;
        this.$sortType$inlined = r106;
        super(1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void invoke(int r100) {
        switch(r100) {
            case 40: goto L23;
            case 41: goto L14;
            case 42: goto L5;
            default: goto L38;
        };
    L5:
        TextView r101 = (TextView) this.$timeTv.element;
        if (r101 == null) goto L8;
        this.this$0.U5(r101, false);
    L8:
        TextView r102 = (TextView) this.$fanTv.element;
        if (r102 == null) goto L11;
        this.this$0.U5(r102, false);
    L11:
        TextView r103 = (TextView) this.$recommendTv.element;
        if (r103 == null) goto L33;
        this.this$0.U5(r103, true);
        return;
    L33:
        return;
    L14:
        TextView r104 = (TextView) this.$timeTv.element;
        if (r104 == null) goto L17;
        this.this$0.U5(r104, false);
    L17:
        TextView r105 = (TextView) this.$fanTv.element;
        if (r105 == null) goto L20;
        this.this$0.U5(r105, true);
    L20:
        TextView r106 = (TextView) this.$recommendTv.element;
        if (r106 == null) goto L35;
        this.this$0.U5(r106, false);
        return;
    L35:
        return;
    L23:
        TextView r107 = (TextView) this.$timeTv.element;
        if (r107 == null) goto L26;
        this.this$0.U5(r107, true);
    L26:
        TextView r108 = (TextView) this.$fanTv.element;
        if (r108 == null) goto L29;
        this.this$0.U5(r108, false);
    L29:
        TextView r109 = (TextView) this.$recommendTv.element;
        if (r109 == null) goto L37;
        this.this$0.U5(r109, false);
        return;
    L37:
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer r100) {
        invoke(r100.intValue());
        return Unit.INSTANCE;
    }
}

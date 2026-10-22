package com.obric.oui.scrollbar;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.GlobalProxyLancet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: RecyclerViewScrollBarHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tJ\u0014\u0010\n\u001a\u00020\u0006*\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tJ\u001c\u0010\u000b\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u001c\u0010\r\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/oui/scrollbar/RecyclerViewScrollBarHelper;", "", "()V", "TAG", "", "adjustScrollBarVisibilityDynamic", "", "Landroidx/recyclerview/widget/RecyclerView;", "maxScreens", "", "adjustScrollBarVisibilityEfficiently", "updateScrollBarVisibilityByItemCount", "scene", "updateScrollBarWithStableHeight", "contentHeight", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RecyclerViewScrollBarHelper {
    public static final RecyclerViewScrollBarHelper INSTANCE = null;
    private static final String TAG = "RecyclerViewScrollBarHelper";

    /* JADX INFO: renamed from: com.obric.oui.scrollbar.RecyclerViewScrollBarHelper$adjustScrollBarVisibilityDynamic$3, reason: invalid class name */
    /* JADX INFO: compiled from: RecyclerViewScrollBarHelper.kt */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\t"}, d2 = {"com/obric/oui/scrollbar/RecyclerViewScrollBarHelper$adjustScrollBarVisibilityDynamic$3", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeInserted", "positionStart", "", "itemCount", "onItemRangeRemoved", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class AnonymousClass3 extends RecyclerView.AdapterDataObserver {
        final /* synthetic */ Ref.IntRef $maxContentHeight;
        final /* synthetic */ float $maxScreens;
        final /* synthetic */ RecyclerView $this_adjustScrollBarVisibilityDynamic;

        /* JADX INFO: renamed from: $r8$lambda$TEaG71vGjDO9w-_H5l4WHgblJTs, reason: not valid java name */
        public static /* synthetic */ void m655$r8$lambda$TEaG71vGjDO9w_H5l4WHgblJTs(RecyclerView r0, Ref.IntRef r1, float r2) {
            m658onItemRangeInserted$lambda1(r0, r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$XflT6eY4E7FHfQKK2ZRQEywTiS4(Ref.IntRef r0, RecyclerView r1, float r2) {
            m659onItemRangeRemoved$lambda2(r0, r1, r2);
        }

        /* JADX INFO: renamed from: $r8$lambda$scXfCaplnlu1ekug1rPYx8-f6LU, reason: not valid java name */
        public static /* synthetic */ void m656$r8$lambda$scXfCaplnlu1ekug1rPYx8f6LU(Ref.IntRef r0, RecyclerView r1, float r2) {
            m657onChanged$lambda0(r0, r1, r2);
        }

        AnonymousClass3(RecyclerView r1, Ref.IntRef r2, float r3) {
            this.$this_adjustScrollBarVisibilityDynamic = r1;
            this.$maxContentHeight = r2;
            this.$maxScreens = r3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            final RecyclerView r0 = this.$this_adjustScrollBarVisibilityDynamic;
            final Ref.IntRef r1 = this.$maxContentHeight;
            final float r3 = this.$maxScreens;
            r0.post(new RecyclerViewScrollBarHelper$adjustScrollBarVisibilityDynamic$3$$ExternalSyntheticLambda2(r1, r0, r3));
        }

        /* JADX INFO: renamed from: onChanged$lambda-0, reason: not valid java name */
        private static final void m657onChanged$lambda0(Ref.IntRef r1, RecyclerView r2, float r3) {
            Intrinsics.checkNotNullParameter(r1, "$maxContentHeight");
            Intrinsics.checkNotNullParameter(r2, "$this_adjustScrollBarVisibilityDynamic");
            r1.element = 0;
            RecyclerViewScrollBarHelper.access$updateScrollBarWithStableHeight(RecyclerViewScrollBarHelper.INSTANCE, r2, r3, r2.computeVerticalScrollRange());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int r2, int r3) {
            final RecyclerView r4 = this.$this_adjustScrollBarVisibilityDynamic;
            final Ref.IntRef r5 = this.$maxContentHeight;
            final float r1 = this.$maxScreens;
            r4.post(new RecyclerViewScrollBarHelper$adjustScrollBarVisibilityDynamic$3$$ExternalSyntheticLambda0(r4, r5, r1));
        }

        /* JADX INFO: renamed from: onItemRangeInserted$lambda-1, reason: not valid java name */
        private static final void m658onItemRangeInserted$lambda1(RecyclerView r2, Ref.IntRef r3, float r4) {
            Intrinsics.checkNotNullParameter(r2, "$this_adjustScrollBarVisibilityDynamic");
            Intrinsics.checkNotNullParameter(r3, "$maxContentHeight");
            int r0 = r2.computeVerticalScrollRange();
            if (r0 <= r3.element) goto L5;
            r3.element = r0;
        L5:
            RecyclerViewScrollBarHelper.access$updateScrollBarWithStableHeight(RecyclerViewScrollBarHelper.INSTANCE, r2, r4, r3.element);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int r2, int r3) {
            final RecyclerView r4 = this.$this_adjustScrollBarVisibilityDynamic;
            final Ref.IntRef r5 = this.$maxContentHeight;
            final float r1 = this.$maxScreens;
            r4.post(new RecyclerViewScrollBarHelper$adjustScrollBarVisibilityDynamic$3$$ExternalSyntheticLambda1(r5, r4, r1));
        }

        /* JADX INFO: renamed from: onItemRangeRemoved$lambda-2, reason: not valid java name */
        private static final void m659onItemRangeRemoved$lambda2(Ref.IntRef r1, RecyclerView r2, float r3) {
            Intrinsics.checkNotNullParameter(r1, "$maxContentHeight");
            Intrinsics.checkNotNullParameter(r2, "$this_adjustScrollBarVisibilityDynamic");
            r1.element = 0;
            RecyclerViewScrollBarHelper.access$updateScrollBarWithStableHeight(RecyclerViewScrollBarHelper.INSTANCE, r2, r3, r2.computeVerticalScrollRange());
        }
    }

    public static /* synthetic */ void $r8$lambda$2g8mfwrfARH3xGvMrBg8plEP12E(RecyclerView r0, float r1, Ref.IntRef r2) {
        m652adjustScrollBarVisibilityDynamic$lambda3$lambda2(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$BWsKZPaY9bOBydgcMyqr2mPYcSo(RecyclerView r0, float r1, Ref.IntRef r2, View r3, int r4, int r5, int r6, int r7, int r8, int r9, int r10, int r11) {
        m651adjustScrollBarVisibilityDynamic$lambda3(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ void $r8$lambda$UNCMdqBqquub2Sscn_QMH7A7zmc(RecyclerView r0, float r1) {
        m654adjustScrollBarVisibilityEfficiently$lambda1$lambda0(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$oG7O_vu9hzL5nbXGrhF8zwLRzRY(RecyclerView r0, float r1, View r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9, int r10) {
        m653adjustScrollBarVisibilityEfficiently$lambda1(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    static {
        INSTANCE = new RecyclerViewScrollBarHelper();
    }

    private RecyclerViewScrollBarHelper() {
    }

    public static final /* synthetic */ void access$updateScrollBarVisibilityByItemCount(RecyclerViewScrollBarHelper r0, RecyclerView r1, float r2, String r3) {
        r0.updateScrollBarVisibilityByItemCount(r1, r2, r3);
    }

    public static final /* synthetic */ void access$updateScrollBarWithStableHeight(RecyclerViewScrollBarHelper r0, RecyclerView r1, float r2, int r3) {
        r0.updateScrollBarWithStableHeight(r1, r2, r3);
    }

    public static /* synthetic */ void adjustScrollBarVisibilityEfficiently$default(RecyclerViewScrollBarHelper r0, RecyclerView r1, float r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L5;
        r2 = 3.0f;
    L5:
        r0.adjustScrollBarVisibilityEfficiently(r1, r2);
    }

    public final void adjustScrollBarVisibilityEfficiently(final RecyclerView r2, final float r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, Intrinsics.stringPlus("adjustScrollBarVisibilityEfficiently, maxScreens: ", Float.valueOf(r3)));
        r2.setVerticalScrollBarEnabled(false);
        r2.addOnLayoutChangeListener(new RecyclerViewScrollBarHelper$$ExternalSyntheticLambda1(r2, r3));
        r2.addOnScrollListener(new C03682(r2, r3));
    }

    /* JADX INFO: renamed from: adjustScrollBarVisibilityEfficiently$lambda-1, reason: not valid java name */
    private static final void m653adjustScrollBarVisibilityEfficiently$lambda1(final RecyclerView r0, final float r1, View r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9, int r10) {
        Intrinsics.checkNotNullParameter(r0, "$this_adjustScrollBarVisibilityEfficiently");
        r0.post(new RecyclerViewScrollBarHelper$$ExternalSyntheticLambda0(r0, r1));
    }

    /* JADX INFO: renamed from: adjustScrollBarVisibilityEfficiently$lambda-1$lambda-0, reason: not valid java name */
    private static final void m654adjustScrollBarVisibilityEfficiently$lambda1$lambda0(RecyclerView r2, float r3) {
        Intrinsics.checkNotNullParameter(r2, "$this_adjustScrollBarVisibilityEfficiently");
        INSTANCE.updateScrollBarVisibilityByItemCount(r2, r3, "onLayoutChange");
    }

    private final void updateScrollBarVisibilityByItemCount(RecyclerView r10, float r11, String r12) {
        RecyclerView.LayoutManager r9 = r10.getLayoutManager();
        if ((r9 instanceof LinearLayoutManager) == false) goto L5;
        LinearLayoutManager r13 = (LinearLayoutManager) r9;
    L6:
        if (r13 != null) goto L8;
        return;
    L8:
        int r0 = r13.findFirstVisibleItemPosition();
        int r14 = r13.findLastVisibleItemPosition();
        boolean r2 = true;
        int r1 = (r14 - r0) + 1;
        RecyclerView.Adapter r3 = r10.getAdapter();
        if (r3 != null) goto L11;
        int r4 = 0;
    L13:
        if (r1 <= 0) goto L16;
        if (r4 <= 0) goto L16;
        float r7 = r4 / r1;
    L18:
        if (r7 >= r11) goto L21;
        r2 = false;
    L21:
        r10.setVerticalScrollBarEnabled(r2);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "updateScrollBarVisibilityByItemCount, scene: " + r12 + ", isVerticalScrollBarEnabled: " + r10.isVerticalScrollBarEnabled() + ", estimatedScreens: " + r7 + ", totalItemCount: " + r4 + ", visibleItemCount: " + r1 + ", firstVisibleItemPosition: " + r0 + ", lastVisibleItemPosition: " + r14);
        return;
    L16:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "updateScrollBarVisibilityByItemCount, error! totalItemCount: " + r4 + ", visibleItemCount: " + r1);
        r7 = 0.0f;
        goto L18
    L11:
        r4 = r3.getItemCount();
        goto L13
    L5:
        r13 = null;
        goto L6
    }

    public static /* synthetic */ void adjustScrollBarVisibilityDynamic$default(RecyclerViewScrollBarHelper r0, RecyclerView r1, float r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L5;
        r2 = 3.0f;
    L5:
        r0.adjustScrollBarVisibilityDynamic(r1, r2);
    }

    public final void adjustScrollBarVisibilityDynamic(final RecyclerView r3, final float r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, Intrinsics.stringPlus("adjustScrollBarVisibilityDynamic, maxScreens: ", Float.valueOf(r4)));
        r3.setVerticalScrollBarEnabled(false);
        final Ref.IntRef r2 = new Ref.IntRef();
        r3.addOnLayoutChangeListener(new RecyclerViewScrollBarHelper$$ExternalSyntheticLambda2(r3, r4, r2));
        r3.addOnScrollListener(new AnonymousClass2(r3, r2, r4));
        RecyclerView.Adapter r0 = r3.getAdapter();
        if (r0 == null) goto L7;
        r0.registerAdapterDataObserver(new AnonymousClass3(r3, r2, r4));
        return;
    }

    /* JADX INFO: renamed from: adjustScrollBarVisibilityDynamic$lambda-3, reason: not valid java name */
    private static final void m651adjustScrollBarVisibilityDynamic$lambda3(final RecyclerView r0, final float r1, final Ref.IntRef r2, View r3, int r4, int r5, int r6, int r7, int r8, int r9, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r0, "$this_adjustScrollBarVisibilityDynamic");
        Intrinsics.checkNotNullParameter(r2, "$maxContentHeight");
        r0.post(new RecyclerViewScrollBarHelper$$ExternalSyntheticLambda3(r0, r1, r2));
    }

    /* JADX INFO: renamed from: adjustScrollBarVisibilityDynamic$lambda-3$lambda-2, reason: not valid java name */
    private static final void m652adjustScrollBarVisibilityDynamic$lambda3$lambda2(RecyclerView r2, float r3, Ref.IntRef r4) {
        Intrinsics.checkNotNullParameter(r2, "$this_adjustScrollBarVisibilityDynamic");
        Intrinsics.checkNotNullParameter(r4, "$maxContentHeight");
        INSTANCE.updateScrollBarWithStableHeight(r2, r3, r4.element);
        int r5 = r2.computeVerticalScrollRange();
        if (r5 <= r4.element) goto L6;
        r4.element = r5;
        return;
    }

    private final void updateScrollBarWithStableHeight(RecyclerView r3, float r4, int r5) {
        int r2 = r3.computeVerticalScrollExtent();
        if (r2 <= 0) goto L6;
        if (r5 <= 0) goto L6;
        float r0 = r5 / r2;
    L8:
        if (r0 < r4) goto L10;
        boolean r6 = true;
    L12:
        if (r3.isVerticalScrollBarEnabled() == r6) goto L14;
        r3.setVerticalScrollBarEnabled(r6);
    L14:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "updateScrollBarWithStableHeight, isVerticalScrollBarEnabled: " + r3.isVerticalScrollBarEnabled() + ", contentScreens: " + r0 + ", contentHeight: " + r5 + ", visibleHeight: " + r2);
        return;
    L10:
        r6 = false;
    L6:
        r0 = 0.0f;
        goto L8
    }
}

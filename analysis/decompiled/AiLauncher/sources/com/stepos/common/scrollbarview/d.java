package com.stepos.common.scrollbarview;

import android.view.View;
import androidx.core.widget.NestedScrollView;
import com.stepos.common.scrollview.StepOSNestedScrollView;

/* loaded from: classes3.dex */
public class d {

    public class a implements StepOSNestedScrollView.a {
        final /* synthetic */ StepOSScrollBarView val$scrollBarView;

        public a(StepOSScrollBarView stepOSScrollBarView) {
            this.val$scrollBarView = stepOSScrollBarView;
        }

        @Override // Lc.a
        public void a(View view, int i10) {
        }

        @Override // Lc.a
        public void b(View view, float f10, float f11) {
            this.val$scrollBarView.c();
        }
    }

    public class b implements NestedScrollView.e {
        final /* synthetic */ StepOSScrollBarView val$scrollBarView;

        public b(StepOSScrollBarView stepOSScrollBarView) {
            this.val$scrollBarView = stepOSScrollBarView;
        }

        @Override // androidx.core.widget.NestedScrollView.e
        public void a(NestedScrollView nestedScrollView, int i10, int i11, int i12, int i13) {
            this.val$scrollBarView.c();
        }
    }

    public static void a(NestedScrollView nestedScrollView, StepOSScrollBarView stepOSScrollBarView) {
        stepOSScrollBarView.setScrollableView(nestedScrollView);
        if (nestedScrollView instanceof StepOSNestedScrollView) {
            ((StepOSNestedScrollView) nestedScrollView).W(new a(stepOSScrollBarView));
        }
        nestedScrollView.setOnScrollChangeListener(new b(stepOSScrollBarView));
    }

    public static void b(NestedScrollView nestedScrollView, StepOSScrollBarView stepOSScrollBarView) {
        a(nestedScrollView, stepOSScrollBarView);
    }
}

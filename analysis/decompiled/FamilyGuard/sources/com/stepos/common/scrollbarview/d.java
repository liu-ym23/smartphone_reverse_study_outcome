package com.stepos.common.scrollbarview;

import android.view.View;
import androidx.core.widget.NestedScrollView;
import com.stepos.common.scrollview.StepOSNestedScrollView;

/* loaded from: classes.dex */
public class d {

    class a implements StepOSNestedScrollView.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ StepOSScrollBarView f13763a;

        a(StepOSScrollBarView stepOSScrollBarView) {
            this.f13763a = stepOSScrollBarView;
        }

        @Override // e5.a
        public void a(View view, float f5, float f6) {
            this.f13763a.c();
        }

        @Override // e5.a
        public void b(View view, int i5) {
        }
    }

    class b implements NestedScrollView.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ StepOSScrollBarView f13764a;

        b(StepOSScrollBarView stepOSScrollBarView) {
            this.f13764a = stepOSScrollBarView;
        }

        @Override // androidx.core.widget.NestedScrollView.d
        public void a(NestedScrollView nestedScrollView, int i5, int i6, int i7, int i8) {
            this.f13764a.c();
        }
    }

    private static void a(NestedScrollView nestedScrollView, StepOSScrollBarView stepOSScrollBarView) {
        stepOSScrollBarView.setScrollableView(nestedScrollView);
        if (nestedScrollView instanceof StepOSNestedScrollView) {
            ((StepOSNestedScrollView) nestedScrollView).a0(new a(stepOSScrollBarView));
        }
        nestedScrollView.setOnScrollChangeListener(new b(stepOSScrollBarView));
    }

    public static void b(NestedScrollView nestedScrollView, StepOSScrollBarView stepOSScrollBarView) {
        a(nestedScrollView, stepOSScrollBarView);
    }
}

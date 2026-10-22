package androidx.core.view;

import android.R;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputMethodManager;

/* loaded from: classes.dex */
public final class C {

    /* renamed from: a, reason: collision with root package name */
    private final c f9717a;

    /* JADX INFO: Access modifiers changed from: private */
    static class a extends c {

        /* renamed from: a, reason: collision with root package name */
        private final View f9718a;

        a(View view) {
            this.f9718a = view;
        }

        @Override // androidx.core.view.C.c
        void a() {
            final View viewFindViewById = this.f9718a;
            if (viewFindViewById == null) {
                return;
            }
            if (viewFindViewById.isInEditMode() || viewFindViewById.onCheckIsTextEditor()) {
                viewFindViewById.requestFocus();
            } else {
                viewFindViewById = viewFindViewById.getRootView().findFocus();
            }
            if (viewFindViewById == null) {
                viewFindViewById = this.f9718a.getRootView().findViewById(R.id.content);
            }
            if (viewFindViewById == null || !viewFindViewById.hasWindowFocus()) {
                return;
            }
            viewFindViewById.post(new Runnable() { // from class: androidx.core.view.B
                @Override // java.lang.Runnable
                public final void run() {
                    View view = viewFindViewById;
                    ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
                }
            });
        }
    }

    private static class c {
        c() {
        }

        void a() {
            throw null;
        }
    }

    public C(View view) {
        this.f9717a = new b(view);
    }

    public void a() {
        this.f9717a.a();
    }

    private static class b extends a {

        /* renamed from: b, reason: collision with root package name */
        private View f9719b;

        /* renamed from: c, reason: collision with root package name */
        private WindowInsetsController f9720c;

        b(View view) {
            super(view);
            this.f9719b = view;
        }

        @Override // androidx.core.view.C.a, androidx.core.view.C.c
        void a() {
            View view = this.f9719b;
            WindowInsetsController windowInsetsController = this.f9720c;
            if (windowInsetsController == null) {
                windowInsetsController = view != null ? view.getWindowInsetsController() : null;
            }
            if (windowInsetsController != null) {
                windowInsetsController.show(WindowInsets.Type.ime());
            }
            super.a();
        }

        b(WindowInsetsController windowInsetsController) {
            super(null);
            this.f9720c = windowInsetsController;
        }
    }

    @Deprecated
    C(WindowInsetsController windowInsetsController) {
        this.f9717a = new b(windowInsetsController);
    }
}

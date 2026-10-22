package androidx.core.view;

import android.R;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputMethodManager;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class H {

    /* renamed from: a, reason: collision with root package name */
    public final c f13103a;

    public static class a extends c {

        /* renamed from: a, reason: collision with root package name */
        public final View f13104a;

        public a(View view) {
            this.f13104a = view;
        }

        @Override // androidx.core.view.H.c
        public void a() {
            View view = this.f13104a;
            if (view != null) {
                ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.f13104a.getWindowToken(), 0);
            }
        }

        @Override // androidx.core.view.H.c
        public void b() {
            final View viewFindViewById = this.f13104a;
            if (viewFindViewById == null) {
                return;
            }
            if (viewFindViewById.isInEditMode() || viewFindViewById.onCheckIsTextEditor()) {
                viewFindViewById.requestFocus();
            } else {
                viewFindViewById = viewFindViewById.getRootView().findFocus();
            }
            if (viewFindViewById == null) {
                viewFindViewById = this.f13104a.getRootView().findViewById(R.id.content);
            }
            if (viewFindViewById == null || !viewFindViewById.hasWindowFocus()) {
                return;
            }
            viewFindViewById.post(new Runnable() { // from class: androidx.core.view.G
                @Override // java.lang.Runnable
                public final void run() {
                    View view = viewFindViewById;
                    ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
                }
            });
        }
    }

    public static class c {
        public void a() {
            throw null;
        }

        public void b() {
            throw null;
        }
    }

    public H(View view) {
        this.f13103a = new b(view);
    }

    public void a() {
        this.f13103a.a();
    }

    public void b() {
        this.f13103a.b();
    }

    public static class b extends a {

        /* renamed from: b, reason: collision with root package name */
        public View f13105b;

        /* renamed from: c, reason: collision with root package name */
        public WindowInsetsController f13106c;

        public b(View view) {
            super(view);
            this.f13105b = view;
        }

        @Override // androidx.core.view.H.a, androidx.core.view.H.c
        public void a() {
            View view;
            WindowInsetsController windowInsetsController = this.f13106c;
            if (windowInsetsController == null) {
                View view2 = this.f13105b;
                windowInsetsController = view2 != null ? view2.getWindowInsetsController() : null;
            }
            if (windowInsetsController == null) {
                super.a();
                return;
            }
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            WindowInsetsController.OnControllableInsetsChangedListener onControllableInsetsChangedListener = new WindowInsetsController.OnControllableInsetsChangedListener() { // from class: androidx.core.view.I
                @Override // android.view.WindowInsetsController.OnControllableInsetsChangedListener
                public final void onControllableInsetsChanged(WindowInsetsController windowInsetsController2, int i10) {
                    atomicBoolean.set((i10 & 8) != 0);
                }
            };
            windowInsetsController.addOnControllableInsetsChangedListener(onControllableInsetsChangedListener);
            if (!atomicBoolean.get() && (view = this.f13105b) != null) {
                ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.f13105b.getWindowToken(), 0);
            }
            windowInsetsController.removeOnControllableInsetsChangedListener(onControllableInsetsChangedListener);
            windowInsetsController.hide(WindowInsets.Type.ime());
        }

        @Override // androidx.core.view.H.a, androidx.core.view.H.c
        public void b() {
            View view = this.f13105b;
            WindowInsetsController windowInsetsController = this.f13106c;
            if (windowInsetsController == null) {
                windowInsetsController = view != null ? view.getWindowInsetsController() : null;
            }
            if (windowInsetsController != null) {
                windowInsetsController.show(WindowInsets.Type.ime());
            }
            super.b();
        }

        public b(WindowInsetsController windowInsetsController) {
            super(null);
            this.f13106c = windowInsetsController;
        }
    }

    @Deprecated
    public H(WindowInsetsController windowInsetsController) {
        this.f13103a = new b(windowInsetsController);
    }
}

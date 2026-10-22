package s3;

import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import l3.C0843a;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f20267a = new f();

    private f() {
    }

    public static /* synthetic */ void e(f fVar, View view, int i5, float f5, boolean z5, boolean z6, float f6, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            f5 = 0.0f;
        }
        if ((i6 & 8) != 0) {
            z5 = false;
        }
        if ((i6 & 16) != 0) {
            z6 = true;
        }
        if ((i6 & 32) != 0) {
            f6 = 0.0f;
        }
        fVar.d(view, i5, f5, z5, z6, f6);
    }

    public static /* synthetic */ void g(f fVar, ViewGroup viewGroup, int i5, float f5, boolean z5, boolean z6, float f6, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            f5 = 0.0f;
        }
        if ((i6 & 8) != 0) {
            z5 = false;
        }
        if ((i6 & 16) != 0) {
            z6 = true;
        }
        if ((i6 & 32) != 0) {
            f6 = 0.0f;
        }
        fVar.f(viewGroup, i5, f5, z5, z6, f6);
    }

    private final void h(View view) {
        view.setTag(l3.h.f18419K, Boolean.TRUE);
    }

    public final void a(View view) {
        j4.k.g(view, "view");
        h(view);
        view.setStateListAnimator(AnimatorInflater.loadStateListAnimator(view.getContext(), C0843a.f18278a));
    }

    public final void b(View view) {
        j4.k.g(view, "view");
        view.setStateListAnimator(null);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
    }

    public final Drawable c(Context context, int i5, float f5, float f6) throws Resources.NotFoundException {
        j4.k.g(context, "context");
        Resources resources = context.getResources();
        return new i(i5, resources.getInteger(l3.i.f18453b), resources.getInteger(l3.i.f18454c), Math.max(0.0f, f6), Math.max(0.0f, f5), 1.0f - (kotlin.ranges.l.h(resources.getInteger(l3.i.f18455d), 0, 100) / 100.0f));
    }

    public final void d(View view, int i5, float f5, boolean z5, boolean z6, float f6) {
        j4.k.g(view, "view");
        Context context = view.getContext();
        j4.k.f(context, "getContext(...)");
        view.setForeground(c(context, i5, f5, f6));
        if (!z5) {
            view.setOutlineProvider(new j(f5));
        }
        view.setClipToOutline(true);
        if (!z6) {
            b(view);
        } else {
            h(view);
            a(view);
        }
    }

    public final void f(ViewGroup viewGroup, int i5, float f5, boolean z5, boolean z6, float f6) {
        j4.k.g(viewGroup, "parent");
        viewGroup.setAddStatesFromChildren(true);
        d(viewGroup, i5, f5, z5, z6, f6);
    }

    public final void i(View view, boolean z5) {
        j4.k.g(view, "root");
        if (j4.k.b(view.getTag(l3.h.f18419K), Boolean.TRUE)) {
            if (z5) {
                a(view);
            } else {
                b(view);
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = viewGroup.getChildAt(i5);
                j4.k.f(childAt, "getChildAt(...)");
                i(childAt, z5);
            }
        }
    }
}

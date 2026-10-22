package stepos.support.v7.widget;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import com.stepos.agentsafetycenter.R;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class q1 implements te.v {

    /* renamed from: c, reason: collision with root package name */
    public te.l f12822c;

    /* renamed from: f, reason: collision with root package name */
    public te.m f12823f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Toolbar f12824g;

    public q1(Toolbar toolbar) {
        this.f12824g = toolbar;
    }

    @Override // te.v
    public final boolean a() {
        return false;
    }

    @Override // te.v
    public final void c() {
        if (this.f12823f != null) {
            te.l lVar = this.f12822c;
            if (lVar != null) {
                int size = lVar.f13347e.size();
                for (int i = 0; i < size; i++) {
                    if (this.f12822c.getItem(i) == this.f12823f) {
                        return;
                    }
                }
            }
            e(this.f12823f);
        }
    }

    @Override // te.v
    public final boolean d(te.m mVar) {
        Toolbar toolbar = this.f12824g;
        int i = toolbar.f12697t;
        int i3 = 1;
        if (toolbar.f12690m == null) {
            ImageButton imageButton = new ImageButton(toolbar.getContext(), null, R.attr.toolbarNavigationButtonStyle);
            toolbar.f12690m = imageButton;
            imageButton.setImageDrawable(toolbar.f12688k);
            toolbar.f12690m.setContentDescription(toolbar.f12689l);
            r1 r1VarF = Toolbar.f();
            r1VarF.f12825a = (i & 112) | 8388611;
            r1VarF.f12826b = 2;
            toolbar.f12690m.setLayoutParams(r1VarF);
            ImageButton imageButton2 = toolbar.f12690m;
            b bVar = new b(i3);
            bVar.f12726f = toolbar;
            VarHandle.storeStoreFence();
            imageButton2.setOnClickListener(bVar);
        }
        if (toolbar.f12690m.getParent() != toolbar) {
            toolbar.addView(toolbar.f12690m);
        }
        View actionView = mVar.getActionView();
        toolbar.f12691n = actionView;
        this.f12823f = mVar;
        if (actionView.getParent() != toolbar) {
            r1 r1VarF2 = Toolbar.f();
            r1VarF2.f12825a = (i & 112) | 8388611;
            r1VarF2.f12826b = 2;
            toolbar.f12691n.setLayoutParams(r1VarF2);
            toolbar.addView(toolbar.f12691n);
        }
        for (int childCount = toolbar.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = toolbar.getChildAt(childCount);
            if (((r1) childAt.getLayoutParams()).f12826b != 2 && childAt != toolbar.f12681c) {
                toolbar.removeViewAt(childCount);
                toolbar.K.add(childAt);
            }
        }
        toolbar.requestLayout();
        mVar.C = true;
        mVar.f13375n.o(false);
        KeyEvent.Callback callback = toolbar.f12691n;
        if (callback instanceof k.b) {
            ((k.b) callback).onActionViewExpanded();
        }
        return true;
    }

    @Override // te.v
    public final boolean e(te.m mVar) {
        Toolbar toolbar = this.f12824g;
        KeyEvent.Callback callback = toolbar.f12691n;
        if (callback instanceof k.b) {
            ((k.b) callback).onActionViewCollapsed();
        }
        toolbar.removeView(toolbar.f12691n);
        toolbar.removeView(toolbar.f12690m);
        toolbar.f12691n = null;
        ArrayList arrayList = toolbar.K;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            toolbar.addView((View) arrayList.get(size));
        }
        arrayList.clear();
        this.f12823f = null;
        toolbar.requestLayout();
        mVar.C = false;
        mVar.f13375n.o(false);
        return true;
    }

    @Override // te.v
    public final void f(Context context, te.l lVar) {
        te.m mVar;
        te.l lVar2 = this.f12822c;
        if (lVar2 != null && (mVar = this.f12823f) != null) {
            lVar2.d(mVar);
        }
        this.f12822c = lVar;
    }

    @Override // te.v
    public final boolean g(te.z zVar) {
        return false;
    }

    @Override // te.v
    public final void b(te.l lVar, boolean z10) {
    }
}

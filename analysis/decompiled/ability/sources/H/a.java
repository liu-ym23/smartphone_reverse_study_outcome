package H;

import android.view.View;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f705a = 2;
    public final Object b;
    public final Object c;
    public final /* synthetic */ Object d;

    public a(String str, JSONObject jSONObject, String str2) {
        this.b = str;
        this.d = str2;
        this.c = jSONObject;
    }

    @Override // java.lang.Runnable
    public final void run() {
        OverScroller overScroller;
        switch (this.f705a) {
            case 0:
                O.a.g().c(new P.c((String) this.b, 0, (JSONObject) this.c, null, null, (JSONObject) this.d));
                break;
            case 1:
                O.a aVarG = O.a.g();
                String str = (String) this.b;
                String str2 = (String) this.d;
                JSONObject jSONObject = (JSONObject) this.c;
                P.f fVar = new P.f();
                fVar.f1058a = str;
                fVar.b = str2;
                fVar.c = jSONObject;
                fVar.d = null;
                aVarG.c(fVar);
                break;
            default:
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.b;
                com.google.android.material.appbar.g gVar = (com.google.android.material.appbar.g) this.d;
                View view = (View) this.c;
                if (view != null && (overScroller = gVar.b) != null) {
                    if (!overScroller.computeScrollOffset()) {
                        AppBarLayout appBarLayout = (AppBarLayout) view;
                        ((AppBarLayout.BaseBehavior) gVar).l(coordinatorLayout, appBarLayout);
                        if (appBarLayout.l) {
                            appBarLayout.i(appBarLayout.j(AppBarLayout.BaseBehavior.h(coordinatorLayout)));
                            break;
                        }
                    } else {
                        gVar.e(coordinatorLayout, view, gVar.b.getCurrY());
                        view.postOnAnimation(this);
                        break;
                    }
                }
                break;
        }
    }

    public a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        this.b = str;
        this.c = jSONObject;
        this.d = jSONObject2;
    }

    public a(com.google.android.material.appbar.g gVar, CoordinatorLayout coordinatorLayout, View view) {
        this.d = gVar;
        this.b = coordinatorLayout;
        this.c = view;
    }
}

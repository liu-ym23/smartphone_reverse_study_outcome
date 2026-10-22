package androidx.appcompat.widget;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.R$attr;
import androidx.appcompat.view.menu.e;

/* loaded from: classes.dex */
public class I {

    /* renamed from: a, reason: collision with root package name */
    public final Context f8945a;

    /* renamed from: b, reason: collision with root package name */
    public final androidx.appcompat.view.menu.e f8946b;

    /* renamed from: c, reason: collision with root package name */
    public final View f8947c;

    /* renamed from: d, reason: collision with root package name */
    public final androidx.appcompat.view.menu.h f8948d;

    public class a implements e.a {
        public a() {
        }

        @Override // androidx.appcompat.view.menu.e.a
        public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
            I.this.getClass();
            return false;
        }

        @Override // androidx.appcompat.view.menu.e.a
        public void b(androidx.appcompat.view.menu.e eVar) {
        }
    }

    public class b implements PopupWindow.OnDismissListener {
        public b() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            I.this.getClass();
        }
    }

    public I(Context context, View view) {
        this(context, view, 0);
    }

    public Menu a() {
        return this.f8946b;
    }

    public MenuInflater b() {
        return new i.g(this.f8945a);
    }

    public I(Context context, View view, int i10) {
        this(context, view, i10, R$attr.popupMenuStyle, 0);
    }

    public I(Context context, View view, int i10, int i11, int i12) {
        this.f8945a = context;
        this.f8947c = view;
        androidx.appcompat.view.menu.e eVar = new androidx.appcompat.view.menu.e(context);
        this.f8946b = eVar;
        eVar.W(new a());
        androidx.appcompat.view.menu.h hVar = new androidx.appcompat.view.menu.h(context, eVar, view, false, i11, i12);
        this.f8948d = hVar;
        hVar.h(i10);
        hVar.i(new b());
    }
}

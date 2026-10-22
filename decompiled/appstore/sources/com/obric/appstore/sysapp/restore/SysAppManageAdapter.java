package com.obric.appstore.sysapp.restore;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j;
import com.obric.appstore.R;
import com.obric.appstore.common.core.ui.view.ObricAppItemViewForSettings;
import com.obric.appstore.ui.adapter.ItemAppProvider;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.s;
import kotlin.collections.t;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import x7.b0;

/* JADX INFO: loaded from: classes3.dex */
public final class SysAppManageAdapter extends j {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f10975e = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Activity f10976c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1 f10977d;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/obric/appstore/sysapp/restore/SysAppManageAdapter$UiItem;", "", "a", "b", "c", "Lcom/obric/appstore/sysapp/restore/SysAppManageAdapter$UiItem$a;", "Lcom/obric/appstore/sysapp/restore/SysAppManageAdapter$UiItem$b;", "Lcom/obric/appstore/sysapp/restore/SysAppManageAdapter$UiItem$c;", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface UiItem {

        public static final class a implements UiItem {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final com.obric.appstore.sysapp.restore.e f10978a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final int f10979b;

            public a(com.obric.appstore.sysapp.restore.e r10, int r11) {
                q.g(r10, "item");
                this.f10978a = r10;
                this.f10979b = r11;
            }

            public final int a() {
                return this.f10979b;
            }

            public final com.obric.appstore.sysapp.restore.e b() {
                return this.f10978a;
            }

            public boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof a) == true) goto L8;
                return false;
            L8:
                a r11 = (a) r10;
                if (q.b(this.f10978a, r11.f10978a) == true) goto L12;
                return false;
            L12:
                if (this.f10979b == r11.f10979b) goto L14;
                return false;
            L14:
                return true;
            }

            public int hashCode() {
                return (this.f10978a.hashCode() * 31) + Integer.hashCode(this.f10979b);
            }

            public String toString() {
                return "App(item=" + this.f10978a + ", cardPositionType=" + this.f10979b + ')';
            }
        }

        public static final class b implements UiItem {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f10980a = null;

            static {
                f10980a = new b();
            }

            public b() {
            }
        }

        public static final class c implements UiItem {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final boolean f10981a;

            public c(boolean r10) {
                this.f10981a = r10;
            }

            public final boolean a() {
                return this.f10981a;
            }

            public boolean equals(Object r10) {
                if (this != r10) goto L6;
                return true;
            L6:
                if ((r10 instanceof c) == true) goto L9;
                return false;
            L9:
                if (this.f10981a == ((c) r10).f10981a) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                return Boolean.hashCode(this.f10981a);
            }

            public String toString() {
                return "WifiUpdateSetting(enabled=" + this.f10981a + ')';
            }
        }
    }

    public static final class a extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final OCardListItem f10982a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ObricAppItemViewForSettings f10983b;

        public a(OCardListItem r10, ObricAppItemViewForSettings r11) {
            q.g(r10, "card");
            q.g(r11, "appView");
            super(r10);
            this.f10982a = r10;
            this.f10983b = r11;
        }

        public final ObricAppItemViewForSettings a() {
            return this.f10983b;
        }

        public final OCardListItem b() {
            return this.f10982a;
        }
    }

    public static final class b {
        public /* synthetic */ b(DefaultConstructorMarker r10) {
            this();
        }

        public b() {
        }
    }

    public static final class c extends DiffUtil.ItemCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f10984a = null;

        static {
            f10984a = new c();
        }

        public c() {
        }

        public boolean a(UiItem r10, UiItem r11) {
            q.g(r10, "oldItem");
            q.g(r11, "newItem");
            if ((r10 instanceof UiItem.c) == false) goto L10;
            if ((r11 instanceof UiItem.c) == false) goto L10;
            if (((UiItem.c) r10).a() == ((UiItem.c) r11).a()) goto L24;
            return false;
        L24:
            return true;
        L10:
            if ((r10 instanceof UiItem.b) == false) goto L15;
            if ((r11 instanceof UiItem.b) == true) goto L24;
        L15:
            if ((r10 instanceof UiItem.a) == true) goto L17;
            return false;
        L17:
            if ((r11 instanceof UiItem.a) == false) goto L26;
            UiItem.a r12 = (UiItem.a) r10;
            UiItem.a r13 = (UiItem.a) r11;
            if (r12.a() == r13.a()) goto L21;
            return false;
        L21:
            if (q.b(r12.b().a(), r13.b().a()) == true) goto L24;
            return false;
        L26:
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public /* bridge */ /* synthetic */ boolean areContentsTheSame(Object r10, Object r11) {
            return a((UiItem) r10, (UiItem) r11);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public /* bridge */ /* synthetic */ boolean areItemsTheSame(Object r10, Object r11) {
            return b((UiItem) r10, (UiItem) r11);
        }

        public boolean b(UiItem r10, UiItem r11) {
            q.g(r10, "oldItem");
            q.g(r11, "newItem");
            if ((r10 instanceof UiItem.c) == false) goto L8;
            if ((r11 instanceof UiItem.c) == false) goto L8;
            return true;
        L8:
            if ((r10 instanceof UiItem.b) == false) goto L13;
            if ((r11 instanceof UiItem.b) == false) goto L13;
            return true;
        L13:
            if ((r10 instanceof UiItem.a) == true) goto L15;
        L17:
            return false;
        L15:
            if ((r11 instanceof UiItem.a) == false) goto L17;
            return q.b(((UiItem.a) r10).b().a().appPackageName, ((UiItem.a) r11).b().a().appPackageName);
        }
    }

    public static final class d extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ViewGroup f10985a;

        public d(ViewGroup r10) {
            q.g(r10, "parent");
            super(LayoutInflater.from(r10.getContext()).inflate(R.layout.item_sysapp_restore_section_title, r10, false));
            this.f10985a = r10;
        }
    }

    public static final class e extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b0 f10986a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function1 f10987b;

        public e(b0 r10, Function1 r11) {
            q.g(r10, "binding");
            q.g(r11, "onCheckedChange");
            super(r10.b());
            this.f10986a = r10;
            this.f10987b = r11;
        }

        public static /* synthetic */ void a(e r10, CompoundButton r11, boolean r12) {
            d(r10, r11, r12);
        }

        public static /* synthetic */ void b(OSwitch r10, View r11) {
            e(r10, r11);
        }

        public static final void d(e r10, CompoundButton r11, boolean r12) {
            q.g(r10, "this$0");
            q.g(r11, "<anonymous parameter 0>");
            r10.f10987b.invoke(Boolean.valueOf(r12));
        }

        public static final void e(OSwitch r10, View r11) {
            if (r10 == null) goto L5;
            r10.toggle();
            return;
        }

        public final void c(boolean r10) {
            final OSwitch r11 = this.f10986a.f25501b.getEndSwitch();
            if (r11 == null) goto L5;
            r11.setOnCheckedChangeListener(null);
        L5:
            if (r11 == null) goto L7;
            r11.setCheckedNoAnim(r10);
        L7:
            if (r11 == null) goto L9;
            r11.setOnCheckedChangeListener(new com.obric.appstore.sysapp.restore.a(this));
        L9:
            this.f10986a.b().setOnClickListener(new com.obric.appstore.sysapp.restore.b(r11));
        }
    }

    static {
        f10975e = new b(null);
    }

    public SysAppManageAdapter(Activity r10, Function1 r11) {
        q.g(r10, "activity");
        q.g(r11, "onWifiUpdateCheckedChange");
        super(c.f10984a);
        this.f10976c = r10;
        this.f10977d = r11;
    }

    public final int c(int r10, int r11) {
        if (r11 > 1) goto L6;
        return 0;
    L6:
        if (r10 != 0) goto L9;
        return 1;
    L9:
        if (r10 != (r11 - 1)) goto L11;
        return 3;
    L11:
        return 2;
    }

    public final void d(List r10, Boolean r11) {
        q.g(r10, "appItems");
        List r12 = s.c();
        if (r11 == null) goto L6;
        r12.add(new UiItem.c(r11.booleanValue()));
    L6:
        if (r10.isEmpty() == true) goto L8;
        r12.add(UiItem.b.f10980a);
    L8:
        Iterator r13 = r10.iterator();
        int r14 = 0;
    L10:
        if (r13.hasNext() == false) goto L15;
        Object r15 = r13.next();
        int r16 = r14 + 1;
        if (r14 >= 0) goto L14;
        t.q();
    L14:
        r12.add(new UiItem.a((com.obric.appstore.sysapp.restore.e) r15, c(r14, r10.size())));
        r14 = r16;
        goto L10
    L15:
        b(s.a(r12));
    }

    public final int e(int r10) {
        if (r10 != 2) goto L5;
        return 0;
    L5:
        if (r10 != 3) goto L7;
        return 1;
    L7:
        if (r10 == 5) goto L13;
        return 2;
    L13:
        return 3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r10) {
        UiItem r11 = (UiItem) getItem(r10);
        if ((r11 instanceof UiItem.c) == false) goto L6;
        return 0;
    L6:
        if ((r11 instanceof UiItem.b) == false) goto L9;
        return 1;
    L9:
        if ((r11 instanceof UiItem.a) == false) goto L21;
        int r12 = ((UiItem.a) r11).a();
        if (r12 != 0) goto L13;
        return 2;
    L13:
        if (r12 == 1) goto L26;
        if (r12 == 3) goto L16;
        return 4;
    L16:
        return 5;
    L26:
        return 3;
    L21:
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder r10, int r11) {
        q.g(r10, "holder");
        UiItem.c r12 = null;
        if ((r10 instanceof e) == false) goto L11;
        Object r13 = getItem(r11);
        if ((r13 instanceof UiItem.c) == false) goto L7;
        r12 = (UiItem.c) r13;
    L7:
        if (r12 != null) goto L9;
        return;
    L9:
        ((e) r10).c(r12.a());
        return;
    L11:
        if ((r10 instanceof d) == false) goto L13;
        return;
    L13:
        if ((r10 instanceof a) == false) goto L24;
        Object r14 = getItem(r11);
        if ((r14 instanceof UiItem.a) == false) goto L17;
        UiItem.a r15 = (UiItem.a) r14;
    L18:
        if (r15 != null) goto L20;
        return;
    L20:
        a r16 = (a) r10;
        OCardListItem.s(r16.b(), r15.a(), false, 2, null);
        ItemAppProvider.f11017k.g(this.f10976c, r16.a(), r15.b().a());
        return;
    L17:
        r15 = null;
        goto L18
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r20, int r21) {
        q.g(r20, "parent");
        if (r21 != 0) goto L5;
        b0 r10 = b0.c(LayoutInflater.from(r20.getContext()), r20, false);
        q.f(r10, "inflate(...)");
        return new e(r10, this.f10977d);
    L5:
        if (r21 == 1) goto L11;
        Context r11 = r20.getContext();
        q.f(r11, "getContext(...)");
        ObricAppItemViewForSettings r12 = new ObricAppItemViewForSettings(r11, null, 0, 6, null);
        r12.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        Context r14 = r20.getContext();
        q.f(r14, "getContext(...)");
        OCardListItem r13 = new OCardListItem(r14, null, 0, 6, null);
        r13.setCardType(2);
        r13.setShowCardBg(true);
        OCardListItem.s(r13, e(r21), false, 2, null);
        r13.E(false);
        r13.H(false);
        r13.F(false);
        r13.D(false);
        r13.C(true);
        r13.setCustomStartView(r12);
        r13.B(false);
        return new a(r13, r12);
    L11:
        return new d(r20);
    }
}

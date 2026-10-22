package com.stepos.ailauncher.chat.fragment;

import Z8.C1173v;
import android.content.Context;
import android.os.Bundle;
import android.view.LifecycleOwner;
import android.view.View;
import android.widget.Toast;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.ailauncher.chat.adapter.C2503i;
import com.stepos.ailauncher.chat.fragment.AmooInstalledAppsFragment;
import com.stepos.ailauncher.chat.manager.AuthManager;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.chat.view.C2773b6;
import com.stepos.ailauncher.chat.view.C2796d7;
import com.stepos.ailauncher.chat.view.PagedListController;
import com.stepos.ailauncher.chat.view.Z8;
import com.stepos.ailauncher.foundation.appstore.api.AppVersionItem;
import com.stepos.ailauncher.foundation.appstore.j;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import y7.G;

@Metadata(d1 = {"\u0000_\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n*\u0001)\u0018\u0000 42\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0003J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0003J\u000f\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0003J\u000f\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0003J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\tJ\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\tJ\u0013\u0010\u0017\u001a\u00020\u0016*\u00020\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u00198\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\u001dR\u0016\u0010\"\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u001dR\u0016\u0010#\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010\u001dR$\u0010'\u001a\u0012\u0012\u0004\u0012\u00020%0$j\b\u0012\u0004\u0012\u00020%`&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010-\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00101\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\u0014\u00103\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b2\u00100¨\u00066"}, d2 = {"Lcom/stepos/ailauncher/chat/fragment/AmooInstalledAppsFragment;", "Lcom/stepos/ailauncher/sheet/nav/a;", "<init>", "()V", "LY8/t;", ExifInterface.LONGITUDE_WEST, "Lcom/stepos/ailauncher/foundation/appstore/api/AppVersionItem;", "item", "R", "(Lcom/stepos/ailauncher/foundation/appstore/api/AppVersionItem;)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onDestroyView", "M", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "U", "", "L", "(Lcom/stepos/ailauncher/foundation/appstore/api/AppVersionItem;)Z", "Lcom/stepos/ailauncher/chat/view/PagedListController;", "pages", "Lcom/stepos/ailauncher/chat/view/PagedListController;", "reportedComplete", "Z", "", DidiCardProvider.KEY_ITEMS, "Ljava/util/List;", "loaded", ChatTracker.PREVIEW_LOADING, "loadError", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "trackedUninstallPkgs", "Ljava/util/HashSet;", "com/stepos/ailauncher/chat/fragment/AmooInstalledAppsFragment$b", "uninstallCallback", "Lcom/stepos/ailauncher/chat/fragment/AmooInstalledAppsFragment$b;", "Lcom/stepos/ailauncher/chat/adapter/i;", "adapter", "Lcom/stepos/ailauncher/chat/adapter/i;", "e", "()Z", "extendsContentToBottomEdge", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "showsSheetDragHandle", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AmooInstalledAppsFragment extends com.stepos.ailauncher.sheet.nav.a {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int PAGE_SIZE = 50;
    private final C2503i adapter;
    private List<AppVersionItem> items;
    private boolean loadError;
    private boolean loaded;
    private boolean loading;
    private PagedListController<AppVersionItem> pages;
    private boolean reportedComplete;
    private final HashSet<String> trackedUninstallPkgs;
    private final b uninstallCallback;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/chat/fragment/AmooInstalledAppsFragment$a;", "", "<init>", "()V", "Lcom/stepos/ailauncher/chat/fragment/AmooInstalledAppsFragment;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/chat/fragment/AmooInstalledAppsFragment;", "", "PAGE_SIZE", "I", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.fragment.AmooInstalledAppsFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final AmooInstalledAppsFragment a() {
            return new AmooInstalledAppsFragment();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/stepos/ailauncher/chat/fragment/AmooInstalledAppsFragment$b", "Lcom/stepos/ailauncher/foundation/appstore/j$b;", "", "pkg", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)V", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements j.b {
        public b() {
        }

        public static final boolean d(String str, AppVersionItem it) {
            kotlin.jvm.internal.p.i(it, "it");
            return kotlin.jvm.internal.p.d(it.getPackageName(), str);
        }

        @Override // com.stepos.ailauncher.foundation.appstore.j.b
        public void a(String pkg) {
            kotlin.jvm.internal.p.i(pkg, "pkg");
            Context context = AmooInstalledAppsFragment.this.getContext();
            if (context == null) {
                return;
            }
            Toast.makeText(context, R$string.amoo_installed_apps_uninstall_failed, 0).show();
        }

        @Override // com.stepos.ailauncher.foundation.appstore.j.b
        public void b(final String pkg) {
            kotlin.jvm.internal.p.i(pkg, "pkg");
            if (AmooInstalledAppsFragment.this.pages != null) {
                PagedListController pagedListController = AmooInstalledAppsFragment.this.pages;
                if (pagedListController == null) {
                    kotlin.jvm.internal.p.A("pages");
                    pagedListController = null;
                }
                pagedListController.v(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.D
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(AmooInstalledAppsFragment.b.d(pkg, (AppVersionItem) obj));
                    }
                });
            }
        }
    }

    public AmooInstalledAppsFragment() {
        super(R$layout.fragment_amoo_installed_apps);
        this.items = C1173v.m();
        this.trackedUninstallPkgs = new HashSet<>();
        this.uninstallCallback = new b();
        this.adapter = new C2503i(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.B
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AmooInstalledAppsFragment.J(this.f25160a, (AppVersionItem) obj);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.C
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AmooInstalledAppsFragment.K(this.f25164a, (AppVersionItem) obj);
            }
        });
    }

    public static final Y8.t J(AmooInstalledAppsFragment amooInstalledAppsFragment, AppVersionItem item) {
        kotlin.jvm.internal.p.i(item, "item");
        amooInstalledAppsFragment.R(item);
        return Y8.t.f7040a;
    }

    public static final Y8.t K(AmooInstalledAppsFragment amooInstalledAppsFragment, AppVersionItem item) {
        kotlin.jvm.internal.p.i(item, "item");
        amooInstalledAppsFragment.V(item);
        return Y8.t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Y8.t N(A7.B attachGradientBlur) {
        kotlin.jvm.internal.p.i(attachGradientBlur, "$this$attachGradientBlur");
        com.stepos.ailauncher.container.glass.i.a(attachGradientBlur);
        return Y8.t.f7040a;
    }

    public static final void O(AmooInstalledAppsFragment amooInstalledAppsFragment, View view) {
        if (amooInstalledAppsFragment.x()) {
            return;
        }
        amooInstalledAppsFragment.o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String P(AppVersionItem it) {
        kotlin.jvm.internal.p.i(it, "it");
        String packageName = it.getPackageName();
        if (packageName != null) {
            if (La.H.x0(packageName)) {
                packageName = null;
            }
            if (packageName != null) {
                return packageName;
            }
        }
        return String.valueOf(it.getId());
    }

    public static final Y8.t Q(AmooInstalledAppsFragment amooInstalledAppsFragment, C2796d7 state) {
        kotlin.jvm.internal.p.i(state, "state");
        List<AppVersionItem> listF = state.f();
        amooInstalledAppsFragment.items = listF;
        amooInstalledAppsFragment.adapter.g(listF);
        Iterator<T> it = amooInstalledAppsFragment.items.iterator();
        while (it.hasNext()) {
            amooInstalledAppsFragment.U((AppVersionItem) it.next());
        }
        amooInstalledAppsFragment.loading = state.getLoading();
        amooInstalledAppsFragment.loaded = state.getCompleted();
        amooInstalledAppsFragment.loadError = state.getError() != null && state.f().isEmpty();
        amooInstalledAppsFragment.W();
        if (state.getCompleted() && !amooInstalledAppsFragment.reportedComplete) {
            amooInstalledAppsFragment.reportedComplete = true;
            com.stepos.ailauncher.chat.trace.a.INSTANCE.e(Integer.valueOf(amooInstalledAppsFragment.items.size()));
        }
        return Y8.t.f7040a;
    }

    private final void R(AppVersionItem item) {
        Context context = getContext();
        if (context != null && AuthManager.O(AuthManager.INSTANCE, context, false, false, 6, null)) {
            com.stepos.ailauncher.sheet.nav.a.z(this, AmooAppDetailFragment.INSTANCE.a(item.getId(), item.getPackageName(), item.getName(), item.getIconUrl()), "ai_app_detail_" + item.getId(), null, null, null, 28, null);
        }
    }

    public static final boolean T(AmooInstalledAppsFragment amooInstalledAppsFragment, AppVersionItem it) {
        kotlin.jvm.internal.p.i(it, "it");
        return !amooInstalledAppsFragment.L(it);
    }

    private final void W() {
        View view = getView();
        if (view == null) {
            return;
        }
        view.findViewById(R$id.rvInstalledApps).setVisibility(!this.items.isEmpty() ? 0 : 8);
        view.findViewById(R$id.loadingView).setVisibility(8);
        view.findViewById(R$id.emptyView).setVisibility(((this.loaded || this.loadError) && this.items.isEmpty()) ? 0 : 8);
    }

    public final boolean L(AppVersionItem appVersionItem) {
        Context context;
        String packageName = appVersionItem.getPackageName();
        if (packageName == null || (context = getContext()) == null) {
            return false;
        }
        return com.stepos.ailauncher.foundation.appstore.j.INSTANCE.v(context, packageName);
    }

    public final void M() {
        PagedListController<AppVersionItem> pagedListController;
        this.reportedComplete = false;
        PagedListController<AppVersionItem> pagedListController2 = this.pages;
        if (pagedListController2 == null) {
            kotlin.jvm.internal.p.A("pages");
            pagedListController = null;
        } else {
            pagedListController = pagedListController2;
        }
        PagedListController.x(pagedListController, 0, this.items, new AmooInstalledAppsFragment$loadInstalledApps$1(this, null), 1, null);
    }

    public final void S() {
        PagedListController<AppVersionItem> pagedListController = this.pages;
        if (pagedListController != null) {
            if (pagedListController == null) {
                kotlin.jvm.internal.p.A("pages");
                pagedListController = null;
            }
            pagedListController.v(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.A
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(AmooInstalledAppsFragment.T(this.f25157a, (AppVersionItem) obj));
                }
            });
        }
    }

    public final void U(AppVersionItem item) {
        String packageName = item.getPackageName();
        if (packageName != null && this.trackedUninstallPkgs.add(packageName)) {
            com.stepos.ailauncher.foundation.appstore.j.INSTANCE.o(packageName, this.uninstallCallback);
        }
    }

    public final void V(AppVersionItem item) {
        Context context;
        String packageName = item.getPackageName();
        if (packageName == null || (context = getContext()) == null) {
            return;
        }
        U(item);
        com.stepos.ailauncher.foundation.appstore.j.INSTANCE.K(context, packageName);
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public boolean e() {
        return true;
    }

    @Override // com.stepos.ailauncher.sheet.nav.a, com.stepos.ailauncher.sheet.nav.d
    public boolean j() {
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        Iterator<T> it = this.trackedUninstallPkgs.iterator();
        while (it.hasNext()) {
            com.stepos.ailauncher.foundation.appstore.j.INSTANCE.G((String) it.next(), this.uninstallCallback);
        }
        this.trackedUninstallPkgs.clear();
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.loaded) {
            S();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        kotlin.jvm.internal.p.i(view, "view");
        super.onViewCreated(view, savedInstanceState);
        com.stepos.ailauncher.container.glass.k.b(view, 0, 1, null);
        View viewFindViewById = view.findViewById(R$id.btnBack);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        C2773b6 c2773b6 = new C2773b6(viewLifecycleOwner, false, 2, 0 == true ? 1 : 0);
        kotlin.jvm.internal.p.f(viewFindViewById);
        C2773b6 c2773b6P = C2773b6.p(c2773b6, new View[]{viewFindViewById}, null, false, 6, null);
        View viewFindViewById2 = view.findViewById(R$id.topChromeBlur);
        kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
        C2773b6.j(c2773b6P, new View[]{viewFindViewById2}, G.a.f43886a.g(), null, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.w
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AmooInstalledAppsFragment.N((A7.B) obj);
            }
        }, 4, null);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.fragment.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AmooInstalledAppsFragment.O(this.f25352a, view2);
            }
        });
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R$id.rvInstalledApps);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
        recyclerView.setAdapter(this.adapter);
        Context context = recyclerView.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        recyclerView.addItemDecoration(new Z8(context));
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        kotlin.jvm.internal.p.h(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        RecyclerView rvInstalledApps = l5.e.a(view).rvInstalledApps;
        kotlin.jvm.internal.p.h(rvInstalledApps, "rvInstalledApps");
        this.pages = new PagedListController<>(viewLifecycleOwner2, rvInstalledApps, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.y
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AmooInstalledAppsFragment.P((AppVersionItem) obj);
            }
        }, true, false, false, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.fragment.z
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AmooInstalledAppsFragment.Q(this.f25363a, (C2796d7) obj);
            }
        });
        M();
    }
}

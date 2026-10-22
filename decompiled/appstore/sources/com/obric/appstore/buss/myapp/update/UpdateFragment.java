package com.obric.appstore.buss.myapp.update;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.eventbus.AddUpdateEvent;
import com.bytedanceos.common.eventbus.IgnoreAppEvent;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.b0;
import com.bytedanceos.common.toolbox.e0;
import com.bytedanceos.common.ui.ConfirmDialog;
import com.bytedanceos.common.utils.ActivityUtilKt;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.obric.appstore.R;
import com.obric.appstore.base.BaseListAdapter;
import com.obric.appstore.base.BaseListFragment;
import com.obric.appstore.base.BaseListItemProvider;
import com.obric.appstore.base.ILoadViewModel;
import com.obric.appstore.buss.apps.AppCallback;
import com.obric.appstore.buss.apps.AppsManager;
import com.obric.appstore.buss.detail.o;
import com.obric.appstore.common.core.ui.view.ObricAppItemView;
import com.obric.appstore.ui.adapter.ItemAppProvider;
import com.obric.appstore.ui.adapter.ItemType;
import com.obric.appstore.ui.menu.PopMenu;
import com.obric.appstore.util.n;
import com.obric.oui.button.OButton;
import com.obric.oui.common.style.IOUIAlpha;
import com.obric.oui.paneltitlebar.OPanelTitleBar;
import com.obric.oui.status.OPageStatus;
import com.smt.obric.appstore.domain.app.AppInstallActor;
import com.tmall.wireless.tangram.structure.card.FixCard;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.s;
import kotlin.collections.t;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.u;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import org.apache.http.message.TokenParser;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\u0005J\u000f\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\u0005J\u0019\u0010\u000f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0015\u0010\u0005J\u0017\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u001aH\u0007¢\u0006\u0004\b\u0018\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001c\u0010\u0005J\u0017\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 R\u001a\u0010&\u001a\u00020!8\u0014X\u0094\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001b\u0010,\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001a\u0010/\u001a\u00020!8\u0014X\u0094D¢\u0006\f\n\u0004\b-\u0010#\u001a\u0004\b.\u0010%R\u001a\u00105\u001a\u0002008\u0014X\u0094\u0004¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u001a\u0010;\u001a\u0002068\u0016X\u0096D¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001a\u0010=\u001a\u0002068\u0016X\u0096D¢\u0006\f\n\u0004\b<\u00108\u001a\u0004\b<\u0010:R\u001a\u0010C\u001a\u00020>8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u0014\u0010F\u001a\u00020D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010ER\u0014\u0010I\u001a\u00020G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010HR\u0014\u0010M\u001a\u00020J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u001a\u0010P\u001a\u0002068\u0014X\u0094D¢\u0006\f\n\u0004\bN\u00108\u001a\u0004\bO\u0010:R \u0010U\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020R0Q8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\bS\u0010T¨\u0006V"}, d2 = {"Lcom/obric/appstore/buss/myapp/update/UpdateFragment;", "Lcom/obric/appstore/base/BaseListFragment;", "Lcom/obric/appstore/buss/myapp/update/e;", "Lcom/obric/appstore/buss/apps/AppCallback;", "<init>", "()V", "Landroid/widget/Button;", "updateAllBtn", "", "i0", "(Landroid/widget/Button;)V", "o0", "n0", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroy", "Lcom/bytedanceos/common/eventbus/AddUpdateEvent;", "event", "onEvent", "(Lcom/bytedanceos/common/eventbus/AddUpdateEvent;)V", "Lcom/bytedanceos/common/eventbus/IgnoreAppEvent;", "(Lcom/bytedanceos/common/eventbus/IgnoreAppEvent;)V", "onAppUpdate", "Lcom/obric/oui/status/OPageStatus;", "empty", "Q", "(Lcom/obric/oui/status/OPageStatus;)V", "", "o", "I", "w", "()I", "layoutId", "Lcom/obric/appstore/buss/myapp/update/UpdateVM;", "p", "Lkotlin/Lazy;", "m0", "()Lcom/obric/appstore/buss/myapp/update/UpdateVM;", "updateVM", "q", "v", "headerLayoutId", "Lcom/obric/appstore/buss/myapp/update/UpdateUIAdapter;", "r", "Lcom/obric/appstore/buss/myapp/update/UpdateUIAdapter;", "j0", "()Lcom/obric/appstore/buss/myapp/update/UpdateUIAdapter;", "adapter", "", "s", "Z", "W", "()Z", "enableNested", "t", "enableEventBus", "Lcom/obric/appstore/buss/myapp/update/f;", "u", "Lcom/obric/appstore/buss/myapp/update/f;", "k0", "()Lcom/obric/appstore/buss/myapp/update/f;", "diffCallback", "Lcom/obric/appstore/ui/menu/PopMenu;", "Lcom/obric/appstore/ui/menu/PopMenu;", "popMenu", "Lbb/a;", "Lbb/a;", "blockTouchAfterLongClick", "Lbb/c;", FixCard.FixStyle.KEY_X, "Lbb/c;", "downTrackingClick", FixCard.FixStyle.KEY_Y, "H", "showLoadingWhenEmpty", "Lcom/obric/appstore/base/k;", "", "l0", "()Lcom/obric/appstore/base/k;", "listVM", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nUpdateFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UpdateFragment.kt\ncom/obric/appstore/buss/myapp/update/UpdateFragment\n+ 2 FragmentViewModelLazy.kt\nandroidx/fragment/app/FragmentViewModelLazyKt\n*L\n1#1,476:1\n106#2,15:477\n*S KotlinDebug\n*F\n+ 1 UpdateFragment.kt\ncom/obric/appstore/buss/myapp/update/UpdateFragment\n*L\n72#1:477,15\n*E\n"})
public final class UpdateFragment extends BaseListFragment<e> implements AppCallback {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f10742o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f10743p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f10744q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final UpdateUIAdapter f10745r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f10746s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f10747t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final f f10748u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final PopMenu f10749v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final bb.a f10750w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final bb.c f10751x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final boolean f10752y;

    /* JADX INFO: renamed from: com.obric.appstore.buss.myapp.update.UpdateFragment$onCreate$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "position", "Landroid/view/View;", "view", "Lcom/obric/appstore/buss/myapp/update/e;", "appInfo", "", "invoke", "(ILandroid/view/View;Lcom/obric/appstore/buss/myapp/update/e;)V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @SourceDebugExtension({"SMAP\nUpdateFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UpdateFragment.kt\ncom/obric/appstore/buss/myapp/update/UpdateFragment$onCreate$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,476:1\n1#2:477\n*E\n"})
    public static final class AnonymousClass1 extends Lambda implements Function3<Integer, View, e, Unit> {
        final /* synthetic */ UpdateFragment this$0;

        public AnonymousClass1(UpdateFragment r10) {
            this.this$0 = r10;
            super(3);
        }

        public static /* synthetic */ boolean a(UpdateFragment r10, e r11, View r12, View r13) {
            return invoke$lambda$2(r10, r11, r12, r13);
        }

        private static final boolean invoke$lambda$2(final UpdateFragment r10, final e r11, View r12, View r13) {
            q.g(r10, "this$0");
            q.g(r11, "$appInfo");
            q.g(r12, "$view");
            bb.a r14 = UpdateFragment.c0(r10);
            q.d(r13);
            r14.a(r13);
            AppsManager r15 = AppsManager.f10585a;
            String r16 = r11.getAppInfo().appPackageName;
            q.f(r16, "appPackageName");
            AppInfo r17 = r15.d(r16);
            if (r17 != null) goto L6;
            return true;
        L6:
            if (r17.downloadStatus != 8) goto L8;
            return true;
        L8:
            int r18 = R.drawable.oui_icon_cancel_ignore_update;
            String r19 = r10.getString(R.string.app_manage_menu_ignore_update);
            q.f(r19, "getString(...)");
            List r20 = s.e(new com.obric.appstore.ui.menu.b(0, r18, r19));
            UpdateFragment.e0(r10).e(r12, UpdateFragment.d0(r10).a(), r20, new UpdateFragment$onCreate$1$2$1(r10, r11));
            return true;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Integer r10, View r11, e r12) {
            invoke(r10.intValue(), r11, r12);
            return Unit.f21064a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void invoke(int r10, @NotNull final View r11, @NotNull final e r12) {
            q.g(r11, "view");
            q.g(r12, "appInfo");
            Object r13 = null;
            if ((r11 instanceof IOUIAlpha) == false) goto L5;
            IOUIAlpha r14 = (IOUIAlpha) r11;
        L6:
            if (r14 == null) goto L8;
            r14.setChangeAlphaWhenSelected(true);
        L8:
            int r15 = r10 + 1;
            bg.c r16 = new bg.c(r15, this.this$0.j0().getData().size() - 1);
            UpdateFragment r17 = this.this$0;
            Iterator r18 = r16.iterator();
        L10:
            if (r18.hasNext() == false) goto L14;
            Object r19 = r18.next();
            if (r17.j0().getItemViewType(((Number) r19).intValue()) != ItemType.APP.ordinal()) goto L10;
            r13 = r19;
        L14:
            if (r13 != null) goto L16;
            boolean r20 = true;
        L18:
            if (r15 >= (this.this$0.j0().getData().size() - 1)) goto L25;
            if (r20 == false) goto L21;
        L24:
            r20 = true;
            goto L25
        L21:
            if (this.this$0.j0().getItemViewType(r15) == ItemType.TITLE.ordinal()) goto L24;
            r20 = false;
        L25:
            if (r20 == false) goto L27;
            ((ObricAppItemView) r11).showLine(false);
        L27:
            r11.setSelected(false);
            r11.setOnTouchListener(new bb.b(t.l(new View.OnTouchListener[]{UpdateFragment.d0(this.this$0), UpdateFragment.c0(this.this$0)})));
            final UpdateFragment r21 = this.this$0;
            r11.setOnLongClickListener(new j(r21, r12, r11));
            return;
        L16:
            r20 = false;
            goto L18
        L5:
            r14 = null;
            goto L6
        }
    }

    /* JADX INFO: renamed from: com.obric.appstore.buss.myapp.update.UpdateFragment$onCreate$2, reason: invalid class name */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0017\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"com/obric/appstore/buss/myapp/update/UpdateFragment$onCreate$2", "Lcom/obric/appstore/base/BaseListItemProvider;", "Lsa/j;", "Lcom/obric/appstore/buss/myapp/update/e;", "Landroid/view/ViewGroup;", "parent", "f", "(Landroid/view/ViewGroup;)Lsa/j;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "helper", "item", "", "d", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/obric/appstore/buss/myapp/update/e;)V", "", "getItemViewType", "()I", "itemViewType", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class AnonymousClass2 extends BaseListItemProvider<sa.j, e> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ UpdateFragment f10755c;

        public AnonymousClass2(UpdateFragment r10) {
            this.f10755c = r10;
        }

        public static /* synthetic */ void c(UpdateFragment r10, e.d r11, View r12) {
            e(r10, r11, r12);
        }

        public static final void e(UpdateFragment r10, e.d r11, View r12) {
            q.g(r10, "this$0");
            if (r10.getActivity() != null) goto L5;
            return;
        L5:
            UpdateFragment.h0(r10);
        }

        @Override // com.obric.appstore.base.BaseListItemProvider
        public /* bridge */ /* synthetic */ ViewBinding a(ViewGroup r10) {
            return f(r10);
        }

        @Override // com.chad.library.adapter.base.provider.BaseItemProvider
        public /* bridge */ /* synthetic */ void convert(BaseViewHolder r10, Object r11) {
            d(r10, (e) r11);
        }

        public void d(BaseViewHolder r10, e r11) {
            q.g(r10, "helper");
            q.g(r11, "item");
            ViewBinding r12 = b(r10);
            final UpdateFragment r13 = this.f10755c;
            sa.j r14 = (sa.j) r12;
            r14.f24596b.setTitle(getContext().getString(R.string.app_manage_update_title, new Object[]{0}));
            sa.t r15 = sa.t.c(LayoutInflater.from(getContext()));
            q.f(r15, "inflate(...)");
            OButton r16 = r15.f24679b;
            q.f(r16, "btn");
            r16.setText(r13.getString(R.string.update_all));
            final e.d r17 = null;
            r16.setOnClickListener(new k(r13, r17));
            r14.f24596b.setActionView(r15.b());
        }

        public sa.j f(ViewGroup r10) {
            q.g(r10, "parent");
            sa.j r11 = sa.j.c(LayoutInflater.from(r10.getContext()), r10, false);
            q.f(r11, "inflate(...)");
            return r11;
        }

        @Override // com.obric.appstore.base.BaseListItemProvider, com.chad.library.adapter.base.provider.BaseItemProvider
        public int getItemViewType() {
            return ItemType.UPDATE_APP_TITLE.ordinal();
        }
    }

    /* JADX INFO: renamed from: com.obric.appstore.buss.myapp.update.UpdateFragment$onCreate$3, reason: invalid class name */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0017\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"com/obric/appstore/buss/myapp/update/UpdateFragment$onCreate$3", "Lcom/obric/appstore/base/BaseListItemProvider;", "Lsa/h;", "Lcom/obric/appstore/buss/myapp/update/e;", "Landroid/view/ViewGroup;", "parent", "f", "(Landroid/view/ViewGroup;)Lsa/h;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "helper", "item", "", "d", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/obric/appstore/buss/myapp/update/e;)V", "", "getItemViewType", "()I", "itemViewType", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nUpdateFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UpdateFragment.kt\ncom/obric/appstore/buss/myapp/update/UpdateFragment$onCreate$3\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,476:1\n262#2,2:477\n*S KotlinDebug\n*F\n+ 1 UpdateFragment.kt\ncom/obric/appstore/buss/myapp/update/UpdateFragment$onCreate$3\n*L\n215#1:477,2\n*E\n"})
    public static final class AnonymousClass3 extends BaseListItemProvider<sa.h, e> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ UpdateFragment f10756c;

        public AnonymousClass3(UpdateFragment r10) {
            this.f10756c = r10;
        }

        public static /* synthetic */ void c(UpdateFragment r10, View r11) {
            e(r10, r11);
        }

        public static final void e(UpdateFragment r10, View r11) {
            q.g(r10, "this$0");
            n.f11086a.h(r10.getActivity());
        }

        @Override // com.obric.appstore.base.BaseListItemProvider
        public /* bridge */ /* synthetic */ ViewBinding a(ViewGroup r10) {
            return f(r10);
        }

        @Override // com.chad.library.adapter.base.provider.BaseItemProvider
        public /* bridge */ /* synthetic */ void convert(BaseViewHolder r10, Object r11) {
            d(r10, (e) r11);
        }

        public void d(BaseViewHolder r10, e r11) {
            q.g(r10, "helper");
            q.g(r11, "item");
            ViewBinding r12 = b(r10);
            final UpdateFragment r13 = this.f10756c;
            sa.h r14 = (sa.h) r12;
            if ((r11 instanceof e.b) == false) goto L5;
            e.b r15 = (e.b) r11;
        L6:
            View r16 = r14.f24590b;
            q.f(r16, "divider");
            r16.setVisibility(8);
            OPanelTitleBar r17 = r14.f24591c;
            Context r18 = getContext();
            int r19 = R.string.app_manage_ignore_update_title;
            if (r15 == null) goto L9;
            int r20 = r15.a();
        L10:
            r17.setTitle(r18.getString(r19, new Object[]{Integer.valueOf(r20)}));
            r14.f24591c.setOnClickListener(new l(r13));
            sa.g r21 = sa.g.c(LayoutInflater.from(getContext()));
            q.f(r21, "inflate(...)");
            r14.f24591c.setActionView(r21.b());
            return;
        L9:
            r20 = 0;
            goto L10
        L5:
            r15 = null;
            goto L6
        }

        public sa.h f(ViewGroup r10) {
            q.g(r10, "parent");
            sa.h r11 = sa.h.c(LayoutInflater.from(r10.getContext()), r10, false);
            q.f(r11, "inflate(...)");
            return r11;
        }

        @Override // com.obric.appstore.base.BaseListItemProvider, com.chad.library.adapter.base.provider.BaseItemProvider
        public int getItemViewType() {
            return ItemType.IGNORE_UPDATE_TITLE.ordinal();
        }
    }

    /* JADX INFO: renamed from: com.obric.appstore.buss.myapp.update.UpdateFragment$onCreate$4, reason: invalid class name */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0017\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"com/obric/appstore/buss/myapp/update/UpdateFragment$onCreate$4", "Lcom/obric/appstore/base/BaseListItemProvider;", "Lsa/h;", "Lcom/obric/appstore/buss/myapp/update/e;", "Landroid/view/ViewGroup;", "parent", "f", "(Landroid/view/ViewGroup;)Lsa/h;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "helper", "item", "", "d", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Lcom/obric/appstore/buss/myapp/update/e;)V", "", "getItemViewType", "()I", "itemViewType", "obriccommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nUpdateFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UpdateFragment.kt\ncom/obric/appstore/buss/myapp/update/UpdateFragment$onCreate$4\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,476:1\n262#2,2:477\n*S KotlinDebug\n*F\n+ 1 UpdateFragment.kt\ncom/obric/appstore/buss/myapp/update/UpdateFragment$onCreate$4\n*L\n246#1:477,2\n*E\n"})
    public static final class AnonymousClass4 extends BaseListItemProvider<sa.h, e> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ UpdateFragment f10757c;

        public AnonymousClass4(UpdateFragment r10) {
            this.f10757c = r10;
        }

        public static /* synthetic */ void c(UpdateFragment r10, View r11) {
            e(r10, r11);
        }

        private static final void e(UpdateFragment r10, View r11) {
            q.g(r10, "this$0");
            n.f11086a.o(r10.getActivity());
        }

        @Override // com.obric.appstore.base.BaseListItemProvider
        public /* bridge */ /* synthetic */ ViewBinding a(ViewGroup r10) {
            return f(r10);
        }

        @Override // com.chad.library.adapter.base.provider.BaseItemProvider
        public /* bridge */ /* synthetic */ void convert(BaseViewHolder r10, Object r11) {
            d(r10, (e) r11);
        }

        public void d(BaseViewHolder r10, e r11) {
            q.g(r10, "helper");
            q.g(r11, "item");
            ViewBinding r12 = b(r10);
            final UpdateFragment r13 = this.f10757c;
            sa.h r14 = (sa.h) r12;
            if ((r11 instanceof e.c) == false) goto L5;
            e.c r15 = (e.c) r11;
        L6:
            View r16 = r14.f24590b;
            q.f(r16, "divider");
            int r17 = 0;
            if (r15 == null) goto L9;
            boolean r18 = r15.b();
        L10:
            if (r18 == false) goto L12;
            int r19 = 0;
        L13:
            r16.setVisibility(r19);
            OPanelTitleBar r20 = r14.f24591c;
            Context r21 = getContext();
            int r22 = R.string.app_manage_sign_note_match_title;
            if (r15 == null) goto L16;
            r17 = r15.a();
        L16:
            r20.setTitle(r21.getString(r22, new Object[]{Integer.valueOf(r17)}));
            r14.f24591c.setOnClickListener(new m(r13));
            sa.g r23 = sa.g.c(LayoutInflater.from(getContext()));
            q.f(r23, "inflate(...)");
            r14.f24591c.setActionView(r23.b());
            return;
        L12:
            r19 = 8;
            goto L13
        L9:
            r18 = false;
            goto L10
        L5:
            r15 = null;
            goto L6
        }

        public sa.h f(ViewGroup r10) {
            q.g(r10, "parent");
            sa.h r11 = sa.h.c(LayoutInflater.from(r10.getContext()), r10, false);
            q.f(r11, "inflate(...)");
            return r11;
        }

        @Override // com.obric.appstore.base.BaseListItemProvider, com.chad.library.adapter.base.provider.BaseItemProvider
        public int getItemViewType() {
            return ItemType.SIGN_NOT_MATCH.ordinal();
        }
    }

    /* JADX INFO: renamed from: com.obric.appstore.buss.myapp.update.UpdateFragment$onViewCreated$3, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.appstore.buss.myapp.update.UpdateFragment$onViewCreated$3", f = "UpdateFragment.kt", i = {}, l = {287}, m = "invokeSuspend", n = {}, s = {})
    public static final class C04433 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ UpdateFragment this$0;

        /* JADX INFO: renamed from: com.obric.appstore.buss.myapp.update.UpdateFragment$onViewCreated$3$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.appstore.buss.myapp.update.UpdateFragment$onViewCreated$3$1", f = "UpdateFragment.kt", i = {}, l = {288}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ UpdateFragment this$0;

            /* JADX INFO: renamed from: com.obric.appstore.buss.myapp.update.UpdateFragment$onViewCreated$3$1$a */
            public static final class a implements FlowCollector {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ UpdateFragment f10758a;

                public a(UpdateFragment r10) {
                    this.f10758a = r10;
                }

                public final Object a(List r10, Continuation r11) {
                    ILoadViewModel.s(UpdateFragment.f0(this.f10758a), false, false, 3, null);
                    return Unit.f21064a;
                }

                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object r10, Continuation r11) {
                    return a((List) r10, r11);
                }
            }

            public AnonymousClass1(UpdateFragment r10, Continuation<? super AnonymousClass1> r11) {
                this.this$0 = r10;
                super(2, r11);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
                return new AnonymousClass1(this.this$0, r11);
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
                return invoke2(r10, r11);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object r10) {
                Object r11 = kotlin.coroutines.intrinsics.a.d();
                int r12 = this.label;
                if (r12 == 0) goto L8;
                if (r12 != 1) goto L6;
                kotlin.c.b(r10);
            L12:
                throw new KotlinNothingValueException();
            L6:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                kotlin.c.b(r10);
                StateFlow r13 = AppInstallActor.f17891n.b().S();
                a r14 = new a(this.this$0);
                this.label = 1;
                if (r13.collect(r14, this) != r11) goto L12;
                return r11;
            }

            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
                return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.f21064a);
            }
        }

        public C04433(UpdateFragment r10, Continuation<? super C04433> r11) {
            this.this$0 = r10;
            super(2, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            return new C04433(this.this$0, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
            return invoke2(r10, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r10) {
            Object r11 = kotlin.coroutines.intrinsics.a.d();
            int r12 = this.label;
            if (r12 == 0) goto L8;
            if (r12 != 1) goto L7;
            kotlin.c.b(r10);
        L12:
            return Unit.f21064a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            kotlin.c.b(r10);
            UpdateFragment r13 = this.this$0;
            Lifecycle.State r14 = Lifecycle.State.RESUMED;
            AnonymousClass1 r15 = new AnonymousClass1(r13, null);
            this.label = 1;
            if (RepeatOnLifecycleKt.b(r13, r14, r15, this) != r11) goto L12;
            return r11;
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
            return ((C04433) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }
    }

    public UpdateFragment() {
        this.f10742o = R.layout.fragment_update;
        final Function0<Fragment> r10 = new UpdateFragment$special$$inlined$viewModels$default$1(this);
        final Lazy r11 = kotlin.b.a(LazyThreadSafetyMode.NONE, new UpdateFragment$special$$inlined$viewModels$default$2(r10));
        final Function0 r12 = null;
        this.f10743p = FragmentViewModelLazyKt.c(this, u.b(UpdateVM.class), new UpdateFragment$special$$inlined$viewModels$default$3(r11), new UpdateFragment$special$$inlined$viewModels$default$4(r12, r11), new UpdateFragment$special$$inlined$viewModels$default$5(this, r11));
        this.f10745r = new UpdateUIAdapter();
        this.f10746s = true;
        this.f10747t = true;
        this.f10748u = new f();
        this.f10749v = new PopMenu();
        this.f10750w = new bb.a();
        this.f10751x = new bb.c();
    }

    public static /* synthetic */ void a0(FragmentActivity r10, UpdateFragment r11, int r12, int r13, boolean r14, Bundle r15) {
        p0(r10, r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ void b0(UpdateFragment r10, int r11, int r12, boolean r13, Bundle r14) {
        q0(r10, r11, r12, r13, r14);
    }

    public static final /* synthetic */ bb.a c0(UpdateFragment r10) {
        return r10.f10750w;
    }

    public static final /* synthetic */ bb.c d0(UpdateFragment r10) {
        return r10.f10751x;
    }

    public static final /* synthetic */ PopMenu e0(UpdateFragment r10) {
        return r10.f10749v;
    }

    public static final /* synthetic */ UpdateVM f0(UpdateFragment r10) {
        return r10.m0();
    }

    public static final /* synthetic */ void g0(UpdateFragment r10) {
        r10.n0();
    }

    public static final /* synthetic */ void h0(UpdateFragment r10) {
        r10.o0();
    }

    private final UpdateVM m0() {
        return (UpdateVM) this.f10743p.getValue();
    }

    private final void n0() {
        if (com.bytedanceos.common.toolbox.e.q0(1000) == false) goto L6;
        m0().C();
        return;
    }

    public static final void p0(FragmentActivity r10, UpdateFragment r11, int r12, int r13, boolean r14, Bundle r15) {
        q.g(r10, "$activity");
        q.g(r11, "this$0");
        if (r14 == false) goto L6;
        b0.n().E("switch_update", BaseApplication.c().getVersionCode(), null, r10);
    L6:
        if (r13 != (-2)) goto L8;
        d9.a.e().n("0023");
    L12:
        r11.m0().F(true);
        return;
    L8:
        if (r13 != (-1)) goto L12;
        com.bytedanceos.common.toolbox.s.r(BaseApplication.c(), true);
        d9.a.e().n("0024");
        goto L12
    }

    public static final void q0(UpdateFragment r10, int r11, int r12, boolean r13, Bundle r14) {
        q.g(r10, "this$0");
        if (r12 == (-2)) goto L8;
        boolean r15 = false;
        if (r12 != (-1)) goto L9;
        r10.m0().F(false);
    L9:
        if (r13 == false) goto L12;
        com.bytedanceos.common.toolbox.e.Z0(r15, 2);
        return;
    L12:
        return;
    L8:
        r10.m0().G();
        r15 = true;
        goto L9
    }

    @Override // com.obric.appstore.base.BaseFragment
    public boolean H() {
        return this.f10752y;
    }

    @Override // com.obric.appstore.base.BaseFragment
    public void Q(OPageStatus r10) {
        q.g(r10, "empty");
        if (getView() == null) goto L6;
        r10.setType(0);
        r10.setTitle(getString(R.string.obric_empty_update_apps));
        return;
    }

    @Override // com.obric.appstore.base.BaseListFragment
    public /* bridge */ /* synthetic */ BaseListAdapter U() {
        return j0();
    }

    @Override // com.obric.appstore.base.BaseListFragment
    public /* bridge */ /* synthetic */ DiffUtil.ItemCallback V() {
        return k0();
    }

    @Override // com.obric.appstore.base.BaseListFragment
    public boolean W() {
        return this.f10746s;
    }

    @Override // com.obric.appstore.base.BaseListFragment
    public /* bridge */ /* synthetic */ ILoadViewModel X() {
        return l0();
    }

    public final void i0(Button r10) {
        LifecycleOwner r11 = getViewLifecycleOwner();
        q.f(r11, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.h.d(androidx.lifecycle.s.a(r11), null, null, new UpdateFragment$bindUpdateAllBtn$1(this, r10, null), 3, null);
    }

    public UpdateUIAdapter j0() {
        return this.f10745r;
    }

    public f k0() {
        return this.f10748u;
    }

    public com.obric.appstore.base.k l0() {
        return m0();
    }

    public final void o0() {
        if (com.bytedanceos.common.toolbox.e.q0(1000) == true) goto L5;
        return;
    L5:
        List r10 = BaseApplication.c().b().v("UPDATE");
        if (com.bytedanceos.common.download.d.d(getActivity(), r10) == true) goto L8;
        return;
    L8:
        final FragmentActivity r11 = getActivity();
        if (r11 != null) goto L11;
        return;
    L11:
        int r12 = com.bytedanceos.common.toolbox.e.A();
        if (r12 != 0) goto L14;
        e0.e(R.string.retry_connection);
        return;
    L14:
        if (r12 == 1) goto L23;
        if (r12 == 2) goto L19;
        return;
    L19:
        if (com.bytedanceos.common.toolbox.s.o(r11) == false) goto L21;
        ConfirmDialog r13 = ConfirmDialog.newInstance(16, true, null);
        r13.setOnClickListener(new g(r11, this));
        r13.show(r11.getFragmentManager(), "switch_update_apps");
        return;
    L21:
        m0().F(true);
        return;
    L23:
        if (com.bytedanceos.common.toolbox.e.G(0) == true) goto L25;
        ConfirmDialog r14 = ConfirmDialog.newInstance(19, BaseApplication.c().b().F());
        r14.setOnClickListener(new h(this));
        r14.show(r11.getFragmentManager(), "mobile_data_reminder");
        return;
    L25:
        if (com.bytedanceos.common.toolbox.e.G(1) == false) goto L27;
        m0().G();
        return;
    L27:
        m0().F(false);
    }

    @Override // com.obric.appstore.buss.apps.AppCallback
    public void onAppUpdate() {
        ILoadViewModel.s(m0(), true, false, 2, null);
    }

    @Override // com.obric.appstore.base.BaseListFragment, com.obric.appstore.base.BaseFragment, com.obric.appstore.base.e, androidx.fragment.app.Fragment
    public void onCreate(Bundle r13) {
        super.onCreate(r13);
        UpdateUIAdapter r14 = j0();
        String r10 = getPageSource();
        int r11 = o.a();
        r14.addItemProvider(new ItemAppProvider(r10, false, false, new AnonymousClass1(this), Integer.valueOf(r11), false, false, 0.0f, 160, null));
        j0().addItemProvider(new AnonymousClass2(this));
        j0().addItemProvider(new AnonymousClass3(this));
        j0().addItemProvider(new AnonymousClass4(this));
        ILoadViewModel.s(m0(), false, false, 3, null);
        AppsManager.f10585a.j(this);
    }

    @Override // com.obric.appstore.base.e, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        AppsManager.f10585a.l(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull AddUpdateEvent r10) {
        q.g(r10, "event");
        com.bytedanceos.common.toolbox.j.n(getPageSource() + " onEvent " + r10.getEvent() + TokenParser.SP + r10.getPackageName());
        if (r10.getEvent() != 2) goto L7;
        ILoadViewModel.s(m0(), true, false, 2, null);
        return;
    L7:
        if (TextUtils.isEmpty(r10.getPackageName()) == true) goto L10;
        ILoadViewModel.s(m0(), true, false, 2, null);
        return;
    }

    @Override // com.obric.appstore.base.BaseListFragment, com.obric.appstore.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r10, Bundle r11) {
        q.g(r10, "view");
        super.onViewCreated(r10, r11);
        RecyclerView r12 = Y();
        if (r12 == null) goto L5;
        u8.c.c(r12, C04421.INSTANCE);
    L5:
        OButton r13 = (OButton) r10.findViewById(R.id.btn_update_all);
        if (r13 == null) goto L8;
        u8.c.e(r13, UpdateFragment$onViewCreated$2$1.INSTANCE);
        i0(r13);
    L8:
        LifecycleOwner r14 = getViewLifecycleOwner();
        q.f(r14, "getViewLifecycleOwner(...)");
        kotlinx.coroutines.h.d(androidx.lifecycle.s.a(r14), null, null, new C04433(this, null), 3, null);
        final RecyclerView r15 = Y();
        if (r15 == null) goto L12;
        ActivityUtilKt.b(r15, new UpdateFragment$onViewCreated$4$1(r15));
        r15.setClipToPadding(false);
        r15.addItemDecoration(new bb.f(o.c(), o.b(), o.c(), false, 0, o.b()));
        return;
    }

    @Override // com.obric.appstore.base.e
    public boolean t() {
        return this.f10747t;
    }

    @Override // com.obric.appstore.base.e
    public int v() {
        return this.f10744q;
    }

    @Override // com.obric.appstore.base.BaseListFragment, com.obric.appstore.base.e
    public int w() {
        return this.f10742o;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull IgnoreAppEvent r10) {
        q.g(r10, "event");
        ILoadViewModel.s(m0(), true, false, 2, null);
    }
}

package com.bytedance.android.livesdk.chatroom.roommanage.admin;

import am2.x;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.browser.webview.fragment.BaseWebDialogFragment;
import com.bytedance.android.live.browser.webview.fragment.o;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.utils.l;
import com.bytedance.android.live.network.response.BaseListResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.admin.api.AdminApi2;
import com.bytedance.android.livesdk.admin.prompt.PrompterDataContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.roommanage.admin.binder.i;
import com.bytedance.android.livesdk.chatroom.ui.SimpleInputDialogFragment;
import com.bytedance.android.livesdk.chatroom.utils.q3;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.utils.SettingKeyUtils;
import com.bytedance.android.livesdk.utils.t2;
import com.bytedance.android.livesdk.widget.LiveBottomSheetDialog;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.lifecycle.ILiveLifecycle;
import com.bytedance.android.livesdkapi.lifecycle.ILiveLifecycleObserver;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.m;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/roommanage/admin/PrompterDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "Lcom/bytedance/android/livesdk/chatroom/ui/SimpleInputDialogFragment$c;", "Lcom/bytedance/android/livesdkapi/lifecycle/ILiveLifecycleObserver;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PrompterDialog extends LiveDialogFragment implements SimpleInputDialogFragment.c, ILiveLifecycleObserver {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f111216o = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f111217d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Disposable f111218e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<td1.c> f111219f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RecyclerView f111220g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f111221h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f111222i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public MultiTypeAdapter f111223j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Long f111224k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f111225l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public SimpleInputDialogFragment f111226m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f111227n;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PrompterDialog f111228a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ User f111229b;

        public b(PrompterDialog r100, User r101) {
            this.f111228a = r100;
            this.f111229b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Response r101 = (Response) r100;
            if (r101 == null) goto L15;
            td1.c r102 = (td1.c) r101.data;
            if (r102 == null) goto L15;
            com.bytedance.android.livesdk.log.g r103 = u.l();
            PrompterDataContext.a r104 = PrompterDataContext.Companion;
            User r105 = this.f111229b;
            r104.getClass();
            Map<String, String> r106 = PrompterDataContext.a.b(r105);
            r106.put(EventConstant.Key.RETAIN_PROMPT, r102.a());
            Unit r107 = Unit.INSTANCE;
            r103.f("livesdk_prompter_send_message_success", r106, new Object[]{Room.class, x.class});
            this.f111228a.f111219f.add(r102);
            PrompterDialog r108 = this.f111228a;
            PrompterDialog.S90(r108, r108.f111219f, r101.extra.now);
            PrompterDialog r109 = this.f111228a;
            Disposable r110 = r109.f111218e;
            if (r110 == null) goto L10;
            r109.f111217d.remove(r110);
            r110.dispose();
        L10:
            PrompterDialog r111 = this.f111228a;
            Disposable r112 = Observable.timer(r102.c(), TimeUnit.SECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.livesdk.chatroom.roommanage.admin.f(this));
            if (r112 == null) goto L13;
            this.f111228a.f111217d.add(r112);
        L14:
            r111.f111218e = r112;
            return;
        L13:
            r112 = null;
        L15:
            ALogger.e("PromptDialog", "post prompt resp get null");
        }
    }

    public static final class c extends q3 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PrompterDialog f111230b;

        public c(PrompterDialog r100) {
            this.f111230b = r100;
        }

        @Override // com.bytedance.android.livesdk.chatroom.utils.q3
        public final void a(Throwable r100) {
            super.a(r100);
            User r101 = null;
            if ((r100 instanceof ApiServerException) == true) goto L5;
            r100 = null;
        L5:
            ApiServerException r102 = (ApiServerException) r100;
            if (r102 == null) goto L8;
            int r103 = r102.getErrorCode();
        L9:
            PrompterDialog r104 = this.f111230b;
            int r105 = PrompterDialog.f111216o;
            r104.getClass();
            RoomContext r106 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r106 == null) goto L14;
            m<User> r107 = r106.getUser();
            if (r107 == null) goto L14;
            r101 = r107.getValue();
        L14:
            com.bytedance.android.livesdk.log.g r108 = u.l();
            PrompterDataContext.Companion.getClass();
            Map<String, String> r109 = PrompterDataContext.a.b(r101);
            if (r103 != 4002140) goto L17;
            String r110 = "frequency_limit";
        L21:
            r109.put("fail_reason", r110);
            Unit r111 = Unit.INSTANCE;
            r108.f("livesdk_prompter_send_message_fail", r109, new Object[]{Room.class, x.class});
            return;
        L17:
            if (r103 == 4002143) goto L19;
            r110 = "unknown_" + r103;
            goto L21
        L19:
            r110 = "break_rule";
            goto L21
        L8:
            r103 = 0;
            goto L9
        }

        @Override // com.bytedance.android.livesdk.chatroom.utils.q3, io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Throwable r100) {
            a(r100);
        }
    }

    public static final class d implements LiveBottomSheetDialog.m {
        public d() {
        }

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.m
        public final boolean disableDragDown() {
            return true;
        }

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.m
        public final boolean shouldInterceptSlide(int r100) {
            return false;
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f111231a = null;

        static {
            f111231a = new e();
        }

        public e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Resources r101 = r100.getContext().getResources();
            DisplayMetrics r102 = WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics());
            int r103 = MathKt.roundToInt(r102.widthPixels / r102.density);
            PrompterDataContext.Companion.getClass();
            String r104 = PrompterDataContext.a.c();
            if (((Boolean) SettingKeyUtils.f158789e.getValue()).booleanValue() == true) goto L5;
            o r105 = ((IBrowserService) k.n(IBrowserService.class)).buildWebDialog(r104).setWidth(r103);
            r105.f64387b = 270;
            r105.f64394i = 80;
            r105.f64400o = true;
            r105.f64398m = true;
            r105.a(0);
            r105.b(8, 8, 0, 0);
            r105.f64401p = false;
            r105.f64402q = true;
            BaseWebDialogFragment r106 = r105.build();
            LiveDialogFragment.a r107 = LiveDialogFragment.Companion;
            FragmentActivity r108 = ContextUtil.contextToFragmentActivity(r100.getContext());
            r107.getClass();
            LiveDialogFragment.a.a(r108, r106);
            return;
        L5:
            IBaseBrowserService.b.a((IBaseBrowserService) k.n(IBrowserService.class), r100.getContext(), x6.a.a(r104).appendQueryParameter("width", String.valueOf(r103)).appendQueryParameter("height", String.valueOf(270)).appendQueryParameter(GXTemplateKey.GAIAX_LAYER_GRAVITY, "bottom").appendQueryParameter("landscape_custom_gravity", "1").appendQueryParameter("landscape_custom_height", "1").appendQueryParameter("radius_top_left", "8").appendQueryParameter("radius_top_right", "8").appendQueryParameter("radius_bottom_right", "0").appendQueryParameter("radius_bottom_left", "0").appendQueryParameter("show_dim", "0").appendQueryParameter("type", "popup").build());
        }
    }

    public static final class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PrompterDialog f111232a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f111233b;

        public f(PrompterDialog r100, View r101) {
            this.f111232a = r100;
            this.f111233b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            CharSequence r101 = ((TextView) this.f111233b.findViewById(R.id.tv_fake_prompter_edit)).getText();
            if (r101 != null) goto L5;
            r101 = "";
        L5:
            FragmentActivity r102 = ContextUtil.contextToFragmentActivity(this.f111233b.getContext());
            if (r102 == null) goto L8;
            FragmentManager r103 = r102.getSupportFragmentManager();
        L9:
            if (r103 != null) goto L12;
            ALogger.e("PromptDialog", "null fragment manager when showing input dialog, ignore click");
            return;
        L12:
            PrompterDialog r104 = this.f111232a;
            SimpleInputDialogFragment r105 = SimpleInputDialogFragment.S90("", r101.toString(), this.f111232a.f111227n, false);
            Bundle r106 = r105.getArguments();
            if (r106 == null) goto L15;
            r106.putBoolean("live.intent.extra.TOUCH_OUTSIDE_DISMISS", true);
        L15:
            r105.f112533f = this.f111232a;
            LandscapeRestrictionOperation r107 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r105, "admin_prompt", r107);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r103, r105, r107) == false) goto L23;
        L20:
            Unit r108 = Unit.INSTANCE;
            r104.f111226m = r105;
            return;
        L23:
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L22
        L19:
            r105.show(r103, "admin_prompt");
            goto L20
        L8:
            r103 = null;
            goto L9
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PrompterDialog f111234a;

        public g(PrompterDialog r100) {
            this.f111234a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            BaseListResponse r101 = (BaseListResponse) r100;
            td1.g r102 = (td1.g) r101.extra;
            if (r102.getDuration() <= 0) goto L6;
            PrompterDialog r103 = this.f111234a;
            r103.f111225l = r102.getDuration();
        L6:
            if (r102.a() <= 0) goto L8;
            PrompterDialog r104 = this.f111234a;
            r104.f111227n = r102.a();
        L8:
            PrompterDialog r105 = this.f111234a;
            int r106 = PrompterDialog.f111216o;
            r105.U90();
            PrompterDialog r107 = this.f111234a;
            ArrayList r108 = r101.data;
            if (r108 != null) goto L11;
            r108 = new ArrayList();
        L11:
            r107.f111219f = r108;
            PrompterDialog r109 = this.f111234a;
            PrompterDialog.S90(r109, r109.f111219f, ((td1.g) r101.extra).now);
        }
    }

    public static final class h extends l {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PrompterDialog f111235b;

        public h(PrompterDialog r100) {
            this.f111235b = r100;
        }

        @Override // com.bytedance.android.live.liveinteract.api.utils.l
        public final void a(Throwable r100) {
            super.a(r100);
            PrompterDialog.S90(this.f111235b, new ArrayList(), System.currentTimeMillis());
        }

        @Override // com.bytedance.android.live.liveinteract.api.utils.l, io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Throwable r100) {
            a(r100);
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.SimpleInputDialogFragment.c
    public final void h4(String r100) {
    }

    public final void T90() {
        if (this.f111224k != null) goto L6;
        ALogger.e("PromptDialog", "input confirm, room id is null");
        return;
    L6:
        com.bytedance.android.livesdk.service.l.d().getClass();
        Disposable r100 = ((AdminApi2) com.bytedance.android.live.network.c.b().e(AdminApi2.class)).fetchPrompts(this.f111224k.longValue()).observeOn(AndroidSchedulers.mainThread()).subscribe(new g(this), new h(this));
        if (r100 == null) goto L10;
        this.f111217d.add(r100);
        return;
    }

    public PrompterDialog() {
        this.f111217d = new CompositeDisposable();
        this.f111219f = new ArrayList();
        DataContext r100 = com.bytedance.live.datacontext.d.d(RoomContext.class);
        Long r101 = null;
        if ((r100 instanceof RoomContext) == true) goto L5;
        r100 = null;
    L5:
        RoomContext r102 = (RoomContext) r100;
        if (r102 == null) goto L12;
        m<Room> r103 = r102.getRoom();
        if (r103 == null) goto L12;
        Room r104 = r103.getValue();
        if (r104 == null) goto L12;
        r101 = Long.valueOf(r104.f162599id);
    L12:
        this.f111224k = r101;
        this.f111225l = 10;
        this.f111227n = 50;
        setNoTitleAndCancelOutside(true);
    }

    public final void U90() {
        View r100 = getView();
        if (r100 == null) goto L9;
        TextView r101 = (TextView) r100.findViewById(R.id.tv_fake_prompter_edit);
        if (r101 == null) goto L10;
        r101.setText(s1.C(R.string.ttlive_template_admin_prompt_duration, new Object[]{Integer.valueOf(this.f111225l)}));
        return;
    L10:
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDetach() {
        super.onDetach();
        this.f111217d.clear();
        ((ILiveLifecycle) k.n(ILiveLifecycle.class)).removeObserver(this);
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        Dialog r101 = getDialog();
        if (r101 == null) goto L8;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L9;
        r102.setNavigationBarColor(0);
        int r103 = s1.f(270);
        r102.setGravity(80);
        r102.setLayout(-1, r103);
        return;
    L9:
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onAttach(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.onAttach(r100);
        ((ILiveLifecycle) k.n(ILiveLifecycle.class)).addObserver(this);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.SimpleInputDialogFragment.c
    public final void onConfirm(String r100) {
        RoomContext r101 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r101 == null) goto L7;
        m<User> r102 = r101.getUser();
        if (r102 == null) goto L7;
        User r103 = r102.getValue();
    L8:
        if (r100 != null) goto L10;
    L13:
        boolean r104 = true;
    L14:
        if (r104 == false) goto L16;
    L30:
        ALogger.w("PromptDialog", "input confirm pre-check failed, input: " + r100 + ", roomId: " + this.f111224k + ", user: " + r103);
        return;
    L16:
        if (this.f111224k == null) goto L30;
        if (r103 == null) goto L30;
        com.bytedance.android.livesdk.service.l.d().getClass();
        Disposable r105 = ((AdminApi2) com.bytedance.android.live.network.c.b().e(AdminApi2.class)).postPrompt(this.f111224k.longValue(), r100).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r103), new c(this));
        if (r105 == null) goto L22;
        this.f111217d.add(r105);
    L22:
        SimpleInputDialogFragment r106 = this.f111226m;
        if (r106 != null) goto L25;
    L28:
        this.f111226m = null;
        return;
    L25:
        if (r106.f112535h == null) goto L28;
        t2.a(r106.getContext(), r106.f112535h);
        goto L28
    L10:
        if (r100.length() == 0) goto L13;
        r104 = false;
    L7:
        r103 = null;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setStyle(1, R.style.ttlive_decorate_dialog);
        setBottomSheetSlideProcessor(new d());
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        this.f111220g = (RecyclerView) r100.findViewById(R.id.rv_prompts);
        this.f111221h = r100.findViewById(R.id.stupid_gradient);
        this.f111222i = r100.findViewById(R.id.tv_prompts_empty);
        MultiTypeAdapter r102 = new MultiTypeAdapter();
        r102.z2(i.class, new com.bytedance.android.livesdk.chatroom.roommanage.admin.binder.h());
        r102.f513437a = this.f111219f;
        Unit r103 = Unit.INSTANCE;
        this.f111223j = r102;
        RecyclerView r104 = this.f111220g;
        if (r104 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L5:
        MultiTypeAdapter r105 = this.f111223j;
        if (r105 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("multiTypeAdapter");
    L8:
        r104.setAdapter(r105);
        r100.findViewById(R.id.iv_prompter_desc).setOnClickListener(e.f111231a);
        r100.findViewById(R.id.container_edit_text).setOnClickListener(new f(this, r100));
        U90();
        T90();
    }

    public static final void S90(PrompterDialog r110, List r111, long r112) {
        r110.getClass();
        boolean r100 = !r111.isEmpty();
        RecyclerView r101 = r110.f111220g;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L5:
        UtilityKotlinExtentionsKt.z(r101, r100);
        View r102 = r110.f111221h;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerViewFg");
    L8:
        UtilityKotlinExtentionsKt.z(r102, r100);
        View r103 = r110.f111222i;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("emptyView");
    L11:
        UtilityKotlinExtentionsKt.z(r103, !r100);
        if (r100 == false) goto L41;
        MultiTypeAdapter r104 = r110.f111223j;
        if (r104 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("multiTypeAdapter");
    L17:
        List r105 = r111;
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator r107 = r105.iterator();
        int r108 = 0;
    L19:
        if (r107.hasNext() == false) goto L30;
        Object r109 = r107.next();
        int r113 = r108 + 1;
        if (r108 >= 0) goto L23;
        CollectionsKt.throwIndexOverflow();
    L23:
        td1.c r114 = (td1.c) r109;
        if (r108 == CollectionsKt.getLastIndex(r111)) goto L26;
    L28:
        boolean r115 = false;
    L29:
        r106.add(new i(r114, r115));
        r108 = r113;
        goto L19
    L26:
        if (r112 >= ((r114.b() + ((long) r114.c())) * 1000)) goto L28;
        r115 = true;
        goto L29
    L30:
        r104.f513437a = r106;
        MultiTypeAdapter r116 = r110.f111223j;
        if (r116 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("multiTypeAdapter");
    L33:
        r116.notifyDataSetChanged();
        RecyclerView r117 = r110.f111220g;
        if (r117 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L36:
        r117.scrollToPosition(CollectionsKt.getLastIndex(r111));
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return getLayoutInflater().inflate(R.layout.ttlive_dialog_admin_prompt, r101, false);
    }

    @Override // com.bytedance.android.livesdkapi.lifecycle.ILiveLifecycleObserver
    public final void onLifecycleEvent(ILiveLifecycleObserver.Event r100, String r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "roomId");
        if (isShowing() == true) goto L5;
        return;
    L5:
        if (r100 != ILiveLifecycleObserver.Event.EndSession) goto L16;
        dismissAllowingStateLoss();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r103 = DialogFragmentLancet.sLastShowStack;
        if (r103 == null) goto L17;
        com.bytedance.crash.d.d(r103, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L17:
        return;
    }
}

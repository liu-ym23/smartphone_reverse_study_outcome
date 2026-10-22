package com.bytedance.android.livesdk.linkvideo.ui;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.api.IRoomModuleService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.android.livesdk.linkvideo.AnchorLinkVideoListViewModel;
import com.bytedance.android.livesdk.linkvideo.AnchorLinkVideoListViewModelFactory;
import com.bytedance.android.livesdk.linkvideo.DialogLifecycleOwner;
import com.bytedance.android.livesdk.linkvideo.LoadMoreScrollListener;
import com.bytedance.android.livesdk.linkvideo.view.h;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.v6;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import com.bytedance.live.datacontext.i;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/linkvideo/ui/LinkVideoDialog;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "Lcom/bytedance/android/livesdk/linkvideo/view/h;", "Landroid/view/View$OnClickListener;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "room-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkVideoDialog extends LiveDialogFragment implements h, View.OnClickListener {
    public static final String R = null;
    public LoadMoreScrollListener A;
    public LiveDoubleColorBallAnimationView B;
    public View C;
    public int D;
    public boolean E;
    public boolean F;
    public final WeakHandler G;
    public final MutableLiveData<gf2.a> H;
    public long I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final Map<Integer, Long> f147126J;
    public int K;
    public boolean L;
    public int M;
    public View N;
    public boolean O;
    public long P;
    public boolean Q;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f147127d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f147128e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f147129f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f147130g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CompositeDisposable f147131h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AnchorLinkVideoListViewModel f147132i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f147133j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f147134k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f147135l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public HSImageView f147136m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Button f147137n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Button f147138o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Button f147139p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public TextView f147140q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ImageView f147141r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ImageView f147142s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public View f147143t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public FrameLayout f147144u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public TextView f147145v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public View f147146w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public View f147147x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public RecyclerView f147148y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public MultiTypeAdapter f147149z;

    public static final class a {
    }

    public static final class b implements WeakHandler.IHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f147150a = null;

        static {
            f147150a = new b();
        }

        public b() {
        }

        @Override // com.bytedance.android.livesdkapi.depend.handler.WeakHandler.IHandler
        public final void handleMsg(Message r100) {
        }
    }

    public static final class c implements IMiddlewareHostBusiness.AwemeQueryCallBack {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkVideoDialog f147151a;

        @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness.AwemeQueryCallBack
        public final void onBatchSuccess(HashMap<Long, Object> r100) {
        }

        public c(LinkVideoDialog r100) {
            this.f147151a = r100;
        }

        @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness.AwemeQueryCallBack
        public final void onSuccess(Object r100, long r101) {
            if (r100 == null) goto L25;
            LinkVideoDialog r110 = this.f147151a;
            String r102 = LinkVideoDialog.R;
            r110.getClass();
            if (PadConfigUtils.c() == false) goto L7;
            int r103 = s1.k(R.dimen.ttlive_video_preview_height_pad);
        L8:
            IMiddlewareHostBusiness.AwemeVideoPlayFragmentV2 r104 = ((IMiddlewareHostBusiness) k.n(IMiddlewareHostBusiness.class)).getLivePureVideoPlayFragmentV2(r100, r103, r110.getContext(), 0);
            Fragment r105 = null;
            if (r104 == null) goto L11;
            r104.setPlayOnResume(false);
            r104.setCallback(new com.bytedance.android.livesdk.linkvideo.ui.d(r110));
        L12:
            if (r104 == null) goto L14;
            r105 = r104.asFragment();
        L14:
            if (r105 == null) goto L24;
            FragmentManager r106 = r110.getChildFragmentManager();
            if (r106 == null) goto L24;
            FragmentTransaction r107 = r106.beginTransaction();
            if (r107 == null) goto L24;
            if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r107, r105, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, "LinkVideoDialogPreview", R.id.live_play_container) == true) goto L23;
            r107.add(R.id.live_play_container, r105, "LinkVideoDialogPreview");
        L23:
            r107.commitAllowingStateLoss();
        L24:
            this.f147151a.hideLoading();
            return;
        L11:
            r104 = null;
            goto L12
        L7:
            r103 = s1.k(R.dimen.ttlive_video_preview_height) - (s1.f(484.0f) - r110.M);
            goto L8
        L25:
            f2.b(R.string.ttlive_video_invalid_choose_again, 0);
            LinkVideoDialog r108 = this.f147151a;
            String r109 = LinkVideoDialog.R;
            r108.hideLoading();
            this.f147151a.Y90(1);
        }

        @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness.AwemeQueryCallBack
        public final void onFailure(String r100, String r101, String r102) {
            if (TextUtils.isEmpty(r101) == true) goto L6;
            f2.c(r101, 0);
        L9:
            LinkVideoDialog r103 = this.f147151a;
            String r104 = LinkVideoDialog.R;
            r103.hideLoading();
            this.f147151a.Y90(1);
            return;
        L6:
            if (TextUtils.isEmpty(r102) == true) goto L8;
            f2.c(r102, 0);
            goto L9
        L8:
            f2.b(R.string.ttlive_aweme_video_info_error, 0);
            goto L9
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkVideoDialog f147152a;

        public d(LinkVideoDialog r100) {
            this.f147152a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View r100 = this.f147152a.C;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.setVisibility(8);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
        R = "https://" + LiveCommonConstants.INSTANCE.getObjectTosPath() + "/obj/live-android/ttlive_video_comment_empty_list_image.png";
    }

    @Override // com.bytedance.android.livesdk.linkvideo.view.h
    public final gf2.a J9() {
        MutableLiveData<gf2.a> r100 = this.H;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getValue();
    }

    public final void U90() {
        View r100 = this.f147146w;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getVisibility() != 0) goto L26;
        View r101 = this.f147146w;
        Integer r102 = null;
        if (r101 == null) goto L9;
        ViewParent r103 = r101.getParent();
    L10:
        if (r103 == null) goto L29;
        FragmentManager r104 = getChildFragmentManager();
        if (r104 == null) goto L27;
        Fragment r105 = r104.findFragmentByTag("LinkVideoDialogPreview");
        if (r105 == null) goto L28;
        FragmentManager r106 = getChildFragmentManager();
        if (r106 == null) goto L23;
        FragmentTransaction r107 = r106.beginTransaction();
        if (r107 == null) goto L23;
        FragmentTransaction r108 = r107.remove(r105);
        if (r108 == null) goto L23;
        r102 = Integer.valueOf(r108.commitAllowingStateLoss());
    L23:
        r102.intValue();
        return;
    L28:
        return;
    L27:
        return;
    L29:
        return;
    L9:
        r103 = null;
        goto L10
    }

    public final void W90() {
        View r100 = this.f147135l;
        if (r100 == null) goto L5;
        r100.setVisibility(0);
    L5:
        ImageLoader.bindImage(this.f147136m, R);
        IRoomModuleService r101 = (IRoomModuleService) k.f(IRoomModuleService.class);
        if (r101 == null) goto L11;
        com.bytedance.android.livesdk.linkvideo.b r102 = r101.getLinkVideoTea();
        if (r102 == null) goto L12;
        r102.f(this.F, v6.a());
        return;
    L12:
        return;
    }

    public final void hideLoading() {
        View r100 = this.f147133j;
        if (r100 == null) goto L5;
        r100.setVisibility(8);
    L5:
        LiveDoubleColorBallAnimationView r101 = this.B;
        if (r101 == null) goto L9;
        r101.c();
        return;
    }

    public LinkVideoDialog() {
        this.f147127d = 1;
        this.f147128e = "";
        this.f147130g = LazyKt.lazy(LinkVideoDialog$lifecycleOwner$2.INSTANCE);
        this.f147131h = new CompositeDisposable();
        this.E = true;
        this.G = new WeakHandler(Looper.getMainLooper(), b.f147150a);
        this.H = new MutableLiveData();
        this.f147126J = new LinkedHashMap();
        this.O = true;
        this.Q = true;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        com.bytedance.android.livesdk.f.d().f();
        AnchorLinkVideoListViewModel r100 = this.f147132i;
        if (r100 == null) goto L5;
        r100.onDialogDismiss();
    L5:
        WeakHandler r101 = this.G;
        if (r101 == null) goto L8;
        r101.removeCallbacksAndMessages(null);
    L8:
        ((LifecycleRegistry) ((DialogLifecycleOwner) this.f147130g.getValue()).f147111a.getValue()).handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        CompositeDisposable r102 = this.f147131h;
        if (r102 == null) goto L11;
        r102.clear();
    L11:
        U90();
        IRoomModuleService r103 = (IRoomModuleService) k.f(IRoomModuleService.class);
        if (r103 == null) goto L14;
        com.bytedance.android.livesdk.linkvideo.b r104 = r103.getLinkVideoTea();
    L15:
        int r105 = this.K;
        if (r105 < 0) goto L33;
        int r106 = 0;
    L18:
        Long r107 = (Long) ((LinkedHashMap) this.f147126J).get(Integer.valueOf(r106));
        if (r107 == null) goto L21;
        long r108 = r107.longValue();
    L23:
        if (r108 <= 0) goto L31;
        if (r104 == null) goto L31;
        boolean r109 = this.F;
        String r110 = v6.a();
        Long r111 = (Long) ((LinkedHashMap) this.f147126J).get(Integer.valueOf(r106));
        if (r111 == null) goto L29;
        String r112 = String.valueOf(r111.longValue());
    L30:
        r104.b(r109, r110, r112);
        goto L31
    L29:
        r112 = null;
    L31:
        if (r106 == r105) goto L35;
        r106 = r106 + 1;
        goto L18
    L35:
        return;
    L21:
        r108 = 0;
        goto L23
    L33:
        return;
    L14:
        r104 = null;
        goto L15
    }

    @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r100 = getDialog();
        if (r100 == null) goto L8;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L9;
        r101.setLayout(-1, s1.f(484.0f));
        return;
    L9:
        return;
    }

    public static TextureView S90(ViewGroup r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r101 = r100.getChildCount();
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L23;
        View r103 = r100.getChildAt(r102);
        if ((r103 instanceof TextureView) == true) goto L16;
        if ((r103 instanceof ViewGroup) == false) goto L15;
        TextureView r104 = S90((ViewGroup) r103);
        if (r104 == null) goto L15;
        return r104;
    L15:
        r102 = r102 + 1;
        goto L6
    L16:
        return (TextureView) r103;
    L23:
        return null;
    }

    public final gf2.a T90(long r100) {
        MultiTypeAdapter r101 = this.f147149z;
        if (r101 == null) goto L17;
        List<?> r102 = r101.f513437a;
        if (r102 == null) goto L27;
        Iterator<T> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L28;
        Object r104 = r103.next();
        if ((r104 instanceof gf2.a) == false) goto L8;
        gf2.a r105 = (gf2.a) r104;
        Long r106 = r105.b();
        if (r106 == null) goto L8;
        if (r106.longValue() != r100) goto L8;
        return r105;
    L28:
        return null;
    L27:
        return null;
    L17:
        return null;
    }

    public final void V90(boolean r100) {
        LoadMoreScrollListener r101 = this.A;
        if (r101 == null) goto L5;
        r101.f147113b = 0;
    L5:
        MultiTypeAdapter r102 = this.f147149z;
        List<?> r103 = null;
        if (r102 == null) goto L8;
        List<?> r104 = r102.f513437a;
    L10:
        if (TypeIntrinsics.isMutableList(r104) == false) goto L13;
        r103 = r104;
    L13:
        if (r103 != null) goto L16;
        return;
    L16:
        if (r103.size() <= 0) goto L25;
        int r105 = r103.size() - 1;
        if ((ListProtector.get(r103, r105) instanceof com.bytedance.android.livesdk.linkvideo.view.f) == false) goto L26;
        ListProtector.remove(r103, r105);
        if (r100 == false) goto L27;
        MultiTypeAdapter r106 = this.f147149z;
        if (r106 == null) goto L28;
        r106.notifyItemRemoved(r105);
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    L8:
        r104 = null;
        goto L10
    }

    public final void X90(long r100) {
        if (r100 > 0) goto L6;
        f2.b(R.string.ttlive_aweme_video_info_error, 0);
        return;
    L6:
        this.P = r100;
        View r101 = this.f147133j;
        if (r101 == null) goto L9;
        r101.setVisibility(0);
    L9:
        LiveDoubleColorBallAnimationView r102 = this.B;
        if (r102 == null) goto L12;
        r102.b();
    L12:
        Disposable r103 = ((IMiddlewareHostBusiness) k.n(IMiddlewareHostBusiness.class)).queryAweme(r100, new c(this));
        if (r103 == null) goto L16;
        RxUtilKt.c(r103, this.f147131h);
        return;
    }

    @Override // com.bytedance.android.livesdk.linkvideo.view.h
    public final void XJ(long r100) {
        if (r100 > 0) goto L6;
        f2.b(R.string.ttlive_aweme_video_info_error, 0);
        return;
    L6:
        this.I = r100;
        Y90(2);
        X90(r100);
    }

    public final void Y90(int r100) {
        this.D = r100;
        if (r100 != 1) goto L5;
        ImageView r101 = this.f147141r;
        if (r101 == null) goto L76;
        r101.setVisibility(0);
    L76:
        RecyclerView r102 = this.f147148y;
        if (r102 == null) goto L79;
        r102.setVisibility(0);
    L79:
        ImageView r103 = this.f147142s;
        if (r103 == null) goto L82;
        r103.setVisibility(0);
    L82:
        TextView r104 = this.f147140q;
        if (r104 == null) goto L85;
        r104.setText(s1.B(R.string.ttlive_choose_related_video));
    L85:
        Button r105 = this.f147137n;
        if (r105 == null) goto L88;
        r105.setVisibility(8);
    L88:
        Button r106 = this.f147138o;
        if (r106 == null) goto L91;
        r106.setVisibility(8);
    L91:
        Button r107 = this.f147139p;
        if (r107 == null) goto L94;
        r107.setVisibility(8);
    L94:
        FrameLayout r108 = this.f147144u;
        if (r108 == null) goto L97;
        r108.setVisibility(8);
    L97:
        TextView r109 = this.f147145v;
        if (r109 == null) goto L101;
        r109.setVisibility(8);
    L101:
        if (this.f147127d != 1) goto L103;
    L107:
        IRoomModuleService r110 = (IRoomModuleService) k.f(IRoomModuleService.class);
        if (r110 == null) goto L119;
        com.bytedance.android.livesdk.linkvideo.b r111 = r110.getLinkVideoTea();
        if (r111 == null) goto L120;
        r111.i(v6.a());
        return;
    L120:
        return;
    L119:
        return;
    L103:
        if (this.E == false) goto L107;
        AnchorLinkVideoListViewModel r112 = this.f147132i;
        if (r112 == null) goto L107;
        r112.doAction(new com.bytedance.android.livesdk.linkvideo.f.a(true, true));
        goto L107
    L5:
        if (r100 != 2) goto L7;
        ImageView r113 = this.f147141r;
        if (r113 == null) goto L44;
        r113.setVisibility(0);
    L44:
        RecyclerView r114 = this.f147148y;
        if (r114 == null) goto L47;
        r114.setVisibility(8);
    L47:
        ImageView r115 = this.f147142s;
        if (r115 == null) goto L50;
        r115.setVisibility(8);
    L50:
        TextView r116 = this.f147140q;
        if (r116 == null) goto L53;
        r116.setText(s1.B(R.string.ttlive_preview));
    L53:
        Button r117 = this.f147137n;
        if (r117 == null) goto L56;
        r117.setVisibility(0);
    L56:
        Button r118 = this.f147138o;
        if (r118 == null) goto L59;
        r118.setVisibility(8);
    L59:
        Button r119 = this.f147139p;
        if (r119 == null) goto L62;
        r119.setVisibility(8);
    L62:
        FrameLayout r120 = this.f147144u;
        if (r120 == null) goto L65;
        r120.setVisibility(0);
    L65:
        TextView r121 = this.f147145v;
        if (r121 == null) goto L68;
        r121.setVisibility(8);
    L68:
        this.Q = true;
        Z90(false);
        IRoomModuleService r122 = (IRoomModuleService) k.f(IRoomModuleService.class);
        if (r122 == null) goto L116;
        com.bytedance.android.livesdk.linkvideo.b r123 = r122.getLinkVideoTea();
        if (r123 == null) goto L117;
        r123.a("video_play", v6.a());
        return;
    L117:
        return;
    L116:
        return;
    L7:
        if (r100 != 3) goto L121;
        ImageView r124 = this.f147141r;
        if (r124 == null) goto L12;
        r124.setVisibility(8);
    L12:
        RecyclerView r125 = this.f147148y;
        if (r125 == null) goto L15;
        r125.setVisibility(8);
    L15:
        ImageView r126 = this.f147142s;
        if (r126 == null) goto L18;
        r126.setVisibility(0);
    L18:
        TextView r127 = this.f147140q;
        if (r127 == null) goto L21;
        r127.setText(s1.B(R.string.ttlive_live_related_video));
    L21:
        Button r128 = this.f147137n;
        if (r128 == null) goto L24;
        r128.setVisibility(8);
    L24:
        Button r129 = this.f147138o;
        if (r129 == null) goto L27;
        r129.setVisibility(0);
    L27:
        Button r130 = this.f147139p;
        if (r130 == null) goto L30;
        r130.setVisibility(0);
    L30:
        FrameLayout r131 = this.f147144u;
        if (r131 == null) goto L33;
        r131.setVisibility(0);
    L33:
        TextView r132 = this.f147145v;
        if (r132 == null) goto L36;
        r132.setVisibility(0);
    L36:
        this.O = true;
        this.Q = true;
        Z90(false);
        IRoomModuleService r133 = (IRoomModuleService) k.f(IRoomModuleService.class);
        if (r133 == null) goto L113;
        com.bytedance.android.livesdk.linkvideo.b r134 = r133.getLinkVideoTea();
        if (r134 == null) goto L114;
        r134.i(v6.a());
        return;
    L114:
        return;
    L113:
        return;
    }

    public final void Z90(boolean r100) {
        View r101 = this.C;
        if (r101 == null) goto L8;
        if (r100 == false) goto L6;
        int r102 = 0;
    L7:
        r101.setVisibility(r102);
        goto L8
    L6:
        r102 = 8;
    L8:
        if (r100 == false) goto L13;
        WeakHandler r103 = this.G;
        if (r103 == null) goto L14;
        r103.postDelayed(new d(this), 5000);
        return;
    L14:
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r110) {
        if (r110 != null) goto L4;
        return;
    L4:
        int r111 = r110.getId();
        if (r111 != R.id.btn_reload) goto L9;
        AnchorLinkVideoListViewModel r112 = this.f147132i;
        if (r112 == null) goto L128;
        r112.doAction(new com.bytedance.android.livesdk.linkvideo.f.a(true, true));
        return;
    L128:
        return;
    L9:
        int r100 = 0;
        if (r111 != R.id.iv_back) goto L28;
        int r113 = this.D;
        if (r113 == 1) goto L124;
        if (r113 != 2) goto L132;
        Y90(1);
        U90();
        Button r114 = this.f147137n;
        if (r114 != null) goto L23;
        return;
    L23:
        if (J9() != null) goto L26;
        r100 = 8;
    L26:
        r114.setVisibility(r100);
        return;
    L132:
        return;
    L124:
        dismiss();     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r115 = DialogFragmentLancet.sLastShowStack;
        if (r115 == null) goto L130;
        com.bytedance.crash.d.d(r115, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L130:
        return;
    L28:
        if (r111 != R.id.iv_question) goto L50;
        Context r116 = getContext();
        if ((r116 instanceof FragmentActivity) == true) goto L32;
        r116 = null;
    L32:
        FragmentActivity r117 = (FragmentActivity) r116;
        if (r117 == null) goto L44;
        FragmentManager r118 = r117.getSupportFragmentManager();
        if (r118 == null) goto L44;
        com.bytedance.android.livesdk.linkvideo.h r101 = com.bytedance.android.livesdk.linkvideo.h.f147125a;
        String r102 = this.f147128e;
        if (r102 != null) goto L39;
        r102 = "";
    L39:
        Intrinsics.checkNotNullParameter(r118, "manager");
        Intrinsics.checkNotNullParameter(r102, "pageData");
        ALogger.d("UILinkVideoManager", "介绍页面：goIntroduceDialog");
        String r103 = LinkVideoIntroduceDialog.f147157l;
        Intrinsics.checkNotNullParameter(r118, "manager");
        Intrinsics.checkNotNullParameter(r102, "extra");
        LinkVideoIntroduceDialog.f147157l = r102;
        LinkVideoIntroduceDialog.f147158m = false;
        LinkVideoIntroduceDialog r104 = new LinkVideoIntroduceDialog();
        LandscapeRestrictionOperation r105 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r104, "LinkVideoIntroduceDialog", r105);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r118, r104, r105) == true) goto L44;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L121
    L43:
        r104.show(r118, "LinkVideoIntroduceDialog");
    L44:
        IRoomModuleService r119 = (IRoomModuleService) k.f(IRoomModuleService.class);
        if (r119 == null) goto L135;
        com.bytedance.android.livesdk.linkvideo.b r120 = r119.getLinkVideoTea();
        if (r120 == null) goto L136;
        r120.c(v6.a());
        return;
    L136:
        return;
    L135:
        return;
    L50:
        if (r111 != R.id.btn_link) goto L83;
        if (this.D != 2) goto L54;
        long r106 = this.I;
    L61:
        if (r106 > 0) goto L64;
        f2.b(R.string.ttlive_aweme_video_info_error, 0);
        return;
    L64:
        this.I = r106;
        IRoomModuleService r121 = (IRoomModuleService) k.f(IRoomModuleService.class);
        if (r121 == null) goto L69;
        com.bytedance.android.livesdk.linkvideo.a r122 = r121.getLinkVideoManager();
        if (r122 == null) goto L69;
        r122.b(r106);
    L69:
        f2.c(s1.B(R.string.ttlive_link_video_success_tip), 0);
        IRoomModuleService r123 = (IRoomModuleService) k.f(IRoomModuleService.class);
        if (r123 == null) goto L79;
        com.bytedance.android.livesdk.linkvideo.b r124 = r123.getLinkVideoTea();
        if (r124 == null) goto L79;
        if (this.D != 1) goto L76;
        String r107 = "related_video";
    L77:
        r124.j(r107, v6.a(), String.valueOf(r106));
        goto L79
    L76:
        r107 = "video_play";
    L79:
        if (this.D != 2) goto L81;
        U90();
    L81:
        Y90(3);
        X90(r106);
        return;
    L54:
        gf2.a r125 = J9();
        if (r125 == null) goto L59;
        Long r126 = r125.b();
        if (r126 == null) goto L59;
        r106 = r126.longValue();
    L59:
        r106 = 0;
        goto L61
    L83:
        if (r111 != R.id.btn_cancel) goto L101;
        IRoomModuleService r127 = (IRoomModuleService) k.f(IRoomModuleService.class);
        if (r127 == null) goto L126;
        com.bytedance.android.livesdk.linkvideo.a r128 = r127.getLinkVideoManager();
        if (r128 == null) goto L126;
        r128.a();
    L126:
        dismiss();     // Catch: Exception -> L91
    L95:
        f2.b(R.string.ttlive_cancel_link_already, 0);
        IRoomModuleService r129 = (IRoomModuleService) k.f(IRoomModuleService.class);
        if (r129 == null) goto L139;
        com.bytedance.android.livesdk.linkvideo.b r130 = r129.getLinkVideoTea();
        if (r130 == null) goto L140;
        r130.h(v6.a());
        return;
    L140:
        return;
    L139:
        return;
    L91:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r131 = DialogFragmentLancet.sLastShowStack;
        if (r131 == null) goto L95;
        com.bytedance.crash.d.d(r131, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L95
    L101:
        if (r111 != R.id.btn_again) goto L142;
        this.F = true;
        IRoomModuleService r132 = (IRoomModuleService) k.f(IRoomModuleService.class);
        if (r132 == null) goto L107;
        com.bytedance.android.livesdk.linkvideo.a r133 = r132.getLinkVideoManager();
        if (r133 == null) goto L107;
        r133.a();
    L107:
        U90();
        Y90(1);
        if (this.f147127d != 1) goto L110;
    L111:
        gf2.a r134 = T90(this.I);
        if (r134 != null) goto L114;
        r134 = new gf2.a(0);
        r134.d(Long.valueOf(this.I));
    L114:
        Ao(r134, false);
    L115:
        IRoomModuleService r135 = (IRoomModuleService) k.f(IRoomModuleService.class);
        if (r135 == null) goto L143;
        com.bytedance.android.livesdk.linkvideo.b r136 = r135.getLinkVideoTea();
        if (r136 == null) goto L144;
        r136.g(v6.a());
        return;
    L144:
        return;
    L143:
        return;
    L110:
        if (this.E == true) goto L115;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Dialog r101 = getDialog();
        if (r101 == null) goto L7;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L7;
        r102.setBackgroundDrawable(new ColorDrawable(0));
    L7:
        setStyle(1, R.style.ttlive_CommonBottomDialogFast_DimDisable);
        ((LifecycleRegistry) ((DialogLifecycleOwner) this.f147130g.getValue()).f147111a.getValue()).handleLifecycleEvent(Lifecycle.Event.ON_START);
        MiddlewareRoomContext r103 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, null, 0, 3);
        if (r103 == null) goto L14;
        i<Boolean> r104 = r103.isAnchor();
        if (r104 == null) goto L14;
        Boolean r105 = r104.getValue();
        if (r105 == null) goto L14;
        r105.booleanValue();
    L14:
        Context r106 = getContext();
        if ((r106 instanceof FragmentActivity) == true) goto L17;
        r106 = null;
    L17:
        FragmentActivity r107 = (FragmentActivity) r106;
        if (r107 == null) goto L34;
        AnchorLinkVideoListViewModel r108 = (AnchorLinkVideoListViewModel) ViewModelProviders.of(r107, new AnchorLinkVideoListViewModelFactory()).get(AnchorLinkVideoListViewModel.class);
        if (r108 == null) goto L23;
        r108.initData();
        Unit r109 = Unit.INSTANCE;
    L24:
        this.f147132i = r108;
        if (r108 == null) goto L29;
        MutableLiveData<com.bytedance.android.livesdk.linkvideo.g> r110 = r108.getViewEvent();
        if (r110 == null) goto L29;
        r110.observe((DialogLifecycleOwner) this.f147130g.getValue(), new com.bytedance.android.livesdk.linkvideo.ui.b(this));
    L29:
        MutableLiveData<gf2.a> r111 = this.H;
        if (r111 == null) goto L33;
        r111.setValue(null);
        r111.observe((DialogLifecycleOwner) this.f147130g.getValue(), new com.bytedance.android.livesdk.linkvideo.ui.a(this));
        return;
    L33:
        return;
    L23:
        r108 = null;
        goto L24
    }

    @Override // com.bytedance.android.livesdk.linkvideo.view.h
    public final void Ao(gf2.a r110, boolean r111) {
        if (r110 == null) goto L5;
        boolean r100 = true;
    L6:
        long r101 = 0;
        if (r110 == null) goto L11;
        Long r102 = r110.b();
        if (r102 == null) goto L11;
        long r103 = r102.longValue();
    L12:
        if (r100 == false) goto L30;
        MultiTypeAdapter r104 = this.f147149z;
        if (r104 == null) goto L40;
        List<?> r105 = r104.f513437a;
        if (r105 == null) goto L40;
        Iterator<T> r106 = r105.iterator();
    L19:
        if (r106.hasNext() == false) goto L40;
        Object r107 = r106.next();
        if ((r107 instanceof gf2.a) == false) goto L19;
        gf2.a r108 = (gf2.a) r107;
        Long r109 = r108.b();
        if (r109 != null) goto L26;
    L27:
        boolean r112 = true;
    L29:
        r108.f481047a = r112;
        goto L19
    L26:
        if (r109.longValue() != r103) goto L27;
        r112 = false;
    L40:
        MutableLiveData<gf2.a> r113 = this.H;
        if (r113 == null) goto L43;
        r113.setValue(r110);
    L43:
        if (r111 == false) goto L65;
        IRoomModuleService r114 = (IRoomModuleService) k.f(IRoomModuleService.class);
        if (r114 == null) goto L66;
        com.bytedance.android.livesdk.linkvideo.b r115 = r114.getLinkVideoTea();
        if (r115 == null) goto L67;
        boolean r116 = this.F;
        String r117 = v6.a();
        if (r110 == null) goto L53;
        Long r118 = r110.b();
        if (r118 == null) goto L53;
        r101 = r118.longValue();
    L53:
        r115.e(r116, r117, String.valueOf(r101));
        return;
    L67:
        return;
    L66:
        return;
    L65:
        return;
    L30:
        MultiTypeAdapter r119 = this.f147149z;
        if (r119 == null) goto L40;
        List<?> r120 = r119.f513437a;
        if (r120 == null) goto L40;
        Iterator<T> r121 = r120.iterator();
    L36:
        if (r121.hasNext() == false) goto L40;
        Object r122 = r121.next();
        if ((r122 instanceof gf2.a) == false) goto L36;
        ((gf2.a) r122).f481047a = false;
    L11:
        r103 = 0;
        goto L12
    L5:
        r100 = false;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r101 = r100.inflate(R.layout.ttlive_dialog_anchor_video, r110, true);
        this.f147143t = r101;
        Dialog r112 = getDialog();
        ImageView r113 = null;
        if (r112 == null) goto L5;
        Window r114 = r112.getWindow();
    L6:
        if (r114 == null) goto L8;
        WindowManager.LayoutParams r102 = r114.getAttributes();
    L9:
        if (r102 == null) goto L11;
        r102.gravity = 80;
    L11:
        if (r114 == null) goto L13;
        r114.setAttributes(r102);
    L13:
        Bundle r115 = getArguments();
        if (r115 == null) goto L16;
        int r116 = r115.getInt("key_state", 1);
    L17:
        this.f147127d = r116;
        Bundle r117 = getArguments();
        String r103 = "";
        if (r117 == null) goto L23;
        String r118 = r117.getString("key_extra", "");
        if (r118 == null) goto L23;
        r103 = r118;
    L23:
        this.f147128e = r103;
        Bundle r119 = getArguments();
        if (r119 == null) goto L26;
        long r104 = r119.getLong("key_preview_id", 0);
    L27:
        this.f147129f = r104;
        if (r101 == null) goto L90;
        this.f147133j = r101.findViewById(R.id.fl_loading);
        this.f147134k = r101.findViewById(R.id.ll_reload);
        Button r105 = (Button) r101.findViewById(R.id.btn_reload);
        if (r105 == null) goto L33;
        r105.setOnClickListener(this);
        Unit r106 = Unit.INSTANCE;
    L33:
        this.f147135l = r101.findViewById(R.id.ll_empty);
        this.f147136m = (HSImageView) r101.findViewById(R.id.iv_empty);
        this.f147148y = (RecyclerView) r101.findViewById(R.id.video_pager_rlv);
        this.B = (LiveDoubleColorBallAnimationView) r101.findViewById(R.id.animation_double_ball);
        this.C = r101.findViewById(R.id.cl_tip);
        Button r107 = (Button) r101.findViewById(R.id.btn_link);
        if (r107 == null) goto L36;
        r107.setOnClickListener(this);
        Unit r108 = Unit.INSTANCE;
    L37:
        this.f147137n = r107;
        Button r109 = (Button) r101.findViewById(R.id.btn_cancel);
        if (r109 == null) goto L40;
        r109.setOnClickListener(this);
        Unit r120 = Unit.INSTANCE;
    L41:
        this.f147138o = r109;
        Button r121 = (Button) r101.findViewById(R.id.btn_again);
        if (r121 == null) goto L44;
        r121.setOnClickListener(this);
        Unit r122 = Unit.INSTANCE;
    L45:
        this.f147139p = r121;
        this.f147147x = r101.findViewById(R.id.cl_top);
        View r123 = r101.findViewById(R.id.cl_container);
        if (r123 == null) goto L48;
        r123.post(new com.bytedance.android.livesdk.linkvideo.ui.c(r123, this));
        Unit r124 = Unit.INSTANCE;
    L49:
        this.N = r123;
        this.f147140q = (TextView) r101.findViewById(R.id.tv_title);
        this.f147144u = (FrameLayout) r101.findViewById(R.id.live_play_container);
        this.f147145v = (TextView) r101.findViewById(R.id.tv_link_success_tag);
        Drawable r125 = s1.m(R.drawable.ttlive_ic_link_video_tag);
        if (r125 == null) goto L54;
        r125.setBounds(s1.f(4.0f) + 0, 0, s1.f(12.0f) + s1.f(4.0f), s1.f(12.0f));
        TextView r126 = this.f147145v;
        if (r126 == null) goto L54;
        r126.setCompoundDrawables(r125, null, null, null);
    L54:
        MultiTypeAdapter r127 = new MultiTypeAdapter();
        this.f147149z = r127;
        r127.f513437a = new ArrayList();
        MultiTypeAdapter r128 = this.f147149z;
        if (r128 == null) goto L57;
        r128.z2(gf2.a.class, new com.bytedance.android.livesdk.linkvideo.view.a(this));
    L57:
        MultiTypeAdapter r129 = this.f147149z;
        if (r129 == null) goto L60;
        r129.z2(com.bytedance.android.livesdk.linkvideo.view.f.class, new com.bytedance.android.livesdk.linkvideo.view.e());
    L60:
        final GridLayoutManager r130 = new GridLayoutManager(getContext(), 3);
        r130.setSpanSizeLookup(new LinkVideoDialog$initViews$7(this));
        RecyclerView r131 = this.f147148y;
        if (r131 == null) goto L63;
        r131.setLayoutManager(r130);
    L63:
        RecyclerView r132 = this.f147148y;
        if (r132 == null) goto L66;
        r132.addItemDecoration(new LinkVideoDialog$initViews$8());
    L66:
        RecyclerView r133 = this.f147148y;
        if (r133 == null) goto L69;
        r133.setAdapter(this.f147149z);
    L69:
        RecyclerView r134 = this.f147148y;
        if (r134 == null) goto L72;
        r134.addOnScrollListener(new LinkVideoDialog$initViews$9(this, r130));
    L72:
        MultiTypeAdapter r135 = this.f147149z;
        if (r135 == null) goto L75;
        r135.registerAdapterDataObserver(new LinkVideoDialog$initViews$10(this));
    L75:
        LoadMoreScrollListener r136 = new LoadMoreScrollListener(r130, new LinkVideoDialog$initViews$11(this));
        this.A = r136;
        RecyclerView r137 = this.f147148y;
        if (r137 == null) goto L78;
        r137.addOnScrollListener(r136);
    L78:
        ImageView r138 = (ImageView) r101.findViewById(R.id.iv_back);
        if (r138 == null) goto L81;
        r138.setOnClickListener(this);
        Unit r139 = Unit.INSTANCE;
    L82:
        this.f147141r = r138;
        ImageView r140 = (ImageView) r101.findViewById(R.id.iv_question);
        if (r140 == null) goto L85;
        r140.setOnClickListener(this);
        Unit r141 = Unit.INSTANCE;
        r113 = r140;
    L85:
        this.f147142s = r113;
        if (this.f147127d != 1) goto L90;
        AnchorLinkVideoListViewModel r142 = this.f147132i;
        if (r142 == null) goto L90;
        r142.doAction(new com.bytedance.android.livesdk.linkvideo.f.a(true, true));
        goto L90
    L81:
        r138 = null;
        goto L82
    L48:
        r123 = null;
        goto L49
    L44:
        r121 = null;
        goto L45
    L40:
        r109 = null;
        goto L41
    L36:
        r107 = null;
    L90:
        Y90(this.f147127d);
        if (this.f147127d == 1) goto L96;
        long r143 = this.f147129f;
        if (r143 <= 0) goto L95;
        this.I = r143;
        X90(r143);
        goto L96
    L95:
        f2.b(R.string.ttlive_aweme_video_info_error, 0);
    L96:
        return r101;
    L26:
        r104 = 0;
        goto L27
    L16:
        r116 = 1;
        goto L17
    L8:
        r102 = null;
        goto L9
    L5:
        r114 = null;
        goto L6
    }
}

package com.bytedance.android.livesdk.room.placeholder.behavior;

import android.graphics.drawable.Animatable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.viewmodel.IAnimationScheduler;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.q4;
import com.bytedance.android.livesdk.config.nj1;
import com.bytedance.android.livesdk.config.setting.s;
import com.bytedance.android.livesdk.config.setting.z;
import com.bytedance.android.livesdk.config.ux;
import com.bytedance.android.livesdk.config.xn0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalButton;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.facebook.drawee.interfaces.DraweeController;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/room/placeholder/behavior/AudienceCommerceWrapper;", "Lcom/bytedance/android/livesdk/room/placeholder/behavior/l;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceCommerceWrapper extends l implements Observer<KVData> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f157695g = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f157696b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DataCenter f157697c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f157698d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f157699e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final IExternalButton f157700f;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.livesdk.chatroom.viewmodel.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AudienceCommerceWrapper f157701a;

        @Override // com.bytedance.android.livesdk.chatroom.viewmodel.c
        public final boolean b() {
            return false;
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodel.c
        public final ToolbarButton c() {
            return ToolbarButton.COMMERCE;
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodel.c
        public final com.bytedance.android.livesdk.chatroom.viewmodel.a getInfo() {
            return com.bytedance.android.livesdk.chatroom.viewmodel.a.C1691a.f114773b;
        }

        public b(AudienceCommerceWrapper r100) {
            this.f157701a = r100;
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodel.c
        public final boolean a(long r100) {
            ALogger.i("AnimationCenterScheduler", "ecom-cart schedule " + r100);
            return this.f157701a.f157700f.onTriggerAnimation(r100);
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AudienceCommerceWrapper f157702a;

        public c(AudienceCommerceWrapper r100) {
            this.f157702a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f157702a.f157700f.onViewDetached();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AudienceCommerceWrapper f157703a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f157704b;

        public d(AudienceCommerceWrapper r100, Ref.ObjectRef r101) {
            this.f157703a = r100;
            this.f157704b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            DraweeController r102 = ((HSImageView) this.f157704b.element).getController();
            if (r102 == null) goto L5;
            Animatable r103 = r102.getAnimatable();
        L6:
            if (r103 == null) goto L12;
            DraweeController r104 = ((HSImageView) this.f157704b.element).getController();
            if (r104 == null) goto L16;
            Animatable r105 = r104.getAnimatable();
            if (r105 == null) goto L17;
            r105.start();
            return;
        L17:
            return;
        L16:
            return;
        L12:
            Disposable r106 = this.f157703a.f157698d;
            if (r106 == null) goto L19;
            r106.dispose();
            return;
        L19:
            return;
        L5:
            r103 = null;
            goto L6
        }
    }

    static {
    }

    public final void b() {
        View r100 = this.f157696b;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("itemView");
    L6:
        if ((r100 instanceof ViewGroup) == false) goto L9;
        this.f157700f.onViewWillDetach();
        ((ViewGroup) r100).removeAllViews();
        r100.post(new c(this));
        return;
    }

    public AudienceCommerceWrapper(IExternalButton r100) {
        Intrinsics.checkNotNullParameter(r100, "ext");
        super(r100);
        this.f157700f = r100;
        this.f157699e = new b(this);
    }

    public final boolean c(ViewGroup r100) {
        if (r100.getChildCount() == 1) goto L5;
    L9:
        return false;
    L5:
        if ((r100.getChildAt(0).getTag() instanceof String) == false) goto L9;
        if (Intrinsics.areEqual("skin_animation_view", r100.getChildAt(0).getTag()) == false) goto L9;
        return true;
    }

    public final void e(boolean r100) {
        if (ux.f121407a.getValue().booleanValue() == true) goto L5;
    L28:
        if (r100 == false) goto L64;
        View r101 = this.f157696b;
        if (r101 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("itemView");
    L33:
        if ((r101 instanceof ViewGroup) == false) goto L52;
        ViewGroup r102 = (ViewGroup) r101;
        r102.setClipChildren(false);
        if (r102.getChildCount() > 0) goto L37;
    L39:
        View r103 = this.f157700f.getView();
        this.f157700f.onViewWillAttach(l.a(r101));
        ViewGroup r104 = (ViewGroup) r101;
        if (c(r104) == false) goto L42;
        this.f157700f.getView().setAlpha(0.0f);
    L42:
        int r105 = z.f121222a;
        if (nj1.f120839a.getValue().d() == false) goto L51;
        DataCenter r106 = this.f157697c;
        if (r106 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
    L47:
        Room r107 = (Room) r106.get("data_room", null);
        View r108 = this.f157696b;
        if (r108 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("itemView");
    L50:
        d(r107, r108);
    L51:
        r104.addView(r103);
        r101.post(new g(this, r101));
        goto L52
    L37:
        if (c(r102) == true) goto L39;
        b();
    L52:
        DataCenter r109 = this.f157697c;
        if (r109 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
    L55:
        com.bytedance.android.livesdk.business.douplus.h.g(false, r109);
        int r110 = q4.f117346e;
        DataCenter r111 = this.f157697c;
        if (r111 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
    L58:
        q4.a.b(r111);
        if (s.a() == false) goto L71;
        DataCenter r112 = this.f157697c;
        if (r112 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
    L63:
        y3.m(r112).c(ToolbarButton.COMMERCE.extended());
        return;
    L71:
        return;
    L64:
        b();
        if (s.a() == false) goto L73;
        DataCenter r113 = this.f157697c;
        if (r113 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
    L69:
        y3.m(r113).i(ToolbarButton.COMMERCE.extended());
        return;
    L73:
        return;
    L5:
        if (r100 == false) goto L24;
        DataCenter r114 = this.f157697c;
        if (r114 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
    L10:
        if (com.bytedance.android.livesdk.commerce.b.a(r114).booleanValue() == false) goto L20;
        DataCenter r115 = this.f157697c;
        if (r115 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
    L14:
        Boolean r116 = Boolean.FALSE;
        if (Intrinsics.areEqual((Boolean) r115.get("DATA_AUDIENCE_TRANSFORM_WIDGET_MORE_SHOW", r116), r116) == false) goto L20;
        DataCenter r117 = this.f157697c;
        if (r117 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
    L19:
        r117.put("DATA_AUDIENCE_COMMERCE_MORE_SHOW", Boolean.valueOf(r100));
        r100 = false;
    L20:
        DataCenter r118 = this.f157697c;
        if (r118 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
    L23:
        r118.put("DATA_AUDIENCE_COMMERCE_MORE_SHOW", Boolean.FALSE);
        goto L28
    L24:
        DataCenter r119 = this.f157697c;
        if (r119 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
    L27:
        r119.put("DATA_AUDIENCE_COMMERCE_MORE_SHOW", Boolean.FALSE);
        goto L28
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 == null) goto L5;
        String r102 = r101.getKey();
    L6:
        if (r102 == null) goto L23;
        int r103 = r102.hashCode();
        if (r103 != (-414927467)) goto L11;
        r102.equals("data_audience_interact_game");
        return;
    L11:
        if (r103 == 1579247770) goto L14;
        return;
    L14:
        if (r102.equals("cmd_commerce_ad_show") == false) goto L20;
        Boolean r104 = (Boolean) r101.getData(Boolean.FALSE);
        Boolean r105 = Boolean.TRUE;
        e(!Intrinsics.areEqual(r104, r105));
        if (Intrinsics.areEqual(r104, r105) == false) goto L21;
        ALogger.e("NewToolbarLog", "onChanged Error:live_ad is true");
        return;
    L21:
        return;
    L20:
        return;
    L23:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.room.placeholder.behavior.l, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        super.R9(r100, r101);
        r101.removeObserver(this);
        Disposable r102 = this.f157698d;
        if (r102 == null) goto L5;
        r102.dispose();
    L5:
        IAnimationScheduler.M0.getClass();
        if (IAnimationScheduler.Companion.b() == false) goto L11;
        ALogger.i("AnimationCenterScheduler", "unregister ecom-cart");
        IAnimationScheduler r103 = IAnimationScheduler.Companion.a(r101);
        if (r103 == null) goto L12;
        r103.unRegisterListener(this.f157699e);
        return;
    L12:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v13, types: [com.bytedance.android.live.core.widget.HSImageView] */
    /* JADX WARN: Type inference failed for: r2v3, types: [T, com.bytedance.android.live.core.widget.HSImageView] */
    public final void d(Room r110, View r111) {
        if (ht2.g.f(r110, 5, true) == false) goto L57;
        final Ref.ObjectRef r100 = new Ref.ObjectRef();
        T r101 = 0;
        r100.element = null;
        View r102 = this.f157696b;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("itemView");
    L8:
        if ((r102 instanceof ViewGroup) == false) goto L31;
        View r103 = this.f157696b;
        if (r103 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("itemView");
    L12:
        if (r103 == null) goto L29;
        ViewGroup r104 = (ViewGroup) r103;
        int r105 = r104.getChildCount();
        int r106 = 0;
    L14:
        if (r106 >= r105) goto L27;
        if ((r104.getChildAt(r106) instanceof HSImageView) == false) goto L26;
        if ((r104.getChildAt(r106).getTag() instanceof String) == false) goto L26;
        if (Intrinsics.areEqual("skin_animation_view", r104.getChildAt(r106).getTag()) == false) goto L26;
        View r107 = r104.getChildAt(r106);
        if (r107 == null) goto L25;
        r101 = (HSImageView) r107;
        goto L27
    L25:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.core.widget.HSImageView");
    L26:
        r106 = r106 + 1;
    L27:
        r100.element = r101;
        goto L31
    L29:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L31:
        if (((HSImageView) r100.element) != null) goto L45;
        r100.element = new HSImageView(r111.getContext());
        View r112 = this.f157696b;
        if (r112 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("itemView");
    L36:
        if ((r112 instanceof FrameLayout) == false) goto L44;
        FrameLayout.LayoutParams r113 = new FrameLayout.LayoutParams((int) UIUtils.dip2Px(s1.getContext(), 66.0f), (int) UIUtils.dip2Px(s1.getContext(), 66.0f));
        r113.gravity = 17;
        View r108 = this.f157696b;
        if (r108 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("itemView");
    L40:
        if (r108 == null) goto L43;
        ((ViewGroup) r108).addView((HSImageView) r100.element, r113);
        goto L44
    L43:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L44:
        ((HSImageView) r100.element).setTag("skin_animation_view");
        HSImageView r114 = (HSImageView) r100.element;
        Function0<Unit> r109 = new AudienceCommerceWrapper$renderSkinIcon$1(this, r100);
        Intrinsics.checkNotNullParameter(r109, WidgetCostModule.TYPE_ON_START);
        ht2.g.d(5, r110, r114, r109);
    L45:
        xn0 r115 = xn0.f121619a;
        if (r115.getValue().longValue() <= 0) goto L58;
        Disposable r116 = this.f157698d;
        if (r116 == null) goto L50;
        r116.dispose();
    L50:
        com.bytedance.android.live.core.utils.rxutils.j.a r117 = com.bytedance.android.live.core.utils.rxutils.j.f66356a;
        this.f157698d = com.bytedance.android.live.core.utils.rxutils.j.a(r115.getValue().longValue(), r115.getValue().longValue(), TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this, r100));
        return;
    L58:
        return;
    }

    @Override // com.bytedance.android.livesdk.room.placeholder.behavior.l, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f157696b = r100;
        this.f157697c = r101;
        this.f157700f.onLoad();
        Room r102 = (Room) r101.get("data_room", null);
        if (r101.has("cmd_commerce_ad_show") == true) goto L5;
        e(true);
    L6:
        r101.observe("cmd_commerce_ad_show", this, true);
        if (ux.f121407a.getValue().booleanValue() == false) goto L9;
        r101.observe("data_audience_interact_game", this);
    L9:
        int r103 = z.f121222a;
        if (nj1.f120839a.getValue().d() == true) goto L12;
        d(r102, r100);
    L12:
        IAnimationScheduler.M0.getClass();
        if (IAnimationScheduler.Companion.b() == false) goto L18;
        ALogger.i("AnimationCenterScheduler", "register ecom-cart");
        IAnimationScheduler r104 = IAnimationScheduler.Companion.a(r101);
        if (r104 == null) goto L19;
        r104.registerListener(this.f157699e);
        return;
    L19:
        return;
    L18:
        return;
    L5:
        ALogger.e("NewToolbarLog", "onLoad Error:live_ad is true");
        goto L6
    }
}

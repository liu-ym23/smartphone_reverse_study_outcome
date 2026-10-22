package com.bytedance.android.livesdk.castscreen.padandpc.adapter;

import am2.x;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.m2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livesdk.castscreen.guide.PadAndPcGuideExpandType;
import com.bytedance.android.livesdk.castscreen.utils.LivePadAndPcPlayUtil;
import com.bytedance.android.livesdk.castscreen.utils.LivePadPcLogger;
import com.bytedance.android.livesdk.castscreen.utils.d;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.user.f;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposables;
import java.util.Map;
import jc1.k;
import jta.g;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0005\u0004\u0005\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/castscreen/padandpc/adapter/PadAndPcDeviceListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lpf1/a;", "Lcom/bytedance/android/livesdk/castscreen/padandpc/adapter/PadAndPcDeviceListAdapter$BaseHolder;", "BaseHolder", "PadDeviceHolder", "PadGuideHolder", "PcDeviceHolder", "PcGuideHolder", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PadAndPcDeviceListAdapter extends ListAdapter<pf1.a, BaseHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.livesdk.castscreen.padandpc.vm.a f104646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f104647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f104648c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f104649d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DataCenter f104650e;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b¦\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/castscreen/padandpc/adapter/PadAndPcDeviceListAdapter$BaseHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public abstract class BaseHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public pf1.a f104651a;

        public abstract void T3(pf1.a r100);

        public BaseHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/castscreen/padandpc/adapter/PadAndPcDeviceListAdapter$PadDeviceHolder;", "Lcom/bytedance/android/livesdk/castscreen/padandpc/adapter/PadAndPcDeviceListAdapter$BaseHolder;", "Lcom/bytedance/android/livesdk/castscreen/padandpc/adapter/PadAndPcDeviceListAdapter;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class PadDeviceHolder extends BaseHolder {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ int f104652g = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ImageView f104653b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f104654c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ImageView f104655d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final View f104656e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ PadAndPcDeviceListAdapter f104657f;

        public static final class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ PadDeviceHolder f104658a;

            public a(PadDeviceHolder r100) {
                this.f104658a = r100;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r110) {
                final PadDeviceHolder r111 = this.f104658a;
                LivePadPcLogger.a("livesdk_screen_share_device_click", r111.f104657f.f104650e, PadAndPcDeviceListAdapter$PadDeviceHolder$requestPadPlay$1.INSTANCE);
                pf1.a r100 = r111.f104651a;
                if (r100 == null) goto L34;
                final of1.a r101 = r100.f528841b;
                if (r101 == null) goto L38;
                DataCenter r102 = r111.f104657f.f104650e;
                if (r102 == null) goto L35;
                Room r103 = z.o(r102);
                if (r103 == null) goto L36;
                f r104 = ((IUserService) k.n(IUserService.class)).user();
                o r105 = u.l().c(x.class);
                Lazy r106 = LazyKt.lazy(new PadAndPcDeviceListAdapter$PadDeviceHolder$requestPadPlay$$inlined$let$lambda$1(r111, r101));
                JSONObject r107 = new JSONObject();
                r107.put("url_source", "app_continued");
                com.bytedance.android.livesdk.castscreen.padandpc.vm.a r108 = r111.f104657f.f104646a;
                if (r108 == null) goto L37;
                long r109 = r103.getRoomId();
                long r112 = r103.getRoomId();
                Pair[] r113 = new Pair[12];
                r113[0] = TuplesKt.to("author_id", r103.getOwnerUserIdString());
                r113[1] = TuplesKt.to("from_device_id", ((IHostContext) k.n(IHostContext.class)).getServerDeviceId().toString());
                r113[2] = TuplesKt.to("from_user_id", r104.n());
                r113[3] = TuplesKt.to("is_login", Boolean.valueOf(r104.isLogin()));
                String r114 = null;
                if (r105 == null) goto L18;
                Map<String, String> r115 = r105.getMap();
                if (r115 == null) goto L18;
                String r116 = r115.get("action_type");
            L19:
                r113[4] = TuplesKt.to("action_type", r116);
                r113[5] = TuplesKt.to(ILiveRoomPlayFragmentConstant.EXTRA_IS_APP_LOGIN, m2.b(r104.isLogin()));
                r113[6] = TuplesKt.to("scene", "live");
                ii1.a r117 = (ii1.a) r106.getValue();
                if (r117 == null) goto L22;
                String r118 = r117.h();
            L23:
                r113[7] = TuplesKt.to("enter_from_on_cellphone", r118);
                ii1.a r119 = (ii1.a) r106.getValue();
                if (r119 == null) goto L26;
                r114 = r119.b();
            L26:
                r113[8] = TuplesKt.to("previous_page_on_cellphone", r114);
                DataCenter r120 = r111.f104657f.f104650e;
                if (r120 != null) goto L29;
            L31:
                String r121 = "0";
            L32:
                r113[9] = TuplesKt.to("is_landscape_status_on_cellphone", r121);
                r113[10] = TuplesKt.to("enter_method_on_cellphone", "more_pannel");
                JSONObject r122 = new JSONObject();
                r122.put("common_data", r107);
                Unit r123 = Unit.INSTANCE;
                r113[11] = TuplesKt.to("event_params", r122.toString());
                r108.padPlay(r109, r101, d.a(r112, r113));
                return;
            L29:
                if (z.m(r120, true) == true) goto L31;
                r121 = "1";
                goto L32
            L22:
                r118 = null;
            L18:
                r116 = null;
                goto L19
            L37:
                return;
            L36:
                return;
            L35:
                return;
            L38:
                return;
            }
        }

        @Override // com.bytedance.android.livesdk.castscreen.padandpc.adapter.PadAndPcDeviceListAdapter.BaseHolder
        public final void T3(pf1.a r100) {
            Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
            this.f104651a = r100;
            TextView r101 = this.f104654c;
            pf1.a r102 = null;
            if (r101 == null) goto L9;
            of1.a r103 = r100.f528841b;
            if (r103 == null) goto L7;
            String r104 = r103.getName();
        L8:
            r101.setText(r104);
            goto L9
        L7:
            r104 = null;
        L9:
            com.bytedance.android.livesdk.castscreen.padandpc.vm.a r105 = this.f104657f.f104646a;
            if (r105 == null) goto L14;
            com.bytedance.android.live.core.arch.mvvm.d<pf1.a> r106 = r105.getCurPlayDevice();
            if (r106 == null) goto L14;
            r102 = r106.getValue();
        L14:
            U3(r102);
        }

        public final void U3(pf1.a r100) {
            pf1.a r101 = this.f104651a;
            int r102 = 0;
            if (r101 == null) goto L16;
            of1.a r103 = r101.f528841b;
            if (r103 == null) goto L16;
            boolean r104 = true;
            if (r100 == null) goto L13;
            of1.a r105 = r100.f528841b;
            if (r105 == null) goto L13;
            if (r103.a(r105) != true) goto L13;
            boolean r106 = true;
        L14:
            if (r106 != true) goto L16;
        L17:
            ImageView r107 = this.f104655d;
            if (r107 == null) goto L22;
            if (r104 == true) goto L21;
            r102 = 8;
        L21:
            r107.setVisibility(r102);
        L22:
            TextView r108 = this.f104654c;
            if (r108 == null) goto L25;
            r108.setSelected(r104);
        L25:
            ImageView r109 = this.f104653b;
            if (r109 == null) goto L28;
            r109.setSelected(r104);
        L28:
            if (r104 == false) goto L30;
            return;
        L30:
            if (LivePadAndPcPlayUtil.h() == false) goto L42;
            ImageView r110 = this.f104653b;
            boolean r111 = PadAndPcDeviceListAdapter.y2(this.f104657f);
            if (r110 == null) goto L37;
            if (r111 == false) goto L35;
            int r112 = R.drawable.ttlive_ic_pad_pc_play_pad_device_light_theme;
        L36:
            r110.setBackground(s1.m(r112));
            goto L37
        L35:
            r112 = R.drawable.ttlive_ic_pad_pc_play_pad_device_dark_theme;
        L37:
            TextView r113 = this.f104654c;
            if (r113 == null) goto L43;
            LivePadAndPcPlayUtil.e(r113, PadAndPcDeviceListAdapter.y2(this.f104657f));
            return;
        L43:
            return;
        L42:
            return;
        L13:
            r106 = false;
        L16:
            r104 = false;
            goto L17
        }

        public PadDeviceHolder(PadAndPcDeviceListAdapter r100, View r101) {
            Intrinsics.checkNotNullParameter(r101, "itemView");
            this.f104657f = r100;
            super(r101);
            this.f104653b = (ImageView) r101.findViewById(R.id.ivPadIcon);
            this.f104654c = (TextView) r101.findViewById(R.id.tvDeviceName);
            this.f104655d = (ImageView) r101.findViewById(R.id.ivPadChosen);
            View r102 = r101.findViewById(R.id.vDivider);
            this.f104656e = r102;
            if (LivePadAndPcPlayUtil.h() == false) goto L9;
            ViewGroup.LayoutParams r103 = r101.getLayoutParams();
            if (r103 == null) goto L7;
            r103.height = UtilityKotlinExtentionsKt.i(48);
        L7:
            if (r102 == null) goto L9;
            UtilityKotlinExtentionsKt.t(r102);
        L9:
            r101.setOnClickListener(new a(this));
            com.bytedance.android.livesdk.castscreen.padandpc.vm.a r104 = r100.f104646a;
            if (r104 == null) goto L13;
            RxUtilKt.c(RxUtilKt.h(r104.getCurPlayDevice()).subscribe(new com.bytedance.android.livesdk.castscreen.padandpc.adapter.a(this)), r100.f104649d);
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/castscreen/padandpc/adapter/PadAndPcDeviceListAdapter$PadGuideHolder;", "Lcom/bytedance/android/livesdk/castscreen/padandpc/adapter/PadAndPcDeviceListAdapter$BaseHolder;", "Lcom/bytedance/android/livesdk/castscreen/padandpc/adapter/PadAndPcDeviceListAdapter;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class PadGuideHolder extends BaseHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PadAndPcDeviceListAdapter f104659b;

        public static final class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ PadGuideHolder f104660a;

            public a(PadGuideHolder r100) {
                this.f104660a = r100;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r100) {
                com.bytedance.android.livesdk.castscreen.padandpc.vm.a r101 = this.f104660a.f104659b.f104646a;
                if (r101 == null) goto L6;
                r101.notifyExpendGuide(PadAndPcGuideExpandType.Pad);
                return;
            }
        }

        @Override // com.bytedance.android.livesdk.castscreen.padandpc.adapter.PadAndPcDeviceListAdapter.BaseHolder
        public final void T3(pf1.a r100) {
            Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        }

        public PadGuideHolder(PadAndPcDeviceListAdapter r100, View r101) {
            Intrinsics.checkNotNullParameter(r101, "itemView");
            this.f104659b = r100;
            super(r101);
            r101.setOnClickListener(new a(this));
            LivePadAndPcPlayUtil.a(r101, PadAndPcDeviceListAdapter.y2(r100));
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/castscreen/padandpc/adapter/PadAndPcDeviceListAdapter$PcDeviceHolder;", "Lcom/bytedance/android/livesdk/castscreen/padandpc/adapter/PadAndPcDeviceListAdapter$BaseHolder;", "Lcom/bytedance/android/livesdk/castscreen/padandpc/adapter/PadAndPcDeviceListAdapter;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class PcDeviceHolder extends BaseHolder {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ int f104661g = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ImageView f104662b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final LottieAnimationView f104663c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f104664d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final View f104665e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ PadAndPcDeviceListAdapter f104666f;

        public static final class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ PcDeviceHolder f104667a;

            public a(PcDeviceHolder r100) {
                this.f104667a = r100;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r110) {
                PcDeviceHolder r111 = this.f104667a;
                LivePadPcLogger.a("livesdk_screen_share_device_click", r111.f104666f.f104650e, PadAndPcDeviceListAdapter$PcDeviceHolder$requestPcPlay$1.INSTANCE);
                pf1.a r100 = r111.f104651a;
                if (r100 == null) goto L29;
                com.bytedance.android.livesdk.castscreen.castscreenapi.model.b r101 = r100.f528842c;
                if (r101 == null) goto L32;
                DataCenter r102 = r111.f104666f.f104650e;
                if (r102 == null) goto L30;
                Room r103 = z.o(r102);
                if (r103 == null) goto L33;
                com.bytedance.android.livesdk.castscreen.padandpc.vm.a r104 = r111.f104666f.f104646a;
                if (r104 == null) goto L31;
                long r105 = r103.getRoomId();
                String r106 = r103.getOwnerUserIdString();
                JSONObject r107 = new JSONObject();
                ii1.a r108 = (ii1.a) r111.f104666f.f104648c.getValue();
                String r109 = null;
                if (r108 == null) goto L17;
                String r112 = r108.h();
            L18:
                r107.put("enter_from_on_cellphone", r112);
                ii1.a r113 = (ii1.a) r111.f104666f.f104648c.getValue();
                if (r113 == null) goto L21;
                r109 = r113.b();
            L21:
                r107.put("previous_page_on_cellphone", r109);
                DataCenter r114 = r111.f104666f.f104650e;
                if (r114 == null) goto L26;
                int r115 = 1;
                if (z.m(r114, true) == true) goto L26;
            L27:
                r107.put("is_landscape_status_on_cellphone", r115);
                r107.put("enter_method_on_cellphone", "more_pannel");
                r107.put("scene", "live");
                r107.put("room_id", Long.valueOf(r103.getRoomId()).longValue());
                r107.put("from_device_id", g.d());
                o0.a r116 = o0.f58946a;
                String r117 = ((IUserService) k.n(IUserService.class)).user().n();
                r116.getClass();
                r107.put("from_user_id", o0.a.f(r117));
                Unit r118 = Unit.INSTANCE;
                r104.pcPlay(r105, r106, r101, r107.toString());
                return;
            L26:
                r115 = 0;
                goto L27
            L17:
                r112 = null;
                goto L18
            L31:
                return;
            L33:
                return;
            L30:
                return;
            L32:
                return;
            }
        }

        @Override // com.bytedance.android.livesdk.castscreen.padandpc.adapter.PadAndPcDeviceListAdapter.BaseHolder
        public final void T3(pf1.a r100) {
            Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
            this.f104651a = r100;
            TextView r101 = this.f104664d;
            pf1.a r102 = null;
            if (r101 == null) goto L9;
            com.bytedance.android.livesdk.castscreen.castscreenapi.model.b r103 = r100.f528842c;
            if (r103 == null) goto L7;
            String r104 = r103.a();
        L8:
            r101.setText(r104);
            goto L9
        L7:
            r104 = null;
        L9:
            com.bytedance.android.livesdk.castscreen.padandpc.vm.a r105 = this.f104666f.f104646a;
            if (r105 == null) goto L14;
            com.bytedance.android.live.core.arch.mvvm.d<pf1.a> r106 = r105.getCurPlayDevice();
            if (r106 == null) goto L14;
            r102 = r106.getValue();
        L14:
            U3(r102);
        }

        public final void U3(pf1.a r100) {
            pf1.a r101 = this.f104651a;
            int r102 = 0;
            if (r101 == null) goto L23;
            com.bytedance.android.livesdk.castscreen.castscreenapi.model.b r103 = r101.f528842c;
            if (r103 == null) goto L23;
            Long r104 = r103.b();
            if (r104 == null) goto L23;
            long r105 = r104.longValue();
            if (r100 == null) goto L13;
            com.bytedance.android.livesdk.castscreen.castscreenapi.model.b r106 = r100.f528842c;
            if (r106 == null) goto L13;
            Long r107 = r106.b();
        L14:
            boolean r108 = true;
            if (r107 != null) goto L18;
        L20:
            boolean r109 = false;
        L21:
            if (r109 != true) goto L23;
        L24:
            ImageView r110 = this.f104662b;
            if (r110 == null) goto L30;
            if (r108 == false) goto L28;
            int r111 = 4;
        L29:
            r110.setVisibility(r111);
            goto L30
        L28:
            r111 = 0;
        L30:
            LottieAnimationView r112 = this.f104663c;
            if (r112 == null) goto L35;
            if (r108 == true) goto L34;
            r102 = 8;
        L34:
            r112.setVisibility(r102);
        L35:
            LottieAnimationView r113 = this.f104663c;
            if (r113 == null) goto L44;
            if (r108 == false) goto L42;
            if (r113.isAnimating() == true) goto L44;
            r113.playAnimation();
            goto L44
        L42:
            if (r113.isAnimating() == false) goto L44;
            r113.cancelAnimation();
        L44:
            if (r108 == false) goto L46;
            return;
        L46:
            if (LivePadAndPcPlayUtil.h() == false) goto L58;
            ImageView r114 = this.f104662b;
            boolean r115 = PadAndPcDeviceListAdapter.y2(this.f104666f);
            if (r114 == null) goto L53;
            if (r115 == false) goto L51;
            int r116 = R.drawable.ttlive_ic_pad_pc_play_pc_device_light_theme;
        L52:
            r114.setBackground(s1.m(r116));
            goto L53
        L51:
            r116 = R.drawable.ttlive_ic_pad_pc_play_pc_device_dark_theme;
        L53:
            TextView r117 = this.f104664d;
            if (r117 == null) goto L59;
            LivePadAndPcPlayUtil.e(r117, PadAndPcDeviceListAdapter.y2(this.f104666f));
            return;
        L59:
            return;
        L58:
            return;
        L18:
            if (r105 != r107.longValue()) goto L20;
            r109 = true;
        L13:
            r107 = null;
        L23:
            r108 = false;
            goto L24
        }

        public PcDeviceHolder(PadAndPcDeviceListAdapter r100, View r101) {
            Intrinsics.checkNotNullParameter(r101, "itemView");
            this.f104666f = r100;
            super(r101);
            this.f104662b = (ImageView) r101.findViewById(R.id.ivPlayStatus);
            this.f104663c = (LottieAnimationView) r101.findViewById(R.id.lottieLinking);
            this.f104664d = (TextView) r101.findViewById(R.id.tvDeviceName);
            View r102 = r101.findViewById(R.id.vDivider);
            this.f104665e = r102;
            if (LivePadAndPcPlayUtil.h() == false) goto L9;
            ViewGroup.LayoutParams r103 = r101.getLayoutParams();
            if (r103 == null) goto L7;
            r103.height = UtilityKotlinExtentionsKt.i(48);
        L7:
            if (r102 == null) goto L9;
            UtilityKotlinExtentionsKt.t(r102);
        L9:
            r101.setOnClickListener(new a(this));
            com.bytedance.android.livesdk.castscreen.padandpc.vm.a r104 = r100.f104646a;
            if (r104 == null) goto L12;
            RxUtilKt.c(RxUtilKt.h(r104.getCurPlayDevice()).subscribe(new b(this)), r100.f104649d);
        L12:
            RxUtilKt.c(Disposables.fromAction(new c(this)), r100.f104649d);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/castscreen/padandpc/adapter/PadAndPcDeviceListAdapter$PcGuideHolder;", "Lcom/bytedance/android/livesdk/castscreen/padandpc/adapter/PadAndPcDeviceListAdapter$BaseHolder;", "Lcom/bytedance/android/livesdk/castscreen/padandpc/adapter/PadAndPcDeviceListAdapter;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class PcGuideHolder extends BaseHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PadAndPcDeviceListAdapter f104668b;

        public static final class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ PcGuideHolder f104669a;

            public a(PcGuideHolder r100) {
                this.f104669a = r100;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r100) {
                com.bytedance.android.livesdk.castscreen.padandpc.vm.a r101 = this.f104669a.f104668b.f104646a;
                if (r101 == null) goto L6;
                r101.notifyExpendGuide(PadAndPcGuideExpandType.Pc);
                return;
            }
        }

        @Override // com.bytedance.android.livesdk.castscreen.padandpc.adapter.PadAndPcDeviceListAdapter.BaseHolder
        public final void T3(pf1.a r100) {
            Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        }

        public PcGuideHolder(PadAndPcDeviceListAdapter r100, View r101) {
            Intrinsics.checkNotNullParameter(r101, "itemView");
            this.f104668b = r100;
            super(r101);
            r101.setOnClickListener(new a(this));
            TextView r102 = (TextView) r101.findViewById(R.id.tvSubPcTitle);
            if (r102 == null) goto L5;
            LivePadAndPcPlayUtil.c(r102, PadAndPcDeviceListAdapter.y2(r100));
        L5:
            LivePadAndPcPlayUtil.b(r101, PadAndPcDeviceListAdapter.y2(r100));
        }
    }

    public PadAndPcDeviceListAdapter(DataCenter r100) {
        super(new PadAndPcDeviceDiffCallback());
        this.f104650e = r100;
        this.f104647b = LazyKt.lazy(new PadAndPcDeviceListAdapter$isLightTheme$2(this));
        this.f104648c = LazyKt.lazy(new PadAndPcDeviceListAdapter$roomLogger$2(this));
        this.f104649d = new CompositeDisposable();
    }

    public static final boolean y2(PadAndPcDeviceListAdapter r100) {
        return ((Boolean) r100.f104647b.getValue()).booleanValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        pf1.a r101 = getItem(r100);
        Integer r102 = r101.f528840a;
        if (r102 == null) goto L6;
        return r102.intValue();
    L6:
        if (r101.f528841b == null) goto L8;
        return 1;
    L8:
        return 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        BaseHolder r102 = (BaseHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holderPad");
        r102.T3(getItem(r101));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (r101 == 1) goto L15;
        if (r101 == 2) goto L19;
        if (r101 == 3) goto L18;
        if (r101 == 4) goto L17;
        return new PcDeviceHolder(this, LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_item_view_pad_and_pc_pc_device, r100, false));
    L17:
        return new PadGuideHolder(this, LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_item_view_pad_and_pc_pad_guide, r100, false));
    L18:
        return new PcGuideHolder(this, LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_item_view_pad_and_pc_pc_guide, r100, false));
    L19:
        return new PcDeviceHolder(this, LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_item_view_pad_and_pc_pc_device, r100, false));
    L15:
        return new PadDeviceHolder(this, LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_item_view_pad_device, r100, false));
    }
}

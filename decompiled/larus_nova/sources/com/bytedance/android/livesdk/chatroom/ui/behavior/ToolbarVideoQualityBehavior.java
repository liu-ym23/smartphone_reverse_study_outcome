package com.bytedance.android.livesdk.chatroom.ui.behavior;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.live.room.api.login.ILoginGuideService;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.castscreen.leboController.bytecast.ui.LiveByteCastUIHelper;
import com.bytedance.android.livesdk.castscreen.views.CastScreenViewModel;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.resolution.AudienceVideoResolutionManager;
import com.bytedance.android.livesdk.chatroom.room.p0;
import com.bytedance.android.livesdk.chatroom.ui.y6;
import com.bytedance.android.livesdk.chatroom.utils.VSMediaUIConfigHelper;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.chatroom.utils.uhdLogin.UhdLoginManager;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.VSPlayerViewControlContext;
import com.bytedance.android.livesdk.config.m50;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.service.h;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.IQuality;
import com.bytedance.android.livesdkapi.depend.model.live.LiveCoreSDKData;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.model.ListenLiveStatus;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/behavior/ToolbarVideoQualityBehavior;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/c0$b;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ToolbarVideoQualityBehavior implements c0.b, Observer<KVData> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f112614m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f112615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DataCenter f112616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f112617c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f112618d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CompositeDisposable f112619e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f112620f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ToolbarVideoQualityBehavior$observer$1 f112621g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f112622h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Context f112623i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Room f112624j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f112625k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View.OnClickListener f112626l;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ToolbarVideoQualityBehavior f112627a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IRoomEventHub f112628b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LifecycleOwner f112629c;

        public b(ToolbarVideoQualityBehavior r100, IRoomEventHub r101, LifecycleOwner r102) {
            this.f112627a = r100;
            this.f112628b = r101;
            this.f112629c = r102;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Integer r101 = (Integer) r100;
            if (r101 == null) goto L5;
            int r102 = r101.intValue();
        L6:
            if (r102 <= 0) goto L9;
            ToolbarVideoQualityBehavior r103 = this.f112627a;
            int r104 = ToolbarVideoQualityBehavior.f112614m;
            r103.c();
            return;
        L9:
            return;
        L5:
            r102 = 0;
            goto L6
        }
    }

    public static final class c implements DialogInterface.OnDismissListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f112630a = null;

        static {
            f112630a = new c();
        }

        public c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r100) {
            xs2.b.a().post(new do1.b());
        }
    }

    public static final class d<T> implements androidx.lifecycle.Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ToolbarVideoQualityBehavior f112631a;

        public d(ToolbarVideoQualityBehavior r100) {
            this.f112631a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if (((Boolean) r100).booleanValue() == false) goto L6;
            ToolbarVideoQualityBehavior r101 = this.f112631a;
            int r102 = ToolbarVideoQualityBehavior.f112614m;
            r101.b();
            return;
        }
    }

    public static final class e<T> implements com.bytedance.android.livesdk.app.dataholder.Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ToolbarVideoQualityBehavior f112632a;

        public e(ToolbarVideoQualityBehavior r100) {
            this.f112632a = r100;
        }

        @Override // com.bytedance.android.livesdk.app.dataholder.Observer
        public final void onChanged(Object r100) {
            Integer r101 = (Integer) r100;
            if (r101 != null) goto L6;
            return;
        L6:
            if (r101.intValue() != 0) goto L11;
            ToolbarVideoQualityBehavior r102 = this.f112632a;
            r102.f112618d = false;
            View r103 = r102.f112615a;
            if (r103 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("view");
        L10:
            r103.setAlpha(1.0f);
            return;
        L11:
            this.f112632a.f112618d = true;
            MiddlewareRoomContext r104 = o3.b();
            if (r104 == null) goto L23;
            m<Boolean> r105 = r104.getVsInChorusConcert();
            if (r105 != null) goto L16;
            return;
        L16:
            if (r105.getValue().booleanValue() == true) goto L25;
            View r106 = this.f112632a.f112615a;
            if (r106 != null) goto L20;
            Intrinsics.throwUninitializedPropertyAccessException("view");
        L20:
            r106.setAlpha(0.2f);
            return;
        L25:
            return;
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ToolbarVideoQualityBehavior f112633a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DataCenter f112634b;

        public f(ToolbarVideoQualityBehavior r100, DataCenter r101) {
            this.f112633a = r100;
            this.f112634b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Boolean r101 = (Boolean) r100;
            Lazy r102 = LiveByteCastUIHelper.f104523a;
            if (LiveByteCastUIHelper.k(this.f112634b) == false) goto L5;
            return;
        L5:
            if (r101.booleanValue() == false) goto L10;
            View r103 = this.f112633a.f112615a;
            if (r103 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException("view");
        L9:
            r103.setVisibility(8);
            return;
        L10:
            View r104 = this.f112633a.f112615a;
            if (r104 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("view");
        L13:
            r104.setVisibility(0);
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ToolbarVideoQualityBehavior f112635a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DataCenter f112636b;

        public g(ToolbarVideoQualityBehavior r100, DataCenter r101) {
            this.f112635a = r100;
            this.f112636b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            ToolbarVideoQualityBehavior r102 = this.f112635a;
            int r103 = ToolbarVideoQualityBehavior.f112614m;
            r102.getClass();
            ILivePlayerClient r104 = LivePlatformPlayerManager.f();
            if (r104 == null) goto L9;
            IRoomEventHub r105 = r104.getEventHub();
            if (r105 == null) goto L9;
            MutableLiveData<Boolean> r106 = r105.getFirstFrame();
            if (r106 == null) goto L9;
            Boolean r107 = r106.getValue();
        L11:
            if (Intrinsics.areEqual(r107, Boolean.TRUE) == false) goto L13;
            this.f112635a.c();
            return;
        L13:
            ILivePlayerClient r108 = LivePlatformPlayerManager.f();
            if (r108 == null) goto L22;
            IRoomEventHub r109 = r108.getEventHub();
            if (r109 == null) goto L23;
            MutableLiveData<Boolean> r110 = r109.getFirstFrame();
            if (r110 == null) goto L24;
            r110.observe(this.f112636b.lifecycleOwner, this.f112635a.f112621g);
            return;
        L24:
            return;
        L23:
            return;
        L22:
            return;
        L9:
            r107 = null;
            goto L11
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(s r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void SY(s r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r100) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public final void c() {
        int r100 = AudienceVideoResolutionManager.f110411a;
        View r101 = null;
        if (AudienceVideoResolutionManager.o() == false) goto L5;
        String r102 = PlayerResolution.NAME.AUTO;
    L63:
        if (r102 != null) goto L65;
    L68:
        boolean r103 = true;
    L69:
        if (r103 == true) goto L111;
        View r104 = this.f112615a;
        if (r104 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L74:
        if (r104 == null) goto L110;
        CharSequence r105 = ((TextView) r104).getText();
        String r106 = "";
        if (r105 == null) goto L79;
        String r107 = r105.toString();
        if (r107 == null) goto L79;
    L81:
        if (Intrinsics.areEqual(r107, r102) == false) goto L83;
        return;
    L83:
        View r108 = this.f112615a;
        if (r108 != null) goto L87;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L87:
        if ((r108 instanceof TextView) == false) goto L90;
        r101 = r108;
    L90:
        TextView r109 = (TextView) r101;
        if (r109 == null) goto L93;
        r109.setText(r102);
    L93:
        d(r102);
        View r110 = this.f112615a;
        if (r110 != null) goto L96;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L96:
        View r111 = this.f112615a;
        if (r111 != null) goto L99;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L99:
        if (r111 == null) goto L108;
        CharSequence r112 = ((TextView) r111).getText();
        if (r112 == null) goto L106;
        String r113 = r112.toString();
        if (r113 == null) goto L106;
        r106 = r113;
    L106:
        r3.c(r110, r106, true);
        return;
    L108:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L79:
        r107 = "";
        goto L81
    L110:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L111:
        return;
    L65:
        if (r102.length() == 0) goto L68;
        r103 = false;
        goto L69
    L5:
        nm1.m r114 = pm1.f.l();
        if (r114 != null) goto L8;
    L44:
        StreamUrl r115 = this.f112624j.getStreamUrl();
        if (r115 == null) goto L62;
        List<IQuality> r116 = r115.getQualityList();
        if (r116 == null) goto L62;
        Iterator<T> r117 = r116.iterator();
    L50:
        if (r117.hasNext() == false) goto L58;
        Object r118 = r117.next();
        String r119 = ((IQuality) r118).getSdkKey();
        ILivePlayerClient r120 = LivePlatformPlayerManager.f();
        if (r120 == null) goto L54;
        String r121 = r120.getCurrentResolution();
    L56:
        if (TextUtils.equals(r119, r121) == false) goto L50;
    L59:
        IQuality r122 = (IQuality) r118;
        if (r122 == null) goto L62;
        r102 = r122.getName();
        goto L63
    L54:
        r121 = null;
        goto L56
    L58:
        r118 = null;
    L62:
        r102 = null;
        goto L63
    L8:
        if (r114.a(this.f112616b) != true) goto L44;
        nm1.m r123 = pm1.f.l();
        if (r123 == null) goto L12;
        IBaseStreamUrl r124 = r123.E(this.f112616b);
    L13:
        if (r124 == null) goto L30;
        List<IQuality> r125 = r124.getQualityList();
        if (r125 == null) goto L30;
        Iterator<T> r126 = r125.iterator();
    L18:
        if (r126.hasNext() == false) goto L26;
        Object r127 = r126.next();
        String r128 = ((IQuality) r127).getSdkKey();
        ILivePlayerClient r129 = LivePlatformPlayerManager.f();
        if (r129 == null) goto L22;
        String r130 = r129.getCurrentResolution();
    L24:
        if (TextUtils.equals(r128, r130) == false) goto L18;
    L27:
        IQuality r131 = (IQuality) r127;
        if (r131 == null) goto L30;
        String r132 = r131.getName();
    L31:
        if (r132 == null) goto L118;
        View r133 = this.f112615a;
        if (r133 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L36:
        if ((r133 instanceof TextView) == false) goto L39;
        r101 = r133;
    L39:
        TextView r134 = (TextView) r101;
        if (r134 == null) goto L42;
        r134.setText(r132);
    L42:
        d(r132);
        return;
    L118:
        return;
    L22:
        r130 = null;
        goto L24
    L26:
        r127 = null;
    L30:
        r132 = null;
        goto L31
    L12:
        r124 = null;
        goto L13
    }

    public final void b() {
        ILivePlayerClient r100 = LivePlatformPlayerManager.f();
        LifecycleOwner r101 = null;
        if (r100 == null) goto L5;
        IRoomEventHub r102 = r100.getEventHub();
    L6:
        ILivePlayerClient r103 = LivePlatformPlayerManager.f();
        if (r103 == null) goto L9;
        r101 = r103.getLifecycleOwner();
    L9:
        if (r101 == null) goto L15;
        if (r102 == null) goto L16;
        MutableLiveData<Integer> r104 = r102.getAbrSwitch();
        if (r104 == null) goto L17;
        r104.observe(r101, new b(this, r102, r101));
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final boolean a(Room r100) {
        Intrinsics.checkNotNullParameter(r100, "room");
        nm1.m r101 = pm1.f.l();
        if (r101 == null) goto L28;
        if (r101.a(this.f112616b) != true) goto L28;
        nm1.m r102 = pm1.f.l();
        if (r102 == null) goto L9;
        IBaseStreamUrl r103 = r102.E(this.f112616b);
    L10:
        if (r103 != null) goto L12;
    L19:
        if (r103 == null) goto L23;
        Set<String> r104 = r103.getQualities();
        if (r104 == null) goto L23;
        int r105 = r104.size();
    L24:
        if (r105 <= 1) goto L47;
    L25:
        return true;
    L47:
        return false;
    L23:
        r105 = 0;
        goto L24
    L12:
        if (r103.isMultiPullDataValid() != true) goto L19;
        List<IQuality> r106 = r103.getQualityList();
        if (r106 == null) goto L16;
        int r107 = r106.size();
    L17:
        if (r107 > 1) goto L25;
        return false;
    L16:
        r107 = 0;
        goto L17
    L9:
        r103 = null;
    L28:
        if (r100.isMultiPullDataValid() == false) goto L37;
        StreamUrl r108 = r100.getStreamUrl();
        if (r108 == null) goto L34;
        List<IQuality> r109 = r108.getQualityList();
        if (r109 == null) goto L34;
        int r110 = r109.size();
    L35:
        if (r110 <= 1) goto L48;
    L44:
        return true;
    L48:
        return false;
    L34:
        r110 = 0;
        goto L35
    L37:
        StreamUrl r111 = r100.getStreamUrl();
        if (r111 == null) goto L42;
        Set<String> r112 = r111.getQualities();
        if (r112 == null) goto L42;
        int r113 = r112.size();
    L43:
        if (r113 > 1) goto L44;
        return false;
    L42:
        r113 = 0;
        goto L43
    }

    public final void d(String r110) {
        View r100 = this.f112615a;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L6:
        if ((r100 instanceof TextView) == true) goto L8;
        r100 = null;
    L8:
        TextView r101 = (TextView) r100;
        if (r101 != null) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(r110, "fhd") == true) goto L20;
        ILivePlayerClient r111 = LivePlatformPlayerManager.f();
        if (r111 == null) goto L15;
        String r112 = r111.getCurrentResolution();
    L17:
        if (Intrinsics.areEqual(r112, "fhd") == true) goto L20;
        r101.getPaint().setShader(null);
        return;
    L15:
        r112 = null;
    L20:
        r101.getPaint().setShader(new LinearGradient(0.0f, 0.0f, r101.getPaint().getTextSize() * r101.getText().length(), 0.0f, ArraysKt.toIntArray(new Integer[]{Integer.valueOf(ColorProtector.parseColor("#FFCA7E")), Integer.valueOf(ColorProtector.parseColor("#FFEECC")), Integer.valueOf(ColorProtector.parseColor("#FFCE95"))}), ArraysKt.toFloatArray(new Float[]{Float.valueOf(0.0f), Float.valueOf(0.67f), Float.valueOf(1.0f)}), Shader.TileMode.CLAMP));
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        Intrinsics.checkNotNullParameter(r101, "kvData");
        if (TextUtils.isEmpty(r101.getKey()) == true) goto L27;
        String r102 = r101.getKey();
        int r103 = r102.hashCode();
        if (r103 == (-1477198303)) goto L19;
        if (r103 == 64125084) goto L16;
        if (r103 == 161190806) goto L13;
        return;
    L13:
        if (r102.equals("cmd_switch_resolution_success") == false) goto L22;
        c();
        return;
    L22:
        return;
    L16:
        if (r102.equals("data_video_resolution_degrade") == false) goto L24;
        c();
        return;
    L24:
        return;
    L19:
        if (r102.equals("data_switch_resolution_by_cast_screen") == false) goto L26;
        c();
        return;
    L26:
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r110) {
        ALogger.d("vsInChorusConcert", "onclick");
        HashMap<Integer, com.bytedance.android.livesdk.chatroom.utils.uhdLogin.a> r100 = UhdLoginManager.f114644a;
        y6 r101 = null;
        RoomContext r102 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r102 == null) goto L43;
        m<Room> r103 = r102.getRoom();
        if (r103 == null) goto L43;
        Room r104 = r103.getValue();
        if (r104 == null) goto L43;
        if (r104.isMergeVSRoom() == true) goto L43;
        StreamUrl r105 = r104.getStreamUrl();
        if (r105 == null) goto L15;
        if (r105.getVPassDefault() == true) goto L43;
    L15:
        if (r104.isVrRoom() == true) goto L43;
        if (r104.isPaidRoom() == true) goto L43;
        StreamUrl r106 = r104.getStreamUrl();
        if (r106 == null) goto L43;
        if (r106.isMultiPullDataValid() != true) goto L43;
        StreamUrl r107 = r104.getStreamUrl();
        if (r107 == null) goto L39;
        List<IQuality> r108 = r107.getQualityList();
        if (r108 == null) goto L39;
        Iterator<T> r109 = r108.iterator();
    L28:
        if (r109.hasNext() == false) goto L37;
        Object r111 = r109.next();
        IQuality r112 = (IQuality) r111;
        if (r112 != null) goto L32;
    L34:
        boolean r113 = false;
    L35:
        if (r113 == false) goto L28;
    L38:
        IQuality r114 = (IQuality) r111;
    L40:
        if (r114 == null) goto L43;
        boolean r115 = false;
    L44:
        RoomContext r116 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r116 == null) goto L60;
        i<Boolean> r117 = r116.isAnchor();
        if (r117 == null) goto L60;
        if (r117.getValue().booleanValue() == true) goto L60;
        h r118 = TTLiveSDKContext.getHostService();
        if (r118 == null) goto L57;
        com.bytedance.android.livesdk.user.f r119 = ((com.bytedance.android.livesdk.service.f) r118).h();
        if (r119 == null) goto L57;
        if (r119.isLogin() != true) goto L57;
        boolean r120 = true;
    L58:
        if (r120 == false) goto L60;
        boolean r121 = true;
    L61:
        boolean r122 = !UhdLoginManager.f114646c.a();
        ALogger.i("UhdLoginTimerManager", "Check result for uhd force login: roomFiltered: " + r115 + ", userFiltered: " + r121 + ", configFiltered: " + r122);
        if (r115 == true) goto L66;
        if (r121 == true) goto L66;
        if (r122 == true) goto L66;
        boolean r123 = true;
    L67:
        if (r123 == false) goto L74;
        ((ILoginGuideService) k.n(ILoginGuideService.class)).intercept(new q61.c(new q61.b.a(cz.c.d.f465998c)));     // Catch: Exception -> L70
        return;
    L70:
        e = move-exception;
        ALogger.e("UhdLoginTimerManager", e.getMessage());
        return;
    L74:
        if (this.f112618d == false) goto L82;
        MiddlewareRoomContext r124 = o3.b();
        if (r124 == null) goto L82;
        m<Boolean> r125 = r124.getVsInChorusConcert();
        if (r125 == null) goto L82;
        if (r125.getValue().booleanValue() == true) goto L82;
        return;
    L82:
        DataCenter r126 = this.f112616b;
        if (r126 == null) goto L90;
        ListenLiveStatus r127 = (ListenLiveStatus) r126.get("cmd_change_listen_live_status");
        if (r127 == null) goto L90;
        if (r127.isOpen() != true) goto L90;
        f2.b(R.string.ttlive_live_cannot_switch_when_listen, 0);
        return;
    L90:
        MiddlewareRoomContext r128 = o3.b();
        if (r128 == null) goto L98;
        m<Boolean> r129 = r128.getVsInChorusConcert();
        if (r129 == null) goto L98;
        if (r129.getValue().booleanValue() != true) goto L98;
        ALogger.d("vsInChorusConcert", "onclick vsInChorusConcert true return");
        f2.c("连线状态下暂不支持切换清晰度", 0);
        return;
    L98:
        ALogger.d("vsInChorusConcert", "onclick continue");
        this.f112626l.onClick(r110);
        y6 r130 = new y6(this.f112623i, this.f112624j, this.f112616b);
        r130.setOnDismissListener(c.f112630a);
        if (r130.isShowing() == true) goto L101;
        r101 = r130;
    L101:
        if (r101 != null) goto L103;
    L107:
        AudienceVideoResolutionManager.q();
        return;
    L103:
        if (DialogLancet.shouldBlockDialogShow(r101) == false) goto L110;
        DialogLancet.handleBlockedDialogShow(r101);
        goto L107
    L110:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L109
    L106:
        DialogLancet.beforeDialogShow(r101);
        r101.show();
        DialogLancet.afterDialogShow(r101);
    L66:
        r123 = false;
    L57:
        r120 = false;
    L60:
        r121 = false;
        goto L61
    L32:
        if (Intrinsics.areEqual(r112.getName(), PlayerResolution.NAME.UHD) == false) goto L34;
        r113 = true;
        goto L35
    L37:
        r111 = null;
    L39:
        r114 = null;
    L43:
        r115 = true;
        goto L44
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        DataCenter r102 = this.f112616b;
        if (r102 == null) goto L5;
        r102.removeObserver(this);
    L5:
        this.f112616b = null;
        e r103 = this.f112617c;
        if (r103 == null) goto L8;
        hd0.c.f().e(r103);
    L8:
        this.f112619e.clear();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r100, DataCenter r110) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r110, "dataCenter");
        this.f112615a = r100;
        this.f112616b = r110;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L6:
        if ((r100 instanceof TextView) == true) goto L8;
    L171:
        View r101 = this.f112615a;
        if (r101 != null) goto L174;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L174:
        r101.setVisibility(8);
        return;
    L8:
        if (a(this.f112624j) == false) goto L171;
        if (this.f112624j.isMergeVSRoom() == false) goto L12;
    L30:
        View r102 = this.f112615a;
        if (r102 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L34:
        if ((r102 instanceof TextView) == false) goto L42;
        View r103 = this.f112615a;
        if (r103 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L38:
        if (r103 == null) goto L41;
        ((TextView) r103).setPadding(UtilityKotlinExtentionsKt.i(0), UtilityKotlinExtentionsKt.i(0), UtilityKotlinExtentionsKt.i(8), UtilityKotlinExtentionsKt.i(0));
        goto L42
    L41:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L42:
        r110.observe("cmd_switch_resolution_success", this);
        r110.observe("data_video_resolution_degrade", this);
        r110.observe("data_switch_resolution_by_cast_screen", this);
        View r104 = this.f112615a;
        if (r104 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L45:
        if (r104 == null) goto L170;
        TextView r105 = (TextView) r104;
        r105.setVisibility(0);
        IQuality r106 = null;
        if (((Boolean) this.f112620f.getValue()).booleanValue() == false) goto L60;
        StreamUrl r107 = this.f112624j.getStreamUrl();
        if (r107 == null) goto L57;
        List<IQuality> r108 = r107.getQualityList();
        if (r108 == null) goto L57;
        IQuality r109 = AudienceVideoResolutionManager.d(r108);
        if (r109 == null) goto L55;
        String r111 = r109.getName();
    L56:
        if (r111 == null) goto L57;
    L68:
        if (r111 == null) goto L71;
        r105.setText(r111);
        d(r111);
    L71:
        if (this.f112625k == false) goto L73;
    L76:
        Room r112 = this.f112624j;
        int r113 = com.bytedance.android.livesdk.utils.landscape.d.f159073a;
        if (r112 == null) goto L79;
        boolean r114 = r112.isMediaRoom();
    L80:
        if (r114 == false) goto L82;
    L81:
        r105.setBackgroundResource(0);
    L82:
        this.f112617c = new e(this);
        hd0.c.f().c(this.f112617c);
        CastScreenViewModel.Companion.getClass();
        CastScreenViewModel r115 = CastScreenViewModel.a.b(r110);
        if (r115 == null) goto L92;
        m<Boolean> r116 = r115.getCastOrMirrorScreenMode();
        if (r116 == null) goto L92;
        Observable<Boolean> r117 = r116.a();
        if (r117 == null) goto L92;
        Disposable r118 = r117.subscribe(new f(this, r110));
        if (r118 == null) goto L92;
        RxUtilKt.c(r118, this.f112619e);
    L92:
        if (LiveByteCastUIHelper.k(r110) == true) goto L103;
        CastScreenViewModel r119 = CastScreenViewModel.a.a();
        if (r119 == null) goto L103;
        m<Boolean> r120 = r119.getCastOrMirrorScreenMode();
        if (r120 == null) goto L103;
        if (r120.getValue().booleanValue() != true) goto L103;
        View r121 = this.f112615a;
        if (r121 != null) goto L102;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L102:
        r121.setVisibility(8);
    L103:
        RoomContext r122 = RoomContext.a.c(RoomContext.Companion, r110, 0, 2);
        if (r122 == null) goto L112;
        m<Long> r123 = r122.getCameraId();
        if (r123 == null) goto L112;
        Observable<Long> r124 = r123.a();
        if (r124 == null) goto L112;
        Disposable r125 = r124.subscribe(new g(this, r110));
        if (r125 == null) goto L112;
        RxUtilKt.c(r125, this.f112619e);
    L112:
        LifecycleOwner r126 = r110.lifecycleOwner;
        if (r126 == null) goto L120;
        p0 r127 = (p0) r110.get("zygote_event_hub", null);
        if (r127 == null) goto L117;
        NextLiveData<Boolean> r128 = r127.getSwitchStreamDataEvent();
    L118:
        if (r128 == null) goto L120;
        r128.observe(r126, new d(this));
        goto L120
    L117:
        r128 = null;
    L120:
        b();
        if (this.f112622h == true) goto L137;
        this.f112622h = true;
        IVSPlayerService r129 = (IVSPlayerService) k.f(IVSPlayerService.class);
        if (r129 == null) goto L126;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r130 = r129.provideVSPlayerViewControlService(this.f112616b);
    L127:
        if (r130 == null) goto L137;
        VSPlayerViewControlContext r131 = r130.provideContext();
        if (r131 == null) goto L137;
        m<Boolean> r132 = r131.getPlayerViewVisibleTriggeredByUser();
        if (r132 == null) goto L137;
        Observable<Boolean> r133 = r132.a();
        if (r133 == null) goto L137;
        Observable<Boolean> r134 = r133.filter(com.bytedance.android.livesdk.chatroom.ui.behavior.d.f112653a);
        if (r134 == null) goto L137;
        r134.subscribe(new com.bytedance.android.livesdk.chatroom.ui.behavior.e(this));
        goto L137
    L126:
        r130 = null;
    L137:
        int r135 = AudienceVideoResolutionManager.f110411a;
        if (((Boolean) this.f112620f.getValue()).booleanValue() == false) goto L148;
        StreamUrl r136 = this.f112624j.getStreamUrl();
        if (r136 == null) goto L145;
        List<IQuality> r137 = r136.getQualityList();
        if (r137 == null) goto L145;
        IQuality r138 = AudienceVideoResolutionManager.d(r137);
        if (r138 == null) goto L145;
    L150:
        r106 = r138;
    L154:
        AudienceVideoResolutionManager.r(r106, "icon");
        View r139 = this.f112615a;
        if (r139 != null) goto L157;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L157:
        View r140 = this.f112615a;
        if (r140 != null) goto L160;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L160:
        if (r140 == null) goto L168;
        CharSequence r141 = ((TextView) r140).getText();
        if (r141 == null) goto L165;
        String r142 = r141.toString();
        if (r142 == null) goto L165;
    L166:
        r3.c(r139, r142, true);
        return;
    L165:
        r142 = "";
        goto L166
    L168:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L145:
        StreamUrl r143 = this.f112624j.getStreamUrl();
        if (r143 == null) goto L154;
        r106 = r143.getMultiDefaultQuality();
        goto L154
    L148:
        r138 = AudienceVideoResolutionManager.c();
        if (r138 != null) goto L150;
        StreamUrl r144 = this.f112624j.getStreamUrl();
        if (r144 == null) goto L154;
        r106 = r144.getMultiDefaultQuality();
        goto L154
    L79:
        r114 = false;
        goto L80
    L73:
        if (com.bytedance.android.livesdk.utils.landscape.d.c(r110) == true) goto L81;
        if (VSMediaUIConfigHelper.b(r110) == true) goto L81;
    L55:
        r111 = null;
    L57:
        StreamUrl r145 = this.f112624j.getStreamUrl();
        if (r145 == null) goto L67;
        r111 = r145.getDefaultQuality();
    L67:
        r111 = null;
        goto L68
    L60:
        LiveCoreSDKData.Quality r146 = AudienceVideoResolutionManager.c();
        if (r146 == null) goto L64;
        r111 = r146.getName();
        if (r111 != null) goto L68;
    L64:
        StreamUrl r147 = this.f112624j.getStreamUrl();
        if (r147 == null) goto L67;
        r111 = r147.getDefaultQuality();
        goto L68
    L170:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L12:
        if (VSMediaUIConfigHelper.b(r110) == true) goto L30;
        if (m50.f120732a.getValue().a() == false) goto L42;
        if (this.f112624j.isMediaRoom() == true) goto L42;
        View r148 = this.f112615a;
        if (r148 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L22:
        if ((r148 instanceof TextView) == false) goto L42;
        View r149 = this.f112615a;
        if (r149 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L26:
        if (r149 == null) goto L29;
        ((TextView) r149).setPadding(UtilityKotlinExtentionsKt.i(0), UtilityKotlinExtentionsKt.i(0), UtilityKotlinExtentionsKt.i(0), UtilityKotlinExtentionsKt.i(0));
        goto L42
    L29:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.bytedance.android.livesdk.chatroom.ui.behavior.ToolbarVideoQualityBehavior$observer$1] */
    public ToolbarVideoQualityBehavior(Context r100, Room r101, boolean r102, View.OnClickListener r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "mRoom");
        Intrinsics.checkNotNullParameter(r103, "onClickListener");
        this.f112623i = r100;
        this.f112624j = r101;
        this.f112625k = r102;
        this.f112626l = r103;
        this.f112619e = new CompositeDisposable();
        this.f112620f = LazyKt.lazy(ToolbarVideoQualityBehavior$landscapeQualityToolbarFixEnable$2.INSTANCE);
        this.f112621g = new ToolbarVideoQualityBehavior$observer$1(this);
    }
}

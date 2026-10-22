package com.bytedance.android.livesdk.gift.platform.core.ui.configuration.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.r0;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import com.bytedance.android.livesdk.gift.model.a0;
import com.bytedance.android.livesdk.gift.model.c0;
import com.bytedance.android.livesdk.gift.model.x3;
import com.bytedance.android.livesdk.gift.model.y3;
import com.bytedance.android.livesdk.gift.platform.core.ui.configuration.ClickType;
import com.bytedance.android.livesdk.gift.platform.core.ui.configuration.p;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.scope.m;
import com.ss.texturerender.TextureRenderKeys;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import mz0.n;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b4\u00105J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002J \u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00022\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nJ\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u0004J \u0010\u000f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00022\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nJ\u001c\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012J!\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0014R\u001b\u0010\u001d\u001a\u00060\u001bj\u0002`\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\"\u0010#\u001a\u0010\u0012\f\u0012\n \"*\u0004\u0018\u00010\u00020\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\"\u0010%\u001a\u0010\u0012\f\u0012\n \"*\u0004\u0018\u00010\u00020\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010$R\"\u0010&\u001a\u0010\u0012\f\u0012\n \"*\u0004\u0018\u00010\u00020\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010$R\u0016\u0010'\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010(R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0017\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00020,8F¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0017\u00101\u001a\b\u0012\u0004\u0012\u00020\u00020,8F¢\u0006\u0006\u001a\u0004\b0\u0010.R\u0017\u00103\u001a\b\u0012\u0004\u0012\u00020\u00020,8F¢\u0006\u0006\u001a\u0004\b2\u0010.¨\u00066"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/ui/configuration/viewmodel/GiftEffectConfigurationViewModelForAnchor;", "Landroidx/lifecycle/ViewModel;", "", "isBeforeLive", "", "setIsBeforeLive", "updateStickerEffectStatus", "newStatus", "uploadChangeStatus", "switch", "Lkotlin/Function0;", "onSuccessAction", "updateGameEffectSwitch", "getGameEffectSwitch", "getRoleSkillEffectSwitch", "updateRoleSkillEffectSwitch", "", TextureRenderKeys.KEY_MODULE_NAME, "Lcom/bytedance/android/livesdk/gift/platform/core/ui/configuration/ClickType;", "clickType", "logAnchorConfigDialogShow", "switchStatus", "logConfigDialogClick", "(Lcom/bytedance/android/livesdk/gift/platform/core/ui/configuration/ClickType;Ljava/lang/Boolean;)V", "result", "logConfigSetResult", "onCleared", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/revenue/platform/api/core/rx/CompositeDisposable;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "getCompositeDisposable", "()Lio/reactivex/disposables/CompositeDisposable;", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "_stickerEffectSwitchStatus", "Landroidx/lifecycle/MutableLiveData;", "_gameEffectSwitchStatus", "_roleSkillEffectSwitchStatus", "hasManualChangeRoleSkillEffectStatus", "Z", "Lp12/c;", "giftEffectRepo", "Lp12/c;", "Landroidx/lifecycle/LiveData;", "getStickerEffectSwitchStatus", "()Landroidx/lifecycle/LiveData;", "stickerEffectSwitchStatus", "getGameEffectSwitchStatus", "gameEffectSwitchStatus", "getRoleSkillEffectSwitchStatus", "roleSkillEffectSwitchStatus", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftEffectConfigurationViewModelForAnchor extends ViewModel {
    private final MutableLiveData<Boolean> _gameEffectSwitchStatus;
    private final MutableLiveData<Boolean> _roleSkillEffectSwitchStatus;
    private final MutableLiveData<Boolean> _stickerEffectSwitchStatus;
    private final CompositeDisposable compositeDisposable;
    private final p12.c giftEffectRepo;
    private boolean hasManualChangeRoleSkillEffectStatus;
    private boolean isBeforeLive;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GiftEffectConfigurationViewModelForAnchor f131990a;

        public a(GiftEffectConfigurationViewModelForAnchor r100) {
            this.f131990a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            boolean r101 = !((a0) r100).getForbiddenSwitch();
            ay1.d.e(r101);
            GiftEffectConfigurationViewModelForAnchor.access$get_gameEffectSwitchStatus$p(this.f131990a).setValue(Boolean.valueOf(r101));
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f131991a = null;

        static {
            f131991a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GiftEffectConfigurationViewModelForAnchor f131992a;

        public c(GiftEffectConfigurationViewModelForAnchor r100) {
            this.f131992a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            c0 r101 = (c0) r100;
            if (GiftEffectConfigurationViewModelForAnchor.access$getHasManualChangeRoleSkillEffectStatus$p(this.f131992a) == true) goto L7;
            boolean r102 = r101.getEffectSwitchStatus();
            ay1.d.f(r102);
            GiftEffectConfigurationViewModelForAnchor.access$get_roleSkillEffectSwitchStatus$p(this.f131992a).setValue(Boolean.valueOf(r102));
            return;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f131993a = null;

        static {
            f131993a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GiftEffectConfigurationViewModelForAnchor f131994a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0 f131995b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f131996c;

        public e(GiftEffectConfigurationViewModelForAnchor r100, Function0 r101, boolean r102) {
            this.f131994a = r100;
            this.f131995b = r101;
            this.f131996c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            boolean r101 = !((x3) r100).getForbiddenSwitch();
            ay1.d.e(r101);
            GiftEffectConfigurationViewModelForAnchor.access$get_gameEffectSwitchStatus$p(this.f131994a).setValue(Boolean.valueOf(r101));
            Function0 r102 = this.f131995b;
            if (r102 == null) goto L5;
            Unit r103 = (Unit) r102.invoke();
        L5:
            this.f131994a.logConfigSetResult(ClickType.EffectGame, this.f131996c, true);
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GiftEffectConfigurationViewModelForAnchor f131997a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f131998b;

        public f(GiftEffectConfigurationViewModelForAnchor r100, boolean r101) {
            this.f131997a = r100;
            this.f131998b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            ay1.d.e(!this.f131998b);
            GiftEffectConfigurationViewModelForAnchor.access$get_gameEffectSwitchStatus$p(this.f131997a).setValue(Boolean.valueOf(!this.f131998b));
            this.f131997a.logConfigSetResult(ClickType.EffectGame, this.f131998b, false);
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GiftEffectConfigurationViewModelForAnchor f131999a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f132000b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function0 f132001c;

        public g(GiftEffectConfigurationViewModelForAnchor r100, boolean r101, Function0 r102) {
            this.f131999a = r100;
            this.f132000b = r101;
            this.f132001c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            y3 r101 = (y3) r100;
            if (GiftEffectConfigurationViewModelForAnchor.access$getHasManualChangeRoleSkillEffectStatus$p(this.f131999a) == true) goto L5;
            GiftEffectConfigurationViewModelForAnchor.access$setHasManualChangeRoleSkillEffectStatus$p(this.f131999a, true);
        L5:
            ay1.d.f(this.f132000b);
            GiftEffectConfigurationViewModelForAnchor.access$get_roleSkillEffectSwitchStatus$p(this.f131999a).setValue(Boolean.valueOf(this.f132000b));
            Function0 r102 = this.f132001c;
            if (r102 == null) goto L8;
            Unit r103 = (Unit) r102.invoke();
        L8:
            this.f131999a.logConfigSetResult(ClickType.RoleSkill, this.f132000b, true);
        }
    }

    public static final class h<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GiftEffectConfigurationViewModelForAnchor f132002a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f132003b;

        public h(GiftEffectConfigurationViewModelForAnchor r100, boolean r101) {
            this.f132002a = r100;
            this.f132003b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            ay1.d.f(!this.f132003b);
            GiftEffectConfigurationViewModelForAnchor.access$get_roleSkillEffectSwitchStatus$p(this.f132002a).setValue(Boolean.valueOf(!this.f132003b));
            this.f132002a.logConfigSetResult(ClickType.RoleSkill, this.f132003b, false);
        }
    }

    public static final class i<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GiftEffectConfigurationViewModelForAnchor f132004a;

        public i(GiftEffectConfigurationViewModelForAnchor r100) {
            this.f132004a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            if (((r0) ((com.bytedance.android.live.network.response.e) r100).data).faceGiftSwitch == 2) goto L5;
            boolean r101 = true;
        L6:
            ay1.d.g(r101);
            GiftEffectConfigurationViewModelForAnchor.access$get_stickerEffectSwitchStatus$p(this.f132004a).setValue(Boolean.valueOf(r101));
            return;
        L5:
            r101 = false;
            goto L6
        }
    }

    public static final class j<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f132005a = null;

        static {
            f132005a = new j();
        }

        public j() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    public static final class k<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GiftEffectConfigurationViewModelForAnchor f132006a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f132007b;

        public k(GiftEffectConfigurationViewModelForAnchor r100, boolean r101) {
            this.f132006a = r100;
            this.f132007b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
            this.f132006a.logConfigSetResult(ClickType.StickerGiftEffectSwitch, this.f132007b, true);
        }
    }

    public static final class l<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GiftEffectConfigurationViewModelForAnchor f132008a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f132009b;

        public l(GiftEffectConfigurationViewModelForAnchor r100, boolean r101) {
            this.f132008a = r100;
            this.f132009b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            ay1.d.g(!this.f132009b);
            GiftEffectConfigurationViewModelForAnchor.access$get_stickerEffectSwitchStatus$p(this.f132008a).setValue(Boolean.valueOf(!this.f132009b));
            this.f132008a.logConfigSetResult(ClickType.StickerGiftEffectSwitch, this.f132009b, false);
        }
    }

    public final void getGameEffectSwitch() {
        yz0.k r100 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r100 == null) goto L11;
        IRoom r101 = r100.getRoom();
        if (r101 == null) goto L12;
        String r102 = r101.getIdStr();
        if (r102 == null) goto L13;
        this.giftEffectRepo.getClass();
        Intrinsics.checkNotNullParameter(r102, "roomId");
        tz0.b r103 = tz0.b.f548039a;
        uz0.c r104 = new uz0.c();
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "$this$beforeConfigureRequest");
        Map<String, String> r105 = r104.f552161b;
        Intrinsics.checkNotNullParameter(r105, "queriesMap");
        Intrinsics.checkNotNullParameter("room_id", "$this$setTo");
        r105.put("room_id", r102);
        Intrinsics.checkNotNullParameter(r104, "$this$afterConfigureRequest");
        com.bytedance.revenue.platform.api.core.rx.f.a(((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/gift/effect_game/get_config/", TypesJVMKt.getJavaType(Reflection.typeOf(a0.class)), Extra.class, r104.f552163d, r104.f552160a, r104.f552161b, r104.f552162c).map(p12.a.f527317a).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this), b.f131991a), this.compositeDisposable);
        return;
    L13:
        return;
    L12:
        return;
    }

    public final void getRoleSkillEffectSwitch() {
        String r100 = ((com.bytedance.android.livesdk.revenue.service.user.a) vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class)).getCurrentUserId();
        this.giftEffectRepo.getClass();
        Intrinsics.checkNotNullParameter(r100, "userId");
        tz0.b r101 = tz0.b.f548039a;
        uz0.c r102 = new uz0.c();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "$this$beforeConfigureRequest");
        Map<String, String> r103 = r102.f552161b;
        Intrinsics.checkNotNullParameter(r103, "queriesMap");
        Intrinsics.checkNotNullParameter("target_user_id", "$this$setTo");
        if (r100 == null) goto L5;
        r103.put("target_user_id", r100);
    L5:
        Intrinsics.checkNotNullParameter(r102, "$this$afterConfigureRequest");
        com.bytedance.revenue.platform.api.core.rx.f.a(((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/rare_gift/effect_switch/get/", TypesJVMKt.getJavaType(Reflection.typeOf(c0.class)), Extra.class, r102.f552163d, r102.f552160a, r102.f552161b, r102.f552162c).map(p12.b.f527318a).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this), d.f131993a), this.compositeDisposable);
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.compositeDisposable.dispose();
        super.onCleared();
    }

    public final void updateStickerEffectStatus() {
        IBaseUser r100 = ((com.bytedance.android.livesdk.revenue.service.user.a) vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class)).b();
        if (r100 != null) goto L5;
        return;
    L5:
        String r101 = r100.getIdString();
        Intrinsics.checkNotNullParameter(r100, "$this$secUidExt");
        String r102 = r100.getCastSecUid();
        ds2.a r103 = (ds2.a) vh6.c.b(ds2.a.class);
        if (this.isBeforeLive == false) goto L8;
        String r104 = "start_live";
    L9:
        Disposable r105 = r103.queryAnchorStickerStatus(r101, r102, r104).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new i(this), j.f132005a);
        if (r105 != null) goto L12;
        return;
    L12:
        this.compositeDisposable.add(r105);
        return;
    L8:
        r104 = null;
        goto L9
    }

    public GiftEffectConfigurationViewModelForAnchor() {
        this.compositeDisposable = new CompositeDisposable();
        this._stickerEffectSwitchStatus = new MutableLiveData(Boolean.valueOf(ay1.d.d()));
        this._gameEffectSwitchStatus = new MutableLiveData(Boolean.valueOf(ay1.d.a()));
        this._roleSkillEffectSwitchStatus = new MutableLiveData(Boolean.valueOf(ay1.d.c()));
        this.giftEffectRepo = new p12.c();
    }

    public final CompositeDisposable getCompositeDisposable() {
        return this.compositeDisposable;
    }

    public final LiveData<Boolean> getGameEffectSwitchStatus() {
        return this._gameEffectSwitchStatus;
    }

    public final LiveData<Boolean> getRoleSkillEffectSwitchStatus() {
        return this._roleSkillEffectSwitchStatus;
    }

    public final LiveData<Boolean> getStickerEffectSwitchStatus() {
        return this._stickerEffectSwitchStatus;
    }

    public final boolean isBeforeLive() {
        return this.isBeforeLive;
    }

    public static final /* synthetic */ boolean access$getHasManualChangeRoleSkillEffectStatus$p(GiftEffectConfigurationViewModelForAnchor r100) {
        return r100.hasManualChangeRoleSkillEffectStatus;
    }

    public static final /* synthetic */ MutableLiveData access$get_gameEffectSwitchStatus$p(GiftEffectConfigurationViewModelForAnchor r100) {
        return r100._gameEffectSwitchStatus;
    }

    public static final /* synthetic */ MutableLiveData access$get_roleSkillEffectSwitchStatus$p(GiftEffectConfigurationViewModelForAnchor r100) {
        return r100._roleSkillEffectSwitchStatus;
    }

    public static final /* synthetic */ MutableLiveData access$get_stickerEffectSwitchStatus$p(GiftEffectConfigurationViewModelForAnchor r100) {
        return r100._stickerEffectSwitchStatus;
    }

    public final void setIsBeforeLive(boolean r100) {
        this.isBeforeLive = r100;
    }

    public final void uploadChangeStatus(boolean r100) {
        Disposable r101 = ((ds2.a) vh6.c.b(ds2.a.class)).uploadAnchorStickerStatus(r100, this.isBeforeLive).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new k(this, r100), new l(this, r100));
        if (r101 != null) goto L5;
        return;
    L5:
        this.compositeDisposable.add(r101);
    }

    public static final /* synthetic */ void access$setHasManualChangeRoleSkillEffectStatus$p(GiftEffectConfigurationViewModelForAnchor r100, boolean r101) {
        r100.hasManualChangeRoleSkillEffectStatus = r101;
    }

    public final void logAnchorConfigDialogShow(String r100, ClickType r101) {
        Intrinsics.checkNotNullParameter(r100, TextureRenderKeys.KEY_MODULE_NAME);
        int r102 = p.f131989a;
        Intrinsics.checkNotNullParameter(r100, TextureRenderKeys.KEY_MODULE_NAME);
        n r103 = new n();
        p.a(r103);
        Map<String, String> r104 = r103.f516447a;
        Intrinsics.checkNotNullParameter(r104, "map");
        Map<? extends String, ? extends String> r105 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("module_name", r100)});
        if (r101 == null) goto L5;
        r105.put("gift_type", r101.getValue());
    L5:
        Intrinsics.checkNotNullParameter(r105, "map");
        r104.putAll(r105);
        cy0.e.f465759a.getClass();
        cy0.j r106 = cy0.e.a.f465760a;
        m.f163449e.getClass();
        Object r107 = m.b(r106).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r107);
        ((mz0.i) ((f80.a) r107)).w3("livesdk_anchor_gift_effects_setting_popup_show", r103.f516447a, r103.f516448b);
    }

    public final void logConfigDialogClick(ClickType r100, Boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "clickType");
        p.b(r100, r101);
    }

    public final void updateGameEffectSwitch(boolean r100, Function0<Unit> r101) {
        yz0.k r102 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r102 == null) goto L7;
        IRoom r103 = r102.getRoom();
        if (r103 == null) goto L7;
        String r104 = r103.getIdStr();
    L9:
        if (r104 != null) goto L11;
    L14:
        boolean r105 = true;
    L15:
        if (r105 == false) goto L18;
        logConfigSetResult(ClickType.EffectGame, r100, true);
        return;
    L18:
        this.giftEffectRepo.getClass();
        com.bytedance.revenue.platform.api.core.rx.f.a(p12.c.a(r104, !r100).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this, r101, r100), new f(this, r100)), this.compositeDisposable);
        return;
    L11:
        if (r104.length() == 0) goto L14;
        r105 = false;
    L7:
        r104 = null;
        goto L9
    }

    public final void updateRoleSkillEffectSwitch(boolean r110, Function0<Unit> r111) {
        String r100 = ((com.bytedance.android.livesdk.revenue.service.user.a) vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class)).getCurrentUserId();
        int r101 = !r110 ? 1 : 0;
        this.giftEffectRepo.getClass();
        Intrinsics.checkNotNullParameter(r100, "userId");
        tz0.b r102 = tz0.b.f548039a;
        uz0.e r103 = new uz0.e();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "$this$beforeConfigureRequest");
        Map<String, String> r104 = r103.f552161b;
        Intrinsics.checkNotNullParameter(r104, "queriesMap");
        Intrinsics.checkNotNullParameter("target_user_id", "$this$setTo");
        if (r100 == null) goto L5;
        r104.put("target_user_id", r100);
    L5:
        String r105 = Integer.valueOf(r101).toString();
        Intrinsics.checkNotNullParameter("effect_switcher", "$this$setTo");
        if (r105 == null) goto L8;
        r104.put("effect_switcher", r105);
    L8:
        Intrinsics.checkNotNullParameter(r103, "$this$afterConfigureRequest");
        com.bytedance.revenue.platform.api.core.rx.f.a(((INetworkService) com.bytedance.android.live.revenue.core.util.f.a(INetworkService.class)).L4(INetworkService.Biz.Revenue, "/webcast/rare_gift/effect_switch/set/", TypesJVMKt.getJavaType(Reflection.typeOf(y3.class)), Extra.class, r103.f552163d, r103.f552160a, r103.f552161b, r103.f552162c, r103.f552166e, r103.f552167f, r103.f552168g).map(p12.d.f527320a).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new g(this, r110, r111), new h(this, r110)), this.compositeDisposable);
    }

    public final void logConfigSetResult(ClickType r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "clickType");
        p.c(r100, r101, r102);
    }

    public static /* synthetic */ void logAnchorConfigDialogShow$default(GiftEffectConfigurationViewModelForAnchor r100, String r101, ClickType r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = "set";
    L6:
        if ((r103 & 2) == 0) goto L8;
        r102 = null;
    L8:
        r100.logAnchorConfigDialogShow(r101, r102);
    }

    public static /* synthetic */ void logConfigDialogClick$default(GiftEffectConfigurationViewModelForAnchor r100, ClickType r101, Boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        r100.logConfigDialogClick(r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateGameEffectSwitch$default(GiftEffectConfigurationViewModelForAnchor r100, boolean r101, Function0 r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        r100.updateGameEffectSwitch(r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateRoleSkillEffectSwitch$default(GiftEffectConfigurationViewModelForAnchor r100, boolean r101, Function0 r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        r100.updateRoleSkillEffectSwitch(r101, r102);
    }
}

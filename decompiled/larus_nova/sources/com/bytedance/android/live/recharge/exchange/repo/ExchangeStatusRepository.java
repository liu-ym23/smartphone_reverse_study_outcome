package com.bytedance.android.live.recharge.exchange.repo;

import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.recharge.exchange.model.AutoExchangeStatus;
import com.bytedance.android.live.recharge.exchange.model.GetAutoExchangeStatusResult;
import com.bytedance.android.live.recharge.exchange.model.ReqFrom;
import com.bytedance.android.live.revenue.common.v;
import com.bytedance.android.live.revenue.common.x;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.platform.network.api.INetworkService;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u0005J\u0018\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\u0005J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\f\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000eJ\b\u0010\u0014\u001a\u00020\u000eH\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/recharge/exchange/repo/ExchangeStatusRepository;", "Landroidx/lifecycle/ViewModel;", "()V", "_switchStatus", "Lcom/bytedance/android/live/core/arch/mvvm/PropertyOwner;", "", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "switchObserver", "Lio/reactivex/Observable;", "curVal", "fetchExchangeStatus", "reqFrom", "isAlreadySync", "", "release", "", "syncExchangeStatus", "enable", "updateExchangeStatus", "userLogin", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ExchangeStatusRepository extends ViewModel {
    private final PropertyOwner<Integer> _switchStatus;

    /* JADX INFO: renamed from: cd, reason: collision with root package name */
    private final CompositeDisposable f89867cd;
    private final Observable<Integer> switchObserver;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExchangeStatusRepository f89868a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f89869b;

        public a(ExchangeStatusRepository r100, int r101) {
            this.f89868a = r100;
            this.f89869b = r101;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ExchangeStatusRepository.access$get_switchStatus$p(this.f89868a).a(Integer.valueOf(((GetAutoExchangeStatusResult) ((ExtraResponse) r100).data).getSwitchStatus()));
            if (((Number) ExchangeStatusRepository.access$get_switchStatus$p(this.f89868a).f64752a).intValue() != AutoExchangeStatus.UnSync.getValue()) goto L7;
            int r101 = this.f89869b;
            ReqFrom r102 = ReqFrom.GiftPanel;
            if (r101 != r102.getValue()) goto L7;
            this.f89868a.syncExchangeStatus(r102.getValue(), com.bytedance.android.live.recharge.util.d.a());
        L7:
            int r103 = v.f91009a;
            v.e("ttlive_exchange", "fetchExchangeStatus success,status: " + ((Number) ExchangeStatusRepository.access$get_switchStatus$p(this.f89868a).f64752a).intValue() + ' ');
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f89870a = null;

        static {
            f89870a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            int r101 = v.f91009a;
            v.b("ttlive_exchange", "fetchExchangeStatus fail,throwable: " + ((Throwable) r100) + ' ', null);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExchangeStatusRepository f89871a;

        public c(ExchangeStatusRepository r100) {
            this.f89871a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            CompositeDisposable r101 = ExchangeStatusRepository.access$getCd$p(this.f89871a);
            r101.add((Disposable) r100);
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExchangeStatusRepository f89872a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f89873b;

        public d(ExchangeStatusRepository r100, boolean r101) {
            this.f89872a = r100;
            this.f89873b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ExtraResponse r101 = (ExtraResponse) r100;
            PropertyOwner r102 = ExchangeStatusRepository.access$get_switchStatus$p(this.f89872a);
            if (this.f89873b == false) goto L5;
            AutoExchangeStatus r103 = AutoExchangeStatus.Open;
        L6:
            r102.a(Integer.valueOf(r103.getValue()));
            return;
        L5:
            r103 = AutoExchangeStatus.Closed;
            goto L6
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f89874a = null;

        static {
            f89874a = new e();
        }

        public e() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            int r101 = v.f91009a;
            v.b("ttlive_exchange", "syncExchangeStatus fail,throwable: " + ((Throwable) r100) + ' ', null);
        }
    }

    private final boolean userLogin() {
        return ((l01.d) f.a(l01.d.class)).isLogin();
    }

    public final int curVal() {
        return this._switchStatus.f64752a.intValue();
    }

    public final boolean isAlreadySync() {
        if (this._switchStatus.f64752a.intValue() != AutoExchangeStatus.Open.getValue()) goto L5;
    L8:
        return true;
    L5:
        if (this._switchStatus.f64752a.intValue() == AutoExchangeStatus.Closed.getValue()) goto L8;
        return false;
    }

    public final void release() {
        this.f89867cd.clear();
    }

    public ExchangeStatusRepository() {
        this.f89867cd = new CompositeDisposable();
        PropertyOwner<Integer> r100 = new PropertyOwner(Integer.valueOf(AutoExchangeStatus.UnKnown.getValue()));
        this._switchStatus = r100;
        this.switchObserver = r100.doOnSubscribe(new c(this));
    }

    public static final /* synthetic */ CompositeDisposable access$getCd$p(ExchangeStatusRepository r100) {
        return r100.f89867cd;
    }

    public static final /* synthetic */ PropertyOwner access$get_switchStatus$p(ExchangeStatusRepository r100) {
        return r100._switchStatus;
    }

    public final Observable<Integer> fetchExchangeStatus(int r110) {
        if (userLogin() == true) goto L6;
        return null;
    L6:
        tz0.b r100 = tz0.b.f548039a;
        uz0.c r101 = new uz0.c();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "$this$beforeConfigureRequest");
        Intrinsics.checkNotNullParameter(r101, "$this$afterConfigureRequest");
        RxUtilKt.c(((INetworkService) f.a(INetworkService.class)).x0(INetworkService.Biz.Revenue, "/webcast/growth/income_exchange/get_auto_exchange_status/", TypesJVMKt.getJavaType(Reflection.typeOf(GetAutoExchangeStatusResult.class)), Extra.class, r101.f552163d, r101.f552160a, r101.f552161b, r101.f552162c).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(this, r110), b.f89870a), this.f89867cd);
        return this.switchObserver;
    }

    public final void updateExchangeStatus(boolean r100) {
        PropertyOwner<Integer> r101 = this._switchStatus;
        if (r100 == false) goto L5;
        AutoExchangeStatus r102 = AutoExchangeStatus.Open;
    L6:
        r101.a(Integer.valueOf(r102.getValue()));
        return;
    L5:
        r102 = AutoExchangeStatus.Closed;
        goto L6
    }

    public final void syncExchangeStatus(int r110, boolean r111) {
        if (userLogin() == true) goto L5;
        return;
    L5:
        tz0.b r100 = tz0.b.f548039a;
        uz0.e r101 = new uz0.e();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "$this$beforeConfigureRequest");
        Map<String, String> r102 = r101.f552161b;
        Intrinsics.checkNotNullParameter(r102, "queriesMap");
        String r112 = Integer.valueOf(r110).toString();
        Intrinsics.checkNotNullParameter("req_from", "$this$setTo");
        if (r112 == null) goto L8;
        r102.put("req_from", r112);
    L8:
        if (r111 == false) goto L10;
        AutoExchangeStatus r113 = AutoExchangeStatus.Open;
    L11:
        String r114 = Integer.valueOf(r113.getValue()).toString();
        Intrinsics.checkNotNullParameter("status", "$this$setTo");
        if (r114 == null) goto L14;
        r102.put("status", r114);
    L14:
        x.a(r101, false);
        Intrinsics.checkNotNullParameter(r101, "$this$afterConfigureRequest");
        RxUtilKt.c(((INetworkService) f.a(INetworkService.class)).L4(INetworkService.Biz.Revenue, "/webcast/growth/income_exchange/set_auto_exchange_status/", TypesJVMKt.getJavaType(Reflection.typeOf(com.bytedance.android.live.network.response.a.class)), Extra.class, r101.f552163d, r101.f552160a, r101.f552161b, r101.f552162c, r101.f552166e, r101.f552167f, r101.f552168g).compose(RxUtil.rxSchedulerHelper()).subscribe(new d(this, r111), e.f89874a), this.f89867cd);
        return;
    L10:
        r113 = AutoExchangeStatus.Closed;
        goto L11
    }

    public static /* synthetic */ Observable fetchExchangeStatus$default(ExchangeStatusRepository r100, int r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = ReqFrom.UnKnown.getValue();
    L6:
        return r100.fetchExchangeStatus(r101);
    }

    public static /* synthetic */ void syncExchangeStatus$default(ExchangeStatusRepository r100, int r101, boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L5;
        r101 = ReqFrom.UnKnown.getValue();
    L5:
        r100.syncExchangeStatus(r101, r102);
    }
}

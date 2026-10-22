package com.bytedance.android.livesdk.livecommerce.broadcast.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdk.livecommerce.base.ECBaseViewModel;
import com.bytedance.android.livesdk.livecommerce.broadcast.bindcoupon.ui.ECBindCouponFragment;
import com.bytedance.android.livesdk.livecommerce.broadcast.viewbinder.LiveRoomNewCouponViewBinder;
import com.bytedance.android.livesdk.livecommerce.event.c2;
import com.bytedance.android.livesdk.livecommerce.event.w1;
import com.bytedance.android.livesdk.livecommerce.event.x1;
import com.bytedance.android.livesdk.livecommerce.multitype.MultiTypeAdapter;
import com.bytedance.android.livesdk.livecommerce.room.controller.CoreRequests;
import com.bytedance.android.livesdk.livecommerce.utils.k;
import com.bytedance.android.livesdk.livecommerce.utils.x;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import sg2.h;
import si2.g;
import si2.p;
import vi2.m;
import vi2.v0;
import xi2.l;
import xi2.n;
import xi2.r;

/* JADX INFO: loaded from: classes10.dex */
public class LiveRoomCouponListViewModel extends ECBaseViewModel implements dh2.a.InterfaceC5668a, com.bytedance.android.livesdk.livecommerce.view.countdown.e.a, LiveRoomNewCouponViewBinder.a {
    public static final int MSG_DISMISS_END_COUPON_GUIDE = 2;
    public static final int MSG_DISMISS_FUNCTION_GUIDE = 1;
    private MutableLiveData<Pair<Integer, Integer>> mAdapterAppendData;
    private MutableLiveData<Void> mAdapterChangeData;
    private String mAnchorId;
    private dh2.a mBindCouponManager;
    private WeakReference<Context> mContextWeakReference;
    private String mCouponBindNotice;
    private String mCouponCipherText;
    private ch2.a mCouponDataHelper;
    private MutableLiveData<String> mCouponDetailGuideData;
    private String mCouponExplain;
    private int mCurrentPage;
    private MutableLiveData<Void> mDismissFunctionGuideData;
    private MutableLiveData<p> mDistributeCouponData;
    private h mDistributeCouponManager;
    private v0<xi2.p> mDistributeCouponResponseIApiObserver;
    private MutableLiveData<xi2.p> mDistributeResponse;
    private MutableLiveData<View> mEndCouponGuideData;
    private String mEndCouponHint;
    private String mEndCouponToast;
    private v0<r> mEndDistributeCouponResponseIApiObserver;
    private String mEnterFrom;
    private MutableLiveData<Void> mFullLoadingData;
    private MutableLiveData<Void> mFullLoadingFinishData;
    private boolean mHasMore;
    private String mRoomId;
    private MutableLiveData<Integer> mScrollData;
    private long mStartDistributeTime;
    private String mWillDistributeCouponId;

    public class a implements v0<n> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f147696a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LiveRoomCouponListViewModel f147697b;

        @Override // vi2.v0
        public final void onError(Throwable r100) {
            LiveRoomCouponListFragment r101 = ((com.bytedance.android.livesdk.livecommerce.broadcast.ui.a) this.f147696a).f147702a.f147703a;
            r101.f147690r.setText(th.a.g(r101.getContext(), R.string.ec_search_no_more));
        }

        @Override // vi2.v0
        public final void onSuccess(n r100) {
            n r101 = r100;
            if (r101.statusCode != 0) goto L13;
            LiveRoomCouponListViewModel.access$002(this.f147697b, r101.hasMore);
            LiveRoomCouponListViewModel.access$102(this.f147697b, r101.page + 1);
            int r102 = ((ArrayList) LiveRoomCouponListViewModel.access$200(this.f147697b).f23758a).size();
            ch2.a r103 = LiveRoomCouponListViewModel.access$200(this.f147697b);
            r103.getClass();
            List<l> r104 = r101.couponList;
            if (r104 == null) goto L10;
            Iterator<l> r105 = r104.iterator();
        L8:
            if (r105.hasNext() == false) goto L10;
            p r106 = k.b(r105.next());
            ((ArrayList) r103.f23758a).add(r106);
        L10:
            int r107 = r101.couponList.size();
            this.f147697b.getAdapterAppendData().postValue(new Pair(Integer.valueOf(r102), Integer.valueOf(r107)));
            LiveRoomCouponListFragment r108 = ((com.bytedance.android.livesdk.livecommerce.broadcast.ui.a) this.f147696a).f147702a.f147703a;
            r108.f147690r.setText(th.a.g(r108.getContext(), R.string.ec_search_no_more));
            return;
        }

        public a(LiveRoomCouponListViewModel r100, f r101) {
            this.f147697b = r100;
            this.f147696a = r101;
        }
    }

    public class b implements v0<n> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveRoomCouponListViewModel f147698a;

        public b(LiveRoomCouponListViewModel r100) {
            this.f147698a = r100;
        }

        @Override // vi2.v0
        public final void onError(Throwable r100) {
            this.f147698a.getLoadingErrorData().postValue(null);
        }

        @Override // vi2.v0
        public final void onSuccess(n r100) {
            n r101 = r100;
            int r102 = r101.statusCode;
            if (r102 != 0) goto L36;
            n.a r103 = r101.extra;
            if (r103 == null) goto L7;
            LiveRoomCouponListViewModel.access$302(this.f147698a, r103.couponBindNotice);
            LiveRoomCouponListViewModel.access$402(this.f147698a, r101.extra.couponCipherText);
            LiveRoomCouponListViewModel.access$502(this.f147698a, r101.extra.endCouponToast);
            LiveRoomCouponListViewModel.access$602(this.f147698a, r101.extra.endCouponNotice);
        L7:
            LiveRoomCouponListViewModel.access$002(this.f147698a, r101.hasMore);
            boolean r104 = true;
            LiveRoomCouponListViewModel.access$102(this.f147698a, r101.page + 1);
            LiveRoomCouponListViewModel.access$702(this.f147698a, r101.couponExplain);
            LiveRoomCouponListViewModel.access$200(this.f147698a).a(r101);
            this.f147698a.getAdapterChangeData().postValue(null);
            this.f147698a.getLoadingFinishData().postValue(null);
            if (LiveRoomCouponListViewModel.access$800(this.f147698a) == null) goto L30;
            Context r105 = (Context) LiveRoomCouponListViewModel.access$800(this.f147698a).get();
            if (r105 == null) goto L30;
            SharedPreferences r106 = x.b(r105);
            if (r106 != null) goto L14;
        L16:
            boolean r107 = false;
        L17:
            if (r107 == true) goto L30;
            n.a r108 = r101.extra;
            if (r108 == null) goto L30;
            if (TextUtils.isEmpty(r108.couponDetailNotice) == true) goto L30;
            this.f147698a.getCouponDetailGuideData().postValue(r101.extra.couponDetailNotice);
            SharedPreferences r109 = x.b(r105);
            if (r109 == null) goto L30;
            if (TextUtils.isEmpty("ec_coupon_detail_guide") == true) goto L30;
            SharedPreferences.Editor r110 = r109.edit();
            if (r110 == null) goto L30;
            r110.putBoolean("ec_coupon_detail_guide", true);
            r110.apply();
            goto L30
        L14:
            if (TextUtils.isEmpty("ec_coupon_detail_guide") == true) goto L16;
            r107 = r106.getBoolean("ec_coupon_detail_guide", false);
        L30:
            if (LiveRoomCouponListViewModel.access$900(this.f147698a).f541799a == 2) goto L33;
            r104 = false;
        L33:
            if (r104 == false) goto L42;
            this.f147698a.getFullLoadingData().postValue(null);
            LiveRoomCouponListViewModel.access$1002(this.f147698a, new com.bytedance.android.livesdk.livecommerce.broadcast.ui.c(this));
            h r111 = LiveRoomCouponListViewModel.access$900(this.f147698a);
            v0 r112 = LiveRoomCouponListViewModel.access$1000(this.f147698a);
            r111.getClass();
            r111.f541800b = new WeakReference(r112);
            return;
        L42:
            return;
        L36:
            if (r102 == 11272) goto L38;
        L40:
            this.f147698a.getLoadingErrorData().postValue(null);
            return;
        L38:
            if (r101.statusMessage == null) goto L40;
            this.f147698a.getPermissionDeniedData().postValue(r101.statusMessage);
        }
    }

    public class c implements v0<r> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveRoomCouponListViewModel f147699a;

        public c(LiveRoomCouponListViewModel r100) {
            this.f147699a = r100;
        }

        @Override // vi2.v0
        public final void onError(Throwable r100) {
            this.f147699a.getFullLoadingFinishData().postValue(null);
            LiveRoomCouponListViewModel.access$1500(this.f147699a);
            LiveRoomCouponListViewModel.access$1402(this.f147699a, null);
        }

        @Override // vi2.v0
        public final void onSuccess(r r100) {
            this.f147699a.getFullLoadingFinishData().postValue(null);
            LiveRoomCouponListViewModel.access$1300(this.f147699a);
            LiveRoomCouponListViewModel.access$1402(this.f147699a, null);
        }
    }

    public class d implements v0<xi2.p> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveRoomCouponListViewModel f147700a;

        public d(LiveRoomCouponListViewModel r100) {
            this.f147700a = r100;
        }

        @Override // vi2.v0
        public final void onError(Throwable r100) {
            this.f147700a.getFullLoadingFinishData().postValue(null);
            LiveRoomCouponListViewModel.access$1200(this.f147700a);
            LiveRoomCouponListViewModel.access$1002(this.f147700a, null);
        }

        @Override // vi2.v0
        public final void onSuccess(xi2.p r100) {
            MutableLiveData<xi2.p> r101 = this.f147700a.getDistributeResponse();
            r101.postValue(r100);
            this.f147700a.getFullLoadingFinishData().postValue(null);
            LiveRoomCouponListViewModel.access$1100(this.f147700a);
            LiveRoomCouponListViewModel.access$1002(this.f147700a, null);
        }
    }

    public class e implements v0<n> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveRoomCouponListViewModel f147701a;

        public e(LiveRoomCouponListViewModel r100) {
            this.f147701a = r100;
        }

        @Override // vi2.v0
        public final void onError(Throwable r100) {
            this.f147701a.getFullLoadingFinishData().postValue(null);
            this.f147701a.getToastInt().postValue(Integer.valueOf(R.string.ec_refresh_couponlist_fail));
        }

        @Override // vi2.v0
        public final void onSuccess(n r100) {
            n r101 = r100;
            int r102 = r101.statusCode;
            if (r102 != 0) goto L6;
            this.f147701a.getFullLoadingFinishData().postValue(null);
            LiveRoomCouponListViewModel.access$702(this.f147701a, r101.couponExplain);
            LiveRoomCouponListViewModel.access$200(this.f147701a).a(r101);
            this.f147701a.getAdapterChangeData().postValue(null);
            LiveRoomCouponListViewModel.access$002(this.f147701a, r101.hasMore);
            return;
        L6:
            if (r102 == 11272) goto L8;
        L10:
            this.f147701a.getFullLoadingFinishData().postValue(null);
            this.f147701a.getToastInt().postValue(Integer.valueOf(R.string.ec_refresh_couponlist_fail));
            return;
        L8:
            if (r101.statusMessage == null) goto L10;
            this.f147701a.getPermissionDeniedData().postValue(r101.statusMessage);
        }
    }

    public interface f {
    }

    private void onCouponDistributeFail() {
        this.mWillDistributeCouponId = null;
        getAdapterChangeData().postValue(null);
    }

    private void onCouponDistributeSuccess() {
        this.mWillDistributeCouponId = null;
        h r100 = this.mDistributeCouponManager;
        p r101 = r100.f541802d;
        if (r101 == null) goto L5;
        r101.f542200l = 1;
        r100.f541802d = null;
    L5:
        getFullLoadingFinishData().postValue(null);
        getAdapterChangeData().postValue(null);
    }

    private void onEndDistributeFailed() {
        this.mWillDistributeCouponId = null;
    }

    private void onEndDistributeSuccess() {
        this.mWillDistributeCouponId = null;
        h r100 = this.mDistributeCouponManager;
        p r101 = r100.f541802d;
        if (r101 == null) goto L5;
        r101.f542200l = 0;
        r100.f541802d = null;
    L5:
        getFullLoadingFinishData().postValue(null);
        getAdapterChangeData().postValue(null);
    }

    public void cancelDistributeCoupon() {
        this.mWillDistributeCouponId = null;
    }

    public MutableLiveData<Pair<Integer, Integer>> getAdapterAppendData() {
        if (this.mAdapterAppendData != null) goto L6;
        this.mAdapterAppendData = new MutableLiveData();
    L6:
        return this.mAdapterAppendData;
    }

    public MutableLiveData<Void> getAdapterChangeData() {
        if (this.mAdapterChangeData != null) goto L6;
        this.mAdapterChangeData = new MutableLiveData();
    L6:
        return this.mAdapterChangeData;
    }

    public MutableLiveData<String> getCouponDetailGuideData() {
        if (this.mCouponDetailGuideData != null) goto L6;
        this.mCouponDetailGuideData = new MutableLiveData();
    L6:
        return this.mCouponDetailGuideData;
    }

    public MutableLiveData<Void> getDismissFunctionGuideData() {
        if (this.mDismissFunctionGuideData != null) goto L6;
        this.mDismissFunctionGuideData = new MutableLiveData();
    L6:
        return this.mDismissFunctionGuideData;
    }

    public MutableLiveData<p> getDistributeCouponData() {
        if (this.mDistributeCouponData != null) goto L6;
        this.mDistributeCouponData = new MutableLiveData();
    L6:
        return this.mDistributeCouponData;
    }

    public MutableLiveData<xi2.p> getDistributeResponse() {
        if (this.mDistributeResponse != null) goto L6;
        this.mDistributeResponse = new MutableLiveData();
    L6:
        return this.mDistributeResponse;
    }

    public MutableLiveData<View> getEndCouponGuideData() {
        if (this.mEndCouponGuideData != null) goto L6;
        this.mEndCouponGuideData = new MutableLiveData();
    L6:
        return this.mEndCouponGuideData;
    }

    public MutableLiveData<Void> getFullLoadingData() {
        if (this.mFullLoadingData != null) goto L6;
        this.mFullLoadingData = new MutableLiveData();
    L6:
        return this.mFullLoadingData;
    }

    public MutableLiveData<Void> getFullLoadingFinishData() {
        if (this.mFullLoadingFinishData != null) goto L6;
        this.mFullLoadingFinishData = new MutableLiveData();
    L6:
        return this.mFullLoadingFinishData;
    }

    public MutableLiveData<Integer> getScrollData() {
        if (this.mScrollData != null) goto L6;
        this.mScrollData = new MutableLiveData();
    L6:
        return this.mScrollData;
    }

    public LiveRoomCouponListViewModel() {
        this.mAdapterChangeData = null;
        this.mAdapterAppendData = null;
        this.mScrollData = null;
        this.mDistributeCouponData = null;
        this.mFullLoadingData = null;
        this.mFullLoadingFinishData = null;
        this.mCouponDetailGuideData = null;
        this.mDismissFunctionGuideData = null;
        this.mEndCouponGuideData = null;
        this.mDistributeResponse = null;
        this.mDistributeCouponManager = h.a.f541804a;
        this.mCouponDataHelper = new ch2.a();
        this.mEnterFrom = "";
    }

    private void refreshData() {
        getFullLoadingData().postValue(null);
        CompositeDisposable r100 = CoreRequests.f151395a;
        CoreRequests.b(this.mRoomId, this.mAnchorId, this.mEnterFrom, 0, new e(this));
    }

    private void requestData() {
        getLoadingData().postValue(null);
        CompositeDisposable r100 = CoreRequests.f151395a;
        CoreRequests.b(this.mRoomId, this.mAnchorId, this.mEnterFrom, 0, new b(this));
    }

    public void clickRetry() {
        requestData();
    }

    public String getCouponBindNotice() {
        return this.mCouponBindNotice;
    }

    public String getEndCouponHint() {
        return this.mEndCouponHint;
    }

    public boolean hasMore() {
        return this.mHasMore;
    }

    public void start() {
        requestData();
    }

    public static /* synthetic */ v0 access$1000(LiveRoomCouponListViewModel r100) {
        return r100.mDistributeCouponResponseIApiObserver;
    }

    public static /* synthetic */ void access$1100(LiveRoomCouponListViewModel r100) {
        r100.onCouponDistributeSuccess();
    }

    public static /* synthetic */ void access$1200(LiveRoomCouponListViewModel r100) {
        r100.onCouponDistributeFail();
    }

    public static /* synthetic */ void access$1300(LiveRoomCouponListViewModel r100) {
        r100.onEndDistributeSuccess();
    }

    public static /* synthetic */ void access$1500(LiveRoomCouponListViewModel r100) {
        r100.onEndDistributeFailed();
    }

    public static /* synthetic */ ch2.a access$200(LiveRoomCouponListViewModel r100) {
        return r100.mCouponDataHelper;
    }

    public static /* synthetic */ WeakReference access$800(LiveRoomCouponListViewModel r100) {
        return r100.mContextWeakReference;
    }

    public static /* synthetic */ h access$900(LiveRoomCouponListViewModel r100) {
        return r100.mDistributeCouponManager;
    }

    public void bindCoupon(FragmentManager r100) {
        if (this.mBindCouponManager != null) goto L5;
        this.mBindCouponManager = new dh2.a();
    L5:
        dh2.a r101 = this.mBindCouponManager;
        String r102 = this.mRoomId;
        String r103 = this.mCouponCipherText;
        String r104 = this.mCouponBindNotice;
        String r105 = this.mAnchorId;
        r101.getClass();
        if (r100 == null) goto L19;
        ECBindCouponFragment r106 = new ECBindCouponFragment();
        Bundle r107 = new Bundle();
        r107.putString("room_id", r102);
        r107.putString("anchor_id", r105);
        r107.putString("cipher_text", r103);
        r107.putString("bind_notice", r104);
        r106.setArguments(r107);
        WeakReference<dh2.a.InterfaceC5668a> r108 = r106.f147670x;
        if (r108 == null) goto L10;
        r108.clear();
    L10:
        r106.f147670x = new WeakReference(this);
        LandscapeRestrictionOperation r109 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r106, "bind_coupon_fragment", r109);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r100, r106, r109) == true) goto L20;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
    L14:
        r106.show(r100, "bind_coupon_fragment");
        return;
    L20:
        return;
    }

    public void bindDataAdapter(MultiTypeAdapter r100) {
        List<p> r101 = this.mCouponDataHelper.f23758a;
        r100.getClass();
        r101.getClass();
        ui2.c r102 = r100.f149488g;
        ((ArrayList) r102.f550144a).clear();
        ((ArrayList) r102.f550145b).clear();
        ((ArrayList) r102.f550144a).add(r101);
        List<ui2.c.a> r103 = r102.f550145b;
        ArrayList r104 = (ArrayList) r103;
        r104.add(new ui2.b());
    }

    @Override // com.bytedance.android.livesdk.livecommerce.broadcast.viewbinder.LiveRoomNewCouponViewBinder.a
    public void distributeCoupon(p r100) {
        if (this.mWillDistributeCouponId == null) goto L5;
        return;
    L5:
        h r101 = this.mDistributeCouponManager;
        if (r101 != null) goto L8;
    L16:
        this.mWillDistributeCouponId = r100.f542198j;
        getDistributeCouponData().postValue(r100);
        return;
    L8:
        if (r100.f542200l != 0) goto L16;
        if (r101.f541803e == true) goto L16;
        if (this.mEndCouponToast == null) goto L14;
        getToastString().postValue(this.mEndCouponToast);
        return;
    L14:
        getToastInt().postValue(Integer.valueOf(R.string.ec_can_not_distribute_coupon_same_time));
    }

    @Override // com.bytedance.android.livesdk.livecommerce.view.countdown.e.a
    public void handleMsg(Message r100) {
        if (r100 == null) goto L10;
        int r101 = r100.what;
        if (r101 != 1) goto L6;
    L8:
        getDismissFunctionGuideData().postValue(null);
        return;
    L6:
        if (r101 == 2) goto L8;
        return;
    }

    @Override // dh2.a.InterfaceC5668a
    public void onBindDone(List<p> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == true) goto L8;
        requestData();
        getScrollData().postValue(0);
        return;
    }

    public void setEnterFrom(String r100) {
        this.mEnterFrom = r100;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.broadcast.viewbinder.LiveRoomNewCouponViewBinder.a
    public void showBubble(View r100) {
        getEndCouponGuideData().postValue(r100);
    }

    public static /* synthetic */ boolean access$002(LiveRoomCouponListViewModel r100, boolean r101) {
        r100.mHasMore = r101;
        return r101;
    }

    public static /* synthetic */ v0 access$1002(LiveRoomCouponListViewModel r100, v0 r101) {
        r100.mDistributeCouponResponseIApiObserver = r101;
        return r101;
    }

    public static /* synthetic */ int access$102(LiveRoomCouponListViewModel r100, int r101) {
        r100.mCurrentPage = r101;
        return r101;
    }

    public static /* synthetic */ v0 access$1402(LiveRoomCouponListViewModel r100, v0 r101) {
        r100.mEndDistributeCouponResponseIApiObserver = r101;
        return r101;
    }

    public static /* synthetic */ String access$302(LiveRoomCouponListViewModel r100, String r101) {
        r100.mCouponBindNotice = r101;
        return r101;
    }

    public static /* synthetic */ String access$402(LiveRoomCouponListViewModel r100, String r101) {
        r100.mCouponCipherText = r101;
        return r101;
    }

    public static /* synthetic */ String access$502(LiveRoomCouponListViewModel r100, String r101) {
        r100.mEndCouponToast = r101;
        return r101;
    }

    public static /* synthetic */ String access$602(LiveRoomCouponListViewModel r100, String r101) {
        r100.mEndCouponHint = r101;
        return r101;
    }

    public static /* synthetic */ String access$702(LiveRoomCouponListViewModel r100, String r101) {
        r100.mCouponExplain = r101;
        return r101;
    }

    public void endDistributeCoupon(final Context r110, p r111) {
        this.mEndDistributeCouponResponseIApiObserver = new c(this);
        h r100 = this.mDistributeCouponManager;
        v0<r> r101 = this.mEndDistributeCouponResponseIApiObserver;
        r100.getClass();
        r100.f541801c = new WeakReference(r101);
        final h r102 = this.mDistributeCouponManager;
        String r103 = this.mRoomId;
        String r104 = r111.f542198j;
        boolean r105 = true;
        if (r102.f541799a == 1) goto L5;
        r105 = false;
    L6:
        if (r105 == false) goto L9;
        getFullLoadingData().postValue(null);
        c2 r112 = new c2();
        r112.f("coupon_id", r111.f542198j);
        r112.f("anchor_id", this.mAnchorId);
        r112.d(com.bytedance.android.ec.core.event.a.KEY_COUPON_TYPE, r111.f542189a);
        r112.f("room_id", this.mRoomId);
        r112.k();
        new w1(r111.f542198j, this.mRoomId, this.mAnchorId, r111.f542189a, SystemClock.elapsedRealtime() - this.mStartDistributeTime).k();
        return;
    L9:
        return;
    L5:
        r102.f541799a = 2;
        String r106 = vi2.h.f555073a;
        String r107 = vi2.h.d(g.f542173w);
        vi2.h.e(null, null, r107, new vi2.n(r103, r104, r107)).observeOn(AndroidSchedulers.mainThread()).subscribe(new sg2.f(r102, r110), new sg2.g(r102, r110));
        goto L6
    }

    public void openDistributeCouponDescFragment(Context r100, FragmentManager r101) {
        String r102 = th.a.g(r100, R.string.ec_coupon_introduction_title);
        String r103 = this.mCouponExplain;
        ECWebFragment r104 = new ECWebFragment();
        Bundle r105 = new Bundle();
        r105.putString("title", r102);
        r105.putString("url", r103);
        r104.setArguments(r105);
        INVOKEVIRTUAL_com_bytedance_android_livesdk_livecommerce_broadcast_ui_LiveRoomCouponListViewModel_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(r104, r101, "coupon_introduction_fragment");
    }

    public void realDistributeCoupon(final Context r110, p r111) {
        this.mDistributeCouponResponseIApiObserver = new d(this);
        h r100 = this.mDistributeCouponManager;
        v0<xi2.p> r101 = this.mDistributeCouponResponseIApiObserver;
        r100.getClass();
        r100.f541800b = new WeakReference(r101);
        final h r102 = this.mDistributeCouponManager;
        final String r103 = this.mRoomId;
        final String r104 = r111.f542198j;
        final String r105 = r111.f542202n;
        final int r106 = r111.f542201m;
        String r107 = this.mEnterFrom;
        if (r102.f541799a == 1) goto L5;
        boolean r112 = false;
    L6:
        if (r112 == false) goto L13;
        getFullLoadingData().postValue(null);
        String r108 = r111.f542198j;
        String r109 = this.mRoomId;
        String r113 = this.mAnchorId;
        int r114 = r111.f542189a;
        if (r111.f542206r != 1) goto L10;
        boolean r115 = true;
    L11:
        new x1(r108, r109, r113, r114, r115).k();
        this.mStartDistributeTime = SystemClock.elapsedRealtime();
        return;
    L10:
        r115 = false;
        goto L11
    L13:
        return;
    L5:
        r102.f541799a = 2;
        String r116 = vi2.h.f555073a;
        String r117 = vi2.h.d(g.f542172v);
        vi2.h.e(null, null, r117, new m(r103, r104, r107, r117)).observeOn(AndroidSchedulers.mainThread()).subscribe(new sg2.d(r102, r103, r104, r105, r106, r110), new sg2.e(r102, r110));
        r112 = true;
        goto L6
    }

    public void requestMore(MultiTypeAdapter r100, f r101) {
        CompositeDisposable r102 = CoreRequests.f151395a;
        CoreRequests.b(this.mRoomId, this.mAnchorId, this.mEnterFrom, this.mCurrentPage, new a(this, r101));
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_livesdk_livecommerce_broadcast_ui_LiveRoomCouponListViewModel_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(ECWebFragment r100, FragmentManager r101, String r102) {
        if ((r100 instanceof Fragment) == false) goto L5;
        ECWebFragment r103 = r100;
    L6:
        LandscapeRestrictionOperation r104 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r103, r102, r104);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r101, r103, r104) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r100.show(r101, r102);
        return;
    L5:
        r103 = null;
        goto L6
    }

    public void init(String r100, String r101, Context r102) {
        this.mRoomId = r100;
        this.mAnchorId = r101;
        if (r102 == null) goto L6;
        this.mContextWeakReference = new WeakReference(r102);
        return;
    }
}

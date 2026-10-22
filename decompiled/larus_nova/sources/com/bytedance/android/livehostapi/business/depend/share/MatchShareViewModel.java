package com.bytedance.android.livehostapi.business.depend.share;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.xiaomi.mipush.sdk.MiPushClient;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\t\"\u0004\b\u0012\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/share/MatchShareViewModel;", "Landroidx/lifecycle/ViewModel;", AppConstants.APP_FG, "Landroidx/lifecycle/LifecycleOwner;", "(Landroidx/lifecycle/LifecycleOwner;)V", "closeSharePageData", "Landroidx/lifecycle/MutableLiveData;", "", "getCloseSharePageData", "()Landroidx/lifecycle/MutableLiveData;", "setCloseSharePageData", "(Landroidx/lifecycle/MutableLiveData;)V", "screenOrientationChange", "", "getScreenOrientationChange", "setScreenOrientationChange", "setScreenOrientationVertical", "getSetScreenOrientationVertical", "setSetScreenOrientationVertical", "Companion", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MatchShareViewModel extends ViewModel {
    public static final Companion Companion = null;
    public static final String TAG = "MatchShareViewModel";
    private MutableLiveData<Boolean> closeSharePageData;

    /* JADX INFO: renamed from: fg, reason: collision with root package name */
    private final LifecycleOwner f102936fg;
    private MutableLiveData<Integer> screenOrientationChange;
    private MutableLiveData<Boolean> setScreenOrientationVertical;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J&\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0007J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\fH\u0007J\u0018\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/share/MatchShareViewModel$Companion;", "", "()V", "TAG", "", MonitorConstants.CONNECT_TYPE_GET, "Lcom/bytedance/android/livehostapi/business/depend/share/MatchShareViewModel;", "activity", "Landroid/app/Activity;", "subscribeScreenOrientation", "", MiPushClient.COMMAND_REGISTER, "", "observer", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "", "updateClosePageStatus", "close", "updateScreenOrientation", "vertical", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public final MatchShareViewModel get(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            if ((r100 instanceof FragmentActivity) == true) goto L5;
            r100 = null;
        L5:
            FragmentActivity r101 = (FragmentActivity) r100;
            if (r101 != null) goto L8;
            return null;
        L8:
            return (MatchShareViewModel) ViewModelProviders.of(r101, new MatchShareViewModelFactory(r101)).get(MatchShareViewModel.TAG, MatchShareViewModel.class);
        }

        @JvmStatic
        public final void updateClosePageStatus(Activity r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            MatchShareViewModel r102 = get(r100);
            if (r102 == null) goto L6;
            r102.getCloseSharePageData().setValue(Boolean.valueOf(r101));
            return;
        }

        @JvmStatic
        public final void updateScreenOrientation(Activity r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            MatchShareViewModel r102 = get(r100);
            if (r102 == null) goto L6;
            r102.getSetScreenOrientationVertical().setValue(Boolean.valueOf(r101));
            return;
        }

        @JvmStatic
        public final void subscribeScreenOrientation(Activity r100, boolean r101, Observer<Integer> r102) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Intrinsics.checkNotNullParameter(r102, "observer");
            MatchShareViewModel r103 = get(r100);
            if (r103 == null) goto L8;
            if (r101 == false) goto L6;
            r103.getScreenOrientationChange().observe((FragmentActivity) r100, r102);
            return;
        L6:
            r103.getScreenOrientationChange().removeObserver(r102);
            return;
        }
    }

    static {
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final MatchShareViewModel get(Activity r100) {
        return Companion.get(r100);
    }

    @JvmStatic
    public static final void subscribeScreenOrientation(Activity r100, boolean r101, Observer<Integer> r102) {
        Companion.subscribeScreenOrientation(r100, r101, r102);
    }

    @JvmStatic
    public static final void updateClosePageStatus(Activity r100, boolean r101) {
        Companion.updateClosePageStatus(r100, r101);
    }

    @JvmStatic
    public static final void updateScreenOrientation(Activity r100, boolean r101) {
        Companion.updateScreenOrientation(r100, r101);
    }

    public final MutableLiveData<Boolean> getCloseSharePageData() {
        return this.closeSharePageData;
    }

    public final MutableLiveData<Integer> getScreenOrientationChange() {
        return this.screenOrientationChange;
    }

    public final MutableLiveData<Boolean> getSetScreenOrientationVertical() {
        return this.setScreenOrientationVertical;
    }

    public MatchShareViewModel(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, AppConstants.APP_FG);
        this.f102936fg = r100;
        this.closeSharePageData = new MutableLiveData();
        this.screenOrientationChange = new MutableLiveData();
        this.setScreenOrientationVertical = new MutableLiveData();
    }

    public final void setCloseSharePageData(MutableLiveData<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.closeSharePageData = r100;
    }

    public final void setScreenOrientationChange(MutableLiveData<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.screenOrientationChange = r100;
    }

    public final void setSetScreenOrientationVertical(MutableLiveData<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.setScreenOrientationVertical = r100;
    }
}

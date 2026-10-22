package com.bytedance.android.live.componentsmarket.impl.components.title.model;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSTitleIcon;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0002#$B\u0007¢\u0006\u0004\b \u0010!J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\bH\u0016J\u0012\u0010\r\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0013R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0013R\u001c\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0013R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001dR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u001dR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u001dR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u001dR\u001c\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001d¨\u0006%"}, d2 = {"Lcom/bytedance/android/live/componentsmarket/impl/components/title/model/BaseTitleViewModel;", "Landroidx/lifecycle/ViewModel;", "", "", "text", "", "titleText", "desText", "", "isTvStatusShow", "isTitleIconShow", "isPrefixImgShow", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/VSTitleIcon;", "leftTitleIcon", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "roomInfo", "setRoomInfo", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "_titleText", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "_desText", "_isTvStatusShow", "_isTitleIconShow", "_isPrefixImgShow", "_leftTitleIcon", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "Landroidx/lifecycle/LiveData;", "getTitleText", "()Landroidx/lifecycle/LiveData;", "getDesText", "getLeftTitleIcon", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ComponentsType", "livecomponentsmarket-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseTitleViewModel extends ViewModel {
    public static final a Companion = null;
    private final NextLiveData<String> _desText;
    private final NextLiveData<Boolean> _isPrefixImgShow;
    private final NextLiveData<Boolean> _isTitleIconShow;
    private final NextLiveData<Boolean> _isTvStatusShow;
    private final NextLiveData<VSTitleIcon> _leftTitleIcon;
    private final NextLiveData<String> _titleText;
    private Room room;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/componentsmarket/impl/components/title/model/BaseTitleViewModel$ComponentsType;", "", "IS_MEDIA", "IS_VS", "livecomponentsmarket-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ComponentsType extends Enum<ComponentsType> {
        public static final ComponentsType IS_MEDIA = null;
        public static final ComponentsType IS_VS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ComponentsType[] f64684a = null;

        static {
            ComponentsType r100 = new ComponentsType("IS_MEDIA", 0);
            IS_MEDIA = r100;
            ComponentsType r101 = new ComponentsType("IS_VS", 1);
            IS_VS = r101;
            f64684a = new ComponentsType[]{r100, r101};
        }

        public static ComponentsType valueOf(String r100) {
            return (ComponentsType) r27.a.a(ComponentsType.class, r100);
        }

        public static ComponentsType[] values() {
            return (ComponentsType[]) f64684a.clone();
        }

        public ComponentsType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static BaseTitleViewModel a(ComponentsType r100, FragmentActivity r101) {
            Intrinsics.checkNotNullParameter(r100, "componentsType");
            Intrinsics.checkNotNullParameter(r101, WidgetService.PARAM_FRAGMENT);
            int r102 = t40.a.f544551a[r100.ordinal()];
            if (r102 == 1) goto L11;
            if (r102 != 2) goto L9;
            return (BaseTitleViewModel) ViewModelProviders.of(r101).get(VSTitleViewModel.class);
        L9:
            throw new NoWhenBranchMatchedException();
        L11:
            return (BaseTitleViewModel) ViewModelProviders.of(r101).get(MediaTitleViewModel.class);
        }
    }

    static {
        Companion = new a();
    }

    @JvmStatic
    public static final BaseTitleViewModel initViewModel(ComponentsType r100, FragmentActivity r101) {
        Companion.getClass();
        return a.a(r100, r101);
    }

    public BaseTitleViewModel() {
        this._titleText = new NextLiveData();
        this._desText = new NextLiveData();
        this._isTvStatusShow = new NextLiveData();
        this._isTitleIconShow = new NextLiveData();
        this._isPrefixImgShow = new NextLiveData();
        this._leftTitleIcon = new NextLiveData();
    }

    public LiveData<String> getDesText() {
        return this._desText;
    }

    public LiveData<VSTitleIcon> getLeftTitleIcon() {
        return this._leftTitleIcon;
    }

    public LiveData<String> getTitleText() {
        return this._titleText;
    }

    public LiveData<Boolean> isPrefixImgShow() {
        return this._isPrefixImgShow;
    }

    public LiveData<Boolean> isTitleIconShow() {
        return this._isTitleIconShow;
    }

    public LiveData<Boolean> isTvStatusShow() {
        return this._isTvStatusShow;
    }

    public void desText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this._desText.setValue(r100);
    }

    public void isPrefixImgShow(boolean r100) {
        this._isPrefixImgShow.setValue(Boolean.valueOf(r100));
    }

    public void isTitleIconShow(boolean r100) {
        this._isTitleIconShow.setValue(Boolean.valueOf(r100));
    }

    public void isTvStatusShow(boolean r100) {
        this._isTvStatusShow.setValue(Boolean.valueOf(r100));
    }

    public void leftTitleIcon(VSTitleIcon r100) {
        this._leftTitleIcon.setValue(r100);
    }

    public final void setRoomInfo(Room r100) {
        Intrinsics.checkNotNullParameter(r100, "roomInfo");
        this.room = r100;
    }

    public void titleText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this._titleText.setValue(r100);
    }
}

package com.bytedance.android.shopping.anchorv3.auction;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.ec.core.data.ActionObserver;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModelOwner;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0005\u0006B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/auction/AnchorV3AuctionOfferRecordsFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Lcom/ss/android/ugc/aweme/kiwi/viewmodel/QViewModelOwner;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "OfferRecordsParams", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV3AuctionOfferRecordsFragment extends BottomSheetDialogFragment implements QViewModelOwner {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f164431g = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final QUIManager f164432d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.ec.core.arch.viewmodel.c f164433e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public OfferRecordsParams f164434f;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/auction/AnchorV3AuctionOfferRecordsFragment$OfferRecordsParams;", "Landroid/os/Parcelable;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class OfferRecordsParams implements Parcelable {
        public static final Parcelable.Creator<OfferRecordsParams> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f164435a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f164436b;

        public static class a implements Parcelable.Creator<OfferRecordsParams> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final OfferRecordsParams createFromParcel(Parcel r100) {
                Intrinsics.checkNotNullParameter(r100, "in");
                return new OfferRecordsParams(r100.readString(), r100.readInt());
            }

            @Override // android.os.Parcelable.Creator
            public final OfferRecordsParams[] newArray(int r100) {
                return new OfferRecordsParams[r100];
            }
        }

        static {
            CREATOR = new a();
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            r100.writeString(this.f164435a);
            r100.writeInt(this.f164436b);
        }

        public OfferRecordsParams(String r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "auctionId");
            this.f164435a = r100;
            this.f164436b = r101;
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModelOwner
    public final ViewModelProvider.Factory o6() {
        return new ViewModelProvider.NewInstanceFactory();
    }

    public AnchorV3AuctionOfferRecordsFragment() {
        this.f164432d = new QUIManager();
        Function0<ViewModelProvider.Factory> r100 = new AnchorV3AuctionOfferRecordsFragment$viewModel$2(this);
        final Function0<Fragment> r101 = new AnchorV3AuctionOfferRecordsFragment$$special$$inlined$viewModels$1(this);
        this.f164433e = com.bytedance.android.ec.core.arch.viewmodel.b.a(this, Reflection.getOrCreateKotlinClass(AuctionOfferRecordsViewModel.class), new AnchorV3AuctionOfferRecordsFragment$$special$$inlined$viewModels$2(r101), r100);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        this.f164432d.c(c.class, null);
        ((AuctionOfferRecordsViewModel) this.f164433e.getValue()).getClosePageAction().b(getViewLifecycleOwner(), new ActionObserver(new AnonymousClass1(this)));
        OfferRecordsParams r101 = this.f164434f;
        if (r101 == null) goto L6;
        ((AuctionOfferRecordsViewModel) this.f164433e.getValue()).init(r101);
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        OfferRecordsParams r102 = null;
        if (r101 == null) goto L5;
        OfferRecordsParams r103 = (OfferRecordsParams) r101.getParcelable(Constants.KEY_PARAMS);
    L7:
        if ((r103 instanceof OfferRecordsParams) == false) goto L10;
        r102 = r103;
    L10:
        this.f164434f = r102;
        return;
    L5:
        r103 = null;
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        this.f164432d.k(new c(), th.a.e(requireContext(), true), this);
        return this.f164432d.p();
    }
}

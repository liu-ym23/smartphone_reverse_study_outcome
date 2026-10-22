package com.bytedance.android.live.ktv.common.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.livesdk.ktvapi.model.mv.a;
import com.bytedance.android.livesdk.ktvapi.model.mv.b;
import com.bytedance.android.livesdk.ktvapi.model.mv.f;
import com.bytedance.android.livesdk.ktvapi.model.mv.g;
import com.bytedance.android.livesdk.ktvapi.model.mv.k;
import com.bytedance.android.livesdk.message.model.od;
import com.bytedance.locallife.dito.data.DitoNode;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0002JG\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022-\b\u0002\u0010\f\u001a'\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006J&\u0010\u0011\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u00022\u0014\u0010\f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u000b0\u000fJ\b\u0010\u0012\u001a\u00020\u000bH\u0014R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R#\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u00188\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR-\u0010!\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001a0\u001fj\b\u0012\u0004\u0012\u00020\u001a` 0\u00188\u0006¢\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001eR\u0017\u0010$\u001a\u00020#8\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'¨\u0006,"}, d2 = {"Lcom/bytedance/android/live/ktv/common/viewmodel/OpusPreviewViewModel;", "Landroidx/lifecycle/ViewModel;", "", "isCurrentMvEmpty", "newRound", DitoNode.LOAD_MORE, "Lkotlin/Function2;", "Lcom/bytedance/android/livesdk/ktvapi/model/mv/a;", "Lkotlin/ParameterName;", "name", "fromRequest", "", "mvListCallback", "requestMvList", "isRefresh", "Lkotlin/Function1;", "Lcom/bytedance/android/livesdk/ktvapi/model/mv/b;", "changeMvList", "onCleared", "Lcom/bytedance/android/livesdk/ktvapi/model/mv/f;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/bytedance/android/livesdk/ktvapi/model/mv/f;", "getModel", "()Lcom/bytedance/android/livesdk/ktvapi/model/mv/f;", "Landroidx/lifecycle/LiveData;", "", "Lcom/bytedance/android/livesdk/message/model/od;", "officialMvList", "Landroidx/lifecycle/LiveData;", "getOfficialMvList", "()Landroidx/lifecycle/LiveData;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "opusMvList", "getOpusMvList", "Lcom/bytedance/android/livesdk/ktvapi/model/mv/k;", "songInfo", "Lcom/bytedance/android/livesdk/ktvapi/model/mv/k;", "getSongInfo", "()Lcom/bytedance/android/livesdk/ktvapi/model/mv/k;", "Lcom/bytedance/android/livesdk/ktvapi/model/mv/g;", "opusServie", "<init>", "(Lcom/bytedance/android/livesdk/ktvapi/model/mv/g;Lcom/bytedance/android/livesdk/ktvapi/model/mv/k;)V", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class OpusPreviewViewModel extends ViewModel {
    private final f model;
    private final LiveData<List<od>> officialMvList;
    private final LiveData<ArrayList<od>> opusMvList;
    private final k songInfo;

    private final boolean isCurrentMvEmpty() {
        List<od> r100 = this.officialMvList.getValue();
        if (r100 != null) goto L5;
    L6:
        ArrayList<od> r101 = this.opusMvList.getValue();
        if (r101 != null) goto L9;
        return true;
    L9:
        if ((!r101.isEmpty()) != true) goto L14;
    L11:
        return false;
    L14:
        return true;
    L5:
        if ((!r100.isEmpty()) == true) goto L11;
        goto L6
    }

    public final f getModel() {
        return this.model;
    }

    public final LiveData<List<od>> getOfficialMvList() {
        return this.officialMvList;
    }

    public final LiveData<ArrayList<od>> getOpusMvList() {
        return this.opusMvList;
    }

    public final k getSongInfo() {
        return this.songInfo;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
    }

    public OpusPreviewViewModel(g r100, k r101) {
        Intrinsics.checkNotNullParameter(r100, "opusServie");
        Intrinsics.checkNotNullParameter(r101, "songInfo");
        this.songInfo = r101;
        f r102 = r100.l(r101.f142333e, r101.f142334f);
        this.model = r102;
        this.officialMvList = r102.f();
        this.opusMvList = r102.j();
    }

    public final void changeMvList(boolean r100, Function1<? super b, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "mvListCallback");
        this.model.b(r100, r101);
    }

    public final void requestMvList(boolean r100, boolean r101, final Function2<? super a, ? super Boolean, Unit> r102) {
        if (isCurrentMvEmpty() == false) goto L6;
        if (r100 == false) goto L6;
        this.model.k(true, new AnonymousClass1(r102));
        return;
    L6:
        if (r100 == false) goto L8;
        this.model.c(new AnonymousClass2(this, r102));
        return;
    L8:
        if (r101 == false) goto L13;
        this.model.k(false, AnonymousClass3.INSTANCE);
        return;
    }

    public static /* synthetic */ void changeMvList$default(OpusPreviewViewModel r100, boolean r101, Function1 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L5;
        r101 = false;
    L5:
        r100.changeMvList(r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void requestMvList$default(OpusPreviewViewModel r100, boolean r101, boolean r102, Function2 r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = false;
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = null;
    L8:
        r100.requestMvList(r101, r102, r103);
    }
}

package com.bytedance.android.livesdk.dsl.recyclerview;

import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.n0;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yt1.k;
import yt1.o;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/dsl/recyclerview/SingleDSLViewHolder;", "Lcom/bytedance/android/livesdk/dsl/recyclerview/BaseDSLViewHolder;", "dslservice-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SingleDSLViewHolder extends BaseDSLViewHolder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PropertyOwner<Integer> f122775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f122776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k f122777d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f122778e;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SingleDSLViewHolder f122779a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f122780b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f122781c;

        public a(SingleDSLViewHolder r100, b r101, boolean r102) {
            this.f122779a = r100;
            this.f122780b = r101;
            this.f122781c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            if (((Integer) r100).intValue() <= 0) goto L22;
            ALogger.d("Live_Slice", "bindDSLItem " + this.f122780b.f122787d + " update:" + this.f122781c);
            k r101 = this.f122779a.f122777d;
            if (r101 == null) goto L7;
            r101.a(new i(this));
        L7:
            k r102 = this.f122779a.f122777d;
            if (r102 == null) goto L17;
            b r103 = this.f122780b;
            if (r103.f122786c != null) goto L15;
            int r104 = com.bytedance.android.livesdk.dsl.util.c.f122805a;
            HashMap<String, Object> r105 = com.bytedance.android.livesdk.dsl.util.c.g(r103.f122789f);
            r103.f122786c = r105;
            HashMap<String, Object> r106 = r103.f122788e;
            if (r106 == null) goto L15;
            if (r105 == null) goto L15;
            r105.putAll(r106);
        L15:
            r102.c(null, r103.f122786c, 0);
        L17:
            if (this.f122781c == true) goto L23;
            k r107 = this.f122779a.f122777d;
            if (r107 == null) goto L24;
            r107.b(au1.a.c.f16301b, true);
            return;
        L24:
            return;
        L23:
            return;
        }
    }

    @Override // com.bytedance.android.livesdk.dsl.recyclerview.BaseDSLViewHolder
    public final void V3() {
        this.f122776c.clear();
    }

    @Override // com.bytedance.android.livesdk.dsl.recyclerview.BaseDSLViewHolder
    public final c T3() {
        return this.f122778e;
    }

    public SingleDSLViewHolder(o r100, c r101) {
        FrameLayout r102 = new FrameLayout(r101.getActivity());
        r102.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        Intrinsics.checkNotNullParameter(r100, "templateData");
        Intrinsics.checkNotNullParameter(r101, "dslRVContext");
        Intrinsics.checkNotNullParameter(r102, "slcView");
        super(r102);
        this.f122778e = r101;
        this.f122775b = new PropertyOwner(0);
        this.f122776c = new CompositeDisposable();
        k r103 = r101.f122796e.d(r100, "", r102, null, new h(this));
        this.f122777d = r103;
        if (n0.f65363a.getValue().booleanValue() == false) goto L6;
        if (r103 == null) goto L6;
        Intrinsics.checkNotNullParameter(r103, "comp");
        r101.f122794c.add(r103);
    L6:
        yt1.e r104 = r100.f569031a;
        if (r104 == null) goto L18;
        int r105 = (int) r104.f569027a;
        if (r105 < 0) goto L12;
        r105 = UtilityKotlinExtentionsKt.i(r105);
    L12:
        a1.k(r102, r105);
        int r106 = (int) r104.f569028b;
        if (r106 < 0) goto L16;
        r106 = UtilityKotlinExtentionsKt.i(r106);
    L16:
        a1.p(r102, r106);
        return;
    }

    @Override // com.bytedance.android.livesdk.dsl.recyclerview.BaseDSLViewHolder
    public final void U3(b r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        RxUtilKt.c(com.bytedance.android.live.core.arch.mvvm.f.b(this.f122775b).subscribe(new a(this, r100, r101)), this.f122776c);
    }
}

package com.bytedance.android.live.search.impl.search;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.live.search.impl.search.model.LiveSearchResultParam;
import com.bytedance.android.live.search.impl.search.viewmodel.LiveSearchIntermediateViewModel;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0003\u000e\u000f\u0010B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/search/impl/search/LiveSearchIntermediateView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/live/search/impl/search/LiveSearchIntermediateView$b;", "listener", "", "setOnDispatchTouchEventListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "livesearchimpl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveSearchIntermediateView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LiveSearchIntermediateViewModel f100619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f100620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FragmentManager f100621c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LiveSearchIntermediateFragment f100622d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f100623e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f100624f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f100625g;

    public static final class a {
    }

    public interface b {
        void c(MotionEvent r100);
    }

    public interface c {
        void d50(LiveSearchResultParam r100);
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveSearchIntermediateView f100626a;

        public d(LiveSearchIntermediateView r100) {
            this.f100626a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Integer r101 = (Integer) r100;
            if (r101 != null) goto L6;
            return;
        L6:
            if (this.f100626a.f100623e != r101.intValue()) goto L8;
        L20:
            this.f100626a.setVisibility(0);
        L22:
            if (r101.intValue() != 0) goto L29;
            LiveSearchIntermediateView r102 = this.f100626a;
            LiveSearchIntermediateFragment r103 = r102.f100622d;
            if (r103 == null) goto L29;
            FragmentManager r104 = r102.f100621c;
            if (r104 != null) goto L28;
            Intrinsics.throwUninitializedPropertyAccessException("fragmentManager");
        L28:
            r104.beginTransaction().hide(r103).commitAllowingStateLoss();
        L29:
            LiveSearchIntermediateView r105 = this.f100626a;
            r105.f100623e = r101.intValue();
            return;
        L8:
            if (r101.intValue() != 0) goto L20;
            LiveSearchIntermediateViewModel r106 = this.f100626a.f100619a;
            if (r106 == null) goto L14;
            NextLiveData<LiveSearchResultParam> r107 = r106.getOpenSearchParam();
            if (r107 == null) goto L14;
            LiveSearchResultParam r108 = r107.getValue();
        L15:
            if (r108 == null) goto L22;
            c r109 = this.f100626a.f100620b;
            if (r109 != null) goto L19;
            Intrinsics.throwUninitializedPropertyAccessException("responder");
        L19:
            r109.d50(r108);
            this.f100626a.setVisibility(8);
        L14:
            r108 = null;
            goto L15
        }
    }

    static {
    }

    public LiveSearchIntermediateView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LiveSearchIntermediateView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void a() {
        FragmentManager r100 = this.f100621c;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("fragmentManager");
    L6:
        if ((r100.findFragmentByTag("tag_intermediate") instanceof LiveSearchIntermediateFragment) == true) goto L17;
        this.f100622d = new LiveSearchIntermediateFragment();
        FragmentManager r101 = this.f100621c;
        if (r101 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("fragmentManager");
    L10:
        FragmentTransaction r102 = r101.beginTransaction();
        LiveSearchIntermediateFragment r103 = this.f100622d;
        if (r103 != null) goto L13;
        return;
    L13:
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r102, r103, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "tag_intermediate", R.id.search_intermediate) == true) goto L16;
        r102 = r102.replace(R.id.search_intermediate, r103, "tag_intermediate");
    L16:
        r102.show(r103).commitAllowingStateLoss();
        return;
    L17:
        FragmentManager r104 = this.f100621c;
        if (r104 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("fragmentManager");
    L20:
        FragmentTransaction r105 = r104.beginTransaction();
        LiveSearchIntermediateFragment r106 = this.f100622d;
        if (r106 == null) goto L26;
        r105.show(r106).commitAllowingStateLoss();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        boolean r101 = super.dispatchTouchEvent(r100);
        b r102 = this.f100625g;
        if (r102 == null) goto L5;
        r102.c(r100);
    L5:
        return r101;
    }

    public final void setOnDispatchTouchEventListener(b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f100625g = r100;
    }

    public LiveSearchIntermediateView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setVisibility(0);
        this.f100623e = 0;
        this.f100624f = new d(this);
    }

    public /* synthetic */ LiveSearchIntermediateView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}

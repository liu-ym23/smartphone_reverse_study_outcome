package com.bytedance.android.live.soloktv.tuningpanel.manager;

import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.d;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/soloktv/tuningpanel/manager/SoloKtvTuningDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/live/ktv/common/tuningpanel/ability/a;", "mTuningCore", "Lcom/bytedance/android/live/ktv/common/tuningpanel/ability/a;", "getMTuningCore", "()Lcom/bytedance/android/live/ktv/common/tuningpanel/ability/a;", "setMTuningCore", "(Lcom/bytedance/android/live/ktv/common/tuningpanel/ability/a;)V", "Lec0/a;", "mTuningMusicControl", "Lec0/a;", "getMTuningMusicControl", "()Lec0/a;", "setMTuningMusicControl", "(Lec0/a;)V", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "<init>", "()V", "Companion", "soloktv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SoloKtvTuningDataContext extends DataContext {
    public static final Companion Companion = null;
    private final CompositeDisposable compositeDisposable;
    private com.bytedance.android.live.ktv.common.tuningpanel.ability.a mTuningCore;
    private ec0.a mTuningMusicControl;

    public static final class Companion {
        public Companion() {
        }

        @JvmStatic
        public static SoloKtvTuningDataContext a() {
            DataContext r100 = d.d(SoloKtvTuningDataContext$Companion$getDataContext$1.INSTANCE);
            if ((r100 instanceof SoloKtvTuningDataContext) == true) goto L6;
            r100 = null;
        L6:
            return (SoloKtvTuningDataContext) r100;
        }
    }

    public static final class a implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SoloKtvTuningDataContext f101581a;

        public a(SoloKtvTuningDataContext r100) {
            this.f101581a = r100;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r100 = this.f101581a.getMTuningCore();
            if (r100 == null) goto L5;
            r100.clearData();
        L5:
            ec0.a r101 = this.f101581a.getMTuningMusicControl();
            if (r101 == null) goto L8;
            r101.clearData();
        L8:
            this.f101581a.setMTuningCore(null);
            this.f101581a.setMTuningMusicControl(null);
            SoloKtvTuningDataContext.access$getCompositeDisposable$p(this.f101581a).clear();
        }
    }

    @JvmStatic
    public static final SoloKtvTuningDataContext getDataContext() {
        Companion.getClass();
        return Companion.a();
    }

    static {
        Companion = new Companion();
    }

    @JvmStatic
    public static final com.bytedance.android.live.ktv.common.tuningpanel.ability.a getTuningCore() {
        Companion.getClass();
        SoloKtvTuningDataContext r100 = Companion.a();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getMTuningCore();
    }

    public SoloKtvTuningDataContext() {
        CompositeDisposable r100 = new CompositeDisposable();
        this.compositeDisposable = r100;
        Disposable r101 = getOnCleared().subscribe(new a(this));
        if (r101 == null) goto L6;
        RxUtilKt.c(r101, r100);
        return;
    }

    public final com.bytedance.android.live.ktv.common.tuningpanel.ability.a getMTuningCore() {
        return this.mTuningCore;
    }

    public final ec0.a getMTuningMusicControl() {
        return this.mTuningMusicControl;
    }

    public static final /* synthetic */ CompositeDisposable access$getCompositeDisposable$p(SoloKtvTuningDataContext r100) {
        return r100.compositeDisposable;
    }

    public final void setMTuningCore(com.bytedance.android.live.ktv.common.tuningpanel.ability.a r100) {
        this.mTuningCore = r100;
    }

    public final void setMTuningMusicControl(ec0.a r100) {
        this.mTuningMusicControl = r100;
    }
}

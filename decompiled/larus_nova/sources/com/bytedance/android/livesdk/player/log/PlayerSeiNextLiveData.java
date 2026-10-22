package com.bytedance.android.livesdk.player.log;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.bytedance.android.livesdk.player.event.PlayerNextLiveData;
import com.bytedance.android.livesdk.player.monitor.e;
import com.bytedance.android.livesdk.player.setting.SettingKeyUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/player/log/PlayerSeiNextLiveData;", "Lcom/bytedance/android/livesdk/player/event/PlayerNextLiveData;", "", "SeiObserverWrapper", "live-player-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerSeiNextLiveData extends PlayerNextLiveData<String> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakHashMap<Observer<? super String>, SeiObserverWrapper> f155612c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f155613d;

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/player/log/PlayerSeiNextLiveData$SeiObserverWrapper;", "Landroidx/lifecycle/Observer;", "", "live-player-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class SeiObserverWrapper implements Observer<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f155614a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Observer<? super String> f155615b;

        @Override // androidx.lifecycle.Observer
        public final void onChanged(String r100) {
            String r101 = r100;
            String r102 = this.f155615b.getClass().getName();
            e r103 = this.f155614a;     // Catch: Exception -> L11
            if (r103 == null) goto L7;
            r103.e(r102, "sei");     // Catch: Exception -> L11
        L7:
            this.f155615b.onChanged(r101);     // Catch: Exception -> L11
            e r104 = this.f155614a;     // Catch: Exception -> L11
            if (r104 == null) goto L16;
            r104.c(r102, "sei");     // Catch: Exception -> L11
            return;
        L16:
            return;
        L11:
            e = move-exception;
            e.printStackTrace();
            throw e;
        }

        public SeiObserverWrapper(e r100, Observer<? super String> r101) {
            Intrinsics.checkNotNullParameter(r101, "wrapperObserver");
            this.f155614a = r100;
            this.f155615b = r101;
        }
    }

    public PlayerSeiNextLiveData(e r100) {
        this.f155613d = r100;
        this.f155612c = new WeakHashMap();
    }

    public final SeiObserverWrapper a(Observer r100) {
        if (SettingKeyUtils.a() == false) goto L7;
        SeiObserverWrapper r101 = this.f155612c.get(r100);
        if (r101 == null) goto L7;
        return r101;
    L7:
        SeiObserverWrapper r102 = new SeiObserverWrapper(this.f155613d, r100);
        this.f155612c.put(r100, r102);
        return r102;
    }

    @Override // com.bytedance.android.livesdk.player.event.PlayerNextLiveData, androidx.lifecycle.LiveData
    public final void removeObserver(Observer<? super String> r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        if (SettingKeyUtils.a() == false) goto L29;
        Iterator<T> r101 = this.f155612c.entrySet().iterator();
    L5:
        Object r102 = null;
        if (r101.hasNext() == false) goto L17;
        Object r103 = r101.next();
        SeiObserverWrapper r104 = (SeiObserverWrapper) ((Map.Entry) r103).getValue();
        if ((r100 instanceof PlayerNextLiveData.NextObserver) == true) goto L10;
        Observer<? super String> r105 = null;
    L11:
        PlayerNextLiveData.NextObserver r106 = (PlayerNextLiveData.NextObserver) r105;
        if (r106 == null) goto L15;
        r102 = r106.f155173b;
    L15:
        if (Intrinsics.areEqual(r104, r102) == false) goto L5;
        r102 = r103;
        goto L17
    L10:
        r105 = r100;
    L17:
        Map.Entry r107 = (Map.Entry) r102;
        if (r107 == null) goto L25;
        SeiObserverWrapper r108 = (SeiObserverWrapper) r107.getValue();
        if (r108 == null) goto L25;
        Observer<? super String> r109 = r108.f155615b;
        if (r109 == null) goto L24;
        SeiObserverWrapper r110 = this.f155612c.remove(r109);
    L24:
        super.removeObserver(r108);
        return;
    L25:
        SeiObserverWrapper r111 = this.f155612c.get(r100);
        if (r111 == null) goto L28;
        this.f155612c.remove(r100);
        super.removeObserver(r111);
        return;
    L28:
        super.removeObserver(r100);
        return;
    L29:
        SeiObserverWrapper r112 = this.f155612c.get(r100);
        if (r112 == null) goto L32;
        this.f155612c.remove(r100);
        super.removeObserver(r112);
        return;
    L32:
        super.removeObserver(r100);
    }

    @Override // com.bytedance.android.livesdk.player.event.PlayerNextLiveData
    public final void observeForever(Observer<? super String> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        super.observeForever(a(r100), false);
    }

    @Override // com.bytedance.android.livesdk.player.event.PlayerNextLiveData
    public final void observe(LifecycleOwner r100, Observer<? super String> r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "observer");
        super.observe(r100, a(r101), r102);
    }
}

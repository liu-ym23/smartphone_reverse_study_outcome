package com.bytedance.android.livesdk.player.newstrategy.pullstream;

import androidx.lifecycle.Observer;
import com.bytedance.android.livesdkapi.model.AudioStereoParams;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001¨\u0006\u0005"}, d2 = {"com/bytedance/android/livesdk/player/newstrategy/pullstream/AudioStereoStrategyNode$observer$1", "Landroidx/lifecycle/Observer;", "", "", "", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudioStereoStrategyNode$observer$1 implements Observer<Map<String, ? extends Object>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AudioStereoStrategyNode f155952a;

    public AudioStereoStrategyNode$observer$1(AudioStereoStrategyNode r100) {
        this.f155952a = r100;
    }

    public final void a(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        WeakReference<ILivePlayerClient> r101 = this.f155952a.f155949a;
        Object r102 = null;
        if (r101 == null) goto L5;
        ILivePlayerClient r103 = r101.get();
    L7:
        if ((!Intrinsics.areEqual(r100, this.f155952a.f155950b)) == false) goto L26;
        if (r103 == null) goto L27;
        Object r104 = r100.get("enable");
        if ((r104 instanceof Boolean) == true) goto L12;
        r104 = null;
    L12:
        Boolean r105 = (Boolean) r104;
        int r106 = 0;
        if (Intrinsics.areEqual(r105, Boolean.TRUE) == false) goto L23;
        Object r107 = r100.get("position");
        if ((r107 instanceof Integer) == false) goto L18;
        r102 = r107;
    L18:
        Integer r108 = (Integer) r102;
        if (r108 == null) goto L21;
        r106 = r108.intValue();
    L21:
        r103.setAudioStereo(new AudioStereoParams(true, r106, String.valueOf(com.bytedance.android.livesdk.chatroom.viewmodule.shortterm.q.a(r100))));
        return;
    L23:
        if (Intrinsics.areEqual(r105, Boolean.FALSE) == false) goto L29;
        r103.setAudioStereo(new AudioStereoParams(false, 0, ""));
        return;
    L29:
        return;
    L27:
        return;
    L26:
        return;
    L5:
        r103 = null;
        goto L7
    }

    @Override // androidx.lifecycle.Observer
    public final /* bridge */ /* synthetic */ void onChanged(Map<String, ? extends Object> r100) {
        a(r100);
    }
}

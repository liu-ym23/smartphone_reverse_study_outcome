package be0;

import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import java.util.ArrayList;
import kotlin.Deprecated;

/* JADX INFO: loaded from: classes46.dex */
@Deprecated(message = "VideoKtv已下架,仅兼容旧逻辑使用")
public final class f implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NextLiveData<IVoiceLiveTheme> f18730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NextLiveData<IVoiceLiveTheme> f18731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NextLiveData<ArrayList<IVoiceLiveTheme>> f18732c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final NextLiveData<Integer> f18733d;

    @Override // be0.a
    public final IVoiceLiveTheme d() {
        return null;
    }

    public f() {
        this.f18730a = new NextLiveData();
        this.f18731b = new NextLiveData();
        NextLiveData<ArrayList<IVoiceLiveTheme>> r100 = new NextLiveData();
        this.f18732c = r100;
        this.f18733d = new NextLiveData();
        r100.setValue(new ArrayList());
    }

    @Override // be0.a
    public final NextLiveData<IVoiceLiveTheme> a() {
        return this.f18731b;
    }

    @Override // be0.a
    public final NextLiveData<ArrayList<IVoiceLiveTheme>> b() {
        return this.f18732c;
    }

    @Override // be0.a
    public final NextLiveData<Integer> c() {
        return this.f18733d;
    }

    @Override // be0.a
    public final NextLiveData<IVoiceLiveTheme> getCurrentTheme() {
        return this.f18730a;
    }
}

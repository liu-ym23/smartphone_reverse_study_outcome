package be0;

import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes46.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NextLiveData<IVoiceLiveTheme> f18717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NextLiveData<IVoiceLiveTheme> f18718b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NextLiveData<ArrayList<IVoiceLiveTheme>> f18719c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final NextLiveData<Integer> f18720d;

    @Override // be0.a
    public final IVoiceLiveTheme d() {
        return null;
    }

    public b() {
        this.f18717a = new NextLiveData();
        this.f18718b = new NextLiveData();
        NextLiveData<ArrayList<IVoiceLiveTheme>> r100 = new NextLiveData();
        this.f18719c = r100;
        this.f18720d = new NextLiveData();
        r100.setValue(new ArrayList());
    }

    @Override // be0.a
    public final NextLiveData<IVoiceLiveTheme> a() {
        return this.f18718b;
    }

    @Override // be0.a
    public final NextLiveData<ArrayList<IVoiceLiveTheme>> b() {
        return this.f18719c;
    }

    @Override // be0.a
    public final NextLiveData<Integer> c() {
        return this.f18720d;
    }

    @Override // be0.a
    public final NextLiveData<IVoiceLiveTheme> getCurrentTheme() {
        return this.f18717a;
    }
}

package be0;

import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.model.DefaultVoiceLiveThemeResource;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes46.dex */
public final class g implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NextLiveData<IVoiceLiveTheme> f18734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NextLiveData<IVoiceLiveTheme> f18735b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NextLiveData<ArrayList<IVoiceLiveTheme>> f18736c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final NextLiveData<Integer> f18737d;

    public g() {
        this.f18734a = new NextLiveData();
        this.f18735b = new NextLiveData();
        NextLiveData<ArrayList<IVoiceLiveTheme>> r100 = new NextLiveData();
        this.f18736c = r100;
        this.f18737d = new NextLiveData();
        r100.setValue(new ArrayList());
    }

    @Override // be0.a
    public final IVoiceLiveTheme d() {
        return DefaultVoiceLiveThemeResource.videoTalkRoomDefaultTheme();
    }

    @Override // be0.a
    public final NextLiveData<IVoiceLiveTheme> a() {
        return this.f18735b;
    }

    @Override // be0.a
    public final NextLiveData<ArrayList<IVoiceLiveTheme>> b() {
        return this.f18736c;
    }

    @Override // be0.a
    public final NextLiveData<Integer> c() {
        return this.f18737d;
    }

    @Override // be0.a
    public final NextLiveData<IVoiceLiveTheme> getCurrentTheme() {
        return this.f18734a;
    }
}

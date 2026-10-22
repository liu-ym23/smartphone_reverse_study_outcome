package be0;

import com.bytedance.android.livesdk.model.k;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class e implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NextLiveData<IVoiceLiveTheme> f18726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NextLiveData<IVoiceLiveTheme> f18727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NextLiveData<ArrayList<IVoiceLiveTheme>> f18728c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final NextLiveData<Integer> f18729d;

    @Override // be0.a
    public final IVoiceLiveTheme d() {
        ArrayList<IVoiceLiveTheme> r100 = this.f18728c.getValue();
        if (r100 == null) goto L14;
        Iterator<T> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        Object r102 = r101.next();
        String r103 = ((IVoiceLiveTheme) r102).getImageUri();
        oj0.a r104 = oj0.a.f523507c;
        r104.getClass();
        if (Intrinsics.areEqual(r103, ((oj0.b) oj0.a.f523506b.getValue(r104, oj0.a.f523505a[0])).f523508a) == false) goto L6;
    L11:
        IVoiceLiveTheme r105 = (IVoiceLiveTheme) r102;
        if (r105 == null) goto L14;
        return r105;
    L10:
        r102 = null;
    L14:
        return k.a();
    }

    public e() {
        this.f18726a = new NextLiveData();
        this.f18727b = new NextLiveData();
        NextLiveData<ArrayList<IVoiceLiveTheme>> r100 = new NextLiveData();
        this.f18728c = r100;
        this.f18729d = new NextLiveData();
        r100.setValue(new ArrayList());
    }

    @Override // be0.a
    public final NextLiveData<IVoiceLiveTheme> a() {
        return this.f18727b;
    }

    @Override // be0.a
    public final NextLiveData<ArrayList<IVoiceLiveTheme>> b() {
        return this.f18728c;
    }

    @Override // be0.a
    public final NextLiveData<Integer> c() {
        return this.f18729d;
    }

    @Override // be0.a
    public final NextLiveData<IVoiceLiveTheme> getCurrentTheme() {
        return this.f18726a;
    }
}

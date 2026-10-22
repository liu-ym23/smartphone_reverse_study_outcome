package b6a;

import com.lynx.lottieadapter.AnimationType;

/* JADX INFO: loaded from: classes4.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AnimationType f17892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f17893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f17894c;

    public k() {
        this.f17892a = AnimationType.LOTTIE;
        this.f17893b = false;
        this.f17894c = false;
    }

    public AnimationType getType() {
        return this.f17892a;
    }

    public k(k r100) {
        this.f17892a = AnimationType.LOTTIE;
        this.f17893b = false;
        this.f17894c = false;
        this.f17892a = r100.f17892a;
        this.f17893b = r100.f17893b;
        this.f17894c = r100.f17894c;
    }
}

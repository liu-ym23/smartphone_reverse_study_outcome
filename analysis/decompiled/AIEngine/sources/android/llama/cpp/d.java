package android.llama.cpp;

import android.llama.cpp.LLamaAndroid;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements zb.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f190a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LLamaAndroid f191b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LLamaAndroid.Companion.State f192c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f193d;

    public /* synthetic */ d(LLamaAndroid lLamaAndroid, LLamaAndroid.Companion.State state, Object obj, int i10) {
        this.f190a = i10;
        this.f191b = lLamaAndroid;
        this.f192c = state;
        this.f193d = obj;
    }

    @Override // zb.a
    public final Object invoke() {
        switch (this.f190a) {
            case 0:
                return LLamaAndroid.AnonymousClass2.invokeSuspend$lambda$0(this.f191b, (LLamaAndroid.Companion.State.EmbeddingLoaded) this.f192c, (List) this.f193d);
            case 1:
                return LLamaAndroid.C01852.invokeSuspend$lambda$0(this.f191b, (LLamaAndroid.Companion.State.EmbeddingLoaded) this.f192c, (String) this.f193d);
            default:
                return LLamaAndroid.C01902.invokeSuspend$lambda$1(this.f191b, (LLamaAndroid.Companion.State.Loaded) this.f192c, (LLamaAndroid.Companion.IntVar) this.f193d);
        }
    }
}

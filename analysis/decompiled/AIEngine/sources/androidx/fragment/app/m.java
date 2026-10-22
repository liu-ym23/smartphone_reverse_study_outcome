package androidx.fragment.app;

import android.content.Intent;
import kotlinx.coroutines.channels.Channel;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class m implements u0.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2167a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2168b;

    public /* synthetic */ m(Object obj, int i10) {
        this.f2167a = i10;
        this.f2168b = obj;
    }

    @Override // u0.a
    public final void accept(Object obj) {
        int i10 = this.f2167a;
        Object obj2 = this.f2168b;
        switch (i10) {
            case 0:
                ((o) obj2).lambda$init$2((Intent) obj);
                break;
            default:
                androidx.window.layout.m info = (androidx.window.layout.m) obj;
                kotlin.jvm.internal.g.e(info, "info");
                ((Channel) obj2).mo149trySendJP2dKIU(info);
                break;
        }
    }
}

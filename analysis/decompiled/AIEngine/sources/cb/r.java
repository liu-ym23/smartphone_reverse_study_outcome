package cb;

import com.stepos.core.ability.text.SessionKey;
import com.stepos.core.ability.text.SessionStore;
import com.tonyodev.fetch2.Download;
import java.io.Serializable;
import java.util.List;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class r implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3387a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3388b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3389c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Serializable f3390d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f3391e;

    public /* synthetic */ r(SessionKey sessionKey, Ref$ObjectRef ref$ObjectRef, int i10, String str) {
        this.f3389c = sessionKey;
        this.f3390d = ref$ObjectRef;
        this.f3388b = i10;
        this.f3391e = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3387a) {
            case 0:
                ((ya.f) this.f3389c).onStarted((Download) this.f3390d, (List) this.f3391e, this.f3388b);
                break;
            default:
                SessionStore.markPendingClose$lambda$4((SessionKey) this.f3389c, (Ref$ObjectRef) this.f3390d, this.f3388b, (String) this.f3391e);
                break;
        }
    }

    public /* synthetic */ r(ya.f fVar, Download download, List list, int i10) {
        this.f3389c = fVar;
        this.f3390d = download;
        this.f3391e = list;
        this.f3388b = i10;
    }
}

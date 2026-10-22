package b26;

import java.util.concurrent.Callable;
import kotlin.Unit;
import org.json.JSONObject;
import v26.j;
import v26.l;

/* JADX INFO: loaded from: classes19.dex */
public final class c<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f17015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f17016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f17017c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f17018d;

    public c(j r100, l r101, String r102, String r103) {
        this.f17015a = r100;
        this.f17016b = r101;
        this.f17017c = r102;
        this.f17018d = r103;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        a r100 = this.f17015a.f552697r;
        l r101 = this.f17016b;
        d r102 = new d("res_gecko_loader_secure");
        String r103 = this.f17017c;
        String r104 = this.f17018d;
        JSONObject r105 = new JSONObject();
        r105.put("channel", r103);
        r105.put("bundle", r104);
        r105.put("loader", "ResourceLoader");
        r102.f17022d = r105;
        r102.f17024f = Boolean.TRUE;
        Unit r106 = Unit.INSTANCE;
        r100.a(r101, r102);
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}

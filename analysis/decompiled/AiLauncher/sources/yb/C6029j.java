package yb;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import yb.InterfaceC6039t;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\u0003\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0003\u0010\u000bJ\u000f\u0010\f\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\bR\u001a\u0010\u0014\u001a\u00020\u00128\u0016X\u0096D¢\u0006\f\n\u0004\b\f\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lyb/j;", "Lyb/t$b;", "", "e", "<init>", "(Ljava/lang/Throwable;)V", "Lyb/t$a;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Lyb/t$a;", "c", "", "()Ljava/lang/Void;", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_APIKEY, "Lyb/t$a;", Const.INTENT_KEY_UMID, "result", "", "Z", "isReady", "()Z", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: yb.j, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6029j implements InterfaceC6039t.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC6039t.ConnectResult result;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final boolean isReady;

    public C6029j(Throwable e10) {
        kotlin.jvm.internal.p.i(e10, "e");
        this.result = new InterfaceC6039t.ConnectResult(this, null, e10, 2, null);
    }

    @Override // yb.InterfaceC6039t.b
    /* renamed from: a */
    public /* bridge */ /* synthetic */ C6033n getConnection() {
        return (C6033n) e();
    }

    @Override // yb.InterfaceC6039t.b, zb.InterfaceC6480d.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Void cancel() {
        throw new IllegalStateException("unexpected cancel");
    }

    @Override // yb.InterfaceC6039t.b
    /* renamed from: c, reason: from getter */
    public InterfaceC6039t.ConnectResult getResult() {
        return this.result;
    }

    public final InterfaceC6039t.ConnectResult d() {
        return this.result;
    }

    public Void e() {
        throw new IllegalStateException("unexpected call");
    }

    @Override // yb.InterfaceC6039t.b
    public /* bridge */ /* synthetic */ InterfaceC6039t.b f() {
        return (InterfaceC6039t.b) h();
    }

    @Override // yb.InterfaceC6039t.b
    public InterfaceC6039t.ConnectResult g() {
        return this.result;
    }

    public Void h() {
        throw new IllegalStateException("unexpected retry");
    }

    @Override // yb.InterfaceC6039t.b
    /* renamed from: isReady, reason: from getter */
    public boolean getIsReady() {
        return this.isReady;
    }
}

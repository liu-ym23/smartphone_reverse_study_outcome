package yb;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import yb.InterfaceC6039t;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\bJ\u000f\u0010\r\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u000e\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u00108\u0016X\u0096D¢\u0006\f\n\u0004\b\f\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lyb/r;", "Lyb/t$b;", "Lyb/n;", "connection", "<init>", "(Lyb/n;)V", "", Const.INTENT_KEY_UMID, "()Ljava/lang/Void;", "e", Const.INTENT_KEY_APIKEY, "()Lyb/n;", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Lyb/n;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "", "Z", "isReady", "()Z", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: yb.r, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6037r implements InterfaceC6039t.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final C6033n connection;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final boolean isReady;

    public C6037r(C6033n connection) {
        kotlin.jvm.internal.p.i(connection, "connection");
        this.connection = connection;
        this.isReady = true;
    }

    @Override // yb.InterfaceC6039t.b
    /* renamed from: a, reason: from getter */
    public C6033n getConnection() {
        return this.connection;
    }

    @Override // yb.InterfaceC6039t.b, zb.InterfaceC6480d.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Void cancel() {
        throw new IllegalStateException("unexpected cancel");
    }

    @Override // yb.InterfaceC6039t.b
    public /* bridge */ /* synthetic */ InterfaceC6039t.ConnectResult c() {
        return (InterfaceC6039t.ConnectResult) e();
    }

    public Void d() {
        throw new IllegalStateException("already connected");
    }

    public Void e() {
        throw new IllegalStateException("already connected");
    }

    @Override // yb.InterfaceC6039t.b
    public /* bridge */ /* synthetic */ InterfaceC6039t.b f() {
        return (InterfaceC6039t.b) i();
    }

    @Override // yb.InterfaceC6039t.b
    public /* bridge */ /* synthetic */ InterfaceC6039t.ConnectResult g() {
        return (InterfaceC6039t.ConnectResult) d();
    }

    public final C6033n h() {
        return this.connection;
    }

    public Void i() {
        throw new IllegalStateException("unexpected retry");
    }

    @Override // yb.InterfaceC6039t.b
    /* renamed from: isReady, reason: from getter */
    public boolean getIsReady() {
        return this.isReady;
    }
}

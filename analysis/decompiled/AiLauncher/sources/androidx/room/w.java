package androidx.room;

import com.autonavi.aps.amapapi.config.Const;
import i1.InterfaceC4160b;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\b'\u0018\u00002\u00020\u0001:\u0001\u0014B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000e\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u0012\u0010\rJ\u0017\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u0013\u0010\rJ\u0017\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u0014\u0010\rJ\u0017\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u0015\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001c\u0010\u001b¨\u0006\u001d"}, d2 = {"Landroidx/room/w;", "Landroidx/room/x;", "", "version", "", "identityHash", "legacyIdentityHash", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "Li1/b;", "connection", "LY8/t;", "f", "(Li1/b;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Landroidx/room/w$a;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Li1/b;)Landroidx/room/w$a;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "I", "e", "()I", "Ljava/lang/String;", "c", "()Ljava/lang/String;", Const.INTENT_KEY_UMID, "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class w implements x {
    private final String identityHash;
    private final String legacyIdentityHash;
    private final int version;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/room/w$a;", "", "", "isValid", "", "expectedFoundMsg", "<init>", "(ZLjava/lang/String;)V", Const.INTENT_KEY_APIKEY, "Z", Const.INTENT_KEY_PKGNAME, "Ljava/lang/String;", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final boolean isValid;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final String expectedFoundMsg;

        public a(boolean z10, String str) {
            this.isValid = z10;
            this.expectedFoundMsg = str;
        }
    }

    public w(int i10, String identityHash, String legacyIdentityHash) {
        kotlin.jvm.internal.p.i(identityHash, "identityHash");
        kotlin.jvm.internal.p.i(legacyIdentityHash, "legacyIdentityHash");
        this.version = i10;
        this.identityHash = identityHash;
        this.legacyIdentityHash = legacyIdentityHash;
    }

    public abstract void a(InterfaceC4160b connection);

    public abstract void b(InterfaceC4160b connection);

    /* renamed from: c, reason: from getter */
    public final String getIdentityHash() {
        return this.identityHash;
    }

    /* renamed from: d, reason: from getter */
    public final String getLegacyIdentityHash() {
        return this.legacyIdentityHash;
    }

    /* renamed from: e, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    public abstract void f(InterfaceC4160b connection);

    public abstract void g(InterfaceC4160b connection);

    public abstract void h(InterfaceC4160b connection);

    public abstract void i(InterfaceC4160b connection);

    public abstract a j(InterfaceC4160b connection);
}

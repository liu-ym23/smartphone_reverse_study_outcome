package e1;

import androidx.room.support.AutoCloser;
import androidx.room.support.AutoClosingRoomOpenHelper;
import com.autonavi.aps.amapapi.config.Const;
import j1.InterfaceC4757d;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\fR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Le1/f;", "Lj1/d$c;", "delegate", "Landroidx/room/support/AutoCloser;", "autoCloser", "<init>", "(Lj1/d$c;Landroidx/room/support/AutoCloser;)V", "Lj1/d$b;", "configuration", "Landroidx/room/support/AutoClosingRoomOpenHelper;", Const.INTENT_KEY_APIKEY, "(Lj1/d$b;)Landroidx/room/support/AutoClosingRoomOpenHelper;", "Lj1/d$c;", Const.INTENT_KEY_PKGNAME, "Landroidx/room/support/AutoCloser;", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class f implements InterfaceC4757d.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC4757d.c delegate;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final AutoCloser autoCloser;

    public f(InterfaceC4757d.c delegate, AutoCloser autoCloser) {
        p.i(delegate, "delegate");
        p.i(autoCloser, "autoCloser");
        this.delegate = delegate;
        this.autoCloser = autoCloser;
    }

    @Override // j1.InterfaceC4757d.c
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AutoClosingRoomOpenHelper create(InterfaceC4757d.b configuration) {
        p.i(configuration, "configuration");
        return new AutoClosingRoomOpenHelper(this.delegate.create(configuration), this.autoCloser);
    }
}

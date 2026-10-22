package androidx.room;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import f1.C4038h;
import i1.InterfaceC4160b;
import i1.InterfaceC4162d;
import kotlin.Metadata;
import n9.C4946a;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H$¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00028\u0000H$¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0010\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Landroidx/room/f;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", "", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/String;", "Li1/d;", "statement", Const.LBS_FAIL_BD_ENTITY, "LY8/t;", Const.INTENT_KEY_APIKEY, "(Li1/d;Ljava/lang/Object;)V", "Li1/b;", "connection", Const.INTENT_KEY_UMID, "(Li1/b;Ljava/lang/Object;)V", "", "entities", "c", "(Li1/b;Ljava/lang/Iterable;)V", "", "e", "(Li1/b;Ljava/lang/Object;)J", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: androidx.room.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1410f<T> {
    public abstract void a(InterfaceC4162d statement, T entity);

    public abstract String b();

    public final void c(InterfaceC4160b connection, Iterable<? extends T> entities) throws Exception {
        kotlin.jvm.internal.p.i(connection, "connection");
        if (entities == null) {
            return;
        }
        InterfaceC4162d interfaceC4162dQ1 = connection.q1(b());
        try {
            for (T t10 : entities) {
                if (t10 != null) {
                    a(interfaceC4162dQ1, t10);
                    interfaceC4162dQ1.n1();
                    interfaceC4162dQ1.reset();
                }
            }
            Y8.t tVar = Y8.t.f7040a;
            C4946a.a(interfaceC4162dQ1, null);
        } finally {
        }
    }

    public final void d(InterfaceC4160b connection, T entity) throws Exception {
        kotlin.jvm.internal.p.i(connection, "connection");
        if (entity == null) {
            return;
        }
        InterfaceC4162d interfaceC4162dQ1 = connection.q1(b());
        try {
            a(interfaceC4162dQ1, entity);
            interfaceC4162dQ1.n1();
            C4946a.a(interfaceC4162dQ1, null);
        } finally {
        }
    }

    public final long e(InterfaceC4160b connection, T entity) throws Exception {
        kotlin.jvm.internal.p.i(connection, "connection");
        if (entity == null) {
            return -1L;
        }
        InterfaceC4162d interfaceC4162dQ1 = connection.q1(b());
        try {
            a(interfaceC4162dQ1, entity);
            interfaceC4162dQ1.n1();
            C4946a.a(interfaceC4162dQ1, null);
            return C4038h.a(connection);
        } finally {
        }
    }
}

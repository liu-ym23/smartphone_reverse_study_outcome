package Ua;

import Ua.AbstractC1067l0;
import com.autonavi.aps.amapapi.config.Const;
import java.io.Closeable;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.coroutines.d;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 \u000b2\u00020\u00012\u00020\u00022\u00060\u0003j\u0002`\u0004:\u0001\fB\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"LUa/l0;", "LUa/I;", "Ljava/io/Closeable;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "<init>", "()V", "Ljava/util/concurrent/Executor;", "u1", "()Ljava/util/concurrent/Executor;", "executor", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: Ua.l0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC1067l0 extends I implements Closeable, AutoCloseable {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"LUa/l0$a;", "Lkotlin/coroutines/b;", "LUa/I;", "LUa/l0;", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: Ua.l0$a, reason: from kotlin metadata */
    public static final class Companion extends kotlin.coroutines.b<I, AbstractC1067l0> {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public static final AbstractC1067l0 d(d.b bVar) {
            if (bVar instanceof AbstractC1067l0) {
                return (AbstractC1067l0) bVar;
            }
            return null;
        }

        public Companion() {
            super(I.INSTANCE, new InterfaceC5074l() { // from class: Ua.k0
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return AbstractC1067l0.Companion.d((d.b) obj);
                }
            });
        }
    }

    public abstract Executor u1();
}

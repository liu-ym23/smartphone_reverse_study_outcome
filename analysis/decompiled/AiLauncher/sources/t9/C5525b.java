package t9;

import com.autonavi.aps.amapapi.config.Const;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lt9/b;", "Lt9/a;", "<init>", "()V", "t9/b$a", "c", "Lt9/b$a;", "implStorage", "Ljava/util/Random;", "l", "()Ljava/util/Random;", "impl", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: t9.b, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C5525b extends AbstractC5524a {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final a implStorage = new a();

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"t9/b$a", "Ljava/lang/ThreadLocal;", "Ljava/util/Random;", Const.INTENT_KEY_APIKEY, "()Ljava/util/Random;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: t9.b$a */
    public static final class a extends ThreadLocal<Random> {
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Random initialValue() {
            return new Random();
        }
    }

    @Override // t9.AbstractC5524a
    public Random l() {
        Random random = this.implStorage.get();
        p.h(random, "get(...)");
        return random;
    }
}

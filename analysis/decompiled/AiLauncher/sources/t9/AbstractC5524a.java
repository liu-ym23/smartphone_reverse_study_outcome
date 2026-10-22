package t9;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.random.Random;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\u0007J\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00168&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lt9/a;", "Lkotlin/random/Random;", "<init>", "()V", "", "bitCount", Const.INTENT_KEY_PKGNAME, "(I)I", "f", "()I", "until", Const.INTENT_KEY_BACKGROUND_COMMAND, "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()J", "", "e", "()F", "", "array", "c", "([B)[B", "Ljava/util/Random;", "l", "()Ljava/util/Random;", "impl", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: t9.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC5524a extends Random {
    @Override // kotlin.random.Random
    public int b(int bitCount) {
        return C5526c.g(l().nextInt(), bitCount);
    }

    @Override // kotlin.random.Random
    public byte[] c(byte[] array) {
        p.i(array, "array");
        l().nextBytes(array);
        return array;
    }

    @Override // kotlin.random.Random
    public float e() {
        return l().nextFloat();
    }

    @Override // kotlin.random.Random
    public int f() {
        return l().nextInt();
    }

    @Override // kotlin.random.Random
    public int g(int until) {
        return l().nextInt(until);
    }

    @Override // kotlin.random.Random
    public long i() {
        return l().nextLong();
    }

    public abstract java.util.Random l();
}

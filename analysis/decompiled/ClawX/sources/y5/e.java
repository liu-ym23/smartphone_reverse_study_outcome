package y5;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e {
    public static f a(int i8, long j4) {
        long j8 = i8;
        long j9 = j8 / 1000000000;
        if ((j8 ^ 1000000000) < 0 && j9 * 1000000000 != j8) {
            j9--;
        }
        long j10 = j4 + j9;
        if ((j4 ^ j10) < 0 && (j9 ^ j4) >= 0) {
            return j4 > 0 ? f.f6348e : f.d;
        }
        if (j10 < -31557014167219200L) {
            return f.d;
        }
        if (j10 > 31556889864403199L) {
            return f.f6348e;
        }
        long j11 = j8 % 1000000000;
        return new f((int) (j11 + ((((j11 ^ 1000000000) & ((-j11) | j11)) >> 63) & 1000000000)), j10);
    }
}

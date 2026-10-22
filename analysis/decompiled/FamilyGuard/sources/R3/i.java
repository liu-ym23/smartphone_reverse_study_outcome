package R3;

/* loaded from: classes.dex */
public final class i {
    public static int a(int i5) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i5 - 1));
    }
}

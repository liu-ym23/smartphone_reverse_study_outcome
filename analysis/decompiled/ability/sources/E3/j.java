package E3;

import androidx.profileinstaller.ProfileVerifier;
import java.util.BitSet;

/* loaded from: classes3.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final BitSet f470a;
    public static final BitSet b;
    public static final BitSet c;
    public static final BitSet d;
    public static final BitSet e;
    public static final BitSet f;
    public static final BitSet g;
    public static final BitSet h;
    public static final BitSet i;

    /* renamed from: j, reason: collision with root package name */
    public static final BitSet f471j;

    static {
        BitSet bitSet = new BitSet(69632);
        f470a = bitSet;
        BitSet bitSet2 = new BitSet(69632);
        b = bitSet2;
        BitSet bitSet3 = new BitSet(8192);
        c = bitSet3;
        BitSet bitSet4 = new BitSet(1536);
        d = bitSet4;
        BitSet bitSet5 = new BitSet(208896);
        e = bitSet5;
        f = new BitSet(1114112);
        g = new BitSet(1114112);
        h = new BitSet(1114112);
        i = new BitSet(1114112);
        f471j = new BitSet(1114112);
        bitSet.set(1632, 1642);
        bitSet2.set(1776, 1786);
        bitSet3.set(880, 1024);
        bitSet3.set(7936, 8192);
        bitSet4.set(1424, 1536);
        bitSet5.set(11904, 12032);
        bitSet5.set(12032, 12256);
        bitSet5.set(12288, 12352);
        bitSet5.set(12352, 12448);
        bitSet5.set(12448, 12544);
        bitSet5.set(13312, 19904);
        bitSet5.set(19968, 40960);
        bitSet5.set(63744, 64256);
        bitSet5.set(94176, 94208);
        bitSet5.set(131072, 173792);
        bitSet5.set(173824, 177984);
        bitSet5.set(177984, 178208);
        bitSet5.set(178208, 183984);
        bitSet5.set(183984, 191472);
        bitSet5.set(194560, 195104);
        bitSet5.set(ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 201552);
        bitSet5.set(201552, 205744);
    }

    public static synchronized void a() {
        if (g.isEmpty()) {
            i.a("/ucd/extracted/DerivedJoiningType.txt", new d(1));
        }
    }
}

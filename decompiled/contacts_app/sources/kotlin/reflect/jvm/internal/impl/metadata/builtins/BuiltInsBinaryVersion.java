package kotlin.reflect.jvm.internal.impl.metadata.builtins;

import com.obric.aikernel.sdk.ext.CozeCloudExt;
import java.io.DataInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;

/* JADX INFO: compiled from: BuiltInsBinaryVersion.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class BuiltInsBinaryVersion extends BinaryVersion {
    public static final Companion Companion = null;
    public static final BuiltInsBinaryVersion INSTANCE = null;
    public static final BuiltInsBinaryVersion INVALID_VERSION = null;

    /* JADX INFO: compiled from: BuiltInsBinaryVersion.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final BuiltInsBinaryVersion readFrom(InputStream r3) {
            Intrinsics.checkNotNullParameter(r3, CozeCloudExt.API_KEY_HTTP_STREAM_METHOD);
            DataInputStream r2 = new DataInputStream(r3);
            IntRange r4 = new IntRange(1, r2.readInt());
            ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
            Iterator<Integer> r5 = r4.iterator();
        L4:
            if (r5.hasNext() == false) goto L6;
            ((IntIterator) r5).nextInt();
            r0.add(Integer.valueOf(r2.readInt()));
            goto L4
        L6:
            int[] r6 = CollectionsKt.toIntArray(r0);
            return new BuiltInsBinaryVersion(Arrays.copyOf(r6, r6.length));
        }
    }

    public BuiltInsBinaryVersion(int... r2) {
        Intrinsics.checkNotNullParameter(r2, "numbers");
        super(Arrays.copyOf(r2, r2.length));
    }

    public boolean isCompatible() {
        return isCompatibleTo(INSTANCE);
    }

    static {
        Companion = new Companion(null);
        INSTANCE = new BuiltInsBinaryVersion(new int[]{1, 0, 7});
        INVALID_VERSION = new BuiltInsBinaryVersion(new int[0]);
    }
}

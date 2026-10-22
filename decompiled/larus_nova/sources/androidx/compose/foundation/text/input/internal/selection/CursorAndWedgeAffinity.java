package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.text.input.internal.WedgeAffinity;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmInline;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0081@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB\u001b\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010\u0010\u001a\u00020\u0007H\u0086\u0002¢\u0006\u0004\b\u0011\u0010\rJ\u0012\u0010\u0012\u001a\u0004\u0018\u00010\nH\u0086\u0002¢\u0006\u0004\b\u0013\u0010\u000fJ\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u001a"}, d2 = {"Landroidx/compose/foundation/text/input/internal/selection/CursorAndWedgeAffinity;", "", "value", "", "constructor-impl", "(J)J", EffectConfiguration.KEY_CURSOR, "", "(I)J", "wedgeAffinity", "Landroidx/compose/foundation/text/input/internal/WedgeAffinity;", "(ILandroidx/compose/foundation/text/input/internal/WedgeAffinity;)J", "getCursor-impl", "(J)I", "getWedgeAffinity-impl", "(J)Landroidx/compose/foundation/text/input/internal/WedgeAffinity;", "component1", "component1-impl", "component2", "component2-impl", "equals", "", "other", "hashCode", "toString", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class CursorAndWedgeAffinity {
    private final long value;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[WedgeAffinity.values().length];
            r100[WedgeAffinity.Start.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[WedgeAffinity.End.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r100;
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ CursorAndWedgeAffinity m1331boximpl(long r100) {
        return new CursorAndWedgeAffinity(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m1336constructorimpl(long r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1337equalsimpl(long r100, Object r101) {
        if ((r101 instanceof CursorAndWedgeAffinity) == true) goto L6;
        return false;
    L6:
        if (r100 == ((CursorAndWedgeAffinity) r101).m1343unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1338equalsimpl0(long r100, long r101) {
        if (r100 != r101) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: getCursor-impl, reason: not valid java name */
    public static final int m1339getCursorimpl(long r100) {
        return (int) (r100 >> 32);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1341hashCodeimpl(long r100) {
        return (int) (r100 ^ (r100 >>> 32));
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1342toStringimpl(long r100) {
        return "CursorAndWedgeAffinity(value=" + r100 + ')';
    }

    public boolean equals(Object r100) {
        return m1337equalsimpl(this.value, r100);
    }

    public int hashCode() {
        return m1341hashCodeimpl(this.value);
    }

    public String toString() {
        return m1342toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m1343unboximpl() {
        return this.value;
    }

    private /* synthetic */ CursorAndWedgeAffinity(long r100) {
        this.value = r100;
    }

    /* JADX INFO: renamed from: component1-impl, reason: not valid java name */
    public static final int m1332component1impl(long r100) {
        return m1339getCursorimpl(r100);
    }

    /* JADX INFO: renamed from: component2-impl, reason: not valid java name */
    public static final WedgeAffinity m1333component2impl(long r100) {
        return m1340getWedgeAffinityimpl(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m1334constructorimpl(int r100) {
        return m1336constructorimpl((((long) r100) << 32) | (((long) (-1)) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: getWedgeAffinity-impl, reason: not valid java name */
    public static final WedgeAffinity m1340getWedgeAffinityimpl(long r100) {
        int r101 = (int) (r100 & BodyPartID.bodyIdMax);
        if (r101 >= 0) goto L5;
        return null;
    L5:
        if (r101 != 0) goto L8;
        return WedgeAffinity.Start;
    L8:
        return WedgeAffinity.End;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m1335constructorimpl(int r100, WedgeAffinity r101) {
        int r102 = -1;
        if (r101 != null) goto L5;
        int r103 = -1;
    L6:
        if (r103 == (-1)) goto L16;
        r102 = 1;
        if (r103 != 1) goto L10;
        r102 = 0;
        goto L16
    L10:
        if (r103 == 2) goto L16;
        throw new NoWhenBranchMatchedException();
    L16:
        return m1336constructorimpl((((long) r100) << 32) | (((long) r102) & BodyPartID.bodyIdMax));
    L5:
        r103 = WhenMappings.$EnumSwitchMapping$0[r101.ordinal()];
        goto L6
    }
}

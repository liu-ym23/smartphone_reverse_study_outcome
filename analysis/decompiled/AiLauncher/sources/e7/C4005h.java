package e7;

import Z8.Y;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \u000b2\u00020\u0001:\u0001\u0007B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\tR\u001a\u0010\u0004\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\b\u001a\u0004\b\n\u0010\t¨\u0006\f"}, d2 = {"Le7/h;", "Le7/m;", "", "maxCharsPerChunk", "overlapChars", "<init>", "(II)V", Const.INTENT_KEY_APIKEY, "I", "()I", Const.INTENT_KEY_PKGNAME, "Companion", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: e7.h, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C4005h implements m {

    /* renamed from: c, reason: collision with root package name */
    public static final Set<Character> f32318c = Y.j(12290, 65281, 65311, '.', '!', '?', ';', 65307);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final int maxCharsPerChunk;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final int overlapChars;

    public C4005h(int i10, int i11) {
        this.maxCharsPerChunk = i10;
        this.overlapChars = i11;
        if (getMaxCharsPerChunk() <= 0) {
            throw new IllegalArgumentException("maxCharsPerChunk must be > 0");
        }
        int maxCharsPerChunk = getMaxCharsPerChunk();
        int overlapChars = getOverlapChars();
        if (overlapChars < 0 || overlapChars >= maxCharsPerChunk) {
            throw new IllegalArgumentException(("overlapChars (" + getOverlapChars() + ") must be in [0, maxCharsPerChunk=" + getMaxCharsPerChunk() + ")").toString());
        }
    }

    /* renamed from: a, reason: from getter */
    public int getMaxCharsPerChunk() {
        return this.maxCharsPerChunk;
    }

    /* renamed from: b, reason: from getter */
    public int getOverlapChars() {
        return this.overlapChars;
    }

    public /* synthetic */ C4005h(int i10, int i11, int i12, kotlin.jvm.internal.i iVar) {
        this((i12 & 1) != 0 ? Const.I_TILE_TINY : i10, (i12 & 2) != 0 ? 50 : i11);
    }
}

package fb;

import com.autonavi.aps.amapapi.config.Const;
import io.ktor.http.ContentDisposition;
import io.ktor.util.date.GMTDateParser;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0019\n\u0002\b\u0005\u001a'\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a'\u0010\t\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\t\u0010\u0006\"\u001a\u0010\u000e\u001a\u00020\n8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"", ContentDisposition.Parameters.Size, "offset", "byteCount", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(JJJ)V", "startIndex", "endIndex", Const.INTENT_KEY_APIKEY, "", "[C", "c", "()[C", "HEX_DIGIT_CHARS", "kotlinx-io-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f32635a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', GMTDateParser.DAY_OF_MONTH, 'e', 'f'};

    public static final void a(long j10, long j11, long j12) {
        if (j11 < 0 || j12 > j10) {
            throw new IndexOutOfBoundsException("startIndex (" + j11 + ") and endIndex (" + j12 + ") are not within the range [0..size(" + j10 + "))");
        }
        if (j11 <= j12) {
            return;
        }
        throw new IllegalArgumentException("startIndex (" + j11 + ") > endIndex (" + j12 + ')');
    }

    public static final void b(long j10, long j11, long j12) {
        if (j11 < 0 || j11 > j10 || j10 - j11 < j12 || j12 < 0) {
            throw new IllegalArgumentException("offset (" + j11 + ") and byteCount (" + j12 + ") are not within the range [0..size(" + j10 + "))");
        }
    }

    public static final char[] c() {
        return f32635a;
    }
}

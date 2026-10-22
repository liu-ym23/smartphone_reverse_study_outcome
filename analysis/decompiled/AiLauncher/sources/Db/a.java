package Db;

import Mb.InterfaceC0967e;
import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u0001B!\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0015\u001a\u0004\b\u0018\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"LDb/a;", "", "", "sections", "ranges", "mappings", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "codePoint", "LMb/e;", "sink", "", "c", "(ILMb/e;)Z", Const.INTENT_KEY_PKGNAME, "(I)I", "position", "limit", Const.INTENT_KEY_APIKEY, "(III)I", "Ljava/lang/String;", "getSections", "()Ljava/lang/String;", "getRanges", "getMappings", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String sections;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final String ranges;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final String mappings;

    public a(String sections, String ranges, String mappings) {
        p.i(sections, "sections");
        p.i(ranges, "ranges");
        p.i(mappings, "mappings");
        this.sections = sections;
        this.ranges = ranges;
        this.mappings = mappings;
    }

    public final int a(int codePoint, int position, int limit) {
        int i10;
        int i11 = codePoint & 127;
        int i12 = limit - 1;
        while (true) {
            if (position > i12) {
                i10 = (-position) - 1;
                break;
            }
            i10 = (position + i12) / 2;
            int iK = p.k(i11, this.ranges.charAt(i10 * 4));
            if (iK >= 0) {
                if (iK <= 0) {
                    break;
                }
                position = i10 + 1;
            } else {
                i12 = i10 - 1;
            }
        }
        return i10 >= 0 ? i10 * 4 : ((-i10) - 2) * 4;
    }

    public final int b(int codePoint) {
        int i10;
        int i11 = (codePoint & 2097024) >> 7;
        int length = (this.sections.length() / 4) - 1;
        int i12 = 0;
        while (true) {
            if (i12 > length) {
                i10 = (-i12) - 1;
                break;
            }
            i10 = (i12 + length) / 2;
            int iK = p.k(i11, c.a(this.sections, i10 * 4));
            if (iK >= 0) {
                if (iK <= 0) {
                    break;
                }
                i12 = i10 + 1;
            } else {
                length = i10 - 1;
            }
        }
        return i10 >= 0 ? i10 * 4 : ((-i10) - 2) * 4;
    }

    public final boolean c(int codePoint, InterfaceC0967e sink) throws IOException {
        p.i(sink, "sink");
        int iB = b(codePoint);
        int iA = a(codePoint, c.a(this.sections, iB + 2), iB + 4 < this.sections.length() ? c.a(this.sections, iB + 6) : this.ranges.length() / 4);
        char cCharAt = this.ranges.charAt(iA + 1);
        if (cCharAt >= 0 && cCharAt < '@') {
            int iA2 = c.a(this.ranges, iA + 2);
            sink.R(this.mappings, iA2, cCharAt + iA2);
            return true;
        }
        if ('@' <= cCharAt && cCharAt < 'P') {
            sink.z(codePoint - (this.ranges.charAt(iA + 3) | (((cCharAt & 15) << 14) | (this.ranges.charAt(iA + 2) << 7))));
            return true;
        }
        if ('P' <= cCharAt && cCharAt < '`') {
            sink.z(codePoint + (this.ranges.charAt(iA + 3) | ((cCharAt & 15) << 14) | (this.ranges.charAt(iA + 2) << 7)));
            return true;
        }
        if (cCharAt == 'w') {
            t tVar = t.f7040a;
            return true;
        }
        if (cCharAt == 'x') {
            sink.z(codePoint);
            return true;
        }
        if (cCharAt == 'y') {
            sink.z(codePoint);
            return false;
        }
        if (cCharAt == 'z') {
            sink.writeByte(this.ranges.charAt(iA + 2));
            return true;
        }
        if (cCharAt == '{') {
            sink.writeByte(this.ranges.charAt(iA + 2) | 128);
            return true;
        }
        if (cCharAt == '|') {
            sink.writeByte(this.ranges.charAt(iA + 2));
            sink.writeByte(this.ranges.charAt(iA + 3));
            return true;
        }
        if (cCharAt == '}') {
            sink.writeByte(this.ranges.charAt(iA + 2) | 128);
            sink.writeByte(this.ranges.charAt(iA + 3));
            return true;
        }
        if (cCharAt == '~') {
            sink.writeByte(this.ranges.charAt(iA + 2));
            sink.writeByte(this.ranges.charAt(iA + 3) | 128);
            return true;
        }
        if (cCharAt == 127) {
            sink.writeByte(this.ranges.charAt(iA + 2) | 128);
            sink.writeByte(this.ranges.charAt(iA + 3) | 128);
            return true;
        }
        throw new IllegalStateException(("unexpected rangesIndex for " + codePoint).toString());
    }
}

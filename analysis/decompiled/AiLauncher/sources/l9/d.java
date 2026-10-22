package l9;

import com.autonavi.aps.amapapi.config.Const;
import io.ktor.http.ContentDisposition;
import java.io.ByteArrayOutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\t\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Ll9/d;", "Ljava/io/ByteArrayOutputStream;", "", ContentDisposition.Parameters.Size, "<init>", "(I)V", "", Const.INTENT_KEY_PKGNAME, "()[B", "buffer", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class d extends ByteArrayOutputStream {
    public d(int i10) {
        super(i10);
    }

    public final byte[] b() {
        byte[] buf = ((ByteArrayOutputStream) this).buf;
        p.h(buf, "buf");
        return buf;
    }
}

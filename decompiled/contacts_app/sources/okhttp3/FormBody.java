package okhttp3;

import com.ss.android.http.legacy.utils.URLEncodedUtils;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;

/* JADX INFO: loaded from: classes5.dex */
public final class FormBody extends RequestBody {
    private static final MediaType CONTENT_TYPE = null;
    private final List<String> encodedNames;
    private final List<String> encodedValues;

    public static final class Builder {
        private final Charset charset;
        private final List<String> names;
        private final List<String> values;

        public Builder() {
            this(null);
        }

        public Builder(Charset r2) {
            this.names = new ArrayList();
            this.values = new ArrayList();
            this.charset = r2;
        }

        public Builder add(String r9, String r10) {
            if (r9 == null) goto L9;
            if (r10 == null) goto L7;
            this.names.add(HttpUrl.canonicalize(r9, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.charset));
            this.values.add(HttpUrl.canonicalize(r10, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.charset));
            return this;
        L7:
            throw new NullPointerException("value == null");
        L9:
            throw new NullPointerException("name == null");
        }

        public Builder addEncoded(String r9, String r10) {
            if (r9 == null) goto L9;
            if (r10 == null) goto L7;
            this.names.add(HttpUrl.canonicalize(r9, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.charset));
            this.values.add(HttpUrl.canonicalize(r10, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.charset));
            return this;
        L7:
            throw new NullPointerException("value == null");
        L9:
            throw new NullPointerException("name == null");
        }

        public FormBody build() {
            return new FormBody(this.names, this.values);
        }
    }

    static {
        CONTENT_TYPE = MediaType.get(URLEncodedUtils.CONTENT_TYPE);
    }

    FormBody(List<String> r1, List<String> r2) {
        this.encodedNames = Util.immutableList(r1);
        this.encodedValues = Util.immutableList(r2);
    }

    public int size() {
        return this.encodedNames.size();
    }

    public String encodedName(int r1) {
        return this.encodedNames.get(r1);
    }

    public String name(int r1) {
        return HttpUrl.percentDecode(encodedName(r1), true);
    }

    public String encodedValue(int r1) {
        return this.encodedValues.get(r1);
    }

    public String value(int r1) {
        return HttpUrl.percentDecode(encodedValue(r1), true);
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return CONTENT_TYPE;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        return writeOrCountBytes(null, true);
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink r2) throws IOException {
        writeOrCountBytes(r2, false);
    }

    private long writeOrCountBytes(@Nullable BufferedSink r4, boolean r5) {
        if (r5 == false) goto L4;
        Buffer r6 = new Buffer();
    L5:
        int r0 = this.encodedNames.size();
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L10;
        if (r1 <= 0) goto L9;
        r6.writeByte(38);
    L9:
        r6.writeUtf8(this.encodedNames.get(r1));
        r6.writeByte(61);
        r6.writeUtf8(this.encodedValues.get(r1));
        r1 = r1 + 1;
        goto L6
    L10:
        if (r5 == false) goto L12;
        long r2 = r6.size();
        r6.clear();
        return r2;
    L12:
        return 0;
    L4:
        r6 = r4.buffer();
        goto L5
    }
}

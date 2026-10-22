package kotlinx.serialization.json.io.internal;

import com.stepos.stepclaw.SecurePrefs;
import j6.i;
import j6.k;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.json.internal.InternalJsonWriter;
import kotlinx.serialization.json.internal.StringOpsKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0011\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096\u0080\u0004J\u0012\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0080\u0004J\u0012\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0096\u0080\u0004J\u0012\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0096\u0080\u0004J\n\u0010\u0011\u001a\u00020\u0007H\u0096\u0080\u0004R\u000f\u0010\u0002\u001a\u00020\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkotlinx/serialization/json/io/internal/JsonToIoStreamWriter;", "Lkotlinx/serialization/json/internal/InternalJsonWriter;", "sink", "Lkotlinx/io/Sink;", "<init>", "(Lkotlinx/io/Sink;)V", "writeLong", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "value", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "writeChar", "char", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "write", "text", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "writeQuoted", "release", "kotlinx-serialization-json-io"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public final class JsonToIoStreamWriter implements InternalJsonWriter {
    private final i sink;

    public JsonToIoStreamWriter(i sink) {
        p.e(sink, "sink");
        this.sink = sink;
    }

    @Override // kotlinx.serialization.json.internal.InternalJsonWriter
    public void write(String text) {
        p.e(text, "text");
        k.i(this.sink, text, 0, text.length());
    }

    @Override // kotlinx.serialization.json.internal.InternalJsonWriter
    public void writeChar(char c3) {
        k.h(this.sink, c3);
    }

    @Override // kotlinx.serialization.json.internal.InternalJsonWriter
    public void writeLong(long value) {
        write(String.valueOf(value));
    }

    @Override // kotlinx.serialization.json.internal.InternalJsonWriter
    public void writeQuoted(String text) {
        p.e(text, "text");
        k.h(this.sink, 34);
        int length = text.length();
        int i8 = 0;
        for (int i9 = 0; i9 < length; i9++) {
            char cCharAt = text.charAt(i9);
            if (cCharAt < StringOpsKt.getESCAPE_STRINGS().length && StringOpsKt.getESCAPE_STRINGS()[cCharAt] != null) {
                k.i(this.sink, text, i8, i9);
                String str = StringOpsKt.getESCAPE_STRINGS()[cCharAt];
                p.b(str);
                k.i(this.sink, str, 0, str.length());
                i8 = i9 + 1;
            }
        }
        k.i(this.sink, text, i8, text.length());
        k.h(this.sink, 34);
    }

    @Override // kotlinx.serialization.json.internal.InternalJsonWriter
    public void release() {
    }
}

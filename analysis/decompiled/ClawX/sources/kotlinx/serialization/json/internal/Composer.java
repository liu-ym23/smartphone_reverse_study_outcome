package kotlinx.serialization.json.internal;

import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\f\n\u0002\u0010\u000e\n\u0002\u0010\u0007\n\u0002\u0010\u0006\n\u0002\u0010\u0005\n\u0002\u0010\n\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0011\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\r\u001a\u00020\u000eH\u0096\u0080\u0004J\n\u0010\u000f\u001a\u00020\u000eH\u0096\u0080\u0004J\n\u0010\u0010\u001a\u00020\u000eH\u0096\u0080\u0004J\n\u0010\u0011\u001a\u00020\u000eH\u0096\u0080\u0004J\n\u0010\u0012\u001a\u00020\u000eH\u0096\u0080\u0004J\u0012\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0086\u0080\u0004J\u0012\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0016H\u0086\u0080\u0004J\u0012\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0017H\u0096\u0080\u0004J\u0012\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0018H\u0096\u0080\u0004J\u0012\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0019H\u0096\u0080\u0004J\u0012\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u001aH\u0096\u0080\u0004J\u0012\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u001bH\u0096\u0080\u0004J\u0012\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u001cH\u0096\u0080\u0004J\u0012\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0007H\u0096\u0080\u0004J\u0012\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0016H\u0096\u0080\u0004R\u0011\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0084\b¢\u0006\u0002\n\u0000R%\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@DX\u0086\u008e\b¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u001e"}, d2 = {"Lkotlinx/serialization/json/internal/Composer;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "writer", "Lkotlinx/serialization/json/internal/InternalJsonWriter;", "<init>", "(Lkotlinx/serialization/json/internal/InternalJsonWriter;)V", "value", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "writingFirst", "getWritingFirst", "()Z", "setWritingFirst", "(Z)V", "indent", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "unIndent", "nextItem", "nextItemIfNotFirst", "space", "print", "v", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "printQuoted", "kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public class Composer {
    public final InternalJsonWriter writer;
    private boolean writingFirst;

    public Composer(InternalJsonWriter writer) {
        p.e(writer, "writer");
        this.writer = writer;
        this.writingFirst = true;
    }

    public final boolean getWritingFirst() {
        return this.writingFirst;
    }

    public void indent() {
        this.writingFirst = true;
    }

    public void nextItem() {
        this.writingFirst = false;
    }

    public void nextItemIfNotFirst() {
        this.writingFirst = false;
    }

    public final void print(char v8) {
        this.writer.writeChar(v8);
    }

    public void printQuoted(String value) {
        p.e(value, "value");
        this.writer.writeQuoted(value);
    }

    public final void setWritingFirst(boolean z) {
        this.writingFirst = z;
    }

    public final void print(String v8) {
        p.e(v8, "v");
        this.writer.write(v8);
    }

    public void print(float v8) {
        this.writer.write(String.valueOf(v8));
    }

    public void print(double v8) {
        this.writer.write(String.valueOf(v8));
    }

    public void print(byte v8) {
        this.writer.writeLong(v8);
    }

    public void print(short v8) {
        this.writer.writeLong(v8);
    }

    public void print(int v8) {
        this.writer.writeLong(v8);
    }

    public void print(long v8) {
        this.writer.writeLong(v8);
    }

    public void print(boolean v8) {
        this.writer.write(String.valueOf(v8));
    }

    public void space() {
    }

    public void unIndent() {
    }
}

package kotlinx.serialization.json.internal;

import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@JsonFriendModuleApi
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\t\bF¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00020\u0005H¦\u0080\u0004J\n\u0010\u0006\u001a\u00020\u0007H¦\u0080\u0004J\"\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0086\u0080\u0004R\u0013\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u008e\b¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u0010"}, d2 = {"Lkotlinx/serialization/json/internal/InternalJsonReaderCodePointImpl;", "Lkotlinx/serialization/json/internal/InternalJsonReader;", "<init>", "()V", "exhausted", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "nextCodePoint", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "bufferedChar", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Ljava/lang/Character;", "read", "buffer", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "bufferOffset", "count", "kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class InternalJsonReaderCodePointImpl implements InternalJsonReader {
    private Character bufferedChar;

    public abstract boolean exhausted();

    public abstract int nextCodePoint();

    @Override // kotlinx.serialization.json.internal.InternalJsonReader
    public final int read(char[] buffer, int bufferOffset, int count) {
        int i8;
        p.e(buffer, "buffer");
        Character ch = this.bufferedChar;
        if (ch != null) {
            p.b(ch);
            buffer[bufferOffset] = ch.charValue();
            this.bufferedChar = null;
            i8 = 1;
        } else {
            i8 = 0;
        }
        while (i8 < count && !exhausted()) {
            int iNextCodePoint = nextCodePoint();
            if (iNextCodePoint <= 65535) {
                buffer[bufferOffset + i8] = (char) iNextCodePoint;
                i8++;
            } else {
                char c3 = (char) ((iNextCodePoint >>> 10) + 55232);
                char c8 = (char) ((iNextCodePoint & 1023) + 56320);
                buffer[bufferOffset + i8] = c3;
                int i9 = i8 + 1;
                if (i9 < count) {
                    buffer[i9 + bufferOffset] = c8;
                    i8 += 2;
                } else {
                    this.bufferedChar = Character.valueOf(c8);
                    i8 = i9;
                }
            }
        }
        if (i8 > 0) {
            return i8;
        }
        return -1;
    }
}

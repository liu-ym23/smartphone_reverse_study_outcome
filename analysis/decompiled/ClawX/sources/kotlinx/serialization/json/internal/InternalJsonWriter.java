package kotlinx.serialization.json.internal;

import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p5.q;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@JsonFriendModuleApi
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bg\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eJ\u0012\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦\u0080\u0004J\u0012\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH¦\u0080\u0004J\u0012\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH¦\u0080\u0004J\u0012\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH¦\u0080\u0004J\n\u0010\r\u001a\u00020\u0003H¦\u0080\u0004¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lkotlinx/serialization/json/internal/InternalJsonWriter;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "writeLong", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "value", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "writeChar", "char", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "write", "text", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "writeQuoted", "release", "Companion", "kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public interface InternalJsonWriter {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003Jb\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072K\u0010\b\u001aG\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\f¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\f¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00050\tH\u0086\u0088\u0004ø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000f"}, d2 = {"Lkotlinx/serialization/json/internal/InternalJsonWriter$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "doWriteEscaping", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "text", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "writeImpl", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "startIndex", "endIndex", "kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final void doWriteEscaping(String text, q writeImpl) {
            p.e(text, "text");
            p.e(writeImpl, "writeImpl");
            int length = text.length();
            int i8 = 0;
            for (int i9 = 0; i9 < length; i9++) {
                char cCharAt = text.charAt(i9);
                if (cCharAt < StringOpsKt.getESCAPE_STRINGS().length && StringOpsKt.getESCAPE_STRINGS()[cCharAt] != null) {
                    writeImpl.invoke(text, Integer.valueOf(i8), Integer.valueOf(i9));
                    String str = StringOpsKt.getESCAPE_STRINGS()[cCharAt];
                    p.b(str);
                    writeImpl.invoke(str, 0, Integer.valueOf(str.length()));
                    i8 = i9 + 1;
                }
            }
            writeImpl.invoke(text, Integer.valueOf(i8), Integer.valueOf(text.length()));
        }
    }

    void release();

    void write(String text);

    void writeChar(char c3);

    void writeLong(long value);

    void writeQuoted(String text);
}

package kotlinx.serialization.json.internal;

import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\f\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\bB\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0084\b¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0084\b¢\u0006\u0002\n\u0000j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lkotlinx/serialization/json/internal/WriteMode;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "begin", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "end", "<init>", "(Ljava/lang/String;ICC)V", "OBJ", "LIST", "MAP", "POLY_OBJ", "kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public final class WriteMode {
    private static final /* synthetic */ i5.a $ENTRIES;
    private static final /* synthetic */ WriteMode[] $VALUES;
    public final char begin;
    public final char end;
    public static final WriteMode OBJ = new WriteMode("OBJ", 0, AbstractJsonLexerKt.BEGIN_OBJ, AbstractJsonLexerKt.END_OBJ);
    public static final WriteMode LIST = new WriteMode("LIST", 1, AbstractJsonLexerKt.BEGIN_LIST, AbstractJsonLexerKt.END_LIST);
    public static final WriteMode MAP = new WriteMode("MAP", 2, AbstractJsonLexerKt.BEGIN_OBJ, AbstractJsonLexerKt.END_OBJ);
    public static final WriteMode POLY_OBJ = new WriteMode("POLY_OBJ", 3, AbstractJsonLexerKt.BEGIN_LIST, AbstractJsonLexerKt.END_LIST);

    private static final /* synthetic */ WriteMode[] $values() {
        return new WriteMode[]{OBJ, LIST, MAP, POLY_OBJ};
    }

    static {
        WriteMode[] writeModeArr$values = $values();
        $VALUES = writeModeArr$values;
        $ENTRIES = a.a.F(writeModeArr$values);
    }

    private WriteMode(String str, int i8, char c3, char c8) {
        this.begin = c3;
        this.end = c8;
    }

    public static i5.a getEntries() {
        return $ENTRIES;
    }

    public static WriteMode valueOf(String str) {
        return (WriteMode) Enum.valueOf(WriteMode.class, str);
    }

    public static WriteMode[] values() {
        return (WriteMode[]) $VALUES.clone();
    }
}

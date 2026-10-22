package kotlin.text;

import com.bytedance.apm.constant.CommonKey;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u001d\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006\u001f"}, d2 = {"Lkotlin/text/CharDirectionality;", "", "", CommonKey.KEY_VALUE, "<init>", "(Ljava/lang/String;II)V", "I", "getValue", "()I", "Companion", "a", "UNDEFINED", "LEFT_TO_RIGHT", "RIGHT_TO_LEFT", "RIGHT_TO_LEFT_ARABIC", "EUROPEAN_NUMBER", "EUROPEAN_NUMBER_SEPARATOR", "EUROPEAN_NUMBER_TERMINATOR", "ARABIC_NUMBER", "COMMON_NUMBER_SEPARATOR", "NONSPACING_MARK", "BOUNDARY_NEUTRAL", "PARAGRAPH_SEPARATOR", "SEGMENT_SEPARATOR", "WHITESPACE", "OTHER_NEUTRALS", "LEFT_TO_RIGHT_EMBEDDING", "LEFT_TO_RIGHT_OVERRIDE", "RIGHT_TO_LEFT_EMBEDDING", "RIGHT_TO_LEFT_OVERRIDE", "POP_DIRECTIONAL_FORMAT", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum CharDirectionality extends Enum<CharDirectionality> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ CharDirectionality[] $VALUES = null;
    public static final CharDirectionality ARABIC_NUMBER = null;
    public static final CharDirectionality BOUNDARY_NEUTRAL = null;
    public static final CharDirectionality COMMON_NUMBER_SEPARATOR = null;

    @NotNull
    public static final a Companion = null;
    public static final CharDirectionality EUROPEAN_NUMBER = null;
    public static final CharDirectionality EUROPEAN_NUMBER_SEPARATOR = null;
    public static final CharDirectionality EUROPEAN_NUMBER_TERMINATOR = null;
    public static final CharDirectionality LEFT_TO_RIGHT = null;
    public static final CharDirectionality LEFT_TO_RIGHT_EMBEDDING = null;
    public static final CharDirectionality LEFT_TO_RIGHT_OVERRIDE = null;
    public static final CharDirectionality NONSPACING_MARK = null;
    public static final CharDirectionality OTHER_NEUTRALS = null;
    public static final CharDirectionality PARAGRAPH_SEPARATOR = null;
    public static final CharDirectionality POP_DIRECTIONAL_FORMAT = null;
    public static final CharDirectionality RIGHT_TO_LEFT = null;
    public static final CharDirectionality RIGHT_TO_LEFT_ARABIC = null;
    public static final CharDirectionality RIGHT_TO_LEFT_EMBEDDING = null;
    public static final CharDirectionality RIGHT_TO_LEFT_OVERRIDE = null;
    public static final CharDirectionality SEGMENT_SEPARATOR = null;
    public static final CharDirectionality UNDEFINED = null;
    public static final CharDirectionality WHITESPACE = null;

    @NotNull
    private static final Lazy<Map<Integer, CharDirectionality>> directionalityMap$delegate = null;
    private final int value;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    private static final /* synthetic */ CharDirectionality[] $values() {
        return new CharDirectionality[]{UNDEFINED, LEFT_TO_RIGHT, RIGHT_TO_LEFT, RIGHT_TO_LEFT_ARABIC, EUROPEAN_NUMBER, EUROPEAN_NUMBER_SEPARATOR, EUROPEAN_NUMBER_TERMINATOR, ARABIC_NUMBER, COMMON_NUMBER_SEPARATOR, NONSPACING_MARK, BOUNDARY_NEUTRAL, PARAGRAPH_SEPARATOR, SEGMENT_SEPARATOR, WHITESPACE, OTHER_NEUTRALS, LEFT_TO_RIGHT_EMBEDDING, LEFT_TO_RIGHT_OVERRIDE, RIGHT_TO_LEFT_EMBEDDING, RIGHT_TO_LEFT_OVERRIDE, POP_DIRECTIONAL_FORMAT};
    }

    static {
        UNDEFINED = new CharDirectionality("UNDEFINED", 0, -1);
        LEFT_TO_RIGHT = new CharDirectionality("LEFT_TO_RIGHT", 1, 0);
        RIGHT_TO_LEFT = new CharDirectionality("RIGHT_TO_LEFT", 2, 1);
        RIGHT_TO_LEFT_ARABIC = new CharDirectionality("RIGHT_TO_LEFT_ARABIC", 3, 2);
        EUROPEAN_NUMBER = new CharDirectionality("EUROPEAN_NUMBER", 4, 3);
        EUROPEAN_NUMBER_SEPARATOR = new CharDirectionality("EUROPEAN_NUMBER_SEPARATOR", 5, 4);
        EUROPEAN_NUMBER_TERMINATOR = new CharDirectionality("EUROPEAN_NUMBER_TERMINATOR", 6, 5);
        ARABIC_NUMBER = new CharDirectionality("ARABIC_NUMBER", 7, 6);
        COMMON_NUMBER_SEPARATOR = new CharDirectionality("COMMON_NUMBER_SEPARATOR", 8, 7);
        NONSPACING_MARK = new CharDirectionality("NONSPACING_MARK", 9, 8);
        BOUNDARY_NEUTRAL = new CharDirectionality("BOUNDARY_NEUTRAL", 10, 9);
        PARAGRAPH_SEPARATOR = new CharDirectionality("PARAGRAPH_SEPARATOR", 11, 10);
        SEGMENT_SEPARATOR = new CharDirectionality("SEGMENT_SEPARATOR", 12, 11);
        WHITESPACE = new CharDirectionality("WHITESPACE", 13, 12);
        OTHER_NEUTRALS = new CharDirectionality("OTHER_NEUTRALS", 14, 13);
        LEFT_TO_RIGHT_EMBEDDING = new CharDirectionality("LEFT_TO_RIGHT_EMBEDDING", 15, 14);
        LEFT_TO_RIGHT_OVERRIDE = new CharDirectionality("LEFT_TO_RIGHT_OVERRIDE", 16, 15);
        RIGHT_TO_LEFT_EMBEDDING = new CharDirectionality("RIGHT_TO_LEFT_EMBEDDING", 17, 16);
        RIGHT_TO_LEFT_OVERRIDE = new CharDirectionality("RIGHT_TO_LEFT_OVERRIDE", 18, 17);
        POP_DIRECTIONAL_FORMAT = new CharDirectionality("POP_DIRECTIONAL_FORMAT", 19, 18);
        CharDirectionality[] r10 = $values();
        $VALUES = r10;
        $ENTRIES = kotlin.enums.a.a(r10);
        Companion = new a(null);
        directionalityMap$delegate = kotlin.b.b(CharDirectionality$Companion$directionalityMap$2.INSTANCE);
    }

    private CharDirectionality(String r10, int r11, int r12) {
        super(r10, r11);
        this.value = r12;
    }

    public static final /* synthetic */ Lazy access$getDirectionalityMap$delegate$cp() {
        return directionalityMap$delegate;
    }

    @NotNull
    public static EnumEntries<CharDirectionality> getEntries() {
        return $ENTRIES;
    }

    public static CharDirectionality valueOf(String r10) {
        return (CharDirectionality) Enum.valueOf(CharDirectionality.class, r10);
    }

    public static CharDirectionality[] values() {
        return (CharDirectionality[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }
}

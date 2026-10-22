package kotlinx.serialization.json.internal;

import a6.w;
import a8.b;
import com.stepos.stepclaw.SecurePrefs;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.json.Json;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B'\bF\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000e\u001a\u00028\u0000H\u0096\u0082\u0004¢\u0006\u0002\u0010\u000fJ\n\u0010\u0010\u001a\u00020\fH\u0096\u0082\u0004R\u000f\u0010\u0003\u001a\u00020\u0004X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0005\u001a\u00020\u0006X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\u000b\u001a\u00020\fX\u0082\u008e\b¢\u0006\u0002\n\u0000R\u000f\u0010\r\u001a\u00020\fX\u0082\u008e\b¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lkotlinx/serialization/json/internal/JsonIteratorArrayWrapped;", "T", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "json", "Lkotlinx/serialization/json/Json;", "lexer", "Lkotlinx/serialization/json/internal/ReaderJsonLexer;", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "<init>", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/internal/ReaderJsonLexer;Lkotlinx/serialization/DeserializationStrategy;)V", "first", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "finished", "next", "()Ljava/lang/Object;", "hasNext", "kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
final class JsonIteratorArrayWrapped<T> implements Iterator<T>, q5.a {
    private final DeserializationStrategy<T> deserializer;
    private boolean finished;
    private boolean first;
    private final Json json;
    private final ReaderJsonLexer lexer;

    /* JADX WARN: Multi-variable type inference failed */
    public JsonIteratorArrayWrapped(Json json, ReaderJsonLexer lexer, DeserializationStrategy<? extends T> deserializer) {
        p.e(json, "json");
        p.e(lexer, "lexer");
        p.e(deserializer, "deserializer");
        this.json = json;
        this.lexer = lexer;
        this.deserializer = deserializer;
        this.first = true;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.finished) {
            return false;
        }
        if (this.lexer.peekNextToken() == 9) {
            this.finished = true;
            this.lexer.consumeNextToken((byte) 9);
            if (this.lexer.isNotEof()) {
                if (this.lexer.peekNextToken() == 8) {
                    AbstractJsonLexer.fail$default(this.lexer, "There is a start of the new array after the one parsed to sequence. ARRAY_WRAPPED mode doesn't merge consecutive arrays.\nIf you need to parse a stream of arrays, please use WHITESPACE_SEPARATED mode instead.", 0, null, 6, null);
                    throw new w();
                }
                this.lexer.expectEof();
            }
            return false;
        }
        if (this.lexer.isNotEof() || this.finished) {
            return true;
        }
        ReaderJsonLexer readerJsonLexer = this.lexer;
        String str = AbstractJsonLexerKt.tokenDescription((byte) 9);
        int i8 = readerJsonLexer.currentPosition;
        int i9 = i8 - 1;
        AbstractJsonLexer.fail$default(readerJsonLexer, b.q("Expected ", str, ", but had '", (i8 == readerJsonLexer.getSource().length() || i9 < 0) ? "EOF" : String.valueOf(readerJsonLexer.getSource().charAt(i9)), "' instead"), i9, null, 4, null);
        throw new w();
    }

    @Override // java.util.Iterator
    public T next() {
        if (this.first) {
            this.first = false;
        } else {
            this.lexer.consumeNextToken(AbstractJsonLexerKt.COMMA);
        }
        return (T) new StreamingJsonDecoder(this.json, WriteMode.OBJ, this.lexer, this.deserializer.getDescriptor(), null).decodeSerializableValue(this.deserializer);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

package kotlinx.serialization.json.internal;

import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.json.Json;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0019\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\n\u001a\u00020\u000bH\u0096\u0080\u0004J\n\u0010\f\u001a\u00020\u000bH\u0096\u0080\u0004J\n\u0010\r\u001a\u00020\u000bH\u0096\u0080\u0004J\n\u0010\u000e\u001a\u00020\u000bH\u0096\u0080\u0004J\n\u0010\u000f\u001a\u00020\u000bH\u0096\u0080\u0004R\u000f\u0010\u0004\u001a\u00020\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\b\u001a\u00020\tX\u0082\u008e\b¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkotlinx/serialization/json/internal/ComposerWithPrettyPrint;", "Lkotlinx/serialization/json/internal/Composer;", "writer", "Lkotlinx/serialization/json/internal/InternalJsonWriter;", "json", "Lkotlinx/serialization/json/Json;", "<init>", "(Lkotlinx/serialization/json/internal/InternalJsonWriter;Lkotlinx/serialization/json/Json;)V", "level", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "indent", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "unIndent", "nextItem", "nextItemIfNotFirst", "space", "kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ComposerWithPrettyPrint extends Composer {
    private final Json json;
    private int level;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposerWithPrettyPrint(InternalJsonWriter writer, Json json) {
        super(writer);
        p.e(writer, "writer");
        p.e(json, "json");
        this.json = json;
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void indent() {
        setWritingFirst(true);
        this.level++;
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void nextItem() {
        setWritingFirst(false);
        print("\n");
        int i8 = this.level;
        for (int i9 = 0; i9 < i8; i9++) {
            print(this.json.getConfiguration().getPrettyPrintIndent());
        }
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void nextItemIfNotFirst() {
        if (getWritingFirst()) {
            setWritingFirst(false);
        } else {
            nextItem();
        }
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void space() {
        print(' ');
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void unIndent() {
        this.level--;
    }
}

package kotlinx.serialization.json.io.internal;

import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.provider.contract.ExtensionCallContract;
import j6.a;
import j6.j;
import j6.k;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.json.internal.InternalJsonReaderCodePointImpl;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0011\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0006\u001a\u00020\u0007H\u0096\u0080\u0004J\n\u0010\b\u001a\u00020\tH\u0096\u0080\u0004R\u000f\u0010\u0002\u001a\u00020\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkotlinx/serialization/json/io/internal/IoSerialReader;", "Lkotlinx/serialization/json/internal/InternalJsonReaderCodePointImpl;", ExtensionCallContract.SOURCE, "Lkotlinx/io/Source;", "<init>", "(Lkotlinx/io/Source;)V", "exhausted", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "nextCodePoint", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "kotlinx-serialization-json-io"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes.dex */
public final class IoSerialReader extends InternalJsonReaderCodePointImpl {
    private final j source;

    public IoSerialReader(j source) {
        p.e(source, "source");
        this.source = source;
    }

    @Override // kotlinx.serialization.json.internal.InternalJsonReaderCodePointImpl
    public boolean exhausted() {
        return this.source.q();
    }

    @Override // kotlinx.serialization.json.internal.InternalJsonReaderCodePointImpl
    public int nextCodePoint() {
        j jVar = this.source;
        p.e(jVar, "<this>");
        if (jVar instanceof a) {
            return k.d((a) jVar);
        }
        jVar.f(1L);
        byte bA = jVar.c().a(0L);
        if ((bA & 224) == 192) {
            jVar.f(2L);
        } else if ((bA & 240) == 224) {
            jVar.f(3L);
        } else if ((bA & 248) == 240) {
            jVar.f(4L);
        }
        return k.d(jVar.c());
    }
}

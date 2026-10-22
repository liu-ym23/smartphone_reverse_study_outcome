package bytekn.foundation.io.file;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/nio/charset/Charset;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class FileManager$readFile$charset$1 extends Lambda implements Function0<Charset> {
    final /* synthetic */ ContentEncoding $encoding;

    public FileManager$readFile$charset$1(ContentEncoding r100) {
        this.$encoding = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Charset invoke2() {
        ContentEncoding r100 = this.$encoding;
        if (c.f21787a[r100.ordinal()] == 1) goto L6;
        return Charsets.UTF_8;
    L6:
        return Charsets.US_ASCII;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Charset invoke() {
        return invoke2();
    }
}

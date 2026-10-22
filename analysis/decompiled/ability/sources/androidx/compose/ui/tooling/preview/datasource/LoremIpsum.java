package androidx.compose.ui.tooling.preview.datasource;

import D7.q;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.tooling.preview.PreviewParameterProvider;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.voicewakeup.service.d;
import i9.C1567b;
import i9.C1569d;
import i9.InterfaceC1568c;
import i9.i;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.sequences.a;

@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\t\b\u0016¢\u0006\u0004\b\u0005\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\nR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/tooling/preview/datasource/LoremIpsum;", "Landroidx/compose/ui/tooling/preview/PreviewParameterProvider;", "", "", "words", AppAgent.CONSTRUCT, "(I)V", "()V", "generateLoremIpsum", "(I)Ljava/lang/String;", "I", "Li9/i;", "getValues", "()Li9/i;", "values", "ui-tooling-preview"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public class LoremIpsum implements PreviewParameterProvider<String> {
    public static final int $stable = 0;
    private final int words;

    public LoremIpsum(int i) {
        this.words = i;
    }

    private final String generateLoremIpsum(int words) {
        i iVarJ0 = a.j0(new d(new Ref$IntRef(), LoremIpsum_androidKt.LOREM_IPSUM_SOURCE.size(), 2));
        if (words >= 0) {
            return a.l0(words == 0 ? C1569d.f4618a : iVarJ0 instanceof InterfaceC1568c ? ((InterfaceC1568c) iVarJ0).b(words) : new C1567b(iVarJ0, words, 1), " ");
        }
        throw new IllegalArgumentException(androidx.appfunctions.metadata.a.i(words, "Requested element count ", " is less than zero.").toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String generateLoremIpsum$lambda$0(Ref$IntRef ref$IntRef, int i) {
        List list = LoremIpsum_androidKt.LOREM_IPSUM_SOURCE;
        int i6 = ref$IntRef.f4918a;
        ref$IntRef.f4918a = i6 + 1;
        return (String) list.get(i6 % i);
    }

    @Override // androidx.compose.ui.tooling.preview.PreviewParameterProvider
    public i getValues() {
        return q.M(new String[]{generateLoremIpsum(this.words)});
    }

    public LoremIpsum() {
        this(500);
    }
}

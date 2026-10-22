package androidx.compose.foundation.text;

import S7.k;
import androidx.compose.runtime.Stable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Stable
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0097\u0001\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R%\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R%\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0017\u0010\u0016R%\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R%\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0019\u0010\u0016R%\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016R%\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016¨\u0006\u001d"}, d2 = {"Landroidx/compose/foundation/text/KeyboardActions;", "", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/KeyboardActionScope;", "LC7/r;", "onDone", "onGo", "onNext", "onPrevious", "onSearch", "onSend", AppAgent.CONSTRUCT, "(LS7/k;LS7/k;LS7/k;LS7/k;LS7/k;LS7/k;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "LS7/k;", "getOnDone", "()LS7/k;", "getOnGo", "getOnNext", "getOnPrevious", "getOnSearch", "getOnSend", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class KeyboardActions {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KeyboardActions Default = new KeyboardActions(null, null, null, null, null, null, 63, null);
    private final k onDone;
    private final k onGo;
    private final k onNext;
    private final k onPrevious;
    private final k onSearch;
    private final k onSend;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/text/KeyboardActions$Companion;", "", "()V", "Default", "Landroidx/compose/foundation/text/KeyboardActions;", "getDefault$annotations", "getDefault", "()Landroidx/compose/foundation/text/KeyboardActions;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        @Stable
        public static /* synthetic */ void getDefault$annotations() {
        }

        public final KeyboardActions getDefault() {
            return KeyboardActions.Default;
        }

        private Companion() {
        }
    }

    public KeyboardActions() {
        this(null, null, null, null, null, null, 63, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KeyboardActions)) {
            return false;
        }
        KeyboardActions keyboardActions = (KeyboardActions) other;
        return this.onDone == keyboardActions.onDone && this.onGo == keyboardActions.onGo && this.onNext == keyboardActions.onNext && this.onPrevious == keyboardActions.onPrevious && this.onSearch == keyboardActions.onSearch && this.onSend == keyboardActions.onSend;
    }

    public final k getOnDone() {
        return this.onDone;
    }

    public final k getOnGo() {
        return this.onGo;
    }

    public final k getOnNext() {
        return this.onNext;
    }

    public final k getOnPrevious() {
        return this.onPrevious;
    }

    public final k getOnSearch() {
        return this.onSearch;
    }

    public final k getOnSend() {
        return this.onSend;
    }

    public int hashCode() {
        k kVar = this.onDone;
        int iHashCode = (kVar != null ? kVar.hashCode() : 0) * 31;
        k kVar2 = this.onGo;
        int iHashCode2 = (iHashCode + (kVar2 != null ? kVar2.hashCode() : 0)) * 31;
        k kVar3 = this.onNext;
        int iHashCode3 = (iHashCode2 + (kVar3 != null ? kVar3.hashCode() : 0)) * 31;
        k kVar4 = this.onPrevious;
        int iHashCode4 = (iHashCode3 + (kVar4 != null ? kVar4.hashCode() : 0)) * 31;
        k kVar5 = this.onSearch;
        int iHashCode5 = (iHashCode4 + (kVar5 != null ? kVar5.hashCode() : 0)) * 31;
        k kVar6 = this.onSend;
        return iHashCode5 + (kVar6 != null ? kVar6.hashCode() : 0);
    }

    public KeyboardActions(k kVar, k kVar2, k kVar3, k kVar4, k kVar5, k kVar6) {
        this.onDone = kVar;
        this.onGo = kVar2;
        this.onNext = kVar3;
        this.onPrevious = kVar4;
        this.onSearch = kVar5;
        this.onSend = kVar6;
    }

    public /* synthetic */ KeyboardActions(k kVar, k kVar2, k kVar3, k kVar4, k kVar5, k kVar6, int i, e eVar) {
        this((i & 1) != 0 ? null : kVar, (i & 2) != 0 ? null : kVar2, (i & 4) != 0 ? null : kVar3, (i & 8) != 0 ? null : kVar4, (i & 16) != 0 ? null : kVar5, (i & 32) != 0 ? null : kVar6);
    }
}

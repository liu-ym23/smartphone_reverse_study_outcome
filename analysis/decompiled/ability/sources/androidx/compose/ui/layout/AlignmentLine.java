package androidx.compose.ui.layout;

import S7.n;
import androidx.compose.runtime.Immutable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Immutable
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \n2\u00020\u0001:\u0001\nB#\b\u0004\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006R,\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0007\u001a\u0004\b\b\u0010\t\u0082\u0001\u0002\u000b\f¨\u0006\r"}, d2 = {"Landroidx/compose/ui/layout/AlignmentLine;", "", "Lkotlin/Function2;", "", "merger", AppAgent.CONSTRUCT, "(LS7/n;)V", "LS7/n;", "getMerger$ui_release", "()LS7/n;", "Companion", "Landroidx/compose/ui/layout/HorizontalAlignmentLine;", "Landroidx/compose/ui/layout/VerticalAlignmentLine;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class AlignmentLine {
    public static final int $stable = 0;
    public static final int Unspecified = Integer.MIN_VALUE;
    private final n merger;

    public /* synthetic */ AlignmentLine(n nVar, e eVar) {
        this(nVar);
    }

    /* renamed from: getMerger$ui_release, reason: from getter */
    public final n getMerger() {
        return this.merger;
    }

    private AlignmentLine(n nVar) {
        this.merger = nVar;
    }
}

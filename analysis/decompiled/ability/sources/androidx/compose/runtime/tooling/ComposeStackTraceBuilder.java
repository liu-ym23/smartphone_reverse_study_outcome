package androidx.compose.runtime.tooling;

import androidx.compose.foundation.b;
import androidx.compose.runtime.Anchor;
import androidx.compose.runtime.GroupSourceInformation;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import j9.t;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\b!\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\b\u0010\tJ#\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0012\u001a\u00020\u0011*\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u001c\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u001c\u0010\tJ\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001e\u001a\u00020\u001dH&¢\u0006\u0004\b\u000f\u0010\u001fJ\u0017\u0010!\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\u001dH&¢\u0006\u0004\b!\u0010\"R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000b0#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006&"}, d2 = {"Landroidx/compose/runtime/tooling/ComposeStackTraceBuilder;", "", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/runtime/GroupSourceInformation;", "groupSourceInformation", "child", "LC7/r;", "appendTraceFrame", "(Landroidx/compose/runtime/GroupSourceInformation;Ljava/lang/Object;)V", "targetChild", "Landroidx/compose/runtime/tooling/ComposeStackTraceFrame;", "extractTraceFrame", "(Landroidx/compose/runtime/GroupSourceInformation;Ljava/lang/Object;)Landroidx/compose/runtime/tooling/ComposeStackTraceFrame;", "group", "sourceInformationOf", "(Ljava/lang/Object;)Landroidx/compose/runtime/GroupSourceInformation;", "", "isCall", "(Landroidx/compose/runtime/GroupSourceInformation;)Z", "sourceInformation", TypedValues.AttributesType.S_TARGET, "findInGroupSourceInformation", "(Landroidx/compose/runtime/GroupSourceInformation;Ljava/lang/Object;)Z", "", "trace", "()Ljava/util/List;", "childData", "processEdge", "Landroidx/compose/runtime/Anchor;", "anchor", "(Landroidx/compose/runtime/Anchor;)Landroidx/compose/runtime/GroupSourceInformation;", "", "groupKeyOf", "(Landroidx/compose/runtime/Anchor;)I", "", "_trace", "Ljava/util/List;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ComposeStackTraceBuilder {
    public static final int $stable = 8;
    private final List<ComposeStackTraceFrame> _trace = new ArrayList();

    private final void appendTraceFrame(GroupSourceInformation groupSourceInformation, Object child) {
        ComposeStackTraceFrame composeStackTraceFrameExtractTraceFrame = extractTraceFrame(groupSourceInformation, child);
        if (composeStackTraceFrameExtractTraceFrame != null) {
            this._trace.add(composeStackTraceFrameExtractTraceFrame);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final androidx.compose.runtime.tooling.ComposeStackTraceFrame extractTraceFrame(androidx.compose.runtime.GroupSourceInformation r12, java.lang.Object r13) {
        /*
            r11 = this;
            java.lang.String r0 = r12.getSourceInformation()
            r1 = 0
            if (r0 == 0) goto Lc
            androidx.compose.runtime.tooling.SourceInformation r0 = androidx.compose.runtime.tooling.SourceInformationKt.parseSourceInformation(r0)
            goto Ld
        Lc:
            r0 = r1
        Ld:
            if (r0 == 0) goto L97
            if (r13 != 0) goto L17
            androidx.compose.runtime.tooling.ComposeStackTraceFrame r11 = new androidx.compose.runtime.tooling.ComposeStackTraceFrame
            r11.<init>(r0, r1)
            return r11
        L17:
            java.util.ArrayList r12 = r12.getGroups()
            r2 = 0
            if (r12 == 0) goto L8d
            int r3 = r12.size()
            r4 = r2
            r5 = r4
        L24:
            if (r4 >= r3) goto L8c
            java.lang.Object r6 = r12.get(r4)
            boolean r7 = kotlin.jvm.internal.k.b(r6, r13)
            if (r7 != 0) goto L8c
            androidx.compose.runtime.GroupSourceInformation r7 = r11.sourceInformationOf(r6)
            r8 = 1
            if (r7 == 0) goto L7f
            int r9 = r7.getKey()
            r10 = -127(0xffffffffffffff81, float:NaN)
            if (r9 == r10) goto L51
            int r9 = r7.getKey()
            if (r9 != 0) goto L7f
            boolean r9 = r6 instanceof androidx.compose.runtime.Anchor
            if (r9 == 0) goto L7f
            androidx.compose.runtime.Anchor r6 = (androidx.compose.runtime.Anchor) r6
            int r6 = r11.groupKeyOf(r6)
            if (r6 != r10) goto L7f
        L51:
            if (r7 == 0) goto L58
            java.lang.String r6 = r7.getSourceInformation()
            goto L59
        L58:
            r6 = r1
        L59:
            if (r6 != 0) goto L7f
            if (r7 == 0) goto L89
            java.util.ArrayList r6 = r7.getGroups()
            if (r6 == 0) goto L89
            int r7 = r6.size()
            r9 = r2
        L68:
            if (r9 >= r7) goto L89
            java.lang.Object r10 = r6.get(r9)
            androidx.compose.runtime.GroupSourceInformation r10 = r11.sourceInformationOf(r10)
            if (r10 == 0) goto L7c
            boolean r10 = r11.isCall(r10)
            if (r10 != r8) goto L7c
            int r5 = r5 + 1
        L7c:
            int r9 = r9 + 1
            goto L68
        L7f:
            if (r7 == 0) goto L89
            boolean r6 = r11.isCall(r7)
            if (r6 != r8) goto L89
            int r5 = r5 + 1
        L89:
            int r4 = r4 + 1
            goto L24
        L8c:
            r2 = r5
        L8d:
            androidx.compose.runtime.tooling.ComposeStackTraceFrame r11 = new androidx.compose.runtime.tooling.ComposeStackTraceFrame
            java.lang.Integer r12 = java.lang.Integer.valueOf(r2)
            r11.<init>(r0, r12)
            return r11
        L97:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.tooling.ComposeStackTraceBuilder.extractTraceFrame(androidx.compose.runtime.GroupSourceInformation, java.lang.Object):androidx.compose.runtime.tooling.ComposeStackTraceFrame");
    }

    private final boolean findInGroupSourceInformation(GroupSourceInformation sourceInformation, Object target) {
        ArrayList<Object> groups = sourceInformation.getGroups();
        boolean z10 = false;
        if (groups != null) {
            int size = groups.size();
            for (int i = 0; i < size; i++) {
                Object obj = groups.get(i);
                if (obj instanceof Anchor) {
                    if (k.b(obj, target)) {
                        appendTraceFrame(sourceInformation, obj);
                        return true;
                    }
                } else {
                    if (!(obj instanceof GroupSourceInformation)) {
                        throw new IllegalStateException(b.r(obj, "Unexpected child source info "));
                    }
                    if (findInGroupSourceInformation((GroupSourceInformation) obj, target)) {
                        appendTraceFrame(sourceInformation, obj);
                        return true;
                    }
                }
            }
            return false;
        }
        if (!sourceInformation.getClosed()) {
            appendTraceFrame(sourceInformation, null);
            return true;
        }
        int dataStartOffset = sourceInformation.getDataStartOffset();
        int dataEndOffset = sourceInformation.getDataEndOffset();
        if (target instanceof Integer) {
            Number number = (Number) target;
            int iIntValue = number.intValue();
            if ((dataStartOffset <= iIntValue && iIntValue < dataEndOffset) || (dataStartOffset == dataEndOffset && target != null && dataStartOffset == number.intValue())) {
                z10 = true;
            }
            if (z10) {
                appendTraceFrame(sourceInformation, null);
            }
        }
        return z10;
    }

    private final boolean isCall(GroupSourceInformation groupSourceInformation) {
        String sourceInformation = groupSourceInformation.getSourceInformation();
        return sourceInformation != null && t.e0(sourceInformation, "C", false);
    }

    private final GroupSourceInformation sourceInformationOf(Object group) {
        if (group instanceof Anchor) {
            return sourceInformationOf((Anchor) group);
        }
        if (group instanceof GroupSourceInformation) {
            return (GroupSourceInformation) group;
        }
        throw new IllegalStateException(b.r(group, "Unexpected child source info "));
    }

    public abstract int groupKeyOf(Anchor anchor);

    public final void processEdge(GroupSourceInformation sourceInformation, Object childData) {
        if (sourceInformation != null) {
            if (childData == null) {
                appendTraceFrame(sourceInformation, null);
            } else {
                if (findInGroupSourceInformation(sourceInformation, childData) || sourceInformation.getClosed()) {
                    return;
                }
                appendTraceFrame(sourceInformation, null);
            }
        }
    }

    public abstract GroupSourceInformation sourceInformationOf(Anchor anchor);

    public final List<ComposeStackTraceFrame> trace() {
        return this._trace;
    }
}

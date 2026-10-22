package androidx.compose.runtime.tooling;

import androidx.compose.runtime.Anchor;
import androidx.compose.runtime.GroupSourceInformation;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b!\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bJ\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0002J\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0011\u001a\u00020\u0001H\u0002J\f\u0010\u0012\u001a\u00020\u0013*\u00020\fH\u0002J\u001a\u0010\u0014\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001J\u0018\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0001H\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0019\u001a\u00020\u001aH&J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u001aH&R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Landroidx/compose/runtime/tooling/ComposeStackTraceBuilder;", "", "<init>", "()V", "_trace", "", "Landroidx/compose/runtime/tooling/ComposeStackTraceFrame;", "trace", "", "appendTraceFrame", "", "groupSourceInformation", "Landroidx/compose/runtime/GroupSourceInformation;", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "extractTraceFrame", "targetChild", "sourceInformationOf", "group", "isCall", "", "processEdge", "sourceInformation", "childData", "findInGroupSourceInformation", PickerReporterConstants.KEY.TARGET, "anchor", "Landroidx/compose/runtime/Anchor;", "groupKeyOf", "", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class ComposeStackTraceBuilder {
    public static final int $stable = 8;
    private final List<ComposeStackTraceFrame> _trace;

    public abstract int groupKeyOf(Anchor r100);

    public abstract GroupSourceInformation sourceInformationOf(Anchor r100);

    public ComposeStackTraceBuilder() {
        this._trace = new ArrayList();
    }

    public final List<ComposeStackTraceFrame> trace() {
        return this._trace;
    }

    private final boolean isCall(GroupSourceInformation r100) {
        String r101 = r100.getSourceInformation();
        if (r101 != null) goto L5;
        return false;
    L5:
        if (StringsKt.startsWith$default(r101, "C", false, 2, null) != true) goto L9;
        return true;
    L9:
        return false;
    }

    private final GroupSourceInformation sourceInformationOf(Object r100) {
        if ((r100 instanceof Anchor) == false) goto L6;
        return sourceInformationOf((Anchor) r100);
    L6:
        if ((r100 instanceof GroupSourceInformation) == false) goto L10;
        return (GroupSourceInformation) r100;
    L10:
        throw new IllegalStateException(("Unexpected child source info " + r100).toString());
    }

    private final void appendTraceFrame(GroupSourceInformation r100, Object r101) {
        ComposeStackTraceFrame r102 = extractTraceFrame(r100, r101);
        if (r102 == null) goto L6;
        this._trace.add(r102);
        return;
    }

    private final ComposeStackTraceFrame extractTraceFrame(GroupSourceInformation r110, Object r111) {
        String r100 = r110.getSourceInformation();
        if (r100 == null) goto L5;
        SourceInformation r101 = SourceInformationKt.parseSourceInformation(r100);
    L6:
        if (r101 == null) goto L58;
        if (r111 == null) goto L9;
        ArrayList<Object> r112 = r110.getGroups();
        int r102 = 0;
        if (r112 == null) goto L57;
        int r103 = r112.size();
        int r104 = 0;
        int r105 = 0;
    L13:
        if (r104 >= r103) goto L55;
        Object r106 = ListProtector.get(r112, r104);
        if (Intrinsics.areEqual(r106, r111) == true) goto L55;
        GroupSourceInformation r107 = sourceInformationOf(r106);
        boolean r108 = true;
        if (r107 != null) goto L19;
    L27:
        boolean r109 = false;
    L28:
        if (r109 == false) goto L47;
        if (r107 == null) goto L31;
        String r113 = r107.getSourceInformation();
    L32:
        if (r113 != null) goto L47;
        if (r107 == null) goto L54;
        ArrayList<Object> r114 = r107.getGroups();
        if (r114 == null) goto L54;
        int r115 = r114.size();
        int r116 = 0;
    L37:
        if (r116 >= r115) goto L54;
        GroupSourceInformation r117 = sourceInformationOf(ListProtector.get(r114, r116));
        if (r117 != null) goto L41;
    L43:
        boolean r118 = false;
    L44:
        if (r118 == false) goto L46;
        r105 = r105 + 1;
    L46:
        r116 = r116 + 1;
        goto L37
    L41:
        if (isCall(r117) != true) goto L43;
        r118 = true;
    L54:
        r104 = r104 + 1;
        goto L13
    L31:
        r113 = null;
    L47:
        if (r107 != null) goto L49;
    L51:
        r108 = false;
    L52:
        if (r108 == false) goto L54;
        r105 = r105 + 1;
        goto L54
    L49:
        if (isCall(r107) != true) goto L51;
    L19:
        if (r107.getKey() != (-127)) goto L21;
    L26:
        r109 = true;
        goto L28
    L21:
        if (r107.getKey() != 0) goto L27;
        if ((r106 instanceof Anchor) == false) goto L27;
        if (groupKeyOf((Anchor) r106) != (-127)) goto L27;
    L55:
        r102 = r105;
    L57:
        return new ComposeStackTraceFrame(r101, Integer.valueOf(r102));
    L9:
        return new ComposeStackTraceFrame(r101, null);
    L58:
        return null;
    L5:
        r101 = null;
        goto L6
    }

    private final boolean findInGroupSourceInformation(GroupSourceInformation r100, Object r101) {
        ArrayList<Object> r102 = r100.getGroups();
        boolean r103 = true;
        if (r102 == null) goto L5;
        int r104 = r102.size();
        int r105 = 0;
    L28:
        if (r105 >= r104) goto L44;
        Object r106 = ListProtector.get(r102, r105);
        if ((r106 instanceof Anchor) == false) goto L36;
        if (Intrinsics.areEqual(r106, r101) == false) goto L41;
        appendTraceFrame(r100, r106);
        return true;
    L41:
        r105 = r105 + 1;
        goto L28
    L36:
        if ((r106 instanceof GroupSourceInformation) == false) goto L43;
        if (findInGroupSourceInformation((GroupSourceInformation) r106, r101) == false) goto L41;
        appendTraceFrame(r100, r106);
        return true;
    L43:
        throw new IllegalStateException(("Unexpected child source info " + r106).toString());
    L44:
        return false;
    L5:
        if (r100.getClosed() == true) goto L8;
        appendTraceFrame(r100, null);
        return true;
    L8:
        int r107 = r100.getDataStartOffset();
        int r108 = r100.getDataEndOffset();
        boolean r109 = r101 instanceof Integer;
        if (r109 == false) goto L26;
        Number r110 = (Number) r101;
        int r111 = r110.intValue();
        if (r107 > r111) goto L14;
        if (r111 >= r108) goto L14;
        boolean r112 = true;
    L15:
        if (r112 == true) goto L23;
        if (r107 != r108) goto L22;
        if (r109 == false) goto L22;
        if (r107 == r110.intValue()) goto L23;
    L22:
        r103 = false;
    L23:
        if (r103 == false) goto L25;
        appendTraceFrame(r100, null);
    L25:
        return r103;
    L14:
        r112 = false;
        goto L15
    L26:
        return false;
    }

    public final void processEdge(GroupSourceInformation r100, Object r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r101 != null) goto L7;
        appendTraceFrame(r100, null);
        return;
    L7:
        if (findInGroupSourceInformation(r100, r101) == false) goto L9;
        return;
    L9:
        if (r100.getClosed() == true) goto L15;
        appendTraceFrame(r100, null);
        return;
    }
}

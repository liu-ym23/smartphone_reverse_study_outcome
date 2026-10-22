package androidx.compose.runtime;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.pitaya.api.PTYSocketStateCallback;
import com.larus.trace.CopyContentTypeString;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010!\u001a\u00020\"2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0003J\u000e\u0010$\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0003J\u0016\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0003J\u0016\u0010%\u001a\u00020\"2\u0006\u0010)\u001a\u00020*2\u0006\u0010(\u001a\u00020\u0003J\u001e\u0010+\u001a\u00020\"2\u0006\u0010&\u001a\u00020'2\u0006\u0010,\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0003J\u000e\u0010-\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0003J\b\u0010.\u001a\u00020\u0000H\u0002J\u0010\u0010/\u001a\u00020\"2\u0006\u0010(\u001a\u00020\u0001H\u0002J\u0010\u00100\u001a\u00020\u00182\u0006\u00101\u001a\u000202H\u0002J\u000e\u00103\u001a\u00020\u00182\u0006\u00101\u001a\u000202R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\nR.\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\n\"\u0004\b\u001f\u0010 ¨\u00064"}, d2 = {"Landroidx/compose/runtime/GroupSourceInformation;", "", "key", "", "sourceInformation", "", "dataStartOffset", "<init>", "(ILjava/lang/String;I)V", "getKey", "()I", "getSourceInformation", "()Ljava/lang/String;", "setSourceInformation", "(Ljava/lang/String;)V", "getDataStartOffset", "groups", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getGroups", "()Ljava/util/ArrayList;", "setGroups", "(Ljava/util/ArrayList;)V", PTYSocketStateCallback.CLOSED, "", "getClosed", "()Z", "setClosed", "(Z)V", "dataEndOffset", "getDataEndOffset", "setDataEndOffset", "(I)V", "startGrouplessCall", "", "dataOffset", "endGrouplessCall", "reportGroup", "writer", "Landroidx/compose/runtime/SlotWriter;", "group", CopyContentTypeString.TABLE, "Landroidx/compose/runtime/SlotTable;", "addGroupAfter", "predecessor", "close", "openInformation", "add", "hasAnchor", "anchor", "Landroidx/compose/runtime/Anchor;", "removeAnchor", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GroupSourceInformation {
    public static final int $stable = 8;
    private boolean closed;
    private int dataEndOffset;
    private final int dataStartOffset;
    private ArrayList<Object> groups;
    private final int key;
    private String sourceInformation;

    private final GroupSourceInformation openInformation() {
        ArrayList<Object> r100 = this.groups;
        GroupSourceInformation r101 = null;
        if (r100 == null) goto L15;
        int r102 = r100.size() - 1;
    L5:
        if (r102 < 0) goto L15;
        Object r103 = ListProtector.get(r100, r102);
        if ((r103 instanceof GroupSourceInformation) == true) goto L9;
    L11:
        boolean r104 = false;
    L12:
        if (r104 == true) goto L17;
        r102 = r102 - 1;
    L17:
        if ((r103 instanceof GroupSourceInformation) == false) goto L19;
        r101 = (GroupSourceInformation) r103;
    L19:
        if (r101 == null) goto L24;
        GroupSourceInformation r105 = r101.openInformation();
        if (r105 == null) goto L24;
        return r105;
    L24:
        return this;
    L9:
        if (((GroupSourceInformation) r103).closed == true) goto L11;
        r104 = true;
    L15:
        r103 = null;
        goto L17
    }

    public final boolean getClosed() {
        return this.closed;
    }

    public final int getDataEndOffset() {
        return this.dataEndOffset;
    }

    public final int getDataStartOffset() {
        return this.dataStartOffset;
    }

    public final ArrayList<Object> getGroups() {
        return this.groups;
    }

    public final int getKey() {
        return this.key;
    }

    public final String getSourceInformation() {
        return this.sourceInformation;
    }

    private final void add(Object r100) {
        ArrayList<Object> r101 = this.groups;
        if (r101 != null) goto L5;
        r101 = new ArrayList();
    L5:
        this.groups = r101;
        r101.add(r100);
    }

    private final boolean hasAnchor(Anchor r100) {
        ArrayList<Object> r101 = this.groups;
        if (r101 == null) goto L25;
        int r102 = r101.size();
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L19;
        Object r104 = ListProtector.get(r101, r103);
        if (Intrinsics.areEqual(r104, r100) == false) goto L10;
    L15:
        boolean r105 = true;
    L16:
        if (r105 == true) goto L17;
        r103 = r103 + 1;
        goto L6
    L17:
        boolean r106 = true;
    L20:
        if (r106 != true) goto L26;
        return true;
    L26:
        return false;
    L10:
        if ((r104 instanceof GroupSourceInformation) == true) goto L12;
    L14:
        r105 = false;
        goto L16
    L12:
        if (((GroupSourceInformation) r104).hasAnchor(r100) == false) goto L14;
    L19:
        r106 = false;
        goto L20
    L25:
        return false;
    }

    public final void close(int r100) {
        this.closed = true;
        this.dataEndOffset = r100;
    }

    public final void endGrouplessCall(int r100) {
        openInformation().close(r100);
    }

    public final boolean removeAnchor(Anchor r100) {
        ArrayList<Object> r101 = this.groups;
        if (r101 == null) goto L21;
        int r102 = r101.size() - 1;
    L5:
        if (r102 < 0) goto L18;
        Object r103 = ListProtector.get(r101, r102);
        if ((r103 instanceof Anchor) == false) goto L12;
        if (Intrinsics.areEqual(r103, r100) == false) goto L16;
        ListProtector.remove(r101, r102);
    L16:
        r102 = r102 - 1;
        goto L5
    L12:
        if ((r103 instanceof GroupSourceInformation) == false) goto L16;
        if (((GroupSourceInformation) r103).removeAnchor(r100) == true) goto L16;
        ListProtector.remove(r101, r102);
        goto L16
    L18:
        if (r101.isEmpty() == false) goto L21;
        this.groups = null;
        return false;
    L21:
        return true;
    }

    public final void setClosed(boolean r100) {
        this.closed = r100;
    }

    public final void setDataEndOffset(int r100) {
        this.dataEndOffset = r100;
    }

    public final void setGroups(ArrayList<Object> r100) {
        this.groups = r100;
    }

    public final void setSourceInformation(String r100) {
        this.sourceInformation = r100;
    }

    public final void reportGroup(SlotTable r100, int r101) {
        openInformation().add(r100.anchor(r101));
    }

    public final void reportGroup(SlotWriter r100, int r101) {
        openInformation().add(r100.anchor(r101));
    }

    public GroupSourceInformation(int r100, String r101, int r102) {
        this.key = r100;
        this.sourceInformation = r101;
        this.dataStartOffset = r102;
    }

    public final void addGroupAfter(SlotWriter r100, int r101, int r102) {
        ArrayList<Object> r103 = this.groups;
        if (r103 != null) goto L5;
        r103 = new ArrayList();
        this.groups = r103;
    L5:
        int r104 = 0;
        if (r101 < 0) goto L24;
        Anchor r105 = r100.tryAnchor$runtime(r101);
        if (r105 == null) goto L24;
        int r106 = r103.size();
        int r107 = 0;
    L10:
        if (r107 >= r106) goto L23;
        Object r108 = ListProtector.get(r103, r107);
        if (Intrinsics.areEqual(r108, r105) == false) goto L14;
    L19:
        boolean r109 = true;
    L20:
        if (r109 == true) goto L21;
        r107 = r107 + 1;
        goto L10
    L21:
        r104 = r107;
        goto L24
    L14:
        if ((r108 instanceof GroupSourceInformation) == true) goto L16;
    L18:
        r109 = false;
        goto L20
    L16:
        if (((GroupSourceInformation) r108).hasAnchor(r105) == false) goto L18;
    L23:
        r104 = -1;
    L24:
        ListProtector.add(r103, r104, r100.anchor(r102));
    }

    public final void startGrouplessCall(int r100, String r101, int r102) {
        openInformation().add(new GroupSourceInformation(r100, r101, r102));
    }
}

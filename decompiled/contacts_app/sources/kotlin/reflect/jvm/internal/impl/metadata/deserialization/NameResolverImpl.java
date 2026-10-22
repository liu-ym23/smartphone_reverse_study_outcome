package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import com.bytedance.librarian.LibrarianImpl;
import java.util.LinkedList;
import java.util.List;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* JADX INFO: compiled from: NameResolverImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class NameResolverImpl implements NameResolver {
    private final ProtoBuf.QualifiedNameTable qualifiedNames;
    private final ProtoBuf.StringTable strings;

    /* JADX INFO: compiled from: NameResolverImpl.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.values().length];
            r0[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.CLASS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.PACKAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.LOCAL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public NameResolverImpl(ProtoBuf.StringTable r2, ProtoBuf.QualifiedNameTable r3) {
        Intrinsics.checkNotNullParameter(r2, "strings");
        Intrinsics.checkNotNullParameter(r3, "qualifiedNames");
        this.strings = r2;
        this.qualifiedNames = r3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public String getString(int r1) {
        String r0 = this.strings.getString(r1);
        Intrinsics.checkNotNullExpressionValue(r0, "strings.getString(index)");
        return r0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public String getQualifiedClassName(int r11) {
        Triple<List<String>, List<String>, Boolean> r10 = traverseIds(r11);
        List<String> r12 = r10.component1();
        String r13 = CollectionsKt.joinToString$default(r10.component2(), LibrarianImpl.Constants.DOT, null, null, 0, null, null, 62, null);
        if (r12.isEmpty() == false) goto L6;
        return r13;
    L6:
        return CollectionsKt.joinToString$default(r12, LibrarianImpl.Constants.SEPARATOR, null, null, 0, null, null, 62, null) + '/' + r13;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public boolean isLocalClassName(int r1) {
        return traverseIds(r1).getThird().booleanValue();
    }

    private final Triple<List<String>, List<String>, Boolean> traverseIds(int r8) {
        LinkedList r0 = new LinkedList();
        LinkedList r1 = new LinkedList();
        boolean r2 = false;
    L4:
        if (r8 == (-1)) goto L17;
        ProtoBuf.QualifiedNameTable.QualifiedName r9 = this.qualifiedNames.getQualifiedName(r8);
        String r3 = this.strings.getString(r9.getShortName());
        ProtoBuf.QualifiedNameTable.QualifiedName.Kind r4 = r9.getKind();
        Intrinsics.checkNotNull(r4);
        int r5 = WhenMappings.$EnumSwitchMapping$0[r4.ordinal()];
        if (r5 != 1) goto L8;
        r1.addFirst(r3);
    L15:
        r8 = r9.getParentQualifiedName();
        goto L4
    L8:
        if (r5 != 2) goto L10;
        r0.addFirst(r3);
        goto L15
    L10:
        if (r5 != 3) goto L15;
        r1.addFirst(r3);
        r2 = true;
        goto L15
    L17:
        return new Triple(r0, r1, Boolean.valueOf(r2));
    }
}

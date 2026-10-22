package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class ExtensionRegistryLite {
    private static final ExtensionRegistryLite EMPTY = null;
    private static volatile boolean eagerlyParseMessageSets = false;
    private final Map<ObjectIntPair, GeneratedMessageLite.GeneratedExtension<?, ?>> extensionsByNumber;

    private static final class ObjectIntPair {
        private final int number;
        private final Object object;

        ObjectIntPair(Object r1, int r2) {
            this.object = r1;
            this.number = r2;
        }

        public int hashCode() {
            return (System.identityHashCode(this.object) * 65535) + this.number;
        }

        public boolean equals(Object r4) {
            if ((r4 instanceof ObjectIntPair) == true) goto L5;
            return false;
        L5:
            ObjectIntPair r5 = (ObjectIntPair) r4;
            if (this.object == r5.object) goto L8;
            return false;
        L8:
            if (this.number != r5.number) goto L12;
            return true;
        L12:
            return false;
        }
    }

    public static ExtensionRegistryLite newInstance() {
        return new ExtensionRegistryLite();
    }

    public static ExtensionRegistryLite getEmptyRegistry() {
        return EMPTY;
    }

    public <ContainingType extends MessageLite> GeneratedMessageLite.GeneratedExtension<ContainingType, ?> findLiteExtensionByNumber(ContainingType r2, int r3) {
        return (GeneratedMessageLite.GeneratedExtension) this.extensionsByNumber.get(new ObjectIntPair(r2, r3));
    }

    public final void add(GeneratedMessageLite.GeneratedExtension<?, ?> r4) {
        this.extensionsByNumber.put(new ObjectIntPair(r4.getContainingTypeDefaultInstance(), r4.getNumber()), r4);
    }

    ExtensionRegistryLite() {
        this.extensionsByNumber = new HashMap();
    }

    private ExtensionRegistryLite(boolean r1) {
        this.extensionsByNumber = Collections.emptyMap();
    }

    static {
        EMPTY = new ExtensionRegistryLite(true);
    }
}

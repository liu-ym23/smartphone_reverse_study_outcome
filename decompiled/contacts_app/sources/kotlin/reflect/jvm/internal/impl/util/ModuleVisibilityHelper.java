package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;

/* JADX INFO: compiled from: ModuleVisibilityHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface ModuleVisibilityHelper {

    /* JADX INFO: compiled from: ModuleVisibilityHelper.kt */
    public static final class EMPTY implements ModuleVisibilityHelper {
        public static final EMPTY INSTANCE = null;

        static {
            INSTANCE = new EMPTY();
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.ModuleVisibilityHelper
        public boolean isInFriendModule(DeclarationDescriptor r1, DeclarationDescriptor r2) {
            Intrinsics.checkNotNullParameter(r1, "what");
            Intrinsics.checkNotNullParameter(r2, "from");
            return true;
        }

        private EMPTY() {
        }
    }

    boolean isInFriendModule(DeclarationDescriptor r1, DeclarationDescriptor r2);
}

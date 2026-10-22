package kotlin.reflect.jvm.internal.impl.platform;

import com.bytedance.librarian.LibrarianImpl;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: platformUtil.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class PlatformUtilKt {
    public static final String getPresentableDescription(TargetPlatform r9) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        return CollectionsKt.joinToString$default(r9.getComponentPlatforms(), LibrarianImpl.Constants.SEPARATOR, null, null, 0, null, null, 62, null);
    }
}

package androidx.room;

import androidx.room.IMultiInstanceInvalidationCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"androidx/room/MultiInstanceInvalidationClient$callback$1", "Landroidx/room/IMultiInstanceInvalidationCallback$Stub;", "", "", "tables", "", "onInvalidation", "([Ljava/lang/String;)V", "room-runtime_release"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class MultiInstanceInvalidationClient$callback$1 extends IMultiInstanceInvalidationCallback.Stub {
    final /* synthetic */ s this$0;

    public MultiInstanceInvalidationClient$callback$1(s sVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInvalidation$lambda$0(s this$0, String[] tables) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(tables, "$tables");
        this$0.getClass();
        throw null;
    }

    @Override // androidx.room.IMultiInstanceInvalidationCallback
    public void onInvalidation(@NotNull String[] tables) {
        Intrinsics.checkNotNullParameter(tables, "tables");
        this.this$0.getClass();
        throw null;
    }
}

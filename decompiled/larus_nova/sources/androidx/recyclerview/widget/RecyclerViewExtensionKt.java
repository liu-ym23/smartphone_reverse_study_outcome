package androidx.recyclerview.widget;

import com.larus.utils.logger.FLogger;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"notInLayoutOrScroll", "", "Landroidx/recyclerview/widget/RecyclerView;", "chat-common_mainlandRelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class RecyclerViewExtensionKt {
    public static final boolean notInLayoutOrScroll(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.assertNotInLayoutOrScroll(null);     // Catch: Throwable -> L5 IllegalAccessError -> L7
        goto L8
    L12:
        return true;
    L5:
        th = move-exception;
        FLogger.f375446a.e("RecyclerViewExt", "Try to updating the ViewHolder when RecyclerView scrolls or layouts");
        FLogger.f375446a.e("RecyclerViewExt", ExceptionsKt.stackTraceToString(th));
        return false;
    L8:
        return true ^ r100.isComputingLayout();
    }
}

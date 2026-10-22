package androidx.compose.foundation.layout;

import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/compose/foundation/layout/DoNothingNestedScrollConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "<init>", "()V", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class DoNothingNestedScrollConnection implements NestedScrollConnection {
    public static final DoNothingNestedScrollConnection INSTANCE = null;

    static {
        INSTANCE = new DoNothingNestedScrollConnection();
    }

    private DoNothingNestedScrollConnection() {
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    public final /* synthetic */ Object mo496onPostFlingRZ2iAVY(long r100, long r101, Continuation r102) {
        return NestedScrollConnection.CC.m5985$default$onPostFlingRZ2iAVY(this, r100, r101, r102);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    public final /* synthetic */ long mo497onPostScrollDzOQY0M(long r100, long r101, int r102) {
        return NestedScrollConnection.CC.m5986$default$onPostScrollDzOQY0M(this, r100, r101, r102);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreFling-QWom1Mo */
    public final /* synthetic */ Object mo498onPreFlingQWom1Mo(long r100, Continuation r101) {
        return NestedScrollConnection.CC.m5987$default$onPreFlingQWom1Mo(this, r100, r101);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
    public final /* synthetic */ long mo499onPreScrollOzD1aCk(long r100, int r101) {
        return NestedScrollConnection.CC.m5988$default$onPreScrollOzD1aCk(this, r100, r101);
    }
}

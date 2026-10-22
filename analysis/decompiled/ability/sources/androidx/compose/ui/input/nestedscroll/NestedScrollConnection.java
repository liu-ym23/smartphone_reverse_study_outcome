package androidx.compose.ui.input.nestedscroll;

import H7.c;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Velocity;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u001f\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\rH\u0096@¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0013\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\rH\u0096@¢\u0006\u0004\b\u0011\u0010\u0012ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "", "Landroidx/compose/ui/geometry/Offset;", "available", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", AgentBusWakeContract.EXTRA_SOURCE, "onPreScroll-OzD1aCk", "(JI)J", "onPreScroll", "consumed", "onPostScroll-DzOQY0M", "(JJI)J", "onPostScroll", "Landroidx/compose/ui/unit/Velocity;", "onPreFling-QWom1Mo", "(JLH7/c;)Ljava/lang/Object;", "onPreFling", "onPostFling-RZ2iAVY", "(JJLH7/c;)Ljava/lang/Object;", "onPostFling", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public interface NestedScrollConnection {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        /* renamed from: onPostFling-RZ2iAVY, reason: not valid java name */
        public static Object m5289onPostFlingRZ2iAVY(NestedScrollConnection nestedScrollConnection, long j5, long j6, c<? super Velocity> cVar) {
            return NestedScrollConnection.super.mo500onPostFlingRZ2iAVY(j5, j6, cVar);
        }

        @Deprecated
        /* renamed from: onPostScroll-DzOQY0M, reason: not valid java name */
        public static long m5290onPostScrollDzOQY0M(NestedScrollConnection nestedScrollConnection, long j5, long j6, int i) {
            return NestedScrollConnection.super.mo501onPostScrollDzOQY0M(j5, j6, i);
        }

        @Deprecated
        /* renamed from: onPreFling-QWom1Mo, reason: not valid java name */
        public static Object m5291onPreFlingQWom1Mo(NestedScrollConnection nestedScrollConnection, long j5, c<? super Velocity> cVar) {
            return NestedScrollConnection.super.mo775onPreFlingQWom1Mo(j5, cVar);
        }

        @Deprecated
        /* renamed from: onPreScroll-OzD1aCk, reason: not valid java name */
        public static long m5292onPreScrollOzD1aCk(NestedScrollConnection nestedScrollConnection, long j5, int i) {
            return NestedScrollConnection.super.mo776onPreScrollOzD1aCk(j5, i);
        }
    }

    /* renamed from: onPostFling-RZ2iAVY$suspendImpl, reason: not valid java name */
    static /* synthetic */ Object m5287onPostFlingRZ2iAVY$suspendImpl(NestedScrollConnection nestedScrollConnection, long j5, long j6, c<? super Velocity> cVar) {
        return Velocity.m7073boximpl(Velocity.INSTANCE.m7093getZero9UxMQ8M());
    }

    /* renamed from: onPreFling-QWom1Mo$suspendImpl, reason: not valid java name */
    static /* synthetic */ Object m5288onPreFlingQWom1Mo$suspendImpl(NestedScrollConnection nestedScrollConnection, long j5, c<? super Velocity> cVar) {
        return Velocity.m7073boximpl(Velocity.INSTANCE.m7093getZero9UxMQ8M());
    }

    /* renamed from: onPostFling-RZ2iAVY */
    default Object mo500onPostFlingRZ2iAVY(long j5, long j6, c<? super Velocity> cVar) {
        return m5287onPostFlingRZ2iAVY$suspendImpl(this, j5, j6, cVar);
    }

    /* renamed from: onPostScroll-DzOQY0M */
    default long mo501onPostScrollDzOQY0M(long consumed, long available, int source) {
        return Offset.INSTANCE.m3911getZeroF1C5BW0();
    }

    /* renamed from: onPreFling-QWom1Mo */
    default Object mo775onPreFlingQWom1Mo(long j5, c<? super Velocity> cVar) {
        return m5288onPreFlingQWom1Mo$suspendImpl(this, j5, cVar);
    }

    /* renamed from: onPreScroll-OzD1aCk */
    default long mo776onPreScrollOzD1aCk(long available, int source) {
        return Offset.INSTANCE.m3911getZeroF1C5BW0();
    }
}

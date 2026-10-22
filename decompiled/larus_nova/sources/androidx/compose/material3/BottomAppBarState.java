package androidx.compose.material3;

import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\bg\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\u0018\u0010\u000b\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007R\u0012\u0010\u000e\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0001"}, d2 = {"Landroidx/compose/material3/BottomAppBarState;", "", "heightOffsetLimit", "", "getHeightOffsetLimit", "()F", "setHeightOffsetLimit", "(F)V", "heightOffset", "getHeightOffset", "setHeightOffset", "contentOffset", "getContentOffset", "setContentOffset", "collapsedFraction", "getCollapsedFraction", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface BottomAppBarState {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/material3/BottomAppBarState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/BottomAppBarState;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final Saver<BottomAppBarState, ?> Saver = null;

        private Companion() {
        }

        public static /* synthetic */ BottomAppBarState a(List r100) {
            return Saver$lambda$1(r100);
        }

        public static /* synthetic */ List b(SaverScope r100, BottomAppBarState r101) {
            return Saver$lambda$0(r100, r101);
        }

        static {
            $$INSTANCE = new Companion();
            Saver = ListSaverKt.listSaver(new p1(), new q1());
        }

        public final Saver<BottomAppBarState, ?> getSaver() {
            return Saver;
        }

        private static final BottomAppBarState Saver$lambda$1(List r100) {
            return AppBarKt.BottomAppBarState(((Number) ListProtector.get(r100, 0)).floatValue(), ((Number) ListProtector.get(r100, 1)).floatValue(), ((Number) ListProtector.get(r100, 2)).floatValue());
        }

        private static final List Saver$lambda$0(SaverScope r100, BottomAppBarState r101) {
            return CollectionsKt.listOf(new Float[]{Float.valueOf(r101.getHeightOffsetLimit()), Float.valueOf(r101.getHeightOffset()), Float.valueOf(r101.getContentOffset())});
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    float getCollapsedFraction();

    float getContentOffset();

    float getHeightOffset();

    float getHeightOffsetLimit();

    void setContentOffset(float r100);

    void setHeightOffset(float r100);

    void setHeightOffsetLimit(float r100);
}

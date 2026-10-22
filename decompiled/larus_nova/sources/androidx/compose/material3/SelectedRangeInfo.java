package androidx.compose.material3;

import androidx.compose.material3.internal.CalendarDate;
import androidx.compose.material3.internal.CalendarMonth;
import androidx.compose.ui.unit.IntOffset;
import com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0001\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0012"}, d2 = {"Landroidx/compose/material3/SelectedRangeInfo;", "", "gridStartCoordinates", "Landroidx/compose/ui/unit/IntOffset;", "gridEndCoordinates", "firstIsSelectionStart", "", "lastIsSelectionEnd", "<init>", "(JJZZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getGridStartCoordinates-nOcc-ac", "()J", "J", "getGridEndCoordinates-nOcc-ac", "getFirstIsSelectionStart", "()Z", "getLastIsSelectionEnd", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SelectedRangeInfo {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private final boolean firstIsSelectionStart;
    private final long gridEndCoordinates;
    private final long gridStartCoordinates;
    private final boolean lastIsSelectionEnd;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t¨\u0006\u000b"}, d2 = {"Landroidx/compose/material3/SelectedRangeInfo$Companion;", "", "<init>", "()V", "calculateRangeInfo", "Landroidx/compose/material3/SelectedRangeInfo;", BdpGameHostBaseUIService.DATE_PICKER_TYPE_MONTH, "Landroidx/compose/material3/internal/CalendarMonth;", com.heytap.mcssdk.constant.b.f276369s, "Landroidx/compose/material3/internal/CalendarDate;", com.heytap.mcssdk.constant.b.f276370t, "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final SelectedRangeInfo calculateRangeInfo(CalendarMonth r110, CalendarDate r111, CalendarDate r112) {
            if (r111.getUtcTimeMillis() <= r110.getEndUtcTimeMillis()) goto L5;
            return null;
        L5:
            if (r112.getUtcTimeMillis() >= r110.getStartUtcTimeMillis()) goto L8;
            return null;
        L8:
            if (r111.getUtcTimeMillis() < r110.getStartUtcTimeMillis()) goto L10;
            boolean r113 = true;
        L12:
            if (r112.getUtcTimeMillis() > r110.getEndUtcTimeMillis()) goto L14;
            boolean r114 = true;
        L15:
            if (r113 == false) goto L17;
            int r100 = (r110.getDaysFromStartOfWeekToFirstOfMonth() + r111.getDayOfMonth()) - 1;
        L18:
            if (r114 == false) goto L20;
            int r101 = r110.getDaysFromStartOfWeekToFirstOfMonth();
            int r102 = r112.getDayOfMonth();
        L21:
            int r103 = (r101 + r102) - 1;
            int r104 = r100 % 7;
            long r105 = IntOffset.m7670constructorimpl((((long) r104) << 32) | (((long) (r100 / 7)) & BodyPartID.bodyIdMax));
            int r106 = r103 % 7;
            long r107 = ((long) r106) << 32;
            return new SelectedRangeInfo(r105, IntOffset.m7670constructorimpl((((long) (r103 / 7)) & BodyPartID.bodyIdMax) | r107), r113, r114, null);
        L20:
            r101 = r110.getDaysFromStartOfWeekToFirstOfMonth();
            r102 = r110.getNumberOfDays();
            goto L21
        L17:
            r100 = r110.getDaysFromStartOfWeekToFirstOfMonth();
            goto L18
        L14:
            r114 = false;
            goto L15
        L10:
            r113 = false;
            goto L12
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ SelectedRangeInfo(long r100, long r101, boolean r102, boolean r103, DefaultConstructorMarker r104) {
        this(r100, r101, r102, r103);
    }

    public final boolean getFirstIsSelectionStart() {
        return this.firstIsSelectionStart;
    }

    /* JADX INFO: renamed from: getGridEndCoordinates-nOcc-ac, reason: not valid java name */
    public final long m2615getGridEndCoordinatesnOccac() {
        return this.gridEndCoordinates;
    }

    /* JADX INFO: renamed from: getGridStartCoordinates-nOcc-ac, reason: not valid java name */
    public final long m2616getGridStartCoordinatesnOccac() {
        return this.gridStartCoordinates;
    }

    public final boolean getLastIsSelectionEnd() {
        return this.lastIsSelectionEnd;
    }

    private SelectedRangeInfo(long r100, long r101, boolean r102, boolean r103) {
        this.gridStartCoordinates = r100;
        this.gridEndCoordinates = r101;
        this.firstIsSelectionStart = r102;
        this.lastIsSelectionEnd = r103;
    }
}

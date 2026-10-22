package androidx.appfunctions.internal.serializableproxies;

import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appfunctions.AppFunctionSerializableProxy;
import androidx.appfunctions.metadata.AppFunctionMetadataKt;
import androidx.constraintlayout.core.dsl.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.time.LocalDateTime;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0001$B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0014\u001a\u00020\u0015J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003JO\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010!\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\"\u001a\u00020#HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006%"}, d2 = {"Landroidx/appfunctions/internal/serializableproxies/AppFunctionLocalDateTime;", "", "year", "", "month", "dayOfMonth", "hour", "minute", "second", "nanoOfSecond", AppAgent.CONSTRUCT, "(IIIIIII)V", "getYear", "()I", "getMonth", "getDayOfMonth", "getHour", "getMinute", "getSecond", "getNanoOfSecond", "toLocalDateTime", "Ljava/time/LocalDateTime;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 1, mv = {2, 1, 0}, xi = 48)
@RequiresApi(26)
@AppFunctionSerializableProxy(targetClass = LocalDateTime.class)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final /* data */ class AppFunctionLocalDateTime {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int dayOfMonth;
    private final int hour;
    private final int minute;
    private final int month;
    private final int nanoOfSecond;
    private final int second;
    private final int year;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Landroidx/appfunctions/internal/serializableproxies/AppFunctionLocalDateTime$Companion;", "", AppAgent.CONSTRUCT, "()V", "fromLocalDateTime", "Landroidx/appfunctions/internal/serializableproxies/AppFunctionLocalDateTime;", "localDateTime", "Ljava/time/LocalDateTime;", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final AppFunctionLocalDateTime fromLocalDateTime(LocalDateTime localDateTime) {
            k.f(localDateTime, "localDateTime");
            return new AppFunctionLocalDateTime(localDateTime.getYear(), localDateTime.getMonthValue(), localDateTime.getDayOfMonth(), localDateTime.getHour(), localDateTime.getMinute(), localDateTime.getSecond(), localDateTime.getNano());
        }

        private Companion() {
        }
    }

    public AppFunctionLocalDateTime(int i, int i6, int i10, int i11, int i12, int i13, int i14) {
        this.year = i;
        this.month = i6;
        this.dayOfMonth = i10;
        this.hour = i11;
        this.minute = i12;
        this.second = i13;
        this.nanoOfSecond = i14;
    }

    public static /* synthetic */ AppFunctionLocalDateTime copy$default(AppFunctionLocalDateTime appFunctionLocalDateTime, int i, int i6, int i10, int i11, int i12, int i13, int i14, int i15, Object obj) {
        if ((i15 & 1) != 0) {
            i = appFunctionLocalDateTime.year;
        }
        if ((i15 & 2) != 0) {
            i6 = appFunctionLocalDateTime.month;
        }
        if ((i15 & 4) != 0) {
            i10 = appFunctionLocalDateTime.dayOfMonth;
        }
        if ((i15 & 8) != 0) {
            i11 = appFunctionLocalDateTime.hour;
        }
        if ((i15 & 16) != 0) {
            i12 = appFunctionLocalDateTime.minute;
        }
        if ((i15 & 32) != 0) {
            i13 = appFunctionLocalDateTime.second;
        }
        if ((i15 & 64) != 0) {
            i14 = appFunctionLocalDateTime.nanoOfSecond;
        }
        int i16 = i13;
        int i17 = i14;
        int i18 = i12;
        int i19 = i10;
        return appFunctionLocalDateTime.copy(i, i6, i19, i11, i18, i16, i17);
    }

    /* renamed from: component1, reason: from getter */
    public final int getYear() {
        return this.year;
    }

    /* renamed from: component2, reason: from getter */
    public final int getMonth() {
        return this.month;
    }

    /* renamed from: component3, reason: from getter */
    public final int getDayOfMonth() {
        return this.dayOfMonth;
    }

    /* renamed from: component4, reason: from getter */
    public final int getHour() {
        return this.hour;
    }

    /* renamed from: component5, reason: from getter */
    public final int getMinute() {
        return this.minute;
    }

    /* renamed from: component6, reason: from getter */
    public final int getSecond() {
        return this.second;
    }

    /* renamed from: component7, reason: from getter */
    public final int getNanoOfSecond() {
        return this.nanoOfSecond;
    }

    public final AppFunctionLocalDateTime copy(int year, int month, int dayOfMonth, int hour, int minute, int second, int nanoOfSecond) {
        return new AppFunctionLocalDateTime(year, month, dayOfMonth, hour, minute, second, nanoOfSecond);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppFunctionLocalDateTime)) {
            return false;
        }
        AppFunctionLocalDateTime appFunctionLocalDateTime = (AppFunctionLocalDateTime) other;
        return this.year == appFunctionLocalDateTime.year && this.month == appFunctionLocalDateTime.month && this.dayOfMonth == appFunctionLocalDateTime.dayOfMonth && this.hour == appFunctionLocalDateTime.hour && this.minute == appFunctionLocalDateTime.minute && this.second == appFunctionLocalDateTime.second && this.nanoOfSecond == appFunctionLocalDateTime.nanoOfSecond;
    }

    public final int getDayOfMonth() {
        return this.dayOfMonth;
    }

    public final int getHour() {
        return this.hour;
    }

    public final int getMinute() {
        return this.minute;
    }

    public final int getMonth() {
        return this.month;
    }

    public final int getNanoOfSecond() {
        return this.nanoOfSecond;
    }

    public final int getSecond() {
        return this.second;
    }

    public final int getYear() {
        return this.year;
    }

    public int hashCode() {
        return Integer.hashCode(this.nanoOfSecond) + a.a(this.second, a.a(this.minute, a.a(this.hour, a.a(this.dayOfMonth, a.a(this.month, Integer.hashCode(this.year) * 31, 31), 31), 31), 31), 31);
    }

    public final LocalDateTime toLocalDateTime() {
        LocalDateTime localDateTimeOf = LocalDateTime.of(this.year, this.month, this.dayOfMonth, this.hour, this.minute, this.second, this.nanoOfSecond);
        k.e(localDateTimeOf, "of(...)");
        return localDateTimeOf;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AppFunctionLocalDateTime(year=");
        sb.append(this.year);
        sb.append(", month=");
        sb.append(this.month);
        sb.append(", dayOfMonth=");
        sb.append(this.dayOfMonth);
        sb.append(", hour=");
        sb.append(this.hour);
        sb.append(", minute=");
        sb.append(this.minute);
        sb.append(", second=");
        sb.append(this.second);
        sb.append(", nanoOfSecond=");
        return B7.a.o(sb, this.nanoOfSecond, ')');
    }
}

package io.ktor.util.date;

import Y8.h;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import io.ktor.util.date.GMTDate;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import lb.l;
import ob.d;
import p9.InterfaceC5063a;
import pb.E0;
import pb.I;
import pb.T0;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0087\b\u0018\u0000 F2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002FGBO\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010Bg\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u000f\u0010\u0014J'\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\u0000¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b%\u0010$J\u0010\u0010&\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b&\u0010$J\u0010\u0010'\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b)\u0010$J\u0010\u0010*\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b*\u0010$J\u0010\u0010+\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b-\u0010$J\u0010\u0010.\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b.\u0010/Jj\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\rHÆ\u0001¢\u0006\u0004\b!\u00100J\u0010\u00102\u001a\u000201HÖ\u0001¢\u0006\u0004\b2\u00103J\u0010\u00104\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b4\u0010$J\u001a\u00107\u001a\u0002062\b\u0010\u001e\u001a\u0004\u0018\u000105HÖ\u0003¢\u0006\u0004\b7\u00108R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00109\u001a\u0004\b:\u0010$R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u00109\u001a\u0004\b;\u0010$R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u00109\u001a\u0004\b<\u0010$R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010=\u001a\u0004\b>\u0010(R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u00109\u001a\u0004\b?\u0010$R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u00109\u001a\u0004\b@\u0010$R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010A\u001a\u0004\bB\u0010,R\u0017\u0010\f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u00109\u001a\u0004\bC\u0010$R\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010D\u001a\u0004\bE\u0010/¨\u0006H"}, d2 = {"Lio/ktor/util/date/GMTDate;", "", "", "seconds", "minutes", "hours", "Lio/ktor/util/date/WeekDay;", "dayOfWeek", "dayOfMonth", "dayOfYear", "Lio/ktor/util/date/Month;", "month", "year", "", "timestamp", "<init>", "(IIILio/ktor/util/date/WeekDay;IILio/ktor/util/date/Month;IJ)V", "seen0", "Lpb/T0;", "serializationConstructorMarker", "(IIIILio/ktor/util/date/WeekDay;IILio/ktor/util/date/Month;IJLpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "write$Self$ktor_utils", "(Lio/ktor/util/date/GMTDate;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "other", "compareTo", "(Lio/ktor/util/date/GMTDate;)I", ChatTracker.CLICK_COPY, "()Lio/ktor/util/date/GMTDate;", "component1", "()I", "component2", "component3", "component4", "()Lio/ktor/util/date/WeekDay;", "component5", "component6", "component7", "()Lio/ktor/util/date/Month;", "component8", "component9", "()J", "(IIILio/ktor/util/date/WeekDay;IILio/ktor/util/date/Month;IJ)Lio/ktor/util/date/GMTDate;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "", "equals", "(Ljava/lang/Object;)Z", "I", "getSeconds", "getMinutes", "getHours", "Lio/ktor/util/date/WeekDay;", "getDayOfWeek", "getDayOfMonth", "getDayOfYear", "Lio/ktor/util/date/Month;", "getMonth", "getYear", "J", "getTimestamp", "Companion", "$serializer", "ktor-utils"}, k = 1, mv = {2, 2, 0}, xi = 48)
@l
/* loaded from: classes4.dex */
public final /* data */ class GMTDate implements Comparable<GMTDate> {
    private static final h<KSerializer<Object>>[] $childSerializers;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final GMTDate START;
    private final int dayOfMonth;
    private final WeekDay dayOfWeek;
    private final int dayOfYear;
    private final int hours;
    private final int minutes;
    private final Month month;
    private final int seconds;
    private final long timestamp;
    private final int year;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/ktor/util/date/GMTDate$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/ktor/util/date/GMTDate;", "serializer", "()Lkotlinx/serialization/KSerializer;", "START", "Lio/ktor/util/date/GMTDate;", "getSTART", "()Lio/ktor/util/date/GMTDate;", "ktor-utils"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final GMTDate getSTART() {
            return GMTDate.START;
        }

        public final KSerializer<GMTDate> serializer() {
            return GMTDate$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    static {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        $childSerializers = new h[]{null, null, null, C4848b.a(lazyThreadSafetyMode, new InterfaceC5063a() { // from class: s8.a
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return GMTDate._childSerializers$_anonymous_();
            }
        }), null, null, C4848b.a(lazyThreadSafetyMode, new InterfaceC5063a() { // from class: s8.b
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return GMTDate._childSerializers$_anonymous_$0();
            }
        }), null, null};
        START = DateJvmKt.GMTDate(0L);
    }

    public /* synthetic */ GMTDate(int i10, int i11, int i12, int i13, WeekDay weekDay, int i14, int i15, Month month, int i16, long j10, T0 t02) {
        if (511 != (i10 & 511)) {
            E0.a(i10, 511, GMTDate$$serializer.INSTANCE.getDescriptor());
        }
        this.seconds = i11;
        this.minutes = i12;
        this.hours = i13;
        this.dayOfWeek = weekDay;
        this.dayOfMonth = i14;
        this.dayOfYear = i15;
        this.month = month;
        this.year = i16;
        this.timestamp = j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return I.a("io.ktor.util.date.WeekDay", WeekDay.values());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return I.a("io.ktor.util.date.Month", Month.values());
    }

    public static /* synthetic */ GMTDate copy$default(GMTDate gMTDate, int i10, int i11, int i12, WeekDay weekDay, int i13, int i14, Month month, int i15, long j10, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i10 = gMTDate.seconds;
        }
        if ((i16 & 2) != 0) {
            i11 = gMTDate.minutes;
        }
        if ((i16 & 4) != 0) {
            i12 = gMTDate.hours;
        }
        if ((i16 & 8) != 0) {
            weekDay = gMTDate.dayOfWeek;
        }
        if ((i16 & 16) != 0) {
            i13 = gMTDate.dayOfMonth;
        }
        if ((i16 & 32) != 0) {
            i14 = gMTDate.dayOfYear;
        }
        if ((i16 & 64) != 0) {
            month = gMTDate.month;
        }
        if ((i16 & 128) != 0) {
            i15 = gMTDate.year;
        }
        if ((i16 & 256) != 0) {
            j10 = gMTDate.timestamp;
        }
        long j11 = j10;
        Month month2 = month;
        int i17 = i15;
        int i18 = i13;
        int i19 = i14;
        return gMTDate.copy(i10, i11, i12, weekDay, i18, i19, month2, i17, j11);
    }

    public static final /* synthetic */ void write$Self$ktor_utils(GMTDate self, d output, SerialDescriptor serialDesc) {
        h<KSerializer<Object>>[] hVarArr = $childSerializers;
        output.t(serialDesc, 0, self.seconds);
        output.t(serialDesc, 1, self.minutes);
        output.t(serialDesc, 2, self.hours);
        output.x(serialDesc, 3, hVarArr[3].getValue(), self.dayOfWeek);
        output.t(serialDesc, 4, self.dayOfMonth);
        output.t(serialDesc, 5, self.dayOfYear);
        output.x(serialDesc, 6, hVarArr[6].getValue(), self.month);
        output.t(serialDesc, 7, self.year);
        output.C(serialDesc, 8, self.timestamp);
    }

    /* renamed from: component1, reason: from getter */
    public final int getSeconds() {
        return this.seconds;
    }

    /* renamed from: component2, reason: from getter */
    public final int getMinutes() {
        return this.minutes;
    }

    /* renamed from: component3, reason: from getter */
    public final int getHours() {
        return this.hours;
    }

    /* renamed from: component4, reason: from getter */
    public final WeekDay getDayOfWeek() {
        return this.dayOfWeek;
    }

    /* renamed from: component5, reason: from getter */
    public final int getDayOfMonth() {
        return this.dayOfMonth;
    }

    /* renamed from: component6, reason: from getter */
    public final int getDayOfYear() {
        return this.dayOfYear;
    }

    /* renamed from: component7, reason: from getter */
    public final Month getMonth() {
        return this.month;
    }

    /* renamed from: component8, reason: from getter */
    public final int getYear() {
        return this.year;
    }

    /* renamed from: component9, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    public final GMTDate copy(int seconds, int minutes, int hours, WeekDay dayOfWeek, int dayOfMonth, int dayOfYear, Month month, int year, long timestamp) {
        p.i(dayOfWeek, "dayOfWeek");
        p.i(month, "month");
        return new GMTDate(seconds, minutes, hours, dayOfWeek, dayOfMonth, dayOfYear, month, year, timestamp);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GMTDate)) {
            return false;
        }
        GMTDate gMTDate = (GMTDate) other;
        return this.seconds == gMTDate.seconds && this.minutes == gMTDate.minutes && this.hours == gMTDate.hours && this.dayOfWeek == gMTDate.dayOfWeek && this.dayOfMonth == gMTDate.dayOfMonth && this.dayOfYear == gMTDate.dayOfYear && this.month == gMTDate.month && this.year == gMTDate.year && this.timestamp == gMTDate.timestamp;
    }

    public final int getDayOfMonth() {
        return this.dayOfMonth;
    }

    public final WeekDay getDayOfWeek() {
        return this.dayOfWeek;
    }

    public final int getDayOfYear() {
        return this.dayOfYear;
    }

    public final int getHours() {
        return this.hours;
    }

    public final int getMinutes() {
        return this.minutes;
    }

    public final Month getMonth() {
        return this.month;
    }

    public final int getSeconds() {
        return this.seconds;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final int getYear() {
        return this.year;
    }

    public int hashCode() {
        return (((((((((((((((Integer.hashCode(this.seconds) * 31) + Integer.hashCode(this.minutes)) * 31) + Integer.hashCode(this.hours)) * 31) + this.dayOfWeek.hashCode()) * 31) + Integer.hashCode(this.dayOfMonth)) * 31) + Integer.hashCode(this.dayOfYear)) * 31) + this.month.hashCode()) * 31) + Integer.hashCode(this.year)) * 31) + Long.hashCode(this.timestamp);
    }

    public String toString() {
        return "GMTDate(seconds=" + this.seconds + ", minutes=" + this.minutes + ", hours=" + this.hours + ", dayOfWeek=" + this.dayOfWeek + ", dayOfMonth=" + this.dayOfMonth + ", dayOfYear=" + this.dayOfYear + ", month=" + this.month + ", year=" + this.year + ", timestamp=" + this.timestamp + ')';
    }

    public GMTDate(int i10, int i11, int i12, WeekDay dayOfWeek, int i13, int i14, Month month, int i15, long j10) {
        p.i(dayOfWeek, "dayOfWeek");
        p.i(month, "month");
        this.seconds = i10;
        this.minutes = i11;
        this.hours = i12;
        this.dayOfWeek = dayOfWeek;
        this.dayOfMonth = i13;
        this.dayOfYear = i14;
        this.month = month;
        this.year = i15;
        this.timestamp = j10;
    }

    @Override // java.lang.Comparable
    public int compareTo(GMTDate other) {
        p.i(other, "other");
        return p.l(this.timestamp, other.timestamp);
    }

    public final GMTDate copy() {
        return DateJvmKt.GMTDate$default(null, 1, null);
    }
}

package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import bg.c;
import com.bytedance.apm.constant.CommonKey;
import com.obric.capabilitykit.entity.EntityExtKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.b0;
import kotlin.collections.k0;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 =2\u00020\u0001:\u0001=B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B/\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0002\u0010\fJ\u001a\u00103\u001a\u0004\u0018\u00010\u00062\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"H\u0002J\u0019\u00104\u001a\u0004\u0018\u00010\u00062\b\u0010*\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0002\u00105J\"\u00106\u001a\u0002072\u0006\u0010\u0002\u001a\u00020\u00032\b\u00108\u001a\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020#H\u0016J\u0018\u0010;\u001a\u0002072\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010<\u001a\u00020#H\u0016R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b\u0019\u0010\u0012R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\n\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017R4\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0010\u0010)\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010*\u001a\u0004\u0018\u00010#2\b\u0010!\u001a\u0004\u0018\u00010#@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0010\u00100\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0015\"\u0004\b2\u0010\u0017¨\u0006>"}, d2 = {"Lcom/obric/capabilitykit/entity/app/AlarmEntity;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "name", "startTime", "(Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;)V", "closeInHoliday", "", "getCloseInHoliday", "()Z", "setCloseInHoliday", "(Z)V", "date", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "isEnabled", "setEnabled", "isRinging", "()Ljava/lang/Boolean;", "setRinging", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getName", "setName", CommonKey.KEY_VALUE, "", "", "repeatDayOfWeek", "getRepeatDayOfWeek", "()Ljava/util/List;", "setRepeatDayOfWeek", "(Ljava/util/List;)V", "repeatDayOfWeekDesc", "repeatType", "getRepeatType", "()Ljava/lang/Integer;", "setRepeatType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "repeatTypeDesc", "getStartTime", "setStartTime", "generateRepeatDesc", "generateRepeatTypeDesc", "(Ljava/lang/Integer;)Ljava/lang/String;", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AlarmEntity extends AppEntity {

    @NotNull
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 4;
    private static final int RELATED_VERSION = 0;
    private boolean closeInHoliday;

    @Nullable
    private String date;
    private boolean isEnabled;

    @Nullable
    private Boolean isRinging;

    @NotNull
    private String name;

    @Nullable
    private List<Integer> repeatDayOfWeek;

    @Nullable
    private String repeatDayOfWeekDesc;

    @Nullable
    private Integer repeatType;

    @Nullable
    private String repeatTypeDesc;

    @NotNull
    private String startTime;

    @Keep
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/app/AlarmEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/app/AlarmEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/app/AlarmEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<AlarmEntity> {
        private CREATOR() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public AlarmEntity createFromParcel(@NotNull Parcel r10) {
            q.g(r10, "parcel");
            AppEntity r11 = AppEntity.CREATOR.createFromParcel(r10);
            q.e(r11, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.AlarmEntity");
            return (AlarmEntity) r11;
        }

        public final int getVersion() {
            return 4;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public AlarmEntity[] newArray(int r10) {
            return new AlarmEntity[r10];
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r10) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AlarmEntity createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AlarmEntity[] newArray(int r10) {
            return newArray(r10);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function1<Integer, CharSequence> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map<Integer, String> f11321a;

        public a(Map<Integer, String> r10) {
            this.f11321a = r10;
            super(1);
        }

        @NotNull
        public final CharSequence a(int r10) {
            String r11 = this.f11321a.get(Integer.valueOf(r10));
            if (r11 != null) goto L7;
            return "";
        L7:
            return r11;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CharSequence invoke(Integer r10) {
            return a(r10.intValue());
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public AlarmEntity(@NotNull Parcel r10) {
        q.g(r10, "parcel");
        this(EntityExtKt.f(r10), r10.readLong(), r10.readLong(), EntityExtKt.f(r10), EntityExtKt.f(r10));
        readExtensionFieldFromParcel$capabilitykitcommon_release(r10);
        int r11 = r10.readInt();
        this.isEnabled = EntityExtKt.e(r10);
        ArrayList r12 = new ArrayList();
        r10.readList(r12, Integer.TYPE.getClassLoader());
        setRepeatDayOfWeek(r12);
        this.closeInHoliday = EntityExtKt.e(r10);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r10, 4, r11);
    }

    private final String generateRepeatDesc(List<Integer> r12) {
        if (r12 != null) goto L4;
        return null;
    L4:
        if (r12.isEmpty() == true) goto L14;
        Map r10 = k0.j(new Pair[]{d.a(1, "周一"), d.a(2, "周二"), d.a(3, "周三"), d.a(4, "周四"), d.a(5, "周五"), d.a(6, "周六"), d.a(7, "周日")});
        if (r12.containsAll(b0.x0(new c(1, 7))) == false) goto L10;
        return "每天";
    L10:
        return 27599 + b0.h0(b0.s0(r12), "", null, null, 0, null, new a(r10), 30, null);
    L14:
        return null;
    }

    private final String generateRepeatTypeDesc(Integer r10) {
        if (r10 == null) goto L16;
        int r11 = r10.intValue();
        if (r11 != 0) goto L6;
        return "不重复";
    L6:
        if (r11 != 1) goto L8;
        return "每天";
    L8:
        if (r11 != 2) goto L10;
        return "法定工作日";
    L10:
        if (r11 != 3) goto L16;
        return "法定节假日及周末";
    L16:
        return null;
    }

    public final boolean getCloseInHoliday() {
        return this.closeInHoliday;
    }

    @Nullable
    public final String getDate() {
        return this.date;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final List<Integer> getRepeatDayOfWeek() {
        return this.repeatDayOfWeek;
    }

    @Nullable
    public final Integer getRepeatType() {
        return this.repeatType;
    }

    @NotNull
    public final String getStartTime() {
        return this.startTime;
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    @Nullable
    public final Boolean isRinging() {
        return this.isRinging;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(@NotNull Parcel r10, @Nullable ClassLoader r11, int r12) {
        q.g(r10, "parcel");
        if (r12 != 1) goto L5;
        this.date = (String) r10.readValue(r11);
        return;
    L5:
        if (r12 != 2) goto L7;
        this.isRinging = (Boolean) r10.readValue(r11);
        return;
    L7:
        if (r12 != 3) goto L9;
        setRepeatType((Integer) r10.readValue(r11));
        return;
    L9:
        if (r12 != 4) goto L19;
        this.repeatTypeDesc = (String) r10.readValue(r11);
        return;
    }

    public final void setCloseInHoliday(boolean r10) {
        this.closeInHoliday = r10;
    }

    public final void setDate(@Nullable String r10) {
        this.date = r10;
    }

    public final void setEnabled(boolean r10) {
        this.isEnabled = r10;
    }

    public final void setName(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.name = r10;
    }

    public final void setRepeatDayOfWeek(@Nullable List<Integer> r10) {
        this.repeatDayOfWeekDesc = generateRepeatDesc(r10);
        this.repeatDayOfWeek = r10;
    }

    public final void setRepeatType(@Nullable Integer r10) {
        this.repeatTypeDesc = generateRepeatTypeDesc(r10);
        this.repeatType = r10;
    }

    public final void setRinging(@Nullable Boolean r10) {
        this.isRinging = r10;
    }

    public final void setStartTime(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.startTime = r10;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        q.g(r10, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r10);
        r10.writeString(this.name);
        r10.writeString(this.startTime);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r10);
        r10.writeInt(4);
        EntityExtKt.g(r10, this.isEnabled);
        r10.writeList(this.repeatDayOfWeek);
        EntityExtKt.g(r10, this.closeInHoliday);
        r10.writeValue(this.date);
        r10.writeValue(this.isRinging);
        r10.writeValue(this.repeatType);
        r10.writeValue(this.repeatTypeDesc);
    }

    public AlarmEntity(@NotNull String r10, long r11, long r12, @NotNull String r14, @NotNull String r15) {
        q.g(r10, "id");
        q.g(r14, "name");
        q.g(r15, "startTime");
        super(r10, r11, r12, 701);
        this.name = r14;
        this.startTime = r15;
    }

    public /* synthetic */ AlarmEntity(String r10, long r11, long r13, String r15, String r16, int r17, DefaultConstructorMarker r18) {
        if ((r17 & 16) == 0) goto L5;
        String r12 = "";
    L6:
        this(r10, r11, r13, r15, r12);
        return;
    L5:
        r12 = r16;
        goto L6
    }
}

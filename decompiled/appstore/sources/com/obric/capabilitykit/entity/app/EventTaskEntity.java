package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.obric.capabilitykit.entity.EntityExtKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.b0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 )2\u00020\u0001:\u0001)B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004BK\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010¢\u0006\u0002\u0010\u0011J\"\u0010!\u001a\u00020\"2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&H\u0016J\u0018\u0010'\u001a\u00020\"2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010(\u001a\u00020&H\u0016R \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\n\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\f\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0017\"\u0004\b\u001e\u0010\u0019R\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0017\"\u0004\b \u0010\u0019¨\u0006*"}, d2 = {"Lcom/obric/capabilitykit/entity/app/EventTaskEntity;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "conditionString", "taskQuery", "periodString", "isDeleted", "", "conditionList", "", "(Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;)V", "getConditionList", "()Ljava/util/List;", "setConditionList", "(Ljava/util/List;)V", "getConditionString", "()Ljava/lang/String;", "setConditionString", "(Ljava/lang/String;)V", "()Z", "setDeleted", "(Z)V", "getPeriodString", "setPeriodString", "getTaskQuery", "setTaskQuery", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EventTaskEntity extends AppEntity {

    @NotNull
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 0;
    private static final int RELATED_VERSION = 0;

    @NotNull
    private List<String> conditionList;

    @NotNull
    private String conditionString;
    private boolean isDeleted;

    @NotNull
    private String periodString;

    @NotNull
    private String taskQuery;

    @Keep
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/app/EventTaskEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/app/EventTaskEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/app/EventTaskEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<EventTaskEntity> {
        private CREATOR() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public EventTaskEntity createFromParcel(@NotNull Parcel r10) {
            q.g(r10, "parcel");
            AppEntity r11 = AppEntity.CREATOR.createFromParcel(r10);
            q.e(r11, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.EventTaskEntity");
            return (EventTaskEntity) r11;
        }

        public final int getVersion() {
            return 0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public EventTaskEntity[] newArray(int r10) {
            return new EventTaskEntity[r10];
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r10) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ EventTaskEntity createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ EventTaskEntity[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public EventTaskEntity(@NotNull Parcel r13) {
        q.g(r13, "parcel");
        String r10 = EntityExtKt.f(r13);
        long r11 = r13.readLong();
        long r12 = r13.readLong();
        String r14 = EntityExtKt.f(r13);
        String r15 = EntityExtKt.f(r13);
        String r16 = EntityExtKt.f(r13);
        boolean r17 = EntityExtKt.e(r13);
        ArrayList<String> r18 = r13.createStringArrayList();
        if (r18 == null) goto L8;
        List r19 = b0.x0(r18);
        if (r19 == null) goto L8;
    L9:
        this(r10, r11, r12, r14, r15, r16, r17, r19);
        readExtensionFieldFromParcel$capabilitykitcommon_release(r13);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r13, 0, r13.readInt());
        return;
    L8:
        r19 = new ArrayList();
        goto L9
    }

    @NotNull
    public final List<String> getConditionList() {
        return this.conditionList;
    }

    @NotNull
    public final String getConditionString() {
        return this.conditionString;
    }

    @NotNull
    public final String getPeriodString() {
        return this.periodString;
    }

    @NotNull
    public final String getTaskQuery() {
        return this.taskQuery;
    }

    public final boolean isDeleted() {
        return this.isDeleted;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(@NotNull Parcel r10, @Nullable ClassLoader r11, int r12) {
        q.g(r10, "parcel");
    }

    public final void setConditionList(@NotNull List<String> r10) {
        q.g(r10, "<set-?>");
        this.conditionList = r10;
    }

    public final void setConditionString(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.conditionString = r10;
    }

    public final void setDeleted(boolean r10) {
        this.isDeleted = r10;
    }

    public final void setPeriodString(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.periodString = r10;
    }

    public final void setTaskQuery(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.taskQuery = r10;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        q.g(r10, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r10);
        r10.writeString(this.conditionString);
        r10.writeString(this.taskQuery);
        r10.writeString(this.periodString);
        EntityExtKt.g(r10, this.isDeleted);
        r10.writeStringList(this.conditionList);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r10);
        r10.writeInt(0);
    }

    public EventTaskEntity(@NotNull String r13, long r14, long r16, @NotNull String r18, @NotNull String r19, @NotNull String r20, boolean r21, @NotNull List<String> r22) {
        q.g(r13, "id");
        q.g(r18, "conditionString");
        q.g(r19, "taskQuery");
        q.g(r20, "periodString");
        q.g(r22, "conditionList");
        super(r13, r14, r16, EntityType.EVENT_TASK);
        this.conditionString = r18;
        this.taskQuery = r19;
        this.periodString = r20;
        this.isDeleted = r21;
        this.conditionList = r22;
    }
}

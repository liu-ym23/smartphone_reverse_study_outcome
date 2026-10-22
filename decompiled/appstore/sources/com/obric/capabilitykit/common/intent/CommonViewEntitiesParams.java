package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import be.a;
import com.bytedanceos.common.model.AppInfo;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.versionedparcelable.VersionedParcelable;
import com.tmall.wireless.tangram.structure.card.SlideCard;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Keep
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\nJ,\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0016J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0004HÖ\u0001J\u0012\u0010\u001d\u001a\u00020\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001bH\u0016J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\u0019\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0004HÖ\u0001R$\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006&"}, d2 = {"Lcom/obric/capabilitykit/common/intent/CommonViewEntitiesParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", SlideCard.KEY_INDEX, "", "entities", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "(Ljava/lang/Integer;[Lcom/obric/capabilitykit/entity/app/AppEntity;)V", "getEntities", "()[Lcom/obric/capabilitykit/entity/app/AppEntity;", "setEntities", "([Lcom/obric/capabilitykit/entity/app/AppEntity;)V", "[Lcom/obric/capabilitykit/entity/app/AppEntity;", "getIndex", "()Ljava/lang/Integer;", "setIndex", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/Integer;[Lcom/obric/capabilitykit/entity/app/AppEntity;)Lcom/obric/capabilitykit/common/intent/CommonViewEntitiesParams;", "describeContents", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "mergeParams", "params", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class CommonViewEntitiesParams implements IntentParams, Parcelable {

    @NotNull
    public static final Parcelable.Creator<CommonViewEntitiesParams> CREATOR = null;

    @Nullable
    private AppEntity[] entities;

    @Nullable
    private Integer index;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CommonViewEntitiesParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CommonViewEntitiesParams createFromParcel(@NotNull Parcel r10) {
            int r11 = r10.readInt();
            q.g(r10, "parcel");
            AppEntity[] r12 = null;
            if (r10.readInt() != 0) goto L5;
            Integer r13 = null;
        L7:
            if (r10.readInt() == 0) goto L13;
            int r14 = r10.readInt();
            AppEntity[] r15 = new AppEntity[r14];
            int r16 = 0;
        L10:
            if (r16 == r14) goto L12;
            r15[r16] = (AppEntity) r10.readParcelable(CommonViewEntitiesParams.class.getClassLoader());
            r16 = r16 + 1;
            goto L10
        L12:
            r12 = r15;
        L13:
            CommonViewEntitiesParams r17 = new CommonViewEntitiesParams(r13, r12);
            int r18 = Math.min(r11, 0);
            ClassLoader r19 = Creator.class.getClassLoader();
            int r20 = 1;
        L14:
            if (r20 > r18) goto L16;
            r20 = r20 + 1;
        L16:
            if (r20 > r11) goto L18;
            a.d(r10, r19);
            r20 = r20 + 1;
            goto L16
        L18:
            return r17;
        L5:
            r13 = Integer.valueOf(r10.readInt());
            goto L7
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CommonViewEntitiesParams[] newArray(int r10) {
            return new CommonViewEntitiesParams[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CommonViewEntitiesParams createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CommonViewEntitiesParams[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CommonViewEntitiesParams() {
        Object[] r10 = 0 == true ? 1 : 0;
        this(null, r10, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CommonViewEntitiesParams copy$default(CommonViewEntitiesParams r10, Integer r11, AppEntity[] r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.index;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.entities;
    L9:
        return r10.copy(r11, r12);
    }

    @Nullable
    public final Integer component1() {
        return this.index;
    }

    @Nullable
    public final AppEntity[] component2() {
        return this.entities;
    }

    @NotNull
    public final CommonViewEntitiesParams copy(@Nullable Integer r10, @Nullable AppEntity[] r11) {
        return new CommonViewEntitiesParams(r10, r11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof CommonViewEntitiesParams) == true) goto L8;
        return false;
    L8:
        CommonViewEntitiesParams r11 = (CommonViewEntitiesParams) r10;
        if (q.b(this.index, r11.index) == true) goto L12;
        return false;
    L12:
        if (q.b(this.entities, r11.entities) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @Nullable
    public final AppEntity[] getEntities() {
        return this.entities;
    }

    @Nullable
    public final Integer getIndex() {
        return this.index;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @Nullable
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    public int hashCode() {
        Integer r10 = this.index;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        AppEntity[] r14 = this.entities;
        if (r14 == null) goto L11;
        r11 = Arrays.hashCode(r14);
    L11:
        return r13 + r11;
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.DefaultImpls.isParamsCompleted(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @NotNull
    public IntentParams mergeParams(@Nullable Object r10) {
        if ((r10 instanceof CommonViewEntitiesParams) == true) goto L5;
        return this;
    L5:
        Integer r11 = this.index;
        if (r11 != null) goto L8;
        r11 = ((CommonViewEntitiesParams) r10).index;
    L8:
        AppEntity[] r12 = this.entities;
        if (r12 != null) goto L12;
        r12 = ((CommonViewEntitiesParams) r10).entities;
    L12:
        return new CommonViewEntitiesParams(r11, r12);
    }

    public final void setEntities(@Nullable AppEntity[] r10) {
        this.entities = r10;
    }

    public final void setIndex(@Nullable Integer r10) {
        this.index = r10;
    }

    @NotNull
    public String toString() {
        return "CommonViewEntitiesParams(index=" + this.index + ", entities=" + Arrays.toString(this.entities) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        int r12 = 0;
        r10.writeInt(0);
        q.g(r10, "out");
        Integer r13 = this.index;
        if (r13 != null) goto L5;
        r10.writeInt(0);
    L6:
        AppEntity[] r14 = this.entities;
        if (r14 != null) goto L9;
        r10.writeInt(0);
        return;
    L9:
        r10.writeInt(1);
        int r15 = r14.length;
        r10.writeInt(r15);
    L10:
        if (r12 == r15) goto L14;
        r10.writeParcelable(r14[r12], r11);
        r12 = r12 + 1;
        goto L10
    L14:
        return;
    L5:
        r10.writeInt(1);
        r10.writeInt(r13.intValue());
        goto L6
    }

    public CommonViewEntitiesParams(@Nullable Integer r10, @Nullable AppEntity[] r11) {
        this.index = r10;
        this.entities = r11;
    }

    public /* synthetic */ CommonViewEntitiesParams(Integer r10, AppEntity[] r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = null;
    L8:
        this(r10, r11);
    }
}

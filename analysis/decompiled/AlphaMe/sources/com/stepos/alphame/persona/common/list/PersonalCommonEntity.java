package com.stepos.alphame.persona.common.list;

import B0.g;
import androidx.annotation.Keep;
import androidx.room.AbstractC0351g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/stepos/alphame/persona/common/list/PersonalCommonEntity;", "", "title", "", "content", "type", "", "isChecked", "", "(Ljava/lang/String;Ljava/lang/String;IZ)V", "getContent", "()Ljava/lang/String;", "()Z", "setChecked", "(Z)V", "getTitle", "getType", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class PersonalCommonEntity {

    @NotNull
    private final String content;
    private boolean isChecked;

    @NotNull
    private final String title;
    private final int type;

    public PersonalCommonEntity(@NotNull String title, @NotNull String content, int i4, boolean z4) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(content, "content");
        this.title = title;
        this.content = content;
        this.type = i4;
        this.isChecked = z4;
    }

    public static /* synthetic */ PersonalCommonEntity copy$default(PersonalCommonEntity personalCommonEntity, String str, String str2, int i4, boolean z4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = personalCommonEntity.title;
        }
        if ((i5 & 2) != 0) {
            str2 = personalCommonEntity.content;
        }
        if ((i5 & 4) != 0) {
            i4 = personalCommonEntity.type;
        }
        if ((i5 & 8) != 0) {
            z4 = personalCommonEntity.isChecked;
        }
        return personalCommonEntity.copy(str, str2, i4, z4);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component3, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsChecked() {
        return this.isChecked;
    }

    @NotNull
    public final PersonalCommonEntity copy(@NotNull String title, @NotNull String content, int type, boolean isChecked) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(content, "content");
        return new PersonalCommonEntity(title, content, type, isChecked);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PersonalCommonEntity)) {
            return false;
        }
        PersonalCommonEntity personalCommonEntity = (PersonalCommonEntity) other;
        return Intrinsics.areEqual(this.title, personalCommonEntity.title) && Intrinsics.areEqual(this.content, personalCommonEntity.content) && this.type == personalCommonEntity.type && this.isChecked == personalCommonEntity.isChecked;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return Boolean.hashCode(this.isChecked) + g.d(this.type, AbstractC0351g.d(this.content, this.title.hashCode() * 31, 31), 31);
    }

    public final boolean isChecked() {
        return this.isChecked;
    }

    public final void setChecked(boolean z4) {
        this.isChecked = z4;
    }

    @NotNull
    public String toString() {
        String str = this.title;
        String str2 = this.content;
        int i4 = this.type;
        boolean z4 = this.isChecked;
        StringBuilder sbX = g.x("PersonalCommonEntity(title=", str, ", content=", str2, ", type=");
        sbX.append(i4);
        sbX.append(", isChecked=");
        sbX.append(z4);
        sbX.append(")");
        return sbX.toString();
    }
}

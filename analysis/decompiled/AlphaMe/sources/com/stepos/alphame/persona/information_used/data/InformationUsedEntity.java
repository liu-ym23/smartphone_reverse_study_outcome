package com.stepos.alphame.persona.information_used.data;

import B0.g;
import androidx.annotation.Keep;
import androidx.room.AbstractC0351g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/stepos/alphame/persona/information_used/data/InformationUsedEntity;", "", "title", "", "content", "state", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getContent", "()Ljava/lang/String;", "getState", "()Z", "getTitle", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class InformationUsedEntity {

    @NotNull
    private final String content;
    private final boolean state;

    @NotNull
    private final String title;

    public InformationUsedEntity(@NotNull String title, @NotNull String content, boolean z4) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(content, "content");
        this.title = title;
        this.content = content;
        this.state = z4;
    }

    public static /* synthetic */ InformationUsedEntity copy$default(InformationUsedEntity informationUsedEntity, String str, String str2, boolean z4, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = informationUsedEntity.title;
        }
        if ((i4 & 2) != 0) {
            str2 = informationUsedEntity.content;
        }
        if ((i4 & 4) != 0) {
            z4 = informationUsedEntity.state;
        }
        return informationUsedEntity.copy(str, str2, z4);
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
    public final boolean getState() {
        return this.state;
    }

    @NotNull
    public final InformationUsedEntity copy(@NotNull String title, @NotNull String content, boolean state) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(content, "content");
        return new InformationUsedEntity(title, content, state);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InformationUsedEntity)) {
            return false;
        }
        InformationUsedEntity informationUsedEntity = (InformationUsedEntity) other;
        return Intrinsics.areEqual(this.title, informationUsedEntity.title) && Intrinsics.areEqual(this.content, informationUsedEntity.content) && this.state == informationUsedEntity.state;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    public final boolean getState() {
        return this.state;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return Boolean.hashCode(this.state) + AbstractC0351g.d(this.content, this.title.hashCode() * 31, 31);
    }

    @NotNull
    public String toString() {
        String str = this.title;
        String str2 = this.content;
        boolean z4 = this.state;
        StringBuilder sbX = g.x("InformationUsedEntity(title=", str, ", content=", str2, ", state=");
        sbX.append(z4);
        sbX.append(")");
        return sbX.toString();
    }
}

package com.stepos.ailauncher.foundation.appstore.api;

import com.google.gson.JsonPrimitive;
import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/stepos/ailauncher/foundation/appstore/api/AppDetailDto;", "", "name", "", ContentDisposition.Parameters.Size, "Lcom/google/gson/JsonPrimitive;", "icon", "description", "publisher", "<init>", "(Ljava/lang/String;Lcom/google/gson/JsonPrimitive;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getSize", "()Lcom/google/gson/JsonPrimitive;", "getIcon", "getDescription", "getPublisher", "component1", "component2", "component3", "component4", "component5", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AppDetailDto {

    @SerializedName("description")
    private final String description;

    @SerializedName("icon")
    private final String icon;

    @SerializedName("name")
    private final String name;

    @SerializedName("publisher")
    private final String publisher;

    @SerializedName(ContentDisposition.Parameters.Size)
    private final JsonPrimitive size;

    public AppDetailDto() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ AppDetailDto copy$default(AppDetailDto appDetailDto, String str, JsonPrimitive jsonPrimitive, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = appDetailDto.name;
        }
        if ((i10 & 2) != 0) {
            jsonPrimitive = appDetailDto.size;
        }
        if ((i10 & 4) != 0) {
            str2 = appDetailDto.icon;
        }
        if ((i10 & 8) != 0) {
            str3 = appDetailDto.description;
        }
        if ((i10 & 16) != 0) {
            str4 = appDetailDto.publisher;
        }
        String str5 = str4;
        String str6 = str2;
        return appDetailDto.copy(str, jsonPrimitive, str6, str3, str5);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final JsonPrimitive getSize() {
        return this.size;
    }

    /* renamed from: component3, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component5, reason: from getter */
    public final String getPublisher() {
        return this.publisher;
    }

    public final AppDetailDto copy(String name, JsonPrimitive size, String icon, String description, String publisher) {
        return new AppDetailDto(name, size, icon, description, publisher);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppDetailDto)) {
            return false;
        }
        AppDetailDto appDetailDto = (AppDetailDto) other;
        return p.d(this.name, appDetailDto.name) && p.d(this.size, appDetailDto.size) && p.d(this.icon, appDetailDto.icon) && p.d(this.description, appDetailDto.description) && p.d(this.publisher, appDetailDto.publisher);
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPublisher() {
        return this.publisher;
    }

    public final JsonPrimitive getSize() {
        return this.size;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        JsonPrimitive jsonPrimitive = this.size;
        int iHashCode2 = (iHashCode + (jsonPrimitive == null ? 0 : jsonPrimitive.hashCode())) * 31;
        String str2 = this.icon;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.description;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.publisher;
        return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "AppDetailDto(name=" + this.name + ", size=" + this.size + ", icon=" + this.icon + ", description=" + this.description + ", publisher=" + this.publisher + ")";
    }

    public AppDetailDto(String str, JsonPrimitive jsonPrimitive, String str2, String str3, String str4) {
        this.name = str;
        this.size = jsonPrimitive;
        this.icon = str2;
        this.description = str3;
        this.publisher = str4;
    }

    public /* synthetic */ AppDetailDto(String str, JsonPrimitive jsonPrimitive, String str2, String str3, String str4, int i10, i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : jsonPrimitive, (i10 & 4) != 0 ? null : str2, (i10 & 8) != 0 ? null : str3, (i10 & 16) != 0 ? null : str4);
    }
}

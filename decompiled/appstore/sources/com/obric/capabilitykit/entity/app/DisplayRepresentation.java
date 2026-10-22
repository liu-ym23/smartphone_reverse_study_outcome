package com.obric.capabilitykit.entity.app;

import android.net.Uri;
import androidx.annotation.Keep;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedanceos.common.model.AppInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J5\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/obric/capabilitykit/entity/app/DisplayRepresentation;", "", SlardarSettingsConsts.SETTING_IMAGE, "Landroid/net/Uri;", "title", "", "subtitle", "time", "", "(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;J)V", "getImage", "()Landroid/net/Uri;", "getSubtitle", "()Ljava/lang/String;", "getTime", "()J", "getTitle", "component1", "component2", "component3", "component4", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "", "toString", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DisplayRepresentation {

    @Nullable
    private final Uri image;

    @Nullable
    private final String subtitle;
    private final long time;

    @NotNull
    private final String title;

    public DisplayRepresentation(@Nullable Uri r10, @NotNull String r11, @Nullable String r12, long r13) {
        q.g(r11, "title");
        this.image = r10;
        this.title = r11;
        this.subtitle = r12;
        this.time = r13;
    }

    public static /* synthetic */ DisplayRepresentation copy$default(DisplayRepresentation r10, Uri r11, String r12, String r13, long r14, int r15, Object r16) {
        if ((r15 & 1) == 0) goto L6;
        r11 = r10.image;
    L6:
        if ((r15 & 2) == 0) goto L8;
        r12 = r10.title;
    L8:
        String r17 = r12;
        if ((r15 & 4) == 0) goto L11;
        r13 = r10.subtitle;
    L11:
        String r18 = r13;
        if ((r15 & 8) == 0) goto L14;
        r14 = r10.time;
    L14:
        Uri r19 = r11;
        return r10.copy(r19, r17, r18, r14);
    }

    @Nullable
    public final Uri component1() {
        return this.image;
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    @Nullable
    public final String component3() {
        return this.subtitle;
    }

    public final long component4() {
        return this.time;
    }

    @NotNull
    public final DisplayRepresentation copy(@Nullable Uri r10, @NotNull String r11, @Nullable String r12, long r13) {
        q.g(r11, "title");
        return new DisplayRepresentation(r10, r11, r12, r13);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof DisplayRepresentation) == true) goto L8;
        return false;
    L8:
        DisplayRepresentation r11 = (DisplayRepresentation) r10;
        if (q.b(this.image, r11.image) == true) goto L12;
        return false;
    L12:
        if (q.b(this.title, r11.title) == true) goto L15;
        return false;
    L15:
        if (q.b(this.subtitle, r11.subtitle) == true) goto L18;
        return false;
    L18:
        if (this.time == r11.time) goto L20;
        return false;
    L20:
        return true;
    }

    @Nullable
    public final Uri getImage() {
        return this.image;
    }

    @Nullable
    public final String getSubtitle() {
        return this.subtitle;
    }

    public final long getTime() {
        return this.time;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        Uri r10 = this.image;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = ((r12 * 31) + this.title.hashCode()) * 31;
        String r14 = this.subtitle;
        if (r14 == null) goto L11;
        r11 = r14.hashCode();
    L11:
        return ((r13 + r11) * 31) + Long.hashCode(this.time);
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    @NotNull
    public String toString() {
        return "DisplayRepresentation(image=" + this.image + ", title=" + this.title + ", subtitle=" + this.subtitle + ", time=" + this.time + ')';
    }

    public /* synthetic */ DisplayRepresentation(Uri r10, String r11, String r12, long r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L5;
        Uri r16 = null;
    L7:
        if ((r14 & 4) == 0) goto L9;
        String r17 = null;
    L10:
        this(r16, r11, r17, r13);
        return;
    L9:
        r17 = r12;
        goto L10
    L5:
        r16 = r10;
        goto L7
    }
}

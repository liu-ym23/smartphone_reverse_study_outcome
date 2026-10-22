package com.bytedanceos.appstore.buss.entity;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u0006\u0010\u001d\u001a\u00020\u001eJY\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006&"}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/TopicEntity;", "", "id", "", "name", ServerElements.ICON, "type", ServerElements.HEAD_BANNER, ServerElements.BRIEF, "identity", ServerElements.HISTORY_BANNER, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBrief", "()Ljava/lang/String;", "getHead_banner", "getHistory_banner", "getIcon", "getId", "getIdentity", "getName", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "convertTvAppEntity", "Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "", "toString", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TopicEntity {

    @NotNull
    private final String brief;

    @NotNull
    private final String head_banner;

    @NotNull
    private final String history_banner;

    @NotNull
    private final String icon;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @NotNull
    private final String f8433id;

    @NotNull
    private final String identity;

    @NotNull
    private final String name;

    @NotNull
    private final String type;

    public TopicEntity(@NotNull String r10, @NotNull String r11, @NotNull String r12, @NotNull String r13, @NotNull String r14, @NotNull String r15, @NotNull String r16, @NotNull String r17) {
        q.g(r10, "id");
        q.g(r11, "name");
        q.g(r12, ServerElements.ICON);
        q.g(r13, "type");
        q.g(r14, ServerElements.HEAD_BANNER);
        q.g(r15, ServerElements.BRIEF);
        q.g(r16, "identity");
        q.g(r17, ServerElements.HISTORY_BANNER);
        this.f8433id = r10;
        this.name = r11;
        this.icon = r12;
        this.type = r13;
        this.head_banner = r14;
        this.brief = r15;
        this.identity = r16;
        this.history_banner = r17;
    }

    public static /* synthetic */ TopicEntity copy$default(TopicEntity r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, int r19, Object r110) {
        if ((r19 & 1) == 0) goto L5;
        String r20 = r10.f8433id;
    L7:
        if ((r19 & 2) == 0) goto L9;
        String r21 = r10.name;
    L11:
        if ((r19 & 4) == 0) goto L13;
        String r22 = r10.icon;
    L15:
        if ((r19 & 8) == 0) goto L17;
        String r23 = r10.type;
    L19:
        if ((r19 & 16) == 0) goto L21;
        String r24 = r10.head_banner;
    L23:
        if ((r19 & 32) == 0) goto L25;
        String r25 = r10.brief;
    L27:
        if ((r19 & 64) == 0) goto L29;
        String r26 = r10.identity;
    L31:
        if ((r19 & 128) == 0) goto L33;
        String r27 = r10.history_banner;
    L35:
        return r10.copy(r20, r21, r22, r23, r24, r25, r26, r27);
    L33:
        r27 = r18;
        goto L35
    L29:
        r26 = r17;
        goto L31
    L25:
        r25 = r16;
        goto L27
    L21:
        r24 = r15;
        goto L23
    L17:
        r23 = r14;
        goto L19
    L13:
        r22 = r13;
        goto L15
    L9:
        r21 = r12;
        goto L11
    L5:
        r20 = r11;
        goto L7
    }

    @NotNull
    public final String component1() {
        return this.f8433id;
    }

    @NotNull
    public final String component2() {
        return this.name;
    }

    @NotNull
    public final String component3() {
        return this.icon;
    }

    @NotNull
    public final String component4() {
        return this.type;
    }

    @NotNull
    public final String component5() {
        return this.head_banner;
    }

    @NotNull
    public final String component6() {
        return this.brief;
    }

    @NotNull
    public final String component7() {
        return this.identity;
    }

    @NotNull
    public final String component8() {
        return this.history_banner;
    }

    @NotNull
    public final CommonAppEntity convertTvAppEntity() {
        CommonAppEntity r10 = new CommonAppEntity();
        r10.setIcon(this.icon);
        return r10;
    }

    @NotNull
    public final TopicEntity copy(@NotNull String r11, @NotNull String r12, @NotNull String r13, @NotNull String r14, @NotNull String r15, @NotNull String r16, @NotNull String r17, @NotNull String r18) {
        q.g(r11, "id");
        q.g(r12, "name");
        q.g(r13, ServerElements.ICON);
        q.g(r14, "type");
        q.g(r15, ServerElements.HEAD_BANNER);
        q.g(r16, ServerElements.BRIEF);
        q.g(r17, "identity");
        q.g(r18, ServerElements.HISTORY_BANNER);
        return new TopicEntity(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof TopicEntity) == true) goto L8;
        return false;
    L8:
        TopicEntity r11 = (TopicEntity) r10;
        if (q.b(this.f8433id, r11.f8433id) == true) goto L12;
        return false;
    L12:
        if (q.b(this.name, r11.name) == true) goto L15;
        return false;
    L15:
        if (q.b(this.icon, r11.icon) == true) goto L18;
        return false;
    L18:
        if (q.b(this.type, r11.type) == true) goto L21;
        return false;
    L21:
        if (q.b(this.head_banner, r11.head_banner) == true) goto L24;
        return false;
    L24:
        if (q.b(this.brief, r11.brief) == true) goto L27;
        return false;
    L27:
        if (q.b(this.identity, r11.identity) == true) goto L30;
        return false;
    L30:
        if (q.b(this.history_banner, r11.history_banner) == true) goto L32;
        return false;
    L32:
        return true;
    }

    @NotNull
    public final String getBrief() {
        return this.brief;
    }

    @NotNull
    public final String getHead_banner() {
        return this.head_banner;
    }

    @NotNull
    public final String getHistory_banner() {
        return this.history_banner;
    }

    @NotNull
    public final String getIcon() {
        return this.icon;
    }

    @NotNull
    public final String getId() {
        return this.f8433id;
    }

    @NotNull
    public final String getIdentity() {
        return this.identity;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((((((((((this.f8433id.hashCode() * 31) + this.name.hashCode()) * 31) + this.icon.hashCode()) * 31) + this.type.hashCode()) * 31) + this.head_banner.hashCode()) * 31) + this.brief.hashCode()) * 31) + this.identity.hashCode()) * 31) + this.history_banner.hashCode();
    }

    @NotNull
    public String toString() {
        return "TopicEntity(id=" + this.f8433id + ", name=" + this.name + ", icon=" + this.icon + ", type=" + this.type + ", head_banner=" + this.head_banner + ", brief=" + this.brief + ", identity=" + this.identity + ", history_banner=" + this.history_banner + ')';
    }
}

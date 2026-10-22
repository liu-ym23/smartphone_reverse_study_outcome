package com.bytedanceos.appstore.buss.entity.netwrap;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import com.bytedanceos.common.ui.AppPermissionActivity;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003JK\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0006HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/netwrap/AppFeedBackEntity;", "", "source", "", AppPermissionActivity.EXTRA_APP_PKG, "version_code", "", "type", "feedback", ServerElements.SECOND_BAR_PIC, "", "Lcom/bytedanceos/appstore/buss/entity/netwrap/AppFeedBackPicEntity;", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getFeedback", "()Ljava/lang/String;", "getPic", "()Ljava/util/List;", "getPkg", "getSource", "getType", "getVersion_code", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "hashCode", "toString", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AppFeedBackEntity {

    @NotNull
    private final String feedback;

    @NotNull
    private final List<AppFeedBackPicEntity> pic;

    @SerializedName("package")
    @NotNull
    private final String pkg;

    @NotNull
    private final String source;

    @NotNull
    private final String type;
    private final int version_code;

    public AppFeedBackEntity(@NotNull String r10, @NotNull String r11, int r12, @NotNull String r13, @NotNull String r14, @NotNull List<AppFeedBackPicEntity> r15) {
        q.g(r10, "source");
        q.g(r11, AppPermissionActivity.EXTRA_APP_PKG);
        q.g(r13, "type");
        q.g(r14, "feedback");
        q.g(r15, ServerElements.SECOND_BAR_PIC);
        this.source = r10;
        this.pkg = r11;
        this.version_code = r12;
        this.type = r13;
        this.feedback = r14;
        this.pic = r15;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AppFeedBackEntity copy$default(AppFeedBackEntity r10, String r11, String r12, int r13, String r14, String r15, List r16, int r17, Object r18) {
        if ((r17 & 1) == 0) goto L6;
        r11 = r10.source;
    L6:
        if ((r17 & 2) == 0) goto L8;
        r12 = r10.pkg;
    L8:
        String r19 = r12;
        if ((r17 & 4) == 0) goto L11;
        r13 = r10.version_code;
    L11:
        int r20 = r13;
        if ((r17 & 8) == 0) goto L14;
        r14 = r10.type;
    L14:
        String r21 = r14;
        if ((r17 & 16) == 0) goto L17;
        r15 = r10.feedback;
    L17:
        String r22 = r15;
        if ((r17 & 32) == 0) goto L20;
        r16 = r10.pic;
    L20:
        String r23 = r11;
        return r10.copy(r23, r19, r20, r21, r22, r16);
    }

    @NotNull
    public final String component1() {
        return this.source;
    }

    @NotNull
    public final String component2() {
        return this.pkg;
    }

    public final int component3() {
        return this.version_code;
    }

    @NotNull
    public final String component4() {
        return this.type;
    }

    @NotNull
    public final String component5() {
        return this.feedback;
    }

    @NotNull
    public final List<AppFeedBackPicEntity> component6() {
        return this.pic;
    }

    @NotNull
    public final AppFeedBackEntity copy(@NotNull String r10, @NotNull String r11, int r12, @NotNull String r13, @NotNull String r14, @NotNull List<AppFeedBackPicEntity> r15) {
        q.g(r10, "source");
        q.g(r11, AppPermissionActivity.EXTRA_APP_PKG);
        q.g(r13, "type");
        q.g(r14, "feedback");
        q.g(r15, ServerElements.SECOND_BAR_PIC);
        return new AppFeedBackEntity(r10, r11, r12, r13, r14, r15);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof AppFeedBackEntity) == true) goto L8;
        return false;
    L8:
        AppFeedBackEntity r11 = (AppFeedBackEntity) r10;
        if (q.b(this.source, r11.source) == true) goto L12;
        return false;
    L12:
        if (q.b(this.pkg, r11.pkg) == true) goto L15;
        return false;
    L15:
        if (this.version_code == r11.version_code) goto L18;
        return false;
    L18:
        if (q.b(this.type, r11.type) == true) goto L21;
        return false;
    L21:
        if (q.b(this.feedback, r11.feedback) == true) goto L24;
        return false;
    L24:
        if (q.b(this.pic, r11.pic) == true) goto L26;
        return false;
    L26:
        return true;
    }

    @NotNull
    public final String getFeedback() {
        return this.feedback;
    }

    @NotNull
    public final List<AppFeedBackPicEntity> getPic() {
        return this.pic;
    }

    @NotNull
    public final String getPkg() {
        return this.pkg;
    }

    @NotNull
    public final String getSource() {
        return this.source;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    public final int getVersion_code() {
        return this.version_code;
    }

    public int hashCode() {
        return (((((((((this.source.hashCode() * 31) + this.pkg.hashCode()) * 31) + Integer.hashCode(this.version_code)) * 31) + this.type.hashCode()) * 31) + this.feedback.hashCode()) * 31) + this.pic.hashCode();
    }

    @NotNull
    public String toString() {
        return "AppFeedBackEntity(source=" + this.source + ", pkg=" + this.pkg + ", version_code=" + this.version_code + ", type=" + this.type + ", feedback=" + this.feedback + ", pic=" + this.pic + ')';
    }
}

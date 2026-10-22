package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.bytedanceos.common.toolbox.ServerElements;
import com.obric.capabilitykit.entity.EntityExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 02\u00020\u0001:\u00010B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004Be\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0013J\b\u0010'\u001a\u00020(H\u0016J\"\u0010)\u001a\u00020*2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020\rH\u0016J\u0018\u0010.\u001a\u00020*2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\rH\u0016R\u001a\u0010\n\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u0017R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0015\"\u0004\b$\u0010\u0017R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0015\"\u0004\b&\u0010\u0017¨\u00061"}, d2 = {"Lcom/obric/capabilitykit/entity/app/AppInfoEntity;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "appName", "appPackageName", "appStatus", "", "isExactMatch", "", ServerElements.ICON, "openStoreDetailDeeplink", "packageSize", "(Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;IZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppName", "()Ljava/lang/String;", "setAppName", "(Ljava/lang/String;)V", "getAppPackageName", "setAppPackageName", "getAppStatus", "()I", "setAppStatus", "(I)V", "getIcon", "setIcon", "()Z", "setExactMatch", "(Z)V", "getOpenStoreDetailDeeplink", "setOpenStoreDetailDeeplink", "getPackageSize", "setPackageSize", "getDisplayRepresentation", "Lcom/obric/capabilitykit/entity/app/DisplayRepresentation;", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AppInfoEntity extends AppEntity {

    @NotNull
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 0;
    private static final int RELATED_VERSION = 0;
    public static final int STATUS_INSTALLED = 2;
    public static final int STATUS_INSTALLING = 1;
    public static final int STATUS_NOT_INSTALLED = 0;
    public static final int STATUS_UPDATE_AVAILABLE = 4;
    public static final int STATUS_UPDATING = 3;

    @NotNull
    private String appName;

    @NotNull
    private String appPackageName;
    private int appStatus;

    @Nullable
    private String icon;
    private boolean isExactMatch;

    @Nullable
    private String openStoreDetailDeeplink;

    @Nullable
    private String packageSize;

    @Keep
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0006\u0010\u000f\u001a\u00020\u0005J\u001d\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/capabilitykit/entity/app/AppInfoEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/app/AppInfoEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "STATUS_INSTALLED", "STATUS_INSTALLING", "STATUS_NOT_INSTALLED", "STATUS_UPDATE_AVAILABLE", "STATUS_UPDATING", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/app/AppInfoEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<AppInfoEntity> {
        private CREATOR() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public AppInfoEntity createFromParcel(@NotNull Parcel r10) {
            q.g(r10, "parcel");
            AppEntity r11 = AppEntity.CREATOR.createFromParcel(r10);
            q.e(r11, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.AppInfoEntity");
            return (AppInfoEntity) r11;
        }

        public final int getVersion() {
            return 0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public AppInfoEntity[] newArray(int r10) {
            return new AppInfoEntity[r10];
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r10) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AppInfoEntity createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AppInfoEntity[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public AppInfoEntity(@NotNull Parcel r17) {
        q.g(r17, "parcel");
        String r10 = EntityExtKt.f(r17);
        long r11 = r17.readLong();
        long r12 = r17.readLong();
        String r13 = EntityExtKt.f(r17);
        String r14 = EntityExtKt.f(r17);
        int r15 = r17.readInt();
        if (r17.readInt() != 1) goto L5;
        boolean r16 = true;
    L6:
        this(r10, r11, r12, r13, r14, r15, r16, r17.readString(), r17.readString(), r17.readString());
        readExtensionFieldFromParcel$capabilitykitcommon_release(r17);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r17, 0, r17.readInt());
        return;
    L5:
        r16 = false;
        goto L6
    }

    @NotNull
    public final String getAppName() {
        return this.appName;
    }

    @NotNull
    public final String getAppPackageName() {
        return this.appPackageName;
    }

    public final int getAppStatus() {
        return this.appStatus;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    @NotNull
    public DisplayRepresentation getDisplayRepresentation() {
        return new DisplayRepresentation(null, this.appName, null, getLastModifiedTime(), 5, null);
    }

    @Nullable
    public final String getIcon() {
        return this.icon;
    }

    @Nullable
    public final String getOpenStoreDetailDeeplink() {
        return this.openStoreDetailDeeplink;
    }

    @Nullable
    public final String getPackageSize() {
        return this.packageSize;
    }

    public final boolean isExactMatch() {
        return this.isExactMatch;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(@NotNull Parcel r10, @Nullable ClassLoader r11, int r12) {
        q.g(r10, "parcel");
    }

    public final void setAppName(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.appName = r10;
    }

    public final void setAppPackageName(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.appPackageName = r10;
    }

    public final void setAppStatus(int r10) {
        this.appStatus = r10;
    }

    public final void setExactMatch(boolean r10) {
        this.isExactMatch = r10;
    }

    public final void setIcon(@Nullable String r10) {
        this.icon = r10;
    }

    public final void setOpenStoreDetailDeeplink(@Nullable String r10) {
        this.openStoreDetailDeeplink = r10;
    }

    public final void setPackageSize(@Nullable String r10) {
        this.packageSize = r10;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        q.g(r10, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r10);
        r10.writeString(this.appName);
        r10.writeString(this.appPackageName);
        r10.writeInt(this.appStatus);
        r10.writeInt(this.isExactMatch ? 1 : 0);
        r10.writeString(this.icon);
        r10.writeString(this.openStoreDetailDeeplink);
        r10.writeString(this.packageSize);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r10);
        r10.writeInt(0);
    }

    public AppInfoEntity(@NotNull String r11, long r12, long r14, @NotNull String r16, @NotNull String r17, int r18, boolean r19, @Nullable String r20, @Nullable String r21, @Nullable String r22) {
        q.g(r11, "id");
        q.g(r16, "appName");
        q.g(r17, "appPackageName");
        super(r11, r12, r14, EntityType.APP_INFO);
        this.appName = r16;
        this.appPackageName = r17;
        this.appStatus = r18;
        this.isExactMatch = r19;
        this.icon = r20;
        this.openStoreDetailDeeplink = r21;
        this.packageSize = r22;
    }

    public /* synthetic */ AppInfoEntity(String r17, long r18, long r20, String r22, String r23, int r24, boolean r25, String r26, String r27, String r28, int r29, DefaultConstructorMarker r30) {
        if ((r29 & 32) == 0) goto L5;
        int r11 = 0;
    L7:
        if ((r29 & 64) == 0) goto L9;
        boolean r12 = false;
    L11:
        if ((r29 & 128) == 0) goto L13;
        String r13 = null;
    L15:
        if ((r29 & 256) == 0) goto L17;
        String r14 = null;
    L19:
        if ((r29 & 512) == 0) goto L21;
        String r15 = null;
    L22:
        this(r17, r18, r20, r22, r23, r11, r12, r13, r14, r15);
        return;
    L21:
        r15 = r28;
        goto L22
    L17:
        r14 = r27;
        goto L19
    L13:
        r13 = r26;
        goto L15
    L9:
        r12 = r25;
        goto L11
    L5:
        r11 = r24;
        goto L7
    }
}

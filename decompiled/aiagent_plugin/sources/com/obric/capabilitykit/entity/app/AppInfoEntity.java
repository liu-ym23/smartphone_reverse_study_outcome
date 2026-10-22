package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public final class AppInfoEntity extends AppEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 0;
    private static final int RELATED_VERSION = 0;
    public static final int STATUS_INSTALLED = 2;
    public static final int STATUS_INSTALLING = 1;
    public static final int STATUS_NOT_INSTALLED = 0;
    public static final int STATUS_UPDATE_AVAILABLE = 4;
    public static final int STATUS_UPDATING = 3;
    private String appName;
    private String appPackageName;
    private int appStatus;
    private String icon;
    private boolean isExactMatch;
    private String openStoreDetailDeeplink;
    private String packageSize;

    public static final class CREATOR implements Parcelable.Creator<AppInfoEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppInfoEntity createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            AppEntity r1 = AppEntity.CREATOR.createFromParcel(r2);
            o.a(r1, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.AppInfoEntity");
            return (AppInfoEntity) ZeusTransformUtils.preCheckCast(r1, AppInfoEntity.class, "com.obric.aiagent.plugin");
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AppInfoEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppInfoEntity[] newArray(int r1) {
            return new AppInfoEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AppInfoEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public AppInfoEntity(Parcel r17) {
        o.e(r17, "parcel");
        String r3 = EntityExtKt.a(r17);
        long r4 = r17.readLong();
        long r6 = r17.readLong();
        String r8 = EntityExtKt.a(r17);
        String r9 = EntityExtKt.a(r17);
        int r10 = r17.readInt();
        if (r17.readInt() != 1) goto L5;
        boolean r11 = true;
    L6:
        this(r3, r4, r6, r8, r9, r10, r11, r17.readString(), r17.readString(), r17.readString());
        readExtensionFieldFromParcel$capabilitykitcommon_release(r17);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r17, 0, r17.readInt());
        return;
    L5:
        r11 = false;
        goto L6
    }

    public AppInfoEntity(String r11, long r12, long r14, String r16, String r17, int r18, boolean r19, String r20, String r21, String r22) {
        o.e(r11, DbHelper.COL_ID);
        o.e(r16, "appName");
        o.e(r17, "appPackageName");
        super(r11, r12, r14, EntityType.APP_INFO);
        this.appName = r16;
        this.appPackageName = r17;
        this.appStatus = r18;
        this.isExactMatch = r19;
        this.icon = r20;
        this.openStoreDetailDeeplink = r21;
        this.packageSize = r22;
    }

    public /* synthetic */ AppInfoEntity(String r17, long r18, long r20, String r22, String r23, int r24, boolean r25, String r26, String r27, String r28, int r29, h r30) {
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

    public final String getAppName() {
        return this.appName;
    }

    public final String getAppPackageName() {
        return this.appPackageName;
    }

    public final int getAppStatus() {
        return this.appStatus;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public DisplayRepresentation getDisplayRepresentation() {
        return new DisplayRepresentation(null, this.appName, null, getLastModifiedTime(), 5, null);
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getOpenStoreDetailDeeplink() {
        return this.openStoreDetailDeeplink;
    }

    public final String getPackageSize() {
        return this.packageSize;
    }

    public final boolean isExactMatch() {
        return this.isExactMatch;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r1, ClassLoader r2, int r3) {
        o.e(r1, "parcel");
    }

    public final void setAppName(String r2) {
        o.e(r2, "<set-?>");
        this.appName = r2;
    }

    public final void setAppPackageName(String r2) {
        o.e(r2, "<set-?>");
        this.appPackageName = r2;
    }

    public final void setAppStatus(int r1) {
        this.appStatus = r1;
    }

    public final void setExactMatch(boolean r1) {
        this.isExactMatch = r1;
    }

    public final void setIcon(String r1) {
        this.icon = r1;
    }

    public final void setOpenStoreDetailDeeplink(String r1) {
        this.openStoreDetailDeeplink = r1;
    }

    public final void setPackageSize(String r1) {
        this.packageSize = r1;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r1);
        r1.writeString(this.appName);
        r1.writeString(this.appPackageName);
        r1.writeInt(this.appStatus);
        r1.writeInt(this.isExactMatch ? 1 : 0);
        r1.writeString(this.icon);
        r1.writeString(this.openStoreDetailDeeplink);
        r1.writeString(this.packageSize);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r1);
        r1.writeInt(0);
    }
}

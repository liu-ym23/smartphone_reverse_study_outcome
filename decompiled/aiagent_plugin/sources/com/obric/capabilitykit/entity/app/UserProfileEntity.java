package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public final class UserProfileEntity extends AppEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 0;
    private static final int RELATED_VERSION = 0;
    private boolean isFromAutoLearn;
    private String profileKey;
    private String profileValue;

    public static final class CREATOR implements Parcelable.Creator<UserProfileEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserProfileEntity createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            AppEntity r1 = AppEntity.CREATOR.createFromParcel(r2);
            o.a(r1, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.UserProfileEntity");
            return (UserProfileEntity) ZeusTransformUtils.preCheckCast(r1, UserProfileEntity.class, "com.obric.aiagent.plugin");
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ UserProfileEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserProfileEntity[] newArray(int r1) {
            return new UserProfileEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ UserProfileEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public UserProfileEntity(Parcel r11) {
        o.e(r11, "parcel");
        this(EntityExtKt.a(r11), r11.readLong(), r11.readLong(), EntityExtKt.a(r11), EntityExtKt.a(r11), EntityExtKt.b(r11));
        readExtensionFieldFromParcel$capabilitykitcommon_release(r11);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r11, 0, r11.readInt());
    }

    public UserProfileEntity(String r11, long r12, long r14, String r16, String r17, boolean r18) {
        o.e(r11, DbHelper.COL_ID);
        o.e(r16, "profileKey");
        o.e(r17, "profileValue");
        super(r11, r12, r14, EntityType.USER_PROFILE);
        this.profileKey = r16;
        this.profileValue = r17;
        this.isFromAutoLearn = r18;
    }

    public /* synthetic */ UserProfileEntity(String r11, long r12, long r14, String r16, String r17, boolean r18, int r19, h r20) {
        if ((r19 & 32) == 0) goto L5;
        boolean r9 = false;
    L6:
        this(r11, r12, r14, r16, r17, r9);
        return;
    L5:
        r9 = r18;
        goto L6
    }

    public final String getProfileKey() {
        return this.profileKey;
    }

    public final String getProfileValue() {
        return this.profileValue;
    }

    public final boolean isFromAutoLearn() {
        return this.isFromAutoLearn;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r1, ClassLoader r2, int r3) {
        o.e(r1, "parcel");
    }

    public final void setFromAutoLearn(boolean r1) {
        this.isFromAutoLearn = r1;
    }

    public final void setProfileKey(String r2) {
        o.e(r2, "<set-?>");
        this.profileKey = r2;
    }

    public final void setProfileValue(String r2) {
        o.e(r2, "<set-?>");
        this.profileValue = r2;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        super.writeBaseFieldToParcel$capabilitykitcommon_release(r1);
        r1.writeString(this.profileKey);
        r1.writeString(this.profileValue);
        EntityExtKt.a(r1, this.isFromAutoLearn);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r1);
        r1.writeInt(0);
    }
}

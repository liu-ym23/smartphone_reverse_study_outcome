package com.obric.capabilitykit.entity.memory;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class InfoAddressMemoryEntity extends MemoryEntity implements IUriSharerEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 0;
    private static final int RELATED_VERSION = 0;
    private String address;
    private String addressType;

    public static final class CREATOR implements Parcelable.Creator<InfoAddressMemoryEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InfoAddressMemoryEntity createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            AppEntity r1 = AppEntity.CREATOR.createFromParcel(r2);
            o.a(r1, "null cannot be cast to non-null type com.obric.capabilitykit.entity.memory.InfoAddressMemoryEntity");
            return (InfoAddressMemoryEntity) ZeusTransformUtils.preCheckCast(r1, InfoAddressMemoryEntity.class, "com.obric.aiagent.plugin");
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ InfoAddressMemoryEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InfoAddressMemoryEntity[] newArray(int r1) {
            return new InfoAddressMemoryEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ InfoAddressMemoryEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public InfoAddressMemoryEntity(Parcel r11) {
        o.e(r11, "parcel");
        this(EntityExtKt.a(r11), r11.readLong(), r11.readLong(), r11.readInt(), EntityExtKt.a(r11), EntityExtKt.a(r11));
        readMemoryExtensionFieldFromParcel$capabilitykitcommon_release(r11);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r11, 0, r11.readInt());
    }

    public InfoAddressMemoryEntity(String r12, long r13, long r15, int r17, String r18, String r19) {
        o.e(r12, DbHelper.COL_ID);
        o.e(r18, "addressType");
        o.e(r19, SensitiveType.ADDRESS);
        super(r12, r13, r15, EntityType.MEMORY_INFO_ADDRESS, r17);
        this.addressType = r18;
        this.address = r19;
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity
    public JSONObject convertToModelInput() {
        JSONObject r0 = new JSONObject();
        r0.put("type", getType());
        r0.put("createTime", getCreateTime());
        r0.put("modifyTime", getLastModifiedTime());
        r0.put("ecaId", getEcaId());
        r0.put("addressType", makeModelInputValue("常驻地类型", this.addressType));
        r0.put(SensitiveType.ADDRESS, makeModelInputValue("具体地址", this.address));
        return r0;
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getAddressType() {
        return this.addressType;
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity
    public List<Uri> getSharedUris() {
        FileEntity r0 = getScreenshot();
        if (r0 == null) goto L7;
        List<Uri> r1 = r0.getSharedUris();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return p.b();
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r1, ClassLoader r2, int r3) {
        o.e(r1, "parcel");
    }

    public final void setAddress(String r2) {
        o.e(r2, "<set-?>");
        this.address = r2;
    }

    public final void setAddressType(String r2) {
        o.e(r2, "<set-?>");
        this.addressType = r2;
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity, com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        o.e(r2, "parcel");
        writeMemoryBaseFieldToParcel$capabilitykitcommon_release(r2);
        r2.writeString(this.addressType);
        r2.writeString(this.address);
        writeMemoryExtensionFieldToParcel$capabilitykitcommon_release(r2, r3);
        r2.writeInt(0);
    }
}

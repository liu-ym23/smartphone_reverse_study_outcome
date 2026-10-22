package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public final class ProactiveMemoryEntity extends AppEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 2;
    private static final int RELATED_VERSION = 0;
    private String content;
    private Integer productType;
    private String title;

    public static final class CREATOR implements Parcelable.Creator<ProactiveMemoryEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProactiveMemoryEntity createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            AppEntity r1 = AppEntity.CREATOR.createFromParcel(r2);
            o.a(r1, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.ProactiveMemoryEntity");
            return (ProactiveMemoryEntity) ZeusTransformUtils.preCheckCast(r1, ProactiveMemoryEntity.class, "com.obric.aiagent.plugin");
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ProactiveMemoryEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProactiveMemoryEntity[] newArray(int r1) {
            return new ProactiveMemoryEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ProactiveMemoryEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public ProactiveMemoryEntity(Parcel r12) {
        o.e(r12, "parcel");
        this(EntityExtKt.a(r12), r12.readLong(), r12.readLong(), EntityExtKt.a(r12), null, 16, null);
        readExtensionFieldFromParcel$capabilitykitcommon_release(r12);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r12, 2, r12.readInt());
    }

    public ProactiveMemoryEntity(String r9, long r10, long r12, String r14, String r15) {
        o.e(r9, DbHelper.COL_ID);
        o.e(r14, "content");
        super(r9, r10, r12, EntityType.PROACTIVE_MEMORY);
        this.content = r14;
        this.title = r15;
    }

    public /* synthetic */ ProactiveMemoryEntity(String r10, long r11, long r13, String r15, String r16, int r17, h r18) {
        if ((r17 & 16) == 0) goto L5;
        String r8 = null;
    L6:
        this(r10, r11, r13, r15, r8);
        return;
    L5:
        r8 = r16;
        goto L6
    }

    public final String getContent() {
        return this.content;
    }

    public final Integer getProductType() {
        return this.productType;
    }

    public final String getTitle() {
        return this.title;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r3, ClassLoader r4, int r5) {
        o.e(r3, "parcel");
        if (r5 != 1) goto L5;
        this.title = (String) ZeusTransformUtils.preCheckCast(r3.readValue(r4), String.class, "com.obric.aiagent.plugin");
        return;
    L5:
        if (r5 != 2) goto L11;
        this.productType = (Integer) ZeusTransformUtils.preCheckCast(r3.readValue(r4), Integer.class, "com.obric.aiagent.plugin");
        return;
    }

    public final void setContent(String r2) {
        o.e(r2, "<set-?>");
        this.content = r2;
    }

    public final void setProductType(Integer r1) {
        this.productType = r1;
    }

    public final void setTitle(String r1) {
        this.title = r1;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r1);
        r1.writeString(this.content);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r1);
        r1.writeInt(2);
        r1.writeValue(this.title);
        r1.writeValue(this.productType);
    }
}

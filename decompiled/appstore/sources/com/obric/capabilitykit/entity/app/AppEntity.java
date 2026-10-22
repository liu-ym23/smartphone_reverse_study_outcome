package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.JsonParser;
import com.obric.capabilitykit.PackageUtils;
import com.obric.capabilitykit.common.b0;
import com.obric.capabilitykit.common.l;
import com.obric.capabilitykit.common.w;
import com.obric.capabilitykit.entity.EntityContextHolder;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.utils.ParcelUtils;
import java.lang.reflect.GenericDeclaration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0014\b'\u0018\u0000 V2\u00020\u0001:\u0001VB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B%\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u000e\u00105\u001a\u0002062\u0006\u0010\u001a\u001a\u00020$J\u0006\u00107\u001a\u000206J\b\u00108\u001a\u00020\u000bH\u0016J\b\u00109\u001a\u00020:H\u0016J\b\u0010;\u001a\u0004\u0018\u00010\u0006J\b\u0010<\u001a\u0004\u0018\u00010\u0006J\u0010\u0010=\u001a\u0004\u0018\u00010$2\u0006\u0010>\u001a\u00020\u0006J\u0006\u0010?\u001a\u00020\u0006J\b\u0010@\u001a\u00020\u000bH\u0016J\"\u0010A\u001a\u0002062\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010B\u001a\u0004\u0018\u00010C2\u0006\u0010D\u001a\u00020\u000bH&J\u0015\u0010E\u001a\u0002062\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\bFJ%\u0010G\u001a\u0002062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010H\u001a\u00020\u000b2\u0006\u0010I\u001a\u00020\u000bH\u0000¢\u0006\u0002\bJJ\u0010\u0010K\u001a\u0002062\b\u0010L\u001a\u0004\u0018\u00010\u0006J\u0010\u0010M\u001a\u0002062\b\u0010N\u001a\u0004\u0018\u00010\u0006J\b\u0010O\u001a\u00020\u0006H\u0016J\u0015\u0010P\u001a\u0002062\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\bQJ\u0015\u0010R\u001a\u0002062\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\bSJ\u0018\u0010T\u001a\u0002062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010U\u001a\u00020\u000bH\u0016R\u001a\u0010\r\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0011R\"\u0010\"\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001e\u0010*\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u000f\"\u0004\b.\u0010\u0011R\u001a\u0010\t\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0013\"\u0004\b0\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b1\u0010,R\u001c\u00102\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u000f\"\u0004\b4\u0010\u0011¨\u0006W"}, d2 = {"Lcom/obric/capabilitykit/entity/app/AppEntity;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "lastModifiedTime", "type", "", "(Ljava/lang/String;JJI)V", "_packageName", "get_packageName", "()Ljava/lang/String;", "set_packageName", "(Ljava/lang/String;)V", "getCreateTime", "()J", "setCreateTime", "(J)V", "ecaId", "ecaRawContent", CommonKey.KEY_VALUE, "", WsConstants.KEY_EXTRA, "getExtra", "()Ljava/lang/Object;", "setExtra", "(Ljava/lang/Object;)V", "extraData", "getExtraData", "setExtraData", "extras", "", "Lcom/obric/capabilitykit/entity/app/ExtraEntity;", "getExtras", "()Ljava/util/List;", "setExtras", "(Ljava/util/List;)V", "<set-?>", "hashCodeValue", "getHashCodeValue", "()I", "getId", "setId", "getLastModifiedTime", "setLastModifiedTime", "getType", "uuid", "getUuid", "setUuid", "addExtraEntity", "", "countHashCode", "describeContents", "getDisplayRepresentation", "Lcom/obric/capabilitykit/entity/app/DisplayRepresentation;", "getEcaId", "getEcaRawContent", "getExtraEntity", "key", "getPackageName", "hashCode", "onReadSubClassExtensionField", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "readExtensionFieldFromParcel", "readExtensionFieldFromParcel$capabilitykitcommon_release", "readSubClassExtensionFieldFromParcel", "ourVersion", "theirVersion", "readSubClassExtensionFieldFromParcel$capabilitykitcommon_release", "setEcaId", "uniqueId", "setEcaRawContent", "rawContent", "toString", "writeBaseFieldToParcel", "writeBaseFieldToParcel$capabilitykitcommon_release", "writeExtensionFieldToParcel", "writeExtensionFieldToParcel$capabilitykitcommon_release", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class AppEntity implements Parcelable {

    @NotNull
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 6;
    private static final int RELATED_VERSION = 0;

    @NotNull
    private String _packageName;
    private long createTime;

    @Nullable
    private String ecaId;

    @Nullable
    private String ecaRawContent;

    @Nullable
    private transient Object extra;

    @Nullable
    private String extraData;

    @Nullable
    private List<ExtraEntity> extras;
    private int hashCodeValue;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @NotNull
    private String f11322id;
    private long lastModifiedTime;
    private final int type;

    @Nullable
    private String uuid;

    @Keep
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\u000e\u001a\u00020\u0005J\u001d\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/capabilitykit/entity/app/AppEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "fromJson", "json", "", "fromJsonKeepTimeStamp", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/app/AppEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<AppEntity> {
        private CREATOR() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public AppEntity createFromParcel(@NotNull Parcel r10) {
            q.g(r10, "parcel");
            int r11 = r10.readInt();
            EntityClassData<? extends AppEntity> r12 = EntityType.INSTANCE.getClassMap().get(Integer.valueOf(r11));
            if (r12 == null) goto L9;
            Function1<Parcel, T> r13 = r12.getParcelConstructor();
            if (r13 == 0) goto L9;
            return (AppEntity) r13.invoke(r10);
        L9:
            throw new UnsupportedOperationException("failed to construct AppEntity for type " + r11);
        }

        @NotNull
        public final AppEntity fromJson(@NotNull String r10) {
            q.g(r10, "json");
            Object r11 = EntityExtKt.a().fromJson(r10, AppEntity.class);
            q.f(r11, "entityGson.fromJson(json, AppEntity::class.java)");
            return (AppEntity) r11;
        }

        @NotNull
        public final AppEntity fromJsonKeepTimeStamp(@NotNull String r10) {
            q.g(r10, "json");
            int r11 = new JsonParser().parse(r10).getAsJsonObject().get("type").getAsInt();
            EntityClassData<? extends AppEntity> r12 = EntityType.INSTANCE.getClassMap().get(Integer.valueOf(r11));
            if (r12 == null) goto L9;
            GenericDeclaration r13 = r12.getClazz();
            if (r13 == null) goto L9;
            Object r14 = EntityExtKt.b().fromJson(r10, r13);
            q.f(r14, "entityKeepTimeStampGson.…omJson(json, targetClass)");
            return (AppEntity) r14;
        L9:
            throw new IllegalArgumentException("Unknown entity type: " + r11);
        }

        public final int getVersion() {
            return 6;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public AppEntity[] newArray(int r10) {
            return new AppEntity[r10];
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r10) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AppEntity createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AppEntity[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public AppEntity(@NotNull Parcel r10) {
        q.g(r10, "parcel");
        this(EntityExtKt.f(r10), r10.readLong(), r10.readLong(), r10.readInt());
        throw new UnsupportedOperationException("Don't construct AppEntity Directly, use subclass instead");
    }

    public final void addExtraEntity(@NotNull ExtraEntity r10) {
        q.g(r10, WsConstants.KEY_EXTRA);
        if (this.extras != null) goto L5;
        this.extras = new ArrayList();
    L5:
        List<ExtraEntity> r11 = this.extras;
        q.d(r11);
        r11.add(r10);
    }

    public final void countHashCode() {
        this.hashCodeValue = hashCode();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    @NotNull
    public DisplayRepresentation getDisplayRepresentation() {
        throw new UnsupportedOperationException("entity not implementation getDisplayRepresentation method");
    }

    @Nullable
    public final String getEcaId() {
        return this.ecaId;
    }

    @Nullable
    public final String getEcaRawContent() {
        return this.ecaRawContent;
    }

    @Nullable
    public final Object getExtra() {
        return this.extra;
    }

    @Nullable
    public final String getExtraData() {
        return this.extraData;
    }

    @Nullable
    public final ExtraEntity getExtraEntity(@NotNull String r10) {
        q.g(r10, "key");
        List<ExtraEntity> r11 = this.extras;
        Object r12 = null;
        if (r11 == null) goto L15;
        Iterator<T> r13 = r11.iterator();
    L6:
        if (r13.hasNext() == false) goto L11;
        Object r14 = r13.next();
        if (q.b(((ExtraEntity) r14).getKey(), r10) == false) goto L6;
        r12 = r14;
    L11:
        return (ExtraEntity) r12;
    L15:
        return null;
    }

    @Nullable
    public final List<ExtraEntity> getExtras() {
        return this.extras;
    }

    public final int getHashCodeValue() {
        return this.hashCodeValue;
    }

    @NotNull
    public final String getId() {
        return this.f11322id;
    }

    public final long getLastModifiedTime() {
        return this.lastModifiedTime;
    }

    @NotNull
    public final String getPackageName() {
        return this._packageName;
    }

    public final int getType() {
        return this.type;
    }

    @Nullable
    public final String getUuid() {
        return this.uuid;
    }

    @NotNull
    public final String get_packageName() {
        return this._packageName;
    }

    public int hashCode() {
        b0 r10 = w.f11308a.a().get(getClass().getName());
        if (r10 == null) goto L7;
        return (r10.a(this) * 31) + l.f11293a.a(this);
    L7:
        throw new IllegalStateException("not found entity generatorHashCode function, entityName: " + getClass().getName());
    }

    public abstract void onReadSubClassExtensionField(@NotNull Parcel r10, @Nullable ClassLoader r11, int r12);

    public final void readExtensionFieldFromParcel$capabilitykitcommon_release(@NotNull Parcel r10) {
        q.g(r10, "parcel");
        int r11 = r10.readInt();
        this._packageName = EntityExtKt.f(r10);
        this.extras = r10.createTypedArrayList(ExtraEntity.CREATOR);
        int r12 = 6;
        if (r11 > 6) goto L6;
        r12 = r11;
    L6:
        ClassLoader r13 = AppEntity.class.getClassLoader();
        int r14 = 1;
    L7:
        if (r14 > r12) goto L30;
        String r15 = null;
        switch(r14) {
            case 1: goto L28;
            case 2: goto L27;
            case 3: goto L23;
            case 4: goto L19;
            case 5: goto L15;
            case 6: goto L11;
            default: goto L29;
        };
    L11:
        Object r16 = ParcelUtils.INSTANCE.readValueSafely(r10, r13);
        if ((r16 instanceof String) == false) goto L14;
        r15 = (String) r16;
    L14:
        this.uuid = r15;
        goto L29
    L15:
        Object r17 = ParcelUtils.INSTANCE.readValueSafely(r10, r13);
        if ((r17 instanceof String) == false) goto L18;
        r15 = (String) r17;
    L18:
        this.ecaRawContent = r15;
        goto L29
    L19:
        Object r18 = ParcelUtils.INSTANCE.readValueSafely(r10, r13);
        if ((r18 instanceof String) == false) goto L22;
        r15 = (String) r18;
    L22:
        this.ecaId = r15;
        goto L29
    L23:
        Object r19 = ParcelUtils.INSTANCE.readValueSafely(r10, r13);
        if ((r19 instanceof String) == false) goto L26;
        r15 = (String) r19;
    L26:
        this.extraData = r15;
        goto L29
    L27:
        Object r20 = r10.readValue(r13);
        q.e(r20, "null cannot be cast to non-null type kotlin.Int");
        this.hashCodeValue = ((Integer) r20).intValue();
        goto L29
    L28:
        setExtra(ParcelUtils.INSTANCE.readValueSafely(r10, r13));
    L29:
        r14 = r14 + 1;
    L30:
        if (r14 > r11) goto L32;
        ParcelUtils.INSTANCE.skipValueSafely(r10, r13);
        r14 = r14 + 1;
        goto L30
    }

    public final void readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(@NotNull Parcel r10, int r11, int r12) {
        q.g(r10, "parcel");
        if (r12 > r11) goto L6;
        r11 = r12;
    L6:
        ClassLoader r13 = AppEntity.class.getClassLoader();
        int r14 = 1;
    L7:
        if (r14 > r11) goto L9;
        onReadSubClassExtensionField(r10, r13, r14);
        r14 = r14 + 1;
    L9:
        if (r14 > r12) goto L11;
        ParcelUtils.INSTANCE.skipValueSafely(r10, r13);
        r14 = r14 + 1;
        goto L9
    }

    public final void setCreateTime(long r10) {
        this.createTime = r10;
    }

    public final void setEcaId(@Nullable String r10) {
        this.ecaId = r10;
    }

    public final void setEcaRawContent(@Nullable String r10) {
        this.ecaRawContent = r10;
    }

    public final void setExtra(@Nullable Object r10) {
        if (EntityExtKt.d(r10) == false) goto L6;
        this.extra = r10;
        return;
    L6:
        StringBuilder r11 = new StringBuilder();
        r11.append("extra value type ");
        q.d(r10);
        r11.append(r10.getClass().getName());
        r11.append(" is not supported");
        throw new IllegalArgumentException(r11.toString());
    }

    public final void setExtraData(@Nullable String r10) {
        this.extraData = r10;
    }

    public final void setExtras(@Nullable List<ExtraEntity> r10) {
        this.extras = r10;
    }

    public final void setId(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.f11322id = r10;
    }

    public final void setLastModifiedTime(long r10) {
        this.lastModifiedTime = r10;
    }

    public final void setUuid(@Nullable String r10) {
        this.uuid = r10;
    }

    public final void set_packageName(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this._packageName = r10;
    }

    @NotNull
    public String toString() {
        return EntityExtKt.toJson(this);
    }

    public final void writeBaseFieldToParcel$capabilitykitcommon_release(@NotNull Parcel r10) {
        q.g(r10, "parcel");
        r10.writeInt(this.type);
        r10.writeString(this.f11322id);
        r10.writeLong(this.createTime);
        r10.writeLong(this.lastModifiedTime);
    }

    public final void writeExtensionFieldToParcel$capabilitykitcommon_release(@NotNull Parcel r10) {
        q.g(r10, "parcel");
        r10.writeInt(6);
        r10.writeString(this._packageName);
        r10.writeTypedList(this.extras);
        r10.writeValue(this.extra);
        r10.writeValue(Integer.valueOf(this.hashCodeValue));
        r10.writeValue(this.extraData);
        r10.writeValue(this.ecaId);
        r10.writeValue(this.ecaRawContent);
        r10.writeValue(this.uuid);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        q.g(r10, "parcel");
        throw new UnsupportedOperationException("Don't construct AppEntity Directly, use subclass instead");
    }

    public AppEntity(@NotNull String r10, long r11, long r12, int r13) {
        q.g(r10, "id");
        this.f11322id = r10;
        this.createTime = r11;
        this.lastModifiedTime = r12;
        this.type = r13;
        this._packageName = "";
        String r14 = EntityContextHolder.INSTANCE.getPackageName();
        if (PackageUtils.INSTANCE.isMemoryPackageName(r14) == false) goto L13;
        if ((this instanceof ContactEntity) == false) goto L7;
    L16:
        r14 = "com.android.contacts";
    L17:
        this._packageName = r14;
        return;
    L7:
        if ((this instanceof CallHistoryEntity) == true) goto L16;
        if ((this instanceof MessageEntity) == false) goto L17;
        this._packageName = "com.android.mms";
        return;
    L13:
        if (q.b("com.android.mms", r14) == false) goto L17;
        if ((this instanceof ContactEntity) == false) goto L17;
        goto L16
    }
}

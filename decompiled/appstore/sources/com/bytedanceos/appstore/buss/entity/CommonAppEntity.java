package com.bytedanceos.appstore.buss.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedanceos.appstore.buss.entity.item.CommonAppItem;
import com.bytedanceos.common.networkv2.entity.AppEntity;
import com.bytedanceos.common.toolbox.ServerElements;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Parcelize
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\u0006\u0010'\u001a\u00020\u000bJ\u000e\u0010(\u001a\u00020)2\u0006\u0010'\u001a\u00020\u000bJ\u0019\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020&HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR\u001c\u0010\"\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\t¨\u0006."}, d2 = {"Lcom/bytedanceos/appstore/buss/entity/CommonAppEntity;", "Lcom/bytedanceos/common/networkv2/entity/AppEntity;", "Landroid/os/Parcelable;", "()V", ServerElements.BANNER, "", "getBanner", "()Ljava/lang/String;", "setBanner", "(Ljava/lang/String;)V", "checkState", "", "getCheckState", "()Z", "setCheckState", "(Z)V", ServerElements.ICON, "getIcon", "setIcon", "item", "Lcom/bytedanceos/appstore/buss/entity/item/CommonAppItem;", "getItem", "()Lcom/bytedanceos/appstore/buss/entity/item/CommonAppItem;", "setItem", "(Lcom/bytedanceos/appstore/buss/entity/item/CommonAppItem;)V", "pageTitle", "getPageTitle", "setPageTitle", ServerElements.TOPIC_ID, "getTopic_id", "setTopic_id", ServerElements.VIDEO_IMG, "getVideo_img", "setVideo_img", ServerElements.VIDEO_PATH, "getVideo_url", "setVideo_url", "describeContents", "", "isChecked", "setChecked", "", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CommonAppEntity extends AppEntity implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<CommonAppEntity> CREATOR = null;

    @Nullable
    private String banner;
    private boolean checkState;

    @Nullable
    private String icon;

    @Nullable
    private CommonAppItem item;

    @Nullable
    private String pageTitle;

    @Nullable
    private String topic_id;

    @Nullable
    private String video_img;

    @Nullable
    private String video_url;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CommonAppEntity> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CommonAppEntity createFromParcel(@NotNull Parcel r10) {
            q.g(r10, "parcel");
            r10.readInt();
            return new CommonAppEntity();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final CommonAppEntity[] newArray(int r10) {
            return new CommonAppEntity[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CommonAppEntity createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CommonAppEntity[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public CommonAppEntity() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final String getBanner() {
        return this.banner;
    }

    public final boolean getCheckState() {
        return this.checkState;
    }

    @Nullable
    public final String getIcon() {
        return this.icon;
    }

    @Nullable
    public final CommonAppItem getItem() {
        return this.item;
    }

    @Nullable
    public final String getPageTitle() {
        return this.pageTitle;
    }

    @Nullable
    public final String getTopic_id() {
        return this.topic_id;
    }

    @Nullable
    public final String getVideo_img() {
        return this.video_img;
    }

    @Nullable
    public final String getVideo_url() {
        return this.video_url;
    }

    public final boolean isChecked() {
        if (getDefault_check() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final void setBanner(@Nullable String r10) {
        this.banner = r10;
    }

    public final void setCheckState(boolean r10) {
        this.checkState = r10;
    }

    public final void setChecked(boolean r10) {
        setDefault_check(r10 ? 1 : 0);
    }

    public final void setIcon(@Nullable String r10) {
        this.icon = r10;
    }

    public final void setItem(@Nullable CommonAppItem r10) {
        this.item = r10;
    }

    public final void setPageTitle(@Nullable String r10) {
        this.pageTitle = r10;
    }

    public final void setTopic_id(@Nullable String r10) {
        this.topic_id = r10;
    }

    public final void setVideo_img(@Nullable String r10) {
        this.video_img = r10;
    }

    public final void setVideo_url(@Nullable String r10) {
        this.video_url = r10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        q.g(r10, "out");
        r10.writeInt(1);
    }
}

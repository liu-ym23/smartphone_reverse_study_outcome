package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.live.base.model.m;
import com.bytedance.android.livesdk.gift.model.b1;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import py.k;

/* JADX INFO: loaded from: classes12.dex */
@ForMain
@JsonAdapter(FlexModelJsonAdapter.class)
public class BannerInRoom extends FlexModelBase<b1> implements b1 {
    public static final int TYPE_ACTION_FULL_WEB = 3;
    public static final int TYPE_ACTION_HALF_WEB = 2;
    public static final int TYPE_ACTION_SCHEMA = 1;
    public static final int TYPE_ACTIVITY = 6;
    public static final int TYPE_TASK_GIFT = 30;

    @SerializedName("action_type")
    int actionType;

    @SerializedName("extra")
    String extra;

    @SerializedName("frame_type")
    int frameType;

    @SerializedName("height")
    int height;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    long f162578id;

    @SerializedName("image")
    k image;

    @SerializedName("priority")
    int priority;

    @SerializedName(a.KEY_SCHEMA_URL)
    String schemaUrl;

    @SerializedName("text")
    String text;

    @SerializedName("title")
    String title;

    @SerializedName("tracking_type")
    List<String> trackingTypes;

    @SerializedName("uid")
    long uid;

    @SerializedName("width")
    int width;

    public BannerInRoom() {
        super(b1.class);
    }

    public String toString() {
        return "BannerInRoom{id=" + this.f162578id + ", title='" + this.title + "', image=" + this.image + ", height=" + this.height + ", width=" + this.width + ", schemaUrl='" + this.schemaUrl + "', text='" + this.text + "', actionType=" + this.actionType + ", priority=" + this.priority + ", frameType=" + this.frameType + ", extra='" + this.extra + "', uid=" + this.uid + '}';
    }

    @Override // com.bytedance.android.livesdk.gift.model.b1
    public int getActionType() {
        return this.actionType;
    }

    @Override // com.bytedance.android.livesdk.gift.model.b1
    public String getExtra() {
        return this.extra;
    }

    @Override // com.bytedance.android.livesdk.gift.model.b1
    public int getFrameType() {
        return this.frameType;
    }

    @Override // com.bytedance.android.livesdk.gift.model.b1
    public int getHeight() {
        return this.height;
    }

    @Override // com.bytedance.android.livesdk.gift.model.b1
    public long getId() {
        return this.f162578id;
    }

    @Override // com.bytedance.android.livesdk.gift.model.b1
    public k getImage() {
        return this.image;
    }

    @Override // com.bytedance.android.livesdk.gift.model.b1
    public int getPriority() {
        return this.priority;
    }

    @Override // com.bytedance.android.livesdk.gift.model.b1
    public String getSchemaUrl() {
        return this.schemaUrl;
    }

    @Override // com.bytedance.android.livesdk.gift.model.b1
    public String getText() {
        return this.text;
    }

    @Override // com.bytedance.android.livesdk.gift.model.b1
    public String getTitle() {
        return this.title;
    }

    @Override // com.bytedance.android.livesdk.gift.model.b1
    public List<String> getTrackingTypes() {
        return this.trackingTypes;
    }

    public long getUid() {
        return this.uid;
    }

    @Override // com.bytedance.android.livesdk.gift.model.b1
    public int getWidth() {
        return this.width;
    }

    @Override // com.bytedance.android.livesdk.gift.model.b1
    public void setActionType(int r100) {
        this.actionType = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.model.b1
    public void setHeight(int r100) {
        this.height = r100;
    }

    public void setId(long r100) {
        this.f162578id = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.model.b1
    public void setImage(k r100) {
        this.image = (k) m.b(r100, k.class);
    }

    public void setPriority(int r100) {
        this.priority = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.model.b1
    public void setSchemaUrl(String r100) {
        this.schemaUrl = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.model.b1
    public void setText(String r100) {
        this.text = r100;
    }

    public void setTitle(String r100) {
        this.title = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.model.b1
    public void setTrackingTypes(List<String> r100) {
        this.trackingTypes = r100;
    }

    public void setUid(long r100) {
        this.uid = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.model.b1
    public void setWidth(int r100) {
        this.width = r100;
    }
}

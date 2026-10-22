package com.bytedance.android.live.liveinteract.videotalk.emoji.model;

import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.tools.kcp.modelx.runtime.internal.FlexModelDelegate;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class InteractEmojiAnim extends d implements vh7.c.a<f>, f {
    public static final int TYPE_ICON_MOVE = 1;
    public static final int TYPE_MIC_SEAT = 4;
    public static final int TYPE_TRACK_EFFECT = 2;
    public static final int TYPE_TRANS_EFFECT = 3;
    public static final int TYPE_UNDEFINED = 0;

    @SerializedName("interact_emoji")
    public py.k dynamicImage;

    @SerializedName("own_emoji")
    public py.k extraDynamicImage;
    private transient FlexModelDelegate<f> modelDefaultDelegate;

    @IgnoreProtoFieldCheck
    @SerializedName("interact_emojis")
    public List<py.k> resources;

    public InteractEmojiAnim() {
        this.modelDefaultDelegate = new FlexModelDelegate(f.class, this);
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.d, com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public py.k dynamicImage() {
        return this.dynamicImage;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.d, com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public py.k extraDynamicImage() {
        return this.extraDynamicImage;
    }

    @Override // vh7.c.a
    public FlexModelDelegate<f> getDelegate() {
        return this.modelDefaultDelegate;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public long getDuration() {
        return this.duration;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public py.k getDynamicImage() {
        return this.dynamicImage;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public long getExtraDuration() {
        return this.extraDuration;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public py.k getExtraDynamicImage() {
        return this.extraDynamicImage;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public int getLevel() {
        return this.level;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public long getOffset() {
        return this.offset;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public int getOffsetStart() {
        return this.offsetStart;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public boolean getReshape() {
        return this.reshape;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public Long getReshapeStart() {
        return this.reshapeStart;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public List<py.k> getResources() {
        return this.resources;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public long getSizeScale() {
        return this.sizeScale;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public String getSoundUrl() {
        return this.soundUrl;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public long getStart() {
        return this.start;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public int getTimeOffset() {
        return this.timeOffset;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public int getType() {
        return this.type;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public int getX() {
        return this.f79386x;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public int getY() {
        return this.f79387y;
    }

    public boolean isReshape() {
        return this.reshape;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.d, com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public List<? extends py.k> resources() {
        return this.resources;
    }

    @Override // vh7.c.a, vh7.c
    public <R extends vh7.e<f>> R castTo(Class<R> r100) {
        return (R) this.modelDefaultDelegate.castTo(r100);
    }

    @Override // vh7.c.a, vh7.c
    public <R extends vh7.e<f>> R castToOrNull(Class<R> r100) {
        return (R) this.modelDefaultDelegate.castToOrNull(r100);
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public void setDuration(long r100) {
        this.duration = r100;
    }

    public void setDynamicImage(py.k r100) {
        this.dynamicImage = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public void setExtraDuration(long r100) {
        this.extraDuration = r100;
    }

    public void setExtraDynamicImage(py.k r100) {
        this.extraDynamicImage = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public void setLevel(int r100) {
        this.level = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public void setOffset(long r100) {
        this.offset = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public void setOffsetStart(int r100) {
        this.offsetStart = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public void setReshape(boolean r100) {
        this.reshape = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public void setReshapeStart(Long r100) {
        this.reshapeStart = r100;
    }

    public void setResources(List<py.k> r100) {
        this.resources = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public void setSizeScale(long r100) {
        this.sizeScale = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public void setSoundUrl(String r100) {
        this.soundUrl = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public void setStart(long r100) {
        this.start = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public void setTimeOffset(int r100) {
        this.timeOffset = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public void setType(int r100) {
        this.type = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public void setX(int r100) {
        this.f79386x = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.videotalk.emoji.model.f
    public void setY(int r100) {
        this.f79387y = r100;
    }
}

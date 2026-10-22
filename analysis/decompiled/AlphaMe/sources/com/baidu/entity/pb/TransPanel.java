package com.baidu.entity.pb;

import L1.a;
import L1.b;
import L1.d;
import L1.e;
import L1.f;
import java.io.IOException;

/* loaded from: classes.dex */
public final class TransPanel extends f {
    public static final int BASE_MAP_TYPE_FIELD_NUMBER = 8;
    public static final int CONTENT_FIELD_NUMBER = 1;
    public static final int DISPLAY_DURATION_FIELD_NUMBER = 3;
    public static final int DISPLAY_TIME_TYPE_FIELD_NUMBER = 9;
    public static final int ICON_ID_FIELD_NUMBER = 5;
    public static final int IS_DEFAULT_CHOOSE_FIELD_NUMBER = 6;
    public static final int PATTERN_FIELD_NUMBER = 4;
    public static final int SCENE_ID_FIELD_NUMBER = 7;
    public static final int SUB_CONTENT_FIELD_NUMBER = 2;
    private int baseMapType_;
    private int cachedSize;
    private a content_;
    private int displayDuration_;
    private int displayTimeType_;
    private boolean hasBaseMapType;
    private boolean hasContent;
    private boolean hasDisplayDuration;
    private boolean hasDisplayTimeType;
    private boolean hasIconId;
    private boolean hasIsDefaultChoose;
    private boolean hasPattern;
    private boolean hasSceneId;
    private boolean hasSubContent;
    private int iconId_;
    private int isDefaultChoose_;
    private int pattern_;
    private int sceneId_;
    private a subContent_;

    public TransPanel() {
        a aVar = a.f1216c;
        this.content_ = aVar;
        this.subContent_ = aVar;
        this.displayDuration_ = 0;
        this.pattern_ = 0;
        this.iconId_ = 0;
        this.isDefaultChoose_ = 0;
        this.sceneId_ = 0;
        this.baseMapType_ = 0;
        this.displayTimeType_ = 0;
        this.cachedSize = -1;
    }

    public static TransPanel parseFrom(b bVar) throws IOException {
        return new TransPanel().mergeFrom(bVar);
    }

    public final TransPanel clear() {
        clearContent();
        clearSubContent();
        clearDisplayDuration();
        clearPattern();
        clearIconId();
        clearIsDefaultChoose();
        clearSceneId();
        clearBaseMapType();
        clearDisplayTimeType();
        this.cachedSize = -1;
        return this;
    }

    public TransPanel clearBaseMapType() {
        this.hasBaseMapType = false;
        this.baseMapType_ = 0;
        return this;
    }

    public TransPanel clearContent() {
        this.hasContent = false;
        this.content_ = a.f1216c;
        return this;
    }

    public TransPanel clearDisplayDuration() {
        this.hasDisplayDuration = false;
        this.displayDuration_ = 0;
        return this;
    }

    public TransPanel clearDisplayTimeType() {
        this.hasDisplayTimeType = false;
        this.displayTimeType_ = 0;
        return this;
    }

    public TransPanel clearIconId() {
        this.hasIconId = false;
        this.iconId_ = 0;
        return this;
    }

    public TransPanel clearIsDefaultChoose() {
        this.hasIsDefaultChoose = false;
        this.isDefaultChoose_ = 0;
        return this;
    }

    public TransPanel clearPattern() {
        this.hasPattern = false;
        this.pattern_ = 0;
        return this;
    }

    public TransPanel clearSceneId() {
        this.hasSceneId = false;
        this.sceneId_ = 0;
        return this;
    }

    public TransPanel clearSubContent() {
        this.hasSubContent = false;
        this.subContent_ = a.f1216c;
        return this;
    }

    public int getBaseMapType() {
        return this.baseMapType_;
    }

    @Override // L1.f
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public a getContent() {
        return this.content_;
    }

    public int getDisplayDuration() {
        return this.displayDuration_;
    }

    public int getDisplayTimeType() {
        return this.displayTimeType_;
    }

    public int getIconId() {
        return this.iconId_;
    }

    public int getIsDefaultChoose() {
        return this.isDefaultChoose_;
    }

    public int getPattern() {
        return this.pattern_;
    }

    public int getSceneId() {
        return this.sceneId_;
    }

    @Override // L1.f
    public int getSerializedSize() {
        int iB = hasContent() ? d.b(1, getContent()) : 0;
        if (hasSubContent()) {
            iB += d.b(2, getSubContent());
        }
        if (hasDisplayDuration()) {
            iB += d.e(3, getDisplayDuration());
        }
        if (hasPattern()) {
            iB += d.e(4, getPattern());
        }
        if (hasIconId()) {
            iB += d.e(5, getIconId());
        }
        if (hasIsDefaultChoose()) {
            iB += d.e(6, getIsDefaultChoose());
        }
        if (hasSceneId()) {
            iB += d.e(7, getSceneId());
        }
        if (hasBaseMapType()) {
            iB += d.e(8, getBaseMapType());
        }
        if (hasDisplayTimeType()) {
            iB += d.e(9, getDisplayTimeType());
        }
        this.cachedSize = iB;
        return iB;
    }

    public a getSubContent() {
        return this.subContent_;
    }

    public boolean hasBaseMapType() {
        return this.hasBaseMapType;
    }

    public boolean hasContent() {
        return this.hasContent;
    }

    public boolean hasDisplayDuration() {
        return this.hasDisplayDuration;
    }

    public boolean hasDisplayTimeType() {
        return this.hasDisplayTimeType;
    }

    public boolean hasIconId() {
        return this.hasIconId;
    }

    public boolean hasIsDefaultChoose() {
        return this.hasIsDefaultChoose;
    }

    public boolean hasPattern() {
        return this.hasPattern;
    }

    public boolean hasSceneId() {
        return this.hasSceneId;
    }

    public boolean hasSubContent() {
        return this.hasSubContent;
    }

    public final boolean isInitialized() {
        return true;
    }

    public TransPanel setBaseMapType(int i4) {
        this.hasBaseMapType = true;
        this.baseMapType_ = i4;
        return this;
    }

    public TransPanel setContent(a aVar) {
        this.hasContent = true;
        this.content_ = aVar;
        return this;
    }

    public TransPanel setDisplayDuration(int i4) {
        this.hasDisplayDuration = true;
        this.displayDuration_ = i4;
        return this;
    }

    public TransPanel setDisplayTimeType(int i4) {
        this.hasDisplayTimeType = true;
        this.displayTimeType_ = i4;
        return this;
    }

    public TransPanel setIconId(int i4) {
        this.hasIconId = true;
        this.iconId_ = i4;
        return this;
    }

    public TransPanel setIsDefaultChoose(int i4) {
        this.hasIsDefaultChoose = true;
        this.isDefaultChoose_ = i4;
        return this;
    }

    public TransPanel setPattern(int i4) {
        this.hasPattern = true;
        this.pattern_ = i4;
        return this;
    }

    public TransPanel setSceneId(int i4) {
        this.hasSceneId = true;
        this.sceneId_ = i4;
        return this;
    }

    public TransPanel setSubContent(a aVar) {
        this.hasSubContent = true;
        this.subContent_ = aVar;
        return this;
    }

    @Override // L1.f
    public void writeTo(d dVar) throws IOException {
        if (hasContent()) {
            dVar.q(1, getContent());
        }
        if (hasSubContent()) {
            dVar.q(2, getSubContent());
        }
        if (hasDisplayDuration()) {
            dVar.s(3, getDisplayDuration());
        }
        if (hasPattern()) {
            dVar.s(4, getPattern());
        }
        if (hasIconId()) {
            dVar.s(5, getIconId());
        }
        if (hasIsDefaultChoose()) {
            dVar.s(6, getIsDefaultChoose());
        }
        if (hasSceneId()) {
            dVar.s(7, getSceneId());
        }
        if (hasBaseMapType()) {
            dVar.s(8, getBaseMapType());
        }
        if (hasDisplayTimeType()) {
            dVar.s(9, getDisplayTimeType());
        }
    }

    public static TransPanel parseFrom(byte[] bArr) throws e {
        return (TransPanel) new TransPanel().mergeFrom(bArr);
    }

    @Override // L1.f
    public TransPanel mergeFrom(b bVar) throws IOException {
        while (true) {
            int iO = bVar.o();
            if (iO == 0) {
                return this;
            }
            if (iO == 10) {
                setContent(bVar.b());
            } else if (iO == 18) {
                setSubContent(bVar.b());
            } else if (iO == 24) {
                setDisplayDuration(bVar.k());
            } else if (iO == 32) {
                setPattern(bVar.k());
            } else if (iO == 40) {
                setIconId(bVar.k());
            } else if (iO == 48) {
                setIsDefaultChoose(bVar.k());
            } else if (iO == 56) {
                setSceneId(bVar.k());
            } else if (iO == 64) {
                setBaseMapType(bVar.k());
            } else if (iO == 72) {
                setDisplayTimeType(bVar.k());
            } else if (!parseUnknownField(bVar, iO)) {
                return this;
            }
        }
    }
}

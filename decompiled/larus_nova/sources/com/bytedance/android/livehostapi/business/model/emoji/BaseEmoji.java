package com.bytedance.android.livehostapi.business.model.emoji;

import android.graphics.drawable.Drawable;
import com.bytedance.android.livesdkapi.depend.model.live.emoji.IBaseEmoji;
import com.bytedance.android.livesdkapi.depend.model.live.emoji.IEmojiType;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
public class BaseEmoji implements IBaseEmoji {
    private String description;
    private Drawable drawable;
    private int iconId;
    public boolean isLatestUseEmoji;
    public boolean isRecommendEmoji;
    private String localFilePath;
    public int position;
    public float recommendScore;
    private Type type;

    public static final enum Type extends Enum<Type> implements IEmojiType {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type DeleteEmoji = null;
        public static final Type DummyEmoji = null;
        public static final Type SelfEmoji = null;
        public static final Type SmallEmoji = null;

        static {
            Type r100 = new Type("DummyEmoji", 0);
            DummyEmoji = r100;
            Type r101 = new Type("SmallEmoji", 1);
            SmallEmoji = r101;
            Type r102 = new Type("DeleteEmoji", 2);
            DeleteEmoji = r102;
            Type r103 = new Type("SelfEmoji", 3);
            SelfEmoji = r103;
            $VALUES = new Type[]{r100, r101, r102, r103};
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        private Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    public BaseEmoji() {
        this.type = Type.SmallEmoji;
        this.isLatestUseEmoji = false;
        this.position = -1;
        this.recommendScore = 0.0f;
        this.isRecommendEmoji = false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.emoji.IBaseEmoji
    public /* bridge */ /* synthetic */ IEmojiType getType() {
        return getType();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.emoji.IBaseEmoji
    public String getDescription() {
        return this.description;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.emoji.IBaseEmoji
    public Drawable getDrawable() {
        return this.drawable;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.emoji.IBaseEmoji
    public int getIconId() {
        return this.iconId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.emoji.IBaseEmoji
    public String getLocalFilePath() {
        return this.localFilePath;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.emoji.IBaseEmoji
    public int getPosition() {
        return this.position;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.emoji.IBaseEmoji
    public boolean isLatestUseEmoji() {
        return this.isLatestUseEmoji;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.emoji.IBaseEmoji
    public Type getType() {
        return this.type;
    }

    public void setDescription(String r100) {
        this.description = r100;
    }

    public void setIconId(int r100) {
        this.iconId = r100;
    }

    public void setLocalFilePath(String r100) {
        this.localFilePath = r100;
    }

    public void setType(Type r100) {
        this.type = r100;
    }
}

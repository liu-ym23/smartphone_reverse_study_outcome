package com.bytedance.android.livesdkapi.depend.model;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010 \u001a\u00020!H\u0016R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001a\u0010\u001a\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/LocalSubStickerItem;", "", "()V", "configList", "Ljava/util/ArrayList;", "Lcom/bytedance/android/livesdkapi/depend/model/Sticker$ComposerConfig;", "Lkotlin/collections/ArrayList;", "getConfigList", "()Ljava/util/ArrayList;", "setConfigList", "(Ljava/util/ArrayList;)V", "mappingSticker", "Lcom/bytedance/android/livesdkapi/depend/model/Sticker;", "getMappingSticker", "()Lcom/bytedance/android/livesdkapi/depend/model/Sticker;", "setMappingSticker", "(Lcom/bytedance/android/livesdkapi/depend/model/Sticker;)V", "resId", "", "getResId", "()Ljava/lang/String;", "setResId", "(Ljava/lang/String;)V", "tag", "getTag", "setTag", "type", "getType", "setType", "equals", "", "other", "hashCode", "", "Companion", "liveeffect-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LocalSubStickerItem {
    public static final String BEAUTY_TYPE_BEAUTY = "BEAUTY";
    public static final String BEAUTY_TYPE_FILTER = "FILTER";
    public static final String BEAUTY_TYPE_MAKEUP = "MAKEUP";
    public static final Companion Companion = null;
    private ArrayList<Sticker.ComposerConfig> configList;
    private Sticker mappingSticker;
    private String resId;
    private String tag;
    private String type;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/LocalSubStickerItem$Companion;", "", "()V", "BEAUTY_TYPE_BEAUTY", "", "BEAUTY_TYPE_FILTER", "BEAUTY_TYPE_MAKEUP", "liveeffect-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public int hashCode() {
        return this.resId.hashCode();
    }

    public LocalSubStickerItem() {
        this.tag = "";
        this.resId = "";
        this.type = "";
        this.configList = new ArrayList();
    }

    public final ArrayList<Sticker.ComposerConfig> getConfigList() {
        return this.configList;
    }

    public final Sticker getMappingSticker() {
        return this.mappingSticker;
    }

    public final String getResId() {
        return this.resId;
    }

    public final String getTag() {
        return this.tag;
    }

    public final String getType() {
        return this.type;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((true ^ Intrinsics.areEqual(LocalSubStickerItem.class, r101)) == false) goto L13;
        return false;
    L13:
        if (r100 == null) goto L17;
        return Intrinsics.areEqual(this.resId, ((LocalSubStickerItem) r100).resId);
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.depend.model.LocalSubStickerItem");
    L8:
        r101 = null;
        goto L10
    }

    public final void setConfigList(ArrayList<Sticker.ComposerConfig> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.configList = r100;
    }

    public final void setMappingSticker(Sticker r100) {
        this.mappingSticker = r100;
    }

    public final void setResId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.resId = r100;
    }

    public final void setTag(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.tag = r100;
    }

    public final void setType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.type = r100;
    }
}

package com.bytedance.android.ec.window.base.repository.vo;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/ec/window/base/repository/vo/TagListScene;", "", "", "scene", "Ljava/lang/String;", "getScene", "()Ljava/lang/String;", "SHOP_HEADRE_FIRST_LINE_TAG_LIST", "SHOP_HEADER_SECOND_LINE_TAG_LIST", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum TagListScene extends Enum<TagListScene> {
    public static final TagListScene SHOP_HEADER_SECOND_LINE_TAG_LIST = null;
    public static final TagListScene SHOP_HEADRE_FIRST_LINE_TAG_LIST = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TagListScene[] f49457a = null;
    private final String scene;

    static {
        TagListScene r100 = new TagListScene("SHOP_HEADRE_FIRST_LINE_TAG_LIST", 0, "shop_header_first_line_tag_list");
        SHOP_HEADRE_FIRST_LINE_TAG_LIST = r100;
        TagListScene r101 = new TagListScene("SHOP_HEADER_SECOND_LINE_TAG_LIST", 1, "shop_header_second_line_tag_list");
        SHOP_HEADER_SECOND_LINE_TAG_LIST = r101;
        f49457a = new TagListScene[]{r100, r101};
    }

    public static TagListScene valueOf(String r100) {
        return (TagListScene) r27.a.a(TagListScene.class, r100);
    }

    public static TagListScene[] values() {
        return (TagListScene[]) f49457a.clone();
    }

    public final String getScene() {
        return this.scene;
    }

    public TagListScene(String r100, int r101, String r102) {
        super(r100, r101);
        this.scene = r102;
    }
}

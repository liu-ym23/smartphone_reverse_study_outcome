package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000b\bg\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u001d\u001eR\"\u0010\b\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\"\u0010\u000b\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0007\u001a\u0004\b\t\u0010\u0005R\u001a\u0010\u0010\u001a\u00020\f8&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0007\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0013\u001a\u00020\f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0007\u001a\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0018\u001a\u00020\u00148&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0007\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001b\u001a\u00020\f8&X§\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0007\u001a\u0004\b\u0019\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleRivalTag;", "Lvh7/c;", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getBackgroundImage", "()Lpy/k;", "getBackgroundImage$annotations", "()V", "backgroundImage", "getIconImage", "getIconImage$annotations", "iconImage", "", "getContent", "()Ljava/lang/String;", "getContent$annotations", "content", "getFontColor", "getFontColor$annotations", "fontColor", "", "getTagType", "()I", "getTagType$annotations", "tagType", "getTagDesc", "getTagDesc$annotations", "tagDesc", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "TagType", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IBattleRivalTag extends vh7.c<IBattleRivalTag> {
    public static final a Companion = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleRivalTag$TagType;", "", "TypeDefault", "TypeRank", "TypeFollow", "TypeRoomContent", "TypeOftenBattleWithMe", "TypeRelation", "TypePower", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum TagType extends Enum<TagType> {
        public static final TagType TypeDefault = null;
        public static final TagType TypeFollow = null;
        public static final TagType TypeOftenBattleWithMe = null;
        public static final TagType TypePower = null;
        public static final TagType TypeRank = null;
        public static final TagType TypeRelation = null;
        public static final TagType TypeRoomContent = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TagType[] f147033a = null;

        static {
            TagType r100 = new TagType("TypeDefault", 0);
            TypeDefault = r100;
            TagType r101 = new TagType("TypeRank", 1);
            TypeRank = r101;
            TagType r102 = new TagType("TypeFollow", 2);
            TypeFollow = r102;
            TagType r103 = new TagType("TypeRoomContent", 3);
            TypeRoomContent = r103;
            TagType r104 = new TagType("TypeOftenBattleWithMe", 4);
            TypeOftenBattleWithMe = r104;
            TagType r105 = new TagType("TypeRelation", 5);
            TypeRelation = r105;
            TagType r106 = new TagType("TypePower", 6);
            TypePower = r106;
            f147033a = new TagType[]{r100, r101, r102, r103, r104, r105, r106};
        }

        public static TagType valueOf(String r100) {
            return (TagType) r27.a.a(TagType.class, r100);
        }

        public static TagType[] values() {
            return (TagType[]) f147033a.clone();
        }

        public TagType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f147034a = null;

        public a() {
        }

        static {
            f147034a = new a();
        }

        public static void a(List r100, Map r101) {
            Intrinsics.checkNotNullParameter(r100, PromotionProductPrivilegesStruct.TAGS);
            Intrinsics.checkNotNullParameter(r101, "extra");
            int r102 = 2;
            if (r100.size() >= 2) goto L5;
            r102 = r100.size();
        L5:
            int r103 = 0;
        L6:
            if (r103 >= r102) goto L18;
            StringBuilder r104 = new StringBuilder("tag");
            int r105 = r103 + 1;
            r104.append(r105);
            r104.append("_type");
            String r106 = r104.toString();
            IBattleRivalTag r107 = (IBattleRivalTag) ListProtector.get(r100, r103);
            Intrinsics.checkNotNullParameter(r107, "$this$typeString");
            int r108 = r107.getTagType();
            if (r108 != TagType.TypeRank.ordinal()) goto L11;
            String r109 = "list_rank";
        L17:
            r101.put(r106, r109);
            r101.put("tag" + r105 + "_content", ((IBattleRivalTag) ListProtector.get(r100, r103)).getContent().toString());
            r103 = r105;
            goto L6
        L11:
            if (r108 != TagType.TypeFollow.ordinal()) goto L14;
            r109 = "relation";
            goto L17
        L14:
            if (r108 != TagType.TypeRoomContent.ordinal()) goto L16;
            r109 = "room_content";
            goto L17
        L16:
            r109 = "room_attribute";
            goto L17
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = a.f147034a;
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "bg_image")
    py.k getBackgroundImage();

    @FieldName(name = "content")
    String getContent();

    @FieldName(name = "font_color")
    String getFontColor();

    @FieldName(name = "icon_image")
    py.k getIconImage();

    @FieldName(name = "tag_desc")
    String getTagDesc();

    @FieldName(name = com.bytedance.android.ec.core.event.a.KEY_TAG_TYPE)
    int getTagType();
}

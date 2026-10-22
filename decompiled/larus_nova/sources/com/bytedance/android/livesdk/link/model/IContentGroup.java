package com.bytedance.android.livesdk.link.model;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rR\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IContentGroup;", "Lvh7/c;", "", "getSubTitle", "()Ljava/lang/String;", "getSubTitle$annotations", "()V", "subTitle", "Lcom/bytedance/android/livesdk/link/model/IContentGroup$IContent;", "getContent", "()Lcom/bytedance/android/livesdk/link/model/IContentGroup$IContent;", "getContent$annotations", "content", "IContent", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IContentGroup extends vh7.c<IContentGroup> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0013R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\"\u0010\u0012\u001a\n\u0018\u00010\rj\u0004\u0018\u0001`\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IContentGroup$IContent;", "Lvh7/c;", "", "getType", "()I", "getType$annotations", "()V", "type", "", "getText", "()Ljava/lang/String;", "getText$annotations", "text", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getImage", "()Lpy/k;", "getImage$annotations", "image", "ContentType", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface IContent extends vh7.c<IContent> {

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IContentGroup$IContent$ContentType;", "", "", "type", "I", "getType", "()I", "Text", "Image", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
        public static final enum ContentType extends Enum<ContentType> {
            public static final ContentType Image = null;
            public static final ContentType Text = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ ContentType[] f147037a = null;
            private final int type;

            static {
                ContentType r100 = new ContentType("Text", 0, 0);
                Text = r100;
                ContentType r101 = new ContentType("Image", 1, 1);
                Image = r101;
                f147037a = new ContentType[]{r100, r101};
            }

            public static ContentType valueOf(String r100) {
                return (ContentType) r27.a.a(ContentType.class, r100);
            }

            public static ContentType[] values() {
                return (ContentType[]) f147037a.clone();
            }

            public final int getType() {
                return this.type;
            }

            public ContentType(String r100, int r101, int r102) {
                super(r100, r101);
                this.type = r102;
            }
        }

        @JsonAdapter(FlexModelJsonAdapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class a {
        }

        @Override // vh7.c
        /* synthetic */ vh7.e castTo(Class r100);

        @Override // vh7.c
        /* synthetic */ vh7.e castToOrNull(Class r100);

        @FieldName(name = "image")
        py.k getImage();

        @FieldName(name = "text")
        String getText();

        @FieldName(name = "type")
        int getType();
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "content")
    IContent getContent();

    @FieldName(name = BdpAppEventConstant.PARAMS_SUB_TITLE)
    String getSubTitle();
}

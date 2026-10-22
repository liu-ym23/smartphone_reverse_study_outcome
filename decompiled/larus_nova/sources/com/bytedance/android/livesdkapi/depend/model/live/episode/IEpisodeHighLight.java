package com.bytedance.android.livesdkapi.depend.model.live.episode;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import py.k;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\u0010\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0017\u001a\u0004\u0018\u00010\u00118&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0016\u0010\b\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u001b\u001a\u0004\u0018\u00010\u00118&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001a\u0010\b\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\"\u0010\u001f\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001e\u0010\b\u001a\u0004\b\u001c\u0010\u0004\"\u0004\b\u001d\u0010\u0006R\"\u0010&\u001a\u00020 8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b%\u0010\b\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010*\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b)\u0010\b\u001a\u0004\b'\u0010\u0004\"\u0004\b(\u0010\u0006¨\u0006+"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeHighLight;", "Lvh7/c;", "", "getLocation", "()J", "setLocation", "(J)V", "getLocation$annotations", "()V", "location", "", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "getDescription$annotations", "description", "Lpy/k;", "getImage", "()Lpy/k;", "setImage", "(Lpy/k;)V", "getImage$annotations", "image", "getSmallImage", "setSmallImage", "getSmallImage$annotations", "smallImage", "getLocationEnd", "setLocationEnd", "getLocationEnd$annotations", "locationEnd", "", "getHot", "()Z", "setHot", "(Z)V", "getHot$annotations", "hot", "getCollectionId", "setCollectionId", "getCollectionId$annotations", "collectionId", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IEpisodeHighLight extends c<IEpisodeHighLight> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "collection_id")
        public static /* synthetic */ void getCollectionId$annotations() {
        }

        @FieldName(name = "description")
        public static /* synthetic */ void getDescription$annotations() {
        }

        @FieldName(name = "hot")
        public static /* synthetic */ void getHot$annotations() {
        }

        @FieldName(name = "image")
        public static /* synthetic */ void getImage$annotations() {
        }

        @FieldName(name = "location")
        public static /* synthetic */ void getLocation$annotations() {
        }

        @FieldName(name = "location_end")
        public static /* synthetic */ void getLocationEnd$annotations() {
        }

        @FieldName(name = "small_image")
        public static /* synthetic */ void getSmallImage$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "collection_id")
    long getCollectionId();

    @FieldName(name = "description")
    String getDescription();

    @FieldName(name = "hot")
    boolean getHot();

    @FieldName(name = "image")
    k getImage();

    @FieldName(name = "location")
    long getLocation();

    @FieldName(name = "location_end")
    long getLocationEnd();

    @FieldName(name = "small_image")
    k getSmallImage();

    @FieldName(name = "collection_id#setter")
    void setCollectionId(long r100);

    @FieldName(name = "description#setter")
    void setDescription(String r100);

    @FieldName(name = "hot#setter")
    void setHot(boolean r100);

    @FieldName(name = "image#setter")
    void setImage(k r100);

    @FieldName(name = "location#setter")
    void setLocation(long r100);

    @FieldName(name = "location_end#setter")
    void setLocationEnd(long r100);

    @FieldName(name = "small_image#setter")
    void setSmallImage(k r100);
}

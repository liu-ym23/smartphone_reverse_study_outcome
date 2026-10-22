package com.bytedance.android.livesdkapi.depend.model.live.episode;

import am3.g;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import py.k;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0017\u0018\u0000 42\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u00014B\u0007¢\u0006\u0004\b2\u00103R\"\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010\u001f\u001a\u0004\u0018\u00010\u00188\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\"\u0010\"\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\"\u0010\f\u001a\u0004\b#\u0010\u000e\"\u0004\b$\u0010\u0010R\"\u0010&\u001a\u00020%8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010,\u001a\u00020\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b,\u0010\f\u001a\u0004\b-\u0010\u000e\"\u0004\b.\u0010\u0010R$\u0010/\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010\u0013\u001a\u0004\b0\u0010\u0015\"\u0004\b1\u0010\u0017¨\u00065"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/EpisodeHighLight;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IEpisodeHighLight;", "", "type", "I", "getType", "()I", "setType", "(I)V", "", "location", "J", "getLocation", "()J", "setLocation", "(J)V", "", "description", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "Lpy/k;", "image", "Lpy/k;", "getImage", "()Lpy/k;", "setImage", "(Lpy/k;)V", "smallImage", "getSmallImage", "setSmallImage", "locationEnd", "getLocationEnd", "setLocationEnd", "", "hot", "Z", "getHot", "()Z", "setHot", "(Z)V", "collectionId", "getCollectionId", "setCollectionId", "pid", "getPid", "setPid", "<init>", "()V", "Companion", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public class EpisodeHighLight extends FlexModelBase<IEpisodeHighLight> implements IEpisodeHighLight, h {
    public static final Companion Companion = null;
    public static final int TYPE_EPISODE = 1;
    public static final int TYPE_LIVE = 2;

    @SerializedName("collection_id")
    protected long collectionId;

    @SerializedName("description")
    protected String description;

    @SerializedName("hot")
    protected boolean hot;

    @SerializedName("image")
    protected k image;

    @SerializedName("location")
    protected long location;

    @SerializedName("location_end")
    protected long locationEnd;

    @SerializedName("pid")
    protected String pid;

    @SerializedName("small_image")
    protected k smallImage;
    private int type;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/EpisodeHighLight$Companion;", "", "()V", "TYPE_EPISODE", "", "TYPE_LIVE", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    public EpisodeHighLight() {
        super(IEpisodeHighLight.class);
        this.type = 1;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeHighLight
    public long getCollectionId() {
        return this.collectionId;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeHighLight
    public String getDescription() {
        return this.description;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeHighLight
    public boolean getHot() {
        return this.hot;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeHighLight
    public k getImage() {
        return this.image;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeHighLight
    public long getLocation() {
        return this.location;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeHighLight
    public long getLocationEnd() {
        return this.locationEnd;
    }

    public final String getPid() {
        return this.pid;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeHighLight
    public k getSmallImage() {
        return this.smallImage;
    }

    public final int getType() {
        return this.type;
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object, py.k] */
    public EpisodeHighLight(g r100) {
        super(IEpisodeHighLight.class);
        this.type = 1;
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L16;
        g.a r103 = decodeExtensionFields(r102, r100);
        switch(r102) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            default: goto L7;
        };
    L8:
        this.pid = am3.h.c(r100);
        goto L3
    L9:
        this.collectionId = r100.j();
        goto L3
    L10:
        this.hot = am3.h.a(r100);
        goto L3
    L11:
        this.locationEnd = r100.j();
        goto L3
    L12:
        this.smallImage = f.a(r100, k.class);
        goto L3
    L13:
        this.image = f.a(r100, k.class);
        goto L3
    L14:
        this.description = am3.h.c(r100);
        goto L3
    L15:
        this.location = r100.j();
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L16:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeHighLight
    public void setCollectionId(long r100) {
        this.collectionId = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeHighLight
    public void setDescription(String r100) {
        this.description = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeHighLight
    public void setHot(boolean r100) {
        this.hot = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeHighLight
    public void setImage(k r100) {
        this.image = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeHighLight
    public void setLocation(long r100) {
        this.location = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeHighLight
    public void setLocationEnd(long r100) {
        this.locationEnd = r100;
    }

    public final void setPid(String r100) {
        this.pid = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeHighLight
    public void setSmallImage(k r100) {
        this.smallImage = r100;
    }

    public final void setType(int r100) {
        this.type = r100;
    }
}

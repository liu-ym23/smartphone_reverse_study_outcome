package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.livesdkapi.depend.live.player.MaskSrc;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.android.livesdkapi.util.KotlinTypeUtilsKt;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.internal.FlexModelDelegate;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.PrizeNoticeMessage")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00000\u0004B\u0007¢\u0006\u0004\bv\u0010wJ\u0011\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0000H\u0096\u0002J-\u0010\f\u001a\u00028\u0000\"\u000e\b\u0000\u0010\t*\b\u0012\u0004\u0012\u00020\u00030\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016¢\u0006\u0004\b\f\u0010\rJ-\u0010\u000e\u001a\u00028\u0000\"\u000e\b\u0000\u0010\t*\b\u0012\u0004\u0012\u00020\u00030\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0017¢\u0006\u0004\b\u000e\u0010\rR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010*\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00100\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R0\u00107\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)\u0018\u0001068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010=\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b=\u0010\u0016\u001a\u0004\b>\u0010\u0018\"\u0004\b?\u0010\u001aR$\u0010@\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b@\u0010+\u001a\u0004\bA\u0010-\"\u0004\bB\u0010/R$\u0010D\u001a\u0004\u0018\u00010C8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR*\u0010L\u001a\n\u0012\u0004\u0012\u00020K\u0018\u00010J8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\"\u0010S\u001a\u00020R8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bS\u0010U\"\u0004\bV\u0010WR$\u0010Y\u001a\u0004\u0018\u00010X8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R$\u0010`\u001a\u0004\u0018\u00010_8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR$\u0010i\u001a\u00020\u00142\u0006\u0010f\u001a\u00020\u00148V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bg\u0010\u0018\"\u0004\bh\u0010\u001aR\u0016\u0010k\u001a\u0004\u0018\u00010\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bj\u0010\u001fR\u0016\u0010m\u001a\u0004\u0018\u00010\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bl\u0010&R\u0016\u0010o\u001a\u0004\u0018\u00010)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bn\u0010-R\u0014\u0010q\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bp\u00103R \u0010s\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020)068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\br\u0010:R\u0014\u0010u\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bt\u0010\u0018¨\u0006x"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/hi;", "Llm2/a;", "Lvh7/c$a;", "Lcom/bytedance/android/livesdk/message/model/gb;", "", "o", "", "compareTo", "Lvh7/e;", "R", "Ljava/lang/Class;", "aClass", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/FlexModelDelegate;", "delegate", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/FlexModelDelegate;", "getDelegate", "()Lcom/bytedance/tools/kcp/modelx/runtime/internal/FlexModelDelegate;", "", "_assetId", "J", "get_assetId", "()J", "set_assetId", "(J)V", "Lcom/bytedance/android/livesdk/message/model/a8;", "_imageInfo", "Lcom/bytedance/android/livesdk/message/model/a8;", "get_imageInfo", "()Lcom/bytedance/android/livesdk/message/model/a8;", "set_imageInfo", "(Lcom/bytedance/android/livesdk/message/model/a8;)V", "Lcom/bytedance/android/live/base/model/ImageModel;", "_landscapeBgImg", "Lcom/bytedance/android/live/base/model/ImageModel;", "get_landscapeBgImg", "()Lcom/bytedance/android/live/base/model/ImageModel;", "set_landscapeBgImg", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "", "_landscapeContent", "Ljava/lang/String;", "get_landscapeContent", "()Ljava/lang/String;", "set_landscapeContent", "(Ljava/lang/String;)V", "_playPriority", "I", "get_playPriority", "()I", "set_playPriority", "(I)V", "", "_extra", "Ljava/util/Map;", "get_extra", "()Ljava/util/Map;", "set_extra", "(Ljava/util/Map;)V", "_sceneContextId", "get_sceneContextId", "set_sceneContextId", "assetPath", "getAssetPath", "setAssetPath", "Lcom/bytedance/android/livesdk/message/model/gb$b;", "videoCallback", "Lcom/bytedance/android/livesdk/message/model/gb$b;", "getVideoCallback", "()Lcom/bytedance/android/livesdk/message/model/gb$b;", "setVideoCallback", "(Lcom/bytedance/android/livesdk/message/model/gb$b;)V", "", "Lcom/bytedance/android/livesdkapi/depend/live/player/MaskSrc;", "maskSrcList", "Ljava/util/List;", "getMaskSrcList", "()Ljava/util/List;", "setMaskSrcList", "(Ljava/util/List;)V", "", "isTopEffectSamePlayer", "Z", "()Z", "setTopEffectSamePlayer", "(Z)V", "Lcom/bytedance/android/livesdk/message/model/gb$a;", "elementClickListener", "Lcom/bytedance/android/livesdk/message/model/gb$a;", "getElementClickListener", "()Lcom/bytedance/android/livesdk/message/model/gb$a;", "setElementClickListener", "(Lcom/bytedance/android/livesdk/message/model/gb$a;)V", "Lio/reactivex/disposables/CompositeDisposable;", "playDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "getPlayDisposable", "()Lio/reactivex/disposables/CompositeDisposable;", "setPlayDisposable", "(Lio/reactivex/disposables/CompositeDisposable;)V", "value", "getAssetId", "setAssetId", "assetId", "getImageInfo", "imageInfo", "getLandscapeBgImg", "landscapeBgImg", "getLandscapeContent", "landscapeContent", "getPlayPriority", "playPriority", "getExtra", "extra", "getSceneContextId", "sceneContextId", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class hi extends lm2.a implements vh7.c.a<gb>, gb, Comparable<hi>, vh7.h {

    @SerializedName("asset_id")
    protected long _assetId;

    @SerializedName("extra")
    protected Map<String, String> _extra;

    @SerializedName("image_info")
    protected a8 _imageInfo;

    @SerializedName("landscape_bg_img")
    protected ImageModel _landscapeBgImg;

    @SerializedName("landscape_content")
    protected String _landscapeContent;

    @SerializedName("play_priority")
    protected int _playPriority;

    @SerializedName("scene_context_id")
    protected long _sceneContextId;

    @IgnoreProtoFieldCheck
    private String assetPath;
    private final transient FlexModelDelegate<gb> delegate;

    @IgnoreProtoFieldCheck
    private gb.a elementClickListener;

    @IgnoreProtoFieldCheck
    private boolean isTopEffectSamePlayer;

    @IgnoreProtoFieldCheck
    private List<MaskSrc> maskSrcList;
    private CompositeDisposable playDisposable;

    @IgnoreProtoFieldCheck
    private gb.b videoCallback;

    @Override // com.bytedance.android.livesdk.message.model.gb
    public Map<String, String> getExtra() {
        return KotlinTypeUtilsKt.castElementType(this._extra);
    }

    public hi() {
        this.delegate = new FlexModelDelegate(gb.class, this);
        this.isTopEffectSamePlayer = true;
        this.type = MessageType.PRIZE_NOTICE_MESSAGE;
    }

    @Override // com.bytedance.android.livesdk.message.model.gb
    public /* bridge */ /* synthetic */ py.k getLandscapeBgImg() {
        return getLandscapeBgImg();
    }

    @Override // com.bytedance.android.livesdk.message.model.gb
    public long getAssetId() {
        return this._assetId;
    }

    public final String getAssetPath() {
        return this.assetPath;
    }

    @Override // vh7.c.a
    public FlexModelDelegate<gb> getDelegate() {
        return this.delegate;
    }

    @Override // com.bytedance.android.livesdk.message.model.gb
    public gb.a getElementClickListener() {
        return this.elementClickListener;
    }

    @Override // com.bytedance.android.livesdk.message.model.gb
    public a8 getImageInfo() {
        return this._imageInfo;
    }

    @Override // com.bytedance.android.livesdk.message.model.gb
    public String getLandscapeContent() {
        return this._landscapeContent;
    }

    public final List<MaskSrc> getMaskSrcList() {
        return this.maskSrcList;
    }

    @Override // com.bytedance.android.livesdk.message.model.gb
    public CompositeDisposable getPlayDisposable() {
        return this.playDisposable;
    }

    @Override // com.bytedance.android.livesdk.message.model.gb
    public int getPlayPriority() {
        return this._playPriority;
    }

    @Override // com.bytedance.android.livesdk.message.model.gb
    public long getSceneContextId() {
        return this._sceneContextId;
    }

    @Override // com.bytedance.android.livesdk.message.model.gb
    public gb.b getVideoCallback() {
        return this.videoCallback;
    }

    public final long get_assetId() {
        return this._assetId;
    }

    public final Map<String, String> get_extra() {
        return this._extra;
    }

    public final a8 get_imageInfo() {
        return this._imageInfo;
    }

    public final ImageModel get_landscapeBgImg() {
        return this._landscapeBgImg;
    }

    public final String get_landscapeContent() {
        return this._landscapeContent;
    }

    public final int get_playPriority() {
        return this._playPriority;
    }

    public final long get_sceneContextId() {
        return this._sceneContextId;
    }

    @Override // com.bytedance.android.livesdk.message.model.gb
    public boolean isTopEffectSamePlayer() {
        return this.isTopEffectSamePlayer;
    }

    @Override // com.bytedance.android.livesdk.message.model.gb
    public ImageModel getLandscapeBgImg() {
        return this._landscapeBgImg;
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [com.bytedance.android.livesdk.message.model.a8, java.lang.Object] */
    public hi(am3.g r110) {
        this._extra = new HashMap();
        this.delegate = new FlexModelDelegate(gb.class, this);
        this.isTopEffectSamePlayer = true;
        getDelegate().setThreadSafe(false);
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L32;
        am3.g.a r102 = getDelegate().decodeExtensionFields(r101, r110);
        switch(r101) {
            case 1: goto L31;
            case 2: goto L30;
            case 3: goto L29;
            case 4: goto L28;
            case 5: goto L27;
            case 6: goto L26;
            case 7: goto L7;
            case 8: goto L25;
            case 9: goto L8;
            default: goto L7;
        };
    L8:
        long r103 = r110.c();
        String r104 = null;
        String r105 = null;
    L9:
        int r106 = r110.f();
        if (r106 == (-1)) goto L17;
        if (r106 != 1) goto L13;
        r104 = am3.h.c(r110);
        goto L9
    L13:
        if (r106 != 2) goto L14;
        r105 = am3.h.c(r110);
        goto L9
    L14:
        am3.h.e(r110);
        goto L9
    L17:
        r110.d(r103);
        Map<String, String> r107 = this._extra;
        if (r104 == null) goto L24;
        if (r105 == null) goto L22;
        r107.put(r104, r105);
        goto L3
    L22:
        throw new IllegalStateException("Value must not be null");
    L24:
        throw new IllegalStateException("Key must not be null");
    L25:
        this._playPriority = r110.i();
        goto L3
    L26:
        this._sceneContextId = r110.j();
        goto L3
    L27:
        this._landscapeContent = am3.h.c(r110);
        goto L3
    L28:
        this._landscapeBgImg = com.bytedance.android.live.base.model.x.a(r110);
        goto L3
    L29:
        this._imageInfo = vh7.f.a(r110, a8.class);
        goto L3
    L30:
        this._assetId = r110.j();
        goto L3
    L31:
        this.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r110);
        goto L3
    L7:
        am3.h.d(r102, r110);
        goto L3
    L32:
        r110.d(r100);
        getDelegate().setThreadSafe(true);
        this.type = MessageType.PRIZE_NOTICE_MESSAGE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // vh7.c.a, vh7.c
    public <R extends vh7.e<gb>> R castTo(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "aClass");
        return (R) getDelegate().castTo(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // vh7.c.a, vh7.c
    public <R extends vh7.e<gb>> R castToOrNull(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "aClass");
        return (R) getDelegate().castToOrNull(r100);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(hi r100) {
        Intrinsics.checkNotNullParameter(r100, "o");
        if (getPlayPriority() != r100.getPlayPriority()) goto L6;
        return (int) (r100.timestamp - this.timestamp);
    L6:
        return getPlayPriority() - r100.getPlayPriority();
    }

    @Override // com.bytedance.android.livesdk.message.model.gb
    public void setAssetId(long r100) {
        this._assetId = r100;
    }

    public final void setAssetPath(String r100) {
        this.assetPath = r100;
    }

    @Override // com.bytedance.android.livesdk.message.model.gb
    public void setElementClickListener(gb.a r100) {
        this.elementClickListener = r100;
    }

    public final void setMaskSrcList(List<MaskSrc> r100) {
        this.maskSrcList = r100;
    }

    @Override // com.bytedance.android.livesdk.message.model.gb
    public void setPlayDisposable(CompositeDisposable r100) {
        this.playDisposable = r100;
    }

    @Override // com.bytedance.android.livesdk.message.model.gb
    public void setTopEffectSamePlayer(boolean r100) {
        this.isTopEffectSamePlayer = r100;
    }

    @Override // com.bytedance.android.livesdk.message.model.gb
    public void setVideoCallback(gb.b r100) {
        this.videoCallback = r100;
    }

    public final void set_assetId(long r100) {
        this._assetId = r100;
    }

    public final void set_extra(Map<String, String> r100) {
        this._extra = r100;
    }

    public final void set_imageInfo(a8 r100) {
        this._imageInfo = r100;
    }

    public final void set_landscapeBgImg(ImageModel r100) {
        this._landscapeBgImg = r100;
    }

    public final void set_landscapeContent(String r100) {
        this._landscapeContent = r100;
    }

    public final void set_playPriority(int r100) {
        this._playPriority = r100;
    }

    public final void set_sceneContextId(long r100) {
        this._sceneContextId = r100;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(hi r100) {
        return compareTo2(r100);
    }
}

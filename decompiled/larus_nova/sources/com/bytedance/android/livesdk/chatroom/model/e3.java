package com.bytedance.android.livesdk.chatroom.model;

import com.amap.api.col.s.ce;
import com.bytedance.android.livesdkapi.depend.model.live.DecorationFontConfig;
import com.bytedance.android.livesdkapi.depend.model.live.RoomDecoration;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b.\u0010/R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR*\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0005\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR$\u0010\u001f\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0016\u001a\u0004\b \u0010\u0018\"\u0004\b!\u0010\u001aR$\u0010\"\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010(\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010#\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R*\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010\u0005\u001a\u0004\b,\u0010\u0007\"\u0004\b-\u0010\t¨\u00060"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/e3;", "", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/RoomDecoration;", "textDecorationList", "Ljava/util/List;", "h", "()Ljava/util/List;", "setTextDecorationList", "(Ljava/util/List;)V", "imageDecorationList", "f", "setImageDecorationList", "", "isCanEdit", "Z", RXScreenCaptureService.KEY_INDEX, "()Z", ce.f26395j, "(Z)V", "", EventConstant.Key.RETAIN_PROMPT, "Ljava/lang/String;", ce.f26391f, "()Ljava/lang/String;", ce.f26396k, "(Ljava/lang/String;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/DecorationFontConfig;", "fontConfigs", "e", "setFontConfigs", "defaultContent", "b", "setDefaultContent", "defaultDecorationText", "Lcom/bytedance/android/livesdkapi/depend/model/live/RoomDecoration;", "d", "()Lcom/bytedance/android/livesdkapi/depend/model/live/RoomDecoration;", "setDefaultDecorationText", "(Lcom/bytedance/android/livesdkapi/depend/model/live/RoomDecoration;)V", "defaultDecoration", "c", "setDefaultDecoration", "composeStickerList", "getComposeStickerList", "setComposeStickerList", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e3 {

    @SerializedName("decoration_mod")
    private List<RoomDecoration> composeStickerList;

    @SerializedName("default_content")
    private String defaultContent;

    @SerializedName("default_decoration")
    private RoomDecoration defaultDecoration;

    @SerializedName("default_decoration_text")
    private RoomDecoration defaultDecorationText;

    @SerializedName("font_configs")
    private List<DecorationFontConfig> fontConfigs;

    @SerializedName("decoration")
    private List<RoomDecoration> imageDecorationList;

    @SerializedName("canEdit")
    private boolean isCanEdit;

    @SerializedName(EventConstant.Key.RETAIN_PROMPT)
    private String prompt;

    @IgnoreProtoFieldCheck
    @SerializedName("decoration_text")
    private List<RoomDecoration> textDecorationList;

    public e3() {
    }

    public final String b() {
        return this.defaultContent;
    }

    public final RoomDecoration c() {
        return this.defaultDecoration;
    }

    public final RoomDecoration d() {
        return this.defaultDecorationText;
    }

    public final List<DecorationFontConfig> e() {
        return this.fontConfigs;
    }

    public final List<RoomDecoration> f() {
        return this.imageDecorationList;
    }

    public final String g() {
        return this.prompt;
    }

    public final List<RoomDecoration> h() {
        return this.textDecorationList;
    }

    public final boolean i() {
        return this.isCanEdit;
    }

    public final RoomDecoration a(long r100) {
        List<RoomDecoration> r101 = this.imageDecorationList;
        Object r102 = null;
        if (r101 == null) goto L18;
        Iterator<T> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L13;
        Object r104 = r103.next();
        if (((RoomDecoration) r104).getId() != r100) goto L10;
        boolean r105 = true;
    L11:
        if (r105 == false) goto L6;
    L14:
        RoomDecoration r106 = (RoomDecoration) r104;
        if (r106 == null) goto L18;
        return r106;
    L10:
        r105 = false;
        goto L11
    L13:
        r104 = null;
    L18:
        List<RoomDecoration> r107 = this.textDecorationList;
        if (r107 == null) goto L42;
        Iterator<T> r108 = r107.iterator();
    L22:
        if (r108.hasNext() == false) goto L30;
        Object r109 = r108.next();
        if (((RoomDecoration) r109).getId() != r100) goto L26;
        boolean r110 = true;
    L27:
        if (r110 == false) goto L22;
        r102 = r109;
        goto L30
    L26:
        r110 = false;
    L30:
        return (RoomDecoration) r102;
    L42:
        return null;
    }

    public final void j(boolean r100) {
        this.isCanEdit = r100;
    }

    public final void k(String r100) {
        this.prompt = r100;
    }
}

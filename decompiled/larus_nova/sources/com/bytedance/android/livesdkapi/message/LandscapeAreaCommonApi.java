package com.bytedance.android.livesdkapi.message;

import am3.g;
import com.bytedance.android.live.base.model.message.p1;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.api.show.ShowChatResponse.LandscapeAreaCommon")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001$B\u0007¢\u0006\u0004\b\"\u0010#J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\u0006\u0010\u000b\u001a\u00020\u0000R\"\u0010\f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\"\u0010\u0015\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R*\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR*\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0019\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001d¨\u0006%"}, d2 = {"Lcom/bytedance/android/livesdkapi/message/LandscapeAreaCommonApi;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/base/model/message/p1;", "", "isShowHead", "isShowNickName", "isStarMessage", "", "", "getColorList", "getShowFontColor", "toCommon", "_showHead", "Z", "get_showHead", "()Z", "set_showHead", "(Z)V", "_showNickName", "get_showNickName", "set_showNickName", "_showFontColor", "get_showFontColor", "set_showFontColor", "_colorList", "Ljava/util/List;", "get_colorList", "()Ljava/util/List;", "set_colorList", "(Ljava/util/List;)V", "", "commentTypeTag", "getCommentTypeTag", "setCommentTypeTag", "<init>", "()V", "CommentTypeTag", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
@IgnoreProtoFieldCheck
public final class LandscapeAreaCommonApi extends FlexModelBase<p1> implements p1, h {

    @SerializedName("color_value")
    private List<String> _colorList;

    @SerializedName("show_font_color")
    protected boolean _showFontColor;

    @SerializedName("show_head")
    protected boolean _showHead;

    @SerializedName("show_nickname")
    protected boolean _showNickName;

    @SerializedName("comment_type_tags")
    protected List<Integer> commentTypeTag;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdkapi/message/LandscapeAreaCommonApi$CommentTypeTag;", "", "()V", "COMMENT_TYPE_TAG_STAR", "", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class CommentTypeTag {
        public static final int COMMENT_TYPE_TAG_STAR = 1;
        public static final CommentTypeTag INSTANCE = null;

        private CommentTypeTag() {
        }

        static {
            INSTANCE = new CommentTypeTag();
        }
    }

    public LandscapeAreaCommonApi() {
        super(p1.class);
    }

    @Override // com.bytedance.android.live.base.model.message.p1, com.bytedance.android.live.base.model.message.o1
    public boolean isStarMessage() {
        List<Integer> r100 = this.commentTypeTag;
        if (r100 == null) goto L10;
        Intrinsics.checkNotNull(r100);
        Iterator<Integer> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L15;
        if (r101.next().intValue() != 1) goto L6;
        return true;
    L15:
        return false;
    L10:
        return false;
    }

    public final LandscapeAreaCommonApi toCommon() {
        LandscapeAreaCommonApi r100 = new LandscapeAreaCommonApi();
        r100._showHead = this._showHead;
        r100._showNickName = this._showNickName;
        r100._showFontColor = getShowFontColor();
        r100._colorList = getColorList();
        r100.commentTypeTag = this.commentTypeTag;
        return r100;
    }

    @Override // com.bytedance.android.live.base.model.message.p1
    public List<String> getColorList() {
        return this._colorList;
    }

    public final List<Integer> getCommentTypeTag() {
        return this.commentTypeTag;
    }

    @Override // com.bytedance.android.live.base.model.message.p1, com.bytedance.android.live.base.model.message.o1
    public boolean getShowFontColor() {
        return this._showFontColor;
    }

    public final List<String> get_colorList() {
        return this._colorList;
    }

    public final boolean get_showFontColor() {
        return this._showFontColor;
    }

    public final boolean get_showHead() {
        return this._showHead;
    }

    public final boolean get_showNickName() {
        return this._showNickName;
    }

    @Override // com.bytedance.android.live.base.model.message.p1, com.bytedance.android.live.base.model.message.o1
    public boolean isShowHead() {
        return this._showHead;
    }

    @Override // com.bytedance.android.live.base.model.message.p1, com.bytedance.android.live.base.model.message.o1
    public boolean isShowNickName() {
        return this._showNickName;
    }

    public LandscapeAreaCommonApi(g r100) {
        super(p1.class);
        this.commentTypeTag = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._showHead = am3.h.a(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._showNickName = am3.h.a(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._showFontColor = am3.h.a(r100);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.commentTypeTag.add(Integer.valueOf(r100.i()));
        goto L3
    L13:
        am3.h.d(r103, r100);
        goto L3
    L18:
        r100.d(r101);
        setThreadSafe(true);
    }

    public final void setCommentTypeTag(List<Integer> r100) {
        this.commentTypeTag = r100;
    }

    public final void set_colorList(List<String> r100) {
        this._colorList = r100;
    }

    public final void set_showFontColor(boolean r100) {
        this._showFontColor = r100;
    }

    public final void set_showHead(boolean r100) {
        this._showHead = r100;
    }

    public final void set_showNickName(boolean r100) {
        this._showNickName = r100;
    }
}

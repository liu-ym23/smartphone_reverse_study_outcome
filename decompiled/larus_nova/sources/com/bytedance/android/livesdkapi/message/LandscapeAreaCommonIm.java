package com.bytedance.android.livesdkapi.message;

import am3.g;
import com.bytedance.android.live.base.model.message.q1;
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
@ProtoMessage("webcast.im.LandscapeAreaCommon")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001 B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\u0006\u0010\u000b\u001a\u00020\u0000R\"\u0010\f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\rR\u001e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R*\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0017\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdkapi/message/LandscapeAreaCommonIm;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/base/model/message/q1;", "", "isShowHead", "isShowNickName", "isStarMessage", "", "", "getColorList", "getShowFontColor", "toCommon", "showHead", "Z", "getShowHead", "()Z", "setShowHead", "(Z)V", "showNickName", "getShowNickName", "setShowNickName", "showFontColor", "colorList", "Ljava/util/List;", "", "commentTypeTag", "getCommentTypeTag", "()Ljava/util/List;", "setCommentTypeTag", "(Ljava/util/List;)V", "<init>", "()V", "CommentTypeTag", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandscapeAreaCommonIm extends FlexModelBase<q1> implements q1, h {

    @SerializedName("color_value")
    public List<String> colorList;

    @SerializedName("comment_type_tags")
    protected List<Integer> commentTypeTag;

    @SerializedName("show_font_color")
    public boolean showFontColor;

    @SerializedName("show_head")
    protected boolean showHead;

    @SerializedName("show_nickname")
    protected boolean showNickName;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdkapi/message/LandscapeAreaCommonIm$CommentTypeTag;", "", "()V", "COMMENT_TYPE_TAG_STAR", "", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class CommentTypeTag {
        public static final int COMMENT_TYPE_TAG_STAR = 1;
        public static final CommentTypeTag INSTANCE = null;

        private CommentTypeTag() {
        }

        static {
            INSTANCE = new CommentTypeTag();
        }
    }

    public LandscapeAreaCommonIm() {
        super(q1.class);
    }

    @Override // com.bytedance.android.live.base.model.message.q1, com.bytedance.android.live.base.model.message.o1
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

    public final LandscapeAreaCommonIm toCommon() {
        LandscapeAreaCommonIm r100 = new LandscapeAreaCommonIm();
        r100.showHead = this.showHead;
        r100.showNickName = this.showNickName;
        r100.showFontColor = this.showFontColor;
        r100.colorList = this.colorList;
        r100.commentTypeTag = this.commentTypeTag;
        return r100;
    }

    @Override // com.bytedance.android.live.base.model.message.q1
    public List<String> getColorList() {
        return this.colorList;
    }

    public final List<Integer> getCommentTypeTag() {
        return this.commentTypeTag;
    }

    @Override // com.bytedance.android.live.base.model.message.q1, com.bytedance.android.live.base.model.message.o1
    public boolean getShowFontColor() {
        return this.showFontColor;
    }

    public final boolean getShowHead() {
        return this.showHead;
    }

    public final boolean getShowNickName() {
        return this.showNickName;
    }

    @Override // com.bytedance.android.live.base.model.message.q1, com.bytedance.android.live.base.model.message.o1
    public boolean isShowHead() {
        return this.showHead;
    }

    @Override // com.bytedance.android.live.base.model.message.q1, com.bytedance.android.live.base.model.message.o1
    public boolean isShowNickName() {
        return this.showNickName;
    }

    public LandscapeAreaCommonIm(g r100) {
        super(q1.class);
        this.colorList = new ArrayList();
        this.commentTypeTag = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L22;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.showHead = am3.h.a(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.showNickName = am3.h.a(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.showFontColor = am3.h.a(r100);
        goto L3
    L12:
        if (r102 == 4) goto L17;
        if (r102 != 5) goto L15;
        List r104 = this.commentTypeTag;
        Comparable r105 = Integer.valueOf(r100.i());
    L18:
        r104.add(r105);
        goto L3
    L15:
        am3.h.d(r103, r100);
        goto L3
    L17:
        r104 = this.colorList;
        r105 = am3.h.c(r100);
        goto L18
    L22:
        r100.d(r101);
        setThreadSafe(true);
    }

    public final void setCommentTypeTag(List<Integer> r100) {
        this.commentTypeTag = r100;
    }

    public final void setShowHead(boolean r100) {
        this.showHead = r100;
    }

    public final void setShowNickName(boolean r100) {
        this.showNickName = r100;
    }
}

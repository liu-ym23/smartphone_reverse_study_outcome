package com.bytedance.android.livesdkapi.depend.model.live.matchroom;

import am3.g;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/MatchTitle;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/IMatchTitle;", "()V", "roomTitle", "", "getRoomTitle", "()Ljava/lang/String;", "setRoomTitle", "(Ljava/lang/String;)V", "titleIcon", "Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/MatchTitle$TitleIcon;", "getTitleIcon", "()Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/MatchTitle$TitleIcon;", "setTitleIcon", "(Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/MatchTitle$TitleIcon;)V", "TitleIcon", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MatchTitle extends FlexModelBase<IMatchTitle> implements IMatchTitle, h {

    @SerializedName("room_title")
    protected String roomTitle;

    @SerializedName("title_icon")
    protected TitleIcon titleIcon;

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/MatchTitle$TitleIcon;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/ITitleIcon;", "()V", "sizeType", "", "getSizeType", "()I", "setSizeType", "(I)V", "url", "", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "Companion", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class TitleIcon extends FlexModelBase<ITitleIcon> implements ITitleIcon, h {
        public static final Companion Companion = null;
        public static final int LARGE = 3;
        public static final int MEDIUM = 2;
        public static final int SMALL = 1;

        @SerializedName("size_type")
        protected int sizeType;

        @SerializedName("url")
        protected String url;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/matchroom/MatchTitle$TitleIcon$Companion;", "", "()V", "LARGE", "", "MEDIUM", "SMALL", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
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

        public TitleIcon() {
            super(ITitleIcon.class);
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.ITitleIcon
        public int getSizeType() {
            return this.sizeType;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.ITitleIcon
        public String getUrl() {
            return this.url;
        }

        public TitleIcon(g r100) {
            super(ITitleIcon.class);
            setThreadSafe(false);
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L12;
            g.a r103 = decodeExtensionFields(r102, r100);
            if (r102 != 1) goto L8;
            this.url = am3.h.c(r100);
            goto L3
        L8:
            if (r102 != 2) goto L9;
            this.sizeType = r100.i();
            goto L3
        L9:
            am3.h.d(r103, r100);
            goto L3
        L12:
            r100.d(r101);
            setThreadSafe(true);
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.ITitleIcon
        public void setSizeType(int r100) {
            this.sizeType = r100;
        }

        @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.ITitleIcon
        public void setUrl(String r100) {
            this.url = r100;
        }
    }

    public MatchTitle() {
        super(IMatchTitle.class);
    }

    public MatchTitle(g r100) {
        super(IMatchTitle.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.roomTitle = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.titleIcon = new TitleIcon(r100);
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchTitle
    public /* bridge */ /* synthetic */ ITitleIcon getTitleIcon() {
        return getTitleIcon();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchTitle
    public String getRoomTitle() {
        return this.roomTitle;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.matchroom.IMatchTitle
    public TitleIcon getTitleIcon() {
        return this.titleIcon;
    }

    public void setRoomTitle(String r100) {
        this.roomTitle = r100;
    }

    public void setTitleIcon(TitleIcon r100) {
        this.titleIcon = r100;
    }
}

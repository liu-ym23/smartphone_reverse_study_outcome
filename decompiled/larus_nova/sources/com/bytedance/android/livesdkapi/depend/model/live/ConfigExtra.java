package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.game.api.ConfigExtraResponse.Data")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/ConfigExtra;", "", "()V", "extra", "", "gameId", "", "kind", "Ljava/lang/Integer;", "Extra", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ConfigExtra implements h {

    @SerializedName("config_extra")
    public String extra;

    @SerializedName("game_id")
    public int gameId;

    @SerializedName("game_kind")
    public Integer kind;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/ConfigExtra$Extra;", "", "isShow", "", "legalText", "", "(ILjava/lang/String;)V", "()I", "getLegalText", "()Ljava/lang/String;", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Extra {

        @SerializedName("show_legal_text")
        private final int isShow;

        @SerializedName("legal_text")
        private final String legalText;

        public final String getLegalText() {
            return this.legalText;
        }

        public final int isShow() {
            return this.isShow;
        }

        public Extra(int r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "legalText");
            this.isShow = r100;
            this.legalText = r101;
        }

        public /* synthetic */ Extra(int r100, String r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 2) == 0) goto L5;
            r101 = "";
        L5:
            this(r100, r101);
        }
    }

    public ConfigExtra() {
        this.gameId = -1;
    }

    public ConfigExtra(g r100) {
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L14;
        if (r103 != 1) goto L7;
        this.gameId = (int) r100.j();
        r102 = r102 | true;
        goto L3
    L7:
        if (r103 != 2) goto L9;
        this.kind = Integer.valueOf(r100.i());
        goto L3
    L9:
        if (r103 != 3) goto L10;
        this.extra = am3.h.c(r100);
        goto L3
    L10:
        am3.h.e(r100);
        goto L3
    L14:
        r100.d(r101);
        if ((r102 & true) == true) goto L30;
        this.gameId = -1;
        return;
    }
}

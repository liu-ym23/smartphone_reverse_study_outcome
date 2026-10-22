package com.bytedance.android.gamecp.common.model;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\u0001\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010J\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000ej\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/gamecp/common/model/GameBizType;", "", "", "toTrackString", "", "value", "Ljava/lang/Integer;", "getValue", "()Ljava/lang/Integer;", "setValue", "(Ljava/lang/Integer;)V", "type", "I", "getType", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "None", "GAMECP", "STAR", "Enterprise", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GameBizType extends Enum<GameBizType> {
    public static final a Companion = null;
    public static final GameBizType Enterprise = null;
    public static final GameBizType GAMECP = null;
    public static final GameBizType None = null;
    public static final GameBizType STAR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GameBizType[] f56530a = null;
    private final int type;
    private Integer value;

    public static final class a {
        public a() {
        }

        public static GameBizType a(Integer r100) {
            GameBizType[] r101 = GameBizType.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L14;
            GameBizType r104 = r101[r103];
            int r105 = r104.getType();
            if (r100 != null) goto L8;
        L10:
            boolean r106 = false;
        L11:
            if (r106 == true) goto L15;
            r103 = r103 + 1;
        L15:
            if (r104 != null) goto L17;
            r104 = GameBizType.None;
        L17:
            r104.setValue(r100);
            return r104;
        L8:
            if (r105 != r100.intValue()) goto L10;
            r106 = true;
            goto L11
        L14:
            r104 = null;
            goto L15
        }
    }

    static {
        GameBizType r100 = new GameBizType("None", 0, -1);
        None = r100;
        GameBizType r101 = new GameBizType("GAMECP", 1, 0);
        GAMECP = r101;
        GameBizType r102 = new GameBizType("STAR", 2, 1);
        STAR = r102;
        GameBizType r103 = new GameBizType("Enterprise", 3, 2);
        Enterprise = r103;
        f56530a = new GameBizType[]{r100, r101, r102, r103};
        Companion = new a();
    }

    public static GameBizType valueOf(String r100) {
        return (GameBizType) r27.a.a(GameBizType.class, r100);
    }

    public static GameBizType[] values() {
        return (GameBizType[]) f56530a.clone();
    }

    public final String toTrackString() {
        int r100 = b.f56533a[ordinal()];
        if (r100 == 1) goto L16;
        if (r100 != 2) goto L7;
        return "douyingame";
    L7:
        if (r100 != 3) goto L9;
        return ScoreTags.SCORE_TYPE_STAR;
    L9:
        if (r100 != 4) goto L12;
        return "comp";
    L12:
        throw new NoWhenBranchMatchedException();
    L16:
        return String.valueOf(this.value);
    }

    public final int getType() {
        return this.type;
    }

    public final Integer getValue() {
        return this.value;
    }

    public final void setValue(Integer r100) {
        this.value = r100;
    }

    public GameBizType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}

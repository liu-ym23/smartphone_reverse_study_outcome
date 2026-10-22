package com.obric.common.oea.style.scene.alpha.alphaplayer.model;

import com.tmall.wireless.tangram.structure.card.SlideCard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\u0001\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/ScaleType;", "", "", SlideCard.KEY_INDEX, "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "ScaleToFill", "ScaleAspectFitCenter", "ScaleAspectFill", "TopFill", "BottomFill", "LeftFill", "RightFill", "TopFit", "BottomFit", "LeftFit", "RightFit", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final enum ScaleType extends Enum<ScaleType> {
    private static final /* synthetic */ ScaleType[] $VALUES = null;
    public static final ScaleType BottomFill = null;
    public static final ScaleType BottomFit = null;

    @NotNull
    public static final a Companion = null;
    public static final ScaleType LeftFill = null;
    public static final ScaleType LeftFit = null;
    public static final ScaleType RightFill = null;
    public static final ScaleType RightFit = null;
    public static final ScaleType ScaleAspectFill = null;
    public static final ScaleType ScaleAspectFitCenter = null;
    public static final ScaleType ScaleToFill = null;
    public static final ScaleType TopFill = null;
    public static final ScaleType TopFit = null;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        ScaleType r10 = new ScaleType("ScaleToFill", 0, 0);
        ScaleToFill = r10;
        ScaleType r11 = new ScaleType("ScaleAspectFitCenter", 1, 1);
        ScaleAspectFitCenter = r11;
        ScaleType r12 = new ScaleType("ScaleAspectFill", 2, 2);
        ScaleAspectFill = r12;
        ScaleType r13 = new ScaleType("TopFill", 3, 3);
        TopFill = r13;
        ScaleType r14 = new ScaleType("BottomFill", 4, 4);
        BottomFill = r14;
        ScaleType r15 = new ScaleType("LeftFill", 5, 5);
        LeftFill = r15;
        ScaleType r16 = new ScaleType("RightFill", 6, 6);
        RightFill = r16;
        ScaleType r17 = new ScaleType("TopFit", 7, 7);
        TopFit = r17;
        ScaleType r18 = new ScaleType("BottomFit", 8, 8);
        BottomFit = r18;
        ScaleType r19 = new ScaleType("LeftFit", 9, 9);
        LeftFit = r19;
        ScaleType r110 = new ScaleType("RightFit", 10, 10);
        RightFit = r110;
        $VALUES = new ScaleType[]{r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110};
        Companion = new a(null);
    }

    private ScaleType(String r10, int r11, int r12) {
        super(r10, r11);
    }

    public static ScaleType valueOf(String r10) {
        return (ScaleType) Enum.valueOf(ScaleType.class, r10);
    }

    public static ScaleType[] values() {
        return (ScaleType[]) $VALUES.clone();
    }
}

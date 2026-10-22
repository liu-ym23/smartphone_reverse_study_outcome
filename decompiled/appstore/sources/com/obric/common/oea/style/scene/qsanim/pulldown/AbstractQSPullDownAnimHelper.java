package com.obric.common.oea.style.scene.qsanim.pulldown;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractQSPullDownAnimHelper extends com.obric.common.oea.style.scene.qsanim.pulldown.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final wb.a f11851b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f11852c = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/pulldown/AbstractQSPullDownAnimHelper$DragUpAnimPhase;", "", "(Ljava/lang/String;I)V", "NONE", "OPEN", "CLOSE", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum DragUpAnimPhase extends Enum<DragUpAnimPhase> {
        private static final /* synthetic */ DragUpAnimPhase[] $VALUES = null;
        public static final DragUpAnimPhase CLOSE = null;
        public static final DragUpAnimPhase NONE = null;
        public static final DragUpAnimPhase OPEN = null;

        static {
            DragUpAnimPhase r10 = new DragUpAnimPhase("NONE", 0);
            NONE = r10;
            DragUpAnimPhase r11 = new DragUpAnimPhase("OPEN", 1);
            OPEN = r11;
            DragUpAnimPhase r12 = new DragUpAnimPhase("CLOSE", 2);
            CLOSE = r12;
            $VALUES = new DragUpAnimPhase[]{r10, r11, r12};
        }

        private DragUpAnimPhase(String r10, int r11) {
            super(r10, r11);
        }

        public static DragUpAnimPhase valueOf(String r10) {
            return (DragUpAnimPhase) Enum.valueOf(DragUpAnimPhase.class, r10);
        }

        public static DragUpAnimPhase[] values() {
            return (DragUpAnimPhase[]) $VALUES.clone();
        }
    }

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        f11852c = new a(null);
        f11851b = new wb.a();
    }

    public static final /* synthetic */ Map a(AbstractQSPullDownAnimHelper r10) {
        throw null;
    }
}

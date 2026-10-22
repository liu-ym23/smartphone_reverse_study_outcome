package androidx.compose.ui.unit;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0013\u0010\b\u001a\u00020\t*\u00020\nH\u0017¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\r\u001a\u00020\n*\u00020\tH\u0017¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/unit/FontScalingLinear;", "", "fontScale", "", "getFontScale$annotations", "()V", "getFontScale", "()F", "toSp", "Landroidx/compose/ui/unit/TextUnit;", "Landroidx/compose/ui/unit/Dp;", "toSp-0xMU5do", "(F)J", "toDp", "toDp-GaN1DYA", "(J)F", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface FontScalingLinear {

    /* JADX INFO: renamed from: androidx.compose.ui.unit.FontScalingLinear$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        /* JADX INFO: renamed from: $default$toDp-GaN1DYA, reason: not valid java name */
        public static float m7661$default$toDpGaN1DYA(FontScalingLinear r100, long r101) {
            if (TextUnitType.m7770equalsimpl0(TextUnit.m7741getTypeUIouoOA(r101), TextUnitType.Companion.m7775getSpUIouoOA()) == false) goto L7;
            return Dp.m7544constructorimpl(TextUnit.m7742getValueimpl(r101) * r100.getFontScale());
        L7:
            throw new IllegalStateException("Only Sp can convert to Px".toString());
        }

        /* JADX INFO: renamed from: $default$toSp-0xMU5do, reason: not valid java name */
        public static long m7662$default$toSp0xMU5do(FontScalingLinear r100, float r101) {
            return TextUnitKt.getSp(r101 / r100.getFontScale());
        }

        /* JADX INFO: renamed from: access$toDp-GaN1DYA$jd, reason: not valid java name */
        public static /* synthetic */ float m7663access$toDpGaN1DYA$jd(FontScalingLinear r100, long r101) {
            return m7661$default$toDpGaN1DYA(r100, r101);
        }

        /* JADX INFO: renamed from: access$toSp-0xMU5do$jd, reason: not valid java name */
        public static /* synthetic */ long m7664access$toSp0xMU5do$jd(FontScalingLinear r100, float r101) {
            return m7662$default$toSp0xMU5do(r100, r101);
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void getFontScale$annotations() {
        }

        /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m7665toDpGaN1DYA(FontScalingLinear r100, long r101) {
            return CC.m7663access$toDpGaN1DYA$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m7666toSp0xMU5do(FontScalingLinear r100, float r101) {
            return CC.m7664access$toSp0xMU5do$jd(r100, r101);
        }
    }

    float getFontScale();

    /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
    float m7659toDpGaN1DYA(long r100);

    /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
    long m7660toSp0xMU5do(float r100);
}

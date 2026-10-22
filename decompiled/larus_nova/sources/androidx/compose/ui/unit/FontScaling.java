package androidx.compose.ui.unit;

import androidx.compose.ui.unit.fontscaling.FontScaleConverter;
import androidx.compose.ui.unit.fontscaling.FontScaleConverterFactory;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0013\u0010\b\u001a\u00020\t*\u00020\nH\u0017¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\r\u001a\u00020\n*\u00020\tH\u0017¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/unit/FontScaling;", "", "fontScale", "", "getFontScale$annotations", "()V", "getFontScale", "()F", "toSp", "Landroidx/compose/ui/unit/TextUnit;", "Landroidx/compose/ui/unit/Dp;", "toSp-0xMU5do", "(F)J", "toDp", "toDp-GaN1DYA", "(J)F", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface FontScaling {

    /* JADX INFO: renamed from: androidx.compose.ui.unit.FontScaling$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        /* JADX INFO: renamed from: $default$toDp-GaN1DYA, reason: not valid java name */
        public static float m7653$default$toDpGaN1DYA(FontScaling r100, long r101) {
            if (TextUnitType.m7770equalsimpl0(TextUnit.m7741getTypeUIouoOA(r101), TextUnitType.Companion.m7775getSpUIouoOA()) == true) goto L5;
            InlineClassHelperKt.throwIllegalStateException("Only Sp can convert to Px");
        L5:
            FontScaleConverterFactory r102 = FontScaleConverterFactory.INSTANCE;
            if (r102.isNonLinearFontScalingActive(r100.getFontScale()) == false) goto L8;
            FontScaleConverter r103 = r102.forScale(r100.getFontScale());
            if (r103 != null) goto L13;
            return Dp.m7544constructorimpl(TextUnit.m7742getValueimpl(r101) * r100.getFontScale());
        L13:
            return Dp.m7544constructorimpl(r103.convertSpToDp(TextUnit.m7742getValueimpl(r101)));
        L8:
            return Dp.m7544constructorimpl(TextUnit.m7742getValueimpl(r101) * r100.getFontScale());
        }

        /* JADX INFO: renamed from: $default$toSp-0xMU5do, reason: not valid java name */
        public static long m7654$default$toSp0xMU5do(FontScaling r100, float r101) {
            FontScaleConverterFactory r102 = FontScaleConverterFactory.INSTANCE;
            if (r102.isNonLinearFontScalingActive(r100.getFontScale()) == false) goto L5;
            FontScaleConverter r103 = r102.forScale(r100.getFontScale());
            if (r103 == null) goto L9;
            float r104 = r103.convertDpToSp(r101);
        L11:
            return TextUnitKt.getSp(r104);
        L9:
            r104 = r101 / r100.getFontScale();
            goto L11
        L5:
            return TextUnitKt.getSp(r101 / r100.getFontScale());
        }

        /* JADX INFO: renamed from: access$toDp-GaN1DYA$jd, reason: not valid java name */
        public static /* synthetic */ float m7655access$toDpGaN1DYA$jd(FontScaling r100, long r101) {
            return m7653$default$toDpGaN1DYA(r100, r101);
        }

        /* JADX INFO: renamed from: access$toSp-0xMU5do$jd, reason: not valid java name */
        public static /* synthetic */ long m7656access$toSp0xMU5do$jd(FontScaling r100, float r101) {
            return m7654$default$toSp0xMU5do(r100, r101);
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void getFontScale$annotations() {
        }

        /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m7657toDpGaN1DYA(FontScaling r100, long r101) {
            return CC.m7655access$toDpGaN1DYA$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m7658toSp0xMU5do(FontScaling r100, float r101) {
            return CC.m7656access$toSp0xMU5do$jd(r100, r101);
        }
    }

    float getFontScale();

    /* JADX INFO: renamed from: toDp-GaN1DYA */
    float mo366toDpGaN1DYA(long r100);

    /* JADX INFO: renamed from: toSp-0xMU5do */
    long mo373toSp0xMU5do(float r100);
}

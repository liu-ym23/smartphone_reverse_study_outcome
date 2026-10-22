package androidx.compose.material3.internal;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathBuilder;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\bÁ\u0002\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2 = {"Landroidx/compose/material3/internal/Icons;", "", "<init>", "()V", "AutoMirrored", "Filled", "Outlined", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Icons {
    public static final int $stable = 0;
    public static final Icons INSTANCE = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroidx/compose/material3/internal/Icons$AutoMirrored;", "", "<init>", "()V", "Filled", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AutoMirrored {
        public static final int $stable = 0;
        public static final AutoMirrored INSTANCE = null;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0007R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Landroidx/compose/material3/internal/Icons$AutoMirrored$Filled;", "", "<init>", "()V", "KeyboardArrowLeft", "Landroidx/compose/ui/graphics/vector/ImageVector;", "getKeyboardArrowLeft$material3", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "_keyboardArrowLeft", "KeyboardArrowRight", "getKeyboardArrowRight$material3", "_keyboardArrowRight", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Filled {
            public static final int $stable = 0;
            public static final Filled INSTANCE = null;
            private static ImageVector _keyboardArrowLeft;
            private static ImageVector _keyboardArrowRight;

            static {
                INSTANCE = new Filled();
                $stable = 8;
            }

            private Filled() {
            }

            public final ImageVector getKeyboardArrowLeft$material3() {
                ImageVector r100 = _keyboardArrowLeft;
                if (r100 == null) goto L6;
                Intrinsics.checkNotNull(r100);
                return r100;
            L6:
                ImageVector.Builder r101 = new ImageVector.Builder("AutoMirrored.Filled.KeyboardArrowLeft", Dp.m7544constructorimpl(24.0f), Dp.m7544constructorimpl(24.0f), 24.0f, 24.0f, 0, 0, true, 96, null);
                int r110 = VectorKt.getDefaultFillType();
                SolidColor r102 = new SolidColor(Color.Companion.m4853getBlack0d7_KjU(), null);
                int r210 = StrokeCap.Companion.m5206getButtKaPHkGw();
                int r211 = StrokeJoin.Companion.m5216getBevelLxFBmk8();
                PathBuilder r103 = new PathBuilder();
                r103.moveTo(15.41f, 16.59f);
                r103.lineTo(10.83f, 12.0f);
                r103.lineToRelative(4.58f, -4.59f);
                r103.lineTo(14.0f, 6.0f);
                r103.lineToRelative(-6.0f, 6.0f);
                r103.lineToRelative(6.0f, 6.0f);
                r103.lineToRelative(1.41f, -1.41f);
                r103.close();
                ImageVector r104 = ImageVector.Builder.m5567addPathoIyEayM$default(r101, r103.getNodes(), r110, "", r102, 1.0f, null, 1.0f, 1.0f, r210, r211, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
                _keyboardArrowLeft = r104;
                Intrinsics.checkNotNull(r104);
                return r104;
            }

            public final ImageVector getKeyboardArrowRight$material3() {
                ImageVector r100 = _keyboardArrowRight;
                if (r100 == null) goto L6;
                Intrinsics.checkNotNull(r100);
                return r100;
            L6:
                ImageVector.Builder r101 = new ImageVector.Builder("AutoMirrored.Filled.KeyboardArrowRight", Dp.m7544constructorimpl(24.0f), Dp.m7544constructorimpl(24.0f), 24.0f, 24.0f, 0, 0, true, 96, null);
                int r110 = VectorKt.getDefaultFillType();
                SolidColor r102 = new SolidColor(Color.Companion.m4853getBlack0d7_KjU(), null);
                int r210 = StrokeCap.Companion.m5206getButtKaPHkGw();
                int r211 = StrokeJoin.Companion.m5216getBevelLxFBmk8();
                PathBuilder r103 = new PathBuilder();
                r103.moveTo(8.59f, 16.59f);
                r103.lineTo(13.17f, 12.0f);
                r103.lineTo(8.59f, 7.41f);
                r103.lineTo(10.0f, 6.0f);
                r103.lineToRelative(6.0f, 6.0f);
                r103.lineToRelative(-6.0f, 6.0f);
                r103.lineToRelative(-1.41f, -1.41f);
                r103.close();
                ImageVector r104 = ImageVector.Builder.m5567addPathoIyEayM$default(r101, r103.getNodes(), r110, "", r102, 1.0f, null, 1.0f, 1.0f, r210, r211, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
                _keyboardArrowRight = r104;
                Intrinsics.checkNotNull(r104);
                return r104;
            }
        }

        static {
            INSTANCE = new AutoMirrored();
        }

        private AutoMirrored() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0007R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0007R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0007R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/compose/material3/internal/Icons$Filled;", "", "<init>", "()V", "Close", "Landroidx/compose/ui/graphics/vector/ImageVector;", "getClose$material3", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "_close", "Check", "getCheck$material3", "_check", "Edit", "getEdit$material3", "_edit", "DateRange", "getDateRange$material3", "_dateRange", "ArrowDropDown", "getArrowDropDown$material3", "_arrowDropDown", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Filled {
        public static final int $stable = 0;
        public static final Filled INSTANCE = null;
        private static ImageVector _arrowDropDown;
        private static ImageVector _check;
        private static ImageVector _close;
        private static ImageVector _dateRange;
        private static ImageVector _edit;

        static {
            INSTANCE = new Filled();
            $stable = 8;
        }

        private Filled() {
        }

        public final ImageVector getArrowDropDown$material3() {
            ImageVector r100 = _arrowDropDown;
            if (r100 == null) goto L6;
            Intrinsics.checkNotNull(r100);
            return r100;
        L6:
            ImageVector.Builder r101 = new ImageVector.Builder("Filled.ArrowDropDown", Dp.m7544constructorimpl(24.0f), Dp.m7544constructorimpl(24.0f), 24.0f, 24.0f, 0, 0, false, 224, null);
            int r110 = VectorKt.getDefaultFillType();
            SolidColor r102 = new SolidColor(Color.Companion.m4853getBlack0d7_KjU(), null);
            int r210 = StrokeCap.Companion.m5206getButtKaPHkGw();
            int r211 = StrokeJoin.Companion.m5216getBevelLxFBmk8();
            PathBuilder r103 = new PathBuilder();
            r103.moveTo(7.0f, 10.0f);
            r103.lineToRelative(5.0f, 5.0f);
            r103.lineToRelative(5.0f, -5.0f);
            r103.close();
            ImageVector r104 = ImageVector.Builder.m5567addPathoIyEayM$default(r101, r103.getNodes(), r110, "", r102, 1.0f, null, 1.0f, 1.0f, r210, r211, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
            _arrowDropDown = r104;
            Intrinsics.checkNotNull(r104);
            return r104;
        }

        public final ImageVector getCheck$material3() {
            ImageVector r100 = _check;
            if (r100 == null) goto L6;
            Intrinsics.checkNotNull(r100);
            return r100;
        L6:
            ImageVector.Builder r101 = new ImageVector.Builder("Filled.Check", Dp.m7544constructorimpl(24.0f), Dp.m7544constructorimpl(24.0f), 24.0f, 24.0f, 0, 0, false, 224, null);
            int r110 = VectorKt.getDefaultFillType();
            SolidColor r102 = new SolidColor(Color.Companion.m4853getBlack0d7_KjU(), null);
            int r210 = StrokeCap.Companion.m5206getButtKaPHkGw();
            int r211 = StrokeJoin.Companion.m5216getBevelLxFBmk8();
            PathBuilder r103 = new PathBuilder();
            r103.moveTo(9.0f, 16.17f);
            r103.lineTo(4.83f, 12.0f);
            r103.lineToRelative(-1.42f, 1.41f);
            r103.lineTo(9.0f, 19.0f);
            r103.lineTo(21.0f, 7.0f);
            r103.lineToRelative(-1.41f, -1.41f);
            r103.close();
            ImageVector r104 = ImageVector.Builder.m5567addPathoIyEayM$default(r101, r103.getNodes(), r110, "", r102, 1.0f, null, 1.0f, 1.0f, r210, r211, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
            _check = r104;
            Intrinsics.checkNotNull(r104);
            return r104;
        }

        public final ImageVector getClose$material3() {
            ImageVector r100 = _close;
            if (r100 == null) goto L6;
            Intrinsics.checkNotNull(r100);
            return r100;
        L6:
            ImageVector.Builder r101 = new ImageVector.Builder("Filled.Close", Dp.m7544constructorimpl(24.0f), Dp.m7544constructorimpl(24.0f), 24.0f, 24.0f, 0, 0, false, 224, null);
            int r110 = VectorKt.getDefaultFillType();
            SolidColor r102 = new SolidColor(Color.Companion.m4853getBlack0d7_KjU(), null);
            int r210 = StrokeCap.Companion.m5206getButtKaPHkGw();
            int r211 = StrokeJoin.Companion.m5216getBevelLxFBmk8();
            PathBuilder r103 = new PathBuilder();
            r103.moveTo(19.0f, 6.41f);
            r103.lineTo(17.59f, 5.0f);
            r103.lineTo(12.0f, 10.59f);
            r103.lineTo(6.41f, 5.0f);
            r103.lineTo(5.0f, 6.41f);
            r103.lineTo(10.59f, 12.0f);
            r103.lineTo(5.0f, 17.59f);
            r103.lineTo(6.41f, 19.0f);
            r103.lineTo(12.0f, 13.41f);
            r103.lineTo(17.59f, 19.0f);
            r103.lineTo(19.0f, 17.59f);
            r103.lineTo(13.41f, 12.0f);
            r103.close();
            ImageVector r104 = ImageVector.Builder.m5567addPathoIyEayM$default(r101, r103.getNodes(), r110, "", r102, 1.0f, null, 1.0f, 1.0f, r210, r211, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
            _close = r104;
            Intrinsics.checkNotNull(r104);
            return r104;
        }

        public final ImageVector getDateRange$material3() {
            ImageVector r100 = _dateRange;
            if (r100 == null) goto L6;
            Intrinsics.checkNotNull(r100);
            return r100;
        L6:
            ImageVector.Builder r101 = new ImageVector.Builder("Filled.DateRange", Dp.m7544constructorimpl(24.0f), Dp.m7544constructorimpl(24.0f), 24.0f, 24.0f, 0, 0, false, 224, null);
            int r110 = VectorKt.getDefaultFillType();
            SolidColor r102 = new SolidColor(Color.Companion.m4853getBlack0d7_KjU(), null);
            int r210 = StrokeCap.Companion.m5206getButtKaPHkGw();
            int r211 = StrokeJoin.Companion.m5216getBevelLxFBmk8();
            PathBuilder r103 = new PathBuilder();
            r103.moveTo(9.0f, 11.0f);
            r103.lineTo(7.0f, 11.0f);
            r103.verticalLineToRelative(2.0f);
            r103.horizontalLineToRelative(2.0f);
            r103.verticalLineToRelative(-2.0f);
            r103.close();
            r103.moveTo(13.0f, 11.0f);
            r103.horizontalLineToRelative(-2.0f);
            r103.verticalLineToRelative(2.0f);
            r103.horizontalLineToRelative(2.0f);
            r103.verticalLineToRelative(-2.0f);
            r103.close();
            r103.moveTo(17.0f, 11.0f);
            r103.horizontalLineToRelative(-2.0f);
            r103.verticalLineToRelative(2.0f);
            r103.horizontalLineToRelative(2.0f);
            r103.verticalLineToRelative(-2.0f);
            r103.close();
            r103.moveTo(19.0f, 4.0f);
            r103.horizontalLineToRelative(-1.0f);
            r103.lineTo(18.0f, 2.0f);
            r103.horizontalLineToRelative(-2.0f);
            r103.verticalLineToRelative(2.0f);
            r103.lineTo(8.0f, 4.0f);
            r103.lineTo(8.0f, 2.0f);
            r103.lineTo(6.0f, 2.0f);
            r103.verticalLineToRelative(2.0f);
            r103.lineTo(5.0f, 4.0f);
            r103.curveToRelative(-1.11f, 0.0f, -1.99f, 0.9f, -1.99f, 2.0f);
            r103.lineTo(3.0f, 20.0f);
            r103.curveToRelative(0.0f, 1.1f, 0.89f, 2.0f, 2.0f, 2.0f);
            r103.horizontalLineToRelative(14.0f);
            r103.curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f);
            r103.lineTo(21.0f, 6.0f);
            r103.curveToRelative(0.0f, -1.1f, -0.9f, -2.0f, -2.0f, -2.0f);
            r103.close();
            r103.moveTo(19.0f, 20.0f);
            r103.lineTo(5.0f, 20.0f);
            r103.lineTo(5.0f, 9.0f);
            r103.horizontalLineToRelative(14.0f);
            r103.verticalLineToRelative(11.0f);
            r103.close();
            ImageVector r104 = ImageVector.Builder.m5567addPathoIyEayM$default(r101, r103.getNodes(), r110, "", r102, 1.0f, null, 1.0f, 1.0f, r210, r211, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
            _dateRange = r104;
            Intrinsics.checkNotNull(r104);
            return r104;
        }

        public final ImageVector getEdit$material3() {
            ImageVector r100 = _edit;
            if (r100 == null) goto L6;
            Intrinsics.checkNotNull(r100);
            return r100;
        L6:
            ImageVector.Builder r101 = new ImageVector.Builder("Filled.Edit", Dp.m7544constructorimpl(24.0f), Dp.m7544constructorimpl(24.0f), 24.0f, 24.0f, 0, 0, false, 224, null);
            int r110 = VectorKt.getDefaultFillType();
            SolidColor r102 = new SolidColor(Color.Companion.m4853getBlack0d7_KjU(), null);
            int r210 = StrokeCap.Companion.m5206getButtKaPHkGw();
            int r211 = StrokeJoin.Companion.m5216getBevelLxFBmk8();
            PathBuilder r103 = new PathBuilder();
            r103.moveTo(3.0f, 17.25f);
            r103.verticalLineTo(21.0f);
            r103.horizontalLineToRelative(3.75f);
            r103.lineTo(17.81f, 9.94f);
            r103.lineToRelative(-3.75f, -3.75f);
            r103.lineTo(3.0f, 17.25f);
            r103.close();
            r103.moveTo(20.71f, 7.04f);
            r103.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0.0f, -1.41f);
            r103.lineToRelative(-2.34f, -2.34f);
            r103.curveToRelative(-0.39f, -0.39f, -1.02f, -0.39f, -1.41f, 0.0f);
            r103.lineToRelative(-1.83f, 1.83f);
            r103.lineToRelative(3.75f, 3.75f);
            r103.lineToRelative(1.83f, -1.83f);
            r103.close();
            ImageVector r104 = ImageVector.Builder.m5567addPathoIyEayM$default(r101, r103.getNodes(), r110, "", r102, 1.0f, null, 1.0f, 1.0f, r210, r211, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
            _edit = r104;
            Intrinsics.checkNotNull(r104);
            return r104;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\n\u0010\u0007R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Landroidx/compose/material3/internal/Icons$Outlined;", "", "<init>", "()V", "Schedule", "Landroidx/compose/ui/graphics/vector/ImageVector;", "getSchedule", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "_schedule", "Keyboard", "getKeyboard", "_keyboard", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Outlined {
        public static final int $stable = 0;
        public static final Outlined INSTANCE = null;
        private static ImageVector _keyboard;
        private static ImageVector _schedule;

        static {
            INSTANCE = new Outlined();
            $stable = 8;
        }

        private Outlined() {
        }

        public final ImageVector getKeyboard() {
            ImageVector r100 = _keyboard;
            if (r100 == null) goto L6;
            Intrinsics.checkNotNull(r100);
            return r100;
        L6:
            ImageVector.Builder r101 = new ImageVector.Builder("Outlined.Keyboard", Dp.m7544constructorimpl(24.0f), Dp.m7544constructorimpl(24.0f), 24.0f, 24.0f, 0, 0, false, 224, null);
            int r110 = VectorKt.getDefaultFillType();
            SolidColor r102 = new SolidColor(Color.Companion.m4853getBlack0d7_KjU(), null);
            int r210 = StrokeCap.Companion.m5206getButtKaPHkGw();
            int r211 = StrokeJoin.Companion.m5216getBevelLxFBmk8();
            PathBuilder r103 = new PathBuilder();
            r103.moveTo(20.0f, 7.0f);
            r103.verticalLineToRelative(10.0f);
            r103.lineTo(4.0f, 17.0f);
            r103.lineTo(4.0f, 7.0f);
            r103.horizontalLineToRelative(16.0f);
            r103.moveToRelative(0.0f, -2.0f);
            r103.lineTo(4.0f, 5.0f);
            r103.curveToRelative(-1.1f, 0.0f, -1.99f, 0.9f, -1.99f, 2.0f);
            r103.lineTo(2.0f, 17.0f);
            r103.curveToRelative(0.0f, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f);
            r103.horizontalLineToRelative(16.0f);
            r103.curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f);
            r103.lineTo(22.0f, 7.0f);
            r103.curveToRelative(0.0f, -1.1f, -0.9f, -2.0f, -2.0f, -2.0f);
            r103.close();
            r103.moveTo(11.0f, 8.0f);
            r103.horizontalLineToRelative(2.0f);
            r103.verticalLineToRelative(2.0f);
            r103.horizontalLineToRelative(-2.0f);
            r103.close();
            r103.moveTo(11.0f, 11.0f);
            r103.horizontalLineToRelative(2.0f);
            r103.verticalLineToRelative(2.0f);
            r103.horizontalLineToRelative(-2.0f);
            r103.close();
            r103.moveTo(8.0f, 8.0f);
            r103.horizontalLineToRelative(2.0f);
            r103.verticalLineToRelative(2.0f);
            r103.lineTo(8.0f, 10.0f);
            r103.close();
            r103.moveTo(8.0f, 11.0f);
            r103.horizontalLineToRelative(2.0f);
            r103.verticalLineToRelative(2.0f);
            r103.lineTo(8.0f, 13.0f);
            r103.close();
            r103.moveTo(5.0f, 11.0f);
            r103.horizontalLineToRelative(2.0f);
            r103.verticalLineToRelative(2.0f);
            r103.lineTo(5.0f, 13.0f);
            r103.close();
            r103.moveTo(5.0f, 8.0f);
            r103.horizontalLineToRelative(2.0f);
            r103.verticalLineToRelative(2.0f);
            r103.lineTo(5.0f, 10.0f);
            r103.close();
            r103.moveTo(8.0f, 14.0f);
            r103.horizontalLineToRelative(8.0f);
            r103.verticalLineToRelative(2.0f);
            r103.lineTo(8.0f, 16.0f);
            r103.close();
            r103.moveTo(14.0f, 11.0f);
            r103.horizontalLineToRelative(2.0f);
            r103.verticalLineToRelative(2.0f);
            r103.horizontalLineToRelative(-2.0f);
            r103.close();
            r103.moveTo(14.0f, 8.0f);
            r103.horizontalLineToRelative(2.0f);
            r103.verticalLineToRelative(2.0f);
            r103.horizontalLineToRelative(-2.0f);
            r103.close();
            r103.moveTo(17.0f, 11.0f);
            r103.horizontalLineToRelative(2.0f);
            r103.verticalLineToRelative(2.0f);
            r103.horizontalLineToRelative(-2.0f);
            r103.close();
            r103.moveTo(17.0f, 8.0f);
            r103.horizontalLineToRelative(2.0f);
            r103.verticalLineToRelative(2.0f);
            r103.horizontalLineToRelative(-2.0f);
            r103.close();
            ImageVector r104 = ImageVector.Builder.m5567addPathoIyEayM$default(r101, r103.getNodes(), r110, "", r102, 1.0f, null, 1.0f, 1.0f, r210, r211, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
            _keyboard = r104;
            Intrinsics.checkNotNull(r104);
            return r104;
        }

        public final ImageVector getSchedule() {
            ImageVector r100 = _schedule;
            if (r100 == null) goto L6;
            Intrinsics.checkNotNull(r100);
            return r100;
        L6:
            ImageVector.Builder r101 = new ImageVector.Builder("Outlined.Schedule", Dp.m7544constructorimpl(24.0f), Dp.m7544constructorimpl(24.0f), 24.0f, 24.0f, 0, 0, false, 224, null);
            int r110 = VectorKt.getDefaultFillType();
            SolidColor r102 = new SolidColor(Color.Companion.m4853getBlack0d7_KjU(), null);
            int r210 = StrokeCap.Companion.m5206getButtKaPHkGw();
            int r211 = StrokeJoin.Companion.m5216getBevelLxFBmk8();
            PathBuilder r103 = new PathBuilder();
            r103.moveTo(11.99f, 2.0f);
            r103.curveTo(6.47f, 2.0f, 2.0f, 6.48f, 2.0f, 12.0f);
            r103.reflectiveCurveToRelative(4.47f, 10.0f, 9.99f, 10.0f);
            r103.curveTo(17.52f, 22.0f, 22.0f, 17.52f, 22.0f, 12.0f);
            r103.reflectiveCurveTo(17.52f, 2.0f, 11.99f, 2.0f);
            r103.close();
            r103.moveTo(12.0f, 20.0f);
            r103.curveToRelative(-4.42f, 0.0f, -8.0f, -3.58f, -8.0f, -8.0f);
            r103.reflectiveCurveToRelative(3.58f, -8.0f, 8.0f, -8.0f);
            r103.reflectiveCurveToRelative(8.0f, 3.58f, 8.0f, 8.0f);
            r103.reflectiveCurveToRelative(-3.58f, 8.0f, -8.0f, 8.0f);
            r103.close();
            r103.moveTo(12.5f, 7.0f);
            r103.lineTo(11.0f, 7.0f);
            r103.verticalLineToRelative(6.0f);
            r103.lineToRelative(5.25f, 3.15f);
            r103.lineToRelative(0.75f, -1.23f);
            r103.lineToRelative(-4.5f, -2.67f);
            r103.close();
            ImageVector r104 = ImageVector.Builder.m5567addPathoIyEayM$default(r101, r103.getNodes(), r110, "", r102, 1.0f, null, 1.0f, 1.0f, r210, r211, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
            _schedule = r104;
            Intrinsics.checkNotNull(r104);
            return r104;
        }
    }

    static {
        INSTANCE = new Icons();
    }

    private Icons() {
    }
}

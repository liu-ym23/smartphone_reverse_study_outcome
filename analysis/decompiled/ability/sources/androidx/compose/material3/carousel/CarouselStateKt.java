package androidx.compose.material3.carousel;

import S7.a;
import androidx.compose.material3.ExperimentalMaterial3Api;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0001\u001a\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"", "initialItem", "Lkotlin/Function0;", "itemCount", "Landroidx/compose/material3/carousel/CarouselState;", "rememberCarouselState", "(ILS7/a;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/carousel/CarouselState;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CarouselStateKt {
    @Composable
    @ExperimentalMaterial3Api
    public static final CarouselState rememberCarouselState(final int i, final a aVar, Composer composer, int i6, int i10) {
        boolean z10 = true;
        if ((i10 & 1) != 0) {
            i = 0;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-217285684, i6, -1, "androidx.compose.material3.carousel.rememberCarouselState (CarouselState.kt:102)");
        }
        Object[] objArr = new Object[0];
        Saver<CarouselState, ?> saver = CarouselState.INSTANCE.getSaver();
        boolean z11 = (((i6 & 14) ^ 6) > 4 && composer.changed(i)) || (i6 & 6) == 4;
        if ((((i6 & 112) ^ 48) <= 32 || !composer.changed(aVar)) && (i6 & 48) != 32) {
            z10 = false;
        }
        boolean z12 = z11 | z10;
        Object objRememberedValue = composer.rememberedValue();
        if (z12 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new a() { // from class: androidx.compose.material3.carousel.CarouselStateKt$rememberCarouselState$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // S7.a
                public final CarouselState invoke() {
                    return new CarouselState(i, 0.0f, aVar);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        CarouselState carouselState = (CarouselState) RememberSaveableKt.m3591rememberSaveable(objArr, (Saver) saver, (String) null, (a) objRememberedValue, composer, 0, 4);
        carouselState.getItemCountState().setValue(aVar);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return carouselState;
    }
}

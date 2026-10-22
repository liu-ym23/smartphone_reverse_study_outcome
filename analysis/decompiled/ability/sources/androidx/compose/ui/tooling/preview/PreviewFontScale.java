package androidx.compose.ui.tooling.preview;

import androidx.compose.material3.carousel.CarouselDefaults;
import androidx.compose.ui.tooling.preview.Preview;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;

@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/compose/ui/tooling/preview/PreviewFontScale;", "", "ui-tooling-preview"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Preview.Container({@Preview(fontScale = CarouselDefaults.MediumLargeItemDiffThreshold, name = "85%"), @Preview(fontScale = 1.0f, name = "100%"), @Preview(fontScale = 1.15f, name = "115%"), @Preview(fontScale = 1.3f, name = "130%"), @Preview(fontScale = 1.5f, name = "150%"), @Preview(fontScale = 1.8f, name = "180%"), @Preview(fontScale = 2.0f, name = "200%")})
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes2.dex */
public @interface PreviewFontScale {
}

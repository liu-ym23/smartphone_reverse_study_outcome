package androidx.compose.ui.tooling.preview;

import androidx.compose.ui.tooling.preview.Preview;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;

@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/compose/ui/tooling/preview/PreviewLightDark;", "", "ui-tooling-preview"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Preview.Container({@Preview(name = "Light"), @Preview(name = "Dark", uiMode = 33)})
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes2.dex */
public @interface PreviewLightDark {
}

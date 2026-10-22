package butterknife;

import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import butterknife.internal.ListenerClass;
import butterknife.internal.ListenerMethod;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes28.dex */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ListenerClass(method = {@ListenerMethod(defaultReturn = "true", name = "onLongClick", parameters = {AndroidComposeViewAccessibilityDelegateCompat.ClassName}, returnType = "boolean")}, setter = "setOnLongClickListener", targetType = AndroidComposeViewAccessibilityDelegateCompat.ClassName, type = "android.view.View.OnLongClickListener")
public @interface OnLongClick {
    int[] value() default {-1};
}

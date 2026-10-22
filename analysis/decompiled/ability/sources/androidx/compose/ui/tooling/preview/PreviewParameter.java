package androidx.compose.ui.tooling.preview;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0002\u0018\u00002\u00020\u0001B%\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u001d\u0010\u0004\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00030\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0004\u0010\tR\u0011\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\u0006\u001a\u0004\b\u0006\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/tooling/preview/PreviewParameter;", "", "LZ7/d;", "Landroidx/compose/ui/tooling/preview/PreviewParameterProvider;", "provider", "", "limit", AppAgent.CONSTRUCT, "(LZ7/d;I)V", "()Ljava/lang/Class;", "()I", "ui-tooling-preview"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public @interface PreviewParameter {
    int limit() default Integer.MAX_VALUE;

    Class<? extends PreviewParameterProvider<?>> provider();
}

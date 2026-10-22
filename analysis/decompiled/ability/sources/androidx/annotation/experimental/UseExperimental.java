package androidx.annotation.experimental;

import C7.c;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE})
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0002\u0018\u00002\u00020\u0001B+\u0012\"\u0010\u0004\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00030\u0002\"\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006R!\u0010\u0004\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00030\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/annotation/experimental/UseExperimental;", "", "", "LZ7/d;", "markerClass", AppAgent.CONSTRUCT, "(Lkotlin/Array;)V", "()[Ljava/lang/Class;", "annotation-experimental_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@c
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes.dex */
public @interface UseExperimental {
    Class<? extends Annotation>[] markerClass();
}

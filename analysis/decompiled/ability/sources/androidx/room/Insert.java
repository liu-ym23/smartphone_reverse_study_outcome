package androidx.room;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0087\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\f\b\u0002\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0015\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\bR\u0011\u0010\u0005\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0005\u0010\t¨\u0006\n"}, d2 = {"Landroidx/room/Insert;", "", "LZ7/d;", "entity", "", "onConflict", AppAgent.CONSTRUCT, "(LZ7/d;I)V", "()Ljava/lang/Class;", "()I", "room-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public @interface Insert {
    Class<?> entity() default Object.class;

    @OnConflictStrategy
    int onConflict() default 3;
}

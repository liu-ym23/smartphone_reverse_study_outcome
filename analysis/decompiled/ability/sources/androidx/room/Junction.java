package androidx.room;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;

@Target({})
@Retention(RetentionPolicy.CLASS)
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0087\u0002\u0018\u00002\u00020\u0001B'\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0015\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\tR\u0011\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\u0006\u001a\u0004\b\u0005\u0010\nR\u0011\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\u0006\u001a\u0004\b\u0006\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/room/Junction;", "", "LZ7/d;", "value", "", "parentColumn", "entityColumn", AppAgent.CONSTRUCT, "(LZ7/d;Ljava/lang/String;Ljava/lang/String;)V", "()Ljava/lang/Class;", "()Ljava/lang/String;", "room-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public @interface Junction {
    String entityColumn() default "";

    String parentColumn() default "";

    Class<?> value();
}

package androidx.room;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/room/RawQuery;", "", "", "LZ7/d;", "observedEntities", AppAgent.CONSTRUCT, "(Lkotlin/Array;)V", "()[Ljava/lang/Class;", "room-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public @interface RawQuery {
    Class<?>[] observedEntities() default {};
}

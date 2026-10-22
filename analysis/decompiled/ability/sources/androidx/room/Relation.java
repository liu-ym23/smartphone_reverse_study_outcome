package androidx.room;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\b\b\u0087\u0002\u0018\u00002\u00020\u0001B?\u0012\f\b\u0002\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t¢\u0006\u0004\b\u000b\u0010\fR\u0015\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\rR\u0011\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u000eR\u0011\u0010\b\u001a\u00020\u00078\u0006¢\u0006\u0006\u001a\u0004\b\b\u0010\u000fR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t8\u0006¢\u0006\u0006\u001a\u0004\b\n\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/room/Relation;", "", "LZ7/d;", "entity", "", "parentColumn", "entityColumn", "Landroidx/room/Junction;", "associateBy", "", "projection", AppAgent.CONSTRUCT, "(LZ7/d;Ljava/lang/String;Ljava/lang/String;Landroidx/room/Junction;Lkotlin/Array;)V", "()Ljava/lang/Class;", "()Ljava/lang/String;", "()Landroidx/room/Junction;", "()[Ljava/lang/String;", "room-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public @interface Relation {
    Junction associateBy() default @Junction(Object.class);

    Class<?> entity() default Object.class;

    String entityColumn();

    String parentColumn();

    String[] projection() default {};
}

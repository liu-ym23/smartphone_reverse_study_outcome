package a7;

import com.stepos.datacenter.entity.FieldPriority;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;

/* JADX WARN: Method from annotation default annotation not found: mediaType */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\u0002\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\fR\u0011\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0004\u0010\fR\u0011\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0005\u0010\fR\u0011\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\u0006\u001a\u0004\b\u0007\u0010\r¨\u0006\u000e"}, d2 = {"La7/a;", "", "", "fts", "vector", "filter", "Lcom/stepos/datacenter/entity/FieldPriority;", "priority", "Lcom/stepos/datacenter/entity/MediaType;", "mediaType", "<init>", "(ZZZLcom/stepos/datacenter/entity/FieldPriority;Lcom/stepos/datacenter/entity/MediaType;)V", "()Z", "()Lcom/stepos/datacenter/entity/FieldPriority;", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: a7.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public @interface InterfaceC1237a {
    boolean filter() default false;

    boolean fts() default true;

    FieldPriority priority() default FieldPriority.NORMAL;

    boolean vector() default true;
}

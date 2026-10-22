package androidx.room;

import androidx.annotation.RequiresApi;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

@Target({ElementType.TYPE})
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0002\u0018\u00002\u00020\u0001Bg\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005\u0012\f\b\u0002\u0010\t\u001a\u0006\u0012\u0002\b\u00030\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058\u0006¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0015\u0010\t\u001a\u0006\u0012\u0002\b\u00030\b8\u0006¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0004R\u0011\u0010\r\u001a\u00020\f8\u0006¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058\u0006¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0011\u001a\u00020\u00108\u0006¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Landroidx/room/Fts4;", "", "", "tokenizer", "()Ljava/lang/String;", "", "tokenizerArgs", "()[Ljava/lang/String;", "Lkotlin/reflect/KClass;", "contentEntity", "()Ljava/lang/Class;", "languageId", "Landroidx/room/m;", "matchInfo", "()Landroidx/room/m;", "notIndexed", "", "prefix", "()[I", "Landroidx/room/n;", "order", "()Landroidx/room/n;", "<init>", "(Ljava/lang/String;Lkotlin/Array;Lkotlin/reflect/KClass;Ljava/lang/String;Landroidx/room/m;Lkotlin/Array;[ILandroidx/room/n;)V", "room-common"}, k = 1, mv = {1, 8, 0})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS})
@RequiresApi(16)
@Retention(RetentionPolicy.CLASS)
@kotlin.annotation.Retention(AnnotationRetention.BINARY)
/* loaded from: classes.dex */
public @interface Fts4 {
    Class<?> contentEntity() default Object.class;

    String languageId() default "";

    m matchInfo() default m.f4220a;

    String[] notIndexed() default {};

    n order() default n.f4222a;

    int[] prefix() default {};

    String tokenizer() default "simple";

    String[] tokenizerArgs() default {};
}

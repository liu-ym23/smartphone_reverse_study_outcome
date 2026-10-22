package kotlin.reflect.full;

import androidx.exifinterface.media.ExifInterface;
import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KAnnotatedElement;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: KAnnotatedElements.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\b\u0002\n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a \u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0003H\u0087\b¢\u0006\u0002\u0010\u0004\u001a\u001f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0006\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0003H\u0087\b\u001a*\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00010\bH\u0007\u001a\u0019\u0010\t\u001a\u00020\n\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0003H\u0087\b¨\u0006\u000b"}, d2 = {"findAnnotation", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlin/reflect/KAnnotatedElement;", "(Lkotlin/reflect/KAnnotatedElement;)Ljava/lang/annotation/Annotation;", "findAnnotations", "", "klass", "Lkotlin/reflect/KClass;", "hasAnnotation", "", "kotlin-reflection"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class KAnnotatedElements {
    public static final /* synthetic */ <T extends Annotation> T findAnnotation(KAnnotatedElement r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Iterator<T> r5 = r4.getAnnotations().iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        Object r0 = r5.next();
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        if ((((Annotation) r0) instanceof Annotation) == false) goto L4;
    L9:
        Intrinsics.reifiedOperationMarker(1, "T?");
        return (T) r0;
    L8:
        r0 = null;
        goto L9
    }

    public static final /* synthetic */ <T extends Annotation> List<T> findAnnotations(KAnnotatedElement r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return findAnnotations(r2, Reflection.getOrCreateKotlinClass(Annotation.class));
    }

    public static final <T extends Annotation> List<T> findAnnotations(KAnnotatedElement r3, KClass<T> r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "klass");
        List<T> r0 = CollectionsKt.filterIsInstance(r3.getAnnotations(), JvmClassMappingKt.getJavaClass(r4));
        if ((!r0.isEmpty()) == false) goto L5;
        return r0;
    L5:
        Class<? extends Annotation> r5 = Java8RepeatableContainerLoader.INSTANCE.loadRepeatableContainer(JvmClassMappingKt.getJavaClass(r4));
        if (r5 == null) goto L19;
        Iterator<T> r6 = r3.getAnnotations().iterator();
    L9:
        if (r6.hasNext() == false) goto L13;
        Object r1 = r6.next();
        if (Intrinsics.areEqual(JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass((Annotation) r1)), r5) == false) goto L9;
    L14:
        Annotation r2 = (Annotation) r1;
        if (r2 == null) goto L19;
        Object r7 = r2.getClass().getMethod("value", new Class[0]).invoke(r2, new Object[0]);
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type kotlin.Array<T of kotlin.reflect.full.KAnnotatedElements.findAnnotations>");
        return ArraysKt.asList((Annotation[]) r7);
    L13:
        r1 = null;
    L19:
        return CollectionsKt.emptyList();
    }

    public static final /* synthetic */ <T extends Annotation> boolean hasAnnotation(KAnnotatedElement r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Iterator<T> r5 = r4.getAnnotations().iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        Object r0 = r5.next();
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        if ((((Annotation) r0) instanceof Annotation) == false) goto L4;
    L9:
        Intrinsics.reifiedOperationMarker(1, "T?");
        if (((Annotation) r0) != null) goto L17;
        return false;
    L17:
        return true;
    L8:
        r0 = null;
        goto L9
    }
}

package kotlin.reflect.jvm.internal.impl.load.kotlin;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
final class AbstractBinaryClassAnnotationLoader$PropertyRelatedElement {

    /* renamed from: a, reason: collision with root package name */
    public static final AbstractBinaryClassAnnotationLoader$PropertyRelatedElement f5007a;
    public static final AbstractBinaryClassAnnotationLoader$PropertyRelatedElement b;
    public static final AbstractBinaryClassAnnotationLoader$PropertyRelatedElement c;
    public static final /* synthetic */ AbstractBinaryClassAnnotationLoader$PropertyRelatedElement[] d;

    static {
        AbstractBinaryClassAnnotationLoader$PropertyRelatedElement abstractBinaryClassAnnotationLoader$PropertyRelatedElement = new AbstractBinaryClassAnnotationLoader$PropertyRelatedElement("PROPERTY", 0);
        f5007a = abstractBinaryClassAnnotationLoader$PropertyRelatedElement;
        AbstractBinaryClassAnnotationLoader$PropertyRelatedElement abstractBinaryClassAnnotationLoader$PropertyRelatedElement2 = new AbstractBinaryClassAnnotationLoader$PropertyRelatedElement("BACKING_FIELD", 1);
        b = abstractBinaryClassAnnotationLoader$PropertyRelatedElement2;
        AbstractBinaryClassAnnotationLoader$PropertyRelatedElement abstractBinaryClassAnnotationLoader$PropertyRelatedElement3 = new AbstractBinaryClassAnnotationLoader$PropertyRelatedElement("DELEGATE_FIELD", 2);
        c = abstractBinaryClassAnnotationLoader$PropertyRelatedElement3;
        AbstractBinaryClassAnnotationLoader$PropertyRelatedElement[] abstractBinaryClassAnnotationLoader$PropertyRelatedElementArr = {abstractBinaryClassAnnotationLoader$PropertyRelatedElement, abstractBinaryClassAnnotationLoader$PropertyRelatedElement2, abstractBinaryClassAnnotationLoader$PropertyRelatedElement3};
        d = abstractBinaryClassAnnotationLoader$PropertyRelatedElementArr;
        kotlin.enums.a.a(abstractBinaryClassAnnotationLoader$PropertyRelatedElementArr);
    }

    public static AbstractBinaryClassAnnotationLoader$PropertyRelatedElement valueOf(String str) {
        return (AbstractBinaryClassAnnotationLoader$PropertyRelatedElement) Enum.valueOf(AbstractBinaryClassAnnotationLoader$PropertyRelatedElement.class, str);
    }

    public static AbstractBinaryClassAnnotationLoader$PropertyRelatedElement[] values() {
        return (AbstractBinaryClassAnnotationLoader$PropertyRelatedElement[]) d.clone();
    }
}

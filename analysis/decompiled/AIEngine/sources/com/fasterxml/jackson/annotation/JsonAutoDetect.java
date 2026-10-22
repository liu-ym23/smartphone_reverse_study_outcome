package com.fasterxml.jackson.annotation;

import com.stepos.core.download.ModelFlowMeta;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface JsonAutoDetect {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Visibility {

        /* renamed from: a, reason: collision with root package name */
        public static final Visibility f3424a;

        /* renamed from: b, reason: collision with root package name */
        public static final Visibility f3425b;

        /* renamed from: c, reason: collision with root package name */
        public static final Visibility f3426c;

        /* renamed from: d, reason: collision with root package name */
        public static final Visibility f3427d;

        /* renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ Visibility[] f3428e;

        static {
            Visibility visibility = new Visibility("ANY", 0);
            f3424a = visibility;
            Visibility visibility2 = new Visibility("NON_PRIVATE", 1);
            Visibility visibility3 = new Visibility("PROTECTED_AND_PUBLIC", 2);
            Visibility visibility4 = new Visibility("PUBLIC_ONLY", 3);
            f3425b = visibility4;
            Visibility visibility5 = new Visibility(ModelFlowMeta.PLAN_NONE, 4);
            f3426c = visibility5;
            Visibility visibility6 = new Visibility("DEFAULT", 5);
            f3427d = visibility6;
            f3428e = new Visibility[]{visibility, visibility2, visibility3, visibility4, visibility5, visibility6};
        }

        public Visibility() {
            throw null;
        }

        public static Visibility valueOf(String str) {
            return (Visibility) Enum.valueOf(Visibility.class, str);
        }

        public static Visibility[] values() {
            return (Visibility[]) f3428e.clone();
        }

        public final boolean a(Member member) {
            int iOrdinal = ordinal();
            if (iOrdinal == 0) {
                return true;
            }
            if (iOrdinal == 1) {
                return !Modifier.isPrivate(member.getModifiers());
            }
            if (iOrdinal != 2) {
                if (iOrdinal != 3) {
                    return false;
                }
            } else if (Modifier.isProtected(member.getModifiers())) {
                return true;
            }
            return Modifier.isPublic(member.getModifiers());
        }
    }

    Visibility creatorVisibility() default Visibility.f3427d;

    Visibility fieldVisibility() default Visibility.f3427d;

    Visibility getterVisibility() default Visibility.f3427d;

    Visibility isGetterVisibility() default Visibility.f3427d;

    Visibility setterVisibility() default Visibility.f3427d;
}

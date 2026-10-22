package kotlinx.serialization.json;

import com.stepos.core.download.ModelFlowMeta;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ClassDiscriminatorMode {

    /* renamed from: a, reason: collision with root package name */
    public static final ClassDiscriminatorMode f10122a;

    /* renamed from: b, reason: collision with root package name */
    public static final ClassDiscriminatorMode f10123b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ ClassDiscriminatorMode[] f10124c;

    static {
        ClassDiscriminatorMode classDiscriminatorMode = new ClassDiscriminatorMode(ModelFlowMeta.PLAN_NONE, 0);
        f10122a = classDiscriminatorMode;
        ClassDiscriminatorMode classDiscriminatorMode2 = new ClassDiscriminatorMode("ALL_JSON_OBJECTS", 1);
        ClassDiscriminatorMode classDiscriminatorMode3 = new ClassDiscriminatorMode("POLYMORPHIC", 2);
        f10123b = classDiscriminatorMode3;
        ClassDiscriminatorMode[] classDiscriminatorModeArr = {classDiscriminatorMode, classDiscriminatorMode2, classDiscriminatorMode3};
        f10124c = classDiscriminatorModeArr;
        a.a(classDiscriminatorModeArr);
    }

    public ClassDiscriminatorMode() {
        throw null;
    }

    public static ClassDiscriminatorMode valueOf(String str) {
        return (ClassDiscriminatorMode) Enum.valueOf(ClassDiscriminatorMode.class, str);
    }

    public static ClassDiscriminatorMode[] values() {
        return (ClassDiscriminatorMode[]) f10124c.clone();
    }
}
